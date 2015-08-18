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
	@Nullable R visiting(@NonNull example2.classes.util.Visitable visitable);

	@Nullable R visitArgument(@NonNull example2.classes.Argument object);
	@Nullable R visitCallExp(@NonNull example2.classes.CallExp object);
	@Nullable R visitClass(@NonNull example2.classes.Class object);
	@Nullable R visitElement(@NonNull example2.classes.Element object);
	@Nullable R visitNamedElement(@NonNull example2.classes.NamedElement object);
	@Nullable R visitNamespace(@NonNull example2.classes.Namespace object);
	@Nullable R visitOperation(@NonNull example2.classes.Operation object);
	@Nullable R visitOperationCallExp(@NonNull example2.classes.OperationCallExp object);
	@Nullable R visitPackage(@NonNull example2.classes.Package object);
	@Nullable R visitParameter(@NonNull example2.classes.Parameter object);
	@Nullable R visitProperty(@NonNull example2.classes.Property object);
	@Nullable R visitPropertyCallExp(@NonNull example2.classes.PropertyCallExp object);
	@Nullable R visitRoot(@NonNull example2.classes.Root object);
	@Nullable R visitTypedElement(@NonNull example2.classes.TypedElement object);
}
