/*******************************************************************************
 * Copyright (c) 2014, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.qvtd.xtext.qvtrelation;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPivotStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtrelation.scoping.QVTrelationScoping;
import org.eclipse.qvtd.xtext.qvtrelation.utilities.QVTrelationASResourceFactory;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
public class QVTrelationStandaloneSetup extends QVTrelationStandaloneSetupGenerated
{
	private static Injector injector = null;

	public static void doSetup() {
		assert !EMFPlugin.IS_ECLIPSE_RUNNING;			// Enforces Bug 381901/382058 fix
		if (injector == null) {
			injector = new QVTrelationStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}

	public static void doTearDown() {
		injector = null;
	}

	/**
	 * Return the Injector for this plugin.
	 */
	public static final Injector getInjector() {
		if (injector == null) {
			if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
				doSetup();
			}
			else {
				injector = Guice.createInjector(new QVTrelationRuntimeModule());
			}
		}
		return injector;
	}

	public static void init() {
		QVTrelationPivotStandaloneSetup.doSetup();
		QVTrelationASResourceFactory.getInstance();
		QVTrelationCSPackage.eINSTANCE.getName();
		QVTrelationScoping.init();
		//		QVTrelationCS2MonikerVisitor.FACTORY.getClass();
	}

	@Override
	public Injector createInjector() {
		assert !EMFPlugin.IS_ECLIPSE_RUNNING;
		init();
		injector = super.createInjector();
		return injector;
	}
}

