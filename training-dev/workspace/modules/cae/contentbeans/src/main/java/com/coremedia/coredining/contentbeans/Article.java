package com.coremedia.coredining.contentbeans;

import com.coremedia.coredining.contentbeans.Linkable;
import com.coremedia.xml.Markup;
import java.util.Calendar;
import java.util.List;

/**
 * Generated interface for beans of document type "Article".
 */
public interface Article extends Linkable  {

  /*
   * DEVELOPER NOTE
   * Change the methods to narrow the public interface
   * of the {@link com.coremedia.coredining.contentbeans.ArticleImpl} implementation bean.
   */

  /**
   * {@link com.coremedia.cap.content.ContentType#getName() Name of the ContentType} 'Article'
   */
  public static final String CONTENTTYPE_ARTICLE = "Article";

  /**
   * Returns the value of the document property "text"
   * @return the value
   */
  public Markup getText();

  /**
   * Returns the value of the document property "autoDelete"
   * @return the value
   */
  public Calendar getAutoDelete();

  /**
   * Returns the value of the document property "image"
   * @return the value
   */
  public List<? extends Image> getImage();

  /**
   * Returns the value of the document property "autoPublish"
   * @return the value
   */
  public Calendar getAutoPublish();

  /**
   * Returns the value of the document property "master"
   * @return the value
   */
  public List<? extends Article> getMaster();

  /**
   * Returns the value of the document property "teaserLength"
   * @return the value
   */
  public int getTeaserLength();

  /**
   * Returns the value of the document property "related"
   * @return the value
   */
  public List<? extends Linkable> getRelated();
}
