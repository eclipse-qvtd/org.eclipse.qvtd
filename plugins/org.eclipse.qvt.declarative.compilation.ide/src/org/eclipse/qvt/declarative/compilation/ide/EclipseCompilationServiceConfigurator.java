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
 * $Id: EclipseCompilationServiceConfigurator.java,v 1.2 2008/10/09 17:21:13 qglineur Exp $
 */
package org.eclipse.qvt.declarative.compilation.ide;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.qvt.declarative.compilation.CompilationService;
import org.eclipse.qvt.declarative.core.ide.EclipseServiceConfiguator;

public class EclipseCompilationServiceConfigurator extends EclipseServiceConfiguator{
	
	private final static Map<String, String> parameters = new HashMap<String, String>();
	
	static {
		parameters.put(NAMESPACE, org.eclipse.qvt.declarative.compilation.ide.Activator.PLUGIN_ID);
		parameters.put(EXTENSION_POINT_NAME, "compilationProvider"); //$NON-NLS-1$
	}
	
	public EclipseCompilationServiceConfigurator() {
		super(CompilationService.getInstance(), parameters);
	}
	
}
