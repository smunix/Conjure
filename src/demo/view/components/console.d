//@+leo-ver=5-thin
//@+node:roobie.20110516104530.1342: * @file console.d
module demo.view.components.console;

import tango.io.Console;
import tango.util.log.Log;
import tango.util.log.AppendConsole;
import tango.text.Regex;

import demo.view.consoleagent;


class Console
{
    private final ConsoleAgent agent;

    this(ConsoleAgent ca)
    {
        this.agent = ca;
        Cout("Hello. This is a demo CLI app for Conjure MVC...").newline;
    }

    void run()
    {
        char[] response = "";
        auto regex = new Regex("[E|e][X|x][I|i][T|t]");

        while (regex.test(response) != true)
        {
            Cout("Please let me calculate an integer addition or subtraction (type exit to quit)").newline;

            response = Cin.get();
            if (regex.test(response) != true)
            {
                this.agent.exec(response);
            }
        }

        Cout("Bye ...").newline;
    }
}
//@-leo
