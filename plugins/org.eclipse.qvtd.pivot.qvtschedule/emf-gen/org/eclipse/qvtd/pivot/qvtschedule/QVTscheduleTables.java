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
 *   /org.eclipse.qvtd.pivot.qvtschedule/model/QVTschedule.ecore
 * using:
 *   /org.eclipse.qvtd.pivot.qvtschedule/model/QVTschedule.genmodel
 *   org.eclipse.ocl.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.flat.FlatClass;
import org.eclipse.ocl.pivot.flat.FlatFragment;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.EnumerationId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.PartialStandardLibraryImpl;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.AbstractTables;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables;
// import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
// import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables;

/**
 * QVTscheduleTables provides the dispatch tables for the qvtschedule for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
public class QVTscheduleTables extends AbstractTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The overall library of all packages and types.
	 */
	public static final PartialStandardLibraryImpl.@NonNull ReadOnly LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	The AS package for the QVTschedulePackage.eINSTANCE EPackage.
	 */
	public static final org.eclipse.ocl.pivot.@NonNull Package PACKAGE = LIBRARY.createPackage(QVTschedulePackage.eINSTANCE);

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
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", "ecore", EcorePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbase", "qvtb", QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2017/QVTschedule", "qvts", QVTschedulePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BasicPartition = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("BasicPartition", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CastEdge = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("CastEdge", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = QVTscheduleTables.PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ClassDatum = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("ClassDatum", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Cluster = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Cluster", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CollectionClassDatum = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("CollectionClassDatum", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CollectionLiteralPart = QVTscheduleTables.PACKid_$metamodel$.getClassId("CollectionLiteralPart", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CompleteClass = QVTscheduleTables.PACKid_$metamodel$.getClassId("CompleteClass", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CompositePartition = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("CompositePartition", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Connection = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Connection", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ConnectionEnd = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("ConnectionEnd", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CyclicMappingRegion = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("CyclicMappingRegion", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DispatchRegion = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("DispatchRegion", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Edge = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Edge", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_EdgeConnection = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("EdgeConnection", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_EnumerationLiteral = QVTscheduleTables.PACKid_$metamodel$.getClassId("EnumerationLiteral", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_KeyPartEdge = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("KeyPartEdge", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_KeyedValueNode = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("KeyedValueNode", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_LoadingPartition = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("LoadingPartition", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_LoadingRegion = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("LoadingRegion", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MapLiteralPart = QVTscheduleTables.PACKid_$metamodel$.getClassId("MapLiteralPart", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MappingPartition = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("MappingPartition", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MappingRegion = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("MappingRegion", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MergedPartition = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("MergedPartition", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_NavigableEdge = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("NavigableEdge", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_NavigationEdge = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("NavigationEdge", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Node = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Node", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_NodeConnection = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("NodeConnection", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Operation = QVTscheduleTables.PACKid_$metamodel$.getClassId("Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OperationRegion = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("OperationRegion", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Parameter = QVTscheduleTables.PACKid_$metamodel$.getClassId("Parameter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Partition = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Partition", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Property = QVTscheduleTables.PACKid_$metamodel$.getClassId("Property", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_PropertyDatum = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("PropertyDatum", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Region = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Region", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RootPartition = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("RootPartition", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RootRegion = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("RootRegion", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Rule = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Rule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RuleRegion = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("RuleRegion", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ScheduleModel = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("ScheduleModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ShadowPart = QVTscheduleTables.PACKid_$metamodel$.getClassId("ShadowPart", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Transformation = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Transformation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TupleLiteralPart = QVTscheduleTables.PACKid_$metamodel$.getClassId("TupleLiteralPart", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Type = QVTscheduleTables.PACKid_$metamodel$.getClassId("Type", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TypedModel = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("TypedModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableDeclaration = QVTscheduleTables.PACKid_$metamodel$.getClassId("VariableDeclaration", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VerdictRegion = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("VerdictRegion", 0);
	public static final /*@NonInvalid*/ @NonNull DataTypeId DATAid_EInt = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EInt", 0);
	public static final /*@NonInvalid*/ @NonNull DataTypeId DATAid_EIntegerObject = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EIntegerObject", 0);
	public static final /*@NonInvalid*/ @NonNull DataTypeId DATAid_Number = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getDataTypeId("Number", 0);
	public static final /*@NonInvalid*/ @NonNull EnumerationId ENUMid_ConnectionRole = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getEnumerationId("ConnectionRole");
	public static final /*@NonInvalid*/ @NonNull EnumerationId ENUMid_Role = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getEnumerationId("Role");
	public static final /*@NonInvalid*/ @NonNull EnumerationId ENUMid_Utility = QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getEnumerationId("Utility");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_BasicPartition = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_BasicPartition, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_CastEdge = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_CastEdge, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_ClassDatum = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_ClassDatum, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_CollectionClassDatum = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_CollectionClassDatum, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_Connection = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_Connection, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_CyclicMappingRegion = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_CyclicMappingRegion, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_DispatchRegion = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_DispatchRegion, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_EdgeConnection = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_EdgeConnection, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_KeyPartEdge = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_KeyPartEdge, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_KeyedValueNode = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_KeyedValueNode, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_MappingPartition = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_MappingPartition, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_MappingRegion = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_MappingRegion, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_NavigableEdge = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_NavigableEdge, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_NavigationEdge = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_NavigationEdge, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_Node = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_Node, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_NodeConnection = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_NodeConnection, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_OperationRegion = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_OperationRegion, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_Partition = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_Partition, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_PropertyDatum = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_PropertyDatum, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_RootPartition = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_RootPartition, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_VerdictRegion = TypeId.BAG.getSpecializedId(QVTscheduleTables.CLSSid_VerdictRegion, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_BasicPartition = TypeId.ORDERED_SET.getSpecializedId(QVTscheduleTables.CLSSid_BasicPartition, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_ClassDatum = TypeId.ORDERED_SET.getSpecializedId(QVTscheduleTables.CLSSid_ClassDatum, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Cluster = TypeId.ORDERED_SET.getSpecializedId(QVTscheduleTables.CLSSid_Cluster, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_CompleteClass = TypeId.ORDERED_SET.getSpecializedId(QVTscheduleTables.CLSSid_CompleteClass, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Connection = TypeId.ORDERED_SET.getSpecializedId(QVTscheduleTables.CLSSid_Connection, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Edge = TypeId.ORDERED_SET.getSpecializedId(QVTscheduleTables.CLSSid_Edge, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_EdgeConnection = TypeId.ORDERED_SET.getSpecializedId(QVTscheduleTables.CLSSid_EdgeConnection, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_MappingPartition = TypeId.ORDERED_SET.getSpecializedId(QVTscheduleTables.CLSSid_MappingPartition, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_MappingRegion = TypeId.ORDERED_SET.getSpecializedId(QVTscheduleTables.CLSSid_MappingRegion, false, ValueUtil.ONE_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_MappingRegion_0 = TypeId.ORDERED_SET.getSpecializedId(QVTscheduleTables.CLSSid_MappingRegion, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Node = TypeId.ORDERED_SET.getSpecializedId(QVTscheduleTables.CLSSid_Node, false, ValueUtil.ONE_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_NodeConnection = TypeId.ORDERED_SET.getSpecializedId(QVTscheduleTables.CLSSid_NodeConnection, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Node_0 = TypeId.ORDERED_SET.getSpecializedId(QVTscheduleTables.CLSSid_Node, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_OperationRegion = TypeId.ORDERED_SET.getSpecializedId(QVTscheduleTables.CLSSid_OperationRegion, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_PropertyDatum = TypeId.ORDERED_SET.getSpecializedId(QVTscheduleTables.CLSSid_PropertyDatum, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Region = TypeId.ORDERED_SET.getSpecializedId(QVTscheduleTables.CLSSid_Region, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_RootRegion = TypeId.ORDERED_SET.getSpecializedId(QVTscheduleTables.CLSSid_RootRegion, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_DATAid_EInt = TypeId.ORDERED_SET.getSpecializedId(QVTscheduleTables.DATAid_EInt, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_BasicPartition = TypeId.SET.getSpecializedId(QVTscheduleTables.CLSSid_BasicPartition, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_ConnectionEnd = TypeId.SET.getSpecializedId(QVTscheduleTables.CLSSid_ConnectionEnd, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Edge = TypeId.SET.getSpecializedId(QVTscheduleTables.CLSSid_Edge, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_MappingPartition = TypeId.SET.getSpecializedId(QVTscheduleTables.CLSSid_MappingPartition, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_NavigableEdge = TypeId.SET.getSpecializedId(QVTscheduleTables.CLSSid_NavigableEdge, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Node = TypeId.SET.getSpecializedId(QVTscheduleTables.CLSSid_Node, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_NodeConnection = TypeId.SET.getSpecializedId(QVTscheduleTables.CLSSid_NodeConnection, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Partition = TypeId.SET.getSpecializedId(QVTscheduleTables.CLSSid_Partition, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);

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

		public static final org.eclipse.ocl.pivot.@NonNull Class _AbstractDatum = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.ABSTRACT_DATUM, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _ArgumentEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.ARGUMENT_EDGE, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _BasicPartition = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.BASIC_PARTITION, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _BooleanLiteralNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.BOOLEAN_LITERAL_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _CastEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.CAST_EDGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _ClassDatum = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.CLASS_DATUM, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Cluster = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.CLUSTER, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _CollectionClassDatum = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.COLLECTION_CLASS_DATUM, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _CollectionLiteralNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.COLLECTION_LITERAL_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _CollectionPartEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.COLLECTION_PART_EDGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _CollectionRangeNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.COLLECTION_RANGE_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _ComposedNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.COMPOSED_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _CompositePartition = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.COMPOSITE_PARTITION, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Connection = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.CONNECTION, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _ConnectionEnd = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.CONNECTION_END, null, 0 | FlatClass.ABSTRACT);
		public static final @NonNull Enumeration _ConnectionRole = LIBRARY.createEnumeration(QVTschedulePackage.Literals.CONNECTION_ROLE);
		public static final org.eclipse.ocl.pivot.@NonNull Class _CyclicMappingRegion = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.CYCLIC_MAPPING_REGION, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _CyclicPartition = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.CYCLIC_PARTITION, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _DependencyEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.DEPENDENCY_EDGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _DependencyNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.DEPENDENCY_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _DispatchRegion = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.DISPATCH_REGION, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Edge = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.EDGE, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _EdgeConnection = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.EDGE_CONNECTION, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _EnumLiteralNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.ENUM_LITERAL_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _ErrorNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.ERROR_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _ExpressionEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.EXPRESSION_EDGE, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _IfNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.IF_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _IncludesEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.INCLUDES_EDGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _InputNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.INPUT_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _IteratedEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.ITERATED_EDGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _IteratorNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.ITERATOR_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _KeyPartEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.KEY_PART_EDGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _KeyedValueNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.KEYED_VALUE_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _LoadingPartition = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.LOADING_PARTITION, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _LoadingRegion = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.LOADING_REGION, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _MapLiteralNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.MAP_LITERAL_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _MapPartEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.MAP_PART_EDGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _MapPartNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.MAP_PART_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _MappingNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.MAPPING_NODE, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _MappingPartition = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.MAPPING_PARTITION, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _MappingRegion = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.MAPPING_REGION, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _MergedPartition = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.MERGED_PARTITION, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _NavigableEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.NAVIGABLE_EDGE, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _NavigationEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.NAVIGATION_EDGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Node = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.NODE, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _NodeConnection = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.NODE_CONNECTION, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _NonPartition = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.NON_PARTITION, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _NullLiteralNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.NULL_LITERAL_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Number = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.NUMBER, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _NumericLiteralNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.NUMERIC_LITERAL_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _OperationCallNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.OPERATION_CALL_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _OperationNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.OPERATION_NODE, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _OperationParameterEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.OPERATION_PARAMETER_EDGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _OperationRegion = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.OPERATION_REGION, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _OperationSelfEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.OPERATION_SELF_EDGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Partition = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.PARTITION, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _PatternTypedNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.PATTERN_TYPED_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _PatternVariableNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.PATTERN_VARIABLE_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _PredicateEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.PREDICATE_EDGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _PropertyDatum = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.PROPERTY_DATUM, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _RecursionEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.RECURSION_EDGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Region = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.REGION, null, 0 | FlatClass.ABSTRACT);
		public static final @NonNull Enumeration _Role = LIBRARY.createEnumeration(QVTschedulePackage.Literals.ROLE);
		public static final org.eclipse.ocl.pivot.@NonNull Class _RootPartition = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.ROOT_PARTITION, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _RootRegion = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.ROOT_REGION, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _RuleRegion = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.RULE_REGION, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _ScheduleModel = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.SCHEDULE_MODEL, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _ShadowNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.SHADOW_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _ShadowPartEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.SHADOW_PART_EDGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _StringLiteralNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.STRING_LITERAL_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _SuccessEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.SUCCESS_EDGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _SuccessNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.SUCCESS_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Symbolable = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.SYMBOLABLE, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _TupleLiteralNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.TUPLE_LITERAL_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _TuplePartEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.TUPLE_PART_EDGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _TypeLiteralNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.TYPE_LITERAL_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _UnknownNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.UNKNOWN_NODE, null, 0);
		public static final @NonNull Enumeration _Utility = LIBRARY.createEnumeration(QVTschedulePackage.Literals.UTILITY);
		public static final org.eclipse.ocl.pivot.@NonNull Class _VariableNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.VARIABLE_NODE, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _VerdictRegion = LIBRARY.createClass(PivotPackage.Literals.CLASS, QVTschedulePackage.Literals.VERDICT_REGION, null, 0);

		private static final org.eclipse.ocl.pivot.@NonNull Class @NonNull [] types = {
			_AbstractDatum,
			_ArgumentEdge,
			_BasicPartition,
			_BooleanLiteralNode,
			_CastEdge,
			_ClassDatum,
			_Cluster,
			_CollectionClassDatum,
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
			_MergedPartition,
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
			_RootRegion,
			_RuleRegion,
			_ScheduleModel,
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
			_Utility,
			_VariableNode,
			_VerdictRegion
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			LIBRARY.initPackage(PACKAGE, types);
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

		private static final @NonNull FlatFragment _AbstractDatum__AbstractDatum = LIBRARY.createFragment(Types._AbstractDatum, Types._AbstractDatum);
		private static final @NonNull FlatFragment _AbstractDatum__Element = LIBRARY.createFragment(Types._AbstractDatum, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _AbstractDatum__NamedElement = LIBRARY.createFragment(Types._AbstractDatum, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _AbstractDatum__OclAny = LIBRARY.createFragment(Types._AbstractDatum, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _AbstractDatum__OclElement = LIBRARY.createFragment(Types._AbstractDatum, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _ArgumentEdge__ArgumentEdge = LIBRARY.createFragment(Types._ArgumentEdge, Types._ArgumentEdge);
		private static final @NonNull FlatFragment _ArgumentEdge__Edge = LIBRARY.createFragment(Types._ArgumentEdge, Types._Edge);
		private static final @NonNull FlatFragment _ArgumentEdge__Element = LIBRARY.createFragment(Types._ArgumentEdge, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _ArgumentEdge__ExpressionEdge = LIBRARY.createFragment(Types._ArgumentEdge, Types._ExpressionEdge);
		private static final @NonNull FlatFragment _ArgumentEdge__OclAny = LIBRARY.createFragment(Types._ArgumentEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _ArgumentEdge__OclElement = LIBRARY.createFragment(Types._ArgumentEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _BasicPartition__BasicPartition = LIBRARY.createFragment(Types._BasicPartition, Types._BasicPartition);
		private static final @NonNull FlatFragment _BasicPartition__Element = LIBRARY.createFragment(Types._BasicPartition, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _BasicPartition__MappingPartition = LIBRARY.createFragment(Types._BasicPartition, Types._MappingPartition);
		private static final @NonNull FlatFragment _BasicPartition__NamedElement = LIBRARY.createFragment(Types._BasicPartition, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _BasicPartition__OclAny = LIBRARY.createFragment(Types._BasicPartition, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _BasicPartition__OclElement = LIBRARY.createFragment(Types._BasicPartition, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _BasicPartition__Partition = LIBRARY.createFragment(Types._BasicPartition, Types._Partition);

		private static final @NonNull FlatFragment _BooleanLiteralNode__BooleanLiteralNode = LIBRARY.createFragment(Types._BooleanLiteralNode, Types._BooleanLiteralNode);
		private static final @NonNull FlatFragment _BooleanLiteralNode__ConnectionEnd = LIBRARY.createFragment(Types._BooleanLiteralNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _BooleanLiteralNode__Element = LIBRARY.createFragment(Types._BooleanLiteralNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _BooleanLiteralNode__MappingNode = LIBRARY.createFragment(Types._BooleanLiteralNode, Types._MappingNode);
		private static final @NonNull FlatFragment _BooleanLiteralNode__Node = LIBRARY.createFragment(Types._BooleanLiteralNode, Types._Node);
		private static final @NonNull FlatFragment _BooleanLiteralNode__OclAny = LIBRARY.createFragment(Types._BooleanLiteralNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _BooleanLiteralNode__OclElement = LIBRARY.createFragment(Types._BooleanLiteralNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _BooleanLiteralNode__OperationNode = LIBRARY.createFragment(Types._BooleanLiteralNode, Types._OperationNode);

		private static final @NonNull FlatFragment _CastEdge__CastEdge = LIBRARY.createFragment(Types._CastEdge, Types._CastEdge);
		private static final @NonNull FlatFragment _CastEdge__Edge = LIBRARY.createFragment(Types._CastEdge, Types._Edge);
		private static final @NonNull FlatFragment _CastEdge__Element = LIBRARY.createFragment(Types._CastEdge, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _CastEdge__OclAny = LIBRARY.createFragment(Types._CastEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _CastEdge__OclElement = LIBRARY.createFragment(Types._CastEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _ClassDatum__AbstractDatum = LIBRARY.createFragment(Types._ClassDatum, Types._AbstractDatum);
		private static final @NonNull FlatFragment _ClassDatum__ClassDatum = LIBRARY.createFragment(Types._ClassDatum, Types._ClassDatum);
		private static final @NonNull FlatFragment _ClassDatum__Element = LIBRARY.createFragment(Types._ClassDatum, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _ClassDatum__NamedElement = LIBRARY.createFragment(Types._ClassDatum, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _ClassDatum__OclAny = LIBRARY.createFragment(Types._ClassDatum, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _ClassDatum__OclElement = LIBRARY.createFragment(Types._ClassDatum, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _Cluster__Cluster = LIBRARY.createFragment(Types._Cluster, Types._Cluster);
		private static final @NonNull FlatFragment _Cluster__Element = LIBRARY.createFragment(Types._Cluster, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _Cluster__NamedElement = LIBRARY.createFragment(Types._Cluster, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _Cluster__OclAny = LIBRARY.createFragment(Types._Cluster, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Cluster__OclElement = LIBRARY.createFragment(Types._Cluster, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Cluster__Symbolable = LIBRARY.createFragment(Types._Cluster, Types._Symbolable);

		private static final @NonNull FlatFragment _CollectionClassDatum__AbstractDatum = LIBRARY.createFragment(Types._CollectionClassDatum, Types._AbstractDatum);
		private static final @NonNull FlatFragment _CollectionClassDatum__ClassDatum = LIBRARY.createFragment(Types._CollectionClassDatum, Types._ClassDatum);
		private static final @NonNull FlatFragment _CollectionClassDatum__CollectionClassDatum = LIBRARY.createFragment(Types._CollectionClassDatum, Types._CollectionClassDatum);
		private static final @NonNull FlatFragment _CollectionClassDatum__Element = LIBRARY.createFragment(Types._CollectionClassDatum, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _CollectionClassDatum__NamedElement = LIBRARY.createFragment(Types._CollectionClassDatum, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _CollectionClassDatum__OclAny = LIBRARY.createFragment(Types._CollectionClassDatum, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _CollectionClassDatum__OclElement = LIBRARY.createFragment(Types._CollectionClassDatum, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _CollectionLiteralNode__CollectionLiteralNode = LIBRARY.createFragment(Types._CollectionLiteralNode, Types._CollectionLiteralNode);
		private static final @NonNull FlatFragment _CollectionLiteralNode__ConnectionEnd = LIBRARY.createFragment(Types._CollectionLiteralNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _CollectionLiteralNode__Element = LIBRARY.createFragment(Types._CollectionLiteralNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _CollectionLiteralNode__MappingNode = LIBRARY.createFragment(Types._CollectionLiteralNode, Types._MappingNode);
		private static final @NonNull FlatFragment _CollectionLiteralNode__Node = LIBRARY.createFragment(Types._CollectionLiteralNode, Types._Node);
		private static final @NonNull FlatFragment _CollectionLiteralNode__OclAny = LIBRARY.createFragment(Types._CollectionLiteralNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _CollectionLiteralNode__OclElement = LIBRARY.createFragment(Types._CollectionLiteralNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _CollectionLiteralNode__OperationNode = LIBRARY.createFragment(Types._CollectionLiteralNode, Types._OperationNode);

		private static final @NonNull FlatFragment _CollectionPartEdge__ArgumentEdge = LIBRARY.createFragment(Types._CollectionPartEdge, Types._ArgumentEdge);
		private static final @NonNull FlatFragment _CollectionPartEdge__CollectionPartEdge = LIBRARY.createFragment(Types._CollectionPartEdge, Types._CollectionPartEdge);
		private static final @NonNull FlatFragment _CollectionPartEdge__Edge = LIBRARY.createFragment(Types._CollectionPartEdge, Types._Edge);
		private static final @NonNull FlatFragment _CollectionPartEdge__Element = LIBRARY.createFragment(Types._CollectionPartEdge, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _CollectionPartEdge__ExpressionEdge = LIBRARY.createFragment(Types._CollectionPartEdge, Types._ExpressionEdge);
		private static final @NonNull FlatFragment _CollectionPartEdge__OclAny = LIBRARY.createFragment(Types._CollectionPartEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _CollectionPartEdge__OclElement = LIBRARY.createFragment(Types._CollectionPartEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _CollectionRangeNode__CollectionRangeNode = LIBRARY.createFragment(Types._CollectionRangeNode, Types._CollectionRangeNode);
		private static final @NonNull FlatFragment _CollectionRangeNode__ConnectionEnd = LIBRARY.createFragment(Types._CollectionRangeNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _CollectionRangeNode__Element = LIBRARY.createFragment(Types._CollectionRangeNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _CollectionRangeNode__MappingNode = LIBRARY.createFragment(Types._CollectionRangeNode, Types._MappingNode);
		private static final @NonNull FlatFragment _CollectionRangeNode__Node = LIBRARY.createFragment(Types._CollectionRangeNode, Types._Node);
		private static final @NonNull FlatFragment _CollectionRangeNode__OclAny = LIBRARY.createFragment(Types._CollectionRangeNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _CollectionRangeNode__OclElement = LIBRARY.createFragment(Types._CollectionRangeNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _CollectionRangeNode__OperationNode = LIBRARY.createFragment(Types._CollectionRangeNode, Types._OperationNode);

		private static final @NonNull FlatFragment _ComposedNode__ComposedNode = LIBRARY.createFragment(Types._ComposedNode, Types._ComposedNode);
		private static final @NonNull FlatFragment _ComposedNode__ConnectionEnd = LIBRARY.createFragment(Types._ComposedNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _ComposedNode__Element = LIBRARY.createFragment(Types._ComposedNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _ComposedNode__Node = LIBRARY.createFragment(Types._ComposedNode, Types._Node);
		private static final @NonNull FlatFragment _ComposedNode__OclAny = LIBRARY.createFragment(Types._ComposedNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _ComposedNode__OclElement = LIBRARY.createFragment(Types._ComposedNode, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _CompositePartition__CompositePartition = LIBRARY.createFragment(Types._CompositePartition, Types._CompositePartition);
		private static final @NonNull FlatFragment _CompositePartition__Element = LIBRARY.createFragment(Types._CompositePartition, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _CompositePartition__NamedElement = LIBRARY.createFragment(Types._CompositePartition, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _CompositePartition__OclAny = LIBRARY.createFragment(Types._CompositePartition, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _CompositePartition__OclElement = LIBRARY.createFragment(Types._CompositePartition, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _CompositePartition__Partition = LIBRARY.createFragment(Types._CompositePartition, Types._Partition);

		private static final @NonNull FlatFragment _Connection__Connection = LIBRARY.createFragment(Types._Connection, Types._Connection);
		private static final @NonNull FlatFragment _Connection__Element = LIBRARY.createFragment(Types._Connection, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _Connection__OclAny = LIBRARY.createFragment(Types._Connection, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Connection__OclElement = LIBRARY.createFragment(Types._Connection, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Connection__Symbolable = LIBRARY.createFragment(Types._Connection, Types._Symbolable);

		private static final @NonNull FlatFragment _ConnectionEnd__ConnectionEnd = LIBRARY.createFragment(Types._ConnectionEnd, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _ConnectionEnd__OclAny = LIBRARY.createFragment(Types._ConnectionEnd, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _ConnectionEnd__OclElement = LIBRARY.createFragment(Types._ConnectionEnd, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _ConnectionRole__ConnectionRole = LIBRARY.createFragment(Types._ConnectionRole, Types._ConnectionRole);
		private static final @NonNull FlatFragment _ConnectionRole__OclAny = LIBRARY.createFragment(Types._ConnectionRole, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _ConnectionRole__OclElement = LIBRARY.createFragment(Types._ConnectionRole, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _ConnectionRole__OclEnumeration = LIBRARY.createFragment(Types._ConnectionRole, OCLstdlibTables.Types._OclEnumeration);
		private static final @NonNull FlatFragment _ConnectionRole__OclType = LIBRARY.createFragment(Types._ConnectionRole, OCLstdlibTables.Types._OclType);

		private static final @NonNull FlatFragment _CyclicMappingRegion__CyclicMappingRegion = LIBRARY.createFragment(Types._CyclicMappingRegion, Types._CyclicMappingRegion);
		private static final @NonNull FlatFragment _CyclicMappingRegion__Element = LIBRARY.createFragment(Types._CyclicMappingRegion, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _CyclicMappingRegion__MappingRegion = LIBRARY.createFragment(Types._CyclicMappingRegion, Types._MappingRegion);
		private static final @NonNull FlatFragment _CyclicMappingRegion__NamedElement = LIBRARY.createFragment(Types._CyclicMappingRegion, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _CyclicMappingRegion__OclAny = LIBRARY.createFragment(Types._CyclicMappingRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _CyclicMappingRegion__OclElement = LIBRARY.createFragment(Types._CyclicMappingRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _CyclicMappingRegion__Region = LIBRARY.createFragment(Types._CyclicMappingRegion, Types._Region);
		private static final @NonNull FlatFragment _CyclicMappingRegion__Symbolable = LIBRARY.createFragment(Types._CyclicMappingRegion, Types._Symbolable);

		private static final @NonNull FlatFragment _CyclicPartition__CompositePartition = LIBRARY.createFragment(Types._CyclicPartition, Types._CompositePartition);
		private static final @NonNull FlatFragment _CyclicPartition__CyclicPartition = LIBRARY.createFragment(Types._CyclicPartition, Types._CyclicPartition);
		private static final @NonNull FlatFragment _CyclicPartition__Element = LIBRARY.createFragment(Types._CyclicPartition, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _CyclicPartition__MappingPartition = LIBRARY.createFragment(Types._CyclicPartition, Types._MappingPartition);
		private static final @NonNull FlatFragment _CyclicPartition__NamedElement = LIBRARY.createFragment(Types._CyclicPartition, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _CyclicPartition__OclAny = LIBRARY.createFragment(Types._CyclicPartition, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _CyclicPartition__OclElement = LIBRARY.createFragment(Types._CyclicPartition, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _CyclicPartition__Partition = LIBRARY.createFragment(Types._CyclicPartition, Types._Partition);

		private static final @NonNull FlatFragment _DependencyEdge__DependencyEdge = LIBRARY.createFragment(Types._DependencyEdge, Types._DependencyEdge);
		private static final @NonNull FlatFragment _DependencyEdge__Edge = LIBRARY.createFragment(Types._DependencyEdge, Types._Edge);
		private static final @NonNull FlatFragment _DependencyEdge__Element = LIBRARY.createFragment(Types._DependencyEdge, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _DependencyEdge__OclAny = LIBRARY.createFragment(Types._DependencyEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _DependencyEdge__OclElement = LIBRARY.createFragment(Types._DependencyEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _DependencyNode__ConnectionEnd = LIBRARY.createFragment(Types._DependencyNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _DependencyNode__DependencyNode = LIBRARY.createFragment(Types._DependencyNode, Types._DependencyNode);
		private static final @NonNull FlatFragment _DependencyNode__Element = LIBRARY.createFragment(Types._DependencyNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _DependencyNode__Node = LIBRARY.createFragment(Types._DependencyNode, Types._Node);
		private static final @NonNull FlatFragment _DependencyNode__OclAny = LIBRARY.createFragment(Types._DependencyNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _DependencyNode__OclElement = LIBRARY.createFragment(Types._DependencyNode, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _DispatchRegion__DispatchRegion = LIBRARY.createFragment(Types._DispatchRegion, Types._DispatchRegion);
		private static final @NonNull FlatFragment _DispatchRegion__Element = LIBRARY.createFragment(Types._DispatchRegion, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _DispatchRegion__MappingRegion = LIBRARY.createFragment(Types._DispatchRegion, Types._MappingRegion);
		private static final @NonNull FlatFragment _DispatchRegion__NamedElement = LIBRARY.createFragment(Types._DispatchRegion, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _DispatchRegion__OclAny = LIBRARY.createFragment(Types._DispatchRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _DispatchRegion__OclElement = LIBRARY.createFragment(Types._DispatchRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _DispatchRegion__Region = LIBRARY.createFragment(Types._DispatchRegion, Types._Region);
		private static final @NonNull FlatFragment _DispatchRegion__RuleRegion = LIBRARY.createFragment(Types._DispatchRegion, Types._RuleRegion);
		private static final @NonNull FlatFragment _DispatchRegion__Symbolable = LIBRARY.createFragment(Types._DispatchRegion, Types._Symbolable);

		private static final @NonNull FlatFragment _Edge__Edge = LIBRARY.createFragment(Types._Edge, Types._Edge);
		private static final @NonNull FlatFragment _Edge__Element = LIBRARY.createFragment(Types._Edge, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _Edge__OclAny = LIBRARY.createFragment(Types._Edge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Edge__OclElement = LIBRARY.createFragment(Types._Edge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _EdgeConnection__Connection = LIBRARY.createFragment(Types._EdgeConnection, Types._Connection);
		private static final @NonNull FlatFragment _EdgeConnection__EdgeConnection = LIBRARY.createFragment(Types._EdgeConnection, Types._EdgeConnection);
		private static final @NonNull FlatFragment _EdgeConnection__Element = LIBRARY.createFragment(Types._EdgeConnection, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _EdgeConnection__OclAny = LIBRARY.createFragment(Types._EdgeConnection, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _EdgeConnection__OclElement = LIBRARY.createFragment(Types._EdgeConnection, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _EdgeConnection__Symbolable = LIBRARY.createFragment(Types._EdgeConnection, Types._Symbolable);

		private static final @NonNull FlatFragment _EnumLiteralNode__ConnectionEnd = LIBRARY.createFragment(Types._EnumLiteralNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _EnumLiteralNode__Element = LIBRARY.createFragment(Types._EnumLiteralNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _EnumLiteralNode__EnumLiteralNode = LIBRARY.createFragment(Types._EnumLiteralNode, Types._EnumLiteralNode);
		private static final @NonNull FlatFragment _EnumLiteralNode__MappingNode = LIBRARY.createFragment(Types._EnumLiteralNode, Types._MappingNode);
		private static final @NonNull FlatFragment _EnumLiteralNode__Node = LIBRARY.createFragment(Types._EnumLiteralNode, Types._Node);
		private static final @NonNull FlatFragment _EnumLiteralNode__OclAny = LIBRARY.createFragment(Types._EnumLiteralNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _EnumLiteralNode__OclElement = LIBRARY.createFragment(Types._EnumLiteralNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _EnumLiteralNode__OperationNode = LIBRARY.createFragment(Types._EnumLiteralNode, Types._OperationNode);

		private static final @NonNull FlatFragment _ErrorNode__ConnectionEnd = LIBRARY.createFragment(Types._ErrorNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _ErrorNode__Element = LIBRARY.createFragment(Types._ErrorNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _ErrorNode__ErrorNode = LIBRARY.createFragment(Types._ErrorNode, Types._ErrorNode);
		private static final @NonNull FlatFragment _ErrorNode__MappingNode = LIBRARY.createFragment(Types._ErrorNode, Types._MappingNode);
		private static final @NonNull FlatFragment _ErrorNode__Node = LIBRARY.createFragment(Types._ErrorNode, Types._Node);
		private static final @NonNull FlatFragment _ErrorNode__OclAny = LIBRARY.createFragment(Types._ErrorNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _ErrorNode__OclElement = LIBRARY.createFragment(Types._ErrorNode, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _ExpressionEdge__Edge = LIBRARY.createFragment(Types._ExpressionEdge, Types._Edge);
		private static final @NonNull FlatFragment _ExpressionEdge__Element = LIBRARY.createFragment(Types._ExpressionEdge, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _ExpressionEdge__ExpressionEdge = LIBRARY.createFragment(Types._ExpressionEdge, Types._ExpressionEdge);
		private static final @NonNull FlatFragment _ExpressionEdge__OclAny = LIBRARY.createFragment(Types._ExpressionEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _ExpressionEdge__OclElement = LIBRARY.createFragment(Types._ExpressionEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _IfNode__ConnectionEnd = LIBRARY.createFragment(Types._IfNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _IfNode__Element = LIBRARY.createFragment(Types._IfNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _IfNode__IfNode = LIBRARY.createFragment(Types._IfNode, Types._IfNode);
		private static final @NonNull FlatFragment _IfNode__MappingNode = LIBRARY.createFragment(Types._IfNode, Types._MappingNode);
		private static final @NonNull FlatFragment _IfNode__Node = LIBRARY.createFragment(Types._IfNode, Types._Node);
		private static final @NonNull FlatFragment _IfNode__OclAny = LIBRARY.createFragment(Types._IfNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _IfNode__OclElement = LIBRARY.createFragment(Types._IfNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _IfNode__OperationNode = LIBRARY.createFragment(Types._IfNode, Types._OperationNode);

		private static final @NonNull FlatFragment _IncludesEdge__Edge = LIBRARY.createFragment(Types._IncludesEdge, Types._Edge);
		private static final @NonNull FlatFragment _IncludesEdge__Element = LIBRARY.createFragment(Types._IncludesEdge, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _IncludesEdge__ExpressionEdge = LIBRARY.createFragment(Types._IncludesEdge, Types._ExpressionEdge);
		private static final @NonNull FlatFragment _IncludesEdge__IncludesEdge = LIBRARY.createFragment(Types._IncludesEdge, Types._IncludesEdge);
		private static final @NonNull FlatFragment _IncludesEdge__OclAny = LIBRARY.createFragment(Types._IncludesEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _IncludesEdge__OclElement = LIBRARY.createFragment(Types._IncludesEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _InputNode__ConnectionEnd = LIBRARY.createFragment(Types._InputNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _InputNode__Element = LIBRARY.createFragment(Types._InputNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _InputNode__InputNode = LIBRARY.createFragment(Types._InputNode, Types._InputNode);
		private static final @NonNull FlatFragment _InputNode__Node = LIBRARY.createFragment(Types._InputNode, Types._Node);
		private static final @NonNull FlatFragment _InputNode__OclAny = LIBRARY.createFragment(Types._InputNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _InputNode__OclElement = LIBRARY.createFragment(Types._InputNode, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _IteratedEdge__Edge = LIBRARY.createFragment(Types._IteratedEdge, Types._Edge);
		private static final @NonNull FlatFragment _IteratedEdge__Element = LIBRARY.createFragment(Types._IteratedEdge, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _IteratedEdge__IteratedEdge = LIBRARY.createFragment(Types._IteratedEdge, Types._IteratedEdge);
		private static final @NonNull FlatFragment _IteratedEdge__OclAny = LIBRARY.createFragment(Types._IteratedEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _IteratedEdge__OclElement = LIBRARY.createFragment(Types._IteratedEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _IteratorNode__ConnectionEnd = LIBRARY.createFragment(Types._IteratorNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _IteratorNode__Element = LIBRARY.createFragment(Types._IteratorNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _IteratorNode__IteratorNode = LIBRARY.createFragment(Types._IteratorNode, Types._IteratorNode);
		private static final @NonNull FlatFragment _IteratorNode__MappingNode = LIBRARY.createFragment(Types._IteratorNode, Types._MappingNode);
		private static final @NonNull FlatFragment _IteratorNode__Node = LIBRARY.createFragment(Types._IteratorNode, Types._Node);
		private static final @NonNull FlatFragment _IteratorNode__OclAny = LIBRARY.createFragment(Types._IteratorNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _IteratorNode__OclElement = LIBRARY.createFragment(Types._IteratorNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _IteratorNode__VariableNode = LIBRARY.createFragment(Types._IteratorNode, Types._VariableNode);

		private static final @NonNull FlatFragment _KeyPartEdge__ConnectionEnd = LIBRARY.createFragment(Types._KeyPartEdge, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _KeyPartEdge__Edge = LIBRARY.createFragment(Types._KeyPartEdge, Types._Edge);
		private static final @NonNull FlatFragment _KeyPartEdge__Element = LIBRARY.createFragment(Types._KeyPartEdge, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _KeyPartEdge__KeyPartEdge = LIBRARY.createFragment(Types._KeyPartEdge, Types._KeyPartEdge);
		private static final @NonNull FlatFragment _KeyPartEdge__NavigableEdge = LIBRARY.createFragment(Types._KeyPartEdge, Types._NavigableEdge);
		private static final @NonNull FlatFragment _KeyPartEdge__NavigationEdge = LIBRARY.createFragment(Types._KeyPartEdge, Types._NavigationEdge);
		private static final @NonNull FlatFragment _KeyPartEdge__OclAny = LIBRARY.createFragment(Types._KeyPartEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _KeyPartEdge__OclElement = LIBRARY.createFragment(Types._KeyPartEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _KeyedValueNode__ConnectionEnd = LIBRARY.createFragment(Types._KeyedValueNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _KeyedValueNode__Element = LIBRARY.createFragment(Types._KeyedValueNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _KeyedValueNode__KeyedValueNode = LIBRARY.createFragment(Types._KeyedValueNode, Types._KeyedValueNode);
		private static final @NonNull FlatFragment _KeyedValueNode__MappingNode = LIBRARY.createFragment(Types._KeyedValueNode, Types._MappingNode);
		private static final @NonNull FlatFragment _KeyedValueNode__Node = LIBRARY.createFragment(Types._KeyedValueNode, Types._Node);
		private static final @NonNull FlatFragment _KeyedValueNode__OclAny = LIBRARY.createFragment(Types._KeyedValueNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _KeyedValueNode__OclElement = LIBRARY.createFragment(Types._KeyedValueNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _KeyedValueNode__OperationNode = LIBRARY.createFragment(Types._KeyedValueNode, Types._OperationNode);

		private static final @NonNull FlatFragment _LoadingPartition__Element = LIBRARY.createFragment(Types._LoadingPartition, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _LoadingPartition__LoadingPartition = LIBRARY.createFragment(Types._LoadingPartition, Types._LoadingPartition);
		private static final @NonNull FlatFragment _LoadingPartition__MappingPartition = LIBRARY.createFragment(Types._LoadingPartition, Types._MappingPartition);
		private static final @NonNull FlatFragment _LoadingPartition__NamedElement = LIBRARY.createFragment(Types._LoadingPartition, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _LoadingPartition__OclAny = LIBRARY.createFragment(Types._LoadingPartition, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _LoadingPartition__OclElement = LIBRARY.createFragment(Types._LoadingPartition, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _LoadingPartition__Partition = LIBRARY.createFragment(Types._LoadingPartition, Types._Partition);

		private static final @NonNull FlatFragment _LoadingRegion__Element = LIBRARY.createFragment(Types._LoadingRegion, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _LoadingRegion__LoadingRegion = LIBRARY.createFragment(Types._LoadingRegion, Types._LoadingRegion);
		private static final @NonNull FlatFragment _LoadingRegion__NamedElement = LIBRARY.createFragment(Types._LoadingRegion, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _LoadingRegion__OclAny = LIBRARY.createFragment(Types._LoadingRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _LoadingRegion__OclElement = LIBRARY.createFragment(Types._LoadingRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _LoadingRegion__Region = LIBRARY.createFragment(Types._LoadingRegion, Types._Region);
		private static final @NonNull FlatFragment _LoadingRegion__Symbolable = LIBRARY.createFragment(Types._LoadingRegion, Types._Symbolable);

		private static final @NonNull FlatFragment _MapLiteralNode__ConnectionEnd = LIBRARY.createFragment(Types._MapLiteralNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _MapLiteralNode__Element = LIBRARY.createFragment(Types._MapLiteralNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _MapLiteralNode__MapLiteralNode = LIBRARY.createFragment(Types._MapLiteralNode, Types._MapLiteralNode);
		private static final @NonNull FlatFragment _MapLiteralNode__MappingNode = LIBRARY.createFragment(Types._MapLiteralNode, Types._MappingNode);
		private static final @NonNull FlatFragment _MapLiteralNode__Node = LIBRARY.createFragment(Types._MapLiteralNode, Types._Node);
		private static final @NonNull FlatFragment _MapLiteralNode__OclAny = LIBRARY.createFragment(Types._MapLiteralNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _MapLiteralNode__OclElement = LIBRARY.createFragment(Types._MapLiteralNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _MapLiteralNode__OperationNode = LIBRARY.createFragment(Types._MapLiteralNode, Types._OperationNode);

		private static final @NonNull FlatFragment _MapPartEdge__ArgumentEdge = LIBRARY.createFragment(Types._MapPartEdge, Types._ArgumentEdge);
		private static final @NonNull FlatFragment _MapPartEdge__Edge = LIBRARY.createFragment(Types._MapPartEdge, Types._Edge);
		private static final @NonNull FlatFragment _MapPartEdge__Element = LIBRARY.createFragment(Types._MapPartEdge, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _MapPartEdge__ExpressionEdge = LIBRARY.createFragment(Types._MapPartEdge, Types._ExpressionEdge);
		private static final @NonNull FlatFragment _MapPartEdge__MapPartEdge = LIBRARY.createFragment(Types._MapPartEdge, Types._MapPartEdge);
		private static final @NonNull FlatFragment _MapPartEdge__OclAny = LIBRARY.createFragment(Types._MapPartEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _MapPartEdge__OclElement = LIBRARY.createFragment(Types._MapPartEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _MapPartNode__ConnectionEnd = LIBRARY.createFragment(Types._MapPartNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _MapPartNode__Element = LIBRARY.createFragment(Types._MapPartNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _MapPartNode__MapPartNode = LIBRARY.createFragment(Types._MapPartNode, Types._MapPartNode);
		private static final @NonNull FlatFragment _MapPartNode__MappingNode = LIBRARY.createFragment(Types._MapPartNode, Types._MappingNode);
		private static final @NonNull FlatFragment _MapPartNode__Node = LIBRARY.createFragment(Types._MapPartNode, Types._Node);
		private static final @NonNull FlatFragment _MapPartNode__OclAny = LIBRARY.createFragment(Types._MapPartNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _MapPartNode__OclElement = LIBRARY.createFragment(Types._MapPartNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _MapPartNode__OperationNode = LIBRARY.createFragment(Types._MapPartNode, Types._OperationNode);

		private static final @NonNull FlatFragment _MappingNode__ConnectionEnd = LIBRARY.createFragment(Types._MappingNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _MappingNode__Element = LIBRARY.createFragment(Types._MappingNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _MappingNode__MappingNode = LIBRARY.createFragment(Types._MappingNode, Types._MappingNode);
		private static final @NonNull FlatFragment _MappingNode__Node = LIBRARY.createFragment(Types._MappingNode, Types._Node);
		private static final @NonNull FlatFragment _MappingNode__OclAny = LIBRARY.createFragment(Types._MappingNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _MappingNode__OclElement = LIBRARY.createFragment(Types._MappingNode, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _MappingPartition__Element = LIBRARY.createFragment(Types._MappingPartition, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _MappingPartition__MappingPartition = LIBRARY.createFragment(Types._MappingPartition, Types._MappingPartition);
		private static final @NonNull FlatFragment _MappingPartition__NamedElement = LIBRARY.createFragment(Types._MappingPartition, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _MappingPartition__OclAny = LIBRARY.createFragment(Types._MappingPartition, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _MappingPartition__OclElement = LIBRARY.createFragment(Types._MappingPartition, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _MappingPartition__Partition = LIBRARY.createFragment(Types._MappingPartition, Types._Partition);

		private static final @NonNull FlatFragment _MappingRegion__Element = LIBRARY.createFragment(Types._MappingRegion, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _MappingRegion__MappingRegion = LIBRARY.createFragment(Types._MappingRegion, Types._MappingRegion);
		private static final @NonNull FlatFragment _MappingRegion__NamedElement = LIBRARY.createFragment(Types._MappingRegion, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _MappingRegion__OclAny = LIBRARY.createFragment(Types._MappingRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _MappingRegion__OclElement = LIBRARY.createFragment(Types._MappingRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _MappingRegion__Region = LIBRARY.createFragment(Types._MappingRegion, Types._Region);
		private static final @NonNull FlatFragment _MappingRegion__Symbolable = LIBRARY.createFragment(Types._MappingRegion, Types._Symbolable);

		private static final @NonNull FlatFragment _MergedPartition__BasicPartition = LIBRARY.createFragment(Types._MergedPartition, Types._BasicPartition);
		private static final @NonNull FlatFragment _MergedPartition__Element = LIBRARY.createFragment(Types._MergedPartition, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _MergedPartition__MappingPartition = LIBRARY.createFragment(Types._MergedPartition, Types._MappingPartition);
		private static final @NonNull FlatFragment _MergedPartition__MergedPartition = LIBRARY.createFragment(Types._MergedPartition, Types._MergedPartition);
		private static final @NonNull FlatFragment _MergedPartition__NamedElement = LIBRARY.createFragment(Types._MergedPartition, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _MergedPartition__OclAny = LIBRARY.createFragment(Types._MergedPartition, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _MergedPartition__OclElement = LIBRARY.createFragment(Types._MergedPartition, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _MergedPartition__Partition = LIBRARY.createFragment(Types._MergedPartition, Types._Partition);

		private static final @NonNull FlatFragment _NavigableEdge__ConnectionEnd = LIBRARY.createFragment(Types._NavigableEdge, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _NavigableEdge__Edge = LIBRARY.createFragment(Types._NavigableEdge, Types._Edge);
		private static final @NonNull FlatFragment _NavigableEdge__Element = LIBRARY.createFragment(Types._NavigableEdge, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _NavigableEdge__NavigableEdge = LIBRARY.createFragment(Types._NavigableEdge, Types._NavigableEdge);
		private static final @NonNull FlatFragment _NavigableEdge__OclAny = LIBRARY.createFragment(Types._NavigableEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _NavigableEdge__OclElement = LIBRARY.createFragment(Types._NavigableEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _NavigationEdge__ConnectionEnd = LIBRARY.createFragment(Types._NavigationEdge, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _NavigationEdge__Edge = LIBRARY.createFragment(Types._NavigationEdge, Types._Edge);
		private static final @NonNull FlatFragment _NavigationEdge__Element = LIBRARY.createFragment(Types._NavigationEdge, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _NavigationEdge__NavigableEdge = LIBRARY.createFragment(Types._NavigationEdge, Types._NavigableEdge);
		private static final @NonNull FlatFragment _NavigationEdge__NavigationEdge = LIBRARY.createFragment(Types._NavigationEdge, Types._NavigationEdge);
		private static final @NonNull FlatFragment _NavigationEdge__OclAny = LIBRARY.createFragment(Types._NavigationEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _NavigationEdge__OclElement = LIBRARY.createFragment(Types._NavigationEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _Node__ConnectionEnd = LIBRARY.createFragment(Types._Node, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _Node__Element = LIBRARY.createFragment(Types._Node, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _Node__Node = LIBRARY.createFragment(Types._Node, Types._Node);
		private static final @NonNull FlatFragment _Node__OclAny = LIBRARY.createFragment(Types._Node, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Node__OclElement = LIBRARY.createFragment(Types._Node, OCLstdlibTables.Types._OclElement);

		private static final @NonNull FlatFragment _NodeConnection__Connection = LIBRARY.createFragment(Types._NodeConnection, Types._Connection);
		private static final @NonNull FlatFragment _NodeConnection__Element = LIBRARY.createFragment(Types._NodeConnection, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _NodeConnection__NodeConnection = LIBRARY.createFragment(Types._NodeConnection, Types._NodeConnection);
		private static final @NonNull FlatFragment _NodeConnection__OclAny = LIBRARY.createFragment(Types._NodeConnection, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _NodeConnection__OclElement = LIBRARY.createFragment(Types._NodeConnection, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _NodeConnection__Symbolable = LIBRARY.createFragment(Types._NodeConnection, Types._Symbolable);

		private static final @NonNull FlatFragment _NonPartition__Element = LIBRARY.createFragment(Types._NonPartition, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _NonPartition__MappingPartition = LIBRARY.createFragment(Types._NonPartition, Types._MappingPartition);
		private static final @NonNull FlatFragment _NonPartition__NamedElement = LIBRARY.createFragment(Types._NonPartition, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _NonPartition__NonPartition = LIBRARY.createFragment(Types._NonPartition, Types._NonPartition);
		private static final @NonNull FlatFragment _NonPartition__OclAny = LIBRARY.createFragment(Types._NonPartition, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _NonPartition__OclElement = LIBRARY.createFragment(Types._NonPartition, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _NonPartition__Partition = LIBRARY.createFragment(Types._NonPartition, Types._Partition);

		private static final @NonNull FlatFragment _NullLiteralNode__ConnectionEnd = LIBRARY.createFragment(Types._NullLiteralNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _NullLiteralNode__Element = LIBRARY.createFragment(Types._NullLiteralNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _NullLiteralNode__MappingNode = LIBRARY.createFragment(Types._NullLiteralNode, Types._MappingNode);
		private static final @NonNull FlatFragment _NullLiteralNode__Node = LIBRARY.createFragment(Types._NullLiteralNode, Types._Node);
		private static final @NonNull FlatFragment _NullLiteralNode__NullLiteralNode = LIBRARY.createFragment(Types._NullLiteralNode, Types._NullLiteralNode);
		private static final @NonNull FlatFragment _NullLiteralNode__OclAny = LIBRARY.createFragment(Types._NullLiteralNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _NullLiteralNode__OclElement = LIBRARY.createFragment(Types._NullLiteralNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _NullLiteralNode__OperationNode = LIBRARY.createFragment(Types._NullLiteralNode, Types._OperationNode);

		private static final @NonNull FlatFragment _Number__Number = LIBRARY.createFragment(Types._Number, Types._Number);
		private static final @NonNull FlatFragment _Number__OclAny = LIBRARY.createFragment(Types._Number, OCLstdlibTables.Types._OclAny);

		private static final @NonNull FlatFragment _NumericLiteralNode__ConnectionEnd = LIBRARY.createFragment(Types._NumericLiteralNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _NumericLiteralNode__Element = LIBRARY.createFragment(Types._NumericLiteralNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _NumericLiteralNode__MappingNode = LIBRARY.createFragment(Types._NumericLiteralNode, Types._MappingNode);
		private static final @NonNull FlatFragment _NumericLiteralNode__Node = LIBRARY.createFragment(Types._NumericLiteralNode, Types._Node);
		private static final @NonNull FlatFragment _NumericLiteralNode__NumericLiteralNode = LIBRARY.createFragment(Types._NumericLiteralNode, Types._NumericLiteralNode);
		private static final @NonNull FlatFragment _NumericLiteralNode__OclAny = LIBRARY.createFragment(Types._NumericLiteralNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _NumericLiteralNode__OclElement = LIBRARY.createFragment(Types._NumericLiteralNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _NumericLiteralNode__OperationNode = LIBRARY.createFragment(Types._NumericLiteralNode, Types._OperationNode);

		private static final @NonNull FlatFragment _OperationCallNode__ConnectionEnd = LIBRARY.createFragment(Types._OperationCallNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _OperationCallNode__Element = LIBRARY.createFragment(Types._OperationCallNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _OperationCallNode__MappingNode = LIBRARY.createFragment(Types._OperationCallNode, Types._MappingNode);
		private static final @NonNull FlatFragment _OperationCallNode__Node = LIBRARY.createFragment(Types._OperationCallNode, Types._Node);
		private static final @NonNull FlatFragment _OperationCallNode__OclAny = LIBRARY.createFragment(Types._OperationCallNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _OperationCallNode__OclElement = LIBRARY.createFragment(Types._OperationCallNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _OperationCallNode__OperationCallNode = LIBRARY.createFragment(Types._OperationCallNode, Types._OperationCallNode);
		private static final @NonNull FlatFragment _OperationCallNode__OperationNode = LIBRARY.createFragment(Types._OperationCallNode, Types._OperationNode);

		private static final @NonNull FlatFragment _OperationNode__ConnectionEnd = LIBRARY.createFragment(Types._OperationNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _OperationNode__Element = LIBRARY.createFragment(Types._OperationNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _OperationNode__MappingNode = LIBRARY.createFragment(Types._OperationNode, Types._MappingNode);
		private static final @NonNull FlatFragment _OperationNode__Node = LIBRARY.createFragment(Types._OperationNode, Types._Node);
		private static final @NonNull FlatFragment _OperationNode__OclAny = LIBRARY.createFragment(Types._OperationNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _OperationNode__OclElement = LIBRARY.createFragment(Types._OperationNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _OperationNode__OperationNode = LIBRARY.createFragment(Types._OperationNode, Types._OperationNode);

		private static final @NonNull FlatFragment _OperationParameterEdge__ArgumentEdge = LIBRARY.createFragment(Types._OperationParameterEdge, Types._ArgumentEdge);
		private static final @NonNull FlatFragment _OperationParameterEdge__Edge = LIBRARY.createFragment(Types._OperationParameterEdge, Types._Edge);
		private static final @NonNull FlatFragment _OperationParameterEdge__Element = LIBRARY.createFragment(Types._OperationParameterEdge, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _OperationParameterEdge__ExpressionEdge = LIBRARY.createFragment(Types._OperationParameterEdge, Types._ExpressionEdge);
		private static final @NonNull FlatFragment _OperationParameterEdge__OclAny = LIBRARY.createFragment(Types._OperationParameterEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _OperationParameterEdge__OclElement = LIBRARY.createFragment(Types._OperationParameterEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _OperationParameterEdge__OperationParameterEdge = LIBRARY.createFragment(Types._OperationParameterEdge, Types._OperationParameterEdge);

		private static final @NonNull FlatFragment _OperationRegion__Element = LIBRARY.createFragment(Types._OperationRegion, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _OperationRegion__NamedElement = LIBRARY.createFragment(Types._OperationRegion, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _OperationRegion__OclAny = LIBRARY.createFragment(Types._OperationRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _OperationRegion__OclElement = LIBRARY.createFragment(Types._OperationRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _OperationRegion__OperationRegion = LIBRARY.createFragment(Types._OperationRegion, Types._OperationRegion);
		private static final @NonNull FlatFragment _OperationRegion__Region = LIBRARY.createFragment(Types._OperationRegion, Types._Region);
		private static final @NonNull FlatFragment _OperationRegion__Symbolable = LIBRARY.createFragment(Types._OperationRegion, Types._Symbolable);

		private static final @NonNull FlatFragment _OperationSelfEdge__ArgumentEdge = LIBRARY.createFragment(Types._OperationSelfEdge, Types._ArgumentEdge);
		private static final @NonNull FlatFragment _OperationSelfEdge__Edge = LIBRARY.createFragment(Types._OperationSelfEdge, Types._Edge);
		private static final @NonNull FlatFragment _OperationSelfEdge__Element = LIBRARY.createFragment(Types._OperationSelfEdge, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _OperationSelfEdge__ExpressionEdge = LIBRARY.createFragment(Types._OperationSelfEdge, Types._ExpressionEdge);
		private static final @NonNull FlatFragment _OperationSelfEdge__OclAny = LIBRARY.createFragment(Types._OperationSelfEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _OperationSelfEdge__OclElement = LIBRARY.createFragment(Types._OperationSelfEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _OperationSelfEdge__OperationSelfEdge = LIBRARY.createFragment(Types._OperationSelfEdge, Types._OperationSelfEdge);

		private static final @NonNull FlatFragment _Partition__Element = LIBRARY.createFragment(Types._Partition, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _Partition__NamedElement = LIBRARY.createFragment(Types._Partition, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _Partition__OclAny = LIBRARY.createFragment(Types._Partition, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Partition__OclElement = LIBRARY.createFragment(Types._Partition, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Partition__Partition = LIBRARY.createFragment(Types._Partition, Types._Partition);

		private static final @NonNull FlatFragment _PatternTypedNode__ConnectionEnd = LIBRARY.createFragment(Types._PatternTypedNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _PatternTypedNode__Element = LIBRARY.createFragment(Types._PatternTypedNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _PatternTypedNode__MappingNode = LIBRARY.createFragment(Types._PatternTypedNode, Types._MappingNode);
		private static final @NonNull FlatFragment _PatternTypedNode__Node = LIBRARY.createFragment(Types._PatternTypedNode, Types._Node);
		private static final @NonNull FlatFragment _PatternTypedNode__OclAny = LIBRARY.createFragment(Types._PatternTypedNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _PatternTypedNode__OclElement = LIBRARY.createFragment(Types._PatternTypedNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _PatternTypedNode__PatternTypedNode = LIBRARY.createFragment(Types._PatternTypedNode, Types._PatternTypedNode);

		private static final @NonNull FlatFragment _PatternVariableNode__ConnectionEnd = LIBRARY.createFragment(Types._PatternVariableNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _PatternVariableNode__Element = LIBRARY.createFragment(Types._PatternVariableNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _PatternVariableNode__MappingNode = LIBRARY.createFragment(Types._PatternVariableNode, Types._MappingNode);
		private static final @NonNull FlatFragment _PatternVariableNode__Node = LIBRARY.createFragment(Types._PatternVariableNode, Types._Node);
		private static final @NonNull FlatFragment _PatternVariableNode__OclAny = LIBRARY.createFragment(Types._PatternVariableNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _PatternVariableNode__OclElement = LIBRARY.createFragment(Types._PatternVariableNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _PatternVariableNode__PatternVariableNode = LIBRARY.createFragment(Types._PatternVariableNode, Types._PatternVariableNode);
		private static final @NonNull FlatFragment _PatternVariableNode__VariableNode = LIBRARY.createFragment(Types._PatternVariableNode, Types._VariableNode);

		private static final @NonNull FlatFragment _PredicateEdge__Edge = LIBRARY.createFragment(Types._PredicateEdge, Types._Edge);
		private static final @NonNull FlatFragment _PredicateEdge__Element = LIBRARY.createFragment(Types._PredicateEdge, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _PredicateEdge__OclAny = LIBRARY.createFragment(Types._PredicateEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _PredicateEdge__OclElement = LIBRARY.createFragment(Types._PredicateEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _PredicateEdge__PredicateEdge = LIBRARY.createFragment(Types._PredicateEdge, Types._PredicateEdge);

		private static final @NonNull FlatFragment _PropertyDatum__AbstractDatum = LIBRARY.createFragment(Types._PropertyDatum, Types._AbstractDatum);
		private static final @NonNull FlatFragment _PropertyDatum__Element = LIBRARY.createFragment(Types._PropertyDatum, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _PropertyDatum__NamedElement = LIBRARY.createFragment(Types._PropertyDatum, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _PropertyDatum__OclAny = LIBRARY.createFragment(Types._PropertyDatum, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _PropertyDatum__OclElement = LIBRARY.createFragment(Types._PropertyDatum, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _PropertyDatum__PropertyDatum = LIBRARY.createFragment(Types._PropertyDatum, Types._PropertyDatum);

		private static final @NonNull FlatFragment _RecursionEdge__Edge = LIBRARY.createFragment(Types._RecursionEdge, Types._Edge);
		private static final @NonNull FlatFragment _RecursionEdge__Element = LIBRARY.createFragment(Types._RecursionEdge, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _RecursionEdge__OclAny = LIBRARY.createFragment(Types._RecursionEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _RecursionEdge__OclElement = LIBRARY.createFragment(Types._RecursionEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _RecursionEdge__RecursionEdge = LIBRARY.createFragment(Types._RecursionEdge, Types._RecursionEdge);

		private static final @NonNull FlatFragment _Region__Element = LIBRARY.createFragment(Types._Region, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _Region__NamedElement = LIBRARY.createFragment(Types._Region, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _Region__OclAny = LIBRARY.createFragment(Types._Region, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Region__OclElement = LIBRARY.createFragment(Types._Region, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Region__Region = LIBRARY.createFragment(Types._Region, Types._Region);
		private static final @NonNull FlatFragment _Region__Symbolable = LIBRARY.createFragment(Types._Region, Types._Symbolable);

		private static final @NonNull FlatFragment _Role__OclAny = LIBRARY.createFragment(Types._Role, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Role__OclElement = LIBRARY.createFragment(Types._Role, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Role__OclEnumeration = LIBRARY.createFragment(Types._Role, OCLstdlibTables.Types._OclEnumeration);
		private static final @NonNull FlatFragment _Role__OclType = LIBRARY.createFragment(Types._Role, OCLstdlibTables.Types._OclType);
		private static final @NonNull FlatFragment _Role__Role = LIBRARY.createFragment(Types._Role, Types._Role);

		private static final @NonNull FlatFragment _RootPartition__CompositePartition = LIBRARY.createFragment(Types._RootPartition, Types._CompositePartition);
		private static final @NonNull FlatFragment _RootPartition__Element = LIBRARY.createFragment(Types._RootPartition, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _RootPartition__NamedElement = LIBRARY.createFragment(Types._RootPartition, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _RootPartition__OclAny = LIBRARY.createFragment(Types._RootPartition, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _RootPartition__OclElement = LIBRARY.createFragment(Types._RootPartition, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _RootPartition__Partition = LIBRARY.createFragment(Types._RootPartition, Types._Partition);
		private static final @NonNull FlatFragment _RootPartition__RootPartition = LIBRARY.createFragment(Types._RootPartition, Types._RootPartition);

		private static final @NonNull FlatFragment _RootRegion__Element = LIBRARY.createFragment(Types._RootRegion, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _RootRegion__NamedElement = LIBRARY.createFragment(Types._RootRegion, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _RootRegion__OclAny = LIBRARY.createFragment(Types._RootRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _RootRegion__OclElement = LIBRARY.createFragment(Types._RootRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _RootRegion__Region = LIBRARY.createFragment(Types._RootRegion, Types._Region);
		private static final @NonNull FlatFragment _RootRegion__RootRegion = LIBRARY.createFragment(Types._RootRegion, Types._RootRegion);
		private static final @NonNull FlatFragment _RootRegion__Symbolable = LIBRARY.createFragment(Types._RootRegion, Types._Symbolable);

		private static final @NonNull FlatFragment _RuleRegion__Element = LIBRARY.createFragment(Types._RuleRegion, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _RuleRegion__MappingRegion = LIBRARY.createFragment(Types._RuleRegion, Types._MappingRegion);
		private static final @NonNull FlatFragment _RuleRegion__NamedElement = LIBRARY.createFragment(Types._RuleRegion, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _RuleRegion__OclAny = LIBRARY.createFragment(Types._RuleRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _RuleRegion__OclElement = LIBRARY.createFragment(Types._RuleRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _RuleRegion__Region = LIBRARY.createFragment(Types._RuleRegion, Types._Region);
		private static final @NonNull FlatFragment _RuleRegion__RuleRegion = LIBRARY.createFragment(Types._RuleRegion, Types._RuleRegion);
		private static final @NonNull FlatFragment _RuleRegion__Symbolable = LIBRARY.createFragment(Types._RuleRegion, Types._Symbolable);

		private static final @NonNull FlatFragment _ScheduleModel__Element = LIBRARY.createFragment(Types._ScheduleModel, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _ScheduleModel__Model = LIBRARY.createFragment(Types._ScheduleModel, PivotTables.Types._Model);
		private static final @NonNull FlatFragment _ScheduleModel__NamedElement = LIBRARY.createFragment(Types._ScheduleModel, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _ScheduleModel__Namespace = LIBRARY.createFragment(Types._ScheduleModel, PivotTables.Types._Namespace);
		private static final @NonNull FlatFragment _ScheduleModel__OclAny = LIBRARY.createFragment(Types._ScheduleModel, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _ScheduleModel__OclElement = LIBRARY.createFragment(Types._ScheduleModel, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _ScheduleModel__ScheduleModel = LIBRARY.createFragment(Types._ScheduleModel, Types._ScheduleModel);

		private static final @NonNull FlatFragment _ShadowNode__ConnectionEnd = LIBRARY.createFragment(Types._ShadowNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _ShadowNode__Element = LIBRARY.createFragment(Types._ShadowNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _ShadowNode__MappingNode = LIBRARY.createFragment(Types._ShadowNode, Types._MappingNode);
		private static final @NonNull FlatFragment _ShadowNode__Node = LIBRARY.createFragment(Types._ShadowNode, Types._Node);
		private static final @NonNull FlatFragment _ShadowNode__OclAny = LIBRARY.createFragment(Types._ShadowNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _ShadowNode__OclElement = LIBRARY.createFragment(Types._ShadowNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _ShadowNode__OperationNode = LIBRARY.createFragment(Types._ShadowNode, Types._OperationNode);
		private static final @NonNull FlatFragment _ShadowNode__ShadowNode = LIBRARY.createFragment(Types._ShadowNode, Types._ShadowNode);

		private static final @NonNull FlatFragment _ShadowPartEdge__ArgumentEdge = LIBRARY.createFragment(Types._ShadowPartEdge, Types._ArgumentEdge);
		private static final @NonNull FlatFragment _ShadowPartEdge__Edge = LIBRARY.createFragment(Types._ShadowPartEdge, Types._Edge);
		private static final @NonNull FlatFragment _ShadowPartEdge__Element = LIBRARY.createFragment(Types._ShadowPartEdge, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _ShadowPartEdge__ExpressionEdge = LIBRARY.createFragment(Types._ShadowPartEdge, Types._ExpressionEdge);
		private static final @NonNull FlatFragment _ShadowPartEdge__OclAny = LIBRARY.createFragment(Types._ShadowPartEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _ShadowPartEdge__OclElement = LIBRARY.createFragment(Types._ShadowPartEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _ShadowPartEdge__ShadowPartEdge = LIBRARY.createFragment(Types._ShadowPartEdge, Types._ShadowPartEdge);

		private static final @NonNull FlatFragment _StringLiteralNode__ConnectionEnd = LIBRARY.createFragment(Types._StringLiteralNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _StringLiteralNode__Element = LIBRARY.createFragment(Types._StringLiteralNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _StringLiteralNode__MappingNode = LIBRARY.createFragment(Types._StringLiteralNode, Types._MappingNode);
		private static final @NonNull FlatFragment _StringLiteralNode__Node = LIBRARY.createFragment(Types._StringLiteralNode, Types._Node);
		private static final @NonNull FlatFragment _StringLiteralNode__OclAny = LIBRARY.createFragment(Types._StringLiteralNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _StringLiteralNode__OclElement = LIBRARY.createFragment(Types._StringLiteralNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _StringLiteralNode__OperationNode = LIBRARY.createFragment(Types._StringLiteralNode, Types._OperationNode);
		private static final @NonNull FlatFragment _StringLiteralNode__StringLiteralNode = LIBRARY.createFragment(Types._StringLiteralNode, Types._StringLiteralNode);

		private static final @NonNull FlatFragment _SuccessEdge__ConnectionEnd = LIBRARY.createFragment(Types._SuccessEdge, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _SuccessEdge__Edge = LIBRARY.createFragment(Types._SuccessEdge, Types._Edge);
		private static final @NonNull FlatFragment _SuccessEdge__Element = LIBRARY.createFragment(Types._SuccessEdge, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _SuccessEdge__NavigableEdge = LIBRARY.createFragment(Types._SuccessEdge, Types._NavigableEdge);
		private static final @NonNull FlatFragment _SuccessEdge__NavigationEdge = LIBRARY.createFragment(Types._SuccessEdge, Types._NavigationEdge);
		private static final @NonNull FlatFragment _SuccessEdge__OclAny = LIBRARY.createFragment(Types._SuccessEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _SuccessEdge__OclElement = LIBRARY.createFragment(Types._SuccessEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _SuccessEdge__SuccessEdge = LIBRARY.createFragment(Types._SuccessEdge, Types._SuccessEdge);

		private static final @NonNull FlatFragment _SuccessNode__ConnectionEnd = LIBRARY.createFragment(Types._SuccessNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _SuccessNode__Element = LIBRARY.createFragment(Types._SuccessNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _SuccessNode__MappingNode = LIBRARY.createFragment(Types._SuccessNode, Types._MappingNode);
		private static final @NonNull FlatFragment _SuccessNode__Node = LIBRARY.createFragment(Types._SuccessNode, Types._Node);
		private static final @NonNull FlatFragment _SuccessNode__OclAny = LIBRARY.createFragment(Types._SuccessNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _SuccessNode__OclElement = LIBRARY.createFragment(Types._SuccessNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _SuccessNode__SuccessNode = LIBRARY.createFragment(Types._SuccessNode, Types._SuccessNode);

		private static final @NonNull FlatFragment _Symbolable__OclAny = LIBRARY.createFragment(Types._Symbolable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Symbolable__OclElement = LIBRARY.createFragment(Types._Symbolable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Symbolable__Symbolable = LIBRARY.createFragment(Types._Symbolable, Types._Symbolable);

		private static final @NonNull FlatFragment _TupleLiteralNode__ConnectionEnd = LIBRARY.createFragment(Types._TupleLiteralNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _TupleLiteralNode__Element = LIBRARY.createFragment(Types._TupleLiteralNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _TupleLiteralNode__MappingNode = LIBRARY.createFragment(Types._TupleLiteralNode, Types._MappingNode);
		private static final @NonNull FlatFragment _TupleLiteralNode__Node = LIBRARY.createFragment(Types._TupleLiteralNode, Types._Node);
		private static final @NonNull FlatFragment _TupleLiteralNode__OclAny = LIBRARY.createFragment(Types._TupleLiteralNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _TupleLiteralNode__OclElement = LIBRARY.createFragment(Types._TupleLiteralNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _TupleLiteralNode__OperationNode = LIBRARY.createFragment(Types._TupleLiteralNode, Types._OperationNode);
		private static final @NonNull FlatFragment _TupleLiteralNode__TupleLiteralNode = LIBRARY.createFragment(Types._TupleLiteralNode, Types._TupleLiteralNode);

		private static final @NonNull FlatFragment _TuplePartEdge__ArgumentEdge = LIBRARY.createFragment(Types._TuplePartEdge, Types._ArgumentEdge);
		private static final @NonNull FlatFragment _TuplePartEdge__Edge = LIBRARY.createFragment(Types._TuplePartEdge, Types._Edge);
		private static final @NonNull FlatFragment _TuplePartEdge__Element = LIBRARY.createFragment(Types._TuplePartEdge, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _TuplePartEdge__ExpressionEdge = LIBRARY.createFragment(Types._TuplePartEdge, Types._ExpressionEdge);
		private static final @NonNull FlatFragment _TuplePartEdge__OclAny = LIBRARY.createFragment(Types._TuplePartEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _TuplePartEdge__OclElement = LIBRARY.createFragment(Types._TuplePartEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _TuplePartEdge__TuplePartEdge = LIBRARY.createFragment(Types._TuplePartEdge, Types._TuplePartEdge);

		private static final @NonNull FlatFragment _TypeLiteralNode__ConnectionEnd = LIBRARY.createFragment(Types._TypeLiteralNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _TypeLiteralNode__Element = LIBRARY.createFragment(Types._TypeLiteralNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _TypeLiteralNode__MappingNode = LIBRARY.createFragment(Types._TypeLiteralNode, Types._MappingNode);
		private static final @NonNull FlatFragment _TypeLiteralNode__Node = LIBRARY.createFragment(Types._TypeLiteralNode, Types._Node);
		private static final @NonNull FlatFragment _TypeLiteralNode__OclAny = LIBRARY.createFragment(Types._TypeLiteralNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _TypeLiteralNode__OclElement = LIBRARY.createFragment(Types._TypeLiteralNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _TypeLiteralNode__OperationNode = LIBRARY.createFragment(Types._TypeLiteralNode, Types._OperationNode);
		private static final @NonNull FlatFragment _TypeLiteralNode__TypeLiteralNode = LIBRARY.createFragment(Types._TypeLiteralNode, Types._TypeLiteralNode);

		private static final @NonNull FlatFragment _UnknownNode__ConnectionEnd = LIBRARY.createFragment(Types._UnknownNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _UnknownNode__Element = LIBRARY.createFragment(Types._UnknownNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _UnknownNode__MappingNode = LIBRARY.createFragment(Types._UnknownNode, Types._MappingNode);
		private static final @NonNull FlatFragment _UnknownNode__Node = LIBRARY.createFragment(Types._UnknownNode, Types._Node);
		private static final @NonNull FlatFragment _UnknownNode__OclAny = LIBRARY.createFragment(Types._UnknownNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _UnknownNode__OclElement = LIBRARY.createFragment(Types._UnknownNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _UnknownNode__UnknownNode = LIBRARY.createFragment(Types._UnknownNode, Types._UnknownNode);

		private static final @NonNull FlatFragment _Utility__OclAny = LIBRARY.createFragment(Types._Utility, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Utility__OclElement = LIBRARY.createFragment(Types._Utility, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Utility__OclEnumeration = LIBRARY.createFragment(Types._Utility, OCLstdlibTables.Types._OclEnumeration);
		private static final @NonNull FlatFragment _Utility__OclType = LIBRARY.createFragment(Types._Utility, OCLstdlibTables.Types._OclType);
		private static final @NonNull FlatFragment _Utility__Utility = LIBRARY.createFragment(Types._Utility, Types._Utility);

		private static final @NonNull FlatFragment _VariableNode__ConnectionEnd = LIBRARY.createFragment(Types._VariableNode, Types._ConnectionEnd);
		private static final @NonNull FlatFragment _VariableNode__Element = LIBRARY.createFragment(Types._VariableNode, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _VariableNode__MappingNode = LIBRARY.createFragment(Types._VariableNode, Types._MappingNode);
		private static final @NonNull FlatFragment _VariableNode__Node = LIBRARY.createFragment(Types._VariableNode, Types._Node);
		private static final @NonNull FlatFragment _VariableNode__OclAny = LIBRARY.createFragment(Types._VariableNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _VariableNode__OclElement = LIBRARY.createFragment(Types._VariableNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _VariableNode__VariableNode = LIBRARY.createFragment(Types._VariableNode, Types._VariableNode);

		private static final @NonNull FlatFragment _VerdictRegion__Element = LIBRARY.createFragment(Types._VerdictRegion, PivotTables.Types._Element);
		private static final @NonNull FlatFragment _VerdictRegion__MappingRegion = LIBRARY.createFragment(Types._VerdictRegion, Types._MappingRegion);
		private static final @NonNull FlatFragment _VerdictRegion__NamedElement = LIBRARY.createFragment(Types._VerdictRegion, PivotTables.Types._NamedElement);
		private static final @NonNull FlatFragment _VerdictRegion__OclAny = LIBRARY.createFragment(Types._VerdictRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _VerdictRegion__OclElement = LIBRARY.createFragment(Types._VerdictRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _VerdictRegion__Region = LIBRARY.createFragment(Types._VerdictRegion, Types._Region);
		private static final @NonNull FlatFragment _VerdictRegion__RuleRegion = LIBRARY.createFragment(Types._VerdictRegion, Types._RuleRegion);
		private static final @NonNull FlatFragment _VerdictRegion__Symbolable = LIBRARY.createFragment(Types._VerdictRegion, Types._Symbolable);
		private static final @NonNull FlatFragment _VerdictRegion__VerdictRegion = LIBRARY.createFragment(Types._VerdictRegion, Types._VerdictRegion);

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

		public static final @NonNull Property _BasicPartition__constantEdges = LIBRARY.createProperty(Types._BasicPartition, QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_EDGES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Edge), 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _BasicPartition__constantNodes = LIBRARY.createProperty(Types._BasicPartition, QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Node), 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _BasicPartition__constantSuccessFalseNodes = LIBRARY.createProperty(Types._BasicPartition, QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_SUCCESS_FALSE_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Node), 2 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _BasicPartition__constantSuccessTrueNodes = LIBRARY.createProperty(Types._BasicPartition, QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_SUCCESS_TRUE_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Node), 3 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _BasicPartition__explicitPredecessors = LIBRARY.createProperty(Types._BasicPartition, QVTschedulePackage.Literals.BASIC_PARTITION__EXPLICIT_PREDECESSORS, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._MappingPartition), 4 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _BasicPartition__headNodes = LIBRARY.createProperty(Types._BasicPartition, QVTschedulePackage.Literals.BASIC_PARTITION__HEAD_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Node), 5 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _BasicPartition__loadedEdges = LIBRARY.createProperty(Types._BasicPartition, QVTschedulePackage.Literals.BASIC_PARTITION__LOADED_EDGES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Edge), 6 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _BasicPartition__loadedNodes = LIBRARY.createProperty(Types._BasicPartition, QVTschedulePackage.Literals.BASIC_PARTITION__LOADED_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Node), 7 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _BasicPartition__owningMergedPartition = LIBRARY.createProperty(Types._BasicPartition, QVTschedulePackage.Literals.BASIC_PARTITION__OWNING_MERGED_PARTITION, Types._MergedPartition, 8 | IsResolveProxies);
		public static final @NonNull Property _BasicPartition__predicatedEdges = LIBRARY.createProperty(Types._BasicPartition, QVTschedulePackage.Literals.BASIC_PARTITION__PREDICATED_EDGES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Edge), 9 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _BasicPartition__predicatedNodes = LIBRARY.createProperty(Types._BasicPartition, QVTschedulePackage.Literals.BASIC_PARTITION__PREDICATED_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Node), 10 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _BasicPartition__realizedEdges = LIBRARY.createProperty(Types._BasicPartition, QVTschedulePackage.Literals.BASIC_PARTITION__REALIZED_EDGES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Edge), 11 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _BasicPartition__realizedNodes = LIBRARY.createProperty(Types._BasicPartition, QVTschedulePackage.Literals.BASIC_PARTITION__REALIZED_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Node), 12 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _BasicPartition__speculatedEdges = LIBRARY.createProperty(Types._BasicPartition, QVTschedulePackage.Literals.BASIC_PARTITION__SPECULATED_EDGES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Edge), 13 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _BasicPartition__speculatedNodes = LIBRARY.createProperty(Types._BasicPartition, QVTschedulePackage.Literals.BASIC_PARTITION__SPECULATED_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Node), 14 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _BasicPartition__speculationNodes = LIBRARY.createProperty(Types._BasicPartition, QVTschedulePackage.Literals.BASIC_PARTITION__SPECULATION_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Node), 15 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _BooleanLiteralNode__booleanValue = LIBRARY.createProperty(Types._BooleanLiteralNode, QVTschedulePackage.Literals.BOOLEAN_LITERAL_NODE__BOOLEAN_VALUE, OCLstdlibTables.Types._Boolean, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _CastEdge__referredClassDatum = LIBRARY.createProperty(Types._CastEdge, QVTschedulePackage.Literals.CAST_EDGE__REFERRED_CLASS_DATUM, Types._ClassDatum, 0 | IsDerived | IsRequired | IsResolveProxies | IsTransient);

		public static final @NonNull Property _ClassDatum__completeClasses = LIBRARY.createProperty(Types._ClassDatum, QVTschedulePackage.Literals.CLASS_DATUM__COMPLETE_CLASSES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, PivotTables.Types._CompleteClass), 0 | IsDerived | IsRequired | IsResolveProxies | IsTransient);
		public static final @NonNull Property _ClassDatum__ownedPropertyDatums = LIBRARY.createProperty(Types._ClassDatum, QVTschedulePackage.Literals.CLASS_DATUM__OWNED_PROPERTY_DATUMS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._PropertyDatum), 1 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _ClassDatum__owningScheduleModel = LIBRARY.createProperty(Types._ClassDatum, QVTschedulePackage.Literals.CLASS_DATUM__OWNING_SCHEDULE_MODEL, Types._ScheduleModel, 2 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _ClassDatum__referredClass = LIBRARY.createProperty(Types._ClassDatum, QVTschedulePackage.Literals.CLASS_DATUM__REFERRED_CLASS, PivotTables.Types._Class, 3 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _ClassDatum__referredTypedModel = LIBRARY.createProperty(Types._ClassDatum, QVTschedulePackage.Literals.CLASS_DATUM__REFERRED_TYPED_MODEL, QVTbaseTables.Types._TypedModel, 4 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _ClassDatum__superClassDatums = LIBRARY.createProperty(Types._ClassDatum, QVTschedulePackage.Literals.CLASS_DATUM__SUPER_CLASS_DATUMS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._ClassDatum), 5 | IsRequired | IsResolveProxies | IsTransient);
		public static final @NonNull Property _ClassDatum__CastEdge__referredClassDatum = LIBRARY.createOppositeProperty(Types._ClassDatum, "CastEdge", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._CastEdge), 6 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.CAST_EDGE__REFERRED_CLASS_DATUM);
		public static final @NonNull Property _ClassDatum__ClassDatum__superClassDatums = LIBRARY.createOppositeProperty(Types._ClassDatum, "ClassDatum", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._ClassDatum), 7 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.CLASS_DATUM__SUPER_CLASS_DATUMS);
		public static final @NonNull Property _ClassDatum__CollectionClassDatum__elementalClassDatum = LIBRARY.createOppositeProperty(Types._ClassDatum, "CollectionClassDatum", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._CollectionClassDatum), 8 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.COLLECTION_CLASS_DATUM__ELEMENTAL_CLASS_DATUM);
		public static final @NonNull Property _ClassDatum__KeyedValueNode__classDatumValue = LIBRARY.createOppositeProperty(Types._ClassDatum, "KeyedValueNode", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._KeyedValueNode), 9 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.KEYED_VALUE_NODE__CLASS_DATUM_VALUE);
		public static final @NonNull Property _ClassDatum__Node__classDatum = LIBRARY.createOppositeProperty(Types._ClassDatum, "Node", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._Node), 10 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.NODE__CLASS_DATUM);
		public static final @NonNull Property _ClassDatum__NodeConnection__classDatum = LIBRARY.createOppositeProperty(Types._ClassDatum, "NodeConnection", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._NodeConnection), 11 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.NODE_CONNECTION__CLASS_DATUM);
		public static final @NonNull Property _ClassDatum__PropertyDatum__targetClassDatum = LIBRARY.createOppositeProperty(Types._ClassDatum, "PropertyDatum", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._PropertyDatum), 12 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.PROPERTY_DATUM__TARGET_CLASS_DATUM);

		public static final @NonNull Property _Cluster__depth = LIBRARY.createProperty(Types._Cluster, QVTschedulePackage.Literals.CLUSTER__DEPTH, OCLstdlibTables.Types._Integer, 0 | IsResolveProxies);
		public static final @NonNull Property _Cluster__memberEdges = LIBRARY.createProperty(Types._Cluster, QVTschedulePackage.Literals.CLUSTER__MEMBER_EDGES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Edge), 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Cluster__memberNodes = LIBRARY.createProperty(Types._Cluster, QVTschedulePackage.Literals.CLUSTER__MEMBER_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Node), 2 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Cluster__owningRegion = LIBRARY.createProperty(Types._Cluster, QVTschedulePackage.Literals.CLUSTER__OWNING_REGION, Types._Region, 3 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Cluster__precedingClusters = LIBRARY.createProperty(Types._Cluster, QVTschedulePackage.Literals.CLUSTER__PRECEDING_CLUSTERS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Cluster), 4 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Cluster__succeedingClusters = LIBRARY.createProperty(Types._Cluster, QVTschedulePackage.Literals.CLUSTER__SUCCEEDING_CLUSTERS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Cluster), 5 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _CollectionClassDatum__elementalClassDatum = LIBRARY.createProperty(Types._CollectionClassDatum, QVTschedulePackage.Literals.COLLECTION_CLASS_DATUM__ELEMENTAL_CLASS_DATUM, Types._ClassDatum, 0 | IsDerived | IsResolveProxies | IsTransient);

		public static final @NonNull Property _CollectionPartEdge__referredPart = LIBRARY.createProperty(Types._CollectionPartEdge, QVTschedulePackage.Literals.COLLECTION_PART_EDGE__REFERRED_PART, PivotTables.Types._CollectionLiteralPart, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _CompositePartition__ownedMappingPartitions = LIBRARY.createProperty(Types._CompositePartition, QVTschedulePackage.Literals.COMPOSITE_PARTITION__OWNED_MAPPING_PARTITIONS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._MappingPartition), 0 | IsComposite | IsRequired | IsResolveProxies);

		public static final @NonNull Property _Connection__commonPartition = LIBRARY.createProperty(Types._Connection, QVTschedulePackage.Literals.CONNECTION__COMMON_PARTITION, Types._Partition, 0 | IsResolveProxies);
		public static final @NonNull Property _Connection__connectionRole = LIBRARY.createProperty(Types._Connection, QVTschedulePackage.Literals.CONNECTION__CONNECTION_ROLE, Types._ConnectionRole, 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Connection__intermediatePartitions = LIBRARY.createProperty(Types._Connection, QVTschedulePackage.Literals.CONNECTION__INTERMEDIATE_PARTITIONS, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Partition), 2 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Connection__name = LIBRARY.createProperty(Types._Connection, QVTschedulePackage.Literals.CONNECTION__NAME, OCLstdlibTables.Types._String, 3 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Connection__owningRootRegion = LIBRARY.createProperty(Types._Connection, QVTschedulePackage.Literals.CONNECTION__OWNING_ROOT_REGION, Types._RootRegion, 4 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Connection__sourceEnds = LIBRARY.createProperty(Types._Connection, QVTschedulePackage.Literals.CONNECTION__SOURCE_ENDS, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._ConnectionEnd), 5 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _ConnectionEnd__Connection__sourceEnds = LIBRARY.createOppositeProperty(Types._ConnectionEnd, "Connection", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._Connection), 0 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.CONNECTION__SOURCE_ENDS);

		public static final @NonNull Property _CyclicMappingRegion__elementRegions = LIBRARY.createProperty(Types._CyclicMappingRegion, QVTschedulePackage.Literals.CYCLIC_MAPPING_REGION__ELEMENT_REGIONS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._MappingRegion), 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _DispatchRegion__referredRuleRegion = LIBRARY.createProperty(Types._DispatchRegion, QVTschedulePackage.Literals.DISPATCH_REGION__REFERRED_RULE_REGION, Types._RuleRegion, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _Edge__cluster = LIBRARY.createProperty(Types._Edge, QVTschedulePackage.Literals.EDGE__CLUSTER, Types._Cluster, 0 | IsResolveProxies);
		public static final @NonNull Property _Edge__edgeRole = LIBRARY.createProperty(Types._Edge, QVTschedulePackage.Literals.EDGE__EDGE_ROLE, Types._Role, 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Edge__name = LIBRARY.createProperty(Types._Edge, QVTschedulePackage.Literals.EDGE__NAME, OCLstdlibTables.Types._String, 2 | IsResolveProxies);
		public static final @NonNull Property _Edge__owningRegion = LIBRARY.createProperty(Types._Edge, QVTschedulePackage.Literals.EDGE__OWNING_REGION, Types._Region, 3 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Edge__sourceNode = LIBRARY.createProperty(Types._Edge, QVTschedulePackage.Literals.EDGE__SOURCE_NODE, Types._Node, 4 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Edge__targetNode = LIBRARY.createProperty(Types._Edge, QVTschedulePackage.Literals.EDGE__TARGET_NODE, Types._Node, 5 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Edge__utility = LIBRARY.createProperty(Types._Edge, QVTschedulePackage.Literals.EDGE__UTILITY, Types._Utility, 6 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Edge__BasicPartition__constantEdges = LIBRARY.createOppositeProperty(Types._Edge, "BasicPartition", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._BasicPartition), 7 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_EDGES);
		public static final @NonNull Property _Edge__BasicPartition__loadedEdges = LIBRARY.createOppositeProperty(Types._Edge, "BasicPartition", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._BasicPartition), 8 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.BASIC_PARTITION__LOADED_EDGES);
		public static final @NonNull Property _Edge__BasicPartition__predicatedEdges = LIBRARY.createOppositeProperty(Types._Edge, "BasicPartition", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._BasicPartition), 9 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.BASIC_PARTITION__PREDICATED_EDGES);
		public static final @NonNull Property _Edge__BasicPartition__realizedEdges = LIBRARY.createOppositeProperty(Types._Edge, "BasicPartition", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._BasicPartition), 10 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.BASIC_PARTITION__REALIZED_EDGES);
		public static final @NonNull Property _Edge__BasicPartition__speculatedEdges = LIBRARY.createOppositeProperty(Types._Edge, "BasicPartition", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._BasicPartition), 11 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.BASIC_PARTITION__SPECULATED_EDGES);

		public static final @NonNull Property _EdgeConnection__mandatoryTargetEdges = LIBRARY.createProperty(Types._EdgeConnection, QVTschedulePackage.Literals.EDGE_CONNECTION__MANDATORY_TARGET_EDGES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._NavigableEdge), 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _EdgeConnection__preferredTargetEdges = LIBRARY.createProperty(Types._EdgeConnection, QVTschedulePackage.Literals.EDGE_CONNECTION__PREFERRED_TARGET_EDGES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._NavigableEdge), 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _EdgeConnection__referredProperty = LIBRARY.createProperty(Types._EdgeConnection, QVTschedulePackage.Literals.EDGE_CONNECTION__REFERRED_PROPERTY, PivotTables.Types._Property, 2 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _EdgeConnection__NavigableEdge__incomingConnection = LIBRARY.createOppositeProperty(Types._EdgeConnection, "NavigableEdge", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._NavigableEdge), 3 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.NAVIGABLE_EDGE__INCOMING_CONNECTION);
		public static final @NonNull Property _EdgeConnection__NavigableEdge__outgoingConnections = LIBRARY.createOppositeProperty(Types._EdgeConnection, "NavigableEdge", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._NavigableEdge), 4 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.NAVIGABLE_EDGE__OUTGOING_CONNECTIONS);

		public static final @NonNull Property _EnumLiteralNode__enumValue = LIBRARY.createProperty(Types._EnumLiteralNode, QVTschedulePackage.Literals.ENUM_LITERAL_NODE__ENUM_VALUE, PivotTables.Types._EnumerationLiteral, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _KeyPartEdge__referredPart = LIBRARY.createProperty(Types._KeyPartEdge, QVTschedulePackage.Literals.KEY_PART_EDGE__REFERRED_PART, Types._PropertyDatum, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _KeyedValueNode__classDatumValue = LIBRARY.createProperty(Types._KeyedValueNode, QVTschedulePackage.Literals.KEYED_VALUE_NODE__CLASS_DATUM_VALUE, Types._ClassDatum, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _LoadingPartition__referredLoadingRegion = LIBRARY.createProperty(Types._LoadingPartition, QVTschedulePackage.Literals.LOADING_PARTITION__REFERRED_LOADING_REGION, Types._LoadingRegion, 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _LoadingPartition__RootPartition__loadingPartition = LIBRARY.createOppositeProperty(Types._LoadingPartition, "RootPartition", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._RootPartition), 1 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.ROOT_PARTITION__LOADING_PARTITION);

		public static final @NonNull Property _LoadingRegion__loadingPartition = LIBRARY.createProperty(Types._LoadingRegion, QVTschedulePackage.Literals.LOADING_REGION__LOADING_PARTITION, Types._LoadingPartition, 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _LoadingRegion__owningRootRegion = LIBRARY.createProperty(Types._LoadingRegion, QVTschedulePackage.Literals.LOADING_REGION__OWNING_ROOT_REGION, Types._RootRegion, 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _LoadingRegion__targetName = LIBRARY.createProperty(Types._LoadingRegion, QVTschedulePackage.Literals.LOADING_REGION__TARGET_NAME, OCLstdlibTables.Types._String, 2 | IsResolveProxies);

		public static final @NonNull Property _MapPartEdge__referredPart = LIBRARY.createProperty(Types._MapPartEdge, QVTschedulePackage.Literals.MAP_PART_EDGE__REFERRED_PART, PivotTables.Types._MapLiteralPart, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _MappingPartition__explicitSuccessors = LIBRARY.createProperty(Types._MappingPartition, QVTschedulePackage.Literals.MAPPING_PARTITION__EXPLICIT_SUCCESSORS, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._BasicPartition), 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _MappingPartition__owningCompositePartition = LIBRARY.createProperty(Types._MappingPartition, QVTschedulePackage.Literals.MAPPING_PARTITION__OWNING_COMPOSITE_PARTITION, Types._CompositePartition, 1 | IsResolveProxies);
		public static final @NonNull Property _MappingPartition__referedMappingRegion = LIBRARY.createProperty(Types._MappingPartition, QVTschedulePackage.Literals.MAPPING_PARTITION__REFERED_MAPPING_REGION, Types._MappingRegion, 2 | IsResolveProxies);
		public static final @NonNull Property _MappingPartition__region = LIBRARY.createProperty(Types._MappingPartition, QVTschedulePackage.Literals.MAPPING_PARTITION__REGION, Types._Region, 3 | IsDerived | IsReadOnly | IsResolveProxies | IsTransient | IsVolatile);

		public static final @NonNull Property _MappingRegion__headNodes = LIBRARY.createProperty(Types._MappingRegion, QVTschedulePackage.Literals.MAPPING_REGION__HEAD_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Node), 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _MappingRegion__mappingPartitions = LIBRARY.createProperty(Types._MappingRegion, QVTschedulePackage.Literals.MAPPING_REGION__MAPPING_PARTITIONS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._MappingPartition), 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _MappingRegion__owningScheduleModel = LIBRARY.createProperty(Types._MappingRegion, QVTschedulePackage.Literals.MAPPING_REGION__OWNING_SCHEDULE_MODEL, Types._ScheduleModel, 2 | IsResolveProxies);
		public static final @NonNull Property _MappingRegion__CyclicMappingRegion__elementRegions = LIBRARY.createOppositeProperty(Types._MappingRegion, "CyclicMappingRegion", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._CyclicMappingRegion), 3 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.CYCLIC_MAPPING_REGION__ELEMENT_REGIONS);

		public static final @NonNull Property _MergedPartition__ownedMergedPartitions = LIBRARY.createProperty(Types._MergedPartition, QVTschedulePackage.Literals.MERGED_PARTITION__OWNED_MERGED_PARTITIONS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._BasicPartition), 0 | IsComposite | IsRequired | IsResolveProxies);

		public static final @NonNull Property _NavigableEdge__incomingConnection = LIBRARY.createProperty(Types._NavigableEdge, QVTschedulePackage.Literals.NAVIGABLE_EDGE__INCOMING_CONNECTION, Types._EdgeConnection, 0 | IsResolveProxies);
		public static final @NonNull Property _NavigableEdge__outgoingConnections = LIBRARY.createProperty(Types._NavigableEdge, QVTschedulePackage.Literals.NAVIGABLE_EDGE__OUTGOING_CONNECTIONS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._EdgeConnection), 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _NavigableEdge__EdgeConnection__mandatoryTargetEdges = LIBRARY.createOppositeProperty(Types._NavigableEdge, "EdgeConnection", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._EdgeConnection), 2 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.EDGE_CONNECTION__MANDATORY_TARGET_EDGES);
		public static final @NonNull Property _NavigableEdge__EdgeConnection__preferredTargetEdges = LIBRARY.createOppositeProperty(Types._NavigableEdge, "EdgeConnection", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._EdgeConnection), 3 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.EDGE_CONNECTION__PREFERRED_TARGET_EDGES);

		public static final @NonNull Property _NavigationEdge__oppositeEdge = LIBRARY.createProperty(Types._NavigationEdge, QVTschedulePackage.Literals.NAVIGATION_EDGE__OPPOSITE_EDGE, Types._NavigationEdge, 0 | IsResolveProxies);
		public static final @NonNull Property _NavigationEdge__partial = LIBRARY.createProperty(Types._NavigationEdge, QVTschedulePackage.Literals.NAVIGATION_EDGE__PARTIAL, OCLstdlibTables.Types._Boolean, 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _NavigationEdge__referredProperty = LIBRARY.createProperty(Types._NavigationEdge, QVTschedulePackage.Literals.NAVIGATION_EDGE__REFERRED_PROPERTY, PivotTables.Types._Property, 2 | IsResolveProxies | IsTransient);
		public static final @NonNull Property _NavigationEdge__secondary = LIBRARY.createProperty(Types._NavigationEdge, QVTschedulePackage.Literals.NAVIGATION_EDGE__SECONDARY, OCLstdlibTables.Types._Boolean, 3 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _NavigationEdge__NavigationEdge__oppositeEdge = LIBRARY.createOppositeProperty(Types._NavigationEdge, "NavigationEdge", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._NavigationEdge), 4 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.NAVIGATION_EDGE__OPPOSITE_EDGE);

		public static final @NonNull Property _Node__classDatum = LIBRARY.createProperty(Types._Node, QVTschedulePackage.Literals.NODE__CLASS_DATUM, Types._ClassDatum, 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Node__cluster = LIBRARY.createProperty(Types._Node, QVTschedulePackage.Literals.NODE__CLUSTER, Types._Cluster, 1 | IsResolveProxies);
		public static final @NonNull Property _Node__incomingConnection = LIBRARY.createProperty(Types._Node, QVTschedulePackage.Literals.NODE__INCOMING_CONNECTION, Types._NodeConnection, 2 | IsResolveProxies);
		public static final @NonNull Property _Node__incomingEdges = LIBRARY.createProperty(Types._Node, QVTschedulePackage.Literals.NODE__INCOMING_EDGES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Edge), 3 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Node__name = LIBRARY.createProperty(Types._Node, QVTschedulePackage.Literals.NODE__NAME, OCLstdlibTables.Types._String, 4 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Node__nodeRole = LIBRARY.createProperty(Types._Node, QVTschedulePackage.Literals.NODE__NODE_ROLE, Types._Role, 5 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Node__outgoingConnections = LIBRARY.createProperty(Types._Node, QVTschedulePackage.Literals.NODE__OUTGOING_CONNECTIONS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._NodeConnection), 6 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Node__outgoingEdges = LIBRARY.createProperty(Types._Node, QVTschedulePackage.Literals.NODE__OUTGOING_EDGES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Edge), 7 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Node__owningRegion = LIBRARY.createProperty(Types._Node, QVTschedulePackage.Literals.NODE__OWNING_REGION, Types._Region, 8 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Node__utility = LIBRARY.createProperty(Types._Node, QVTschedulePackage.Literals.NODE__UTILITY, Types._Utility, 9 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Node__BasicPartition__constantNodes = LIBRARY.createOppositeProperty(Types._Node, "BasicPartition", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._BasicPartition), 10 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_NODES);
		public static final @NonNull Property _Node__BasicPartition__constantSuccessFalseNodes = LIBRARY.createOppositeProperty(Types._Node, "BasicPartition", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._BasicPartition), 11 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_SUCCESS_FALSE_NODES);
		public static final @NonNull Property _Node__BasicPartition__constantSuccessTrueNodes = LIBRARY.createOppositeProperty(Types._Node, "BasicPartition", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._BasicPartition), 12 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_SUCCESS_TRUE_NODES);
		public static final @NonNull Property _Node__BasicPartition__headNodes = LIBRARY.createOppositeProperty(Types._Node, "BasicPartition", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._BasicPartition), 13 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.BASIC_PARTITION__HEAD_NODES);
		public static final @NonNull Property _Node__BasicPartition__loadedNodes = LIBRARY.createOppositeProperty(Types._Node, "BasicPartition", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._BasicPartition), 14 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.BASIC_PARTITION__LOADED_NODES);
		public static final @NonNull Property _Node__BasicPartition__predicatedNodes = LIBRARY.createOppositeProperty(Types._Node, "BasicPartition", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._BasicPartition), 15 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.BASIC_PARTITION__PREDICATED_NODES);
		public static final @NonNull Property _Node__BasicPartition__realizedNodes = LIBRARY.createOppositeProperty(Types._Node, "BasicPartition", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._BasicPartition), 16 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.BASIC_PARTITION__REALIZED_NODES);
		public static final @NonNull Property _Node__BasicPartition__speculatedNodes = LIBRARY.createOppositeProperty(Types._Node, "BasicPartition", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._BasicPartition), 17 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.BASIC_PARTITION__SPECULATED_NODES);
		public static final @NonNull Property _Node__BasicPartition__speculationNodes = LIBRARY.createOppositeProperty(Types._Node, "BasicPartition", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._BasicPartition), 18 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.BASIC_PARTITION__SPECULATION_NODES);
		public static final @NonNull Property _Node__MappingRegion__headNodes = LIBRARY.createOppositeProperty(Types._Node, "MappingRegion", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._MappingRegion), 19 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.MAPPING_REGION__HEAD_NODES);
		public static final @NonNull Property _Node__NodeConnection__mandatoryTargetNodes = LIBRARY.createOppositeProperty(Types._Node, "NodeConnection", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._NodeConnection), 20 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.NODE_CONNECTION__MANDATORY_TARGET_NODES);
		public static final @NonNull Property _Node__NodeConnection__passedTargetNodes = LIBRARY.createOppositeProperty(Types._Node, "NodeConnection", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._NodeConnection), 21 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.NODE_CONNECTION__PASSED_TARGET_NODES);
		public static final @NonNull Property _Node__NodeConnection__preferredTargetNodes = LIBRARY.createOppositeProperty(Types._Node, "NodeConnection", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._NodeConnection), 22 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.NODE_CONNECTION__PREFERRED_TARGET_NODES);
		public static final @NonNull Property _Node__OperationRegion__dependencyNodes = LIBRARY.createOppositeProperty(Types._Node, "OperationRegion", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._OperationRegion), 23 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.OPERATION_REGION__DEPENDENCY_NODES);
		public static final @NonNull Property _Node__OperationRegion__headNodes = LIBRARY.createOppositeProperty(Types._Node, "OperationRegion", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._OperationRegion), 24 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.OPERATION_REGION__HEAD_NODES);
		public static final @NonNull Property _Node__OperationRegion__resultNode = LIBRARY.createOppositeProperty(Types._Node, "OperationRegion", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._OperationRegion), 25 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.OPERATION_REGION__RESULT_NODE);

		public static final @NonNull Property _NodeConnection__classDatum = LIBRARY.createProperty(Types._NodeConnection, QVTschedulePackage.Literals.NODE_CONNECTION__CLASS_DATUM, Types._ClassDatum, 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _NodeConnection__mandatoryTargetNodes = LIBRARY.createProperty(Types._NodeConnection, QVTschedulePackage.Literals.NODE_CONNECTION__MANDATORY_TARGET_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Node), 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _NodeConnection__passedTargetNodes = LIBRARY.createProperty(Types._NodeConnection, QVTschedulePackage.Literals.NODE_CONNECTION__PASSED_TARGET_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Node), 2 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _NodeConnection__preferredTargetNodes = LIBRARY.createProperty(Types._NodeConnection, QVTschedulePackage.Literals.NODE_CONNECTION__PREFERRED_TARGET_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._Node), 3 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _NodeConnection__Node__incomingConnection = LIBRARY.createOppositeProperty(Types._NodeConnection, "Node", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._Node), 4 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.NODE__INCOMING_CONNECTION);
		public static final @NonNull Property _NodeConnection__Node__outgoingConnections = LIBRARY.createOppositeProperty(Types._NodeConnection, "Node", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._Node), 5 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.NODE__OUTGOING_CONNECTIONS);
		public static final @NonNull Property _NodeConnection__Partition__intermediateConnections = LIBRARY.createOppositeProperty(Types._NodeConnection, "Partition", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._Partition), 6 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.PARTITION__INTERMEDIATE_CONNECTIONS);
		public static final @NonNull Property _NodeConnection__Partition__rootConnections = LIBRARY.createOppositeProperty(Types._NodeConnection, "Partition", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._Partition), 7 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.PARTITION__ROOT_CONNECTIONS);

		public static final @NonNull Property _NumericLiteralNode__numericValue = LIBRARY.createProperty(Types._NumericLiteralNode, QVTschedulePackage.Literals.NUMERIC_LITERAL_NODE__NUMERIC_VALUE, Types._Number, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _OperationCallNode__referredOperation = LIBRARY.createProperty(Types._OperationCallNode, QVTschedulePackage.Literals.OPERATION_CALL_NODE__REFERRED_OPERATION, PivotTables.Types._Operation, 0 | IsResolveProxies | IsTransient);

		public static final @NonNull Property _OperationParameterEdge__parameterIndex = LIBRARY.createProperty(Types._OperationParameterEdge, QVTschedulePackage.Literals.OPERATION_PARAMETER_EDGE__PARAMETER_INDEX, OCLstdlibTables.Types._Integer, 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _OperationParameterEdge__referredParameter = LIBRARY.createProperty(Types._OperationParameterEdge, QVTschedulePackage.Literals.OPERATION_PARAMETER_EDGE__REFERRED_PARAMETER, PivotTables.Types._Parameter, 1 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _OperationRegion__dependencyNodes = LIBRARY.createProperty(Types._OperationRegion, QVTschedulePackage.Literals.OPERATION_REGION__DEPENDENCY_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Node), 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _OperationRegion__headNodes = LIBRARY.createProperty(Types._OperationRegion, QVTschedulePackage.Literals.OPERATION_REGION__HEAD_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Node), 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _OperationRegion__owningScheduleModel = LIBRARY.createProperty(Types._OperationRegion, QVTschedulePackage.Literals.OPERATION_REGION__OWNING_SCHEDULE_MODEL, Types._ScheduleModel, 2 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _OperationRegion__referredOperation = LIBRARY.createProperty(Types._OperationRegion, QVTschedulePackage.Literals.OPERATION_REGION__REFERRED_OPERATION, PivotTables.Types._Operation, 3 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _OperationRegion__resultNode = LIBRARY.createProperty(Types._OperationRegion, QVTschedulePackage.Literals.OPERATION_REGION__RESULT_NODE, Types._Node, 4 | IsResolveProxies);

		public static final @NonNull Property _OperationSelfEdge__referredType = LIBRARY.createProperty(Types._OperationSelfEdge, QVTschedulePackage.Literals.OPERATION_SELF_EDGE__REFERRED_TYPE, PivotTables.Types._Type, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _Partition__intermediateConnections = LIBRARY.createProperty(Types._Partition, QVTschedulePackage.Literals.PARTITION__INTERMEDIATE_CONNECTIONS, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._NodeConnection), 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Partition__passes = LIBRARY.createProperty(Types._Partition, QVTschedulePackage.Literals.PARTITION__PASSES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, OCLstdlibTables.Types._Integer), 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Partition__rootConnections = LIBRARY.createProperty(Types._Partition, QVTschedulePackage.Literals.PARTITION__ROOT_CONNECTIONS, MODEL.getCollectionType(OCLstdlibTables.Types._Set, Types._NodeConnection), 2 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Partition__Connection__commonPartition = LIBRARY.createOppositeProperty(Types._Partition, "Connection", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._Connection), 3 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.CONNECTION__COMMON_PARTITION);
		public static final @NonNull Property _Partition__Connection__intermediatePartitions = LIBRARY.createOppositeProperty(Types._Partition, "Connection", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._Connection), 4 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.CONNECTION__INTERMEDIATE_PARTITIONS);

		public static final @NonNull Property _PredicateEdge__partial = LIBRARY.createProperty(Types._PredicateEdge, QVTschedulePackage.Literals.PREDICATE_EDGE__PARTIAL, OCLstdlibTables.Types._Boolean, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _PropertyDatum__key = LIBRARY.createProperty(Types._PropertyDatum, QVTschedulePackage.Literals.PROPERTY_DATUM__KEY, OCLstdlibTables.Types._Boolean, 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _PropertyDatum__opposite = LIBRARY.createProperty(Types._PropertyDatum, QVTschedulePackage.Literals.PROPERTY_DATUM__OPPOSITE, Types._PropertyDatum, 1 | IsResolveProxies);
		public static final @NonNull Property _PropertyDatum__owningClassDatum = LIBRARY.createProperty(Types._PropertyDatum, QVTschedulePackage.Literals.PROPERTY_DATUM__OWNING_CLASS_DATUM, Types._ClassDatum, 2 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _PropertyDatum__referredProperty = LIBRARY.createProperty(Types._PropertyDatum, QVTschedulePackage.Literals.PROPERTY_DATUM__REFERRED_PROPERTY, PivotTables.Types._Property, 3 | IsResolveProxies | IsTransient);
		public static final @NonNull Property _PropertyDatum__superPropertyDatums = LIBRARY.createProperty(Types._PropertyDatum, QVTschedulePackage.Literals.PROPERTY_DATUM__SUPER_PROPERTY_DATUMS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._PropertyDatum), 4 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _PropertyDatum__targetClassDatum = LIBRARY.createProperty(Types._PropertyDatum, QVTschedulePackage.Literals.PROPERTY_DATUM__TARGET_CLASS_DATUM, Types._ClassDatum, 5 | IsResolveProxies);
		public static final @NonNull Property _PropertyDatum__KeyPartEdge__referredPart = LIBRARY.createOppositeProperty(Types._PropertyDatum, "KeyPartEdge", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._KeyPartEdge), 6 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.KEY_PART_EDGE__REFERRED_PART);
		public static final @NonNull Property _PropertyDatum__PropertyDatum__opposite = LIBRARY.createOppositeProperty(Types._PropertyDatum, "PropertyDatum", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._PropertyDatum), 7 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.PROPERTY_DATUM__OPPOSITE);
		public static final @NonNull Property _PropertyDatum__PropertyDatum__superPropertyDatums = LIBRARY.createOppositeProperty(Types._PropertyDatum, "PropertyDatum", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._PropertyDatum), 8 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.PROPERTY_DATUM__SUPER_PROPERTY_DATUMS);

		public static final @NonNull Property _RecursionEdge__primary = LIBRARY.createProperty(Types._RecursionEdge, QVTschedulePackage.Literals.RECURSION_EDGE__PRIMARY, OCLstdlibTables.Types._Boolean, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _Region__ownedClusters = LIBRARY.createProperty(Types._Region, QVTschedulePackage.Literals.REGION__OWNED_CLUSTERS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Cluster), 0 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Region__ownedEdges = LIBRARY.createProperty(Types._Region, QVTschedulePackage.Literals.REGION__OWNED_EDGES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Edge), 1 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Region__ownedNodes = LIBRARY.createProperty(Types._Region, QVTschedulePackage.Literals.REGION__OWNED_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Node), 2 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Region__rootRegion = LIBRARY.createProperty(Types._Region, QVTschedulePackage.Literals.REGION__ROOT_REGION, Types._RootRegion, 3 | IsResolveProxies);
		public static final @NonNull Property _Region__MappingPartition__region = LIBRARY.createOppositeProperty(Types._Region, "MappingPartition", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._MappingPartition), 4 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.MAPPING_PARTITION__REGION);

		public static final @NonNull Property _RootPartition__loadingPartition = LIBRARY.createProperty(Types._RootPartition, QVTschedulePackage.Literals.ROOT_PARTITION__LOADING_PARTITION, Types._LoadingPartition, 0 | IsResolveProxies);
		public static final @NonNull Property _RootPartition__owningRootRegion = LIBRARY.createProperty(Types._RootPartition, QVTschedulePackage.Literals.ROOT_PARTITION__OWNING_ROOT_REGION, Types._RootRegion, 1 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _RootRegion__activeRegions = LIBRARY.createProperty(Types._RootRegion, QVTschedulePackage.Literals.ROOT_REGION__ACTIVE_REGIONS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Region), 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RootRegion__ownedConnections = LIBRARY.createProperty(Types._RootRegion, QVTschedulePackage.Literals.ROOT_REGION__OWNED_CONNECTIONS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Connection), 1 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RootRegion__ownedLoadingRegion = LIBRARY.createProperty(Types._RootRegion, QVTschedulePackage.Literals.ROOT_REGION__OWNED_LOADING_REGION, Types._LoadingRegion, 2 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RootRegion__ownedRootPartition = LIBRARY.createProperty(Types._RootRegion, QVTschedulePackage.Literals.ROOT_REGION__OWNED_ROOT_PARTITION, Types._RootPartition, 3 | IsComposite | IsResolveProxies);
		public static final @NonNull Property _RootRegion__owningScheduleModel = LIBRARY.createProperty(Types._RootRegion, QVTschedulePackage.Literals.ROOT_REGION__OWNING_SCHEDULE_MODEL, Types._ScheduleModel, 4 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RootRegion__referredTransformation = LIBRARY.createProperty(Types._RootRegion, QVTschedulePackage.Literals.ROOT_REGION__REFERRED_TRANSFORMATION, QVTbaseTables.Types._Transformation, 5 | IsResolveProxies);

		public static final @NonNull Property _RuleRegion__referredRule = LIBRARY.createProperty(Types._RuleRegion, QVTschedulePackage.Literals.RULE_REGION__REFERRED_RULE, QVTbaseTables.Types._Rule, 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RuleRegion__DispatchRegion__referredRuleRegion = LIBRARY.createOppositeProperty(Types._RuleRegion, "DispatchRegion", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._DispatchRegion), 1 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.DISPATCH_REGION__REFERRED_RULE_REGION);
		public static final @NonNull Property _RuleRegion__VerdictRegion__referredRuleRegion = LIBRARY.createOppositeProperty(Types._RuleRegion, "VerdictRegion", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._VerdictRegion), 2 | IsImplicit | IsRequired | IsResolveProxies, QVTschedulePackage.Literals.VERDICT_REGION__REFERRED_RULE_REGION);

		public static final @NonNull Property _ScheduleModel__ownedClassDatums = LIBRARY.createProperty(Types._ScheduleModel, QVTschedulePackage.Literals.SCHEDULE_MODEL__OWNED_CLASS_DATUMS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._ClassDatum), 0 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _ScheduleModel__ownedMappingRegions = LIBRARY.createProperty(Types._ScheduleModel, QVTschedulePackage.Literals.SCHEDULE_MODEL__OWNED_MAPPING_REGIONS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._MappingRegion), 1 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _ScheduleModel__ownedOperationRegions = LIBRARY.createProperty(Types._ScheduleModel, QVTschedulePackage.Literals.SCHEDULE_MODEL__OWNED_OPERATION_REGIONS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._OperationRegion), 2 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _ScheduleModel__ownedRootRegions = LIBRARY.createProperty(Types._ScheduleModel, QVTschedulePackage.Literals.SCHEDULE_MODEL__OWNED_ROOT_REGIONS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._RootRegion), 3 | IsComposite | IsRequired | IsResolveProxies);

		public static final @NonNull Property _ShadowPartEdge__referredPart = LIBRARY.createProperty(Types._ShadowPartEdge, QVTschedulePackage.Literals.SHADOW_PART_EDGE__REFERRED_PART, PivotTables.Types._ShadowPart, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _StringLiteralNode__stringValue = LIBRARY.createProperty(Types._StringLiteralNode, QVTschedulePackage.Literals.STRING_LITERAL_NODE__STRING_VALUE, OCLstdlibTables.Types._String, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _Symbolable__symbolName = LIBRARY.createProperty(Types._Symbolable, QVTschedulePackage.Literals.SYMBOLABLE__SYMBOL_NAME, OCLstdlibTables.Types._String, 0 | IsResolveProxies | IsTransient);

		public static final @NonNull Property _TuplePartEdge__referredPart = LIBRARY.createProperty(Types._TuplePartEdge, QVTschedulePackage.Literals.TUPLE_PART_EDGE__REFERRED_PART, PivotTables.Types._TupleLiteralPart, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _TypeLiteralNode__typeValue = LIBRARY.createProperty(Types._TypeLiteralNode, QVTschedulePackage.Literals.TYPE_LITERAL_NODE__TYPE_VALUE, PivotTables.Types._Type, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _VariableNode__referredVariable = LIBRARY.createProperty(Types._VariableNode, QVTschedulePackage.Literals.VARIABLE_NODE__REFERRED_VARIABLE, PivotTables.Types._VariableDeclaration, 0 | IsResolveProxies | IsTransient);

		public static final @NonNull Property _VerdictRegion__referredRuleRegion = LIBRARY.createProperty(Types._VerdictRegion, QVTschedulePackage.Literals.VERDICT_REGION__REFERRED_RULE_REGION, Types._RuleRegion, 0 | IsRequired | IsResolveProxies);

		static {
			_BasicPartition__constantEdges.setOpposite(_Edge__BasicPartition__constantEdges);
			_BasicPartition__constantNodes.setOpposite(_Node__BasicPartition__constantNodes);
			_BasicPartition__constantSuccessFalseNodes.setOpposite(_Node__BasicPartition__constantSuccessFalseNodes);
			_BasicPartition__constantSuccessTrueNodes.setOpposite(_Node__BasicPartition__constantSuccessTrueNodes);
			_BasicPartition__explicitPredecessors.setOpposite(_MappingPartition__explicitSuccessors);
			_BasicPartition__headNodes.setOpposite(_Node__BasicPartition__headNodes);
			_BasicPartition__loadedEdges.setOpposite(_Edge__BasicPartition__loadedEdges);
			_BasicPartition__loadedNodes.setOpposite(_Node__BasicPartition__loadedNodes);
			_BasicPartition__owningMergedPartition.setOpposite(_MergedPartition__ownedMergedPartitions);
			_BasicPartition__predicatedEdges.setOpposite(_Edge__BasicPartition__predicatedEdges);
			_BasicPartition__predicatedNodes.setOpposite(_Node__BasicPartition__predicatedNodes);
			_BasicPartition__realizedEdges.setOpposite(_Edge__BasicPartition__realizedEdges);
			_BasicPartition__realizedNodes.setOpposite(_Node__BasicPartition__realizedNodes);
			_BasicPartition__speculatedEdges.setOpposite(_Edge__BasicPartition__speculatedEdges);
			_BasicPartition__speculatedNodes.setOpposite(_Node__BasicPartition__speculatedNodes);
			_BasicPartition__speculationNodes.setOpposite(_Node__BasicPartition__speculationNodes);


			_CastEdge__referredClassDatum.setOpposite(_ClassDatum__CastEdge__referredClassDatum);

			LIBRARY.createOpposite("ClassDatum", _ClassDatum__completeClasses);
			_ClassDatum__ownedPropertyDatums.setOpposite(_PropertyDatum__owningClassDatum);
			_ClassDatum__owningScheduleModel.setOpposite(_ScheduleModel__ownedClassDatums);
			LIBRARY.createOpposite("ClassDatum", _ClassDatum__referredClass);
			LIBRARY.createOpposite("ClassDatum", _ClassDatum__referredTypedModel);
			_ClassDatum__superClassDatums.setOpposite(_ClassDatum__ClassDatum__superClassDatums);
			_ClassDatum__CastEdge__referredClassDatum.setOpposite(_CastEdge__referredClassDatum);
			_ClassDatum__ClassDatum__superClassDatums.setOpposite(_ClassDatum__superClassDatums);
			_ClassDatum__CollectionClassDatum__elementalClassDatum.setOpposite(_CollectionClassDatum__elementalClassDatum);
			_ClassDatum__KeyedValueNode__classDatumValue.setOpposite(_KeyedValueNode__classDatumValue);
			_ClassDatum__Node__classDatum.setOpposite(_Node__classDatum);
			_ClassDatum__NodeConnection__classDatum.setOpposite(_NodeConnection__classDatum);
			_ClassDatum__PropertyDatum__targetClassDatum.setOpposite(_PropertyDatum__targetClassDatum);

			_Cluster__memberEdges.setOpposite(_Edge__cluster);
			_Cluster__memberNodes.setOpposite(_Node__cluster);
			_Cluster__owningRegion.setOpposite(_Region__ownedClusters);
			_Cluster__precedingClusters.setOpposite(_Cluster__succeedingClusters);
			_Cluster__succeedingClusters.setOpposite(_Cluster__precedingClusters);

			_CollectionClassDatum__elementalClassDatum.setOpposite(_ClassDatum__CollectionClassDatum__elementalClassDatum);

			LIBRARY.createOpposite("CollectionPartEdge", _CollectionPartEdge__referredPart);

			_CompositePartition__ownedMappingPartitions.setOpposite(_MappingPartition__owningCompositePartition);

			_Connection__commonPartition.setOpposite(_Partition__Connection__commonPartition);
			_Connection__connectionRole.setDefaultValueString("UNDEFINED");
			_Connection__intermediatePartitions.setOpposite(_Partition__Connection__intermediatePartitions);
			_Connection__owningRootRegion.setOpposite(_RootRegion__ownedConnections);
			_Connection__sourceEnds.setOpposite(_ConnectionEnd__Connection__sourceEnds);

			_ConnectionEnd__Connection__sourceEnds.setOpposite(_Connection__sourceEnds);

			_CyclicMappingRegion__elementRegions.setOpposite(_MappingRegion__CyclicMappingRegion__elementRegions);

			_DispatchRegion__referredRuleRegion.setOpposite(_RuleRegion__DispatchRegion__referredRuleRegion);

			_Edge__cluster.setOpposite(_Cluster__memberEdges);
			_Edge__owningRegion.setOpposite(_Region__ownedEdges);
			_Edge__sourceNode.setOpposite(_Node__outgoingEdges);
			_Edge__targetNode.setOpposite(_Node__incomingEdges);
			_Edge__utility.setDefaultValueString("NOT_KNOWN");
			_Edge__BasicPartition__constantEdges.setOpposite(_BasicPartition__constantEdges);
			_Edge__BasicPartition__loadedEdges.setOpposite(_BasicPartition__loadedEdges);
			_Edge__BasicPartition__predicatedEdges.setOpposite(_BasicPartition__predicatedEdges);
			_Edge__BasicPartition__realizedEdges.setOpposite(_BasicPartition__realizedEdges);
			_Edge__BasicPartition__speculatedEdges.setOpposite(_BasicPartition__speculatedEdges);

			_EdgeConnection__mandatoryTargetEdges.setOpposite(_NavigableEdge__EdgeConnection__mandatoryTargetEdges);
			_EdgeConnection__preferredTargetEdges.setOpposite(_NavigableEdge__EdgeConnection__preferredTargetEdges);
			LIBRARY.createOpposite("EdgeConnection", _EdgeConnection__referredProperty);
			_EdgeConnection__NavigableEdge__incomingConnection.setOpposite(_NavigableEdge__incomingConnection);
			_EdgeConnection__NavigableEdge__outgoingConnections.setOpposite(_NavigableEdge__outgoingConnections);

			LIBRARY.createOpposite("EnumLiteralNode", _EnumLiteralNode__enumValue);

			_KeyPartEdge__referredPart.setOpposite(_PropertyDatum__KeyPartEdge__referredPart);

			_KeyedValueNode__classDatumValue.setOpposite(_ClassDatum__KeyedValueNode__classDatumValue);

			_LoadingPartition__referredLoadingRegion.setOpposite(_LoadingRegion__loadingPartition);
			_LoadingPartition__RootPartition__loadingPartition.setOpposite(_RootPartition__loadingPartition);

			_LoadingRegion__loadingPartition.setOpposite(_LoadingPartition__referredLoadingRegion);
			_LoadingRegion__owningRootRegion.setOpposite(_RootRegion__ownedLoadingRegion);

			LIBRARY.createOpposite("MapPartEdge", _MapPartEdge__referredPart);

			_MappingPartition__explicitSuccessors.setOpposite(_BasicPartition__explicitPredecessors);
			_MappingPartition__owningCompositePartition.setOpposite(_CompositePartition__ownedMappingPartitions);
			_MappingPartition__referedMappingRegion.setOpposite(_MappingRegion__mappingPartitions);
			_MappingPartition__region.setOpposite(_Region__MappingPartition__region);

			_MappingRegion__headNodes.setOpposite(_Node__MappingRegion__headNodes);
			_MappingRegion__mappingPartitions.setOpposite(_MappingPartition__referedMappingRegion);
			_MappingRegion__owningScheduleModel.setOpposite(_ScheduleModel__ownedMappingRegions);
			_MappingRegion__CyclicMappingRegion__elementRegions.setOpposite(_CyclicMappingRegion__elementRegions);

			_MergedPartition__ownedMergedPartitions.setOpposite(_BasicPartition__owningMergedPartition);

			_NavigableEdge__incomingConnection.setOpposite(_EdgeConnection__NavigableEdge__incomingConnection);
			_NavigableEdge__outgoingConnections.setOpposite(_EdgeConnection__NavigableEdge__outgoingConnections);
			_NavigableEdge__EdgeConnection__mandatoryTargetEdges.setOpposite(_EdgeConnection__mandatoryTargetEdges);
			_NavigableEdge__EdgeConnection__preferredTargetEdges.setOpposite(_EdgeConnection__preferredTargetEdges);

			_NavigationEdge__oppositeEdge.setOpposite(_NavigationEdge__NavigationEdge__oppositeEdge);
			_NavigationEdge__partial.setDefaultValueString("false");
			LIBRARY.createOpposite("NavigationEdge", _NavigationEdge__referredProperty);
			_NavigationEdge__secondary.setDefaultValueString("false");
			_NavigationEdge__NavigationEdge__oppositeEdge.setOpposite(_NavigationEdge__oppositeEdge);

			_Node__classDatum.setOpposite(_ClassDatum__Node__classDatum);
			_Node__cluster.setOpposite(_Cluster__memberNodes);
			_Node__incomingConnection.setOpposite(_NodeConnection__Node__incomingConnection);
			_Node__incomingEdges.setOpposite(_Edge__targetNode);
			_Node__outgoingConnections.setOpposite(_NodeConnection__Node__outgoingConnections);
			_Node__outgoingEdges.setOpposite(_Edge__sourceNode);
			_Node__owningRegion.setOpposite(_Region__ownedNodes);
			_Node__utility.setDefaultValueString("NOT_KNOWN");
			_Node__BasicPartition__constantNodes.setOpposite(_BasicPartition__constantNodes);
			_Node__BasicPartition__constantSuccessFalseNodes.setOpposite(_BasicPartition__constantSuccessFalseNodes);
			_Node__BasicPartition__constantSuccessTrueNodes.setOpposite(_BasicPartition__constantSuccessTrueNodes);
			_Node__BasicPartition__headNodes.setOpposite(_BasicPartition__headNodes);
			_Node__BasicPartition__loadedNodes.setOpposite(_BasicPartition__loadedNodes);
			_Node__BasicPartition__predicatedNodes.setOpposite(_BasicPartition__predicatedNodes);
			_Node__BasicPartition__realizedNodes.setOpposite(_BasicPartition__realizedNodes);
			_Node__BasicPartition__speculatedNodes.setOpposite(_BasicPartition__speculatedNodes);
			_Node__BasicPartition__speculationNodes.setOpposite(_BasicPartition__speculationNodes);
			_Node__MappingRegion__headNodes.setOpposite(_MappingRegion__headNodes);
			_Node__NodeConnection__mandatoryTargetNodes.setOpposite(_NodeConnection__mandatoryTargetNodes);
			_Node__NodeConnection__passedTargetNodes.setOpposite(_NodeConnection__passedTargetNodes);
			_Node__NodeConnection__preferredTargetNodes.setOpposite(_NodeConnection__preferredTargetNodes);
			_Node__OperationRegion__dependencyNodes.setOpposite(_OperationRegion__dependencyNodes);
			_Node__OperationRegion__headNodes.setOpposite(_OperationRegion__headNodes);
			_Node__OperationRegion__resultNode.setOpposite(_OperationRegion__resultNode);

			_NodeConnection__classDatum.setOpposite(_ClassDatum__NodeConnection__classDatum);
			_NodeConnection__mandatoryTargetNodes.setOpposite(_Node__NodeConnection__mandatoryTargetNodes);
			_NodeConnection__passedTargetNodes.setOpposite(_Node__NodeConnection__passedTargetNodes);
			_NodeConnection__preferredTargetNodes.setOpposite(_Node__NodeConnection__preferredTargetNodes);
			_NodeConnection__Node__incomingConnection.setOpposite(_Node__incomingConnection);
			_NodeConnection__Node__outgoingConnections.setOpposite(_Node__outgoingConnections);
			_NodeConnection__Partition__intermediateConnections.setOpposite(_Partition__intermediateConnections);
			_NodeConnection__Partition__rootConnections.setOpposite(_Partition__rootConnections);


			LIBRARY.createOpposite("OperationCallNode", _OperationCallNode__referredOperation);

			_OperationParameterEdge__parameterIndex.setDefaultValueString("-1");
			LIBRARY.createOpposite("OperationParameterEdge", _OperationParameterEdge__referredParameter);

			_OperationRegion__dependencyNodes.setOpposite(_Node__OperationRegion__dependencyNodes);
			_OperationRegion__headNodes.setOpposite(_Node__OperationRegion__headNodes);
			_OperationRegion__owningScheduleModel.setOpposite(_ScheduleModel__ownedOperationRegions);
			LIBRARY.createOpposite("OperationRegion", _OperationRegion__referredOperation);
			_OperationRegion__resultNode.setOpposite(_Node__OperationRegion__resultNode);

			LIBRARY.createOpposite("OperationSelfEdge", _OperationSelfEdge__referredType);

			_Partition__intermediateConnections.setOpposite(_NodeConnection__Partition__intermediateConnections);
			_Partition__rootConnections.setOpposite(_NodeConnection__Partition__rootConnections);
			_Partition__Connection__commonPartition.setOpposite(_Connection__commonPartition);
			_Partition__Connection__intermediatePartitions.setOpposite(_Connection__intermediatePartitions);

			_PredicateEdge__partial.setDefaultValueString("false");

			_PropertyDatum__opposite.setOpposite(_PropertyDatum__PropertyDatum__opposite);
			_PropertyDatum__owningClassDatum.setOpposite(_ClassDatum__ownedPropertyDatums);
			LIBRARY.createOpposite("PropertyDatum", _PropertyDatum__referredProperty);
			_PropertyDatum__superPropertyDatums.setOpposite(_PropertyDatum__PropertyDatum__superPropertyDatums);
			_PropertyDatum__targetClassDatum.setOpposite(_ClassDatum__PropertyDatum__targetClassDatum);
			_PropertyDatum__KeyPartEdge__referredPart.setOpposite(_KeyPartEdge__referredPart);
			_PropertyDatum__PropertyDatum__opposite.setOpposite(_PropertyDatum__opposite);
			_PropertyDatum__PropertyDatum__superPropertyDatums.setOpposite(_PropertyDatum__superPropertyDatums);

			_RecursionEdge__primary.setDefaultValueString("false");

			_Region__ownedClusters.setOpposite(_Cluster__owningRegion);
			_Region__ownedEdges.setOpposite(_Edge__owningRegion);
			_Region__ownedNodes.setOpposite(_Node__owningRegion);
			_Region__rootRegion.setOpposite(_RootRegion__activeRegions);
			_Region__MappingPartition__region.setOpposite(_MappingPartition__region);

			_RootPartition__loadingPartition.setOpposite(_LoadingPartition__RootPartition__loadingPartition);
			_RootPartition__owningRootRegion.setOpposite(_RootRegion__ownedRootPartition);

			_RootRegion__activeRegions.setOpposite(_Region__rootRegion);
			_RootRegion__ownedConnections.setOpposite(_Connection__owningRootRegion);
			_RootRegion__ownedLoadingRegion.setOpposite(_LoadingRegion__owningRootRegion);
			_RootRegion__ownedRootPartition.setOpposite(_RootPartition__owningRootRegion);
			_RootRegion__owningScheduleModel.setOpposite(_ScheduleModel__ownedRootRegions);
			LIBRARY.createOpposite("RootRegion", _RootRegion__referredTransformation);

			LIBRARY.createOpposite("RuleRegion", _RuleRegion__referredRule);
			_RuleRegion__DispatchRegion__referredRuleRegion.setOpposite(_DispatchRegion__referredRuleRegion);
			_RuleRegion__VerdictRegion__referredRuleRegion.setOpposite(_VerdictRegion__referredRuleRegion);

			_ScheduleModel__ownedClassDatums.setOpposite(_ClassDatum__owningScheduleModel);
			_ScheduleModel__ownedMappingRegions.setOpposite(_MappingRegion__owningScheduleModel);
			_ScheduleModel__ownedOperationRegions.setOpposite(_OperationRegion__owningScheduleModel);
			_ScheduleModel__ownedRootRegions.setOpposite(_RootRegion__owningScheduleModel);

			LIBRARY.createOpposite("ShadowPartEdge", _ShadowPartEdge__referredPart);



			LIBRARY.createOpposite("TuplePartEdge", _TuplePartEdge__referredPart);

			LIBRARY.createOpposite("TypeLiteralNode", _TypeLiteralNode__typeValue);

			LIBRARY.createOpposite("VariableNode", _VariableNode__referredVariable);

			_VerdictRegion__referredRuleRegion.setOpposite(_RuleRegion__VerdictRegion__referredRuleRegion);

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

		private static final @NonNull FlatFragment @NonNull [] _AbstractDatum =
			{
				Fragments._AbstractDatum__OclAny /* 0 */,
				Fragments._AbstractDatum__OclElement /* 1 */,
				Fragments._AbstractDatum__Element /* 2 */,
				Fragments._AbstractDatum__NamedElement /* 3 */,
				Fragments._AbstractDatum__AbstractDatum /* 4 */
			};
		private static final int @NonNull [] __AbstractDatum = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _ArgumentEdge =
			{
				Fragments._ArgumentEdge__OclAny /* 0 */,
				Fragments._ArgumentEdge__OclElement /* 1 */,
				Fragments._ArgumentEdge__Element /* 2 */,
				Fragments._ArgumentEdge__Edge /* 3 */,
				Fragments._ArgumentEdge__ExpressionEdge /* 4 */,
				Fragments._ArgumentEdge__ArgumentEdge /* 5 */
			};
		private static final int @NonNull [] __ArgumentEdge = { 1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _BasicPartition =
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

		private static final @NonNull FlatFragment @NonNull [] _BooleanLiteralNode =
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

		private static final @NonNull FlatFragment @NonNull [] _CastEdge =
			{
				Fragments._CastEdge__OclAny /* 0 */,
				Fragments._CastEdge__OclElement /* 1 */,
				Fragments._CastEdge__Element /* 2 */,
				Fragments._CastEdge__Edge /* 3 */,
				Fragments._CastEdge__CastEdge /* 4 */
			};
		private static final int @NonNull [] __CastEdge = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _ClassDatum =
			{
				Fragments._ClassDatum__OclAny /* 0 */,
				Fragments._ClassDatum__OclElement /* 1 */,
				Fragments._ClassDatum__Element /* 2 */,
				Fragments._ClassDatum__NamedElement /* 3 */,
				Fragments._ClassDatum__AbstractDatum /* 4 */,
				Fragments._ClassDatum__ClassDatum /* 5 */
			};
		private static final int @NonNull [] __ClassDatum = { 1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Cluster =
			{
				Fragments._Cluster__OclAny /* 0 */,
				Fragments._Cluster__OclElement /* 1 */,
				Fragments._Cluster__Element /* 2 */,
				Fragments._Cluster__Symbolable /* 2 */,
				Fragments._Cluster__NamedElement /* 3 */,
				Fragments._Cluster__Cluster /* 4 */
			};
		private static final int @NonNull [] __Cluster = { 1,1,2,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _CollectionClassDatum =
			{
				Fragments._CollectionClassDatum__OclAny /* 0 */,
				Fragments._CollectionClassDatum__OclElement /* 1 */,
				Fragments._CollectionClassDatum__Element /* 2 */,
				Fragments._CollectionClassDatum__NamedElement /* 3 */,
				Fragments._CollectionClassDatum__AbstractDatum /* 4 */,
				Fragments._CollectionClassDatum__ClassDatum /* 5 */,
				Fragments._CollectionClassDatum__CollectionClassDatum /* 6 */
			};
		private static final int @NonNull [] __CollectionClassDatum = { 1,1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _CollectionLiteralNode =
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

		private static final @NonNull FlatFragment @NonNull [] _CollectionPartEdge =
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

		private static final @NonNull FlatFragment @NonNull [] _CollectionRangeNode =
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

		private static final @NonNull FlatFragment @NonNull [] _ComposedNode =
			{
				Fragments._ComposedNode__OclAny /* 0 */,
				Fragments._ComposedNode__OclElement /* 1 */,
				Fragments._ComposedNode__ConnectionEnd /* 2 */,
				Fragments._ComposedNode__Element /* 2 */,
				Fragments._ComposedNode__Node /* 3 */,
				Fragments._ComposedNode__ComposedNode /* 4 */
			};
		private static final int @NonNull [] __ComposedNode = { 1,1,2,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _CompositePartition =
			{
				Fragments._CompositePartition__OclAny /* 0 */,
				Fragments._CompositePartition__OclElement /* 1 */,
				Fragments._CompositePartition__Element /* 2 */,
				Fragments._CompositePartition__NamedElement /* 3 */,
				Fragments._CompositePartition__Partition /* 4 */,
				Fragments._CompositePartition__CompositePartition /* 5 */
			};
		private static final int @NonNull [] __CompositePartition = { 1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Connection =
			{
				Fragments._Connection__OclAny /* 0 */,
				Fragments._Connection__OclElement /* 1 */,
				Fragments._Connection__Element /* 2 */,
				Fragments._Connection__Symbolable /* 2 */,
				Fragments._Connection__Connection /* 3 */
			};
		private static final int @NonNull [] __Connection = { 1,1,2,1 };

		private static final @NonNull FlatFragment @NonNull [] _ConnectionEnd =
			{
				Fragments._ConnectionEnd__OclAny /* 0 */,
				Fragments._ConnectionEnd__OclElement /* 1 */,
				Fragments._ConnectionEnd__ConnectionEnd /* 2 */
			};
		private static final int @NonNull [] __ConnectionEnd = { 1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _ConnectionRole =
			{
				Fragments._ConnectionRole__OclAny /* 0 */,
				Fragments._ConnectionRole__OclElement /* 1 */,
				Fragments._ConnectionRole__OclType /* 2 */,
				Fragments._ConnectionRole__OclEnumeration /* 3 */,
				Fragments._ConnectionRole__ConnectionRole /* 4 */
			};
		private static final int @NonNull [] __ConnectionRole = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _CyclicMappingRegion =
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

		private static final @NonNull FlatFragment @NonNull [] _CyclicPartition =
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

		private static final @NonNull FlatFragment @NonNull [] _DependencyEdge =
			{
				Fragments._DependencyEdge__OclAny /* 0 */,
				Fragments._DependencyEdge__OclElement /* 1 */,
				Fragments._DependencyEdge__Element /* 2 */,
				Fragments._DependencyEdge__Edge /* 3 */,
				Fragments._DependencyEdge__DependencyEdge /* 4 */
			};
		private static final int @NonNull [] __DependencyEdge = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _DependencyNode =
			{
				Fragments._DependencyNode__OclAny /* 0 */,
				Fragments._DependencyNode__OclElement /* 1 */,
				Fragments._DependencyNode__ConnectionEnd /* 2 */,
				Fragments._DependencyNode__Element /* 2 */,
				Fragments._DependencyNode__Node /* 3 */,
				Fragments._DependencyNode__DependencyNode /* 4 */
			};
		private static final int @NonNull [] __DependencyNode = { 1,1,2,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _DispatchRegion =
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

		private static final @NonNull FlatFragment @NonNull [] _Edge =
			{
				Fragments._Edge__OclAny /* 0 */,
				Fragments._Edge__OclElement /* 1 */,
				Fragments._Edge__Element /* 2 */,
				Fragments._Edge__Edge /* 3 */
			};
		private static final int @NonNull [] __Edge = { 1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _EdgeConnection =
			{
				Fragments._EdgeConnection__OclAny /* 0 */,
				Fragments._EdgeConnection__OclElement /* 1 */,
				Fragments._EdgeConnection__Element /* 2 */,
				Fragments._EdgeConnection__Symbolable /* 2 */,
				Fragments._EdgeConnection__Connection /* 3 */,
				Fragments._EdgeConnection__EdgeConnection /* 4 */
			};
		private static final int @NonNull [] __EdgeConnection = { 1,1,2,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _EnumLiteralNode =
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

		private static final @NonNull FlatFragment @NonNull [] _ErrorNode =
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

		private static final @NonNull FlatFragment @NonNull [] _ExpressionEdge =
			{
				Fragments._ExpressionEdge__OclAny /* 0 */,
				Fragments._ExpressionEdge__OclElement /* 1 */,
				Fragments._ExpressionEdge__Element /* 2 */,
				Fragments._ExpressionEdge__Edge /* 3 */,
				Fragments._ExpressionEdge__ExpressionEdge /* 4 */
			};
		private static final int @NonNull [] __ExpressionEdge = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _IfNode =
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

		private static final @NonNull FlatFragment @NonNull [] _IncludesEdge =
			{
				Fragments._IncludesEdge__OclAny /* 0 */,
				Fragments._IncludesEdge__OclElement /* 1 */,
				Fragments._IncludesEdge__Element /* 2 */,
				Fragments._IncludesEdge__Edge /* 3 */,
				Fragments._IncludesEdge__ExpressionEdge /* 4 */,
				Fragments._IncludesEdge__IncludesEdge /* 5 */
			};
		private static final int @NonNull [] __IncludesEdge = { 1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _InputNode =
			{
				Fragments._InputNode__OclAny /* 0 */,
				Fragments._InputNode__OclElement /* 1 */,
				Fragments._InputNode__ConnectionEnd /* 2 */,
				Fragments._InputNode__Element /* 2 */,
				Fragments._InputNode__Node /* 3 */,
				Fragments._InputNode__InputNode /* 4 */
			};
		private static final int @NonNull [] __InputNode = { 1,1,2,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _IteratedEdge =
			{
				Fragments._IteratedEdge__OclAny /* 0 */,
				Fragments._IteratedEdge__OclElement /* 1 */,
				Fragments._IteratedEdge__Element /* 2 */,
				Fragments._IteratedEdge__Edge /* 3 */,
				Fragments._IteratedEdge__IteratedEdge /* 4 */
			};
		private static final int @NonNull [] __IteratedEdge = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _IteratorNode =
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

		private static final @NonNull FlatFragment @NonNull [] _KeyPartEdge =
			{
				Fragments._KeyPartEdge__OclAny /* 0 */,
				Fragments._KeyPartEdge__OclElement /* 1 */,
				Fragments._KeyPartEdge__ConnectionEnd /* 2 */,
				Fragments._KeyPartEdge__Element /* 2 */,
				Fragments._KeyPartEdge__Edge /* 3 */,
				Fragments._KeyPartEdge__NavigableEdge /* 4 */,
				Fragments._KeyPartEdge__NavigationEdge /* 5 */,
				Fragments._KeyPartEdge__KeyPartEdge /* 6 */
			};
		private static final int @NonNull [] __KeyPartEdge = { 1,1,2,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _KeyedValueNode =
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

		private static final @NonNull FlatFragment @NonNull [] _LoadingPartition =
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

		private static final @NonNull FlatFragment @NonNull [] _LoadingRegion =
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

		private static final @NonNull FlatFragment @NonNull [] _MapLiteralNode =
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

		private static final @NonNull FlatFragment @NonNull [] _MapPartEdge =
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

		private static final @NonNull FlatFragment @NonNull [] _MapPartNode =
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

		private static final @NonNull FlatFragment @NonNull [] _MappingNode =
			{
				Fragments._MappingNode__OclAny /* 0 */,
				Fragments._MappingNode__OclElement /* 1 */,
				Fragments._MappingNode__ConnectionEnd /* 2 */,
				Fragments._MappingNode__Element /* 2 */,
				Fragments._MappingNode__Node /* 3 */,
				Fragments._MappingNode__MappingNode /* 4 */
			};
		private static final int @NonNull [] __MappingNode = { 1,1,2,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _MappingPartition =
			{
				Fragments._MappingPartition__OclAny /* 0 */,
				Fragments._MappingPartition__OclElement /* 1 */,
				Fragments._MappingPartition__Element /* 2 */,
				Fragments._MappingPartition__NamedElement /* 3 */,
				Fragments._MappingPartition__Partition /* 4 */,
				Fragments._MappingPartition__MappingPartition /* 5 */
			};
		private static final int @NonNull [] __MappingPartition = { 1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _MappingRegion =
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

		private static final @NonNull FlatFragment @NonNull [] _MergedPartition =
			{
				Fragments._MergedPartition__OclAny /* 0 */,
				Fragments._MergedPartition__OclElement /* 1 */,
				Fragments._MergedPartition__Element /* 2 */,
				Fragments._MergedPartition__NamedElement /* 3 */,
				Fragments._MergedPartition__Partition /* 4 */,
				Fragments._MergedPartition__MappingPartition /* 5 */,
				Fragments._MergedPartition__BasicPartition /* 6 */,
				Fragments._MergedPartition__MergedPartition /* 7 */
			};
		private static final int @NonNull [] __MergedPartition = { 1,1,1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _NavigableEdge =
			{
				Fragments._NavigableEdge__OclAny /* 0 */,
				Fragments._NavigableEdge__OclElement /* 1 */,
				Fragments._NavigableEdge__ConnectionEnd /* 2 */,
				Fragments._NavigableEdge__Element /* 2 */,
				Fragments._NavigableEdge__Edge /* 3 */,
				Fragments._NavigableEdge__NavigableEdge /* 4 */
			};
		private static final int @NonNull [] __NavigableEdge = { 1,1,2,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _NavigationEdge =
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

		private static final @NonNull FlatFragment @NonNull [] _Node =
			{
				Fragments._Node__OclAny /* 0 */,
				Fragments._Node__OclElement /* 1 */,
				Fragments._Node__ConnectionEnd /* 2 */,
				Fragments._Node__Element /* 2 */,
				Fragments._Node__Node /* 3 */
			};
		private static final int @NonNull [] __Node = { 1,1,2,1 };

		private static final @NonNull FlatFragment @NonNull [] _NodeConnection =
			{
				Fragments._NodeConnection__OclAny /* 0 */,
				Fragments._NodeConnection__OclElement /* 1 */,
				Fragments._NodeConnection__Element /* 2 */,
				Fragments._NodeConnection__Symbolable /* 2 */,
				Fragments._NodeConnection__Connection /* 3 */,
				Fragments._NodeConnection__NodeConnection /* 4 */
			};
		private static final int @NonNull [] __NodeConnection = { 1,1,2,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _NonPartition =
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

		private static final @NonNull FlatFragment @NonNull [] _NullLiteralNode =
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

		private static final @NonNull FlatFragment @NonNull [] _Number =
			{
				Fragments._Number__OclAny /* 0 */,
				Fragments._Number__Number /* 1 */
			};
		private static final int @NonNull [] __Number = { 1,1 };

		private static final @NonNull FlatFragment @NonNull [] _NumericLiteralNode =
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

		private static final @NonNull FlatFragment @NonNull [] _OperationCallNode =
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

		private static final @NonNull FlatFragment @NonNull [] _OperationNode =
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

		private static final @NonNull FlatFragment @NonNull [] _OperationParameterEdge =
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

		private static final @NonNull FlatFragment @NonNull [] _OperationRegion =
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

		private static final @NonNull FlatFragment @NonNull [] _OperationSelfEdge =
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

		private static final @NonNull FlatFragment @NonNull [] _Partition =
			{
				Fragments._Partition__OclAny /* 0 */,
				Fragments._Partition__OclElement /* 1 */,
				Fragments._Partition__Element /* 2 */,
				Fragments._Partition__NamedElement /* 3 */,
				Fragments._Partition__Partition /* 4 */
			};
		private static final int @NonNull [] __Partition = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _PatternTypedNode =
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

		private static final @NonNull FlatFragment @NonNull [] _PatternVariableNode =
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

		private static final @NonNull FlatFragment @NonNull [] _PredicateEdge =
			{
				Fragments._PredicateEdge__OclAny /* 0 */,
				Fragments._PredicateEdge__OclElement /* 1 */,
				Fragments._PredicateEdge__Element /* 2 */,
				Fragments._PredicateEdge__Edge /* 3 */,
				Fragments._PredicateEdge__PredicateEdge /* 4 */
			};
		private static final int @NonNull [] __PredicateEdge = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _PropertyDatum =
			{
				Fragments._PropertyDatum__OclAny /* 0 */,
				Fragments._PropertyDatum__OclElement /* 1 */,
				Fragments._PropertyDatum__Element /* 2 */,
				Fragments._PropertyDatum__NamedElement /* 3 */,
				Fragments._PropertyDatum__AbstractDatum /* 4 */,
				Fragments._PropertyDatum__PropertyDatum /* 5 */
			};
		private static final int @NonNull [] __PropertyDatum = { 1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _RecursionEdge =
			{
				Fragments._RecursionEdge__OclAny /* 0 */,
				Fragments._RecursionEdge__OclElement /* 1 */,
				Fragments._RecursionEdge__Element /* 2 */,
				Fragments._RecursionEdge__Edge /* 3 */,
				Fragments._RecursionEdge__RecursionEdge /* 4 */
			};
		private static final int @NonNull [] __RecursionEdge = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Region =
			{
				Fragments._Region__OclAny /* 0 */,
				Fragments._Region__OclElement /* 1 */,
				Fragments._Region__Element /* 2 */,
				Fragments._Region__Symbolable /* 2 */,
				Fragments._Region__NamedElement /* 3 */,
				Fragments._Region__Region /* 4 */
			};
		private static final int @NonNull [] __Region = { 1,1,2,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Role =
			{
				Fragments._Role__OclAny /* 0 */,
				Fragments._Role__OclElement /* 1 */,
				Fragments._Role__OclType /* 2 */,
				Fragments._Role__OclEnumeration /* 3 */,
				Fragments._Role__Role /* 4 */
			};
		private static final int @NonNull [] __Role = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _RootPartition =
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

		private static final @NonNull FlatFragment @NonNull [] _RootRegion =
			{
				Fragments._RootRegion__OclAny /* 0 */,
				Fragments._RootRegion__OclElement /* 1 */,
				Fragments._RootRegion__Element /* 2 */,
				Fragments._RootRegion__Symbolable /* 2 */,
				Fragments._RootRegion__NamedElement /* 3 */,
				Fragments._RootRegion__Region /* 4 */,
				Fragments._RootRegion__RootRegion /* 5 */
			};
		private static final int @NonNull [] __RootRegion = { 1,1,2,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _RuleRegion =
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

		private static final @NonNull FlatFragment @NonNull [] _ScheduleModel =
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

		private static final @NonNull FlatFragment @NonNull [] _ShadowNode =
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

		private static final @NonNull FlatFragment @NonNull [] _ShadowPartEdge =
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

		private static final @NonNull FlatFragment @NonNull [] _StringLiteralNode =
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

		private static final @NonNull FlatFragment @NonNull [] _SuccessEdge =
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

		private static final @NonNull FlatFragment @NonNull [] _SuccessNode =
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

		private static final @NonNull FlatFragment @NonNull [] _Symbolable =
			{
				Fragments._Symbolable__OclAny /* 0 */,
				Fragments._Symbolable__OclElement /* 1 */,
				Fragments._Symbolable__Symbolable /* 2 */
			};
		private static final int @NonNull [] __Symbolable = { 1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _TupleLiteralNode =
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

		private static final @NonNull FlatFragment @NonNull [] _TuplePartEdge =
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

		private static final @NonNull FlatFragment @NonNull [] _TypeLiteralNode =
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

		private static final @NonNull FlatFragment @NonNull [] _UnknownNode =
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

		private static final @NonNull FlatFragment @NonNull [] _Utility =
			{
				Fragments._Utility__OclAny /* 0 */,
				Fragments._Utility__OclElement /* 1 */,
				Fragments._Utility__OclType /* 2 */,
				Fragments._Utility__OclEnumeration /* 3 */,
				Fragments._Utility__Utility /* 4 */
			};
		private static final int @NonNull [] __Utility = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _VariableNode =
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

		private static final @NonNull FlatFragment @NonNull [] _VerdictRegion =
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
			Types._CollectionClassDatum.initFragments(_CollectionClassDatum, __CollectionClassDatum);
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
			Types._MergedPartition.initFragments(_MergedPartition, __MergedPartition);
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
			Types._RootRegion.initFragments(_RootRegion, __RootRegion);
			Types._RuleRegion.initFragments(_RuleRegion, __RuleRegion);
			Types._ScheduleModel.initFragments(_ScheduleModel, __ScheduleModel);
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
			Types._Utility.initFragments(_Utility, __Utility);
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

		private static final @NonNull Operation @NonNull [] _AbstractDatum__AbstractDatum = {};
		private static final @NonNull Operation @NonNull [] _AbstractDatum__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _AbstractDatum__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _AbstractDatum__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _AbstractDatum__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _ArgumentEdge__ArgumentEdge = {};
		private static final @NonNull Operation @NonNull [] _ArgumentEdge__Edge = {};
		private static final @NonNull Operation @NonNull [] _ArgumentEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _ArgumentEdge__ExpressionEdge = {};
		private static final @NonNull Operation @NonNull [] _ArgumentEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _ArgumentEdge__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _BasicPartition__BasicPartition = {};
		private static final @NonNull Operation @NonNull [] _BasicPartition__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _BasicPartition__MappingPartition = {};
		private static final @NonNull Operation @NonNull [] _BasicPartition__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _BasicPartition__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _BasicPartition__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _BasicPartition__Partition = {};

		private static final @NonNull Operation @NonNull [] _BooleanLiteralNode__BooleanLiteralNode = {};
		private static final @NonNull Operation @NonNull [] _BooleanLiteralNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _BooleanLiteralNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _BooleanLiteralNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _BooleanLiteralNode__Node = {};
		private static final @NonNull Operation @NonNull [] _BooleanLiteralNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _BooleanLiteralNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _BooleanLiteralNode__OperationNode = {};

		private static final @NonNull Operation @NonNull [] _CastEdge__CastEdge = {};
		private static final @NonNull Operation @NonNull [] _CastEdge__Edge = {};
		private static final @NonNull Operation @NonNull [] _CastEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _CastEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _CastEdge__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _ClassDatum__ClassDatum = {};
		private static final @NonNull Operation @NonNull [] _ClassDatum__AbstractDatum = {};
		private static final @NonNull Operation @NonNull [] _ClassDatum__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _ClassDatum__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _ClassDatum__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _ClassDatum__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _Cluster__Cluster = {};
		private static final @NonNull Operation @NonNull [] _Cluster__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _Cluster__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _Cluster__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _Cluster__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _Cluster__Symbolable = {};

		private static final @NonNull Operation @NonNull [] _CollectionClassDatum__CollectionClassDatum = {};
		private static final @NonNull Operation @NonNull [] _CollectionClassDatum__AbstractDatum = {};
		private static final @NonNull Operation @NonNull [] _CollectionClassDatum__ClassDatum = {};
		private static final @NonNull Operation @NonNull [] _CollectionClassDatum__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _CollectionClassDatum__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _CollectionClassDatum__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _CollectionClassDatum__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _CollectionLiteralNode__CollectionLiteralNode = {};
		private static final @NonNull Operation @NonNull [] _CollectionLiteralNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _CollectionLiteralNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _CollectionLiteralNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _CollectionLiteralNode__Node = {};
		private static final @NonNull Operation @NonNull [] _CollectionLiteralNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _CollectionLiteralNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _CollectionLiteralNode__OperationNode = {};

		private static final @NonNull Operation @NonNull [] _CollectionPartEdge__CollectionPartEdge = {};
		private static final @NonNull Operation @NonNull [] _CollectionPartEdge__ArgumentEdge = {};
		private static final @NonNull Operation @NonNull [] _CollectionPartEdge__Edge = {};
		private static final @NonNull Operation @NonNull [] _CollectionPartEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _CollectionPartEdge__ExpressionEdge = {};
		private static final @NonNull Operation @NonNull [] _CollectionPartEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _CollectionPartEdge__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _CollectionRangeNode__CollectionRangeNode = {};
		private static final @NonNull Operation @NonNull [] _CollectionRangeNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _CollectionRangeNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _CollectionRangeNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _CollectionRangeNode__Node = {};
		private static final @NonNull Operation @NonNull [] _CollectionRangeNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _CollectionRangeNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _CollectionRangeNode__OperationNode = {};

		private static final @NonNull Operation @NonNull [] _ComposedNode__ComposedNode = {};
		private static final @NonNull Operation @NonNull [] _ComposedNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _ComposedNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _ComposedNode__Node = {};
		private static final @NonNull Operation @NonNull [] _ComposedNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _ComposedNode__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _CompositePartition__CompositePartition = {};
		private static final @NonNull Operation @NonNull [] _CompositePartition__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _CompositePartition__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _CompositePartition__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _CompositePartition__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _CompositePartition__Partition = {};

		private static final @NonNull Operation @NonNull [] _Connection__Connection = {};
		private static final @NonNull Operation @NonNull [] _Connection__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _Connection__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _Connection__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _Connection__Symbolable = {};

		private static final @NonNull Operation @NonNull [] _ConnectionEnd__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _ConnectionEnd__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _ConnectionEnd__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _ConnectionRole__ConnectionRole = {};
		private static final @NonNull Operation @NonNull [] _ConnectionRole__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _ConnectionRole__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _ConnectionRole__OclEnumeration = {};
		private static final @NonNull Operation @NonNull [] _ConnectionRole__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final @NonNull Operation @NonNull [] _CyclicMappingRegion__CyclicMappingRegion = {};
		private static final @NonNull Operation @NonNull [] _CyclicMappingRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _CyclicMappingRegion__MappingRegion = {};
		private static final @NonNull Operation @NonNull [] _CyclicMappingRegion__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _CyclicMappingRegion__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _CyclicMappingRegion__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _CyclicMappingRegion__Region = {};
		private static final @NonNull Operation @NonNull [] _CyclicMappingRegion__Symbolable = {};

		private static final @NonNull Operation @NonNull [] _CyclicPartition__CyclicPartition = {};
		private static final @NonNull Operation @NonNull [] _CyclicPartition__CompositePartition = {};
		private static final @NonNull Operation @NonNull [] _CyclicPartition__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _CyclicPartition__MappingPartition = {};
		private static final @NonNull Operation @NonNull [] _CyclicPartition__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _CyclicPartition__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _CyclicPartition__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _CyclicPartition__Partition = {};

		private static final @NonNull Operation @NonNull [] _DependencyEdge__DependencyEdge = {};
		private static final @NonNull Operation @NonNull [] _DependencyEdge__Edge = {};
		private static final @NonNull Operation @NonNull [] _DependencyEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _DependencyEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _DependencyEdge__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _DependencyNode__DependencyNode = {};
		private static final @NonNull Operation @NonNull [] _DependencyNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _DependencyNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _DependencyNode__Node = {};
		private static final @NonNull Operation @NonNull [] _DependencyNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _DependencyNode__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _DispatchRegion__DispatchRegion = {};
		private static final @NonNull Operation @NonNull [] _DispatchRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _DispatchRegion__MappingRegion = {};
		private static final @NonNull Operation @NonNull [] _DispatchRegion__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _DispatchRegion__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _DispatchRegion__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _DispatchRegion__Region = {};
		private static final @NonNull Operation @NonNull [] _DispatchRegion__RuleRegion = {};
		private static final @NonNull Operation @NonNull [] _DispatchRegion__Symbolable = {};

		private static final @NonNull Operation @NonNull [] _Edge__Edge = {};
		private static final @NonNull Operation @NonNull [] _Edge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _Edge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _Edge__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _EdgeConnection__EdgeConnection = {};
		private static final @NonNull Operation @NonNull [] _EdgeConnection__Connection = {};
		private static final @NonNull Operation @NonNull [] _EdgeConnection__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _EdgeConnection__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _EdgeConnection__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _EdgeConnection__Symbolable = {};

		private static final @NonNull Operation @NonNull [] _EnumLiteralNode__EnumLiteralNode = {};
		private static final @NonNull Operation @NonNull [] _EnumLiteralNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _EnumLiteralNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _EnumLiteralNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _EnumLiteralNode__Node = {};
		private static final @NonNull Operation @NonNull [] _EnumLiteralNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _EnumLiteralNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _EnumLiteralNode__OperationNode = {};

		private static final @NonNull Operation @NonNull [] _ErrorNode__ErrorNode = {};
		private static final @NonNull Operation @NonNull [] _ErrorNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _ErrorNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _ErrorNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _ErrorNode__Node = {};
		private static final @NonNull Operation @NonNull [] _ErrorNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _ErrorNode__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _ExpressionEdge__ExpressionEdge = {};
		private static final @NonNull Operation @NonNull [] _ExpressionEdge__Edge = {};
		private static final @NonNull Operation @NonNull [] _ExpressionEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _ExpressionEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _ExpressionEdge__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _IfNode__IfNode = {};
		private static final @NonNull Operation @NonNull [] _IfNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _IfNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _IfNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _IfNode__Node = {};
		private static final @NonNull Operation @NonNull [] _IfNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _IfNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _IfNode__OperationNode = {};

		private static final @NonNull Operation @NonNull [] _IncludesEdge__IncludesEdge = {};
		private static final @NonNull Operation @NonNull [] _IncludesEdge__Edge = {};
		private static final @NonNull Operation @NonNull [] _IncludesEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _IncludesEdge__ExpressionEdge = {};
		private static final @NonNull Operation @NonNull [] _IncludesEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _IncludesEdge__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _InputNode__InputNode = {};
		private static final @NonNull Operation @NonNull [] _InputNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _InputNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _InputNode__Node = {};
		private static final @NonNull Operation @NonNull [] _InputNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _InputNode__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _IteratedEdge__IteratedEdge = {};
		private static final @NonNull Operation @NonNull [] _IteratedEdge__Edge = {};
		private static final @NonNull Operation @NonNull [] _IteratedEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _IteratedEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _IteratedEdge__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _IteratorNode__IteratorNode = {};
		private static final @NonNull Operation @NonNull [] _IteratorNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _IteratorNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _IteratorNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _IteratorNode__Node = {};
		private static final @NonNull Operation @NonNull [] _IteratorNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _IteratorNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _IteratorNode__VariableNode = {};

		private static final @NonNull Operation @NonNull [] _KeyPartEdge__KeyPartEdge = {};
		private static final @NonNull Operation @NonNull [] _KeyPartEdge__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _KeyPartEdge__Edge = {};
		private static final @NonNull Operation @NonNull [] _KeyPartEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _KeyPartEdge__NavigableEdge = {};
		private static final @NonNull Operation @NonNull [] _KeyPartEdge__NavigationEdge = {};
		private static final @NonNull Operation @NonNull [] _KeyPartEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _KeyPartEdge__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _KeyedValueNode__KeyedValueNode = {};
		private static final @NonNull Operation @NonNull [] _KeyedValueNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _KeyedValueNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _KeyedValueNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _KeyedValueNode__Node = {};
		private static final @NonNull Operation @NonNull [] _KeyedValueNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _KeyedValueNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _KeyedValueNode__OperationNode = {};

		private static final @NonNull Operation @NonNull [] _LoadingPartition__LoadingPartition = {};
		private static final @NonNull Operation @NonNull [] _LoadingPartition__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _LoadingPartition__MappingPartition = {};
		private static final @NonNull Operation @NonNull [] _LoadingPartition__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _LoadingPartition__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _LoadingPartition__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _LoadingPartition__Partition = {};

		private static final @NonNull Operation @NonNull [] _LoadingRegion__LoadingRegion = {};
		private static final @NonNull Operation @NonNull [] _LoadingRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _LoadingRegion__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _LoadingRegion__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _LoadingRegion__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _LoadingRegion__Region = {};
		private static final @NonNull Operation @NonNull [] _LoadingRegion__Symbolable = {};

		private static final @NonNull Operation @NonNull [] _MapLiteralNode__MapLiteralNode = {};
		private static final @NonNull Operation @NonNull [] _MapLiteralNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _MapLiteralNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _MapLiteralNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _MapLiteralNode__Node = {};
		private static final @NonNull Operation @NonNull [] _MapLiteralNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _MapLiteralNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _MapLiteralNode__OperationNode = {};

		private static final @NonNull Operation @NonNull [] _MapPartEdge__MapPartEdge = {};
		private static final @NonNull Operation @NonNull [] _MapPartEdge__ArgumentEdge = {};
		private static final @NonNull Operation @NonNull [] _MapPartEdge__Edge = {};
		private static final @NonNull Operation @NonNull [] _MapPartEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _MapPartEdge__ExpressionEdge = {};
		private static final @NonNull Operation @NonNull [] _MapPartEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _MapPartEdge__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _MapPartNode__MapPartNode = {};
		private static final @NonNull Operation @NonNull [] _MapPartNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _MapPartNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _MapPartNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _MapPartNode__Node = {};
		private static final @NonNull Operation @NonNull [] _MapPartNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _MapPartNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _MapPartNode__OperationNode = {};

		private static final @NonNull Operation @NonNull [] _MappingNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _MappingNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _MappingNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _MappingNode__Node = {};
		private static final @NonNull Operation @NonNull [] _MappingNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _MappingNode__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _MappingPartition__MappingPartition = {};
		private static final @NonNull Operation @NonNull [] _MappingPartition__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _MappingPartition__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _MappingPartition__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _MappingPartition__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _MappingPartition__Partition = {};

		private static final @NonNull Operation @NonNull [] _MappingRegion__MappingRegion = {};
		private static final @NonNull Operation @NonNull [] _MappingRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _MappingRegion__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _MappingRegion__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _MappingRegion__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _MappingRegion__Region = {};
		private static final @NonNull Operation @NonNull [] _MappingRegion__Symbolable = {};

		private static final @NonNull Operation @NonNull [] _MergedPartition__MergedPartition = {};
		private static final @NonNull Operation @NonNull [] _MergedPartition__BasicPartition = {};
		private static final @NonNull Operation @NonNull [] _MergedPartition__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _MergedPartition__MappingPartition = {};
		private static final @NonNull Operation @NonNull [] _MergedPartition__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _MergedPartition__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _MergedPartition__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _MergedPartition__Partition = {};

		private static final @NonNull Operation @NonNull [] _NavigableEdge__NavigableEdge = {};
		private static final @NonNull Operation @NonNull [] _NavigableEdge__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _NavigableEdge__Edge = {};
		private static final @NonNull Operation @NonNull [] _NavigableEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _NavigableEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _NavigableEdge__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _NavigationEdge__NavigationEdge = {};
		private static final @NonNull Operation @NonNull [] _NavigationEdge__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _NavigationEdge__Edge = {};
		private static final @NonNull Operation @NonNull [] _NavigationEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _NavigationEdge__NavigableEdge = {};
		private static final @NonNull Operation @NonNull [] _NavigationEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _NavigationEdge__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _Node__Node = {};
		private static final @NonNull Operation @NonNull [] _Node__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _Node__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _Node__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _Node__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _NodeConnection__NodeConnection = {};
		private static final @NonNull Operation @NonNull [] _NodeConnection__Connection = {};
		private static final @NonNull Operation @NonNull [] _NodeConnection__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _NodeConnection__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _NodeConnection__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _NodeConnection__Symbolable = {};

		private static final @NonNull Operation @NonNull [] _NonPartition__NonPartition = {};
		private static final @NonNull Operation @NonNull [] _NonPartition__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _NonPartition__MappingPartition = {};
		private static final @NonNull Operation @NonNull [] _NonPartition__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _NonPartition__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _NonPartition__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _NonPartition__Partition = {};

		private static final @NonNull Operation @NonNull [] _NullLiteralNode__NullLiteralNode = {};
		private static final @NonNull Operation @NonNull [] _NullLiteralNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _NullLiteralNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _NullLiteralNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _NullLiteralNode__Node = {};
		private static final @NonNull Operation @NonNull [] _NullLiteralNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _NullLiteralNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _NullLiteralNode__OperationNode = {};

		private static final @NonNull Operation @NonNull [] _Number__Number = {};
		private static final @NonNull Operation @NonNull [] _Number__OclAny = {
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

		private static final @NonNull Operation @NonNull [] _NumericLiteralNode__NumericLiteralNode = {};
		private static final @NonNull Operation @NonNull [] _NumericLiteralNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _NumericLiteralNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _NumericLiteralNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _NumericLiteralNode__Node = {};
		private static final @NonNull Operation @NonNull [] _NumericLiteralNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _NumericLiteralNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _NumericLiteralNode__OperationNode = {};

		private static final @NonNull Operation @NonNull [] _OperationCallNode__OperationCallNode = {};
		private static final @NonNull Operation @NonNull [] _OperationCallNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _OperationCallNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _OperationCallNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _OperationCallNode__Node = {};
		private static final @NonNull Operation @NonNull [] _OperationCallNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _OperationCallNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _OperationCallNode__OperationNode = {};

		private static final @NonNull Operation @NonNull [] _OperationNode__OperationNode = {};
		private static final @NonNull Operation @NonNull [] _OperationNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _OperationNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _OperationNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _OperationNode__Node = {};
		private static final @NonNull Operation @NonNull [] _OperationNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _OperationNode__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _OperationParameterEdge__OperationParameterEdge = {};
		private static final @NonNull Operation @NonNull [] _OperationParameterEdge__ArgumentEdge = {};
		private static final @NonNull Operation @NonNull [] _OperationParameterEdge__Edge = {};
		private static final @NonNull Operation @NonNull [] _OperationParameterEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _OperationParameterEdge__ExpressionEdge = {};
		private static final @NonNull Operation @NonNull [] _OperationParameterEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _OperationParameterEdge__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _OperationRegion__OperationRegion = {};
		private static final @NonNull Operation @NonNull [] _OperationRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _OperationRegion__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _OperationRegion__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _OperationRegion__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _OperationRegion__Region = {};
		private static final @NonNull Operation @NonNull [] _OperationRegion__Symbolable = {};

		private static final @NonNull Operation @NonNull [] _OperationSelfEdge__OperationSelfEdge = {};
		private static final @NonNull Operation @NonNull [] _OperationSelfEdge__ArgumentEdge = {};
		private static final @NonNull Operation @NonNull [] _OperationSelfEdge__Edge = {};
		private static final @NonNull Operation @NonNull [] _OperationSelfEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _OperationSelfEdge__ExpressionEdge = {};
		private static final @NonNull Operation @NonNull [] _OperationSelfEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _OperationSelfEdge__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _Partition__Partition = {};
		private static final @NonNull Operation @NonNull [] _Partition__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _Partition__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _Partition__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _Partition__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _PatternTypedNode__PatternTypedNode = {};
		private static final @NonNull Operation @NonNull [] _PatternTypedNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _PatternTypedNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _PatternTypedNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _PatternTypedNode__Node = {};
		private static final @NonNull Operation @NonNull [] _PatternTypedNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _PatternTypedNode__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _PatternVariableNode__PatternVariableNode = {};
		private static final @NonNull Operation @NonNull [] _PatternVariableNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _PatternVariableNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _PatternVariableNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _PatternVariableNode__Node = {};
		private static final @NonNull Operation @NonNull [] _PatternVariableNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _PatternVariableNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _PatternVariableNode__VariableNode = {};

		private static final @NonNull Operation @NonNull [] _PredicateEdge__PredicateEdge = {};
		private static final @NonNull Operation @NonNull [] _PredicateEdge__Edge = {};
		private static final @NonNull Operation @NonNull [] _PredicateEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _PredicateEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _PredicateEdge__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _PropertyDatum__PropertyDatum = {};
		private static final @NonNull Operation @NonNull [] _PropertyDatum__AbstractDatum = {};
		private static final @NonNull Operation @NonNull [] _PropertyDatum__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _PropertyDatum__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _PropertyDatum__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _PropertyDatum__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _RecursionEdge__RecursionEdge = {};
		private static final @NonNull Operation @NonNull [] _RecursionEdge__Edge = {};
		private static final @NonNull Operation @NonNull [] _RecursionEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _RecursionEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _RecursionEdge__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _Region__Region = {};
		private static final @NonNull Operation @NonNull [] _Region__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _Region__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _Region__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _Region__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _Region__Symbolable = {};

		private static final @NonNull Operation @NonNull [] _Role__Role = {};
		private static final @NonNull Operation @NonNull [] _Role__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _Role__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _Role__OclEnumeration = {};
		private static final @NonNull Operation @NonNull [] _Role__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final @NonNull Operation @NonNull [] _RootPartition__RootPartition = {};
		private static final @NonNull Operation @NonNull [] _RootPartition__CompositePartition = {};
		private static final @NonNull Operation @NonNull [] _RootPartition__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _RootPartition__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _RootPartition__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _RootPartition__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _RootPartition__Partition = {};

		private static final @NonNull Operation @NonNull [] _RootRegion__RootRegion = {};
		private static final @NonNull Operation @NonNull [] _RootRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _RootRegion__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _RootRegion__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _RootRegion__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _RootRegion__Region = {};
		private static final @NonNull Operation @NonNull [] _RootRegion__Symbolable = {};

		private static final @NonNull Operation @NonNull [] _RuleRegion__RuleRegion = {};
		private static final @NonNull Operation @NonNull [] _RuleRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _RuleRegion__MappingRegion = {};
		private static final @NonNull Operation @NonNull [] _RuleRegion__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _RuleRegion__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _RuleRegion__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _RuleRegion__Region = {};
		private static final @NonNull Operation @NonNull [] _RuleRegion__Symbolable = {};

		private static final @NonNull Operation @NonNull [] _ScheduleModel__ScheduleModel = {};
		private static final @NonNull Operation @NonNull [] _ScheduleModel__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _ScheduleModel__Model = {};
		private static final @NonNull Operation @NonNull [] _ScheduleModel__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _ScheduleModel__Namespace = {};
		private static final @NonNull Operation @NonNull [] _ScheduleModel__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _ScheduleModel__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _ShadowNode__ShadowNode = {};
		private static final @NonNull Operation @NonNull [] _ShadowNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _ShadowNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _ShadowNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _ShadowNode__Node = {};
		private static final @NonNull Operation @NonNull [] _ShadowNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _ShadowNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _ShadowNode__OperationNode = {};

		private static final @NonNull Operation @NonNull [] _ShadowPartEdge__ShadowPartEdge = {};
		private static final @NonNull Operation @NonNull [] _ShadowPartEdge__ArgumentEdge = {};
		private static final @NonNull Operation @NonNull [] _ShadowPartEdge__Edge = {};
		private static final @NonNull Operation @NonNull [] _ShadowPartEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _ShadowPartEdge__ExpressionEdge = {};
		private static final @NonNull Operation @NonNull [] _ShadowPartEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _ShadowPartEdge__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _StringLiteralNode__StringLiteralNode = {};
		private static final @NonNull Operation @NonNull [] _StringLiteralNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _StringLiteralNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _StringLiteralNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _StringLiteralNode__Node = {};
		private static final @NonNull Operation @NonNull [] _StringLiteralNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _StringLiteralNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _StringLiteralNode__OperationNode = {};

		private static final @NonNull Operation @NonNull [] _SuccessEdge__SuccessEdge = {};
		private static final @NonNull Operation @NonNull [] _SuccessEdge__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _SuccessEdge__Edge = {};
		private static final @NonNull Operation @NonNull [] _SuccessEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _SuccessEdge__NavigableEdge = {};
		private static final @NonNull Operation @NonNull [] _SuccessEdge__NavigationEdge = {};
		private static final @NonNull Operation @NonNull [] _SuccessEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _SuccessEdge__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _SuccessNode__SuccessNode = {};
		private static final @NonNull Operation @NonNull [] _SuccessNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _SuccessNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _SuccessNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _SuccessNode__Node = {};
		private static final @NonNull Operation @NonNull [] _SuccessNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _SuccessNode__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _Symbolable__Symbolable = {};
		private static final @NonNull Operation @NonNull [] _Symbolable__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _Symbolable__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _TupleLiteralNode__TupleLiteralNode = {};
		private static final @NonNull Operation @NonNull [] _TupleLiteralNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _TupleLiteralNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _TupleLiteralNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _TupleLiteralNode__Node = {};
		private static final @NonNull Operation @NonNull [] _TupleLiteralNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _TupleLiteralNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _TupleLiteralNode__OperationNode = {};

		private static final @NonNull Operation @NonNull [] _TuplePartEdge__TuplePartEdge = {};
		private static final @NonNull Operation @NonNull [] _TuplePartEdge__ArgumentEdge = {};
		private static final @NonNull Operation @NonNull [] _TuplePartEdge__Edge = {};
		private static final @NonNull Operation @NonNull [] _TuplePartEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _TuplePartEdge__ExpressionEdge = {};
		private static final @NonNull Operation @NonNull [] _TuplePartEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _TuplePartEdge__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _TypeLiteralNode__TypeLiteralNode = {};
		private static final @NonNull Operation @NonNull [] _TypeLiteralNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _TypeLiteralNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _TypeLiteralNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _TypeLiteralNode__Node = {};
		private static final @NonNull Operation @NonNull [] _TypeLiteralNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _TypeLiteralNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _TypeLiteralNode__OperationNode = {};

		private static final @NonNull Operation @NonNull [] _UnknownNode__UnknownNode = {};
		private static final @NonNull Operation @NonNull [] _UnknownNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _UnknownNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _UnknownNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _UnknownNode__Node = {};
		private static final @NonNull Operation @NonNull [] _UnknownNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _UnknownNode__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _Utility__Utility = {};
		private static final @NonNull Operation @NonNull [] _Utility__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _Utility__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _Utility__OclEnumeration = {};
		private static final @NonNull Operation @NonNull [] _Utility__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final @NonNull Operation @NonNull [] _VariableNode__VariableNode = {};
		private static final @NonNull Operation @NonNull [] _VariableNode__ConnectionEnd = {};
		private static final @NonNull Operation @NonNull [] _VariableNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _VariableNode__MappingNode = {};
		private static final @NonNull Operation @NonNull [] _VariableNode__Node = {};
		private static final @NonNull Operation @NonNull [] _VariableNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _VariableNode__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _VerdictRegion__VerdictRegion = {};
		private static final @NonNull Operation @NonNull [] _VerdictRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull Operation @NonNull [] _VerdictRegion__MappingRegion = {};
		private static final @NonNull Operation @NonNull [] _VerdictRegion__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _VerdictRegion__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _VerdictRegion__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _VerdictRegion__Region = {};
		private static final @NonNull Operation @NonNull [] _VerdictRegion__RuleRegion = {};
		private static final @NonNull Operation @NonNull [] _VerdictRegion__Symbolable = {};

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
			Fragments._CastEdge__Edge.initOperations(_CastEdge__Edge);
			Fragments._CastEdge__Element.initOperations(_CastEdge__Element);
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

			Fragments._CollectionClassDatum__AbstractDatum.initOperations(_CollectionClassDatum__AbstractDatum);
			Fragments._CollectionClassDatum__ClassDatum.initOperations(_CollectionClassDatum__ClassDatum);
			Fragments._CollectionClassDatum__CollectionClassDatum.initOperations(_CollectionClassDatum__CollectionClassDatum);
			Fragments._CollectionClassDatum__Element.initOperations(_CollectionClassDatum__Element);
			Fragments._CollectionClassDatum__NamedElement.initOperations(_CollectionClassDatum__NamedElement);
			Fragments._CollectionClassDatum__OclAny.initOperations(_CollectionClassDatum__OclAny);
			Fragments._CollectionClassDatum__OclElement.initOperations(_CollectionClassDatum__OclElement);

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

			Fragments._KeyPartEdge__ConnectionEnd.initOperations(_KeyPartEdge__ConnectionEnd);
			Fragments._KeyPartEdge__Edge.initOperations(_KeyPartEdge__Edge);
			Fragments._KeyPartEdge__Element.initOperations(_KeyPartEdge__Element);
			Fragments._KeyPartEdge__KeyPartEdge.initOperations(_KeyPartEdge__KeyPartEdge);
			Fragments._KeyPartEdge__NavigableEdge.initOperations(_KeyPartEdge__NavigableEdge);
			Fragments._KeyPartEdge__NavigationEdge.initOperations(_KeyPartEdge__NavigationEdge);
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

			Fragments._MergedPartition__BasicPartition.initOperations(_MergedPartition__BasicPartition);
			Fragments._MergedPartition__Element.initOperations(_MergedPartition__Element);
			Fragments._MergedPartition__MappingPartition.initOperations(_MergedPartition__MappingPartition);
			Fragments._MergedPartition__MergedPartition.initOperations(_MergedPartition__MergedPartition);
			Fragments._MergedPartition__NamedElement.initOperations(_MergedPartition__NamedElement);
			Fragments._MergedPartition__OclAny.initOperations(_MergedPartition__OclAny);
			Fragments._MergedPartition__OclElement.initOperations(_MergedPartition__OclElement);
			Fragments._MergedPartition__Partition.initOperations(_MergedPartition__Partition);

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

			Fragments._RootRegion__Element.initOperations(_RootRegion__Element);
			Fragments._RootRegion__NamedElement.initOperations(_RootRegion__NamedElement);
			Fragments._RootRegion__OclAny.initOperations(_RootRegion__OclAny);
			Fragments._RootRegion__OclElement.initOperations(_RootRegion__OclElement);
			Fragments._RootRegion__Region.initOperations(_RootRegion__Region);
			Fragments._RootRegion__RootRegion.initOperations(_RootRegion__RootRegion);
			Fragments._RootRegion__Symbolable.initOperations(_RootRegion__Symbolable);

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

			Fragments._Utility__OclAny.initOperations(_Utility__OclAny);
			Fragments._Utility__OclElement.initOperations(_Utility__OclElement);
			Fragments._Utility__OclEnumeration.initOperations(_Utility__OclEnumeration);
			Fragments._Utility__OclType.initOperations(_Utility__OclType);
			Fragments._Utility__Utility.initOperations(_Utility__Utility);

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

		private static final @NonNull Property @NonNull [] _AbstractDatum = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions
		};

		private static final @NonNull Property @NonNull [] _ArgumentEdge = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Edge__cluster,
			Properties._Edge__edgeRole,
			Properties._Edge__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Edge__owningRegion,
			Properties._Edge__sourceNode,
			Properties._Edge__targetNode,
			Properties._Edge__utility
		};

		private static final @NonNull Property @NonNull [] _BasicPartition = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._BasicPartition__constantEdges,
			Properties._BasicPartition__constantNodes,
			Properties._BasicPartition__constantSuccessFalseNodes,
			Properties._BasicPartition__constantSuccessTrueNodes,
			Properties._BasicPartition__explicitPredecessors,
			Properties._MappingPartition__explicitSuccessors,
			Properties._BasicPartition__headNodes,
			Properties._Partition__intermediateConnections,
			Properties._BasicPartition__loadedEdges,
			Properties._BasicPartition__loadedNodes,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._MappingPartition__owningCompositePartition,
			Properties._BasicPartition__owningMergedPartition,
			Properties._Partition__passes,
			Properties._BasicPartition__predicatedEdges,
			Properties._BasicPartition__predicatedNodes,
			Properties._BasicPartition__realizedEdges,
			Properties._BasicPartition__realizedNodes,
			Properties._MappingPartition__referedMappingRegion,
			Properties._MappingPartition__region,
			Properties._Partition__rootConnections,
			Properties._BasicPartition__speculatedEdges,
			Properties._BasicPartition__speculatedNodes,
			Properties._BasicPartition__speculationNodes
		};

		private static final @NonNull Property @NonNull [] _BooleanLiteralNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._BooleanLiteralNode__booleanValue,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _CastEdge = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Edge__cluster,
			Properties._Edge__edgeRole,
			Properties._Edge__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Edge__owningRegion,
			Properties._CastEdge__referredClassDatum,
			Properties._Edge__sourceNode,
			Properties._Edge__targetNode,
			Properties._Edge__utility
		};

		private static final @NonNull Property @NonNull [] _ClassDatum = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._ClassDatum__completeClasses,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._ClassDatum__ownedPropertyDatums,
			Properties._ClassDatum__owningScheduleModel,
			Properties._ClassDatum__referredClass,
			Properties._ClassDatum__referredTypedModel,
			Properties._ClassDatum__superClassDatums
		};

		private static final @NonNull Property @NonNull [] _Cluster = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Cluster__depth,
			Properties._Cluster__memberEdges,
			Properties._Cluster__memberNodes,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Cluster__owningRegion,
			Properties._Cluster__precedingClusters,
			Properties._Cluster__succeedingClusters,
			Properties._Symbolable__symbolName
		};

		private static final @NonNull Property @NonNull [] _CollectionClassDatum = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._ClassDatum__completeClasses,
			Properties._CollectionClassDatum__elementalClassDatum,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._ClassDatum__ownedPropertyDatums,
			Properties._ClassDatum__owningScheduleModel,
			Properties._ClassDatum__referredClass,
			Properties._ClassDatum__referredTypedModel,
			Properties._ClassDatum__superClassDatums
		};

		private static final @NonNull Property @NonNull [] _CollectionLiteralNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _CollectionPartEdge = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Edge__cluster,
			Properties._Edge__edgeRole,
			Properties._Edge__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Edge__owningRegion,
			Properties._CollectionPartEdge__referredPart,
			Properties._Edge__sourceNode,
			Properties._Edge__targetNode,
			Properties._Edge__utility
		};

		private static final @NonNull Property @NonNull [] _CollectionRangeNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _ComposedNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _CompositePartition = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Partition__intermediateConnections,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._CompositePartition__ownedMappingPartitions,
			Properties._Partition__passes,
			Properties._Partition__rootConnections
		};

		private static final @NonNull Property @NonNull [] _Connection = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Connection__commonPartition,
			Properties._Connection__connectionRole,
			Properties._Connection__intermediatePartitions,
			Properties._Connection__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Connection__owningRootRegion,
			Properties._Connection__sourceEnds,
			Properties._Symbolable__symbolName
		};

		private static final @NonNull Property @NonNull [] _ConnectionEnd = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _ConnectionRole = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _CyclicMappingRegion = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._CyclicMappingRegion__elementRegions,
			Properties._MappingRegion__headNodes,
			Properties._MappingRegion__mappingPartitions,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			Properties._Region__ownedClusters,
			PivotTables.Properties._Element__ownedComments,
			Properties._Region__ownedEdges,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Region__ownedNodes,
			Properties._MappingRegion__owningScheduleModel,
			Properties._Region__rootRegion,
			Properties._Symbolable__symbolName
		};

		private static final @NonNull Property @NonNull [] _CyclicPartition = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._MappingPartition__explicitSuccessors,
			Properties._Partition__intermediateConnections,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._CompositePartition__ownedMappingPartitions,
			Properties._MappingPartition__owningCompositePartition,
			Properties._Partition__passes,
			Properties._MappingPartition__referedMappingRegion,
			Properties._MappingPartition__region,
			Properties._Partition__rootConnections
		};

		private static final @NonNull Property @NonNull [] _DependencyEdge = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Edge__cluster,
			Properties._Edge__edgeRole,
			Properties._Edge__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Edge__owningRegion,
			Properties._Edge__sourceNode,
			Properties._Edge__targetNode,
			Properties._Edge__utility
		};

		private static final @NonNull Property @NonNull [] _DependencyNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _DispatchRegion = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._MappingRegion__headNodes,
			Properties._MappingRegion__mappingPartitions,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			Properties._Region__ownedClusters,
			PivotTables.Properties._Element__ownedComments,
			Properties._Region__ownedEdges,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Region__ownedNodes,
			Properties._MappingRegion__owningScheduleModel,
			Properties._RuleRegion__referredRule,
			Properties._DispatchRegion__referredRuleRegion,
			Properties._Region__rootRegion,
			Properties._Symbolable__symbolName
		};

		private static final @NonNull Property @NonNull [] _Edge = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Edge__cluster,
			Properties._Edge__edgeRole,
			Properties._Edge__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Edge__owningRegion,
			Properties._Edge__sourceNode,
			Properties._Edge__targetNode,
			Properties._Edge__utility
		};

		private static final @NonNull Property @NonNull [] _EdgeConnection = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Connection__commonPartition,
			Properties._Connection__connectionRole,
			Properties._Connection__intermediatePartitions,
			Properties._EdgeConnection__mandatoryTargetEdges,
			Properties._Connection__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Connection__owningRootRegion,
			Properties._EdgeConnection__preferredTargetEdges,
			Properties._EdgeConnection__referredProperty,
			Properties._Connection__sourceEnds,
			Properties._Symbolable__symbolName
		};

		private static final @NonNull Property @NonNull [] _EnumLiteralNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._EnumLiteralNode__enumValue,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _ErrorNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _ExpressionEdge = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Edge__cluster,
			Properties._Edge__edgeRole,
			Properties._Edge__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Edge__owningRegion,
			Properties._Edge__sourceNode,
			Properties._Edge__targetNode,
			Properties._Edge__utility
		};

		private static final @NonNull Property @NonNull [] _IfNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _IncludesEdge = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Edge__cluster,
			Properties._Edge__edgeRole,
			Properties._Edge__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Edge__owningRegion,
			Properties._Edge__sourceNode,
			Properties._Edge__targetNode,
			Properties._Edge__utility
		};

		private static final @NonNull Property @NonNull [] _InputNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _IteratedEdge = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Edge__cluster,
			Properties._Edge__edgeRole,
			Properties._Edge__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Edge__owningRegion,
			Properties._Edge__sourceNode,
			Properties._Edge__targetNode,
			Properties._Edge__utility
		};

		private static final @NonNull Property @NonNull [] _IteratorNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._VariableNode__referredVariable,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _KeyPartEdge = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Edge__cluster,
			Properties._Edge__edgeRole,
			Properties._NavigableEdge__incomingConnection,
			Properties._Edge__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._NavigationEdge__oppositeEdge,
			Properties._NavigableEdge__outgoingConnections,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Edge__owningRegion,
			Properties._NavigationEdge__partial,
			Properties._KeyPartEdge__referredPart,
			Properties._NavigationEdge__referredProperty,
			Properties._NavigationEdge__secondary,
			Properties._Edge__sourceNode,
			Properties._Edge__targetNode,
			Properties._Edge__utility
		};

		private static final @NonNull Property @NonNull [] _KeyedValueNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._KeyedValueNode__classDatumValue,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _LoadingPartition = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._MappingPartition__explicitSuccessors,
			Properties._Partition__intermediateConnections,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._MappingPartition__owningCompositePartition,
			Properties._Partition__passes,
			Properties._MappingPartition__referedMappingRegion,
			Properties._LoadingPartition__referredLoadingRegion,
			Properties._MappingPartition__region,
			Properties._Partition__rootConnections
		};

		private static final @NonNull Property @NonNull [] _LoadingRegion = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._LoadingRegion__loadingPartition,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			Properties._Region__ownedClusters,
			PivotTables.Properties._Element__ownedComments,
			Properties._Region__ownedEdges,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Region__ownedNodes,
			Properties._LoadingRegion__owningRootRegion,
			Properties._Region__rootRegion,
			Properties._Symbolable__symbolName,
			Properties._LoadingRegion__targetName
		};

		private static final @NonNull Property @NonNull [] _MapLiteralNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _MapPartEdge = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Edge__cluster,
			Properties._Edge__edgeRole,
			Properties._Edge__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Edge__owningRegion,
			Properties._MapPartEdge__referredPart,
			Properties._Edge__sourceNode,
			Properties._Edge__targetNode,
			Properties._Edge__utility
		};

		private static final @NonNull Property @NonNull [] _MapPartNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _MappingNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _MappingPartition = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._MappingPartition__explicitSuccessors,
			Properties._Partition__intermediateConnections,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._MappingPartition__owningCompositePartition,
			Properties._Partition__passes,
			Properties._MappingPartition__referedMappingRegion,
			Properties._MappingPartition__region,
			Properties._Partition__rootConnections
		};

		private static final @NonNull Property @NonNull [] _MappingRegion = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._MappingRegion__headNodes,
			Properties._MappingRegion__mappingPartitions,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			Properties._Region__ownedClusters,
			PivotTables.Properties._Element__ownedComments,
			Properties._Region__ownedEdges,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Region__ownedNodes,
			Properties._MappingRegion__owningScheduleModel,
			Properties._Region__rootRegion,
			Properties._Symbolable__symbolName
		};

		private static final @NonNull Property @NonNull [] _MergedPartition = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._BasicPartition__constantEdges,
			Properties._BasicPartition__constantNodes,
			Properties._BasicPartition__constantSuccessFalseNodes,
			Properties._BasicPartition__constantSuccessTrueNodes,
			Properties._BasicPartition__explicitPredecessors,
			Properties._MappingPartition__explicitSuccessors,
			Properties._BasicPartition__headNodes,
			Properties._Partition__intermediateConnections,
			Properties._BasicPartition__loadedEdges,
			Properties._BasicPartition__loadedNodes,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._MergedPartition__ownedMergedPartitions,
			Properties._MappingPartition__owningCompositePartition,
			Properties._BasicPartition__owningMergedPartition,
			Properties._Partition__passes,
			Properties._BasicPartition__predicatedEdges,
			Properties._BasicPartition__predicatedNodes,
			Properties._BasicPartition__realizedEdges,
			Properties._BasicPartition__realizedNodes,
			Properties._MappingPartition__referedMappingRegion,
			Properties._MappingPartition__region,
			Properties._Partition__rootConnections,
			Properties._BasicPartition__speculatedEdges,
			Properties._BasicPartition__speculatedNodes,
			Properties._BasicPartition__speculationNodes
		};

		private static final @NonNull Property @NonNull [] _NavigableEdge = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Edge__cluster,
			Properties._Edge__edgeRole,
			Properties._NavigableEdge__incomingConnection,
			Properties._Edge__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._NavigableEdge__outgoingConnections,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Edge__owningRegion,
			Properties._Edge__sourceNode,
			Properties._Edge__targetNode,
			Properties._Edge__utility
		};

		private static final @NonNull Property @NonNull [] _NavigationEdge = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Edge__cluster,
			Properties._Edge__edgeRole,
			Properties._NavigableEdge__incomingConnection,
			Properties._Edge__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._NavigationEdge__oppositeEdge,
			Properties._NavigableEdge__outgoingConnections,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Edge__owningRegion,
			Properties._NavigationEdge__partial,
			Properties._NavigationEdge__referredProperty,
			Properties._NavigationEdge__secondary,
			Properties._Edge__sourceNode,
			Properties._Edge__targetNode,
			Properties._Edge__utility
		};

		private static final @NonNull Property @NonNull [] _Node = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _NodeConnection = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._NodeConnection__classDatum,
			Properties._Connection__commonPartition,
			Properties._Connection__connectionRole,
			Properties._Connection__intermediatePartitions,
			Properties._NodeConnection__mandatoryTargetNodes,
			Properties._Connection__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Connection__owningRootRegion,
			Properties._NodeConnection__passedTargetNodes,
			Properties._NodeConnection__preferredTargetNodes,
			Properties._Connection__sourceEnds,
			Properties._Symbolable__symbolName
		};

		private static final @NonNull Property @NonNull [] _NonPartition = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._MappingPartition__explicitSuccessors,
			Properties._Partition__intermediateConnections,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._MappingPartition__owningCompositePartition,
			Properties._Partition__passes,
			Properties._MappingPartition__referedMappingRegion,
			Properties._MappingPartition__region,
			Properties._Partition__rootConnections
		};

		private static final @NonNull Property @NonNull [] _NullLiteralNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _Number = {};

		private static final @NonNull Property @NonNull [] _NumericLiteralNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			Properties._NumericLiteralNode__numericValue,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _OperationCallNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._OperationCallNode__referredOperation,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _OperationNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _OperationParameterEdge = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Edge__cluster,
			Properties._Edge__edgeRole,
			Properties._Edge__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Edge__owningRegion,
			Properties._OperationParameterEdge__parameterIndex,
			Properties._OperationParameterEdge__referredParameter,
			Properties._Edge__sourceNode,
			Properties._Edge__targetNode,
			Properties._Edge__utility
		};

		private static final @NonNull Property @NonNull [] _OperationRegion = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._OperationRegion__dependencyNodes,
			Properties._OperationRegion__headNodes,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			Properties._Region__ownedClusters,
			PivotTables.Properties._Element__ownedComments,
			Properties._Region__ownedEdges,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Region__ownedNodes,
			Properties._OperationRegion__owningScheduleModel,
			Properties._OperationRegion__referredOperation,
			Properties._OperationRegion__resultNode,
			Properties._Region__rootRegion,
			Properties._Symbolable__symbolName
		};

		private static final @NonNull Property @NonNull [] _OperationSelfEdge = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Edge__cluster,
			Properties._Edge__edgeRole,
			Properties._Edge__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Edge__owningRegion,
			Properties._OperationSelfEdge__referredType,
			Properties._Edge__sourceNode,
			Properties._Edge__targetNode,
			Properties._Edge__utility
		};

		private static final @NonNull Property @NonNull [] _Partition = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Partition__intermediateConnections,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Partition__passes,
			Properties._Partition__rootConnections
		};

		private static final @NonNull Property @NonNull [] _PatternTypedNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _PatternVariableNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._VariableNode__referredVariable,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _PredicateEdge = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Edge__cluster,
			Properties._Edge__edgeRole,
			Properties._Edge__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Edge__owningRegion,
			Properties._PredicateEdge__partial,
			Properties._Edge__sourceNode,
			Properties._Edge__targetNode,
			Properties._Edge__utility
		};

		private static final @NonNull Property @NonNull [] _PropertyDatum = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._PropertyDatum__key,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._PropertyDatum__opposite,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._PropertyDatum__owningClassDatum,
			Properties._PropertyDatum__referredProperty,
			Properties._PropertyDatum__superPropertyDatums,
			Properties._PropertyDatum__targetClassDatum
		};

		private static final @NonNull Property @NonNull [] _RecursionEdge = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Edge__cluster,
			Properties._Edge__edgeRole,
			Properties._Edge__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Edge__owningRegion,
			Properties._RecursionEdge__primary,
			Properties._Edge__sourceNode,
			Properties._Edge__targetNode,
			Properties._Edge__utility
		};

		private static final @NonNull Property @NonNull [] _Region = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			Properties._Region__ownedClusters,
			PivotTables.Properties._Element__ownedComments,
			Properties._Region__ownedEdges,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Region__ownedNodes,
			Properties._Region__rootRegion,
			Properties._Symbolable__symbolName
		};

		private static final @NonNull Property @NonNull [] _Role = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _RootPartition = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Partition__intermediateConnections,
			Properties._RootPartition__loadingPartition,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._CompositePartition__ownedMappingPartitions,
			Properties._RootPartition__owningRootRegion,
			Properties._Partition__passes,
			Properties._Partition__rootConnections
		};

		private static final @NonNull Property @NonNull [] _RootRegion = {
			Properties._RootRegion__activeRegions,
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			Properties._Region__ownedClusters,
			PivotTables.Properties._Element__ownedComments,
			Properties._RootRegion__ownedConnections,
			Properties._Region__ownedEdges,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._RootRegion__ownedLoadingRegion,
			Properties._Region__ownedNodes,
			Properties._RootRegion__ownedRootPartition,
			Properties._RootRegion__owningScheduleModel,
			Properties._RootRegion__referredTransformation,
			Properties._Region__rootRegion,
			Properties._Symbolable__symbolName
		};

		private static final @NonNull Property @NonNull [] _RuleRegion = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._MappingRegion__headNodes,
			Properties._MappingRegion__mappingPartitions,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			Properties._Region__ownedClusters,
			PivotTables.Properties._Element__ownedComments,
			Properties._Region__ownedEdges,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Region__ownedNodes,
			Properties._MappingRegion__owningScheduleModel,
			Properties._RuleRegion__referredRule,
			Properties._Region__rootRegion,
			Properties._Symbolable__symbolName
		};

		private static final @NonNull Property @NonNull [] _ScheduleModel = {
			PivotTables.Properties._Element__annotatingComments,
			PivotTables.Properties._Model__externalURI,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			Properties._ScheduleModel__ownedClassDatums,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Namespace__ownedConstraints,
			PivotTables.Properties._Element__ownedExtensions,
			PivotTables.Properties._Model__ownedImports,
			Properties._ScheduleModel__ownedMappingRegions,
			Properties._ScheduleModel__ownedOperationRegions,
			PivotTables.Properties._Model__ownedPackages,
			Properties._ScheduleModel__ownedRootRegions,
			PivotTables.Properties._Model__xmiidVersion
		};

		private static final @NonNull Property @NonNull [] _ShadowNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _ShadowPartEdge = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Edge__cluster,
			Properties._Edge__edgeRole,
			Properties._Edge__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Edge__owningRegion,
			Properties._ShadowPartEdge__referredPart,
			Properties._Edge__sourceNode,
			Properties._Edge__targetNode,
			Properties._Edge__utility
		};

		private static final @NonNull Property @NonNull [] _StringLiteralNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._StringLiteralNode__stringValue,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _SuccessEdge = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Edge__cluster,
			Properties._Edge__edgeRole,
			Properties._NavigableEdge__incomingConnection,
			Properties._Edge__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._NavigationEdge__oppositeEdge,
			Properties._NavigableEdge__outgoingConnections,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Edge__owningRegion,
			Properties._NavigationEdge__partial,
			Properties._NavigationEdge__referredProperty,
			Properties._NavigationEdge__secondary,
			Properties._Edge__sourceNode,
			Properties._Edge__targetNode,
			Properties._Edge__utility
		};

		private static final @NonNull Property @NonNull [] _SuccessNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _Symbolable = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Symbolable__symbolName
		};

		private static final @NonNull Property @NonNull [] _TupleLiteralNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _TuplePartEdge = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Edge__cluster,
			Properties._Edge__edgeRole,
			Properties._Edge__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Edge__owningRegion,
			Properties._TuplePartEdge__referredPart,
			Properties._Edge__sourceNode,
			Properties._Edge__targetNode,
			Properties._Edge__utility
		};

		private static final @NonNull Property @NonNull [] _TypeLiteralNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._TypeLiteralNode__typeValue,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _UnknownNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _Utility = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _VariableNode = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._Node__classDatum,
			Properties._Node__cluster,
			Properties._Node__incomingConnection,
			Properties._Node__incomingEdges,
			Properties._Node__name,
			Properties._Node__nodeRole,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Node__outgoingConnections,
			Properties._Node__outgoingEdges,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Node__owningRegion,
			Properties._VariableNode__referredVariable,
			Properties._Node__utility
		};

		private static final @NonNull Property @NonNull [] _VerdictRegion = {
			PivotTables.Properties._Element__annotatingComments,
			Properties._MappingRegion__headNodes,
			Properties._MappingRegion__mappingPartitions,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			Properties._Region__ownedClusters,
			PivotTables.Properties._Element__ownedComments,
			Properties._Region__ownedEdges,
			PivotTables.Properties._Element__ownedExtensions,
			Properties._Region__ownedNodes,
			Properties._MappingRegion__owningScheduleModel,
			Properties._RuleRegion__referredRule,
			Properties._VerdictRegion__referredRuleRegion,
			Properties._Region__rootRegion,
			Properties._Symbolable__symbolName
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
			Fragments._CollectionClassDatum__CollectionClassDatum.initProperties(_CollectionClassDatum);
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
			Fragments._MergedPartition__MergedPartition.initProperties(_MergedPartition);
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
			Fragments._RootRegion__RootRegion.initProperties(_RootRegion);
			Fragments._RuleRegion__RuleRegion.initProperties(_RuleRegion);
			Fragments._ScheduleModel__ScheduleModel.initProperties(_ScheduleModel);
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
			Fragments._Utility__Utility.initProperties(_Utility);
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

		public static final @NonNull EnumerationLiteral _ConnectionRole__MANDATORY_EDGE = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.CONNECTION_ROLE.getEEnumLiteral("MANDATORY_EDGE"), Types._ConnectionRole, 0);
		public static final @NonNull EnumerationLiteral _ConnectionRole__MANDATORY_NODE = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.CONNECTION_ROLE.getEEnumLiteral("MANDATORY_NODE"), Types._ConnectionRole, 1);
		public static final @NonNull EnumerationLiteral _ConnectionRole__PASSED = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.CONNECTION_ROLE.getEEnumLiteral("PASSED"), Types._ConnectionRole, 2);
		public static final @NonNull EnumerationLiteral _ConnectionRole__PREFERRED_EDGE = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.CONNECTION_ROLE.getEEnumLiteral("PREFERRED_EDGE"), Types._ConnectionRole, 3);
		public static final @NonNull EnumerationLiteral _ConnectionRole__PREFERRED_NODE = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.CONNECTION_ROLE.getEEnumLiteral("PREFERRED_NODE"), Types._ConnectionRole, 4);
		public static final @NonNull EnumerationLiteral _ConnectionRole__UNDEFINED = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.CONNECTION_ROLE.getEEnumLiteral("UNDEFINED"), Types._ConnectionRole, 5);
		private static final @NonNull EnumerationLiteral @NonNull [] _ConnectionRole = {
			_ConnectionRole__MANDATORY_EDGE,
			_ConnectionRole__MANDATORY_NODE,
			_ConnectionRole__PASSED,
			_ConnectionRole__PREFERRED_EDGE,
			_ConnectionRole__PREFERRED_NODE,
			_ConnectionRole__UNDEFINED
		};

		public static final @NonNull EnumerationLiteral _Role__CONSTANT = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("CONSTANT"), Types._Role, 0);
		public static final @NonNull EnumerationLiteral _Role__CONSTANT_SUCCESS_FALSE = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("CONSTANT_SUCCESS_FALSE"), Types._Role, 1);
		public static final @NonNull EnumerationLiteral _Role__CONSTANT_SUCCESS_TRUE = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("CONSTANT_SUCCESS_TRUE"), Types._Role, 2);
		public static final @NonNull EnumerationLiteral _Role__LOADED = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("LOADED"), Types._Role, 3);
		public static final @NonNull EnumerationLiteral _Role__REALIZED = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("REALIZED"), Types._Role, 4);
		public static final @NonNull EnumerationLiteral _Role__PREDICATED = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("PREDICATED"), Types._Role, 5);
		public static final @NonNull EnumerationLiteral _Role__SPECULATION = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("SPECULATION"), Types._Role, 6);
		public static final @NonNull EnumerationLiteral _Role__SPECULATED = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("SPECULATED"), Types._Role, 7);
		public static final @NonNull EnumerationLiteral _Role__OTHER = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.ROLE.getEEnumLiteral("OTHER"), Types._Role, 8);
		private static final @NonNull EnumerationLiteral @NonNull [] _Role = {
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

		public static final @NonNull EnumerationLiteral _Utility__DISPATCH = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.UTILITY.getEEnumLiteral("DISPATCH"), Types._Utility, 0);
		public static final @NonNull EnumerationLiteral _Utility__TRACE = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.UTILITY.getEEnumLiteral("TRACE"), Types._Utility, 1);
		public static final @NonNull EnumerationLiteral _Utility__SUCCESS = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.UTILITY.getEEnumLiteral("SUCCESS"), Types._Utility, 2);
		public static final @NonNull EnumerationLiteral _Utility__DEPENDENCY = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.UTILITY.getEEnumLiteral("DEPENDENCY"), Types._Utility, 3);
		public static final @NonNull EnumerationLiteral _Utility__COMPOSED = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.UTILITY.getEEnumLiteral("COMPOSED"), Types._Utility, 4);
		public static final @NonNull EnumerationLiteral _Utility__NON_NULL_MATCHED = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.UTILITY.getEEnumLiteral("NON_NULL_MATCHED"), Types._Utility, 5);
		public static final @NonNull EnumerationLiteral _Utility__NULLABLE_MATCHED = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.UTILITY.getEEnumLiteral("NULLABLE_MATCHED"), Types._Utility, 6);
		public static final @NonNull EnumerationLiteral _Utility__NON_NULL_CONDITIONAL = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.UTILITY.getEEnumLiteral("NON_NULL_CONDITIONAL"), Types._Utility, 7);
		public static final @NonNull EnumerationLiteral _Utility__NULLABLE_CONDITIONAL = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.UTILITY.getEEnumLiteral("NULLABLE_CONDITIONAL"), Types._Utility, 8);
		public static final @NonNull EnumerationLiteral _Utility__NOT_KNOWN = LIBRARY.createEnumerationLiteral(QVTschedulePackage.Literals.UTILITY.getEEnumLiteral("NOT_KNOWN"), Types._Utility, 9);
		private static final @NonNull EnumerationLiteral @NonNull [] _Utility = {
			_Utility__DISPATCH,
			_Utility__TRACE,
			_Utility__SUCCESS,
			_Utility__DEPENDENCY,
			_Utility__COMPOSED,
			_Utility__NON_NULL_MATCHED,
			_Utility__NULLABLE_MATCHED,
			_Utility__NON_NULL_CONDITIONAL,
			_Utility__NULLABLE_CONDITIONAL,
			_Utility__NOT_KNOWN
		};

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {
			LIBRARY.initLiterals(Types._ConnectionRole, _ConnectionRole);
			LIBRARY.initLiterals(Types._Role, _Role);
			LIBRARY.initLiterals(Types._Utility, _Utility);

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
		new QVTscheduleTables();
	}

	private QVTscheduleTables() {
		super(QVTschedulePackage.eNS_URI);
	}
}
