package org.g19.mvc.conjure.triad;

import java.util.HashMap;

import org.g19.mvc.conjure.interfaces.ICommand;
import org.g19.mvc.conjure.interfaces.IController;
import org.g19.mvc.conjure.interfaces.IFunction;
import org.g19.mvc.conjure.interfaces.INotification;
import org.g19.mvc.conjure.interfaces.IView;
import org.g19.mvc.conjure.patterns.observer.Observer;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class Controller implements IController {
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
	protected IView view;
	protected HashMap<String, ICommand> commandMap;

	// /////////////////////////////////////////////////////////////////////////
	//
	// Constructors
	//
	// /////////////////////////////////////////////////////////////////////////
	@Inject
	protected Controller(IView view) {
		this.setCommandMap(new HashMap<String, ICommand>());
		this.setView(view);
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Methods
	//
	// /////////////////////////////////////////////////////////////////////////
	@Override
	public void registerCommand(String notificationName, ICommand command) {
		if (null != this.getCommandMap().put(notificationName, command))
			return;

		this.getView().registerObserver(notificationName,
				new Observer(new IFunction() {
					public void onNotification(INotification notification) {
						executeCommand(notification);
					}
				}, this));
	}

	@Override
	public void executeCommand(INotification notification) {
		ICommand commandInstance = (ICommand) this.getCommandMap().get(
				notification.getName());
		if (commandInstance != null) {
			commandInstance.execute(notification);
		}
	}

	@Override
	@Inject
	public void removeCommand(String notificationName) {
		// if the Command is registered...
		if (hasCommand(notificationName)) {
			// remove the observer
			getView().removeObserver(notificationName, this);
			getCommandMap().remove(notificationName);
		}
	}

	@Override
	public boolean hasCommand(String notificationName) {
		return commandMap.containsKey(notificationName);
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Accessors & factories
	//
	// /////////////////////////////////////////////////////////////////////////
	protected HashMap<String, ICommand> getCommandMap() {
		return commandMap;
	}

	protected void setCommandMap(HashMap<String, ICommand> commandMap) {
		this.commandMap = commandMap;
	}

	protected IView getView() {
		return view;
	}

	protected void setView(IView view) {
		this.view = view;
	}

}
