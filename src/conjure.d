//@+leo-ver=5-thin
//@+node:roobie.20110513155345.1304: * @file conjure.d
module conjure;

import tango.io.Console;
import tango.util.log.Log;
import tango.util.log.AppendConsole;

import patterns.facade;

void main ()
{
    auto logger = Log.lookup("conjure");
    logger.level = logger.Trace;

    logger.add(new AppendConsole);
    logger.trace("Testing the logger...");

    Facade facade = cast(Facade)Facade.getInstance();
    logger.trace(facade.toString());
}
//@-leo
