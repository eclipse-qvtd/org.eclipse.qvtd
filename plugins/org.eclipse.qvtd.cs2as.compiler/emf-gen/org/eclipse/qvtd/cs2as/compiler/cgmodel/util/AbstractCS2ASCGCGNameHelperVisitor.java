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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.naming.NameManagerHelper;
import org.eclipse.qvtd.codegen.qvticgmodel.utilities.QVTiCGModelCGNameHelperVisitor;

/**
 * An AbstractCS2ASCGCGNameHelperVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractCS2ASCGCGNameHelperVisitor
extends QVTiCGModelCGNameHelperVisitor
implements CS2ASCGModelVisitor<@NonNull String>
{
	protected AbstractCS2ASCGCGNameHelperVisitor(@NonNull NameManagerHelper context) {
		super(context);
	}

	@Override
	public @NonNull String visitCGLookupCallExp(org.eclipse.qvtd.cs2as.compiler.cgmodel.@NonNull CGLookupCallExp object) {
		return visitCGOperationCallExp(object);
	}
}
