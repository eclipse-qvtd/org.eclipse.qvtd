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

import org.eclipse.core.resources.IResource;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractModelResolver;

public class ModelResourceResolver extends AbstractModelResolver
{
	public static EclipseFileHandle createFileHandle(IResource resource) {
		EclipseProjectHandle projectHandle = new EclipseProjectHandle(resource.getProject());
		return projectHandle.getFileHandle(resource);
	}
	
	public ModelResourceResolver(IResource resource) {
		super(createFileHandle(resource));
	}
}
