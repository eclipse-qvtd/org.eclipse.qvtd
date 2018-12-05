/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations Ltd, University of York and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   Adolfo Sanchez-Barbudo Herrera (UoY) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.internal.cs2as;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;

public class CS2ASDiagnostic extends BasicDiagnostic {
 
	private EObject csObject;
	
	public CS2ASDiagnostic(EObject csObject, int severity, String source, int code, String message) {
		super(severity, source, code, message, null);		
		this.csObject = csObject;
	}
	
	/**
	 * A simple (no source, code) CS2AS error diagnostic
	 * @param csObject the source CSObject
	 * @param message the erroneus situation
	 */
	public CS2ASDiagnostic(EObject csObject, String message) {
		this(csObject, Diagnostic.ERROR, null, 0, message);		
	}
	
	public EObject getCSObject() {
		return csObject;
	}
}
