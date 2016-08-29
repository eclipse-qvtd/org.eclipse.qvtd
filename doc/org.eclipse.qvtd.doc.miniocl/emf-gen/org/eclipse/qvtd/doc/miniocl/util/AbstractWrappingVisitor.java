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
 * An AbstractWrappingVisitor delegates all visits wrapping the delegation in a call to a preVisit function and a postVisit function.
 */
public abstract class AbstractWrappingVisitor<R, C, @NonNull D extends Visitor<R>, P>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	protected final @NonNull D delegate;
	
	protected AbstractWrappingVisitor(@NonNull D delegate, C context) {
		super(context);
		this.delegate = delegate;		
	//	delegate.setUndecoratedVisitor(this);
	}

	/**
	 * Intercept an exception thrown by the delegated visit to perform some post-functionality that may use the visitable object,
	 * the result of preVisit and the thrown exception to determine the overall wrapped result.
	 * 
	 * @return a rethrown RuntimeException or a RuntimeException-wrapped non-RuntimeException.
	 */
	protected R badVisit(org.eclipse.qvtd.doc.miniocl.util.@NonNull Visitable visitable, @Nullable P prologue, @NonNull Throwable e) throws RuntimeException {
		if (e instanceof Exception) {
			throw (RuntimeException)e;
		}
		else {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Obtains the visitor that I wrap.
	 * 
	 * @return my wrapped visitor
	 */
	protected @NonNull D getDelegate() {
		return delegate;
	}

	/**
	 * Intercept the result of the delegated visit to perform some post-functionality that may use the visitable object,
	 * the result of preVisit and the result of the delegated visit to determine the overall wrapped result.
	 * 
	 * @return the epilogue result, which defaults to the delegated result.
	 */
	protected R postVisit(org.eclipse.qvtd.doc.miniocl.util.@NonNull Visitable visitable, @Nullable P prologue, R result) {
		return result;
	}

	/**
	 * Compute and return some value before performing the delegated visit.
	 * 
	 * @return the prologue result, which defauilts to null.
	 */
	protected @Nullable P preVisit(org.eclipse.qvtd.doc.miniocl.util.@NonNull Visitable visitable) {
		return null;
	}

	@Override
	public R visiting(org.eclipse.qvtd.doc.miniocl.util.@NonNull Visitable visitable) {
		throw new UnsupportedOperationException();		// Cannot happen since all methods delegate.
	}

	@Override
	public R visitBooleanLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull BooleanLiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBooleanLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCallExp(org.eclipse.qvtd.doc.miniocl.@NonNull CallExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitClass(org.eclipse.qvtd.doc.miniocl.@NonNull Class object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitClass(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCollectionItem(org.eclipse.qvtd.doc.miniocl.@NonNull CollectionItem object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCollectionItem(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCollectionLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull CollectionLiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCollectionLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCollectionLiteralPart(org.eclipse.qvtd.doc.miniocl.@NonNull CollectionLiteralPart object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCollectionLiteralPart(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCollectionRange(org.eclipse.qvtd.doc.miniocl.@NonNull CollectionRange object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCollectionRange(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitConstraint(org.eclipse.qvtd.doc.miniocl.@NonNull Constraint object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitConstraint(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitElement(org.eclipse.qvtd.doc.miniocl.@NonNull Element object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitElement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitExpressionInOCL(org.eclipse.qvtd.doc.miniocl.@NonNull ExpressionInOCL object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitExpressionInOCL(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitFeature(org.eclipse.qvtd.doc.miniocl.@NonNull Feature object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitFeature(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitImport(org.eclipse.qvtd.doc.miniocl.@NonNull Import object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitImport(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitIntegerLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull IntegerLiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitIntegerLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitIterateExp(org.eclipse.qvtd.doc.miniocl.@NonNull IterateExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitIterateExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitIteratorExp(org.eclipse.qvtd.doc.miniocl.@NonNull IteratorExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitIteratorExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLetExp(org.eclipse.qvtd.doc.miniocl.@NonNull LetExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLetExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull LiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLoopExp(org.eclipse.qvtd.doc.miniocl.@NonNull LoopExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLoopExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNamedElement(org.eclipse.qvtd.doc.miniocl.@NonNull NamedElement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNamedElement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNamespace(org.eclipse.qvtd.doc.miniocl.@NonNull Namespace object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNamespace(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNullLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull NullLiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNullLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitOCLExpression(org.eclipse.qvtd.doc.miniocl.@NonNull OCLExpression object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOCLExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitOpaqueExpression(org.eclipse.qvtd.doc.miniocl.@NonNull OpaqueExpression object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOpaqueExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitOperation(org.eclipse.qvtd.doc.miniocl.@NonNull Operation object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOperation(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitOperationCallExp(org.eclipse.qvtd.doc.miniocl.@NonNull OperationCallExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOperationCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPackage(org.eclipse.qvtd.doc.miniocl.@NonNull Package object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPackage(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitParameter(org.eclipse.qvtd.doc.miniocl.@NonNull Parameter object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitParameter(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPrimitiveLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull PrimitiveLiteralExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPrimitiveLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitProperty(org.eclipse.qvtd.doc.miniocl.@NonNull Property object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitProperty(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPropertyCallExp(org.eclipse.qvtd.doc.miniocl.@NonNull PropertyCallExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPropertyCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitRoot(org.eclipse.qvtd.doc.miniocl.@NonNull Root object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitRoot(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTypedElement(org.eclipse.qvtd.doc.miniocl.@NonNull TypedElement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTypedElement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitVariable(org.eclipse.qvtd.doc.miniocl.@NonNull Variable object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitVariable(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitVariableExp(org.eclipse.qvtd.doc.miniocl.@NonNull VariableExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitVariableExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}
}
