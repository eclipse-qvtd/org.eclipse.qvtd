/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePivotStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtimperative.attributes.QVTimperativeScoping;
import org.eclipse.qvtd.xtext.qvtimperative.utilities.QVTimperativeASResourceFactory;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
public class QVTimperativeStandaloneSetup extends QVTimperativeStandaloneSetupGenerated
{
	private static Injector injector = null;

	public static void doSetup() {
		assert !EMFPlugin.IS_ECLIPSE_RUNNING;			// Enforces Bug 381901/382058 fix
		if (injector == null) {
			injector = new QVTimperativeStandaloneSetup().createInjectorAndDoEMFRegistration();
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
				injector = Guice.createInjector(new QVTimperativeRuntimeModule());
			}
		}
		return injector;
	}

	public static void init() {
		QVTimperativePivotStandaloneSetup.doSetup();
		QVTimperativeCSPackage.eINSTANCE.getName();
		QVTimperativeScoping.init();
		QVTimperativeASResourceFactory.getInstance();
		//		QVTimperativeCS2MonikerVisitor.FACTORY.getClass();
	}

	@Override
	public Injector createInjector() {
		assert !EMFPlugin.IS_ECLIPSE_RUNNING;
		init();
		injector = super.createInjector();
		return injector;
	}
}

