/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.qvtd.xtext.qvtrelation;

import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPivotStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtrelation.scoping.QVTrelationScoping;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class QVTrelationStandaloneSetup extends QVTrelationStandaloneSetupGenerated
{
	private static Injector injector = null;	

	public static void doSetup() {
		if (injector == null) {
			injector = new QVTrelationStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}

	public static void init() {
		QVTrelationPivotStandaloneSetup.doSetup();
		QVTrelationCSPackage.eINSTANCE.getName();
		QVTrelationScoping.init();
//		QVTrelationCS2MonikerVisitor.FACTORY.getClass();
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

	@Override
	public Injector createInjector() {
		init();
		return super.createInjector();
	}
}

