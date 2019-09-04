/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

/**
 * An InvocationAnalysis identifies the invocation of one Relation from another.
 */
public interface InvocationAnalysis
{
	void addBinding(@NonNull VariableDeclaration rootVariable, @NonNull Node argumentNode);
	@NonNull Iterable<@NonNull Node> getArgumentNodes();
	@NonNull RelationAnalysis getInvokedRelationAnalysis();
	@NonNull RelationAnalysis getInvokingRelationAnalysis();
	boolean isRealized();

	/**
	 * Return true if the invoked relation is a top relation.
	 */
	boolean isTop();

	/**
	 * Return true if the invocation is from a when clause, else false for a where clause.
	 */
	boolean isWhen();

	/**
	 * Return true if a trace property is needed for the invocation.
	 */
	boolean needsInvocationTraceProperty();

	/**
	 * Set isStrict true if this invocation's uniqueness must be explicitly enforced at run-time.
	 */
	void setStrict(boolean isStrict);

	void synthesizeInvocationNodes(@NonNull Node traceNode);
}