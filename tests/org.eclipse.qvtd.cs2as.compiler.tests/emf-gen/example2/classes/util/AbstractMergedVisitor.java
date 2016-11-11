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
	public R visitArgument(example2.classes.@NonNull Argument object) {
		return visiting(object);
	}

	@Override
	public R visitCallExp(example2.classes.@NonNull CallExp object) {
		return visiting(object);
	}

	@Override
	public R visitClass(example2.classes.@NonNull Class object) {
		return visiting(object);
	}

	@Override
	public R visitElement(example2.classes.@NonNull Element object) {
		return visiting(object);
	}

	@Override
	public R visitNamedElement(example2.classes.@NonNull NamedElement object) {
		return visiting(object);
	}

	@Override
	public R visitNamespace(example2.classes.@NonNull Namespace object) {
		return visiting(object);
	}

	@Override
	public R visitOperation(example2.classes.@NonNull Operation object) {
		return visiting(object);
	}

	@Override
	public R visitOperationCallExp(example2.classes.@NonNull OperationCallExp object) {
		return visiting(object);
	}

	@Override
	public R visitPackage(example2.classes.@NonNull Package object) {
		return visiting(object);
	}

	@Override
	public R visitParameter(example2.classes.@NonNull Parameter object) {
		return visiting(object);
	}

	@Override
	public R visitProperty(example2.classes.@NonNull Property object) {
		return visiting(object);
	}

	@Override
	public R visitPropertyCallExp(example2.classes.@NonNull PropertyCallExp object) {
		return visiting(object);
	}

	@Override
	public R visitRoot(example2.classes.@NonNull Root object) {
		return visiting(object);
	}

	@Override
	public R visitTypedElement(example2.classes.@NonNull TypedElement object) {
		return visiting(object);
	}
}
