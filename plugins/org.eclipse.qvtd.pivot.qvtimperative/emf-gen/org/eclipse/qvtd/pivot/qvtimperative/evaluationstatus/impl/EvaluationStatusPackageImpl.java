/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationElement;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EvaluationStatusPackageImpl extends EPackageImpl implements EvaluationStatusPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationStatusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeStatusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classStatusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementStatusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evaluationElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingStatusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyStatusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationStatusEClass = null;

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
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EvaluationStatusPackageImpl() {
		super(eNS_URI, EvaluationStatusFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EvaluationStatusPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EvaluationStatusPackage init() {
		if (isInited) return (EvaluationStatusPackage)EPackage.Registry.INSTANCE.getEPackage(EvaluationStatusPackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		EvaluationStatusPackageImpl theEvaluationStatusPackage = (EvaluationStatusPackageImpl)(ePackage instanceof EvaluationStatusPackageImpl ? ePackage : new EvaluationStatusPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		QVTimperativePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEvaluationStatusPackage.createPackageContents();

		// Initialize created meta-data
		theEvaluationStatusPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEvaluationStatusPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EvaluationStatusPackage.eNS_URI, theEvaluationStatusPackage);
		return theEvaluationStatusPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssociationStatus() {
		return associationStatusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssociationStatus_ForwardEReference() {
		return (EReference)associationStatusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssociationStatus_FromClassStatuses() {
		return (EReference)associationStatusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAssociationStatus_IsInput() {
		return (EAttribute)associationStatusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAssociationStatus_IsOutput() {
		return (EAttribute)associationStatusEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssociationStatus_OwningTransformationStatus() {
		return (EReference)associationStatusEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssociationStatus_ToClassStatuses() {
		return (EReference)associationStatusEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeStatus() {
		return attributeStatusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeStatus_EFeature() {
		return (EReference)attributeStatusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttributeStatus_Object() {
		return (EAttribute)attributeStatusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeStatus_OwningClassStatus() {
		return (EReference)attributeStatusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getClassStatus() {
		return classStatusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassStatus_AssociationStatuses() {
		return (EReference)classStatusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassStatus_EObject() {
		return (EReference)classStatusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getClassStatus_IsInput() {
		return (EAttribute)classStatusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getClassStatus_IsOutput() {
		return (EAttribute)classStatusEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassStatus_OwnedAttributeStatuses() {
		return (EReference)classStatusEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassStatus_OwningTransformationStatus() {
		return (EReference)classStatusEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassStatus_Type() {
		return (EReference)classStatusEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getElementStatus() {
		return elementStatusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getElementStatus_Depth() {
		return (EAttribute)elementStatusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getElementStatus_Sources() {
		return (EReference)elementStatusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getElementStatus_Targets() {
		return (EReference)elementStatusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEvaluationElement() {
		return evaluationElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingStatus() {
		return mappingStatusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMappingStatus_BoundValues() {
		return (EAttribute)mappingStatusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMappingStatus_Depth() {
		return (EAttribute)mappingStatusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingStatus_Inputs() {
		return (EReference)mappingStatusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMappingStatus_IsBlocked() {
		return (EAttribute)mappingStatusEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMappingStatus_IsDirty() {
		return (EAttribute)mappingStatusEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingStatus_Outputs() {
		return (EReference)mappingStatusEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingStatus_OwningTransformationStatus() {
		return (EReference)mappingStatusEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingStatus_ReferredMappingCall() {
		return (EReference)mappingStatusEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyStatus() {
		return propertyStatusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPropertyStatus_IsAssignable() {
		return (EAttribute)propertyStatusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPropertyStatus_IsAssigned() {
		return (EAttribute)propertyStatusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPropertyStatus_IsDirty() {
		return (EAttribute)propertyStatusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPropertyStatus_IsError() {
		return (EAttribute)propertyStatusEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPropertyStatus_IsReady() {
		return (EAttribute)propertyStatusEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTransformationStatus() {
		return transformationStatusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformationStatus_OwnedAssociationStatuses() {
		return (EReference)transformationStatusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformationStatus_OwnedClassStatuses() {
		return (EReference)transformationStatusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformationStatus_OwnedMappingStatuses() {
		return (EReference)transformationStatusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EvaluationStatusFactory getEvaluationStatusFactory() {
		return (EvaluationStatusFactory)getEFactoryInstance();
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
		associationStatusEClass = createEClass(ASSOCIATION_STATUS);
		createEReference(associationStatusEClass, ASSOCIATION_STATUS__FORWARD_EREFERENCE);
		createEReference(associationStatusEClass, ASSOCIATION_STATUS__FROM_CLASS_STATUSES);
		createEAttribute(associationStatusEClass, ASSOCIATION_STATUS__IS_INPUT);
		createEAttribute(associationStatusEClass, ASSOCIATION_STATUS__IS_OUTPUT);
		createEReference(associationStatusEClass, ASSOCIATION_STATUS__OWNING_TRANSFORMATION_STATUS);
		createEReference(associationStatusEClass, ASSOCIATION_STATUS__TO_CLASS_STATUSES);

		attributeStatusEClass = createEClass(ATTRIBUTE_STATUS);
		createEReference(attributeStatusEClass, ATTRIBUTE_STATUS__EFEATURE);
		createEAttribute(attributeStatusEClass, ATTRIBUTE_STATUS__OBJECT);
		createEReference(attributeStatusEClass, ATTRIBUTE_STATUS__OWNING_CLASS_STATUS);

		classStatusEClass = createEClass(CLASS_STATUS);
		createEReference(classStatusEClass, CLASS_STATUS__ASSOCIATION_STATUSES);
		createEReference(classStatusEClass, CLASS_STATUS__EOBJECT);
		createEAttribute(classStatusEClass, CLASS_STATUS__IS_INPUT);
		createEAttribute(classStatusEClass, CLASS_STATUS__IS_OUTPUT);
		createEReference(classStatusEClass, CLASS_STATUS__OWNED_ATTRIBUTE_STATUSES);
		createEReference(classStatusEClass, CLASS_STATUS__OWNING_TRANSFORMATION_STATUS);
		createEReference(classStatusEClass, CLASS_STATUS__TYPE);

		elementStatusEClass = createEClass(ELEMENT_STATUS);
		createEAttribute(elementStatusEClass, ELEMENT_STATUS__DEPTH);
		createEReference(elementStatusEClass, ELEMENT_STATUS__SOURCES);
		createEReference(elementStatusEClass, ELEMENT_STATUS__TARGETS);

		evaluationElementEClass = createEClass(EVALUATION_ELEMENT);

		mappingStatusEClass = createEClass(MAPPING_STATUS);
		createEAttribute(mappingStatusEClass, MAPPING_STATUS__BOUND_VALUES);
		createEAttribute(mappingStatusEClass, MAPPING_STATUS__DEPTH);
		createEReference(mappingStatusEClass, MAPPING_STATUS__INPUTS);
		createEAttribute(mappingStatusEClass, MAPPING_STATUS__IS_BLOCKED);
		createEAttribute(mappingStatusEClass, MAPPING_STATUS__IS_DIRTY);
		createEReference(mappingStatusEClass, MAPPING_STATUS__OUTPUTS);
		createEReference(mappingStatusEClass, MAPPING_STATUS__OWNING_TRANSFORMATION_STATUS);
		createEReference(mappingStatusEClass, MAPPING_STATUS__REFERRED_MAPPING_CALL);

		propertyStatusEClass = createEClass(PROPERTY_STATUS);
		createEAttribute(propertyStatusEClass, PROPERTY_STATUS__IS_ASSIGNABLE);
		createEAttribute(propertyStatusEClass, PROPERTY_STATUS__IS_ASSIGNED);
		createEAttribute(propertyStatusEClass, PROPERTY_STATUS__IS_DIRTY);
		createEAttribute(propertyStatusEClass, PROPERTY_STATUS__IS_ERROR);
		createEAttribute(propertyStatusEClass, PROPERTY_STATUS__IS_READY);

		transformationStatusEClass = createEClass(TRANSFORMATION_STATUS);
		createEReference(transformationStatusEClass, TRANSFORMATION_STATUS__OWNED_ASSOCIATION_STATUSES);
		createEReference(transformationStatusEClass, TRANSFORMATION_STATUS__OWNED_CLASS_STATUSES);
		createEReference(transformationStatusEClass, TRANSFORMATION_STATUS__OWNED_MAPPING_STATUSES);
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
		QVTimperativePackage theQVTimperativePackage = (QVTimperativePackage)EPackage.Registry.INSTANCE.getEPackage(QVTimperativePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		associationStatusEClass.getESuperTypes().add(this.getPropertyStatus());
		attributeStatusEClass.getESuperTypes().add(this.getPropertyStatus());
		classStatusEClass.getESuperTypes().add(this.getElementStatus());
		elementStatusEClass.getESuperTypes().add(this.getEvaluationElement());
		mappingStatusEClass.getESuperTypes().add(this.getEvaluationElement());
		propertyStatusEClass.getESuperTypes().add(this.getElementStatus());
		transformationStatusEClass.getESuperTypes().add(this.getEvaluationElement());

		// Initialize classes and features; add operations and parameters
		initEClass(associationStatusEClass, AssociationStatus.class, "AssociationStatus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssociationStatus_ForwardEReference(), ecorePackage.getEReference(), null, "forwardEReference", null, 1, 1, AssociationStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociationStatus_FromClassStatuses(), this.getClassStatus(), null, "fromClassStatuses", null, 0, -1, AssociationStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAssociationStatus_IsInput(), ecorePackage.getEBoolean(), "isInput", "false", 0, 1, AssociationStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssociationStatus_IsOutput(), ecorePackage.getEBoolean(), "isOutput", "false", 0, 1, AssociationStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociationStatus_OwningTransformationStatus(), this.getTransformationStatus(), this.getTransformationStatus_OwnedAssociationStatuses(), "owningTransformationStatus", null, 1, 1, AssociationStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociationStatus_ToClassStatuses(), this.getClassStatus(), null, "toClassStatuses", null, 0, -1, AssociationStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(attributeStatusEClass, AttributeStatus.class, "AttributeStatus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeStatus_EFeature(), ecorePackage.getEStructuralFeature(), null, "eFeature", null, 1, 1, AttributeStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeStatus_Object(), thePivotPackage.getObject(), "object", null, 0, 1, AttributeStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeStatus_OwningClassStatus(), this.getClassStatus(), this.getClassStatus_OwnedAttributeStatuses(), "owningClassStatus", null, 1, 1, AttributeStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classStatusEClass, ClassStatus.class, "ClassStatus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassStatus_AssociationStatuses(), this.getAssociationStatus(), null, "associationStatuses", null, 0, -1, ClassStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassStatus_EObject(), ecorePackage.getEObject(), null, "eObject", null, 1, 1, ClassStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassStatus_IsInput(), ecorePackage.getEBoolean(), "isInput", "false", 0, 1, ClassStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassStatus_IsOutput(), ecorePackage.getEBoolean(), "isOutput", "false", 0, 1, ClassStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassStatus_OwnedAttributeStatuses(), this.getAttributeStatus(), this.getAttributeStatus_OwningClassStatus(), "ownedAttributeStatuses", null, 0, -1, ClassStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClassStatus_OwningTransformationStatus(), this.getTransformationStatus(), this.getTransformationStatus_OwnedClassStatuses(), "owningTransformationStatus", null, 1, 1, ClassStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassStatus_Type(), thePivotPackage.getType(), null, "type", null, 1, 1, ClassStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementStatusEClass, ElementStatus.class, "ElementStatus", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElementStatus_Depth(), ecorePackage.getEIntegerObject(), "depth", null, 0, 1, ElementStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementStatus_Sources(), this.getMappingStatus(), this.getMappingStatus_Outputs(), "sources", null, 0, -1, ElementStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getElementStatus_Targets(), this.getMappingStatus(), this.getMappingStatus_Inputs(), "targets", null, 0, -1, ElementStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(evaluationElementEClass, EvaluationElement.class, "EvaluationElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingStatusEClass, MappingStatus.class, "MappingStatus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingStatus_BoundValues(), thePivotPackage.getObject(), "boundValues", null, 0, -1, MappingStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingStatus_Depth(), ecorePackage.getEIntegerObject(), "depth", null, 0, 1, MappingStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingStatus_Inputs(), this.getElementStatus(), this.getElementStatus_Targets(), "inputs", null, 0, -1, MappingStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMappingStatus_IsBlocked(), ecorePackage.getEBoolean(), "isBlocked", "false", 0, 1, MappingStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingStatus_IsDirty(), ecorePackage.getEBoolean(), "isDirty", "false", 0, 1, MappingStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingStatus_Outputs(), this.getElementStatus(), this.getElementStatus_Sources(), "outputs", null, 0, -1, MappingStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMappingStatus_OwningTransformationStatus(), this.getTransformationStatus(), this.getTransformationStatus_OwnedMappingStatuses(), "owningTransformationStatus", null, 1, 1, MappingStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingStatus_ReferredMappingCall(), theQVTimperativePackage.getMappingCall(), null, "referredMappingCall", null, 1, 1, MappingStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyStatusEClass, PropertyStatus.class, "PropertyStatus", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyStatus_IsAssignable(), ecorePackage.getEBoolean(), "isAssignable", "false", 0, 1, PropertyStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyStatus_IsAssigned(), ecorePackage.getEBoolean(), "isAssigned", "false", 0, 1, PropertyStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyStatus_IsDirty(), ecorePackage.getEBoolean(), "isDirty", "false", 0, 1, PropertyStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyStatus_IsError(), ecorePackage.getEBoolean(), "isError", "false", 0, 1, PropertyStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyStatus_IsReady(), ecorePackage.getEBoolean(), "isReady", "false", 0, 1, PropertyStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationStatusEClass, TransformationStatus.class, "TransformationStatus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationStatus_OwnedAssociationStatuses(), this.getAssociationStatus(), this.getAssociationStatus_OwningTransformationStatus(), "ownedAssociationStatuses", null, 0, -1, TransformationStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTransformationStatus_OwnedClassStatuses(), this.getClassStatus(), this.getClassStatus_OwningTransformationStatus(), "ownedClassStatuses", null, 0, -1, TransformationStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTransformationStatus_OwnedMappingStatuses(), this.getMappingStatus(), this.getMappingStatus_OwningTransformationStatus(), "ownedMappingStatuses", null, 0, -1, TransformationStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore",
			 "qvtb", "../../org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.ecore#/",
			 "qvtcb", "../../org.eclipse.qvtd.pivot.qvtcorebase/model/QVTcoreBase.ecore#/",
			 "qvti", "QVTimperative.ecore#/"
		   });
	}

} //EvaluationStatusPackageImpl
