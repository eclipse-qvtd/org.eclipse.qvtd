/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role</b></em>'.
 * @extends Comparable<Role>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Phase identifies the different processing phases of a mapping. The phases are ordered by decreasing
 * certainty, allowing the earlier to be chosen by a merge.
 * 
 * NEW = REALIZED || SPECULATION
 * OLD = CONSTANT || LOADED || PREDICATED || SPECULATED
 * <!-- end-model-doc -->
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRole()
 * @model
 * @generated
 */
public enum Role implements Enumerator, Comparable<Role>
{
	/**
	 * The '<em><b>CONSTANT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSTANT_VALUE
	 * @generated
	 * @ordered
	 */
	CONSTANT(0, "CONSTANT", "CONSTANT"),
	/**
	 * The '<em><b>LOADED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOADED_VALUE
	 * @generated
	 * @ordered
	 */
	LOADED(1, "LOADED", "LOADED"),
	/**
	 * The '<em><b>REALIZED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REALIZED_VALUE
	 * @generated
	 * @ordered
	 */
	REALIZED(2, "REALIZED", "REALIZED"),
	/**
	 * The '<em><b>PREDICATED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PREDICATED_VALUE
	 * @generated
	 * @ordered
	 */
	PREDICATED(3, "PREDICATED", "PREDICATED"),
	/**
	 * The '<em><b>SPECULATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPECULATION_VALUE
	 * @generated
	 * @ordered
	 */
	SPECULATION(4, "SPECULATION", "SPECULATION"),
	/**
	 * The '<em><b>SPECULATED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPECULATED_VALUE
	 * @generated
	 * @ordered
	 */
	SPECULATED(5, "SPECULATED", "SPECULATED"),
	/**
	 * The '<em><b>OTHER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OTHER_VALUE
	 * @generated
	 * @ordered
	 */
	OTHER(6, "OTHER", "OTHER");
	/**
	 * The '<em><b>CONSTANT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Unequivocably known as compile time constant
	 * <!-- end-model-doc -->
	 * @see #CONSTANT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONSTANT_VALUE = 0;

	/**
	 * The '<em><b>LOADED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Known once input models loaded
	 * <!-- end-model-doc -->
	 * @see #LOADED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOADED_VALUE = 1;

	/**
	 * The '<em><b>REALIZED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Known once a mapping has realized its results
	 * <!-- end-model-doc -->
	 * @see #REALIZED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REALIZED_VALUE = 2;

	/**
	 * The '<em><b>PREDICATED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Not known, awaiting matching
	 * <!-- end-model-doc -->
	 * @see #PREDICATED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PREDICATED_VALUE = 3;

	/**
	 * The '<em><b>SPECULATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Awaiting other mappings to speculate
	 * <!-- end-model-doc -->
	 * @see #SPECULATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SPECULATION_VALUE = 4;

	/**
	 * The '<em><b>SPECULATED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Known other mappings are speculating
	 * <!-- end-model-doc -->
	 * @see #SPECULATED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SPECULATED_VALUE = 5;

	/**
	 * The '<em><b>OTHER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Not known, nothing to do with mapping execution
	 * <!-- end-model-doc -->
	 * @see #OTHER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OTHER_VALUE = 6;

	/**
	 * An array of all the '<em><b>Role</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Role[] VALUES_ARRAY =
			new Role[] {
			CONSTANT,
			LOADED,
			REALIZED,
			PREDICATED,
			SPECULATION,
			SPECULATED,
			OTHER,
		};

	/**
	 * A public read-only list of all the '<em><b>Role</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Role> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Role</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Role get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Role result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Role</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Role getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Role result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Role</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Role get(int value) {
		switch (value) {
			case CONSTANT_VALUE: return CONSTANT;
			case LOADED_VALUE: return LOADED;
			case REALIZED_VALUE: return REALIZED;
			case PREDICATED_VALUE: return PREDICATED;
			case SPECULATION_VALUE: return SPECULATION;
			case SPECULATED_VALUE: return SPECULATED;
			case OTHER_VALUE: return OTHER;
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
	private Role(int value, String name, String literal) {
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

	public boolean isNew() {
		return (this == REALIZED) || (this == SPECULATION);
	}

	public boolean isOld() {
		return (this == CONSTANT) || (this == LOADED) || (this == PREDICATED) || (this == SPECULATED);
	}
}
