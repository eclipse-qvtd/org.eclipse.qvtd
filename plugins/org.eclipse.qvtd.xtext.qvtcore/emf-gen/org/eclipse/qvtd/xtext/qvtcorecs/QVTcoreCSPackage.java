/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcorecs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSFactory
 * @model kind="package"
 * @generated
 */
public interface QVTcoreCSPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qvtcorecs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/2015/QVTcoreCS";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtccs";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	String eCONTENT_TYPE = "org.eclipse.qvtd.xtext.qvtcore";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTcoreCSPackage eINSTANCE = org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.AreaCSImpl <em>Area CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.AreaCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getAreaCS()
	 * @generated
	 */
	int AREA_CS = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.PatternCSImpl <em>Pattern CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.PatternCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getPatternCS()
	 * @generated
	 */
	int PATTERN_CS = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.BottomPatternCSImpl <em>Bottom Pattern CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.BottomPatternCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getBottomPatternCS()
	 * @generated
	 */
	int BOTTOM_PATTERN_CS = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.DirectionCSImpl <em>Direction CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.DirectionCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getDirectionCS()
	 * @generated
	 */
	int DIRECTION_CS = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.DomainCSImpl <em>Domain CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.DomainCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getDomainCS()
	 * @generated
	 */
	int DOMAIN_CS = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.EnforcementOperationCSImpl <em>Enforcement Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.EnforcementOperationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getEnforcementOperationCS()
	 * @generated
	 */
	int ENFORCEMENT_OPERATION_CS = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.GuardPatternCSImpl <em>Guard Pattern CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.GuardPatternCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getGuardPatternCS()
	 * @generated
	 */
	int GUARD_PATTERN_CS = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.MappingCSImpl <em>Mapping CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.MappingCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getMappingCS()
	 * @generated
	 */
	int MAPPING_CS = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.ParamDeclarationCSImpl <em>Param Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.ParamDeclarationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getParamDeclarationCS()
	 * @generated
	 */
	int PARAM_DECLARATION_CS = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.PredicateCSImpl <em>Predicate CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.PredicateCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getPredicateCS()
	 * @generated
	 */
	int PREDICATE_CS = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.PredicateOrAssignmentCSImpl <em>Predicate Or Assignment CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.PredicateOrAssignmentCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getPredicateOrAssignmentCS()
	 * @generated
	 */
	int PREDICATE_OR_ASSIGNMENT_CS = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.QueryCSImpl <em>Query CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QueryCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getQueryCS()
	 * @generated
	 */
	int QUERY_CS = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.RealizeableVariableCSImpl <em>Realizeable Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.RealizeableVariableCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getRealizeableVariableCS()
	 * @generated
	 */
	int REALIZEABLE_VARIABLE_CS = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.RealizedVariableCSImpl <em>Realized Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.RealizedVariableCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getRealizedVariableCS()
	 * @generated
	 */
	int REALIZED_VARIABLE_CS = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.TopLevelCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getTopLevelCS()
	 * @generated
	 */
	int TOP_LEVEL_CS = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.TransformationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getTransformationCS()
	 * @generated
	 */
	int TRANSFORMATION_CS = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.UnrealizedVariableCSImpl <em>Unrealized Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.UnrealizedVariableCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getUnrealizedVariableCS()
	 * @generated
	 */
	int UNREALIZED_VARIABLE_CS = 16;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecs.AreaCS <em>Area CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Area CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.AreaCS
	 * @generated
	 */
	EClass getAreaCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecs.AreaCS#getOwnedGuardPattern <em>Owned Guard Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Guard Pattern</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.AreaCS#getOwnedGuardPattern()
	 * @see #getAreaCS()
	 * @generated
	 */
	EReference getAreaCS_OwnedGuardPattern();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecs.AreaCS#getOwnedBottomPattern <em>Owned Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Bottom Pattern</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.AreaCS#getOwnedBottomPattern()
	 * @see #getAreaCS()
	 * @generated
	 */
	EReference getAreaCS_OwnedBottomPattern();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecs.BottomPatternCS <em>Bottom Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bottom Pattern CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.BottomPatternCS
	 * @generated
	 */
	EClass getBottomPatternCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecs.BottomPatternCS#getOwnedEnforcementOperations <em>Owned Enforcement Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Enforcement Operations</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.BottomPatternCS#getOwnedEnforcementOperations()
	 * @see #getBottomPatternCS()
	 * @generated
	 */
	EReference getBottomPatternCS_OwnedEnforcementOperations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecs.BottomPatternCS#getOwnedRealizedVariables <em>Owned Realized Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Realized Variables</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.BottomPatternCS#getOwnedRealizedVariables()
	 * @see #getBottomPatternCS()
	 * @generated
	 */
	EReference getBottomPatternCS_OwnedRealizedVariables();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecs.BottomPatternCS#getOwnedConstraints <em>Owned Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Constraints</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.BottomPatternCS#getOwnedConstraints()
	 * @see #getBottomPatternCS()
	 * @generated
	 */
	EReference getBottomPatternCS_OwnedConstraints();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecs.DirectionCS <em>Direction CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Direction CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.DirectionCS
	 * @generated
	 */
	EClass getDirectionCS();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtcorecs.DirectionCS#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imports</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.DirectionCS#getImports()
	 * @see #getDirectionCS()
	 * @generated
	 */
	EReference getDirectionCS_Imports();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtcorecs.DirectionCS#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Uses</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.DirectionCS#getUses()
	 * @see #getDirectionCS()
	 * @generated
	 */
	EReference getDirectionCS_Uses();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecs.DomainCS <em>Domain CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.DomainCS
	 * @generated
	 */
	EClass getDomainCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcorecs.DomainCS#isIsCheck <em>Is Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Check</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.DomainCS#isIsCheck()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_IsCheck();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcorecs.DomainCS#isIsEnforce <em>Is Enforce</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Enforce</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.DomainCS#isIsEnforce()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_IsEnforce();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcorecs.DomainCS#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Direction</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.DomainCS#getDirection()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_Direction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecs.EnforcementOperationCS <em>Enforcement Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enforcement Operation CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.EnforcementOperationCS
	 * @generated
	 */
	EClass getEnforcementOperationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcorecs.EnforcementOperationCS#isIsDeletion <em>Is Deletion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Deletion</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.EnforcementOperationCS#isIsDeletion()
	 * @see #getEnforcementOperationCS()
	 * @generated
	 */
	EAttribute getEnforcementOperationCS_IsDeletion();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecs.EnforcementOperationCS#getOwnedOperationCall <em>Owned Operation Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Operation Call</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.EnforcementOperationCS#getOwnedOperationCall()
	 * @see #getEnforcementOperationCS()
	 * @generated
	 */
	EReference getEnforcementOperationCS_OwnedOperationCall();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecs.GuardPatternCS <em>Guard Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard Pattern CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.GuardPatternCS
	 * @generated
	 */
	EClass getGuardPatternCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecs.GuardPatternCS#getOwnedPredicates <em>Owned Predicates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Predicates</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.GuardPatternCS#getOwnedPredicates()
	 * @see #getGuardPatternCS()
	 * @generated
	 */
	EReference getGuardPatternCS_OwnedPredicates();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecs.MappingCS <em>Mapping CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.MappingCS
	 * @generated
	 */
	EClass getMappingCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#isIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#isIsAbstract()
	 * @see #getMappingCS()
	 * @generated
	 */
	EAttribute getMappingCS_IsAbstract();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#getOwnedComposedMappings <em>Owned Composed Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Composed Mappings</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#getOwnedComposedMappings()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_OwnedComposedMappings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#getOwnedDomains <em>Owned Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Domains</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#getOwnedDomains()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_OwnedDomains();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#getOwnedInPathName <em>Owned In Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned In Path Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#getOwnedInPathName()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_OwnedInPathName();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#getOwnedMiddle <em>Owned Middle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Middle</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#getOwnedMiddle()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_OwnedMiddle();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#getRefines <em>Refines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refines</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.MappingCS#getRefines()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_Refines();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecs.ParamDeclarationCS <em>Param Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Param Declaration CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.ParamDeclarationCS
	 * @generated
	 */
	EClass getParamDeclarationCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecs.PatternCS <em>Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.PatternCS
	 * @generated
	 */
	EClass getPatternCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecs.PatternCS#getOwnedUnrealizedVariables <em>Owned Unrealized Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Unrealized Variables</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.PatternCS#getOwnedUnrealizedVariables()
	 * @see #getPatternCS()
	 * @generated
	 */
	EReference getPatternCS_OwnedUnrealizedVariables();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecs.PredicateCS <em>Predicate CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.PredicateCS
	 * @generated
	 */
	EClass getPredicateCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecs.PredicateCS#getOwnedCondition <em>Owned Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Condition</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.PredicateCS#getOwnedCondition()
	 * @see #getPredicateCS()
	 * @generated
	 */
	EReference getPredicateCS_OwnedCondition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecs.PredicateOrAssignmentCS <em>Predicate Or Assignment CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate Or Assignment CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.PredicateOrAssignmentCS
	 * @generated
	 */
	EClass getPredicateOrAssignmentCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcorecs.PredicateOrAssignmentCS#isIsDefault <em>Is Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Default</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.PredicateOrAssignmentCS#isIsDefault()
	 * @see #getPredicateOrAssignmentCS()
	 * @generated
	 */
	EAttribute getPredicateOrAssignmentCS_IsDefault();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcorecs.PredicateOrAssignmentCS#isIsPartial <em>Is Partial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Partial</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.PredicateOrAssignmentCS#isIsPartial()
	 * @see #getPredicateOrAssignmentCS()
	 * @generated
	 */
	EAttribute getPredicateOrAssignmentCS_IsPartial();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecs.PredicateOrAssignmentCS#getOwnedTarget <em>Owned Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Target</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.PredicateOrAssignmentCS#getOwnedTarget()
	 * @see #getPredicateOrAssignmentCS()
	 * @generated
	 */
	EReference getPredicateOrAssignmentCS_OwnedTarget();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecs.PredicateOrAssignmentCS#getOwnedInitExpression <em>Owned Init Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init Expression</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.PredicateOrAssignmentCS#getOwnedInitExpression()
	 * @see #getPredicateOrAssignmentCS()
	 * @generated
	 */
	EReference getPredicateOrAssignmentCS_OwnedInitExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecs.QueryCS <em>Query CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QueryCS
	 * @generated
	 */
	EClass getQueryCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecs.QueryCS#getOwnedPathName <em>Owned Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Path Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QueryCS#getOwnedPathName()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_OwnedPathName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcorecs.QueryCS#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transformation</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QueryCS#getTransformation()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_Transformation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecs.QueryCS#getOwnedParameters <em>Owned Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameters</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QueryCS#getOwnedParameters()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_OwnedParameters();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecs.QueryCS#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QueryCS#getOwnedExpression()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_OwnedExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcorecs.QueryCS#isIsTransient <em>Is Transient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Transient</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QueryCS#isIsTransient()
	 * @see #getQueryCS()
	 * @generated
	 */
	EAttribute getQueryCS_IsTransient();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecs.RealizeableVariableCS <em>Realizeable Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Realizeable Variable CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.RealizeableVariableCS
	 * @generated
	 */
	EClass getRealizeableVariableCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecs.RealizedVariableCS <em>Realized Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Realized Variable CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.RealizedVariableCS
	 * @generated
	 */
	EClass getRealizedVariableCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecs.TopLevelCS <em>Top Level CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Level CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.TopLevelCS
	 * @generated
	 */
	EClass getTopLevelCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecs.TopLevelCS#getOwnedMappings <em>Owned Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Mappings</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.TopLevelCS#getOwnedMappings()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_OwnedMappings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecs.TopLevelCS#getOwnedQueries <em>Owned Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Queries</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.TopLevelCS#getOwnedQueries()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_OwnedQueries();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecs.TopLevelCS#getOwnedTransformations <em>Owned Transformations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Transformations</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.TopLevelCS#getOwnedTransformations()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_OwnedTransformations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecs.TransformationCS <em>Transformation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.TransformationCS
	 * @generated
	 */
	EClass getTransformationCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcorecs.TransformationCS#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Package</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.TransformationCS#getPackage()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_Package();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecs.TransformationCS#getOwnedDirections <em>Owned Directions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Directions</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.TransformationCS#getOwnedDirections()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_OwnedDirections();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecs.UnrealizedVariableCS <em>Unrealized Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unrealized Variable CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.UnrealizedVariableCS
	 * @generated
	 */
	EClass getUnrealizedVariableCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecs.UnrealizedVariableCS#getOwnedInitExpression <em>Owned Init Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init Expression</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.UnrealizedVariableCS#getOwnedInitExpression()
	 * @see #getUnrealizedVariableCS()
	 * @generated
	 */
	EReference getUnrealizedVariableCS_OwnedInitExpression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTcoreCSFactory getQVTcoreCSFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.AreaCSImpl <em>Area CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.AreaCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getAreaCS()
		 * @generated
		 */
		EClass AREA_CS = eINSTANCE.getAreaCS();

		/**
		 * The meta object literal for the '<em><b>Owned Guard Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA_CS__OWNED_GUARD_PATTERN = eINSTANCE.getAreaCS_OwnedGuardPattern();

		/**
		 * The meta object literal for the '<em><b>Owned Bottom Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA_CS__OWNED_BOTTOM_PATTERN = eINSTANCE.getAreaCS_OwnedBottomPattern();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.BottomPatternCSImpl <em>Bottom Pattern CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.BottomPatternCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getBottomPatternCS()
		 * @generated
		 */
		EClass BOTTOM_PATTERN_CS = eINSTANCE.getBottomPatternCS();

		/**
		 * The meta object literal for the '<em><b>Owned Enforcement Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTOM_PATTERN_CS__OWNED_ENFORCEMENT_OPERATIONS = eINSTANCE.getBottomPatternCS_OwnedEnforcementOperations();

		/**
		 * The meta object literal for the '<em><b>Owned Realized Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES = eINSTANCE.getBottomPatternCS_OwnedRealizedVariables();

		/**
		 * The meta object literal for the '<em><b>Owned Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS = eINSTANCE.getBottomPatternCS_OwnedConstraints();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.DirectionCSImpl <em>Direction CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.DirectionCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getDirectionCS()
		 * @generated
		 */
		EClass DIRECTION_CS = eINSTANCE.getDirectionCS();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTION_CS__IMPORTS = eINSTANCE.getDirectionCS_Imports();

		/**
		 * The meta object literal for the '<em><b>Uses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTION_CS__USES = eINSTANCE.getDirectionCS_Uses();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.DomainCSImpl <em>Domain CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.DomainCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getDomainCS()
		 * @generated
		 */
		EClass DOMAIN_CS = eINSTANCE.getDomainCS();

		/**
		 * The meta object literal for the '<em><b>Is Check</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_CS__IS_CHECK = eINSTANCE.getDomainCS_IsCheck();

		/**
		 * The meta object literal for the '<em><b>Is Enforce</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_CS__IS_ENFORCE = eINSTANCE.getDomainCS_IsEnforce();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_CS__DIRECTION = eINSTANCE.getDomainCS_Direction();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.EnforcementOperationCSImpl <em>Enforcement Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.EnforcementOperationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getEnforcementOperationCS()
		 * @generated
		 */
		EClass ENFORCEMENT_OPERATION_CS = eINSTANCE.getEnforcementOperationCS();

		/**
		 * The meta object literal for the '<em><b>Is Deletion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENFORCEMENT_OPERATION_CS__IS_DELETION = eINSTANCE.getEnforcementOperationCS_IsDeletion();

		/**
		 * The meta object literal for the '<em><b>Owned Operation Call</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCEMENT_OPERATION_CS__OWNED_OPERATION_CALL = eINSTANCE.getEnforcementOperationCS_OwnedOperationCall();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.GuardPatternCSImpl <em>Guard Pattern CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.GuardPatternCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getGuardPatternCS()
		 * @generated
		 */
		EClass GUARD_PATTERN_CS = eINSTANCE.getGuardPatternCS();

		/**
		 * The meta object literal for the '<em><b>Owned Predicates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD_PATTERN_CS__OWNED_PREDICATES = eINSTANCE.getGuardPatternCS_OwnedPredicates();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.MappingCSImpl <em>Mapping CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.MappingCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getMappingCS()
		 * @generated
		 */
		EClass MAPPING_CS = eINSTANCE.getMappingCS();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_CS__IS_ABSTRACT = eINSTANCE.getMappingCS_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Owned Composed Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__OWNED_COMPOSED_MAPPINGS = eINSTANCE.getMappingCS_OwnedComposedMappings();

		/**
		 * The meta object literal for the '<em><b>Owned Domains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__OWNED_DOMAINS = eINSTANCE.getMappingCS_OwnedDomains();

		/**
		 * The meta object literal for the '<em><b>Owned In Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__OWNED_IN_PATH_NAME = eINSTANCE.getMappingCS_OwnedInPathName();

		/**
		 * The meta object literal for the '<em><b>Owned Middle</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__OWNED_MIDDLE = eINSTANCE.getMappingCS_OwnedMiddle();

		/**
		 * The meta object literal for the '<em><b>Refines</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__REFINES = eINSTANCE.getMappingCS_Refines();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.ParamDeclarationCSImpl <em>Param Declaration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.ParamDeclarationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getParamDeclarationCS()
		 * @generated
		 */
		EClass PARAM_DECLARATION_CS = eINSTANCE.getParamDeclarationCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.PatternCSImpl <em>Pattern CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.PatternCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getPatternCS()
		 * @generated
		 */
		EClass PATTERN_CS = eINSTANCE.getPatternCS();

		/**
		 * The meta object literal for the '<em><b>Owned Unrealized Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_CS__OWNED_UNREALIZED_VARIABLES = eINSTANCE.getPatternCS_OwnedUnrealizedVariables();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.PredicateCSImpl <em>Predicate CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.PredicateCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getPredicateCS()
		 * @generated
		 */
		EClass PREDICATE_CS = eINSTANCE.getPredicateCS();

		/**
		 * The meta object literal for the '<em><b>Owned Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE_CS__OWNED_CONDITION = eINSTANCE.getPredicateCS_OwnedCondition();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.PredicateOrAssignmentCSImpl <em>Predicate Or Assignment CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.PredicateOrAssignmentCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getPredicateOrAssignmentCS()
		 * @generated
		 */
		EClass PREDICATE_OR_ASSIGNMENT_CS = eINSTANCE.getPredicateOrAssignmentCS();

		/**
		 * The meta object literal for the '<em><b>Is Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREDICATE_OR_ASSIGNMENT_CS__IS_DEFAULT = eINSTANCE.getPredicateOrAssignmentCS_IsDefault();

		/**
		 * The meta object literal for the '<em><b>Is Partial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREDICATE_OR_ASSIGNMENT_CS__IS_PARTIAL = eINSTANCE.getPredicateOrAssignmentCS_IsPartial();

		/**
		 * The meta object literal for the '<em><b>Owned Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE_OR_ASSIGNMENT_CS__OWNED_TARGET = eINSTANCE.getPredicateOrAssignmentCS_OwnedTarget();

		/**
		 * The meta object literal for the '<em><b>Owned Init Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE_OR_ASSIGNMENT_CS__OWNED_INIT_EXPRESSION = eINSTANCE.getPredicateOrAssignmentCS_OwnedInitExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.QueryCSImpl <em>Query CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QueryCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getQueryCS()
		 * @generated
		 */
		EClass QUERY_CS = eINSTANCE.getQueryCS();

		/**
		 * The meta object literal for the '<em><b>Owned Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__OWNED_PATH_NAME = eINSTANCE.getQueryCS_OwnedPathName();

		/**
		 * The meta object literal for the '<em><b>Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__TRANSFORMATION = eINSTANCE.getQueryCS_Transformation();

		/**
		 * The meta object literal for the '<em><b>Owned Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__OWNED_PARAMETERS = eINSTANCE.getQueryCS_OwnedParameters();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__OWNED_EXPRESSION = eINSTANCE.getQueryCS_OwnedExpression();

		/**
		 * The meta object literal for the '<em><b>Is Transient</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_CS__IS_TRANSIENT = eINSTANCE.getQueryCS_IsTransient();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.RealizeableVariableCSImpl <em>Realizeable Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.RealizeableVariableCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getRealizeableVariableCS()
		 * @generated
		 */
		EClass REALIZEABLE_VARIABLE_CS = eINSTANCE.getRealizeableVariableCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.RealizedVariableCSImpl <em>Realized Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.RealizedVariableCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getRealizedVariableCS()
		 * @generated
		 */
		EClass REALIZED_VARIABLE_CS = eINSTANCE.getRealizedVariableCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.TopLevelCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getTopLevelCS()
		 * @generated
		 */
		EClass TOP_LEVEL_CS = eINSTANCE.getTopLevelCS();

		/**
		 * The meta object literal for the '<em><b>Owned Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__OWNED_MAPPINGS = eINSTANCE.getTopLevelCS_OwnedMappings();

		/**
		 * The meta object literal for the '<em><b>Owned Queries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__OWNED_QUERIES = eINSTANCE.getTopLevelCS_OwnedQueries();

		/**
		 * The meta object literal for the '<em><b>Owned Transformations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__OWNED_TRANSFORMATIONS = eINSTANCE.getTopLevelCS_OwnedTransformations();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.TransformationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getTransformationCS()
		 * @generated
		 */
		EClass TRANSFORMATION_CS = eINSTANCE.getTransformationCS();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__PACKAGE = eINSTANCE.getTransformationCS_Package();

		/**
		 * The meta object literal for the '<em><b>Owned Directions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__OWNED_DIRECTIONS = eINSTANCE.getTransformationCS_OwnedDirections();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.UnrealizedVariableCSImpl <em>Unrealized Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.UnrealizedVariableCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecs.impl.QVTcoreCSPackageImpl#getUnrealizedVariableCS()
		 * @generated
		 */
		EClass UNREALIZED_VARIABLE_CS = eINSTANCE.getUnrealizedVariableCS();

		/**
		 * The meta object literal for the '<em><b>Owned Init Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNREALIZED_VARIABLE_CS__OWNED_INIT_EXPRESSION = eINSTANCE.getUnrealizedVariableCS_OwnedInitExpression();

	}

} //QVTcoreCSTPackage
