/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvttemplate.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.LiteralExpImpl;
import org.eclipse.ocl.pivot.internal.utilities.LazyXMIidAssigningResourceImpl;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateFactory;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.util.QVTtemplateValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTtemplatePackageImpl extends EPackageImpl implements QVTtemplatePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionTemplateExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectTemplateExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyTemplateItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateExpEClass = null;

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
	 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTtemplatePackageImpl() {
		super(eNS_URI, QVTtemplateFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QVTtemplatePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTtemplatePackage init() {
		if (isInited) return (QVTtemplatePackage)EPackage.Registry.INSTANCE.getEPackage(QVTtemplatePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredQVTtemplatePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QVTtemplatePackageImpl theQVTtemplatePackage = registeredQVTtemplatePackage instanceof QVTtemplatePackageImpl ? (QVTtemplatePackageImpl)registeredQVTtemplatePackage : new QVTtemplatePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		PivotPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTtemplatePackage.createPackageContents();

		// Initialize created meta-data
		theQVTtemplatePackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theQVTtemplatePackage,
			 new EValidator.Descriptor() {
				 @Override
				 public EValidator getEValidator() {
					 return QVTtemplateValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theQVTtemplatePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTtemplatePackage.eNS_URI, theQVTtemplatePackage);
		return theQVTtemplatePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCollectionTemplateExp() {
		return collectionTemplateExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCollectionTemplateExp_Member() {
		return (EReference)collectionTemplateExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCollectionTemplateExp_ReferredCollectionType() {
		return (EReference)collectionTemplateExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCollectionTemplateExp_Rest() {
		return (EReference)collectionTemplateExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getCollectionTemplateExp__ValidateMemberTypeisCollectionElementType__DiagnosticChain_Map() {
		return collectionTemplateExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getCollectionTemplateExp__ValidateRestTypeisCollectionType__DiagnosticChain_Map() {
		return collectionTemplateExpEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getCollectionTemplateExp__ValidateTypeisCollectionType__DiagnosticChain_Map() {
		return collectionTemplateExpEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getObjectTemplateExp() {
		return objectTemplateExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getObjectTemplateExp_Part() {
		return (EReference)objectTemplateExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getObjectTemplateExp_ReferredClass() {
		return (EReference)objectTemplateExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getObjectTemplateExp__ValidatePartPropertyIsUnique__DiagnosticChain_Map() {
		return objectTemplateExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getObjectTemplateExp__ValidateTypeisObjectType__DiagnosticChain_Map() {
		return objectTemplateExpEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyTemplateItem() {
		return propertyTemplateItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyTemplateItem_ObjContainer() {
		return (EReference)propertyTemplateItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyTemplateItem_ReferredProperty() {
		return (EReference)propertyTemplateItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyTemplateItem_Value() {
		return (EReference)propertyTemplateItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPropertyTemplateItem_IsOpposite() {
		return (EAttribute)propertyTemplateItemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyTemplateItem_ResolvedProperty() {
		return (EReference)propertyTemplateItemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyTemplateItem__ValidateCompatibleClassForProperty__DiagnosticChain_Map() {
		return propertyTemplateItemEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyTemplateItem__ValidateCompatibleTypeForObjectValue__DiagnosticChain_Map() {
		return propertyTemplateItemEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyTemplateItem__ValidateCompatibleTypeForCollectionElementValue__DiagnosticChain_Map() {
		return propertyTemplateItemEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyTemplateItem__ValidateCompatibleTypeForCollectionValue__DiagnosticChain_Map() {
		return propertyTemplateItemEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTemplateExp() {
		return templateExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTemplateExp_BindsTo() {
		return (EReference)templateExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTemplateExp_Where() {
		return (EReference)templateExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTemplateExp__ValidateWhereIsBoolean__DiagnosticChain_Map() {
		return templateExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTtemplateFactory getQVTtemplateFactory() {
		return (QVTtemplateFactory)getEFactoryInstance();
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
		collectionTemplateExpEClass = createEClass(0);
		createEReference(collectionTemplateExpEClass, LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 2);
		createEReference(collectionTemplateExpEClass, LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 3);
		createEReference(collectionTemplateExpEClass, LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 4);
		createEOperation(collectionTemplateExpEClass, LiteralExpImpl.LITERAL_EXP_OPERATION_COUNT + 2);
		createEOperation(collectionTemplateExpEClass, LiteralExpImpl.LITERAL_EXP_OPERATION_COUNT + 3);
		createEOperation(collectionTemplateExpEClass, LiteralExpImpl.LITERAL_EXP_OPERATION_COUNT + 4);

		objectTemplateExpEClass = createEClass(1);
		createEReference(objectTemplateExpEClass, LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 2);
		createEReference(objectTemplateExpEClass, LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 3);
		createEOperation(objectTemplateExpEClass, LiteralExpImpl.LITERAL_EXP_OPERATION_COUNT + 2);
		createEOperation(objectTemplateExpEClass, LiteralExpImpl.LITERAL_EXP_OPERATION_COUNT + 3);

		propertyTemplateItemEClass = createEClass(2);
		createEReference(propertyTemplateItemEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 0);
		createEReference(propertyTemplateItemEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 1);
		createEReference(propertyTemplateItemEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 2);
		createEAttribute(propertyTemplateItemEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 3);
		createEReference(propertyTemplateItemEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 4);
		createEOperation(propertyTemplateItemEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 1);
		createEOperation(propertyTemplateItemEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 2);
		createEOperation(propertyTemplateItemEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 3);
		createEOperation(propertyTemplateItemEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 4);

		templateExpEClass = createEClass(3);
		createEReference(templateExpEClass, LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 0);
		createEReference(templateExpEClass, LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 1);
		createEOperation(templateExpEClass, LiteralExpImpl.LITERAL_EXP_OPERATION_COUNT + 1);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		collectionTemplateExpEClass.getESuperTypes().add(this.getTemplateExp());
		objectTemplateExpEClass.getESuperTypes().add(this.getTemplateExp());
		propertyTemplateItemEClass.getESuperTypes().add(thePivotPackage.getElement());
		propertyTemplateItemEClass.getESuperTypes().add(thePivotPackage.getReferringElement());
		templateExpEClass.getESuperTypes().add(thePivotPackage.getLiteralExp());
		templateExpEClass.getESuperTypes().add(thePivotPackage.getReferringElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(collectionTemplateExpEClass, CollectionTemplateExp.class, "CollectionTemplateExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionTemplateExp_Member(), thePivotPackage.getOCLExpression(), null, "member", null, 0, -1, CollectionTemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollectionTemplateExp_ReferredCollectionType(), thePivotPackage.getCollectionType(), null, "referredCollectionType", null, 1, 1, CollectionTemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionTemplateExp_Rest(), thePivotPackage.getVariable(), null, "rest", null, 0, 1, CollectionTemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getCollectionTemplateExp__ValidateMemberTypeisCollectionElementType__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateMemberTypeisCollectionElementType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCollectionTemplateExp__ValidateRestTypeisCollectionType__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateRestTypeisCollectionType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCollectionTemplateExp__ValidateTypeisCollectionType__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTypeisCollectionType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(objectTemplateExpEClass, ObjectTemplateExp.class, "ObjectTemplateExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectTemplateExp_Part(), this.getPropertyTemplateItem(), this.getPropertyTemplateItem_ObjContainer(), "part", null, 0, -1, ObjectTemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getObjectTemplateExp_ReferredClass(), thePivotPackage.getClass_(), null, "referredClass", null, 1, 1, ObjectTemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getObjectTemplateExp__ValidatePartPropertyIsUnique__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validatePartPropertyIsUnique", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getObjectTemplateExp__ValidateTypeisObjectType__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTypeisObjectType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(propertyTemplateItemEClass, PropertyTemplateItem.class, "PropertyTemplateItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyTemplateItem_ObjContainer(), this.getObjectTemplateExp(), this.getObjectTemplateExp_Part(), "objContainer", null, 1, 1, PropertyTemplateItem.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyTemplateItem_ReferredProperty(), thePivotPackage.getProperty(), null, "referredProperty", null, 1, 1, PropertyTemplateItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyTemplateItem_Value(), thePivotPackage.getOCLExpression(), null, "value", null, 1, 1, PropertyTemplateItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyTemplateItem_IsOpposite(), ecorePackage.getEBoolean(), "isOpposite", "false", 1, 1, PropertyTemplateItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyTemplateItem_ResolvedProperty(), thePivotPackage.getProperty(), null, "resolvedProperty", null, 1, 1, PropertyTemplateItem.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = initEOperation(getPropertyTemplateItem__ValidateCompatibleClassForProperty__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleClassForProperty", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPropertyTemplateItem__ValidateCompatibleTypeForObjectValue__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleTypeForObjectValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPropertyTemplateItem__ValidateCompatibleTypeForCollectionElementValue__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleTypeForCollectionElementValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPropertyTemplateItem__ValidateCompatibleTypeForCollectionValue__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleTypeForCollectionValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(templateExpEClass, TemplateExp.class, "TemplateExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplateExp_BindsTo(), thePivotPackage.getVariable(), null, "bindsTo", null, 0, 1, TemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTemplateExp_Where(), thePivotPackage.getOCLExpression(), null, "where", null, 0, 1, TemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getTemplateExp__ValidateWhereIsBoolean__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateWhereIsBoolean", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
		// http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName
		createEmofAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";
		addAnnotation
		  (this,
		   source,
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEmofAnnotations() {
		String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName";
		addAnnotation
		  (getCollectionTemplateExp_Member(),
		   source,
		   new String[] {
			   "body", "listContainer"
		   });
		addAnnotation
		  (getCollectionTemplateExp_Rest(),
		   source,
		   new String[] {
			   "body", "matchingExp"
		   });
		addAnnotation
		  (getPropertyTemplateItem_ReferredProperty(),
		   source,
		   new String[] {
			   "body", "propertyItem"
		   });
		addAnnotation
		  (getPropertyTemplateItem_Value(),
		   source,
		   new String[] {
			   "body", "propertyItem"
		   });
		addAnnotation
		  (getTemplateExp_BindsTo(),
		   source,
		   new String[] {
			   "body", "templateExp"
		   });
		addAnnotation
		  (getTemplateExp_Where(),
		   source,
		   new String[] {
			   "body", "owner"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML";
		addAnnotation
		  (getCollectionTemplateExp__ValidateMemberTypeisCollectionElementType__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "MemberTypeisCollectionElementType"
		   });
		addAnnotation
		  (getCollectionTemplateExp__ValidateRestTypeisCollectionType__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "RestTypeisCollectionType"
		   });
		addAnnotation
		  (getCollectionTemplateExp__ValidateTypeisCollectionType__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "TypeisCollectionType"
		   });
		addAnnotation
		  (getObjectTemplateExp__ValidatePartPropertyIsUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "PartPropertyIsUnique"
		   });
		addAnnotation
		  (getObjectTemplateExp__ValidateTypeisObjectType__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "TypeisObjectType"
		   });
		addAnnotation
		  (getPropertyTemplateItem__ValidateCompatibleClassForProperty__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "CompatibleClassForProperty"
		   });
		addAnnotation
		  (getPropertyTemplateItem__ValidateCompatibleTypeForObjectValue__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "CompatibleTypeForObjectValue"
		   });
		addAnnotation
		  (getPropertyTemplateItem__ValidateCompatibleTypeForCollectionElementValue__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "CompatibleTypeForCollectionElementValue"
		   });
		addAnnotation
		  (getPropertyTemplateItem__ValidateCompatibleTypeForCollectionValue__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "CompatibleTypeForCollectionValue"
		   });
		addAnnotation
		  (getTemplateExp__ValidateWhereIsBoolean__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "WhereIsBoolean"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
		addAnnotation
		  (getCollectionTemplateExp__ValidateMemberTypeisCollectionElementType__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tmember->forAll(type?.conformsTo(referredCollectionType.elementType))\n\n"
		   });
		addAnnotation
		  (getCollectionTemplateExp__ValidateRestTypeisCollectionType__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\trest <> null implies\n\t\trest.type = referredCollectionType\n\n"
		   });
		addAnnotation
		  (getCollectionTemplateExp__ValidateTypeisCollectionType__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\ttype = referredCollectionType\n\n"
		   });
		addAnnotation
		  (getObjectTemplateExp__ValidatePartPropertyIsUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tpart->isUnique(resolvedProperty)\n\n"
		   });
		addAnnotation
		  (getObjectTemplateExp__ValidateTypeisObjectType__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\ttype = referredClass\n\n"
		   });
		addAnnotation
		  (getPropertyTemplateItem__ValidateCompatibleClassForProperty__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "Tuple {\n\tmessage : String = objContainer.referredClass.name + \' must conform to \' + resolvedProperty.owningClass?.name,\n\tstatus : Boolean = \n\tobjContainer.referredClass.conformsTo(resolvedProperty.owningClass)\n\n\n}.status"
		   });
		addAnnotation
		  (getPropertyTemplateItem__ValidateCompatibleTypeForObjectValue__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "Tuple {\n\tmessage : String = value.type?.name + \' must conform to \' + resolvedProperty.type?.name + \' or vice-versa\',\n\tstatus : Boolean = \n\tnot resolvedProperty.type.oclIsKindOf(ocl::CollectionType) implies\n\t\tlet propertyType = resolvedProperty.type in\n\t\tlet valueType = value.type in\n\t\t\tvalueType?.conformsTo(propertyType)\n\t\t\tor propertyType?.conformsTo(valueType)\n\n\n}.status"
		   });
		addAnnotation
		  (getPropertyTemplateItem__ValidateCompatibleTypeForCollectionElementValue__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "Tuple {\n\tmessage : String = value.type?.name + \' must conform to \' + resolvedProperty.type.oclAsType(ocl::CollectionType).elementType.name + \' or vice-versa\',\n\tstatus : Boolean = \n\tresolvedProperty.type.oclIsKindOf(ocl::CollectionType)\n\tand not value.type.oclIsKindOf(ocl::CollectionType) implies\n\t\tlet propertyType = resolvedProperty.type.oclAsType(ocl::CollectionType).elementType in\n\t\tlet valueType = value.type in\n\t\t\tvalueType?.conformsTo(propertyType)\n\t\t\tor propertyType.conformsTo(valueType)\n\n\n}.status"
		   });
		addAnnotation
		  (getPropertyTemplateItem__ValidateCompatibleTypeForCollectionValue__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "Tuple {\n\tmessage : String = value.type.oclAsType(ocl::CollectionType).elementType.name + \' must conform to \' + resolvedProperty.type.oclAsType(ocl::CollectionType).elementType.name + \' or vice-versa\',\n\tstatus : Boolean = \n\tresolvedProperty.type.oclIsKindOf(ocl::CollectionType)\n\tand value.type.oclIsKindOf(ocl::CollectionType) implies\n\t\tlet propertyType = resolvedProperty.type.oclAsType(ocl::CollectionType).elementType in\n\t\tlet valueType = value.type.oclAsType(ocl::CollectionType).elementType in\n--\t\tTuple {\n--\t\t\tmessage : String = valueType.conformsTo(propertyType) or propertyType.conformsTo(valueType),\n\t\t\t/*status : Boolean =*/ valueType.conformsTo(propertyType) or propertyType.conformsTo(valueType)\n\n}.status"
		   });
		addAnnotation
		  (getPropertyTemplateItem_ResolvedProperty(),
		   source,
		   new String[] {
			   "derivation", "\n\tif isOpposite then referredProperty.opposite else referredProperty endif\n\n"
		   });
		addAnnotation
		  (getTemplateExp__ValidateWhereIsBoolean__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\twhere <> null implies\n\t\twhere.type = Boolean\n\n"
		   });
	}

	/**
	 * Overridden to populate the idToEObjectMap/eObjectToIDMap maps when an attempt is made to use them.
	 *
	 * @generated NOT
	 */
	@Override
	protected Resource createResource(/*@NonNull*/ String uri) {
		Resource resource = eResource();
		if (resource == null) {
			resource = LazyXMIidAssigningResourceImpl.createResource(uri, this);
		}
		return resource;
	}
} //QVTtemplatePackageImpl
