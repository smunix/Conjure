package org.g19.mvc.conjure.core.triad;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.g19.mvc.conjure.core.DevConjureModule;
import org.g19.mvc.conjure.interfaces.IFacade;
import org.g19.mvc.conjure.patterns.facade.Facade;
import org.junit.Before;
import org.junit.Test;

public class FacadeTestCase {
	// /////////////////////////////////////////////////////////////////////////
	//
	// Set up & tear down
	//
	// /////////////////////////////////////////////////////////////////////////
	@Before
	public void setUp() throws Exception {
		DevConjureModule.bootStrap();

		BasicConfigurator.resetConfiguration();
		BasicConfigurator.configure();
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// TESTS
	//
	// /////////////////////////////////////////////////////////////////////////

	@Test
	public final void testFacade() {
		IFacade facade = DevConjureModule.injector.getInstance(Facade.class);
		IFacade otherRefToFacade = DevConjureModule.injector
				.getInstance(Facade.class);

		Logger.getLogger(FacadeTestCase.class).debug(
				"facade instance created?:");
		Logger.getLogger(FacadeTestCase.class).debug(facade);
		Logger.getLogger(FacadeTestCase.class).debug(
				"otherRefToFacade instance created?:");
		Logger.getLogger(FacadeTestCase.class).debug(otherRefToFacade);
		Assert.assertTrue("Expecting instance1 not null", facade != null);
		Assert.assertTrue("Expecting instance2 not null",
				otherRefToFacade != null);
		Assert.assertTrue("Expecting instances 1&2 to be referencing the same",
				facade.equals(otherRefToFacade));

	}

	@Test
	public final void testSendNotificationStringObjectString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSendNotificationStringObject() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSendNotificationString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testNotifyObservers() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testRegisterProxy() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testRetrieveProxy() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testRemoveProxy() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testHasProxy() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testRegisterCommand() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testRemoveCommand() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testHasCommand() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testRegisterMediator() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testRetrieveMediator() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testHasMediator() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testRemoveMediator() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetController() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetController() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetModel() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetModel() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetView() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetView() {
		fail("Not yet implemented"); // TODO
	}

}
