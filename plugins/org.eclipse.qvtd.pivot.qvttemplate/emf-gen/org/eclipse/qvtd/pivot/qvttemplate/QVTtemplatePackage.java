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
package org.eclipse.qvtd.pivot.qvttemplate;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore"
 * @generated
 */
public interface QVTtemplatePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qvttemplate";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/2015/QVTtemplate";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtt";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.qvtd.qvttemplate";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTtemplatePackage eINSTANCE = org.eclipse.qvtd.pivot.qvttemplate.impl.QVTtemplatePackageImpl.init();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp <em>Collection Template Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Template Exp</em>'.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp
	 * @generated
	 */
	EClass getCollectionTemplateExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp#getMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Member</em>'.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp#getMember()
	 * @see #getCollectionTemplateExp()
	 * @generated
	 */
	EReference getCollectionTemplateExp_Member();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp#getReferredCollectionType <em>Referred Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Collection Type</em>'.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp#getReferredCollectionType()
	 * @see #getCollectionTemplateExp()
	 * @generated
	 */
	EReference getCollectionTemplateExp_ReferredCollectionType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp#getRest <em>Rest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rest</em>'.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp#getRest()
	 * @see #getCollectionTemplateExp()
	 * @generated
	 */
	EReference getCollectionTemplateExp_Rest();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp#validateMemberTypeisCollectionElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Member Typeis Collection Element Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Member Typeis Collection Element Type</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp#validateMemberTypeisCollectionElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCollectionTemplateExp__ValidateMemberTypeisCollectionElementType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp#validateRestTypeisCollectionType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Rest Typeis Collection Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Rest Typeis Collection Type</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp#validateRestTypeisCollectionType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCollectionTemplateExp__ValidateRestTypeisCollectionType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp#validateTypeisCollectionType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Typeis Collection Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Typeis Collection Type</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp#validateTypeisCollectionType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCollectionTemplateExp__ValidateTypeisCollectionType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp <em>Object Template Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Template Exp</em>'.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp
	 * @generated
	 */
	EClass getObjectTemplateExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Part</em>'.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp#getPart()
	 * @see #getObjectTemplateExp()
	 * @generated
	 */
	EReference getObjectTemplateExp_Part();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp#getReferredClass <em>Referred Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Class</em>'.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp#getReferredClass()
	 * @see #getObjectTemplateExp()
	 * @generated
	 */
	EReference getObjectTemplateExp_ReferredClass();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp#validatePartPropertyIsUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Part Property Is Unique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Part Property Is Unique</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp#validatePartPropertyIsUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getObjectTemplateExp__ValidatePartPropertyIsUnique__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp#validateTypeisObjectType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Typeis Object Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Typeis Object Type</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp#validateTypeisObjectType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getObjectTemplateExp__ValidateTypeisObjectType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem <em>Property Template Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Template Item</em>'.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem
	 * @generated
	 */
	EClass getPropertyTemplateItem();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#getObjContainer <em>Obj Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Obj Container</em>'.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#getObjContainer()
	 * @see #getPropertyTemplateItem()
	 * @generated
	 */
	EReference getPropertyTemplateItem_ObjContainer();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#getReferredProperty()
	 * @see #getPropertyTemplateItem()
	 * @generated
	 */
	EReference getPropertyTemplateItem_ReferredProperty();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#getValue()
	 * @see #getPropertyTemplateItem()
	 * @generated
	 */
	EReference getPropertyTemplateItem_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#isIsOpposite <em>Is Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Opposite</em>'.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#isIsOpposite()
	 * @see #getPropertyTemplateItem()
	 * @generated
	 */
	EAttribute getPropertyTemplateItem_IsOpposite();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#getResolvedProperty <em>Resolved Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolved Property</em>'.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#getResolvedProperty()
	 * @see #getPropertyTemplateItem()
	 * @generated
	 */
	EReference getPropertyTemplateItem_ResolvedProperty();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#validateCompatibleClassForProperty(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Class For Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Class For Property</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#validateCompatibleClassForProperty(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPropertyTemplateItem__ValidateCompatibleClassForProperty__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#validateCompatibleTypeForObjectValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Object Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Object Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#validateCompatibleTypeForObjectValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPropertyTemplateItem__ValidateCompatibleTypeForObjectValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#validateCompatibleTypeForCollectionElementValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Collection Element Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Collection Element Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#validateCompatibleTypeForCollectionElementValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPropertyTemplateItem__ValidateCompatibleTypeForCollectionElementValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#validateCompatibleTypeForCollectionValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Collection Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Collection Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem#validateCompatibleTypeForCollectionValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPropertyTemplateItem__ValidateCompatibleTypeForCollectionValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvttemplate.TemplateExp <em>Template Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Exp</em>'.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.TemplateExp
	 * @generated
	 */
	EClass getTemplateExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvttemplate.TemplateExp#getBindsTo <em>Binds To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binds To</em>'.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.TemplateExp#getBindsTo()
	 * @see #getTemplateExp()
	 * @generated
	 */
	EReference getTemplateExp_BindsTo();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvttemplate.TemplateExp#getWhere <em>Where</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Where</em>'.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.TemplateExp#getWhere()
	 * @see #getTemplateExp()
	 * @generated
	 */
	EReference getTemplateExp_Where();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvttemplate.TemplateExp#validateWhereIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Where Is Boolean</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Where Is Boolean</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvttemplate.TemplateExp#validateWhereIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTemplateExp__ValidateWhereIsBoolean__DiagnosticChain_Map();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTtemplateFactory getQVTtemplateFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvttemplate.impl.CollectionTemplateExpImpl <em>Collection Template Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvttemplate.impl.CollectionTemplateExpImpl
		 * @see org.eclipse.qvtd.pivot.qvttemplate.impl.QVTtemplatePackageImpl#getCollectionTemplateExp()
		 * @generated
		 */
		EClass COLLECTION_TEMPLATE_EXP = eINSTANCE.getCollectionTemplateExp();

		/**
		 * The meta object literal for the '<em><b>Member</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TEMPLATE_EXP__MEMBER = eINSTANCE.getCollectionTemplateExp_Member();

		/**
		 * The meta object literal for the '<em><b>Referred Collection Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TEMPLATE_EXP__REFERRED_COLLECTION_TYPE = eINSTANCE.getCollectionTemplateExp_ReferredCollectionType();

		/**
		 * The meta object literal for the '<em><b>Rest</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TEMPLATE_EXP__REST = eINSTANCE.getCollectionTemplateExp_Rest();

		/**
		 * The meta object literal for the '<em><b>Validate Member Typeis Collection Element Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLLECTION_TEMPLATE_EXP___VALIDATE_MEMBER_TYPEIS_COLLECTION_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCollectionTemplateExp__ValidateMemberTypeisCollectionElementType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Rest Typeis Collection Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLLECTION_TEMPLATE_EXP___VALIDATE_REST_TYPEIS_COLLECTION_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCollectionTemplateExp__ValidateRestTypeisCollectionType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Typeis Collection Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLLECTION_TEMPLATE_EXP___VALIDATE_TYPEIS_COLLECTION_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCollectionTemplateExp__ValidateTypeisCollectionType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvttemplate.impl.ObjectTemplateExpImpl <em>Object Template Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvttemplate.impl.ObjectTemplateExpImpl
		 * @see org.eclipse.qvtd.pivot.qvttemplate.impl.QVTtemplatePackageImpl#getObjectTemplateExp()
		 * @generated
		 */
		EClass OBJECT_TEMPLATE_EXP = eINSTANCE.getObjectTemplateExp();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_TEMPLATE_EXP__PART = eINSTANCE.getObjectTemplateExp_Part();

		/**
		 * The meta object literal for the '<em><b>Referred Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_TEMPLATE_EXP__REFERRED_CLASS = eINSTANCE.getObjectTemplateExp_ReferredClass();

		/**
		 * The meta object literal for the '<em><b>Validate Part Property Is Unique</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OBJECT_TEMPLATE_EXP___VALIDATE_PART_PROPERTY_IS_UNIQUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getObjectTemplateExp__ValidatePartPropertyIsUnique__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Typeis Object Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OBJECT_TEMPLATE_EXP___VALIDATE_TYPEIS_OBJECT_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getObjectTemplateExp__ValidateTypeisObjectType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvttemplate.impl.PropertyTemplateItemImpl <em>Property Template Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvttemplate.impl.PropertyTemplateItemImpl
		 * @see org.eclipse.qvtd.pivot.qvttemplate.impl.QVTtemplatePackageImpl#getPropertyTemplateItem()
		 * @generated
		 */
		EClass PROPERTY_TEMPLATE_ITEM = eINSTANCE.getPropertyTemplateItem();

		/**
		 * The meta object literal for the '<em><b>Obj Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER = eINSTANCE.getPropertyTemplateItem_ObjContainer();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY = eINSTANCE.getPropertyTemplateItem_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_TEMPLATE_ITEM__VALUE = eINSTANCE.getPropertyTemplateItem_Value();

		/**
		 * The meta object literal for the '<em><b>Is Opposite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_TEMPLATE_ITEM__IS_OPPOSITE = eINSTANCE.getPropertyTemplateItem_IsOpposite();

		/**
		 * The meta object literal for the '<em><b>Resolved Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_TEMPLATE_ITEM__RESOLVED_PROPERTY = eINSTANCE.getPropertyTemplateItem_ResolvedProperty();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Class For Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_TEMPLATE_ITEM___VALIDATE_COMPATIBLE_CLASS_FOR_PROPERTY__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPropertyTemplateItem__ValidateCompatibleClassForProperty__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Object Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_TEMPLATE_ITEM___VALIDATE_COMPATIBLE_TYPE_FOR_OBJECT_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPropertyTemplateItem__ValidateCompatibleTypeForObjectValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Collection Element Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_TEMPLATE_ITEM___VALIDATE_COMPATIBLE_TYPE_FOR_COLLECTION_ELEMENT_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPropertyTemplateItem__ValidateCompatibleTypeForCollectionElementValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Collection Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_TEMPLATE_ITEM___VALIDATE_COMPATIBLE_TYPE_FOR_COLLECTION_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPropertyTemplateItem__ValidateCompatibleTypeForCollectionValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvttemplate.impl.TemplateExpImpl <em>Template Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvttemplate.impl.TemplateExpImpl
		 * @see org.eclipse.qvtd.pivot.qvttemplate.impl.QVTtemplatePackageImpl#getTemplateExp()
		 * @generated
		 */
		EClass TEMPLATE_EXP = eINSTANCE.getTemplateExp();

		/**
		 * The meta object literal for the '<em><b>Binds To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_EXP__BINDS_TO = eINSTANCE.getTemplateExp_BindsTo();

		/**
		 * The meta object literal for the '<em><b>Where</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_EXP__WHERE = eINSTANCE.getTemplateExp_Where();

		/**
		 * The meta object literal for the '<em><b>Validate Where Is Boolean</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TEMPLATE_EXP___VALIDATE_WHERE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTemplateExp__ValidateWhereIsBoolean__DiagnosticChain_Map();

	}

} //QVTtemplatePackage
