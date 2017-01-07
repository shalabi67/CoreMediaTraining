package com.coremedia.coredining.studio.field {

import com.coremedia.cap.content.Content;
import com.coremedia.coredining.studio.config.referrersField;
import com.coremedia.ui.data.Bean;
import com.coremedia.ui.data.RemoteBean;
import com.coremedia.ui.data.ValueExpression;
import com.coremedia.ui.data.ValueExpressionFactory;
import com.coremedia.ui.data.beanFactory;

import ext.Container;
import ext.Ext;

public class ReferrersFieldBase extends Container {

  public function ReferrersFieldBase(config:referrersField) {
    super(config);
    loadReferrers();
    config.bindTo.addChangeListener(loadReferrers);
  }

  // === LOADING REFERRERS FROM REST SERVICE ===

  public function loadReferrers() : void {
    var referrers:RemoteBean = getReferrers();
    referrers.invalidate(function():void {
      getReferrersValueExpression().setValue(referrers.get("items"));
    });
  }

  private function getReferrers() : RemoteBean {
    var target:Content = initialConfig.bindTo.getValue() as Content;
    return beanFactory.getRemoteBean("referrers/" + numericalId(target.getUriPath()) + "/all");
  }

  private function numericalId(uriPath:String) : String {
    if (uriPath.indexOf("content/")==0) {
      return uriPath.substring("content/".length);
    }
    return null;
  }


  // === GETTERS FOR VALUE EXPRESSIONS ===

  public function getReferrersValueExpression() : ValueExpression {
    if (!referrersValueExpression) {
      referrersValueExpression = ValueExpressionFactory.create("referrers", getModel());
    }
    return referrersValueExpression;
  }

  public function getSelectionValueExpression() : ValueExpression {
    if (!selectionValueExpression) {
      selectionValueExpression = ValueExpressionFactory.create("selection", getModel());
    }
    return selectionValueExpression;
  }

  private function getModel() : Bean {
    if (!model) {
      model = beanFactory.createLocalBean();
    }
    return model;
  }


  // === ATTRIBUTES ===

  private var referrersValueExpression:ValueExpression;
  private var selectionValueExpression:ValueExpression;
  private var model:Bean;

}
}
