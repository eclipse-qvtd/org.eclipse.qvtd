/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/cs2as/compiler/tests/models/example1/TargetMM1.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	example1.target.util;

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
	public R visiting(example1.target.util.@NonNull Visitable visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitA(example1.target.@NonNull A object) {
		return delegate.visitA(object);
	}

	@Override
	public R visitA1(example1.target.@NonNull A1 object) {
		return delegate.visitA1(object);
	}

	@Override
	public R visitA2(example1.target.@NonNull A2 object) {
		return delegate.visitA2(object);
	}

	@Override
	public R visitA3(example1.target.@NonNull A3 object) {
		return delegate.visitA3(object);
	}

	@Override
	public R visitB(example1.target.@NonNull B object) {
		return delegate.visitB(object);
	}

	@Override
	public R visitC(example1.target.@NonNull C object) {
		return delegate.visitC(object);
	}

	@Override
	public R visitD(example1.target.@NonNull D object) {
		return delegate.visitD(object);
	}

	@Override
	public R visitNamedElement(example1.target.@NonNull NamedElement object) {
		return delegate.visitNamedElement(object);
	}

	@Override
	public R visitNamespace(example1.target.@NonNull Namespace object) {
		return delegate.visitNamespace(object);
	}

	@Override
	public R visitTRoot(example1.target.@NonNull TRoot object) {
		return delegate.visitTRoot(object);
	}
}
