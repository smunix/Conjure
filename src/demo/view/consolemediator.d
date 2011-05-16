//@+leo-ver=5-thin
//@+node:roobie.20110516180703.1358: * @file consolemediator.d
module demo.view.consoleagent;

import conjure.patterns.agent;
import demo.view.components.console;

class ConsoleAgent : Agent
{
    private static final NAME = "ConsoleAgent";
    private final Console component;

    this()
    {
        this.component = new Console(this);
    }

    void exec(char[] cmd)
    {

    }
}
//@-leo
