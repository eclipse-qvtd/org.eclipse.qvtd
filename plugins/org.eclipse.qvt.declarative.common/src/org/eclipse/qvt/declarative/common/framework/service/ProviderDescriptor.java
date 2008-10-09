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
 * $Id: ProviderDescriptor.java,v 1.4 2008/10/09 17:21:03 qglineur Exp $
 */
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
