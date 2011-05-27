module conjure.core.model;

class Model
{
private:
    static Model instance;
    final Object[char[]] componentMap;

protected:
    this() {
        Model.instance = this;
    }

public:
    synchronized Object registerComponent(Object component) {
        this.componentMap[component.classinfo.name] = component;
        return component;
    }
    unittest {
        Model m = Model.getInstance();
        Object o = new Object();
        assert(m.registerComponent(o) is o);
        assert(m.componentMap[o.classinfo.name] !is null);
    }

    Object retrieveComponent(char[] componentClassName) {
        return this.componentMap[componentClassName];
    }
    unittest {
        Model m = Model.getInstance();
        Object o = new Object();
        m.registerComponent(o);
        assert(m.retrieveComponent(o.classinfo.name) is o);
    }

    Object removeComponent(char[] componentClassName) {
        Object component = this.componentMap[componentClassName];
        this.componentMap[componentClassName] = null;
        return component;
    }
    unittest {
        Model m = Model.getInstance();
        Object o = new Object();
        m.registerComponent(o);
        assert(m.removeComponent(o.classinfo.name) is o);
        assert(m.componentMap[o.classinfo.name] is null);
    }

    /**
        Singleton factory for Model.
     */
    static Model getInstance() {
        if (Model.instance is null) {
            return new Model();
        }
        return Model.instance;
    }
    unittest {
        Model model0 = Model.getInstance();
        assert(model0 is model0);

        Model model1 = Model.getInstance();
        assert(model1 is model0);
    }
}
