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

import net.conjure.interfaces.Notable;

public abstract class AbstractNote implements Notable{
	// /////////////////////////////////////////////////////////////////////////
	//
	//	Instance variables
	//
	// /////////////////////////////////////////////////////////////////////////
	public String name;
	public Object contents;
	public String args;
	
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
	protected synchronized final String getName() {
		return this.name;
	}
	protected synchronized final void setName(String name) {
		this.name = name;
	}
	protected synchronized final Object getContents() {
		return this.contents;
	}
	protected synchronized final void setContents(Object contents) {
		this.contents = contents;
	}
	protected synchronized final String getArgs() {
		return this.args;
	}
	protected synchronized final void setArgs(String args) {
		this.args = args;
	}

}
