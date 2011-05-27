module conjure.patterns.observer;
import conjure.patterns.message;

abstract class Observable
{
protected:
    final Observer[][char[]] observerMap;

public:
    void addObserver(char[] context, Observer observer) {
        bool exists;
        try {
            while (exists == false) {
                foreach (Observer o; observerMap[context]) {
                    if (o is observer) {
                        exists = true;
                    }
                }
            }
        } catch (Exception e) {}

        if (!exists) {
            observerMap[context] ~= observer;
        }
    }

    void removeObserver(char[] context, Observer observer) {
        bool exists;

        try {
            while (exists == false) {
                for (int i; i < observerMap[context].length; i++) {
                    if (observerMap[context][i] is observer) {
                        observerMap[context][i] = null;
                        exists = true;
                    }
                }
            }
        } catch (Exception e) {}
    }

    void notifyObservers(char[] context, Message msg) {
        if(observerMap[context].length != 0) {
            foreach (Observer o; observerMap[context]) {
                o.update(this, msg);
            }
        }
    }
}

interface Observer {
public:
    void update(Observable observable, Message msg);
}
