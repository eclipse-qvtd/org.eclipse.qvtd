/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.compiler.internal.qvtcconfig;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.QVTcConfigFactory
 * @model kind="package"
 * @generated
 */
public interface QVTcConfigPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qvtcconfig";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/examples/0.1/QVTcConfig";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtcconfig";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTcConfigPackage eINSTANCE = org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.QVTcConfigPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.ConfigurationImpl
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.QVTcConfigPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Input Direction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__INPUT_DIRECTION = 0;

	/**
	 * The feature id for the '<em><b>Output Direction</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__OUTPUT_DIRECTION = 1;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__MODE = 2;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__TRANSFORMATION = 3;

	/**
	 * The feature id for the '<em><b>Middle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__MIDDLE = 4;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.NamedElementImpl
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.QVTcConfigPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.DirectionImpl <em>Direction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.DirectionImpl
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.QVTcConfigPackageImpl#getDirection()
	 * @generated
	 */
	int DIRECTION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION__IMPORTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Direction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Direction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.ImportImpl
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.QVTcConfigPackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Metamodel File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__METAMODEL_FILE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Metamodel Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__METAMODEL_URI = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__PACKAGE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.TransformationImpl <em>Transformation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.TransformationImpl
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.QVTcConfigPackageImpl#getTransformation()
	 * @generated
	 */
	int TRANSFORMATION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__DIRECTION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__IMPORT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Mode <em>Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Mode
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.QVTcConfigPackageImpl#getMode()
	 * @generated
	 */
	int MODE = 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration#getInputDirection <em>Input Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input Direction</em>'.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration#getInputDirection()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_InputDirection();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration#getOutputDirection <em>Output Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Output Direction</em>'.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration#getOutputDirection()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_OutputDirection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration#getMode()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Mode();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Transformation</em>'.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration#getTransformation()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Transformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration#getMiddle <em>Middle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Middle</em>'.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration#getMiddle()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Middle();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Direction <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Direction</em>'.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Direction
	 * @generated
	 */
	EClass getDirection();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Direction#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imports</em>'.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Direction#getImports()
	 * @see #getDirection()
	 * @generated
	 */
	EReference getDirection_Imports();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Import#getMetamodelFile <em>Metamodel File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metamodel File</em>'.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Import#getMetamodelFile()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_MetamodelFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Import#getMetamodelUri <em>Metamodel Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metamodel Uri</em>'.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Import#getMetamodelUri()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_MetamodelUri();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Import#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Package</em>'.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Import#getPackage()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_Package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Transformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation</em>'.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Transformation
	 * @generated
	 */
	EClass getTransformation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Transformation#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Direction</em>'.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Transformation#getDirection()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_Direction();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Transformation#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import</em>'.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Transformation#getImport()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_Import();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Mode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Mode</em>'.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Mode
	 * @generated
	 */
	EEnum getMode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTcConfigFactory getQVTcConfigFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.ConfigurationImpl
		 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.QVTcConfigPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Input Direction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__INPUT_DIRECTION = eINSTANCE.getConfiguration_InputDirection();

		/**
		 * The meta object literal for the '<em><b>Output Direction</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__OUTPUT_DIRECTION = eINSTANCE.getConfiguration_OutputDirection();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__MODE = eINSTANCE.getConfiguration_Mode();

		/**
		 * The meta object literal for the '<em><b>Transformation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__TRANSFORMATION = eINSTANCE.getConfiguration_Transformation();

		/**
		 * The meta object literal for the '<em><b>Middle</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__MIDDLE = eINSTANCE.getConfiguration_Middle();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.DirectionImpl <em>Direction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.DirectionImpl
		 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.QVTcConfigPackageImpl#getDirection()
		 * @generated
		 */
		EClass DIRECTION = eINSTANCE.getDirection();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTION__IMPORTS = eINSTANCE.getDirection_Imports();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.NamedElementImpl
		 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.QVTcConfigPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.ImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.ImportImpl
		 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.QVTcConfigPackageImpl#getImport()
		 * @generated
		 */
		EClass IMPORT = eINSTANCE.getImport();

		/**
		 * The meta object literal for the '<em><b>Metamodel File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__METAMODEL_FILE = eINSTANCE.getImport_MetamodelFile();

		/**
		 * The meta object literal for the '<em><b>Metamodel Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__METAMODEL_URI = eINSTANCE.getImport_MetamodelUri();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__PACKAGE = eINSTANCE.getImport_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.TransformationImpl <em>Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.TransformationImpl
		 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.QVTcConfigPackageImpl#getTransformation()
		 * @generated
		 */
		EClass TRANSFORMATION = eINSTANCE.getTransformation();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__DIRECTION = eINSTANCE.getTransformation_Direction();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__IMPORT = eINSTANCE.getTransformation_Import();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Mode <em>Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Mode
		 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.QVTcConfigPackageImpl#getMode()
		 * @generated
		 */
		EEnum MODE = eINSTANCE.getMode();

	}

} //QVTcConfigPackage
