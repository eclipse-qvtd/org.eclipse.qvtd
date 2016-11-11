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
	public R visitArgument(example2.classes.@NonNull Argument object) {
		return null;
	}

	@Override
	public R visitCallExp(example2.classes.@NonNull CallExp object) {
		return null;
	}

	@Override
	public R visitClass(example2.classes.@NonNull Class object) {
		return null;
	}

	@Override
	public R visitElement(example2.classes.@NonNull Element object) {
		return null;
	}

	@Override
	public R visitNamedElement(example2.classes.@NonNull NamedElement object) {
		return null;
	}

	@Override
	public R visitNamespace(example2.classes.@NonNull Namespace object) {
		return null;
	}

	@Override
	public R visitOperation(example2.classes.@NonNull Operation object) {
		return null;
	}

	@Override
	public R visitOperationCallExp(example2.classes.@NonNull OperationCallExp object) {
		return null;
	}

	@Override
	public R visitPackage(example2.classes.@NonNull Package object) {
		return null;
	}

	@Override
	public R visitParameter(example2.classes.@NonNull Parameter object) {
		return null;
	}

	@Override
	public R visitProperty(example2.classes.@NonNull Property object) {
		return null;
	}

	@Override
	public R visitPropertyCallExp(example2.classes.@NonNull PropertyCallExp object) {
		return null;
	}

	@Override
	public R visitRoot(example2.classes.@NonNull Root object) {
		return null;
	}

	@Override
	public R visitTypedElement(example2.classes.@NonNull TypedElement object) {
		return null;
	}
}
