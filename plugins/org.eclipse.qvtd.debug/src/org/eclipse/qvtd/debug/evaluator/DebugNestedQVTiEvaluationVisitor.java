/*******************************************************************************
 * Copyright (c) 2009,2012 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *     Christopher Gerking - bug 394498
 *******************************************************************************/
package org.eclipse.qvtd.debug.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitor;

public class DebugNestedQVTiEvaluationVisitor extends DebugQVTiEvaluationVisitor
{
	protected final @NonNull DebugRootQVTiEvaluationVisitor root;
	protected final @NonNull DebugQVTiEvaluationVisitor parent;
	protected final int depth;
	
	protected DebugNestedQVTiEvaluationVisitor(@NonNull DebugQVTiEvaluationVisitor parent, @NonNull QVTiEvaluationVisitor nestedEvaluationVisitor, @NonNull NamedElement operation) {
		super(nestedEvaluationVisitor);
		this.root = parent.getRootEvaluationVisitor();
		this.parent = parent;
		this.depth = parent.getDepth() + 1;
		root.pushVisitor(this);
	}

	public void dispose() {
		root.popVisitor(this);
	}

	public int getDepth() {
		return depth;
	}

	public @NonNull DebugRootQVTiEvaluationVisitor getRootEvaluationVisitor() {
		return root;
	}

	protected void postVisit(@NonNull IDebugEvaluationEnvironment evalEnv, @NonNull Element element, Object preState) {
		root.postVisit(evalEnv, element, preState);
	}

	protected Object preVisit(@NonNull IDebugEvaluationEnvironment evalEnv, @NonNull Element element) {
		return root.preVisit(evalEnv, element);
	}
}
