package org.eclipse.qvt.declarative.common.framework.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

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

	/**
	 * Registers all providers that are declaring an extension of a particular
	 * extension point.
	 * 
	 * @param namespace
	 *            The extension point name space.
	 * @param extensionPointName
	 *            The extension point name.
	 */
	public final void registerProviders(String namespace,
			String extensionPointName) {
		registerProviders(Platform.getExtensionRegistry().getExtensionPoint(
				namespace, extensionPointName).getConfigurationElements());
	}

	/**
	 * Registers all providers that are declaring an extension of a particular
	 * extension point.
	 * 
	 * @param elements
	 *            The <code>IConfigurationElement</code> array from an extension
	 *            point representing the extenders.
	 */
	public final void registerProviders(IConfigurationElement[] elements) {
		assert null != elements : "null elements"; //$NON-NLS-1$

		for (int i = 0; i < elements.length; ++i) {
			IConfigurationElement element = elements[i];
			ProviderDescriptor descriptor = new ProviderDescriptor(element);
			addProvider(descriptor.getPriority(), descriptor);
		}

		for (ProviderDescriptor.Priority providerPriority : ProviderDescriptor.Priority
				.values()) {
			providers.get(providerPriority).trimToSize();
		}
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

}
