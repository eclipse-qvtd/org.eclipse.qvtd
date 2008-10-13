/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * </copyright>
 * 
 * Contributors:
 *     Quentin Glineur - initial API and implementation
 *
 * $Id: EclipseExecutionServiceConfigurator.java,v 1.3 2008/10/13 16:21:50 qglineur Exp $
 */
package org.eclipse.qvt.declarative.execution.ide;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.qvt.declarative.core.ide.EclipseServiceConfiguator;
import org.eclipse.qvt.declarative.execution.ExecutionService;

public class EclipseExecutionServiceConfigurator extends
		EclipseServiceConfiguator {
	
	private final static Map<String, String> parameters = new HashMap<String, String>();
	
	private static boolean IS_INITIALIZED;
	
	static {
		parameters.put(NAMESPACE, org.eclipse.qvt.declarative.execution.ide.Activator.PLUGIN_ID);
		parameters.put(EXTENSION_POINT_NAME, "executionProvider"); //$NON-NLS-1$
		IS_INITIALIZED = false;
	}
	
	private EclipseExecutionServiceConfigurator(){
		super(ExecutionService.getInstance(), parameters);
	}
	
	public static void assertInitialized() {
		if (!IS_INITIALIZED) {
			new EclipseExecutionServiceConfigurator();
			IS_INITIALIZED = true;
		}
	}
	
}
