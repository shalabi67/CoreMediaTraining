#!/bin/bash
# $1 == 1 --> initial installation
# $1 == 2 --> upgrade
set -e
if @postconfiguration.enable@ ; then
  @APPLICATION_INSTALL_ROOT@/INSTALL/install-config.sh
  su @INSTALL_USER@ -c '@APPLICATION_INSTALL_ROOT@/INSTALL/reconfigure.sh @APPLICATION_NAME@ @APPLICATION_INSTALL_ROOT@'
fi

if [ $1 -eq 1 ]; then

  #Create logging dir
  if test -d @APPLICATION_LOG_DIR@; then
    chown -R @INSTALL_USER@:@INSTALL_GROUP@ @APPLICATION_LOG_DIR@
  else
    mkdir -p @APPLICATION_LOG_DIR@
    chown -R @INSTALL_USER@:@INSTALL_GROUP@ @APPLICATION_LOG_DIR@
  fi

  #Create tmp dir
  if test -d @TMP_ROOT@/@APPLICATION_NAME@; then
    chown -R @INSTALL_USER@:@INSTALL_GROUP@ @TMP_ROOT@/@APPLICATION_NAME@
  else
    mkdir -p @TMP_ROOT@/@APPLICATION_NAME@
    chown -R @INSTALL_USER@:@INSTALL_GROUP@ @TMP_ROOT@/@APPLICATION_NAME@
  fi

  cp @APPLICATION_INSTALL_ROOT@/INSTALL/start-service.sh /etc/init.d/@APPLICATION_NAME@
  chmod 700 /etc/init.d/@APPLICATION_NAME@

  cp @APPLICATION_INSTALL_ROOT@/INSTALL/catalina-config.sh @CONFIGURE_ROOT@/@APPLICATION_NAME@.conf
  chmod 644 @CONFIGURE_ROOT@/@APPLICATION_NAME@.conf

  # Register as service
  chkconfig @APPLICATION_NAME@ on

fi

#if [ $1 -gt 1 ]; then
#do nothing
#fi
