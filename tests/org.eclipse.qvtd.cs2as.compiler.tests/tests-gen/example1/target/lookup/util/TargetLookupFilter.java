/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/cs2as/compiler/tests/models/example1/TargetMM1.genmodel
 * template: org.eclipse.ocl.examples.build.xtend.GenerateAutoLookupInfrastructureXtend
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	example1.target.lookup.util;

import org.eclipse.jdt.annotation.NonNull;
import example1.target.NamedElement;

/**
 * 
 */
public interface TargetLookupFilter {
	
	boolean matches(@NonNull NamedElement namedElement);
	
}
