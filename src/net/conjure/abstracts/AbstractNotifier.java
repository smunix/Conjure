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

import java.util.ArrayList;
import java.util.HashMap;

import net.conjure.interfaces.Observable;

public abstract class AbstractNotifier implements Observable {
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
	protected HashMap<Observable, ArrayList<AbstractObserver>> observers;

	// /////////////////////////////////////////////////////////////////////////
	//
	// Constructors
	//
	// /////////////////////////////////////////////////////////////////////////

	// /////////////////////////////////////////////////////////////////////////
	//
	// Methods
	//
	// /////////////////////////////////////////////////////////////////////////
	public abstract void notifyObservers(Observable notifier);

	// /////////////////////////////////////////////////////////////////////////
	//
	// Accessors & factories
	//
	// /////////////////////////////////////////////////////////////////////////
	protected synchronized final HashMap<Observable, ArrayList<AbstractObserver>> getObservers() {
		return this.observers;
	}

	protected synchronized final void setObservers(
			HashMap<Observable, ArrayList<AbstractObserver>> observers) {
		this.observers = observers;
	}

}
