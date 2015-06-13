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
package org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus;

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
 * <!-- begin-model-doc -->
 * The Package for an Imperative QVT transformation evaluation status.
 * <!-- end-model-doc -->
 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore' qvtb='../../org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.ecore#/' qvtcb='../../org.eclipse.qvtd.pivot.qvtcorebase/model/QVTcoreBase.ecore#/' qvti='QVTimperative.ecore#/'"
 * @generated
 */
public interface EvaluationStatusPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "evaluationstatus";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/2015/EvaluationStatus";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "es";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EvaluationStatusPackage eINSTANCE = org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationStatusPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationElementImpl <em>Evaluation Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationElementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationStatusPackageImpl#getEvaluationElement()
	 * @generated
	 */
	int EVALUATION_ELEMENT = 4;

	/**
	 * The number of structural features of the '<em>Evaluation Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.ElementStatusImpl <em>Element Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.ElementStatusImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationStatusPackageImpl#getElementStatus()
	 * @generated
	 */
	int ELEMENT_STATUS = 3;

	/**
	 * The feature id for the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_STATUS__DEPTH = EVALUATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_STATUS__SOURCES = EVALUATION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_STATUS__TARGETS = EVALUATION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Element Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_STATUS_FEATURE_COUNT = EVALUATION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.PropertyStatusImpl <em>Property Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.PropertyStatusImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationStatusPackageImpl#getPropertyStatus()
	 * @generated
	 */
	int PROPERTY_STATUS = 6;

	/**
	 * The feature id for the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_STATUS__DEPTH = ELEMENT_STATUS__DEPTH;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_STATUS__SOURCES = ELEMENT_STATUS__SOURCES;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_STATUS__TARGETS = ELEMENT_STATUS__TARGETS;

	/**
	 * The feature id for the '<em><b>Is Assignable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_STATUS__IS_ASSIGNABLE = ELEMENT_STATUS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Assigned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_STATUS__IS_ASSIGNED = ELEMENT_STATUS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Dirty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_STATUS__IS_DIRTY = ELEMENT_STATUS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_STATUS__IS_ERROR = ELEMENT_STATUS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Ready</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_STATUS__IS_READY = ELEMENT_STATUS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Property Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_STATUS_FEATURE_COUNT = ELEMENT_STATUS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.AssociationStatusImpl <em>Association Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.AssociationStatusImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationStatusPackageImpl#getAssociationStatus()
	 * @generated
	 */
	int ASSOCIATION_STATUS = 0;

	/**
	 * The feature id for the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_STATUS__DEPTH = PROPERTY_STATUS__DEPTH;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_STATUS__SOURCES = PROPERTY_STATUS__SOURCES;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_STATUS__TARGETS = PROPERTY_STATUS__TARGETS;

	/**
	 * The feature id for the '<em><b>Is Assignable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_STATUS__IS_ASSIGNABLE = PROPERTY_STATUS__IS_ASSIGNABLE;

	/**
	 * The feature id for the '<em><b>Is Assigned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_STATUS__IS_ASSIGNED = PROPERTY_STATUS__IS_ASSIGNED;

	/**
	 * The feature id for the '<em><b>Is Dirty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_STATUS__IS_DIRTY = PROPERTY_STATUS__IS_DIRTY;

	/**
	 * The feature id for the '<em><b>Is Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_STATUS__IS_ERROR = PROPERTY_STATUS__IS_ERROR;

	/**
	 * The feature id for the '<em><b>Is Ready</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_STATUS__IS_READY = PROPERTY_STATUS__IS_READY;

	/**
	 * The feature id for the '<em><b>Forward EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_STATUS__FORWARD_EREFERENCE = PROPERTY_STATUS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From Class Statuses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_STATUS__FROM_CLASS_STATUSES = PROPERTY_STATUS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_STATUS__IS_INPUT = PROPERTY_STATUS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_STATUS__IS_OUTPUT = PROPERTY_STATUS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owning Transformation Status</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_STATUS__OWNING_TRANSFORMATION_STATUS = PROPERTY_STATUS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>To Class Statuses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_STATUS__TO_CLASS_STATUSES = PROPERTY_STATUS_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Association Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_STATUS_FEATURE_COUNT = PROPERTY_STATUS_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.AttributeStatusImpl <em>Attribute Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.AttributeStatusImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationStatusPackageImpl#getAttributeStatus()
	 * @generated
	 */
	int ATTRIBUTE_STATUS = 1;

	/**
	 * The feature id for the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_STATUS__DEPTH = PROPERTY_STATUS__DEPTH;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_STATUS__SOURCES = PROPERTY_STATUS__SOURCES;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_STATUS__TARGETS = PROPERTY_STATUS__TARGETS;

	/**
	 * The feature id for the '<em><b>Is Assignable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_STATUS__IS_ASSIGNABLE = PROPERTY_STATUS__IS_ASSIGNABLE;

	/**
	 * The feature id for the '<em><b>Is Assigned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_STATUS__IS_ASSIGNED = PROPERTY_STATUS__IS_ASSIGNED;

	/**
	 * The feature id for the '<em><b>Is Dirty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_STATUS__IS_DIRTY = PROPERTY_STATUS__IS_DIRTY;

	/**
	 * The feature id for the '<em><b>Is Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_STATUS__IS_ERROR = PROPERTY_STATUS__IS_ERROR;

	/**
	 * The feature id for the '<em><b>Is Ready</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_STATUS__IS_READY = PROPERTY_STATUS__IS_READY;

	/**
	 * The feature id for the '<em><b>EFeature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_STATUS__EFEATURE = PROPERTY_STATUS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_STATUS__OBJECT = PROPERTY_STATUS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owning Class Status</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_STATUS__OWNING_CLASS_STATUS = PROPERTY_STATUS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Attribute Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_STATUS_FEATURE_COUNT = PROPERTY_STATUS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.ClassStatusImpl <em>Class Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.ClassStatusImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationStatusPackageImpl#getClassStatus()
	 * @generated
	 */
	int CLASS_STATUS = 2;

	/**
	 * The feature id for the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_STATUS__DEPTH = ELEMENT_STATUS__DEPTH;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_STATUS__SOURCES = ELEMENT_STATUS__SOURCES;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_STATUS__TARGETS = ELEMENT_STATUS__TARGETS;

	/**
	 * The feature id for the '<em><b>Association Statuses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_STATUS__ASSOCIATION_STATUSES = ELEMENT_STATUS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>EObject</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_STATUS__EOBJECT = ELEMENT_STATUS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_STATUS__IS_INPUT = ELEMENT_STATUS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_STATUS__IS_OUTPUT = ELEMENT_STATUS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Attribute Statuses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_STATUS__OWNED_ATTRIBUTE_STATUSES = ELEMENT_STATUS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Owning Transformation Status</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_STATUS__OWNING_TRANSFORMATION_STATUS = ELEMENT_STATUS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_STATUS__TYPE = ELEMENT_STATUS_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Class Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_STATUS_FEATURE_COUNT = ELEMENT_STATUS_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.MappingStatusImpl <em>Mapping Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.MappingStatusImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationStatusPackageImpl#getMappingStatus()
	 * @generated
	 */
	int MAPPING_STATUS = 5;

	/**
	 * The feature id for the '<em><b>Bound Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATUS__BOUND_VALUES = EVALUATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATUS__DEPTH = EVALUATION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATUS__INPUTS = EVALUATION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Blocked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATUS__IS_BLOCKED = EVALUATION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Dirty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATUS__IS_DIRTY = EVALUATION_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATUS__OUTPUTS = EVALUATION_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Owning Transformation Status</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATUS__OWNING_TRANSFORMATION_STATUS = EVALUATION_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Referred Mapping Call</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATUS__REFERRED_MAPPING_CALL = EVALUATION_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Mapping Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATUS_FEATURE_COUNT = EVALUATION_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.TransformationStatusImpl <em>Transformation Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.TransformationStatusImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationStatusPackageImpl#getTransformationStatus()
	 * @generated
	 */
	int TRANSFORMATION_STATUS = 7;

	/**
	 * The feature id for the '<em><b>Owned Association Statuses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_STATUS__OWNED_ASSOCIATION_STATUSES = EVALUATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Class Statuses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_STATUS__OWNED_CLASS_STATUSES = EVALUATION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Mapping Statuses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_STATUS__OWNED_MAPPING_STATUSES = EVALUATION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Transformation Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_STATUS_FEATURE_COUNT = EVALUATION_ELEMENT_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus <em>Association Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association Status</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus
	 * @generated
	 */
	EClass getAssociationStatus();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#getForwardEReference <em>Forward EReference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Forward EReference</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#getForwardEReference()
	 * @see #getAssociationStatus()
	 * @generated
	 */
	EReference getAssociationStatus_ForwardEReference();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#getFromClassStatuses <em>From Class Statuses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>From Class Statuses</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#getFromClassStatuses()
	 * @see #getAssociationStatus()
	 * @generated
	 */
	EReference getAssociationStatus_FromClassStatuses();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#isIsInput <em>Is Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Input</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#isIsInput()
	 * @see #getAssociationStatus()
	 * @generated
	 */
	EAttribute getAssociationStatus_IsInput();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#isIsOutput <em>Is Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Output</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#isIsOutput()
	 * @see #getAssociationStatus()
	 * @generated
	 */
	EAttribute getAssociationStatus_IsOutput();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#getOwningTransformationStatus <em>Owning Transformation Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Transformation Status</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#getOwningTransformationStatus()
	 * @see #getAssociationStatus()
	 * @generated
	 */
	EReference getAssociationStatus_OwningTransformationStatus();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#getToClassStatuses <em>To Class Statuses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>To Class Statuses</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus#getToClassStatuses()
	 * @see #getAssociationStatus()
	 * @generated
	 */
	EReference getAssociationStatus_ToClassStatuses();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus <em>Attribute Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Status</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus
	 * @generated
	 */
	EClass getAttributeStatus();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus#getEFeature <em>EFeature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EFeature</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus#getEFeature()
	 * @see #getAttributeStatus()
	 * @generated
	 */
	EReference getAttributeStatus_EFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus#getObject()
	 * @see #getAttributeStatus()
	 * @generated
	 */
	EAttribute getAttributeStatus_Object();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus#getOwningClassStatus <em>Owning Class Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Class Status</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus#getOwningClassStatus()
	 * @see #getAttributeStatus()
	 * @generated
	 */
	EReference getAttributeStatus_OwningClassStatus();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus <em>Class Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Status</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus
	 * @generated
	 */
	EClass getClassStatus();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus#getAssociationStatuses <em>Association Statuses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Association Statuses</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus#getAssociationStatuses()
	 * @see #getClassStatus()
	 * @generated
	 */
	EReference getClassStatus_AssociationStatuses();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus#getEObject <em>EObject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EObject</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus#getEObject()
	 * @see #getClassStatus()
	 * @generated
	 */
	EReference getClassStatus_EObject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus#isIsInput <em>Is Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Input</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus#isIsInput()
	 * @see #getClassStatus()
	 * @generated
	 */
	EAttribute getClassStatus_IsInput();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus#isIsOutput <em>Is Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Output</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus#isIsOutput()
	 * @see #getClassStatus()
	 * @generated
	 */
	EAttribute getClassStatus_IsOutput();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus#getOwnedAttributeStatuses <em>Owned Attribute Statuses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Attribute Statuses</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus#getOwnedAttributeStatuses()
	 * @see #getClassStatus()
	 * @generated
	 */
	EReference getClassStatus_OwnedAttributeStatuses();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus#getOwningTransformationStatus <em>Owning Transformation Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Transformation Status</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus#getOwningTransformationStatus()
	 * @see #getClassStatus()
	 * @generated
	 */
	EReference getClassStatus_OwningTransformationStatus();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus#getType()
	 * @see #getClassStatus()
	 * @generated
	 */
	EReference getClassStatus_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus <em>Element Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Status</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus
	 * @generated
	 */
	EClass getElementStatus();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus#getDepth <em>Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus#getDepth()
	 * @see #getElementStatus()
	 * @generated
	 */
	EAttribute getElementStatus_Depth();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus#getSources <em>Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sources</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus#getSources()
	 * @see #getElementStatus()
	 * @generated
	 */
	EReference getElementStatus_Sources();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Targets</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus#getTargets()
	 * @see #getElementStatus()
	 * @generated
	 */
	EReference getElementStatus_Targets();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationElement <em>Evaluation Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluation Element</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationElement
	 * @generated
	 */
	EClass getEvaluationElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus <em>Mapping Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Status</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus
	 * @generated
	 */
	EClass getMappingStatus();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getBoundValues <em>Bound Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Bound Values</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getBoundValues()
	 * @see #getMappingStatus()
	 * @generated
	 */
	EAttribute getMappingStatus_BoundValues();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getDepth <em>Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getDepth()
	 * @see #getMappingStatus()
	 * @generated
	 */
	EAttribute getMappingStatus_Depth();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getInputs()
	 * @see #getMappingStatus()
	 * @generated
	 */
	EReference getMappingStatus_Inputs();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#isIsBlocked <em>Is Blocked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Blocked</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#isIsBlocked()
	 * @see #getMappingStatus()
	 * @generated
	 */
	EAttribute getMappingStatus_IsBlocked();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#isIsDirty <em>Is Dirty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Dirty</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#isIsDirty()
	 * @see #getMappingStatus()
	 * @generated
	 */
	EAttribute getMappingStatus_IsDirty();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getOutputs()
	 * @see #getMappingStatus()
	 * @generated
	 */
	EReference getMappingStatus_Outputs();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getOwningTransformationStatus <em>Owning Transformation Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Transformation Status</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getOwningTransformationStatus()
	 * @see #getMappingStatus()
	 * @generated
	 */
	EReference getMappingStatus_OwningTransformationStatus();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getReferredMappingCall <em>Referred Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Mapping Call</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus#getReferredMappingCall()
	 * @see #getMappingStatus()
	 * @generated
	 */
	EReference getMappingStatus_ReferredMappingCall();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus <em>Property Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Status</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus
	 * @generated
	 */
	EClass getPropertyStatus();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsAssignable <em>Is Assignable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Assignable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsAssignable()
	 * @see #getPropertyStatus()
	 * @generated
	 */
	EAttribute getPropertyStatus_IsAssignable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsAssigned <em>Is Assigned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Assigned</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsAssigned()
	 * @see #getPropertyStatus()
	 * @generated
	 */
	EAttribute getPropertyStatus_IsAssigned();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsDirty <em>Is Dirty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Dirty</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsDirty()
	 * @see #getPropertyStatus()
	 * @generated
	 */
	EAttribute getPropertyStatus_IsDirty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsError <em>Is Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Error</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsError()
	 * @see #getPropertyStatus()
	 * @generated
	 */
	EAttribute getPropertyStatus_IsError();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsReady <em>Is Ready</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Ready</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsReady()
	 * @see #getPropertyStatus()
	 * @generated
	 */
	EAttribute getPropertyStatus_IsReady();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus <em>Transformation Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation Status</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus
	 * @generated
	 */
	EClass getTransformationStatus();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus#getOwnedAssociationStatuses <em>Owned Association Statuses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Association Statuses</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus#getOwnedAssociationStatuses()
	 * @see #getTransformationStatus()
	 * @generated
	 */
	EReference getTransformationStatus_OwnedAssociationStatuses();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus#getOwnedClassStatuses <em>Owned Class Statuses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Class Statuses</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus#getOwnedClassStatuses()
	 * @see #getTransformationStatus()
	 * @generated
	 */
	EReference getTransformationStatus_OwnedClassStatuses();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus#getOwnedMappingStatuses <em>Owned Mapping Statuses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Mapping Statuses</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus#getOwnedMappingStatuses()
	 * @see #getTransformationStatus()
	 * @generated
	 */
	EReference getTransformationStatus_OwnedMappingStatuses();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EvaluationStatusFactory getEvaluationStatusFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.AssociationStatusImpl <em>Association Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.AssociationStatusImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationStatusPackageImpl#getAssociationStatus()
		 * @generated
		 */
		EClass ASSOCIATION_STATUS = eINSTANCE.getAssociationStatus();

		/**
		 * The meta object literal for the '<em><b>Forward EReference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_STATUS__FORWARD_EREFERENCE = eINSTANCE.getAssociationStatus_ForwardEReference();

		/**
		 * The meta object literal for the '<em><b>From Class Statuses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_STATUS__FROM_CLASS_STATUSES = eINSTANCE.getAssociationStatus_FromClassStatuses();

		/**
		 * The meta object literal for the '<em><b>Is Input</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSOCIATION_STATUS__IS_INPUT = eINSTANCE.getAssociationStatus_IsInput();

		/**
		 * The meta object literal for the '<em><b>Is Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSOCIATION_STATUS__IS_OUTPUT = eINSTANCE.getAssociationStatus_IsOutput();

		/**
		 * The meta object literal for the '<em><b>Owning Transformation Status</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_STATUS__OWNING_TRANSFORMATION_STATUS = eINSTANCE.getAssociationStatus_OwningTransformationStatus();

		/**
		 * The meta object literal for the '<em><b>To Class Statuses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_STATUS__TO_CLASS_STATUSES = eINSTANCE.getAssociationStatus_ToClassStatuses();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.AttributeStatusImpl <em>Attribute Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.AttributeStatusImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationStatusPackageImpl#getAttributeStatus()
		 * @generated
		 */
		EClass ATTRIBUTE_STATUS = eINSTANCE.getAttributeStatus();

		/**
		 * The meta object literal for the '<em><b>EFeature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_STATUS__EFEATURE = eINSTANCE.getAttributeStatus_EFeature();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_STATUS__OBJECT = eINSTANCE.getAttributeStatus_Object();

		/**
		 * The meta object literal for the '<em><b>Owning Class Status</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_STATUS__OWNING_CLASS_STATUS = eINSTANCE.getAttributeStatus_OwningClassStatus();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.ClassStatusImpl <em>Class Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.ClassStatusImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationStatusPackageImpl#getClassStatus()
		 * @generated
		 */
		EClass CLASS_STATUS = eINSTANCE.getClassStatus();

		/**
		 * The meta object literal for the '<em><b>Association Statuses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_STATUS__ASSOCIATION_STATUSES = eINSTANCE.getClassStatus_AssociationStatuses();

		/**
		 * The meta object literal for the '<em><b>EObject</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_STATUS__EOBJECT = eINSTANCE.getClassStatus_EObject();

		/**
		 * The meta object literal for the '<em><b>Is Input</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_STATUS__IS_INPUT = eINSTANCE.getClassStatus_IsInput();

		/**
		 * The meta object literal for the '<em><b>Is Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_STATUS__IS_OUTPUT = eINSTANCE.getClassStatus_IsOutput();

		/**
		 * The meta object literal for the '<em><b>Owned Attribute Statuses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_STATUS__OWNED_ATTRIBUTE_STATUSES = eINSTANCE.getClassStatus_OwnedAttributeStatuses();

		/**
		 * The meta object literal for the '<em><b>Owning Transformation Status</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_STATUS__OWNING_TRANSFORMATION_STATUS = eINSTANCE.getClassStatus_OwningTransformationStatus();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_STATUS__TYPE = eINSTANCE.getClassStatus_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.ElementStatusImpl <em>Element Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.ElementStatusImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationStatusPackageImpl#getElementStatus()
		 * @generated
		 */
		EClass ELEMENT_STATUS = eINSTANCE.getElementStatus();

		/**
		 * The meta object literal for the '<em><b>Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_STATUS__DEPTH = eINSTANCE.getElementStatus_Depth();

		/**
		 * The meta object literal for the '<em><b>Sources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_STATUS__SOURCES = eINSTANCE.getElementStatus_Sources();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_STATUS__TARGETS = eINSTANCE.getElementStatus_Targets();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationElementImpl <em>Evaluation Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationElementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationStatusPackageImpl#getEvaluationElement()
		 * @generated
		 */
		EClass EVALUATION_ELEMENT = eINSTANCE.getEvaluationElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.MappingStatusImpl <em>Mapping Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.MappingStatusImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationStatusPackageImpl#getMappingStatus()
		 * @generated
		 */
		EClass MAPPING_STATUS = eINSTANCE.getMappingStatus();

		/**
		 * The meta object literal for the '<em><b>Bound Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_STATUS__BOUND_VALUES = eINSTANCE.getMappingStatus_BoundValues();

		/**
		 * The meta object literal for the '<em><b>Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_STATUS__DEPTH = eINSTANCE.getMappingStatus_Depth();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_STATUS__INPUTS = eINSTANCE.getMappingStatus_Inputs();

		/**
		 * The meta object literal for the '<em><b>Is Blocked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_STATUS__IS_BLOCKED = eINSTANCE.getMappingStatus_IsBlocked();

		/**
		 * The meta object literal for the '<em><b>Is Dirty</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_STATUS__IS_DIRTY = eINSTANCE.getMappingStatus_IsDirty();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_STATUS__OUTPUTS = eINSTANCE.getMappingStatus_Outputs();

		/**
		 * The meta object literal for the '<em><b>Owning Transformation Status</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_STATUS__OWNING_TRANSFORMATION_STATUS = eINSTANCE.getMappingStatus_OwningTransformationStatus();

		/**
		 * The meta object literal for the '<em><b>Referred Mapping Call</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_STATUS__REFERRED_MAPPING_CALL = eINSTANCE.getMappingStatus_ReferredMappingCall();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.PropertyStatusImpl <em>Property Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.PropertyStatusImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationStatusPackageImpl#getPropertyStatus()
		 * @generated
		 */
		EClass PROPERTY_STATUS = eINSTANCE.getPropertyStatus();

		/**
		 * The meta object literal for the '<em><b>Is Assignable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_STATUS__IS_ASSIGNABLE = eINSTANCE.getPropertyStatus_IsAssignable();

		/**
		 * The meta object literal for the '<em><b>Is Assigned</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_STATUS__IS_ASSIGNED = eINSTANCE.getPropertyStatus_IsAssigned();

		/**
		 * The meta object literal for the '<em><b>Is Dirty</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_STATUS__IS_DIRTY = eINSTANCE.getPropertyStatus_IsDirty();

		/**
		 * The meta object literal for the '<em><b>Is Error</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_STATUS__IS_ERROR = eINSTANCE.getPropertyStatus_IsError();

		/**
		 * The meta object literal for the '<em><b>Is Ready</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_STATUS__IS_READY = eINSTANCE.getPropertyStatus_IsReady();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.TransformationStatusImpl <em>Transformation Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.TransformationStatusImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.EvaluationStatusPackageImpl#getTransformationStatus()
		 * @generated
		 */
		EClass TRANSFORMATION_STATUS = eINSTANCE.getTransformationStatus();

		/**
		 * The meta object literal for the '<em><b>Owned Association Statuses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_STATUS__OWNED_ASSOCIATION_STATUSES = eINSTANCE.getTransformationStatus_OwnedAssociationStatuses();

		/**
		 * The meta object literal for the '<em><b>Owned Class Statuses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_STATUS__OWNED_CLASS_STATUSES = eINSTANCE.getTransformationStatus_OwnedClassStatuses();

		/**
		 * The meta object literal for the '<em><b>Owned Mapping Statuses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_STATUS__OWNED_MAPPING_STATUSES = eINSTANCE.getTransformationStatus_OwnedMappingStatuses();

	}

} //EvaluationStatusPackage
