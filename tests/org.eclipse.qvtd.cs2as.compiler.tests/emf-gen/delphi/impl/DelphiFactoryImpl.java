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
package delphi.impl;

import delphi.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DelphiFactoryImpl extends EFactoryImpl implements DelphiFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DelphiFactory init() {
		try {
			DelphiFactory theDelphiFactory = (DelphiFactory)EPackage.Registry.INSTANCE.getEFactory(DelphiPackage.eNS_URI);
			if (theDelphiFactory != null) {
				return theDelphiFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DelphiFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DelphiFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DelphiPackage.MAIN_RULE: return createmainRule();
			case DelphiPackage.FILE: return createfile();
			case DelphiPackage.PROGRAM: return createprogram();
			case DelphiPackage.UNIT: return createunit();
			case DelphiPackage.PACKAGE_DECL: return createpackageDecl();
			case DelphiPackage.LIBRARY: return createlibrary();
			case DelphiPackage.PROGRAM_BLOCK: return createprogramBlock();
			case DelphiPackage.USES_CLAUSE: return createusesClause();
			case DelphiPackage.INTERFACE_SECTION: return createinterfaceSection();
			case DelphiPackage.INTERFACE_DECL: return createinterfaceDecl();
			case DelphiPackage.EXPORTED_HEADING: return createexportedHeading();
			case DelphiPackage.IMPLEMENTATION_SECTION: return createimplementationSection();
			case DelphiPackage.BLOCK: return createblock();
			case DelphiPackage.EXPORTS_ITEM: return createexportsItem();
			case DelphiPackage.EXPORTS_STMT: return createexportsStmt();
			case DelphiPackage.DECL_SECTION: return createdeclSection();
			case DelphiPackage.LABEL_DECL_SECTION: return createlabelDeclSection();
			case DelphiPackage.CONST_SECTION: return createconstSection();
			case DelphiPackage.CONSTANT_DECL: return createconstantDecl();
			case DelphiPackage.TYPE_SECTION: return createtypeSection();
			case DelphiPackage.TYPE_DECL: return createtypeDecl();
			case DelphiPackage.TYPED_CONSTANT: return createtypedConstant();
			case DelphiPackage.ARRAY_CONSTANT: return createarrayConstant();
			case DelphiPackage.RECORD_CONSTANT: return createrecordConstant();
			case DelphiPackage.RECORD_FIELD_CONSTANT: return createrecordFieldConstant();
			case DelphiPackage.TYPE: return createtype();
			case DelphiPackage.RESTRICTED_TYPE: return createrestrictedType();
			case DelphiPackage.CLASS_REF_TYPE: return createclassRefType();
			case DelphiPackage.SIMPLE_TYPE: return createsimpleType();
			case DelphiPackage.REAL_TYPE: return createrealType();
			case DelphiPackage.ORDINAL_TYPE: return createordinalType();
			case DelphiPackage.ORD_IDENT: return createordIdent();
			case DelphiPackage.VARIANT_TYPE: return createvariantType();
			case DelphiPackage.SUBRANGE_TYPE: return createsubrangeType();
			case DelphiPackage.ENUMERATED_TYPE: return createenumeratedType();
			case DelphiPackage.ENUMERATED_TYPE_ELEMENT: return createenumeratedTypeElement();
			case DelphiPackage.STRING_TYPE: return createstringType();
			case DelphiPackage.STRUC_TYPE: return createstrucType();
			case DelphiPackage.ARRAY_TYPE: return createarrayType();
			case DelphiPackage.REC_TYPE: return createrecType();
			case DelphiPackage.FIELD_LIST: return createfieldList();
			case DelphiPackage.FIELD_DECL: return createfieldDecl();
			case DelphiPackage.VARIANT_SECTION: return createvariantSection();
			case DelphiPackage.REC_VARIANT: return createrecVariant();
			case DelphiPackage.SET_TYPE: return createsetType();
			case DelphiPackage.FILE_TYPE: return createfileType();
			case DelphiPackage.POINTER_TYPE: return createpointerType();
			case DelphiPackage.PROCEDURE_TYPE: return createprocedureType();
			case DelphiPackage.VAR_SECTION: return createvarSection();
			case DelphiPackage.VAR_DECL: return createvarDecl();
			case DelphiPackage.EXPRESSION: return createexpression();
			case DelphiPackage.SIMPLE_EXPRESSION: return createsimpleExpression();
			case DelphiPackage.TERM: return createterm();
			case DelphiPackage.FACTOR: return createfactor();
			case DelphiPackage.REL_OP: return createrelOp();
			case DelphiPackage.ADD_OP: return createaddOp();
			case DelphiPackage.MUL_OP: return createmulOp();
			case DelphiPackage.DESIGNATOR: return createdesignator();
			case DelphiPackage.DESIGNATOR_SUB_PART: return createdesignatorSubPart();
			case DelphiPackage.DESIGNATOR_PART: return createdesignatorPart();
			case DelphiPackage.SET_CONSTRUCTOR: return createsetConstructor();
			case DelphiPackage.SET_ELEMENT: return createsetElement();
			case DelphiPackage.EXPR_LIST: return createexprList();
			case DelphiPackage.STMT_LIST: return createstmtList();
			case DelphiPackage.STATEMENT: return createstatement();
			case DelphiPackage.UNLABELLED_STATEMENT: return createunlabelledStatement();
			case DelphiPackage.SIMPLE_STATEMENT: return createsimpleStatement();
			case DelphiPackage.STRUCT_STMT: return createstructStmt();
			case DelphiPackage.COMPOUND_STMT: return createcompoundStmt();
			case DelphiPackage.CONDITIONAL_STMT: return createconditionalStmt();
			case DelphiPackage.IF_STMT: return createifStmt();
			case DelphiPackage.CASE_STMT: return createcaseStmt();
			case DelphiPackage.CASE_SELECTOR: return createcaseSelector();
			case DelphiPackage.CASE_LABEL: return createcaseLabel();
			case DelphiPackage.LOOP_STMT: return createloopStmt();
			case DelphiPackage.REPEAT_STMT: return createrepeatStmt();
			case DelphiPackage.WHILE_STMT: return createwhileStmt();
			case DelphiPackage.FOR_STMT: return createforStmt();
			case DelphiPackage.WITH_STMT: return createwithStmt();
			case DelphiPackage.TRY_STMT: return createtryStmt();
			case DelphiPackage.EXCEPTION_BLOCK: return createexceptionBlock();
			case DelphiPackage.RAISE_STMT: return createraiseStmt();
			case DelphiPackage.ASSEMBLER_STMT: return createassemblerStmt();
			case DelphiPackage.PROCEDURE_DECL_SECTION: return createprocedureDeclSection();
			case DelphiPackage.PROCEDURE_DECL: return createprocedureDecl();
			case DelphiPackage.FUNCTION_DECL: return createfunctionDecl();
			case DelphiPackage.FUNCTION_HEADING: return createfunctionHeading();
			case DelphiPackage.PROCEDURE_HEADING: return createprocedureHeading();
			case DelphiPackage.FORMAL_PARAMETERS: return createformalParameters();
			case DelphiPackage.FORMAL_PARM: return createformalParm();
			case DelphiPackage.PARAMETER: return createparameter();
			case DelphiPackage.DIRECTIVE: return createdirective();
			case DelphiPackage.OBJECT_TYPE: return createobjectType();
			case DelphiPackage.OBJ_HERITAGE: return createobjHeritage();
			case DelphiPackage.METHOD_LIST: return createmethodList();
			case DelphiPackage.METHOD_HEADING: return createmethodHeading();
			case DelphiPackage.CONSTRUCTOR_HEADING: return createconstructorHeading();
			case DelphiPackage.DESTRUCTOR_HEADING: return createdestructorHeading();
			case DelphiPackage.OBJ_FIELD_LIST: return createobjFieldList();
			case DelphiPackage.INIT_SECTION: return createinitSection();
			case DelphiPackage.CLASS_TYPE: return createclassType();
			case DelphiPackage.CLASS_HERITAGE: return createclassHeritage();
			case DelphiPackage.CLASS_FIELD_LIST: return createclassFieldList();
			case DelphiPackage.CLASS_FIELD: return createclassField();
			case DelphiPackage.CLASS_METHOD_LIST: return createclassMethodList();
			case DelphiPackage.CLASS_METHOD: return createclassMethod();
			case DelphiPackage.CLASS_PROPERTY_LIST: return createclassPropertyList();
			case DelphiPackage.CLASS_PROPERTY: return createclassProperty();
			case DelphiPackage.PROPERTY_LIST: return createpropertyList();
			case DelphiPackage.PROPERTY_INTERFACE: return createpropertyInterface();
			case DelphiPackage.PROPERTY_PARAMETER_LIST: return createpropertyParameterList();
			case DelphiPackage.PROPERTY_SPECIFIERS: return createpropertySpecifiers();
			case DelphiPackage.INTERFACE_TYPE: return createinterfaceType();
			case DelphiPackage.INTERFACE_HERITAGE: return createinterfaceHeritage();
			case DelphiPackage.REQUIRES_CLAUSE: return createrequiresClause();
			case DelphiPackage.CONTAINS_CLAUSE: return createcontainsClause();
			case DelphiPackage.IDENT_LIST: return createidentList();
			case DelphiPackage.QUAL_ID: return createqualId();
			case DelphiPackage.TYPE_ID: return createtypeId();
			case DelphiPackage.IDENT: return createident();
			case DelphiPackage.RESERVED_WORD: return createreservedWord();
			case DelphiPackage.CONST_EXPR: return createconstExpr();
			case DelphiPackage.RECORD_CONST_EXPR: return createrecordConstExpr();
			case DelphiPackage.UNIT_ID: return createunitId();
			case DelphiPackage.REL_EXP: return createrelExp();
			case DelphiPackage.ADD_EXP: return createaddExp();
			case DelphiPackage.MULT_EXP: return createmultExp();
			case DelphiPackage.SIMPLE_FACTOR: return createsimpleFactor();
			case DelphiPackage.ASSIGNMENT_STMNT: return createassignmentStmnt();
			case DelphiPackage.CALL_STMNT: return createcallStmnt();
			case DelphiPackage.INHERITED_STAMNT: return createinheritedStamnt();
			case DelphiPackage.GOTO_STMNT: return creategotoStmnt();
			case DelphiPackage.PARAMETER_LIST: return createparameterList();
			case DelphiPackage.PARAMETER_SIMPLE: return createparameterSimple();
			case DelphiPackage.MULTIPLE_ID: return createMultipleId();
			case DelphiPackage.RESERVED_ID: return createReservedId();
			case DelphiPackage.MINE_ID: return createMineID();
			case DelphiPackage.CONST_EXP: return createConstExp();
			case DelphiPackage.MULTIPLE_CONST_EXP: return createMultipleConstExp();
			case DelphiPackage.RECORD_CONST_EXP: return createRecordConstExp();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public mainRule createmainRule() {
		mainRuleImpl mainRule = new mainRuleImpl();
		return mainRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public file createfile() {
		fileImpl file = new fileImpl();
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public program createprogram() {
		programImpl program = new programImpl();
		return program;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public unit createunit() {
		unitImpl unit = new unitImpl();
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public packageDecl createpackageDecl() {
		packageDeclImpl packageDecl = new packageDeclImpl();
		return packageDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public library createlibrary() {
		libraryImpl library = new libraryImpl();
		return library;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public programBlock createprogramBlock() {
		programBlockImpl programBlock = new programBlockImpl();
		return programBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public usesClause createusesClause() {
		usesClauseImpl usesClause = new usesClauseImpl();
		return usesClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interfaceSection createinterfaceSection() {
		interfaceSectionImpl interfaceSection = new interfaceSectionImpl();
		return interfaceSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interfaceDecl createinterfaceDecl() {
		interfaceDeclImpl interfaceDecl = new interfaceDeclImpl();
		return interfaceDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public exportedHeading createexportedHeading() {
		exportedHeadingImpl exportedHeading = new exportedHeadingImpl();
		return exportedHeading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public implementationSection createimplementationSection() {
		implementationSectionImpl implementationSection = new implementationSectionImpl();
		return implementationSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public block createblock() {
		blockImpl block = new blockImpl();
		return block;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public exportsItem createexportsItem() {
		exportsItemImpl exportsItem = new exportsItemImpl();
		return exportsItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public exportsStmt createexportsStmt() {
		exportsStmtImpl exportsStmt = new exportsStmtImpl();
		return exportsStmt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public declSection createdeclSection() {
		declSectionImpl declSection = new declSectionImpl();
		return declSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public labelDeclSection createlabelDeclSection() {
		labelDeclSectionImpl labelDeclSection = new labelDeclSectionImpl();
		return labelDeclSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public constSection createconstSection() {
		constSectionImpl constSection = new constSectionImpl();
		return constSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public constantDecl createconstantDecl() {
		constantDeclImpl constantDecl = new constantDeclImpl();
		return constantDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public typeSection createtypeSection() {
		typeSectionImpl typeSection = new typeSectionImpl();
		return typeSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public typeDecl createtypeDecl() {
		typeDeclImpl typeDecl = new typeDeclImpl();
		return typeDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public typedConstant createtypedConstant() {
		typedConstantImpl typedConstant = new typedConstantImpl();
		return typedConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public arrayConstant createarrayConstant() {
		arrayConstantImpl arrayConstant = new arrayConstantImpl();
		return arrayConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public recordConstant createrecordConstant() {
		recordConstantImpl recordConstant = new recordConstantImpl();
		return recordConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public recordFieldConstant createrecordFieldConstant() {
		recordFieldConstantImpl recordFieldConstant = new recordFieldConstantImpl();
		return recordFieldConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public type createtype() {
		typeImpl type = new typeImpl();
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public restrictedType createrestrictedType() {
		restrictedTypeImpl restrictedType = new restrictedTypeImpl();
		return restrictedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public classRefType createclassRefType() {
		classRefTypeImpl classRefType = new classRefTypeImpl();
		return classRefType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public simpleType createsimpleType() {
		simpleTypeImpl simpleType = new simpleTypeImpl();
		return simpleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public realType createrealType() {
		realTypeImpl realType = new realTypeImpl();
		return realType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ordinalType createordinalType() {
		ordinalTypeImpl ordinalType = new ordinalTypeImpl();
		return ordinalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ordIdent createordIdent() {
		ordIdentImpl ordIdent = new ordIdentImpl();
		return ordIdent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public variantType createvariantType() {
		variantTypeImpl variantType = new variantTypeImpl();
		return variantType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public subrangeType createsubrangeType() {
		subrangeTypeImpl subrangeType = new subrangeTypeImpl();
		return subrangeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public enumeratedType createenumeratedType() {
		enumeratedTypeImpl enumeratedType = new enumeratedTypeImpl();
		return enumeratedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public enumeratedTypeElement createenumeratedTypeElement() {
		enumeratedTypeElementImpl enumeratedTypeElement = new enumeratedTypeElementImpl();
		return enumeratedTypeElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public stringType createstringType() {
		stringTypeImpl stringType = new stringTypeImpl();
		return stringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public strucType createstrucType() {
		strucTypeImpl strucType = new strucTypeImpl();
		return strucType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public arrayType createarrayType() {
		arrayTypeImpl arrayType = new arrayTypeImpl();
		return arrayType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public recType createrecType() {
		recTypeImpl recType = new recTypeImpl();
		return recType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public fieldList createfieldList() {
		fieldListImpl fieldList = new fieldListImpl();
		return fieldList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public fieldDecl createfieldDecl() {
		fieldDeclImpl fieldDecl = new fieldDeclImpl();
		return fieldDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public variantSection createvariantSection() {
		variantSectionImpl variantSection = new variantSectionImpl();
		return variantSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public recVariant createrecVariant() {
		recVariantImpl recVariant = new recVariantImpl();
		return recVariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public setType createsetType() {
		setTypeImpl setType = new setTypeImpl();
		return setType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public fileType createfileType() {
		fileTypeImpl fileType = new fileTypeImpl();
		return fileType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public pointerType createpointerType() {
		pointerTypeImpl pointerType = new pointerTypeImpl();
		return pointerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public procedureType createprocedureType() {
		procedureTypeImpl procedureType = new procedureTypeImpl();
		return procedureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public varSection createvarSection() {
		varSectionImpl varSection = new varSectionImpl();
		return varSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public varDecl createvarDecl() {
		varDeclImpl varDecl = new varDeclImpl();
		return varDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public expression createexpression() {
		expressionImpl expression = new expressionImpl();
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public simpleExpression createsimpleExpression() {
		simpleExpressionImpl simpleExpression = new simpleExpressionImpl();
		return simpleExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public term createterm() {
		termImpl term = new termImpl();
		return term;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public factor createfactor() {
		factorImpl factor = new factorImpl();
		return factor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public relOp createrelOp() {
		relOpImpl relOp = new relOpImpl();
		return relOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public addOp createaddOp() {
		addOpImpl addOp = new addOpImpl();
		return addOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public mulOp createmulOp() {
		mulOpImpl mulOp = new mulOpImpl();
		return mulOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public designator createdesignator() {
		designatorImpl designator = new designatorImpl();
		return designator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public designatorSubPart createdesignatorSubPart() {
		designatorSubPartImpl designatorSubPart = new designatorSubPartImpl();
		return designatorSubPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public designatorPart createdesignatorPart() {
		designatorPartImpl designatorPart = new designatorPartImpl();
		return designatorPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public setConstructor createsetConstructor() {
		setConstructorImpl setConstructor = new setConstructorImpl();
		return setConstructor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public setElement createsetElement() {
		setElementImpl setElement = new setElementImpl();
		return setElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public exprList createexprList() {
		exprListImpl exprList = new exprListImpl();
		return exprList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public stmtList createstmtList() {
		stmtListImpl stmtList = new stmtListImpl();
		return stmtList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public statement createstatement() {
		statementImpl statement = new statementImpl();
		return statement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public unlabelledStatement createunlabelledStatement() {
		unlabelledStatementImpl unlabelledStatement = new unlabelledStatementImpl();
		return unlabelledStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public simpleStatement createsimpleStatement() {
		simpleStatementImpl simpleStatement = new simpleStatementImpl();
		return simpleStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public structStmt createstructStmt() {
		structStmtImpl structStmt = new structStmtImpl();
		return structStmt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public compoundStmt createcompoundStmt() {
		compoundStmtImpl compoundStmt = new compoundStmtImpl();
		return compoundStmt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public conditionalStmt createconditionalStmt() {
		conditionalStmtImpl conditionalStmt = new conditionalStmtImpl();
		return conditionalStmt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ifStmt createifStmt() {
		ifStmtImpl ifStmt = new ifStmtImpl();
		return ifStmt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public caseStmt createcaseStmt() {
		caseStmtImpl caseStmt = new caseStmtImpl();
		return caseStmt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public caseSelector createcaseSelector() {
		caseSelectorImpl caseSelector = new caseSelectorImpl();
		return caseSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public caseLabel createcaseLabel() {
		caseLabelImpl caseLabel = new caseLabelImpl();
		return caseLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public loopStmt createloopStmt() {
		loopStmtImpl loopStmt = new loopStmtImpl();
		return loopStmt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public repeatStmt createrepeatStmt() {
		repeatStmtImpl repeatStmt = new repeatStmtImpl();
		return repeatStmt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public whileStmt createwhileStmt() {
		whileStmtImpl whileStmt = new whileStmtImpl();
		return whileStmt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public forStmt createforStmt() {
		forStmtImpl forStmt = new forStmtImpl();
		return forStmt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public withStmt createwithStmt() {
		withStmtImpl withStmt = new withStmtImpl();
		return withStmt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public tryStmt createtryStmt() {
		tryStmtImpl tryStmt = new tryStmtImpl();
		return tryStmt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public exceptionBlock createexceptionBlock() {
		exceptionBlockImpl exceptionBlock = new exceptionBlockImpl();
		return exceptionBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public raiseStmt createraiseStmt() {
		raiseStmtImpl raiseStmt = new raiseStmtImpl();
		return raiseStmt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public assemblerStmt createassemblerStmt() {
		assemblerStmtImpl assemblerStmt = new assemblerStmtImpl();
		return assemblerStmt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public procedureDeclSection createprocedureDeclSection() {
		procedureDeclSectionImpl procedureDeclSection = new procedureDeclSectionImpl();
		return procedureDeclSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public procedureDecl createprocedureDecl() {
		procedureDeclImpl procedureDecl = new procedureDeclImpl();
		return procedureDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public functionDecl createfunctionDecl() {
		functionDeclImpl functionDecl = new functionDeclImpl();
		return functionDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public functionHeading createfunctionHeading() {
		functionHeadingImpl functionHeading = new functionHeadingImpl();
		return functionHeading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public procedureHeading createprocedureHeading() {
		procedureHeadingImpl procedureHeading = new procedureHeadingImpl();
		return procedureHeading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public formalParameters createformalParameters() {
		formalParametersImpl formalParameters = new formalParametersImpl();
		return formalParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public formalParm createformalParm() {
		formalParmImpl formalParm = new formalParmImpl();
		return formalParm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public parameter createparameter() {
		parameterImpl parameter = new parameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public directive createdirective() {
		directiveImpl directive = new directiveImpl();
		return directive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public objectType createobjectType() {
		objectTypeImpl objectType = new objectTypeImpl();
		return objectType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public objHeritage createobjHeritage() {
		objHeritageImpl objHeritage = new objHeritageImpl();
		return objHeritage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public methodList createmethodList() {
		methodListImpl methodList = new methodListImpl();
		return methodList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public methodHeading createmethodHeading() {
		methodHeadingImpl methodHeading = new methodHeadingImpl();
		return methodHeading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public constructorHeading createconstructorHeading() {
		constructorHeadingImpl constructorHeading = new constructorHeadingImpl();
		return constructorHeading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public destructorHeading createdestructorHeading() {
		destructorHeadingImpl destructorHeading = new destructorHeadingImpl();
		return destructorHeading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public objFieldList createobjFieldList() {
		objFieldListImpl objFieldList = new objFieldListImpl();
		return objFieldList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public initSection createinitSection() {
		initSectionImpl initSection = new initSectionImpl();
		return initSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public classType createclassType() {
		classTypeImpl classType = new classTypeImpl();
		return classType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public classHeritage createclassHeritage() {
		classHeritageImpl classHeritage = new classHeritageImpl();
		return classHeritage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public classFieldList createclassFieldList() {
		classFieldListImpl classFieldList = new classFieldListImpl();
		return classFieldList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public classField createclassField() {
		classFieldImpl classField = new classFieldImpl();
		return classField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public classMethodList createclassMethodList() {
		classMethodListImpl classMethodList = new classMethodListImpl();
		return classMethodList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public classMethod createclassMethod() {
		classMethodImpl classMethod = new classMethodImpl();
		return classMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public classPropertyList createclassPropertyList() {
		classPropertyListImpl classPropertyList = new classPropertyListImpl();
		return classPropertyList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public classProperty createclassProperty() {
		classPropertyImpl classProperty = new classPropertyImpl();
		return classProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public propertyList createpropertyList() {
		propertyListImpl propertyList = new propertyListImpl();
		return propertyList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public propertyInterface createpropertyInterface() {
		propertyInterfaceImpl propertyInterface = new propertyInterfaceImpl();
		return propertyInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public propertyParameterList createpropertyParameterList() {
		propertyParameterListImpl propertyParameterList = new propertyParameterListImpl();
		return propertyParameterList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public propertySpecifiers createpropertySpecifiers() {
		propertySpecifiersImpl propertySpecifiers = new propertySpecifiersImpl();
		return propertySpecifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interfaceType createinterfaceType() {
		interfaceTypeImpl interfaceType = new interfaceTypeImpl();
		return interfaceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interfaceHeritage createinterfaceHeritage() {
		interfaceHeritageImpl interfaceHeritage = new interfaceHeritageImpl();
		return interfaceHeritage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public requiresClause createrequiresClause() {
		requiresClauseImpl requiresClause = new requiresClauseImpl();
		return requiresClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public containsClause createcontainsClause() {
		containsClauseImpl containsClause = new containsClauseImpl();
		return containsClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public identList createidentList() {
		identListImpl identList = new identListImpl();
		return identList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public qualId createqualId() {
		qualIdImpl qualId = new qualIdImpl();
		return qualId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public typeId createtypeId() {
		typeIdImpl typeId = new typeIdImpl();
		return typeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ident createident() {
		identImpl ident = new identImpl();
		return ident;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public reservedWord createreservedWord() {
		reservedWordImpl reservedWord = new reservedWordImpl();
		return reservedWord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public constExpr createconstExpr() {
		constExprImpl constExpr = new constExprImpl();
		return constExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public recordConstExpr createrecordConstExpr() {
		recordConstExprImpl recordConstExpr = new recordConstExprImpl();
		return recordConstExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public unitId createunitId() {
		unitIdImpl unitId = new unitIdImpl();
		return unitId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public relExp createrelExp() {
		relExpImpl relExp = new relExpImpl();
		return relExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public addExp createaddExp() {
		addExpImpl addExp = new addExpImpl();
		return addExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public multExp createmultExp() {
		multExpImpl multExp = new multExpImpl();
		return multExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public simpleFactor createsimpleFactor() {
		simpleFactorImpl simpleFactor = new simpleFactorImpl();
		return simpleFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public assignmentStmnt createassignmentStmnt() {
		assignmentStmntImpl assignmentStmnt = new assignmentStmntImpl();
		return assignmentStmnt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public callStmnt createcallStmnt() {
		callStmntImpl callStmnt = new callStmntImpl();
		return callStmnt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public inheritedStamnt createinheritedStamnt() {
		inheritedStamntImpl inheritedStamnt = new inheritedStamntImpl();
		return inheritedStamnt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public gotoStmnt creategotoStmnt() {
		gotoStmntImpl gotoStmnt = new gotoStmntImpl();
		return gotoStmnt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public parameterList createparameterList() {
		parameterListImpl parameterList = new parameterListImpl();
		return parameterList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public parameterSimple createparameterSimple() {
		parameterSimpleImpl parameterSimple = new parameterSimpleImpl();
		return parameterSimple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultipleId createMultipleId() {
		MultipleIdImpl multipleId = new MultipleIdImpl();
		return multipleId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReservedId createReservedId() {
		ReservedIdImpl reservedId = new ReservedIdImpl();
		return reservedId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MineID createMineID() {
		MineIDImpl mineID = new MineIDImpl();
		return mineID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstExp createConstExp() {
		ConstExpImpl constExp = new ConstExpImpl();
		return constExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultipleConstExp createMultipleConstExp() {
		MultipleConstExpImpl multipleConstExp = new MultipleConstExpImpl();
		return multipleConstExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecordConstExp createRecordConstExp() {
		RecordConstExpImpl recordConstExp = new RecordConstExpImpl();
		return recordConstExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DelphiPackage getDelphiPackage() {
		return (DelphiPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DelphiPackage getPackage() {
		return DelphiPackage.eINSTANCE;
	}

} //DelphiFactoryImpl
