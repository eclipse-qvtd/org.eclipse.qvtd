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
 * An AbstractExtendingVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingVisitor<R, C>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingVisitor(@NonNull C context) {
		super(context);
	}	

	@Override
	public @Nullable R visitA(@NonNull example1.target.A object) {
		return visitNamespace(object);
	}

	@Override
	public @Nullable R visitA1(@NonNull example1.target.A1 object) {
		return visitA(object);
	}

	@Override
	public @Nullable R visitA2(@NonNull example1.target.A2 object) {
		return visitA(object);
	}

	@Override
	public @Nullable R visitA3(@NonNull example1.target.A3 object) {
		return visitA2(object);
	}

	@Override
	public @Nullable R visitB(@NonNull example1.target.B object) {
		return visitNamespace(object);
	}

	@Override
	public @Nullable R visitC(@NonNull example1.target.C object) {
		return visitNamespace(object);
	}

	@Override
	public @Nullable R visitD(@NonNull example1.target.D object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitNamedElement(@NonNull example1.target.NamedElement object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitNamespace(@NonNull example1.target.Namespace object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitTRoot(@NonNull example1.target.TRoot object) {
		return visiting(object);
	}
}
