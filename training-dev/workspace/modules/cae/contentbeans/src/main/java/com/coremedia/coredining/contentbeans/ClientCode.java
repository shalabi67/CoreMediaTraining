package com.coremedia.coredining.contentbeans;

import com.coremedia.cap.common.Blob;
import com.coremedia.coredining.contentbeans.Base;
import com.coremedia.coredining.contentbeans.Symbol;
import java.util.List;

/**
 * Generated interface for beans of document type "ClientCode".
 */
public interface ClientCode extends Base  {

  /*
   * DEVELOPER NOTE
   * Change the methods to narrow the public interface
   * of the {@link com.coremedia.coredining.contentbeans.ClientCodeImpl} implementation bean.
   */

  /**
   * {@link com.coremedia.cap.content.ContentType#getName() Name of the ContentType} 'ClientCode'
   */
  public static final String CONTENTTYPE_CLIENTCODE = "ClientCode";

  /**
   * Returns the value of the document property "raw"
   * @return the value
   */
  public Blob getRaw();

  /**
   * Returns the value of the document property "format"
   * @return the value
   */
  public List<? extends Symbol> getFormat();

  /**
   * Returns the value of the document property "url"
   * @return the value
   */
  public String getUrl();
}
