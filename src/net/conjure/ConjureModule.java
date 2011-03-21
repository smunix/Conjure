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

import net.conjure.abstracts.AbstractController;
import net.conjure.abstracts.AbstractFacade;
import net.conjure.abstracts.AbstractModel;
import net.conjure.abstracts.AbstractView;
import net.conjure.core.Controller;
import net.conjure.core.Model;
import net.conjure.core.View;
import net.conjure.patterns.facade.Facade;

import com.google.inject.AbstractModule;

public class ConjureModule extends AbstractModule{
	// /////////////////////////////////////////////////////////////////////////
	//
	//	Configuration
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
	//	Methods
	//
	// /////////////////////////////////////////////////////////////////////////

}
