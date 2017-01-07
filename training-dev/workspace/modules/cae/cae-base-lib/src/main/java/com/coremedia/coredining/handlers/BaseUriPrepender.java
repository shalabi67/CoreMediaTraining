package com.coremedia.coredining.handlers;

import com.coremedia.objectserver.view.ViewUtils;
import com.coremedia.objectserver.web.links.LinkPostProcessor;
import com.coremedia.objectserver.web.links.UriComponentsHelper;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@LinkPostProcessor
public class BaseUriPrepender {

  @LinkPostProcessor
  public UriComponentsBuilder prependPrefix(UriComponents originalUri, HttpServletRequest request) {
    // this @LinkPostProcessor prepends the URI returned by 'buildLink()' with
    // the base URI ('/coredining/servlet')
    String baseUri = ViewUtils.getBaseUri(request);
    return UriComponentsHelper.prependPath(baseUri, originalUri);
  }
}
