//@+leo-ver=5-thin
//@+node:roobie.20110516180703.1363: * @file action.d
module conjure.patterns.action;

import conjure.patterns.facade;
import conjure.patterns.message;
import conjure.patterns.observer;

class Action : Observer
{
    private static Facade facade;
    private static final char[] NAME = "BaseAction";

    this()
    {
        facade  = Facade.getInstance();
    }

    void execute(Message msg) {}

    void update(Observable observable, Message msg)
    {
        this.execute(msg);
    }

    char[] getName()
    {
        return Action.NAME;
    }

    protected Facade getFacade()
    {
        return Action.facade;
    }
}
//@-leo
