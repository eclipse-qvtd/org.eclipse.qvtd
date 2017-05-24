/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.qvtd.atl.atl2qvtr;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.m2m.atl.common.ATL.ATLPackage;
import org.eclipse.m2m.atl.common.ATL.Helper;
import org.eclipse.m2m.atl.common.ATL.InPattern;
import org.eclipse.m2m.atl.common.ATL.MatchedRule;
import org.eclipse.m2m.atl.common.ATL.Module;
import org.eclipse.m2m.atl.common.OCL.OCLPackage;
import org.eclipse.m2m.atl.common.OCL.OclExpression;
import org.eclipse.m2m.atl.common.OCL.OclFeature;
import org.eclipse.m2m.atl.common.OCL.OclFeatureDefinition;
import org.eclipse.m2m.atl.common.OCL.OclModel;
import org.eclipse.m2m.atl.common.OCL.Operation;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.UnboxedCompositionProperty;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrFactory;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TMatchedRule2Relation;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclExpression2OCLExpression;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_create;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOperationCallExp2OperationCallExp;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationFactory;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.InvalidEvaluationException;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;

/**
 * The ATL2QVTr transformation:
 * <p>
 * Construct with an evaluator
 * <br>
 * Populate each input model with {@link addRootObjects(String,List)}
 * <br>
 * {@link run()}
 * <br>
 * Extract each output model with {@link getRootObjects(String)}
 */
