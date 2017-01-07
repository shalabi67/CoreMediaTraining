Contentbeans and Spring Configuration
=======================================

This is the module, where you can place your contentbeans classes, the corresponding Spring definitions and your dataviews configuration.

Please put your:
* packages/classes below ```src/main/java/```

* spring definitions below ```src/main/resources/framework/spring```

* dataviews configuration below ```src/main/resources/framework/dataviews```


It is important, that you also package the spring contentbeans configurations here, as the CAE-Feeder need the contentbeans and their
definitions artifact in its classpath. To prevent the CAEFeeder from loading also the CAE webaplication infrastructure, you should
not put your MVC classes and configurations here.
