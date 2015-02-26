/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.build.cs2as.tests/src/org/eclipse/qvtd/build/cs2as/tests/models/example2/Classes.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	classes.util;

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
	public @Nullable R visiting(@NonNull classes.util.Visitable visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public @Nullable R visitClass(@NonNull classes.Class object) {
		return delegate.visitClass(object);
	}

	@Override
	public @Nullable R visitElement(@NonNull classes.Element object) {
		return delegate.visitElement(object);
	}

	@Override
	public @Nullable R visitNamedElement(@NonNull classes.NamedElement object) {
		return delegate.visitNamedElement(object);
	}

	@Override
	public @Nullable R visitNamespace(@NonNull classes.Namespace object) {
		return delegate.visitNamespace(object);
	}

	@Override
	public @Nullable R visitPackage(@NonNull classes.Package object) {
		return delegate.visitPackage(object);
	}

	@Override
	public @Nullable R visitRoot(@NonNull classes.Root object) {
		return delegate.visitRoot(object);
	}
}
