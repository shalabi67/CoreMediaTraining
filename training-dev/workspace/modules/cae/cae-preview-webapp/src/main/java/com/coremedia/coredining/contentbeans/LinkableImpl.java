package com.coremedia.coredining.contentbeans;

import com.coremedia.objectserver.beans.AbstractContentBean;

public class LinkableImpl extends AbstractContentBean implements Linkable {

	/* (non-Javadoc)
	 * @see com.coremedia.corebase.contentbeans.Linkable#getTitle()
	 */
	public String getTitle() {
		return getContent().getString("title");
	}

	public String getText() {
		return "This is text property.";
	}

}
