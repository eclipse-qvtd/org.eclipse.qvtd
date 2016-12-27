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

import astm.AstmPackage;

import delphi.CSTrace;
import delphi.ConstExp;
import delphi.DelphiFactory;
import delphi.DelphiPackage;
import delphi.MineID;
import delphi.MultipleConstExp;
import delphi.MultipleId;
import delphi.RecordConstExp;
import delphi.ReservedId;
import delphi.addExp;
import delphi.addOp;
import delphi.arrayConstant;
import delphi.arrayType;
import delphi.assemblerStmt;
import delphi.assignmentStmnt;
import delphi.block;
import delphi.callStmnt;
import delphi.caseLabel;
import delphi.caseSelector;
import delphi.caseStmt;
import delphi.classField;
import delphi.classFieldList;
import delphi.classHeritage;
import delphi.classMethod;
import delphi.classMethodList;
import delphi.classProperty;
import delphi.classPropertyList;
import delphi.classRefType;
import delphi.classType;
import delphi.compoundStmt;
import delphi.conditionalStmt;
import delphi.constExpr;
import delphi.constSection;
import delphi.constantDecl;
import delphi.constructorHeading;
import delphi.containsClause;
import delphi.declSection;
import delphi.designator;
import delphi.designatorPart;
import delphi.designatorSubPart;
import delphi.destructorHeading;
import delphi.directive;
import delphi.enumeratedType;
import delphi.enumeratedTypeElement;
import delphi.exceptionBlock;
import delphi.exportedHeading;
import delphi.exportsItem;
import delphi.exportsStmt;
import delphi.exprList;
import delphi.expression;
import delphi.factor;
import delphi.fieldDecl;
import delphi.fieldList;
import delphi.file;
import delphi.fileType;
import delphi.forStmt;
import delphi.formalParameters;
import delphi.formalParm;
import delphi.functionDecl;
import delphi.functionHeading;
import delphi.gotoStmnt;
import delphi.ident;
import delphi.identList;
import delphi.ifStmt;
import delphi.implementationSection;
import delphi.inheritedStamnt;
import delphi.initSection;
import delphi.interfaceDecl;
import delphi.interfaceHeritage;
import delphi.interfaceSection;
import delphi.interfaceType;
import delphi.labelDeclSection;
import delphi.library;
import delphi.loopStmt;
import delphi.mainRule;
import delphi.methodHeading;
import delphi.methodList;
import delphi.mulOp;
import delphi.multExp;
import delphi.objFieldList;
import delphi.objHeritage;
import delphi.objectType;
import delphi.ordIdent;
import delphi.ordinalType;
import delphi.packageDecl;
import delphi.parameter;
import delphi.parameterList;
import delphi.parameterSimple;
import delphi.pointerType;
import delphi.procedureDecl;
import delphi.procedureDeclSection;
import delphi.procedureHeading;
import delphi.procedureType;
import delphi.program;
import delphi.programBlock;
import delphi.propertyInterface;
import delphi.propertyList;
import delphi.propertyParameterList;
import delphi.propertySpecifiers;
import delphi.qualId;
import delphi.raiseStmt;
import delphi.realType;
import delphi.recType;
import delphi.recVariant;
import delphi.recordConstExpr;
import delphi.recordConstant;
import delphi.recordFieldConstant;
import delphi.relExp;
import delphi.relOp;
import delphi.repeatStmt;
import delphi.requiresClause;
import delphi.reservedWord;
import delphi.restrictedType;
import delphi.setConstructor;
import delphi.setElement;
import delphi.setType;
import delphi.simpleExpression;
import delphi.simpleFactor;
import delphi.simpleStatement;
import delphi.simpleType;
import delphi.statement;
import delphi.stmtList;
import delphi.stringType;
import delphi.strucType;
import delphi.structStmt;
import delphi.subrangeType;
import delphi.term;
import delphi.tryStmt;
import delphi.type;
import delphi.typeDecl;
import delphi.typeId;
import delphi.typeSection;
import delphi.typedConstant;
import delphi.unit;
import delphi.unitId;
import delphi.unlabelledStatement;
import delphi.usesClause;
import delphi.varDecl;
import delphi.varSection;
import delphi.variantSection;
import delphi.variantType;
import delphi.whileStmt;
import delphi.withStmt;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DelphiPackageImpl extends EPackageImpl implements DelphiPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mainRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass programEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageDeclEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass programBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass usesClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceDeclEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exportedHeadingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implementationSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exportsItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exportsStmtEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass declSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass labelDeclSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constantDeclEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeDeclEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedConstantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayConstantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recordConstantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recordFieldConstantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass restrictedTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classRefTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ordinalTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ordIdentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variantTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subrangeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumeratedTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumeratedTypeElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass strucTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fieldListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fieldDeclEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variantSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recVariantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pointerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass procedureTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass varSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass varDeclEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass termEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass factorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relOpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addOpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mulOpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass designatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass designatorSubPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass designatorPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setConstructorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exprListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stmtListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unlabelledStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structStmtEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compoundStmtEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalStmtEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifStmtEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caseStmtEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caseSelectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caseLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopStmtEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repeatStmtEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileStmtEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forStmtEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass withStmtEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tryStmtEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exceptionBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass raiseStmtEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assemblerStmtEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass procedureDeclSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass procedureDeclEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionDeclEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionHeadingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass procedureHeadingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formalParametersEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formalParmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objHeritageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodHeadingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constructorHeadingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass destructorHeadingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objFieldListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classHeritageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classFieldListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classMethodListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classMethodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classPropertyListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyParameterListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertySpecifiersEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceHeritageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requiresClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containsClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualIdEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeIdEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reservedWordEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recordConstExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitIdEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleFactorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentStmntEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callStmntEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inheritedStamntEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gotoStmntEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterSimpleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multipleIdEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reservedIdEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mineIDEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multipleConstExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recordConstExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass csTraceEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see delphi.DelphiPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DelphiPackageImpl() {
		super(eNS_URI, DelphiFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DelphiPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DelphiPackage init() {
		if (isInited) return (DelphiPackage)EPackage.Registry.INSTANCE.getEPackage(DelphiPackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DelphiPackageImpl theDelphiPackage = (DelphiPackageImpl)(ePackage instanceof DelphiPackageImpl ? ePackage : new DelphiPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		AstmPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDelphiPackage.createPackageContents();

		// Initialize created meta-data
		theDelphiPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDelphiPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DelphiPackage.eNS_URI, theDelphiPackage);
		return theDelphiPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getmainRule() {
		return mainRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getmainRule_File() {
		return (EReference)mainRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getfile() {
		return fileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getfile_Id() {
		return (EReference)fileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getprogram() {
		return programEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getprogram_ParamsList() {
		return (EReference)programEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getprogram_Block() {
		return (EReference)programEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getunit() {
		return unitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getunit_Port() {
		return (EAttribute)unitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getunit_InterfaceSect() {
		return (EReference)unitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getunit_ImplementationSect() {
		return (EReference)unitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getunit_InitSect() {
		return (EReference)unitEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getpackageDecl() {
		return packageDeclEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getpackageDecl_Requires() {
		return (EReference)packageDeclEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getpackageDecl_Contains() {
		return (EReference)packageDeclEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getlibrary() {
		return libraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getlibrary_PBlock() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getprogramBlock() {
		return programBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getprogramBlock_Uses() {
		return (EReference)programBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getprogramBlock_Block() {
		return (EReference)programBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getusesClause() {
		return usesClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getusesClause_IdList() {
		return (EReference)usesClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getinterfaceSection() {
		return interfaceSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getinterfaceSection_Uses() {
		return (EReference)interfaceSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getinterfaceSection_InterfaceDecl() {
		return (EReference)interfaceSectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getinterfaceDecl() {
		return interfaceDeclEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getexportedHeading() {
		return exportedHeadingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getexportedHeading_PHeading() {
		return (EReference)exportedHeadingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getexportedHeading_Directive() {
		return (EReference)exportedHeadingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getexportedHeading_FHeading() {
		return (EReference)exportedHeadingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getimplementationSection() {
		return implementationSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getimplementationSection_Uses() {
		return (EReference)implementationSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getimplementationSection_DeclSect() {
		return (EReference)implementationSectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getimplementationSection_Exports() {
		return (EReference)implementationSectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getblock() {
		return blockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getblock_DeclSect() {
		return (EReference)blockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getblock_Exports() {
		return (EReference)blockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getblock_Compound() {
		return (EReference)blockEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getexportsItem() {
		return exportsItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getexportsItem_Id() {
		return (EReference)exportsItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getexportsItem_ConstExp() {
		return (EReference)exportsItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getexportsStmt() {
		return exportsStmtEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getexportsStmt_Items() {
		return (EReference)exportsStmtEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getdeclSection() {
		return declSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getlabelDeclSection() {
		return labelDeclSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getlabelDeclSection_Id() {
		return (EAttribute)labelDeclSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getconstSection() {
		return constSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getconstSection_ConstantDecl() {
		return (EReference)constSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getconstantDecl() {
		return constantDeclEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getconstantDecl_Id() {
		return (EReference)constantDeclEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getconstantDecl_Const() {
		return (EReference)constantDeclEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getconstantDecl_Port() {
		return (EAttribute)constantDeclEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getconstantDecl_TypeRef() {
		return (EReference)constantDeclEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getconstantDecl_TypedConstat() {
		return (EReference)constantDeclEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass gettypeSection() {
		return typeSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference gettypeSection_TypeDecl() {
		return (EReference)typeSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass gettypeDecl() {
		return typeDeclEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference gettypeDecl_Id() {
		return (EReference)typeDeclEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference gettypeDecl_Type() {
		return (EReference)typeDeclEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute gettypeDecl_Port() {
		return (EAttribute)typeDeclEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference gettypeDecl_RestrictedType() {
		return (EReference)typeDeclEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass gettypedConstant() {
		return typedConstantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference gettypedConstant_Const() {
		return (EReference)typedConstantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference gettypedConstant_Array() {
		return (EReference)typedConstantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference gettypedConstant_Record() {
		return (EReference)typedConstantEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getarrayConstant() {
		return arrayConstantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getarrayConstant_TypedConstant() {
		return (EReference)arrayConstantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getrecordConstant() {
		return recordConstantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getrecordConstant_RecordField() {
		return (EReference)recordConstantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getrecordFieldConstant() {
		return recordFieldConstantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getrecordFieldConstant_Id() {
		return (EReference)recordFieldConstantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getrecordFieldConstant_TypedConstant() {
		return (EReference)recordFieldConstantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass gettype() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getrestrictedType() {
		return restrictedTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getclassRefType() {
		return classRefTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getclassRefType_TypeRef() {
		return (EReference)classRefTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getsimpleType() {
		return simpleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getrealType() {
		return realTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getordinalType() {
		return ordinalTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getordIdent() {
		return ordIdentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariantType() {
		return variantTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getsubrangeType() {
		return subrangeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getsubrangeType_First() {
		return (EReference)subrangeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getsubrangeType_Last() {
		return (EReference)subrangeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getenumeratedType() {
		return enumeratedTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getenumeratedType_Element() {
		return (EReference)enumeratedTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getenumeratedTypeElement() {
		return enumeratedTypeElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getenumeratedTypeElement_Id() {
		return (EReference)enumeratedTypeElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getenumeratedTypeElement_LiteralExp() {
		return (EReference)enumeratedTypeElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getstringType() {
		return stringTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getstringType_ConstExp() {
		return (EReference)stringTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getstrucType() {
		return strucTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getstrucType_Port() {
		return (EAttribute)strucTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getarrayType() {
		return arrayTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getarrayType_OrdinalType() {
		return (EReference)arrayTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getarrayType_OrdinalTyp() {
		return (EReference)arrayTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getarrayType_Type() {
		return (EReference)arrayTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getrecType() {
		return recTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getrecType_Fields() {
		return (EReference)recTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getfieldList() {
		return fieldListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getfieldList_Field() {
		return (EReference)fieldListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getfieldList_VariantSect() {
		return (EReference)fieldListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getfieldDecl() {
		return fieldDeclEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getfieldDecl_IdList() {
		return (EReference)fieldDeclEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getfieldDecl_Type() {
		return (EReference)fieldDeclEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getfieldDecl_Port() {
		return (EAttribute)fieldDeclEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariantSection() {
		return variantSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getvariantSection_Id() {
		return (EReference)variantSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getvariantSection_TypeRef() {
		return (EReference)variantSectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getvariantSection_RecVariants() {
		return (EReference)variantSectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getrecVariant() {
		return recVariantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getrecVariant_ConstExp() {
		return (EReference)recVariantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getrecVariant_FieldList() {
		return (EReference)recVariantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getsetType() {
		return setTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getsetType_Ordinal() {
		return (EReference)setTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getfileType() {
		return fileTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getfileType_TypeRef() {
		return (EReference)fileTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getpointerType() {
		return pointerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getprocedureType() {
		return procedureTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getprocedureType_PHeading() {
		return (EReference)procedureTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getprocedureType_FHeading() {
		return (EReference)procedureTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvarSection() {
		return varSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getvarSection_VarDecls() {
		return (EReference)varSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvarDecl() {
		return varDeclEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getvarDecl_IdList() {
		return (EReference)varDeclEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getvarDecl_Type() {
		return (EReference)varDeclEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getvarDecl_AbsId() {
		return (EReference)varDeclEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getvarDecl_AbsConst() {
		return (EReference)varDeclEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getvarDecl_AbsIniti() {
		return (EReference)varDeclEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getexpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getsimpleExpression() {
		return simpleExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getterm() {
		return termEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getfactor() {
		return factorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getfactor_Designator() {
		return (EReference)factorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getfactor_ExpList() {
		return (EReference)factorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getfactor_Number() {
		return (EAttribute)factorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getfactor_String() {
		return (EAttribute)factorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getfactor_NestedExp() {
		return (EReference)factorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getfactor_Exp() {
		return (EReference)factorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getfactor_SetConstuctor() {
		return (EReference)factorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getfactor_TypeRef() {
		return (EReference)factorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getrelOp() {
		return relOpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getrelOp_Op() {
		return (EAttribute)relOpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getaddOp() {
		return addOpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getaddOp_Op() {
		return (EAttribute)addOpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getmulOp() {
		return mulOpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getmulOp_Op() {
		return (EAttribute)mulOpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getdesignator() {
		return designatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getdesignator_Subpart() {
		return (EReference)designatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getdesignator_Designator() {
		return (EReference)designatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getdesignatorSubPart() {
		return designatorSubPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getdesignatorSubPart_Part() {
		return (EReference)designatorSubPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getdesignatorSubPart_ExprList() {
		return (EReference)designatorSubPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getdesignatorPart() {
		return designatorPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getdesignatorPart_Id() {
		return (EAttribute)designatorPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getdesignatorPart_ReservedWord() {
		return (EReference)designatorPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getdesignatorPart_Id2() {
		return (EAttribute)designatorPartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getsetConstructor() {
		return setConstructorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getsetConstructor_Element() {
		return (EReference)setConstructorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getsetElement() {
		return setElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getsetElement_First() {
		return (EReference)setElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getsetElement_Last() {
		return (EReference)setElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getexprList() {
		return exprListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getexprList_Exps() {
		return (EReference)exprListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getstmtList() {
		return stmtListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getstmtList_Statments() {
		return (EReference)stmtListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getstatement() {
		return statementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getstatement_LabelId() {
		return (EAttribute)statementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getstatement_Statement() {
		return (EReference)statementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getunlabelledStatement() {
		return unlabelledStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getsimpleStatement() {
		return simpleStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getstructStmt() {
		return structStmtEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getcompoundStmt() {
		return compoundStmtEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getcompoundStmt_StamtList() {
		return (EReference)compoundStmtEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getconditionalStmt() {
		return conditionalStmtEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getifStmt() {
		return ifStmtEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getifStmt_Condition() {
		return (EReference)ifStmtEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getifStmt_Then() {
		return (EReference)ifStmtEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getifStmt_Else() {
		return (EReference)ifStmtEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getcaseStmt() {
		return caseStmtEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getcaseStmt_Expression() {
		return (EReference)caseStmtEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getcaseStmt_Cases() {
		return (EReference)caseStmtEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getcaseStmt_Default() {
		return (EReference)caseStmtEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getcaseSelector() {
		return caseSelectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getcaseSelector_Labels() {
		return (EReference)caseSelectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getcaseSelector_Stmt() {
		return (EReference)caseSelectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getcaseLabel() {
		return caseLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getcaseLabel_First() {
		return (EReference)caseLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getcaseLabel_Last() {
		return (EReference)caseLabelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getloopStmt() {
		return loopStmtEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getloopStmt_Stmt() {
		return (EReference)loopStmtEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getloopStmt_Condition() {
		return (EReference)loopStmtEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getrepeatStmt() {
		return repeatStmtEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getwhileStmt() {
		return whileStmtEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getforStmt() {
		return forStmtEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getforStmt_VarId() {
		return (EReference)forStmtEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getforStmt_VarInit() {
		return (EReference)forStmtEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getwithStmt() {
		return withStmtEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getwithStmt_Vars() {
		return (EReference)withStmtEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getwithStmt_Stmt() {
		return (EReference)withStmtEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass gettryStmt() {
		return tryStmtEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference gettryStmt_StmtList() {
		return (EReference)tryStmtEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference gettryStmt_Exception() {
		return (EReference)tryStmtEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference gettryStmt_Final() {
		return (EReference)tryStmtEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getexceptionBlock() {
		return exceptionBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getexceptionBlock_ExceptionId() {
		return (EReference)exceptionBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getexceptionBlock_Type() {
		return (EReference)exceptionBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getexceptionBlock_DoStmt() {
		return (EReference)exceptionBlockEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getexceptionBlock_ElseStmts() {
		return (EReference)exceptionBlockEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getraiseStmt() {
		return raiseStmtEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getraiseStmt_Raise() {
		return (EAttribute)raiseStmtEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getraiseStmt_At() {
		return (EAttribute)raiseStmtEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getassemblerStmt() {
		return assemblerStmtEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getprocedureDeclSection() {
		return procedureDeclSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getprocedureDeclSection_Directive() {
		return (EReference)procedureDeclSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getprocedureDeclSection_Port() {
		return (EAttribute)procedureDeclSectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getprocedureDeclSection_Block() {
		return (EReference)procedureDeclSectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getprocedureDecl() {
		return procedureDeclEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getprocedureDecl_Heading() {
		return (EReference)procedureDeclEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getfunctionDecl() {
		return functionDeclEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getfunctionDecl_Heading() {
		return (EReference)functionDeclEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getfunctionHeading() {
		return functionHeadingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getfunctionHeading_Type() {
		return (EReference)functionHeadingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getprocedureHeading() {
		return procedureHeadingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getformalParameters() {
		return formalParametersEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getformalParameters_Params() {
		return (EReference)formalParametersEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getformalParm() {
		return formalParmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getformalParm_Param() {
		return (EReference)formalParmEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getparameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getparameter_Type() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getdirective() {
		return directiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getdirective_Dir() {
		return (EAttribute)directiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getdirective_MessageExp() {
		return (EReference)directiveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getobjectType() {
		return objectTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getobjectType_Heritage() {
		return (EReference)objectTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getobjectType_FieldList() {
		return (EReference)objectTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getobjectType_MethodList() {
		return (EReference)objectTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getobjHeritage() {
		return objHeritageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getobjHeritage_Id() {
		return (EReference)objHeritageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getmethodList() {
		return methodListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getmethodList_Heading() {
		return (EReference)methodListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getmethodList_Directive() {
		return (EReference)methodListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getmethodHeading() {
		return methodHeadingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getmethodHeading_Id() {
		return (EReference)methodHeadingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getmethodHeading_FormalParams() {
		return (EReference)methodHeadingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getconstructorHeading() {
		return constructorHeadingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getdestructorHeading() {
		return destructorHeadingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getobjFieldList() {
		return objFieldListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getinitSection() {
		return initSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getinitSection_StmtList() {
		return (EReference)initSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getinitSection_EndStmtList() {
		return (EReference)initSectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getclassType() {
		return classTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getclassType_Heritage() {
		return (EReference)classTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getclassType_Visibility() {
		return (EAttribute)classTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getclassType_FieldList() {
		return (EReference)classTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getclassType_MethodList() {
		return (EReference)classTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getclassType_PropList() {
		return (EReference)classTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getclassHeritage() {
		return classHeritageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getclassFieldList() {
		return classFieldListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getclassFieldList_Field() {
		return (EReference)classFieldListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getclassField() {
		return classFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getclassField_Visibility() {
		return (EAttribute)classFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getclassField_FieldList() {
		return (EReference)classFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getclassMethodList() {
		return classMethodListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getclassMethodList_Metod() {
		return (EReference)classMethodListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getclassMethod() {
		return classMethodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getclassMethod_Visibility() {
		return (EAttribute)classMethodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getclassMethod_MethodList() {
		return (EReference)classMethodEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getclassPropertyList() {
		return classPropertyListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getclassPropertyList_Property() {
		return (EReference)classPropertyListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getclassProperty() {
		return classPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getclassProperty_Visibility() {
		return (EAttribute)classPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getclassProperty_PropList() {
		return (EReference)classPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getpropertyList() {
		return propertyListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getpropertyList_Id() {
		return (EReference)propertyListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getpropertyList_Interface() {
		return (EReference)propertyListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getpropertyList_Specifiers() {
		return (EReference)propertyListEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getpropertyList_Port() {
		return (EAttribute)propertyListEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getpropertyInterface() {
		return propertyInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getpropertyInterface_ParamList() {
		return (EReference)propertyInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getpropertyInterface_Id() {
		return (EReference)propertyInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getpropertyParameterList() {
		return propertyParameterListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getpropertyParameterList_IdList() {
		return (EReference)propertyParameterListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getpropertyParameterList_TypeRef() {
		return (EReference)propertyParameterListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getpropertySpecifiers() {
		return propertySpecifiersEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getpropertySpecifiers_Index() {
		return (EReference)propertySpecifiersEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getpropertySpecifiers_ReadId() {
		return (EReference)propertySpecifiersEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getpropertySpecifiers_WriteId() {
		return (EReference)propertySpecifiersEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getpropertySpecifiers_StoreId() {
		return (EReference)propertySpecifiersEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getpropertySpecifiers_StoreExp() {
		return (EReference)propertySpecifiersEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getpropertySpecifiers_DefaulExp() {
		return (EReference)propertySpecifiersEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getpropertySpecifiers_Implement() {
		return (EReference)propertySpecifiersEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getinterfaceType() {
		return interfaceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getinterfaceType_Heritage() {
		return (EReference)interfaceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getinterfaceType_MethodList() {
		return (EReference)interfaceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getinterfaceType_PropList() {
		return (EReference)interfaceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getinterfaceHeritage() {
		return interfaceHeritageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getinterfaceHeritage_IdList() {
		return (EReference)interfaceHeritageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getrequiresClause() {
		return requiresClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getrequiresClause_IdList() {
		return (EReference)requiresClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getcontainsClause() {
		return containsClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getcontainsClause_IdList() {
		return (EReference)containsClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getidentList() {
		return identListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getidentList_Type() {
		return (EReference)identListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getidentList_Ids() {
		return (EReference)identListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getqualId() {
		return qualIdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getqualId_UnitId() {
		return (EReference)qualIdEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getqualId_Id() {
		return (EReference)qualIdEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass gettypeId() {
		return typeIdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference gettypeId_UnitId() {
		return (EReference)typeIdEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference gettypeId_Id() {
		return (EReference)typeIdEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getident() {
		return identEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getreservedWord() {
		return reservedWordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getreservedWord_Id() {
		return (EAttribute)reservedWordEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getconstExpr() {
		return constExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getrecordConstExpr() {
		return recordConstExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getrecordConstExpr_Id() {
		return (EReference)recordConstExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getrecordConstExpr_ConstExp() {
		return (EReference)recordConstExprEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getunitId() {
		return unitIdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getunitId_Id() {
		return (EAttribute)unitIdEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getrelExp() {
		return relExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getrelExp_Left() {
		return (EReference)relExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getrelExp_RelOp() {
		return (EReference)relExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getrelExp_Right() {
		return (EReference)relExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getaddExp() {
		return addExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getaddExp_Left() {
		return (EReference)addExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getaddExp_AddOp() {
		return (EReference)addExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getaddExp_Right() {
		return (EReference)addExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getmultExp() {
		return multExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getmultExp_Left() {
		return (EReference)multExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getmultExp_MultOp() {
		return (EReference)multExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getmultExp_Right() {
		return (EReference)multExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getsimpleFactor() {
		return simpleFactorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getassignmentStmnt() {
		return assignmentStmntEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getassignmentStmnt_Designator() {
		return (EReference)assignmentStmntEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getassignmentStmnt_Operator() {
		return (EAttribute)assignmentStmntEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getassignmentStmnt_Exp() {
		return (EReference)assignmentStmntEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getcallStmnt() {
		return callStmntEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getcallStmnt_Designator() {
		return (EReference)callStmntEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getcallStmnt_Args() {
		return (EReference)callStmntEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getinheritedStamnt() {
		return inheritedStamntEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getgotoStmnt() {
		return gotoStmntEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getgotoStmnt_Label() {
		return (EAttribute)gotoStmntEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getparameterList() {
		return parameterListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getparameterList_IdList() {
		return (EReference)parameterListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getparameterSimple() {
		return parameterSimpleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getparameterSimple_If() {
		return (EReference)parameterSimpleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getparameterSimple_InitExp() {
		return (EReference)parameterSimpleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultipleId() {
		return multipleIdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultipleId_Id() {
		return (EAttribute)multipleIdEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReservedId() {
		return reservedIdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReservedId_ReservedWord() {
		return (EReference)reservedIdEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMineID() {
		return mineIDEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMineID_First() {
		return (EAttribute)mineIDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMineID_Second() {
		return (EAttribute)mineIDEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstExp() {
		return constExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstExp_Exp() {
		return (EReference)constExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultipleConstExp() {
		return multipleConstExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultipleConstExp_Exps() {
		return (EReference)multipleConstExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecordConstExp() {
		return recordConstExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecordConstExp_Exps() {
		return (EReference)recordConstExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCSTrace() {
		return csTraceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCSTrace_Ast() {
		return (EReference)csTraceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DelphiFactory getDelphiFactory() {
		return (DelphiFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		mainRuleEClass = createEClass(MAIN_RULE);
		createEReference(mainRuleEClass, MAIN_RULE__FILE);

		fileEClass = createEClass(FILE);
		createEReference(fileEClass, FILE__ID);

		programEClass = createEClass(PROGRAM);
		createEReference(programEClass, PROGRAM__PARAMS_LIST);
		createEReference(programEClass, PROGRAM__BLOCK);

		unitEClass = createEClass(UNIT);
		createEAttribute(unitEClass, UNIT__PORT);
		createEReference(unitEClass, UNIT__INTERFACE_SECT);
		createEReference(unitEClass, UNIT__IMPLEMENTATION_SECT);
		createEReference(unitEClass, UNIT__INIT_SECT);

		packageDeclEClass = createEClass(PACKAGE_DECL);
		createEReference(packageDeclEClass, PACKAGE_DECL__REQUIRES);
		createEReference(packageDeclEClass, PACKAGE_DECL__CONTAINS);

		libraryEClass = createEClass(LIBRARY);
		createEReference(libraryEClass, LIBRARY__PBLOCK);

		programBlockEClass = createEClass(PROGRAM_BLOCK);
		createEReference(programBlockEClass, PROGRAM_BLOCK__USES);
		createEReference(programBlockEClass, PROGRAM_BLOCK__BLOCK);

		usesClauseEClass = createEClass(USES_CLAUSE);
		createEReference(usesClauseEClass, USES_CLAUSE__ID_LIST);

		interfaceSectionEClass = createEClass(INTERFACE_SECTION);
		createEReference(interfaceSectionEClass, INTERFACE_SECTION__USES);
		createEReference(interfaceSectionEClass, INTERFACE_SECTION__INTERFACE_DECL);

		interfaceDeclEClass = createEClass(INTERFACE_DECL);

		exportedHeadingEClass = createEClass(EXPORTED_HEADING);
		createEReference(exportedHeadingEClass, EXPORTED_HEADING__PHEADING);
		createEReference(exportedHeadingEClass, EXPORTED_HEADING__DIRECTIVE);
		createEReference(exportedHeadingEClass, EXPORTED_HEADING__FHEADING);

		implementationSectionEClass = createEClass(IMPLEMENTATION_SECTION);
		createEReference(implementationSectionEClass, IMPLEMENTATION_SECTION__USES);
		createEReference(implementationSectionEClass, IMPLEMENTATION_SECTION__DECL_SECT);
		createEReference(implementationSectionEClass, IMPLEMENTATION_SECTION__EXPORTS);

		blockEClass = createEClass(BLOCK);
		createEReference(blockEClass, BLOCK__DECL_SECT);
		createEReference(blockEClass, BLOCK__EXPORTS);
		createEReference(blockEClass, BLOCK__COMPOUND);

		exportsItemEClass = createEClass(EXPORTS_ITEM);
		createEReference(exportsItemEClass, EXPORTS_ITEM__ID);
		createEReference(exportsItemEClass, EXPORTS_ITEM__CONST_EXP);

		exportsStmtEClass = createEClass(EXPORTS_STMT);
		createEReference(exportsStmtEClass, EXPORTS_STMT__ITEMS);

		declSectionEClass = createEClass(DECL_SECTION);

		labelDeclSectionEClass = createEClass(LABEL_DECL_SECTION);
		createEAttribute(labelDeclSectionEClass, LABEL_DECL_SECTION__ID);

		constSectionEClass = createEClass(CONST_SECTION);
		createEReference(constSectionEClass, CONST_SECTION__CONSTANT_DECL);

		constantDeclEClass = createEClass(CONSTANT_DECL);
		createEReference(constantDeclEClass, CONSTANT_DECL__ID);
		createEReference(constantDeclEClass, CONSTANT_DECL__CONST);
		createEAttribute(constantDeclEClass, CONSTANT_DECL__PORT);
		createEReference(constantDeclEClass, CONSTANT_DECL__TYPE_REF);
		createEReference(constantDeclEClass, CONSTANT_DECL__TYPED_CONSTAT);

		typeSectionEClass = createEClass(TYPE_SECTION);
		createEReference(typeSectionEClass, TYPE_SECTION__TYPE_DECL);

		typeDeclEClass = createEClass(TYPE_DECL);
		createEReference(typeDeclEClass, TYPE_DECL__ID);
		createEReference(typeDeclEClass, TYPE_DECL__TYPE);
		createEAttribute(typeDeclEClass, TYPE_DECL__PORT);
		createEReference(typeDeclEClass, TYPE_DECL__RESTRICTED_TYPE);

		typedConstantEClass = createEClass(TYPED_CONSTANT);
		createEReference(typedConstantEClass, TYPED_CONSTANT__CONST);
		createEReference(typedConstantEClass, TYPED_CONSTANT__ARRAY);
		createEReference(typedConstantEClass, TYPED_CONSTANT__RECORD);

		arrayConstantEClass = createEClass(ARRAY_CONSTANT);
		createEReference(arrayConstantEClass, ARRAY_CONSTANT__TYPED_CONSTANT);

		recordConstantEClass = createEClass(RECORD_CONSTANT);
		createEReference(recordConstantEClass, RECORD_CONSTANT__RECORD_FIELD);

		recordFieldConstantEClass = createEClass(RECORD_FIELD_CONSTANT);
		createEReference(recordFieldConstantEClass, RECORD_FIELD_CONSTANT__ID);
		createEReference(recordFieldConstantEClass, RECORD_FIELD_CONSTANT__TYPED_CONSTANT);

		typeEClass = createEClass(TYPE);

		restrictedTypeEClass = createEClass(RESTRICTED_TYPE);

		classRefTypeEClass = createEClass(CLASS_REF_TYPE);
		createEReference(classRefTypeEClass, CLASS_REF_TYPE__TYPE_REF);

		simpleTypeEClass = createEClass(SIMPLE_TYPE);

		realTypeEClass = createEClass(REAL_TYPE);

		ordinalTypeEClass = createEClass(ORDINAL_TYPE);

		ordIdentEClass = createEClass(ORD_IDENT);

		variantTypeEClass = createEClass(VARIANT_TYPE);

		subrangeTypeEClass = createEClass(SUBRANGE_TYPE);
		createEReference(subrangeTypeEClass, SUBRANGE_TYPE__FIRST);
		createEReference(subrangeTypeEClass, SUBRANGE_TYPE__LAST);

		enumeratedTypeEClass = createEClass(ENUMERATED_TYPE);
		createEReference(enumeratedTypeEClass, ENUMERATED_TYPE__ELEMENT);

		enumeratedTypeElementEClass = createEClass(ENUMERATED_TYPE_ELEMENT);
		createEReference(enumeratedTypeElementEClass, ENUMERATED_TYPE_ELEMENT__ID);
		createEReference(enumeratedTypeElementEClass, ENUMERATED_TYPE_ELEMENT__LITERAL_EXP);

		stringTypeEClass = createEClass(STRING_TYPE);
		createEReference(stringTypeEClass, STRING_TYPE__CONST_EXP);

		strucTypeEClass = createEClass(STRUC_TYPE);
		createEAttribute(strucTypeEClass, STRUC_TYPE__PORT);

		arrayTypeEClass = createEClass(ARRAY_TYPE);
		createEReference(arrayTypeEClass, ARRAY_TYPE__ORDINAL_TYPE);
		createEReference(arrayTypeEClass, ARRAY_TYPE__ORDINAL_TYP);
		createEReference(arrayTypeEClass, ARRAY_TYPE__TYPE);

		recTypeEClass = createEClass(REC_TYPE);
		createEReference(recTypeEClass, REC_TYPE__FIELDS);

		fieldListEClass = createEClass(FIELD_LIST);
		createEReference(fieldListEClass, FIELD_LIST__FIELD);
		createEReference(fieldListEClass, FIELD_LIST__VARIANT_SECT);

		fieldDeclEClass = createEClass(FIELD_DECL);
		createEReference(fieldDeclEClass, FIELD_DECL__ID_LIST);
		createEReference(fieldDeclEClass, FIELD_DECL__TYPE);
		createEAttribute(fieldDeclEClass, FIELD_DECL__PORT);

		variantSectionEClass = createEClass(VARIANT_SECTION);
		createEReference(variantSectionEClass, VARIANT_SECTION__ID);
		createEReference(variantSectionEClass, VARIANT_SECTION__TYPE_REF);
		createEReference(variantSectionEClass, VARIANT_SECTION__REC_VARIANTS);

		recVariantEClass = createEClass(REC_VARIANT);
		createEReference(recVariantEClass, REC_VARIANT__CONST_EXP);
		createEReference(recVariantEClass, REC_VARIANT__FIELD_LIST);

		setTypeEClass = createEClass(SET_TYPE);
		createEReference(setTypeEClass, SET_TYPE__ORDINAL);

		fileTypeEClass = createEClass(FILE_TYPE);
		createEReference(fileTypeEClass, FILE_TYPE__TYPE_REF);

		pointerTypeEClass = createEClass(POINTER_TYPE);

		procedureTypeEClass = createEClass(PROCEDURE_TYPE);
		createEReference(procedureTypeEClass, PROCEDURE_TYPE__PHEADING);
		createEReference(procedureTypeEClass, PROCEDURE_TYPE__FHEADING);

		varSectionEClass = createEClass(VAR_SECTION);
		createEReference(varSectionEClass, VAR_SECTION__VAR_DECLS);

		varDeclEClass = createEClass(VAR_DECL);
		createEReference(varDeclEClass, VAR_DECL__ID_LIST);
		createEReference(varDeclEClass, VAR_DECL__TYPE);
		createEReference(varDeclEClass, VAR_DECL__ABS_ID);
		createEReference(varDeclEClass, VAR_DECL__ABS_CONST);
		createEReference(varDeclEClass, VAR_DECL__ABS_INITI);

		expressionEClass = createEClass(EXPRESSION);

		simpleExpressionEClass = createEClass(SIMPLE_EXPRESSION);

		termEClass = createEClass(TERM);

		factorEClass = createEClass(FACTOR);
		createEReference(factorEClass, FACTOR__DESIGNATOR);
		createEReference(factorEClass, FACTOR__EXP_LIST);
		createEAttribute(factorEClass, FACTOR__NUMBER);
		createEAttribute(factorEClass, FACTOR__STRING);
		createEReference(factorEClass, FACTOR__NESTED_EXP);
		createEReference(factorEClass, FACTOR__EXP);
		createEReference(factorEClass, FACTOR__SET_CONSTUCTOR);
		createEReference(factorEClass, FACTOR__TYPE_REF);

		relOpEClass = createEClass(REL_OP);
		createEAttribute(relOpEClass, REL_OP__OP);

		addOpEClass = createEClass(ADD_OP);
		createEAttribute(addOpEClass, ADD_OP__OP);

		mulOpEClass = createEClass(MUL_OP);
		createEAttribute(mulOpEClass, MUL_OP__OP);

		designatorEClass = createEClass(DESIGNATOR);
		createEReference(designatorEClass, DESIGNATOR__SUBPART);
		createEReference(designatorEClass, DESIGNATOR__DESIGNATOR);

		designatorSubPartEClass = createEClass(DESIGNATOR_SUB_PART);
		createEReference(designatorSubPartEClass, DESIGNATOR_SUB_PART__PART);
		createEReference(designatorSubPartEClass, DESIGNATOR_SUB_PART__EXPR_LIST);

		designatorPartEClass = createEClass(DESIGNATOR_PART);
		createEAttribute(designatorPartEClass, DESIGNATOR_PART__ID);
		createEReference(designatorPartEClass, DESIGNATOR_PART__RESERVED_WORD);
		createEAttribute(designatorPartEClass, DESIGNATOR_PART__ID2);

		setConstructorEClass = createEClass(SET_CONSTRUCTOR);
		createEReference(setConstructorEClass, SET_CONSTRUCTOR__ELEMENT);

		setElementEClass = createEClass(SET_ELEMENT);
		createEReference(setElementEClass, SET_ELEMENT__FIRST);
		createEReference(setElementEClass, SET_ELEMENT__LAST);

		exprListEClass = createEClass(EXPR_LIST);
		createEReference(exprListEClass, EXPR_LIST__EXPS);

		stmtListEClass = createEClass(STMT_LIST);
		createEReference(stmtListEClass, STMT_LIST__STATMENTS);

		statementEClass = createEClass(STATEMENT);
		createEAttribute(statementEClass, STATEMENT__LABEL_ID);
		createEReference(statementEClass, STATEMENT__STATEMENT);

		unlabelledStatementEClass = createEClass(UNLABELLED_STATEMENT);

		simpleStatementEClass = createEClass(SIMPLE_STATEMENT);

		structStmtEClass = createEClass(STRUCT_STMT);

		compoundStmtEClass = createEClass(COMPOUND_STMT);
		createEReference(compoundStmtEClass, COMPOUND_STMT__STAMT_LIST);

		conditionalStmtEClass = createEClass(CONDITIONAL_STMT);

		ifStmtEClass = createEClass(IF_STMT);
		createEReference(ifStmtEClass, IF_STMT__CONDITION);
		createEReference(ifStmtEClass, IF_STMT__THEN);
		createEReference(ifStmtEClass, IF_STMT__ELSE);

		caseStmtEClass = createEClass(CASE_STMT);
		createEReference(caseStmtEClass, CASE_STMT__EXPRESSION);
		createEReference(caseStmtEClass, CASE_STMT__CASES);
		createEReference(caseStmtEClass, CASE_STMT__DEFAULT);

		caseSelectorEClass = createEClass(CASE_SELECTOR);
		createEReference(caseSelectorEClass, CASE_SELECTOR__LABELS);
		createEReference(caseSelectorEClass, CASE_SELECTOR__STMT);

		caseLabelEClass = createEClass(CASE_LABEL);
		createEReference(caseLabelEClass, CASE_LABEL__FIRST);
		createEReference(caseLabelEClass, CASE_LABEL__LAST);

		loopStmtEClass = createEClass(LOOP_STMT);
		createEReference(loopStmtEClass, LOOP_STMT__STMT);
		createEReference(loopStmtEClass, LOOP_STMT__CONDITION);

		repeatStmtEClass = createEClass(REPEAT_STMT);

		whileStmtEClass = createEClass(WHILE_STMT);

		forStmtEClass = createEClass(FOR_STMT);
		createEReference(forStmtEClass, FOR_STMT__VAR_ID);
		createEReference(forStmtEClass, FOR_STMT__VAR_INIT);

		withStmtEClass = createEClass(WITH_STMT);
		createEReference(withStmtEClass, WITH_STMT__VARS);
		createEReference(withStmtEClass, WITH_STMT__STMT);

		tryStmtEClass = createEClass(TRY_STMT);
		createEReference(tryStmtEClass, TRY_STMT__STMT_LIST);
		createEReference(tryStmtEClass, TRY_STMT__EXCEPTION);
		createEReference(tryStmtEClass, TRY_STMT__FINAL);

		exceptionBlockEClass = createEClass(EXCEPTION_BLOCK);
		createEReference(exceptionBlockEClass, EXCEPTION_BLOCK__EXCEPTION_ID);
		createEReference(exceptionBlockEClass, EXCEPTION_BLOCK__TYPE);
		createEReference(exceptionBlockEClass, EXCEPTION_BLOCK__DO_STMT);
		createEReference(exceptionBlockEClass, EXCEPTION_BLOCK__ELSE_STMTS);

		raiseStmtEClass = createEClass(RAISE_STMT);
		createEAttribute(raiseStmtEClass, RAISE_STMT__RAISE);
		createEAttribute(raiseStmtEClass, RAISE_STMT__AT);

		assemblerStmtEClass = createEClass(ASSEMBLER_STMT);

		procedureDeclSectionEClass = createEClass(PROCEDURE_DECL_SECTION);
		createEReference(procedureDeclSectionEClass, PROCEDURE_DECL_SECTION__DIRECTIVE);
		createEAttribute(procedureDeclSectionEClass, PROCEDURE_DECL_SECTION__PORT);
		createEReference(procedureDeclSectionEClass, PROCEDURE_DECL_SECTION__BLOCK);

		procedureDeclEClass = createEClass(PROCEDURE_DECL);
		createEReference(procedureDeclEClass, PROCEDURE_DECL__HEADING);

		functionDeclEClass = createEClass(FUNCTION_DECL);
		createEReference(functionDeclEClass, FUNCTION_DECL__HEADING);

		functionHeadingEClass = createEClass(FUNCTION_HEADING);
		createEReference(functionHeadingEClass, FUNCTION_HEADING__TYPE);

		procedureHeadingEClass = createEClass(PROCEDURE_HEADING);

		formalParametersEClass = createEClass(FORMAL_PARAMETERS);
		createEReference(formalParametersEClass, FORMAL_PARAMETERS__PARAMS);

		formalParmEClass = createEClass(FORMAL_PARM);
		createEReference(formalParmEClass, FORMAL_PARM__PARAM);

		parameterEClass = createEClass(PARAMETER);
		createEReference(parameterEClass, PARAMETER__TYPE);

		directiveEClass = createEClass(DIRECTIVE);
		createEAttribute(directiveEClass, DIRECTIVE__DIR);
		createEReference(directiveEClass, DIRECTIVE__MESSAGE_EXP);

		objectTypeEClass = createEClass(OBJECT_TYPE);
		createEReference(objectTypeEClass, OBJECT_TYPE__HERITAGE);
		createEReference(objectTypeEClass, OBJECT_TYPE__FIELD_LIST);
		createEReference(objectTypeEClass, OBJECT_TYPE__METHOD_LIST);

		objHeritageEClass = createEClass(OBJ_HERITAGE);
		createEReference(objHeritageEClass, OBJ_HERITAGE__ID);

		methodListEClass = createEClass(METHOD_LIST);
		createEReference(methodListEClass, METHOD_LIST__HEADING);
		createEReference(methodListEClass, METHOD_LIST__DIRECTIVE);

		methodHeadingEClass = createEClass(METHOD_HEADING);
		createEReference(methodHeadingEClass, METHOD_HEADING__ID);
		createEReference(methodHeadingEClass, METHOD_HEADING__FORMAL_PARAMS);

		constructorHeadingEClass = createEClass(CONSTRUCTOR_HEADING);

		destructorHeadingEClass = createEClass(DESTRUCTOR_HEADING);

		objFieldListEClass = createEClass(OBJ_FIELD_LIST);

		initSectionEClass = createEClass(INIT_SECTION);
		createEReference(initSectionEClass, INIT_SECTION__STMT_LIST);
		createEReference(initSectionEClass, INIT_SECTION__END_STMT_LIST);

		classTypeEClass = createEClass(CLASS_TYPE);
		createEReference(classTypeEClass, CLASS_TYPE__HERITAGE);
		createEAttribute(classTypeEClass, CLASS_TYPE__VISIBILITY);
		createEReference(classTypeEClass, CLASS_TYPE__FIELD_LIST);
		createEReference(classTypeEClass, CLASS_TYPE__METHOD_LIST);
		createEReference(classTypeEClass, CLASS_TYPE__PROP_LIST);

		classHeritageEClass = createEClass(CLASS_HERITAGE);

		classFieldListEClass = createEClass(CLASS_FIELD_LIST);
		createEReference(classFieldListEClass, CLASS_FIELD_LIST__FIELD);

		classFieldEClass = createEClass(CLASS_FIELD);
		createEAttribute(classFieldEClass, CLASS_FIELD__VISIBILITY);
		createEReference(classFieldEClass, CLASS_FIELD__FIELD_LIST);

		classMethodListEClass = createEClass(CLASS_METHOD_LIST);
		createEReference(classMethodListEClass, CLASS_METHOD_LIST__METOD);

		classMethodEClass = createEClass(CLASS_METHOD);
		createEAttribute(classMethodEClass, CLASS_METHOD__VISIBILITY);
		createEReference(classMethodEClass, CLASS_METHOD__METHOD_LIST);

		classPropertyListEClass = createEClass(CLASS_PROPERTY_LIST);
		createEReference(classPropertyListEClass, CLASS_PROPERTY_LIST__PROPERTY);

		classPropertyEClass = createEClass(CLASS_PROPERTY);
		createEAttribute(classPropertyEClass, CLASS_PROPERTY__VISIBILITY);
		createEReference(classPropertyEClass, CLASS_PROPERTY__PROP_LIST);

		propertyListEClass = createEClass(PROPERTY_LIST);
		createEReference(propertyListEClass, PROPERTY_LIST__ID);
		createEReference(propertyListEClass, PROPERTY_LIST__INTERFACE);
		createEReference(propertyListEClass, PROPERTY_LIST__SPECIFIERS);
		createEAttribute(propertyListEClass, PROPERTY_LIST__PORT);

		propertyInterfaceEClass = createEClass(PROPERTY_INTERFACE);
		createEReference(propertyInterfaceEClass, PROPERTY_INTERFACE__PARAM_LIST);
		createEReference(propertyInterfaceEClass, PROPERTY_INTERFACE__ID);

		propertyParameterListEClass = createEClass(PROPERTY_PARAMETER_LIST);
		createEReference(propertyParameterListEClass, PROPERTY_PARAMETER_LIST__ID_LIST);
		createEReference(propertyParameterListEClass, PROPERTY_PARAMETER_LIST__TYPE_REF);

		propertySpecifiersEClass = createEClass(PROPERTY_SPECIFIERS);
		createEReference(propertySpecifiersEClass, PROPERTY_SPECIFIERS__INDEX);
		createEReference(propertySpecifiersEClass, PROPERTY_SPECIFIERS__READ_ID);
		createEReference(propertySpecifiersEClass, PROPERTY_SPECIFIERS__WRITE_ID);
		createEReference(propertySpecifiersEClass, PROPERTY_SPECIFIERS__STORE_ID);
		createEReference(propertySpecifiersEClass, PROPERTY_SPECIFIERS__STORE_EXP);
		createEReference(propertySpecifiersEClass, PROPERTY_SPECIFIERS__DEFAUL_EXP);
		createEReference(propertySpecifiersEClass, PROPERTY_SPECIFIERS__IMPLEMENT);

		interfaceTypeEClass = createEClass(INTERFACE_TYPE);
		createEReference(interfaceTypeEClass, INTERFACE_TYPE__HERITAGE);
		createEReference(interfaceTypeEClass, INTERFACE_TYPE__METHOD_LIST);
		createEReference(interfaceTypeEClass, INTERFACE_TYPE__PROP_LIST);

		interfaceHeritageEClass = createEClass(INTERFACE_HERITAGE);
		createEReference(interfaceHeritageEClass, INTERFACE_HERITAGE__ID_LIST);

		requiresClauseEClass = createEClass(REQUIRES_CLAUSE);
		createEReference(requiresClauseEClass, REQUIRES_CLAUSE__ID_LIST);

		containsClauseEClass = createEClass(CONTAINS_CLAUSE);
		createEReference(containsClauseEClass, CONTAINS_CLAUSE__ID_LIST);

		identListEClass = createEClass(IDENT_LIST);
		createEReference(identListEClass, IDENT_LIST__TYPE);
		createEReference(identListEClass, IDENT_LIST__IDS);

		qualIdEClass = createEClass(QUAL_ID);
		createEReference(qualIdEClass, QUAL_ID__UNIT_ID);
		createEReference(qualIdEClass, QUAL_ID__ID);

		typeIdEClass = createEClass(TYPE_ID);
		createEReference(typeIdEClass, TYPE_ID__UNIT_ID);
		createEReference(typeIdEClass, TYPE_ID__ID);

		identEClass = createEClass(IDENT);

		reservedWordEClass = createEClass(RESERVED_WORD);
		createEAttribute(reservedWordEClass, RESERVED_WORD__ID);

		constExprEClass = createEClass(CONST_EXPR);

		recordConstExprEClass = createEClass(RECORD_CONST_EXPR);
		createEReference(recordConstExprEClass, RECORD_CONST_EXPR__ID);
		createEReference(recordConstExprEClass, RECORD_CONST_EXPR__CONST_EXP);

		unitIdEClass = createEClass(UNIT_ID);
		createEAttribute(unitIdEClass, UNIT_ID__ID);

		relExpEClass = createEClass(REL_EXP);
		createEReference(relExpEClass, REL_EXP__LEFT);
		createEReference(relExpEClass, REL_EXP__REL_OP);
		createEReference(relExpEClass, REL_EXP__RIGHT);

		addExpEClass = createEClass(ADD_EXP);
		createEReference(addExpEClass, ADD_EXP__LEFT);
		createEReference(addExpEClass, ADD_EXP__ADD_OP);
		createEReference(addExpEClass, ADD_EXP__RIGHT);

		multExpEClass = createEClass(MULT_EXP);
		createEReference(multExpEClass, MULT_EXP__LEFT);
		createEReference(multExpEClass, MULT_EXP__MULT_OP);
		createEReference(multExpEClass, MULT_EXP__RIGHT);

		simpleFactorEClass = createEClass(SIMPLE_FACTOR);

		assignmentStmntEClass = createEClass(ASSIGNMENT_STMNT);
		createEReference(assignmentStmntEClass, ASSIGNMENT_STMNT__DESIGNATOR);
		createEAttribute(assignmentStmntEClass, ASSIGNMENT_STMNT__OPERATOR);
		createEReference(assignmentStmntEClass, ASSIGNMENT_STMNT__EXP);

		callStmntEClass = createEClass(CALL_STMNT);
		createEReference(callStmntEClass, CALL_STMNT__DESIGNATOR);
		createEReference(callStmntEClass, CALL_STMNT__ARGS);

		inheritedStamntEClass = createEClass(INHERITED_STAMNT);

		gotoStmntEClass = createEClass(GOTO_STMNT);
		createEAttribute(gotoStmntEClass, GOTO_STMNT__LABEL);

		parameterListEClass = createEClass(PARAMETER_LIST);
		createEReference(parameterListEClass, PARAMETER_LIST__ID_LIST);

		parameterSimpleEClass = createEClass(PARAMETER_SIMPLE);
		createEReference(parameterSimpleEClass, PARAMETER_SIMPLE__IF);
		createEReference(parameterSimpleEClass, PARAMETER_SIMPLE__INIT_EXP);

		multipleIdEClass = createEClass(MULTIPLE_ID);
		createEAttribute(multipleIdEClass, MULTIPLE_ID__ID);

		reservedIdEClass = createEClass(RESERVED_ID);
		createEReference(reservedIdEClass, RESERVED_ID__RESERVED_WORD);

		mineIDEClass = createEClass(MINE_ID);
		createEAttribute(mineIDEClass, MINE_ID__FIRST);
		createEAttribute(mineIDEClass, MINE_ID__SECOND);

		constExpEClass = createEClass(CONST_EXP);
		createEReference(constExpEClass, CONST_EXP__EXP);

		multipleConstExpEClass = createEClass(MULTIPLE_CONST_EXP);
		createEReference(multipleConstExpEClass, MULTIPLE_CONST_EXP__EXPS);

		recordConstExpEClass = createEClass(RECORD_CONST_EXP);
		createEReference(recordConstExpEClass, RECORD_CONST_EXP__EXPS);

		csTraceEClass = createEClass(CS_TRACE);
		createEReference(csTraceEClass, CS_TRACE__AST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		AstmPackage theAstmPackage = (AstmPackage)EPackage.Registry.INSTANCE.getEPackage(AstmPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		mainRuleEClass.getESuperTypes().add(this.getCSTrace());
		fileEClass.getESuperTypes().add(this.getCSTrace());
		programEClass.getESuperTypes().add(this.getfile());
		unitEClass.getESuperTypes().add(this.getfile());
		packageDeclEClass.getESuperTypes().add(this.getfile());
		libraryEClass.getESuperTypes().add(this.getfile());
		programBlockEClass.getESuperTypes().add(this.getCSTrace());
		usesClauseEClass.getESuperTypes().add(this.getCSTrace());
		interfaceSectionEClass.getESuperTypes().add(this.getCSTrace());
		interfaceDeclEClass.getESuperTypes().add(this.getCSTrace());
		exportedHeadingEClass.getESuperTypes().add(this.getinterfaceDecl());
		implementationSectionEClass.getESuperTypes().add(this.getCSTrace());
		blockEClass.getESuperTypes().add(this.getCSTrace());
		exportsItemEClass.getESuperTypes().add(this.getCSTrace());
		exportsStmtEClass.getESuperTypes().add(this.getCSTrace());
		declSectionEClass.getESuperTypes().add(this.getCSTrace());
		labelDeclSectionEClass.getESuperTypes().add(this.getdeclSection());
		constSectionEClass.getESuperTypes().add(this.getinterfaceDecl());
		constSectionEClass.getESuperTypes().add(this.getdeclSection());
		constantDeclEClass.getESuperTypes().add(this.getCSTrace());
		typeSectionEClass.getESuperTypes().add(this.getinterfaceDecl());
		typeSectionEClass.getESuperTypes().add(this.getdeclSection());
		typeDeclEClass.getESuperTypes().add(this.getCSTrace());
		typedConstantEClass.getESuperTypes().add(this.getCSTrace());
		arrayConstantEClass.getESuperTypes().add(this.getCSTrace());
		recordConstantEClass.getESuperTypes().add(this.getCSTrace());
		recordFieldConstantEClass.getESuperTypes().add(this.getCSTrace());
		typeEClass.getESuperTypes().add(this.getCSTrace());
		restrictedTypeEClass.getESuperTypes().add(this.getCSTrace());
		classRefTypeEClass.getESuperTypes().add(this.gettype());
		simpleTypeEClass.getESuperTypes().add(this.gettype());
		realTypeEClass.getESuperTypes().add(this.getsimpleType());
		ordinalTypeEClass.getESuperTypes().add(this.getsimpleType());
		ordIdentEClass.getESuperTypes().add(this.getordinalType());
		variantTypeEClass.getESuperTypes().add(this.gettype());
		subrangeTypeEClass.getESuperTypes().add(this.getordinalType());
		enumeratedTypeEClass.getESuperTypes().add(this.getordinalType());
		enumeratedTypeElementEClass.getESuperTypes().add(this.getCSTrace());
		stringTypeEClass.getESuperTypes().add(this.gettype());
		strucTypeEClass.getESuperTypes().add(this.gettype());
		arrayTypeEClass.getESuperTypes().add(this.getstrucType());
		recTypeEClass.getESuperTypes().add(this.getstrucType());
		fieldListEClass.getESuperTypes().add(this.getCSTrace());
		fieldDeclEClass.getESuperTypes().add(this.getCSTrace());
		variantSectionEClass.getESuperTypes().add(this.getCSTrace());
		recVariantEClass.getESuperTypes().add(this.getCSTrace());
		setTypeEClass.getESuperTypes().add(this.getstrucType());
		fileTypeEClass.getESuperTypes().add(this.getstrucType());
		pointerTypeEClass.getESuperTypes().add(this.gettype());
		procedureTypeEClass.getESuperTypes().add(this.gettype());
		varSectionEClass.getESuperTypes().add(this.getinterfaceDecl());
		varSectionEClass.getESuperTypes().add(this.getdeclSection());
		varDeclEClass.getESuperTypes().add(this.getCSTrace());
		expressionEClass.getESuperTypes().add(this.getCSTrace());
		simpleExpressionEClass.getESuperTypes().add(this.getexpression());
		termEClass.getESuperTypes().add(this.getsimpleExpression());
		factorEClass.getESuperTypes().add(this.getterm());
		relOpEClass.getESuperTypes().add(this.getCSTrace());
		addOpEClass.getESuperTypes().add(this.getCSTrace());
		mulOpEClass.getESuperTypes().add(this.getCSTrace());
		designatorEClass.getESuperTypes().add(this.getCSTrace());
		designatorSubPartEClass.getESuperTypes().add(this.getCSTrace());
		designatorPartEClass.getESuperTypes().add(this.getCSTrace());
		setConstructorEClass.getESuperTypes().add(this.getCSTrace());
		setElementEClass.getESuperTypes().add(this.getCSTrace());
		exprListEClass.getESuperTypes().add(this.getCSTrace());
		stmtListEClass.getESuperTypes().add(this.getCSTrace());
		statementEClass.getESuperTypes().add(this.getCSTrace());
		unlabelledStatementEClass.getESuperTypes().add(this.getCSTrace());
		simpleStatementEClass.getESuperTypes().add(this.getunlabelledStatement());
		structStmtEClass.getESuperTypes().add(this.getunlabelledStatement());
		compoundStmtEClass.getESuperTypes().add(this.getstructStmt());
		conditionalStmtEClass.getESuperTypes().add(this.getstructStmt());
		ifStmtEClass.getESuperTypes().add(this.getconditionalStmt());
		caseStmtEClass.getESuperTypes().add(this.getconditionalStmt());
		caseSelectorEClass.getESuperTypes().add(this.getCSTrace());
		caseLabelEClass.getESuperTypes().add(this.getCSTrace());
		loopStmtEClass.getESuperTypes().add(this.getstructStmt());
		repeatStmtEClass.getESuperTypes().add(this.getloopStmt());
		whileStmtEClass.getESuperTypes().add(this.getloopStmt());
		forStmtEClass.getESuperTypes().add(this.getloopStmt());
		withStmtEClass.getESuperTypes().add(this.getstructStmt());
		tryStmtEClass.getESuperTypes().add(this.getstructStmt());
		exceptionBlockEClass.getESuperTypes().add(this.getCSTrace());
		raiseStmtEClass.getESuperTypes().add(this.getstructStmt());
		assemblerStmtEClass.getESuperTypes().add(this.getstructStmt());
		procedureDeclSectionEClass.getESuperTypes().add(this.getdeclSection());
		procedureDeclEClass.getESuperTypes().add(this.getprocedureDeclSection());
		functionDeclEClass.getESuperTypes().add(this.getprocedureDeclSection());
		functionHeadingEClass.getESuperTypes().add(this.getmethodHeading());
		procedureHeadingEClass.getESuperTypes().add(this.getmethodHeading());
		formalParametersEClass.getESuperTypes().add(this.getCSTrace());
		formalParmEClass.getESuperTypes().add(this.getCSTrace());
		parameterEClass.getESuperTypes().add(this.getCSTrace());
		directiveEClass.getESuperTypes().add(this.getCSTrace());
		objectTypeEClass.getESuperTypes().add(this.getrestrictedType());
		objHeritageEClass.getESuperTypes().add(this.getCSTrace());
		methodListEClass.getESuperTypes().add(this.getCSTrace());
		methodHeadingEClass.getESuperTypes().add(this.getCSTrace());
		constructorHeadingEClass.getESuperTypes().add(this.getmethodHeading());
		destructorHeadingEClass.getESuperTypes().add(this.getmethodHeading());
		objFieldListEClass.getESuperTypes().add(this.getCSTrace());
		initSectionEClass.getESuperTypes().add(this.getCSTrace());
		classTypeEClass.getESuperTypes().add(this.getrestrictedType());
		classHeritageEClass.getESuperTypes().add(this.getCSTrace());
		classFieldListEClass.getESuperTypes().add(this.getCSTrace());
		classFieldEClass.getESuperTypes().add(this.getCSTrace());
		classMethodListEClass.getESuperTypes().add(this.getCSTrace());
		classMethodEClass.getESuperTypes().add(this.getCSTrace());
		classPropertyListEClass.getESuperTypes().add(this.getCSTrace());
		classPropertyEClass.getESuperTypes().add(this.getCSTrace());
		propertyListEClass.getESuperTypes().add(this.getCSTrace());
		propertyInterfaceEClass.getESuperTypes().add(this.getCSTrace());
		propertyParameterListEClass.getESuperTypes().add(this.getCSTrace());
		propertySpecifiersEClass.getESuperTypes().add(this.getCSTrace());
		interfaceTypeEClass.getESuperTypes().add(this.getrestrictedType());
		interfaceHeritageEClass.getESuperTypes().add(this.getCSTrace());
		requiresClauseEClass.getESuperTypes().add(this.getCSTrace());
		containsClauseEClass.getESuperTypes().add(this.getCSTrace());
		identListEClass.getESuperTypes().add(this.getobjFieldList());
		identListEClass.getESuperTypes().add(this.getclassHeritage());
		qualIdEClass.getESuperTypes().add(this.getCSTrace());
		typeIdEClass.getESuperTypes().add(this.gettype());
		typeIdEClass.getESuperTypes().add(this.getpointerType());
		identEClass.getESuperTypes().add(this.getCSTrace());
		reservedWordEClass.getESuperTypes().add(this.getCSTrace());
		constExprEClass.getESuperTypes().add(this.getCSTrace());
		recordConstExprEClass.getESuperTypes().add(this.getCSTrace());
		unitIdEClass.getESuperTypes().add(this.getCSTrace());
		relExpEClass.getESuperTypes().add(this.getexpression());
		addExpEClass.getESuperTypes().add(this.getsimpleExpression());
		multExpEClass.getESuperTypes().add(this.getterm());
		simpleFactorEClass.getESuperTypes().add(this.getfactor());
		assignmentStmntEClass.getESuperTypes().add(this.getsimpleStatement());
		callStmntEClass.getESuperTypes().add(this.getsimpleStatement());
		inheritedStamntEClass.getESuperTypes().add(this.getsimpleStatement());
		gotoStmntEClass.getESuperTypes().add(this.getsimpleStatement());
		parameterListEClass.getESuperTypes().add(this.getparameter());
		parameterSimpleEClass.getESuperTypes().add(this.getparameter());
		multipleIdEClass.getESuperTypes().add(this.getident());
		reservedIdEClass.getESuperTypes().add(this.getident());
		mineIDEClass.getESuperTypes().add(this.getident());
		constExpEClass.getESuperTypes().add(this.getconstExpr());
		multipleConstExpEClass.getESuperTypes().add(this.getconstExpr());
		recordConstExpEClass.getESuperTypes().add(this.getconstExpr());

		// Initialize classes and features; add operations and parameters
		initEClass(mainRuleEClass, mainRule.class, "mainRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getmainRule_File(), this.getfile(), null, "file", null, 0, 1, mainRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fileEClass, file.class, "file", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getfile_Id(), this.getident(), null, "id", null, 0, 1, file.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(programEClass, program.class, "program", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getprogram_ParamsList(), this.getidentList(), null, "paramsList", null, 0, 1, program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getprogram_Block(), this.getprogramBlock(), null, "block", null, 0, 1, program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitEClass, unit.class, "unit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getunit_Port(), ecorePackage.getEString(), "port", null, 0, 1, unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getunit_InterfaceSect(), this.getinterfaceSection(), null, "interfaceSect", null, 0, 1, unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getunit_ImplementationSect(), this.getimplementationSection(), null, "implementationSect", null, 0, 1, unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getunit_InitSect(), this.getinitSection(), null, "initSect", null, 0, 1, unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageDeclEClass, packageDecl.class, "packageDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getpackageDecl_Requires(), this.getrequiresClause(), null, "requires", null, 0, 1, packageDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getpackageDecl_Contains(), this.getcontainsClause(), null, "contains", null, 0, 1, packageDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libraryEClass, library.class, "library", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getlibrary_PBlock(), this.getprogramBlock(), null, "pBlock", null, 0, 1, library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(programBlockEClass, programBlock.class, "programBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getprogramBlock_Uses(), this.getusesClause(), null, "uses", null, 0, 1, programBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getprogramBlock_Block(), this.getblock(), null, "block", null, 0, 1, programBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(usesClauseEClass, usesClause.class, "usesClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getusesClause_IdList(), this.getidentList(), null, "idList", null, 0, 1, usesClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceSectionEClass, interfaceSection.class, "interfaceSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getinterfaceSection_Uses(), this.getusesClause(), null, "uses", null, 0, 1, interfaceSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getinterfaceSection_InterfaceDecl(), this.getinterfaceDecl(), null, "interfaceDecl", null, 0, -1, interfaceSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceDeclEClass, interfaceDecl.class, "interfaceDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(exportedHeadingEClass, exportedHeading.class, "exportedHeading", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getexportedHeading_PHeading(), this.getprocedureHeading(), null, "pHeading", null, 0, 1, exportedHeading.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getexportedHeading_Directive(), this.getdirective(), null, "directive", null, 0, 1, exportedHeading.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getexportedHeading_FHeading(), this.getfunctionHeading(), null, "fHeading", null, 0, 1, exportedHeading.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(implementationSectionEClass, implementationSection.class, "implementationSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getimplementationSection_Uses(), this.getusesClause(), null, "uses", null, 0, 1, implementationSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getimplementationSection_DeclSect(), this.getdeclSection(), null, "declSect", null, 0, -1, implementationSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getimplementationSection_Exports(), this.getexportsStmt(), null, "exports", null, 0, -1, implementationSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(blockEClass, block.class, "block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getblock_DeclSect(), this.getdeclSection(), null, "declSect", null, 0, 1, block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getblock_Exports(), this.getexportsStmt(), null, "exports", null, 0, -1, block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getblock_Compound(), this.getcompoundStmt(), null, "compound", null, 0, 1, block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exportsItemEClass, exportsItem.class, "exportsItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getexportsItem_Id(), this.getident(), null, "id", null, 0, 1, exportsItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getexportsItem_ConstExp(), this.getconstExpr(), null, "constExp", null, 0, -1, exportsItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exportsStmtEClass, exportsStmt.class, "exportsStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getexportsStmt_Items(), this.getexportsItem(), null, "items", null, 0, -1, exportsStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(declSectionEClass, declSection.class, "declSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(labelDeclSectionEClass, labelDeclSection.class, "labelDeclSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getlabelDeclSection_Id(), ecorePackage.getEString(), "id", null, 0, 1, labelDeclSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constSectionEClass, constSection.class, "constSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getconstSection_ConstantDecl(), this.getconstantDecl(), null, "constantDecl", null, 0, -1, constSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constantDeclEClass, constantDecl.class, "constantDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getconstantDecl_Id(), this.getident(), null, "id", null, 0, 1, constantDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getconstantDecl_Const(), this.getconstExpr(), null, "const", null, 0, 1, constantDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getconstantDecl_Port(), ecorePackage.getEString(), "port", null, 0, 1, constantDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getconstantDecl_TypeRef(), this.gettypeId(), null, "typeRef", null, 0, 1, constantDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getconstantDecl_TypedConstat(), this.gettypedConstant(), null, "typedConstat", null, 0, 1, constantDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeSectionEClass, typeSection.class, "typeSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(gettypeSection_TypeDecl(), this.gettypeDecl(), null, "typeDecl", null, 0, -1, typeSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeDeclEClass, typeDecl.class, "typeDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(gettypeDecl_Id(), this.getident(), null, "id", null, 0, 1, typeDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(gettypeDecl_Type(), this.gettype(), null, "type", null, 0, 1, typeDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(gettypeDecl_Port(), ecorePackage.getEString(), "port", null, 0, 1, typeDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(gettypeDecl_RestrictedType(), this.getrestrictedType(), null, "restrictedType", null, 0, 1, typeDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typedConstantEClass, typedConstant.class, "typedConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(gettypedConstant_Const(), this.getconstExpr(), null, "const", null, 0, 1, typedConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(gettypedConstant_Array(), this.getarrayConstant(), null, "array", null, 0, 1, typedConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(gettypedConstant_Record(), this.getrecordConstant(), null, "record", null, 0, 1, typedConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayConstantEClass, arrayConstant.class, "arrayConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getarrayConstant_TypedConstant(), this.gettypedConstant(), null, "typedConstant", null, 0, 1, arrayConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recordConstantEClass, recordConstant.class, "recordConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getrecordConstant_RecordField(), this.getrecordFieldConstant(), null, "recordField", null, 0, -1, recordConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recordFieldConstantEClass, recordFieldConstant.class, "recordFieldConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getrecordFieldConstant_Id(), this.getident(), null, "id", null, 0, 1, recordFieldConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getrecordFieldConstant_TypedConstant(), this.gettypedConstant(), null, "typedConstant", null, 0, 1, recordFieldConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeEClass, type.class, "type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(restrictedTypeEClass, restrictedType.class, "restrictedType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classRefTypeEClass, classRefType.class, "classRefType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getclassRefType_TypeRef(), this.gettypeId(), null, "typeRef", null, 0, 1, classRefType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleTypeEClass, simpleType.class, "simpleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(realTypeEClass, realType.class, "realType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ordinalTypeEClass, ordinalType.class, "ordinalType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ordIdentEClass, ordIdent.class, "ordIdent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variantTypeEClass, variantType.class, "variantType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(subrangeTypeEClass, subrangeType.class, "subrangeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getsubrangeType_First(), this.getconstExpr(), null, "first", null, 0, 1, subrangeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getsubrangeType_Last(), this.getconstExpr(), null, "last", null, 0, 1, subrangeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumeratedTypeEClass, enumeratedType.class, "enumeratedType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getenumeratedType_Element(), this.getenumeratedTypeElement(), null, "element", null, 0, -1, enumeratedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumeratedTypeElementEClass, enumeratedTypeElement.class, "enumeratedTypeElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getenumeratedTypeElement_Id(), this.getident(), null, "id", null, 0, 1, enumeratedTypeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getenumeratedTypeElement_LiteralExp(), this.getconstExpr(), null, "literalExp", null, 0, 1, enumeratedTypeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringTypeEClass, stringType.class, "stringType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getstringType_ConstExp(), this.getconstExpr(), null, "constExp", null, 0, 1, stringType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(strucTypeEClass, strucType.class, "strucType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getstrucType_Port(), ecorePackage.getEString(), "port", null, 0, 1, strucType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayTypeEClass, arrayType.class, "arrayType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getarrayType_OrdinalType(), this.getordinalType(), null, "ordinalType", null, 0, -1, arrayType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getarrayType_OrdinalTyp(), this.getordinalType(), null, "ordinalTyp", null, 0, -1, arrayType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getarrayType_Type(), this.gettype(), null, "type", null, 0, 1, arrayType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recTypeEClass, recType.class, "recType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getrecType_Fields(), this.getfieldList(), null, "fields", null, 0, 1, recType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fieldListEClass, fieldList.class, "fieldList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getfieldList_Field(), this.getfieldDecl(), null, "field", null, 0, -1, fieldList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getfieldList_VariantSect(), this.getvariantSection(), null, "variantSect", null, 0, 1, fieldList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fieldDeclEClass, fieldDecl.class, "fieldDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getfieldDecl_IdList(), this.getidentList(), null, "idList", null, 0, 1, fieldDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getfieldDecl_Type(), this.gettype(), null, "type", null, 0, 1, fieldDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getfieldDecl_Port(), ecorePackage.getEString(), "port", null, 0, 1, fieldDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variantSectionEClass, variantSection.class, "variantSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getvariantSection_Id(), this.getident(), null, "id", null, 0, 1, variantSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getvariantSection_TypeRef(), this.gettypeId(), null, "typeRef", null, 0, 1, variantSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getvariantSection_RecVariants(), this.getrecVariant(), null, "recVariants", null, 0, -1, variantSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recVariantEClass, recVariant.class, "recVariant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getrecVariant_ConstExp(), this.getconstExpr(), null, "constExp", null, 0, -1, recVariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getrecVariant_FieldList(), this.getfieldList(), null, "fieldList", null, 0, 1, recVariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setTypeEClass, setType.class, "setType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getsetType_Ordinal(), this.getordinalType(), null, "ordinal", null, 0, 1, setType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fileTypeEClass, fileType.class, "fileType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getfileType_TypeRef(), this.gettypeId(), null, "typeRef", null, 0, 1, fileType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pointerTypeEClass, pointerType.class, "pointerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(procedureTypeEClass, procedureType.class, "procedureType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getprocedureType_PHeading(), this.getprocedureHeading(), null, "pHeading", null, 0, 1, procedureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getprocedureType_FHeading(), this.getfunctionHeading(), null, "fHeading", null, 0, 1, procedureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varSectionEClass, varSection.class, "varSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getvarSection_VarDecls(), this.getvarDecl(), null, "varDecls", null, 0, -1, varSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varDeclEClass, varDecl.class, "varDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getvarDecl_IdList(), this.getidentList(), null, "idList", null, 0, 1, varDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getvarDecl_Type(), this.gettype(), null, "type", null, 0, 1, varDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getvarDecl_AbsId(), this.getident(), null, "absId", null, 0, 1, varDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getvarDecl_AbsConst(), this.getconstExpr(), null, "absConst", null, 0, 1, varDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getvarDecl_AbsIniti(), this.getconstExpr(), null, "absIniti", null, 0, 1, varDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionEClass, expression.class, "expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simpleExpressionEClass, simpleExpression.class, "simpleExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(termEClass, term.class, "term", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(factorEClass, factor.class, "factor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getfactor_Designator(), this.getdesignator(), null, "designator", null, 0, 1, factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getfactor_ExpList(), this.getexprList(), null, "expList", null, 0, 1, factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getfactor_Number(), ecorePackage.getEString(), "number", null, 0, 1, factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getfactor_String(), ecorePackage.getEString(), "string", null, 0, 1, factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getfactor_NestedExp(), this.getexpression(), null, "nestedExp", null, 0, 1, factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getfactor_Exp(), this.getexpression(), null, "exp", null, 0, 1, factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getfactor_SetConstuctor(), this.getsetConstructor(), null, "setConstuctor", null, 0, 1, factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getfactor_TypeRef(), this.gettypeId(), null, "typeRef", null, 0, 1, factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relOpEClass, relOp.class, "relOp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getrelOp_Op(), ecorePackage.getEString(), "op", null, 0, 1, relOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addOpEClass, addOp.class, "addOp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getaddOp_Op(), ecorePackage.getEString(), "op", null, 0, 1, addOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mulOpEClass, mulOp.class, "mulOp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getmulOp_Op(), ecorePackage.getEString(), "op", null, 0, 1, mulOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(designatorEClass, designator.class, "designator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getdesignator_Subpart(), this.getdesignatorSubPart(), null, "subpart", null, 0, 1, designator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getdesignator_Designator(), this.getdesignator(), null, "designator", null, 0, 1, designator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(designatorSubPartEClass, designatorSubPart.class, "designatorSubPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getdesignatorSubPart_Part(), this.getdesignatorPart(), null, "part", null, 0, 1, designatorSubPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getdesignatorSubPart_ExprList(), this.getexprList(), null, "exprList", null, 0, -1, designatorSubPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(designatorPartEClass, designatorPart.class, "designatorPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getdesignatorPart_Id(), ecorePackage.getEString(), "id", null, 0, 1, designatorPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getdesignatorPart_ReservedWord(), this.getreservedWord(), null, "reservedWord", null, 0, 1, designatorPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getdesignatorPart_Id2(), ecorePackage.getEString(), "id2", null, 0, 1, designatorPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setConstructorEClass, setConstructor.class, "setConstructor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getsetConstructor_Element(), this.getsetElement(), null, "element", null, 0, -1, setConstructor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setElementEClass, setElement.class, "setElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getsetElement_First(), this.getexpression(), null, "first", null, 0, 1, setElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getsetElement_Last(), this.getexpression(), null, "last", null, 0, 1, setElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exprListEClass, exprList.class, "exprList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getexprList_Exps(), this.getexpression(), null, "exps", null, 0, -1, exprList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stmtListEClass, stmtList.class, "stmtList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getstmtList_Statments(), this.getstatement(), null, "statments", null, 0, -1, stmtList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statementEClass, statement.class, "statement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getstatement_LabelId(), ecorePackage.getEString(), "labelId", null, 0, 1, statement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getstatement_Statement(), this.getunlabelledStatement(), null, "statement", null, 0, 1, statement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unlabelledStatementEClass, unlabelledStatement.class, "unlabelledStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simpleStatementEClass, simpleStatement.class, "simpleStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(structStmtEClass, structStmt.class, "structStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compoundStmtEClass, compoundStmt.class, "compoundStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getcompoundStmt_StamtList(), this.getstmtList(), null, "stamtList", null, 0, 1, compoundStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionalStmtEClass, conditionalStmt.class, "conditionalStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ifStmtEClass, ifStmt.class, "ifStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getifStmt_Condition(), this.getexpression(), null, "condition", null, 0, 1, ifStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getifStmt_Then(), this.getstatement(), null, "then", null, 0, 1, ifStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getifStmt_Else(), this.getstatement(), null, "else", null, 0, 1, ifStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caseStmtEClass, caseStmt.class, "caseStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getcaseStmt_Expression(), this.getexpression(), null, "expression", null, 0, 1, caseStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getcaseStmt_Cases(), this.getcaseSelector(), null, "cases", null, 0, -1, caseStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getcaseStmt_Default(), this.getstmtList(), null, "default", null, 0, 1, caseStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caseSelectorEClass, caseSelector.class, "caseSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getcaseSelector_Labels(), this.getcaseLabel(), null, "labels", null, 0, -1, caseSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getcaseSelector_Stmt(), this.getstatement(), null, "stmt", null, 0, 1, caseSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caseLabelEClass, caseLabel.class, "caseLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getcaseLabel_First(), this.getconstExpr(), null, "first", null, 0, 1, caseLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getcaseLabel_Last(), this.getconstExpr(), null, "last", null, 0, 1, caseLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loopStmtEClass, loopStmt.class, "loopStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getloopStmt_Stmt(), this.getstatement(), null, "stmt", null, 0, 1, loopStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getloopStmt_Condition(), this.getexpression(), null, "condition", null, 0, 1, loopStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(repeatStmtEClass, repeatStmt.class, "repeatStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(whileStmtEClass, whileStmt.class, "whileStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(forStmtEClass, forStmt.class, "forStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getforStmt_VarId(), this.getqualId(), null, "varId", null, 0, 1, forStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getforStmt_VarInit(), this.getexpression(), null, "varInit", null, 0, 1, forStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(withStmtEClass, withStmt.class, "withStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getwithStmt_Vars(), this.getidentList(), null, "vars", null, 0, 1, withStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getwithStmt_Stmt(), this.getstatement(), null, "stmt", null, 0, 1, withStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tryStmtEClass, tryStmt.class, "tryStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(gettryStmt_StmtList(), this.getstmtList(), null, "stmtList", null, 0, 1, tryStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(gettryStmt_Exception(), this.getexceptionBlock(), null, "exception", null, 0, 1, tryStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(gettryStmt_Final(), this.getstmtList(), null, "final", null, 0, 1, tryStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exceptionBlockEClass, exceptionBlock.class, "exceptionBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getexceptionBlock_ExceptionId(), this.getident(), null, "exceptionId", null, 0, -1, exceptionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getexceptionBlock_Type(), this.gettype(), null, "type", null, 0, -1, exceptionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getexceptionBlock_DoStmt(), this.getstatement(), null, "doStmt", null, 0, -1, exceptionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getexceptionBlock_ElseStmts(), this.getstmtList(), null, "elseStmts", null, 0, 1, exceptionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(raiseStmtEClass, raiseStmt.class, "raiseStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getraiseStmt_Raise(), ecorePackage.getEString(), "raise", null, 0, 1, raiseStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getraiseStmt_At(), ecorePackage.getEString(), "at", null, 0, 1, raiseStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assemblerStmtEClass, assemblerStmt.class, "assemblerStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(procedureDeclSectionEClass, procedureDeclSection.class, "procedureDeclSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getprocedureDeclSection_Directive(), this.getdirective(), null, "directive", null, 0, 1, procedureDeclSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getprocedureDeclSection_Port(), ecorePackage.getEString(), "port", null, 0, 1, procedureDeclSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getprocedureDeclSection_Block(), this.getblock(), null, "block", null, 0, 1, procedureDeclSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(procedureDeclEClass, procedureDecl.class, "procedureDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getprocedureDecl_Heading(), this.getprocedureHeading(), null, "heading", null, 0, 1, procedureDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionDeclEClass, functionDecl.class, "functionDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getfunctionDecl_Heading(), this.getfunctionHeading(), null, "heading", null, 0, 1, functionDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionHeadingEClass, functionHeading.class, "functionHeading", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getfunctionHeading_Type(), this.gettype(), null, "type", null, 0, 1, functionHeading.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(procedureHeadingEClass, procedureHeading.class, "procedureHeading", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(formalParametersEClass, formalParameters.class, "formalParameters", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getformalParameters_Params(), this.getformalParm(), null, "params", null, 0, -1, formalParameters.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(formalParmEClass, formalParm.class, "formalParm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getformalParm_Param(), this.getparameter(), null, "param", null, 0, 1, formalParm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, parameter.class, "parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getparameter_Type(), this.gettype(), null, "type", null, 0, 1, parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(directiveEClass, directive.class, "directive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getdirective_Dir(), ecorePackage.getEString(), "dir", null, 0, 1, directive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getdirective_MessageExp(), this.getconstExpr(), null, "messageExp", null, 0, 1, directive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectTypeEClass, objectType.class, "objectType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getobjectType_Heritage(), this.getobjHeritage(), null, "heritage", null, 0, 1, objectType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getobjectType_FieldList(), this.getobjFieldList(), null, "fieldList", null, 0, 1, objectType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getobjectType_MethodList(), this.getmethodList(), null, "methodList", null, 0, 1, objectType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objHeritageEClass, objHeritage.class, "objHeritage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getobjHeritage_Id(), this.getqualId(), null, "id", null, 0, 1, objHeritage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodListEClass, methodList.class, "methodList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getmethodList_Heading(), this.getmethodHeading(), null, "heading", null, 0, 1, methodList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getmethodList_Directive(), this.getdirective(), null, "directive", null, 0, -1, methodList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodHeadingEClass, methodHeading.class, "methodHeading", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getmethodHeading_Id(), this.getident(), null, "id", null, 0, 1, methodHeading.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getmethodHeading_FormalParams(), this.getformalParameters(), null, "formalParams", null, 0, 1, methodHeading.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constructorHeadingEClass, constructorHeading.class, "constructorHeading", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(destructorHeadingEClass, destructorHeading.class, "destructorHeading", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(objFieldListEClass, objFieldList.class, "objFieldList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(initSectionEClass, initSection.class, "initSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getinitSection_StmtList(), this.getstmtList(), null, "stmtList", null, 0, 1, initSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getinitSection_EndStmtList(), this.getstmtList(), null, "endStmtList", null, 0, 1, initSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classTypeEClass, classType.class, "classType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getclassType_Heritage(), this.getclassHeritage(), null, "heritage", null, 0, 1, classType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getclassType_Visibility(), ecorePackage.getEString(), "visibility", null, 0, 1, classType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getclassType_FieldList(), this.getclassFieldList(), null, "fieldList", null, 0, 1, classType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getclassType_MethodList(), this.getclassMethodList(), null, "methodList", null, 0, 1, classType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getclassType_PropList(), this.getclassPropertyList(), null, "propList", null, 0, 1, classType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classHeritageEClass, classHeritage.class, "classHeritage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classFieldListEClass, classFieldList.class, "classFieldList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getclassFieldList_Field(), this.getclassField(), null, "field", null, 0, -1, classFieldList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classFieldEClass, classField.class, "classField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getclassField_Visibility(), ecorePackage.getEString(), "visibility", null, 0, 1, classField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getclassField_FieldList(), this.getobjFieldList(), null, "fieldList", null, 0, 1, classField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classMethodListEClass, classMethodList.class, "classMethodList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getclassMethodList_Metod(), this.getclassMethod(), null, "metod", null, 0, -1, classMethodList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classMethodEClass, classMethod.class, "classMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getclassMethod_Visibility(), ecorePackage.getEString(), "visibility", null, 0, 1, classMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getclassMethod_MethodList(), this.getmethodList(), null, "methodList", null, 0, 1, classMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classPropertyListEClass, classPropertyList.class, "classPropertyList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getclassPropertyList_Property(), this.getclassProperty(), null, "property", null, 0, -1, classPropertyList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classPropertyEClass, classProperty.class, "classProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getclassProperty_Visibility(), ecorePackage.getEString(), "visibility", null, 0, 1, classProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getclassProperty_PropList(), this.getpropertyList(), null, "propList", null, 0, 1, classProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyListEClass, propertyList.class, "propertyList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getpropertyList_Id(), this.getident(), null, "id", null, 0, 1, propertyList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getpropertyList_Interface(), this.getpropertyInterface(), null, "interface", null, 0, 1, propertyList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getpropertyList_Specifiers(), this.getpropertySpecifiers(), null, "specifiers", null, 0, 1, propertyList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getpropertyList_Port(), ecorePackage.getEString(), "port", null, 0, 1, propertyList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyInterfaceEClass, propertyInterface.class, "propertyInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getpropertyInterface_ParamList(), this.getpropertyParameterList(), null, "paramList", null, 0, 1, propertyInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getpropertyInterface_Id(), this.getident(), null, "id", null, 0, 1, propertyInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyParameterListEClass, propertyParameterList.class, "propertyParameterList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getpropertyParameterList_IdList(), this.getidentList(), null, "idList", null, 0, -1, propertyParameterList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getpropertyParameterList_TypeRef(), this.gettypeId(), null, "typeRef", null, 0, -1, propertyParameterList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertySpecifiersEClass, propertySpecifiers.class, "propertySpecifiers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getpropertySpecifiers_Index(), this.getconstExpr(), null, "index", null, 0, 1, propertySpecifiers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getpropertySpecifiers_ReadId(), this.getident(), null, "readId", null, 0, 1, propertySpecifiers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getpropertySpecifiers_WriteId(), this.getident(), null, "writeId", null, 0, 1, propertySpecifiers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getpropertySpecifiers_StoreId(), this.getident(), null, "storeId", null, 0, 1, propertySpecifiers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getpropertySpecifiers_StoreExp(), this.getconstExpr(), null, "storeExp", null, 0, 1, propertySpecifiers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getpropertySpecifiers_DefaulExp(), this.getconstExpr(), null, "defaulExp", null, 0, 1, propertySpecifiers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getpropertySpecifiers_Implement(), this.gettypeId(), null, "implement", null, 0, 1, propertySpecifiers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceTypeEClass, interfaceType.class, "interfaceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getinterfaceType_Heritage(), this.getinterfaceHeritage(), null, "heritage", null, 0, 1, interfaceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getinterfaceType_MethodList(), this.getclassMethodList(), null, "methodList", null, 0, 1, interfaceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getinterfaceType_PropList(), this.getclassPropertyList(), null, "propList", null, 0, -1, interfaceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceHeritageEClass, interfaceHeritage.class, "interfaceHeritage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getinterfaceHeritage_IdList(), this.getidentList(), null, "idList", null, 0, 1, interfaceHeritage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requiresClauseEClass, requiresClause.class, "requiresClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getrequiresClause_IdList(), this.getidentList(), null, "idList", null, 0, -1, requiresClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containsClauseEClass, containsClause.class, "containsClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getcontainsClause_IdList(), this.getidentList(), null, "idList", null, 0, -1, containsClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(identListEClass, identList.class, "identList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getidentList_Type(), this.gettype(), null, "type", null, 0, 1, identList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getidentList_Ids(), this.getident(), null, "ids", null, 0, -1, identList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qualIdEClass, qualId.class, "qualId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getqualId_UnitId(), this.getunitId(), null, "unitId", null, 0, 1, qualId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getqualId_Id(), this.getident(), null, "id", null, 0, 1, qualId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeIdEClass, typeId.class, "typeId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(gettypeId_UnitId(), this.getunitId(), null, "unitId", null, 0, 1, typeId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(gettypeId_Id(), this.getqualId(), null, "id", null, 0, 1, typeId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(identEClass, ident.class, "ident", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(reservedWordEClass, reservedWord.class, "reservedWord", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getreservedWord_Id(), ecorePackage.getEString(), "id", null, 0, 1, reservedWord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constExprEClass, constExpr.class, "constExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(recordConstExprEClass, recordConstExpr.class, "recordConstExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getrecordConstExpr_Id(), this.getident(), null, "id", null, 0, 1, recordConstExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getrecordConstExpr_ConstExp(), this.getconstExpr(), null, "constExp", null, 0, 1, recordConstExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitIdEClass, unitId.class, "unitId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getunitId_Id(), ecorePackage.getEString(), "id", null, 0, 1, unitId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relExpEClass, relExp.class, "relExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getrelExp_Left(), this.getexpression(), null, "left", null, 0, 1, relExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getrelExp_RelOp(), this.getrelOp(), null, "relOp", null, 0, 1, relExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getrelExp_Right(), this.getsimpleExpression(), null, "right", null, 0, 1, relExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addExpEClass, addExp.class, "addExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getaddExp_Left(), this.getsimpleExpression(), null, "left", null, 0, 1, addExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getaddExp_AddOp(), this.getaddOp(), null, "addOp", null, 0, 1, addExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getaddExp_Right(), this.getterm(), null, "right", null, 0, 1, addExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multExpEClass, multExp.class, "multExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getmultExp_Left(), this.getterm(), null, "left", null, 0, 1, multExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getmultExp_MultOp(), this.getmulOp(), null, "multOp", null, 0, 1, multExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getmultExp_Right(), this.getfactor(), null, "right", null, 0, 1, multExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleFactorEClass, simpleFactor.class, "simpleFactor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assignmentStmntEClass, assignmentStmnt.class, "assignmentStmnt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getassignmentStmnt_Designator(), this.getdesignator(), null, "designator", null, 0, 1, assignmentStmnt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getassignmentStmnt_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, assignmentStmnt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getassignmentStmnt_Exp(), this.getexpression(), null, "exp", null, 0, 1, assignmentStmnt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callStmntEClass, callStmnt.class, "callStmnt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getcallStmnt_Designator(), this.getdesignator(), null, "designator", null, 0, 1, callStmnt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getcallStmnt_Args(), this.getexprList(), null, "args", null, 0, 1, callStmnt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inheritedStamntEClass, inheritedStamnt.class, "inheritedStamnt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(gotoStmntEClass, gotoStmnt.class, "gotoStmnt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getgotoStmnt_Label(), ecorePackage.getEString(), "label", null, 0, 1, gotoStmnt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterListEClass, parameterList.class, "parameterList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getparameterList_IdList(), this.getidentList(), null, "idList", null, 0, 1, parameterList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterSimpleEClass, parameterSimple.class, "parameterSimple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getparameterSimple_If(), this.getident(), null, "if", null, 0, 1, parameterSimple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getparameterSimple_InitExp(), this.getconstExpr(), null, "initExp", null, 0, 1, parameterSimple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multipleIdEClass, MultipleId.class, "MultipleId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultipleId_Id(), ecorePackage.getEString(), "id", null, 0, -1, MultipleId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(reservedIdEClass, ReservedId.class, "ReservedId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReservedId_ReservedWord(), this.getreservedWord(), null, "reservedWord", null, 0, 1, ReservedId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mineIDEClass, MineID.class, "MineID", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMineID_First(), ecorePackage.getEString(), "first", null, 0, 1, MineID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMineID_Second(), ecorePackage.getEString(), "second", null, 0, 1, MineID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constExpEClass, ConstExp.class, "ConstExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstExp_Exp(), this.getexpression(), null, "exp", null, 0, 1, ConstExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multipleConstExpEClass, MultipleConstExp.class, "MultipleConstExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultipleConstExp_Exps(), this.getconstExpr(), null, "exps", null, 0, -1, MultipleConstExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recordConstExpEClass, RecordConstExp.class, "RecordConstExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRecordConstExp_Exps(), this.getrecordConstExpr(), null, "exps", null, 0, -1, RecordConstExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(csTraceEClass, CSTrace.class, "CSTrace", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCSTrace_Ast(), theAstmPackage.getVisitable(), null, "ast", null, 0, 1, CSTrace.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //DelphiPackageImpl
