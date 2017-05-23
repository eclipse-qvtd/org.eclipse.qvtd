/**
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.qvtd.umlx.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.umlx.UMLXPackage
 * @generated
 */
public class UMLXValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final UMLXValidator INSTANCE = new UMLXValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.qvtd.umlx";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Name Is Required' of 'Rel Diagram'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_DIAGRAM__VALIDATE_NAME_IS_REQUIRED = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Rel Pattern Node Names Are Unique' of 'Rel Diagram'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_DIAGRAM__VALIDATE_REL_PATTERN_NODE_NAMES_ARE_UNIQUE = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Edges' of 'Rel Invocation Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_INVOCATION_NODE__VALIDATE_COMPATIBLE_EDGES = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source Is EClass' of 'Rel Pattern Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_EDGE__VALIDATE_SOURCE_IS_ECLASS = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source Is Class Node' of 'Rel Pattern Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_EDGE__VALIDATE_SOURCE_IS_CLASS_NODE = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible EAttribute Property Target' of 'Rel Pattern Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_EDGE__VALIDATE_COMPATIBLE_EATTRIBUTE_PROPERTY_TARGET = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Source Multiplicity' of 'Rel Pattern Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_EDGE__VALIDATE_COMPATIBLE_SOURCE_MULTIPLICITY = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible EReference Property Target' of 'Rel Pattern Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_EDGE__VALIDATE_COMPATIBLE_EREFERENCE_PROPERTY_TARGET = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Property Source' of 'Rel Pattern Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_EDGE__VALIDATE_COMPATIBLE_PROPERTY_SOURCE = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Source Index' of 'Rel Pattern Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_EDGE__VALIDATE_COMPATIBLE_SOURCE_INDEX = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Rest Property Target' of 'Rel Pattern Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_EDGE__VALIDATE_COMPATIBLE_REST_PROPERTY_TARGET = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Member Property Target' of 'Rel Pattern Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_EDGE__VALIDATE_COMPATIBLE_MEMBER_PROPERTY_TARGET = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Anon Is Unnamed' of 'Rel Pattern Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_NODE__VALIDATE_ANON_IS_UNNAMED = 13;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Required' of 'Rel Pattern Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_NODE__VALIDATE_TYPE_IS_REQUIRED = 14;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate EClassifier Is In Typed Model' of 'Rel Pattern Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_NODE__VALIDATE_ECLASSIFIER_IS_IN_TYPED_MODEL = 15;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Tx Query Node Names Are Unique' of 'Tx Diagram'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TX_DIAGRAM__VALIDATE_TX_QUERY_NODE_NAMES_ARE_UNIQUE = 16;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Rel Diagram Names Are Unique' of 'Tx Diagram'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TX_DIAGRAM__VALIDATE_REL_DIAGRAM_NAMES_ARE_UNIQUE = 17;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Name Is Required' of 'Tx Diagram'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TX_DIAGRAM__VALIDATE_NAME_IS_REQUIRED = 18;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Tx Typed Model Node Names Are Unique' of 'Tx Diagram'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TX_DIAGRAM__VALIDATE_TX_TYPED_MODEL_NODE_NAMES_ARE_UNIQUE = 19;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Parts Are Unique' of 'Tx Key Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TX_KEY_NODE__VALIDATE_PARTS_ARE_UNIQUE = 20;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Name Is Required' of 'Tx Parameter Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TX_PARAMETER_NODE__VALIDATE_NAME_IS_REQUIRED = 21;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Required' of 'Tx Parameter Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TX_PARAMETER_NODE__VALIDATE_TYPE_IS_REQUIRED = 22;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Part Is Property Of Key' of 'Tx Part Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TX_PART_NODE__VALIDATE_PART_IS_PROPERTY_OF_KEY = 23;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Name Is Required' of 'Tx Query Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TX_QUERY_NODE__VALIDATE_NAME_IS_REQUIRED = 24;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Required' of 'Tx Query Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TX_QUERY_NODE__VALIDATE_TYPE_IS_REQUIRED = 25;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Parameters Are Unique' of 'Tx Query Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TX_QUERY_NODE__VALIDATE_PARAMETERS_ARE_UNIQUE = 26;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Tx Package Node Packages Are Unique' of 'Tx Typed Model Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TX_TYPED_MODEL_NODE__VALIDATE_TX_PACKAGE_NODE_PACKAGES_ARE_UNIQUE = 27;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Name Is Required' of 'Tx Typed Model Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TX_TYPED_MODEL_NODE__VALIDATE_NAME_IS_REQUIRED = 28;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 28;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLXValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return UMLXPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case UMLXPackage.REL_DIAGRAM:
				return validateRelDiagram((RelDiagram)value, diagnostics, context);
			case UMLXPackage.REL_DOMAIN_NODE:
				return validateRelDomainNode((RelDomainNode)value, diagnostics, context);
			case UMLXPackage.REL_EDGE:
				return validateRelEdge((RelEdge)value, diagnostics, context);
			case UMLXPackage.REL_INVOCATION_EDGE:
				return validateRelInvocationEdge((RelInvocationEdge)value, diagnostics, context);
			case UMLXPackage.REL_INVOCATION_NODE:
				return validateRelInvocationNode((RelInvocationNode)value, diagnostics, context);
			case UMLXPackage.REL_NODE:
				return validateRelNode((RelNode)value, diagnostics, context);
			case UMLXPackage.REL_PATTERN_EDGE:
				return validateRelPatternEdge((RelPatternEdge)value, diagnostics, context);
			case UMLXPackage.REL_PATTERN_NODE:
				return validateRelPatternNode((RelPatternNode)value, diagnostics, context);
			case UMLXPackage.TX_DIAGRAM:
				return validateTxDiagram((TxDiagram)value, diagnostics, context);
			case UMLXPackage.TX_KEY_NODE:
				return validateTxKeyNode((TxKeyNode)value, diagnostics, context);
			case UMLXPackage.TX_NODE:
				return validateTxNode((TxNode)value, diagnostics, context);
			case UMLXPackage.TX_PACKAGE_NODE:
				return validateTxPackageNode((TxPackageNode)value, diagnostics, context);
			case UMLXPackage.TX_PARAMETER_NODE:
				return validateTxParameterNode((TxParameterNode)value, diagnostics, context);
			case UMLXPackage.TX_PART_NODE:
				return validateTxPartNode((TxPartNode)value, diagnostics, context);
			case UMLXPackage.TX_QUERY_NODE:
				return validateTxQueryNode((TxQueryNode)value, diagnostics, context);
			case UMLXPackage.TX_TYPED_MODEL_NODE:
				return validateTxTypedModelNode((TxTypedModelNode)value, diagnostics, context);
			case UMLXPackage.UMLX_ELEMENT:
				return validateUMLXElement((UMLXElement)value, diagnostics, context);
			case UMLXPackage.UMLX_MODEL:
				return validateUMLXModel((UMLXModel)value, diagnostics, context);
			case UMLXPackage.UMLX_NAMED_ELEMENT:
				return validateUMLXNamedElement((UMLXNamedElement)value, diagnostics, context);
			case UMLXPackage.UMLX_TYPED_ELEMENT:
				return validateUMLXTypedElement((UMLXTypedElement)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelDiagram(RelDiagram relDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relDiagram, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelDiagram_validateRelPatternNodeNamesAreUnique(relDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelDiagram_validateNameIsRequired(relDiagram, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateRelPatternNodeNamesAreUnique constraint of '<em>Rel Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelDiagram_validateRelPatternNodeNamesAreUnique(RelDiagram relDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relDiagram.validateRelPatternNodeNamesAreUnique(diagnostics, context);
	}

	/**
	 * Validates the validateNameIsRequired constraint of '<em>Rel Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelDiagram_validateNameIsRequired(RelDiagram relDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relDiagram.validateNameIsRequired(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelDomainNode(RelDomainNode relDomainNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(relDomainNode, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelEdge(RelEdge relEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(relEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelInvocationEdge(RelInvocationEdge relInvocationEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(relInvocationEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelInvocationNode(RelInvocationNode relInvocationNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relInvocationNode, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relInvocationNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relInvocationNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relInvocationNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relInvocationNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relInvocationNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relInvocationNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relInvocationNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relInvocationNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelInvocationNode_validateCompatibleEdges(relInvocationNode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleEdges constraint of '<em>Rel Invocation Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelInvocationNode_validateCompatibleEdges(RelInvocationNode relInvocationNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relInvocationNode.validateCompatibleEdges(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelNode(RelNode relNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(relNode, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relPatternEdge, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_validateCompatibleMemberPropertyTarget(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_validateSourceIsEClass(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_validateSourceIsClassNode(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_validateCompatibleEAttributePropertyTarget(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_validateCompatibleSourceMultiplicity(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_validateCompatibleEReferencePropertyTarget(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_validateCompatiblePropertySource(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_validateCompatibleSourceIndex(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_validateCompatibleRestPropertyTarget(relPatternEdge, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleMemberPropertyTarget constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_validateCompatibleMemberPropertyTarget(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relPatternEdge.validateCompatibleMemberPropertyTarget(diagnostics, context);
	}

	/**
	 * Validates the validateSourceIsEClass constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_validateSourceIsEClass(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relPatternEdge.validateSourceIsEClass(diagnostics, context);
	}

	/**
	 * Validates the validateSourceIsClassNode constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_validateSourceIsClassNode(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relPatternEdge.validateSourceIsClassNode(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleEAttributePropertyTarget constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_validateCompatibleEAttributePropertyTarget(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relPatternEdge.validateCompatibleEAttributePropertyTarget(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleSourceMultiplicity constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_validateCompatibleSourceMultiplicity(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relPatternEdge.validateCompatibleSourceMultiplicity(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleEReferencePropertyTarget constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_validateCompatibleEReferencePropertyTarget(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relPatternEdge.validateCompatibleEReferencePropertyTarget(diagnostics, context);
	}

	/**
	 * Validates the validateCompatiblePropertySource constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_validateCompatiblePropertySource(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relPatternEdge.validateCompatiblePropertySource(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleSourceIndex constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_validateCompatibleSourceIndex(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relPatternEdge.validateCompatibleSourceIndex(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleRestPropertyTarget constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_validateCompatibleRestPropertyTarget(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relPatternEdge.validateCompatibleRestPropertyTarget(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternNode(RelPatternNode relPatternNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relPatternNode, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relPatternNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relPatternNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relPatternNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relPatternNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relPatternNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relPatternNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relPatternNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relPatternNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternNode_validateEClassifierIsInTypedModel(relPatternNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternNode_validateAnonIsUnnamed(relPatternNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternNode_validateTypeIsRequired(relPatternNode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateEClassifierIsInTypedModel constraint of '<em>Rel Pattern Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternNode_validateEClassifierIsInTypedModel(RelPatternNode relPatternNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relPatternNode.validateEClassifierIsInTypedModel(diagnostics, context);
	}

	/**
	 * Validates the validateAnonIsUnnamed constraint of '<em>Rel Pattern Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternNode_validateAnonIsUnnamed(RelPatternNode relPatternNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relPatternNode.validateAnonIsUnnamed(diagnostics, context);
	}

	/**
	 * Validates the validateTypeIsRequired constraint of '<em>Rel Pattern Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternNode_validateTypeIsRequired(RelPatternNode relPatternNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relPatternNode.validateTypeIsRequired(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxDiagram(TxDiagram txDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(txDiagram, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(txDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(txDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(txDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(txDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(txDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(txDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(txDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(txDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validateTxDiagram_validateTxTypedModelNodeNamesAreUnique(txDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validateTxDiagram_validateTxQueryNodeNamesAreUnique(txDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validateTxDiagram_validateRelDiagramNamesAreUnique(txDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validateTxDiagram_validateNameIsRequired(txDiagram, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTxTypedModelNodeNamesAreUnique constraint of '<em>Tx Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxDiagram_validateTxTypedModelNodeNamesAreUnique(TxDiagram txDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return txDiagram.validateTxTypedModelNodeNamesAreUnique(diagnostics, context);
	}

	/**
	 * Validates the validateTxQueryNodeNamesAreUnique constraint of '<em>Tx Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxDiagram_validateTxQueryNodeNamesAreUnique(TxDiagram txDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return txDiagram.validateTxQueryNodeNamesAreUnique(diagnostics, context);
	}

	/**
	 * Validates the validateRelDiagramNamesAreUnique constraint of '<em>Tx Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxDiagram_validateRelDiagramNamesAreUnique(TxDiagram txDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return txDiagram.validateRelDiagramNamesAreUnique(diagnostics, context);
	}

	/**
	 * Validates the validateNameIsRequired constraint of '<em>Tx Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxDiagram_validateNameIsRequired(TxDiagram txDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return txDiagram.validateNameIsRequired(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxKeyNode(TxKeyNode txKeyNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(txKeyNode, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(txKeyNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(txKeyNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(txKeyNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(txKeyNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(txKeyNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(txKeyNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(txKeyNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(txKeyNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateTxKeyNode_validatePartsAreUnique(txKeyNode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validatePartsAreUnique constraint of '<em>Tx Key Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxKeyNode_validatePartsAreUnique(TxKeyNode txKeyNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return txKeyNode.validatePartsAreUnique(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxNode(TxNode txNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(txNode, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxPackageNode(TxPackageNode txPackageNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(txPackageNode, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxParameterNode(TxParameterNode txParameterNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(txParameterNode, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(txParameterNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(txParameterNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(txParameterNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(txParameterNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(txParameterNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(txParameterNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(txParameterNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(txParameterNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateTxParameterNode_validateTypeIsRequired(txParameterNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateTxParameterNode_validateNameIsRequired(txParameterNode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTypeIsRequired constraint of '<em>Tx Parameter Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxParameterNode_validateTypeIsRequired(TxParameterNode txParameterNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return txParameterNode.validateTypeIsRequired(diagnostics, context);
	}

	/**
	 * Validates the validateNameIsRequired constraint of '<em>Tx Parameter Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxParameterNode_validateNameIsRequired(TxParameterNode txParameterNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return txParameterNode.validateNameIsRequired(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxPartNode(TxPartNode txPartNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(txPartNode, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(txPartNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(txPartNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(txPartNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(txPartNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(txPartNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(txPartNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(txPartNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(txPartNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateTxPartNode_validatePartIsPropertyOfKey(txPartNode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validatePartIsPropertyOfKey constraint of '<em>Tx Part Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxPartNode_validatePartIsPropertyOfKey(TxPartNode txPartNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return txPartNode.validatePartIsPropertyOfKey(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxQueryNode(TxQueryNode txQueryNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(txQueryNode, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(txQueryNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(txQueryNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(txQueryNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(txQueryNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(txQueryNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(txQueryNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(txQueryNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(txQueryNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateTxQueryNode_validateParametersAreUnique(txQueryNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateTxQueryNode_validateNameIsRequired(txQueryNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateTxQueryNode_validateTypeIsRequired(txQueryNode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateParametersAreUnique constraint of '<em>Tx Query Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxQueryNode_validateParametersAreUnique(TxQueryNode txQueryNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return txQueryNode.validateParametersAreUnique(diagnostics, context);
	}

	/**
	 * Validates the validateNameIsRequired constraint of '<em>Tx Query Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxQueryNode_validateNameIsRequired(TxQueryNode txQueryNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return txQueryNode.validateNameIsRequired(diagnostics, context);
	}

	/**
	 * Validates the validateTypeIsRequired constraint of '<em>Tx Query Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxQueryNode_validateTypeIsRequired(TxQueryNode txQueryNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return txQueryNode.validateTypeIsRequired(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxTypedModelNode(TxTypedModelNode txTypedModelNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(txTypedModelNode, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(txTypedModelNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(txTypedModelNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(txTypedModelNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(txTypedModelNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(txTypedModelNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(txTypedModelNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(txTypedModelNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(txTypedModelNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateTxTypedModelNode_validateNameIsRequired(txTypedModelNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateTxTypedModelNode_validateTxPackageNodePackagesAreUnique(txTypedModelNode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNameIsRequired constraint of '<em>Tx Typed Model Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxTypedModelNode_validateNameIsRequired(TxTypedModelNode txTypedModelNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return txTypedModelNode.validateNameIsRequired(diagnostics, context);
	}

	/**
	 * Validates the validateTxPackageNodePackagesAreUnique constraint of '<em>Tx Typed Model Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxTypedModelNode_validateTxPackageNodePackagesAreUnique(TxTypedModelNode txTypedModelNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return txTypedModelNode.validateTxPackageNodePackagesAreUnique(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUMLXElement(UMLXElement umlxElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(umlxElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUMLXModel(UMLXModel umlxModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(umlxModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUMLXNamedElement(UMLXNamedElement umlxNamedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(umlxNamedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUMLXTypedElement(UMLXTypedElement umlxTypedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(umlxTypedElement, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //UMLXValidator
