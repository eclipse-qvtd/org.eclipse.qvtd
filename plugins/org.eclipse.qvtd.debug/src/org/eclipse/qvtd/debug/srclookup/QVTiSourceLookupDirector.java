/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.srclookup;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.srclookup.VMSourceLookupDirector;
import org.eclipse.qvtd.debug.core.QVTiDebugCore;

public class QVTiSourceLookupDirector extends VMSourceLookupDirector
{	
	@Override
	protected @NonNull QVTiDebugCore getDebugCore() {
		return QVTiDebugCore.INSTANCE;
	}	
}
