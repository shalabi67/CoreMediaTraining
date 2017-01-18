package com.coremedia.coredining.contentbeans;

import com.coremedia.cap.content.Content;
import com.coremedia.coredining.contentbeans.BaseImpl;
import com.coremedia.coredining.contentbeans.ClientCode;
import java.util.List;

/**
 * Generated base class for beans of document type "PageLayout".
 */
public abstract class PageLayoutBase extends BaseImpl {

  /*
   * DEVELOPER NOTE
   * Change {@link com.coremedia.coredining.contentbeans.PageLayoutImpl} instead of this class.
   */

  /**
   * Returns the value of the document property "clientCodes"
   * @return the value of the document property "clientCodes"
   */
  public List<? extends ClientCode> getClientCodes() {
    List/*<Content>*/ contents = getContent().getLinks("clientCodes");
    List<? extends ClientCode> contentBeans = (List<? extends ClientCode>) createBeansFor(contents);
    return contentBeans;
  }

}
