name             'blueprint-yum'
maintainer       ''
maintainer_email ''
license          ''
description      'Configures yum repositories'
long_description 'Configures yum repositories'
version          '0.1.0'
depends          'yum', '= 3.3.2'
depends          'yum-centos', '= 0.3.0'
depends          'yum-mysql-community', '= 0.1.10'

supports 'redhat'
supports 'centos'
supports 'scientific'
supports 'amazon'
supports 'fedora'
