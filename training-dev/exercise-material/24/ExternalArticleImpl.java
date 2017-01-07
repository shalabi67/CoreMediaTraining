package com.coremedia.coredining.contentbeans;

import java.util.Map;

import com.coremedia.coredining.dao.ArticleDAO;
import com.coremedia.xml.Markup;
import com.coremedia.xml.MarkupFactory;

public class ExternalArticleImpl extends ArticleImpl {

  @Override
  public Markup getText() {
	  String textBody = getExternalContent().get("text");
	  return MarkupFactory.fromString("<div><p>" + textBody + "</p></div>");
  }

  @Override
  public String getTitle() {
	  return getExternalContent().get("title");
  }

  @Override
  public String getKeywords() {
	  return getExternalContent().get("keywords");
  }
  
  public void setArticleDAO(ArticleDAO articleDAO) {
	  this.articleDAO = articleDAO;
  }
  
  public ArticleDAO getArticleDAO() {
	  return articleDAO;
  }
  
  protected String getExternalId() {
    return getContent().getString("externalId");
  }
  
  protected Map<String, String> getExternalContent() {
    String externalId = getExternalId();
    return getArticleDAO().get(externalId);
  }
  
  private ArticleDAO articleDAO;
}
