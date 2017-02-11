/*******************************************************************************
 * <copyright>
 * 
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 *   /org.eclipse.qvtd.pivot.qvtrelation/model/QVTrelation.ecore
 * using:
 *   /org.eclipse.qvtd.pivot.qvtrelation/model/QVTrelation.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreLibraryOppositeProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorFragment;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorOperation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorPropertyWithImplementation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables;

/**
 * QVTrelationTables provides the dispatch tables for the qvtrelation for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
@SuppressWarnings("nls")
public class QVTrelationTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final @NonNull EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(QVTrelationPackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final @NonNull ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = org.eclipse.ocl.pivot.ids.IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbase", null, org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTrelation", null, org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTtemplate = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTtemplate", null, org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Domain = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Domain", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_DomainPattern = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("DomainPattern", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Key = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("Key", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OCLExpression = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_$metamodel$.getClassId("OCLExpression", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Operation = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_$metamodel$.getClassId("Operation", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Package = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_$metamodel$.getClassId("Package", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Pattern = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Pattern", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Property = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_$metamodel$.getClassId("Property", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Relation = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("Relation", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RelationCallExp = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("RelationCallExp", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RelationDomain = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("RelationDomain", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RelationDomainAssignment = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("RelationDomainAssignment", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RelationImplementation = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("RelationImplementation", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RelationalTransformation = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("RelationalTransformation", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Rule = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Rule", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TemplateExp = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTtemplate.getClassId("TemplateExp", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Transformation = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Transformation", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Type = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_$metamodel$.getClassId("Type", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TypedModel = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("TypedModel", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Variable = org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.PACKid_$metamodel$.getClassId("Variable", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue INT_0 = org.eclipse.ocl.pivot.utilities.ValueUtil.integerValueOf("0");
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_Key_c_c_IdentifiesIsAUsedPackageClass = "Key::IdentifiesIsAUsedPackageClass";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_Key_c_c_OppositePartsAreOppositeParts = "Key::OppositePartsAreOppositeParts";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_Key_c_c_OppositePartsHaveOpposites = "Key::OppositePartsHaveOpposites";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_Key_c_c_PartsAreParts = "Key::PartsAreParts";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_Key_c_c_PartsAreUnique = "Key::PartsAreUnique";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelationCallExp_c_c_MatchingArgumentCount = "RelationCallExp::MatchingArgumentCount";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelationDomainAssignment_c_c_CompatibleTypeForValue = "RelationDomainAssignment::CompatibleTypeForValue";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelationDomain_c_c_RelationDomainAssignmentsAreUnique = "RelationDomain::RelationDomainAssignmentsAreUnique";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_Relation_c_c_DomainsAreRelationDomains = "Relation::DomainsAreRelationDomains";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_Relation_c_c_TransformationIsRelationalTransformation = "Relation::TransformationIsRelationalTransformation";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelationalTransformation_c_c_KeysAreUnique = "RelationalTransformation::KeysAreUnique";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelationalTransformation_c_c_RulesAreRelations = "RelationalTransformation::RulesAreRelations";
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_Property = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.CLSSid_Property);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Domain = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.CLSSid_Domain);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_DomainPattern = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.CLSSid_DomainPattern);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_OCLExpression = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.CLSSid_OCLExpression);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_TypedModel = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.CLSSid_TypedModel);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Variable = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.CLSSid_Variable);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Package = org.eclipse.ocl.pivot.ids.TypeId.SEQUENCE.getSpecializedId(org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.CLSSid_Package);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_RelationDomain = org.eclipse.ocl.pivot.ids.TypeId.SEQUENCE.getSpecializedId(org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.CLSSid_RelationDomain);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Variable = org.eclipse.ocl.pivot.ids.TypeId.SEQUENCE.getSpecializedId(org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.CLSSid_Variable);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Key = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.CLSSid_Key);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Package = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.CLSSid_Package);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Property = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.CLSSid_Property);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_RelationDomainAssignment = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.CLSSid_RelationDomainAssignment);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_RelationImplementation = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.CLSSid_RelationImplementation);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Rule = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.CLSSid_Rule);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Variable = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables.CLSSid_Variable);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			QVTrelationTables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTrelationTables::TypeParameters and all preceding sub-packages.
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

		public static final @NonNull EcoreExecutorType _DomainPattern = new EcoreExecutorType(QVTrelationPackage.Literals.DOMAIN_PATTERN, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Key = new EcoreExecutorType(QVTrelationPackage.Literals.KEY, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Relation = new EcoreExecutorType(QVTrelationPackage.Literals.RELATION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _RelationCallExp = new EcoreExecutorType(QVTrelationPackage.Literals.RELATION_CALL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _RelationDomain = new EcoreExecutorType(QVTrelationPackage.Literals.RELATION_DOMAIN, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _RelationDomainAssignment = new EcoreExecutorType(QVTrelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _RelationImplementation = new EcoreExecutorType(QVTrelationPackage.Literals.RELATION_IMPLEMENTATION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _RelationModel = new EcoreExecutorType(QVTrelationPackage.Literals.RELATION_MODEL, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _RelationalTransformation = new EcoreExecutorType(QVTrelationPackage.Literals.RELATIONAL_TRANSFORMATION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _SharedVariable = new EcoreExecutorType(QVTrelationPackage.Literals.SHARED_VARIABLE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TemplateVariable = new EcoreExecutorType(QVTrelationPackage.Literals.TEMPLATE_VARIABLE, PACKAGE, 0);

		private static final @NonNull EcoreExecutorType @NonNull [] types = {
			_DomainPattern,
			_Key,
			_Relation,
			_RelationCallExp,
			_RelationDomain,
			_RelationDomainAssignment,
			_RelationImplementation,
			_RelationModel,
			_RelationalTransformation,
			_SharedVariable,
			_TemplateVariable
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTrelationTables::Types and all preceding sub-packages.
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

		private static final @NonNull ExecutorFragment _DomainPattern__DomainPattern = new ExecutorFragment(Types._DomainPattern, QVTrelationTables.Types._DomainPattern);
		private static final @NonNull ExecutorFragment _DomainPattern__Element = new ExecutorFragment(Types._DomainPattern, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _DomainPattern__OclAny = new ExecutorFragment(Types._DomainPattern, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _DomainPattern__OclElement = new ExecutorFragment(Types._DomainPattern, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _DomainPattern__Pattern = new ExecutorFragment(Types._DomainPattern, QVTbaseTables.Types._Pattern);
		private static final @NonNull ExecutorFragment _DomainPattern__Visitable = new ExecutorFragment(Types._DomainPattern, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Key__Element = new ExecutorFragment(Types._Key, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Key__Key = new ExecutorFragment(Types._Key, QVTrelationTables.Types._Key);
		private static final @NonNull ExecutorFragment _Key__OclAny = new ExecutorFragment(Types._Key, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Key__OclElement = new ExecutorFragment(Types._Key, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Key__Visitable = new ExecutorFragment(Types._Key, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Relation__Element = new ExecutorFragment(Types._Relation, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Relation__Nameable = new ExecutorFragment(Types._Relation, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _Relation__NamedElement = new ExecutorFragment(Types._Relation, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Relation__OclAny = new ExecutorFragment(Types._Relation, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Relation__OclElement = new ExecutorFragment(Types._Relation, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Relation__Relation = new ExecutorFragment(Types._Relation, QVTrelationTables.Types._Relation);
		private static final @NonNull ExecutorFragment _Relation__Rule = new ExecutorFragment(Types._Relation, QVTbaseTables.Types._Rule);
		private static final @NonNull ExecutorFragment _Relation__Visitable = new ExecutorFragment(Types._Relation, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _RelationCallExp__Element = new ExecutorFragment(Types._RelationCallExp, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _RelationCallExp__Nameable = new ExecutorFragment(Types._RelationCallExp, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _RelationCallExp__NamedElement = new ExecutorFragment(Types._RelationCallExp, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _RelationCallExp__OCLExpression = new ExecutorFragment(Types._RelationCallExp, PivotTables.Types._OCLExpression);
		private static final @NonNull ExecutorFragment _RelationCallExp__OclAny = new ExecutorFragment(Types._RelationCallExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _RelationCallExp__OclElement = new ExecutorFragment(Types._RelationCallExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _RelationCallExp__RelationCallExp = new ExecutorFragment(Types._RelationCallExp, QVTrelationTables.Types._RelationCallExp);
		private static final @NonNull ExecutorFragment _RelationCallExp__TypedElement = new ExecutorFragment(Types._RelationCallExp, PivotTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _RelationCallExp__Visitable = new ExecutorFragment(Types._RelationCallExp, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _RelationDomain__Domain = new ExecutorFragment(Types._RelationDomain, QVTbaseTables.Types._Domain);
		private static final @NonNull ExecutorFragment _RelationDomain__Element = new ExecutorFragment(Types._RelationDomain, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _RelationDomain__Nameable = new ExecutorFragment(Types._RelationDomain, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _RelationDomain__NamedElement = new ExecutorFragment(Types._RelationDomain, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _RelationDomain__OclAny = new ExecutorFragment(Types._RelationDomain, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _RelationDomain__OclElement = new ExecutorFragment(Types._RelationDomain, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _RelationDomain__ReferringElement = new ExecutorFragment(Types._RelationDomain, PivotTables.Types._ReferringElement);
		private static final @NonNull ExecutorFragment _RelationDomain__RelationDomain = new ExecutorFragment(Types._RelationDomain, QVTrelationTables.Types._RelationDomain);
		private static final @NonNull ExecutorFragment _RelationDomain__Visitable = new ExecutorFragment(Types._RelationDomain, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _RelationDomainAssignment__Element = new ExecutorFragment(Types._RelationDomainAssignment, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _RelationDomainAssignment__OclAny = new ExecutorFragment(Types._RelationDomainAssignment, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _RelationDomainAssignment__OclElement = new ExecutorFragment(Types._RelationDomainAssignment, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _RelationDomainAssignment__RelationDomainAssignment = new ExecutorFragment(Types._RelationDomainAssignment, QVTrelationTables.Types._RelationDomainAssignment);
		private static final @NonNull ExecutorFragment _RelationDomainAssignment__Visitable = new ExecutorFragment(Types._RelationDomainAssignment, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _RelationImplementation__Element = new ExecutorFragment(Types._RelationImplementation, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _RelationImplementation__OclAny = new ExecutorFragment(Types._RelationImplementation, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _RelationImplementation__OclElement = new ExecutorFragment(Types._RelationImplementation, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _RelationImplementation__RelationImplementation = new ExecutorFragment(Types._RelationImplementation, QVTrelationTables.Types._RelationImplementation);
		private static final @NonNull ExecutorFragment _RelationImplementation__Visitable = new ExecutorFragment(Types._RelationImplementation, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _RelationModel__BaseModel = new ExecutorFragment(Types._RelationModel, QVTbaseTables.Types._BaseModel);
		private static final @NonNull ExecutorFragment _RelationModel__Element = new ExecutorFragment(Types._RelationModel, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _RelationModel__Model = new ExecutorFragment(Types._RelationModel, PivotTables.Types._Model);
		private static final @NonNull ExecutorFragment _RelationModel__Nameable = new ExecutorFragment(Types._RelationModel, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _RelationModel__NamedElement = new ExecutorFragment(Types._RelationModel, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _RelationModel__Namespace = new ExecutorFragment(Types._RelationModel, PivotTables.Types._Namespace);
		private static final @NonNull ExecutorFragment _RelationModel__OclAny = new ExecutorFragment(Types._RelationModel, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _RelationModel__OclElement = new ExecutorFragment(Types._RelationModel, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _RelationModel__RelationModel = new ExecutorFragment(Types._RelationModel, QVTrelationTables.Types._RelationModel);
		private static final @NonNull ExecutorFragment _RelationModel__Visitable = new ExecutorFragment(Types._RelationModel, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _RelationalTransformation__Class = new ExecutorFragment(Types._RelationalTransformation, PivotTables.Types._Class);
		private static final @NonNull ExecutorFragment _RelationalTransformation__Element = new ExecutorFragment(Types._RelationalTransformation, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _RelationalTransformation__Nameable = new ExecutorFragment(Types._RelationalTransformation, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _RelationalTransformation__NamedElement = new ExecutorFragment(Types._RelationalTransformation, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _RelationalTransformation__Namespace = new ExecutorFragment(Types._RelationalTransformation, PivotTables.Types._Namespace);
		private static final @NonNull ExecutorFragment _RelationalTransformation__OclAny = new ExecutorFragment(Types._RelationalTransformation, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _RelationalTransformation__OclElement = new ExecutorFragment(Types._RelationalTransformation, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _RelationalTransformation__OclType = new ExecutorFragment(Types._RelationalTransformation, OCLstdlibTables.Types._OclType);
		private static final @NonNull ExecutorFragment _RelationalTransformation__RelationalTransformation = new ExecutorFragment(Types._RelationalTransformation, QVTrelationTables.Types._RelationalTransformation);
		private static final @NonNull ExecutorFragment _RelationalTransformation__TemplateableElement = new ExecutorFragment(Types._RelationalTransformation, PivotTables.Types._TemplateableElement);
		private static final @NonNull ExecutorFragment _RelationalTransformation__Transformation = new ExecutorFragment(Types._RelationalTransformation, QVTbaseTables.Types._Transformation);
		private static final @NonNull ExecutorFragment _RelationalTransformation__Type = new ExecutorFragment(Types._RelationalTransformation, PivotTables.Types._Type);
		private static final @NonNull ExecutorFragment _RelationalTransformation__Visitable = new ExecutorFragment(Types._RelationalTransformation, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _SharedVariable__Element = new ExecutorFragment(Types._SharedVariable, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _SharedVariable__Nameable = new ExecutorFragment(Types._SharedVariable, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _SharedVariable__NamedElement = new ExecutorFragment(Types._SharedVariable, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _SharedVariable__OclAny = new ExecutorFragment(Types._SharedVariable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _SharedVariable__OclElement = new ExecutorFragment(Types._SharedVariable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _SharedVariable__SharedVariable = new ExecutorFragment(Types._SharedVariable, QVTrelationTables.Types._SharedVariable);
		private static final @NonNull ExecutorFragment _SharedVariable__TypedElement = new ExecutorFragment(Types._SharedVariable, PivotTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _SharedVariable__Variable = new ExecutorFragment(Types._SharedVariable, PivotTables.Types._Variable);
		private static final @NonNull ExecutorFragment _SharedVariable__VariableDeclaration = new ExecutorFragment(Types._SharedVariable, PivotTables.Types._VariableDeclaration);
		private static final @NonNull ExecutorFragment _SharedVariable__Visitable = new ExecutorFragment(Types._SharedVariable, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _TemplateVariable__Element = new ExecutorFragment(Types._TemplateVariable, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _TemplateVariable__Nameable = new ExecutorFragment(Types._TemplateVariable, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _TemplateVariable__NamedElement = new ExecutorFragment(Types._TemplateVariable, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _TemplateVariable__OclAny = new ExecutorFragment(Types._TemplateVariable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _TemplateVariable__OclElement = new ExecutorFragment(Types._TemplateVariable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _TemplateVariable__TemplateVariable = new ExecutorFragment(Types._TemplateVariable, QVTrelationTables.Types._TemplateVariable);
		private static final @NonNull ExecutorFragment _TemplateVariable__TypedElement = new ExecutorFragment(Types._TemplateVariable, PivotTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _TemplateVariable__Variable = new ExecutorFragment(Types._TemplateVariable, PivotTables.Types._Variable);
		private static final @NonNull ExecutorFragment _TemplateVariable__VariableDeclaration = new ExecutorFragment(Types._TemplateVariable, PivotTables.Types._VariableDeclaration);
		private static final @NonNull ExecutorFragment _TemplateVariable__Visitable = new ExecutorFragment(Types._TemplateVariable, PivotTables.Types._Visitable);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTrelationTables::Fragments and all preceding sub-packages.
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


		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTrelationTables::Parameters and all preceding sub-packages.
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

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTrelationTables::Operations and all preceding sub-packages.
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

		public static final @NonNull ExecutorProperty _DomainPattern__templateExpression = new EcoreExecutorProperty(QVTrelationPackage.Literals.DOMAIN_PATTERN__TEMPLATE_EXPRESSION, Types._DomainPattern, 0);
		public static final @NonNull ExecutorProperty _DomainPattern__RelationDomain__pattern = new ExecutorPropertyWithImplementation("RelationDomain", Types._DomainPattern, 1, new EcoreLibraryOppositeProperty(QVTrelationPackage.Literals.RELATION_DOMAIN__PATTERN));

		public static final @NonNull ExecutorProperty _Key__identifies = new EcoreExecutorProperty(QVTrelationPackage.Literals.KEY__IDENTIFIES, Types._Key, 0);
		public static final @NonNull ExecutorProperty _Key__oppositePart = new EcoreExecutorProperty(QVTrelationPackage.Literals.KEY__OPPOSITE_PART, Types._Key, 1);
		public static final @NonNull ExecutorProperty _Key__part = new EcoreExecutorProperty(QVTrelationPackage.Literals.KEY__PART, Types._Key, 2);
		public static final @NonNull ExecutorProperty _Key__transformation = new EcoreExecutorProperty(QVTrelationPackage.Literals.KEY__TRANSFORMATION, Types._Key, 3);

		public static final @NonNull ExecutorProperty _Relation__isInPlace = new EcoreExecutorProperty(QVTrelationPackage.Literals.RELATION__IS_IN_PLACE, Types._Relation, 0);
		public static final @NonNull ExecutorProperty _Relation__isTopLevel = new EcoreExecutorProperty(QVTrelationPackage.Literals.RELATION__IS_TOP_LEVEL, Types._Relation, 1);
		public static final @NonNull ExecutorProperty _Relation__operationalImpl = new EcoreExecutorProperty(QVTrelationPackage.Literals.RELATION__OPERATIONAL_IMPL, Types._Relation, 2);
		public static final @NonNull ExecutorProperty _Relation__variable = new EcoreExecutorProperty(QVTrelationPackage.Literals.RELATION__VARIABLE, Types._Relation, 3);
		public static final @NonNull ExecutorProperty _Relation__when = new EcoreExecutorProperty(QVTrelationPackage.Literals.RELATION__WHEN, Types._Relation, 4);
		public static final @NonNull ExecutorProperty _Relation__where = new EcoreExecutorProperty(QVTrelationPackage.Literals.RELATION__WHERE, Types._Relation, 5);
		public static final @NonNull ExecutorProperty _Relation__relationCallExp__referredRelation = new ExecutorPropertyWithImplementation("relationCallExp", Types._Relation, 6, new EcoreLibraryOppositeProperty(QVTrelationPackage.Literals.RELATION_CALL_EXP__REFERRED_RELATION));

		public static final @NonNull ExecutorProperty _RelationCallExp__argument = new EcoreExecutorProperty(QVTrelationPackage.Literals.RELATION_CALL_EXP__ARGUMENT, Types._RelationCallExp, 0);
		public static final @NonNull ExecutorProperty _RelationCallExp__referredRelation = new EcoreExecutorProperty(QVTrelationPackage.Literals.RELATION_CALL_EXP__REFERRED_RELATION, Types._RelationCallExp, 1);

		public static final @NonNull ExecutorProperty _RelationDomain__defaultAssignment = new EcoreExecutorProperty(QVTrelationPackage.Literals.RELATION_DOMAIN__DEFAULT_ASSIGNMENT, Types._RelationDomain, 0);
		public static final @NonNull ExecutorProperty _RelationDomain__pattern = new EcoreExecutorProperty(QVTrelationPackage.Literals.RELATION_DOMAIN__PATTERN, Types._RelationDomain, 1);
		public static final @NonNull ExecutorProperty _RelationDomain__rootVariable = new EcoreExecutorProperty(QVTrelationPackage.Literals.RELATION_DOMAIN__ROOT_VARIABLE, Types._RelationDomain, 2);

		public static final @NonNull ExecutorProperty _RelationDomainAssignment__valueExp = new EcoreExecutorProperty(QVTrelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP, Types._RelationDomainAssignment, 0);
		public static final @NonNull ExecutorProperty _RelationDomainAssignment__variable = new EcoreExecutorProperty(QVTrelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VARIABLE, Types._RelationDomainAssignment, 1);
		public static final @NonNull ExecutorProperty _RelationDomainAssignment__owner__defaultAssignment = new ExecutorPropertyWithImplementation("owner", Types._RelationDomainAssignment, 2, new EcoreLibraryOppositeProperty(QVTrelationPackage.Literals.RELATION_DOMAIN__DEFAULT_ASSIGNMENT));

		public static final @NonNull ExecutorProperty _RelationImplementation__impl = new EcoreExecutorProperty(QVTrelationPackage.Literals.RELATION_IMPLEMENTATION__IMPL, Types._RelationImplementation, 0);
		public static final @NonNull ExecutorProperty _RelationImplementation__inDirectionOf = new EcoreExecutorProperty(QVTrelationPackage.Literals.RELATION_IMPLEMENTATION__IN_DIRECTION_OF, Types._RelationImplementation, 1);
		public static final @NonNull ExecutorProperty _RelationImplementation__relation = new EcoreExecutorProperty(QVTrelationPackage.Literals.RELATION_IMPLEMENTATION__RELATION, Types._RelationImplementation, 2);

		public static final @NonNull ExecutorProperty _RelationalTransformation__ownedKey = new EcoreExecutorProperty(QVTrelationPackage.Literals.RELATIONAL_TRANSFORMATION__OWNED_KEY, Types._RelationalTransformation, 0);
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTrelationTables::Properties and all preceding sub-packages.
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

		private static final @NonNull ExecutorFragment @NonNull [] _DomainPattern =
		{
			Fragments._DomainPattern__OclAny /* 0 */,
			Fragments._DomainPattern__OclElement /* 1 */,
			Fragments._DomainPattern__Visitable /* 2 */,
			Fragments._DomainPattern__Element /* 3 */,
			Fragments._DomainPattern__Pattern /* 4 */,
			Fragments._DomainPattern__DomainPattern /* 5 */
		};
		private static final int @NonNull [] __DomainPattern = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Key =
		{
			Fragments._Key__OclAny /* 0 */,
			Fragments._Key__OclElement /* 1 */,
			Fragments._Key__Visitable /* 2 */,
			Fragments._Key__Element /* 3 */,
			Fragments._Key__Key /* 4 */
		};
		private static final int @NonNull [] __Key = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Relation =
		{
			Fragments._Relation__OclAny /* 0 */,
			Fragments._Relation__OclElement /* 1 */,
			Fragments._Relation__Nameable /* 2 */,
			Fragments._Relation__Visitable /* 2 */,
			Fragments._Relation__Element /* 3 */,
			Fragments._Relation__NamedElement /* 4 */,
			Fragments._Relation__Rule /* 5 */,
			Fragments._Relation__Relation /* 6 */
		};
		private static final int @NonNull [] __Relation = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _RelationCallExp =
		{
			Fragments._RelationCallExp__OclAny /* 0 */,
			Fragments._RelationCallExp__OclElement /* 1 */,
			Fragments._RelationCallExp__Nameable /* 2 */,
			Fragments._RelationCallExp__Visitable /* 2 */,
			Fragments._RelationCallExp__Element /* 3 */,
			Fragments._RelationCallExp__NamedElement /* 4 */,
			Fragments._RelationCallExp__TypedElement /* 5 */,
			Fragments._RelationCallExp__OCLExpression /* 6 */,
			Fragments._RelationCallExp__RelationCallExp /* 7 */
		};
		private static final int @NonNull [] __RelationCallExp = { 1,1,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _RelationDomain =
		{
			Fragments._RelationDomain__OclAny /* 0 */,
			Fragments._RelationDomain__OclElement /* 1 */,
			Fragments._RelationDomain__Nameable /* 2 */,
			Fragments._RelationDomain__ReferringElement /* 2 */,
			Fragments._RelationDomain__Visitable /* 2 */,
			Fragments._RelationDomain__Element /* 3 */,
			Fragments._RelationDomain__NamedElement /* 4 */,
			Fragments._RelationDomain__Domain /* 5 */,
			Fragments._RelationDomain__RelationDomain /* 6 */
		};
		private static final int @NonNull [] __RelationDomain = { 1,1,3,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _RelationDomainAssignment =
		{
			Fragments._RelationDomainAssignment__OclAny /* 0 */,
			Fragments._RelationDomainAssignment__OclElement /* 1 */,
			Fragments._RelationDomainAssignment__Visitable /* 2 */,
			Fragments._RelationDomainAssignment__Element /* 3 */,
			Fragments._RelationDomainAssignment__RelationDomainAssignment /* 4 */
		};
		private static final int @NonNull [] __RelationDomainAssignment = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _RelationImplementation =
		{
			Fragments._RelationImplementation__OclAny /* 0 */,
			Fragments._RelationImplementation__OclElement /* 1 */,
			Fragments._RelationImplementation__Visitable /* 2 */,
			Fragments._RelationImplementation__Element /* 3 */,
			Fragments._RelationImplementation__RelationImplementation /* 4 */
		};
		private static final int @NonNull [] __RelationImplementation = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _RelationModel =
		{
			Fragments._RelationModel__OclAny /* 0 */,
			Fragments._RelationModel__OclElement /* 1 */,
			Fragments._RelationModel__Nameable /* 2 */,
			Fragments._RelationModel__Visitable /* 2 */,
			Fragments._RelationModel__Element /* 3 */,
			Fragments._RelationModel__NamedElement /* 4 */,
			Fragments._RelationModel__Namespace /* 5 */,
			Fragments._RelationModel__Model /* 6 */,
			Fragments._RelationModel__BaseModel /* 7 */,
			Fragments._RelationModel__RelationModel /* 8 */
		};
		private static final int @NonNull [] __RelationModel = { 1,1,2,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _RelationalTransformation =
		{
			Fragments._RelationalTransformation__OclAny /* 0 */,
			Fragments._RelationalTransformation__OclElement /* 1 */,
			Fragments._RelationalTransformation__Nameable /* 2 */,
			Fragments._RelationalTransformation__OclType /* 2 */,
			Fragments._RelationalTransformation__Visitable /* 2 */,
			Fragments._RelationalTransformation__Element /* 3 */,
			Fragments._RelationalTransformation__NamedElement /* 4 */,
			Fragments._RelationalTransformation__TemplateableElement /* 4 */,
			Fragments._RelationalTransformation__Namespace /* 5 */,
			Fragments._RelationalTransformation__Type /* 5 */,
			Fragments._RelationalTransformation__Class /* 6 */,
			Fragments._RelationalTransformation__Transformation /* 7 */,
			Fragments._RelationalTransformation__RelationalTransformation /* 8 */
		};
		private static final int @NonNull [] __RelationalTransformation = { 1,1,3,1,2,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _SharedVariable =
		{
			Fragments._SharedVariable__OclAny /* 0 */,
			Fragments._SharedVariable__OclElement /* 1 */,
			Fragments._SharedVariable__Nameable /* 2 */,
			Fragments._SharedVariable__Visitable /* 2 */,
			Fragments._SharedVariable__Element /* 3 */,
			Fragments._SharedVariable__NamedElement /* 4 */,
			Fragments._SharedVariable__TypedElement /* 5 */,
			Fragments._SharedVariable__VariableDeclaration /* 6 */,
			Fragments._SharedVariable__Variable /* 7 */,
			Fragments._SharedVariable__SharedVariable /* 8 */
		};
		private static final int @NonNull [] __SharedVariable = { 1,1,2,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _TemplateVariable =
		{
			Fragments._TemplateVariable__OclAny /* 0 */,
			Fragments._TemplateVariable__OclElement /* 1 */,
			Fragments._TemplateVariable__Nameable /* 2 */,
			Fragments._TemplateVariable__Visitable /* 2 */,
			Fragments._TemplateVariable__Element /* 3 */,
			Fragments._TemplateVariable__NamedElement /* 4 */,
			Fragments._TemplateVariable__TypedElement /* 5 */,
			Fragments._TemplateVariable__VariableDeclaration /* 6 */,
			Fragments._TemplateVariable__Variable /* 7 */,
			Fragments._TemplateVariable__TemplateVariable /* 8 */
		};
		private static final int @NonNull [] __TemplateVariable = { 1,1,2,1,1,1,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._DomainPattern.initFragments(_DomainPattern, __DomainPattern);
			Types._Key.initFragments(_Key, __Key);
			Types._Relation.initFragments(_Relation, __Relation);
			Types._RelationCallExp.initFragments(_RelationCallExp, __RelationCallExp);
			Types._RelationDomain.initFragments(_RelationDomain, __RelationDomain);
			Types._RelationDomainAssignment.initFragments(_RelationDomainAssignment, __RelationDomainAssignment);
			Types._RelationImplementation.initFragments(_RelationImplementation, __RelationImplementation);
			Types._RelationModel.initFragments(_RelationModel, __RelationModel);
			Types._RelationalTransformation.initFragments(_RelationalTransformation, __RelationalTransformation);
			Types._SharedVariable.initFragments(_SharedVariable, __SharedVariable);
			Types._TemplateVariable.initFragments(_TemplateVariable, __TemplateVariable);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTrelationTables::TypeFragments and all preceding sub-packages.
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

		private static final @NonNull ExecutorOperation @NonNull [] _DomainPattern__DomainPattern = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DomainPattern__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _DomainPattern__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _DomainPattern__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _DomainPattern__Pattern = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DomainPattern__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Key__Key = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Key__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Key__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Key__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Key__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Relation__Relation = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Relation__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Relation__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Relation__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Relation__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Relation__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Relation__Rule = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Relation__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _RelationCallExp__RelationCallExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationCallExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationCallExp__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationCallExp__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationCallExp__OCLExpression = {
			PivotTables.Operations._OCLExpression__isNonNull /* isNonNull() */,
			PivotTables.Operations._OCLExpression__isNull /* isNull() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationCallExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationCallExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationCallExp__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationCallExp__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _RelationDomain__RelationDomain = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationDomain__Domain = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationDomain__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationDomain__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationDomain__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationDomain__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationDomain__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationDomain__ReferringElement = {
			PivotTables.Operations._ReferringElement__getReferredElement /* getReferredElement() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationDomain__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _RelationDomainAssignment__RelationDomainAssignment = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationDomainAssignment__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationDomainAssignment__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationDomainAssignment__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationDomainAssignment__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _RelationImplementation__RelationImplementation = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationImplementation__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationImplementation__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationImplementation__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationImplementation__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _RelationModel__RelationModel = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationModel__BaseModel = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationModel__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationModel__Model = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationModel__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationModel__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationModel__Namespace = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationModel__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationModel__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationModel__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _RelationalTransformation__RelationalTransformation = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationalTransformation__Class = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationalTransformation__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationalTransformation__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationalTransformation__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationalTransformation__Namespace = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationalTransformation__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationalTransformation__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationalTransformation__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationalTransformation__TemplateableElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationalTransformation__Transformation = {
			QVTbaseTables.Operations._Transformation__getFunction /* getFunction(String[1]) */,
			QVTbaseTables.Operations._Transformation__getModelParameter /* getModelParameter(String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationalTransformation__Type = {
			PivotTables.Operations._Type__conformsTo /* conformsTo(Type[?]) */,
			PivotTables.Operations._Type__flattenedType /* flattenedType() */,
			PivotTables.Operations._Type__isClass /* isClass() */,
			PivotTables.Operations._Type__isTemplateParameter /* isTemplateParameter() */,
			PivotTables.Operations._Type__specializeIn /* specializeIn(CallExp[1],Type[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelationalTransformation__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _SharedVariable__SharedVariable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SharedVariable__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SharedVariable__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SharedVariable__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SharedVariable__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SharedVariable__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SharedVariable__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SharedVariable__Variable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SharedVariable__VariableDeclaration = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SharedVariable__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _TemplateVariable__TemplateVariable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TemplateVariable__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TemplateVariable__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TemplateVariable__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TemplateVariable__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TemplateVariable__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TemplateVariable__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TemplateVariable__Variable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TemplateVariable__VariableDeclaration = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TemplateVariable__Visitable = {};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._DomainPattern__DomainPattern.initOperations(_DomainPattern__DomainPattern);
			Fragments._DomainPattern__Element.initOperations(_DomainPattern__Element);
			Fragments._DomainPattern__OclAny.initOperations(_DomainPattern__OclAny);
			Fragments._DomainPattern__OclElement.initOperations(_DomainPattern__OclElement);
			Fragments._DomainPattern__Pattern.initOperations(_DomainPattern__Pattern);
			Fragments._DomainPattern__Visitable.initOperations(_DomainPattern__Visitable);

			Fragments._Key__Element.initOperations(_Key__Element);
			Fragments._Key__Key.initOperations(_Key__Key);
			Fragments._Key__OclAny.initOperations(_Key__OclAny);
			Fragments._Key__OclElement.initOperations(_Key__OclElement);
			Fragments._Key__Visitable.initOperations(_Key__Visitable);

			Fragments._Relation__Element.initOperations(_Relation__Element);
			Fragments._Relation__Nameable.initOperations(_Relation__Nameable);
			Fragments._Relation__NamedElement.initOperations(_Relation__NamedElement);
			Fragments._Relation__OclAny.initOperations(_Relation__OclAny);
			Fragments._Relation__OclElement.initOperations(_Relation__OclElement);
			Fragments._Relation__Relation.initOperations(_Relation__Relation);
			Fragments._Relation__Rule.initOperations(_Relation__Rule);
			Fragments._Relation__Visitable.initOperations(_Relation__Visitable);

			Fragments._RelationCallExp__Element.initOperations(_RelationCallExp__Element);
			Fragments._RelationCallExp__Nameable.initOperations(_RelationCallExp__Nameable);
			Fragments._RelationCallExp__NamedElement.initOperations(_RelationCallExp__NamedElement);
			Fragments._RelationCallExp__OCLExpression.initOperations(_RelationCallExp__OCLExpression);
			Fragments._RelationCallExp__OclAny.initOperations(_RelationCallExp__OclAny);
			Fragments._RelationCallExp__OclElement.initOperations(_RelationCallExp__OclElement);
			Fragments._RelationCallExp__RelationCallExp.initOperations(_RelationCallExp__RelationCallExp);
			Fragments._RelationCallExp__TypedElement.initOperations(_RelationCallExp__TypedElement);
			Fragments._RelationCallExp__Visitable.initOperations(_RelationCallExp__Visitable);

			Fragments._RelationDomain__Domain.initOperations(_RelationDomain__Domain);
			Fragments._RelationDomain__Element.initOperations(_RelationDomain__Element);
			Fragments._RelationDomain__Nameable.initOperations(_RelationDomain__Nameable);
			Fragments._RelationDomain__NamedElement.initOperations(_RelationDomain__NamedElement);
			Fragments._RelationDomain__OclAny.initOperations(_RelationDomain__OclAny);
			Fragments._RelationDomain__OclElement.initOperations(_RelationDomain__OclElement);
			Fragments._RelationDomain__ReferringElement.initOperations(_RelationDomain__ReferringElement);
			Fragments._RelationDomain__RelationDomain.initOperations(_RelationDomain__RelationDomain);
			Fragments._RelationDomain__Visitable.initOperations(_RelationDomain__Visitable);

			Fragments._RelationDomainAssignment__Element.initOperations(_RelationDomainAssignment__Element);
			Fragments._RelationDomainAssignment__OclAny.initOperations(_RelationDomainAssignment__OclAny);
			Fragments._RelationDomainAssignment__OclElement.initOperations(_RelationDomainAssignment__OclElement);
			Fragments._RelationDomainAssignment__RelationDomainAssignment.initOperations(_RelationDomainAssignment__RelationDomainAssignment);
			Fragments._RelationDomainAssignment__Visitable.initOperations(_RelationDomainAssignment__Visitable);

			Fragments._RelationImplementation__Element.initOperations(_RelationImplementation__Element);
			Fragments._RelationImplementation__OclAny.initOperations(_RelationImplementation__OclAny);
			Fragments._RelationImplementation__OclElement.initOperations(_RelationImplementation__OclElement);
			Fragments._RelationImplementation__RelationImplementation.initOperations(_RelationImplementation__RelationImplementation);
			Fragments._RelationImplementation__Visitable.initOperations(_RelationImplementation__Visitable);

			Fragments._RelationModel__BaseModel.initOperations(_RelationModel__BaseModel);
			Fragments._RelationModel__Element.initOperations(_RelationModel__Element);
			Fragments._RelationModel__Model.initOperations(_RelationModel__Model);
			Fragments._RelationModel__Nameable.initOperations(_RelationModel__Nameable);
			Fragments._RelationModel__NamedElement.initOperations(_RelationModel__NamedElement);
			Fragments._RelationModel__Namespace.initOperations(_RelationModel__Namespace);
			Fragments._RelationModel__OclAny.initOperations(_RelationModel__OclAny);
			Fragments._RelationModel__OclElement.initOperations(_RelationModel__OclElement);
			Fragments._RelationModel__RelationModel.initOperations(_RelationModel__RelationModel);
			Fragments._RelationModel__Visitable.initOperations(_RelationModel__Visitable);

			Fragments._RelationalTransformation__Class.initOperations(_RelationalTransformation__Class);
			Fragments._RelationalTransformation__Element.initOperations(_RelationalTransformation__Element);
			Fragments._RelationalTransformation__Nameable.initOperations(_RelationalTransformation__Nameable);
			Fragments._RelationalTransformation__NamedElement.initOperations(_RelationalTransformation__NamedElement);
			Fragments._RelationalTransformation__Namespace.initOperations(_RelationalTransformation__Namespace);
			Fragments._RelationalTransformation__OclAny.initOperations(_RelationalTransformation__OclAny);
			Fragments._RelationalTransformation__OclElement.initOperations(_RelationalTransformation__OclElement);
			Fragments._RelationalTransformation__OclType.initOperations(_RelationalTransformation__OclType);
			Fragments._RelationalTransformation__RelationalTransformation.initOperations(_RelationalTransformation__RelationalTransformation);
			Fragments._RelationalTransformation__TemplateableElement.initOperations(_RelationalTransformation__TemplateableElement);
			Fragments._RelationalTransformation__Transformation.initOperations(_RelationalTransformation__Transformation);
			Fragments._RelationalTransformation__Type.initOperations(_RelationalTransformation__Type);
			Fragments._RelationalTransformation__Visitable.initOperations(_RelationalTransformation__Visitable);

			Fragments._SharedVariable__Element.initOperations(_SharedVariable__Element);
			Fragments._SharedVariable__Nameable.initOperations(_SharedVariable__Nameable);
			Fragments._SharedVariable__NamedElement.initOperations(_SharedVariable__NamedElement);
			Fragments._SharedVariable__OclAny.initOperations(_SharedVariable__OclAny);
			Fragments._SharedVariable__OclElement.initOperations(_SharedVariable__OclElement);
			Fragments._SharedVariable__SharedVariable.initOperations(_SharedVariable__SharedVariable);
			Fragments._SharedVariable__TypedElement.initOperations(_SharedVariable__TypedElement);
			Fragments._SharedVariable__Variable.initOperations(_SharedVariable__Variable);
			Fragments._SharedVariable__VariableDeclaration.initOperations(_SharedVariable__VariableDeclaration);
			Fragments._SharedVariable__Visitable.initOperations(_SharedVariable__Visitable);

			Fragments._TemplateVariable__Element.initOperations(_TemplateVariable__Element);
			Fragments._TemplateVariable__Nameable.initOperations(_TemplateVariable__Nameable);
			Fragments._TemplateVariable__NamedElement.initOperations(_TemplateVariable__NamedElement);
			Fragments._TemplateVariable__OclAny.initOperations(_TemplateVariable__OclAny);
			Fragments._TemplateVariable__OclElement.initOperations(_TemplateVariable__OclElement);
			Fragments._TemplateVariable__TemplateVariable.initOperations(_TemplateVariable__TemplateVariable);
			Fragments._TemplateVariable__TypedElement.initOperations(_TemplateVariable__TypedElement);
			Fragments._TemplateVariable__Variable.initOperations(_TemplateVariable__Variable);
			Fragments._TemplateVariable__VariableDeclaration.initOperations(_TemplateVariable__VariableDeclaration);
			Fragments._TemplateVariable__Visitable.initOperations(_TemplateVariable__Visitable);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTrelationTables::FragmentOperations and all preceding sub-packages.
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

		private static final @NonNull ExecutorProperty @NonNull [] _DomainPattern = {
			QVTrelationTables.Properties._DomainPattern__templateExpression
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Key = {
			QVTrelationTables.Properties._Key__identifies,
			QVTrelationTables.Properties._Key__oppositePart,
			QVTrelationTables.Properties._Key__part,
			QVTrelationTables.Properties._Key__transformation
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Relation = {
			QVTrelationTables.Properties._Relation__isInPlace,
			QVTrelationTables.Properties._Relation__isTopLevel,
			QVTrelationTables.Properties._Relation__operationalImpl,
			QVTrelationTables.Properties._Relation__variable,
			QVTrelationTables.Properties._Relation__when,
			QVTrelationTables.Properties._Relation__where
		};

		private static final @NonNull ExecutorProperty @NonNull [] _RelationCallExp = {
			QVTrelationTables.Properties._RelationCallExp__argument,
			QVTrelationTables.Properties._RelationCallExp__referredRelation
		};

		private static final @NonNull ExecutorProperty @NonNull [] _RelationDomain = {
			QVTrelationTables.Properties._RelationDomain__defaultAssignment,
			QVTrelationTables.Properties._RelationDomain__pattern,
			QVTrelationTables.Properties._RelationDomain__rootVariable
		};

		private static final @NonNull ExecutorProperty @NonNull [] _RelationDomainAssignment = {
			QVTrelationTables.Properties._RelationDomainAssignment__valueExp,
			QVTrelationTables.Properties._RelationDomainAssignment__variable
		};

		private static final @NonNull ExecutorProperty @NonNull [] _RelationImplementation = {
			QVTrelationTables.Properties._RelationImplementation__impl,
			QVTrelationTables.Properties._RelationImplementation__inDirectionOf,
			QVTrelationTables.Properties._RelationImplementation__relation
		};

		private static final @NonNull ExecutorProperty @NonNull [] _RelationModel = {};

		private static final @NonNull ExecutorProperty @NonNull [] _RelationalTransformation = {
			QVTrelationTables.Properties._RelationalTransformation__ownedKey
		};

		private static final @NonNull ExecutorProperty @NonNull [] _SharedVariable = {};

		private static final @NonNull ExecutorProperty @NonNull [] _TemplateVariable = {};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._DomainPattern__DomainPattern.initProperties(_DomainPattern);
			Fragments._Key__Key.initProperties(_Key);
			Fragments._Relation__Relation.initProperties(_Relation);
			Fragments._RelationCallExp__RelationCallExp.initProperties(_RelationCallExp);
			Fragments._RelationDomain__RelationDomain.initProperties(_RelationDomain);
			Fragments._RelationDomainAssignment__RelationDomainAssignment.initProperties(_RelationDomainAssignment);
			Fragments._RelationImplementation__RelationImplementation.initProperties(_RelationImplementation);
			Fragments._RelationModel__RelationModel.initProperties(_RelationModel);
			Fragments._RelationalTransformation__RelationalTransformation.initProperties(_RelationalTransformation);
			Fragments._SharedVariable__SharedVariable.initProperties(_SharedVariable);
			Fragments._TemplateVariable__TemplateVariable.initProperties(_TemplateVariable);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTrelationTables::FragmentProperties and all preceding sub-packages.
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
		 * Force initialization of the fields of QVTrelationTables::EnumerationLiterals and all preceding sub-packages.
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