@SuppressWarnings("unused")
public class ATL2QVTr extends AbstractTransformer
{
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL = IdManager.getNsURIPackageId("http://www.eclipse.org/gmt/2005/ATL", null, ATLPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL = IdManager.getNsURIPackageId("http://www.eclipse.org/gmt/2005/OCL", null, OCLPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbase", null, QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTrelation", null, QVTrelationPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd-example/org/eclipse/qvtd/atl/atl2qvtr/ATL2QVTr", "PATL2QVTr", PATL2QVTrPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Function = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Function", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Helper = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("Helper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_InPattern = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("InPattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MatchedRule = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("MatchedRule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Module = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("Module", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclExpression = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("OclExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclFeature = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("OclFeature", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclFeatureDefinition = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("OclFeatureDefinition", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclModel = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("OclModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Operation = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OperationCallExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("OperationCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OperationCallExp_0 = PACKid_$metamodel$.getClassId("OperationCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Package = PACKid_$metamodel$.getClassId("Package", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Pattern = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Pattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Predicate = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Predicate", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Relation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("Relation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelationDomain = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("RelationDomain", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelationModel = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("RelationModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelationalTransformation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("RelationalTransformation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_THelper2Function = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("THelper2Function", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TInPattern2RelationDomain = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TInPattern2RelationDomain", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TInPattern2RelationDomain_guard = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TInPattern2RelationDomain_guard", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TMatchedRule2Relation = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TMatchedRule2Relation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TModel2RelationalTransformation = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TModel2RelationalTransformation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TOclExpression2OCLExpression = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TOclExpression2OCLExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TOclModel2ModelParameter_create = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TOclModel2ModelParameter_create", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TOclModel2ModelParameter_from = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TOclModel2ModelParameter_from", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TOperationCallExp2OperationCallExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TOperationCallExp2OperationCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TypedModel = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("TypedModel", 0);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_OclModel = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OclModel);
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_aPattern_0 = CLSSid_TInPattern2RelationDomain.getPropertyId("aPattern");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_aRule = CLSSid_TInPattern2RelationDomain.getPropertyId("aRule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_inModels = CLSSid_Module.getPropertyId("inModels");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_matchedRule = CLSSid_TMatchedRule2Relation.getPropertyId("matchedRule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_module = CLSSid_TModel2RelationalTransformation.getPropertyId("module");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_outModels = CLSSid_Module.getPropertyId("outModels");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_OclModel = TypeId.SET.getSpecializedId(CLSSid_OclModel);

	/*
	 * Property-source to Property-target unnavigable navigation caches
	 */
	protected final @NonNull Map<InPattern,TInPattern2RelationDomain> OPPOSITE_OF_TInPattern2RelationDomain_aPattern = new HashMap<InPattern,TInPattern2RelationDomain>();
	protected final @NonNull Map<MatchedRule,TInPattern2RelationDomain> OPPOSITE_OF_TInPattern2RelationDomain_aRule = new HashMap<MatchedRule,TInPattern2RelationDomain>();
	protected final @NonNull Map<MatchedRule,TMatchedRule2Relation> OPPOSITE_OF_TMatchedRule2Relation_matchedRule = new HashMap<MatchedRule,TMatchedRule2Relation>();
	protected final @NonNull Map<Module,TModel2RelationalTransformation> OPPOSITE_OF_TModel2RelationalTransformation_module = new HashMap<Module,TModel2RelationalTransformation>();

	/*
	 * Array of the source PropertyIds of each Property for which unnavigable opposite property navigation may occur.
	 */
	private static final @NonNull PropertyId @NonNull [] oppositeIndex2propertyId = new @NonNull PropertyId[]{
		PROPid_module,		// 0 => module
		PROPid_matchedRule,		// 1 => matchedRule
		PROPid_aPattern_0,		// 2 => aPattern
		PROPid_aRule		// 3 => aRule
	};

	/*
	 * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
	 */
	private static final @NonNull ClassId @NonNull [] classIndex2classId = new @NonNull ClassId[]{
		CLSSid_Helper,                        // 0 => Helper
		CLSSid_InPattern,                     // 1 => InPattern
		CLSSid_MatchedRule,                   // 2 => MatchedRule
		CLSSid_Module,                        // 3 => Module
		CLSSid_OclModel,                      // 4 => OclModel
		CLSSid_OperationCallExp               // 5 => OperationCallExp
	};

	/*
	 * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
	 * may contribute results to an allInstances() invocation.
	 * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
	 * instance of the derived classId contributes to derived and inherited ClassIndexes.
	 */
	private final static int @NonNull [] @NonNull [] classIndex2allClassIndexes = new int @NonNull [] @NonNull [] {
		{0},                          // 0 : Helper -> {Helper}
		{1},                          // 1 : InPattern -> {InPattern}
		{2},                          // 2 : MatchedRule -> {MatchedRule}
		{3},                          // 3 : Module -> {Module}
		{4},                          // 4 : OclModel -> {OclModel}
		{5}                           // 5 : OperationCallExp -> {OperationCallExp}
	};


	public ATL2QVTr(final @NonNull TransformationExecutor executor) {
		super(executor, new @NonNull String[] {"middle", "atl", "qvtr", "$primitive$"}, oppositeIndex2propertyId, classIndex2classId, classIndex2allClassIndexes);
	}

	@Override
	public boolean run() {
		final @NonNull Connection ji_Helper = models[1/*atl*/].getConnection(0/*ATL::Helper*/);
		final @NonNull Connection ji_InPattern = models[1/*atl*/].getConnection(1/*ATL::InPattern*/);
		final @NonNull Connection ji_MatchedRule = models[1/*atl*/].getConnection(2/*ATL::MatchedRule*/);
		final @NonNull Connection ji_Module = models[1/*atl*/].getConnection(3/*ATL::Module*/);
		final @NonNull Connection ji_OclModel = models[1/*atl*/].getConnection(4/*OCL::OclModel*/);
		final @NonNull Connection ji_OperationCallExp = models[1/*atl*/].getConnection(5/*OCL::OperationCallExp*/);
		return MAP___root__(ji_Helper, ji_InPattern, ji_MatchedRule, ji_Module, ji_OclModel, ji_OperationCallExp) && invocationManager.flush();
	}

	/**
	 *
	 * map __root__ in ATL2QVTr {
	 *
	 *   append ji_Helper  : ATL::Helper[1];
	 * append ji_InPattern  : ATL::InPattern[1];
	 * append ji_MatchedRule  : ATL::MatchedRule[1];
	 * append ji_Module  : ATL::Module[1];
	 * append ji_OclModel  : OCL::OclModel[1];
	 * append ji_OperationCallExp  : OCL::OperationCallExp[1];
	 * ::jm_THelper2Function : PATL2QVTr::THelper2Function[1]::jm_TInPattern2RelationDomain : PATL2QVTr::TInPattern2RelationDomain[1]::jm_TInPattern2RelationDomain__guard : PATL2QVTr::TInPattern2RelationDomain_guard[1]::jm_TMatchedRule2Relation : PATL2QVTr::TMatchedRule2Relation[1]::jm_TOclModel2ModelParameter__create : PATL2QVTr::TOclModel2ModelParameter_create[1]::jm_TOclModel2ModelParameter__from : PATL2QVTr::TOclModel2ModelParameter_from[1]::jo_OperationCallExp : OperationCallExp[1]::jo_Relation : qvtrelation::Relation[1]install m_TModel2RelationalTransformation__3__4_module_relTx_r0 {
	 * module consumes append ji_Module  : ATL::Module[1];
	 * ;
	 * }
	 *   install m_TOperationCallExp2OperationCallExp_aExpression_rEx_r0 {
	 * aExpression consumes append ji_OperationCallExp  : OCL::OperationCallExp[1];
	 * ;
	 * jo_OperationCallExp appendsTo jo_OperationCallExp;
	 * }
	 *   install m_TInPattern2RelationDomain__guard_aExpression_aPatt_r0 {
	 * aPattern consumes append ji_InPattern  : ATL::InPattern[1];
	 * ;
	 * jm_TInPattern2RelationDomain__guard appendsTo jm_TInPattern2RelationDomain__guard;
	 * }
	 *   install m_THelper2Function_aDef_aFeat_aModule_helper_opName_p0 {
	 * helper consumes append ji_Helper  : ATL::Helper[1];
	 * ;
	 * jm_THelper2Function appendsTo jm_THelper2Function;
	 * }
	 *   install m_THelper2Function_function_relTx_lc {
	 * trace consumes ::jm_THelper2Function : PATL2QVTr::THelper2Function[1];
	 * }
	 *   install m_TInPattern2RelationDomain_aPattern_aRule_p0 {
	 * aPattern consumes append ji_InPattern  : ATL::InPattern[1];
	 * ;
	 * jm_TInPattern2RelationDomain appendsTo jm_TInPattern2RelationDomain;
	 * }
	 *   install m_TMatchedRule2Relation_aModule_matchedRule_ruleName_p0 {
	 * jm_TMatchedRule2Relation appendsTo jm_TMatchedRule2Relation;
	 * matchedRule consumes append ji_MatchedRule  : ATL::MatchedRule[1];
	 * ;
	 * }
	 *   install m_TInPattern2RelationDomain_rDomain_where_InPattern2_p1 {
	 * jm_TInPattern2RelationDomain__guard appendsTo jm_TInPattern2RelationDomain__guard;
	 * trace consumes ::jm_TInPattern2RelationDomain : PATL2QVTr::TInPattern2RelationDomain[1];
	 * }
	 *   install m_TInPattern2RelationDomain__guard_rExpression_p1 {
	 * rExpression consumes ::jo_OperationCallExp : OperationCallExp[1];
	 * trace consumes ::jm_TInPattern2RelationDomain__guard : PATL2QVTr::TInPattern2RelationDomain_guard[1];
	 * }
	 *   install m_TInPattern2RelationDomain__aPattern_p3 {
	 * aPattern consumes append ji_InPattern  : ATL::InPattern[1];
	 * ;
	 * }
	 *   install m_TMatchedRule2Relation_rRule_p1 {
	 * jo_Relation appendsTo jo_Relation;
	 * trace consumes ::jm_TMatchedRule2Relation : PATL2QVTr::TMatchedRule2Relation[1];
	 * }
	 *   install m_TInPattern2RelationDomain_rRule_p2 {
	 * aRule consumes append ji_MatchedRule  : ATL::MatchedRule[1];
	 * ;
	 * }
	 *   install m_TMatchedRule2Relation_relTx_p2 {
	 * trace consumes ::jm_TMatchedRule2Relation : PATL2QVTr::TMatchedRule2Relation[1];
	 * }
	 *   install m_TInPattern2RelationDomain__guard_rRule_p2 {
	 * rRule consumes ::jo_Relation : qvtrelation::Relation[1];
	 * trace consumes ::jm_TInPattern2RelationDomain__guard : PATL2QVTr::TInPattern2RelationDomain_guard[1];
	 * }
	 *   install m_TOclModel2ModelParameter__create_aModule_oclModel__p0 {
	 * jm_TOclModel2ModelParameter__create appendsTo jm_TOclModel2ModelParameter__create;
	 * oclModel consumes append ji_OclModel  : OCL::OclModel[1];
	 * ;
	 * }
	 *   install m_TOclModel2ModelParameter__create_relTM_p1 {
	 * trace consumes ::jm_TOclModel2ModelParameter__create : PATL2QVTr::TOclModel2ModelParameter_create[1];
	 * }
	 *   install m_TOclModel2ModelParameter__from_aModule_oclModel_tm_p0 {
	 * jm_TOclModel2ModelParameter__from appendsTo jm_TOclModel2ModelParameter__from;
	 * oclModel consumes append ji_OclModel  : OCL::OclModel[1];
	 * ;
	 * }
	 *   install m_TOclModel2ModelParameter__from_relTM_p1 {
	 * trace consumes ::jm_TOclModel2ModelParameter__from : PATL2QVTr::TOclModel2ModelParameter_from[1];
	 * }
	 *   install m_TOclModel2ModelParameter__create_relTx_p2 {
	 * trace consumes ::jm_TOclModel2ModelParameter__create : PATL2QVTr::TOclModel2ModelParameter_create[1];
	 * }
	 *   install m_TOclModel2ModelParameter__from_relTx_p2 {
	 * trace consumes ::jm_TOclModel2ModelParameter__from : PATL2QVTr::TOclModel2ModelParameter_from[1];
	 * }
	 */
	protected boolean MAP___root__(final @NonNull Connection ji_Helper, final @NonNull Connection ji_InPattern, final @NonNull Connection ji_MatchedRule, final @NonNull Connection ji_Module, final @NonNull Connection ji_OclModel, final @NonNull Connection ji_OperationCallExp)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP___root__" + ", " + ji_Helper + ", " + ji_InPattern + ", " + ji_MatchedRule + ", " + ji_Module + ", " + ji_OclModel + ", " + ji_OperationCallExp);
		}
		// connection variables
		final @NonNull Connection jm_THelper2Function_1 = createConnection("jm_THelper2Function", CLSSid_THelper2Function, false);
		final @NonNull Connection jm_TInPattern2RelationDomain_1 = createConnection("jm_TInPattern2RelationDomain", CLSSid_TInPattern2RelationDomain, false);
		final @NonNull Connection jm_TInPattern2RelationDomain__guard_3 = createConnection("jm_TInPattern2RelationDomain__guard", CLSSid_TInPattern2RelationDomain_guard, false);
		final @NonNull Connection jm_TMatchedRule2Relation_1 = createConnection("jm_TMatchedRule2Relation", CLSSid_TMatchedRule2Relation, false);
		final @NonNull Connection jm_TOclModel2ModelParameter__create_1 = createConnection("jm_TOclModel2ModelParameter__create", CLSSid_TOclModel2ModelParameter_create, false);
		final @NonNull Connection jm_TOclModel2ModelParameter__from_1 = createConnection("jm_TOclModel2ModelParameter__from", CLSSid_TOclModel2ModelParameter_from, false);
		final @NonNull Connection jo_OperationCallExp_1 = createConnection("jo_OperationCallExp", CLSSid_OperationCallExp_0, false);
		final @NonNull Connection jo_Relation_1 = createConnection("jo_Relation", CLSSid_Relation, false);
		// mapping statements
		for (@NonNull Module module_0 : ji_Module.typedIterable(Module.class)) {
			MAP_m_TModel2RelationalTransformation__3__4_module_relTx_r0(module_0);
		}
		for (org.eclipse.m2m.atl.common.OCL.@NonNull OperationCallExp aExpression_0 : ji_OperationCallExp.typedIterable(org.eclipse.m2m.atl.common.OCL.OperationCallExp.class)) {
			MAP_m_TOperationCallExp2OperationCallExp_aExpression_rEx_r0(aExpression_0, jo_OperationCallExp_1);
		}
		for (@NonNull InPattern aPattern_2 : ji_InPattern.typedIterable(InPattern.class)) {
			MAP_m_TInPattern2RelationDomain__guard_aExpression_aPatt_r0(aPattern_2, jm_TInPattern2RelationDomain__guard_3);
		}
		for (@NonNull Helper helper_0 : ji_Helper.typedIterable(Helper.class)) {
			MAP_m_THelper2Function_aDef_aFeat_aModule_helper_opName_p0(helper_0, jm_THelper2Function_1);
		}
		for (@NonNull THelper2Function trace_9 : jm_THelper2Function_1.typedIterable(THelper2Function.class)) {
			MAP_m_THelper2Function_function_relTx_lc(trace_9);
		}
		for (@NonNull InPattern aPattern_3 : ji_InPattern.typedIterable(InPattern.class)) {
			MAP_m_TInPattern2RelationDomain_aPattern_aRule_p0(aPattern_3, jm_TInPattern2RelationDomain_1);
		}
		for (@NonNull MatchedRule matchedRule_0 : ji_MatchedRule.typedIterable(MatchedRule.class)) {
			MAP_m_TMatchedRule2Relation_aModule_matchedRule_ruleName_p0(jm_TMatchedRule2Relation_1, matchedRule_0);
		}
		for (@NonNull TInPattern2RelationDomain trace_10 : jm_TInPattern2RelationDomain_1.typedIterable(TInPattern2RelationDomain.class)) {
			MAP_m_TInPattern2RelationDomain_rDomain_where_InPattern2_p1(jm_TInPattern2RelationDomain__guard_3, trace_10);
		}
		for (org.eclipse.ocl.pivot.@NonNull OperationCallExp rExpression_0 : jo_OperationCallExp_1.typedIterable(org.eclipse.ocl.pivot.OperationCallExp.class)) {
			for (@NonNull TInPattern2RelationDomain_guard trace_11 : jm_TInPattern2RelationDomain__guard_3.typedIterable(TInPattern2RelationDomain_guard.class)) {
				MAP_m_TInPattern2RelationDomain__guard_rExpression_p1(rExpression_0, trace_11);
			}
		}
		for (@NonNull InPattern aPattern_4 : ji_InPattern.typedIterable(InPattern.class)) {
			MAP_m_TInPattern2RelationDomain__aPattern_p3(aPattern_4);
		}
		for (@NonNull TMatchedRule2Relation trace_12 : jm_TMatchedRule2Relation_1.typedIterable(TMatchedRule2Relation.class)) {
			MAP_m_TMatchedRule2Relation_rRule_p1(jo_Relation_1, trace_12);
		}
		for (@NonNull MatchedRule aRule_0 : ji_MatchedRule.typedIterable(MatchedRule.class)) {
			MAP_m_TInPattern2RelationDomain_rRule_p2(aRule_0);
		}
		for (@NonNull TMatchedRule2Relation trace_13 : jm_TMatchedRule2Relation_1.typedIterable(TMatchedRule2Relation.class)) {
			MAP_m_TMatchedRule2Relation_relTx_p2(trace_13);
		}
		for (@NonNull Relation rRule_0 : jo_Relation_1.typedIterable(Relation.class)) {
			for (@NonNull TInPattern2RelationDomain_guard trace_14 : jm_TInPattern2RelationDomain__guard_3.typedIterable(TInPattern2RelationDomain_guard.class)) {
				MAP_m_TInPattern2RelationDomain__guard_rRule_p2(rRule_0, trace_14);
			}
		}
		for (@NonNull OclModel oclModel_1 : ji_OclModel.typedIterable(OclModel.class)) {
			MAP_m_TOclModel2ModelParameter__create_aModule_oclModel__p0(jm_TOclModel2ModelParameter__create_1, oclModel_1);
		}
		for (@NonNull TOclModel2ModelParameter_create trace_15 : jm_TOclModel2ModelParameter__create_1.typedIterable(TOclModel2ModelParameter_create.class)) {
			MAP_m_TOclModel2ModelParameter__create_relTM_p1(trace_15);
		}
		for (@NonNull OclModel oclModel_2 : ji_OclModel.typedIterable(OclModel.class)) {
			MAP_m_TOclModel2ModelParameter__from_aModule_oclModel_tm_p0(jm_TOclModel2ModelParameter__from_1, oclModel_2);
		}
		for (@NonNull TOclModel2ModelParameter_from trace_16 : jm_TOclModel2ModelParameter__from_1.typedIterable(TOclModel2ModelParameter_from.class)) {
			MAP_m_TOclModel2ModelParameter__from_relTM_p1(trace_16);
		}
		for (@NonNull TOclModel2ModelParameter_create trace_17 : jm_TOclModel2ModelParameter__create_1.typedIterable(TOclModel2ModelParameter_create.class)) {
			MAP_m_TOclModel2ModelParameter__create_relTx_p2(trace_17);
		}
		for (@NonNull TOclModel2ModelParameter_from trace_18 : jm_TOclModel2ModelParameter__from_1.typedIterable(TOclModel2ModelParameter_from.class)) {
			MAP_m_TOclModel2ModelParameter__from_relTx_p2(trace_18);
		}
		final /*@Thrown*/ @Nullable Boolean __root__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((__root__ ? "done "  : "fail ") + "MAP___root__");
		}
		return __root__;
	}

	/**
	 *
	 * map m_TModel2RelationalTransformation__3__4_module_relTx_r0 in ATL2QVTr {
	 * guard:atl module : ATL::Module[1];
	 * var txName : String[1] := module.name;
	 * contained new:qvtr _3 : Package[1];
	 * new:qvtr _4 : qvtrelation::RelationModel[1];
	 * contained new:qvtr relTx : qvtrelation::RelationalTransformation[1];
	 * new:middle trace : PATL2QVTr::TModel2RelationalTransformation[1];
	 * set _3.name := null;
	 * set _4.name := null;
	 * set trace._3 := _3;
	 * set trace._4 := _4;
	 * set trace.module := module;
	 * set trace.relTx := relTx;
	 * set _3.Model := _4;
	 * set relTx.owningPackage := _3;
	 * set relTx.name := txName;
	 * set trace.txName := txName;
	 *
	 */
	protected boolean MAP_m_TModel2RelationalTransformation__3__4_module_relTx_r0(final /*@NonInvalid*/ @NonNull Module module)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TModel2RelationalTransformation__3__4_module_relTx_r0" + ", " + module);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String name = module.getName();
		// creations
		final @SuppressWarnings("null")org.eclipse.ocl.pivot.@NonNull Package _3 = PivotFactory.eINSTANCE.createPackage();
		models[2/*qvtr*/].add(_3, true);
		final @NonNull RelationModel _4 = QVTrelationFactory.eINSTANCE.createRelationModel();
		models[2/*qvtr*/].add(_4, false);
		final @NonNull RelationalTransformation relTx = QVTrelationFactory.eINSTANCE.createRelationalTransformation();
		models[2/*qvtr*/].add(relTx, true);
		final @SuppressWarnings("null")@NonNull TModel2RelationalTransformation trace_9 = PATL2QVTrFactory.eINSTANCE.createTModel2RelationalTransformation();
		models[0/*middle*/].add(trace_9, false);
		// mapping statements
		_3.setName(null);
		_4.setName(null);
		trace_9.set_3(_3);
		trace_9.set_4(_4);
		OPPOSITE_OF_TModel2RelationalTransformation_module.put(module, trace_9);
		trace_9.setModule(module);
		trace_9.setRelTx(relTx);
		_4.getOwnedPackages().add(_3);
		relTx.setOwningPackage(_3);
		relTx.setName(name);
		trace_9.setTxName(name);
		final /*@Thrown*/ @Nullable Boolean m_TModel2RelationalTransformation__3__4_module_relTx_r0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((m_TModel2RelationalTransformation__3__4_module_relTx_r0 ? "done "  : "fail ") + "MAP_m_TModel2RelationalTransformation__3__4_module_relTx_r0");
		}
		return m_TModel2RelationalTransformation__3__4_module_relTx_r0;
	}

	/**
	 *
	 * map m_TOperationCallExp2OperationCallExp_aExpression_rEx_r0 in ATL2QVTr {
	 * guard:atl aExpression : OCL::OperationCallExp[1];
	 * append jo_OperationCallExp  : OperationCallExp[1];
	 * new:qvtr rExpression : OperationCallExp[1];
	 * new:middle trace : PATL2QVTr::TOperationCallExp2OperationCallExp[1];
	 * set trace.aExpression := aExpression;
	 * set trace.rExpression := rExpression;
	 * add jo_OperationCallExp += rExpression;
	 *
	 */
	protected boolean MAP_m_TOperationCallExp2OperationCallExp_aExpression_rEx_r0(final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull OperationCallExp aExpression, final org.eclipse.qvtd.runtime.evaluation.@org.eclipse.jdt.annotation.NonNull Connection jo_OperationCallExp)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TOperationCallExp2OperationCallExp_aExpression_rEx_r0" + ", " + aExpression + ", " + jo_OperationCallExp);
		}
		// creations
		final org.eclipse.ocl.pivot.@NonNull OperationCallExp rExpression_0 = PivotFactory.eINSTANCE.createOperationCallExp();
		models[2/*qvtr*/].add(rExpression_0, false);
		final @SuppressWarnings("null")@NonNull TOperationCallExp2OperationCallExp trace_9 = PATL2QVTrFactory.eINSTANCE.createTOperationCallExp2OperationCallExp();
		models[0/*middle*/].add(trace_9, false);
		// mapping statements
		trace_9.setAExpression(aExpression);
		trace_9.setRExpression(rExpression_0);
		jo_OperationCallExp.appendElement(rExpression_0);
		final /*@Thrown*/ @Nullable Boolean m_TOperationCallExp2OperationCallExp_aExpression_rEx_r0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((m_TOperationCallExp2OperationCallExp_aExpression_rEx_r0 ? "done "  : "fail ") + "MAP_m_TOperationCallExp2OperationCallExp_aExpression_rEx_r0");
		}
		return m_TOperationCallExp2OperationCallExp_aExpression_rEx_r0;
	}

	/**
	 *
	 * map m_TInPattern2RelationDomain__guard_aExpression_aPatt_r0 in ATL2QVTr {
	 * guard:atl aPattern : ATL::InPattern[1];
	 * append jm_TInPattern2RelationDomain__guard  : PATL2QVTr::TInPattern2RelationDomain_guard[1];
	 * check var aExpression : OCL::OperationCallExp[1] := aPattern.filter;
	 * new:qvtr p : qvtbase::Predicate[1];
	 * new:middle trace : PATL2QVTr::TInPattern2RelationDomain_guard[1];
	 * contained new:qvtr w : qvtbase::Pattern[1];
	 * new:middle when_TOclExpression2OCLExpression : PATL2QVTr::TOclExpression2OCLExpression[1];
	 * set trace.aPattern := aPattern;
	 * set trace.p := p;
	 * set trace.w := w;
	 * set trace.when_OclExpression2OCLExpression := when_TOclExpression2OCLExpression;
	 * set w.predicate := p;
	 * set trace.aExpression := aExpression;
	 * set when_TOclExpression2OCLExpression.aExpression := aExpression;
	 * add jm_TInPattern2RelationDomain__guard += trace;
	 *
	 */
	protected boolean MAP_m_TInPattern2RelationDomain__guard_aExpression_aPatt_r0(final /*@NonInvalid*/ @NonNull InPattern aPattern, final @NonNull Connection jm_TInPattern2RelationDomain__guard)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TInPattern2RelationDomain__guard_aExpression_aPatt_r0" + ", " + aPattern + ", " + jm_TInPattern2RelationDomain__guard);
		}
		final /*@NonInvalid*/ @Nullable OclExpression temp1_aExpression = aPattern.getFilter();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_aExpression instanceof org.eclipse.m2m.atl.common.OCL.OperationCallExp;
		/*@Thrown*/ @Nullable Boolean symbol_11;
		if (symbol_0) {
			final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@Nullable OperationCallExp symbol_1 = (org.eclipse.m2m.atl.common.OCL.OperationCallExp)temp1_aExpression;
			if (symbol_1 == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			// creations
			final @NonNull Predicate p = QVTbaseFactory.eINSTANCE.createPredicate();
			models[2/*qvtr*/].add(p, false);
			final @SuppressWarnings("null")@NonNull TInPattern2RelationDomain_guard trace_9 = PATL2QVTrFactory.eINSTANCE.createTInPattern2RelationDomain_guard();
			models[0/*middle*/].add(trace_9, false);
			final @NonNull Pattern w = QVTbaseFactory.eINSTANCE.createPattern();
			models[2/*qvtr*/].add(w, true);
			final @SuppressWarnings("null")@NonNull TOclExpression2OCLExpression when_TOclExpression2OCLExpression = PATL2QVTrFactory.eINSTANCE.createTOclExpression2OCLExpression();
			models[0/*middle*/].add(when_TOclExpression2OCLExpression, false);
			// mapping statements
			trace_9.setAPattern(aPattern);
			trace_9.setP(p);
			trace_9.setW(w);
			trace_9.setWhen_OclExpression2OCLExpression(when_TOclExpression2OCLExpression);
			w.getPredicate().add(p);
			trace_9.setAExpression(symbol_1);
			when_TOclExpression2OCLExpression.setAExpression(symbol_1);
			jm_TInPattern2RelationDomain__guard.appendElement(trace_9);
			final /*@Thrown*/ @Nullable Boolean m_TInPattern2RelationDomain__guard_aExpression_aPatt_r0 = ValueUtil.TRUE_VALUE;
			symbol_11 = m_TInPattern2RelationDomain__guard_aExpression_aPatt_r0;
		}
		else {
			symbol_11 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_11 ? "done "  : "fail ") + "MAP_m_TInPattern2RelationDomain__guard_aExpression_aPatt_r0");
		}
		return symbol_11;
	}

