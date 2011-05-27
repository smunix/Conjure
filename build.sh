#!/bin/bash
#@+leo-ver=5-thin
#@+node:roobie.20110516180703.1361: * @file build.sh
#@@first

#@@language shell

if [ "$1" = "-unittest" ]
then
    rm -f bin/conjure /bin/conjure_demo
    dsss clean && dsss build -unittest

    cd src/demo

    dsss clean && dsss build -unittest

    cd ../../

    ./bin/conjure && ./bin/conjure_demo

else
    rm -f bin/conjure /bin/conjure_demo
    dsss clean && dsss build -unittest

    cd src/demo

    dsss clean && dsss build -unittest

    cd ../../

fi
#@-leo
