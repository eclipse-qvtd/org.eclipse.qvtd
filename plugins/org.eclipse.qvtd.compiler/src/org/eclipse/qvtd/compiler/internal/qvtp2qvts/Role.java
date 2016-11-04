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

/**
 * Role defines which of many possible roles an edge plays
 */
public interface Role extends Comparable<Role>
{
	public static final @NonNull String BINDING_COLOR = "darkorange";
	public static final @NonNull String CONSTANT_COLOR = "black";
	public static final @NonNull String ERROR_COLOR = "red";
	public static final @NonNull String ITERATION_COLOR = "magenta";
	public static final @NonNull String LIGHT_CONSTANT_COLOR = "lightgray";
	public static final @NonNull String LIGHT_LOADED_COLOR = "lightblue1";
	public static final @NonNull String LIGHT_OTHER_COLOR = "gray";
	public static final @NonNull String LIGHT_PREDICATED_COLOR = "lightcyan1";
	public static final @NonNull String LIGHT_REALIZED_COLOR = "palegreen1";
	public static final @NonNull String LIGHT_SPECULATED_COLOR = "palegoldenrod";
	public static final @NonNull String LIGHT_SPECULATION_COLOR = "pink1";
	public static final @NonNull String LOADED_COLOR = "blue";
	public static final @NonNull String OPERATION_COLOR = "magenta";
	public static final @NonNull String ORDERING_COLOR = "brown";
	public static final @NonNull String OTHER_COLOR = "grey";
	public static final @NonNull String PREDICATED_COLOR = "cyan";
	public static final @NonNull String REALIZED_COLOR = "green3";
	public static final @NonNull String RECURSION_COLOR = "brown";
	public static final @NonNull String SPECULATED_COLOR = "darkorange";
	public static final @NonNull String SPECULATION_COLOR = "red";

	public static final @NonNull Integer HEAD_WIDTH = 8;
	public static final @NonNull Integer LINE_WIDTH = 2;

	/**
	 * Phase identifies the different processing phases of a mapping. The phases are ordered by decreasing
	 * certainty, allowing the earlier to be chosen by a merge.
	 */
	public enum Phase {
		CONSTANT,		// Unequivocably known as compile time constant
		LOADED,			// Known once input models loaded
		REALIZED,		// Known once a mapping has realized its results
		PREDICATED,		// Not known, awaiting matching
		SPECULATION,	// Awaiting other mappings to speculate
		SPECULATED,		// Known other mappings are speculating
		OTHER			// Not known, nothing to do with mapping execution.
		// NEW = REALIZED || SPECULATION
		// OLD = CONSTANT || LOADED || PREDICATED || SPECULATED
	};

	/**
	 * Return the color with which this glyph is drawn.
	 */
	@NonNull String getColor();

	@NonNull Phase getPhase();

	boolean isConstant();

	boolean isLoaded();

	boolean isNew();

	boolean isOld();

	boolean isPredicated();

	boolean isSpeculated();

	boolean isRealized();

	boolean isSpeculation();
}