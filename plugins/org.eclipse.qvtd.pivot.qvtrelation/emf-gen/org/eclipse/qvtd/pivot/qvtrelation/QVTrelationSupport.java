/*******************************************************************************
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 * using:
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreSupport$OCLinEcoreSupportClassCallingConvention
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.AbstractExecutionSupport;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;

public class QVTrelationSupport extends AbstractExecutionSupport
{
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId COL_ = TypeId.COLLECTION;
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId COL__0 = TypeId.COLLECTION;
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_ = TypeId.ORDERED_SET;
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_ = TypeId.SET;
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbase", null, QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTrelation", null, QVTrelationPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTtemplate = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTtemplate", null, QVTtemplatePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_PRIMid_String = TypeId.BAG.getSpecializedId(TypeId.STRING, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_TMPLid_ = TypeId.BAG.getSpecializedId(TypeId.T_2, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CollectionType = PACKid_$metamodel$.getClassId("CollectionType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DataType = PACKid_$metamodel$.getClassId("DataType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Domain = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Domain", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DomainPattern = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("DomainPattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Key = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("Key", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OCLExpression = PACKid_$metamodel$.getClassId("OCLExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclComparable = PACKid_$metamodel$.getClassId("OclComparable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclType = PACKid_$metamodel$.getClassId("OclType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Operation = PACKid_$metamodel$.getClassId("Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Package = PACKid_$metamodel$.getClassId("Package", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Parameter = PACKid_$metamodel$.getClassId("Parameter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Pattern = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Pattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Property = PACKid_$metamodel$.getClassId("Property", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Relation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("Relation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelationCallExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("RelationCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelationDomain = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("RelationDomain", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelationDomainAssignment = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("RelationDomainAssignment", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelationImplementation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("RelationImplementation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelationalTransformation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("RelationalTransformation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Rule = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Rule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_SharedVariable = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("SharedVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TemplateExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTtemplate.getClassId("TemplateExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Transformation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Transformation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Type = PACKid_$metamodel$.getClassId("Type", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TypedModel = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("TypedModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Variable = PACKid_$metamodel$.getClassId("Variable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableDeclaration = PACKid_$metamodel$.getClassId("VariableDeclaration", 0);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId COL_TMPLid_ = TypeId.COLLECTION.getSpecializedId(TypeId.T_2, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_0 = ValueUtil.integerValueOf("0");
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_1 = ValueUtil.integerValueOf("1");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_PRIMid_String = TypeId.ORDERED_SET.getSpecializedId(TypeId.STRING, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_TMPLid_ = TypeId.ORDERED_SET.getSpecializedId(TypeId.T_1, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_TMPLid__0 = TypeId.ORDERED_SET.getSpecializedId(TypeId.T_2, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_TMPLid__1 = TypeId.ORDERED_SET.getSpecializedId(TypeId.T_1, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_TMPLid_ = TypeId.SEQUENCE.getSpecializedId(TypeId.T_2, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_TMPLid__0 = TypeId.SEQUENCE.getSpecializedId(TypeId.T_2, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_PRIMid_OclSelf = TypeId.SET.getSpecializedId(TypeId.OCL_SELF, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_PRIMid_String = TypeId.SET.getSpecializedId(TypeId.STRING, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_TMPLid_ = TypeId.SET.getSpecializedId(TypeId.T_1, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull String STR_ = "";
	public static final /*@NonInvalid*/ @NonNull String STR_Relation_c_c_VariablesAreUnique_c_32_Multiple_32_definitions_32_of_32 = "Relation::VariablesAreUnique: Multiple definitions of ";
	public static final /*@NonInvalid*/ @NonNull String STR__32_in_32_34 = " in \"";
	public static final /*@NonInvalid*/ @NonNull String STR__34 = "\"";
	public static final /*@NonInvalid*/ @NonNull String STR__44 = ",";
	public static final /*@NonInvalid*/ @NonNull String STR__c_c = "::";
	public static final /*@NonInvalid*/ @NonNull String STR_null = "null";
	public static final /*@NonInvalid*/ @NonNull TuplePartId PARTid_ = IdManager.getTuplePartId(0, "message", TypeId.STRING);
	public static final /*@NonInvalid*/ @NonNull TuplePartId PARTid__0 = IdManager.getTuplePartId(1, "status", TypeId.BOOLEAN);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_Class = TypeId.BAG.getSpecializedId(CLSSid_Class, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_Property = TypeId.BAG.getSpecializedId(CLSSid_Property, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Domain = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Domain, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_DomainPattern = TypeId.ORDERED_SET.getSpecializedId(CLSSid_DomainPattern, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_OCLExpression = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OCLExpression, true, ValueUtil.ONE_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_OclElement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OclElement, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Pattern = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Pattern, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Relation = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Relation, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_RelationCallExp = TypeId.ORDERED_SET.getSpecializedId(CLSSid_RelationCallExp, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_TypedModel = TypeId.ORDERED_SET.getSpecializedId(CLSSid_TypedModel, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Variable = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Variable, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Package = TypeId.SEQUENCE.getSpecializedId(CLSSid_Package, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_RelationDomain = TypeId.SEQUENCE.getSpecializedId(CLSSid_RelationDomain, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Variable = TypeId.SEQUENCE.getSpecializedId(CLSSid_Variable, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Class = TypeId.SET.getSpecializedId(CLSSid_Class, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Key = TypeId.SET.getSpecializedId(CLSSid_Key, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Package = TypeId.SET.getSpecializedId(CLSSid_Package, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Pattern = TypeId.SET.getSpecializedId(CLSSid_Pattern, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Property = TypeId.SET.getSpecializedId(CLSSid_Property, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_RelationCallExp = TypeId.SET.getSpecializedId(CLSSid_RelationCallExp, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_RelationDomainAssignment = TypeId.SET.getSpecializedId(CLSSid_RelationDomainAssignment, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_RelationImplementation = TypeId.SET.getSpecializedId(CLSSid_RelationImplementation, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Rule = TypeId.SET.getSpecializedId(CLSSid_Rule, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Variable = TypeId.SET.getSpecializedId(CLSSid_Variable, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull TupleTypeId TUPLid_ = IdManager.getTupleTypeId("Tuple", PARTid_, PARTid__0);

	public QVTrelationSupport(@NonNull Executor executor) {
		super(executor);
	}

}
