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
import org.eclipse.m2m.atl.common.ATL.Module;
import org.eclipse.m2m.atl.common.OCL.OCLPackage;
import org.eclipse.m2m.atl.common.OCL.OclFeature;
import org.eclipse.m2m.atl.common.OCL.OclFeatureDefinition;
import org.eclipse.m2m.atl.common.OCL.Operation;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrFactory;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationFactory;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
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
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTbase = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2017/QVTbase", null, QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTrelation = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2017/QVTrelation", null, QVTrelationPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd-example/org/eclipse/qvtd/atl/atl2qvtr/ATL2QVTr", "PATL2QVTr", PATL2QVTrPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Function = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTbase.getClassId("Function", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Helper = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("Helper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Module = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("Module", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclFeature = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("OclFeature", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclFeatureDefinition = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("OclFeatureDefinition", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Operation = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Package = PACKid_$metamodel$.getClassId("Package", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelationModel = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTrelation.getClassId("RelationModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelationalTransformation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTrelation.getClassId("RelationalTransformation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_THelper2Function = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("THelper2Function", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TModel2RelationalTransformation = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TModel2RelationalTransformation", 0);
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_aModule = CLSSid_THelper2Function.getPropertyId("aModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_module = CLSSid_TModel2RelationalTransformation.getPropertyId("module");

	/*
	 * Property-source to Property-target unnavigable navigation caches
	 */
	protected final @NonNull Map<Module,THelper2Function> OPPOSITE_OF_THelper2Function_aModule = new HashMap<Module,THelper2Function>();
	protected final @NonNull Map<Module,TModel2RelationalTransformation> OPPOSITE_OF_TModel2RelationalTransformation_module = new HashMap<Module,TModel2RelationalTransformation>();

	/*
	 * Array of the source PropertyIds of each Property for which unnavigable opposite property navigation may occur.
	 */
	private static final @NonNull PropertyId @NonNull [] oppositeIndex2propertyId = new @NonNull PropertyId[]{
		PROPid_module,		// 0 => module
		PROPid_aModule		// 1 => aModule
	};

	/*
	 * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
	 */
	private static final @NonNull ClassId @NonNull [] classIndex2classId = new @NonNull ClassId[]{
		CLSSid_Helper,                        // 0 => Helper
		CLSSid_Module                         // 1 => Module
	};

	/*
	 * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
	 * may contribute results to an allInstances() invocation.
	 * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
	 * instance of the derived classId contributes to derived and inherited ClassIndexes.
	 */
	private final static int @NonNull [] @NonNull [] classIndex2allClassIndexes = new int @NonNull [] @NonNull [] {
		{0},                          // 0 : Helper -> {Helper}
		{1}                           // 1 : Module -> {Module}
	};


	public ATL2QVTr(final @NonNull TransformationExecutor executor) {
		super(executor, new @NonNull String[] {"middle", "atl", "qvtr", "$primitive$"}, oppositeIndex2propertyId, classIndex2classId, classIndex2allClassIndexes);
	}

	@Override
	public boolean run() {
		final @NonNull Connection ji_Helper = models[1/*atl*/].getConnection(0/*ATL::Helper*/);
		final @NonNull Connection ji_Module = models[1/*atl*/].getConnection(1/*ATL::Module*/);
		return MAP___root__(ji_Helper, ji_Module) && invocationManager.flush();
	}

	/**
	 *
	 * map __root__ in ATL2QVTr {
	 *
	 *   append ji_Helper  : ATL::Helper[1];
	 * append ji_Module  : ATL::Module[1];
	 * ::jm_THelper2Function : PATL2QVTr::THelper2Function[1]install m_TModel2RelationalTransformation__3__4_module_relTx_r0 {
	 * module consumes append ji_Module  : ATL::Module[1];
	 * ;
	 * }
	 *   install m_THelper2Function_aDef_aFeat_aModule_helper_txName_p0 {
	 * helper consumes append ji_Helper  : ATL::Helper[1];
	 * ;
	 * jm_THelper2Function appendsTo jm_THelper2Function;
	 * }
	 *   install m_THelper2Function_function_p1 {
	 * trace consumes ::jm_THelper2Function : PATL2QVTr::THelper2Function[1];
	 * }
	 *   install m_THelper2Function__owningClass_p2 {
	 * aModule consumes append ji_Module  : ATL::Module[1];
	 * ;
	 * }
	 */
	protected boolean MAP___root__(final @NonNull Connection ji_Helper, final @NonNull Connection ji_Module)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP___root__" + ", " + ji_Helper + ", " + ji_Module);
		}
		// connection variables
		final @NonNull Connection jm_THelper2Function_1 = createConnection("jm_THelper2Function", CLSSid_THelper2Function, false);
		// mapping statements
		for (@NonNull Module module_0 : ji_Module.typedIterable(Module.class)) {
			MAP_m_TModel2RelationalTransformation__3__4_module_relTx_r0(module_0);
		}
		for (@NonNull Helper helper_0 : ji_Helper.typedIterable(Helper.class)) {
			MAP_m_THelper2Function_aDef_aFeat_aModule_helper_txName_p0(helper_0, jm_THelper2Function_1);
		}
		for (@NonNull THelper2Function trace_0 : jm_THelper2Function_1.typedIterable(THelper2Function.class)) {
			MAP_m_THelper2Function_function_p1(trace_0);
		}
		for (@NonNull Module aModule_0 : ji_Module.typedIterable(Module.class)) {
			MAP_m_THelper2Function__owningClass_p2(aModule_0);
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
	 * guard:atl module  : ATL::Module[1];
	 * var txName : String[1] := module.name;
	 * contained new:qvtr _3 : Package[1];
	 * new:qvtr _4 : qvtrelation::RelationModel[1];
	 * contained new:qvtr relTx : qvtrelation::RelationalTransformation[1];
	 * new:middle trace : PATL2QVTr::TModel2RelationalTransformation[1];
	 * set _4.name := null;
	 * set _3.name := null;
	 * set relTx.owningPackage := _3;
	 * set trace._3 := _3;
	 * set trace._4 := _4;
	 * set trace.module := module;
	 * set trace.relTx := relTx;
	 * set _3.Model := _4;
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
		final @SuppressWarnings("null")@NonNull TModel2RelationalTransformation trace_0 = PATL2QVTrFactory.eINSTANCE.createTModel2RelationalTransformation();
		models[0/*middle*/].add(trace_0, false);
		// mapping statements
		_4.setName(null);
		_3.setName(null);
		relTx.setOwningPackage(_3);
		trace_0.set_3(_3);
		trace_0.set_4(_4);
		OPPOSITE_OF_TModel2RelationalTransformation_module.put(module, trace_0);
		trace_0.setModule(module);
		trace_0.setRelTx(relTx);
		_4.getOwnedPackages().add(_3);
		relTx.setName(name);
		trace_0.setTxName(name);
		final /*@Thrown*/ @Nullable Boolean m_TModel2RelationalTransformation__3__4_module_relTx_r0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((m_TModel2RelationalTransformation__3__4_module_relTx_r0 ? "done "  : "fail ") + "MAP_m_TModel2RelationalTransformation__3__4_module_relTx_r0");
		}
		return m_TModel2RelationalTransformation__3__4_module_relTx_r0;
	}

	/**
	 *
	 * map m_THelper2Function_aDef_aFeat_aModule_helper_txName_p0 in ATL2QVTr {
	 * guard:atl helper  : ATL::Helper[1];
	 * append jm_THelper2Function  : PATL2QVTr::THelper2Function[1];
	 * var aDef : OCL::OclFeatureDefinition[1] := helper.definition;
	 * var aModule : ATL::Module[1] := helper.module;
	 * var aFeat : OCL::OclFeature[1] := aDef.feature;
	 * check var aFeat1 : OCL::Operation[1] := aFeat;
	 * var txName : String[1] := aFeat1.name;
	 * new:middle trace : PATL2QVTr::THelper2Function[1];
	 * set trace.helper := helper;
	 * set trace.aDef := aDef;
	 * set trace.aModule := aModule;
	 * set trace.aFeat := aFeat1;
	 * set trace.txName := txName;
	 * add jm_THelper2Function += trace;
	 *
	 */
	protected boolean MAP_m_THelper2Function_aDef_aFeat_aModule_helper_txName_p0(final /*@NonInvalid*/ @NonNull Helper helper, final @NonNull Connection jm_THelper2Function)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_THelper2Function_aDef_aFeat_aModule_helper_txName_p0" + ", " + helper + ", " + jm_THelper2Function);
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
				final @SuppressWarnings("null")@NonNull THelper2Function trace_0 = PATL2QVTrFactory.eINSTANCE.createTHelper2Function();
				models[0/*middle*/].add(trace_0, false);
				// mapping statements
				trace_0.setHelper(helper);
				trace_0.setADef(definition);
				OPPOSITE_OF_THelper2Function_aModule.put(module_0, trace_0);
				trace_0.setAModule(module_0);
				trace_0.setAFeat(symbol_2);
				trace_0.setTxName(name);
				jm_THelper2Function.appendElement(trace_0);
				final /*@Thrown*/ @Nullable Boolean m_THelper2Function_aDef_aFeat_aModule_helper_txName_p0 = ValueUtil.TRUE_VALUE;
				symbol_10 = m_THelper2Function_aDef_aFeat_aModule_helper_txName_p0;
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
			AbstractTransformer.INVOCATIONS.println((raw_aModule ? "done "  : "fail ") + "MAP_m_THelper2Function_aDef_aFeat_aModule_helper_txName_p0");
		}
		return raw_aModule;
	}

	/**
	 *
	 * map m_THelper2Function_function_p1 in ATL2QVTr {
	 * guard:middle trace  : PATL2QVTr::THelper2Function[1];
	 * var aModule : ATL::Module[1] := trace.aModule;
	 * var txName : String[1] := trace.txName;
	 * var when_TModel2RelationalTransformation : PATL2QVTr::TModel2RelationalTransformation[1] := aModule.TModel2RelationalTransformation;
	 * contained new:qvtr function : qvtbase::Function[1];
	 * set trace.function := function;
	 * set function.name := txName;
	 *
	 */
	protected boolean MAP_m_THelper2Function_function_p1(final /*@NonInvalid*/ @NonNull THelper2Function trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_THelper2Function_function_p1" + ", " + trace);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Module aModule_0 = trace.getAModule();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String txName = trace.getTxName();
		final /*@NonInvalid*/ @Nullable TModel2RelationalTransformation TModel2RelationalTransformation = OPPOSITE_OF_TModel2RelationalTransformation_module.get(aModule_0);
		final /*@NonInvalid*/ boolean symbol_0 = TModel2RelationalTransformation != null;
		/*@Thrown*/ @Nullable Boolean raw_when_TModel2RelationalTransformation;
		if (symbol_0) {
			if (TModel2RelationalTransformation == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			// creations
			final @NonNull Function function = QVTbaseFactory.eINSTANCE.createFunction();
			models[2/*qvtr*/].add(function, true);
			// mapping statements
			trace.setFunction(function);
			function.setName(txName);
			final /*@Thrown*/ @Nullable Boolean m_THelper2Function_function_p1 = ValueUtil.TRUE_VALUE;
			raw_when_TModel2RelationalTransformation = m_THelper2Function_function_p1;
		}
		else {
			raw_when_TModel2RelationalTransformation = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_TModel2RelationalTransformation ? "done "  : "fail ") + "MAP_m_THelper2Function_function_p1");
		}
		return raw_when_TModel2RelationalTransformation;
	}

	/**
	 *
	 * map m_THelper2Function__owningClass_p2 in ATL2QVTr {
	 * guard:atl aModule  : ATL::Module[1];
	 * var trace : PATL2QVTr::THelper2Function[1] := aModule.THelper2Function;
	 * var when_TModel2RelationalTransformation : PATL2QVTr::TModel2RelationalTransformation[1] := aModule.TModel2RelationalTransformation;
	 * var function : qvtbase::Function[1] := trace.function;
	 * var relTx : qvtrelation::RelationalTransformation[1] := when_TModel2RelationalTransformation.relTx;
	 * set function.owningClass := relTx;
	 *
	 */
	protected boolean MAP_m_THelper2Function__owningClass_p2(final /*@NonInvalid*/ @NonNull Module aModule)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_THelper2Function__owningClass_p2" + ", " + aModule);
		}
		final /*@NonInvalid*/ @Nullable THelper2Function THelper2Function = OPPOSITE_OF_THelper2Function_aModule.get(aModule);
		final /*@NonInvalid*/ boolean symbol_0 = THelper2Function != null;
		/*@Thrown*/ @Nullable Boolean raw_trace;
		if (symbol_0) {
			if (THelper2Function == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@NonInvalid*/ @Nullable TModel2RelationalTransformation TModel2RelationalTransformation = OPPOSITE_OF_TModel2RelationalTransformation_module.get(aModule);
			final /*@NonInvalid*/ boolean symbol_1 = TModel2RelationalTransformation != null;
			/*@Thrown*/ @Nullable Boolean raw_when_TModel2RelationalTransformation;
			if (symbol_1) {
				if (TModel2RelationalTransformation == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull Function function = THelper2Function.getFunction();
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull RelationalTransformation relTx = TModel2RelationalTransformation.getRelTx();
				// mapping statements
				function.setOwningClass(relTx);
				final /*@Thrown*/ @Nullable Boolean m_THelper2Function__owningClass_p2 = ValueUtil.TRUE_VALUE;
				raw_when_TModel2RelationalTransformation = m_THelper2Function__owningClass_p2;
			}
			else {
				raw_when_TModel2RelationalTransformation = ValueUtil.FALSE_VALUE;
			}
			raw_trace = raw_when_TModel2RelationalTransformation;
		}
		else {
			raw_trace = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_trace ? "done "  : "fail ") + "MAP_m_THelper2Function__owningClass_p2");
		}
		return raw_trace;
	}
}
