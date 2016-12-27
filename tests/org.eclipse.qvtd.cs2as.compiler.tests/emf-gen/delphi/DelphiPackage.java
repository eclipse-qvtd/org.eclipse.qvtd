/**
 * Copyright (c)  2016 Willink Transformations, Univesity of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 */
package delphi;

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
 * @see delphi.DelphiFactory
 * @model kind="package"
 * @generated
 */
public interface DelphiPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "delphi";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cs2as/tests/delphi/CS/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "delphi";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DelphiPackage eINSTANCE = delphi.impl.DelphiPackageImpl.init();

	/**
	 * The meta object id for the '{@link delphi.impl.CSTraceImpl <em>CS Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.CSTraceImpl
	 * @see delphi.impl.DelphiPackageImpl#getCSTrace()
	 * @generated
	 */
	int CS_TRACE = 140;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_TRACE__AST = 0;

	/**
	 * The number of structural features of the '<em>CS Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_TRACE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link delphi.impl.mainRuleImpl <em>main Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.mainRuleImpl
	 * @see delphi.impl.DelphiPackageImpl#getmainRule()
	 * @generated
	 */
	int MAIN_RULE = 0;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN_RULE__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN_RULE__FILE = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>main Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN_RULE_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.fileImpl <em>file</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.fileImpl
	 * @see delphi.impl.DelphiPackageImpl#getfile()
	 * @generated
	 */
	int FILE = 1;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__ID = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>file</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.programImpl <em>program</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.programImpl
	 * @see delphi.impl.DelphiPackageImpl#getprogram()
	 * @generated
	 */
	int PROGRAM = 2;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__AST = FILE__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__ID = FILE__ID;

	/**
	 * The feature id for the '<em><b>Params List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__PARAMS_LIST = FILE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__BLOCK = FILE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>program</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_FEATURE_COUNT = FILE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.unitImpl <em>unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.unitImpl
	 * @see delphi.impl.DelphiPackageImpl#getunit()
	 * @generated
	 */
	int UNIT = 3;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__AST = FILE__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__ID = FILE__ID;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__PORT = FILE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Interface Sect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__INTERFACE_SECT = FILE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Implementation Sect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__IMPLEMENTATION_SECT = FILE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Init Sect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__INIT_SECT = FILE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_FEATURE_COUNT = FILE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link delphi.impl.packageDeclImpl <em>package Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.packageDeclImpl
	 * @see delphi.impl.DelphiPackageImpl#getpackageDecl()
	 * @generated
	 */
	int PACKAGE_DECL = 4;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECL__AST = FILE__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECL__ID = FILE__ID;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECL__REQUIRES = FILE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contains</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECL__CONTAINS = FILE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>package Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_DECL_FEATURE_COUNT = FILE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.libraryImpl <em>library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.libraryImpl
	 * @see delphi.impl.DelphiPackageImpl#getlibrary()
	 * @generated
	 */
	int LIBRARY = 5;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__AST = FILE__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__ID = FILE__ID;

	/**
	 * The feature id for the '<em><b>PBlock</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__PBLOCK = FILE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = FILE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.programBlockImpl <em>program Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.programBlockImpl
	 * @see delphi.impl.DelphiPackageImpl#getprogramBlock()
	 * @generated
	 */
	int PROGRAM_BLOCK = 6;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_BLOCK__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_BLOCK__USES = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_BLOCK__BLOCK = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>program Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_BLOCK_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.usesClauseImpl <em>uses Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.usesClauseImpl
	 * @see delphi.impl.DelphiPackageImpl#getusesClause()
	 * @generated
	 */
	int USES_CLAUSE = 7;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USES_CLAUSE__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USES_CLAUSE__ID_LIST = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>uses Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USES_CLAUSE_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.interfaceSectionImpl <em>interface Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.interfaceSectionImpl
	 * @see delphi.impl.DelphiPackageImpl#getinterfaceSection()
	 * @generated
	 */
	int INTERFACE_SECTION = 8;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_SECTION__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_SECTION__USES = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Interface Decl</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_SECTION__INTERFACE_DECL = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>interface Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_SECTION_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.interfaceDeclImpl <em>interface Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.interfaceDeclImpl
	 * @see delphi.impl.DelphiPackageImpl#getinterfaceDecl()
	 * @generated
	 */
	int INTERFACE_DECL = 9;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_DECL__AST = CS_TRACE__AST;

	/**
	 * The number of structural features of the '<em>interface Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_DECL_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.exportedHeadingImpl <em>exported Heading</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.exportedHeadingImpl
	 * @see delphi.impl.DelphiPackageImpl#getexportedHeading()
	 * @generated
	 */
	int EXPORTED_HEADING = 10;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_HEADING__AST = INTERFACE_DECL__AST;

	/**
	 * The feature id for the '<em><b>PHeading</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_HEADING__PHEADING = INTERFACE_DECL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Directive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_HEADING__DIRECTIVE = INTERFACE_DECL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>FHeading</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_HEADING__FHEADING = INTERFACE_DECL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>exported Heading</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_HEADING_FEATURE_COUNT = INTERFACE_DECL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link delphi.impl.implementationSectionImpl <em>implementation Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.implementationSectionImpl
	 * @see delphi.impl.DelphiPackageImpl#getimplementationSection()
	 * @generated
	 */
	int IMPLEMENTATION_SECTION = 11;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_SECTION__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_SECTION__USES = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Decl Sect</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_SECTION__DECL_SECT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_SECTION__EXPORTS = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>implementation Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_SECTION_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link delphi.impl.blockImpl <em>block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.blockImpl
	 * @see delphi.impl.DelphiPackageImpl#getblock()
	 * @generated
	 */
	int BLOCK = 12;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Decl Sect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__DECL_SECT = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__EXPORTS = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Compound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__COMPOUND = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link delphi.impl.exportsItemImpl <em>exports Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.exportsItemImpl
	 * @see delphi.impl.DelphiPackageImpl#getexportsItem()
	 * @generated
	 */
	int EXPORTS_ITEM = 13;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTS_ITEM__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTS_ITEM__ID = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Const Exp</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTS_ITEM__CONST_EXP = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>exports Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTS_ITEM_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.exportsStmtImpl <em>exports Stmt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.exportsStmtImpl
	 * @see delphi.impl.DelphiPackageImpl#getexportsStmt()
	 * @generated
	 */
	int EXPORTS_STMT = 14;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTS_STMT__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTS_STMT__ITEMS = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>exports Stmt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTS_STMT_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.declSectionImpl <em>decl Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.declSectionImpl
	 * @see delphi.impl.DelphiPackageImpl#getdeclSection()
	 * @generated
	 */
	int DECL_SECTION = 15;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECL_SECTION__AST = CS_TRACE__AST;

	/**
	 * The number of structural features of the '<em>decl Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECL_SECTION_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.labelDeclSectionImpl <em>label Decl Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.labelDeclSectionImpl
	 * @see delphi.impl.DelphiPackageImpl#getlabelDeclSection()
	 * @generated
	 */
	int LABEL_DECL_SECTION = 16;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_DECL_SECTION__AST = DECL_SECTION__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_DECL_SECTION__ID = DECL_SECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>label Decl Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_DECL_SECTION_FEATURE_COUNT = DECL_SECTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.constSectionImpl <em>const Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.constSectionImpl
	 * @see delphi.impl.DelphiPackageImpl#getconstSection()
	 * @generated
	 */
	int CONST_SECTION = 17;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_SECTION__AST = INTERFACE_DECL__AST;

	/**
	 * The feature id for the '<em><b>Constant Decl</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_SECTION__CONSTANT_DECL = INTERFACE_DECL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>const Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_SECTION_FEATURE_COUNT = INTERFACE_DECL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.constantDeclImpl <em>constant Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.constantDeclImpl
	 * @see delphi.impl.DelphiPackageImpl#getconstantDecl()
	 * @generated
	 */
	int CONSTANT_DECL = 18;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DECL__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DECL__ID = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Const</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DECL__CONST = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DECL__PORT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DECL__TYPE_REF = CS_TRACE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Typed Constat</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DECL__TYPED_CONSTAT = CS_TRACE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>constant Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DECL_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link delphi.impl.typeSectionImpl <em>type Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.typeSectionImpl
	 * @see delphi.impl.DelphiPackageImpl#gettypeSection()
	 * @generated
	 */
	int TYPE_SECTION = 19;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SECTION__AST = INTERFACE_DECL__AST;

	/**
	 * The feature id for the '<em><b>Type Decl</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SECTION__TYPE_DECL = INTERFACE_DECL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>type Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SECTION_FEATURE_COUNT = INTERFACE_DECL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.typeDeclImpl <em>type Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.typeDeclImpl
	 * @see delphi.impl.DelphiPackageImpl#gettypeDecl()
	 * @generated
	 */
	int TYPE_DECL = 20;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DECL__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DECL__ID = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DECL__TYPE = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DECL__PORT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Restricted Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DECL__RESTRICTED_TYPE = CS_TRACE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>type Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DECL_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link delphi.impl.typedConstantImpl <em>typed Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.typedConstantImpl
	 * @see delphi.impl.DelphiPackageImpl#gettypedConstant()
	 * @generated
	 */
	int TYPED_CONSTANT = 21;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_CONSTANT__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Const</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_CONSTANT__CONST = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Array</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_CONSTANT__ARRAY = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Record</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_CONSTANT__RECORD = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>typed Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_CONSTANT_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link delphi.impl.arrayConstantImpl <em>array Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.arrayConstantImpl
	 * @see delphi.impl.DelphiPackageImpl#getarrayConstant()
	 * @generated
	 */
	int ARRAY_CONSTANT = 22;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_CONSTANT__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Typed Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_CONSTANT__TYPED_CONSTANT = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>array Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_CONSTANT_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.recordConstantImpl <em>record Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.recordConstantImpl
	 * @see delphi.impl.DelphiPackageImpl#getrecordConstant()
	 * @generated
	 */
	int RECORD_CONSTANT = 23;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CONSTANT__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Record Field</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CONSTANT__RECORD_FIELD = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>record Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CONSTANT_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.recordFieldConstantImpl <em>record Field Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.recordFieldConstantImpl
	 * @see delphi.impl.DelphiPackageImpl#getrecordFieldConstant()
	 * @generated
	 */
	int RECORD_FIELD_CONSTANT = 24;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FIELD_CONSTANT__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FIELD_CONSTANT__ID = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Typed Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FIELD_CONSTANT__TYPED_CONSTANT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>record Field Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FIELD_CONSTANT_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.typeImpl <em>type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.typeImpl
	 * @see delphi.impl.DelphiPackageImpl#gettype()
	 * @generated
	 */
	int TYPE = 25;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__AST = CS_TRACE__AST;

	/**
	 * The number of structural features of the '<em>type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.restrictedTypeImpl <em>restricted Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.restrictedTypeImpl
	 * @see delphi.impl.DelphiPackageImpl#getrestrictedType()
	 * @generated
	 */
	int RESTRICTED_TYPE = 26;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICTED_TYPE__AST = CS_TRACE__AST;

	/**
	 * The number of structural features of the '<em>restricted Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICTED_TYPE_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.classRefTypeImpl <em>class Ref Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.classRefTypeImpl
	 * @see delphi.impl.DelphiPackageImpl#getclassRefType()
	 * @generated
	 */
	int CLASS_REF_TYPE = 27;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_REF_TYPE__AST = TYPE__AST;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_REF_TYPE__TYPE_REF = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>class Ref Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_REF_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.simpleTypeImpl <em>simple Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.simpleTypeImpl
	 * @see delphi.impl.DelphiPackageImpl#getsimpleType()
	 * @generated
	 */
	int SIMPLE_TYPE = 28;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE__AST = TYPE__AST;

	/**
	 * The number of structural features of the '<em>simple Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.realTypeImpl <em>real Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.realTypeImpl
	 * @see delphi.impl.DelphiPackageImpl#getrealType()
	 * @generated
	 */
	int REAL_TYPE = 29;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__AST = SIMPLE_TYPE__AST;

	/**
	 * The number of structural features of the '<em>real Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE_FEATURE_COUNT = SIMPLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.ordinalTypeImpl <em>ordinal Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.ordinalTypeImpl
	 * @see delphi.impl.DelphiPackageImpl#getordinalType()
	 * @generated
	 */
	int ORDINAL_TYPE = 30;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDINAL_TYPE__AST = SIMPLE_TYPE__AST;

	/**
	 * The number of structural features of the '<em>ordinal Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDINAL_TYPE_FEATURE_COUNT = SIMPLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.ordIdentImpl <em>ord Ident</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.ordIdentImpl
	 * @see delphi.impl.DelphiPackageImpl#getordIdent()
	 * @generated
	 */
	int ORD_IDENT = 31;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORD_IDENT__AST = ORDINAL_TYPE__AST;

	/**
	 * The number of structural features of the '<em>ord Ident</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORD_IDENT_FEATURE_COUNT = ORDINAL_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.variantTypeImpl <em>variant Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.variantTypeImpl
	 * @see delphi.impl.DelphiPackageImpl#getvariantType()
	 * @generated
	 */
	int VARIANT_TYPE = 32;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPE__AST = TYPE__AST;

	/**
	 * The number of structural features of the '<em>variant Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.subrangeTypeImpl <em>subrange Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.subrangeTypeImpl
	 * @see delphi.impl.DelphiPackageImpl#getsubrangeType()
	 * @generated
	 */
	int SUBRANGE_TYPE = 33;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBRANGE_TYPE__AST = ORDINAL_TYPE__AST;

	/**
	 * The feature id for the '<em><b>First</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBRANGE_TYPE__FIRST = ORDINAL_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBRANGE_TYPE__LAST = ORDINAL_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>subrange Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBRANGE_TYPE_FEATURE_COUNT = ORDINAL_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.enumeratedTypeImpl <em>enumerated Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.enumeratedTypeImpl
	 * @see delphi.impl.DelphiPackageImpl#getenumeratedType()
	 * @generated
	 */
	int ENUMERATED_TYPE = 34;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATED_TYPE__AST = ORDINAL_TYPE__AST;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATED_TYPE__ELEMENT = ORDINAL_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>enumerated Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATED_TYPE_FEATURE_COUNT = ORDINAL_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.enumeratedTypeElementImpl <em>enumerated Type Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.enumeratedTypeElementImpl
	 * @see delphi.impl.DelphiPackageImpl#getenumeratedTypeElement()
	 * @generated
	 */
	int ENUMERATED_TYPE_ELEMENT = 35;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATED_TYPE_ELEMENT__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATED_TYPE_ELEMENT__ID = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Literal Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATED_TYPE_ELEMENT__LITERAL_EXP = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>enumerated Type Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATED_TYPE_ELEMENT_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.stringTypeImpl <em>string Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.stringTypeImpl
	 * @see delphi.impl.DelphiPackageImpl#getstringType()
	 * @generated
	 */
	int STRING_TYPE = 36;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__AST = TYPE__AST;

	/**
	 * The feature id for the '<em><b>Const Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__CONST_EXP = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>string Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.strucTypeImpl <em>struc Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.strucTypeImpl
	 * @see delphi.impl.DelphiPackageImpl#getstrucType()
	 * @generated
	 */
	int STRUC_TYPE = 37;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUC_TYPE__AST = TYPE__AST;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUC_TYPE__PORT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>struc Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUC_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.arrayTypeImpl <em>array Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.arrayTypeImpl
	 * @see delphi.impl.DelphiPackageImpl#getarrayType()
	 * @generated
	 */
	int ARRAY_TYPE = 38;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__AST = STRUC_TYPE__AST;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__PORT = STRUC_TYPE__PORT;

	/**
	 * The feature id for the '<em><b>Ordinal Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__ORDINAL_TYPE = STRUC_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ordinal Typ</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__ORDINAL_TYP = STRUC_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__TYPE = STRUC_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>array Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE_FEATURE_COUNT = STRUC_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link delphi.impl.recTypeImpl <em>rec Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.recTypeImpl
	 * @see delphi.impl.DelphiPackageImpl#getrecType()
	 * @generated
	 */
	int REC_TYPE = 39;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REC_TYPE__AST = STRUC_TYPE__AST;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REC_TYPE__PORT = STRUC_TYPE__PORT;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REC_TYPE__FIELDS = STRUC_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>rec Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REC_TYPE_FEATURE_COUNT = STRUC_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.fieldListImpl <em>field List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.fieldListImpl
	 * @see delphi.impl.DelphiPackageImpl#getfieldList()
	 * @generated
	 */
	int FIELD_LIST = 40;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_LIST__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Field</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_LIST__FIELD = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variant Sect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_LIST__VARIANT_SECT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>field List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_LIST_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.fieldDeclImpl <em>field Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.fieldDeclImpl
	 * @see delphi.impl.DelphiPackageImpl#getfieldDecl()
	 * @generated
	 */
	int FIELD_DECL = 41;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_DECL__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_DECL__ID_LIST = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_DECL__TYPE = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_DECL__PORT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>field Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_DECL_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link delphi.impl.variantSectionImpl <em>variant Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.variantSectionImpl
	 * @see delphi.impl.DelphiPackageImpl#getvariantSection()
	 * @generated
	 */
	int VARIANT_SECTION = 42;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_SECTION__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_SECTION__ID = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_SECTION__TYPE_REF = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rec Variants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_SECTION__REC_VARIANTS = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>variant Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_SECTION_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link delphi.impl.recVariantImpl <em>rec Variant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.recVariantImpl
	 * @see delphi.impl.DelphiPackageImpl#getrecVariant()
	 * @generated
	 */
	int REC_VARIANT = 43;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REC_VARIANT__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Const Exp</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REC_VARIANT__CONST_EXP = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Field List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REC_VARIANT__FIELD_LIST = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>rec Variant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REC_VARIANT_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.setTypeImpl <em>set Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.setTypeImpl
	 * @see delphi.impl.DelphiPackageImpl#getsetType()
	 * @generated
	 */
	int SET_TYPE = 44;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__AST = STRUC_TYPE__AST;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__PORT = STRUC_TYPE__PORT;

	/**
	 * The feature id for the '<em><b>Ordinal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__ORDINAL = STRUC_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_FEATURE_COUNT = STRUC_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.fileTypeImpl <em>file Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.fileTypeImpl
	 * @see delphi.impl.DelphiPackageImpl#getfileType()
	 * @generated
	 */
	int FILE_TYPE = 45;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE__AST = STRUC_TYPE__AST;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE__PORT = STRUC_TYPE__PORT;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE__TYPE_REF = STRUC_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>file Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE_FEATURE_COUNT = STRUC_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.pointerTypeImpl <em>pointer Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.pointerTypeImpl
	 * @see delphi.impl.DelphiPackageImpl#getpointerType()
	 * @generated
	 */
	int POINTER_TYPE = 46;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTER_TYPE__AST = TYPE__AST;

	/**
	 * The number of structural features of the '<em>pointer Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTER_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.procedureTypeImpl <em>procedure Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.procedureTypeImpl
	 * @see delphi.impl.DelphiPackageImpl#getprocedureType()
	 * @generated
	 */
	int PROCEDURE_TYPE = 47;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_TYPE__AST = TYPE__AST;

	/**
	 * The feature id for the '<em><b>PHeading</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_TYPE__PHEADING = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>FHeading</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_TYPE__FHEADING = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>procedure Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.varSectionImpl <em>var Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.varSectionImpl
	 * @see delphi.impl.DelphiPackageImpl#getvarSection()
	 * @generated
	 */
	int VAR_SECTION = 48;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_SECTION__AST = INTERFACE_DECL__AST;

	/**
	 * The feature id for the '<em><b>Var Decls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_SECTION__VAR_DECLS = INTERFACE_DECL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>var Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_SECTION_FEATURE_COUNT = INTERFACE_DECL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.varDeclImpl <em>var Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.varDeclImpl
	 * @see delphi.impl.DelphiPackageImpl#getvarDecl()
	 * @generated
	 */
	int VAR_DECL = 49;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECL__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECL__ID_LIST = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECL__TYPE = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Abs Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECL__ABS_ID = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Abs Const</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECL__ABS_CONST = CS_TRACE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Abs Initi</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECL__ABS_INITI = CS_TRACE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>var Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECL_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link delphi.impl.expressionImpl <em>expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.expressionImpl
	 * @see delphi.impl.DelphiPackageImpl#getexpression()
	 * @generated
	 */
	int EXPRESSION = 50;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__AST = CS_TRACE__AST;

	/**
	 * The number of structural features of the '<em>expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.simpleExpressionImpl <em>simple Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.simpleExpressionImpl
	 * @see delphi.impl.DelphiPackageImpl#getsimpleExpression()
	 * @generated
	 */
	int SIMPLE_EXPRESSION = 51;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXPRESSION__AST = EXPRESSION__AST;

	/**
	 * The number of structural features of the '<em>simple Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.termImpl <em>term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.termImpl
	 * @see delphi.impl.DelphiPackageImpl#getterm()
	 * @generated
	 */
	int TERM = 52;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__AST = SIMPLE_EXPRESSION__AST;

	/**
	 * The number of structural features of the '<em>term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_FEATURE_COUNT = SIMPLE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.factorImpl <em>factor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.factorImpl
	 * @see delphi.impl.DelphiPackageImpl#getfactor()
	 * @generated
	 */
	int FACTOR = 53;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR__AST = TERM__AST;

	/**
	 * The feature id for the '<em><b>Designator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR__DESIGNATOR = TERM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exp List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR__EXP_LIST = TERM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR__NUMBER = TERM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR__STRING = TERM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Nested Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR__NESTED_EXP = TERM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR__EXP = TERM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Set Constuctor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR__SET_CONSTUCTOR = TERM_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR__TYPE_REF = TERM_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>factor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTOR_FEATURE_COUNT = TERM_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link delphi.impl.relOpImpl <em>rel Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.relOpImpl
	 * @see delphi.impl.DelphiPackageImpl#getrelOp()
	 * @generated
	 */
	int REL_OP = 54;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_OP__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_OP__OP = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>rel Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_OP_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.addOpImpl <em>add Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.addOpImpl
	 * @see delphi.impl.DelphiPackageImpl#getaddOp()
	 * @generated
	 */
	int ADD_OP = 55;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OP__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OP__OP = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>add Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OP_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.mulOpImpl <em>mul Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.mulOpImpl
	 * @see delphi.impl.DelphiPackageImpl#getmulOp()
	 * @generated
	 */
	int MUL_OP = 56;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUL_OP__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUL_OP__OP = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>mul Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUL_OP_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.designatorImpl <em>designator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.designatorImpl
	 * @see delphi.impl.DelphiPackageImpl#getdesignator()
	 * @generated
	 */
	int DESIGNATOR = 57;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGNATOR__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Subpart</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGNATOR__SUBPART = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Designator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGNATOR__DESIGNATOR = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>designator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGNATOR_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.designatorSubPartImpl <em>designator Sub Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.designatorSubPartImpl
	 * @see delphi.impl.DelphiPackageImpl#getdesignatorSubPart()
	 * @generated
	 */
	int DESIGNATOR_SUB_PART = 58;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGNATOR_SUB_PART__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGNATOR_SUB_PART__PART = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expr List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGNATOR_SUB_PART__EXPR_LIST = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>designator Sub Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGNATOR_SUB_PART_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.designatorPartImpl <em>designator Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.designatorPartImpl
	 * @see delphi.impl.DelphiPackageImpl#getdesignatorPart()
	 * @generated
	 */
	int DESIGNATOR_PART = 59;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGNATOR_PART__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGNATOR_PART__ID = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reserved Word</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGNATOR_PART__RESERVED_WORD = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGNATOR_PART__ID2 = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>designator Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGNATOR_PART_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link delphi.impl.setConstructorImpl <em>set Constructor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.setConstructorImpl
	 * @see delphi.impl.DelphiPackageImpl#getsetConstructor()
	 * @generated
	 */
	int SET_CONSTRUCTOR = 60;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CONSTRUCTOR__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CONSTRUCTOR__ELEMENT = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>set Constructor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CONSTRUCTOR_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.setElementImpl <em>set Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.setElementImpl
	 * @see delphi.impl.DelphiPackageImpl#getsetElement()
	 * @generated
	 */
	int SET_ELEMENT = 61;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ELEMENT__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>First</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ELEMENT__FIRST = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ELEMENT__LAST = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>set Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ELEMENT_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.exprListImpl <em>expr List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.exprListImpl
	 * @see delphi.impl.DelphiPackageImpl#getexprList()
	 * @generated
	 */
	int EXPR_LIST = 62;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_LIST__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Exps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_LIST__EXPS = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>expr List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_LIST_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.stmtListImpl <em>stmt List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.stmtListImpl
	 * @see delphi.impl.DelphiPackageImpl#getstmtList()
	 * @generated
	 */
	int STMT_LIST = 63;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STMT_LIST__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Statments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STMT_LIST__STATMENTS = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>stmt List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STMT_LIST_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.statementImpl <em>statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.statementImpl
	 * @see delphi.impl.DelphiPackageImpl#getstatement()
	 * @generated
	 */
	int STATEMENT = 64;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Label Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__LABEL_ID = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__STATEMENT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.unlabelledStatementImpl <em>unlabelled Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.unlabelledStatementImpl
	 * @see delphi.impl.DelphiPackageImpl#getunlabelledStatement()
	 * @generated
	 */
	int UNLABELLED_STATEMENT = 65;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLABELLED_STATEMENT__AST = CS_TRACE__AST;

	/**
	 * The number of structural features of the '<em>unlabelled Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLABELLED_STATEMENT_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.simpleStatementImpl <em>simple Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.simpleStatementImpl
	 * @see delphi.impl.DelphiPackageImpl#getsimpleStatement()
	 * @generated
	 */
	int SIMPLE_STATEMENT = 66;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_STATEMENT__AST = UNLABELLED_STATEMENT__AST;

	/**
	 * The number of structural features of the '<em>simple Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_STATEMENT_FEATURE_COUNT = UNLABELLED_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.structStmtImpl <em>struct Stmt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.structStmtImpl
	 * @see delphi.impl.DelphiPackageImpl#getstructStmt()
	 * @generated
	 */
	int STRUCT_STMT = 67;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_STMT__AST = UNLABELLED_STATEMENT__AST;

	/**
	 * The number of structural features of the '<em>struct Stmt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_STMT_FEATURE_COUNT = UNLABELLED_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.compoundStmtImpl <em>compound Stmt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.compoundStmtImpl
	 * @see delphi.impl.DelphiPackageImpl#getcompoundStmt()
	 * @generated
	 */
	int COMPOUND_STMT = 68;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_STMT__AST = STRUCT_STMT__AST;

	/**
	 * The feature id for the '<em><b>Stamt List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_STMT__STAMT_LIST = STRUCT_STMT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>compound Stmt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_STMT_FEATURE_COUNT = STRUCT_STMT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.conditionalStmtImpl <em>conditional Stmt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.conditionalStmtImpl
	 * @see delphi.impl.DelphiPackageImpl#getconditionalStmt()
	 * @generated
	 */
	int CONDITIONAL_STMT = 69;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_STMT__AST = STRUCT_STMT__AST;

	/**
	 * The number of structural features of the '<em>conditional Stmt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_STMT_FEATURE_COUNT = STRUCT_STMT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.ifStmtImpl <em>if Stmt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.ifStmtImpl
	 * @see delphi.impl.DelphiPackageImpl#getifStmt()
	 * @generated
	 */
	int IF_STMT = 70;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STMT__AST = CONDITIONAL_STMT__AST;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STMT__CONDITION = CONDITIONAL_STMT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STMT__THEN = CONDITIONAL_STMT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STMT__ELSE = CONDITIONAL_STMT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>if Stmt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STMT_FEATURE_COUNT = CONDITIONAL_STMT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link delphi.impl.caseStmtImpl <em>case Stmt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.caseStmtImpl
	 * @see delphi.impl.DelphiPackageImpl#getcaseStmt()
	 * @generated
	 */
	int CASE_STMT = 71;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STMT__AST = CONDITIONAL_STMT__AST;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STMT__EXPRESSION = CONDITIONAL_STMT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STMT__CASES = CONDITIONAL_STMT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STMT__DEFAULT = CONDITIONAL_STMT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>case Stmt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STMT_FEATURE_COUNT = CONDITIONAL_STMT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link delphi.impl.caseSelectorImpl <em>case Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.caseSelectorImpl
	 * @see delphi.impl.DelphiPackageImpl#getcaseSelector()
	 * @generated
	 */
	int CASE_SELECTOR = 72;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SELECTOR__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SELECTOR__LABELS = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stmt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SELECTOR__STMT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>case Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_SELECTOR_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.caseLabelImpl <em>case Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.caseLabelImpl
	 * @see delphi.impl.DelphiPackageImpl#getcaseLabel()
	 * @generated
	 */
	int CASE_LABEL = 73;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_LABEL__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>First</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_LABEL__FIRST = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_LABEL__LAST = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>case Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_LABEL_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.loopStmtImpl <em>loop Stmt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.loopStmtImpl
	 * @see delphi.impl.DelphiPackageImpl#getloopStmt()
	 * @generated
	 */
	int LOOP_STMT = 74;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_STMT__AST = STRUCT_STMT__AST;

	/**
	 * The feature id for the '<em><b>Stmt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_STMT__STMT = STRUCT_STMT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_STMT__CONDITION = STRUCT_STMT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>loop Stmt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_STMT_FEATURE_COUNT = STRUCT_STMT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.repeatStmtImpl <em>repeat Stmt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.repeatStmtImpl
	 * @see delphi.impl.DelphiPackageImpl#getrepeatStmt()
	 * @generated
	 */
	int REPEAT_STMT = 75;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_STMT__AST = LOOP_STMT__AST;

	/**
	 * The feature id for the '<em><b>Stmt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_STMT__STMT = LOOP_STMT__STMT;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_STMT__CONDITION = LOOP_STMT__CONDITION;

	/**
	 * The number of structural features of the '<em>repeat Stmt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_STMT_FEATURE_COUNT = LOOP_STMT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.whileStmtImpl <em>while Stmt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.whileStmtImpl
	 * @see delphi.impl.DelphiPackageImpl#getwhileStmt()
	 * @generated
	 */
	int WHILE_STMT = 76;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STMT__AST = LOOP_STMT__AST;

	/**
	 * The feature id for the '<em><b>Stmt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STMT__STMT = LOOP_STMT__STMT;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STMT__CONDITION = LOOP_STMT__CONDITION;

	/**
	 * The number of structural features of the '<em>while Stmt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STMT_FEATURE_COUNT = LOOP_STMT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.forStmtImpl <em>for Stmt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.forStmtImpl
	 * @see delphi.impl.DelphiPackageImpl#getforStmt()
	 * @generated
	 */
	int FOR_STMT = 77;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STMT__AST = LOOP_STMT__AST;

	/**
	 * The feature id for the '<em><b>Stmt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STMT__STMT = LOOP_STMT__STMT;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STMT__CONDITION = LOOP_STMT__CONDITION;

	/**
	 * The feature id for the '<em><b>Var Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STMT__VAR_ID = LOOP_STMT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Var Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STMT__VAR_INIT = LOOP_STMT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>for Stmt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STMT_FEATURE_COUNT = LOOP_STMT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.withStmtImpl <em>with Stmt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.withStmtImpl
	 * @see delphi.impl.DelphiPackageImpl#getwithStmt()
	 * @generated
	 */
	int WITH_STMT = 78;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_STMT__AST = STRUCT_STMT__AST;

	/**
	 * The feature id for the '<em><b>Vars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_STMT__VARS = STRUCT_STMT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stmt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_STMT__STMT = STRUCT_STMT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>with Stmt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_STMT_FEATURE_COUNT = STRUCT_STMT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.tryStmtImpl <em>try Stmt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.tryStmtImpl
	 * @see delphi.impl.DelphiPackageImpl#gettryStmt()
	 * @generated
	 */
	int TRY_STMT = 79;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_STMT__AST = STRUCT_STMT__AST;

	/**
	 * The feature id for the '<em><b>Stmt List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_STMT__STMT_LIST = STRUCT_STMT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_STMT__EXCEPTION = STRUCT_STMT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Final</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_STMT__FINAL = STRUCT_STMT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>try Stmt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_STMT_FEATURE_COUNT = STRUCT_STMT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link delphi.impl.exceptionBlockImpl <em>exception Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.exceptionBlockImpl
	 * @see delphi.impl.DelphiPackageImpl#getexceptionBlock()
	 * @generated
	 */
	int EXCEPTION_BLOCK = 80;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_BLOCK__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Exception Id</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_BLOCK__EXCEPTION_ID = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_BLOCK__TYPE = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Do Stmt</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_BLOCK__DO_STMT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Else Stmts</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_BLOCK__ELSE_STMTS = CS_TRACE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>exception Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_BLOCK_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link delphi.impl.raiseStmtImpl <em>raise Stmt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.raiseStmtImpl
	 * @see delphi.impl.DelphiPackageImpl#getraiseStmt()
	 * @generated
	 */
	int RAISE_STMT = 81;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_STMT__AST = STRUCT_STMT__AST;

	/**
	 * The feature id for the '<em><b>Raise</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_STMT__RAISE = STRUCT_STMT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_STMT__AT = STRUCT_STMT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>raise Stmt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_STMT_FEATURE_COUNT = STRUCT_STMT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.assemblerStmtImpl <em>assembler Stmt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.assemblerStmtImpl
	 * @see delphi.impl.DelphiPackageImpl#getassemblerStmt()
	 * @generated
	 */
	int ASSEMBLER_STMT = 82;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLER_STMT__AST = STRUCT_STMT__AST;

	/**
	 * The number of structural features of the '<em>assembler Stmt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLER_STMT_FEATURE_COUNT = STRUCT_STMT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.procedureDeclSectionImpl <em>procedure Decl Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.procedureDeclSectionImpl
	 * @see delphi.impl.DelphiPackageImpl#getprocedureDeclSection()
	 * @generated
	 */
	int PROCEDURE_DECL_SECTION = 83;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_DECL_SECTION__AST = DECL_SECTION__AST;

	/**
	 * The feature id for the '<em><b>Directive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_DECL_SECTION__DIRECTIVE = DECL_SECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_DECL_SECTION__PORT = DECL_SECTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_DECL_SECTION__BLOCK = DECL_SECTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>procedure Decl Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_DECL_SECTION_FEATURE_COUNT = DECL_SECTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link delphi.impl.procedureDeclImpl <em>procedure Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.procedureDeclImpl
	 * @see delphi.impl.DelphiPackageImpl#getprocedureDecl()
	 * @generated
	 */
	int PROCEDURE_DECL = 84;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_DECL__AST = PROCEDURE_DECL_SECTION__AST;

	/**
	 * The feature id for the '<em><b>Directive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_DECL__DIRECTIVE = PROCEDURE_DECL_SECTION__DIRECTIVE;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_DECL__PORT = PROCEDURE_DECL_SECTION__PORT;

	/**
	 * The feature id for the '<em><b>Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_DECL__BLOCK = PROCEDURE_DECL_SECTION__BLOCK;

	/**
	 * The feature id for the '<em><b>Heading</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_DECL__HEADING = PROCEDURE_DECL_SECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>procedure Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_DECL_FEATURE_COUNT = PROCEDURE_DECL_SECTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.functionDeclImpl <em>function Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.functionDeclImpl
	 * @see delphi.impl.DelphiPackageImpl#getfunctionDecl()
	 * @generated
	 */
	int FUNCTION_DECL = 85;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECL__AST = PROCEDURE_DECL_SECTION__AST;

	/**
	 * The feature id for the '<em><b>Directive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECL__DIRECTIVE = PROCEDURE_DECL_SECTION__DIRECTIVE;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECL__PORT = PROCEDURE_DECL_SECTION__PORT;

	/**
	 * The feature id for the '<em><b>Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECL__BLOCK = PROCEDURE_DECL_SECTION__BLOCK;

	/**
	 * The feature id for the '<em><b>Heading</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECL__HEADING = PROCEDURE_DECL_SECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>function Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECL_FEATURE_COUNT = PROCEDURE_DECL_SECTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.methodHeadingImpl <em>method Heading</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.methodHeadingImpl
	 * @see delphi.impl.DelphiPackageImpl#getmethodHeading()
	 * @generated
	 */
	int METHOD_HEADING = 95;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_HEADING__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_HEADING__ID = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Formal Params</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_HEADING__FORMAL_PARAMS = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>method Heading</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_HEADING_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.functionHeadingImpl <em>function Heading</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.functionHeadingImpl
	 * @see delphi.impl.DelphiPackageImpl#getfunctionHeading()
	 * @generated
	 */
	int FUNCTION_HEADING = 86;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_HEADING__AST = METHOD_HEADING__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_HEADING__ID = METHOD_HEADING__ID;

	/**
	 * The feature id for the '<em><b>Formal Params</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_HEADING__FORMAL_PARAMS = METHOD_HEADING__FORMAL_PARAMS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_HEADING__TYPE = METHOD_HEADING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>function Heading</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_HEADING_FEATURE_COUNT = METHOD_HEADING_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.procedureHeadingImpl <em>procedure Heading</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.procedureHeadingImpl
	 * @see delphi.impl.DelphiPackageImpl#getprocedureHeading()
	 * @generated
	 */
	int PROCEDURE_HEADING = 87;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_HEADING__AST = METHOD_HEADING__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_HEADING__ID = METHOD_HEADING__ID;

	/**
	 * The feature id for the '<em><b>Formal Params</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_HEADING__FORMAL_PARAMS = METHOD_HEADING__FORMAL_PARAMS;

	/**
	 * The number of structural features of the '<em>procedure Heading</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_HEADING_FEATURE_COUNT = METHOD_HEADING_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.formalParametersImpl <em>formal Parameters</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.formalParametersImpl
	 * @see delphi.impl.DelphiPackageImpl#getformalParameters()
	 * @generated
	 */
	int FORMAL_PARAMETERS = 88;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETERS__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETERS__PARAMS = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>formal Parameters</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETERS_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.formalParmImpl <em>formal Parm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.formalParmImpl
	 * @see delphi.impl.DelphiPackageImpl#getformalParm()
	 * @generated
	 */
	int FORMAL_PARM = 89;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARM__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARM__PARAM = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>formal Parm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARM_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.parameterImpl <em>parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.parameterImpl
	 * @see delphi.impl.DelphiPackageImpl#getparameter()
	 * @generated
	 */
	int PARAMETER = 90;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.directiveImpl <em>directive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.directiveImpl
	 * @see delphi.impl.DelphiPackageImpl#getdirective()
	 * @generated
	 */
	int DIRECTIVE = 91;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE__DIR = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Message Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE__MESSAGE_EXP = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.objectTypeImpl <em>object Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.objectTypeImpl
	 * @see delphi.impl.DelphiPackageImpl#getobjectType()
	 * @generated
	 */
	int OBJECT_TYPE = 92;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__AST = RESTRICTED_TYPE__AST;

	/**
	 * The feature id for the '<em><b>Heritage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__HERITAGE = RESTRICTED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Field List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__FIELD_LIST = RESTRICTED_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Method List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__METHOD_LIST = RESTRICTED_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>object Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE_FEATURE_COUNT = RESTRICTED_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link delphi.impl.objHeritageImpl <em>obj Heritage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.objHeritageImpl
	 * @see delphi.impl.DelphiPackageImpl#getobjHeritage()
	 * @generated
	 */
	int OBJ_HERITAGE = 93;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJ_HERITAGE__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJ_HERITAGE__ID = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>obj Heritage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJ_HERITAGE_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.methodListImpl <em>method List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.methodListImpl
	 * @see delphi.impl.DelphiPackageImpl#getmethodList()
	 * @generated
	 */
	int METHOD_LIST = 94;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_LIST__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Heading</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_LIST__HEADING = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Directive</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_LIST__DIRECTIVE = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>method List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_LIST_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.constructorHeadingImpl <em>constructor Heading</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.constructorHeadingImpl
	 * @see delphi.impl.DelphiPackageImpl#getconstructorHeading()
	 * @generated
	 */
	int CONSTRUCTOR_HEADING = 96;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_HEADING__AST = METHOD_HEADING__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_HEADING__ID = METHOD_HEADING__ID;

	/**
	 * The feature id for the '<em><b>Formal Params</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_HEADING__FORMAL_PARAMS = METHOD_HEADING__FORMAL_PARAMS;

	/**
	 * The number of structural features of the '<em>constructor Heading</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_HEADING_FEATURE_COUNT = METHOD_HEADING_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.destructorHeadingImpl <em>destructor Heading</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.destructorHeadingImpl
	 * @see delphi.impl.DelphiPackageImpl#getdestructorHeading()
	 * @generated
	 */
	int DESTRUCTOR_HEADING = 97;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTRUCTOR_HEADING__AST = METHOD_HEADING__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTRUCTOR_HEADING__ID = METHOD_HEADING__ID;

	/**
	 * The feature id for the '<em><b>Formal Params</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTRUCTOR_HEADING__FORMAL_PARAMS = METHOD_HEADING__FORMAL_PARAMS;

	/**
	 * The number of structural features of the '<em>destructor Heading</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTRUCTOR_HEADING_FEATURE_COUNT = METHOD_HEADING_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.objFieldListImpl <em>obj Field List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.objFieldListImpl
	 * @see delphi.impl.DelphiPackageImpl#getobjFieldList()
	 * @generated
	 */
	int OBJ_FIELD_LIST = 98;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJ_FIELD_LIST__AST = CS_TRACE__AST;

	/**
	 * The number of structural features of the '<em>obj Field List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJ_FIELD_LIST_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.initSectionImpl <em>init Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.initSectionImpl
	 * @see delphi.impl.DelphiPackageImpl#getinitSection()
	 * @generated
	 */
	int INIT_SECTION = 99;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_SECTION__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Stmt List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_SECTION__STMT_LIST = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Stmt List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_SECTION__END_STMT_LIST = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>init Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_SECTION_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.classTypeImpl <em>class Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.classTypeImpl
	 * @see delphi.impl.DelphiPackageImpl#getclassType()
	 * @generated
	 */
	int CLASS_TYPE = 100;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TYPE__AST = RESTRICTED_TYPE__AST;

	/**
	 * The feature id for the '<em><b>Heritage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TYPE__HERITAGE = RESTRICTED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TYPE__VISIBILITY = RESTRICTED_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Field List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TYPE__FIELD_LIST = RESTRICTED_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Method List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TYPE__METHOD_LIST = RESTRICTED_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Prop List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TYPE__PROP_LIST = RESTRICTED_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>class Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TYPE_FEATURE_COUNT = RESTRICTED_TYPE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link delphi.impl.classHeritageImpl <em>class Heritage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.classHeritageImpl
	 * @see delphi.impl.DelphiPackageImpl#getclassHeritage()
	 * @generated
	 */
	int CLASS_HERITAGE = 101;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_HERITAGE__AST = CS_TRACE__AST;

	/**
	 * The number of structural features of the '<em>class Heritage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_HERITAGE_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.classFieldListImpl <em>class Field List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.classFieldListImpl
	 * @see delphi.impl.DelphiPackageImpl#getclassFieldList()
	 * @generated
	 */
	int CLASS_FIELD_LIST = 102;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FIELD_LIST__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Field</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FIELD_LIST__FIELD = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>class Field List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FIELD_LIST_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.classFieldImpl <em>class Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.classFieldImpl
	 * @see delphi.impl.DelphiPackageImpl#getclassField()
	 * @generated
	 */
	int CLASS_FIELD = 103;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FIELD__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FIELD__VISIBILITY = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Field List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FIELD__FIELD_LIST = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>class Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FIELD_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.classMethodListImpl <em>class Method List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.classMethodListImpl
	 * @see delphi.impl.DelphiPackageImpl#getclassMethodList()
	 * @generated
	 */
	int CLASS_METHOD_LIST = 104;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD_LIST__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Metod</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD_LIST__METOD = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>class Method List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD_LIST_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.classMethodImpl <em>class Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.classMethodImpl
	 * @see delphi.impl.DelphiPackageImpl#getclassMethod()
	 * @generated
	 */
	int CLASS_METHOD = 105;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD__VISIBILITY = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Method List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD__METHOD_LIST = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>class Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_METHOD_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.classPropertyListImpl <em>class Property List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.classPropertyListImpl
	 * @see delphi.impl.DelphiPackageImpl#getclassPropertyList()
	 * @generated
	 */
	int CLASS_PROPERTY_LIST = 106;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PROPERTY_LIST__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PROPERTY_LIST__PROPERTY = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>class Property List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PROPERTY_LIST_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.classPropertyImpl <em>class Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.classPropertyImpl
	 * @see delphi.impl.DelphiPackageImpl#getclassProperty()
	 * @generated
	 */
	int CLASS_PROPERTY = 107;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PROPERTY__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PROPERTY__VISIBILITY = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Prop List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PROPERTY__PROP_LIST = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>class Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PROPERTY_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.propertyListImpl <em>property List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.propertyListImpl
	 * @see delphi.impl.DelphiPackageImpl#getpropertyList()
	 * @generated
	 */
	int PROPERTY_LIST = 108;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_LIST__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_LIST__ID = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_LIST__INTERFACE = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Specifiers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_LIST__SPECIFIERS = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_LIST__PORT = CS_TRACE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>property List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_LIST_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link delphi.impl.propertyInterfaceImpl <em>property Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.propertyInterfaceImpl
	 * @see delphi.impl.DelphiPackageImpl#getpropertyInterface()
	 * @generated
	 */
	int PROPERTY_INTERFACE = 109;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_INTERFACE__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Param List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_INTERFACE__PARAM_LIST = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_INTERFACE__ID = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>property Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_INTERFACE_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.propertyParameterListImpl <em>property Parameter List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.propertyParameterListImpl
	 * @see delphi.impl.DelphiPackageImpl#getpropertyParameterList()
	 * @generated
	 */
	int PROPERTY_PARAMETER_LIST = 110;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PARAMETER_LIST__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PARAMETER_LIST__ID_LIST = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PARAMETER_LIST__TYPE_REF = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>property Parameter List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_PARAMETER_LIST_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.propertySpecifiersImpl <em>property Specifiers</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.propertySpecifiersImpl
	 * @see delphi.impl.DelphiPackageImpl#getpropertySpecifiers()
	 * @generated
	 */
	int PROPERTY_SPECIFIERS = 111;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SPECIFIERS__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SPECIFIERS__INDEX = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Read Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SPECIFIERS__READ_ID = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Write Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SPECIFIERS__WRITE_ID = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Store Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SPECIFIERS__STORE_ID = CS_TRACE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Store Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SPECIFIERS__STORE_EXP = CS_TRACE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Defaul Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SPECIFIERS__DEFAUL_EXP = CS_TRACE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Implement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SPECIFIERS__IMPLEMENT = CS_TRACE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>property Specifiers</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SPECIFIERS_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link delphi.impl.interfaceTypeImpl <em>interface Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.interfaceTypeImpl
	 * @see delphi.impl.DelphiPackageImpl#getinterfaceType()
	 * @generated
	 */
	int INTERFACE_TYPE = 112;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_TYPE__AST = RESTRICTED_TYPE__AST;

	/**
	 * The feature id for the '<em><b>Heritage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_TYPE__HERITAGE = RESTRICTED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Method List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_TYPE__METHOD_LIST = RESTRICTED_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Prop List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_TYPE__PROP_LIST = RESTRICTED_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>interface Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_TYPE_FEATURE_COUNT = RESTRICTED_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link delphi.impl.interfaceHeritageImpl <em>interface Heritage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.interfaceHeritageImpl
	 * @see delphi.impl.DelphiPackageImpl#getinterfaceHeritage()
	 * @generated
	 */
	int INTERFACE_HERITAGE = 113;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_HERITAGE__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_HERITAGE__ID_LIST = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>interface Heritage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_HERITAGE_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.requiresClauseImpl <em>requires Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.requiresClauseImpl
	 * @see delphi.impl.DelphiPackageImpl#getrequiresClause()
	 * @generated
	 */
	int REQUIRES_CLAUSE = 114;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_CLAUSE__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_CLAUSE__ID_LIST = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>requires Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_CLAUSE_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.containsClauseImpl <em>contains Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.containsClauseImpl
	 * @see delphi.impl.DelphiPackageImpl#getcontainsClause()
	 * @generated
	 */
	int CONTAINS_CLAUSE = 115;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_CLAUSE__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_CLAUSE__ID_LIST = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>contains Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_CLAUSE_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.identListImpl <em>ident List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.identListImpl
	 * @see delphi.impl.DelphiPackageImpl#getidentList()
	 * @generated
	 */
	int IDENT_LIST = 116;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENT_LIST__AST = OBJ_FIELD_LIST__AST;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENT_LIST__TYPE = OBJ_FIELD_LIST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ids</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENT_LIST__IDS = OBJ_FIELD_LIST_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>ident List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENT_LIST_FEATURE_COUNT = OBJ_FIELD_LIST_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.qualIdImpl <em>qual Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.qualIdImpl
	 * @see delphi.impl.DelphiPackageImpl#getqualId()
	 * @generated
	 */
	int QUAL_ID = 117;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUAL_ID__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Unit Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUAL_ID__UNIT_ID = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUAL_ID__ID = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>qual Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUAL_ID_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.typeIdImpl <em>type Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.typeIdImpl
	 * @see delphi.impl.DelphiPackageImpl#gettypeId()
	 * @generated
	 */
	int TYPE_ID = 118;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ID__AST = TYPE__AST;

	/**
	 * The feature id for the '<em><b>Unit Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ID__UNIT_ID = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ID__ID = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>type Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ID_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.identImpl <em>ident</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.identImpl
	 * @see delphi.impl.DelphiPackageImpl#getident()
	 * @generated
	 */
	int IDENT = 119;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENT__AST = CS_TRACE__AST;

	/**
	 * The number of structural features of the '<em>ident</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENT_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.reservedWordImpl <em>reserved Word</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.reservedWordImpl
	 * @see delphi.impl.DelphiPackageImpl#getreservedWord()
	 * @generated
	 */
	int RESERVED_WORD = 120;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_WORD__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_WORD__ID = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>reserved Word</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_WORD_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.constExprImpl <em>const Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.constExprImpl
	 * @see delphi.impl.DelphiPackageImpl#getconstExpr()
	 * @generated
	 */
	int CONST_EXPR = 121;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_EXPR__AST = CS_TRACE__AST;

	/**
	 * The number of structural features of the '<em>const Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_EXPR_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.recordConstExprImpl <em>record Const Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.recordConstExprImpl
	 * @see delphi.impl.DelphiPackageImpl#getrecordConstExpr()
	 * @generated
	 */
	int RECORD_CONST_EXPR = 122;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CONST_EXPR__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CONST_EXPR__ID = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Const Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CONST_EXPR__CONST_EXP = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>record Const Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CONST_EXPR_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.unitIdImpl <em>unit Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.unitIdImpl
	 * @see delphi.impl.DelphiPackageImpl#getunitId()
	 * @generated
	 */
	int UNIT_ID = 123;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_ID__AST = CS_TRACE__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_ID__ID = CS_TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>unit Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_ID_FEATURE_COUNT = CS_TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.relExpImpl <em>rel Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.relExpImpl
	 * @see delphi.impl.DelphiPackageImpl#getrelExp()
	 * @generated
	 */
	int REL_EXP = 124;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_EXP__AST = EXPRESSION__AST;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_EXP__LEFT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rel Op</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_EXP__REL_OP = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_EXP__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>rel Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link delphi.impl.addExpImpl <em>add Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.addExpImpl
	 * @see delphi.impl.DelphiPackageImpl#getaddExp()
	 * @generated
	 */
	int ADD_EXP = 125;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_EXP__AST = SIMPLE_EXPRESSION__AST;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_EXP__LEFT = SIMPLE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Add Op</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_EXP__ADD_OP = SIMPLE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_EXP__RIGHT = SIMPLE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>add Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_EXP_FEATURE_COUNT = SIMPLE_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link delphi.impl.multExpImpl <em>mult Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.multExpImpl
	 * @see delphi.impl.DelphiPackageImpl#getmultExp()
	 * @generated
	 */
	int MULT_EXP = 126;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULT_EXP__AST = TERM__AST;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULT_EXP__LEFT = TERM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mult Op</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULT_EXP__MULT_OP = TERM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULT_EXP__RIGHT = TERM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>mult Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULT_EXP_FEATURE_COUNT = TERM_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link delphi.impl.simpleFactorImpl <em>simple Factor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.simpleFactorImpl
	 * @see delphi.impl.DelphiPackageImpl#getsimpleFactor()
	 * @generated
	 */
	int SIMPLE_FACTOR = 127;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_FACTOR__AST = FACTOR__AST;

	/**
	 * The feature id for the '<em><b>Designator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_FACTOR__DESIGNATOR = FACTOR__DESIGNATOR;

	/**
	 * The feature id for the '<em><b>Exp List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_FACTOR__EXP_LIST = FACTOR__EXP_LIST;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_FACTOR__NUMBER = FACTOR__NUMBER;

	/**
	 * The feature id for the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_FACTOR__STRING = FACTOR__STRING;

	/**
	 * The feature id for the '<em><b>Nested Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_FACTOR__NESTED_EXP = FACTOR__NESTED_EXP;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_FACTOR__EXP = FACTOR__EXP;

	/**
	 * The feature id for the '<em><b>Set Constuctor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_FACTOR__SET_CONSTUCTOR = FACTOR__SET_CONSTUCTOR;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_FACTOR__TYPE_REF = FACTOR__TYPE_REF;

	/**
	 * The number of structural features of the '<em>simple Factor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_FACTOR_FEATURE_COUNT = FACTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.assignmentStmntImpl <em>assignment Stmnt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.assignmentStmntImpl
	 * @see delphi.impl.DelphiPackageImpl#getassignmentStmnt()
	 * @generated
	 */
	int ASSIGNMENT_STMNT = 128;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_STMNT__AST = SIMPLE_STATEMENT__AST;

	/**
	 * The feature id for the '<em><b>Designator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_STMNT__DESIGNATOR = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_STMNT__OPERATOR = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_STMNT__EXP = SIMPLE_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>assignment Stmnt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_STMNT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link delphi.impl.callStmntImpl <em>call Stmnt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.callStmntImpl
	 * @see delphi.impl.DelphiPackageImpl#getcallStmnt()
	 * @generated
	 */
	int CALL_STMNT = 129;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STMNT__AST = SIMPLE_STATEMENT__AST;

	/**
	 * The feature id for the '<em><b>Designator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STMNT__DESIGNATOR = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Args</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STMNT__ARGS = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>call Stmnt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STMNT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.inheritedStamntImpl <em>inherited Stamnt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.inheritedStamntImpl
	 * @see delphi.impl.DelphiPackageImpl#getinheritedStamnt()
	 * @generated
	 */
	int INHERITED_STAMNT = 130;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INHERITED_STAMNT__AST = SIMPLE_STATEMENT__AST;

	/**
	 * The number of structural features of the '<em>inherited Stamnt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INHERITED_STAMNT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link delphi.impl.gotoStmntImpl <em>goto Stmnt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.gotoStmntImpl
	 * @see delphi.impl.DelphiPackageImpl#getgotoStmnt()
	 * @generated
	 */
	int GOTO_STMNT = 131;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_STMNT__AST = SIMPLE_STATEMENT__AST;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_STMNT__LABEL = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>goto Stmnt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_STMNT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.parameterListImpl <em>parameter List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.parameterListImpl
	 * @see delphi.impl.DelphiPackageImpl#getparameterList()
	 * @generated
	 */
	int PARAMETER_LIST = 132;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_LIST__AST = PARAMETER__AST;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_LIST__TYPE = PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>Id List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_LIST__ID_LIST = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>parameter List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_LIST_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.parameterSimpleImpl <em>parameter Simple</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.parameterSimpleImpl
	 * @see delphi.impl.DelphiPackageImpl#getparameterSimple()
	 * @generated
	 */
	int PARAMETER_SIMPLE = 133;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_SIMPLE__AST = PARAMETER__AST;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_SIMPLE__TYPE = PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>If</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_SIMPLE__IF = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Init Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_SIMPLE__INIT_EXP = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>parameter Simple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_SIMPLE_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.MultipleIdImpl <em>Multiple Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.MultipleIdImpl
	 * @see delphi.impl.DelphiPackageImpl#getMultipleId()
	 * @generated
	 */
	int MULTIPLE_ID = 134;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_ID__AST = IDENT__AST;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_ID__ID = IDENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Multiple Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_ID_FEATURE_COUNT = IDENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.ReservedIdImpl <em>Reserved Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.ReservedIdImpl
	 * @see delphi.impl.DelphiPackageImpl#getReservedId()
	 * @generated
	 */
	int RESERVED_ID = 135;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_ID__AST = IDENT__AST;

	/**
	 * The feature id for the '<em><b>Reserved Word</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_ID__RESERVED_WORD = IDENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reserved Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_ID_FEATURE_COUNT = IDENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.MineIDImpl <em>Mine ID</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.MineIDImpl
	 * @see delphi.impl.DelphiPackageImpl#getMineID()
	 * @generated
	 */
	int MINE_ID = 136;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINE_ID__AST = IDENT__AST;

	/**
	 * The feature id for the '<em><b>First</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINE_ID__FIRST = IDENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Second</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINE_ID__SECOND = IDENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mine ID</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINE_ID_FEATURE_COUNT = IDENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link delphi.impl.ConstExpImpl <em>Const Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.ConstExpImpl
	 * @see delphi.impl.DelphiPackageImpl#getConstExp()
	 * @generated
	 */
	int CONST_EXP = 137;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_EXP__AST = CONST_EXPR__AST;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_EXP__EXP = CONST_EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Const Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_EXP_FEATURE_COUNT = CONST_EXPR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.MultipleConstExpImpl <em>Multiple Const Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.MultipleConstExpImpl
	 * @see delphi.impl.DelphiPackageImpl#getMultipleConstExp()
	 * @generated
	 */
	int MULTIPLE_CONST_EXP = 138;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_CONST_EXP__AST = CONST_EXPR__AST;

	/**
	 * The feature id for the '<em><b>Exps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_CONST_EXP__EXPS = CONST_EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Multiple Const Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_CONST_EXP_FEATURE_COUNT = CONST_EXPR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link delphi.impl.RecordConstExpImpl <em>Record Const Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see delphi.impl.RecordConstExpImpl
	 * @see delphi.impl.DelphiPackageImpl#getRecordConstExp()
	 * @generated
	 */
	int RECORD_CONST_EXP = 139;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CONST_EXP__AST = CONST_EXPR__AST;

	/**
	 * The feature id for the '<em><b>Exps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CONST_EXP__EXPS = CONST_EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Record Const Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_CONST_EXP_FEATURE_COUNT = CONST_EXPR_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link delphi.mainRule <em>main Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>main Rule</em>'.
	 * @see delphi.mainRule
	 * @generated
	 */
	EClass getmainRule();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.mainRule#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File</em>'.
	 * @see delphi.mainRule#getFile()
	 * @see #getmainRule()
	 * @generated
	 */
	EReference getmainRule_File();

	/**
	 * Returns the meta object for class '{@link delphi.file <em>file</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>file</em>'.
	 * @see delphi.file
	 * @generated
	 */
	EClass getfile();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.file#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id</em>'.
	 * @see delphi.file#getId()
	 * @see #getfile()
	 * @generated
	 */
	EReference getfile_Id();

	/**
	 * Returns the meta object for class '{@link delphi.program <em>program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>program</em>'.
	 * @see delphi.program
	 * @generated
	 */
	EClass getprogram();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.program#getParamsList <em>Params List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Params List</em>'.
	 * @see delphi.program#getParamsList()
	 * @see #getprogram()
	 * @generated
	 */
	EReference getprogram_ParamsList();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.program#getBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Block</em>'.
	 * @see delphi.program#getBlock()
	 * @see #getprogram()
	 * @generated
	 */
	EReference getprogram_Block();

	/**
	 * Returns the meta object for class '{@link delphi.unit <em>unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>unit</em>'.
	 * @see delphi.unit
	 * @generated
	 */
	EClass getunit();

	/**
	 * Returns the meta object for the attribute '{@link delphi.unit#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see delphi.unit#getPort()
	 * @see #getunit()
	 * @generated
	 */
	EAttribute getunit_Port();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.unit#getInterfaceSect <em>Interface Sect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Interface Sect</em>'.
	 * @see delphi.unit#getInterfaceSect()
	 * @see #getunit()
	 * @generated
	 */
	EReference getunit_InterfaceSect();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.unit#getImplementationSect <em>Implementation Sect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Implementation Sect</em>'.
	 * @see delphi.unit#getImplementationSect()
	 * @see #getunit()
	 * @generated
	 */
	EReference getunit_ImplementationSect();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.unit#getInitSect <em>Init Sect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init Sect</em>'.
	 * @see delphi.unit#getInitSect()
	 * @see #getunit()
	 * @generated
	 */
	EReference getunit_InitSect();

	/**
	 * Returns the meta object for class '{@link delphi.packageDecl <em>package Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>package Decl</em>'.
	 * @see delphi.packageDecl
	 * @generated
	 */
	EClass getpackageDecl();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.packageDecl#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Requires</em>'.
	 * @see delphi.packageDecl#getRequires()
	 * @see #getpackageDecl()
	 * @generated
	 */
	EReference getpackageDecl_Requires();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.packageDecl#getContains <em>Contains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Contains</em>'.
	 * @see delphi.packageDecl#getContains()
	 * @see #getpackageDecl()
	 * @generated
	 */
	EReference getpackageDecl_Contains();

	/**
	 * Returns the meta object for class '{@link delphi.library <em>library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>library</em>'.
	 * @see delphi.library
	 * @generated
	 */
	EClass getlibrary();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.library#getPBlock <em>PBlock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>PBlock</em>'.
	 * @see delphi.library#getPBlock()
	 * @see #getlibrary()
	 * @generated
	 */
	EReference getlibrary_PBlock();

	/**
	 * Returns the meta object for class '{@link delphi.programBlock <em>program Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>program Block</em>'.
	 * @see delphi.programBlock
	 * @generated
	 */
	EClass getprogramBlock();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.programBlock#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Uses</em>'.
	 * @see delphi.programBlock#getUses()
	 * @see #getprogramBlock()
	 * @generated
	 */
	EReference getprogramBlock_Uses();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.programBlock#getBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Block</em>'.
	 * @see delphi.programBlock#getBlock()
	 * @see #getprogramBlock()
	 * @generated
	 */
	EReference getprogramBlock_Block();

	/**
	 * Returns the meta object for class '{@link delphi.usesClause <em>uses Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>uses Clause</em>'.
	 * @see delphi.usesClause
	 * @generated
	 */
	EClass getusesClause();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.usesClause#getIdList <em>Id List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id List</em>'.
	 * @see delphi.usesClause#getIdList()
	 * @see #getusesClause()
	 * @generated
	 */
	EReference getusesClause_IdList();

	/**
	 * Returns the meta object for class '{@link delphi.interfaceSection <em>interface Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>interface Section</em>'.
	 * @see delphi.interfaceSection
	 * @generated
	 */
	EClass getinterfaceSection();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.interfaceSection#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Uses</em>'.
	 * @see delphi.interfaceSection#getUses()
	 * @see #getinterfaceSection()
	 * @generated
	 */
	EReference getinterfaceSection_Uses();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.interfaceSection#getInterfaceDecl <em>Interface Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Interface Decl</em>'.
	 * @see delphi.interfaceSection#getInterfaceDecl()
	 * @see #getinterfaceSection()
	 * @generated
	 */
	EReference getinterfaceSection_InterfaceDecl();

	/**
	 * Returns the meta object for class '{@link delphi.interfaceDecl <em>interface Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>interface Decl</em>'.
	 * @see delphi.interfaceDecl
	 * @generated
	 */
	EClass getinterfaceDecl();

	/**
	 * Returns the meta object for class '{@link delphi.exportedHeading <em>exported Heading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>exported Heading</em>'.
	 * @see delphi.exportedHeading
	 * @generated
	 */
	EClass getexportedHeading();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.exportedHeading#getPHeading <em>PHeading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>PHeading</em>'.
	 * @see delphi.exportedHeading#getPHeading()
	 * @see #getexportedHeading()
	 * @generated
	 */
	EReference getexportedHeading_PHeading();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.exportedHeading#getDirective <em>Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Directive</em>'.
	 * @see delphi.exportedHeading#getDirective()
	 * @see #getexportedHeading()
	 * @generated
	 */
	EReference getexportedHeading_Directive();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.exportedHeading#getFHeading <em>FHeading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FHeading</em>'.
	 * @see delphi.exportedHeading#getFHeading()
	 * @see #getexportedHeading()
	 * @generated
	 */
	EReference getexportedHeading_FHeading();

	/**
	 * Returns the meta object for class '{@link delphi.implementationSection <em>implementation Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>implementation Section</em>'.
	 * @see delphi.implementationSection
	 * @generated
	 */
	EClass getimplementationSection();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.implementationSection#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Uses</em>'.
	 * @see delphi.implementationSection#getUses()
	 * @see #getimplementationSection()
	 * @generated
	 */
	EReference getimplementationSection_Uses();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.implementationSection#getDeclSect <em>Decl Sect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Decl Sect</em>'.
	 * @see delphi.implementationSection#getDeclSect()
	 * @see #getimplementationSection()
	 * @generated
	 */
	EReference getimplementationSection_DeclSect();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.implementationSection#getExports <em>Exports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exports</em>'.
	 * @see delphi.implementationSection#getExports()
	 * @see #getimplementationSection()
	 * @generated
	 */
	EReference getimplementationSection_Exports();

	/**
	 * Returns the meta object for class '{@link delphi.block <em>block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>block</em>'.
	 * @see delphi.block
	 * @generated
	 */
	EClass getblock();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.block#getDeclSect <em>Decl Sect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Decl Sect</em>'.
	 * @see delphi.block#getDeclSect()
	 * @see #getblock()
	 * @generated
	 */
	EReference getblock_DeclSect();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.block#getExports <em>Exports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exports</em>'.
	 * @see delphi.block#getExports()
	 * @see #getblock()
	 * @generated
	 */
	EReference getblock_Exports();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.block#getCompound <em>Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compound</em>'.
	 * @see delphi.block#getCompound()
	 * @see #getblock()
	 * @generated
	 */
	EReference getblock_Compound();

	/**
	 * Returns the meta object for class '{@link delphi.exportsItem <em>exports Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>exports Item</em>'.
	 * @see delphi.exportsItem
	 * @generated
	 */
	EClass getexportsItem();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.exportsItem#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id</em>'.
	 * @see delphi.exportsItem#getId()
	 * @see #getexportsItem()
	 * @generated
	 */
	EReference getexportsItem_Id();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.exportsItem#getConstExp <em>Const Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Const Exp</em>'.
	 * @see delphi.exportsItem#getConstExp()
	 * @see #getexportsItem()
	 * @generated
	 */
	EReference getexportsItem_ConstExp();

	/**
	 * Returns the meta object for class '{@link delphi.exportsStmt <em>exports Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>exports Stmt</em>'.
	 * @see delphi.exportsStmt
	 * @generated
	 */
	EClass getexportsStmt();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.exportsStmt#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see delphi.exportsStmt#getItems()
	 * @see #getexportsStmt()
	 * @generated
	 */
	EReference getexportsStmt_Items();

	/**
	 * Returns the meta object for class '{@link delphi.declSection <em>decl Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>decl Section</em>'.
	 * @see delphi.declSection
	 * @generated
	 */
	EClass getdeclSection();

	/**
	 * Returns the meta object for class '{@link delphi.labelDeclSection <em>label Decl Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>label Decl Section</em>'.
	 * @see delphi.labelDeclSection
	 * @generated
	 */
	EClass getlabelDeclSection();

	/**
	 * Returns the meta object for the attribute '{@link delphi.labelDeclSection#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see delphi.labelDeclSection#getId()
	 * @see #getlabelDeclSection()
	 * @generated
	 */
	EAttribute getlabelDeclSection_Id();

	/**
	 * Returns the meta object for class '{@link delphi.constSection <em>const Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>const Section</em>'.
	 * @see delphi.constSection
	 * @generated
	 */
	EClass getconstSection();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.constSection#getConstantDecl <em>Constant Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constant Decl</em>'.
	 * @see delphi.constSection#getConstantDecl()
	 * @see #getconstSection()
	 * @generated
	 */
	EReference getconstSection_ConstantDecl();

	/**
	 * Returns the meta object for class '{@link delphi.constantDecl <em>constant Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>constant Decl</em>'.
	 * @see delphi.constantDecl
	 * @generated
	 */
	EClass getconstantDecl();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.constantDecl#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id</em>'.
	 * @see delphi.constantDecl#getId()
	 * @see #getconstantDecl()
	 * @generated
	 */
	EReference getconstantDecl_Id();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.constantDecl#getConst <em>Const</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Const</em>'.
	 * @see delphi.constantDecl#getConst()
	 * @see #getconstantDecl()
	 * @generated
	 */
	EReference getconstantDecl_Const();

	/**
	 * Returns the meta object for the attribute '{@link delphi.constantDecl#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see delphi.constantDecl#getPort()
	 * @see #getconstantDecl()
	 * @generated
	 */
	EAttribute getconstantDecl_Port();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.constantDecl#getTypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Ref</em>'.
	 * @see delphi.constantDecl#getTypeRef()
	 * @see #getconstantDecl()
	 * @generated
	 */
	EReference getconstantDecl_TypeRef();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.constantDecl#getTypedConstat <em>Typed Constat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Typed Constat</em>'.
	 * @see delphi.constantDecl#getTypedConstat()
	 * @see #getconstantDecl()
	 * @generated
	 */
	EReference getconstantDecl_TypedConstat();

	/**
	 * Returns the meta object for class '{@link delphi.typeSection <em>type Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>type Section</em>'.
	 * @see delphi.typeSection
	 * @generated
	 */
	EClass gettypeSection();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.typeSection#getTypeDecl <em>Type Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Decl</em>'.
	 * @see delphi.typeSection#getTypeDecl()
	 * @see #gettypeSection()
	 * @generated
	 */
	EReference gettypeSection_TypeDecl();

	/**
	 * Returns the meta object for class '{@link delphi.typeDecl <em>type Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>type Decl</em>'.
	 * @see delphi.typeDecl
	 * @generated
	 */
	EClass gettypeDecl();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.typeDecl#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id</em>'.
	 * @see delphi.typeDecl#getId()
	 * @see #gettypeDecl()
	 * @generated
	 */
	EReference gettypeDecl_Id();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.typeDecl#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see delphi.typeDecl#getType()
	 * @see #gettypeDecl()
	 * @generated
	 */
	EReference gettypeDecl_Type();

	/**
	 * Returns the meta object for the attribute '{@link delphi.typeDecl#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see delphi.typeDecl#getPort()
	 * @see #gettypeDecl()
	 * @generated
	 */
	EAttribute gettypeDecl_Port();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.typeDecl#getRestrictedType <em>Restricted Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Restricted Type</em>'.
	 * @see delphi.typeDecl#getRestrictedType()
	 * @see #gettypeDecl()
	 * @generated
	 */
	EReference gettypeDecl_RestrictedType();

	/**
	 * Returns the meta object for class '{@link delphi.typedConstant <em>typed Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>typed Constant</em>'.
	 * @see delphi.typedConstant
	 * @generated
	 */
	EClass gettypedConstant();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.typedConstant#getConst <em>Const</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Const</em>'.
	 * @see delphi.typedConstant#getConst()
	 * @see #gettypedConstant()
	 * @generated
	 */
	EReference gettypedConstant_Const();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.typedConstant#getArray <em>Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Array</em>'.
	 * @see delphi.typedConstant#getArray()
	 * @see #gettypedConstant()
	 * @generated
	 */
	EReference gettypedConstant_Array();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.typedConstant#getRecord <em>Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Record</em>'.
	 * @see delphi.typedConstant#getRecord()
	 * @see #gettypedConstant()
	 * @generated
	 */
	EReference gettypedConstant_Record();

	/**
	 * Returns the meta object for class '{@link delphi.arrayConstant <em>array Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>array Constant</em>'.
	 * @see delphi.arrayConstant
	 * @generated
	 */
	EClass getarrayConstant();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.arrayConstant#getTypedConstant <em>Typed Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Typed Constant</em>'.
	 * @see delphi.arrayConstant#getTypedConstant()
	 * @see #getarrayConstant()
	 * @generated
	 */
	EReference getarrayConstant_TypedConstant();

	/**
	 * Returns the meta object for class '{@link delphi.recordConstant <em>record Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>record Constant</em>'.
	 * @see delphi.recordConstant
	 * @generated
	 */
	EClass getrecordConstant();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.recordConstant#getRecordField <em>Record Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Record Field</em>'.
	 * @see delphi.recordConstant#getRecordField()
	 * @see #getrecordConstant()
	 * @generated
	 */
	EReference getrecordConstant_RecordField();

	/**
	 * Returns the meta object for class '{@link delphi.recordFieldConstant <em>record Field Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>record Field Constant</em>'.
	 * @see delphi.recordFieldConstant
	 * @generated
	 */
	EClass getrecordFieldConstant();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.recordFieldConstant#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id</em>'.
	 * @see delphi.recordFieldConstant#getId()
	 * @see #getrecordFieldConstant()
	 * @generated
	 */
	EReference getrecordFieldConstant_Id();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.recordFieldConstant#getTypedConstant <em>Typed Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Typed Constant</em>'.
	 * @see delphi.recordFieldConstant#getTypedConstant()
	 * @see #getrecordFieldConstant()
	 * @generated
	 */
	EReference getrecordFieldConstant_TypedConstant();

	/**
	 * Returns the meta object for class '{@link delphi.type <em>type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>type</em>'.
	 * @see delphi.type
	 * @generated
	 */
	EClass gettype();

	/**
	 * Returns the meta object for class '{@link delphi.restrictedType <em>restricted Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>restricted Type</em>'.
	 * @see delphi.restrictedType
	 * @generated
	 */
	EClass getrestrictedType();

	/**
	 * Returns the meta object for class '{@link delphi.classRefType <em>class Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>class Ref Type</em>'.
	 * @see delphi.classRefType
	 * @generated
	 */
	EClass getclassRefType();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.classRefType#getTypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Ref</em>'.
	 * @see delphi.classRefType#getTypeRef()
	 * @see #getclassRefType()
	 * @generated
	 */
	EReference getclassRefType_TypeRef();

	/**
	 * Returns the meta object for class '{@link delphi.simpleType <em>simple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>simple Type</em>'.
	 * @see delphi.simpleType
	 * @generated
	 */
	EClass getsimpleType();

	/**
	 * Returns the meta object for class '{@link delphi.realType <em>real Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>real Type</em>'.
	 * @see delphi.realType
	 * @generated
	 */
	EClass getrealType();

	/**
	 * Returns the meta object for class '{@link delphi.ordinalType <em>ordinal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ordinal Type</em>'.
	 * @see delphi.ordinalType
	 * @generated
	 */
	EClass getordinalType();

	/**
	 * Returns the meta object for class '{@link delphi.ordIdent <em>ord Ident</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ord Ident</em>'.
	 * @see delphi.ordIdent
	 * @generated
	 */
	EClass getordIdent();

	/**
	 * Returns the meta object for class '{@link delphi.variantType <em>variant Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant Type</em>'.
	 * @see delphi.variantType
	 * @generated
	 */
	EClass getvariantType();

	/**
	 * Returns the meta object for class '{@link delphi.subrangeType <em>subrange Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>subrange Type</em>'.
	 * @see delphi.subrangeType
	 * @generated
	 */
	EClass getsubrangeType();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.subrangeType#getFirst <em>First</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>First</em>'.
	 * @see delphi.subrangeType#getFirst()
	 * @see #getsubrangeType()
	 * @generated
	 */
	EReference getsubrangeType_First();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.subrangeType#getLast <em>Last</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Last</em>'.
	 * @see delphi.subrangeType#getLast()
	 * @see #getsubrangeType()
	 * @generated
	 */
	EReference getsubrangeType_Last();

	/**
	 * Returns the meta object for class '{@link delphi.enumeratedType <em>enumerated Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>enumerated Type</em>'.
	 * @see delphi.enumeratedType
	 * @generated
	 */
	EClass getenumeratedType();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.enumeratedType#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element</em>'.
	 * @see delphi.enumeratedType#getElement()
	 * @see #getenumeratedType()
	 * @generated
	 */
	EReference getenumeratedType_Element();

	/**
	 * Returns the meta object for class '{@link delphi.enumeratedTypeElement <em>enumerated Type Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>enumerated Type Element</em>'.
	 * @see delphi.enumeratedTypeElement
	 * @generated
	 */
	EClass getenumeratedTypeElement();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.enumeratedTypeElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id</em>'.
	 * @see delphi.enumeratedTypeElement#getId()
	 * @see #getenumeratedTypeElement()
	 * @generated
	 */
	EReference getenumeratedTypeElement_Id();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.enumeratedTypeElement#getLiteralExp <em>Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Literal Exp</em>'.
	 * @see delphi.enumeratedTypeElement#getLiteralExp()
	 * @see #getenumeratedTypeElement()
	 * @generated
	 */
	EReference getenumeratedTypeElement_LiteralExp();

	/**
	 * Returns the meta object for class '{@link delphi.stringType <em>string Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>string Type</em>'.
	 * @see delphi.stringType
	 * @generated
	 */
	EClass getstringType();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.stringType#getConstExp <em>Const Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Const Exp</em>'.
	 * @see delphi.stringType#getConstExp()
	 * @see #getstringType()
	 * @generated
	 */
	EReference getstringType_ConstExp();

	/**
	 * Returns the meta object for class '{@link delphi.strucType <em>struc Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>struc Type</em>'.
	 * @see delphi.strucType
	 * @generated
	 */
	EClass getstrucType();

	/**
	 * Returns the meta object for the attribute '{@link delphi.strucType#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see delphi.strucType#getPort()
	 * @see #getstrucType()
	 * @generated
	 */
	EAttribute getstrucType_Port();

	/**
	 * Returns the meta object for class '{@link delphi.arrayType <em>array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>array Type</em>'.
	 * @see delphi.arrayType
	 * @generated
	 */
	EClass getarrayType();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.arrayType#getOrdinalType <em>Ordinal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ordinal Type</em>'.
	 * @see delphi.arrayType#getOrdinalType()
	 * @see #getarrayType()
	 * @generated
	 */
	EReference getarrayType_OrdinalType();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.arrayType#getOrdinalTyp <em>Ordinal Typ</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ordinal Typ</em>'.
	 * @see delphi.arrayType#getOrdinalTyp()
	 * @see #getarrayType()
	 * @generated
	 */
	EReference getarrayType_OrdinalTyp();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.arrayType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see delphi.arrayType#getType()
	 * @see #getarrayType()
	 * @generated
	 */
	EReference getarrayType_Type();

	/**
	 * Returns the meta object for class '{@link delphi.recType <em>rec Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>rec Type</em>'.
	 * @see delphi.recType
	 * @generated
	 */
	EClass getrecType();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.recType#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Fields</em>'.
	 * @see delphi.recType#getFields()
	 * @see #getrecType()
	 * @generated
	 */
	EReference getrecType_Fields();

	/**
	 * Returns the meta object for class '{@link delphi.fieldList <em>field List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>field List</em>'.
	 * @see delphi.fieldList
	 * @generated
	 */
	EClass getfieldList();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.fieldList#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Field</em>'.
	 * @see delphi.fieldList#getField()
	 * @see #getfieldList()
	 * @generated
	 */
	EReference getfieldList_Field();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.fieldList#getVariantSect <em>Variant Sect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variant Sect</em>'.
	 * @see delphi.fieldList#getVariantSect()
	 * @see #getfieldList()
	 * @generated
	 */
	EReference getfieldList_VariantSect();

	/**
	 * Returns the meta object for class '{@link delphi.fieldDecl <em>field Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>field Decl</em>'.
	 * @see delphi.fieldDecl
	 * @generated
	 */
	EClass getfieldDecl();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.fieldDecl#getIdList <em>Id List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id List</em>'.
	 * @see delphi.fieldDecl#getIdList()
	 * @see #getfieldDecl()
	 * @generated
	 */
	EReference getfieldDecl_IdList();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.fieldDecl#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see delphi.fieldDecl#getType()
	 * @see #getfieldDecl()
	 * @generated
	 */
	EReference getfieldDecl_Type();

	/**
	 * Returns the meta object for the attribute '{@link delphi.fieldDecl#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see delphi.fieldDecl#getPort()
	 * @see #getfieldDecl()
	 * @generated
	 */
	EAttribute getfieldDecl_Port();

	/**
	 * Returns the meta object for class '{@link delphi.variantSection <em>variant Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant Section</em>'.
	 * @see delphi.variantSection
	 * @generated
	 */
	EClass getvariantSection();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.variantSection#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id</em>'.
	 * @see delphi.variantSection#getId()
	 * @see #getvariantSection()
	 * @generated
	 */
	EReference getvariantSection_Id();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.variantSection#getTypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Ref</em>'.
	 * @see delphi.variantSection#getTypeRef()
	 * @see #getvariantSection()
	 * @generated
	 */
	EReference getvariantSection_TypeRef();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.variantSection#getRecVariants <em>Rec Variants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rec Variants</em>'.
	 * @see delphi.variantSection#getRecVariants()
	 * @see #getvariantSection()
	 * @generated
	 */
	EReference getvariantSection_RecVariants();

	/**
	 * Returns the meta object for class '{@link delphi.recVariant <em>rec Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>rec Variant</em>'.
	 * @see delphi.recVariant
	 * @generated
	 */
	EClass getrecVariant();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.recVariant#getConstExp <em>Const Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Const Exp</em>'.
	 * @see delphi.recVariant#getConstExp()
	 * @see #getrecVariant()
	 * @generated
	 */
	EReference getrecVariant_ConstExp();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.recVariant#getFieldList <em>Field List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Field List</em>'.
	 * @see delphi.recVariant#getFieldList()
	 * @see #getrecVariant()
	 * @generated
	 */
	EReference getrecVariant_FieldList();

	/**
	 * Returns the meta object for class '{@link delphi.setType <em>set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>set Type</em>'.
	 * @see delphi.setType
	 * @generated
	 */
	EClass getsetType();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.setType#getOrdinal <em>Ordinal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ordinal</em>'.
	 * @see delphi.setType#getOrdinal()
	 * @see #getsetType()
	 * @generated
	 */
	EReference getsetType_Ordinal();

	/**
	 * Returns the meta object for class '{@link delphi.fileType <em>file Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>file Type</em>'.
	 * @see delphi.fileType
	 * @generated
	 */
	EClass getfileType();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.fileType#getTypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Ref</em>'.
	 * @see delphi.fileType#getTypeRef()
	 * @see #getfileType()
	 * @generated
	 */
	EReference getfileType_TypeRef();

	/**
	 * Returns the meta object for class '{@link delphi.pointerType <em>pointer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>pointer Type</em>'.
	 * @see delphi.pointerType
	 * @generated
	 */
	EClass getpointerType();

	/**
	 * Returns the meta object for class '{@link delphi.procedureType <em>procedure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>procedure Type</em>'.
	 * @see delphi.procedureType
	 * @generated
	 */
	EClass getprocedureType();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.procedureType#getPHeading <em>PHeading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>PHeading</em>'.
	 * @see delphi.procedureType#getPHeading()
	 * @see #getprocedureType()
	 * @generated
	 */
	EReference getprocedureType_PHeading();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.procedureType#getFHeading <em>FHeading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FHeading</em>'.
	 * @see delphi.procedureType#getFHeading()
	 * @see #getprocedureType()
	 * @generated
	 */
	EReference getprocedureType_FHeading();

	/**
	 * Returns the meta object for class '{@link delphi.varSection <em>var Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>var Section</em>'.
	 * @see delphi.varSection
	 * @generated
	 */
	EClass getvarSection();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.varSection#getVarDecls <em>Var Decls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Var Decls</em>'.
	 * @see delphi.varSection#getVarDecls()
	 * @see #getvarSection()
	 * @generated
	 */
	EReference getvarSection_VarDecls();

	/**
	 * Returns the meta object for class '{@link delphi.varDecl <em>var Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>var Decl</em>'.
	 * @see delphi.varDecl
	 * @generated
	 */
	EClass getvarDecl();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.varDecl#getIdList <em>Id List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id List</em>'.
	 * @see delphi.varDecl#getIdList()
	 * @see #getvarDecl()
	 * @generated
	 */
	EReference getvarDecl_IdList();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.varDecl#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see delphi.varDecl#getType()
	 * @see #getvarDecl()
	 * @generated
	 */
	EReference getvarDecl_Type();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.varDecl#getAbsId <em>Abs Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Abs Id</em>'.
	 * @see delphi.varDecl#getAbsId()
	 * @see #getvarDecl()
	 * @generated
	 */
	EReference getvarDecl_AbsId();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.varDecl#getAbsConst <em>Abs Const</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Abs Const</em>'.
	 * @see delphi.varDecl#getAbsConst()
	 * @see #getvarDecl()
	 * @generated
	 */
	EReference getvarDecl_AbsConst();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.varDecl#getAbsIniti <em>Abs Initi</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Abs Initi</em>'.
	 * @see delphi.varDecl#getAbsIniti()
	 * @see #getvarDecl()
	 * @generated
	 */
	EReference getvarDecl_AbsIniti();

	/**
	 * Returns the meta object for class '{@link delphi.expression <em>expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>expression</em>'.
	 * @see delphi.expression
	 * @generated
	 */
	EClass getexpression();

	/**
	 * Returns the meta object for class '{@link delphi.simpleExpression <em>simple Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>simple Expression</em>'.
	 * @see delphi.simpleExpression
	 * @generated
	 */
	EClass getsimpleExpression();

	/**
	 * Returns the meta object for class '{@link delphi.term <em>term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>term</em>'.
	 * @see delphi.term
	 * @generated
	 */
	EClass getterm();

	/**
	 * Returns the meta object for class '{@link delphi.factor <em>factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>factor</em>'.
	 * @see delphi.factor
	 * @generated
	 */
	EClass getfactor();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.factor#getDesignator <em>Designator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Designator</em>'.
	 * @see delphi.factor#getDesignator()
	 * @see #getfactor()
	 * @generated
	 */
	EReference getfactor_Designator();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.factor#getExpList <em>Exp List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exp List</em>'.
	 * @see delphi.factor#getExpList()
	 * @see #getfactor()
	 * @generated
	 */
	EReference getfactor_ExpList();

	/**
	 * Returns the meta object for the attribute '{@link delphi.factor#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see delphi.factor#getNumber()
	 * @see #getfactor()
	 * @generated
	 */
	EAttribute getfactor_Number();

	/**
	 * Returns the meta object for the attribute '{@link delphi.factor#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String</em>'.
	 * @see delphi.factor#getString()
	 * @see #getfactor()
	 * @generated
	 */
	EAttribute getfactor_String();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.factor#getNestedExp <em>Nested Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Nested Exp</em>'.
	 * @see delphi.factor#getNestedExp()
	 * @see #getfactor()
	 * @generated
	 */
	EReference getfactor_NestedExp();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.factor#getExp <em>Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exp</em>'.
	 * @see delphi.factor#getExp()
	 * @see #getfactor()
	 * @generated
	 */
	EReference getfactor_Exp();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.factor#getSetConstuctor <em>Set Constuctor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Set Constuctor</em>'.
	 * @see delphi.factor#getSetConstuctor()
	 * @see #getfactor()
	 * @generated
	 */
	EReference getfactor_SetConstuctor();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.factor#getTypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Ref</em>'.
	 * @see delphi.factor#getTypeRef()
	 * @see #getfactor()
	 * @generated
	 */
	EReference getfactor_TypeRef();

	/**
	 * Returns the meta object for class '{@link delphi.relOp <em>rel Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>rel Op</em>'.
	 * @see delphi.relOp
	 * @generated
	 */
	EClass getrelOp();

	/**
	 * Returns the meta object for the attribute '{@link delphi.relOp#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see delphi.relOp#getOp()
	 * @see #getrelOp()
	 * @generated
	 */
	EAttribute getrelOp_Op();

	/**
	 * Returns the meta object for class '{@link delphi.addOp <em>add Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>add Op</em>'.
	 * @see delphi.addOp
	 * @generated
	 */
	EClass getaddOp();

	/**
	 * Returns the meta object for the attribute '{@link delphi.addOp#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see delphi.addOp#getOp()
	 * @see #getaddOp()
	 * @generated
	 */
	EAttribute getaddOp_Op();

	/**
	 * Returns the meta object for class '{@link delphi.mulOp <em>mul Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>mul Op</em>'.
	 * @see delphi.mulOp
	 * @generated
	 */
	EClass getmulOp();

	/**
	 * Returns the meta object for the attribute '{@link delphi.mulOp#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see delphi.mulOp#getOp()
	 * @see #getmulOp()
	 * @generated
	 */
	EAttribute getmulOp_Op();

	/**
	 * Returns the meta object for class '{@link delphi.designator <em>designator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>designator</em>'.
	 * @see delphi.designator
	 * @generated
	 */
	EClass getdesignator();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.designator#getSubpart <em>Subpart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Subpart</em>'.
	 * @see delphi.designator#getSubpart()
	 * @see #getdesignator()
	 * @generated
	 */
	EReference getdesignator_Subpart();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.designator#getDesignator <em>Designator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Designator</em>'.
	 * @see delphi.designator#getDesignator()
	 * @see #getdesignator()
	 * @generated
	 */
	EReference getdesignator_Designator();

	/**
	 * Returns the meta object for class '{@link delphi.designatorSubPart <em>designator Sub Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>designator Sub Part</em>'.
	 * @see delphi.designatorSubPart
	 * @generated
	 */
	EClass getdesignatorSubPart();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.designatorSubPart#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Part</em>'.
	 * @see delphi.designatorSubPart#getPart()
	 * @see #getdesignatorSubPart()
	 * @generated
	 */
	EReference getdesignatorSubPart_Part();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.designatorSubPart#getExprList <em>Expr List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expr List</em>'.
	 * @see delphi.designatorSubPart#getExprList()
	 * @see #getdesignatorSubPart()
	 * @generated
	 */
	EReference getdesignatorSubPart_ExprList();

	/**
	 * Returns the meta object for class '{@link delphi.designatorPart <em>designator Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>designator Part</em>'.
	 * @see delphi.designatorPart
	 * @generated
	 */
	EClass getdesignatorPart();

	/**
	 * Returns the meta object for the attribute '{@link delphi.designatorPart#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see delphi.designatorPart#getId()
	 * @see #getdesignatorPart()
	 * @generated
	 */
	EAttribute getdesignatorPart_Id();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.designatorPart#getReservedWord <em>Reserved Word</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reserved Word</em>'.
	 * @see delphi.designatorPart#getReservedWord()
	 * @see #getdesignatorPart()
	 * @generated
	 */
	EReference getdesignatorPart_ReservedWord();

	/**
	 * Returns the meta object for the attribute '{@link delphi.designatorPart#getId2 <em>Id2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id2</em>'.
	 * @see delphi.designatorPart#getId2()
	 * @see #getdesignatorPart()
	 * @generated
	 */
	EAttribute getdesignatorPart_Id2();

	/**
	 * Returns the meta object for class '{@link delphi.setConstructor <em>set Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>set Constructor</em>'.
	 * @see delphi.setConstructor
	 * @generated
	 */
	EClass getsetConstructor();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.setConstructor#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element</em>'.
	 * @see delphi.setConstructor#getElement()
	 * @see #getsetConstructor()
	 * @generated
	 */
	EReference getsetConstructor_Element();

	/**
	 * Returns the meta object for class '{@link delphi.setElement <em>set Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>set Element</em>'.
	 * @see delphi.setElement
	 * @generated
	 */
	EClass getsetElement();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.setElement#getFirst <em>First</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>First</em>'.
	 * @see delphi.setElement#getFirst()
	 * @see #getsetElement()
	 * @generated
	 */
	EReference getsetElement_First();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.setElement#getLast <em>Last</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Last</em>'.
	 * @see delphi.setElement#getLast()
	 * @see #getsetElement()
	 * @generated
	 */
	EReference getsetElement_Last();

	/**
	 * Returns the meta object for class '{@link delphi.exprList <em>expr List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>expr List</em>'.
	 * @see delphi.exprList
	 * @generated
	 */
	EClass getexprList();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.exprList#getExps <em>Exps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exps</em>'.
	 * @see delphi.exprList#getExps()
	 * @see #getexprList()
	 * @generated
	 */
	EReference getexprList_Exps();

	/**
	 * Returns the meta object for class '{@link delphi.stmtList <em>stmt List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>stmt List</em>'.
	 * @see delphi.stmtList
	 * @generated
	 */
	EClass getstmtList();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.stmtList#getStatments <em>Statments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statments</em>'.
	 * @see delphi.stmtList#getStatments()
	 * @see #getstmtList()
	 * @generated
	 */
	EReference getstmtList_Statments();

	/**
	 * Returns the meta object for class '{@link delphi.statement <em>statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>statement</em>'.
	 * @see delphi.statement
	 * @generated
	 */
	EClass getstatement();

	/**
	 * Returns the meta object for the attribute '{@link delphi.statement#getLabelId <em>Label Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label Id</em>'.
	 * @see delphi.statement#getLabelId()
	 * @see #getstatement()
	 * @generated
	 */
	EAttribute getstatement_LabelId();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.statement#getStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Statement</em>'.
	 * @see delphi.statement#getStatement()
	 * @see #getstatement()
	 * @generated
	 */
	EReference getstatement_Statement();

	/**
	 * Returns the meta object for class '{@link delphi.unlabelledStatement <em>unlabelled Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>unlabelled Statement</em>'.
	 * @see delphi.unlabelledStatement
	 * @generated
	 */
	EClass getunlabelledStatement();

	/**
	 * Returns the meta object for class '{@link delphi.simpleStatement <em>simple Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>simple Statement</em>'.
	 * @see delphi.simpleStatement
	 * @generated
	 */
	EClass getsimpleStatement();

	/**
	 * Returns the meta object for class '{@link delphi.structStmt <em>struct Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>struct Stmt</em>'.
	 * @see delphi.structStmt
	 * @generated
	 */
	EClass getstructStmt();

	/**
	 * Returns the meta object for class '{@link delphi.compoundStmt <em>compound Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>compound Stmt</em>'.
	 * @see delphi.compoundStmt
	 * @generated
	 */
	EClass getcompoundStmt();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.compoundStmt#getStamtList <em>Stamt List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stamt List</em>'.
	 * @see delphi.compoundStmt#getStamtList()
	 * @see #getcompoundStmt()
	 * @generated
	 */
	EReference getcompoundStmt_StamtList();

	/**
	 * Returns the meta object for class '{@link delphi.conditionalStmt <em>conditional Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>conditional Stmt</em>'.
	 * @see delphi.conditionalStmt
	 * @generated
	 */
	EClass getconditionalStmt();

	/**
	 * Returns the meta object for class '{@link delphi.ifStmt <em>if Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>if Stmt</em>'.
	 * @see delphi.ifStmt
	 * @generated
	 */
	EClass getifStmt();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.ifStmt#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see delphi.ifStmt#getCondition()
	 * @see #getifStmt()
	 * @generated
	 */
	EReference getifStmt_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.ifStmt#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see delphi.ifStmt#getThen()
	 * @see #getifStmt()
	 * @generated
	 */
	EReference getifStmt_Then();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.ifStmt#getElse <em>Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else</em>'.
	 * @see delphi.ifStmt#getElse()
	 * @see #getifStmt()
	 * @generated
	 */
	EReference getifStmt_Else();

	/**
	 * Returns the meta object for class '{@link delphi.caseStmt <em>case Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>case Stmt</em>'.
	 * @see delphi.caseStmt
	 * @generated
	 */
	EClass getcaseStmt();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.caseStmt#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see delphi.caseStmt#getExpression()
	 * @see #getcaseStmt()
	 * @generated
	 */
	EReference getcaseStmt_Expression();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.caseStmt#getCases <em>Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cases</em>'.
	 * @see delphi.caseStmt#getCases()
	 * @see #getcaseStmt()
	 * @generated
	 */
	EReference getcaseStmt_Cases();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.caseStmt#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default</em>'.
	 * @see delphi.caseStmt#getDefault()
	 * @see #getcaseStmt()
	 * @generated
	 */
	EReference getcaseStmt_Default();

	/**
	 * Returns the meta object for class '{@link delphi.caseSelector <em>case Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>case Selector</em>'.
	 * @see delphi.caseSelector
	 * @generated
	 */
	EClass getcaseSelector();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.caseSelector#getLabels <em>Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Labels</em>'.
	 * @see delphi.caseSelector#getLabels()
	 * @see #getcaseSelector()
	 * @generated
	 */
	EReference getcaseSelector_Labels();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.caseSelector#getStmt <em>Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stmt</em>'.
	 * @see delphi.caseSelector#getStmt()
	 * @see #getcaseSelector()
	 * @generated
	 */
	EReference getcaseSelector_Stmt();

	/**
	 * Returns the meta object for class '{@link delphi.caseLabel <em>case Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>case Label</em>'.
	 * @see delphi.caseLabel
	 * @generated
	 */
	EClass getcaseLabel();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.caseLabel#getFirst <em>First</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>First</em>'.
	 * @see delphi.caseLabel#getFirst()
	 * @see #getcaseLabel()
	 * @generated
	 */
	EReference getcaseLabel_First();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.caseLabel#getLast <em>Last</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Last</em>'.
	 * @see delphi.caseLabel#getLast()
	 * @see #getcaseLabel()
	 * @generated
	 */
	EReference getcaseLabel_Last();

	/**
	 * Returns the meta object for class '{@link delphi.loopStmt <em>loop Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>loop Stmt</em>'.
	 * @see delphi.loopStmt
	 * @generated
	 */
	EClass getloopStmt();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.loopStmt#getStmt <em>Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stmt</em>'.
	 * @see delphi.loopStmt#getStmt()
	 * @see #getloopStmt()
	 * @generated
	 */
	EReference getloopStmt_Stmt();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.loopStmt#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see delphi.loopStmt#getCondition()
	 * @see #getloopStmt()
	 * @generated
	 */
	EReference getloopStmt_Condition();

	/**
	 * Returns the meta object for class '{@link delphi.repeatStmt <em>repeat Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>repeat Stmt</em>'.
	 * @see delphi.repeatStmt
	 * @generated
	 */
	EClass getrepeatStmt();

	/**
	 * Returns the meta object for class '{@link delphi.whileStmt <em>while Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>while Stmt</em>'.
	 * @see delphi.whileStmt
	 * @generated
	 */
	EClass getwhileStmt();

	/**
	 * Returns the meta object for class '{@link delphi.forStmt <em>for Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>for Stmt</em>'.
	 * @see delphi.forStmt
	 * @generated
	 */
	EClass getforStmt();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.forStmt#getVarId <em>Var Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Var Id</em>'.
	 * @see delphi.forStmt#getVarId()
	 * @see #getforStmt()
	 * @generated
	 */
	EReference getforStmt_VarId();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.forStmt#getVarInit <em>Var Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Var Init</em>'.
	 * @see delphi.forStmt#getVarInit()
	 * @see #getforStmt()
	 * @generated
	 */
	EReference getforStmt_VarInit();

	/**
	 * Returns the meta object for class '{@link delphi.withStmt <em>with Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>with Stmt</em>'.
	 * @see delphi.withStmt
	 * @generated
	 */
	EClass getwithStmt();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.withStmt#getVars <em>Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Vars</em>'.
	 * @see delphi.withStmt#getVars()
	 * @see #getwithStmt()
	 * @generated
	 */
	EReference getwithStmt_Vars();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.withStmt#getStmt <em>Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stmt</em>'.
	 * @see delphi.withStmt#getStmt()
	 * @see #getwithStmt()
	 * @generated
	 */
	EReference getwithStmt_Stmt();

	/**
	 * Returns the meta object for class '{@link delphi.tryStmt <em>try Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>try Stmt</em>'.
	 * @see delphi.tryStmt
	 * @generated
	 */
	EClass gettryStmt();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.tryStmt#getStmtList <em>Stmt List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stmt List</em>'.
	 * @see delphi.tryStmt#getStmtList()
	 * @see #gettryStmt()
	 * @generated
	 */
	EReference gettryStmt_StmtList();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.tryStmt#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exception</em>'.
	 * @see delphi.tryStmt#getException()
	 * @see #gettryStmt()
	 * @generated
	 */
	EReference gettryStmt_Exception();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.tryStmt#getFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Final</em>'.
	 * @see delphi.tryStmt#getFinal()
	 * @see #gettryStmt()
	 * @generated
	 */
	EReference gettryStmt_Final();

	/**
	 * Returns the meta object for class '{@link delphi.exceptionBlock <em>exception Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>exception Block</em>'.
	 * @see delphi.exceptionBlock
	 * @generated
	 */
	EClass getexceptionBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.exceptionBlock#getExceptionId <em>Exception Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exception Id</em>'.
	 * @see delphi.exceptionBlock#getExceptionId()
	 * @see #getexceptionBlock()
	 * @generated
	 */
	EReference getexceptionBlock_ExceptionId();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.exceptionBlock#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type</em>'.
	 * @see delphi.exceptionBlock#getType()
	 * @see #getexceptionBlock()
	 * @generated
	 */
	EReference getexceptionBlock_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.exceptionBlock#getDoStmt <em>Do Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Do Stmt</em>'.
	 * @see delphi.exceptionBlock#getDoStmt()
	 * @see #getexceptionBlock()
	 * @generated
	 */
	EReference getexceptionBlock_DoStmt();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.exceptionBlock#getElseStmts <em>Else Stmts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Stmts</em>'.
	 * @see delphi.exceptionBlock#getElseStmts()
	 * @see #getexceptionBlock()
	 * @generated
	 */
	EReference getexceptionBlock_ElseStmts();

	/**
	 * Returns the meta object for class '{@link delphi.raiseStmt <em>raise Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>raise Stmt</em>'.
	 * @see delphi.raiseStmt
	 * @generated
	 */
	EClass getraiseStmt();

	/**
	 * Returns the meta object for the attribute '{@link delphi.raiseStmt#getRaise <em>Raise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Raise</em>'.
	 * @see delphi.raiseStmt#getRaise()
	 * @see #getraiseStmt()
	 * @generated
	 */
	EAttribute getraiseStmt_Raise();

	/**
	 * Returns the meta object for the attribute '{@link delphi.raiseStmt#getAt <em>At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>At</em>'.
	 * @see delphi.raiseStmt#getAt()
	 * @see #getraiseStmt()
	 * @generated
	 */
	EAttribute getraiseStmt_At();

	/**
	 * Returns the meta object for class '{@link delphi.assemblerStmt <em>assembler Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>assembler Stmt</em>'.
	 * @see delphi.assemblerStmt
	 * @generated
	 */
	EClass getassemblerStmt();

	/**
	 * Returns the meta object for class '{@link delphi.procedureDeclSection <em>procedure Decl Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>procedure Decl Section</em>'.
	 * @see delphi.procedureDeclSection
	 * @generated
	 */
	EClass getprocedureDeclSection();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.procedureDeclSection#getDirective <em>Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Directive</em>'.
	 * @see delphi.procedureDeclSection#getDirective()
	 * @see #getprocedureDeclSection()
	 * @generated
	 */
	EReference getprocedureDeclSection_Directive();

	/**
	 * Returns the meta object for the attribute '{@link delphi.procedureDeclSection#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see delphi.procedureDeclSection#getPort()
	 * @see #getprocedureDeclSection()
	 * @generated
	 */
	EAttribute getprocedureDeclSection_Port();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.procedureDeclSection#getBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Block</em>'.
	 * @see delphi.procedureDeclSection#getBlock()
	 * @see #getprocedureDeclSection()
	 * @generated
	 */
	EReference getprocedureDeclSection_Block();

	/**
	 * Returns the meta object for class '{@link delphi.procedureDecl <em>procedure Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>procedure Decl</em>'.
	 * @see delphi.procedureDecl
	 * @generated
	 */
	EClass getprocedureDecl();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.procedureDecl#getHeading <em>Heading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Heading</em>'.
	 * @see delphi.procedureDecl#getHeading()
	 * @see #getprocedureDecl()
	 * @generated
	 */
	EReference getprocedureDecl_Heading();

	/**
	 * Returns the meta object for class '{@link delphi.functionDecl <em>function Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>function Decl</em>'.
	 * @see delphi.functionDecl
	 * @generated
	 */
	EClass getfunctionDecl();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.functionDecl#getHeading <em>Heading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Heading</em>'.
	 * @see delphi.functionDecl#getHeading()
	 * @see #getfunctionDecl()
	 * @generated
	 */
	EReference getfunctionDecl_Heading();

	/**
	 * Returns the meta object for class '{@link delphi.functionHeading <em>function Heading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>function Heading</em>'.
	 * @see delphi.functionHeading
	 * @generated
	 */
	EClass getfunctionHeading();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.functionHeading#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see delphi.functionHeading#getType()
	 * @see #getfunctionHeading()
	 * @generated
	 */
	EReference getfunctionHeading_Type();

	/**
	 * Returns the meta object for class '{@link delphi.procedureHeading <em>procedure Heading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>procedure Heading</em>'.
	 * @see delphi.procedureHeading
	 * @generated
	 */
	EClass getprocedureHeading();

	/**
	 * Returns the meta object for class '{@link delphi.formalParameters <em>formal Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>formal Parameters</em>'.
	 * @see delphi.formalParameters
	 * @generated
	 */
	EClass getformalParameters();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.formalParameters#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Params</em>'.
	 * @see delphi.formalParameters#getParams()
	 * @see #getformalParameters()
	 * @generated
	 */
	EReference getformalParameters_Params();

	/**
	 * Returns the meta object for class '{@link delphi.formalParm <em>formal Parm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>formal Parm</em>'.
	 * @see delphi.formalParm
	 * @generated
	 */
	EClass getformalParm();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.formalParm#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Param</em>'.
	 * @see delphi.formalParm#getParam()
	 * @see #getformalParm()
	 * @generated
	 */
	EReference getformalParm_Param();

	/**
	 * Returns the meta object for class '{@link delphi.parameter <em>parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>parameter</em>'.
	 * @see delphi.parameter
	 * @generated
	 */
	EClass getparameter();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.parameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see delphi.parameter#getType()
	 * @see #getparameter()
	 * @generated
	 */
	EReference getparameter_Type();

	/**
	 * Returns the meta object for class '{@link delphi.directive <em>directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>directive</em>'.
	 * @see delphi.directive
	 * @generated
	 */
	EClass getdirective();

	/**
	 * Returns the meta object for the attribute '{@link delphi.directive#getDir <em>Dir</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dir</em>'.
	 * @see delphi.directive#getDir()
	 * @see #getdirective()
	 * @generated
	 */
	EAttribute getdirective_Dir();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.directive#getMessageExp <em>Message Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Message Exp</em>'.
	 * @see delphi.directive#getMessageExp()
	 * @see #getdirective()
	 * @generated
	 */
	EReference getdirective_MessageExp();

	/**
	 * Returns the meta object for class '{@link delphi.objectType <em>object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>object Type</em>'.
	 * @see delphi.objectType
	 * @generated
	 */
	EClass getobjectType();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.objectType#getHeritage <em>Heritage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Heritage</em>'.
	 * @see delphi.objectType#getHeritage()
	 * @see #getobjectType()
	 * @generated
	 */
	EReference getobjectType_Heritage();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.objectType#getFieldList <em>Field List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Field List</em>'.
	 * @see delphi.objectType#getFieldList()
	 * @see #getobjectType()
	 * @generated
	 */
	EReference getobjectType_FieldList();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.objectType#getMethodList <em>Method List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Method List</em>'.
	 * @see delphi.objectType#getMethodList()
	 * @see #getobjectType()
	 * @generated
	 */
	EReference getobjectType_MethodList();

	/**
	 * Returns the meta object for class '{@link delphi.objHeritage <em>obj Heritage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>obj Heritage</em>'.
	 * @see delphi.objHeritage
	 * @generated
	 */
	EClass getobjHeritage();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.objHeritage#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id</em>'.
	 * @see delphi.objHeritage#getId()
	 * @see #getobjHeritage()
	 * @generated
	 */
	EReference getobjHeritage_Id();

	/**
	 * Returns the meta object for class '{@link delphi.methodList <em>method List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>method List</em>'.
	 * @see delphi.methodList
	 * @generated
	 */
	EClass getmethodList();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.methodList#getHeading <em>Heading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Heading</em>'.
	 * @see delphi.methodList#getHeading()
	 * @see #getmethodList()
	 * @generated
	 */
	EReference getmethodList_Heading();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.methodList#getDirective <em>Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Directive</em>'.
	 * @see delphi.methodList#getDirective()
	 * @see #getmethodList()
	 * @generated
	 */
	EReference getmethodList_Directive();

	/**
	 * Returns the meta object for class '{@link delphi.methodHeading <em>method Heading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>method Heading</em>'.
	 * @see delphi.methodHeading
	 * @generated
	 */
	EClass getmethodHeading();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.methodHeading#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id</em>'.
	 * @see delphi.methodHeading#getId()
	 * @see #getmethodHeading()
	 * @generated
	 */
	EReference getmethodHeading_Id();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.methodHeading#getFormalParams <em>Formal Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Formal Params</em>'.
	 * @see delphi.methodHeading#getFormalParams()
	 * @see #getmethodHeading()
	 * @generated
	 */
	EReference getmethodHeading_FormalParams();

	/**
	 * Returns the meta object for class '{@link delphi.constructorHeading <em>constructor Heading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>constructor Heading</em>'.
	 * @see delphi.constructorHeading
	 * @generated
	 */
	EClass getconstructorHeading();

	/**
	 * Returns the meta object for class '{@link delphi.destructorHeading <em>destructor Heading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>destructor Heading</em>'.
	 * @see delphi.destructorHeading
	 * @generated
	 */
	EClass getdestructorHeading();

	/**
	 * Returns the meta object for class '{@link delphi.objFieldList <em>obj Field List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>obj Field List</em>'.
	 * @see delphi.objFieldList
	 * @generated
	 */
	EClass getobjFieldList();

	/**
	 * Returns the meta object for class '{@link delphi.initSection <em>init Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>init Section</em>'.
	 * @see delphi.initSection
	 * @generated
	 */
	EClass getinitSection();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.initSection#getStmtList <em>Stmt List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stmt List</em>'.
	 * @see delphi.initSection#getStmtList()
	 * @see #getinitSection()
	 * @generated
	 */
	EReference getinitSection_StmtList();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.initSection#getEndStmtList <em>End Stmt List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>End Stmt List</em>'.
	 * @see delphi.initSection#getEndStmtList()
	 * @see #getinitSection()
	 * @generated
	 */
	EReference getinitSection_EndStmtList();

	/**
	 * Returns the meta object for class '{@link delphi.classType <em>class Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>class Type</em>'.
	 * @see delphi.classType
	 * @generated
	 */
	EClass getclassType();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.classType#getHeritage <em>Heritage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Heritage</em>'.
	 * @see delphi.classType#getHeritage()
	 * @see #getclassType()
	 * @generated
	 */
	EReference getclassType_Heritage();

	/**
	 * Returns the meta object for the attribute '{@link delphi.classType#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see delphi.classType#getVisibility()
	 * @see #getclassType()
	 * @generated
	 */
	EAttribute getclassType_Visibility();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.classType#getFieldList <em>Field List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Field List</em>'.
	 * @see delphi.classType#getFieldList()
	 * @see #getclassType()
	 * @generated
	 */
	EReference getclassType_FieldList();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.classType#getMethodList <em>Method List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Method List</em>'.
	 * @see delphi.classType#getMethodList()
	 * @see #getclassType()
	 * @generated
	 */
	EReference getclassType_MethodList();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.classType#getPropList <em>Prop List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Prop List</em>'.
	 * @see delphi.classType#getPropList()
	 * @see #getclassType()
	 * @generated
	 */
	EReference getclassType_PropList();

	/**
	 * Returns the meta object for class '{@link delphi.classHeritage <em>class Heritage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>class Heritage</em>'.
	 * @see delphi.classHeritage
	 * @generated
	 */
	EClass getclassHeritage();

	/**
	 * Returns the meta object for class '{@link delphi.classFieldList <em>class Field List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>class Field List</em>'.
	 * @see delphi.classFieldList
	 * @generated
	 */
	EClass getclassFieldList();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.classFieldList#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Field</em>'.
	 * @see delphi.classFieldList#getField()
	 * @see #getclassFieldList()
	 * @generated
	 */
	EReference getclassFieldList_Field();

	/**
	 * Returns the meta object for class '{@link delphi.classField <em>class Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>class Field</em>'.
	 * @see delphi.classField
	 * @generated
	 */
	EClass getclassField();

	/**
	 * Returns the meta object for the attribute '{@link delphi.classField#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see delphi.classField#getVisibility()
	 * @see #getclassField()
	 * @generated
	 */
	EAttribute getclassField_Visibility();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.classField#getFieldList <em>Field List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Field List</em>'.
	 * @see delphi.classField#getFieldList()
	 * @see #getclassField()
	 * @generated
	 */
	EReference getclassField_FieldList();

	/**
	 * Returns the meta object for class '{@link delphi.classMethodList <em>class Method List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>class Method List</em>'.
	 * @see delphi.classMethodList
	 * @generated
	 */
	EClass getclassMethodList();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.classMethodList#getMetod <em>Metod</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metod</em>'.
	 * @see delphi.classMethodList#getMetod()
	 * @see #getclassMethodList()
	 * @generated
	 */
	EReference getclassMethodList_Metod();

	/**
	 * Returns the meta object for class '{@link delphi.classMethod <em>class Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>class Method</em>'.
	 * @see delphi.classMethod
	 * @generated
	 */
	EClass getclassMethod();

	/**
	 * Returns the meta object for the attribute '{@link delphi.classMethod#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see delphi.classMethod#getVisibility()
	 * @see #getclassMethod()
	 * @generated
	 */
	EAttribute getclassMethod_Visibility();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.classMethod#getMethodList <em>Method List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Method List</em>'.
	 * @see delphi.classMethod#getMethodList()
	 * @see #getclassMethod()
	 * @generated
	 */
	EReference getclassMethod_MethodList();

	/**
	 * Returns the meta object for class '{@link delphi.classPropertyList <em>class Property List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>class Property List</em>'.
	 * @see delphi.classPropertyList
	 * @generated
	 */
	EClass getclassPropertyList();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.classPropertyList#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property</em>'.
	 * @see delphi.classPropertyList#getProperty()
	 * @see #getclassPropertyList()
	 * @generated
	 */
	EReference getclassPropertyList_Property();

	/**
	 * Returns the meta object for class '{@link delphi.classProperty <em>class Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>class Property</em>'.
	 * @see delphi.classProperty
	 * @generated
	 */
	EClass getclassProperty();

	/**
	 * Returns the meta object for the attribute '{@link delphi.classProperty#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see delphi.classProperty#getVisibility()
	 * @see #getclassProperty()
	 * @generated
	 */
	EAttribute getclassProperty_Visibility();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.classProperty#getPropList <em>Prop List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Prop List</em>'.
	 * @see delphi.classProperty#getPropList()
	 * @see #getclassProperty()
	 * @generated
	 */
	EReference getclassProperty_PropList();

	/**
	 * Returns the meta object for class '{@link delphi.propertyList <em>property List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>property List</em>'.
	 * @see delphi.propertyList
	 * @generated
	 */
	EClass getpropertyList();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.propertyList#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id</em>'.
	 * @see delphi.propertyList#getId()
	 * @see #getpropertyList()
	 * @generated
	 */
	EReference getpropertyList_Id();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.propertyList#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Interface</em>'.
	 * @see delphi.propertyList#getInterface()
	 * @see #getpropertyList()
	 * @generated
	 */
	EReference getpropertyList_Interface();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.propertyList#getSpecifiers <em>Specifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specifiers</em>'.
	 * @see delphi.propertyList#getSpecifiers()
	 * @see #getpropertyList()
	 * @generated
	 */
	EReference getpropertyList_Specifiers();

	/**
	 * Returns the meta object for the attribute '{@link delphi.propertyList#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see delphi.propertyList#getPort()
	 * @see #getpropertyList()
	 * @generated
	 */
	EAttribute getpropertyList_Port();

	/**
	 * Returns the meta object for class '{@link delphi.propertyInterface <em>property Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>property Interface</em>'.
	 * @see delphi.propertyInterface
	 * @generated
	 */
	EClass getpropertyInterface();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.propertyInterface#getParamList <em>Param List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Param List</em>'.
	 * @see delphi.propertyInterface#getParamList()
	 * @see #getpropertyInterface()
	 * @generated
	 */
	EReference getpropertyInterface_ParamList();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.propertyInterface#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id</em>'.
	 * @see delphi.propertyInterface#getId()
	 * @see #getpropertyInterface()
	 * @generated
	 */
	EReference getpropertyInterface_Id();

	/**
	 * Returns the meta object for class '{@link delphi.propertyParameterList <em>property Parameter List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>property Parameter List</em>'.
	 * @see delphi.propertyParameterList
	 * @generated
	 */
	EClass getpropertyParameterList();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.propertyParameterList#getIdList <em>Id List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Id List</em>'.
	 * @see delphi.propertyParameterList#getIdList()
	 * @see #getpropertyParameterList()
	 * @generated
	 */
	EReference getpropertyParameterList_IdList();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.propertyParameterList#getTypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Ref</em>'.
	 * @see delphi.propertyParameterList#getTypeRef()
	 * @see #getpropertyParameterList()
	 * @generated
	 */
	EReference getpropertyParameterList_TypeRef();

	/**
	 * Returns the meta object for class '{@link delphi.propertySpecifiers <em>property Specifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>property Specifiers</em>'.
	 * @see delphi.propertySpecifiers
	 * @generated
	 */
	EClass getpropertySpecifiers();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.propertySpecifiers#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Index</em>'.
	 * @see delphi.propertySpecifiers#getIndex()
	 * @see #getpropertySpecifiers()
	 * @generated
	 */
	EReference getpropertySpecifiers_Index();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.propertySpecifiers#getReadId <em>Read Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Read Id</em>'.
	 * @see delphi.propertySpecifiers#getReadId()
	 * @see #getpropertySpecifiers()
	 * @generated
	 */
	EReference getpropertySpecifiers_ReadId();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.propertySpecifiers#getWriteId <em>Write Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Write Id</em>'.
	 * @see delphi.propertySpecifiers#getWriteId()
	 * @see #getpropertySpecifiers()
	 * @generated
	 */
	EReference getpropertySpecifiers_WriteId();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.propertySpecifiers#getStoreId <em>Store Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Store Id</em>'.
	 * @see delphi.propertySpecifiers#getStoreId()
	 * @see #getpropertySpecifiers()
	 * @generated
	 */
	EReference getpropertySpecifiers_StoreId();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.propertySpecifiers#getStoreExp <em>Store Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Store Exp</em>'.
	 * @see delphi.propertySpecifiers#getStoreExp()
	 * @see #getpropertySpecifiers()
	 * @generated
	 */
	EReference getpropertySpecifiers_StoreExp();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.propertySpecifiers#getDefaulExp <em>Defaul Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Defaul Exp</em>'.
	 * @see delphi.propertySpecifiers#getDefaulExp()
	 * @see #getpropertySpecifiers()
	 * @generated
	 */
	EReference getpropertySpecifiers_DefaulExp();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.propertySpecifiers#getImplement <em>Implement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Implement</em>'.
	 * @see delphi.propertySpecifiers#getImplement()
	 * @see #getpropertySpecifiers()
	 * @generated
	 */
	EReference getpropertySpecifiers_Implement();

	/**
	 * Returns the meta object for class '{@link delphi.interfaceType <em>interface Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>interface Type</em>'.
	 * @see delphi.interfaceType
	 * @generated
	 */
	EClass getinterfaceType();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.interfaceType#getHeritage <em>Heritage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Heritage</em>'.
	 * @see delphi.interfaceType#getHeritage()
	 * @see #getinterfaceType()
	 * @generated
	 */
	EReference getinterfaceType_Heritage();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.interfaceType#getMethodList <em>Method List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Method List</em>'.
	 * @see delphi.interfaceType#getMethodList()
	 * @see #getinterfaceType()
	 * @generated
	 */
	EReference getinterfaceType_MethodList();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.interfaceType#getPropList <em>Prop List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Prop List</em>'.
	 * @see delphi.interfaceType#getPropList()
	 * @see #getinterfaceType()
	 * @generated
	 */
	EReference getinterfaceType_PropList();

	/**
	 * Returns the meta object for class '{@link delphi.interfaceHeritage <em>interface Heritage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>interface Heritage</em>'.
	 * @see delphi.interfaceHeritage
	 * @generated
	 */
	EClass getinterfaceHeritage();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.interfaceHeritage#getIdList <em>Id List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id List</em>'.
	 * @see delphi.interfaceHeritage#getIdList()
	 * @see #getinterfaceHeritage()
	 * @generated
	 */
	EReference getinterfaceHeritage_IdList();

	/**
	 * Returns the meta object for class '{@link delphi.requiresClause <em>requires Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>requires Clause</em>'.
	 * @see delphi.requiresClause
	 * @generated
	 */
	EClass getrequiresClause();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.requiresClause#getIdList <em>Id List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Id List</em>'.
	 * @see delphi.requiresClause#getIdList()
	 * @see #getrequiresClause()
	 * @generated
	 */
	EReference getrequiresClause_IdList();

	/**
	 * Returns the meta object for class '{@link delphi.containsClause <em>contains Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>contains Clause</em>'.
	 * @see delphi.containsClause
	 * @generated
	 */
	EClass getcontainsClause();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.containsClause#getIdList <em>Id List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Id List</em>'.
	 * @see delphi.containsClause#getIdList()
	 * @see #getcontainsClause()
	 * @generated
	 */
	EReference getcontainsClause_IdList();

	/**
	 * Returns the meta object for class '{@link delphi.identList <em>ident List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ident List</em>'.
	 * @see delphi.identList
	 * @generated
	 */
	EClass getidentList();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.identList#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see delphi.identList#getType()
	 * @see #getidentList()
	 * @generated
	 */
	EReference getidentList_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.identList#getIds <em>Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ids</em>'.
	 * @see delphi.identList#getIds()
	 * @see #getidentList()
	 * @generated
	 */
	EReference getidentList_Ids();

	/**
	 * Returns the meta object for class '{@link delphi.qualId <em>qual Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>qual Id</em>'.
	 * @see delphi.qualId
	 * @generated
	 */
	EClass getqualId();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.qualId#getUnitId <em>Unit Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Id</em>'.
	 * @see delphi.qualId#getUnitId()
	 * @see #getqualId()
	 * @generated
	 */
	EReference getqualId_UnitId();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.qualId#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id</em>'.
	 * @see delphi.qualId#getId()
	 * @see #getqualId()
	 * @generated
	 */
	EReference getqualId_Id();

	/**
	 * Returns the meta object for class '{@link delphi.typeId <em>type Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>type Id</em>'.
	 * @see delphi.typeId
	 * @generated
	 */
	EClass gettypeId();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.typeId#getUnitId <em>Unit Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Id</em>'.
	 * @see delphi.typeId#getUnitId()
	 * @see #gettypeId()
	 * @generated
	 */
	EReference gettypeId_UnitId();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.typeId#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id</em>'.
	 * @see delphi.typeId#getId()
	 * @see #gettypeId()
	 * @generated
	 */
	EReference gettypeId_Id();

	/**
	 * Returns the meta object for class '{@link delphi.ident <em>ident</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ident</em>'.
	 * @see delphi.ident
	 * @generated
	 */
	EClass getident();

	/**
	 * Returns the meta object for class '{@link delphi.reservedWord <em>reserved Word</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>reserved Word</em>'.
	 * @see delphi.reservedWord
	 * @generated
	 */
	EClass getreservedWord();

	/**
	 * Returns the meta object for the attribute '{@link delphi.reservedWord#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see delphi.reservedWord#getId()
	 * @see #getreservedWord()
	 * @generated
	 */
	EAttribute getreservedWord_Id();

	/**
	 * Returns the meta object for class '{@link delphi.constExpr <em>const Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>const Expr</em>'.
	 * @see delphi.constExpr
	 * @generated
	 */
	EClass getconstExpr();

	/**
	 * Returns the meta object for class '{@link delphi.recordConstExpr <em>record Const Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>record Const Expr</em>'.
	 * @see delphi.recordConstExpr
	 * @generated
	 */
	EClass getrecordConstExpr();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.recordConstExpr#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id</em>'.
	 * @see delphi.recordConstExpr#getId()
	 * @see #getrecordConstExpr()
	 * @generated
	 */
	EReference getrecordConstExpr_Id();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.recordConstExpr#getConstExp <em>Const Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Const Exp</em>'.
	 * @see delphi.recordConstExpr#getConstExp()
	 * @see #getrecordConstExpr()
	 * @generated
	 */
	EReference getrecordConstExpr_ConstExp();

	/**
	 * Returns the meta object for class '{@link delphi.unitId <em>unit Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>unit Id</em>'.
	 * @see delphi.unitId
	 * @generated
	 */
	EClass getunitId();

	/**
	 * Returns the meta object for the attribute '{@link delphi.unitId#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see delphi.unitId#getId()
	 * @see #getunitId()
	 * @generated
	 */
	EAttribute getunitId_Id();

	/**
	 * Returns the meta object for class '{@link delphi.relExp <em>rel Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>rel Exp</em>'.
	 * @see delphi.relExp
	 * @generated
	 */
	EClass getrelExp();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.relExp#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see delphi.relExp#getLeft()
	 * @see #getrelExp()
	 * @generated
	 */
	EReference getrelExp_Left();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.relExp#getRelOp <em>Rel Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rel Op</em>'.
	 * @see delphi.relExp#getRelOp()
	 * @see #getrelExp()
	 * @generated
	 */
	EReference getrelExp_RelOp();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.relExp#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see delphi.relExp#getRight()
	 * @see #getrelExp()
	 * @generated
	 */
	EReference getrelExp_Right();

	/**
	 * Returns the meta object for class '{@link delphi.addExp <em>add Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>add Exp</em>'.
	 * @see delphi.addExp
	 * @generated
	 */
	EClass getaddExp();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.addExp#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see delphi.addExp#getLeft()
	 * @see #getaddExp()
	 * @generated
	 */
	EReference getaddExp_Left();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.addExp#getAddOp <em>Add Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Add Op</em>'.
	 * @see delphi.addExp#getAddOp()
	 * @see #getaddExp()
	 * @generated
	 */
	EReference getaddExp_AddOp();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.addExp#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see delphi.addExp#getRight()
	 * @see #getaddExp()
	 * @generated
	 */
	EReference getaddExp_Right();

	/**
	 * Returns the meta object for class '{@link delphi.multExp <em>mult Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>mult Exp</em>'.
	 * @see delphi.multExp
	 * @generated
	 */
	EClass getmultExp();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.multExp#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see delphi.multExp#getLeft()
	 * @see #getmultExp()
	 * @generated
	 */
	EReference getmultExp_Left();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.multExp#getMultOp <em>Mult Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mult Op</em>'.
	 * @see delphi.multExp#getMultOp()
	 * @see #getmultExp()
	 * @generated
	 */
	EReference getmultExp_MultOp();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.multExp#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see delphi.multExp#getRight()
	 * @see #getmultExp()
	 * @generated
	 */
	EReference getmultExp_Right();

	/**
	 * Returns the meta object for class '{@link delphi.simpleFactor <em>simple Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>simple Factor</em>'.
	 * @see delphi.simpleFactor
	 * @generated
	 */
	EClass getsimpleFactor();

	/**
	 * Returns the meta object for class '{@link delphi.assignmentStmnt <em>assignment Stmnt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>assignment Stmnt</em>'.
	 * @see delphi.assignmentStmnt
	 * @generated
	 */
	EClass getassignmentStmnt();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.assignmentStmnt#getDesignator <em>Designator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Designator</em>'.
	 * @see delphi.assignmentStmnt#getDesignator()
	 * @see #getassignmentStmnt()
	 * @generated
	 */
	EReference getassignmentStmnt_Designator();

	/**
	 * Returns the meta object for the attribute '{@link delphi.assignmentStmnt#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see delphi.assignmentStmnt#getOperator()
	 * @see #getassignmentStmnt()
	 * @generated
	 */
	EAttribute getassignmentStmnt_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.assignmentStmnt#getExp <em>Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exp</em>'.
	 * @see delphi.assignmentStmnt#getExp()
	 * @see #getassignmentStmnt()
	 * @generated
	 */
	EReference getassignmentStmnt_Exp();

	/**
	 * Returns the meta object for class '{@link delphi.callStmnt <em>call Stmnt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>call Stmnt</em>'.
	 * @see delphi.callStmnt
	 * @generated
	 */
	EClass getcallStmnt();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.callStmnt#getDesignator <em>Designator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Designator</em>'.
	 * @see delphi.callStmnt#getDesignator()
	 * @see #getcallStmnt()
	 * @generated
	 */
	EReference getcallStmnt_Designator();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.callStmnt#getArgs <em>Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Args</em>'.
	 * @see delphi.callStmnt#getArgs()
	 * @see #getcallStmnt()
	 * @generated
	 */
	EReference getcallStmnt_Args();

	/**
	 * Returns the meta object for class '{@link delphi.inheritedStamnt <em>inherited Stamnt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>inherited Stamnt</em>'.
	 * @see delphi.inheritedStamnt
	 * @generated
	 */
	EClass getinheritedStamnt();

	/**
	 * Returns the meta object for class '{@link delphi.gotoStmnt <em>goto Stmnt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>goto Stmnt</em>'.
	 * @see delphi.gotoStmnt
	 * @generated
	 */
	EClass getgotoStmnt();

	/**
	 * Returns the meta object for the attribute '{@link delphi.gotoStmnt#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see delphi.gotoStmnt#getLabel()
	 * @see #getgotoStmnt()
	 * @generated
	 */
	EAttribute getgotoStmnt_Label();

	/**
	 * Returns the meta object for class '{@link delphi.parameterList <em>parameter List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>parameter List</em>'.
	 * @see delphi.parameterList
	 * @generated
	 */
	EClass getparameterList();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.parameterList#getIdList <em>Id List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id List</em>'.
	 * @see delphi.parameterList#getIdList()
	 * @see #getparameterList()
	 * @generated
	 */
	EReference getparameterList_IdList();

	/**
	 * Returns the meta object for class '{@link delphi.parameterSimple <em>parameter Simple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>parameter Simple</em>'.
	 * @see delphi.parameterSimple
	 * @generated
	 */
	EClass getparameterSimple();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.parameterSimple#getIf <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>If</em>'.
	 * @see delphi.parameterSimple#getIf()
	 * @see #getparameterSimple()
	 * @generated
	 */
	EReference getparameterSimple_If();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.parameterSimple#getInitExp <em>Init Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init Exp</em>'.
	 * @see delphi.parameterSimple#getInitExp()
	 * @see #getparameterSimple()
	 * @generated
	 */
	EReference getparameterSimple_InitExp();

	/**
	 * Returns the meta object for class '{@link delphi.MultipleId <em>Multiple Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiple Id</em>'.
	 * @see delphi.MultipleId
	 * @generated
	 */
	EClass getMultipleId();

	/**
	 * Returns the meta object for the attribute list '{@link delphi.MultipleId#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Id</em>'.
	 * @see delphi.MultipleId#getId()
	 * @see #getMultipleId()
	 * @generated
	 */
	EAttribute getMultipleId_Id();

	/**
	 * Returns the meta object for class '{@link delphi.ReservedId <em>Reserved Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reserved Id</em>'.
	 * @see delphi.ReservedId
	 * @generated
	 */
	EClass getReservedId();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.ReservedId#getReservedWord <em>Reserved Word</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reserved Word</em>'.
	 * @see delphi.ReservedId#getReservedWord()
	 * @see #getReservedId()
	 * @generated
	 */
	EReference getReservedId_ReservedWord();

	/**
	 * Returns the meta object for class '{@link delphi.MineID <em>Mine ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mine ID</em>'.
	 * @see delphi.MineID
	 * @generated
	 */
	EClass getMineID();

	/**
	 * Returns the meta object for the attribute '{@link delphi.MineID#getFirst <em>First</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First</em>'.
	 * @see delphi.MineID#getFirst()
	 * @see #getMineID()
	 * @generated
	 */
	EAttribute getMineID_First();

	/**
	 * Returns the meta object for the attribute '{@link delphi.MineID#getSecond <em>Second</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Second</em>'.
	 * @see delphi.MineID#getSecond()
	 * @see #getMineID()
	 * @generated
	 */
	EAttribute getMineID_Second();

	/**
	 * Returns the meta object for class '{@link delphi.ConstExp <em>Const Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Const Exp</em>'.
	 * @see delphi.ConstExp
	 * @generated
	 */
	EClass getConstExp();

	/**
	 * Returns the meta object for the containment reference '{@link delphi.ConstExp#getExp <em>Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exp</em>'.
	 * @see delphi.ConstExp#getExp()
	 * @see #getConstExp()
	 * @generated
	 */
	EReference getConstExp_Exp();

	/**
	 * Returns the meta object for class '{@link delphi.MultipleConstExp <em>Multiple Const Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiple Const Exp</em>'.
	 * @see delphi.MultipleConstExp
	 * @generated
	 */
	EClass getMultipleConstExp();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.MultipleConstExp#getExps <em>Exps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exps</em>'.
	 * @see delphi.MultipleConstExp#getExps()
	 * @see #getMultipleConstExp()
	 * @generated
	 */
	EReference getMultipleConstExp_Exps();

	/**
	 * Returns the meta object for class '{@link delphi.RecordConstExp <em>Record Const Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Record Const Exp</em>'.
	 * @see delphi.RecordConstExp
	 * @generated
	 */
	EClass getRecordConstExp();

	/**
	 * Returns the meta object for the containment reference list '{@link delphi.RecordConstExp#getExps <em>Exps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exps</em>'.
	 * @see delphi.RecordConstExp#getExps()
	 * @see #getRecordConstExp()
	 * @generated
	 */
	EReference getRecordConstExp_Exps();

	/**
	 * Returns the meta object for class '{@link delphi.CSTrace <em>CS Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CS Trace</em>'.
	 * @see delphi.CSTrace
	 * @generated
	 */
	EClass getCSTrace();

	/**
	 * Returns the meta object for the reference '{@link delphi.CSTrace#getAst <em>Ast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ast</em>'.
	 * @see delphi.CSTrace#getAst()
	 * @see #getCSTrace()
	 * @generated
	 */
	EReference getCSTrace_Ast();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DelphiFactory getDelphiFactory();

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
		 * The meta object literal for the '{@link delphi.impl.mainRuleImpl <em>main Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.mainRuleImpl
		 * @see delphi.impl.DelphiPackageImpl#getmainRule()
		 * @generated
		 */
		EClass MAIN_RULE = eINSTANCE.getmainRule();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAIN_RULE__FILE = eINSTANCE.getmainRule_File();

		/**
		 * The meta object literal for the '{@link delphi.impl.fileImpl <em>file</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.fileImpl
		 * @see delphi.impl.DelphiPackageImpl#getfile()
		 * @generated
		 */
		EClass FILE = eINSTANCE.getfile();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE__ID = eINSTANCE.getfile_Id();

		/**
		 * The meta object literal for the '{@link delphi.impl.programImpl <em>program</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.programImpl
		 * @see delphi.impl.DelphiPackageImpl#getprogram()
		 * @generated
		 */
		EClass PROGRAM = eINSTANCE.getprogram();

		/**
		 * The meta object literal for the '<em><b>Params List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__PARAMS_LIST = eINSTANCE.getprogram_ParamsList();

		/**
		 * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__BLOCK = eINSTANCE.getprogram_Block();

		/**
		 * The meta object literal for the '{@link delphi.impl.unitImpl <em>unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.unitImpl
		 * @see delphi.impl.DelphiPackageImpl#getunit()
		 * @generated
		 */
		EClass UNIT = eINSTANCE.getunit();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__PORT = eINSTANCE.getunit_Port();

		/**
		 * The meta object literal for the '<em><b>Interface Sect</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT__INTERFACE_SECT = eINSTANCE.getunit_InterfaceSect();

		/**
		 * The meta object literal for the '<em><b>Implementation Sect</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT__IMPLEMENTATION_SECT = eINSTANCE.getunit_ImplementationSect();

		/**
		 * The meta object literal for the '<em><b>Init Sect</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT__INIT_SECT = eINSTANCE.getunit_InitSect();

		/**
		 * The meta object literal for the '{@link delphi.impl.packageDeclImpl <em>package Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.packageDeclImpl
		 * @see delphi.impl.DelphiPackageImpl#getpackageDecl()
		 * @generated
		 */
		EClass PACKAGE_DECL = eINSTANCE.getpackageDecl();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_DECL__REQUIRES = eINSTANCE.getpackageDecl_Requires();

		/**
		 * The meta object literal for the '<em><b>Contains</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_DECL__CONTAINS = eINSTANCE.getpackageDecl_Contains();

		/**
		 * The meta object literal for the '{@link delphi.impl.libraryImpl <em>library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.libraryImpl
		 * @see delphi.impl.DelphiPackageImpl#getlibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getlibrary();

		/**
		 * The meta object literal for the '<em><b>PBlock</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__PBLOCK = eINSTANCE.getlibrary_PBlock();

		/**
		 * The meta object literal for the '{@link delphi.impl.programBlockImpl <em>program Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.programBlockImpl
		 * @see delphi.impl.DelphiPackageImpl#getprogramBlock()
		 * @generated
		 */
		EClass PROGRAM_BLOCK = eINSTANCE.getprogramBlock();

		/**
		 * The meta object literal for the '<em><b>Uses</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM_BLOCK__USES = eINSTANCE.getprogramBlock_Uses();

		/**
		 * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM_BLOCK__BLOCK = eINSTANCE.getprogramBlock_Block();

		/**
		 * The meta object literal for the '{@link delphi.impl.usesClauseImpl <em>uses Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.usesClauseImpl
		 * @see delphi.impl.DelphiPackageImpl#getusesClause()
		 * @generated
		 */
		EClass USES_CLAUSE = eINSTANCE.getusesClause();

		/**
		 * The meta object literal for the '<em><b>Id List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USES_CLAUSE__ID_LIST = eINSTANCE.getusesClause_IdList();

		/**
		 * The meta object literal for the '{@link delphi.impl.interfaceSectionImpl <em>interface Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.interfaceSectionImpl
		 * @see delphi.impl.DelphiPackageImpl#getinterfaceSection()
		 * @generated
		 */
		EClass INTERFACE_SECTION = eINSTANCE.getinterfaceSection();

		/**
		 * The meta object literal for the '<em><b>Uses</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_SECTION__USES = eINSTANCE.getinterfaceSection_Uses();

		/**
		 * The meta object literal for the '<em><b>Interface Decl</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_SECTION__INTERFACE_DECL = eINSTANCE.getinterfaceSection_InterfaceDecl();

		/**
		 * The meta object literal for the '{@link delphi.impl.interfaceDeclImpl <em>interface Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.interfaceDeclImpl
		 * @see delphi.impl.DelphiPackageImpl#getinterfaceDecl()
		 * @generated
		 */
		EClass INTERFACE_DECL = eINSTANCE.getinterfaceDecl();

		/**
		 * The meta object literal for the '{@link delphi.impl.exportedHeadingImpl <em>exported Heading</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.exportedHeadingImpl
		 * @see delphi.impl.DelphiPackageImpl#getexportedHeading()
		 * @generated
		 */
		EClass EXPORTED_HEADING = eINSTANCE.getexportedHeading();

		/**
		 * The meta object literal for the '<em><b>PHeading</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPORTED_HEADING__PHEADING = eINSTANCE.getexportedHeading_PHeading();

		/**
		 * The meta object literal for the '<em><b>Directive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPORTED_HEADING__DIRECTIVE = eINSTANCE.getexportedHeading_Directive();

		/**
		 * The meta object literal for the '<em><b>FHeading</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPORTED_HEADING__FHEADING = eINSTANCE.getexportedHeading_FHeading();

		/**
		 * The meta object literal for the '{@link delphi.impl.implementationSectionImpl <em>implementation Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.implementationSectionImpl
		 * @see delphi.impl.DelphiPackageImpl#getimplementationSection()
		 * @generated
		 */
		EClass IMPLEMENTATION_SECTION = eINSTANCE.getimplementationSection();

		/**
		 * The meta object literal for the '<em><b>Uses</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLEMENTATION_SECTION__USES = eINSTANCE.getimplementationSection_Uses();

		/**
		 * The meta object literal for the '<em><b>Decl Sect</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLEMENTATION_SECTION__DECL_SECT = eINSTANCE.getimplementationSection_DeclSect();

		/**
		 * The meta object literal for the '<em><b>Exports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLEMENTATION_SECTION__EXPORTS = eINSTANCE.getimplementationSection_Exports();

		/**
		 * The meta object literal for the '{@link delphi.impl.blockImpl <em>block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.blockImpl
		 * @see delphi.impl.DelphiPackageImpl#getblock()
		 * @generated
		 */
		EClass BLOCK = eINSTANCE.getblock();

		/**
		 * The meta object literal for the '<em><b>Decl Sect</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__DECL_SECT = eINSTANCE.getblock_DeclSect();

		/**
		 * The meta object literal for the '<em><b>Exports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__EXPORTS = eINSTANCE.getblock_Exports();

		/**
		 * The meta object literal for the '<em><b>Compound</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__COMPOUND = eINSTANCE.getblock_Compound();

		/**
		 * The meta object literal for the '{@link delphi.impl.exportsItemImpl <em>exports Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.exportsItemImpl
		 * @see delphi.impl.DelphiPackageImpl#getexportsItem()
		 * @generated
		 */
		EClass EXPORTS_ITEM = eINSTANCE.getexportsItem();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPORTS_ITEM__ID = eINSTANCE.getexportsItem_Id();

		/**
		 * The meta object literal for the '<em><b>Const Exp</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPORTS_ITEM__CONST_EXP = eINSTANCE.getexportsItem_ConstExp();

		/**
		 * The meta object literal for the '{@link delphi.impl.exportsStmtImpl <em>exports Stmt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.exportsStmtImpl
		 * @see delphi.impl.DelphiPackageImpl#getexportsStmt()
		 * @generated
		 */
		EClass EXPORTS_STMT = eINSTANCE.getexportsStmt();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPORTS_STMT__ITEMS = eINSTANCE.getexportsStmt_Items();

		/**
		 * The meta object literal for the '{@link delphi.impl.declSectionImpl <em>decl Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.declSectionImpl
		 * @see delphi.impl.DelphiPackageImpl#getdeclSection()
		 * @generated
		 */
		EClass DECL_SECTION = eINSTANCE.getdeclSection();

		/**
		 * The meta object literal for the '{@link delphi.impl.labelDeclSectionImpl <em>label Decl Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.labelDeclSectionImpl
		 * @see delphi.impl.DelphiPackageImpl#getlabelDeclSection()
		 * @generated
		 */
		EClass LABEL_DECL_SECTION = eINSTANCE.getlabelDeclSection();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL_DECL_SECTION__ID = eINSTANCE.getlabelDeclSection_Id();

		/**
		 * The meta object literal for the '{@link delphi.impl.constSectionImpl <em>const Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.constSectionImpl
		 * @see delphi.impl.DelphiPackageImpl#getconstSection()
		 * @generated
		 */
		EClass CONST_SECTION = eINSTANCE.getconstSection();

		/**
		 * The meta object literal for the '<em><b>Constant Decl</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONST_SECTION__CONSTANT_DECL = eINSTANCE.getconstSection_ConstantDecl();

		/**
		 * The meta object literal for the '{@link delphi.impl.constantDeclImpl <em>constant Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.constantDeclImpl
		 * @see delphi.impl.DelphiPackageImpl#getconstantDecl()
		 * @generated
		 */
		EClass CONSTANT_DECL = eINSTANCE.getconstantDecl();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTANT_DECL__ID = eINSTANCE.getconstantDecl_Id();

		/**
		 * The meta object literal for the '<em><b>Const</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTANT_DECL__CONST = eINSTANCE.getconstantDecl_Const();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTANT_DECL__PORT = eINSTANCE.getconstantDecl_Port();

		/**
		 * The meta object literal for the '<em><b>Type Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTANT_DECL__TYPE_REF = eINSTANCE.getconstantDecl_TypeRef();

		/**
		 * The meta object literal for the '<em><b>Typed Constat</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTANT_DECL__TYPED_CONSTAT = eINSTANCE.getconstantDecl_TypedConstat();

		/**
		 * The meta object literal for the '{@link delphi.impl.typeSectionImpl <em>type Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.typeSectionImpl
		 * @see delphi.impl.DelphiPackageImpl#gettypeSection()
		 * @generated
		 */
		EClass TYPE_SECTION = eINSTANCE.gettypeSection();

		/**
		 * The meta object literal for the '<em><b>Type Decl</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_SECTION__TYPE_DECL = eINSTANCE.gettypeSection_TypeDecl();

		/**
		 * The meta object literal for the '{@link delphi.impl.typeDeclImpl <em>type Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.typeDeclImpl
		 * @see delphi.impl.DelphiPackageImpl#gettypeDecl()
		 * @generated
		 */
		EClass TYPE_DECL = eINSTANCE.gettypeDecl();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_DECL__ID = eINSTANCE.gettypeDecl_Id();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_DECL__TYPE = eINSTANCE.gettypeDecl_Type();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_DECL__PORT = eINSTANCE.gettypeDecl_Port();

		/**
		 * The meta object literal for the '<em><b>Restricted Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_DECL__RESTRICTED_TYPE = eINSTANCE.gettypeDecl_RestrictedType();

		/**
		 * The meta object literal for the '{@link delphi.impl.typedConstantImpl <em>typed Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.typedConstantImpl
		 * @see delphi.impl.DelphiPackageImpl#gettypedConstant()
		 * @generated
		 */
		EClass TYPED_CONSTANT = eINSTANCE.gettypedConstant();

		/**
		 * The meta object literal for the '<em><b>Const</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_CONSTANT__CONST = eINSTANCE.gettypedConstant_Const();

		/**
		 * The meta object literal for the '<em><b>Array</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_CONSTANT__ARRAY = eINSTANCE.gettypedConstant_Array();

		/**
		 * The meta object literal for the '<em><b>Record</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_CONSTANT__RECORD = eINSTANCE.gettypedConstant_Record();

		/**
		 * The meta object literal for the '{@link delphi.impl.arrayConstantImpl <em>array Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.arrayConstantImpl
		 * @see delphi.impl.DelphiPackageImpl#getarrayConstant()
		 * @generated
		 */
		EClass ARRAY_CONSTANT = eINSTANCE.getarrayConstant();

		/**
		 * The meta object literal for the '<em><b>Typed Constant</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_CONSTANT__TYPED_CONSTANT = eINSTANCE.getarrayConstant_TypedConstant();

		/**
		 * The meta object literal for the '{@link delphi.impl.recordConstantImpl <em>record Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.recordConstantImpl
		 * @see delphi.impl.DelphiPackageImpl#getrecordConstant()
		 * @generated
		 */
		EClass RECORD_CONSTANT = eINSTANCE.getrecordConstant();

		/**
		 * The meta object literal for the '<em><b>Record Field</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECORD_CONSTANT__RECORD_FIELD = eINSTANCE.getrecordConstant_RecordField();

		/**
		 * The meta object literal for the '{@link delphi.impl.recordFieldConstantImpl <em>record Field Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.recordFieldConstantImpl
		 * @see delphi.impl.DelphiPackageImpl#getrecordFieldConstant()
		 * @generated
		 */
		EClass RECORD_FIELD_CONSTANT = eINSTANCE.getrecordFieldConstant();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECORD_FIELD_CONSTANT__ID = eINSTANCE.getrecordFieldConstant_Id();

		/**
		 * The meta object literal for the '<em><b>Typed Constant</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECORD_FIELD_CONSTANT__TYPED_CONSTANT = eINSTANCE.getrecordFieldConstant_TypedConstant();

		/**
		 * The meta object literal for the '{@link delphi.impl.typeImpl <em>type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.typeImpl
		 * @see delphi.impl.DelphiPackageImpl#gettype()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.gettype();

		/**
		 * The meta object literal for the '{@link delphi.impl.restrictedTypeImpl <em>restricted Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.restrictedTypeImpl
		 * @see delphi.impl.DelphiPackageImpl#getrestrictedType()
		 * @generated
		 */
		EClass RESTRICTED_TYPE = eINSTANCE.getrestrictedType();

		/**
		 * The meta object literal for the '{@link delphi.impl.classRefTypeImpl <em>class Ref Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.classRefTypeImpl
		 * @see delphi.impl.DelphiPackageImpl#getclassRefType()
		 * @generated
		 */
		EClass CLASS_REF_TYPE = eINSTANCE.getclassRefType();

		/**
		 * The meta object literal for the '<em><b>Type Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_REF_TYPE__TYPE_REF = eINSTANCE.getclassRefType_TypeRef();

		/**
		 * The meta object literal for the '{@link delphi.impl.simpleTypeImpl <em>simple Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.simpleTypeImpl
		 * @see delphi.impl.DelphiPackageImpl#getsimpleType()
		 * @generated
		 */
		EClass SIMPLE_TYPE = eINSTANCE.getsimpleType();

		/**
		 * The meta object literal for the '{@link delphi.impl.realTypeImpl <em>real Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.realTypeImpl
		 * @see delphi.impl.DelphiPackageImpl#getrealType()
		 * @generated
		 */
		EClass REAL_TYPE = eINSTANCE.getrealType();

		/**
		 * The meta object literal for the '{@link delphi.impl.ordinalTypeImpl <em>ordinal Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.ordinalTypeImpl
		 * @see delphi.impl.DelphiPackageImpl#getordinalType()
		 * @generated
		 */
		EClass ORDINAL_TYPE = eINSTANCE.getordinalType();

		/**
		 * The meta object literal for the '{@link delphi.impl.ordIdentImpl <em>ord Ident</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.ordIdentImpl
		 * @see delphi.impl.DelphiPackageImpl#getordIdent()
		 * @generated
		 */
		EClass ORD_IDENT = eINSTANCE.getordIdent();

		/**
		 * The meta object literal for the '{@link delphi.impl.variantTypeImpl <em>variant Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.variantTypeImpl
		 * @see delphi.impl.DelphiPackageImpl#getvariantType()
		 * @generated
		 */
		EClass VARIANT_TYPE = eINSTANCE.getvariantType();

		/**
		 * The meta object literal for the '{@link delphi.impl.subrangeTypeImpl <em>subrange Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.subrangeTypeImpl
		 * @see delphi.impl.DelphiPackageImpl#getsubrangeType()
		 * @generated
		 */
		EClass SUBRANGE_TYPE = eINSTANCE.getsubrangeType();

		/**
		 * The meta object literal for the '<em><b>First</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBRANGE_TYPE__FIRST = eINSTANCE.getsubrangeType_First();

		/**
		 * The meta object literal for the '<em><b>Last</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBRANGE_TYPE__LAST = eINSTANCE.getsubrangeType_Last();

		/**
		 * The meta object literal for the '{@link delphi.impl.enumeratedTypeImpl <em>enumerated Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.enumeratedTypeImpl
		 * @see delphi.impl.DelphiPackageImpl#getenumeratedType()
		 * @generated
		 */
		EClass ENUMERATED_TYPE = eINSTANCE.getenumeratedType();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATED_TYPE__ELEMENT = eINSTANCE.getenumeratedType_Element();

		/**
		 * The meta object literal for the '{@link delphi.impl.enumeratedTypeElementImpl <em>enumerated Type Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.enumeratedTypeElementImpl
		 * @see delphi.impl.DelphiPackageImpl#getenumeratedTypeElement()
		 * @generated
		 */
		EClass ENUMERATED_TYPE_ELEMENT = eINSTANCE.getenumeratedTypeElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATED_TYPE_ELEMENT__ID = eINSTANCE.getenumeratedTypeElement_Id();

		/**
		 * The meta object literal for the '<em><b>Literal Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATED_TYPE_ELEMENT__LITERAL_EXP = eINSTANCE.getenumeratedTypeElement_LiteralExp();

		/**
		 * The meta object literal for the '{@link delphi.impl.stringTypeImpl <em>string Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.stringTypeImpl
		 * @see delphi.impl.DelphiPackageImpl#getstringType()
		 * @generated
		 */
		EClass STRING_TYPE = eINSTANCE.getstringType();

		/**
		 * The meta object literal for the '<em><b>Const Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_TYPE__CONST_EXP = eINSTANCE.getstringType_ConstExp();

		/**
		 * The meta object literal for the '{@link delphi.impl.strucTypeImpl <em>struc Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.strucTypeImpl
		 * @see delphi.impl.DelphiPackageImpl#getstrucType()
		 * @generated
		 */
		EClass STRUC_TYPE = eINSTANCE.getstrucType();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUC_TYPE__PORT = eINSTANCE.getstrucType_Port();

		/**
		 * The meta object literal for the '{@link delphi.impl.arrayTypeImpl <em>array Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.arrayTypeImpl
		 * @see delphi.impl.DelphiPackageImpl#getarrayType()
		 * @generated
		 */
		EClass ARRAY_TYPE = eINSTANCE.getarrayType();

		/**
		 * The meta object literal for the '<em><b>Ordinal Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_TYPE__ORDINAL_TYPE = eINSTANCE.getarrayType_OrdinalType();

		/**
		 * The meta object literal for the '<em><b>Ordinal Typ</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_TYPE__ORDINAL_TYP = eINSTANCE.getarrayType_OrdinalTyp();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_TYPE__TYPE = eINSTANCE.getarrayType_Type();

		/**
		 * The meta object literal for the '{@link delphi.impl.recTypeImpl <em>rec Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.recTypeImpl
		 * @see delphi.impl.DelphiPackageImpl#getrecType()
		 * @generated
		 */
		EClass REC_TYPE = eINSTANCE.getrecType();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REC_TYPE__FIELDS = eINSTANCE.getrecType_Fields();

		/**
		 * The meta object literal for the '{@link delphi.impl.fieldListImpl <em>field List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.fieldListImpl
		 * @see delphi.impl.DelphiPackageImpl#getfieldList()
		 * @generated
		 */
		EClass FIELD_LIST = eINSTANCE.getfieldList();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIELD_LIST__FIELD = eINSTANCE.getfieldList_Field();

		/**
		 * The meta object literal for the '<em><b>Variant Sect</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIELD_LIST__VARIANT_SECT = eINSTANCE.getfieldList_VariantSect();

		/**
		 * The meta object literal for the '{@link delphi.impl.fieldDeclImpl <em>field Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.fieldDeclImpl
		 * @see delphi.impl.DelphiPackageImpl#getfieldDecl()
		 * @generated
		 */
		EClass FIELD_DECL = eINSTANCE.getfieldDecl();

		/**
		 * The meta object literal for the '<em><b>Id List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIELD_DECL__ID_LIST = eINSTANCE.getfieldDecl_IdList();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIELD_DECL__TYPE = eINSTANCE.getfieldDecl_Type();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD_DECL__PORT = eINSTANCE.getfieldDecl_Port();

		/**
		 * The meta object literal for the '{@link delphi.impl.variantSectionImpl <em>variant Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.variantSectionImpl
		 * @see delphi.impl.DelphiPackageImpl#getvariantSection()
		 * @generated
		 */
		EClass VARIANT_SECTION = eINSTANCE.getvariantSection();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIANT_SECTION__ID = eINSTANCE.getvariantSection_Id();

		/**
		 * The meta object literal for the '<em><b>Type Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIANT_SECTION__TYPE_REF = eINSTANCE.getvariantSection_TypeRef();

		/**
		 * The meta object literal for the '<em><b>Rec Variants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIANT_SECTION__REC_VARIANTS = eINSTANCE.getvariantSection_RecVariants();

		/**
		 * The meta object literal for the '{@link delphi.impl.recVariantImpl <em>rec Variant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.recVariantImpl
		 * @see delphi.impl.DelphiPackageImpl#getrecVariant()
		 * @generated
		 */
		EClass REC_VARIANT = eINSTANCE.getrecVariant();

		/**
		 * The meta object literal for the '<em><b>Const Exp</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REC_VARIANT__CONST_EXP = eINSTANCE.getrecVariant_ConstExp();

		/**
		 * The meta object literal for the '<em><b>Field List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REC_VARIANT__FIELD_LIST = eINSTANCE.getrecVariant_FieldList();

		/**
		 * The meta object literal for the '{@link delphi.impl.setTypeImpl <em>set Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.setTypeImpl
		 * @see delphi.impl.DelphiPackageImpl#getsetType()
		 * @generated
		 */
		EClass SET_TYPE = eINSTANCE.getsetType();

		/**
		 * The meta object literal for the '<em><b>Ordinal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_TYPE__ORDINAL = eINSTANCE.getsetType_Ordinal();

		/**
		 * The meta object literal for the '{@link delphi.impl.fileTypeImpl <em>file Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.fileTypeImpl
		 * @see delphi.impl.DelphiPackageImpl#getfileType()
		 * @generated
		 */
		EClass FILE_TYPE = eINSTANCE.getfileType();

		/**
		 * The meta object literal for the '<em><b>Type Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE_TYPE__TYPE_REF = eINSTANCE.getfileType_TypeRef();

		/**
		 * The meta object literal for the '{@link delphi.impl.pointerTypeImpl <em>pointer Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.pointerTypeImpl
		 * @see delphi.impl.DelphiPackageImpl#getpointerType()
		 * @generated
		 */
		EClass POINTER_TYPE = eINSTANCE.getpointerType();

		/**
		 * The meta object literal for the '{@link delphi.impl.procedureTypeImpl <em>procedure Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.procedureTypeImpl
		 * @see delphi.impl.DelphiPackageImpl#getprocedureType()
		 * @generated
		 */
		EClass PROCEDURE_TYPE = eINSTANCE.getprocedureType();

		/**
		 * The meta object literal for the '<em><b>PHeading</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE_TYPE__PHEADING = eINSTANCE.getprocedureType_PHeading();

		/**
		 * The meta object literal for the '<em><b>FHeading</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE_TYPE__FHEADING = eINSTANCE.getprocedureType_FHeading();

		/**
		 * The meta object literal for the '{@link delphi.impl.varSectionImpl <em>var Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.varSectionImpl
		 * @see delphi.impl.DelphiPackageImpl#getvarSection()
		 * @generated
		 */
		EClass VAR_SECTION = eINSTANCE.getvarSection();

		/**
		 * The meta object literal for the '<em><b>Var Decls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_SECTION__VAR_DECLS = eINSTANCE.getvarSection_VarDecls();

		/**
		 * The meta object literal for the '{@link delphi.impl.varDeclImpl <em>var Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.varDeclImpl
		 * @see delphi.impl.DelphiPackageImpl#getvarDecl()
		 * @generated
		 */
		EClass VAR_DECL = eINSTANCE.getvarDecl();

		/**
		 * The meta object literal for the '<em><b>Id List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_DECL__ID_LIST = eINSTANCE.getvarDecl_IdList();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_DECL__TYPE = eINSTANCE.getvarDecl_Type();

		/**
		 * The meta object literal for the '<em><b>Abs Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_DECL__ABS_ID = eINSTANCE.getvarDecl_AbsId();

		/**
		 * The meta object literal for the '<em><b>Abs Const</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_DECL__ABS_CONST = eINSTANCE.getvarDecl_AbsConst();

		/**
		 * The meta object literal for the '<em><b>Abs Initi</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_DECL__ABS_INITI = eINSTANCE.getvarDecl_AbsIniti();

		/**
		 * The meta object literal for the '{@link delphi.impl.expressionImpl <em>expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.expressionImpl
		 * @see delphi.impl.DelphiPackageImpl#getexpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getexpression();

		/**
		 * The meta object literal for the '{@link delphi.impl.simpleExpressionImpl <em>simple Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.simpleExpressionImpl
		 * @see delphi.impl.DelphiPackageImpl#getsimpleExpression()
		 * @generated
		 */
		EClass SIMPLE_EXPRESSION = eINSTANCE.getsimpleExpression();

		/**
		 * The meta object literal for the '{@link delphi.impl.termImpl <em>term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.termImpl
		 * @see delphi.impl.DelphiPackageImpl#getterm()
		 * @generated
		 */
		EClass TERM = eINSTANCE.getterm();

		/**
		 * The meta object literal for the '{@link delphi.impl.factorImpl <em>factor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.factorImpl
		 * @see delphi.impl.DelphiPackageImpl#getfactor()
		 * @generated
		 */
		EClass FACTOR = eINSTANCE.getfactor();

		/**
		 * The meta object literal for the '<em><b>Designator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACTOR__DESIGNATOR = eINSTANCE.getfactor_Designator();

		/**
		 * The meta object literal for the '<em><b>Exp List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACTOR__EXP_LIST = eINSTANCE.getfactor_ExpList();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACTOR__NUMBER = eINSTANCE.getfactor_Number();

		/**
		 * The meta object literal for the '<em><b>String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACTOR__STRING = eINSTANCE.getfactor_String();

		/**
		 * The meta object literal for the '<em><b>Nested Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACTOR__NESTED_EXP = eINSTANCE.getfactor_NestedExp();

		/**
		 * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACTOR__EXP = eINSTANCE.getfactor_Exp();

		/**
		 * The meta object literal for the '<em><b>Set Constuctor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACTOR__SET_CONSTUCTOR = eINSTANCE.getfactor_SetConstuctor();

		/**
		 * The meta object literal for the '<em><b>Type Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACTOR__TYPE_REF = eINSTANCE.getfactor_TypeRef();

		/**
		 * The meta object literal for the '{@link delphi.impl.relOpImpl <em>rel Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.relOpImpl
		 * @see delphi.impl.DelphiPackageImpl#getrelOp()
		 * @generated
		 */
		EClass REL_OP = eINSTANCE.getrelOp();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REL_OP__OP = eINSTANCE.getrelOp_Op();

		/**
		 * The meta object literal for the '{@link delphi.impl.addOpImpl <em>add Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.addOpImpl
		 * @see delphi.impl.DelphiPackageImpl#getaddOp()
		 * @generated
		 */
		EClass ADD_OP = eINSTANCE.getaddOp();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_OP__OP = eINSTANCE.getaddOp_Op();

		/**
		 * The meta object literal for the '{@link delphi.impl.mulOpImpl <em>mul Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.mulOpImpl
		 * @see delphi.impl.DelphiPackageImpl#getmulOp()
		 * @generated
		 */
		EClass MUL_OP = eINSTANCE.getmulOp();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MUL_OP__OP = eINSTANCE.getmulOp_Op();

		/**
		 * The meta object literal for the '{@link delphi.impl.designatorImpl <em>designator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.designatorImpl
		 * @see delphi.impl.DelphiPackageImpl#getdesignator()
		 * @generated
		 */
		EClass DESIGNATOR = eINSTANCE.getdesignator();

		/**
		 * The meta object literal for the '<em><b>Subpart</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESIGNATOR__SUBPART = eINSTANCE.getdesignator_Subpart();

		/**
		 * The meta object literal for the '<em><b>Designator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESIGNATOR__DESIGNATOR = eINSTANCE.getdesignator_Designator();

		/**
		 * The meta object literal for the '{@link delphi.impl.designatorSubPartImpl <em>designator Sub Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.designatorSubPartImpl
		 * @see delphi.impl.DelphiPackageImpl#getdesignatorSubPart()
		 * @generated
		 */
		EClass DESIGNATOR_SUB_PART = eINSTANCE.getdesignatorSubPart();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESIGNATOR_SUB_PART__PART = eINSTANCE.getdesignatorSubPart_Part();

		/**
		 * The meta object literal for the '<em><b>Expr List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESIGNATOR_SUB_PART__EXPR_LIST = eINSTANCE.getdesignatorSubPart_ExprList();

		/**
		 * The meta object literal for the '{@link delphi.impl.designatorPartImpl <em>designator Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.designatorPartImpl
		 * @see delphi.impl.DelphiPackageImpl#getdesignatorPart()
		 * @generated
		 */
		EClass DESIGNATOR_PART = eINSTANCE.getdesignatorPart();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESIGNATOR_PART__ID = eINSTANCE.getdesignatorPart_Id();

		/**
		 * The meta object literal for the '<em><b>Reserved Word</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESIGNATOR_PART__RESERVED_WORD = eINSTANCE.getdesignatorPart_ReservedWord();

		/**
		 * The meta object literal for the '<em><b>Id2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESIGNATOR_PART__ID2 = eINSTANCE.getdesignatorPart_Id2();

		/**
		 * The meta object literal for the '{@link delphi.impl.setConstructorImpl <em>set Constructor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.setConstructorImpl
		 * @see delphi.impl.DelphiPackageImpl#getsetConstructor()
		 * @generated
		 */
		EClass SET_CONSTRUCTOR = eINSTANCE.getsetConstructor();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_CONSTRUCTOR__ELEMENT = eINSTANCE.getsetConstructor_Element();

		/**
		 * The meta object literal for the '{@link delphi.impl.setElementImpl <em>set Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.setElementImpl
		 * @see delphi.impl.DelphiPackageImpl#getsetElement()
		 * @generated
		 */
		EClass SET_ELEMENT = eINSTANCE.getsetElement();

		/**
		 * The meta object literal for the '<em><b>First</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_ELEMENT__FIRST = eINSTANCE.getsetElement_First();

		/**
		 * The meta object literal for the '<em><b>Last</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_ELEMENT__LAST = eINSTANCE.getsetElement_Last();

		/**
		 * The meta object literal for the '{@link delphi.impl.exprListImpl <em>expr List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.exprListImpl
		 * @see delphi.impl.DelphiPackageImpl#getexprList()
		 * @generated
		 */
		EClass EXPR_LIST = eINSTANCE.getexprList();

		/**
		 * The meta object literal for the '<em><b>Exps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPR_LIST__EXPS = eINSTANCE.getexprList_Exps();

		/**
		 * The meta object literal for the '{@link delphi.impl.stmtListImpl <em>stmt List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.stmtListImpl
		 * @see delphi.impl.DelphiPackageImpl#getstmtList()
		 * @generated
		 */
		EClass STMT_LIST = eINSTANCE.getstmtList();

		/**
		 * The meta object literal for the '<em><b>Statments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STMT_LIST__STATMENTS = eINSTANCE.getstmtList_Statments();

		/**
		 * The meta object literal for the '{@link delphi.impl.statementImpl <em>statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.statementImpl
		 * @see delphi.impl.DelphiPackageImpl#getstatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getstatement();

		/**
		 * The meta object literal for the '<em><b>Label Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEMENT__LABEL_ID = eINSTANCE.getstatement_LabelId();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATEMENT__STATEMENT = eINSTANCE.getstatement_Statement();

		/**
		 * The meta object literal for the '{@link delphi.impl.unlabelledStatementImpl <em>unlabelled Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.unlabelledStatementImpl
		 * @see delphi.impl.DelphiPackageImpl#getunlabelledStatement()
		 * @generated
		 */
		EClass UNLABELLED_STATEMENT = eINSTANCE.getunlabelledStatement();

		/**
		 * The meta object literal for the '{@link delphi.impl.simpleStatementImpl <em>simple Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.simpleStatementImpl
		 * @see delphi.impl.DelphiPackageImpl#getsimpleStatement()
		 * @generated
		 */
		EClass SIMPLE_STATEMENT = eINSTANCE.getsimpleStatement();

		/**
		 * The meta object literal for the '{@link delphi.impl.structStmtImpl <em>struct Stmt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.structStmtImpl
		 * @see delphi.impl.DelphiPackageImpl#getstructStmt()
		 * @generated
		 */
		EClass STRUCT_STMT = eINSTANCE.getstructStmt();

		/**
		 * The meta object literal for the '{@link delphi.impl.compoundStmtImpl <em>compound Stmt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.compoundStmtImpl
		 * @see delphi.impl.DelphiPackageImpl#getcompoundStmt()
		 * @generated
		 */
		EClass COMPOUND_STMT = eINSTANCE.getcompoundStmt();

		/**
		 * The meta object literal for the '<em><b>Stamt List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOUND_STMT__STAMT_LIST = eINSTANCE.getcompoundStmt_StamtList();

		/**
		 * The meta object literal for the '{@link delphi.impl.conditionalStmtImpl <em>conditional Stmt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.conditionalStmtImpl
		 * @see delphi.impl.DelphiPackageImpl#getconditionalStmt()
		 * @generated
		 */
		EClass CONDITIONAL_STMT = eINSTANCE.getconditionalStmt();

		/**
		 * The meta object literal for the '{@link delphi.impl.ifStmtImpl <em>if Stmt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.ifStmtImpl
		 * @see delphi.impl.DelphiPackageImpl#getifStmt()
		 * @generated
		 */
		EClass IF_STMT = eINSTANCE.getifStmt();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STMT__CONDITION = eINSTANCE.getifStmt_Condition();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STMT__THEN = eINSTANCE.getifStmt_Then();

		/**
		 * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STMT__ELSE = eINSTANCE.getifStmt_Else();

		/**
		 * The meta object literal for the '{@link delphi.impl.caseStmtImpl <em>case Stmt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.caseStmtImpl
		 * @see delphi.impl.DelphiPackageImpl#getcaseStmt()
		 * @generated
		 */
		EClass CASE_STMT = eINSTANCE.getcaseStmt();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_STMT__EXPRESSION = eINSTANCE.getcaseStmt_Expression();

		/**
		 * The meta object literal for the '<em><b>Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_STMT__CASES = eINSTANCE.getcaseStmt_Cases();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_STMT__DEFAULT = eINSTANCE.getcaseStmt_Default();

		/**
		 * The meta object literal for the '{@link delphi.impl.caseSelectorImpl <em>case Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.caseSelectorImpl
		 * @see delphi.impl.DelphiPackageImpl#getcaseSelector()
		 * @generated
		 */
		EClass CASE_SELECTOR = eINSTANCE.getcaseSelector();

		/**
		 * The meta object literal for the '<em><b>Labels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_SELECTOR__LABELS = eINSTANCE.getcaseSelector_Labels();

		/**
		 * The meta object literal for the '<em><b>Stmt</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_SELECTOR__STMT = eINSTANCE.getcaseSelector_Stmt();

		/**
		 * The meta object literal for the '{@link delphi.impl.caseLabelImpl <em>case Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.caseLabelImpl
		 * @see delphi.impl.DelphiPackageImpl#getcaseLabel()
		 * @generated
		 */
		EClass CASE_LABEL = eINSTANCE.getcaseLabel();

		/**
		 * The meta object literal for the '<em><b>First</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_LABEL__FIRST = eINSTANCE.getcaseLabel_First();

		/**
		 * The meta object literal for the '<em><b>Last</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_LABEL__LAST = eINSTANCE.getcaseLabel_Last();

		/**
		 * The meta object literal for the '{@link delphi.impl.loopStmtImpl <em>loop Stmt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.loopStmtImpl
		 * @see delphi.impl.DelphiPackageImpl#getloopStmt()
		 * @generated
		 */
		EClass LOOP_STMT = eINSTANCE.getloopStmt();

		/**
		 * The meta object literal for the '<em><b>Stmt</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_STMT__STMT = eINSTANCE.getloopStmt_Stmt();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_STMT__CONDITION = eINSTANCE.getloopStmt_Condition();

		/**
		 * The meta object literal for the '{@link delphi.impl.repeatStmtImpl <em>repeat Stmt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.repeatStmtImpl
		 * @see delphi.impl.DelphiPackageImpl#getrepeatStmt()
		 * @generated
		 */
		EClass REPEAT_STMT = eINSTANCE.getrepeatStmt();

		/**
		 * The meta object literal for the '{@link delphi.impl.whileStmtImpl <em>while Stmt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.whileStmtImpl
		 * @see delphi.impl.DelphiPackageImpl#getwhileStmt()
		 * @generated
		 */
		EClass WHILE_STMT = eINSTANCE.getwhileStmt();

		/**
		 * The meta object literal for the '{@link delphi.impl.forStmtImpl <em>for Stmt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.forStmtImpl
		 * @see delphi.impl.DelphiPackageImpl#getforStmt()
		 * @generated
		 */
		EClass FOR_STMT = eINSTANCE.getforStmt();

		/**
		 * The meta object literal for the '<em><b>Var Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STMT__VAR_ID = eINSTANCE.getforStmt_VarId();

		/**
		 * The meta object literal for the '<em><b>Var Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STMT__VAR_INIT = eINSTANCE.getforStmt_VarInit();

		/**
		 * The meta object literal for the '{@link delphi.impl.withStmtImpl <em>with Stmt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.withStmtImpl
		 * @see delphi.impl.DelphiPackageImpl#getwithStmt()
		 * @generated
		 */
		EClass WITH_STMT = eINSTANCE.getwithStmt();

		/**
		 * The meta object literal for the '<em><b>Vars</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WITH_STMT__VARS = eINSTANCE.getwithStmt_Vars();

		/**
		 * The meta object literal for the '<em><b>Stmt</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WITH_STMT__STMT = eINSTANCE.getwithStmt_Stmt();

		/**
		 * The meta object literal for the '{@link delphi.impl.tryStmtImpl <em>try Stmt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.tryStmtImpl
		 * @see delphi.impl.DelphiPackageImpl#gettryStmt()
		 * @generated
		 */
		EClass TRY_STMT = eINSTANCE.gettryStmt();

		/**
		 * The meta object literal for the '<em><b>Stmt List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRY_STMT__STMT_LIST = eINSTANCE.gettryStmt_StmtList();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRY_STMT__EXCEPTION = eINSTANCE.gettryStmt_Exception();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRY_STMT__FINAL = eINSTANCE.gettryStmt_Final();

		/**
		 * The meta object literal for the '{@link delphi.impl.exceptionBlockImpl <em>exception Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.exceptionBlockImpl
		 * @see delphi.impl.DelphiPackageImpl#getexceptionBlock()
		 * @generated
		 */
		EClass EXCEPTION_BLOCK = eINSTANCE.getexceptionBlock();

		/**
		 * The meta object literal for the '<em><b>Exception Id</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXCEPTION_BLOCK__EXCEPTION_ID = eINSTANCE.getexceptionBlock_ExceptionId();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXCEPTION_BLOCK__TYPE = eINSTANCE.getexceptionBlock_Type();

		/**
		 * The meta object literal for the '<em><b>Do Stmt</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXCEPTION_BLOCK__DO_STMT = eINSTANCE.getexceptionBlock_DoStmt();

		/**
		 * The meta object literal for the '<em><b>Else Stmts</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXCEPTION_BLOCK__ELSE_STMTS = eINSTANCE.getexceptionBlock_ElseStmts();

		/**
		 * The meta object literal for the '{@link delphi.impl.raiseStmtImpl <em>raise Stmt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.raiseStmtImpl
		 * @see delphi.impl.DelphiPackageImpl#getraiseStmt()
		 * @generated
		 */
		EClass RAISE_STMT = eINSTANCE.getraiseStmt();

		/**
		 * The meta object literal for the '<em><b>Raise</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAISE_STMT__RAISE = eINSTANCE.getraiseStmt_Raise();

		/**
		 * The meta object literal for the '<em><b>At</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAISE_STMT__AT = eINSTANCE.getraiseStmt_At();

		/**
		 * The meta object literal for the '{@link delphi.impl.assemblerStmtImpl <em>assembler Stmt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.assemblerStmtImpl
		 * @see delphi.impl.DelphiPackageImpl#getassemblerStmt()
		 * @generated
		 */
		EClass ASSEMBLER_STMT = eINSTANCE.getassemblerStmt();

		/**
		 * The meta object literal for the '{@link delphi.impl.procedureDeclSectionImpl <em>procedure Decl Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.procedureDeclSectionImpl
		 * @see delphi.impl.DelphiPackageImpl#getprocedureDeclSection()
		 * @generated
		 */
		EClass PROCEDURE_DECL_SECTION = eINSTANCE.getprocedureDeclSection();

		/**
		 * The meta object literal for the '<em><b>Directive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE_DECL_SECTION__DIRECTIVE = eINSTANCE.getprocedureDeclSection_Directive();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCEDURE_DECL_SECTION__PORT = eINSTANCE.getprocedureDeclSection_Port();

		/**
		 * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE_DECL_SECTION__BLOCK = eINSTANCE.getprocedureDeclSection_Block();

		/**
		 * The meta object literal for the '{@link delphi.impl.procedureDeclImpl <em>procedure Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.procedureDeclImpl
		 * @see delphi.impl.DelphiPackageImpl#getprocedureDecl()
		 * @generated
		 */
		EClass PROCEDURE_DECL = eINSTANCE.getprocedureDecl();

		/**
		 * The meta object literal for the '<em><b>Heading</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE_DECL__HEADING = eINSTANCE.getprocedureDecl_Heading();

		/**
		 * The meta object literal for the '{@link delphi.impl.functionDeclImpl <em>function Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.functionDeclImpl
		 * @see delphi.impl.DelphiPackageImpl#getfunctionDecl()
		 * @generated
		 */
		EClass FUNCTION_DECL = eINSTANCE.getfunctionDecl();

		/**
		 * The meta object literal for the '<em><b>Heading</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DECL__HEADING = eINSTANCE.getfunctionDecl_Heading();

		/**
		 * The meta object literal for the '{@link delphi.impl.functionHeadingImpl <em>function Heading</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.functionHeadingImpl
		 * @see delphi.impl.DelphiPackageImpl#getfunctionHeading()
		 * @generated
		 */
		EClass FUNCTION_HEADING = eINSTANCE.getfunctionHeading();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_HEADING__TYPE = eINSTANCE.getfunctionHeading_Type();

		/**
		 * The meta object literal for the '{@link delphi.impl.procedureHeadingImpl <em>procedure Heading</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.procedureHeadingImpl
		 * @see delphi.impl.DelphiPackageImpl#getprocedureHeading()
		 * @generated
		 */
		EClass PROCEDURE_HEADING = eINSTANCE.getprocedureHeading();

		/**
		 * The meta object literal for the '{@link delphi.impl.formalParametersImpl <em>formal Parameters</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.formalParametersImpl
		 * @see delphi.impl.DelphiPackageImpl#getformalParameters()
		 * @generated
		 */
		EClass FORMAL_PARAMETERS = eINSTANCE.getformalParameters();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMAL_PARAMETERS__PARAMS = eINSTANCE.getformalParameters_Params();

		/**
		 * The meta object literal for the '{@link delphi.impl.formalParmImpl <em>formal Parm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.formalParmImpl
		 * @see delphi.impl.DelphiPackageImpl#getformalParm()
		 * @generated
		 */
		EClass FORMAL_PARM = eINSTANCE.getformalParm();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMAL_PARM__PARAM = eINSTANCE.getformalParm_Param();

		/**
		 * The meta object literal for the '{@link delphi.impl.parameterImpl <em>parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.parameterImpl
		 * @see delphi.impl.DelphiPackageImpl#getparameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getparameter();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__TYPE = eINSTANCE.getparameter_Type();

		/**
		 * The meta object literal for the '{@link delphi.impl.directiveImpl <em>directive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.directiveImpl
		 * @see delphi.impl.DelphiPackageImpl#getdirective()
		 * @generated
		 */
		EClass DIRECTIVE = eINSTANCE.getdirective();

		/**
		 * The meta object literal for the '<em><b>Dir</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTIVE__DIR = eINSTANCE.getdirective_Dir();

		/**
		 * The meta object literal for the '<em><b>Message Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTIVE__MESSAGE_EXP = eINSTANCE.getdirective_MessageExp();

		/**
		 * The meta object literal for the '{@link delphi.impl.objectTypeImpl <em>object Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.objectTypeImpl
		 * @see delphi.impl.DelphiPackageImpl#getobjectType()
		 * @generated
		 */
		EClass OBJECT_TYPE = eINSTANCE.getobjectType();

		/**
		 * The meta object literal for the '<em><b>Heritage</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_TYPE__HERITAGE = eINSTANCE.getobjectType_Heritage();

		/**
		 * The meta object literal for the '<em><b>Field List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_TYPE__FIELD_LIST = eINSTANCE.getobjectType_FieldList();

		/**
		 * The meta object literal for the '<em><b>Method List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_TYPE__METHOD_LIST = eINSTANCE.getobjectType_MethodList();

		/**
		 * The meta object literal for the '{@link delphi.impl.objHeritageImpl <em>obj Heritage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.objHeritageImpl
		 * @see delphi.impl.DelphiPackageImpl#getobjHeritage()
		 * @generated
		 */
		EClass OBJ_HERITAGE = eINSTANCE.getobjHeritage();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJ_HERITAGE__ID = eINSTANCE.getobjHeritage_Id();

		/**
		 * The meta object literal for the '{@link delphi.impl.methodListImpl <em>method List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.methodListImpl
		 * @see delphi.impl.DelphiPackageImpl#getmethodList()
		 * @generated
		 */
		EClass METHOD_LIST = eINSTANCE.getmethodList();

		/**
		 * The meta object literal for the '<em><b>Heading</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_LIST__HEADING = eINSTANCE.getmethodList_Heading();

		/**
		 * The meta object literal for the '<em><b>Directive</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_LIST__DIRECTIVE = eINSTANCE.getmethodList_Directive();

		/**
		 * The meta object literal for the '{@link delphi.impl.methodHeadingImpl <em>method Heading</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.methodHeadingImpl
		 * @see delphi.impl.DelphiPackageImpl#getmethodHeading()
		 * @generated
		 */
		EClass METHOD_HEADING = eINSTANCE.getmethodHeading();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_HEADING__ID = eINSTANCE.getmethodHeading_Id();

		/**
		 * The meta object literal for the '<em><b>Formal Params</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_HEADING__FORMAL_PARAMS = eINSTANCE.getmethodHeading_FormalParams();

		/**
		 * The meta object literal for the '{@link delphi.impl.constructorHeadingImpl <em>constructor Heading</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.constructorHeadingImpl
		 * @see delphi.impl.DelphiPackageImpl#getconstructorHeading()
		 * @generated
		 */
		EClass CONSTRUCTOR_HEADING = eINSTANCE.getconstructorHeading();

		/**
		 * The meta object literal for the '{@link delphi.impl.destructorHeadingImpl <em>destructor Heading</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.destructorHeadingImpl
		 * @see delphi.impl.DelphiPackageImpl#getdestructorHeading()
		 * @generated
		 */
		EClass DESTRUCTOR_HEADING = eINSTANCE.getdestructorHeading();

		/**
		 * The meta object literal for the '{@link delphi.impl.objFieldListImpl <em>obj Field List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.objFieldListImpl
		 * @see delphi.impl.DelphiPackageImpl#getobjFieldList()
		 * @generated
		 */
		EClass OBJ_FIELD_LIST = eINSTANCE.getobjFieldList();

		/**
		 * The meta object literal for the '{@link delphi.impl.initSectionImpl <em>init Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.initSectionImpl
		 * @see delphi.impl.DelphiPackageImpl#getinitSection()
		 * @generated
		 */
		EClass INIT_SECTION = eINSTANCE.getinitSection();

		/**
		 * The meta object literal for the '<em><b>Stmt List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INIT_SECTION__STMT_LIST = eINSTANCE.getinitSection_StmtList();

		/**
		 * The meta object literal for the '<em><b>End Stmt List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INIT_SECTION__END_STMT_LIST = eINSTANCE.getinitSection_EndStmtList();

		/**
		 * The meta object literal for the '{@link delphi.impl.classTypeImpl <em>class Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.classTypeImpl
		 * @see delphi.impl.DelphiPackageImpl#getclassType()
		 * @generated
		 */
		EClass CLASS_TYPE = eINSTANCE.getclassType();

		/**
		 * The meta object literal for the '<em><b>Heritage</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TYPE__HERITAGE = eINSTANCE.getclassType_Heritage();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_TYPE__VISIBILITY = eINSTANCE.getclassType_Visibility();

		/**
		 * The meta object literal for the '<em><b>Field List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TYPE__FIELD_LIST = eINSTANCE.getclassType_FieldList();

		/**
		 * The meta object literal for the '<em><b>Method List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TYPE__METHOD_LIST = eINSTANCE.getclassType_MethodList();

		/**
		 * The meta object literal for the '<em><b>Prop List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_TYPE__PROP_LIST = eINSTANCE.getclassType_PropList();

		/**
		 * The meta object literal for the '{@link delphi.impl.classHeritageImpl <em>class Heritage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.classHeritageImpl
		 * @see delphi.impl.DelphiPackageImpl#getclassHeritage()
		 * @generated
		 */
		EClass CLASS_HERITAGE = eINSTANCE.getclassHeritage();

		/**
		 * The meta object literal for the '{@link delphi.impl.classFieldListImpl <em>class Field List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.classFieldListImpl
		 * @see delphi.impl.DelphiPackageImpl#getclassFieldList()
		 * @generated
		 */
		EClass CLASS_FIELD_LIST = eINSTANCE.getclassFieldList();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_FIELD_LIST__FIELD = eINSTANCE.getclassFieldList_Field();

		/**
		 * The meta object literal for the '{@link delphi.impl.classFieldImpl <em>class Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.classFieldImpl
		 * @see delphi.impl.DelphiPackageImpl#getclassField()
		 * @generated
		 */
		EClass CLASS_FIELD = eINSTANCE.getclassField();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_FIELD__VISIBILITY = eINSTANCE.getclassField_Visibility();

		/**
		 * The meta object literal for the '<em><b>Field List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_FIELD__FIELD_LIST = eINSTANCE.getclassField_FieldList();

		/**
		 * The meta object literal for the '{@link delphi.impl.classMethodListImpl <em>class Method List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.classMethodListImpl
		 * @see delphi.impl.DelphiPackageImpl#getclassMethodList()
		 * @generated
		 */
		EClass CLASS_METHOD_LIST = eINSTANCE.getclassMethodList();

		/**
		 * The meta object literal for the '<em><b>Metod</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_METHOD_LIST__METOD = eINSTANCE.getclassMethodList_Metod();

		/**
		 * The meta object literal for the '{@link delphi.impl.classMethodImpl <em>class Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.classMethodImpl
		 * @see delphi.impl.DelphiPackageImpl#getclassMethod()
		 * @generated
		 */
		EClass CLASS_METHOD = eINSTANCE.getclassMethod();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_METHOD__VISIBILITY = eINSTANCE.getclassMethod_Visibility();

		/**
		 * The meta object literal for the '<em><b>Method List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_METHOD__METHOD_LIST = eINSTANCE.getclassMethod_MethodList();

		/**
		 * The meta object literal for the '{@link delphi.impl.classPropertyListImpl <em>class Property List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.classPropertyListImpl
		 * @see delphi.impl.DelphiPackageImpl#getclassPropertyList()
		 * @generated
		 */
		EClass CLASS_PROPERTY_LIST = eINSTANCE.getclassPropertyList();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_PROPERTY_LIST__PROPERTY = eINSTANCE.getclassPropertyList_Property();

		/**
		 * The meta object literal for the '{@link delphi.impl.classPropertyImpl <em>class Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.classPropertyImpl
		 * @see delphi.impl.DelphiPackageImpl#getclassProperty()
		 * @generated
		 */
		EClass CLASS_PROPERTY = eINSTANCE.getclassProperty();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_PROPERTY__VISIBILITY = eINSTANCE.getclassProperty_Visibility();

		/**
		 * The meta object literal for the '<em><b>Prop List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_PROPERTY__PROP_LIST = eINSTANCE.getclassProperty_PropList();

		/**
		 * The meta object literal for the '{@link delphi.impl.propertyListImpl <em>property List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.propertyListImpl
		 * @see delphi.impl.DelphiPackageImpl#getpropertyList()
		 * @generated
		 */
		EClass PROPERTY_LIST = eINSTANCE.getpropertyList();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_LIST__ID = eINSTANCE.getpropertyList_Id();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_LIST__INTERFACE = eINSTANCE.getpropertyList_Interface();

		/**
		 * The meta object literal for the '<em><b>Specifiers</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_LIST__SPECIFIERS = eINSTANCE.getpropertyList_Specifiers();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_LIST__PORT = eINSTANCE.getpropertyList_Port();

		/**
		 * The meta object literal for the '{@link delphi.impl.propertyInterfaceImpl <em>property Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.propertyInterfaceImpl
		 * @see delphi.impl.DelphiPackageImpl#getpropertyInterface()
		 * @generated
		 */
		EClass PROPERTY_INTERFACE = eINSTANCE.getpropertyInterface();

		/**
		 * The meta object literal for the '<em><b>Param List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_INTERFACE__PARAM_LIST = eINSTANCE.getpropertyInterface_ParamList();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_INTERFACE__ID = eINSTANCE.getpropertyInterface_Id();

		/**
		 * The meta object literal for the '{@link delphi.impl.propertyParameterListImpl <em>property Parameter List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.propertyParameterListImpl
		 * @see delphi.impl.DelphiPackageImpl#getpropertyParameterList()
		 * @generated
		 */
		EClass PROPERTY_PARAMETER_LIST = eINSTANCE.getpropertyParameterList();

		/**
		 * The meta object literal for the '<em><b>Id List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_PARAMETER_LIST__ID_LIST = eINSTANCE.getpropertyParameterList_IdList();

		/**
		 * The meta object literal for the '<em><b>Type Ref</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_PARAMETER_LIST__TYPE_REF = eINSTANCE.getpropertyParameterList_TypeRef();

		/**
		 * The meta object literal for the '{@link delphi.impl.propertySpecifiersImpl <em>property Specifiers</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.propertySpecifiersImpl
		 * @see delphi.impl.DelphiPackageImpl#getpropertySpecifiers()
		 * @generated
		 */
		EClass PROPERTY_SPECIFIERS = eINSTANCE.getpropertySpecifiers();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_SPECIFIERS__INDEX = eINSTANCE.getpropertySpecifiers_Index();

		/**
		 * The meta object literal for the '<em><b>Read Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_SPECIFIERS__READ_ID = eINSTANCE.getpropertySpecifiers_ReadId();

		/**
		 * The meta object literal for the '<em><b>Write Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_SPECIFIERS__WRITE_ID = eINSTANCE.getpropertySpecifiers_WriteId();

		/**
		 * The meta object literal for the '<em><b>Store Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_SPECIFIERS__STORE_ID = eINSTANCE.getpropertySpecifiers_StoreId();

		/**
		 * The meta object literal for the '<em><b>Store Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_SPECIFIERS__STORE_EXP = eINSTANCE.getpropertySpecifiers_StoreExp();

		/**
		 * The meta object literal for the '<em><b>Defaul Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_SPECIFIERS__DEFAUL_EXP = eINSTANCE.getpropertySpecifiers_DefaulExp();

		/**
		 * The meta object literal for the '<em><b>Implement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_SPECIFIERS__IMPLEMENT = eINSTANCE.getpropertySpecifiers_Implement();

		/**
		 * The meta object literal for the '{@link delphi.impl.interfaceTypeImpl <em>interface Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.interfaceTypeImpl
		 * @see delphi.impl.DelphiPackageImpl#getinterfaceType()
		 * @generated
		 */
		EClass INTERFACE_TYPE = eINSTANCE.getinterfaceType();

		/**
		 * The meta object literal for the '<em><b>Heritage</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_TYPE__HERITAGE = eINSTANCE.getinterfaceType_Heritage();

		/**
		 * The meta object literal for the '<em><b>Method List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_TYPE__METHOD_LIST = eINSTANCE.getinterfaceType_MethodList();

		/**
		 * The meta object literal for the '<em><b>Prop List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_TYPE__PROP_LIST = eINSTANCE.getinterfaceType_PropList();

		/**
		 * The meta object literal for the '{@link delphi.impl.interfaceHeritageImpl <em>interface Heritage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.interfaceHeritageImpl
		 * @see delphi.impl.DelphiPackageImpl#getinterfaceHeritage()
		 * @generated
		 */
		EClass INTERFACE_HERITAGE = eINSTANCE.getinterfaceHeritage();

		/**
		 * The meta object literal for the '<em><b>Id List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_HERITAGE__ID_LIST = eINSTANCE.getinterfaceHeritage_IdList();

		/**
		 * The meta object literal for the '{@link delphi.impl.requiresClauseImpl <em>requires Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.requiresClauseImpl
		 * @see delphi.impl.DelphiPackageImpl#getrequiresClause()
		 * @generated
		 */
		EClass REQUIRES_CLAUSE = eINSTANCE.getrequiresClause();

		/**
		 * The meta object literal for the '<em><b>Id List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIRES_CLAUSE__ID_LIST = eINSTANCE.getrequiresClause_IdList();

		/**
		 * The meta object literal for the '{@link delphi.impl.containsClauseImpl <em>contains Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.containsClauseImpl
		 * @see delphi.impl.DelphiPackageImpl#getcontainsClause()
		 * @generated
		 */
		EClass CONTAINS_CLAUSE = eINSTANCE.getcontainsClause();

		/**
		 * The meta object literal for the '<em><b>Id List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINS_CLAUSE__ID_LIST = eINSTANCE.getcontainsClause_IdList();

		/**
		 * The meta object literal for the '{@link delphi.impl.identListImpl <em>ident List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.identListImpl
		 * @see delphi.impl.DelphiPackageImpl#getidentList()
		 * @generated
		 */
		EClass IDENT_LIST = eINSTANCE.getidentList();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENT_LIST__TYPE = eINSTANCE.getidentList_Type();

		/**
		 * The meta object literal for the '<em><b>Ids</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENT_LIST__IDS = eINSTANCE.getidentList_Ids();

		/**
		 * The meta object literal for the '{@link delphi.impl.qualIdImpl <em>qual Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.qualIdImpl
		 * @see delphi.impl.DelphiPackageImpl#getqualId()
		 * @generated
		 */
		EClass QUAL_ID = eINSTANCE.getqualId();

		/**
		 * The meta object literal for the '<em><b>Unit Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUAL_ID__UNIT_ID = eINSTANCE.getqualId_UnitId();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUAL_ID__ID = eINSTANCE.getqualId_Id();

		/**
		 * The meta object literal for the '{@link delphi.impl.typeIdImpl <em>type Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.typeIdImpl
		 * @see delphi.impl.DelphiPackageImpl#gettypeId()
		 * @generated
		 */
		EClass TYPE_ID = eINSTANCE.gettypeId();

		/**
		 * The meta object literal for the '<em><b>Unit Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_ID__UNIT_ID = eINSTANCE.gettypeId_UnitId();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_ID__ID = eINSTANCE.gettypeId_Id();

		/**
		 * The meta object literal for the '{@link delphi.impl.identImpl <em>ident</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.identImpl
		 * @see delphi.impl.DelphiPackageImpl#getident()
		 * @generated
		 */
		EClass IDENT = eINSTANCE.getident();

		/**
		 * The meta object literal for the '{@link delphi.impl.reservedWordImpl <em>reserved Word</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.reservedWordImpl
		 * @see delphi.impl.DelphiPackageImpl#getreservedWord()
		 * @generated
		 */
		EClass RESERVED_WORD = eINSTANCE.getreservedWord();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESERVED_WORD__ID = eINSTANCE.getreservedWord_Id();

		/**
		 * The meta object literal for the '{@link delphi.impl.constExprImpl <em>const Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.constExprImpl
		 * @see delphi.impl.DelphiPackageImpl#getconstExpr()
		 * @generated
		 */
		EClass CONST_EXPR = eINSTANCE.getconstExpr();

		/**
		 * The meta object literal for the '{@link delphi.impl.recordConstExprImpl <em>record Const Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.recordConstExprImpl
		 * @see delphi.impl.DelphiPackageImpl#getrecordConstExpr()
		 * @generated
		 */
		EClass RECORD_CONST_EXPR = eINSTANCE.getrecordConstExpr();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECORD_CONST_EXPR__ID = eINSTANCE.getrecordConstExpr_Id();

		/**
		 * The meta object literal for the '<em><b>Const Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECORD_CONST_EXPR__CONST_EXP = eINSTANCE.getrecordConstExpr_ConstExp();

		/**
		 * The meta object literal for the '{@link delphi.impl.unitIdImpl <em>unit Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.unitIdImpl
		 * @see delphi.impl.DelphiPackageImpl#getunitId()
		 * @generated
		 */
		EClass UNIT_ID = eINSTANCE.getunitId();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_ID__ID = eINSTANCE.getunitId_Id();

		/**
		 * The meta object literal for the '{@link delphi.impl.relExpImpl <em>rel Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.relExpImpl
		 * @see delphi.impl.DelphiPackageImpl#getrelExp()
		 * @generated
		 */
		EClass REL_EXP = eINSTANCE.getrelExp();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_EXP__LEFT = eINSTANCE.getrelExp_Left();

		/**
		 * The meta object literal for the '<em><b>Rel Op</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_EXP__REL_OP = eINSTANCE.getrelExp_RelOp();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_EXP__RIGHT = eINSTANCE.getrelExp_Right();

		/**
		 * The meta object literal for the '{@link delphi.impl.addExpImpl <em>add Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.addExpImpl
		 * @see delphi.impl.DelphiPackageImpl#getaddExp()
		 * @generated
		 */
		EClass ADD_EXP = eINSTANCE.getaddExp();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_EXP__LEFT = eINSTANCE.getaddExp_Left();

		/**
		 * The meta object literal for the '<em><b>Add Op</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_EXP__ADD_OP = eINSTANCE.getaddExp_AddOp();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_EXP__RIGHT = eINSTANCE.getaddExp_Right();

		/**
		 * The meta object literal for the '{@link delphi.impl.multExpImpl <em>mult Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.multExpImpl
		 * @see delphi.impl.DelphiPackageImpl#getmultExp()
		 * @generated
		 */
		EClass MULT_EXP = eINSTANCE.getmultExp();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULT_EXP__LEFT = eINSTANCE.getmultExp_Left();

		/**
		 * The meta object literal for the '<em><b>Mult Op</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULT_EXP__MULT_OP = eINSTANCE.getmultExp_MultOp();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULT_EXP__RIGHT = eINSTANCE.getmultExp_Right();

		/**
		 * The meta object literal for the '{@link delphi.impl.simpleFactorImpl <em>simple Factor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.simpleFactorImpl
		 * @see delphi.impl.DelphiPackageImpl#getsimpleFactor()
		 * @generated
		 */
		EClass SIMPLE_FACTOR = eINSTANCE.getsimpleFactor();

		/**
		 * The meta object literal for the '{@link delphi.impl.assignmentStmntImpl <em>assignment Stmnt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.assignmentStmntImpl
		 * @see delphi.impl.DelphiPackageImpl#getassignmentStmnt()
		 * @generated
		 */
		EClass ASSIGNMENT_STMNT = eINSTANCE.getassignmentStmnt();

		/**
		 * The meta object literal for the '<em><b>Designator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT_STMNT__DESIGNATOR = eINSTANCE.getassignmentStmnt_Designator();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGNMENT_STMNT__OPERATOR = eINSTANCE.getassignmentStmnt_Operator();

		/**
		 * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT_STMNT__EXP = eINSTANCE.getassignmentStmnt_Exp();

		/**
		 * The meta object literal for the '{@link delphi.impl.callStmntImpl <em>call Stmnt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.callStmntImpl
		 * @see delphi.impl.DelphiPackageImpl#getcallStmnt()
		 * @generated
		 */
		EClass CALL_STMNT = eINSTANCE.getcallStmnt();

		/**
		 * The meta object literal for the '<em><b>Designator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_STMNT__DESIGNATOR = eINSTANCE.getcallStmnt_Designator();

		/**
		 * The meta object literal for the '<em><b>Args</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_STMNT__ARGS = eINSTANCE.getcallStmnt_Args();

		/**
		 * The meta object literal for the '{@link delphi.impl.inheritedStamntImpl <em>inherited Stamnt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.inheritedStamntImpl
		 * @see delphi.impl.DelphiPackageImpl#getinheritedStamnt()
		 * @generated
		 */
		EClass INHERITED_STAMNT = eINSTANCE.getinheritedStamnt();

		/**
		 * The meta object literal for the '{@link delphi.impl.gotoStmntImpl <em>goto Stmnt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.gotoStmntImpl
		 * @see delphi.impl.DelphiPackageImpl#getgotoStmnt()
		 * @generated
		 */
		EClass GOTO_STMNT = eINSTANCE.getgotoStmnt();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOTO_STMNT__LABEL = eINSTANCE.getgotoStmnt_Label();

		/**
		 * The meta object literal for the '{@link delphi.impl.parameterListImpl <em>parameter List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.parameterListImpl
		 * @see delphi.impl.DelphiPackageImpl#getparameterList()
		 * @generated
		 */
		EClass PARAMETER_LIST = eINSTANCE.getparameterList();

		/**
		 * The meta object literal for the '<em><b>Id List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_LIST__ID_LIST = eINSTANCE.getparameterList_IdList();

		/**
		 * The meta object literal for the '{@link delphi.impl.parameterSimpleImpl <em>parameter Simple</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.parameterSimpleImpl
		 * @see delphi.impl.DelphiPackageImpl#getparameterSimple()
		 * @generated
		 */
		EClass PARAMETER_SIMPLE = eINSTANCE.getparameterSimple();

		/**
		 * The meta object literal for the '<em><b>If</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_SIMPLE__IF = eINSTANCE.getparameterSimple_If();

		/**
		 * The meta object literal for the '<em><b>Init Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_SIMPLE__INIT_EXP = eINSTANCE.getparameterSimple_InitExp();

		/**
		 * The meta object literal for the '{@link delphi.impl.MultipleIdImpl <em>Multiple Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.MultipleIdImpl
		 * @see delphi.impl.DelphiPackageImpl#getMultipleId()
		 * @generated
		 */
		EClass MULTIPLE_ID = eINSTANCE.getMultipleId();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLE_ID__ID = eINSTANCE.getMultipleId_Id();

		/**
		 * The meta object literal for the '{@link delphi.impl.ReservedIdImpl <em>Reserved Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.ReservedIdImpl
		 * @see delphi.impl.DelphiPackageImpl#getReservedId()
		 * @generated
		 */
		EClass RESERVED_ID = eINSTANCE.getReservedId();

		/**
		 * The meta object literal for the '<em><b>Reserved Word</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESERVED_ID__RESERVED_WORD = eINSTANCE.getReservedId_ReservedWord();

		/**
		 * The meta object literal for the '{@link delphi.impl.MineIDImpl <em>Mine ID</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.MineIDImpl
		 * @see delphi.impl.DelphiPackageImpl#getMineID()
		 * @generated
		 */
		EClass MINE_ID = eINSTANCE.getMineID();

		/**
		 * The meta object literal for the '<em><b>First</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MINE_ID__FIRST = eINSTANCE.getMineID_First();

		/**
		 * The meta object literal for the '<em><b>Second</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MINE_ID__SECOND = eINSTANCE.getMineID_Second();

		/**
		 * The meta object literal for the '{@link delphi.impl.ConstExpImpl <em>Const Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.ConstExpImpl
		 * @see delphi.impl.DelphiPackageImpl#getConstExp()
		 * @generated
		 */
		EClass CONST_EXP = eINSTANCE.getConstExp();

		/**
		 * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONST_EXP__EXP = eINSTANCE.getConstExp_Exp();

		/**
		 * The meta object literal for the '{@link delphi.impl.MultipleConstExpImpl <em>Multiple Const Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.MultipleConstExpImpl
		 * @see delphi.impl.DelphiPackageImpl#getMultipleConstExp()
		 * @generated
		 */
		EClass MULTIPLE_CONST_EXP = eINSTANCE.getMultipleConstExp();

		/**
		 * The meta object literal for the '<em><b>Exps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLE_CONST_EXP__EXPS = eINSTANCE.getMultipleConstExp_Exps();

		/**
		 * The meta object literal for the '{@link delphi.impl.RecordConstExpImpl <em>Record Const Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.RecordConstExpImpl
		 * @see delphi.impl.DelphiPackageImpl#getRecordConstExp()
		 * @generated
		 */
		EClass RECORD_CONST_EXP = eINSTANCE.getRecordConstExp();

		/**
		 * The meta object literal for the '<em><b>Exps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECORD_CONST_EXP__EXPS = eINSTANCE.getRecordConstExp_Exps();

		/**
		 * The meta object literal for the '{@link delphi.impl.CSTraceImpl <em>CS Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see delphi.impl.CSTraceImpl
		 * @see delphi.impl.DelphiPackageImpl#getCSTrace()
		 * @generated
		 */
		EClass CS_TRACE = eINSTANCE.getCSTrace();

		/**
		 * The meta object literal for the '<em><b>Ast</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CS_TRACE__AST = eINSTANCE.getCSTrace_Ast();

	}

} //DelphiPackage
