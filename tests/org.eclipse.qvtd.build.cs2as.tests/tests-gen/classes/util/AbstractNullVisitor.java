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
	public @Nullable R visitClass(@NonNull classes.Class object) {
		return null;
	}

	@Override
	public @Nullable R visitElement(@NonNull classes.Element object) {
		return null;
	}

	@Override
	public @Nullable R visitNamedElement(@NonNull classes.NamedElement object) {
		return null;
	}

	@Override
	public @Nullable R visitNamespace(@NonNull classes.Namespace object) {
		return null;
	}

	@Override
	public @Nullable R visitPackage(@NonNull classes.Package object) {
		return null;
	}

	@Override
	public @Nullable R visitRoot(@NonNull classes.Root object) {
		return null;
	}
}
