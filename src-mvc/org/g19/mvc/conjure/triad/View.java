package org.g19.mvc.conjure.triad;

import java.util.HashMap;
import java.util.List;

import org.g19.mvc.conjure.interfaces.IMediator;
import org.g19.mvc.conjure.interfaces.INotification;
import org.g19.mvc.conjure.interfaces.IObserver;
import org.g19.mvc.conjure.interfaces.IView;
import org.g19.mvc.conjure.patterns.observer.Observer;

import com.google.inject.Singleton;

@Singleton
public class View implements IView {
	// /////////////////////////////////////////////////////////////////////////
	//
	// Static variables
	//
	// /////////////////////////////////////////////////////////////////////////

	// /////////////////////////////////////////////////////////////////////////
	//
	// Instance variables
	//
	// /////////////////////////////////////////////////////////////////////////
	protected HashMap<String, IMediator> mediatorMap;
	protected HashMap<String, List<IObserver>> observerMap;

	// /////////////////////////////////////////////////////////////////////////
	//
	// Constructors
	//
	// /////////////////////////////////////////////////////////////////////////
	protected View() {
		this.setMediatorMap(new HashMap<String,IMediator>());
		this.setObserverMap(new HashMap<String,List<IObserver>>());
		
		initializeView();
	}
	// /////////////////////////////////////////////////////////////////////////
	//
	// Methods
	//
	// /////////////////////////////////////////////////////////////////////////
	protected void initializeView() {
		
	}
	@Override
	public void registerObserver(String noteName, IObserver observer) {
		// TODO Auto-generated method stub

	}

	public void removeObserver(String notificationName, Object notifyContext) {
		// the observer list for the notification under inspection
		List<IObserver> observers = observerMap.get(notificationName);

		if (observers != null) {
			// find the observer for the notifyContext
			for (int i = 0; i < observers.size(); i++) {
				Observer observer = (Observer) observers.get(i);
				if (observer.compareNotifyContext(notifyContext) == true)
					observers.remove(observer);
			}

			// Also, when a Notification's Observer list length falls to
			// zero, delete the notification key from the observer map
			if (observers.size() == 0)
				observerMap.remove(notificationName);
		}
	}

	@Override
	public void notifyObservers(INotification note) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerMediator(IMediator mediator) {
		// TODO Auto-generated method stub

	}

	@Override
	public IMediator retrieveMediator(String mediatorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMediator removeMediator(String mediatorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasMediator(String mediatorName) {
		// TODO Auto-generated method stub
		return false;
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Accessors & factories
	//
	// /////////////////////////////////////////////////////////////////////////
	protected HashMap<String, IMediator> getMediatorMap() {
		return mediatorMap;
	}
	protected void setMediatorMap(HashMap<String, IMediator> mediatorMap) {
		this.mediatorMap = mediatorMap;
	}
	protected HashMap<String, List<IObserver>> getObserverMap() {
		return observerMap;
	}
	protected void setObserverMap(HashMap<String, List<IObserver>> observerMap) {
		this.observerMap = observerMap;
	}

}
