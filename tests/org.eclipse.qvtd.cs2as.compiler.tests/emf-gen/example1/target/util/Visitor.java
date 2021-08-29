/*******************************************************************************
 * Copyright (c) 2014, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.cs2as.compiler.tests/models/Source2Target/TargetMM1.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	example1.target.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * @noimplement This interface is not intended to be implemented by clients.
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
