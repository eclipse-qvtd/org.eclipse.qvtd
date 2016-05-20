package org.eclipse.qvtd.doc.linker;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;

public class LinkerUtil {
	
	public static boolean hasSyntaxError(List<Diagnostic> diagnostics) {
		for (Diagnostic diagnostic : diagnostics) {
			if (diagnostic instanceof XtextSyntaxDiagnostic) {
				return true;
			}
		}
		return false;
	}

}
