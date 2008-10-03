package org.eclipse.qvt.declarative.common.framework.service;

import java.util.List;

public abstract class ServiceConfigurator<T> {
	
	public ServiceConfigurator(Service service, T parameters) {
		for (ProviderDescriptor descriptor : getProviderDescriptors(parameters)) {
			  service.addProvider(descriptor.getPriority(), descriptor);
		}
	}
	
	public abstract List<ProviderDescriptor> getProviderDescriptors(T parameters);

}
