/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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
 *   /org.eclipse.qvtd.pivot.qvtschedule/model/QVTschedule.ecore
 * using:
 *   /org.eclipse.qvtd.pivot.qvtschedule/model/QVTschedule.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorEnumeration;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorEnumerationLiteral;
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
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorTypeParameter;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables;

/**
 * QVTscheduleTables provides the dispatch tables for the qvtschedule for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
public class QVTscheduleTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final @NonNull EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(QVTschedulePackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final @NonNull ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = org.eclipse.ocl.pivot.ids.IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbase", null, org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2017/QVTschedule", null, org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_TMPLid_ = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.ocl.pivot.ids.IdManager.getTemplateParameterId(0));
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_AbstractDatum = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("AbstractDatum", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ClassDatum = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("ClassDatum", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_CompleteClass = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getClassId("CompleteClass", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Connection = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Connection", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_DispatchRegion = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("DispatchRegion", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Edge = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Edge", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_EdgeConnection = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("EdgeConnection", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_KeyedValueNode = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("KeyedValueNode", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_LoadingRegion = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("LoadingRegion", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_MappingRegion = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("MappingRegion", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_MicroMappingRegion = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("MicroMappingRegion", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_NavigableEdge = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("NavigableEdge", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Node = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Node", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_NodeConnection = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("NodeConnection", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Operation = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getClassId("Operation", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OperationRegion = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("OperationRegion", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Property = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getClassId("Property", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PropertyDatum = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("PropertyDatum", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Region = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Region", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Rule = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Rule", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RuleRegion = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("RuleRegion", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ScheduleModel = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("ScheduleModel", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ScheduledRegion = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("ScheduledRegion", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Transformation = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Transformation", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TypedModel = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("TypedModel", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_VariableDeclaration = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getClassId("VariableDeclaration", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_VerdictRegion = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("VerdictRegion", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull DataTypeId DATAid_Object = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getDataTypeId("Object", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull EnumerationId ENUMid_ConnectionRole = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getEnumerationId("ConnectionRole");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull EnumerationId ENUMid_Role = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getEnumerationId("Role");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_ClassDatum = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_ClassDatum);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_DispatchRegion = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_DispatchRegion);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_KeyedValueNode = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_KeyedValueNode);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_MappingRegion = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_MappingRegion);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_MicroMappingRegion = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_MicroMappingRegion);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_NavigableEdge = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_NavigableEdge);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_Node = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_Node);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_NodeConnection = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_NodeConnection);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_OperationRegion = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_OperationRegion);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_PropertyDatum = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_PropertyDatum);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_VerdictRegion = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_VerdictRegion);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_ClassDatum = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_ClassDatum);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Connection = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_Connection);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Edge = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_Edge);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_EdgeConnection = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_EdgeConnection);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_MappingRegion = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_MappingRegion);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Node = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_Node);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_NodeConnection = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_NodeConnection);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_OperationRegion = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_OperationRegion);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_PropertyDatum = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_PropertyDatum);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_ScheduledRegion = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_ScheduledRegion);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_AbstractDatum = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_AbstractDatum);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_RuleRegion = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_RuleRegion);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			QVTscheduleTables.init();
		}

		public static final @NonNull ExecutorTypeParameter _DatumConnection_CE = new ExecutorTypeParameter(TypeId.T_1, "CE");

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTscheduleTables::TypeParameters and all preceding sub-packages.
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

		public static final @NonNull EcoreExecutorType _AbstractDatum = new EcoreExecutorType(QVTschedulePackage.Literals.ABSTRACT_DATUM, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _BooleanValueNode = new EcoreExecutorType(QVTschedulePackage.Literals.BOOLEAN_VALUE_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CastEdge = new EcoreExecutorType(QVTschedulePackage.Literals.CAST_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ClassDatum = new EcoreExecutorType(QVTschedulePackage.Literals.CLASS_DATUM, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ComposedNode = new EcoreExecutorType(QVTschedulePackage.Literals.COMPOSED_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Connection = new EcoreExecutorType(QVTschedulePackage.Literals.CONNECTION, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _ConnectionEnd = new EcoreExecutorType(QVTschedulePackage.Literals.CONNECTION_END, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorEnumeration _ConnectionRole = new EcoreExecutorEnumeration(QVTschedulePackage.Literals.CONNECTION_ROLE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _DatumConnection = new EcoreExecutorType(QVTschedulePackage.Literals.DATUM_CONNECTION, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._DatumConnection_CE);
		public static final @NonNull EcoreExecutorType _DependencyNode = new EcoreExecutorType(QVTschedulePackage.Literals.DEPENDENCY_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _DispatchRegion = new EcoreExecutorType(QVTschedulePackage.Literals.DISPATCH_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Edge = new EcoreExecutorType(QVTschedulePackage.Literals.EDGE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _EdgeConnection = new EcoreExecutorType(QVTschedulePackage.Literals.EDGE_CONNECTION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ErrorNode = new EcoreExecutorType(QVTschedulePackage.Literals.ERROR_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ExpressionEdge = new EcoreExecutorType(QVTschedulePackage.Literals.EXPRESSION_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _InputNode = new EcoreExecutorType(QVTschedulePackage.Literals.INPUT_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _IteratedEdge = new EcoreExecutorType(QVTschedulePackage.Literals.ITERATED_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _IteratorNode = new EcoreExecutorType(QVTschedulePackage.Literals.ITERATOR_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _KeyedValueNode = new EcoreExecutorType(QVTschedulePackage.Literals.KEYED_VALUE_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _LoadingRegion = new EcoreExecutorType(QVTschedulePackage.Literals.LOADING_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _MappingRegion = new EcoreExecutorType(QVTschedulePackage.Literals.MAPPING_REGION, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _MicroMappingRegion = new EcoreExecutorType(QVTschedulePackage.Literals.MICRO_MAPPING_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _NamedMappingRegion = new EcoreExecutorType(QVTschedulePackage.Literals.NAMED_MAPPING_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _NavigableEdge = new EcoreExecutorType(QVTschedulePackage.Literals.NAVIGABLE_EDGE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _NavigationEdge = new EcoreExecutorType(QVTschedulePackage.Literals.NAVIGATION_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Node = new EcoreExecutorType(QVTschedulePackage.Literals.NODE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _NodeConnection = new EcoreExecutorType(QVTschedulePackage.Literals.NODE_CONNECTION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _NullNode = new EcoreExecutorType(QVTschedulePackage.Literals.NULL_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OperationNode = new EcoreExecutorType(QVTschedulePackage.Literals.OPERATION_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OperationRegion = new EcoreExecutorType(QVTschedulePackage.Literals.OPERATION_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OperationValueNode = new EcoreExecutorType(QVTschedulePackage.Literals.OPERATION_VALUE_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _PatternTypedNode = new EcoreExecutorType(QVTschedulePackage.Literals.PATTERN_TYPED_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _PatternVariableNode = new EcoreExecutorType(QVTschedulePackage.Literals.PATTERN_VARIABLE_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _PredicateEdge = new EcoreExecutorType(QVTschedulePackage.Literals.PREDICATE_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _PropertyDatum = new EcoreExecutorType(QVTschedulePackage.Literals.PROPERTY_DATUM, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _RecursionEdge = new EcoreExecutorType(QVTschedulePackage.Literals.RECURSION_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Region = new EcoreExecutorType(QVTschedulePackage.Literals.REGION, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorEnumeration _Role = new EcoreExecutorEnumeration(QVTschedulePackage.Literals.ROLE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _RuleRegion = new EcoreExecutorType(QVTschedulePackage.Literals.RULE_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ScheduleModel = new EcoreExecutorType(QVTschedulePackage.Literals.SCHEDULE_MODEL, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ScheduledRegion = new EcoreExecutorType(QVTschedulePackage.Literals.SCHEDULED_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _SuccessEdge = new EcoreExecutorType(QVTschedulePackage.Literals.SUCCESS_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _SuccessNode = new EcoreExecutorType(QVTschedulePackage.Literals.SUCCESS_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Symbolable = new EcoreExecutorType(QVTschedulePackage.Literals.SYMBOLABLE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _UnknownNode = new EcoreExecutorType(QVTschedulePackage.Literals.UNKNOWN_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _VariableNode = new EcoreExecutorType(QVTschedulePackage.Literals.VARIABLE_NODE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _VerdictRegion = new EcoreExecutorType(QVTschedulePackage.Literals.VERDICT_REGION, PACKAGE, 0);

		private static final @NonNull EcoreExecutorType @NonNull [] types = {
			_AbstractDatum,
			_BooleanValueNode,
			_CastEdge,
			_ClassDatum,
			_ComposedNode,
			_Connection,
			_ConnectionEnd,
			_ConnectionRole,
			_DatumConnection,
			_DependencyNode,
			_DispatchRegion,
			_Edge,
			_EdgeConnection,
			_ErrorNode,
			_ExpressionEdge,
			_InputNode,
			_IteratedEdge,
			_IteratorNode,
			_KeyedValueNode,
			_LoadingRegion,
			_MappingRegion,
			_MicroMappingRegion,
			_NamedMappingRegion,
			_NavigableEdge,
			_NavigationEdge,
			_Node,
			_NodeConnection,
			_NullNode,
			_OperationNode,
			_OperationRegion,
			_OperationValueNode,
			_PatternTypedNode,
			_PatternVariableNode,
			_PredicateEdge,
			_PropertyDatum,
			_RecursionEdge,
			_Region,
			_Role,
			_RuleRegion,
			_ScheduleModel,
			_ScheduledRegion,
			_SuccessEdge,
			_SuccessNode,
			_Symbolable,
			_UnknownNode,
			_VariableNode,
			_VerdictRegion
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTscheduleTables::Types and all preceding sub-packages.
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

		private static final @NonNull ExecutorFragment _AbstractDatum__AbstractDatum = new ExecutorFragment(Types._AbstractDatum, QVTscheduleTables.Types._AbstractDatum);
		private static final @NonNull ExecutorFragment _AbstractDatum__Element = new ExecutorFragment(Types._AbstractDatum, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _AbstractDatum__NamedElement = new ExecutorFragment(Types._AbstractDatum, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _AbstractDatum__OclAny = new ExecutorFragment(Types._AbstractDatum, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _AbstractDatum__OclElement = new ExecutorFragment(Types._AbstractDatum, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _BooleanValueNode__BooleanValueNode = new ExecutorFragment(Types._BooleanValueNode, QVTscheduleTables.Types._BooleanValueNode);
		private static final @NonNull ExecutorFragment _BooleanValueNode__ConnectionEnd = new ExecutorFragment(Types._BooleanValueNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _BooleanValueNode__Element = new ExecutorFragment(Types._BooleanValueNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _BooleanValueNode__Node = new ExecutorFragment(Types._BooleanValueNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _BooleanValueNode__OclAny = new ExecutorFragment(Types._BooleanValueNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _BooleanValueNode__OclElement = new ExecutorFragment(Types._BooleanValueNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _BooleanValueNode__OperationNode = new ExecutorFragment(Types._BooleanValueNode, QVTscheduleTables.Types._OperationNode);

		private static final @NonNull ExecutorFragment _CastEdge__CastEdge = new ExecutorFragment(Types._CastEdge, QVTscheduleTables.Types._CastEdge);
		private static final @NonNull ExecutorFragment _CastEdge__ConnectionEnd = new ExecutorFragment(Types._CastEdge, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _CastEdge__Edge = new ExecutorFragment(Types._CastEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _CastEdge__Element = new ExecutorFragment(Types._CastEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _CastEdge__NavigableEdge = new ExecutorFragment(Types._CastEdge, QVTscheduleTables.Types._NavigableEdge);
		private static final @NonNull ExecutorFragment _CastEdge__OclAny = new ExecutorFragment(Types._CastEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _CastEdge__OclElement = new ExecutorFragment(Types._CastEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _ClassDatum__AbstractDatum = new ExecutorFragment(Types._ClassDatum, QVTscheduleTables.Types._AbstractDatum);
		private static final @NonNull ExecutorFragment _ClassDatum__ClassDatum = new ExecutorFragment(Types._ClassDatum, QVTscheduleTables.Types._ClassDatum);
		private static final @NonNull ExecutorFragment _ClassDatum__Element = new ExecutorFragment(Types._ClassDatum, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ClassDatum__NamedElement = new ExecutorFragment(Types._ClassDatum, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _ClassDatum__OclAny = new ExecutorFragment(Types._ClassDatum, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ClassDatum__OclElement = new ExecutorFragment(Types._ClassDatum, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _ComposedNode__ComposedNode = new ExecutorFragment(Types._ComposedNode, QVTscheduleTables.Types._ComposedNode);
		private static final @NonNull ExecutorFragment _ComposedNode__ConnectionEnd = new ExecutorFragment(Types._ComposedNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _ComposedNode__Element = new ExecutorFragment(Types._ComposedNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ComposedNode__Node = new ExecutorFragment(Types._ComposedNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _ComposedNode__OclAny = new ExecutorFragment(Types._ComposedNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ComposedNode__OclElement = new ExecutorFragment(Types._ComposedNode, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _Connection__Connection = new ExecutorFragment(Types._Connection, QVTscheduleTables.Types._Connection);
		private static final @NonNull ExecutorFragment _Connection__Element = new ExecutorFragment(Types._Connection, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Connection__OclAny = new ExecutorFragment(Types._Connection, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Connection__OclElement = new ExecutorFragment(Types._Connection, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Connection__Symbolable = new ExecutorFragment(Types._Connection, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _ConnectionEnd__ConnectionEnd = new ExecutorFragment(Types._ConnectionEnd, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _ConnectionEnd__OclAny = new ExecutorFragment(Types._ConnectionEnd, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ConnectionEnd__OclElement = new ExecutorFragment(Types._ConnectionEnd, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _ConnectionRole__ConnectionRole = new ExecutorFragment(Types._ConnectionRole, QVTscheduleTables.Types._ConnectionRole);
		private static final @NonNull ExecutorFragment _ConnectionRole__OclAny = new ExecutorFragment(Types._ConnectionRole, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ConnectionRole__OclElement = new ExecutorFragment(Types._ConnectionRole, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _ConnectionRole__OclEnumeration = new ExecutorFragment(Types._ConnectionRole, OCLstdlibTables.Types._OclEnumeration);
		private static final @NonNull ExecutorFragment _ConnectionRole__OclType = new ExecutorFragment(Types._ConnectionRole, OCLstdlibTables.Types._OclType);

		private static final @NonNull ExecutorFragment _DatumConnection__Connection = new ExecutorFragment(Types._DatumConnection, QVTscheduleTables.Types._Connection);
		private static final @NonNull ExecutorFragment _DatumConnection__DatumConnection = new ExecutorFragment(Types._DatumConnection, QVTscheduleTables.Types._DatumConnection);
		private static final @NonNull ExecutorFragment _DatumConnection__Element = new ExecutorFragment(Types._DatumConnection, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _DatumConnection__OclAny = new ExecutorFragment(Types._DatumConnection, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _DatumConnection__OclElement = new ExecutorFragment(Types._DatumConnection, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _DatumConnection__Symbolable = new ExecutorFragment(Types._DatumConnection, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _DependencyNode__ConnectionEnd = new ExecutorFragment(Types._DependencyNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _DependencyNode__DependencyNode = new ExecutorFragment(Types._DependencyNode, QVTscheduleTables.Types._DependencyNode);
		private static final @NonNull ExecutorFragment _DependencyNode__Element = new ExecutorFragment(Types._DependencyNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _DependencyNode__Node = new ExecutorFragment(Types._DependencyNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _DependencyNode__OclAny = new ExecutorFragment(Types._DependencyNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _DependencyNode__OclElement = new ExecutorFragment(Types._DependencyNode, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _DispatchRegion__DispatchRegion = new ExecutorFragment(Types._DispatchRegion, QVTscheduleTables.Types._DispatchRegion);
		private static final @NonNull ExecutorFragment _DispatchRegion__Element = new ExecutorFragment(Types._DispatchRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _DispatchRegion__MappingRegion = new ExecutorFragment(Types._DispatchRegion, QVTscheduleTables.Types._MappingRegion);
		private static final @NonNull ExecutorFragment _DispatchRegion__NamedElement = new ExecutorFragment(Types._DispatchRegion, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _DispatchRegion__OclAny = new ExecutorFragment(Types._DispatchRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _DispatchRegion__OclElement = new ExecutorFragment(Types._DispatchRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _DispatchRegion__Region = new ExecutorFragment(Types._DispatchRegion, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _DispatchRegion__RuleRegion = new ExecutorFragment(Types._DispatchRegion, QVTscheduleTables.Types._RuleRegion);
		private static final @NonNull ExecutorFragment _DispatchRegion__Symbolable = new ExecutorFragment(Types._DispatchRegion, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _Edge__Edge = new ExecutorFragment(Types._Edge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _Edge__Element = new ExecutorFragment(Types._Edge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Edge__OclAny = new ExecutorFragment(Types._Edge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Edge__OclElement = new ExecutorFragment(Types._Edge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _EdgeConnection__Connection = new ExecutorFragment(Types._EdgeConnection, QVTscheduleTables.Types._Connection);
		private static final @NonNull ExecutorFragment _EdgeConnection__DatumConnection = new ExecutorFragment(Types._EdgeConnection, QVTscheduleTables.Types._DatumConnection);
		private static final @NonNull ExecutorFragment _EdgeConnection__EdgeConnection = new ExecutorFragment(Types._EdgeConnection, QVTscheduleTables.Types._EdgeConnection);
		private static final @NonNull ExecutorFragment _EdgeConnection__Element = new ExecutorFragment(Types._EdgeConnection, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _EdgeConnection__OclAny = new ExecutorFragment(Types._EdgeConnection, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _EdgeConnection__OclElement = new ExecutorFragment(Types._EdgeConnection, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _EdgeConnection__Symbolable = new ExecutorFragment(Types._EdgeConnection, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _ErrorNode__ConnectionEnd = new ExecutorFragment(Types._ErrorNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _ErrorNode__Element = new ExecutorFragment(Types._ErrorNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ErrorNode__ErrorNode = new ExecutorFragment(Types._ErrorNode, QVTscheduleTables.Types._ErrorNode);
		private static final @NonNull ExecutorFragment _ErrorNode__Node = new ExecutorFragment(Types._ErrorNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _ErrorNode__OclAny = new ExecutorFragment(Types._ErrorNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ErrorNode__OclElement = new ExecutorFragment(Types._ErrorNode, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _ExpressionEdge__Edge = new ExecutorFragment(Types._ExpressionEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _ExpressionEdge__Element = new ExecutorFragment(Types._ExpressionEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ExpressionEdge__ExpressionEdge = new ExecutorFragment(Types._ExpressionEdge, QVTscheduleTables.Types._ExpressionEdge);
		private static final @NonNull ExecutorFragment _ExpressionEdge__OclAny = new ExecutorFragment(Types._ExpressionEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ExpressionEdge__OclElement = new ExecutorFragment(Types._ExpressionEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _InputNode__ConnectionEnd = new ExecutorFragment(Types._InputNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _InputNode__Element = new ExecutorFragment(Types._InputNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _InputNode__InputNode = new ExecutorFragment(Types._InputNode, QVTscheduleTables.Types._InputNode);
		private static final @NonNull ExecutorFragment _InputNode__Node = new ExecutorFragment(Types._InputNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _InputNode__OclAny = new ExecutorFragment(Types._InputNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _InputNode__OclElement = new ExecutorFragment(Types._InputNode, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _IteratedEdge__Edge = new ExecutorFragment(Types._IteratedEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _IteratedEdge__Element = new ExecutorFragment(Types._IteratedEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _IteratedEdge__IteratedEdge = new ExecutorFragment(Types._IteratedEdge, QVTscheduleTables.Types._IteratedEdge);
		private static final @NonNull ExecutorFragment _IteratedEdge__OclAny = new ExecutorFragment(Types._IteratedEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _IteratedEdge__OclElement = new ExecutorFragment(Types._IteratedEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _IteratorNode__ConnectionEnd = new ExecutorFragment(Types._IteratorNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _IteratorNode__Element = new ExecutorFragment(Types._IteratorNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _IteratorNode__IteratorNode = new ExecutorFragment(Types._IteratorNode, QVTscheduleTables.Types._IteratorNode);
		private static final @NonNull ExecutorFragment _IteratorNode__Node = new ExecutorFragment(Types._IteratorNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _IteratorNode__OclAny = new ExecutorFragment(Types._IteratorNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _IteratorNode__OclElement = new ExecutorFragment(Types._IteratorNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _IteratorNode__VariableNode = new ExecutorFragment(Types._IteratorNode, QVTscheduleTables.Types._VariableNode);

		private static final @NonNull ExecutorFragment _KeyedValueNode__ConnectionEnd = new ExecutorFragment(Types._KeyedValueNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _KeyedValueNode__Element = new ExecutorFragment(Types._KeyedValueNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _KeyedValueNode__KeyedValueNode = new ExecutorFragment(Types._KeyedValueNode, QVTscheduleTables.Types._KeyedValueNode);
		private static final @NonNull ExecutorFragment _KeyedValueNode__Node = new ExecutorFragment(Types._KeyedValueNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _KeyedValueNode__OclAny = new ExecutorFragment(Types._KeyedValueNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _KeyedValueNode__OclElement = new ExecutorFragment(Types._KeyedValueNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _KeyedValueNode__OperationNode = new ExecutorFragment(Types._KeyedValueNode, QVTscheduleTables.Types._OperationNode);

		private static final @NonNull ExecutorFragment _LoadingRegion__Element = new ExecutorFragment(Types._LoadingRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _LoadingRegion__LoadingRegion = new ExecutorFragment(Types._LoadingRegion, QVTscheduleTables.Types._LoadingRegion);
		private static final @NonNull ExecutorFragment _LoadingRegion__NamedElement = new ExecutorFragment(Types._LoadingRegion, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _LoadingRegion__OclAny = new ExecutorFragment(Types._LoadingRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _LoadingRegion__OclElement = new ExecutorFragment(Types._LoadingRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _LoadingRegion__Region = new ExecutorFragment(Types._LoadingRegion, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _LoadingRegion__Symbolable = new ExecutorFragment(Types._LoadingRegion, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _MappingRegion__Element = new ExecutorFragment(Types._MappingRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _MappingRegion__MappingRegion = new ExecutorFragment(Types._MappingRegion, QVTscheduleTables.Types._MappingRegion);
		private static final @NonNull ExecutorFragment _MappingRegion__NamedElement = new ExecutorFragment(Types._MappingRegion, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _MappingRegion__OclAny = new ExecutorFragment(Types._MappingRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _MappingRegion__OclElement = new ExecutorFragment(Types._MappingRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _MappingRegion__Region = new ExecutorFragment(Types._MappingRegion, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _MappingRegion__Symbolable = new ExecutorFragment(Types._MappingRegion, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _MicroMappingRegion__Element = new ExecutorFragment(Types._MicroMappingRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _MicroMappingRegion__MappingRegion = new ExecutorFragment(Types._MicroMappingRegion, QVTscheduleTables.Types._MappingRegion);
		private static final @NonNull ExecutorFragment _MicroMappingRegion__MicroMappingRegion = new ExecutorFragment(Types._MicroMappingRegion, QVTscheduleTables.Types._MicroMappingRegion);
		private static final @NonNull ExecutorFragment _MicroMappingRegion__NamedElement = new ExecutorFragment(Types._MicroMappingRegion, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _MicroMappingRegion__OclAny = new ExecutorFragment(Types._MicroMappingRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _MicroMappingRegion__OclElement = new ExecutorFragment(Types._MicroMappingRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _MicroMappingRegion__Region = new ExecutorFragment(Types._MicroMappingRegion, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _MicroMappingRegion__Symbolable = new ExecutorFragment(Types._MicroMappingRegion, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _NamedMappingRegion__Element = new ExecutorFragment(Types._NamedMappingRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _NamedMappingRegion__MappingRegion = new ExecutorFragment(Types._NamedMappingRegion, QVTscheduleTables.Types._MappingRegion);
		private static final @NonNull ExecutorFragment _NamedMappingRegion__NamedElement = new ExecutorFragment(Types._NamedMappingRegion, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _NamedMappingRegion__NamedMappingRegion = new ExecutorFragment(Types._NamedMappingRegion, QVTscheduleTables.Types._NamedMappingRegion);
		private static final @NonNull ExecutorFragment _NamedMappingRegion__OclAny = new ExecutorFragment(Types._NamedMappingRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NamedMappingRegion__OclElement = new ExecutorFragment(Types._NamedMappingRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _NamedMappingRegion__Region = new ExecutorFragment(Types._NamedMappingRegion, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _NamedMappingRegion__Symbolable = new ExecutorFragment(Types._NamedMappingRegion, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _NavigableEdge__ConnectionEnd = new ExecutorFragment(Types._NavigableEdge, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _NavigableEdge__Edge = new ExecutorFragment(Types._NavigableEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _NavigableEdge__Element = new ExecutorFragment(Types._NavigableEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _NavigableEdge__NavigableEdge = new ExecutorFragment(Types._NavigableEdge, QVTscheduleTables.Types._NavigableEdge);
		private static final @NonNull ExecutorFragment _NavigableEdge__OclAny = new ExecutorFragment(Types._NavigableEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NavigableEdge__OclElement = new ExecutorFragment(Types._NavigableEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _NavigationEdge__ConnectionEnd = new ExecutorFragment(Types._NavigationEdge, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _NavigationEdge__Edge = new ExecutorFragment(Types._NavigationEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _NavigationEdge__Element = new ExecutorFragment(Types._NavigationEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _NavigationEdge__NavigableEdge = new ExecutorFragment(Types._NavigationEdge, QVTscheduleTables.Types._NavigableEdge);
		private static final @NonNull ExecutorFragment _NavigationEdge__NavigationEdge = new ExecutorFragment(Types._NavigationEdge, QVTscheduleTables.Types._NavigationEdge);
		private static final @NonNull ExecutorFragment _NavigationEdge__OclAny = new ExecutorFragment(Types._NavigationEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NavigationEdge__OclElement = new ExecutorFragment(Types._NavigationEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _Node__ConnectionEnd = new ExecutorFragment(Types._Node, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _Node__Element = new ExecutorFragment(Types._Node, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Node__Node = new ExecutorFragment(Types._Node, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _Node__OclAny = new ExecutorFragment(Types._Node, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Node__OclElement = new ExecutorFragment(Types._Node, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _NodeConnection__Connection = new ExecutorFragment(Types._NodeConnection, QVTscheduleTables.Types._Connection);
		private static final @NonNull ExecutorFragment _NodeConnection__DatumConnection = new ExecutorFragment(Types._NodeConnection, QVTscheduleTables.Types._DatumConnection);
		private static final @NonNull ExecutorFragment _NodeConnection__Element = new ExecutorFragment(Types._NodeConnection, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _NodeConnection__NodeConnection = new ExecutorFragment(Types._NodeConnection, QVTscheduleTables.Types._NodeConnection);
		private static final @NonNull ExecutorFragment _NodeConnection__OclAny = new ExecutorFragment(Types._NodeConnection, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NodeConnection__OclElement = new ExecutorFragment(Types._NodeConnection, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _NodeConnection__Symbolable = new ExecutorFragment(Types._NodeConnection, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _NullNode__ConnectionEnd = new ExecutorFragment(Types._NullNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _NullNode__Element = new ExecutorFragment(Types._NullNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _NullNode__Node = new ExecutorFragment(Types._NullNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _NullNode__NullNode = new ExecutorFragment(Types._NullNode, QVTscheduleTables.Types._NullNode);
		private static final @NonNull ExecutorFragment _NullNode__OclAny = new ExecutorFragment(Types._NullNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NullNode__OclElement = new ExecutorFragment(Types._NullNode, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _OperationNode__ConnectionEnd = new ExecutorFragment(Types._OperationNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _OperationNode__Element = new ExecutorFragment(Types._OperationNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _OperationNode__Node = new ExecutorFragment(Types._OperationNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _OperationNode__OclAny = new ExecutorFragment(Types._OperationNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OperationNode__OclElement = new ExecutorFragment(Types._OperationNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _OperationNode__OperationNode = new ExecutorFragment(Types._OperationNode, QVTscheduleTables.Types._OperationNode);

		private static final @NonNull ExecutorFragment _OperationRegion__Element = new ExecutorFragment(Types._OperationRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _OperationRegion__NamedElement = new ExecutorFragment(Types._OperationRegion, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _OperationRegion__OclAny = new ExecutorFragment(Types._OperationRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OperationRegion__OclElement = new ExecutorFragment(Types._OperationRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _OperationRegion__OperationRegion = new ExecutorFragment(Types._OperationRegion, QVTscheduleTables.Types._OperationRegion);
		private static final @NonNull ExecutorFragment _OperationRegion__Region = new ExecutorFragment(Types._OperationRegion, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _OperationRegion__Symbolable = new ExecutorFragment(Types._OperationRegion, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _OperationValueNode__ConnectionEnd = new ExecutorFragment(Types._OperationValueNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _OperationValueNode__Element = new ExecutorFragment(Types._OperationValueNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _OperationValueNode__Node = new ExecutorFragment(Types._OperationValueNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _OperationValueNode__OclAny = new ExecutorFragment(Types._OperationValueNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OperationValueNode__OclElement = new ExecutorFragment(Types._OperationValueNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _OperationValueNode__OperationNode = new ExecutorFragment(Types._OperationValueNode, QVTscheduleTables.Types._OperationNode);
		private static final @NonNull ExecutorFragment _OperationValueNode__OperationValueNode = new ExecutorFragment(Types._OperationValueNode, QVTscheduleTables.Types._OperationValueNode);

		private static final @NonNull ExecutorFragment _PatternTypedNode__ConnectionEnd = new ExecutorFragment(Types._PatternTypedNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _PatternTypedNode__Element = new ExecutorFragment(Types._PatternTypedNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _PatternTypedNode__Node = new ExecutorFragment(Types._PatternTypedNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _PatternTypedNode__OclAny = new ExecutorFragment(Types._PatternTypedNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _PatternTypedNode__OclElement = new ExecutorFragment(Types._PatternTypedNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _PatternTypedNode__PatternTypedNode = new ExecutorFragment(Types._PatternTypedNode, QVTscheduleTables.Types._PatternTypedNode);

		private static final @NonNull ExecutorFragment _PatternVariableNode__ConnectionEnd = new ExecutorFragment(Types._PatternVariableNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _PatternVariableNode__Element = new ExecutorFragment(Types._PatternVariableNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _PatternVariableNode__Node = new ExecutorFragment(Types._PatternVariableNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _PatternVariableNode__OclAny = new ExecutorFragment(Types._PatternVariableNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _PatternVariableNode__OclElement = new ExecutorFragment(Types._PatternVariableNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _PatternVariableNode__PatternVariableNode = new ExecutorFragment(Types._PatternVariableNode, QVTscheduleTables.Types._PatternVariableNode);
		private static final @NonNull ExecutorFragment _PatternVariableNode__VariableNode = new ExecutorFragment(Types._PatternVariableNode, QVTscheduleTables.Types._VariableNode);

		private static final @NonNull ExecutorFragment _PredicateEdge__Edge = new ExecutorFragment(Types._PredicateEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _PredicateEdge__Element = new ExecutorFragment(Types._PredicateEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _PredicateEdge__OclAny = new ExecutorFragment(Types._PredicateEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _PredicateEdge__OclElement = new ExecutorFragment(Types._PredicateEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _PredicateEdge__PredicateEdge = new ExecutorFragment(Types._PredicateEdge, QVTscheduleTables.Types._PredicateEdge);

		private static final @NonNull ExecutorFragment _PropertyDatum__AbstractDatum = new ExecutorFragment(Types._PropertyDatum, QVTscheduleTables.Types._AbstractDatum);
		private static final @NonNull ExecutorFragment _PropertyDatum__Element = new ExecutorFragment(Types._PropertyDatum, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _PropertyDatum__NamedElement = new ExecutorFragment(Types._PropertyDatum, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _PropertyDatum__OclAny = new ExecutorFragment(Types._PropertyDatum, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _PropertyDatum__OclElement = new ExecutorFragment(Types._PropertyDatum, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _PropertyDatum__PropertyDatum = new ExecutorFragment(Types._PropertyDatum, QVTscheduleTables.Types._PropertyDatum);

		private static final @NonNull ExecutorFragment _RecursionEdge__Edge = new ExecutorFragment(Types._RecursionEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _RecursionEdge__Element = new ExecutorFragment(Types._RecursionEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _RecursionEdge__OclAny = new ExecutorFragment(Types._RecursionEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _RecursionEdge__OclElement = new ExecutorFragment(Types._RecursionEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _RecursionEdge__RecursionEdge = new ExecutorFragment(Types._RecursionEdge, QVTscheduleTables.Types._RecursionEdge);

		private static final @NonNull ExecutorFragment _Region__Element = new ExecutorFragment(Types._Region, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Region__NamedElement = new ExecutorFragment(Types._Region, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Region__OclAny = new ExecutorFragment(Types._Region, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Region__OclElement = new ExecutorFragment(Types._Region, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Region__Region = new ExecutorFragment(Types._Region, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _Region__Symbolable = new ExecutorFragment(Types._Region, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _Role__OclAny = new ExecutorFragment(Types._Role, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Role__OclElement = new ExecutorFragment(Types._Role, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Role__OclEnumeration = new ExecutorFragment(Types._Role, OCLstdlibTables.Types._OclEnumeration);
		private static final @NonNull ExecutorFragment _Role__OclType = new ExecutorFragment(Types._Role, OCLstdlibTables.Types._OclType);
		private static final @NonNull ExecutorFragment _Role__Role = new ExecutorFragment(Types._Role, QVTscheduleTables.Types._Role);

		private static final @NonNull ExecutorFragment _RuleRegion__Element = new ExecutorFragment(Types._RuleRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _RuleRegion__MappingRegion = new ExecutorFragment(Types._RuleRegion, QVTscheduleTables.Types._MappingRegion);
		private static final @NonNull ExecutorFragment _RuleRegion__NamedElement = new ExecutorFragment(Types._RuleRegion, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _RuleRegion__OclAny = new ExecutorFragment(Types._RuleRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _RuleRegion__OclElement = new ExecutorFragment(Types._RuleRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _RuleRegion__Region = new ExecutorFragment(Types._RuleRegion, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _RuleRegion__RuleRegion = new ExecutorFragment(Types._RuleRegion, QVTscheduleTables.Types._RuleRegion);
		private static final @NonNull ExecutorFragment _RuleRegion__Symbolable = new ExecutorFragment(Types._RuleRegion, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _ScheduleModel__Element = new ExecutorFragment(Types._ScheduleModel, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ScheduleModel__Model = new ExecutorFragment(Types._ScheduleModel, PivotTables.Types._Model);
		private static final @NonNull ExecutorFragment _ScheduleModel__NamedElement = new ExecutorFragment(Types._ScheduleModel, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _ScheduleModel__Namespace = new ExecutorFragment(Types._ScheduleModel, PivotTables.Types._Namespace);
		private static final @NonNull ExecutorFragment _ScheduleModel__OclAny = new ExecutorFragment(Types._ScheduleModel, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ScheduleModel__OclElement = new ExecutorFragment(Types._ScheduleModel, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _ScheduleModel__ScheduleModel = new ExecutorFragment(Types._ScheduleModel, QVTscheduleTables.Types._ScheduleModel);

		private static final @NonNull ExecutorFragment _ScheduledRegion__Element = new ExecutorFragment(Types._ScheduledRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ScheduledRegion__NamedElement = new ExecutorFragment(Types._ScheduledRegion, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _ScheduledRegion__OclAny = new ExecutorFragment(Types._ScheduledRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ScheduledRegion__OclElement = new ExecutorFragment(Types._ScheduledRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _ScheduledRegion__Region = new ExecutorFragment(Types._ScheduledRegion, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _ScheduledRegion__ScheduledRegion = new ExecutorFragment(Types._ScheduledRegion, QVTscheduleTables.Types._ScheduledRegion);
		private static final @NonNull ExecutorFragment _ScheduledRegion__Symbolable = new ExecutorFragment(Types._ScheduledRegion, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _SuccessEdge__ConnectionEnd = new ExecutorFragment(Types._SuccessEdge, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _SuccessEdge__Edge = new ExecutorFragment(Types._SuccessEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _SuccessEdge__Element = new ExecutorFragment(Types._SuccessEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _SuccessEdge__NavigableEdge = new ExecutorFragment(Types._SuccessEdge, QVTscheduleTables.Types._NavigableEdge);
		private static final @NonNull ExecutorFragment _SuccessEdge__NavigationEdge = new ExecutorFragment(Types._SuccessEdge, QVTscheduleTables.Types._NavigationEdge);
		private static final @NonNull ExecutorFragment _SuccessEdge__OclAny = new ExecutorFragment(Types._SuccessEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _SuccessEdge__OclElement = new ExecutorFragment(Types._SuccessEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _SuccessEdge__SuccessEdge = new ExecutorFragment(Types._SuccessEdge, QVTscheduleTables.Types._SuccessEdge);

		private static final @NonNull ExecutorFragment _SuccessNode__ConnectionEnd = new ExecutorFragment(Types._SuccessNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _SuccessNode__Element = new ExecutorFragment(Types._SuccessNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _SuccessNode__Node = new ExecutorFragment(Types._SuccessNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _SuccessNode__OclAny = new ExecutorFragment(Types._SuccessNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _SuccessNode__OclElement = new ExecutorFragment(Types._SuccessNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _SuccessNode__SuccessNode = new ExecutorFragment(Types._SuccessNode, QVTscheduleTables.Types._SuccessNode);

		private static final @NonNull ExecutorFragment _Symbolable__OclAny = new ExecutorFragment(Types._Symbolable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Symbolable__OclElement = new ExecutorFragment(Types._Symbolable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Symbolable__Symbolable = new ExecutorFragment(Types._Symbolable, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _UnknownNode__ConnectionEnd = new ExecutorFragment(Types._UnknownNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _UnknownNode__Element = new ExecutorFragment(Types._UnknownNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _UnknownNode__Node = new ExecutorFragment(Types._UnknownNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _UnknownNode__OclAny = new ExecutorFragment(Types._UnknownNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _UnknownNode__OclElement = new ExecutorFragment(Types._UnknownNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _UnknownNode__UnknownNode = new ExecutorFragment(Types._UnknownNode, QVTscheduleTables.Types._UnknownNode);

		private static final @NonNull ExecutorFragment _VariableNode__ConnectionEnd = new ExecutorFragment(Types._VariableNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _VariableNode__Element = new ExecutorFragment(Types._VariableNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _VariableNode__Node = new ExecutorFragment(Types._VariableNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _VariableNode__OclAny = new ExecutorFragment(Types._VariableNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _VariableNode__OclElement = new ExecutorFragment(Types._VariableNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _VariableNode__VariableNode = new ExecutorFragment(Types._VariableNode, QVTscheduleTables.Types._VariableNode);

		private static final @NonNull ExecutorFragment _VerdictRegion__Element = new ExecutorFragment(Types._VerdictRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _VerdictRegion__MappingRegion = new ExecutorFragment(Types._VerdictRegion, QVTscheduleTables.Types._MappingRegion);
		private static final @NonNull ExecutorFragment _VerdictRegion__NamedElement = new ExecutorFragment(Types._VerdictRegion, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _VerdictRegion__OclAny = new ExecutorFragment(Types._VerdictRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _VerdictRegion__OclElement = new ExecutorFragment(Types._VerdictRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _VerdictRegion__Region = new ExecutorFragment(Types._VerdictRegion, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _VerdictRegion__RuleRegion = new ExecutorFragment(Types._VerdictRegion, QVTscheduleTables.Types._RuleRegion);
		private static final @NonNull ExecutorFragment _VerdictRegion__Symbolable = new ExecutorFragment(Types._VerdictRegion, QVTscheduleTables.Types._Symbolable);
		private static final @NonNull ExecutorFragment _VerdictRegion__VerdictRegion = new ExecutorFragment(Types._VerdictRegion, QVTscheduleTables.Types._VerdictRegion);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTscheduleTables::Fragments and all preceding sub-packages.
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
		 * Force initialization of the fields of QVTscheduleTables::Parameters and all preceding sub-packages.
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
		 * Force initialization of the fields of QVTscheduleTables::Operations and all preceding sub-packages.
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

		public static final @NonNull ExecutorProperty _AbstractDatum__consumingRegions = new EcoreExecutorProperty(QVTschedulePackage.Literals.ABSTRACT_DATUM__CONSUMING_REGIONS, Types._AbstractDatum, 0);
		public static final @NonNull ExecutorProperty _AbstractDatum__producingRegions = new EcoreExecutorProperty(QVTschedulePackage.Literals.ABSTRACT_DATUM__PRODUCING_REGIONS, Types._AbstractDatum, 1);
		public static final @NonNull ExecutorProperty _AbstractDatum__referredTypedModel = new EcoreExecutorProperty(QVTschedulePackage.Literals.ABSTRACT_DATUM__REFERRED_TYPED_MODEL, Types._AbstractDatum, 2);

		public static final @NonNull ExecutorProperty _BooleanValueNode__booleanValue = new EcoreExecutorProperty(QVTschedulePackage.Literals.BOOLEAN_VALUE_NODE__BOOLEAN_VALUE, Types._BooleanValueNode, 0);

		public static final @NonNull ExecutorProperty _CastEdge__property = new EcoreExecutorProperty(QVTschedulePackage.Literals.CAST_EDGE__PROPERTY, Types._CastEdge, 0);
		public static final @NonNull ExecutorProperty _CastEdge__referredClass = new EcoreExecutorProperty(QVTschedulePackage.Literals.CAST_EDGE__REFERRED_CLASS, Types._CastEdge, 1);

		public static final @NonNull ExecutorProperty _ClassDatum__completeClass = new EcoreExecutorProperty(QVTschedulePackage.Literals.CLASS_DATUM__COMPLETE_CLASS, Types._ClassDatum, 0);
		public static final @NonNull ExecutorProperty _ClassDatum__ownedPropertyDatums = new EcoreExecutorProperty(QVTschedulePackage.Literals.CLASS_DATUM__OWNED_PROPERTY_DATUMS, Types._ClassDatum, 1);
		public static final @NonNull ExecutorProperty _ClassDatum__owningScheduleModel = new EcoreExecutorProperty(QVTschedulePackage.Literals.CLASS_DATUM__OWNING_SCHEDULE_MODEL, Types._ClassDatum, 2);
		public static final @NonNull ExecutorProperty _ClassDatum__referredClass = new EcoreExecutorProperty(QVTschedulePackage.Literals.CLASS_DATUM__REFERRED_CLASS, Types._ClassDatum, 3);
		public static final @NonNull ExecutorProperty _ClassDatum__superClassDatums = new EcoreExecutorProperty(QVTschedulePackage.Literals.CLASS_DATUM__SUPER_CLASS_DATUMS, Types._ClassDatum, 4);
		public static final @NonNull ExecutorProperty _ClassDatum__ClassDatum__superClassDatums = new ExecutorPropertyWithImplementation("ClassDatum", Types._ClassDatum, 5, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.CLASS_DATUM__SUPER_CLASS_DATUMS));
		public static final @NonNull ExecutorProperty _ClassDatum__KeyedValueNode__classDatumValue = new ExecutorPropertyWithImplementation("KeyedValueNode", Types._ClassDatum, 6, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.KEYED_VALUE_NODE__CLASS_DATUM_VALUE));
		public static final @NonNull ExecutorProperty _ClassDatum__Node__classDatum = new ExecutorPropertyWithImplementation("Node", Types._ClassDatum, 7, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.NODE__CLASS_DATUM));
		public static final @NonNull ExecutorProperty _ClassDatum__NodeConnection__classDatum = new ExecutorPropertyWithImplementation("NodeConnection", Types._ClassDatum, 8, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.NODE_CONNECTION__CLASS_DATUM));

		public static final @NonNull ExecutorProperty _Connection__owningScheduledRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.CONNECTION__OWNING_SCHEDULED_REGION, Types._Connection, 0);

		public static final @NonNull ExecutorProperty _DatumConnection__connectionRole = new EcoreExecutorProperty(QVTschedulePackage.Literals.DATUM_CONNECTION__CONNECTION_ROLE, Types._DatumConnection, 0);
		public static final @NonNull ExecutorProperty _DatumConnection__name = new EcoreExecutorProperty(QVTschedulePackage.Literals.DATUM_CONNECTION__NAME, Types._DatumConnection, 1);
		public static final @NonNull ExecutorProperty _DatumConnection__sourceEnds = new EcoreExecutorProperty(QVTschedulePackage.Literals.DATUM_CONNECTION__SOURCE_ENDS, Types._DatumConnection, 2);

		public static final @NonNull ExecutorProperty _DispatchRegion__referredRuleRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.DISPATCH_REGION__REFERRED_RULE_REGION, Types._DispatchRegion, 0);

		public static final @NonNull ExecutorProperty _Edge__edgeRole = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE__EDGE_ROLE, Types._Edge, 0);
		public static final @NonNull ExecutorProperty _Edge__name = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE__NAME, Types._Edge, 1);
		public static final @NonNull ExecutorProperty _Edge__owningRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE__OWNING_REGION, Types._Edge, 2);
		public static final @NonNull ExecutorProperty _Edge__sourceNode = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE__SOURCE_NODE, Types._Edge, 3);
		public static final @NonNull ExecutorProperty _Edge__targetNode = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE__TARGET_NODE, Types._Edge, 4);

		public static final @NonNull ExecutorProperty _EdgeConnection__referredProperty = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE_CONNECTION__REFERRED_PROPERTY, Types._EdgeConnection, 0);
		public static final @NonNull ExecutorProperty _EdgeConnection__NavigableEdge__incomingConnection = new ExecutorPropertyWithImplementation("NavigableEdge", Types._EdgeConnection, 1, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.NAVIGABLE_EDGE__INCOMING_CONNECTION));
		public static final @NonNull ExecutorProperty _EdgeConnection__NavigableEdge__outgoingConnections = new ExecutorPropertyWithImplementation("NavigableEdge", Types._EdgeConnection, 2, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.NAVIGABLE_EDGE__OUTGOING_CONNECTIONS));

		public static final @NonNull ExecutorProperty _ExpressionEdge__referredObject = new EcoreExecutorProperty(QVTschedulePackage.Literals.EXPRESSION_EDGE__REFERRED_OBJECT, Types._ExpressionEdge, 0);

		public static final @NonNull ExecutorProperty _KeyedValueNode__classDatumValue = new EcoreExecutorProperty(QVTschedulePackage.Literals.KEYED_VALUE_NODE__CLASS_DATUM_VALUE, Types._KeyedValueNode, 0);

		public static final @NonNull ExecutorProperty _LoadingRegion__owningScheduledRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.LOADING_REGION__OWNING_SCHEDULED_REGION, Types._LoadingRegion, 0);

		public static final @NonNull ExecutorProperty _MappingRegion__headNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.MAPPING_REGION__HEAD_NODES, Types._MappingRegion, 0);
		public static final @NonNull ExecutorProperty _MappingRegion__owningScheduleModel = new EcoreExecutorProperty(QVTschedulePackage.Literals.MAPPING_REGION__OWNING_SCHEDULE_MODEL, Types._MappingRegion, 1);
		public static final @NonNull ExecutorProperty _MappingRegion__scheduledRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.MAPPING_REGION__SCHEDULED_REGION, Types._MappingRegion, 2);
		public static final @NonNull ExecutorProperty _MappingRegion__MicroMappingRegion__mappingRegion = new ExecutorPropertyWithImplementation("MicroMappingRegion", Types._MappingRegion, 3, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.MICRO_MAPPING_REGION__MAPPING_REGION));

		public static final @NonNull ExecutorProperty _MicroMappingRegion__mappingRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.MICRO_MAPPING_REGION__MAPPING_REGION, Types._MicroMappingRegion, 0);
		public static final @NonNull ExecutorProperty _MicroMappingRegion__namePrefix = new EcoreExecutorProperty(QVTschedulePackage.Literals.MICRO_MAPPING_REGION__NAME_PREFIX, Types._MicroMappingRegion, 1);
		public static final @NonNull ExecutorProperty _MicroMappingRegion__symbolNameSuffix = new EcoreExecutorProperty(QVTschedulePackage.Literals.MICRO_MAPPING_REGION__SYMBOL_NAME_SUFFIX, Types._MicroMappingRegion, 2);

		public static final @NonNull ExecutorProperty _NamedMappingRegion__symbolNameSuffix = new EcoreExecutorProperty(QVTschedulePackage.Literals.NAMED_MAPPING_REGION__SYMBOL_NAME_SUFFIX, Types._NamedMappingRegion, 0);

		public static final @NonNull ExecutorProperty _NavigableEdge__incomingConnection = new EcoreExecutorProperty(QVTschedulePackage.Literals.NAVIGABLE_EDGE__INCOMING_CONNECTION, Types._NavigableEdge, 0);
		public static final @NonNull ExecutorProperty _NavigableEdge__oppositeEdge = new EcoreExecutorProperty(QVTschedulePackage.Literals.NAVIGABLE_EDGE__OPPOSITE_EDGE, Types._NavigableEdge, 1);
		public static final @NonNull ExecutorProperty _NavigableEdge__outgoingConnections = new EcoreExecutorProperty(QVTschedulePackage.Literals.NAVIGABLE_EDGE__OUTGOING_CONNECTIONS, Types._NavigableEdge, 2);
		public static final @NonNull ExecutorProperty _NavigableEdge__secondary = new EcoreExecutorProperty(QVTschedulePackage.Literals.NAVIGABLE_EDGE__SECONDARY, Types._NavigableEdge, 3);
		public static final @NonNull ExecutorProperty _NavigableEdge__NavigableEdge__oppositeEdge = new ExecutorPropertyWithImplementation("NavigableEdge", Types._NavigableEdge, 4, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.NAVIGABLE_EDGE__OPPOSITE_EDGE));

		public static final @NonNull ExecutorProperty _NavigationEdge__partial = new EcoreExecutorProperty(QVTschedulePackage.Literals.NAVIGATION_EDGE__PARTIAL, Types._NavigationEdge, 0);
		public static final @NonNull ExecutorProperty _NavigationEdge__referredProperty = new EcoreExecutorProperty(QVTschedulePackage.Literals.NAVIGATION_EDGE__REFERRED_PROPERTY, Types._NavigationEdge, 1);

		public static final @NonNull ExecutorProperty _Node__classDatum = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__CLASS_DATUM, Types._Node, 0);
		public static final @NonNull ExecutorProperty _Node__incomingConnection = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__INCOMING_CONNECTION, Types._Node, 1);
		public static final @NonNull ExecutorProperty _Node__incomingEdges = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__INCOMING_EDGES, Types._Node, 2);
		public static final @NonNull ExecutorProperty _Node__name = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__NAME, Types._Node, 3);
		public static final @NonNull ExecutorProperty _Node__nodeRole = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__NODE_ROLE, Types._Node, 4);
		public static final @NonNull ExecutorProperty _Node__outgoingConnections = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__OUTGOING_CONNECTIONS, Types._Node, 5);
		public static final @NonNull ExecutorProperty _Node__outgoingEdges = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__OUTGOING_EDGES, Types._Node, 6);
		public static final @NonNull ExecutorProperty _Node__owningRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__OWNING_REGION, Types._Node, 7);
		public static final @NonNull ExecutorProperty _Node__MappingRegion__headNodes = new ExecutorPropertyWithImplementation("MappingRegion", Types._Node, 8, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.MAPPING_REGION__HEAD_NODES));
		public static final @NonNull ExecutorProperty _Node__OperationRegion__dependencyNodes = new ExecutorPropertyWithImplementation("OperationRegion", Types._Node, 9, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.OPERATION_REGION__DEPENDENCY_NODES));
		public static final @NonNull ExecutorProperty _Node__OperationRegion__headNodes = new ExecutorPropertyWithImplementation("OperationRegion", Types._Node, 10, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.OPERATION_REGION__HEAD_NODES));
		public static final @NonNull ExecutorProperty _Node__OperationRegion__resultNode = new ExecutorPropertyWithImplementation("OperationRegion", Types._Node, 11, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.OPERATION_REGION__RESULT_NODE));

		public static final @NonNull ExecutorProperty _NodeConnection__classDatum = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE_CONNECTION__CLASS_DATUM, Types._NodeConnection, 0);
		public static final @NonNull ExecutorProperty _NodeConnection__Node__incomingConnection = new ExecutorPropertyWithImplementation("Node", Types._NodeConnection, 1, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.NODE__INCOMING_CONNECTION));
		public static final @NonNull ExecutorProperty _NodeConnection__Node__outgoingConnections = new ExecutorPropertyWithImplementation("Node", Types._NodeConnection, 2, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.NODE__OUTGOING_CONNECTIONS));

		public static final @NonNull ExecutorProperty _NullNode__matched = new EcoreExecutorProperty(QVTschedulePackage.Literals.NULL_NODE__MATCHED, Types._NullNode, 0);

		public static final @NonNull ExecutorProperty _OperationNode__matched = new EcoreExecutorProperty(QVTschedulePackage.Literals.OPERATION_NODE__MATCHED, Types._OperationNode, 0);

		public static final @NonNull ExecutorProperty _OperationRegion__dependencyNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.OPERATION_REGION__DEPENDENCY_NODES, Types._OperationRegion, 0);
		public static final @NonNull ExecutorProperty _OperationRegion__headNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.OPERATION_REGION__HEAD_NODES, Types._OperationRegion, 1);
		public static final @NonNull ExecutorProperty _OperationRegion__owningScheduleModel = new EcoreExecutorProperty(QVTschedulePackage.Literals.OPERATION_REGION__OWNING_SCHEDULE_MODEL, Types._OperationRegion, 2);
		public static final @NonNull ExecutorProperty _OperationRegion__referredOperation = new EcoreExecutorProperty(QVTschedulePackage.Literals.OPERATION_REGION__REFERRED_OPERATION, Types._OperationRegion, 3);
		public static final @NonNull ExecutorProperty _OperationRegion__resultNode = new EcoreExecutorProperty(QVTschedulePackage.Literals.OPERATION_REGION__RESULT_NODE, Types._OperationRegion, 4);

		public static final @NonNull ExecutorProperty _OperationValueNode__operationValue = new EcoreExecutorProperty(QVTschedulePackage.Literals.OPERATION_VALUE_NODE__OPERATION_VALUE, Types._OperationValueNode, 0);

		public static final @NonNull ExecutorProperty _PatternTypedNode__matched = new EcoreExecutorProperty(QVTschedulePackage.Literals.PATTERN_TYPED_NODE__MATCHED, Types._PatternTypedNode, 0);

		public static final @NonNull ExecutorProperty _PatternVariableNode__matched = new EcoreExecutorProperty(QVTschedulePackage.Literals.PATTERN_VARIABLE_NODE__MATCHED, Types._PatternVariableNode, 0);

		public static final @NonNull ExecutorProperty _PropertyDatum__key = new EcoreExecutorProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__KEY, Types._PropertyDatum, 0);
		public static final @NonNull ExecutorProperty _PropertyDatum__opposite = new EcoreExecutorProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__OPPOSITE, Types._PropertyDatum, 1);
		public static final @NonNull ExecutorProperty _PropertyDatum__owningClassDatum = new EcoreExecutorProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__OWNING_CLASS_DATUM, Types._PropertyDatum, 2);
		public static final @NonNull ExecutorProperty _PropertyDatum__referredProperty = new EcoreExecutorProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__REFERRED_PROPERTY, Types._PropertyDatum, 3);
		public static final @NonNull ExecutorProperty _PropertyDatum__superPropertyDatums = new EcoreExecutorProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__SUPER_PROPERTY_DATUMS, Types._PropertyDatum, 4);
		public static final @NonNull ExecutorProperty _PropertyDatum__PropertyDatum__opposite = new ExecutorPropertyWithImplementation("PropertyDatum", Types._PropertyDatum, 5, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__OPPOSITE));
		public static final @NonNull ExecutorProperty _PropertyDatum__PropertyDatum__superPropertyDatums = new ExecutorPropertyWithImplementation("PropertyDatum", Types._PropertyDatum, 6, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__SUPER_PROPERTY_DATUMS));

		public static final @NonNull ExecutorProperty _RecursionEdge__primary = new EcoreExecutorProperty(QVTschedulePackage.Literals.RECURSION_EDGE__PRIMARY, Types._RecursionEdge, 0);

		public static final @NonNull ExecutorProperty _Region__ownedEdges = new EcoreExecutorProperty(QVTschedulePackage.Literals.REGION__OWNED_EDGES, Types._Region, 0);
		public static final @NonNull ExecutorProperty _Region__ownedNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.REGION__OWNED_NODES, Types._Region, 1);

		public static final @NonNull ExecutorProperty _RuleRegion__consumedDatums = new EcoreExecutorProperty(QVTschedulePackage.Literals.RULE_REGION__CONSUMED_DATUMS, Types._RuleRegion, 0);
		public static final @NonNull ExecutorProperty _RuleRegion__producedDatums = new EcoreExecutorProperty(QVTschedulePackage.Literals.RULE_REGION__PRODUCED_DATUMS, Types._RuleRegion, 1);
		public static final @NonNull ExecutorProperty _RuleRegion__referredRule = new EcoreExecutorProperty(QVTschedulePackage.Literals.RULE_REGION__REFERRED_RULE, Types._RuleRegion, 2);
		public static final @NonNull ExecutorProperty _RuleRegion__DispatchRegion__referredRuleRegion = new ExecutorPropertyWithImplementation("DispatchRegion", Types._RuleRegion, 3, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.DISPATCH_REGION__REFERRED_RULE_REGION));
		public static final @NonNull ExecutorProperty _RuleRegion__VerdictRegion__referredRuleRegion = new ExecutorPropertyWithImplementation("VerdictRegion", Types._RuleRegion, 4, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.VERDICT_REGION__REFERRED_RULE_REGION));

		public static final @NonNull ExecutorProperty _ScheduleModel__ownedClassDatums = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULE_MODEL__OWNED_CLASS_DATUMS, Types._ScheduleModel, 0);
		public static final @NonNull ExecutorProperty _ScheduleModel__ownedMappingRegions = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULE_MODEL__OWNED_MAPPING_REGIONS, Types._ScheduleModel, 1);
		public static final @NonNull ExecutorProperty _ScheduleModel__ownedOperationRegions = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULE_MODEL__OWNED_OPERATION_REGIONS, Types._ScheduleModel, 2);
		public static final @NonNull ExecutorProperty _ScheduleModel__ownedScheduledRegions = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULE_MODEL__OWNED_SCHEDULED_REGIONS, Types._ScheduleModel, 3);

		public static final @NonNull ExecutorProperty _ScheduledRegion__mappingRegions = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULED_REGION__MAPPING_REGIONS, Types._ScheduledRegion, 0);
		public static final @NonNull ExecutorProperty _ScheduledRegion__ownedConnections = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULED_REGION__OWNED_CONNECTIONS, Types._ScheduledRegion, 1);
		public static final @NonNull ExecutorProperty _ScheduledRegion__ownedLoadingRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULED_REGION__OWNED_LOADING_REGION, Types._ScheduledRegion, 2);
		public static final @NonNull ExecutorProperty _ScheduledRegion__owningScheduleModel = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULED_REGION__OWNING_SCHEDULE_MODEL, Types._ScheduledRegion, 3);
		public static final @NonNull ExecutorProperty _ScheduledRegion__referredTransformation = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULED_REGION__REFERRED_TRANSFORMATION, Types._ScheduledRegion, 4);

		public static final @NonNull ExecutorProperty _Symbolable__symbolName = new EcoreExecutorProperty(QVTschedulePackage.Literals.SYMBOLABLE__SYMBOL_NAME, Types._Symbolable, 0);

		public static final @NonNull ExecutorProperty _VariableNode__referredVariable = new EcoreExecutorProperty(QVTschedulePackage.Literals.VARIABLE_NODE__REFERRED_VARIABLE, Types._VariableNode, 0);

		public static final @NonNull ExecutorProperty _VerdictRegion__referredRuleRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.VERDICT_REGION__REFERRED_RULE_REGION, Types._VerdictRegion, 0);
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTscheduleTables::Properties and all preceding sub-packages.
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

		private static final @NonNull ExecutorFragment @NonNull [] _AbstractDatum =
			{
				Fragments._AbstractDatum__OclAny /* 0 */,
				Fragments._AbstractDatum__OclElement /* 1 */,
				Fragments._AbstractDatum__Element /* 2 */,
				Fragments._AbstractDatum__NamedElement /* 3 */,
				Fragments._AbstractDatum__AbstractDatum /* 4 */
			};
		private static final int @NonNull [] __AbstractDatum = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _BooleanValueNode =
			{
				Fragments._BooleanValueNode__OclAny /* 0 */,
				Fragments._BooleanValueNode__OclElement /* 1 */,
				Fragments._BooleanValueNode__ConnectionEnd /* 2 */,
				Fragments._BooleanValueNode__Element /* 2 */,
				Fragments._BooleanValueNode__Node /* 3 */,
				Fragments._BooleanValueNode__OperationNode /* 4 */,
				Fragments._BooleanValueNode__BooleanValueNode /* 5 */
			};
		private static final int @NonNull [] __BooleanValueNode = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _CastEdge =
			{
				Fragments._CastEdge__OclAny /* 0 */,
				Fragments._CastEdge__OclElement /* 1 */,
				Fragments._CastEdge__ConnectionEnd /* 2 */,
				Fragments._CastEdge__Element /* 2 */,
				Fragments._CastEdge__Edge /* 3 */,
				Fragments._CastEdge__NavigableEdge /* 4 */,
				Fragments._CastEdge__CastEdge /* 5 */
			};
		private static final int @NonNull [] __CastEdge = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ClassDatum =
			{
				Fragments._ClassDatum__OclAny /* 0 */,
				Fragments._ClassDatum__OclElement /* 1 */,
				Fragments._ClassDatum__Element /* 2 */,
				Fragments._ClassDatum__NamedElement /* 3 */,
				Fragments._ClassDatum__AbstractDatum /* 4 */,
				Fragments._ClassDatum__ClassDatum /* 5 */
			};
		private static final int @NonNull [] __ClassDatum = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ComposedNode =
			{
				Fragments._ComposedNode__OclAny /* 0 */,
				Fragments._ComposedNode__OclElement /* 1 */,
				Fragments._ComposedNode__ConnectionEnd /* 2 */,
				Fragments._ComposedNode__Element /* 2 */,
				Fragments._ComposedNode__Node /* 3 */,
				Fragments._ComposedNode__ComposedNode /* 4 */
			};
		private static final int @NonNull [] __ComposedNode = { 1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Connection =
			{
				Fragments._Connection__OclAny /* 0 */,
				Fragments._Connection__OclElement /* 1 */,
				Fragments._Connection__Element /* 2 */,
				Fragments._Connection__Symbolable /* 2 */,
				Fragments._Connection__Connection /* 3 */
			};
		private static final int @NonNull [] __Connection = { 1,1,2,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ConnectionEnd =
			{
				Fragments._ConnectionEnd__OclAny /* 0 */,
				Fragments._ConnectionEnd__OclElement /* 1 */,
				Fragments._ConnectionEnd__ConnectionEnd /* 2 */
			};
		private static final int @NonNull [] __ConnectionEnd = { 1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ConnectionRole =
			{
				Fragments._ConnectionRole__OclAny /* 0 */,
				Fragments._ConnectionRole__OclElement /* 1 */,
				Fragments._ConnectionRole__OclType /* 2 */,
				Fragments._ConnectionRole__OclEnumeration /* 3 */,
				Fragments._ConnectionRole__ConnectionRole /* 4 */
			};
		private static final int @NonNull [] __ConnectionRole = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _DatumConnection =
			{
				Fragments._DatumConnection__OclAny /* 0 */,
				Fragments._DatumConnection__OclElement /* 1 */,
				Fragments._DatumConnection__Element /* 2 */,
				Fragments._DatumConnection__Symbolable /* 2 */,
				Fragments._DatumConnection__Connection /* 3 */,
				Fragments._DatumConnection__DatumConnection /* 4 */
			};
		private static final int @NonNull [] __DatumConnection = { 1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _DependencyNode =
			{
				Fragments._DependencyNode__OclAny /* 0 */,
				Fragments._DependencyNode__OclElement /* 1 */,
				Fragments._DependencyNode__ConnectionEnd /* 2 */,
				Fragments._DependencyNode__Element /* 2 */,
				Fragments._DependencyNode__Node /* 3 */,
				Fragments._DependencyNode__DependencyNode /* 4 */
			};
		private static final int @NonNull [] __DependencyNode = { 1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _DispatchRegion =
			{
				Fragments._DispatchRegion__OclAny /* 0 */,
				Fragments._DispatchRegion__OclElement /* 1 */,
				Fragments._DispatchRegion__Element /* 2 */,
				Fragments._DispatchRegion__Symbolable /* 2 */,
				Fragments._DispatchRegion__NamedElement /* 3 */,
				Fragments._DispatchRegion__Region /* 4 */,
				Fragments._DispatchRegion__MappingRegion /* 5 */,
				Fragments._DispatchRegion__RuleRegion /* 6 */,
				Fragments._DispatchRegion__DispatchRegion /* 7 */
			};
		private static final int @NonNull [] __DispatchRegion = { 1,1,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Edge =
			{
				Fragments._Edge__OclAny /* 0 */,
				Fragments._Edge__OclElement /* 1 */,
				Fragments._Edge__Element /* 2 */,
				Fragments._Edge__Edge /* 3 */
			};
		private static final int @NonNull [] __Edge = { 1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _EdgeConnection =
			{
				Fragments._EdgeConnection__OclAny /* 0 */,
				Fragments._EdgeConnection__OclElement /* 1 */,
				Fragments._EdgeConnection__Element /* 2 */,
				Fragments._EdgeConnection__Symbolable /* 2 */,
				Fragments._EdgeConnection__Connection /* 3 */,
				Fragments._EdgeConnection__DatumConnection /* 4 */,
				Fragments._EdgeConnection__EdgeConnection /* 5 */
			};
		private static final int @NonNull [] __EdgeConnection = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ErrorNode =
			{
				Fragments._ErrorNode__OclAny /* 0 */,
				Fragments._ErrorNode__OclElement /* 1 */,
				Fragments._ErrorNode__ConnectionEnd /* 2 */,
				Fragments._ErrorNode__Element /* 2 */,
				Fragments._ErrorNode__Node /* 3 */,
				Fragments._ErrorNode__ErrorNode /* 4 */
			};
		private static final int @NonNull [] __ErrorNode = { 1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ExpressionEdge =
			{
				Fragments._ExpressionEdge__OclAny /* 0 */,
				Fragments._ExpressionEdge__OclElement /* 1 */,
				Fragments._ExpressionEdge__Element /* 2 */,
				Fragments._ExpressionEdge__Edge /* 3 */,
				Fragments._ExpressionEdge__ExpressionEdge /* 4 */
			};
		private static final int @NonNull [] __ExpressionEdge = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _InputNode =
			{
				Fragments._InputNode__OclAny /* 0 */,
				Fragments._InputNode__OclElement /* 1 */,
				Fragments._InputNode__ConnectionEnd /* 2 */,
				Fragments._InputNode__Element /* 2 */,
				Fragments._InputNode__Node /* 3 */,
				Fragments._InputNode__InputNode /* 4 */
			};
		private static final int @NonNull [] __InputNode = { 1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _IteratedEdge =
			{
				Fragments._IteratedEdge__OclAny /* 0 */,
				Fragments._IteratedEdge__OclElement /* 1 */,
				Fragments._IteratedEdge__Element /* 2 */,
				Fragments._IteratedEdge__Edge /* 3 */,
				Fragments._IteratedEdge__IteratedEdge /* 4 */
			};
		private static final int @NonNull [] __IteratedEdge = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _IteratorNode =
			{
				Fragments._IteratorNode__OclAny /* 0 */,
				Fragments._IteratorNode__OclElement /* 1 */,
				Fragments._IteratorNode__ConnectionEnd /* 2 */,
				Fragments._IteratorNode__Element /* 2 */,
				Fragments._IteratorNode__Node /* 3 */,
				Fragments._IteratorNode__VariableNode /* 4 */,
				Fragments._IteratorNode__IteratorNode /* 5 */
			};
		private static final int @NonNull [] __IteratorNode = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _KeyedValueNode =
			{
				Fragments._KeyedValueNode__OclAny /* 0 */,
				Fragments._KeyedValueNode__OclElement /* 1 */,
				Fragments._KeyedValueNode__ConnectionEnd /* 2 */,
				Fragments._KeyedValueNode__Element /* 2 */,
				Fragments._KeyedValueNode__Node /* 3 */,
				Fragments._KeyedValueNode__OperationNode /* 4 */,
				Fragments._KeyedValueNode__KeyedValueNode /* 5 */
			};
		private static final int @NonNull [] __KeyedValueNode = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _LoadingRegion =
			{
				Fragments._LoadingRegion__OclAny /* 0 */,
				Fragments._LoadingRegion__OclElement /* 1 */,
				Fragments._LoadingRegion__Element /* 2 */,
				Fragments._LoadingRegion__Symbolable /* 2 */,
				Fragments._LoadingRegion__NamedElement /* 3 */,
				Fragments._LoadingRegion__Region /* 4 */,
				Fragments._LoadingRegion__LoadingRegion /* 5 */
			};
		private static final int @NonNull [] __LoadingRegion = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _MappingRegion =
			{
				Fragments._MappingRegion__OclAny /* 0 */,
				Fragments._MappingRegion__OclElement /* 1 */,
				Fragments._MappingRegion__Element /* 2 */,
				Fragments._MappingRegion__Symbolable /* 2 */,
				Fragments._MappingRegion__NamedElement /* 3 */,
				Fragments._MappingRegion__Region /* 4 */,
				Fragments._MappingRegion__MappingRegion /* 5 */
			};
		private static final int @NonNull [] __MappingRegion = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _MicroMappingRegion =
			{
				Fragments._MicroMappingRegion__OclAny /* 0 */,
				Fragments._MicroMappingRegion__OclElement /* 1 */,
				Fragments._MicroMappingRegion__Element /* 2 */,
				Fragments._MicroMappingRegion__Symbolable /* 2 */,
				Fragments._MicroMappingRegion__NamedElement /* 3 */,
				Fragments._MicroMappingRegion__Region /* 4 */,
				Fragments._MicroMappingRegion__MappingRegion /* 5 */,
				Fragments._MicroMappingRegion__MicroMappingRegion /* 6 */
			};
		private static final int @NonNull [] __MicroMappingRegion = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _NamedMappingRegion =
			{
				Fragments._NamedMappingRegion__OclAny /* 0 */,
				Fragments._NamedMappingRegion__OclElement /* 1 */,
				Fragments._NamedMappingRegion__Element /* 2 */,
				Fragments._NamedMappingRegion__Symbolable /* 2 */,
				Fragments._NamedMappingRegion__NamedElement /* 3 */,
				Fragments._NamedMappingRegion__Region /* 4 */,
				Fragments._NamedMappingRegion__MappingRegion /* 5 */,
				Fragments._NamedMappingRegion__NamedMappingRegion /* 6 */
			};
		private static final int @NonNull [] __NamedMappingRegion = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _NavigableEdge =
			{
				Fragments._NavigableEdge__OclAny /* 0 */,
				Fragments._NavigableEdge__OclElement /* 1 */,
				Fragments._NavigableEdge__ConnectionEnd /* 2 */,
				Fragments._NavigableEdge__Element /* 2 */,
				Fragments._NavigableEdge__Edge /* 3 */,
				Fragments._NavigableEdge__NavigableEdge /* 4 */
			};
		private static final int @NonNull [] __NavigableEdge = { 1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _NavigationEdge =
			{
				Fragments._NavigationEdge__OclAny /* 0 */,
				Fragments._NavigationEdge__OclElement /* 1 */,
				Fragments._NavigationEdge__ConnectionEnd /* 2 */,
				Fragments._NavigationEdge__Element /* 2 */,
				Fragments._NavigationEdge__Edge /* 3 */,
				Fragments._NavigationEdge__NavigableEdge /* 4 */,
				Fragments._NavigationEdge__NavigationEdge /* 5 */
			};
		private static final int @NonNull [] __NavigationEdge = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Node =
			{
				Fragments._Node__OclAny /* 0 */,
				Fragments._Node__OclElement /* 1 */,
				Fragments._Node__ConnectionEnd /* 2 */,
				Fragments._Node__Element /* 2 */,
				Fragments._Node__Node /* 3 */
			};
		private static final int @NonNull [] __Node = { 1,1,2,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _NodeConnection =
			{
				Fragments._NodeConnection__OclAny /* 0 */,
				Fragments._NodeConnection__OclElement /* 1 */,
				Fragments._NodeConnection__Element /* 2 */,
				Fragments._NodeConnection__Symbolable /* 2 */,
				Fragments._NodeConnection__Connection /* 3 */,
				Fragments._NodeConnection__DatumConnection /* 4 */,
				Fragments._NodeConnection__NodeConnection /* 5 */
			};
		private static final int @NonNull [] __NodeConnection = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _NullNode =
			{
				Fragments._NullNode__OclAny /* 0 */,
				Fragments._NullNode__OclElement /* 1 */,
				Fragments._NullNode__ConnectionEnd /* 2 */,
				Fragments._NullNode__Element /* 2 */,
				Fragments._NullNode__Node /* 3 */,
				Fragments._NullNode__NullNode /* 4 */
			};
		private static final int @NonNull [] __NullNode = { 1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OperationNode =
			{
				Fragments._OperationNode__OclAny /* 0 */,
				Fragments._OperationNode__OclElement /* 1 */,
				Fragments._OperationNode__ConnectionEnd /* 2 */,
				Fragments._OperationNode__Element /* 2 */,
				Fragments._OperationNode__Node /* 3 */,
				Fragments._OperationNode__OperationNode /* 4 */
			};
		private static final int @NonNull [] __OperationNode = { 1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OperationRegion =
			{
				Fragments._OperationRegion__OclAny /* 0 */,
				Fragments._OperationRegion__OclElement /* 1 */,
				Fragments._OperationRegion__Element /* 2 */,
				Fragments._OperationRegion__Symbolable /* 2 */,
				Fragments._OperationRegion__NamedElement /* 3 */,
				Fragments._OperationRegion__Region /* 4 */,
				Fragments._OperationRegion__OperationRegion /* 5 */
			};
		private static final int @NonNull [] __OperationRegion = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OperationValueNode =
			{
				Fragments._OperationValueNode__OclAny /* 0 */,
				Fragments._OperationValueNode__OclElement /* 1 */,
				Fragments._OperationValueNode__ConnectionEnd /* 2 */,
				Fragments._OperationValueNode__Element /* 2 */,
				Fragments._OperationValueNode__Node /* 3 */,
				Fragments._OperationValueNode__OperationNode /* 4 */,
				Fragments._OperationValueNode__OperationValueNode /* 5 */
			};
		private static final int @NonNull [] __OperationValueNode = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _PatternTypedNode =
			{
				Fragments._PatternTypedNode__OclAny /* 0 */,
				Fragments._PatternTypedNode__OclElement /* 1 */,
				Fragments._PatternTypedNode__ConnectionEnd /* 2 */,
				Fragments._PatternTypedNode__Element /* 2 */,
				Fragments._PatternTypedNode__Node /* 3 */,
				Fragments._PatternTypedNode__PatternTypedNode /* 4 */
			};
		private static final int @NonNull [] __PatternTypedNode = { 1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _PatternVariableNode =
			{
				Fragments._PatternVariableNode__OclAny /* 0 */,
				Fragments._PatternVariableNode__OclElement /* 1 */,
				Fragments._PatternVariableNode__ConnectionEnd /* 2 */,
				Fragments._PatternVariableNode__Element /* 2 */,
				Fragments._PatternVariableNode__Node /* 3 */,
				Fragments._PatternVariableNode__VariableNode /* 4 */,
				Fragments._PatternVariableNode__PatternVariableNode /* 5 */
			};
		private static final int @NonNull [] __PatternVariableNode = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _PredicateEdge =
			{
				Fragments._PredicateEdge__OclAny /* 0 */,
				Fragments._PredicateEdge__OclElement /* 1 */,
				Fragments._PredicateEdge__Element /* 2 */,
				Fragments._PredicateEdge__Edge /* 3 */,
				Fragments._PredicateEdge__PredicateEdge /* 4 */
			};
		private static final int @NonNull [] __PredicateEdge = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _PropertyDatum =
			{
				Fragments._PropertyDatum__OclAny /* 0 */,
				Fragments._PropertyDatum__OclElement /* 1 */,
				Fragments._PropertyDatum__Element /* 2 */,
				Fragments._PropertyDatum__NamedElement /* 3 */,
				Fragments._PropertyDatum__AbstractDatum /* 4 */,
				Fragments._PropertyDatum__PropertyDatum /* 5 */
			};
		private static final int @NonNull [] __PropertyDatum = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _RecursionEdge =
			{
				Fragments._RecursionEdge__OclAny /* 0 */,
				Fragments._RecursionEdge__OclElement /* 1 */,
				Fragments._RecursionEdge__Element /* 2 */,
				Fragments._RecursionEdge__Edge /* 3 */,
				Fragments._RecursionEdge__RecursionEdge /* 4 */
			};
		private static final int @NonNull [] __RecursionEdge = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Region =
			{
				Fragments._Region__OclAny /* 0 */,
				Fragments._Region__OclElement /* 1 */,
				Fragments._Region__Element /* 2 */,
				Fragments._Region__Symbolable /* 2 */,
				Fragments._Region__NamedElement /* 3 */,
				Fragments._Region__Region /* 4 */
			};
		private static final int @NonNull [] __Region = { 1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Role =
			{
				Fragments._Role__OclAny /* 0 */,
				Fragments._Role__OclElement /* 1 */,
				Fragments._Role__OclType /* 2 */,
				Fragments._Role__OclEnumeration /* 3 */,
				Fragments._Role__Role /* 4 */
			};
		private static final int @NonNull [] __Role = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _RuleRegion =
			{
				Fragments._RuleRegion__OclAny /* 0 */,
				Fragments._RuleRegion__OclElement /* 1 */,
				Fragments._RuleRegion__Element /* 2 */,
				Fragments._RuleRegion__Symbolable /* 2 */,
				Fragments._RuleRegion__NamedElement /* 3 */,
				Fragments._RuleRegion__Region /* 4 */,
				Fragments._RuleRegion__MappingRegion /* 5 */,
				Fragments._RuleRegion__RuleRegion /* 6 */
			};
		private static final int @NonNull [] __RuleRegion = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ScheduleModel =
			{
				Fragments._ScheduleModel__OclAny /* 0 */,
				Fragments._ScheduleModel__OclElement /* 1 */,
				Fragments._ScheduleModel__Element /* 2 */,
				Fragments._ScheduleModel__NamedElement /* 3 */,
				Fragments._ScheduleModel__Namespace /* 4 */,
				Fragments._ScheduleModel__Model /* 5 */,
				Fragments._ScheduleModel__ScheduleModel /* 6 */
			};
		private static final int @NonNull [] __ScheduleModel = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ScheduledRegion =
			{
				Fragments._ScheduledRegion__OclAny /* 0 */,
				Fragments._ScheduledRegion__OclElement /* 1 */,
				Fragments._ScheduledRegion__Element /* 2 */,
				Fragments._ScheduledRegion__Symbolable /* 2 */,
				Fragments._ScheduledRegion__NamedElement /* 3 */,
				Fragments._ScheduledRegion__Region /* 4 */,
				Fragments._ScheduledRegion__ScheduledRegion /* 5 */
			};
		private static final int @NonNull [] __ScheduledRegion = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _SuccessEdge =
			{
				Fragments._SuccessEdge__OclAny /* 0 */,
				Fragments._SuccessEdge__OclElement /* 1 */,
				Fragments._SuccessEdge__ConnectionEnd /* 2 */,
				Fragments._SuccessEdge__Element /* 2 */,
				Fragments._SuccessEdge__Edge /* 3 */,
				Fragments._SuccessEdge__NavigableEdge /* 4 */,
				Fragments._SuccessEdge__NavigationEdge /* 5 */,
				Fragments._SuccessEdge__SuccessEdge /* 6 */
			};
		private static final int @NonNull [] __SuccessEdge = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _SuccessNode =
			{
				Fragments._SuccessNode__OclAny /* 0 */,
				Fragments._SuccessNode__OclElement /* 1 */,
				Fragments._SuccessNode__ConnectionEnd /* 2 */,
				Fragments._SuccessNode__Element /* 2 */,
				Fragments._SuccessNode__Node /* 3 */,
				Fragments._SuccessNode__SuccessNode /* 4 */
			};
		private static final int @NonNull [] __SuccessNode = { 1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Symbolable =
			{
				Fragments._Symbolable__OclAny /* 0 */,
				Fragments._Symbolable__OclElement /* 1 */,
				Fragments._Symbolable__Symbolable /* 2 */
			};
		private static final int @NonNull [] __Symbolable = { 1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _UnknownNode =
			{
				Fragments._UnknownNode__OclAny /* 0 */,
				Fragments._UnknownNode__OclElement /* 1 */,
				Fragments._UnknownNode__ConnectionEnd /* 2 */,
				Fragments._UnknownNode__Element /* 2 */,
				Fragments._UnknownNode__Node /* 3 */,
				Fragments._UnknownNode__UnknownNode /* 4 */
			};
		private static final int @NonNull [] __UnknownNode = { 1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _VariableNode =
			{
				Fragments._VariableNode__OclAny /* 0 */,
				Fragments._VariableNode__OclElement /* 1 */,
				Fragments._VariableNode__ConnectionEnd /* 2 */,
				Fragments._VariableNode__Element /* 2 */,
				Fragments._VariableNode__Node /* 3 */,
				Fragments._VariableNode__VariableNode /* 4 */
			};
		private static final int @NonNull [] __VariableNode = { 1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _VerdictRegion =
			{
				Fragments._VerdictRegion__OclAny /* 0 */,
				Fragments._VerdictRegion__OclElement /* 1 */,
				Fragments._VerdictRegion__Element /* 2 */,
				Fragments._VerdictRegion__Symbolable /* 2 */,
				Fragments._VerdictRegion__NamedElement /* 3 */,
				Fragments._VerdictRegion__Region /* 4 */,
				Fragments._VerdictRegion__MappingRegion /* 5 */,
				Fragments._VerdictRegion__RuleRegion /* 6 */,
				Fragments._VerdictRegion__VerdictRegion /* 7 */
			};
		private static final int @NonNull [] __VerdictRegion = { 1,1,2,1,1,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._AbstractDatum.initFragments(_AbstractDatum, __AbstractDatum);
			Types._BooleanValueNode.initFragments(_BooleanValueNode, __BooleanValueNode);
			Types._CastEdge.initFragments(_CastEdge, __CastEdge);
			Types._ClassDatum.initFragments(_ClassDatum, __ClassDatum);
			Types._ComposedNode.initFragments(_ComposedNode, __ComposedNode);
			Types._Connection.initFragments(_Connection, __Connection);
			Types._ConnectionEnd.initFragments(_ConnectionEnd, __ConnectionEnd);
			Types._ConnectionRole.initFragments(_ConnectionRole, __ConnectionRole);
			Types._DatumConnection.initFragments(_DatumConnection, __DatumConnection);
			Types._DependencyNode.initFragments(_DependencyNode, __DependencyNode);
			Types._DispatchRegion.initFragments(_DispatchRegion, __DispatchRegion);
			Types._Edge.initFragments(_Edge, __Edge);
			Types._EdgeConnection.initFragments(_EdgeConnection, __EdgeConnection);
			Types._ErrorNode.initFragments(_ErrorNode, __ErrorNode);
			Types._ExpressionEdge.initFragments(_ExpressionEdge, __ExpressionEdge);
			Types._InputNode.initFragments(_InputNode, __InputNode);
			Types._IteratedEdge.initFragments(_IteratedEdge, __IteratedEdge);
			Types._IteratorNode.initFragments(_IteratorNode, __IteratorNode);
			Types._KeyedValueNode.initFragments(_KeyedValueNode, __KeyedValueNode);
			Types._LoadingRegion.initFragments(_LoadingRegion, __LoadingRegion);
			Types._MappingRegion.initFragments(_MappingRegion, __MappingRegion);
			Types._MicroMappingRegion.initFragments(_MicroMappingRegion, __MicroMappingRegion);
			Types._NamedMappingRegion.initFragments(_NamedMappingRegion, __NamedMappingRegion);
			Types._NavigableEdge.initFragments(_NavigableEdge, __NavigableEdge);
			Types._NavigationEdge.initFragments(_NavigationEdge, __NavigationEdge);
			Types._Node.initFragments(_Node, __Node);
			Types._NodeConnection.initFragments(_NodeConnection, __NodeConnection);
			Types._NullNode.initFragments(_NullNode, __NullNode);
			Types._OperationNode.initFragments(_OperationNode, __OperationNode);
			Types._OperationRegion.initFragments(_OperationRegion, __OperationRegion);
			Types._OperationValueNode.initFragments(_OperationValueNode, __OperationValueNode);
			Types._PatternTypedNode.initFragments(_PatternTypedNode, __PatternTypedNode);
			Types._PatternVariableNode.initFragments(_PatternVariableNode, __PatternVariableNode);
			Types._PredicateEdge.initFragments(_PredicateEdge, __PredicateEdge);
			Types._PropertyDatum.initFragments(_PropertyDatum, __PropertyDatum);
			Types._RecursionEdge.initFragments(_RecursionEdge, __RecursionEdge);
			Types._Region.initFragments(_Region, __Region);
			Types._Role.initFragments(_Role, __Role);
			Types._RuleRegion.initFragments(_RuleRegion, __RuleRegion);
			Types._ScheduleModel.initFragments(_ScheduleModel, __ScheduleModel);
			Types._ScheduledRegion.initFragments(_ScheduledRegion, __ScheduledRegion);
			Types._SuccessEdge.initFragments(_SuccessEdge, __SuccessEdge);
			Types._SuccessNode.initFragments(_SuccessNode, __SuccessNode);
			Types._Symbolable.initFragments(_Symbolable, __Symbolable);
			Types._UnknownNode.initFragments(_UnknownNode, __UnknownNode);
			Types._VariableNode.initFragments(_VariableNode, __VariableNode);
			Types._VerdictRegion.initFragments(_VerdictRegion, __VerdictRegion);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTscheduleTables::TypeFragments and all preceding sub-packages.
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

		private static final @NonNull ExecutorOperation @NonNull [] _AbstractDatum__AbstractDatum = {};
		private static final @NonNull ExecutorOperation @NonNull [] _AbstractDatum__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _AbstractDatum__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _AbstractDatum__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _AbstractDatum__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _BooleanValueNode__BooleanValueNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanValueNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanValueNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanValueNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanValueNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanValueNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanValueNode__OperationNode = {};

		private static final @NonNull ExecutorOperation @NonNull [] _CastEdge__CastEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CastEdge__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CastEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CastEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CastEdge__NavigableEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CastEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _CastEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _ClassDatum__ClassDatum = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ClassDatum__AbstractDatum = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ClassDatum__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ClassDatum__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ClassDatum__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ClassDatum__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _ComposedNode__ComposedNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ComposedNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ComposedNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ComposedNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ComposedNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ComposedNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Connection__Connection = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Connection__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Connection__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Connection__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Connection__Symbolable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionEnd__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionEnd__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionEnd__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionRole__ConnectionRole = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionRole__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionRole__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionRole__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionRole__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _DatumConnection__DatumConnection = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DatumConnection__Connection = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DatumConnection__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _DatumConnection__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _DatumConnection__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _DatumConnection__Symbolable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _DependencyNode__DependencyNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DependencyNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DependencyNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _DependencyNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DependencyNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _DependencyNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _DispatchRegion__DispatchRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DispatchRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _DispatchRegion__MappingRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DispatchRegion__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DispatchRegion__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _DispatchRegion__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _DispatchRegion__Region = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DispatchRegion__RuleRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DispatchRegion__Symbolable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Edge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Edge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Edge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Edge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _EdgeConnection__EdgeConnection = {};
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeConnection__Connection = {};
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeConnection__DatumConnection = {};
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeConnection__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeConnection__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeConnection__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeConnection__Symbolable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _ErrorNode__ErrorNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ErrorNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ErrorNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ErrorNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ErrorNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ErrorNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionEdge__ExpressionEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _InputNode__InputNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _InputNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _InputNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _InputNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _InputNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _InputNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _IteratedEdge__IteratedEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratedEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratedEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratedEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _IteratedEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _IteratorNode__IteratorNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorNode__VariableNode = {};

		private static final @NonNull ExecutorOperation @NonNull [] _KeyedValueNode__KeyedValueNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _KeyedValueNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _KeyedValueNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _KeyedValueNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _KeyedValueNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _KeyedValueNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _KeyedValueNode__OperationNode = {};

		private static final @NonNull ExecutorOperation @NonNull [] _LoadingRegion__LoadingRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LoadingRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _LoadingRegion__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LoadingRegion__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _LoadingRegion__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _LoadingRegion__Region = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LoadingRegion__Symbolable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _MappingRegion__MappingRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingRegion__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingRegion__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _MappingRegion__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingRegion__Region = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingRegion__Symbolable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _MicroMappingRegion__MicroMappingRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MicroMappingRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MicroMappingRegion__MappingRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MicroMappingRegion__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MicroMappingRegion__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _MicroMappingRegion__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MicroMappingRegion__Region = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MicroMappingRegion__Symbolable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _NamedMappingRegion__NamedMappingRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedMappingRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedMappingRegion__MappingRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedMappingRegion__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedMappingRegion__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _NamedMappingRegion__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedMappingRegion__Region = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedMappingRegion__Symbolable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _NavigableEdge__NavigableEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigableEdge__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigableEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigableEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigableEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _NavigableEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _NavigationEdge__NavigationEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigationEdge__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigationEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigationEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigationEdge__NavigableEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigationEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _NavigationEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Node__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Node__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Node__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Node__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Node__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _NodeConnection__NodeConnection = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NodeConnection__Connection = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NodeConnection__DatumConnection = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NodeConnection__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NodeConnection__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _NodeConnection__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NodeConnection__Symbolable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _NullNode__NullNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NullNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NullNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NullNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NullNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _NullNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _OperationNode__OperationNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _OperationNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _OperationRegion__OperationRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationRegion__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationRegion__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _OperationRegion__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationRegion__Region = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationRegion__Symbolable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _OperationValueNode__OperationValueNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationValueNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationValueNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationValueNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationValueNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _OperationValueNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationValueNode__OperationNode = {};

		private static final @NonNull ExecutorOperation @NonNull [] _PatternTypedNode__PatternTypedNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternTypedNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternTypedNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternTypedNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternTypedNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _PatternTypedNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _PatternVariableNode__PatternVariableNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternVariableNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternVariableNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternVariableNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternVariableNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _PatternVariableNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternVariableNode__VariableNode = {};

		private static final @NonNull ExecutorOperation @NonNull [] _PredicateEdge__PredicateEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PredicateEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PredicateEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PredicateEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _PredicateEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _PropertyDatum__PropertyDatum = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyDatum__AbstractDatum = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyDatum__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyDatum__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyDatum__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyDatum__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _RecursionEdge__RecursionEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RecursionEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RecursionEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RecursionEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _RecursionEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Region__Region = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Region__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Region__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Region__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Region__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Region__Symbolable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Role__Role = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Role__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Role__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Role__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Role__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _RuleRegion__RuleRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RuleRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RuleRegion__MappingRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RuleRegion__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RuleRegion__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _RuleRegion__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RuleRegion__Region = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RuleRegion__Symbolable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _ScheduleModel__ScheduleModel = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduleModel__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduleModel__Model = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduleModel__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduleModel__Namespace = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduleModel__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduleModel__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _ScheduledRegion__ScheduledRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduledRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduledRegion__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduledRegion__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduledRegion__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduledRegion__Region = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduledRegion__Symbolable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _SuccessEdge__SuccessEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SuccessEdge__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SuccessEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SuccessEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SuccessEdge__NavigableEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SuccessEdge__NavigationEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SuccessEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _SuccessEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _SuccessNode__SuccessNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SuccessNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SuccessNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SuccessNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SuccessNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _SuccessNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Symbolable__Symbolable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Symbolable__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Symbolable__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _UnknownNode__UnknownNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _UnknownNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _UnknownNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _UnknownNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _UnknownNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _UnknownNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _VariableNode__VariableNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _VariableNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _VerdictRegion__VerdictRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _VerdictRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _VerdictRegion__MappingRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _VerdictRegion__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _VerdictRegion__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _VerdictRegion__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _VerdictRegion__Region = {};
		private static final @NonNull ExecutorOperation @NonNull [] _VerdictRegion__RuleRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _VerdictRegion__Symbolable = {};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._AbstractDatum__AbstractDatum.initOperations(_AbstractDatum__AbstractDatum);
			Fragments._AbstractDatum__Element.initOperations(_AbstractDatum__Element);
			Fragments._AbstractDatum__NamedElement.initOperations(_AbstractDatum__NamedElement);
			Fragments._AbstractDatum__OclAny.initOperations(_AbstractDatum__OclAny);
			Fragments._AbstractDatum__OclElement.initOperations(_AbstractDatum__OclElement);

			Fragments._BooleanValueNode__BooleanValueNode.initOperations(_BooleanValueNode__BooleanValueNode);
			Fragments._BooleanValueNode__ConnectionEnd.initOperations(_BooleanValueNode__ConnectionEnd);
			Fragments._BooleanValueNode__Element.initOperations(_BooleanValueNode__Element);
			Fragments._BooleanValueNode__Node.initOperations(_BooleanValueNode__Node);
			Fragments._BooleanValueNode__OclAny.initOperations(_BooleanValueNode__OclAny);
			Fragments._BooleanValueNode__OclElement.initOperations(_BooleanValueNode__OclElement);
			Fragments._BooleanValueNode__OperationNode.initOperations(_BooleanValueNode__OperationNode);

			Fragments._CastEdge__CastEdge.initOperations(_CastEdge__CastEdge);
			Fragments._CastEdge__ConnectionEnd.initOperations(_CastEdge__ConnectionEnd);
			Fragments._CastEdge__Edge.initOperations(_CastEdge__Edge);
			Fragments._CastEdge__Element.initOperations(_CastEdge__Element);
			Fragments._CastEdge__NavigableEdge.initOperations(_CastEdge__NavigableEdge);
			Fragments._CastEdge__OclAny.initOperations(_CastEdge__OclAny);
			Fragments._CastEdge__OclElement.initOperations(_CastEdge__OclElement);

			Fragments._ClassDatum__AbstractDatum.initOperations(_ClassDatum__AbstractDatum);
			Fragments._ClassDatum__ClassDatum.initOperations(_ClassDatum__ClassDatum);
			Fragments._ClassDatum__Element.initOperations(_ClassDatum__Element);
			Fragments._ClassDatum__NamedElement.initOperations(_ClassDatum__NamedElement);
			Fragments._ClassDatum__OclAny.initOperations(_ClassDatum__OclAny);
			Fragments._ClassDatum__OclElement.initOperations(_ClassDatum__OclElement);

			Fragments._ComposedNode__ComposedNode.initOperations(_ComposedNode__ComposedNode);
			Fragments._ComposedNode__ConnectionEnd.initOperations(_ComposedNode__ConnectionEnd);
			Fragments._ComposedNode__Element.initOperations(_ComposedNode__Element);
			Fragments._ComposedNode__Node.initOperations(_ComposedNode__Node);
			Fragments._ComposedNode__OclAny.initOperations(_ComposedNode__OclAny);
			Fragments._ComposedNode__OclElement.initOperations(_ComposedNode__OclElement);

			Fragments._Connection__Connection.initOperations(_Connection__Connection);
			Fragments._Connection__Element.initOperations(_Connection__Element);
			Fragments._Connection__OclAny.initOperations(_Connection__OclAny);
			Fragments._Connection__OclElement.initOperations(_Connection__OclElement);
			Fragments._Connection__Symbolable.initOperations(_Connection__Symbolable);

			Fragments._ConnectionEnd__ConnectionEnd.initOperations(_ConnectionEnd__ConnectionEnd);
			Fragments._ConnectionEnd__OclAny.initOperations(_ConnectionEnd__OclAny);
			Fragments._ConnectionEnd__OclElement.initOperations(_ConnectionEnd__OclElement);

			Fragments._ConnectionRole__ConnectionRole.initOperations(_ConnectionRole__ConnectionRole);
			Fragments._ConnectionRole__OclAny.initOperations(_ConnectionRole__OclAny);
			Fragments._ConnectionRole__OclElement.initOperations(_ConnectionRole__OclElement);
			Fragments._ConnectionRole__OclEnumeration.initOperations(_ConnectionRole__OclEnumeration);
			Fragments._ConnectionRole__OclType.initOperations(_ConnectionRole__OclType);

			Fragments._DatumConnection__Connection.initOperations(_DatumConnection__Connection);
			Fragments._DatumConnection__DatumConnection.initOperations(_DatumConnection__DatumConnection);
			Fragments._DatumConnection__Element.initOperations(_DatumConnection__Element);
			Fragments._DatumConnection__OclAny.initOperations(_DatumConnection__OclAny);
			Fragments._DatumConnection__OclElement.initOperations(_DatumConnection__OclElement);
			Fragments._DatumConnection__Symbolable.initOperations(_DatumConnection__Symbolable);

			Fragments._DependencyNode__ConnectionEnd.initOperations(_DependencyNode__ConnectionEnd);
			Fragments._DependencyNode__DependencyNode.initOperations(_DependencyNode__DependencyNode);
			Fragments._DependencyNode__Element.initOperations(_DependencyNode__Element);
			Fragments._DependencyNode__Node.initOperations(_DependencyNode__Node);
			Fragments._DependencyNode__OclAny.initOperations(_DependencyNode__OclAny);
			Fragments._DependencyNode__OclElement.initOperations(_DependencyNode__OclElement);

			Fragments._DispatchRegion__DispatchRegion.initOperations(_DispatchRegion__DispatchRegion);
			Fragments._DispatchRegion__Element.initOperations(_DispatchRegion__Element);
			Fragments._DispatchRegion__MappingRegion.initOperations(_DispatchRegion__MappingRegion);
			Fragments._DispatchRegion__NamedElement.initOperations(_DispatchRegion__NamedElement);
			Fragments._DispatchRegion__OclAny.initOperations(_DispatchRegion__OclAny);
			Fragments._DispatchRegion__OclElement.initOperations(_DispatchRegion__OclElement);
			Fragments._DispatchRegion__Region.initOperations(_DispatchRegion__Region);
			Fragments._DispatchRegion__RuleRegion.initOperations(_DispatchRegion__RuleRegion);
			Fragments._DispatchRegion__Symbolable.initOperations(_DispatchRegion__Symbolable);

			Fragments._Edge__Edge.initOperations(_Edge__Edge);
			Fragments._Edge__Element.initOperations(_Edge__Element);
			Fragments._Edge__OclAny.initOperations(_Edge__OclAny);
			Fragments._Edge__OclElement.initOperations(_Edge__OclElement);

			Fragments._EdgeConnection__Connection.initOperations(_EdgeConnection__Connection);
			Fragments._EdgeConnection__DatumConnection.initOperations(_EdgeConnection__DatumConnection);
			Fragments._EdgeConnection__EdgeConnection.initOperations(_EdgeConnection__EdgeConnection);
			Fragments._EdgeConnection__Element.initOperations(_EdgeConnection__Element);
			Fragments._EdgeConnection__OclAny.initOperations(_EdgeConnection__OclAny);
			Fragments._EdgeConnection__OclElement.initOperations(_EdgeConnection__OclElement);
			Fragments._EdgeConnection__Symbolable.initOperations(_EdgeConnection__Symbolable);

			Fragments._ErrorNode__ConnectionEnd.initOperations(_ErrorNode__ConnectionEnd);
			Fragments._ErrorNode__Element.initOperations(_ErrorNode__Element);
			Fragments._ErrorNode__ErrorNode.initOperations(_ErrorNode__ErrorNode);
			Fragments._ErrorNode__Node.initOperations(_ErrorNode__Node);
			Fragments._ErrorNode__OclAny.initOperations(_ErrorNode__OclAny);
			Fragments._ErrorNode__OclElement.initOperations(_ErrorNode__OclElement);

			Fragments._ExpressionEdge__Edge.initOperations(_ExpressionEdge__Edge);
			Fragments._ExpressionEdge__Element.initOperations(_ExpressionEdge__Element);
			Fragments._ExpressionEdge__ExpressionEdge.initOperations(_ExpressionEdge__ExpressionEdge);
			Fragments._ExpressionEdge__OclAny.initOperations(_ExpressionEdge__OclAny);
			Fragments._ExpressionEdge__OclElement.initOperations(_ExpressionEdge__OclElement);

			Fragments._InputNode__ConnectionEnd.initOperations(_InputNode__ConnectionEnd);
			Fragments._InputNode__Element.initOperations(_InputNode__Element);
			Fragments._InputNode__InputNode.initOperations(_InputNode__InputNode);
			Fragments._InputNode__Node.initOperations(_InputNode__Node);
			Fragments._InputNode__OclAny.initOperations(_InputNode__OclAny);
			Fragments._InputNode__OclElement.initOperations(_InputNode__OclElement);

			Fragments._IteratedEdge__Edge.initOperations(_IteratedEdge__Edge);
			Fragments._IteratedEdge__Element.initOperations(_IteratedEdge__Element);
			Fragments._IteratedEdge__IteratedEdge.initOperations(_IteratedEdge__IteratedEdge);
			Fragments._IteratedEdge__OclAny.initOperations(_IteratedEdge__OclAny);
			Fragments._IteratedEdge__OclElement.initOperations(_IteratedEdge__OclElement);

			Fragments._IteratorNode__ConnectionEnd.initOperations(_IteratorNode__ConnectionEnd);
			Fragments._IteratorNode__Element.initOperations(_IteratorNode__Element);
			Fragments._IteratorNode__IteratorNode.initOperations(_IteratorNode__IteratorNode);
			Fragments._IteratorNode__Node.initOperations(_IteratorNode__Node);
			Fragments._IteratorNode__OclAny.initOperations(_IteratorNode__OclAny);
			Fragments._IteratorNode__OclElement.initOperations(_IteratorNode__OclElement);
			Fragments._IteratorNode__VariableNode.initOperations(_IteratorNode__VariableNode);

			Fragments._KeyedValueNode__ConnectionEnd.initOperations(_KeyedValueNode__ConnectionEnd);
			Fragments._KeyedValueNode__Element.initOperations(_KeyedValueNode__Element);
			Fragments._KeyedValueNode__KeyedValueNode.initOperations(_KeyedValueNode__KeyedValueNode);
			Fragments._KeyedValueNode__Node.initOperations(_KeyedValueNode__Node);
			Fragments._KeyedValueNode__OclAny.initOperations(_KeyedValueNode__OclAny);
			Fragments._KeyedValueNode__OclElement.initOperations(_KeyedValueNode__OclElement);
			Fragments._KeyedValueNode__OperationNode.initOperations(_KeyedValueNode__OperationNode);

			Fragments._LoadingRegion__Element.initOperations(_LoadingRegion__Element);
			Fragments._LoadingRegion__LoadingRegion.initOperations(_LoadingRegion__LoadingRegion);
			Fragments._LoadingRegion__NamedElement.initOperations(_LoadingRegion__NamedElement);
			Fragments._LoadingRegion__OclAny.initOperations(_LoadingRegion__OclAny);
			Fragments._LoadingRegion__OclElement.initOperations(_LoadingRegion__OclElement);
			Fragments._LoadingRegion__Region.initOperations(_LoadingRegion__Region);
			Fragments._LoadingRegion__Symbolable.initOperations(_LoadingRegion__Symbolable);

			Fragments._MappingRegion__Element.initOperations(_MappingRegion__Element);
			Fragments._MappingRegion__MappingRegion.initOperations(_MappingRegion__MappingRegion);
			Fragments._MappingRegion__NamedElement.initOperations(_MappingRegion__NamedElement);
			Fragments._MappingRegion__OclAny.initOperations(_MappingRegion__OclAny);
			Fragments._MappingRegion__OclElement.initOperations(_MappingRegion__OclElement);
			Fragments._MappingRegion__Region.initOperations(_MappingRegion__Region);
			Fragments._MappingRegion__Symbolable.initOperations(_MappingRegion__Symbolable);

			Fragments._MicroMappingRegion__Element.initOperations(_MicroMappingRegion__Element);
			Fragments._MicroMappingRegion__MappingRegion.initOperations(_MicroMappingRegion__MappingRegion);
			Fragments._MicroMappingRegion__MicroMappingRegion.initOperations(_MicroMappingRegion__MicroMappingRegion);
			Fragments._MicroMappingRegion__NamedElement.initOperations(_MicroMappingRegion__NamedElement);
			Fragments._MicroMappingRegion__OclAny.initOperations(_MicroMappingRegion__OclAny);
			Fragments._MicroMappingRegion__OclElement.initOperations(_MicroMappingRegion__OclElement);
			Fragments._MicroMappingRegion__Region.initOperations(_MicroMappingRegion__Region);
			Fragments._MicroMappingRegion__Symbolable.initOperations(_MicroMappingRegion__Symbolable);

			Fragments._NamedMappingRegion__Element.initOperations(_NamedMappingRegion__Element);
			Fragments._NamedMappingRegion__MappingRegion.initOperations(_NamedMappingRegion__MappingRegion);
			Fragments._NamedMappingRegion__NamedElement.initOperations(_NamedMappingRegion__NamedElement);
			Fragments._NamedMappingRegion__NamedMappingRegion.initOperations(_NamedMappingRegion__NamedMappingRegion);
			Fragments._NamedMappingRegion__OclAny.initOperations(_NamedMappingRegion__OclAny);
			Fragments._NamedMappingRegion__OclElement.initOperations(_NamedMappingRegion__OclElement);
			Fragments._NamedMappingRegion__Region.initOperations(_NamedMappingRegion__Region);
			Fragments._NamedMappingRegion__Symbolable.initOperations(_NamedMappingRegion__Symbolable);

			Fragments._NavigableEdge__ConnectionEnd.initOperations(_NavigableEdge__ConnectionEnd);
			Fragments._NavigableEdge__Edge.initOperations(_NavigableEdge__Edge);
			Fragments._NavigableEdge__Element.initOperations(_NavigableEdge__Element);
			Fragments._NavigableEdge__NavigableEdge.initOperations(_NavigableEdge__NavigableEdge);
			Fragments._NavigableEdge__OclAny.initOperations(_NavigableEdge__OclAny);
			Fragments._NavigableEdge__OclElement.initOperations(_NavigableEdge__OclElement);

			Fragments._NavigationEdge__ConnectionEnd.initOperations(_NavigationEdge__ConnectionEnd);
			Fragments._NavigationEdge__Edge.initOperations(_NavigationEdge__Edge);
			Fragments._NavigationEdge__Element.initOperations(_NavigationEdge__Element);
			Fragments._NavigationEdge__NavigableEdge.initOperations(_NavigationEdge__NavigableEdge);
			Fragments._NavigationEdge__NavigationEdge.initOperations(_NavigationEdge__NavigationEdge);
			Fragments._NavigationEdge__OclAny.initOperations(_NavigationEdge__OclAny);
			Fragments._NavigationEdge__OclElement.initOperations(_NavigationEdge__OclElement);

			Fragments._Node__ConnectionEnd.initOperations(_Node__ConnectionEnd);
			Fragments._Node__Element.initOperations(_Node__Element);
			Fragments._Node__Node.initOperations(_Node__Node);
			Fragments._Node__OclAny.initOperations(_Node__OclAny);
			Fragments._Node__OclElement.initOperations(_Node__OclElement);

			Fragments._NodeConnection__Connection.initOperations(_NodeConnection__Connection);
			Fragments._NodeConnection__DatumConnection.initOperations(_NodeConnection__DatumConnection);
			Fragments._NodeConnection__Element.initOperations(_NodeConnection__Element);
			Fragments._NodeConnection__NodeConnection.initOperations(_NodeConnection__NodeConnection);
			Fragments._NodeConnection__OclAny.initOperations(_NodeConnection__OclAny);
			Fragments._NodeConnection__OclElement.initOperations(_NodeConnection__OclElement);
			Fragments._NodeConnection__Symbolable.initOperations(_NodeConnection__Symbolable);

			Fragments._NullNode__ConnectionEnd.initOperations(_NullNode__ConnectionEnd);
			Fragments._NullNode__Element.initOperations(_NullNode__Element);
			Fragments._NullNode__Node.initOperations(_NullNode__Node);
			Fragments._NullNode__NullNode.initOperations(_NullNode__NullNode);
			Fragments._NullNode__OclAny.initOperations(_NullNode__OclAny);
			Fragments._NullNode__OclElement.initOperations(_NullNode__OclElement);

			Fragments._OperationNode__ConnectionEnd.initOperations(_OperationNode__ConnectionEnd);
			Fragments._OperationNode__Element.initOperations(_OperationNode__Element);
			Fragments._OperationNode__Node.initOperations(_OperationNode__Node);
			Fragments._OperationNode__OclAny.initOperations(_OperationNode__OclAny);
			Fragments._OperationNode__OclElement.initOperations(_OperationNode__OclElement);
			Fragments._OperationNode__OperationNode.initOperations(_OperationNode__OperationNode);

			Fragments._OperationRegion__Element.initOperations(_OperationRegion__Element);
			Fragments._OperationRegion__NamedElement.initOperations(_OperationRegion__NamedElement);
			Fragments._OperationRegion__OclAny.initOperations(_OperationRegion__OclAny);
			Fragments._OperationRegion__OclElement.initOperations(_OperationRegion__OclElement);
			Fragments._OperationRegion__OperationRegion.initOperations(_OperationRegion__OperationRegion);
			Fragments._OperationRegion__Region.initOperations(_OperationRegion__Region);
			Fragments._OperationRegion__Symbolable.initOperations(_OperationRegion__Symbolable);

			Fragments._OperationValueNode__ConnectionEnd.initOperations(_OperationValueNode__ConnectionEnd);
			Fragments._OperationValueNode__Element.initOperations(_OperationValueNode__Element);
			Fragments._OperationValueNode__Node.initOperations(_OperationValueNode__Node);
			Fragments._OperationValueNode__OclAny.initOperations(_OperationValueNode__OclAny);
			Fragments._OperationValueNode__OclElement.initOperations(_OperationValueNode__OclElement);
			Fragments._OperationValueNode__OperationNode.initOperations(_OperationValueNode__OperationNode);
			Fragments._OperationValueNode__OperationValueNode.initOperations(_OperationValueNode__OperationValueNode);

			Fragments._PatternTypedNode__ConnectionEnd.initOperations(_PatternTypedNode__ConnectionEnd);
			Fragments._PatternTypedNode__Element.initOperations(_PatternTypedNode__Element);
			Fragments._PatternTypedNode__Node.initOperations(_PatternTypedNode__Node);
			Fragments._PatternTypedNode__OclAny.initOperations(_PatternTypedNode__OclAny);
			Fragments._PatternTypedNode__OclElement.initOperations(_PatternTypedNode__OclElement);
			Fragments._PatternTypedNode__PatternTypedNode.initOperations(_PatternTypedNode__PatternTypedNode);

			Fragments._PatternVariableNode__ConnectionEnd.initOperations(_PatternVariableNode__ConnectionEnd);
			Fragments._PatternVariableNode__Element.initOperations(_PatternVariableNode__Element);
			Fragments._PatternVariableNode__Node.initOperations(_PatternVariableNode__Node);
			Fragments._PatternVariableNode__OclAny.initOperations(_PatternVariableNode__OclAny);
			Fragments._PatternVariableNode__OclElement.initOperations(_PatternVariableNode__OclElement);
			Fragments._PatternVariableNode__PatternVariableNode.initOperations(_PatternVariableNode__PatternVariableNode);
			Fragments._PatternVariableNode__VariableNode.initOperations(_PatternVariableNode__VariableNode);

			Fragments._PredicateEdge__Edge.initOperations(_PredicateEdge__Edge);
			Fragments._PredicateEdge__Element.initOperations(_PredicateEdge__Element);
			Fragments._PredicateEdge__OclAny.initOperations(_PredicateEdge__OclAny);
			Fragments._PredicateEdge__OclElement.initOperations(_PredicateEdge__OclElement);
			Fragments._PredicateEdge__PredicateEdge.initOperations(_PredicateEdge__PredicateEdge);

			Fragments._PropertyDatum__AbstractDatum.initOperations(_PropertyDatum__AbstractDatum);
			Fragments._PropertyDatum__Element.initOperations(_PropertyDatum__Element);
			Fragments._PropertyDatum__NamedElement.initOperations(_PropertyDatum__NamedElement);
			Fragments._PropertyDatum__OclAny.initOperations(_PropertyDatum__OclAny);
			Fragments._PropertyDatum__OclElement.initOperations(_PropertyDatum__OclElement);
			Fragments._PropertyDatum__PropertyDatum.initOperations(_PropertyDatum__PropertyDatum);

			Fragments._RecursionEdge__Edge.initOperations(_RecursionEdge__Edge);
			Fragments._RecursionEdge__Element.initOperations(_RecursionEdge__Element);
			Fragments._RecursionEdge__OclAny.initOperations(_RecursionEdge__OclAny);
			Fragments._RecursionEdge__OclElement.initOperations(_RecursionEdge__OclElement);
			Fragments._RecursionEdge__RecursionEdge.initOperations(_RecursionEdge__RecursionEdge);

			Fragments._Region__Element.initOperations(_Region__Element);
			Fragments._Region__NamedElement.initOperations(_Region__NamedElement);
			Fragments._Region__OclAny.initOperations(_Region__OclAny);
			Fragments._Region__OclElement.initOperations(_Region__OclElement);
			Fragments._Region__Region.initOperations(_Region__Region);
			Fragments._Region__Symbolable.initOperations(_Region__Symbolable);

			Fragments._Role__OclAny.initOperations(_Role__OclAny);
			Fragments._Role__OclElement.initOperations(_Role__OclElement);
			Fragments._Role__OclEnumeration.initOperations(_Role__OclEnumeration);
			Fragments._Role__OclType.initOperations(_Role__OclType);
			Fragments._Role__Role.initOperations(_Role__Role);

			Fragments._RuleRegion__Element.initOperations(_RuleRegion__Element);
			Fragments._RuleRegion__MappingRegion.initOperations(_RuleRegion__MappingRegion);
			Fragments._RuleRegion__NamedElement.initOperations(_RuleRegion__NamedElement);
			Fragments._RuleRegion__OclAny.initOperations(_RuleRegion__OclAny);
			Fragments._RuleRegion__OclElement.initOperations(_RuleRegion__OclElement);
			Fragments._RuleRegion__Region.initOperations(_RuleRegion__Region);
			Fragments._RuleRegion__RuleRegion.initOperations(_RuleRegion__RuleRegion);
			Fragments._RuleRegion__Symbolable.initOperations(_RuleRegion__Symbolable);

			Fragments._ScheduleModel__Element.initOperations(_ScheduleModel__Element);
			Fragments._ScheduleModel__Model.initOperations(_ScheduleModel__Model);
			Fragments._ScheduleModel__NamedElement.initOperations(_ScheduleModel__NamedElement);
			Fragments._ScheduleModel__Namespace.initOperations(_ScheduleModel__Namespace);
			Fragments._ScheduleModel__OclAny.initOperations(_ScheduleModel__OclAny);
			Fragments._ScheduleModel__OclElement.initOperations(_ScheduleModel__OclElement);
			Fragments._ScheduleModel__ScheduleModel.initOperations(_ScheduleModel__ScheduleModel);

			Fragments._ScheduledRegion__Element.initOperations(_ScheduledRegion__Element);
			Fragments._ScheduledRegion__NamedElement.initOperations(_ScheduledRegion__NamedElement);
			Fragments._ScheduledRegion__OclAny.initOperations(_ScheduledRegion__OclAny);
			Fragments._ScheduledRegion__OclElement.initOperations(_ScheduledRegion__OclElement);
			Fragments._ScheduledRegion__Region.initOperations(_ScheduledRegion__Region);
			Fragments._ScheduledRegion__ScheduledRegion.initOperations(_ScheduledRegion__ScheduledRegion);
			Fragments._ScheduledRegion__Symbolable.initOperations(_ScheduledRegion__Symbolable);

			Fragments._SuccessEdge__ConnectionEnd.initOperations(_SuccessEdge__ConnectionEnd);
			Fragments._SuccessEdge__Edge.initOperations(_SuccessEdge__Edge);
			Fragments._SuccessEdge__Element.initOperations(_SuccessEdge__Element);
			Fragments._SuccessEdge__NavigableEdge.initOperations(_SuccessEdge__NavigableEdge);
			Fragments._SuccessEdge__NavigationEdge.initOperations(_SuccessEdge__NavigationEdge);
			Fragments._SuccessEdge__OclAny.initOperations(_SuccessEdge__OclAny);
			Fragments._SuccessEdge__OclElement.initOperations(_SuccessEdge__OclElement);
			Fragments._SuccessEdge__SuccessEdge.initOperations(_SuccessEdge__SuccessEdge);

			Fragments._SuccessNode__ConnectionEnd.initOperations(_SuccessNode__ConnectionEnd);
			Fragments._SuccessNode__Element.initOperations(_SuccessNode__Element);
			Fragments._SuccessNode__Node.initOperations(_SuccessNode__Node);
			Fragments._SuccessNode__OclAny.initOperations(_SuccessNode__OclAny);
			Fragments._SuccessNode__OclElement.initOperations(_SuccessNode__OclElement);
			Fragments._SuccessNode__SuccessNode.initOperations(_SuccessNode__SuccessNode);

			Fragments._Symbolable__OclAny.initOperations(_Symbolable__OclAny);
			Fragments._Symbolable__OclElement.initOperations(_Symbolable__OclElement);
			Fragments._Symbolable__Symbolable.initOperations(_Symbolable__Symbolable);

			Fragments._UnknownNode__ConnectionEnd.initOperations(_UnknownNode__ConnectionEnd);
			Fragments._UnknownNode__Element.initOperations(_UnknownNode__Element);
			Fragments._UnknownNode__Node.initOperations(_UnknownNode__Node);
			Fragments._UnknownNode__OclAny.initOperations(_UnknownNode__OclAny);
			Fragments._UnknownNode__OclElement.initOperations(_UnknownNode__OclElement);
			Fragments._UnknownNode__UnknownNode.initOperations(_UnknownNode__UnknownNode);

			Fragments._VariableNode__ConnectionEnd.initOperations(_VariableNode__ConnectionEnd);
			Fragments._VariableNode__Element.initOperations(_VariableNode__Element);
			Fragments._VariableNode__Node.initOperations(_VariableNode__Node);
			Fragments._VariableNode__OclAny.initOperations(_VariableNode__OclAny);
			Fragments._VariableNode__OclElement.initOperations(_VariableNode__OclElement);
			Fragments._VariableNode__VariableNode.initOperations(_VariableNode__VariableNode);

			Fragments._VerdictRegion__Element.initOperations(_VerdictRegion__Element);
			Fragments._VerdictRegion__MappingRegion.initOperations(_VerdictRegion__MappingRegion);
			Fragments._VerdictRegion__NamedElement.initOperations(_VerdictRegion__NamedElement);
			Fragments._VerdictRegion__OclAny.initOperations(_VerdictRegion__OclAny);
			Fragments._VerdictRegion__OclElement.initOperations(_VerdictRegion__OclElement);
			Fragments._VerdictRegion__Region.initOperations(_VerdictRegion__Region);
			Fragments._VerdictRegion__RuleRegion.initOperations(_VerdictRegion__RuleRegion);
			Fragments._VerdictRegion__Symbolable.initOperations(_VerdictRegion__Symbolable);
			Fragments._VerdictRegion__VerdictRegion.initOperations(_VerdictRegion__VerdictRegion);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTscheduleTables::FragmentOperations and all preceding sub-packages.
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

		private static final @NonNull ExecutorProperty @NonNull [] _AbstractDatum = {
			QVTscheduleTables.Properties._AbstractDatum__consumingRegions,
			QVTscheduleTables.Properties._AbstractDatum__producingRegions,
			QVTscheduleTables.Properties._AbstractDatum__referredTypedModel
		};

		private static final @NonNull ExecutorProperty @NonNull [] _BooleanValueNode = {
			QVTscheduleTables.Properties._BooleanValueNode__booleanValue,
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._OperationNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _CastEdge = {
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._NavigableEdge__incomingConnection,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._NavigableEdge__oppositeEdge,
			QVTscheduleTables.Properties._NavigableEdge__outgoingConnections,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._CastEdge__property,
			QVTscheduleTables.Properties._CastEdge__referredClass,
			QVTscheduleTables.Properties._NavigableEdge__secondary,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ClassDatum = {
			QVTscheduleTables.Properties._ClassDatum__completeClass,
			QVTscheduleTables.Properties._AbstractDatum__consumingRegions,
			QVTscheduleTables.Properties._ClassDatum__ownedPropertyDatums,
			QVTscheduleTables.Properties._ClassDatum__owningScheduleModel,
			QVTscheduleTables.Properties._AbstractDatum__producingRegions,
			QVTscheduleTables.Properties._ClassDatum__referredClass,
			QVTscheduleTables.Properties._AbstractDatum__referredTypedModel,
			QVTscheduleTables.Properties._ClassDatum__superClassDatums
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ComposedNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Connection = {
			QVTscheduleTables.Properties._Connection__owningScheduledRegion,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ConnectionEnd = {};

		private static final @NonNull ExecutorProperty @NonNull [] _ConnectionRole = {};

		private static final @NonNull ExecutorProperty @NonNull [] _DatumConnection = {
			QVTscheduleTables.Properties._DatumConnection__connectionRole,
			QVTscheduleTables.Properties._DatumConnection__name,
			QVTscheduleTables.Properties._Connection__owningScheduledRegion,
			QVTscheduleTables.Properties._DatumConnection__sourceEnds,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _DependencyNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _DispatchRegion = {
			QVTscheduleTables.Properties._RuleRegion__consumedDatums,
			QVTscheduleTables.Properties._MappingRegion__headNodes,
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._MappingRegion__owningScheduleModel,
			QVTscheduleTables.Properties._RuleRegion__producedDatums,
			QVTscheduleTables.Properties._RuleRegion__referredRule,
			QVTscheduleTables.Properties._DispatchRegion__referredRuleRegion,
			QVTscheduleTables.Properties._MappingRegion__scheduledRegion,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Edge = {
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _EdgeConnection = {
			QVTscheduleTables.Properties._DatumConnection__connectionRole,
			QVTscheduleTables.Properties._DatumConnection__name,
			QVTscheduleTables.Properties._Connection__owningScheduledRegion,
			QVTscheduleTables.Properties._EdgeConnection__referredProperty,
			QVTscheduleTables.Properties._DatumConnection__sourceEnds,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ErrorNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ExpressionEdge = {
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._ExpressionEdge__referredObject,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _InputNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _IteratedEdge = {
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _IteratorNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion,
			QVTscheduleTables.Properties._VariableNode__referredVariable
		};

		private static final @NonNull ExecutorProperty @NonNull [] _KeyedValueNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._KeyedValueNode__classDatumValue,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._OperationNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _LoadingRegion = {
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._LoadingRegion__owningScheduledRegion,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _MappingRegion = {
			QVTscheduleTables.Properties._MappingRegion__headNodes,
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._MappingRegion__owningScheduleModel,
			QVTscheduleTables.Properties._MappingRegion__scheduledRegion,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _MicroMappingRegion = {
			QVTscheduleTables.Properties._MappingRegion__headNodes,
			QVTscheduleTables.Properties._MicroMappingRegion__mappingRegion,
			QVTscheduleTables.Properties._MicroMappingRegion__namePrefix,
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._MappingRegion__owningScheduleModel,
			QVTscheduleTables.Properties._MappingRegion__scheduledRegion,
			QVTscheduleTables.Properties._Symbolable__symbolName,
			QVTscheduleTables.Properties._MicroMappingRegion__symbolNameSuffix
		};

		private static final @NonNull ExecutorProperty @NonNull [] _NamedMappingRegion = {
			QVTscheduleTables.Properties._MappingRegion__headNodes,
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._MappingRegion__owningScheduleModel,
			QVTscheduleTables.Properties._MappingRegion__scheduledRegion,
			QVTscheduleTables.Properties._Symbolable__symbolName,
			QVTscheduleTables.Properties._NamedMappingRegion__symbolNameSuffix
		};

		private static final @NonNull ExecutorProperty @NonNull [] _NavigableEdge = {
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._NavigableEdge__incomingConnection,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._NavigableEdge__oppositeEdge,
			QVTscheduleTables.Properties._NavigableEdge__outgoingConnections,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._NavigableEdge__secondary,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _NavigationEdge = {
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._NavigableEdge__incomingConnection,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._NavigableEdge__oppositeEdge,
			QVTscheduleTables.Properties._NavigableEdge__outgoingConnections,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._NavigationEdge__partial,
			QVTscheduleTables.Properties._NavigationEdge__referredProperty,
			QVTscheduleTables.Properties._NavigableEdge__secondary,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Node = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _NodeConnection = {
			QVTscheduleTables.Properties._NodeConnection__classDatum,
			QVTscheduleTables.Properties._DatumConnection__connectionRole,
			QVTscheduleTables.Properties._DatumConnection__name,
			QVTscheduleTables.Properties._Connection__owningScheduledRegion,
			QVTscheduleTables.Properties._DatumConnection__sourceEnds,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _NullNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._NullNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OperationNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._OperationNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OperationRegion = {
			QVTscheduleTables.Properties._OperationRegion__dependencyNodes,
			QVTscheduleTables.Properties._OperationRegion__headNodes,
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._OperationRegion__owningScheduleModel,
			QVTscheduleTables.Properties._OperationRegion__referredOperation,
			QVTscheduleTables.Properties._OperationRegion__resultNode,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OperationValueNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._OperationNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._OperationValueNode__operationValue,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _PatternTypedNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._PatternTypedNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _PatternVariableNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._PatternVariableNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion,
			QVTscheduleTables.Properties._VariableNode__referredVariable
		};

		private static final @NonNull ExecutorProperty @NonNull [] _PredicateEdge = {
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _PropertyDatum = {
			QVTscheduleTables.Properties._AbstractDatum__consumingRegions,
			QVTscheduleTables.Properties._PropertyDatum__key,
			QVTscheduleTables.Properties._PropertyDatum__opposite,
			QVTscheduleTables.Properties._PropertyDatum__owningClassDatum,
			QVTscheduleTables.Properties._AbstractDatum__producingRegions,
			QVTscheduleTables.Properties._PropertyDatum__referredProperty,
			QVTscheduleTables.Properties._AbstractDatum__referredTypedModel,
			QVTscheduleTables.Properties._PropertyDatum__superPropertyDatums
		};

		private static final @NonNull ExecutorProperty @NonNull [] _RecursionEdge = {
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._RecursionEdge__primary,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Region = {
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Role = {};

		private static final @NonNull ExecutorProperty @NonNull [] _RuleRegion = {
			QVTscheduleTables.Properties._RuleRegion__consumedDatums,
			QVTscheduleTables.Properties._MappingRegion__headNodes,
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._MappingRegion__owningScheduleModel,
			QVTscheduleTables.Properties._RuleRegion__producedDatums,
			QVTscheduleTables.Properties._RuleRegion__referredRule,
			QVTscheduleTables.Properties._MappingRegion__scheduledRegion,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ScheduleModel = {
			QVTscheduleTables.Properties._ScheduleModel__ownedClassDatums,
			QVTscheduleTables.Properties._ScheduleModel__ownedMappingRegions,
			QVTscheduleTables.Properties._ScheduleModel__ownedOperationRegions,
			QVTscheduleTables.Properties._ScheduleModel__ownedScheduledRegions
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ScheduledRegion = {
			QVTscheduleTables.Properties._ScheduledRegion__mappingRegions,
			QVTscheduleTables.Properties._ScheduledRegion__ownedConnections,
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._ScheduledRegion__ownedLoadingRegion,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._ScheduledRegion__owningScheduleModel,
			QVTscheduleTables.Properties._ScheduledRegion__referredTransformation,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _SuccessEdge = {
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._NavigableEdge__incomingConnection,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._NavigableEdge__oppositeEdge,
			QVTscheduleTables.Properties._NavigableEdge__outgoingConnections,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._NavigationEdge__partial,
			QVTscheduleTables.Properties._NavigationEdge__referredProperty,
			QVTscheduleTables.Properties._NavigableEdge__secondary,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _SuccessNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Symbolable = {
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _UnknownNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _VariableNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion,
			QVTscheduleTables.Properties._VariableNode__referredVariable
		};

		private static final @NonNull ExecutorProperty @NonNull [] _VerdictRegion = {
			QVTscheduleTables.Properties._RuleRegion__consumedDatums,
			QVTscheduleTables.Properties._MappingRegion__headNodes,
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._MappingRegion__owningScheduleModel,
			QVTscheduleTables.Properties._RuleRegion__producedDatums,
			QVTscheduleTables.Properties._RuleRegion__referredRule,
			QVTscheduleTables.Properties._VerdictRegion__referredRuleRegion,
			QVTscheduleTables.Properties._MappingRegion__scheduledRegion,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._AbstractDatum__AbstractDatum.initProperties(_AbstractDatum);
			Fragments._BooleanValueNode__BooleanValueNode.initProperties(_BooleanValueNode);
			Fragments._CastEdge__CastEdge.initProperties(_CastEdge);
			Fragments._ClassDatum__ClassDatum.initProperties(_ClassDatum);
			Fragments._ComposedNode__ComposedNode.initProperties(_ComposedNode);
			Fragments._Connection__Connection.initProperties(_Connection);
			Fragments._ConnectionEnd__ConnectionEnd.initProperties(_ConnectionEnd);
			Fragments._ConnectionRole__ConnectionRole.initProperties(_ConnectionRole);
			Fragments._DatumConnection__DatumConnection.initProperties(_DatumConnection);
			Fragments._DependencyNode__DependencyNode.initProperties(_DependencyNode);
			Fragments._DispatchRegion__DispatchRegion.initProperties(_DispatchRegion);
			Fragments._Edge__Edge.initProperties(_Edge);
			Fragments._EdgeConnection__EdgeConnection.initProperties(_EdgeConnection);
			Fragments._ErrorNode__ErrorNode.initProperties(_ErrorNode);
			Fragments._ExpressionEdge__ExpressionEdge.initProperties(_ExpressionEdge);
			Fragments._InputNode__InputNode.initProperties(_InputNode);
			Fragments._IteratedEdge__IteratedEdge.initProperties(_IteratedEdge);
			Fragments._IteratorNode__IteratorNode.initProperties(_IteratorNode);
			Fragments._KeyedValueNode__KeyedValueNode.initProperties(_KeyedValueNode);
			Fragments._LoadingRegion__LoadingRegion.initProperties(_LoadingRegion);
			Fragments._MappingRegion__MappingRegion.initProperties(_MappingRegion);
			Fragments._MicroMappingRegion__MicroMappingRegion.initProperties(_MicroMappingRegion);
			Fragments._NamedMappingRegion__NamedMappingRegion.initProperties(_NamedMappingRegion);
			Fragments._NavigableEdge__NavigableEdge.initProperties(_NavigableEdge);
			Fragments._NavigationEdge__NavigationEdge.initProperties(_NavigationEdge);
			Fragments._Node__Node.initProperties(_Node);
			Fragments._NodeConnection__NodeConnection.initProperties(_NodeConnection);
			Fragments._NullNode__NullNode.initProperties(_NullNode);
			Fragments._OperationNode__OperationNode.initProperties(_OperationNode);
			Fragments._OperationRegion__OperationRegion.initProperties(_OperationRegion);
			Fragments._OperationValueNode__OperationValueNode.initProperties(_OperationValueNode);
			Fragments._PatternTypedNode__PatternTypedNode.initProperties(_PatternTypedNode);
			Fragments._PatternVariableNode__PatternVariableNode.initProperties(_PatternVariableNode);
			Fragments._PredicateEdge__PredicateEdge.initProperties(_PredicateEdge);
			Fragments._PropertyDatum__PropertyDatum.initProperties(_PropertyDatum);
			Fragments._RecursionEdge__RecursionEdge.initProperties(_RecursionEdge);
			Fragments._Region__Region.initProperties(_Region);
			Fragments._Role__Role.initProperties(_Role);
			Fragments._RuleRegion__RuleRegion.initProperties(_RuleRegion);
			Fragments._ScheduleModel__ScheduleModel.initProperties(_ScheduleModel);
			Fragments._ScheduledRegion__ScheduledRegion.initProperties(_ScheduledRegion);
			Fragments._SuccessEdge__SuccessEdge.initProperties(_SuccessEdge);
			Fragments._SuccessNode__SuccessNode.initProperties(_SuccessNode);
			Fragments._Symbolable__Symbolable.initProperties(_Symbolable);
			Fragments._UnknownNode__UnknownNode.initProperties(_UnknownNode);
			Fragments._VariableNode__VariableNode.initProperties(_VariableNode);
			Fragments._VerdictRegion__VerdictRegion.initProperties(_VerdictRegion);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTscheduleTables::FragmentProperties and all preceding sub-packages.
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

		public static final @NonNull EcoreExecutorEnumerationLiteral _ConnectionRole__MANDATORY_EDGE = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.CONNECTION_ROLE.getEEnumLiteral("MANDATORY_EDGE"), Types._ConnectionRole, 0);
		public static final @NonNull EcoreExecutorEnumerationLiteral _ConnectionRole__MANDATORY_NODE = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.CONNECTION_ROLE.getEEnumLiteral("MANDATORY_NODE"), Types._ConnectionRole, 1);
		public static final @NonNull EcoreExecutorEnumerationLiteral _ConnectionRole__PASSED = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.CONNECTION_ROLE.getEEnumLiteral("PASSED"), Types._ConnectionRole, 2);
		public static final @NonNull EcoreExecutorEnumerationLiteral _ConnectionRole__PREFERRED_EDGE = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.CONNECTION_ROLE.getEEnumLiteral("PREFERRED_EDGE"), Types._ConnectionRole, 3);
		public static final @NonNull EcoreExecutorEnumerationLiteral _ConnectionRole__PREFERRED_NODE = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.CONNECTION_ROLE.getEEnumLiteral("PREFERRED_NODE"), Types._ConnectionRole, 4);
		public static final @NonNull EcoreExecutorEnumerationLiteral _ConnectionRole__UNDEFINED = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.CONNECTION_ROLE.getEEnumLiteral("UNDEFINED"), Types._ConnectionRole, 5);
		private static final @NonNull EcoreExecutorEnumerationLiteral @NonNull [] _ConnectionRole = {
			_ConnectionRole__MANDATORY_EDGE,
			_ConnectionRole__MANDATORY_NODE,
			_ConnectionRole__PASSED,
			_ConnectionRole__PREFERRED_EDGE,
			_ConnectionRole__PREFERRED_NODE,
			_ConnectionRole__UNDEFINED
		};

		public static final @NonNull EcoreExecutorEnumerationLiteral _Role__CONSTANT = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("CONSTANT"), Types._Role, 0);
		public static final @NonNull EcoreExecutorEnumerationLiteral _Role__LOADED = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("LOADED"), Types._Role, 1);
		public static final @NonNull EcoreExecutorEnumerationLiteral _Role__REALIZED = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("REALIZED"), Types._Role, 2);
		public static final @NonNull EcoreExecutorEnumerationLiteral _Role__PREDICATED = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("PREDICATED"), Types._Role, 3);
		public static final @NonNull EcoreExecutorEnumerationLiteral _Role__SPECULATION = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("SPECULATION"), Types._Role, 4);
		public static final @NonNull EcoreExecutorEnumerationLiteral _Role__SPECULATED = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("SPECULATED"), Types._Role, 5);
		public static final @NonNull EcoreExecutorEnumerationLiteral _Role__OTHER = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("OTHER"), Types._Role, 6);
		private static final @NonNull EcoreExecutorEnumerationLiteral @NonNull [] _Role = {
			_Role__CONSTANT,
			_Role__LOADED,
			_Role__REALIZED,
			_Role__PREDICATED,
			_Role__SPECULATION,
			_Role__SPECULATED,
			_Role__OTHER
		};

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {
			Types._ConnectionRole.initLiterals(_ConnectionRole);
			Types._Role.initLiterals(_Role);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTscheduleTables::EnumerationLiterals and all preceding sub-packages.
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
