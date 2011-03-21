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
package net.conjure.patterns.facade;

import net.conjure.abstracts.AbstractController;
import net.conjure.abstracts.AbstractFacade;
import net.conjure.abstracts.AbstractModel;
import net.conjure.abstracts.AbstractView;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * 
 * @author Björn Roberg (bjorn.roberg@gmail.com
 * 
 *         The <code>Facade</code> will act as the primary communication portal
 *         for the back end of the application. It will have all methods (not
 *         accessors) that is contained within the triad (
 *         <code>Model, View and Controller</code>.
 */
@Singleton
public class Facade extends AbstractFacade {
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
	/**
	 * The constructor for the <code>Facade</code>. The references to the triad
	 * is injected by <code>Guice</code> via the <code>ConjureModule</code>.
	 */
	@Inject
	public Facade(
			AbstractModel model,
			AbstractView view,
			AbstractController controller) {
		this.setModel(model);
		this.setView(view);
		this.setController(controller);
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Methods
	//
	// /////////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return (this.getClass().getName() + '@' +
				Integer.toHexString(hashCode()) + ", " +
				this.getModel().toString() + ", " + 
				this.getView().toString() + ", " +
				this.getController().toString());
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Accessors & factories
	//
	// /////////////////////////////////////////////////////////////////////////

}
