package org.g19.mvc.conjure.core;

import org.g19.mvc.conjure.interfaces.IController;
import org.g19.mvc.conjure.interfaces.IFacade;
import org.g19.mvc.conjure.interfaces.IModel;
import org.g19.mvc.conjure.interfaces.IView;
import org.g19.mvc.conjure.patterns.facade.Facade;
import org.g19.mvc.conjure.triad.Controller;
import org.g19.mvc.conjure.triad.Model;
import org.g19.mvc.conjure.triad.View;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Björn Roberg (bjorn.roberg@gmail.com)
 * 
 * This module is for testing only.
 */
public class DevConjureModule extends AbstractModule{
	// /////////////////////////////////////////////////////////////////////////
	//
	// Statics
	//
	// /////////////////////////////////////////////////////////////////////////
	/**
	 * This is for testing purposes. Should be removed in a release version
	 * TODO remove before release
	 */
	public static Injector injector;
	
	// /////////////////////////////////////////////////////////////////////////
	//
	// Configuration
	//
	// /////////////////////////////////////////////////////////////////////////
	/**
	 * Binds the interfaces to the implementations. The only one of these that
	 * the extending module should care about is the <code>Facade</code>-
	 * binding. Chaining this binding is a good idea if you have extended the 
	 * <code>Facade</code>-class from the framework (which you should).
	 */@Override
	protected void configure() {
		bind(IFacade.class).to(Facade.class);
		bind(IController.class).to(Controller.class);
		bind(IView.class).to(View.class);
		bind(IModel.class).to(Model.class);
	}
	
	// /////////////////////////////////////////////////////////////////////////
	//
	// Methods
	//
	// /////////////////////////////////////////////////////////////////////////
	/**
	 * This method is for testing purposes. The actual creating of the 
	 * <code>Injector</code> should be done in the <code>main</code>-method.
	 * This is for testing purposes. Should be removed in a release version
	 * TODO remove before release
	 */
	 public static final void bootStrap() {
		Injector injector = Guice.createInjector(new DevConjureModule());
		DevConjureModule.injector = injector;
	}

}
