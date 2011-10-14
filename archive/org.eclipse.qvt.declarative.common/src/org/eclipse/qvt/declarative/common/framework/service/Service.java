/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * </copyright>
 * 
 * Contributors:
 *     Quentin Glineur - initial API and implementation
 *
 * $Id: Service.java,v 1.9 2008/10/21 08:30:31 qglineur Exp $
 */
package org.eclipse.qvt.declarative.common.framework.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Base class for services. A service is a group of providers classed by
 * priority. It is itself a provider proxy as it delegates the operation to one
 * or more of its providers according to a strategy.
 * 
 * @author Quentin Glineur
 * 
 */
public abstract class Service implements Provider {

	protected final Map<ProviderDescriptor.Priority, ArrayList<Provider>> providers;

	protected final List<? extends Object> execute(ExecutionStrategy strategy,
			Operation operation) throws Exception {
		assert null != operation : "null operation"; //$NON-NLS-1$
		return strategy.execute(this, operation);
	}

	/**
	 * Construct and initialize the service base.
	 */
	public Service() {
		providers = new HashMap<ProviderDescriptor.Priority, ArrayList<Provider>>();
		for (ProviderDescriptor.Priority providerPriority : ProviderDescriptor.Priority
				.values()) {
			providers.put(providerPriority, new ArrayList<Provider>());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.qvt.declarative.common.framework.service.Provider#provides
	 * (org.eclipse.qvt.declarative.common.framework.service.Operation)
	 */
	public boolean provides(Operation operation) {
		assert null != operation : "null operation passed to provides(IOperation)"; //$NON-NLS-1$

		for (ProviderDescriptor.Priority providerPriority : ProviderDescriptor.Priority
				.values()) {
			for (Provider provider : providers.get(providerPriority)) {
				if (provider.provides(operation)) {
					return true;
				}
			}
		}

		return false;
	}

	protected final void addProvider(ProviderDescriptor.Priority priority,
			ProviderDescriptor provider) {
		assert null != priority : "null ProviderPriority"; //$NON-NLS-1$
		assert null != provider : "null ProviderDescriptor"; //$NON-NLS-1$

		providers.get(priority).add(provider);
	}

	/**
	 * Return the first <code>provider</code> with the highest priority able to
	 * provides the <code>operation</code> given in parameter
	 * 
	 * @param the
	 *            operation the provider should support
	 * @return the provider
	 */
	protected Provider getFirstProvider(Operation operation) {
		List<ProviderDescriptor.Priority> providerPriorities = Arrays
				.asList(ProviderDescriptor.Priority.values());
		Collections.reverse(providerPriorities);

		for (ProviderDescriptor.Priority providerPriority : providerPriorities) {
			for (Provider provider : providers.get(providerPriority)) {
				if (provider.provides(operation)) {
					return provider;
				}
			}
		}
		return null;
	}

	protected List<Provider> getProvidersByPriorityDescending(
			Operation operation) {
		List<Provider> result = new ArrayList<Provider>();

		List<ProviderDescriptor.Priority> providerPriorities = Arrays
				.asList(ProviderDescriptor.Priority.values());
		Collections.reverse(providerPriorities);

		for (ProviderDescriptor.Priority providerPriority : providerPriorities) {
			for (Provider provider : providers.get(providerPriority)) {
				if (provider.provides(operation)) {
					result.add(provider);
				}
			}
		}
		return result;
	}
	
	public Provider[] getProviders(ProviderDescriptor.Priority priority) {
		List<Provider> selectedProviders = providers.get(priority);
		return selectedProviders.toArray(new Provider[selectedProviders.size()]);
	}
	
	public Map<ProviderDescriptor.Priority, Provider[]> getProviders() {
		Map<ProviderDescriptor.Priority, Provider[]> result = new LinkedHashMap<ProviderDescriptor.Priority, Provider[]>();
		for (ProviderDescriptor.Priority priority : ProviderDescriptor.Priority.values()) {
			result.put(priority, getProviders(priority));
		}
		return result;
	}

}
