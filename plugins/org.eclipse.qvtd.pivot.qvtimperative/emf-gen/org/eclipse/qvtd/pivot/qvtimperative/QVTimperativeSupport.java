/*******************************************************************************
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 * using:
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreSupport$OCLinEcoreSupportClassCallingConvention
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.AbstractExecutionSupport;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;

public class QVTimperativeSupport extends AbstractExecutionSupport
{
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId COL_ = TypeId.COLLECTION;
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId COL__0 = TypeId.UNIQUE_COLLECTION;
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_ = TypeId.ORDERED_SET;
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_ = TypeId.SET;
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbase", null, QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2016/QVTimperative", null, QVTimperativePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_PRIMid_String = TypeId.BAG.getSpecializedId(TypeId.STRING, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_TMPLid_ = TypeId.BAG.getSpecializedId(TypeId.T_2, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_AddStatement = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("AddStatement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_AppendParameterBinding = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("AppendParameterBinding", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BooleanType = PACKid_$metamodel$.getClassId("BooleanType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BufferStatement = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("BufferStatement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CallExp = PACKid_$metamodel$.getClassId("CallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CheckStatement = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("CheckStatement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CollectionType = PACKid_$metamodel$.getClassId("CollectionType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ConnectionVariable = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("ConnectionVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DataType = PACKid_$metamodel$.getClassId("DataType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DeclareStatement = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("DeclareStatement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_EntryPoint = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("EntryPoint", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_GuardParameterBinding = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("GuardParameterBinding", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ImperativeTransformation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("ImperativeTransformation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_LoopParameterBinding = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("LoopParameterBinding", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_LoopVariable = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("LoopVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Mapping = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("Mapping", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MappingCall = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("MappingCall", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MappingLoop = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("MappingLoop", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MappingParameter = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("MappingParameter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MappingParameterBinding = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("MappingParameterBinding", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MappingStatement = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("MappingStatement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_NewStatement = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("NewStatement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_NewStatementPart = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("NewStatementPart", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OCLExpression = PACKid_$metamodel$.getClassId("OCLExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclComparable = PACKid_$metamodel$.getClassId("OclComparable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclType = PACKid_$metamodel$.getClassId("OclType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Property = PACKid_$metamodel$.getClassId("Property", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Rule = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Rule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_SetStatement = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("SetStatement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_SimpleParameterBinding = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("SimpleParameterBinding", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Statement = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("Statement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Type = PACKid_$metamodel$.getClassId("Type", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TypedModel = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("TypedModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableDeclaration = PACKid_$metamodel$.getClassId("VariableDeclaration", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableExp = PACKid_$metamodel$.getClassId("VariableExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableStatement = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_QVTimperative.getClassId("VariableStatement", 0);
	public static final /*@NonInvalid*/ @NonNull DataTypeId DATAid_EIntegerObject = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EIntegerObject", 0);
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_0 = ValueUtil.integerValueOf("0");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_PRIMid_String = TypeId.ORDERED_SET.getSpecializedId(TypeId.STRING, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_TMPLid_ = TypeId.ORDERED_SET.getSpecializedId(TypeId.T_2, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_TMPLid__0 = TypeId.ORDERED_SET.getSpecializedId(TypeId.T_1, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_PRIMid_String = TypeId.SEQUENCE.getSpecializedId(TypeId.STRING, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_TMPLid_ = TypeId.SEQUENCE.getSpecializedId(TypeId.T_2, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_TMPLid__0 = TypeId.SEQUENCE.getSpecializedId(TypeId.T_2, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_PRIMid_OclSelf = TypeId.SET.getSpecializedId(TypeId.OCL_SELF, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_PRIMid_String = TypeId.SET.getSpecializedId(TypeId.STRING, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_TMPLid_ = TypeId.SET.getSpecializedId(TypeId.T_1, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_TMPLid__0 = TypeId.SET.getSpecializedId(TypeId.T_2, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_TMPLid__1 = TypeId.SET.getSpecializedId(TypeId.T_1, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull String STR_ = "";
	public static final /*@NonInvalid*/ @NonNull String STR_MappingCall_c_c_MatchingCallBindings_c_32 = "MappingCall::MatchingCallBindings: ";
	public static final /*@NonInvalid*/ @NonNull String STR_SetStatement_c_c_CompatibleClassForProperty_c_32 = "SetStatement::CompatibleClassForProperty: ";
	public static final /*@NonInvalid*/ @NonNull String STR_SetStatement_c_c_CompatibleTypeForPartialValue_c_32 = "SetStatement::CompatibleTypeForPartialValue: ";
	public static final /*@NonInvalid*/ @NonNull String STR_SetStatement_c_c_CompatibleTypeForTotalValue_c_32 = "SetStatement::CompatibleTypeForTotalValue: ";
	public static final /*@NonInvalid*/ @NonNull String STR__123 = "{";
	public static final /*@NonInvalid*/ @NonNull String STR__125 = "}";
	public static final /*@NonInvalid*/ @NonNull String STR__32 = " ";
	public static final /*@NonInvalid*/ @NonNull String STR__32_l_g_32 = " <> ";
	public static final /*@NonInvalid*/ @NonNull String STR__32_must_32_conform_32_to_32 = " must conform to ";
	public static final /*@NonInvalid*/ @NonNull String STR__59 = ";";
	public static final /*@NonInvalid*/ @NonNull TuplePartId PARTid_ = IdManager.getTuplePartId(0, "message", TypeId.STRING);
	public static final /*@NonInvalid*/ @NonNull TuplePartId PARTid__0 = IdManager.getTuplePartId(1, "status", TypeId.BOOLEAN);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_AddStatement = TypeId.BAG.getSpecializedId(CLSSid_AddStatement, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_AppendParameterBinding = TypeId.BAG.getSpecializedId(CLSSid_AppendParameterBinding, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_GuardParameterBinding = TypeId.BAG.getSpecializedId(CLSSid_GuardParameterBinding, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_LoopParameterBinding = TypeId.BAG.getSpecializedId(CLSSid_LoopParameterBinding, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_MappingCall = TypeId.BAG.getSpecializedId(CLSSid_MappingCall, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_MappingParameterBinding = TypeId.BAG.getSpecializedId(CLSSid_MappingParameterBinding, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_LoopVariable = TypeId.ORDERED_SET.getSpecializedId(CLSSid_LoopVariable, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_MappingParameterBinding = TypeId.ORDERED_SET.getSpecializedId(CLSSid_MappingParameterBinding, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_MappingStatement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_MappingStatement, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_OCLExpression = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OCLExpression, true, ValueUtil.ONE_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Statement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Statement, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_TypedModel = TypeId.ORDERED_SET.getSpecializedId(CLSSid_TypedModel, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_VariableStatement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_VariableStatement, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_MappingParameter = TypeId.SEQUENCE.getSpecializedId(CLSSid_MappingParameter, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_EntryPoint = TypeId.SET.getSpecializedId(CLSSid_EntryPoint, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_MappingParameter = TypeId.SET.getSpecializedId(CLSSid_MappingParameter, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_NewStatementPart = TypeId.SET.getSpecializedId(CLSSid_NewStatementPart, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_OCLExpression = TypeId.SET.getSpecializedId(CLSSid_OCLExpression, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_OclElement = TypeId.SET.getSpecializedId(CLSSid_OclElement, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Property = TypeId.SET.getSpecializedId(CLSSid_Property, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Rule = TypeId.SET.getSpecializedId(CLSSid_Rule, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_VariableDeclaration = TypeId.SET.getSpecializedId(CLSSid_VariableDeclaration, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_VariableExp = TypeId.SET.getSpecializedId(CLSSid_VariableExp, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull TupleTypeId TUPLid_ = IdManager.getTupleTypeId("Tuple", PARTid_, PARTid__0);

	public QVTimperativeSupport(@NonNull Executor executor) {
		super(executor);
	}

}
