package com.coremedia.coredining.handlers;

import java.util.List;

import com.coremedia.cap.common.IdHelper;
import com.coremedia.coredining.contentbeans.LinkableImpl;
import com.coremedia.objectserver.web.links.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.coremedia.coredining.contentbeans.Linkable;
import com.coremedia.coredining.contentbeans.Topic;
import com.coremedia.objectserver.beans.ContentBean;
import com.coremedia.objectserver.web.HandlerHelper;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping
@Link
public class CustomContentHandler {

  public static final String CONTENT_URL_PATTERN = "/content/{id:\\d+}";
  public static final String ATTRIBUTE_CURRENT_TOPIC = "currentTopic";

  @RequestMapping(CONTENT_URL_PATTERN)
  public ModelAndView handleContent(@PathVariable("id") ContentBean self,
	  								@RequestParam(value="view", required=false) String view) {
    if (self==null) {
      return HandlerHelper.notFound();
    }
    ModelAndView modelAndView = HandlerHelper.createModelWithView(self, view);

    Topic currentTopic = null;

    ///////////////////////////////////////////////////
    // your code starts here

    if (self instanceof Topic) {
      currentTopic = (Topic) self;
    }
    else if (self instanceof Linkable) {
      List<? extends Topic> homeTopic = ((Linkable) self).getHomeTopic();
      if (!homeTopic.isEmpty()) {
        currentTopic = homeTopic.get(0);
      }
    }

    // your code ends here
    ///////////////////////////////////////////////////

    modelAndView.addObject(ATTRIBUTE_CURRENT_TOPIC, currentTopic);
    return modelAndView;
  }
}
