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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see delphi.DelphiPackage
 * @generated
 */
public interface DelphiFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DelphiFactory eINSTANCE = delphi.impl.DelphiFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>main Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>main Rule</em>'.
	 * @generated
	 */
	mainRule createmainRule();

	/**
	 * Returns a new object of class '<em>file</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>file</em>'.
	 * @generated
	 */
	file createfile();

	/**
	 * Returns a new object of class '<em>program</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>program</em>'.
	 * @generated
	 */
	program createprogram();

	/**
	 * Returns a new object of class '<em>unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>unit</em>'.
	 * @generated
	 */
	unit createunit();

	/**
	 * Returns a new object of class '<em>package Decl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>package Decl</em>'.
	 * @generated
	 */
	packageDecl createpackageDecl();

	/**
	 * Returns a new object of class '<em>library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>library</em>'.
	 * @generated
	 */
	library createlibrary();

	/**
	 * Returns a new object of class '<em>program Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>program Block</em>'.
	 * @generated
	 */
	programBlock createprogramBlock();

	/**
	 * Returns a new object of class '<em>uses Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>uses Clause</em>'.
	 * @generated
	 */
	usesClause createusesClause();

	/**
	 * Returns a new object of class '<em>interface Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>interface Section</em>'.
	 * @generated
	 */
	interfaceSection createinterfaceSection();

	/**
	 * Returns a new object of class '<em>interface Decl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>interface Decl</em>'.
	 * @generated
	 */
	interfaceDecl createinterfaceDecl();

	/**
	 * Returns a new object of class '<em>exported Heading</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>exported Heading</em>'.
	 * @generated
	 */
	exportedHeading createexportedHeading();

	/**
	 * Returns a new object of class '<em>implementation Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>implementation Section</em>'.
	 * @generated
	 */
	implementationSection createimplementationSection();

	/**
	 * Returns a new object of class '<em>block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>block</em>'.
	 * @generated
	 */
	block createblock();

	/**
	 * Returns a new object of class '<em>exports Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>exports Item</em>'.
	 * @generated
	 */
	exportsItem createexportsItem();

	/**
	 * Returns a new object of class '<em>exports Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>exports Stmt</em>'.
	 * @generated
	 */
	exportsStmt createexportsStmt();

	/**
	 * Returns a new object of class '<em>decl Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>decl Section</em>'.
	 * @generated
	 */
	declSection createdeclSection();

	/**
	 * Returns a new object of class '<em>label Decl Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>label Decl Section</em>'.
	 * @generated
	 */
	labelDeclSection createlabelDeclSection();

	/**
	 * Returns a new object of class '<em>const Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>const Section</em>'.
	 * @generated
	 */
	constSection createconstSection();

	/**
	 * Returns a new object of class '<em>constant Decl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>constant Decl</em>'.
	 * @generated
	 */
	constantDecl createconstantDecl();

	/**
	 * Returns a new object of class '<em>type Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>type Section</em>'.
	 * @generated
	 */
	typeSection createtypeSection();

	/**
	 * Returns a new object of class '<em>type Decl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>type Decl</em>'.
	 * @generated
	 */
	typeDecl createtypeDecl();

	/**
	 * Returns a new object of class '<em>typed Constant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>typed Constant</em>'.
	 * @generated
	 */
	typedConstant createtypedConstant();

	/**
	 * Returns a new object of class '<em>array Constant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>array Constant</em>'.
	 * @generated
	 */
	arrayConstant createarrayConstant();

	/**
	 * Returns a new object of class '<em>record Constant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>record Constant</em>'.
	 * @generated
	 */
	recordConstant createrecordConstant();

	/**
	 * Returns a new object of class '<em>record Field Constant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>record Field Constant</em>'.
	 * @generated
	 */
	recordFieldConstant createrecordFieldConstant();

	/**
	 * Returns a new object of class '<em>type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>type</em>'.
	 * @generated
	 */
	type createtype();

	/**
	 * Returns a new object of class '<em>restricted Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>restricted Type</em>'.
	 * @generated
	 */
	restrictedType createrestrictedType();

	/**
	 * Returns a new object of class '<em>class Ref Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>class Ref Type</em>'.
	 * @generated
	 */
	classRefType createclassRefType();

	/**
	 * Returns a new object of class '<em>simple Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>simple Type</em>'.
	 * @generated
	 */
	simpleType createsimpleType();

	/**
	 * Returns a new object of class '<em>real Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>real Type</em>'.
	 * @generated
	 */
	realType createrealType();

	/**
	 * Returns a new object of class '<em>ordinal Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ordinal Type</em>'.
	 * @generated
	 */
	ordinalType createordinalType();

	/**
	 * Returns a new object of class '<em>ord Ident</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ord Ident</em>'.
	 * @generated
	 */
	ordIdent createordIdent();

	/**
	 * Returns a new object of class '<em>variant Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>variant Type</em>'.
	 * @generated
	 */
	variantType createvariantType();

	/**
	 * Returns a new object of class '<em>subrange Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>subrange Type</em>'.
	 * @generated
	 */
	subrangeType createsubrangeType();

	/**
	 * Returns a new object of class '<em>enumerated Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>enumerated Type</em>'.
	 * @generated
	 */
	enumeratedType createenumeratedType();

	/**
	 * Returns a new object of class '<em>enumerated Type Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>enumerated Type Element</em>'.
	 * @generated
	 */
	enumeratedTypeElement createenumeratedTypeElement();

	/**
	 * Returns a new object of class '<em>string Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>string Type</em>'.
	 * @generated
	 */
	stringType createstringType();

	/**
	 * Returns a new object of class '<em>struc Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>struc Type</em>'.
	 * @generated
	 */
	strucType createstrucType();

	/**
	 * Returns a new object of class '<em>array Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>array Type</em>'.
	 * @generated
	 */
	arrayType createarrayType();

	/**
	 * Returns a new object of class '<em>rec Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>rec Type</em>'.
	 * @generated
	 */
	recType createrecType();

	/**
	 * Returns a new object of class '<em>field List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>field List</em>'.
	 * @generated
	 */
	fieldList createfieldList();

	/**
	 * Returns a new object of class '<em>field Decl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>field Decl</em>'.
	 * @generated
	 */
	fieldDecl createfieldDecl();

	/**
	 * Returns a new object of class '<em>variant Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>variant Section</em>'.
	 * @generated
	 */
	variantSection createvariantSection();

	/**
	 * Returns a new object of class '<em>rec Variant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>rec Variant</em>'.
	 * @generated
	 */
	recVariant createrecVariant();

	/**
	 * Returns a new object of class '<em>set Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>set Type</em>'.
	 * @generated
	 */
	setType createsetType();

	/**
	 * Returns a new object of class '<em>file Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>file Type</em>'.
	 * @generated
	 */
	fileType createfileType();

	/**
	 * Returns a new object of class '<em>pointer Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>pointer Type</em>'.
	 * @generated
	 */
	pointerType createpointerType();

	/**
	 * Returns a new object of class '<em>procedure Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>procedure Type</em>'.
	 * @generated
	 */
	procedureType createprocedureType();

	/**
	 * Returns a new object of class '<em>var Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>var Section</em>'.
	 * @generated
	 */
	varSection createvarSection();

	/**
	 * Returns a new object of class '<em>var Decl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>var Decl</em>'.
	 * @generated
	 */
	varDecl createvarDecl();

	/**
	 * Returns a new object of class '<em>expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>expression</em>'.
	 * @generated
	 */
	expression createexpression();

	/**
	 * Returns a new object of class '<em>simple Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>simple Expression</em>'.
	 * @generated
	 */
	simpleExpression createsimpleExpression();

	/**
	 * Returns a new object of class '<em>term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>term</em>'.
	 * @generated
	 */
	term createterm();

	/**
	 * Returns a new object of class '<em>factor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>factor</em>'.
	 * @generated
	 */
	factor createfactor();

	/**
	 * Returns a new object of class '<em>rel Op</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>rel Op</em>'.
	 * @generated
	 */
	relOp createrelOp();

	/**
	 * Returns a new object of class '<em>add Op</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>add Op</em>'.
	 * @generated
	 */
	addOp createaddOp();

	/**
	 * Returns a new object of class '<em>mul Op</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>mul Op</em>'.
	 * @generated
	 */
	mulOp createmulOp();

	/**
	 * Returns a new object of class '<em>designator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>designator</em>'.
	 * @generated
	 */
	designator createdesignator();

	/**
	 * Returns a new object of class '<em>designator Sub Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>designator Sub Part</em>'.
	 * @generated
	 */
	designatorSubPart createdesignatorSubPart();

	/**
	 * Returns a new object of class '<em>designator Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>designator Part</em>'.
	 * @generated
	 */
	designatorPart createdesignatorPart();

	/**
	 * Returns a new object of class '<em>set Constructor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>set Constructor</em>'.
	 * @generated
	 */
	setConstructor createsetConstructor();

	/**
	 * Returns a new object of class '<em>set Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>set Element</em>'.
	 * @generated
	 */
	setElement createsetElement();

	/**
	 * Returns a new object of class '<em>expr List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>expr List</em>'.
	 * @generated
	 */
	exprList createexprList();

	/**
	 * Returns a new object of class '<em>stmt List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>stmt List</em>'.
	 * @generated
	 */
	stmtList createstmtList();

	/**
	 * Returns a new object of class '<em>statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>statement</em>'.
	 * @generated
	 */
	statement createstatement();

	/**
	 * Returns a new object of class '<em>unlabelled Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>unlabelled Statement</em>'.
	 * @generated
	 */
	unlabelledStatement createunlabelledStatement();

	/**
	 * Returns a new object of class '<em>simple Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>simple Statement</em>'.
	 * @generated
	 */
	simpleStatement createsimpleStatement();

	/**
	 * Returns a new object of class '<em>struct Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>struct Stmt</em>'.
	 * @generated
	 */
	structStmt createstructStmt();

	/**
	 * Returns a new object of class '<em>compound Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>compound Stmt</em>'.
	 * @generated
	 */
	compoundStmt createcompoundStmt();

	/**
	 * Returns a new object of class '<em>conditional Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>conditional Stmt</em>'.
	 * @generated
	 */
	conditionalStmt createconditionalStmt();

	/**
	 * Returns a new object of class '<em>if Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>if Stmt</em>'.
	 * @generated
	 */
	ifStmt createifStmt();

	/**
	 * Returns a new object of class '<em>case Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>case Stmt</em>'.
	 * @generated
	 */
	caseStmt createcaseStmt();

	/**
	 * Returns a new object of class '<em>case Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>case Selector</em>'.
	 * @generated
	 */
	caseSelector createcaseSelector();

	/**
	 * Returns a new object of class '<em>case Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>case Label</em>'.
	 * @generated
	 */
	caseLabel createcaseLabel();

	/**
	 * Returns a new object of class '<em>loop Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>loop Stmt</em>'.
	 * @generated
	 */
	loopStmt createloopStmt();

	/**
	 * Returns a new object of class '<em>repeat Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>repeat Stmt</em>'.
	 * @generated
	 */
	repeatStmt createrepeatStmt();

	/**
	 * Returns a new object of class '<em>while Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>while Stmt</em>'.
	 * @generated
	 */
	whileStmt createwhileStmt();

	/**
	 * Returns a new object of class '<em>for Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>for Stmt</em>'.
	 * @generated
	 */
	forStmt createforStmt();

	/**
	 * Returns a new object of class '<em>with Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>with Stmt</em>'.
	 * @generated
	 */
	withStmt createwithStmt();

	/**
	 * Returns a new object of class '<em>try Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>try Stmt</em>'.
	 * @generated
	 */
	tryStmt createtryStmt();

	/**
	 * Returns a new object of class '<em>exception Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>exception Block</em>'.
	 * @generated
	 */
	exceptionBlock createexceptionBlock();

	/**
	 * Returns a new object of class '<em>raise Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>raise Stmt</em>'.
	 * @generated
	 */
	raiseStmt createraiseStmt();

	/**
	 * Returns a new object of class '<em>assembler Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>assembler Stmt</em>'.
	 * @generated
	 */
	assemblerStmt createassemblerStmt();

	/**
	 * Returns a new object of class '<em>procedure Decl Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>procedure Decl Section</em>'.
	 * @generated
	 */
	procedureDeclSection createprocedureDeclSection();

	/**
	 * Returns a new object of class '<em>procedure Decl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>procedure Decl</em>'.
	 * @generated
	 */
	procedureDecl createprocedureDecl();

	/**
	 * Returns a new object of class '<em>function Decl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>function Decl</em>'.
	 * @generated
	 */
	functionDecl createfunctionDecl();

	/**
	 * Returns a new object of class '<em>function Heading</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>function Heading</em>'.
	 * @generated
	 */
	functionHeading createfunctionHeading();

	/**
	 * Returns a new object of class '<em>procedure Heading</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>procedure Heading</em>'.
	 * @generated
	 */
	procedureHeading createprocedureHeading();

	/**
	 * Returns a new object of class '<em>formal Parameters</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>formal Parameters</em>'.
	 * @generated
	 */
	formalParameters createformalParameters();

	/**
	 * Returns a new object of class '<em>formal Parm</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>formal Parm</em>'.
	 * @generated
	 */
	formalParm createformalParm();

	/**
	 * Returns a new object of class '<em>parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>parameter</em>'.
	 * @generated
	 */
	parameter createparameter();

	/**
	 * Returns a new object of class '<em>directive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>directive</em>'.
	 * @generated
	 */
	directive createdirective();

	/**
	 * Returns a new object of class '<em>object Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>object Type</em>'.
	 * @generated
	 */
	objectType createobjectType();

	/**
	 * Returns a new object of class '<em>obj Heritage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>obj Heritage</em>'.
	 * @generated
	 */
	objHeritage createobjHeritage();

	/**
	 * Returns a new object of class '<em>method List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>method List</em>'.
	 * @generated
	 */
	methodList createmethodList();

	/**
	 * Returns a new object of class '<em>method Heading</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>method Heading</em>'.
	 * @generated
	 */
	methodHeading createmethodHeading();

	/**
	 * Returns a new object of class '<em>constructor Heading</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>constructor Heading</em>'.
	 * @generated
	 */
	constructorHeading createconstructorHeading();

	/**
	 * Returns a new object of class '<em>destructor Heading</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>destructor Heading</em>'.
	 * @generated
	 */
	destructorHeading createdestructorHeading();

	/**
	 * Returns a new object of class '<em>obj Field List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>obj Field List</em>'.
	 * @generated
	 */
	objFieldList createobjFieldList();

	/**
	 * Returns a new object of class '<em>init Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>init Section</em>'.
	 * @generated
	 */
	initSection createinitSection();

	/**
	 * Returns a new object of class '<em>class Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>class Type</em>'.
	 * @generated
	 */
	classType createclassType();

	/**
	 * Returns a new object of class '<em>class Heritage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>class Heritage</em>'.
	 * @generated
	 */
	classHeritage createclassHeritage();

	/**
	 * Returns a new object of class '<em>class Field List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>class Field List</em>'.
	 * @generated
	 */
	classFieldList createclassFieldList();

	/**
	 * Returns a new object of class '<em>class Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>class Field</em>'.
	 * @generated
	 */
	classField createclassField();

	/**
	 * Returns a new object of class '<em>class Method List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>class Method List</em>'.
	 * @generated
	 */
	classMethodList createclassMethodList();

	/**
	 * Returns a new object of class '<em>class Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>class Method</em>'.
	 * @generated
	 */
	classMethod createclassMethod();

	/**
	 * Returns a new object of class '<em>class Property List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>class Property List</em>'.
	 * @generated
	 */
	classPropertyList createclassPropertyList();

	/**
	 * Returns a new object of class '<em>class Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>class Property</em>'.
	 * @generated
	 */
	classProperty createclassProperty();

	/**
	 * Returns a new object of class '<em>property List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>property List</em>'.
	 * @generated
	 */
	propertyList createpropertyList();

	/**
	 * Returns a new object of class '<em>property Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>property Interface</em>'.
	 * @generated
	 */
	propertyInterface createpropertyInterface();

	/**
	 * Returns a new object of class '<em>property Parameter List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>property Parameter List</em>'.
	 * @generated
	 */
	propertyParameterList createpropertyParameterList();

	/**
	 * Returns a new object of class '<em>property Specifiers</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>property Specifiers</em>'.
	 * @generated
	 */
	propertySpecifiers createpropertySpecifiers();

	/**
	 * Returns a new object of class '<em>interface Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>interface Type</em>'.
	 * @generated
	 */
	interfaceType createinterfaceType();

	/**
	 * Returns a new object of class '<em>interface Heritage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>interface Heritage</em>'.
	 * @generated
	 */
	interfaceHeritage createinterfaceHeritage();

	/**
	 * Returns a new object of class '<em>requires Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>requires Clause</em>'.
	 * @generated
	 */
	requiresClause createrequiresClause();

	/**
	 * Returns a new object of class '<em>contains Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>contains Clause</em>'.
	 * @generated
	 */
	containsClause createcontainsClause();

	/**
	 * Returns a new object of class '<em>ident List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ident List</em>'.
	 * @generated
	 */
	identList createidentList();

	/**
	 * Returns a new object of class '<em>qual Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>qual Id</em>'.
	 * @generated
	 */
	qualId createqualId();

	/**
	 * Returns a new object of class '<em>type Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>type Id</em>'.
	 * @generated
	 */
	typeId createtypeId();

	/**
	 * Returns a new object of class '<em>ident</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ident</em>'.
	 * @generated
	 */
	ident createident();

	/**
	 * Returns a new object of class '<em>reserved Word</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>reserved Word</em>'.
	 * @generated
	 */
	reservedWord createreservedWord();

	/**
	 * Returns a new object of class '<em>const Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>const Expr</em>'.
	 * @generated
	 */
	constExpr createconstExpr();

	/**
	 * Returns a new object of class '<em>record Const Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>record Const Expr</em>'.
	 * @generated
	 */
	recordConstExpr createrecordConstExpr();

	/**
	 * Returns a new object of class '<em>unit Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>unit Id</em>'.
	 * @generated
	 */
	unitId createunitId();

	/**
	 * Returns a new object of class '<em>rel Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>rel Exp</em>'.
	 * @generated
	 */
	relExp createrelExp();

	/**
	 * Returns a new object of class '<em>add Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>add Exp</em>'.
	 * @generated
	 */
	addExp createaddExp();

	/**
	 * Returns a new object of class '<em>mult Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>mult Exp</em>'.
	 * @generated
	 */
	multExp createmultExp();

	/**
	 * Returns a new object of class '<em>simple Factor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>simple Factor</em>'.
	 * @generated
	 */
	simpleFactor createsimpleFactor();

	/**
	 * Returns a new object of class '<em>assignment Stmnt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>assignment Stmnt</em>'.
	 * @generated
	 */
	assignmentStmnt createassignmentStmnt();

	/**
	 * Returns a new object of class '<em>call Stmnt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>call Stmnt</em>'.
	 * @generated
	 */
	callStmnt createcallStmnt();

	/**
	 * Returns a new object of class '<em>inherited Stamnt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>inherited Stamnt</em>'.
	 * @generated
	 */
	inheritedStamnt createinheritedStamnt();

	/**
	 * Returns a new object of class '<em>goto Stmnt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>goto Stmnt</em>'.
	 * @generated
	 */
	gotoStmnt creategotoStmnt();

	/**
	 * Returns a new object of class '<em>parameter List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>parameter List</em>'.
	 * @generated
	 */
	parameterList createparameterList();

	/**
	 * Returns a new object of class '<em>parameter Simple</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>parameter Simple</em>'.
	 * @generated
	 */
	parameterSimple createparameterSimple();

	/**
	 * Returns a new object of class '<em>Multiple Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multiple Id</em>'.
	 * @generated
	 */
	MultipleId createMultipleId();

	/**
	 * Returns a new object of class '<em>Reserved Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reserved Id</em>'.
	 * @generated
	 */
	ReservedId createReservedId();

	/**
	 * Returns a new object of class '<em>Mine ID</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mine ID</em>'.
	 * @generated
	 */
	MineID createMineID();

	/**
	 * Returns a new object of class '<em>Const Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Const Exp</em>'.
	 * @generated
	 */
	ConstExp createConstExp();

	/**
	 * Returns a new object of class '<em>Multiple Const Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multiple Const Exp</em>'.
	 * @generated
	 */
	MultipleConstExp createMultipleConstExp();

	/**
	 * Returns a new object of class '<em>Record Const Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Record Const Exp</em>'.
	 * @generated
	 */
	RecordConstExp createRecordConstExp();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DelphiPackage getDelphiPackage();

} //DelphiFactory
