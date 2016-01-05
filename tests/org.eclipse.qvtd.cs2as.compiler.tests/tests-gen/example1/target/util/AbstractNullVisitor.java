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
 * An AbstractNullVisitor provides a default implementation for each
 * visitXxx method that returns null.
 *
 * @deprecated Explicit 'Null' functionality is obsolete with Java 8 @Nullable annotations.  
 */
 @Deprecated
public abstract class AbstractNullVisitor<@Nullable R, C>
	extends AbstractVisitor<R, C>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullVisitor(C context) {
		super(context);
	}	

	@Override
	public R visitA(example1.target.@NonNull A object) {
		return null;
	}

	@Override
	public R visitA1(example1.target.@NonNull A1 object) {
		return null;
	}

	@Override
	public R visitA2(example1.target.@NonNull A2 object) {
		return null;
	}

	@Override
	public R visitA3(example1.target.@NonNull A3 object) {
		return null;
	}

	@Override
	public R visitB(example1.target.@NonNull B object) {
		return null;
	}

	@Override
	public R visitC(example1.target.@NonNull C object) {
		return null;
	}

	@Override
	public R visitD(example1.target.@NonNull D object) {
		return null;
	}

	@Override
	public R visitNamedElement(example1.target.@NonNull NamedElement object) {
		return null;
	}

	@Override
	public R visitNamespace(example1.target.@NonNull Namespace object) {
		return null;
	}

	@Override
	public R visitTRoot(example1.target.@NonNull TRoot object) {
		return null;
	}
}
