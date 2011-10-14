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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.qvt.declarative.editor.ui.IMasterPageManager;
import org.eclipse.qvt.declarative.editor.ui.IPageManager;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.eclipse.qvt.declarative.editor.ui.pages.AbstractPageFactory;
import org.eclipse.qvt.declarative.editor.ui.pages.PageDefinitions;

/**
 * An XMLPageFactory manages creation of XML pages.
 */
public abstract class XMLPageFactory extends AbstractPageFactory
{
	public abstract IMasterPageManager createMasterPageFor(PagedEditor pagedEditor, XMLResource resource);
	public abstract void createOtherPagesFor(PagedEditor pagedEditor);
	public abstract IPageManager createPageFor(PagedEditor pagedEditor, XMLResource resource);

	protected XMLPageFactory(PagedEditor pagedEditor) {
		super(pagedEditor);
	}

	public static boolean isEPackageBased(XMLResource e) {
		if (e == null)
			return false;
		List<EObject> contents = e.getContents();
		if (contents.isEmpty())
			return false;
		EClass ePackageMetaClass = EcorePackage.eINSTANCE.eClass();
		for (EObject content : contents) {		// content is an EPackage or derivation
			EClass metaClass = content.eClass();					
			if (!ePackageMetaClass.isSuperTypeOf(metaClass))
				return false;
		}
		return true;
	}
	
	public void registerAsIn(String name, PageDefinitions pageFactoryRegistries) throws InstantiationException, IllegalAccessException {
		XMLPageFactoryRegistry pageFactoryRegistry = pageFactoryRegistries.create(XMLPageFactoryRegistry.class);
		pageFactoryRegistry.registerPageFactory(name, this);
	}
}