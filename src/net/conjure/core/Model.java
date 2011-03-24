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

import net.conjure.core.abstracts.AbstractModel;
import net.conjure.patterns.intermediaries.abstracts.AbstractKeeper;

import com.google.inject.Singleton;

/**
 * 
 * @author Björn Roberg (bjorn.roberg@gmail.com
 * 
 *         <p>
 *         The <code>Model</code>'s responsibilities are:
 *         <ul>
 *         <li>Cache named references to <code>Keeper</code>s in the
 *         application.</li>
 *         </ul>
 *         </p>
 *         <p>
 *         </p>
 */
@Singleton
public class Model extends AbstractModel {
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
	public Model() {

	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Methods
	//
	// /////////////////////////////////////////////////////////////////////////
	@Override
	public void registerKeeper(AbstractKeeper keeper) {
		this.getKeepers().put(keeper.getKeeperName(), keeper);
	}

	@Override
	public boolean hasKeeper(AbstractKeeper keeper) {
		return this.getKeepers().containsKey(keeper.getKeeperName());
	}

	@Override
	public AbstractKeeper removeKeeper(AbstractKeeper keeper) {
		this.getKeepers().remove(keeper.getKeeperName());
		return keeper;
	}

	@Override
	public AbstractKeeper fetchKeeper(String keeperIdentifier) {
		return this.getKeepers().get(keeperIdentifier);
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Accessors & factories
	//
	// /////////////////////////////////////////////////////////////////////////

}
