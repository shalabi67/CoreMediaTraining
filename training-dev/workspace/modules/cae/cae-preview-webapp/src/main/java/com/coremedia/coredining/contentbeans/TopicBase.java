package com.coremedia.coredining.contentbeans;

import com.coremedia.cap.content.Content;
import com.coremedia.coredining.contentbeans.Container;
import com.coremedia.coredining.contentbeans.LinkableImpl;
import com.coremedia.coredining.contentbeans.PageLayout;
import com.coremedia.coredining.contentbeans.Topic;
import java.util.List;

/**
 * Generated base class for beans of document type "Topic".
 */
public abstract class TopicBase extends LinkableImpl {

  /*
   * DEVELOPER NOTE
   * Change {@link com.coremedia.coredining.contentbeans.TopicImpl} instead of this class.
   */

  /**
   * Returns the value of the document property "contentContainers"
   * @return the value of the document property "contentContainers"
   */
  public List<? extends Container> getContentContainers() {
    List/*<Content>*/ contents = getContent().getLinks("contentContainers");
    List<? extends Container> contentBeans = (List<? extends Container>) createBeansFor(contents);
    return contentBeans;
  }


  /**
   * Returns the value of the document property "pageLayout"
   * @return the value of the document property "pageLayout"
   */
  public List<? extends PageLayout> getPageLayout() {
    List/*<Content>*/ contents = getContent().getLinks("pageLayout");
    List<? extends PageLayout> contentBeans = (List<? extends PageLayout>) createBeansFor(contents);
    return contentBeans;
  }


  /**
   * Returns the value of the document property "subTopics"
   * @return the value of the document property "subTopics"
   */
  public List<? extends Topic> getSubTopics() {
    List/*<Content>*/ contents = getContent().getLinks("subTopics");
    List<? extends Topic> contentBeans = (List<? extends Topic>) createBeansFor(contents);
    return contentBeans;
  }


  /**
   * Returns the value of the document property "relatedContainers"
   * @return the value of the document property "relatedContainers"
   */
  public List<? extends Container> getRelatedContainers() {
    List/*<Content>*/ contents = getContent().getLinks("relatedContainers");
    List<? extends Container> contentBeans = (List<? extends Container>) createBeansFor(contents);
    return contentBeans;
  }


  /**
   * Returns the value of the document property "master"
   * @return the value of the document property "master"
   */
  public List<? extends Topic> getMaster() {
    List/*<Content>*/ contents = getContent().getLinks("master");
    List<? extends Topic> contentBeans = (List<? extends Topic>) createBeansFor(contents);
    return contentBeans;
  }

}
