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
	protected AbstractExtendingVisitor(C context) {
		super(context);
	}	

	@Override
	public R visitArgument(example2.classes.@NonNull Argument object) {
		return visitNamedElement(object);
	}

	@Override
	public R visitCallExp(example2.classes.@NonNull CallExp object) {
		return visitTypedElement(object);
	}

	@Override
	public R visitClass(example2.classes.@NonNull Class object) {
		return visitNamedElement(object);
	}

	@Override
	public R visitElement(example2.classes.@NonNull Element object) {
		return visiting(object);
	}

	@Override
	public R visitNamedElement(example2.classes.@NonNull NamedElement object) {
		return visitElement(object);
	}

	@Override
	public R visitNamespace(example2.classes.@NonNull Namespace object) {
		return visitElement(object);
	}

	@Override
	public R visitOperation(example2.classes.@NonNull Operation object) {
		return visitNamedElement(object);
	}

	@Override
	public R visitOperationCallExp(example2.classes.@NonNull OperationCallExp object) {
		return visitCallExp(object);
	}

	@Override
	public R visitPackage(example2.classes.@NonNull Package object) {
		return visitNamedElement(object);
	}

	@Override
	public R visitParameter(example2.classes.@NonNull Parameter object) {
		return visitNamedElement(object);
	}

	@Override
	public R visitProperty(example2.classes.@NonNull Property object) {
		return visitNamedElement(object);
	}

	@Override
	public R visitPropertyCallExp(example2.classes.@NonNull PropertyCallExp object) {
		return visitCallExp(object);
	}

	@Override
	public R visitRoot(example2.classes.@NonNull Root object) {
		return visitElement(object);
	}

	@Override
	public R visitTypedElement(example2.classes.@NonNull TypedElement object) {
		return visitElement(object);
	}
}
