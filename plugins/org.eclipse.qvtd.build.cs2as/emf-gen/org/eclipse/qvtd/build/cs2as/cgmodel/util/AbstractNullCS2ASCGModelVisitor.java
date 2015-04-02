/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.build.cs2as/model/cs2ascgmodel.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.build.cs2as.cgmodel.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullCS2ASCGModelVisitor provides a default implementation for each
 * visitXxx method that returns null.
 */
public abstract class AbstractNullCS2ASCGModelVisitor<R, C>
	extends org.eclipse.ocl.examples.codegen.cgmodel.util.AbstractNullCGModelVisitor<R, C> implements CS2ASCGModelVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullCS2ASCGModelVisitor(@NonNull C context) {
		super(context);
	}	

	@Override
	public @Nullable R visitCGLookupCallExp(@NonNull org.eclipse.qvtd.build.cs2as.cgmodel.CGLookupCallExp object) {
		return null;
	}
}
