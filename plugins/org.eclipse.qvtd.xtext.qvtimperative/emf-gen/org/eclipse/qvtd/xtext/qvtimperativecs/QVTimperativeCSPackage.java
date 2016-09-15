/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperativecs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage;

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
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSFactory
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
	String eNS_URI = "http://www.eclipse.org/qvt/2015/QVTimperativeCS";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtics";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	String eCONTENT_TYPE = "org.eclipse.qvtd.xtext.qvtimperative";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTimperativeCSPackage eINSTANCE = org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.StatementCSImpl <em>Statement CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.StatementCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getStatementCS()
	 * @generated
	 */
	int STATEMENT_CS = 17;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__CSI = BaseCSPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__PARENT = BaseCSPackage.MODEL_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__PIVOT = BaseCSPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__ORIGINAL_XMI_ID = BaseCSPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS__OWNED_ANNOTATIONS = BaseCSPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Statement CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_CS_FEATURE_COUNT = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCSImpl <em>Mapping CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getMappingCS()
	 * @generated
	 */
	int MAPPING_CS = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCallBindingCSImpl <em>Mapping Call Binding CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCallBindingCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getMappingCallBindingCS()
	 * @generated
	 */
	int MAPPING_CALL_BINDING_CS = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingStatementCSImpl <em>Mapping Statement CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingStatementCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getMappingStatementCS()
	 * @generated
	 */
	int MAPPING_STATEMENT_CS = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCallCSImpl <em>Mapping Call CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCallCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getMappingCallCS()
	 * @generated
	 */
	int MAPPING_CALL_CS = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingLoopCSImpl <em>Mapping Loop CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingLoopCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getMappingLoopCS()
	 * @generated
	 */
	int MAPPING_LOOP_CS = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.TopLevelCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getTopLevelCS()
	 * @generated
	 */
	int TOP_LEVEL_CS = 18;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT_CS__CSI = STATEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT_CS__PARENT = STATEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT_CS__PIVOT = STATEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT_CS__ORIGINAL_XMI_ID = STATEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT_CS__OWNED_ANNOTATIONS = STATEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Mapping Statement CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.AddStatementCSImpl <em>Add Statement CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.AddStatementCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getAddStatementCS()
	 * @generated
	 */
	int ADD_STATEMENT_CS = 0;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT_CS__CSI = MAPPING_STATEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT_CS__PARENT = MAPPING_STATEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT_CS__PIVOT = MAPPING_STATEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT_CS__ORIGINAL_XMI_ID = MAPPING_STATEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT_CS__OWNED_ANNOTATIONS = MAPPING_STATEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT_CS__OWNED_EXPRESSION = MAPPING_STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT_CS__TARGET_VARIABLE = MAPPING_STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Add Statement CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT_CS_FEATURE_COUNT = MAPPING_STATEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.CheckStatementCSImpl <em>Check Statement CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.CheckStatementCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getCheckStatementCS()
	 * @generated
	 */
	int CHECK_STATEMENT_CS = 1;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT_CS__CSI = STATEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT_CS__PARENT = STATEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT_CS__PIVOT = STATEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT_CS__ORIGINAL_XMI_ID = STATEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT_CS__OWNED_ANNOTATIONS = STATEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT_CS__OWNED_CONDITION = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Check Statement CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.DirectionCSImpl <em>Direction CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.DirectionCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getDirectionCS()
	 * @generated
	 */
	int DIRECTION_CS = 2;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__CSI = BaseCSPackage.NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__PARENT = BaseCSPackage.NAMED_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__PIVOT = BaseCSPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__ORIGINAL_XMI_ID = BaseCSPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__OWNED_ANNOTATIONS = BaseCSPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__NAME = BaseCSPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__IMPORTS = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__USES = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Direction CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS_FEATURE_COUNT = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.DomainCSImpl <em>Domain CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.DomainCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getDomainCS()
	 * @generated
	 */
	int DOMAIN_CS = 3;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__CSI = BaseCSPackage.NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__PARENT = BaseCSPackage.NAMED_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__PIVOT = BaseCSPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__ORIGINAL_XMI_ID = BaseCSPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__OWNED_ANNOTATIONS = BaseCSPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__NAME = BaseCSPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Is Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__IS_CHECK = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Enforce</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__IS_ENFORCE = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__DIRECTION = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Checked Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__CHECKED_PROPERTIES = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Guard Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__OWNED_GUARD_VARIABLES = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Domain CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS_FEATURE_COUNT = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.GuardVariableCSImpl <em>Guard Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.GuardVariableCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getGuardVariableCS()
	 * @generated
	 */
	int GUARD_VARIABLE_CS = 4;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE_CS__CSI = BaseCSPackage.TYPED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE_CS__PARENT = BaseCSPackage.TYPED_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE_CS__PIVOT = BaseCSPackage.TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE_CS__ORIGINAL_XMI_ID = BaseCSPackage.TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE_CS__OWNED_ANNOTATIONS = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE_CS__NAME = BaseCSPackage.TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Is Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE_CS__IS_OPTIONAL = BaseCSPackage.TYPED_ELEMENT_CS__IS_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE_CS__OWNED_TYPE = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE_CS__QUALIFIERS = BaseCSPackage.TYPED_ELEMENT_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Referred Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE_CS__REFERRED_TYPED_MODEL = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Guard Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE_CS_FEATURE_COUNT = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.InoutVariableCSImpl <em>Inout Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.InoutVariableCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getInoutVariableCS()
	 * @generated
	 */
	int INOUT_VARIABLE_CS = 5;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUT_VARIABLE_CS__CSI = BaseCSPackage.TYPED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUT_VARIABLE_CS__PARENT = BaseCSPackage.TYPED_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUT_VARIABLE_CS__PIVOT = BaseCSPackage.TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUT_VARIABLE_CS__ORIGINAL_XMI_ID = BaseCSPackage.TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUT_VARIABLE_CS__OWNED_ANNOTATIONS = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUT_VARIABLE_CS__NAME = BaseCSPackage.TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Is Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUT_VARIABLE_CS__IS_OPTIONAL = BaseCSPackage.TYPED_ELEMENT_CS__IS_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUT_VARIABLE_CS__OWNED_TYPE = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUT_VARIABLE_CS__QUALIFIERS = BaseCSPackage.TYPED_ELEMENT_CS__QUALIFIERS;

	/**
	 * The number of structural features of the '<em>Inout Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUT_VARIABLE_CS_FEATURE_COUNT = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__CSI = BaseCSPackage.NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__PARENT = BaseCSPackage.NAMED_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__PIVOT = BaseCSPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__ORIGINAL_XMI_ID = BaseCSPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__OWNED_ANNOTATIONS = BaseCSPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__NAME = BaseCSPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Domains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__OWNED_DOMAINS = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned In Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__OWNED_IN_PATH_NAME = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__OWNED_STATEMENTS = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Inout Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__OWNED_INOUT_VARIABLES = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mapping CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS_FEATURE_COUNT = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 4;

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
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__PIVOT = EssentialOCLCSPackage.EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__ORIGINAL_XMI_ID = EssentialOCLCSPackage.EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__OWNED_ANNOTATIONS = EssentialOCLCSPackage.EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__HAS_ERROR = EssentialOCLCSPackage.EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__LOCAL_LEFT = EssentialOCLCSPackage.EXP_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__LOCAL_LEFTMOST_DESCENDANT = EssentialOCLCSPackage.EXP_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__LOCAL_PARENT = EssentialOCLCSPackage.EXP_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__LOCAL_RIGHT = EssentialOCLCSPackage.EXP_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__LOCAL_RIGHTMOST_DESCENDANT = EssentialOCLCSPackage.EXP_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__PRECEDENCE = EssentialOCLCSPackage.EXP_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Is Polled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__IS_POLLED = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__OWNED_VALUE = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owning Mapping Call</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__OWNING_MAPPING_CALL = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Referred Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mapping Call Binding CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_CS_FEATURE_COUNT = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_CS__CSI = MAPPING_STATEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_CS__PARENT = MAPPING_STATEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_CS__PIVOT = MAPPING_STATEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_CS__ORIGINAL_XMI_ID = MAPPING_STATEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_CS__OWNED_ANNOTATIONS = MAPPING_STATEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Is Infinite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_CS__IS_INFINITE = MAPPING_STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_CS__OWNED_BINDINGS = MAPPING_STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_CS__OWNED_PATH_NAME = MAPPING_STATEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Referred Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_CS__REFERRED_MAPPING = MAPPING_STATEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mapping Call CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_CS_FEATURE_COUNT = MAPPING_STATEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP_CS__CSI = MAPPING_STATEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP_CS__PARENT = MAPPING_STATEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP_CS__PIVOT = MAPPING_STATEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP_CS__ORIGINAL_XMI_ID = MAPPING_STATEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP_CS__OWNED_ANNOTATIONS = MAPPING_STATEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Iterator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP_CS__OWNED_ITERATOR = MAPPING_STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned In Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP_CS__OWNED_IN_EXPRESSION = MAPPING_STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Mapping Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP_CS__OWNED_MAPPING_STATEMENTS = MAPPING_STATEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mapping Loop CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP_CS_FEATURE_COUNT = MAPPING_STATEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.ParamDeclarationCSImpl <em>Param Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.ParamDeclarationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getParamDeclarationCS()
	 * @generated
	 */
	int PARAM_DECLARATION_CS = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.PredicateVariableCSImpl <em>Predicate Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.PredicateVariableCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getPredicateVariableCS()
	 * @generated
	 */
	int PREDICATE_VARIABLE_CS = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.QueryCSImpl <em>Query CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QueryCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getQueryCS()
	 * @generated
	 */
	int QUERY_CS = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.NewStatementCSImpl <em>New Statement CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.NewStatementCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getNewStatementCS()
	 * @generated
	 */
	int NEW_STATEMENT_CS = 11;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT_CS__CSI = BaseCSPackage.TYPED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT_CS__PARENT = BaseCSPackage.TYPED_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT_CS__PIVOT = BaseCSPackage.TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT_CS__ORIGINAL_XMI_ID = BaseCSPackage.TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT_CS__OWNED_ANNOTATIONS = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT_CS__NAME = BaseCSPackage.TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Is Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT_CS__IS_OPTIONAL = BaseCSPackage.TYPED_ELEMENT_CS__IS_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT_CS__OWNED_TYPE = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT_CS__QUALIFIERS = BaseCSPackage.TYPED_ELEMENT_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Owned Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT_CS__OWNED_INIT = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT_CS__REFERRED_TYPED_MODEL = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>New Statement CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT_CS_FEATURE_COUNT = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.OutVariableCSImpl <em>Out Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.OutVariableCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getOutVariableCS()
	 * @generated
	 */
	int OUT_VARIABLE_CS = 12;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_VARIABLE_CS__CSI = BaseCSPackage.TYPED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_VARIABLE_CS__PARENT = BaseCSPackage.TYPED_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_VARIABLE_CS__PIVOT = BaseCSPackage.TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_VARIABLE_CS__ORIGINAL_XMI_ID = BaseCSPackage.TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_VARIABLE_CS__OWNED_ANNOTATIONS = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_VARIABLE_CS__NAME = BaseCSPackage.TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Is Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_VARIABLE_CS__IS_OPTIONAL = BaseCSPackage.TYPED_ELEMENT_CS__IS_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_VARIABLE_CS__OWNED_TYPE = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_VARIABLE_CS__QUALIFIERS = BaseCSPackage.TYPED_ELEMENT_CS__QUALIFIERS;

	/**
	 * The number of structural features of the '<em>Out Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_VARIABLE_CS_FEATURE_COUNT = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__CSI = BaseCSPackage.TYPED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__PARENT = BaseCSPackage.TYPED_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__PIVOT = BaseCSPackage.TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__ORIGINAL_XMI_ID = BaseCSPackage.TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__OWNED_ANNOTATIONS = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__NAME = BaseCSPackage.TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Is Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__IS_OPTIONAL = BaseCSPackage.TYPED_ELEMENT_CS__IS_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__OWNED_TYPE = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__QUALIFIERS = BaseCSPackage.TYPED_ELEMENT_CS__QUALIFIERS;

	/**
	 * The number of structural features of the '<em>Param Declaration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS_FEATURE_COUNT = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_VARIABLE_CS__CSI = BaseCSPackage.TYPED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_VARIABLE_CS__PARENT = BaseCSPackage.TYPED_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_VARIABLE_CS__PIVOT = BaseCSPackage.TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_VARIABLE_CS__ORIGINAL_XMI_ID = BaseCSPackage.TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_VARIABLE_CS__OWNED_ANNOTATIONS = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_VARIABLE_CS__NAME = BaseCSPackage.TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Is Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_VARIABLE_CS__IS_OPTIONAL = BaseCSPackage.TYPED_ELEMENT_CS__IS_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_VARIABLE_CS__OWNED_TYPE = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_VARIABLE_CS__QUALIFIERS = BaseCSPackage.TYPED_ELEMENT_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Owned Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_VARIABLE_CS__OWNED_INIT = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_VARIABLE_CS__IS_CHECKED = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Predicate Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_VARIABLE_CS_FEATURE_COUNT = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__CSI = BaseCSPackage.TYPED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__PARENT = BaseCSPackage.TYPED_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__PIVOT = BaseCSPackage.TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__ORIGINAL_XMI_ID = BaseCSPackage.TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__OWNED_ANNOTATIONS = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__NAME = BaseCSPackage.TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Is Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__IS_OPTIONAL = BaseCSPackage.TYPED_ELEMENT_CS__IS_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__OWNED_TYPE = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__QUALIFIERS = BaseCSPackage.TYPED_ELEMENT_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__OWNED_PATH_NAME = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__TRANSFORMATION = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__OWNED_PARAMETERS = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__OWNED_EXPRESSION = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__IS_TRANSIENT = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Query CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS_FEATURE_COUNT = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.SetStatementCSImpl <em>Set Statement CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.SetStatementCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getSetStatementCS()
	 * @generated
	 */
	int SET_STATEMENT_CS = 16;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT_CS__CSI = STATEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT_CS__PARENT = STATEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT_CS__PIVOT = STATEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT_CS__ORIGINAL_XMI_ID = STATEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT_CS__OWNED_ANNOTATIONS = STATEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT_CS__REFERRED_PROPERTY = STATEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT_CS__REFERRED_VARIABLE = STATEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT_CS__OWNED_INIT = STATEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Emit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT_CS__IS_EMIT = STATEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Set Statement CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__CSI = BaseCSPackage.ROOT_PACKAGE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__PARENT = BaseCSPackage.ROOT_PACKAGE_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__PIVOT = BaseCSPackage.ROOT_PACKAGE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__ORIGINAL_XMI_ID = BaseCSPackage.ROOT_PACKAGE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_ANNOTATIONS = BaseCSPackage.ROOT_PACKAGE_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_PACKAGES = BaseCSPackage.ROOT_PACKAGE_CS__OWNED_PACKAGES;

	/**
	 * The feature id for the '<em><b>Owned Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_IMPORTS = BaseCSPackage.ROOT_PACKAGE_CS__OWNED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Owned Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_MAPPINGS = BaseCSPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Queries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_QUERIES = BaseCSPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Transformations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_TRANSFORMATIONS = BaseCSPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Top Level CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS_FEATURE_COUNT = BaseCSPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.TransformationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getTransformationCS()
	 * @generated
	 */
	int TRANSFORMATION_CS = 19;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__CSI = QVTbaseCSPackage.ABSTRACT_TRANSFORMATION_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__PARENT = QVTbaseCSPackage.ABSTRACT_TRANSFORMATION_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__PIVOT = QVTbaseCSPackage.ABSTRACT_TRANSFORMATION_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__ORIGINAL_XMI_ID = QVTbaseCSPackage.ABSTRACT_TRANSFORMATION_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_ANNOTATIONS = QVTbaseCSPackage.ABSTRACT_TRANSFORMATION_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__NAME = QVTbaseCSPackage.ABSTRACT_TRANSFORMATION_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_SIGNATURE = QVTbaseCSPackage.ABSTRACT_TRANSFORMATION_CS__OWNED_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__INSTANCE_CLASS_NAME = QVTbaseCSPackage.ABSTRACT_TRANSFORMATION_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_CONSTRAINTS = QVTbaseCSPackage.ABSTRACT_TRANSFORMATION_CS__OWNED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Owning Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNING_PACKAGE = QVTbaseCSPackage.ABSTRACT_TRANSFORMATION_CS__OWNING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_PATH_NAME = QVTbaseCSPackage.ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__PACKAGE = QVTbaseCSPackage.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Directions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_DIRECTIONS = QVTbaseCSPackage.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Transformation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS_FEATURE_COUNT = QVTbaseCSPackage.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.AddStatementCS <em>Add Statement CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Statement CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.AddStatementCS
	 * @generated
	 */
	EClass getAddStatementCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.AddStatementCS#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.AddStatementCS#getOwnedExpression()
	 * @see #getAddStatementCS()
	 * @generated
	 */
	EReference getAddStatementCS_OwnedExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.AddStatementCS#getTargetVariable <em>Target Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Variable</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.AddStatementCS#getTargetVariable()
	 * @see #getAddStatementCS()
	 * @generated
	 */
	EReference getAddStatementCS_TargetVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.CheckStatementCS <em>Check Statement CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Check Statement CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.CheckStatementCS
	 * @generated
	 */
	EClass getCheckStatementCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.CheckStatementCS#getOwnedCondition <em>Owned Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Condition</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.CheckStatementCS#getOwnedCondition()
	 * @see #getCheckStatementCS()
	 * @generated
	 */
	EReference getCheckStatementCS_OwnedCondition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS <em>Direction CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Direction CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS
	 * @generated
	 */
	EClass getDirectionCS();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imports</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS#getImports()
	 * @see #getDirectionCS()
	 * @generated
	 */
	EReference getDirectionCS_Imports();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Uses</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS#getUses()
	 * @see #getDirectionCS()
	 * @generated
	 */
	EReference getDirectionCS_Uses();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS <em>Domain CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS
	 * @generated
	 */
	EClass getDomainCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS#isIsCheck <em>Is Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Check</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS#isIsCheck()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_IsCheck();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS#isIsEnforce <em>Is Enforce</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Enforce</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS#isIsEnforce()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_IsEnforce();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Direction</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS#getDirection()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_Direction();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS#getCheckedProperties <em>Checked Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Checked Properties</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS#getCheckedProperties()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_CheckedProperties();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS#getOwnedGuardVariables <em>Owned Guard Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Guard Variables</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS#getOwnedGuardVariables()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_OwnedGuardVariables();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.GuardVariableCS <em>Guard Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard Variable CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.GuardVariableCS
	 * @generated
	 */
	EClass getGuardVariableCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.GuardVariableCS#getReferredTypedModel <em>Referred Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Typed Model</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.GuardVariableCS#getReferredTypedModel()
	 * @see #getGuardVariableCS()
	 * @generated
	 */
	EReference getGuardVariableCS_ReferredTypedModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.InoutVariableCS <em>Inout Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inout Variable CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.InoutVariableCS
	 * @generated
	 */
	EClass getInoutVariableCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS <em>Mapping CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS
	 * @generated
	 */
	EClass getMappingCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#getOwnedDomains <em>Owned Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Domains</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#getOwnedDomains()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_OwnedDomains();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#getOwnedInPathName <em>Owned In Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned In Path Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#getOwnedInPathName()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_OwnedInPathName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#getOwnedStatements <em>Owned Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Statements</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#getOwnedStatements()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_OwnedStatements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#getOwnedInoutVariables <em>Owned Inout Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Inout Variables</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#getOwnedInoutVariables()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_OwnedInoutVariables();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS <em>Mapping Call Binding CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Call Binding CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS
	 * @generated
	 */
	EClass getMappingCallBindingCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS#isIsPolled <em>Is Polled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Polled</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS#isIsPolled()
	 * @see #getMappingCallBindingCS()
	 * @generated
	 */
	EAttribute getMappingCallBindingCS_IsPolled();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS#getOwningMappingCall <em>Owning Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Mapping Call</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS#getOwningMappingCall()
	 * @see #getMappingCallBindingCS()
	 * @generated
	 */
	EReference getMappingCallBindingCS_OwningMappingCall();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS#getReferredVariable <em>Referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Variable</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS#getReferredVariable()
	 * @see #getMappingCallBindingCS()
	 * @generated
	 */
	EReference getMappingCallBindingCS_ReferredVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS#getOwnedValue <em>Owned Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Value</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS#getOwnedValue()
	 * @see #getMappingCallBindingCS()
	 * @generated
	 */
	EReference getMappingCallBindingCS_OwnedValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS <em>Mapping Call CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Call CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS
	 * @generated
	 */
	EClass getMappingCallCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS#isIsInfinite <em>Is Infinite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Infinite</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS#isIsInfinite()
	 * @see #getMappingCallCS()
	 * @generated
	 */
	EAttribute getMappingCallCS_IsInfinite();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS#getReferredMapping <em>Referred Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Mapping</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS#getReferredMapping()
	 * @see #getMappingCallCS()
	 * @generated
	 */
	EReference getMappingCallCS_ReferredMapping();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS#getOwnedBindings <em>Owned Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Bindings</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS#getOwnedBindings()
	 * @see #getMappingCallCS()
	 * @generated
	 */
	EReference getMappingCallCS_OwnedBindings();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS#getOwnedPathName <em>Owned Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Path Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS#getOwnedPathName()
	 * @see #getMappingCallCS()
	 * @generated
	 */
	EReference getMappingCallCS_OwnedPathName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS <em>Mapping Loop CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Loop CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS
	 * @generated
	 */
	EClass getMappingLoopCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS#getOwnedIterator <em>Owned Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Iterator</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS#getOwnedIterator()
	 * @see #getMappingLoopCS()
	 * @generated
	 */
	EReference getMappingLoopCS_OwnedIterator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS#getOwnedInExpression <em>Owned In Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned In Expression</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS#getOwnedInExpression()
	 * @see #getMappingLoopCS()
	 * @generated
	 */
	EReference getMappingLoopCS_OwnedInExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS#getOwnedMappingStatements <em>Owned Mapping Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Mapping Statements</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS#getOwnedMappingStatements()
	 * @see #getMappingLoopCS()
	 * @generated
	 */
	EReference getMappingLoopCS_OwnedMappingStatements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingStatementCS <em>Mapping Statement CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Statement CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingStatementCS
	 * @generated
	 */
	EClass getMappingStatementCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.ParamDeclarationCS <em>Param Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Param Declaration CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.ParamDeclarationCS
	 * @generated
	 */
	EClass getParamDeclarationCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.PredicateVariableCS <em>Predicate Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate Variable CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.PredicateVariableCS
	 * @generated
	 */
	EClass getPredicateVariableCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.PredicateVariableCS#getOwnedInit <em>Owned Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.PredicateVariableCS#getOwnedInit()
	 * @see #getPredicateVariableCS()
	 * @generated
	 */
	EReference getPredicateVariableCS_OwnedInit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtimperativecs.PredicateVariableCS#isIsChecked <em>Is Checked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Checked</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.PredicateVariableCS#isIsChecked()
	 * @see #getPredicateVariableCS()
	 * @generated
	 */
	EAttribute getPredicateVariableCS_IsChecked();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS <em>Query CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS
	 * @generated
	 */
	EClass getQueryCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS#getOwnedPathName <em>Owned Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Path Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS#getOwnedPathName()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_OwnedPathName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transformation</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS#getTransformation()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_Transformation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS#getOwnedParameters <em>Owned Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameters</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS#getOwnedParameters()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_OwnedParameters();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS#getOwnedExpression()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_OwnedExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS#isIsTransient <em>Is Transient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Transient</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS#isIsTransient()
	 * @see #getQueryCS()
	 * @generated
	 */
	EAttribute getQueryCS_IsTransient();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.NewStatementCS <em>New Statement CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Statement CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.NewStatementCS
	 * @generated
	 */
	EClass getNewStatementCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.NewStatementCS#getOwnedInit <em>Owned Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.NewStatementCS#getOwnedInit()
	 * @see #getNewStatementCS()
	 * @generated
	 */
	EReference getNewStatementCS_OwnedInit();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.NewStatementCS#getReferredTypedModel <em>Referred Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Typed Model</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.NewStatementCS#getReferredTypedModel()
	 * @see #getNewStatementCS()
	 * @generated
	 */
	EReference getNewStatementCS_ReferredTypedModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.OutVariableCS <em>Out Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Out Variable CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.OutVariableCS
	 * @generated
	 */
	EClass getOutVariableCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.SetStatementCS <em>Set Statement CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Statement CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.SetStatementCS
	 * @generated
	 */
	EClass getSetStatementCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.SetStatementCS#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.SetStatementCS#getReferredProperty()
	 * @see #getSetStatementCS()
	 * @generated
	 */
	EReference getSetStatementCS_ReferredProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.SetStatementCS#getReferredVariable <em>Referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Variable</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.SetStatementCS#getReferredVariable()
	 * @see #getSetStatementCS()
	 * @generated
	 */
	EReference getSetStatementCS_ReferredVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.SetStatementCS#getOwnedInit <em>Owned Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.SetStatementCS#getOwnedInit()
	 * @see #getSetStatementCS()
	 * @generated
	 */
	EReference getSetStatementCS_OwnedInit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtimperativecs.SetStatementCS#isIsEmit <em>Is Emit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Emit</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.SetStatementCS#isIsEmit()
	 * @see #getSetStatementCS()
	 * @generated
	 */
	EAttribute getSetStatementCS_IsEmit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.StatementCS <em>Statement CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.StatementCS
	 * @generated
	 */
	EClass getStatementCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS <em>Top Level CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Level CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS
	 * @generated
	 */
	EClass getTopLevelCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS#getOwnedMappings <em>Owned Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Mappings</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS#getOwnedMappings()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_OwnedMappings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS#getOwnedQueries <em>Owned Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Queries</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS#getOwnedQueries()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_OwnedQueries();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS#getOwnedTransformations <em>Owned Transformations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Transformations</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS#getOwnedTransformations()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_OwnedTransformations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS <em>Transformation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS
	 * @generated
	 */
	EClass getTransformationCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Package</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS#getPackage()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_Package();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS#getOwnedDirections <em>Owned Directions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Directions</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS#getOwnedDirections()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_OwnedDirections();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.AddStatementCSImpl <em>Add Statement CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.AddStatementCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getAddStatementCS()
		 * @generated
		 */
		EClass ADD_STATEMENT_CS = eINSTANCE.getAddStatementCS();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_STATEMENT_CS__OWNED_EXPRESSION = eINSTANCE.getAddStatementCS_OwnedExpression();

		/**
		 * The meta object literal for the '<em><b>Target Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_STATEMENT_CS__TARGET_VARIABLE = eINSTANCE.getAddStatementCS_TargetVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.CheckStatementCSImpl <em>Check Statement CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.CheckStatementCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getCheckStatementCS()
		 * @generated
		 */
		EClass CHECK_STATEMENT_CS = eINSTANCE.getCheckStatementCS();

		/**
		 * The meta object literal for the '<em><b>Owned Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECK_STATEMENT_CS__OWNED_CONDITION = eINSTANCE.getCheckStatementCS_OwnedCondition();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.DirectionCSImpl <em>Direction CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.DirectionCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getDirectionCS()
		 * @generated
		 */
		EClass DIRECTION_CS = eINSTANCE.getDirectionCS();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTION_CS__IMPORTS = eINSTANCE.getDirectionCS_Imports();

		/**
		 * The meta object literal for the '<em><b>Uses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTION_CS__USES = eINSTANCE.getDirectionCS_Uses();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.DomainCSImpl <em>Domain CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.DomainCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getDomainCS()
		 * @generated
		 */
		EClass DOMAIN_CS = eINSTANCE.getDomainCS();

		/**
		 * The meta object literal for the '<em><b>Is Check</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_CS__IS_CHECK = eINSTANCE.getDomainCS_IsCheck();

		/**
		 * The meta object literal for the '<em><b>Is Enforce</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_CS__IS_ENFORCE = eINSTANCE.getDomainCS_IsEnforce();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_CS__DIRECTION = eINSTANCE.getDomainCS_Direction();

		/**
		 * The meta object literal for the '<em><b>Checked Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_CS__CHECKED_PROPERTIES = eINSTANCE.getDomainCS_CheckedProperties();

		/**
		 * The meta object literal for the '<em><b>Owned Guard Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_CS__OWNED_GUARD_VARIABLES = eINSTANCE.getDomainCS_OwnedGuardVariables();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.GuardVariableCSImpl <em>Guard Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.GuardVariableCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getGuardVariableCS()
		 * @generated
		 */
		EClass GUARD_VARIABLE_CS = eINSTANCE.getGuardVariableCS();

		/**
		 * The meta object literal for the '<em><b>Referred Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD_VARIABLE_CS__REFERRED_TYPED_MODEL = eINSTANCE.getGuardVariableCS_ReferredTypedModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.InoutVariableCSImpl <em>Inout Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.InoutVariableCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getInoutVariableCS()
		 * @generated
		 */
		EClass INOUT_VARIABLE_CS = eINSTANCE.getInoutVariableCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCSImpl <em>Mapping CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getMappingCS()
		 * @generated
		 */
		EClass MAPPING_CS = eINSTANCE.getMappingCS();

		/**
		 * The meta object literal for the '<em><b>Owned Domains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__OWNED_DOMAINS = eINSTANCE.getMappingCS_OwnedDomains();

		/**
		 * The meta object literal for the '<em><b>Owned In Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__OWNED_IN_PATH_NAME = eINSTANCE.getMappingCS_OwnedInPathName();

		/**
		 * The meta object literal for the '<em><b>Owned Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__OWNED_STATEMENTS = eINSTANCE.getMappingCS_OwnedStatements();

		/**
		 * The meta object literal for the '<em><b>Owned Inout Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__OWNED_INOUT_VARIABLES = eINSTANCE.getMappingCS_OwnedInoutVariables();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCallBindingCSImpl <em>Mapping Call Binding CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCallBindingCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getMappingCallBindingCS()
		 * @generated
		 */
		EClass MAPPING_CALL_BINDING_CS = eINSTANCE.getMappingCallBindingCS();

		/**
		 * The meta object literal for the '<em><b>Is Polled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_CALL_BINDING_CS__IS_POLLED = eINSTANCE.getMappingCallBindingCS_IsPolled();

		/**
		 * The meta object literal for the '<em><b>Owning Mapping Call</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CALL_BINDING_CS__OWNING_MAPPING_CALL = eINSTANCE.getMappingCallBindingCS_OwningMappingCall();

		/**
		 * The meta object literal for the '<em><b>Referred Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE = eINSTANCE.getMappingCallBindingCS_ReferredVariable();

		/**
		 * The meta object literal for the '<em><b>Owned Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CALL_BINDING_CS__OWNED_VALUE = eINSTANCE.getMappingCallBindingCS_OwnedValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCallCSImpl <em>Mapping Call CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCallCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getMappingCallCS()
		 * @generated
		 */
		EClass MAPPING_CALL_CS = eINSTANCE.getMappingCallCS();

		/**
		 * The meta object literal for the '<em><b>Is Infinite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_CALL_CS__IS_INFINITE = eINSTANCE.getMappingCallCS_IsInfinite();

		/**
		 * The meta object literal for the '<em><b>Referred Mapping</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CALL_CS__REFERRED_MAPPING = eINSTANCE.getMappingCallCS_ReferredMapping();

		/**
		 * The meta object literal for the '<em><b>Owned Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CALL_CS__OWNED_BINDINGS = eINSTANCE.getMappingCallCS_OwnedBindings();

		/**
		 * The meta object literal for the '<em><b>Owned Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CALL_CS__OWNED_PATH_NAME = eINSTANCE.getMappingCallCS_OwnedPathName();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingLoopCSImpl <em>Mapping Loop CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingLoopCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getMappingLoopCS()
		 * @generated
		 */
		EClass MAPPING_LOOP_CS = eINSTANCE.getMappingLoopCS();

		/**
		 * The meta object literal for the '<em><b>Owned Iterator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_LOOP_CS__OWNED_ITERATOR = eINSTANCE.getMappingLoopCS_OwnedIterator();

		/**
		 * The meta object literal for the '<em><b>Owned In Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_LOOP_CS__OWNED_IN_EXPRESSION = eINSTANCE.getMappingLoopCS_OwnedInExpression();

		/**
		 * The meta object literal for the '<em><b>Owned Mapping Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_LOOP_CS__OWNED_MAPPING_STATEMENTS = eINSTANCE.getMappingLoopCS_OwnedMappingStatements();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingStatementCSImpl <em>Mapping Statement CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingStatementCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getMappingStatementCS()
		 * @generated
		 */
		EClass MAPPING_STATEMENT_CS = eINSTANCE.getMappingStatementCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.ParamDeclarationCSImpl <em>Param Declaration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.ParamDeclarationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getParamDeclarationCS()
		 * @generated
		 */
		EClass PARAM_DECLARATION_CS = eINSTANCE.getParamDeclarationCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.PredicateVariableCSImpl <em>Predicate Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.PredicateVariableCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getPredicateVariableCS()
		 * @generated
		 */
		EClass PREDICATE_VARIABLE_CS = eINSTANCE.getPredicateVariableCS();

		/**
		 * The meta object literal for the '<em><b>Owned Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE_VARIABLE_CS__OWNED_INIT = eINSTANCE.getPredicateVariableCS_OwnedInit();

		/**
		 * The meta object literal for the '<em><b>Is Checked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREDICATE_VARIABLE_CS__IS_CHECKED = eINSTANCE.getPredicateVariableCS_IsChecked();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.QueryCSImpl <em>Query CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QueryCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getQueryCS()
		 * @generated
		 */
		EClass QUERY_CS = eINSTANCE.getQueryCS();

		/**
		 * The meta object literal for the '<em><b>Owned Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__OWNED_PATH_NAME = eINSTANCE.getQueryCS_OwnedPathName();

		/**
		 * The meta object literal for the '<em><b>Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__TRANSFORMATION = eINSTANCE.getQueryCS_Transformation();

		/**
		 * The meta object literal for the '<em><b>Owned Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__OWNED_PARAMETERS = eINSTANCE.getQueryCS_OwnedParameters();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__OWNED_EXPRESSION = eINSTANCE.getQueryCS_OwnedExpression();

		/**
		 * The meta object literal for the '<em><b>Is Transient</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_CS__IS_TRANSIENT = eINSTANCE.getQueryCS_IsTransient();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.NewStatementCSImpl <em>New Statement CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.NewStatementCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getNewStatementCS()
		 * @generated
		 */
		EClass NEW_STATEMENT_CS = eINSTANCE.getNewStatementCS();

		/**
		 * The meta object literal for the '<em><b>Owned Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_STATEMENT_CS__OWNED_INIT = eINSTANCE.getNewStatementCS_OwnedInit();

		/**
		 * The meta object literal for the '<em><b>Referred Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_STATEMENT_CS__REFERRED_TYPED_MODEL = eINSTANCE.getNewStatementCS_ReferredTypedModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.OutVariableCSImpl <em>Out Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.OutVariableCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getOutVariableCS()
		 * @generated
		 */
		EClass OUT_VARIABLE_CS = eINSTANCE.getOutVariableCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.SetStatementCSImpl <em>Set Statement CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.SetStatementCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getSetStatementCS()
		 * @generated
		 */
		EClass SET_STATEMENT_CS = eINSTANCE.getSetStatementCS();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_STATEMENT_CS__REFERRED_PROPERTY = eINSTANCE.getSetStatementCS_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Referred Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_STATEMENT_CS__REFERRED_VARIABLE = eINSTANCE.getSetStatementCS_ReferredVariable();

		/**
		 * The meta object literal for the '<em><b>Owned Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_STATEMENT_CS__OWNED_INIT = eINSTANCE.getSetStatementCS_OwnedInit();

		/**
		 * The meta object literal for the '<em><b>Is Emit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_STATEMENT_CS__IS_EMIT = eINSTANCE.getSetStatementCS_IsEmit();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.StatementCSImpl <em>Statement CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.StatementCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getStatementCS()
		 * @generated
		 */
		EClass STATEMENT_CS = eINSTANCE.getStatementCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.TopLevelCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getTopLevelCS()
		 * @generated
		 */
		EClass TOP_LEVEL_CS = eINSTANCE.getTopLevelCS();

		/**
		 * The meta object literal for the '<em><b>Owned Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__OWNED_MAPPINGS = eINSTANCE.getTopLevelCS_OwnedMappings();

		/**
		 * The meta object literal for the '<em><b>Owned Queries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__OWNED_QUERIES = eINSTANCE.getTopLevelCS_OwnedQueries();

		/**
		 * The meta object literal for the '<em><b>Owned Transformations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__OWNED_TRANSFORMATIONS = eINSTANCE.getTopLevelCS_OwnedTransformations();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.TransformationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtimperativecs.impl.QVTimperativeCSPackageImpl#getTransformationCS()
		 * @generated
		 */
		EClass TRANSFORMATION_CS = eINSTANCE.getTransformationCS();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__PACKAGE = eINSTANCE.getTransformationCS_Package();

		/**
		 * The meta object literal for the '<em><b>Owned Directions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__OWNED_DIRECTIONS = eINSTANCE.getTransformationCS_OwnedDirections();

	}

} //QVTimperativeCSTPackage
