package com.coremedia.coredining.contentbeans;

import com.coremedia.coredining.contentbeans.LinkableImpl;

import java.util.List;

/**
 * Generated base class for beans of document type "Site".
 */
public abstract class SiteBase extends LinkableImpl {

  /*
   * DEVELOPER NOTE
   * Change {@link com.coremedia.coredining.contentbeans.SiteImpl} instead of this class.
   */

  /**
   * Returns the value of the document property "id"
   * @return the value of the document property "id"
   */
  public String getId() {
    return getContent().getString("id");
  }


  /**
   * Returns the value of the document property "root"
   * @return the value of the document property "root"
   */
  public List<? extends Topic> getRoot() {
    List/*<Content>*/ contents = getContent().getLinks("root");
    List<? extends Topic> contentBeans = (List<? extends Topic>) createBeansFor(contents);
    return contentBeans;
  }


  /**
   * Returns the value of the document property "name"
   * @return the value of the document property "name"
   */
  public String getName() {
    return getContent().getString("name");
  }


  /**
   * Returns the value of the document property "siteManagerGroup"
   * @return the value of the document property "siteManagerGroup"
   */
  public String getSiteManagerGroup() {
    return getContent().getString("siteManagerGroup");
  }


  /**
   * Returns the value of the document property "master"
   * @return the value of the document property "master"
   */
  public List<? extends Site> getMaster() {
    List/*<Content>*/ contents = getContent().getLinks("master");
    List<? extends Site> contentBeans = (List<? extends Site>) createBeansFor(contents);
    return contentBeans;
  }

}
