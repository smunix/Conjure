//@+leo-ver=5-thin
//@+node:roobie.20110513155345.1304: * @file conjure.d
module conjure.main;

import tango.io.Console;
import tango.util.log.Log;
import tango.util.log.AppendConsole;

import conjure.patterns.facade;

void main ()
{
    auto logger = Log.lookup("main");
    logger.add(new AppendConsole);
    logger.info("Hello Tango.Log!");
}
//@-leo
