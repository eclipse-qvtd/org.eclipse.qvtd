/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.build.cs2as.tests/src/org/eclipse/qvtd/build/cs2as/tests/models/example1/TargetMM1.genmodel
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
	@Nullable R visiting(@NonNull example1.target.util.Visitable visitable);

	@Nullable R visitA(@NonNull example1.target.A object);
	@Nullable R visitA1(@NonNull example1.target.A1 object);
	@Nullable R visitA2(@NonNull example1.target.A2 object);
	@Nullable R visitA3(@NonNull example1.target.A3 object);
	@Nullable R visitB(@NonNull example1.target.B object);
	@Nullable R visitC(@NonNull example1.target.C object);
	@Nullable R visitD(@NonNull example1.target.D object);
	@Nullable R visitNamedElement(@NonNull example1.target.NamedElement object);
	@Nullable R visitTRoot(@NonNull example1.target.TRoot object);
}
