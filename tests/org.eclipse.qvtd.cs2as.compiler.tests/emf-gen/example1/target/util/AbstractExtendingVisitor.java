/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
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
	public R visitA(example1.target.@NonNull A object) {
		return visitNamespace(object);
	}

	@Override
	public R visitA1(example1.target.@NonNull A1 object) {
		return visitA(object);
	}

	@Override
	public R visitA2(example1.target.@NonNull A2 object) {
		return visitA(object);
	}

	@Override
	public R visitA3(example1.target.@NonNull A3 object) {
		return visitA2(object);
	}

	@Override
	public R visitB(example1.target.@NonNull B object) {
		return visitNamespace(object);
	}

	@Override
	public R visitC(example1.target.@NonNull C object) {
		return visitNamespace(object);
	}

	@Override
	public R visitD(example1.target.@NonNull D object) {
		return visitNamedElement(object);
	}

	@Override
	public R visitNamedElement(example1.target.@NonNull NamedElement object) {
		return visiting(object);
	}

	@Override
	public R visitNamespace(example1.target.@NonNull Namespace object) {
		return visitNamedElement(object);
	}

	@Override
	public R visitTRoot(example1.target.@NonNull TRoot object) {
		return visiting(object);
	}
}
