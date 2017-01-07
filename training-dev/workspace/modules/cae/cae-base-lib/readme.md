CAE base lib
==============

The base lib is the home of all cae specific code, that goes beyond the contentbeans. Contentbeans classes and code 
should be put in the contentbeans module, see [cae/contentbeans/readme.md](../contentbeans/readme.md). 

In this module you can put the code for your handlers, linkschemes, programmed views and all other stuff that is necessary
in your cae.

To help you with the start, the following files have been arranged for you to integrate your spring logic in. The naming
should be enough documenation.
* [cae/cae-base-lib/src/main/resources/framework/spring/cache.xml](src/main/resources/framework/spring/cache.xml)

* [cae/cae-base-lib/src/main/resources/framework/spring/handlers.xml](src/main/resources/framework/spring/handlers.xml)

* [cae/cae-base-lib/src/main/resources/framework/spring/linkschemes.xml](src/main/resources/framework/spring/linkschemes.xml)

* [cae/cae-base-lib/src/main/resources/framework/spring/views.xml](src/main/resources/framework/spring/views.xml)

The packages and classes should be put as usual, below a ```src/main/java``` folder.