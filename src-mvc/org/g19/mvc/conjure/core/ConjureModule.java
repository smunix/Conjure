/**
 * Copyright [2011] [Björn Roberg]
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

/**
 * @author Björn Roberg (bjorn.roberg@gmail.com)
 * 
 *         This module is the module, which configures the framework's wiring.
 *         The first (base) module that the implementing project has should
 *         <code>extends</code> this module and <code>override</code> the
 *         <code>configure()</code>-method, calling
 *         <code>this.super().configure();</code> as the first statement in the
 *         <code>configure()</code>-method.
 */
public class ConjureModule extends AbstractModule {

	// /////////////////////////////////////////////////////////////////////////
	//
	// Configuration
	//
	// /////////////////////////////////////////////////////////////////////////
	/**
	 * Binds the interfaces to the implementations. The only one of these that
	 * the extending module should care about is the <code>Facade</code>-
	 * binding. Chaining this binding is a good idea if you have extended the
	 * <code>Facade</code>-class from the framework (which you should). E.g:
	 * <code>bind(Facade.class).to(MyFacade.class);</code>
	 */
	@Override
	protected void configure() {
		bind(IFacade.class).to(Facade.class);
		bind(IController.class).to(Controller.class);
		bind(IView.class).to(View.class);
		bind(IModel.class).to(Model.class);
	}

}
