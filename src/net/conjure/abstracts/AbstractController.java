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

import java.util.HashMap;

public abstract class AbstractController {
	// /////////////////////////////////////////////////////////////////////////
	//
	// Instance variables
	//
	// /////////////////////////////////////////////////////////////////////////
	protected HashMap<String, AbstractEvent> events;

	/**
	 * Reference to <code>Model</code>.
	 */
	protected AbstractModel model;
	/**
	 * Reference to <code>View</code>.
	 */
	protected AbstractView view;

	// /////////////////////////////////////////////////////////////////////////
	//
	// Methods
	//
	// /////////////////////////////////////////////////////////////////////////

	// /////////////////////////////////////////////////////////////////////////
	//
	// Accessors & factories
	//
	// /////////////////////////////////////////////////////////////////////////
	protected synchronized final HashMap<String, AbstractEvent> getEvents() {
		return this.events;
	}

	protected synchronized final void setEvents(
			HashMap<String, AbstractEvent> events) {
		this.events = events;
	}

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

}
