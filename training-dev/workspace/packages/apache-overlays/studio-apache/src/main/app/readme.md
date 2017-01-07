Apache CAE rewrite rules
=========================

For each site, you should put your virtual host config and your rewrite rules into separate folders and include them in the
[packages/apache-overlays/studio-apache/src/main/app/studio-apache.conf](studio-apache.conf).

If you strive for a different layout, you can do this but you need to be aware that the RPM/Zip installation mechanism is
preconfigured for this layout and it may take some while to adapt the setup to your needs.

To make the apache configuration postconfigurable you need outfit it with some filtertokens, e.g. :

* ```@STUDIO_APACHE_HTTP_PORT@``` for the HTTP port of this apache
* ```@STUDIO_TLD@``` for the top level domain of this website
* ```@STUDIO_JVM_ROUTE@``` for the Tomcat JVM Route parameter
* ```@STUDIO_APACHE_LOG_DIR@``` for the logging directory of this virtual host.

