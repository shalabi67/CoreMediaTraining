package com.coremedia.coredining.view;

import com.coremedia.coredining.contentbeans.HasViewVariant;
import com.coremedia.objectserver.view.RenderNode;
import com.coremedia.objectserver.view.RenderNodeDecorator;

public class ViewVariantRenderNodeDecorator implements RenderNodeDecorator {

  @Override
  public Object decorateBean(Object self, String view) {
	return self;
  }

  @Override
  public String decorateViewName(Object self, String view) {
    String decoratedViewName = view;

	// 	//////////////////////////////////////////////////////////////////
	// 	Your code starts here...
	//
	// 	We are going to append the view variant of the ${self} object
	// 	to the specified view name. E.g. view name "main" will become
	// 	"main[tableOfTeasers]", if the object 'self' has a view variant.
	//
	// 	The view variant will be determined by the method 'getViewVariant()'
	//	of the interface 'HasViewVariant' which will be implemented by all
	//	LinkableImpl's.
	//
	//	NOTE: it is always a good idea to make the view dispatching 
	//		  independend of the actual implementation of your content beans!!!
	//
	//	(1) We start with 'decoratedViewName = view;' (already done).
	//
	// 	(2)	Check if the object 'self' implements HasViewVariant.
	//
	//	(3) If true, get the view variant of the object self.
	// 
	//	(4) If the view variant is null, we are done, we will return the 
	//		view name unchanged. 
	//
	//  (5) Otherwise we have to calculate a new view name:
	//      If view==null : decoratedViewName = "[" + viewVariant + "]"
	//		If view!=null : decoratedViewName = view + "[" + viewVariant + "]"
	//
	//	(6) Finally, return the decoratedView Name.
	//
	// 	//////////////////////////////////////////////////////////////////
	
    return decoratedViewName;
  }

  @Override
  public RenderNode decorateRenderNode(Object self, String view) {
    return new RenderNode(decorateBean(self, view), decorateViewName(self, view));
  }
}
