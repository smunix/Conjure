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
package net.conjure.abstracts;

public abstract class AbstractFacade {
	// /////////////////////////////////////////////////////////////////////////
	//
	//	Instance variables
	//
	// /////////////////////////////////////////////////////////////////////////
	protected AbstractModel model;
	protected AbstractView view;
	protected AbstractController controller;

	// /////////////////////////////////////////////////////////////////////////
	//
	//	Constructors
	//
	// /////////////////////////////////////////////////////////////////////////

	// /////////////////////////////////////////////////////////////////////////
	//
	//	Methods
	//
	// /////////////////////////////////////////////////////////////////////////

	// /////////////////////////////////////////////////////////////////////////
	//
	//	Accessors & factories
	//
	// /////////////////////////////////////////////////////////////////////////
	protected synchronized final AbstractModel getModel() {
		return this.model;
	}
	protected synchronized final void setModel(AbstractModel model) {
		this.model = model;
	}
	protected synchronized final AbstractView getView() {
		return this.view;
	}
	protected synchronized final void setView(AbstractView view) {
		this.view = view;
	}
	protected synchronized final AbstractController getController() {
		return this.controller;
	}
	protected synchronized final void setController(AbstractController controller) {
		this.controller = controller;
	}

}