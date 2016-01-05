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

/**
 * An AbstractMergedVisitor merges all visits direct to visiting().
 * This can be used by a decorating visitor to execute shared code before redispatching to a decorated visitor.
 */
public abstract class AbstractMergedVisitor<R, C>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	protected AbstractMergedVisitor(C context) {
		super(context);
	}

	@Override
	public R visitA(example1.target.@NonNull A object) {
		return visiting(object);
	}

	@Override
	public R visitA1(example1.target.@NonNull A1 object) {
		return visiting(object);
	}

	@Override
	public R visitA2(example1.target.@NonNull A2 object) {
		return visiting(object);
	}

	@Override
	public R visitA3(example1.target.@NonNull A3 object) {
		return visiting(object);
	}

	@Override
	public R visitB(example1.target.@NonNull B object) {
		return visiting(object);
	}

	@Override
	public R visitC(example1.target.@NonNull C object) {
		return visiting(object);
	}

	@Override
	public R visitD(example1.target.@NonNull D object) {
		return visiting(object);
	}

	@Override
	public R visitNamedElement(example1.target.@NonNull NamedElement object) {
		return visiting(object);
	}

	@Override
	public R visitNamespace(example1.target.@NonNull Namespace object) {
		return visiting(object);
	}

	@Override
	public R visitTRoot(example1.target.@NonNull TRoot object) {
		return visiting(object);
	}
}