	/**
	 *
	 * map m_THelper2Function_aDef_aFeat_aModule_helper_opName_p0 in ATL2QVTr {
	 * guard:atl helper : ATL::Helper[1];
	 * append jm_THelper2Function  : PATL2QVTr::THelper2Function[1];
	 * var aDef : OCL::OclFeatureDefinition[1] := helper.definition;
	 * var aModule : ATL::Module[1] := helper.module;
	 * var aFeat : OCL::OclFeature[1] := aDef.feature;
	 * check var aFeat1 : OCL::Operation[1] := aFeat;
	 * var opName : String[1] := aFeat1.name;
	 * new:middle trace : PATL2QVTr::THelper2Function[1];
	 * set trace.helper := helper;
	 * set trace.aDef := aDef;
	 * set trace.aModule := aModule;
	 * set trace.aFeat := aFeat1;
	 * set trace.opName := opName;
	 * add jm_THelper2Function += trace;
	 *
	 */
	protected boolean MAP_m_THelper2Function_aDef_aFeat_aModule_helper_opName_p0(final /*@NonInvalid*/ @NonNull Helper helper, final @NonNull Connection jm_THelper2Function)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_THelper2Function_aDef_aFeat_aModule_helper_opName_p0" + ", " + helper + ", " + jm_THelper2Function);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = helper.getDefinition();
		final /*@NonInvalid*/ @Nullable Module module_0 = helper.getModule();
		final /*@NonInvalid*/ boolean symbol_0 = module_0 != null;
		/*@Thrown*/ @Nullable Boolean raw_aModule;
		if (symbol_0) {
			if (module_0 == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclFeature feature = definition.getFeature();
			final /*@NonInvalid*/ boolean symbol_1 = feature instanceof Operation;
			/*@Thrown*/ @Nullable Boolean symbol_10;
			if (symbol_1) {
				final /*@NonInvalid*/ @NonNull Operation symbol_2 = (Operation)feature;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String name = symbol_2.getName();
				// creations
				final @SuppressWarnings("null")@NonNull THelper2Function trace_9 = PATL2QVTrFactory.eINSTANCE.createTHelper2Function();
				models[0/*middle*/].add(trace_9, false);
				// mapping statements
				trace_9.setHelper(helper);
				trace_9.setADef(definition);
				trace_9.setAModule(module_0);
				trace_9.setAFeat(symbol_2);
				trace_9.setOpName(name);
				jm_THelper2Function.appendElement(trace_9);
				final /*@Thrown*/ @Nullable Boolean m_THelper2Function_aDef_aFeat_aModule_helper_opName_p0 = ValueUtil.TRUE_VALUE;
				symbol_10 = m_THelper2Function_aDef_aFeat_aModule_helper_opName_p0;
			}
			else {
				symbol_10 = ValueUtil.FALSE_VALUE;
			}
			raw_aModule = symbol_10;
		}
		else {
			raw_aModule = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_aModule ? "done "  : "fail ") + "MAP_m_THelper2Function_aDef_aFeat_aModule_helper_opName_p0");
		}
		return raw_aModule;
	}

	/**
	 *
	 * map m_THelper2Function_function_relTx_lc in ATL2QVTr {
	 * guard:middle trace : PATL2QVTr::THelper2Function[1];
	 * var aModule : ATL::Module[1] := trace.aModule;
	 * var opName : String[1] := trace.opName;
	 * var when_TModel2RelationalTransformation : PATL2QVTr::TModel2RelationalTransformation[1] := aModule.TModel2RelationalTransformation;
	 * var relTx : qvtrelation::RelationalTransformation[1] := when_TModel2RelationalTransformation.relTx;
	 * new:qvtr function : qvtbase::Function[1];
	 * set trace.function := function;
	 * set function.name := opName;
	 * set trace.relTx := relTx;
	 * set function.owningClass := relTx;
	 *
	 */
	protected boolean MAP_m_THelper2Function_function_relTx_lc(final /*@NonInvalid*/ @NonNull THelper2Function trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_THelper2Function_function_relTx_lc" + ", " + trace);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Module aModule = trace.getAModule();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String opName = trace.getOpName();
		final /*@NonInvalid*/ @Nullable TModel2RelationalTransformation TModel2RelationalTransformation = OPPOSITE_OF_TModel2RelationalTransformation_module.get(aModule);
		final /*@NonInvalid*/ boolean symbol_0 = TModel2RelationalTransformation != null;
		/*@Thrown*/ @Nullable Boolean raw_when_TModel2RelationalTransformation;
		if (symbol_0) {
			if (TModel2RelationalTransformation == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull RelationalTransformation relTx = TModel2RelationalTransformation.getRelTx();
			// creations
			final @NonNull Function function = QVTbaseFactory.eINSTANCE.createFunction();
			models[2/*qvtr*/].add(function, false);
			// mapping statements
			trace.setFunction(function);
			function.setName(opName);
			trace.setRelTx(relTx);
			function.setOwningClass(relTx);
			final /*@Thrown*/ @Nullable Boolean m_THelper2Function_function_relTx_lc = ValueUtil.TRUE_VALUE;
			raw_when_TModel2RelationalTransformation = m_THelper2Function_function_relTx_lc;
		}
		else {
			raw_when_TModel2RelationalTransformation = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_TModel2RelationalTransformation ? "done "  : "fail ") + "MAP_m_THelper2Function_function_relTx_lc");
		}
		return raw_when_TModel2RelationalTransformation;
	}

	/**
	 *
	 * map m_TInPattern2RelationDomain_aPattern_aRule_p0 in ATL2QVTr {
	 * guard:atl aPattern : ATL::InPattern[1];
	 * append jm_TInPattern2RelationDomain  : PATL2QVTr::TInPattern2RelationDomain[1];
	 * var aRule : ATL::MatchedRule[1] := aPattern.rule;
	 * new:middle trace : PATL2QVTr::TInPattern2RelationDomain[1];
	 * set trace.aPattern := aPattern;
	 * set trace.aRule := aRule;
	 * add jm_TInPattern2RelationDomain += trace;
	 *
	 */
	protected boolean MAP_m_TInPattern2RelationDomain_aPattern_aRule_p0(final /*@NonInvalid*/ @NonNull InPattern aPattern_0, final @NonNull Connection jm_TInPattern2RelationDomain)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TInPattern2RelationDomain_aPattern_aRule_p0" + ", " + aPattern_0 + ", " + jm_TInPattern2RelationDomain);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull MatchedRule rule = aPattern_0.getRule();
		// creations
		final @SuppressWarnings("null")@NonNull TInPattern2RelationDomain trace_9 = PATL2QVTrFactory.eINSTANCE.createTInPattern2RelationDomain();
		models[0/*middle*/].add(trace_9, false);
		// mapping statements
		OPPOSITE_OF_TInPattern2RelationDomain_aPattern.put(aPattern_0, trace_9);
		trace_9.setAPattern(aPattern_0);
		OPPOSITE_OF_TInPattern2RelationDomain_aRule.put(rule, trace_9);
		trace_9.setARule(rule);
		jm_TInPattern2RelationDomain.appendElement(trace_9);
		final /*@Thrown*/ @Nullable Boolean m_TInPattern2RelationDomain_aPattern_aRule_p0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((m_TInPattern2RelationDomain_aPattern_aRule_p0 ? "done "  : "fail ") + "MAP_m_TInPattern2RelationDomain_aPattern_aRule_p0");
		}
		return m_TInPattern2RelationDomain_aPattern_aRule_p0;
	}

	/**
	 *
	 * map m_TMatchedRule2Relation_aModule_matchedRule_ruleName_p0 in ATL2QVTr {
	 * guard:atl matchedRule : ATL::MatchedRule[1];
	 * append jm_TMatchedRule2Relation  : PATL2QVTr::TMatchedRule2Relation[1];
	 * var aModule : ATL::Module[1] := matchedRule.module;
	 * var ruleName : String[1] := matchedRule.name;
	 * new:middle trace : PATL2QVTr::TMatchedRule2Relation[1];
	 * set trace.matchedRule := matchedRule;
	 * set trace.ruleName := ruleName;
	 * set trace.aModule := aModule;
	 * add jm_TMatchedRule2Relation += trace;
	 *
	 */
	protected boolean MAP_m_TMatchedRule2Relation_aModule_matchedRule_ruleName_p0(final @NonNull Connection jm_TMatchedRule2Relation, final /*@NonInvalid*/ @NonNull MatchedRule matchedRule)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TMatchedRule2Relation_aModule_matchedRule_ruleName_p0" + ", " + jm_TMatchedRule2Relation + ", " + matchedRule);
		}
		final /*@NonInvalid*/ @Nullable Module module_0 = matchedRule.getModule();
		final /*@NonInvalid*/ boolean symbol_0 = module_0 != null;
		/*@Thrown*/ @Nullable Boolean raw_aModule;
		if (symbol_0) {
			if (module_0 == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name = matchedRule.getName();
			// creations
			final @SuppressWarnings("null")@NonNull TMatchedRule2Relation trace_9 = PATL2QVTrFactory.eINSTANCE.createTMatchedRule2Relation();
			models[0/*middle*/].add(trace_9, false);
			// mapping statements
			OPPOSITE_OF_TMatchedRule2Relation_matchedRule.put(matchedRule, trace_9);
			trace_9.setMatchedRule(matchedRule);
			trace_9.setRuleName(name);
			trace_9.setAModule(module_0);
			jm_TMatchedRule2Relation.appendElement(trace_9);
			final /*@Thrown*/ @Nullable Boolean m_TMatchedRule2Relation_aModule_matchedRule_ruleName_p0 = ValueUtil.TRUE_VALUE;
			raw_aModule = m_TMatchedRule2Relation_aModule_matchedRule_ruleName_p0;
		}
		else {
			raw_aModule = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_aModule ? "done "  : "fail ") + "MAP_m_TMatchedRule2Relation_aModule_matchedRule_ruleName_p0");
		}
		return raw_aModule;
	}

	/**
	 *
	 * map m_TInPattern2RelationDomain_rDomain_where_InPattern2_p1 in ATL2QVTr {
	 * guard:middle trace : PATL2QVTr::TInPattern2RelationDomain[1];
	 * append jm_TInPattern2RelationDomain__guard  : PATL2QVTr::TInPattern2RelationDomain_guard[1];
	 * var aRule : ATL::MatchedRule[1] := trace.aRule;
	 * var when_TMatchedRule2Relation : PATL2QVTr::TMatchedRule2Relation[1] := aRule.TMatchedRule2Relation;
	 * contained new:qvtr rDomain : qvtrelation::RelationDomain[1];
	 * new:middle where_TInPattern2RelationDomain_guard : PATL2QVTr::TInPattern2RelationDomain_guard[1];
	 * set rDomain.isCheckable := true;
	 * set rDomain.isEnforceable := false;
	 * set trace.rDomain := rDomain;
	 * set trace.where_InPattern2RelationDomain_guard := where_TInPattern2RelationDomain_guard;
	 * add jm_TInPattern2RelationDomain__guard += where_TInPattern2RelationDomain_guard;
	 *
	 */
	protected boolean MAP_m_TInPattern2RelationDomain_rDomain_where_InPattern2_p1(final @NonNull Connection jm_TInPattern2RelationDomain__guard_0, final /*@NonInvalid*/ @NonNull TInPattern2RelationDomain trace_0)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TInPattern2RelationDomain_rDomain_where_InPattern2_p1" + ", " + jm_TInPattern2RelationDomain__guard_0 + ", " + trace_0);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull MatchedRule aRule_0 = trace_0.getARule();
		final /*@NonInvalid*/ @Nullable TMatchedRule2Relation TMatchedRule2Relation = OPPOSITE_OF_TMatchedRule2Relation_matchedRule.get(aRule_0);
		final /*@NonInvalid*/ boolean symbol_0 = TMatchedRule2Relation != null;
		/*@Thrown*/ @Nullable Boolean raw_when_TMatchedRule2Relation;
		if (symbol_0) {
			if (TMatchedRule2Relation == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			// creations
			final @NonNull RelationDomain rDomain = QVTrelationFactory.eINSTANCE.createRelationDomain();
			models[2/*qvtr*/].add(rDomain, true);
			final @SuppressWarnings("null")@NonNull TInPattern2RelationDomain_guard where_TInPattern2RelationDomain_guard = PATL2QVTrFactory.eINSTANCE.createTInPattern2RelationDomain_guard();
			models[0/*middle*/].add(where_TInPattern2RelationDomain_guard, false);
			// mapping statements
			rDomain.setIsCheckable(ValueUtil.TRUE_VALUE);
			rDomain.setIsEnforceable(ValueUtil.FALSE_VALUE);
			trace_0.setRDomain(rDomain);
			trace_0.setWhere_InPattern2RelationDomain_guard(where_TInPattern2RelationDomain_guard);
			jm_TInPattern2RelationDomain__guard_0.appendElement(where_TInPattern2RelationDomain_guard);
			final /*@Thrown*/ @Nullable Boolean m_TInPattern2RelationDomain_rDomain_where_InPattern2_p1 = ValueUtil.TRUE_VALUE;
			raw_when_TMatchedRule2Relation = m_TInPattern2RelationDomain_rDomain_where_InPattern2_p1;
		}
		else {
			raw_when_TMatchedRule2Relation = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_TMatchedRule2Relation ? "done "  : "fail ") + "MAP_m_TInPattern2RelationDomain_rDomain_where_InPattern2_p1");
		}
		return raw_when_TMatchedRule2Relation;
	}

	/**
	 *
	 * map m_TInPattern2RelationDomain__guard_rExpression_p1 in ATL2QVTr {
	 * guard:qvtr rExpression : OperationCallExp[1];
	 * guard:middle trace : PATL2QVTr::TInPattern2RelationDomain_guard[1];
	 * var p : qvtbase::Predicate[1] := trace.p;
	 * var when_TOclExpression2OCLExpression : PATL2QVTr::TOclExpression2OCLExpression[1] := trace.when_OclExpression2OCLExpression;
	 * set trace.rExpression := rExpression;
	 * set when_TOclExpression2OCLExpression.rExpression := rExpression;
	 * set p.conditionExpression := rExpression;
	 *
	 */
	protected boolean MAP_m_TInPattern2RelationDomain__guard_rExpression_p1(final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp rExpression, final /*@NonInvalid*/ org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.@org.eclipse.jdt.annotation.NonNull TInPattern2RelationDomain_guard trace_1)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TInPattern2RelationDomain__guard_rExpression_p1" + ", " + rExpression + ", " + trace_1);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Predicate p = trace_1.getP();
		final /*@NonInvalid*/ @Nullable TOclExpression2OCLExpression when_OclExpression2OCLExpression = trace_1.getWhen_OclExpression2OCLExpression();
		final /*@NonInvalid*/ boolean symbol_0 = when_OclExpression2OCLExpression != null;
		/*@Thrown*/ @Nullable Boolean raw_when_TOclExpression2OCLExpression;
		if (symbol_0) {
			if (when_OclExpression2OCLExpression == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			// mapping statements
			trace_1.setRExpression(rExpression);
			when_OclExpression2OCLExpression.setRExpression(rExpression);
			p.setConditionExpression(rExpression);
			final /*@Thrown*/ @Nullable Boolean m_TInPattern2RelationDomain__guard_rExpression_p1 = ValueUtil.TRUE_VALUE;
			raw_when_TOclExpression2OCLExpression = m_TInPattern2RelationDomain__guard_rExpression_p1;
		}
		else {
			raw_when_TOclExpression2OCLExpression = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_TOclExpression2OCLExpression ? "done "  : "fail ") + "MAP_m_TInPattern2RelationDomain__guard_rExpression_p1");
		}
		return raw_when_TOclExpression2OCLExpression;
	}

	/**
	 *
	 * map m_TInPattern2RelationDomain__aPattern_p3 in ATL2QVTr {
	 * guard:atl aPattern : ATL::InPattern[1];
	 * var trace : PATL2QVTr::TInPattern2RelationDomain[1] := aPattern.TInPattern2RelationDomain;
	 * var where_TInPattern2RelationDomain_guard : PATL2QVTr::TInPattern2RelationDomain_guard[1] := trace.where_InPattern2RelationDomain_guard;
	 * set where_TInPattern2RelationDomain_guard.aPattern := aPattern;
	 *
	 */
	protected boolean MAP_m_TInPattern2RelationDomain__aPattern_p3(final /*@NonInvalid*/ @NonNull InPattern aPattern_1)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TInPattern2RelationDomain__aPattern_p3" + ", " + aPattern_1);
		}
		final /*@NonInvalid*/ @Nullable TInPattern2RelationDomain TInPattern2RelationDomain = OPPOSITE_OF_TInPattern2RelationDomain_aPattern.get(aPattern_1);
		final /*@NonInvalid*/ boolean symbol_0 = TInPattern2RelationDomain != null;
		/*@Thrown*/ @Nullable Boolean raw_trace;
		if (symbol_0) {
			if (TInPattern2RelationDomain == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable TInPattern2RelationDomain_guard where_InPattern2RelationDomain_guard = TInPattern2RelationDomain.getWhere_InPattern2RelationDomain_guard();
			final /*@Thrown*/ boolean symbol_1 = where_InPattern2RelationDomain_guard != null;
			/*@Thrown*/ @Nullable Boolean raw_where_TInPattern2RelationDomain_guard;
			if (symbol_1) {
				if (where_InPattern2RelationDomain_guard == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				// mapping statements
				where_InPattern2RelationDomain_guard.setAPattern(aPattern_1);
				final /*@Thrown*/ @Nullable Boolean m_TInPattern2RelationDomain__aPattern_p3 = ValueUtil.TRUE_VALUE;
				raw_where_TInPattern2RelationDomain_guard = m_TInPattern2RelationDomain__aPattern_p3;
			}
			else {
				raw_where_TInPattern2RelationDomain_guard = ValueUtil.FALSE_VALUE;
			}
			raw_trace = raw_where_TInPattern2RelationDomain_guard;
		}
		else {
			raw_trace = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_trace ? "done "  : "fail ") + "MAP_m_TInPattern2RelationDomain__aPattern_p3");
		}
		return raw_trace;
	}

	/**
	 *
	 * map m_TMatchedRule2Relation_rRule_p1 in ATL2QVTr {
	 * guard:middle trace : PATL2QVTr::TMatchedRule2Relation[1];
	 * append jo_Relation  : qvtrelation::Relation[1];
	 * var aModule : ATL::Module[1] := trace.aModule;
	 * var ruleName : String[1] := trace.ruleName;
	 * var when_TModel2RelationalTransformation : PATL2QVTr::TModel2RelationalTransformation[1] := aModule.TModel2RelationalTransformation;
	 * contained new:qvtr rRule : qvtrelation::Relation[1];
	 * set trace.rRule := rRule;
	 * set rRule.name := ruleName;
	 * add jo_Relation += rRule;
	 *
	 */
	protected boolean MAP_m_TMatchedRule2Relation_rRule_p1(final @NonNull Connection jo_Relation, final /*@NonInvalid*/ @NonNull TMatchedRule2Relation trace_2)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TMatchedRule2Relation_rRule_p1" + ", " + jo_Relation + ", " + trace_2);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Module aModule = trace_2.getAModule();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String ruleName = trace_2.getRuleName();
		final /*@NonInvalid*/ @Nullable TModel2RelationalTransformation TModel2RelationalTransformation = OPPOSITE_OF_TModel2RelationalTransformation_module.get(aModule);
		final /*@NonInvalid*/ boolean symbol_0 = TModel2RelationalTransformation != null;
		/*@Thrown*/ @Nullable Boolean raw_when_TModel2RelationalTransformation;
		if (symbol_0) {
			if (TModel2RelationalTransformation == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			// creations
			final @NonNull Relation rRule_0 = QVTrelationFactory.eINSTANCE.createRelation();
			models[2/*qvtr*/].add(rRule_0, true);
			// mapping statements
			trace_2.setRRule(rRule_0);
			rRule_0.setName(ruleName);
			jo_Relation.appendElement(rRule_0);
			final /*@Thrown*/ @Nullable Boolean m_TMatchedRule2Relation_rRule_p1 = ValueUtil.TRUE_VALUE;
			raw_when_TModel2RelationalTransformation = m_TMatchedRule2Relation_rRule_p1;
		}
		else {
			raw_when_TModel2RelationalTransformation = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_TModel2RelationalTransformation ? "done "  : "fail ") + "MAP_m_TMatchedRule2Relation_rRule_p1");
		}
		return raw_when_TModel2RelationalTransformation;
	}

	/**
	 *
	 * map m_TInPattern2RelationDomain_rRule_p2 in ATL2QVTr {
	 * guard:atl aRule : ATL::MatchedRule[1];
	 * var trace : PATL2QVTr::TInPattern2RelationDomain[1] := aRule.TInPattern2RelationDomain;
	 * var when_TMatchedRule2Relation : PATL2QVTr::TMatchedRule2Relation[1] := aRule.TMatchedRule2Relation;
	 * var rDomain : qvtrelation::RelationDomain[1] := trace.rDomain;
	 * var rRule : qvtrelation::Relation[1] := when_TMatchedRule2Relation.rRule;
	 * var where_TInPattern2RelationDomain_guard : PATL2QVTr::TInPattern2RelationDomain_guard[1] := trace.where_InPattern2RelationDomain_guard;
	 * set where_TInPattern2RelationDomain_guard.rRule := rRule;
	 * set trace.rRule := rRule;
	 * set rDomain.rule := rRule;
	 *
	 */
	protected boolean MAP_m_TInPattern2RelationDomain_rRule_p2(final /*@NonInvalid*/ @NonNull MatchedRule aRule)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TInPattern2RelationDomain_rRule_p2" + ", " + aRule);
		}
		final /*@NonInvalid*/ @Nullable TInPattern2RelationDomain TInPattern2RelationDomain = OPPOSITE_OF_TInPattern2RelationDomain_aRule.get(aRule);
		final /*@NonInvalid*/ boolean symbol_0 = TInPattern2RelationDomain != null;
		/*@Thrown*/ @Nullable Boolean raw_trace;
		if (symbol_0) {
			if (TInPattern2RelationDomain == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@NonInvalid*/ @Nullable TMatchedRule2Relation TMatchedRule2Relation = OPPOSITE_OF_TMatchedRule2Relation_matchedRule.get(aRule);
			final /*@NonInvalid*/ boolean symbol_1 = TMatchedRule2Relation != null;
			/*@Thrown*/ @Nullable Boolean raw_when_TMatchedRule2Relation;
			if (symbol_1) {
				if (TMatchedRule2Relation == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull RelationDomain rDomain = TInPattern2RelationDomain.getRDomain();
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull Relation rRule_0 = TMatchedRule2Relation.getRRule();
				final /*@Thrown*/ @Nullable TInPattern2RelationDomain_guard where_InPattern2RelationDomain_guard = TInPattern2RelationDomain.getWhere_InPattern2RelationDomain_guard();
				final /*@Thrown*/ boolean symbol_2 = where_InPattern2RelationDomain_guard != null;
				/*@Thrown*/ @Nullable Boolean raw_where_TInPattern2RelationDomain_guard;
				if (symbol_2) {
					if (where_InPattern2RelationDomain_guard == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					// mapping statements
					where_InPattern2RelationDomain_guard.setRRule(rRule_0);
					TInPattern2RelationDomain.setRRule(rRule_0);
					rDomain.setRule(rRule_0);
					final /*@Thrown*/ @Nullable Boolean m_TInPattern2RelationDomain_rRule_p2 = ValueUtil.TRUE_VALUE;
					raw_where_TInPattern2RelationDomain_guard = m_TInPattern2RelationDomain_rRule_p2;
				}
				else {
					raw_where_TInPattern2RelationDomain_guard = ValueUtil.FALSE_VALUE;
				}
				raw_when_TMatchedRule2Relation = raw_where_TInPattern2RelationDomain_guard;
			}
			else {
				raw_when_TMatchedRule2Relation = ValueUtil.FALSE_VALUE;
			}
			raw_trace = raw_when_TMatchedRule2Relation;
		}
		else {
			raw_trace = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_trace ? "done "  : "fail ") + "MAP_m_TInPattern2RelationDomain_rRule_p2");
		}
		return raw_trace;
	}

	/**
	 *
	 * map m_TMatchedRule2Relation_relTx_p2 in ATL2QVTr {
	 * guard:middle trace : PATL2QVTr::TMatchedRule2Relation[1];
	 * var aModule : ATL::Module[1] := trace.aModule;
	 * var rRule : qvtrelation::Relation[1] := trace.rRule;
	 * var when_TModel2RelationalTransformation : PATL2QVTr::TModel2RelationalTransformation[1] := aModule.TModel2RelationalTransformation;
	 * var relTx : qvtrelation::RelationalTransformation[1] := when_TModel2RelationalTransformation.relTx;
	 * set rRule.transformation := relTx;
	 * set trace.relTx := relTx;
	 *
	 */
	protected boolean MAP_m_TMatchedRule2Relation_relTx_p2(final /*@NonInvalid*/ @NonNull TMatchedRule2Relation trace_3)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TMatchedRule2Relation_relTx_p2" + ", " + trace_3);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Module aModule = trace_3.getAModule();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Relation rRule_0 = trace_3.getRRule();
		final /*@NonInvalid*/ @Nullable TModel2RelationalTransformation TModel2RelationalTransformation = OPPOSITE_OF_TModel2RelationalTransformation_module.get(aModule);
		final /*@NonInvalid*/ boolean symbol_0 = TModel2RelationalTransformation != null;
		/*@Thrown*/ @Nullable Boolean raw_when_TModel2RelationalTransformation;
		if (symbol_0) {
			if (TModel2RelationalTransformation == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull RelationalTransformation relTx = TModel2RelationalTransformation.getRelTx();
			// mapping statements
			rRule_0.setTransformation(relTx);
			trace_3.setRelTx(relTx);
			final /*@Thrown*/ @Nullable Boolean m_TMatchedRule2Relation_relTx_p2 = ValueUtil.TRUE_VALUE;
			raw_when_TModel2RelationalTransformation = m_TMatchedRule2Relation_relTx_p2;
		}
		else {
			raw_when_TModel2RelationalTransformation = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_TModel2RelationalTransformation ? "done "  : "fail ") + "MAP_m_TMatchedRule2Relation_relTx_p2");
		}
		return raw_when_TModel2RelationalTransformation;
	}

	/**
	 *
	 * map m_TInPattern2RelationDomain__guard_rRule_p2 in ATL2QVTr {
	 * guard:qvtr rRule : qvtrelation::Relation[1];
	 * guard:middle trace : PATL2QVTr::TInPattern2RelationDomain_guard[1];
	 * var w : qvtbase::Pattern[1] := trace.w;
	 * var when_TOclExpression2OCLExpression : PATL2QVTr::TOclExpression2OCLExpression[1] := trace.when_OclExpression2OCLExpression;
	 * set trace.rRule := rRule;
	 * set rRule.when := w;
	 *
	 */
	protected boolean MAP_m_TInPattern2RelationDomain__guard_rRule_p2(final /*@NonInvalid*/ @NonNull Relation rRule, final /*@NonInvalid*/ @NonNull TInPattern2RelationDomain_guard trace_4)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TInPattern2RelationDomain__guard_rRule_p2" + ", " + rRule + ", " + trace_4);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Pattern w = trace_4.getW();
		final /*@NonInvalid*/ @Nullable TOclExpression2OCLExpression when_OclExpression2OCLExpression = trace_4.getWhen_OclExpression2OCLExpression();
		final /*@NonInvalid*/ boolean symbol_0 = when_OclExpression2OCLExpression != null;
		/*@Thrown*/ @Nullable Boolean raw_when_TOclExpression2OCLExpression;
		if (symbol_0) {
			if (when_OclExpression2OCLExpression == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			// mapping statements
			trace_4.setRRule(rRule);
			rRule.setWhen(w);
			final /*@Thrown*/ @Nullable Boolean m_TInPattern2RelationDomain__guard_rRule_p2 = ValueUtil.TRUE_VALUE;
			raw_when_TOclExpression2OCLExpression = m_TInPattern2RelationDomain__guard_rRule_p2;
		}
		else {
			raw_when_TOclExpression2OCLExpression = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_TOclExpression2OCLExpression ? "done "  : "fail ") + "MAP_m_TInPattern2RelationDomain__guard_rRule_p2");
		}
		return raw_when_TOclExpression2OCLExpression;
	}

	/**
	 *
	 * map m_TOclModel2ModelParameter__create_aModule_oclModel__p0 in ATL2QVTr {
	 * guard:atl oclModel : OCL::OclModel[1];
	 * append jm_TOclModel2ModelParameter__create  : PATL2QVTr::TOclModel2ModelParameter_create[1];
	 * var aModule : ATL::Module[1] := oclModel.Module;
	 * var tmName : String[1] := oclModel.name;
	 * new:middle trace : PATL2QVTr::TOclModel2ModelParameter_create[1];
	 * set trace.oclModel := oclModel;
	 * set trace.tmName := tmName;
	 * set trace.aModule := aModule;
	 * add jm_TOclModel2ModelParameter__create += trace;
	 *
	 */
	protected boolean MAP_m_TOclModel2ModelParameter__create_aModule_oclModel__p0(final @NonNull Connection jm_TOclModel2ModelParameter__create, final /*@NonInvalid*/ @NonNull OclModel oclModel)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TOclModel2ModelParameter__create_aModule_oclModel__p0" + ", " + jm_TOclModel2ModelParameter__create + ", " + oclModel);
		}
		final /*@NonInvalid*/ @NonNull UnboxedCompositionProperty IMPPROPid_inModels = new UnboxedCompositionProperty(PROPid_inModels);
		final /*@NonInvalid*/ @Nullable Module Module = (Module)IMPPROPid_inModels.evaluate(executor, CLSSid_Module, oclModel);
		final /*@NonInvalid*/ boolean symbol_0 = Module != null;
		/*@Thrown*/ @Nullable Boolean raw_aModule;
		if (symbol_0) {
			if (Module == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name = oclModel.getName();
			// creations
			final @SuppressWarnings("null")@NonNull TOclModel2ModelParameter_create trace_9 = PATL2QVTrFactory.eINSTANCE.createTOclModel2ModelParameter_create();
			models[0/*middle*/].add(trace_9, false);
			// mapping statements
			trace_9.setOclModel(oclModel);
			trace_9.setTmName(name);
			trace_9.setAModule(Module);
			jm_TOclModel2ModelParameter__create.appendElement(trace_9);
			final /*@Thrown*/ @Nullable Boolean m_TOclModel2ModelParameter__create_aModule_oclModel__p0 = ValueUtil.TRUE_VALUE;
			raw_aModule = m_TOclModel2ModelParameter__create_aModule_oclModel__p0;
		}
		else {
			raw_aModule = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_aModule ? "done "  : "fail ") + "MAP_m_TOclModel2ModelParameter__create_aModule_oclModel__p0");
		}
		return raw_aModule;
	}

	/**
	 *
	 * map m_TOclModel2ModelParameter__create_relTM_p1 in ATL2QVTr {
	 * guard:middle trace : PATL2QVTr::TOclModel2ModelParameter_create[1];
	 * var aModule : ATL::Module[1] := trace.aModule;
	 * var tmName : String[1] := trace.tmName;
	 * var when_TModel2RelationalTransformation : PATL2QVTr::TModel2RelationalTransformation[1] := aModule.TModel2RelationalTransformation;
	 * contained new:qvtr relTM : qvtbase::TypedModel[1];
	 * set trace.relTM := relTM;
	 * set relTM.name := tmName;
	 *
	 */
	protected boolean MAP_m_TOclModel2ModelParameter__create_relTM_p1(final /*@NonInvalid*/ @NonNull TOclModel2ModelParameter_create trace_5)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TOclModel2ModelParameter__create_relTM_p1" + ", " + trace_5);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Module aModule = trace_5.getAModule();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String tmName = trace_5.getTmName();
		final /*@NonInvalid*/ @Nullable TModel2RelationalTransformation TModel2RelationalTransformation = OPPOSITE_OF_TModel2RelationalTransformation_module.get(aModule);
		final /*@NonInvalid*/ boolean symbol_0 = TModel2RelationalTransformation != null;
		/*@Thrown*/ @Nullable Boolean raw_when_TModel2RelationalTransformation;
		if (symbol_0) {
			if (TModel2RelationalTransformation == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			// creations
			final @NonNull TypedModel relTM = QVTbaseFactory.eINSTANCE.createTypedModel();
			models[2/*qvtr*/].add(relTM, true);
			// mapping statements
			trace_5.setRelTM(relTM);
			relTM.setName(tmName);
			final /*@Thrown*/ @Nullable Boolean m_TOclModel2ModelParameter__create_relTM_p1 = ValueUtil.TRUE_VALUE;
			raw_when_TModel2RelationalTransformation = m_TOclModel2ModelParameter__create_relTM_p1;
		}
		else {
			raw_when_TModel2RelationalTransformation = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_TModel2RelationalTransformation ? "done "  : "fail ") + "MAP_m_TOclModel2ModelParameter__create_relTM_p1");
		}
		return raw_when_TModel2RelationalTransformation;
	}

	/**
	 *
	 * map m_TOclModel2ModelParameter__from_aModule_oclModel_tm_p0 in ATL2QVTr {
	 * guard:atl oclModel : OCL::OclModel[1];
	 * append jm_TOclModel2ModelParameter__from  : PATL2QVTr::TOclModel2ModelParameter_from[1];
	 * var aModule : ATL::Module[1] := oclModel.Module;
	 * var tmName : String[1] := oclModel.name;
	 * new:middle trace : PATL2QVTr::TOclModel2ModelParameter_from[1];
	 * set trace.oclModel := oclModel;
	 * set trace.tmName := tmName;
	 * set trace.aModule := aModule;
	 * add jm_TOclModel2ModelParameter__from += trace;
	 *
	 */
	protected boolean MAP_m_TOclModel2ModelParameter__from_aModule_oclModel_tm_p0(final @NonNull Connection jm_TOclModel2ModelParameter__from, final /*@NonInvalid*/ @NonNull OclModel oclModel_0)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TOclModel2ModelParameter__from_aModule_oclModel_tm_p0" + ", " + jm_TOclModel2ModelParameter__from + ", " + oclModel_0);
		}
		final /*@NonInvalid*/ @NonNull UnboxedCompositionProperty IMPPROPid_outModels = new UnboxedCompositionProperty(PROPid_outModels);
		final /*@NonInvalid*/ @Nullable Module Module = (Module)IMPPROPid_outModels.evaluate(executor, CLSSid_Module, oclModel_0);
		final /*@NonInvalid*/ boolean symbol_0 = Module != null;
		/*@Thrown*/ @Nullable Boolean raw_aModule;
		if (symbol_0) {
			if (Module == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name = oclModel_0.getName();
			// creations
			final @SuppressWarnings("null")@NonNull TOclModel2ModelParameter_from trace_9 = PATL2QVTrFactory.eINSTANCE.createTOclModel2ModelParameter_from();
			models[0/*middle*/].add(trace_9, false);
			// mapping statements
			trace_9.setOclModel(oclModel_0);
			trace_9.setTmName(name);
			trace_9.setAModule(Module);
			jm_TOclModel2ModelParameter__from.appendElement(trace_9);
			final /*@Thrown*/ @Nullable Boolean m_TOclModel2ModelParameter__from_aModule_oclModel_tm_p0 = ValueUtil.TRUE_VALUE;
			raw_aModule = m_TOclModel2ModelParameter__from_aModule_oclModel_tm_p0;
		}
		else {
			raw_aModule = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_aModule ? "done "  : "fail ") + "MAP_m_TOclModel2ModelParameter__from_aModule_oclModel_tm_p0");
		}
		return raw_aModule;
	}

	/**
	 *
	 * map m_TOclModel2ModelParameter__from_relTM_p1 in ATL2QVTr {
	 * guard:middle trace : PATL2QVTr::TOclModel2ModelParameter_from[1];
	 * var aModule : ATL::Module[1] := trace.aModule;
	 * var tmName : String[1] := trace.tmName;
	 * var when_TModel2RelationalTransformation : PATL2QVTr::TModel2RelationalTransformation[1] := aModule.TModel2RelationalTransformation;
	 * contained new:qvtr relTM : qvtbase::TypedModel[1];
	 * set trace.relTM := relTM;
	 * set relTM.name := tmName;
	 *
	 */
	protected boolean MAP_m_TOclModel2ModelParameter__from_relTM_p1(final /*@NonInvalid*/ @NonNull TOclModel2ModelParameter_from trace_6)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TOclModel2ModelParameter__from_relTM_p1" + ", " + trace_6);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Module aModule = trace_6.getAModule();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String tmName = trace_6.getTmName();
		final /*@NonInvalid*/ @Nullable TModel2RelationalTransformation TModel2RelationalTransformation = OPPOSITE_OF_TModel2RelationalTransformation_module.get(aModule);
		final /*@NonInvalid*/ boolean symbol_0 = TModel2RelationalTransformation != null;
		/*@Thrown*/ @Nullable Boolean raw_when_TModel2RelationalTransformation;
		if (symbol_0) {
			if (TModel2RelationalTransformation == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			// creations
			final @NonNull TypedModel relTM = QVTbaseFactory.eINSTANCE.createTypedModel();
			models[2/*qvtr*/].add(relTM, true);
			// mapping statements
			trace_6.setRelTM(relTM);
			relTM.setName(tmName);
			final /*@Thrown*/ @Nullable Boolean m_TOclModel2ModelParameter__from_relTM_p1 = ValueUtil.TRUE_VALUE;
			raw_when_TModel2RelationalTransformation = m_TOclModel2ModelParameter__from_relTM_p1;
		}
		else {
			raw_when_TModel2RelationalTransformation = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_TModel2RelationalTransformation ? "done "  : "fail ") + "MAP_m_TOclModel2ModelParameter__from_relTM_p1");
		}
		return raw_when_TModel2RelationalTransformation;
	}

	/**
	 *
	 * map m_TOclModel2ModelParameter__create_relTx_p2 in ATL2QVTr {
	 * guard:middle trace : PATL2QVTr::TOclModel2ModelParameter_create[1];
	 * var aModule : ATL::Module[1] := trace.aModule;
	 * var relTM : qvtbase::TypedModel[1] := trace.relTM;
	 * var when_TModel2RelationalTransformation : PATL2QVTr::TModel2RelationalTransformation[1] := aModule.TModel2RelationalTransformation;
	 * var relTx : qvtrelation::RelationalTransformation[1] := when_TModel2RelationalTransformation.relTx;
	 * set relTM.transformation := relTx;
	 * set trace.relTx := relTx;
	 *
	 */
	protected boolean MAP_m_TOclModel2ModelParameter__create_relTx_p2(final /*@NonInvalid*/ @NonNull TOclModel2ModelParameter_create trace_7)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TOclModel2ModelParameter__create_relTx_p2" + ", " + trace_7);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Module aModule = trace_7.getAModule();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull TypedModel relTM = trace_7.getRelTM();
		final /*@NonInvalid*/ @Nullable TModel2RelationalTransformation TModel2RelationalTransformation = OPPOSITE_OF_TModel2RelationalTransformation_module.get(aModule);
		final /*@NonInvalid*/ boolean symbol_0 = TModel2RelationalTransformation != null;
		/*@Thrown*/ @Nullable Boolean raw_when_TModel2RelationalTransformation;
		if (symbol_0) {
			if (TModel2RelationalTransformation == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull RelationalTransformation relTx = TModel2RelationalTransformation.getRelTx();
			// mapping statements
			relTM.setTransformation(relTx);
			trace_7.setRelTx(relTx);
			final /*@Thrown*/ @Nullable Boolean m_TOclModel2ModelParameter__create_relTx_p2 = ValueUtil.TRUE_VALUE;
			raw_when_TModel2RelationalTransformation = m_TOclModel2ModelParameter__create_relTx_p2;
		}
		else {
			raw_when_TModel2RelationalTransformation = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_TModel2RelationalTransformation ? "done "  : "fail ") + "MAP_m_TOclModel2ModelParameter__create_relTx_p2");
		}
		return raw_when_TModel2RelationalTransformation;
	}

	/**
	 *
	 * map m_TOclModel2ModelParameter__from_relTx_p2 in ATL2QVTr {
	 * guard:middle trace : PATL2QVTr::TOclModel2ModelParameter_from[1];
	 * var aModule : ATL::Module[1] := trace.aModule;
	 * var relTM : qvtbase::TypedModel[1] := trace.relTM;
	 * var when_TModel2RelationalTransformation : PATL2QVTr::TModel2RelationalTransformation[1] := aModule.TModel2RelationalTransformation;
	 * var relTx : qvtrelation::RelationalTransformation[1] := when_TModel2RelationalTransformation.relTx;
	 * set relTM.transformation := relTx;
	 * set trace.relTx := relTx;
	 *
	 */
	protected boolean MAP_m_TOclModel2ModelParameter__from_relTx_p2(final /*@NonInvalid*/ @NonNull TOclModel2ModelParameter_from trace_8)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TOclModel2ModelParameter__from_relTx_p2" + ", " + trace_8);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Module aModule = trace_8.getAModule();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull TypedModel relTM = trace_8.getRelTM();
		final /*@NonInvalid*/ @Nullable TModel2RelationalTransformation TModel2RelationalTransformation = OPPOSITE_OF_TModel2RelationalTransformation_module.get(aModule);
		final /*@NonInvalid*/ boolean symbol_0 = TModel2RelationalTransformation != null;
		/*@Thrown*/ @Nullable Boolean raw_when_TModel2RelationalTransformation;
		if (symbol_0) {
			if (TModel2RelationalTransformation == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull RelationalTransformation relTx = TModel2RelationalTransformation.getRelTx();
			// mapping statements
			relTM.setTransformation(relTx);
			trace_8.setRelTx(relTx);
			final /*@Thrown*/ @Nullable Boolean m_TOclModel2ModelParameter__from_relTx_p2 = ValueUtil.TRUE_VALUE;
			raw_when_TModel2RelationalTransformation = m_TOclModel2ModelParameter__from_relTx_p2;
		}
		else {
			raw_when_TModel2RelationalTransformation = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_TModel2RelationalTransformation ? "done "  : "fail ") + "MAP_m_TOclModel2ModelParameter__from_relTx_p2");
		}
		return raw_when_TModel2RelationalTransformation;
	}
}