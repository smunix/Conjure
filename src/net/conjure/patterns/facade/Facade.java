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
package net.conjure.patterns.facade;

import net.conjure.core.abstracts.AbstractController;
import net.conjure.core.abstracts.AbstractModel;
import net.conjure.core.abstracts.AbstractView;
import net.conjure.patterns.facade.abstracts.AbstractFacade;
import net.conjure.patterns.intermediaries.abstracts.AbstractAgent;
import net.conjure.patterns.intermediaries.abstracts.AbstractKeeper;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * 
 * @author Björn Roberg (bjorn.roberg@gmail.com
 *         <p>
 *         The <code>Facade</code>'s responsibilites are:
 *         <ul>
 *         <li>To encompass all the methods in the core members of the MVC
 *         framework so as to enable the developer to use it as a front actor,
 *         with which to control the application.</li>
 *         </ul>
 *         </p>
 */
@Singleton
public class Facade extends AbstractFacade {
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

	// /////////////////////////////////////////////////////////////////////////
	//
	// Constructors
	//
	// /////////////////////////////////////////////////////////////////////////
	@Inject
	public Facade(AbstractModel model, AbstractView view,
			AbstractController controller) {
		this.initializeFacade(model, view, controller);
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Methods
	//
	// /////////////////////////////////////////////////////////////////////////
	private synchronized void initializeFacade(AbstractModel model,
			AbstractView view, AbstractController controller) {
		this.setModel(model);
		this.setView(view);
		this.setController(controller);
	}

	/**
	 * Override this method in your <code>Facade</code>-implementation to
	 * initialize it with <code>Keeper</code>s from the start of the program.
	 */
	@Override
	protected void initializeModel() {
	}
	
	/**
	 * Override this method in your <code>Facade</code>-implementation to
	 * initialize it with <code>Agent</code>s from the start of the program.
	 */
	@Override
	protected void initializeView() {
	}

	@Override
	public void registerAgent(AbstractAgent agent) {
		this.getView().registerAgent(agent);
	}

	@Override
	public boolean hasAgent(AbstractAgent agent) {
		return this.getView().hasAgent(agent);
	}

	@Override
	public AbstractAgent removeAgent(AbstractAgent agent) {
		return this.getView().removeAgent(agent);
	}

	@Override
	public AbstractAgent fetchAgent(String agentIdentifier) {
		return this.getView().fetchAgent(agentIdentifier);
	}

	@Override
	public void registerKeeper(AbstractKeeper keeper) {
		this.getModel().registerKeeper(keeper);
	}

	@Override
	public boolean hasKeeper(AbstractKeeper keeper) {
		return this.getModel().hasKeeper(keeper);
	}

	@Override
	public AbstractKeeper removeKeeper(AbstractKeeper keeper) {
		return this.getModel().removeKeeper(keeper);
	}

	@Override
	public AbstractKeeper fetchKeeper(String keeperIdentifier) {
		return this.getModel().fetchKeeper(keeperIdentifier);
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Accessors & factories
	//
	// /////////////////////////////////////////////////////////////////////////

}
