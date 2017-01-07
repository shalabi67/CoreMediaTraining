#!/bin/sh
export THIS_DIR=`dirname $0`
$THIS_DIR/drop-schemas.sh
$THIS_DIR/drop-database.sh
$THIS_DIR/drop-users.sh
echo "Done."