#!/bin/bash

set -e

# global check
if @postconfiguration.enable@ ; then
  which java || (logger -p syslog.err -t coremedia/rpm -s "No java on path $PATH, cannot run reconfigure without java"; exit 1)
fi

# $1 == 1 --> initial installation
# $1 == 2 --> upgrade

if [ $1 -eq 1 ] ; then
  # initial installation

  # configure environment
  if test -d @INSTALL_ROOT@; then
    find @INSTALL_ROOT@ -xdev | xargs chown @INSTALL_USER@:@INSTALL_GROUP@
  else
     mkdir -p @INSTALL_ROOT@
  fi

  # Add the "@INSTALL_USER@" user, on Solaris you should replace /usr/sbin/nologin with /usr/bin/false
  /usr/sbin/useradd -c "system user to run coremedia services and applications" -s /bin/bash -m -d @INSTALL_ROOT@ -r @INSTALL_USER@ 2> /dev/null || :

  #Create configure dir
  if test -d @CONFIGURE_ROOT@; then
    chown -R root:root @CONFIGURE_ROOT@
  else
    mkdir -p @CONFIGURE_ROOT@
  fi

  #Create logging dir
  if test -d @LOG_ROOT@; then
    chown -R @INSTALL_USER@:@INSTALL_GROUP@ @LOG_ROOT@
  else
    mkdir -p @LOG_ROOT@
    chown -R @INSTALL_USER@:@INSTALL_GROUP@ @LOG_ROOT@
  fi

  #Create PID dir
  if test -d @PID_ROOT@; then
    chown -R @INSTALL_USER@:@INSTALL_GROUP@ @PID_ROOT@
  else
    mkdir -p @PID_ROOT@
    chown -R @INSTALL_USER@:@INSTALL_GROUP@ @PID_ROOT@
  fi

  #Create tmp dir
  if test -d @TMP_ROOT@; then
    chown -R @INSTALL_USER@:@INSTALL_GROUP@ @TMP_ROOT@
  else
    mkdir -p @TMP_ROOT@
    chown -R @INSTALL_USER@:@INSTALL_GROUP@ @TMP_ROOT@
  fi
fi

#if [ $1 -gt 1 ] ; then
# upgrade installation
#fi

