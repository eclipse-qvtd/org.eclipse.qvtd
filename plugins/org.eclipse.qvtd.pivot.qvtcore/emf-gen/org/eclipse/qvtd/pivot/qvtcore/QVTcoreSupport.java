/*******************************************************************************
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 * using:
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreSupport$OCLinEcoreSupportClassCallingConvention
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.AbstractExecutionSupport;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.EnumerationId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;

public class QVTcoreSupport extends AbstractExecutionSupport
{
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbase", null, QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTcore", null, QVTcorePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Area = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("Area", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Assignment = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("Assignment", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BottomPattern = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("BottomPattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BottomVariable = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("BottomVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CollectionType = PACKid_$metamodel$.getClassId("CollectionType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CoreDomain = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("CoreDomain", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CorePattern = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("CorePattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DataType = PACKid_$metamodel$.getClassId("DataType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Domain = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Domain", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_EnforcementOperation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("EnforcementOperation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_GuardPattern = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("GuardPattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_GuardVariable = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("GuardVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Mapping = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("Mapping", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OCLExpression = PACKid_$metamodel$.getClassId("OCLExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclComparable = PACKid_$metamodel$.getClassId("OclComparable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclType = PACKid_$metamodel$.getClassId("OclType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OperationCallExp = PACKid_$metamodel$.getClassId("OperationCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OppositePropertyAssignment = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("OppositePropertyAssignment", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Property = PACKid_$metamodel$.getClassId("Property", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_PropertyAssignment = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("PropertyAssignment", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RealizedVariable = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("RealizedVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Transformation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Transformation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Type = PACKid_$metamodel$.getClassId("Type", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableAssignment = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("VariableAssignment", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableDeclaration = PACKid_$metamodel$.getClassId("VariableDeclaration", 0);
	public static final /*@NonInvalid*/ @NonNull EnumerationId ENUMid_EnforcementMode = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getEnumerationId("EnforcementMode");
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_0 = ValueUtil.integerValueOf("0");
	public static final /*@NonInvalid*/ @NonNull String STR_OppositePropertyAssignment_c_c_CompatibleTypeForPartialValue_c_32 = "OppositePropertyAssignment::CompatibleTypeForPartialValue: ";
	public static final /*@NonInvalid*/ @NonNull String STR_OppositePropertyAssignment_c_c_CompatibleTypeForTotalValue_c_32 = "OppositePropertyAssignment::CompatibleTypeForTotalValue: ";
	public static final /*@NonInvalid*/ @NonNull String STR_PropertyAssignment_c_c_CompatibleTypeForPartialValue_c_32 = "PropertyAssignment::CompatibleTypeForPartialValue: ";
	public static final /*@NonInvalid*/ @NonNull String STR_PropertyAssignment_c_c_CompatibleTypeForTotalValue_c_32 = "PropertyAssignment::CompatibleTypeForTotalValue: ";
	public static final /*@NonInvalid*/ @NonNull String STR_VariableAssignment_c_c_CompatibleTypeForValue_c_32 = "VariableAssignment::CompatibleTypeForValue: ";
	public static final /*@NonInvalid*/ @NonNull String STR__32_must_32_conform_32_to_32 = " must conform to ";
	public static final /*@NonInvalid*/ @NonNull String STR__32_or_32_vice_m_versa = " or vice-versa";
	public static final /*@NonInvalid*/ @NonNull TuplePartId PARTid_ = IdManager.getTuplePartId(0, "message", TypeId.STRING);
	public static final /*@NonInvalid*/ @NonNull TuplePartId PARTid__0 = IdManager.getTuplePartId(1, "status", TypeId.BOOLEAN);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Domain = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Domain, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Assignment = TypeId.SET.getSpecializedId(CLSSid_Assignment, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_EnforcementOperation = TypeId.SET.getSpecializedId(CLSSid_EnforcementOperation, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Mapping = TypeId.SET.getSpecializedId(CLSSid_Mapping, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_RealizedVariable = TypeId.SET.getSpecializedId(CLSSid_RealizedVariable, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_VariableDeclaration = TypeId.SET.getSpecializedId(CLSSid_VariableDeclaration, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull TupleTypeId TUPLid_ = IdManager.getTupleTypeId("Tuple", PARTid_, PARTid__0);

	public QVTcoreSupport(@NonNull Executor executor) {
		super(executor);
	}

}
