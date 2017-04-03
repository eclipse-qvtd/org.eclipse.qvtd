/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * ;All rights reserved. This program and the accompanying materials
 * ;are made available under the terms of the Eclipse Public License v1.0
 * ;which accompanies this distribution, and is available at
 * ;http://www.eclipse.org/legal/epl-v10.html
 * ;
 * ;Contributors:
 * ;  E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.m2m.atl.common.ATL.ATLPackage;

import org.eclipse.m2m.atl.common.OCL.OCLPackage;

import org.eclipse.m2m.atl.common.PrimitiveTypes.PrimitiveTypesPackage;

import org.eclipse.ocl.pivot.PivotPackage;

import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrFactory;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation;

import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;

import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;

import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PATL2QVTrPackageImpl extends EPackageImpl implements PATL2QVTrPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tModel2RelationalTransformationEClass = null;

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
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PATL2QVTrPackageImpl() {
		super(eNS_URI, PATL2QVTrFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link PATL2QVTrPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PATL2QVTrPackage init() {
		if (isInited) return (PATL2QVTrPackage)EPackage.Registry.INSTANCE.getEPackage(PATL2QVTrPackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		PATL2QVTrPackageImpl thePATL2QVTrPackage = (PATL2QVTrPackageImpl)(ePackage instanceof PATL2QVTrPackageImpl ? ePackage : new PATL2QVTrPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ATLPackage.eINSTANCE.eClass();
		PrimitiveTypesPackage.eINSTANCE.eClass();
		OCLPackage.eINSTANCE.eClass();
		PivotPackage.eINSTANCE.eClass();
		QVTbasePackage.eINSTANCE.eClass();
		QVTrelationPackage.eINSTANCE.eClass();
		QVTtemplatePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePATL2QVTrPackage.createPackageContents();

		// Initialize created meta-data
		thePATL2QVTrPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePATL2QVTrPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PATL2QVTrPackage.eNS_URI, thePATL2QVTrPackage);
		return thePATL2QVTrPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTModel2RelationalTransformation() {
		return tModel2RelationalTransformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTModel2RelationalTransformation__3() {
		return (EReference)tModel2RelationalTransformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTModel2RelationalTransformation__4() {
		return (EReference)tModel2RelationalTransformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTModel2RelationalTransformation_Module() {
		return (EReference)tModel2RelationalTransformationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTModel2RelationalTransformation_RelModel() {
		return (EReference)tModel2RelationalTransformationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTModel2RelationalTransformation_TxName() {
		return (EAttribute)tModel2RelationalTransformationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PATL2QVTrFactory getPATL2QVTrFactory() {
		return (PATL2QVTrFactory)getEFactoryInstance();
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
		tModel2RelationalTransformationEClass = createEClass(TMODEL2_RELATIONAL_TRANSFORMATION);
		createEReference(tModel2RelationalTransformationEClass, TMODEL2_RELATIONAL_TRANSFORMATION__3);
		createEReference(tModel2RelationalTransformationEClass, TMODEL2_RELATIONAL_TRANSFORMATION__4);
		createEReference(tModel2RelationalTransformationEClass, TMODEL2_RELATIONAL_TRANSFORMATION__MODULE);
		createEReference(tModel2RelationalTransformationEClass, TMODEL2_RELATIONAL_TRANSFORMATION__REL_MODEL);
		createEAttribute(tModel2RelationalTransformationEClass, TMODEL2_RELATIONAL_TRANSFORMATION__TX_NAME);
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
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		QVTrelationPackage theQVTrelationPackage = (QVTrelationPackage)EPackage.Registry.INSTANCE.getEPackage(QVTrelationPackage.eNS_URI);
		ATLPackage theATLPackage = (ATLPackage)EPackage.Registry.INSTANCE.getEPackage(ATLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(tModel2RelationalTransformationEClass, TModel2RelationalTransformation.class, "TModel2RelationalTransformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTModel2RelationalTransformation__3(), thePivotPackage.getPackage(), null, "_3", null, 1, 1, TModel2RelationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTModel2RelationalTransformation__4(), theQVTrelationPackage.getRelationalTransformation(), null, "_4", null, 1, 1, TModel2RelationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTModel2RelationalTransformation_Module(), theATLPackage.getModule(), null, "module", null, 1, 1, TModel2RelationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTModel2RelationalTransformation_RelModel(), theQVTrelationPackage.getRelationModel(), null, "relModel", null, 1, 1, TModel2RelationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTModel2RelationalTransformation_TxName(), ecorePackage.getEString(), "txName", null, 1, 1, TModel2RelationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/qvt#Domains
		createQvtDomainsAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/qvt#Domains</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createQvtDomainsAnnotations() {
		String source = "http://www.eclipse.org/qvt#Domains";
		addAnnotation
		(getTModel2RelationalTransformation__3(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTModel2RelationalTransformation__4(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTModel2RelationalTransformation_Module(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTModel2RelationalTransformation_RelModel(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
	}

} //PATL2QVTrPackageImpl