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
package org.eclipse.qvt.declarative.editor.ui.xml;

import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;

/**
 * An EcorePageManager manages editing of the primary edit Resource as an Ecore-based XMI text file.
 */
public class EcoreXMLPageManager extends XMLPageManager
{
	public EcoreXMLPageManager(PagedEditor pagedEditor, XMLResource resource, String pageTitle) {
		super(pagedEditor, resource, pageTitle);
	}
	
//	@Override protected Collection<? extends EObject> getEcoreContents(Resource resource) {
//		return resource.getContents();
//	}

	public String getFileExtension() {
		return getCreationFactory().getEcoreExtension();
	}
}