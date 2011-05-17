//@+leo-ver=5-thin
//@+node:roobie.20110513155345.1316: * @file controller.d
module conjure.core.controller;

import conjure.patterns.action;

class Controller
{
    private static Controller instance;

    private final Action[char[]] actionMap;

    protected this()
    {
        Controller.instance = this;
    }

    static Controller getInstance()
    {
        if (Controller.instance is null)
        {
            return new Controller();
        }
        return Controller.instance;
    }
    unittest
    {
        Controller controller0 = Controller.getInstance();
        assert(controller0 is controller0);

        Controller controller1 = Controller.getInstance();
        assert(controller0 is controller1);
    }

    bool registerAction(Action action)
    {
        try
        {
            if (this.actionMap[action.getName()] is null)
            {
                this.actionMap[action.getName()] = action;
                return true;
            }
        }
        catch (Exception e) {}
        return false;
    }

    bool removeAction(char[] actionName)
    {
        try
        {
            if (this.actionMap[actionName] !is null)
            {
                this.actionMap[actionName] = null;
                return true;
            }
        }
        catch (Exception e) {}
        return false;
    }
}
//@-leo
