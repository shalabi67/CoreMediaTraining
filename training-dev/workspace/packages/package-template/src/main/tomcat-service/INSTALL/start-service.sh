#!/bin/bash
#
# Init file for @APPLICATION_NAME@
#
# chkconfig: @SERVICE_START_LEVELS@ @SERVICE_START_PRIOPRITY@ @SERVICE_STOP_PRIORITY@
# description: @project.description@.
# processname: @APPLICATION_NAME@
# pidfile: @PID_ROOT@/@APPLICATION_NAME@.pid
# config: @CONFIGURE_ROOT@/@APPLICATION_NAME@.conf

TOMCAT_CONFIG=@CONFIGURE_ROOT@/@APPLICATION_NAME@.conf
test -r $TOMCAT_CONFIG || { echo "$TOMCAT_CONFIG not existing";
        if [ "$1" = "stop" ]; then exit 0;
        else exit 6; fi; }

# Read config
. $TOMCAT_CONFIG
export CATALINA_HOME CATALINA_OUT CATALINA_PID CATALINA_TMPDIR CATALINA_BASE JAVA_HOME
test -x $CATALINA_HOME || { echo "TOMCAT providing CATALINA_HOME not installed at $CATALINA_HOME";
        if [ "$1" = "stop" ]; then exit 0;
        else exit 5; fi; }

test -x $CATALINA_BASE || { echo "TOMCAT providing CATALINA_BASE not installed at $CATALINA_BASE";
        if [ "$1" = "stop" ]; then exit 0;
        else exit 5; fi; }

RETVAL=0

printStatus(){
  echo -ne "\t\t\t [ "
  if test $1 == 0; then
    echo -ne "\e[0;92mOK"
  else
    echo -ne "\e[0;31mERROR"
  fi
  tput sgr0
  echo " ]"
}

start(){
  echo -ne "Starting @APPLICATION_NAME@"
  su @INSTALL_USER@ -c '$CATALINA_HOME/bin/catalina.sh start' &>/dev/null
  RETVAL=$?
  printStatus $RETVAL
  [ $RETVAL = 0 ] && touch /var/lock/subsys/@APPLICATION_NAME@
}
stop(){
  echo -ne "Stopping @APPLICATION_NAME@"
  su @INSTALL_USER@ -c '$CATALINA_HOME/bin/catalina.sh stop -force' &>/dev/null
  RETVAL=$?
  printStatus $RETVAL
  [ $RETVAL = 0 ] && rm -f /var/lock/subsys/@APPLICATION_NAME@
}
reconfigure(){
 if @postconfiguration.enable@ ; then
    su @INSTALL_USER@ -c '@APPLICATION_INSTALL_ROOT@/INSTALL/reconfigure.sh @APPLICATION_NAME@ @APPLICATION_INSTALL_ROOT@'
 else
   echo "reconfigure not supported with preconfigured rpms"
 fi
}
case "$1" in
start)
  start
  ;;
restart)
  stop
  sleep 10
  start
  ;;
reload)
  stop
  sleep 10
  reconfigure
  start
  ;;
stop)
  stop
  ;;
status)
  if test -f "$CATALINA_PID"
  then
    if ps -f --pid $(cat $CATALINA_PID) | grep org.apache.catalina.startup.Bootstrap | grep -v -q grep
    then
      echo "Tomcat @APPLICATION_NAME@ is running with pid: $(cat $CATALINA_PID)"
      exit 0
    else
      echo "Tomcat @APPLICATION_NAME@ pid file exist but no process with id $(cat $CATALINA_PID) is running"
      exit 4
    fi
  else
    echo "Tomcat @APPLICATION_NAME@ is stopped, no PID file found at $CATALINA_PID"
    exit 3
  fi
;;
reconfigure)
 reconfigure
 ;;
*)
  echo "Usage: $0 {start|stop|restart|status|reconfigure|reload}"
  exit 1
	;;
esac

exit $RETVAL
