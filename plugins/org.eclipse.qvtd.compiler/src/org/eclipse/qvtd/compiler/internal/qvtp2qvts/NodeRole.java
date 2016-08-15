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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.TypedElement;

/**
 * NodeRole defines which of many possible roles an node plays
 */
public interface NodeRole extends Role
{
	@NonNull NodeRole asNavigable();
	@Override
	@NonNull NodeRole asPhase(@NonNull Phase phase);
	@NonNull NodeRole asPredicated();
	@NonNull NodeRole asSpeculated();
	@NonNull NodeRole asSpeculation();

	@NonNull Node createNode(@NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis);

	@NonNull Node createNode(@NonNull Region region, @NonNull String name, @NonNull TypedElement typedElement);

	/**
	 * Return the pen width with which this edge is drawn.
	 */
	@NonNull Integer getPenwidth();

	/**
	 * Return the shape or null for default.
	 */
	@Nullable String getShape();

	//	@Nullable String getStyle();

	boolean isComposed();

	boolean isExpression();

	boolean isExtraGuardVariable();

	boolean isHead();

	boolean isInternal();

	boolean isIterator();

	boolean isNavigable();

	boolean isNull();

	boolean isOperation();

	boolean isPattern();

	boolean isTrue();

	/**
	 * Return the merged role combining this role and nodeRole.
	 */
	@NonNull NodeRole merge(@NonNull NodeRole nodeRole);

	/**
	 * Redesignate a head node as not-a-head, typically following a multi-headed split.
	 */
	@NonNull NodeRole resetHead();

	/**
	 * Redesignate a guard node as a head.
	 */
	@NonNull NodeRole setHead();
}