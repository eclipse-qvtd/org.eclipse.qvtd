/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.qvtd.pivot.qvtrelation;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.qvtd.pivot.qvtrelation.scoping.QVTrelationPivotScoping;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationToStringVisitor;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePivotStandaloneSetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for Pivot models without equinox extension registry
 */
public class QVTrelationPivotStandaloneSetup //implements ISetup
{
	private static Injector injector = null;

	public static void doSetup() {
		if (injector == null) {
			injector = new QVTrelationPivotStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}

	public static void doTearDown() {
		injector = null;
	}

	public static void init() {
		QVTtemplatePivotStandaloneSetup.doSetup();
		QVTrelationPivotScoping.init();
		QVTrelationToStringVisitor.FACTORY.getClass();
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
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("ecore"))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xmi"))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
		if (!EPackage.Registry.INSTANCE.containsKey(QVTrelationPackage.eNS_URI))
			EPackage.Registry.INSTANCE.put(QVTrelationPackage.eNS_URI, QVTrelationPackage.eINSTANCE);

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

