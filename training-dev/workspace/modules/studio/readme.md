CoreMedia Studio
==================

The studio modules hierarchy contains several modules:

* the studio-webapp module, that contains studio webapp you can start via tomcat7:run
* the studio-plugins module, an aggregator module for studio plugins
    * the example-studio-plugin module where you can add your custom studio client code
    * the control-room-plugin, the configurator plugin module for the CoreMedia Studio Control Room
* the studio-rest-extensions module, where you can add your custom studio server code


studio-plugins
------------------
Below the studio-plugins hierarchy, you can add Studio plugin modules. By default you will find the controlroom-studio-plugin,
which enables the Control Room and configures the translation workflow for it.

### example-studio-plugin
In the example-studio-plugin you can add your exml files and your custom jangaroo code to extend the CoreMedia Studio
on the client-side. The module is preconfigured with some example files:

* [studio-plugins/example-studio-plugin/src/main/joo/change/me/now/StudioPlugin.exml](studio-plugins/example-studio-plugin/src/main/joo/change/me/now/StudioPlugin.exml)

* [studio-plugins/example-studio-plugin/src/main/resources/META-INF/resources/joo/example-plugin.module.js](studio-plugins/example-studio-plugin/src/main/resources/META-INF/resources/joo/example-plugin.module.js)

As a first step you should replace the example package ```change.me.now``` into something reflecting your project. If you do this you have to:

* move the ```StudioPlugin.exml``` to the package of your choice

* set that package name in the ```studio-components.module.js``` e.g. modify ```mainClass:"change.me.now.StudioPlugin"```

* modify the config package in the plugin configuration of the ```exml-maven-plugin``` in the [studio-plugins/example-studio-plugin/pom.xml](studio-plugins/example-studio-plugin/pom.xml) to


studio-rest-extension
---------------------
In the studio-rest-extension module you can add extensions to the server-side of the studio, e.g. server-side validators.
To guide your first steps a spring example configuration has been added at
[studio-rest-extension/src/main/resources/META-INF/coremedia/component-example.xml](studio-rest-extension/src/main/resources/META-INF/coremedia/component-example.xml).
In the example spring file you will find all necessary spring imports predefined and a commented example validator. Remember that if you rename
the file, it should match the filename pattern ```component-.*.xml``` to be automatically been picked up by the Studio-webapp.


studio-webapp
-------------------
The studio webapp aggregates the ```studio-plugins``` and the ```studio-rest-extensions``` modules and provides a startable
infrastructure, currently using the ```tomcat7-maven-plugin```. To provide you with a nice development experience, there are some
plugin configurations necessary, which manifest in the:

 * [studio-webapp/tomcat-context.xml](studio-webapp/tomcat-context.xml)

 The job of this file is to configure the resource path for tomcat from which web resources should be loaded at startup.


 All this configurations are also being documented in the "Studio Developer Manual" on [documentation.coremedia.com](http://documentation.coremedia.com)
