package com.coremedia.coredining.studio.validation;

import com.coremedia.cap.content.Content;
import com.coremedia.rest.cap.validation.ContentTypeValidatorBase;
import com.coremedia.rest.validation.Issues;
import com.coremedia.rest.validation.Severity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author mbuse
 *         03.06.13 15:07
 */
public class TopicNavigationValidator extends ContentTypeValidatorBase {

  private static final String TYPE_TOPIC = "Topic";

  private static final String PROPERTY_SUBTOPICS = "subTopics";
  private static final String PROPERTY_TITLE = "title";

  private static final String CODE_NO_TITLE = "noTitle";
  private static final String CODE_SAME_TITLE_TWICE = "sameTitleTwice";
  private static final String CODE_SIBLING_WITH_SAME_TITLE = "siblingWithSameTitle";

  @Override
  public void validate(Content content, Issues issues) {
    validateSubTopics(content, issues);
    validateTitle(content, issues);
  }

  private void validateSubTopics(Content content, Issues issues) {
    List<Content> subTopics = content.getLinks(PROPERTY_SUBTOPICS);
    Map<String, Content> subTopicForTitleMap = new HashMap<String, Content>();
    for (Content t : subTopics) {
      String title = t.getString(PROPERTY_TITLE);
      if (title==null) {
        issues.addIssue(Severity.ERROR, PROPERTY_SUBTOPICS, CODE_NO_TITLE, t.getPath());
      }
      else if (subTopicForTitleMap.containsKey(title)) {
        Content otherTopic = subTopicForTitleMap.get(title);
        issues.addIssue(Severity.ERROR, PROPERTY_SUBTOPICS, CODE_SAME_TITLE_TWICE, title, otherTopic.getPath(), t.getPath());
      }
      else {
        subTopicForTitleMap.put(title, t);
      }
    }
  }

  private void validateTitle(Content content, Issues issues) {
    String title = content.getString(PROPERTY_TITLE);
    if (title == null) {
      issues.addIssue(Severity.ERROR, PROPERTY_TITLE, CODE_NO_TITLE);
    } else {
      Set<Content> parents = content.getReferrersWithDescriptor(TYPE_TOPIC, PROPERTY_SUBTOPICS);
      for (Content parent : parents) {
        List<Content> siblings = parent.getLinks(PROPERTY_SUBTOPICS);
        for (Content sibling : siblings) {
          String otherTitle = sibling.getString(PROPERTY_TITLE);
          if (title.equals(otherTitle) && !content.equals(sibling)) {
            issues.addIssue(Severity.ERROR, PROPERTY_TITLE, CODE_SIBLING_WITH_SAME_TITLE, parent.getPath(), sibling.getPath());
          }
        }
      }
    }
  }
}
