package com.coremedia.coredining.contentbeans;

import com.coremedia.cap.content.Content;
import com.coremedia.coredining.contentbeans.Article;
import com.coremedia.coredining.contentbeans.Image;
import com.coremedia.coredining.contentbeans.Linkable;
import com.coremedia.coredining.contentbeans.LinkableImpl;
import com.coremedia.xml.Markup;
import java.util.Calendar;
import java.util.List;

/**
 * Generated base class for beans of document type "Article".
 */
public abstract class ArticleBase extends LinkableImpl {

  /*
   * DEVELOPER NOTE
   * Change {@link com.coremedia.coredining.contentbeans.ArticleImpl} instead of this class.
   */

  /**
   * Returns the value of the document property "image"
   * @return the value of the document property "image"
   */
  public List<? extends Image> getImage() {
    List/*<Content>*/ contents = getContent().getLinks("image");
    List<? extends Image> contentBeans = (List<? extends Image>) createBeansFor(contents);
    return contentBeans;
  }


  /**
   * Returns the value of the document property "related"
   * @return the value of the document property "related"
   */
  public List<? extends Linkable> getRelated() {
    List/*<Content>*/ contents = getContent().getLinks("related");
    List<? extends Linkable> contentBeans = (List<? extends Linkable>) createBeansFor(contents);
    return contentBeans;
  }


  /**
   * Returns the value of the document property "autoDelete"
   * @return the value of the document property "autoDelete"
   */
  public Calendar getAutoDelete() {
    return getContent().getDate("autoDelete");
  }


  /**
   * Returns the value of the document property "text"
   * @return the value of the document property "text"
   */
  public Markup getText() {
    return getMarkup("text");
  }


  /**
   * Returns the value of the document property "teaserLength"
   * @return the value of the document property "teaserLength"
   */
  public int getTeaserLength() {
    return getContent().getInt("teaserLength");
  }


  /**
   * Returns the value of the document property "autoPublish"
   * @return the value of the document property "autoPublish"
   */
  public Calendar getAutoPublish() {
    return getContent().getDate("autoPublish");
  }


  /**
   * Returns the value of the document property "master"
   * @return the value of the document property "master"
   */
  public List<? extends Article> getMaster() {
    List/*<Content>*/ contents = getContent().getLinks("master");
    List<? extends Article> contentBeans = (List<? extends Article>) createBeansFor(contents);
    return contentBeans;
  }

}
