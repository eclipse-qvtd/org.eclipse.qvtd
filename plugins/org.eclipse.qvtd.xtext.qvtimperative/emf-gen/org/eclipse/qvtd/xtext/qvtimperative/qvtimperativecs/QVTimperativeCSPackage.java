/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QVTcoreBaseCSPackage;

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
 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.QVTimperativeCSFactory
 * @model kind="package"
 * @generated
 */
public interface QVTimperativeCSPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qvtimperativecs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/0.9/QVTimperativeCST";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtics";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTimperativeCSPackage eINSTANCE = org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.QVTimperativeCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.MappingCSImpl <em>Mapping CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.MappingCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getMappingCS()
	 * @generated
	 */
	int MAPPING_CS = 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__LOGICAL_PARENT = QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__PIVOT = QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__OWNED_ANNOTATION = QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__ORIGINAL_XMI_ID = QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__CSI = QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__NAME = QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__NAME;

	/**
	 * The feature id for the '<em><b>Domains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__DOMAINS = QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__DOMAINS;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__IN = QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__IN;

	/**
	 * The feature id for the '<em><b>Middle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__MIDDLE = QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__MIDDLE;

	/**
	 * The feature id for the '<em><b>Mapping Calls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__MAPPING_CALLS = QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mapping CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS_FEATURE_COUNT = QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.MappingCallBindingCSImpl <em>Mapping Call Binding CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.MappingCallBindingCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getMappingCallBindingCS()
	 * @generated
	 */
	int MAPPING_CALL_BINDING_CS = 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__LOGICAL_PARENT = EssentialOCLCSPackage.EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__PIVOT = EssentialOCLCSPackage.EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__OWNED_ANNOTATION = EssentialOCLCSPackage.EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__ORIGINAL_XMI_ID = EssentialOCLCSPackage.EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__CSI = EssentialOCLCSPackage.EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__PARENT = EssentialOCLCSPackage.EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Mapping Call</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__MAPPING_CALL = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__VALUE = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Loop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__IS_LOOP = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mapping Call Binding CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS_FEATURE_COUNT = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.MappingCallCSImpl <em>Mapping Call CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.MappingCallCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getMappingCallCS()
	 * @generated
	 */
	int MAPPING_CALL_CS = 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_CS__LOGICAL_PARENT = BaseCSPackage.MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_CS__PIVOT = BaseCSPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_CS__OWNED_ANNOTATION = BaseCSPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_CS__ORIGINAL_XMI_ID = BaseCSPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_CS__CSI = BaseCSPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Referred Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_CS__REFERRED_MAPPING = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_CS__BINDINGS = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping Call CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_CS_FEATURE_COUNT = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.TopLevelCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getTopLevelCS()
	 * @generated
	 */
	int TOP_LEVEL_CS = 3;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__LOGICAL_PARENT = BaseCSPackage.ROOT_PACKAGE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__PIVOT = BaseCSPackage.ROOT_PACKAGE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_ANNOTATION = BaseCSPackage.ROOT_PACKAGE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__ORIGINAL_XMI_ID = BaseCSPackage.ROOT_PACKAGE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__CSI = BaseCSPackage.ROOT_PACKAGE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Owned Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_NESTED_PACKAGE = BaseCSPackage.ROOT_PACKAGE_CS__OWNED_NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Owned Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_IMPORT = BaseCSPackage.ROOT_PACKAGE_CS__OWNED_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Library</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_LIBRARY = BaseCSPackage.ROOT_PACKAGE_CS__OWNED_LIBRARY;

	/**
	 * The feature id for the '<em><b>Transformations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__TRANSFORMATIONS = BaseCSPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Queries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__QUERIES = BaseCSPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__MAPPINGS = BaseCSPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Top Level CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS_FEATURE_COUNT = BaseCSPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 3;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCS <em>Mapping CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCS
	 * @generated
	 */
	EClass getMappingCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCS#getMappingCalls <em>Mapping Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping Calls</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCS#getMappingCalls()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_MappingCalls();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS <em>Mapping Call Binding CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Call Binding CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS
	 * @generated
	 */
	EClass getMappingCallBindingCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS#getMappingCall <em>Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapping Call</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS#getMappingCall()
	 * @see #getMappingCallBindingCS()
	 * @generated
	 */
	EReference getMappingCallBindingCS_MappingCall();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS#getReferredVariable <em>Referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Variable</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS#getReferredVariable()
	 * @see #getMappingCallBindingCS()
	 * @generated
	 */
	EReference getMappingCallBindingCS_ReferredVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS#getValue()
	 * @see #getMappingCallBindingCS()
	 * @generated
	 */
	EReference getMappingCallBindingCS_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS#isIsLoop <em>Is Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Loop</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS#isIsLoop()
	 * @see #getMappingCallBindingCS()
	 * @generated
	 */
	EAttribute getMappingCallBindingCS_IsLoop();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallCS <em>Mapping Call CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Call CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallCS
	 * @generated
	 */
	EClass getMappingCallCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallCS#getReferredMapping <em>Referred Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Mapping</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallCS#getReferredMapping()
	 * @see #getMappingCallCS()
	 * @generated
	 */
	EReference getMappingCallCS_ReferredMapping();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallCS#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bindings</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallCS#getBindings()
	 * @see #getMappingCallCS()
	 * @generated
	 */
	EReference getMappingCallCS_Bindings();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.TopLevelCS <em>Top Level CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Level CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.TopLevelCS
	 * @generated
	 */
	EClass getTopLevelCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.TopLevelCS#getTransformations <em>Transformations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transformations</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.TopLevelCS#getTransformations()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_Transformations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.TopLevelCS#getQueries <em>Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Queries</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.TopLevelCS#getQueries()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_Queries();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.TopLevelCS#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.TopLevelCS#getMappings()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_Mappings();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTimperativeCSFactory getQVTimperativeCSFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.MappingCSImpl <em>Mapping CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.MappingCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getMappingCS()
		 * @generated
		 */
		EClass MAPPING_CS = eINSTANCE.getMappingCS();

		/**
		 * The meta object literal for the '<em><b>Mapping Calls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__MAPPING_CALLS = eINSTANCE.getMappingCS_MappingCalls();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.MappingCallBindingCSImpl <em>Mapping Call Binding CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.MappingCallBindingCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getMappingCallBindingCS()
		 * @generated
		 */
		EClass MAPPING_CALL_BINDING_CS = eINSTANCE.getMappingCallBindingCS();

		/**
		 * The meta object literal for the '<em><b>Mapping Call</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CALL_BINDING_CS__MAPPING_CALL = eINSTANCE.getMappingCallBindingCS_MappingCall();

		/**
		 * The meta object literal for the '<em><b>Referred Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE = eINSTANCE.getMappingCallBindingCS_ReferredVariable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CALL_BINDING_CS__VALUE = eINSTANCE.getMappingCallBindingCS_Value();

		/**
		 * The meta object literal for the '<em><b>Is Loop</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_CALL_BINDING_CS__IS_LOOP = eINSTANCE.getMappingCallBindingCS_IsLoop();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.MappingCallCSImpl <em>Mapping Call CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.MappingCallCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getMappingCallCS()
		 * @generated
		 */
		EClass MAPPING_CALL_CS = eINSTANCE.getMappingCallCS();

		/**
		 * The meta object literal for the '<em><b>Referred Mapping</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CALL_CS__REFERRED_MAPPING = eINSTANCE.getMappingCallCS_ReferredMapping();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CALL_CS__BINDINGS = eINSTANCE.getMappingCallCS_Bindings();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.TopLevelCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getTopLevelCS()
		 * @generated
		 */
		EClass TOP_LEVEL_CS = eINSTANCE.getTopLevelCS();

		/**
		 * The meta object literal for the '<em><b>Transformations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__TRANSFORMATIONS = eINSTANCE.getTopLevelCS_Transformations();

		/**
		 * The meta object literal for the '<em><b>Queries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__QUERIES = eINSTANCE.getTopLevelCS_Queries();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__MAPPINGS = eINSTANCE.getTopLevelCS_Mappings();

	}

} //QVTimperativeCSTPackage
