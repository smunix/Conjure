//@+leo-ver=5-thin
//@+node:roobie.20110513155345.1314: * @file model.d
module conjure.core.model;

import conjure.patterns.proxy;

class Model
{
    private static Model instance;

    private final Proxy[char[]] proxyMap;

    protected this()
    {
        Model.instance = this;
    }

    synchronized Proxy registerProxy(Proxy proxyObject)
    {
        Proxy p = proxyObject;
        this.proxyMap[p.getName()] = p;
        return p;
    }
    unittest
    {
        Model m = Model.getInstance();
        Proxy p = new Proxy();
        assert(m.registerProxy(p) is p);
        assert(m.proxyMap[p.getName()] !is null);
    }

    Proxy retrieveProxy(char[] proxyName)
    {
        return this.proxyMap[proxyName];
    }
    unittest
    {
        Model m = Model.getInstance();
        Proxy p = new Proxy();
        m.registerProxy(p);
        assert(m.retrieveProxy(p.getName()) is p);
    }

    Proxy removeProxy(char[] proxyName)
    {
        Proxy proxy = this.proxyMap[proxyName];
        this.proxyMap[proxyName] = null;
        return proxy;
    }
    unittest
    {
        Model m = Model.getInstance();
        Proxy p = new Proxy();
        m.registerProxy(p);
        assert(m.removeProxy(p.getName()) is p);
        assert(m.proxyMap[p.getName()] is null);
    }

    /**
        Singleton factory for Model.
     */
    static Model getInstance()
    {
        if (Model.instance is null)
        {
            return new Model();
        }
        return Model.instance;
    }
    unittest
    {
        Model model0 = Model.getInstance();
        assert(model0 is model0);

        Model model1 = Model.getInstance();
        assert(model1 is model0);
    }
}
//@-leo
