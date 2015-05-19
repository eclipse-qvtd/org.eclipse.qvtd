/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.model.QVTimperativeLibrary;
import org.eclipse.qvtd.pivot.qvtimperative.scoping.QVTimperativePivotScoping;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeASResourceFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeToStringVisitor;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for Pivot models without equinox extension registry
 */
public class QVTimperativePivotStandaloneSetup
{
	private static Injector injector = null;
	
	public static void doSetup() {
		if (injector == null) {
			injector = new QVTimperativePivotStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}

	public static void init() {
		QVTimperativeLibrary.lazyInstall();
		QVTcoreBasePivotStandaloneSetup.doSetup();
		QVTimperativePivotScoping.init();
		QVTimperativeASResourceFactory.getInstance();
		QVTimperativeToStringVisitor.FACTORY.getClass();
	}
	
	/**
	 * Return the Injector for this plugin.
	 */
	public static final Injector getInjector() {
		if (injector == null) {
			doSetup();
		}
		return injector;
	}

/*	private static final ContentHandler QVTI_CONTENT_HANDLER = new RootXMLContentHandlerImpl(
		QVTimperativePackage.eCONTENT_TYPE,
		new String[]{ASResource.FILE_EXTENSION},
		RootXMLContentHandlerImpl.XMI_KIND, QVTimperativePackage.eNS_URI, null);

	public static void initializeResourceFactory(@NonNull Resource.Factory.Registry resourceFactoryRegistry) {
		Map<String, Object> contentTypeToFactoryMap = resourceFactoryRegistry.getContentTypeToFactoryMap();
		if (!contentTypeToFactoryMap.containsKey(QVTimperativePackage.eCONTENT_TYPE))
			contentTypeToFactoryMap.put(QVTimperativePackage.eCONTENT_TYPE, QVTimperativeASResourceFactory.INSTANCE);
//		Map<String, Object> extensionToFactoryMap = resourceFactoryRegistry.getExtensionToFactoryMap();
//		if (!extensionToFactoryMap.containsKey("qvtixmi"))
//			extensionToFactoryMap.put("qvtixmi", QVTimperativeResourceFactoryImpl.INSTANCE);
		MetamodelManager.installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY, QVTI_CONTENT_HANDLER);
	} */

	public Injector createInjector() {
		if (Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xmi"))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().remove("xmi");
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(Resource.Factory.Registry.DEFAULT_EXTENSION))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		return Guice.createInjector(/*new org.eclipse.ocl.xtext.essentialocl.EssentialOCLRuntimeModule()*/);
	}

	public Injector createInjectorAndDoEMFRegistration() {
		init();
		// register default ePackages
		@SuppressWarnings("null")@NonNull Registry resourceFactoryRegistry = Resource.Factory.Registry.INSTANCE;
		if (!resourceFactoryRegistry.getExtensionToFactoryMap().containsKey("ecore"))
			resourceFactoryRegistry.getExtensionToFactoryMap().put(
				"ecore", new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		if (!resourceFactoryRegistry.getExtensionToFactoryMap().containsKey("xmi"))
			resourceFactoryRegistry.getExtensionToFactoryMap().put(
				"xmi", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
//		initializeResourceFactory(resourceFactoryRegistry);
		if (!EPackage.Registry.INSTANCE.containsKey(QVTimperativePackage.eNS_URI))
			EPackage.Registry.INSTANCE.put(QVTimperativePackage.eNS_URI, QVTimperativePackage.eINSTANCE);

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public void register(Injector injector) {
//		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
//		org.eclipse.xtext.resource.IResourceServiceProvider serviceProvider = injector.getInstance(org.eclipse.xtext.resource.IResourceServiceProvider.class);
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("essentialocl", resourceFactory);
//		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("essentialocl", serviceProvider);
	}
}

