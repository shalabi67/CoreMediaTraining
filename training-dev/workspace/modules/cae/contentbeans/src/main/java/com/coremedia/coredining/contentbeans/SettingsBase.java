package com.coremedia.coredining.contentbeans;

import com.coremedia.cap.content.Content;
import com.coremedia.cap.struct.Struct;
import com.coremedia.coredining.contentbeans.BaseImpl;
import com.coremedia.xml.Markup;

/**
 * Generated base class for beans of document type "Settings".
 */
public abstract class SettingsBase extends BaseImpl {

  /*
   * DEVELOPER NOTE
   * Change {@link com.coremedia.coredining.contentbeans.SettingsImpl} instead of this class.
   */

  /**
   * Returns the value of the document property "settings"
   * @return the value of the document property "settings"
   */
  public Struct getSettings() {
    return getContent().getStruct("settings");
  }


  /**
   * Returns the value of the document property "identifier"
   * @return the value of the document property "identifier"
   */
  public String getIdentifier() {
    return getContent().getString("identifier");
  }

}
