package com.coremedia.coredining.contentbeans;

import com.coremedia.cap.common.Blob;
import com.coremedia.coredining.contentbeans.Linkable;
import java.util.List;

/**
 * Generated interface for beans of document type "Image".
 */
public interface Image extends Linkable  {

  /*
   * DEVELOPER NOTE
   * Change the methods to narrow the public interface
   * of the {@link com.coremedia.coredining.contentbeans.ImageImpl} implementation bean.
   */

  /**
   * {@link com.coremedia.cap.content.ContentType#getName() Name of the ContentType} 'Image'
   */
  public static final String CONTENTTYPE_IMAGE = "Image";

  /**
   * Returns the value of the document property "data"
   * @return the value
   */
  public Blob getData();

  /**
   * Returns the value of the document property "caption"
   * @return the value
   */
  public String getCaption();

  /**
   * Returns the value of the document property "master"
   * @return the value
   */
  public List<? extends Image> getMaster();
}
