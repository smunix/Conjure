module conjure.patterns.command;

//import conjure.patterns.facade;
import conjure.patterns.message;
import conjure.patterns.observer;
import conjure.patterns.strategy;

class Command
{
protected:
    void execute(Message msg) {}

public:
    void callback(Strategy strat) {}

    void update(Observable observable, Message msg) {
        this.execute(msg);
    }
}
