#!/bin/sh
export THIS_DIR=`dirname $0`

echo === DROP DATABASE ===
psql --username=postgres -f $THIS_DIR/drop-database.sql


