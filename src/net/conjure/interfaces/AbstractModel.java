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
package net.conjure.interfaces;

import java.util.HashMap;

public abstract class AbstractModel {
	// /////////////////////////////////////////////////////////////////////////
	//
	//	Instance variables
	//
	// /////////////////////////////////////////////////////////////////////////
	protected HashMap<String, AbstractKeeper> keepers;

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
	protected synchronized final HashMap<String, AbstractKeeper> getKeepers() {
		return this.keepers;
	}

	protected synchronized final void setKeepers(
			HashMap<String, AbstractKeeper> keepers) {
		this.keepers = keepers;
	}

}
