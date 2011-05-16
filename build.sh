#!/bin/sh
#@+leo-ver=5-thin
#@+node:roobie.20110516180703.1361: * @file build.sh
#@@first

#@@language shell

dsss clean && dsss build -unittest

cd src/demo

dsss clean && dsss build -unittest

cd ../../

./bin/conjure && ./bin/conjure_demo

#@-leo
