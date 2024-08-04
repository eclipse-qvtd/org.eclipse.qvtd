/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePivotStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
public class QVTbaseStandaloneSetup extends QVTbaseStandaloneSetupGenerated
{
	private static Injector injector = null;

	public static void doSetup() {
		assert !EMFPlugin.IS_ECLIPSE_RUNNING;			// Enforces Bug 381901/382058 fix
		if (injector == null) {
			injector = new QVTbaseStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}

	public static void init() {
		QVTbasePivotStandaloneSetup.doSetup();
		QVTbaseCSPackage.eINSTANCE.getName();
		//		QVTbaseCS2MonikerVisitor.FACTORY.getClass();
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
				injector = Guice.createInjector(new QVTbaseRuntimeModule());
			}
		}
		return injector;
	}

	@Override
	public Injector createInjector() {
		init();
		return super.createInjector();
	}
}
