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
package net.conjure.impl.model.business;

import net.conjure.interfaces.Context;
import net.conjure.interfaces.strategies.BrakeBehaviour;

import org.apache.log4j.Logger;

import com.google.inject.Inject;

public class Car implements Context{
	// /////////////////////////////////////////////////////////////////////////
	//
	//	Static variables
	//
	// /////////////////////////////////////////////////////////////////////////

	// /////////////////////////////////////////////////////////////////////////
	//
	//	Instance variables
	//
	// /////////////////////////////////////////////////////////////////////////
	BrakeBehaviour brakeBehaviour;

	// /////////////////////////////////////////////////////////////////////////
	//
	//	Constructors
	//
	// /////////////////////////////////////////////////////////////////////////
	@Inject
	public Car(BrakeBehaviour brakeBehaviour) {
		this.setBrakeBehaviour(brakeBehaviour);
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	//	Methods
	//
	// /////////////////////////////////////////////////////////////////////////
	@Override
	public void executeStrategy() {
		this.getBrakeBehaviour().brake();
		Logger.getLogger(Car.class).debug(this.getBrakeBehaviour());
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	//	Accessors & factories
	//
	// /////////////////////////////////////////////////////////////////////////
	protected synchronized final BrakeBehaviour getBrakeBehaviour() {
		return brakeBehaviour;
	}

	protected synchronized final void setBrakeBehaviour(
			BrakeBehaviour brakeBehaviour) {
		this.brakeBehaviour = brakeBehaviour;
	}
	
}
