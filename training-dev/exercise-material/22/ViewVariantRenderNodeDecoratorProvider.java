package com.coremedia.coredining.view;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.coremedia.objectserver.view.RenderNodeDecorator;
import com.coremedia.objectserver.view.RenderNodeDecoratorProvider;

public class ViewVariantRenderNodeDecoratorProvider implements RenderNodeDecoratorProvider {
  
  private static final RenderNodeDecorator DECORATOR = new ViewVariantRenderNodeDecorator();

  @Override
  public RenderNodeDecorator getDecorator(String view, Map model, Locale locale, HttpServletRequest request) {
	  return DECORATOR;
  }

}
