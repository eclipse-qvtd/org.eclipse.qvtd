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
 *   /org.eclipse.qvtd.pivot.qvtcore/model/QVTcore.ecore
 * using:
 *   /org.eclipse.qvtd.pivot.qvtcore/model/QVTcore.genmodel
 *   org.eclipse.ocl.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore;

import java.lang.String;
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
import org.eclipse.ocl.pivot.ids.PartId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.PartialStandardLibraryImpl;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.types.TemplateParameters;
import org.eclipse.ocl.pivot.utilities.AbstractTables;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables;
// import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
// import org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables;

/**
 * QVTcoreTables provides the dispatch tables for the qvtcore for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
public class QVTcoreTables extends AbstractTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The library of all packages and types.
	 */
	public static final PartialStandardLibraryImpl.@NonNull ReadOnly LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	The package descriptor for the package.
	 */
	public static final org.eclipse.ocl.pivot.@NonNull Package PACKAGE = LIBRARY.createPackage(QVTcorePackage.eINSTANCE, null);

	/**
	 *	Constants used by auto-generated code.
	 */
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbase", null, QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTcore", null, QVTcorePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Area = QVTcoreTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("Area", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Assignment = QVTcoreTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("Assignment", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BottomPattern = QVTcoreTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("BottomPattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BottomVariable = QVTcoreTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("BottomVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = QVTcoreTables.PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CollectionType = QVTcoreTables.PACKid_$metamodel$.getClassId("CollectionType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CoreDomain = QVTcoreTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("CoreDomain", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DataType = QVTcoreTables.PACKid_$metamodel$.getClassId("DataType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Domain = QVTcoreTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Domain", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_EnforcementOperation = QVTcoreTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("EnforcementOperation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_GuardPattern = QVTcoreTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("GuardPattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_GuardVariable = QVTcoreTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("GuardVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Mapping = QVTcoreTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("Mapping", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OCLExpression = QVTcoreTables.PACKid_$metamodel$.getClassId("OCLExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OperationCallExp = QVTcoreTables.PACKid_$metamodel$.getClassId("OperationCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OppositePropertyAssignment = QVTcoreTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("OppositePropertyAssignment", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Property = QVTcoreTables.PACKid_$metamodel$.getClassId("Property", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_PropertyAssignment = QVTcoreTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("PropertyAssignment", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RealizedVariable = QVTcoreTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("RealizedVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Transformation = QVTcoreTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Transformation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Type = QVTcoreTables.PACKid_$metamodel$.getClassId("Type", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableAssignment = QVTcoreTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("VariableAssignment", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableDeclaration = QVTcoreTables.PACKid_$metamodel$.getClassId("VariableDeclaration", 0);
	public static final /*@NonInvalid*/ @NonNull EnumerationId ENUMid_EnforcementMode = QVTcoreTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getEnumerationId("EnforcementMode");
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_0 = ValueUtil.integerValueOf("0");
	public static final /*@NonInvalid*/ @NonNull PartId PARTid_ = IdManager.getPartId(1, "status", TypeId.BOOLEAN, false);
	public static final /*@NonInvalid*/ @NonNull PartId PARTid__0 = IdManager.getPartId(0, "message", TypeId.STRING, true);
	public static final /*@NonInvalid*/ @NonNull String STR_OppositePropertyAssignment_c_c_CompatibleTypeForPartialValue_c_32 = "OppositePropertyAssignment::CompatibleTypeForPartialValue: ";
	public static final /*@NonInvalid*/ @NonNull String STR_OppositePropertyAssignment_c_c_CompatibleTypeForTotalValue_c_32 = "OppositePropertyAssignment::CompatibleTypeForTotalValue: ";
	public static final /*@NonInvalid*/ @NonNull String STR_PropertyAssignment_c_c_CompatibleTypeForPartialValue_c_32 = "PropertyAssignment::CompatibleTypeForPartialValue: ";
	public static final /*@NonInvalid*/ @NonNull String STR_PropertyAssignment_c_c_CompatibleTypeForTotalValue_c_32 = "PropertyAssignment::CompatibleTypeForTotalValue: ";
	public static final /*@NonInvalid*/ @NonNull String STR_VariableAssignment_c_c_CompatibleTypeForValue_c_32 = "VariableAssignment::CompatibleTypeForValue: ";
	public static final /*@NonInvalid*/ @NonNull String STR__32_must_32_conform_32_to_32 = " must conform to ";
	public static final /*@NonInvalid*/ @NonNull String STR__32_or_32_vice_m_versa = " or vice-versa";
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Domain = TypeId.ORDERED_SET.getSpecializedId(QVTcoreTables.CLSSid_Domain, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Assignment = TypeId.SET.getSpecializedId(QVTcoreTables.CLSSid_Assignment, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_EnforcementOperation = TypeId.SET.getSpecializedId(QVTcoreTables.CLSSid_EnforcementOperation, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Mapping = TypeId.SET.getSpecializedId(QVTcoreTables.CLSSid_Mapping, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_RealizedVariable = TypeId.SET.getSpecializedId(QVTcoreTables.CLSSid_RealizedVariable, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_VariableDeclaration = TypeId.SET.getSpecializedId(QVTcoreTables.CLSSid_VariableDeclaration, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull TupleTypeId TUPLid_ = IdManager.getTupleTypeId(QVTcoreTables.PARTid__0, QVTcoreTables.PARTid_);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			QVTcoreTables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTcoreTables::TypeParameters and all preceding sub-packages.
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

		public static final org.eclipse.ocl.pivot.@NonNull Class _Area = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTcorePackage.Literals.AREA, PACKAGE, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Assignment = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTcorePackage.Literals.ASSIGNMENT, PACKAGE, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _BottomPattern = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTcorePackage.Literals.BOTTOM_PATTERN, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _BottomVariable = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTcorePackage.Literals.BOTTOM_VARIABLE, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _CoreDomain = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTcorePackage.Literals.CORE_DOMAIN, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _CoreModel = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTcorePackage.Literals.CORE_MODEL, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _CorePattern = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTcorePackage.Literals.CORE_PATTERN, PACKAGE, null, 0);
		public static final @NonNull Enumeration _EnforcementMode = LIBRARY.createEnumeration(QVTcorePackage.Literals.ENFORCEMENT_MODE, PACKAGE);
		public static final org.eclipse.ocl.pivot.@NonNull Class _EnforcementOperation = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTcorePackage.Literals.ENFORCEMENT_OPERATION, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _GuardPattern = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTcorePackage.Literals.GUARD_PATTERN, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _GuardVariable = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTcorePackage.Literals.GUARD_VARIABLE, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Mapping = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTcorePackage.Literals.MAPPING, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _NavigationAssignment = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTcorePackage.Literals.NAVIGATION_ASSIGNMENT, PACKAGE, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _OppositePropertyAssignment = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTcorePackage.Literals.OPPOSITE_PROPERTY_ASSIGNMENT, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _PropertyAssignment = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTcorePackage.Literals.PROPERTY_ASSIGNMENT, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _RealizedVariable = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTcorePackage.Literals.REALIZED_VARIABLE, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _VariableAssignment = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTcorePackage.Literals.VARIABLE_ASSIGNMENT, PACKAGE, null, 0);

		private static final org.eclipse.ocl.pivot.@NonNull Class @NonNull [] types = {
			_Area,
			_Assignment,
			_BottomPattern,
			_BottomVariable,
			_CoreDomain,
			_CoreModel,
			_CorePattern,
			_EnforcementMode,
			_EnforcementOperation,
			_GuardPattern,
			_GuardVariable,
			_Mapping,
			_NavigationAssignment,
			_OppositePropertyAssignment,
			_PropertyAssignment,
			_RealizedVariable,
			_VariableAssignment
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			LIBRARY.initPackage(PACKAGE, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTcoreTables::Types and all preceding sub-packages.
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

		private static final @NonNull FlatFragment _Area__Area = LIBRARY.createFragment(Types._Area, QVTcoreTables.Types._Area);
		private static final @NonNull FlatFragment _Area__Element = LIBRARY.createFragment(Types._Area, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _Area__OclAny = LIBRARY.createFragment(Types._Area, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Area__OclElement = LIBRARY.createFragment(Types._Area, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _Assignment__Assignment = LIBRARY.createFragment(Types._Assignment, QVTcoreTables.Types._Assignment);
		private static final @NonNull FlatFragment _Assignment__Element = LIBRARY.createFragment(Types._Assignment, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _Assignment__OclAny = LIBRARY.createFragment(Types._Assignment, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Assignment__OclElement = LIBRARY.createFragment(Types._Assignment, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _BottomPattern__BottomPattern = LIBRARY.createFragment(Types._BottomPattern, QVTcoreTables.Types._BottomPattern);
		private static final @NonNull FlatFragment _BottomPattern__CorePattern = LIBRARY.createFragment(Types._BottomPattern, QVTcoreTables.Types._CorePattern);
		private static final @NonNull FlatFragment _BottomPattern__Element = LIBRARY.createFragment(Types._BottomPattern, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _BottomPattern__OclAny = LIBRARY.createFragment(Types._BottomPattern, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _BottomPattern__OclElement = LIBRARY.createFragment(Types._BottomPattern, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _BottomPattern__Pattern = LIBRARY.createFragment(Types._BottomPattern, QVTbaseTables.Types._Pattern);

		private static final @NonNull FlatFragment _BottomVariable__BottomVariable = LIBRARY.createFragment(Types._BottomVariable, QVTcoreTables.Types._BottomVariable);
		private static final @NonNull FlatFragment _BottomVariable__Element = LIBRARY.createFragment(Types._BottomVariable, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _BottomVariable__NamedElement = LIBRARY.createFragment(Types._BottomVariable, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _BottomVariable__OclAny = LIBRARY.createFragment(Types._BottomVariable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _BottomVariable__OclElement = LIBRARY.createFragment(Types._BottomVariable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _BottomVariable__TypedElement = LIBRARY.createFragment(Types._BottomVariable, PivotTables.Types._TypedElement);
		private static final @NonNull FlatFragment _BottomVariable__Variable = LIBRARY.createFragment(Types._BottomVariable, PivotTables.Types._Variable);
		private static final @NonNull FlatFragment _BottomVariable__VariableDeclaration = LIBRARY.createFragment(Types._BottomVariable, PivotTables.Types._VariableDeclaration);

		private static final @NonNull FlatFragment _CoreDomain__Area = LIBRARY.createFragment(Types._CoreDomain, QVTcoreTables.Types._Area);
		private static final @NonNull FlatFragment _CoreDomain__CoreDomain = LIBRARY.createFragment(Types._CoreDomain, QVTcoreTables.Types._CoreDomain);
		private static final @NonNull FlatFragment _CoreDomain__Domain = LIBRARY.createFragment(Types._CoreDomain, QVTbaseTables.Types._Domain);
		private static final @NonNull FlatFragment _CoreDomain__Element = LIBRARY.createFragment(Types._CoreDomain, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _CoreDomain__NamedElement = LIBRARY.createFragment(Types._CoreDomain, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _CoreDomain__OclAny = LIBRARY.createFragment(Types._CoreDomain, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _CoreDomain__OclElement = LIBRARY.createFragment(Types._CoreDomain, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _CoreDomain__ReferringElement = LIBRARY.createFragment(Types._CoreDomain, PivotTables.Types._ReferringElement);

		private static final @NonNull FlatFragment _CoreModel__BaseModel = LIBRARY.createFragment(Types._CoreModel, QVTbaseTables.Types._BaseModel);
		private static final @NonNull FlatFragment _CoreModel__CoreModel = LIBRARY.createFragment(Types._CoreModel, QVTcoreTables.Types._CoreModel);
		private static final @NonNull FlatFragment _CoreModel__Element = LIBRARY.createFragment(Types._CoreModel, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _CoreModel__Model = LIBRARY.createFragment(Types._CoreModel, PivotTables.Types._Model);
		private static final @NonNull FlatFragment _CoreModel__NamedElement = LIBRARY.createFragment(Types._CoreModel, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _CoreModel__Namespace = LIBRARY.createFragment(Types._CoreModel, PivotTables.Types._Namespace);
		private static final @NonNull FlatFragment _CoreModel__OclAny = LIBRARY.createFragment(Types._CoreModel, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _CoreModel__OclElement = LIBRARY.createFragment(Types._CoreModel, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _CorePattern__CorePattern = LIBRARY.createFragment(Types._CorePattern, QVTcoreTables.Types._CorePattern);
		private static final @NonNull FlatFragment _CorePattern__Element = LIBRARY.createFragment(Types._CorePattern, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _CorePattern__OclAny = LIBRARY.createFragment(Types._CorePattern, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _CorePattern__OclElement = LIBRARY.createFragment(Types._CorePattern, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _CorePattern__Pattern = LIBRARY.createFragment(Types._CorePattern, QVTbaseTables.Types._Pattern);

		private static final @NonNull FlatFragment _EnforcementMode__EnforcementMode = LIBRARY.createFragment(Types._EnforcementMode, QVTcoreTables.Types._EnforcementMode);
		private static final @NonNull FlatFragment _EnforcementMode__OclAny = LIBRARY.createFragment(Types._EnforcementMode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _EnforcementMode__OclElement = LIBRARY.createFragment(Types._EnforcementMode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _EnforcementMode__OclEnumeration = LIBRARY.createFragment(Types._EnforcementMode, OCLstdlibTables.Types._OclEnumeration);
		private static final @NonNull FlatFragment _EnforcementMode__OclType = LIBRARY.createFragment(Types._EnforcementMode, OCLstdlibTables.Types._OclType);

		private static final @NonNull FlatFragment _EnforcementOperation__Element = LIBRARY.createFragment(Types._EnforcementOperation, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _EnforcementOperation__EnforcementOperation = LIBRARY.createFragment(Types._EnforcementOperation, QVTcoreTables.Types._EnforcementOperation);
		private static final @NonNull FlatFragment _EnforcementOperation__OclAny = LIBRARY.createFragment(Types._EnforcementOperation, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _EnforcementOperation__OclElement = LIBRARY.createFragment(Types._EnforcementOperation, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _GuardPattern__CorePattern = LIBRARY.createFragment(Types._GuardPattern, QVTcoreTables.Types._CorePattern);
		private static final @NonNull FlatFragment _GuardPattern__Element = LIBRARY.createFragment(Types._GuardPattern, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _GuardPattern__GuardPattern = LIBRARY.createFragment(Types._GuardPattern, QVTcoreTables.Types._GuardPattern);
		private static final @NonNull FlatFragment _GuardPattern__OclAny = LIBRARY.createFragment(Types._GuardPattern, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _GuardPattern__OclElement = LIBRARY.createFragment(Types._GuardPattern, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _GuardPattern__Pattern = LIBRARY.createFragment(Types._GuardPattern, QVTbaseTables.Types._Pattern);

		private static final @NonNull FlatFragment _GuardVariable__Element = LIBRARY.createFragment(Types._GuardVariable, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _GuardVariable__GuardVariable = LIBRARY.createFragment(Types._GuardVariable, QVTcoreTables.Types._GuardVariable);
		private static final @NonNull FlatFragment _GuardVariable__NamedElement = LIBRARY.createFragment(Types._GuardVariable, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _GuardVariable__OclAny = LIBRARY.createFragment(Types._GuardVariable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _GuardVariable__OclElement = LIBRARY.createFragment(Types._GuardVariable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _GuardVariable__TypedElement = LIBRARY.createFragment(Types._GuardVariable, PivotTables.Types._TypedElement);
		private static final @NonNull FlatFragment _GuardVariable__Variable = LIBRARY.createFragment(Types._GuardVariable, PivotTables.Types._Variable);
		private static final @NonNull FlatFragment _GuardVariable__VariableDeclaration = LIBRARY.createFragment(Types._GuardVariable, PivotTables.Types._VariableDeclaration);

		private static final @NonNull FlatFragment _Mapping__Area = LIBRARY.createFragment(Types._Mapping, QVTcoreTables.Types._Area);
		private static final @NonNull FlatFragment _Mapping__Element = LIBRARY.createFragment(Types._Mapping, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _Mapping__Mapping = LIBRARY.createFragment(Types._Mapping, QVTcoreTables.Types._Mapping);
		private static final @NonNull FlatFragment _Mapping__NamedElement = LIBRARY.createFragment(Types._Mapping, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _Mapping__OclAny = LIBRARY.createFragment(Types._Mapping, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Mapping__OclElement = LIBRARY.createFragment(Types._Mapping, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Mapping__Rule = LIBRARY.createFragment(Types._Mapping, QVTbaseTables.Types._Rule);

		private static final @NonNull FlatFragment _NavigationAssignment__Assignment = LIBRARY.createFragment(Types._NavigationAssignment, QVTcoreTables.Types._Assignment);
		private static final @NonNull FlatFragment _NavigationAssignment__Element = LIBRARY.createFragment(Types._NavigationAssignment, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _NavigationAssignment__NavigationAssignment = LIBRARY.createFragment(Types._NavigationAssignment, QVTcoreTables.Types._NavigationAssignment);
		private static final @NonNull FlatFragment _NavigationAssignment__OclAny = LIBRARY.createFragment(Types._NavigationAssignment, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _NavigationAssignment__OclElement = LIBRARY.createFragment(Types._NavigationAssignment, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _OppositePropertyAssignment__Assignment = LIBRARY.createFragment(Types._OppositePropertyAssignment, QVTcoreTables.Types._Assignment);
		private static final @NonNull FlatFragment _OppositePropertyAssignment__Element = LIBRARY.createFragment(Types._OppositePropertyAssignment, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _OppositePropertyAssignment__NavigationAssignment = LIBRARY.createFragment(Types._OppositePropertyAssignment, QVTcoreTables.Types._NavigationAssignment);
		private static final @NonNull FlatFragment _OppositePropertyAssignment__OclAny = LIBRARY.createFragment(Types._OppositePropertyAssignment, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _OppositePropertyAssignment__OclElement = LIBRARY.createFragment(Types._OppositePropertyAssignment, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _OppositePropertyAssignment__OppositePropertyAssignment = LIBRARY.createFragment(Types._OppositePropertyAssignment, QVTcoreTables.Types._OppositePropertyAssignment);

		private static final @NonNull FlatFragment _PropertyAssignment__Assignment = LIBRARY.createFragment(Types._PropertyAssignment, QVTcoreTables.Types._Assignment);
		private static final @NonNull FlatFragment _PropertyAssignment__Element = LIBRARY.createFragment(Types._PropertyAssignment, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _PropertyAssignment__NavigationAssignment = LIBRARY.createFragment(Types._PropertyAssignment, QVTcoreTables.Types._NavigationAssignment);
		private static final @NonNull FlatFragment _PropertyAssignment__OclAny = LIBRARY.createFragment(Types._PropertyAssignment, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _PropertyAssignment__OclElement = LIBRARY.createFragment(Types._PropertyAssignment, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _PropertyAssignment__PropertyAssignment = LIBRARY.createFragment(Types._PropertyAssignment, QVTcoreTables.Types._PropertyAssignment);

		private static final @NonNull FlatFragment _RealizedVariable__Element = LIBRARY.createFragment(Types._RealizedVariable, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _RealizedVariable__NamedElement = LIBRARY.createFragment(Types._RealizedVariable, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _RealizedVariable__OclAny = LIBRARY.createFragment(Types._RealizedVariable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _RealizedVariable__OclElement = LIBRARY.createFragment(Types._RealizedVariable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _RealizedVariable__RealizedVariable = LIBRARY.createFragment(Types._RealizedVariable, QVTcoreTables.Types._RealizedVariable);
		private static final @NonNull FlatFragment _RealizedVariable__TypedElement = LIBRARY.createFragment(Types._RealizedVariable, PivotTables.Types._TypedElement);
		private static final @NonNull FlatFragment _RealizedVariable__Variable = LIBRARY.createFragment(Types._RealizedVariable, PivotTables.Types._Variable);
		private static final @NonNull FlatFragment _RealizedVariable__VariableDeclaration = LIBRARY.createFragment(Types._RealizedVariable, PivotTables.Types._VariableDeclaration);

		private static final @NonNull FlatFragment _VariableAssignment__Assignment = LIBRARY.createFragment(Types._VariableAssignment, QVTcoreTables.Types._Assignment);
		private static final @NonNull FlatFragment _VariableAssignment__Element = LIBRARY.createFragment(Types._VariableAssignment, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _VariableAssignment__OclAny = LIBRARY.createFragment(Types._VariableAssignment, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _VariableAssignment__OclElement = LIBRARY.createFragment(Types._VariableAssignment, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _VariableAssignment__VariableAssignment = LIBRARY.createFragment(Types._VariableAssignment, QVTcoreTables.Types._VariableAssignment);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTcoreTables::Fragments and all preceding sub-packages.
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
		 * Force initialization of the fields of QVTcoreTables::Parameters and all preceding sub-packages.
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

		public static final @NonNull Operation _CorePattern__getArea = LIBRARY.createOperation("getArea", ParameterTypes.EMPTY_LIST, Types._CorePattern,
			0, TemplateParameters.EMPTY_LIST, null);

		public static final @NonNull Operation _OppositePropertyAssignment__getReferredTargetProperty = LIBRARY.createOperation("getReferredTargetProperty", ParameterTypes.EMPTY_LIST, Types._OppositePropertyAssignment,
			0, TemplateParameters.EMPTY_LIST, null);

		public static final @NonNull Operation _PropertyAssignment__getReferredTargetProperty = LIBRARY.createOperation("getReferredTargetProperty", ParameterTypes.EMPTY_LIST, Types._PropertyAssignment,
			0, TemplateParameters.EMPTY_LIST, null);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTcoreTables::Operations and all preceding sub-packages.
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

		public static final @NonNull Property _Area__bottomPattern = LIBRARY.createProperty(QVTcorePackage.Literals.AREA__BOTTOM_PATTERN, Types._Area, 0);
		public static final @NonNull Property _Area__guardPattern = LIBRARY.createProperty(QVTcorePackage.Literals.AREA__GUARD_PATTERN, Types._Area, 1);

		public static final @NonNull Property _Assignment__bottomPattern = LIBRARY.createProperty(QVTcorePackage.Literals.ASSIGNMENT__BOTTOM_PATTERN, Types._Assignment, 0);
		public static final @NonNull Property _Assignment__isDefault = LIBRARY.createProperty(QVTcorePackage.Literals.ASSIGNMENT__IS_DEFAULT, Types._Assignment, 1);
		public static final @NonNull Property _Assignment__isPartial = LIBRARY.createProperty(QVTcorePackage.Literals.ASSIGNMENT__IS_PARTIAL, Types._Assignment, 2);
		public static final @NonNull Property _Assignment__value = LIBRARY.createProperty(QVTcorePackage.Literals.ASSIGNMENT__VALUE, Types._Assignment, 3);

		public static final @NonNull Property _BottomPattern__area = LIBRARY.createProperty(QVTcorePackage.Literals.BOTTOM_PATTERN__AREA, Types._BottomPattern, 0);
		public static final @NonNull Property _BottomPattern__assignment = LIBRARY.createProperty(QVTcorePackage.Literals.BOTTOM_PATTERN__ASSIGNMENT, Types._BottomPattern, 1);
		public static final @NonNull Property _BottomPattern__enforcementOperation = LIBRARY.createProperty(QVTcorePackage.Literals.BOTTOM_PATTERN__ENFORCEMENT_OPERATION, Types._BottomPattern, 2);
		public static final @NonNull Property _BottomPattern__realizedVariable = LIBRARY.createProperty(QVTcorePackage.Literals.BOTTOM_PATTERN__REALIZED_VARIABLE, Types._BottomPattern, 3);

		public static final @NonNull Property _CorePattern__ownedVariables = LIBRARY.createProperty(QVTcorePackage.Literals.CORE_PATTERN__OWNED_VARIABLES, Types._CorePattern, 0);

		public static final @NonNull Property _EnforcementOperation__bottomPattern = LIBRARY.createProperty(QVTcorePackage.Literals.ENFORCEMENT_OPERATION__BOTTOM_PATTERN, Types._EnforcementOperation, 0);
		public static final @NonNull Property _EnforcementOperation__enforcementMode = LIBRARY.createProperty(QVTcorePackage.Literals.ENFORCEMENT_OPERATION__ENFORCEMENT_MODE, Types._EnforcementOperation, 1);
		public static final @NonNull Property _EnforcementOperation__operationCallExp = LIBRARY.createProperty(QVTcorePackage.Literals.ENFORCEMENT_OPERATION__OPERATION_CALL_EXP, Types._EnforcementOperation, 2);

		public static final @NonNull Property _GuardPattern__area = LIBRARY.createProperty(QVTcorePackage.Literals.GUARD_PATTERN__AREA, Types._GuardPattern, 0);

		public static final @NonNull Property _Mapping__context = LIBRARY.createProperty(QVTcorePackage.Literals.MAPPING__CONTEXT, Types._Mapping, 0);
		public static final @NonNull Property _Mapping__local = LIBRARY.createProperty(QVTcorePackage.Literals.MAPPING__LOCAL, Types._Mapping, 1);
		public static final @NonNull Property _Mapping__refinement = LIBRARY.createProperty(QVTcorePackage.Literals.MAPPING__REFINEMENT, Types._Mapping, 2);
		public static final @NonNull Property _Mapping__specification = LIBRARY.createProperty(QVTcorePackage.Literals.MAPPING__SPECIFICATION, Types._Mapping, 3);

		public static final @NonNull Property _NavigationAssignment__slotExpression = LIBRARY.createProperty(QVTcorePackage.Literals.NAVIGATION_ASSIGNMENT__SLOT_EXPRESSION, Types._NavigationAssignment, 0);
		public static final @NonNull Property _NavigationAssignment__targetProperty = LIBRARY.createProperty(QVTcorePackage.Literals.NAVIGATION_ASSIGNMENT__TARGET_PROPERTY, Types._NavigationAssignment, 1);

		public static final @NonNull Property _RealizedVariable__BottomPattern__realizedVariable = LIBRARY.createOppositeProperty("BottomPattern", Types._RealizedVariable, 0, QVTcorePackage.Literals.BOTTOM_PATTERN__REALIZED_VARIABLE);

		public static final @NonNull Property _VariableAssignment__targetVariable = LIBRARY.createProperty(QVTcorePackage.Literals.VARIABLE_ASSIGNMENT__TARGET_VARIABLE, Types._VariableAssignment, 0);
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTcoreTables::Properties and all preceding sub-packages.
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

		private static final @NonNull FlatFragment @NonNull [] _Area =
			{
				Fragments._Area__OclAny /* 0 */,
				Fragments._Area__OclElement /* 1 */,
				Fragments._Area__Element /* 2 */,
				Fragments._Area__Area /* 3 */
			};
		private static final int @NonNull [] __Area = { 1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Assignment =
			{
				Fragments._Assignment__OclAny /* 0 */,
				Fragments._Assignment__OclElement /* 1 */,
				Fragments._Assignment__Element /* 2 */,
				Fragments._Assignment__Assignment /* 3 */
			};
		private static final int @NonNull [] __Assignment = { 1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _BottomPattern =
			{
				Fragments._BottomPattern__OclAny /* 0 */,
				Fragments._BottomPattern__OclElement /* 1 */,
				Fragments._BottomPattern__Element /* 2 */,
				Fragments._BottomPattern__Pattern /* 3 */,
				Fragments._BottomPattern__CorePattern /* 4 */,
				Fragments._BottomPattern__BottomPattern /* 5 */
			};
		private static final int @NonNull [] __BottomPattern = { 1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _BottomVariable =
			{
				Fragments._BottomVariable__OclAny /* 0 */,
				Fragments._BottomVariable__OclElement /* 1 */,
				Fragments._BottomVariable__Element /* 2 */,
				Fragments._BottomVariable__NamedElement /* 3 */,
				Fragments._BottomVariable__TypedElement /* 4 */,
				Fragments._BottomVariable__VariableDeclaration /* 5 */,
				Fragments._BottomVariable__Variable /* 6 */,
				Fragments._BottomVariable__BottomVariable /* 7 */
			};
		private static final int @NonNull [] __BottomVariable = { 1,1,1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _CoreDomain =
			{
				Fragments._CoreDomain__OclAny /* 0 */,
				Fragments._CoreDomain__OclElement /* 1 */,
				Fragments._CoreDomain__Element /* 2 */,
				Fragments._CoreDomain__ReferringElement /* 2 */,
				Fragments._CoreDomain__Area /* 3 */,
				Fragments._CoreDomain__NamedElement /* 3 */,
				Fragments._CoreDomain__Domain /* 4 */,
				Fragments._CoreDomain__CoreDomain /* 5 */
			};
		private static final int @NonNull [] __CoreDomain = { 1,1,2,2,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _CoreModel =
			{
				Fragments._CoreModel__OclAny /* 0 */,
				Fragments._CoreModel__OclElement /* 1 */,
				Fragments._CoreModel__Element /* 2 */,
				Fragments._CoreModel__NamedElement /* 3 */,
				Fragments._CoreModel__Namespace /* 4 */,
				Fragments._CoreModel__Model /* 5 */,
				Fragments._CoreModel__BaseModel /* 6 */,
				Fragments._CoreModel__CoreModel /* 7 */
			};
		private static final int @NonNull [] __CoreModel = { 1,1,1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _CorePattern =
			{
				Fragments._CorePattern__OclAny /* 0 */,
				Fragments._CorePattern__OclElement /* 1 */,
				Fragments._CorePattern__Element /* 2 */,
				Fragments._CorePattern__Pattern /* 3 */,
				Fragments._CorePattern__CorePattern /* 4 */
			};
		private static final int @NonNull [] __CorePattern = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _EnforcementMode =
			{
				Fragments._EnforcementMode__OclAny /* 0 */,
				Fragments._EnforcementMode__OclElement /* 1 */,
				Fragments._EnforcementMode__OclType /* 2 */,
				Fragments._EnforcementMode__OclEnumeration /* 3 */,
				Fragments._EnforcementMode__EnforcementMode /* 4 */
			};
		private static final int @NonNull [] __EnforcementMode = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _EnforcementOperation =
			{
				Fragments._EnforcementOperation__OclAny /* 0 */,
				Fragments._EnforcementOperation__OclElement /* 1 */,
				Fragments._EnforcementOperation__Element /* 2 */,
				Fragments._EnforcementOperation__EnforcementOperation /* 3 */
			};
		private static final int @NonNull [] __EnforcementOperation = { 1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _GuardPattern =
			{
				Fragments._GuardPattern__OclAny /* 0 */,
				Fragments._GuardPattern__OclElement /* 1 */,
				Fragments._GuardPattern__Element /* 2 */,
				Fragments._GuardPattern__Pattern /* 3 */,
				Fragments._GuardPattern__CorePattern /* 4 */,
				Fragments._GuardPattern__GuardPattern /* 5 */
			};
		private static final int @NonNull [] __GuardPattern = { 1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _GuardVariable =
			{
				Fragments._GuardVariable__OclAny /* 0 */,
				Fragments._GuardVariable__OclElement /* 1 */,
				Fragments._GuardVariable__Element /* 2 */,
				Fragments._GuardVariable__NamedElement /* 3 */,
				Fragments._GuardVariable__TypedElement /* 4 */,
				Fragments._GuardVariable__VariableDeclaration /* 5 */,
				Fragments._GuardVariable__Variable /* 6 */,
				Fragments._GuardVariable__GuardVariable /* 7 */
			};
		private static final int @NonNull [] __GuardVariable = { 1,1,1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Mapping =
			{
				Fragments._Mapping__OclAny /* 0 */,
				Fragments._Mapping__OclElement /* 1 */,
				Fragments._Mapping__Element /* 2 */,
				Fragments._Mapping__Area /* 3 */,
				Fragments._Mapping__NamedElement /* 3 */,
				Fragments._Mapping__Rule /* 4 */,
				Fragments._Mapping__Mapping /* 5 */
			};
		private static final int @NonNull [] __Mapping = { 1,1,1,2,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _NavigationAssignment =
			{
				Fragments._NavigationAssignment__OclAny /* 0 */,
				Fragments._NavigationAssignment__OclElement /* 1 */,
				Fragments._NavigationAssignment__Element /* 2 */,
				Fragments._NavigationAssignment__Assignment /* 3 */,
				Fragments._NavigationAssignment__NavigationAssignment /* 4 */
			};
		private static final int @NonNull [] __NavigationAssignment = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _OppositePropertyAssignment =
			{
				Fragments._OppositePropertyAssignment__OclAny /* 0 */,
				Fragments._OppositePropertyAssignment__OclElement /* 1 */,
				Fragments._OppositePropertyAssignment__Element /* 2 */,
				Fragments._OppositePropertyAssignment__Assignment /* 3 */,
				Fragments._OppositePropertyAssignment__NavigationAssignment /* 4 */,
				Fragments._OppositePropertyAssignment__OppositePropertyAssignment /* 5 */
			};
		private static final int @NonNull [] __OppositePropertyAssignment = { 1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _PropertyAssignment =
			{
				Fragments._PropertyAssignment__OclAny /* 0 */,
				Fragments._PropertyAssignment__OclElement /* 1 */,
				Fragments._PropertyAssignment__Element /* 2 */,
				Fragments._PropertyAssignment__Assignment /* 3 */,
				Fragments._PropertyAssignment__NavigationAssignment /* 4 */,
				Fragments._PropertyAssignment__PropertyAssignment /* 5 */
			};
		private static final int @NonNull [] __PropertyAssignment = { 1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _RealizedVariable =
			{
				Fragments._RealizedVariable__OclAny /* 0 */,
				Fragments._RealizedVariable__OclElement /* 1 */,
				Fragments._RealizedVariable__Element /* 2 */,
				Fragments._RealizedVariable__NamedElement /* 3 */,
				Fragments._RealizedVariable__TypedElement /* 4 */,
				Fragments._RealizedVariable__VariableDeclaration /* 5 */,
				Fragments._RealizedVariable__Variable /* 6 */,
				Fragments._RealizedVariable__RealizedVariable /* 7 */
			};
		private static final int @NonNull [] __RealizedVariable = { 1,1,1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _VariableAssignment =
			{
				Fragments._VariableAssignment__OclAny /* 0 */,
				Fragments._VariableAssignment__OclElement /* 1 */,
				Fragments._VariableAssignment__Element /* 2 */,
				Fragments._VariableAssignment__Assignment /* 3 */,
				Fragments._VariableAssignment__VariableAssignment /* 4 */
			};
		private static final int @NonNull [] __VariableAssignment = { 1,1,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._Area.initFragments(_Area, __Area);
			Types._Assignment.initFragments(_Assignment, __Assignment);
			Types._BottomPattern.initFragments(_BottomPattern, __BottomPattern);
			Types._BottomVariable.initFragments(_BottomVariable, __BottomVariable);
			Types._CoreDomain.initFragments(_CoreDomain, __CoreDomain);
			Types._CoreModel.initFragments(_CoreModel, __CoreModel);
			Types._CorePattern.initFragments(_CorePattern, __CorePattern);
			Types._EnforcementMode.initFragments(_EnforcementMode, __EnforcementMode);
			Types._EnforcementOperation.initFragments(_EnforcementOperation, __EnforcementOperation);
			Types._GuardPattern.initFragments(_GuardPattern, __GuardPattern);
			Types._GuardVariable.initFragments(_GuardVariable, __GuardVariable);
			Types._Mapping.initFragments(_Mapping, __Mapping);
			Types._NavigationAssignment.initFragments(_NavigationAssignment, __NavigationAssignment);
			Types._OppositePropertyAssignment.initFragments(_OppositePropertyAssignment, __OppositePropertyAssignment);
			Types._PropertyAssignment.initFragments(_PropertyAssignment, __PropertyAssignment);
			Types._RealizedVariable.initFragments(_RealizedVariable, __RealizedVariable);
			Types._VariableAssignment.initFragments(_VariableAssignment, __VariableAssignment);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTcoreTables::TypeFragments and all preceding sub-packages.
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

		private static final @NonNull Operation @NonNull [] _Area__Area = {};
		private static final @NonNull Operation @NonNull [] _Area__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _Area__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _Area__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _Assignment__Assignment = {};
		private static final @NonNull Operation @NonNull [] _Assignment__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _Assignment__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _Assignment__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _BottomPattern__BottomPattern = {};
		private static final @NonNull Operation @NonNull [] _BottomPattern__CorePattern = {
			QVTcoreTables.Operations._CorePattern__getArea /* getArea() */
		};
		private static final @NonNull Operation @NonNull [] _BottomPattern__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _BottomPattern__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _BottomPattern__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _BottomPattern__Pattern = {};

		private static final @NonNull Operation @NonNull [] _BottomVariable__BottomVariable = {};
		private static final @NonNull Operation @NonNull [] _BottomVariable__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _BottomVariable__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _BottomVariable__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _BottomVariable__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _BottomVariable__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull Operation @NonNull [] _BottomVariable__Variable = {};
		private static final @NonNull Operation @NonNull [] _BottomVariable__VariableDeclaration = {};

		private static final @NonNull Operation @NonNull [] _CoreDomain__CoreDomain = {};
		private static final @NonNull Operation @NonNull [] _CoreDomain__Area = {};
		private static final @NonNull Operation @NonNull [] _CoreDomain__Domain = {};
		private static final @NonNull Operation @NonNull [] _CoreDomain__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _CoreDomain__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _CoreDomain__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _CoreDomain__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _CoreDomain__ReferringElement = {
			PivotTables.Operations._ReferringElement__getReferredElement /* getReferredElement() */
		};

		private static final @NonNull Operation @NonNull [] _CoreModel__CoreModel = {};
		private static final @NonNull Operation @NonNull [] _CoreModel__BaseModel = {};
		private static final @NonNull Operation @NonNull [] _CoreModel__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _CoreModel__Model = {};
		private static final @NonNull Operation @NonNull [] _CoreModel__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _CoreModel__Namespace = {};
		private static final @NonNull Operation @NonNull [] _CoreModel__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _CoreModel__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _CorePattern__CorePattern = {
			QVTcoreTables.Operations._CorePattern__getArea /* getArea() */
		};
		private static final @NonNull Operation @NonNull [] _CorePattern__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _CorePattern__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _CorePattern__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _CorePattern__Pattern = {};

		private static final @NonNull Operation @NonNull [] _EnforcementMode__EnforcementMode = {};
		private static final @NonNull Operation @NonNull [] _EnforcementMode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _EnforcementMode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _EnforcementMode__OclEnumeration = {};
		private static final @NonNull Operation @NonNull [] _EnforcementMode__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final @NonNull Operation @NonNull [] _EnforcementOperation__EnforcementOperation = {};
		private static final @NonNull Operation @NonNull [] _EnforcementOperation__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _EnforcementOperation__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _EnforcementOperation__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _GuardPattern__GuardPattern = {};
		private static final @NonNull Operation @NonNull [] _GuardPattern__CorePattern = {
			QVTcoreTables.Operations._CorePattern__getArea /* getArea() */
		};
		private static final @NonNull Operation @NonNull [] _GuardPattern__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _GuardPattern__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _GuardPattern__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _GuardPattern__Pattern = {};

		private static final @NonNull Operation @NonNull [] _GuardVariable__GuardVariable = {};
		private static final @NonNull Operation @NonNull [] _GuardVariable__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _GuardVariable__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _GuardVariable__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _GuardVariable__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _GuardVariable__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull Operation @NonNull [] _GuardVariable__Variable = {};
		private static final @NonNull Operation @NonNull [] _GuardVariable__VariableDeclaration = {};

		private static final @NonNull Operation @NonNull [] _Mapping__Mapping = {};
		private static final @NonNull Operation @NonNull [] _Mapping__Area = {};
		private static final @NonNull Operation @NonNull [] _Mapping__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _Mapping__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _Mapping__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _Mapping__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _Mapping__Rule = {};

		private static final @NonNull Operation @NonNull [] _NavigationAssignment__NavigationAssignment = {};
		private static final @NonNull Operation @NonNull [] _NavigationAssignment__Assignment = {};
		private static final @NonNull Operation @NonNull [] _NavigationAssignment__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _NavigationAssignment__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _NavigationAssignment__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _OppositePropertyAssignment__OppositePropertyAssignment = {
			QVTcoreTables.Operations._OppositePropertyAssignment__getReferredTargetProperty /* getReferredTargetProperty() */
		};
		private static final @NonNull Operation @NonNull [] _OppositePropertyAssignment__Assignment = {};
		private static final @NonNull Operation @NonNull [] _OppositePropertyAssignment__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _OppositePropertyAssignment__NavigationAssignment = {};
		private static final @NonNull Operation @NonNull [] _OppositePropertyAssignment__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _OppositePropertyAssignment__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _PropertyAssignment__PropertyAssignment = {
			QVTcoreTables.Operations._PropertyAssignment__getReferredTargetProperty /* getReferredTargetProperty() */
		};
		private static final @NonNull Operation @NonNull [] _PropertyAssignment__Assignment = {};
		private static final @NonNull Operation @NonNull [] _PropertyAssignment__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _PropertyAssignment__NavigationAssignment = {};
		private static final @NonNull Operation @NonNull [] _PropertyAssignment__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _PropertyAssignment__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _RealizedVariable__RealizedVariable = {};
		private static final @NonNull Operation @NonNull [] _RealizedVariable__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _RealizedVariable__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _RealizedVariable__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _RealizedVariable__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _RealizedVariable__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};
		private static final @NonNull Operation @NonNull [] _RealizedVariable__Variable = {};
		private static final @NonNull Operation @NonNull [] _RealizedVariable__VariableDeclaration = {};

		private static final @NonNull Operation @NonNull [] _VariableAssignment__VariableAssignment = {};
		private static final @NonNull Operation @NonNull [] _VariableAssignment__Assignment = {};
		private static final @NonNull Operation @NonNull [] _VariableAssignment__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _VariableAssignment__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _VariableAssignment__OclElement = {
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
			Fragments._Area__Area.initOperations(_Area__Area);
			Fragments._Area__Element.initOperations(_Area__Element);
			Fragments._Area__OclAny.initOperations(_Area__OclAny);
			Fragments._Area__OclElement.initOperations(_Area__OclElement);

			Fragments._Assignment__Assignment.initOperations(_Assignment__Assignment);
			Fragments._Assignment__Element.initOperations(_Assignment__Element);
			Fragments._Assignment__OclAny.initOperations(_Assignment__OclAny);
			Fragments._Assignment__OclElement.initOperations(_Assignment__OclElement);

			Fragments._BottomPattern__BottomPattern.initOperations(_BottomPattern__BottomPattern);
			Fragments._BottomPattern__CorePattern.initOperations(_BottomPattern__CorePattern);
			Fragments._BottomPattern__Element.initOperations(_BottomPattern__Element);
			Fragments._BottomPattern__OclAny.initOperations(_BottomPattern__OclAny);
			Fragments._BottomPattern__OclElement.initOperations(_BottomPattern__OclElement);
			Fragments._BottomPattern__Pattern.initOperations(_BottomPattern__Pattern);

			Fragments._BottomVariable__BottomVariable.initOperations(_BottomVariable__BottomVariable);
			Fragments._BottomVariable__Element.initOperations(_BottomVariable__Element);
			Fragments._BottomVariable__NamedElement.initOperations(_BottomVariable__NamedElement);
			Fragments._BottomVariable__OclAny.initOperations(_BottomVariable__OclAny);
			Fragments._BottomVariable__OclElement.initOperations(_BottomVariable__OclElement);
			Fragments._BottomVariable__TypedElement.initOperations(_BottomVariable__TypedElement);
			Fragments._BottomVariable__Variable.initOperations(_BottomVariable__Variable);
			Fragments._BottomVariable__VariableDeclaration.initOperations(_BottomVariable__VariableDeclaration);

			Fragments._CoreDomain__Area.initOperations(_CoreDomain__Area);
			Fragments._CoreDomain__CoreDomain.initOperations(_CoreDomain__CoreDomain);
			Fragments._CoreDomain__Domain.initOperations(_CoreDomain__Domain);
			Fragments._CoreDomain__Element.initOperations(_CoreDomain__Element);
			Fragments._CoreDomain__NamedElement.initOperations(_CoreDomain__NamedElement);
			Fragments._CoreDomain__OclAny.initOperations(_CoreDomain__OclAny);
			Fragments._CoreDomain__OclElement.initOperations(_CoreDomain__OclElement);
			Fragments._CoreDomain__ReferringElement.initOperations(_CoreDomain__ReferringElement);

			Fragments._CoreModel__BaseModel.initOperations(_CoreModel__BaseModel);
			Fragments._CoreModel__CoreModel.initOperations(_CoreModel__CoreModel);
			Fragments._CoreModel__Element.initOperations(_CoreModel__Element);
			Fragments._CoreModel__Model.initOperations(_CoreModel__Model);
			Fragments._CoreModel__NamedElement.initOperations(_CoreModel__NamedElement);
			Fragments._CoreModel__Namespace.initOperations(_CoreModel__Namespace);
			Fragments._CoreModel__OclAny.initOperations(_CoreModel__OclAny);
			Fragments._CoreModel__OclElement.initOperations(_CoreModel__OclElement);

			Fragments._CorePattern__CorePattern.initOperations(_CorePattern__CorePattern);
			Fragments._CorePattern__Element.initOperations(_CorePattern__Element);
			Fragments._CorePattern__OclAny.initOperations(_CorePattern__OclAny);
			Fragments._CorePattern__OclElement.initOperations(_CorePattern__OclElement);
			Fragments._CorePattern__Pattern.initOperations(_CorePattern__Pattern);

			Fragments._EnforcementMode__EnforcementMode.initOperations(_EnforcementMode__EnforcementMode);
			Fragments._EnforcementMode__OclAny.initOperations(_EnforcementMode__OclAny);
			Fragments._EnforcementMode__OclElement.initOperations(_EnforcementMode__OclElement);
			Fragments._EnforcementMode__OclEnumeration.initOperations(_EnforcementMode__OclEnumeration);
			Fragments._EnforcementMode__OclType.initOperations(_EnforcementMode__OclType);

			Fragments._EnforcementOperation__Element.initOperations(_EnforcementOperation__Element);
			Fragments._EnforcementOperation__EnforcementOperation.initOperations(_EnforcementOperation__EnforcementOperation);
			Fragments._EnforcementOperation__OclAny.initOperations(_EnforcementOperation__OclAny);
			Fragments._EnforcementOperation__OclElement.initOperations(_EnforcementOperation__OclElement);

			Fragments._GuardPattern__CorePattern.initOperations(_GuardPattern__CorePattern);
			Fragments._GuardPattern__Element.initOperations(_GuardPattern__Element);
			Fragments._GuardPattern__GuardPattern.initOperations(_GuardPattern__GuardPattern);
			Fragments._GuardPattern__OclAny.initOperations(_GuardPattern__OclAny);
			Fragments._GuardPattern__OclElement.initOperations(_GuardPattern__OclElement);
			Fragments._GuardPattern__Pattern.initOperations(_GuardPattern__Pattern);

			Fragments._GuardVariable__Element.initOperations(_GuardVariable__Element);
			Fragments._GuardVariable__GuardVariable.initOperations(_GuardVariable__GuardVariable);
			Fragments._GuardVariable__NamedElement.initOperations(_GuardVariable__NamedElement);
			Fragments._GuardVariable__OclAny.initOperations(_GuardVariable__OclAny);
			Fragments._GuardVariable__OclElement.initOperations(_GuardVariable__OclElement);
			Fragments._GuardVariable__TypedElement.initOperations(_GuardVariable__TypedElement);
			Fragments._GuardVariable__Variable.initOperations(_GuardVariable__Variable);
			Fragments._GuardVariable__VariableDeclaration.initOperations(_GuardVariable__VariableDeclaration);

			Fragments._Mapping__Area.initOperations(_Mapping__Area);
			Fragments._Mapping__Element.initOperations(_Mapping__Element);
			Fragments._Mapping__Mapping.initOperations(_Mapping__Mapping);
			Fragments._Mapping__NamedElement.initOperations(_Mapping__NamedElement);
			Fragments._Mapping__OclAny.initOperations(_Mapping__OclAny);
			Fragments._Mapping__OclElement.initOperations(_Mapping__OclElement);
			Fragments._Mapping__Rule.initOperations(_Mapping__Rule);

			Fragments._NavigationAssignment__Assignment.initOperations(_NavigationAssignment__Assignment);
			Fragments._NavigationAssignment__Element.initOperations(_NavigationAssignment__Element);
			Fragments._NavigationAssignment__NavigationAssignment.initOperations(_NavigationAssignment__NavigationAssignment);
			Fragments._NavigationAssignment__OclAny.initOperations(_NavigationAssignment__OclAny);
			Fragments._NavigationAssignment__OclElement.initOperations(_NavigationAssignment__OclElement);

			Fragments._OppositePropertyAssignment__Assignment.initOperations(_OppositePropertyAssignment__Assignment);
			Fragments._OppositePropertyAssignment__Element.initOperations(_OppositePropertyAssignment__Element);
			Fragments._OppositePropertyAssignment__NavigationAssignment.initOperations(_OppositePropertyAssignment__NavigationAssignment);
			Fragments._OppositePropertyAssignment__OclAny.initOperations(_OppositePropertyAssignment__OclAny);
			Fragments._OppositePropertyAssignment__OclElement.initOperations(_OppositePropertyAssignment__OclElement);
			Fragments._OppositePropertyAssignment__OppositePropertyAssignment.initOperations(_OppositePropertyAssignment__OppositePropertyAssignment);

			Fragments._PropertyAssignment__Assignment.initOperations(_PropertyAssignment__Assignment);
			Fragments._PropertyAssignment__Element.initOperations(_PropertyAssignment__Element);
			Fragments._PropertyAssignment__NavigationAssignment.initOperations(_PropertyAssignment__NavigationAssignment);
			Fragments._PropertyAssignment__OclAny.initOperations(_PropertyAssignment__OclAny);
			Fragments._PropertyAssignment__OclElement.initOperations(_PropertyAssignment__OclElement);
			Fragments._PropertyAssignment__PropertyAssignment.initOperations(_PropertyAssignment__PropertyAssignment);

			Fragments._RealizedVariable__Element.initOperations(_RealizedVariable__Element);
			Fragments._RealizedVariable__NamedElement.initOperations(_RealizedVariable__NamedElement);
			Fragments._RealizedVariable__OclAny.initOperations(_RealizedVariable__OclAny);
			Fragments._RealizedVariable__OclElement.initOperations(_RealizedVariable__OclElement);
			Fragments._RealizedVariable__RealizedVariable.initOperations(_RealizedVariable__RealizedVariable);
			Fragments._RealizedVariable__TypedElement.initOperations(_RealizedVariable__TypedElement);
			Fragments._RealizedVariable__Variable.initOperations(_RealizedVariable__Variable);
			Fragments._RealizedVariable__VariableDeclaration.initOperations(_RealizedVariable__VariableDeclaration);

			Fragments._VariableAssignment__Assignment.initOperations(_VariableAssignment__Assignment);
			Fragments._VariableAssignment__Element.initOperations(_VariableAssignment__Element);
			Fragments._VariableAssignment__OclAny.initOperations(_VariableAssignment__OclAny);
			Fragments._VariableAssignment__OclElement.initOperations(_VariableAssignment__OclElement);
			Fragments._VariableAssignment__VariableAssignment.initOperations(_VariableAssignment__VariableAssignment);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTcoreTables::FragmentOperations and all preceding sub-packages.
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

		private static final @NonNull Property @NonNull [] _Area = {
			PivotTables.Properties._Element__annotatingComments,
			QVTcoreTables.Properties._Area__bottomPattern,
			QVTcoreTables.Properties._Area__guardPattern,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions
		};

		private static final @NonNull Property @NonNull [] _Assignment = {
			PivotTables.Properties._Element__annotatingComments,
			QVTcoreTables.Properties._Assignment__bottomPattern,
			QVTcoreTables.Properties._Assignment__isDefault,
			QVTcoreTables.Properties._Assignment__isPartial,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTcoreTables.Properties._Assignment__value
		};

		private static final @NonNull Property @NonNull [] _BottomPattern = {
			PivotTables.Properties._Element__annotatingComments,
			QVTcoreTables.Properties._BottomPattern__area,
			QVTcoreTables.Properties._BottomPattern__assignment,
			QVTbaseTables.Properties._Pattern__bindsTo,
			QVTcoreTables.Properties._BottomPattern__enforcementOperation,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTcoreTables.Properties._CorePattern__ownedVariables,
			QVTbaseTables.Properties._Pattern__predicate,
			QVTcoreTables.Properties._BottomPattern__realizedVariable
		};

		private static final @NonNull Property @NonNull [] _BottomVariable = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._Variable__isImplicit,
			PivotTables.Properties._TypedElement__isMany,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			PivotTables.Properties._Variable__ownedInit,
			PivotTables.Properties._Variable__representedParameter,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._VariableDeclaration__typeValue
		};

		private static final @NonNull Property @NonNull [] _CoreDomain = {
			PivotTables.Properties._Element__annotatingComments,
			QVTcoreTables.Properties._Area__bottomPattern,
			QVTcoreTables.Properties._Area__guardPattern,
			QVTbaseTables.Properties._Domain__isCheckable,
			QVTbaseTables.Properties._Domain__isEnforceable,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTbaseTables.Properties._Domain__rule,
			QVTbaseTables.Properties._Domain__typedModel
		};

		private static final @NonNull Property @NonNull [] _CoreModel = {
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

		private static final @NonNull Property @NonNull [] _CorePattern = {
			PivotTables.Properties._Element__annotatingComments,
			QVTbaseTables.Properties._Pattern__bindsTo,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTcoreTables.Properties._CorePattern__ownedVariables,
			QVTbaseTables.Properties._Pattern__predicate
		};

		private static final @NonNull Property @NonNull [] _EnforcementMode = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _EnforcementOperation = {
			PivotTables.Properties._Element__annotatingComments,
			QVTcoreTables.Properties._EnforcementOperation__bottomPattern,
			QVTcoreTables.Properties._EnforcementOperation__enforcementMode,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			QVTcoreTables.Properties._EnforcementOperation__operationCallExp,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions
		};

		private static final @NonNull Property @NonNull [] _GuardPattern = {
			PivotTables.Properties._Element__annotatingComments,
			QVTcoreTables.Properties._GuardPattern__area,
			QVTbaseTables.Properties._Pattern__bindsTo,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTcoreTables.Properties._CorePattern__ownedVariables,
			QVTbaseTables.Properties._Pattern__predicate
		};

		private static final @NonNull Property @NonNull [] _GuardVariable = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._Variable__isImplicit,
			PivotTables.Properties._TypedElement__isMany,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			PivotTables.Properties._Variable__ownedInit,
			PivotTables.Properties._Variable__representedParameter,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._VariableDeclaration__typeValue
		};

		private static final @NonNull Property @NonNull [] _Mapping = {
			PivotTables.Properties._Element__annotatingComments,
			QVTcoreTables.Properties._Area__bottomPattern,
			QVTcoreTables.Properties._Mapping__context,
			QVTbaseTables.Properties._Rule__domain,
			QVTcoreTables.Properties._Area__guardPattern,
			QVTbaseTables.Properties._Rule__isAbstract,
			QVTcoreTables.Properties._Mapping__local,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			QVTbaseTables.Properties._Rule__overridden,
			QVTbaseTables.Properties._Rule__overrides,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			QVTbaseTables.Properties._Rule__ownedContext,
			PivotTables.Properties._Element__ownedExtensions,
			QVTcoreTables.Properties._Mapping__refinement,
			QVTcoreTables.Properties._Mapping__specification,
			QVTbaseTables.Properties._Rule__transformation
		};

		private static final @NonNull Property @NonNull [] _NavigationAssignment = {
			PivotTables.Properties._Element__annotatingComments,
			QVTcoreTables.Properties._Assignment__bottomPattern,
			QVTcoreTables.Properties._Assignment__isDefault,
			QVTcoreTables.Properties._Assignment__isPartial,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTcoreTables.Properties._NavigationAssignment__slotExpression,
			QVTcoreTables.Properties._NavigationAssignment__targetProperty,
			QVTcoreTables.Properties._Assignment__value
		};

		private static final @NonNull Property @NonNull [] _OppositePropertyAssignment = {
			PivotTables.Properties._Element__annotatingComments,
			QVTcoreTables.Properties._Assignment__bottomPattern,
			QVTcoreTables.Properties._Assignment__isDefault,
			QVTcoreTables.Properties._Assignment__isPartial,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTcoreTables.Properties._NavigationAssignment__slotExpression,
			QVTcoreTables.Properties._NavigationAssignment__targetProperty,
			QVTcoreTables.Properties._Assignment__value
		};

		private static final @NonNull Property @NonNull [] _PropertyAssignment = {
			PivotTables.Properties._Element__annotatingComments,
			QVTcoreTables.Properties._Assignment__bottomPattern,
			QVTcoreTables.Properties._Assignment__isDefault,
			QVTcoreTables.Properties._Assignment__isPartial,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTcoreTables.Properties._NavigationAssignment__slotExpression,
			QVTcoreTables.Properties._NavigationAssignment__targetProperty,
			QVTcoreTables.Properties._Assignment__value
		};

		private static final @NonNull Property @NonNull [] _RealizedVariable = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._Variable__isImplicit,
			PivotTables.Properties._TypedElement__isMany,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			PivotTables.Properties._Variable__ownedInit,
			PivotTables.Properties._Variable__representedParameter,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._VariableDeclaration__typeValue
		};

		private static final @NonNull Property @NonNull [] _VariableAssignment = {
			PivotTables.Properties._Element__annotatingComments,
			QVTcoreTables.Properties._Assignment__bottomPattern,
			QVTcoreTables.Properties._Assignment__isDefault,
			QVTcoreTables.Properties._Assignment__isPartial,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTcoreTables.Properties._VariableAssignment__targetVariable,
			QVTcoreTables.Properties._Assignment__value
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._Area__Area.initProperties(_Area);
			Fragments._Assignment__Assignment.initProperties(_Assignment);
			Fragments._BottomPattern__BottomPattern.initProperties(_BottomPattern);
			Fragments._BottomVariable__BottomVariable.initProperties(_BottomVariable);
			Fragments._CoreDomain__CoreDomain.initProperties(_CoreDomain);
			Fragments._CoreModel__CoreModel.initProperties(_CoreModel);
			Fragments._CorePattern__CorePattern.initProperties(_CorePattern);
			Fragments._EnforcementMode__EnforcementMode.initProperties(_EnforcementMode);
			Fragments._EnforcementOperation__EnforcementOperation.initProperties(_EnforcementOperation);
			Fragments._GuardPattern__GuardPattern.initProperties(_GuardPattern);
			Fragments._GuardVariable__GuardVariable.initProperties(_GuardVariable);
			Fragments._Mapping__Mapping.initProperties(_Mapping);
			Fragments._NavigationAssignment__NavigationAssignment.initProperties(_NavigationAssignment);
			Fragments._OppositePropertyAssignment__OppositePropertyAssignment.initProperties(_OppositePropertyAssignment);
			Fragments._PropertyAssignment__PropertyAssignment.initProperties(_PropertyAssignment);
			Fragments._RealizedVariable__RealizedVariable.initProperties(_RealizedVariable);
			Fragments._VariableAssignment__VariableAssignment.initProperties(_VariableAssignment);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTcoreTables::FragmentProperties and all preceding sub-packages.
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

		public static final @NonNull EnumerationLiteral _EnforcementMode__Creation = LIBRARY.createEnumerationLiteral(QVTcorePackage.Literals.ENFORCEMENT_MODE.getEEnumLiteral("Creation"), Types._EnforcementMode, 0);
		public static final @NonNull EnumerationLiteral _EnforcementMode__Deletion = LIBRARY.createEnumerationLiteral(QVTcorePackage.Literals.ENFORCEMENT_MODE.getEEnumLiteral("Deletion"), Types._EnforcementMode, 1);
		private static final @NonNull EnumerationLiteral @NonNull [] _EnforcementMode = {
			_EnforcementMode__Creation,
			_EnforcementMode__Deletion
		};

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {
			LIBRARY.initLiterals(Types._EnforcementMode, _EnforcementMode);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTcoreTables::EnumerationLiterals and all preceding sub-packages.
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
		new QVTcoreTables();
	}

	private QVTcoreTables() {
		super(QVTcorePackage.eNS_URI);
	}
}
