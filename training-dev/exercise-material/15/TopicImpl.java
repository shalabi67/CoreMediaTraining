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

  /**
   * Traverses the topic hierarchy to find the root of the topic tree.
   *
   * @return the root topic of this topic (might be the topic itself)
   */
  @Override
  public Topic getRootTopic() {
 	// Proposed steps:

	// (1) start from this topic
	// (2) if this topic has no parent, it must be the root topic
	// (3) if it has a parent, return the root topic of the parent
	// this will recursively walk down the navigation tree.
  }

  /**
   * Builds a list of topics that reflect the path from this topic to the root
   * topic in reverse order. This topic will not be included in the path.
   *
   * @return list of parents starting with the overall root topic at index 0.
   */
  @Override
  public List<? extends Topic> getPathElements() {
    // There are multiple ways to calculate the path elements. The one shown
	// below uses a while-loop over the parent and grandparents. But you can
	// also use recursion, which is maybe more elegant. 
	//
	// Please, recall that ContentBeans always should return immutable values!
	// Therefore it is best practice to use Collections.unmodifiableList(pathElements) 
	// wrap your pathElements before returning them.
	//
	// Proposed steps:
	//
	// (1) create an ArrayList to contain the result
	// (2) start with the parent of this topic
	// (3) if there is no parent, you are done
	// (4) otherwise add the parent to the *front* of list to return
	// (5) repeat from (3) with parent of the current parent
	// (6) when you are done return the constructed list
	// 
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
