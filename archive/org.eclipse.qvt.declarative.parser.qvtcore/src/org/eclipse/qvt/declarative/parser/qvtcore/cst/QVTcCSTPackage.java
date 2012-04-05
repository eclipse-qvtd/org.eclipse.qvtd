/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: QVTcCSTPackage.java,v 1.5 2008/11/28 17:22:58 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore.cst;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.qvt.declarative.parser.qvt.cst.QVTCSTPackage;

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
 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTFactory
 * @model kind="package"
 * @generated
 */
public interface QVTcCSTPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cst";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/1.0/QVTCorecst";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtccst";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTcCSTPackage eINSTANCE = org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.AreaCSImpl <em>Area CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.AreaCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getAreaCS()
	 * @generated
	 */
	int AREA_CS = 0;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__START_OFFSET = QVTCSTPackage.IDENTIFIED_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__END_OFFSET = QVTCSTPackage.IDENTIFIED_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__START_TOKEN = QVTCSTPackage.IDENTIFIED_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__END_TOKEN = QVTCSTPackage.IDENTIFIED_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__AST = QVTCSTPackage.IDENTIFIED_CS__AST;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__IDENTIFIER = QVTCSTPackage.IDENTIFIED_CS__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Ast Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__AST_NODE = QVTCSTPackage.IDENTIFIED_CS__AST_NODE;

	/**
	 * The feature id for the '<em><b>Guard Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__GUARD_PATTERN = QVTCSTPackage.IDENTIFIED_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__BOTTOM_PATTERN = QVTCSTPackage.IDENTIFIED_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Area CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS_FEATURE_COUNT = QVTCSTPackage.IDENTIFIED_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.AssignmentCSImpl <em>Assignment CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.AssignmentCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getAssignmentCS()
	 * @generated
	 */
	int ASSIGNMENT_CS = 1;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__START_OFFSET = CSTPackage.OCL_EXPRESSION_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__END_OFFSET = CSTPackage.OCL_EXPRESSION_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__START_TOKEN = CSTPackage.OCL_EXPRESSION_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__END_TOKEN = CSTPackage.OCL_EXPRESSION_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__AST = CSTPackage.OCL_EXPRESSION_CS__AST;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__TARGET = CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initialiser</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__INITIALISER = CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__DEFAULT = CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assignment CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS_FEATURE_COUNT = CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.DirectionCSImpl <em>Direction CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.DirectionCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getDirectionCS()
	 * @generated
	 */
	int DIRECTION_CS = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.MappingCSImpl <em>Mapping CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.MappingCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getMappingCS()
	 * @generated
	 */
	int MAPPING_CS = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.PatternCSImpl <em>Pattern CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.PatternCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getPatternCS()
	 * @generated
	 */
	int PATTERN_CS = 9;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__CONSTRAINTS = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unrealized Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__UNREALIZED_VARIABLES = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Pattern CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.BottomPatternCSImpl <em>Bottom Pattern CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.BottomPatternCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getBottomPatternCS()
	 * @generated
	 */
	int BOTTOM_PATTERN_CS = 2;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__START_OFFSET = PATTERN_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__END_OFFSET = PATTERN_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__START_TOKEN = PATTERN_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__END_TOKEN = PATTERN_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__AST = PATTERN_CS__AST;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__CONSTRAINTS = PATTERN_CS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Unrealized Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__UNREALIZED_VARIABLES = PATTERN_CS__UNREALIZED_VARIABLES;

	/**
	 * The feature id for the '<em><b>Enforcement Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__ENFORCEMENT_OPERATIONS = PATTERN_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Realized Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__REALIZED_VARIABLES = PATTERN_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bottom Pattern CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS_FEATURE_COUNT = PATTERN_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__START_OFFSET = QVTCSTPackage.IDENTIFIED_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__END_OFFSET = QVTCSTPackage.IDENTIFIED_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__START_TOKEN = QVTCSTPackage.IDENTIFIED_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__END_TOKEN = QVTCSTPackage.IDENTIFIED_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__AST = QVTCSTPackage.IDENTIFIED_CS__AST;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__IDENTIFIER = QVTCSTPackage.IDENTIFIED_CS__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Ast Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__AST_NODE = QVTCSTPackage.IDENTIFIED_CS__AST_NODE;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__IMPORTS = QVTCSTPackage.IDENTIFIED_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__USES = QVTCSTPackage.IDENTIFIED_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Direction CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS_FEATURE_COUNT = QVTCSTPackage.IDENTIFIED_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.TopLevelCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getTopLevelCS()
	 * @generated
	 */
	int TOP_LEVEL_CS = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.TransformationCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getTransformationCS()
	 * @generated
	 */
	int TRANSFORMATION_CS = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.DomainCSImpl <em>Domain CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.DomainCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getDomainCS()
	 * @generated
	 */
	int DOMAIN_CS = 4;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__START_OFFSET = AREA_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__END_OFFSET = AREA_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__START_TOKEN = AREA_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__END_TOKEN = AREA_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__AST = AREA_CS__AST;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__IDENTIFIER = AREA_CS__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Ast Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__AST_NODE = AREA_CS__AST_NODE;

	/**
	 * The feature id for the '<em><b>Guard Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__GUARD_PATTERN = AREA_CS__GUARD_PATTERN;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__BOTTOM_PATTERN = AREA_CS__BOTTOM_PATTERN;

	/**
	 * The feature id for the '<em><b>Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__CHECK = AREA_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enforce</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__ENFORCE = AREA_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Domain CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS_FEATURE_COUNT = AREA_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.GuardPatternCSImpl <em>Guard Pattern CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.GuardPatternCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getGuardPatternCS()
	 * @generated
	 */
	int GUARD_PATTERN_CS = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.ParamDeclarationCSImpl <em>Param Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.ParamDeclarationCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getParamDeclarationCS()
	 * @generated
	 */
	int PARAM_DECLARATION_CS = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QueryCSImpl <em>Query CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QueryCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getQueryCS()
	 * @generated
	 */
	int QUERY_CS = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.RealizeableVariableCSImpl <em>Realizeable Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.RealizeableVariableCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getRealizeableVariableCS()
	 * @generated
	 */
	int REALIZEABLE_VARIABLE_CS = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.RealizedVariableCSImpl <em>Realized Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.RealizedVariableCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getRealizedVariableCS()
	 * @generated
	 */
	int REALIZED_VARIABLE_CS = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.UnrealizedVariableCSImpl <em>Unrealized Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.UnrealizedVariableCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getUnrealizedVariableCS()
	 * @generated
	 */
	int UNREALIZED_VARIABLE_CS = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.EnforcementOperationCSImpl <em>Enforcement Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.EnforcementOperationCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getEnforcementOperationCS()
	 * @generated
	 */
	int ENFORCEMENT_OPERATION_CS = 5;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Deletion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__DELETION = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operation Call</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__OPERATION_CALL = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Enforcement Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_CS__START_OFFSET = PATTERN_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_CS__END_OFFSET = PATTERN_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_CS__START_TOKEN = PATTERN_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_CS__END_TOKEN = PATTERN_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_CS__AST = PATTERN_CS__AST;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_CS__CONSTRAINTS = PATTERN_CS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Unrealized Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_CS__UNREALIZED_VARIABLES = PATTERN_CS__UNREALIZED_VARIABLES;

	/**
	 * The number of structural features of the '<em>Guard Pattern CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_CS_FEATURE_COUNT = PATTERN_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__START_OFFSET = QVTCSTPackage.IDENTIFIED_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__END_OFFSET = QVTCSTPackage.IDENTIFIED_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__START_TOKEN = QVTCSTPackage.IDENTIFIED_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__END_TOKEN = QVTCSTPackage.IDENTIFIED_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__AST = QVTCSTPackage.IDENTIFIED_CS__AST;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__IDENTIFIER = QVTCSTPackage.IDENTIFIED_CS__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Ast Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__AST_NODE = QVTCSTPackage.IDENTIFIED_CS__AST_NODE;

	/**
	 * The feature id for the '<em><b>Composed Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__COMPOSED_MAPPINGS = QVTCSTPackage.IDENTIFIED_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__DOMAINS = QVTCSTPackage.IDENTIFIED_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>In</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__IN = QVTCSTPackage.IDENTIFIED_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Middle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__MIDDLE = QVTCSTPackage.IDENTIFIED_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__REFINES = QVTCSTPackage.IDENTIFIED_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Mapping CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS_FEATURE_COUNT = QVTCSTPackage.IDENTIFIED_CS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__IDENTIFIER = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__TYPE = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Param Declaration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Input Param Declaration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__INPUT_PARAM_DECLARATION = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ocl Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__OCL_EXPRESSION = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__PATH_NAME = CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__TYPE = CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Query CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__START_OFFSET = QVTCSTPackage.IDENTIFIED_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__END_OFFSET = QVTCSTPackage.IDENTIFIED_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__START_TOKEN = QVTCSTPackage.IDENTIFIED_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__END_TOKEN = QVTCSTPackage.IDENTIFIED_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__AST = QVTCSTPackage.IDENTIFIED_CS__AST;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__IDENTIFIER = QVTCSTPackage.IDENTIFIED_CS__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Ast Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__AST_NODE = QVTCSTPackage.IDENTIFIED_CS__AST_NODE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__TYPE = QVTCSTPackage.IDENTIFIED_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Realizeable Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS_FEATURE_COUNT = QVTCSTPackage.IDENTIFIED_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__START_OFFSET = REALIZEABLE_VARIABLE_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__END_OFFSET = REALIZEABLE_VARIABLE_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__START_TOKEN = REALIZEABLE_VARIABLE_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__END_TOKEN = REALIZEABLE_VARIABLE_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__AST = REALIZEABLE_VARIABLE_CS__AST;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__IDENTIFIER = REALIZEABLE_VARIABLE_CS__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Ast Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__AST_NODE = REALIZEABLE_VARIABLE_CS__AST_NODE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__TYPE = REALIZEABLE_VARIABLE_CS__TYPE;

	/**
	 * The number of structural features of the '<em>Realized Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS_FEATURE_COUNT = REALIZEABLE_VARIABLE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Transformations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__TRANSFORMATIONS = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Queries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__QUERIES = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__MAPPINGS = CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Top Level CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Directions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__DIRECTIONS = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__PATH_NAME = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Transformation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__START_OFFSET = REALIZEABLE_VARIABLE_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__END_OFFSET = REALIZEABLE_VARIABLE_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__START_TOKEN = REALIZEABLE_VARIABLE_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__END_TOKEN = REALIZEABLE_VARIABLE_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__AST = REALIZEABLE_VARIABLE_CS__AST;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__IDENTIFIER = REALIZEABLE_VARIABLE_CS__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Ast Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__AST_NODE = REALIZEABLE_VARIABLE_CS__AST_NODE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__TYPE = REALIZEABLE_VARIABLE_CS__TYPE;

	/**
	 * The number of structural features of the '<em>Unrealized Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS_FEATURE_COUNT = REALIZEABLE_VARIABLE_CS_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.AreaCS <em>Area CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Area CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.AreaCS
	 * @generated
	 */
	EClass getAreaCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.AreaCS#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bottom Pattern</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.AreaCS#getBottomPattern()
	 * @see #getAreaCS()
	 * @generated
	 */
	EReference getAreaCS_BottomPattern();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.AreaCS#getGuardPattern <em>Guard Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard Pattern</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.AreaCS#getGuardPattern()
	 * @see #getAreaCS()
	 * @generated
	 */
	EReference getAreaCS_GuardPattern();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.AssignmentCS <em>Assignment CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.AssignmentCS
	 * @generated
	 */
	EClass getAssignmentCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.AssignmentCS#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.AssignmentCS#getTarget()
	 * @see #getAssignmentCS()
	 * @generated
	 */
	EReference getAssignmentCS_Target();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.AssignmentCS#getInitialiser <em>Initialiser</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initialiser</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.AssignmentCS#getInitialiser()
	 * @see #getAssignmentCS()
	 * @generated
	 */
	EReference getAssignmentCS_Initialiser();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.AssignmentCS#isDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.AssignmentCS#isDefault()
	 * @see #getAssignmentCS()
	 * @generated
	 */
	EAttribute getAssignmentCS_Default();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.BottomPatternCS <em>Bottom Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bottom Pattern CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.BottomPatternCS
	 * @generated
	 */
	EClass getBottomPatternCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.BottomPatternCS#getEnforcementOperations <em>Enforcement Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Enforcement Operations</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.BottomPatternCS#getEnforcementOperations()
	 * @see #getBottomPatternCS()
	 * @generated
	 */
	EReference getBottomPatternCS_EnforcementOperations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.BottomPatternCS#getRealizedVariables <em>Realized Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Realized Variables</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.BottomPatternCS#getRealizedVariables()
	 * @see #getBottomPatternCS()
	 * @generated
	 */
	EReference getBottomPatternCS_RealizedVariables();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.DirectionCS <em>Direction CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Direction CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.DirectionCS
	 * @generated
	 */
	EClass getDirectionCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.DirectionCS#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.DirectionCS#getImports()
	 * @see #getDirectionCS()
	 * @generated
	 */
	EReference getDirectionCS_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.DirectionCS#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Uses</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.DirectionCS#getUses()
	 * @see #getDirectionCS()
	 * @generated
	 */
	EReference getDirectionCS_Uses();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS <em>Mapping CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS
	 * @generated
	 */
	EClass getMappingCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS#getIn()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_In();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS#getMiddle <em>Middle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Middle</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS#getMiddle()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_Middle();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS#getRefines <em>Refines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Refines</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS#getRefines()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_Refines();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.ParamDeclarationCS <em>Param Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Param Declaration CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.ParamDeclarationCS
	 * @generated
	 */
	EClass getParamDeclarationCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.ParamDeclarationCS#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identifier</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.ParamDeclarationCS#getIdentifier()
	 * @see #getParamDeclarationCS()
	 * @generated
	 */
	EReference getParamDeclarationCS_Identifier();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.ParamDeclarationCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.ParamDeclarationCS#getType()
	 * @see #getParamDeclarationCS()
	 * @generated
	 */
	EReference getParamDeclarationCS_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS#getComposedMappings <em>Composed Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Composed Mappings</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS#getComposedMappings()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_ComposedMappings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS#getDomains <em>Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Domains</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS#getDomains()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_Domains();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.PatternCS <em>Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.PatternCS
	 * @generated
	 */
	EClass getPatternCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.PatternCS#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.PatternCS#getConstraints()
	 * @see #getPatternCS()
	 * @generated
	 */
	EReference getPatternCS_Constraints();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.PatternCS#getUnrealizedVariables <em>Unrealized Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unrealized Variables</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.PatternCS#getUnrealizedVariables()
	 * @see #getPatternCS()
	 * @generated
	 */
	EReference getPatternCS_UnrealizedVariables();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS <em>Query CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS
	 * @generated
	 */
	EClass getQueryCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS#getPathName()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_PathName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS#getInputParamDeclaration <em>Input Param Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Param Declaration</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS#getInputParamDeclaration()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_InputParamDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS#getOclExpression <em>Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ocl Expression</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS#getOclExpression()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_OclExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS#getType()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.RealizeableVariableCS <em>Realizeable Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Realizeable Variable CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.RealizeableVariableCS
	 * @generated
	 */
	EClass getRealizeableVariableCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.RealizeableVariableCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.RealizeableVariableCS#getType()
	 * @see #getRealizeableVariableCS()
	 * @generated
	 */
	EReference getRealizeableVariableCS_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.TopLevelCS <em>Top Level CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Level CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.TopLevelCS
	 * @generated
	 */
	EClass getTopLevelCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.TopLevelCS#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.TopLevelCS#getMappings()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_Mappings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.TopLevelCS#getQueries <em>Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Queries</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.TopLevelCS#getQueries()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_Queries();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.TopLevelCS#getTransformations <em>Transformations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transformations</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.TopLevelCS#getTransformations()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_Transformations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.TransformationCS <em>Transformation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.TransformationCS
	 * @generated
	 */
	EClass getTransformationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.TransformationCS#getDirections <em>Directions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Directions</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.TransformationCS#getDirections()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_Directions();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.TransformationCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.TransformationCS#getPathName()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_PathName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.UnrealizedVariableCS <em>Unrealized Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unrealized Variable CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.UnrealizedVariableCS
	 * @generated
	 */
	EClass getUnrealizedVariableCS();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTcCSTFactory getQVTcCSTFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.EnforcementOperationCS <em>Enforcement Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enforcement Operation CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.EnforcementOperationCS
	 * @generated
	 */
	EClass getEnforcementOperationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.EnforcementOperationCS#isDeletion <em>Deletion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deletion</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.EnforcementOperationCS#isDeletion()
	 * @see #getEnforcementOperationCS()
	 * @generated
	 */
	EAttribute getEnforcementOperationCS_Deletion();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.EnforcementOperationCS#getOperationCall <em>Operation Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operation Call</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.EnforcementOperationCS#getOperationCall()
	 * @see #getEnforcementOperationCS()
	 * @generated
	 */
	EReference getEnforcementOperationCS_OperationCall();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.DomainCS <em>Domain CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.DomainCS
	 * @generated
	 */
	EClass getDomainCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.DomainCS#isCheck <em>Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Check</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.DomainCS#isCheck()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_Check();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.DomainCS#isEnforce <em>Enforce</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enforce</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.DomainCS#isEnforce()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_Enforce();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.GuardPatternCS <em>Guard Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard Pattern CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.GuardPatternCS
	 * @generated
	 */
	EClass getGuardPatternCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.RealizedVariableCS <em>Realized Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Realized Variable CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.RealizedVariableCS
	 * @generated
	 */
	EClass getRealizedVariableCS();

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
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.AreaCSImpl <em>Area CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.AreaCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getAreaCS()
		 * @generated
		 */
		EClass AREA_CS = eINSTANCE.getAreaCS();

		/**
		 * The meta object literal for the '<em><b>Bottom Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA_CS__BOTTOM_PATTERN = eINSTANCE.getAreaCS_BottomPattern();

		/**
		 * The meta object literal for the '<em><b>Guard Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA_CS__GUARD_PATTERN = eINSTANCE.getAreaCS_GuardPattern();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.AssignmentCSImpl <em>Assignment CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.AssignmentCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getAssignmentCS()
		 * @generated
		 */
		EClass ASSIGNMENT_CS = eINSTANCE.getAssignmentCS();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT_CS__TARGET = eINSTANCE.getAssignmentCS_Target();

		/**
		 * The meta object literal for the '<em><b>Initialiser</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT_CS__INITIALISER = eINSTANCE.getAssignmentCS_Initialiser();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGNMENT_CS__DEFAULT = eINSTANCE.getAssignmentCS_Default();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.BottomPatternCSImpl <em>Bottom Pattern CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.BottomPatternCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getBottomPatternCS()
		 * @generated
		 */
		EClass BOTTOM_PATTERN_CS = eINSTANCE.getBottomPatternCS();

		/**
		 * The meta object literal for the '<em><b>Enforcement Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTOM_PATTERN_CS__ENFORCEMENT_OPERATIONS = eINSTANCE.getBottomPatternCS_EnforcementOperations();

		/**
		 * The meta object literal for the '<em><b>Realized Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTOM_PATTERN_CS__REALIZED_VARIABLES = eINSTANCE.getBottomPatternCS_RealizedVariables();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.DirectionCSImpl <em>Direction CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.DirectionCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getDirectionCS()
		 * @generated
		 */
		EClass DIRECTION_CS = eINSTANCE.getDirectionCS();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTION_CS__IMPORTS = eINSTANCE.getDirectionCS_Imports();

		/**
		 * The meta object literal for the '<em><b>Uses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTION_CS__USES = eINSTANCE.getDirectionCS_Uses();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.MappingCSImpl <em>Mapping CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.MappingCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getMappingCS()
		 * @generated
		 */
		EClass MAPPING_CS = eINSTANCE.getMappingCS();

		/**
		 * The meta object literal for the '<em><b>In</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__IN = eINSTANCE.getMappingCS_In();

		/**
		 * The meta object literal for the '<em><b>Middle</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__MIDDLE = eINSTANCE.getMappingCS_Middle();

		/**
		 * The meta object literal for the '<em><b>Refines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__REFINES = eINSTANCE.getMappingCS_Refines();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.ParamDeclarationCSImpl <em>Param Declaration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.ParamDeclarationCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getParamDeclarationCS()
		 * @generated
		 */
		EClass PARAM_DECLARATION_CS = eINSTANCE.getParamDeclarationCS();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAM_DECLARATION_CS__IDENTIFIER = eINSTANCE.getParamDeclarationCS_Identifier();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAM_DECLARATION_CS__TYPE = eINSTANCE.getParamDeclarationCS_Type();

		/**
		 * The meta object literal for the '<em><b>Composed Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__COMPOSED_MAPPINGS = eINSTANCE.getMappingCS_ComposedMappings();

		/**
		 * The meta object literal for the '<em><b>Domains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__DOMAINS = eINSTANCE.getMappingCS_Domains();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.PatternCSImpl <em>Pattern CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.PatternCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getPatternCS()
		 * @generated
		 */
		EClass PATTERN_CS = eINSTANCE.getPatternCS();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_CS__CONSTRAINTS = eINSTANCE.getPatternCS_Constraints();

		/**
		 * The meta object literal for the '<em><b>Unrealized Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_CS__UNREALIZED_VARIABLES = eINSTANCE.getPatternCS_UnrealizedVariables();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QueryCSImpl <em>Query CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QueryCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getQueryCS()
		 * @generated
		 */
		EClass QUERY_CS = eINSTANCE.getQueryCS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__PATH_NAME = eINSTANCE.getQueryCS_PathName();

		/**
		 * The meta object literal for the '<em><b>Input Param Declaration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__INPUT_PARAM_DECLARATION = eINSTANCE.getQueryCS_InputParamDeclaration();

		/**
		 * The meta object literal for the '<em><b>Ocl Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__OCL_EXPRESSION = eINSTANCE.getQueryCS_OclExpression();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__TYPE = eINSTANCE.getQueryCS_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.RealizeableVariableCSImpl <em>Realizeable Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.RealizeableVariableCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getRealizeableVariableCS()
		 * @generated
		 */
		EClass REALIZEABLE_VARIABLE_CS = eINSTANCE.getRealizeableVariableCS();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REALIZEABLE_VARIABLE_CS__TYPE = eINSTANCE.getRealizeableVariableCS_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.TopLevelCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getTopLevelCS()
		 * @generated
		 */
		EClass TOP_LEVEL_CS = eINSTANCE.getTopLevelCS();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__MAPPINGS = eINSTANCE.getTopLevelCS_Mappings();

		/**
		 * The meta object literal for the '<em><b>Queries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__QUERIES = eINSTANCE.getTopLevelCS_Queries();

		/**
		 * The meta object literal for the '<em><b>Transformations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__TRANSFORMATIONS = eINSTANCE.getTopLevelCS_Transformations();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.TransformationCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getTransformationCS()
		 * @generated
		 */
		EClass TRANSFORMATION_CS = eINSTANCE.getTransformationCS();

		/**
		 * The meta object literal for the '<em><b>Directions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__DIRECTIONS = eINSTANCE.getTransformationCS_Directions();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__PATH_NAME = eINSTANCE.getTransformationCS_PathName();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.UnrealizedVariableCSImpl <em>Unrealized Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.UnrealizedVariableCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getUnrealizedVariableCS()
		 * @generated
		 */
		EClass UNREALIZED_VARIABLE_CS = eINSTANCE.getUnrealizedVariableCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.EnforcementOperationCSImpl <em>Enforcement Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.EnforcementOperationCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getEnforcementOperationCS()
		 * @generated
		 */
		EClass ENFORCEMENT_OPERATION_CS = eINSTANCE.getEnforcementOperationCS();

		/**
		 * The meta object literal for the '<em><b>Deletion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENFORCEMENT_OPERATION_CS__DELETION = eINSTANCE.getEnforcementOperationCS_Deletion();

		/**
		 * The meta object literal for the '<em><b>Operation Call</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCEMENT_OPERATION_CS__OPERATION_CALL = eINSTANCE.getEnforcementOperationCS_OperationCall();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.DomainCSImpl <em>Domain CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.DomainCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getDomainCS()
		 * @generated
		 */
		EClass DOMAIN_CS = eINSTANCE.getDomainCS();

		/**
		 * The meta object literal for the '<em><b>Check</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_CS__CHECK = eINSTANCE.getDomainCS_Check();

		/**
		 * The meta object literal for the '<em><b>Enforce</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_CS__ENFORCE = eINSTANCE.getDomainCS_Enforce();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.GuardPatternCSImpl <em>Guard Pattern CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.GuardPatternCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getGuardPatternCS()
		 * @generated
		 */
		EClass GUARD_PATTERN_CS = eINSTANCE.getGuardPatternCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.RealizedVariableCSImpl <em>Realized Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.RealizedVariableCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QVTcCSTPackageImpl#getRealizedVariableCS()
		 * @generated
		 */
		EClass REALIZED_VARIABLE_CS = eINSTANCE.getRealizedVariableCS();

	}

} //EqvtcCSTPackage
