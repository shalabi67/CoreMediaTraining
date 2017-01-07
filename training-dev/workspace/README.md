CM8 Project Workspace for Custom Projects
=========================================

This CM8 Project Workspace for Custom Projects is a _bare_ workspace without dependencies to CoreMedia Blueprint. It still leverages the new project workspace layout
and provides a target infrastructure as a starting point for integrating custom projects.

One major feature of CoreMedia 8 is localization. To provide you with this integration, you need to provide a special
document type, that represents the site model within the multi-site concept. You also need to integrate some specific document type
properties into your `DocType` hierarchy. Please visit the CoreMedia 8 manual for a detailed explanation. To enable this feature
within this _bare_ workspace, a minimal set of document types are provided.

CoreMedia Elastic Social and CoreMedia Adaptive Personalization functionality is out of scope of this workspace deliverable.
Please mind the CM8 supported operating environments before planning your migration efforts.

## Structure

The workspace is separated into four major directory hierarchies:

* The `modules` folder contains all library- and application-modules.

* The `packages` folder contains only deployment specific resources and modules. No compilation is done here.

* The `boxes` folder contains the infrastructure specific resources. No application packaging is done here.

* The `test-data` folder contains test content and test user definitions. Currently the test content is packaged by 
the boxes module.

## Vagrant Chef Setup

By moving all required services into a virtual environment, the Vagrant Chef Setup reduces the amount of 
installation prerequisites to start developing to a minimum that should not conflict with any other projects you are 
working on. See the "Getting Started" > "Prerequisites" section of the "CoreMedia 8 Manual" in the CoreMedia
[documentation](https://documentation.coremedia.com/cm8/overview/).

* [Prerequisites](https://documentation.coremedia.com/cm8/7.1.5-10/manuals/coremedia-en/webhelp/content/ch03s01.html).

* A short quickstart guide for the Vagrant Chef Setup, is described [here](./VAGRANTSETUP.md)

* An overview of all application links, is available [here](./OVERVIEW.md). 

Introduction
------------

Please read the [CoreMedia 8 Manual](https://documentation.coremedia.com/cm8/7.1.5-10/manuals/coremedia-en/webhelp/content/ch01.html)
of the CM8 distribution for a detailed description. Most features described there are also part of this
workspace. As a list of the most prominent ones, this includes:

* a workspace layout reflecting best practises in module structure including the
integration of the CoreMedia Project extensions, a mechanism that allows you to centralize the de/activation of a feature,
bundled as a set of maven modules, with a single dependency entry. For more information about this feature, see the section
"Project Extensions" in the "Concepts and Architecture" chapter of the project developer guide.

* a preconfigured build process from library jars to components to packages. For more information, see the section
 "Structure of the Workspace" in the "Concepts and Architecture" chapter of the project developer guide.

* a preconfigured virtualization setup to minimize the bootstrap process on your developer machine. For more information
 about this feature, see the section "Starting the Boxes" in the "Getting Started" chapter of the project developer guide.

* a preconfigured setup to start all applications from within the workspace. For a detailed step through, see the section
 "Starting the Components" in the "Getting started" chapter of the project developer guide.

 All preconfigured properties, like ports and application urls in this workspace are identical with the ones from CM7.
 Visit the appendices of the project developer guide for an overview of all important references.


Integrating your custom project
-------------------------------

Before you start your migration effort, make sure to follow the configuration steps listed in the "Configuration" section
of the "Getting Started" chapter of the project developer guide.

To guide you during the initial integration of your existing codebase into this workspace, we put hint tags and readme files into the poms
and into folders in the source tree. All hints within the code are tagged with ```[TODO: MIGRATION]```, the readme files are
all named ```readme.md```.

* [modules/cae/cae-base-lib/readme.md](modules/cae/cae-base-lib/readme.md)

* [modules/cae/cae-preview-webapp/readme.md](modules/cae/cae-preview-webapp/readme.md)

* [modules/cae/contentbeans/readme.md](modules/cae/contentbeans/readme.md)

* [modules/editor-components/doctype-icons/readme.md](modules/editor-components/doctype-icons/readme.md)

* [modules/editor-lib/doctype-icons/readme.md](modules/editor-components/editor-lib/readme.md)

* [modules/server/contentserver-component/readme.md](modules/server/contentserver-component/readme.md)

* [packages/apache-overlays/studio-apache/src/main/app/preview/readme.md](packages/apache-overlays/studio-apache/src/main/app/readme.md)

* [packages/apache-overlays/delivery-apache/src/main/app/live/readme.md](packages/apache-overlays/delivery-apache/src/main/app/readme.md)

* [modules/studio/readme.md](modules/studio/readme.md)

To make the migration easier for you, we left the major dependencies that you obviously need in the library modules, but commented them.
Since there is almost no code in the workspace to compile, the ```maven-dependency-plugin:analyze-only``` execution defined in the root ```pom.xml```
has been commented out to not fail your build. If you have migrated the code you should reactivate the plugins execution to
prevent your modules from degrading with unused or undeclared dependencies.

Document Model Requirements for Localization
----------------------

Since CoreMedia 8, there are some requirements to the document model of you project. Therefore a minimal document typo model is provided

