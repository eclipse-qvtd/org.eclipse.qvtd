package org.eclipse.qvt.declarative.common.framework.service;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

public class ProviderDescriptor implements Provider{

	public static enum Priority {
		lowest, low, normal, high, highest
	}

	private static final String PRIORITY_ELEMENT = "Priority"; //$NON-NLS-1$
	
	private static final String NAME_ATTRIBUTE = "name"; //$NON-NLS-1$
	
	protected static final String CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$

	private final IConfigurationElement element;

	private String providerClassName;
	
	private Priority providerPriority;

	protected Provider describedProvider;

	private boolean providerClassInstantiationFailed = false;
	
	protected ProviderDescriptor(IConfigurationElement element) {
		this.element = element;
	}

	protected final IConfigurationElement getConfigurationElement() {
		return element;
	}

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

	public Priority getPriority() {
		if (providerPriority == null) {	
			if (element != null && element.isValid()) {
				String priority = element.getChildren(PRIORITY_ELEMENT)[0].getAttribute(NAME_ATTRIBUTE);
				providerPriority =  Priority.valueOf(priority);	
			}
		}
		return providerPriority;
	}
	
	public String getProviderClassName() {
		if (providerClassName == null) {
			if (element != null && element.isValid()) {
				String className = element.getAttribute(CLASS_ATTRIBUTE);
				providerClassName = (className != null) ? className : super.toString();	
			}
		}
		return providerClassName;
	}

	
	public boolean provides(Operation operation) {
		if (describedProvider == null) {
			describedProvider = getDescribedProvider();
			if (describedProvider == null) {
				return false;
			}
		}		
		try {
			return describedProvider.provides(operation);
		}
		catch (Throwable e) {
			if (e instanceof ThreadDeath) {
				throw (ThreadDeath) e;
			}
			if (e instanceof VirtualMachineError) {
				throw (VirtualMachineError) e;
			}
			return false;
		}
	}
	
}
