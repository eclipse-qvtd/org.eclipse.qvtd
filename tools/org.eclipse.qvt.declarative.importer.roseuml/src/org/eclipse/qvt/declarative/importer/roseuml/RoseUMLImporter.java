/*******************************************************************************
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.importer.roseuml;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.importer.rose.RoseImporter;
import org.eclipse.qvt.declarative.importer.roseuml.builder.RoseUMLUtil;


/**
 */
public class RoseUMLImporter extends RoseImporter
{
	protected Monitor monitor = null;		// Non-null copy of computeEPackages argument
	
    @Override public Diagnostic computeEPackages(Monitor monitor) throws Exception {
		this.monitor = monitor;
		try {
			return super.computeEPackages(monitor);
		} finally {
			monitor = null;
		}
	}
	
    @Override protected RoseUMLUtil createRoseUtil()
    {
        RoseUMLUtil roseUtil = new RoseUMLUtil(this, createResourceSet().getURIConverter());
        roseUtil.getRoseEcoreBuilder().noQualify = noQualify;
        roseUtil.getRoseEcoreBuilder().unsettablePrimitive = unsettablePrimitive;
        return roseUtil;
    }

	@Override public String getID()
    {
        return "org.eclipse.qvt.declarative.importer.roseuml";
    }

	public Monitor getMonitor() { return monitor; }
}