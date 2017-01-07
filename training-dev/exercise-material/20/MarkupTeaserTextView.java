package com.coremedia.coredining.view;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.coremedia.objectserver.view.TextView;
import com.coremedia.xml.Markup;

/**
 * Special view to display XML richtext markup as a teaser. For this purpose:
 * <ul>
 * <li>all tags will be removed
 * <li>text inside of headlines will be removed
 * <li>the resulting text length is restricted
 * </ul>
 * 
 * The maximum text lenght can be either set as parameter using &lt;cm:param> or
 * in the bean definition. A passed parameter overrides the value set in the
 * bean definition.
 * 
 */
public class MarkupTeaserTextView implements TextView<Markup> {

	protected int teaserLength = 100;

	public void render(Markup markup, String view, Writer out,
			HttpServletRequest request, HttpServletResponse response) {

		int maxLength = getTeaserLength();

		///////////////////////////////////////////////////
		// your code starts here

		// You already have a neat handler class defined in
		// "TeaserTextHandler". It is able to write a limited
		// amount of characters to a given writer.
		// 
		// (1)  Create an instance of it and pass in the 
		//      writer "out" and the maximum length
		//      as determined above.
		//
		// (2)  Use the method 'Markup#writeOn(ContentHandler)' to
        //      write the markup on the TeaserTextHandler.
		
		// your code ends here
		///////////////////////////////////////////////////
	}

	public int getTeaserLength() {
		return teaserLength;
	}

	public void setTeaserLength(int teaserLength) {
		this.teaserLength = teaserLength;
	}

	private static class TeaserTextHandler extends DefaultHandler {

		protected int desiredLength;

		protected int restLength;

		protected Writer writer;

		protected boolean skipMode;

		public TeaserTextHandler(Writer writer, int desiredLength) {
			this.writer = writer;
			this.desiredLength = desiredLength;
			this.restLength = desiredLength;
		}

		public void characters(char ch[], int start, int length)
				throws SAXException {
			try {
				if (!skipMode && restLength > 0) {
					writer.write(ch, start, Math.min(length, restLength));
					restLength -= length;
				}
			} catch (IOException e) {
				throw new SAXException(e);
			}
		}

		public void startElement(String uri, String localName, String qName,
				Attributes atts) throws SAXException {
			if ("p".equals(localName) && atts.getIndex("class") != -1) {
				skipMode = true;
			}
		}

		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			if (restLength > 0) {
				try {
					writer.write(' ');
					restLength--;
				} catch (IOException e) {
					throw new SAXException(e);
				}
			}
			if ("p".equals(localName)) {
				skipMode = false;
			}
		}

	}

}
