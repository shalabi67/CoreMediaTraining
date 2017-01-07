package com.coremedia.coredining.contentbeans;

import com.coremedia.coredining.contentbeans.Linkable;

import java.util.List;

/**
 * Generated interface for beans of document type "Site".
 */
public interface Site extends Linkable  {

  /*
   * DEVELOPER NOTE
   * Change the methods to narrow the public interface
   * of the {@link com.coremedia.coredining.contentbeans.SiteImpl} implementation bean.
   */

  /**
   * {@link com.coremedia.cap.content.ContentType#getName() Name of the ContentType} 'Site'
   */
  public static final String CONTENTTYPE_SITE = "Site";

  /**
   * Returns the value of the document property "id"
   * @return the value
   */
  public String getId();

  /**
   * Returns the value of the document property "root"
   * @return the value
   */
  public List<? extends Topic> getRoot();

  /**
   * Returns the value of the document property "name"
   * @return the value
   */
  public String getName();

  /**
   * Returns the value of the document property "siteManagerGroup"
   * @return the value
   */
  public String getSiteManagerGroup();

  /**
   * Returns the value of the document property "master"
   * @return the value
   */
  public List<? extends Site> getMaster();
}
