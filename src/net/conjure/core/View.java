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
package net.conjure.core;

import net.conjure.core.abstracts.AbstractView;
import net.conjure.patterns.intermediaries.abstracts.AbstractAgent;

import com.google.inject.Singleton;

/**
 * 
 * @author Björn Roberg (bjorn.roberg@gmail.com
 * 
 *         <p>
 *         The <code>View</code>'s responsibilities are:
 *         <ul>
 *         <li>Cache named references to <code>Agent</code>s in application.</li>
 *         </ul>
 *         </p>
 *         <p>
 *         </p>
 */
@Singleton
public class View extends AbstractView {
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
	public View() {

	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Methods
	//
	// /////////////////////////////////////////////////////////////////////////
	@Override
	public void registerAgent(AbstractAgent agent) {
		this.getAgents().put(agent.getAgentName(), agent);
	}

	@Override
	public boolean hasAgent(AbstractAgent agent) {
		return this.getAgents().containsKey(agent.getAgentName());
	}

	@Override
	public AbstractAgent removeAgent(AbstractAgent agent) {
		this.getAgents().remove(agent.getAgentName());
		return agent;
	}

	@Override
	public AbstractAgent fetchAgent(String agentIdentifier) {
		return this.getAgents().get(agentIdentifier);
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Accessors & factories
	//
	// /////////////////////////////////////////////////////////////////////////

}
