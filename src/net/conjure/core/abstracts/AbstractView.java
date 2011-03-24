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
package net.conjure.core.abstracts;

import java.util.HashMap;

import net.conjure.patterns.intermediaries.abstracts.AbstractAgent;

/**
 * 
 * @author Björn Roberg (bjorn.roberg@gmail.com
 * @see org.conjure.core.View
 */
public abstract class AbstractView {
	// /////////////////////////////////////////////////////////////////////////
	//
	// Instance variables
	//
	// /////////////////////////////////////////////////////////////////////////
	protected HashMap<String, AbstractAgent> agents;

	// /////////////////////////////////////////////////////////////////////////
	//
	// Methods
	//
	// /////////////////////////////////////////////////////////////////////////
	public abstract void registerAgent(AbstractAgent agent);

	public abstract boolean hasAgent(AbstractAgent agent);

	public abstract AbstractAgent removeAgent(AbstractAgent agent);

	public abstract AbstractAgent fetchAgent(String agentIdentifier);

	// /////////////////////////////////////////////////////////////////////////
	//
	// Accessors & factories
	//
	// /////////////////////////////////////////////////////////////////////////
	protected synchronized final void setAgents(
			HashMap<String, AbstractAgent> agents) {
		this.agents = agents;
	}

	protected synchronized final HashMap<String, AbstractAgent> getAgents() {
		return agents;
	}

}