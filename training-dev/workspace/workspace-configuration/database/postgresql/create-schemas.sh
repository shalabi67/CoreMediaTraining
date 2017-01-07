#!/bin/sh
export THIS_DIR=`dirname $0`

echo === CREATE SCHEMAS ===
psql --username=postgres --dbname=coredining -f $THIS_DIR/create-schemas.sql

