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
package net.conjure.impl.modules;

import net.conjure.impl.FacadeImpl;
import net.conjure.impl.strategies.BrakeWithABS;
import net.conjure.interfaces.strategies.BrakeBehaviour;
import net.conjure.patterns.facade.Facade;

import com.google.inject.AbstractModule;

public class ABSCarModule extends AbstractModule {

	// /////////////////////////////////////////////////////////////////////////
	//
	//	CONFIG
	//
	// /////////////////////////////////////////////////////////////////////////
	@Override
	public void configure() {
		bind(Facade.class).to(FacadeImpl.class);
		bind(BrakeBehaviour.class).to(BrakeWithABS.class);
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	//	Providers
	//
	// /////////////////////////////////////////////////////////////////////////

}
