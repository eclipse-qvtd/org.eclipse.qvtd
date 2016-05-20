/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.doc.miniocl/model/MiniOCL.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.doc.miniocl.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullVisitor provides a default implementation for each
 * visitXxx method that returns null.
 *
 * @deprecated Explicit 'Null' functionality is obsolete with Java 8 @Nullable annotations.  
 */
 @Deprecated
public abstract class AbstractNullVisitor<@Nullable R, C>
	extends AbstractVisitor<R, C>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullVisitor(C context) {
		super(context);
	}	

	@Override
	public R visitCallExp(org.eclipse.qvtd.doc.miniocl.@NonNull CallExp object) {
		return null;
	}

	@Override
	public R visitClass(org.eclipse.qvtd.doc.miniocl.@NonNull Class object) {
		return null;
	}

	@Override
	public R visitConstraint(org.eclipse.qvtd.doc.miniocl.@NonNull Constraint object) {
		return null;
	}

	@Override
	public R visitElement(org.eclipse.qvtd.doc.miniocl.@NonNull Element object) {
		return null;
	}

	@Override
	public R visitExpressionInOCL(org.eclipse.qvtd.doc.miniocl.@NonNull ExpressionInOCL object) {
		return null;
	}

	@Override
	public R visitFeature(org.eclipse.qvtd.doc.miniocl.@NonNull Feature object) {
		return null;
	}

	@Override
	public R visitNamedElement(org.eclipse.qvtd.doc.miniocl.@NonNull NamedElement object) {
		return null;
	}

	@Override
	public R visitNamespace(org.eclipse.qvtd.doc.miniocl.@NonNull Namespace object) {
		return null;
	}

	@Override
	public R visitOCLExpression(org.eclipse.qvtd.doc.miniocl.@NonNull OCLExpression object) {
		return null;
	}

	@Override
	public R visitOperation(org.eclipse.qvtd.doc.miniocl.@NonNull Operation object) {
		return null;
	}

	@Override
	public R visitOperationCallExp(org.eclipse.qvtd.doc.miniocl.@NonNull OperationCallExp object) {
		return null;
	}

	@Override
	public R visitPackage(org.eclipse.qvtd.doc.miniocl.@NonNull Package object) {
		return null;
	}

	@Override
	public R visitParameter(org.eclipse.qvtd.doc.miniocl.@NonNull Parameter object) {
		return null;
	}

	@Override
	public R visitProperty(org.eclipse.qvtd.doc.miniocl.@NonNull Property object) {
		return null;
	}

	@Override
	public R visitPropertyCallExp(org.eclipse.qvtd.doc.miniocl.@NonNull PropertyCallExp object) {
		return null;
	}

	@Override
	public R visitRoot(org.eclipse.qvtd.doc.miniocl.@NonNull Root object) {
		return null;
	}

	@Override
	public R visitTypedElement(org.eclipse.qvtd.doc.miniocl.@NonNull TypedElement object) {
		return null;
	}

	@Override
	public R visitVariable(org.eclipse.qvtd.doc.miniocl.@NonNull Variable object) {
		return null;
	}

	@Override
	public R visitVariableExp(org.eclipse.qvtd.doc.miniocl.@NonNull VariableExp object) {
		return null;
	}
}
