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
 * An AbstractExtendingVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingVisitor<R, C>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractExtendingVisitor(C context) {
		super(context);
	}

	@Override
	public R visitBooleanLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull BooleanLiteralExp object) {
		return visitPrimitiveLiteralExp(object);
	}

	@Override
	public R visitCallExp(org.eclipse.qvtd.doc.miniocl.@NonNull CallExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public R visitClass(org.eclipse.qvtd.doc.miniocl.@NonNull Class object) {
		return visitNamespace(object);
	}

	@Override
	public R visitCollectionItem(org.eclipse.qvtd.doc.miniocl.@NonNull CollectionItem object) {
		return visitCollectionLiteralPart(object);
	}

	@Override
	public R visitCollectionLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull CollectionLiteralExp object) {
		return visitLiteralExp(object);
	}

	@Override
	public R visitCollectionLiteralPart(org.eclipse.qvtd.doc.miniocl.@NonNull CollectionLiteralPart object) {
		return visitTypedElement(object);
	}

	@Override
	public R visitCollectionRange(org.eclipse.qvtd.doc.miniocl.@NonNull CollectionRange object) {
		return visitCollectionLiteralPart(object);
	}

	@Override
	public R visitConstraint(org.eclipse.qvtd.doc.miniocl.@NonNull Constraint object) {
		return visitNamedElement(object);
	}

	@Override
	public R visitElement(org.eclipse.qvtd.doc.miniocl.@NonNull Element object) {
		return visiting(object);
	}

	@Override
	public R visitExpressionInOCL(org.eclipse.qvtd.doc.miniocl.@NonNull ExpressionInOCL object) {
		return visitOpaqueExpression(object);
	}

	@Override
	public R visitFeature(org.eclipse.qvtd.doc.miniocl.@NonNull Feature object) {
		return visitNamedElement(object);
	}

	@Override
	public R visitImport(org.eclipse.qvtd.doc.miniocl.@NonNull Import object) {
		return visitElement(object);
	}

	@Override
	public R visitIntegerLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull IntegerLiteralExp object) {
		return visitPrimitiveLiteralExp(object);
	}

	@Override
	public R visitIterateExp(org.eclipse.qvtd.doc.miniocl.@NonNull IterateExp object) {
		return visitLoopExp(object);
	}

	@Override
	public R visitIteratorExp(org.eclipse.qvtd.doc.miniocl.@NonNull IteratorExp object) {
		return visitLoopExp(object);
	}

	@Override
	public R visitLetExp(org.eclipse.qvtd.doc.miniocl.@NonNull LetExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public R visitLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull LiteralExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public R visitLoopExp(org.eclipse.qvtd.doc.miniocl.@NonNull LoopExp object) {
		return visitCallExp(object);
	}

	@Override
	public R visitNamedElement(org.eclipse.qvtd.doc.miniocl.@NonNull NamedElement object) {
		return visitElement(object);
	}

	@Override
	public R visitNamespace(org.eclipse.qvtd.doc.miniocl.@NonNull Namespace object) {
		return visitNamedElement(object);
	}

	@Override
	public R visitNullLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull NullLiteralExp object) {
		return visitLiteralExp(object);
	}

	@Override
	public R visitOCLExpression(org.eclipse.qvtd.doc.miniocl.@NonNull OCLExpression object) {
		return visitTypedElement(object);
	}

	@Override
	public R visitOpaqueExpression(org.eclipse.qvtd.doc.miniocl.@NonNull OpaqueExpression object) {
		return visitTypedElement(object);
	}

	@Override
	public R visitOperation(org.eclipse.qvtd.doc.miniocl.@NonNull Operation object) {
		return visitFeature(object);
	}

	@Override
	public R visitOperationCallExp(org.eclipse.qvtd.doc.miniocl.@NonNull OperationCallExp object) {
		return visitCallExp(object);
	}

	@Override
	public R visitPackage(org.eclipse.qvtd.doc.miniocl.@NonNull Package object) {
		return visitNamespace(object);
	}

	@Override
	public R visitParameter(org.eclipse.qvtd.doc.miniocl.@NonNull Parameter object) {
		return visitVariable(object);
	}

	@Override
	public R visitPrimitiveLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull PrimitiveLiteralExp object) {
		return visitLiteralExp(object);
	}

	@Override
	public R visitProperty(org.eclipse.qvtd.doc.miniocl.@NonNull Property object) {
		return visitFeature(object);
	}

	@Override
	public R visitPropertyCallExp(org.eclipse.qvtd.doc.miniocl.@NonNull PropertyCallExp object) {
		return visitCallExp(object);
	}

	@Override
	public R visitRoot(org.eclipse.qvtd.doc.miniocl.@NonNull Root object) {
		return visitElement(object);
	}

	@Override
	public R visitTypedElement(org.eclipse.qvtd.doc.miniocl.@NonNull TypedElement object) {
		return visitElement(object);
	}

	@Override
	public R visitVariable(org.eclipse.qvtd.doc.miniocl.@NonNull Variable object) {
		return visitNamedElement(object);
	}

	@Override
	public R visitVariableExp(org.eclipse.qvtd.doc.miniocl.@NonNull VariableExp object) {
		return visitOCLExpression(object);
	}
}
