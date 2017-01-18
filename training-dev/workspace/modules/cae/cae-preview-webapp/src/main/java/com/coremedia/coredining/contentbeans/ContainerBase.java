package com.coremedia.coredining.contentbeans;

import com.coremedia.cap.content.Content;
import com.coremedia.coredining.contentbeans.Container;
import com.coremedia.coredining.contentbeans.Linkable;
import com.coremedia.coredining.contentbeans.LinkableImpl;
import java.util.List;

/**
 * Generated base class for beans of document type "Container".
 */
public abstract class ContainerBase extends LinkableImpl {

  /*
   * DEVELOPER NOTE
   * Change {@link com.coremedia.coredining.contentbeans.ContainerImpl} instead of this class.
   */

  /**
   * Returns the value of the document property "contents"
   * @return the value of the document property "contents"
   */
  public List<? extends Linkable> getContents() {
    List/*<Content>*/ contents = getContent().getLinks("contents");
    List<? extends Linkable> contentBeans = (List<? extends Linkable>) createBeansFor(contents);
    return contentBeans;
  }


  /**
   * Returns the value of the document property "master"
   * @return the value of the document property "master"
   */
  public List<? extends Container> getMaster() {
    List/*<Content>*/ contents = getContent().getLinks("master");
    List<? extends Container> contentBeans = (List<? extends Container>) createBeansFor(contents);
    return contentBeans;
  }

}
