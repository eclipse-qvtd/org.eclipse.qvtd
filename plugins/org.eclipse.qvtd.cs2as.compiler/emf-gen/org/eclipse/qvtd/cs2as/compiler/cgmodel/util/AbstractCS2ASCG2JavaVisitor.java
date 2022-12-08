/*******************************************************************************
 * <copyright>
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.cs2as.compiler/model/cs2ascgmodel.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.cs2as.compiler.cgmodel.util;

import java.lang.Iterable;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

/**
 * An AbstractCS2ASCG2JavaVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractCS2ASCG2JavaVisitor
extends org.eclipse.qvtd.codegen.qvti.java.QVTiCG2JavaVisitor
implements CS2ASCGModelVisitor<@NonNull Boolean>
{
	protected AbstractCS2ASCG2JavaVisitor(@NonNull QVTiCodeGenerator codeGenerator, @Nullable Iterable<@NonNull CGValuedElement> sortedGlobals) {
		super(codeGenerator, sortedGlobals);
	}

	@Override
	public @NonNull Boolean visitCGLookupCallExp(org.eclipse.qvtd.cs2as.compiler.cgmodel.@NonNull CGLookupCallExp object) {
		return visitCGOperationCallExp(object);
	}
}
