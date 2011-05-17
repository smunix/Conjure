//@+leo-ver=5-thin
//@+node:roobie.20110516104530.1334: * @file demofacade.d
module demo.demofacade;

import demo.controller.addaction;
import demo.controller.subtractaction;
import demo.model.commandproxy;
import demo.view.consoleagent;
import conjure.patterns.facade;
import tango.io.Console;

class DemoFacade : Facade
{
    private static DemoFacade instance;

    public static final TEST = "This is the identifier for the TestAction";

    protected this()
    {
        super();
        DemoFacade.instance = this;
    }

    static DemoFacade getInstance()
    {
        if(DemoFacade.instance is null)
        {
            return new DemoFacade();
        }
        return DemoFacade.instance;
    }

    void start()
    {
    }

    override void initializeModel()
    {
        super.initializeModel();
        this.registerProxy(new CommandProxy());
    }
    override void initializeView()
    {
        super.initializeView();
        this.registerAgent(new ConsoleAgent());
    }
    override void initializeController()
    {
        super.initializeController();
        this.registerAction(new AddAction());
        this.registerAction(new SubtractAction());
    }
}

void main()
{
    DemoFacade df = DemoFacade.getInstance();
    df.start();
}
//@-leo
