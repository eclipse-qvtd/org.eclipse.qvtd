/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: QVTcCSTPackageImpl.java,v 1.2 2008/08/09 17:42:09 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore.cst.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.qvt.declarative.parser.qvt.cst.QVTCSTPackage;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.AreaCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.AssignmentCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.BottomPatternCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.DirectionCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.DomainCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.EnforcementOperationCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTFactory;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.GuardPatternCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.ParamDeclarationCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.PatternCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.RealizeableVariableCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.RealizedVariableCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.TopLevelCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.TransformationCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.UnrealizedVariableCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTcCSTPackageImpl extends EPackageImpl implements QVTcCSTPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass areaCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bottomPatternCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directionCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paramDeclarationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queryCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realizeableVariableCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topLevelCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unrealizedVariableCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enforcementOperationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guardPatternCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realizedVariableCSEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTcCSTPackageImpl() {
		super(eNS_URI, QVTcCSTFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTcCSTPackage init() {
		if (isInited) return (QVTcCSTPackage)EPackage.Registry.INSTANCE.getEPackage(QVTcCSTPackage.eNS_URI);

		// Obtain or create and register package
		QVTcCSTPackageImpl theQVTcCSTPackage = (QVTcCSTPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof QVTcCSTPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new QVTcCSTPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		QVTCSTPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTcCSTPackage.createPackageContents();

		// Initialize created meta-data
		theQVTcCSTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQVTcCSTPackage.freeze();

		return theQVTcCSTPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAreaCS() {
		return areaCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAreaCS_BottomPattern() {
		return (EReference)areaCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAreaCS_GuardPattern() {
		return (EReference)areaCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignmentCS() {
		return assignmentCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignmentCS_Target() {
		return (EReference)assignmentCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignmentCS_Initialiser() {
		return (EReference)assignmentCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignmentCS_Default() {
		return (EAttribute)assignmentCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBottomPatternCS() {
		return bottomPatternCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBottomPatternCS_EnforcementOperations()
	{
		return (EReference)bottomPatternCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBottomPatternCS_RealizedVariables() {
		return (EReference)bottomPatternCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectionCS() {
		return directionCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDirectionCS_Imports() {
		return (EReference)directionCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDirectionCS_Uses() {
		return (EReference)directionCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingCS() {
		return mappingCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingCS_In() {
		return (EReference)mappingCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingCS_Middle()
	{
		return (EReference)mappingCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingCS_Refines() {
		return (EReference)mappingCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParamDeclarationCS() {
		return paramDeclarationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParamDeclarationCS_Identifier() {
		return (EReference)paramDeclarationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParamDeclarationCS_Type() {
		return (EReference)paramDeclarationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingCS_ComposedMappings() {
		return (EReference)mappingCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingCS_Domains() {
		return (EReference)mappingCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternCS() {
		return patternCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternCS_Constraints() {
		return (EReference)patternCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternCS_UnrealizedVariables() {
		return (EReference)patternCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQueryCS() {
		return queryCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryCS_PathName() {
		return (EReference)queryCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryCS_InputParamDeclaration() {
		return (EReference)queryCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryCS_OclExpression() {
		return (EReference)queryCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryCS_Type() {
		return (EReference)queryCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRealizeableVariableCS() {
		return realizeableVariableCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRealizeableVariableCS_Type() {
		return (EReference)realizeableVariableCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopLevelCS() {
		return topLevelCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopLevelCS_Mappings() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopLevelCS_Queries() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopLevelCS_Transformations() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformationCS() {
		return transformationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationCS_Directions() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationCS_PathName() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnrealizedVariableCS() {
		return unrealizedVariableCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTcCSTFactory getQVTcCSTFactory() {
		return (QVTcCSTFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnforcementOperationCS()
	{
		return enforcementOperationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnforcementOperationCS_Deletion()
	{
		return (EAttribute)enforcementOperationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnforcementOperationCS_OperationCall()
	{
		return (EReference)enforcementOperationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainCS() {
		return domainCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomainCS_Check() {
		return (EAttribute)domainCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomainCS_Enforce() {
		return (EAttribute)domainCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGuardPatternCS() {
		return guardPatternCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRealizedVariableCS() {
		return realizedVariableCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		areaCSEClass = createEClass(AREA_CS);
		createEReference(areaCSEClass, AREA_CS__GUARD_PATTERN);
		createEReference(areaCSEClass, AREA_CS__BOTTOM_PATTERN);

		assignmentCSEClass = createEClass(ASSIGNMENT_CS);
		createEReference(assignmentCSEClass, ASSIGNMENT_CS__TARGET);
		createEReference(assignmentCSEClass, ASSIGNMENT_CS__INITIALISER);
		createEAttribute(assignmentCSEClass, ASSIGNMENT_CS__DEFAULT);

		bottomPatternCSEClass = createEClass(BOTTOM_PATTERN_CS);
		createEReference(bottomPatternCSEClass, BOTTOM_PATTERN_CS__ENFORCEMENT_OPERATIONS);
		createEReference(bottomPatternCSEClass, BOTTOM_PATTERN_CS__REALIZED_VARIABLES);

		directionCSEClass = createEClass(DIRECTION_CS);
		createEReference(directionCSEClass, DIRECTION_CS__IMPORTS);
		createEReference(directionCSEClass, DIRECTION_CS__USES);

		domainCSEClass = createEClass(DOMAIN_CS);
		createEAttribute(domainCSEClass, DOMAIN_CS__CHECK);
		createEAttribute(domainCSEClass, DOMAIN_CS__ENFORCE);

		enforcementOperationCSEClass = createEClass(ENFORCEMENT_OPERATION_CS);
		createEAttribute(enforcementOperationCSEClass, ENFORCEMENT_OPERATION_CS__DELETION);
		createEReference(enforcementOperationCSEClass, ENFORCEMENT_OPERATION_CS__OPERATION_CALL);

		guardPatternCSEClass = createEClass(GUARD_PATTERN_CS);

		mappingCSEClass = createEClass(MAPPING_CS);
		createEReference(mappingCSEClass, MAPPING_CS__COMPOSED_MAPPINGS);
		createEReference(mappingCSEClass, MAPPING_CS__DOMAINS);
		createEReference(mappingCSEClass, MAPPING_CS__IN);
		createEReference(mappingCSEClass, MAPPING_CS__MIDDLE);
		createEReference(mappingCSEClass, MAPPING_CS__REFINES);

		paramDeclarationCSEClass = createEClass(PARAM_DECLARATION_CS);
		createEReference(paramDeclarationCSEClass, PARAM_DECLARATION_CS__IDENTIFIER);
		createEReference(paramDeclarationCSEClass, PARAM_DECLARATION_CS__TYPE);

		patternCSEClass = createEClass(PATTERN_CS);
		createEReference(patternCSEClass, PATTERN_CS__CONSTRAINTS);
		createEReference(patternCSEClass, PATTERN_CS__UNREALIZED_VARIABLES);

		queryCSEClass = createEClass(QUERY_CS);
		createEReference(queryCSEClass, QUERY_CS__INPUT_PARAM_DECLARATION);
		createEReference(queryCSEClass, QUERY_CS__OCL_EXPRESSION);
		createEReference(queryCSEClass, QUERY_CS__PATH_NAME);
		createEReference(queryCSEClass, QUERY_CS__TYPE);

		realizeableVariableCSEClass = createEClass(REALIZEABLE_VARIABLE_CS);
		createEReference(realizeableVariableCSEClass, REALIZEABLE_VARIABLE_CS__TYPE);

		realizedVariableCSEClass = createEClass(REALIZED_VARIABLE_CS);

		topLevelCSEClass = createEClass(TOP_LEVEL_CS);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__TRANSFORMATIONS);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__QUERIES);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__MAPPINGS);

		transformationCSEClass = createEClass(TRANSFORMATION_CS);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__DIRECTIONS);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__PATH_NAME);

		unrealizedVariableCSEClass = createEClass(UNREALIZED_VARIABLE_CS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		QVTCSTPackage theQVTCSTPackage = (QVTCSTPackage)EPackage.Registry.INSTANCE.getEPackage(QVTCSTPackage.eNS_URI);
		CSTPackage theCSTPackage = (CSTPackage)EPackage.Registry.INSTANCE.getEPackage(CSTPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		areaCSEClass.getESuperTypes().add(theQVTCSTPackage.getIdentifiedCS());
		assignmentCSEClass.getESuperTypes().add(theCSTPackage.getOCLExpressionCS());
		bottomPatternCSEClass.getESuperTypes().add(this.getPatternCS());
		directionCSEClass.getESuperTypes().add(theQVTCSTPackage.getIdentifiedCS());
		domainCSEClass.getESuperTypes().add(this.getAreaCS());
		enforcementOperationCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		guardPatternCSEClass.getESuperTypes().add(this.getPatternCS());
		mappingCSEClass.getESuperTypes().add(theQVTCSTPackage.getIdentifiedCS());
		paramDeclarationCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		patternCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		queryCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		queryCSEClass.getESuperTypes().add(theQVTCSTPackage.getIHasName());
		realizeableVariableCSEClass.getESuperTypes().add(theQVTCSTPackage.getIdentifiedCS());
		realizedVariableCSEClass.getESuperTypes().add(this.getRealizeableVariableCS());
		topLevelCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		transformationCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		transformationCSEClass.getESuperTypes().add(theQVTCSTPackage.getIHasName());
		unrealizedVariableCSEClass.getESuperTypes().add(this.getRealizeableVariableCS());

		// Initialize classes and features; add operations and parameters
		initEClass(areaCSEClass, AreaCS.class, "AreaCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAreaCS_GuardPattern(), this.getGuardPatternCS(), null, "guardPattern", null, 0, 1, AreaCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAreaCS_BottomPattern(), this.getBottomPatternCS(), null, "bottomPattern", null, 0, 1, AreaCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assignmentCSEClass, AssignmentCS.class, "AssignmentCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignmentCS_Target(), theCSTPackage.getOCLExpressionCS(), null, "target", null, 1, 1, AssignmentCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignmentCS_Initialiser(), theCSTPackage.getOCLExpressionCS(), null, "initialiser", null, 1, 1, AssignmentCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssignmentCS_Default(), ecorePackage.getEBoolean(), "default", null, 0, 1, AssignmentCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bottomPatternCSEClass, BottomPatternCS.class, "BottomPatternCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBottomPatternCS_EnforcementOperations(), this.getEnforcementOperationCS(), null, "enforcementOperations", null, 0, -1, BottomPatternCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBottomPatternCS_RealizedVariables(), this.getRealizedVariableCS(), null, "realizedVariables", null, 0, -1, BottomPatternCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(directionCSEClass, DirectionCS.class, "DirectionCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDirectionCS_Imports(), theCSTPackage.getPathNameCS(), null, "imports", null, 0, -1, DirectionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDirectionCS_Uses(), theQVTCSTPackage.getIdentifierCS(), null, "uses", null, 0, -1, DirectionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainCSEClass, DomainCS.class, "DomainCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDomainCS_Check(), ecorePackage.getEBoolean(), "check", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainCS_Enforce(), ecorePackage.getEBoolean(), "enforce", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enforcementOperationCSEClass, EnforcementOperationCS.class, "EnforcementOperationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnforcementOperationCS_Deletion(), ecorePackage.getEBoolean(), "deletion", null, 0, 1, EnforcementOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnforcementOperationCS_OperationCall(), theCSTPackage.getOperationCallExpCS(), null, "operationCall", null, 0, 1, EnforcementOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(guardPatternCSEClass, GuardPatternCS.class, "GuardPatternCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingCSEClass, MappingCS.class, "MappingCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingCS_ComposedMappings(), this.getMappingCS(), null, "composedMappings", null, 0, -1, MappingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCS_Domains(), this.getDomainCS(), null, "domains", null, 0, -1, MappingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCS_In(), theCSTPackage.getPathNameCS(), null, "in", null, 0, 1, MappingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCS_Middle(), this.getDomainCS(), null, "middle", null, 1, 1, MappingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCS_Refines(), theQVTCSTPackage.getIdentifierCS(), null, "refines", null, 0, -1, MappingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paramDeclarationCSEClass, ParamDeclarationCS.class, "ParamDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParamDeclarationCS_Identifier(), theQVTCSTPackage.getIdentifierCS(), null, "identifier", null, 0, 1, ParamDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParamDeclarationCS_Type(), theCSTPackage.getTypeCS(), null, "type", null, 0, 1, ParamDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(patternCSEClass, PatternCS.class, "PatternCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPatternCS_Constraints(), theCSTPackage.getOCLExpressionCS(), null, "constraints", null, 0, -1, PatternCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternCS_UnrealizedVariables(), this.getUnrealizedVariableCS(), null, "unrealizedVariables", null, 0, -1, PatternCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(queryCSEClass, QueryCS.class, "QueryCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQueryCS_InputParamDeclaration(), this.getParamDeclarationCS(), null, "inputParamDeclaration", null, 0, -1, QueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryCS_OclExpression(), theCSTPackage.getOCLExpressionCS(), null, "oclExpression", null, 0, 1, QueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryCS_PathName(), theCSTPackage.getPathNameCS(), null, "pathName", null, 0, 1, QueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryCS_Type(), theCSTPackage.getTypeCS(), null, "type", null, 0, 1, QueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(realizeableVariableCSEClass, RealizeableVariableCS.class, "RealizeableVariableCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRealizeableVariableCS_Type(), theCSTPackage.getTypeCS(), null, "type", null, 0, 1, RealizeableVariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(realizedVariableCSEClass, RealizedVariableCS.class, "RealizedVariableCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(topLevelCSEClass, TopLevelCS.class, "TopLevelCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTopLevelCS_Transformations(), this.getTransformationCS(), null, "transformations", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopLevelCS_Queries(), this.getQueryCS(), null, "queries", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopLevelCS_Mappings(), this.getMappingCS(), null, "mappings", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationCSEClass, TransformationCS.class, "TransformationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationCS_Directions(), this.getDirectionCS(), null, "directions", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_PathName(), theCSTPackage.getPathNameCS(), null, "pathName", null, 0, 1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unrealizedVariableCSEClass, UnrealizedVariableCS.class, "UnrealizedVariableCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EqvtcCSTPackageImpl
