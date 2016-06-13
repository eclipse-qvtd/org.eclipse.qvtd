/*******************************************************************************
 * Copyright (c) 2011, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class QVTbaseStandaloneSetup extends QVTbaseStandaloneSetupGenerated{

	public static void doSetup() {
		new QVTbaseStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

