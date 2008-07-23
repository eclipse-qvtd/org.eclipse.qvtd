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
package org.eclipse.qvt.declarative.editor.ui.pages;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.qvt.declarative.ecore.utils.ClassUtils;
import org.eclipse.qvt.declarative.editor.ui.ICreationFactory;
import org.eclipse.qvt.declarative.editor.ui.QVTEditorPlugin;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.osgi.framework.Bundle;

/**
 * A plugin extension reader that populates the PageDefinitions registry.
 */
public class PageDefinitionsReader extends RegistryReader
{
	
	// The page factory extension point name
	public static final String PAGE_DEFINITION_PPID = "pageDefinition";
	private static final String TAG_PAGE = "page";
	private static final String ATT_CREATION = "creationFactory";
	private static final String ATT_FACTORY = "pageFactory";
	private static final String ATT_NAME = "name";
	
	private final PagedEditor pagedEditor;
	
	public PageDefinitionsReader(PagedEditor pagedEditor) {
		super(Platform.getExtensionRegistry(),
				QVTEditorPlugin.INSTANCE.getBundle().getSymbolicName(), 
				PAGE_DEFINITION_PPID);
		this.pagedEditor = pagedEditor;
	}

	@Override protected boolean readElement(IConfigurationElement element) {
	    if (element.getName().equals(TAG_PAGE)) {
	    	String name = element.getAttribute(ATT_NAME);
	    	if (name == null)
    			return logError("Missing", ATT_NAME, element, null);
	    	IPageFactory pageFactory = null;
    		String pageFactoryName = element.getAttribute(ATT_FACTORY);
    		if (pageFactoryName == null)
    			return logError("Missing", ATT_FACTORY, element, null);
			IExtension extension = element.getDeclaringExtension();
			String namespaceIdentifier = extension.getNamespaceIdentifier();
			Bundle bundle = Platform.getBundle(namespaceIdentifier);	
    		Class<IPageFactory> pageFactoryClass = null;
    		try {
		    	pageFactoryClass = ClassUtils.asClassUnchecked(bundle.loadClass(pageFactoryName));
			} catch (ClassNotFoundException e) {
    			return logError("Failed to load class", pageFactoryName, element, e);
			} 
			ICreationFactory creationFactory = null;
    		String creationFactoryName = element.getAttribute(ATT_CREATION);
    		Class<?>[] constructorArgumentClasses = null;
    		Object[] constructorArgumentObjects = null;
    		if (creationFactoryName != null) {
    			try {
    		    	Class<ICreationFactory> creationFactoryClass = ClassUtils.asClassUnchecked(bundle.loadClass(creationFactoryName));
    				creationFactory = (ICreationFactory) creationFactoryClass.getDeclaredField("INSTANCE").get(null);
					constructorArgumentClasses = new Class<?>[] { PagedEditor.class, ICreationFactory.class};
					constructorArgumentObjects = new Object[] { pagedEditor, creationFactory };
				} catch (ClassNotFoundException e) {
	    			return logError("Failed to load class", creationFactoryName, element, e);
				} catch (IllegalArgumentException e) {
	    			return logError("Failed to load INSTANCE field", creationFactoryName, element, e);
				} catch (SecurityException e) {
	    			return logError("Failed to load INSTANCE field", creationFactoryName, element, e);
				} catch (IllegalAccessException e) {
	    			return logError("Failed to load INSTANCE field", creationFactoryName, element, e);
				} catch (NoSuchFieldException e) {
	    			return logError("Failed to load INSTANCE field", creationFactoryName, element, e);
				}
    		}
    		else {
				constructorArgumentClasses = new Class<?>[] { PagedEditor.class };
				constructorArgumentObjects = new Object[] { pagedEditor };
    		}
    		Constructor<IPageFactory> constructor = null;
    		try {
				constructor = pageFactoryClass.getConstructor(constructorArgumentClasses);
			} catch (SecurityException e) {
    			return logError("Failed to locate constructor", pageFactoryName, element, e);
			} catch (NoSuchMethodException e) {
    			return logError("Failed to locate constructor", pageFactoryName, element, e);
			} catch (IllegalArgumentException e) {
    			return logError("Failed to locate constructor", pageFactoryName, element, e);
			}
			try {
				pageFactory = constructor.newInstance(constructorArgumentObjects);
			} catch (IllegalArgumentException e) {
    			return logError("Failed to construct", pageFactoryName, element, e);
			} catch (InstantiationException e) {
    			return logError("Failed to construct", pageFactoryName, element, e);
			} catch (IllegalAccessException e) {
    			return logError("Failed to construct", pageFactoryName, element, e);
			} catch (InvocationTargetException e) {
    			return logError("Failed to construct", pageFactoryName, element, e);
			}
			try {
				PageDefinitions pageFactoryRegistries = pagedEditor.getPageFactoryRegistries();
				pageFactory.registerAsIn(name, pageFactoryRegistries);
			} catch (InstantiationException e) {
    			return logError("Failed to register", pageFactoryName, element, e);
			} catch (IllegalAccessException e) {
    			return logError("Failed to register", pageFactoryName, element, e);
			}
	    	return true;
	    }
	    return false;
	}

	protected boolean logError(String prefix, String pageFactoryName, IConfigurationElement element, Exception e) {
		IExtension extension = element.getDeclaringExtension();
		String namespaceIdentifier = extension.getNamespaceIdentifier();
		String extensionPoint = extension.getExtensionPointUniqueIdentifier();
		String elementName = element.getName();
		QVTEditorPlugin.logError(prefix + " '" + pageFactoryName
				+ "' for element '" + elementName
				+ "' of extension point '" + extensionPoint
				+ "' of bundle '" + namespaceIdentifier + "'", e);
		return false;
	}
}
