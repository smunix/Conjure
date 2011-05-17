//@+leo-ver=5-thin
//@+node:roobie.20110513155345.1315: * @file view.d
module conjure.core.view;

import conjure.patterns.agent;
import conjure.patterns.action;
import conjure.patterns.observer;

class View : Observable
{
    private static View instance;

    private final Agent[char[]] agentMap;

    protected this()
    {
        View.instance = this;
    }

    synchronized Agent registerAgent(Agent agentObject)
    {
        Agent a = agentObject;
        this.agentMap[a.getName()] = a;
        return a;
    }
    unittest
    {
        View v = View.getInstance();
        Agent a = new Agent();
        assert(v.registerAgent(a) is a);
        assert(v.agentMap[a.getName()] !is null);
    }

    Agent retrieveAgent(char[] agentName)
    {
        return this.agentMap[agentName];
    }
    unittest
    {
        View v = View.getInstance();
        Agent a = new Agent();
        v.registerAgent(a);
        assert(v.retrieveAgent(a.getName()) is a);
    }

    Agent removeAgent(char[] agentName)
    {
        Agent agent = this.agentMap[agentName];
        this.agentMap[agentName] = null;
        return agent;
    }
    unittest
    {
        View v = View.getInstance();
        Agent a = new Agent();
        v.registerAgent(a);
        assert(v.removeAgent(a.getName()) is a);
        assert(v.agentMap[a.getName()] is null);
    }

    static View getInstance()
    {
        if (View.instance is null)
        {
            return new View();
        }
        return View.instance;
    }
    unittest
    {
        View view0 = View.getInstance();
        assert(view0 is view0);

        View view1 = View.getInstance();
        assert(view0 is view1);
    }

    /**
        Testing super class (Observable)
     */
    unittest
    {
        Action a = new Action();
        View v = View.getInstance();
        v.addObserver("Test", a);
        assert(v.observerMap["Test"][0] is a);

        v.removeObserver("Test", a);
        assert(v.observerMap["Test"][0] is null);
    }
}
//@-leo
