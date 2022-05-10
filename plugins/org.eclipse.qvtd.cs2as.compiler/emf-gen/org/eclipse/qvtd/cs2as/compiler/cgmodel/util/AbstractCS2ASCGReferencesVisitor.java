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

import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.codegen.qvticgmodel.utilities.QVTiCGModelReferencesVisitor;

/**
 * An AbstractCS2ASCGReferencesVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractCS2ASCGReferencesVisitor
	extends QVTiCGModelReferencesVisitor
	implements CS2ASCGModelVisitor<@NonNull List<@Nullable Object>>
{
	protected AbstractCS2ASCGReferencesVisitor(@Nullable Object context) {
		super(context);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGLookupCallExp(org.eclipse.qvtd.cs2as.compiler.cgmodel.@NonNull CGLookupCallExp object) {
		return visitCGOperationCallExp(object);
	}
}
