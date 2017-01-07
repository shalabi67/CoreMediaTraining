package com.coremedia.coredining.contentbeans;

import com.coremedia.coredining.contentbeans.Linkable;

import java.util.List;

/**
 * Generated interface for beans of document type "Topic".
 */
public interface Topic extends Linkable  {

  /*
   * DEVELOPER NOTE
   * Change the methods to narrow the public interface
   * of the {@link com.coremedia.coredining.contentbeans.TopicImpl} implementation bean.
   */

  /**
   * {@link com.coremedia.cap.content.ContentType#getName() Name of the ContentType} 'Topic'
   */
  public static final String CONTENTTYPE_TOPIC = "Topic";

  /**
   * Returns the value of the document property "pageLayout"
   * @return the value
   */
  public List<? extends PageLayout> getPageLayout();

  /**
   * Returns the value of the document property "contentContainers"
   * @return the value
   */
  public List<? extends Container> getContentContainers();

  /**
   * Returns the value of the document property "relatedContainers"
   * @return the value
   */
  public List<? extends Container> getRelatedContainers();

  /**
   * Returns the value of the document property "subTopics"
   * @return the value
   */
  public List<? extends Topic> getSubTopics();

  /**
   * Returns the value of the document property "master"
   * @return the value
   */
  public List<? extends Topic> getMaster();

  public List<? extends Topic> getPathElements();

  public Topic getRootTopic();
}
