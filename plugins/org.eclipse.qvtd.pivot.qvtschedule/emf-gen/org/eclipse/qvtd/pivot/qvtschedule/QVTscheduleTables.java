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
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, org.eclipse.emf.ecore.EcorePackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbase", null, org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2017/QVTschedule", null, org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_BasicPartition = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("BasicPartition", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ClassDatum = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("ClassDatum", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Cluster = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Cluster", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_CollectionLiteralPart = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getClassId("CollectionLiteralPart", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_CompleteClass = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getClassId("CompleteClass", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_CompositePartition = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("CompositePartition", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Connection = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Connection", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ConnectionEnd = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("ConnectionEnd", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_CyclicMappingRegion = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("CyclicMappingRegion", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_DispatchRegion = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("DispatchRegion", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Edge = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Edge", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_EdgeConnection = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("EdgeConnection", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_EnumerationLiteral = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getClassId("EnumerationLiteral", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_KeyPartEdge = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("KeyPartEdge", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_KeyedValueNode = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("KeyedValueNode", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_LoadingPartition = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("LoadingPartition", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_LoadingRegion = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("LoadingRegion", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_MapLiteralPart = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getClassId("MapLiteralPart", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_MappingPartition = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("MappingPartition", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_MappingRegion = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("MappingRegion", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_MicroMappingRegion = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("MicroMappingRegion", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_NavigableEdge = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("NavigableEdge", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Node = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Node", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_NodeConnection = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("NodeConnection", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Operation = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getClassId("Operation", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OperationRegion = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("OperationRegion", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Parameter = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getClassId("Parameter", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Partition = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Partition", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Property = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getClassId("Property", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PropertyDatum = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("PropertyDatum", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Region = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Region", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RootPartition = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("RootPartition", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Rule = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Rule", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RuleRegion = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("RuleRegion", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ScheduleModel = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("ScheduleModel", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ScheduledRegion = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("ScheduledRegion", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ShadowPart = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getClassId("ShadowPart", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Transformation = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Transformation", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TupleLiteralPart = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getClassId("TupleLiteralPart", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Type = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getClassId("Type", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TypedModel = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("TypedModel", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_VariableDeclaration = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getClassId("VariableDeclaration", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_VerdictRegion = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("VerdictRegion", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull DataTypeId DATAid_EInt = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EInt", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull DataTypeId DATAid_EIntegerObject = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EIntegerObject", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull DataTypeId DATAid_Number = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getDataTypeId("Number", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull EnumerationId ENUMid_ConnectionRole = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getEnumerationId("ConnectionRole");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull EnumerationId ENUMid_Role = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getEnumerationId("Role");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_BasicPartition = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_BasicPartition);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_ClassDatum = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_ClassDatum);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_Connection = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_Connection);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_CyclicMappingRegion = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_CyclicMappingRegion);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_DispatchRegion = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_DispatchRegion);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_EdgeConnection = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_EdgeConnection);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_KeyPartEdge = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_KeyPartEdge);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_KeyedValueNode = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_KeyedValueNode);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_MappingPartition = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_MappingPartition);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_MappingRegion = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_MappingRegion);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_MicroMappingRegion = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_MicroMappingRegion);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_NavigableEdge = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_NavigableEdge);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_Node = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_Node);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_NodeConnection = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_NodeConnection);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_OperationRegion = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_OperationRegion);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_Partition = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_Partition);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_PropertyDatum = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_PropertyDatum);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_RootPartition = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_RootPartition);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_VerdictRegion = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_VerdictRegion);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_ClassDatum = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_ClassDatum);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Cluster = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_Cluster);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Connection = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_Connection);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Edge = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_Edge);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_EdgeConnection = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_EdgeConnection);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_MappingPartition = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_MappingPartition);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_MappingRegion = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_MappingRegion);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Node = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_Node);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_NodeConnection = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_NodeConnection);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_OperationRegion = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_OperationRegion);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_PropertyDatum = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_PropertyDatum);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Region = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_Region);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_ScheduledRegion = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_ScheduledRegion);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_DATAid_EInt = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.DATAid_EInt);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_ConnectionEnd = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_ConnectionEnd);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Edge = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_Edge);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_MappingPartition = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_MappingPartition);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_NavigableEdge = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_NavigableEdge);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Node = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_Node);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_NodeConnection = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_NodeConnection);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Partition = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_Partition);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			QVTscheduleTables.init();
		}

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
		public static final @NonNull EcoreExecutorType _ArgumentEdge = new EcoreExecutorType(QVTschedulePackage.Literals.ARGUMENT_EDGE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _BasicPartition = new EcoreExecutorType(QVTschedulePackage.Literals.BASIC_PARTITION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _BooleanLiteralNode = new EcoreExecutorType(QVTschedulePackage.Literals.BOOLEAN_LITERAL_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CastEdge = new EcoreExecutorType(QVTschedulePackage.Literals.CAST_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ClassDatum = new EcoreExecutorType(QVTschedulePackage.Literals.CLASS_DATUM, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Cluster = new EcoreExecutorType(QVTschedulePackage.Literals.CLUSTER, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CollectionLiteralNode = new EcoreExecutorType(QVTschedulePackage.Literals.COLLECTION_LITERAL_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CollectionPartEdge = new EcoreExecutorType(QVTschedulePackage.Literals.COLLECTION_PART_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CollectionRangeNode = new EcoreExecutorType(QVTschedulePackage.Literals.COLLECTION_RANGE_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ComposedNode = new EcoreExecutorType(QVTschedulePackage.Literals.COMPOSED_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CompositePartition = new EcoreExecutorType(QVTschedulePackage.Literals.COMPOSITE_PARTITION, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _Connection = new EcoreExecutorType(QVTschedulePackage.Literals.CONNECTION, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _ConnectionEnd = new EcoreExecutorType(QVTschedulePackage.Literals.CONNECTION_END, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorEnumeration _ConnectionRole = new EcoreExecutorEnumeration(QVTschedulePackage.Literals.CONNECTION_ROLE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CyclicMappingRegion = new EcoreExecutorType(QVTschedulePackage.Literals.CYCLIC_MAPPING_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CyclicPartition = new EcoreExecutorType(QVTschedulePackage.Literals.CYCLIC_PARTITION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _DependencyEdge = new EcoreExecutorType(QVTschedulePackage.Literals.DEPENDENCY_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _DependencyNode = new EcoreExecutorType(QVTschedulePackage.Literals.DEPENDENCY_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _DispatchRegion = new EcoreExecutorType(QVTschedulePackage.Literals.DISPATCH_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Edge = new EcoreExecutorType(QVTschedulePackage.Literals.EDGE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _EdgeConnection = new EcoreExecutorType(QVTschedulePackage.Literals.EDGE_CONNECTION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _EnumLiteralNode = new EcoreExecutorType(QVTschedulePackage.Literals.ENUM_LITERAL_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ErrorNode = new EcoreExecutorType(QVTschedulePackage.Literals.ERROR_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ExpressionEdge = new EcoreExecutorType(QVTschedulePackage.Literals.EXPRESSION_EDGE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _IfNode = new EcoreExecutorType(QVTschedulePackage.Literals.IF_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _IncludesEdge = new EcoreExecutorType(QVTschedulePackage.Literals.INCLUDES_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _InputNode = new EcoreExecutorType(QVTschedulePackage.Literals.INPUT_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _IteratedEdge = new EcoreExecutorType(QVTschedulePackage.Literals.ITERATED_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _IteratorNode = new EcoreExecutorType(QVTschedulePackage.Literals.ITERATOR_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _KeyPartEdge = new EcoreExecutorType(QVTschedulePackage.Literals.KEY_PART_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _KeyedValueNode = new EcoreExecutorType(QVTschedulePackage.Literals.KEYED_VALUE_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _LoadingPartition = new EcoreExecutorType(QVTschedulePackage.Literals.LOADING_PARTITION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _LoadingRegion = new EcoreExecutorType(QVTschedulePackage.Literals.LOADING_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _MapLiteralNode = new EcoreExecutorType(QVTschedulePackage.Literals.MAP_LITERAL_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _MapPartEdge = new EcoreExecutorType(QVTschedulePackage.Literals.MAP_PART_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _MapPartNode = new EcoreExecutorType(QVTschedulePackage.Literals.MAP_PART_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _MappingNode = new EcoreExecutorType(QVTschedulePackage.Literals.MAPPING_NODE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _MappingPartition = new EcoreExecutorType(QVTschedulePackage.Literals.MAPPING_PARTITION, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _MappingRegion = new EcoreExecutorType(QVTschedulePackage.Literals.MAPPING_REGION, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _MicroMappingRegion = new EcoreExecutorType(QVTschedulePackage.Literals.MICRO_MAPPING_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _NamedMappingRegion = new EcoreExecutorType(QVTschedulePackage.Literals.NAMED_MAPPING_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _NavigableEdge = new EcoreExecutorType(QVTschedulePackage.Literals.NAVIGABLE_EDGE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _NavigationEdge = new EcoreExecutorType(QVTschedulePackage.Literals.NAVIGATION_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Node = new EcoreExecutorType(QVTschedulePackage.Literals.NODE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _NodeConnection = new EcoreExecutorType(QVTschedulePackage.Literals.NODE_CONNECTION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _NonPartition = new EcoreExecutorType(QVTschedulePackage.Literals.NON_PARTITION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _NullLiteralNode = new EcoreExecutorType(QVTschedulePackage.Literals.NULL_LITERAL_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Number = new EcoreExecutorType("Number", PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _NumericLiteralNode = new EcoreExecutorType(QVTschedulePackage.Literals.NUMERIC_LITERAL_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OperationCallNode = new EcoreExecutorType(QVTschedulePackage.Literals.OPERATION_CALL_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OperationNode = new EcoreExecutorType(QVTschedulePackage.Literals.OPERATION_NODE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _OperationParameterEdge = new EcoreExecutorType(QVTschedulePackage.Literals.OPERATION_PARAMETER_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OperationRegion = new EcoreExecutorType(QVTschedulePackage.Literals.OPERATION_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OperationSelfEdge = new EcoreExecutorType(QVTschedulePackage.Literals.OPERATION_SELF_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Partition = new EcoreExecutorType(QVTschedulePackage.Literals.PARTITION, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _PatternTypedNode = new EcoreExecutorType(QVTschedulePackage.Literals.PATTERN_TYPED_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _PatternVariableNode = new EcoreExecutorType(QVTschedulePackage.Literals.PATTERN_VARIABLE_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _PredicateEdge = new EcoreExecutorType(QVTschedulePackage.Literals.PREDICATE_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _PropertyDatum = new EcoreExecutorType(QVTschedulePackage.Literals.PROPERTY_DATUM, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _RecursionEdge = new EcoreExecutorType(QVTschedulePackage.Literals.RECURSION_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Region = new EcoreExecutorType(QVTschedulePackage.Literals.REGION, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorEnumeration _Role = new EcoreExecutorEnumeration(QVTschedulePackage.Literals.ROLE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _RootPartition = new EcoreExecutorType(QVTschedulePackage.Literals.ROOT_PARTITION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _RuleRegion = new EcoreExecutorType(QVTschedulePackage.Literals.RULE_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ScheduleModel = new EcoreExecutorType(QVTschedulePackage.Literals.SCHEDULE_MODEL, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ScheduledRegion = new EcoreExecutorType(QVTschedulePackage.Literals.SCHEDULED_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ShadowNode = new EcoreExecutorType(QVTschedulePackage.Literals.SHADOW_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ShadowPartEdge = new EcoreExecutorType(QVTschedulePackage.Literals.SHADOW_PART_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _StringLiteralNode = new EcoreExecutorType(QVTschedulePackage.Literals.STRING_LITERAL_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _SuccessEdge = new EcoreExecutorType(QVTschedulePackage.Literals.SUCCESS_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _SuccessNode = new EcoreExecutorType(QVTschedulePackage.Literals.SUCCESS_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Symbolable = new EcoreExecutorType(QVTschedulePackage.Literals.SYMBOLABLE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _TupleLiteralNode = new EcoreExecutorType(QVTschedulePackage.Literals.TUPLE_LITERAL_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TuplePartEdge = new EcoreExecutorType(QVTschedulePackage.Literals.TUPLE_PART_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TypeLiteralNode = new EcoreExecutorType(QVTschedulePackage.Literals.TYPE_LITERAL_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _UnknownNode = new EcoreExecutorType(QVTschedulePackage.Literals.UNKNOWN_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _VariableNode = new EcoreExecutorType(QVTschedulePackage.Literals.VARIABLE_NODE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _VerdictRegion = new EcoreExecutorType(QVTschedulePackage.Literals.VERDICT_REGION, PACKAGE, 0);

		private static final @NonNull EcoreExecutorType @NonNull [] types = {
			_AbstractDatum,
			_ArgumentEdge,
			_BasicPartition,
			_BooleanLiteralNode,
			_CastEdge,
			_ClassDatum,
			_Cluster,
			_CollectionLiteralNode,
			_CollectionPartEdge,
			_CollectionRangeNode,
			_ComposedNode,
			_CompositePartition,
			_Connection,
			_ConnectionEnd,
			_ConnectionRole,
			_CyclicMappingRegion,
			_CyclicPartition,
			_DependencyEdge,
			_DependencyNode,
			_DispatchRegion,
			_Edge,
			_EdgeConnection,
			_EnumLiteralNode,
			_ErrorNode,
			_ExpressionEdge,
			_IfNode,
			_IncludesEdge,
			_InputNode,
			_IteratedEdge,
			_IteratorNode,
			_KeyPartEdge,
			_KeyedValueNode,
			_LoadingPartition,
			_LoadingRegion,
			_MapLiteralNode,
			_MapPartEdge,
			_MapPartNode,
			_MappingNode,
			_MappingPartition,
			_MappingRegion,
			_MicroMappingRegion,
			_NamedMappingRegion,
			_NavigableEdge,
			_NavigationEdge,
			_Node,
			_NodeConnection,
			_NonPartition,
			_NullLiteralNode,
			_Number,
			_NumericLiteralNode,
			_OperationCallNode,
			_OperationNode,
			_OperationParameterEdge,
			_OperationRegion,
			_OperationSelfEdge,
			_Partition,
			_PatternTypedNode,
			_PatternVariableNode,
			_PredicateEdge,
			_PropertyDatum,
			_RecursionEdge,
			_Region,
			_Role,
			_RootPartition,
			_RuleRegion,
			_ScheduleModel,
			_ScheduledRegion,
			_ShadowNode,
			_ShadowPartEdge,
			_StringLiteralNode,
			_SuccessEdge,
			_SuccessNode,
			_Symbolable,
			_TupleLiteralNode,
			_TuplePartEdge,
			_TypeLiteralNode,
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

		private static final @NonNull ExecutorFragment _ArgumentEdge__ArgumentEdge = new ExecutorFragment(Types._ArgumentEdge, QVTscheduleTables.Types._ArgumentEdge);
		private static final @NonNull ExecutorFragment _ArgumentEdge__Edge = new ExecutorFragment(Types._ArgumentEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _ArgumentEdge__Element = new ExecutorFragment(Types._ArgumentEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ArgumentEdge__ExpressionEdge = new ExecutorFragment(Types._ArgumentEdge, QVTscheduleTables.Types._ExpressionEdge);
		private static final @NonNull ExecutorFragment _ArgumentEdge__OclAny = new ExecutorFragment(Types._ArgumentEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ArgumentEdge__OclElement = new ExecutorFragment(Types._ArgumentEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _BasicPartition__BasicPartition = new ExecutorFragment(Types._BasicPartition, QVTscheduleTables.Types._BasicPartition);
		private static final @NonNull ExecutorFragment _BasicPartition__Element = new ExecutorFragment(Types._BasicPartition, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _BasicPartition__MappingPartition = new ExecutorFragment(Types._BasicPartition, QVTscheduleTables.Types._MappingPartition);
		private static final @NonNull ExecutorFragment _BasicPartition__NamedElement = new ExecutorFragment(Types._BasicPartition, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _BasicPartition__OclAny = new ExecutorFragment(Types._BasicPartition, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _BasicPartition__OclElement = new ExecutorFragment(Types._BasicPartition, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _BasicPartition__Partition = new ExecutorFragment(Types._BasicPartition, QVTscheduleTables.Types._Partition);

		private static final @NonNull ExecutorFragment _BooleanLiteralNode__BooleanLiteralNode = new ExecutorFragment(Types._BooleanLiteralNode, QVTscheduleTables.Types._BooleanLiteralNode);
		private static final @NonNull ExecutorFragment _BooleanLiteralNode__ConnectionEnd = new ExecutorFragment(Types._BooleanLiteralNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _BooleanLiteralNode__Element = new ExecutorFragment(Types._BooleanLiteralNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _BooleanLiteralNode__MappingNode = new ExecutorFragment(Types._BooleanLiteralNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _BooleanLiteralNode__Node = new ExecutorFragment(Types._BooleanLiteralNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _BooleanLiteralNode__OclAny = new ExecutorFragment(Types._BooleanLiteralNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _BooleanLiteralNode__OclElement = new ExecutorFragment(Types._BooleanLiteralNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _BooleanLiteralNode__OperationNode = new ExecutorFragment(Types._BooleanLiteralNode, QVTscheduleTables.Types._OperationNode);

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

		private static final @NonNull ExecutorFragment _Cluster__Cluster = new ExecutorFragment(Types._Cluster, QVTscheduleTables.Types._Cluster);
		private static final @NonNull ExecutorFragment _Cluster__Element = new ExecutorFragment(Types._Cluster, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Cluster__NamedElement = new ExecutorFragment(Types._Cluster, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Cluster__OclAny = new ExecutorFragment(Types._Cluster, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Cluster__OclElement = new ExecutorFragment(Types._Cluster, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Cluster__Symbolable = new ExecutorFragment(Types._Cluster, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _CollectionLiteralNode__CollectionLiteralNode = new ExecutorFragment(Types._CollectionLiteralNode, QVTscheduleTables.Types._CollectionLiteralNode);
		private static final @NonNull ExecutorFragment _CollectionLiteralNode__ConnectionEnd = new ExecutorFragment(Types._CollectionLiteralNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _CollectionLiteralNode__Element = new ExecutorFragment(Types._CollectionLiteralNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _CollectionLiteralNode__MappingNode = new ExecutorFragment(Types._CollectionLiteralNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _CollectionLiteralNode__Node = new ExecutorFragment(Types._CollectionLiteralNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _CollectionLiteralNode__OclAny = new ExecutorFragment(Types._CollectionLiteralNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _CollectionLiteralNode__OclElement = new ExecutorFragment(Types._CollectionLiteralNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _CollectionLiteralNode__OperationNode = new ExecutorFragment(Types._CollectionLiteralNode, QVTscheduleTables.Types._OperationNode);

		private static final @NonNull ExecutorFragment _CollectionPartEdge__ArgumentEdge = new ExecutorFragment(Types._CollectionPartEdge, QVTscheduleTables.Types._ArgumentEdge);
		private static final @NonNull ExecutorFragment _CollectionPartEdge__CollectionPartEdge = new ExecutorFragment(Types._CollectionPartEdge, QVTscheduleTables.Types._CollectionPartEdge);
		private static final @NonNull ExecutorFragment _CollectionPartEdge__Edge = new ExecutorFragment(Types._CollectionPartEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _CollectionPartEdge__Element = new ExecutorFragment(Types._CollectionPartEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _CollectionPartEdge__ExpressionEdge = new ExecutorFragment(Types._CollectionPartEdge, QVTscheduleTables.Types._ExpressionEdge);
		private static final @NonNull ExecutorFragment _CollectionPartEdge__OclAny = new ExecutorFragment(Types._CollectionPartEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _CollectionPartEdge__OclElement = new ExecutorFragment(Types._CollectionPartEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _CollectionRangeNode__CollectionRangeNode = new ExecutorFragment(Types._CollectionRangeNode, QVTscheduleTables.Types._CollectionRangeNode);
		private static final @NonNull ExecutorFragment _CollectionRangeNode__ConnectionEnd = new ExecutorFragment(Types._CollectionRangeNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _CollectionRangeNode__Element = new ExecutorFragment(Types._CollectionRangeNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _CollectionRangeNode__MappingNode = new ExecutorFragment(Types._CollectionRangeNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _CollectionRangeNode__Node = new ExecutorFragment(Types._CollectionRangeNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _CollectionRangeNode__OclAny = new ExecutorFragment(Types._CollectionRangeNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _CollectionRangeNode__OclElement = new ExecutorFragment(Types._CollectionRangeNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _CollectionRangeNode__OperationNode = new ExecutorFragment(Types._CollectionRangeNode, QVTscheduleTables.Types._OperationNode);

		private static final @NonNull ExecutorFragment _ComposedNode__ComposedNode = new ExecutorFragment(Types._ComposedNode, QVTscheduleTables.Types._ComposedNode);
		private static final @NonNull ExecutorFragment _ComposedNode__ConnectionEnd = new ExecutorFragment(Types._ComposedNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _ComposedNode__Element = new ExecutorFragment(Types._ComposedNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ComposedNode__Node = new ExecutorFragment(Types._ComposedNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _ComposedNode__OclAny = new ExecutorFragment(Types._ComposedNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ComposedNode__OclElement = new ExecutorFragment(Types._ComposedNode, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _CompositePartition__CompositePartition = new ExecutorFragment(Types._CompositePartition, QVTscheduleTables.Types._CompositePartition);
		private static final @NonNull ExecutorFragment _CompositePartition__Element = new ExecutorFragment(Types._CompositePartition, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _CompositePartition__NamedElement = new ExecutorFragment(Types._CompositePartition, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _CompositePartition__OclAny = new ExecutorFragment(Types._CompositePartition, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _CompositePartition__OclElement = new ExecutorFragment(Types._CompositePartition, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _CompositePartition__Partition = new ExecutorFragment(Types._CompositePartition, QVTscheduleTables.Types._Partition);

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

		private static final @NonNull ExecutorFragment _CyclicMappingRegion__CyclicMappingRegion = new ExecutorFragment(Types._CyclicMappingRegion, QVTscheduleTables.Types._CyclicMappingRegion);
		private static final @NonNull ExecutorFragment _CyclicMappingRegion__Element = new ExecutorFragment(Types._CyclicMappingRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _CyclicMappingRegion__MappingRegion = new ExecutorFragment(Types._CyclicMappingRegion, QVTscheduleTables.Types._MappingRegion);
		private static final @NonNull ExecutorFragment _CyclicMappingRegion__NamedElement = new ExecutorFragment(Types._CyclicMappingRegion, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _CyclicMappingRegion__OclAny = new ExecutorFragment(Types._CyclicMappingRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _CyclicMappingRegion__OclElement = new ExecutorFragment(Types._CyclicMappingRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _CyclicMappingRegion__Region = new ExecutorFragment(Types._CyclicMappingRegion, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _CyclicMappingRegion__Symbolable = new ExecutorFragment(Types._CyclicMappingRegion, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _CyclicPartition__CompositePartition = new ExecutorFragment(Types._CyclicPartition, QVTscheduleTables.Types._CompositePartition);
		private static final @NonNull ExecutorFragment _CyclicPartition__CyclicPartition = new ExecutorFragment(Types._CyclicPartition, QVTscheduleTables.Types._CyclicPartition);
		private static final @NonNull ExecutorFragment _CyclicPartition__Element = new ExecutorFragment(Types._CyclicPartition, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _CyclicPartition__MappingPartition = new ExecutorFragment(Types._CyclicPartition, QVTscheduleTables.Types._MappingPartition);
		private static final @NonNull ExecutorFragment _CyclicPartition__NamedElement = new ExecutorFragment(Types._CyclicPartition, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _CyclicPartition__OclAny = new ExecutorFragment(Types._CyclicPartition, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _CyclicPartition__OclElement = new ExecutorFragment(Types._CyclicPartition, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _CyclicPartition__Partition = new ExecutorFragment(Types._CyclicPartition, QVTscheduleTables.Types._Partition);

		private static final @NonNull ExecutorFragment _DependencyEdge__DependencyEdge = new ExecutorFragment(Types._DependencyEdge, QVTscheduleTables.Types._DependencyEdge);
		private static final @NonNull ExecutorFragment _DependencyEdge__Edge = new ExecutorFragment(Types._DependencyEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _DependencyEdge__Element = new ExecutorFragment(Types._DependencyEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _DependencyEdge__OclAny = new ExecutorFragment(Types._DependencyEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _DependencyEdge__OclElement = new ExecutorFragment(Types._DependencyEdge, OCLstdlibTables.Types._OclElement);

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
		private static final @NonNull ExecutorFragment _EdgeConnection__EdgeConnection = new ExecutorFragment(Types._EdgeConnection, QVTscheduleTables.Types._EdgeConnection);
		private static final @NonNull ExecutorFragment _EdgeConnection__Element = new ExecutorFragment(Types._EdgeConnection, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _EdgeConnection__OclAny = new ExecutorFragment(Types._EdgeConnection, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _EdgeConnection__OclElement = new ExecutorFragment(Types._EdgeConnection, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _EdgeConnection__Symbolable = new ExecutorFragment(Types._EdgeConnection, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _EnumLiteralNode__ConnectionEnd = new ExecutorFragment(Types._EnumLiteralNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _EnumLiteralNode__Element = new ExecutorFragment(Types._EnumLiteralNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _EnumLiteralNode__EnumLiteralNode = new ExecutorFragment(Types._EnumLiteralNode, QVTscheduleTables.Types._EnumLiteralNode);
		private static final @NonNull ExecutorFragment _EnumLiteralNode__MappingNode = new ExecutorFragment(Types._EnumLiteralNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _EnumLiteralNode__Node = new ExecutorFragment(Types._EnumLiteralNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _EnumLiteralNode__OclAny = new ExecutorFragment(Types._EnumLiteralNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _EnumLiteralNode__OclElement = new ExecutorFragment(Types._EnumLiteralNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _EnumLiteralNode__OperationNode = new ExecutorFragment(Types._EnumLiteralNode, QVTscheduleTables.Types._OperationNode);

		private static final @NonNull ExecutorFragment _ErrorNode__ConnectionEnd = new ExecutorFragment(Types._ErrorNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _ErrorNode__Element = new ExecutorFragment(Types._ErrorNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ErrorNode__ErrorNode = new ExecutorFragment(Types._ErrorNode, QVTscheduleTables.Types._ErrorNode);
		private static final @NonNull ExecutorFragment _ErrorNode__MappingNode = new ExecutorFragment(Types._ErrorNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _ErrorNode__Node = new ExecutorFragment(Types._ErrorNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _ErrorNode__OclAny = new ExecutorFragment(Types._ErrorNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ErrorNode__OclElement = new ExecutorFragment(Types._ErrorNode, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _ExpressionEdge__Edge = new ExecutorFragment(Types._ExpressionEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _ExpressionEdge__Element = new ExecutorFragment(Types._ExpressionEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ExpressionEdge__ExpressionEdge = new ExecutorFragment(Types._ExpressionEdge, QVTscheduleTables.Types._ExpressionEdge);
		private static final @NonNull ExecutorFragment _ExpressionEdge__OclAny = new ExecutorFragment(Types._ExpressionEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ExpressionEdge__OclElement = new ExecutorFragment(Types._ExpressionEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _IfNode__ConnectionEnd = new ExecutorFragment(Types._IfNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _IfNode__Element = new ExecutorFragment(Types._IfNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _IfNode__IfNode = new ExecutorFragment(Types._IfNode, QVTscheduleTables.Types._IfNode);
		private static final @NonNull ExecutorFragment _IfNode__MappingNode = new ExecutorFragment(Types._IfNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _IfNode__Node = new ExecutorFragment(Types._IfNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _IfNode__OclAny = new ExecutorFragment(Types._IfNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _IfNode__OclElement = new ExecutorFragment(Types._IfNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _IfNode__OperationNode = new ExecutorFragment(Types._IfNode, QVTscheduleTables.Types._OperationNode);

		private static final @NonNull ExecutorFragment _IncludesEdge__Edge = new ExecutorFragment(Types._IncludesEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _IncludesEdge__Element = new ExecutorFragment(Types._IncludesEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _IncludesEdge__ExpressionEdge = new ExecutorFragment(Types._IncludesEdge, QVTscheduleTables.Types._ExpressionEdge);
		private static final @NonNull ExecutorFragment _IncludesEdge__IncludesEdge = new ExecutorFragment(Types._IncludesEdge, QVTscheduleTables.Types._IncludesEdge);
		private static final @NonNull ExecutorFragment _IncludesEdge__OclAny = new ExecutorFragment(Types._IncludesEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _IncludesEdge__OclElement = new ExecutorFragment(Types._IncludesEdge, OCLstdlibTables.Types._OclElement);

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
		private static final @NonNull ExecutorFragment _IteratorNode__MappingNode = new ExecutorFragment(Types._IteratorNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _IteratorNode__Node = new ExecutorFragment(Types._IteratorNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _IteratorNode__OclAny = new ExecutorFragment(Types._IteratorNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _IteratorNode__OclElement = new ExecutorFragment(Types._IteratorNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _IteratorNode__VariableNode = new ExecutorFragment(Types._IteratorNode, QVTscheduleTables.Types._VariableNode);

		private static final @NonNull ExecutorFragment _KeyPartEdge__ArgumentEdge = new ExecutorFragment(Types._KeyPartEdge, QVTscheduleTables.Types._ArgumentEdge);
		private static final @NonNull ExecutorFragment _KeyPartEdge__Edge = new ExecutorFragment(Types._KeyPartEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _KeyPartEdge__Element = new ExecutorFragment(Types._KeyPartEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _KeyPartEdge__ExpressionEdge = new ExecutorFragment(Types._KeyPartEdge, QVTscheduleTables.Types._ExpressionEdge);
		private static final @NonNull ExecutorFragment _KeyPartEdge__KeyPartEdge = new ExecutorFragment(Types._KeyPartEdge, QVTscheduleTables.Types._KeyPartEdge);
		private static final @NonNull ExecutorFragment _KeyPartEdge__OclAny = new ExecutorFragment(Types._KeyPartEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _KeyPartEdge__OclElement = new ExecutorFragment(Types._KeyPartEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _KeyedValueNode__ConnectionEnd = new ExecutorFragment(Types._KeyedValueNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _KeyedValueNode__Element = new ExecutorFragment(Types._KeyedValueNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _KeyedValueNode__KeyedValueNode = new ExecutorFragment(Types._KeyedValueNode, QVTscheduleTables.Types._KeyedValueNode);
		private static final @NonNull ExecutorFragment _KeyedValueNode__MappingNode = new ExecutorFragment(Types._KeyedValueNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _KeyedValueNode__Node = new ExecutorFragment(Types._KeyedValueNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _KeyedValueNode__OclAny = new ExecutorFragment(Types._KeyedValueNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _KeyedValueNode__OclElement = new ExecutorFragment(Types._KeyedValueNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _KeyedValueNode__OperationNode = new ExecutorFragment(Types._KeyedValueNode, QVTscheduleTables.Types._OperationNode);

		private static final @NonNull ExecutorFragment _LoadingPartition__Element = new ExecutorFragment(Types._LoadingPartition, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _LoadingPartition__LoadingPartition = new ExecutorFragment(Types._LoadingPartition, QVTscheduleTables.Types._LoadingPartition);
		private static final @NonNull ExecutorFragment _LoadingPartition__MappingPartition = new ExecutorFragment(Types._LoadingPartition, QVTscheduleTables.Types._MappingPartition);
		private static final @NonNull ExecutorFragment _LoadingPartition__NamedElement = new ExecutorFragment(Types._LoadingPartition, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _LoadingPartition__OclAny = new ExecutorFragment(Types._LoadingPartition, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _LoadingPartition__OclElement = new ExecutorFragment(Types._LoadingPartition, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _LoadingPartition__Partition = new ExecutorFragment(Types._LoadingPartition, QVTscheduleTables.Types._Partition);

		private static final @NonNull ExecutorFragment _LoadingRegion__Element = new ExecutorFragment(Types._LoadingRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _LoadingRegion__LoadingRegion = new ExecutorFragment(Types._LoadingRegion, QVTscheduleTables.Types._LoadingRegion);
		private static final @NonNull ExecutorFragment _LoadingRegion__NamedElement = new ExecutorFragment(Types._LoadingRegion, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _LoadingRegion__OclAny = new ExecutorFragment(Types._LoadingRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _LoadingRegion__OclElement = new ExecutorFragment(Types._LoadingRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _LoadingRegion__Region = new ExecutorFragment(Types._LoadingRegion, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _LoadingRegion__Symbolable = new ExecutorFragment(Types._LoadingRegion, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _MapLiteralNode__ConnectionEnd = new ExecutorFragment(Types._MapLiteralNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _MapLiteralNode__Element = new ExecutorFragment(Types._MapLiteralNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _MapLiteralNode__MapLiteralNode = new ExecutorFragment(Types._MapLiteralNode, QVTscheduleTables.Types._MapLiteralNode);
		private static final @NonNull ExecutorFragment _MapLiteralNode__MappingNode = new ExecutorFragment(Types._MapLiteralNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _MapLiteralNode__Node = new ExecutorFragment(Types._MapLiteralNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _MapLiteralNode__OclAny = new ExecutorFragment(Types._MapLiteralNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _MapLiteralNode__OclElement = new ExecutorFragment(Types._MapLiteralNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _MapLiteralNode__OperationNode = new ExecutorFragment(Types._MapLiteralNode, QVTscheduleTables.Types._OperationNode);

		private static final @NonNull ExecutorFragment _MapPartEdge__ArgumentEdge = new ExecutorFragment(Types._MapPartEdge, QVTscheduleTables.Types._ArgumentEdge);
		private static final @NonNull ExecutorFragment _MapPartEdge__Edge = new ExecutorFragment(Types._MapPartEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _MapPartEdge__Element = new ExecutorFragment(Types._MapPartEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _MapPartEdge__ExpressionEdge = new ExecutorFragment(Types._MapPartEdge, QVTscheduleTables.Types._ExpressionEdge);
		private static final @NonNull ExecutorFragment _MapPartEdge__MapPartEdge = new ExecutorFragment(Types._MapPartEdge, QVTscheduleTables.Types._MapPartEdge);
		private static final @NonNull ExecutorFragment _MapPartEdge__OclAny = new ExecutorFragment(Types._MapPartEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _MapPartEdge__OclElement = new ExecutorFragment(Types._MapPartEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _MapPartNode__ConnectionEnd = new ExecutorFragment(Types._MapPartNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _MapPartNode__Element = new ExecutorFragment(Types._MapPartNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _MapPartNode__MapPartNode = new ExecutorFragment(Types._MapPartNode, QVTscheduleTables.Types._MapPartNode);
		private static final @NonNull ExecutorFragment _MapPartNode__MappingNode = new ExecutorFragment(Types._MapPartNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _MapPartNode__Node = new ExecutorFragment(Types._MapPartNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _MapPartNode__OclAny = new ExecutorFragment(Types._MapPartNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _MapPartNode__OclElement = new ExecutorFragment(Types._MapPartNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _MapPartNode__OperationNode = new ExecutorFragment(Types._MapPartNode, QVTscheduleTables.Types._OperationNode);

		private static final @NonNull ExecutorFragment _MappingNode__ConnectionEnd = new ExecutorFragment(Types._MappingNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _MappingNode__Element = new ExecutorFragment(Types._MappingNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _MappingNode__MappingNode = new ExecutorFragment(Types._MappingNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _MappingNode__Node = new ExecutorFragment(Types._MappingNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _MappingNode__OclAny = new ExecutorFragment(Types._MappingNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _MappingNode__OclElement = new ExecutorFragment(Types._MappingNode, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _MappingPartition__Element = new ExecutorFragment(Types._MappingPartition, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _MappingPartition__MappingPartition = new ExecutorFragment(Types._MappingPartition, QVTscheduleTables.Types._MappingPartition);
		private static final @NonNull ExecutorFragment _MappingPartition__NamedElement = new ExecutorFragment(Types._MappingPartition, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _MappingPartition__OclAny = new ExecutorFragment(Types._MappingPartition, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _MappingPartition__OclElement = new ExecutorFragment(Types._MappingPartition, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _MappingPartition__Partition = new ExecutorFragment(Types._MappingPartition, QVTscheduleTables.Types._Partition);

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
		private static final @NonNull ExecutorFragment _NodeConnection__Element = new ExecutorFragment(Types._NodeConnection, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _NodeConnection__NodeConnection = new ExecutorFragment(Types._NodeConnection, QVTscheduleTables.Types._NodeConnection);
		private static final @NonNull ExecutorFragment _NodeConnection__OclAny = new ExecutorFragment(Types._NodeConnection, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NodeConnection__OclElement = new ExecutorFragment(Types._NodeConnection, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _NodeConnection__Symbolable = new ExecutorFragment(Types._NodeConnection, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _NonPartition__Element = new ExecutorFragment(Types._NonPartition, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _NonPartition__MappingPartition = new ExecutorFragment(Types._NonPartition, QVTscheduleTables.Types._MappingPartition);
		private static final @NonNull ExecutorFragment _NonPartition__NamedElement = new ExecutorFragment(Types._NonPartition, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _NonPartition__NonPartition = new ExecutorFragment(Types._NonPartition, QVTscheduleTables.Types._NonPartition);
		private static final @NonNull ExecutorFragment _NonPartition__OclAny = new ExecutorFragment(Types._NonPartition, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NonPartition__OclElement = new ExecutorFragment(Types._NonPartition, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _NonPartition__Partition = new ExecutorFragment(Types._NonPartition, QVTscheduleTables.Types._Partition);

		private static final @NonNull ExecutorFragment _NullLiteralNode__ConnectionEnd = new ExecutorFragment(Types._NullLiteralNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _NullLiteralNode__Element = new ExecutorFragment(Types._NullLiteralNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _NullLiteralNode__MappingNode = new ExecutorFragment(Types._NullLiteralNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _NullLiteralNode__Node = new ExecutorFragment(Types._NullLiteralNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _NullLiteralNode__NullLiteralNode = new ExecutorFragment(Types._NullLiteralNode, QVTscheduleTables.Types._NullLiteralNode);
		private static final @NonNull ExecutorFragment _NullLiteralNode__OclAny = new ExecutorFragment(Types._NullLiteralNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NullLiteralNode__OclElement = new ExecutorFragment(Types._NullLiteralNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _NullLiteralNode__OperationNode = new ExecutorFragment(Types._NullLiteralNode, QVTscheduleTables.Types._OperationNode);

		private static final @NonNull ExecutorFragment _Number__Number = new ExecutorFragment(Types._Number, QVTscheduleTables.Types._Number);
		private static final @NonNull ExecutorFragment _Number__OclAny = new ExecutorFragment(Types._Number, OCLstdlibTables.Types._OclAny);

		private static final @NonNull ExecutorFragment _NumericLiteralNode__ConnectionEnd = new ExecutorFragment(Types._NumericLiteralNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _NumericLiteralNode__Element = new ExecutorFragment(Types._NumericLiteralNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _NumericLiteralNode__MappingNode = new ExecutorFragment(Types._NumericLiteralNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _NumericLiteralNode__Node = new ExecutorFragment(Types._NumericLiteralNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _NumericLiteralNode__NumericLiteralNode = new ExecutorFragment(Types._NumericLiteralNode, QVTscheduleTables.Types._NumericLiteralNode);
		private static final @NonNull ExecutorFragment _NumericLiteralNode__OclAny = new ExecutorFragment(Types._NumericLiteralNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NumericLiteralNode__OclElement = new ExecutorFragment(Types._NumericLiteralNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _NumericLiteralNode__OperationNode = new ExecutorFragment(Types._NumericLiteralNode, QVTscheduleTables.Types._OperationNode);

		private static final @NonNull ExecutorFragment _OperationCallNode__ConnectionEnd = new ExecutorFragment(Types._OperationCallNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _OperationCallNode__Element = new ExecutorFragment(Types._OperationCallNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _OperationCallNode__MappingNode = new ExecutorFragment(Types._OperationCallNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _OperationCallNode__Node = new ExecutorFragment(Types._OperationCallNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _OperationCallNode__OclAny = new ExecutorFragment(Types._OperationCallNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OperationCallNode__OclElement = new ExecutorFragment(Types._OperationCallNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _OperationCallNode__OperationCallNode = new ExecutorFragment(Types._OperationCallNode, QVTscheduleTables.Types._OperationCallNode);
		private static final @NonNull ExecutorFragment _OperationCallNode__OperationNode = new ExecutorFragment(Types._OperationCallNode, QVTscheduleTables.Types._OperationNode);

		private static final @NonNull ExecutorFragment _OperationNode__ConnectionEnd = new ExecutorFragment(Types._OperationNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _OperationNode__Element = new ExecutorFragment(Types._OperationNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _OperationNode__MappingNode = new ExecutorFragment(Types._OperationNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _OperationNode__Node = new ExecutorFragment(Types._OperationNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _OperationNode__OclAny = new ExecutorFragment(Types._OperationNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OperationNode__OclElement = new ExecutorFragment(Types._OperationNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _OperationNode__OperationNode = new ExecutorFragment(Types._OperationNode, QVTscheduleTables.Types._OperationNode);

		private static final @NonNull ExecutorFragment _OperationParameterEdge__ArgumentEdge = new ExecutorFragment(Types._OperationParameterEdge, QVTscheduleTables.Types._ArgumentEdge);
		private static final @NonNull ExecutorFragment _OperationParameterEdge__Edge = new ExecutorFragment(Types._OperationParameterEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _OperationParameterEdge__Element = new ExecutorFragment(Types._OperationParameterEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _OperationParameterEdge__ExpressionEdge = new ExecutorFragment(Types._OperationParameterEdge, QVTscheduleTables.Types._ExpressionEdge);
		private static final @NonNull ExecutorFragment _OperationParameterEdge__OclAny = new ExecutorFragment(Types._OperationParameterEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OperationParameterEdge__OclElement = new ExecutorFragment(Types._OperationParameterEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _OperationParameterEdge__OperationParameterEdge = new ExecutorFragment(Types._OperationParameterEdge, QVTscheduleTables.Types._OperationParameterEdge);

		private static final @NonNull ExecutorFragment _OperationRegion__Element = new ExecutorFragment(Types._OperationRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _OperationRegion__NamedElement = new ExecutorFragment(Types._OperationRegion, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _OperationRegion__OclAny = new ExecutorFragment(Types._OperationRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OperationRegion__OclElement = new ExecutorFragment(Types._OperationRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _OperationRegion__OperationRegion = new ExecutorFragment(Types._OperationRegion, QVTscheduleTables.Types._OperationRegion);
		private static final @NonNull ExecutorFragment _OperationRegion__Region = new ExecutorFragment(Types._OperationRegion, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _OperationRegion__Symbolable = new ExecutorFragment(Types._OperationRegion, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _OperationSelfEdge__ArgumentEdge = new ExecutorFragment(Types._OperationSelfEdge, QVTscheduleTables.Types._ArgumentEdge);
		private static final @NonNull ExecutorFragment _OperationSelfEdge__Edge = new ExecutorFragment(Types._OperationSelfEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _OperationSelfEdge__Element = new ExecutorFragment(Types._OperationSelfEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _OperationSelfEdge__ExpressionEdge = new ExecutorFragment(Types._OperationSelfEdge, QVTscheduleTables.Types._ExpressionEdge);
		private static final @NonNull ExecutorFragment _OperationSelfEdge__OclAny = new ExecutorFragment(Types._OperationSelfEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OperationSelfEdge__OclElement = new ExecutorFragment(Types._OperationSelfEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _OperationSelfEdge__OperationSelfEdge = new ExecutorFragment(Types._OperationSelfEdge, QVTscheduleTables.Types._OperationSelfEdge);

		private static final @NonNull ExecutorFragment _Partition__Element = new ExecutorFragment(Types._Partition, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Partition__NamedElement = new ExecutorFragment(Types._Partition, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Partition__OclAny = new ExecutorFragment(Types._Partition, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Partition__OclElement = new ExecutorFragment(Types._Partition, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Partition__Partition = new ExecutorFragment(Types._Partition, QVTscheduleTables.Types._Partition);

		private static final @NonNull ExecutorFragment _PatternTypedNode__ConnectionEnd = new ExecutorFragment(Types._PatternTypedNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _PatternTypedNode__Element = new ExecutorFragment(Types._PatternTypedNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _PatternTypedNode__MappingNode = new ExecutorFragment(Types._PatternTypedNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _PatternTypedNode__Node = new ExecutorFragment(Types._PatternTypedNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _PatternTypedNode__OclAny = new ExecutorFragment(Types._PatternTypedNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _PatternTypedNode__OclElement = new ExecutorFragment(Types._PatternTypedNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _PatternTypedNode__PatternTypedNode = new ExecutorFragment(Types._PatternTypedNode, QVTscheduleTables.Types._PatternTypedNode);

		private static final @NonNull ExecutorFragment _PatternVariableNode__ConnectionEnd = new ExecutorFragment(Types._PatternVariableNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _PatternVariableNode__Element = new ExecutorFragment(Types._PatternVariableNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _PatternVariableNode__MappingNode = new ExecutorFragment(Types._PatternVariableNode, QVTscheduleTables.Types._MappingNode);
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

		private static final @NonNull ExecutorFragment _RootPartition__CompositePartition = new ExecutorFragment(Types._RootPartition, QVTscheduleTables.Types._CompositePartition);
		private static final @NonNull ExecutorFragment _RootPartition__Element = new ExecutorFragment(Types._RootPartition, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _RootPartition__NamedElement = new ExecutorFragment(Types._RootPartition, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _RootPartition__OclAny = new ExecutorFragment(Types._RootPartition, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _RootPartition__OclElement = new ExecutorFragment(Types._RootPartition, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _RootPartition__Partition = new ExecutorFragment(Types._RootPartition, QVTscheduleTables.Types._Partition);
		private static final @NonNull ExecutorFragment _RootPartition__RootPartition = new ExecutorFragment(Types._RootPartition, QVTscheduleTables.Types._RootPartition);

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

		private static final @NonNull ExecutorFragment _ShadowNode__ConnectionEnd = new ExecutorFragment(Types._ShadowNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _ShadowNode__Element = new ExecutorFragment(Types._ShadowNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ShadowNode__MappingNode = new ExecutorFragment(Types._ShadowNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _ShadowNode__Node = new ExecutorFragment(Types._ShadowNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _ShadowNode__OclAny = new ExecutorFragment(Types._ShadowNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ShadowNode__OclElement = new ExecutorFragment(Types._ShadowNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _ShadowNode__OperationNode = new ExecutorFragment(Types._ShadowNode, QVTscheduleTables.Types._OperationNode);
		private static final @NonNull ExecutorFragment _ShadowNode__ShadowNode = new ExecutorFragment(Types._ShadowNode, QVTscheduleTables.Types._ShadowNode);

		private static final @NonNull ExecutorFragment _ShadowPartEdge__ArgumentEdge = new ExecutorFragment(Types._ShadowPartEdge, QVTscheduleTables.Types._ArgumentEdge);
		private static final @NonNull ExecutorFragment _ShadowPartEdge__Edge = new ExecutorFragment(Types._ShadowPartEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _ShadowPartEdge__Element = new ExecutorFragment(Types._ShadowPartEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ShadowPartEdge__ExpressionEdge = new ExecutorFragment(Types._ShadowPartEdge, QVTscheduleTables.Types._ExpressionEdge);
		private static final @NonNull ExecutorFragment _ShadowPartEdge__OclAny = new ExecutorFragment(Types._ShadowPartEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ShadowPartEdge__OclElement = new ExecutorFragment(Types._ShadowPartEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _ShadowPartEdge__ShadowPartEdge = new ExecutorFragment(Types._ShadowPartEdge, QVTscheduleTables.Types._ShadowPartEdge);

		private static final @NonNull ExecutorFragment _StringLiteralNode__ConnectionEnd = new ExecutorFragment(Types._StringLiteralNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _StringLiteralNode__Element = new ExecutorFragment(Types._StringLiteralNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _StringLiteralNode__MappingNode = new ExecutorFragment(Types._StringLiteralNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _StringLiteralNode__Node = new ExecutorFragment(Types._StringLiteralNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _StringLiteralNode__OclAny = new ExecutorFragment(Types._StringLiteralNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _StringLiteralNode__OclElement = new ExecutorFragment(Types._StringLiteralNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _StringLiteralNode__OperationNode = new ExecutorFragment(Types._StringLiteralNode, QVTscheduleTables.Types._OperationNode);
		private static final @NonNull ExecutorFragment _StringLiteralNode__StringLiteralNode = new ExecutorFragment(Types._StringLiteralNode, QVTscheduleTables.Types._StringLiteralNode);

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
		private static final @NonNull ExecutorFragment _SuccessNode__MappingNode = new ExecutorFragment(Types._SuccessNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _SuccessNode__Node = new ExecutorFragment(Types._SuccessNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _SuccessNode__OclAny = new ExecutorFragment(Types._SuccessNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _SuccessNode__OclElement = new ExecutorFragment(Types._SuccessNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _SuccessNode__SuccessNode = new ExecutorFragment(Types._SuccessNode, QVTscheduleTables.Types._SuccessNode);

		private static final @NonNull ExecutorFragment _Symbolable__OclAny = new ExecutorFragment(Types._Symbolable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Symbolable__OclElement = new ExecutorFragment(Types._Symbolable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Symbolable__Symbolable = new ExecutorFragment(Types._Symbolable, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _TupleLiteralNode__ConnectionEnd = new ExecutorFragment(Types._TupleLiteralNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _TupleLiteralNode__Element = new ExecutorFragment(Types._TupleLiteralNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _TupleLiteralNode__MappingNode = new ExecutorFragment(Types._TupleLiteralNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _TupleLiteralNode__Node = new ExecutorFragment(Types._TupleLiteralNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _TupleLiteralNode__OclAny = new ExecutorFragment(Types._TupleLiteralNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _TupleLiteralNode__OclElement = new ExecutorFragment(Types._TupleLiteralNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _TupleLiteralNode__OperationNode = new ExecutorFragment(Types._TupleLiteralNode, QVTscheduleTables.Types._OperationNode);
		private static final @NonNull ExecutorFragment _TupleLiteralNode__TupleLiteralNode = new ExecutorFragment(Types._TupleLiteralNode, QVTscheduleTables.Types._TupleLiteralNode);

		private static final @NonNull ExecutorFragment _TuplePartEdge__ArgumentEdge = new ExecutorFragment(Types._TuplePartEdge, QVTscheduleTables.Types._ArgumentEdge);
		private static final @NonNull ExecutorFragment _TuplePartEdge__Edge = new ExecutorFragment(Types._TuplePartEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _TuplePartEdge__Element = new ExecutorFragment(Types._TuplePartEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _TuplePartEdge__ExpressionEdge = new ExecutorFragment(Types._TuplePartEdge, QVTscheduleTables.Types._ExpressionEdge);
		private static final @NonNull ExecutorFragment _TuplePartEdge__OclAny = new ExecutorFragment(Types._TuplePartEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _TuplePartEdge__OclElement = new ExecutorFragment(Types._TuplePartEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _TuplePartEdge__TuplePartEdge = new ExecutorFragment(Types._TuplePartEdge, QVTscheduleTables.Types._TuplePartEdge);

		private static final @NonNull ExecutorFragment _TypeLiteralNode__ConnectionEnd = new ExecutorFragment(Types._TypeLiteralNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _TypeLiteralNode__Element = new ExecutorFragment(Types._TypeLiteralNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _TypeLiteralNode__MappingNode = new ExecutorFragment(Types._TypeLiteralNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _TypeLiteralNode__Node = new ExecutorFragment(Types._TypeLiteralNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _TypeLiteralNode__OclAny = new ExecutorFragment(Types._TypeLiteralNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _TypeLiteralNode__OclElement = new ExecutorFragment(Types._TypeLiteralNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _TypeLiteralNode__OperationNode = new ExecutorFragment(Types._TypeLiteralNode, QVTscheduleTables.Types._OperationNode);
		private static final @NonNull ExecutorFragment _TypeLiteralNode__TypeLiteralNode = new ExecutorFragment(Types._TypeLiteralNode, QVTscheduleTables.Types._TypeLiteralNode);

		private static final @NonNull ExecutorFragment _UnknownNode__ConnectionEnd = new ExecutorFragment(Types._UnknownNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _UnknownNode__Element = new ExecutorFragment(Types._UnknownNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _UnknownNode__MappingNode = new ExecutorFragment(Types._UnknownNode, QVTscheduleTables.Types._MappingNode);
		private static final @NonNull ExecutorFragment _UnknownNode__Node = new ExecutorFragment(Types._UnknownNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _UnknownNode__OclAny = new ExecutorFragment(Types._UnknownNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _UnknownNode__OclElement = new ExecutorFragment(Types._UnknownNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _UnknownNode__UnknownNode = new ExecutorFragment(Types._UnknownNode, QVTscheduleTables.Types._UnknownNode);

		private static final @NonNull ExecutorFragment _VariableNode__ConnectionEnd = new ExecutorFragment(Types._VariableNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _VariableNode__Element = new ExecutorFragment(Types._VariableNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _VariableNode__MappingNode = new ExecutorFragment(Types._VariableNode, QVTscheduleTables.Types._MappingNode);
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

		public static final @NonNull ExecutorProperty _AbstractDatum__referredTypedModel = new EcoreExecutorProperty(QVTschedulePackage.Literals.ABSTRACT_DATUM__REFERRED_TYPED_MODEL, Types._AbstractDatum, 0);

		public static final @NonNull ExecutorProperty _BasicPartition__constantEdges = new EcoreExecutorProperty(QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_EDGES, Types._BasicPartition, 0);
		public static final @NonNull ExecutorProperty _BasicPartition__constantNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_NODES, Types._BasicPartition, 1);
		public static final @NonNull ExecutorProperty _BasicPartition__constantSuccessFalseNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_SUCCESS_FALSE_NODES, Types._BasicPartition, 2);
		public static final @NonNull ExecutorProperty _BasicPartition__constantSuccessTrueNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_SUCCESS_TRUE_NODES, Types._BasicPartition, 3);
		public static final @NonNull ExecutorProperty _BasicPartition__explicitPredecessors = new EcoreExecutorProperty(QVTschedulePackage.Literals.BASIC_PARTITION__EXPLICIT_PREDECESSORS, Types._BasicPartition, 4);
		public static final @NonNull ExecutorProperty _BasicPartition__headNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.BASIC_PARTITION__HEAD_NODES, Types._BasicPartition, 5);
		public static final @NonNull ExecutorProperty _BasicPartition__loadedEdges = new EcoreExecutorProperty(QVTschedulePackage.Literals.BASIC_PARTITION__LOADED_EDGES, Types._BasicPartition, 6);
		public static final @NonNull ExecutorProperty _BasicPartition__loadedNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.BASIC_PARTITION__LOADED_NODES, Types._BasicPartition, 7);
		public static final @NonNull ExecutorProperty _BasicPartition__predicatedEdges = new EcoreExecutorProperty(QVTschedulePackage.Literals.BASIC_PARTITION__PREDICATED_EDGES, Types._BasicPartition, 8);
		public static final @NonNull ExecutorProperty _BasicPartition__predicatedNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.BASIC_PARTITION__PREDICATED_NODES, Types._BasicPartition, 9);
		public static final @NonNull ExecutorProperty _BasicPartition__realizedEdges = new EcoreExecutorProperty(QVTschedulePackage.Literals.BASIC_PARTITION__REALIZED_EDGES, Types._BasicPartition, 10);
		public static final @NonNull ExecutorProperty _BasicPartition__realizedNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.BASIC_PARTITION__REALIZED_NODES, Types._BasicPartition, 11);
		public static final @NonNull ExecutorProperty _BasicPartition__speculatedEdges = new EcoreExecutorProperty(QVTschedulePackage.Literals.BASIC_PARTITION__SPECULATED_EDGES, Types._BasicPartition, 12);
		public static final @NonNull ExecutorProperty _BasicPartition__speculatedNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.BASIC_PARTITION__SPECULATED_NODES, Types._BasicPartition, 13);
		public static final @NonNull ExecutorProperty _BasicPartition__speculationNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.BASIC_PARTITION__SPECULATION_NODES, Types._BasicPartition, 14);

		public static final @NonNull ExecutorProperty _BooleanLiteralNode__booleanValue = new EcoreExecutorProperty(QVTschedulePackage.Literals.BOOLEAN_LITERAL_NODE__BOOLEAN_VALUE, Types._BooleanLiteralNode, 0);

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

		public static final @NonNull ExecutorProperty _Cluster__depth = new EcoreExecutorProperty(QVTschedulePackage.Literals.CLUSTER__DEPTH, Types._Cluster, 0);
		public static final @NonNull ExecutorProperty _Cluster__memberEdges = new EcoreExecutorProperty(QVTschedulePackage.Literals.CLUSTER__MEMBER_EDGES, Types._Cluster, 1);
		public static final @NonNull ExecutorProperty _Cluster__memberNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.CLUSTER__MEMBER_NODES, Types._Cluster, 2);
		public static final @NonNull ExecutorProperty _Cluster__owningRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.CLUSTER__OWNING_REGION, Types._Cluster, 3);
		public static final @NonNull ExecutorProperty _Cluster__precedingClusters = new EcoreExecutorProperty(QVTschedulePackage.Literals.CLUSTER__PRECEDING_CLUSTERS, Types._Cluster, 4);
		public static final @NonNull ExecutorProperty _Cluster__succeedingClusters = new EcoreExecutorProperty(QVTschedulePackage.Literals.CLUSTER__SUCCEEDING_CLUSTERS, Types._Cluster, 5);

		public static final @NonNull ExecutorProperty _CollectionPartEdge__referredPart = new EcoreExecutorProperty(QVTschedulePackage.Literals.COLLECTION_PART_EDGE__REFERRED_PART, Types._CollectionPartEdge, 0);

		public static final @NonNull ExecutorProperty _CompositePartition__ownedMappingPartitions = new EcoreExecutorProperty(QVTschedulePackage.Literals.COMPOSITE_PARTITION__OWNED_MAPPING_PARTITIONS, Types._CompositePartition, 0);

		public static final @NonNull ExecutorProperty _Connection__commonPartition = new EcoreExecutorProperty(QVTschedulePackage.Literals.CONNECTION__COMMON_PARTITION, Types._Connection, 0);
		public static final @NonNull ExecutorProperty _Connection__connectionRole = new EcoreExecutorProperty(QVTschedulePackage.Literals.CONNECTION__CONNECTION_ROLE, Types._Connection, 1);
		public static final @NonNull ExecutorProperty _Connection__intermediatePartitions = new EcoreExecutorProperty(QVTschedulePackage.Literals.CONNECTION__INTERMEDIATE_PARTITIONS, Types._Connection, 2);
		public static final @NonNull ExecutorProperty _Connection__name = new EcoreExecutorProperty(QVTschedulePackage.Literals.CONNECTION__NAME, Types._Connection, 3);
		public static final @NonNull ExecutorProperty _Connection__owningScheduledRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.CONNECTION__OWNING_SCHEDULED_REGION, Types._Connection, 4);
		public static final @NonNull ExecutorProperty _Connection__sourceEnds = new EcoreExecutorProperty(QVTschedulePackage.Literals.CONNECTION__SOURCE_ENDS, Types._Connection, 5);

		public static final @NonNull ExecutorProperty _ConnectionEnd__Connection__sourceEnds = new ExecutorPropertyWithImplementation("Connection", Types._ConnectionEnd, 0, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.CONNECTION__SOURCE_ENDS));

		public static final @NonNull ExecutorProperty _CyclicMappingRegion__elementRegions = new EcoreExecutorProperty(QVTschedulePackage.Literals.CYCLIC_MAPPING_REGION__ELEMENT_REGIONS, Types._CyclicMappingRegion, 0);

		public static final @NonNull ExecutorProperty _DispatchRegion__referredRuleRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.DISPATCH_REGION__REFERRED_RULE_REGION, Types._DispatchRegion, 0);

		public static final @NonNull ExecutorProperty _Edge__cluster = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE__CLUSTER, Types._Edge, 0);
		public static final @NonNull ExecutorProperty _Edge__edgeRole = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE__EDGE_ROLE, Types._Edge, 1);
		public static final @NonNull ExecutorProperty _Edge__name = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE__NAME, Types._Edge, 2);
		public static final @NonNull ExecutorProperty _Edge__owningRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE__OWNING_REGION, Types._Edge, 3);
		public static final @NonNull ExecutorProperty _Edge__sourceNode = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE__SOURCE_NODE, Types._Edge, 4);
		public static final @NonNull ExecutorProperty _Edge__targetNode = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE__TARGET_NODE, Types._Edge, 5);
		public static final @NonNull ExecutorProperty _Edge__BasicPartition__constantEdges = new ExecutorPropertyWithImplementation("BasicPartition", Types._Edge, 6, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_EDGES));
		public static final @NonNull ExecutorProperty _Edge__BasicPartition__loadedEdges = new ExecutorPropertyWithImplementation("BasicPartition", Types._Edge, 7, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.BASIC_PARTITION__LOADED_EDGES));
		public static final @NonNull ExecutorProperty _Edge__BasicPartition__predicatedEdges = new ExecutorPropertyWithImplementation("BasicPartition", Types._Edge, 8, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.BASIC_PARTITION__PREDICATED_EDGES));
		public static final @NonNull ExecutorProperty _Edge__BasicPartition__realizedEdges = new ExecutorPropertyWithImplementation("BasicPartition", Types._Edge, 9, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.BASIC_PARTITION__REALIZED_EDGES));
		public static final @NonNull ExecutorProperty _Edge__BasicPartition__speculatedEdges = new ExecutorPropertyWithImplementation("BasicPartition", Types._Edge, 10, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.BASIC_PARTITION__SPECULATED_EDGES));

		public static final @NonNull ExecutorProperty _EdgeConnection__mandatoryTargetEdges = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE_CONNECTION__MANDATORY_TARGET_EDGES, Types._EdgeConnection, 0);
		public static final @NonNull ExecutorProperty _EdgeConnection__preferredTargetEdges = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE_CONNECTION__PREFERRED_TARGET_EDGES, Types._EdgeConnection, 1);
		public static final @NonNull ExecutorProperty _EdgeConnection__referredProperty = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE_CONNECTION__REFERRED_PROPERTY, Types._EdgeConnection, 2);
		public static final @NonNull ExecutorProperty _EdgeConnection__NavigableEdge__incomingConnection = new ExecutorPropertyWithImplementation("NavigableEdge", Types._EdgeConnection, 3, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.NAVIGABLE_EDGE__INCOMING_CONNECTION));
		public static final @NonNull ExecutorProperty _EdgeConnection__NavigableEdge__outgoingConnections = new ExecutorPropertyWithImplementation("NavigableEdge", Types._EdgeConnection, 4, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.NAVIGABLE_EDGE__OUTGOING_CONNECTIONS));

		public static final @NonNull ExecutorProperty _EnumLiteralNode__enumValue = new EcoreExecutorProperty(QVTschedulePackage.Literals.ENUM_LITERAL_NODE__ENUM_VALUE, Types._EnumLiteralNode, 0);

		public static final @NonNull ExecutorProperty _KeyPartEdge__referredPart = new EcoreExecutorProperty(QVTschedulePackage.Literals.KEY_PART_EDGE__REFERRED_PART, Types._KeyPartEdge, 0);

		public static final @NonNull ExecutorProperty _KeyedValueNode__classDatumValue = new EcoreExecutorProperty(QVTschedulePackage.Literals.KEYED_VALUE_NODE__CLASS_DATUM_VALUE, Types._KeyedValueNode, 0);

		public static final @NonNull ExecutorProperty _LoadingPartition__referredLoadingRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.LOADING_PARTITION__REFERRED_LOADING_REGION, Types._LoadingPartition, 0);
		public static final @NonNull ExecutorProperty _LoadingPartition__RootPartition__loadingPartition = new ExecutorPropertyWithImplementation("RootPartition", Types._LoadingPartition, 1, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.ROOT_PARTITION__LOADING_PARTITION));

		public static final @NonNull ExecutorProperty _LoadingRegion__loadingPartition = new EcoreExecutorProperty(QVTschedulePackage.Literals.LOADING_REGION__LOADING_PARTITION, Types._LoadingRegion, 0);
		public static final @NonNull ExecutorProperty _LoadingRegion__owningScheduledRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.LOADING_REGION__OWNING_SCHEDULED_REGION, Types._LoadingRegion, 1);

		public static final @NonNull ExecutorProperty _MapPartEdge__referredPart = new EcoreExecutorProperty(QVTschedulePackage.Literals.MAP_PART_EDGE__REFERRED_PART, Types._MapPartEdge, 0);

		public static final @NonNull ExecutorProperty _MappingNode__matched = new EcoreExecutorProperty(QVTschedulePackage.Literals.MAPPING_NODE__MATCHED, Types._MappingNode, 0);

		public static final @NonNull ExecutorProperty _MappingPartition__owningCompositePartition = new EcoreExecutorProperty(QVTschedulePackage.Literals.MAPPING_PARTITION__OWNING_COMPOSITE_PARTITION, Types._MappingPartition, 0);
		public static final @NonNull ExecutorProperty _MappingPartition__referedMappingRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.MAPPING_PARTITION__REFERED_MAPPING_REGION, Types._MappingPartition, 1);
		public static final @NonNull ExecutorProperty _MappingPartition__region = new EcoreExecutorProperty(QVTschedulePackage.Literals.MAPPING_PARTITION__REGION, Types._MappingPartition, 2);
		public static final @NonNull ExecutorProperty _MappingPartition__rootPartition = new EcoreExecutorProperty(QVTschedulePackage.Literals.MAPPING_PARTITION__ROOT_PARTITION, Types._MappingPartition, 3);
		public static final @NonNull ExecutorProperty _MappingPartition__BasicPartition__explicitPredecessors = new ExecutorPropertyWithImplementation("BasicPartition", Types._MappingPartition, 4, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.BASIC_PARTITION__EXPLICIT_PREDECESSORS));

		public static final @NonNull ExecutorProperty _MappingRegion__headNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.MAPPING_REGION__HEAD_NODES, Types._MappingRegion, 0);
		public static final @NonNull ExecutorProperty _MappingRegion__mappingPartitions = new EcoreExecutorProperty(QVTschedulePackage.Literals.MAPPING_REGION__MAPPING_PARTITIONS, Types._MappingRegion, 1);
		public static final @NonNull ExecutorProperty _MappingRegion__owningScheduleModel = new EcoreExecutorProperty(QVTschedulePackage.Literals.MAPPING_REGION__OWNING_SCHEDULE_MODEL, Types._MappingRegion, 2);
		public static final @NonNull ExecutorProperty _MappingRegion__CyclicMappingRegion__elementRegions = new ExecutorPropertyWithImplementation("CyclicMappingRegion", Types._MappingRegion, 3, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.CYCLIC_MAPPING_REGION__ELEMENT_REGIONS));
		public static final @NonNull ExecutorProperty _MappingRegion__MicroMappingRegion__mappingRegion = new ExecutorPropertyWithImplementation("MicroMappingRegion", Types._MappingRegion, 4, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.MICRO_MAPPING_REGION__MAPPING_REGION));

		public static final @NonNull ExecutorProperty _MicroMappingRegion__mappingRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.MICRO_MAPPING_REGION__MAPPING_REGION, Types._MicroMappingRegion, 0);
		public static final @NonNull ExecutorProperty _MicroMappingRegion__namePrefix = new EcoreExecutorProperty(QVTschedulePackage.Literals.MICRO_MAPPING_REGION__NAME_PREFIX, Types._MicroMappingRegion, 1);
		public static final @NonNull ExecutorProperty _MicroMappingRegion__symbolNameSuffix = new EcoreExecutorProperty(QVTschedulePackage.Literals.MICRO_MAPPING_REGION__SYMBOL_NAME_SUFFIX, Types._MicroMappingRegion, 2);

		public static final @NonNull ExecutorProperty _NamedMappingRegion__symbolNameSuffix = new EcoreExecutorProperty(QVTschedulePackage.Literals.NAMED_MAPPING_REGION__SYMBOL_NAME_SUFFIX, Types._NamedMappingRegion, 0);

		public static final @NonNull ExecutorProperty _NavigableEdge__incomingConnection = new EcoreExecutorProperty(QVTschedulePackage.Literals.NAVIGABLE_EDGE__INCOMING_CONNECTION, Types._NavigableEdge, 0);
		public static final @NonNull ExecutorProperty _NavigableEdge__oppositeEdge = new EcoreExecutorProperty(QVTschedulePackage.Literals.NAVIGABLE_EDGE__OPPOSITE_EDGE, Types._NavigableEdge, 1);
		public static final @NonNull ExecutorProperty _NavigableEdge__outgoingConnections = new EcoreExecutorProperty(QVTschedulePackage.Literals.NAVIGABLE_EDGE__OUTGOING_CONNECTIONS, Types._NavigableEdge, 2);
		public static final @NonNull ExecutorProperty _NavigableEdge__secondary = new EcoreExecutorProperty(QVTschedulePackage.Literals.NAVIGABLE_EDGE__SECONDARY, Types._NavigableEdge, 3);
		public static final @NonNull ExecutorProperty _NavigableEdge__EdgeConnection__mandatoryTargetEdges = new ExecutorPropertyWithImplementation("EdgeConnection", Types._NavigableEdge, 4, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.EDGE_CONNECTION__MANDATORY_TARGET_EDGES));
		public static final @NonNull ExecutorProperty _NavigableEdge__EdgeConnection__preferredTargetEdges = new ExecutorPropertyWithImplementation("EdgeConnection", Types._NavigableEdge, 5, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.EDGE_CONNECTION__PREFERRED_TARGET_EDGES));
		public static final @NonNull ExecutorProperty _NavigableEdge__NavigableEdge__oppositeEdge = new ExecutorPropertyWithImplementation("NavigableEdge", Types._NavigableEdge, 6, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.NAVIGABLE_EDGE__OPPOSITE_EDGE));

		public static final @NonNull ExecutorProperty _NavigationEdge__partial = new EcoreExecutorProperty(QVTschedulePackage.Literals.NAVIGATION_EDGE__PARTIAL, Types._NavigationEdge, 0);
		public static final @NonNull ExecutorProperty _NavigationEdge__referredProperty = new EcoreExecutorProperty(QVTschedulePackage.Literals.NAVIGATION_EDGE__REFERRED_PROPERTY, Types._NavigationEdge, 1);

		public static final @NonNull ExecutorProperty _Node__classDatum = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__CLASS_DATUM, Types._Node, 0);
		public static final @NonNull ExecutorProperty _Node__cluster = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__CLUSTER, Types._Node, 1);
		public static final @NonNull ExecutorProperty _Node__incomingConnection = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__INCOMING_CONNECTION, Types._Node, 2);
		public static final @NonNull ExecutorProperty _Node__incomingEdges = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__INCOMING_EDGES, Types._Node, 3);
		public static final @NonNull ExecutorProperty _Node__name = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__NAME, Types._Node, 4);
		public static final @NonNull ExecutorProperty _Node__nodeRole = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__NODE_ROLE, Types._Node, 5);
		public static final @NonNull ExecutorProperty _Node__outgoingConnections = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__OUTGOING_CONNECTIONS, Types._Node, 6);
		public static final @NonNull ExecutorProperty _Node__outgoingEdges = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__OUTGOING_EDGES, Types._Node, 7);
		public static final @NonNull ExecutorProperty _Node__owningRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__OWNING_REGION, Types._Node, 8);
		public static final @NonNull ExecutorProperty _Node__BasicPartition__constantNodes = new ExecutorPropertyWithImplementation("BasicPartition", Types._Node, 9, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_NODES));
		public static final @NonNull ExecutorProperty _Node__BasicPartition__constantSuccessFalseNodes = new ExecutorPropertyWithImplementation("BasicPartition", Types._Node, 10, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_SUCCESS_FALSE_NODES));
		public static final @NonNull ExecutorProperty _Node__BasicPartition__constantSuccessTrueNodes = new ExecutorPropertyWithImplementation("BasicPartition", Types._Node, 11, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_SUCCESS_TRUE_NODES));
		public static final @NonNull ExecutorProperty _Node__BasicPartition__headNodes = new ExecutorPropertyWithImplementation("BasicPartition", Types._Node, 12, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.BASIC_PARTITION__HEAD_NODES));
		public static final @NonNull ExecutorProperty _Node__BasicPartition__loadedNodes = new ExecutorPropertyWithImplementation("BasicPartition", Types._Node, 13, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.BASIC_PARTITION__LOADED_NODES));
		public static final @NonNull ExecutorProperty _Node__BasicPartition__predicatedNodes = new ExecutorPropertyWithImplementation("BasicPartition", Types._Node, 14, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.BASIC_PARTITION__PREDICATED_NODES));
		public static final @NonNull ExecutorProperty _Node__BasicPartition__realizedNodes = new ExecutorPropertyWithImplementation("BasicPartition", Types._Node, 15, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.BASIC_PARTITION__REALIZED_NODES));
		public static final @NonNull ExecutorProperty _Node__BasicPartition__speculatedNodes = new ExecutorPropertyWithImplementation("BasicPartition", Types._Node, 16, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.BASIC_PARTITION__SPECULATED_NODES));
		public static final @NonNull ExecutorProperty _Node__BasicPartition__speculationNodes = new ExecutorPropertyWithImplementation("BasicPartition", Types._Node, 17, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.BASIC_PARTITION__SPECULATION_NODES));
		public static final @NonNull ExecutorProperty _Node__MappingRegion__headNodes = new ExecutorPropertyWithImplementation("MappingRegion", Types._Node, 18, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.MAPPING_REGION__HEAD_NODES));
		public static final @NonNull ExecutorProperty _Node__NodeConnection__mandatoryTargetNodes = new ExecutorPropertyWithImplementation("NodeConnection", Types._Node, 19, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.NODE_CONNECTION__MANDATORY_TARGET_NODES));
		public static final @NonNull ExecutorProperty _Node__NodeConnection__passedTargetNodes = new ExecutorPropertyWithImplementation("NodeConnection", Types._Node, 20, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.NODE_CONNECTION__PASSED_TARGET_NODES));
		public static final @NonNull ExecutorProperty _Node__NodeConnection__preferredTargetNodes = new ExecutorPropertyWithImplementation("NodeConnection", Types._Node, 21, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.NODE_CONNECTION__PREFERRED_TARGET_NODES));
		public static final @NonNull ExecutorProperty _Node__OperationRegion__dependencyNodes = new ExecutorPropertyWithImplementation("OperationRegion", Types._Node, 22, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.OPERATION_REGION__DEPENDENCY_NODES));
		public static final @NonNull ExecutorProperty _Node__OperationRegion__headNodes = new ExecutorPropertyWithImplementation("OperationRegion", Types._Node, 23, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.OPERATION_REGION__HEAD_NODES));
		public static final @NonNull ExecutorProperty _Node__OperationRegion__resultNode = new ExecutorPropertyWithImplementation("OperationRegion", Types._Node, 24, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.OPERATION_REGION__RESULT_NODE));

		public static final @NonNull ExecutorProperty _NodeConnection__classDatum = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE_CONNECTION__CLASS_DATUM, Types._NodeConnection, 0);
		public static final @NonNull ExecutorProperty _NodeConnection__mandatoryTargetNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE_CONNECTION__MANDATORY_TARGET_NODES, Types._NodeConnection, 1);
		public static final @NonNull ExecutorProperty _NodeConnection__passedTargetNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE_CONNECTION__PASSED_TARGET_NODES, Types._NodeConnection, 2);
		public static final @NonNull ExecutorProperty _NodeConnection__preferredTargetNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE_CONNECTION__PREFERRED_TARGET_NODES, Types._NodeConnection, 3);
		public static final @NonNull ExecutorProperty _NodeConnection__Node__incomingConnection = new ExecutorPropertyWithImplementation("Node", Types._NodeConnection, 4, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.NODE__INCOMING_CONNECTION));
		public static final @NonNull ExecutorProperty _NodeConnection__Node__outgoingConnections = new ExecutorPropertyWithImplementation("Node", Types._NodeConnection, 5, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.NODE__OUTGOING_CONNECTIONS));
		public static final @NonNull ExecutorProperty _NodeConnection__Partition__intermediateConnections = new ExecutorPropertyWithImplementation("Partition", Types._NodeConnection, 6, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.PARTITION__INTERMEDIATE_CONNECTIONS));
		public static final @NonNull ExecutorProperty _NodeConnection__Partition__rootConnections = new ExecutorPropertyWithImplementation("Partition", Types._NodeConnection, 7, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.PARTITION__ROOT_CONNECTIONS));

		public static final @NonNull ExecutorProperty _NumericLiteralNode__numericValue = new EcoreExecutorProperty(QVTschedulePackage.Literals.NUMERIC_LITERAL_NODE__NUMERIC_VALUE, Types._NumericLiteralNode, 0);

		public static final @NonNull ExecutorProperty _OperationCallNode__referredOperation = new EcoreExecutorProperty(QVTschedulePackage.Literals.OPERATION_CALL_NODE__REFERRED_OPERATION, Types._OperationCallNode, 0);

		public static final @NonNull ExecutorProperty _OperationParameterEdge__parameterIndex = new EcoreExecutorProperty(QVTschedulePackage.Literals.OPERATION_PARAMETER_EDGE__PARAMETER_INDEX, Types._OperationParameterEdge, 0);
		public static final @NonNull ExecutorProperty _OperationParameterEdge__referredParameter = new EcoreExecutorProperty(QVTschedulePackage.Literals.OPERATION_PARAMETER_EDGE__REFERRED_PARAMETER, Types._OperationParameterEdge, 1);

		public static final @NonNull ExecutorProperty _OperationRegion__dependencyNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.OPERATION_REGION__DEPENDENCY_NODES, Types._OperationRegion, 0);
		public static final @NonNull ExecutorProperty _OperationRegion__headNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.OPERATION_REGION__HEAD_NODES, Types._OperationRegion, 1);
		public static final @NonNull ExecutorProperty _OperationRegion__owningScheduleModel = new EcoreExecutorProperty(QVTschedulePackage.Literals.OPERATION_REGION__OWNING_SCHEDULE_MODEL, Types._OperationRegion, 2);
		public static final @NonNull ExecutorProperty _OperationRegion__referredOperation = new EcoreExecutorProperty(QVTschedulePackage.Literals.OPERATION_REGION__REFERRED_OPERATION, Types._OperationRegion, 3);
		public static final @NonNull ExecutorProperty _OperationRegion__resultNode = new EcoreExecutorProperty(QVTschedulePackage.Literals.OPERATION_REGION__RESULT_NODE, Types._OperationRegion, 4);

		public static final @NonNull ExecutorProperty _OperationSelfEdge__referredType = new EcoreExecutorProperty(QVTschedulePackage.Literals.OPERATION_SELF_EDGE__REFERRED_TYPE, Types._OperationSelfEdge, 0);

		public static final @NonNull ExecutorProperty _Partition__intermediateConnections = new EcoreExecutorProperty(QVTschedulePackage.Literals.PARTITION__INTERMEDIATE_CONNECTIONS, Types._Partition, 0);
		public static final @NonNull ExecutorProperty _Partition__passes = new EcoreExecutorProperty(QVTschedulePackage.Literals.PARTITION__PASSES, Types._Partition, 1);
		public static final @NonNull ExecutorProperty _Partition__rootConnections = new EcoreExecutorProperty(QVTschedulePackage.Literals.PARTITION__ROOT_CONNECTIONS, Types._Partition, 2);
		public static final @NonNull ExecutorProperty _Partition__Connection__commonPartition = new ExecutorPropertyWithImplementation("Connection", Types._Partition, 3, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.CONNECTION__COMMON_PARTITION));
		public static final @NonNull ExecutorProperty _Partition__Connection__intermediatePartitions = new ExecutorPropertyWithImplementation("Connection", Types._Partition, 4, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.CONNECTION__INTERMEDIATE_PARTITIONS));

		public static final @NonNull ExecutorProperty _PropertyDatum__key = new EcoreExecutorProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__KEY, Types._PropertyDatum, 0);
		public static final @NonNull ExecutorProperty _PropertyDatum__opposite = new EcoreExecutorProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__OPPOSITE, Types._PropertyDatum, 1);
		public static final @NonNull ExecutorProperty _PropertyDatum__owningClassDatum = new EcoreExecutorProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__OWNING_CLASS_DATUM, Types._PropertyDatum, 2);
		public static final @NonNull ExecutorProperty _PropertyDatum__referredProperty = new EcoreExecutorProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__REFERRED_PROPERTY, Types._PropertyDatum, 3);
		public static final @NonNull ExecutorProperty _PropertyDatum__superPropertyDatums = new EcoreExecutorProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__SUPER_PROPERTY_DATUMS, Types._PropertyDatum, 4);
		public static final @NonNull ExecutorProperty _PropertyDatum__KeyPartEdge__referredPart = new ExecutorPropertyWithImplementation("KeyPartEdge", Types._PropertyDatum, 5, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.KEY_PART_EDGE__REFERRED_PART));
		public static final @NonNull ExecutorProperty _PropertyDatum__PropertyDatum__opposite = new ExecutorPropertyWithImplementation("PropertyDatum", Types._PropertyDatum, 6, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__OPPOSITE));
		public static final @NonNull ExecutorProperty _PropertyDatum__PropertyDatum__superPropertyDatums = new ExecutorPropertyWithImplementation("PropertyDatum", Types._PropertyDatum, 7, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__SUPER_PROPERTY_DATUMS));

		public static final @NonNull ExecutorProperty _RecursionEdge__primary = new EcoreExecutorProperty(QVTschedulePackage.Literals.RECURSION_EDGE__PRIMARY, Types._RecursionEdge, 0);

		public static final @NonNull ExecutorProperty _Region__ownedClusters = new EcoreExecutorProperty(QVTschedulePackage.Literals.REGION__OWNED_CLUSTERS, Types._Region, 0);
		public static final @NonNull ExecutorProperty _Region__ownedEdges = new EcoreExecutorProperty(QVTschedulePackage.Literals.REGION__OWNED_EDGES, Types._Region, 1);
		public static final @NonNull ExecutorProperty _Region__ownedNodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.REGION__OWNED_NODES, Types._Region, 2);
		public static final @NonNull ExecutorProperty _Region__scheduledRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.REGION__SCHEDULED_REGION, Types._Region, 3);
		public static final @NonNull ExecutorProperty _Region__MappingPartition__region = new ExecutorPropertyWithImplementation("MappingPartition", Types._Region, 4, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.MAPPING_PARTITION__REGION));

		public static final @NonNull ExecutorProperty _RootPartition__loadingPartition = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROOT_PARTITION__LOADING_PARTITION, Types._RootPartition, 0);
		public static final @NonNull ExecutorProperty _RootPartition__owningRootRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROOT_PARTITION__OWNING_ROOT_REGION, Types._RootPartition, 1);
		public static final @NonNull ExecutorProperty _RootPartition__MappingPartition__rootPartition = new ExecutorPropertyWithImplementation("MappingPartition", Types._RootPartition, 2, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.MAPPING_PARTITION__ROOT_PARTITION));

		public static final @NonNull ExecutorProperty _RuleRegion__referredRule = new EcoreExecutorProperty(QVTschedulePackage.Literals.RULE_REGION__REFERRED_RULE, Types._RuleRegion, 0);
		public static final @NonNull ExecutorProperty _RuleRegion__DispatchRegion__referredRuleRegion = new ExecutorPropertyWithImplementation("DispatchRegion", Types._RuleRegion, 1, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.DISPATCH_REGION__REFERRED_RULE_REGION));
		public static final @NonNull ExecutorProperty _RuleRegion__VerdictRegion__referredRuleRegion = new ExecutorPropertyWithImplementation("VerdictRegion", Types._RuleRegion, 2, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.VERDICT_REGION__REFERRED_RULE_REGION));

		public static final @NonNull ExecutorProperty _ScheduleModel__ownedClassDatums = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULE_MODEL__OWNED_CLASS_DATUMS, Types._ScheduleModel, 0);
		public static final @NonNull ExecutorProperty _ScheduleModel__ownedMappingRegions = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULE_MODEL__OWNED_MAPPING_REGIONS, Types._ScheduleModel, 1);
		public static final @NonNull ExecutorProperty _ScheduleModel__ownedOperationRegions = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULE_MODEL__OWNED_OPERATION_REGIONS, Types._ScheduleModel, 2);
		public static final @NonNull ExecutorProperty _ScheduleModel__ownedScheduledRegions = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULE_MODEL__OWNED_SCHEDULED_REGIONS, Types._ScheduleModel, 3);

		public static final @NonNull ExecutorProperty _ScheduledRegion__activeRegions = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULED_REGION__ACTIVE_REGIONS, Types._ScheduledRegion, 0);
		public static final @NonNull ExecutorProperty _ScheduledRegion__ownedConnections = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULED_REGION__OWNED_CONNECTIONS, Types._ScheduledRegion, 1);
		public static final @NonNull ExecutorProperty _ScheduledRegion__ownedLoadingRegion = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULED_REGION__OWNED_LOADING_REGION, Types._ScheduledRegion, 2);
		public static final @NonNull ExecutorProperty _ScheduledRegion__ownedRootPartition = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULED_REGION__OWNED_ROOT_PARTITION, Types._ScheduledRegion, 3);
		public static final @NonNull ExecutorProperty _ScheduledRegion__owningScheduleModel = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULED_REGION__OWNING_SCHEDULE_MODEL, Types._ScheduledRegion, 4);
		public static final @NonNull ExecutorProperty _ScheduledRegion__referredTransformation = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULED_REGION__REFERRED_TRANSFORMATION, Types._ScheduledRegion, 5);

		public static final @NonNull ExecutorProperty _ShadowPartEdge__referredPart = new EcoreExecutorProperty(QVTschedulePackage.Literals.SHADOW_PART_EDGE__REFERRED_PART, Types._ShadowPartEdge, 0);

		public static final @NonNull ExecutorProperty _StringLiteralNode__stringValue = new EcoreExecutorProperty(QVTschedulePackage.Literals.STRING_LITERAL_NODE__STRING_VALUE, Types._StringLiteralNode, 0);

		public static final @NonNull ExecutorProperty _Symbolable__symbolName = new EcoreExecutorProperty(QVTschedulePackage.Literals.SYMBOLABLE__SYMBOL_NAME, Types._Symbolable, 0);

		public static final @NonNull ExecutorProperty _TuplePartEdge__referredPart = new EcoreExecutorProperty(QVTschedulePackage.Literals.TUPLE_PART_EDGE__REFERRED_PART, Types._TuplePartEdge, 0);

		public static final @NonNull ExecutorProperty _TypeLiteralNode__typeValue = new EcoreExecutorProperty(QVTschedulePackage.Literals.TYPE_LITERAL_NODE__TYPE_VALUE, Types._TypeLiteralNode, 0);

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

		private static final @NonNull ExecutorFragment @NonNull [] _ArgumentEdge =
			{
				Fragments._ArgumentEdge__OclAny /* 0 */,
				Fragments._ArgumentEdge__OclElement /* 1 */,
				Fragments._ArgumentEdge__Element /* 2 */,
				Fragments._ArgumentEdge__Edge /* 3 */,
				Fragments._ArgumentEdge__ExpressionEdge /* 4 */,
				Fragments._ArgumentEdge__ArgumentEdge /* 5 */
			};
		private static final int @NonNull [] __ArgumentEdge = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _BasicPartition =
			{
				Fragments._BasicPartition__OclAny /* 0 */,
				Fragments._BasicPartition__OclElement /* 1 */,
				Fragments._BasicPartition__Element /* 2 */,
				Fragments._BasicPartition__NamedElement /* 3 */,
				Fragments._BasicPartition__Partition /* 4 */,
				Fragments._BasicPartition__MappingPartition /* 5 */,
				Fragments._BasicPartition__BasicPartition /* 6 */
			};
		private static final int @NonNull [] __BasicPartition = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _BooleanLiteralNode =
			{
				Fragments._BooleanLiteralNode__OclAny /* 0 */,
				Fragments._BooleanLiteralNode__OclElement /* 1 */,
				Fragments._BooleanLiteralNode__ConnectionEnd /* 2 */,
				Fragments._BooleanLiteralNode__Element /* 2 */,
				Fragments._BooleanLiteralNode__Node /* 3 */,
				Fragments._BooleanLiteralNode__MappingNode /* 4 */,
				Fragments._BooleanLiteralNode__OperationNode /* 5 */,
				Fragments._BooleanLiteralNode__BooleanLiteralNode /* 6 */
			};
		private static final int @NonNull [] __BooleanLiteralNode = { 1,1,2,1,1,1,1 };

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

		private static final @NonNull ExecutorFragment @NonNull [] _Cluster =
			{
				Fragments._Cluster__OclAny /* 0 */,
				Fragments._Cluster__OclElement /* 1 */,
				Fragments._Cluster__Element /* 2 */,
				Fragments._Cluster__Symbolable /* 2 */,
				Fragments._Cluster__NamedElement /* 3 */,
				Fragments._Cluster__Cluster /* 4 */
			};
		private static final int @NonNull [] __Cluster = { 1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _CollectionLiteralNode =
			{
				Fragments._CollectionLiteralNode__OclAny /* 0 */,
				Fragments._CollectionLiteralNode__OclElement /* 1 */,
				Fragments._CollectionLiteralNode__ConnectionEnd /* 2 */,
				Fragments._CollectionLiteralNode__Element /* 2 */,
				Fragments._CollectionLiteralNode__Node /* 3 */,
				Fragments._CollectionLiteralNode__MappingNode /* 4 */,
				Fragments._CollectionLiteralNode__OperationNode /* 5 */,
				Fragments._CollectionLiteralNode__CollectionLiteralNode /* 6 */
			};
		private static final int @NonNull [] __CollectionLiteralNode = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _CollectionPartEdge =
			{
				Fragments._CollectionPartEdge__OclAny /* 0 */,
				Fragments._CollectionPartEdge__OclElement /* 1 */,
				Fragments._CollectionPartEdge__Element /* 2 */,
				Fragments._CollectionPartEdge__Edge /* 3 */,
				Fragments._CollectionPartEdge__ExpressionEdge /* 4 */,
				Fragments._CollectionPartEdge__ArgumentEdge /* 5 */,
				Fragments._CollectionPartEdge__CollectionPartEdge /* 6 */
			};
		private static final int @NonNull [] __CollectionPartEdge = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _CollectionRangeNode =
			{
				Fragments._CollectionRangeNode__OclAny /* 0 */,
				Fragments._CollectionRangeNode__OclElement /* 1 */,
				Fragments._CollectionRangeNode__ConnectionEnd /* 2 */,
				Fragments._CollectionRangeNode__Element /* 2 */,
				Fragments._CollectionRangeNode__Node /* 3 */,
				Fragments._CollectionRangeNode__MappingNode /* 4 */,
				Fragments._CollectionRangeNode__OperationNode /* 5 */,
				Fragments._CollectionRangeNode__CollectionRangeNode /* 6 */
			};
		private static final int @NonNull [] __CollectionRangeNode = { 1,1,2,1,1,1,1 };

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

		private static final @NonNull ExecutorFragment @NonNull [] _CompositePartition =
			{
				Fragments._CompositePartition__OclAny /* 0 */,
				Fragments._CompositePartition__OclElement /* 1 */,
				Fragments._CompositePartition__Element /* 2 */,
				Fragments._CompositePartition__NamedElement /* 3 */,
				Fragments._CompositePartition__Partition /* 4 */,
				Fragments._CompositePartition__CompositePartition /* 5 */
			};
		private static final int @NonNull [] __CompositePartition = { 1,1,1,1,1,1 };

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

		private static final @NonNull ExecutorFragment @NonNull [] _CyclicMappingRegion =
			{
				Fragments._CyclicMappingRegion__OclAny /* 0 */,
				Fragments._CyclicMappingRegion__OclElement /* 1 */,
				Fragments._CyclicMappingRegion__Element /* 2 */,
				Fragments._CyclicMappingRegion__Symbolable /* 2 */,
				Fragments._CyclicMappingRegion__NamedElement /* 3 */,
				Fragments._CyclicMappingRegion__Region /* 4 */,
				Fragments._CyclicMappingRegion__MappingRegion /* 5 */,
				Fragments._CyclicMappingRegion__CyclicMappingRegion /* 6 */
			};
		private static final int @NonNull [] __CyclicMappingRegion = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _CyclicPartition =
			{
				Fragments._CyclicPartition__OclAny /* 0 */,
				Fragments._CyclicPartition__OclElement /* 1 */,
				Fragments._CyclicPartition__Element /* 2 */,
				Fragments._CyclicPartition__NamedElement /* 3 */,
				Fragments._CyclicPartition__Partition /* 4 */,
				Fragments._CyclicPartition__CompositePartition /* 5 */,
				Fragments._CyclicPartition__MappingPartition /* 5 */,
				Fragments._CyclicPartition__CyclicPartition /* 6 */
			};
		private static final int @NonNull [] __CyclicPartition = { 1,1,1,1,1,2,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _DependencyEdge =
			{
				Fragments._DependencyEdge__OclAny /* 0 */,
				Fragments._DependencyEdge__OclElement /* 1 */,
				Fragments._DependencyEdge__Element /* 2 */,
				Fragments._DependencyEdge__Edge /* 3 */,
				Fragments._DependencyEdge__DependencyEdge /* 4 */
			};
		private static final int @NonNull [] __DependencyEdge = { 1,1,1,1,1 };

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
				Fragments._EdgeConnection__EdgeConnection /* 4 */
			};
		private static final int @NonNull [] __EdgeConnection = { 1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _EnumLiteralNode =
			{
				Fragments._EnumLiteralNode__OclAny /* 0 */,
				Fragments._EnumLiteralNode__OclElement /* 1 */,
				Fragments._EnumLiteralNode__ConnectionEnd /* 2 */,
				Fragments._EnumLiteralNode__Element /* 2 */,
				Fragments._EnumLiteralNode__Node /* 3 */,
				Fragments._EnumLiteralNode__MappingNode /* 4 */,
				Fragments._EnumLiteralNode__OperationNode /* 5 */,
				Fragments._EnumLiteralNode__EnumLiteralNode /* 6 */
			};
		private static final int @NonNull [] __EnumLiteralNode = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ErrorNode =
			{
				Fragments._ErrorNode__OclAny /* 0 */,
				Fragments._ErrorNode__OclElement /* 1 */,
				Fragments._ErrorNode__ConnectionEnd /* 2 */,
				Fragments._ErrorNode__Element /* 2 */,
				Fragments._ErrorNode__Node /* 3 */,
				Fragments._ErrorNode__MappingNode /* 4 */,
				Fragments._ErrorNode__ErrorNode /* 5 */
			};
		private static final int @NonNull [] __ErrorNode = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ExpressionEdge =
			{
				Fragments._ExpressionEdge__OclAny /* 0 */,
				Fragments._ExpressionEdge__OclElement /* 1 */,
				Fragments._ExpressionEdge__Element /* 2 */,
				Fragments._ExpressionEdge__Edge /* 3 */,
				Fragments._ExpressionEdge__ExpressionEdge /* 4 */
			};
		private static final int @NonNull [] __ExpressionEdge = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _IfNode =
			{
				Fragments._IfNode__OclAny /* 0 */,
				Fragments._IfNode__OclElement /* 1 */,
				Fragments._IfNode__ConnectionEnd /* 2 */,
				Fragments._IfNode__Element /* 2 */,
				Fragments._IfNode__Node /* 3 */,
				Fragments._IfNode__MappingNode /* 4 */,
				Fragments._IfNode__OperationNode /* 5 */,
				Fragments._IfNode__IfNode /* 6 */
			};
		private static final int @NonNull [] __IfNode = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _IncludesEdge =
			{
				Fragments._IncludesEdge__OclAny /* 0 */,
				Fragments._IncludesEdge__OclElement /* 1 */,
				Fragments._IncludesEdge__Element /* 2 */,
				Fragments._IncludesEdge__Edge /* 3 */,
				Fragments._IncludesEdge__ExpressionEdge /* 4 */,
				Fragments._IncludesEdge__IncludesEdge /* 5 */
			};
		private static final int @NonNull [] __IncludesEdge = { 1,1,1,1,1,1 };

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
				Fragments._IteratorNode__MappingNode /* 4 */,
				Fragments._IteratorNode__VariableNode /* 5 */,
				Fragments._IteratorNode__IteratorNode /* 6 */
			};
		private static final int @NonNull [] __IteratorNode = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _KeyPartEdge =
			{
				Fragments._KeyPartEdge__OclAny /* 0 */,
				Fragments._KeyPartEdge__OclElement /* 1 */,
				Fragments._KeyPartEdge__Element /* 2 */,
				Fragments._KeyPartEdge__Edge /* 3 */,
				Fragments._KeyPartEdge__ExpressionEdge /* 4 */,
				Fragments._KeyPartEdge__ArgumentEdge /* 5 */,
				Fragments._KeyPartEdge__KeyPartEdge /* 6 */
			};
		private static final int @NonNull [] __KeyPartEdge = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _KeyedValueNode =
			{
				Fragments._KeyedValueNode__OclAny /* 0 */,
				Fragments._KeyedValueNode__OclElement /* 1 */,
				Fragments._KeyedValueNode__ConnectionEnd /* 2 */,
				Fragments._KeyedValueNode__Element /* 2 */,
				Fragments._KeyedValueNode__Node /* 3 */,
				Fragments._KeyedValueNode__MappingNode /* 4 */,
				Fragments._KeyedValueNode__OperationNode /* 5 */,
				Fragments._KeyedValueNode__KeyedValueNode /* 6 */
			};
		private static final int @NonNull [] __KeyedValueNode = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _LoadingPartition =
			{
				Fragments._LoadingPartition__OclAny /* 0 */,
				Fragments._LoadingPartition__OclElement /* 1 */,
				Fragments._LoadingPartition__Element /* 2 */,
				Fragments._LoadingPartition__NamedElement /* 3 */,
				Fragments._LoadingPartition__Partition /* 4 */,
				Fragments._LoadingPartition__MappingPartition /* 5 */,
				Fragments._LoadingPartition__LoadingPartition /* 6 */
			};
		private static final int @NonNull [] __LoadingPartition = { 1,1,1,1,1,1,1 };

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

		private static final @NonNull ExecutorFragment @NonNull [] _MapLiteralNode =
			{
				Fragments._MapLiteralNode__OclAny /* 0 */,
				Fragments._MapLiteralNode__OclElement /* 1 */,
				Fragments._MapLiteralNode__ConnectionEnd /* 2 */,
				Fragments._MapLiteralNode__Element /* 2 */,
				Fragments._MapLiteralNode__Node /* 3 */,
				Fragments._MapLiteralNode__MappingNode /* 4 */,
				Fragments._MapLiteralNode__OperationNode /* 5 */,
				Fragments._MapLiteralNode__MapLiteralNode /* 6 */
			};
		private static final int @NonNull [] __MapLiteralNode = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _MapPartEdge =
			{
				Fragments._MapPartEdge__OclAny /* 0 */,
				Fragments._MapPartEdge__OclElement /* 1 */,
				Fragments._MapPartEdge__Element /* 2 */,
				Fragments._MapPartEdge__Edge /* 3 */,
				Fragments._MapPartEdge__ExpressionEdge /* 4 */,
				Fragments._MapPartEdge__ArgumentEdge /* 5 */,
				Fragments._MapPartEdge__MapPartEdge /* 6 */
			};
		private static final int @NonNull [] __MapPartEdge = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _MapPartNode =
			{
				Fragments._MapPartNode__OclAny /* 0 */,
				Fragments._MapPartNode__OclElement /* 1 */,
				Fragments._MapPartNode__ConnectionEnd /* 2 */,
				Fragments._MapPartNode__Element /* 2 */,
				Fragments._MapPartNode__Node /* 3 */,
				Fragments._MapPartNode__MappingNode /* 4 */,
				Fragments._MapPartNode__OperationNode /* 5 */,
				Fragments._MapPartNode__MapPartNode /* 6 */
			};
		private static final int @NonNull [] __MapPartNode = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _MappingNode =
			{
				Fragments._MappingNode__OclAny /* 0 */,
				Fragments._MappingNode__OclElement /* 1 */,
				Fragments._MappingNode__ConnectionEnd /* 2 */,
				Fragments._MappingNode__Element /* 2 */,
				Fragments._MappingNode__Node /* 3 */,
				Fragments._MappingNode__MappingNode /* 4 */
			};
		private static final int @NonNull [] __MappingNode = { 1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _MappingPartition =
			{
				Fragments._MappingPartition__OclAny /* 0 */,
				Fragments._MappingPartition__OclElement /* 1 */,
				Fragments._MappingPartition__Element /* 2 */,
				Fragments._MappingPartition__NamedElement /* 3 */,
				Fragments._MappingPartition__Partition /* 4 */,
				Fragments._MappingPartition__MappingPartition /* 5 */
			};
		private static final int @NonNull [] __MappingPartition = { 1,1,1,1,1,1 };

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
				Fragments._NodeConnection__NodeConnection /* 4 */
			};
		private static final int @NonNull [] __NodeConnection = { 1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _NonPartition =
			{
				Fragments._NonPartition__OclAny /* 0 */,
				Fragments._NonPartition__OclElement /* 1 */,
				Fragments._NonPartition__Element /* 2 */,
				Fragments._NonPartition__NamedElement /* 3 */,
				Fragments._NonPartition__Partition /* 4 */,
				Fragments._NonPartition__MappingPartition /* 5 */,
				Fragments._NonPartition__NonPartition /* 6 */
			};
		private static final int @NonNull [] __NonPartition = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _NullLiteralNode =
			{
				Fragments._NullLiteralNode__OclAny /* 0 */,
				Fragments._NullLiteralNode__OclElement /* 1 */,
				Fragments._NullLiteralNode__ConnectionEnd /* 2 */,
				Fragments._NullLiteralNode__Element /* 2 */,
				Fragments._NullLiteralNode__Node /* 3 */,
				Fragments._NullLiteralNode__MappingNode /* 4 */,
				Fragments._NullLiteralNode__OperationNode /* 5 */,
				Fragments._NullLiteralNode__NullLiteralNode /* 6 */
			};
		private static final int @NonNull [] __NullLiteralNode = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Number =
			{
				Fragments._Number__OclAny /* 0 */,
				Fragments._Number__Number /* 1 */
			};
		private static final int @NonNull [] __Number = { 1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _NumericLiteralNode =
			{
				Fragments._NumericLiteralNode__OclAny /* 0 */,
				Fragments._NumericLiteralNode__OclElement /* 1 */,
				Fragments._NumericLiteralNode__ConnectionEnd /* 2 */,
				Fragments._NumericLiteralNode__Element /* 2 */,
				Fragments._NumericLiteralNode__Node /* 3 */,
				Fragments._NumericLiteralNode__MappingNode /* 4 */,
				Fragments._NumericLiteralNode__OperationNode /* 5 */,
				Fragments._NumericLiteralNode__NumericLiteralNode /* 6 */
			};
		private static final int @NonNull [] __NumericLiteralNode = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OperationCallNode =
			{
				Fragments._OperationCallNode__OclAny /* 0 */,
				Fragments._OperationCallNode__OclElement /* 1 */,
				Fragments._OperationCallNode__ConnectionEnd /* 2 */,
				Fragments._OperationCallNode__Element /* 2 */,
				Fragments._OperationCallNode__Node /* 3 */,
				Fragments._OperationCallNode__MappingNode /* 4 */,
				Fragments._OperationCallNode__OperationNode /* 5 */,
				Fragments._OperationCallNode__OperationCallNode /* 6 */
			};
		private static final int @NonNull [] __OperationCallNode = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OperationNode =
			{
				Fragments._OperationNode__OclAny /* 0 */,
				Fragments._OperationNode__OclElement /* 1 */,
				Fragments._OperationNode__ConnectionEnd /* 2 */,
				Fragments._OperationNode__Element /* 2 */,
				Fragments._OperationNode__Node /* 3 */,
				Fragments._OperationNode__MappingNode /* 4 */,
				Fragments._OperationNode__OperationNode /* 5 */
			};
		private static final int @NonNull [] __OperationNode = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OperationParameterEdge =
			{
				Fragments._OperationParameterEdge__OclAny /* 0 */,
				Fragments._OperationParameterEdge__OclElement /* 1 */,
				Fragments._OperationParameterEdge__Element /* 2 */,
				Fragments._OperationParameterEdge__Edge /* 3 */,
				Fragments._OperationParameterEdge__ExpressionEdge /* 4 */,
				Fragments._OperationParameterEdge__ArgumentEdge /* 5 */,
				Fragments._OperationParameterEdge__OperationParameterEdge /* 6 */
			};
		private static final int @NonNull [] __OperationParameterEdge = { 1,1,1,1,1,1,1 };

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

		private static final @NonNull ExecutorFragment @NonNull [] _OperationSelfEdge =
			{
				Fragments._OperationSelfEdge__OclAny /* 0 */,
				Fragments._OperationSelfEdge__OclElement /* 1 */,
				Fragments._OperationSelfEdge__Element /* 2 */,
				Fragments._OperationSelfEdge__Edge /* 3 */,
				Fragments._OperationSelfEdge__ExpressionEdge /* 4 */,
				Fragments._OperationSelfEdge__ArgumentEdge /* 5 */,
				Fragments._OperationSelfEdge__OperationSelfEdge /* 6 */
			};
		private static final int @NonNull [] __OperationSelfEdge = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Partition =
			{
				Fragments._Partition__OclAny /* 0 */,
				Fragments._Partition__OclElement /* 1 */,
				Fragments._Partition__Element /* 2 */,
				Fragments._Partition__NamedElement /* 3 */,
				Fragments._Partition__Partition /* 4 */
			};
		private static final int @NonNull [] __Partition = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _PatternTypedNode =
			{
				Fragments._PatternTypedNode__OclAny /* 0 */,
				Fragments._PatternTypedNode__OclElement /* 1 */,
				Fragments._PatternTypedNode__ConnectionEnd /* 2 */,
				Fragments._PatternTypedNode__Element /* 2 */,
				Fragments._PatternTypedNode__Node /* 3 */,
				Fragments._PatternTypedNode__MappingNode /* 4 */,
				Fragments._PatternTypedNode__PatternTypedNode /* 5 */
			};
		private static final int @NonNull [] __PatternTypedNode = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _PatternVariableNode =
			{
				Fragments._PatternVariableNode__OclAny /* 0 */,
				Fragments._PatternVariableNode__OclElement /* 1 */,
				Fragments._PatternVariableNode__ConnectionEnd /* 2 */,
				Fragments._PatternVariableNode__Element /* 2 */,
				Fragments._PatternVariableNode__Node /* 3 */,
				Fragments._PatternVariableNode__MappingNode /* 4 */,
				Fragments._PatternVariableNode__VariableNode /* 5 */,
				Fragments._PatternVariableNode__PatternVariableNode /* 6 */
			};
		private static final int @NonNull [] __PatternVariableNode = { 1,1,2,1,1,1,1 };

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

		private static final @NonNull ExecutorFragment @NonNull [] _RootPartition =
			{
				Fragments._RootPartition__OclAny /* 0 */,
				Fragments._RootPartition__OclElement /* 1 */,
				Fragments._RootPartition__Element /* 2 */,
				Fragments._RootPartition__NamedElement /* 3 */,
				Fragments._RootPartition__Partition /* 4 */,
				Fragments._RootPartition__CompositePartition /* 5 */,
				Fragments._RootPartition__RootPartition /* 6 */
			};
		private static final int @NonNull [] __RootPartition = { 1,1,1,1,1,1,1 };

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

		private static final @NonNull ExecutorFragment @NonNull [] _ShadowNode =
			{
				Fragments._ShadowNode__OclAny /* 0 */,
				Fragments._ShadowNode__OclElement /* 1 */,
				Fragments._ShadowNode__ConnectionEnd /* 2 */,
				Fragments._ShadowNode__Element /* 2 */,
				Fragments._ShadowNode__Node /* 3 */,
				Fragments._ShadowNode__MappingNode /* 4 */,
				Fragments._ShadowNode__OperationNode /* 5 */,
				Fragments._ShadowNode__ShadowNode /* 6 */
			};
		private static final int @NonNull [] __ShadowNode = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ShadowPartEdge =
			{
				Fragments._ShadowPartEdge__OclAny /* 0 */,
				Fragments._ShadowPartEdge__OclElement /* 1 */,
				Fragments._ShadowPartEdge__Element /* 2 */,
				Fragments._ShadowPartEdge__Edge /* 3 */,
				Fragments._ShadowPartEdge__ExpressionEdge /* 4 */,
				Fragments._ShadowPartEdge__ArgumentEdge /* 5 */,
				Fragments._ShadowPartEdge__ShadowPartEdge /* 6 */
			};
		private static final int @NonNull [] __ShadowPartEdge = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _StringLiteralNode =
			{
				Fragments._StringLiteralNode__OclAny /* 0 */,
				Fragments._StringLiteralNode__OclElement /* 1 */,
				Fragments._StringLiteralNode__ConnectionEnd /* 2 */,
				Fragments._StringLiteralNode__Element /* 2 */,
				Fragments._StringLiteralNode__Node /* 3 */,
				Fragments._StringLiteralNode__MappingNode /* 4 */,
				Fragments._StringLiteralNode__OperationNode /* 5 */,
				Fragments._StringLiteralNode__StringLiteralNode /* 6 */
			};
		private static final int @NonNull [] __StringLiteralNode = { 1,1,2,1,1,1,1 };

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
				Fragments._SuccessNode__MappingNode /* 4 */,
				Fragments._SuccessNode__SuccessNode /* 5 */
			};
		private static final int @NonNull [] __SuccessNode = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Symbolable =
			{
				Fragments._Symbolable__OclAny /* 0 */,
				Fragments._Symbolable__OclElement /* 1 */,
				Fragments._Symbolable__Symbolable /* 2 */
			};
		private static final int @NonNull [] __Symbolable = { 1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _TupleLiteralNode =
			{
				Fragments._TupleLiteralNode__OclAny /* 0 */,
				Fragments._TupleLiteralNode__OclElement /* 1 */,
				Fragments._TupleLiteralNode__ConnectionEnd /* 2 */,
				Fragments._TupleLiteralNode__Element /* 2 */,
				Fragments._TupleLiteralNode__Node /* 3 */,
				Fragments._TupleLiteralNode__MappingNode /* 4 */,
				Fragments._TupleLiteralNode__OperationNode /* 5 */,
				Fragments._TupleLiteralNode__TupleLiteralNode /* 6 */
			};
		private static final int @NonNull [] __TupleLiteralNode = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _TuplePartEdge =
			{
				Fragments._TuplePartEdge__OclAny /* 0 */,
				Fragments._TuplePartEdge__OclElement /* 1 */,
				Fragments._TuplePartEdge__Element /* 2 */,
				Fragments._TuplePartEdge__Edge /* 3 */,
				Fragments._TuplePartEdge__ExpressionEdge /* 4 */,
				Fragments._TuplePartEdge__ArgumentEdge /* 5 */,
				Fragments._TuplePartEdge__TuplePartEdge /* 6 */
			};
		private static final int @NonNull [] __TuplePartEdge = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _TypeLiteralNode =
			{
				Fragments._TypeLiteralNode__OclAny /* 0 */,
				Fragments._TypeLiteralNode__OclElement /* 1 */,
				Fragments._TypeLiteralNode__ConnectionEnd /* 2 */,
				Fragments._TypeLiteralNode__Element /* 2 */,
				Fragments._TypeLiteralNode__Node /* 3 */,
				Fragments._TypeLiteralNode__MappingNode /* 4 */,
				Fragments._TypeLiteralNode__OperationNode /* 5 */,
				Fragments._TypeLiteralNode__TypeLiteralNode /* 6 */
			};
		private static final int @NonNull [] __TypeLiteralNode = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _UnknownNode =
			{
				Fragments._UnknownNode__OclAny /* 0 */,
				Fragments._UnknownNode__OclElement /* 1 */,
				Fragments._UnknownNode__ConnectionEnd /* 2 */,
				Fragments._UnknownNode__Element /* 2 */,
				Fragments._UnknownNode__Node /* 3 */,
				Fragments._UnknownNode__MappingNode /* 4 */,
				Fragments._UnknownNode__UnknownNode /* 5 */
			};
		private static final int @NonNull [] __UnknownNode = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _VariableNode =
			{
				Fragments._VariableNode__OclAny /* 0 */,
				Fragments._VariableNode__OclElement /* 1 */,
				Fragments._VariableNode__ConnectionEnd /* 2 */,
				Fragments._VariableNode__Element /* 2 */,
				Fragments._VariableNode__Node /* 3 */,
				Fragments._VariableNode__MappingNode /* 4 */,
				Fragments._VariableNode__VariableNode /* 5 */
			};
		private static final int @NonNull [] __VariableNode = { 1,1,2,1,1,1 };

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
			Types._ArgumentEdge.initFragments(_ArgumentEdge, __ArgumentEdge);
			Types._BasicPartition.initFragments(_BasicPartition, __BasicPartition);
			Types._BooleanLiteralNode.initFragments(_BooleanLiteralNode, __BooleanLiteralNode);
			Types._CastEdge.initFragments(_CastEdge, __CastEdge);
			Types._ClassDatum.initFragments(_ClassDatum, __ClassDatum);
			Types._Cluster.initFragments(_Cluster, __Cluster);
			Types._CollectionLiteralNode.initFragments(_CollectionLiteralNode, __CollectionLiteralNode);
			Types._CollectionPartEdge.initFragments(_CollectionPartEdge, __CollectionPartEdge);
			Types._CollectionRangeNode.initFragments(_CollectionRangeNode, __CollectionRangeNode);
			Types._ComposedNode.initFragments(_ComposedNode, __ComposedNode);
			Types._CompositePartition.initFragments(_CompositePartition, __CompositePartition);
			Types._Connection.initFragments(_Connection, __Connection);
			Types._ConnectionEnd.initFragments(_ConnectionEnd, __ConnectionEnd);
			Types._ConnectionRole.initFragments(_ConnectionRole, __ConnectionRole);
			Types._CyclicMappingRegion.initFragments(_CyclicMappingRegion, __CyclicMappingRegion);
			Types._CyclicPartition.initFragments(_CyclicPartition, __CyclicPartition);
			Types._DependencyEdge.initFragments(_DependencyEdge, __DependencyEdge);
			Types._DependencyNode.initFragments(_DependencyNode, __DependencyNode);
			Types._DispatchRegion.initFragments(_DispatchRegion, __DispatchRegion);
			Types._Edge.initFragments(_Edge, __Edge);
			Types._EdgeConnection.initFragments(_EdgeConnection, __EdgeConnection);
			Types._EnumLiteralNode.initFragments(_EnumLiteralNode, __EnumLiteralNode);
			Types._ErrorNode.initFragments(_ErrorNode, __ErrorNode);
			Types._ExpressionEdge.initFragments(_ExpressionEdge, __ExpressionEdge);
			Types._IfNode.initFragments(_IfNode, __IfNode);
			Types._IncludesEdge.initFragments(_IncludesEdge, __IncludesEdge);
			Types._InputNode.initFragments(_InputNode, __InputNode);
			Types._IteratedEdge.initFragments(_IteratedEdge, __IteratedEdge);
			Types._IteratorNode.initFragments(_IteratorNode, __IteratorNode);
			Types._KeyPartEdge.initFragments(_KeyPartEdge, __KeyPartEdge);
			Types._KeyedValueNode.initFragments(_KeyedValueNode, __KeyedValueNode);
			Types._LoadingPartition.initFragments(_LoadingPartition, __LoadingPartition);
			Types._LoadingRegion.initFragments(_LoadingRegion, __LoadingRegion);
			Types._MapLiteralNode.initFragments(_MapLiteralNode, __MapLiteralNode);
			Types._MapPartEdge.initFragments(_MapPartEdge, __MapPartEdge);
			Types._MapPartNode.initFragments(_MapPartNode, __MapPartNode);
			Types._MappingNode.initFragments(_MappingNode, __MappingNode);
			Types._MappingPartition.initFragments(_MappingPartition, __MappingPartition);
			Types._MappingRegion.initFragments(_MappingRegion, __MappingRegion);
			Types._MicroMappingRegion.initFragments(_MicroMappingRegion, __MicroMappingRegion);
			Types._NamedMappingRegion.initFragments(_NamedMappingRegion, __NamedMappingRegion);
			Types._NavigableEdge.initFragments(_NavigableEdge, __NavigableEdge);
			Types._NavigationEdge.initFragments(_NavigationEdge, __NavigationEdge);
			Types._Node.initFragments(_Node, __Node);
			Types._NodeConnection.initFragments(_NodeConnection, __NodeConnection);
			Types._NonPartition.initFragments(_NonPartition, __NonPartition);
			Types._NullLiteralNode.initFragments(_NullLiteralNode, __NullLiteralNode);
			Types._Number.initFragments(_Number, __Number);
			Types._NumericLiteralNode.initFragments(_NumericLiteralNode, __NumericLiteralNode);
			Types._OperationCallNode.initFragments(_OperationCallNode, __OperationCallNode);
			Types._OperationNode.initFragments(_OperationNode, __OperationNode);
			Types._OperationParameterEdge.initFragments(_OperationParameterEdge, __OperationParameterEdge);
			Types._OperationRegion.initFragments(_OperationRegion, __OperationRegion);
			Types._OperationSelfEdge.initFragments(_OperationSelfEdge, __OperationSelfEdge);
			Types._Partition.initFragments(_Partition, __Partition);
			Types._PatternTypedNode.initFragments(_PatternTypedNode, __PatternTypedNode);
			Types._PatternVariableNode.initFragments(_PatternVariableNode, __PatternVariableNode);
			Types._PredicateEdge.initFragments(_PredicateEdge, __PredicateEdge);
			Types._PropertyDatum.initFragments(_PropertyDatum, __PropertyDatum);
			Types._RecursionEdge.initFragments(_RecursionEdge, __RecursionEdge);
			Types._Region.initFragments(_Region, __Region);
			Types._Role.initFragments(_Role, __Role);
			Types._RootPartition.initFragments(_RootPartition, __RootPartition);
			Types._RuleRegion.initFragments(_RuleRegion, __RuleRegion);
			Types._ScheduleModel.initFragments(_ScheduleModel, __ScheduleModel);
			Types._ScheduledRegion.initFragments(_ScheduledRegion, __ScheduledRegion);
			Types._ShadowNode.initFragments(_ShadowNode, __ShadowNode);
			Types._ShadowPartEdge.initFragments(_ShadowPartEdge, __ShadowPartEdge);
			Types._StringLiteralNode.initFragments(_StringLiteralNode, __StringLiteralNode);
			Types._SuccessEdge.initFragments(_SuccessEdge, __SuccessEdge);
			Types._SuccessNode.initFragments(_SuccessNode, __SuccessNode);
			Types._Symbolable.initFragments(_Symbolable, __Symbolable);
			Types._TupleLiteralNode.initFragments(_TupleLiteralNode, __TupleLiteralNode);
			Types._TuplePartEdge.initFragments(_TuplePartEdge, __TuplePartEdge);
			Types._TypeLiteralNode.initFragments(_TypeLiteralNode, __TypeLiteralNode);
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

		private static final @NonNull ExecutorOperation @NonNull [] _ArgumentEdge__ArgumentEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ArgumentEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ArgumentEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ArgumentEdge__ExpressionEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ArgumentEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ArgumentEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _BasicPartition__BasicPartition = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BasicPartition__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _BasicPartition__MappingPartition = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BasicPartition__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BasicPartition__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _BasicPartition__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _BasicPartition__Partition = {};

		private static final @NonNull ExecutorOperation @NonNull [] _BooleanLiteralNode__BooleanLiteralNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanLiteralNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanLiteralNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanLiteralNode__MappingNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanLiteralNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanLiteralNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanLiteralNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanLiteralNode__OperationNode = {};

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

		private static final @NonNull ExecutorOperation @NonNull [] _Cluster__Cluster = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Cluster__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Cluster__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Cluster__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Cluster__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Cluster__Symbolable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralNode__CollectionLiteralNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralNode__MappingNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralNode__OperationNode = {};

		private static final @NonNull ExecutorOperation @NonNull [] _CollectionPartEdge__CollectionPartEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionPartEdge__ArgumentEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionPartEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionPartEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionPartEdge__ExpressionEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionPartEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionPartEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _CollectionRangeNode__CollectionRangeNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionRangeNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionRangeNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionRangeNode__MappingNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionRangeNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionRangeNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionRangeNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionRangeNode__OperationNode = {};

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

		private static final @NonNull ExecutorOperation @NonNull [] _CompositePartition__CompositePartition = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CompositePartition__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CompositePartition__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CompositePartition__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _CompositePartition__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CompositePartition__Partition = {};

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

		private static final @NonNull ExecutorOperation @NonNull [] _CyclicMappingRegion__CyclicMappingRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CyclicMappingRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CyclicMappingRegion__MappingRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CyclicMappingRegion__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CyclicMappingRegion__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _CyclicMappingRegion__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CyclicMappingRegion__Region = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CyclicMappingRegion__Symbolable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _CyclicPartition__CyclicPartition = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CyclicPartition__CompositePartition = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CyclicPartition__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CyclicPartition__MappingPartition = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CyclicPartition__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CyclicPartition__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _CyclicPartition__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CyclicPartition__Partition = {};

		private static final @NonNull ExecutorOperation @NonNull [] _DependencyEdge__DependencyEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DependencyEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DependencyEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _DependencyEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _DependencyEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

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

		private static final @NonNull ExecutorOperation @NonNull [] _EnumLiteralNode__EnumLiteralNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _EnumLiteralNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _EnumLiteralNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _EnumLiteralNode__MappingNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _EnumLiteralNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _EnumLiteralNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _EnumLiteralNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _EnumLiteralNode__OperationNode = {};

		private static final @NonNull ExecutorOperation @NonNull [] _ErrorNode__ErrorNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ErrorNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ErrorNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ErrorNode__MappingNode = {};
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

		private static final @NonNull ExecutorOperation @NonNull [] _IfNode__IfNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IfNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IfNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _IfNode__MappingNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IfNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IfNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _IfNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _IfNode__OperationNode = {};

		private static final @NonNull ExecutorOperation @NonNull [] _IncludesEdge__IncludesEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IncludesEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IncludesEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _IncludesEdge__ExpressionEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IncludesEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _IncludesEdge__OclElement = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorNode__MappingNode = {};
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

		private static final @NonNull ExecutorOperation @NonNull [] _KeyPartEdge__KeyPartEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _KeyPartEdge__ArgumentEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _KeyPartEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _KeyPartEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _KeyPartEdge__ExpressionEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _KeyPartEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _KeyPartEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _KeyedValueNode__KeyedValueNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _KeyedValueNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _KeyedValueNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _KeyedValueNode__MappingNode = {};
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

		private static final @NonNull ExecutorOperation @NonNull [] _LoadingPartition__LoadingPartition = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LoadingPartition__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _LoadingPartition__MappingPartition = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LoadingPartition__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LoadingPartition__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _LoadingPartition__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _LoadingPartition__Partition = {};

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

		private static final @NonNull ExecutorOperation @NonNull [] _MapLiteralNode__MapLiteralNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MapLiteralNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MapLiteralNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MapLiteralNode__MappingNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MapLiteralNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MapLiteralNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _MapLiteralNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MapLiteralNode__OperationNode = {};

		private static final @NonNull ExecutorOperation @NonNull [] _MapPartEdge__MapPartEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MapPartEdge__ArgumentEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MapPartEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MapPartEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MapPartEdge__ExpressionEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MapPartEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _MapPartEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _MapPartNode__MapPartNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MapPartNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MapPartNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MapPartNode__MappingNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MapPartNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MapPartNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _MapPartNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MapPartNode__OperationNode = {};

		private static final @NonNull ExecutorOperation @NonNull [] _MappingNode__MappingNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _MappingNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _MappingPartition__MappingPartition = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingPartition__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingPartition__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingPartition__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _MappingPartition__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingPartition__Partition = {};

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

		private static final @NonNull ExecutorOperation @NonNull [] _NonPartition__NonPartition = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NonPartition__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NonPartition__MappingPartition = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NonPartition__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NonPartition__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _NonPartition__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NonPartition__Partition = {};

		private static final @NonNull ExecutorOperation @NonNull [] _NullLiteralNode__NullLiteralNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NullLiteralNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NullLiteralNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NullLiteralNode__MappingNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NullLiteralNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NullLiteralNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _NullLiteralNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NullLiteralNode__OperationNode = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Number__Number = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Number__OclAny = {
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

		private static final @NonNull ExecutorOperation @NonNull [] _NumericLiteralNode__NumericLiteralNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NumericLiteralNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NumericLiteralNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NumericLiteralNode__MappingNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NumericLiteralNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NumericLiteralNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _NumericLiteralNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NumericLiteralNode__OperationNode = {};

		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallNode__OperationCallNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallNode__MappingNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallNode__OperationNode = {};

		private static final @NonNull ExecutorOperation @NonNull [] _OperationNode__OperationNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationNode__MappingNode = {};
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

		private static final @NonNull ExecutorOperation @NonNull [] _OperationParameterEdge__OperationParameterEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationParameterEdge__ArgumentEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationParameterEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationParameterEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationParameterEdge__ExpressionEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationParameterEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _OperationParameterEdge__OclElement = {
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

		private static final @NonNull ExecutorOperation @NonNull [] _OperationSelfEdge__OperationSelfEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationSelfEdge__ArgumentEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationSelfEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationSelfEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationSelfEdge__ExpressionEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationSelfEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _OperationSelfEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Partition__Partition = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Partition__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Partition__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Partition__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Partition__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _PatternTypedNode__PatternTypedNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternTypedNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternTypedNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternTypedNode__MappingNode = {};
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
		private static final @NonNull ExecutorOperation @NonNull [] _PatternVariableNode__MappingNode = {};
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

		private static final @NonNull ExecutorOperation @NonNull [] _RootPartition__RootPartition = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RootPartition__CompositePartition = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RootPartition__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RootPartition__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RootPartition__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _RootPartition__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RootPartition__Partition = {};

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

		private static final @NonNull ExecutorOperation @NonNull [] _ShadowNode__ShadowNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ShadowNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ShadowNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ShadowNode__MappingNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ShadowNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ShadowNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ShadowNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ShadowNode__OperationNode = {};

		private static final @NonNull ExecutorOperation @NonNull [] _ShadowPartEdge__ShadowPartEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ShadowPartEdge__ArgumentEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ShadowPartEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ShadowPartEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ShadowPartEdge__ExpressionEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ShadowPartEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ShadowPartEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _StringLiteralNode__StringLiteralNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _StringLiteralNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _StringLiteralNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _StringLiteralNode__MappingNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _StringLiteralNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _StringLiteralNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _StringLiteralNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _StringLiteralNode__OperationNode = {};

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
		private static final @NonNull ExecutorOperation @NonNull [] _SuccessNode__MappingNode = {};
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

		private static final @NonNull ExecutorOperation @NonNull [] _TupleLiteralNode__TupleLiteralNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TupleLiteralNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TupleLiteralNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TupleLiteralNode__MappingNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TupleLiteralNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TupleLiteralNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _TupleLiteralNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TupleLiteralNode__OperationNode = {};

		private static final @NonNull ExecutorOperation @NonNull [] _TuplePartEdge__TuplePartEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TuplePartEdge__ArgumentEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TuplePartEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TuplePartEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TuplePartEdge__ExpressionEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TuplePartEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _TuplePartEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _TypeLiteralNode__TypeLiteralNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TypeLiteralNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TypeLiteralNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TypeLiteralNode__MappingNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TypeLiteralNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TypeLiteralNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _TypeLiteralNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TypeLiteralNode__OperationNode = {};

		private static final @NonNull ExecutorOperation @NonNull [] _UnknownNode__UnknownNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _UnknownNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _UnknownNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _UnknownNode__MappingNode = {};
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
		private static final @NonNull ExecutorOperation @NonNull [] _VariableNode__MappingNode = {};
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

			Fragments._ArgumentEdge__ArgumentEdge.initOperations(_ArgumentEdge__ArgumentEdge);
			Fragments._ArgumentEdge__Edge.initOperations(_ArgumentEdge__Edge);
			Fragments._ArgumentEdge__Element.initOperations(_ArgumentEdge__Element);
			Fragments._ArgumentEdge__ExpressionEdge.initOperations(_ArgumentEdge__ExpressionEdge);
			Fragments._ArgumentEdge__OclAny.initOperations(_ArgumentEdge__OclAny);
			Fragments._ArgumentEdge__OclElement.initOperations(_ArgumentEdge__OclElement);

			Fragments._BasicPartition__BasicPartition.initOperations(_BasicPartition__BasicPartition);
			Fragments._BasicPartition__Element.initOperations(_BasicPartition__Element);
			Fragments._BasicPartition__MappingPartition.initOperations(_BasicPartition__MappingPartition);
			Fragments._BasicPartition__NamedElement.initOperations(_BasicPartition__NamedElement);
			Fragments._BasicPartition__OclAny.initOperations(_BasicPartition__OclAny);
			Fragments._BasicPartition__OclElement.initOperations(_BasicPartition__OclElement);
			Fragments._BasicPartition__Partition.initOperations(_BasicPartition__Partition);

			Fragments._BooleanLiteralNode__BooleanLiteralNode.initOperations(_BooleanLiteralNode__BooleanLiteralNode);
			Fragments._BooleanLiteralNode__ConnectionEnd.initOperations(_BooleanLiteralNode__ConnectionEnd);
			Fragments._BooleanLiteralNode__Element.initOperations(_BooleanLiteralNode__Element);
			Fragments._BooleanLiteralNode__MappingNode.initOperations(_BooleanLiteralNode__MappingNode);
			Fragments._BooleanLiteralNode__Node.initOperations(_BooleanLiteralNode__Node);
			Fragments._BooleanLiteralNode__OclAny.initOperations(_BooleanLiteralNode__OclAny);
			Fragments._BooleanLiteralNode__OclElement.initOperations(_BooleanLiteralNode__OclElement);
			Fragments._BooleanLiteralNode__OperationNode.initOperations(_BooleanLiteralNode__OperationNode);

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

			Fragments._Cluster__Cluster.initOperations(_Cluster__Cluster);
			Fragments._Cluster__Element.initOperations(_Cluster__Element);
			Fragments._Cluster__NamedElement.initOperations(_Cluster__NamedElement);
			Fragments._Cluster__OclAny.initOperations(_Cluster__OclAny);
			Fragments._Cluster__OclElement.initOperations(_Cluster__OclElement);
			Fragments._Cluster__Symbolable.initOperations(_Cluster__Symbolable);

			Fragments._CollectionLiteralNode__CollectionLiteralNode.initOperations(_CollectionLiteralNode__CollectionLiteralNode);
			Fragments._CollectionLiteralNode__ConnectionEnd.initOperations(_CollectionLiteralNode__ConnectionEnd);
			Fragments._CollectionLiteralNode__Element.initOperations(_CollectionLiteralNode__Element);
			Fragments._CollectionLiteralNode__MappingNode.initOperations(_CollectionLiteralNode__MappingNode);
			Fragments._CollectionLiteralNode__Node.initOperations(_CollectionLiteralNode__Node);
			Fragments._CollectionLiteralNode__OclAny.initOperations(_CollectionLiteralNode__OclAny);
			Fragments._CollectionLiteralNode__OclElement.initOperations(_CollectionLiteralNode__OclElement);
			Fragments._CollectionLiteralNode__OperationNode.initOperations(_CollectionLiteralNode__OperationNode);

			Fragments._CollectionPartEdge__ArgumentEdge.initOperations(_CollectionPartEdge__ArgumentEdge);
			Fragments._CollectionPartEdge__CollectionPartEdge.initOperations(_CollectionPartEdge__CollectionPartEdge);
			Fragments._CollectionPartEdge__Edge.initOperations(_CollectionPartEdge__Edge);
			Fragments._CollectionPartEdge__Element.initOperations(_CollectionPartEdge__Element);
			Fragments._CollectionPartEdge__ExpressionEdge.initOperations(_CollectionPartEdge__ExpressionEdge);
			Fragments._CollectionPartEdge__OclAny.initOperations(_CollectionPartEdge__OclAny);
			Fragments._CollectionPartEdge__OclElement.initOperations(_CollectionPartEdge__OclElement);

			Fragments._CollectionRangeNode__CollectionRangeNode.initOperations(_CollectionRangeNode__CollectionRangeNode);
			Fragments._CollectionRangeNode__ConnectionEnd.initOperations(_CollectionRangeNode__ConnectionEnd);
			Fragments._CollectionRangeNode__Element.initOperations(_CollectionRangeNode__Element);
			Fragments._CollectionRangeNode__MappingNode.initOperations(_CollectionRangeNode__MappingNode);
			Fragments._CollectionRangeNode__Node.initOperations(_CollectionRangeNode__Node);
			Fragments._CollectionRangeNode__OclAny.initOperations(_CollectionRangeNode__OclAny);
			Fragments._CollectionRangeNode__OclElement.initOperations(_CollectionRangeNode__OclElement);
			Fragments._CollectionRangeNode__OperationNode.initOperations(_CollectionRangeNode__OperationNode);

			Fragments._ComposedNode__ComposedNode.initOperations(_ComposedNode__ComposedNode);
			Fragments._ComposedNode__ConnectionEnd.initOperations(_ComposedNode__ConnectionEnd);
			Fragments._ComposedNode__Element.initOperations(_ComposedNode__Element);
			Fragments._ComposedNode__Node.initOperations(_ComposedNode__Node);
			Fragments._ComposedNode__OclAny.initOperations(_ComposedNode__OclAny);
			Fragments._ComposedNode__OclElement.initOperations(_ComposedNode__OclElement);

			Fragments._CompositePartition__CompositePartition.initOperations(_CompositePartition__CompositePartition);
			Fragments._CompositePartition__Element.initOperations(_CompositePartition__Element);
			Fragments._CompositePartition__NamedElement.initOperations(_CompositePartition__NamedElement);
			Fragments._CompositePartition__OclAny.initOperations(_CompositePartition__OclAny);
			Fragments._CompositePartition__OclElement.initOperations(_CompositePartition__OclElement);
			Fragments._CompositePartition__Partition.initOperations(_CompositePartition__Partition);

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

			Fragments._CyclicMappingRegion__CyclicMappingRegion.initOperations(_CyclicMappingRegion__CyclicMappingRegion);
			Fragments._CyclicMappingRegion__Element.initOperations(_CyclicMappingRegion__Element);
			Fragments._CyclicMappingRegion__MappingRegion.initOperations(_CyclicMappingRegion__MappingRegion);
			Fragments._CyclicMappingRegion__NamedElement.initOperations(_CyclicMappingRegion__NamedElement);
			Fragments._CyclicMappingRegion__OclAny.initOperations(_CyclicMappingRegion__OclAny);
			Fragments._CyclicMappingRegion__OclElement.initOperations(_CyclicMappingRegion__OclElement);
			Fragments._CyclicMappingRegion__Region.initOperations(_CyclicMappingRegion__Region);
			Fragments._CyclicMappingRegion__Symbolable.initOperations(_CyclicMappingRegion__Symbolable);

			Fragments._CyclicPartition__CompositePartition.initOperations(_CyclicPartition__CompositePartition);
			Fragments._CyclicPartition__CyclicPartition.initOperations(_CyclicPartition__CyclicPartition);
			Fragments._CyclicPartition__Element.initOperations(_CyclicPartition__Element);
			Fragments._CyclicPartition__MappingPartition.initOperations(_CyclicPartition__MappingPartition);
			Fragments._CyclicPartition__NamedElement.initOperations(_CyclicPartition__NamedElement);
			Fragments._CyclicPartition__OclAny.initOperations(_CyclicPartition__OclAny);
			Fragments._CyclicPartition__OclElement.initOperations(_CyclicPartition__OclElement);
			Fragments._CyclicPartition__Partition.initOperations(_CyclicPartition__Partition);

			Fragments._DependencyEdge__DependencyEdge.initOperations(_DependencyEdge__DependencyEdge);
			Fragments._DependencyEdge__Edge.initOperations(_DependencyEdge__Edge);
			Fragments._DependencyEdge__Element.initOperations(_DependencyEdge__Element);
			Fragments._DependencyEdge__OclAny.initOperations(_DependencyEdge__OclAny);
			Fragments._DependencyEdge__OclElement.initOperations(_DependencyEdge__OclElement);

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
			Fragments._EdgeConnection__EdgeConnection.initOperations(_EdgeConnection__EdgeConnection);
			Fragments._EdgeConnection__Element.initOperations(_EdgeConnection__Element);
			Fragments._EdgeConnection__OclAny.initOperations(_EdgeConnection__OclAny);
			Fragments._EdgeConnection__OclElement.initOperations(_EdgeConnection__OclElement);
			Fragments._EdgeConnection__Symbolable.initOperations(_EdgeConnection__Symbolable);

			Fragments._EnumLiteralNode__ConnectionEnd.initOperations(_EnumLiteralNode__ConnectionEnd);
			Fragments._EnumLiteralNode__Element.initOperations(_EnumLiteralNode__Element);
			Fragments._EnumLiteralNode__EnumLiteralNode.initOperations(_EnumLiteralNode__EnumLiteralNode);
			Fragments._EnumLiteralNode__MappingNode.initOperations(_EnumLiteralNode__MappingNode);
			Fragments._EnumLiteralNode__Node.initOperations(_EnumLiteralNode__Node);
			Fragments._EnumLiteralNode__OclAny.initOperations(_EnumLiteralNode__OclAny);
			Fragments._EnumLiteralNode__OclElement.initOperations(_EnumLiteralNode__OclElement);
			Fragments._EnumLiteralNode__OperationNode.initOperations(_EnumLiteralNode__OperationNode);

			Fragments._ErrorNode__ConnectionEnd.initOperations(_ErrorNode__ConnectionEnd);
			Fragments._ErrorNode__Element.initOperations(_ErrorNode__Element);
			Fragments._ErrorNode__ErrorNode.initOperations(_ErrorNode__ErrorNode);
			Fragments._ErrorNode__MappingNode.initOperations(_ErrorNode__MappingNode);
			Fragments._ErrorNode__Node.initOperations(_ErrorNode__Node);
			Fragments._ErrorNode__OclAny.initOperations(_ErrorNode__OclAny);
			Fragments._ErrorNode__OclElement.initOperations(_ErrorNode__OclElement);

			Fragments._ExpressionEdge__Edge.initOperations(_ExpressionEdge__Edge);
			Fragments._ExpressionEdge__Element.initOperations(_ExpressionEdge__Element);
			Fragments._ExpressionEdge__ExpressionEdge.initOperations(_ExpressionEdge__ExpressionEdge);
			Fragments._ExpressionEdge__OclAny.initOperations(_ExpressionEdge__OclAny);
			Fragments._ExpressionEdge__OclElement.initOperations(_ExpressionEdge__OclElement);

			Fragments._IfNode__ConnectionEnd.initOperations(_IfNode__ConnectionEnd);
			Fragments._IfNode__Element.initOperations(_IfNode__Element);
			Fragments._IfNode__IfNode.initOperations(_IfNode__IfNode);
			Fragments._IfNode__MappingNode.initOperations(_IfNode__MappingNode);
			Fragments._IfNode__Node.initOperations(_IfNode__Node);
			Fragments._IfNode__OclAny.initOperations(_IfNode__OclAny);
			Fragments._IfNode__OclElement.initOperations(_IfNode__OclElement);
			Fragments._IfNode__OperationNode.initOperations(_IfNode__OperationNode);

			Fragments._IncludesEdge__Edge.initOperations(_IncludesEdge__Edge);
			Fragments._IncludesEdge__Element.initOperations(_IncludesEdge__Element);
			Fragments._IncludesEdge__ExpressionEdge.initOperations(_IncludesEdge__ExpressionEdge);
			Fragments._IncludesEdge__IncludesEdge.initOperations(_IncludesEdge__IncludesEdge);
			Fragments._IncludesEdge__OclAny.initOperations(_IncludesEdge__OclAny);
			Fragments._IncludesEdge__OclElement.initOperations(_IncludesEdge__OclElement);

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
			Fragments._IteratorNode__MappingNode.initOperations(_IteratorNode__MappingNode);
			Fragments._IteratorNode__Node.initOperations(_IteratorNode__Node);
			Fragments._IteratorNode__OclAny.initOperations(_IteratorNode__OclAny);
			Fragments._IteratorNode__OclElement.initOperations(_IteratorNode__OclElement);
			Fragments._IteratorNode__VariableNode.initOperations(_IteratorNode__VariableNode);

			Fragments._KeyPartEdge__ArgumentEdge.initOperations(_KeyPartEdge__ArgumentEdge);
			Fragments._KeyPartEdge__Edge.initOperations(_KeyPartEdge__Edge);
			Fragments._KeyPartEdge__Element.initOperations(_KeyPartEdge__Element);
			Fragments._KeyPartEdge__ExpressionEdge.initOperations(_KeyPartEdge__ExpressionEdge);
			Fragments._KeyPartEdge__KeyPartEdge.initOperations(_KeyPartEdge__KeyPartEdge);
			Fragments._KeyPartEdge__OclAny.initOperations(_KeyPartEdge__OclAny);
			Fragments._KeyPartEdge__OclElement.initOperations(_KeyPartEdge__OclElement);

			Fragments._KeyedValueNode__ConnectionEnd.initOperations(_KeyedValueNode__ConnectionEnd);
			Fragments._KeyedValueNode__Element.initOperations(_KeyedValueNode__Element);
			Fragments._KeyedValueNode__KeyedValueNode.initOperations(_KeyedValueNode__KeyedValueNode);
			Fragments._KeyedValueNode__MappingNode.initOperations(_KeyedValueNode__MappingNode);
			Fragments._KeyedValueNode__Node.initOperations(_KeyedValueNode__Node);
			Fragments._KeyedValueNode__OclAny.initOperations(_KeyedValueNode__OclAny);
			Fragments._KeyedValueNode__OclElement.initOperations(_KeyedValueNode__OclElement);
			Fragments._KeyedValueNode__OperationNode.initOperations(_KeyedValueNode__OperationNode);

			Fragments._LoadingPartition__Element.initOperations(_LoadingPartition__Element);
			Fragments._LoadingPartition__LoadingPartition.initOperations(_LoadingPartition__LoadingPartition);
			Fragments._LoadingPartition__MappingPartition.initOperations(_LoadingPartition__MappingPartition);
			Fragments._LoadingPartition__NamedElement.initOperations(_LoadingPartition__NamedElement);
			Fragments._LoadingPartition__OclAny.initOperations(_LoadingPartition__OclAny);
			Fragments._LoadingPartition__OclElement.initOperations(_LoadingPartition__OclElement);
			Fragments._LoadingPartition__Partition.initOperations(_LoadingPartition__Partition);

			Fragments._LoadingRegion__Element.initOperations(_LoadingRegion__Element);
			Fragments._LoadingRegion__LoadingRegion.initOperations(_LoadingRegion__LoadingRegion);
			Fragments._LoadingRegion__NamedElement.initOperations(_LoadingRegion__NamedElement);
			Fragments._LoadingRegion__OclAny.initOperations(_LoadingRegion__OclAny);
			Fragments._LoadingRegion__OclElement.initOperations(_LoadingRegion__OclElement);
			Fragments._LoadingRegion__Region.initOperations(_LoadingRegion__Region);
			Fragments._LoadingRegion__Symbolable.initOperations(_LoadingRegion__Symbolable);

			Fragments._MapLiteralNode__ConnectionEnd.initOperations(_MapLiteralNode__ConnectionEnd);
			Fragments._MapLiteralNode__Element.initOperations(_MapLiteralNode__Element);
			Fragments._MapLiteralNode__MapLiteralNode.initOperations(_MapLiteralNode__MapLiteralNode);
			Fragments._MapLiteralNode__MappingNode.initOperations(_MapLiteralNode__MappingNode);
			Fragments._MapLiteralNode__Node.initOperations(_MapLiteralNode__Node);
			Fragments._MapLiteralNode__OclAny.initOperations(_MapLiteralNode__OclAny);
			Fragments._MapLiteralNode__OclElement.initOperations(_MapLiteralNode__OclElement);
			Fragments._MapLiteralNode__OperationNode.initOperations(_MapLiteralNode__OperationNode);

			Fragments._MapPartEdge__ArgumentEdge.initOperations(_MapPartEdge__ArgumentEdge);
			Fragments._MapPartEdge__Edge.initOperations(_MapPartEdge__Edge);
			Fragments._MapPartEdge__Element.initOperations(_MapPartEdge__Element);
			Fragments._MapPartEdge__ExpressionEdge.initOperations(_MapPartEdge__ExpressionEdge);
			Fragments._MapPartEdge__MapPartEdge.initOperations(_MapPartEdge__MapPartEdge);
			Fragments._MapPartEdge__OclAny.initOperations(_MapPartEdge__OclAny);
			Fragments._MapPartEdge__OclElement.initOperations(_MapPartEdge__OclElement);

			Fragments._MapPartNode__ConnectionEnd.initOperations(_MapPartNode__ConnectionEnd);
			Fragments._MapPartNode__Element.initOperations(_MapPartNode__Element);
			Fragments._MapPartNode__MapPartNode.initOperations(_MapPartNode__MapPartNode);
			Fragments._MapPartNode__MappingNode.initOperations(_MapPartNode__MappingNode);
			Fragments._MapPartNode__Node.initOperations(_MapPartNode__Node);
			Fragments._MapPartNode__OclAny.initOperations(_MapPartNode__OclAny);
			Fragments._MapPartNode__OclElement.initOperations(_MapPartNode__OclElement);
			Fragments._MapPartNode__OperationNode.initOperations(_MapPartNode__OperationNode);

			Fragments._MappingNode__ConnectionEnd.initOperations(_MappingNode__ConnectionEnd);
			Fragments._MappingNode__Element.initOperations(_MappingNode__Element);
			Fragments._MappingNode__MappingNode.initOperations(_MappingNode__MappingNode);
			Fragments._MappingNode__Node.initOperations(_MappingNode__Node);
			Fragments._MappingNode__OclAny.initOperations(_MappingNode__OclAny);
			Fragments._MappingNode__OclElement.initOperations(_MappingNode__OclElement);

			Fragments._MappingPartition__Element.initOperations(_MappingPartition__Element);
			Fragments._MappingPartition__MappingPartition.initOperations(_MappingPartition__MappingPartition);
			Fragments._MappingPartition__NamedElement.initOperations(_MappingPartition__NamedElement);
			Fragments._MappingPartition__OclAny.initOperations(_MappingPartition__OclAny);
			Fragments._MappingPartition__OclElement.initOperations(_MappingPartition__OclElement);
			Fragments._MappingPartition__Partition.initOperations(_MappingPartition__Partition);

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
			Fragments._NodeConnection__Element.initOperations(_NodeConnection__Element);
			Fragments._NodeConnection__NodeConnection.initOperations(_NodeConnection__NodeConnection);
			Fragments._NodeConnection__OclAny.initOperations(_NodeConnection__OclAny);
			Fragments._NodeConnection__OclElement.initOperations(_NodeConnection__OclElement);
			Fragments._NodeConnection__Symbolable.initOperations(_NodeConnection__Symbolable);

			Fragments._NonPartition__Element.initOperations(_NonPartition__Element);
			Fragments._NonPartition__MappingPartition.initOperations(_NonPartition__MappingPartition);
			Fragments._NonPartition__NamedElement.initOperations(_NonPartition__NamedElement);
			Fragments._NonPartition__NonPartition.initOperations(_NonPartition__NonPartition);
			Fragments._NonPartition__OclAny.initOperations(_NonPartition__OclAny);
			Fragments._NonPartition__OclElement.initOperations(_NonPartition__OclElement);
			Fragments._NonPartition__Partition.initOperations(_NonPartition__Partition);

			Fragments._NullLiteralNode__ConnectionEnd.initOperations(_NullLiteralNode__ConnectionEnd);
			Fragments._NullLiteralNode__Element.initOperations(_NullLiteralNode__Element);
			Fragments._NullLiteralNode__MappingNode.initOperations(_NullLiteralNode__MappingNode);
			Fragments._NullLiteralNode__Node.initOperations(_NullLiteralNode__Node);
			Fragments._NullLiteralNode__NullLiteralNode.initOperations(_NullLiteralNode__NullLiteralNode);
			Fragments._NullLiteralNode__OclAny.initOperations(_NullLiteralNode__OclAny);
			Fragments._NullLiteralNode__OclElement.initOperations(_NullLiteralNode__OclElement);
			Fragments._NullLiteralNode__OperationNode.initOperations(_NullLiteralNode__OperationNode);

			Fragments._Number__Number.initOperations(_Number__Number);
			Fragments._Number__OclAny.initOperations(_Number__OclAny);

			Fragments._NumericLiteralNode__ConnectionEnd.initOperations(_NumericLiteralNode__ConnectionEnd);
			Fragments._NumericLiteralNode__Element.initOperations(_NumericLiteralNode__Element);
			Fragments._NumericLiteralNode__MappingNode.initOperations(_NumericLiteralNode__MappingNode);
			Fragments._NumericLiteralNode__Node.initOperations(_NumericLiteralNode__Node);
			Fragments._NumericLiteralNode__NumericLiteralNode.initOperations(_NumericLiteralNode__NumericLiteralNode);
			Fragments._NumericLiteralNode__OclAny.initOperations(_NumericLiteralNode__OclAny);
			Fragments._NumericLiteralNode__OclElement.initOperations(_NumericLiteralNode__OclElement);
			Fragments._NumericLiteralNode__OperationNode.initOperations(_NumericLiteralNode__OperationNode);

			Fragments._OperationCallNode__ConnectionEnd.initOperations(_OperationCallNode__ConnectionEnd);
			Fragments._OperationCallNode__Element.initOperations(_OperationCallNode__Element);
			Fragments._OperationCallNode__MappingNode.initOperations(_OperationCallNode__MappingNode);
			Fragments._OperationCallNode__Node.initOperations(_OperationCallNode__Node);
			Fragments._OperationCallNode__OclAny.initOperations(_OperationCallNode__OclAny);
			Fragments._OperationCallNode__OclElement.initOperations(_OperationCallNode__OclElement);
			Fragments._OperationCallNode__OperationCallNode.initOperations(_OperationCallNode__OperationCallNode);
			Fragments._OperationCallNode__OperationNode.initOperations(_OperationCallNode__OperationNode);

			Fragments._OperationNode__ConnectionEnd.initOperations(_OperationNode__ConnectionEnd);
			Fragments._OperationNode__Element.initOperations(_OperationNode__Element);
			Fragments._OperationNode__MappingNode.initOperations(_OperationNode__MappingNode);
			Fragments._OperationNode__Node.initOperations(_OperationNode__Node);
			Fragments._OperationNode__OclAny.initOperations(_OperationNode__OclAny);
			Fragments._OperationNode__OclElement.initOperations(_OperationNode__OclElement);
			Fragments._OperationNode__OperationNode.initOperations(_OperationNode__OperationNode);

			Fragments._OperationParameterEdge__ArgumentEdge.initOperations(_OperationParameterEdge__ArgumentEdge);
			Fragments._OperationParameterEdge__Edge.initOperations(_OperationParameterEdge__Edge);
			Fragments._OperationParameterEdge__Element.initOperations(_OperationParameterEdge__Element);
			Fragments._OperationParameterEdge__ExpressionEdge.initOperations(_OperationParameterEdge__ExpressionEdge);
			Fragments._OperationParameterEdge__OclAny.initOperations(_OperationParameterEdge__OclAny);
			Fragments._OperationParameterEdge__OclElement.initOperations(_OperationParameterEdge__OclElement);
			Fragments._OperationParameterEdge__OperationParameterEdge.initOperations(_OperationParameterEdge__OperationParameterEdge);

			Fragments._OperationRegion__Element.initOperations(_OperationRegion__Element);
			Fragments._OperationRegion__NamedElement.initOperations(_OperationRegion__NamedElement);
			Fragments._OperationRegion__OclAny.initOperations(_OperationRegion__OclAny);
			Fragments._OperationRegion__OclElement.initOperations(_OperationRegion__OclElement);
			Fragments._OperationRegion__OperationRegion.initOperations(_OperationRegion__OperationRegion);
			Fragments._OperationRegion__Region.initOperations(_OperationRegion__Region);
			Fragments._OperationRegion__Symbolable.initOperations(_OperationRegion__Symbolable);

			Fragments._OperationSelfEdge__ArgumentEdge.initOperations(_OperationSelfEdge__ArgumentEdge);
			Fragments._OperationSelfEdge__Edge.initOperations(_OperationSelfEdge__Edge);
			Fragments._OperationSelfEdge__Element.initOperations(_OperationSelfEdge__Element);
			Fragments._OperationSelfEdge__ExpressionEdge.initOperations(_OperationSelfEdge__ExpressionEdge);
			Fragments._OperationSelfEdge__OclAny.initOperations(_OperationSelfEdge__OclAny);
			Fragments._OperationSelfEdge__OclElement.initOperations(_OperationSelfEdge__OclElement);
			Fragments._OperationSelfEdge__OperationSelfEdge.initOperations(_OperationSelfEdge__OperationSelfEdge);

			Fragments._Partition__Element.initOperations(_Partition__Element);
			Fragments._Partition__NamedElement.initOperations(_Partition__NamedElement);
			Fragments._Partition__OclAny.initOperations(_Partition__OclAny);
			Fragments._Partition__OclElement.initOperations(_Partition__OclElement);
			Fragments._Partition__Partition.initOperations(_Partition__Partition);

			Fragments._PatternTypedNode__ConnectionEnd.initOperations(_PatternTypedNode__ConnectionEnd);
			Fragments._PatternTypedNode__Element.initOperations(_PatternTypedNode__Element);
			Fragments._PatternTypedNode__MappingNode.initOperations(_PatternTypedNode__MappingNode);
			Fragments._PatternTypedNode__Node.initOperations(_PatternTypedNode__Node);
			Fragments._PatternTypedNode__OclAny.initOperations(_PatternTypedNode__OclAny);
			Fragments._PatternTypedNode__OclElement.initOperations(_PatternTypedNode__OclElement);
			Fragments._PatternTypedNode__PatternTypedNode.initOperations(_PatternTypedNode__PatternTypedNode);

			Fragments._PatternVariableNode__ConnectionEnd.initOperations(_PatternVariableNode__ConnectionEnd);
			Fragments._PatternVariableNode__Element.initOperations(_PatternVariableNode__Element);
			Fragments._PatternVariableNode__MappingNode.initOperations(_PatternVariableNode__MappingNode);
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

			Fragments._RootPartition__CompositePartition.initOperations(_RootPartition__CompositePartition);
			Fragments._RootPartition__Element.initOperations(_RootPartition__Element);
			Fragments._RootPartition__NamedElement.initOperations(_RootPartition__NamedElement);
			Fragments._RootPartition__OclAny.initOperations(_RootPartition__OclAny);
			Fragments._RootPartition__OclElement.initOperations(_RootPartition__OclElement);
			Fragments._RootPartition__Partition.initOperations(_RootPartition__Partition);
			Fragments._RootPartition__RootPartition.initOperations(_RootPartition__RootPartition);

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

			Fragments._ShadowNode__ConnectionEnd.initOperations(_ShadowNode__ConnectionEnd);
			Fragments._ShadowNode__Element.initOperations(_ShadowNode__Element);
			Fragments._ShadowNode__MappingNode.initOperations(_ShadowNode__MappingNode);
			Fragments._ShadowNode__Node.initOperations(_ShadowNode__Node);
			Fragments._ShadowNode__OclAny.initOperations(_ShadowNode__OclAny);
			Fragments._ShadowNode__OclElement.initOperations(_ShadowNode__OclElement);
			Fragments._ShadowNode__OperationNode.initOperations(_ShadowNode__OperationNode);
			Fragments._ShadowNode__ShadowNode.initOperations(_ShadowNode__ShadowNode);

			Fragments._ShadowPartEdge__ArgumentEdge.initOperations(_ShadowPartEdge__ArgumentEdge);
			Fragments._ShadowPartEdge__Edge.initOperations(_ShadowPartEdge__Edge);
			Fragments._ShadowPartEdge__Element.initOperations(_ShadowPartEdge__Element);
			Fragments._ShadowPartEdge__ExpressionEdge.initOperations(_ShadowPartEdge__ExpressionEdge);
			Fragments._ShadowPartEdge__OclAny.initOperations(_ShadowPartEdge__OclAny);
			Fragments._ShadowPartEdge__OclElement.initOperations(_ShadowPartEdge__OclElement);
			Fragments._ShadowPartEdge__ShadowPartEdge.initOperations(_ShadowPartEdge__ShadowPartEdge);

			Fragments._StringLiteralNode__ConnectionEnd.initOperations(_StringLiteralNode__ConnectionEnd);
			Fragments._StringLiteralNode__Element.initOperations(_StringLiteralNode__Element);
			Fragments._StringLiteralNode__MappingNode.initOperations(_StringLiteralNode__MappingNode);
			Fragments._StringLiteralNode__Node.initOperations(_StringLiteralNode__Node);
			Fragments._StringLiteralNode__OclAny.initOperations(_StringLiteralNode__OclAny);
			Fragments._StringLiteralNode__OclElement.initOperations(_StringLiteralNode__OclElement);
			Fragments._StringLiteralNode__OperationNode.initOperations(_StringLiteralNode__OperationNode);
			Fragments._StringLiteralNode__StringLiteralNode.initOperations(_StringLiteralNode__StringLiteralNode);

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
			Fragments._SuccessNode__MappingNode.initOperations(_SuccessNode__MappingNode);
			Fragments._SuccessNode__Node.initOperations(_SuccessNode__Node);
			Fragments._SuccessNode__OclAny.initOperations(_SuccessNode__OclAny);
			Fragments._SuccessNode__OclElement.initOperations(_SuccessNode__OclElement);
			Fragments._SuccessNode__SuccessNode.initOperations(_SuccessNode__SuccessNode);

			Fragments._Symbolable__OclAny.initOperations(_Symbolable__OclAny);
			Fragments._Symbolable__OclElement.initOperations(_Symbolable__OclElement);
			Fragments._Symbolable__Symbolable.initOperations(_Symbolable__Symbolable);

			Fragments._TupleLiteralNode__ConnectionEnd.initOperations(_TupleLiteralNode__ConnectionEnd);
			Fragments._TupleLiteralNode__Element.initOperations(_TupleLiteralNode__Element);
			Fragments._TupleLiteralNode__MappingNode.initOperations(_TupleLiteralNode__MappingNode);
			Fragments._TupleLiteralNode__Node.initOperations(_TupleLiteralNode__Node);
			Fragments._TupleLiteralNode__OclAny.initOperations(_TupleLiteralNode__OclAny);
			Fragments._TupleLiteralNode__OclElement.initOperations(_TupleLiteralNode__OclElement);
			Fragments._TupleLiteralNode__OperationNode.initOperations(_TupleLiteralNode__OperationNode);
			Fragments._TupleLiteralNode__TupleLiteralNode.initOperations(_TupleLiteralNode__TupleLiteralNode);

			Fragments._TuplePartEdge__ArgumentEdge.initOperations(_TuplePartEdge__ArgumentEdge);
			Fragments._TuplePartEdge__Edge.initOperations(_TuplePartEdge__Edge);
			Fragments._TuplePartEdge__Element.initOperations(_TuplePartEdge__Element);
			Fragments._TuplePartEdge__ExpressionEdge.initOperations(_TuplePartEdge__ExpressionEdge);
			Fragments._TuplePartEdge__OclAny.initOperations(_TuplePartEdge__OclAny);
			Fragments._TuplePartEdge__OclElement.initOperations(_TuplePartEdge__OclElement);
			Fragments._TuplePartEdge__TuplePartEdge.initOperations(_TuplePartEdge__TuplePartEdge);

			Fragments._TypeLiteralNode__ConnectionEnd.initOperations(_TypeLiteralNode__ConnectionEnd);
			Fragments._TypeLiteralNode__Element.initOperations(_TypeLiteralNode__Element);
			Fragments._TypeLiteralNode__MappingNode.initOperations(_TypeLiteralNode__MappingNode);
			Fragments._TypeLiteralNode__Node.initOperations(_TypeLiteralNode__Node);
			Fragments._TypeLiteralNode__OclAny.initOperations(_TypeLiteralNode__OclAny);
			Fragments._TypeLiteralNode__OclElement.initOperations(_TypeLiteralNode__OclElement);
			Fragments._TypeLiteralNode__OperationNode.initOperations(_TypeLiteralNode__OperationNode);
			Fragments._TypeLiteralNode__TypeLiteralNode.initOperations(_TypeLiteralNode__TypeLiteralNode);

			Fragments._UnknownNode__ConnectionEnd.initOperations(_UnknownNode__ConnectionEnd);
			Fragments._UnknownNode__Element.initOperations(_UnknownNode__Element);
			Fragments._UnknownNode__MappingNode.initOperations(_UnknownNode__MappingNode);
			Fragments._UnknownNode__Node.initOperations(_UnknownNode__Node);
			Fragments._UnknownNode__OclAny.initOperations(_UnknownNode__OclAny);
			Fragments._UnknownNode__OclElement.initOperations(_UnknownNode__OclElement);
			Fragments._UnknownNode__UnknownNode.initOperations(_UnknownNode__UnknownNode);

			Fragments._VariableNode__ConnectionEnd.initOperations(_VariableNode__ConnectionEnd);
			Fragments._VariableNode__Element.initOperations(_VariableNode__Element);
			Fragments._VariableNode__MappingNode.initOperations(_VariableNode__MappingNode);
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
			QVTscheduleTables.Properties._AbstractDatum__referredTypedModel
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ArgumentEdge = {
			QVTscheduleTables.Properties._Edge__cluster,
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _BasicPartition = {
			QVTscheduleTables.Properties._BasicPartition__constantEdges,
			QVTscheduleTables.Properties._BasicPartition__constantNodes,
			QVTscheduleTables.Properties._BasicPartition__constantSuccessFalseNodes,
			QVTscheduleTables.Properties._BasicPartition__constantSuccessTrueNodes,
			QVTscheduleTables.Properties._BasicPartition__explicitPredecessors,
			QVTscheduleTables.Properties._BasicPartition__headNodes,
			QVTscheduleTables.Properties._Partition__intermediateConnections,
			QVTscheduleTables.Properties._BasicPartition__loadedEdges,
			QVTscheduleTables.Properties._BasicPartition__loadedNodes,
			QVTscheduleTables.Properties._MappingPartition__owningCompositePartition,
			QVTscheduleTables.Properties._Partition__passes,
			QVTscheduleTables.Properties._BasicPartition__predicatedEdges,
			QVTscheduleTables.Properties._BasicPartition__predicatedNodes,
			QVTscheduleTables.Properties._BasicPartition__realizedEdges,
			QVTscheduleTables.Properties._BasicPartition__realizedNodes,
			QVTscheduleTables.Properties._MappingPartition__referedMappingRegion,
			QVTscheduleTables.Properties._MappingPartition__region,
			QVTscheduleTables.Properties._Partition__rootConnections,
			QVTscheduleTables.Properties._MappingPartition__rootPartition,
			QVTscheduleTables.Properties._BasicPartition__speculatedEdges,
			QVTscheduleTables.Properties._BasicPartition__speculatedNodes,
			QVTscheduleTables.Properties._BasicPartition__speculationNodes
		};

		private static final @NonNull ExecutorProperty @NonNull [] _BooleanLiteralNode = {
			QVTscheduleTables.Properties._BooleanLiteralNode__booleanValue,
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _CastEdge = {
			QVTscheduleTables.Properties._Edge__cluster,
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
			QVTscheduleTables.Properties._ClassDatum__ownedPropertyDatums,
			QVTscheduleTables.Properties._ClassDatum__owningScheduleModel,
			QVTscheduleTables.Properties._ClassDatum__referredClass,
			QVTscheduleTables.Properties._AbstractDatum__referredTypedModel,
			QVTscheduleTables.Properties._ClassDatum__superClassDatums
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Cluster = {
			QVTscheduleTables.Properties._Cluster__depth,
			QVTscheduleTables.Properties._Cluster__memberEdges,
			QVTscheduleTables.Properties._Cluster__memberNodes,
			QVTscheduleTables.Properties._Cluster__owningRegion,
			QVTscheduleTables.Properties._Cluster__precedingClusters,
			QVTscheduleTables.Properties._Cluster__succeedingClusters,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _CollectionLiteralNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _CollectionPartEdge = {
			QVTscheduleTables.Properties._Edge__cluster,
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._CollectionPartEdge__referredPart,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _CollectionRangeNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ComposedNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _CompositePartition = {
			QVTscheduleTables.Properties._Partition__intermediateConnections,
			QVTscheduleTables.Properties._CompositePartition__ownedMappingPartitions,
			QVTscheduleTables.Properties._Partition__passes,
			QVTscheduleTables.Properties._Partition__rootConnections
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Connection = {
			QVTscheduleTables.Properties._Connection__commonPartition,
			QVTscheduleTables.Properties._Connection__connectionRole,
			QVTscheduleTables.Properties._Connection__intermediatePartitions,
			QVTscheduleTables.Properties._Connection__name,
			QVTscheduleTables.Properties._Connection__owningScheduledRegion,
			QVTscheduleTables.Properties._Connection__sourceEnds,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ConnectionEnd = {};

		private static final @NonNull ExecutorProperty @NonNull [] _ConnectionRole = {};

		private static final @NonNull ExecutorProperty @NonNull [] _CyclicMappingRegion = {
			QVTscheduleTables.Properties._CyclicMappingRegion__elementRegions,
			QVTscheduleTables.Properties._MappingRegion__headNodes,
			QVTscheduleTables.Properties._MappingRegion__mappingPartitions,
			QVTscheduleTables.Properties._Region__ownedClusters,
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._MappingRegion__owningScheduleModel,
			QVTscheduleTables.Properties._Region__scheduledRegion,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _CyclicPartition = {
			QVTscheduleTables.Properties._Partition__intermediateConnections,
			QVTscheduleTables.Properties._CompositePartition__ownedMappingPartitions,
			QVTscheduleTables.Properties._MappingPartition__owningCompositePartition,
			QVTscheduleTables.Properties._Partition__passes,
			QVTscheduleTables.Properties._MappingPartition__referedMappingRegion,
			QVTscheduleTables.Properties._MappingPartition__region,
			QVTscheduleTables.Properties._Partition__rootConnections,
			QVTscheduleTables.Properties._MappingPartition__rootPartition
		};

		private static final @NonNull ExecutorProperty @NonNull [] _DependencyEdge = {
			QVTscheduleTables.Properties._Edge__cluster,
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _DependencyNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _DispatchRegion = {
			QVTscheduleTables.Properties._MappingRegion__headNodes,
			QVTscheduleTables.Properties._MappingRegion__mappingPartitions,
			QVTscheduleTables.Properties._Region__ownedClusters,
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._MappingRegion__owningScheduleModel,
			QVTscheduleTables.Properties._RuleRegion__referredRule,
			QVTscheduleTables.Properties._DispatchRegion__referredRuleRegion,
			QVTscheduleTables.Properties._Region__scheduledRegion,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Edge = {
			QVTscheduleTables.Properties._Edge__cluster,
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _EdgeConnection = {
			QVTscheduleTables.Properties._Connection__commonPartition,
			QVTscheduleTables.Properties._Connection__connectionRole,
			QVTscheduleTables.Properties._Connection__intermediatePartitions,
			QVTscheduleTables.Properties._EdgeConnection__mandatoryTargetEdges,
			QVTscheduleTables.Properties._Connection__name,
			QVTscheduleTables.Properties._Connection__owningScheduledRegion,
			QVTscheduleTables.Properties._EdgeConnection__preferredTargetEdges,
			QVTscheduleTables.Properties._EdgeConnection__referredProperty,
			QVTscheduleTables.Properties._Connection__sourceEnds,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _EnumLiteralNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._EnumLiteralNode__enumValue,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ErrorNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ExpressionEdge = {
			QVTscheduleTables.Properties._Edge__cluster,
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _IfNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _IncludesEdge = {
			QVTscheduleTables.Properties._Edge__cluster,
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _InputNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _IteratedEdge = {
			QVTscheduleTables.Properties._Edge__cluster,
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _IteratorNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion,
			QVTscheduleTables.Properties._VariableNode__referredVariable
		};

		private static final @NonNull ExecutorProperty @NonNull [] _KeyPartEdge = {
			QVTscheduleTables.Properties._Edge__cluster,
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._KeyPartEdge__referredPart,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _KeyedValueNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._KeyedValueNode__classDatumValue,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _LoadingPartition = {
			QVTscheduleTables.Properties._Partition__intermediateConnections,
			QVTscheduleTables.Properties._MappingPartition__owningCompositePartition,
			QVTscheduleTables.Properties._Partition__passes,
			QVTscheduleTables.Properties._MappingPartition__referedMappingRegion,
			QVTscheduleTables.Properties._LoadingPartition__referredLoadingRegion,
			QVTscheduleTables.Properties._MappingPartition__region,
			QVTscheduleTables.Properties._Partition__rootConnections,
			QVTscheduleTables.Properties._MappingPartition__rootPartition
		};

		private static final @NonNull ExecutorProperty @NonNull [] _LoadingRegion = {
			QVTscheduleTables.Properties._LoadingRegion__loadingPartition,
			QVTscheduleTables.Properties._Region__ownedClusters,
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._LoadingRegion__owningScheduledRegion,
			QVTscheduleTables.Properties._Region__scheduledRegion,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _MapLiteralNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _MapPartEdge = {
			QVTscheduleTables.Properties._Edge__cluster,
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._MapPartEdge__referredPart,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _MapPartNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _MappingNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _MappingPartition = {
			QVTscheduleTables.Properties._Partition__intermediateConnections,
			QVTscheduleTables.Properties._MappingPartition__owningCompositePartition,
			QVTscheduleTables.Properties._Partition__passes,
			QVTscheduleTables.Properties._MappingPartition__referedMappingRegion,
			QVTscheduleTables.Properties._MappingPartition__region,
			QVTscheduleTables.Properties._Partition__rootConnections,
			QVTscheduleTables.Properties._MappingPartition__rootPartition
		};

		private static final @NonNull ExecutorProperty @NonNull [] _MappingRegion = {
			QVTscheduleTables.Properties._MappingRegion__headNodes,
			QVTscheduleTables.Properties._MappingRegion__mappingPartitions,
			QVTscheduleTables.Properties._Region__ownedClusters,
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._MappingRegion__owningScheduleModel,
			QVTscheduleTables.Properties._Region__scheduledRegion,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _MicroMappingRegion = {
			QVTscheduleTables.Properties._MappingRegion__headNodes,
			QVTscheduleTables.Properties._MappingRegion__mappingPartitions,
			QVTscheduleTables.Properties._MicroMappingRegion__mappingRegion,
			QVTscheduleTables.Properties._MicroMappingRegion__namePrefix,
			QVTscheduleTables.Properties._Region__ownedClusters,
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._MappingRegion__owningScheduleModel,
			QVTscheduleTables.Properties._Region__scheduledRegion,
			QVTscheduleTables.Properties._Symbolable__symbolName,
			QVTscheduleTables.Properties._MicroMappingRegion__symbolNameSuffix
		};

		private static final @NonNull ExecutorProperty @NonNull [] _NamedMappingRegion = {
			QVTscheduleTables.Properties._MappingRegion__headNodes,
			QVTscheduleTables.Properties._MappingRegion__mappingPartitions,
			QVTscheduleTables.Properties._Region__ownedClusters,
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._MappingRegion__owningScheduleModel,
			QVTscheduleTables.Properties._Region__scheduledRegion,
			QVTscheduleTables.Properties._Symbolable__symbolName,
			QVTscheduleTables.Properties._NamedMappingRegion__symbolNameSuffix
		};

		private static final @NonNull ExecutorProperty @NonNull [] _NavigableEdge = {
			QVTscheduleTables.Properties._Edge__cluster,
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
			QVTscheduleTables.Properties._Edge__cluster,
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
			QVTscheduleTables.Properties._Node__cluster,
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
			QVTscheduleTables.Properties._Connection__commonPartition,
			QVTscheduleTables.Properties._Connection__connectionRole,
			QVTscheduleTables.Properties._Connection__intermediatePartitions,
			QVTscheduleTables.Properties._NodeConnection__mandatoryTargetNodes,
			QVTscheduleTables.Properties._Connection__name,
			QVTscheduleTables.Properties._Connection__owningScheduledRegion,
			QVTscheduleTables.Properties._NodeConnection__passedTargetNodes,
			QVTscheduleTables.Properties._NodeConnection__preferredTargetNodes,
			QVTscheduleTables.Properties._Connection__sourceEnds,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _NonPartition = {
			QVTscheduleTables.Properties._Partition__intermediateConnections,
			QVTscheduleTables.Properties._MappingPartition__owningCompositePartition,
			QVTscheduleTables.Properties._Partition__passes,
			QVTscheduleTables.Properties._MappingPartition__referedMappingRegion,
			QVTscheduleTables.Properties._MappingPartition__region,
			QVTscheduleTables.Properties._Partition__rootConnections,
			QVTscheduleTables.Properties._MappingPartition__rootPartition
		};

		private static final @NonNull ExecutorProperty @NonNull [] _NullLiteralNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Number = {};

		private static final @NonNull ExecutorProperty @NonNull [] _NumericLiteralNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._NumericLiteralNode__numericValue,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OperationCallNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion,
			QVTscheduleTables.Properties._OperationCallNode__referredOperation
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OperationNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OperationParameterEdge = {
			QVTscheduleTables.Properties._Edge__cluster,
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._OperationParameterEdge__parameterIndex,
			QVTscheduleTables.Properties._OperationParameterEdge__referredParameter,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OperationRegion = {
			QVTscheduleTables.Properties._OperationRegion__dependencyNodes,
			QVTscheduleTables.Properties._OperationRegion__headNodes,
			QVTscheduleTables.Properties._Region__ownedClusters,
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._OperationRegion__owningScheduleModel,
			QVTscheduleTables.Properties._OperationRegion__referredOperation,
			QVTscheduleTables.Properties._OperationRegion__resultNode,
			QVTscheduleTables.Properties._Region__scheduledRegion,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OperationSelfEdge = {
			QVTscheduleTables.Properties._Edge__cluster,
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._OperationSelfEdge__referredType,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Partition = {
			QVTscheduleTables.Properties._Partition__intermediateConnections,
			QVTscheduleTables.Properties._Partition__passes,
			QVTscheduleTables.Properties._Partition__rootConnections
		};

		private static final @NonNull ExecutorProperty @NonNull [] _PatternTypedNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _PatternVariableNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion,
			QVTscheduleTables.Properties._VariableNode__referredVariable
		};

		private static final @NonNull ExecutorProperty @NonNull [] _PredicateEdge = {
			QVTscheduleTables.Properties._Edge__cluster,
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _PropertyDatum = {
			QVTscheduleTables.Properties._PropertyDatum__key,
			QVTscheduleTables.Properties._PropertyDatum__opposite,
			QVTscheduleTables.Properties._PropertyDatum__owningClassDatum,
			QVTscheduleTables.Properties._PropertyDatum__referredProperty,
			QVTscheduleTables.Properties._AbstractDatum__referredTypedModel,
			QVTscheduleTables.Properties._PropertyDatum__superPropertyDatums
		};

		private static final @NonNull ExecutorProperty @NonNull [] _RecursionEdge = {
			QVTscheduleTables.Properties._Edge__cluster,
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._RecursionEdge__primary,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Region = {
			QVTscheduleTables.Properties._Region__ownedClusters,
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._Region__scheduledRegion,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Role = {};

		private static final @NonNull ExecutorProperty @NonNull [] _RootPartition = {
			QVTscheduleTables.Properties._Partition__intermediateConnections,
			QVTscheduleTables.Properties._RootPartition__loadingPartition,
			QVTscheduleTables.Properties._CompositePartition__ownedMappingPartitions,
			QVTscheduleTables.Properties._RootPartition__owningRootRegion,
			QVTscheduleTables.Properties._Partition__passes,
			QVTscheduleTables.Properties._Partition__rootConnections
		};

		private static final @NonNull ExecutorProperty @NonNull [] _RuleRegion = {
			QVTscheduleTables.Properties._MappingRegion__headNodes,
			QVTscheduleTables.Properties._MappingRegion__mappingPartitions,
			QVTscheduleTables.Properties._Region__ownedClusters,
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._MappingRegion__owningScheduleModel,
			QVTscheduleTables.Properties._RuleRegion__referredRule,
			QVTscheduleTables.Properties._Region__scheduledRegion,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ScheduleModel = {
			QVTscheduleTables.Properties._ScheduleModel__ownedClassDatums,
			QVTscheduleTables.Properties._ScheduleModel__ownedMappingRegions,
			QVTscheduleTables.Properties._ScheduleModel__ownedOperationRegions,
			QVTscheduleTables.Properties._ScheduleModel__ownedScheduledRegions
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ScheduledRegion = {
			QVTscheduleTables.Properties._ScheduledRegion__activeRegions,
			QVTscheduleTables.Properties._Region__ownedClusters,
			QVTscheduleTables.Properties._ScheduledRegion__ownedConnections,
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._ScheduledRegion__ownedLoadingRegion,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._ScheduledRegion__ownedRootPartition,
			QVTscheduleTables.Properties._ScheduledRegion__owningScheduleModel,
			QVTscheduleTables.Properties._ScheduledRegion__referredTransformation,
			QVTscheduleTables.Properties._Region__scheduledRegion,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ShadowNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ShadowPartEdge = {
			QVTscheduleTables.Properties._Edge__cluster,
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._ShadowPartEdge__referredPart,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _StringLiteralNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion,
			QVTscheduleTables.Properties._StringLiteralNode__stringValue
		};

		private static final @NonNull ExecutorProperty @NonNull [] _SuccessEdge = {
			QVTscheduleTables.Properties._Edge__cluster,
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
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Symbolable = {
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _TupleLiteralNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _TuplePartEdge = {
			QVTscheduleTables.Properties._Edge__cluster,
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__owningRegion,
			QVTscheduleTables.Properties._TuplePartEdge__referredPart,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _TypeLiteralNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion,
			QVTscheduleTables.Properties._TypeLiteralNode__typeValue
		};

		private static final @NonNull ExecutorProperty @NonNull [] _UnknownNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion
		};

		private static final @NonNull ExecutorProperty @NonNull [] _VariableNode = {
			QVTscheduleTables.Properties._Node__classDatum,
			QVTscheduleTables.Properties._Node__cluster,
			QVTscheduleTables.Properties._Node__incomingConnection,
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._MappingNode__matched,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingConnections,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__owningRegion,
			QVTscheduleTables.Properties._VariableNode__referredVariable
		};

		private static final @NonNull ExecutorProperty @NonNull [] _VerdictRegion = {
			QVTscheduleTables.Properties._MappingRegion__headNodes,
			QVTscheduleTables.Properties._MappingRegion__mappingPartitions,
			QVTscheduleTables.Properties._Region__ownedClusters,
			QVTscheduleTables.Properties._Region__ownedEdges,
			QVTscheduleTables.Properties._Region__ownedNodes,
			QVTscheduleTables.Properties._MappingRegion__owningScheduleModel,
			QVTscheduleTables.Properties._RuleRegion__referredRule,
			QVTscheduleTables.Properties._VerdictRegion__referredRuleRegion,
			QVTscheduleTables.Properties._Region__scheduledRegion,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._AbstractDatum__AbstractDatum.initProperties(_AbstractDatum);
			Fragments._ArgumentEdge__ArgumentEdge.initProperties(_ArgumentEdge);
			Fragments._BasicPartition__BasicPartition.initProperties(_BasicPartition);
			Fragments._BooleanLiteralNode__BooleanLiteralNode.initProperties(_BooleanLiteralNode);
			Fragments._CastEdge__CastEdge.initProperties(_CastEdge);
			Fragments._ClassDatum__ClassDatum.initProperties(_ClassDatum);
			Fragments._Cluster__Cluster.initProperties(_Cluster);
			Fragments._CollectionLiteralNode__CollectionLiteralNode.initProperties(_CollectionLiteralNode);
			Fragments._CollectionPartEdge__CollectionPartEdge.initProperties(_CollectionPartEdge);
			Fragments._CollectionRangeNode__CollectionRangeNode.initProperties(_CollectionRangeNode);
			Fragments._ComposedNode__ComposedNode.initProperties(_ComposedNode);
			Fragments._CompositePartition__CompositePartition.initProperties(_CompositePartition);
			Fragments._Connection__Connection.initProperties(_Connection);
			Fragments._ConnectionEnd__ConnectionEnd.initProperties(_ConnectionEnd);
			Fragments._ConnectionRole__ConnectionRole.initProperties(_ConnectionRole);
			Fragments._CyclicMappingRegion__CyclicMappingRegion.initProperties(_CyclicMappingRegion);
			Fragments._CyclicPartition__CyclicPartition.initProperties(_CyclicPartition);
			Fragments._DependencyEdge__DependencyEdge.initProperties(_DependencyEdge);
			Fragments._DependencyNode__DependencyNode.initProperties(_DependencyNode);
			Fragments._DispatchRegion__DispatchRegion.initProperties(_DispatchRegion);
			Fragments._Edge__Edge.initProperties(_Edge);
			Fragments._EdgeConnection__EdgeConnection.initProperties(_EdgeConnection);
			Fragments._EnumLiteralNode__EnumLiteralNode.initProperties(_EnumLiteralNode);
			Fragments._ErrorNode__ErrorNode.initProperties(_ErrorNode);
			Fragments._ExpressionEdge__ExpressionEdge.initProperties(_ExpressionEdge);
			Fragments._IfNode__IfNode.initProperties(_IfNode);
			Fragments._IncludesEdge__IncludesEdge.initProperties(_IncludesEdge);
			Fragments._InputNode__InputNode.initProperties(_InputNode);
			Fragments._IteratedEdge__IteratedEdge.initProperties(_IteratedEdge);
			Fragments._IteratorNode__IteratorNode.initProperties(_IteratorNode);
			Fragments._KeyPartEdge__KeyPartEdge.initProperties(_KeyPartEdge);
			Fragments._KeyedValueNode__KeyedValueNode.initProperties(_KeyedValueNode);
			Fragments._LoadingPartition__LoadingPartition.initProperties(_LoadingPartition);
			Fragments._LoadingRegion__LoadingRegion.initProperties(_LoadingRegion);
			Fragments._MapLiteralNode__MapLiteralNode.initProperties(_MapLiteralNode);
			Fragments._MapPartEdge__MapPartEdge.initProperties(_MapPartEdge);
			Fragments._MapPartNode__MapPartNode.initProperties(_MapPartNode);
			Fragments._MappingNode__MappingNode.initProperties(_MappingNode);
			Fragments._MappingPartition__MappingPartition.initProperties(_MappingPartition);
			Fragments._MappingRegion__MappingRegion.initProperties(_MappingRegion);
			Fragments._MicroMappingRegion__MicroMappingRegion.initProperties(_MicroMappingRegion);
			Fragments._NamedMappingRegion__NamedMappingRegion.initProperties(_NamedMappingRegion);
			Fragments._NavigableEdge__NavigableEdge.initProperties(_NavigableEdge);
			Fragments._NavigationEdge__NavigationEdge.initProperties(_NavigationEdge);
			Fragments._Node__Node.initProperties(_Node);
			Fragments._NodeConnection__NodeConnection.initProperties(_NodeConnection);
			Fragments._NonPartition__NonPartition.initProperties(_NonPartition);
			Fragments._NullLiteralNode__NullLiteralNode.initProperties(_NullLiteralNode);
			Fragments._Number__Number.initProperties(_Number);
			Fragments._NumericLiteralNode__NumericLiteralNode.initProperties(_NumericLiteralNode);
			Fragments._OperationCallNode__OperationCallNode.initProperties(_OperationCallNode);
			Fragments._OperationNode__OperationNode.initProperties(_OperationNode);
			Fragments._OperationParameterEdge__OperationParameterEdge.initProperties(_OperationParameterEdge);
			Fragments._OperationRegion__OperationRegion.initProperties(_OperationRegion);
			Fragments._OperationSelfEdge__OperationSelfEdge.initProperties(_OperationSelfEdge);
			Fragments._Partition__Partition.initProperties(_Partition);
			Fragments._PatternTypedNode__PatternTypedNode.initProperties(_PatternTypedNode);
			Fragments._PatternVariableNode__PatternVariableNode.initProperties(_PatternVariableNode);
			Fragments._PredicateEdge__PredicateEdge.initProperties(_PredicateEdge);
			Fragments._PropertyDatum__PropertyDatum.initProperties(_PropertyDatum);
			Fragments._RecursionEdge__RecursionEdge.initProperties(_RecursionEdge);
			Fragments._Region__Region.initProperties(_Region);
			Fragments._Role__Role.initProperties(_Role);
			Fragments._RootPartition__RootPartition.initProperties(_RootPartition);
			Fragments._RuleRegion__RuleRegion.initProperties(_RuleRegion);
			Fragments._ScheduleModel__ScheduleModel.initProperties(_ScheduleModel);
			Fragments._ScheduledRegion__ScheduledRegion.initProperties(_ScheduledRegion);
			Fragments._ShadowNode__ShadowNode.initProperties(_ShadowNode);
			Fragments._ShadowPartEdge__ShadowPartEdge.initProperties(_ShadowPartEdge);
			Fragments._StringLiteralNode__StringLiteralNode.initProperties(_StringLiteralNode);
			Fragments._SuccessEdge__SuccessEdge.initProperties(_SuccessEdge);
			Fragments._SuccessNode__SuccessNode.initProperties(_SuccessNode);
			Fragments._Symbolable__Symbolable.initProperties(_Symbolable);
			Fragments._TupleLiteralNode__TupleLiteralNode.initProperties(_TupleLiteralNode);
			Fragments._TuplePartEdge__TuplePartEdge.initProperties(_TuplePartEdge);
			Fragments._TypeLiteralNode__TypeLiteralNode.initProperties(_TypeLiteralNode);
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
		public static final @NonNull EcoreExecutorEnumerationLiteral _Role__CONSTANT_SUCCESS_FALSE = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("CONSTANT_SUCCESS_FALSE"), Types._Role, 1);
		public static final @NonNull EcoreExecutorEnumerationLiteral _Role__CONSTANT_SUCCESS_TRUE = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("CONSTANT_SUCCESS_TRUE"), Types._Role, 2);
		public static final @NonNull EcoreExecutorEnumerationLiteral _Role__LOADED = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("LOADED"), Types._Role, 3);
		public static final @NonNull EcoreExecutorEnumerationLiteral _Role__REALIZED = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("REALIZED"), Types._Role, 4);
		public static final @NonNull EcoreExecutorEnumerationLiteral _Role__PREDICATED = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("PREDICATED"), Types._Role, 5);
		public static final @NonNull EcoreExecutorEnumerationLiteral _Role__SPECULATION = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("SPECULATION"), Types._Role, 6);
		public static final @NonNull EcoreExecutorEnumerationLiteral _Role__SPECULATED = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("SPECULATED"), Types._Role, 7);
		public static final @NonNull EcoreExecutorEnumerationLiteral _Role__OTHER = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("OTHER"), Types._Role, 8);
		private static final @NonNull EcoreExecutorEnumerationLiteral @NonNull [] _Role = {
			_Role__CONSTANT,
			_Role__CONSTANT_SUCCESS_FALSE,
			_Role__CONSTANT_SUCCESS_TRUE,
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
