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

/**
 * An AbstractMergedVisitor merges all visits direct to visiting().
 * This can be used by a decorating visitor to execute shared code before redispatching to a decorated visitor.
 */
public abstract class AbstractMergedVisitor<R, C>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	protected AbstractMergedVisitor(C context) {
		super(context);
	}

	@Override
	public R visitCallExp(org.eclipse.qvtd.doc.miniocl.@NonNull CallExp object) {
		return visiting(object);
	}

	@Override
	public R visitClass(org.eclipse.qvtd.doc.miniocl.@NonNull Class object) {
		return visiting(object);
	}

	@Override
	public R visitConstraint(org.eclipse.qvtd.doc.miniocl.@NonNull Constraint object) {
		return visiting(object);
	}

	@Override
	public R visitElement(org.eclipse.qvtd.doc.miniocl.@NonNull Element object) {
		return visiting(object);
	}

	@Override
	public R visitExpressionInOCL(org.eclipse.qvtd.doc.miniocl.@NonNull ExpressionInOCL object) {
		return visiting(object);
	}

	@Override
	public R visitFeature(org.eclipse.qvtd.doc.miniocl.@NonNull Feature object) {
		return visiting(object);
	}

	@Override
	public R visitNamedElement(org.eclipse.qvtd.doc.miniocl.@NonNull NamedElement object) {
		return visiting(object);
	}

	@Override
	public R visitNamespace(org.eclipse.qvtd.doc.miniocl.@NonNull Namespace object) {
		return visiting(object);
	}

	@Override
	public R visitOCLExpression(org.eclipse.qvtd.doc.miniocl.@NonNull OCLExpression object) {
		return visiting(object);
	}

	@Override
	public R visitOperation(org.eclipse.qvtd.doc.miniocl.@NonNull Operation object) {
		return visiting(object);
	}

	@Override
	public R visitOperationCallExp(org.eclipse.qvtd.doc.miniocl.@NonNull OperationCallExp object) {
		return visiting(object);
	}

	@Override
	public R visitPackage(org.eclipse.qvtd.doc.miniocl.@NonNull Package object) {
		return visiting(object);
	}

	@Override
	public R visitParameter(org.eclipse.qvtd.doc.miniocl.@NonNull Parameter object) {
		return visiting(object);
	}

	@Override
	public R visitProperty(org.eclipse.qvtd.doc.miniocl.@NonNull Property object) {
		return visiting(object);
	}

	@Override
	public R visitPropertyCallExp(org.eclipse.qvtd.doc.miniocl.@NonNull PropertyCallExp object) {
		return visiting(object);
	}

	@Override
	public R visitRoot(org.eclipse.qvtd.doc.miniocl.@NonNull Root object) {
		return visiting(object);
	}

	@Override
	public R visitTypedElement(org.eclipse.qvtd.doc.miniocl.@NonNull TypedElement object) {
		return visiting(object);
	}

	@Override
	public R visitVariable(org.eclipse.qvtd.doc.miniocl.@NonNull Variable object) {
		return visiting(object);
	}

	@Override
	public R visitVariableExp(org.eclipse.qvtd.doc.miniocl.@NonNull VariableExp object) {
		return visiting(object);
	}
}
