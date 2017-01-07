package com.coremedia.coredining.contentbeans;

import com.coremedia.coredining.contentbeans.Linkable;

import java.util.List;

/**
 * Generated base class for beans of document type "Linkable".
 */
public abstract class LinkableBase extends BaseImpl {

  /*
   * DEVELOPER NOTE
   * Change {@link com.coremedia.coredining.contentbeans.LinkableImpl} instead of this class.
   */

  /**
   * Returns the value of the document property "title"
   * @return the value of the document property "title"
   */
  public String getTitle() {
    return getContent().getString("title");
  }


  /**
   * Returns the value of the document property "keywords"
   * @return the value of the document property "keywords"
   */
  public String getKeywords() {
    return getContent().getString("keywords");
  }


  /**
   * Returns the value of the document property "masterVersion"
   * @return the value of the document property "masterVersion"
   */
  public int getMasterVersion() {
    return getContent().getInt("masterVersion");
  }


  /**
   * Returns the value of the document property "locale"
   * @return the value of the document property "locale"
   */
  public String getLocale() {
    return getContent().getString("locale");
  }


  /**
   * Returns the value of the document property "homeTopic"
   * @return the value of the document property "homeTopic"
   */
  public List<? extends Topic> getHomeTopic() {
    List/*<Content>*/ contents = getContent().getLinks("homeTopic");
    List<? extends Topic> contentBeans = (List<? extends Topic>) createBeansFor(contents);
    return contentBeans;
  }


  /**
   * Returns the value of the document property "view"
   * @return the value of the document property "view"
   */
  public List<? extends Symbol> getView() {
    List/*<Content>*/ contents = getContent().getLinks("view");
    List<? extends Symbol> contentBeans = (List<? extends Symbol>) createBeansFor(contents);
    return contentBeans;
  }


  /**
   * Returns the value of the document property "master"
   * @return the value of the document property "master"
   */
  public List<? extends Linkable> getMaster() {
    List/*<Content>*/ contents = getContent().getLinks("master");
    List<? extends Linkable> contentBeans = (List<? extends Linkable>) createBeansFor(contents);
    return contentBeans;
  }

}
