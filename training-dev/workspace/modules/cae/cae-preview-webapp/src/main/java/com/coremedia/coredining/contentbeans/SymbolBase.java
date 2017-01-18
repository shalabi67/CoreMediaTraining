package com.coremedia.coredining.contentbeans;

import com.coremedia.cap.content.Content;
import com.coremedia.coredining.contentbeans.BaseImpl;

/**
 * Generated base class for beans of document type "Symbol".
 */
public abstract class SymbolBase extends BaseImpl {

  /*
   * DEVELOPER NOTE
   * Change {@link com.coremedia.coredining.contentbeans.SymbolImpl} instead of this class.
   */

  /**
   * Returns the value of the document property "description"
   * @return the value of the document property "description"
   */
  public String getDescription() {
    return getContent().getString("description");
  }

}
