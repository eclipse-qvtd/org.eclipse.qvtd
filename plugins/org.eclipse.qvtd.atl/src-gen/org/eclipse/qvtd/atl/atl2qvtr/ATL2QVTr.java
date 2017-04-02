/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.qvtd.atl.atl2qvtr;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.m2m.atl.common.ATL.ATLPackage;
import org.eclipse.m2m.atl.common.ATL.Module;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrFactory;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationFactory;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Connection;
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
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTrelation = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2017/QVTrelation", null, QVTrelationPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd-example/org/eclipse/qvtd/atl/atl2qvtr/ATL2QVTr", "PATL2QVTr", PATL2QVTrPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Module = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("Module", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Package = PACKid_$metamodel$.getClassId("Package", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelationModel = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTrelation.getClassId("RelationModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelationalTransformation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTrelation.getClassId("RelationalTransformation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TModel2RelationalTransformation = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TModel2RelationalTransformation", 0);

	/*
	 * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
	 */
	private static final @NonNull ClassId @NonNull [] classIndex2classId = new @NonNull ClassId[]{
		CLSSid_Module                         // 0 => Module
	};

	/*
	 * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
	 * may contribute results to an allInstances() invocation.
	 * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
	 * instance of the derived classId contributes to derived and inherited ClassIndexes.
	 */
	private final static int @NonNull [] @NonNull [] classIndex2allClassIndexes = new int @NonNull [] @NonNull [] {
		{0}                           // 0 : Module -> {Module}
	};


	public ATL2QVTr(final @NonNull TransformationExecutor executor) {
		super(executor, new @NonNull String[] {"middle", "atl", "qvtr", "$primitive$"}, null, classIndex2classId, classIndex2allClassIndexes);
	}

	@Override
	public boolean run() {
		final @NonNull Connection ji_Module = models[1/*atl*/].getConnection(0/*ATL::Module*/);
		return MAP___root__(ji_Module) && invocationManager.flush();
	}

	/**
	 *
	 * map __root__ in ATL2QVTr {
	 *
	 *   append ji_Module  : ATL::Module[1];
	 * install m_TModel2RelationalTransformation__3__4_module_relMo_r0 {
	 * module consumes append ji_Module  : ATL::Module[1];
	 * ;
	 * }
	 */
	protected boolean MAP___root__(final @NonNull Connection ji_Module)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP___root__" + ", " + ji_Module);
		}
		// mapping statements
		for (@NonNull Module module_0 : ji_Module.typedIterable(Module.class)) {
			MAP_m_TModel2RelationalTransformation__3__4_module_relMo_r0(module_0);
		}
		final /*@Thrown*/ @Nullable Boolean __root__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((__root__ ? "done "  : "fail ") + "MAP___root__");
		}
		return __root__;
	}

	/**
	 *
	 * map m_TModel2RelationalTransformation__3__4_module_relMo_r0 in ATL2QVTr {
	 * guard:atl module  : ATL::Module[1];
	 * var txName : String[1] := module.name;
	 * new:qvtr _3 : Package[1];
	 * new:qvtr _4 : qvtrelation::RelationalTransformation[1];
	 * new:qvtr relModel : qvtrelation::RelationModel[1];
	 * new:middle trace : PATL2QVTr::TModel2RelationalTransformation[1];
	 * set relModel.name := null;
	 * set _3.name := null;
	 * set relModel.ownedPackages := _3;
	 * set _3.ownedClasses := _4;
	 * set trace._3 := _3;
	 * set trace._4 := _4;
	 * set trace.module := module;
	 * set trace.relModel := relModel;
	 * set _4.name := txName;
	 * set trace.txName := txName;
	 *
	 */
	protected boolean MAP_m_TModel2RelationalTransformation__3__4_module_relMo_r0(final /*@NonInvalid*/ @NonNull Module module)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TModel2RelationalTransformation__3__4_module_relMo_r0" + ", " + module);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String name = module.getName();
		// creations
		final @SuppressWarnings("null")org.eclipse.ocl.pivot.@NonNull Package _3 = PivotFactory.eINSTANCE.createPackage();
		models[2/*qvtr*/].add(_3, false);
		final @NonNull RelationalTransformation _4 = QVTrelationFactory.eINSTANCE.createRelationalTransformation();
		models[2/*qvtr*/].add(_4, false);
		final @NonNull RelationModel relModel = QVTrelationFactory.eINSTANCE.createRelationModel();
		models[2/*qvtr*/].add(relModel, false);
		final @SuppressWarnings("null")@NonNull TModel2RelationalTransformation trace = PATL2QVTrFactory.eINSTANCE.createTModel2RelationalTransformation();
		models[0/*middle*/].add(trace, false);
		// mapping statements
		relModel.setName(null);
		_3.setName(null);
		relModel.getOwnedPackages().add(_3);
		_3.getOwnedClasses().add(_4);
		trace.set_3(_3);
		trace.set_4(_4);
		trace.setModule(module);
		trace.setRelModel(relModel);
		_4.setName(name);
		trace.setTxName(name);
		final /*@Thrown*/ @Nullable Boolean m_TModel2RelationalTransformation__3__4_module_relMo_r0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((m_TModel2RelationalTransformation__3__4_module_relMo_r0 ? "done "  : "fail ") + "MAP_m_TModel2RelationalTransformation__3__4_module_relMo_r0");
		}
		return m_TModel2RelationalTransformation__3__4_module_relMo_r0;
	}
}
