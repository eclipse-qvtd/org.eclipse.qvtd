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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.m2m.atl.common.ATL.ATLPackage;
import org.eclipse.m2m.atl.common.ATL.Binding;
import org.eclipse.m2m.atl.common.ATL.Helper;
import org.eclipse.m2m.atl.common.ATL.InPattern;
import org.eclipse.m2m.atl.common.ATL.InPatternElement;
import org.eclipse.m2m.atl.common.ATL.LocatedElement;
import org.eclipse.m2m.atl.common.ATL.MatchedRule;
import org.eclipse.m2m.atl.common.ATL.Module;
import org.eclipse.m2m.atl.common.ATL.ModuleElement;
import org.eclipse.m2m.atl.common.ATL.OutPattern;
import org.eclipse.m2m.atl.common.ATL.OutPatternElement;
import org.eclipse.m2m.atl.common.ATL.PatternElement;
import org.eclipse.m2m.atl.common.ATL.Rule;
import org.eclipse.m2m.atl.common.ATL.SimpleInPatternElement;
import org.eclipse.m2m.atl.common.ATL.SimpleOutPatternElement;
import org.eclipse.m2m.atl.common.OCL.Attribute;
import org.eclipse.m2m.atl.common.OCL.BooleanExp;
import org.eclipse.m2m.atl.common.OCL.IfExp;
import org.eclipse.m2m.atl.common.OCL.IntegerExp;
import org.eclipse.m2m.atl.common.OCL.NavigationOrAttributeCallExp;
import org.eclipse.m2m.atl.common.OCL.OCLPackage;
import org.eclipse.m2m.atl.common.OCL.OclContextDefinition;
import org.eclipse.m2m.atl.common.OCL.OclExpression;
import org.eclipse.m2m.atl.common.OCL.OclFeature;
import org.eclipse.m2m.atl.common.OCL.OclFeatureDefinition;
import org.eclipse.m2m.atl.common.OCL.OclModel;
import org.eclipse.m2m.atl.common.OCL.OclModelElement;
import org.eclipse.m2m.atl.common.OCL.OclType;
import org.eclipse.m2m.atl.common.OCL.OperationCallExp;
import org.eclipse.m2m.atl.common.OCL.OperatorCallExp;
import org.eclipse.m2m.atl.common.OCL.StringExp;
import org.eclipse.m2m.atl.common.OCL.VariableExp;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.BooleanType;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NestedPackageId;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.UnboxedCompositionProperty;
import org.eclipse.ocl.pivot.internal.library.executor.AbstractEvaluationOperation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIsEmptyOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionNotEmptyOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBooleanExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclType;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TxATL2QVTr;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrFactory;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;
import org.eclipse.qvtd.atl.atl2qvtr.utilities.Helper4getCommonType;
import org.eclipse.qvtd.atl.atl2qvtr.utilities.Helper4getModule;
import org.eclipse.qvtd.atl.atl2qvtr.utilities.Helper4getOperation;
import org.eclipse.qvtd.atl.atl2qvtr.utilities.Helper4getPackage;
import org.eclipse.qvtd.atl.atl2qvtr.utilities.Helper4getProperty;
import org.eclipse.qvtd.atl.atl2qvtr.utilities.Helper4getType;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationFactory;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.SharedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateFactory;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;
import org.eclipse.qvtd.runtime.evaluation.AbstractComputation;
import org.eclipse.qvtd.runtime.evaluation.AbstractInvocation;
import org.eclipse.qvtd.runtime.evaluation.AbstractSimpleInvocation;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.InvalidEvaluationException;
import org.eclipse.qvtd.runtime.evaluation.InvocationConstructor;
import org.eclipse.qvtd.runtime.evaluation.InvocationFailedException;
import org.eclipse.qvtd.runtime.evaluation.ModeFactory;
import org.eclipse.qvtd.runtime.evaluation.SlotState;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractComputationConstructor;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractInvocationConstructor;
import org.eclipse.qvtd.runtime.internal.evaluation.RuntimeModelsManager;
import org.eclipse.qvtd.runtime.qvttrace.QVTtracePackage;

/**
 * The ATL2QVTr transformation:
 * <p>
 * Construct with an evaluator
 * <br>
 * Populate each input model with {@link addRootEObjects(String,List)}
 * <br>
 * {@link run()}
 * <br>
 * Extract each output model with {@link getRootEObjects(String)}
 */
@SuppressWarnings({"restriction","unused"})
public class ATL2QVTr extends AbstractTransformer
{
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_org = IdManager.getRootPackageId("org");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_ = TypeId.BAG;
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId COL_ = TypeId.COLLECTION;
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_ = TypeId.ORDERED_SET;
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_ = TypeId.SEQUENCE;
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_ = TypeId.SET;
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr = IdManager.getNsURIPackageId("http://QVTd_CompileQVTrTransformation__atl2qvtr/org/eclipse/qvtd/atl/atl2qvtr/ATL2QVTr", "PATL2QVTr", trace_ATL2QVTrPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL = IdManager.getNsURIPackageId("http://www.eclipse.org/gmt/2005/ATL", null, ATLPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL = IdManager.getNsURIPackageId("http://www.eclipse.org/gmt/2005/OCL", null, OCLPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbase", null, QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTrelation", null, QVTrelationPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTtemplate = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTtemplate", null, QVTtemplatePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2018_s_QVTtrace = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2018/QVTtrace", null, QVTtracePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_eclipse = PACKid_org.getNestedPackageId("eclipse");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_TMPLid_ = TypeId.BAG.getSpecializedId(TypeId.T_2, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_TMPLid__0 = TypeId.BAG.getSpecializedId(TypeId.T_2, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Attribute = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("Attribute", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Binding = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("Binding", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BooleanExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("BooleanExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BooleanLiteralExp = PACKid_$metamodel$.getClassId("BooleanLiteralExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BooleanType = PACKid_$metamodel$.getClassId("BooleanType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DmapHelper = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("DmapHelper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DmapOclExpression = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("DmapOclExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DmapVariableExp_referredVariable = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("DmapVariableExp_referredVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DomainPattern = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("DomainPattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Function = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Function", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_FunctionParameter = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("FunctionParameter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Helper = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("Helper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_IfExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("IfExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_IfExp_0 = PACKid_$metamodel$.getClassId("IfExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ImapHelper = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("ImapHelper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ImapOclExpression = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("ImapOclExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ImapVariableExp_referredVariable = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("ImapVariableExp_referredVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_InPattern = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("InPattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_InPatternElement = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("InPatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_IntegerExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("IntegerExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_IntegerLiteralExp = PACKid_$metamodel$.getClassId("IntegerLiteralExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_LocatedElement = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("LocatedElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MatchedRule = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("MatchedRule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Module = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("Module", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ModuleElement = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("ModuleElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_NavigationOrAttributeCallExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("NavigationOrAttributeCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OCLExpression = PACKid_$metamodel$.getClassId("OCLExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ObjectTemplateExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTtemplate.getClassId("ObjectTemplateExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclContextDefinition = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("OclContextDefinition", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclExpression = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("OclExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclFeature = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("OclFeature", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclFeatureDefinition = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("OclFeatureDefinition", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclModel = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("OclModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclModelElement = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("OclModelElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclType = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("OclType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Operation = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Operation_0 = PACKid_$metamodel$.getClassId("Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OperationCallExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("OperationCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OperationCallExp_0 = PACKid_$metamodel$.getClassId("OperationCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OperatorCallExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("OperatorCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OutPattern = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("OutPattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OutPatternElement = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("OutPatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Package = PACKid_$metamodel$.getClassId("Package", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Parameter = PACKid_$metamodel$.getClassId("Parameter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Pattern = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Pattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_PatternElement = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("PatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Predicate = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Predicate", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_PrimitiveType = PACKid_$metamodel$.getClassId("PrimitiveType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Property = PACKid_$metamodel$.getClassId("Property", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_PropertyCallExp = PACKid_$metamodel$.getClassId("PropertyCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_PropertyTemplateItem = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTtemplate.getClassId("PropertyTemplateItem", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Relation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("Relation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelationDomain = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("RelationDomain", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelationModel = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("RelationModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelationalTransformation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("RelationalTransformation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Rule = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("Rule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Rule_0 = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Rule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_SharedVariable = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("SharedVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_SimpleInPatternElement = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("SimpleInPatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_SimpleOutPatternElement = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("SimpleOutPatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_StringExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("StringExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_StringLiteralExp = PACKid_$metamodel$.getClassId("StringLiteralExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TemplateExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTtemplate.getClassId("TemplateExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TemplateVariable = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("TemplateVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapBinding = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapBinding", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapBooleanExp = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapBooleanExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapHelper_Attribute = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapHelper_Attribute", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapHelper_Context = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapHelper_Context", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapHelper_Operation = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapHelper_Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapIfExp = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapIfExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapInPattern = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapInPattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapInPattern_filter = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapInPattern_filter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapIntegerExp = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapIntegerExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapMatchedRule = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapMatchedRule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapMatchedRule_super = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapMatchedRule_super", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapModule = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapModule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapNavigationOrAttributeCallExp_Helper = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapNavigationOrAttributeCallExp_Helper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapNavigationOrAttributeCallExp_Property = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapNavigationOrAttributeCallExp_Property", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOclMetamodel = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOclMetamodel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOclModel_IN = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOclModel_IN", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOclModel_OUT = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOclModel_OUT", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOclType = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOclType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOperationCallExp_Helper = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOperationCallExp_Helper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOperationCallExp_Operation = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOperationCallExp_Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOperationCallExp_argument = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOperationCallExp_argument", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOperatorCallExp = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOperatorCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapSimpleInPatternElement = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapSimpleInPatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapSimpleOutPatternElement = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapSimpleOutPatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapStringExp = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapStringExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapVariable = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapVariableExp = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapVariableExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapVariableExp_referredVariable_Helper = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapVariableExp_referredVariable_Helper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapVariableExp_referredVariable_VariableDeclaration = PACKid_http_c_s_s_QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapVariableExp_referredVariable_VariableDeclaration", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TraceElement = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2018_s_QVTtrace.getClassId("TraceElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Transformation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Transformation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Type = PACKid_$metamodel$.getClassId("Type", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TypedModel = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("TypedModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Variable = PACKid_$metamodel$.getClassId("Variable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableDeclaration = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("VariableDeclaration", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableDeclaration_0 = PACKid_$metamodel$.getClassId("VariableDeclaration", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("VariableExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableExp_0 = PACKid_$metamodel$.getClassId("VariableExp", 0);
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_0 = ValueUtil.integerValueOf("0");
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_1 = ValueUtil.integerValueOf("1");
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_2 = ValueUtil.integerValueOf("2");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_TMPLid_ = TypeId.ORDERED_SET.getSpecializedId(TypeId.T_2, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_TMPLid_ = TypeId.SEQUENCE.getSpecializedId(TypeId.T_2, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_TMPLid__0 = TypeId.SEQUENCE.getSpecializedId(TypeId.T_2, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_TMPLid__1 = TypeId.SEQUENCE.getSpecializedId(TypeId.T_2, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_PRIMid_OclSelf = TypeId.SET.getSpecializedId(TypeId.OCL_SELF, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_TMPLid_ = TypeId.SET.getSpecializedId(TypeId.T_2, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull String STR_ = "";
	public static final /*@NonInvalid*/ @NonNull String STR_middle = "middle";
	public static final /*@NonInvalid*/ @NonNull String STR_self = "self";
	public static final /*@NonInvalid*/ @NonNull String STR_this = "this";
	public static final /*@NonInvalid*/ @NonNull String STR_trace = "trace";
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_qvtd = PACKid_eclipse.getNestedPackageId("qvtd");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_OclModelElement = TypeId.BAG.getSpecializedId(CLSSid_OclModelElement, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_OclType = TypeId.BAG.getSpecializedId(CLSSid_OclType, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Helper = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Helper, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_ModuleElement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ModuleElement, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_OCLExpression = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OCLExpression, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_OclModel = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OclModel, true, ValueUtil.ONE_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Rule = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Rule_0, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Variable = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Variable, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Attribute = TypeId.SEQUENCE.getSpecializedId(CLSSid_Attribute, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_OclFeature = TypeId.SEQUENCE.getSpecializedId(CLSSid_OclFeature, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_OclFeatureDefinition = TypeId.SEQUENCE.getSpecializedId(CLSSid_OclFeatureDefinition, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Operation = TypeId.SEQUENCE.getSpecializedId(CLSSid_Operation, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Helper = TypeId.SET.getSpecializedId(CLSSid_Helper, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_InPatternElement = TypeId.SET.getSpecializedId(CLSSid_InPatternElement, true, ValueUtil.ONE_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_LocatedElement = TypeId.SET.getSpecializedId(CLSSid_LocatedElement, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_OclElement = TypeId.SET.getSpecializedId(CLSSid_OclElement, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_OclModel = TypeId.SET.getSpecializedId(CLSSid_OclModel, true, ValueUtil.ONE_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Package = TypeId.SET.getSpecializedId(CLSSid_Package, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Variable = TypeId.SET.getSpecializedId(CLSSid_Variable, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_d3atlHelper = CLSSid_DmapHelper.getPropertyId("d3atlHelper");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_d3atlExpression = CLSSid_DmapOclExpression.getPropertyId("d3atlExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlPattern = CLSSid_TmapInPattern.getPropertyId("t3atlPattern");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3matchedRule = CLSSid_TmapMatchedRule.getPropertyId("t3matchedRule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlModule = CLSSid_TmapModule.getPropertyId("t3atlModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3oclMetamodel = CLSSid_TmapOclMetamodel.getPropertyId("t3oclMetamodel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlElement = CLSSid_TmapSimpleOutPatternElement.getPropertyId("t3atlElement");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlVariable = CLSSid_TmapVariable.getPropertyId("t3atlVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrVariable = CLSSid_TmapVariable.getPropertyId("t4qvtrVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_definition = CLSSid_Helper.getPropertyId("definition");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_inModels = CLSSid_Module.getPropertyId("inModels");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_outModels = CLSSid_Module.getPropertyId("outModels");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_Helper = CLSSid_OclFeatureDefinition.getPropertyId("Helper");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_Module = CLSSid_OclModel.getPropertyId("Module");
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_atl = PACKid_qvtd.getNestedPackageId("atl");
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_atl2qvtr = PACKid_atl.getNestedPackageId("atl2qvtr");
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ATL2QVTr = PACKid_atl2qvtr.getClassId("ATL2QVTr", 0);
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_ATL2QVTr = PACKid_atl2qvtr.getNestedPackageId("ATL2QVTr");
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CACHE_ATL2QVTr_getCommonType = PACKid_ATL2QVTr.getClassId("CACHE_ATL2QVTr_getCommonType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CACHE_ATL2QVTr_getHelper = PACKid_ATL2QVTr.getClassId("CACHE_ATL2QVTr_getHelper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CACHE_ATL2QVTr_getModule = PACKid_ATL2QVTr.getClassId("CACHE_ATL2QVTr_getModule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CACHE_ATL2QVTr_getOperation = PACKid_ATL2QVTr.getClassId("CACHE_ATL2QVTr_getOperation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CACHE_ATL2QVTr_getPackage = PACKid_ATL2QVTr.getClassId("CACHE_ATL2QVTr_getPackage", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CACHE_ATL2QVTr_getProperty = PACKid_ATL2QVTr.getClassId("CACHE_ATL2QVTr_getProperty", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CACHE_ATL2QVTr_getType = PACKid_ATL2QVTr.getClassId("CACHE_ATL2QVTr_getType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ENTRY_ATL2QVTr_getCommonType = PACKid_ATL2QVTr.getClassId("ENTRY_ATL2QVTr_getCommonType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ENTRY_ATL2QVTr_getHelper = PACKid_ATL2QVTr.getClassId("ENTRY_ATL2QVTr_getHelper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ENTRY_ATL2QVTr_getModule = PACKid_ATL2QVTr.getClassId("ENTRY_ATL2QVTr_getModule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ENTRY_ATL2QVTr_getOperation = PACKid_ATL2QVTr.getClassId("ENTRY_ATL2QVTr_getOperation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ENTRY_ATL2QVTr_getPackage = PACKid_ATL2QVTr.getClassId("ENTRY_ATL2QVTr_getPackage", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ENTRY_ATL2QVTr_getProperty = PACKid_ATL2QVTr.getClassId("ENTRY_ATL2QVTr_getProperty", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ENTRY_ATL2QVTr_getType = PACKid_ATL2QVTr.getClassId("ENTRY_ATL2QVTr_getType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RULE_CACHE_DmapVariableExp_referredVariable = PACKid_ATL2QVTr.getClassId("RULE_CACHE_DmapVariableExp_referredVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RULE_CACHE_TmapHelper_Context = PACKid_ATL2QVTr.getClassId("RULE_CACHE_TmapHelper_Context", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RULE_CACHE_TmapVariable = PACKid_ATL2QVTr.getClassId("RULE_CACHE_TmapVariable", 0);

	protected final @NonNull ATL2QVTr rootThis = this;
	protected final RuntimeModelsManager.@NonNull Model MODEL_atl;
	protected final RuntimeModelsManager.@NonNull Model MODEL_qvtr;
	protected final RuntimeModelsManager.@NonNull Model MODEL_middle;

	/*
	 * Property-source to Property-target unnavigable navigation caches
	 */
	protected final @NonNull Map<Helper,DmapHelper> OPPOSITE_OF_DmapHelper_d3atlHelper = new HashMap<>();
	protected final @NonNull Map<OclExpression,DmapOclExpression> OPPOSITE_OF_DmapOclExpression_d3atlExpression = new HashMap<>();
	protected final @NonNull Map<InPattern,TmapInPattern> OPPOSITE_OF_TmapInPattern_t3atlPattern = new HashMap<>();
	protected final @NonNull Map<MatchedRule,TmapMatchedRule> OPPOSITE_OF_TmapMatchedRule_t3matchedRule = new HashMap<>();
	protected final @NonNull Map<Module,TmapModule> OPPOSITE_OF_TmapModule_t3atlModule = new HashMap<>();
	protected final @NonNull Map<OclModel,TmapOclMetamodel> OPPOSITE_OF_TmapOclMetamodel_t3oclMetamodel = new HashMap<>();
	protected final @NonNull Map<SimpleOutPatternElement,TmapSimpleOutPatternElement> OPPOSITE_OF_TmapSimpleOutPatternElement_t3atlElement = new HashMap<>();
	protected final @NonNull Map<LocatedElement,TmapVariable> OPPOSITE_OF_TmapVariable_t3atlVariable = new HashMap<>();
	protected final @NonNull Map<VariableDeclaration,TmapVariable> OPPOSITE_OF_TmapVariable_t4qvtrVariable = new HashMap<>();

	/*
	 * Array of the source PropertyIds of each Property for which unnavigable opposite property navigation may occur.
	 */
	private static final @NonNull PropertyId @NonNull [] oppositeIndex2propertyIdName = new @NonNull PropertyId[]{
		PROPid_d3atlExpression,		// 0 => d3atlExpression
		PROPid_t3atlModule,		// 1 => t3atlModule
		PROPid_t3oclMetamodel,		// 2 => t3oclMetamodel
		PROPid_t3matchedRule,		// 3 => t3matchedRule
		PROPid_d3atlHelper,		// 4 => d3atlHelper
		PROPid_t3atlPattern,		// 5 => t3atlPattern
		PROPid_t3atlElement,		// 6 => t3atlElement
		PROPid_t3atlVariable,		// 7 => t3atlVariable
		PROPid_t4qvtrVariable		// 8 => t4qvtrVariable
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_r_ATL2QVTr__qvtr__load__ = new AbstractInvocationConstructor(invocationManager, "MAP_r_ATL2QVTr__qvtr__load__", false, lazyCreateInterval(0))
	{
		@Override
		public @NonNull MAP_r_ATL2QVTr__qvtr__load__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_r_ATL2QVTr__qvtr__load__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_mmapHelper__Attribute__qvtr__loop__ = new AbstractInvocationConstructor(invocationManager, "MAP_mmapHelper__Attribute__qvtr__loop__", true, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapHelper__Attribute__qvtr__loop__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapHelper__Attribute__qvtr__loop__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_mmapHelper__Context__qvtr__loop__ = new AbstractInvocationConstructor(invocationManager, "MAP_mmapHelper__Context__qvtr__loop__", true, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapHelper__Context__qvtr__loop__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapHelper__Context__qvtr__loop__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_mmapHelper__Operation__qvtr__loop__ = new AbstractInvocationConstructor(invocationManager, "MAP_mmapHelper__Operation__qvtr__loop__", true, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapHelper__Operation__qvtr__loop__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapHelper__Operation__qvtr__loop__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_mmapHelper__verdict__qvtr = new AbstractInvocationConstructor(invocationManager, "MAP_mmapHelper__verdict__qvtr", false, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapHelper__verdict__qvtr newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapHelper__verdict__qvtr(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__ini = new AbstractInvocationConstructor(invocationManager, "MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__ini", false, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__ini newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__ini(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__loo = new AbstractInvocationConstructor(invocationManager, "MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__loo", true, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__loo newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__loo(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__l = new AbstractInvocationConstructor(invocationManager, "MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__l", true, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__l newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__l(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_mmapOclExpression__verdict__qvtr = new AbstractInvocationConstructor(invocationManager, "MAP_mmapOclExpression__verdict__qvtr", false, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapOclExpression__verdict__qvtr newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOclExpression__verdict__qvtr(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_mmapOperationCallExp__Helper__qvtr__init__ = new AbstractInvocationConstructor(invocationManager, "MAP_mmapOperationCallExp__Helper__qvtr__init__", false, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapOperationCallExp__Helper__qvtr__init__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperationCallExp__Helper__qvtr__init__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_mmapOperationCallExp__Helper__qvtr__loop__ = new AbstractInvocationConstructor(invocationManager, "MAP_mmapOperationCallExp__Helper__qvtr__loop__", true, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapOperationCallExp__Helper__qvtr__loop__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperationCallExp__Helper__qvtr__loop__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_mmapOperationCallExp__Operation__qvtr__loop__ = new AbstractInvocationConstructor(invocationManager, "MAP_mmapOperationCallExp__Operation__qvtr__loop__", true, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapOperationCallExp__Operation__qvtr__loop__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperationCallExp__Operation__qvtr__loop__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_mmapOperatorCallExp__qvtr__loop__ = new AbstractInvocationConstructor(invocationManager, "MAP_mmapOperatorCallExp__qvtr__loop__", true, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapOperatorCallExp__qvtr__loop__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperatorCallExp__qvtr__loop__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_mmapVariableExp__referredVariable__Helper__qvtr__lo = new AbstractInvocationConstructor(invocationManager, "MAP_mmapVariableExp__referredVariable__Helper__qvtr__lo", false, lazyCreateInterval(8))
	{
		@Override
		public @NonNull MAP_mmapVariableExp__referredVariable__Helper__qvtr__lo newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapVariableExp__referredVariable__Helper__qvtr__lo(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_mmapIfExp__qvtr__xtra__ = new AbstractInvocationConstructor(invocationManager, "MAP_mmapIfExp__qvtr__xtra__", false, lazyCreateInterval(10))
	{
		@Override
		public @NonNull MAP_mmapIfExp__qvtr__xtra__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapIfExp__qvtr__xtra__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__x = new AbstractInvocationConstructor(invocationManager, "MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__x", true, lazyCreateInterval(10))
	{
		@Override
		public @NonNull MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__x newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__x(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_mmapOperationCallExp__Operation__qvtr__xtra__ = new AbstractInvocationConstructor(invocationManager, "MAP_mmapOperationCallExp__Operation__qvtr__xtra__", true, lazyCreateInterval(10))
	{
		@Override
		public @NonNull MAP_mmapOperationCallExp__Operation__qvtr__xtra__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperationCallExp__Operation__qvtr__xtra__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_mmapOperatorCallExp__qvtr__xtra__ = new AbstractInvocationConstructor(invocationManager, "MAP_mmapOperatorCallExp__qvtr__xtra__", true, lazyCreateInterval(10))
	{
		@Override
		public @NonNull MAP_mmapOperatorCallExp__qvtr__xtra__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperatorCallExp__qvtr__xtra__(this, values);
		}
	};

	/*
	 * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex for TypedModel 2.
	 */
	private static final @NonNull ClassId @NonNull [] classIndex2classId_2 = new @NonNull ClassId[]{
		CLSSid_Binding,                       // 0 => Binding
		CLSSid_Helper,                        // 1 => Helper
		CLSSid_InPattern,                     // 2 => InPattern
		CLSSid_MatchedRule,                   // 3 => MatchedRule
		CLSSid_Module,                        // 4 => Module
		CLSSid_NavigationOrAttributeCallExp,  // 5 => NavigationOrAttributeCallExp
		CLSSid_OclExpression,                 // 6 => OclExpression
		CLSSid_OclModel,                      // 7 => OclModel
		CLSSid_OperationCallExp,              // 8 => OperationCallExp
		CLSSid_SimpleInPatternElement,        // 9 => SimpleInPatternElement
		CLSSid_SimpleOutPatternElement,       // 10 => SimpleOutPatternElement
		CLSSid_VariableExp                    // 11 => VariableExp
	};

	/*
	 * Mapping from each TypedModel 2 ClassIndex to all the ClassIndexes
	 * to which an object of the outer index may contribute results to an allInstances() invocation.
	 * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
	 * instance of the derived classId contributes to derived and inherited ClassIndexes.
	 */
	private final static int @NonNull [] @NonNull [] classIndex2allClassIndexes_2 = new int @NonNull [] @NonNull [] {
		{0},                          // 0 : Binding -> {Binding}
		{1},                          // 1 : Helper -> {Helper}
		{2},                          // 2 : InPattern -> {InPattern}
		{3},                          // 3 : MatchedRule -> {MatchedRule}
		{4},                          // 4 : Module -> {Module}
		{5,6},                        // 5 : NavigationOrAttributeCallExp -> {NavigationOrAttributeCallExp,OclExpression}
		{6},                          // 6 : OclExpression -> {OclExpression}
		{7},                          // 7 : OclModel -> {OclModel}
		{8,6},                        // 8 : OperationCallExp -> {OperationCallExp,OclExpression}
		{9},                          // 9 : SimpleInPatternElement -> {SimpleInPatternElement}
		{10},                         // 10 : SimpleOutPatternElement -> {SimpleOutPatternElement}
		{11,6}                        // 11 : VariableExp -> {VariableExp,OclExpression}
	};

	// CacheInstancePropertyCallingConvention
	public final /*@NonInvalid*/ org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.@NonNull CACHE_ATL2QVTr_getCommonType INSTANCE_CACHE_ATL2QVTr_getCommonType;
	// CacheInstancePropertyCallingConvention
	public final /*@NonInvalid*/ org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.@NonNull CACHE_ATL2QVTr_getHelper INSTANCE_CACHE_ATL2QVTr_getHelper;
	// CacheInstancePropertyCallingConvention
	public final /*@NonInvalid*/ org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.@NonNull CACHE_ATL2QVTr_getModule INSTANCE_CACHE_ATL2QVTr_getModule;
	// CacheInstancePropertyCallingConvention
	public final /*@NonInvalid*/ org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.@NonNull CACHE_ATL2QVTr_getOperation INSTANCE_CACHE_ATL2QVTr_getOperation;
	// CacheInstancePropertyCallingConvention
	public final /*@NonInvalid*/ org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.@NonNull CACHE_ATL2QVTr_getPackage INSTANCE_CACHE_ATL2QVTr_getPackage;
	// CacheInstancePropertyCallingConvention
	public final /*@NonInvalid*/ org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.@NonNull CACHE_ATL2QVTr_getProperty INSTANCE_CACHE_ATL2QVTr_getProperty;
	// CacheInstancePropertyCallingConvention
	public final /*@NonInvalid*/ org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.@NonNull CACHE_ATL2QVTr_getType INSTANCE_CACHE_ATL2QVTr_getType;
	// DefaultInstancePropertyCallingConvention
	protected final /*@NonInvalid*/ org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.@NonNull RULE_CACHE_DmapVariableExp_referredVariable INSTANCE_RULE_CACHE_DmapVariableExp_referredVariable;
	// DefaultInstancePropertyCallingConvention
	protected final /*@NonInvalid*/ org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.@NonNull RULE_CACHE_TmapHelper_Context INSTANCE_RULE_CACHE_TmapHelper_Context;
	// DefaultInstancePropertyCallingConvention
	protected final /*@NonInvalid*/ org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.@NonNull RULE_CACHE_TmapVariable INSTANCE_RULE_CACHE_TmapVariable;

	public ATL2QVTr(final @NonNull TransformationExecutor rootExecutor) {
		super(rootExecutor, 5);
		// CacheInstancePropertyCallingConvention
		this.INSTANCE_CACHE_ATL2QVTr_getModule = new org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.CACHE_ATL2QVTr_getModule();
		// DefaultInstancePropertyCallingConvention
		this.INSTANCE_RULE_CACHE_DmapVariableExp_referredVariable = new org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.RULE_CACHE_DmapVariableExp_referredVariable();
		// CacheInstancePropertyCallingConvention
		this.INSTANCE_CACHE_ATL2QVTr_getType = new org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.CACHE_ATL2QVTr_getType();
		// CacheInstancePropertyCallingConvention
		this.INSTANCE_CACHE_ATL2QVTr_getPackage = new org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.CACHE_ATL2QVTr_getPackage();
		// DefaultInstancePropertyCallingConvention
		this.INSTANCE_RULE_CACHE_TmapVariable = new org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.RULE_CACHE_TmapVariable();
		// DefaultInstancePropertyCallingConvention
		this.INSTANCE_RULE_CACHE_TmapHelper_Context = new org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.RULE_CACHE_TmapHelper_Context();
		// CacheInstancePropertyCallingConvention
		this.INSTANCE_CACHE_ATL2QVTr_getHelper = new org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.CACHE_ATL2QVTr_getHelper();
		// CacheInstancePropertyCallingConvention
		this.INSTANCE_CACHE_ATL2QVTr_getProperty = new org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.CACHE_ATL2QVTr_getProperty();
		// CacheInstancePropertyCallingConvention
		this.INSTANCE_CACHE_ATL2QVTr_getCommonType = new org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.CACHE_ATL2QVTr_getCommonType();
		// CacheInstancePropertyCallingConvention
		this.INSTANCE_CACHE_ATL2QVTr_getOperation = new org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.CACHE_ATL2QVTr_getOperation();
		initOpposites(oppositeIndex2propertyIdName);
		initModel(0, "$primitive$");
		initModel(1, "$this$");
		MODEL_atl = initModel(2, "atl");
		MODEL_qvtr = initModel(3, "qvtr");
		MODEL_middle = initModel(4, "middle");
		MODEL_atl.initClassIds(classIndex2classId_2, classIndex2allClassIndexes_2);
		initConnections();
	}

	private @Nullable TxATL2QVTr transformationExecution = null;

	@Override
	public @Nullable TxATL2QVTr getTransformationExecution(@Nullable Object o) {
		if (transformationExecution == null) {
			transformationExecution = trace_ATL2QVTrFactory.eINSTANCE.createTxATL2QVTr();
		}
		return transformationExecution;
	}

	@Override
	public boolean run(@NonNull String targetName) {
		return run();
	}

	@Override
	public boolean run() {
		initSpeculatedEAttributes(trace_ATL2QVTrPackage.Literals.IMAP_VARIABLE_EXP_REFERRED_VARIABLE__S0GLOBAL,
			trace_ATL2QVTrPackage.Literals.DMAP_HELPER__S0GLOBAL,
			trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL,
			trace_ATL2QVTrPackage.Literals.TMAP_VARIABLE__S0GLOBAL,
			trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL,
			trace_ATL2QVTrPackage.Literals.IMAP_HELPER__S0GLOBAL);
		final @NonNull Connection ji_Binding = MODEL_atl.getConnection(0/*ATL::Binding*/);
		final @NonNull Connection ji_Helper = MODEL_atl.getConnection(1/*ATL::Helper*/);
		final @NonNull Connection ji_InPattern = MODEL_atl.getConnection(2/*ATL::InPattern*/);
		final @NonNull Connection ji_MatchedRule = MODEL_atl.getConnection(3/*ATL::MatchedRule*/);
		final @NonNull Connection ji_Module = MODEL_atl.getConnection(4/*ATL::Module*/);
		final @NonNull Connection ji_NavigationOrAttributeCallExp = MODEL_atl.getConnection(5/*OCL::NavigationOrAttributeCallExp*/);
		final @NonNull Connection ji_OclExpression = MODEL_atl.getConnection(6/*OCL::OclExpression*/);
		final @NonNull Connection ji_OclModel = MODEL_atl.getConnection(7/*OCL::OclModel*/);
		final @NonNull Connection ji_OperationCallExp = MODEL_atl.getConnection(8/*OCL::OperationCallExp*/);
		final @NonNull Connection ji_SimpleInPatternElement = MODEL_atl.getConnection(9/*ATL::SimpleInPatternElement*/);
		final @NonNull Connection ji_SimpleOutPatternElement = MODEL_atl.getConnection(10/*ATL::SimpleOutPatternElement*/);
		final @NonNull Connection ji_VariableExp = MODEL_atl.getConnection(11/*OCL::VariableExp*/);
		CTOR_MAP_r_ATL2QVTr__qvtr__load__.invoke(ji_Binding, ji_Helper, ji_InPattern, ji_MatchedRule, ji_Module, ji_NavigationOrAttributeCallExp, ji_OclExpression, ji_OclModel, ji_OperationCallExp, ji_SimpleInPatternElement, ji_SimpleOutPatternElement, ji_VariableExp);
		return invocationManager.flush();
	}
	/**
	 * The instance of CACHE_ATL2QVTr_getCommonType caches all known evaluations of
	 *
	 * getCommonType(type1 : Type[1], type2 : Type[1]) : Type[1]
	 */
	// RootCacheClassCallingConvention
	public class CACHE_ATL2QVTr_getCommonType extends AbstractComputationConstructor
	{
		// CacheConstructorOperationCallingConvention
		public CACHE_ATL2QVTr_getCommonType() {
			super(rootExecutor, rootThis);
		}

		// ExternalEvaluateOperationCallingConvention
		public /*@NonInvalid*/ @NonNull Type evaluate(final /*@NonInvalid*/ @NonNull Object self_0, final /*@NonInvalid*/ @NonNull Type type1, final /*@NonInvalid*/ @NonNull Type type2) {
			return ((ENTRY_ATL2QVTr_getCommonType)getUniqueComputation(self_0, type1, type2)).cachedResult;
		}

		// CacheNewInstanceOperationCallingConvention
		@Override
		public /*@NonInvalid*/ org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.@NonNull ENTRY_ATL2QVTr_getCommonType newInstance(final /*@NonInvalid*/ @Nullable Object @NonNull [] boxedValues) {
			return new org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.ENTRY_ATL2QVTr_getCommonType((@NonNull Object @NonNull [])boxedValues);
		}
	}
	/**
	 * The instance of CACHE_ATL2QVTr_getHelper caches all known evaluations of
	 *
	 * getHelper(element : ATL::LocatedElement[1]) : ATL::Helper[?]
	 */
	// DefaultCacheClassCallingConvention
	public class CACHE_ATL2QVTr_getHelper extends AbstractComputationConstructor
	{
		// CacheConstructorOperationCallingConvention
		public CACHE_ATL2QVTr_getHelper() {
			super(rootExecutor, rootThis);
		}

		// FunctionEvaluateOperationCallingConvention
		public /*@NonInvalid*/ @Nullable Helper evaluate(final /*@NonInvalid*/ @NonNull LocatedElement element) {
			return ((ENTRY_ATL2QVTr_getHelper)getUniqueComputation(rootThis, element)).cachedResult;
		}

		// CacheNewInstanceOperationCallingConvention
		@Override
		public /*@NonInvalid*/ org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.@NonNull ENTRY_ATL2QVTr_getHelper newInstance(final /*@NonInvalid*/ @Nullable Object @NonNull [] boxedValues) {
			return new org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.ENTRY_ATL2QVTr_getHelper((@NonNull Object @NonNull [])boxedValues);
		}
	}
	/**
	 * The instance of CACHE_ATL2QVTr_getModule caches all known evaluations of
	 *
	 * getModule(element : ATL::LocatedElement[1]) : ATL::Module[1]
	 */
	// RootCacheClassCallingConvention
	public class CACHE_ATL2QVTr_getModule extends AbstractComputationConstructor
	{
		// CacheConstructorOperationCallingConvention
		public CACHE_ATL2QVTr_getModule() {
			super(rootExecutor, rootThis);
		}

		// ExternalEvaluateOperationCallingConvention
		public /*@NonInvalid*/ @NonNull Module evaluate(final /*@NonInvalid*/ @NonNull Object self_0, final /*@NonInvalid*/ @NonNull LocatedElement element) {
			return ((ENTRY_ATL2QVTr_getModule)getUniqueComputation(self_0, element)).cachedResult;
		}

		// CacheNewInstanceOperationCallingConvention
		@Override
		public /*@NonInvalid*/ org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.@NonNull ENTRY_ATL2QVTr_getModule newInstance(final /*@NonInvalid*/ @Nullable Object @NonNull [] boxedValues) {
			return new org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.ENTRY_ATL2QVTr_getModule((@NonNull Object @NonNull [])boxedValues);
		}
	}
	/**
	 * The instance of CACHE_ATL2QVTr_getOperation caches all known evaluations of
	 *
	 * getOperation(type : Type[1], name : String[1]) : Operation[1]
	 */
	// RootCacheClassCallingConvention
	public class CACHE_ATL2QVTr_getOperation extends AbstractComputationConstructor
	{
		// CacheConstructorOperationCallingConvention
		public CACHE_ATL2QVTr_getOperation() {
			super(rootExecutor, rootThis);
		}

		// ExternalEvaluateOperationCallingConvention
		public /*@NonInvalid*/ @NonNull Operation evaluate(final /*@NonInvalid*/ @NonNull Object self_0, final /*@NonInvalid*/ @NonNull Type type, final /*@NonInvalid*/ @NonNull String name) {
			return ((ENTRY_ATL2QVTr_getOperation)getUniqueComputation(self_0, type, name)).cachedResult;
		}

		// CacheNewInstanceOperationCallingConvention
		@Override
		public /*@NonInvalid*/ org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.@NonNull ENTRY_ATL2QVTr_getOperation newInstance(final /*@NonInvalid*/ @Nullable Object @NonNull [] boxedValues) {
			return new org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.ENTRY_ATL2QVTr_getOperation((@NonNull Object @NonNull [])boxedValues);
		}
	}
	/**
	 * The instance of CACHE_ATL2QVTr_getPackage caches all known evaluations of
	 *
	 * getPackage(atlModule : ATL::Module[1], name : String[1]) : Package[1]
	 */
	// RootCacheClassCallingConvention
	public class CACHE_ATL2QVTr_getPackage extends AbstractComputationConstructor
	{
		// CacheConstructorOperationCallingConvention
		public CACHE_ATL2QVTr_getPackage() {
			super(rootExecutor, rootThis);
		}

		// ExternalEvaluateOperationCallingConvention
		public /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Package evaluate(final /*@NonInvalid*/ @NonNull Object self_0, final /*@NonInvalid*/ @NonNull Module atlModule, final /*@NonInvalid*/ @NonNull String name) {
			return ((ENTRY_ATL2QVTr_getPackage)getUniqueComputation(self_0, atlModule, name)).cachedResult;
		}

		// CacheNewInstanceOperationCallingConvention
		@Override
		public /*@NonInvalid*/ org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.@NonNull ENTRY_ATL2QVTr_getPackage newInstance(final /*@NonInvalid*/ @Nullable Object @NonNull [] boxedValues) {
			return new org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.ENTRY_ATL2QVTr_getPackage((@NonNull Object @NonNull [])boxedValues);
		}
	}
	/**
	 * The instance of CACHE_ATL2QVTr_getProperty caches all known evaluations of
	 *
	 * getProperty(type : Type[1], name : String[1]) : Property[1]
	 */
	// RootCacheClassCallingConvention
	public class CACHE_ATL2QVTr_getProperty extends AbstractComputationConstructor
	{
		// CacheConstructorOperationCallingConvention
		public CACHE_ATL2QVTr_getProperty() {
			super(rootExecutor, rootThis);
		}

		// ExternalEvaluateOperationCallingConvention
		public /*@NonInvalid*/ @NonNull Property evaluate(final /*@NonInvalid*/ @NonNull Object self_0, final /*@NonInvalid*/ @NonNull Type type, final /*@NonInvalid*/ @NonNull String name) {
			return ((ENTRY_ATL2QVTr_getProperty)getUniqueComputation(self_0, type, name)).cachedResult;
		}

		// CacheNewInstanceOperationCallingConvention
		@Override
		public /*@NonInvalid*/ org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.@NonNull ENTRY_ATL2QVTr_getProperty newInstance(final /*@NonInvalid*/ @Nullable Object @NonNull [] boxedValues) {
			return new org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.ENTRY_ATL2QVTr_getProperty((@NonNull Object @NonNull [])boxedValues);
		}
	}
	/**
	 * The instance of CACHE_ATL2QVTr_getType caches all known evaluations of
	 *
	 * getType(type : OCL::OclType[?]) : Class[1]
	 */
	// RootCacheClassCallingConvention
	public class CACHE_ATL2QVTr_getType extends AbstractComputationConstructor
	{
		// CacheConstructorOperationCallingConvention
		public CACHE_ATL2QVTr_getType() {
			super(rootExecutor, rootThis);
		}

		// ExternalEvaluateOperationCallingConvention
		public /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class evaluate(final /*@NonInvalid*/ @NonNull Object self_0, final /*@NonInvalid*/ @Nullable OclType type) {
			return ((ENTRY_ATL2QVTr_getType)getUniqueComputation(self_0, type)).cachedResult;
		}

		// CacheNewInstanceOperationCallingConvention
		@Override
		public /*@NonInvalid*/ org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.@NonNull ENTRY_ATL2QVTr_getType newInstance(final /*@NonInvalid*/ @Nullable Object @NonNull [] boxedValues) {
			return new org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.ENTRY_ATL2QVTr_getType(boxedValues);
		}
	}
	/**
	 * Each ENTRY_ATL2QVTr_getCommonType instance caches a distinct evaluation of
	 *
	 * getCommonType(type1 : Type[1], type2 : Type[1]) : Type[1]
	 */
	// ImplementedEntryClassCallingConvention
	protected class ENTRY_ATL2QVTr_getCommonType extends AbstractComputation
	{
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull Object self;
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull Type type1;
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull Type type2;
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull Type cachedResult;

		/**
		 */
		// ImplementedConstructorOperationCallingConvention
		protected ENTRY_ATL2QVTr_getCommonType(final /*@NonInvalid*/ @NonNull Object @NonNull [] boxedValues) {
			final /*@NonInvalid*/ @NonNull Object self = boxedValues[0];
			final /*@NonInvalid*/ @NonNull Type type1 = (Type)boxedValues[1];
			final /*@NonInvalid*/ @NonNull Type type2 = (Type)boxedValues[2];
			this.self = self;
			this.type1 = type1;
			this.type2 = type2;
			final /*@Thrown*/ @NonNull Type evaluate_0 = Helper4getCommonType.INSTANCE.evaluate(rootExecutor, CLSSid_Type, self, type1, type2);
			this.cachedResult = evaluate_0;
		}

		// EntryGetResultOperationCallingConvention
		@Override
		public /*@NonInvalid*/ @NonNull Type getResult() {
			return this.cachedResult;
		}

		/**
		 * Return true if the boxedValues exactly match OCL-wise the values from which this entry was constructed.
		 * If so, the cachedResult can be re-used and no further ENTRY needs construction.
		 */
		// EntryIsEqualOperationCallingConvention
		@Override
		public /*@NonInvalid*/ boolean isEqual(final /*@NonInvalid*/ @NonNull IdResolver idResolver, final /*@NonInvalid*/ @Nullable Object @NonNull [] boxedValues) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Object INDEX_0_boxedValues = (@NonNull Object)boxedValues[0];
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Type INDEX_1_boxedValues = (@NonNull Type)boxedValues[1];
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Type INDEX_2_boxedValues = (@NonNull Type)boxedValues[2];
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(INDEX_0_boxedValues, this.self);
			final /*@NonInvalid*/ boolean and2_0;
			if (!IsEQ_) {
				and2_0 = false;
			}
			else {
				final /*@NonInvalid*/ boolean IsEQ__0 = idResolver.oclEquals(INDEX_0_boxedValues, this.type1);
				and2_0 = IsEQ__0;
			}
			final /*@NonInvalid*/ boolean and2;
			if (!and2_0) {
				and2 = false;
			}
			else {
				final /*@NonInvalid*/ boolean IsEQ__1 = idResolver.oclEquals(INDEX_0_boxedValues, this.type2);
				and2 = IsEQ__1;
			}
			return and2;
		}
	}
	/**
	 * Each ENTRY_ATL2QVTr_getHelper instance caches a distinct evaluation of
	 *
	 * getHelper(element : ATL::LocatedElement[1]) : ATL::Helper[?]
	 */
	// DefaultEntryClassCallingConvention
	protected class ENTRY_ATL2QVTr_getHelper extends AbstractComputation
	{
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull Object contextObject;
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull LocatedElement element;
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @Nullable Helper cachedResult;

		/**
		 *
		 * let
		 *   helpers : Set(ATL::Helper) = element->closure(e | e.oclContainer())
		 *   ->selectByKind(ATL::Helper);
		 *
		 * in if helpers->notEmpty() then helpers->any(true) else null endif
		 */
		// EntryConstructorOperationCallingConvention
		protected ENTRY_ATL2QVTr_getHelper(final /*@NonInvalid*/ @NonNull Object @NonNull [] boxedValues) {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
			final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = rootExecutor.getStandardLibrary();
			final /*@NonInvalid*/ @NonNull Object contextObject = boxedValues[0];
			final /*@NonInvalid*/ @NonNull LocatedElement element = (LocatedElement)boxedValues[1];
			this.contextObject = contextObject;
			this.element = element;
			/*@Caught*/ @Nullable Object CAUGHT_selectByKind;
			try {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ATL_c_c_Helper = idResolver.getClass(CLSSid_Helper, null);
				final /*@NonInvalid*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(rootExecutor, SET_CLSSid_LocatedElement, element);
				final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure = rootExecutor.getStaticTypeOfValue(null, oclAsSet);
				final LibraryIteration.@NonNull LibraryIterationExtension IMPL_closure = (LibraryIteration.LibraryIterationExtension)TYPE_closure.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
				final @NonNull Object ACC_closure = IMPL_closure.createAccumulatorValue(rootExecutor, SET_CLSSid_OclElement, CLSSid_OclElement);
				/**
				 * Implementation of the iterator body.
				 */
				final @NonNull AbstractBinaryOperation BODY_closure = new AbstractBinaryOperation()
				{
					/**
					 * e.oclContainer()
					 */
					@Override
					public @Nullable Object evaluate(final @NonNull Executor rootExecutor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ @Nullable Object e) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull Object CAST_e = (@NonNull Object)e;
						final /*@NonInvalid*/ @Nullable Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(rootExecutor, CAST_e);
						return oclContainer;
					}
				};
				final @NonNull ExecutorSingleIterationManager MGR_closure = new ExecutorSingleIterationManager(rootExecutor, SET_CLSSid_OclElement, BODY_closure, oclAsSet, ACC_closure);
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull SetValue closure = (@NonNull SetValue)IMPL_closure.evaluateIteration(MGR_closure);
				final /*@Thrown*/ @NonNull SetValue selectByKind = (SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(rootExecutor, closure, TYP_ATL_c_c_Helper);
				CAUGHT_selectByKind = selectByKind;
			}
			catch (Exception THROWN_CAUGHT_selectByKind) {
				CAUGHT_selectByKind = ValueUtil.createInvalidValue(THROWN_CAUGHT_selectByKind);
			}
			if (CAUGHT_selectByKind instanceof InvalidValueException) {
				throw (InvalidValueException)CAUGHT_selectByKind;
			}
			final /*@Thrown*/ @Nullable SetValue THROWN_selectByKind = (@Nullable SetValue)CAUGHT_selectByKind;
			final /*@Thrown*/ boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(THROWN_selectByKind).booleanValue();
			/*@Thrown*/ @Nullable Helper IF_notEmpty;
			if (notEmpty) {
				@NonNull Iterator<Object> ITER__1 = THROWN_selectByKind.iterator();
				/*@Thrown*/ @NonNull Helper any_0;
				while (true) {
					if (!ITER__1.hasNext()) {
						throw new InvalidValueException("Nothing to return for ''any''");
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull Helper _1 = (@NonNull Helper)ITER__1.next();
					/**
					 * true
					 */
					//
					if (ValueUtil.TRUE_VALUE) {			// Carry on till something found
						any_0 = _1;
						break;
					}
				}
				IF_notEmpty = any_0;
			}
			else {
				IF_notEmpty = null;
			}
			this.cachedResult = IF_notEmpty;
		}

		// EntryGetResultOperationCallingConvention
		@Override
		public /*@NonInvalid*/ @Nullable Helper getResult() {
			return this.cachedResult;
		}

		/**
		 * Return true if the boxedValues exactly match OCL-wise the values from which this entry was constructed.
		 * If so, the cachedResult can be re-used and no further ENTRY needs construction.
		 */
		// EntryIsEqualOperationCallingConvention
		@Override
		public /*@NonInvalid*/ boolean isEqual(final /*@NonInvalid*/ @NonNull IdResolver idResolver, final /*@NonInvalid*/ @Nullable Object @NonNull [] boxedValues) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Object INDEX_0_boxedValues = (@NonNull Object)boxedValues[0];
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull LocatedElement INDEX_1_boxedValues = (@NonNull LocatedElement)boxedValues[1];
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(INDEX_0_boxedValues, this.contextObject);
			final /*@NonInvalid*/ boolean and2;
			if (!IsEQ_) {
				and2 = false;
			}
			else {
				final /*@NonInvalid*/ boolean IsEQ__0 = idResolver.oclEquals(INDEX_0_boxedValues, this.element);
				and2 = IsEQ__0;
			}
			return and2;
		}
	}
	/**
	 * Each ENTRY_ATL2QVTr_getModule instance caches a distinct evaluation of
	 *
	 * getModule(element : ATL::LocatedElement[1]) : ATL::Module[1]
	 */
	// ImplementedEntryClassCallingConvention
	protected class ENTRY_ATL2QVTr_getModule extends AbstractComputation
	{
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull Object self;
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull LocatedElement element;
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull Module cachedResult;

		/**
		 */
		// ImplementedConstructorOperationCallingConvention
		protected ENTRY_ATL2QVTr_getModule(final /*@NonInvalid*/ @NonNull Object @NonNull [] boxedValues) {
			final /*@NonInvalid*/ @NonNull Object self = boxedValues[0];
			final /*@NonInvalid*/ @NonNull LocatedElement element = (LocatedElement)boxedValues[1];
			this.self = self;
			this.element = element;
			final /*@Thrown*/ @NonNull Module evaluate_0 = Helper4getModule.INSTANCE.evaluate(rootExecutor, CLSSid_Module, self, element);
			this.cachedResult = evaluate_0;
		}

		// EntryGetResultOperationCallingConvention
		@Override
		public /*@NonInvalid*/ @NonNull Module getResult() {
			return this.cachedResult;
		}

		/**
		 * Return true if the boxedValues exactly match OCL-wise the values from which this entry was constructed.
		 * If so, the cachedResult can be re-used and no further ENTRY needs construction.
		 */
		// EntryIsEqualOperationCallingConvention
		@Override
		public /*@NonInvalid*/ boolean isEqual(final /*@NonInvalid*/ @NonNull IdResolver idResolver, final /*@NonInvalid*/ @Nullable Object @NonNull [] boxedValues) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Object INDEX_0_boxedValues = (@NonNull Object)boxedValues[0];
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull LocatedElement INDEX_1_boxedValues = (@NonNull LocatedElement)boxedValues[1];
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(INDEX_0_boxedValues, this.self);
			final /*@NonInvalid*/ boolean and2;
			if (!IsEQ_) {
				and2 = false;
			}
			else {
				final /*@NonInvalid*/ boolean IsEQ__0 = idResolver.oclEquals(INDEX_0_boxedValues, this.element);
				and2 = IsEQ__0;
			}
			return and2;
		}
	}
	/**
	 * Each ENTRY_ATL2QVTr_getOperation instance caches a distinct evaluation of
	 *
	 * getOperation(type : Type[1], name : String[1]) : Operation[1]
	 */
	// ImplementedEntryClassCallingConvention
	protected class ENTRY_ATL2QVTr_getOperation extends AbstractComputation
	{
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull Object self;
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull Type type;
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull String name;
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull Operation cachedResult;

		/**
		 */
		// ImplementedConstructorOperationCallingConvention
		protected ENTRY_ATL2QVTr_getOperation(final /*@NonInvalid*/ @NonNull Object @NonNull [] boxedValues) {
			final /*@NonInvalid*/ @NonNull Object self = boxedValues[0];
			final /*@NonInvalid*/ @NonNull Type type = (Type)boxedValues[1];
			final /*@NonInvalid*/ @NonNull String name = (String)boxedValues[2];
			this.self = self;
			this.type = type;
			this.name = name;
			final /*@Thrown*/ @NonNull Operation evaluate_0 = Helper4getOperation.INSTANCE.evaluate(rootExecutor, CLSSid_Operation_0, self, type, name);
			this.cachedResult = evaluate_0;
		}

		// EntryGetResultOperationCallingConvention
		@Override
		public /*@NonInvalid*/ @NonNull Operation getResult() {
			return this.cachedResult;
		}

		/**
		 * Return true if the boxedValues exactly match OCL-wise the values from which this entry was constructed.
		 * If so, the cachedResult can be re-used and no further ENTRY needs construction.
		 */
		// EntryIsEqualOperationCallingConvention
		@Override
		public /*@NonInvalid*/ boolean isEqual(final /*@NonInvalid*/ @NonNull IdResolver idResolver, final /*@NonInvalid*/ @Nullable Object @NonNull [] boxedValues) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Object INDEX_0_boxedValues = (@NonNull Object)boxedValues[0];
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Type INDEX_1_boxedValues = (@NonNull Type)boxedValues[1];
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String INDEX_2_boxedValues = (@NonNull String)boxedValues[2];
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(INDEX_0_boxedValues, this.self);
			final /*@NonInvalid*/ boolean and2_0;
			if (!IsEQ_) {
				and2_0 = false;
			}
			else {
				final /*@NonInvalid*/ boolean IsEQ__0 = idResolver.oclEquals(INDEX_0_boxedValues, this.type);
				and2_0 = IsEQ__0;
			}
			final /*@NonInvalid*/ boolean and2;
			if (!and2_0) {
				and2 = false;
			}
			else {
				final /*@NonInvalid*/ boolean IsEQ__1 = idResolver.oclEquals(INDEX_0_boxedValues, this.name);
				and2 = IsEQ__1;
			}
			return and2;
		}
	}
	/**
	 * Each ENTRY_ATL2QVTr_getPackage instance caches a distinct evaluation of
	 *
	 * getPackage(atlModule : ATL::Module[1], name : String[1]) : Package[1]
	 */
	// ImplementedEntryClassCallingConvention
	protected class ENTRY_ATL2QVTr_getPackage extends AbstractComputation
	{
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull Object self;
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull Module atlModule;
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull String name;
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Package cachedResult;

		/**
		 */
		// ImplementedConstructorOperationCallingConvention
		protected ENTRY_ATL2QVTr_getPackage(final /*@NonInvalid*/ @NonNull Object @NonNull [] boxedValues) {
			final /*@NonInvalid*/ @NonNull Object self = boxedValues[0];
			final /*@NonInvalid*/ @NonNull Module atlModule = (Module)boxedValues[1];
			final /*@NonInvalid*/ @NonNull String name = (String)boxedValues[2];
			this.self = self;
			this.atlModule = atlModule;
			this.name = name;
			@SuppressWarnings("null")
			final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Package evaluate_0 = (org.eclipse.ocl.pivot.@NonNull Package)Helper4getPackage.INSTANCE.evaluate(rootExecutor, CLSSid_Package, self, atlModule, name);
			this.cachedResult = evaluate_0;
		}

		// EntryGetResultOperationCallingConvention
		@Override
		public /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Package getResult() {
			return this.cachedResult;
		}

		/**
		 * Return true if the boxedValues exactly match OCL-wise the values from which this entry was constructed.
		 * If so, the cachedResult can be re-used and no further ENTRY needs construction.
		 */
		// EntryIsEqualOperationCallingConvention
		@Override
		public /*@NonInvalid*/ boolean isEqual(final /*@NonInvalid*/ @NonNull IdResolver idResolver, final /*@NonInvalid*/ @Nullable Object @NonNull [] boxedValues) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Object INDEX_0_boxedValues = (@NonNull Object)boxedValues[0];
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Module INDEX_1_boxedValues = (@NonNull Module)boxedValues[1];
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String INDEX_2_boxedValues = (@NonNull String)boxedValues[2];
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(INDEX_0_boxedValues, this.self);
			final /*@NonInvalid*/ boolean and2_0;
			if (!IsEQ_) {
				and2_0 = false;
			}
			else {
				final /*@NonInvalid*/ boolean IsEQ__0 = idResolver.oclEquals(INDEX_0_boxedValues, this.atlModule);
				and2_0 = IsEQ__0;
			}
			final /*@NonInvalid*/ boolean and2;
			if (!and2_0) {
				and2 = false;
			}
			else {
				final /*@NonInvalid*/ boolean IsEQ__1 = idResolver.oclEquals(INDEX_0_boxedValues, this.name);
				and2 = IsEQ__1;
			}
			return and2;
		}
	}
	/**
	 * Each ENTRY_ATL2QVTr_getProperty instance caches a distinct evaluation of
	 *
	 * getProperty(type : Type[1], name : String[1]) : Property[1]
	 */
	// ImplementedEntryClassCallingConvention
	protected class ENTRY_ATL2QVTr_getProperty extends AbstractComputation
	{
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull Object self;
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull Type type;
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull String name;
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull Property cachedResult;

		/**
		 */
		// ImplementedConstructorOperationCallingConvention
		protected ENTRY_ATL2QVTr_getProperty(final /*@NonInvalid*/ @NonNull Object @NonNull [] boxedValues) {
			final /*@NonInvalid*/ @NonNull Object self = boxedValues[0];
			final /*@NonInvalid*/ @NonNull Type type = (Type)boxedValues[1];
			final /*@NonInvalid*/ @NonNull String name = (String)boxedValues[2];
			this.self = self;
			this.type = type;
			this.name = name;
			final /*@Thrown*/ @NonNull Property evaluate_0 = Helper4getProperty.INSTANCE.evaluate(rootExecutor, CLSSid_Property, self, type, name);
			this.cachedResult = evaluate_0;
		}

		// EntryGetResultOperationCallingConvention
		@Override
		public /*@NonInvalid*/ @NonNull Property getResult() {
			return this.cachedResult;
		}

		/**
		 * Return true if the boxedValues exactly match OCL-wise the values from which this entry was constructed.
		 * If so, the cachedResult can be re-used and no further ENTRY needs construction.
		 */
		// EntryIsEqualOperationCallingConvention
		@Override
		public /*@NonInvalid*/ boolean isEqual(final /*@NonInvalid*/ @NonNull IdResolver idResolver, final /*@NonInvalid*/ @Nullable Object @NonNull [] boxedValues) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Object INDEX_0_boxedValues = (@NonNull Object)boxedValues[0];
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Type INDEX_1_boxedValues = (@NonNull Type)boxedValues[1];
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String INDEX_2_boxedValues = (@NonNull String)boxedValues[2];
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(INDEX_0_boxedValues, this.self);
			final /*@NonInvalid*/ boolean and2_0;
			if (!IsEQ_) {
				and2_0 = false;
			}
			else {
				final /*@NonInvalid*/ boolean IsEQ__0 = idResolver.oclEquals(INDEX_0_boxedValues, this.type);
				and2_0 = IsEQ__0;
			}
			final /*@NonInvalid*/ boolean and2;
			if (!and2_0) {
				and2 = false;
			}
			else {
				final /*@NonInvalid*/ boolean IsEQ__1 = idResolver.oclEquals(INDEX_0_boxedValues, this.name);
				and2 = IsEQ__1;
			}
			return and2;
		}
	}
	/**
	 * Each ENTRY_ATL2QVTr_getType instance caches a distinct evaluation of
	 *
	 * getType(type : OCL::OclType[?]) : Class[1]
	 */
	// ImplementedEntryClassCallingConvention
	protected class ENTRY_ATL2QVTr_getType extends AbstractComputation
	{
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @NonNull Object self;
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ @Nullable OclType type;
		// ImmutableCachePropertyCallingConvention
		protected final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class cachedResult;

		/**
		 */
		// ImplementedConstructorOperationCallingConvention
		protected ENTRY_ATL2QVTr_getType(final /*@NonInvalid*/ @Nullable Object @NonNull [] boxedValues) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Object self = (@NonNull Object)boxedValues[0];
			final /*@NonInvalid*/ @Nullable OclType type = (OclType)boxedValues[1];
			this.self = self;
			this.type = type;
			final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Class evaluate_0 = Helper4getType.INSTANCE.evaluate(rootExecutor, CLSSid_Class, self, type);
			this.cachedResult = evaluate_0;
		}

		// EntryGetResultOperationCallingConvention
		@Override
		public /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class getResult() {
			return this.cachedResult;
		}

		/**
		 * Return true if the boxedValues exactly match OCL-wise the values from which this entry was constructed.
		 * If so, the cachedResult can be re-used and no further ENTRY needs construction.
		 */
		// EntryIsEqualOperationCallingConvention
		@Override
		public /*@NonInvalid*/ boolean isEqual(final /*@NonInvalid*/ @NonNull IdResolver idResolver, final /*@NonInvalid*/ @Nullable Object @NonNull [] boxedValues) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Object INDEX_0_boxedValues = (@NonNull Object)boxedValues[0];
			final /*@NonInvalid*/ @Nullable OclType INDEX_1_boxedValues = (OclType)boxedValues[1];
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(INDEX_0_boxedValues, this.self);
			final /*@NonInvalid*/ boolean and2;
			if (!IsEQ_) {
				and2 = false;
			}
			else {
				final /*@NonInvalid*/ boolean IsEQ__0 = idResolver.oclEquals(INDEX_0_boxedValues, this.type);
				and2 = IsEQ__0;
			}
			return and2;
		}
	}

	/**
	 * The instance of RULE_CACHE_DmapVariableExp_referredVariable caches the result of each distinct creation of
	 *
	 * DmapVariableExp_referredVariable
	 */
	// RuleCacheClassCallingConvention
	private class RULE_CACHE_DmapVariableExp_referredVariable extends AbstractEvaluationOperation
	{
		/**
		 * The inner evaluation, creates, initializes and installs the new trace singleton.
		 */
		// BasicEvaluateOperationCallingConvention
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor rootExecutor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			/*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable instance = trace_ATL2QVTrFactory.eINSTANCE.createDmapVariableExp_referredVariable();
			@SuppressWarnings("null") /*@NonInvalid*/ @NonNull VariableExp value0 = (/*@NonInvalid*/ @NonNull VariableExp)sourceAndArgumentValues[0];
			instance.setD3atlExpression(value0);
			@SuppressWarnings("null") /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp value1 = (/*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp)sourceAndArgumentValues[1];
			instance.setD4qvtrExpression(value1);
			models[4].add(instance, false);
			return instance;
		}

		/**
		 * The outer evaluation provides a type safe interface.
		 */
		// EvaluateOperationCallingConvention
		public @NonNull DmapVariableExp_referredVariable evaluate(final /*@NonInvalid*/ @NonNull VariableExp d3atlExpression, final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp d4qvtrExpression) {
			return (@NonNull DmapVariableExp_referredVariable)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{d3atlExpression, d4qvtrExpression});
		}
	}

	/**
	 * The instance of RULE_CACHE_TmapHelper_Context caches the result of each distinct creation of
	 *
	 * TmapHelper_Context
	 */
	// RuleCacheClassCallingConvention
	private class RULE_CACHE_TmapHelper_Context extends AbstractEvaluationOperation
	{
		/**
		 * The inner evaluation, creates, initializes and installs the new trace singleton.
		 */
		// BasicEvaluateOperationCallingConvention
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor rootExecutor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			/*@NonInvalid*/ @NonNull TmapHelper_Context instance = trace_ATL2QVTrFactory.eINSTANCE.createTmapHelper_Context();
			@SuppressWarnings("null") /*@NonInvalid*/ @NonNull Helper value0 = (/*@NonInvalid*/ @NonNull Helper)sourceAndArgumentValues[0];
			instance.setT3atlHelper(value0);
			@SuppressWarnings("null") /*@NonInvalid*/ @NonNull Function value1 = (/*@NonInvalid*/ @NonNull Function)sourceAndArgumentValues[1];
			instance.setT4qvtrFunction(value1);
			models[4].add(instance, false);
			return instance;
		}

		/**
		 * The outer evaluation provides a type safe interface.
		 */
		// EvaluateOperationCallingConvention
		public @NonNull TmapHelper_Context evaluate(final /*@NonInvalid*/ @NonNull Helper t3atlHelper, final /*@NonInvalid*/ @NonNull Function t4qvtrFunction) {
			return (@NonNull TmapHelper_Context)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{t3atlHelper, t4qvtrFunction});
		}
	}

	/**
	 * The instance of RULE_CACHE_TmapVariable caches the result of each distinct creation of
	 *
	 * TmapVariable
	 */
	// RuleCacheClassCallingConvention
	private class RULE_CACHE_TmapVariable extends AbstractEvaluationOperation
	{
		/**
		 * The inner evaluation, creates, initializes and installs the new trace singleton.
		 */
		// BasicEvaluateOperationCallingConvention
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor rootExecutor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			/*@NonInvalid*/ @NonNull TmapVariable instance = trace_ATL2QVTrFactory.eINSTANCE.createTmapVariable();
			@SuppressWarnings("null") /*@NonInvalid*/ @NonNull LocatedElement value0 = (/*@NonInvalid*/ @NonNull LocatedElement)sourceAndArgumentValues[0];
			instance.setT3atlVariable(value0);
			OPPOSITE_OF_TmapVariable_t3atlVariable.put(value0, instance);
			@SuppressWarnings("null") /*@NonInvalid*/ @NonNull VariableDeclaration value1 = (/*@NonInvalid*/ @NonNull VariableDeclaration)sourceAndArgumentValues[1];
			instance.setT4qvtrVariable(value1);
			OPPOSITE_OF_TmapVariable_t4qvtrVariable.put(value1, instance);
			models[4].add(instance, false);
			return instance;
		}

		/**
		 * The outer evaluation provides a type safe interface.
		 */
		// EvaluateOperationCallingConvention
		public @NonNull TmapVariable evaluate(final /*@NonInvalid*/ @NonNull LocatedElement t3atlVariable, final /*@NonInvalid*/ @NonNull VariableDeclaration t4qvtrVariable) {
			return (@NonNull TmapVariable)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{t3atlVariable, t4qvtrVariable});
		}
	}

	/**
	 *
	 * entry r_ATL2QVTr__qvtr__load__input atloutput qvtr in ATL2QVTr {
	 *
	 *   append ji_Binding  : ATL::Binding[1];
	 * append ji_Helper  : ATL::Helper[1];
	 * append ji_InPattern  : ATL::InPattern[1];
	 * append ji_MatchedRule  : ATL::MatchedRule[1];
	 * append ji_Module  : ATL::Module[1];
	 * append ji_NavigationOrAttributeCallExp  : OCL::NavigationOrAttributeCallExp[1];
	 * append ji_OclExpression  : OCL::OclExpression[1];
	 * append ji_OclModel  : OCL::OclModel[1];
	 * append ji_OperationCallExp  : OCL::OperationCallExp[1];
	 * append ji_SimpleInPatternElement  : ATL::SimpleInPatternElement[1];
	 * append ji_SimpleOutPatternElement  : ATL::SimpleOutPatternElement[1];
	 * append ji_VariableExp  : OCL::VariableExp[1];
	 * buffer:1 jm_DmapHelper : trace_ATL2QVTr::DmapHelper[1];
	 * buffer:1 jm_DmapOclExpression : trace_ATL2QVTr::DmapOclExpression[1];
	 * buffer:2 jm_DmapVariableExp__referredVariable : trace_ATL2QVTr::DmapVariableExp_referredVariable[1];
	 * buffer:1 jm_TmapBinding : trace_ATL2QVTr::TmapBinding[1];
	 * buffer:1 jm_TmapBooleanExp : trace_ATL2QVTr::TmapBooleanExp[1];
	 * buffer:1 jm_TmapHelper__Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * buffer:5 jm_TmapHelper__Context : trace_ATL2QVTr::TmapHelper_Context[1];
	 * buffer:1 jm_TmapHelper__Operation : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * buffer:1 jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * buffer:1 jm_TmapInPattern : trace_ATL2QVTr::TmapInPattern[1];
	 * buffer:1 jm_TmapInPattern__filter : trace_ATL2QVTr::TmapInPattern_filter[1];
	 * buffer:1 jm_TmapIntegerExp : trace_ATL2QVTr::TmapIntegerExp[1];
	 * buffer:1 jm_TmapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1];
	 * buffer:1 jm_TmapMatchedRule__super : trace_ATL2QVTr::TmapMatchedRule_super[1];
	 * buffer:1 jm_TmapModule : trace_ATL2QVTr::TmapModule[1];
	 * buffer:1 jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * buffer:1 jm_TmapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * buffer:1 jm_TmapOclMetamodel : trace_ATL2QVTr::TmapOclMetamodel[1];
	 * buffer:1 jm_TmapOclModel__IN : trace_ATL2QVTr::TmapOclModel_IN[1];
	 * buffer:1 jm_TmapOclModel__OUT : trace_ATL2QVTr::TmapOclModel_OUT[1];
	 * buffer:1 jm_TmapOclType : trace_ATL2QVTr::TmapOclType[1];
	 * buffer:1 jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * buffer:1 jm_TmapOperationCallExp__Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * buffer:1 jm_TmapOperationCallExp__argument : trace_ATL2QVTr::TmapOperationCallExp_argument[1];
	 * buffer:1 jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * buffer:1 jm_TmapSimpleInPatternElement : trace_ATL2QVTr::TmapSimpleInPatternElement[1];
	 * buffer:1 jm_TmapSimpleOutPatternElement : trace_ATL2QVTr::TmapSimpleOutPatternElement[1];
	 * buffer:1 jm_TmapStringExp : trace_ATL2QVTr::TmapStringExp[1];
	 * buffer:4..6 jm_TmapVariable : trace_ATL2QVTr::TmapVariable[1];
	 * buffer:1 jm_TmapVariableExp : trace_ATL2QVTr::TmapVariableExp[1];
	 * buffer:3 jm_TmapVariableExp__referredVariable__Helper : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * buffer:3 jm_TmapVariableExp__referredVariable__VariableDecl : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1];
	 * install mmapBinding__qvtr__ctor__ {
	 * atlBinding consumes append ji_Binding  : ATL::Binding[1];
	 * ;
	 * jm_TmapBinding appendsTo jm_TmapBinding;
	 * }
	 *   install mmapHelper__dispatch__qvtr {
	 * atlHelper consumes append ji_Helper  : ATL::Helper[1];
	 * ;
	 * jm_DmapHelper appendsTo jm_DmapHelper;
	 * jm_TmapHelper__Attribute appendsTo jm_TmapHelper__Attribute;
	 * jm_TmapHelper__Operation appendsTo jm_TmapHelper__Operation;
	 * }
	 *   install mmapInPattern__filter__qvtr__ctor__ {
	 * atlPattern consumes append ji_InPattern  : ATL::InPattern[1];
	 * ;
	 * jm_TmapInPattern__filter appendsTo jm_TmapInPattern__filter;
	 * }
	 *   install mmapInPattern__qvtr__ctor__ {
	 * atlPattern consumes append ji_InPattern  : ATL::InPattern[1];
	 * ;
	 * jm_TmapInPattern appendsTo jm_TmapInPattern;
	 * }
	 *   install mmapMatchedRule__qvtr__ctor__ {
	 * jm_TmapMatchedRule appendsTo jm_TmapMatchedRule;
	 * matchedRule consumes append ji_MatchedRule  : ATL::MatchedRule[1];
	 * ;
	 * }
	 *   install mmapMatchedRule__super__qvtr__ctor__ {
	 * atlChildRule consumes append ji_MatchedRule  : ATL::MatchedRule[1];
	 * ;
	 * jm_TmapMatchedRule__super appendsTo jm_TmapMatchedRule__super;
	 * }
	 *   install mmapModule__qvtr__ctor__ {
	 * atlModule consumes append ji_Module  : ATL::Module[1];
	 * ;
	 * jm_TmapModule appendsTo jm_TmapModule;
	 * }
	 *   install mmapOclExpression__dispatch__qvtr {
	 * atlExpression consumes append ji_OclExpression  : OCL::OclExpression[1];
	 * ;
	 * jm_DmapOclExpression appendsTo jm_DmapOclExpression;
	 * jm_TmapBooleanExp appendsTo jm_TmapBooleanExp;
	 * jm_TmapIfExp appendsTo jm_TmapIfExp;
	 * jm_TmapIntegerExp appendsTo jm_TmapIntegerExp;
	 * jm_TmapNavigationOrAttributeCallExp__Helper appendsTo jm_TmapNavigationOrAttributeCallExp__Helper;
	 * jm_TmapNavigationOrAttributeCallExp__Property appendsTo jm_TmapNavigationOrAttributeCallExp__Property;
	 * jm_TmapOclType appendsTo jm_TmapOclType;
	 * jm_TmapOperationCallExp__Helper appendsTo jm_TmapOperationCallExp__Helper;
	 * jm_TmapOperationCallExp__Operation appendsTo jm_TmapOperationCallExp__Operation;
	 * jm_TmapOperatorCallExp appendsTo jm_TmapOperatorCallExp;
	 * jm_TmapStringExp appendsTo jm_TmapStringExp;
	 * jm_TmapVariableExp appendsTo jm_TmapVariableExp;
	 * }
	 *   install mmapOclMetamodel__qvtr__ctor__ {
	 * jm_TmapOclMetamodel appendsTo jm_TmapOclMetamodel;
	 * oclMetamodel consumes append ji_OclModel  : OCL::OclModel[1];
	 * ;
	 * }
	 *   install mmapOclModel__IN__qvtr__ctor__ {
	 * jm_TmapOclModel__IN appendsTo jm_TmapOclModel__IN;
	 * oclModel consumes append ji_OclModel  : OCL::OclModel[1];
	 * ;
	 * }
	 *   install mmapOclModel__OUT__qvtr__ctor__ {
	 * jm_TmapOclModel__OUT appendsTo jm_TmapOclModel__OUT;
	 * oclModel consumes append ji_OclModel  : OCL::OclModel[1];
	 * ;
	 * }
	 *   install mmapOperationCallExp__argument__qvtr__ctor__ {
	 * atlArgument consumes append ji_OclExpression  : OCL::OclExpression[1];
	 * ;
	 * jm_TmapOperationCallExp__argument appendsTo jm_TmapOperationCallExp__argument;
	 * }
	 *   install mmapSimpleInPatternElement__qvtr__ctor__ {
	 * atlElement consumes append ji_SimpleInPatternElement  : ATL::SimpleInPatternElement[1];
	 * ;
	 * jm_TmapSimpleInPatternElement appendsTo jm_TmapSimpleInPatternElement;
	 * }
	 *   install mmapSimpleOutPatternElement__qvtr__ctor__ {
	 * atlElement consumes append ji_SimpleOutPatternElement  : ATL::SimpleOutPatternElement[1];
	 * ;
	 * jm_TmapSimpleOutPatternElement appendsTo jm_TmapSimpleOutPatternElement;
	 * }
	 *   install mmapBooleanExp__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapBooleanExp : trace_ATL2QVTr::TmapBooleanExp[1];
	 * ;
	 * }
	 *   install mmapIfExp__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * ;
	 * }
	 *   install mmapIntegerExp__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapIntegerExp : trace_ATL2QVTr::TmapIntegerExp[1];
	 * ;
	 * }
	 *   install mmapModule__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapModule : trace_ATL2QVTr::TmapModule[1];
	 * ;
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Property__qvtr__i {
	 * trace consumes buffer:1 jm_TmapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * ;
	 * }
	 *   install mmapOclMetamodel__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapOclMetamodel : trace_ATL2QVTr::TmapOclMetamodel[1];
	 * ;
	 * }
	 *   install mmapOclType__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapOclType : trace_ATL2QVTr::TmapOclType[1];
	 * ;
	 * }
	 *   install mmapOperationCallExp__Operation__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapOperationCallExp__Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * ;
	 * }
	 *   install mmapOperatorCallExp__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * ;
	 * }
	 *   install mmapStringExp__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapStringExp : trace_ATL2QVTr::TmapStringExp[1];
	 * ;
	 * }
	 *   install mmapVariableExp__qvtr__init__ {
	 * jm_DmapVariableExp__referredVariable appendsTo jm_DmapVariableExp__referredVariable;
	 * trace consumes buffer:1 jm_TmapVariableExp : trace_ATL2QVTr::TmapVariableExp[1];
	 * ;
	 * }
	 *   install mmapBooleanExp__qvtr__rest__ {
	 * trace consumes buffer:1 jm_TmapBooleanExp : trace_ATL2QVTr::TmapBooleanExp[1];
	 * ;
	 * }
	 *   install mmapHelper__Attribute__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapHelper__Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * ;
	 * }
	 *   install mmapHelper__Operation__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapHelper__Operation : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * ;
	 * }
	 *   install mmapIntegerExp__qvtr__rest__ {
	 * trace consumes buffer:1 jm_TmapIntegerExp : trace_ATL2QVTr::TmapIntegerExp[1];
	 * ;
	 * }
	 *   install mmapMatchedRule__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1];
	 * ;
	 * }
	 *   install mmapOclModel__IN__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapOclModel__IN : trace_ATL2QVTr::TmapOclModel_IN[1];
	 * ;
	 * }
	 *   install mmapOclModel__OUT__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapOclModel__OUT : trace_ATL2QVTr::TmapOclModel_OUT[1];
	 * ;
	 * }
	 *   install mmapOclType__qvtr__rest__ {
	 * trace consumes buffer:1 jm_TmapOclType : trace_ATL2QVTr::TmapOclType[1];
	 * ;
	 * }
	 *   install mmapStringExp__qvtr__rest__ {
	 * trace consumes buffer:1 jm_TmapStringExp : trace_ATL2QVTr::TmapStringExp[1];
	 * ;
	 * }
	 *   install mmapVariableExp__qvtr__rest__ {
	 * trace consumes buffer:1 jm_TmapVariableExp : trace_ATL2QVTr::TmapVariableExp[1];
	 * ;
	 * }
	 *   install mmapVariableExp__referredVariable__dispatch__qvtr {
	 * dispatcher consumes buffer:2 jm_DmapVariableExp__referredVariable : trace_ATL2QVTr::DmapVariableExp_referredVariable[1];
	 * ;
	 * jm_TmapVariableExp__referredVariable__Helper appendsTo jm_TmapVariableExp__referredVariable__Helper;
	 * jm_TmapVariableExp__referredVariable__VariableDecl appendsTo jm_TmapVariableExp__referredVariable__VariableDecl;
	 * }
	 *   install mmapInPattern__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapInPattern : trace_ATL2QVTr::TmapInPattern[1];
	 * ;
	 * }
	 *   install mmapMatchedRule__qvtr__rest__ {
	 * trace consumes buffer:1 jm_TmapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1];
	 * ;
	 * }
	 *   install mmapMatchedRule__super__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapMatchedRule__super : trace_ATL2QVTr::TmapMatchedRule_super[1];
	 * ;
	 * }
	 *   install mmapSimpleOutPatternElement__qvtr__init__ {
	 * jm_TmapVariable appendsTo jm_TmapVariable;
	 * trace consumes buffer:1 jm_TmapSimpleOutPatternElement : trace_ATL2QVTr::TmapSimpleOutPatternElement[1];
	 * ;
	 * }
	 *   install mmapHelper__Attribute__qvtr__loop__ {
	 * jm_TmapHelper__Context appendsTo jm_TmapHelper__Context;
	 * trace consumes buffer:1 jm_TmapHelper__Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * ;
	 * }
	 *   install mmapHelper__Context__qvtr__loop__ {
	 * jm_TmapVariable appendsTo jm_TmapVariable;
	 * trace consumes buffer:5 jm_TmapHelper__Context : trace_ATL2QVTr::TmapHelper_Context[1];
	 * ;
	 * }
	 *   install mmapHelper__Operation__qvtr__loop__ {
	 * jm_TmapHelper__Context appendsTo jm_TmapHelper__Context;
	 * trace consumes buffer:1 jm_TmapHelper__Operation : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * ;
	 * }
	 *   install mmapHelper__verdict__qvtr {
	 * mapHelper consumes buffer:1 jm_DmapHelper : trace_ATL2QVTr::DmapHelper[1];
	 * ;
	 * }
	 *   install mmapIfExp__qvtr__loop__ {
	 * trace consumes buffer:1 jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * ;
	 * }
	 *   install mmapModule__qvtr__rest__ {
	 * trace consumes buffer:1 jm_TmapModule : trace_ATL2QVTr::TmapModule[1];
	 * ;
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Helper__qvtr__ini {
	 * trace consumes buffer:1 jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * ;
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Helper__qvtr__loo {
	 * trace consumes buffer:1 jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * ;
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Property__qvtr__l {
	 * trace consumes buffer:1 jm_TmapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * ;
	 * }
	 *   install mmapOclExpression__verdict__qvtr {
	 * mapOclExpression consumes buffer:1 jm_DmapOclExpression : trace_ATL2QVTr::DmapOclExpression[1];
	 * ;
	 * }
	 *   install mmapOperationCallExp__Helper__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * ;
	 * }
	 *   install mmapOperationCallExp__Helper__qvtr__loop__ {
	 * trace consumes buffer:1 jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * ;
	 * }
	 *   install mmapOperationCallExp__Operation__qvtr__loop__ {
	 * trace consumes buffer:1 jm_TmapOperationCallExp__Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * ;
	 * }
	 *   install mmapOperatorCallExp__qvtr__loop__ {
	 * trace consumes buffer:1 jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * ;
	 * }
	 *   install mmapInPattern__qvtr__rest__ {
	 * trace consumes buffer:1 jm_TmapInPattern : trace_ATL2QVTr::TmapInPattern[1];
	 * ;
	 * }
	 *   install mmapSimpleInPatternElement__qvtr__init__ {
	 * jm_TmapVariable appendsTo jm_TmapVariable;
	 * trace consumes buffer:1 jm_TmapSimpleInPatternElement : trace_ATL2QVTr::TmapSimpleInPatternElement[1];
	 * ;
	 * }
	 *   install mmapSimpleOutPatternElement__qvtr__rest__ {
	 * trace consumes buffer:1 jm_TmapSimpleOutPatternElement : trace_ATL2QVTr::TmapSimpleOutPatternElement[1];
	 * ;
	 * }
	 *   install mmapVariableExp__referredVariable__Helper__qvtr__in {
	 * trace consumes buffer:3 jm_TmapVariableExp__referredVariable__Helper : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * ;
	 * }
	 *   install mmapBinding__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapBinding : trace_ATL2QVTr::TmapBinding[1];
	 * ;
	 * }
	 *   install mmapHelper__Attribute__qvtr__rest__ {
	 * trace consumes buffer:1 jm_TmapHelper__Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * ;
	 * }
	 *   install mmapHelper__Operation__qvtr__rest__ {
	 * trace consumes buffer:1 jm_TmapHelper__Operation : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * ;
	 * }
	 *   install mmapIfExp__qvtr__rest__ {
	 * trace consumes buffer:1 jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * ;
	 * }
	 *   install mmapInPattern__filter__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapInPattern__filter : trace_ATL2QVTr::TmapInPattern_filter[1];
	 * ;
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Helper__qvtr__res {
	 * trace consumes buffer:1 jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * ;
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Property__qvtr__r {
	 * trace consumes buffer:1 jm_TmapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * ;
	 * }
	 *   install mmapOperationCallExp__Helper__qvtr__rest__ {
	 * trace consumes buffer:1 jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * ;
	 * }
	 *   install mmapOperationCallExp__Operation__qvtr__rest__ {
	 * trace consumes buffer:1 jm_TmapOperationCallExp__Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * ;
	 * }
	 *   install mmapOperationCallExp__argument__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapOperationCallExp__argument : trace_ATL2QVTr::TmapOperationCallExp_argument[1];
	 * ;
	 * }
	 *   install mmapOperatorCallExp__qvtr__rest__ {
	 * trace consumes buffer:1 jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * ;
	 * }
	 *   install mmapVariableExp__referredVariable__VariableDeclarat {
	 * trace consumes buffer:3 jm_TmapVariableExp__referredVariable__VariableDecl : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1];
	 * ;
	 * }
	 *   install mmapVariable__qvtr__init__ {
	 * trace consumes buffer:4..6 jm_TmapVariable : trace_ATL2QVTr::TmapVariable[1];
	 * ;
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Helper__qvtr__xtr {
	 * trace consumes buffer:1 jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * ;
	 * }
	 *   install mmapOperationCallExp__Helper__qvtr__xtra__ {
	 * trace consumes buffer:1 jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * ;
	 * }
	 *   install mmapVariableExp__referredVariable__Helper__qvtr__lo {
	 * trace consumes buffer:3 jm_TmapVariableExp__referredVariable__Helper : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * ;
	 * }
	 *   install mmapVariableExp__referredVariable__VariableDeclarat_1 {
	 * trace consumes buffer:3 jm_TmapVariableExp__referredVariable__VariableDecl : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1];
	 * ;
	 * }
	 *   install mmapVariableExp__referredVariable__Helper__qvtr__xt {
	 * trace consumes buffer:3 jm_TmapVariableExp__referredVariable__Helper : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * ;
	 * }
	 *   install mmapVariableExp__referredVariable__verdict__qvtr {
	 * mapVariableExp_referredVariable consumes buffer:2 jm_DmapVariableExp__referredVariable : trace_ATL2QVTr::DmapVariableExp_referredVariable[1];
	 * ;
	 * }
	 *   install mmapIfExp__qvtr__xtra__ {
	 * trace consumes buffer:1 jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * ;
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Property__qvtr__x {
	 * trace consumes buffer:1 jm_TmapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * ;
	 * }
	 *   install mmapOperationCallExp__Operation__qvtr__xtra__ {
	 * trace consumes buffer:1 jm_TmapOperationCallExp__Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * ;
	 * }
	 *   install mmapOperatorCallExp__qvtr__xtra__ {
	 * trace consumes buffer:1 jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * ;
	 * }
	 */
	protected class MAP_r_ATL2QVTr__qvtr__load__ extends AbstractInvocation
	{
		protected final @NonNull Connection ji_Binding;
		protected final @NonNull Connection ji_Helper;
		protected final @NonNull Connection ji_InPattern;
		protected final @NonNull Connection ji_MatchedRule;
		protected final @NonNull Connection ji_Module;
		protected final @NonNull Connection ji_NavigationOrAttributeCallExp;
		protected final @NonNull Connection ji_OclExpression;
		protected final @NonNull Connection ji_OclModel;
		protected final @NonNull Connection ji_OperationCallExp;
		protected final @NonNull Connection ji_SimpleInPatternElement;
		protected final @NonNull Connection ji_SimpleOutPatternElement;
		protected final @NonNull Connection ji_VariableExp;

		public MAP_r_ATL2QVTr__qvtr__load__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			ji_Binding = (Connection)boundValues[0];
			ji_Helper = (Connection)boundValues[1];
			ji_InPattern = (Connection)boundValues[2];
			ji_MatchedRule = (Connection)boundValues[3];
			ji_Module = (Connection)boundValues[4];
			ji_NavigationOrAttributeCallExp = (Connection)boundValues[5];
			ji_OclExpression = (Connection)boundValues[6];
			ji_OclModel = (Connection)boundValues[7];
			ji_OperationCallExp = (Connection)boundValues[8];
			ji_SimpleInPatternElement = (Connection)boundValues[9];
			ji_SimpleOutPatternElement = (Connection)boundValues[10];
			ji_VariableExp = (Connection)boundValues[11];
		}

		@Override
		public boolean execute()  {
			// interval variables
			final @NonNull ModeFactory modeFactory = getModeFactory();
			final @NonNull Interval rootInterval = lazyCreateInterval(0);
			// connection variables
			final @NonNull Connection accumulator = lazyCreateInterval(1).createConnection("accumulator", CLSSid_DmapHelper, false, modeFactory);
			final @NonNull Connection accumulator_0 = lazyCreateInterval(1).createConnection("accumulator_0", CLSSid_DmapOclExpression, false, modeFactory);
			final @NonNull Connection accumulator_1 = lazyCreateInterval(2).createConnection("accumulator_1", CLSSid_DmapVariableExp_referredVariable, false, modeFactory);
			final @NonNull Connection accumulator_2 = lazyCreateInterval(1).createConnection("accumulator_2", CLSSid_TmapBinding, false, modeFactory);
			final @NonNull Connection accumulator_3 = lazyCreateInterval(1).createConnection("accumulator_3", CLSSid_TmapBooleanExp, false, modeFactory);
			final @NonNull Connection accumulator_4 = lazyCreateInterval(1).createConnection("accumulator_4", CLSSid_TmapHelper_Attribute, false, modeFactory);
			final @NonNull Connection accumulator_5 = lazyCreateInterval(5).createConnection("accumulator_5", CLSSid_TmapHelper_Context, false, modeFactory);
			final @NonNull Connection accumulator_6 = lazyCreateInterval(1).createConnection("accumulator_6", CLSSid_TmapHelper_Operation, false, modeFactory);
			final @NonNull Connection accumulator_7 = lazyCreateInterval(1).createConnection("accumulator_7", CLSSid_TmapIfExp, false, modeFactory);
			final @NonNull Connection accumulator_8 = lazyCreateInterval(1).createConnection("accumulator_8", CLSSid_TmapInPattern, false, modeFactory);
			final @NonNull Connection accumulator_9 = lazyCreateInterval(1).createConnection("accumulator_9", CLSSid_TmapInPattern_filter, false, modeFactory);
			final @NonNull Connection accumulator_10 = lazyCreateInterval(1).createConnection("accumulator_10", CLSSid_TmapIntegerExp, false, modeFactory);
			final @NonNull Connection accumulator_11 = lazyCreateInterval(1).createConnection("accumulator_11", CLSSid_TmapMatchedRule, false, modeFactory);
			final @NonNull Connection accumulator_12 = lazyCreateInterval(1).createConnection("accumulator_12", CLSSid_TmapMatchedRule_super, false, modeFactory);
			final @NonNull Connection accumulator_13 = lazyCreateInterval(1).createConnection("accumulator_13", CLSSid_TmapModule, false, modeFactory);
			final @NonNull Connection accumulator_14 = lazyCreateInterval(1).createConnection("accumulator_14", CLSSid_TmapNavigationOrAttributeCallExp_Helper, false, modeFactory);
			final @NonNull Connection accumulator_15 = lazyCreateInterval(1).createConnection("accumulator_15", CLSSid_TmapNavigationOrAttributeCallExp_Property, false, modeFactory);
			final @NonNull Connection accumulator_16 = lazyCreateInterval(1).createConnection("accumulator_16", CLSSid_TmapOclMetamodel, false, modeFactory);
			final @NonNull Connection accumulator_17 = lazyCreateInterval(1).createConnection("accumulator_17", CLSSid_TmapOclModel_IN, false, modeFactory);
			final @NonNull Connection accumulator_18 = lazyCreateInterval(1).createConnection("accumulator_18", CLSSid_TmapOclModel_OUT, false, modeFactory);
			final @NonNull Connection accumulator_19 = lazyCreateInterval(1).createConnection("accumulator_19", CLSSid_TmapOclType, false, modeFactory);
			final @NonNull Connection accumulator_20 = lazyCreateInterval(1).createConnection("accumulator_20", CLSSid_TmapOperationCallExp_Helper, false, modeFactory);
			final @NonNull Connection accumulator_21 = lazyCreateInterval(1).createConnection("accumulator_21", CLSSid_TmapOperationCallExp_Operation, false, modeFactory);
			final @NonNull Connection accumulator_22 = lazyCreateInterval(1).createConnection("accumulator_22", CLSSid_TmapOperationCallExp_argument, false, modeFactory);
			final @NonNull Connection accumulator_23 = lazyCreateInterval(1).createConnection("accumulator_23", CLSSid_TmapOperatorCallExp, false, modeFactory);
			final @NonNull Connection accumulator_24 = lazyCreateInterval(1).createConnection("accumulator_24", CLSSid_TmapSimpleInPatternElement, false, modeFactory);
			final @NonNull Connection accumulator_25 = lazyCreateInterval(1).createConnection("accumulator_25", CLSSid_TmapSimpleOutPatternElement, false, modeFactory);
			final @NonNull Connection accumulator_26 = lazyCreateInterval(1).createConnection("accumulator_26", CLSSid_TmapStringExp, false, modeFactory);
			final @NonNull Connection accumulator_27 = lazyCreateInterval(4).createConnection("accumulator_27", CLSSid_TmapVariable, false, modeFactory);
			final @NonNull Connection accumulator_28 = lazyCreateInterval(1).createConnection("accumulator_28", CLSSid_TmapVariableExp, false, modeFactory);
			final @NonNull Connection accumulator_29 = lazyCreateInterval(3).createConnection("accumulator_29", CLSSid_TmapVariableExp_referredVariable_Helper, false, modeFactory);
			final @NonNull Connection accumulator_30 = lazyCreateInterval(3).createConnection("accumulator_30", CLSSid_TmapVariableExp_referredVariable_VariableDeclaration, false, modeFactory);
			// mapping statements
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapBinding__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull Binding atlBinding : ji_Binding.typedIterable(Binding.class)) {
						MAP_mmapBinding__qvtr__ctor__(atlBinding, accumulator_2);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapHelper__dispatch__qvtr") {
				@Override
				public boolean execute() {
					for (@NonNull Helper atlHelper : ji_Helper.typedIterable(Helper.class)) {
						MAP_mmapHelper__dispatch__qvtr(atlHelper, accumulator, accumulator_4, accumulator_6);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapInPattern__filter__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull InPattern atlPattern : ji_InPattern.typedIterable(InPattern.class)) {
						MAP_mmapInPattern__filter__qvtr__ctor__(atlPattern, accumulator_9);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapInPattern__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull InPattern atlPattern_0 : ji_InPattern.typedIterable(InPattern.class)) {
						MAP_mmapInPattern__qvtr__ctor__(atlPattern_0, accumulator_8);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapMatchedRule__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull MatchedRule matchedRule : ji_MatchedRule.typedIterable(MatchedRule.class)) {
						MAP_mmapMatchedRule__qvtr__ctor__(accumulator_11, matchedRule);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapMatchedRule__super__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull MatchedRule atlChildRule : ji_MatchedRule.typedIterable(MatchedRule.class)) {
						MAP_mmapMatchedRule__super__qvtr__ctor__(atlChildRule, accumulator_12);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapModule__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull Module atlModule : ji_Module.typedIterable(Module.class)) {
						MAP_mmapModule__qvtr__ctor__(atlModule, accumulator_13);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapOclExpression__dispatch__qvtr") {
				@Override
				public boolean execute() {
					for (@NonNull OclExpression atlExpression : ji_OclExpression.typedIterable(OclExpression.class)) {
						MAP_mmapOclExpression__dispatch__qvtr(atlExpression, accumulator_0, accumulator_3, accumulator_7, accumulator_10, accumulator_14, accumulator_15, accumulator_19, accumulator_20, accumulator_21, accumulator_23, accumulator_26, accumulator_28);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapOclMetamodel__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull OclModel oclMetamodel : ji_OclModel.typedIterable(OclModel.class)) {
						MAP_mmapOclMetamodel__qvtr__ctor__(accumulator_16, oclMetamodel);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapOclModel__IN__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull OclModel oclModel : ji_OclModel.typedIterable(OclModel.class)) {
						MAP_mmapOclModel__IN__qvtr__ctor__(accumulator_17, oclModel);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapOclModel__OUT__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull OclModel oclModel_0 : ji_OclModel.typedIterable(OclModel.class)) {
						MAP_mmapOclModel__OUT__qvtr__ctor__(accumulator_18, oclModel_0);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapOperationCallExp__argument__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull OclExpression atlArgument : ji_OclExpression.typedIterable(OclExpression.class)) {
						MAP_mmapOperationCallExp__argument__qvtr__ctor__(atlArgument, accumulator_22);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapSimpleInPatternElement__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull SimpleInPatternElement atlElement : ji_SimpleInPatternElement.typedIterable(SimpleInPatternElement.class)) {
						MAP_mmapSimpleInPatternElement__qvtr__ctor__(atlElement, accumulator_24);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapSimpleOutPatternElement__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull SimpleOutPatternElement atlElement_0 : ji_SimpleOutPatternElement.typedIterable(SimpleOutPatternElement.class)) {
						MAP_mmapSimpleOutPatternElement__qvtr__ctor__(atlElement_0, accumulator_25);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapBooleanExp__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapBooleanExp trace : accumulator_3.typedIterable(TmapBooleanExp.class)) {
						MAP_mmapBooleanExp__qvtr__init__(trace);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapIfExp__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapIfExp trace_0 : accumulator_7.typedIterable(TmapIfExp.class)) {
						MAP_mmapIfExp__qvtr__init__(trace_0);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapIntegerExp__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapIntegerExp trace_1 : accumulator_10.typedIterable(TmapIntegerExp.class)) {
						MAP_mmapIntegerExp__qvtr__init__(trace_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapModule__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapModule trace_2 : accumulator_13.typedIterable(TmapModule.class)) {
						MAP_mmapModule__qvtr__init__(trace_2);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapNavigationOrAttributeCallExp__Property__qvtr__i") {
				@Override
				public boolean execute() {
					for (@NonNull TmapNavigationOrAttributeCallExp_Property trace_3 : accumulator_15.typedIterable(TmapNavigationOrAttributeCallExp_Property.class)) {
						MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__i(trace_3);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapOclMetamodel__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOclMetamodel trace_4 : accumulator_16.typedIterable(TmapOclMetamodel.class)) {
						MAP_mmapOclMetamodel__qvtr__init__(trace_4);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapOclType__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOclType trace_5 : accumulator_19.typedIterable(TmapOclType.class)) {
						MAP_mmapOclType__qvtr__init__(trace_5);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapOperationCallExp__Operation__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperationCallExp_Operation trace_6 : accumulator_21.typedIterable(TmapOperationCallExp_Operation.class)) {
						MAP_mmapOperationCallExp__Operation__qvtr__init__(trace_6);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapOperatorCallExp__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperatorCallExp trace_7 : accumulator_23.typedIterable(TmapOperatorCallExp.class)) {
						MAP_mmapOperatorCallExp__qvtr__init__(trace_7);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapStringExp__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapStringExp trace_8 : accumulator_26.typedIterable(TmapStringExp.class)) {
						MAP_mmapStringExp__qvtr__init__(trace_8);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapVariableExp__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapVariableExp trace_9 : accumulator_28.typedIterable(TmapVariableExp.class)) {
						MAP_mmapVariableExp__qvtr__init__(accumulator_1, trace_9);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapBooleanExp__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapBooleanExp trace_10 : accumulator_3.typedIterable(TmapBooleanExp.class)) {
						MAP_mmapBooleanExp__qvtr__rest__(trace_10);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapHelper__Attribute__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapHelper_Attribute trace_11 : accumulator_4.typedIterable(TmapHelper_Attribute.class)) {
						MAP_mmapHelper__Attribute__qvtr__init__(trace_11);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapHelper__Operation__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapHelper_Operation trace_12 : accumulator_6.typedIterable(TmapHelper_Operation.class)) {
						MAP_mmapHelper__Operation__qvtr__init__(trace_12);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapIntegerExp__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapIntegerExp trace_13 : accumulator_10.typedIterable(TmapIntegerExp.class)) {
						MAP_mmapIntegerExp__qvtr__rest__(trace_13);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapMatchedRule__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapMatchedRule trace_14 : accumulator_11.typedIterable(TmapMatchedRule.class)) {
						MAP_mmapMatchedRule__qvtr__init__(trace_14);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapOclModel__IN__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOclModel_IN trace_15 : accumulator_17.typedIterable(TmapOclModel_IN.class)) {
						MAP_mmapOclModel__IN__qvtr__init__(trace_15);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapOclModel__OUT__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOclModel_OUT trace_16 : accumulator_18.typedIterable(TmapOclModel_OUT.class)) {
						MAP_mmapOclModel__OUT__qvtr__init__(trace_16);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapOclType__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOclType trace_17 : accumulator_19.typedIterable(TmapOclType.class)) {
						MAP_mmapOclType__qvtr__rest__(trace_17);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapStringExp__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapStringExp trace_18 : accumulator_26.typedIterable(TmapStringExp.class)) {
						MAP_mmapStringExp__qvtr__rest__(trace_18);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapVariableExp__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapVariableExp trace_19 : accumulator_28.typedIterable(TmapVariableExp.class)) {
						MAP_mmapVariableExp__qvtr__rest__(trace_19);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapVariableExp__referredVariable__dispatch__qvtr") {
				@Override
				public boolean execute() {
					for (@NonNull DmapVariableExp_referredVariable dispatcher : accumulator_1.typedIterable(DmapVariableExp_referredVariable.class)) {
						MAP_mmapVariableExp__referredVariable__dispatch__qvtr(dispatcher, accumulator_29, accumulator_30);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(4/*..null*/), "mmapInPattern__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapInPattern trace_20 : accumulator_8.typedIterable(TmapInPattern.class)) {
						MAP_mmapInPattern__qvtr__init__(trace_20);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(4/*..null*/), "mmapMatchedRule__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapMatchedRule trace_21 : accumulator_11.typedIterable(TmapMatchedRule.class)) {
						MAP_mmapMatchedRule__qvtr__rest__(trace_21);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(4/*..null*/), "mmapMatchedRule__super__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapMatchedRule_super trace_22 : accumulator_12.typedIterable(TmapMatchedRule_super.class)) {
						MAP_mmapMatchedRule__super__qvtr__init__(trace_22);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(4/*..null*/), "mmapSimpleOutPatternElement__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapSimpleOutPatternElement trace_23 : accumulator_25.typedIterable(TmapSimpleOutPatternElement.class)) {
						MAP_mmapSimpleOutPatternElement__qvtr__init__(accumulator_27, trace_23);
					}
					return true;
				}
			};
			CTOR_MAP_mmapHelper__Attribute__qvtr__loop__.addAppendedConnection(accumulator_5);
			CTOR_MAP_mmapHelper__Attribute__qvtr__loop__.addConsumedConnection(accumulator_4);
			CTOR_MAP_mmapHelper__Context__qvtr__loop__.addAppendedConnection(accumulator_27);
			CTOR_MAP_mmapHelper__Context__qvtr__loop__.addConsumedConnection(accumulator_5);
			CTOR_MAP_mmapHelper__Operation__qvtr__loop__.addAppendedConnection(accumulator_5);
			CTOR_MAP_mmapHelper__Operation__qvtr__loop__.addConsumedConnection(accumulator_6);
			CTOR_MAP_mmapHelper__verdict__qvtr.addConsumedConnection(accumulator);
			new AbstractSimpleInvocation(lazyCreateInterval(5/*..null*/), "mmapIfExp__qvtr__loop__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapIfExp trace_27 : accumulator_7.typedIterable(TmapIfExp.class)) {
						MAP_mmapIfExp__qvtr__loop__(trace_27);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(5/*..null*/), "mmapModule__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapModule trace_28 : accumulator_13.typedIterable(TmapModule.class)) {
						MAP_mmapModule__qvtr__rest__(trace_28);
					}
					return true;
				}
			};
			CTOR_MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__ini.addConsumedConnection(accumulator_14);
			CTOR_MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__loo.addConsumedConnection(accumulator_14);
			CTOR_MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__l.addConsumedConnection(accumulator_15);
			CTOR_MAP_mmapOclExpression__verdict__qvtr.addConsumedConnection(accumulator_0);
			CTOR_MAP_mmapOperationCallExp__Helper__qvtr__init__.addConsumedConnection(accumulator_20);
			CTOR_MAP_mmapOperationCallExp__Helper__qvtr__loop__.addConsumedConnection(accumulator_20);
			CTOR_MAP_mmapOperationCallExp__Operation__qvtr__loop__.addConsumedConnection(accumulator_21);
			CTOR_MAP_mmapOperatorCallExp__qvtr__loop__.addConsumedConnection(accumulator_23);
			new AbstractSimpleInvocation(lazyCreateInterval(6/*..null*/), "mmapInPattern__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapInPattern trace_36 : accumulator_8.typedIterable(TmapInPattern.class)) {
						MAP_mmapInPattern__qvtr__rest__(trace_36);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(6/*..null*/), "mmapSimpleInPatternElement__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapSimpleInPatternElement trace_37 : accumulator_24.typedIterable(TmapSimpleInPatternElement.class)) {
						MAP_mmapSimpleInPatternElement__qvtr__init__(accumulator_27, trace_37);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(6/*..null*/), "mmapSimpleOutPatternElement__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapSimpleOutPatternElement trace_38 : accumulator_25.typedIterable(TmapSimpleOutPatternElement.class)) {
						MAP_mmapSimpleOutPatternElement__qvtr__rest__(trace_38);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(6/*..null*/), "mmapVariableExp__referredVariable__Helper__qvtr__in") {
				@Override
				public boolean execute() {
					for (@NonNull TmapVariableExp_referredVariable_Helper trace_39 : accumulator_29.typedIterable(TmapVariableExp_referredVariable_Helper.class)) {
						MAP_mmapVariableExp__referredVariable__Helper__qvtr__in(trace_39);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapBinding__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapBinding trace_40 : accumulator_2.typedIterable(TmapBinding.class)) {
						MAP_mmapBinding__qvtr__init__(trace_40);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapHelper__Attribute__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapHelper_Attribute trace_41 : accumulator_4.typedIterable(TmapHelper_Attribute.class)) {
						MAP_mmapHelper__Attribute__qvtr__rest__(trace_41);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapHelper__Operation__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapHelper_Operation trace_42 : accumulator_6.typedIterable(TmapHelper_Operation.class)) {
						MAP_mmapHelper__Operation__qvtr__rest__(trace_42);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapIfExp__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapIfExp trace_43 : accumulator_7.typedIterable(TmapIfExp.class)) {
						MAP_mmapIfExp__qvtr__rest__(trace_43);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapInPattern__filter__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapInPattern_filter trace_44 : accumulator_9.typedIterable(TmapInPattern_filter.class)) {
						MAP_mmapInPattern__filter__qvtr__init__(trace_44);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapNavigationOrAttributeCallExp__Helper__qvtr__res") {
				@Override
				public boolean execute() {
					for (@NonNull TmapNavigationOrAttributeCallExp_Helper trace_45 : accumulator_14.typedIterable(TmapNavigationOrAttributeCallExp_Helper.class)) {
						MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__res(trace_45);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapNavigationOrAttributeCallExp__Property__qvtr__r") {
				@Override
				public boolean execute() {
					for (@NonNull TmapNavigationOrAttributeCallExp_Property trace_46 : accumulator_15.typedIterable(TmapNavigationOrAttributeCallExp_Property.class)) {
						MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__r(trace_46);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapOperationCallExp__Helper__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperationCallExp_Helper trace_47 : accumulator_20.typedIterable(TmapOperationCallExp_Helper.class)) {
						MAP_mmapOperationCallExp__Helper__qvtr__rest__(trace_47);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapOperationCallExp__Operation__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperationCallExp_Operation trace_48 : accumulator_21.typedIterable(TmapOperationCallExp_Operation.class)) {
						MAP_mmapOperationCallExp__Operation__qvtr__rest__(trace_48);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapOperationCallExp__argument__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperationCallExp_argument trace_49 : accumulator_22.typedIterable(TmapOperationCallExp_argument.class)) {
						MAP_mmapOperationCallExp__argument__qvtr__init__(trace_49);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapOperatorCallExp__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperatorCallExp trace_50 : accumulator_23.typedIterable(TmapOperatorCallExp.class)) {
						MAP_mmapOperatorCallExp__qvtr__rest__(trace_50);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapVariableExp__referredVariable__VariableDeclarat") {
				@Override
				public boolean execute() {
					for (@NonNull TmapVariableExp_referredVariable_VariableDeclaration trace_51 : accumulator_30.typedIterable(TmapVariableExp_referredVariable_VariableDeclaration.class)) {
						MAP_mmapVariableExp__referredVariable__VariableDeclarat(trace_51);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapVariable__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapVariable trace_52 : accumulator_27.typedIterable(TmapVariable.class)) {
						MAP_mmapVariable__qvtr__init__(trace_52);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(8/*..null*/), "mmapNavigationOrAttributeCallExp__Helper__qvtr__xtr") {
				@Override
				public boolean execute() {
					for (@NonNull TmapNavigationOrAttributeCallExp_Helper trace_53 : accumulator_14.typedIterable(TmapNavigationOrAttributeCallExp_Helper.class)) {
						MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__xtr(trace_53);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(8/*..null*/), "mmapOperationCallExp__Helper__qvtr__xtra__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperationCallExp_Helper trace_54 : accumulator_20.typedIterable(TmapOperationCallExp_Helper.class)) {
						MAP_mmapOperationCallExp__Helper__qvtr__xtra__(trace_54);
					}
					return true;
				}
			};
			CTOR_MAP_mmapVariableExp__referredVariable__Helper__qvtr__lo.addConsumedConnection(accumulator_29);
			new AbstractSimpleInvocation(lazyCreateInterval(8/*..null*/), "mmapVariableExp__referredVariable__VariableDeclarat_1") {
				@Override
				public boolean execute() {
					for (@NonNull TmapVariableExp_referredVariable_VariableDeclaration trace_56 : accumulator_30.typedIterable(TmapVariableExp_referredVariable_VariableDeclaration.class)) {
						MAP_mmapVariableExp__referredVariable__VariableDeclarat_1(trace_56);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapVariableExp__referredVariable__Helper__qvtr__xt") {
				@Override
				public boolean execute() {
					for (@NonNull TmapVariableExp_referredVariable_Helper trace_57 : accumulator_29.typedIterable(TmapVariableExp_referredVariable_Helper.class)) {
						MAP_mmapVariableExp__referredVariable__Helper__qvtr__xt(trace_57);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapVariableExp__referredVariable__verdict__qvtr") {
				@Override
				public boolean execute() {
					for (@NonNull DmapVariableExp_referredVariable mapVariableExp_referredVariable : accumulator_1.typedIterable(DmapVariableExp_referredVariable.class)) {
						MAP_mmapVariableExp__referredVariable__verdict__qvtr(mapVariableExp_referredVariable);
					}
					return true;
				}
			};
			CTOR_MAP_mmapIfExp__qvtr__xtra__.addConsumedConnection(accumulator_7);
			CTOR_MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__x.addConsumedConnection(accumulator_15);
			CTOR_MAP_mmapOperationCallExp__Operation__qvtr__xtra__.addConsumedConnection(accumulator_21);
			CTOR_MAP_mmapOperatorCallExp__qvtr__xtra__.addConsumedConnection(accumulator_23);
			final /*@NonInvalid*/ boolean r_ATL2QVTr__qvtr__load__ = ValueUtil.TRUE_VALUE;
			return r_ATL2QVTr__qvtr__load__;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(ji_Binding, thoseValues[0])
					&& idResolver.oclEquals(ji_Helper, thoseValues[1])
					&& idResolver.oclEquals(ji_InPattern, thoseValues[2])
					&& idResolver.oclEquals(ji_MatchedRule, thoseValues[3])
					&& idResolver.oclEquals(ji_Module, thoseValues[4])
					&& idResolver.oclEquals(ji_NavigationOrAttributeCallExp, thoseValues[5])
					&& idResolver.oclEquals(ji_OclExpression, thoseValues[6])
					&& idResolver.oclEquals(ji_OclModel, thoseValues[7])
					&& idResolver.oclEquals(ji_OperationCallExp, thoseValues[8])
					&& idResolver.oclEquals(ji_SimpleInPatternElement, thoseValues[9])
					&& idResolver.oclEquals(ji_SimpleOutPatternElement, thoseValues[10])
					&& idResolver.oclEquals(ji_VariableExp, thoseValues[11]);
		}
	}

	/**
	 *
	 * map:1 mmapBinding__qvtr__ctor__ in ATL2QVTr {
	 * guard:atl atlBinding : ATL::Binding[1];
	 * append jm_TmapBinding  : trace_ATL2QVTr::TmapBinding[1];
	 * new:middle trace : trace_ATL2QVTr::TmapBinding[1];
	 * set trace.t3atlBinding := atlBinding;
	 * add jm_TmapBinding += trace;
	 *
	 */
	protected boolean MAP_mmapBinding__qvtr__ctor__(final /*@NonInvalid*/ @NonNull Binding atlBinding, final @NonNull Connection jm_TmapBinding)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapBinding__qvtr__ctor__" +
					"\n\t\"atlBinding\":" + toDebugString(atlBinding));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapBinding trace = trace_ATL2QVTrFactory.eINSTANCE.createTmapBinding();
		MODEL_middle.add(trace, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace));
		}
		// mapping statements
		trace.setT3atlBinding(atlBinding);
		jm_TmapBinding.appendElement(trace);
		final /*@NonInvalid*/ boolean mmapBinding__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapBinding__qvtr__ctor__ ? "done "  : "fail ") + "MAP_mmapBinding__qvtr__ctor__");
		}
		return mmapBinding__qvtr__ctor__;
	}

	/**
	 *
	 * map:1 mmapHelper__dispatch__qvtr in ATL2QVTr {
	 * guard:atl atlHelper : ATL::Helper[1];
	 * append jm_DmapHelper  : trace_ATL2QVTr::DmapHelper[1];
	 * append jm_TmapHelper__Attribute  : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * append jm_TmapHelper__Operation  : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * new:middle dispatcher : trace_ATL2QVTr::DmapHelper[1];
	 * new:middle mapHelper_Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * new:middle mapHelper_Operation : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * set dispatcher.d3atlHelper := atlHelper;
	 * set dispatcher.domapHelper_Attribute := mapHelper_Attribute;
	 * set dispatcher.domapHelper_Operation := mapHelper_Operation;
	 * add jm_DmapHelper += dispatcher;
	 * add jm_TmapHelper__Attribute += mapHelper_Attribute;
	 * add jm_TmapHelper__Operation += mapHelper_Operation;
	 *
	 */
	protected boolean MAP_mmapHelper__dispatch__qvtr(final /*@NonInvalid*/ @NonNull Helper atlHelper, final @NonNull Connection jm_DmapHelper, final @NonNull Connection jm_TmapHelper__Attribute, final @NonNull Connection jm_TmapHelper__Operation)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapHelper__dispatch__qvtr" +
					"\n\t\"atlHelper\":" + toDebugString(atlHelper));
		}
		// creations
		final @SuppressWarnings("null")@NonNull DmapHelper dispatcher = trace_ATL2QVTrFactory.eINSTANCE.createDmapHelper();
		MODEL_middle.add(dispatcher, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(dispatcher));
		}
		final @SuppressWarnings("null")@NonNull TmapHelper_Attribute mapHelper_Attribute = trace_ATL2QVTrFactory.eINSTANCE.createTmapHelper_Attribute();
		MODEL_middle.add(mapHelper_Attribute, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapHelper_Attribute));
		}
		final @SuppressWarnings("null")@NonNull TmapHelper_Operation mapHelper_Operation = trace_ATL2QVTrFactory.eINSTANCE.createTmapHelper_Operation();
		MODEL_middle.add(mapHelper_Operation, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapHelper_Operation));
		}
		// mapping statements
		OPPOSITE_OF_DmapHelper_d3atlHelper.put(atlHelper, dispatcher);
		dispatcher.setD3atlHelper(atlHelper);
		dispatcher.setDomapHelper_Attribute(mapHelper_Attribute);
		dispatcher.setDomapHelper_Operation(mapHelper_Operation);
		jm_DmapHelper.appendElement(dispatcher);
		jm_TmapHelper__Attribute.appendElement(mapHelper_Attribute);
		jm_TmapHelper__Operation.appendElement(mapHelper_Operation);
		final /*@NonInvalid*/ boolean mmapHelper__dispatch__qvtr = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapHelper__dispatch__qvtr ? "done "  : "fail ") + "MAP_mmapHelper__dispatch__qvtr");
		}
		return mmapHelper__dispatch__qvtr;
	}

	/**
	 *
	 * map:1 mmapInPattern__filter__qvtr__ctor__ in ATL2QVTr {
	 * guard:atl atlPattern : ATL::InPattern[1];
	 * append jm_TmapInPattern__filter  : trace_ATL2QVTr::TmapInPattern_filter[1];
	 * new:middle trace : trace_ATL2QVTr::TmapInPattern_filter[1];
	 * set trace.t3atlPattern := atlPattern;
	 * add jm_TmapInPattern__filter += trace;
	 *
	 */
	protected boolean MAP_mmapInPattern__filter__qvtr__ctor__(final /*@NonInvalid*/ @NonNull InPattern atlPattern, final @NonNull Connection jm_TmapInPattern__filter)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapInPattern__filter__qvtr__ctor__" +
					"\n\t\"atlPattern\":" + toDebugString(atlPattern));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapInPattern_filter trace = trace_ATL2QVTrFactory.eINSTANCE.createTmapInPattern_filter();
		MODEL_middle.add(trace, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace));
		}
		// mapping statements
		trace.setT3atlPattern(atlPattern);
		jm_TmapInPattern__filter.appendElement(trace);
		final /*@NonInvalid*/ boolean mmapInPattern__filter__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapInPattern__filter__qvtr__ctor__ ? "done "  : "fail ") + "MAP_mmapInPattern__filter__qvtr__ctor__");
		}
		return mmapInPattern__filter__qvtr__ctor__;
	}

	/**
	 *
	 * map:1 mmapInPattern__qvtr__ctor__ in ATL2QVTr {
	 * guard:atl atlPattern : ATL::InPattern[1];
	 * append jm_TmapInPattern  : trace_ATL2QVTr::TmapInPattern[1];
	 * new:middle trace : trace_ATL2QVTr::TmapInPattern[1];
	 * set trace.t3atlPattern := atlPattern;
	 * add jm_TmapInPattern += trace;
	 *
	 */
	protected boolean MAP_mmapInPattern__qvtr__ctor__(final /*@NonInvalid*/ @NonNull InPattern atlPattern, final @NonNull Connection jm_TmapInPattern)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapInPattern__qvtr__ctor__" +
					"\n\t\"atlPattern\":" + toDebugString(atlPattern));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapInPattern trace = trace_ATL2QVTrFactory.eINSTANCE.createTmapInPattern();
		MODEL_middle.add(trace, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace));
		}
		// mapping statements
		OPPOSITE_OF_TmapInPattern_t3atlPattern.put(atlPattern, trace);
		trace.setT3atlPattern(atlPattern);
		jm_TmapInPattern.appendElement(trace);
		final /*@NonInvalid*/ boolean mmapInPattern__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapInPattern__qvtr__ctor__ ? "done "  : "fail ") + "MAP_mmapInPattern__qvtr__ctor__");
		}
		return mmapInPattern__qvtr__ctor__;
	}

	/**
	 *
	 * map:1 mmapMatchedRule__qvtr__ctor__ in ATL2QVTr {
	 * guard:atl matchedRule : ATL::MatchedRule[1];
	 * append jm_TmapMatchedRule  : trace_ATL2QVTr::TmapMatchedRule[1];
	 * new:middle trace : trace_ATL2QVTr::TmapMatchedRule[1];
	 * set trace.t3matchedRule := matchedRule;
	 * add jm_TmapMatchedRule += trace;
	 *
	 */
	protected boolean MAP_mmapMatchedRule__qvtr__ctor__(final @NonNull Connection jm_TmapMatchedRule, final /*@NonInvalid*/ @NonNull MatchedRule matchedRule)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapMatchedRule__qvtr__ctor__" +
					"\n\t\"matchedRule\":" + toDebugString(matchedRule));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapMatchedRule trace = trace_ATL2QVTrFactory.eINSTANCE.createTmapMatchedRule();
		MODEL_middle.add(trace, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace));
		}
		// mapping statements
		OPPOSITE_OF_TmapMatchedRule_t3matchedRule.put(matchedRule, trace);
		trace.setT3matchedRule(matchedRule);
		jm_TmapMatchedRule.appendElement(trace);
		final /*@NonInvalid*/ boolean mmapMatchedRule__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapMatchedRule__qvtr__ctor__ ? "done "  : "fail ") + "MAP_mmapMatchedRule__qvtr__ctor__");
		}
		return mmapMatchedRule__qvtr__ctor__;
	}

	/**
	 *
	 * map:1 mmapMatchedRule__super__qvtr__ctor__ in ATL2QVTr {
	 * guard:atl atlChildRule : ATL::MatchedRule[1];
	 * append jm_TmapMatchedRule__super  : trace_ATL2QVTr::TmapMatchedRule_super[1];
	 * new:middle trace : trace_ATL2QVTr::TmapMatchedRule_super[1];
	 * set trace.t3atlChildRule := atlChildRule;
	 * add jm_TmapMatchedRule__super += trace;
	 *
	 */
	protected boolean MAP_mmapMatchedRule__super__qvtr__ctor__(final /*@NonInvalid*/ @NonNull MatchedRule atlChildRule, final @NonNull Connection jm_TmapMatchedRule__super)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapMatchedRule__super__qvtr__ctor__" +
					"\n\t\"atlChildRule\":" + toDebugString(atlChildRule));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapMatchedRule_super trace = trace_ATL2QVTrFactory.eINSTANCE.createTmapMatchedRule_super();
		MODEL_middle.add(trace, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace));
		}
		// mapping statements
		trace.setT3atlChildRule(atlChildRule);
		jm_TmapMatchedRule__super.appendElement(trace);
		final /*@NonInvalid*/ boolean mmapMatchedRule__super__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapMatchedRule__super__qvtr__ctor__ ? "done "  : "fail ") + "MAP_mmapMatchedRule__super__qvtr__ctor__");
		}
		return mmapMatchedRule__super__qvtr__ctor__;
	}

	/**
	 *
	 * map:1 mmapModule__qvtr__ctor__ in ATL2QVTr {
	 * guard:atl atlModule : ATL::Module[1];
	 * append jm_TmapModule  : trace_ATL2QVTr::TmapModule[1];
	 * new:middle trace : trace_ATL2QVTr::TmapModule[1];
	 * set trace.t3atlModule := atlModule;
	 * add jm_TmapModule += trace;
	 *
	 */
	protected boolean MAP_mmapModule__qvtr__ctor__(final /*@NonInvalid*/ @NonNull Module atlModule, final @NonNull Connection jm_TmapModule)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapModule__qvtr__ctor__" +
					"\n\t\"atlModule\":" + toDebugString(atlModule));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapModule trace = trace_ATL2QVTrFactory.eINSTANCE.createTmapModule();
		MODEL_middle.add(trace, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace));
		}
		// mapping statements
		OPPOSITE_OF_TmapModule_t3atlModule.put(atlModule, trace);
		trace.setT3atlModule(atlModule);
		jm_TmapModule.appendElement(trace);
		final /*@NonInvalid*/ boolean mmapModule__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapModule__qvtr__ctor__ ? "done "  : "fail ") + "MAP_mmapModule__qvtr__ctor__");
		}
		return mmapModule__qvtr__ctor__;
	}

	/**
	 *
	 * map:1 mmapOclExpression__dispatch__qvtr in ATL2QVTr {
	 * guard:atl atlExpression : OCL::OclExpression[1];
	 * append jm_DmapOclExpression  : trace_ATL2QVTr::DmapOclExpression[1];
	 * append jm_TmapBooleanExp  : trace_ATL2QVTr::TmapBooleanExp[1];
	 * append jm_TmapIfExp  : trace_ATL2QVTr::TmapIfExp[1];
	 * append jm_TmapIntegerExp  : trace_ATL2QVTr::TmapIntegerExp[1];
	 * append jm_TmapNavigationOrAttributeCallExp__Helper  : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * append jm_TmapNavigationOrAttributeCallExp__Property  : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * append jm_TmapOclType  : trace_ATL2QVTr::TmapOclType[1];
	 * append jm_TmapOperationCallExp__Helper  : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * append jm_TmapOperationCallExp__Operation  : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * append jm_TmapOperatorCallExp  : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * append jm_TmapStringExp  : trace_ATL2QVTr::TmapStringExp[1];
	 * append jm_TmapVariableExp  : trace_ATL2QVTr::TmapVariableExp[1];
	 * new:middle dispatcher : trace_ATL2QVTr::DmapOclExpression[1];
	 * new:middle mapBooleanExp : trace_ATL2QVTr::TmapBooleanExp[1];
	 * new:middle mapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * new:middle mapIntegerExp : trace_ATL2QVTr::TmapIntegerExp[1];
	 * new:middle mapNavigationOrAttributeCallExp_Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * new:middle mapNavigationOrAttributeCallExp_Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * new:middle mapOclType : trace_ATL2QVTr::TmapOclType[1];
	 * new:middle mapOperationCallExp_Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * new:middle mapOperationCallExp_Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * new:middle mapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * new:middle mapStringExp : trace_ATL2QVTr::TmapStringExp[1];
	 * new:middle mapVariableExp : trace_ATL2QVTr::TmapVariableExp[1];
	 * set dispatcher.d3atlExpression := atlExpression;
	 * set dispatcher.domapBooleanExp := mapBooleanExp;
	 * set dispatcher.domapIfExp := mapIfExp;
	 * set dispatcher.domapIntegerExp := mapIntegerExp;
	 * set dispatcher.domapNavigationOrAttributeCallExp_Helper := mapNavigationOrAttributeCallExp_Helper;
	 * set dispatcher.domapNavigationOrAttributeCallExp_Property := mapNavigationOrAttributeCallExp_Property;
	 * set dispatcher.domapOclType := mapOclType;
	 * set dispatcher.domapOperationCallExp_Helper := mapOperationCallExp_Helper;
	 * set dispatcher.domapOperationCallExp_Operation := mapOperationCallExp_Operation;
	 * set dispatcher.domapOperatorCallExp := mapOperatorCallExp;
	 * set dispatcher.domapStringExp := mapStringExp;
	 * set dispatcher.domapVariableExp := mapVariableExp;
	 * add jm_DmapOclExpression += dispatcher;
	 * add jm_TmapBooleanExp += mapBooleanExp;
	 * add jm_TmapIfExp += mapIfExp;
	 * add jm_TmapIntegerExp += mapIntegerExp;
	 * add jm_TmapNavigationOrAttributeCallExp__Helper += mapNavigationOrAttributeCallExp_Helper;
	 * add jm_TmapNavigationOrAttributeCallExp__Property += mapNavigationOrAttributeCallExp_Property;
	 * add jm_TmapOclType += mapOclType;
	 * add jm_TmapOperationCallExp__Helper += mapOperationCallExp_Helper;
	 * add jm_TmapOperationCallExp__Operation += mapOperationCallExp_Operation;
	 * add jm_TmapOperatorCallExp += mapOperatorCallExp;
	 * add jm_TmapStringExp += mapStringExp;
	 * add jm_TmapVariableExp += mapVariableExp;
	 *
	 */
	protected boolean MAP_mmapOclExpression__dispatch__qvtr(final /*@NonInvalid*/ @NonNull OclExpression atlExpression, final @NonNull Connection jm_DmapOclExpression, final @NonNull Connection jm_TmapBooleanExp, final @NonNull Connection jm_TmapIfExp, final @NonNull Connection jm_TmapIntegerExp, final @NonNull Connection jm_TmapNavigationOrAttributeCallExp__Helper, final @NonNull Connection jm_TmapNavigationOrAttributeCallExp__Property, final @NonNull Connection jm_TmapOclType, final @NonNull Connection jm_TmapOperationCallExp__Helper, final @NonNull Connection jm_TmapOperationCallExp__Operation, final @NonNull Connection jm_TmapOperatorCallExp, final @NonNull Connection jm_TmapStringExp, final @NonNull Connection jm_TmapVariableExp)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclExpression__dispatch__qvtr" +
					"\n\t\"atlExpression\":" + toDebugString(atlExpression));
		}
		// creations
		final @SuppressWarnings("null")@NonNull DmapOclExpression dispatcher = trace_ATL2QVTrFactory.eINSTANCE.createDmapOclExpression();
		MODEL_middle.add(dispatcher, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(dispatcher));
		}
		final @SuppressWarnings("null")@NonNull TmapBooleanExp mapBooleanExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapBooleanExp();
		MODEL_middle.add(mapBooleanExp, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapBooleanExp));
		}
		final @SuppressWarnings("null")@NonNull TmapIfExp mapIfExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapIfExp();
		MODEL_middle.add(mapIfExp, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapIfExp));
		}
		final @SuppressWarnings("null")@NonNull TmapIntegerExp mapIntegerExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapIntegerExp();
		MODEL_middle.add(mapIntegerExp, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapIntegerExp));
		}
		final @SuppressWarnings("null")@NonNull TmapNavigationOrAttributeCallExp_Helper mapNavigationOrAttributeCallExp_Helper = trace_ATL2QVTrFactory.eINSTANCE.createTmapNavigationOrAttributeCallExp_Helper();
		MODEL_middle.add(mapNavigationOrAttributeCallExp_Helper, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapNavigationOrAttributeCallExp_Helper));
		}
		final @SuppressWarnings("null")@NonNull TmapNavigationOrAttributeCallExp_Property mapNavigationOrAttributeCallExp_Property = trace_ATL2QVTrFactory.eINSTANCE.createTmapNavigationOrAttributeCallExp_Property();
		MODEL_middle.add(mapNavigationOrAttributeCallExp_Property, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapNavigationOrAttributeCallExp_Property));
		}
		final @SuppressWarnings("null")@NonNull TmapOclType mapOclType = trace_ATL2QVTrFactory.eINSTANCE.createTmapOclType();
		MODEL_middle.add(mapOclType, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapOclType));
		}
		final @SuppressWarnings("null")@NonNull TmapOperationCallExp_Helper mapOperationCallExp_Helper = trace_ATL2QVTrFactory.eINSTANCE.createTmapOperationCallExp_Helper();
		MODEL_middle.add(mapOperationCallExp_Helper, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapOperationCallExp_Helper));
		}
		final @SuppressWarnings("null")@NonNull TmapOperationCallExp_Operation mapOperationCallExp_Operation = trace_ATL2QVTrFactory.eINSTANCE.createTmapOperationCallExp_Operation();
		MODEL_middle.add(mapOperationCallExp_Operation, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapOperationCallExp_Operation));
		}
		final @SuppressWarnings("null")@NonNull TmapOperatorCallExp mapOperatorCallExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapOperatorCallExp();
		MODEL_middle.add(mapOperatorCallExp, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapOperatorCallExp));
		}
		final @SuppressWarnings("null")@NonNull TmapStringExp mapStringExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapStringExp();
		MODEL_middle.add(mapStringExp, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapStringExp));
		}
		final @SuppressWarnings("null")@NonNull TmapVariableExp mapVariableExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapVariableExp();
		MODEL_middle.add(mapVariableExp, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapVariableExp));
		}
		// mapping statements
		OPPOSITE_OF_DmapOclExpression_d3atlExpression.put(atlExpression, dispatcher);
		dispatcher.setD3atlExpression(atlExpression);
		dispatcher.setDomapBooleanExp(mapBooleanExp);
		dispatcher.setDomapIfExp(mapIfExp);
		dispatcher.setDomapIntegerExp(mapIntegerExp);
		dispatcher.setDomapNavigationOrAttributeCallExp_Helper(mapNavigationOrAttributeCallExp_Helper);
		dispatcher.setDomapNavigationOrAttributeCallExp_Property(mapNavigationOrAttributeCallExp_Property);
		dispatcher.setDomapOclType(mapOclType);
		dispatcher.setDomapOperationCallExp_Helper(mapOperationCallExp_Helper);
		dispatcher.setDomapOperationCallExp_Operation(mapOperationCallExp_Operation);
		dispatcher.setDomapOperatorCallExp(mapOperatorCallExp);
		dispatcher.setDomapStringExp(mapStringExp);
		dispatcher.setDomapVariableExp(mapVariableExp);
		jm_DmapOclExpression.appendElement(dispatcher);
		jm_TmapBooleanExp.appendElement(mapBooleanExp);
		jm_TmapIfExp.appendElement(mapIfExp);
		jm_TmapIntegerExp.appendElement(mapIntegerExp);
		jm_TmapNavigationOrAttributeCallExp__Helper.appendElement(mapNavigationOrAttributeCallExp_Helper);
		jm_TmapNavigationOrAttributeCallExp__Property.appendElement(mapNavigationOrAttributeCallExp_Property);
		jm_TmapOclType.appendElement(mapOclType);
		jm_TmapOperationCallExp__Helper.appendElement(mapOperationCallExp_Helper);
		jm_TmapOperationCallExp__Operation.appendElement(mapOperationCallExp_Operation);
		jm_TmapOperatorCallExp.appendElement(mapOperatorCallExp);
		jm_TmapStringExp.appendElement(mapStringExp);
		jm_TmapVariableExp.appendElement(mapVariableExp);
		final /*@NonInvalid*/ boolean mmapOclExpression__dispatch__qvtr = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapOclExpression__dispatch__qvtr ? "done "  : "fail ") + "MAP_mmapOclExpression__dispatch__qvtr");
		}
		return mmapOclExpression__dispatch__qvtr;
	}

	/**
	 *
	 * map:1 mmapOclMetamodel__qvtr__ctor__ in ATL2QVTr {
	 * guard:atl oclMetamodel : OCL::OclModel[1];
	 * append jm_TmapOclMetamodel  : trace_ATL2QVTr::TmapOclMetamodel[1];
	 * new:middle trace : trace_ATL2QVTr::TmapOclMetamodel[1];
	 * set trace.t3oclMetamodel := oclMetamodel;
	 * add jm_TmapOclMetamodel += trace;
	 *
	 */
	protected boolean MAP_mmapOclMetamodel__qvtr__ctor__(final @NonNull Connection jm_TmapOclMetamodel, final /*@NonInvalid*/ @NonNull OclModel oclMetamodel)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclMetamodel__qvtr__ctor__" +
					"\n\t\"oclMetamodel\":" + toDebugString(oclMetamodel));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapOclMetamodel trace = trace_ATL2QVTrFactory.eINSTANCE.createTmapOclMetamodel();
		MODEL_middle.add(trace, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace));
		}
		// mapping statements
		OPPOSITE_OF_TmapOclMetamodel_t3oclMetamodel.put(oclMetamodel, trace);
		trace.setT3oclMetamodel(oclMetamodel);
		jm_TmapOclMetamodel.appendElement(trace);
		final /*@NonInvalid*/ boolean mmapOclMetamodel__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapOclMetamodel__qvtr__ctor__ ? "done "  : "fail ") + "MAP_mmapOclMetamodel__qvtr__ctor__");
		}
		return mmapOclMetamodel__qvtr__ctor__;
	}

	/**
	 *
	 * map:1 mmapOclModel__IN__qvtr__ctor__ in ATL2QVTr {
	 * guard:atl oclModel : OCL::OclModel[1];
	 * append jm_TmapOclModel__IN  : trace_ATL2QVTr::TmapOclModel_IN[1];
	 * new:middle trace : trace_ATL2QVTr::TmapOclModel_IN[1];
	 * set trace.t3oclModel := oclModel;
	 * add jm_TmapOclModel__IN += trace;
	 *
	 */
	protected boolean MAP_mmapOclModel__IN__qvtr__ctor__(final @NonNull Connection jm_TmapOclModel__IN, final /*@NonInvalid*/ @NonNull OclModel oclModel)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclModel__IN__qvtr__ctor__" +
					"\n\t\"oclModel\":" + toDebugString(oclModel));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapOclModel_IN trace = trace_ATL2QVTrFactory.eINSTANCE.createTmapOclModel_IN();
		MODEL_middle.add(trace, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace));
		}
		// mapping statements
		trace.setT3oclModel(oclModel);
		jm_TmapOclModel__IN.appendElement(trace);
		final /*@NonInvalid*/ boolean mmapOclModel__IN__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapOclModel__IN__qvtr__ctor__ ? "done "  : "fail ") + "MAP_mmapOclModel__IN__qvtr__ctor__");
		}
		return mmapOclModel__IN__qvtr__ctor__;
	}

	/**
	 *
	 * map:1 mmapOclModel__OUT__qvtr__ctor__ in ATL2QVTr {
	 * guard:atl oclModel : OCL::OclModel[1];
	 * append jm_TmapOclModel__OUT  : trace_ATL2QVTr::TmapOclModel_OUT[1];
	 * new:middle trace : trace_ATL2QVTr::TmapOclModel_OUT[1];
	 * set trace.t3oclModel := oclModel;
	 * add jm_TmapOclModel__OUT += trace;
	 *
	 */
	protected boolean MAP_mmapOclModel__OUT__qvtr__ctor__(final @NonNull Connection jm_TmapOclModel__OUT, final /*@NonInvalid*/ @NonNull OclModel oclModel)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclModel__OUT__qvtr__ctor__" +
					"\n\t\"oclModel\":" + toDebugString(oclModel));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapOclModel_OUT trace = trace_ATL2QVTrFactory.eINSTANCE.createTmapOclModel_OUT();
		MODEL_middle.add(trace, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace));
		}
		// mapping statements
		trace.setT3oclModel(oclModel);
		jm_TmapOclModel__OUT.appendElement(trace);
		final /*@NonInvalid*/ boolean mmapOclModel__OUT__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapOclModel__OUT__qvtr__ctor__ ? "done "  : "fail ") + "MAP_mmapOclModel__OUT__qvtr__ctor__");
		}
		return mmapOclModel__OUT__qvtr__ctor__;
	}

	/**
	 *
	 * map:1 mmapOperationCallExp__argument__qvtr__ctor__ in ATL2QVTr {
	 * guard:atl atlArgument : OCL::OclExpression[1];
	 * append jm_TmapOperationCallExp__argument  : trace_ATL2QVTr::TmapOperationCallExp_argument[1];
	 * new:middle trace : trace_ATL2QVTr::TmapOperationCallExp_argument[1];
	 * set trace.t3atlArgument := atlArgument;
	 * add jm_TmapOperationCallExp__argument += trace;
	 *
	 */
	protected boolean MAP_mmapOperationCallExp__argument__qvtr__ctor__(final /*@NonInvalid*/ @NonNull OclExpression atlArgument, final @NonNull Connection jm_TmapOperationCallExp__argument)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperationCallExp__argument__qvtr__ctor__" +
					"\n\t\"atlArgument\":" + toDebugString(atlArgument));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapOperationCallExp_argument trace = trace_ATL2QVTrFactory.eINSTANCE.createTmapOperationCallExp_argument();
		MODEL_middle.add(trace, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace));
		}
		// mapping statements
		trace.setT3atlArgument(atlArgument);
		jm_TmapOperationCallExp__argument.appendElement(trace);
		final /*@NonInvalid*/ boolean mmapOperationCallExp__argument__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapOperationCallExp__argument__qvtr__ctor__ ? "done "  : "fail ") + "MAP_mmapOperationCallExp__argument__qvtr__ctor__");
		}
		return mmapOperationCallExp__argument__qvtr__ctor__;
	}

	/**
	 *
	 * map:1 mmapSimpleInPatternElement__qvtr__ctor__ in ATL2QVTr {
	 * guard:atl atlElement : ATL::SimpleInPatternElement[1];
	 * append jm_TmapSimpleInPatternElement  : trace_ATL2QVTr::TmapSimpleInPatternElement[1];
	 * new:middle trace : trace_ATL2QVTr::TmapSimpleInPatternElement[1];
	 * set trace.t3atlElement := atlElement;
	 * add jm_TmapSimpleInPatternElement += trace;
	 *
	 */
	protected boolean MAP_mmapSimpleInPatternElement__qvtr__ctor__(final /*@NonInvalid*/ @NonNull SimpleInPatternElement atlElement, final @NonNull Connection jm_TmapSimpleInPatternElement)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapSimpleInPatternElement__qvtr__ctor__" +
					"\n\t\"atlElement\":" + toDebugString(atlElement));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapSimpleInPatternElement trace = trace_ATL2QVTrFactory.eINSTANCE.createTmapSimpleInPatternElement();
		MODEL_middle.add(trace, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace));
		}
		// mapping statements
		trace.setT3atlElement(atlElement);
		jm_TmapSimpleInPatternElement.appendElement(trace);
		final /*@NonInvalid*/ boolean mmapSimpleInPatternElement__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapSimpleInPatternElement__qvtr__ctor__ ? "done "  : "fail ") + "MAP_mmapSimpleInPatternElement__qvtr__ctor__");
		}
		return mmapSimpleInPatternElement__qvtr__ctor__;
	}

	/**
	 *
	 * map:1 mmapSimpleOutPatternElement__qvtr__ctor__ in ATL2QVTr {
	 * guard:atl atlElement : ATL::SimpleOutPatternElement[1];
	 * append jm_TmapSimpleOutPatternElement  : trace_ATL2QVTr::TmapSimpleOutPatternElement[1];
	 * new:middle trace : trace_ATL2QVTr::TmapSimpleOutPatternElement[1];
	 * set trace.t3atlElement := atlElement;
	 * add jm_TmapSimpleOutPatternElement += trace;
	 *
	 */
	protected boolean MAP_mmapSimpleOutPatternElement__qvtr__ctor__(final /*@NonInvalid*/ @NonNull SimpleOutPatternElement atlElement, final @NonNull Connection jm_TmapSimpleOutPatternElement)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapSimpleOutPatternElement__qvtr__ctor__" +
					"\n\t\"atlElement\":" + toDebugString(atlElement));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapSimpleOutPatternElement trace = trace_ATL2QVTrFactory.eINSTANCE.createTmapSimpleOutPatternElement();
		MODEL_middle.add(trace, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace));
		}
		// mapping statements
		OPPOSITE_OF_TmapSimpleOutPatternElement_t3atlElement.put(atlElement, trace);
		trace.setT3atlElement(atlElement);
		jm_TmapSimpleOutPatternElement.appendElement(trace);
		final /*@NonInvalid*/ boolean mmapSimpleOutPatternElement__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapSimpleOutPatternElement__qvtr__ctor__ ? "done "  : "fail ") + "MAP_mmapSimpleOutPatternElement__qvtr__ctor__");
		}
		return mmapSimpleOutPatternElement__qvtr__ctor__;
	}

	/**
	 *
	 * map:2 mmapBooleanExp__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapBooleanExp[1] success s0global;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapBooleanExp;
	 * check var atlExpression : OCL::BooleanExp[1] := dispatcher.d3atlExpression;
	 * var symbol : Boolean[1] := atlExpression.booleanSymbol;
	 * new:qvtr qvtrExpression : BooleanLiteralExp[1];
	 * set trace.t1symbol := symbol;
	 * set qvtrExpression.booleanSymbol := symbol;
	 * set dispatcher.d4qvtrExpression := qvtrExpression;
	 * set dispatcher.result := trace;
	 *
	 */
	protected boolean MAP_mmapBooleanExp__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapBooleanExp trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapBooleanExp__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapBooleanExp domapBooleanExp = dispatcher.getDomapBooleanExp();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapBooleanExp);
		/*@NonInvalid*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression d3atlExpression = dispatcher.getD3atlExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d3atlExpression instanceof BooleanExp;
			/*@NonInvalid*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ @Nullable BooleanExp CAST_d3atlExpression = (BooleanExp)d3atlExpression;
				final /*@NonInvalid*/ boolean booleanSymbol = CAST_d3atlExpression.isBooleanSymbol();
				// creations
				final @NonNull BooleanLiteralExp qvtrExpression = PivotFactory.eINSTANCE.createBooleanLiteralExp();
				MODEL_qvtr.add(qvtrExpression, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
				}
				// mapping statements
				trace.setT1symbol(booleanSymbol);
				qvtrExpression.setBooleanSymbol(booleanSymbol);
				dispatcher.setD4qvtrExpression(qvtrExpression);
				dispatcher.setResult(trace);
				final /*@NonInvalid*/ boolean mmapBooleanExp__qvtr__init__ = ValueUtil.TRUE_VALUE;
				IF_IsKINDOF_ = mmapBooleanExp__qvtr__init__;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0global(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapBooleanExp__qvtr__init__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:2 mmapIfExp__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapIfExp[1] success s0local;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapIfExp;
	 * check var atlExpression : OCL::IfExp[1] := dispatcher.d3atlExpression;
	 * var atlCondition : OCL::OclExpression[1] := atlExpression.condition;
	 * var atlElse : OCL::OclExpression[1] := atlExpression.elseExpression;
	 * var atlThen : OCL::OclExpression[1] := atlExpression.thenExpression;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlCondition.DmapOclExpression;
	 * var when_mapOclExpression1 : trace_ATL2QVTr::DmapOclExpression[1] := atlElse.DmapOclExpression;
	 * var when_mapOclExpression2 : trace_ATL2QVTr::DmapOclExpression[1] := atlThen.DmapOclExpression;
	 * set dispatcher.result := trace;
	 * set trace.t3atlCondition := atlCondition;
	 * set trace.t3atlElse := atlElse;
	 * set trace.t3atlThen := atlThen;
	 * set trace.wmapOclExpression1 := when_mapOclExpression;
	 * set trace.wmapOclExpression2 := when_mapOclExpression2;
	 * set trace.wmapOclExpression := when_mapOclExpression1;
	 *
	 */
	protected boolean MAP_mmapIfExp__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapIfExp trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapIfExp__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapIfExp domapIfExp = dispatcher.getDomapIfExp();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapIfExp);
		/*@NonInvalid*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression d3atlExpression = dispatcher.getD3atlExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d3atlExpression instanceof IfExp;
			/*@NonInvalid*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ @Nullable IfExp CAST_d3atlExpression = (IfExp)d3atlExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression condition = CAST_d3atlExpression.getCondition();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression elseExpression = CAST_d3atlExpression.getElseExpression();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression thenExpression = CAST_d3atlExpression.getThenExpression();
				final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(condition);
				final /*@NonInvalid*/ Boolean IsEQ__0 = DmapOclExpression != null;
				/*@NonInvalid*/ Boolean IF_IsEQ__0;
				if (IsEQ__0) {
					if (DmapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression_0 = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(elseExpression);
					final /*@NonInvalid*/ Boolean IsEQ__1 = DmapOclExpression_0 != null;
					/*@NonInvalid*/ Boolean IF_IsEQ__1;
					if (IsEQ__1) {
						if (DmapOclExpression_0 == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression_1 = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(thenExpression);
						final /*@NonInvalid*/ Boolean IsEQ__2 = DmapOclExpression_1 != null;
						/*@NonInvalid*/ Boolean IF_IsEQ__2;
						if (IsEQ__2) {
							if (DmapOclExpression_1 == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							// mapping statements
							dispatcher.setResult(trace);
							trace.setT3atlCondition(condition);
							trace.setT3atlElse(elseExpression);
							trace.setT3atlThen(thenExpression);
							trace.setWmapOclExpression1(DmapOclExpression);
							trace.setWmapOclExpression2(DmapOclExpression_1);
							trace.setWmapOclExpression(DmapOclExpression_0);
							final /*@NonInvalid*/ boolean mmapIfExp__qvtr__init__ = ValueUtil.TRUE_VALUE;
							IF_IsEQ__2 = mmapIfExp__qvtr__init__;
						}
						else {
							IF_IsEQ__2 = ValueUtil.FALSE_VALUE;
						}
						IF_IsEQ__1 = IF_IsEQ__2;
					}
					else {
						IF_IsEQ__1 = ValueUtil.FALSE_VALUE;
					}
					IF_IsEQ__0 = IF_IsEQ__1;
				}
				else {
					IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
				}
				IF_IsKINDOF_ = IF_IsEQ__0;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0local(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_IF_EXP__S0LOCAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapIfExp__qvtr__init__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:2 mmapIntegerExp__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapIntegerExp[1] success s0global;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapIntegerExp;
	 * check var atlExpression : OCL::IntegerExp[1] := dispatcher.d3atlExpression;
	 * var symbol : Integer[1] := atlExpression.integerSymbol;
	 * new:qvtr qvtrExpression : IntegerLiteralExp[1];
	 * set trace.t1symbol := symbol;
	 * set qvtrExpression.integerSymbol := symbol;
	 * set dispatcher.d4qvtrExpression := qvtrExpression;
	 * set dispatcher.result := trace;
	 *
	 */
	protected boolean MAP_mmapIntegerExp__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapIntegerExp trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapIntegerExp__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapIntegerExp domapIntegerExp = dispatcher.getDomapIntegerExp();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapIntegerExp);
		/*@NonInvalid*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression d3atlExpression = dispatcher.getD3atlExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d3atlExpression instanceof IntegerExp;
			/*@NonInvalid*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ @Nullable IntegerExp CAST_d3atlExpression = (IntegerExp)d3atlExpression;
				final /*@NonInvalid*/ int integerSymbol = CAST_d3atlExpression.getIntegerSymbol();
				// creations
				final @NonNull IntegerLiteralExp qvtrExpression = PivotFactory.eINSTANCE.createIntegerLiteralExp();
				MODEL_qvtr.add(qvtrExpression, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
				}
				// mapping statements
				trace.setT1symbol(ValueUtil.bigIntegerValueOf(integerSymbol));
				qvtrExpression.setIntegerSymbol(integerSymbol);
				dispatcher.setD4qvtrExpression(qvtrExpression);
				dispatcher.setResult(trace);
				final /*@NonInvalid*/ boolean mmapIntegerExp__qvtr__init__ = ValueUtil.TRUE_VALUE;
				IF_IsKINDOF_ = mmapIntegerExp__qvtr__init__;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0global(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapIntegerExp__qvtr__init__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:2 mmapModule__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapModule[1] success s0global;
	 * var atlModule : ATL::Module[1] := trace.t3atlModule;
	 * var txName : String[1] := atlModule.name;
	 * new:qvtr _3 : Package[1];
	 * new:qvtr _4 : qvtrelation::RelationModel[1];
	 * new:qvtr _5 : Parameter[1];
	 * new:qvtr _6 : qvtbase::TypedModel[1];
	 * new:qvtr qvtrTransformation : qvtrelation::RelationalTransformation[1];
	 * set qvtrTransformation.name := txName;
	 * set trace.t1txName := txName;
	 * set _4.ownedPackages := _3;
	 * notify set _5.type := qvtrTransformation;
	 * set _6.transformation := qvtrTransformation;
	 * set qvtrTransformation.ownedContext := _5;
	 * set qvtrTransformation.owningPackage := _3;
	 * set trace.t4_3 := _3;
	 * set trace.t4_4 := _4;
	 * set trace.t4_5 := _5;
	 * set trace.t4_6 := _6;
	 * set trace.t4qvtrTransformation := qvtrTransformation;
	 *
	 */
	protected boolean MAP_mmapModule__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapModule trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapModule__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Module t3atlModule = trace.getT3atlModule();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String name = t3atlModule.getName();
		// creations
		final org.eclipse.ocl.pivot.@NonNull Package _3 = PivotFactory.eINSTANCE.createPackage();
		MODEL_qvtr.add(_3, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(_3));
		}
		final @NonNull RelationModel _4 = QVTrelationFactory.eINSTANCE.createRelationModel();
		MODEL_qvtr.add(_4, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(_4));
		}
		final @NonNull Parameter _5 = PivotFactory.eINSTANCE.createParameter();
		MODEL_qvtr.add(_5, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(_5));
		}
		final @NonNull TypedModel _6 = QVTbaseFactory.eINSTANCE.createTypedModel();
		MODEL_qvtr.add(_6, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(_6));
		}
		final @NonNull RelationalTransformation qvtrTransformation = QVTrelationFactory.eINSTANCE.createRelationalTransformation();
		MODEL_qvtr.add(qvtrTransformation, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrTransformation));
		}
		// mapping statements
		qvtrTransformation.setName(name);
		trace.setT1txName(name);
		_4.getOwnedPackages().add(_3);
		_5.setType(qvtrTransformation);
		objectManager.assigned(_5, PivotPackage.Literals.TYPED_ELEMENT__TYPE, qvtrTransformation, false);
		_6.setTransformation(qvtrTransformation);
		qvtrTransformation.setOwnedContext(_5);
		qvtrTransformation.setOwningPackage(_3);
		trace.setT4_3(_3);
		trace.setT4_4(_4);
		trace.setT4_5(_5);
		trace.setT4_6(_6);
		trace.setT4qvtrTransformation(qvtrTransformation);
		final /*@NonInvalid*/ boolean mmapModule__qvtr__init__ = ValueUtil.TRUE_VALUE;
		trace.setS0global(mmapModule__qvtr__init__);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_MODULE__S0GLOBAL, mmapModule__qvtr__init__, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapModule__qvtr__init__ ? "done "  : "fail ") + "MAP_mmapModule__qvtr__init__");
		}
		return mmapModule__qvtr__init__;
	}

	/**
	 *
	 * map:2 mmapNavigationOrAttributeCallExp__Property__qvtr__i in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1] success s0local;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapNavigationOrAttributeCallExp_Property;
	 * check var atlExpression : OCL::NavigationOrAttributeCallExp[1] := dispatcher.d3atlExpression;
	 * var atlModule : ATL::Module[1] := this.getModule(atlExpression)
	 *   ;
	 * var elements : OrderedSet(ATL::ModuleElement) := atlModule.elements;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var collect : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(i | i.definition)
	 *   ;
	 * var collect1 : Sequence(OCL::OclFeature) := collect->collect(i | i.feature)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Attribute) := collect1->selectByKind(OCL::Attribute)
	 *   ;
	 * var select : Sequence(OCL::Attribute) := selectByKind1->select(i | i.name = atlExpression.name)
	 *   ;
	 * var isEmpty : Boolean[1] := select->isEmpty();
	 * check isEmpty;
	 * var propertyName : String[1] := atlExpression.name;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlSource.DmapOclExpression;
	 * set trace.t1propertyName := propertyName;
	 * set trace.t3atlAttributes := select;
	 * set dispatcher.result := trace;
	 * set trace.t3atlModule := atlModule;
	 * set trace.t3atlSource := atlSource;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected boolean MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__i(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__i" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Property domapNavigationOrAttributeCallExp_Property = dispatcher.getDomapNavigationOrAttributeCallExp_Property();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapNavigationOrAttributeCallExp_Property);
		/*@NonInvalid*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression d3atlExpression = dispatcher.getD3atlExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d3atlExpression instanceof NavigationOrAttributeCallExp;
			/*@NonInvalid*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ @Nullable NavigationOrAttributeCallExp CAST_d3atlExpression = (NavigationOrAttributeCallExp)d3atlExpression;
				final /*@NonInvalid*/ @NonNull Module getModule_0 = INSTANCE_CACHE_ATL2QVTr_getModule.evaluate(rootThis, CAST_d3atlExpression);
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<ModuleElement> elements = getModule_0.getElements();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ATL_c_c_Helper = idResolver.getClass(CLSSid_Helper, null);
				final /*@NonInvalid*/ @Nullable OrderedSetValue BOXED_elements = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleElement, elements);
				final /*@NonInvalid*/ @NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(rootExecutor, BOXED_elements, TYP_ATL_c_c_Helper);
				/*@NonInvalid*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeatureDefinition);
				@NonNull Iterator<Object> ITER_i = selectByKind.iterator();
				/*@NonInvalid*/ @NonNull SequenceValue collect;
				while (true) {
					if (!ITER_i.hasNext()) {
						collect = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull Helper i = (@NonNull Helper)ITER_i.next();
					/**
					 * i.definition
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = i.getDefinition();
					//
					accumulator.add(definition);
				}
				/*@NonInvalid*/ SequenceValue.@NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeature);
				@NonNull Iterator<Object> ITER_i_0 = collect.iterator();
				/*@NonInvalid*/ @NonNull SequenceValue collect_0;
				while (true) {
					if (!ITER_i_0.hasNext()) {
						collect_0 = accumulator_0;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull OclFeatureDefinition i_0 = (@NonNull OclFeatureDefinition)ITER_i_0.next();
					/**
					 * i.feature
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclFeature feature = i_0.getFeature();
					//
					accumulator_0.add(feature);
				}
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_Attribute = idResolver.getClass(CLSSid_Attribute, null);
				final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(rootExecutor, collect_0, TYP_OCL_c_c_Attribute);
				/*@NonInvalid*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Attribute);
				@NonNull Iterator<Object> ITER_i_1 = selectByKind_0.iterator();
				/*@NonInvalid*/ @NonNull SequenceValue select;
				while (true) {
					if (!ITER_i_1.hasNext()) {
						select = accumulator_1;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull Attribute i_1 = (@NonNull Attribute)ITER_i_1.next();
					/**
					 * i.name = atlExpression.name
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String name_0 = i_1.getName();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String name_1 = CAST_d3atlExpression.getName();
					final /*@NonInvalid*/ boolean IsEQ__1 = idResolver.oclEquals(name_0, name_1);
					//
					if (IsEQ__1) {
						accumulator_1.add(i_1);
					}
				}
				final /*@NonInvalid*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(select).booleanValue();
				/*@NonInvalid*/ boolean IF_IF_isEmpty;
				if (isEmpty) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String name = CAST_d3atlExpression.getName();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclExpression source = CAST_d3atlExpression.getSource();
					final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(source);
					final /*@NonInvalid*/ Boolean IsEQ__0 = DmapOclExpression != null;
					/*@NonInvalid*/ Boolean IF_IsEQ__0;
					if (IsEQ__0) {
						if (DmapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						// mapping statements
						trace.setT1propertyName(name);
						final /*@NonInvalid*/ @Nullable List<Attribute> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Attribute.class, select);
						trace.getT3atlAttributes().addAll(ECORE_select);
						dispatcher.setResult(trace);
						trace.setT3atlModule(getModule_0);
						trace.setT3atlSource(source);
						trace.setWmapOclExpression(DmapOclExpression);
						final /*@NonInvalid*/ boolean mmapNavigationOrAttributeCallExp__Property__qvtr__i = ValueUtil.TRUE_VALUE;
						IF_IsEQ__0 = mmapNavigationOrAttributeCallExp__Property__qvtr__i;
					}
					else {
						IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
					}
					IF_IF_isEmpty = IF_IsEQ__0;
				}
				else {
					IF_IF_isEmpty = ValueUtil.FALSE_VALUE;
				}
				IF_IsKINDOF_ = IF_IF_isEmpty;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0local(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__S0LOCAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__i");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:2 mmapOclMetamodel__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOclMetamodel[1] success s0global;
	 * var oclMetamodel : OCL::OclModel[1] := trace.t3oclMetamodel;
	 * check oclMetamodel.metamodel = null;
	 * var tmName : String[1] := oclMetamodel.name;
	 * new:qvtr qvtrTypedModel : qvtbase::TypedModel[1];
	 * set qvtrTypedModel.name := tmName;
	 * set trace.t1tmName := tmName;
	 * set trace.t4qvtrTypedModel := qvtrTypedModel;
	 *
	 */
	protected boolean MAP_mmapOclMetamodel__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapOclMetamodel trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclMetamodel__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclModel t3oclMetamodel = trace.getT3oclMetamodel();
		final /*@NonInvalid*/ @Nullable OclModel metamodel = t3oclMetamodel.getMetamodel();
		final /*@NonInvalid*/ boolean IsEQ_ = metamodel == null;
		/*@NonInvalid*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name = t3oclMetamodel.getName();
			// creations
			final @NonNull TypedModel qvtrTypedModel = QVTbaseFactory.eINSTANCE.createTypedModel();
			MODEL_qvtr.add(qvtrTypedModel, false);
			if (debugCreations) {
				AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrTypedModel));
			}
			// mapping statements
			qvtrTypedModel.setName(name);
			trace.setT1tmName(name);
			trace.setT4qvtrTypedModel(qvtrTypedModel);
			final /*@NonInvalid*/ boolean mmapOclMetamodel__qvtr__init__ = ValueUtil.TRUE_VALUE;
			IF_IsEQ_ = mmapOclMetamodel__qvtr__init__;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0global(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_OCL_METAMODEL__S0GLOBAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapOclMetamodel__qvtr__init__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:2 mmapOclType__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOclType[1] success s0global;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOclType;
	 * check var atlExpression : OCL::OclType[1] := dispatcher.d3atlExpression;
	 * set dispatcher.result := trace;
	 *
	 */
	protected boolean MAP_mmapOclType__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapOclType trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclType__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOclType domapOclType = dispatcher.getDomapOclType();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapOclType);
		/*@NonInvalid*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression d3atlExpression = dispatcher.getD3atlExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d3atlExpression instanceof OclType;
			/*@NonInvalid*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ @Nullable OclType CAST_d3atlExpression = (OclType)d3atlExpression;
				// mapping statements
				dispatcher.setResult(trace);
				final /*@NonInvalid*/ boolean mmapOclType__qvtr__init__ = ValueUtil.TRUE_VALUE;
				IF_IsKINDOF_ = mmapOclType__qvtr__init__;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0global(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapOclType__qvtr__init__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:2 mmapOperationCallExp__Operation__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Operation[1] success s0local;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapOperationCallExp_Operation;
	 * check var atlExpression : OCL::OperationCallExp[1] := dispatcher.d3atlExpression;
	 * var not_mapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1] := dispatcher.domapOperatorCallExp;
	 * var getModule1 : ATL::Module[1] := this.getModule(atlExpression)
	 *   ;
	 * var elements : OrderedSet(ATL::ModuleElement) := getModule1.elements;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var collect : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(i | i.definition)
	 *   ;
	 * var collect1 : Sequence(OCL::OclFeature) := collect->collect(i | i.feature)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Operation) := collect1->selectByKind(OCL::Operation)
	 *   ;
	 * var select : Sequence(OCL::Operation) := selectByKind1->select(i | i.name = atlExpression.operationName)
	 *   ;
	 * var isEmpty : Boolean[1] := select->isEmpty();
	 * check isEmpty;
	 * var operationName : String[1] := atlExpression.operationName;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlSource.DmapOclExpression;
	 * set trace.t1operationName := operationName;
	 * set trace.t3atlOperations := select;
	 * set dispatcher.result := trace;
	 * set trace.t3atlModule := getModule1;
	 * set trace.t3atlSource := atlSource;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected boolean MAP_mmapOperationCallExp__Operation__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperationCallExp__Operation__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Operation domapOperationCallExp_Operation = dispatcher.getDomapOperationCallExp_Operation();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapOperationCallExp_Operation);
		/*@NonInvalid*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression d3atlExpression = dispatcher.getD3atlExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d3atlExpression instanceof OperationCallExp;
			/*@NonInvalid*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ @Nullable OperationCallExp CAST_d3atlExpression = (OperationCallExp)d3atlExpression;
				final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher.getDomapOperatorCallExp();
				final /*@NonInvalid*/ Boolean IsEQ__0 = domapOperatorCallExp != null;
				/*@NonInvalid*/ Boolean IF_IsEQ__0;
				if (IsEQ__0) {
					if (domapOperatorCallExp == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@NonInvalid*/ @NonNull Module getModule_0 = INSTANCE_CACHE_ATL2QVTr_getModule.evaluate(rootThis, CAST_d3atlExpression);
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<ModuleElement> elements = getModule_0.getElements();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ATL_c_c_Helper = idResolver.getClass(CLSSid_Helper, null);
					final /*@NonInvalid*/ @Nullable OrderedSetValue BOXED_elements = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleElement, elements);
					final /*@NonInvalid*/ @NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(rootExecutor, BOXED_elements, TYP_ATL_c_c_Helper);
					/*@NonInvalid*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeatureDefinition);
					@NonNull Iterator<Object> ITER_i = selectByKind.iterator();
					/*@NonInvalid*/ @NonNull SequenceValue collect;
					while (true) {
						if (!ITER_i.hasNext()) {
							collect = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull Helper i = (@NonNull Helper)ITER_i.next();
						/**
						 * i.definition
						 */
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = i.getDefinition();
						//
						accumulator.add(definition);
					}
					/*@NonInvalid*/ SequenceValue.@NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeature);
					@NonNull Iterator<Object> ITER_i_0 = collect.iterator();
					/*@NonInvalid*/ @NonNull SequenceValue collect_0;
					while (true) {
						if (!ITER_i_0.hasNext()) {
							collect_0 = accumulator_0;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull OclFeatureDefinition i_0 = (@NonNull OclFeatureDefinition)ITER_i_0.next();
						/**
						 * i.feature
						 */
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OclFeature feature = i_0.getFeature();
						//
						accumulator_0.add(feature);
					}
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_Operation = idResolver.getClass(CLSSid_Operation, null);
					final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(rootExecutor, collect_0, TYP_OCL_c_c_Operation);
					/*@NonInvalid*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
					@NonNull Iterator<Object> ITER_i_1 = selectByKind_0.iterator();
					/*@NonInvalid*/ @NonNull SequenceValue select;
					while (true) {
						if (!ITER_i_1.hasNext()) {
							select = accumulator_1;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation i_1 = (org.eclipse.m2m.atl.common.OCL.@NonNull Operation)ITER_i_1.next();
						/**
						 * i.name = atlExpression.operationName
						 */
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String name = i_1.getName();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String operationName_0 = CAST_d3atlExpression.getOperationName();
						final /*@NonInvalid*/ boolean IsEQ__2 = idResolver.oclEquals(name, operationName_0);
						//
						if (IsEQ__2) {
							accumulator_1.add(i_1);
						}
					}
					final /*@NonInvalid*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(select).booleanValue();
					/*@NonInvalid*/ boolean IF_IF_isEmpty;
					if (isEmpty) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String operationName = CAST_d3atlExpression.getOperationName();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OclExpression source = CAST_d3atlExpression.getSource();
						final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(source);
						final /*@NonInvalid*/ Boolean IsEQ__1 = DmapOclExpression != null;
						/*@NonInvalid*/ Boolean IF_IsEQ__1;
						if (IsEQ__1) {
							if (DmapOclExpression == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							// mapping statements
							trace.setT1operationName(operationName);
							final /*@NonInvalid*/ @Nullable List<org.eclipse.m2m.atl.common.OCL.Operation> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.m2m.atl.common.OCL.Operation.class, select);
							trace.getT3atlOperations().addAll(ECORE_select);
							dispatcher.setResult(trace);
							trace.setT3atlModule(getModule_0);
							trace.setT3atlSource(source);
							trace.setWmapOclExpression(DmapOclExpression);
							final /*@NonInvalid*/ boolean mmapOperationCallExp__Operation__qvtr__init__ = ValueUtil.TRUE_VALUE;
							IF_IsEQ__1 = mmapOperationCallExp__Operation__qvtr__init__;
						}
						else {
							IF_IsEQ__1 = ValueUtil.FALSE_VALUE;
						}
						IF_IF_isEmpty = IF_IsEQ__1;
					}
					else {
						IF_IF_isEmpty = ValueUtil.FALSE_VALUE;
					}
					IF_IsEQ__0 = IF_IF_isEmpty;
				}
				else {
					IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
				}
				IF_IsKINDOF_ = IF_IsEQ__0;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0local(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_OPERATION__S0LOCAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapOperationCallExp__Operation__qvtr__init__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:2 mmapOperatorCallExp__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperatorCallExp[1] success s0local;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperatorCallExp;
	 * check var atlExpression : OCL::OperatorCallExp[1] := dispatcher.d3atlExpression;
	 * var operationName : String[1] := atlExpression.operationName;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlSource.DmapOclExpression;
	 * set trace.t1operationName := operationName;
	 * set dispatcher.result := trace;
	 * set trace.t3atlSource := atlSource;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected boolean MAP_mmapOperatorCallExp__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperatorCallExp__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher.getDomapOperatorCallExp();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapOperatorCallExp);
		/*@NonInvalid*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression d3atlExpression = dispatcher.getD3atlExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d3atlExpression instanceof OperatorCallExp;
			/*@NonInvalid*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ @Nullable OperatorCallExp CAST_d3atlExpression = (OperatorCallExp)d3atlExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String operationName = CAST_d3atlExpression.getOperationName();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression source = CAST_d3atlExpression.getSource();
				final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(source);
				final /*@NonInvalid*/ Boolean IsEQ__0 = DmapOclExpression != null;
				/*@NonInvalid*/ Boolean IF_IsEQ__0;
				if (IsEQ__0) {
					if (DmapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					// mapping statements
					trace.setT1operationName(operationName);
					dispatcher.setResult(trace);
					trace.setT3atlSource(source);
					trace.setWmapOclExpression(DmapOclExpression);
					final /*@NonInvalid*/ boolean mmapOperatorCallExp__qvtr__init__ = ValueUtil.TRUE_VALUE;
					IF_IsEQ__0 = mmapOperatorCallExp__qvtr__init__;
				}
				else {
					IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
				}
				IF_IsKINDOF_ = IF_IsEQ__0;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0local(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_OPERATOR_CALL_EXP__S0LOCAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapOperatorCallExp__qvtr__init__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:2 mmapStringExp__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapStringExp[1] success s0global;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapStringExp;
	 * check var atlExpression : OCL::StringExp[1] := dispatcher.d3atlExpression;
	 * var symbol : String[1] := atlExpression.stringSymbol;
	 * new:qvtr qvtrExpression : StringLiteralExp[1];
	 * set trace.t1symbol := symbol;
	 * set qvtrExpression.stringSymbol := symbol;
	 * set dispatcher.d4qvtrExpression := qvtrExpression;
	 * set dispatcher.result := trace;
	 *
	 */
	protected boolean MAP_mmapStringExp__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapStringExp trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapStringExp__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapStringExp domapStringExp = dispatcher.getDomapStringExp();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapStringExp);
		/*@NonInvalid*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression d3atlExpression = dispatcher.getD3atlExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d3atlExpression instanceof StringExp;
			/*@NonInvalid*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ @Nullable StringExp CAST_d3atlExpression = (StringExp)d3atlExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String stringSymbol = CAST_d3atlExpression.getStringSymbol();
				// creations
				final @NonNull StringLiteralExp qvtrExpression = PivotFactory.eINSTANCE.createStringLiteralExp();
				MODEL_qvtr.add(qvtrExpression, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
				}
				// mapping statements
				trace.setT1symbol(stringSymbol);
				qvtrExpression.setStringSymbol(stringSymbol);
				dispatcher.setD4qvtrExpression(qvtrExpression);
				dispatcher.setResult(trace);
				final /*@NonInvalid*/ boolean mmapStringExp__qvtr__init__ = ValueUtil.TRUE_VALUE;
				IF_IsKINDOF_ = mmapStringExp__qvtr__init__;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0global(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapStringExp__qvtr__init__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:2 mmapVariableExp__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp[1] success s0global;
	 * append jm_DmapVariableExp__referredVariable  : trace_ATL2QVTr::DmapVariableExp_referredVariable[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapVariableExp;
	 * check var atlExpression : OCL::VariableExp[1] := dispatcher.d3atlExpression;
	 * var atlVariable : OCL::VariableDeclaration[1] := atlExpression.referredVariable;
	 * var varName : String[1] := atlVariable.varName;
	 * new:qvtr qvtrExpression : VariableExp[1];
	 * new:middle where_mapVariableExp_referredVariable : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] {trace_ATL2QVTr::DmapVariableExp_referredVariable::d3atlExpression : OCL::VariableExp[1] = atlExpression, trace_ATL2QVTr::DmapVariableExp_referredVariable::d4qvtrExpression : VariableExp[1] = qvtrExpression}
	 * set trace.t1varName := varName;
	 * set qvtrExpression.name := varName;
	 * set dispatcher.d4qvtrExpression := qvtrExpression;
	 * set dispatcher.result := trace;
	 * set trace.t3atlVariable := atlVariable;
	 * set trace.wmapVariableExp_referredVariable := where_mapVariableExp_referredVariable;
	 * add jm_DmapVariableExp__referredVariable += where_mapVariableExp_referredVariable;
	 *
	 */
	protected boolean MAP_mmapVariableExp__qvtr__init__(final @NonNull Connection jm_DmapVariableExp__referredVariable, final /*@NonInvalid*/ @NonNull TmapVariableExp trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariableExp__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapVariableExp domapVariableExp = dispatcher.getDomapVariableExp();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapVariableExp);
		/*@NonInvalid*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression d3atlExpression = dispatcher.getD3atlExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d3atlExpression instanceof VariableExp;
			/*@NonInvalid*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ @Nullable VariableExp CAST_d3atlExpression = (VariableExp)d3atlExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableDeclaration referredVariable = CAST_d3atlExpression.getReferredVariable();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String varName = referredVariable.getVarName();
				// creations
				final org.eclipse.ocl.pivot.@NonNull VariableExp qvtrExpression = PivotFactory.eINSTANCE.createVariableExp();
				MODEL_qvtr.add(qvtrExpression, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
				}
				final @SuppressWarnings("null")@NonNull DmapVariableExp_referredVariable where_mapVariableExp_referredVariable = INSTANCE_RULE_CACHE_DmapVariableExp_referredVariable.evaluate(CAST_d3atlExpression, qvtrExpression);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(where_mapVariableExp_referredVariable));
				}
				// mapping statements
				trace.setT1varName(varName);
				qvtrExpression.setName(varName);
				dispatcher.setD4qvtrExpression(qvtrExpression);
				dispatcher.setResult(trace);
				trace.setT3atlVariable(referredVariable);
				trace.setWmapVariableExp_referredVariable(where_mapVariableExp_referredVariable);
				jm_DmapVariableExp__referredVariable.appendElement(where_mapVariableExp_referredVariable);
				final /*@NonInvalid*/ boolean mmapVariableExp__qvtr__init__ = ValueUtil.TRUE_VALUE;
				IF_IsKINDOF_ = mmapVariableExp__qvtr__init__;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0global(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapVariableExp__qvtr__init__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:3 mmapBooleanExp__qvtr__rest__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapBooleanExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapBooleanExp;
	 * check var qvtrExpression : BooleanLiteralExp[1] := dispatcher.d4qvtrExpression;
	 * check trace.s0global;
	 * var Boolean1 : BooleanType[1] := PrimitiveTypes::Boolean;
	 * notify set dispatcher.s0global := true;
	 * notify set qvtrExpression.type := Boolean1;
	 *
	 */
	protected boolean MAP_mmapBooleanExp__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapBooleanExp trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapBooleanExp__qvtr__rest__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapBooleanExp domapBooleanExp = dispatcher.getDomapBooleanExp();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapBooleanExp);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = dispatcher.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d4qvtrExpression instanceof BooleanLiteralExp;
			/*@Thrown*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ @Nullable BooleanLiteralExp CAST_d4qvtrExpression = (BooleanLiteralExp)d4qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0global;
				if (s0global) {
					final /*@NonInvalid*/ @NonNull BooleanType TYP_Boolean = (BooleanType)idResolver.getClass(TypeId.BOOLEAN, null);
					// mapping statements
					dispatcher.setS0global(ValueUtil.TRUE_VALUE);
					objectManager.assigned(dispatcher, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
					CAST_d4qvtrExpression.setType(TYP_Boolean);
					objectManager.assigned(CAST_d4qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, TYP_Boolean, false);
					final /*@NonInvalid*/ boolean mmapBooleanExp__qvtr__rest__ = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapBooleanExp__qvtr__rest__;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_IsKINDOF_ = IF_s0global;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapBooleanExp__qvtr__rest__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:3 mmapHelper__Attribute__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Attribute[1] success s0local;
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapHelper_Attribute;
	 * var atlHelper : ATL::Helper[1] := dispatcher.d3atlHelper;
	 * var atlModule : ATL::Module[1] := atlHelper.module;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * check when_mapModule.s0global;
	 * var atlDefinition : OCL::OclFeatureDefinition[1] := atlHelper.definition;
	 * check var atlFeature : OCL::Attribute[1] := atlDefinition.feature;
	 * var atlExpression : OCL::OclExpression[1] := atlFeature.initExpression;
	 * var attributeName : String[1] := atlFeature.name;
	 * var atlType : OCL::OclType[1] := atlFeature.type;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t4qvtrTransformation;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlExpression.DmapOclExpression;
	 * var getType1 : Class[1] := this.getType(atlType);
	 * set trace.t1attributeName := attributeName;
	 * set dispatcher.result := trace;
	 * set trace.t3atlDefinition := atlDefinition;
	 * set trace.t3atlExpression := atlExpression;
	 * set trace.t3atlFeature := atlFeature;
	 * set trace.t3atlModule := atlModule;
	 * set trace.t3atlType := atlType;
	 * set trace.t4qvtrTransformation := qvtrTransformation;
	 * set trace.wmapModule := when_mapModule;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected boolean MAP_mmapHelper__Attribute__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapHelper_Attribute trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapHelper__Attribute__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlHelper\":" + toDebugString(trace.getDispatcher().getD3atlHelper()) +
					"\n\t\"dispatcher.d4qvtrFunction\":" + toDebugString(trace.getDispatcher().getD4qvtrFunction()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapHelper dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapHelper_Attribute domapHelper_Attribute = dispatcher.getDomapHelper_Attribute();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapHelper_Attribute);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Helper d3atlHelper = dispatcher.getD3atlHelper();
			final /*@NonInvalid*/ @Nullable Module module = d3atlHelper.getModule();
			final /*@NonInvalid*/ Boolean IsEQ__0 = module != null;
			/*@Thrown*/ Boolean IF_IsEQ__0;
			if (IsEQ__0) {
				if (module == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				/*@Caught*/ @Nullable Object CAUGHT_TmapModule;
				try {
					final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t3atlModule.get(module);
					CAUGHT_TmapModule = TmapModule;
				}
				catch (Exception THROWN_CAUGHT_TmapModule) {
					CAUGHT_TmapModule = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapModule);
				}
				if (CAUGHT_TmapModule instanceof InvalidValueException) {
					throw (InvalidValueException)CAUGHT_TmapModule;
				}
				final /*@Thrown*/ @Nullable TmapModule THROWN_TmapModule = (@Nullable TmapModule)CAUGHT_TmapModule;
				final /*@Thrown*/ Boolean IsEQ__1 = THROWN_TmapModule != null;
				/*@Thrown*/ Boolean IF_IsEQ__1;
				if (IsEQ__1) {
					/*@Caught*/ @Nullable Object CAUGHT_TmapModule_0;
					try {
						if (THROWN_TmapModule == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						CAUGHT_TmapModule_0 = THROWN_TmapModule;
					}
					catch (Exception THROWN_CAUGHT_TmapModule_0) {
						CAUGHT_TmapModule_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapModule_0);
					}
					if (CAUGHT_TmapModule_0 instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_TmapModule_0;
					}
					final /*@Thrown*/ @Nullable TmapModule THROWN_TmapModule_0 = (@Nullable TmapModule)CAUGHT_TmapModule_0;
					final /*@Thrown*/ @Nullable Boolean s0global = THROWN_TmapModule_0.getS0global();
					if (s0global == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ boolean IF_s0global;
					if (s0global) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = d3atlHelper.getDefinition();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OclFeature feature = definition.getFeature();
						final /*@NonInvalid*/ boolean IsKINDOF_ = feature instanceof Attribute;
						/*@NonInvalid*/ boolean IF_IsKINDOF_;
						if (IsKINDOF_) {
							final /*@NonInvalid*/ @Nullable Attribute CAST_feature = (Attribute)feature;
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OclExpression initExpression = CAST_feature.getInitExpression();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String name = CAST_feature.getName();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OclType type = CAST_feature.getType();
							/*@Caught*/ @Nullable Object CAUGHT_t4qvtrTransformation;
							try {
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull RelationalTransformation t4qvtrTransformation = THROWN_TmapModule_0.getT4qvtrTransformation();
								CAUGHT_t4qvtrTransformation = t4qvtrTransformation;
							}
							catch (Exception THROWN_CAUGHT_t4qvtrTransformation) {
								CAUGHT_t4qvtrTransformation = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrTransformation);
							}
							final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(initExpression);
							final /*@NonInvalid*/ Boolean IsEQ__2 = DmapOclExpression != null;
							/*@NonInvalid*/ Boolean IF_IsEQ__2;
							if (IsEQ__2) {
								if (DmapOclExpression == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class getType_0 = INSTANCE_CACHE_ATL2QVTr_getType.evaluate(rootThis, type);
								// mapping statements
								trace.setT1attributeName(name);
								dispatcher.setResult(trace);
								trace.setT3atlDefinition(definition);
								trace.setT3atlExpression(initExpression);
								trace.setT3atlFeature(CAST_feature);
								trace.setT3atlModule(module);
								trace.setT3atlType(type);
								if (CAUGHT_t4qvtrTransformation instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_t4qvtrTransformation;
								}
								final /*@Thrown*/ @Nullable RelationalTransformation THROWN_t4qvtrTransformation = (@Nullable RelationalTransformation)CAUGHT_t4qvtrTransformation;
								trace.setT4qvtrTransformation(THROWN_t4qvtrTransformation);
								trace.setWmapModule(THROWN_TmapModule_0);
								trace.setWmapOclExpression(DmapOclExpression);
								final /*@NonInvalid*/ boolean mmapHelper__Attribute__qvtr__init__ = ValueUtil.TRUE_VALUE;
								IF_IsEQ__2 = mmapHelper__Attribute__qvtr__init__;
							}
							else {
								IF_IsEQ__2 = ValueUtil.FALSE_VALUE;
							}
							IF_IsKINDOF_ = IF_IsEQ__2;
						}
						else {
							IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
						}
						IF_s0global = IF_IsKINDOF_;
					}
					else {
						IF_s0global = ValueUtil.FALSE_VALUE;
					}
					IF_IsEQ__1 = IF_s0global;
				}
				else {
					IF_IsEQ__1 = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ__0 = IF_IsEQ__1;
			}
			else {
				IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsEQ__0;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0local(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_ATTRIBUTE__S0LOCAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapHelper__Attribute__qvtr__init__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:3 mmapHelper__Operation__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Operation[1] success s0local;
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapHelper_Operation;
	 * var atlHelper : ATL::Helper[1] := dispatcher.d3atlHelper;
	 * var atlModule : ATL::Module[1] := atlHelper.module;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * check when_mapModule.s0global;
	 * var atlDefinition : OCL::OclFeatureDefinition[1] := atlHelper.definition;
	 * check var atlFeature : OCL::Operation[1] := atlDefinition.feature;
	 * var atlExpression : OCL::OclExpression[1] := atlFeature.body;
	 * var operationName : String[1] := atlFeature.name;
	 * var atlType : OCL::OclType[1] := atlFeature.returnType;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t4qvtrTransformation;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlExpression.DmapOclExpression;
	 * var getType1 : Class[1] := this.getType(atlType);
	 * set trace.t1operationName := operationName;
	 * set dispatcher.result := trace;
	 * set trace.t3atlDefinition := atlDefinition;
	 * set trace.t3atlExpression := atlExpression;
	 * set trace.t3atlFeature := atlFeature;
	 * set trace.t3atlModule := atlModule;
	 * set trace.t3atlType := atlType;
	 * set trace.t4qvtrTransformation := qvtrTransformation;
	 * set trace.wmapModule := when_mapModule;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected boolean MAP_mmapHelper__Operation__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapHelper_Operation trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapHelper__Operation__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlHelper\":" + toDebugString(trace.getDispatcher().getD3atlHelper()) +
					"\n\t\"dispatcher.d4qvtrFunction\":" + toDebugString(trace.getDispatcher().getD4qvtrFunction()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapHelper dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapHelper_Operation domapHelper_Operation = dispatcher.getDomapHelper_Operation();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapHelper_Operation);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Helper d3atlHelper = dispatcher.getD3atlHelper();
			final /*@NonInvalid*/ @Nullable Module module = d3atlHelper.getModule();
			final /*@NonInvalid*/ Boolean IsEQ__0 = module != null;
			/*@Thrown*/ Boolean IF_IsEQ__0;
			if (IsEQ__0) {
				if (module == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				/*@Caught*/ @Nullable Object CAUGHT_TmapModule;
				try {
					final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t3atlModule.get(module);
					CAUGHT_TmapModule = TmapModule;
				}
				catch (Exception THROWN_CAUGHT_TmapModule) {
					CAUGHT_TmapModule = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapModule);
				}
				if (CAUGHT_TmapModule instanceof InvalidValueException) {
					throw (InvalidValueException)CAUGHT_TmapModule;
				}
				final /*@Thrown*/ @Nullable TmapModule THROWN_TmapModule = (@Nullable TmapModule)CAUGHT_TmapModule;
				final /*@Thrown*/ Boolean IsEQ__1 = THROWN_TmapModule != null;
				/*@Thrown*/ Boolean IF_IsEQ__1;
				if (IsEQ__1) {
					/*@Caught*/ @Nullable Object CAUGHT_TmapModule_0;
					try {
						if (THROWN_TmapModule == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						CAUGHT_TmapModule_0 = THROWN_TmapModule;
					}
					catch (Exception THROWN_CAUGHT_TmapModule_0) {
						CAUGHT_TmapModule_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapModule_0);
					}
					if (CAUGHT_TmapModule_0 instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_TmapModule_0;
					}
					final /*@Thrown*/ @Nullable TmapModule THROWN_TmapModule_0 = (@Nullable TmapModule)CAUGHT_TmapModule_0;
					final /*@Thrown*/ @Nullable Boolean s0global = THROWN_TmapModule_0.getS0global();
					if (s0global == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ boolean IF_s0global;
					if (s0global) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = d3atlHelper.getDefinition();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OclFeature feature = definition.getFeature();
						final /*@NonInvalid*/ boolean IsKINDOF_ = feature instanceof org.eclipse.m2m.atl.common.OCL.Operation;
						/*@NonInvalid*/ boolean IF_IsKINDOF_;
						if (IsKINDOF_) {
							final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@Nullable Operation CAST_feature = (org.eclipse.m2m.atl.common.OCL.Operation)feature;
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OclExpression body = CAST_feature.getBody();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String name = CAST_feature.getName();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OclType returnType = CAST_feature.getReturnType();
							/*@Caught*/ @Nullable Object CAUGHT_t4qvtrTransformation;
							try {
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull RelationalTransformation t4qvtrTransformation = THROWN_TmapModule_0.getT4qvtrTransformation();
								CAUGHT_t4qvtrTransformation = t4qvtrTransformation;
							}
							catch (Exception THROWN_CAUGHT_t4qvtrTransformation) {
								CAUGHT_t4qvtrTransformation = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrTransformation);
							}
							final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(body);
							final /*@NonInvalid*/ Boolean IsEQ__2 = DmapOclExpression != null;
							/*@NonInvalid*/ Boolean IF_IsEQ__2;
							if (IsEQ__2) {
								if (DmapOclExpression == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class getType_0 = INSTANCE_CACHE_ATL2QVTr_getType.evaluate(rootThis, returnType);
								// mapping statements
								trace.setT1operationName(name);
								dispatcher.setResult(trace);
								trace.setT3atlDefinition(definition);
								trace.setT3atlExpression(body);
								trace.setT3atlFeature(CAST_feature);
								trace.setT3atlModule(module);
								trace.setT3atlType(returnType);
								if (CAUGHT_t4qvtrTransformation instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_t4qvtrTransformation;
								}
								final /*@Thrown*/ @Nullable RelationalTransformation THROWN_t4qvtrTransformation = (@Nullable RelationalTransformation)CAUGHT_t4qvtrTransformation;
								trace.setT4qvtrTransformation(THROWN_t4qvtrTransformation);
								trace.setWmapModule(THROWN_TmapModule_0);
								trace.setWmapOclExpression(DmapOclExpression);
								final /*@NonInvalid*/ boolean mmapHelper__Operation__qvtr__init__ = ValueUtil.TRUE_VALUE;
								IF_IsEQ__2 = mmapHelper__Operation__qvtr__init__;
							}
							else {
								IF_IsEQ__2 = ValueUtil.FALSE_VALUE;
							}
							IF_IsKINDOF_ = IF_IsEQ__2;
						}
						else {
							IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
						}
						IF_s0global = IF_IsKINDOF_;
					}
					else {
						IF_s0global = ValueUtil.FALSE_VALUE;
					}
					IF_IsEQ__1 = IF_s0global;
				}
				else {
					IF_IsEQ__1 = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ__0 = IF_IsEQ__1;
			}
			else {
				IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsEQ__0;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0local(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_OPERATION__S0LOCAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapHelper__Operation__qvtr__init__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:3 mmapIntegerExp__qvtr__rest__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapIntegerExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapIntegerExp;
	 * check var qvtrExpression : IntegerLiteralExp[1] := dispatcher.d4qvtrExpression;
	 * check trace.s0global;
	 * var Integer1 : PrimitiveType[1] := Integer;
	 * notify set dispatcher.s0global := true;
	 * notify set qvtrExpression.type := Integer1;
	 *
	 */
	protected boolean MAP_mmapIntegerExp__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapIntegerExp trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapIntegerExp__qvtr__rest__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapIntegerExp domapIntegerExp = dispatcher.getDomapIntegerExp();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapIntegerExp);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = dispatcher.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d4qvtrExpression instanceof IntegerLiteralExp;
			/*@Thrown*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ @Nullable IntegerLiteralExp CAST_d4qvtrExpression = (IntegerLiteralExp)d4qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0global;
				if (s0global) {
					final /*@NonInvalid*/ @NonNull PrimitiveType TYP_Integer = (PrimitiveType)idResolver.getClass(TypeId.INTEGER, null);
					// mapping statements
					dispatcher.setS0global(ValueUtil.TRUE_VALUE);
					objectManager.assigned(dispatcher, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
					CAST_d4qvtrExpression.setType(TYP_Integer);
					objectManager.assigned(CAST_d4qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, TYP_Integer, false);
					final /*@NonInvalid*/ boolean mmapIntegerExp__qvtr__rest__ = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapIntegerExp__qvtr__rest__;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_IsKINDOF_ = IF_s0global;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapIntegerExp__qvtr__rest__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:3 mmapMatchedRule__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapMatchedRule[1] success s0global;
	 * var matchedRule : ATL::MatchedRule[1] := trace.t3matchedRule;
	 * var atlModule : ATL::Module[1] := matchedRule.module;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * check when_mapModule.s0global;
	 * var isAbstract : Boolean[1] := matchedRule.isAbstract;
	 * var ruleName : String[1] := matchedRule.name;
	 * var atlOutPattern : ATL::OutPattern[1] := matchedRule.outPattern;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t4qvtrTransformation;
	 * new:qvtr _6 : qvtrelation::SharedVariable[1];
	 * new:qvtr qvtrRelation : qvtrelation::Relation[1];
	 * set qvtrRelation.isAbstract := isAbstract;
	 * set qvtrRelation.name := ruleName;
	 * set trace.t1ruleName := ruleName;
	 * set qvtrRelation.variable := _6;
	 * set qvtrRelation.transformation := qvtrTransformation;
	 * set trace.t3atlModule := atlModule;
	 * set trace.t3atlOutPattern := atlOutPattern;
	 * set trace.t4_6 := _6;
	 * set trace.t4qvtrRelation := qvtrRelation;
	 * set trace.t4qvtrTransformation := qvtrTransformation;
	 * set trace.wmapModule := when_mapModule;
	 *
	 */
	protected boolean MAP_mmapMatchedRule__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapMatchedRule trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapMatchedRule__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull MatchedRule t3matchedRule = trace.getT3matchedRule();
		final /*@NonInvalid*/ @Nullable Module module = t3matchedRule.getModule();
		final /*@NonInvalid*/ Boolean IsEQ_ = module != null;
		/*@Thrown*/ Boolean IF_IsEQ_;
		if (IsEQ_) {
			if (module == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			/*@Caught*/ @Nullable Object CAUGHT_TmapModule;
			try {
				final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t3atlModule.get(module);
				CAUGHT_TmapModule = TmapModule;
			}
			catch (Exception THROWN_CAUGHT_TmapModule) {
				CAUGHT_TmapModule = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapModule);
			}
			if (CAUGHT_TmapModule instanceof InvalidValueException) {
				throw (InvalidValueException)CAUGHT_TmapModule;
			}
			final /*@Thrown*/ @Nullable TmapModule THROWN_TmapModule = (@Nullable TmapModule)CAUGHT_TmapModule;
			final /*@Thrown*/ Boolean IsEQ__0 = THROWN_TmapModule != null;
			/*@Thrown*/ Boolean IF_IsEQ__0;
			if (IsEQ__0) {
				/*@Caught*/ @Nullable Object CAUGHT_TmapModule_0;
				try {
					if (THROWN_TmapModule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					CAUGHT_TmapModule_0 = THROWN_TmapModule;
				}
				catch (Exception THROWN_CAUGHT_TmapModule_0) {
					CAUGHT_TmapModule_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapModule_0);
				}
				if (CAUGHT_TmapModule_0 instanceof InvalidValueException) {
					throw (InvalidValueException)CAUGHT_TmapModule_0;
				}
				final /*@Thrown*/ @Nullable TmapModule THROWN_TmapModule_0 = (@Nullable TmapModule)CAUGHT_TmapModule_0;
				final /*@Thrown*/ @Nullable Boolean s0global = THROWN_TmapModule_0.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0global;
				if (s0global) {
					final /*@NonInvalid*/ boolean isAbstract = t3matchedRule.isIsAbstract();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String name = t3matchedRule.getName();
					final /*@NonInvalid*/ @Nullable OutPattern outPattern = t3matchedRule.getOutPattern();
					final /*@NonInvalid*/ Boolean IsEQ__1 = outPattern != null;
					/*@NonInvalid*/ Boolean IF_IsEQ__1;
					if (IsEQ__1) {
						if (outPattern == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						/*@Caught*/ @Nullable Object CAUGHT_t4qvtrTransformation;
						try {
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull RelationalTransformation t4qvtrTransformation = THROWN_TmapModule_0.getT4qvtrTransformation();
							CAUGHT_t4qvtrTransformation = t4qvtrTransformation;
						}
						catch (Exception THROWN_CAUGHT_t4qvtrTransformation) {
							CAUGHT_t4qvtrTransformation = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrTransformation);
						}
						// creations
						final @NonNull SharedVariable _6 = QVTrelationFactory.eINSTANCE.createSharedVariable();
						MODEL_qvtr.add(_6, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(_6));
						}
						final @NonNull Relation qvtrRelation = QVTrelationFactory.eINSTANCE.createRelation();
						MODEL_qvtr.add(qvtrRelation, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrRelation));
						}
						// mapping statements
						qvtrRelation.setIsAbstract(isAbstract);
						qvtrRelation.setName(name);
						trace.setT1ruleName(name);
						qvtrRelation.getVariable().add(_6);
						if (CAUGHT_t4qvtrTransformation instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_t4qvtrTransformation;
						}
						final /*@Thrown*/ @Nullable RelationalTransformation THROWN_t4qvtrTransformation = (@Nullable RelationalTransformation)CAUGHT_t4qvtrTransformation;
						qvtrRelation.setTransformation(THROWN_t4qvtrTransformation);
						trace.setT3atlModule(module);
						trace.setT3atlOutPattern(outPattern);
						trace.setT4_6(_6);
						trace.setT4qvtrRelation(qvtrRelation);
						if (CAUGHT_t4qvtrTransformation instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_t4qvtrTransformation;
						}
						final /*@Thrown*/ @Nullable RelationalTransformation THROWN_t4qvtrTransformation_0 = (@Nullable RelationalTransformation)CAUGHT_t4qvtrTransformation;
						trace.setT4qvtrTransformation(THROWN_t4qvtrTransformation_0);
						trace.setWmapModule(THROWN_TmapModule_0);
						final /*@NonInvalid*/ boolean mmapMatchedRule__qvtr__init__ = ValueUtil.TRUE_VALUE;
						IF_IsEQ__1 = mmapMatchedRule__qvtr__init__;
					}
					else {
						IF_IsEQ__1 = ValueUtil.FALSE_VALUE;
					}
					IF_s0global = IF_IsEQ__1;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ__0 = IF_s0global;
			}
			else {
				IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsEQ__0;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0global(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_MATCHED_RULE__S0GLOBAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapMatchedRule__qvtr__init__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:3 mmapOclModel__IN__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOclModel_IN[1] success s0global;
	 * var oclModel : OCL::OclModel[1] := trace.t3oclModel;
	 * var oclMetamodel : OCL::OclModel[1] := oclModel.metamodel;
	 * check oclMetamodel.metamodel =
	 *   null;
	 * var atlModule : ATL::Module[1] := oclModel.Module;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * check when_mapModule.s0global;
	 * var when_mapOclMetamodel : trace_ATL2QVTr::TmapOclMetamodel[1] := oclMetamodel.TmapOclMetamodel;
	 * check when_mapOclMetamodel.s0global;
	 * var name : String[1] := oclMetamodel.name;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t4qvtrTransformation;
	 * var qvtrTypedModel : qvtbase::TypedModel[1] := when_mapOclMetamodel.t4qvtrTypedModel;
	 * var getPackage1 : Package[1] := this.getPackage(atlModule, name)
	 *   ;
	 * var oclAsSet : Set(Package) := getPackage1.oclAsSet();
	 * set qvtrTypedModel.usedPackage := oclAsSet;
	 * set trace.t4qvtrPackages := oclAsSet;
	 * set qvtrTypedModel.transformation := qvtrTransformation;
	 * set trace.t3atlModule := atlModule;
	 * set trace.t3oclMetamodel := oclMetamodel;
	 * set trace.t4qvtrTransformation := qvtrTransformation;
	 * set trace.t4qvtrTypedModel := qvtrTypedModel;
	 * set trace.wmapModule := when_mapModule;
	 * set trace.wmapOclMetamodel := when_mapOclMetamodel;
	 *
	 */
	protected boolean MAP_mmapOclModel__IN__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapOclModel_IN trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclModel__IN__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclModel t3oclModel = trace.getT3oclModel();
		final /*@NonInvalid*/ @Nullable OclModel metamodel = t3oclModel.getMetamodel();
		final /*@NonInvalid*/ Boolean IsEQ_ = metamodel != null;
		/*@Thrown*/ Boolean IF_IsEQ_;
		if (IsEQ_) {
			if (metamodel == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable OclModel metamodel_0 = metamodel.getMetamodel();
			final /*@Thrown*/ boolean IsEQ__0 = metamodel_0 == null;
			/*@Thrown*/ boolean IF_IsEQ__0;
			if (IsEQ__0) {
				// ExecutorCompositionPropertyCallingConvention
				final /*@NonInvalid*/ @Nullable UnboxedCompositionProperty IMPPROPid_inModels = new UnboxedCompositionProperty(PROPid_inModels);
				final /*@NonInvalid*/ @Nullable Module Module = (@Nullable Module)IMPPROPid_inModels.evaluate(rootExecutor, CLSSid_Module, t3oclModel);
				final /*@NonInvalid*/ Boolean IsEQ__1 = Module != null;
				/*@Thrown*/ Boolean IF_IsEQ__1;
				if (IsEQ__1) {
					if (Module == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					/*@Caught*/ @Nullable Object CAUGHT_TmapModule;
					try {
						final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t3atlModule.get(Module);
						CAUGHT_TmapModule = TmapModule;
					}
					catch (Exception THROWN_CAUGHT_TmapModule) {
						CAUGHT_TmapModule = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapModule);
					}
					if (CAUGHT_TmapModule instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_TmapModule;
					}
					final /*@Thrown*/ @Nullable TmapModule THROWN_TmapModule = (@Nullable TmapModule)CAUGHT_TmapModule;
					final /*@Thrown*/ Boolean IsEQ__2 = THROWN_TmapModule != null;
					/*@Thrown*/ Boolean IF_IsEQ__2;
					if (IsEQ__2) {
						/*@Caught*/ @Nullable Object CAUGHT_TmapModule_0;
						try {
							if (THROWN_TmapModule == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							CAUGHT_TmapModule_0 = THROWN_TmapModule;
						}
						catch (Exception THROWN_CAUGHT_TmapModule_0) {
							CAUGHT_TmapModule_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapModule_0);
						}
						if (CAUGHT_TmapModule_0 instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_TmapModule_0;
						}
						final /*@Thrown*/ @Nullable TmapModule THROWN_TmapModule_0 = (@Nullable TmapModule)CAUGHT_TmapModule_0;
						final /*@Thrown*/ @Nullable Boolean s0global = THROWN_TmapModule_0.getS0global();
						if (s0global == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ boolean IF_s0global;
						if (s0global) {
							/*@Caught*/ @Nullable Object CAUGHT_TmapOclMetamodel;
							try {
								final /*@Thrown*/ @Nullable TmapOclMetamodel TmapOclMetamodel = OPPOSITE_OF_TmapOclMetamodel_t3oclMetamodel.get(metamodel);
								CAUGHT_TmapOclMetamodel = TmapOclMetamodel;
							}
							catch (Exception THROWN_CAUGHT_TmapOclMetamodel) {
								CAUGHT_TmapOclMetamodel = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapOclMetamodel);
							}
							if (CAUGHT_TmapOclMetamodel instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_TmapOclMetamodel;
							}
							final /*@Thrown*/ @Nullable TmapOclMetamodel THROWN_TmapOclMetamodel = (@Nullable TmapOclMetamodel)CAUGHT_TmapOclMetamodel;
							final /*@Thrown*/ Boolean IsEQ__3 = THROWN_TmapOclMetamodel != null;
							/*@Thrown*/ Boolean IF_IsEQ__3;
							if (IsEQ__3) {
								/*@Caught*/ @Nullable Object CAUGHT_TmapOclMetamodel_0;
								try {
									if (THROWN_TmapOclMetamodel == null) {
										throw new InvalidEvaluationException("Null where non-null value required");
									}
									CAUGHT_TmapOclMetamodel_0 = THROWN_TmapOclMetamodel;
								}
								catch (Exception THROWN_CAUGHT_TmapOclMetamodel_0) {
									CAUGHT_TmapOclMetamodel_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapOclMetamodel_0);
								}
								if (CAUGHT_TmapOclMetamodel_0 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_TmapOclMetamodel_0;
								}
								final /*@Thrown*/ @Nullable TmapOclMetamodel THROWN_TmapOclMetamodel_0 = (@Nullable TmapOclMetamodel)CAUGHT_TmapOclMetamodel_0;
								final /*@Thrown*/ @Nullable Boolean s0global_0 = THROWN_TmapOclMetamodel_0.getS0global();
								if (s0global_0 == null) {
									throw new InvalidEvaluationException("Null if condition");
								}
								/*@Thrown*/ boolean IF_s0global_0;
								if (s0global_0) {
									/*@Caught*/ @Nullable Object CAUGHT_name;
									try {
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull String name = metamodel.getName();
										CAUGHT_name = name;
									}
									catch (Exception THROWN_CAUGHT_name) {
										CAUGHT_name = ValueUtil.createInvalidValue(THROWN_CAUGHT_name);
									}
									/*@Caught*/ @Nullable Object CAUGHT_t4qvtrTransformation;
									try {
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull RelationalTransformation t4qvtrTransformation = THROWN_TmapModule_0.getT4qvtrTransformation();
										CAUGHT_t4qvtrTransformation = t4qvtrTransformation;
									}
									catch (Exception THROWN_CAUGHT_t4qvtrTransformation) {
										CAUGHT_t4qvtrTransformation = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrTransformation);
									}
									/*@Caught*/ @Nullable Object CAUGHT_t4qvtrTypedModel;
									try {
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull TypedModel t4qvtrTypedModel = THROWN_TmapOclMetamodel_0.getT4qvtrTypedModel();
										CAUGHT_t4qvtrTypedModel = t4qvtrTypedModel;
									}
									catch (Exception THROWN_CAUGHT_t4qvtrTypedModel) {
										CAUGHT_t4qvtrTypedModel = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrTypedModel);
									}
									/*@Caught*/ @Nullable Object CAUGHT_getPackage;
									try {
										if (CAUGHT_name instanceof InvalidValueException) {
											throw (InvalidValueException)CAUGHT_name;
										}
										final /*@Thrown*/ @Nullable String THROWN_name = (@Nullable String)CAUGHT_name;
										final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Package getPackage_0 = INSTANCE_CACHE_ATL2QVTr_getPackage.evaluate(rootThis, Module, THROWN_name);
										CAUGHT_getPackage = getPackage_0;
									}
									catch (Exception THROWN_CAUGHT_getPackage) {
										CAUGHT_getPackage = ValueUtil.createInvalidValue(THROWN_CAUGHT_getPackage);
									}
									/*@Caught*/ @Nullable Object CAUGHT_oclAsSet;
									try {
										if (CAUGHT_getPackage instanceof InvalidValueException) {
											throw (InvalidValueException)CAUGHT_getPackage;
										}
										final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Package THROWN_getPackage = (org.eclipse.ocl.pivot.@Nullable Package)CAUGHT_getPackage;
										final /*@Thrown*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(rootExecutor, SET_CLSSid_Package, THROWN_getPackage);
										CAUGHT_oclAsSet = oclAsSet;
									}
									catch (Exception THROWN_CAUGHT_oclAsSet) {
										CAUGHT_oclAsSet = ValueUtil.createInvalidValue(THROWN_CAUGHT_oclAsSet);
									}
									// mapping statements
									if (CAUGHT_t4qvtrTypedModel instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrTypedModel;
									}
									final /*@Thrown*/ @Nullable TypedModel THROWN_t4qvtrTypedModel = (@Nullable TypedModel)CAUGHT_t4qvtrTypedModel;
									if (CAUGHT_oclAsSet instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_oclAsSet;
									}
									final /*@Thrown*/ @Nullable SetValue THROWN_oclAsSet = (@Nullable SetValue)CAUGHT_oclAsSet;
									final /*@Thrown*/ @Nullable List<org.eclipse.ocl.pivot.Package> ECORE_oclAsSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.ocl.pivot.Package.class, THROWN_oclAsSet);
									THROWN_t4qvtrTypedModel.getUsedPackage().addAll(ECORE_oclAsSet);
									if (CAUGHT_oclAsSet instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_oclAsSet;
									}
									final /*@Thrown*/ @Nullable SetValue THROWN_oclAsSet_0 = (@Nullable SetValue)CAUGHT_oclAsSet;
									final /*@Thrown*/ @Nullable List<org.eclipse.ocl.pivot.Package> ECORE_oclAsSet_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.ocl.pivot.Package.class, THROWN_oclAsSet_0);
									trace.getT4qvtrPackages().addAll(ECORE_oclAsSet_0);
									if (CAUGHT_t4qvtrTypedModel instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrTypedModel;
									}
									final /*@Thrown*/ @Nullable TypedModel THROWN_t4qvtrTypedModel_0 = (@Nullable TypedModel)CAUGHT_t4qvtrTypedModel;
									if (CAUGHT_t4qvtrTransformation instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrTransformation;
									}
									final /*@Thrown*/ @Nullable RelationalTransformation THROWN_t4qvtrTransformation = (@Nullable RelationalTransformation)CAUGHT_t4qvtrTransformation;
									THROWN_t4qvtrTypedModel_0.setTransformation(THROWN_t4qvtrTransformation);
									trace.setT3atlModule(Module);
									trace.setT3oclMetamodel(metamodel);
									if (CAUGHT_t4qvtrTransformation instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrTransformation;
									}
									final /*@Thrown*/ @Nullable RelationalTransformation THROWN_t4qvtrTransformation_0 = (@Nullable RelationalTransformation)CAUGHT_t4qvtrTransformation;
									trace.setT4qvtrTransformation(THROWN_t4qvtrTransformation_0);
									if (CAUGHT_t4qvtrTypedModel instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrTypedModel;
									}
									final /*@Thrown*/ @Nullable TypedModel THROWN_t4qvtrTypedModel_1 = (@Nullable TypedModel)CAUGHT_t4qvtrTypedModel;
									trace.setT4qvtrTypedModel(THROWN_t4qvtrTypedModel_1);
									trace.setWmapModule(THROWN_TmapModule_0);
									trace.setWmapOclMetamodel(THROWN_TmapOclMetamodel_0);
									final /*@NonInvalid*/ boolean mmapOclModel__IN__qvtr__init__ = ValueUtil.TRUE_VALUE;
									IF_s0global_0 = mmapOclModel__IN__qvtr__init__;
								}
								else {
									IF_s0global_0 = ValueUtil.FALSE_VALUE;
								}
								IF_IsEQ__3 = IF_s0global_0;
							}
							else {
								IF_IsEQ__3 = ValueUtil.FALSE_VALUE;
							}
							IF_s0global = IF_IsEQ__3;
						}
						else {
							IF_s0global = ValueUtil.FALSE_VALUE;
						}
						IF_IsEQ__2 = IF_s0global;
					}
					else {
						IF_IsEQ__2 = ValueUtil.FALSE_VALUE;
					}
					IF_IsEQ__1 = IF_IsEQ__2;
				}
				else {
					IF_IsEQ__1 = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ__0 = IF_IsEQ__1;
			}
			else {
				IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsEQ__0;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0global(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_OCL_MODEL_IN__S0GLOBAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapOclModel__IN__qvtr__init__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:3 mmapOclModel__OUT__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOclModel_OUT[1] success s0global;
	 * var oclModel : OCL::OclModel[1] := trace.t3oclModel;
	 * var oclMetamodel : OCL::OclModel[1] := oclModel.metamodel;
	 * check oclMetamodel.metamodel =
	 *   null;
	 * var atlModule : ATL::Module[1] := oclModel.Module;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * check when_mapModule.s0global;
	 * var when_mapOclMetamodel : trace_ATL2QVTr::TmapOclMetamodel[1] := oclMetamodel.TmapOclMetamodel;
	 * check when_mapOclMetamodel.s0global;
	 * var name : String[1] := oclMetamodel.name;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t4qvtrTransformation;
	 * var qvtrTypedModel : qvtbase::TypedModel[1] := when_mapOclMetamodel.t4qvtrTypedModel;
	 * var getPackage1 : Package[1] := this.getPackage(atlModule, name)
	 *   ;
	 * var oclAsSet : Set(Package) := getPackage1.oclAsSet();
	 * set qvtrTypedModel.usedPackage := oclAsSet;
	 * set trace.t4qvtrPackages := oclAsSet;
	 * set qvtrTypedModel.transformation := qvtrTransformation;
	 * set trace.t3atlModule := atlModule;
	 * set trace.t3oclMetamodel := oclMetamodel;
	 * set trace.t4qvtrTransformation := qvtrTransformation;
	 * set trace.t4qvtrTypedModel := qvtrTypedModel;
	 * set trace.wmapModule := when_mapModule;
	 * set trace.wmapOclMetamodel := when_mapOclMetamodel;
	 *
	 */
	protected boolean MAP_mmapOclModel__OUT__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapOclModel_OUT trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclModel__OUT__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclModel t3oclModel = trace.getT3oclModel();
		final /*@NonInvalid*/ @Nullable OclModel metamodel = t3oclModel.getMetamodel();
		final /*@NonInvalid*/ Boolean IsEQ_ = metamodel != null;
		/*@Thrown*/ Boolean IF_IsEQ_;
		if (IsEQ_) {
			if (metamodel == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable OclModel metamodel_0 = metamodel.getMetamodel();
			final /*@Thrown*/ boolean IsEQ__0 = metamodel_0 == null;
			/*@Thrown*/ boolean IF_IsEQ__0;
			if (IsEQ__0) {
				// ExecutorCompositionPropertyCallingConvention
				final /*@NonInvalid*/ @Nullable UnboxedCompositionProperty IMPPROPid_outModels = new UnboxedCompositionProperty(PROPid_outModels);
				final /*@NonInvalid*/ @Nullable Module Module = (@Nullable Module)IMPPROPid_outModels.evaluate(rootExecutor, CLSSid_Module, t3oclModel);
				final /*@NonInvalid*/ Boolean IsEQ__1 = Module != null;
				/*@Thrown*/ Boolean IF_IsEQ__1;
				if (IsEQ__1) {
					if (Module == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					/*@Caught*/ @Nullable Object CAUGHT_TmapModule;
					try {
						final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t3atlModule.get(Module);
						CAUGHT_TmapModule = TmapModule;
					}
					catch (Exception THROWN_CAUGHT_TmapModule) {
						CAUGHT_TmapModule = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapModule);
					}
					if (CAUGHT_TmapModule instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_TmapModule;
					}
					final /*@Thrown*/ @Nullable TmapModule THROWN_TmapModule = (@Nullable TmapModule)CAUGHT_TmapModule;
					final /*@Thrown*/ Boolean IsEQ__2 = THROWN_TmapModule != null;
					/*@Thrown*/ Boolean IF_IsEQ__2;
					if (IsEQ__2) {
						/*@Caught*/ @Nullable Object CAUGHT_TmapModule_0;
						try {
							if (THROWN_TmapModule == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							CAUGHT_TmapModule_0 = THROWN_TmapModule;
						}
						catch (Exception THROWN_CAUGHT_TmapModule_0) {
							CAUGHT_TmapModule_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapModule_0);
						}
						if (CAUGHT_TmapModule_0 instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_TmapModule_0;
						}
						final /*@Thrown*/ @Nullable TmapModule THROWN_TmapModule_0 = (@Nullable TmapModule)CAUGHT_TmapModule_0;
						final /*@Thrown*/ @Nullable Boolean s0global = THROWN_TmapModule_0.getS0global();
						if (s0global == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ boolean IF_s0global;
						if (s0global) {
							/*@Caught*/ @Nullable Object CAUGHT_TmapOclMetamodel;
							try {
								final /*@Thrown*/ @Nullable TmapOclMetamodel TmapOclMetamodel = OPPOSITE_OF_TmapOclMetamodel_t3oclMetamodel.get(metamodel);
								CAUGHT_TmapOclMetamodel = TmapOclMetamodel;
							}
							catch (Exception THROWN_CAUGHT_TmapOclMetamodel) {
								CAUGHT_TmapOclMetamodel = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapOclMetamodel);
							}
							if (CAUGHT_TmapOclMetamodel instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_TmapOclMetamodel;
							}
							final /*@Thrown*/ @Nullable TmapOclMetamodel THROWN_TmapOclMetamodel = (@Nullable TmapOclMetamodel)CAUGHT_TmapOclMetamodel;
							final /*@Thrown*/ Boolean IsEQ__3 = THROWN_TmapOclMetamodel != null;
							/*@Thrown*/ Boolean IF_IsEQ__3;
							if (IsEQ__3) {
								/*@Caught*/ @Nullable Object CAUGHT_TmapOclMetamodel_0;
								try {
									if (THROWN_TmapOclMetamodel == null) {
										throw new InvalidEvaluationException("Null where non-null value required");
									}
									CAUGHT_TmapOclMetamodel_0 = THROWN_TmapOclMetamodel;
								}
								catch (Exception THROWN_CAUGHT_TmapOclMetamodel_0) {
									CAUGHT_TmapOclMetamodel_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapOclMetamodel_0);
								}
								if (CAUGHT_TmapOclMetamodel_0 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_TmapOclMetamodel_0;
								}
								final /*@Thrown*/ @Nullable TmapOclMetamodel THROWN_TmapOclMetamodel_0 = (@Nullable TmapOclMetamodel)CAUGHT_TmapOclMetamodel_0;
								final /*@Thrown*/ @Nullable Boolean s0global_0 = THROWN_TmapOclMetamodel_0.getS0global();
								if (s0global_0 == null) {
									throw new InvalidEvaluationException("Null if condition");
								}
								/*@Thrown*/ boolean IF_s0global_0;
								if (s0global_0) {
									/*@Caught*/ @Nullable Object CAUGHT_name;
									try {
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull String name = metamodel.getName();
										CAUGHT_name = name;
									}
									catch (Exception THROWN_CAUGHT_name) {
										CAUGHT_name = ValueUtil.createInvalidValue(THROWN_CAUGHT_name);
									}
									/*@Caught*/ @Nullable Object CAUGHT_t4qvtrTransformation;
									try {
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull RelationalTransformation t4qvtrTransformation = THROWN_TmapModule_0.getT4qvtrTransformation();
										CAUGHT_t4qvtrTransformation = t4qvtrTransformation;
									}
									catch (Exception THROWN_CAUGHT_t4qvtrTransformation) {
										CAUGHT_t4qvtrTransformation = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrTransformation);
									}
									/*@Caught*/ @Nullable Object CAUGHT_t4qvtrTypedModel;
									try {
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull TypedModel t4qvtrTypedModel = THROWN_TmapOclMetamodel_0.getT4qvtrTypedModel();
										CAUGHT_t4qvtrTypedModel = t4qvtrTypedModel;
									}
									catch (Exception THROWN_CAUGHT_t4qvtrTypedModel) {
										CAUGHT_t4qvtrTypedModel = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrTypedModel);
									}
									/*@Caught*/ @Nullable Object CAUGHT_getPackage;
									try {
										if (CAUGHT_name instanceof InvalidValueException) {
											throw (InvalidValueException)CAUGHT_name;
										}
										final /*@Thrown*/ @Nullable String THROWN_name = (@Nullable String)CAUGHT_name;
										final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Package getPackage_0 = INSTANCE_CACHE_ATL2QVTr_getPackage.evaluate(rootThis, Module, THROWN_name);
										CAUGHT_getPackage = getPackage_0;
									}
									catch (Exception THROWN_CAUGHT_getPackage) {
										CAUGHT_getPackage = ValueUtil.createInvalidValue(THROWN_CAUGHT_getPackage);
									}
									/*@Caught*/ @Nullable Object CAUGHT_oclAsSet;
									try {
										if (CAUGHT_getPackage instanceof InvalidValueException) {
											throw (InvalidValueException)CAUGHT_getPackage;
										}
										final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Package THROWN_getPackage = (org.eclipse.ocl.pivot.@Nullable Package)CAUGHT_getPackage;
										final /*@Thrown*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(rootExecutor, SET_CLSSid_Package, THROWN_getPackage);
										CAUGHT_oclAsSet = oclAsSet;
									}
									catch (Exception THROWN_CAUGHT_oclAsSet) {
										CAUGHT_oclAsSet = ValueUtil.createInvalidValue(THROWN_CAUGHT_oclAsSet);
									}
									// mapping statements
									if (CAUGHT_t4qvtrTypedModel instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrTypedModel;
									}
									final /*@Thrown*/ @Nullable TypedModel THROWN_t4qvtrTypedModel = (@Nullable TypedModel)CAUGHT_t4qvtrTypedModel;
									if (CAUGHT_oclAsSet instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_oclAsSet;
									}
									final /*@Thrown*/ @Nullable SetValue THROWN_oclAsSet = (@Nullable SetValue)CAUGHT_oclAsSet;
									final /*@Thrown*/ @Nullable List<org.eclipse.ocl.pivot.Package> ECORE_oclAsSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.ocl.pivot.Package.class, THROWN_oclAsSet);
									THROWN_t4qvtrTypedModel.getUsedPackage().addAll(ECORE_oclAsSet);
									if (CAUGHT_oclAsSet instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_oclAsSet;
									}
									final /*@Thrown*/ @Nullable SetValue THROWN_oclAsSet_0 = (@Nullable SetValue)CAUGHT_oclAsSet;
									final /*@Thrown*/ @Nullable List<org.eclipse.ocl.pivot.Package> ECORE_oclAsSet_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.ocl.pivot.Package.class, THROWN_oclAsSet_0);
									trace.getT4qvtrPackages().addAll(ECORE_oclAsSet_0);
									if (CAUGHT_t4qvtrTypedModel instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrTypedModel;
									}
									final /*@Thrown*/ @Nullable TypedModel THROWN_t4qvtrTypedModel_0 = (@Nullable TypedModel)CAUGHT_t4qvtrTypedModel;
									if (CAUGHT_t4qvtrTransformation instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrTransformation;
									}
									final /*@Thrown*/ @Nullable RelationalTransformation THROWN_t4qvtrTransformation = (@Nullable RelationalTransformation)CAUGHT_t4qvtrTransformation;
									THROWN_t4qvtrTypedModel_0.setTransformation(THROWN_t4qvtrTransformation);
									trace.setT3atlModule(Module);
									trace.setT3oclMetamodel(metamodel);
									if (CAUGHT_t4qvtrTransformation instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrTransformation;
									}
									final /*@Thrown*/ @Nullable RelationalTransformation THROWN_t4qvtrTransformation_0 = (@Nullable RelationalTransformation)CAUGHT_t4qvtrTransformation;
									trace.setT4qvtrTransformation(THROWN_t4qvtrTransformation_0);
									if (CAUGHT_t4qvtrTypedModel instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrTypedModel;
									}
									final /*@Thrown*/ @Nullable TypedModel THROWN_t4qvtrTypedModel_1 = (@Nullable TypedModel)CAUGHT_t4qvtrTypedModel;
									trace.setT4qvtrTypedModel(THROWN_t4qvtrTypedModel_1);
									trace.setWmapModule(THROWN_TmapModule_0);
									trace.setWmapOclMetamodel(THROWN_TmapOclMetamodel_0);
									final /*@NonInvalid*/ boolean mmapOclModel__OUT__qvtr__init__ = ValueUtil.TRUE_VALUE;
									IF_s0global_0 = mmapOclModel__OUT__qvtr__init__;
								}
								else {
									IF_s0global_0 = ValueUtil.FALSE_VALUE;
								}
								IF_IsEQ__3 = IF_s0global_0;
							}
							else {
								IF_IsEQ__3 = ValueUtil.FALSE_VALUE;
							}
							IF_s0global = IF_IsEQ__3;
						}
						else {
							IF_s0global = ValueUtil.FALSE_VALUE;
						}
						IF_IsEQ__2 = IF_s0global;
					}
					else {
						IF_IsEQ__2 = ValueUtil.FALSE_VALUE;
					}
					IF_IsEQ__1 = IF_IsEQ__2;
				}
				else {
					IF_IsEQ__1 = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ__0 = IF_IsEQ__1;
			}
			else {
				IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsEQ__0;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0global(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_OCL_MODEL_OUT__S0GLOBAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapOclModel__OUT__qvtr__init__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:3 mmapOclType__qvtr__rest__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOclType[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOclType;
	 * check trace.s0global;
	 * notify set dispatcher.s0global := true;
	 *
	 */
	protected boolean MAP_mmapOclType__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapOclType trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclType__qvtr__rest__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOclType domapOclType = dispatcher.getDomapOclType();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapOclType);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
			if (s0global == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ boolean IF_s0global;
			if (s0global) {
				// mapping statements
				dispatcher.setS0global(ValueUtil.TRUE_VALUE);
				objectManager.assigned(dispatcher, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
				final /*@NonInvalid*/ boolean mmapOclType__qvtr__rest__ = ValueUtil.TRUE_VALUE;
				IF_s0global = mmapOclType__qvtr__rest__;
			}
			else {
				IF_s0global = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_s0global;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapOclType__qvtr__rest__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:3 mmapStringExp__qvtr__rest__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapStringExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapStringExp;
	 * check var qvtrExpression : StringLiteralExp[1] := dispatcher.d4qvtrExpression;
	 * check trace.s0global;
	 * var String1 : PrimitiveType[1] := String;
	 * notify set dispatcher.s0global := true;
	 * notify set qvtrExpression.type := String1;
	 *
	 */
	protected boolean MAP_mmapStringExp__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapStringExp trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapStringExp__qvtr__rest__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapStringExp domapStringExp = dispatcher.getDomapStringExp();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapStringExp);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = dispatcher.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d4qvtrExpression instanceof StringLiteralExp;
			/*@Thrown*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ @Nullable StringLiteralExp CAST_d4qvtrExpression = (StringLiteralExp)d4qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0global;
				if (s0global) {
					final /*@NonInvalid*/ @NonNull PrimitiveType TYP_String = (PrimitiveType)idResolver.getClass(TypeId.STRING, null);
					// mapping statements
					dispatcher.setS0global(ValueUtil.TRUE_VALUE);
					objectManager.assigned(dispatcher, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
					CAST_d4qvtrExpression.setType(TYP_String);
					objectManager.assigned(CAST_d4qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, TYP_String, false);
					final /*@NonInvalid*/ boolean mmapStringExp__qvtr__rest__ = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapStringExp__qvtr__rest__;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_IsKINDOF_ = IF_s0global;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapStringExp__qvtr__rest__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:3 mmapVariableExp__qvtr__rest__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapVariableExp;
	 * check trace.s0global;
	 * notify set dispatcher.s0global := true;
	 *
	 */
	protected boolean MAP_mmapVariableExp__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapVariableExp trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariableExp__qvtr__rest__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapVariableExp domapVariableExp = dispatcher.getDomapVariableExp();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapVariableExp);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
			if (s0global == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ boolean IF_s0global;
			if (s0global) {
				// mapping statements
				dispatcher.setS0global(ValueUtil.TRUE_VALUE);
				objectManager.assigned(dispatcher, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
				final /*@NonInvalid*/ boolean mmapVariableExp__qvtr__rest__ = ValueUtil.TRUE_VALUE;
				IF_s0global = mmapVariableExp__qvtr__rest__;
			}
			else {
				IF_s0global = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_s0global;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapVariableExp__qvtr__rest__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:3 mmapVariableExp__referredVariable__dispatch__qvtr in ATL2QVTr {
	 * guard:middle dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1];
	 * append jm_TmapVariableExp__referredVariable__Helper  : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * append jm_TmapVariableExp__referredVariable__VariableDecl  : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1];
	 * var atlExpression : OCL::VariableExp[1] := dispatcher.d3atlExpression;
	 * new:middle mapVariableExp_referredVariable_Helper : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * new:middle mapVariableExp_referredVariable_VariableDeclaration : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1];
	 * set dispatcher.domapVariableExp_referredVariable_Helper := mapVariableExp_referredVariable_Helper;
	 * set dispatcher.domapVariableExp_referredVariable_VariableDeclaration := mapVariableExp_referredVariable_VariableDeclaration;
	 * add jm_TmapVariableExp__referredVariable__Helper += mapVariableExp_referredVariable_Helper;
	 * add jm_TmapVariableExp__referredVariable__VariableDecl += mapVariableExp_referredVariable_VariableDeclaration;
	 *
	 */
	protected boolean MAP_mmapVariableExp__referredVariable__dispatch__qvtr(final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher, final @NonNull Connection jm_TmapVariableExp__referredVariable__Helper, final @NonNull Connection jm_TmapVariableExp__referredVariable__VariableDecl)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariableExp__referredVariable__dispatch__qvtr" +
					"\n\t\"dispatcher\":" + toDebugString(dispatcher));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull VariableExp d3atlExpression = dispatcher.getD3atlExpression();
		// creations
		final @SuppressWarnings("null")@NonNull TmapVariableExp_referredVariable_Helper mapVariableExp_referredVariable_Helper = trace_ATL2QVTrFactory.eINSTANCE.createTmapVariableExp_referredVariable_Helper();
		MODEL_middle.add(mapVariableExp_referredVariable_Helper, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapVariableExp_referredVariable_Helper));
		}
		final @SuppressWarnings("null")@NonNull TmapVariableExp_referredVariable_VariableDeclaration mapVariableExp_referredVariable_VariableDeclaration = trace_ATL2QVTrFactory.eINSTANCE.createTmapVariableExp_referredVariable_VariableDeclaration();
		MODEL_middle.add(mapVariableExp_referredVariable_VariableDeclaration, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapVariableExp_referredVariable_VariableDeclaration));
		}
		// mapping statements
		dispatcher.setDomapVariableExp_referredVariable_Helper(mapVariableExp_referredVariable_Helper);
		dispatcher.setDomapVariableExp_referredVariable_VariableDeclaration(mapVariableExp_referredVariable_VariableDeclaration);
		jm_TmapVariableExp__referredVariable__Helper.appendElement(mapVariableExp_referredVariable_Helper);
		jm_TmapVariableExp__referredVariable__VariableDecl.appendElement(mapVariableExp_referredVariable_VariableDeclaration);
		final /*@NonInvalid*/ boolean mmapVariableExp__referredVariable__dispatch__qvtr = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapVariableExp__referredVariable__dispatch__qvtr ? "done "  : "fail ") + "MAP_mmapVariableExp__referredVariable__dispatch__qvtr");
		}
		return mmapVariableExp__referredVariable__dispatch__qvtr;
	}

	/**
	 *
	 * map:4 mmapInPattern__qvtr__init__ in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapInPattern[1] success s0global;
	 * var atlPattern : ATL::InPattern[1] := trace.t3atlPattern;
	 * var atlRule : ATL::MatchedRule[1] := atlPattern.rule;
	 * var when_mapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1] := atlRule.TmapMatchedRule;
	 * check when_mapMatchedRule.s0global;
	 * var elements : Set(ATL::InPatternElement[+|1]) := atlPattern.elements;
	 * var collect : Bag(OCL::OclType[*|?]) := elements->collect(i | i.type)
	 *   ;
	 * var selectByKind : Bag(OCL::OclModelElement) := collect->selectByKind(OCL::OclModelElement)
	 *   ;
	 * var any : OCL::OclModelElement[1] := selectByKind->any(i | true);
	 * var atlModel : OCL::OclModel[1] := any.model;
	 * check atlModel.metamodel = null;
	 * var when_mapOclMetamodel : trace_ATL2QVTr::TmapOclMetamodel[1] := atlModel.TmapOclMetamodel;
	 * check when_mapOclMetamodel.s0global;
	 * var qvtrRelation : qvtrelation::Relation[1] := when_mapMatchedRule.t4qvtrRelation;
	 * var qvtrTypedModel : qvtbase::TypedModel[1] := when_mapOclMetamodel.t4qvtrTypedModel;
	 * new:qvtr qvtrDomain : qvtrelation::RelationDomain[1];
	 * set qvtrDomain.rule := qvtrRelation;
	 * set qvtrDomain.typedModel := qvtrTypedModel;
	 * set trace.t3atlModel := atlModel;
	 * set trace.t3atlRule := atlRule;
	 * set trace.t4qvtrDomain := qvtrDomain;
	 * set trace.t4qvtrRelation := qvtrRelation;
	 * set trace.t4qvtrTypedModel := qvtrTypedModel;
	 * set trace.wmapMatchedRule := when_mapMatchedRule;
	 * set trace.wmapOclMetamodel := when_mapOclMetamodel;
	 *
	 */
	protected boolean MAP_mmapInPattern__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapInPattern trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapInPattern__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull InPattern t3atlPattern = trace.getT3atlPattern();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull MatchedRule rule = t3atlPattern.getRule();
		final /*@NonInvalid*/ @Nullable TmapMatchedRule TmapMatchedRule = OPPOSITE_OF_TmapMatchedRule_t3matchedRule.get(rule);
		final /*@NonInvalid*/ Boolean IsEQ_ = TmapMatchedRule != null;
		/*@Thrown*/ Boolean IF_IsEQ_;
		if (IsEQ_) {
			if (TmapMatchedRule == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean s0global = TmapMatchedRule.getS0global();
			if (s0global == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ boolean IF_s0global;
			if (s0global) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<InPatternElement> elements = t3atlPattern.getElements();
				/*@Caught*/ @Nullable Object CAUGHT_collect;
				try {
					final /*@NonInvalid*/ @Nullable SetValue BOXED_elements = idResolver.createSetOfAll(SET_CLSSid_InPatternElement, elements);
					/*@NonInvalid*/ BagValue.@NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_OclType);
					@NonNull Iterator<Object> ITER_i = BOXED_elements.iterator();
					/*@Thrown*/ @NonNull BagValue collect;
					while (true) {
						if (!ITER_i.hasNext()) {
							collect = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull InPatternElement i = (@NonNull InPatternElement)ITER_i.next();
						/**
						 * i.type
						 */
						final /*@NonInvalid*/ @Nullable OclType type = i.getType();
						//
						accumulator.add(type);
					}
					CAUGHT_collect = collect;
				}
				catch (Exception THROWN_CAUGHT_collect) {
					CAUGHT_collect = ValueUtil.createInvalidValue(THROWN_CAUGHT_collect);
				}
				/*@Caught*/ @Nullable Object CAUGHT_selectByKind;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_OclModelElement = idResolver.getClass(CLSSid_OclModelElement, null);
					if (CAUGHT_collect instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_collect;
					}
					final /*@Thrown*/ @Nullable BagValue THROWN_collect = (@Nullable BagValue)CAUGHT_collect;
					final /*@Thrown*/ @NonNull BagValue selectByKind = (BagValue)CollectionSelectByKindOperation.INSTANCE.evaluate(rootExecutor, THROWN_collect, TYP_OCL_c_c_OclModelElement);
					CAUGHT_selectByKind = selectByKind;
				}
				catch (Exception THROWN_CAUGHT_selectByKind) {
					CAUGHT_selectByKind = ValueUtil.createInvalidValue(THROWN_CAUGHT_selectByKind);
				}
				/*@Caught*/ @Nullable Object CAUGHT_any;
				try {
					if (CAUGHT_selectByKind instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_selectByKind;
					}
					final /*@Thrown*/ @Nullable BagValue THROWN_selectByKind = (@Nullable BagValue)CAUGHT_selectByKind;
					@NonNull Iterator<Object> ITER_i_0 = THROWN_selectByKind.iterator();
					/*@Thrown*/ @NonNull OclModelElement any_0;
					while (true) {
						if (!ITER_i_0.hasNext()) {
							throw new InvalidValueException("Nothing to return for ''any''");
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull OclModelElement i_0 = (@NonNull OclModelElement)ITER_i_0.next();
						/**
						 * true
						 */
						//
						if (ValueUtil.TRUE_VALUE) {			// Carry on till something found
							any_0 = i_0;
							break;
						}
					}
					CAUGHT_any = any_0;
				}
				catch (Exception THROWN_CAUGHT_any) {
					CAUGHT_any = ValueUtil.createInvalidValue(THROWN_CAUGHT_any);
				}
				/*@Caught*/ @Nullable Object CAUGHT_model;
				try {
					if (CAUGHT_any instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_any;
					}
					final /*@Thrown*/ @Nullable OclModelElement THROWN_any = (@Nullable OclModelElement)CAUGHT_any;
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OclModel model = THROWN_any.getModel();
					CAUGHT_model = model;
				}
				catch (Exception THROWN_CAUGHT_model) {
					CAUGHT_model = ValueUtil.createInvalidValue(THROWN_CAUGHT_model);
				}
				if (CAUGHT_model instanceof InvalidValueException) {
					throw (InvalidValueException)CAUGHT_model;
				}
				final /*@Thrown*/ @Nullable OclModel THROWN_model = (@Nullable OclModel)CAUGHT_model;
				final /*@Thrown*/ @Nullable OclModel metamodel = THROWN_model.getMetamodel();
				final /*@Thrown*/ boolean IsEQ__0 = metamodel == null;
				/*@Thrown*/ boolean IF_IsEQ__0;
				if (IsEQ__0) {
					/*@Caught*/ @Nullable Object CAUGHT_TmapOclMetamodel;
					try {
						final /*@Thrown*/ @Nullable TmapOclMetamodel TmapOclMetamodel = OPPOSITE_OF_TmapOclMetamodel_t3oclMetamodel.get(THROWN_model);
						CAUGHT_TmapOclMetamodel = TmapOclMetamodel;
					}
					catch (Exception THROWN_CAUGHT_TmapOclMetamodel) {
						CAUGHT_TmapOclMetamodel = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapOclMetamodel);
					}
					if (CAUGHT_TmapOclMetamodel instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_TmapOclMetamodel;
					}
					final /*@Thrown*/ @Nullable TmapOclMetamodel THROWN_TmapOclMetamodel = (@Nullable TmapOclMetamodel)CAUGHT_TmapOclMetamodel;
					final /*@Thrown*/ Boolean IsEQ__1 = THROWN_TmapOclMetamodel != null;
					/*@Thrown*/ Boolean IF_IsEQ__1;
					if (IsEQ__1) {
						/*@Caught*/ @Nullable Object CAUGHT_TmapOclMetamodel_0;
						try {
							if (THROWN_TmapOclMetamodel == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							CAUGHT_TmapOclMetamodel_0 = THROWN_TmapOclMetamodel;
						}
						catch (Exception THROWN_CAUGHT_TmapOclMetamodel_0) {
							CAUGHT_TmapOclMetamodel_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapOclMetamodel_0);
						}
						if (CAUGHT_TmapOclMetamodel_0 instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_TmapOclMetamodel_0;
						}
						final /*@Thrown*/ @Nullable TmapOclMetamodel THROWN_TmapOclMetamodel_0 = (@Nullable TmapOclMetamodel)CAUGHT_TmapOclMetamodel_0;
						final /*@Thrown*/ @Nullable Boolean s0global_0 = THROWN_TmapOclMetamodel_0.getS0global();
						if (s0global_0 == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ boolean IF_s0global_0;
						if (s0global_0) {
							/*@Caught*/ @Nullable Object CAUGHT_t4qvtrRelation;
							try {
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull Relation t4qvtrRelation = TmapMatchedRule.getT4qvtrRelation();
								CAUGHT_t4qvtrRelation = t4qvtrRelation;
							}
							catch (Exception THROWN_CAUGHT_t4qvtrRelation) {
								CAUGHT_t4qvtrRelation = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrRelation);
							}
							/*@Caught*/ @Nullable Object CAUGHT_t4qvtrTypedModel;
							try {
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull TypedModel t4qvtrTypedModel = THROWN_TmapOclMetamodel_0.getT4qvtrTypedModel();
								CAUGHT_t4qvtrTypedModel = t4qvtrTypedModel;
							}
							catch (Exception THROWN_CAUGHT_t4qvtrTypedModel) {
								CAUGHT_t4qvtrTypedModel = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrTypedModel);
							}
							// creations
							final @NonNull RelationDomain qvtrDomain = QVTrelationFactory.eINSTANCE.createRelationDomain();
							MODEL_qvtr.add(qvtrDomain, false);
							if (debugCreations) {
								AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrDomain));
							}
							// mapping statements
							if (CAUGHT_t4qvtrRelation instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_t4qvtrRelation;
							}
							final /*@Thrown*/ @Nullable Relation THROWN_t4qvtrRelation = (@Nullable Relation)CAUGHT_t4qvtrRelation;
							qvtrDomain.setRule(THROWN_t4qvtrRelation);
							if (CAUGHT_t4qvtrTypedModel instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_t4qvtrTypedModel;
							}
							final /*@Thrown*/ @Nullable TypedModel THROWN_t4qvtrTypedModel = (@Nullable TypedModel)CAUGHT_t4qvtrTypedModel;
							qvtrDomain.setTypedModel(THROWN_t4qvtrTypedModel);
							trace.setT3atlModel(THROWN_model);
							trace.setT3atlRule(rule);
							trace.setT4qvtrDomain(qvtrDomain);
							if (CAUGHT_t4qvtrRelation instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_t4qvtrRelation;
							}
							final /*@Thrown*/ @Nullable Relation THROWN_t4qvtrRelation_0 = (@Nullable Relation)CAUGHT_t4qvtrRelation;
							trace.setT4qvtrRelation(THROWN_t4qvtrRelation_0);
							if (CAUGHT_t4qvtrTypedModel instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_t4qvtrTypedModel;
							}
							final /*@Thrown*/ @Nullable TypedModel THROWN_t4qvtrTypedModel_0 = (@Nullable TypedModel)CAUGHT_t4qvtrTypedModel;
							trace.setT4qvtrTypedModel(THROWN_t4qvtrTypedModel_0);
							trace.setWmapMatchedRule(TmapMatchedRule);
							trace.setWmapOclMetamodel(THROWN_TmapOclMetamodel_0);
							final /*@NonInvalid*/ boolean mmapInPattern__qvtr__init__ = ValueUtil.TRUE_VALUE;
							IF_s0global_0 = mmapInPattern__qvtr__init__;
						}
						else {
							IF_s0global_0 = ValueUtil.FALSE_VALUE;
						}
						IF_IsEQ__1 = IF_s0global_0;
					}
					else {
						IF_IsEQ__1 = ValueUtil.FALSE_VALUE;
					}
					IF_IsEQ__0 = IF_IsEQ__1;
				}
				else {
					IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
				}
				IF_s0global = IF_IsEQ__0;
			}
			else {
				IF_s0global = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_s0global;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0global(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_IN_PATTERN__S0GLOBAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapInPattern__qvtr__init__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:4 mmapMatchedRule__qvtr__rest__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapMatchedRule[1];
	 * check trace.s0global;
	 * var _6 : qvtrelation::SharedVariable[1] := trace.t4_6;
	 * var qvtrRelation : qvtrelation::Relation[1] := trace.t4qvtrRelation;
	 * var _'qvttrace::TraceElement' : Class[1] := qvttrace::TraceElement;
	 * set _6.isImplicit := true;
	 * set _6.name := 'trace';
	 * set qvtrRelation.isTopLevel := true;
	 * set _6.type := _'qvttrace::TraceElement';
	 *
	 */
	protected boolean MAP_mmapMatchedRule__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapMatchedRule trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapMatchedRule__qvtr__rest__" +
					"\n\t\"trace\":" + toDebugString(trace));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
		if (s0global == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ boolean IF_s0global;
		if (s0global) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull SharedVariable t4_6 = trace.getT4_6();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Relation t4qvtrRelation = trace.getT4qvtrRelation();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvttrace_c_c_TraceElement = idResolver.getClass(CLSSid_TraceElement, null);
			// mapping statements
			t4_6.setIsImplicit(ValueUtil.TRUE_VALUE);
			t4_6.setName(STR_trace);
			t4qvtrRelation.setIsTopLevel(ValueUtil.TRUE_VALUE);
			t4_6.setType(TYP_qvttrace_c_c_TraceElement);
			final /*@NonInvalid*/ boolean mmapMatchedRule__qvtr__rest__ = ValueUtil.TRUE_VALUE;
			IF_s0global = mmapMatchedRule__qvtr__rest__;
		}
		else {
			IF_s0global = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_s0global ? "done "  : "fail ") + "MAP_mmapMatchedRule__qvtr__rest__");
		}
		return IF_s0global;
	}

	/**
	 *
	 * map:4 mmapMatchedRule__super__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapMatchedRule_super[1] success s0global;
	 * var atlChildRule : ATL::MatchedRule[1] := trace.t3atlChildRule;
	 * var when_mapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1] := atlChildRule.TmapMatchedRule;
	 * check when_mapMatchedRule.s0global;
	 * var atlSuperRule : ATL::MatchedRule[1] := atlChildRule.superRule;
	 * var when_mapMatchedRule1 : trace_ATL2QVTr::TmapMatchedRule[1] := atlSuperRule.TmapMatchedRule;
	 * check when_mapMatchedRule1.s0global;
	 * var qvtrOverridesRelation : qvtrelation::Relation[1] := when_mapMatchedRule.t4qvtrRelation;
	 * var qvtrOverriddenRelation : qvtrelation::Relation[1] := when_mapMatchedRule1.t4qvtrRelation;
	 * set qvtrOverridesRelation.overrides := qvtrOverriddenRelation;
	 * set trace.t3atlSuperRule := atlSuperRule;
	 * set trace.t4qvtrOverriddenRelation := qvtrOverriddenRelation;
	 * set trace.t4qvtrOverridesRelation := qvtrOverridesRelation;
	 * set trace.wmapMatchedRule1 := when_mapMatchedRule;
	 * set trace.wmapMatchedRule := when_mapMatchedRule1;
	 *
	 */
	protected boolean MAP_mmapMatchedRule__super__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapMatchedRule_super trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapMatchedRule__super__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull MatchedRule t3atlChildRule = trace.getT3atlChildRule();
		final /*@NonInvalid*/ @Nullable TmapMatchedRule TmapMatchedRule = OPPOSITE_OF_TmapMatchedRule_t3matchedRule.get(t3atlChildRule);
		final /*@NonInvalid*/ Boolean IsEQ_ = TmapMatchedRule != null;
		/*@Thrown*/ Boolean IF_IsEQ_;
		if (IsEQ_) {
			if (TmapMatchedRule == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean s0global = TmapMatchedRule.getS0global();
			if (s0global == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ boolean IF_s0global;
			if (s0global) {
				final /*@NonInvalid*/ @Nullable MatchedRule superRule = t3atlChildRule.getSuperRule();
				final /*@NonInvalid*/ Boolean IsEQ__0 = superRule != null;
				/*@Thrown*/ Boolean IF_IsEQ__0;
				if (IsEQ__0) {
					if (superRule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					/*@Caught*/ @Nullable Object CAUGHT_TmapMatchedRule;
					try {
						final /*@Thrown*/ @Nullable TmapMatchedRule TmapMatchedRule_0 = OPPOSITE_OF_TmapMatchedRule_t3matchedRule.get(superRule);
						CAUGHT_TmapMatchedRule = TmapMatchedRule_0;
					}
					catch (Exception THROWN_CAUGHT_TmapMatchedRule) {
						CAUGHT_TmapMatchedRule = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapMatchedRule);
					}
					if (CAUGHT_TmapMatchedRule instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_TmapMatchedRule;
					}
					final /*@Thrown*/ @Nullable TmapMatchedRule THROWN_TmapMatchedRule = (@Nullable TmapMatchedRule)CAUGHT_TmapMatchedRule;
					final /*@Thrown*/ Boolean IsEQ__1 = THROWN_TmapMatchedRule != null;
					/*@Thrown*/ Boolean IF_IsEQ__1;
					if (IsEQ__1) {
						/*@Caught*/ @Nullable Object CAUGHT_TmapMatchedRule_0;
						try {
							if (THROWN_TmapMatchedRule == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							CAUGHT_TmapMatchedRule_0 = THROWN_TmapMatchedRule;
						}
						catch (Exception THROWN_CAUGHT_TmapMatchedRule_0) {
							CAUGHT_TmapMatchedRule_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapMatchedRule_0);
						}
						if (CAUGHT_TmapMatchedRule_0 instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_TmapMatchedRule_0;
						}
						final /*@Thrown*/ @Nullable TmapMatchedRule THROWN_TmapMatchedRule_0 = (@Nullable TmapMatchedRule)CAUGHT_TmapMatchedRule_0;
						final /*@Thrown*/ @Nullable Boolean s0global_0 = THROWN_TmapMatchedRule_0.getS0global();
						if (s0global_0 == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ boolean IF_s0global_0;
						if (s0global_0) {
							/*@Caught*/ @Nullable Object CAUGHT_t4qvtrRelation;
							try {
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull Relation t4qvtrRelation = TmapMatchedRule.getT4qvtrRelation();
								CAUGHT_t4qvtrRelation = t4qvtrRelation;
							}
							catch (Exception THROWN_CAUGHT_t4qvtrRelation) {
								CAUGHT_t4qvtrRelation = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrRelation);
							}
							/*@Caught*/ @Nullable Object CAUGHT_t4qvtrRelation_0;
							try {
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull Relation t4qvtrRelation_0 = THROWN_TmapMatchedRule_0.getT4qvtrRelation();
								CAUGHT_t4qvtrRelation_0 = t4qvtrRelation_0;
							}
							catch (Exception THROWN_CAUGHT_t4qvtrRelation_0) {
								CAUGHT_t4qvtrRelation_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrRelation_0);
							}
							// mapping statements
							if (CAUGHT_t4qvtrRelation instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_t4qvtrRelation;
							}
							final /*@Thrown*/ @Nullable Relation THROWN_t4qvtrRelation_0 = (@Nullable Relation)CAUGHT_t4qvtrRelation;
							if (CAUGHT_t4qvtrRelation_0 instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_t4qvtrRelation_0;
							}
							final /*@Thrown*/ @Nullable Relation THROWN_t4qvtrRelation = (@Nullable Relation)CAUGHT_t4qvtrRelation_0;
							THROWN_t4qvtrRelation_0.getOverrides().add(THROWN_t4qvtrRelation);
							trace.setT3atlSuperRule(superRule);
							if (CAUGHT_t4qvtrRelation_0 instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_t4qvtrRelation_0;
							}
							final /*@Thrown*/ @Nullable Relation THROWN_t4qvtrRelation_1 = (@Nullable Relation)CAUGHT_t4qvtrRelation_0;
							trace.setT4qvtrOverriddenRelation(THROWN_t4qvtrRelation_1);
							if (CAUGHT_t4qvtrRelation instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_t4qvtrRelation;
							}
							final /*@Thrown*/ @Nullable Relation THROWN_t4qvtrRelation_2 = (@Nullable Relation)CAUGHT_t4qvtrRelation;
							trace.setT4qvtrOverridesRelation(THROWN_t4qvtrRelation_2);
							trace.setWmapMatchedRule1(TmapMatchedRule);
							trace.setWmapMatchedRule(THROWN_TmapMatchedRule_0);
							final /*@NonInvalid*/ boolean mmapMatchedRule__super__qvtr__init__ = ValueUtil.TRUE_VALUE;
							IF_s0global_0 = mmapMatchedRule__super__qvtr__init__;
						}
						else {
							IF_s0global_0 = ValueUtil.FALSE_VALUE;
						}
						IF_IsEQ__1 = IF_s0global_0;
					}
					else {
						IF_IsEQ__1 = ValueUtil.FALSE_VALUE;
					}
					IF_IsEQ__0 = IF_IsEQ__1;
				}
				else {
					IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
				}
				IF_s0global = IF_IsEQ__0;
			}
			else {
				IF_s0global = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_s0global;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0global(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_MATCHED_RULE_SUPER__S0GLOBAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapMatchedRule__super__qvtr__init__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:4 mmapSimpleOutPatternElement__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapSimpleOutPatternElement[1] success s0global;
	 * append jm_TmapVariable  : trace_ATL2QVTr::TmapVariable[1];
	 * var atlElement : ATL::SimpleOutPatternElement[1] := trace.t3atlElement;
	 * check var atlType : OCL::OclModelElement[1] := atlElement.type;
	 * var atlMetamodel : OCL::OclModel[1] := atlType.model;
	 * check atlMetamodel.metamodel =
	 *   null;
	 * var atlPattern : ATL::OutPattern[1] := atlElement.outPattern;
	 * check var atlRule : ATL::MatchedRule[1] := atlPattern.rule;
	 * var when_mapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1] := atlRule.TmapMatchedRule;
	 * check when_mapMatchedRule.s0global;
	 * var when_mapOclMetamodel : trace_ATL2QVTr::TmapOclMetamodel[1] := atlMetamodel.TmapOclMetamodel;
	 * check when_mapOclMetamodel.s0global;
	 * var elementName : String[1] := atlElement.varName;
	 * var qvtrRelation : qvtrelation::Relation[1] := when_mapMatchedRule.t4qvtrRelation;
	 * var qvtrTypedModel : qvtbase::TypedModel[1] := when_mapOclMetamodel.t4qvtrTypedModel;
	 * var getType1 : Class[1] := this.getType(atlType);
	 * new:qvtr qvtrDomain : qvtrelation::RelationDomain[1];
	 * new:qvtr qvtrPattern : qvtrelation::DomainPattern[1];
	 * new:qvtr qvtrTemplate : qvttemplate::ObjectTemplateExp[1];
	 * new:qvtr qvtrVariable : qvtrelation::TemplateVariable[1];
	 * new:middle where_mapVariable : trace_ATL2QVTr::TmapVariable[1] {trace_ATL2QVTr::TmapVariable::t3atlVariable : ATL::LocatedElement[1] = atlElement, trace_ATL2QVTr::TmapVariable::t4qvtrVariable : VariableDeclaration[1] = qvtrVariable}
	 * set qvtrVariable.name := elementName;
	 * set trace.t1elementName := elementName;
	 * set qvtrDomain.rule := qvtrRelation;
	 * set qvtrDomain.typedModel := qvtrTypedModel;
	 * set qvtrPattern.relationDomain := qvtrDomain;
	 * set qvtrPattern.templateExpression := qvtrTemplate;
	 * set qvtrTemplate.bindsTo := qvtrVariable;
	 * set qvtrTemplate.referredClass := getType1;
	 * notify set qvtrTemplate.type := getType1;
	 * set qvtrRelation.variable := qvtrVariable;
	 * set qvtrDomain.rootVariable := qvtrVariable;
	 * set qvtrVariable.type := getType1;
	 * set trace.t3atlMetamodel := atlMetamodel;
	 * set trace.t3atlPattern := atlPattern;
	 * set trace.t3atlRule := atlRule;
	 * set trace.t3atlType := atlType;
	 * set trace.t4qvtrDomain := qvtrDomain;
	 * set trace.t4qvtrPattern := qvtrPattern;
	 * set trace.t4qvtrRelation := qvtrRelation;
	 * set trace.t4qvtrTemplate := qvtrTemplate;
	 * set trace.t4qvtrType := getType1;
	 * set trace.t4qvtrTypedModel := qvtrTypedModel;
	 * set trace.t4qvtrVariable := qvtrVariable;
	 * set trace.wmapMatchedRule := when_mapMatchedRule;
	 * set trace.wmapOclMetamodel := when_mapOclMetamodel;
	 * set trace.wmapVariable := where_mapVariable;
	 * add jm_TmapVariable += where_mapVariable;
	 *
	 */
	protected boolean MAP_mmapSimpleOutPatternElement__qvtr__init__(final @NonNull Connection jm_TmapVariable, final /*@NonInvalid*/ @NonNull TmapSimpleOutPatternElement trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapSimpleOutPatternElement__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull SimpleOutPatternElement t3atlElement = trace.getT3atlElement();
		final /*@NonInvalid*/ @Nullable OclType type = t3atlElement.getType();
		final /*@NonInvalid*/ boolean IsKINDOF_ = type instanceof OclModelElement;
		/*@Thrown*/ boolean IF_IsKINDOF_;
		if (IsKINDOF_) {
			final /*@NonInvalid*/ @Nullable OclModelElement CAST_type = (OclModelElement)type;
			if (CAST_type == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			/*@Caught*/ @Nullable Object CAUGHT_model;
			try {
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull OclModel model = CAST_type.getModel();
				CAUGHT_model = model;
			}
			catch (Exception THROWN_CAUGHT_model) {
				CAUGHT_model = ValueUtil.createInvalidValue(THROWN_CAUGHT_model);
			}
			if (CAUGHT_model instanceof InvalidValueException) {
				throw (InvalidValueException)CAUGHT_model;
			}
			final /*@Thrown*/ @Nullable OclModel THROWN_model = (@Nullable OclModel)CAUGHT_model;
			final /*@Thrown*/ @Nullable OclModel metamodel = THROWN_model.getMetamodel();
			final /*@Thrown*/ boolean IsEQ_ = metamodel == null;
			/*@Thrown*/ boolean IF_IsEQ_;
			if (IsEQ_) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OutPattern outPattern = t3atlElement.getOutPattern();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Rule rule = outPattern.getRule();
				final /*@NonInvalid*/ boolean IsKINDOF__0 = rule instanceof MatchedRule;
				/*@Thrown*/ boolean IF_IsKINDOF__0;
				if (IsKINDOF__0) {
					final /*@NonInvalid*/ @Nullable MatchedRule CAST_rule = (MatchedRule)rule;
					final /*@NonInvalid*/ @Nullable TmapMatchedRule TmapMatchedRule = OPPOSITE_OF_TmapMatchedRule_t3matchedRule.get(CAST_rule);
					final /*@NonInvalid*/ Boolean IsEQ__0 = TmapMatchedRule != null;
					/*@Thrown*/ Boolean IF_IsEQ__0;
					if (IsEQ__0) {
						if (TmapMatchedRule == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean s0global = TmapMatchedRule.getS0global();
						if (s0global == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ boolean IF_s0global;
						if (s0global) {
							/*@Caught*/ @Nullable Object CAUGHT_TmapOclMetamodel;
							try {
								final /*@Thrown*/ @Nullable TmapOclMetamodel TmapOclMetamodel = OPPOSITE_OF_TmapOclMetamodel_t3oclMetamodel.get(THROWN_model);
								CAUGHT_TmapOclMetamodel = TmapOclMetamodel;
							}
							catch (Exception THROWN_CAUGHT_TmapOclMetamodel) {
								CAUGHT_TmapOclMetamodel = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapOclMetamodel);
							}
							if (CAUGHT_TmapOclMetamodel instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_TmapOclMetamodel;
							}
							final /*@Thrown*/ @Nullable TmapOclMetamodel THROWN_TmapOclMetamodel = (@Nullable TmapOclMetamodel)CAUGHT_TmapOclMetamodel;
							final /*@Thrown*/ Boolean IsEQ__1 = THROWN_TmapOclMetamodel != null;
							/*@Thrown*/ Boolean IF_IsEQ__1;
							if (IsEQ__1) {
								/*@Caught*/ @Nullable Object CAUGHT_TmapOclMetamodel_0;
								try {
									if (THROWN_TmapOclMetamodel == null) {
										throw new InvalidEvaluationException("Null where non-null value required");
									}
									CAUGHT_TmapOclMetamodel_0 = THROWN_TmapOclMetamodel;
								}
								catch (Exception THROWN_CAUGHT_TmapOclMetamodel_0) {
									CAUGHT_TmapOclMetamodel_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_TmapOclMetamodel_0);
								}
								if (CAUGHT_TmapOclMetamodel_0 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_TmapOclMetamodel_0;
								}
								final /*@Thrown*/ @Nullable TmapOclMetamodel THROWN_TmapOclMetamodel_0 = (@Nullable TmapOclMetamodel)CAUGHT_TmapOclMetamodel_0;
								final /*@Thrown*/ @Nullable Boolean s0global_0 = THROWN_TmapOclMetamodel_0.getS0global();
								if (s0global_0 == null) {
									throw new InvalidEvaluationException("Null if condition");
								}
								/*@Thrown*/ boolean IF_s0global_0;
								if (s0global_0) {
									@SuppressWarnings("null")
									final /*@NonInvalid*/ @NonNull String varName = t3atlElement.getVarName();
									/*@Caught*/ @Nullable Object CAUGHT_t4qvtrRelation;
									try {
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull Relation t4qvtrRelation = TmapMatchedRule.getT4qvtrRelation();
										CAUGHT_t4qvtrRelation = t4qvtrRelation;
									}
									catch (Exception THROWN_CAUGHT_t4qvtrRelation) {
										CAUGHT_t4qvtrRelation = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrRelation);
									}
									/*@Caught*/ @Nullable Object CAUGHT_t4qvtrTypedModel;
									try {
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull TypedModel t4qvtrTypedModel = THROWN_TmapOclMetamodel_0.getT4qvtrTypedModel();
										CAUGHT_t4qvtrTypedModel = t4qvtrTypedModel;
									}
									catch (Exception THROWN_CAUGHT_t4qvtrTypedModel) {
										CAUGHT_t4qvtrTypedModel = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrTypedModel);
									}
									/*@Caught*/ @Nullable Object CAUGHT_getType;
									try {
										final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Class getType_0 = INSTANCE_CACHE_ATL2QVTr_getType.evaluate(rootThis, CAST_type);
										CAUGHT_getType = getType_0;
									}
									catch (Exception THROWN_CAUGHT_getType) {
										CAUGHT_getType = ValueUtil.createInvalidValue(THROWN_CAUGHT_getType);
									}
									// creations
									final @NonNull RelationDomain qvtrDomain = QVTrelationFactory.eINSTANCE.createRelationDomain();
									MODEL_qvtr.add(qvtrDomain, false);
									if (debugCreations) {
										AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrDomain));
									}
									final @NonNull DomainPattern qvtrPattern = QVTrelationFactory.eINSTANCE.createDomainPattern();
									MODEL_qvtr.add(qvtrPattern, false);
									if (debugCreations) {
										AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrPattern));
									}
									final @NonNull ObjectTemplateExp qvtrTemplate = QVTtemplateFactory.eINSTANCE.createObjectTemplateExp();
									MODEL_qvtr.add(qvtrTemplate, false);
									if (debugCreations) {
										AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrTemplate));
									}
									final @NonNull TemplateVariable qvtrVariable = QVTrelationFactory.eINSTANCE.createTemplateVariable();
									MODEL_qvtr.add(qvtrVariable, false);
									if (debugCreations) {
										AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrVariable));
									}
									final @SuppressWarnings("null")@NonNull TmapVariable where_mapVariable = INSTANCE_RULE_CACHE_TmapVariable.evaluate(t3atlElement, qvtrVariable);
									if (debugCreations) {
										AbstractTransformer.CREATIONS.println("created " + toDebugString(where_mapVariable));
									}
									// mapping statements
									qvtrVariable.setName(varName);
									trace.setT1elementName(varName);
									if (CAUGHT_t4qvtrRelation instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrRelation;
									}
									final /*@Thrown*/ @Nullable Relation THROWN_t4qvtrRelation = (@Nullable Relation)CAUGHT_t4qvtrRelation;
									qvtrDomain.setRule(THROWN_t4qvtrRelation);
									if (CAUGHT_t4qvtrTypedModel instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrTypedModel;
									}
									final /*@Thrown*/ @Nullable TypedModel THROWN_t4qvtrTypedModel = (@Nullable TypedModel)CAUGHT_t4qvtrTypedModel;
									qvtrDomain.setTypedModel(THROWN_t4qvtrTypedModel);
									qvtrPattern.setRelationDomain(qvtrDomain);
									qvtrPattern.setTemplateExpression(qvtrTemplate);
									qvtrTemplate.setBindsTo(qvtrVariable);
									if (CAUGHT_getType instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_getType;
									}
									final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Class THROWN_getType = (org.eclipse.ocl.pivot.@Nullable Class)CAUGHT_getType;
									qvtrTemplate.setReferredClass(THROWN_getType);
									if (CAUGHT_getType instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_getType;
									}
									final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Class THROWN_getType_0 = (org.eclipse.ocl.pivot.@Nullable Class)CAUGHT_getType;
									qvtrTemplate.setType(THROWN_getType_0);
									objectManager.assigned(qvtrTemplate, PivotPackage.Literals.TYPED_ELEMENT__TYPE, THROWN_getType_0, false);
									if (CAUGHT_t4qvtrRelation instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrRelation;
									}
									final /*@Thrown*/ @Nullable Relation THROWN_t4qvtrRelation_0 = (@Nullable Relation)CAUGHT_t4qvtrRelation;
									THROWN_t4qvtrRelation_0.getVariable().add(qvtrVariable);
									qvtrDomain.getRootVariable().add(qvtrVariable);
									if (CAUGHT_getType instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_getType;
									}
									final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Class THROWN_getType_1 = (org.eclipse.ocl.pivot.@Nullable Class)CAUGHT_getType;
									qvtrVariable.setType(THROWN_getType_1);
									trace.setT3atlMetamodel(THROWN_model);
									trace.setT3atlPattern(outPattern);
									trace.setT3atlRule(CAST_rule);
									trace.setT3atlType(CAST_type);
									trace.setT4qvtrDomain(qvtrDomain);
									trace.setT4qvtrPattern(qvtrPattern);
									if (CAUGHT_t4qvtrRelation instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrRelation;
									}
									final /*@Thrown*/ @Nullable Relation THROWN_t4qvtrRelation_1 = (@Nullable Relation)CAUGHT_t4qvtrRelation;
									trace.setT4qvtrRelation(THROWN_t4qvtrRelation_1);
									trace.setT4qvtrTemplate(qvtrTemplate);
									if (CAUGHT_getType instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_getType;
									}
									final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Class THROWN_getType_2 = (org.eclipse.ocl.pivot.@Nullable Class)CAUGHT_getType;
									trace.setT4qvtrType(THROWN_getType_2);
									if (CAUGHT_t4qvtrTypedModel instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrTypedModel;
									}
									final /*@Thrown*/ @Nullable TypedModel THROWN_t4qvtrTypedModel_0 = (@Nullable TypedModel)CAUGHT_t4qvtrTypedModel;
									trace.setT4qvtrTypedModel(THROWN_t4qvtrTypedModel_0);
									trace.setT4qvtrVariable(qvtrVariable);
									trace.setWmapMatchedRule(TmapMatchedRule);
									trace.setWmapOclMetamodel(THROWN_TmapOclMetamodel_0);
									trace.setWmapVariable(where_mapVariable);
									jm_TmapVariable.appendElement(where_mapVariable);
									final /*@NonInvalid*/ boolean mmapSimpleOutPatternElement__qvtr__init__ = ValueUtil.TRUE_VALUE;
									IF_s0global_0 = mmapSimpleOutPatternElement__qvtr__init__;
								}
								else {
									IF_s0global_0 = ValueUtil.FALSE_VALUE;
								}
								IF_IsEQ__1 = IF_s0global_0;
							}
							else {
								IF_IsEQ__1 = ValueUtil.FALSE_VALUE;
							}
							IF_s0global = IF_IsEQ__1;
						}
						else {
							IF_s0global = ValueUtil.FALSE_VALUE;
						}
						IF_IsEQ__0 = IF_s0global;
					}
					else {
						IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
					}
					IF_IsKINDOF__0 = IF_IsEQ__0;
				}
				else {
					IF_IsKINDOF__0 = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ_ = IF_IsKINDOF__0;
			}
			else {
				IF_IsEQ_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsKINDOF_ = IF_IsEQ_;
		}
		else {
			IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0global(IF_IsKINDOF_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_SIMPLE_OUT_PATTERN_ELEMENT__S0GLOBAL, IF_IsKINDOF_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsKINDOF_ ? "done "  : "fail ") + "MAP_mmapSimpleOutPatternElement__qvtr__init__");
		}
		return IF_IsKINDOF_;
	}

	/**
	 *
	 * strict map:5 mmapHelper__Attribute__qvtr__loop__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Attribute[1] success s0global;
	 * append jm_TmapHelper__Context  : trace_ATL2QVTr::TmapHelper_Context[1];
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapHelper_Attribute;
	 * var atlHelper : ATL::Helper[1] := dispatcher.d3atlHelper;
	 * check trace.s0local;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * speculate when_mapOclExpression.s0global;
	 * var attributeName : String[1] := trace.t1attributeName;
	 * var atlType : OCL::OclType[1] := trace.t3atlType;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := trace.t4qvtrTransformation;
	 * var getType1 : Class[1] := this.getType(atlType);
	 * new:qvtr qvtrFunction : qvtbase::Function[1];
	 * new:middle where_mapHelper_Context : trace_ATL2QVTr::TmapHelper_Context[1] {trace_ATL2QVTr::TmapHelper_Context::t3atlHelper : ATL::Helper[1] = atlHelper, trace_ATL2QVTr::TmapHelper_Context::t4qvtrFunction : qvtbase::Function[1] = qvtrFunction}
	 * set qvtrFunction.name := attributeName;
	 * notify set dispatcher.s0global := true;
	 * set dispatcher.d4qvtrFunction := qvtrFunction;
	 * set trace.wmapHelper_Context := where_mapHelper_Context;
	 * set qvtrFunction.owningClass := qvtrTransformation;
	 * set qvtrFunction.type := getType1;
	 * add jm_TmapHelper__Context += where_mapHelper_Context;
	 *
	 */
	protected class MAP_mmapHelper__Attribute__qvtr__loop__ extends AbstractInvocation
	{
		protected final @NonNull Connection jm_TmapHelper__Context;
		protected final /*@NonInvalid*/ @NonNull TmapHelper_Attribute trace;

		public MAP_mmapHelper__Attribute__qvtr__loop__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			jm_TmapHelper__Context = (Connection)boundValues[0];
			trace = (@NonNull TmapHelper_Attribute)boundValues[1];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapHelper dispatcher = trace.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapHelper_Attribute domapHelper_Attribute = dispatcher.getDomapHelper_Attribute();
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapHelper_Attribute);
			/*@Thrown*/ boolean IF_IsEQ_;
			if (IsEQ_) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Helper d3atlHelper = dispatcher.getD3atlHelper();
				final /*@NonInvalid*/ @Nullable Boolean s0local = trace.getS0local();
				if (s0local == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0local;
				if (s0local) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace.getWmapOclExpression();
					SlotState.@NonNull Speculating outputSpeculatingSlotState = objectManager.getSpeculatingSlotState(trace, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__S0GLOBAL);
					Boolean outputSpeculatingSlotStatus = outputSpeculatingSlotState.getSpeculationStatus();
					if (outputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
						if (outputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
							trace.setS0global(ValueUtil.FALSE_VALUE);
							return ValueUtil.FALSE_VALUE;
						}
						SlotState.@NonNull Speculating inputSpeculatingSlotState;
						Boolean inputSpeculatingSlotStatus;
						boolean needsSpeculation = false;
						if (wmapOclExpression == null) {
							throw new InvalidEvaluationException("Null wmapOclExpression speculation source");
						}
						inputSpeculatingSlotState = objectManager.getSpeculatingSlotState(wmapOclExpression, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL);
						inputSpeculatingSlotStatus = inputSpeculatingSlotState.getSpeculationStatus();
						if (inputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
							if (inputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
								wmapOclExpression.setS0global(ValueUtil.FALSE_VALUE);
								return ValueUtil.FALSE_VALUE;
							}
							if (outputSpeculatingSlotState != inputSpeculatingSlotState) {
								outputSpeculatingSlotState.addInput(inputSpeculatingSlotState);
								needsSpeculation = true;
							}
						}
						if (needsSpeculation) {
							throw new InvocationFailedException(outputSpeculatingSlotState, true);
						}
					}
					boolean SPEC_ = true;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String t1attributeName = trace.getT1attributeName();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclType t3atlType = trace.getT3atlType();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull RelationalTransformation t4qvtrTransformation = trace.getT4qvtrTransformation();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class getType_0 = INSTANCE_CACHE_ATL2QVTr_getType.evaluate(rootThis, t3atlType);
					// creations
					final @NonNull Function qvtrFunction = QVTbaseFactory.eINSTANCE.createFunction();
					MODEL_qvtr.add(qvtrFunction, false);
					if (debugCreations) {
						AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrFunction));
					}
					final @SuppressWarnings("null")@NonNull TmapHelper_Context where_mapHelper_Context = INSTANCE_RULE_CACHE_TmapHelper_Context.evaluate(d3atlHelper, qvtrFunction);
					if (debugCreations) {
						AbstractTransformer.CREATIONS.println("created " + toDebugString(where_mapHelper_Context));
					}
					// mapping statements
					qvtrFunction.setName(t1attributeName);
					dispatcher.setS0global(ValueUtil.TRUE_VALUE);
					objectManager.assigned(dispatcher, trace_ATL2QVTrPackage.Literals.DMAP_HELPER__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
					dispatcher.setD4qvtrFunction(qvtrFunction);
					trace.setWmapHelper_Context(where_mapHelper_Context);
					qvtrFunction.setOwningClass(t4qvtrTransformation);
					qvtrFunction.setType(getType_0);
					jm_TmapHelper__Context.appendElement(where_mapHelper_Context);
					final /*@NonInvalid*/ boolean mmapHelper__Attribute__qvtr__loop__ = ValueUtil.TRUE_VALUE;
					IF_s0local = SPEC_;
				}
				else {
					IF_s0local = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ_ = IF_s0local;
			}
			else {
				IF_IsEQ_ = ValueUtil.FALSE_VALUE;
			}
			trace.setS0global(IF_IsEQ_);
			objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__S0GLOBAL, IF_IsEQ_, false);
			return IF_IsEQ_;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(jm_TmapHelper__Context, thoseValues[0])
					&& idResolver.oclEquals(trace, thoseValues[1]);
		}
	}

	/**
	 *
	 * strict map:5 mmapHelper__Context__qvtr__loop__ in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapHelper_Context[1] success s0global;
	 * append jm_TmapVariable  : trace_ATL2QVTr::TmapVariable[1];
	 * var atlHelper : ATL::Helper[1] := trace.t3atlHelper;
	 * var qvtrFunction : qvtbase::Function[1] := trace.t4qvtrFunction;
	 * var atlDefinition : OCL::OclFeatureDefinition[1] := atlHelper.definition;
	 * var atlContext : OCL::OclContextDefinition[1] := atlDefinition.context_;
	 * var atlReturnType : OCL::OclType[1] := atlContext.context_;
	 * var getType1 : Class[1] := this.getType(atlReturnType);
	 * new:qvtr qvtrParameter : qvtbase::FunctionParameter[1];
	 * new:middle where_mapVariable : trace_ATL2QVTr::TmapVariable[1] {trace_ATL2QVTr::TmapVariable::t3atlVariable : ATL::LocatedElement[1] = atlHelper, trace_ATL2QVTr::TmapVariable::t4qvtrVariable : VariableDeclaration[1] = qvtrParameter}
	 * notify set qvtrParameter.name := 'self';
	 * set trace.t3atlContext := atlContext;
	 * set trace.t3atlDefinition := atlDefinition;
	 * set trace.t3atlReturnType := atlReturnType;
	 * set trace.t4qvtrParameter := qvtrParameter;
	 * set trace.wmapVariable := where_mapVariable;
	 * set qvtrParameter.owningOperation := qvtrFunction;
	 * notify set qvtrParameter.type := getType1;
	 * add jm_TmapVariable += where_mapVariable;
	 *
	 */
	protected class MAP_mmapHelper__Context__qvtr__loop__ extends AbstractInvocation
	{
		protected final @NonNull Connection jm_TmapVariable;
		protected final /*@NonInvalid*/ @NonNull TmapHelper_Context trace;

		public MAP_mmapHelper__Context__qvtr__loop__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			jm_TmapVariable = (Connection)boundValues[0];
			trace = (@NonNull TmapHelper_Context)boundValues[1];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Helper t3atlHelper = trace.getT3atlHelper();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Function t4qvtrFunction = trace.getT4qvtrFunction();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = t3atlHelper.getDefinition();
			final /*@NonInvalid*/ @Nullable OclContextDefinition context_ = definition.getContext_();
			final /*@NonInvalid*/ Boolean IsEQ_ = context_ != null;
			/*@NonInvalid*/ Boolean IF_IsEQ_;
			if (IsEQ_) {
				if (context_ == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				/*@Caught*/ @Nullable Object CAUGHT_context_;
				try {
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OclType context__0 = context_.getContext_();
					CAUGHT_context_ = context__0;
				}
				catch (Exception THROWN_CAUGHT_context_) {
					CAUGHT_context_ = ValueUtil.createInvalidValue(THROWN_CAUGHT_context_);
				}
				/*@Caught*/ @Nullable Object CAUGHT_getType;
				try {
					if (CAUGHT_context_ instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_context_;
					}
					final /*@Thrown*/ @Nullable OclType THROWN_context_ = (@Nullable OclType)CAUGHT_context_;
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Class getType_0 = INSTANCE_CACHE_ATL2QVTr_getType.evaluate(rootThis, THROWN_context_);
					CAUGHT_getType = getType_0;
				}
				catch (Exception THROWN_CAUGHT_getType) {
					CAUGHT_getType = ValueUtil.createInvalidValue(THROWN_CAUGHT_getType);
				}
				// creations
				final @NonNull FunctionParameter qvtrParameter = QVTbaseFactory.eINSTANCE.createFunctionParameter();
				MODEL_qvtr.add(qvtrParameter, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrParameter));
				}
				final @SuppressWarnings("null")@NonNull TmapVariable where_mapVariable = INSTANCE_RULE_CACHE_TmapVariable.evaluate(t3atlHelper, qvtrParameter);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(where_mapVariable));
				}
				// mapping statements
				qvtrParameter.setName(STR_self);
				objectManager.assigned(qvtrParameter, PivotPackage.Literals.NAMED_ELEMENT__NAME, STR_self, false);
				trace.setT3atlContext(context_);
				trace.setT3atlDefinition(definition);
				if (CAUGHT_context_ instanceof InvalidValueException) {
					throw (InvalidValueException)CAUGHT_context_;
				}
				final /*@Thrown*/ @Nullable OclType THROWN_context__0 = (@Nullable OclType)CAUGHT_context_;
				trace.setT3atlReturnType(THROWN_context__0);
				trace.setT4qvtrParameter(qvtrParameter);
				trace.setWmapVariable(where_mapVariable);
				qvtrParameter.setOwningOperation(t4qvtrFunction);
				if (CAUGHT_getType instanceof InvalidValueException) {
					throw (InvalidValueException)CAUGHT_getType;
				}
				final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Class THROWN_getType = (org.eclipse.ocl.pivot.@Nullable Class)CAUGHT_getType;
				qvtrParameter.setType(THROWN_getType);
				objectManager.assigned(qvtrParameter, PivotPackage.Literals.TYPED_ELEMENT__TYPE, THROWN_getType, false);
				jm_TmapVariable.appendElement(where_mapVariable);
				final /*@NonInvalid*/ boolean mmapHelper__Context__qvtr__loop__ = ValueUtil.TRUE_VALUE;
				IF_IsEQ_ = mmapHelper__Context__qvtr__loop__;
			}
			else {
				IF_IsEQ_ = ValueUtil.FALSE_VALUE;
			}
			trace.setS0global(IF_IsEQ_);
			objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_CONTEXT__S0GLOBAL, IF_IsEQ_, false);
			return IF_IsEQ_;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(jm_TmapVariable, thoseValues[0])
					&& idResolver.oclEquals(trace, thoseValues[1]);
		}
	}

	/**
	 *
	 * strict map:5 mmapHelper__Operation__qvtr__loop__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Operation[1] success s0global;
	 * append jm_TmapHelper__Context  : trace_ATL2QVTr::TmapHelper_Context[1];
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapHelper_Operation;
	 * var atlHelper : ATL::Helper[1] := dispatcher.d3atlHelper;
	 * check trace.s0local;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * speculate when_mapOclExpression.s0global;
	 * var operationName : String[1] := trace.t1operationName;
	 * var atlType : OCL::OclType[1] := trace.t3atlType;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := trace.t4qvtrTransformation;
	 * var getType1 : Class[1] := this.getType(atlType);
	 * new:qvtr qvtrFunction : qvtbase::Function[1];
	 * new:middle where_mapHelper_Context : trace_ATL2QVTr::TmapHelper_Context[1] {trace_ATL2QVTr::TmapHelper_Context::t3atlHelper : ATL::Helper[1] = atlHelper, trace_ATL2QVTr::TmapHelper_Context::t4qvtrFunction : qvtbase::Function[1] = qvtrFunction}
	 * set qvtrFunction.name := operationName;
	 * notify set dispatcher.s0global := true;
	 * set dispatcher.d4qvtrFunction := qvtrFunction;
	 * set trace.wmapHelper_Context := where_mapHelper_Context;
	 * set qvtrFunction.owningClass := qvtrTransformation;
	 * set qvtrFunction.type := getType1;
	 * add jm_TmapHelper__Context += where_mapHelper_Context;
	 *
	 */
	protected class MAP_mmapHelper__Operation__qvtr__loop__ extends AbstractInvocation
	{
		protected final @NonNull Connection jm_TmapHelper__Context;
		protected final /*@NonInvalid*/ @NonNull TmapHelper_Operation trace;

		public MAP_mmapHelper__Operation__qvtr__loop__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			jm_TmapHelper__Context = (Connection)boundValues[0];
			trace = (@NonNull TmapHelper_Operation)boundValues[1];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapHelper dispatcher = trace.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapHelper_Operation domapHelper_Operation = dispatcher.getDomapHelper_Operation();
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapHelper_Operation);
			/*@Thrown*/ boolean IF_IsEQ_;
			if (IsEQ_) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Helper d3atlHelper = dispatcher.getD3atlHelper();
				final /*@NonInvalid*/ @Nullable Boolean s0local = trace.getS0local();
				if (s0local == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0local;
				if (s0local) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace.getWmapOclExpression();
					SlotState.@NonNull Speculating outputSpeculatingSlotState = objectManager.getSpeculatingSlotState(trace, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__S0GLOBAL);
					Boolean outputSpeculatingSlotStatus = outputSpeculatingSlotState.getSpeculationStatus();
					if (outputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
						if (outputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
							trace.setS0global(ValueUtil.FALSE_VALUE);
							return ValueUtil.FALSE_VALUE;
						}
						SlotState.@NonNull Speculating inputSpeculatingSlotState;
						Boolean inputSpeculatingSlotStatus;
						boolean needsSpeculation = false;
						if (wmapOclExpression == null) {
							throw new InvalidEvaluationException("Null wmapOclExpression speculation source");
						}
						inputSpeculatingSlotState = objectManager.getSpeculatingSlotState(wmapOclExpression, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL);
						inputSpeculatingSlotStatus = inputSpeculatingSlotState.getSpeculationStatus();
						if (inputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
							if (inputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
								wmapOclExpression.setS0global(ValueUtil.FALSE_VALUE);
								return ValueUtil.FALSE_VALUE;
							}
							if (outputSpeculatingSlotState != inputSpeculatingSlotState) {
								outputSpeculatingSlotState.addInput(inputSpeculatingSlotState);
								needsSpeculation = true;
							}
						}
						if (needsSpeculation) {
							throw new InvocationFailedException(outputSpeculatingSlotState, true);
						}
					}
					boolean SPEC_ = true;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String t1operationName = trace.getT1operationName();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclType t3atlType = trace.getT3atlType();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull RelationalTransformation t4qvtrTransformation = trace.getT4qvtrTransformation();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class getType_0 = INSTANCE_CACHE_ATL2QVTr_getType.evaluate(rootThis, t3atlType);
					// creations
					final @NonNull Function qvtrFunction = QVTbaseFactory.eINSTANCE.createFunction();
					MODEL_qvtr.add(qvtrFunction, false);
					if (debugCreations) {
						AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrFunction));
					}
					final @SuppressWarnings("null")@NonNull TmapHelper_Context where_mapHelper_Context = INSTANCE_RULE_CACHE_TmapHelper_Context.evaluate(d3atlHelper, qvtrFunction);
					if (debugCreations) {
						AbstractTransformer.CREATIONS.println("created " + toDebugString(where_mapHelper_Context));
					}
					// mapping statements
					qvtrFunction.setName(t1operationName);
					dispatcher.setS0global(ValueUtil.TRUE_VALUE);
					objectManager.assigned(dispatcher, trace_ATL2QVTrPackage.Literals.DMAP_HELPER__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
					dispatcher.setD4qvtrFunction(qvtrFunction);
					trace.setWmapHelper_Context(where_mapHelper_Context);
					qvtrFunction.setOwningClass(t4qvtrTransformation);
					qvtrFunction.setType(getType_0);
					jm_TmapHelper__Context.appendElement(where_mapHelper_Context);
					final /*@NonInvalid*/ boolean mmapHelper__Operation__qvtr__loop__ = ValueUtil.TRUE_VALUE;
					IF_s0local = SPEC_;
				}
				else {
					IF_s0local = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ_ = IF_s0local;
			}
			else {
				IF_IsEQ_ = ValueUtil.FALSE_VALUE;
			}
			trace.setS0global(IF_IsEQ_);
			objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__S0GLOBAL, IF_IsEQ_, false);
			return IF_IsEQ_;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(jm_TmapHelper__Context, thoseValues[0])
					&& idResolver.oclEquals(trace, thoseValues[1]);
		}
	}

	/**
	 *
	 * map:5 mmapHelper__verdict__qvtr in ATL2QVTr {
	 * guard:middle mapHelper : trace_ATL2QVTr::DmapHelper[1];
	 * var mapHelper_Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1] := mapHelper.domapHelper_Attribute;
	 * observe trace_ATL2QVTr::ImapHelper::s0global check mapHelper_Attribute.s0global = false;
	 * var mapHelper_Operation : trace_ATL2QVTr::TmapHelper_Operation[1] := mapHelper.domapHelper_Operation;
	 * observe trace_ATL2QVTr::ImapHelper::s0global check mapHelper_Operation.s0global = false;
	 * notify set mapHelper.s0global := false;
	 *
	 */
	protected class MAP_mmapHelper__verdict__qvtr extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull DmapHelper mapHelper;

		public MAP_mmapHelper__verdict__qvtr(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			mapHelper = (@NonNull DmapHelper)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
			final /*@NonInvalid*/ @Nullable TmapHelper_Attribute domapHelper_Attribute = mapHelper.getDomapHelper_Attribute();
			final /*@NonInvalid*/ Boolean IsEQ_ = domapHelper_Attribute != null;
			/*@Thrown*/ Boolean IF_IsEQ_;
			if (IsEQ_) {
				if (domapHelper_Attribute == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				objectManager.getting(domapHelper_Attribute, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__S0GLOBAL, false);
				final /*@Thrown*/ @Nullable Boolean s0global = domapHelper_Attribute.getS0global();
				final /*@Thrown*/ boolean IsEQ__0 = s0global == Boolean.FALSE;
				/*@Thrown*/ boolean IF_IsEQ__0;
				if (IsEQ__0) {
					final /*@NonInvalid*/ @Nullable TmapHelper_Operation domapHelper_Operation = mapHelper.getDomapHelper_Operation();
					final /*@NonInvalid*/ Boolean IsEQ__1 = domapHelper_Operation != null;
					/*@Thrown*/ Boolean IF_IsEQ__1;
					if (IsEQ__1) {
						if (domapHelper_Operation == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						objectManager.getting(domapHelper_Operation, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__S0GLOBAL, false);
						final /*@Thrown*/ @Nullable Boolean s0global_0 = domapHelper_Operation.getS0global();
						final /*@Thrown*/ boolean IsEQ__2 = s0global_0 == Boolean.FALSE;
						/*@Thrown*/ boolean IF_IsEQ__2;
						if (IsEQ__2) {
							// mapping statements
							mapHelper.setS0global(ValueUtil.FALSE_VALUE);
							objectManager.assigned(mapHelper, trace_ATL2QVTrPackage.Literals.DMAP_HELPER__S0GLOBAL, ValueUtil.FALSE_VALUE, false);
							final /*@NonInvalid*/ boolean mmapHelper__verdict__qvtr = ValueUtil.TRUE_VALUE;
							IF_IsEQ__2 = mmapHelper__verdict__qvtr;
						}
						else {
							IF_IsEQ__2 = ValueUtil.FALSE_VALUE;
						}
						IF_IsEQ__1 = IF_IsEQ__2;
					}
					else {
						IF_IsEQ__1 = ValueUtil.FALSE_VALUE;
					}
					IF_IsEQ__0 = IF_IsEQ__1;
				}
				else {
					IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ_ = IF_IsEQ__0;
			}
			else {
				IF_IsEQ_ = ValueUtil.FALSE_VALUE;
			}
			return IF_IsEQ_;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(mapHelper, thoseValues[0]);
		}
	}

	/**
	 *
	 * map:5 mmapIfExp__qvtr__loop__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapIfExp[1] success s0global;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapIfExp;
	 * check trace.s0local;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var when_mapOclExpression1 : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression2;
	 * var when_mapOclExpression2 : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression1;
	 * new:qvtr qvtrExpression : IfExp[1];
	 * notify set dispatcher.s0global := true;
	 * set dispatcher.d4qvtrExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_mmapIfExp__qvtr__loop__(final /*@NonInvalid*/ @NonNull TmapIfExp trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapIfExp__qvtr__loop__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapIfExp domapIfExp = dispatcher.getDomapIfExp();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapIfExp);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			final /*@NonInvalid*/ @Nullable Boolean s0local = trace.getS0local();
			if (s0local == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ boolean IF_s0local;
			if (s0local) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace.getWmapOclExpression();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression2 = trace.getWmapOclExpression2();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression1 = trace.getWmapOclExpression1();
				// creations
				final org.eclipse.ocl.pivot.@NonNull IfExp qvtrExpression = PivotFactory.eINSTANCE.createIfExp();
				MODEL_qvtr.add(qvtrExpression, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
				}
				// mapping statements
				dispatcher.setS0global(ValueUtil.TRUE_VALUE);
				objectManager.assigned(dispatcher, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
				dispatcher.setD4qvtrExpression(qvtrExpression);
				final /*@NonInvalid*/ boolean mmapIfExp__qvtr__loop__ = ValueUtil.TRUE_VALUE;
				IF_s0local = mmapIfExp__qvtr__loop__;
			}
			else {
				IF_s0local = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_s0local;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0global(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapIfExp__qvtr__loop__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:5 mmapModule__qvtr__rest__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapModule[1];
	 * check trace.s0global;
	 * var _3 : Package[1] := trace.t4_3;
	 * var _5 : Parameter[1] := trace.t4_5;
	 * var _6 : qvtbase::TypedModel[1] := trace.t4_6;
	 * set _3.name := '';
	 * set _5.isRequired := true;
	 * notify set _5.name := 'this';
	 * set _6.isTrace := true;
	 * set _6.name := 'middle';
	 *
	 */
	protected boolean MAP_mmapModule__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapModule trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapModule__qvtr__rest__" +
					"\n\t\"trace\":" + toDebugString(trace));
		}
		final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
		if (s0global == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ boolean IF_s0global;
		if (s0global) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Package t4_3 = trace.getT4_3();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Parameter t4_5 = trace.getT4_5();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull TypedModel t4_6 = trace.getT4_6();
			// mapping statements
			t4_3.setName(STR_);
			t4_5.setIsRequired(ValueUtil.TRUE_VALUE);
			t4_5.setName(STR_this);
			objectManager.assigned(t4_5, PivotPackage.Literals.NAMED_ELEMENT__NAME, STR_this, false);
			t4_6.setIsTrace(ValueUtil.TRUE_VALUE);
			t4_6.setName(STR_middle);
			final /*@NonInvalid*/ boolean mmapModule__qvtr__rest__ = ValueUtil.TRUE_VALUE;
			IF_s0global = mmapModule__qvtr__rest__;
		}
		else {
			IF_s0global = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_s0global ? "done "  : "fail ") + "MAP_mmapModule__qvtr__rest__");
		}
		return IF_s0global;
	}

	/**
	 *
	 * map:5 mmapNavigationOrAttributeCallExp__Helper__qvtr__ini in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1] success s0local;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapNavigationOrAttributeCallExp_Helper;
	 * check var atlExpression : OCL::NavigationOrAttributeCallExp[1] := dispatcher.d3atlExpression;
	 * var atlModule : ATL::Module[1] := this.getModule(atlExpression)
	 *   ;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * check when_mapModule.s0global;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t4qvtrTransformation;
	 * var ownedContext : Parameter[?] := qvtrTransformation.ownedContext;
	 * observe ocl::NamedElement::name var name : String[?] := ownedContext?.name;
	 * observe ocl::TypedElement::type var type : Type[?] := ownedContext?.type;
	 * var elements : OrderedSet(ATL::ModuleElement) := atlModule.elements;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var collect : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(i | i.definition)
	 *   ;
	 * var collect1 : Sequence(OCL::OclFeature) := collect->collect(i | i.feature)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Attribute) := collect1->selectByKind(OCL::Attribute)
	 *   ;
	 * var atlAttributes : Sequence(OCL::Attribute) := selectByKind1->select(i | i.name = atlExpression.name)
	 *   ;
	 * var notEmpty : Boolean[1] := atlAttributes->notEmpty()
	 *   ;
	 * check notEmpty;
	 * var propertyName : String[1] := atlExpression.name;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlSource.DmapOclExpression;
	 * var any : OCL::Attribute[1] := atlAttributes->any(i | true);
	 * var definition : OCL::OclFeatureDefinition[?] := any.definition;
	 * var Helper1 : ATL::Helper[?] := definition?.Helper;
	 * var equals : Boolean[1] := definition =
	 *   null;
	 * var _'if' : ATL::Helper[1] := if equals
	 *   then null
	 *   else Helper1
	 *   endif;
	 * var when_mapHelper_Attribute : trace_ATL2QVTr::DmapHelper[1] := _'if'.DmapHelper;
	 * notify set trace.t1propertyName := propertyName;
	 * set trace.t3atlAttributes := atlAttributes;
	 * notify set dispatcher.result := trace;
	 * set trace.t3atlModule := atlModule;
	 * set trace.t3atlSource := atlSource;
	 * notify set trace.t4qvtrThisVariable := ownedContext;
	 * set trace.t4qvtrTransformation := qvtrTransformation;
	 * notify set trace.wmapHelper := when_mapHelper_Attribute;
	 * set trace.wmapModule := when_mapModule;
	 * notify set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected class MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__ini extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace;

		public MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__ini(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace = (@NonNull TmapNavigationOrAttributeCallExp_Helper)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Helper domapNavigationOrAttributeCallExp_Helper = dispatcher.getDomapNavigationOrAttributeCallExp_Helper();
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapNavigationOrAttributeCallExp_Helper);
			/*@Thrown*/ boolean IF_IsEQ_;
			if (IsEQ_) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression d3atlExpression = dispatcher.getD3atlExpression();
				final /*@NonInvalid*/ boolean IsKINDOF_ = d3atlExpression instanceof NavigationOrAttributeCallExp;
				/*@Thrown*/ boolean IF_IsKINDOF_;
				if (IsKINDOF_) {
					final /*@NonInvalid*/ @Nullable NavigationOrAttributeCallExp CAST_d3atlExpression = (NavigationOrAttributeCallExp)d3atlExpression;
					final /*@NonInvalid*/ @NonNull Module getModule_0 = INSTANCE_CACHE_ATL2QVTr_getModule.evaluate(rootThis, CAST_d3atlExpression);
					final /*@NonInvalid*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t3atlModule.get(getModule_0);
					final /*@NonInvalid*/ Boolean IsEQ__0 = TmapModule != null;
					/*@Thrown*/ Boolean IF_IsEQ__0;
					if (IsEQ__0) {
						if (TmapModule == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean s0global = TmapModule.getS0global();
						if (s0global == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ boolean IF_s0global;
						if (s0global) {
							/*@Caught*/ @Nullable Object CAUGHT_t4qvtrTransformation;
							try {
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull RelationalTransformation t4qvtrTransformation = TmapModule.getT4qvtrTransformation();
								CAUGHT_t4qvtrTransformation = t4qvtrTransformation;
							}
							catch (Exception THROWN_CAUGHT_t4qvtrTransformation) {
								CAUGHT_t4qvtrTransformation = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrTransformation);
							}
							/*@Caught*/ @Nullable Object CAUGHT_ownedContext;
							try {
								if (CAUGHT_t4qvtrTransformation instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_t4qvtrTransformation;
								}
								final /*@Thrown*/ @Nullable RelationalTransformation THROWN_t4qvtrTransformation = (@Nullable RelationalTransformation)CAUGHT_t4qvtrTransformation;
								final /*@Thrown*/ @Nullable Parameter ownedContext = THROWN_t4qvtrTransformation.getOwnedContext();
								CAUGHT_ownedContext = ownedContext;
							}
							catch (Exception THROWN_CAUGHT_ownedContext) {
								CAUGHT_ownedContext = ValueUtil.createInvalidValue(THROWN_CAUGHT_ownedContext);
							}
							if (CAUGHT_ownedContext instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_ownedContext;
							}
							final /*@Thrown*/ @Nullable Parameter THROWN_ownedContext = (@Nullable Parameter)CAUGHT_ownedContext;
							final /*@NonInvalid*/ Boolean IsEQ2_ = THROWN_ownedContext == null;
							/*@Caught*/ @Nullable Object IF_IsEQ2_;
							if (IsEQ2_) {
								IF_IsEQ2_ = null;
							}
							else {
								/*@Caught*/ @Nullable Object CAUGHT_name;
								try {
									assert THROWN_ownedContext != null;
									objectManager.getting(THROWN_ownedContext, PivotPackage.Literals.NAMED_ELEMENT__NAME, false);
									final /*@Thrown*/ @Nullable String name = THROWN_ownedContext.getName();
									CAUGHT_name = name;
								}
								catch (Exception THROWN_CAUGHT_name) {
									CAUGHT_name = ValueUtil.createInvalidValue(THROWN_CAUGHT_name);
								}
								IF_IsEQ2_ = CAUGHT_name;
							}
							final /*@NonInvalid*/ Boolean IsEQ2__0 = THROWN_ownedContext == null;
							/*@Caught*/ @Nullable Object IF_IsEQ2__0;
							if (IsEQ2__0) {
								IF_IsEQ2__0 = null;
							}
							else {
								/*@Caught*/ @Nullable Object CAUGHT_type;
								try {
									assert THROWN_ownedContext != null;
									objectManager.getting(THROWN_ownedContext, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
									final /*@Thrown*/ @Nullable Type type = THROWN_ownedContext.getType();
									CAUGHT_type = type;
								}
								catch (Exception THROWN_CAUGHT_type) {
									CAUGHT_type = ValueUtil.createInvalidValue(THROWN_CAUGHT_type);
								}
								IF_IsEQ2__0 = CAUGHT_type;
							}
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull List<ModuleElement> elements = getModule_0.getElements();
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ATL_c_c_Helper = idResolver.getClass(CLSSid_Helper, null);
							final /*@NonInvalid*/ @Nullable OrderedSetValue BOXED_elements = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleElement, elements);
							final /*@NonInvalid*/ @NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(rootExecutor, BOXED_elements, TYP_ATL_c_c_Helper);
							/*@NonInvalid*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeatureDefinition);
							@NonNull Iterator<Object> ITER_i = selectByKind.iterator();
							/*@NonInvalid*/ @NonNull SequenceValue collect;
							while (true) {
								if (!ITER_i.hasNext()) {
									collect = accumulator;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ @NonNull Helper i = (@NonNull Helper)ITER_i.next();
								/**
								 * i.definition
								 */
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition_0 = i.getDefinition();
								//
								accumulator.add(definition_0);
							}
							/*@NonInvalid*/ SequenceValue.@NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeature);
							@NonNull Iterator<Object> ITER_i_0 = collect.iterator();
							/*@NonInvalid*/ @NonNull SequenceValue collect_0;
							while (true) {
								if (!ITER_i_0.hasNext()) {
									collect_0 = accumulator_0;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ @NonNull OclFeatureDefinition i_0 = (@NonNull OclFeatureDefinition)ITER_i_0.next();
								/**
								 * i.feature
								 */
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull OclFeature feature = i_0.getFeature();
								//
								accumulator_0.add(feature);
							}
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_Attribute = idResolver.getClass(CLSSid_Attribute, null);
							final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(rootExecutor, collect_0, TYP_OCL_c_c_Attribute);
							/*@NonInvalid*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Attribute);
							@NonNull Iterator<Object> ITER_i_1 = selectByKind_0.iterator();
							/*@NonInvalid*/ @NonNull SequenceValue select;
							while (true) {
								if (!ITER_i_1.hasNext()) {
									select = accumulator_1;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ @NonNull Attribute i_1 = (@NonNull Attribute)ITER_i_1.next();
								/**
								 * i.name = atlExpression.name
								 */
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull String name_1 = i_1.getName();
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull String name_2 = CAST_d3atlExpression.getName();
								final /*@NonInvalid*/ boolean IsEQ__5 = idResolver.oclEquals(name_1, name_2);
								//
								if (IsEQ__5) {
									accumulator_1.add(i_1);
								}
							}
							final /*@NonInvalid*/ boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(select).booleanValue();
							/*@Thrown*/ boolean IF_IF_notEmpty;
							if (notEmpty) {
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull String name_0 = CAST_d3atlExpression.getName();
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull OclExpression source = CAST_d3atlExpression.getSource();
								final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(source);
								final /*@NonInvalid*/ Boolean IsEQ__1 = DmapOclExpression != null;
								/*@Thrown*/ Boolean IF_IsEQ__1;
								if (IsEQ__1) {
									if (DmapOclExpression == null) {
										throw new InvalidEvaluationException("Null where non-null value required");
									}
									@NonNull Iterator<Object> ITER_i_2 = select.iterator();
									/*@NonInvalid*/ @NonNull Attribute any_0;
									while (true) {
										if (!ITER_i_2.hasNext()) {
											throw new InvalidValueException("Nothing to return for ''any''");
										}
										@SuppressWarnings("null")
										/*@NonInvalid*/ @NonNull Attribute i_2 = (@NonNull Attribute)ITER_i_2.next();
										/**
										 * true
										 */
										//
										if (ValueUtil.TRUE_VALUE) {			// Carry on till something found
											any_0 = i_2;
											break;
										}
									}
									final /*@NonInvalid*/ @Nullable OclFeatureDefinition definition = any_0.getDefinition();
									final /*@NonInvalid*/ Boolean IsEQ2__1 = definition == null;
									/*@Caught*/ @Nullable Object IF_IsEQ2__1;
									if (IsEQ2__1) {
										IF_IsEQ2__1 = null;
									}
									else {
										/*@Caught*/ @Nullable Object CAUGHT_Helper;
										try {
											// ExecutorCompositionPropertyCallingConvention
											final /*@NonInvalid*/ @Nullable UnboxedCompositionProperty IMPPROPid_definition = new UnboxedCompositionProperty(PROPid_definition);
											assert definition != null;
											final /*@Thrown*/ @Nullable Helper Helper = (@Nullable Helper)IMPPROPid_definition.evaluate(rootExecutor, CLSSid_Helper, definition);
											CAUGHT_Helper = Helper;
										}
										catch (Exception THROWN_CAUGHT_Helper) {
											CAUGHT_Helper = ValueUtil.createInvalidValue(THROWN_CAUGHT_Helper);
										}
										IF_IsEQ2__1 = CAUGHT_Helper;
									}
									final /*@NonInvalid*/ boolean IsEQ__2 = definition == null;
									/*@Caught*/ @Nullable Object IF_IF_IsEQ_;
									if (IsEQ__2 == Boolean.TRUE) {
										IF_IF_IsEQ_ = null;
									}
									else {
										IF_IF_IsEQ_ = IF_IsEQ2__1;
									}
									if (IF_IF_IsEQ_ instanceof InvalidValueException) {
										throw (InvalidValueException)IF_IF_IsEQ_;
									}
									final /*@Thrown*/ @Nullable Helper THROWN_IF_IF_IsEQ_ = (@Nullable Helper)IF_IF_IsEQ_;
									final /*@Thrown*/ Boolean IsEQ__3 = THROWN_IF_IF_IsEQ_ != null;
									/*@Thrown*/ Boolean IF_IsEQ__2;
									if (IsEQ__3) {
										/*@Caught*/ @Nullable Object CAUGHT_IF_IF_IsEQ_;
										try {
											if (THROWN_IF_IF_IsEQ_ == null) {
												throw new InvalidEvaluationException("Null where non-null value required");
											}
											CAUGHT_IF_IF_IsEQ_ = THROWN_IF_IF_IsEQ_;
										}
										catch (Exception THROWN_CAUGHT_IF_IF_IsEQ_) {
											CAUGHT_IF_IF_IsEQ_ = ValueUtil.createInvalidValue(THROWN_CAUGHT_IF_IF_IsEQ_);
										}
										/*@Caught*/ @Nullable Object CAUGHT_DmapHelper;
										try {
											if (CAUGHT_IF_IF_IsEQ_ instanceof InvalidValueException) {
												throw (InvalidValueException)CAUGHT_IF_IF_IsEQ_;
											}
											final /*@Thrown*/ @Nullable Helper THROWN_IF_IF_IsEQ__0 = (@Nullable Helper)CAUGHT_IF_IF_IsEQ_;
											final /*@Thrown*/ @Nullable DmapHelper DmapHelper = OPPOSITE_OF_DmapHelper_d3atlHelper.get(THROWN_IF_IF_IsEQ__0);
											CAUGHT_DmapHelper = DmapHelper;
										}
										catch (Exception THROWN_CAUGHT_DmapHelper) {
											CAUGHT_DmapHelper = ValueUtil.createInvalidValue(THROWN_CAUGHT_DmapHelper);
										}
										if (CAUGHT_DmapHelper instanceof InvalidValueException) {
											throw (InvalidValueException)CAUGHT_DmapHelper;
										}
										final /*@Thrown*/ @Nullable DmapHelper THROWN_DmapHelper = (@Nullable DmapHelper)CAUGHT_DmapHelper;
										final /*@Thrown*/ Boolean IsEQ__4 = THROWN_DmapHelper != null;
										/*@Thrown*/ Boolean IF_IsEQ__3;
										if (IsEQ__4) {
											/*@Caught*/ @Nullable Object CAUGHT_DmapHelper_0;
											try {
												if (THROWN_DmapHelper == null) {
													throw new InvalidEvaluationException("Null where non-null value required");
												}
												CAUGHT_DmapHelper_0 = THROWN_DmapHelper;
											}
											catch (Exception THROWN_CAUGHT_DmapHelper_0) {
												CAUGHT_DmapHelper_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_DmapHelper_0);
											}
											// mapping statements
											trace.setT1propertyName(name_0);
											objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T1PROPERTY_NAME, name_0, false);
											final /*@NonInvalid*/ @Nullable List<Attribute> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Attribute.class, select);
											trace.getT3atlAttributes().addAll(ECORE_select);
											dispatcher.setResult(trace);
											objectManager.assigned(dispatcher, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__RESULT, trace, false);
											trace.setT3atlModule(getModule_0);
											trace.setT3atlSource(source);
											if (CAUGHT_ownedContext instanceof InvalidValueException) {
												throw (InvalidValueException)CAUGHT_ownedContext;
											}
											final /*@Thrown*/ @Nullable Parameter THROWN_ownedContext_0 = (@Nullable Parameter)CAUGHT_ownedContext;
											if (THROWN_ownedContext_0 == null) {
												throw new InvalidEvaluationException("Null value for t4qvtrThisVariable assignment");
											}
											trace.setT4qvtrThisVariable(THROWN_ownedContext_0);
											objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T4QVTR_THIS_VARIABLE, THROWN_ownedContext_0, false);
											if (CAUGHT_t4qvtrTransformation instanceof InvalidValueException) {
												throw (InvalidValueException)CAUGHT_t4qvtrTransformation;
											}
											final /*@Thrown*/ @Nullable RelationalTransformation THROWN_t4qvtrTransformation_0 = (@Nullable RelationalTransformation)CAUGHT_t4qvtrTransformation;
											trace.setT4qvtrTransformation(THROWN_t4qvtrTransformation_0);
											if (CAUGHT_DmapHelper_0 instanceof InvalidValueException) {
												throw (InvalidValueException)CAUGHT_DmapHelper_0;
											}
											final /*@Thrown*/ @Nullable DmapHelper THROWN_DmapHelper_0 = (@Nullable DmapHelper)CAUGHT_DmapHelper_0;
											trace.setWmapHelper(THROWN_DmapHelper_0);
											objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__WMAP_HELPER, THROWN_DmapHelper_0, false);
											trace.setWmapModule(TmapModule);
											trace.setWmapOclExpression(DmapOclExpression);
											objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION, DmapOclExpression, false);
											final /*@NonInvalid*/ boolean mmapNavigationOrAttributeCallExp__Helper__qvtr__ini = ValueUtil.TRUE_VALUE;
											IF_IsEQ__3 = mmapNavigationOrAttributeCallExp__Helper__qvtr__ini;
										}
										else {
											IF_IsEQ__3 = ValueUtil.FALSE_VALUE;
										}
										IF_IsEQ__2 = IF_IsEQ__3;
									}
									else {
										IF_IsEQ__2 = ValueUtil.FALSE_VALUE;
									}
									IF_IsEQ__1 = IF_IsEQ__2;
								}
								else {
									IF_IsEQ__1 = ValueUtil.FALSE_VALUE;
								}
								IF_IF_notEmpty = IF_IsEQ__1;
							}
							else {
								IF_IF_notEmpty = ValueUtil.FALSE_VALUE;
							}
							IF_s0global = IF_IF_notEmpty;
						}
						else {
							IF_s0global = ValueUtil.FALSE_VALUE;
						}
						IF_IsEQ__0 = IF_s0global;
					}
					else {
						IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
					}
					IF_IsKINDOF_ = IF_IsEQ__0;
				}
				else {
					IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ_ = IF_IsKINDOF_;
			}
			else {
				IF_IsEQ_ = ValueUtil.FALSE_VALUE;
			}
			trace.setS0local(IF_IsEQ_);
			objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__S0LOCAL, IF_IsEQ_, false);
			return IF_IsEQ_;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:5 mmapNavigationOrAttributeCallExp__Helper__qvtr__loo in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1] success s0global;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapNavigationOrAttributeCallExp_Helper;
	 * observe trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper::s0local check trace.s0local;
	 * check var ownedContext : Parameter[1] := trace.t4qvtrThisVariable;
	 * observe ocl::NamedElement::name var name : String[?] := ownedContext.name;
	 * observe ocl::TypedElement::type var type : Type[?] := ownedContext.type;
	 * var when_mapHelper_Attribute : trace_ATL2QVTr::DmapHelper[1] := trace.wmapHelper;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * speculate when_mapHelper_Attribute.s0global, when_mapOclExpression.s0global;
	 * var propertyName : String[1] := trace.t1propertyName;
	 * new:qvtr qvtrExpression : OperationCallExp[1];
	 * new:qvtr qvtrSource : VariableExp[1];
	 * set qvtrExpression.name := propertyName;
	 * set qvtrSource.name := name;
	 * notify set dispatcher.s0global := true;
	 * set dispatcher.d4qvtrExpression := qvtrExpression;
	 * set trace.t4qvtrSource := qvtrSource;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 * set qvtrSource.referredVariable := ownedContext;
	 * notify set qvtrSource.type := type;
	 *
	 */
	protected class MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__loo extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace;

		public MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__loo(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace = (@NonNull TmapNavigationOrAttributeCallExp_Helper)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Helper domapNavigationOrAttributeCallExp_Helper = dispatcher.getDomapNavigationOrAttributeCallExp_Helper();
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapNavigationOrAttributeCallExp_Helper);
			/*@Thrown*/ boolean IF_IsEQ_;
			if (IsEQ_) {
				objectManager.getting(trace, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__S0LOCAL, false);
				final /*@NonInvalid*/ @Nullable Boolean s0local = trace.getS0local();
				if (s0local == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0local;
				if (s0local) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull VariableDeclaration t4qvtrThisVariable = trace.getT4qvtrThisVariable();
					final /*@NonInvalid*/ boolean IsKINDOF_ = t4qvtrThisVariable instanceof Parameter;
					/*@NonInvalid*/ boolean IF_IsKINDOF_;
					if (IsKINDOF_) {
						final /*@NonInvalid*/ @Nullable Parameter CAST_t4qvtrThisVariable = (Parameter)t4qvtrThisVariable;
						objectManager.getting(CAST_t4qvtrThisVariable, PivotPackage.Literals.NAMED_ELEMENT__NAME, false);
						final /*@NonInvalid*/ @Nullable String name = CAST_t4qvtrThisVariable.getName();
						objectManager.getting(CAST_t4qvtrThisVariable, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@NonInvalid*/ @Nullable Type type = CAST_t4qvtrThisVariable.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull DmapHelper wmapHelper = trace.getWmapHelper();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace.getWmapOclExpression();
						SlotState.@NonNull Speculating outputSpeculatingSlotState = objectManager.getSpeculatingSlotState(trace, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL);
						Boolean outputSpeculatingSlotStatus = outputSpeculatingSlotState.getSpeculationStatus();
						if (outputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
							if (outputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
								trace.setS0global(ValueUtil.FALSE_VALUE);
								return ValueUtil.FALSE_VALUE;
							}
							SlotState.@NonNull Speculating inputSpeculatingSlotState;
							Boolean inputSpeculatingSlotStatus;
							boolean needsSpeculation = false;
							if (wmapHelper == null) {
								throw new InvalidEvaluationException("Null wmapHelper speculation source");
							}
							inputSpeculatingSlotState = objectManager.getSpeculatingSlotState(wmapHelper, trace_ATL2QVTrPackage.Literals.DMAP_HELPER__S0GLOBAL);
							inputSpeculatingSlotStatus = inputSpeculatingSlotState.getSpeculationStatus();
							if (inputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
								if (inputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
									wmapHelper.setS0global(ValueUtil.FALSE_VALUE);
									return ValueUtil.FALSE_VALUE;
								}
								if (outputSpeculatingSlotState != inputSpeculatingSlotState) {
									outputSpeculatingSlotState.addInput(inputSpeculatingSlotState);
									needsSpeculation = true;
								}
							}
							if (wmapOclExpression == null) {
								throw new InvalidEvaluationException("Null wmapOclExpression speculation source");
							}
							inputSpeculatingSlotState = objectManager.getSpeculatingSlotState(wmapOclExpression, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL);
							inputSpeculatingSlotStatus = inputSpeculatingSlotState.getSpeculationStatus();
							if (inputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
								if (inputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
									wmapOclExpression.setS0global(ValueUtil.FALSE_VALUE);
									return ValueUtil.FALSE_VALUE;
								}
								if (outputSpeculatingSlotState != inputSpeculatingSlotState) {
									outputSpeculatingSlotState.addInput(inputSpeculatingSlotState);
									needsSpeculation = true;
								}
							}
							if (needsSpeculation) {
								throw new InvocationFailedException(outputSpeculatingSlotState, true);
							}
						}
						boolean SPEC_ = true;
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t1propertyName = trace.getT1propertyName();
						// creations
						final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
						MODEL_qvtr.add(qvtrExpression, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
						}
						final org.eclipse.ocl.pivot.@NonNull VariableExp qvtrSource = PivotFactory.eINSTANCE.createVariableExp();
						MODEL_qvtr.add(qvtrSource, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrSource));
						}
						// mapping statements
						qvtrExpression.setName(t1propertyName);
						qvtrSource.setName(name);
						dispatcher.setS0global(ValueUtil.TRUE_VALUE);
						objectManager.assigned(dispatcher, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
						dispatcher.setD4qvtrExpression(qvtrExpression);
						trace.setT4qvtrSource(qvtrSource);
						qvtrExpression.setOwnedSource(qvtrSource);
						qvtrSource.setReferredVariable(CAST_t4qvtrThisVariable);
						qvtrSource.setType(type);
						objectManager.assigned(qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type, false);
						final /*@NonInvalid*/ boolean mmapNavigationOrAttributeCallExp__Helper__qvtr__loo = ValueUtil.TRUE_VALUE;
						IF_IsKINDOF_ = SPEC_;
					}
					else {
						IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
					}
					IF_s0local = IF_IsKINDOF_;
				}
				else {
					IF_s0local = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ_ = IF_s0local;
			}
			else {
				IF_IsEQ_ = ValueUtil.FALSE_VALUE;
			}
			trace.setS0global(IF_IsEQ_);
			objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_IsEQ_, false);
			return IF_IsEQ_;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:5 mmapNavigationOrAttributeCallExp__Property__qvtr__l in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1] success s0global;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapNavigationOrAttributeCallExp_Property;
	 * check trace.s0local;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * speculate when_mapOclExpression.s0global;
	 * var propertyName : String[1] := trace.t1propertyName;
	 * new:qvtr qvtrExpression : PropertyCallExp[1];
	 * set qvtrExpression.name := propertyName;
	 * notify set dispatcher.s0global := true;
	 * set dispatcher.d4qvtrExpression := qvtrExpression;
	 *
	 */
	protected class MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__l extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace;

		public MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__l(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace = (@NonNull TmapNavigationOrAttributeCallExp_Property)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Property domapNavigationOrAttributeCallExp_Property = dispatcher.getDomapNavigationOrAttributeCallExp_Property();
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapNavigationOrAttributeCallExp_Property);
			/*@Thrown*/ boolean IF_IsEQ_;
			if (IsEQ_) {
				final /*@NonInvalid*/ @Nullable Boolean s0local = trace.getS0local();
				if (s0local == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0local;
				if (s0local) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace.getWmapOclExpression();
					SlotState.@NonNull Speculating outputSpeculatingSlotState = objectManager.getSpeculatingSlotState(trace, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL);
					Boolean outputSpeculatingSlotStatus = outputSpeculatingSlotState.getSpeculationStatus();
					if (outputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
						if (outputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
							trace.setS0global(ValueUtil.FALSE_VALUE);
							return ValueUtil.FALSE_VALUE;
						}
						SlotState.@NonNull Speculating inputSpeculatingSlotState;
						Boolean inputSpeculatingSlotStatus;
						boolean needsSpeculation = false;
						if (wmapOclExpression == null) {
							throw new InvalidEvaluationException("Null wmapOclExpression speculation source");
						}
						inputSpeculatingSlotState = objectManager.getSpeculatingSlotState(wmapOclExpression, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL);
						inputSpeculatingSlotStatus = inputSpeculatingSlotState.getSpeculationStatus();
						if (inputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
							if (inputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
								wmapOclExpression.setS0global(ValueUtil.FALSE_VALUE);
								return ValueUtil.FALSE_VALUE;
							}
							if (outputSpeculatingSlotState != inputSpeculatingSlotState) {
								outputSpeculatingSlotState.addInput(inputSpeculatingSlotState);
								needsSpeculation = true;
							}
						}
						if (needsSpeculation) {
							throw new InvocationFailedException(outputSpeculatingSlotState, true);
						}
					}
					boolean SPEC_ = true;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String t1propertyName = trace.getT1propertyName();
					// creations
					final @NonNull PropertyCallExp qvtrExpression = PivotFactory.eINSTANCE.createPropertyCallExp();
					MODEL_qvtr.add(qvtrExpression, false);
					if (debugCreations) {
						AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
					}
					// mapping statements
					qvtrExpression.setName(t1propertyName);
					dispatcher.setS0global(ValueUtil.TRUE_VALUE);
					objectManager.assigned(dispatcher, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
					dispatcher.setD4qvtrExpression(qvtrExpression);
					final /*@NonInvalid*/ boolean mmapNavigationOrAttributeCallExp__Property__qvtr__l = ValueUtil.TRUE_VALUE;
					IF_s0local = SPEC_;
				}
				else {
					IF_s0local = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ_ = IF_s0local;
			}
			else {
				IF_IsEQ_ = ValueUtil.FALSE_VALUE;
			}
			trace.setS0global(IF_IsEQ_);
			objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_IsEQ_, false);
			return IF_IsEQ_;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace, thoseValues[0]);
		}
	}

	/**
	 *
	 * map:5 mmapOclExpression__verdict__qvtr in ATL2QVTr {
	 * guard:middle mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1];
	 * var mapIfExp : trace_ATL2QVTr::TmapIfExp[1] := mapOclExpression.domapIfExp;
	 * observe trace_ATL2QVTr::ImapOclExpression::s0global check mapIfExp.s0global = false;
	 * var mapStringExp : trace_ATL2QVTr::TmapStringExp[1] := mapOclExpression.domapStringExp;
	 * check mapStringExp.s0global = false;
	 * var mapIntegerExp : trace_ATL2QVTr::TmapIntegerExp[1] := mapOclExpression.domapIntegerExp;
	 * check mapIntegerExp.s0global = false;
	 * var mapOclType : trace_ATL2QVTr::TmapOclType[1] := mapOclExpression.domapOclType;
	 * check mapOclType.s0global = false;
	 * var mapVariableExp : trace_ATL2QVTr::TmapVariableExp[1] := mapOclExpression.domapVariableExp;
	 * check mapVariableExp.s0global = false;
	 * var mapOperationCallExp_Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1] := mapOclExpression.domapOperationCallExp_Operation;
	 * observe trace_ATL2QVTr::ImapOclExpression::s0global check mapOperationCallExp_Operation.s0global = false;
	 * var mapBooleanExp : trace_ATL2QVTr::TmapBooleanExp[1] := mapOclExpression.domapBooleanExp;
	 * check mapBooleanExp.s0global = false;
	 * var mapNavigationOrAttributeCallExp_Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1] := mapOclExpression.domapNavigationOrAttributeCallExp_Helper;
	 * observe trace_ATL2QVTr::ImapOclExpression::s0global check mapNavigationOrAttributeCallExp_Helper.s0global = false;
	 * var mapOperationCallExp_Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1] := mapOclExpression.domapOperationCallExp_Helper;
	 * observe trace_ATL2QVTr::ImapOclExpression::s0global check mapOperationCallExp_Helper.s0global = false;
	 * var mapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1] := mapOclExpression.domapOperatorCallExp;
	 * observe trace_ATL2QVTr::ImapOclExpression::s0global check mapOperatorCallExp.s0global = false;
	 * var mapNavigationOrAttributeCallExp_Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1] := mapOclExpression.domapNavigationOrAttributeCallExp_Property;
	 * observe trace_ATL2QVTr::ImapOclExpression::s0global check mapNavigationOrAttributeCallExp_Property.s0global = false;
	 * notify set mapOclExpression.s0global := false;
	 *
	 */
	protected class MAP_mmapOclExpression__verdict__qvtr extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull DmapOclExpression mapOclExpression;

		public MAP_mmapOclExpression__verdict__qvtr(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			mapOclExpression = (@NonNull DmapOclExpression)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
			final /*@NonInvalid*/ @Nullable TmapIfExp domapIfExp = mapOclExpression.getDomapIfExp();
			final /*@NonInvalid*/ Boolean IsEQ_ = domapIfExp != null;
			/*@Thrown*/ Boolean IF_IsEQ_;
			if (IsEQ_) {
				if (domapIfExp == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				objectManager.getting(domapIfExp, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, false);
				final /*@Thrown*/ @Nullable Boolean s0global = domapIfExp.getS0global();
				final /*@Thrown*/ boolean IsEQ__0 = s0global == Boolean.FALSE;
				/*@Thrown*/ boolean IF_IsEQ__0;
				if (IsEQ__0) {
					final /*@NonInvalid*/ @Nullable TmapStringExp domapStringExp = mapOclExpression.getDomapStringExp();
					final /*@NonInvalid*/ Boolean IsEQ__1 = domapStringExp != null;
					/*@Thrown*/ Boolean IF_IsEQ__1;
					if (IsEQ__1) {
						if (domapStringExp == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean s0global_0 = domapStringExp.getS0global();
						final /*@Thrown*/ boolean IsEQ__2 = s0global_0 == Boolean.FALSE;
						/*@Thrown*/ boolean IF_IsEQ__2;
						if (IsEQ__2) {
							final /*@NonInvalid*/ @Nullable TmapIntegerExp domapIntegerExp = mapOclExpression.getDomapIntegerExp();
							final /*@NonInvalid*/ Boolean IsEQ__3 = domapIntegerExp != null;
							/*@Thrown*/ Boolean IF_IsEQ__3;
							if (IsEQ__3) {
								if (domapIntegerExp == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								final /*@Thrown*/ @Nullable Boolean s0global_1 = domapIntegerExp.getS0global();
								final /*@Thrown*/ boolean IsEQ__4 = s0global_1 == Boolean.FALSE;
								/*@Thrown*/ boolean IF_IsEQ__4;
								if (IsEQ__4) {
									final /*@NonInvalid*/ @Nullable TmapOclType domapOclType = mapOclExpression.getDomapOclType();
									final /*@NonInvalid*/ Boolean IsEQ__5 = domapOclType != null;
									/*@Thrown*/ Boolean IF_IsEQ__5;
									if (IsEQ__5) {
										if (domapOclType == null) {
											throw new InvalidEvaluationException("Null where non-null value required");
										}
										final /*@Thrown*/ @Nullable Boolean s0global_2 = domapOclType.getS0global();
										final /*@Thrown*/ boolean IsEQ__6 = s0global_2 == Boolean.FALSE;
										/*@Thrown*/ boolean IF_IsEQ__6;
										if (IsEQ__6) {
											final /*@NonInvalid*/ @Nullable TmapVariableExp domapVariableExp = mapOclExpression.getDomapVariableExp();
											final /*@NonInvalid*/ Boolean IsEQ__7 = domapVariableExp != null;
											/*@Thrown*/ Boolean IF_IsEQ__7;
											if (IsEQ__7) {
												if (domapVariableExp == null) {
													throw new InvalidEvaluationException("Null where non-null value required");
												}
												final /*@Thrown*/ @Nullable Boolean s0global_3 = domapVariableExp.getS0global();
												final /*@Thrown*/ boolean IsEQ__8 = s0global_3 == Boolean.FALSE;
												/*@Thrown*/ boolean IF_IsEQ__8;
												if (IsEQ__8) {
													final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Operation domapOperationCallExp_Operation = mapOclExpression.getDomapOperationCallExp_Operation();
													final /*@NonInvalid*/ Boolean IsEQ__9 = domapOperationCallExp_Operation != null;
													/*@Thrown*/ Boolean IF_IsEQ__9;
													if (IsEQ__9) {
														if (domapOperationCallExp_Operation == null) {
															throw new InvalidEvaluationException("Null where non-null value required");
														}
														objectManager.getting(domapOperationCallExp_Operation, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, false);
														final /*@Thrown*/ @Nullable Boolean s0global_4 = domapOperationCallExp_Operation.getS0global();
														final /*@Thrown*/ boolean IsEQ__10 = s0global_4 == Boolean.FALSE;
														/*@Thrown*/ boolean IF_IsEQ__10;
														if (IsEQ__10) {
															final /*@NonInvalid*/ @Nullable TmapBooleanExp domapBooleanExp = mapOclExpression.getDomapBooleanExp();
															final /*@NonInvalid*/ Boolean IsEQ__11 = domapBooleanExp != null;
															/*@Thrown*/ Boolean IF_IsEQ__11;
															if (IsEQ__11) {
																if (domapBooleanExp == null) {
																	throw new InvalidEvaluationException("Null where non-null value required");
																}
																final /*@Thrown*/ @Nullable Boolean s0global_5 = domapBooleanExp.getS0global();
																final /*@Thrown*/ boolean IsEQ__12 = s0global_5 == Boolean.FALSE;
																/*@Thrown*/ boolean IF_IsEQ__12;
																if (IsEQ__12) {
																	final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Helper domapNavigationOrAttributeCallExp_Helper = mapOclExpression.getDomapNavigationOrAttributeCallExp_Helper();
																	final /*@NonInvalid*/ Boolean IsEQ__13 = domapNavigationOrAttributeCallExp_Helper != null;
																	/*@Thrown*/ Boolean IF_IsEQ__13;
																	if (IsEQ__13) {
																		if (domapNavigationOrAttributeCallExp_Helper == null) {
																			throw new InvalidEvaluationException("Null where non-null value required");
																		}
																		objectManager.getting(domapNavigationOrAttributeCallExp_Helper, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, false);
																		final /*@Thrown*/ @Nullable Boolean s0global_6 = domapNavigationOrAttributeCallExp_Helper.getS0global();
																		final /*@Thrown*/ boolean IsEQ__14 = s0global_6 == Boolean.FALSE;
																		/*@Thrown*/ boolean IF_IsEQ__14;
																		if (IsEQ__14) {
																			final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Helper domapOperationCallExp_Helper = mapOclExpression.getDomapOperationCallExp_Helper();
																			final /*@NonInvalid*/ Boolean IsEQ__15 = domapOperationCallExp_Helper != null;
																			/*@Thrown*/ Boolean IF_IsEQ__15;
																			if (IsEQ__15) {
																				if (domapOperationCallExp_Helper == null) {
																					throw new InvalidEvaluationException("Null where non-null value required");
																				}
																				objectManager.getting(domapOperationCallExp_Helper, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, false);
																				final /*@Thrown*/ @Nullable Boolean s0global_7 = domapOperationCallExp_Helper.getS0global();
																				final /*@Thrown*/ boolean IsEQ__16 = s0global_7 == Boolean.FALSE;
																				/*@Thrown*/ boolean IF_IsEQ__16;
																				if (IsEQ__16) {
																					final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = mapOclExpression.getDomapOperatorCallExp();
																					final /*@NonInvalid*/ Boolean IsEQ__17 = domapOperatorCallExp != null;
																					/*@Thrown*/ Boolean IF_IsEQ__17;
																					if (IsEQ__17) {
																						if (domapOperatorCallExp == null) {
																							throw new InvalidEvaluationException("Null where non-null value required");
																						}
																						objectManager.getting(domapOperatorCallExp, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, false);
																						final /*@Thrown*/ @Nullable Boolean s0global_8 = domapOperatorCallExp.getS0global();
																						final /*@Thrown*/ boolean IsEQ__18 = s0global_8 == Boolean.FALSE;
																						/*@Thrown*/ boolean IF_IsEQ__18;
																						if (IsEQ__18) {
																							final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Property domapNavigationOrAttributeCallExp_Property = mapOclExpression.getDomapNavigationOrAttributeCallExp_Property();
																							final /*@NonInvalid*/ Boolean IsEQ__19 = domapNavigationOrAttributeCallExp_Property != null;
																							/*@Thrown*/ Boolean IF_IsEQ__19;
																							if (IsEQ__19) {
																								if (domapNavigationOrAttributeCallExp_Property == null) {
																									throw new InvalidEvaluationException("Null where non-null value required");
																								}
																								objectManager.getting(domapNavigationOrAttributeCallExp_Property, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, false);
																								final /*@Thrown*/ @Nullable Boolean s0global_9 = domapNavigationOrAttributeCallExp_Property.getS0global();
																								final /*@Thrown*/ boolean IsEQ__20 = s0global_9 == Boolean.FALSE;
																								/*@Thrown*/ boolean IF_IsEQ__20;
																								if (IsEQ__20) {
																									// mapping statements
																									mapOclExpression.setS0global(ValueUtil.FALSE_VALUE);
																									objectManager.assigned(mapOclExpression, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.FALSE_VALUE, false);
																									final /*@NonInvalid*/ boolean mmapOclExpression__verdict__qvtr = ValueUtil.TRUE_VALUE;
																									IF_IsEQ__20 = mmapOclExpression__verdict__qvtr;
																								}
																								else {
																									IF_IsEQ__20 = ValueUtil.FALSE_VALUE;
																								}
																								IF_IsEQ__19 = IF_IsEQ__20;
																							}
																							else {
																								IF_IsEQ__19 = ValueUtil.FALSE_VALUE;
																							}
																							IF_IsEQ__18 = IF_IsEQ__19;
																						}
																						else {
																							IF_IsEQ__18 = ValueUtil.FALSE_VALUE;
																						}
																						IF_IsEQ__17 = IF_IsEQ__18;
																					}
																					else {
																						IF_IsEQ__17 = ValueUtil.FALSE_VALUE;
																					}
																					IF_IsEQ__16 = IF_IsEQ__17;
																				}
																				else {
																					IF_IsEQ__16 = ValueUtil.FALSE_VALUE;
																				}
																				IF_IsEQ__15 = IF_IsEQ__16;
																			}
																			else {
																				IF_IsEQ__15 = ValueUtil.FALSE_VALUE;
																			}
																			IF_IsEQ__14 = IF_IsEQ__15;
																		}
																		else {
																			IF_IsEQ__14 = ValueUtil.FALSE_VALUE;
																		}
																		IF_IsEQ__13 = IF_IsEQ__14;
																	}
																	else {
																		IF_IsEQ__13 = ValueUtil.FALSE_VALUE;
																	}
																	IF_IsEQ__12 = IF_IsEQ__13;
																}
																else {
																	IF_IsEQ__12 = ValueUtil.FALSE_VALUE;
																}
																IF_IsEQ__11 = IF_IsEQ__12;
															}
															else {
																IF_IsEQ__11 = ValueUtil.FALSE_VALUE;
															}
															IF_IsEQ__10 = IF_IsEQ__11;
														}
														else {
															IF_IsEQ__10 = ValueUtil.FALSE_VALUE;
														}
														IF_IsEQ__9 = IF_IsEQ__10;
													}
													else {
														IF_IsEQ__9 = ValueUtil.FALSE_VALUE;
													}
													IF_IsEQ__8 = IF_IsEQ__9;
												}
												else {
													IF_IsEQ__8 = ValueUtil.FALSE_VALUE;
												}
												IF_IsEQ__7 = IF_IsEQ__8;
											}
											else {
												IF_IsEQ__7 = ValueUtil.FALSE_VALUE;
											}
											IF_IsEQ__6 = IF_IsEQ__7;
										}
										else {
											IF_IsEQ__6 = ValueUtil.FALSE_VALUE;
										}
										IF_IsEQ__5 = IF_IsEQ__6;
									}
									else {
										IF_IsEQ__5 = ValueUtil.FALSE_VALUE;
									}
									IF_IsEQ__4 = IF_IsEQ__5;
								}
								else {
									IF_IsEQ__4 = ValueUtil.FALSE_VALUE;
								}
								IF_IsEQ__3 = IF_IsEQ__4;
							}
							else {
								IF_IsEQ__3 = ValueUtil.FALSE_VALUE;
							}
							IF_IsEQ__2 = IF_IsEQ__3;
						}
						else {
							IF_IsEQ__2 = ValueUtil.FALSE_VALUE;
						}
						IF_IsEQ__1 = IF_IsEQ__2;
					}
					else {
						IF_IsEQ__1 = ValueUtil.FALSE_VALUE;
					}
					IF_IsEQ__0 = IF_IsEQ__1;
				}
				else {
					IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ_ = IF_IsEQ__0;
			}
			else {
				IF_IsEQ_ = ValueUtil.FALSE_VALUE;
			}
			return IF_IsEQ_;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(mapOclExpression, thoseValues[0]);
		}
	}

	/**
	 *
	 * map:5 mmapOperationCallExp__Helper__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1] success s0local;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapOperationCallExp_Helper;
	 * check var atlExpression : OCL::OperationCallExp[1] := dispatcher.d3atlExpression;
	 * var atlModule : ATL::Module[1] := this.getModule(atlExpression)
	 *   ;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * check when_mapModule.s0global;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t4qvtrTransformation;
	 * var ownedContext : Parameter[?] := qvtrTransformation.ownedContext;
	 * observe ocl::NamedElement::name var name : String[?] := ownedContext?.name;
	 * observe ocl::TypedElement::type var type : Type[?] := ownedContext?.type;
	 * var elements : OrderedSet(ATL::ModuleElement) := atlModule.elements;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var collect : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(i | i.definition)
	 *   ;
	 * var collect1 : Sequence(OCL::OclFeature) := collect->collect(i | i.feature)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Operation) := collect1->selectByKind(OCL::Operation)
	 *   ;
	 * var atlOperations : Sequence(OCL::Operation) := selectByKind1->select(i | i.name = atlExpression.operationName)
	 *   ;
	 * var notEmpty : Boolean[1] := atlOperations->notEmpty()
	 *   ;
	 * check notEmpty;
	 * var operationName : String[1] := atlExpression.operationName;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlSource.DmapOclExpression;
	 * var any : OCL::Operation[1] := atlOperations->any(i | true);
	 * var definition : OCL::OclFeatureDefinition[?] := any.definition;
	 * var Helper1 : ATL::Helper[?] := definition?.Helper;
	 * var equals : Boolean[1] := definition =
	 *   null;
	 * var _'if' : ATL::Helper[1] := if equals
	 *   then null
	 *   else Helper1
	 *   endif;
	 * var when_mapHelper_Operation : trace_ATL2QVTr::DmapHelper[1] := _'if'.DmapHelper;
	 * notify set trace.t1operationName := operationName;
	 * set trace.t3atlOperations := atlOperations;
	 * notify set dispatcher.result := trace;
	 * set trace.t3atlModule := atlModule;
	 * set trace.t3atlSource := atlSource;
	 * notify set trace.t4qvtrThisVariable := ownedContext;
	 * set trace.t4qvtrTransformation := qvtrTransformation;
	 * notify set trace.wmapHelper := when_mapHelper_Operation;
	 * set trace.wmapModule := when_mapModule;
	 * notify set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected class MAP_mmapOperationCallExp__Helper__qvtr__init__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace;

		public MAP_mmapOperationCallExp__Helper__qvtr__init__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace = (@NonNull TmapOperationCallExp_Helper)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Helper domapOperationCallExp_Helper = dispatcher.getDomapOperationCallExp_Helper();
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapOperationCallExp_Helper);
			/*@Thrown*/ boolean IF_IsEQ_;
			if (IsEQ_) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression d3atlExpression = dispatcher.getD3atlExpression();
				final /*@NonInvalid*/ boolean IsKINDOF_ = d3atlExpression instanceof OperationCallExp;
				/*@Thrown*/ boolean IF_IsKINDOF_;
				if (IsKINDOF_) {
					final /*@NonInvalid*/ @Nullable OperationCallExp CAST_d3atlExpression = (OperationCallExp)d3atlExpression;
					final /*@NonInvalid*/ @NonNull Module getModule_0 = INSTANCE_CACHE_ATL2QVTr_getModule.evaluate(rootThis, CAST_d3atlExpression);
					final /*@NonInvalid*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t3atlModule.get(getModule_0);
					final /*@NonInvalid*/ Boolean IsEQ__0 = TmapModule != null;
					/*@Thrown*/ Boolean IF_IsEQ__0;
					if (IsEQ__0) {
						if (TmapModule == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean s0global = TmapModule.getS0global();
						if (s0global == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ boolean IF_s0global;
						if (s0global) {
							/*@Caught*/ @Nullable Object CAUGHT_t4qvtrTransformation;
							try {
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull RelationalTransformation t4qvtrTransformation = TmapModule.getT4qvtrTransformation();
								CAUGHT_t4qvtrTransformation = t4qvtrTransformation;
							}
							catch (Exception THROWN_CAUGHT_t4qvtrTransformation) {
								CAUGHT_t4qvtrTransformation = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrTransformation);
							}
							/*@Caught*/ @Nullable Object CAUGHT_ownedContext;
							try {
								if (CAUGHT_t4qvtrTransformation instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_t4qvtrTransformation;
								}
								final /*@Thrown*/ @Nullable RelationalTransformation THROWN_t4qvtrTransformation = (@Nullable RelationalTransformation)CAUGHT_t4qvtrTransformation;
								final /*@Thrown*/ @Nullable Parameter ownedContext = THROWN_t4qvtrTransformation.getOwnedContext();
								CAUGHT_ownedContext = ownedContext;
							}
							catch (Exception THROWN_CAUGHT_ownedContext) {
								CAUGHT_ownedContext = ValueUtil.createInvalidValue(THROWN_CAUGHT_ownedContext);
							}
							if (CAUGHT_ownedContext instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_ownedContext;
							}
							final /*@Thrown*/ @Nullable Parameter THROWN_ownedContext = (@Nullable Parameter)CAUGHT_ownedContext;
							final /*@NonInvalid*/ Boolean IsEQ2_ = THROWN_ownedContext == null;
							/*@Caught*/ @Nullable Object IF_IsEQ2_;
							if (IsEQ2_) {
								IF_IsEQ2_ = null;
							}
							else {
								/*@Caught*/ @Nullable Object CAUGHT_name;
								try {
									assert THROWN_ownedContext != null;
									objectManager.getting(THROWN_ownedContext, PivotPackage.Literals.NAMED_ELEMENT__NAME, false);
									final /*@Thrown*/ @Nullable String name = THROWN_ownedContext.getName();
									CAUGHT_name = name;
								}
								catch (Exception THROWN_CAUGHT_name) {
									CAUGHT_name = ValueUtil.createInvalidValue(THROWN_CAUGHT_name);
								}
								IF_IsEQ2_ = CAUGHT_name;
							}
							final /*@NonInvalid*/ Boolean IsEQ2__0 = THROWN_ownedContext == null;
							/*@Caught*/ @Nullable Object IF_IsEQ2__0;
							if (IsEQ2__0) {
								IF_IsEQ2__0 = null;
							}
							else {
								/*@Caught*/ @Nullable Object CAUGHT_type;
								try {
									assert THROWN_ownedContext != null;
									objectManager.getting(THROWN_ownedContext, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
									final /*@Thrown*/ @Nullable Type type = THROWN_ownedContext.getType();
									CAUGHT_type = type;
								}
								catch (Exception THROWN_CAUGHT_type) {
									CAUGHT_type = ValueUtil.createInvalidValue(THROWN_CAUGHT_type);
								}
								IF_IsEQ2__0 = CAUGHT_type;
							}
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull List<ModuleElement> elements = getModule_0.getElements();
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ATL_c_c_Helper = idResolver.getClass(CLSSid_Helper, null);
							final /*@NonInvalid*/ @Nullable OrderedSetValue BOXED_elements = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleElement, elements);
							final /*@NonInvalid*/ @NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(rootExecutor, BOXED_elements, TYP_ATL_c_c_Helper);
							/*@NonInvalid*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeatureDefinition);
							@NonNull Iterator<Object> ITER_i = selectByKind.iterator();
							/*@NonInvalid*/ @NonNull SequenceValue collect;
							while (true) {
								if (!ITER_i.hasNext()) {
									collect = accumulator;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ @NonNull Helper i = (@NonNull Helper)ITER_i.next();
								/**
								 * i.definition
								 */
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition_0 = i.getDefinition();
								//
								accumulator.add(definition_0);
							}
							/*@NonInvalid*/ SequenceValue.@NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeature);
							@NonNull Iterator<Object> ITER_i_0 = collect.iterator();
							/*@NonInvalid*/ @NonNull SequenceValue collect_0;
							while (true) {
								if (!ITER_i_0.hasNext()) {
									collect_0 = accumulator_0;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ @NonNull OclFeatureDefinition i_0 = (@NonNull OclFeatureDefinition)ITER_i_0.next();
								/**
								 * i.feature
								 */
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull OclFeature feature = i_0.getFeature();
								//
								accumulator_0.add(feature);
							}
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_Operation = idResolver.getClass(CLSSid_Operation, null);
							final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(rootExecutor, collect_0, TYP_OCL_c_c_Operation);
							/*@NonInvalid*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
							@NonNull Iterator<Object> ITER_i_1 = selectByKind_0.iterator();
							/*@NonInvalid*/ @NonNull SequenceValue select;
							while (true) {
								if (!ITER_i_1.hasNext()) {
									select = accumulator_1;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation i_1 = (org.eclipse.m2m.atl.common.OCL.@NonNull Operation)ITER_i_1.next();
								/**
								 * i.name = atlExpression.operationName
								 */
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull String name_0 = i_1.getName();
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull String operationName_0 = CAST_d3atlExpression.getOperationName();
								final /*@NonInvalid*/ boolean IsEQ__5 = idResolver.oclEquals(name_0, operationName_0);
								//
								if (IsEQ__5) {
									accumulator_1.add(i_1);
								}
							}
							final /*@NonInvalid*/ boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(select).booleanValue();
							/*@Thrown*/ boolean IF_IF_notEmpty;
							if (notEmpty) {
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull String operationName = CAST_d3atlExpression.getOperationName();
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull OclExpression source = CAST_d3atlExpression.getSource();
								final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(source);
								final /*@NonInvalid*/ Boolean IsEQ__1 = DmapOclExpression != null;
								/*@Thrown*/ Boolean IF_IsEQ__1;
								if (IsEQ__1) {
									if (DmapOclExpression == null) {
										throw new InvalidEvaluationException("Null where non-null value required");
									}
									@NonNull Iterator<Object> ITER_i_2 = select.iterator();
									/*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation any_0;
									while (true) {
										if (!ITER_i_2.hasNext()) {
											throw new InvalidValueException("Nothing to return for ''any''");
										}
										@SuppressWarnings("null")
										/*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation i_2 = (org.eclipse.m2m.atl.common.OCL.@NonNull Operation)ITER_i_2.next();
										/**
										 * true
										 */
										//
										if (ValueUtil.TRUE_VALUE) {			// Carry on till something found
											any_0 = i_2;
											break;
										}
									}
									final /*@NonInvalid*/ @Nullable OclFeatureDefinition definition = any_0.getDefinition();
									final /*@NonInvalid*/ Boolean IsEQ2__1 = definition == null;
									/*@Caught*/ @Nullable Object IF_IsEQ2__1;
									if (IsEQ2__1) {
										IF_IsEQ2__1 = null;
									}
									else {
										/*@Caught*/ @Nullable Object CAUGHT_Helper;
										try {
											// ExecutorCompositionPropertyCallingConvention
											final /*@NonInvalid*/ @Nullable UnboxedCompositionProperty IMPPROPid_definition_0 = new UnboxedCompositionProperty(PROPid_definition);
											assert definition != null;
											final /*@Thrown*/ @Nullable Helper Helper = (@Nullable Helper)IMPPROPid_definition_0.evaluate(rootExecutor, CLSSid_Helper, definition);
											CAUGHT_Helper = Helper;
										}
										catch (Exception THROWN_CAUGHT_Helper) {
											CAUGHT_Helper = ValueUtil.createInvalidValue(THROWN_CAUGHT_Helper);
										}
										IF_IsEQ2__1 = CAUGHT_Helper;
									}
									final /*@NonInvalid*/ boolean IsEQ__2 = definition == null;
									/*@Caught*/ @Nullable Object IF_IF_IsEQ_;
									if (IsEQ__2 == Boolean.TRUE) {
										IF_IF_IsEQ_ = null;
									}
									else {
										IF_IF_IsEQ_ = IF_IsEQ2__1;
									}
									if (IF_IF_IsEQ_ instanceof InvalidValueException) {
										throw (InvalidValueException)IF_IF_IsEQ_;
									}
									final /*@Thrown*/ @Nullable Helper THROWN_IF_IF_IsEQ_ = (@Nullable Helper)IF_IF_IsEQ_;
									final /*@Thrown*/ Boolean IsEQ__3 = THROWN_IF_IF_IsEQ_ != null;
									/*@Thrown*/ Boolean IF_IsEQ__2;
									if (IsEQ__3) {
										/*@Caught*/ @Nullable Object CAUGHT_IF_IF_IsEQ_;
										try {
											if (THROWN_IF_IF_IsEQ_ == null) {
												throw new InvalidEvaluationException("Null where non-null value required");
											}
											CAUGHT_IF_IF_IsEQ_ = THROWN_IF_IF_IsEQ_;
										}
										catch (Exception THROWN_CAUGHT_IF_IF_IsEQ_) {
											CAUGHT_IF_IF_IsEQ_ = ValueUtil.createInvalidValue(THROWN_CAUGHT_IF_IF_IsEQ_);
										}
										/*@Caught*/ @Nullable Object CAUGHT_DmapHelper;
										try {
											if (CAUGHT_IF_IF_IsEQ_ instanceof InvalidValueException) {
												throw (InvalidValueException)CAUGHT_IF_IF_IsEQ_;
											}
											final /*@Thrown*/ @Nullable Helper THROWN_IF_IF_IsEQ__0 = (@Nullable Helper)CAUGHT_IF_IF_IsEQ_;
											final /*@Thrown*/ @Nullable DmapHelper DmapHelper = OPPOSITE_OF_DmapHelper_d3atlHelper.get(THROWN_IF_IF_IsEQ__0);
											CAUGHT_DmapHelper = DmapHelper;
										}
										catch (Exception THROWN_CAUGHT_DmapHelper) {
											CAUGHT_DmapHelper = ValueUtil.createInvalidValue(THROWN_CAUGHT_DmapHelper);
										}
										if (CAUGHT_DmapHelper instanceof InvalidValueException) {
											throw (InvalidValueException)CAUGHT_DmapHelper;
										}
										final /*@Thrown*/ @Nullable DmapHelper THROWN_DmapHelper = (@Nullable DmapHelper)CAUGHT_DmapHelper;
										final /*@Thrown*/ Boolean IsEQ__4 = THROWN_DmapHelper != null;
										/*@Thrown*/ Boolean IF_IsEQ__3;
										if (IsEQ__4) {
											/*@Caught*/ @Nullable Object CAUGHT_DmapHelper_0;
											try {
												if (THROWN_DmapHelper == null) {
													throw new InvalidEvaluationException("Null where non-null value required");
												}
												CAUGHT_DmapHelper_0 = THROWN_DmapHelper;
											}
											catch (Exception THROWN_CAUGHT_DmapHelper_0) {
												CAUGHT_DmapHelper_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_DmapHelper_0);
											}
											// mapping statements
											trace.setT1operationName(operationName);
											objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__T1OPERATION_NAME, operationName, false);
											final /*@NonInvalid*/ @Nullable List<org.eclipse.m2m.atl.common.OCL.Operation> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.m2m.atl.common.OCL.Operation.class, select);
											trace.getT3atlOperations().addAll(ECORE_select);
											dispatcher.setResult(trace);
											objectManager.assigned(dispatcher, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__RESULT, trace, false);
											trace.setT3atlModule(getModule_0);
											trace.setT3atlSource(source);
											if (CAUGHT_ownedContext instanceof InvalidValueException) {
												throw (InvalidValueException)CAUGHT_ownedContext;
											}
											final /*@Thrown*/ @Nullable Parameter THROWN_ownedContext_0 = (@Nullable Parameter)CAUGHT_ownedContext;
											if (THROWN_ownedContext_0 == null) {
												throw new InvalidEvaluationException("Null value for t4qvtrThisVariable assignment");
											}
											trace.setT4qvtrThisVariable(THROWN_ownedContext_0);
											objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__T4QVTR_THIS_VARIABLE, THROWN_ownedContext_0, false);
											if (CAUGHT_t4qvtrTransformation instanceof InvalidValueException) {
												throw (InvalidValueException)CAUGHT_t4qvtrTransformation;
											}
											final /*@Thrown*/ @Nullable RelationalTransformation THROWN_t4qvtrTransformation_0 = (@Nullable RelationalTransformation)CAUGHT_t4qvtrTransformation;
											trace.setT4qvtrTransformation(THROWN_t4qvtrTransformation_0);
											if (CAUGHT_DmapHelper_0 instanceof InvalidValueException) {
												throw (InvalidValueException)CAUGHT_DmapHelper_0;
											}
											final /*@Thrown*/ @Nullable DmapHelper THROWN_DmapHelper_0 = (@Nullable DmapHelper)CAUGHT_DmapHelper_0;
											trace.setWmapHelper(THROWN_DmapHelper_0);
											objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_HELPER, THROWN_DmapHelper_0, false);
											trace.setWmapModule(TmapModule);
											trace.setWmapOclExpression(DmapOclExpression);
											objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION, DmapOclExpression, false);
											final /*@NonInvalid*/ boolean mmapOperationCallExp__Helper__qvtr__init__ = ValueUtil.TRUE_VALUE;
											IF_IsEQ__3 = mmapOperationCallExp__Helper__qvtr__init__;
										}
										else {
											IF_IsEQ__3 = ValueUtil.FALSE_VALUE;
										}
										IF_IsEQ__2 = IF_IsEQ__3;
									}
									else {
										IF_IsEQ__2 = ValueUtil.FALSE_VALUE;
									}
									IF_IsEQ__1 = IF_IsEQ__2;
								}
								else {
									IF_IsEQ__1 = ValueUtil.FALSE_VALUE;
								}
								IF_IF_notEmpty = IF_IsEQ__1;
							}
							else {
								IF_IF_notEmpty = ValueUtil.FALSE_VALUE;
							}
							IF_s0global = IF_IF_notEmpty;
						}
						else {
							IF_s0global = ValueUtil.FALSE_VALUE;
						}
						IF_IsEQ__0 = IF_s0global;
					}
					else {
						IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
					}
					IF_IsKINDOF_ = IF_IsEQ__0;
				}
				else {
					IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ_ = IF_IsKINDOF_;
			}
			else {
				IF_IsEQ_ = ValueUtil.FALSE_VALUE;
			}
			trace.setS0local(IF_IsEQ_);
			objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__S0LOCAL, IF_IsEQ_, false);
			return IF_IsEQ_;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:5 mmapOperationCallExp__Helper__qvtr__loop__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1] success s0global;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperationCallExp_Helper;
	 * observe trace_ATL2QVTr::TmapOperationCallExp_Helper::s0local check trace.s0local;
	 * check var ownedContext : Parameter[1] := trace.t4qvtrThisVariable;
	 * observe ocl::NamedElement::name var name : String[?] := ownedContext.name;
	 * observe ocl::TypedElement::type var type : Type[?] := ownedContext.type;
	 * var when_mapHelper_Operation : trace_ATL2QVTr::DmapHelper[1] := trace.wmapHelper;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * speculate when_mapHelper_Operation.s0global, when_mapOclExpression.s0global;
	 * var operationName : String[1] := trace.t1operationName;
	 * new:qvtr qvtrExpression : OperationCallExp[1];
	 * new:qvtr qvtrSource : VariableExp[1];
	 * set qvtrExpression.name := operationName;
	 * set qvtrSource.name := name;
	 * notify set dispatcher.s0global := true;
	 * set dispatcher.d4qvtrExpression := qvtrExpression;
	 * set trace.t4qvtrSource := qvtrSource;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 * set qvtrSource.referredVariable := ownedContext;
	 * notify set qvtrSource.type := type;
	 *
	 */
	protected class MAP_mmapOperationCallExp__Helper__qvtr__loop__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace;

		public MAP_mmapOperationCallExp__Helper__qvtr__loop__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace = (@NonNull TmapOperationCallExp_Helper)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Helper domapOperationCallExp_Helper = dispatcher.getDomapOperationCallExp_Helper();
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapOperationCallExp_Helper);
			/*@Thrown*/ boolean IF_IsEQ_;
			if (IsEQ_) {
				objectManager.getting(trace, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__S0LOCAL, false);
				final /*@NonInvalid*/ @Nullable Boolean s0local = trace.getS0local();
				if (s0local == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0local;
				if (s0local) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull VariableDeclaration t4qvtrThisVariable = trace.getT4qvtrThisVariable();
					final /*@NonInvalid*/ boolean IsKINDOF_ = t4qvtrThisVariable instanceof Parameter;
					/*@NonInvalid*/ boolean IF_IsKINDOF_;
					if (IsKINDOF_) {
						final /*@NonInvalid*/ @Nullable Parameter CAST_t4qvtrThisVariable = (Parameter)t4qvtrThisVariable;
						objectManager.getting(CAST_t4qvtrThisVariable, PivotPackage.Literals.NAMED_ELEMENT__NAME, false);
						final /*@NonInvalid*/ @Nullable String name = CAST_t4qvtrThisVariable.getName();
						objectManager.getting(CAST_t4qvtrThisVariable, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@NonInvalid*/ @Nullable Type type = CAST_t4qvtrThisVariable.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull DmapHelper wmapHelper = trace.getWmapHelper();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace.getWmapOclExpression();
						SlotState.@NonNull Speculating outputSpeculatingSlotState = objectManager.getSpeculatingSlotState(trace, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL);
						Boolean outputSpeculatingSlotStatus = outputSpeculatingSlotState.getSpeculationStatus();
						if (outputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
							if (outputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
								trace.setS0global(ValueUtil.FALSE_VALUE);
								return ValueUtil.FALSE_VALUE;
							}
							SlotState.@NonNull Speculating inputSpeculatingSlotState;
							Boolean inputSpeculatingSlotStatus;
							boolean needsSpeculation = false;
							if (wmapHelper == null) {
								throw new InvalidEvaluationException("Null wmapHelper speculation source");
							}
							inputSpeculatingSlotState = objectManager.getSpeculatingSlotState(wmapHelper, trace_ATL2QVTrPackage.Literals.DMAP_HELPER__S0GLOBAL);
							inputSpeculatingSlotStatus = inputSpeculatingSlotState.getSpeculationStatus();
							if (inputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
								if (inputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
									wmapHelper.setS0global(ValueUtil.FALSE_VALUE);
									return ValueUtil.FALSE_VALUE;
								}
								if (outputSpeculatingSlotState != inputSpeculatingSlotState) {
									outputSpeculatingSlotState.addInput(inputSpeculatingSlotState);
									needsSpeculation = true;
								}
							}
							if (wmapOclExpression == null) {
								throw new InvalidEvaluationException("Null wmapOclExpression speculation source");
							}
							inputSpeculatingSlotState = objectManager.getSpeculatingSlotState(wmapOclExpression, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL);
							inputSpeculatingSlotStatus = inputSpeculatingSlotState.getSpeculationStatus();
							if (inputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
								if (inputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
									wmapOclExpression.setS0global(ValueUtil.FALSE_VALUE);
									return ValueUtil.FALSE_VALUE;
								}
								if (outputSpeculatingSlotState != inputSpeculatingSlotState) {
									outputSpeculatingSlotState.addInput(inputSpeculatingSlotState);
									needsSpeculation = true;
								}
							}
							if (needsSpeculation) {
								throw new InvocationFailedException(outputSpeculatingSlotState, true);
							}
						}
						boolean SPEC_ = true;
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t1operationName = trace.getT1operationName();
						// creations
						final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
						MODEL_qvtr.add(qvtrExpression, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
						}
						final org.eclipse.ocl.pivot.@NonNull VariableExp qvtrSource = PivotFactory.eINSTANCE.createVariableExp();
						MODEL_qvtr.add(qvtrSource, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrSource));
						}
						// mapping statements
						qvtrExpression.setName(t1operationName);
						qvtrSource.setName(name);
						dispatcher.setS0global(ValueUtil.TRUE_VALUE);
						objectManager.assigned(dispatcher, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
						dispatcher.setD4qvtrExpression(qvtrExpression);
						trace.setT4qvtrSource(qvtrSource);
						qvtrExpression.setOwnedSource(qvtrSource);
						qvtrSource.setReferredVariable(CAST_t4qvtrThisVariable);
						qvtrSource.setType(type);
						objectManager.assigned(qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type, false);
						final /*@NonInvalid*/ boolean mmapOperationCallExp__Helper__qvtr__loop__ = ValueUtil.TRUE_VALUE;
						IF_IsKINDOF_ = SPEC_;
					}
					else {
						IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
					}
					IF_s0local = IF_IsKINDOF_;
				}
				else {
					IF_s0local = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ_ = IF_s0local;
			}
			else {
				IF_IsEQ_ = ValueUtil.FALSE_VALUE;
			}
			trace.setS0global(IF_IsEQ_);
			objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_IsEQ_, false);
			return IF_IsEQ_;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:5 mmapOperationCallExp__Operation__qvtr__loop__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Operation[1] success s0global;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperationCallExp_Operation;
	 * var not_mapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1] := dispatcher.domapOperatorCallExp;
	 * check trace.s0local;
	 * observe trace_ATL2QVTr::ImapOclExpression::s0global check not_mapOperatorCallExp.s0global = false;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * speculate when_mapOclExpression.s0global;
	 * var operationName : String[1] := trace.t1operationName;
	 * new:qvtr qvtrExpression : OperationCallExp[1];
	 * set qvtrExpression.name := operationName;
	 * notify set dispatcher.s0global := true;
	 * set dispatcher.d4qvtrExpression := qvtrExpression;
	 *
	 */
	protected class MAP_mmapOperationCallExp__Operation__qvtr__loop__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace;

		public MAP_mmapOperationCallExp__Operation__qvtr__loop__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace = (@NonNull TmapOperationCallExp_Operation)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Operation domapOperationCallExp_Operation = dispatcher.getDomapOperationCallExp_Operation();
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapOperationCallExp_Operation);
			/*@Thrown*/ boolean IF_IsEQ_;
			if (IsEQ_) {
				final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher.getDomapOperatorCallExp();
				final /*@NonInvalid*/ Boolean IsEQ__0 = domapOperatorCallExp != null;
				/*@Thrown*/ Boolean IF_IsEQ__0;
				if (IsEQ__0) {
					if (domapOperatorCallExp == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@NonInvalid*/ @Nullable Boolean s0local = trace.getS0local();
					if (s0local == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ boolean IF_s0local;
					if (s0local) {
						objectManager.getting(domapOperatorCallExp, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, false);
						final /*@Thrown*/ @Nullable Boolean s0global = domapOperatorCallExp.getS0global();
						final /*@Thrown*/ boolean IsEQ__1 = s0global == Boolean.FALSE;
						/*@Thrown*/ boolean IF_IsEQ__1;
						if (IsEQ__1) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace.getWmapOclExpression();
							SlotState.@NonNull Speculating outputSpeculatingSlotState = objectManager.getSpeculatingSlotState(trace, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL);
							Boolean outputSpeculatingSlotStatus = outputSpeculatingSlotState.getSpeculationStatus();
							if (outputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
								if (outputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
									trace.setS0global(ValueUtil.FALSE_VALUE);
									return ValueUtil.FALSE_VALUE;
								}
								SlotState.@NonNull Speculating inputSpeculatingSlotState;
								Boolean inputSpeculatingSlotStatus;
								boolean needsSpeculation = false;
								if (wmapOclExpression == null) {
									throw new InvalidEvaluationException("Null wmapOclExpression speculation source");
								}
								inputSpeculatingSlotState = objectManager.getSpeculatingSlotState(wmapOclExpression, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL);
								inputSpeculatingSlotStatus = inputSpeculatingSlotState.getSpeculationStatus();
								if (inputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
									if (inputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
										wmapOclExpression.setS0global(ValueUtil.FALSE_VALUE);
										return ValueUtil.FALSE_VALUE;
									}
									if (outputSpeculatingSlotState != inputSpeculatingSlotState) {
										outputSpeculatingSlotState.addInput(inputSpeculatingSlotState);
										needsSpeculation = true;
									}
								}
								if (needsSpeculation) {
									throw new InvocationFailedException(outputSpeculatingSlotState, true);
								}
							}
							boolean SPEC_ = true;
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String t1operationName = trace.getT1operationName();
							// creations
							final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
							MODEL_qvtr.add(qvtrExpression, false);
							if (debugCreations) {
								AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
							}
							// mapping statements
							qvtrExpression.setName(t1operationName);
							dispatcher.setS0global(ValueUtil.TRUE_VALUE);
							objectManager.assigned(dispatcher, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
							dispatcher.setD4qvtrExpression(qvtrExpression);
							final /*@NonInvalid*/ boolean mmapOperationCallExp__Operation__qvtr__loop__ = ValueUtil.TRUE_VALUE;
							IF_IsEQ__1 = SPEC_;
						}
						else {
							IF_IsEQ__1 = ValueUtil.FALSE_VALUE;
						}
						IF_s0local = IF_IsEQ__1;
					}
					else {
						IF_s0local = ValueUtil.FALSE_VALUE;
					}
					IF_IsEQ__0 = IF_s0local;
				}
				else {
					IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ_ = IF_IsEQ__0;
			}
			else {
				IF_IsEQ_ = ValueUtil.FALSE_VALUE;
			}
			trace.setS0global(IF_IsEQ_);
			objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_IsEQ_, false);
			return IF_IsEQ_;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:5 mmapOperatorCallExp__qvtr__loop__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperatorCallExp[1] success s0global;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperatorCallExp;
	 * check trace.s0local;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * speculate when_mapOclExpression.s0global;
	 * var operationName : String[1] := trace.t1operationName;
	 * new:qvtr qvtrExpression : OperationCallExp[1];
	 * set qvtrExpression.name := operationName;
	 * notify set dispatcher.s0global := true;
	 * set dispatcher.d4qvtrExpression := qvtrExpression;
	 *
	 */
	protected class MAP_mmapOperatorCallExp__qvtr__loop__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace;

		public MAP_mmapOperatorCallExp__qvtr__loop__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace = (@NonNull TmapOperatorCallExp)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher.getDomapOperatorCallExp();
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapOperatorCallExp);
			/*@Thrown*/ boolean IF_IsEQ_;
			if (IsEQ_) {
				final /*@NonInvalid*/ @Nullable Boolean s0local = trace.getS0local();
				if (s0local == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0local;
				if (s0local) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace.getWmapOclExpression();
					SlotState.@NonNull Speculating outputSpeculatingSlotState = objectManager.getSpeculatingSlotState(trace, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL);
					Boolean outputSpeculatingSlotStatus = outputSpeculatingSlotState.getSpeculationStatus();
					if (outputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
						if (outputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
							trace.setS0global(ValueUtil.FALSE_VALUE);
							return ValueUtil.FALSE_VALUE;
						}
						SlotState.@NonNull Speculating inputSpeculatingSlotState;
						Boolean inputSpeculatingSlotStatus;
						boolean needsSpeculation = false;
						if (wmapOclExpression == null) {
							throw new InvalidEvaluationException("Null wmapOclExpression speculation source");
						}
						inputSpeculatingSlotState = objectManager.getSpeculatingSlotState(wmapOclExpression, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL);
						inputSpeculatingSlotStatus = inputSpeculatingSlotState.getSpeculationStatus();
						if (inputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
							if (inputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
								wmapOclExpression.setS0global(ValueUtil.FALSE_VALUE);
								return ValueUtil.FALSE_VALUE;
							}
							if (outputSpeculatingSlotState != inputSpeculatingSlotState) {
								outputSpeculatingSlotState.addInput(inputSpeculatingSlotState);
								needsSpeculation = true;
							}
						}
						if (needsSpeculation) {
							throw new InvocationFailedException(outputSpeculatingSlotState, true);
						}
					}
					boolean SPEC_ = true;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String t1operationName = trace.getT1operationName();
					// creations
					final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
					MODEL_qvtr.add(qvtrExpression, false);
					if (debugCreations) {
						AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
					}
					// mapping statements
					qvtrExpression.setName(t1operationName);
					dispatcher.setS0global(ValueUtil.TRUE_VALUE);
					objectManager.assigned(dispatcher, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
					dispatcher.setD4qvtrExpression(qvtrExpression);
					final /*@NonInvalid*/ boolean mmapOperatorCallExp__qvtr__loop__ = ValueUtil.TRUE_VALUE;
					IF_s0local = SPEC_;
				}
				else {
					IF_s0local = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ_ = IF_s0local;
			}
			else {
				IF_IsEQ_ = ValueUtil.FALSE_VALUE;
			}
			trace.setS0global(IF_IsEQ_);
			objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_IsEQ_, false);
			return IF_IsEQ_;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace, thoseValues[0]);
		}
	}

	/**
	 *
	 * map:6 mmapInPattern__qvtr__rest__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapInPattern[1];
	 * check trace.s0global;
	 * var qvtrDomain : qvtrelation::RelationDomain[1] := trace.t4qvtrDomain;
	 * set qvtrDomain.isCheckable := true;
	 * set qvtrDomain.isEnforceable := false;
	 *
	 */
	protected boolean MAP_mmapInPattern__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapInPattern trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapInPattern__qvtr__rest__" +
					"\n\t\"trace\":" + toDebugString(trace));
		}
		final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
		if (s0global == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ boolean IF_s0global;
		if (s0global) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull RelationDomain t4qvtrDomain = trace.getT4qvtrDomain();
			// mapping statements
			t4qvtrDomain.setIsCheckable(ValueUtil.TRUE_VALUE);
			t4qvtrDomain.setIsEnforceable(ValueUtil.FALSE_VALUE);
			final /*@NonInvalid*/ boolean mmapInPattern__qvtr__rest__ = ValueUtil.TRUE_VALUE;
			IF_s0global = mmapInPattern__qvtr__rest__;
		}
		else {
			IF_s0global = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_s0global ? "done "  : "fail ") + "MAP_mmapInPattern__qvtr__rest__");
		}
		return IF_s0global;
	}

	/**
	 *
	 * map:6 mmapSimpleInPatternElement__qvtr__init__ in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapSimpleInPatternElement[1] success s0global;
	 * append jm_TmapVariable  : trace_ATL2QVTr::TmapVariable[1];
	 * var atlElement : ATL::SimpleInPatternElement[1] := trace.t3atlElement;
	 * var atlPattern : ATL::InPattern[1] := atlElement.inPattern;
	 * var when_mapInPattern : trace_ATL2QVTr::TmapInPattern[1] := atlPattern.TmapInPattern;
	 * check when_mapInPattern.s0global;
	 * var atlRule : ATL::MatchedRule[1] := atlPattern.rule;
	 * var when_mapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1] := atlRule.TmapMatchedRule;
	 * check when_mapMatchedRule.s0global;
	 * var type : OCL::OclType[?] := atlElement.type;
	 * var elementName : String[1] := atlElement.varName;
	 * var qvtrDomain : qvtrelation::RelationDomain[1] := when_mapInPattern.t4qvtrDomain;
	 * var qvtrRelation : qvtrelation::Relation[1] := when_mapMatchedRule.t4qvtrRelation;
	 * var getType1 : Class[1] := this.getType(type);
	 * new:qvtr qvtrPattern : qvtrelation::DomainPattern[1];
	 * new:qvtr qvtrTemplate : qvttemplate::ObjectTemplateExp[1];
	 * new:qvtr qvtrVariable : qvtrelation::TemplateVariable[1];
	 * new:middle where_mapVariable : trace_ATL2QVTr::TmapVariable[1] {trace_ATL2QVTr::TmapVariable::t3atlVariable : ATL::LocatedElement[1] = atlElement, trace_ATL2QVTr::TmapVariable::t4qvtrVariable : VariableDeclaration[1] = qvtrVariable}
	 * set qvtrVariable.name := elementName;
	 * set trace.t1elementName := elementName;
	 * set qvtrPattern.relationDomain := qvtrDomain;
	 * set qvtrPattern.templateExpression := qvtrTemplate;
	 * set qvtrTemplate.bindsTo := qvtrVariable;
	 * set qvtrTemplate.referredClass := getType1;
	 * notify set qvtrTemplate.type := getType1;
	 * set qvtrRelation.variable := qvtrVariable;
	 * set qvtrDomain.rootVariable := qvtrVariable;
	 * set qvtrVariable.type := getType1;
	 * set trace.t3atlPattern := atlPattern;
	 * set trace.t3atlRule := atlRule;
	 * set trace.t4qvtrDomain := qvtrDomain;
	 * set trace.t4qvtrPattern := qvtrPattern;
	 * set trace.t4qvtrRelation := qvtrRelation;
	 * set trace.t4qvtrTemplate := qvtrTemplate;
	 * set trace.t4qvtrVariable := qvtrVariable;
	 * set trace.wmapInPattern := when_mapInPattern;
	 * set trace.wmapMatchedRule := when_mapMatchedRule;
	 * set trace.wmapVariable := where_mapVariable;
	 * add jm_TmapVariable += where_mapVariable;
	 *
	 */
	protected boolean MAP_mmapSimpleInPatternElement__qvtr__init__(final @NonNull Connection jm_TmapVariable, final /*@NonInvalid*/ @NonNull TmapSimpleInPatternElement trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapSimpleInPatternElement__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull SimpleInPatternElement t3atlElement = trace.getT3atlElement();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull InPattern inPattern = t3atlElement.getInPattern();
		final /*@NonInvalid*/ @Nullable TmapInPattern TmapInPattern = OPPOSITE_OF_TmapInPattern_t3atlPattern.get(inPattern);
		final /*@NonInvalid*/ Boolean IsEQ_ = TmapInPattern != null;
		/*@Thrown*/ Boolean IF_IsEQ_;
		if (IsEQ_) {
			if (TmapInPattern == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean s0global = TmapInPattern.getS0global();
			if (s0global == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ boolean IF_s0global;
			if (s0global) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull MatchedRule rule = inPattern.getRule();
				final /*@NonInvalid*/ @Nullable TmapMatchedRule TmapMatchedRule = OPPOSITE_OF_TmapMatchedRule_t3matchedRule.get(rule);
				final /*@NonInvalid*/ Boolean IsEQ__0 = TmapMatchedRule != null;
				/*@Thrown*/ Boolean IF_IsEQ__0;
				if (IsEQ__0) {
					if (TmapMatchedRule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable Boolean s0global_0 = TmapMatchedRule.getS0global();
					if (s0global_0 == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ boolean IF_s0global_0;
					if (s0global_0) {
						final /*@NonInvalid*/ @Nullable OclType type = t3atlElement.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String varName = t3atlElement.getVarName();
						/*@Caught*/ @Nullable Object CAUGHT_t4qvtrDomain;
						try {
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull RelationDomain t4qvtrDomain = TmapInPattern.getT4qvtrDomain();
							CAUGHT_t4qvtrDomain = t4qvtrDomain;
						}
						catch (Exception THROWN_CAUGHT_t4qvtrDomain) {
							CAUGHT_t4qvtrDomain = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrDomain);
						}
						/*@Caught*/ @Nullable Object CAUGHT_t4qvtrRelation;
						try {
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull Relation t4qvtrRelation = TmapMatchedRule.getT4qvtrRelation();
							CAUGHT_t4qvtrRelation = t4qvtrRelation;
						}
						catch (Exception THROWN_CAUGHT_t4qvtrRelation) {
							CAUGHT_t4qvtrRelation = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrRelation);
						}
						/*@Caught*/ @Nullable Object CAUGHT_getType;
						try {
							final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Class getType_0 = INSTANCE_CACHE_ATL2QVTr_getType.evaluate(rootThis, type);
							CAUGHT_getType = getType_0;
						}
						catch (Exception THROWN_CAUGHT_getType) {
							CAUGHT_getType = ValueUtil.createInvalidValue(THROWN_CAUGHT_getType);
						}
						// creations
						final @NonNull DomainPattern qvtrPattern = QVTrelationFactory.eINSTANCE.createDomainPattern();
						MODEL_qvtr.add(qvtrPattern, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrPattern));
						}
						final @NonNull ObjectTemplateExp qvtrTemplate = QVTtemplateFactory.eINSTANCE.createObjectTemplateExp();
						MODEL_qvtr.add(qvtrTemplate, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrTemplate));
						}
						final @NonNull TemplateVariable qvtrVariable = QVTrelationFactory.eINSTANCE.createTemplateVariable();
						MODEL_qvtr.add(qvtrVariable, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrVariable));
						}
						final @SuppressWarnings("null")@NonNull TmapVariable where_mapVariable = INSTANCE_RULE_CACHE_TmapVariable.evaluate(t3atlElement, qvtrVariable);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(where_mapVariable));
						}
						// mapping statements
						qvtrVariable.setName(varName);
						trace.setT1elementName(varName);
						if (CAUGHT_t4qvtrDomain instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_t4qvtrDomain;
						}
						final /*@Thrown*/ @Nullable RelationDomain THROWN_t4qvtrDomain = (@Nullable RelationDomain)CAUGHT_t4qvtrDomain;
						qvtrPattern.setRelationDomain(THROWN_t4qvtrDomain);
						qvtrPattern.setTemplateExpression(qvtrTemplate);
						qvtrTemplate.setBindsTo(qvtrVariable);
						if (CAUGHT_getType instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_getType;
						}
						final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Class THROWN_getType = (org.eclipse.ocl.pivot.@Nullable Class)CAUGHT_getType;
						qvtrTemplate.setReferredClass(THROWN_getType);
						if (CAUGHT_getType instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_getType;
						}
						final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Class THROWN_getType_0 = (org.eclipse.ocl.pivot.@Nullable Class)CAUGHT_getType;
						qvtrTemplate.setType(THROWN_getType_0);
						objectManager.assigned(qvtrTemplate, PivotPackage.Literals.TYPED_ELEMENT__TYPE, THROWN_getType_0, false);
						if (CAUGHT_t4qvtrRelation instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_t4qvtrRelation;
						}
						final /*@Thrown*/ @Nullable Relation THROWN_t4qvtrRelation = (@Nullable Relation)CAUGHT_t4qvtrRelation;
						THROWN_t4qvtrRelation.getVariable().add(qvtrVariable);
						if (CAUGHT_t4qvtrDomain instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_t4qvtrDomain;
						}
						final /*@Thrown*/ @Nullable RelationDomain THROWN_t4qvtrDomain_0 = (@Nullable RelationDomain)CAUGHT_t4qvtrDomain;
						THROWN_t4qvtrDomain_0.getRootVariable().add(qvtrVariable);
						if (CAUGHT_getType instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_getType;
						}
						final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Class THROWN_getType_1 = (org.eclipse.ocl.pivot.@Nullable Class)CAUGHT_getType;
						qvtrVariable.setType(THROWN_getType_1);
						trace.setT3atlPattern(inPattern);
						trace.setT3atlRule(rule);
						if (CAUGHT_t4qvtrDomain instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_t4qvtrDomain;
						}
						final /*@Thrown*/ @Nullable RelationDomain THROWN_t4qvtrDomain_1 = (@Nullable RelationDomain)CAUGHT_t4qvtrDomain;
						trace.setT4qvtrDomain(THROWN_t4qvtrDomain_1);
						trace.setT4qvtrPattern(qvtrPattern);
						if (CAUGHT_t4qvtrRelation instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_t4qvtrRelation;
						}
						final /*@Thrown*/ @Nullable Relation THROWN_t4qvtrRelation_0 = (@Nullable Relation)CAUGHT_t4qvtrRelation;
						trace.setT4qvtrRelation(THROWN_t4qvtrRelation_0);
						trace.setT4qvtrTemplate(qvtrTemplate);
						trace.setT4qvtrVariable(qvtrVariable);
						trace.setWmapInPattern(TmapInPattern);
						trace.setWmapMatchedRule(TmapMatchedRule);
						trace.setWmapVariable(where_mapVariable);
						jm_TmapVariable.appendElement(where_mapVariable);
						final /*@NonInvalid*/ boolean mmapSimpleInPatternElement__qvtr__init__ = ValueUtil.TRUE_VALUE;
						IF_s0global_0 = mmapSimpleInPatternElement__qvtr__init__;
					}
					else {
						IF_s0global_0 = ValueUtil.FALSE_VALUE;
					}
					IF_IsEQ__0 = IF_s0global_0;
				}
				else {
					IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
				}
				IF_s0global = IF_IsEQ__0;
			}
			else {
				IF_s0global = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_s0global;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0global(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_SIMPLE_IN_PATTERN_ELEMENT__S0GLOBAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapSimpleInPatternElement__qvtr__init__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:6 mmapSimpleOutPatternElement__qvtr__rest__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapSimpleOutPatternElement[1];
	 * check trace.s0global;
	 * var qvtrDomain : qvtrelation::RelationDomain[1] := trace.t4qvtrDomain;
	 * set qvtrDomain.isCheckable := false;
	 * set qvtrDomain.isEnforceable := true;
	 *
	 */
	protected boolean MAP_mmapSimpleOutPatternElement__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapSimpleOutPatternElement trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapSimpleOutPatternElement__qvtr__rest__" +
					"\n\t\"trace\":" + toDebugString(trace));
		}
		final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
		if (s0global == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ boolean IF_s0global;
		if (s0global) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull RelationDomain t4qvtrDomain = trace.getT4qvtrDomain();
			// mapping statements
			t4qvtrDomain.setIsCheckable(ValueUtil.FALSE_VALUE);
			t4qvtrDomain.setIsEnforceable(ValueUtil.TRUE_VALUE);
			final /*@NonInvalid*/ boolean mmapSimpleOutPatternElement__qvtr__rest__ = ValueUtil.TRUE_VALUE;
			IF_s0global = mmapSimpleOutPatternElement__qvtr__rest__;
		}
		else {
			IF_s0global = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_s0global ? "done "  : "fail ") + "MAP_mmapSimpleOutPatternElement__qvtr__rest__");
		}
		return IF_s0global;
	}

	/**
	 *
	 * map:6 mmapVariableExp__referredVariable__Helper__qvtr__in in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1] success s0local;
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 * check trace = dispatcher.domapVariableExp_referredVariable_Helper;
	 * var atlExpression : OCL::VariableExp[1] := dispatcher.d3atlExpression;
	 * var qvtrExpression : VariableExp[1] := dispatcher.d4qvtrExpression;
	 * var atlVariable : OCL::VariableDeclaration[1] := atlExpression.referredVariable;
	 * check atlVariable.varName =
	 *   'self';
	 * var atlHelper : ATL::Helper[?] := this.getHelper(atlExpression);
	 * set dispatcher.result := trace;
	 * set trace.t3atlHelper := atlHelper;
	 * set trace.t3atlVariable := atlVariable;
	 *
	 */
	protected boolean MAP_mmapVariableExp__referredVariable__Helper__qvtr__in(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_Helper trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariableExp__referredVariable__Helper__qvtr__in" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_Helper domapVariableExp_referredVariable_Helper = dispatcher.getDomapVariableExp_referredVariable_Helper();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapVariableExp_referredVariable_Helper);
		/*@NonInvalid*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull VariableExp d3atlExpression = dispatcher.getD3atlExpression();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp d4qvtrExpression = dispatcher.getD4qvtrExpression();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableDeclaration referredVariable = d3atlExpression.getReferredVariable();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String varName = referredVariable.getVarName();
			final /*@NonInvalid*/ boolean IsEQ__0 = idResolver.oclEquals(varName, STR_self);
			/*@NonInvalid*/ boolean IF_IsEQ__0;
			if (IsEQ__0) {
				final /*@NonInvalid*/ @Nullable Helper getHelper = INSTANCE_CACHE_ATL2QVTr_getHelper.evaluate(d3atlExpression);
				// mapping statements
				dispatcher.setResult(trace);
				if (getHelper == null) {
					throw new InvalidEvaluationException("Null value for t3atlHelper assignment");
				}
				trace.setT3atlHelper(getHelper);
				trace.setT3atlVariable(referredVariable);
				final /*@NonInvalid*/ boolean mmapVariableExp__referredVariable__Helper__qvtr__in = ValueUtil.TRUE_VALUE;
				IF_IsEQ__0 = mmapVariableExp__referredVariable__Helper__qvtr__in;
			}
			else {
				IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsEQ__0;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0local(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__S0LOCAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapVariableExp__referredVariable__Helper__qvtr__in");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:7 mmapBinding__qvtr__init__ in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapBinding[1] success s0global;
	 * var atlBinding : ATL::Binding[1] := trace.t3atlBinding;
	 * check var atlOutPatternElement : ATL::SimpleOutPatternElement[1] := atlBinding.outPatternElement;
	 * var atlExpression : OCL::OclExpression[1] := atlBinding.value;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlExpression.DmapOclExpression;
	 * check when_mapOclExpression.s0global;
	 * var when_mapSimpleOutPatternElement : trace_ATL2QVTr::TmapSimpleOutPatternElement[1] := atlOutPatternElement.TmapSimpleOutPatternElement;
	 * check when_mapSimpleOutPatternElement.s0global;
	 * var propertyName : String[1] := atlBinding.propertyName;
	 * var qvtrExpression : OCLExpression[1] := when_mapOclExpression.d4qvtrExpression;
	 * var qvtrTemplate : qvttemplate::ObjectTemplateExp[1] := when_mapSimpleOutPatternElement.t4qvtrTemplate;
	 * var type : Type[?] := qvtrTemplate.type;
	 * var getProperty1 : Property[1] := this.getProperty(type, propertyName);
	 * new:qvtr qvtrPart : qvttemplate::PropertyTemplateItem[1];
	 * set trace.t1propertyName := propertyName;
	 * set qvtrPart.objContainer := qvtrTemplate;
	 * set qvtrPart.referredProperty := getProperty1;
	 * set qvtrPart.value := qvtrExpression;
	 * set trace.t3atlExpression := atlExpression;
	 * set trace.t3atlOutPatternElement := atlOutPatternElement;
	 * set trace.t4qvtrExpression := qvtrExpression;
	 * set trace.t4qvtrPart := qvtrPart;
	 * set trace.t4qvtrTemplate := qvtrTemplate;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 * set trace.wmapSimpleOutPatternElement := when_mapSimpleOutPatternElement;
	 *
	 */
	protected boolean MAP_mmapBinding__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapBinding trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapBinding__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Binding t3atlBinding = trace.getT3atlBinding();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OutPatternElement outPatternElement = t3atlBinding.getOutPatternElement();
		final /*@NonInvalid*/ boolean IsKINDOF_ = outPatternElement instanceof SimpleOutPatternElement;
		/*@Thrown*/ boolean IF_IsKINDOF_;
		if (IsKINDOF_) {
			final /*@NonInvalid*/ @Nullable SimpleOutPatternElement CAST_outPatternElement = (SimpleOutPatternElement)outPatternElement;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression value = t3atlBinding.getValue();
			final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(value);
			final /*@NonInvalid*/ Boolean IsEQ_ = DmapOclExpression != null;
			/*@Thrown*/ Boolean IF_IsEQ_;
			if (IsEQ_) {
				if (DmapOclExpression == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@Thrown*/ @Nullable Boolean s0global = DmapOclExpression.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0global;
				if (s0global) {
					final /*@NonInvalid*/ @Nullable TmapSimpleOutPatternElement TmapSimpleOutPatternElement = OPPOSITE_OF_TmapSimpleOutPatternElement_t3atlElement.get(CAST_outPatternElement);
					final /*@NonInvalid*/ Boolean IsEQ__0 = TmapSimpleOutPatternElement != null;
					/*@Thrown*/ Boolean IF_IsEQ__0;
					if (IsEQ__0) {
						if (TmapSimpleOutPatternElement == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean s0global_0 = TmapSimpleOutPatternElement.getS0global();
						if (s0global_0 == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ boolean IF_s0global_0;
						if (s0global_0) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String propertyName = t3atlBinding.getPropertyName();
							/*@Caught*/ @Nullable Object CAUGHT_d4qvtrExpression;
							try {
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull OCLExpression d4qvtrExpression = DmapOclExpression.getD4qvtrExpression();
								CAUGHT_d4qvtrExpression = d4qvtrExpression;
							}
							catch (Exception THROWN_CAUGHT_d4qvtrExpression) {
								CAUGHT_d4qvtrExpression = ValueUtil.createInvalidValue(THROWN_CAUGHT_d4qvtrExpression);
							}
							/*@Caught*/ @Nullable Object CAUGHT_t4qvtrTemplate;
							try {
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull ObjectTemplateExp t4qvtrTemplate = TmapSimpleOutPatternElement.getT4qvtrTemplate();
								CAUGHT_t4qvtrTemplate = t4qvtrTemplate;
							}
							catch (Exception THROWN_CAUGHT_t4qvtrTemplate) {
								CAUGHT_t4qvtrTemplate = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrTemplate);
							}
							/*@Caught*/ @Nullable Object CAUGHT_type;
							try {
								if (CAUGHT_t4qvtrTemplate instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_t4qvtrTemplate;
								}
								final /*@Thrown*/ @Nullable ObjectTemplateExp THROWN_t4qvtrTemplate = (@Nullable ObjectTemplateExp)CAUGHT_t4qvtrTemplate;
								final /*@Thrown*/ @Nullable Type type = THROWN_t4qvtrTemplate.getType();
								CAUGHT_type = type;
							}
							catch (Exception THROWN_CAUGHT_type) {
								CAUGHT_type = ValueUtil.createInvalidValue(THROWN_CAUGHT_type);
							}
							/*@Caught*/ @Nullable Object CAUGHT_getProperty;
							try {
								if (CAUGHT_type instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_type;
								}
								final /*@Thrown*/ @NonNull Type THROWN_type = (@NonNull Type)CAUGHT_type;
								final /*@Thrown*/ @NonNull Property getProperty_0 = INSTANCE_CACHE_ATL2QVTr_getProperty.evaluate(rootThis, THROWN_type, propertyName);
								CAUGHT_getProperty = getProperty_0;
							}
							catch (Exception THROWN_CAUGHT_getProperty) {
								CAUGHT_getProperty = ValueUtil.createInvalidValue(THROWN_CAUGHT_getProperty);
							}
							// creations
							final @NonNull PropertyTemplateItem qvtrPart = QVTtemplateFactory.eINSTANCE.createPropertyTemplateItem();
							MODEL_qvtr.add(qvtrPart, false);
							if (debugCreations) {
								AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrPart));
							}
							// mapping statements
							trace.setT1propertyName(propertyName);
							if (CAUGHT_t4qvtrTemplate instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_t4qvtrTemplate;
							}
							final /*@Thrown*/ @Nullable ObjectTemplateExp THROWN_t4qvtrTemplate_0 = (@Nullable ObjectTemplateExp)CAUGHT_t4qvtrTemplate;
							qvtrPart.setObjContainer(THROWN_t4qvtrTemplate_0);
							if (CAUGHT_getProperty instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_getProperty;
							}
							final /*@Thrown*/ @Nullable Property THROWN_getProperty = (@Nullable Property)CAUGHT_getProperty;
							qvtrPart.setReferredProperty(THROWN_getProperty);
							if (CAUGHT_d4qvtrExpression instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_d4qvtrExpression;
							}
							final /*@Thrown*/ @Nullable OCLExpression THROWN_d4qvtrExpression = (@Nullable OCLExpression)CAUGHT_d4qvtrExpression;
							qvtrPart.setValue(THROWN_d4qvtrExpression);
							trace.setT3atlExpression(value);
							trace.setT3atlOutPatternElement(CAST_outPatternElement);
							if (CAUGHT_d4qvtrExpression instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_d4qvtrExpression;
							}
							final /*@Thrown*/ @Nullable OCLExpression THROWN_d4qvtrExpression_0 = (@Nullable OCLExpression)CAUGHT_d4qvtrExpression;
							trace.setT4qvtrExpression(THROWN_d4qvtrExpression_0);
							trace.setT4qvtrPart(qvtrPart);
							if (CAUGHT_t4qvtrTemplate instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_t4qvtrTemplate;
							}
							final /*@Thrown*/ @Nullable ObjectTemplateExp THROWN_t4qvtrTemplate_1 = (@Nullable ObjectTemplateExp)CAUGHT_t4qvtrTemplate;
							trace.setT4qvtrTemplate(THROWN_t4qvtrTemplate_1);
							trace.setWmapOclExpression(DmapOclExpression);
							trace.setWmapSimpleOutPatternElement(TmapSimpleOutPatternElement);
							final /*@NonInvalid*/ boolean mmapBinding__qvtr__init__ = ValueUtil.TRUE_VALUE;
							IF_s0global_0 = mmapBinding__qvtr__init__;
						}
						else {
							IF_s0global_0 = ValueUtil.FALSE_VALUE;
						}
						IF_IsEQ__0 = IF_s0global_0;
					}
					else {
						IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
					}
					IF_s0global = IF_IsEQ__0;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ_ = IF_s0global;
			}
			else {
				IF_IsEQ_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsKINDOF_ = IF_IsEQ_;
		}
		else {
			IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0global(IF_IsKINDOF_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_BINDING__S0GLOBAL, IF_IsKINDOF_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsKINDOF_ ? "done "  : "fail ") + "MAP_mmapBinding__qvtr__init__");
		}
		return IF_IsKINDOF_;
	}

	/**
	 *
	 * map:7 mmapHelper__Attribute__qvtr__rest__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * check trace = dispatcher.domapHelper_Attribute;
	 * var qvtrFunction : qvtbase::Function[1] := dispatcher.d4qvtrFunction;
	 * check trace.s0global;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrExpression : OCLExpression[1] := when_mapOclExpression.d4qvtrExpression;
	 * set trace.t4qvtrExpression := qvtrExpression;
	 * set qvtrFunction.queryExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_mmapHelper__Attribute__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapHelper_Attribute trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapHelper__Attribute__qvtr__rest__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlHelper\":" + toDebugString(trace.getDispatcher().getD3atlHelper()) +
					"\n\t\"dispatcher.d4qvtrFunction\":" + toDebugString(trace.getDispatcher().getD4qvtrFunction()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapHelper dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapHelper_Attribute domapHelper_Attribute = dispatcher.getDomapHelper_Attribute();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapHelper_Attribute);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Function d4qvtrFunction = dispatcher.getD4qvtrFunction();
			final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
			if (s0global == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ boolean IF_s0global;
			if (s0global) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace.getWmapOclExpression();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = wmapOclExpression.getD4qvtrExpression();
				// mapping statements
				trace.setT4qvtrExpression(d4qvtrExpression);
				d4qvtrFunction.setQueryExpression(d4qvtrExpression);
				final /*@NonInvalid*/ boolean mmapHelper__Attribute__qvtr__rest__ = ValueUtil.TRUE_VALUE;
				IF_s0global = mmapHelper__Attribute__qvtr__rest__;
			}
			else {
				IF_s0global = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_s0global;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapHelper__Attribute__qvtr__rest__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:7 mmapHelper__Operation__qvtr__rest__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * check trace = dispatcher.domapHelper_Operation;
	 * var qvtrFunction : qvtbase::Function[1] := dispatcher.d4qvtrFunction;
	 * check trace.s0global;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrExpression : OCLExpression[1] := when_mapOclExpression.d4qvtrExpression;
	 * set trace.t4qvtrExpression := qvtrExpression;
	 * set qvtrFunction.queryExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_mmapHelper__Operation__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapHelper_Operation trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapHelper__Operation__qvtr__rest__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlHelper\":" + toDebugString(trace.getDispatcher().getD3atlHelper()) +
					"\n\t\"dispatcher.d4qvtrFunction\":" + toDebugString(trace.getDispatcher().getD4qvtrFunction()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapHelper dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapHelper_Operation domapHelper_Operation = dispatcher.getDomapHelper_Operation();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapHelper_Operation);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Function d4qvtrFunction = dispatcher.getD4qvtrFunction();
			final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
			if (s0global == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ boolean IF_s0global;
			if (s0global) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace.getWmapOclExpression();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = wmapOclExpression.getD4qvtrExpression();
				// mapping statements
				trace.setT4qvtrExpression(d4qvtrExpression);
				d4qvtrFunction.setQueryExpression(d4qvtrExpression);
				final /*@NonInvalid*/ boolean mmapHelper__Operation__qvtr__rest__ = ValueUtil.TRUE_VALUE;
				IF_s0global = mmapHelper__Operation__qvtr__rest__;
			}
			else {
				IF_s0global = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_s0global;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapHelper__Operation__qvtr__rest__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:7 mmapIfExp__qvtr__rest__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapIfExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapIfExp;
	 * check var qvtrExpression : IfExp[1] := dispatcher.d4qvtrExpression;
	 * check trace.s0global;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var when_mapOclExpression1 : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression1;
	 * var when_mapOclExpression2 : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression2;
	 * var qvtrCondition : OCLExpression[1] := when_mapOclExpression1.d4qvtrExpression;
	 * var qvtrElse : OCLExpression[1] := when_mapOclExpression.d4qvtrExpression;
	 * var qvtrThen : OCLExpression[1] := when_mapOclExpression2.d4qvtrExpression;
	 * set trace.t4qvtrCondition := qvtrCondition;
	 * set trace.t4qvtrElse := qvtrElse;
	 * set trace.t4qvtrThen := qvtrThen;
	 * set qvtrExpression.ownedCondition := qvtrCondition;
	 * set qvtrExpression.ownedElse := qvtrElse;
	 * set qvtrExpression.ownedThen := qvtrThen;
	 *
	 */
	protected boolean MAP_mmapIfExp__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapIfExp trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapIfExp__qvtr__rest__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapIfExp domapIfExp = dispatcher.getDomapIfExp();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapIfExp);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = dispatcher.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d4qvtrExpression instanceof org.eclipse.ocl.pivot.IfExp;
			/*@Thrown*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable IfExp CAST_d4qvtrExpression = (org.eclipse.ocl.pivot.IfExp)d4qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0global;
				if (s0global) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace.getWmapOclExpression();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression1 = trace.getWmapOclExpression1();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression2 = trace.getWmapOclExpression2();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression_0 = wmapOclExpression1.getD4qvtrExpression();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression_1 = wmapOclExpression.getD4qvtrExpression();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression_2 = wmapOclExpression2.getD4qvtrExpression();
					// mapping statements
					trace.setT4qvtrCondition(d4qvtrExpression_0);
					trace.setT4qvtrElse(d4qvtrExpression_1);
					trace.setT4qvtrThen(d4qvtrExpression_2);
					CAST_d4qvtrExpression.setOwnedCondition(d4qvtrExpression_0);
					CAST_d4qvtrExpression.setOwnedElse(d4qvtrExpression_1);
					CAST_d4qvtrExpression.setOwnedThen(d4qvtrExpression_2);
					final /*@NonInvalid*/ boolean mmapIfExp__qvtr__rest__ = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapIfExp__qvtr__rest__;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_IsKINDOF_ = IF_s0global;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapIfExp__qvtr__rest__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:7 mmapInPattern__filter__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapInPattern_filter[1] success s0global;
	 * var atlPattern : ATL::InPattern[1] := trace.t3atlPattern;
	 * var when_mapInPattern : trace_ATL2QVTr::TmapInPattern[1] := atlPattern.TmapInPattern;
	 * check when_mapInPattern.s0global;
	 * var atlExpression : OCL::OclExpression[1] := atlPattern.filter;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlExpression.DmapOclExpression;
	 * check when_mapOclExpression.s0global;
	 * var atlRule : ATL::MatchedRule[1] := atlPattern.rule;
	 * var when_mapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1] := atlRule.TmapMatchedRule;
	 * check when_mapMatchedRule.s0global;
	 * var qvtrDomain : qvtrelation::RelationDomain[1] := when_mapInPattern.t4qvtrDomain;
	 * var qvtrExpression : OCLExpression[1] := when_mapOclExpression.d4qvtrExpression;
	 * var qvtrRelation : qvtrelation::Relation[1] := when_mapMatchedRule.t4qvtrRelation;
	 * new:qvtr p : qvtbase::Predicate[1];
	 * new:qvtr w : qvtbase::Pattern[1];
	 * set qvtrDomain.rule := qvtrRelation;
	 * set qvtrRelation.when := w;
	 * set p.conditionExpression := qvtrExpression;
	 * set p.pattern := w;
	 * set trace.t3atlExpression := atlExpression;
	 * set trace.t3atlRule := atlRule;
	 * set trace.t4p := p;
	 * set trace.t4qvtrDomain := qvtrDomain;
	 * set trace.t4qvtrExpression := qvtrExpression;
	 * set trace.t4qvtrRelation := qvtrRelation;
	 * set trace.t4w := w;
	 * set trace.wmapInPattern := when_mapInPattern;
	 * set trace.wmapMatchedRule := when_mapMatchedRule;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected boolean MAP_mmapInPattern__filter__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapInPattern_filter trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapInPattern__filter__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull InPattern t3atlPattern = trace.getT3atlPattern();
		final /*@NonInvalid*/ @Nullable TmapInPattern TmapInPattern = OPPOSITE_OF_TmapInPattern_t3atlPattern.get(t3atlPattern);
		final /*@NonInvalid*/ Boolean IsEQ_ = TmapInPattern != null;
		/*@Thrown*/ Boolean IF_IsEQ_;
		if (IsEQ_) {
			if (TmapInPattern == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean s0global = TmapInPattern.getS0global();
			if (s0global == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ boolean IF_s0global;
			if (s0global) {
				final /*@NonInvalid*/ @Nullable OclExpression filter = t3atlPattern.getFilter();
				final /*@NonInvalid*/ Boolean IsEQ__0 = filter != null;
				/*@Thrown*/ Boolean IF_IsEQ__0;
				if (IsEQ__0) {
					if (filter == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					/*@Caught*/ @Nullable Object CAUGHT_DmapOclExpression;
					try {
						final /*@Thrown*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(filter);
						CAUGHT_DmapOclExpression = DmapOclExpression;
					}
					catch (Exception THROWN_CAUGHT_DmapOclExpression) {
						CAUGHT_DmapOclExpression = ValueUtil.createInvalidValue(THROWN_CAUGHT_DmapOclExpression);
					}
					if (CAUGHT_DmapOclExpression instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_DmapOclExpression;
					}
					final /*@Thrown*/ @Nullable DmapOclExpression THROWN_DmapOclExpression = (@Nullable DmapOclExpression)CAUGHT_DmapOclExpression;
					final /*@Thrown*/ Boolean IsEQ__1 = THROWN_DmapOclExpression != null;
					/*@Thrown*/ Boolean IF_IsEQ__1;
					if (IsEQ__1) {
						/*@Caught*/ @Nullable Object CAUGHT_DmapOclExpression_0;
						try {
							if (THROWN_DmapOclExpression == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							CAUGHT_DmapOclExpression_0 = THROWN_DmapOclExpression;
						}
						catch (Exception THROWN_CAUGHT_DmapOclExpression_0) {
							CAUGHT_DmapOclExpression_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_DmapOclExpression_0);
						}
						if (CAUGHT_DmapOclExpression_0 instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_DmapOclExpression_0;
						}
						final /*@Thrown*/ @Nullable DmapOclExpression THROWN_DmapOclExpression_0 = (@Nullable DmapOclExpression)CAUGHT_DmapOclExpression_0;
						final /*@Thrown*/ @Nullable Boolean s0global_0 = THROWN_DmapOclExpression_0.getS0global();
						if (s0global_0 == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ boolean IF_s0global_0;
						if (s0global_0) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull MatchedRule rule = t3atlPattern.getRule();
							final /*@NonInvalid*/ @Nullable TmapMatchedRule TmapMatchedRule = OPPOSITE_OF_TmapMatchedRule_t3matchedRule.get(rule);
							final /*@NonInvalid*/ Boolean IsEQ__2 = TmapMatchedRule != null;
							/*@Thrown*/ Boolean IF_IsEQ__2;
							if (IsEQ__2) {
								if (TmapMatchedRule == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								final /*@Thrown*/ @Nullable Boolean s0global_1 = TmapMatchedRule.getS0global();
								if (s0global_1 == null) {
									throw new InvalidEvaluationException("Null if condition");
								}
								/*@Thrown*/ boolean IF_s0global_1;
								if (s0global_1) {
									/*@Caught*/ @Nullable Object CAUGHT_t4qvtrDomain;
									try {
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull RelationDomain t4qvtrDomain = TmapInPattern.getT4qvtrDomain();
										CAUGHT_t4qvtrDomain = t4qvtrDomain;
									}
									catch (Exception THROWN_CAUGHT_t4qvtrDomain) {
										CAUGHT_t4qvtrDomain = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrDomain);
									}
									/*@Caught*/ @Nullable Object CAUGHT_d4qvtrExpression;
									try {
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull OCLExpression d4qvtrExpression = THROWN_DmapOclExpression_0.getD4qvtrExpression();
										CAUGHT_d4qvtrExpression = d4qvtrExpression;
									}
									catch (Exception THROWN_CAUGHT_d4qvtrExpression) {
										CAUGHT_d4qvtrExpression = ValueUtil.createInvalidValue(THROWN_CAUGHT_d4qvtrExpression);
									}
									/*@Caught*/ @Nullable Object CAUGHT_t4qvtrRelation;
									try {
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull Relation t4qvtrRelation = TmapMatchedRule.getT4qvtrRelation();
										CAUGHT_t4qvtrRelation = t4qvtrRelation;
									}
									catch (Exception THROWN_CAUGHT_t4qvtrRelation) {
										CAUGHT_t4qvtrRelation = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrRelation);
									}
									// creations
									final @NonNull Predicate p = QVTbaseFactory.eINSTANCE.createPredicate();
									MODEL_qvtr.add(p, false);
									if (debugCreations) {
										AbstractTransformer.CREATIONS.println("created " + toDebugString(p));
									}
									final @NonNull Pattern w = QVTbaseFactory.eINSTANCE.createPattern();
									MODEL_qvtr.add(w, false);
									if (debugCreations) {
										AbstractTransformer.CREATIONS.println("created " + toDebugString(w));
									}
									// mapping statements
									if (CAUGHT_t4qvtrDomain instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrDomain;
									}
									final /*@Thrown*/ @Nullable RelationDomain THROWN_t4qvtrDomain = (@Nullable RelationDomain)CAUGHT_t4qvtrDomain;
									if (CAUGHT_t4qvtrRelation instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrRelation;
									}
									final /*@Thrown*/ @Nullable Relation THROWN_t4qvtrRelation = (@Nullable Relation)CAUGHT_t4qvtrRelation;
									THROWN_t4qvtrDomain.setRule(THROWN_t4qvtrRelation);
									if (CAUGHT_t4qvtrRelation instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrRelation;
									}
									final /*@Thrown*/ @Nullable Relation THROWN_t4qvtrRelation_0 = (@Nullable Relation)CAUGHT_t4qvtrRelation;
									THROWN_t4qvtrRelation_0.setWhen(w);
									if (CAUGHT_d4qvtrExpression instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_d4qvtrExpression;
									}
									final /*@Thrown*/ @Nullable OCLExpression THROWN_d4qvtrExpression = (@Nullable OCLExpression)CAUGHT_d4qvtrExpression;
									p.setConditionExpression(THROWN_d4qvtrExpression);
									p.setPattern(w);
									trace.setT3atlExpression(filter);
									trace.setT3atlRule(rule);
									trace.setT4p(p);
									if (CAUGHT_t4qvtrDomain instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrDomain;
									}
									final /*@Thrown*/ @Nullable RelationDomain THROWN_t4qvtrDomain_0 = (@Nullable RelationDomain)CAUGHT_t4qvtrDomain;
									trace.setT4qvtrDomain(THROWN_t4qvtrDomain_0);
									if (CAUGHT_d4qvtrExpression instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_d4qvtrExpression;
									}
									final /*@Thrown*/ @Nullable OCLExpression THROWN_d4qvtrExpression_0 = (@Nullable OCLExpression)CAUGHT_d4qvtrExpression;
									trace.setT4qvtrExpression(THROWN_d4qvtrExpression_0);
									if (CAUGHT_t4qvtrRelation instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_t4qvtrRelation;
									}
									final /*@Thrown*/ @Nullable Relation THROWN_t4qvtrRelation_1 = (@Nullable Relation)CAUGHT_t4qvtrRelation;
									trace.setT4qvtrRelation(THROWN_t4qvtrRelation_1);
									trace.setT4w(w);
									trace.setWmapInPattern(TmapInPattern);
									trace.setWmapMatchedRule(TmapMatchedRule);
									trace.setWmapOclExpression(THROWN_DmapOclExpression_0);
									final /*@NonInvalid*/ boolean mmapInPattern__filter__qvtr__init__ = ValueUtil.TRUE_VALUE;
									IF_s0global_1 = mmapInPattern__filter__qvtr__init__;
								}
								else {
									IF_s0global_1 = ValueUtil.FALSE_VALUE;
								}
								IF_IsEQ__2 = IF_s0global_1;
							}
							else {
								IF_IsEQ__2 = ValueUtil.FALSE_VALUE;
							}
							IF_s0global_0 = IF_IsEQ__2;
						}
						else {
							IF_s0global_0 = ValueUtil.FALSE_VALUE;
						}
						IF_IsEQ__1 = IF_s0global_0;
					}
					else {
						IF_IsEQ__1 = ValueUtil.FALSE_VALUE;
					}
					IF_IsEQ__0 = IF_IsEQ__1;
				}
				else {
					IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
				}
				IF_s0global = IF_IsEQ__0;
			}
			else {
				IF_s0global = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_s0global;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0global(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_IN_PATTERN_FILTER__S0GLOBAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapInPattern__filter__qvtr__init__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:7 mmapNavigationOrAttributeCallExp__Helper__qvtr__res in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapNavigationOrAttributeCallExp_Helper;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d4qvtrExpression;
	 * check trace.s0global;
	 * var when_mapHelper_Attribute : trace_ATL2QVTr::DmapHelper[1] := trace.wmapHelper;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrOperation : Operation[1] := when_mapHelper_Attribute.d4qvtrFunction;
	 * var qvtrSourceArgument : OCLExpression[1] := when_mapOclExpression.d4qvtrExpression;
	 * set qvtrExpression.ownedArguments := qvtrSourceArgument;
	 * set trace.t4qvtrOperation := qvtrOperation;
	 * set trace.t4qvtrSourceArgument := qvtrSourceArgument;
	 * set qvtrExpression.referredOperation := qvtrOperation;
	 *
	 */
	protected boolean MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__res(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__res" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Helper domapNavigationOrAttributeCallExp_Helper = dispatcher.getDomapNavigationOrAttributeCallExp_Helper();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapNavigationOrAttributeCallExp_Helper);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = dispatcher.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d4qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable OperationCallExp CAST_d4qvtrExpression = (org.eclipse.ocl.pivot.OperationCallExp)d4qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0global;
				if (s0global) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapHelper wmapHelper = trace.getWmapHelper();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace.getWmapOclExpression();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull Function d4qvtrFunction = wmapHelper.getD4qvtrFunction();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression_0 = wmapOclExpression.getD4qvtrExpression();
					// mapping statements
					CAST_d4qvtrExpression.getOwnedArguments().add(d4qvtrExpression_0);
					trace.setT4qvtrOperation(d4qvtrFunction);
					trace.setT4qvtrSourceArgument(d4qvtrExpression_0);
					CAST_d4qvtrExpression.setReferredOperation(d4qvtrFunction);
					final /*@NonInvalid*/ boolean mmapNavigationOrAttributeCallExp__Helper__qvtr__res = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapNavigationOrAttributeCallExp__Helper__qvtr__res;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_IsKINDOF_ = IF_s0global;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__res");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:7 mmapNavigationOrAttributeCallExp__Property__qvtr__r in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapNavigationOrAttributeCallExp_Property;
	 * check var qvtrExpression : PropertyCallExp[1] := dispatcher.d4qvtrExpression;
	 * check trace.s0global;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrSource : OCLExpression[1] := when_mapOclExpression.d4qvtrExpression;
	 * set trace.t4qvtrSource := qvtrSource;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 *
	 */
	protected boolean MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__r(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__r" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Property domapNavigationOrAttributeCallExp_Property = dispatcher.getDomapNavigationOrAttributeCallExp_Property();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapNavigationOrAttributeCallExp_Property);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = dispatcher.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d4qvtrExpression instanceof PropertyCallExp;
			/*@Thrown*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ @Nullable PropertyCallExp CAST_d4qvtrExpression = (PropertyCallExp)d4qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0global;
				if (s0global) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace.getWmapOclExpression();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression_0 = wmapOclExpression.getD4qvtrExpression();
					// mapping statements
					trace.setT4qvtrSource(d4qvtrExpression_0);
					CAST_d4qvtrExpression.setOwnedSource(d4qvtrExpression_0);
					final /*@NonInvalid*/ boolean mmapNavigationOrAttributeCallExp__Property__qvtr__r = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapNavigationOrAttributeCallExp__Property__qvtr__r;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_IsKINDOF_ = IF_s0global;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__r");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:7 mmapOperationCallExp__Helper__qvtr__rest__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperationCallExp_Helper;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d4qvtrExpression;
	 * check trace.s0global;
	 * var when_mapHelper_Operation : trace_ATL2QVTr::DmapHelper[1] := trace.wmapHelper;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrOperation : Operation[1] := when_mapHelper_Operation.d4qvtrFunction;
	 * var qvtrSourceArgument : OCLExpression[1] := when_mapOclExpression.d4qvtrExpression;
	 * set qvtrExpression.ownedArguments := qvtrSourceArgument;
	 * set trace.t4qvtrOperation := qvtrOperation;
	 * set trace.t4qvtrSourceArgument := qvtrSourceArgument;
	 * set qvtrExpression.referredOperation := qvtrOperation;
	 *
	 */
	protected boolean MAP_mmapOperationCallExp__Helper__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperationCallExp__Helper__qvtr__rest__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Helper domapOperationCallExp_Helper = dispatcher.getDomapOperationCallExp_Helper();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapOperationCallExp_Helper);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = dispatcher.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d4qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable OperationCallExp CAST_d4qvtrExpression = (org.eclipse.ocl.pivot.OperationCallExp)d4qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0global;
				if (s0global) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapHelper wmapHelper = trace.getWmapHelper();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace.getWmapOclExpression();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull Function d4qvtrFunction = wmapHelper.getD4qvtrFunction();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression_0 = wmapOclExpression.getD4qvtrExpression();
					// mapping statements
					CAST_d4qvtrExpression.getOwnedArguments().add(d4qvtrExpression_0);
					trace.setT4qvtrOperation(d4qvtrFunction);
					trace.setT4qvtrSourceArgument(d4qvtrExpression_0);
					CAST_d4qvtrExpression.setReferredOperation(d4qvtrFunction);
					final /*@NonInvalid*/ boolean mmapOperationCallExp__Helper__qvtr__rest__ = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapOperationCallExp__Helper__qvtr__rest__;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_IsKINDOF_ = IF_s0global;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapOperationCallExp__Helper__qvtr__rest__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:7 mmapOperationCallExp__Operation__qvtr__rest__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperationCallExp_Operation;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d4qvtrExpression;
	 * check trace.s0global;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrSource : OCLExpression[1] := when_mapOclExpression.d4qvtrExpression;
	 * set trace.t4qvtrSource := qvtrSource;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 *
	 */
	protected boolean MAP_mmapOperationCallExp__Operation__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperationCallExp__Operation__qvtr__rest__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Operation domapOperationCallExp_Operation = dispatcher.getDomapOperationCallExp_Operation();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapOperationCallExp_Operation);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = dispatcher.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d4qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable OperationCallExp CAST_d4qvtrExpression = (org.eclipse.ocl.pivot.OperationCallExp)d4qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0global;
				if (s0global) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace.getWmapOclExpression();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression_0 = wmapOclExpression.getD4qvtrExpression();
					// mapping statements
					trace.setT4qvtrSource(d4qvtrExpression_0);
					CAST_d4qvtrExpression.setOwnedSource(d4qvtrExpression_0);
					final /*@NonInvalid*/ boolean mmapOperationCallExp__Operation__qvtr__rest__ = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapOperationCallExp__Operation__qvtr__rest__;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_IsKINDOF_ = IF_s0global;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapOperationCallExp__Operation__qvtr__rest__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:7 mmapOperationCallExp__argument__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_argument[1] success s0global;
	 * var atlArgument : OCL::OclExpression[1] := trace.t3atlArgument;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlArgument.DmapOclExpression;
	 * check when_mapOclExpression.s0global;
	 * var atlParent : OCL::OperationCallExp[1] := atlArgument.parentOperation;
	 * var when_mapOperationCallExp : trace_ATL2QVTr::DmapOclExpression[1] := atlParent.DmapOclExpression;
	 * check when_mapOperationCallExp.s0global;
	 * check var qvtrParent : OperationCallExp[1] := when_mapOperationCallExp.d4qvtrExpression;
	 * var qvtrArgument : OCLExpression[1] := when_mapOclExpression.d4qvtrExpression;
	 * set qvtrParent.ownedArguments := qvtrArgument;
	 * set trace.t3atlParent := atlParent;
	 * set trace.t4qvtrArgument := qvtrArgument;
	 * set trace.t4qvtrParent := qvtrParent;
	 * set trace.wmapOclExpression1 := when_mapOperationCallExp;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected boolean MAP_mmapOperationCallExp__argument__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_argument trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperationCallExp__argument__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression t3atlArgument = trace.getT3atlArgument();
		final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(t3atlArgument);
		final /*@NonInvalid*/ Boolean IsEQ_ = DmapOclExpression != null;
		/*@Thrown*/ Boolean IF_IsEQ_;
		if (IsEQ_) {
			if (DmapOclExpression == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean s0global = DmapOclExpression.getS0global();
			if (s0global == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ boolean IF_s0global;
			if (s0global) {
				final /*@NonInvalid*/ @Nullable OperationCallExp parentOperation = t3atlArgument.getParentOperation();
				final /*@NonInvalid*/ Boolean IsEQ__0 = parentOperation != null;
				/*@Thrown*/ Boolean IF_IsEQ__0;
				if (IsEQ__0) {
					if (parentOperation == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					/*@Caught*/ @Nullable Object CAUGHT_DmapOclExpression;
					try {
						final /*@Thrown*/ @Nullable DmapOclExpression DmapOclExpression_0 = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(parentOperation);
						CAUGHT_DmapOclExpression = DmapOclExpression_0;
					}
					catch (Exception THROWN_CAUGHT_DmapOclExpression) {
						CAUGHT_DmapOclExpression = ValueUtil.createInvalidValue(THROWN_CAUGHT_DmapOclExpression);
					}
					if (CAUGHT_DmapOclExpression instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_DmapOclExpression;
					}
					final /*@Thrown*/ @Nullable DmapOclExpression THROWN_DmapOclExpression = (@Nullable DmapOclExpression)CAUGHT_DmapOclExpression;
					final /*@Thrown*/ Boolean IsEQ__1 = THROWN_DmapOclExpression != null;
					/*@Thrown*/ Boolean IF_IsEQ__1;
					if (IsEQ__1) {
						/*@Caught*/ @Nullable Object CAUGHT_DmapOclExpression_0;
						try {
							if (THROWN_DmapOclExpression == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							CAUGHT_DmapOclExpression_0 = THROWN_DmapOclExpression;
						}
						catch (Exception THROWN_CAUGHT_DmapOclExpression_0) {
							CAUGHT_DmapOclExpression_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_DmapOclExpression_0);
						}
						if (CAUGHT_DmapOclExpression_0 instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_DmapOclExpression_0;
						}
						final /*@Thrown*/ @Nullable DmapOclExpression THROWN_DmapOclExpression_0 = (@Nullable DmapOclExpression)CAUGHT_DmapOclExpression_0;
						final /*@Thrown*/ @Nullable Boolean s0global_0 = THROWN_DmapOclExpression_0.getS0global();
						if (s0global_0 == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ boolean IF_s0global_0;
						if (s0global_0) {
							/*@Caught*/ @Nullable Object CAUGHT_d4qvtrExpression;
							try {
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull OCLExpression d4qvtrExpression = THROWN_DmapOclExpression_0.getD4qvtrExpression();
								CAUGHT_d4qvtrExpression = d4qvtrExpression;
							}
							catch (Exception THROWN_CAUGHT_d4qvtrExpression) {
								CAUGHT_d4qvtrExpression = ValueUtil.createInvalidValue(THROWN_CAUGHT_d4qvtrExpression);
							}
							if (CAUGHT_d4qvtrExpression instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_d4qvtrExpression;
							}
							final /*@Thrown*/ @Nullable OCLExpression THROWN_d4qvtrExpression = (@Nullable OCLExpression)CAUGHT_d4qvtrExpression;
							final /*@NonInvalid*/ boolean IsKINDOF_ = THROWN_d4qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
							/*@NonInvalid*/ boolean IF_IsKINDOF_;
							if (IsKINDOF_) {
								/*@Caught*/ @Nullable Object CAUGHT_d4qvtrExpression_0;
								try {
									final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable OperationCallExp CAST_d4qvtrExpression = (org.eclipse.ocl.pivot.OperationCallExp)THROWN_d4qvtrExpression;
									CAUGHT_d4qvtrExpression_0 = CAST_d4qvtrExpression;
								}
								catch (Exception THROWN_CAUGHT_d4qvtrExpression_0) {
									CAUGHT_d4qvtrExpression_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_d4qvtrExpression_0);
								}
								/*@Caught*/ @Nullable Object CAUGHT_d4qvtrExpression_1;
								try {
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull OCLExpression d4qvtrExpression_0 = DmapOclExpression.getD4qvtrExpression();
									CAUGHT_d4qvtrExpression_1 = d4qvtrExpression_0;
								}
								catch (Exception THROWN_CAUGHT_d4qvtrExpression_1) {
									CAUGHT_d4qvtrExpression_1 = ValueUtil.createInvalidValue(THROWN_CAUGHT_d4qvtrExpression_1);
								}
								// mapping statements
								if (CAUGHT_d4qvtrExpression_0 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_d4qvtrExpression_0;
								}
								final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable OperationCallExp THROWN_d4qvtrExpression_1 = (org.eclipse.ocl.pivot.@Nullable OperationCallExp)CAUGHT_d4qvtrExpression_0;
								if (CAUGHT_d4qvtrExpression_1 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_d4qvtrExpression_1;
								}
								final /*@Thrown*/ @Nullable OCLExpression THROWN_d4qvtrExpression_0 = (@Nullable OCLExpression)CAUGHT_d4qvtrExpression_1;
								THROWN_d4qvtrExpression_1.getOwnedArguments().add(THROWN_d4qvtrExpression_0);
								trace.setT3atlParent(parentOperation);
								if (CAUGHT_d4qvtrExpression_1 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_d4qvtrExpression_1;
								}
								final /*@Thrown*/ @Nullable OCLExpression THROWN_d4qvtrExpression_2 = (@Nullable OCLExpression)CAUGHT_d4qvtrExpression_1;
								trace.setT4qvtrArgument(THROWN_d4qvtrExpression_2);
								if (CAUGHT_d4qvtrExpression_0 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_d4qvtrExpression_0;
								}
								final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable OperationCallExp THROWN_d4qvtrExpression_3 = (org.eclipse.ocl.pivot.@Nullable OperationCallExp)CAUGHT_d4qvtrExpression_0;
								trace.setT4qvtrParent(THROWN_d4qvtrExpression_3);
								trace.setWmapOclExpression1(THROWN_DmapOclExpression_0);
								trace.setWmapOclExpression(DmapOclExpression);
								final /*@NonInvalid*/ boolean mmapOperationCallExp__argument__qvtr__init__ = ValueUtil.TRUE_VALUE;
								IF_IsKINDOF_ = mmapOperationCallExp__argument__qvtr__init__;
							}
							else {
								IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
							}
							IF_s0global_0 = IF_IsKINDOF_;
						}
						else {
							IF_s0global_0 = ValueUtil.FALSE_VALUE;
						}
						IF_IsEQ__1 = IF_s0global_0;
					}
					else {
						IF_IsEQ__1 = ValueUtil.FALSE_VALUE;
					}
					IF_IsEQ__0 = IF_IsEQ__1;
				}
				else {
					IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
				}
				IF_s0global = IF_IsEQ__0;
			}
			else {
				IF_s0global = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_s0global;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0global(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_ARGUMENT__S0GLOBAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapOperationCallExp__argument__qvtr__init__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:7 mmapOperatorCallExp__qvtr__rest__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperatorCallExp;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d4qvtrExpression;
	 * check trace.s0global;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrSource : OCLExpression[1] := when_mapOclExpression.d4qvtrExpression;
	 * set trace.t4qvtrSource := qvtrSource;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 *
	 */
	protected boolean MAP_mmapOperatorCallExp__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperatorCallExp__qvtr__rest__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher.getDomapOperatorCallExp();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapOperatorCallExp);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = dispatcher.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d4qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable OperationCallExp CAST_d4qvtrExpression = (org.eclipse.ocl.pivot.OperationCallExp)d4qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0global;
				if (s0global) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace.getWmapOclExpression();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression_0 = wmapOclExpression.getD4qvtrExpression();
					// mapping statements
					trace.setT4qvtrSource(d4qvtrExpression_0);
					CAST_d4qvtrExpression.setOwnedSource(d4qvtrExpression_0);
					final /*@NonInvalid*/ boolean mmapOperatorCallExp__qvtr__rest__ = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapOperatorCallExp__qvtr__rest__;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_IsKINDOF_ = IF_s0global;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapOperatorCallExp__qvtr__rest__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:7 mmapVariableExp__referredVariable__VariableDeclarat in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1] success s0local;
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 * check trace = dispatcher.domapVariableExp_referredVariable_VariableDeclaration;
	 * var atlExpression : OCL::VariableExp[1] := dispatcher.d3atlExpression;
	 * var qvtrExpression : VariableExp[1] := dispatcher.d4qvtrExpression;
	 * check var atlVariable : ATL::PatternElement[1] := atlExpression.referredVariable;
	 * var when_mapVariable : trace_ATL2QVTr::TmapVariable[1] := atlVariable.TmapVariable;
	 * var qvtrVariable : VariableDeclaration[1] := when_mapVariable.t4qvtrVariable;
	 * var name : String[?] := qvtrVariable.name;
	 * var type : Type[?] := qvtrVariable.type;
	 * set qvtrExpression.name := name;
	 * set dispatcher.result := trace;
	 * set qvtrExpression.referredVariable := qvtrVariable;
	 * notify set qvtrExpression.type := type;
	 * set trace.t3atlVariable := atlVariable;
	 * set trace.t4qvtrVariable := qvtrVariable;
	 *
	 */
	protected boolean MAP_mmapVariableExp__referredVariable__VariableDeclarat(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_VariableDeclaration trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariableExp__referredVariable__VariableDeclarat" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_VariableDeclaration domapVariableExp_referredVariable_VariableDeclaration = dispatcher.getDomapVariableExp_referredVariable_VariableDeclaration();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapVariableExp_referredVariable_VariableDeclaration);
		/*@NonInvalid*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull VariableExp d3atlExpression = dispatcher.getD3atlExpression();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp d4qvtrExpression = dispatcher.getD4qvtrExpression();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableDeclaration referredVariable = d3atlExpression.getReferredVariable();
			final /*@NonInvalid*/ boolean IsKINDOF_ = referredVariable instanceof PatternElement;
			/*@NonInvalid*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ @Nullable PatternElement CAST_referredVariable = (PatternElement)referredVariable;
				final /*@NonInvalid*/ @Nullable TmapVariable TmapVariable = OPPOSITE_OF_TmapVariable_t3atlVariable.get(CAST_referredVariable);
				final /*@NonInvalid*/ Boolean IsEQ__0 = TmapVariable != null;
				/*@NonInvalid*/ Boolean IF_IsEQ__0;
				if (IsEQ__0) {
					if (TmapVariable == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					/*@Caught*/ @Nullable Object CAUGHT_t4qvtrVariable;
					try {
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull VariableDeclaration t4qvtrVariable = TmapVariable.getT4qvtrVariable();
						CAUGHT_t4qvtrVariable = t4qvtrVariable;
					}
					catch (Exception THROWN_CAUGHT_t4qvtrVariable) {
						CAUGHT_t4qvtrVariable = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrVariable);
					}
					/*@Caught*/ @Nullable Object CAUGHT_name;
					try {
						if (CAUGHT_t4qvtrVariable instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_t4qvtrVariable;
						}
						final /*@Thrown*/ @Nullable VariableDeclaration THROWN_t4qvtrVariable = (@Nullable VariableDeclaration)CAUGHT_t4qvtrVariable;
						final /*@Thrown*/ @Nullable String name = THROWN_t4qvtrVariable.getName();
						CAUGHT_name = name;
					}
					catch (Exception THROWN_CAUGHT_name) {
						CAUGHT_name = ValueUtil.createInvalidValue(THROWN_CAUGHT_name);
					}
					/*@Caught*/ @Nullable Object CAUGHT_type;
					try {
						if (CAUGHT_t4qvtrVariable instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_t4qvtrVariable;
						}
						final /*@Thrown*/ @Nullable VariableDeclaration THROWN_t4qvtrVariable_0 = (@Nullable VariableDeclaration)CAUGHT_t4qvtrVariable;
						final /*@Thrown*/ @Nullable Type type = THROWN_t4qvtrVariable_0.getType();
						CAUGHT_type = type;
					}
					catch (Exception THROWN_CAUGHT_type) {
						CAUGHT_type = ValueUtil.createInvalidValue(THROWN_CAUGHT_type);
					}
					// mapping statements
					if (CAUGHT_name instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_name;
					}
					final /*@Thrown*/ @Nullable String THROWN_name = (@Nullable String)CAUGHT_name;
					d4qvtrExpression.setName(THROWN_name);
					dispatcher.setResult(trace);
					if (CAUGHT_t4qvtrVariable instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_t4qvtrVariable;
					}
					final /*@Thrown*/ @Nullable VariableDeclaration THROWN_t4qvtrVariable_1 = (@Nullable VariableDeclaration)CAUGHT_t4qvtrVariable;
					d4qvtrExpression.setReferredVariable(THROWN_t4qvtrVariable_1);
					if (CAUGHT_type instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_type;
					}
					final /*@Thrown*/ @Nullable Type THROWN_type = (@Nullable Type)CAUGHT_type;
					d4qvtrExpression.setType(THROWN_type);
					objectManager.assigned(d4qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, THROWN_type, false);
					trace.setT3atlVariable(CAST_referredVariable);
					if (CAUGHT_t4qvtrVariable instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_t4qvtrVariable;
					}
					final /*@Thrown*/ @Nullable VariableDeclaration THROWN_t4qvtrVariable_2 = (@Nullable VariableDeclaration)CAUGHT_t4qvtrVariable;
					trace.setT4qvtrVariable(THROWN_t4qvtrVariable_2);
					final /*@NonInvalid*/ boolean mmapVariableExp__referredVariable__VariableDeclarat = ValueUtil.TRUE_VALUE;
					IF_IsEQ__0 = mmapVariableExp__referredVariable__VariableDeclarat;
				}
				else {
					IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
				}
				IF_IsKINDOF_ = IF_IsEQ__0;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0local(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__S0LOCAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapVariableExp__referredVariable__VariableDeclarat");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:7 mmapVariable__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariable[1] success s0global;
	 * var atlVariable : ATL::LocatedElement[1] := trace.t3atlVariable;
	 * var qvtrVariable : VariableDeclaration[1] := trace.t4qvtrVariable;
	 *
	 */
	protected boolean MAP_mmapVariable__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapVariable trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariable__qvtr__init__" +
					"\n\t\"trace\":" + toDebugString(trace));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull LocatedElement t3atlVariable = trace.getT3atlVariable();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull VariableDeclaration t4qvtrVariable = trace.getT4qvtrVariable();
		// mapping statements
		final /*@NonInvalid*/ boolean mmapVariable__qvtr__init__ = ValueUtil.TRUE_VALUE;
		trace.setS0global(mmapVariable__qvtr__init__);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TMAP_VARIABLE__S0GLOBAL, mmapVariable__qvtr__init__, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapVariable__qvtr__init__ ? "done "  : "fail ") + "MAP_mmapVariable__qvtr__init__");
		}
		return mmapVariable__qvtr__init__;
	}

	/**
	 *
	 * map:8 mmapNavigationOrAttributeCallExp__Helper__qvtr__xtr in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapNavigationOrAttributeCallExp_Helper;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d4qvtrExpression;
	 * check trace.s0global;
	 * var qvtrOperation : Operation[1] := trace.t4qvtrOperation;
	 * var type : Type[?] := qvtrOperation.type;
	 * notify set qvtrExpression.type := type;
	 *
	 */
	protected boolean MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__xtr(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__xtr" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Helper domapNavigationOrAttributeCallExp_Helper = dispatcher.getDomapNavigationOrAttributeCallExp_Helper();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapNavigationOrAttributeCallExp_Helper);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = dispatcher.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d4qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable OperationCallExp CAST_d4qvtrExpression = (org.eclipse.ocl.pivot.OperationCallExp)d4qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0global;
				if (s0global) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull Operation t4qvtrOperation = trace.getT4qvtrOperation();
					final /*@NonInvalid*/ @Nullable Type type = t4qvtrOperation.getType();
					// mapping statements
					CAST_d4qvtrExpression.setType(type);
					objectManager.assigned(CAST_d4qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type, false);
					final /*@NonInvalid*/ boolean mmapNavigationOrAttributeCallExp__Helper__qvtr__xtr = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapNavigationOrAttributeCallExp__Helper__qvtr__xtr;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_IsKINDOF_ = IF_s0global;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__xtr");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:8 mmapOperationCallExp__Helper__qvtr__xtra__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperationCallExp_Helper;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d4qvtrExpression;
	 * check trace.s0global;
	 * var qvtrOperation : Operation[1] := trace.t4qvtrOperation;
	 * var type : Type[?] := qvtrOperation.type;
	 * notify set qvtrExpression.type := type;
	 *
	 */
	protected boolean MAP_mmapOperationCallExp__Helper__qvtr__xtra__(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperationCallExp__Helper__qvtr__xtra__" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Helper domapOperationCallExp_Helper = dispatcher.getDomapOperationCallExp_Helper();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapOperationCallExp_Helper);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = dispatcher.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean IsKINDOF_ = d4qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ boolean IF_IsKINDOF_;
			if (IsKINDOF_) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable OperationCallExp CAST_d4qvtrExpression = (org.eclipse.ocl.pivot.OperationCallExp)d4qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0global;
				if (s0global) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull Operation t4qvtrOperation = trace.getT4qvtrOperation();
					final /*@NonInvalid*/ @Nullable Type type = t4qvtrOperation.getType();
					// mapping statements
					CAST_d4qvtrExpression.setType(type);
					objectManager.assigned(CAST_d4qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type, false);
					final /*@NonInvalid*/ boolean mmapOperationCallExp__Helper__qvtr__xtra__ = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapOperationCallExp__Helper__qvtr__xtra__;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_IsKINDOF_ = IF_s0global;
			}
			else {
				IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsKINDOF_;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapOperationCallExp__Helper__qvtr__xtra__");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:8 mmapVariableExp__referredVariable__Helper__qvtr__lo in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1] success s0global;
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 * check trace = dispatcher.domapVariableExp_referredVariable_Helper;
	 * var qvtrExpression : VariableExp[1] := dispatcher.d4qvtrExpression;
	 * check trace.s0local;
	 * var atlHelper : ATL::Helper[1] := trace.t3atlHelper;
	 * var when_mapVariable : trace_ATL2QVTr::TmapVariable[1] := atlHelper.TmapVariable;
	 * speculate when_mapVariable.s0global;
	 * var qvtrVariable : VariableDeclaration[1] := when_mapVariable.t4qvtrVariable;
	 * set qvtrExpression.name := 'self';
	 * set dispatcher.s0global := true;
	 * set qvtrExpression.referredVariable := qvtrVariable;
	 * set trace.t4qvtrVariable := qvtrVariable;
	 *
	 */
	protected class MAP_mmapVariableExp__referredVariable__Helper__qvtr__lo extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_Helper trace;

		public MAP_mmapVariableExp__referredVariable__Helper__qvtr__lo(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace = (@NonNull TmapVariableExp_referredVariable_Helper)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher = trace.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_Helper domapVariableExp_referredVariable_Helper = dispatcher.getDomapVariableExp_referredVariable_Helper();
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapVariableExp_referredVariable_Helper);
			/*@Thrown*/ boolean IF_IsEQ_;
			if (IsEQ_) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp d4qvtrExpression = dispatcher.getD4qvtrExpression();
				final /*@NonInvalid*/ @Nullable Boolean s0local = trace.getS0local();
				if (s0local == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ boolean IF_s0local;
				if (s0local) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull Helper t3atlHelper = trace.getT3atlHelper();
					final /*@NonInvalid*/ @Nullable TmapVariable TmapVariable = OPPOSITE_OF_TmapVariable_t3atlVariable.get(t3atlHelper);
					final /*@NonInvalid*/ Boolean IsEQ__0 = TmapVariable != null;
					/*@NonInvalid*/ @Nullable Boolean IF_IsEQ__0;
					if (IsEQ__0) {
						if (TmapVariable == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						SlotState.@NonNull Speculating outputSpeculatingSlotState = objectManager.getSpeculatingSlotState(trace, trace_ATL2QVTrPackage.Literals.IMAP_VARIABLE_EXP_REFERRED_VARIABLE__S0GLOBAL);
						Boolean outputSpeculatingSlotStatus = outputSpeculatingSlotState.getSpeculationStatus();
						if (outputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
							if (outputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
								trace.setS0global(ValueUtil.FALSE_VALUE);
								return ValueUtil.FALSE_VALUE;
							}
							SlotState.@NonNull Speculating inputSpeculatingSlotState;
							Boolean inputSpeculatingSlotStatus;
							boolean needsSpeculation = false;
							if (TmapVariable == null) {
								throw new InvalidEvaluationException("Null TmapVariable speculation source");
							}
							inputSpeculatingSlotState = objectManager.getSpeculatingSlotState(TmapVariable, trace_ATL2QVTrPackage.Literals.TMAP_VARIABLE__S0GLOBAL);
							inputSpeculatingSlotStatus = inputSpeculatingSlotState.getSpeculationStatus();
							if (inputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
								if (inputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
									TmapVariable.setS0global(ValueUtil.FALSE_VALUE);
									return ValueUtil.FALSE_VALUE;
								}
								if (outputSpeculatingSlotState != inputSpeculatingSlotState) {
									outputSpeculatingSlotState.addInput(inputSpeculatingSlotState);
									needsSpeculation = true;
								}
							}
							if (needsSpeculation) {
								throw new InvocationFailedException(outputSpeculatingSlotState, true);
							}
						}
						boolean SPEC_ = true;
						/*@Caught*/ @Nullable Object CAUGHT_t4qvtrVariable;
						try {
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull VariableDeclaration t4qvtrVariable = TmapVariable.getT4qvtrVariable();
							CAUGHT_t4qvtrVariable = t4qvtrVariable;
						}
						catch (Exception THROWN_CAUGHT_t4qvtrVariable) {
							CAUGHT_t4qvtrVariable = ValueUtil.createInvalidValue(THROWN_CAUGHT_t4qvtrVariable);
						}
						// mapping statements
						d4qvtrExpression.setName(STR_self);
						dispatcher.setS0global(ValueUtil.TRUE_VALUE);
						if (CAUGHT_t4qvtrVariable instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_t4qvtrVariable;
						}
						final /*@Thrown*/ @Nullable VariableDeclaration THROWN_t4qvtrVariable = (@Nullable VariableDeclaration)CAUGHT_t4qvtrVariable;
						d4qvtrExpression.setReferredVariable(THROWN_t4qvtrVariable);
						if (CAUGHT_t4qvtrVariable instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_t4qvtrVariable;
						}
						final /*@Thrown*/ @Nullable VariableDeclaration THROWN_t4qvtrVariable_0 = (@Nullable VariableDeclaration)CAUGHT_t4qvtrVariable;
						trace.setT4qvtrVariable(THROWN_t4qvtrVariable_0);
						final /*@NonInvalid*/ boolean mmapVariableExp__referredVariable__Helper__qvtr__lo = ValueUtil.TRUE_VALUE;
						IF_IsEQ__0 = SPEC_;
					}
					else {
						IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
					}
					IF_s0local = IF_IsEQ__0;
				}
				else {
					IF_s0local = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ_ = IF_s0local;
			}
			else {
				IF_IsEQ_ = ValueUtil.FALSE_VALUE;
			}
			trace.setS0global(IF_IsEQ_);
			objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.IMAP_VARIABLE_EXP_REFERRED_VARIABLE__S0GLOBAL, IF_IsEQ_, false);
			return IF_IsEQ_;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace, thoseValues[0]);
		}
	}

	/**
	 *
	 * map:8 mmapVariableExp__referredVariable__VariableDeclarat_1 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1] success s0global;
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 * check trace = dispatcher.domapVariableExp_referredVariable_VariableDeclaration;
	 * check trace.s0local;
	 * var qvtrVariable : VariableDeclaration[1] := trace.t4qvtrVariable;
	 * var when_mapVariable : trace_ATL2QVTr::TmapVariable[1] := qvtrVariable.TmapVariable;
	 * set dispatcher.s0global := true;
	 *
	 */
	protected boolean MAP_mmapVariableExp__referredVariable__VariableDeclarat_1(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_VariableDeclaration trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariableExp__referredVariable__VariableDeclarat_1" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_VariableDeclaration domapVariableExp_referredVariable_VariableDeclaration = dispatcher.getDomapVariableExp_referredVariable_VariableDeclaration();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapVariableExp_referredVariable_VariableDeclaration);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			final /*@NonInvalid*/ @Nullable Boolean s0local = trace.getS0local();
			if (s0local == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ boolean IF_s0local;
			if (s0local) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull VariableDeclaration t4qvtrVariable = trace.getT4qvtrVariable();
				final /*@NonInvalid*/ @Nullable TmapVariable TmapVariable = OPPOSITE_OF_TmapVariable_t4qvtrVariable.get(t4qvtrVariable);
				final /*@NonInvalid*/ Boolean IsEQ__0 = TmapVariable != null;
				/*@NonInvalid*/ Boolean IF_IsEQ__0;
				if (IsEQ__0) {
					if (TmapVariable == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					// mapping statements
					dispatcher.setS0global(ValueUtil.TRUE_VALUE);
					final /*@NonInvalid*/ boolean mmapVariableExp__referredVariable__VariableDeclarat_1 = ValueUtil.TRUE_VALUE;
					IF_IsEQ__0 = mmapVariableExp__referredVariable__VariableDeclarat_1;
				}
				else {
					IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
				}
				IF_s0local = IF_IsEQ__0;
			}
			else {
				IF_s0local = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_s0local;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		trace.setS0global(IF_IsEQ_);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.IMAP_VARIABLE_EXP_REFERRED_VARIABLE__S0GLOBAL, IF_IsEQ_, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapVariableExp__referredVariable__VariableDeclarat_1");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:9 mmapVariableExp__referredVariable__Helper__qvtr__xt in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 * check trace = dispatcher.domapVariableExp_referredVariable_Helper;
	 * var qvtrExpression : VariableExp[1] := dispatcher.d4qvtrExpression;
	 * check trace.s0global;
	 * var qvtrVariable : VariableDeclaration[1] := trace.t4qvtrVariable;
	 * var type : Type[?] := qvtrVariable.type;
	 * notify set qvtrExpression.type := type;
	 *
	 */
	protected boolean MAP_mmapVariableExp__referredVariable__Helper__qvtr__xt(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_Helper trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariableExp__referredVariable__Helper__qvtr__xt" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace.getDispatcher().getD3atlExpression()) +
					"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_Helper domapVariableExp_referredVariable_Helper = dispatcher.getDomapVariableExp_referredVariable_Helper();
		final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapVariableExp_referredVariable_Helper);
		/*@Thrown*/ boolean IF_IsEQ_;
		if (IsEQ_) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp d4qvtrExpression = dispatcher.getD4qvtrExpression();
			final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
			if (s0global == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ boolean IF_s0global;
			if (s0global) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull VariableDeclaration t4qvtrVariable = trace.getT4qvtrVariable();
				final /*@NonInvalid*/ @Nullable Type type = t4qvtrVariable.getType();
				// mapping statements
				d4qvtrExpression.setType(type);
				objectManager.assigned(d4qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type, false);
				final /*@NonInvalid*/ boolean mmapVariableExp__referredVariable__Helper__qvtr__xt = ValueUtil.TRUE_VALUE;
				IF_s0global = mmapVariableExp__referredVariable__Helper__qvtr__xt;
			}
			else {
				IF_s0global = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_s0global;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapVariableExp__referredVariable__Helper__qvtr__xt");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:9 mmapVariableExp__referredVariable__verdict__qvtr in ATL2QVTr {
	 * guard:middle mapVariableExp_referredVariable : trace_ATL2QVTr::DmapVariableExp_referredVariable[1];
	 * var mapVariableExp_referredVariable_Helper : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1] := mapVariableExp_referredVariable.domapVariableExp_referredVariable_Helper;
	 * check mapVariableExp_referredVariable_Helper.s0global = false;
	 * var mapVariableExp_referredVariable_VariableDeclaration : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1] := mapVariableExp_referredVariable.domapVariableExp_referredVariable_VariableDeclaration;
	 * check mapVariableExp_referredVariable_VariableDeclaration.s0global = false;
	 * set mapVariableExp_referredVariable.s0global := false;
	 *
	 */
	protected boolean MAP_mmapVariableExp__referredVariable__verdict__qvtr(final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable mapVariableExp_referredVariable)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariableExp__referredVariable__verdict__qvtr" +
					"\n\t\"mapVariableExp_referredVariable\":" + toDebugString(mapVariableExp_referredVariable));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
		final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_Helper domapVariableExp_referredVariable_Helper = mapVariableExp_referredVariable.getDomapVariableExp_referredVariable_Helper();
		final /*@NonInvalid*/ Boolean IsEQ_ = domapVariableExp_referredVariable_Helper != null;
		/*@Thrown*/ Boolean IF_IsEQ_;
		if (IsEQ_) {
			if (domapVariableExp_referredVariable_Helper == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean s0global = domapVariableExp_referredVariable_Helper.getS0global();
			final /*@Thrown*/ boolean IsEQ__0 = s0global == Boolean.FALSE;
			/*@Thrown*/ boolean IF_IsEQ__0;
			if (IsEQ__0) {
				final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_VariableDeclaration domapVariableExp_referredVariable_VariableDeclaration = mapVariableExp_referredVariable.getDomapVariableExp_referredVariable_VariableDeclaration();
				final /*@NonInvalid*/ Boolean IsEQ__1 = domapVariableExp_referredVariable_VariableDeclaration != null;
				/*@Thrown*/ Boolean IF_IsEQ__1;
				if (IsEQ__1) {
					if (domapVariableExp_referredVariable_VariableDeclaration == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable Boolean s0global_0 = domapVariableExp_referredVariable_VariableDeclaration.getS0global();
					final /*@Thrown*/ boolean IsEQ__2 = s0global_0 == Boolean.FALSE;
					/*@Thrown*/ boolean IF_IsEQ__2;
					if (IsEQ__2) {
						// mapping statements
						mapVariableExp_referredVariable.setS0global(ValueUtil.FALSE_VALUE);
						final /*@NonInvalid*/ boolean mmapVariableExp__referredVariable__verdict__qvtr = ValueUtil.TRUE_VALUE;
						IF_IsEQ__2 = mmapVariableExp__referredVariable__verdict__qvtr;
					}
					else {
						IF_IsEQ__2 = ValueUtil.FALSE_VALUE;
					}
					IF_IsEQ__1 = IF_IsEQ__2;
				}
				else {
					IF_IsEQ__1 = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ__0 = IF_IsEQ__1;
			}
			else {
				IF_IsEQ__0 = ValueUtil.FALSE_VALUE;
			}
			IF_IsEQ_ = IF_IsEQ__0;
		}
		else {
			IF_IsEQ_ = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_IsEQ_ ? "done "  : "fail ") + "MAP_mmapVariableExp__referredVariable__verdict__qvtr");
		}
		return IF_IsEQ_;
	}

	/**
	 *
	 * map:10 mmapIfExp__qvtr__xtra__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapIfExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapIfExp;
	 * check var qvtrExpression : IfExp[1] := dispatcher.d4qvtrExpression;
	 * check trace.s0global;
	 * var qvtrThen : OCLExpression[1] := trace.t4qvtrThen;
	 * observe ocl::TypedElement::type var type : Type[?] := qvtrThen.type;
	 * var qvtrElse : OCLExpression[1] := trace.t4qvtrElse;
	 * observe ocl::TypedElement::type var type1 : Type[?] := qvtrElse.type;
	 * var getCommonType1 : Type[1] := this.getCommonType(type, type1);
	 * notify set qvtrExpression.type := getCommonType1;
	 *
	 */
	protected class MAP_mmapIfExp__qvtr__xtra__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapIfExp trace;

		public MAP_mmapIfExp__qvtr__xtra__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace = (@NonNull TmapIfExp)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapIfExp domapIfExp = dispatcher.getDomapIfExp();
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapIfExp);
			/*@Thrown*/ boolean IF_IsEQ_;
			if (IsEQ_) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = dispatcher.getD4qvtrExpression();
				final /*@NonInvalid*/ boolean IsKINDOF_ = d4qvtrExpression instanceof org.eclipse.ocl.pivot.IfExp;
				/*@Thrown*/ boolean IF_IsKINDOF_;
				if (IsKINDOF_) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable IfExp CAST_d4qvtrExpression = (org.eclipse.ocl.pivot.IfExp)d4qvtrExpression;
					final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
					if (s0global == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ boolean IF_s0global;
					if (s0global) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OCLExpression t4qvtrThen = trace.getT4qvtrThen();
						objectManager.getting(t4qvtrThen, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@NonInvalid*/ @NonNull Type type = t4qvtrThen.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OCLExpression t4qvtrElse = trace.getT4qvtrElse();
						objectManager.getting(t4qvtrElse, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@NonInvalid*/ @NonNull Type type_0 = t4qvtrElse.getType();
						/*@Caught*/ @Nullable Object CAUGHT_getCommonType;
						try {
							final /*@Thrown*/ @NonNull Type getCommonType_0 = INSTANCE_CACHE_ATL2QVTr_getCommonType.evaluate(rootThis, type, type_0);
							CAUGHT_getCommonType = getCommonType_0;
						}
						catch (Exception THROWN_CAUGHT_getCommonType) {
							CAUGHT_getCommonType = ValueUtil.createInvalidValue(THROWN_CAUGHT_getCommonType);
						}
						// mapping statements
						if (CAUGHT_getCommonType instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_getCommonType;
						}
						final /*@Thrown*/ @Nullable Type THROWN_getCommonType = (@Nullable Type)CAUGHT_getCommonType;
						CAST_d4qvtrExpression.setType(THROWN_getCommonType);
						objectManager.assigned(CAST_d4qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, THROWN_getCommonType, false);
						final /*@NonInvalid*/ boolean mmapIfExp__qvtr__xtra__ = ValueUtil.TRUE_VALUE;
						IF_s0global = mmapIfExp__qvtr__xtra__;
					}
					else {
						IF_s0global = ValueUtil.FALSE_VALUE;
					}
					IF_IsKINDOF_ = IF_s0global;
				}
				else {
					IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ_ = IF_IsKINDOF_;
			}
			else {
				IF_IsEQ_ = ValueUtil.FALSE_VALUE;
			}
			return IF_IsEQ_;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:10 mmapNavigationOrAttributeCallExp__Property__qvtr__x in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapNavigationOrAttributeCallExp_Property;
	 * check var qvtrExpression : PropertyCallExp[1] := dispatcher.d4qvtrExpression;
	 * check trace.s0global;
	 * var qvtrSource : OCLExpression[1] := trace.t4qvtrSource;
	 * observe ocl::TypedElement::type var type : Type[?] := qvtrSource.type;
	 * var propertyName : String[1] := trace.t1propertyName;
	 * var qvtrProperty : Property[1] := this.getProperty(type, propertyName);
	 * var type1 : Type[?] := qvtrProperty.type;
	 * set trace.t4qvtrProperty := qvtrProperty;
	 * set qvtrExpression.referredProperty := qvtrProperty;
	 * notify set qvtrExpression.type := type1;
	 *
	 */
	protected class MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__x extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace;

		public MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__x(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace = (@NonNull TmapNavigationOrAttributeCallExp_Property)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Property domapNavigationOrAttributeCallExp_Property = dispatcher.getDomapNavigationOrAttributeCallExp_Property();
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapNavigationOrAttributeCallExp_Property);
			/*@Thrown*/ boolean IF_IsEQ_;
			if (IsEQ_) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = dispatcher.getD4qvtrExpression();
				final /*@NonInvalid*/ boolean IsKINDOF_ = d4qvtrExpression instanceof PropertyCallExp;
				/*@Thrown*/ boolean IF_IsKINDOF_;
				if (IsKINDOF_) {
					final /*@NonInvalid*/ @Nullable PropertyCallExp CAST_d4qvtrExpression = (PropertyCallExp)d4qvtrExpression;
					final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
					if (s0global == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ boolean IF_s0global;
					if (s0global) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OCLExpression t4qvtrSource = trace.getT4qvtrSource();
						objectManager.getting(t4qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@NonInvalid*/ @NonNull Type type = t4qvtrSource.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t1propertyName = trace.getT1propertyName();
						/*@Caught*/ @Nullable Object CAUGHT_getProperty;
						try {
							final /*@Thrown*/ @NonNull Property getProperty_0 = INSTANCE_CACHE_ATL2QVTr_getProperty.evaluate(rootThis, type, t1propertyName);
							CAUGHT_getProperty = getProperty_0;
						}
						catch (Exception THROWN_CAUGHT_getProperty) {
							CAUGHT_getProperty = ValueUtil.createInvalidValue(THROWN_CAUGHT_getProperty);
						}
						/*@Caught*/ @Nullable Object CAUGHT_type;
						try {
							if (CAUGHT_getProperty instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_getProperty;
							}
							final /*@Thrown*/ @Nullable Property THROWN_getProperty = (@Nullable Property)CAUGHT_getProperty;
							final /*@Thrown*/ @Nullable Type type_0 = THROWN_getProperty.getType();
							CAUGHT_type = type_0;
						}
						catch (Exception THROWN_CAUGHT_type) {
							CAUGHT_type = ValueUtil.createInvalidValue(THROWN_CAUGHT_type);
						}
						// mapping statements
						if (CAUGHT_getProperty instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_getProperty;
						}
						final /*@Thrown*/ @Nullable Property THROWN_getProperty_0 = (@Nullable Property)CAUGHT_getProperty;
						trace.setT4qvtrProperty(THROWN_getProperty_0);
						if (CAUGHT_getProperty instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_getProperty;
						}
						final /*@Thrown*/ @Nullable Property THROWN_getProperty_1 = (@Nullable Property)CAUGHT_getProperty;
						CAST_d4qvtrExpression.setReferredProperty(THROWN_getProperty_1);
						if (CAUGHT_type instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_type;
						}
						final /*@Thrown*/ @Nullable Type THROWN_type = (@Nullable Type)CAUGHT_type;
						CAST_d4qvtrExpression.setType(THROWN_type);
						objectManager.assigned(CAST_d4qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, THROWN_type, false);
						final /*@NonInvalid*/ boolean mmapNavigationOrAttributeCallExp__Property__qvtr__x = ValueUtil.TRUE_VALUE;
						IF_s0global = mmapNavigationOrAttributeCallExp__Property__qvtr__x;
					}
					else {
						IF_s0global = ValueUtil.FALSE_VALUE;
					}
					IF_IsKINDOF_ = IF_s0global;
				}
				else {
					IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ_ = IF_IsKINDOF_;
			}
			else {
				IF_IsEQ_ = ValueUtil.FALSE_VALUE;
			}
			return IF_IsEQ_;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:10 mmapOperationCallExp__Operation__qvtr__xtra__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapOperationCallExp_Operation;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d4qvtrExpression;
	 * check trace.s0global;
	 * var qvtrSource : OCLExpression[1] := trace.t4qvtrSource;
	 * observe ocl::TypedElement::type var type : Type[?] := qvtrSource.type;
	 * var operationName : String[1] := trace.t1operationName;
	 * var getOperation1 : Operation[1] := this.getOperation(type, operationName);
	 * var type1 : Type[?] := getOperation1.type;
	 * set trace.t4qvtrOperation := getOperation1;
	 * set qvtrExpression.referredOperation := getOperation1;
	 * notify set qvtrExpression.type := type1;
	 *
	 */
	protected class MAP_mmapOperationCallExp__Operation__qvtr__xtra__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace;

		public MAP_mmapOperationCallExp__Operation__qvtr__xtra__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace = (@NonNull TmapOperationCallExp_Operation)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Operation domapOperationCallExp_Operation = dispatcher.getDomapOperationCallExp_Operation();
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapOperationCallExp_Operation);
			/*@Thrown*/ boolean IF_IsEQ_;
			if (IsEQ_) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = dispatcher.getD4qvtrExpression();
				final /*@NonInvalid*/ boolean IsKINDOF_ = d4qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
				/*@Thrown*/ boolean IF_IsKINDOF_;
				if (IsKINDOF_) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable OperationCallExp CAST_d4qvtrExpression = (org.eclipse.ocl.pivot.OperationCallExp)d4qvtrExpression;
					final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
					if (s0global == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ boolean IF_s0global;
					if (s0global) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OCLExpression t4qvtrSource = trace.getT4qvtrSource();
						objectManager.getting(t4qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@NonInvalid*/ @NonNull Type type = t4qvtrSource.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t1operationName = trace.getT1operationName();
						/*@Caught*/ @Nullable Object CAUGHT_getOperation;
						try {
							final /*@Thrown*/ @NonNull Operation getOperation_0 = INSTANCE_CACHE_ATL2QVTr_getOperation.evaluate(rootThis, type, t1operationName);
							CAUGHT_getOperation = getOperation_0;
						}
						catch (Exception THROWN_CAUGHT_getOperation) {
							CAUGHT_getOperation = ValueUtil.createInvalidValue(THROWN_CAUGHT_getOperation);
						}
						/*@Caught*/ @Nullable Object CAUGHT_type;
						try {
							if (CAUGHT_getOperation instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_getOperation;
							}
							final /*@Thrown*/ @Nullable Operation THROWN_getOperation = (@Nullable Operation)CAUGHT_getOperation;
							final /*@Thrown*/ @Nullable Type type_0 = THROWN_getOperation.getType();
							CAUGHT_type = type_0;
						}
						catch (Exception THROWN_CAUGHT_type) {
							CAUGHT_type = ValueUtil.createInvalidValue(THROWN_CAUGHT_type);
						}
						// mapping statements
						if (CAUGHT_getOperation instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_getOperation;
						}
						final /*@Thrown*/ @Nullable Operation THROWN_getOperation_0 = (@Nullable Operation)CAUGHT_getOperation;
						trace.setT4qvtrOperation(THROWN_getOperation_0);
						if (CAUGHT_getOperation instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_getOperation;
						}
						final /*@Thrown*/ @Nullable Operation THROWN_getOperation_1 = (@Nullable Operation)CAUGHT_getOperation;
						CAST_d4qvtrExpression.setReferredOperation(THROWN_getOperation_1);
						if (CAUGHT_type instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_type;
						}
						final /*@Thrown*/ @Nullable Type THROWN_type = (@Nullable Type)CAUGHT_type;
						CAST_d4qvtrExpression.setType(THROWN_type);
						objectManager.assigned(CAST_d4qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, THROWN_type, false);
						final /*@NonInvalid*/ boolean mmapOperationCallExp__Operation__qvtr__xtra__ = ValueUtil.TRUE_VALUE;
						IF_s0global = mmapOperationCallExp__Operation__qvtr__xtra__;
					}
					else {
						IF_s0global = ValueUtil.FALSE_VALUE;
					}
					IF_IsKINDOF_ = IF_s0global;
				}
				else {
					IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ_ = IF_IsKINDOF_;
			}
			else {
				IF_IsEQ_ = ValueUtil.FALSE_VALUE;
			}
			return IF_IsEQ_;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:10 mmapOperatorCallExp__qvtr__xtra__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapOperatorCallExp;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d4qvtrExpression;
	 * check trace.s0global;
	 * var qvtrSource : OCLExpression[1] := trace.t4qvtrSource;
	 * observe ocl::TypedElement::type var type : Type[?] := qvtrSource.type;
	 * var operationName : String[1] := trace.t1operationName;
	 * var qvtrOperation : Operation[1] := this.getOperation(type, operationName);
	 * var type1 : Type[?] := qvtrOperation.type;
	 * set trace.t4qvtrOperation := qvtrOperation;
	 * set qvtrExpression.referredOperation := qvtrOperation;
	 * notify set qvtrExpression.type := type1;
	 *
	 */
	protected class MAP_mmapOperatorCallExp__qvtr__xtra__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace;

		public MAP_mmapOperatorCallExp__qvtr__xtra__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace = (@NonNull TmapOperatorCallExp)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = rootExecutor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher = trace.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher.getDomapOperatorCallExp();
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(trace, domapOperatorCallExp);
			/*@Thrown*/ boolean IF_IsEQ_;
			if (IsEQ_) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = dispatcher.getD4qvtrExpression();
				final /*@NonInvalid*/ boolean IsKINDOF_ = d4qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
				/*@Thrown*/ boolean IF_IsKINDOF_;
				if (IsKINDOF_) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable OperationCallExp CAST_d4qvtrExpression = (org.eclipse.ocl.pivot.OperationCallExp)d4qvtrExpression;
					final /*@NonInvalid*/ @Nullable Boolean s0global = trace.getS0global();
					if (s0global == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ boolean IF_s0global;
					if (s0global) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OCLExpression t4qvtrSource = trace.getT4qvtrSource();
						objectManager.getting(t4qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@NonInvalid*/ @NonNull Type type = t4qvtrSource.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t1operationName = trace.getT1operationName();
						/*@Caught*/ @Nullable Object CAUGHT_getOperation;
						try {
							final /*@Thrown*/ @NonNull Operation getOperation_0 = INSTANCE_CACHE_ATL2QVTr_getOperation.evaluate(rootThis, type, t1operationName);
							CAUGHT_getOperation = getOperation_0;
						}
						catch (Exception THROWN_CAUGHT_getOperation) {
							CAUGHT_getOperation = ValueUtil.createInvalidValue(THROWN_CAUGHT_getOperation);
						}
						/*@Caught*/ @Nullable Object CAUGHT_type;
						try {
							if (CAUGHT_getOperation instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_getOperation;
							}
							final /*@Thrown*/ @Nullable Operation THROWN_getOperation = (@Nullable Operation)CAUGHT_getOperation;
							final /*@Thrown*/ @Nullable Type type_0 = THROWN_getOperation.getType();
							CAUGHT_type = type_0;
						}
						catch (Exception THROWN_CAUGHT_type) {
							CAUGHT_type = ValueUtil.createInvalidValue(THROWN_CAUGHT_type);
						}
						// mapping statements
						if (CAUGHT_getOperation instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_getOperation;
						}
						final /*@Thrown*/ @Nullable Operation THROWN_getOperation_0 = (@Nullable Operation)CAUGHT_getOperation;
						trace.setT4qvtrOperation(THROWN_getOperation_0);
						if (CAUGHT_getOperation instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_getOperation;
						}
						final /*@Thrown*/ @Nullable Operation THROWN_getOperation_1 = (@Nullable Operation)CAUGHT_getOperation;
						CAST_d4qvtrExpression.setReferredOperation(THROWN_getOperation_1);
						if (CAUGHT_type instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_type;
						}
						final /*@Thrown*/ @Nullable Type THROWN_type = (@Nullable Type)CAUGHT_type;
						CAST_d4qvtrExpression.setType(THROWN_type);
						objectManager.assigned(CAST_d4qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, THROWN_type, false);
						final /*@NonInvalid*/ boolean mmapOperatorCallExp__qvtr__xtra__ = ValueUtil.TRUE_VALUE;
						IF_s0global = mmapOperatorCallExp__qvtr__xtra__;
					}
					else {
						IF_s0global = ValueUtil.FALSE_VALUE;
					}
					IF_IsKINDOF_ = IF_s0global;
				}
				else {
					IF_IsKINDOF_ = ValueUtil.FALSE_VALUE;
				}
				IF_IsEQ_ = IF_IsKINDOF_;
			}
			else {
				IF_IsEQ_ = ValueUtil.FALSE_VALUE;
			}
			return IF_IsEQ_;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace, thoseValues[0]);
		}
	}
}
