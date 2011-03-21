package org.g19.mvc.conjure.triad;

import java.util.HashMap;

import org.g19.mvc.conjure.interfaces.IModel;
import org.g19.mvc.conjure.interfaces.IProxy;

import com.google.inject.Singleton;

@Singleton
public class Model implements IModel {
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
	protected HashMap<String, IProxy> proxyMap;

	// /////////////////////////////////////////////////////////////////////////
	//
	// Constructors
	//
	// /////////////////////////////////////////////////////////////////////////
	protected Model() {
		this.setProxyMap(new HashMap<String, IProxy>());
		initializeModel();
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Methods
	//
	// /////////////////////////////////////////////////////////////////////////
	protected void initializeModel() {
		
	}
	
	@Override
	public void registerProxy(IProxy proxy) {
		// TODO Auto-generated method stub

	}

	@Override
	public IProxy retrieveProxy(String proxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IProxy removeProxy(String proxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasProxy(String proxyName) {
		// TODO Auto-generated method stub
		return false;
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Accessors & factories
	//
	// /////////////////////////////////////////////////////////////////////////
	protected HashMap<String, IProxy> getProxyMap() {
		return proxyMap;
	}

	protected void setProxyMap(HashMap<String, IProxy> proxyMap) {
		this.proxyMap = proxyMap;
	}

}
