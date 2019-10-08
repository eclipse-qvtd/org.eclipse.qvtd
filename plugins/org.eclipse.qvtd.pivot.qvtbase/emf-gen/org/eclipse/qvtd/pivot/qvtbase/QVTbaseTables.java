/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ParameterTypes;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreLibraryOppositeProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorFragment;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorOperation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorPropertyWithImplementation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorType;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables;

/**
 * QVTbaseTables provides the dispatch tables for the qvtbase for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
public class QVTbaseTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final @NonNull EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(QVTbasePackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final @NonNull ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbase", null, QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Annotation = QVTbaseTables.PACKid_$metamodel$.getClassId("Annotation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = QVTbaseTables.PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Domain = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Domain", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Function = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Function", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_FunctionParameter = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("FunctionParameter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OCLExpression = QVTbaseTables.PACKid_$metamodel$.getClassId("OCLExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclElement = QVTbaseTables.PACKid_$metamodel$.getClassId("OclElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Package = QVTbaseTables.PACKid_$metamodel$.getClassId("Package", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Parameter = QVTbaseTables.PACKid_$metamodel$.getClassId("Parameter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Pattern = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Pattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Predicate = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Predicate", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Rule = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Rule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Transformation = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Transformation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Type = QVTbaseTables.PACKid_$metamodel$.getClassId("Type", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TypedModel = QVTbaseTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("TypedModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Variable = QVTbaseTables.PACKid_$metamodel$.getClassId("Variable", 0);
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_0 = ValueUtil.integerValueOf("0");
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_1 = ValueUtil.integerValueOf("1");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_PRIMid_String = TypeId.SEQUENCE.getSpecializedId(TypeId.STRING);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_Domain = TypeId.BAG.getSpecializedId(QVTbaseTables.CLSSid_Domain);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Domain = TypeId.ORDERED_SET.getSpecializedId(QVTbaseTables.CLSSid_Domain);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Parameter = TypeId.ORDERED_SET.getSpecializedId(QVTbaseTables.CLSSid_Parameter);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Rule = TypeId.ORDERED_SET.getSpecializedId(QVTbaseTables.CLSSid_Rule);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_TypedModel = TypeId.ORDERED_SET.getSpecializedId(QVTbaseTables.CLSSid_TypedModel);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Package = TypeId.SEQUENCE.getSpecializedId(QVTbaseTables.CLSSid_Package);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Annotation = TypeId.SET.getSpecializedId(QVTbaseTables.CLSSid_Annotation);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Package = TypeId.SET.getSpecializedId(QVTbaseTables.CLSSid_Package);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Predicate = TypeId.SET.getSpecializedId(QVTbaseTables.CLSSid_Predicate);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Rule = TypeId.SET.getSpecializedId(QVTbaseTables.CLSSid_Rule);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Transformation = TypeId.SET.getSpecializedId(QVTbaseTables.CLSSid_Transformation);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_TypedModel = TypeId.SET.getSpecializedId(QVTbaseTables.CLSSid_TypedModel);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Variable = TypeId.SET.getSpecializedId(QVTbaseTables.CLSSid_Variable);

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

		public static final @NonNull EcoreExecutorType _BaseModel = new EcoreExecutorType(QVTbasePackage.Literals.BASE_MODEL, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Domain = new EcoreExecutorType(QVTbasePackage.Literals.DOMAIN, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _Function = new EcoreExecutorType(QVTbasePackage.Literals.FUNCTION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _FunctionBody = new EcoreExecutorType(QVTbasePackage.Literals.FUNCTION_BODY, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _FunctionParameter = new EcoreExecutorType(QVTbasePackage.Literals.FUNCTION_PARAMETER, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Pattern = new EcoreExecutorType(QVTbasePackage.Literals.PATTERN, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Predicate = new EcoreExecutorType(QVTbasePackage.Literals.PREDICATE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Rule = new EcoreExecutorType(QVTbasePackage.Literals.RULE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _Transformation = new EcoreExecutorType(QVTbasePackage.Literals.TRANSFORMATION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TypedModel = new EcoreExecutorType(QVTbasePackage.Literals.TYPED_MODEL, PACKAGE, 0);

		private static final @NonNull EcoreExecutorType @NonNull [] types = {
			_BaseModel,
			_Domain,
			_Function,
			_FunctionBody,
			_FunctionParameter,
			_Pattern,
			_Predicate,
			_Rule,
			_Transformation,
			_TypedModel
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
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

		private static final @NonNull ExecutorFragment _BaseModel__BaseModel = new ExecutorFragment(Types._BaseModel, QVTbaseTables.Types._BaseModel);
		private static final @NonNull ExecutorFragment _BaseModel__Element = new ExecutorFragment(Types._BaseModel, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _BaseModel__Model = new ExecutorFragment(Types._BaseModel, PivotTables.Types._Model);
		private static final @NonNull ExecutorFragment _BaseModel__NamedElement = new ExecutorFragment(Types._BaseModel, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _BaseModel__Namespace = new ExecutorFragment(Types._BaseModel, PivotTables.Types._Namespace);
		private static final @NonNull ExecutorFragment _BaseModel__OclAny = new ExecutorFragment(Types._BaseModel, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _BaseModel__OclElement = new ExecutorFragment(Types._BaseModel, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _Domain__Domain = new ExecutorFragment(Types._Domain, QVTbaseTables.Types._Domain);
		private static final @NonNull ExecutorFragment _Domain__Element = new ExecutorFragment(Types._Domain, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Domain__NamedElement = new ExecutorFragment(Types._Domain, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Domain__OclAny = new ExecutorFragment(Types._Domain, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Domain__OclElement = new ExecutorFragment(Types._Domain, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Domain__ReferringElement = new ExecutorFragment(Types._Domain, PivotTables.Types._ReferringElement);

		private static final @NonNull ExecutorFragment _Function__Element = new ExecutorFragment(Types._Function, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Function__Feature = new ExecutorFragment(Types._Function, PivotTables.Types._Feature);
		private static final @NonNull ExecutorFragment _Function__Function = new ExecutorFragment(Types._Function, QVTbaseTables.Types._Function);
		private static final @NonNull ExecutorFragment _Function__NamedElement = new ExecutorFragment(Types._Function, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Function__Namespace = new ExecutorFragment(Types._Function, PivotTables.Types._Namespace);
		private static final @NonNull ExecutorFragment _Function__OclAny = new ExecutorFragment(Types._Function, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Function__OclElement = new ExecutorFragment(Types._Function, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Function__Operation = new ExecutorFragment(Types._Function, PivotTables.Types._Operation);
		private static final @NonNull ExecutorFragment _Function__TemplateableElement = new ExecutorFragment(Types._Function, PivotTables.Types._TemplateableElement);
		private static final @NonNull ExecutorFragment _Function__TypedElement = new ExecutorFragment(Types._Function, PivotTables.Types._TypedElement);

		private static final @NonNull ExecutorFragment _FunctionBody__Element = new ExecutorFragment(Types._FunctionBody, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _FunctionBody__ExpressionInOCL = new ExecutorFragment(Types._FunctionBody, PivotTables.Types._ExpressionInOCL);
		private static final @NonNull ExecutorFragment _FunctionBody__FunctionBody = new ExecutorFragment(Types._FunctionBody, QVTbaseTables.Types._FunctionBody);
		private static final @NonNull ExecutorFragment _FunctionBody__LanguageExpression = new ExecutorFragment(Types._FunctionBody, PivotTables.Types._LanguageExpression);
		private static final @NonNull ExecutorFragment _FunctionBody__NamedElement = new ExecutorFragment(Types._FunctionBody, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _FunctionBody__OclAny = new ExecutorFragment(Types._FunctionBody, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _FunctionBody__OclElement = new ExecutorFragment(Types._FunctionBody, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _FunctionBody__TypedElement = new ExecutorFragment(Types._FunctionBody, PivotTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _FunctionBody__ValueSpecification = new ExecutorFragment(Types._FunctionBody, PivotTables.Types._ValueSpecification);

		private static final @NonNull ExecutorFragment _FunctionParameter__Element = new ExecutorFragment(Types._FunctionParameter, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _FunctionParameter__FunctionParameter = new ExecutorFragment(Types._FunctionParameter, QVTbaseTables.Types._FunctionParameter);
		private static final @NonNull ExecutorFragment _FunctionParameter__NamedElement = new ExecutorFragment(Types._FunctionParameter, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _FunctionParameter__OclAny = new ExecutorFragment(Types._FunctionParameter, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _FunctionParameter__OclElement = new ExecutorFragment(Types._FunctionParameter, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _FunctionParameter__Parameter = new ExecutorFragment(Types._FunctionParameter, PivotTables.Types._Parameter);
		private static final @NonNull ExecutorFragment _FunctionParameter__TypedElement = new ExecutorFragment(Types._FunctionParameter, PivotTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _FunctionParameter__VariableDeclaration = new ExecutorFragment(Types._FunctionParameter, PivotTables.Types._VariableDeclaration);

		private static final @NonNull ExecutorFragment _Pattern__Element = new ExecutorFragment(Types._Pattern, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Pattern__OclAny = new ExecutorFragment(Types._Pattern, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Pattern__OclElement = new ExecutorFragment(Types._Pattern, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Pattern__Pattern = new ExecutorFragment(Types._Pattern, QVTbaseTables.Types._Pattern);

		private static final @NonNull ExecutorFragment _Predicate__Element = new ExecutorFragment(Types._Predicate, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Predicate__OclAny = new ExecutorFragment(Types._Predicate, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Predicate__OclElement = new ExecutorFragment(Types._Predicate, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Predicate__Predicate = new ExecutorFragment(Types._Predicate, QVTbaseTables.Types._Predicate);

		private static final @NonNull ExecutorFragment _Rule__Element = new ExecutorFragment(Types._Rule, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Rule__NamedElement = new ExecutorFragment(Types._Rule, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Rule__OclAny = new ExecutorFragment(Types._Rule, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Rule__OclElement = new ExecutorFragment(Types._Rule, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Rule__Rule = new ExecutorFragment(Types._Rule, QVTbaseTables.Types._Rule);

		private static final @NonNull ExecutorFragment _Transformation__Class = new ExecutorFragment(Types._Transformation, PivotTables.Types._Class);
		private static final @NonNull ExecutorFragment _Transformation__Element = new ExecutorFragment(Types._Transformation, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Transformation__NamedElement = new ExecutorFragment(Types._Transformation, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Transformation__Namespace = new ExecutorFragment(Types._Transformation, PivotTables.Types._Namespace);
		private static final @NonNull ExecutorFragment _Transformation__OclAny = new ExecutorFragment(Types._Transformation, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Transformation__OclElement = new ExecutorFragment(Types._Transformation, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Transformation__OclType = new ExecutorFragment(Types._Transformation, OCLstdlibTables.Types._OclType);
		private static final @NonNull ExecutorFragment _Transformation__TemplateableElement = new ExecutorFragment(Types._Transformation, PivotTables.Types._TemplateableElement);
		private static final @NonNull ExecutorFragment _Transformation__Transformation = new ExecutorFragment(Types._Transformation, QVTbaseTables.Types._Transformation);
		private static final @NonNull ExecutorFragment _Transformation__Type = new ExecutorFragment(Types._Transformation, PivotTables.Types._Type);

		private static final @NonNull ExecutorFragment _TypedModel__Element = new ExecutorFragment(Types._TypedModel, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _TypedModel__NamedElement = new ExecutorFragment(Types._TypedModel, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _TypedModel__OclAny = new ExecutorFragment(Types._TypedModel, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _TypedModel__OclElement = new ExecutorFragment(Types._TypedModel, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _TypedModel__TypedModel = new ExecutorFragment(Types._TypedModel, QVTbaseTables.Types._TypedModel);

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

		public static final @NonNull ParameterTypes _String = TypeUtil.createParameterTypes(OCLstdlibTables.Types._String);

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

		public static final @NonNull ExecutorOperation _Transformation__getFunction = new ExecutorOperation("getFunction", Parameters._String, Types._Transformation,
			0, TemplateParameters.EMPTY_LIST, null);
		public static final @NonNull ExecutorOperation _Transformation__getModelParameter = new ExecutorOperation("getModelParameter", Parameters._String, Types._Transformation,
			1, TemplateParameters.EMPTY_LIST, null);

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


		public static final @NonNull ExecutorProperty _Domain__isCheckable = new EcoreExecutorProperty(QVTbasePackage.Literals.DOMAIN__IS_CHECKABLE, Types._Domain, 0);
		public static final @NonNull ExecutorProperty _Domain__isEnforceable = new EcoreExecutorProperty(QVTbasePackage.Literals.DOMAIN__IS_ENFORCEABLE, Types._Domain, 1);
		public static final @NonNull ExecutorProperty _Domain__rule = new EcoreExecutorProperty(QVTbasePackage.Literals.DOMAIN__RULE, Types._Domain, 2);
		public static final @NonNull ExecutorProperty _Domain__typedModel = new EcoreExecutorProperty(QVTbasePackage.Literals.DOMAIN__TYPED_MODEL, Types._Domain, 3);

		public static final @NonNull ExecutorProperty _Function__queryExpression = new EcoreExecutorProperty(QVTbasePackage.Literals.FUNCTION__QUERY_EXPRESSION, Types._Function, 0);

		public static final @NonNull ExecutorProperty _Pattern__bindsTo = new EcoreExecutorProperty(QVTbasePackage.Literals.PATTERN__BINDS_TO, Types._Pattern, 0);
		public static final @NonNull ExecutorProperty _Pattern__predicate = new EcoreExecutorProperty(QVTbasePackage.Literals.PATTERN__PREDICATE, Types._Pattern, 1);

		public static final @NonNull ExecutorProperty _Predicate__conditionExpression = new EcoreExecutorProperty(QVTbasePackage.Literals.PREDICATE__CONDITION_EXPRESSION, Types._Predicate, 0);
		public static final @NonNull ExecutorProperty _Predicate__pattern = new EcoreExecutorProperty(QVTbasePackage.Literals.PREDICATE__PATTERN, Types._Predicate, 1);

		public static final @NonNull ExecutorProperty _Rule__domain = new EcoreExecutorProperty(QVTbasePackage.Literals.RULE__DOMAIN, Types._Rule, 0);
		public static final @NonNull ExecutorProperty _Rule__isAbstract = new EcoreExecutorProperty(QVTbasePackage.Literals.RULE__IS_ABSTRACT, Types._Rule, 1);
		public static final @NonNull ExecutorProperty _Rule__overridden = new EcoreExecutorProperty(QVTbasePackage.Literals.RULE__OVERRIDDEN, Types._Rule, 2);
		public static final @NonNull ExecutorProperty _Rule__overrides = new EcoreExecutorProperty(QVTbasePackage.Literals.RULE__OVERRIDES, Types._Rule, 3);
		public static final @NonNull ExecutorProperty _Rule__transformation = new EcoreExecutorProperty(QVTbasePackage.Literals.RULE__TRANSFORMATION, Types._Rule, 4);

		public static final @NonNull ExecutorProperty _Transformation__extends = new EcoreExecutorProperty(QVTbasePackage.Literals.TRANSFORMATION__EXTENDS, Types._Transformation, 0);
		public static final @NonNull ExecutorProperty _Transformation__modelParameter = new EcoreExecutorProperty(QVTbasePackage.Literals.TRANSFORMATION__MODEL_PARAMETER, Types._Transformation, 1);
		public static final @NonNull ExecutorProperty _Transformation__ownedContext = new EcoreExecutorProperty(QVTbasePackage.Literals.TRANSFORMATION__OWNED_CONTEXT, Types._Transformation, 2);
		public static final @NonNull ExecutorProperty _Transformation__ownedTag = new EcoreExecutorProperty(QVTbasePackage.Literals.TRANSFORMATION__OWNED_TAG, Types._Transformation, 3);
		public static final @NonNull ExecutorProperty _Transformation__rule = new EcoreExecutorProperty(QVTbasePackage.Literals.TRANSFORMATION__RULE, Types._Transformation, 4);
		public static final @NonNull ExecutorProperty _Transformation__extendedBy__extends = new ExecutorPropertyWithImplementation("extendedBy", Types._Transformation, 5, new EcoreLibraryOppositeProperty(QVTbasePackage.Literals.TRANSFORMATION__EXTENDS));

		public static final @NonNull ExecutorProperty _TypedModel__dependsOn = new EcoreExecutorProperty(QVTbasePackage.Literals.TYPED_MODEL__DEPENDS_ON, Types._TypedModel, 0);
		public static final @NonNull ExecutorProperty _TypedModel__isPrimitive = new EcoreExecutorProperty(QVTbasePackage.Literals.TYPED_MODEL__IS_PRIMITIVE, Types._TypedModel, 1);
		public static final @NonNull ExecutorProperty _TypedModel__isThis = new EcoreExecutorProperty(QVTbasePackage.Literals.TYPED_MODEL__IS_THIS, Types._TypedModel, 2);
		public static final @NonNull ExecutorProperty _TypedModel__isTrace = new EcoreExecutorProperty(QVTbasePackage.Literals.TYPED_MODEL__IS_TRACE, Types._TypedModel, 3);
		public static final @NonNull ExecutorProperty _TypedModel__ownedContext = new EcoreExecutorProperty(QVTbasePackage.Literals.TYPED_MODEL__OWNED_CONTEXT, Types._TypedModel, 4);
		public static final @NonNull ExecutorProperty _TypedModel__transformation = new EcoreExecutorProperty(QVTbasePackage.Literals.TYPED_MODEL__TRANSFORMATION, Types._TypedModel, 5);
		public static final @NonNull ExecutorProperty _TypedModel__usedPackage = new EcoreExecutorProperty(QVTbasePackage.Literals.TYPED_MODEL__USED_PACKAGE, Types._TypedModel, 6);
		public static final @NonNull ExecutorProperty _TypedModel__Domain__typedModel = new ExecutorPropertyWithImplementation("Domain", Types._TypedModel, 7, new EcoreLibraryOppositeProperty(QVTbasePackage.Literals.DOMAIN__TYPED_MODEL));
		public static final @NonNull ExecutorProperty _TypedModel__dependent__dependsOn = new ExecutorPropertyWithImplementation("dependent", Types._TypedModel, 8, new EcoreLibraryOppositeProperty(QVTbasePackage.Literals.TYPED_MODEL__DEPENDS_ON));
		static {
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

		private static final @NonNull ExecutorFragment @NonNull [] _BaseModel =
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

		private static final @NonNull ExecutorFragment @NonNull [] _Domain =
			{
				Fragments._Domain__OclAny /* 0 */,
				Fragments._Domain__OclElement /* 1 */,
				Fragments._Domain__Element /* 2 */,
				Fragments._Domain__ReferringElement /* 2 */,
				Fragments._Domain__NamedElement /* 3 */,
				Fragments._Domain__Domain /* 4 */
			};
		private static final int @NonNull [] __Domain = { 1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Function =
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

		private static final @NonNull ExecutorFragment @NonNull [] _FunctionBody =
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

		private static final @NonNull ExecutorFragment @NonNull [] _FunctionParameter =
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

		private static final @NonNull ExecutorFragment @NonNull [] _Pattern =
			{
				Fragments._Pattern__OclAny /* 0 */,
				Fragments._Pattern__OclElement /* 1 */,
				Fragments._Pattern__Element /* 2 */,
				Fragments._Pattern__Pattern /* 3 */
			};
		private static final int @NonNull [] __Pattern = { 1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Predicate =
			{
				Fragments._Predicate__OclAny /* 0 */,
				Fragments._Predicate__OclElement /* 1 */,
				Fragments._Predicate__Element /* 2 */,
				Fragments._Predicate__Predicate /* 3 */
			};
		private static final int @NonNull [] __Predicate = { 1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Rule =
			{
				Fragments._Rule__OclAny /* 0 */,
				Fragments._Rule__OclElement /* 1 */,
				Fragments._Rule__Element /* 2 */,
				Fragments._Rule__NamedElement /* 3 */,
				Fragments._Rule__Rule /* 4 */
			};
		private static final int @NonNull [] __Rule = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Transformation =
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

		private static final @NonNull ExecutorFragment @NonNull [] _TypedModel =
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
			Types._Domain.initFragments(_Domain, __Domain);
			Types._Function.initFragments(_Function, __Function);
			Types._FunctionBody.initFragments(_FunctionBody, __FunctionBody);
			Types._FunctionParameter.initFragments(_FunctionParameter, __FunctionParameter);
			Types._Pattern.initFragments(_Pattern, __Pattern);
			Types._Predicate.initFragments(_Predicate, __Predicate);
			Types._Rule.initFragments(_Rule, __Rule);
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

		private static final @NonNull ExecutorOperation @NonNull [] _BaseModel__BaseModel = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BaseModel__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _BaseModel__Model = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BaseModel__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BaseModel__Namespace = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BaseModel__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _BaseModel__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Domain__Domain = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Domain__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Domain__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Domain__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Domain__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Domain__ReferringElement = {
			PivotTables.Operations._ReferringElement__getReferredElement /* getReferredElement() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Function__Function = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Function__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Function__Feature = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Function__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Function__Namespace = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Function__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Function__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Function__Operation = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Function__TemplateableElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Function__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _FunctionBody__FunctionBody = {};
		private static final @NonNull ExecutorOperation @NonNull [] _FunctionBody__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _FunctionBody__ExpressionInOCL = {};
		private static final @NonNull ExecutorOperation @NonNull [] _FunctionBody__LanguageExpression = {};
		private static final @NonNull ExecutorOperation @NonNull [] _FunctionBody__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _FunctionBody__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _FunctionBody__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _FunctionBody__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _FunctionBody__ValueSpecification = {
			PivotTables.Operations._ValueSpecification__booleanValue /* booleanValue() */,
			PivotTables.Operations._ValueSpecification__integerValue /* integerValue() */,
			PivotTables.Operations._ValueSpecification__isComputable /* isComputable() */,
			PivotTables.Operations._ValueSpecification__isNull /* isNull() */,
			PivotTables.Operations._ValueSpecification__stringValue /* stringValue() */,
			PivotTables.Operations._ValueSpecification__unlimitedValue /* unlimitedValue() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _FunctionParameter__FunctionParameter = {};
		private static final @NonNull ExecutorOperation @NonNull [] _FunctionParameter__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _FunctionParameter__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _FunctionParameter__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _FunctionParameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _FunctionParameter__Parameter = {};
		private static final @NonNull ExecutorOperation @NonNull [] _FunctionParameter__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _FunctionParameter__VariableDeclaration = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Pattern__Pattern = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Pattern__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Pattern__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Pattern__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Predicate__Predicate = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Predicate__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Predicate__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Predicate__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Rule__Rule = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Rule__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Rule__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Rule__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Rule__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Transformation__Transformation = {
			QVTbaseTables.Operations._Transformation__getFunction /* getFunction(String[1]) */,
			QVTbaseTables.Operations._Transformation__getModelParameter /* getModelParameter(String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Transformation__Class = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Transformation__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Transformation__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Transformation__Namespace = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Transformation__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Transformation__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Transformation__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Transformation__TemplateableElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Transformation__Type = {
			PivotTables.Operations._Type__conformsTo /* conformsTo(Type[?]) */,
			PivotTables.Operations._Type__flattenedType /* flattenedType() */,
			PivotTables.Operations._Type__isClass /* isClass() */,
			PivotTables.Operations._Type__isTemplateParameter /* isTemplateParameter() */,
			PivotTables.Operations._Type__specializeIn /* specializeIn(CallExp[1],Type[1]) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _TypedModel__TypedModel = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TypedModel__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TypedModel__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TypedModel__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TypedModel__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
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

		private static final @NonNull ExecutorProperty @NonNull [] _BaseModel = {};

		private static final @NonNull ExecutorProperty @NonNull [] _Domain = {
			QVTbaseTables.Properties._Domain__isCheckable,
			QVTbaseTables.Properties._Domain__isEnforceable,
			QVTbaseTables.Properties._Domain__rule,
			QVTbaseTables.Properties._Domain__typedModel
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Function = {
			QVTbaseTables.Properties._Function__queryExpression
		};

		private static final @NonNull ExecutorProperty @NonNull [] _FunctionBody = {};

		private static final @NonNull ExecutorProperty @NonNull [] _FunctionParameter = {};

		private static final @NonNull ExecutorProperty @NonNull [] _Pattern = {
			QVTbaseTables.Properties._Pattern__bindsTo,
			QVTbaseTables.Properties._Pattern__predicate
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Predicate = {
			QVTbaseTables.Properties._Predicate__conditionExpression,
			QVTbaseTables.Properties._Predicate__pattern
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Rule = {
			QVTbaseTables.Properties._Rule__domain,
			QVTbaseTables.Properties._Rule__isAbstract,
			QVTbaseTables.Properties._Rule__overridden,
			QVTbaseTables.Properties._Rule__overrides,
			QVTbaseTables.Properties._Rule__transformation
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Transformation = {
			QVTbaseTables.Properties._Transformation__extends,
			QVTbaseTables.Properties._Transformation__modelParameter,
			QVTbaseTables.Properties._Transformation__ownedContext,
			QVTbaseTables.Properties._Transformation__ownedTag,
			QVTbaseTables.Properties._Transformation__rule
		};

		private static final @NonNull ExecutorProperty @NonNull [] _TypedModel = {
			QVTbaseTables.Properties._TypedModel__dependsOn,
			QVTbaseTables.Properties._TypedModel__isPrimitive,
			QVTbaseTables.Properties._TypedModel__isThis,
			QVTbaseTables.Properties._TypedModel__isTrace,
			QVTbaseTables.Properties._TypedModel__ownedContext,
			QVTbaseTables.Properties._TypedModel__transformation,
			QVTbaseTables.Properties._TypedModel__usedPackage
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._BaseModel__BaseModel.initProperties(_BaseModel);
			Fragments._Domain__Domain.initProperties(_Domain);
			Fragments._Function__Function.initProperties(_Function);
			Fragments._FunctionBody__FunctionBody.initProperties(_FunctionBody);
			Fragments._FunctionParameter__FunctionParameter.initProperties(_FunctionParameter);
			Fragments._Pattern__Pattern.initProperties(_Pattern);
			Fragments._Predicate__Predicate.initProperties(_Predicate);
			Fragments._Rule__Rule.initProperties(_Rule);
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

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {

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
		 * Invoked at the start of a static construction to defer residual cobstruction until primary constructions complete.
		 */
		private static void initStart() {
			if (initCount >= 0) {
				initCount++;
			}
		}

		/**
		 * Invoked at the end of a static construction to activate residual cobstruction once primary constructions complete.
		 */
		private static void initEnd() {
			if (initCount > 0) {
				if (--initCount == 0) {
					initCount = -1;
					EnumerationLiterals.init();
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
	public static void init() {}
}
