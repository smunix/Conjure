/**
 * Copyright [2011] [Björn Roberg (bjorn.roberg@gmail.com]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.conjure;

import net.conjure.core.Controller;
import net.conjure.core.Model;
import net.conjure.core.View;
import net.conjure.core.abstracts.AbstractController;
import net.conjure.core.abstracts.AbstractModel;
import net.conjure.core.abstracts.AbstractView;
import net.conjure.patterns.facade.Facade;
import net.conjure.patterns.facade.abstracts.AbstractFacade;

import com.google.inject.AbstractModule;

/**
 * 
 * @author Björn Roberg (bjorn.roberg@gmail.com
 * 
 *         <p>
 *         Module used to bind the triad and the facade to their
 *         implementations.
 *         </p>
 *         <p>
 *         The <code>main</code>-method in the framework-implementing
 *         application should always use an instance of this module when
 *         creating an injector with <code>Guice</code> so as to configure the
 *         framework berfore using classes that depend upon it.
 *         </p>
 */
public class ConjureModule extends AbstractModule {
	// /////////////////////////////////////////////////////////////////////////
	//
	// Configuration
	//
	// /////////////////////////////////////////////////////////////////////////
	@Override
	protected void configure() {
		bind(AbstractFacade.class).to(Facade.class);
		bind(AbstractModel.class).to(Model.class);
		bind(AbstractView.class).to(View.class);
		bind(AbstractController.class).to(Controller.class);
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Providers
	//
	// /////////////////////////////////////////////////////////////////////////

}
