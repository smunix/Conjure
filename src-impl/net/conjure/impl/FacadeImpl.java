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
package net.conjure.impl;

import net.conjure.core.abstracts.AbstractController;
import net.conjure.core.abstracts.AbstractModel;
import net.conjure.core.abstracts.AbstractView;
import net.conjure.impl.model.business.Car;
import net.conjure.impl.strategies.BrakeWithABS;
import net.conjure.patterns.facade.Facade;

import com.google.inject.Inject;

public class FacadeImpl extends Facade{
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

	// /////////////////////////////////////////////////////////////////////////
	//
	//	Constructors
	//
	// /////////////////////////////////////////////////////////////////////////
	@Inject
	public FacadeImpl(AbstractModel model, AbstractView view,
			AbstractController controller) {
		super(model, view, controller);
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	//	Methods
	//
	// /////////////////////////////////////////////////////////////////////////
	public void start() {
		Car car = new Car(new BrakeWithABS());
		car.executeStrategy();
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	//	Accessors & factories
	//
	// /////////////////////////////////////////////////////////////////////////

}
