/**
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtbasecs.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.impl.ClassCSImpl;
import org.eclipse.ocl.xtext.basecs.impl.ElementCSImpl;
import org.eclipse.ocl.xtext.basecs.impl.ModelElementCSImpl;
import org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl;
import org.eclipse.ocl.xtext.basecs.impl.PackageCSImpl;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.xtext.qvtbasecs.AbstractTransformationCS;
import org.eclipse.qvtd.xtext.qvtbasecs.CompoundTargetElementCS;
import org.eclipse.qvtd.xtext.qvtbasecs.JavaClassCS;
import org.eclipse.qvtd.xtext.qvtbasecs.JavaImplementationCS;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSFactory;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage;
import org.eclipse.qvtd.xtext.qvtbasecs.QualifiedPackageCS;
import org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS;
import org.eclipse.qvtd.xtext.qvtbasecs.TargetCS;
import org.eclipse.qvtd.xtext.qvtbasecs.TargetElementCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTbaseCSPackageImpl extends EPackageImpl implements QVTbaseCSPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTransformationCSEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compoundTargetElementCSEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaClassCSEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaImplementationCSEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualifiedPackageCSEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleTargetElementCSEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetCSEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetElementCSEClass = null;
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
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTbaseCSPackageImpl()
	{
		super(eNS_URI, QVTbaseCSFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QVTbaseCSPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTbaseCSPackage init()
	{
		if (isInited) return (QVTbaseCSPackage)EPackage.Registry.INSTANCE.getEPackage(QVTbaseCSPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredQVTbaseCSPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QVTbaseCSPackageImpl theQVTbaseCSPackage = registeredQVTbaseCSPackage instanceof QVTbaseCSPackageImpl ? (QVTbaseCSPackageImpl)registeredQVTbaseCSPackage : new QVTbaseCSPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		BaseCSPackage.eINSTANCE.eClass();
		PivotPackage.eINSTANCE.eClass();
		QVTbasePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTbaseCSPackage.createPackageContents();

		// Initialize created meta-data
		theQVTbaseCSPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQVTbaseCSPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTbaseCSPackage.eNS_URI, theQVTbaseCSPackage);
		return theQVTbaseCSPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractTransformationCS()
	{
		return abstractTransformationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractTransformationCS_OwnedPathName()
	{
		return (EReference)abstractTransformationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractTransformationCS_OwnedTargets()
	{
		return (EReference)abstractTransformationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompoundTargetElementCS()
	{
		return compoundTargetElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompoundTargetElementCS_OwnedTargetElements()
	{
		return (EReference)compoundTargetElementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJavaClassCS()
	{
		return javaClassCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJavaImplementationCS()
	{
		return javaImplementationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJavaImplementationCS_Implementation()
	{
		return (EReference)javaImplementationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getQualifiedPackageCS()
	{
		return qualifiedPackageCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQualifiedPackageCS_OwnedPathName()
	{
		return (EReference)qualifiedPackageCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSimpleTargetElementCS()
	{
		return simpleTargetElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimpleTargetElementCS_TypedModel()
	{
		return (EReference)simpleTargetElementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimpleTargetElementCS_Iterates()
	{
		return (EReference)simpleTargetElementCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleTargetElementCS_Input()
	{
		return (EAttribute)simpleTargetElementCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleTargetElementCS_Output()
	{
		return (EAttribute)simpleTargetElementCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleTargetElementCS_Via()
	{
		return (EAttribute)simpleTargetElementCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTargetCS()
	{
		return targetCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTargetCS_OwnedTargetElements()
	{
		return (EReference)targetCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTargetElementCS()
	{
		return targetElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTbaseCSFactory getQVTbaseCSFactory()
	{
		return (QVTbaseCSFactory)getEFactoryInstance();
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
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		abstractTransformationCSEClass = createEClass(0);
		createEReference(abstractTransformationCSEClass, ClassCSImpl.CLASS_CS_FEATURE_COUNT + 0);
		createEReference(abstractTransformationCSEClass, ClassCSImpl.CLASS_CS_FEATURE_COUNT + 1);

		compoundTargetElementCSEClass = createEClass(1);
		createEReference(compoundTargetElementCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0);

		javaClassCSEClass = createEClass(2);

		javaImplementationCSEClass = createEClass(3);
		createEReference(javaImplementationCSEClass, ElementCSImpl.ELEMENT_CS_FEATURE_COUNT + 0);

		qualifiedPackageCSEClass = createEClass(4);
		createEReference(qualifiedPackageCSEClass, PackageCSImpl.PACKAGE_CS_FEATURE_COUNT + 0);

		simpleTargetElementCSEClass = createEClass(5);
		createEReference(simpleTargetElementCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0);
		createEReference(simpleTargetElementCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 1);
		createEAttribute(simpleTargetElementCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 2);
		createEAttribute(simpleTargetElementCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 3);
		createEAttribute(simpleTargetElementCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 4);

		targetCSEClass = createEClass(6);
		createEReference(targetCSEClass, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0);

		targetElementCSEClass = createEClass(7);
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
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		BaseCSPackage theBaseCSPackage = (BaseCSPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSPackage.eNS_URI);
		QVTbasePackage theQVTbasePackage = (QVTbasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTbasePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractTransformationCSEClass.getESuperTypes().add(theBaseCSPackage.getClassCS());
		compoundTargetElementCSEClass.getESuperTypes().add(this.getTargetElementCS());
		javaClassCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());
		javaImplementationCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		qualifiedPackageCSEClass.getESuperTypes().add(theBaseCSPackage.getPackageCS());
		simpleTargetElementCSEClass.getESuperTypes().add(this.getTargetElementCS());
		targetCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());
		targetElementCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractTransformationCSEClass, AbstractTransformationCS.class, "AbstractTransformationCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractTransformationCS_OwnedPathName(), theBaseCSPackage.getPathNameCS(), null, "ownedPathName", null, 0, 1, AbstractTransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractTransformationCS_OwnedTargets(), this.getTargetCS(), null, "ownedTargets", null, 0, -1, AbstractTransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compoundTargetElementCSEClass, CompoundTargetElementCS.class, "CompoundTargetElementCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompoundTargetElementCS_OwnedTargetElements(), this.getSimpleTargetElementCS(), null, "ownedTargetElements", null, 0, -1, CompoundTargetElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaClassCSEClass, JavaClassCS.class, "JavaClassCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(javaImplementationCSEClass, JavaImplementationCS.class, "JavaImplementationCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJavaImplementationCS_Implementation(), this.getJavaClassCS(), null, "implementation", null, 0, 1, JavaImplementationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qualifiedPackageCSEClass, QualifiedPackageCS.class, "QualifiedPackageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQualifiedPackageCS_OwnedPathName(), theBaseCSPackage.getPathNameCS(), null, "ownedPathName", null, 0, 1, QualifiedPackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleTargetElementCSEClass, SimpleTargetElementCS.class, "SimpleTargetElementCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimpleTargetElementCS_TypedModel(), theQVTbasePackage.getTypedModel(), null, "typedModel", null, 1, 1, SimpleTargetElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimpleTargetElementCS_Iterates(), theQVTbasePackage.getTypedModel(), null, "iterates", null, 0, -1, SimpleTargetElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleTargetElementCS_Input(), ecorePackage.getEBooleanObject(), "input", null, 0, 1, SimpleTargetElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleTargetElementCS_Output(), ecorePackage.getEBooleanObject(), "output", null, 0, 1, SimpleTargetElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleTargetElementCS_Via(), ecorePackage.getEBooleanObject(), "via", null, 0, 1, SimpleTargetElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetCSEClass, TargetCS.class, "TargetCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetCS_OwnedTargetElements(), this.getTargetElementCS(), null, "ownedTargetElements", null, 0, -1, TargetCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetElementCSEClass, TargetElementCS.class, "TargetElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //QVTbaseCSPackageImpl
