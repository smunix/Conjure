/*
 PureMVC Java port by Frederic Saunier <frederic.saunier@puremvc.org>
 
 Adapted from sources of thoses different authors :
 	Donald Stinchfield <donald.stinchfield@puremvc.org>, et all
 	Ima OpenSource <opensource@ima.eu>
 	Anthony Quinault <anthony.quinault@puremvc.org>
 
 PureMVC - Copyright(c) 2006-10 Futurescale, Inc., Some rights reserved. 
 Your reuse is governed by the Creative Commons Attribution 3.0 License
 
 This file is modified by:
 	Björn Roberg (bjorn.roberg@gmail.com)
 the changes are not in any way supported or endorsed by the original author(s).
*/
/**
 * Copyright [2011] [Björn Roberg (bjorn.roberg@gmail.com)]
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.g19.mvc.conjure.patterns.facade;

import org.g19.mvc.conjure.core.ConjureModule;
import org.g19.mvc.conjure.interfaces.ICommand;
import org.g19.mvc.conjure.interfaces.IController;
import org.g19.mvc.conjure.interfaces.IFacade;
import org.g19.mvc.conjure.interfaces.IMediator;
import org.g19.mvc.conjure.interfaces.IModel;
import org.g19.mvc.conjure.interfaces.INotification;
import org.g19.mvc.conjure.interfaces.IProxy;
import org.g19.mvc.conjure.interfaces.IView;
import org.g19.mvc.conjure.patterns.observer.Notification;
import org.g19.mvc.conjure.triad.Controller;
import org.g19.mvc.conjure.triad.Model;
import org.g19.mvc.conjure.triad.View;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

@Singleton
public class Facade implements IFacade {
	// /////////////////////////////////////////////////////////////////////////
	//
	// Instance variables
	//
	// /////////////////////////////////////////////////////////////////////////
	/**
	 * Reference to the Controller
	 */
	private IController controller;

	/**
	 * Reference to the Model
	 */
	private IModel model;

	/**
	 * Reference to the View
	 */
	private IView view;

	// /////////////////////////////////////////////////////////////////////////
	//
	// Constructors
	//
	// /////////////////////////////////////////////////////////////////////////
	@Inject
	protected Facade() {
		Injector injector = Guice.createInjector(new ConjureModule());
		this.setController(injector.getInstance(Controller.class));
		this.setModel(injector.getInstance(Model.class));
		this.setView(injector.getInstance(View.class));

		this.initializeController();
		this.initializeModel();
		this.initializeView();

	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Methods
	//
	// /////////////////////////////////////////////////////////////////////////
	@Override
	public void sendNotification(String notificationName, Object body,
			String type) {
		this.notifyObservers(new Notification(notificationName, body, type));

	}

	@Override
	public void sendNotification(String notificationName, Object body) {
		this.sendNotification(notificationName, body, null);
	}

	@Override
	public void sendNotification(String notificationName) {
		this.sendNotification(notificationName, null, null);
	}

	@Override
	public void notifyObservers(INotification notification) {
		if (this.view != null) {
			this.getView().notifyObservers(notification);
		}
	}

	@Override
	public void registerProxy(IProxy proxy) {
		if (this.getModel() != null) {
			this.getModel().registerProxy(proxy);
		}
	}

	@Override
	public IProxy retrieveProxy(String proxyName) {
		return this.getModel().retrieveProxy(proxyName);
	}

	@Override
	public IProxy removeProxy(String proxyName) {
		if (this.getModel() != null) {
			return this.getModel().removeProxy(proxyName);
		}
		return null;
	}

	@Override
	public boolean hasProxy(String proxyName) {
		return getModel().hasProxy(proxyName);
	}

	@Override
	public void registerCommand(String noteName, ICommand commandClassRef) {
		if (this.getController() != null) {
			this.getController().registerCommand(noteName, commandClassRef);
		}
	}

	@Override
	public void removeCommand(String notificationName) {
		this.getController().removeCommand(notificationName);
	}

	@Override
	public boolean hasCommand(String notificationName) {
		return getController().hasCommand(notificationName);
	}

	@Override
	public void registerMediator(IMediator mediator) {
		if (this.getView() != null) {
			this.getView().registerMediator(mediator);
		}
	}

	@Override
	public IMediator retrieveMediator(String mediatorName) {
		return this.getView().retrieveMediator(mediatorName);
	}

	@Override
	public boolean hasMediator(String mediatorName) {
		return this.getView().hasMediator(mediatorName);
	}

	@Override
	public IMediator removeMediator(String mediatorName) {
		if (this.getView() != null) {
			return this.getView().removeMediator(mediatorName);
		}
		return null;
	}

	/**
	 * 
	 * These are used to register commands/proxies/mediators at the start of an
	 * application. It is called by the Facade-constructor.
	 */
	protected void initializeController() {}
	protected void initializeModel() {}
	protected void initializeView() {}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Accessors
	//
	// /////////////////////////////////////////////////////////////////////////
	private final IController getController() {
		return this.controller;
	}

	private final void setController(IController controller) {
		this.controller = controller;
	}

	private final IModel getModel() {
		return this.model;
	}

	private final void setModel(IModel model) {
		this.model = model;
	}

	private final IView getView() {
		return this.view;
	}

	private final void setView(IView view) {
		this.view = view;
	}
}
