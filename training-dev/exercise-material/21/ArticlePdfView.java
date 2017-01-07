package com.coremedia.coredining.view;

import java.awt.Color;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.coremedia.coredining.contentbeans.Article;
import com.coremedia.coredining.contentbeans.Image;
import com.coremedia.objectserver.view.ServletView;
import com.coremedia.xml.Markup;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class ArticlePdfView implements ServletView<Article> {

  private static Font TITLE_FONT = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
  private static Font SUBTITLE_FONT = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.DARK_GRAY);
  private static Font TEXT_FONT = FontFactory.getFont(FontFactory.HELVETICA, 12);

  public void render(Article article, String view, HttpServletRequest request, HttpServletResponse response) {

    Document document = new Document();

    try {
      response.setContentType("application/pdf");

      PdfWriter pdfWriter = PdfWriter.getInstance(document, response.getOutputStream());
      pdfWriter.setPdfVersion(PdfWriter.VERSION_1_6);

      document.addTitle(article.getTitle());

      document.open();

      Paragraph paragraph = new Paragraph(article.getTitle(), TITLE_FONT);
      document.add(paragraph);

      if (!article.getImage().isEmpty()) {
      Image image = (Image) article.getImage().get(0);
      com.lowagie.text.Image pdfImage
          = com.lowagie.text.Image.getInstance(image.getData().asBytes());
      pdfImage.setAlignment(com.lowagie.text.Image.ALIGN_RIGHT
        | com.lowagie.text.Image.TEXTWRAP);
      pdfImage.scaleToFit(300, 300);

      document.add(pdfImage);
      }

      Markup text = article.getText();
      text.writeOn(new RichtTextToPdfHandler(document));

    } catch (DocumentException e1) {
      e1.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (document.isOpen())
      document.close();
    }
  }

  private static class RichtTextToPdfHandler extends DefaultHandler {
	
    private static final char NO_BREAK_SPACE = '\u00a0';
    private static final char WHITESPACE = ' ';

    protected Document document;
    protected Paragraph paragraph = null;
    protected List list = null;

    public RichtTextToPdfHandler(Document document) {
      this.document = document;
    }

    @Override
    public void characters(char[] data, int offset, int count)
      throws SAXException {
      if (paragraph != null) {
        String text = String.copyValueOf(data, offset, count);
        text = text.replace(NO_BREAK_SPACE, WHITESPACE); // fixing &nbsp; in text...
        paragraph.add(text);
      }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
      if ("p".equals(localName)) {
      String cls = atts.getValue("class");
      if (cls == null) {
        // create a default paragraph...
        openParagraph(TEXT_FONT, 4);
      } else if ("p--heading-1".equals(cls)) {
        openParagraph(TITLE_FONT, 18);
      } else if ("p--heading-2".equals(cls) || cls.startsWith("p--heading")) {
        openParagraph(SUBTITLE_FONT, 12);
      } else {
        // create a default paragraph...
        openParagraph(TEXT_FONT, 6);
      }
      }
      else if ("ul".equals(localName)) {
        list = new List(false);
        list.setListSymbol("\u2022 ");
      }
      else if ("ol".equals(localName)) {
        list = new List(true);
      }
      else if ("li".equals(localName)) {
        paragraph = new ListItem("", TEXT_FONT);
      }

    }

    @Override
    public void endElement(String uri, String localName, String qName)
      throws SAXException {
      try {
      if ("p".equals(localName)) {
        closeParagraph();
      }
      else if ("br".equals(localName)) {
        addLineBreak();
      }
      else if ("ul".equals(localName) || "ol".equals(localName)) {
        if (list!=null) {
          document.add(list);
          list = null;
        }
      }
      else if ("li".equals(localName)) {
        if (list!=null && paragraph!=null) {
          list.add(paragraph);
          paragraph = null;
        }
      }
      } catch (DocumentException ex) {
      throw new SAXException(ex);
      }
    }

    private void addLineBreak() throws DocumentException {
      if (paragraph!=null) {
        Font currentFont = paragraph.getFont();
        closeParagraph();
        openParagraph(currentFont, 0);
      }
    }

    private void openParagraph(Font font, float spacingBefore) {
      paragraph = new Paragraph("", font);
      paragraph.setSpacingBefore(spacingBefore);
    }

    private void closeParagraph() throws DocumentException {
      if (paragraph != null) {
        document.add(paragraph);
        paragraph = null;
      }
    }

  }

}
