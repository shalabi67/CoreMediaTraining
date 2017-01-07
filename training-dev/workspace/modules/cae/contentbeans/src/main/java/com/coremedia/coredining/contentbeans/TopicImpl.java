package com.coremedia.coredining.contentbeans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.coremedia.cap.content.Content;

/**
 * Generated extension class for immutable beans of document type "Topic". You
 * are invited to change this class.
 */
public class TopicImpl extends TopicBase implements Topic {

  @Override
  public List<? extends PageLayout> getPageLayout() {
    List<? extends PageLayout> pageLayout = super.getPageLayout();
    if (pageLayout.isEmpty()) {
      Topic parent = getParent();
      if (parent!=null) {
        pageLayout = parent.getPageLayout();
      }
    }
    return pageLayout;
  }
  
  /**
   * Traverses the topic hierarchy to find the root of the topic tree.
   *
   * @return the root topic of this topic (might be the topic itself)
   */
  @Override
  public Topic getRootTopic() {
    Topic parent = getParent();
    if (parent == null) {
      return this;
    } else {
      return parent.getRootTopic();
    }
  }

  /**
   * Builds a list of topics that reflect the path from this topic to the root
   * topic in reverse order. This topic will not be included in the path.
   *
   * @return list of parents starting with the overall root topic at index 0.
   */
  @Override
  public List<? extends Topic> getPathElements() {
    List<Topic> pathElements = new ArrayList<Topic>();

    Topic parent = getParent();
    if (parent != null) {
      pathElements.addAll(parent.getPathElements());
      pathElements.add(parent);
    }

    return Collections.unmodifiableList(pathElements);
  }

  /**
   * Gets the parent topic of this topic if there is one.
   *
   * @return the parent <code>null</code> if there is no parent topic
   */
  protected Topic getParent() {
    Set<Content> incoming = getContent().getReferrersWithDescriptor("Topic", "subTopics");
    if (incoming.isEmpty()) {
      return null;
    } else {
      Content content = incoming.iterator().next();
      return (Topic) createBeanFor(content);
    }
  }

}
