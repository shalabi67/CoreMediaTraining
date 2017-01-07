Contentserver component
========================

This module is the component being deployed in all contentservers. Therefore you can place your doctype definitions here.
They should be placed in a folder ```src/main/resources/framework/doctypes``` or any folder below that root. The
`custom-doctype.xml` contains a minimal set of document types to run the CoreMedia Components. These document types are
 must not necessary exist, but there must be a similar document type with the characteristic properties for localization and
 multisite.

[custom-doctypes.xml](src/main/resources/framework/doctypes/custom/custom-doctypes.xml)

* `CMObject`
* `CMLocalized`
* `CMSettings` - The CoreMedia Studio requires a document type to store the locale settings. The name is arbitrary but path and
    propertyname must be configured. The test content can be found in [LocaleSettings.xml](../../../test-data/content/Settings/LocaleSettings.xml).
* `CMSite` - This document type or a similar one is needed for applications requiring the site service.