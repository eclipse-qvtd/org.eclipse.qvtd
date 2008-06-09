package org.eclipse.qvt.declarative.common.framework.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class Service implements Provider {
		
	protected final Map<ProviderDescriptor.Priority, ArrayList<Provider>> providers;
	
	
	protected final List<? extends Object> execute(ExecutionStrategy strategy, Operation operation) throws Exception {
		assert null != operation : "null operation"; //$NON-NLS-1$
		return strategy.execute(this, operation);
	}
	
	public Service() {
		providers = new HashMap<ProviderDescriptor.Priority, ArrayList<Provider>>();
		for (ProviderDescriptor.Priority providerPriority : ProviderDescriptor.Priority.values()) {
			providers.put(providerPriority, new ArrayList<Provider>());
		}
		
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvt.declarative.common.framework.service.Provider#provides(org.eclipse.qvt.declarative.common.framework.service.Operation)
	 */
	@Override
	public boolean provides(Operation operation) {
		assert null != operation : "null operation passed to provides(IOperation)"; //$NON-NLS-1$

		for (ProviderDescriptor.Priority providerPriority : ProviderDescriptor.Priority.values()) {
			for (Provider provider : providers.get(providerPriority)) {
				if (provider.provides(operation)) {
					return true;
				}
			}
		}
		
		
		return false;
	}
	
	public final void registerProviders(String namespace, String extensionPointName) {
		registerProviders(Platform.getExtensionRegistry()
									.getExtensionPoint(namespace, extensionPointName)
									.getConfigurationElements());
	}

	public final void registerProviders(IConfigurationElement[] elements) {
		assert null != elements : "null elements"; //$NON-NLS-1$

		for (int i = 0; i < elements.length; ++i) {
			IConfigurationElement element = elements[i];
			ProviderDescriptor descriptor = new ProviderDescriptor(element);
			addProvider(descriptor.getPriority(), descriptor);
		}
		
		for (ProviderDescriptor.Priority providerPriority : ProviderDescriptor.Priority.values()) {
			providers.get(providerPriority).trimToSize();
		}
	}
	
	protected final void addProvider(ProviderDescriptor.Priority priority, ProviderDescriptor provider) {
		assert null != priority : "null ProviderPriority"; //$NON-NLS-1$
		assert null != provider : "null ProviderDescriptor"; //$NON-NLS-1$
		
		providers.get(priority).add(provider);
	}
	
	/**
	 * Return the first <code>provider</code> with the highest priority able to provides the <code>operation</code> given in parameter
	 * @param the operation the provider should support
	 * @return the provider
	 */
	protected Provider getFirstProvider(Operation operation) {
		List<ProviderDescriptor.Priority> providerPriorities = Arrays.asList(ProviderDescriptor.Priority.values());
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
	
	protected List<Provider> getProvidersByPriorityDescending (Operation operation) {
		List<Provider> result = new ArrayList<Provider>();
		
		List<ProviderDescriptor.Priority> providerPriorities = Arrays.asList(ProviderDescriptor.Priority.values());
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
