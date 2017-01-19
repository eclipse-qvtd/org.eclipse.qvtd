/**
 * Copyright (c) 2016 Willink Transformations and others.
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

import org.eclipse.emf.common.util.Diagnostic;
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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Rel Pattern Node Names Are Unique' of 'Rel Diagram'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_DIAGRAM__VALIDATE_REL_PATTERN_NODE_NAMES_ARE_UNIQUE = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Edges' of 'Rel Invocation Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_INVOCATION_NODE__VALIDATE_COMPATIBLE_EDGES = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Anon Is Unnamed' of 'Rel Pattern Class Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_CLASS_NODE__VALIDATE_ANON_IS_UNNAMED = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate EClassifier Is In Typed Model' of 'Rel Pattern Class Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_CLASS_NODE__VALIDATE_ECLASSIFIER_IS_IN_TYPED_MODEL = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Member Property Target' of 'Rel Pattern Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_EDGE__VALIDATE_COMPATIBLE_MEMBER_PROPERTY_TARGET = 13;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source Is Class Node' of 'Rel Pattern Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_EDGE__VALIDATE_SOURCE_IS_CLASS_NODE = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source Is EClass' of 'Rel Pattern Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_EDGE__VALIDATE_SOURCE_IS_ECLASS = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Source Index' of 'Rel Pattern Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_EDGE__VALIDATE_COMPATIBLE_SOURCE_INDEX = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Rest Property Target' of 'Rel Pattern Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_EDGE__VALIDATE_COMPATIBLE_REST_PROPERTY_TARGET = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible EAttribute Property Target' of 'Rel Pattern Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_EDGE__VALIDATE_COMPATIBLE_EATTRIBUTE_PROPERTY_TARGET = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Property Source' of 'Rel Pattern Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_EDGE__VALIDATE_COMPATIBLE_PROPERTY_SOURCE = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Source Multiplicity' of 'Rel Pattern Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_EDGE__VALIDATE_COMPATIBLE_SOURCE_MULTIPLICITY = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible EReference Property Target' of 'Rel Pattern Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REL_PATTERN_EDGE__VALIDATE_COMPATIBLE_EREFERENCE_PROPERTY_TARGET = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Rel Diagram Names Are Unique' of 'Tx Diagram'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TX_DIAGRAM__VALIDATE_REL_DIAGRAM_NAMES_ARE_UNIQUE = 14;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Tx Typed Model Node Names Are Unique' of 'Tx Diagram'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TX_DIAGRAM__VALIDATE_TX_TYPED_MODEL_NODE_NAMES_ARE_UNIQUE = 15;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Parts Are Unique' of 'Tx Key Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TX_KEY_NODE__VALIDATE_PARTS_ARE_UNIQUE = 16;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Part Is Property Of Key' of 'Tx Part Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TX_PART_NODE__VALIDATE_PART_IS_PROPERTY_OF_KEY = 17;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Tx Package Node Packages Are Unique' of 'Tx Typed Model Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TX_TYPED_MODEL_NODE__VALIDATE_TX_PACKAGE_NODE_PACKAGES_ARE_UNIQUE = 18;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 18;

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
			case UMLXPackage.REL_PATTERN_CLASS_NODE:
				return validateRelPatternClassNode((RelPatternClassNode)value, diagnostics, context);
			case UMLXPackage.REL_PATTERN_EDGE:
				return validateRelPatternEdge((RelPatternEdge)value, diagnostics, context);
			case UMLXPackage.REL_PATTERN_EXPRESSION_NODE:
				return validateRelPatternExpressionNode((RelPatternExpressionNode)value, diagnostics, context);
			case UMLXPackage.REL_PATTERN_NODE:
				return validateRelPatternNode((RelPatternNode)value, diagnostics, context);
			case UMLXPackage.TX_DIAGRAM:
				return validateTxDiagram((TxDiagram)value, diagnostics, context);
			case UMLXPackage.TX_IMPORT_NODE:
				return validateTxImportNode((TxImportNode)value, diagnostics, context);
			case UMLXPackage.TX_KEY_NODE:
				return validateTxKeyNode((TxKeyNode)value, diagnostics, context);
			case UMLXPackage.TX_NODE:
				return validateTxNode((TxNode)value, diagnostics, context);
			case UMLXPackage.TX_PACKAGE_NODE:
				return validateTxPackageNode((TxPackageNode)value, diagnostics, context);
			case UMLXPackage.TX_PART_NODE:
				return validateTxPartNode((TxPartNode)value, diagnostics, context);
			case UMLXPackage.TX_TYPED_MODEL_NODE:
				return validateTxTypedModelNode((TxTypedModelNode)value, diagnostics, context);
			case UMLXPackage.UMLX_ELEMENT:
				return validateUMLXElement((UMLXElement)value, diagnostics, context);
			case UMLXPackage.UMLX_MODEL:
				return validateUMLXModel((UMLXModel)value, diagnostics, context);
			case UMLXPackage.UMLX_NAMED_ELEMENT:
				return validateUMLXNamedElement((UMLXNamedElement)value, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateRelDiagram_RelPatternNodeNamesAreUnique(relDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelDiagram_validateRelPatternNodeNamesAreUnique(relDiagram, diagnostics, context);
		return result;
	}

	/**
	 * Validates the RelPatternNodeNamesAreUnique constraint of '<em>Rel Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelDiagram_RelPatternNodeNamesAreUnique(RelDiagram relDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "RelPatternNodeNamesAreUnique", getObjectLabel(relDiagram, context) },
						 new Object[] { relDiagram },
						 context));
			}
			return false;
		}
		return true;
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
		if (result || diagnostics != null) result &= validateRelInvocationNode_CompatibleEdges(relInvocationNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelInvocationNode_validateCompatibleEdges(relInvocationNode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the CompatibleEdges constraint of '<em>Rel Invocation Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelInvocationNode_CompatibleEdges(RelInvocationNode relInvocationNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "CompatibleEdges", getObjectLabel(relInvocationNode, context) },
						 new Object[] { relInvocationNode },
						 context));
			}
			return false;
		}
		return true;
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
	public boolean validateRelPatternClassNode(RelPatternClassNode relPatternClassNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relPatternClassNode, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relPatternClassNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relPatternClassNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relPatternClassNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relPatternClassNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relPatternClassNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relPatternClassNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relPatternClassNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relPatternClassNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternClassNode_AnonIsUnnamed(relPatternClassNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternClassNode_EClassifierIsInTypedModel(relPatternClassNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternClassNode_validateAnonIsUnnamed(relPatternClassNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternClassNode_validateEClassifierIsInTypedModel(relPatternClassNode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the AnonIsUnnamed constraint of '<em>Rel Pattern Class Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternClassNode_AnonIsUnnamed(RelPatternClassNode relPatternClassNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "AnonIsUnnamed", getObjectLabel(relPatternClassNode, context) },
						 new Object[] { relPatternClassNode },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the EClassifierIsInTypedModel constraint of '<em>Rel Pattern Class Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternClassNode_EClassifierIsInTypedModel(RelPatternClassNode relPatternClassNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "EClassifierIsInTypedModel", getObjectLabel(relPatternClassNode, context) },
						 new Object[] { relPatternClassNode },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateAnonIsUnnamed constraint of '<em>Rel Pattern Class Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternClassNode_validateAnonIsUnnamed(RelPatternClassNode relPatternClassNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relPatternClassNode.validateAnonIsUnnamed(diagnostics, context);
	}

	/**
	 * Validates the validateEClassifierIsInTypedModel constraint of '<em>Rel Pattern Class Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternClassNode_validateEClassifierIsInTypedModel(RelPatternClassNode relPatternClassNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relPatternClassNode.validateEClassifierIsInTypedModel(diagnostics, context);
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
		if (result || diagnostics != null) result &= validateRelPatternEdge_SourceIsClassNode(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_SourceIsEClass(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_CompatiblePropertySource(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_CompatibleSourceIndex(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_CompatibleSourceMultiplicity(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_CompatibleEAttributePropertyTarget(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_CompatibleEReferencePropertyTarget(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_CompatibleMemberPropertyTarget(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_CompatibleRestPropertyTarget(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_validateSourceIsEClass(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_validateSourceIsClassNode(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_validateCompatibleEAttributePropertyTarget(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_validateCompatibleSourceMultiplicity(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_validateCompatibleEReferencePropertyTarget(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_validateCompatiblePropertySource(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_validateCompatibleSourceIndex(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_validateCompatibleRestPropertyTarget(relPatternEdge, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelPatternEdge_validateCompatibleMemberPropertyTarget(relPatternEdge, diagnostics, context);
		return result;
	}

	/**
	 * Validates the SourceIsClassNode constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_SourceIsClassNode(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "SourceIsClassNode", getObjectLabel(relPatternEdge, context) },
						 new Object[] { relPatternEdge },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the SourceIsEClass constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_SourceIsEClass(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "SourceIsEClass", getObjectLabel(relPatternEdge, context) },
						 new Object[] { relPatternEdge },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the CompatiblePropertySource constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_CompatiblePropertySource(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "CompatiblePropertySource", getObjectLabel(relPatternEdge, context) },
						 new Object[] { relPatternEdge },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the CompatibleSourceIndex constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_CompatibleSourceIndex(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "CompatibleSourceIndex", getObjectLabel(relPatternEdge, context) },
						 new Object[] { relPatternEdge },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the CompatibleSourceMultiplicity constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_CompatibleSourceMultiplicity(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "CompatibleSourceMultiplicity", getObjectLabel(relPatternEdge, context) },
						 new Object[] { relPatternEdge },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the CompatibleEAttributePropertyTarget constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_CompatibleEAttributePropertyTarget(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "CompatibleEAttributePropertyTarget", getObjectLabel(relPatternEdge, context) },
						 new Object[] { relPatternEdge },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the CompatibleEReferencePropertyTarget constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_CompatibleEReferencePropertyTarget(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "CompatibleEReferencePropertyTarget", getObjectLabel(relPatternEdge, context) },
						 new Object[] { relPatternEdge },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the CompatibleMemberPropertyTarget constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_CompatibleMemberPropertyTarget(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "CompatibleMemberPropertyTarget", getObjectLabel(relPatternEdge, context) },
						 new Object[] { relPatternEdge },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the CompatibleRestPropertyTarget constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_CompatibleRestPropertyTarget(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "CompatibleRestPropertyTarget", getObjectLabel(relPatternEdge, context) },
						 new Object[] { relPatternEdge },
						 context));
			}
			return false;
		}
		return true;
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
	 * Validates the validateSourceIsClassNode constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_validateSourceIsClassNode(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relPatternEdge.validateSourceIsClassNode(diagnostics, context);
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
	 * Validates the validateCompatibleEAttributePropertyTarget constraint of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternEdge_validateCompatibleEAttributePropertyTarget(RelPatternEdge relPatternEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relPatternEdge.validateCompatibleEAttributePropertyTarget(diagnostics, context);
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternExpressionNode(RelPatternExpressionNode relPatternExpressionNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(relPatternExpressionNode, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelPatternNode(RelPatternNode relPatternNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(relPatternNode, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateTxDiagram_RelDiagramNamesAreUnique(txDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validateTxDiagram_TxTypedModelNodeNamesAreUnique(txDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validateTxDiagram_validateRelDiagramNamesAreUnique(txDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validateTxDiagram_validateTxTypedModelNodeNamesAreUnique(txDiagram, diagnostics, context);
		return result;
	}

	/**
	 * Validates the RelDiagramNamesAreUnique constraint of '<em>Tx Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxDiagram_RelDiagramNamesAreUnique(TxDiagram txDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "RelDiagramNamesAreUnique", getObjectLabel(txDiagram, context) },
						 new Object[] { txDiagram },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the TxTypedModelNodeNamesAreUnique constraint of '<em>Tx Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxDiagram_TxTypedModelNodeNamesAreUnique(TxDiagram txDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "TxTypedModelNodeNamesAreUnique", getObjectLabel(txDiagram, context) },
						 new Object[] { txDiagram },
						 context));
			}
			return false;
		}
		return true;
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
	 * Validates the validateTxTypedModelNodeNamesAreUnique constraint of '<em>Tx Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxDiagram_validateTxTypedModelNodeNamesAreUnique(TxDiagram txDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return txDiagram.validateTxTypedModelNodeNamesAreUnique(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxImportNode(TxImportNode txImportNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(txImportNode, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateTxKeyNode_PartsAreUnique(txKeyNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateTxKeyNode_validatePartsAreUnique(txKeyNode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the PartsAreUnique constraint of '<em>Tx Key Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxKeyNode_PartsAreUnique(TxKeyNode txKeyNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "PartsAreUnique", getObjectLabel(txKeyNode, context) },
						 new Object[] { txKeyNode },
						 context));
			}
			return false;
		}
		return true;
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
		if (result || diagnostics != null) result &= validateTxPartNode_PartIsPropertyOfKey(txPartNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateTxPartNode_validatePartIsPropertyOfKey(txPartNode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the PartIsPropertyOfKey constraint of '<em>Tx Part Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxPartNode_PartIsPropertyOfKey(TxPartNode txPartNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "PartIsPropertyOfKey", getObjectLabel(txPartNode, context) },
						 new Object[] { txPartNode },
						 context));
			}
			return false;
		}
		return true;
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
		if (result || diagnostics != null) result &= validateTxTypedModelNode_TxPackageNodePackagesAreUnique(txTypedModelNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateTxTypedModelNode_validateTxPackageNodePackagesAreUnique(txTypedModelNode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the TxPackageNodePackagesAreUnique constraint of '<em>Tx Typed Model Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTxTypedModelNode_TxPackageNodePackagesAreUnique(TxTypedModelNode txTypedModelNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "TxPackageNodePackagesAreUnique", getObjectLabel(txTypedModelNode, context) },
						 new Object[] { txTypedModelNode },
						 context));
			}
			return false;
		}
		return true;
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
