package com.coremedia.coredining.contentbeans;

import com.coremedia.coredining.contentbeans.Base;
import com.coremedia.coredining.contentbeans.ClientCode;
import java.util.List;

/**
 * Generated interface for beans of document type "PageLayout".
 */
public interface PageLayout extends Base  {

  /*
   * DEVELOPER NOTE
   * Change the methods to narrow the public interface
   * of the {@link com.coremedia.coredining.contentbeans.PageLayoutImpl} implementation bean.
   */

  /**
   * {@link com.coremedia.cap.content.ContentType#getName() Name of the ContentType} 'PageLayout'
   */
  public static final String CONTENTTYPE_PAGELAYOUT = "PageLayout";

  /**
   * Returns the value of the document property "clientCodes"
   * @return the value
   */
  public List<? extends ClientCode> getClientCodes();
}
