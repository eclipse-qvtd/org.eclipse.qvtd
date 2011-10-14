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
 * $Id: EclipseProviderDescriptor.java,v 1.2 2008/10/09 17:21:08 qglineur Exp $
 */
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
