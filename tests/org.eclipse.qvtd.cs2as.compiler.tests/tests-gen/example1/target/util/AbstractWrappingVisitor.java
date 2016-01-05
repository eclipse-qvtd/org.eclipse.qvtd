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
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractWrappingVisitor delegates all visits wrapping the delegation in a call to a preVisit function and a postVisit function.
 */
public abstract class AbstractWrappingVisitor<R, C, D extends Visitor<R>, P>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	protected final D delegate;
	
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
	protected R badVisit(example1.target.util.@NonNull Visitable visitable, @Nullable P prologue, @NonNull Throwable e) throws RuntimeException {
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
	@SuppressWarnings("null")
	protected @NonNull D getDelegate() {
		return delegate;
	}

	/**
	 * Intercept the result of the delegated visit to perform some post-functionality that may use the visitable object,
	 * the result of preVisit and the result of the delegated visit to determine the overall wrapped result.
	 * 
	 * @return the epilogue result, which defaults to the delegated result.
	 */
	protected R postVisit(example1.target.util.@NonNull Visitable visitable, @Nullable P prologue, R result) {
		return result;
	}

	/**
	 * Compute and return some value before performing the delegated visit.
	 * 
	 * @return the prologue result, which defauilts to null.
	 */
	protected @Nullable P preVisit(example1.target.util.@NonNull Visitable visitable) {
		return null;
	}

	@Override
	public R visiting(example1.target.util.@NonNull Visitable visitable) {
		throw new UnsupportedOperationException();		// Cannot happen since all methods delegate.
	}

	@Override
	public R visitA(example1.target.@NonNull A object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitA(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitA1(example1.target.@NonNull A1 object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitA1(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitA2(example1.target.@NonNull A2 object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitA2(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitA3(example1.target.@NonNull A3 object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitA3(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitB(example1.target.@NonNull B object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitB(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitC(example1.target.@NonNull C object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitC(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitD(example1.target.@NonNull D object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitD(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNamedElement(example1.target.@NonNull NamedElement object) {
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
	public R visitNamespace(example1.target.@NonNull Namespace object) {
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
	public R visitTRoot(example1.target.@NonNull TRoot object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTRoot(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}
}
