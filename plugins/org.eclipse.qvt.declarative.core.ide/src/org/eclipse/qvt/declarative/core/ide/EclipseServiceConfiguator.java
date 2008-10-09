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
 * $Id: EclipseServiceConfiguator.java,v 1.2 2008/10/09 17:21:08 qglineur Exp $
 */
package org.eclipse.qvt.declarative.core.ide;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.qvt.declarative.common.framework.service.ProviderDescriptor;
import org.eclipse.qvt.declarative.common.framework.service.Service;
import org.eclipse.qvt.declarative.common.framework.service.ServiceConfigurator;

public abstract class EclipseServiceConfiguator extends ServiceConfigurator<Map<String, String>>{
	
	protected static String NAMESPACE = "namespace";
	
	protected static String EXTENSION_POINT_NAME = "EXTENSION_POINT_NAME";

	public EclipseServiceConfiguator(Service service, Map<String, String> parameters) {
		super(service, parameters);
		System.out.println("configured "+service+ " with "+parameters);
	}


	private List<ProviderDescriptor> getProvidersDeclaredByExtensionPoint (String namespace, String extensionPointName) {
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(namespace, extensionPointName);
		IConfigurationElement[] configurationElements = extensionPoint.getConfigurationElements();
		return getCorrespondingProviders(configurationElements);
	}
	
	private final List<ProviderDescriptor> getCorrespondingProviders(IConfigurationElement[] elements) {
		assert null != elements : "null elements"; //$NON-NLS-1$

		List<ProviderDescriptor> providerDescriptorList = new ArrayList<ProviderDescriptor>();
		
		for (int i = 0; i < elements.length; ++i) {
			IConfigurationElement element = elements[i];
			ProviderDescriptor descriptor = new EclipseProviderDescriptor(element);
			providerDescriptorList.add(descriptor);
		}

		return providerDescriptorList;
	}

	@Override
	public List<ProviderDescriptor> getProviderDescriptors(Map<String, String> parameters) {
		String extensionNamespace = parameters.get(NAMESPACE);
		String extensionPointName = parameters.get(EXTENSION_POINT_NAME);
		return getProvidersDeclaredByExtensionPoint(extensionNamespace, extensionPointName);
	}

}
