package com.coremedia.coredining.contentbeans;

import com.coremedia.cap.common.Blob;
import com.coremedia.cap.content.Content;
import com.coremedia.coredining.contentbeans.Image;
import com.coremedia.coredining.contentbeans.LinkableImpl;
import java.util.List;

/**
 * Generated base class for beans of document type "Image".
 */
public abstract class ImageBase extends LinkableImpl {

  /*
   * DEVELOPER NOTE
   * Change {@link com.coremedia.coredining.contentbeans.ImageImpl} instead of this class.
   */

  /**
   * Returns the value of the document property "data"
   * @return the value of the document property "data"
   */
  public Blob getData() {
    return getContent().getBlobRef("data");
  }


  /**
   * Returns the value of the document property "caption"
   * @return the value of the document property "caption"
   */
  public String getCaption() {
    return getContent().getString("caption");
  }


  /**
   * Returns the value of the document property "master"
   * @return the value of the document property "master"
   */
  public List<? extends Image> getMaster() {
    List/*<Content>*/ contents = getContent().getLinks("master");
    List<? extends Image> contentBeans = (List<? extends Image>) createBeansFor(contents);
    return contentBeans;
  }

}
