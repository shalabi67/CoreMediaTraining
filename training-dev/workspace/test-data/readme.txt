This folder is the place where you can put content that should be imported automatically, when using the virtualization
infrastructure with Vagrant and VirtualBox. Place content below the "content" folder and a "users.xml" below the "users"
folder to import predefined users.

When you build the "boxes" module the content of this folder will be packaged into a content-users.zip for automatic
provisioning. You can override the maven property "blueprint.testdata.dir" to an absolute path using either:
* a Maven profile in the project.
* a Maven profile in your Maven settings.xml.
* a Java system property on the command line.
