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
 * An AbstractNullVisitor provides a default implementation for each
 * visitXxx method that returns null.
 */
public abstract class AbstractNullVisitor<R, C>
	extends AbstractVisitor<R, C>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullVisitor(@NonNull C context) {
		super(context);
	}	

	@Override
	public @Nullable R visitArgument(@NonNull example2.classes.Argument object) {
		return null;
	}

	@Override
	public @Nullable R visitCallExp(@NonNull example2.classes.CallExp object) {
		return null;
	}

	@Override
	public @Nullable R visitClass(@NonNull example2.classes.Class object) {
		return null;
	}

	@Override
	public @Nullable R visitElement(@NonNull example2.classes.Element object) {
		return null;
	}

	@Override
	public @Nullable R visitNamedElement(@NonNull example2.classes.NamedElement object) {
		return null;
	}

	@Override
	public @Nullable R visitNamespace(@NonNull example2.classes.Namespace object) {
		return null;
	}

	@Override
	public @Nullable R visitOperation(@NonNull example2.classes.Operation object) {
		return null;
	}

	@Override
	public @Nullable R visitOperationCallExp(@NonNull example2.classes.OperationCallExp object) {
		return null;
	}

	@Override
	public @Nullable R visitPackage(@NonNull example2.classes.Package object) {
		return null;
	}

	@Override
	public @Nullable R visitParameter(@NonNull example2.classes.Parameter object) {
		return null;
	}

	@Override
	public @Nullable R visitProperty(@NonNull example2.classes.Property object) {
		return null;
	}

	@Override
	public @Nullable R visitPropertyCallExp(@NonNull example2.classes.PropertyCallExp object) {
		return null;
	}

	@Override
	public @Nullable R visitRoot(@NonNull example2.classes.Root object) {
		return null;
	}

	@Override
	public @Nullable R visitTypedElement(@NonNull example2.classes.TypedElement object) {
		return null;
	}
}
