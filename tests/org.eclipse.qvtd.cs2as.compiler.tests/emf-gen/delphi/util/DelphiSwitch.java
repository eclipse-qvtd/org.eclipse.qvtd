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
package delphi.util;

import delphi.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.jdt.annotation.Nullable;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see delphi.DelphiPackage
 * @generated
 */
public class DelphiSwitch<@Nullable T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DelphiPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DelphiSwitch() {
		if (modelPackage == null) {
			modelPackage = DelphiPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DelphiPackage.MAIN_RULE: {
				mainRule mainRule = (mainRule)theEObject;
				T result = casemainRule(mainRule);
				if (result == null) result = caseCSTrace(mainRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.FILE: {
				file file = (file)theEObject;
				T result = casefile(file);
				if (result == null) result = caseCSTrace(file);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.PROGRAM: {
				program program = (program)theEObject;
				T result = caseprogram(program);
				if (result == null) result = casefile(program);
				if (result == null) result = caseCSTrace(program);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.UNIT: {
				unit unit = (unit)theEObject;
				T result = caseunit(unit);
				if (result == null) result = casefile(unit);
				if (result == null) result = caseCSTrace(unit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.PACKAGE_DECL: {
				packageDecl packageDecl = (packageDecl)theEObject;
				T result = casepackageDecl(packageDecl);
				if (result == null) result = casefile(packageDecl);
				if (result == null) result = caseCSTrace(packageDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.LIBRARY: {
				library library = (library)theEObject;
				T result = caselibrary(library);
				if (result == null) result = casefile(library);
				if (result == null) result = caseCSTrace(library);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.PROGRAM_BLOCK: {
				programBlock programBlock = (programBlock)theEObject;
				T result = caseprogramBlock(programBlock);
				if (result == null) result = caseCSTrace(programBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.USES_CLAUSE: {
				usesClause usesClause = (usesClause)theEObject;
				T result = caseusesClause(usesClause);
				if (result == null) result = caseCSTrace(usesClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.INTERFACE_SECTION: {
				interfaceSection interfaceSection = (interfaceSection)theEObject;
				T result = caseinterfaceSection(interfaceSection);
				if (result == null) result = caseCSTrace(interfaceSection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.INTERFACE_DECL: {
				interfaceDecl interfaceDecl = (interfaceDecl)theEObject;
				T result = caseinterfaceDecl(interfaceDecl);
				if (result == null) result = caseCSTrace(interfaceDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.EXPORTED_HEADING: {
				exportedHeading exportedHeading = (exportedHeading)theEObject;
				T result = caseexportedHeading(exportedHeading);
				if (result == null) result = caseinterfaceDecl(exportedHeading);
				if (result == null) result = caseCSTrace(exportedHeading);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.IMPLEMENTATION_SECTION: {
				implementationSection implementationSection = (implementationSection)theEObject;
				T result = caseimplementationSection(implementationSection);
				if (result == null) result = caseCSTrace(implementationSection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.BLOCK: {
				block block = (block)theEObject;
				T result = caseblock(block);
				if (result == null) result = caseCSTrace(block);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.EXPORTS_ITEM: {
				exportsItem exportsItem = (exportsItem)theEObject;
				T result = caseexportsItem(exportsItem);
				if (result == null) result = caseCSTrace(exportsItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.EXPORTS_STMT: {
				exportsStmt exportsStmt = (exportsStmt)theEObject;
				T result = caseexportsStmt(exportsStmt);
				if (result == null) result = caseCSTrace(exportsStmt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.DECL_SECTION: {
				declSection declSection = (declSection)theEObject;
				T result = casedeclSection(declSection);
				if (result == null) result = caseCSTrace(declSection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.LABEL_DECL_SECTION: {
				labelDeclSection labelDeclSection = (labelDeclSection)theEObject;
				T result = caselabelDeclSection(labelDeclSection);
				if (result == null) result = casedeclSection(labelDeclSection);
				if (result == null) result = caseCSTrace(labelDeclSection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CONST_SECTION: {
				constSection constSection = (constSection)theEObject;
				T result = caseconstSection(constSection);
				if (result == null) result = caseinterfaceDecl(constSection);
				if (result == null) result = casedeclSection(constSection);
				if (result == null) result = caseCSTrace(constSection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CONSTANT_DECL: {
				constantDecl constantDecl = (constantDecl)theEObject;
				T result = caseconstantDecl(constantDecl);
				if (result == null) result = caseCSTrace(constantDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.TYPE_SECTION: {
				typeSection typeSection = (typeSection)theEObject;
				T result = casetypeSection(typeSection);
				if (result == null) result = caseinterfaceDecl(typeSection);
				if (result == null) result = casedeclSection(typeSection);
				if (result == null) result = caseCSTrace(typeSection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.TYPE_DECL: {
				typeDecl typeDecl = (typeDecl)theEObject;
				T result = casetypeDecl(typeDecl);
				if (result == null) result = caseCSTrace(typeDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.TYPED_CONSTANT: {
				typedConstant typedConstant = (typedConstant)theEObject;
				T result = casetypedConstant(typedConstant);
				if (result == null) result = caseCSTrace(typedConstant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.ARRAY_CONSTANT: {
				arrayConstant arrayConstant = (arrayConstant)theEObject;
				T result = casearrayConstant(arrayConstant);
				if (result == null) result = caseCSTrace(arrayConstant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.RECORD_CONSTANT: {
				recordConstant recordConstant = (recordConstant)theEObject;
				T result = caserecordConstant(recordConstant);
				if (result == null) result = caseCSTrace(recordConstant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.RECORD_FIELD_CONSTANT: {
				recordFieldConstant recordFieldConstant = (recordFieldConstant)theEObject;
				T result = caserecordFieldConstant(recordFieldConstant);
				if (result == null) result = caseCSTrace(recordFieldConstant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.TYPE: {
				type type = (type)theEObject;
				T result = casetype(type);
				if (result == null) result = caseCSTrace(type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.RESTRICTED_TYPE: {
				restrictedType restrictedType = (restrictedType)theEObject;
				T result = caserestrictedType(restrictedType);
				if (result == null) result = caseCSTrace(restrictedType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CLASS_REF_TYPE: {
				classRefType classRefType = (classRefType)theEObject;
				T result = caseclassRefType(classRefType);
				if (result == null) result = casetype(classRefType);
				if (result == null) result = caseCSTrace(classRefType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.SIMPLE_TYPE: {
				simpleType simpleType = (simpleType)theEObject;
				T result = casesimpleType(simpleType);
				if (result == null) result = casetype(simpleType);
				if (result == null) result = caseCSTrace(simpleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.REAL_TYPE: {
				realType realType = (realType)theEObject;
				T result = caserealType(realType);
				if (result == null) result = casesimpleType(realType);
				if (result == null) result = casetype(realType);
				if (result == null) result = caseCSTrace(realType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.ORDINAL_TYPE: {
				ordinalType ordinalType = (ordinalType)theEObject;
				T result = caseordinalType(ordinalType);
				if (result == null) result = casesimpleType(ordinalType);
				if (result == null) result = casetype(ordinalType);
				if (result == null) result = caseCSTrace(ordinalType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.ORD_IDENT: {
				ordIdent ordIdent = (ordIdent)theEObject;
				T result = caseordIdent(ordIdent);
				if (result == null) result = caseordinalType(ordIdent);
				if (result == null) result = casesimpleType(ordIdent);
				if (result == null) result = casetype(ordIdent);
				if (result == null) result = caseCSTrace(ordIdent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.VARIANT_TYPE: {
				variantType variantType = (variantType)theEObject;
				T result = casevariantType(variantType);
				if (result == null) result = casetype(variantType);
				if (result == null) result = caseCSTrace(variantType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.SUBRANGE_TYPE: {
				subrangeType subrangeType = (subrangeType)theEObject;
				T result = casesubrangeType(subrangeType);
				if (result == null) result = caseordinalType(subrangeType);
				if (result == null) result = casesimpleType(subrangeType);
				if (result == null) result = casetype(subrangeType);
				if (result == null) result = caseCSTrace(subrangeType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.ENUMERATED_TYPE: {
				enumeratedType enumeratedType = (enumeratedType)theEObject;
				T result = caseenumeratedType(enumeratedType);
				if (result == null) result = caseordinalType(enumeratedType);
				if (result == null) result = casesimpleType(enumeratedType);
				if (result == null) result = casetype(enumeratedType);
				if (result == null) result = caseCSTrace(enumeratedType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.ENUMERATED_TYPE_ELEMENT: {
				enumeratedTypeElement enumeratedTypeElement = (enumeratedTypeElement)theEObject;
				T result = caseenumeratedTypeElement(enumeratedTypeElement);
				if (result == null) result = caseCSTrace(enumeratedTypeElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.STRING_TYPE: {
				stringType stringType = (stringType)theEObject;
				T result = casestringType(stringType);
				if (result == null) result = casetype(stringType);
				if (result == null) result = caseCSTrace(stringType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.STRUC_TYPE: {
				strucType strucType = (strucType)theEObject;
				T result = casestrucType(strucType);
				if (result == null) result = casetype(strucType);
				if (result == null) result = caseCSTrace(strucType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.ARRAY_TYPE: {
				arrayType arrayType = (arrayType)theEObject;
				T result = casearrayType(arrayType);
				if (result == null) result = casestrucType(arrayType);
				if (result == null) result = casetype(arrayType);
				if (result == null) result = caseCSTrace(arrayType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.REC_TYPE: {
				recType recType = (recType)theEObject;
				T result = caserecType(recType);
				if (result == null) result = casestrucType(recType);
				if (result == null) result = casetype(recType);
				if (result == null) result = caseCSTrace(recType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.FIELD_LIST: {
				fieldList fieldList = (fieldList)theEObject;
				T result = casefieldList(fieldList);
				if (result == null) result = caseCSTrace(fieldList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.FIELD_DECL: {
				fieldDecl fieldDecl = (fieldDecl)theEObject;
				T result = casefieldDecl(fieldDecl);
				if (result == null) result = caseCSTrace(fieldDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.VARIANT_SECTION: {
				variantSection variantSection = (variantSection)theEObject;
				T result = casevariantSection(variantSection);
				if (result == null) result = caseCSTrace(variantSection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.REC_VARIANT: {
				recVariant recVariant = (recVariant)theEObject;
				T result = caserecVariant(recVariant);
				if (result == null) result = caseCSTrace(recVariant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.SET_TYPE: {
				setType setType = (setType)theEObject;
				T result = casesetType(setType);
				if (result == null) result = casestrucType(setType);
				if (result == null) result = casetype(setType);
				if (result == null) result = caseCSTrace(setType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.FILE_TYPE: {
				fileType fileType = (fileType)theEObject;
				T result = casefileType(fileType);
				if (result == null) result = casestrucType(fileType);
				if (result == null) result = casetype(fileType);
				if (result == null) result = caseCSTrace(fileType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.POINTER_TYPE: {
				pointerType pointerType = (pointerType)theEObject;
				T result = casepointerType(pointerType);
				if (result == null) result = casetype(pointerType);
				if (result == null) result = caseCSTrace(pointerType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.PROCEDURE_TYPE: {
				procedureType procedureType = (procedureType)theEObject;
				T result = caseprocedureType(procedureType);
				if (result == null) result = casetype(procedureType);
				if (result == null) result = caseCSTrace(procedureType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.VAR_SECTION: {
				varSection varSection = (varSection)theEObject;
				T result = casevarSection(varSection);
				if (result == null) result = caseinterfaceDecl(varSection);
				if (result == null) result = casedeclSection(varSection);
				if (result == null) result = caseCSTrace(varSection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.VAR_DECL: {
				varDecl varDecl = (varDecl)theEObject;
				T result = casevarDecl(varDecl);
				if (result == null) result = caseCSTrace(varDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.EXPRESSION: {
				expression expression = (expression)theEObject;
				T result = caseexpression(expression);
				if (result == null) result = caseCSTrace(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.SIMPLE_EXPRESSION: {
				simpleExpression simpleExpression = (simpleExpression)theEObject;
				T result = casesimpleExpression(simpleExpression);
				if (result == null) result = caseexpression(simpleExpression);
				if (result == null) result = caseCSTrace(simpleExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.TERM: {
				term term = (term)theEObject;
				T result = caseterm(term);
				if (result == null) result = casesimpleExpression(term);
				if (result == null) result = caseexpression(term);
				if (result == null) result = caseCSTrace(term);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.FACTOR: {
				factor factor = (factor)theEObject;
				T result = casefactor(factor);
				if (result == null) result = caseterm(factor);
				if (result == null) result = casesimpleExpression(factor);
				if (result == null) result = caseexpression(factor);
				if (result == null) result = caseCSTrace(factor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.REL_OP: {
				relOp relOp = (relOp)theEObject;
				T result = caserelOp(relOp);
				if (result == null) result = caseCSTrace(relOp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.ADD_OP: {
				addOp addOp = (addOp)theEObject;
				T result = caseaddOp(addOp);
				if (result == null) result = caseCSTrace(addOp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.MUL_OP: {
				mulOp mulOp = (mulOp)theEObject;
				T result = casemulOp(mulOp);
				if (result == null) result = caseCSTrace(mulOp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.DESIGNATOR: {
				designator designator = (designator)theEObject;
				T result = casedesignator(designator);
				if (result == null) result = caseCSTrace(designator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.DESIGNATOR_SUB_PART: {
				designatorSubPart designatorSubPart = (designatorSubPart)theEObject;
				T result = casedesignatorSubPart(designatorSubPart);
				if (result == null) result = caseCSTrace(designatorSubPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.DESIGNATOR_PART: {
				designatorPart designatorPart = (designatorPart)theEObject;
				T result = casedesignatorPart(designatorPart);
				if (result == null) result = caseCSTrace(designatorPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.SET_CONSTRUCTOR: {
				setConstructor setConstructor = (setConstructor)theEObject;
				T result = casesetConstructor(setConstructor);
				if (result == null) result = caseCSTrace(setConstructor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.SET_ELEMENT: {
				setElement setElement = (setElement)theEObject;
				T result = casesetElement(setElement);
				if (result == null) result = caseCSTrace(setElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.EXPR_LIST: {
				exprList exprList = (exprList)theEObject;
				T result = caseexprList(exprList);
				if (result == null) result = caseCSTrace(exprList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.STMT_LIST: {
				stmtList stmtList = (stmtList)theEObject;
				T result = casestmtList(stmtList);
				if (result == null) result = caseCSTrace(stmtList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.STATEMENT: {
				statement statement = (statement)theEObject;
				T result = casestatement(statement);
				if (result == null) result = caseCSTrace(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.UNLABELLED_STATEMENT: {
				unlabelledStatement unlabelledStatement = (unlabelledStatement)theEObject;
				T result = caseunlabelledStatement(unlabelledStatement);
				if (result == null) result = caseCSTrace(unlabelledStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.SIMPLE_STATEMENT: {
				simpleStatement simpleStatement = (simpleStatement)theEObject;
				T result = casesimpleStatement(simpleStatement);
				if (result == null) result = caseunlabelledStatement(simpleStatement);
				if (result == null) result = caseCSTrace(simpleStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.STRUCT_STMT: {
				structStmt structStmt = (structStmt)theEObject;
				T result = casestructStmt(structStmt);
				if (result == null) result = caseunlabelledStatement(structStmt);
				if (result == null) result = caseCSTrace(structStmt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.COMPOUND_STMT: {
				compoundStmt compoundStmt = (compoundStmt)theEObject;
				T result = casecompoundStmt(compoundStmt);
				if (result == null) result = casestructStmt(compoundStmt);
				if (result == null) result = caseunlabelledStatement(compoundStmt);
				if (result == null) result = caseCSTrace(compoundStmt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CONDITIONAL_STMT: {
				conditionalStmt conditionalStmt = (conditionalStmt)theEObject;
				T result = caseconditionalStmt(conditionalStmt);
				if (result == null) result = casestructStmt(conditionalStmt);
				if (result == null) result = caseunlabelledStatement(conditionalStmt);
				if (result == null) result = caseCSTrace(conditionalStmt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.IF_STMT: {
				ifStmt ifStmt = (ifStmt)theEObject;
				T result = caseifStmt(ifStmt);
				if (result == null) result = caseconditionalStmt(ifStmt);
				if (result == null) result = casestructStmt(ifStmt);
				if (result == null) result = caseunlabelledStatement(ifStmt);
				if (result == null) result = caseCSTrace(ifStmt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CASE_STMT: {
				caseStmt caseStmt = (caseStmt)theEObject;
				T result = casecaseStmt(caseStmt);
				if (result == null) result = caseconditionalStmt(caseStmt);
				if (result == null) result = casestructStmt(caseStmt);
				if (result == null) result = caseunlabelledStatement(caseStmt);
				if (result == null) result = caseCSTrace(caseStmt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CASE_SELECTOR: {
				caseSelector caseSelector = (caseSelector)theEObject;
				T result = casecaseSelector(caseSelector);
				if (result == null) result = caseCSTrace(caseSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CASE_LABEL: {
				caseLabel caseLabel = (caseLabel)theEObject;
				T result = casecaseLabel(caseLabel);
				if (result == null) result = caseCSTrace(caseLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.LOOP_STMT: {
				loopStmt loopStmt = (loopStmt)theEObject;
				T result = caseloopStmt(loopStmt);
				if (result == null) result = casestructStmt(loopStmt);
				if (result == null) result = caseunlabelledStatement(loopStmt);
				if (result == null) result = caseCSTrace(loopStmt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.REPEAT_STMT: {
				repeatStmt repeatStmt = (repeatStmt)theEObject;
				T result = caserepeatStmt(repeatStmt);
				if (result == null) result = caseloopStmt(repeatStmt);
				if (result == null) result = casestructStmt(repeatStmt);
				if (result == null) result = caseunlabelledStatement(repeatStmt);
				if (result == null) result = caseCSTrace(repeatStmt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.WHILE_STMT: {
				whileStmt whileStmt = (whileStmt)theEObject;
				T result = casewhileStmt(whileStmt);
				if (result == null) result = caseloopStmt(whileStmt);
				if (result == null) result = casestructStmt(whileStmt);
				if (result == null) result = caseunlabelledStatement(whileStmt);
				if (result == null) result = caseCSTrace(whileStmt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.FOR_STMT: {
				forStmt forStmt = (forStmt)theEObject;
				T result = caseforStmt(forStmt);
				if (result == null) result = caseloopStmt(forStmt);
				if (result == null) result = casestructStmt(forStmt);
				if (result == null) result = caseunlabelledStatement(forStmt);
				if (result == null) result = caseCSTrace(forStmt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.WITH_STMT: {
				withStmt withStmt = (withStmt)theEObject;
				T result = casewithStmt(withStmt);
				if (result == null) result = casestructStmt(withStmt);
				if (result == null) result = caseunlabelledStatement(withStmt);
				if (result == null) result = caseCSTrace(withStmt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.TRY_STMT: {
				tryStmt tryStmt = (tryStmt)theEObject;
				T result = casetryStmt(tryStmt);
				if (result == null) result = casestructStmt(tryStmt);
				if (result == null) result = caseunlabelledStatement(tryStmt);
				if (result == null) result = caseCSTrace(tryStmt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.EXCEPTION_BLOCK: {
				exceptionBlock exceptionBlock = (exceptionBlock)theEObject;
				T result = caseexceptionBlock(exceptionBlock);
				if (result == null) result = caseCSTrace(exceptionBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.RAISE_STMT: {
				raiseStmt raiseStmt = (raiseStmt)theEObject;
				T result = caseraiseStmt(raiseStmt);
				if (result == null) result = casestructStmt(raiseStmt);
				if (result == null) result = caseunlabelledStatement(raiseStmt);
				if (result == null) result = caseCSTrace(raiseStmt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.ASSEMBLER_STMT: {
				assemblerStmt assemblerStmt = (assemblerStmt)theEObject;
				T result = caseassemblerStmt(assemblerStmt);
				if (result == null) result = casestructStmt(assemblerStmt);
				if (result == null) result = caseunlabelledStatement(assemblerStmt);
				if (result == null) result = caseCSTrace(assemblerStmt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.PROCEDURE_DECL_SECTION: {
				procedureDeclSection procedureDeclSection = (procedureDeclSection)theEObject;
				T result = caseprocedureDeclSection(procedureDeclSection);
				if (result == null) result = casedeclSection(procedureDeclSection);
				if (result == null) result = caseCSTrace(procedureDeclSection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.PROCEDURE_DECL: {
				procedureDecl procedureDecl = (procedureDecl)theEObject;
				T result = caseprocedureDecl(procedureDecl);
				if (result == null) result = caseprocedureDeclSection(procedureDecl);
				if (result == null) result = casedeclSection(procedureDecl);
				if (result == null) result = caseCSTrace(procedureDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.FUNCTION_DECL: {
				functionDecl functionDecl = (functionDecl)theEObject;
				T result = casefunctionDecl(functionDecl);
				if (result == null) result = caseprocedureDeclSection(functionDecl);
				if (result == null) result = casedeclSection(functionDecl);
				if (result == null) result = caseCSTrace(functionDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.FUNCTION_HEADING: {
				functionHeading functionHeading = (functionHeading)theEObject;
				T result = casefunctionHeading(functionHeading);
				if (result == null) result = casemethodHeading(functionHeading);
				if (result == null) result = caseCSTrace(functionHeading);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.PROCEDURE_HEADING: {
				procedureHeading procedureHeading = (procedureHeading)theEObject;
				T result = caseprocedureHeading(procedureHeading);
				if (result == null) result = casemethodHeading(procedureHeading);
				if (result == null) result = caseCSTrace(procedureHeading);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.FORMAL_PARAMETERS: {
				formalParameters formalParameters = (formalParameters)theEObject;
				T result = caseformalParameters(formalParameters);
				if (result == null) result = caseCSTrace(formalParameters);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.FORMAL_PARM: {
				formalParm formalParm = (formalParm)theEObject;
				T result = caseformalParm(formalParm);
				if (result == null) result = caseCSTrace(formalParm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.PARAMETER: {
				parameter parameter = (parameter)theEObject;
				T result = caseparameter(parameter);
				if (result == null) result = caseCSTrace(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.DIRECTIVE: {
				directive directive = (directive)theEObject;
				T result = casedirective(directive);
				if (result == null) result = caseCSTrace(directive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.OBJECT_TYPE: {
				objectType objectType = (objectType)theEObject;
				T result = caseobjectType(objectType);
				if (result == null) result = caserestrictedType(objectType);
				if (result == null) result = caseCSTrace(objectType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.OBJ_HERITAGE: {
				objHeritage objHeritage = (objHeritage)theEObject;
				T result = caseobjHeritage(objHeritage);
				if (result == null) result = caseCSTrace(objHeritage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.METHOD_LIST: {
				methodList methodList = (methodList)theEObject;
				T result = casemethodList(methodList);
				if (result == null) result = caseCSTrace(methodList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.METHOD_HEADING: {
				methodHeading methodHeading = (methodHeading)theEObject;
				T result = casemethodHeading(methodHeading);
				if (result == null) result = caseCSTrace(methodHeading);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CONSTRUCTOR_HEADING: {
				constructorHeading constructorHeading = (constructorHeading)theEObject;
				T result = caseconstructorHeading(constructorHeading);
				if (result == null) result = casemethodHeading(constructorHeading);
				if (result == null) result = caseCSTrace(constructorHeading);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.DESTRUCTOR_HEADING: {
				destructorHeading destructorHeading = (destructorHeading)theEObject;
				T result = casedestructorHeading(destructorHeading);
				if (result == null) result = casemethodHeading(destructorHeading);
				if (result == null) result = caseCSTrace(destructorHeading);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.OBJ_FIELD_LIST: {
				objFieldList objFieldList = (objFieldList)theEObject;
				T result = caseobjFieldList(objFieldList);
				if (result == null) result = caseCSTrace(objFieldList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.INIT_SECTION: {
				initSection initSection = (initSection)theEObject;
				T result = caseinitSection(initSection);
				if (result == null) result = caseCSTrace(initSection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CLASS_TYPE: {
				classType classType = (classType)theEObject;
				T result = caseclassType(classType);
				if (result == null) result = caserestrictedType(classType);
				if (result == null) result = caseCSTrace(classType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CLASS_HERITAGE: {
				classHeritage classHeritage = (classHeritage)theEObject;
				T result = caseclassHeritage(classHeritage);
				if (result == null) result = caseCSTrace(classHeritage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CLASS_FIELD_LIST: {
				classFieldList classFieldList = (classFieldList)theEObject;
				T result = caseclassFieldList(classFieldList);
				if (result == null) result = caseCSTrace(classFieldList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CLASS_FIELD: {
				classField classField = (classField)theEObject;
				T result = caseclassField(classField);
				if (result == null) result = caseCSTrace(classField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CLASS_METHOD_LIST: {
				classMethodList classMethodList = (classMethodList)theEObject;
				T result = caseclassMethodList(classMethodList);
				if (result == null) result = caseCSTrace(classMethodList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CLASS_METHOD: {
				classMethod classMethod = (classMethod)theEObject;
				T result = caseclassMethod(classMethod);
				if (result == null) result = caseCSTrace(classMethod);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CLASS_PROPERTY_LIST: {
				classPropertyList classPropertyList = (classPropertyList)theEObject;
				T result = caseclassPropertyList(classPropertyList);
				if (result == null) result = caseCSTrace(classPropertyList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CLASS_PROPERTY: {
				classProperty classProperty = (classProperty)theEObject;
				T result = caseclassProperty(classProperty);
				if (result == null) result = caseCSTrace(classProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.PROPERTY_LIST: {
				propertyList propertyList = (propertyList)theEObject;
				T result = casepropertyList(propertyList);
				if (result == null) result = caseCSTrace(propertyList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.PROPERTY_INTERFACE: {
				propertyInterface propertyInterface = (propertyInterface)theEObject;
				T result = casepropertyInterface(propertyInterface);
				if (result == null) result = caseCSTrace(propertyInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.PROPERTY_PARAMETER_LIST: {
				propertyParameterList propertyParameterList = (propertyParameterList)theEObject;
				T result = casepropertyParameterList(propertyParameterList);
				if (result == null) result = caseCSTrace(propertyParameterList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.PROPERTY_SPECIFIERS: {
				propertySpecifiers propertySpecifiers = (propertySpecifiers)theEObject;
				T result = casepropertySpecifiers(propertySpecifiers);
				if (result == null) result = caseCSTrace(propertySpecifiers);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.INTERFACE_TYPE: {
				interfaceType interfaceType = (interfaceType)theEObject;
				T result = caseinterfaceType(interfaceType);
				if (result == null) result = caserestrictedType(interfaceType);
				if (result == null) result = caseCSTrace(interfaceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.INTERFACE_HERITAGE: {
				interfaceHeritage interfaceHeritage = (interfaceHeritage)theEObject;
				T result = caseinterfaceHeritage(interfaceHeritage);
				if (result == null) result = caseCSTrace(interfaceHeritage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.REQUIRES_CLAUSE: {
				requiresClause requiresClause = (requiresClause)theEObject;
				T result = caserequiresClause(requiresClause);
				if (result == null) result = caseCSTrace(requiresClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CONTAINS_CLAUSE: {
				containsClause containsClause = (containsClause)theEObject;
				T result = casecontainsClause(containsClause);
				if (result == null) result = caseCSTrace(containsClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.IDENT_LIST: {
				identList identList = (identList)theEObject;
				T result = caseidentList(identList);
				if (result == null) result = caseobjFieldList(identList);
				if (result == null) result = caseclassHeritage(identList);
				if (result == null) result = caseCSTrace(identList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.QUAL_ID: {
				qualId qualId = (qualId)theEObject;
				T result = casequalId(qualId);
				if (result == null) result = caseCSTrace(qualId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.TYPE_ID: {
				typeId typeId = (typeId)theEObject;
				T result = casetypeId(typeId);
				if (result == null) result = casepointerType(typeId);
				if (result == null) result = casetype(typeId);
				if (result == null) result = caseCSTrace(typeId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.IDENT: {
				ident ident = (ident)theEObject;
				T result = caseident(ident);
				if (result == null) result = caseCSTrace(ident);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.RESERVED_WORD: {
				reservedWord reservedWord = (reservedWord)theEObject;
				T result = casereservedWord(reservedWord);
				if (result == null) result = caseCSTrace(reservedWord);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CONST_EXPR: {
				constExpr constExpr = (constExpr)theEObject;
				T result = caseconstExpr(constExpr);
				if (result == null) result = caseCSTrace(constExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.RECORD_CONST_EXPR: {
				recordConstExpr recordConstExpr = (recordConstExpr)theEObject;
				T result = caserecordConstExpr(recordConstExpr);
				if (result == null) result = caseCSTrace(recordConstExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.UNIT_ID: {
				unitId unitId = (unitId)theEObject;
				T result = caseunitId(unitId);
				if (result == null) result = caseCSTrace(unitId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.REL_EXP: {
				relExp relExp = (relExp)theEObject;
				T result = caserelExp(relExp);
				if (result == null) result = caseexpression(relExp);
				if (result == null) result = caseCSTrace(relExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.ADD_EXP: {
				addExp addExp = (addExp)theEObject;
				T result = caseaddExp(addExp);
				if (result == null) result = casesimpleExpression(addExp);
				if (result == null) result = caseexpression(addExp);
				if (result == null) result = caseCSTrace(addExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.MULT_EXP: {
				multExp multExp = (multExp)theEObject;
				T result = casemultExp(multExp);
				if (result == null) result = caseterm(multExp);
				if (result == null) result = casesimpleExpression(multExp);
				if (result == null) result = caseexpression(multExp);
				if (result == null) result = caseCSTrace(multExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.SIMPLE_FACTOR: {
				simpleFactor simpleFactor = (simpleFactor)theEObject;
				T result = casesimpleFactor(simpleFactor);
				if (result == null) result = casefactor(simpleFactor);
				if (result == null) result = caseterm(simpleFactor);
				if (result == null) result = casesimpleExpression(simpleFactor);
				if (result == null) result = caseexpression(simpleFactor);
				if (result == null) result = caseCSTrace(simpleFactor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.ASSIGNMENT_STMNT: {
				assignmentStmnt assignmentStmnt = (assignmentStmnt)theEObject;
				T result = caseassignmentStmnt(assignmentStmnt);
				if (result == null) result = casesimpleStatement(assignmentStmnt);
				if (result == null) result = caseunlabelledStatement(assignmentStmnt);
				if (result == null) result = caseCSTrace(assignmentStmnt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CALL_STMNT: {
				callStmnt callStmnt = (callStmnt)theEObject;
				T result = casecallStmnt(callStmnt);
				if (result == null) result = casesimpleStatement(callStmnt);
				if (result == null) result = caseunlabelledStatement(callStmnt);
				if (result == null) result = caseCSTrace(callStmnt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.INHERITED_STAMNT: {
				inheritedStamnt inheritedStamnt = (inheritedStamnt)theEObject;
				T result = caseinheritedStamnt(inheritedStamnt);
				if (result == null) result = casesimpleStatement(inheritedStamnt);
				if (result == null) result = caseunlabelledStatement(inheritedStamnt);
				if (result == null) result = caseCSTrace(inheritedStamnt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.GOTO_STMNT: {
				gotoStmnt gotoStmnt = (gotoStmnt)theEObject;
				T result = casegotoStmnt(gotoStmnt);
				if (result == null) result = casesimpleStatement(gotoStmnt);
				if (result == null) result = caseunlabelledStatement(gotoStmnt);
				if (result == null) result = caseCSTrace(gotoStmnt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.PARAMETER_LIST: {
				parameterList parameterList = (parameterList)theEObject;
				T result = caseparameterList(parameterList);
				if (result == null) result = caseparameter(parameterList);
				if (result == null) result = caseCSTrace(parameterList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.PARAMETER_SIMPLE: {
				parameterSimple parameterSimple = (parameterSimple)theEObject;
				T result = caseparameterSimple(parameterSimple);
				if (result == null) result = caseparameter(parameterSimple);
				if (result == null) result = caseCSTrace(parameterSimple);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.MULTIPLE_ID: {
				MultipleId multipleId = (MultipleId)theEObject;
				T result = caseMultipleId(multipleId);
				if (result == null) result = caseident(multipleId);
				if (result == null) result = caseCSTrace(multipleId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.RESERVED_ID: {
				ReservedId reservedId = (ReservedId)theEObject;
				T result = caseReservedId(reservedId);
				if (result == null) result = caseident(reservedId);
				if (result == null) result = caseCSTrace(reservedId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.MINE_ID: {
				MineID mineID = (MineID)theEObject;
				T result = caseMineID(mineID);
				if (result == null) result = caseident(mineID);
				if (result == null) result = caseCSTrace(mineID);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CONST_EXP: {
				ConstExp constExp = (ConstExp)theEObject;
				T result = caseConstExp(constExp);
				if (result == null) result = caseconstExpr(constExp);
				if (result == null) result = caseCSTrace(constExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.MULTIPLE_CONST_EXP: {
				MultipleConstExp multipleConstExp = (MultipleConstExp)theEObject;
				T result = caseMultipleConstExp(multipleConstExp);
				if (result == null) result = caseconstExpr(multipleConstExp);
				if (result == null) result = caseCSTrace(multipleConstExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.RECORD_CONST_EXP: {
				RecordConstExp recordConstExp = (RecordConstExp)theEObject;
				T result = caseRecordConstExp(recordConstExp);
				if (result == null) result = caseconstExpr(recordConstExp);
				if (result == null) result = caseCSTrace(recordConstExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DelphiPackage.CS_TRACE: {
				CSTrace csTrace = (CSTrace)theEObject;
				T result = caseCSTrace(csTrace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>main Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>main Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casemainRule(mainRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>file</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>file</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casefile(file object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>program</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>program</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseprogram(program object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseunit(unit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>package Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>package Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casepackageDecl(packageDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caselibrary(library object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>program Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>program Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseprogramBlock(programBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>uses Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>uses Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseusesClause(usesClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>interface Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>interface Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseinterfaceSection(interfaceSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>interface Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>interface Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseinterfaceDecl(interfaceDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>exported Heading</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>exported Heading</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseexportedHeading(exportedHeading object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>implementation Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>implementation Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseimplementationSection(implementationSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseblock(block object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>exports Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>exports Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseexportsItem(exportsItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>exports Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>exports Stmt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseexportsStmt(exportsStmt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>decl Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>decl Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casedeclSection(declSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>label Decl Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>label Decl Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caselabelDeclSection(labelDeclSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>const Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>const Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseconstSection(constSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>constant Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>constant Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseconstantDecl(constantDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>type Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>type Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casetypeSection(typeSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>type Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>type Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casetypeDecl(typeDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>typed Constant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>typed Constant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casetypedConstant(typedConstant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>array Constant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>array Constant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casearrayConstant(arrayConstant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>record Constant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>record Constant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caserecordConstant(recordConstant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>record Field Constant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>record Field Constant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caserecordFieldConstant(recordFieldConstant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casetype(type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>restricted Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>restricted Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caserestrictedType(restrictedType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>class Ref Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>class Ref Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseclassRefType(classRefType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>simple Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>simple Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casesimpleType(simpleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>real Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>real Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caserealType(realType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ordinal Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ordinal Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseordinalType(ordinalType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ord Ident</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ord Ident</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseordIdent(ordIdent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariantType(variantType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>subrange Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>subrange Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casesubrangeType(subrangeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>enumerated Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>enumerated Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseenumeratedType(enumeratedType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>enumerated Type Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>enumerated Type Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseenumeratedTypeElement(enumeratedTypeElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>string Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>string Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casestringType(stringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>struc Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>struc Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casestrucType(strucType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>array Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>array Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casearrayType(arrayType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>rec Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>rec Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caserecType(recType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>field List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>field List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casefieldList(fieldList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>field Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>field Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casefieldDecl(fieldDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariantSection(variantSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>rec Variant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>rec Variant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caserecVariant(recVariant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casesetType(setType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>file Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>file Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casefileType(fileType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>pointer Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>pointer Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casepointerType(pointerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>procedure Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>procedure Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseprocedureType(procedureType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>var Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>var Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevarSection(varSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>var Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>var Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevarDecl(varDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseexpression(expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>simple Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>simple Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casesimpleExpression(simpleExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseterm(term object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>factor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>factor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casefactor(factor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>rel Op</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>rel Op</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caserelOp(relOp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>add Op</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>add Op</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseaddOp(addOp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>mul Op</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>mul Op</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casemulOp(mulOp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>designator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>designator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casedesignator(designator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>designator Sub Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>designator Sub Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casedesignatorSubPart(designatorSubPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>designator Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>designator Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casedesignatorPart(designatorPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>set Constructor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>set Constructor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casesetConstructor(setConstructor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>set Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>set Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casesetElement(setElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>expr List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>expr List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseexprList(exprList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>stmt List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>stmt List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casestmtList(stmtList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casestatement(statement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>unlabelled Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>unlabelled Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseunlabelledStatement(unlabelledStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>simple Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>simple Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casesimpleStatement(simpleStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>struct Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>struct Stmt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casestructStmt(structStmt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>compound Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>compound Stmt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casecompoundStmt(compoundStmt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>conditional Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>conditional Stmt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseconditionalStmt(conditionalStmt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>if Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>if Stmt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseifStmt(ifStmt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>case Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>case Stmt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casecaseStmt(caseStmt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>case Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>case Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casecaseSelector(caseSelector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>case Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>case Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casecaseLabel(caseLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>loop Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>loop Stmt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseloopStmt(loopStmt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>repeat Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>repeat Stmt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caserepeatStmt(repeatStmt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>while Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>while Stmt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casewhileStmt(whileStmt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>for Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>for Stmt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseforStmt(forStmt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>with Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>with Stmt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casewithStmt(withStmt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>try Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>try Stmt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casetryStmt(tryStmt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>exception Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>exception Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseexceptionBlock(exceptionBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>raise Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>raise Stmt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseraiseStmt(raiseStmt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>assembler Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>assembler Stmt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseassemblerStmt(assemblerStmt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>procedure Decl Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>procedure Decl Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseprocedureDeclSection(procedureDeclSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>procedure Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>procedure Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseprocedureDecl(procedureDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>function Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>function Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casefunctionDecl(functionDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>function Heading</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>function Heading</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casefunctionHeading(functionHeading object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>procedure Heading</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>procedure Heading</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseprocedureHeading(procedureHeading object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>formal Parameters</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>formal Parameters</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseformalParameters(formalParameters object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>formal Parm</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>formal Parm</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseformalParm(formalParm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseparameter(parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casedirective(directive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>object Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>object Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseobjectType(objectType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>obj Heritage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>obj Heritage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseobjHeritage(objHeritage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>method List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>method List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casemethodList(methodList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>method Heading</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>method Heading</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casemethodHeading(methodHeading object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>constructor Heading</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>constructor Heading</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseconstructorHeading(constructorHeading object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>destructor Heading</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>destructor Heading</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casedestructorHeading(destructorHeading object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>obj Field List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>obj Field List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseobjFieldList(objFieldList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>init Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>init Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseinitSection(initSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseclassType(classType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>class Heritage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>class Heritage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseclassHeritage(classHeritage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>class Field List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>class Field List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseclassFieldList(classFieldList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>class Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>class Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseclassField(classField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>class Method List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>class Method List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseclassMethodList(classMethodList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>class Method</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>class Method</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseclassMethod(classMethod object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>class Property List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>class Property List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseclassPropertyList(classPropertyList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>class Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>class Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseclassProperty(classProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>property List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>property List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casepropertyList(propertyList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>property Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>property Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casepropertyInterface(propertyInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>property Parameter List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>property Parameter List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casepropertyParameterList(propertyParameterList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>property Specifiers</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>property Specifiers</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casepropertySpecifiers(propertySpecifiers object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>interface Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>interface Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseinterfaceType(interfaceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>interface Heritage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>interface Heritage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseinterfaceHeritage(interfaceHeritage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>requires Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>requires Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caserequiresClause(requiresClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>contains Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>contains Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casecontainsClause(containsClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ident List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ident List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseidentList(identList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>qual Id</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>qual Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casequalId(qualId object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>type Id</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>type Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casetypeId(typeId object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ident</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ident</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseident(ident object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>reserved Word</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>reserved Word</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casereservedWord(reservedWord object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>const Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>const Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseconstExpr(constExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>record Const Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>record Const Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caserecordConstExpr(recordConstExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>unit Id</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>unit Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseunitId(unitId object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>rel Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>rel Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caserelExp(relExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>add Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>add Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseaddExp(addExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>mult Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>mult Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casemultExp(multExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>simple Factor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>simple Factor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casesimpleFactor(simpleFactor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>assignment Stmnt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>assignment Stmnt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseassignmentStmnt(assignmentStmnt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>call Stmnt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>call Stmnt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casecallStmnt(callStmnt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>inherited Stamnt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>inherited Stamnt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseinheritedStamnt(inheritedStamnt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>goto Stmnt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>goto Stmnt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casegotoStmnt(gotoStmnt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>parameter List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>parameter List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseparameterList(parameterList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>parameter Simple</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>parameter Simple</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseparameterSimple(parameterSimple object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiple Id</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiple Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultipleId(MultipleId object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reserved Id</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reserved Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReservedId(ReservedId object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mine ID</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mine ID</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMineID(MineID object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Const Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Const Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstExp(ConstExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiple Const Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiple Const Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultipleConstExp(MultipleConstExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Record Const Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Record Const Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecordConstExp(RecordConstExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CS Trace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CS Trace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCSTrace(CSTrace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DelphiSwitch
