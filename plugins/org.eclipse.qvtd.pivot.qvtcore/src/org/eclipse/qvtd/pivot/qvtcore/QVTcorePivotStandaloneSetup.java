/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: EssentialOCLStandaloneSetup.java,v 1.3 2011/03/01 08:46:48 ewillink Exp $
 */

package org.eclipse.qvtd.pivot.qvtcore;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtcore.scoping.QVTcorePivotScoping;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcorePrettyPrintVisitor;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreSaver;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreToStringVisitor;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for Pivot models without equinox extension registry
 */
public class QVTcorePivotStandaloneSetup //implements ISetup
{
	private static Injector injector = null;
	
	public static void doSetup() {
		if (injector == null) {
			injector = new QVTcorePivotStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}

	public static void init() {
		QVTbasePivotStandaloneSetup.doSetup();
		QVTcorePivotScoping.init();
		QVTcorePrettyPrintVisitor.FACTORY.getClass();
		QVTcoreSaver.FACTORY.getClass();
		QVTcoreToStringVisitor.FACTORY.getClass();
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
		return Guice.createInjector(/*new org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCLRuntimeModule()*/);
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
		if (!EPackage.Registry.INSTANCE.containsKey(QVTcorePackage.eNS_URI))
			EPackage.Registry.INSTANCE.put(QVTcorePackage.eNS_URI, QVTcorePackage.eINSTANCE);

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

