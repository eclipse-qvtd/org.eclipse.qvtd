package org.eclipse.qvt.declarative.common.framework.service;


public abstract class ProviderDescriptor implements Provider{

	public static enum Priority {
		lowest, low, normal, high, highest
	}
	protected Provider describedProvider;

	public abstract Provider getDescribedProvider();

	public abstract Priority getPriority() ;
	
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
