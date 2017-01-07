package com.coremedia.coredining.handlers;

import com.coremedia.cap.common.CapBlobRef;
import com.coremedia.cap.common.CapPropertyDescriptor;
import com.coremedia.objectserver.web.ContentBlobHandlerBase;
import com.coremedia.objectserver.web.links.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RequestMapping
@Link
public class ContentBlobViewHandler extends ContentBlobHandlerBase {

  private static final String BLOB_URI_PATTERN = "/contentblob/{id}/{property}/{etag}";

  @RequestMapping(BLOB_URI_PATTERN)
  public ModelAndView handleBlob(@PathVariable("id") int contentId, @PathVariable("property") String propertyName, @PathVariable("etag") String etag) {
    return super.handleBlob(contentId, propertyName);
  }

  @Override
  @Link(type=CapBlobRef.class, uri=BLOB_URI_PATTERN)
  public Map<String, Object> buildBlobLink(CapBlobRef blob) {
    return super.buildBlobLink(blob);
  }

  @Override
  protected boolean isPermitted(CapPropertyDescriptor capPropertyDescriptor) {
    return true;
  }
}
