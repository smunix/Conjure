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

import net.conjure.patterns.intermediaries.abstracts.AbstractKeeper;

/**
 * 
 * @author Björn Roberg (bjorn.roberg@gmail.com
 * @see org.conjure.core.Model
 */
public abstract class AbstractModel {
	// /////////////////////////////////////////////////////////////////////////
	//
	// Instance variables
	//
	// /////////////////////////////////////////////////////////////////////////
	protected HashMap<String, AbstractKeeper> keepers;

	// /////////////////////////////////////////////////////////////////////////
	//
	// Methods
	//
	// /////////////////////////////////////////////////////////////////////////
	public abstract void registerKeeper(AbstractKeeper keeper);

	public abstract boolean hasKeeper(AbstractKeeper keeper);

	public abstract AbstractKeeper removeKeeper(AbstractKeeper keeper);

	public abstract AbstractKeeper fetchKeeper(String keeperIdentifier);

	// /////////////////////////////////////////////////////////////////////////
	//
	// Accessors & factories
	//
	// /////////////////////////////////////////////////////////////////////////
	protected synchronized final HashMap<String, AbstractKeeper> getKeepers() {
		return keepers;
	}

	protected synchronized final void setKeepers(
			HashMap<String, AbstractKeeper> keepers) {
		this.keepers = keepers;
	}
	
}