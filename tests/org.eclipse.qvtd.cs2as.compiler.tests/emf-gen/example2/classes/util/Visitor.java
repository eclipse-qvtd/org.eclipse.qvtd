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
 */
public interface Visitor<R>
{
	/**
	 * Returns an object which is an instance of the given class
	 * associated with this object. Returns <code>null</code> if
	 * no such object can be found.
	 *
	 * @param adapter the adapter class to look up
	 * @return an object of the given class, 
	 *    or <code>null</code> if this object does not
	 *    have an adapter for the given class
	 */
	@Nullable <A> A getAdapter(@NonNull Class<A> adapter);

	/**
	 * Return the result of visiting a visitable for which no more specific pivot type method
	 * is available.
	 */
	R visiting(example2.classes.util.@NonNull Visitable visitable);

	R visitArgument(example2.classes.@NonNull Argument object);
	R visitCallExp(example2.classes.@NonNull CallExp object);
	R visitClass(example2.classes.@NonNull Class object);
	R visitElement(example2.classes.@NonNull Element object);
	R visitNamedElement(example2.classes.@NonNull NamedElement object);
	R visitNamespace(example2.classes.@NonNull Namespace object);
	R visitOperation(example2.classes.@NonNull Operation object);
	R visitOperationCallExp(example2.classes.@NonNull OperationCallExp object);
	R visitPackage(example2.classes.@NonNull Package object);
	R visitParameter(example2.classes.@NonNull Parameter object);
	R visitProperty(example2.classes.@NonNull Property object);
	R visitPropertyCallExp(example2.classes.@NonNull PropertyCallExp object);
	R visitRoot(example2.classes.@NonNull Root object);
	R visitTypedElement(example2.classes.@NonNull TypedElement object);
}
