# IDE Configuration

This module contains configuration files that can be used with Intellij Idea.

## Preview_CAE_Tomcat_7.xml
You can easily run a CAE Webapp from Idea.
Development becomes much easier because Idea can deploy changed classes and files (e.g. templates) into the running Tomcat.


An external Tomcat installation is needed, Idea does not supply one.
You may either download a separate Tomcat 7 installation, or build the module packages/tomcat-installation and use the Tomcat libraries in the target directory.
If you do the latter, you'll always use the Tomcat version that will be used in the RPMs/deployment.
See [Idea Help: Application Servers][1]


Idea will use/read the startup scripts from the Tomcat installation.
This will potentially overwrite e.g. the "VM options" from the run configuration.


Copy the file to <project_home>/.idea/runConfigurations/.
Go to the run configurations and edit "Preview CAE Tomcat 7".
Learn more about Tomcat run configurations [here][2]


Change heap size and / or the host configuration in the dialog.

[1]:    http://www.jetbrains.com/idea/webhelp/application-servers.html                                    "Idea Help: Application Servers"
[2]:    http://www.jetbrains.com/idea/webhelp/run-debug-configuration-tomcat.html                         "Idea Help: Run Configuration Tomcat"
