#!/bin/sh
export THIS_DIR=`dirname $0`

echo === CREATE LOGIN ROLES ===
psql --username=postgres -f $THIS_DIR/create-users.sql

