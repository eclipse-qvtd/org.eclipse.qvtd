/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/cs2as/compiler/tests/models/example2/Classes.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	example2.classes.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractDelegatingVisitor delegates all visits.
 */
public abstract class AbstractDelegatingVisitor<R, C, D extends Visitor<R>>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	protected final D delegate;
	
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
	@SuppressWarnings("null")
	protected final @NonNull D getDelegate() {
		return delegate;
	}

	@Override
	public R visiting(example2.classes.util.@NonNull Visitable visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitArgument(example2.classes.@NonNull Argument object) {
		return delegate.visitArgument(object);
	}

	@Override
	public R visitCallExp(example2.classes.@NonNull CallExp object) {
		return delegate.visitCallExp(object);
	}

	@Override
	public R visitClass(example2.classes.@NonNull Class object) {
		return delegate.visitClass(object);
	}

	@Override
	public R visitElement(example2.classes.@NonNull Element object) {
		return delegate.visitElement(object);
	}

	@Override
	public R visitNamedElement(example2.classes.@NonNull NamedElement object) {
		return delegate.visitNamedElement(object);
	}

	@Override
	public R visitNamespace(example2.classes.@NonNull Namespace object) {
		return delegate.visitNamespace(object);
	}

	@Override
	public R visitOperation(example2.classes.@NonNull Operation object) {
		return delegate.visitOperation(object);
	}

	@Override
	public R visitOperationCallExp(example2.classes.@NonNull OperationCallExp object) {
		return delegate.visitOperationCallExp(object);
	}

	@Override
	public R visitPackage(example2.classes.@NonNull Package object) {
		return delegate.visitPackage(object);
	}

	@Override
	public R visitParameter(example2.classes.@NonNull Parameter object) {
		return delegate.visitParameter(object);
	}

	@Override
	public R visitProperty(example2.classes.@NonNull Property object) {
		return delegate.visitProperty(object);
	}

	@Override
	public R visitPropertyCallExp(example2.classes.@NonNull PropertyCallExp object) {
		return delegate.visitPropertyCallExp(object);
	}

	@Override
	public R visitRoot(example2.classes.@NonNull Root object) {
		return delegate.visitRoot(object);
	}

	@Override
	public R visitTypedElement(example2.classes.@NonNull TypedElement object) {
		return delegate.visitTypedElement(object);
	}
}
