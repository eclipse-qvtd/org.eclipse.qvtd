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
 * An AbstractDelegatingVisitor delegates all visits.
 */
public abstract class AbstractDelegatingVisitor<R, C, @NonNull D extends Visitor<R>>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	protected final @NonNull D delegate;
	
	protected AbstractDelegatingVisitor(@NonNull D delegate, C context) {
		super(context);
	//	assert delegate != null : "cannot decorate a null visitor"; //$NON-NLS-1$
		this.delegate = delegate;		
	//	delegate.setUndecoratedVisitor(this);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	//	public @NonNull DecorableVisitor<R> createNestedVisitor() {
	//		return delegate.createNestedVisitor();
	//	}

	/**
	 * Obtains the visitor that I decorate.
	 * 
	 * @return my decorated visitor
	 */
	protected final @NonNull D getDelegate() {
		return delegate;
	}

	@Override
	public R visiting(org.eclipse.qvtd.doc.miniocl.util.@NonNull Visitable visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitBooleanLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull BooleanLiteralExp object) {
		return delegate.visitBooleanLiteralExp(object);
	}

	@Override
	public R visitCallExp(org.eclipse.qvtd.doc.miniocl.@NonNull CallExp object) {
		return delegate.visitCallExp(object);
	}

	@Override
	public R visitClass(org.eclipse.qvtd.doc.miniocl.@NonNull Class object) {
		return delegate.visitClass(object);
	}

	@Override
	public R visitCollectionItem(org.eclipse.qvtd.doc.miniocl.@NonNull CollectionItem object) {
		return delegate.visitCollectionItem(object);
	}

	@Override
	public R visitCollectionLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull CollectionLiteralExp object) {
		return delegate.visitCollectionLiteralExp(object);
	}

	@Override
	public R visitCollectionLiteralPart(org.eclipse.qvtd.doc.miniocl.@NonNull CollectionLiteralPart object) {
		return delegate.visitCollectionLiteralPart(object);
	}

	@Override
	public R visitCollectionRange(org.eclipse.qvtd.doc.miniocl.@NonNull CollectionRange object) {
		return delegate.visitCollectionRange(object);
	}

	@Override
	public R visitConstraint(org.eclipse.qvtd.doc.miniocl.@NonNull Constraint object) {
		return delegate.visitConstraint(object);
	}

	@Override
	public R visitElement(org.eclipse.qvtd.doc.miniocl.@NonNull Element object) {
		return delegate.visitElement(object);
	}

	@Override
	public R visitExpressionInOCL(org.eclipse.qvtd.doc.miniocl.@NonNull ExpressionInOCL object) {
		return delegate.visitExpressionInOCL(object);
	}

	@Override
	public R visitFeature(org.eclipse.qvtd.doc.miniocl.@NonNull Feature object) {
		return delegate.visitFeature(object);
	}

	@Override
	public R visitImport(org.eclipse.qvtd.doc.miniocl.@NonNull Import object) {
		return delegate.visitImport(object);
	}

	@Override
	public R visitIntegerLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull IntegerLiteralExp object) {
		return delegate.visitIntegerLiteralExp(object);
	}

	@Override
	public R visitIterateExp(org.eclipse.qvtd.doc.miniocl.@NonNull IterateExp object) {
		return delegate.visitIterateExp(object);
	}

	@Override
	public R visitIteratorExp(org.eclipse.qvtd.doc.miniocl.@NonNull IteratorExp object) {
		return delegate.visitIteratorExp(object);
	}

	@Override
	public R visitLetExp(org.eclipse.qvtd.doc.miniocl.@NonNull LetExp object) {
		return delegate.visitLetExp(object);
	}

	@Override
	public R visitLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull LiteralExp object) {
		return delegate.visitLiteralExp(object);
	}

	@Override
	public R visitLoopExp(org.eclipse.qvtd.doc.miniocl.@NonNull LoopExp object) {
		return delegate.visitLoopExp(object);
	}

	@Override
	public R visitNamedElement(org.eclipse.qvtd.doc.miniocl.@NonNull NamedElement object) {
		return delegate.visitNamedElement(object);
	}

	@Override
	public R visitNamespace(org.eclipse.qvtd.doc.miniocl.@NonNull Namespace object) {
		return delegate.visitNamespace(object);
	}

	@Override
	public R visitNullLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull NullLiteralExp object) {
		return delegate.visitNullLiteralExp(object);
	}

	@Override
	public R visitOCLExpression(org.eclipse.qvtd.doc.miniocl.@NonNull OCLExpression object) {
		return delegate.visitOCLExpression(object);
	}

	@Override
	public R visitOpaqueExpression(org.eclipse.qvtd.doc.miniocl.@NonNull OpaqueExpression object) {
		return delegate.visitOpaqueExpression(object);
	}

	@Override
	public R visitOperation(org.eclipse.qvtd.doc.miniocl.@NonNull Operation object) {
		return delegate.visitOperation(object);
	}

	@Override
	public R visitOperationCallExp(org.eclipse.qvtd.doc.miniocl.@NonNull OperationCallExp object) {
		return delegate.visitOperationCallExp(object);
	}

	@Override
	public R visitPackage(org.eclipse.qvtd.doc.miniocl.@NonNull Package object) {
		return delegate.visitPackage(object);
	}

	@Override
	public R visitParameter(org.eclipse.qvtd.doc.miniocl.@NonNull Parameter object) {
		return delegate.visitParameter(object);
	}

	@Override
	public R visitPrimitiveLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull PrimitiveLiteralExp object) {
		return delegate.visitPrimitiveLiteralExp(object);
	}

	@Override
	public R visitProperty(org.eclipse.qvtd.doc.miniocl.@NonNull Property object) {
		return delegate.visitProperty(object);
	}

	@Override
	public R visitPropertyCallExp(org.eclipse.qvtd.doc.miniocl.@NonNull PropertyCallExp object) {
		return delegate.visitPropertyCallExp(object);
	}

	@Override
	public R visitRoot(org.eclipse.qvtd.doc.miniocl.@NonNull Root object) {
		return delegate.visitRoot(object);
	}

	@Override
	public R visitTypedElement(org.eclipse.qvtd.doc.miniocl.@NonNull TypedElement object) {
		return delegate.visitTypedElement(object);
	}

	@Override
	public R visitVariable(org.eclipse.qvtd.doc.miniocl.@NonNull Variable object) {
		return delegate.visitVariable(object);
	}

	@Override
	public R visitVariableExp(org.eclipse.qvtd.doc.miniocl.@NonNull VariableExp object) {
		return delegate.visitVariableExp(object);
	}
}
