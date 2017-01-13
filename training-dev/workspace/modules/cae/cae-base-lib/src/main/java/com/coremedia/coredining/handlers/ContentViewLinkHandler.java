package com.coremedia.coredining.handlers;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.coremedia.cap.common.IdHelper;
import com.coremedia.objectserver.beans.ContentBean;
import com.coremedia.objectserver.web.links.Link;

/**
 * The ContentViewLinkHandler contains the link-building logic for the ContentViewHandler.
 * 
 * It is a replacement or the former ContentLinkScheme.
 * 
 * In a typical handler implementation both link-building and request-handling methods would be placed in 
 * a single class. Unfortunately this would not allow to replace the request-handling method in a custom
 * handler without replacing the link-building method too.
 */
@Link
public class ContentViewLinkHandler {

	 @Link(type = ContentBean.class, uri = ContentViewHandler.CONTENT_URL_PATTERN)
	  public UriComponents buildContentLink(ContentBean target, String view, UriComponentsBuilder builder) {
	    if (view!=null) {
	      builder.queryParam("view", view);
	    }
	    int id = IdHelper.parseContentId(target.getContent().getId());
	    return builder.buildAndExpand(id);
	  }
}
