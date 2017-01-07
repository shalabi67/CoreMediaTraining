#!/bin/sh
export THIS_DIR=`dirname $0`

echo === CREATE DATABASE ===
psql --username=postgres -f $THIS_DIR/create-database.sql
