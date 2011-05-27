module conjure.core.controller;

import conjure.core.view;
import conjure.patterns.command;

class Controller
{
private:
    static Controller instance;
    static View view;
    final Command[char[]] commandMap;

protected:
    this(View view) {
        Controller.instance = this;
        Controller.view = view;
    }

public:
    static Controller getInstance(View view) {
        if (Controller.instance is null) {
            return new Controller(view);
        }
        return Controller.instance;
    }
    unittest {
        Controller controller0 = Controller.getInstance(View.getInstance());
        assert(controller0 is controller0);

        Controller controller1 = Controller.getInstance(View.getInstance());
        assert(controller0 is controller1);
    }

    bool registerCommand(char[] context, Command command) {
        try {
            if (this.commandMap[command.classinfo.name] is null) {
                this.commandMap[command.classinfo.name] = command;
                // addObserver
                return true;
            }
        } catch (Exception e) {}
        return false;
    }

    bool removeCommand(char[] commandClassName) {
        try {
            if (this.commandMap[commandClassName] !is null) {
                this.commandMap[commandClassName] = null;
                // removeObserver
                return true;
            }
        } catch (Exception e) {}
        return false;
    }
}
