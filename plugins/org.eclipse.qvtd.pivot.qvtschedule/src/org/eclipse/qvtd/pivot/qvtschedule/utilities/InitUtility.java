/**
 * <copyright>
 *
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.TypedElement;

public enum InitUtility {
	/** The predicated dispatcher of an overriding rule (the overridden dispatcher is a TRACE).*/
	DISPATCH,
	/** The predicated/realized trace node.*/
	TRACE,
	/** The success node to which the match/not-match verdict is assigned.*/
	SUCCESS,
	/** A dependency that must be satisfied to validate the region's execution.*/
	DEPENDENCY,
	/** A LoadingRegion element.*/
	COMPOSED,
	/** Non-null value reachable by to-1 navigation from the (?? a) trace node, or by to-? to an ExplicitNull.*/
	NON_NULL_MATCHED,
	/** Maybe-null value reachable by to-1 navigation from the (?? a) trace node, or by to-? to an ExplicitNull.*/
	NULLABLE_MATCHED,
	/** A non-null selectively computable element depending on if conditions / loops. Not matched.*/
	NON_NULL_CONDITIONAL,
	/** A maybe-null selectively computable element depending on if conditions / loops. Not matched.*/
	NULLABLE_CONDITIONAL,
	NOT_KNOWN;

	public static @NonNull InitUtility getRequiredInitUtility(@NonNull TypedElement typedElement) {
		return typedElement.isIsRequired() ? InitUtility.NON_NULL_MATCHED : InitUtility.NULLABLE_MATCHED;
	}

	public @NonNull InitUtility getConditionalUtility() {
		switch(this) {
			case NON_NULL_CONDITIONAL: return NON_NULL_CONDITIONAL;
			case NON_NULL_MATCHED: return NON_NULL_CONDITIONAL;
			case NULLABLE_CONDITIONAL: return NULLABLE_CONDITIONAL;
			case NULLABLE_MATCHED: return NULLABLE_CONDITIONAL;
		}
		throw new UnsupportedOperationException();
	}

	public @NonNull InitUtility getNullableUtility() {
		switch(this) {
			case NON_NULL_CONDITIONAL: return NULLABLE_CONDITIONAL;
			case NON_NULL_MATCHED: return NULLABLE_MATCHED;
			case NULLABLE_CONDITIONAL: return NULLABLE_CONDITIONAL;
			case NULLABLE_MATCHED: return NULLABLE_MATCHED;
		}
		throw new UnsupportedOperationException();
	}

	/**
	 * Return true for a conditional pattern usage.
	 */
	public boolean isConditional() {
		return (this == NON_NULL_CONDITIONAL) || (this == NULLABLE_CONDITIONAL);
	}

	/**
	 * Return true for a nullable pattern usage.
	 */
	public boolean isNullable() {
		return (this == InitUtility.NULLABLE_MATCHED) || (this == NULLABLE_CONDITIONAL);
	}

	/**
	 * Return true for an unconditioknal pattern usage.
	 */
	public boolean isUnconditional() {
		return (this == InitUtility.NON_NULL_MATCHED) || (this == InitUtility.NULLABLE_MATCHED) || (this == TRACE) || (this == DISPATCH);
	}
}