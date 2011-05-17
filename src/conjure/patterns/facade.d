//@+leo-ver=5-thin
//@+node:roobie.20110513155345.1312: * @file facade.d
module conjure.patterns.facade;

import conjure.core.model;
import conjure.core.view;
import conjure.core.controller;

import conjure.patterns.proxy;
import conjure.patterns.agent;
import conjure.patterns.action;
import conjure.patterns.message;

/**
    The facade is the singleton, which acts as a representative
    for the core actors. All communication should go through
    this.

    Implements all public methods/functions of the core
    actors.
*/
class Facade
{
    private static Facade      instance;
    private static Model       model;
    private static View        view;
    private static Controller  controller;

    protected this()
    {
        Facade.instance = this;
        this.initializeFacade();
    }

    /**
        Singleton factory for Facade. 
     */
    static Facade getInstance()
    {
        if (Facade.instance is null)
        {
            return new Facade();
        }
        return Facade.instance;
    }
    unittest
    {
        Facade facade0 = Facade.getInstance();
        assert(facade0 is facade0);

        Facade facade1 = Facade.getInstance();
        assert(facade0 is facade1);
    }

    protected void initializeFacade()
    {
        Facade.model = Model.getInstance();
        Facade.view = View.getInstance();
        Facade.controller = Controller.getInstance();

        this.initializeModel();
        this.initializeView();
        this.initializeController();
    }
    unittest
    {
        Facade facade = Facade.getInstance();

        assert(facade.model !is null);
        assert(facade.model is Model.getInstance());

        assert(facade.view !is null);
        assert(facade.view is View.getInstance());

        assert(facade.controller !is null);
        assert(facade.controller is Controller.getInstance());
    }

    /**
        Use this to register proxies at startup
     */
    protected void initializeModel()
    {
    }

    /**
        Use this to register agents at startup
     */
    protected void initializeView()
    {
    }

    /**
        Use this to execute strategies at startup
     */
    protected void initializeController()
    {
    }

    /// Facade to model-functions
    synchronized Proxy registerProxy(Proxy proxyObject)
    {
        return Facade.model.registerProxy(proxyObject);
    }

    Proxy retrieveProxy(char[] proxyName)
    {
        return Facade.model.retrieveProxy(proxyName);
    }

    Proxy removeProxy(char[] proxyName)
    {
        return Facade.model.removeProxy(proxyName);
    }

    /// Facade to view-functions
    synchronized Agent registerAgent(Agent agentObject)
    {
        return Facade.view.registerAgent(agentObject);
    }

    Agent retrieveAgent(char[] agentName)
    {
        return Facade.view.retrieveAgent(agentName);
    }

    Agent removeAgent(char[] agentName)
    {
        return Facade.view.removeAgent(agentName);
    }

    /// Facade to controller-functions
    bool registerAction(Action actionObject)
    {
        return Facade.controller.registerAction(actionObject);
    }
    bool removeAction(Action actionObject)
    {
        return removeAction(actionObject);
    }
    void sendMessage(char[] actionName, Message msg)
    {
        Facade.view.notifyObservers(actionName, msg);
    }
}
//@-leo
