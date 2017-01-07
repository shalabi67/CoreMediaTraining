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

  public static final String ATTRIBUTE_CURRENT_TOPIC = "currentTopic";

  @RequestMapping( /* TODO: Add an valid URL pattern */)
  public ModelAndView handleContent(@PathVariable("id") ContentBean self,
	  								@RequestParam(value="view", required=false) String view) {
    if (self==null) {
      return HandlerHelper.notFound();
    }
    ModelAndView modelAndView = HandlerHelper.createModelWithView(self, view);

    Topic currentTopic = null;

    ///////////////////////////////////////////////////
    // TODO: your code starts here

    // You need to set currentTopic to a reasonable value,
    // no matter if the bean to be displayed is an
    // article or a topic. Linkable JSP can use this value
    // if it is added to the result.
    //
    // In case of an article you already know how to set the 
    // topic: you take the home topic!
    // In case the bean is a topic the current topic is the
    // topic bean itself
    
    // Hint: use something like "bean instanceof Topic" 
    // to find out if the bean is a topic!!!

    // your code ends here
    ///////////////////////////////////////////////////

    modelAndView.addObject(ATTRIBUTE_CURRENT_TOPIC, currentTopic);
    return modelAndView;
  }
}
