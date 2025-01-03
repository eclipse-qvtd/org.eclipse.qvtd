/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/*
 * generated by Xtext 2.16.0
 */
package org.eclipse.qvtd.doc.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.qvtd.doc.MiniOCLCSRuntimeModule;
import org.eclipse.qvtd.doc.MiniOCLCSStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class MiniOCLCSIdeSetup extends MiniOCLCSStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new MiniOCLCSRuntimeModule(), new MiniOCLCSIdeModule()));
	}
	
}
