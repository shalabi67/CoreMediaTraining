package com.coremedia.coredining.contentbeans;

import com.coremedia.coredining.contentbeans.Linkable;
import java.util.List;

/**
 * Generated interface for beans of document type "Container".
 */
public interface Container extends Linkable  {

  /*
   * DEVELOPER NOTE
   * Change the methods to narrow the public interface
   * of the {@link com.coremedia.coredining.contentbeans.ContainerImpl} implementation bean.
   */

  /**
   * {@link com.coremedia.cap.content.ContentType#getName() Name of the ContentType} 'Container'
   */
  public static final String CONTENTTYPE_CONTAINER = "Container";

  /**
   * Returns the value of the document property "contents"
   * @return the value
   */
  public List<? extends Linkable> getContents();

  /**
   * Returns the value of the document property "master"
   * @return the value
   */
  public List<? extends Container> getMaster();
}
