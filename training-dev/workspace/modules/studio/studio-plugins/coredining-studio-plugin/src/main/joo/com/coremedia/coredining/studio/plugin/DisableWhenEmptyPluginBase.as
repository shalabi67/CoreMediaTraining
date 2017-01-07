package com.coremedia.coredining.studio.plugin {

import com.coremedia.coredining.studio.config.disableWhenEmptyPlugin;
import com.coremedia.ui.data.ValueExpression;

import ext.Button;

import ext.Component;

import ext.Plugin;

public class DisableWhenEmptyPluginBase implements Plugin {

	private var listValueExpression:ValueExpression;

	public function DisableWhenEmptyPluginBase(config:disableWhenEmptyPlugin) {
	 	listValueExpression = config.listValueExpression;

	}

	public function init(component:Component):void {
    var button:Button = component as Button;
		if (button) {
      // (1) set button state...
      setButtonState(button);
      // (2) register change listener...
			var changeListener:Function = function() {
        setButtonState(button);
      };
      listValueExpression.addChangeListener(changeListener);
      // (3) de-register change listener on "destroy"-event
      button.on("destroy", function() {
        listValueExpression.removeChangeListener(changeListener);
      });
		}
	}

  private function setButtonState(btn:Button) {
    var items:Array = listValueExpression.getValue() as Array;
    if (items && items.length > 0) {
      btn.enable();
    }
    else {
      btn.disable();
    }
  }
}
}
