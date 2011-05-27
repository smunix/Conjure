module conjure.core.view;

class View
{
private:
    static View instance;
    final Object[char[]] viewElementMap;

protected:
    this() {
        View.instance = this;
    }

public:
    synchronized Object registerViewElement(Object viewElement) {
        this.viewElementMap[viewElement.classinfo.name] = viewElement;
        return viewElement;
    }
    unittest {
        View v = View.getInstance();
        Object a = new Object();
        assert(v.registerViewElement(a) is a);
        assert(v.viewElementMap[a.classinfo.name] !is null);
    }

    Object retrieveViewElement(char[] agentName) {
        return this.viewElementMap[agentName];
    }
    unittest {
        View v = View.getInstance();
        Object a = new Object();
        v.registerViewElement(a);
        assert(v.retrieveViewElement(a.classinfo.name) is a);
    }

    Object removeViewElement(char[] agentName) {
        Object agent = this.viewElementMap[agentName];
        this.viewElementMap[agentName] = null;
        return agent;
    }
    unittest {
        View v = View.getInstance();
        Object a = new Object();
        v.registerViewElement(a);
        assert(v.removeViewElement(a.classinfo.name) is a);
        assert(v.viewElementMap[a.classinfo.name] is null);
    }

    static View getInstance() {
        if (View.instance is null) {
            return new View();
        }
        return View.instance;
    }
    unittest {
        View view0 = View.getInstance();
        assert(view0 is view0);

        View view1 = View.getInstance();
        assert(view0 is view1);
    }
}
