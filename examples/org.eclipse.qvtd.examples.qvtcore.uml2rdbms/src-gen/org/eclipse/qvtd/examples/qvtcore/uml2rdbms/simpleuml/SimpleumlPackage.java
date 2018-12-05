/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.SimpleumlFactory
 * @model kind="package"
 * @generated
 */
public interface SimpleumlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "simpleuml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvtd/examples/qvtcore/UML2RDBMS/1.0/simpleUML";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "simpleuml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimpleumlPackage eINSTANCE = org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.SimpleumlPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.UMLModelElementImpl <em>UML Model Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.UMLModelElementImpl
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.SimpleumlPackageImpl#getUMLModelElement()
	 * @generated
	 */
	int UML_MODEL_ELEMENT = 7;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL_ELEMENT__KIND = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL_ELEMENT__NAME = 1;

	/**
	 * The number of structural features of the '<em>UML Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>UML Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.AttributeImpl
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.SimpleumlPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__KIND = UML_MODEL_ELEMENT__KIND;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = UML_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__OWNER = UML_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__TYPE = UML_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = UML_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = UML_MODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.PackageElementImpl <em>Package Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.PackageElementImpl
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.SimpleumlPackageImpl#getPackageElement()
	 * @generated
	 */
	int PACKAGE_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_ELEMENT__KIND = UML_MODEL_ELEMENT__KIND;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_ELEMENT__NAME = UML_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_ELEMENT__NAMESPACE = UML_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Package Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_ELEMENT_FEATURE_COUNT = UML_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Package Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_ELEMENT_OPERATION_COUNT = UML_MODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.AssociationImpl <em>Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.AssociationImpl
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.SimpleumlPackageImpl#getAssociation()
	 * @generated
	 */
	int ASSOCIATION = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__KIND = PACKAGE_ELEMENT__KIND;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__NAME = PACKAGE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__NAMESPACE = PACKAGE_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__DESTINATION = PACKAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__SOURCE = PACKAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FEATURE_COUNT = PACKAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_OPERATION_COUNT = PACKAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.ClassifierImpl <em>Classifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.ClassifierImpl
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.SimpleumlPackageImpl#getClassifier()
	 * @generated
	 */
	int CLASSIFIER = 3;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__KIND = PACKAGE_ELEMENT__KIND;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__NAME = PACKAGE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__NAMESPACE = PACKAGE_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Type Opposite</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__TYPE_OPPOSITE = PACKAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_FEATURE_COUNT = PACKAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_OPERATION_COUNT = PACKAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.ClassImpl
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.SimpleumlPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 2;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__KIND = CLASSIFIER__KIND;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAMESPACE = CLASSIFIER__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Type Opposite</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__TYPE_OPPOSITE = CLASSIFIER__TYPE_OPPOSITE;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ATTRIBUTES = CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Forward</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__FORWARD = CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__GENERAL = CLASSIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>General Opposite</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__GENERAL_OPPOSITE = CLASSIFIER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Reverse</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__REVERSE = CLASSIFIER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = CLASSIFIER_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = CLASSIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.PackageImpl <em>Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.PackageImpl
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.SimpleumlPackageImpl#getPackage()
	 * @generated
	 */
	int PACKAGE = 4;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__KIND = PACKAGE_ELEMENT__KIND;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NAME = PACKAGE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NAMESPACE = PACKAGE_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__ELEMENTS = PACKAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FEATURE_COUNT = PACKAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_OPERATION_COUNT = PACKAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.PrimitiveDataTypeImpl <em>Primitive Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.PrimitiveDataTypeImpl
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.SimpleumlPackageImpl#getPrimitiveDataType()
	 * @generated
	 */
	int PRIMITIVE_DATA_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DATA_TYPE__KIND = CLASSIFIER__KIND;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DATA_TYPE__NAME = CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DATA_TYPE__NAMESPACE = CLASSIFIER__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Type Opposite</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DATA_TYPE__TYPE_OPPOSITE = CLASSIFIER__TYPE_OPPOSITE;

	/**
	 * The number of structural features of the '<em>Primitive Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DATA_TYPE_FEATURE_COUNT = CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Primitive Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DATA_TYPE_OPERATION_COUNT = CLASSIFIER_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Attribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Attribute#getOwner()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Owner();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Attribute#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Attribute#getType()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Association
	 * @generated
	 */
	EClass getAssociation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Association#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Association#getDestination()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_Destination();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Association#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Association#getSource()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_Source();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class#getAttributes()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Attributes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class#getForward <em>Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Forward</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class#getForward()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Forward();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class#getGeneral <em>General</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>General</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class#getGeneral()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_General();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class#getGeneralOpposite <em>General Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>General Opposite</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class#getGeneralOpposite()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_GeneralOpposite();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class#getReverse <em>Reverse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Reverse</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class#getReverse()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Reverse();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Classifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Classifier
	 * @generated
	 */
	EClass getClassifier();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Classifier#getTypeOpposite <em>Type Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Type Opposite</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Classifier#getTypeOpposite()
	 * @see #getClassifier()
	 * @generated
	 */
	EReference getClassifier_TypeOpposite();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Package
	 * @generated
	 */
	EClass getPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Package#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Package#getElements()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.PackageElement <em>Package Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Element</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.PackageElement
	 * @generated
	 */
	EClass getPackageElement();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.PackageElement#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Namespace</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.PackageElement#getNamespace()
	 * @see #getPackageElement()
	 * @generated
	 */
	EReference getPackageElement_Namespace();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.PrimitiveDataType <em>Primitive Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Data Type</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.PrimitiveDataType
	 * @generated
	 */
	EClass getPrimitiveDataType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.UMLModelElement <em>UML Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Model Element</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.UMLModelElement
	 * @generated
	 */
	EClass getUMLModelElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.UMLModelElement#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.UMLModelElement#getKind()
	 * @see #getUMLModelElement()
	 * @generated
	 */
	EAttribute getUMLModelElement_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.UMLModelElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.UMLModelElement#getName()
	 * @see #getUMLModelElement()
	 * @generated
	 */
	EAttribute getUMLModelElement_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SimpleumlFactory getSimpleumlFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.AttributeImpl
		 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.SimpleumlPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__OWNER = eINSTANCE.getAttribute_Owner();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.AssociationImpl <em>Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.AssociationImpl
		 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.SimpleumlPackageImpl#getAssociation()
		 * @generated
		 */
		EClass ASSOCIATION = eINSTANCE.getAssociation();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__DESTINATION = eINSTANCE.getAssociation_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__SOURCE = eINSTANCE.getAssociation_Source();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.ClassImpl
		 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.SimpleumlPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ATTRIBUTES = eINSTANCE.getClass_Attributes();

		/**
		 * The meta object literal for the '<em><b>Forward</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__FORWARD = eINSTANCE.getClass_Forward();

		/**
		 * The meta object literal for the '<em><b>General</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__GENERAL = eINSTANCE.getClass_General();

		/**
		 * The meta object literal for the '<em><b>General Opposite</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__GENERAL_OPPOSITE = eINSTANCE.getClass_GeneralOpposite();

		/**
		 * The meta object literal for the '<em><b>Reverse</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__REVERSE = eINSTANCE.getClass_Reverse();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.ClassifierImpl <em>Classifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.ClassifierImpl
		 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.SimpleumlPackageImpl#getClassifier()
		 * @generated
		 */
		EClass CLASSIFIER = eINSTANCE.getClassifier();

		/**
		 * The meta object literal for the '<em><b>Type Opposite</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER__TYPE_OPPOSITE = eINSTANCE.getClassifier_TypeOpposite();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.PackageImpl <em>Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.PackageImpl
		 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.SimpleumlPackageImpl#getPackage()
		 * @generated
		 */
		EClass PACKAGE = eINSTANCE.getPackage();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__ELEMENTS = eINSTANCE.getPackage_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.PackageElementImpl <em>Package Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.PackageElementImpl
		 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.SimpleumlPackageImpl#getPackageElement()
		 * @generated
		 */
		EClass PACKAGE_ELEMENT = eINSTANCE.getPackageElement();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_ELEMENT__NAMESPACE = eINSTANCE.getPackageElement_Namespace();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.PrimitiveDataTypeImpl <em>Primitive Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.PrimitiveDataTypeImpl
		 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.SimpleumlPackageImpl#getPrimitiveDataType()
		 * @generated
		 */
		EClass PRIMITIVE_DATA_TYPE = eINSTANCE.getPrimitiveDataType();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.UMLModelElementImpl <em>UML Model Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.UMLModelElementImpl
		 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.SimpleumlPackageImpl#getUMLModelElement()
		 * @generated
		 */
		EClass UML_MODEL_ELEMENT = eINSTANCE.getUMLModelElement();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UML_MODEL_ELEMENT__KIND = eINSTANCE.getUMLModelElement_Kind();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UML_MODEL_ELEMENT__NAME = eINSTANCE.getUMLModelElement_Name();

	}

} //SimpleumlPackage
