#!/bin/sh
export THIS_DIR=`dirname $0`

echo === DROP SCHEMAS ===
psql --username=postgres --dbname=coredining -f $THIS_DIR/drop-schemas.sql


