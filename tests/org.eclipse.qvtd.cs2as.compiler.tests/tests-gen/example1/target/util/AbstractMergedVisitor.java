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
 * An AbstractMergedVisitor merges all visits direct to visiting().
 * This can be used by a decorating visitor to execute shared code before redispatching to a decorated visitor.
 */
public abstract class AbstractMergedVisitor<R, C>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	protected AbstractMergedVisitor(@NonNull C context) {
		super(context);
	}

	@Override
	public @Nullable R visitA(@NonNull example1.target.A object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitA1(@NonNull example1.target.A1 object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitA2(@NonNull example1.target.A2 object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitA3(@NonNull example1.target.A3 object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitB(@NonNull example1.target.B object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitC(@NonNull example1.target.C object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitD(@NonNull example1.target.D object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitNamedElement(@NonNull example1.target.NamedElement object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitNamespace(@NonNull example1.target.Namespace object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitTRoot(@NonNull example1.target.TRoot object) {
		return visiting(object);
	}
}
