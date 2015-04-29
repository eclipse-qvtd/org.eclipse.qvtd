package org.eclipse.qvtd.cs2as.runtime;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;

public class CS2ASDiagnostic<CS extends EObject> extends BasicDiagnostic {
 
	private CS csObject;
	
	public CS2ASDiagnostic(CS csObject, int severity, String source, int code, String message) {
		super(severity, source, code, message, null);		
		this.csObject = csObject;
	}
	
	/**
	 * A simple (no source, code) CS2AS error diagnostic
	 * @param csObject the source CSObject
	 * @param message the erroneus situation
	 */
	public CS2ASDiagnostic(CS csObject, String message) {
		this(csObject, Diagnostic.ERROR, null, 0, message);		
	}
	
	public CS getCSObject() {
		return csObject;
	}
}
