#!/bin/sh
export THIS_DIR=`dirname $0`

echo === DROP LOGIN ROLES ===
psql --username=postgres -f $THIS_DIR/drop-users.sql