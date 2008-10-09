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
 * $Id: ServiceConfigurator.java,v 1.2 2008/10/09 17:21:03 qglineur Exp $
 */
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
