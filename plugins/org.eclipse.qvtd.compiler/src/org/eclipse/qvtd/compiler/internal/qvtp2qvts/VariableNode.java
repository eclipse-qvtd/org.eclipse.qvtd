/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * VariableNode provides the non-terminal analysis and status of a Variable from which navigations
 * are possible. The analysis is associated with a particular sourceVariable from which a variety of further node analyses
 * are reachable by traversing some Property.
 */
public class VariableNode extends AbstractNode
{
	protected final @NonNull VariableDeclaration variable;

	public VariableNode(@NonNull NodeRole nodeRole, @NonNull Region region, @NonNull VariableDeclaration variable) {
		super(nodeRole, region, ClassUtil.nonNullState(variable.getName()), region.getClassDatumAnalysis(variable));
		this.variable = variable;
		assert variable.eContainer() != null;
		assert variable.getName() != null;
		if (region instanceof BasicMappingRegion) {
			((BasicMappingRegion)region).addVariableNode(getVariable(), this);
		}
		addTypedElement(variable);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitVariableNode(this);
	}

	public @NonNull VariableDeclaration getVariable() {
		return variable;
	}

	@SuppressWarnings("null")		// @NonNull may be null during construction
	@Override
	public @NonNull String toString() {
		return getNodeRole().toString() + "(" + (variable != null ? variable.toString() : name) + ")";
	}
}