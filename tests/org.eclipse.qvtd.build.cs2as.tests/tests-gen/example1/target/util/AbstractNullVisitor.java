/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/build/cs2as/tests/models/example1/TargetMM1.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	example1.target.util;

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
	public @Nullable R visitA(@NonNull example1.target.A object) {
		return null;
	}

	@Override
	public @Nullable R visitA1(@NonNull example1.target.A1 object) {
		return null;
	}

	@Override
	public @Nullable R visitA2(@NonNull example1.target.A2 object) {
		return null;
	}

	@Override
	public @Nullable R visitA3(@NonNull example1.target.A3 object) {
		return null;
	}

	@Override
	public @Nullable R visitB(@NonNull example1.target.B object) {
		return null;
	}

	@Override
	public @Nullable R visitC(@NonNull example1.target.C object) {
		return null;
	}

	@Override
	public @Nullable R visitD(@NonNull example1.target.D object) {
		return null;
	}

	@Override
	public @Nullable R visitNamedElement(@NonNull example1.target.NamedElement object) {
		return null;
	}

	@Override
	public @Nullable R visitNamespace(@NonNull example1.target.Namespace object) {
		return null;
	}

	@Override
	public @Nullable R visitTRoot(@NonNull example1.target.TRoot object) {
		return null;
	}
}
