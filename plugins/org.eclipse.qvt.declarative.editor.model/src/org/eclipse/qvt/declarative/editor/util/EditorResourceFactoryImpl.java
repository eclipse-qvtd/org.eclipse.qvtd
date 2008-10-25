/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: EditorResourceFactoryImpl.java,v 1.1 2008/10/25 16:59:36 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.util;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

public class EditorResourceFactoryImpl extends ResourceFactoryImpl
{
	@Override
	public Resource createResource(URI uri)
	{
		XMLResource result = new XMIResourceImpl(uri)
		{
			@Override
			protected boolean useIDs()
			{
				return eObjectToIDMap != null || idToEObjectMap != null;
			}
		};
		result.setEncoding("UTF-8");

		result.getDefaultSaveOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
		result.getDefaultSaveOptions().put(XMLResource.OPTION_LINE_WIDTH, new Integer(80));
		result.getDefaultSaveOptions().put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware());
		return result;
	}
}
