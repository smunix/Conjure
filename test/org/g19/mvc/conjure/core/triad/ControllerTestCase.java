package org.g19.mvc.conjure.core.triad;

import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.g19.mvc.conjure.core.DevConjureModule;
import org.g19.mvc.conjure.interfaces.IController;
import org.g19.mvc.conjure.interfaces.INotification;
import org.g19.mvc.conjure.patterns.observer.Notification;
import org.g19.mvc.conjure.triad.Controller;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerTestCase {
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

	@After
	public void tearDown() throws Exception {
		//
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// TESTS
	//
	// /////////////////////////////////////////////////////////////////////////
	@Test
	public final void testInjector() {
		IController controller = DevConjureModule.injector
				.getInstance(Controller.class);
		IController otherRefToController = DevConjureModule.injector
				.getInstance(Controller.class);

		Logger.getLogger(ControllerTestCase.class).debug(
				"controller instance created?:");
		Logger.getLogger(ControllerTestCase.class).debug(controller);
		Logger.getLogger(ControllerTestCase.class).debug(
				"otherRefToController instance created?:");
		Logger.getLogger(ControllerTestCase.class).debug(otherRefToController);
		Assert.assertTrue("Expecting instance1 not null", controller != null);
		Assert.assertTrue("Expecting instance2 not null",
				otherRefToController != null);
		Assert.assertTrue("Expecting instances 1&2 to be referencing the same",
				controller.equals(otherRefToController));
	}

	@Test
	public final void testController() {
		IController controller = DevConjureModule.injector
				.getInstance(Controller.class);
		Controller concreteController = (Controller) controller;
		concreteController.getClass();

		// Assert.assertTrue("Expecting not null",
		// concreteController.getCommandMap() != null);
		// Assert.assertTrue("Expecting true",
		// concreteController.getCommandMap().isEmpty() == true);
	}

	@Test
	public final void testRegisterCommand() {
		String command = "command";
		IController controller = DevConjureModule.injector
				.getInstance(Controller.class);

		controller.registerCommand(command, new MockCommand());
		Assert.assertTrue("Expecting not null", controller.hasCommand(command));
	}

	@Test
	public final void testExecuteCommand() {
		String command = "command";
		Logger.getLogger(MockCommand.class).setLevel(Level.ALL);

		IController controller = DevConjureModule.injector
				.getInstance(Controller.class);

		controller.registerCommand(command, new MockCommand());
		INotification notification = new Notification(command);
		controller.executeCommand(notification);

		Assert.assertTrue("Expecting level of logger to be DEBUG", Logger
				.getLogger(MockCommand.class).getLevel() == Level.DEBUG);
	}

	@Test
	public final void testRemoveCommand() {
	}

	@Test
	public final void testHasCommand() {
	}

	@Test
	public final void testGetCommandMap() {
	}

	@Test
	public final void testSetCommandMap() {
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Methods
	//
	// /////////////////////////////////////////////////////////////////////////

}
