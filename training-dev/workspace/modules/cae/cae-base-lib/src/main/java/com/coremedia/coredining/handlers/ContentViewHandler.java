package com.coremedia.coredining.handlers;

import com.coremedia.cap.common.IdHelper;
import com.coremedia.objectserver.beans.ContentBean;
import com.coremedia.objectserver.web.HandlerHelper;
import com.coremedia.objectserver.web.links.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by mbuse on 17.02.2015.
 */

@RequestMapping
@Link
public class ContentViewHandler {

  public static final String CONTENT_URL_PATTERN = "/content/{id:\\d+}";

  @RequestMapping(CONTENT_URL_PATTERN)
  public ModelAndView handleContent(@PathVariable("id") ContentBean contentBean) {
    return HandlerHelper.createModel(contentBean);
  }

  @RequestMapping(value = CONTENT_URL_PATTERN, params = { "view" })
  public ModelAndView handleContent(@PathVariable("id") ContentBean contentBean,
                                    @RequestParam("view") String view) {
    return HandlerHelper.createModelWithView(contentBean, view);
  }

}
