#!/bin/sh
export THIS_DIR=`dirname $0`
$THIS_DIR/create-users.sh
$THIS_DIR/create-database.sh
$THIS_DIR/create-schemas.sh
echo "Done."

