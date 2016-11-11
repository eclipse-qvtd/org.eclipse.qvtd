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
	R visiting(example1.target.util.@NonNull Visitable visitable);

	R visitA(example1.target.@NonNull A object);
	R visitA1(example1.target.@NonNull A1 object);
	R visitA2(example1.target.@NonNull A2 object);
	R visitA3(example1.target.@NonNull A3 object);
	R visitB(example1.target.@NonNull B object);
	R visitC(example1.target.@NonNull C object);
	R visitD(example1.target.@NonNull D object);
	R visitNamedElement(example1.target.@NonNull NamedElement object);
	R visitNamespace(example1.target.@NonNull Namespace object);
	R visitTRoot(example1.target.@NonNull TRoot object);
}
