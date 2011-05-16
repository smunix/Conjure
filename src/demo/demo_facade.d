//@+leo-ver=5-thin
//@+node:roobie.20110516104530.1334: * @file demo_facade.d
module demo.facade;

import conjure.patterns.facade;

class DemoFacade : Facade
{
    private static DemoFacade instance;

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
}

void main(char[][] args)
{
    if (args !is null)
    {
        Cout("No args accepted. Please try again using no args").newline;
    }
    DemoFacade df = DemoFacade.getInstance();
    df.start();
}
//@-leo
