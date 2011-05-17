//@+leo-ver=5-thin
//@+node:roobie.20110516180703.1358: * @file consoleagent.d
module demo.view.consoleagent;

import conjure.patterns.agent;
import conjure.patterns.message;
import conjure.patterns.facade;
import demo.view.components.console;
import demo.demofacade;

class ConsoleAgent : Agent
{
    private static final NAME = "ConsoleAgent";
    private final Console component;

    this()
    {
        super();
        this.component = new Console(this);
    }

    void exec(char[] cmd)
    {
        this.getFacade.sendMessage(DemoFacade.TEST
            , new Message("Command line args", cmd, null));
    }

    unittest
    {
        ConsoleAgent ca = new ConsoleAgent();

        assert(ca.getFacade() is Facade.getInstance());
    }
}
//@-leo
