/*******************************************************************************
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 * using:
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreSupport$OCLinEcoreSupportClassCallingConvention
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.AbstractExecutionSupport;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.EnumerationId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;

public class QVTscheduleSupport extends AbstractExecutionSupport
{
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbase", null, QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2017/QVTschedule", null, QVTschedulePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BasicPartition = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("BasicPartition", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CastEdge = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("CastEdge", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ClassDatum = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("ClassDatum", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Cluster = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Cluster", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CollectionClassDatum = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("CollectionClassDatum", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CollectionLiteralPart = PACKid_$metamodel$.getClassId("CollectionLiteralPart", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CompleteClass = PACKid_$metamodel$.getClassId("CompleteClass", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CompositePartition = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("CompositePartition", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Connection = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Connection", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ConnectionEnd = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("ConnectionEnd", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CyclicMappingRegion = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("CyclicMappingRegion", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DispatchRegion = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("DispatchRegion", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Edge = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Edge", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_EdgeConnection = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("EdgeConnection", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_EnumerationLiteral = PACKid_$metamodel$.getClassId("EnumerationLiteral", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_KeyPartEdge = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("KeyPartEdge", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_KeyedValueNode = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("KeyedValueNode", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_LoadingPartition = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("LoadingPartition", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_LoadingRegion = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("LoadingRegion", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MapLiteralPart = PACKid_$metamodel$.getClassId("MapLiteralPart", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MappingPartition = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("MappingPartition", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MappingRegion = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("MappingRegion", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MergedPartition = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("MergedPartition", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_NavigableEdge = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("NavigableEdge", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_NavigationEdge = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("NavigationEdge", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Node = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Node", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_NodeConnection = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("NodeConnection", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Operation = PACKid_$metamodel$.getClassId("Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OperationRegion = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("OperationRegion", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Parameter = PACKid_$metamodel$.getClassId("Parameter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Partition = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Partition", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Property = PACKid_$metamodel$.getClassId("Property", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_PropertyDatum = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("PropertyDatum", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Region = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Region", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RootPartition = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("RootPartition", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RootRegion = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("RootRegion", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Rule = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Rule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RuleRegion = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("RuleRegion", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ScheduleModel = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("ScheduleModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ShadowPart = PACKid_$metamodel$.getClassId("ShadowPart", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Transformation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Transformation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TupleLiteralPart = PACKid_$metamodel$.getClassId("TupleLiteralPart", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Type = PACKid_$metamodel$.getClassId("Type", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TypedModel = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("TypedModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableDeclaration = PACKid_$metamodel$.getClassId("VariableDeclaration", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VerdictRegion = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("VerdictRegion", 0);
	public static final /*@NonInvalid*/ @NonNull DataTypeId DATAid_EInt = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EInt", 0);
	public static final /*@NonInvalid*/ @NonNull DataTypeId DATAid_EIntegerObject = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EIntegerObject", 0);
	public static final /*@NonInvalid*/ @NonNull DataTypeId DATAid_Number = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getDataTypeId("Number", 0);
	public static final /*@NonInvalid*/ @NonNull EnumerationId ENUMid_ConnectionRole = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getEnumerationId("ConnectionRole");
	public static final /*@NonInvalid*/ @NonNull EnumerationId ENUMid_Role = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getEnumerationId("Role");
	public static final /*@NonInvalid*/ @NonNull EnumerationId ENUMid_Utility = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getEnumerationId("Utility");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_BasicPartition = TypeId.BAG.getSpecializedId(CLSSid_BasicPartition, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_CastEdge = TypeId.BAG.getSpecializedId(CLSSid_CastEdge, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_ClassDatum = TypeId.BAG.getSpecializedId(CLSSid_ClassDatum, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_CollectionClassDatum = TypeId.BAG.getSpecializedId(CLSSid_CollectionClassDatum, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_Connection = TypeId.BAG.getSpecializedId(CLSSid_Connection, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_CyclicMappingRegion = TypeId.BAG.getSpecializedId(CLSSid_CyclicMappingRegion, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_DispatchRegion = TypeId.BAG.getSpecializedId(CLSSid_DispatchRegion, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_EdgeConnection = TypeId.BAG.getSpecializedId(CLSSid_EdgeConnection, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_KeyPartEdge = TypeId.BAG.getSpecializedId(CLSSid_KeyPartEdge, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_KeyedValueNode = TypeId.BAG.getSpecializedId(CLSSid_KeyedValueNode, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_MappingPartition = TypeId.BAG.getSpecializedId(CLSSid_MappingPartition, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_MappingRegion = TypeId.BAG.getSpecializedId(CLSSid_MappingRegion, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_NavigableEdge = TypeId.BAG.getSpecializedId(CLSSid_NavigableEdge, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_NavigationEdge = TypeId.BAG.getSpecializedId(CLSSid_NavigationEdge, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_Node = TypeId.BAG.getSpecializedId(CLSSid_Node, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_NodeConnection = TypeId.BAG.getSpecializedId(CLSSid_NodeConnection, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_OperationRegion = TypeId.BAG.getSpecializedId(CLSSid_OperationRegion, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_Partition = TypeId.BAG.getSpecializedId(CLSSid_Partition, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_PropertyDatum = TypeId.BAG.getSpecializedId(CLSSid_PropertyDatum, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_RootPartition = TypeId.BAG.getSpecializedId(CLSSid_RootPartition, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_VerdictRegion = TypeId.BAG.getSpecializedId(CLSSid_VerdictRegion, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_BasicPartition = TypeId.ORDERED_SET.getSpecializedId(CLSSid_BasicPartition, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_ClassDatum = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ClassDatum, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Cluster = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Cluster, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_CompleteClass = TypeId.ORDERED_SET.getSpecializedId(CLSSid_CompleteClass, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Connection = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Connection, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Edge = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Edge, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_EdgeConnection = TypeId.ORDERED_SET.getSpecializedId(CLSSid_EdgeConnection, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_MappingPartition = TypeId.ORDERED_SET.getSpecializedId(CLSSid_MappingPartition, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_MappingRegion = TypeId.ORDERED_SET.getSpecializedId(CLSSid_MappingRegion, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_MappingRegion_0 = TypeId.ORDERED_SET.getSpecializedId(CLSSid_MappingRegion, true, ValueUtil.ONE_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Node = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Node, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Node_0 = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Node, true, ValueUtil.ONE_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_NodeConnection = TypeId.ORDERED_SET.getSpecializedId(CLSSid_NodeConnection, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_OperationRegion = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OperationRegion, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_PropertyDatum = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PropertyDatum, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Region = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Region, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_RootRegion = TypeId.ORDERED_SET.getSpecializedId(CLSSid_RootRegion, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_DATAid_EInt = TypeId.ORDERED_SET.getSpecializedId(DATAid_EInt, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_BasicPartition = TypeId.SET.getSpecializedId(CLSSid_BasicPartition, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_ConnectionEnd = TypeId.SET.getSpecializedId(CLSSid_ConnectionEnd, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Edge = TypeId.SET.getSpecializedId(CLSSid_Edge, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_MappingPartition = TypeId.SET.getSpecializedId(CLSSid_MappingPartition, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_NavigableEdge = TypeId.SET.getSpecializedId(CLSSid_NavigableEdge, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Node = TypeId.SET.getSpecializedId(CLSSid_Node, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_NodeConnection = TypeId.SET.getSpecializedId(CLSSid_NodeConnection, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Partition = TypeId.SET.getSpecializedId(CLSSid_Partition, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);

	public QVTscheduleSupport(@NonNull Executor executor) {
		super(executor);
	}

}
