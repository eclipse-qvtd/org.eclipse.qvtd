/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.modelregistry.eclipse;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.qvt.declarative.modelregistry.environment.AccessorKindRegistry;
import org.eclipse.qvt.declarative.modelregistry.environment.ModelRegistryEnvironment;
import org.eclipse.qvt.declarative.modelregistry.model.Accessor;

/**
 * A plugin extension reader that populates the AccessorKindRegistry.
 */
public class AccessorKindRegistryReader extends RegistryReader
{
	private static final String TAG_ACCESSOR = "accessor";
	private static final String ATT_CLASS = "class";
	
	private final AccessorKindRegistry accessorKindRegistry;
	
	public AccessorKindRegistryReader(AccessorKindRegistry accessorKindRegistry) {
		super(Platform.getExtensionRegistry(),
				ModelRegistryPlugin.getDefault().getBundle().getSymbolicName(), 
				EclipseModelRegistryEnvironment.ACCESSOR_KIND_PPID);
		this.accessorKindRegistry = accessorKindRegistry;
	}

	@Override protected boolean readElement(IConfigurationElement element) {
	    if (element.getName().equals(TAG_ACCESSOR)) {
	    	try {
	    		Accessor accessorPrototype = (Accessor) element.createExecutableExtension(ATT_CLASS);
	    		accessorKindRegistry.addAccessor(accessorPrototype);
			} catch (CoreException e) {
				ModelRegistryEnvironment.logError("Failed to load class for '" + element.getAttribute(ATT_CLASS) + "'", e);
				return false;
			}
	    	return true;
	    }
	    return false;
	}
}
