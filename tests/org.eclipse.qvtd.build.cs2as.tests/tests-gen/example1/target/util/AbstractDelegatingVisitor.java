/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.build.cs2as.tests/src/org/eclipse/qvtd/build/cs2as/tests/models/example1/TargetMM1.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	example1.target.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingVisitor delegates all visits.
 */
public abstract class AbstractDelegatingVisitor<R, C, D extends Visitor<R>>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	protected final D delegate;
	
	protected AbstractDelegatingVisitor(@NonNull D delegate, @NonNull C context) {
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
	public @Nullable R visiting(@NonNull example1.target.util.Visitable visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public @Nullable R visitA(@NonNull example1.target.A object) {
		return delegate.visitA(object);
	}

	@Override
	public @Nullable R visitA1(@NonNull example1.target.A1 object) {
		return delegate.visitA1(object);
	}

	@Override
	public @Nullable R visitA2(@NonNull example1.target.A2 object) {
		return delegate.visitA2(object);
	}

	@Override
	public @Nullable R visitA3(@NonNull example1.target.A3 object) {
		return delegate.visitA3(object);
	}

	@Override
	public @Nullable R visitB(@NonNull example1.target.B object) {
		return delegate.visitB(object);
	}

	@Override
	public @Nullable R visitC(@NonNull example1.target.C object) {
		return delegate.visitC(object);
	}

	@Override
	public @Nullable R visitD(@NonNull example1.target.D object) {
		return delegate.visitD(object);
	}

	@Override
	public @Nullable R visitNamedElement(@NonNull example1.target.NamedElement object) {
		return delegate.visitNamedElement(object);
	}

	@Override
	public @Nullable R visitNamespace(@NonNull example1.target.Namespace object) {
		return delegate.visitNamespace(object);
	}

	@Override
	public @Nullable R visitTRoot(@NonNull example1.target.TRoot object) {
		return delegate.visitTRoot(object);
	}
}
