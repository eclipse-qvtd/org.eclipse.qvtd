/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.qvtd.umlx.utilities;

import java.util.Map;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.labels.RelPatternEdgeLabelGenerator;
import org.eclipse.qvtd.umlx.labels.UMLXModelLabelGenerator;
import org.eclipse.qvtd.umlx.labels.UMLXNamedElementLabelGenerator;
import org.eclipse.qvtd.umlx.labels.RelDomainNodeLabelGenerator;
import org.eclipse.qvtd.umlx.labels.RelPatternNodeLabelGenerator;
import org.eclipse.qvtd.umlx.resource.UMLXResourceFactoryImpl;
import org.eclipse.qvtd.umlx.util.UMLXValidator;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for UMLX models without equinox extension registry
 */
public class UMLXStandaloneSetup
{
	private static Injector injector = null;

	public static void doSetup() {
		if (injector == null) {
			new UMLXStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}

	public static void doTearDown() {
		injector = null;
	}

	public static void init() {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("umlx", new UMLXResourceFactoryImpl());
		}
		EPackage.Registry.INSTANCE.put(UMLXPackage.eNS_URI, UMLXPackage.eINSTANCE);
		EValidator.Registry.INSTANCE.put(UMLXPackage.eINSTANCE, UMLXValidator.INSTANCE);
		RelDomainNodeLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
		RelPatternNodeLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
		RelPatternEdgeLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
		UMLXModelLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
		UMLXNamedElementLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
	}

	/**
	 * Return the Injector for this plugin.
	 */
	public static final Injector getInjector() {
		return injector;
	}

	public Injector createInjector() {
		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		if (extensionToFactoryMap.containsKey("xmi"))
			extensionToFactoryMap.remove("xmi");
		String defaultExtension = Resource.Factory.Registry.DEFAULT_EXTENSION;
		if (!extensionToFactoryMap.containsKey(defaultExtension))
			extensionToFactoryMap.put(defaultExtension, new XMIResourceFactoryImpl());
		injector = Guice.createInjector(/*new PivotRuntimeModule()*/);
		return injector;
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
		if (!EPackage.Registry.INSTANCE.containsKey(UMLXPackage.eNS_URI))
			EPackage.Registry.INSTANCE.put(UMLXPackage.eNS_URI, UMLXPackage.eINSTANCE);

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

