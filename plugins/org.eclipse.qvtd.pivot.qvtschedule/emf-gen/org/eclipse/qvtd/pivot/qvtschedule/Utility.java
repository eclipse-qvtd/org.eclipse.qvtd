/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtschedule;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.TypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Utility</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The utility of the model element for the overall match.
 * <!-- end-model-doc -->
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getUtility()
 * @model
 * @generated
 */
public enum Utility implements Enumerator {
	/**
	 * The '<em><b>DISPATCH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The predicated dispatcher of an overriding rule (the overridden dispatcher is a TRACE).
	 * <!-- end-model-doc -->
	 * @see #DISPATCH_VALUE
	 * @generated
	 * @ordered
	 */
	DISPATCH(0, "DISPATCH", "DISPATCH"),

	/**
	 * The '<em><b>TRACE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The predicated/realized trace node.
	 * <!-- end-model-doc -->
	 * @see #TRACE_VALUE
	 * @generated
	 * @ordered
	 */
	TRACE(0, "TRACE", "TRACE"),

	/**
	 * The '<em><b>SUCCESS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The success node to which the match/not-match verdict is assigned.
	 * <!-- end-model-doc -->
	 * @see #SUCCESS_VALUE
	 * @generated
	 * @ordered
	 */
	SUCCESS(0, "SUCCESS", "SUCCESS"),

	/**
	 * The '<em><b>DEPENDENCY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A dependency that must be satisfied to validate the region's execution.
	 * <!-- end-model-doc -->
	 * @see #DEPENDENCY_VALUE
	 * @generated
	 * @ordered
	 */
	DEPENDENCY(0, "DEPENDENCY", "DEPENDENCY"),

	/**
	 * The '<em><b>COMPOSED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A LoadingRegion element.
	 * <!-- end-model-doc -->
	 * @see #COMPOSED_VALUE
	 * @generated
	 * @ordered
	 */
	COMPOSED(0, "COMPOSED", "COMPOSED"),

	/**
	 * The '<em><b>NON NULL MATCHED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Non-null value reachable by to-1 navigation from the (?? a) trace node, or by to-? to an ExplicitNull.
	 * <!-- end-model-doc -->
	 * @see #NON_NULL_MATCHED_VALUE
	 * @generated
	 * @ordered
	 */
	NON_NULL_MATCHED(0, "NON_NULL_MATCHED", "NON_NULL_MATCHED"),

	/**
	 * The '<em><b>NULLABLE MATCHED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Maybe-null value reachable by to-1 navigation from the (?? a) trace node, or by to-? to an ExplicitNull.
	 * <!-- end-model-doc -->
	 * @see #NULLABLE_MATCHED_VALUE
	 * @generated
	 * @ordered
	 */
	NULLABLE_MATCHED(0, "NULLABLE_MATCHED", "NULLABLE_MATCHED"),

	/**
	 * The '<em><b>NON NULL CONDITIONAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A non-null selectively computable element depending on if conditions / loops. Not matched.
	 * <!-- end-model-doc -->
	 * @see #NON_NULL_CONDITIONAL_VALUE
	 * @generated
	 * @ordered
	 */
	NON_NULL_CONDITIONAL(0, "NON_NULL_CONDITIONAL", "NON_NULL_CONDITIONAL"),

	/**
	 * The '<em><b>NULLABLE CONDITIONAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An uninitialized / erroneous / undefined utility.
	 * <!-- end-model-doc -->
	 * @see #NULLABLE_CONDITIONAL_VALUE
	 * @generated
	 * @ordered
	 */
	NULLABLE_CONDITIONAL(0, "NULLABLE_CONDITIONAL", "NULLABLE_CONDITIONAL"),

