/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/build/cs2as/tests/models/example2/Classes.genmodel
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
	public @Nullable R visitPackage(@NonNull example2.classes.Package object) {
		return null;
	}

	@Override
	public @Nullable R visitRoot(@NonNull example2.classes.Root object) {
		return null;
	}
}
