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
package net.conjure.patterns.facade.abstracts;

import net.conjure.core.abstracts.AbstractController;
import net.conjure.core.abstracts.AbstractModel;
import net.conjure.core.abstracts.AbstractView;
import net.conjure.patterns.intermediaries.abstracts.AbstractAgent;
import net.conjure.patterns.intermediaries.abstracts.AbstractKeeper;

/**
 * 
 * @author Björn Roberg (bjorn.roberg@gmail.com
 * @see org.conjure.patterns.Facade
 */
public abstract class AbstractFacade {
	// /////////////////////////////////////////////////////////////////////////
	//
	// Instance variables
	//
	// /////////////////////////////////////////////////////////////////////////
	protected AbstractModel model;
	protected AbstractView view;
	protected AbstractController controller;

	// /////////////////////////////////////////////////////////////////////////
	//
	// Methods
	//
	// /////////////////////////////////////////////////////////////////////////
	protected abstract void initializeModel();

	protected abstract void initializeView();

	@Override
	public String toString() {
		return (this.getClass().getName() + '@'
				+ Integer.toHexString(hashCode()) + ", "
				+ this.getModel().toString() + ", " 
				+ this.getView().toString()
				+ ", " + this.getController().toString());
	}

	public abstract void registerAgent(AbstractAgent agent);

	public abstract boolean hasAgent(AbstractAgent agent);

	public abstract AbstractAgent removeAgent(AbstractAgent agent);

	public abstract AbstractAgent fetchAgent(String agentIdentifier);

	public abstract void registerKeeper(AbstractKeeper keeper);

	public abstract boolean hasKeeper(AbstractKeeper keeper);

	public abstract AbstractKeeper removeKeeper(AbstractKeeper keeper);

	public abstract AbstractKeeper fetchKeeper(String keeperIdentifier);

	// /////////////////////////////////////////////////////////////////////////
	//
	// Accessors & factories
	//
	// /////////////////////////////////////////////////////////////////////////
	protected synchronized final AbstractModel getModel() {
		return model;
	}

	protected synchronized final void setModel(AbstractModel model) {
		this.model = model;
	}

	protected synchronized final AbstractView getView() {
		return view;
	}

	protected synchronized final void setView(AbstractView view) {
		this.view = view;
	}

	protected synchronized final AbstractController getController() {
		return controller;
	}

	protected synchronized final void setController(
			AbstractController controller) {
		this.controller = controller;
	}

}
