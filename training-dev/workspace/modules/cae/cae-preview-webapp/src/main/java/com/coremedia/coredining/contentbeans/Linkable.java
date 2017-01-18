package com.coremedia.coredining.contentbeans;

import com.coremedia.coredining.contentbeans.Base;
import com.coremedia.coredining.contentbeans.Linkable;
import com.coremedia.coredining.contentbeans.Symbol;
import com.coremedia.coredining.contentbeans.Topic;
import java.util.List;

/**
 * Generated interface for beans of document type "Linkable".
 */
public interface Linkable extends Base  {

  /*
   * DEVELOPER NOTE
   * Change the methods to narrow the public interface
   * of the {@link com.coremedia.coredining.contentbeans.LinkableImpl} implementation bean.
   */

  /**
   * {@link com.coremedia.cap.content.ContentType#getName() Name of the ContentType} 'Linkable'
   */
  public static final String CONTENTTYPE_LINKABLE = "Linkable";

  /**
   * Returns the value of the document property "view"
   * @return the value
   */
  public List<? extends Symbol> getView();

  /**
   * Returns the value of the document property "keywords"
   * @return the value
   */
  public String getKeywords();

  /**
   * Returns the value of the document property "homeTopic"
   * @return the value
   */
  public List<? extends Topic> getHomeTopic();

  /**
   * Returns the value of the document property "masterVersion"
   * @return the value
   */
  public int getMasterVersion();

  /**
   * Returns the value of the document property "title"
   * @return the value
   */
  public String getTitle();

  /**
   * Returns the value of the document property "locale"
   * @return the value
   */
  public String getLocale();

  /**
   * Returns the value of the document property "master"
   * @return the value
   */
  public List<? extends Linkable> getMaster();
}
