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
package net.conjure.junit;

import junit.framework.Assert;
import net.conjure.ConjureModule;
import net.conjure.interfaces.AbstractFacade;
import net.conjure.patterns.facade.Facade;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class FacadeTestCase {
	// /////////////////////////////////////////////////////////////////////////
	//
	//	Set up & tear down
	//
	// /////////////////////////////////////////////////////////////////////////
	@Before
	public void setUp() throws Exception {
		BasicConfigurator.resetConfiguration();
		BasicConfigurator.configure();
	}
	@After
	public void tearDown() throws Exception {
	}
	
	// /////////////////////////////////////////////////////////////////////////
	//
	//	TESTS
	//
	// /////////////////////////////////////////////////////////////////////////
	@Test
	public final void testFacade() {
		Injector injector = Guice.createInjector(new ConjureModule());
		AbstractFacade facade0 = injector.getInstance(Facade.class);
		
		Logger.getLogger(FacadeTestCase.class).debug(facade0.toString());
		String zero = facade0.toString();
		
		AbstractFacade facade1 = injector.getInstance(Facade.class);
		
		Logger.getLogger(FacadeTestCase.class).debug(facade1.toString());
		String one = facade1.toString();
		
		Assert.assertTrue("Should be same", zero.equals(one));
	}

}