	/**
	 * The '<em><b>NOT KNOWN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The predicated dispatcher of an overriding rule (the overridden dispatcher is a TRACE).
	 * <!-- end-model-doc -->
	 * @see #NOT_KNOWN_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_KNOWN(0, "NOT_KNOWN", "NOT_KNOWN");

	/**
	 * The '<em><b>DISPATCH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The predicated dispatcher of an overriding rule (the overridden dispatcher is a TRACE).
	 * <!-- end-model-doc -->
	 * @see #DISPATCH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DISPATCH_VALUE = 0;

	/**
	 * The '<em><b>TRACE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The predicated/realized trace node.
	 * <!-- end-model-doc -->
	 * @see #TRACE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRACE_VALUE = 0;

	/**
	 * The '<em><b>SUCCESS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The success node to which the match/not-match verdict is assigned.
	 * <!-- end-model-doc -->
	 * @see #SUCCESS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUCCESS_VALUE = 0;

	/**
	 * The '<em><b>DEPENDENCY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A dependency that must be satisfied to validate the region's execution.
	 * <!-- end-model-doc -->
	 * @see #DEPENDENCY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEPENDENCY_VALUE = 0;

	/**
	 * The '<em><b>COMPOSED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A LoadingRegion element.
	 * <!-- end-model-doc -->
	 * @see #COMPOSED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPOSED_VALUE = 0;

	/**
	 * The '<em><b>NON NULL MATCHED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Non-null value reachable by to-1 navigation from the (?? a) trace node, or by to-? to an ExplicitNull.
	 * <!-- end-model-doc -->
	 * @see #NON_NULL_MATCHED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NON_NULL_MATCHED_VALUE = 0;

	/**
	 * The '<em><b>NULLABLE MATCHED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Maybe-null value reachable by to-1 navigation from the (?? a) trace node, or by to-? to an ExplicitNull.
	 * <!-- end-model-doc -->
	 * @see #NULLABLE_MATCHED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NULLABLE_MATCHED_VALUE = 0;

	/**
	 * The '<em><b>NON NULL CONDITIONAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A non-null selectively computable element depending on if conditions / loops. Not matched.
	 * <!-- end-model-doc -->
	 * @see #NON_NULL_CONDITIONAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NON_NULL_CONDITIONAL_VALUE = 0;

	/**
	 * The '<em><b>NULLABLE CONDITIONAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An uninitialized / erroneous / undefined utility.
	 * <!-- end-model-doc -->
	 * @see #NULLABLE_CONDITIONAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NULLABLE_CONDITIONAL_VALUE = 0;

	/**
	 * The '<em><b>NOT KNOWN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The predicated dispatcher of an overriding rule (the overridden dispatcher is a TRACE).
	 * <!-- end-model-doc -->
	 * @see #NOT_KNOWN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOT_KNOWN_VALUE = 0;

	/**
	 * An array of all the '<em><b>Utility</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Utility[] VALUES_ARRAY =
			new Utility[] {
			DISPATCH,
			TRACE,
			SUCCESS,
			DEPENDENCY,
			COMPOSED,
			NON_NULL_MATCHED,
			NULLABLE_MATCHED,
			NON_NULL_CONDITIONAL,
			NULLABLE_CONDITIONAL,
			NOT_KNOWN,
		};

	/**
	 * A public read-only list of all the '<em><b>Utility</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Utility> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Utility</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Utility get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Utility result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Utility</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Utility getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Utility result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Utility</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Utility get(int value) {
		switch (value) {
			case DISPATCH_VALUE: return DISPATCH;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Utility(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}


	public static @NonNull Utility getRequiredUtility(@NonNull TypedElement typedElement) {
		return typedElement.isIsRequired() ? Utility.NON_NULL_MATCHED : Utility.NULLABLE_MATCHED;
	}

	public @NonNull Utility getConditionalUtility() {
		switch(this) {
			case NON_NULL_CONDITIONAL: return NON_NULL_CONDITIONAL;
			case NON_NULL_MATCHED: return NON_NULL_CONDITIONAL;
			case NULLABLE_CONDITIONAL: return NULLABLE_CONDITIONAL;
			case NULLABLE_MATCHED: return NULLABLE_CONDITIONAL;
		}
		throw new UnsupportedOperationException();
	}

	public @NonNull Utility getNullableUtility() {
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
		return (this == Utility.NULLABLE_MATCHED) || (this == NULLABLE_CONDITIONAL);
	}

	/**
	 * Return true for an unconditioknal pattern usage.
	 */
	public boolean isUnconditional() {
		return (this == Utility.NON_NULL_MATCHED) || (this == Utility.NULLABLE_MATCHED) || (this == TRACE) || (this == DISPATCH);
	}
} //Utility
