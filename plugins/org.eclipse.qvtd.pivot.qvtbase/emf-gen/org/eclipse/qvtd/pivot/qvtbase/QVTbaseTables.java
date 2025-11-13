/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2013, 2025 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 *   /org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.ecore
 * using:
 *   /org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.genmodel
 *   org.eclipse.ocl.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.ParameterTypes;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.flat.FlatClass;
import org.eclipse.ocl.pivot.flat.FlatFragment;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.EnumerationId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.PartialStandardLibraryImpl;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.types.TemplateParameters;
import org.eclipse.ocl.pivot.utilities.AbstractTables;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
// import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
// import org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables;

/**
 * QVTbaseTables provides the dispatch tables for the qvtbase for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
public class QVTbaseTables extends AbstractTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The overall library of all packages and types.
	 */
	public static final PartialStandardLibraryImpl.@NonNull ReadOnly LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	The AS package for the QVTbasePackage.eINSTANCE EPackage.
	 */
	public static final org.eclipse.ocl.pivot.@NonNull Package PACKAGE = LIBRARY.createPackage(QVTbasePackage.eINSTANCE);

	/**
	 *	The AS model for the AS package and its additional orphans.
	 */
	public static final AbstractTables.@NonNull BuiltInModel MODEL = LIBRARY.createModel(PACKAGE);

	/**
	 *	The EMF Resource containing the AS model, its AS package and its additional orphans.
	 */
	public static final @NonNull Resource RESOURCE = LIBRARY.createResource(MODEL);

	/**
	 *	Constants used by auto-generated code.
	 */
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbase", "qvtb", QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Annotation = QVTbaseTables.PACKid_$metamodel$.getClassId("Annotation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BooleanType = QVTbaseTables.PACKid_$metamodel$.getClassId("BooleanType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = QVTbaseTables.PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CompoundTargetElement = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("CompoundTargetElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Domain = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Domain", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Function = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Function", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_FunctionParameter = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("FunctionParameter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OCLExpression = QVTbaseTables.PACKid_$metamodel$.getClassId("OCLExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclElement = QVTbaseTables.PACKid_$metamodel$.getClassId("OclElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Package = QVTbaseTables.PACKid_$metamodel$.getClassId("Package", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Parameter = QVTbaseTables.PACKid_$metamodel$.getClassId("Parameter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ParameterVariable = QVTbaseTables.PACKid_$metamodel$.getClassId("ParameterVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Pattern = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Pattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Predicate = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Predicate", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Rule = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Rule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_SimpleTargetElement = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("SimpleTargetElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Target = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Target", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TargetElement = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("TargetElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Transformation = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Transformation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Type = QVTbaseTables.PACKid_$metamodel$.getClassId("Type", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TypedModel = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("TypedModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Variable = QVTbaseTables.PACKid_$metamodel$.getClassId("Variable", 0);
	public static final /*@NonInvalid*/ @NonNull EnumerationId ENUMid_TargetElementKind = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getEnumerationId("TargetElementKind");
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_0 = ValueUtil.integerValueOf("0");
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_1 = ValueUtil.integerValueOf("1");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_PRIMid_String = TypeId.SEQUENCE.getSpecializedId(TypeId.STRING, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_Domain = TypeId.BAG.getSpecializedId(QVTbaseTables.CLSSid_Domain, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_SimpleTargetElement = TypeId.BAG.getSpecializedId(QVTbaseTables.CLSSid_SimpleTargetElement, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_TypedModel = TypeId.BAG.getSpecializedId(QVTbaseTables.CLSSid_TypedModel, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Domain = TypeId.ORDERED_SET.getSpecializedId(QVTbaseTables.CLSSid_Domain, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Parameter = TypeId.ORDERED_SET.getSpecializedId(QVTbaseTables.CLSSid_Parameter, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Rule = TypeId.ORDERED_SET.getSpecializedId(QVTbaseTables.CLSSid_Rule, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_SimpleTargetElement = TypeId.ORDERED_SET.getSpecializedId(QVTbaseTables.CLSSid_SimpleTargetElement, false, ValueUtil.integerValueOf(2), ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_TypedModel = TypeId.ORDERED_SET.getSpecializedId(QVTbaseTables.CLSSid_TypedModel, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Package = TypeId.SEQUENCE.getSpecializedId(QVTbaseTables.CLSSid_Package, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Annotation = TypeId.SET.getSpecializedId(QVTbaseTables.CLSSid_Annotation, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Package = TypeId.SET.getSpecializedId(QVTbaseTables.CLSSid_Package, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Predicate = TypeId.SET.getSpecializedId(QVTbaseTables.CLSSid_Predicate, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Rule = TypeId.SET.getSpecializedId(QVTbaseTables.CLSSid_Rule, true, ValueUtil.ONE_VALUE, ValueUtil.ONE_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Rule_0 = TypeId.SET.getSpecializedId(QVTbaseTables.CLSSid_Rule, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Rule_1 = TypeId.SET.getSpecializedId(QVTbaseTables.CLSSid_Rule, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Target = TypeId.SET.getSpecializedId(QVTbaseTables.CLSSid_Target, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_TargetElement = TypeId.SET.getSpecializedId(QVTbaseTables.CLSSid_TargetElement, false, ValueUtil.integerValueOf(2), ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Transformation = TypeId.SET.getSpecializedId(QVTbaseTables.CLSSid_Transformation, true, ValueUtil.ONE_VALUE, ValueUtil.ONE_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Transformation_0 = TypeId.SET.getSpecializedId(QVTbaseTables.CLSSid_Transformation, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_TypedModel = TypeId.SET.getSpecializedId(QVTbaseTables.CLSSid_TypedModel, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Variable = TypeId.SET.getSpecializedId(QVTbaseTables.CLSSid_Variable, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			QVTbaseTables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTbaseTables::TypeParameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The type descriptors for each type.
	 */
	public static class Types {
		static {
			Init.initStart();
			TypeParameters.init();
		}

		public static final org.eclipse.ocl.pivot.@NonNull Class _BaseModel = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTbasePackage.Literals.BASE_MODEL, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _CompoundTargetElement = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTbasePackage.Literals.COMPOUND_TARGET_ELEMENT, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Domain = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTbasePackage.Literals.DOMAIN, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Function = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTbasePackage.Literals.FUNCTION, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _FunctionBody = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTbasePackage.Literals.FUNCTION_BODY, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _FunctionParameter = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTbasePackage.Literals.FUNCTION_PARAMETER, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Pattern = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTbasePackage.Literals.PATTERN, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Predicate = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTbasePackage.Literals.PREDICATE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Rule = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTbasePackage.Literals.RULE, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _SimpleTargetElement = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTbasePackage.Literals.SIMPLE_TARGET_ELEMENT, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Target = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTbasePackage.Literals.TARGET, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _TargetElement = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTbasePackage.Literals.TARGET_ELEMENT, null, 0 | FlatClass.ABSTRACT);
		public static final @NonNull Enumeration _TargetElementKind = LIBRARY.createEnumeration(QVTbasePackage.Literals.TARGET_ELEMENT_KIND);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Transformation = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTbasePackage.Literals.TRANSFORMATION, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _TypedModel = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTbasePackage.Literals.TYPED_MODEL, null, 0);

		private static final org.eclipse.ocl.pivot.@NonNull Class @NonNull [] types = {
			_BaseModel,
			_CompoundTargetElement,
			_Domain,
			_Function,
			_FunctionBody,
			_FunctionParameter,
			_Pattern,
			_Predicate,
			_Rule,
			_SimpleTargetElement,
			_Target,
			_TargetElement,
			_TargetElementKind,
			_Transformation,
			_TypedModel
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			LIBRARY.initPackage(PACKAGE, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTbaseTables::Types and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragment descriptors for the local elements of each type and its supertypes.
	 */
	public static class Fragments {
		static {
			Init.initStart();
			Types.init();
		}

		private static final @NonNull FlatFragment _BaseModel__BaseModel = LIBRARY.createFragment(Types._BaseModel, Types._BaseModel);
		private static final @NonNull FlatFragment _BaseModel__Element = LIBRARY.createFragment(Types._BaseModel, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _BaseModel__Model = LIBRARY.createFragment(Types._BaseModel, PivotTables.Types._Model);
		private static final @NonNull FlatFragment _BaseModel__NamedElement = LIBRARY.createFragment(Types._BaseModel, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _BaseModel__Namespace = LIBRARY.createFragment(Types._BaseModel, PivotTables.Types._Namespace);
		private static final @NonNull FlatFragment _BaseModel__OclAny = LIBRARY.createFragment(Types._BaseModel, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _BaseModel__OclElement = LIBRARY.createFragment(Types._BaseModel, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _CompoundTargetElement__CompoundTargetElement = LIBRARY.createFragment(Types._CompoundTargetElement, Types._CompoundTargetElement);
		private static final @NonNull FlatFragment _CompoundTargetElement__Element = LIBRARY.createFragment(Types._CompoundTargetElement, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _CompoundTargetElement__OclAny = LIBRARY.createFragment(Types._CompoundTargetElement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _CompoundTargetElement__OclElement = LIBRARY.createFragment(Types._CompoundTargetElement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _CompoundTargetElement__TargetElement = LIBRARY.createFragment(Types._CompoundTargetElement, Types._TargetElement);

		private static final @NonNull FlatFragment _Domain__Domain = LIBRARY.createFragment(Types._Domain, Types._Domain);
		private static final @NonNull FlatFragment _Domain__Element = LIBRARY.createFragment(Types._Domain, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _Domain__NamedElement = LIBRARY.createFragment(Types._Domain, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _Domain__OclAny = LIBRARY.createFragment(Types._Domain, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Domain__OclElement = LIBRARY.createFragment(Types._Domain, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Domain__ReferringElement = LIBRARY.createFragment(Types._Domain, PivotTables.Types._ReferringElement);

		private static final @NonNull FlatFragment _Function__Element = LIBRARY.createFragment(Types._Function, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _Function__Feature = LIBRARY.createFragment(Types._Function, PivotTables.Types._Feature);
		private static final @NonNull FlatFragment _Function__Function = LIBRARY.createFragment(Types._Function, Types._Function);
		private static final @NonNull FlatFragment _Function__NamedElement = LIBRARY.createFragment(Types._Function, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _Function__Namespace = LIBRARY.createFragment(Types._Function, PivotTables.Types._Namespace);
		private static final @NonNull FlatFragment _Function__OclAny = LIBRARY.createFragment(Types._Function, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Function__OclElement = LIBRARY.createFragment(Types._Function, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Function__Operation = LIBRARY.createFragment(Types._Function, PivotTables.Types._Operation);
		private static final @NonNull FlatFragment _Function__TemplateableElement = LIBRARY.createFragment(Types._Function, PivotTables.Types._TemplateableElement);
		private static final @NonNull FlatFragment _Function__TypedElement = LIBRARY.createFragment(Types._Function, PivotTables.Types._TypedElement);

		private static final @NonNull FlatFragment _FunctionBody__Element = LIBRARY.createFragment(Types._FunctionBody, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _FunctionBody__ExpressionInOCL = LIBRARY.createFragment(Types._FunctionBody, PivotTables.Types._ExpressionInOCL);
		private static final @NonNull FlatFragment _FunctionBody__FunctionBody = LIBRARY.createFragment(Types._FunctionBody, Types._FunctionBody);
		private static final @NonNull FlatFragment _FunctionBody__LanguageExpression = LIBRARY.createFragment(Types._FunctionBody, PivotTables.Types._LanguageExpression);
		private static final @NonNull FlatFragment _FunctionBody__NamedElement = LIBRARY.createFragment(Types._FunctionBody, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _FunctionBody__OclAny = LIBRARY.createFragment(Types._FunctionBody, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _FunctionBody__OclElement = LIBRARY.createFragment(Types._FunctionBody, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _FunctionBody__TypedElement = LIBRARY.createFragment(Types._FunctionBody, PivotTables.Types._TypedElement);
		private static final @NonNull FlatFragment _FunctionBody__ValueSpecification = LIBRARY.createFragment(Types._FunctionBody, PivotTables.Types._ValueSpecification);

		private static final @NonNull FlatFragment _FunctionParameter__Element = LIBRARY.createFragment(Types._FunctionParameter, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _FunctionParameter__FunctionParameter = LIBRARY.createFragment(Types._FunctionParameter, Types._FunctionParameter);
		private static final @NonNull FlatFragment _FunctionParameter__NamedElement = LIBRARY.createFragment(Types._FunctionParameter, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _FunctionParameter__OclAny = LIBRARY.createFragment(Types._FunctionParameter, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _FunctionParameter__OclElement = LIBRARY.createFragment(Types._FunctionParameter, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _FunctionParameter__Parameter = LIBRARY.createFragment(Types._FunctionParameter, PivotTables.Types._Parameter);
		private static final @NonNull FlatFragment _FunctionParameter__TypedElement = LIBRARY.createFragment(Types._FunctionParameter, PivotTables.Types._TypedElement);
		private static final @NonNull FlatFragment _FunctionParameter__VariableDeclaration = LIBRARY.createFragment(Types._FunctionParameter, PivotTables.Types._VariableDeclaration);

		private static final @NonNull FlatFragment _Pattern__Element = LIBRARY.createFragment(Types._Pattern, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _Pattern__OclAny = LIBRARY.createFragment(Types._Pattern, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Pattern__OclElement = LIBRARY.createFragment(Types._Pattern, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Pattern__Pattern = LIBRARY.createFragment(Types._Pattern, Types._Pattern);

		private static final @NonNull FlatFragment _Predicate__Element = LIBRARY.createFragment(Types._Predicate, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _Predicate__OclAny = LIBRARY.createFragment(Types._Predicate, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Predicate__OclElement = LIBRARY.createFragment(Types._Predicate, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Predicate__Predicate = LIBRARY.createFragment(Types._Predicate, Types._Predicate);

		private static final @NonNull FlatFragment _Rule__Element = LIBRARY.createFragment(Types._Rule, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _Rule__NamedElement = LIBRARY.createFragment(Types._Rule, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _Rule__OclAny = LIBRARY.createFragment(Types._Rule, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Rule__OclElement = LIBRARY.createFragment(Types._Rule, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Rule__Rule = LIBRARY.createFragment(Types._Rule, Types._Rule);

		private static final @NonNull FlatFragment _SimpleTargetElement__Element = LIBRARY.createFragment(Types._SimpleTargetElement, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _SimpleTargetElement__OclAny = LIBRARY.createFragment(Types._SimpleTargetElement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _SimpleTargetElement__OclElement = LIBRARY.createFragment(Types._SimpleTargetElement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _SimpleTargetElement__SimpleTargetElement = LIBRARY.createFragment(Types._SimpleTargetElement, Types._SimpleTargetElement);
		private static final @NonNull FlatFragment _SimpleTargetElement__TargetElement = LIBRARY.createFragment(Types._SimpleTargetElement, Types._TargetElement);

		private static final @NonNull FlatFragment _Target__Element = LIBRARY.createFragment(Types._Target, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _Target__NamedElement = LIBRARY.createFragment(Types._Target, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _Target__OclAny = LIBRARY.createFragment(Types._Target, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Target__OclElement = LIBRARY.createFragment(Types._Target, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Target__Target = LIBRARY.createFragment(Types._Target, Types._Target);

		private static final @NonNull FlatFragment _TargetElement__Element = LIBRARY.createFragment(Types._TargetElement, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _TargetElement__OclAny = LIBRARY.createFragment(Types._TargetElement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _TargetElement__OclElement = LIBRARY.createFragment(Types._TargetElement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _TargetElement__TargetElement = LIBRARY.createFragment(Types._TargetElement, Types._TargetElement);

		private static final @NonNull FlatFragment _TargetElementKind__OclAny = LIBRARY.createFragment(Types._TargetElementKind, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _TargetElementKind__OclElement = LIBRARY.createFragment(Types._TargetElementKind, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _TargetElementKind__OclEnumeration = LIBRARY.createFragment(Types._TargetElementKind, OCLstdlibTables.Types._OclEnumeration);
		private static final @NonNull FlatFragment _TargetElementKind__OclType = LIBRARY.createFragment(Types._TargetElementKind, OCLstdlibTables.Types._OclType);
		private static final @NonNull FlatFragment _TargetElementKind__TargetElementKind = LIBRARY.createFragment(Types._TargetElementKind, Types._TargetElementKind);

		private static final @NonNull FlatFragment _Transformation__Class = LIBRARY.createFragment(Types._Transformation, PivotTables.Types._Class);
		private static final @NonNull FlatFragment _Transformation__Element = LIBRARY.createFragment(Types._Transformation, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _Transformation__NamedElement = LIBRARY.createFragment(Types._Transformation, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _Transformation__Namespace = LIBRARY.createFragment(Types._Transformation, PivotTables.Types._Namespace);
		private static final @NonNull FlatFragment _Transformation__OclAny = LIBRARY.createFragment(Types._Transformation, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Transformation__OclElement = LIBRARY.createFragment(Types._Transformation, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Transformation__OclType = LIBRARY.createFragment(Types._Transformation, OCLstdlibTables.Types._OclType);
		private static final @NonNull FlatFragment _Transformation__TemplateableElement = LIBRARY.createFragment(Types._Transformation, PivotTables.Types._TemplateableElement);
		private static final @NonNull FlatFragment _Transformation__Transformation = LIBRARY.createFragment(Types._Transformation, Types._Transformation);
		private static final @NonNull FlatFragment _Transformation__Type = LIBRARY.createFragment(Types._Transformation, PivotTables.Types._Type);

		private static final @NonNull FlatFragment _TypedModel__Element = LIBRARY.createFragment(Types._TypedModel, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _TypedModel__NamedElement = LIBRARY.createFragment(Types._TypedModel, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _TypedModel__OclAny = LIBRARY.createFragment(Types._TypedModel, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _TypedModel__OclElement = LIBRARY.createFragment(Types._TypedModel, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _TypedModel__TypedModel = LIBRARY.createFragment(Types._TypedModel, Types._TypedModel);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTbaseTables::Fragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The parameter lists shared by operations.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Parameters {
		static {
			Init.initStart();
			Fragments.init();
		}

		public static final @NonNull ParameterTypes _String = new ParameterTypes(OCLstdlibTables.Types._String);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTbaseTables::Parameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The operation descriptors for each operation of each type.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Operations {
		static {
			Init.initStart();
			Parameters.init();
		}

		public static final @NonNull Operation _Transformation__getFunction = LIBRARY.createOperation(Types._Transformation, "getFunction", Parameters._String, Types._Function,
			0 | IsRequired, TemplateParameters.EMPTY_LIST, null);
		public static final @NonNull Operation _Transformation__getModelParameter = LIBRARY.createOperation(Types._Transformation, "getModelParameter", Parameters._String, Types._TypedModel,
			1 | IsRequired, TemplateParameters.EMPTY_LIST, null);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTbaseTables::Operations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The property descriptors for each property of each type.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Properties {
		static {
			Init.initStart();
			Operations.init();
		}

		public static final @NonNull Property _CompoundTargetElement__ownedTargetElements = LIBRARY.createProperty(Types._CompoundTargetElement, QVTbasePackage.Literals.COMPOUND_TARGET_ELEMENT__OWNED_TARGET_ELEMENTS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._SimpleTargetElement), 0 | IsComposite | IsRequired | IsResolveProxies);

		public static final @NonNull Property _Domain__isCheckable = LIBRARY.createProperty(Types._Domain, QVTbasePackage.Literals.DOMAIN__IS_CHECKABLE, OCLstdlibTables.Types._Boolean, 0 | IsRequired | IsResolveProxies | IsUnsettable);
		public static final @NonNull Property _Domain__isEnforceable = LIBRARY.createProperty(Types._Domain, QVTbasePackage.Literals.DOMAIN__IS_ENFORCEABLE, OCLstdlibTables.Types._Boolean, 1 | IsRequired | IsResolveProxies | IsUnsettable);
		public static final @NonNull Property _Domain__rule = LIBRARY.createProperty(Types._Domain, QVTbasePackage.Literals.DOMAIN__RULE, Types._Rule, 2 | IsRequired | IsResolveProxies | IsTransient);
		public static final @NonNull Property _Domain__typedModel = LIBRARY.createProperty(Types._Domain, QVTbasePackage.Literals.DOMAIN__TYPED_MODEL, Types._TypedModel, 3 | IsResolveProxies);

		public static final @NonNull Property _Function__queryExpression = LIBRARY.createProperty(Types._Function, QVTbasePackage.Literals.FUNCTION__QUERY_EXPRESSION, PivotTables.Types._OCLExpression, 0 | IsDerived | IsTransient | IsVolatile);

		public static final @NonNull Property _Pattern__bindsTo = LIBRARY.createProperty(Types._Pattern, QVTbasePackage.Literals.PATTERN__BINDS_TO, MODEL.getCollectionType(OCLstdlibTables.Types._Set, PivotTables.Types._Variable), 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Pattern__predicate = LIBRARY.createProperty(Types._Pattern, QVTbasePackage.Literals.PATTERN__PREDICATE, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Predicate), 1 | IsComposite | IsRequired | IsResolveProxies);

		public static final @NonNull Property _Predicate__conditionExpression = LIBRARY.createProperty(Types._Predicate, QVTbasePackage.Literals.PREDICATE__CONDITION_EXPRESSION, PivotTables.Types._OCLExpression, 0 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Predicate__pattern = LIBRARY.createProperty(Types._Predicate, QVTbasePackage.Literals.PREDICATE__PATTERN, Types._Pattern, 1 | IsRequired | IsResolveProxies | IsTransient);

		public static final @NonNull Property _Rule__domain = LIBRARY.createProperty(Types._Rule, QVTbasePackage.Literals.RULE__DOMAIN, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Domain), 0 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Rule__isAbstract = LIBRARY.createProperty(Types._Rule, QVTbasePackage.Literals.RULE__IS_ABSTRACT, OCLstdlibTables.Types._Boolean, 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Rule__overridden = LIBRARY.createProperty(Types._Rule, QVTbasePackage.Literals.RULE__OVERRIDDEN, Types._Rule, 2 | IsResolveProxies);
		public static final @NonNull Property _Rule__overrides = LIBRARY.createProperty(Types._Rule, QVTbasePackage.Literals.RULE__OVERRIDES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Rule), 3 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Rule__ownedContext = LIBRARY.createProperty(Types._Rule, QVTbasePackage.Literals.RULE__OWNED_CONTEXT, PivotTables.Types._ParameterVariable, 4 | IsComposite | IsResolveProxies);
		public static final @NonNull Property _Rule__transformation = LIBRARY.createProperty(Types._Rule, QVTbasePackage.Literals.RULE__TRANSFORMATION, Types._Transformation, 5 | IsTransient);

		public static final @NonNull Property _SimpleTargetElement__iterates = LIBRARY.createProperty(Types._SimpleTargetElement, QVTbasePackage.Literals.SIMPLE_TARGET_ELEMENT__ITERATES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._TypedModel), 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _SimpleTargetElement__kind = LIBRARY.createProperty(Types._SimpleTargetElement, QVTbasePackage.Literals.SIMPLE_TARGET_ELEMENT__KIND, Types._TargetElementKind, 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _SimpleTargetElement__typedModel = LIBRARY.createProperty(Types._SimpleTargetElement, QVTbasePackage.Literals.SIMPLE_TARGET_ELEMENT__TYPED_MODEL, Types._TypedModel, 2 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _SimpleTargetElement__CompoundTargetElement__ownedTargetElements = LIBRARY.createOppositeProperty(Types._SimpleTargetElement, "CompoundTargetElement", Types._CompoundTargetElement, 3 | IsImplicit | IsResolveProxies, QVTbasePackage.Literals.COMPOUND_TARGET_ELEMENT__OWNED_TARGET_ELEMENTS);

		public static final @NonNull Property _Target__ownedTargetElements = LIBRARY.createProperty(Types._Target, QVTbasePackage.Literals.TARGET__OWNED_TARGET_ELEMENTS, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._TargetElement), 0 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Target__owningTransformation = LIBRARY.createProperty(Types._Target, QVTbasePackage.Literals.TARGET__OWNING_TRANSFORMATION, Types._Transformation, 1 | IsRequired | IsResolveProxies | IsTransient);

		public static final @NonNull Property _TargetElement__Target__ownedTargetElements = LIBRARY.createOppositeProperty(Types._TargetElement, "Target", Types._Target, 0 | IsImplicit | IsResolveProxies, QVTbasePackage.Literals.TARGET__OWNED_TARGET_ELEMENTS);

		public static final @NonNull Property _Transformation__extends = LIBRARY.createProperty(Types._Transformation, QVTbasePackage.Literals.TRANSFORMATION__EXTENDS, Types._Transformation, 0 | IsResolveProxies);
		public static final @NonNull Property _Transformation__modelParameter = LIBRARY.createProperty(Types._Transformation, QVTbasePackage.Literals.TRANSFORMATION__MODEL_PARAMETER, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._TypedModel), 1 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Transformation__ownedContext = LIBRARY.createProperty(Types._Transformation, QVTbasePackage.Literals.TRANSFORMATION__OWNED_CONTEXT, PivotTables.Types._Parameter, 2 | IsComposite | IsResolveProxies);
		public static final @NonNull Property _Transformation__ownedTag = LIBRARY.createProperty(Types._Transformation, QVTbasePackage.Literals.TRANSFORMATION__OWNED_TAG, MODEL.getCollectionType(OCLstdlibTables.Types._Set, PivotTables.Types._Annotation), 3 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Transformation__ownedTargets = LIBRARY.createProperty(Types._Transformation, QVTbasePackage.Literals.TRANSFORMATION__OWNED_TARGETS, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Target), 4 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Transformation__rule = LIBRARY.createProperty(Types._Transformation, QVTbasePackage.Literals.TRANSFORMATION__RULE, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Rule), 5 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Transformation__extendedBy__extends = LIBRARY.createOppositeProperty(Types._Transformation, "extendedBy", Types._Transformation, 6 | IsImplicit | IsResolveProxies, QVTbasePackage.Literals.TRANSFORMATION__EXTENDS);

		public static final @NonNull Property _TypedModel__dependsOn = LIBRARY.createProperty(Types._TypedModel, QVTbasePackage.Literals.TYPED_MODEL__DEPENDS_ON, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._TypedModel), 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TypedModel__isPrimitive = LIBRARY.createProperty(Types._TypedModel, QVTbasePackage.Literals.TYPED_MODEL__IS_PRIMITIVE, OCLstdlibTables.Types._Boolean, 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TypedModel__isThis = LIBRARY.createProperty(Types._TypedModel, QVTbasePackage.Literals.TYPED_MODEL__IS_THIS, OCLstdlibTables.Types._Boolean, 2 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TypedModel__isTrace = LIBRARY.createProperty(Types._TypedModel, QVTbasePackage.Literals.TYPED_MODEL__IS_TRACE, OCLstdlibTables.Types._Boolean, 3 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TypedModel__iterates = LIBRARY.createProperty(Types._TypedModel, QVTbasePackage.Literals.TYPED_MODEL__ITERATES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._TypedModel), 4 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TypedModel__ownedContext = LIBRARY.createProperty(Types._TypedModel, QVTbasePackage.Literals.TYPED_MODEL__OWNED_CONTEXT, PivotTables.Types._Parameter, 5 | IsComposite | IsResolveProxies);
		public static final @NonNull Property _TypedModel__transformation = LIBRARY.createProperty(Types._TypedModel, QVTbasePackage.Literals.TYPED_MODEL__TRANSFORMATION, Types._Transformation, 6 | IsRequired | IsResolveProxies | IsTransient);
		public static final @NonNull Property _TypedModel__usedPackage = LIBRARY.createProperty(Types._TypedModel, QVTbasePackage.Literals.TYPED_MODEL__USED_PACKAGE, MODEL.getCollectionType(OCLstdlibTables.Types._Set, PivotTables.Types._Package), 7 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TypedModel__Domain__typedModel = LIBRARY.createOppositeProperty(Types._TypedModel, "Domain", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._Domain), 8 | IsImplicit | IsRequired | IsResolveProxies, QVTbasePackage.Literals.DOMAIN__TYPED_MODEL);
		public static final @NonNull Property _TypedModel__SimpleTargetElement__iterates = LIBRARY.createOppositeProperty(Types._TypedModel, "SimpleTargetElement", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._SimpleTargetElement), 9 | IsImplicit | IsRequired | IsResolveProxies, QVTbasePackage.Literals.SIMPLE_TARGET_ELEMENT__ITERATES);
		public static final @NonNull Property _TypedModel__SimpleTargetElement__typedModel = LIBRARY.createOppositeProperty(Types._TypedModel, "SimpleTargetElement", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._SimpleTargetElement), 10 | IsImplicit | IsRequired | IsResolveProxies, QVTbasePackage.Literals.SIMPLE_TARGET_ELEMENT__TYPED_MODEL);
		public static final @NonNull Property _TypedModel__TypedModel__iterates = LIBRARY.createOppositeProperty(Types._TypedModel, "TypedModel", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._TypedModel), 11 | IsImplicit | IsRequired | IsResolveProxies, QVTbasePackage.Literals.TYPED_MODEL__ITERATES);
		public static final @NonNull Property _TypedModel__dependent__dependsOn = LIBRARY.createOppositeProperty(Types._TypedModel, "dependent", Types._TypedModel, 12 | IsImplicit | IsResolveProxies, QVTbasePackage.Literals.TYPED_MODEL__DEPENDS_ON);

		static {
			_CompoundTargetElement__ownedTargetElements.setOpposite(_SimpleTargetElement__CompoundTargetElement__ownedTargetElements);

			_Domain__rule.setOpposite(_Rule__domain);
			_Domain__typedModel.setOpposite(_TypedModel__Domain__typedModel);

			createOpposite(PivotPackage.Literals.OCL_EXPRESSION, "Function", _Function__queryExpression);

			createOpposite(PivotPackage.Literals.VARIABLE, "Pattern", _Pattern__bindsTo);
			_Pattern__predicate.setOpposite(_Predicate__pattern);

			createOpposite(PivotPackage.Literals.OCL_EXPRESSION, "predicate", _Predicate__conditionExpression);
			_Predicate__pattern.setOpposite(_Pattern__predicate);

			_Rule__domain.setOpposite(_Domain__rule);
			_Rule__isAbstract.setDefaultValueString("false");
			_Rule__overridden.setOpposite(_Rule__overrides);
			_Rule__overrides.setOpposite(_Rule__overridden);
			createOpposite(PivotPackage.Literals.PARAMETER_VARIABLE, "Rule", _Rule__ownedContext);
			_Rule__transformation.setOpposite(_Transformation__rule);

			_SimpleTargetElement__iterates.setOpposite(_TypedModel__SimpleTargetElement__iterates);
			_SimpleTargetElement__typedModel.setOpposite(_TypedModel__SimpleTargetElement__typedModel);
			_SimpleTargetElement__CompoundTargetElement__ownedTargetElements.setOpposite(_CompoundTargetElement__ownedTargetElements);

			_Target__ownedTargetElements.setOpposite(_TargetElement__Target__ownedTargetElements);
			_Target__owningTransformation.setOpposite(_Transformation__ownedTargets);

			_TargetElement__Target__ownedTargetElements.setOpposite(_Target__ownedTargetElements);

			_Transformation__extends.setOpposite(_Transformation__extendedBy__extends);
			_Transformation__modelParameter.setOpposite(_TypedModel__transformation);
			createOpposite(PivotPackage.Literals.PARAMETER, "Transformation", _Transformation__ownedContext);
			createOpposite(PivotPackage.Literals.ANNOTATION, "Transformation", _Transformation__ownedTag);
			_Transformation__ownedTargets.setOpposite(_Target__owningTransformation);
			_Transformation__rule.setOpposite(_Rule__transformation);
			_Transformation__extendedBy__extends.setOpposite(_Transformation__extends);

			_TypedModel__dependsOn.setOpposite(_TypedModel__dependent__dependsOn);
			_TypedModel__isPrimitive.setDefaultValueString("false");
			_TypedModel__isThis.setDefaultValueString("false");
			_TypedModel__isTrace.setDefaultValueString("false");
			_TypedModel__iterates.setOpposite(_TypedModel__TypedModel__iterates);
			createOpposite(PivotPackage.Literals.PARAMETER, "TypedModel", _TypedModel__ownedContext);
			_TypedModel__transformation.setOpposite(_Transformation__modelParameter);
			createOpposite(PivotPackage.Literals.PACKAGE, "TypedModel", _TypedModel__usedPackage);
			_TypedModel__Domain__typedModel.setOpposite(_Domain__typedModel);
			_TypedModel__SimpleTargetElement__iterates.setOpposite(_SimpleTargetElement__iterates);
			_TypedModel__SimpleTargetElement__typedModel.setOpposite(_SimpleTargetElement__typedModel);
			_TypedModel__TypedModel__iterates.setOpposite(_TypedModel__iterates);
			_TypedModel__dependent__dependsOn.setOpposite(_TypedModel__dependsOn);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTbaseTables::Properties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragments for all base types in depth order: OclAny first, OclSelf last.
	 */
	public static class TypeFragments {
		static {
			Init.initStart();
			Properties.init();
		}

		private static final @NonNull FlatFragment @NonNull [] _BaseModel =
			{
				Fragments._BaseModel__OclAny /* 0 */,
				Fragments._BaseModel__OclElement /* 1 */,
				Fragments._BaseModel__Element /* 2 */,
				Fragments._BaseModel__NamedElement /* 3 */,
				Fragments._BaseModel__Namespace /* 4 */,
				Fragments._BaseModel__Model /* 5 */,
				Fragments._BaseModel__BaseModel /* 6 */
			};
		private static final int @NonNull [] __BaseModel = { 1,1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _CompoundTargetElement =
			{
				Fragments._CompoundTargetElement__OclAny /* 0 */,
				Fragments._CompoundTargetElement__OclElement /* 1 */,
				Fragments._CompoundTargetElement__Element /* 2 */,
				Fragments._CompoundTargetElement__TargetElement /* 3 */,
				Fragments._CompoundTargetElement__CompoundTargetElement /* 4 */
			};
		private static final int @NonNull [] __CompoundTargetElement = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Domain =
			{
				Fragments._Domain__OclAny /* 0 */,
				Fragments._Domain__OclElement /* 1 */,
				Fragments._Domain__Element /* 2 */,
				Fragments._Domain__ReferringElement /* 2 */,
				Fragments._Domain__NamedElement /* 3 */,
				Fragments._Domain__Domain /* 4 */
			};
		private static final int @NonNull [] __Domain = { 1,1,2,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Function =
			{
				Fragments._Function__OclAny /* 0 */,
				Fragments._Function__OclElement /* 1 */,
				Fragments._Function__Element /* 2 */,
				Fragments._Function__NamedElement /* 3 */,
				Fragments._Function__TemplateableElement /* 3 */,
				Fragments._Function__Namespace /* 4 */,
				Fragments._Function__TypedElement /* 4 */,
				Fragments._Function__Feature /* 5 */,
				Fragments._Function__Operation /* 6 */,
				Fragments._Function__Function /* 7 */
			};
		private static final int @NonNull [] __Function = { 1,1,1,2,2,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _FunctionBody =
			{
				Fragments._FunctionBody__OclAny /* 0 */,
				Fragments._FunctionBody__OclElement /* 1 */,
				Fragments._FunctionBody__Element /* 2 */,
				Fragments._FunctionBody__NamedElement /* 3 */,
				Fragments._FunctionBody__TypedElement /* 4 */,
				Fragments._FunctionBody__ValueSpecification /* 5 */,
				Fragments._FunctionBody__LanguageExpression /* 6 */,
				Fragments._FunctionBody__ExpressionInOCL /* 7 */,
				Fragments._FunctionBody__FunctionBody /* 8 */
			};
		private static final int @NonNull [] __FunctionBody = { 1,1,1,1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _FunctionParameter =
			{
				Fragments._FunctionParameter__OclAny /* 0 */,
				Fragments._FunctionParameter__OclElement /* 1 */,
				Fragments._FunctionParameter__Element /* 2 */,
				Fragments._FunctionParameter__NamedElement /* 3 */,
				Fragments._FunctionParameter__TypedElement /* 4 */,
				Fragments._FunctionParameter__VariableDeclaration /* 5 */,
				Fragments._FunctionParameter__Parameter /* 6 */,
				Fragments._FunctionParameter__FunctionParameter /* 7 */
			};
		private static final int @NonNull [] __FunctionParameter = { 1,1,1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Pattern =
			{
				Fragments._Pattern__OclAny /* 0 */,
				Fragments._Pattern__OclElement /* 1 */,
				Fragments._Pattern__Element /* 2 */,
				Fragments._Pattern__Pattern /* 3 */
			};
		private static final int @NonNull [] __Pattern = { 1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Predicate =
			{
				Fragments._Predicate__OclAny /* 0 */,
				Fragments._Predicate__OclElement /* 1 */,
				Fragments._Predicate__Element /* 2 */,
				Fragments._Predicate__Predicate /* 3 */
			};
		private static final int @NonNull [] __Predicate = { 1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Rule =
			{
				Fragments._Rule__OclAny /* 0 */,
				Fragments._Rule__OclElement /* 1 */,
				Fragments._Rule__Element /* 2 */,
				Fragments._Rule__NamedElement /* 3 */,
				Fragments._Rule__Rule /* 4 */
			};
		private static final int @NonNull [] __Rule = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _SimpleTargetElement =
			{
				Fragments._SimpleTargetElement__OclAny /* 0 */,
				Fragments._SimpleTargetElement__OclElement /* 1 */,
				Fragments._SimpleTargetElement__Element /* 2 */,
				Fragments._SimpleTargetElement__TargetElement /* 3 */,
				Fragments._SimpleTargetElement__SimpleTargetElement /* 4 */
			};
		private static final int @NonNull [] __SimpleTargetElement = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Target =
			{
				Fragments._Target__OclAny /* 0 */,
				Fragments._Target__OclElement /* 1 */,
				Fragments._Target__Element /* 2 */,
				Fragments._Target__NamedElement /* 3 */,
				Fragments._Target__Target /* 4 */
			};
		private static final int @NonNull [] __Target = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _TargetElement =
			{
				Fragments._TargetElement__OclAny /* 0 */,
				Fragments._TargetElement__OclElement /* 1 */,
				Fragments._TargetElement__Element /* 2 */,
				Fragments._TargetElement__TargetElement /* 3 */
			};
		private static final int @NonNull [] __TargetElement = { 1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _TargetElementKind =
			{
				Fragments._TargetElementKind__OclAny /* 0 */,
				Fragments._TargetElementKind__OclElement /* 1 */,
				Fragments._TargetElementKind__OclType /* 2 */,
				Fragments._TargetElementKind__OclEnumeration /* 3 */,
				Fragments._TargetElementKind__TargetElementKind /* 4 */
			};
		private static final int @NonNull [] __TargetElementKind = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Transformation =
			{
				Fragments._Transformation__OclAny /* 0 */,
				Fragments._Transformation__OclElement /* 1 */,
				Fragments._Transformation__Element /* 2 */,
				Fragments._Transformation__OclType /* 2 */,
				Fragments._Transformation__NamedElement /* 3 */,
				Fragments._Transformation__TemplateableElement /* 3 */,
				Fragments._Transformation__Namespace /* 4 */,
				Fragments._Transformation__Type /* 4 */,
				Fragments._Transformation__Class /* 5 */,
				Fragments._Transformation__Transformation /* 6 */
			};
		private static final int @NonNull [] __Transformation = { 1,1,2,2,2,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _TypedModel =
			{
				Fragments._TypedModel__OclAny /* 0 */,
				Fragments._TypedModel__OclElement /* 1 */,
				Fragments._TypedModel__Element /* 2 */,
				Fragments._TypedModel__NamedElement /* 3 */,
				Fragments._TypedModel__TypedModel /* 4 */
			};
		private static final int @NonNull [] __TypedModel = { 1,1,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._BaseModel.initFragments(_BaseModel, __BaseModel);
			Types._CompoundTargetElement.initFragments(_CompoundTargetElement, __CompoundTargetElement);
			Types._Domain.initFragments(_Domain, __Domain);
			Types._Function.initFragments(_Function, __Function);
			Types._FunctionBody.initFragments(_FunctionBody, __FunctionBody);
			Types._FunctionParameter.initFragments(_FunctionParameter, __FunctionParameter);
			Types._Pattern.initFragments(_Pattern, __Pattern);
			Types._Predicate.initFragments(_Predicate, __Predicate);
			Types._Rule.initFragments(_Rule, __Rule);
			Types._SimpleTargetElement.initFragments(_SimpleTargetElement, __SimpleTargetElement);
			Types._Target.initFragments(_Target, __Target);
			Types._TargetElement.initFragments(_TargetElement, __TargetElement);
			Types._TargetElementKind.initFragments(_TargetElementKind, __TargetElementKind);
			Types._Transformation.initFragments(_Transformation, __Transformation);
			Types._TypedModel.initFragments(_TypedModel, __TypedModel);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTbaseTables::TypeFragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local operations or local operation overrides for each fragment of each type.
	 */
	public static class FragmentOperations {
		static {
			Init.initStart();
			TypeFragments.init();
		}

		private static final @NonNull Operation @NonNull [] _BaseModel__BaseModel = {};
		private static final @NonNull Operation @NonNull [] _BaseModel__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _BaseModel__Model = {};
		private static final @NonNull Operation @NonNull [] _BaseModel__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _BaseModel__Namespace = {};
		private static final @NonNull Operation @NonNull [] _BaseModel__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _BaseModel__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull Operation @NonNull [] _CompoundTargetElement__CompoundTargetElement = {};
		private static final @NonNull Operation @NonNull [] _CompoundTargetElement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _CompoundTargetElement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _CompoundTargetElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _CompoundTargetElement__TargetElement = {};

		private static final @NonNull Operation @NonNull [] _Domain__Domain = {};
		private static final @NonNull Operation @NonNull [] _Domain__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _Domain__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _Domain__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Domain__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _Domain__ReferringElement = {
			PivotTables.Operations._ReferringElement__getReferredElement /* getReferredElement() */
		};

		private static final @NonNull Operation @NonNull [] _Function__Function = {};
		private static final @NonNull Operation @NonNull [] _Function__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _Function__Feature = {};
		private static final @NonNull Operation @NonNull [] _Function__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _Function__Namespace = {};
		private static final @NonNull Operation @NonNull [] _Function__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Function__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _Function__Operation = {};
		private static final @NonNull Operation @NonNull [] _Function__TemplateableElement = {};
		private static final @NonNull Operation @NonNull [] _Function__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};

		private static final @NonNull Operation @NonNull [] _FunctionBody__FunctionBody = {};
		private static final @NonNull Operation @NonNull [] _FunctionBody__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _FunctionBody__ExpressionInOCL = {};
		private static final @NonNull Operation @NonNull [] _FunctionBody__LanguageExpression = {};
		private static final @NonNull Operation @NonNull [] _FunctionBody__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _FunctionBody__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _FunctionBody__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _FunctionBody__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull Operation @NonNull [] _FunctionBody__ValueSpecification = {
			PivotTables.Operations._ValueSpecification__booleanValue /* booleanValue() */,
			PivotTables.Operations._ValueSpecification__integerValue /* integerValue() */,
			PivotTables.Operations._ValueSpecification__isComputable /* isComputable() */,
			PivotTables.Operations._ValueSpecification__isNull /* isNull() */,
			PivotTables.Operations._ValueSpecification__stringValue /* stringValue() */,
			PivotTables.Operations._ValueSpecification__unlimitedValue /* unlimitedValue() */
		};

		private static final @NonNull Operation @NonNull [] _FunctionParameter__FunctionParameter = {};
		private static final @NonNull Operation @NonNull [] _FunctionParameter__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _FunctionParameter__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _FunctionParameter__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _FunctionParameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _FunctionParameter__Parameter = {};
		private static final @NonNull Operation @NonNull [] _FunctionParameter__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull Operation @NonNull [] _FunctionParameter__VariableDeclaration = {};

		private static final @NonNull Operation @NonNull [] _Pattern__Pattern = {};
		private static final @NonNull Operation @NonNull [] _Pattern__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _Pattern__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Pattern__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull Operation @NonNull [] _Predicate__Predicate = {};
		private static final @NonNull Operation @NonNull [] _Predicate__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _Predicate__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Predicate__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull Operation @NonNull [] _Rule__Rule = {};
		private static final @NonNull Operation @NonNull [] _Rule__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _Rule__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _Rule__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Rule__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull Operation @NonNull [] _SimpleTargetElement__SimpleTargetElement = {};
		private static final @NonNull Operation @NonNull [] _SimpleTargetElement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _SimpleTargetElement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _SimpleTargetElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _SimpleTargetElement__TargetElement = {};

		private static final @NonNull Operation @NonNull [] _Target__Target = {};
		private static final @NonNull Operation @NonNull [] _Target__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _Target__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _Target__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Target__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull Operation @NonNull [] _TargetElement__TargetElement = {};
		private static final @NonNull Operation @NonNull [] _TargetElement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _TargetElement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _TargetElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull Operation @NonNull [] _TargetElementKind__TargetElementKind = {};
		private static final @NonNull Operation @NonNull [] _TargetElementKind__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _TargetElementKind__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _TargetElementKind__OclEnumeration = {};
		private static final @NonNull Operation @NonNull [] _TargetElementKind__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final @NonNull Operation @NonNull [] _Transformation__Transformation = {
			Operations._Transformation__getFunction /* getFunction(String[1]) */,
			Operations._Transformation__getModelParameter /* getModelParameter(String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _Transformation__Class = {
			PivotTables.Operations._Class__allInstances /* allInstances() */
		};
		private static final @NonNull Operation @NonNull [] _Transformation__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _Transformation__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _Transformation__Namespace = {};
		private static final @NonNull Operation @NonNull [] _Transformation__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Transformation__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _Transformation__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};
		private static final @NonNull Operation @NonNull [] _Transformation__TemplateableElement = {};
		private static final @NonNull Operation @NonNull [] _Transformation__Type = {
			PivotTables.Operations._Type__conformsTo /* conformsTo(Type[?]) */,
			PivotTables.Operations._Type__flattenedType /* flattenedType() */,
			PivotTables.Operations._Type__isClass /* isClass() */,
			PivotTables.Operations._Type__isTemplateParameter /* isTemplateParameter() */,
			PivotTables.Operations._Type__specializeIn /* specializeIn(CallExp[1],Type[1]) */
		};

		private static final @NonNull Operation @NonNull [] _TypedModel__TypedModel = {};
		private static final @NonNull Operation @NonNull [] _TypedModel__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _TypedModel__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _TypedModel__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _TypedModel__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._BaseModel__BaseModel.initOperations(_BaseModel__BaseModel);
			Fragments._BaseModel__Element.initOperations(_BaseModel__Element);
			Fragments._BaseModel__Model.initOperations(_BaseModel__Model);
			Fragments._BaseModel__NamedElement.initOperations(_BaseModel__NamedElement);
			Fragments._BaseModel__Namespace.initOperations(_BaseModel__Namespace);
			Fragments._BaseModel__OclAny.initOperations(_BaseModel__OclAny);
			Fragments._BaseModel__OclElement.initOperations(_BaseModel__OclElement);

			Fragments._CompoundTargetElement__CompoundTargetElement.initOperations(_CompoundTargetElement__CompoundTargetElement);
			Fragments._CompoundTargetElement__Element.initOperations(_CompoundTargetElement__Element);
			Fragments._CompoundTargetElement__OclAny.initOperations(_CompoundTargetElement__OclAny);
			Fragments._CompoundTargetElement__OclElement.initOperations(_CompoundTargetElement__OclElement);
			Fragments._CompoundTargetElement__TargetElement.initOperations(_CompoundTargetElement__TargetElement);

			Fragments._Domain__Domain.initOperations(_Domain__Domain);
			Fragments._Domain__Element.initOperations(_Domain__Element);
			Fragments._Domain__NamedElement.initOperations(_Domain__NamedElement);
			Fragments._Domain__OclAny.initOperations(_Domain__OclAny);
			Fragments._Domain__OclElement.initOperations(_Domain__OclElement);
			Fragments._Domain__ReferringElement.initOperations(_Domain__ReferringElement);

			Fragments._Function__Element.initOperations(_Function__Element);
			Fragments._Function__Feature.initOperations(_Function__Feature);
			Fragments._Function__Function.initOperations(_Function__Function);
			Fragments._Function__NamedElement.initOperations(_Function__NamedElement);
			Fragments._Function__Namespace.initOperations(_Function__Namespace);
			Fragments._Function__OclAny.initOperations(_Function__OclAny);
			Fragments._Function__OclElement.initOperations(_Function__OclElement);
			Fragments._Function__Operation.initOperations(_Function__Operation);
			Fragments._Function__TemplateableElement.initOperations(_Function__TemplateableElement);
			Fragments._Function__TypedElement.initOperations(_Function__TypedElement);

			Fragments._FunctionBody__Element.initOperations(_FunctionBody__Element);
			Fragments._FunctionBody__ExpressionInOCL.initOperations(_FunctionBody__ExpressionInOCL);
			Fragments._FunctionBody__FunctionBody.initOperations(_FunctionBody__FunctionBody);
			Fragments._FunctionBody__LanguageExpression.initOperations(_FunctionBody__LanguageExpression);
			Fragments._FunctionBody__NamedElement.initOperations(_FunctionBody__NamedElement);
			Fragments._FunctionBody__OclAny.initOperations(_FunctionBody__OclAny);
			Fragments._FunctionBody__OclElement.initOperations(_FunctionBody__OclElement);
			Fragments._FunctionBody__TypedElement.initOperations(_FunctionBody__TypedElement);
			Fragments._FunctionBody__ValueSpecification.initOperations(_FunctionBody__ValueSpecification);

			Fragments._FunctionParameter__Element.initOperations(_FunctionParameter__Element);
			Fragments._FunctionParameter__FunctionParameter.initOperations(_FunctionParameter__FunctionParameter);
			Fragments._FunctionParameter__NamedElement.initOperations(_FunctionParameter__NamedElement);
			Fragments._FunctionParameter__OclAny.initOperations(_FunctionParameter__OclAny);
			Fragments._FunctionParameter__OclElement.initOperations(_FunctionParameter__OclElement);
			Fragments._FunctionParameter__Parameter.initOperations(_FunctionParameter__Parameter);
			Fragments._FunctionParameter__TypedElement.initOperations(_FunctionParameter__TypedElement);
			Fragments._FunctionParameter__VariableDeclaration.initOperations(_FunctionParameter__VariableDeclaration);

			Fragments._Pattern__Element.initOperations(_Pattern__Element);
			Fragments._Pattern__OclAny.initOperations(_Pattern__OclAny);
			Fragments._Pattern__OclElement.initOperations(_Pattern__OclElement);
			Fragments._Pattern__Pattern.initOperations(_Pattern__Pattern);

			Fragments._Predicate__Element.initOperations(_Predicate__Element);
			Fragments._Predicate__OclAny.initOperations(_Predicate__OclAny);
			Fragments._Predicate__OclElement.initOperations(_Predicate__OclElement);
			Fragments._Predicate__Predicate.initOperations(_Predicate__Predicate);

			Fragments._Rule__Element.initOperations(_Rule__Element);
			Fragments._Rule__NamedElement.initOperations(_Rule__NamedElement);
			Fragments._Rule__OclAny.initOperations(_Rule__OclAny);
			Fragments._Rule__OclElement.initOperations(_Rule__OclElement);
			Fragments._Rule__Rule.initOperations(_Rule__Rule);

			Fragments._SimpleTargetElement__Element.initOperations(_SimpleTargetElement__Element);
			Fragments._SimpleTargetElement__OclAny.initOperations(_SimpleTargetElement__OclAny);
			Fragments._SimpleTargetElement__OclElement.initOperations(_SimpleTargetElement__OclElement);
			Fragments._SimpleTargetElement__SimpleTargetElement.initOperations(_SimpleTargetElement__SimpleTargetElement);
			Fragments._SimpleTargetElement__TargetElement.initOperations(_SimpleTargetElement__TargetElement);

			Fragments._Target__Element.initOperations(_Target__Element);
			Fragments._Target__NamedElement.initOperations(_Target__NamedElement);
			Fragments._Target__OclAny.initOperations(_Target__OclAny);
			Fragments._Target__OclElement.initOperations(_Target__OclElement);
			Fragments._Target__Target.initOperations(_Target__Target);

			Fragments._TargetElement__Element.initOperations(_TargetElement__Element);
			Fragments._TargetElement__OclAny.initOperations(_TargetElement__OclAny);
			Fragments._TargetElement__OclElement.initOperations(_TargetElement__OclElement);
			Fragments._TargetElement__TargetElement.initOperations(_TargetElement__TargetElement);

			Fragments._TargetElementKind__OclAny.initOperations(_TargetElementKind__OclAny);
			Fragments._TargetElementKind__OclElement.initOperations(_TargetElementKind__OclElement);
			Fragments._TargetElementKind__OclEnumeration.initOperations(_TargetElementKind__OclEnumeration);
			Fragments._TargetElementKind__OclType.initOperations(_TargetElementKind__OclType);
			Fragments._TargetElementKind__TargetElementKind.initOperations(_TargetElementKind__TargetElementKind);

			Fragments._Transformation__Class.initOperations(_Transformation__Class);
			Fragments._Transformation__Element.initOperations(_Transformation__Element);
			Fragments._Transformation__NamedElement.initOperations(_Transformation__NamedElement);
			Fragments._Transformation__Namespace.initOperations(_Transformation__Namespace);
			Fragments._Transformation__OclAny.initOperations(_Transformation__OclAny);
			Fragments._Transformation__OclElement.initOperations(_Transformation__OclElement);
			Fragments._Transformation__OclType.initOperations(_Transformation__OclType);
			Fragments._Transformation__TemplateableElement.initOperations(_Transformation__TemplateableElement);
			Fragments._Transformation__Transformation.initOperations(_Transformation__Transformation);
			Fragments._Transformation__Type.initOperations(_Transformation__Type);

			Fragments._TypedModel__Element.initOperations(_TypedModel__Element);
			Fragments._TypedModel__NamedElement.initOperations(_TypedModel__NamedElement);
			Fragments._TypedModel__OclAny.initOperations(_TypedModel__OclAny);
			Fragments._TypedModel__OclElement.initOperations(_TypedModel__OclElement);
			Fragments._TypedModel__TypedModel.initOperations(_TypedModel__TypedModel);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTbaseTables::FragmentOperations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local properties for the local fragment of each type.
	 */
	public static class FragmentProperties {
		static {
			Init.initStart();
			FragmentOperations.init();
		}

		private static final @NonNull Property @NonNull [] _BaseModel = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._Model__externalURI,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Namespace__ownedConstraints,
			PivotTables.Properties._Element__ownedExtensions,
			PivotTables.Properties._Model__ownedImports,
			PivotTables.Properties._Model__ownedPackages,
			PivotTables.Properties._Model__xmiidVersion
		};

		private static final @NonNull Property @NonNull [] _CompoundTargetElement = {
			PivotTables.Properties._Element__annotatingComments,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._CompoundTargetElement__ownedTargetElements
		};

		private static final @NonNull Property @NonNull [] _Domain = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Domain__isCheckable,
			Properties._Domain__isEnforceable,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Domain__rule,
			Properties._Domain__typedModel
		};

		private static final @NonNull Property @NonNull [] _Function = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._Operation__bodyExpression,
			PivotTables.Properties._Feature__implementation,
			PivotTables.Properties._Feature__implementationClass,
			PivotTables.Properties._Operation__isInvalidating,
			PivotTables.Properties._TypedElement__isMany,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._Feature__isStatic,
			PivotTables.Properties._Operation__isTransient,
			PivotTables.Properties._Operation__isTypeof,
			PivotTables.Properties._Operation__isValidating,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._TemplateableElement__ownedBindings,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Namespace__ownedConstraints,
			PivotTables.Properties._Element__ownedExtensions,
			PivotTables.Properties._Operation__ownedParameters,
			PivotTables.Properties._Operation__ownedPostconditions,
			PivotTables.Properties._Operation__ownedPreconditions,
			PivotTables.Properties._TemplateableElement__ownedSignature,
			PivotTables.Properties._Operation__owningClass,
			PivotTables.Properties._Operation__precedence,
			Properties._Function__queryExpression,
			PivotTables.Properties._Operation__raisedExceptions,
			PivotTables.Properties._Operation__redefinedOperations,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull Property @NonNull [] _FunctionBody = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._LanguageExpression__body,
			PivotTables.Properties._TypedElement__isMany,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._LanguageExpression__language,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._ExpressionInOCL__ownedBody,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._ExpressionInOCL__ownedContext,
			PivotTables.Properties._Element__ownedExtensions,
			PivotTables.Properties._ExpressionInOCL__ownedParameters,
			PivotTables.Properties._ExpressionInOCL__ownedResult,
			PivotTables.Properties._LanguageExpression__owningConstraint,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _FunctionParameter = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._TypedElement__isMany,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._Parameter__isTypeof,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			PivotTables.Properties._Parameter__owningOperation,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._VariableDeclaration__typeValue
		};

		private static final @NonNull Property @NonNull [] _Pattern = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Pattern__bindsTo,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Pattern__predicate
		};

		private static final @NonNull Property @NonNull [] _Predicate = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Predicate__conditionExpression,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Predicate__pattern
		};

		private static final @NonNull Property @NonNull [] _Rule = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Rule__domain,
			Properties._Rule__isAbstract,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Rule__overridden,
			Properties._Rule__overrides,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			Properties._Rule__ownedContext,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Rule__transformation
		};

		private static final @NonNull Property @NonNull [] _SimpleTargetElement = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._SimpleTargetElement__iterates,
			Properties._SimpleTargetElement__kind,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._SimpleTargetElement__typedModel
		};

		private static final @NonNull Property @NonNull [] _Target = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Target__ownedTargetElements,
			Properties._Target__owningTransformation
		};

		private static final @NonNull Property @NonNull [] _TargetElement = {
			PivotTables.Properties._Element__annotatingComments,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions
		};

		private static final @NonNull Property @NonNull [] _TargetElementKind = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _Transformation = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._Class__extenders,
			Properties._Transformation__extends,
			PivotTables.Properties._Class__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isActive,
			PivotTables.Properties._Class__isInterface,
			Properties._Transformation__modelParameter,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Class__ownedBehaviors,
			PivotTables.Properties._TemplateableElement__ownedBindings,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Namespace__ownedConstraints,
			Properties._Transformation__ownedContext,
			PivotTables.Properties._Element__ownedExtensions,
			PivotTables.Properties._Class__ownedInvariants,
			PivotTables.Properties._Class__ownedOperations,
			PivotTables.Properties._Class__ownedProperties,
			PivotTables.Properties._TemplateableElement__ownedSignature,
			Properties._Transformation__ownedTag,
			Properties._Transformation__ownedTargets,
			PivotTables.Properties._Class__owningPackage,
			Properties._Transformation__rule,
			PivotTables.Properties._Class__superClasses,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull Property @NonNull [] _TypedModel = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._TypedModel__dependsOn,
			Properties._TypedModel__isPrimitive,
			Properties._TypedModel__isThis,
			Properties._TypedModel__isTrace,
			Properties._TypedModel__iterates,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			Properties._TypedModel__ownedContext,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._TypedModel__transformation,
			Properties._TypedModel__usedPackage
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._BaseModel__BaseModel.initProperties(_BaseModel);
			Fragments._CompoundTargetElement__CompoundTargetElement.initProperties(_CompoundTargetElement);
			Fragments._Domain__Domain.initProperties(_Domain);
			Fragments._Function__Function.initProperties(_Function);
			Fragments._FunctionBody__FunctionBody.initProperties(_FunctionBody);
			Fragments._FunctionParameter__FunctionParameter.initProperties(_FunctionParameter);
			Fragments._Pattern__Pattern.initProperties(_Pattern);
			Fragments._Predicate__Predicate.initProperties(_Predicate);
			Fragments._Rule__Rule.initProperties(_Rule);
			Fragments._SimpleTargetElement__SimpleTargetElement.initProperties(_SimpleTargetElement);
			Fragments._Target__Target.initProperties(_Target);
			Fragments._TargetElement__TargetElement.initProperties(_TargetElement);
			Fragments._TargetElementKind__TargetElementKind.initProperties(_TargetElementKind);
			Fragments._Transformation__Transformation.initProperties(_Transformation);
			Fragments._TypedModel__TypedModel.initProperties(_TypedModel);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTbaseTables::FragmentProperties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of enumeration literals for each enumeration.
	 */
	public static class EnumerationLiterals {
		static {
			Init.initStart();
			FragmentProperties.init();
		}

		public static final @NonNull EnumerationLiteral _TargetElementKind__INPUT = LIBRARY.createEnumerationLiteral(QVTbasePackage.Literals.TARGET_ELEMENT_KIND.getEEnumLiteral("INPUT"), Types._TargetElementKind, 0);
		public static final @NonNull EnumerationLiteral _TargetElementKind__VIA = LIBRARY.createEnumerationLiteral(QVTbasePackage.Literals.TARGET_ELEMENT_KIND.getEEnumLiteral("VIA"), Types._TargetElementKind, 1);
		public static final @NonNull EnumerationLiteral _TargetElementKind__OUTPUT = LIBRARY.createEnumerationLiteral(QVTbasePackage.Literals.TARGET_ELEMENT_KIND.getEEnumLiteral("OUTPUT"), Types._TargetElementKind, 2);
		private static final @NonNull EnumerationLiteral @NonNull [] _TargetElementKind = {
			_TargetElementKind__INPUT,
			_TargetElementKind__VIA,
			_TargetElementKind__OUTPUT
		};

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {
			LIBRARY.initLiterals(Types._TargetElementKind, _TargetElementKind);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTbaseTables::EnumerationLiterals and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 * The multiple packages above avoid problems with the Java 65536 byte limit but introduce a difficulty in ensuring that
	 * static construction occurs in the disciplined order of the packages when construction may start in any of the packages.
	 * The problem is resolved by ensuring that the static construction of each package first initializes its immediate predecessor.
	 * On completion of predecessor initialization, the residual packages are initialized by starting an initialization in the last package.
	 * This class maintains a count so that the various predecessors can distinguish whether they are the starting point and so
	 * ensure that residual construction occurs just once after all predecessors.
	 */
	private static class Init {
		/**
		 * Counter of nested static constructions. On return to zero residual construction starts. -ve once residual construction started.
		 */
		private static int initCount = 0;

		/**
		 * Invoked at the start of a static construction to defer residual construction until primary constructions complete.
		 */
		private static void initStart() {
			if (initCount >= 0) {
				initCount++;
			}
		}

		/**
		 * Invoked at the end of a static construction to activate residual construction once primary constructions complete.
		 */
		private static void initEnd() {
			if (initCount > 0) {
				if (--initCount == 0) {
					initCount = -1;
					EnumerationLiterals.init();
					LIBRARY.freeze(RESOURCE);
				}
			}
		}
	}

	static {
		Init.initEnd();
	}

	/*
	 * Force initialization of outer fields. Inner fields are lazily initialized.
	 */
	public static void init() {
		new QVTbaseTables();
	}

	private QVTbaseTables() {
		super(QVTbasePackage.eNS_URI);
	}
}
