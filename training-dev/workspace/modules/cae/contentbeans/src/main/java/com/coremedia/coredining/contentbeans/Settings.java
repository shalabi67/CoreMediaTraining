package com.coremedia.coredining.contentbeans;

import com.coremedia.cap.struct.Struct;
import com.coremedia.coredining.contentbeans.Base;
import com.coremedia.xml.Markup;

/**
 * Generated interface for beans of document type "Settings".
 */
public interface Settings extends Base  {

  /*
   * DEVELOPER NOTE
   * Change the methods to narrow the public interface
   * of the {@link com.coremedia.coredining.contentbeans.SettingsImpl} implementation bean.
   */

  /**
   * {@link com.coremedia.cap.content.ContentType#getName() Name of the ContentType} 'Settings'
   */
  public static final String CONTENTTYPE_SETTINGS = "Settings";

  /**
   * Returns the value of the document property "settings"
   * @return the value
   */
  public Struct getSettings();

  /**
   * Returns the value of the document property "identifier"
   * @return the value
   */
  public String getIdentifier();
}
