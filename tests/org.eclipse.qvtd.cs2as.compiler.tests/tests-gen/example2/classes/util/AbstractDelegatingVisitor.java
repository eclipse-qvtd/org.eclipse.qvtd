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
	public @Nullable R visiting(@NonNull example2.classes.util.Visitable visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public @Nullable R visitArgument(@NonNull example2.classes.Argument object) {
		return delegate.visitArgument(object);
	}

	@Override
	public @Nullable R visitCallExp(@NonNull example2.classes.CallExp object) {
		return delegate.visitCallExp(object);
	}

	@Override
	public @Nullable R visitClass(@NonNull example2.classes.Class object) {
		return delegate.visitClass(object);
	}

	@Override
	public @Nullable R visitElement(@NonNull example2.classes.Element object) {
		return delegate.visitElement(object);
	}

	@Override
	public @Nullable R visitNamedElement(@NonNull example2.classes.NamedElement object) {
		return delegate.visitNamedElement(object);
	}

	@Override
	public @Nullable R visitNamespace(@NonNull example2.classes.Namespace object) {
		return delegate.visitNamespace(object);
	}

	@Override
	public @Nullable R visitOperation(@NonNull example2.classes.Operation object) {
		return delegate.visitOperation(object);
	}

	@Override
	public @Nullable R visitOperationCallExp(@NonNull example2.classes.OperationCallExp object) {
		return delegate.visitOperationCallExp(object);
	}

	@Override
	public @Nullable R visitPackage(@NonNull example2.classes.Package object) {
		return delegate.visitPackage(object);
	}

	@Override
	public @Nullable R visitParameter(@NonNull example2.classes.Parameter object) {
		return delegate.visitParameter(object);
	}

	@Override
	public @Nullable R visitProperty(@NonNull example2.classes.Property object) {
		return delegate.visitProperty(object);
	}

	@Override
	public @Nullable R visitPropertyCallExp(@NonNull example2.classes.PropertyCallExp object) {
		return delegate.visitPropertyCallExp(object);
	}

	@Override
	public @Nullable R visitRoot(@NonNull example2.classes.Root object) {
		return delegate.visitRoot(object);
	}

	@Override
	public @Nullable R visitTypedElement(@NonNull example2.classes.TypedElement object) {
		return delegate.visitTypedElement(object);
	}
}
