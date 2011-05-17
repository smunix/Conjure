//@+leo-ver=5-thin
//@+node:roobie.20110516104530.1330: * @file agent.d
module conjure.patterns.agent;

import conjure.patterns.facade;

class Agent
{
    private final char[] NAME = "BaseAgent";
    protected Facade facade;

    this()
    {
        facade = Facade.getInstance();
    }

    char[] getName()
    {
        return this.NAME;
    }

    Facade getFacade()
    {
        return this.facade; 
    }
}
//@-leo
