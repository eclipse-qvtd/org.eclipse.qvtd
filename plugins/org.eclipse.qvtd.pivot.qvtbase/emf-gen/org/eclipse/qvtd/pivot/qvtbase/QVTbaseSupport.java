/*******************************************************************************
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 * using:
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreSupport$OCLinEcoreSupportClassCallingConvention
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.AbstractExecutionSupport;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.EnumerationId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;

public class QVTbaseSupport extends AbstractExecutionSupport
{
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId COL_ = TypeId.COLLECTION;
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_ = TypeId.ORDERED_SET;
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_ = TypeId.SET;
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbase", null, QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Annotation = PACKid_$metamodel$.getClassId("Annotation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BooleanType = PACKid_$metamodel$.getClassId("BooleanType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CompoundTargetElement = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("CompoundTargetElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Domain = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Domain", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Function = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Function", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_FunctionParameter = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("FunctionParameter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OCLExpression = PACKid_$metamodel$.getClassId("OCLExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclComparable = PACKid_$metamodel$.getClassId("OclComparable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclType = PACKid_$metamodel$.getClassId("OclType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Package = PACKid_$metamodel$.getClassId("Package", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Parameter = PACKid_$metamodel$.getClassId("Parameter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Pattern = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Pattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Predicate = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Predicate", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Rule = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Rule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_SimpleTargetElement = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("SimpleTargetElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Target = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Target", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TargetElement = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("TargetElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Transformation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Transformation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Type = PACKid_$metamodel$.getClassId("Type", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TypedModel = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("TypedModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Variable = PACKid_$metamodel$.getClassId("Variable", 0);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId COL_TMPLid_ = TypeId.COLLECTION.getSpecializedId(TypeId.T_2, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull EnumerationId ENUMid_TargetElementKind = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getEnumerationId("TargetElementKind");
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_0 = ValueUtil.integerValueOf("0");
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_1 = ValueUtil.integerValueOf("1");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_PRIMid_String = TypeId.SEQUENCE.getSpecializedId(TypeId.STRING, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_TMPLid_ = TypeId.SEQUENCE.getSpecializedId(TypeId.T_2, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_PRIMid_OclSelf = TypeId.SET.getSpecializedId(TypeId.OCL_SELF, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_Domain = TypeId.BAG.getSpecializedId(CLSSid_Domain, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_SimpleTargetElement = TypeId.BAG.getSpecializedId(CLSSid_SimpleTargetElement, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_TypedModel = TypeId.BAG.getSpecializedId(CLSSid_TypedModel, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Domain = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Domain, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Parameter = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Parameter, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Rule = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Rule, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_SimpleTargetElement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_SimpleTargetElement, true, ValueUtil.integerValueOf(2), ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_TypedModel = TypeId.ORDERED_SET.getSpecializedId(CLSSid_TypedModel, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Package = TypeId.SEQUENCE.getSpecializedId(CLSSid_Package, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Annotation = TypeId.SET.getSpecializedId(CLSSid_Annotation, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Package = TypeId.SET.getSpecializedId(CLSSid_Package, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Predicate = TypeId.SET.getSpecializedId(CLSSid_Predicate, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Rule = TypeId.SET.getSpecializedId(CLSSid_Rule, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Rule_0 = TypeId.SET.getSpecializedId(CLSSid_Rule, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Target = TypeId.SET.getSpecializedId(CLSSid_Target, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_TargetElement = TypeId.SET.getSpecializedId(CLSSid_TargetElement, true, ValueUtil.integerValueOf(2), ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Transformation = TypeId.SET.getSpecializedId(CLSSid_Transformation, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Transformation_0 = TypeId.SET.getSpecializedId(CLSSid_Transformation, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_TypedModel = TypeId.SET.getSpecializedId(CLSSid_TypedModel, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Variable = TypeId.SET.getSpecializedId(CLSSid_Variable, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);

	public QVTbaseSupport(@NonNull Executor executor) {
		super(executor);
	}

}
