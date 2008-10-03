package org.eclipse.qvt.declarative.core.ide;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.qvt.declarative.common.framework.service.Provider;
import org.eclipse.qvt.declarative.common.framework.service.ProviderDescriptor;

public class EclipseProviderDescriptor extends ProviderDescriptor {

	private static final String PRIORITY_ATTRIBUTE = "priority"; //$NON-NLS-1$
	
	private static final String CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$

	private final IConfigurationElement element;
	
	private Priority providerPriority;
	
	private boolean providerClassInstantiationFailed = false;

	
	public EclipseProviderDescriptor(IConfigurationElement element) {
		this.element = element;
	}
	
	@Override
	public Provider getDescribedProvider() {
		if (describedProvider == null && !providerClassInstantiationFailed) {
			try {
				describedProvider = (Provider)element.createExecutableExtension(CLASS_ATTRIBUTE);
			} catch (CoreException ce) {
				providerClassInstantiationFailed = true;
			}
		}
		return describedProvider;
	}

	@Override
	public Priority getPriority() {
		if (providerPriority == null) {	
			if (element != null && element.isValid()) {
				String priority = element.getAttribute(PRIORITY_ATTRIBUTE);
				providerPriority =  Priority.valueOf(priority);	
			}
		}
		return providerPriority;
	}

}
