/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *******************************************************************************/
/*
 * generated by Xtext 2.10.0
 */
package org.eclipse.qvtd.doc;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class MiniOCLCSStandaloneSetup extends MiniOCLCSStandaloneSetupGenerated {

	public static void doSetup() {
		new MiniOCLCSStandaloneSetup().createInjectorAndDoEMFRegistration();
	}				
}
