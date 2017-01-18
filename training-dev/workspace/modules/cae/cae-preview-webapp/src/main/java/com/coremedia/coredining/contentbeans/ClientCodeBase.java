package com.coremedia.coredining.contentbeans;

import com.coremedia.cap.common.Blob;
import com.coremedia.cap.content.Content;
import com.coremedia.coredining.contentbeans.BaseImpl;
import com.coremedia.coredining.contentbeans.Symbol;
import java.util.List;

/**
 * Generated base class for beans of document type "ClientCode".
 */
public abstract class ClientCodeBase extends BaseImpl {

  /*
   * DEVELOPER NOTE
   * Change {@link com.coremedia.coredining.contentbeans.ClientCodeImpl} instead of this class.
   */

  /**
   * Returns the value of the document property "format"
   * @return the value of the document property "format"
   */
  public List<? extends Symbol> getFormat() {
    List/*<Content>*/ contents = getContent().getLinks("format");
    List<? extends Symbol> contentBeans = (List<? extends Symbol>) createBeansFor(contents);
    return contentBeans;
  }


  /**
   * Returns the value of the document property "raw"
   * @return the value of the document property "raw"
   */
  public Blob getRaw() {
    return getContent().getBlobRef("raw");
  }


  /**
   * Returns the value of the document property "url"
   * @return the value of the document property "url"
   */
  public String getUrl() {
    return getContent().getString("url");
  }

}
