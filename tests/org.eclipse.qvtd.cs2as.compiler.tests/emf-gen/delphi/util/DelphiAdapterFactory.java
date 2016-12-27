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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.jdt.annotation.Nullable;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see delphi.DelphiPackage
 * @generated
 */
public class DelphiAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DelphiPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DelphiAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DelphiPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DelphiSwitch<@Nullable Adapter> modelSwitch =
		new DelphiSwitch<@Nullable Adapter>() {
			@Override
			public Adapter casemainRule(mainRule object) {
				return createmainRuleAdapter();
			}
			@Override
			public Adapter casefile(file object) {
				return createfileAdapter();
			}
			@Override
			public Adapter caseprogram(program object) {
				return createprogramAdapter();
			}
			@Override
			public Adapter caseunit(unit object) {
				return createunitAdapter();
			}
			@Override
			public Adapter casepackageDecl(packageDecl object) {
				return createpackageDeclAdapter();
			}
			@Override
			public Adapter caselibrary(library object) {
				return createlibraryAdapter();
			}
			@Override
			public Adapter caseprogramBlock(programBlock object) {
				return createprogramBlockAdapter();
			}
			@Override
			public Adapter caseusesClause(usesClause object) {
				return createusesClauseAdapter();
			}
			@Override
			public Adapter caseinterfaceSection(interfaceSection object) {
				return createinterfaceSectionAdapter();
			}
			@Override
			public Adapter caseinterfaceDecl(interfaceDecl object) {
				return createinterfaceDeclAdapter();
			}
			@Override
			public Adapter caseexportedHeading(exportedHeading object) {
				return createexportedHeadingAdapter();
			}
			@Override
			public Adapter caseimplementationSection(implementationSection object) {
				return createimplementationSectionAdapter();
			}
			@Override
			public Adapter caseblock(block object) {
				return createblockAdapter();
			}
			@Override
			public Adapter caseexportsItem(exportsItem object) {
				return createexportsItemAdapter();
			}
			@Override
			public Adapter caseexportsStmt(exportsStmt object) {
				return createexportsStmtAdapter();
			}
			@Override
			public Adapter casedeclSection(declSection object) {
				return createdeclSectionAdapter();
			}
			@Override
			public Adapter caselabelDeclSection(labelDeclSection object) {
				return createlabelDeclSectionAdapter();
			}
			@Override
			public Adapter caseconstSection(constSection object) {
				return createconstSectionAdapter();
			}
			@Override
			public Adapter caseconstantDecl(constantDecl object) {
				return createconstantDeclAdapter();
			}
			@Override
			public Adapter casetypeSection(typeSection object) {
				return createtypeSectionAdapter();
			}
			@Override
			public Adapter casetypeDecl(typeDecl object) {
				return createtypeDeclAdapter();
			}
			@Override
			public Adapter casetypedConstant(typedConstant object) {
				return createtypedConstantAdapter();
			}
			@Override
			public Adapter casearrayConstant(arrayConstant object) {
				return createarrayConstantAdapter();
			}
			@Override
			public Adapter caserecordConstant(recordConstant object) {
				return createrecordConstantAdapter();
			}
			@Override
			public Adapter caserecordFieldConstant(recordFieldConstant object) {
				return createrecordFieldConstantAdapter();
			}
			@Override
			public Adapter casetype(type object) {
				return createtypeAdapter();
			}
			@Override
			public Adapter caserestrictedType(restrictedType object) {
				return createrestrictedTypeAdapter();
			}
			@Override
			public Adapter caseclassRefType(classRefType object) {
				return createclassRefTypeAdapter();
			}
			@Override
			public Adapter casesimpleType(simpleType object) {
				return createsimpleTypeAdapter();
			}
			@Override
			public Adapter caserealType(realType object) {
				return createrealTypeAdapter();
			}
			@Override
			public Adapter caseordinalType(ordinalType object) {
				return createordinalTypeAdapter();
			}
			@Override
			public Adapter caseordIdent(ordIdent object) {
				return createordIdentAdapter();
			}
			@Override
			public Adapter casevariantType(variantType object) {
				return createvariantTypeAdapter();
			}
			@Override
			public Adapter casesubrangeType(subrangeType object) {
				return createsubrangeTypeAdapter();
			}
			@Override
			public Adapter caseenumeratedType(enumeratedType object) {
				return createenumeratedTypeAdapter();
			}
			@Override
			public Adapter caseenumeratedTypeElement(enumeratedTypeElement object) {
				return createenumeratedTypeElementAdapter();
			}
			@Override
			public Adapter casestringType(stringType object) {
				return createstringTypeAdapter();
			}
			@Override
			public Adapter casestrucType(strucType object) {
				return createstrucTypeAdapter();
			}
			@Override
			public Adapter casearrayType(arrayType object) {
				return createarrayTypeAdapter();
			}
			@Override
			public Adapter caserecType(recType object) {
				return createrecTypeAdapter();
			}
			@Override
			public Adapter casefieldList(fieldList object) {
				return createfieldListAdapter();
			}
			@Override
			public Adapter casefieldDecl(fieldDecl object) {
				return createfieldDeclAdapter();
			}
			@Override
			public Adapter casevariantSection(variantSection object) {
				return createvariantSectionAdapter();
			}
			@Override
			public Adapter caserecVariant(recVariant object) {
				return createrecVariantAdapter();
			}
			@Override
			public Adapter casesetType(setType object) {
				return createsetTypeAdapter();
			}
			@Override
			public Adapter casefileType(fileType object) {
				return createfileTypeAdapter();
			}
			@Override
			public Adapter casepointerType(pointerType object) {
				return createpointerTypeAdapter();
			}
			@Override
			public Adapter caseprocedureType(procedureType object) {
				return createprocedureTypeAdapter();
			}
			@Override
			public Adapter casevarSection(varSection object) {
				return createvarSectionAdapter();
			}
			@Override
			public Adapter casevarDecl(varDecl object) {
				return createvarDeclAdapter();
			}
			@Override
			public Adapter caseexpression(expression object) {
				return createexpressionAdapter();
			}
			@Override
			public Adapter casesimpleExpression(simpleExpression object) {
				return createsimpleExpressionAdapter();
			}
			@Override
			public Adapter caseterm(term object) {
				return createtermAdapter();
			}
			@Override
			public Adapter casefactor(factor object) {
				return createfactorAdapter();
			}
			@Override
			public Adapter caserelOp(relOp object) {
				return createrelOpAdapter();
			}
			@Override
			public Adapter caseaddOp(addOp object) {
				return createaddOpAdapter();
			}
			@Override
			public Adapter casemulOp(mulOp object) {
				return createmulOpAdapter();
			}
			@Override
			public Adapter casedesignator(designator object) {
				return createdesignatorAdapter();
			}
			@Override
			public Adapter casedesignatorSubPart(designatorSubPart object) {
				return createdesignatorSubPartAdapter();
			}
			@Override
			public Adapter casedesignatorPart(designatorPart object) {
				return createdesignatorPartAdapter();
			}
			@Override
			public Adapter casesetConstructor(setConstructor object) {
				return createsetConstructorAdapter();
			}
			@Override
			public Adapter casesetElement(setElement object) {
				return createsetElementAdapter();
			}
			@Override
			public Adapter caseexprList(exprList object) {
				return createexprListAdapter();
			}
			@Override
			public Adapter casestmtList(stmtList object) {
				return createstmtListAdapter();
			}
			@Override
			public Adapter casestatement(statement object) {
				return createstatementAdapter();
			}
			@Override
			public Adapter caseunlabelledStatement(unlabelledStatement object) {
				return createunlabelledStatementAdapter();
			}
			@Override
			public Adapter casesimpleStatement(simpleStatement object) {
				return createsimpleStatementAdapter();
			}
			@Override
			public Adapter casestructStmt(structStmt object) {
				return createstructStmtAdapter();
			}
			@Override
			public Adapter casecompoundStmt(compoundStmt object) {
				return createcompoundStmtAdapter();
			}
			@Override
			public Adapter caseconditionalStmt(conditionalStmt object) {
				return createconditionalStmtAdapter();
			}
			@Override
			public Adapter caseifStmt(ifStmt object) {
				return createifStmtAdapter();
			}
			@Override
			public Adapter casecaseStmt(caseStmt object) {
				return createcaseStmtAdapter();
			}
			@Override
			public Adapter casecaseSelector(caseSelector object) {
				return createcaseSelectorAdapter();
			}
			@Override
			public Adapter casecaseLabel(caseLabel object) {
				return createcaseLabelAdapter();
			}
			@Override
			public Adapter caseloopStmt(loopStmt object) {
				return createloopStmtAdapter();
			}
			@Override
			public Adapter caserepeatStmt(repeatStmt object) {
				return createrepeatStmtAdapter();
			}
			@Override
			public Adapter casewhileStmt(whileStmt object) {
				return createwhileStmtAdapter();
			}
			@Override
			public Adapter caseforStmt(forStmt object) {
				return createforStmtAdapter();
			}
			@Override
			public Adapter casewithStmt(withStmt object) {
				return createwithStmtAdapter();
			}
			@Override
			public Adapter casetryStmt(tryStmt object) {
				return createtryStmtAdapter();
			}
			@Override
			public Adapter caseexceptionBlock(exceptionBlock object) {
				return createexceptionBlockAdapter();
			}
			@Override
			public Adapter caseraiseStmt(raiseStmt object) {
				return createraiseStmtAdapter();
			}
			@Override
			public Adapter caseassemblerStmt(assemblerStmt object) {
				return createassemblerStmtAdapter();
			}
			@Override
			public Adapter caseprocedureDeclSection(procedureDeclSection object) {
				return createprocedureDeclSectionAdapter();
			}
			@Override
			public Adapter caseprocedureDecl(procedureDecl object) {
				return createprocedureDeclAdapter();
			}
			@Override
			public Adapter casefunctionDecl(functionDecl object) {
				return createfunctionDeclAdapter();
			}
			@Override
			public Adapter casefunctionHeading(functionHeading object) {
				return createfunctionHeadingAdapter();
			}
			@Override
			public Adapter caseprocedureHeading(procedureHeading object) {
				return createprocedureHeadingAdapter();
			}
			@Override
			public Adapter caseformalParameters(formalParameters object) {
				return createformalParametersAdapter();
			}
			@Override
			public Adapter caseformalParm(formalParm object) {
				return createformalParmAdapter();
			}
			@Override
			public Adapter caseparameter(parameter object) {
				return createparameterAdapter();
			}
			@Override
			public Adapter casedirective(directive object) {
				return createdirectiveAdapter();
			}
			@Override
			public Adapter caseobjectType(objectType object) {
				return createobjectTypeAdapter();
			}
			@Override
			public Adapter caseobjHeritage(objHeritage object) {
				return createobjHeritageAdapter();
			}
			@Override
			public Adapter casemethodList(methodList object) {
				return createmethodListAdapter();
			}
			@Override
			public Adapter casemethodHeading(methodHeading object) {
				return createmethodHeadingAdapter();
			}
			@Override
			public Adapter caseconstructorHeading(constructorHeading object) {
				return createconstructorHeadingAdapter();
			}
			@Override
			public Adapter casedestructorHeading(destructorHeading object) {
				return createdestructorHeadingAdapter();
			}
			@Override
			public Adapter caseobjFieldList(objFieldList object) {
				return createobjFieldListAdapter();
			}
			@Override
			public Adapter caseinitSection(initSection object) {
				return createinitSectionAdapter();
			}
			@Override
			public Adapter caseclassType(classType object) {
				return createclassTypeAdapter();
			}
			@Override
			public Adapter caseclassHeritage(classHeritage object) {
				return createclassHeritageAdapter();
			}
			@Override
			public Adapter caseclassFieldList(classFieldList object) {
				return createclassFieldListAdapter();
			}
			@Override
			public Adapter caseclassField(classField object) {
				return createclassFieldAdapter();
			}
			@Override
			public Adapter caseclassMethodList(classMethodList object) {
				return createclassMethodListAdapter();
			}
			@Override
			public Adapter caseclassMethod(classMethod object) {
				return createclassMethodAdapter();
			}
			@Override
			public Adapter caseclassPropertyList(classPropertyList object) {
				return createclassPropertyListAdapter();
			}
			@Override
			public Adapter caseclassProperty(classProperty object) {
				return createclassPropertyAdapter();
			}
			@Override
			public Adapter casepropertyList(propertyList object) {
				return createpropertyListAdapter();
			}
			@Override
			public Adapter casepropertyInterface(propertyInterface object) {
				return createpropertyInterfaceAdapter();
			}
			@Override
			public Adapter casepropertyParameterList(propertyParameterList object) {
				return createpropertyParameterListAdapter();
			}
			@Override
			public Adapter casepropertySpecifiers(propertySpecifiers object) {
				return createpropertySpecifiersAdapter();
			}
			@Override
			public Adapter caseinterfaceType(interfaceType object) {
				return createinterfaceTypeAdapter();
			}
			@Override
			public Adapter caseinterfaceHeritage(interfaceHeritage object) {
				return createinterfaceHeritageAdapter();
			}
			@Override
			public Adapter caserequiresClause(requiresClause object) {
				return createrequiresClauseAdapter();
			}
			@Override
			public Adapter casecontainsClause(containsClause object) {
				return createcontainsClauseAdapter();
			}
			@Override
			public Adapter caseidentList(identList object) {
				return createidentListAdapter();
			}
			@Override
			public Adapter casequalId(qualId object) {
				return createqualIdAdapter();
			}
			@Override
			public Adapter casetypeId(typeId object) {
				return createtypeIdAdapter();
			}
			@Override
			public Adapter caseident(ident object) {
				return createidentAdapter();
			}
			@Override
			public Adapter casereservedWord(reservedWord object) {
				return createreservedWordAdapter();
			}
			@Override
			public Adapter caseconstExpr(constExpr object) {
				return createconstExprAdapter();
			}
			@Override
			public Adapter caserecordConstExpr(recordConstExpr object) {
				return createrecordConstExprAdapter();
			}
			@Override
			public Adapter caseunitId(unitId object) {
				return createunitIdAdapter();
			}
			@Override
			public Adapter caserelExp(relExp object) {
				return createrelExpAdapter();
			}
			@Override
			public Adapter caseaddExp(addExp object) {
				return createaddExpAdapter();
			}
			@Override
			public Adapter casemultExp(multExp object) {
				return createmultExpAdapter();
			}
			@Override
			public Adapter casesimpleFactor(simpleFactor object) {
				return createsimpleFactorAdapter();
			}
			@Override
			public Adapter caseassignmentStmnt(assignmentStmnt object) {
				return createassignmentStmntAdapter();
			}
			@Override
			public Adapter casecallStmnt(callStmnt object) {
				return createcallStmntAdapter();
			}
			@Override
			public Adapter caseinheritedStamnt(inheritedStamnt object) {
				return createinheritedStamntAdapter();
			}
			@Override
			public Adapter casegotoStmnt(gotoStmnt object) {
				return creategotoStmntAdapter();
			}
			@Override
			public Adapter caseparameterList(parameterList object) {
				return createparameterListAdapter();
			}
			@Override
			public Adapter caseparameterSimple(parameterSimple object) {
				return createparameterSimpleAdapter();
			}
			@Override
			public Adapter caseMultipleId(MultipleId object) {
				return createMultipleIdAdapter();
			}
			@Override
			public Adapter caseReservedId(ReservedId object) {
				return createReservedIdAdapter();
			}
			@Override
			public Adapter caseMineID(MineID object) {
				return createMineIDAdapter();
			}
			@Override
			public Adapter caseConstExp(ConstExp object) {
				return createConstExpAdapter();
			}
			@Override
			public Adapter caseMultipleConstExp(MultipleConstExp object) {
				return createMultipleConstExpAdapter();
			}
			@Override
			public Adapter caseRecordConstExp(RecordConstExp object) {
				return createRecordConstExpAdapter();
			}
			@Override
			public Adapter caseCSTrace(CSTrace object) {
				return createCSTraceAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link delphi.mainRule <em>main Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.mainRule
	 * @generated
	 */
	public Adapter createmainRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.file <em>file</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.file
	 * @generated
	 */
	public Adapter createfileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.program <em>program</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.program
	 * @generated
	 */
	public Adapter createprogramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.unit <em>unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.unit
	 * @generated
	 */
	public Adapter createunitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.packageDecl <em>package Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.packageDecl
	 * @generated
	 */
	public Adapter createpackageDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.library <em>library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.library
	 * @generated
	 */
	public Adapter createlibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.programBlock <em>program Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.programBlock
	 * @generated
	 */
	public Adapter createprogramBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.usesClause <em>uses Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.usesClause
	 * @generated
	 */
	public Adapter createusesClauseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.interfaceSection <em>interface Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.interfaceSection
	 * @generated
	 */
	public Adapter createinterfaceSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.interfaceDecl <em>interface Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.interfaceDecl
	 * @generated
	 */
	public Adapter createinterfaceDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.exportedHeading <em>exported Heading</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.exportedHeading
	 * @generated
	 */
	public Adapter createexportedHeadingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.implementationSection <em>implementation Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.implementationSection
	 * @generated
	 */
	public Adapter createimplementationSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.block <em>block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.block
	 * @generated
	 */
	public Adapter createblockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.exportsItem <em>exports Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.exportsItem
	 * @generated
	 */
	public Adapter createexportsItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.exportsStmt <em>exports Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.exportsStmt
	 * @generated
	 */
	public Adapter createexportsStmtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.declSection <em>decl Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.declSection
	 * @generated
	 */
	public Adapter createdeclSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.labelDeclSection <em>label Decl Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.labelDeclSection
	 * @generated
	 */
	public Adapter createlabelDeclSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.constSection <em>const Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.constSection
	 * @generated
	 */
	public Adapter createconstSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.constantDecl <em>constant Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.constantDecl
	 * @generated
	 */
	public Adapter createconstantDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.typeSection <em>type Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.typeSection
	 * @generated
	 */
	public Adapter createtypeSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.typeDecl <em>type Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.typeDecl
	 * @generated
	 */
	public Adapter createtypeDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.typedConstant <em>typed Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.typedConstant
	 * @generated
	 */
	public Adapter createtypedConstantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.arrayConstant <em>array Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.arrayConstant
	 * @generated
	 */
	public Adapter createarrayConstantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.recordConstant <em>record Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.recordConstant
	 * @generated
	 */
	public Adapter createrecordConstantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.recordFieldConstant <em>record Field Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.recordFieldConstant
	 * @generated
	 */
	public Adapter createrecordFieldConstantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.type <em>type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.type
	 * @generated
	 */
	public Adapter createtypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.restrictedType <em>restricted Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.restrictedType
	 * @generated
	 */
	public Adapter createrestrictedTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.classRefType <em>class Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.classRefType
	 * @generated
	 */
	public Adapter createclassRefTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.simpleType <em>simple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.simpleType
	 * @generated
	 */
	public Adapter createsimpleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.realType <em>real Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.realType
	 * @generated
	 */
	public Adapter createrealTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.ordinalType <em>ordinal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.ordinalType
	 * @generated
	 */
	public Adapter createordinalTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.ordIdent <em>ord Ident</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.ordIdent
	 * @generated
	 */
	public Adapter createordIdentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.variantType <em>variant Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.variantType
	 * @generated
	 */
	public Adapter createvariantTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.subrangeType <em>subrange Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.subrangeType
	 * @generated
	 */
	public Adapter createsubrangeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.enumeratedType <em>enumerated Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.enumeratedType
	 * @generated
	 */
	public Adapter createenumeratedTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.enumeratedTypeElement <em>enumerated Type Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.enumeratedTypeElement
	 * @generated
	 */
	public Adapter createenumeratedTypeElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.stringType <em>string Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.stringType
	 * @generated
	 */
	public Adapter createstringTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.strucType <em>struc Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.strucType
	 * @generated
	 */
	public Adapter createstrucTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.arrayType <em>array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.arrayType
	 * @generated
	 */
	public Adapter createarrayTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.recType <em>rec Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.recType
	 * @generated
	 */
	public Adapter createrecTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.fieldList <em>field List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.fieldList
	 * @generated
	 */
	public Adapter createfieldListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.fieldDecl <em>field Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.fieldDecl
	 * @generated
	 */
	public Adapter createfieldDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.variantSection <em>variant Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.variantSection
	 * @generated
	 */
	public Adapter createvariantSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.recVariant <em>rec Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.recVariant
	 * @generated
	 */
	public Adapter createrecVariantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.setType <em>set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.setType
	 * @generated
	 */
	public Adapter createsetTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.fileType <em>file Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.fileType
	 * @generated
	 */
	public Adapter createfileTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.pointerType <em>pointer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.pointerType
	 * @generated
	 */
	public Adapter createpointerTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.procedureType <em>procedure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.procedureType
	 * @generated
	 */
	public Adapter createprocedureTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.varSection <em>var Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.varSection
	 * @generated
	 */
	public Adapter createvarSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.varDecl <em>var Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.varDecl
	 * @generated
	 */
	public Adapter createvarDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.expression <em>expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.expression
	 * @generated
	 */
	public Adapter createexpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.simpleExpression <em>simple Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.simpleExpression
	 * @generated
	 */
	public Adapter createsimpleExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.term <em>term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.term
	 * @generated
	 */
	public Adapter createtermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.factor <em>factor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.factor
	 * @generated
	 */
	public Adapter createfactorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.relOp <em>rel Op</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.relOp
	 * @generated
	 */
	public Adapter createrelOpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.addOp <em>add Op</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.addOp
	 * @generated
	 */
	public Adapter createaddOpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.mulOp <em>mul Op</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.mulOp
	 * @generated
	 */
	public Adapter createmulOpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.designator <em>designator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.designator
	 * @generated
	 */
	public Adapter createdesignatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.designatorSubPart <em>designator Sub Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.designatorSubPart
	 * @generated
	 */
	public Adapter createdesignatorSubPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.designatorPart <em>designator Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.designatorPart
	 * @generated
	 */
	public Adapter createdesignatorPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.setConstructor <em>set Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.setConstructor
	 * @generated
	 */
	public Adapter createsetConstructorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.setElement <em>set Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.setElement
	 * @generated
	 */
	public Adapter createsetElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.exprList <em>expr List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.exprList
	 * @generated
	 */
	public Adapter createexprListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.stmtList <em>stmt List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.stmtList
	 * @generated
	 */
	public Adapter createstmtListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.statement <em>statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.statement
	 * @generated
	 */
	public Adapter createstatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.unlabelledStatement <em>unlabelled Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.unlabelledStatement
	 * @generated
	 */
	public Adapter createunlabelledStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.simpleStatement <em>simple Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.simpleStatement
	 * @generated
	 */
	public Adapter createsimpleStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.structStmt <em>struct Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.structStmt
	 * @generated
	 */
	public Adapter createstructStmtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.compoundStmt <em>compound Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.compoundStmt
	 * @generated
	 */
	public Adapter createcompoundStmtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.conditionalStmt <em>conditional Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.conditionalStmt
	 * @generated
	 */
	public Adapter createconditionalStmtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.ifStmt <em>if Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.ifStmt
	 * @generated
	 */
	public Adapter createifStmtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.caseStmt <em>case Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.caseStmt
	 * @generated
	 */
	public Adapter createcaseStmtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.caseSelector <em>case Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.caseSelector
	 * @generated
	 */
	public Adapter createcaseSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.caseLabel <em>case Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.caseLabel
	 * @generated
	 */
	public Adapter createcaseLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.loopStmt <em>loop Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.loopStmt
	 * @generated
	 */
	public Adapter createloopStmtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.repeatStmt <em>repeat Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.repeatStmt
	 * @generated
	 */
	public Adapter createrepeatStmtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.whileStmt <em>while Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.whileStmt
	 * @generated
	 */
	public Adapter createwhileStmtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.forStmt <em>for Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.forStmt
	 * @generated
	 */
	public Adapter createforStmtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.withStmt <em>with Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.withStmt
	 * @generated
	 */
	public Adapter createwithStmtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.tryStmt <em>try Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.tryStmt
	 * @generated
	 */
	public Adapter createtryStmtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.exceptionBlock <em>exception Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.exceptionBlock
	 * @generated
	 */
	public Adapter createexceptionBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.raiseStmt <em>raise Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.raiseStmt
	 * @generated
	 */
	public Adapter createraiseStmtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.assemblerStmt <em>assembler Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.assemblerStmt
	 * @generated
	 */
	public Adapter createassemblerStmtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.procedureDeclSection <em>procedure Decl Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.procedureDeclSection
	 * @generated
	 */
	public Adapter createprocedureDeclSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.procedureDecl <em>procedure Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.procedureDecl
	 * @generated
	 */
	public Adapter createprocedureDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.functionDecl <em>function Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.functionDecl
	 * @generated
	 */
	public Adapter createfunctionDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.functionHeading <em>function Heading</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.functionHeading
	 * @generated
	 */
	public Adapter createfunctionHeadingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.procedureHeading <em>procedure Heading</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.procedureHeading
	 * @generated
	 */
	public Adapter createprocedureHeadingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.formalParameters <em>formal Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.formalParameters
	 * @generated
	 */
	public Adapter createformalParametersAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.formalParm <em>formal Parm</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.formalParm
	 * @generated
	 */
	public Adapter createformalParmAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.parameter <em>parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.parameter
	 * @generated
	 */
	public Adapter createparameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.directive <em>directive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.directive
	 * @generated
	 */
	public Adapter createdirectiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.objectType <em>object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.objectType
	 * @generated
	 */
	public Adapter createobjectTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.objHeritage <em>obj Heritage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.objHeritage
	 * @generated
	 */
	public Adapter createobjHeritageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.methodList <em>method List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.methodList
	 * @generated
	 */
	public Adapter createmethodListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.methodHeading <em>method Heading</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.methodHeading
	 * @generated
	 */
	public Adapter createmethodHeadingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.constructorHeading <em>constructor Heading</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.constructorHeading
	 * @generated
	 */
	public Adapter createconstructorHeadingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.destructorHeading <em>destructor Heading</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.destructorHeading
	 * @generated
	 */
	public Adapter createdestructorHeadingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.objFieldList <em>obj Field List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.objFieldList
	 * @generated
	 */
	public Adapter createobjFieldListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.initSection <em>init Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.initSection
	 * @generated
	 */
	public Adapter createinitSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.classType <em>class Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.classType
	 * @generated
	 */
	public Adapter createclassTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.classHeritage <em>class Heritage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.classHeritage
	 * @generated
	 */
	public Adapter createclassHeritageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.classFieldList <em>class Field List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.classFieldList
	 * @generated
	 */
	public Adapter createclassFieldListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.classField <em>class Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.classField
	 * @generated
	 */
	public Adapter createclassFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.classMethodList <em>class Method List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.classMethodList
	 * @generated
	 */
	public Adapter createclassMethodListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.classMethod <em>class Method</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.classMethod
	 * @generated
	 */
	public Adapter createclassMethodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.classPropertyList <em>class Property List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.classPropertyList
	 * @generated
	 */
	public Adapter createclassPropertyListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.classProperty <em>class Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.classProperty
	 * @generated
	 */
	public Adapter createclassPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.propertyList <em>property List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.propertyList
	 * @generated
	 */
	public Adapter createpropertyListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.propertyInterface <em>property Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.propertyInterface
	 * @generated
	 */
	public Adapter createpropertyInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.propertyParameterList <em>property Parameter List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.propertyParameterList
	 * @generated
	 */
	public Adapter createpropertyParameterListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.propertySpecifiers <em>property Specifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.propertySpecifiers
	 * @generated
	 */
	public Adapter createpropertySpecifiersAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.interfaceType <em>interface Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.interfaceType
	 * @generated
	 */
	public Adapter createinterfaceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.interfaceHeritage <em>interface Heritage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.interfaceHeritage
	 * @generated
	 */
	public Adapter createinterfaceHeritageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.requiresClause <em>requires Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.requiresClause
	 * @generated
	 */
	public Adapter createrequiresClauseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.containsClause <em>contains Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.containsClause
	 * @generated
	 */
	public Adapter createcontainsClauseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.identList <em>ident List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.identList
	 * @generated
	 */
	public Adapter createidentListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.qualId <em>qual Id</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.qualId
	 * @generated
	 */
	public Adapter createqualIdAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.typeId <em>type Id</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.typeId
	 * @generated
	 */
	public Adapter createtypeIdAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.ident <em>ident</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.ident
	 * @generated
	 */
	public Adapter createidentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.reservedWord <em>reserved Word</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.reservedWord
	 * @generated
	 */
	public Adapter createreservedWordAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.constExpr <em>const Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.constExpr
	 * @generated
	 */
	public Adapter createconstExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.recordConstExpr <em>record Const Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.recordConstExpr
	 * @generated
	 */
	public Adapter createrecordConstExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.unitId <em>unit Id</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.unitId
	 * @generated
	 */
	public Adapter createunitIdAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.relExp <em>rel Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.relExp
	 * @generated
	 */
	public Adapter createrelExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.addExp <em>add Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.addExp
	 * @generated
	 */
	public Adapter createaddExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.multExp <em>mult Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.multExp
	 * @generated
	 */
	public Adapter createmultExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.simpleFactor <em>simple Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.simpleFactor
	 * @generated
	 */
	public Adapter createsimpleFactorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.assignmentStmnt <em>assignment Stmnt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.assignmentStmnt
	 * @generated
	 */
	public Adapter createassignmentStmntAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.callStmnt <em>call Stmnt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.callStmnt
	 * @generated
	 */
	public Adapter createcallStmntAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.inheritedStamnt <em>inherited Stamnt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.inheritedStamnt
	 * @generated
	 */
	public Adapter createinheritedStamntAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.gotoStmnt <em>goto Stmnt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.gotoStmnt
	 * @generated
	 */
	public Adapter creategotoStmntAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.parameterList <em>parameter List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.parameterList
	 * @generated
	 */
	public Adapter createparameterListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.parameterSimple <em>parameter Simple</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.parameterSimple
	 * @generated
	 */
	public Adapter createparameterSimpleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.MultipleId <em>Multiple Id</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.MultipleId
	 * @generated
	 */
	public Adapter createMultipleIdAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.ReservedId <em>Reserved Id</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.ReservedId
	 * @generated
	 */
	public Adapter createReservedIdAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.MineID <em>Mine ID</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.MineID
	 * @generated
	 */
	public Adapter createMineIDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.ConstExp <em>Const Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.ConstExp
	 * @generated
	 */
	public Adapter createConstExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.MultipleConstExp <em>Multiple Const Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.MultipleConstExp
	 * @generated
	 */
	public Adapter createMultipleConstExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.RecordConstExp <em>Record Const Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.RecordConstExp
	 * @generated
	 */
	public Adapter createRecordConstExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link delphi.CSTrace <em>CS Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see delphi.CSTrace
	 * @generated
	 */
	public Adapter createCSTraceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DelphiAdapterFactory
