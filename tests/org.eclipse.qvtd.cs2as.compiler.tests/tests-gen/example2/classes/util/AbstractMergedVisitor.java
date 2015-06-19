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
	public @Nullable R visitClass(@NonNull example2.classes.Class object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitElement(@NonNull example2.classes.Element object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitNamedElement(@NonNull example2.classes.NamedElement object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitNamespace(@NonNull example2.classes.Namespace object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitPackage(@NonNull example2.classes.Package object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitRoot(@NonNull example2.classes.Root object) {
		return visiting(object);
	}
}
