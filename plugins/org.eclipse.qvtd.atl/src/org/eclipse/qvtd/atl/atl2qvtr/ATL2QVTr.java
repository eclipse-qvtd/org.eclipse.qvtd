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
import org.eclipse.ocl.pivot.NullLiteralExp;
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
import org.eclipse.ocl.pivot.library.collection.CollectionExcludingOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIsEmptyOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionNotEmptyOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapOclExpression;
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
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNullLiteralExp;
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
@SuppressWarnings("unused")
public class ATL2QVTr extends AbstractTransformer
{
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_org = IdManager.getRootPackageId("org");
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_eclipse = PACKid_org.getNestedPackageId("eclipse");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr = IdManager.getNsURIPackageId("http://_QVTd_CompileQVTrTransformation__atl2qvtr/org/eclipse/qvtd/atl/atl2qvtr/ATL2QVTr", "PATL2QVTr", trace_ATL2QVTrPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL = IdManager.getNsURIPackageId("http://www.eclipse.org/gmt/2005/ATL", null, ATLPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL = IdManager.getNsURIPackageId("http://www.eclipse.org/gmt/2005/OCL", null, OCLPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbase", null, QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTrelation", null, QVTrelationPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTtemplate = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTtemplate", null, QVTtemplatePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2018_s_QVTtrace = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2018/QVTtrace", null, QVTtracePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Attribute = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("Attribute", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Binding = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("Binding", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BooleanExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("BooleanExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BooleanLiteralExp = PACKid_$metamodel$.getClassId("BooleanLiteralExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BooleanType = PACKid_$metamodel$.getClassId("BooleanType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CallExp = PACKid_$metamodel$.getClassId("CallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DmapHelper = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("DmapHelper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DmapOclExpression = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("DmapOclExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DmapVariableExp_referredVariable = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("DmapVariableExp_referredVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Domain = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Domain", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DomainPattern = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("DomainPattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Function = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Function", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_FunctionParameter = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("FunctionParameter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Helper = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("Helper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_IfExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("IfExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_IfExp_0 = PACKid_$metamodel$.getClassId("IfExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_InPattern = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("InPattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_InPatternElement = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("InPatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_IntegerExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("IntegerExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_IntegerLiteralExp = PACKid_$metamodel$.getClassId("IntegerLiteralExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_LocatedElement = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("LocatedElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_MatchedRule = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("MatchedRule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Model = PACKid_$metamodel$.getClassId("Model", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Module = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("Module", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ModuleElement = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("ModuleElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_NamedElement = PACKid_$metamodel$.getClassId("NamedElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_NavigationOrAttributeCallExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("NavigationOrAttributeCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_NullLiteralExp = PACKid_$metamodel$.getClassId("NullLiteralExp", 0);
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
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OperationCallExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("OperationCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OperationCallExp_0 = PACKid_$metamodel$.getClassId("OperationCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Operation_0 = PACKid_$metamodel$.getClassId("Operation", 0);
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
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapBinding = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapBinding", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapBooleanExp = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapBooleanExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapHelper_Attribute = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapHelper_Attribute", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapHelper_Context = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapHelper_Context", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapHelper_Operation = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapHelper_Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapIfExp = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapIfExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapInPattern = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapInPattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapInPattern_filter = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapInPattern_filter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapIntegerExp = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapIntegerExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapMatchedRule = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapMatchedRule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapMatchedRule_super = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapMatchedRule_super", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapModule = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapModule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapNavigationOrAttributeCallExp_Helper = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapNavigationOrAttributeCallExp_Helper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapNavigationOrAttributeCallExp_Property = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapNavigationOrAttributeCallExp_Property", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapNullLiteralExp = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapNullLiteralExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOclMetamodel = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOclMetamodel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOclModel_IN = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOclModel_IN", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOclModel_OUT = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOclModel_OUT", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOclType = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOclType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOperationCallExp_Helper = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOperationCallExp_Helper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOperationCallExp_Operation = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOperationCallExp_Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOperationCallExp_argument = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOperationCallExp_argument", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOperatorCallExp = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOperatorCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapSimpleInPatternElement = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapSimpleInPatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapSimpleOutPatternElement = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapSimpleOutPatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapStringExp = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapStringExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapVariable = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapVariableExp = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapVariableExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapVariableExp_referredVariable_Helper = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapVariableExp_referredVariable_Helper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapVariableExp_referredVariable_VariableDeclaration = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapVariableExp_referredVariable_VariableDeclaration", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TraceElement = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2018_s_QVTtrace.getClassId("TraceElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Transformation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Transformation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Type = PACKid_$metamodel$.getClassId("Type", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TypedElement = PACKid_$metamodel$.getClassId("TypedElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TypedModel = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("TypedModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Variable = PACKid_$metamodel$.getClassId("Variable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableDeclaration = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("VariableDeclaration", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableDeclaration_0 = PACKid_$metamodel$.getClassId("VariableDeclaration", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("VariableExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableExp_0 = PACKid_$metamodel$.getClassId("VariableExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VoidType = PACKid_$metamodel$.getClassId("VoidType", 0);
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_qvtd = PACKid_eclipse.getNestedPackageId("qvtd");
	public static final /*@NonInvalid*/ @NonNull String STR_ = "";
	public static final /*@NonInvalid*/ @NonNull String STR_middle = "middle";
	public static final /*@NonInvalid*/ @NonNull String STR_null = "null";
	public static final /*@NonInvalid*/ @NonNull String STR_self = "self";
	public static final /*@NonInvalid*/ @NonNull String STR_this = "this";
	public static final /*@NonInvalid*/ @NonNull String STR_trace = "trace";
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_OclModelElement = TypeId.BAG.getSpecializedId(CLSSid_OclModelElement, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_OclType = TypeId.BAG.getSpecializedId(CLSSid_OclType, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId COL_CLSSid_InPatternElement = TypeId.COLLECTION.getSpecializedId(CLSSid_InPatternElement, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Helper = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Helper, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_ModuleElement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ModuleElement, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_OclModel = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OclModel, false, ValueUtil.ONE_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_atl = PACKid_qvtd.getNestedPackageId("atl");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_Helper = CLSSid_OclFeatureDefinition.getPropertyId("Helper");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_Module = CLSSid_OclModel.getPropertyId("Module");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_bindsTo = CLSSid_TemplateExp.getPropertyId("bindsTo");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_booleanSymbol = CLSSid_BooleanLiteralExp.getPropertyId("booleanSymbol");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_conditionExpression = CLSSid_Predicate.getPropertyId("conditionExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_d3atlExpression = CLSSid_DmapVariableExp_referredVariable.getPropertyId("d3atlExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_d3atlExpression_0 = CLSSid_DmapOclExpression.getPropertyId("d3atlExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_d3atlHelper = CLSSid_DmapHelper.getPropertyId("d3atlHelper");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_d4qvtrExpression = CLSSid_DmapOclExpression.getPropertyId("d4qvtrExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_d4qvtrExpression_0 = CLSSid_DmapVariableExp_referredVariable.getPropertyId("d4qvtrExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_d4qvtrFunction = CLSSid_DmapHelper.getPropertyId("d4qvtrFunction");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_definition = CLSSid_Helper.getPropertyId("definition");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_domapBooleanExp = CLSSid_DmapOclExpression.getPropertyId("domapBooleanExp");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_domapHelper_Attribute = CLSSid_DmapHelper.getPropertyId("domapHelper_Attribute");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_domapHelper_Operation = CLSSid_DmapHelper.getPropertyId("domapHelper_Operation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_domapIfExp = CLSSid_DmapOclExpression.getPropertyId("domapIfExp");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_domapIntegerExp = CLSSid_DmapOclExpression.getPropertyId("domapIntegerExp");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_domapNavigationOrAttributeCallExp_Helper = CLSSid_DmapOclExpression.getPropertyId("domapNavigationOrAttributeCallExp_Helper");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_domapNavigationOrAttributeCallExp_Property = CLSSid_DmapOclExpression.getPropertyId("domapNavigationOrAttributeCallExp_Property");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_domapNullLiteralExp = CLSSid_DmapOclExpression.getPropertyId("domapNullLiteralExp");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_domapOclType = CLSSid_DmapOclExpression.getPropertyId("domapOclType");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_domapOperationCallExp_Helper = CLSSid_DmapOclExpression.getPropertyId("domapOperationCallExp_Helper");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_domapOperationCallExp_Operation = CLSSid_DmapOclExpression.getPropertyId("domapOperationCallExp_Operation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_domapOperatorCallExp = CLSSid_DmapOclExpression.getPropertyId("domapOperatorCallExp");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_domapStringExp = CLSSid_DmapOclExpression.getPropertyId("domapStringExp");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_domapVariableExp = CLSSid_DmapOclExpression.getPropertyId("domapVariableExp");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_domapVariableExp_referredVariable_Helper = CLSSid_DmapVariableExp_referredVariable.getPropertyId("domapVariableExp_referredVariable_Helper");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_domapVariableExp_referredVariable_VariableDeclaration = CLSSid_DmapVariableExp_referredVariable.getPropertyId("domapVariableExp_referredVariable_VariableDeclaration");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_inModels = CLSSid_Module.getPropertyId("inModels");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_integerSymbol = CLSSid_IntegerLiteralExp.getPropertyId("integerSymbol");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_isAbstract = CLSSid_Rule_0.getPropertyId("isAbstract");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_isCheckable = CLSSid_Domain.getPropertyId("isCheckable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_isEnforceable = CLSSid_Domain.getPropertyId("isEnforceable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_isImplicit = CLSSid_Variable.getPropertyId("isImplicit");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_isRequired = CLSSid_TypedElement.getPropertyId("isRequired");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_isTopLevel = CLSSid_Relation.getPropertyId("isTopLevel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_isTrace = CLSSid_TypedModel.getPropertyId("isTrace");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_name = CLSSid_NamedElement.getPropertyId("name");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_objContainer = CLSSid_PropertyTemplateItem.getPropertyId("objContainer");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_outModels = CLSSid_Module.getPropertyId("outModels");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_overrides = CLSSid_Rule_0.getPropertyId("overrides");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ownedArguments = CLSSid_OperationCallExp_0.getPropertyId("ownedArguments");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ownedCondition = CLSSid_IfExp_0.getPropertyId("ownedCondition");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ownedContext = CLSSid_Transformation.getPropertyId("ownedContext");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ownedElse = CLSSid_IfExp_0.getPropertyId("ownedElse");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ownedPackages = CLSSid_Model.getPropertyId("ownedPackages");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ownedSource = CLSSid_CallExp.getPropertyId("ownedSource");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ownedThen = CLSSid_IfExp_0.getPropertyId("ownedThen");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_owningClass = CLSSid_Operation_0.getPropertyId("owningClass");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_owningOperation = CLSSid_Parameter.getPropertyId("owningOperation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_owningPackage = CLSSid_Class.getPropertyId("owningPackage");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_pattern = CLSSid_Predicate.getPropertyId("pattern");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_queryExpression = CLSSid_Function.getPropertyId("queryExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_referredClass = CLSSid_ObjectTemplateExp.getPropertyId("referredClass");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_referredOperation = CLSSid_OperationCallExp_0.getPropertyId("referredOperation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_referredProperty = CLSSid_PropertyTemplateItem.getPropertyId("referredProperty");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_referredProperty_0 = CLSSid_PropertyCallExp.getPropertyId("referredProperty");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_referredVariable = CLSSid_VariableExp_0.getPropertyId("referredVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_relationDomain = CLSSid_DomainPattern.getPropertyId("relationDomain");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_result = CLSSid_DmapOclExpression.getPropertyId("result");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_result_0 = CLSSid_DmapHelper.getPropertyId("result");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_result_1 = CLSSid_DmapVariableExp_referredVariable.getPropertyId("result");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_rootVariable = CLSSid_RelationDomain.getPropertyId("rootVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_rule = CLSSid_Domain.getPropertyId("rule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_s0global = CLSSid_DmapOclExpression.getPropertyId("s0global");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_s0global_0 = CLSSid_DmapHelper.getPropertyId("s0global");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_s0global_1 = CLSSid_DmapVariableExp_referredVariable.getPropertyId("s0global");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_stringSymbol = CLSSid_StringLiteralExp.getPropertyId("stringSymbol");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1attributeName = CLSSid_TmapHelper_Attribute.getPropertyId("t1attributeName");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1elementName = CLSSid_TmapSimpleOutPatternElement.getPropertyId("t1elementName");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1elementName_0 = CLSSid_TmapSimpleInPatternElement.getPropertyId("t1elementName");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1operationName = CLSSid_TmapOperationCallExp_Operation.getPropertyId("t1operationName");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1operationName_0 = CLSSid_TmapOperatorCallExp.getPropertyId("t1operationName");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1operationName_1 = CLSSid_TmapHelper_Operation.getPropertyId("t1operationName");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1operationName_2 = CLSSid_TmapOperationCallExp_Helper.getPropertyId("t1operationName");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1propertyName = CLSSid_TmapNavigationOrAttributeCallExp_Property.getPropertyId("t1propertyName");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1propertyName_0 = CLSSid_TmapNavigationOrAttributeCallExp_Helper.getPropertyId("t1propertyName");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1propertyName_1 = CLSSid_TmapBinding.getPropertyId("t1propertyName");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1ruleName = CLSSid_TmapMatchedRule.getPropertyId("t1ruleName");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1symbol = CLSSid_TmapBooleanExp.getPropertyId("t1symbol");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1symbol_0 = CLSSid_TmapIntegerExp.getPropertyId("t1symbol");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1symbol_1 = CLSSid_TmapStringExp.getPropertyId("t1symbol");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1tmName = CLSSid_TmapOclMetamodel.getPropertyId("t1tmName");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1txName = CLSSid_TmapModule.getPropertyId("t1txName");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1varName = CLSSid_TmapNullLiteralExp.getPropertyId("t1varName");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1varName_0 = CLSSid_TmapVariableExp.getPropertyId("t1varName");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlArgument = CLSSid_TmapOperationCallExp_argument.getPropertyId("t3atlArgument");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlAttributes = CLSSid_TmapNavigationOrAttributeCallExp_Property.getPropertyId("t3atlAttributes");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlAttributes_0 = CLSSid_TmapNavigationOrAttributeCallExp_Helper.getPropertyId("t3atlAttributes");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlBinding = CLSSid_TmapBinding.getPropertyId("t3atlBinding");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlChildRule = CLSSid_TmapMatchedRule_super.getPropertyId("t3atlChildRule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlCondition = CLSSid_TmapIfExp.getPropertyId("t3atlCondition");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlContext = CLSSid_TmapHelper_Context.getPropertyId("t3atlContext");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlDefinition = CLSSid_TmapHelper_Attribute.getPropertyId("t3atlDefinition");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlDefinition_0 = CLSSid_TmapHelper_Operation.getPropertyId("t3atlDefinition");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlDefinition_1 = CLSSid_TmapHelper_Context.getPropertyId("t3atlDefinition");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlElement = CLSSid_TmapSimpleInPatternElement.getPropertyId("t3atlElement");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlElement_0 = CLSSid_TmapSimpleOutPatternElement.getPropertyId("t3atlElement");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlElse = CLSSid_TmapIfExp.getPropertyId("t3atlElse");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlExpression = CLSSid_TmapHelper_Attribute.getPropertyId("t3atlExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlExpression_0 = CLSSid_TmapHelper_Operation.getPropertyId("t3atlExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlExpression_1 = CLSSid_TmapBinding.getPropertyId("t3atlExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlExpression_2 = CLSSid_TmapInPattern_filter.getPropertyId("t3atlExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlFeature = CLSSid_TmapHelper_Attribute.getPropertyId("t3atlFeature");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlFeature_0 = CLSSid_TmapHelper_Operation.getPropertyId("t3atlFeature");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlHelper = CLSSid_TmapHelper_Context.getPropertyId("t3atlHelper");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlHelper_0 = CLSSid_TmapVariableExp_referredVariable_Helper.getPropertyId("t3atlHelper");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlMetamodel = CLSSid_TmapSimpleOutPatternElement.getPropertyId("t3atlMetamodel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlModel = CLSSid_TmapInPattern.getPropertyId("t3atlModel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlModule = CLSSid_TmapNavigationOrAttributeCallExp_Property.getPropertyId("t3atlModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlModule_0 = CLSSid_TmapOperationCallExp_Operation.getPropertyId("t3atlModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlModule_1 = CLSSid_TmapHelper_Attribute.getPropertyId("t3atlModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlModule_2 = CLSSid_TmapHelper_Operation.getPropertyId("t3atlModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlModule_3 = CLSSid_TmapMatchedRule.getPropertyId("t3atlModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlModule_4 = CLSSid_TmapOclModel_IN.getPropertyId("t3atlModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlModule_5 = CLSSid_TmapOclModel_OUT.getPropertyId("t3atlModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlModule_6 = CLSSid_TmapNavigationOrAttributeCallExp_Helper.getPropertyId("t3atlModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlModule_7 = CLSSid_TmapOperationCallExp_Helper.getPropertyId("t3atlModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlModule_8 = CLSSid_TmapModule.getPropertyId("t3atlModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlOperations = CLSSid_TmapOperationCallExp_Operation.getPropertyId("t3atlOperations");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlOperations_0 = CLSSid_TmapOperationCallExp_Helper.getPropertyId("t3atlOperations");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlOutPattern = CLSSid_TmapMatchedRule.getPropertyId("t3atlOutPattern");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlOutPatternElement = CLSSid_TmapBinding.getPropertyId("t3atlOutPatternElement");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlParent = CLSSid_TmapOperationCallExp_argument.getPropertyId("t3atlParent");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlPattern = CLSSid_TmapInPattern_filter.getPropertyId("t3atlPattern");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlPattern_0 = CLSSid_TmapSimpleOutPatternElement.getPropertyId("t3atlPattern");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlPattern_1 = CLSSid_TmapSimpleInPatternElement.getPropertyId("t3atlPattern");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlPattern_2 = CLSSid_TmapInPattern.getPropertyId("t3atlPattern");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlReturnType = CLSSid_TmapHelper_Context.getPropertyId("t3atlReturnType");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlRule = CLSSid_TmapInPattern.getPropertyId("t3atlRule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlRule_0 = CLSSid_TmapSimpleOutPatternElement.getPropertyId("t3atlRule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlRule_1 = CLSSid_TmapSimpleInPatternElement.getPropertyId("t3atlRule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlRule_2 = CLSSid_TmapInPattern_filter.getPropertyId("t3atlRule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlSource = CLSSid_TmapNavigationOrAttributeCallExp_Property.getPropertyId("t3atlSource");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlSource_0 = CLSSid_TmapOperationCallExp_Operation.getPropertyId("t3atlSource");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlSource_1 = CLSSid_TmapOperatorCallExp.getPropertyId("t3atlSource");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlSource_2 = CLSSid_TmapNavigationOrAttributeCallExp_Helper.getPropertyId("t3atlSource");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlSource_3 = CLSSid_TmapOperationCallExp_Helper.getPropertyId("t3atlSource");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlSuperRule = CLSSid_TmapMatchedRule_super.getPropertyId("t3atlSuperRule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlThen = CLSSid_TmapIfExp.getPropertyId("t3atlThen");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlType = CLSSid_TmapHelper_Attribute.getPropertyId("t3atlType");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlType_0 = CLSSid_TmapHelper_Operation.getPropertyId("t3atlType");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlType_1 = CLSSid_TmapSimpleOutPatternElement.getPropertyId("t3atlType");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlVariable = CLSSid_TmapNullLiteralExp.getPropertyId("t3atlVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlVariable_0 = CLSSid_TmapVariableExp.getPropertyId("t3atlVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlVariable_1 = CLSSid_TmapVariable.getPropertyId("t3atlVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlVariable_2 = CLSSid_TmapVariableExp_referredVariable_Helper.getPropertyId("t3atlVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3atlVariable_3 = CLSSid_TmapVariableExp_referredVariable_VariableDeclaration.getPropertyId("t3atlVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3matchedRule = CLSSid_TmapMatchedRule.getPropertyId("t3matchedRule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3oclMetamodel = CLSSid_TmapOclModel_IN.getPropertyId("t3oclMetamodel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3oclMetamodel_0 = CLSSid_TmapOclModel_OUT.getPropertyId("t3oclMetamodel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3oclMetamodel_1 = CLSSid_TmapOclMetamodel.getPropertyId("t3oclMetamodel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3oclModel = CLSSid_TmapOclModel_IN.getPropertyId("t3oclModel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t3oclModel_0 = CLSSid_TmapOclModel_OUT.getPropertyId("t3oclModel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4_1 = CLSSid_TmapModule.getPropertyId("t4_1");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4_2 = CLSSid_TmapModule.getPropertyId("t4_2");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4_3 = CLSSid_TmapModule.getPropertyId("t4_3");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4_4 = CLSSid_TmapModule.getPropertyId("t4_4");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrArgument = CLSSid_TmapOperationCallExp_argument.getPropertyId("t4qvtrArgument");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrCondition = CLSSid_TmapIfExp.getPropertyId("t4qvtrCondition");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrContext = CLSSid_TmapMatchedRule.getPropertyId("t4qvtrContext");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrDomain = CLSSid_TmapInPattern.getPropertyId("t4qvtrDomain");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrDomain_0 = CLSSid_TmapSimpleOutPatternElement.getPropertyId("t4qvtrDomain");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrDomain_1 = CLSSid_TmapSimpleInPatternElement.getPropertyId("t4qvtrDomain");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrElse = CLSSid_TmapIfExp.getPropertyId("t4qvtrElse");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrExpression = CLSSid_TmapBinding.getPropertyId("t4qvtrExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrExpression_0 = CLSSid_TmapHelper_Attribute.getPropertyId("t4qvtrExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrExpression_1 = CLSSid_TmapHelper_Operation.getPropertyId("t4qvtrExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrExpression_2 = CLSSid_TmapInPattern_filter.getPropertyId("t4qvtrExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrFunction = CLSSid_TmapHelper_Context.getPropertyId("t4qvtrFunction");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrOperation = CLSSid_TmapNavigationOrAttributeCallExp_Helper.getPropertyId("t4qvtrOperation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrOperation_0 = CLSSid_TmapOperationCallExp_Helper.getPropertyId("t4qvtrOperation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrOperation_1 = CLSSid_TmapOperationCallExp_Operation.getPropertyId("t4qvtrOperation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrOperation_2 = CLSSid_TmapOperatorCallExp.getPropertyId("t4qvtrOperation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrOverriddenRelation = CLSSid_TmapMatchedRule_super.getPropertyId("t4qvtrOverriddenRelation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrOverridesRelation = CLSSid_TmapMatchedRule_super.getPropertyId("t4qvtrOverridesRelation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrPackages = CLSSid_TmapOclModel_IN.getPropertyId("t4qvtrPackages");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrPackages_0 = CLSSid_TmapOclModel_OUT.getPropertyId("t4qvtrPackages");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrParameter = CLSSid_TmapHelper_Context.getPropertyId("t4qvtrParameter");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrParent = CLSSid_TmapOperationCallExp_argument.getPropertyId("t4qvtrParent");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrPart = CLSSid_TmapBinding.getPropertyId("t4qvtrPart");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrPattern = CLSSid_TmapSimpleOutPatternElement.getPropertyId("t4qvtrPattern");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrPattern_0 = CLSSid_TmapSimpleInPatternElement.getPropertyId("t4qvtrPattern");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrPattern_1 = CLSSid_TmapInPattern_filter.getPropertyId("t4qvtrPattern");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrPredicate = CLSSid_TmapInPattern_filter.getPropertyId("t4qvtrPredicate");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrProperty = CLSSid_TmapNavigationOrAttributeCallExp_Property.getPropertyId("t4qvtrProperty");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrRelation = CLSSid_TmapMatchedRule.getPropertyId("t4qvtrRelation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrRelation_0 = CLSSid_TmapInPattern.getPropertyId("t4qvtrRelation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrRelation_1 = CLSSid_TmapSimpleOutPatternElement.getPropertyId("t4qvtrRelation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrRelation_2 = CLSSid_TmapSimpleInPatternElement.getPropertyId("t4qvtrRelation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrRelation_3 = CLSSid_TmapInPattern_filter.getPropertyId("t4qvtrRelation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrSource = CLSSid_TmapNavigationOrAttributeCallExp_Helper.getPropertyId("t4qvtrSource");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrSourceArgument = CLSSid_TmapNavigationOrAttributeCallExp_Helper.getPropertyId("t4qvtrSourceArgument");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrSourceArgument_0 = CLSSid_TmapOperationCallExp_Helper.getPropertyId("t4qvtrSourceArgument");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrSource_0 = CLSSid_TmapOperationCallExp_Helper.getPropertyId("t4qvtrSource");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrSource_1 = CLSSid_TmapNavigationOrAttributeCallExp_Property.getPropertyId("t4qvtrSource");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrSource_2 = CLSSid_TmapOperationCallExp_Operation.getPropertyId("t4qvtrSource");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrSource_3 = CLSSid_TmapOperatorCallExp.getPropertyId("t4qvtrSource");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrTemplate = CLSSid_TmapSimpleOutPatternElement.getPropertyId("t4qvtrTemplate");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrTemplate_0 = CLSSid_TmapSimpleInPatternElement.getPropertyId("t4qvtrTemplate");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrTemplate_1 = CLSSid_TmapBinding.getPropertyId("t4qvtrTemplate");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrThen = CLSSid_TmapIfExp.getPropertyId("t4qvtrThen");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrThisVariable = CLSSid_TmapNavigationOrAttributeCallExp_Helper.getPropertyId("t4qvtrThisVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrThisVariable_0 = CLSSid_TmapOperationCallExp_Helper.getPropertyId("t4qvtrThisVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrTransformation = CLSSid_TmapModule.getPropertyId("t4qvtrTransformation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrTransformation_0 = CLSSid_TmapHelper_Attribute.getPropertyId("t4qvtrTransformation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrTransformation_1 = CLSSid_TmapHelper_Operation.getPropertyId("t4qvtrTransformation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrTransformation_2 = CLSSid_TmapMatchedRule.getPropertyId("t4qvtrTransformation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrTransformation_3 = CLSSid_TmapOclModel_IN.getPropertyId("t4qvtrTransformation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrTransformation_4 = CLSSid_TmapOclModel_OUT.getPropertyId("t4qvtrTransformation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrTransformation_5 = CLSSid_TmapNavigationOrAttributeCallExp_Helper.getPropertyId("t4qvtrTransformation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrTransformation_6 = CLSSid_TmapOperationCallExp_Helper.getPropertyId("t4qvtrTransformation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrType = CLSSid_TmapSimpleOutPatternElement.getPropertyId("t4qvtrType");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrTypedModel = CLSSid_TmapOclMetamodel.getPropertyId("t4qvtrTypedModel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrTypedModel_0 = CLSSid_TmapOclModel_IN.getPropertyId("t4qvtrTypedModel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrTypedModel_1 = CLSSid_TmapOclModel_OUT.getPropertyId("t4qvtrTypedModel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrTypedModel_2 = CLSSid_TmapInPattern.getPropertyId("t4qvtrTypedModel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrTypedModel_3 = CLSSid_TmapSimpleOutPatternElement.getPropertyId("t4qvtrTypedModel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrVariable = CLSSid_TmapVariable.getPropertyId("t4qvtrVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrVariable_0 = CLSSid_TmapSimpleOutPatternElement.getPropertyId("t4qvtrVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrVariable_1 = CLSSid_TmapSimpleInPatternElement.getPropertyId("t4qvtrVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrVariable_2 = CLSSid_TmapVariableExp_referredVariable_Helper.getPropertyId("t4qvtrVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t4qvtrVariable_3 = CLSSid_TmapVariableExp_referredVariable_VariableDeclaration.getPropertyId("t4qvtrVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_templateExpression = CLSSid_DomainPattern.getPropertyId("templateExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_transformation = CLSSid_TypedModel.getPropertyId("transformation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_transformation_0 = CLSSid_Rule_0.getPropertyId("transformation");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_type = CLSSid_TypedElement.getPropertyId("type");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_typedModel = CLSSid_Domain.getPropertyId("typedModel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_usedPackage = CLSSid_TypedModel.getPropertyId("usedPackage");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_value = CLSSid_PropertyTemplateItem.getPropertyId("value");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_variable = CLSSid_Relation.getPropertyId("variable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_when = CLSSid_Relation.getPropertyId("when");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapHelper = CLSSid_TmapNavigationOrAttributeCallExp_Helper.getPropertyId("wmapHelper");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapHelper_0 = CLSSid_TmapOperationCallExp_Helper.getPropertyId("wmapHelper");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapHelper_Context = CLSSid_TmapHelper_Attribute.getPropertyId("wmapHelper_Context");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapHelper_Context_0 = CLSSid_TmapHelper_Operation.getPropertyId("wmapHelper_Context");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapInPattern = CLSSid_TmapSimpleInPatternElement.getPropertyId("wmapInPattern");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapMatchedRule = CLSSid_TmapInPattern.getPropertyId("wmapMatchedRule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapMatchedRule1 = CLSSid_TmapMatchedRule_super.getPropertyId("wmapMatchedRule1");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapMatchedRule_0 = CLSSid_TmapMatchedRule_super.getPropertyId("wmapMatchedRule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapMatchedRule_1 = CLSSid_TmapSimpleOutPatternElement.getPropertyId("wmapMatchedRule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapMatchedRule_2 = CLSSid_TmapSimpleInPatternElement.getPropertyId("wmapMatchedRule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapMatchedRule_3 = CLSSid_TmapInPattern_filter.getPropertyId("wmapMatchedRule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapModule = CLSSid_TmapHelper_Attribute.getPropertyId("wmapModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapModule_0 = CLSSid_TmapHelper_Operation.getPropertyId("wmapModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapModule_1 = CLSSid_TmapMatchedRule.getPropertyId("wmapModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapModule_2 = CLSSid_TmapOclModel_IN.getPropertyId("wmapModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapModule_3 = CLSSid_TmapOclModel_OUT.getPropertyId("wmapModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapModule_4 = CLSSid_TmapNavigationOrAttributeCallExp_Helper.getPropertyId("wmapModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapModule_5 = CLSSid_TmapOperationCallExp_Helper.getPropertyId("wmapModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapOclExpression = CLSSid_TmapIfExp.getPropertyId("wmapOclExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapOclExpression1 = CLSSid_TmapIfExp.getPropertyId("wmapOclExpression1");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapOclExpression1_0 = CLSSid_TmapOperationCallExp_argument.getPropertyId("wmapOclExpression1");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapOclExpression2 = CLSSid_TmapIfExp.getPropertyId("wmapOclExpression2");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapOclExpression_0 = CLSSid_TmapNavigationOrAttributeCallExp_Property.getPropertyId("wmapOclExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapOclExpression_1 = CLSSid_TmapOperationCallExp_Operation.getPropertyId("wmapOclExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapOclExpression_2 = CLSSid_TmapOperatorCallExp.getPropertyId("wmapOclExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapOclExpression_3 = CLSSid_TmapHelper_Attribute.getPropertyId("wmapOclExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapOclExpression_4 = CLSSid_TmapHelper_Operation.getPropertyId("wmapOclExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapOclExpression_5 = CLSSid_TmapNavigationOrAttributeCallExp_Helper.getPropertyId("wmapOclExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapOclExpression_6 = CLSSid_TmapOperationCallExp_Helper.getPropertyId("wmapOclExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapOclExpression_7 = CLSSid_TmapBinding.getPropertyId("wmapOclExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapOclExpression_8 = CLSSid_TmapInPattern_filter.getPropertyId("wmapOclExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapOclExpression_9 = CLSSid_TmapOperationCallExp_argument.getPropertyId("wmapOclExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapOclMetamodel = CLSSid_TmapOclModel_IN.getPropertyId("wmapOclMetamodel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapOclMetamodel_0 = CLSSid_TmapOclModel_OUT.getPropertyId("wmapOclMetamodel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapOclMetamodel_1 = CLSSid_TmapInPattern.getPropertyId("wmapOclMetamodel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapOclMetamodel_2 = CLSSid_TmapSimpleOutPatternElement.getPropertyId("wmapOclMetamodel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapSimpleOutPatternElement = CLSSid_TmapBinding.getPropertyId("wmapSimpleOutPatternElement");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapVariable = CLSSid_TmapSimpleOutPatternElement.getPropertyId("wmapVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapVariableExp_referredVariable = CLSSid_TmapVariableExp.getPropertyId("wmapVariableExp_referredVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapVariable_0 = CLSSid_TmapHelper_Context.getPropertyId("wmapVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_wmapVariable_1 = CLSSid_TmapSimpleInPatternElement.getPropertyId("wmapVariable");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Attribute = TypeId.SEQUENCE.getSpecializedId(CLSSid_Attribute, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_OclFeature = TypeId.SEQUENCE.getSpecializedId(CLSSid_OclFeature, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_OclFeatureDefinition = TypeId.SEQUENCE.getSpecializedId(CLSSid_OclFeatureDefinition, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Operation = TypeId.SEQUENCE.getSpecializedId(CLSSid_Operation, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Helper = TypeId.SET.getSpecializedId(CLSSid_Helper, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_InPatternElement = TypeId.SET.getSpecializedId(CLSSid_InPatternElement, false, ValueUtil.ONE_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_InPatternElement_0 = TypeId.SET.getSpecializedId(CLSSid_InPatternElement, true, ValueUtil.ONE_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_LocatedElement = TypeId.SET.getSpecializedId(CLSSid_LocatedElement, true, ValueUtil.ONE_VALUE, ValueUtil.ONE_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_OclElement = TypeId.SET.getSpecializedId(CLSSid_OclElement, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_OclModel = TypeId.SET.getSpecializedId(CLSSid_OclModel, false, ValueUtil.ONE_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Package = TypeId.SET.getSpecializedId(CLSSid_Package, true, ValueUtil.ONE_VALUE, ValueUtil.ONE_VALUE);
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_atl2qvtr = PACKid_atl.getNestedPackageId("atl2qvtr");
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TxATL2QVTr = PACKid_http_c_s_s__QVTd_CompileQVTrTransformation__atl2qvtr_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TxATL2QVTr", 0);

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

	/*
	 * Array of the source PropertyIds of each Property for which unnavigable opposite property navigation may occur.
	 */
	private static final @NonNull PropertyId @NonNull [] oppositeIndex2propertyId = new @NonNull PropertyId[]{
		PROPid_d3atlExpression_0,		// 0 => d3atlExpression
		PROPid_t3atlModule_8,		// 1 => t3atlModule
		PROPid_t3oclMetamodel_1,		// 2 => t3oclMetamodel
		PROPid_t3matchedRule,		// 3 => t3matchedRule
		PROPid_d3atlHelper,		// 4 => d3atlHelper
		PROPid_t3atlPattern_2,		// 5 => t3atlPattern
		PROPid_t3atlElement_0,		// 6 => t3atlElement
		PROPid_t3atlVariable_1		// 7 => t3atlVariable
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_r_ATL2QVTr__qvtr__load__ = new AbstractInvocationConstructor(invocationManager, "r_ATL2QVTr__qvtr__load__", false, lazyCreateInterval(0))
	{
		@Override
		public @NonNull MAP_r_ATL2QVTr__qvtr__load__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_r_ATL2QVTr__qvtr__load__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapHelper__Attribute__qvtr__loop__ = new AbstractInvocationConstructor(invocationManager, "mmapHelper__Attribute__qvtr__loop__", true, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapHelper__Attribute__qvtr__loop__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapHelper__Attribute__qvtr__loop__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapHelper__Context__qvtr__loop__ = new AbstractInvocationConstructor(invocationManager, "mmapHelper__Context__qvtr__loop__", true, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapHelper__Context__qvtr__loop__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapHelper__Context__qvtr__loop__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapHelper__Operation__qvtr__loop__ = new AbstractInvocationConstructor(invocationManager, "mmapHelper__Operation__qvtr__loop__", true, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapHelper__Operation__qvtr__loop__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapHelper__Operation__qvtr__loop__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapHelper__verdict__qvtr = new AbstractInvocationConstructor(invocationManager, "mmapHelper__verdict__qvtr", false, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapHelper__verdict__qvtr newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapHelper__verdict__qvtr(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapNavigationOrAttributeCallExp__Helper__qvtr__ini = new AbstractInvocationConstructor(invocationManager, "mmapNavigationOrAttributeCallExp__Helper__qvtr__ini", false, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__ini newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__ini(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapNavigationOrAttributeCallExp__Helper__qvtr__loo = new AbstractInvocationConstructor(invocationManager, "mmapNavigationOrAttributeCallExp__Helper__qvtr__loo", true, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__loo newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__loo(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapNavigationOrAttributeCallExp__Property__qvtr__l = new AbstractInvocationConstructor(invocationManager, "mmapNavigationOrAttributeCallExp__Property__qvtr__l", true, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__l newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__l(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOclExpression__verdict__qvtr = new AbstractInvocationConstructor(invocationManager, "mmapOclExpression__verdict__qvtr", false, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapOclExpression__verdict__qvtr newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOclExpression__verdict__qvtr(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOperationCallExp__Helper__qvtr__init__ = new AbstractInvocationConstructor(invocationManager, "mmapOperationCallExp__Helper__qvtr__init__", false, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapOperationCallExp__Helper__qvtr__init__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperationCallExp__Helper__qvtr__init__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOperationCallExp__Helper__qvtr__loop__ = new AbstractInvocationConstructor(invocationManager, "mmapOperationCallExp__Helper__qvtr__loop__", true, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapOperationCallExp__Helper__qvtr__loop__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperationCallExp__Helper__qvtr__loop__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOperationCallExp__Operation__qvtr__loop__ = new AbstractInvocationConstructor(invocationManager, "mmapOperationCallExp__Operation__qvtr__loop__", true, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapOperationCallExp__Operation__qvtr__loop__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperationCallExp__Operation__qvtr__loop__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOperatorCallExp__qvtr__loop__ = new AbstractInvocationConstructor(invocationManager, "mmapOperatorCallExp__qvtr__loop__", true, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapOperatorCallExp__qvtr__loop__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperatorCallExp__qvtr__loop__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapVariableExp__referredVariable__Helper__qvtr__lo = new AbstractInvocationConstructor(invocationManager, "mmapVariableExp__referredVariable__Helper__qvtr__lo", false, lazyCreateInterval(8))
	{
		@Override
		public @NonNull MAP_mmapVariableExp__referredVariable__Helper__qvtr__lo newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapVariableExp__referredVariable__Helper__qvtr__lo(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapIfExp__qvtr__xtra__ = new AbstractInvocationConstructor(invocationManager, "mmapIfExp__qvtr__xtra__", false, lazyCreateInterval(11))
	{
		@Override
		public @NonNull MAP_mmapIfExp__qvtr__xtra__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapIfExp__qvtr__xtra__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapNavigationOrAttributeCallExp__Property__qvtr__x = new AbstractInvocationConstructor(invocationManager, "mmapNavigationOrAttributeCallExp__Property__qvtr__x", true, lazyCreateInterval(11))
	{
		@Override
		public @NonNull MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__x newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__x(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOperationCallExp__Operation__qvtr__xtra__ = new AbstractInvocationConstructor(invocationManager, "mmapOperationCallExp__Operation__qvtr__xtra__", true, lazyCreateInterval(11))
	{
		@Override
		public @NonNull MAP_mmapOperationCallExp__Operation__qvtr__xtra__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperationCallExp__Operation__qvtr__xtra__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOperatorCallExp__qvtr__xtra__ = new AbstractInvocationConstructor(invocationManager, "mmapOperatorCallExp__qvtr__xtra__", true, lazyCreateInterval(11))
	{
		@Override
		public @NonNull MAP_mmapOperatorCallExp__qvtr__xtra__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperatorCallExp__qvtr__xtra__(this, values);
		}
	};

	protected final @NonNull AbstractComputationConstructor FTOR_getCommonType = new AbstractComputationConstructor(idResolver)
	{
		@Override
		public @NonNull FUN_getCommonType newInstance(@Nullable Object @NonNull [] values) {
			return new FUN_getCommonType(values);
		}
	};

	protected final @NonNull AbstractComputationConstructor FTOR_getHelper = new AbstractComputationConstructor(idResolver)
	{
		@Override
		public @NonNull FUN_getHelper newInstance(@Nullable Object @NonNull [] values) {
			return new FUN_getHelper(values);
		}
	};

	protected final @NonNull AbstractComputationConstructor FTOR_getModule = new AbstractComputationConstructor(idResolver)
	{
		@Override
		public @NonNull FUN_getModule newInstance(@Nullable Object @NonNull [] values) {
			return new FUN_getModule(values);
		}
	};

	protected final @NonNull AbstractComputationConstructor FTOR_getOperation = new AbstractComputationConstructor(idResolver)
	{
		@Override
		public @NonNull FUN_getOperation newInstance(@Nullable Object @NonNull [] values) {
			return new FUN_getOperation(values);
		}
	};

	protected final @NonNull AbstractComputationConstructor FTOR_getPackage = new AbstractComputationConstructor(idResolver)
	{
		@Override
		public @NonNull FUN_getPackage newInstance(@Nullable Object @NonNull [] values) {
			return new FUN_getPackage(values);
		}
	};

	protected final @NonNull AbstractComputationConstructor FTOR_getProperty = new AbstractComputationConstructor(idResolver)
	{
		@Override
		public @NonNull FUN_getProperty newInstance(@Nullable Object @NonNull [] values) {
			return new FUN_getProperty(values);
		}
	};

	protected final @NonNull AbstractComputationConstructor FTOR_getType = new AbstractComputationConstructor(idResolver)
	{
		@Override
		public @NonNull FUN_getType newInstance(@Nullable Object @NonNull [] values) {
			return new FUN_getType(values);
		}
	};

	public class ICACHE_DmapVariableExp_referredVariable extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			/*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable instance = trace_ATL2QVTrFactory.eINSTANCE.createDmapVariableExp_referredVariable();
			/*@NonInvalid*/ @NonNull VariableExp value0 = (/*@NonInvalid*/ @NonNull VariableExp)sourceAndArgumentValues[0];
			instance.setD3atlExpression(value0);
			/*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp value1 = (/*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp)sourceAndArgumentValues[1];
			instance.setD4qvtrExpression(value1);
			models[4].add(instance, false);
			return instance;
		}

		public @NonNull DmapVariableExp_referredVariable evaluate(final /*@NonInvalid*/ @NonNull VariableExp IMPPROPid_d3atlExpression, final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp IMPPROPid_d4qvtrExpression) {
			return (@NonNull DmapVariableExp_referredVariable)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{IMPPROPid_d3atlExpression, IMPPROPid_d4qvtrExpression});
		}
	}

	protected final @NonNull ICACHE_DmapVariableExp_referredVariable INSTANCE_ICACHE_DmapVariableExp_referredVariable = new ICACHE_DmapVariableExp_referredVariable();
	public class ICACHE_TmapHelper_Context extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			/*@NonInvalid*/ @NonNull TmapHelper_Context instance = trace_ATL2QVTrFactory.eINSTANCE.createTmapHelper_Context();
			/*@NonInvalid*/ @NonNull Helper value0 = (/*@NonInvalid*/ @NonNull Helper)sourceAndArgumentValues[0];
			instance.setT3atlHelper(value0);
			/*@NonInvalid*/ @NonNull Function value1 = (/*@NonInvalid*/ @NonNull Function)sourceAndArgumentValues[1];
			instance.setT4qvtrFunction(value1);
			models[4].add(instance, false);
			return instance;
		}

		public @NonNull TmapHelper_Context evaluate(final /*@NonInvalid*/ @NonNull Helper IMPPROPid_t3atlHelper, final /*@NonInvalid*/ @NonNull Function IMPPROPid_t4qvtrFunction) {
			return (@NonNull TmapHelper_Context)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{IMPPROPid_t3atlHelper, IMPPROPid_t4qvtrFunction});
		}
	}

	protected final @NonNull ICACHE_TmapHelper_Context INSTANCE_ICACHE_TmapHelper_Context = new ICACHE_TmapHelper_Context();
	public class ICACHE_TmapVariable extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			/*@NonInvalid*/ @NonNull TmapVariable instance = trace_ATL2QVTrFactory.eINSTANCE.createTmapVariable();
			/*@NonInvalid*/ @NonNull LocatedElement value0 = (/*@NonInvalid*/ @NonNull LocatedElement)sourceAndArgumentValues[0];
			instance.setT3atlVariable(value0);
			OPPOSITE_OF_TmapVariable_t3atlVariable.put(value0, instance);
			/*@NonInvalid*/ @NonNull VariableDeclaration value1 = (/*@NonInvalid*/ @NonNull VariableDeclaration)sourceAndArgumentValues[1];
			instance.setT4qvtrVariable(value1);
			models[4].add(instance, false);
			return instance;
		}

		public @NonNull TmapVariable evaluate(final /*@NonInvalid*/ @NonNull LocatedElement IMPPROPid_t3atlVariable, final /*@NonInvalid*/ @NonNull VariableDeclaration IMPPROPid_t4qvtrVariable) {
			return (@NonNull TmapVariable)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{IMPPROPid_t3atlVariable, IMPPROPid_t4qvtrVariable});
		}
	}

	protected final @NonNull ICACHE_TmapVariable INSTANCE_ICACHE_TmapVariable = new ICACHE_TmapVariable();

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

	public ATL2QVTr(final @NonNull TransformationExecutor executor) {
		super(executor, 5);
		initOpposites(oppositeIndex2propertyId);
		initModel(0, "$primitive$");
		initModel(1, "$this$");
		initModel(2, "atl").initClassIds(classIndex2classId_2, classIndex2allClassIndexes_2);
		initModel(3, "qvtr");
		initModel(4, "middle");
		initConnections();
	}

	private @Nullable TxATL2QVTr transformationExecution = null;

	public @NonNull TxATL2QVTr getTransformationExecution() {
		if (transformationExecution == null) {
			transformationExecution = trace_ATL2QVTrFactory.eINSTANCE.createTxATL2QVTr();
		}
		assert transformationExecution != null;
		return transformationExecution;
	}

	@Override
	public boolean run(@NonNull String targetName) {
		return run();
	}

	@Override
	public boolean run() {
		initSpeculatedEAttributes(trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL,
								trace_ATL2QVTrPackage.Literals.TMAP_VARIABLE__S0GLOBAL,
								trace_ATL2QVTrPackage.Literals.DMAP_HELPER__S0GLOBAL,
								trace_ATL2QVTrPackage.Literals.IMAP_HELPER__S0GLOBAL,
								trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL,
								trace_ATL2QVTrPackage.Literals.IMAP_VARIABLE_EXP_REFERRED_VARIABLE__S0GLOBAL);
		final @NonNull Connection ji_Binding = models[2/*atl*/].getConnection(0/*ATL::Binding*/);
		final @NonNull Connection ji_Helper = models[2/*atl*/].getConnection(1/*ATL::Helper*/);
		final @NonNull Connection ji_InPattern = models[2/*atl*/].getConnection(2/*ATL::InPattern*/);
		final @NonNull Connection ji_MatchedRule = models[2/*atl*/].getConnection(3/*ATL::MatchedRule*/);
		final @NonNull Connection ji_Module = models[2/*atl*/].getConnection(4/*ATL::Module*/);
		final @NonNull Connection ji_NavigationOrAttributeCallExp = models[2/*atl*/].getConnection(5/*OCL::NavigationOrAttributeCallExp*/);
		final @NonNull Connection ji_OclExpression = models[2/*atl*/].getConnection(6/*OCL::OclExpression*/);
		final @NonNull Connection ji_OclModel = models[2/*atl*/].getConnection(7/*OCL::OclModel*/);
		final @NonNull Connection ji_OperationCallExp = models[2/*atl*/].getConnection(8/*OCL::OperationCallExp*/);
		final @NonNull Connection ji_SimpleInPatternElement = models[2/*atl*/].getConnection(9/*ATL::SimpleInPatternElement*/);
		final @NonNull Connection ji_SimpleOutPatternElement = models[2/*atl*/].getConnection(10/*ATL::SimpleOutPatternElement*/);
		final @NonNull Connection ji_VariableExp = models[2/*atl*/].getConnection(11/*OCL::VariableExp*/);
		CTOR_r_ATL2QVTr__qvtr__load__.invoke(ji_Binding, ji_Helper, ji_InPattern, ji_MatchedRule, ji_Module, ji_NavigationOrAttributeCallExp, ji_OclExpression, ji_OclModel, ji_OperationCallExp, ji_SimpleInPatternElement, ji_SimpleOutPatternElement, ji_VariableExp);
		return invocationManager.flush();
	}

	/**
	 * ::getCommonType(type1 : Type[1], type2 : Type[1]) : Type[1]
	 */
	protected class FUN_getCommonType extends AbstractComputation
	{
		protected final @NonNull ATL2QVTr self;
		protected /*@NonInvalid*/ @NonNull Type type1;
		protected /*@NonInvalid*/ @NonNull Type type2;
		protected final /*@NonInvalid*/ @NonNull Type instance;

		/**
		 * ::getCommonType : Type[?]
		 */
		@SuppressWarnings("null")
		public FUN_getCommonType(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.type1 = (@NonNull Type)boundValues[1];
			this.type2 = (@NonNull Type)boundValues[2];
			final /*@NonInvalid*/ @NonNull Type instance = Helper4getCommonType.INSTANCE.evaluate(executor, CLSSid_Type, ATL2QVTr.this, type1, type2);
			this.instance = instance;
		}

		@Override
		public @Nullable Object getResult() {
			return instance;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @Nullable Object @NonNull [] thoseValues) {
			return this.self == thoseValues[0]
				&& idResolver.oclEquals(this.type1, thoseValues[1])
				&& idResolver.oclEquals(this.type2, thoseValues[2]);
		}
	}

	/**
	 * ::getHelper(element : ATL::LocatedElement[1]) : ATL::Helper[?]
	 */
	protected class FUN_getHelper extends AbstractComputation
	{
		protected final @NonNull ATL2QVTr self;
		protected /*@NonInvalid*/ @NonNull LocatedElement element;
		protected final /*@Thrown*/ @Nullable Helper instance;

		/**
		 *
		 * let
		 *   helpers : Set(ATL::Helper) = element->closure(e | e.oclContainer())
		 *   ->selectByKind(ATL::Helper);
		 *
		 * in if helpers->notEmpty() then helpers->any(true) else null endif
		 */
		@SuppressWarnings("null")
		public FUN_getHelper(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.element = (@NonNull LocatedElement)boundValues[1];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ATL_c_c_Helper_0 = idResolver.getClass(CLSSid_Helper, null);
			final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
			final /*@NonInvalid*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_LocatedElement, element);
			final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure_0 = executor.getStaticClassOf(oclAsSet);
			final @NonNull LibraryIteration IMPL_closure_0 = (LibraryIteration)TYPE_closure_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
			final @NonNull Object ACC_closure_0 = IMPL_closure_0.createAccumulatorValue(executor, SET_CLSSid_OclElement, CLSSid_OclElement);
			/**
			 * Implementation of the iteration evaluation body.
			 */
			final @NonNull AbstractBinaryOperation BODY0_closure_1 = new AbstractBinaryOperation()
			{
				/**
				 * e.oclContainer()
				 */
				@Override
				public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ @Nullable Object e_0) {
					if (e_0 == null) {
						throw new InvalidEvaluationException("Null \'\'OclElement\'\' rather than \'\'OclVoid\'\' value required");
					}
					final /*@Thrown*/ @Nullable Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, e_0);
					return oclContainer;
				}
			};
			final @NonNull ExecutorSingleIterationManager MGR_closure_0 = new ExecutorSingleIterationManager(executor, SET_CLSSid_OclElement, BODY0_closure_1, oclAsSet, ACC_closure_0);
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull SetValue closure = (@NonNull SetValue)IMPL_closure_0.evaluateIteration(MGR_closure_0);
			final /*@Thrown*/ @NonNull SetValue helpers = (@Nullable SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, closure, TYP_ATL_c_c_Helper_0);
			final /*@Thrown*/ boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(helpers).booleanValue();
			/*@Thrown*/ @Nullable Helper IF_notEmpty;
			if (notEmpty) {
				@NonNull Iterator<Object> ITERATOR__1 = helpers.iterator();
				/*@Thrown*/ @NonNull Helper any;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						throw new InvalidValueException("Nothing to return for ''any''");
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull Helper _1 = (@NonNull Helper)ITERATOR__1.next();
					/**
					 * true
					 */
					//
					if (ValueUtil.TRUE_VALUE) {			// Carry on till something found
						any = _1;
						break;
					}
				}
				IF_notEmpty = any;
			}
			else {
				IF_notEmpty = null;
			}
			this.instance = IF_notEmpty;
		}

		@Override
		public @Nullable Object getResult() {
			return instance;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @Nullable Object @NonNull [] thoseValues) {
			return this.self == thoseValues[0]
				&& idResolver.oclEquals(this.element, thoseValues[1]);
		}
	}

	/**
	 * ::getModule(element : ATL::LocatedElement[?]) : ATL::Module[1]
	 */
	protected class FUN_getModule extends AbstractComputation
	{
		protected final @NonNull ATL2QVTr self;
		protected /*@NonInvalid*/ LocatedElement element_0;
		protected final /*@Thrown*/ @NonNull Module instance;

		/**
		 * ::getModule : ATL::Module[?]
		 */
		@SuppressWarnings("null")
		public FUN_getModule(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.element_0 = (@Nullable LocatedElement)boundValues[1];
			final /*@Thrown*/ @NonNull Module instance = Helper4getModule.INSTANCE.evaluate(executor, CLSSid_Module, ATL2QVTr.this, element_0);
			this.instance = instance;
		}

		@Override
		public @Nullable Object getResult() {
			return instance;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @Nullable Object @NonNull [] thoseValues) {
			return this.self == thoseValues[0]
				&& idResolver.oclEquals(this.element_0, thoseValues[1]);
		}
	}

	/**
	 * ::getOperation(type : Type[1], name : String[1]) : Operation[1]
	 */
	protected class FUN_getOperation extends AbstractComputation
	{
		protected final @NonNull ATL2QVTr self;
		protected /*@NonInvalid*/ @NonNull Type type;
		protected /*@NonInvalid*/ @NonNull String name;
		protected final /*@NonInvalid*/ @NonNull Operation instance;

		/**
		 * ::getOperation : Operation[?]
		 */
		@SuppressWarnings("null")
		public FUN_getOperation(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.type = (@NonNull Type)boundValues[1];
			this.name = (@NonNull String)boundValues[2];
			final /*@NonInvalid*/ @NonNull Operation instance = Helper4getOperation.INSTANCE.evaluate(executor, CLSSid_Operation_0, ATL2QVTr.this, type, name);
			this.instance = instance;
		}

		@Override
		public @Nullable Object getResult() {
			return instance;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @Nullable Object @NonNull [] thoseValues) {
			return this.self == thoseValues[0]
				&& idResolver.oclEquals(this.type, thoseValues[1])
				&& idResolver.oclEquals(this.name, thoseValues[2]);
		}
	}

	/**
	 * ::getPackage(atlModule : ATL::Module[1], name : String[1]) : Package[?]
	 */
	protected class FUN_getPackage extends AbstractComputation
	{
		protected final @NonNull ATL2QVTr self;
		protected /*@NonInvalid*/ @NonNull Module atlModule_0;
		protected /*@NonInvalid*/ @NonNull String name_0;
		protected final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Package instance;

		/**
		 * ::getPackage : Package[?]
		 */
		@SuppressWarnings("null")
		public FUN_getPackage(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.atlModule_0 = (@NonNull Module)boundValues[1];
			this.name_0 = (@NonNull String)boundValues[2];
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Package instance = Helper4getPackage.INSTANCE.evaluate(executor, CLSSid_Package, ATL2QVTr.this, atlModule_0, name_0);
			this.instance = instance;
		}

		@Override
		public @Nullable Object getResult() {
			return instance;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @Nullable Object @NonNull [] thoseValues) {
			return this.self == thoseValues[0]
				&& idResolver.oclEquals(this.atlModule_0, thoseValues[1])
				&& idResolver.oclEquals(this.name_0, thoseValues[2]);
		}
	}

	/**
	 * ::getProperty(type : Type[1], name : String[1]) : Property[1]
	 */
	protected class FUN_getProperty extends AbstractComputation
	{
		protected final @NonNull ATL2QVTr self;
		protected /*@NonInvalid*/ @NonNull Type type_0;
		protected /*@NonInvalid*/ @NonNull String name_1;
		protected final /*@NonInvalid*/ @NonNull Property instance;

		/**
		 * ::getProperty : Property[?]
		 */
		@SuppressWarnings("null")
		public FUN_getProperty(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.type_0 = (@NonNull Type)boundValues[1];
			this.name_1 = (@NonNull String)boundValues[2];
			final /*@NonInvalid*/ @NonNull Property instance = Helper4getProperty.INSTANCE.evaluate(executor, CLSSid_Property, ATL2QVTr.this, type_0, name_1);
			this.instance = instance;
		}

		@Override
		public @Nullable Object getResult() {
			return instance;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @Nullable Object @NonNull [] thoseValues) {
			return this.self == thoseValues[0]
				&& idResolver.oclEquals(this.type_0, thoseValues[1])
				&& idResolver.oclEquals(this.name_1, thoseValues[2]);
		}
	}

	/**
	 * ::getType(type : OCL::OclType[?]) : Class[1]
	 */
	protected class FUN_getType extends AbstractComputation
	{
		protected final @NonNull ATL2QVTr self;
		protected /*@NonInvalid*/ OclType type_1;
		protected final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Class instance;

		/**
		 * ::getType : Class[?]
		 */
		@SuppressWarnings("null")
		public FUN_getType(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.type_1 = (@Nullable OclType)boundValues[1];
			final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Class instance = Helper4getType.INSTANCE.evaluate(executor, CLSSid_Class, ATL2QVTr.this, type_1);
			this.instance = instance;
		}

		@Override
		public @Nullable Object getResult() {
			return instance;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @Nullable Object @NonNull [] thoseValues) {
			return this.self == thoseValues[0]
				&& idResolver.oclEquals(this.type_1, thoseValues[1]);
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
	 * buffer:1 jm_TmapNullLiteralExp : trace_ATL2QVTr::TmapNullLiteralExp[1];
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
	 * jm_TmapNullLiteralExp appendsTo jm_TmapNullLiteralExp;
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
	 *   install mmapNullLiteralExp__qvtr__init__ {
	 * trace consumes buffer:1 jm_TmapNullLiteralExp : trace_ATL2QVTr::TmapNullLiteralExp[1];
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
	 *   install mmapNullLiteralExp__qvtr__rest__ {
	 * trace consumes buffer:1 jm_TmapNullLiteralExp : trace_ATL2QVTr::TmapNullLiteralExp[1];
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
	 *   install mmapSimpleInPatternElement__qvtr__rest__ {
	 * trace consumes buffer:1 jm_TmapSimpleInPatternElement : trace_ATL2QVTr::TmapSimpleInPatternElement[1];
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
	 *   install mmapVariableExp__referredVariable__VariableDeclarat {
	 * trace consumes buffer:3 jm_TmapVariableExp__referredVariable__VariableDecl : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1];
	 * ;
	 * }
	 *   install mmapVariableExp__referredVariable__Helper__qvtr__xt {
	 * trace consumes buffer:3 jm_TmapVariableExp__referredVariable__Helper : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * ;
	 * }
	 *   install mmapVariableExp__referredVariable__VariableDeclarat_1 {
	 * trace consumes buffer:3 jm_TmapVariableExp__referredVariable__VariableDecl : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1];
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
			final @NonNull Connection jm_DmapHelper_1 = lazyCreateInterval(1).createConnection("jm_DmapHelper", CLSSid_DmapHelper, false, modeFactory);
			final @NonNull Connection jm_DmapOclExpression_1 = lazyCreateInterval(1).createConnection("jm_DmapOclExpression", CLSSid_DmapOclExpression, false, modeFactory);
			final @NonNull Connection jm_DmapVariableExp__referredVariable_1 = lazyCreateInterval(2).createConnection("jm_DmapVariableExp__referredVariable", CLSSid_DmapVariableExp_referredVariable, false, modeFactory);
			final @NonNull Connection jm_TmapBinding_1 = lazyCreateInterval(1).createConnection("jm_TmapBinding", CLSSid_TmapBinding, false, modeFactory);
			final @NonNull Connection jm_TmapBooleanExp_1 = lazyCreateInterval(1).createConnection("jm_TmapBooleanExp", CLSSid_TmapBooleanExp, false, modeFactory);
			final @NonNull Connection jm_TmapHelper__Attribute_1 = lazyCreateInterval(1).createConnection("jm_TmapHelper__Attribute", CLSSid_TmapHelper_Attribute, false, modeFactory);
			final @NonNull Connection jm_TmapHelper__Context_3 = lazyCreateInterval(5).createConnection("jm_TmapHelper__Context", CLSSid_TmapHelper_Context, false, modeFactory);
			final @NonNull Connection jm_TmapHelper__Operation_1 = lazyCreateInterval(1).createConnection("jm_TmapHelper__Operation", CLSSid_TmapHelper_Operation, false, modeFactory);
			final @NonNull Connection jm_TmapIfExp_1 = lazyCreateInterval(1).createConnection("jm_TmapIfExp", CLSSid_TmapIfExp, false, modeFactory);
			final @NonNull Connection jm_TmapInPattern_1 = lazyCreateInterval(1).createConnection("jm_TmapInPattern", CLSSid_TmapInPattern, false, modeFactory);
			final @NonNull Connection jm_TmapInPattern__filter_1 = lazyCreateInterval(1).createConnection("jm_TmapInPattern__filter", CLSSid_TmapInPattern_filter, false, modeFactory);
			final @NonNull Connection jm_TmapIntegerExp_1 = lazyCreateInterval(1).createConnection("jm_TmapIntegerExp", CLSSid_TmapIntegerExp, false, modeFactory);
			final @NonNull Connection jm_TmapMatchedRule_1 = lazyCreateInterval(1).createConnection("jm_TmapMatchedRule", CLSSid_TmapMatchedRule, false, modeFactory);
			final @NonNull Connection jm_TmapMatchedRule__super_1 = lazyCreateInterval(1).createConnection("jm_TmapMatchedRule__super", CLSSid_TmapMatchedRule_super, false, modeFactory);
			final @NonNull Connection jm_TmapModule_1 = lazyCreateInterval(1).createConnection("jm_TmapModule", CLSSid_TmapModule, false, modeFactory);
			final @NonNull Connection jm_TmapNavigationOrAttributeCallExp__Helper_1 = lazyCreateInterval(1).createConnection("jm_TmapNavigationOrAttributeCallExp__Helper", CLSSid_TmapNavigationOrAttributeCallExp_Helper, false, modeFactory);
			final @NonNull Connection jm_TmapNavigationOrAttributeCallExp__Property_1 = lazyCreateInterval(1).createConnection("jm_TmapNavigationOrAttributeCallExp__Property", CLSSid_TmapNavigationOrAttributeCallExp_Property, false, modeFactory);
			final @NonNull Connection jm_TmapNullLiteralExp_1 = lazyCreateInterval(1).createConnection("jm_TmapNullLiteralExp", CLSSid_TmapNullLiteralExp, false, modeFactory);
			final @NonNull Connection jm_TmapOclMetamodel_1 = lazyCreateInterval(1).createConnection("jm_TmapOclMetamodel", CLSSid_TmapOclMetamodel, false, modeFactory);
			final @NonNull Connection jm_TmapOclModel__IN_1 = lazyCreateInterval(1).createConnection("jm_TmapOclModel__IN", CLSSid_TmapOclModel_IN, false, modeFactory);
			final @NonNull Connection jm_TmapOclModel__OUT_1 = lazyCreateInterval(1).createConnection("jm_TmapOclModel__OUT", CLSSid_TmapOclModel_OUT, false, modeFactory);
			final @NonNull Connection jm_TmapOclType_1 = lazyCreateInterval(1).createConnection("jm_TmapOclType", CLSSid_TmapOclType, false, modeFactory);
			final @NonNull Connection jm_TmapOperationCallExp__Helper_1 = lazyCreateInterval(1).createConnection("jm_TmapOperationCallExp__Helper", CLSSid_TmapOperationCallExp_Helper, false, modeFactory);
			final @NonNull Connection jm_TmapOperationCallExp__Operation_1 = lazyCreateInterval(1).createConnection("jm_TmapOperationCallExp__Operation", CLSSid_TmapOperationCallExp_Operation, false, modeFactory);
			final @NonNull Connection jm_TmapOperationCallExp__argument_1 = lazyCreateInterval(1).createConnection("jm_TmapOperationCallExp__argument", CLSSid_TmapOperationCallExp_argument, false, modeFactory);
			final @NonNull Connection jm_TmapOperatorCallExp_1 = lazyCreateInterval(1).createConnection("jm_TmapOperatorCallExp", CLSSid_TmapOperatorCallExp, false, modeFactory);
			final @NonNull Connection jm_TmapSimpleInPatternElement_1 = lazyCreateInterval(1).createConnection("jm_TmapSimpleInPatternElement", CLSSid_TmapSimpleInPatternElement, false, modeFactory);
			final @NonNull Connection jm_TmapSimpleOutPatternElement_1 = lazyCreateInterval(1).createConnection("jm_TmapSimpleOutPatternElement", CLSSid_TmapSimpleOutPatternElement, false, modeFactory);
			final @NonNull Connection jm_TmapStringExp_1 = lazyCreateInterval(1).createConnection("jm_TmapStringExp", CLSSid_TmapStringExp, false, modeFactory);
			final @NonNull Connection jm_TmapVariable_5 = lazyCreateInterval(4).createConnection("jm_TmapVariable", CLSSid_TmapVariable, false, modeFactory);
			final @NonNull Connection jm_TmapVariableExp_1 = lazyCreateInterval(1).createConnection("jm_TmapVariableExp", CLSSid_TmapVariableExp, false, modeFactory);
			final @NonNull Connection jm_TmapVariableExp__referredVariable__Helper_1 = lazyCreateInterval(3).createConnection("jm_TmapVariableExp__referredVariable__Helper", CLSSid_TmapVariableExp_referredVariable_Helper, false, modeFactory);
			final @NonNull Connection jm_TmapVariableExp__referredVariable__VariableDecl_1 = lazyCreateInterval(3).createConnection("jm_TmapVariableExp__referredVariable__VariableDecl", CLSSid_TmapVariableExp_referredVariable_VariableDeclaration, false, modeFactory);
			// mapping statements
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapBinding__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull Binding atlBinding_0 : ji_Binding.typedIterable(Binding.class)) {
						MAP_mmapBinding__qvtr__ctor__(atlBinding_0, jm_TmapBinding_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapHelper__dispatch__qvtr") {
				@Override
				public boolean execute() {
					for (@NonNull Helper atlHelper_0 : ji_Helper.typedIterable(Helper.class)) {
						MAP_mmapHelper__dispatch__qvtr(atlHelper_0, jm_DmapHelper_1, jm_TmapHelper__Attribute_1, jm_TmapHelper__Operation_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapInPattern__filter__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull InPattern atlPattern_1 : ji_InPattern.typedIterable(InPattern.class)) {
						MAP_mmapInPattern__filter__qvtr__ctor__(atlPattern_1, jm_TmapInPattern__filter_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapInPattern__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull InPattern atlPattern_2 : ji_InPattern.typedIterable(InPattern.class)) {
						MAP_mmapInPattern__qvtr__ctor__(atlPattern_2, jm_TmapInPattern_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapMatchedRule__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull MatchedRule matchedRule_0 : ji_MatchedRule.typedIterable(MatchedRule.class)) {
						MAP_mmapMatchedRule__qvtr__ctor__(jm_TmapMatchedRule_1, matchedRule_0);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapMatchedRule__super__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull MatchedRule atlChildRule_0 : ji_MatchedRule.typedIterable(MatchedRule.class)) {
						MAP_mmapMatchedRule__super__qvtr__ctor__(atlChildRule_0, jm_TmapMatchedRule__super_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapModule__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull Module atlModule_1 : ji_Module.typedIterable(Module.class)) {
						MAP_mmapModule__qvtr__ctor__(atlModule_1, jm_TmapModule_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapOclExpression__dispatch__qvtr") {
				@Override
				public boolean execute() {
					for (@NonNull OclExpression atlExpression_0 : ji_OclExpression.typedIterable(OclExpression.class)) {
						MAP_mmapOclExpression__dispatch__qvtr(atlExpression_0, jm_DmapOclExpression_1, jm_TmapBooleanExp_1, jm_TmapIfExp_1, jm_TmapIntegerExp_1, jm_TmapNavigationOrAttributeCallExp__Helper_1, jm_TmapNavigationOrAttributeCallExp__Property_1, jm_TmapNullLiteralExp_1, jm_TmapOclType_1, jm_TmapOperationCallExp__Helper_1, jm_TmapOperationCallExp__Operation_1, jm_TmapOperatorCallExp_1, jm_TmapStringExp_1, jm_TmapVariableExp_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapOclMetamodel__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull OclModel oclMetamodel_0 : ji_OclModel.typedIterable(OclModel.class)) {
						MAP_mmapOclMetamodel__qvtr__ctor__(jm_TmapOclMetamodel_1, oclMetamodel_0);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapOclModel__IN__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull OclModel oclModel_1 : ji_OclModel.typedIterable(OclModel.class)) {
						MAP_mmapOclModel__IN__qvtr__ctor__(jm_TmapOclModel__IN_1, oclModel_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapOclModel__OUT__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull OclModel oclModel_2 : ji_OclModel.typedIterable(OclModel.class)) {
						MAP_mmapOclModel__OUT__qvtr__ctor__(jm_TmapOclModel__OUT_1, oclModel_2);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapOperationCallExp__argument__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull OclExpression atlArgument_0 : ji_OclExpression.typedIterable(OclExpression.class)) {
						MAP_mmapOperationCallExp__argument__qvtr__ctor__(atlArgument_0, jm_TmapOperationCallExp__argument_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapSimpleInPatternElement__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull SimpleInPatternElement atlElement_1 : ji_SimpleInPatternElement.typedIterable(SimpleInPatternElement.class)) {
						MAP_mmapSimpleInPatternElement__qvtr__ctor__(atlElement_1, jm_TmapSimpleInPatternElement_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapSimpleOutPatternElement__qvtr__ctor__") {
				@Override
				public boolean execute() {
					for (@NonNull SimpleOutPatternElement atlElement_2 : ji_SimpleOutPatternElement.typedIterable(SimpleOutPatternElement.class)) {
						MAP_mmapSimpleOutPatternElement__qvtr__ctor__(atlElement_2, jm_TmapSimpleOutPatternElement_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapBooleanExp__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapBooleanExp trace_65 : jm_TmapBooleanExp_1.typedIterable(TmapBooleanExp.class)) {
						MAP_mmapBooleanExp__qvtr__init__(trace_65);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapIfExp__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapIfExp trace_66 : jm_TmapIfExp_1.typedIterable(TmapIfExp.class)) {
						MAP_mmapIfExp__qvtr__init__(trace_66);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapIntegerExp__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapIntegerExp trace_67 : jm_TmapIntegerExp_1.typedIterable(TmapIntegerExp.class)) {
						MAP_mmapIntegerExp__qvtr__init__(trace_67);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapModule__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapModule trace_68 : jm_TmapModule_1.typedIterable(TmapModule.class)) {
						MAP_mmapModule__qvtr__init__(trace_68);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapNavigationOrAttributeCallExp__Property__qvtr__i") {
				@Override
				public boolean execute() {
					for (@NonNull TmapNavigationOrAttributeCallExp_Property trace_69 : jm_TmapNavigationOrAttributeCallExp__Property_1.typedIterable(TmapNavigationOrAttributeCallExp_Property.class)) {
						MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__i(trace_69);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapNullLiteralExp__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapNullLiteralExp trace_70 : jm_TmapNullLiteralExp_1.typedIterable(TmapNullLiteralExp.class)) {
						MAP_mmapNullLiteralExp__qvtr__init__(trace_70);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapOclMetamodel__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOclMetamodel trace_71 : jm_TmapOclMetamodel_1.typedIterable(TmapOclMetamodel.class)) {
						MAP_mmapOclMetamodel__qvtr__init__(trace_71);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapOclType__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOclType trace_72 : jm_TmapOclType_1.typedIterable(TmapOclType.class)) {
						MAP_mmapOclType__qvtr__init__(trace_72);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapOperationCallExp__Operation__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperationCallExp_Operation trace_73 : jm_TmapOperationCallExp__Operation_1.typedIterable(TmapOperationCallExp_Operation.class)) {
						MAP_mmapOperationCallExp__Operation__qvtr__init__(trace_73);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapOperatorCallExp__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperatorCallExp trace_74 : jm_TmapOperatorCallExp_1.typedIterable(TmapOperatorCallExp.class)) {
						MAP_mmapOperatorCallExp__qvtr__init__(trace_74);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapStringExp__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapStringExp trace_75 : jm_TmapStringExp_1.typedIterable(TmapStringExp.class)) {
						MAP_mmapStringExp__qvtr__init__(trace_75);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapVariableExp__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapVariableExp trace_76 : jm_TmapVariableExp_1.typedIterable(TmapVariableExp.class)) {
						MAP_mmapVariableExp__qvtr__init__(jm_DmapVariableExp__referredVariable_1, trace_76);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapBooleanExp__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapBooleanExp trace_77 : jm_TmapBooleanExp_1.typedIterable(TmapBooleanExp.class)) {
						MAP_mmapBooleanExp__qvtr__rest__(trace_77);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapHelper__Attribute__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapHelper_Attribute trace_78 : jm_TmapHelper__Attribute_1.typedIterable(TmapHelper_Attribute.class)) {
						MAP_mmapHelper__Attribute__qvtr__init__(trace_78);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapHelper__Operation__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapHelper_Operation trace_79 : jm_TmapHelper__Operation_1.typedIterable(TmapHelper_Operation.class)) {
						MAP_mmapHelper__Operation__qvtr__init__(trace_79);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapIntegerExp__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapIntegerExp trace_80 : jm_TmapIntegerExp_1.typedIterable(TmapIntegerExp.class)) {
						MAP_mmapIntegerExp__qvtr__rest__(trace_80);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapMatchedRule__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapMatchedRule trace_81 : jm_TmapMatchedRule_1.typedIterable(TmapMatchedRule.class)) {
						MAP_mmapMatchedRule__qvtr__init__(trace_81);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapNullLiteralExp__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapNullLiteralExp trace_82 : jm_TmapNullLiteralExp_1.typedIterable(TmapNullLiteralExp.class)) {
						MAP_mmapNullLiteralExp__qvtr__rest__(trace_82);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapOclModel__IN__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOclModel_IN trace_83 : jm_TmapOclModel__IN_1.typedIterable(TmapOclModel_IN.class)) {
						MAP_mmapOclModel__IN__qvtr__init__(trace_83);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapOclModel__OUT__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOclModel_OUT trace_84 : jm_TmapOclModel__OUT_1.typedIterable(TmapOclModel_OUT.class)) {
						MAP_mmapOclModel__OUT__qvtr__init__(trace_84);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapOclType__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOclType trace_85 : jm_TmapOclType_1.typedIterable(TmapOclType.class)) {
						MAP_mmapOclType__qvtr__rest__(trace_85);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapStringExp__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapStringExp trace_86 : jm_TmapStringExp_1.typedIterable(TmapStringExp.class)) {
						MAP_mmapStringExp__qvtr__rest__(trace_86);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapVariableExp__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapVariableExp trace_87 : jm_TmapVariableExp_1.typedIterable(TmapVariableExp.class)) {
						MAP_mmapVariableExp__qvtr__rest__(trace_87);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapVariableExp__referredVariable__dispatch__qvtr") {
				@Override
				public boolean execute() {
					for (@NonNull DmapVariableExp_referredVariable dispatcher_0 : jm_DmapVariableExp__referredVariable_1.typedIterable(DmapVariableExp_referredVariable.class)) {
						MAP_mmapVariableExp__referredVariable__dispatch__qvtr(dispatcher_0, jm_TmapVariableExp__referredVariable__Helper_1, jm_TmapVariableExp__referredVariable__VariableDecl_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(4/*..null*/), "mmapInPattern__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapInPattern trace_88 : jm_TmapInPattern_1.typedIterable(TmapInPattern.class)) {
						MAP_mmapInPattern__qvtr__init__(trace_88);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(4/*..null*/), "mmapMatchedRule__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapMatchedRule trace_89 : jm_TmapMatchedRule_1.typedIterable(TmapMatchedRule.class)) {
						MAP_mmapMatchedRule__qvtr__rest__(trace_89);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(4/*..null*/), "mmapMatchedRule__super__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapMatchedRule_super trace_90 : jm_TmapMatchedRule__super_1.typedIterable(TmapMatchedRule_super.class)) {
						MAP_mmapMatchedRule__super__qvtr__init__(trace_90);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(4/*..null*/), "mmapSimpleOutPatternElement__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapSimpleOutPatternElement trace_91 : jm_TmapSimpleOutPatternElement_1.typedIterable(TmapSimpleOutPatternElement.class)) {
						MAP_mmapSimpleOutPatternElement__qvtr__init__(jm_TmapVariable_5, trace_91);
					}
					return true;
				}
			};
			CTOR_mmapHelper__Attribute__qvtr__loop__.addAppendedConnection(jm_TmapHelper__Context_3);
			CTOR_mmapHelper__Attribute__qvtr__loop__.addConsumedConnection(jm_TmapHelper__Attribute_1);
			CTOR_mmapHelper__Context__qvtr__loop__.addAppendedConnection(jm_TmapVariable_5);
			CTOR_mmapHelper__Context__qvtr__loop__.addConsumedConnection(jm_TmapHelper__Context_3);
			CTOR_mmapHelper__Operation__qvtr__loop__.addAppendedConnection(jm_TmapHelper__Context_3);
			CTOR_mmapHelper__Operation__qvtr__loop__.addConsumedConnection(jm_TmapHelper__Operation_1);
			CTOR_mmapHelper__verdict__qvtr.addConsumedConnection(jm_DmapHelper_1);
			new AbstractSimpleInvocation(lazyCreateInterval(5/*..null*/), "mmapIfExp__qvtr__loop__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapIfExp trace_95 : jm_TmapIfExp_1.typedIterable(TmapIfExp.class)) {
						MAP_mmapIfExp__qvtr__loop__(trace_95);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(5/*..null*/), "mmapModule__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapModule trace_96 : jm_TmapModule_1.typedIterable(TmapModule.class)) {
						MAP_mmapModule__qvtr__rest__(trace_96);
					}
					return true;
				}
			};
			CTOR_mmapNavigationOrAttributeCallExp__Helper__qvtr__ini.addConsumedConnection(jm_TmapNavigationOrAttributeCallExp__Helper_1);
			CTOR_mmapNavigationOrAttributeCallExp__Helper__qvtr__loo.addConsumedConnection(jm_TmapNavigationOrAttributeCallExp__Helper_1);
			CTOR_mmapNavigationOrAttributeCallExp__Property__qvtr__l.addConsumedConnection(jm_TmapNavigationOrAttributeCallExp__Property_1);
			CTOR_mmapOclExpression__verdict__qvtr.addConsumedConnection(jm_DmapOclExpression_1);
			CTOR_mmapOperationCallExp__Helper__qvtr__init__.addConsumedConnection(jm_TmapOperationCallExp__Helper_1);
			CTOR_mmapOperationCallExp__Helper__qvtr__loop__.addConsumedConnection(jm_TmapOperationCallExp__Helper_1);
			CTOR_mmapOperationCallExp__Operation__qvtr__loop__.addConsumedConnection(jm_TmapOperationCallExp__Operation_1);
			CTOR_mmapOperatorCallExp__qvtr__loop__.addConsumedConnection(jm_TmapOperatorCallExp_1);
			new AbstractSimpleInvocation(lazyCreateInterval(6/*..null*/), "mmapInPattern__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapInPattern trace_104 : jm_TmapInPattern_1.typedIterable(TmapInPattern.class)) {
						MAP_mmapInPattern__qvtr__rest__(trace_104);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(6/*..null*/), "mmapSimpleInPatternElement__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapSimpleInPatternElement trace_105 : jm_TmapSimpleInPatternElement_1.typedIterable(TmapSimpleInPatternElement.class)) {
						MAP_mmapSimpleInPatternElement__qvtr__init__(jm_TmapVariable_5, trace_105);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(6/*..null*/), "mmapSimpleOutPatternElement__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapSimpleOutPatternElement trace_106 : jm_TmapSimpleOutPatternElement_1.typedIterable(TmapSimpleOutPatternElement.class)) {
						MAP_mmapSimpleOutPatternElement__qvtr__rest__(trace_106);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(6/*..null*/), "mmapVariableExp__referredVariable__Helper__qvtr__in") {
				@Override
				public boolean execute() {
					for (@NonNull TmapVariableExp_referredVariable_Helper trace_107 : jm_TmapVariableExp__referredVariable__Helper_1.typedIterable(TmapVariableExp_referredVariable_Helper.class)) {
						MAP_mmapVariableExp__referredVariable__Helper__qvtr__in(trace_107);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapBinding__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapBinding trace_108 : jm_TmapBinding_1.typedIterable(TmapBinding.class)) {
						MAP_mmapBinding__qvtr__init__(trace_108);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapHelper__Attribute__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapHelper_Attribute trace_109 : jm_TmapHelper__Attribute_1.typedIterable(TmapHelper_Attribute.class)) {
						MAP_mmapHelper__Attribute__qvtr__rest__(trace_109);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapHelper__Operation__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapHelper_Operation trace_110 : jm_TmapHelper__Operation_1.typedIterable(TmapHelper_Operation.class)) {
						MAP_mmapHelper__Operation__qvtr__rest__(trace_110);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapIfExp__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapIfExp trace_111 : jm_TmapIfExp_1.typedIterable(TmapIfExp.class)) {
						MAP_mmapIfExp__qvtr__rest__(trace_111);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapInPattern__filter__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapInPattern_filter trace_112 : jm_TmapInPattern__filter_1.typedIterable(TmapInPattern_filter.class)) {
						MAP_mmapInPattern__filter__qvtr__init__(trace_112);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapNavigationOrAttributeCallExp__Helper__qvtr__res") {
				@Override
				public boolean execute() {
					for (@NonNull TmapNavigationOrAttributeCallExp_Helper trace_113 : jm_TmapNavigationOrAttributeCallExp__Helper_1.typedIterable(TmapNavigationOrAttributeCallExp_Helper.class)) {
						MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__res(trace_113);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapNavigationOrAttributeCallExp__Property__qvtr__r") {
				@Override
				public boolean execute() {
					for (@NonNull TmapNavigationOrAttributeCallExp_Property trace_114 : jm_TmapNavigationOrAttributeCallExp__Property_1.typedIterable(TmapNavigationOrAttributeCallExp_Property.class)) {
						MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__r(trace_114);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapOperationCallExp__Helper__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperationCallExp_Helper trace_115 : jm_TmapOperationCallExp__Helper_1.typedIterable(TmapOperationCallExp_Helper.class)) {
						MAP_mmapOperationCallExp__Helper__qvtr__rest__(trace_115);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapOperationCallExp__Operation__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperationCallExp_Operation trace_116 : jm_TmapOperationCallExp__Operation_1.typedIterable(TmapOperationCallExp_Operation.class)) {
						MAP_mmapOperationCallExp__Operation__qvtr__rest__(trace_116);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapOperationCallExp__argument__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperationCallExp_argument trace_117 : jm_TmapOperationCallExp__argument_1.typedIterable(TmapOperationCallExp_argument.class)) {
						MAP_mmapOperationCallExp__argument__qvtr__init__(trace_117);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapOperatorCallExp__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperatorCallExp trace_118 : jm_TmapOperatorCallExp_1.typedIterable(TmapOperatorCallExp.class)) {
						MAP_mmapOperatorCallExp__qvtr__rest__(trace_118);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapSimpleInPatternElement__qvtr__rest__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapSimpleInPatternElement trace_119 : jm_TmapSimpleInPatternElement_1.typedIterable(TmapSimpleInPatternElement.class)) {
						MAP_mmapSimpleInPatternElement__qvtr__rest__(trace_119);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapVariable__qvtr__init__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapVariable trace_120 : jm_TmapVariable_5.typedIterable(TmapVariable.class)) {
						MAP_mmapVariable__qvtr__init__(trace_120);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(8/*..null*/), "mmapNavigationOrAttributeCallExp__Helper__qvtr__xtr") {
				@Override
				public boolean execute() {
					for (@NonNull TmapNavigationOrAttributeCallExp_Helper trace_121 : jm_TmapNavigationOrAttributeCallExp__Helper_1.typedIterable(TmapNavigationOrAttributeCallExp_Helper.class)) {
						MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__xtr(trace_121);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(8/*..null*/), "mmapOperationCallExp__Helper__qvtr__xtra__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperationCallExp_Helper trace_122 : jm_TmapOperationCallExp__Helper_1.typedIterable(TmapOperationCallExp_Helper.class)) {
						MAP_mmapOperationCallExp__Helper__qvtr__xtra__(trace_122);
					}
					return true;
				}
			};
			CTOR_mmapVariableExp__referredVariable__Helper__qvtr__lo.addConsumedConnection(jm_TmapVariableExp__referredVariable__Helper_1);
			new AbstractSimpleInvocation(lazyCreateInterval(8/*..null*/), "mmapVariableExp__referredVariable__VariableDeclarat") {
				@Override
				public boolean execute() {
					for (@NonNull TmapVariableExp_referredVariable_VariableDeclaration trace_124 : jm_TmapVariableExp__referredVariable__VariableDecl_1.typedIterable(TmapVariableExp_referredVariable_VariableDeclaration.class)) {
						MAP_mmapVariableExp__referredVariable__VariableDeclarat(trace_124);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapVariableExp__referredVariable__Helper__qvtr__xt") {
				@Override
				public boolean execute() {
					for (@NonNull TmapVariableExp_referredVariable_Helper trace_125 : jm_TmapVariableExp__referredVariable__Helper_1.typedIterable(TmapVariableExp_referredVariable_Helper.class)) {
						MAP_mmapVariableExp__referredVariable__Helper__qvtr__xt(trace_125);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapVariableExp__referredVariable__VariableDeclarat_1") {
				@Override
				public boolean execute() {
					for (@NonNull TmapVariableExp_referredVariable_VariableDeclaration trace_126 : jm_TmapVariableExp__referredVariable__VariableDecl_1.typedIterable(TmapVariableExp_referredVariable_VariableDeclaration.class)) {
						MAP_mmapVariableExp__referredVariable__VariableDeclarat_1(trace_126);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(10/*..null*/), "mmapVariableExp__referredVariable__verdict__qvtr") {
				@Override
				public boolean execute() {
					for (@NonNull DmapVariableExp_referredVariable mapVariableExp_referredVariable_0 : jm_DmapVariableExp__referredVariable_1.typedIterable(DmapVariableExp_referredVariable.class)) {
						MAP_mmapVariableExp__referredVariable__verdict__qvtr(mapVariableExp_referredVariable_0);
					}
					return true;
				}
			};
			CTOR_mmapIfExp__qvtr__xtra__.addConsumedConnection(jm_TmapIfExp_1);
			CTOR_mmapNavigationOrAttributeCallExp__Property__qvtr__x.addConsumedConnection(jm_TmapNavigationOrAttributeCallExp__Property_1);
			CTOR_mmapOperationCallExp__Operation__qvtr__xtra__.addConsumedConnection(jm_TmapOperationCallExp__Operation_1);
			CTOR_mmapOperatorCallExp__qvtr__xtra__.addConsumedConnection(jm_TmapOperatorCallExp_1);
			final /*@Thrown*/ @Nullable Boolean r_ATL2QVTr__qvtr__load__ = ValueUtil.TRUE_VALUE;
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
		final @SuppressWarnings("null")@NonNull TmapBinding trace_65 = trace_ATL2QVTrFactory.eINSTANCE.createTmapBinding();
		models[4/*middle*/].add(trace_65, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_65));
		}
		// mapping statements
		trace_65.setT3atlBinding(atlBinding);
		jm_TmapBinding.appendElement(trace_65);
		final /*@Thrown*/ @Nullable Boolean mmapBinding__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
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
		final @SuppressWarnings("null")@NonNull DmapHelper dispatcher_0 = trace_ATL2QVTrFactory.eINSTANCE.createDmapHelper();
		models[4/*middle*/].add(dispatcher_0, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(dispatcher_0));
		}
		final @SuppressWarnings("null")@NonNull TmapHelper_Attribute mapHelper_Attribute = trace_ATL2QVTrFactory.eINSTANCE.createTmapHelper_Attribute();
		models[4/*middle*/].add(mapHelper_Attribute, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapHelper_Attribute));
		}
		final @SuppressWarnings("null")@NonNull TmapHelper_Operation mapHelper_Operation = trace_ATL2QVTrFactory.eINSTANCE.createTmapHelper_Operation();
		models[4/*middle*/].add(mapHelper_Operation, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapHelper_Operation));
		}
		// mapping statements
		OPPOSITE_OF_DmapHelper_d3atlHelper.put(atlHelper, dispatcher_0);
		dispatcher_0.setD3atlHelper(atlHelper);
		dispatcher_0.setDomapHelper_Attribute(mapHelper_Attribute);
		dispatcher_0.setDomapHelper_Operation(mapHelper_Operation);
		jm_DmapHelper.appendElement(dispatcher_0);
		jm_TmapHelper__Attribute.appendElement(mapHelper_Attribute);
		jm_TmapHelper__Operation.appendElement(mapHelper_Operation);
		final /*@Thrown*/ @Nullable Boolean mmapHelper__dispatch__qvtr = ValueUtil.TRUE_VALUE;
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
		final @SuppressWarnings("null")@NonNull TmapInPattern_filter trace_65 = trace_ATL2QVTrFactory.eINSTANCE.createTmapInPattern_filter();
		models[4/*middle*/].add(trace_65, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_65));
		}
		// mapping statements
		trace_65.setT3atlPattern(atlPattern);
		jm_TmapInPattern__filter.appendElement(trace_65);
		final /*@Thrown*/ @Nullable Boolean mmapInPattern__filter__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
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
	protected boolean MAP_mmapInPattern__qvtr__ctor__(final /*@NonInvalid*/ @NonNull InPattern atlPattern_0, final @NonNull Connection jm_TmapInPattern)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapInPattern__qvtr__ctor__" +
				"\n\t\"atlPattern\":" + toDebugString(atlPattern_0));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapInPattern trace_65 = trace_ATL2QVTrFactory.eINSTANCE.createTmapInPattern();
		models[4/*middle*/].add(trace_65, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_65));
		}
		// mapping statements
		OPPOSITE_OF_TmapInPattern_t3atlPattern.put(atlPattern_0, trace_65);
		trace_65.setT3atlPattern(atlPattern_0);
		jm_TmapInPattern.appendElement(trace_65);
		final /*@Thrown*/ @Nullable Boolean mmapInPattern__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
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
		final @SuppressWarnings("null")@NonNull TmapMatchedRule trace_65 = trace_ATL2QVTrFactory.eINSTANCE.createTmapMatchedRule();
		models[4/*middle*/].add(trace_65, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_65));
		}
		// mapping statements
		OPPOSITE_OF_TmapMatchedRule_t3matchedRule.put(matchedRule, trace_65);
		trace_65.setT3matchedRule(matchedRule);
		jm_TmapMatchedRule.appendElement(trace_65);
		final /*@Thrown*/ @Nullable Boolean mmapMatchedRule__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
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
		final @SuppressWarnings("null")@NonNull TmapMatchedRule_super trace_65 = trace_ATL2QVTrFactory.eINSTANCE.createTmapMatchedRule_super();
		models[4/*middle*/].add(trace_65, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_65));
		}
		// mapping statements
		trace_65.setT3atlChildRule(atlChildRule);
		jm_TmapMatchedRule__super.appendElement(trace_65);
		final /*@Thrown*/ @Nullable Boolean mmapMatchedRule__super__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
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
		final @SuppressWarnings("null")@NonNull TmapModule trace_65 = trace_ATL2QVTrFactory.eINSTANCE.createTmapModule();
		models[4/*middle*/].add(trace_65, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_65));
		}
		// mapping statements
		OPPOSITE_OF_TmapModule_t3atlModule.put(atlModule, trace_65);
		trace_65.setT3atlModule(atlModule);
		jm_TmapModule.appendElement(trace_65);
		final /*@Thrown*/ @Nullable Boolean mmapModule__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
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
	 * append jm_TmapNullLiteralExp  : trace_ATL2QVTr::TmapNullLiteralExp[1];
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
	 * new:middle mapNullLiteralExp : trace_ATL2QVTr::TmapNullLiteralExp[1];
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
	 * set dispatcher.domapNullLiteralExp := mapNullLiteralExp;
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
	 * add jm_TmapNullLiteralExp += mapNullLiteralExp;
	 * add jm_TmapOclType += mapOclType;
	 * add jm_TmapOperationCallExp__Helper += mapOperationCallExp_Helper;
	 * add jm_TmapOperationCallExp__Operation += mapOperationCallExp_Operation;
	 * add jm_TmapOperatorCallExp += mapOperatorCallExp;
	 * add jm_TmapStringExp += mapStringExp;
	 * add jm_TmapVariableExp += mapVariableExp;
	 *
	 */
	protected boolean MAP_mmapOclExpression__dispatch__qvtr(final /*@NonInvalid*/ @NonNull OclExpression atlExpression, final @NonNull Connection jm_DmapOclExpression, final @NonNull Connection jm_TmapBooleanExp, final @NonNull Connection jm_TmapIfExp, final @NonNull Connection jm_TmapIntegerExp, final @NonNull Connection jm_TmapNavigationOrAttributeCallExp__Helper, final @NonNull Connection jm_TmapNavigationOrAttributeCallExp__Property, final @NonNull Connection jm_TmapNullLiteralExp, final @NonNull Connection jm_TmapOclType, final @NonNull Connection jm_TmapOperationCallExp__Helper, final @NonNull Connection jm_TmapOperationCallExp__Operation, final @NonNull Connection jm_TmapOperatorCallExp, final @NonNull Connection jm_TmapStringExp, final @NonNull Connection jm_TmapVariableExp)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclExpression__dispatch__qvtr" +
				"\n\t\"atlExpression\":" + toDebugString(atlExpression));
		}
		// creations
		final @SuppressWarnings("null")@NonNull DmapOclExpression dispatcher_0 = trace_ATL2QVTrFactory.eINSTANCE.createDmapOclExpression();
		models[4/*middle*/].add(dispatcher_0, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(dispatcher_0));
		}
		final @SuppressWarnings("null")@NonNull TmapBooleanExp mapBooleanExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapBooleanExp();
		models[4/*middle*/].add(mapBooleanExp, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapBooleanExp));
		}
		final @SuppressWarnings("null")@NonNull TmapIfExp mapIfExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapIfExp();
		models[4/*middle*/].add(mapIfExp, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapIfExp));
		}
		final @SuppressWarnings("null")@NonNull TmapIntegerExp mapIntegerExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapIntegerExp();
		models[4/*middle*/].add(mapIntegerExp, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapIntegerExp));
		}
		final @SuppressWarnings("null")@NonNull TmapNavigationOrAttributeCallExp_Helper mapNavigationOrAttributeCallExp_Helper = trace_ATL2QVTrFactory.eINSTANCE.createTmapNavigationOrAttributeCallExp_Helper();
		models[4/*middle*/].add(mapNavigationOrAttributeCallExp_Helper, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapNavigationOrAttributeCallExp_Helper));
		}
		final @SuppressWarnings("null")@NonNull TmapNavigationOrAttributeCallExp_Property mapNavigationOrAttributeCallExp_Property = trace_ATL2QVTrFactory.eINSTANCE.createTmapNavigationOrAttributeCallExp_Property();
		models[4/*middle*/].add(mapNavigationOrAttributeCallExp_Property, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapNavigationOrAttributeCallExp_Property));
		}
		final @SuppressWarnings("null")@NonNull TmapNullLiteralExp mapNullLiteralExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapNullLiteralExp();
		models[4/*middle*/].add(mapNullLiteralExp, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapNullLiteralExp));
		}
		final @SuppressWarnings("null")@NonNull TmapOclType mapOclType = trace_ATL2QVTrFactory.eINSTANCE.createTmapOclType();
		models[4/*middle*/].add(mapOclType, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapOclType));
		}
		final @SuppressWarnings("null")@NonNull TmapOperationCallExp_Helper mapOperationCallExp_Helper = trace_ATL2QVTrFactory.eINSTANCE.createTmapOperationCallExp_Helper();
		models[4/*middle*/].add(mapOperationCallExp_Helper, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapOperationCallExp_Helper));
		}
		final @SuppressWarnings("null")@NonNull TmapOperationCallExp_Operation mapOperationCallExp_Operation = trace_ATL2QVTrFactory.eINSTANCE.createTmapOperationCallExp_Operation();
		models[4/*middle*/].add(mapOperationCallExp_Operation, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapOperationCallExp_Operation));
		}
		final @SuppressWarnings("null")@NonNull TmapOperatorCallExp mapOperatorCallExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapOperatorCallExp();
		models[4/*middle*/].add(mapOperatorCallExp, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapOperatorCallExp));
		}
		final @SuppressWarnings("null")@NonNull TmapStringExp mapStringExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapStringExp();
		models[4/*middle*/].add(mapStringExp, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapStringExp));
		}
		final @SuppressWarnings("null")@NonNull TmapVariableExp mapVariableExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapVariableExp();
		models[4/*middle*/].add(mapVariableExp, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapVariableExp));
		}
		// mapping statements
		OPPOSITE_OF_DmapOclExpression_d3atlExpression.put(atlExpression, dispatcher_0);
		dispatcher_0.setD3atlExpression(atlExpression);
		dispatcher_0.setDomapBooleanExp(mapBooleanExp);
		dispatcher_0.setDomapIfExp(mapIfExp);
		dispatcher_0.setDomapIntegerExp(mapIntegerExp);
		dispatcher_0.setDomapNavigationOrAttributeCallExp_Helper(mapNavigationOrAttributeCallExp_Helper);
		dispatcher_0.setDomapNavigationOrAttributeCallExp_Property(mapNavigationOrAttributeCallExp_Property);
		dispatcher_0.setDomapNullLiteralExp(mapNullLiteralExp);
		dispatcher_0.setDomapOclType(mapOclType);
		dispatcher_0.setDomapOperationCallExp_Helper(mapOperationCallExp_Helper);
		dispatcher_0.setDomapOperationCallExp_Operation(mapOperationCallExp_Operation);
		dispatcher_0.setDomapOperatorCallExp(mapOperatorCallExp);
		dispatcher_0.setDomapStringExp(mapStringExp);
		dispatcher_0.setDomapVariableExp(mapVariableExp);
		jm_DmapOclExpression.appendElement(dispatcher_0);
		jm_TmapBooleanExp.appendElement(mapBooleanExp);
		jm_TmapIfExp.appendElement(mapIfExp);
		jm_TmapIntegerExp.appendElement(mapIntegerExp);
		jm_TmapNavigationOrAttributeCallExp__Helper.appendElement(mapNavigationOrAttributeCallExp_Helper);
		jm_TmapNavigationOrAttributeCallExp__Property.appendElement(mapNavigationOrAttributeCallExp_Property);
		jm_TmapNullLiteralExp.appendElement(mapNullLiteralExp);
		jm_TmapOclType.appendElement(mapOclType);
		jm_TmapOperationCallExp__Helper.appendElement(mapOperationCallExp_Helper);
		jm_TmapOperationCallExp__Operation.appendElement(mapOperationCallExp_Operation);
		jm_TmapOperatorCallExp.appendElement(mapOperatorCallExp);
		jm_TmapStringExp.appendElement(mapStringExp);
		jm_TmapVariableExp.appendElement(mapVariableExp);
		final /*@Thrown*/ @Nullable Boolean mmapOclExpression__dispatch__qvtr = ValueUtil.TRUE_VALUE;
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
		final @SuppressWarnings("null")@NonNull TmapOclMetamodel trace_65 = trace_ATL2QVTrFactory.eINSTANCE.createTmapOclMetamodel();
		models[4/*middle*/].add(trace_65, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_65));
		}
		// mapping statements
		OPPOSITE_OF_TmapOclMetamodel_t3oclMetamodel.put(oclMetamodel, trace_65);
		trace_65.setT3oclMetamodel(oclMetamodel);
		jm_TmapOclMetamodel.appendElement(trace_65);
		final /*@Thrown*/ @Nullable Boolean mmapOclMetamodel__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
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
		final @SuppressWarnings("null")@NonNull TmapOclModel_IN trace_65 = trace_ATL2QVTrFactory.eINSTANCE.createTmapOclModel_IN();
		models[4/*middle*/].add(trace_65, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_65));
		}
		// mapping statements
		trace_65.setT3oclModel(oclModel);
		jm_TmapOclModel__IN.appendElement(trace_65);
		final /*@Thrown*/ @Nullable Boolean mmapOclModel__IN__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
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
	protected boolean MAP_mmapOclModel__OUT__qvtr__ctor__(final @NonNull Connection jm_TmapOclModel__OUT, final /*@NonInvalid*/ @NonNull OclModel oclModel_0)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclModel__OUT__qvtr__ctor__" +
				"\n\t\"oclModel\":" + toDebugString(oclModel_0));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapOclModel_OUT trace_65 = trace_ATL2QVTrFactory.eINSTANCE.createTmapOclModel_OUT();
		models[4/*middle*/].add(trace_65, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_65));
		}
		// mapping statements
		trace_65.setT3oclModel(oclModel_0);
		jm_TmapOclModel__OUT.appendElement(trace_65);
		final /*@Thrown*/ @Nullable Boolean mmapOclModel__OUT__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
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
		final @SuppressWarnings("null")@NonNull TmapOperationCallExp_argument trace_65 = trace_ATL2QVTrFactory.eINSTANCE.createTmapOperationCallExp_argument();
		models[4/*middle*/].add(trace_65, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_65));
		}
		// mapping statements
		trace_65.setT3atlArgument(atlArgument);
		jm_TmapOperationCallExp__argument.appendElement(trace_65);
		final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__argument__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
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
		final @SuppressWarnings("null")@NonNull TmapSimpleInPatternElement trace_65 = trace_ATL2QVTrFactory.eINSTANCE.createTmapSimpleInPatternElement();
		models[4/*middle*/].add(trace_65, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_65));
		}
		// mapping statements
		trace_65.setT3atlElement(atlElement);
		jm_TmapSimpleInPatternElement.appendElement(trace_65);
		final /*@Thrown*/ @Nullable Boolean mmapSimpleInPatternElement__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
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
	protected boolean MAP_mmapSimpleOutPatternElement__qvtr__ctor__(final /*@NonInvalid*/ @NonNull SimpleOutPatternElement atlElement_0, final @NonNull Connection jm_TmapSimpleOutPatternElement)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapSimpleOutPatternElement__qvtr__ctor__" +
				"\n\t\"atlElement\":" + toDebugString(atlElement_0));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapSimpleOutPatternElement trace_65 = trace_ATL2QVTrFactory.eINSTANCE.createTmapSimpleOutPatternElement();
		models[4/*middle*/].add(trace_65, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_65));
		}
		// mapping statements
		OPPOSITE_OF_TmapSimpleOutPatternElement_t3atlElement.put(atlElement_0, trace_65);
		trace_65.setT3atlElement(atlElement_0);
		jm_TmapSimpleOutPatternElement.appendElement(trace_65);
		final /*@Thrown*/ @Nullable Boolean mmapSimpleOutPatternElement__qvtr__ctor__ = ValueUtil.TRUE_VALUE;
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
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapBooleanExp domapBooleanExp = dispatcher_0.getDomapBooleanExp();
		final /*@NonInvalid*/ boolean eq = trace.equals(domapBooleanExp);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD3atlExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof BooleanExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull BooleanExp CAST_temp1_atlExpression = (BooleanExp)temp1_atlExpression;
				final /*@NonInvalid*/ boolean booleanSymbol = CAST_temp1_atlExpression.isBooleanSymbol();
				// creations
				final @NonNull BooleanLiteralExp qvtrExpression = PivotFactory.eINSTANCE.createBooleanLiteralExp();
				models[3/*qvtr*/].add(qvtrExpression, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
				}
				// mapping statements
				trace.setT1symbol(booleanSymbol);
				qvtrExpression.setBooleanSymbol(booleanSymbol);
				dispatcher_0.setD4qvtrExpression(qvtrExpression);
				dispatcher_0.setResult(trace);
				final /*@Thrown*/ @Nullable Boolean mmapBooleanExp__qvtr__init__ = ValueUtil.TRUE_VALUE;
				IF_symbol_0 = mmapBooleanExp__qvtr__init__;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		trace.setS0global(IF_eq);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_eq, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapBooleanExp__qvtr__init__");
		}
		return IF_eq;
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
	 * set trace.wmapOclExpression2 := when_mapOclExpression1;
	 * set trace.wmapOclExpression := when_mapOclExpression2;
	 *
	 */
	protected boolean MAP_mmapIfExp__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapIfExp trace_0)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapIfExp__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_0) +
				"\n\t\"dispatcher\":" + toDebugString(trace_0.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_0.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_0.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_0.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapIfExp domapIfExp = dispatcher_0.getDomapIfExp();
		final /*@NonInvalid*/ boolean eq = trace_0.equals(domapIfExp);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD3atlExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof IfExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull IfExp CAST_temp1_atlExpression = (IfExp)temp1_atlExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression condition = CAST_temp1_atlExpression.getCondition();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression elseExpression = CAST_temp1_atlExpression.getElseExpression();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression thenExpression = CAST_temp1_atlExpression.getThenExpression();
				final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(condition);
				final /*@NonInvalid*/ boolean symbol_1 = DmapOclExpression != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
				if (symbol_1) {
					if (DmapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression_0 = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(elseExpression);
					final /*@NonInvalid*/ boolean symbol_2 = DmapOclExpression_0 != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression1;
					if (symbol_2) {
						if (DmapOclExpression_0 == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression_1 = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(thenExpression);
						final /*@NonInvalid*/ boolean symbol_3 = DmapOclExpression_1 != null;
						/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression2;
						if (symbol_3) {
							if (DmapOclExpression_1 == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							// mapping statements
							dispatcher_0.setResult(trace_0);
							trace_0.setT3atlCondition(condition);
							trace_0.setT3atlElse(elseExpression);
							trace_0.setT3atlThen(thenExpression);
							trace_0.setWmapOclExpression1(DmapOclExpression);
							trace_0.setWmapOclExpression2(DmapOclExpression_0);
							trace_0.setWmapOclExpression(DmapOclExpression_1);
							final /*@Thrown*/ @Nullable Boolean mmapIfExp__qvtr__init__ = ValueUtil.TRUE_VALUE;
							raw_when_mapOclExpression2 = mmapIfExp__qvtr__init__;
						}
						else {
							raw_when_mapOclExpression2 = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapOclExpression1 = raw_when_mapOclExpression2;
					}
					else {
						raw_when_mapOclExpression1 = ValueUtil.FALSE_VALUE;
					}
					raw_when_mapOclExpression = raw_when_mapOclExpression1;
				}
				else {
					raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = raw_when_mapOclExpression;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		trace_0.setS0local(IF_eq);
		objectManager.assigned(trace_0, trace_ATL2QVTrPackage.Literals.TMAP_IF_EXP__S0LOCAL, IF_eq, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapIfExp__qvtr__init__");
		}
		return IF_eq;
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
	protected boolean MAP_mmapIntegerExp__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapIntegerExp trace_1)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapIntegerExp__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_1) +
				"\n\t\"dispatcher\":" + toDebugString(trace_1.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_1.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_1.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_1.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapIntegerExp domapIntegerExp = dispatcher_0.getDomapIntegerExp();
		final /*@NonInvalid*/ boolean eq = trace_1.equals(domapIntegerExp);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD3atlExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof IntegerExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull IntegerExp CAST_temp1_atlExpression = (IntegerExp)temp1_atlExpression;
				final /*@NonInvalid*/ int integerSymbol = CAST_temp1_atlExpression.getIntegerSymbol();
				// creations
				final @NonNull IntegerLiteralExp qvtrExpression = PivotFactory.eINSTANCE.createIntegerLiteralExp();
				models[3/*qvtr*/].add(qvtrExpression, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
				}
				// mapping statements
				trace_1.setT1symbol(ValueUtil.bigIntegerValueOf(integerSymbol));
				qvtrExpression.setIntegerSymbol(integerSymbol);
				dispatcher_0.setD4qvtrExpression(qvtrExpression);
				dispatcher_0.setResult(trace_1);
				final /*@Thrown*/ @Nullable Boolean mmapIntegerExp__qvtr__init__ = ValueUtil.TRUE_VALUE;
				IF_symbol_0 = mmapIntegerExp__qvtr__init__;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		trace_1.setS0global(IF_eq);
		objectManager.assigned(trace_1, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_eq, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapIntegerExp__qvtr__init__");
		}
		return IF_eq;
	}

	/**
	 *
	 * map:2 mmapModule__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapModule[1] success s0global;
	 * var atlModule : ATL::Module[1] := trace.t3atlModule;
	 * var txName : String[1] := atlModule.name;
	 * new:qvtr _1 : Package[1];
	 * new:qvtr _2 : Parameter[1];
	 * new:qvtr _3 : qvtbase::TypedModel[1];
	 * new:qvtr _4 : qvtrelation::RelationModel[1];
	 * new:qvtr qvtrTransformation : qvtrelation::RelationalTransformation[1];
	 * set qvtrTransformation.name := txName;
	 * set trace.t1txName := txName;
	 * set _4.ownedPackages := _1;
	 * notify set _2.type := qvtrTransformation;
	 * set _3.transformation := qvtrTransformation;
	 * set qvtrTransformation.ownedContext := _2;
	 * set qvtrTransformation.owningPackage := _1;
	 * set trace.t4_1 := _1;
	 * set trace.t4_2 := _2;
	 * set trace.t4_3 := _3;
	 * set trace.t4_4 := _4;
	 * set trace.t4qvtrTransformation := qvtrTransformation;
	 *
	 */
	protected boolean MAP_mmapModule__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapModule trace_2)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapModule__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_2));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Module t3atlModule = trace_2.getT3atlModule();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String name_2 = t3atlModule.getName();
		// creations
		final org.eclipse.ocl.pivot.@NonNull Package _1 = PivotFactory.eINSTANCE.createPackage();
		models[3/*qvtr*/].add(_1, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(_1));
		}
		final @NonNull Parameter _2 = PivotFactory.eINSTANCE.createParameter();
		models[3/*qvtr*/].add(_2, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(_2));
		}
		final @NonNull TypedModel _3 = QVTbaseFactory.eINSTANCE.createTypedModel();
		models[3/*qvtr*/].add(_3, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(_3));
		}
		final @NonNull RelationModel _4 = QVTrelationFactory.eINSTANCE.createRelationModel();
		models[3/*qvtr*/].add(_4, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(_4));
		}
		final @NonNull RelationalTransformation qvtrTransformation = QVTrelationFactory.eINSTANCE.createRelationalTransformation();
		models[3/*qvtr*/].add(qvtrTransformation, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrTransformation));
		}
		// mapping statements
		qvtrTransformation.setName(name_2);
		trace_2.setT1txName(name_2);
		_4.getOwnedPackages().add(_1);
		_2.setType(qvtrTransformation);
		objectManager.assigned(_2, PivotPackage.Literals.TYPED_ELEMENT__TYPE, qvtrTransformation, false);
		_3.setTransformation(qvtrTransformation);
		qvtrTransformation.setOwnedContext(_2);
		qvtrTransformation.setOwningPackage(_1);
		trace_2.setT4_1(_1);
		trace_2.setT4_2(_2);
		trace_2.setT4_3(_3);
		trace_2.setT4_4(_4);
		trace_2.setT4qvtrTransformation(qvtrTransformation);
		final /*@Thrown*/ @Nullable Boolean mmapModule__qvtr__init__ = ValueUtil.TRUE_VALUE;
		trace_2.setS0global(mmapModule__qvtr__init__);
		objectManager.assigned(trace_2, trace_ATL2QVTrPackage.Literals.TMAP_MODULE__S0GLOBAL, mmapModule__qvtr__init__, false);
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
	protected boolean MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__i(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace_3)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__i" +
				"\n\t\"trace\":" + toDebugString(trace_3) +
				"\n\t\"dispatcher\":" + toDebugString(trace_3.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_3.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_3.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_3.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Property domapNavigationOrAttributeCallExp_Property = dispatcher_0.getDomapNavigationOrAttributeCallExp_Property();
		final /*@NonInvalid*/ boolean eq = trace_3.equals(domapNavigationOrAttributeCallExp_Property);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD3atlExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof NavigationOrAttributeCallExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull NavigationOrAttributeCallExp CAST_temp1_atlExpression = (NavigationOrAttributeCallExp)temp1_atlExpression;
				final /*@NonInvalid*/ @NonNull Module getModule = ((FUN_getModule)FTOR_getModule.getUniqueComputation(this, CAST_temp1_atlExpression)).instance;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<ModuleElement> elements = getModule.getElements();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ATL_c_c_Helper_0 = idResolver.getClass(CLSSid_Helper, null);
				final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_elements = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleElement, elements);
				final /*@NonInvalid*/ @NonNull OrderedSetValue selectByKind = (@Nullable OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_elements, TYP_ATL_c_c_Helper_0);
				/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeatureDefinition);
				@NonNull Iterator<Object> ITERATOR_i = selectByKind.iterator();
				/*@NonInvalid*/ @NonNull SequenceValue collect;
				while (true) {
					if (!ITERATOR_i.hasNext()) {
						collect = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull Helper i = (@NonNull Helper)ITERATOR_i.next();
					/**
					 * i.definition
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = i.getDefinition();
					//
					accumulator.add(definition);
				}
				/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeature);
				@NonNull Iterator<Object> ITERATOR_i_0 = collect.iterator();
				/*@NonInvalid*/ @NonNull SequenceValue collect_0;
				while (true) {
					if (!ITERATOR_i_0.hasNext()) {
						collect_0 = accumulator_0;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull OclFeatureDefinition i_0 = (@NonNull OclFeatureDefinition)ITERATOR_i_0.next();
					/**
					 * i.feature
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclFeature feature = i_0.getFeature();
					//
					accumulator_0.add(feature);
				}
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_Attribute_0 = idResolver.getClass(CLSSid_Attribute, null);
				final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (@Nullable SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_0, TYP_OCL_c_c_Attribute_0);
				/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Attribute);
				@NonNull Iterator<Object> ITERATOR_i_1 = selectByKind_0.iterator();
				/*@NonInvalid*/ @NonNull SequenceValue select;
				while (true) {
					if (!ITERATOR_i_1.hasNext()) {
						select = accumulator_1;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull Attribute i_1 = (@NonNull Attribute)ITERATOR_i_1.next();
					/**
					 * i.name = atlExpression.name
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String name_2 = i_1.getName();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String name_3 = CAST_temp1_atlExpression.getName();
					final /*@NonInvalid*/ boolean eq_0 = name_2.equals(name_3);
					//
					if (eq_0) {
						accumulator_1.add(i_1);
					}
				}
				final /*@NonInvalid*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(select).booleanValue();
				/*@Thrown*/ @Nullable Boolean IF_isEmpty;
				if (isEmpty) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String name_4 = CAST_temp1_atlExpression.getName();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclExpression source = CAST_temp1_atlExpression.getSource();
					final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(source);
					final /*@NonInvalid*/ boolean symbol_1 = DmapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
					if (symbol_1) {
						if (DmapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						// mapping statements
						trace_3.setT1propertyName(name_4);
						final /*@NonInvalid*/ @NonNull List<Attribute> ECORE_select = idResolver.ecoreValueOfAll(Attribute.class, select);
						trace_3.getT3atlAttributes().addAll(ECORE_select);
						dispatcher_0.setResult(trace_3);
						trace_3.setT3atlModule(getModule);
						trace_3.setT3atlSource(source);
						trace_3.setWmapOclExpression(DmapOclExpression);
						final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Property__qvtr__i = ValueUtil.TRUE_VALUE;
						raw_when_mapOclExpression = mmapNavigationOrAttributeCallExp__Property__qvtr__i;
					}
					else {
						raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
					}
					IF_isEmpty = raw_when_mapOclExpression;
				}
				else {
					IF_isEmpty = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_isEmpty;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		trace_3.setS0local(IF_eq);
		objectManager.assigned(trace_3, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__S0LOCAL, IF_eq, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__i");
		}
		return IF_eq;
	}

	/**
	 *
	 * map:2 mmapNullLiteralExp__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNullLiteralExp[1] success s0global;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapNullLiteralExp;
	 * check var atlExpression : OCL::VariableExp[1] := dispatcher.d3atlExpression;
	 * var _'null' : String[1] := 'null';
	 * var varName : String[1] := _'null';
	 * check _'null' = varName;
	 * var atlVariable : OCL::VariableDeclaration[1] := atlExpression.referredVariable;
	 * check varName = atlVariable.varName;
	 * new:qvtr qvtrExpression : NullLiteralExp[1];
	 * set trace.t1varName := varName;
	 * set dispatcher.d4qvtrExpression := qvtrExpression;
	 * set dispatcher.result := trace;
	 * set trace.t3atlVariable := atlVariable;
	 *
	 */
	protected boolean MAP_mmapNullLiteralExp__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapNullLiteralExp trace_4)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapNullLiteralExp__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_4) +
				"\n\t\"dispatcher\":" + toDebugString(trace_4.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_4.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_4.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_4.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapNullLiteralExp domapNullLiteralExp = dispatcher_0.getDomapNullLiteralExp();
		final /*@NonInvalid*/ boolean eq = trace_4.equals(domapNullLiteralExp);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD3atlExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof VariableExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull VariableExp CAST_temp1_atlExpression = (VariableExp)temp1_atlExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableDeclaration referredVariable = CAST_temp1_atlExpression.getReferredVariable();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String varName = referredVariable.getVarName();
				final /*@NonInvalid*/ boolean eq_0 = STR_null.equals(varName);
				/*@Thrown*/ @Nullable Boolean IF_eq_0;
				if (eq_0) {
					// creations
					final @NonNull NullLiteralExp qvtrExpression = PivotFactory.eINSTANCE.createNullLiteralExp();
					models[3/*qvtr*/].add(qvtrExpression, false);
					if (debugCreations) {
						AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
					}
					// mapping statements
					trace_4.setT1varName(STR_null);
					dispatcher_0.setD4qvtrExpression(qvtrExpression);
					dispatcher_0.setResult(trace_4);
					trace_4.setT3atlVariable(referredVariable);
					final /*@Thrown*/ @Nullable Boolean mmapNullLiteralExp__qvtr__init__ = ValueUtil.TRUE_VALUE;
					IF_eq_0 = mmapNullLiteralExp__qvtr__init__;
				}
				else {
					IF_eq_0 = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_eq_0;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		trace_4.setS0global(IF_eq);
		objectManager.assigned(trace_4, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_eq, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapNullLiteralExp__qvtr__init__");
		}
		return IF_eq;
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
	protected boolean MAP_mmapOclMetamodel__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapOclMetamodel trace_5)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclMetamodel__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_5));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclModel t3oclMetamodel = trace_5.getT3oclMetamodel();
		final /*@NonInvalid*/ @Nullable OclModel metamodel = t3oclMetamodel.getMetamodel();
		final /*@NonInvalid*/ boolean eq = metamodel == null;
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name_2 = t3oclMetamodel.getName();
			// creations
			final @NonNull TypedModel qvtrTypedModel = QVTbaseFactory.eINSTANCE.createTypedModel();
			models[3/*qvtr*/].add(qvtrTypedModel, false);
			if (debugCreations) {
				AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrTypedModel));
			}
			// mapping statements
			qvtrTypedModel.setName(name_2);
			trace_5.setT1tmName(name_2);
			trace_5.setT4qvtrTypedModel(qvtrTypedModel);
			final /*@Thrown*/ @Nullable Boolean mmapOclMetamodel__qvtr__init__ = ValueUtil.TRUE_VALUE;
			IF_eq = mmapOclMetamodel__qvtr__init__;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		trace_5.setS0global(IF_eq);
		objectManager.assigned(trace_5, trace_ATL2QVTrPackage.Literals.TMAP_OCL_METAMODEL__S0GLOBAL, IF_eq, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapOclMetamodel__qvtr__init__");
		}
		return IF_eq;
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
	protected boolean MAP_mmapOclType__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapOclType trace_6)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclType__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_6) +
				"\n\t\"dispatcher\":" + toDebugString(trace_6.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_6.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_6.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_6.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOclType domapOclType = dispatcher_0.getDomapOclType();
		final /*@NonInvalid*/ boolean eq = trace_6.equals(domapOclType);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD3atlExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof OclType;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull OclType CAST_temp1_atlExpression = (OclType)temp1_atlExpression;
				// mapping statements
				dispatcher_0.setResult(trace_6);
				final /*@Thrown*/ @Nullable Boolean mmapOclType__qvtr__init__ = ValueUtil.TRUE_VALUE;
				IF_symbol_0 = mmapOclType__qvtr__init__;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		trace_6.setS0global(IF_eq);
		objectManager.assigned(trace_6, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_eq, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapOclType__qvtr__init__");
		}
		return IF_eq;
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
	protected boolean MAP_mmapOperationCallExp__Operation__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace_7)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperationCallExp__Operation__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_7) +
				"\n\t\"dispatcher\":" + toDebugString(trace_7.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_7.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_7.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_7.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Operation domapOperationCallExp_Operation = dispatcher_0.getDomapOperationCallExp_Operation();
		final /*@NonInvalid*/ boolean eq = trace_7.equals(domapOperationCallExp_Operation);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD3atlExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof OperationCallExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull OperationCallExp CAST_temp1_atlExpression = (OperationCallExp)temp1_atlExpression;
				final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher_0.getDomapOperatorCallExp();
				final /*@NonInvalid*/ boolean symbol_1 = domapOperatorCallExp != null;
				/*@Thrown*/ @Nullable Boolean raw_not_mapOperatorCallExp;
				if (symbol_1) {
					if (domapOperatorCallExp == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@NonInvalid*/ @NonNull Module getModule = ((FUN_getModule)FTOR_getModule.getUniqueComputation(this, CAST_temp1_atlExpression)).instance;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<ModuleElement> elements = getModule.getElements();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ATL_c_c_Helper_0 = idResolver.getClass(CLSSid_Helper, null);
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_elements = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleElement, elements);
					final /*@NonInvalid*/ @NonNull OrderedSetValue selectByKind = (@Nullable OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_elements, TYP_ATL_c_c_Helper_0);
					/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeatureDefinition);
					@NonNull Iterator<Object> ITERATOR_i = selectByKind.iterator();
					/*@NonInvalid*/ @NonNull SequenceValue collect;
					while (true) {
						if (!ITERATOR_i.hasNext()) {
							collect = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull Helper i = (@NonNull Helper)ITERATOR_i.next();
						/**
						 * i.definition
						 */
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = i.getDefinition();
						//
						accumulator.add(definition);
					}
					/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeature);
					@NonNull Iterator<Object> ITERATOR_i_0 = collect.iterator();
					/*@NonInvalid*/ @NonNull SequenceValue collect_0;
					while (true) {
						if (!ITERATOR_i_0.hasNext()) {
							collect_0 = accumulator_0;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull OclFeatureDefinition i_0 = (@NonNull OclFeatureDefinition)ITERATOR_i_0.next();
						/**
						 * i.feature
						 */
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OclFeature feature = i_0.getFeature();
						//
						accumulator_0.add(feature);
					}
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
					final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (@Nullable SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_0, TYP_OCL_c_c_Operation_0);
					/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
					@NonNull Iterator<Object> ITERATOR_i_1 = selectByKind_0.iterator();
					/*@NonInvalid*/ @NonNull SequenceValue select;
					while (true) {
						if (!ITERATOR_i_1.hasNext()) {
							select = accumulator_1;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation i_1 = (org.eclipse.m2m.atl.common.OCL.@NonNull Operation)ITERATOR_i_1.next();
						/**
						 * i.name = atlExpression.operationName
						 */
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String name_2 = i_1.getName();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String operationName = CAST_temp1_atlExpression.getOperationName();
						final /*@NonInvalid*/ boolean eq_0 = name_2.equals(operationName);
						//
						if (eq_0) {
							accumulator_1.add(i_1);
						}
					}
					final /*@NonInvalid*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(select).booleanValue();
					/*@Thrown*/ @Nullable Boolean IF_isEmpty;
					if (isEmpty) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String operationName_0 = CAST_temp1_atlExpression.getOperationName();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OclExpression source = CAST_temp1_atlExpression.getSource();
						final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(source);
						final /*@NonInvalid*/ boolean symbol_2 = DmapOclExpression != null;
						/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
						if (symbol_2) {
							if (DmapOclExpression == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							// mapping statements
							trace_7.setT1operationName(operationName_0);
							final /*@NonInvalid*/ @NonNull List<org.eclipse.m2m.atl.common.OCL.Operation> ECORE_select = idResolver.ecoreValueOfAll(org.eclipse.m2m.atl.common.OCL.Operation.class, select);
							trace_7.getT3atlOperations().addAll(ECORE_select);
							dispatcher_0.setResult(trace_7);
							trace_7.setT3atlModule(getModule);
							trace_7.setT3atlSource(source);
							trace_7.setWmapOclExpression(DmapOclExpression);
							final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Operation__qvtr__init__ = ValueUtil.TRUE_VALUE;
							raw_when_mapOclExpression = mmapOperationCallExp__Operation__qvtr__init__;
						}
						else {
							raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
						}
						IF_isEmpty = raw_when_mapOclExpression;
					}
					else {
						IF_isEmpty = ValueUtil.FALSE_VALUE;
					}
					raw_not_mapOperatorCallExp = IF_isEmpty;
				}
				else {
					raw_not_mapOperatorCallExp = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = raw_not_mapOperatorCallExp;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		trace_7.setS0local(IF_eq);
		objectManager.assigned(trace_7, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_OPERATION__S0LOCAL, IF_eq, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapOperationCallExp__Operation__qvtr__init__");
		}
		return IF_eq;
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
	protected boolean MAP_mmapOperatorCallExp__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace_8)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperatorCallExp__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_8) +
				"\n\t\"dispatcher\":" + toDebugString(trace_8.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_8.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_8.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_8.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher_0.getDomapOperatorCallExp();
		final /*@NonInvalid*/ boolean eq = trace_8.equals(domapOperatorCallExp);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD3atlExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof OperatorCallExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull OperatorCallExp CAST_temp1_atlExpression = (OperatorCallExp)temp1_atlExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String operationName = CAST_temp1_atlExpression.getOperationName();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression source = CAST_temp1_atlExpression.getSource();
				final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(source);
				final /*@NonInvalid*/ boolean symbol_1 = DmapOclExpression != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
				if (symbol_1) {
					if (DmapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					// mapping statements
					trace_8.setT1operationName(operationName);
					dispatcher_0.setResult(trace_8);
					trace_8.setT3atlSource(source);
					trace_8.setWmapOclExpression(DmapOclExpression);
					final /*@Thrown*/ @Nullable Boolean mmapOperatorCallExp__qvtr__init__ = ValueUtil.TRUE_VALUE;
					raw_when_mapOclExpression = mmapOperatorCallExp__qvtr__init__;
				}
				else {
					raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = raw_when_mapOclExpression;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		trace_8.setS0local(IF_eq);
		objectManager.assigned(trace_8, trace_ATL2QVTrPackage.Literals.TMAP_OPERATOR_CALL_EXP__S0LOCAL, IF_eq, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapOperatorCallExp__qvtr__init__");
		}
		return IF_eq;
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
	protected boolean MAP_mmapStringExp__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapStringExp trace_9)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapStringExp__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_9) +
				"\n\t\"dispatcher\":" + toDebugString(trace_9.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_9.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_9.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_9.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapStringExp domapStringExp = dispatcher_0.getDomapStringExp();
		final /*@NonInvalid*/ boolean eq = trace_9.equals(domapStringExp);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD3atlExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof StringExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull StringExp CAST_temp1_atlExpression = (StringExp)temp1_atlExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String stringSymbol = CAST_temp1_atlExpression.getStringSymbol();
				// creations
				final @NonNull StringLiteralExp qvtrExpression = PivotFactory.eINSTANCE.createStringLiteralExp();
				models[3/*qvtr*/].add(qvtrExpression, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
				}
				// mapping statements
				trace_9.setT1symbol(stringSymbol);
				qvtrExpression.setStringSymbol(stringSymbol);
				dispatcher_0.setD4qvtrExpression(qvtrExpression);
				dispatcher_0.setResult(trace_9);
				final /*@Thrown*/ @Nullable Boolean mmapStringExp__qvtr__init__ = ValueUtil.TRUE_VALUE;
				IF_symbol_0 = mmapStringExp__qvtr__init__;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		trace_9.setS0global(IF_eq);
		objectManager.assigned(trace_9, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_eq, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapStringExp__qvtr__init__");
		}
		return IF_eq;
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
	 * var _'<>' : Boolean[1] := varName <> 'null';
	 * check _'<>';
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
	protected boolean MAP_mmapVariableExp__qvtr__init__(final @NonNull Connection jm_DmapVariableExp__referredVariable, final /*@NonInvalid*/ @NonNull TmapVariableExp trace_10)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariableExp__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_10) +
				"\n\t\"dispatcher\":" + toDebugString(trace_10.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_10.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_10.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_10.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapVariableExp domapVariableExp = dispatcher_0.getDomapVariableExp();
		final /*@NonInvalid*/ boolean eq = trace_10.equals(domapVariableExp);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD3atlExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof VariableExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull VariableExp CAST_temp1_atlExpression = (VariableExp)temp1_atlExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableDeclaration referredVariable = CAST_temp1_atlExpression.getReferredVariable();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String varName = referredVariable.getVarName();
				final /*@NonInvalid*/ boolean ne = !varName.equals(STR_null);
				/*@Thrown*/ @Nullable Boolean IF_ne;
				if (ne) {
					// creations
					final org.eclipse.ocl.pivot.@NonNull VariableExp qvtrExpression = PivotFactory.eINSTANCE.createVariableExp();
					models[3/*qvtr*/].add(qvtrExpression, false);
					if (debugCreations) {
						AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
					}
					final @SuppressWarnings("null")@NonNull DmapVariableExp_referredVariable where_mapVariableExp_referredVariable = INSTANCE_ICACHE_DmapVariableExp_referredVariable.evaluate(CAST_temp1_atlExpression, qvtrExpression);
					if (debugCreations) {
						AbstractTransformer.CREATIONS.println("created " + toDebugString(where_mapVariableExp_referredVariable));
					}
					// mapping statements
					trace_10.setT1varName(varName);
					qvtrExpression.setName(varName);
					dispatcher_0.setD4qvtrExpression(qvtrExpression);
					dispatcher_0.setResult(trace_10);
					trace_10.setT3atlVariable(referredVariable);
					trace_10.setWmapVariableExp_referredVariable(where_mapVariableExp_referredVariable);
					jm_DmapVariableExp__referredVariable.appendElement(where_mapVariableExp_referredVariable);
					final /*@Thrown*/ @Nullable Boolean mmapVariableExp__qvtr__init__ = ValueUtil.TRUE_VALUE;
					IF_ne = mmapVariableExp__qvtr__init__;
				}
				else {
					IF_ne = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_ne;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		trace_10.setS0global(IF_eq);
		objectManager.assigned(trace_10, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_eq, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapVariableExp__qvtr__init__");
		}
		return IF_eq;
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
	 * set qvtrExpression.isRequired := true;
	 * notify set dispatcher.s0global := true;
	 * notify set qvtrExpression.type := Boolean1;
	 *
	 */
	protected boolean MAP_mmapBooleanExp__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapBooleanExp trace_11)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapBooleanExp__qvtr__rest__" +
				"\n\t\"trace\":" + toDebugString(trace_11) +
				"\n\t\"dispatcher\":" + toDebugString(trace_11.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_11.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_11.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_11.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapBooleanExp domapBooleanExp = dispatcher_0.getDomapBooleanExp();
		final /*@NonInvalid*/ boolean eq = trace_11.equals(domapBooleanExp);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof BooleanLiteralExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull BooleanLiteralExp CAST_temp1_qvtrExpression = (BooleanLiteralExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace_11.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0global;
				if (s0global) {
					final /*@NonInvalid*/ @NonNull BooleanType TYP_Boolean_0 = (@NonNull BooleanType)idResolver.getClass(TypeId.BOOLEAN, null);
					// mapping statements
					CAST_temp1_qvtrExpression.setIsRequired(ValueUtil.TRUE_VALUE);
					dispatcher_0.setS0global((Boolean)ValueUtil.TRUE_VALUE);
					objectManager.assigned(dispatcher_0, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
					CAST_temp1_qvtrExpression.setType(TYP_Boolean_0);
					objectManager.assigned(CAST_temp1_qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, TYP_Boolean_0, false);
					final /*@Thrown*/ @Nullable Boolean mmapBooleanExp__qvtr__rest__ = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapBooleanExp__qvtr__rest__;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_s0global;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapBooleanExp__qvtr__rest__");
		}
		return IF_eq;
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
	protected boolean MAP_mmapHelper__Attribute__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapHelper_Attribute trace_12)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapHelper__Attribute__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_12) +
				"\n\t\"dispatcher\":" + toDebugString(trace_12.getDispatcher()) +
				"\n\t\"dispatcher.d3atlHelper\":" + toDebugString(trace_12.getDispatcher().getD3atlHelper()) +
				"\n\t\"dispatcher.d4qvtrFunction\":" + toDebugString(trace_12.getDispatcher().getD4qvtrFunction()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_12.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapHelper_Attribute domapHelper_Attribute = dispatcher_0.getDomapHelper_Attribute();
		final /*@NonInvalid*/ boolean eq = trace_12.equals(domapHelper_Attribute);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Helper d3atlHelper = dispatcher_0.getD3atlHelper();
			final /*@NonInvalid*/ @Nullable Module module = d3atlHelper.getModule();
			final /*@NonInvalid*/ boolean symbol_0 = module != null;
			/*@Thrown*/ @Nullable Boolean raw_atlModule;
			if (symbol_0) {
				if (module == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t3atlModule.get(module);
				final /*@Thrown*/ boolean symbol_1 = TmapModule != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
				if (symbol_1) {
					if (TmapModule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable Boolean s0global = TmapModule.getS0global();
					if (s0global == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean IF_s0global;
					if (s0global) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = d3atlHelper.getDefinition();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OclFeature temp1_atlFeature = definition.getFeature();
						final /*@NonInvalid*/ boolean symbol_2 = temp1_atlFeature instanceof Attribute;
						/*@Thrown*/ @Nullable Boolean IF_symbol_2;
						if (symbol_2) {
							final /*@NonInvalid*/ @NonNull Attribute CAST_temp1_atlFeature = (Attribute)temp1_atlFeature;
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OclExpression initExpression = CAST_temp1_atlFeature.getInitExpression();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String name_2 = CAST_temp1_atlFeature.getName();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OclType type_2 = CAST_temp1_atlFeature.getType();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull RelationalTransformation t4qvtrTransformation = TmapModule.getT4qvtrTransformation();
							final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(initExpression);
							final /*@NonInvalid*/ boolean symbol_3 = DmapOclExpression != null;
							/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
							if (symbol_3) {
								if (DmapOclExpression == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(this, type_2)).instance;
								// mapping statements
								trace_12.setT1attributeName(name_2);
								dispatcher_0.setResult(trace_12);
								trace_12.setT3atlDefinition(definition);
								trace_12.setT3atlExpression(initExpression);
								trace_12.setT3atlFeature(CAST_temp1_atlFeature);
								trace_12.setT3atlModule(module);
								trace_12.setT3atlType(type_2);
								trace_12.setT4qvtrTransformation(t4qvtrTransformation);
								trace_12.setWmapModule(TmapModule);
								trace_12.setWmapOclExpression(DmapOclExpression);
								final /*@Thrown*/ @Nullable Boolean mmapHelper__Attribute__qvtr__init__ = ValueUtil.TRUE_VALUE;
								raw_when_mapOclExpression = mmapHelper__Attribute__qvtr__init__;
							}
							else {
								raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
							}
							IF_symbol_2 = raw_when_mapOclExpression;
						}
						else {
							IF_symbol_2 = ValueUtil.FALSE_VALUE;
						}
						IF_s0global = IF_symbol_2;
					}
					else {
						IF_s0global = ValueUtil.FALSE_VALUE;
					}
					raw_when_mapModule = IF_s0global;
				}
				else {
					raw_when_mapModule = ValueUtil.FALSE_VALUE;
				}
				raw_atlModule = raw_when_mapModule;
			}
			else {
				raw_atlModule = ValueUtil.FALSE_VALUE;
			}
			IF_eq = raw_atlModule;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		trace_12.setS0local(IF_eq);
		objectManager.assigned(trace_12, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_ATTRIBUTE__S0LOCAL, IF_eq, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapHelper__Attribute__qvtr__init__");
		}
		return IF_eq;
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
	protected boolean MAP_mmapHelper__Operation__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapHelper_Operation trace_13)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapHelper__Operation__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_13) +
				"\n\t\"dispatcher\":" + toDebugString(trace_13.getDispatcher()) +
				"\n\t\"dispatcher.d3atlHelper\":" + toDebugString(trace_13.getDispatcher().getD3atlHelper()) +
				"\n\t\"dispatcher.d4qvtrFunction\":" + toDebugString(trace_13.getDispatcher().getD4qvtrFunction()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_13.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapHelper_Operation domapHelper_Operation = dispatcher_0.getDomapHelper_Operation();
		final /*@NonInvalid*/ boolean eq = trace_13.equals(domapHelper_Operation);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Helper d3atlHelper = dispatcher_0.getD3atlHelper();
			final /*@NonInvalid*/ @Nullable Module module = d3atlHelper.getModule();
			final /*@NonInvalid*/ boolean symbol_0 = module != null;
			/*@Thrown*/ @Nullable Boolean raw_atlModule;
			if (symbol_0) {
				if (module == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t3atlModule.get(module);
				final /*@Thrown*/ boolean symbol_1 = TmapModule != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
				if (symbol_1) {
					if (TmapModule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable Boolean s0global = TmapModule.getS0global();
					if (s0global == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean IF_s0global;
					if (s0global) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = d3atlHelper.getDefinition();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OclFeature temp1_atlFeature = definition.getFeature();
						final /*@NonInvalid*/ boolean symbol_2 = temp1_atlFeature instanceof org.eclipse.m2m.atl.common.OCL.Operation;
						/*@Thrown*/ @Nullable Boolean IF_symbol_2;
						if (symbol_2) {
							final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation CAST_temp1_atlFeature = (org.eclipse.m2m.atl.common.OCL.Operation)temp1_atlFeature;
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OclExpression body = CAST_temp1_atlFeature.getBody();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String name_2 = CAST_temp1_atlFeature.getName();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OclType returnType = CAST_temp1_atlFeature.getReturnType();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull RelationalTransformation t4qvtrTransformation = TmapModule.getT4qvtrTransformation();
							final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(body);
							final /*@NonInvalid*/ boolean symbol_3 = DmapOclExpression != null;
							/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
							if (symbol_3) {
								if (DmapOclExpression == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(this, returnType)).instance;
								// mapping statements
								trace_13.setT1operationName(name_2);
								dispatcher_0.setResult(trace_13);
								trace_13.setT3atlDefinition(definition);
								trace_13.setT3atlExpression(body);
								trace_13.setT3atlFeature(CAST_temp1_atlFeature);
								trace_13.setT3atlModule(module);
								trace_13.setT3atlType(returnType);
								trace_13.setT4qvtrTransformation(t4qvtrTransformation);
								trace_13.setWmapModule(TmapModule);
								trace_13.setWmapOclExpression(DmapOclExpression);
								final /*@Thrown*/ @Nullable Boolean mmapHelper__Operation__qvtr__init__ = ValueUtil.TRUE_VALUE;
								raw_when_mapOclExpression = mmapHelper__Operation__qvtr__init__;
							}
							else {
								raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
							}
							IF_symbol_2 = raw_when_mapOclExpression;
						}
						else {
							IF_symbol_2 = ValueUtil.FALSE_VALUE;
						}
						IF_s0global = IF_symbol_2;
					}
					else {
						IF_s0global = ValueUtil.FALSE_VALUE;
					}
					raw_when_mapModule = IF_s0global;
				}
				else {
					raw_when_mapModule = ValueUtil.FALSE_VALUE;
				}
				raw_atlModule = raw_when_mapModule;
			}
			else {
				raw_atlModule = ValueUtil.FALSE_VALUE;
			}
			IF_eq = raw_atlModule;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		trace_13.setS0local(IF_eq);
		objectManager.assigned(trace_13, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_OPERATION__S0LOCAL, IF_eq, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapHelper__Operation__qvtr__init__");
		}
		return IF_eq;
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
	 * set qvtrExpression.isRequired := true;
	 * notify set dispatcher.s0global := true;
	 * notify set qvtrExpression.type := Integer1;
	 *
	 */
	protected boolean MAP_mmapIntegerExp__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapIntegerExp trace_14)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapIntegerExp__qvtr__rest__" +
				"\n\t\"trace\":" + toDebugString(trace_14) +
				"\n\t\"dispatcher\":" + toDebugString(trace_14.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_14.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_14.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_14.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapIntegerExp domapIntegerExp = dispatcher_0.getDomapIntegerExp();
		final /*@NonInvalid*/ boolean eq = trace_14.equals(domapIntegerExp);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof IntegerLiteralExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull IntegerLiteralExp CAST_temp1_qvtrExpression = (IntegerLiteralExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace_14.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0global;
				if (s0global) {
					final /*@NonInvalid*/ @NonNull PrimitiveType TYP_Integer_0 = (@NonNull PrimitiveType)idResolver.getClass(TypeId.INTEGER, null);
					// mapping statements
					CAST_temp1_qvtrExpression.setIsRequired(ValueUtil.TRUE_VALUE);
					dispatcher_0.setS0global((Boolean)ValueUtil.TRUE_VALUE);
					objectManager.assigned(dispatcher_0, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
					CAST_temp1_qvtrExpression.setType(TYP_Integer_0);
					objectManager.assigned(CAST_temp1_qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, TYP_Integer_0, false);
					final /*@Thrown*/ @Nullable Boolean mmapIntegerExp__qvtr__rest__ = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapIntegerExp__qvtr__rest__;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_s0global;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapIntegerExp__qvtr__rest__");
		}
		return IF_eq;
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
	 * new:qvtr qvtrContext : qvtrelation::SharedVariable[1];
	 * new:qvtr qvtrRelation : qvtrelation::Relation[1];
	 * set qvtrRelation.isAbstract := isAbstract;
	 * set qvtrRelation.name := ruleName;
	 * set trace.t1ruleName := ruleName;
	 * set qvtrRelation.variable := qvtrContext;
	 * set qvtrRelation.transformation := qvtrTransformation;
	 * set trace.t3atlModule := atlModule;
	 * set trace.t3atlOutPattern := atlOutPattern;
	 * set trace.t4qvtrContext := qvtrContext;
	 * set trace.t4qvtrRelation := qvtrRelation;
	 * set trace.t4qvtrTransformation := qvtrTransformation;
	 * set trace.wmapModule := when_mapModule;
	 *
	 */
	protected boolean MAP_mmapMatchedRule__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapMatchedRule trace_15)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapMatchedRule__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_15));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull MatchedRule t3matchedRule = trace_15.getT3matchedRule();
		final /*@NonInvalid*/ @Nullable Module module = t3matchedRule.getModule();
		final /*@NonInvalid*/ boolean symbol_0 = module != null;
		/*@Thrown*/ @Nullable Boolean raw_atlModule;
		if (symbol_0) {
			if (module == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t3atlModule.get(module);
			final /*@Thrown*/ boolean symbol_1 = TmapModule != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
			if (symbol_1) {
				if (TmapModule == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@Thrown*/ @Nullable Boolean s0global = TmapModule.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0global;
				if (s0global) {
					final /*@NonInvalid*/ boolean isAbstract = t3matchedRule.isIsAbstract();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String name_2 = t3matchedRule.getName();
					final /*@NonInvalid*/ @Nullable OutPattern outPattern = t3matchedRule.getOutPattern();
					final /*@NonInvalid*/ boolean symbol_2 = outPattern != null;
					/*@Thrown*/ @Nullable Boolean raw_atlOutPattern;
					if (symbol_2) {
						if (outPattern == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull RelationalTransformation t4qvtrTransformation = TmapModule.getT4qvtrTransformation();
						// creations
						final @NonNull SharedVariable qvtrContext = QVTrelationFactory.eINSTANCE.createSharedVariable();
						models[3/*qvtr*/].add(qvtrContext, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrContext));
						}
						final @NonNull Relation qvtrRelation = QVTrelationFactory.eINSTANCE.createRelation();
						models[3/*qvtr*/].add(qvtrRelation, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrRelation));
						}
						// mapping statements
						qvtrRelation.setIsAbstract(isAbstract);
						qvtrRelation.setName(name_2);
						trace_15.setT1ruleName(name_2);
						qvtrRelation.getVariable().add(qvtrContext);
						qvtrRelation.setTransformation(t4qvtrTransformation);
						trace_15.setT3atlModule(module);
						trace_15.setT3atlOutPattern(outPattern);
						trace_15.setT4qvtrContext(qvtrContext);
						trace_15.setT4qvtrRelation(qvtrRelation);
						trace_15.setT4qvtrTransformation(t4qvtrTransformation);
						trace_15.setWmapModule(TmapModule);
						final /*@Thrown*/ @Nullable Boolean mmapMatchedRule__qvtr__init__ = ValueUtil.TRUE_VALUE;
						raw_atlOutPattern = mmapMatchedRule__qvtr__init__;
					}
					else {
						raw_atlOutPattern = ValueUtil.FALSE_VALUE;
					}
					IF_s0global = raw_atlOutPattern;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				raw_when_mapModule = IF_s0global;
			}
			else {
				raw_when_mapModule = ValueUtil.FALSE_VALUE;
			}
			raw_atlModule = raw_when_mapModule;
		}
		else {
			raw_atlModule = ValueUtil.FALSE_VALUE;
		}
		trace_15.setS0global(raw_atlModule);
		objectManager.assigned(trace_15, trace_ATL2QVTrPackage.Literals.TMAP_MATCHED_RULE__S0GLOBAL, raw_atlModule, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_atlModule ? "done "  : "fail ") + "MAP_mmapMatchedRule__qvtr__init__");
		}
		return raw_atlModule;
	}

	/**
	 *
	 * map:3 mmapNullLiteralExp__qvtr__rest__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNullLiteralExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapNullLiteralExp;
	 * check var qvtrExpression : NullLiteralExp[1] := dispatcher.d4qvtrExpression;
	 * check trace.s0global;
	 * var VoidType1 : Class[1] := VoidType;
	 * set qvtrExpression.isRequired := false;
	 * notify set dispatcher.s0global := true;
	 * notify set qvtrExpression.type := VoidType1;
	 *
	 */
	protected boolean MAP_mmapNullLiteralExp__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapNullLiteralExp trace_16)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapNullLiteralExp__qvtr__rest__" +
				"\n\t\"trace\":" + toDebugString(trace_16) +
				"\n\t\"dispatcher\":" + toDebugString(trace_16.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_16.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_16.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_16.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapNullLiteralExp domapNullLiteralExp = dispatcher_0.getDomapNullLiteralExp();
		final /*@NonInvalid*/ boolean eq = trace_16.equals(domapNullLiteralExp);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof NullLiteralExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull NullLiteralExp CAST_temp1_qvtrExpression = (NullLiteralExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = ((ImapOclExpression)trace_16).getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0global;
				if (s0global) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_VoidType_0 = idResolver.getClass(CLSSid_VoidType, null);
					// mapping statements
					CAST_temp1_qvtrExpression.setIsRequired(ValueUtil.FALSE_VALUE);
					dispatcher_0.setS0global((Boolean)ValueUtil.TRUE_VALUE);
					objectManager.assigned(dispatcher_0, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
					CAST_temp1_qvtrExpression.setType(TYP_VoidType_0);
					objectManager.assigned(CAST_temp1_qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, TYP_VoidType_0, false);
					final /*@Thrown*/ @Nullable Boolean mmapNullLiteralExp__qvtr__rest__ = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapNullLiteralExp__qvtr__rest__;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_s0global;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapNullLiteralExp__qvtr__rest__");
		}
		return IF_eq;
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
	 * var getPackage1 : Package[?] := this.getPackage(atlModule, name)
	 *   ;
	 * var oclAsSet : Set(Package[1|1]) := getPackage1.oclAsSet();
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
	protected boolean MAP_mmapOclModel__IN__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapOclModel_IN trace_17)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclModel__IN__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_17));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclModel t3oclModel = trace_17.getT3oclModel();
		final /*@NonInvalid*/ @Nullable OclModel metamodel = t3oclModel.getMetamodel();
		final /*@NonInvalid*/ boolean symbol_0 = metamodel != null;
		/*@Thrown*/ @Nullable Boolean raw_oclMetamodel;
		if (symbol_0) {
			if (metamodel == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable OclModel metamodel_0 = metamodel.getMetamodel();
			final /*@Thrown*/ boolean eq = metamodel_0 == null;
			/*@Thrown*/ @Nullable Boolean IF_eq;
			if (eq) {
				final /*@NonInvalid*/ @NonNull UnboxedCompositionProperty IMPPROPid_inModels = new UnboxedCompositionProperty(PROPid_inModels);
				final /*@NonInvalid*/ @Nullable Module Module = (@Nullable Module)IMPPROPid_inModels.evaluate(executor, CLSSid_Module, t3oclModel);
				final /*@NonInvalid*/ boolean symbol_1 = Module != null;
				/*@Thrown*/ @Nullable Boolean raw_atlModule;
				if (symbol_1) {
					if (Module == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t3atlModule.get(Module);
					final /*@Thrown*/ boolean symbol_2 = TmapModule != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
					if (symbol_2) {
						if (TmapModule == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean s0global = TmapModule.getS0global();
						if (s0global == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean IF_s0global;
						if (s0global) {
							final /*@Thrown*/ @Nullable TmapOclMetamodel TmapOclMetamodel = OPPOSITE_OF_TmapOclMetamodel_t3oclMetamodel.get(metamodel);
							final /*@Thrown*/ boolean symbol_3 = TmapOclMetamodel != null;
							/*@Thrown*/ @Nullable Boolean raw_when_mapOclMetamodel;
							if (symbol_3) {
								if (TmapOclMetamodel == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								final /*@Thrown*/ @Nullable Boolean s0global_0 = TmapOclMetamodel.getS0global();
								if (s0global_0 == null) {
									throw new InvalidEvaluationException("Null if condition");
								}
								/*@Thrown*/ @Nullable Boolean IF_s0global_0;
								if (s0global_0) {
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull String name_2 = metamodel.getName();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull RelationalTransformation t4qvtrTransformation = TmapModule.getT4qvtrTransformation();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull TypedModel t4qvtrTypedModel = TmapOclMetamodel.getT4qvtrTypedModel();
									final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Package getPackage = ((FUN_getPackage)FTOR_getPackage.getUniqueComputation(this, Module, name_2)).instance;
									final /*@Thrown*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Package, getPackage);
									// mapping statements
									final /*@Thrown*/ @NonNull List<org.eclipse.ocl.pivot.Package> ECORE_oclAsSet_0 = idResolver.ecoreValueOfAll(org.eclipse.ocl.pivot.Package.class, oclAsSet);
									t4qvtrTypedModel.getUsedPackage().addAll(ECORE_oclAsSet_0);
									trace_17.getT4qvtrPackages().addAll(ECORE_oclAsSet_0);
									t4qvtrTypedModel.setTransformation(t4qvtrTransformation);
									trace_17.setT3atlModule(Module);
									trace_17.setT3oclMetamodel(metamodel);
									trace_17.setT4qvtrTransformation(t4qvtrTransformation);
									trace_17.setT4qvtrTypedModel(t4qvtrTypedModel);
									trace_17.setWmapModule(TmapModule);
									trace_17.setWmapOclMetamodel(TmapOclMetamodel);
									final /*@Thrown*/ @Nullable Boolean mmapOclModel__IN__qvtr__init__ = ValueUtil.TRUE_VALUE;
									IF_s0global_0 = mmapOclModel__IN__qvtr__init__;
								}
								else {
									IF_s0global_0 = ValueUtil.FALSE_VALUE;
								}
								raw_when_mapOclMetamodel = IF_s0global_0;
							}
							else {
								raw_when_mapOclMetamodel = ValueUtil.FALSE_VALUE;
							}
							IF_s0global = raw_when_mapOclMetamodel;
						}
						else {
							IF_s0global = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapModule = IF_s0global;
					}
					else {
						raw_when_mapModule = ValueUtil.FALSE_VALUE;
					}
					raw_atlModule = raw_when_mapModule;
				}
				else {
					raw_atlModule = ValueUtil.FALSE_VALUE;
				}
				IF_eq = raw_atlModule;
			}
			else {
				IF_eq = ValueUtil.FALSE_VALUE;
			}
			raw_oclMetamodel = IF_eq;
		}
		else {
			raw_oclMetamodel = ValueUtil.FALSE_VALUE;
		}
		trace_17.setS0global(raw_oclMetamodel);
		objectManager.assigned(trace_17, trace_ATL2QVTrPackage.Literals.TMAP_OCL_MODEL_IN__S0GLOBAL, raw_oclMetamodel, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_oclMetamodel ? "done "  : "fail ") + "MAP_mmapOclModel__IN__qvtr__init__");
		}
		return raw_oclMetamodel;
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
	 * var getPackage1 : Package[?] := this.getPackage(atlModule, name)
	 *   ;
	 * var oclAsSet : Set(Package[1|1]) := getPackage1.oclAsSet();
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
	protected boolean MAP_mmapOclModel__OUT__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapOclModel_OUT trace_18)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclModel__OUT__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_18));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclModel t3oclModel = trace_18.getT3oclModel();
		final /*@NonInvalid*/ @Nullable OclModel metamodel = t3oclModel.getMetamodel();
		final /*@NonInvalid*/ boolean symbol_0 = metamodel != null;
		/*@Thrown*/ @Nullable Boolean raw_oclMetamodel;
		if (symbol_0) {
			if (metamodel == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable OclModel metamodel_0 = metamodel.getMetamodel();
			final /*@Thrown*/ boolean eq = metamodel_0 == null;
			/*@Thrown*/ @Nullable Boolean IF_eq;
			if (eq) {
				final /*@NonInvalid*/ @NonNull UnboxedCompositionProperty IMPPROPid_outModels = new UnboxedCompositionProperty(PROPid_outModels);
				final /*@NonInvalid*/ @Nullable Module Module = (@Nullable Module)IMPPROPid_outModels.evaluate(executor, CLSSid_Module, t3oclModel);
				final /*@NonInvalid*/ boolean symbol_1 = Module != null;
				/*@Thrown*/ @Nullable Boolean raw_atlModule;
				if (symbol_1) {
					if (Module == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t3atlModule.get(Module);
					final /*@Thrown*/ boolean symbol_2 = TmapModule != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
					if (symbol_2) {
						if (TmapModule == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean s0global = TmapModule.getS0global();
						if (s0global == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean IF_s0global;
						if (s0global) {
							final /*@Thrown*/ @Nullable TmapOclMetamodel TmapOclMetamodel = OPPOSITE_OF_TmapOclMetamodel_t3oclMetamodel.get(metamodel);
							final /*@Thrown*/ boolean symbol_3 = TmapOclMetamodel != null;
							/*@Thrown*/ @Nullable Boolean raw_when_mapOclMetamodel;
							if (symbol_3) {
								if (TmapOclMetamodel == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								final /*@Thrown*/ @Nullable Boolean s0global_0 = TmapOclMetamodel.getS0global();
								if (s0global_0 == null) {
									throw new InvalidEvaluationException("Null if condition");
								}
								/*@Thrown*/ @Nullable Boolean IF_s0global_0;
								if (s0global_0) {
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull String name_2 = metamodel.getName();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull RelationalTransformation t4qvtrTransformation = TmapModule.getT4qvtrTransformation();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull TypedModel t4qvtrTypedModel = TmapOclMetamodel.getT4qvtrTypedModel();
									final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Package getPackage = ((FUN_getPackage)FTOR_getPackage.getUniqueComputation(this, Module, name_2)).instance;
									final /*@Thrown*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Package, getPackage);
									// mapping statements
									final /*@Thrown*/ @NonNull List<org.eclipse.ocl.pivot.Package> ECORE_oclAsSet_0 = idResolver.ecoreValueOfAll(org.eclipse.ocl.pivot.Package.class, oclAsSet);
									t4qvtrTypedModel.getUsedPackage().addAll(ECORE_oclAsSet_0);
									trace_18.getT4qvtrPackages().addAll(ECORE_oclAsSet_0);
									t4qvtrTypedModel.setTransformation(t4qvtrTransformation);
									trace_18.setT3atlModule(Module);
									trace_18.setT3oclMetamodel(metamodel);
									trace_18.setT4qvtrTransformation(t4qvtrTransformation);
									trace_18.setT4qvtrTypedModel(t4qvtrTypedModel);
									trace_18.setWmapModule(TmapModule);
									trace_18.setWmapOclMetamodel(TmapOclMetamodel);
									final /*@Thrown*/ @Nullable Boolean mmapOclModel__OUT__qvtr__init__ = ValueUtil.TRUE_VALUE;
									IF_s0global_0 = mmapOclModel__OUT__qvtr__init__;
								}
								else {
									IF_s0global_0 = ValueUtil.FALSE_VALUE;
								}
								raw_when_mapOclMetamodel = IF_s0global_0;
							}
							else {
								raw_when_mapOclMetamodel = ValueUtil.FALSE_VALUE;
							}
							IF_s0global = raw_when_mapOclMetamodel;
						}
						else {
							IF_s0global = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapModule = IF_s0global;
					}
					else {
						raw_when_mapModule = ValueUtil.FALSE_VALUE;
					}
					raw_atlModule = raw_when_mapModule;
				}
				else {
					raw_atlModule = ValueUtil.FALSE_VALUE;
				}
				IF_eq = raw_atlModule;
			}
			else {
				IF_eq = ValueUtil.FALSE_VALUE;
			}
			raw_oclMetamodel = IF_eq;
		}
		else {
			raw_oclMetamodel = ValueUtil.FALSE_VALUE;
		}
		trace_18.setS0global(raw_oclMetamodel);
		objectManager.assigned(trace_18, trace_ATL2QVTrPackage.Literals.TMAP_OCL_MODEL_OUT__S0GLOBAL, raw_oclMetamodel, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_oclMetamodel ? "done "  : "fail ") + "MAP_mmapOclModel__OUT__qvtr__init__");
		}
		return raw_oclMetamodel;
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
	protected boolean MAP_mmapOclType__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapOclType trace_19)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclType__qvtr__rest__" +
				"\n\t\"trace\":" + toDebugString(trace_19) +
				"\n\t\"dispatcher\":" + toDebugString(trace_19.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_19.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_19.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_19.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOclType domapOclType = dispatcher_0.getDomapOclType();
		final /*@NonInvalid*/ boolean eq = trace_19.equals(domapOclType);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			final /*@NonInvalid*/ @Nullable Boolean s0global = trace_19.getS0global();
			if (s0global == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean IF_s0global;
			if (s0global) {
				// mapping statements
				dispatcher_0.setS0global((Boolean)ValueUtil.TRUE_VALUE);
				objectManager.assigned(dispatcher_0, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
				final /*@Thrown*/ @Nullable Boolean mmapOclType__qvtr__rest__ = ValueUtil.TRUE_VALUE;
				IF_s0global = mmapOclType__qvtr__rest__;
			}
			else {
				IF_s0global = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_s0global;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapOclType__qvtr__rest__");
		}
		return IF_eq;
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
	 * set qvtrExpression.isRequired := true;
	 * notify set dispatcher.s0global := true;
	 * notify set qvtrExpression.type := String1;
	 *
	 */
	protected boolean MAP_mmapStringExp__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapStringExp trace_20)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapStringExp__qvtr__rest__" +
				"\n\t\"trace\":" + toDebugString(trace_20) +
				"\n\t\"dispatcher\":" + toDebugString(trace_20.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_20.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_20.getDispatcher().getD4qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_20.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapStringExp domapStringExp = dispatcher_0.getDomapStringExp();
		final /*@NonInvalid*/ boolean eq = trace_20.equals(domapStringExp);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof StringLiteralExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull StringLiteralExp CAST_temp1_qvtrExpression = (StringLiteralExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace_20.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0global;
				if (s0global) {
					final /*@NonInvalid*/ @NonNull PrimitiveType TYP_String_0 = (@NonNull PrimitiveType)idResolver.getClass(TypeId.STRING, null);
					// mapping statements
					CAST_temp1_qvtrExpression.setIsRequired(ValueUtil.TRUE_VALUE);
					dispatcher_0.setS0global((Boolean)ValueUtil.TRUE_VALUE);
					objectManager.assigned(dispatcher_0, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
					CAST_temp1_qvtrExpression.setType(TYP_String_0);
					objectManager.assigned(CAST_temp1_qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, TYP_String_0, false);
					final /*@Thrown*/ @Nullable Boolean mmapStringExp__qvtr__rest__ = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapStringExp__qvtr__rest__;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_s0global;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapStringExp__qvtr__rest__");
		}
		return IF_eq;
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
	protected boolean MAP_mmapVariableExp__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapVariableExp trace_21)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariableExp__qvtr__rest__" +
				"\n\t\"trace\":" + toDebugString(trace_21) +
				"\n\t\"dispatcher\":" + toDebugString(trace_21.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_21.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_21.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_21.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapVariableExp domapVariableExp = dispatcher_0.getDomapVariableExp();
		final /*@NonInvalid*/ boolean eq = trace_21.equals(domapVariableExp);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			final /*@NonInvalid*/ @Nullable Boolean s0global = trace_21.getS0global();
			if (s0global == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean IF_s0global;
			if (s0global) {
				// mapping statements
				dispatcher_0.setS0global((Boolean)ValueUtil.TRUE_VALUE);
				objectManager.assigned(dispatcher_0, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
				final /*@Thrown*/ @Nullable Boolean mmapVariableExp__qvtr__rest__ = ValueUtil.TRUE_VALUE;
				IF_s0global = mmapVariableExp__qvtr__rest__;
			}
			else {
				IF_s0global = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_s0global;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapVariableExp__qvtr__rest__");
		}
		return IF_eq;
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
		models[4/*middle*/].add(mapVariableExp_referredVariable_Helper, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapVariableExp_referredVariable_Helper));
		}
		final @SuppressWarnings("null")@NonNull TmapVariableExp_referredVariable_VariableDeclaration mapVariableExp_referredVariable_VariableDeclaration = trace_ATL2QVTrFactory.eINSTANCE.createTmapVariableExp_referredVariable_VariableDeclaration();
		models[4/*middle*/].add(mapVariableExp_referredVariable_VariableDeclaration, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapVariableExp_referredVariable_VariableDeclaration));
		}
		// mapping statements
		dispatcher.setDomapVariableExp_referredVariable_Helper(mapVariableExp_referredVariable_Helper);
		dispatcher.setDomapVariableExp_referredVariable_VariableDeclaration(mapVariableExp_referredVariable_VariableDeclaration);
		jm_TmapVariableExp__referredVariable__Helper.appendElement(mapVariableExp_referredVariable_Helper);
		jm_TmapVariableExp__referredVariable__VariableDecl.appendElement(mapVariableExp_referredVariable_VariableDeclaration);
		final /*@Thrown*/ @Nullable Boolean mmapVariableExp__referredVariable__dispatch__qvtr = ValueUtil.TRUE_VALUE;
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
	 * var elements : Set(ATL::InPatternElement[+]) := atlPattern.elements;
	 * check var _'safe-excluding' : Set(ATL::InPatternElement[+|1]) := elements->excluding(null)
	 *   ;
	 * var collect : Bag(OCL::OclType) := _'safe-excluding'->collect(i | i.type)
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
	protected boolean MAP_mmapInPattern__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapInPattern trace_22)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapInPattern__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_22));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull InPattern t3atlPattern = trace_22.getT3atlPattern();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull MatchedRule rule = t3atlPattern.getRule();
		final /*@NonInvalid*/ @Nullable TmapMatchedRule TmapMatchedRule = OPPOSITE_OF_TmapMatchedRule_t3matchedRule.get(rule);
		final /*@NonInvalid*/ boolean symbol_0 = TmapMatchedRule != null;
		/*@Thrown*/ @Nullable Boolean raw_when_mapMatchedRule;
		if (symbol_0) {
			if (TmapMatchedRule == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean s0global = TmapMatchedRule.getS0global();
			if (s0global == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean IF_s0global;
			if (s0global) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<InPatternElement> elements = t3atlPattern.getElements();
				final /*@NonInvalid*/ @NonNull SetValue BOXED_elements = idResolver.createSetOfAll(SET_CLSSid_InPatternElement, elements);
				final /*@Thrown*/ @NonNull CollectionValue temp1_safe_m_excluding = CollectionExcludingOperation.INSTANCE.evaluate(BOXED_elements, (Object)null);
				final /*@NonInvalid*/ boolean symbol_1 = temp1_safe_m_excluding instanceof SetValue;
				/*@Thrown*/ @Nullable Boolean IF_symbol_1;
				if (symbol_1) {
					final /*@Thrown*/ @NonNull SetValue CAST_temp1_safe_m_excluding = (SetValue)temp1_safe_m_excluding;
					/*@Thrown*/ BagValue.@NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_OclType);
					@NonNull Iterator<Object> ITERATOR_i = CAST_temp1_safe_m_excluding.iterator();
					/*@Thrown*/ @NonNull BagValue collect;
					while (true) {
						if (!ITERATOR_i.hasNext()) {
							collect = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull InPatternElement i = (@NonNull InPatternElement)ITERATOR_i.next();
						/**
						 * i.type
						 */
						final /*@NonInvalid*/ @Nullable OclType type_2 = i.getType();
						//
						accumulator.add(type_2);
					}
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_OclModelElement_0 = idResolver.getClass(CLSSid_OclModelElement, null);
					final /*@Thrown*/ @NonNull BagValue selectByKind = (@Nullable BagValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect, TYP_OCL_c_c_OclModelElement_0);
					@NonNull Iterator<Object> ITERATOR_i_0 = selectByKind.iterator();
					/*@Thrown*/ @NonNull OclModelElement any;
					while (true) {
						if (!ITERATOR_i_0.hasNext()) {
							throw new InvalidValueException("Nothing to return for ''any''");
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull OclModelElement i_0 = (@NonNull OclModelElement)ITERATOR_i_0.next();
						/**
						 * true
						 */
						//
						if (ValueUtil.TRUE_VALUE) {			// Carry on till something found
							any = i_0;
							break;
						}
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OclModel model = any.getModel();
					final /*@Thrown*/ @Nullable OclModel metamodel = model.getMetamodel();
					final /*@Thrown*/ boolean eq = metamodel == null;
					/*@Thrown*/ @Nullable Boolean IF_eq;
					if (eq) {
						final /*@Thrown*/ @Nullable TmapOclMetamodel TmapOclMetamodel = OPPOSITE_OF_TmapOclMetamodel_t3oclMetamodel.get(model);
						final /*@Thrown*/ boolean symbol_2 = TmapOclMetamodel != null;
						/*@Thrown*/ @Nullable Boolean raw_when_mapOclMetamodel;
						if (symbol_2) {
							if (TmapOclMetamodel == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							final /*@Thrown*/ @Nullable Boolean s0global_0 = TmapOclMetamodel.getS0global();
							if (s0global_0 == null) {
								throw new InvalidEvaluationException("Null if condition");
							}
							/*@Thrown*/ @Nullable Boolean IF_s0global_0;
							if (s0global_0) {
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull Relation t4qvtrRelation = TmapMatchedRule.getT4qvtrRelation();
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull TypedModel t4qvtrTypedModel = TmapOclMetamodel.getT4qvtrTypedModel();
								// creations
								final @NonNull RelationDomain qvtrDomain = QVTrelationFactory.eINSTANCE.createRelationDomain();
								models[3/*qvtr*/].add(qvtrDomain, false);
								if (debugCreations) {
									AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrDomain));
								}
								// mapping statements
								qvtrDomain.setRule(t4qvtrRelation);
								qvtrDomain.setTypedModel(t4qvtrTypedModel);
								trace_22.setT3atlModel(model);
								trace_22.setT3atlRule(rule);
								trace_22.setT4qvtrDomain(qvtrDomain);
								trace_22.setT4qvtrRelation(t4qvtrRelation);
								trace_22.setT4qvtrTypedModel(t4qvtrTypedModel);
								trace_22.setWmapMatchedRule(TmapMatchedRule);
								trace_22.setWmapOclMetamodel(TmapOclMetamodel);
								final /*@Thrown*/ @Nullable Boolean mmapInPattern__qvtr__init__ = ValueUtil.TRUE_VALUE;
								IF_s0global_0 = mmapInPattern__qvtr__init__;
							}
							else {
								IF_s0global_0 = ValueUtil.FALSE_VALUE;
							}
							raw_when_mapOclMetamodel = IF_s0global_0;
						}
						else {
							raw_when_mapOclMetamodel = ValueUtil.FALSE_VALUE;
						}
						IF_eq = raw_when_mapOclMetamodel;
					}
					else {
						IF_eq = ValueUtil.FALSE_VALUE;
					}
					IF_symbol_1 = IF_eq;
				}
				else {
					IF_symbol_1 = ValueUtil.FALSE_VALUE;
				}
				IF_s0global = IF_symbol_1;
			}
			else {
				IF_s0global = ValueUtil.FALSE_VALUE;
			}
			raw_when_mapMatchedRule = IF_s0global;
		}
		else {
			raw_when_mapMatchedRule = ValueUtil.FALSE_VALUE;
		}
		trace_22.setS0global(raw_when_mapMatchedRule);
		objectManager.assigned(trace_22, trace_ATL2QVTrPackage.Literals.TMAP_IN_PATTERN__S0GLOBAL, raw_when_mapMatchedRule, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_mapMatchedRule ? "done "  : "fail ") + "MAP_mmapInPattern__qvtr__init__");
		}
		return raw_when_mapMatchedRule;
	}

	/**
	 *
	 * map:4 mmapMatchedRule__qvtr__rest__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapMatchedRule[1];
	 * check trace.s0global;
	 * var qvtrContext : qvtrelation::SharedVariable[1] := trace.t4qvtrContext;
	 * var qvtrRelation : qvtrelation::Relation[1] := trace.t4qvtrRelation;
	 * var _'qvttrace::TraceElement' : Class[1] := qvttrace::TraceElement;
	 * set qvtrContext.isImplicit := true;
	 * set qvtrContext.name := 'trace';
	 * set qvtrRelation.isTopLevel := true;
	 * set qvtrContext.type := _'qvttrace::TraceElement';
	 *
	 */
	protected boolean MAP_mmapMatchedRule__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapMatchedRule trace_23)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapMatchedRule__qvtr__rest__" +
				"\n\t\"trace\":" + toDebugString(trace_23));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Boolean s0global = trace_23.getS0global();
		if (s0global == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean IF_s0global;
		if (s0global) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull SharedVariable t4qvtrContext = trace_23.getT4qvtrContext();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Relation t4qvtrRelation = trace_23.getT4qvtrRelation();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvttrace_c_c_TraceElement_0 = idResolver.getClass(CLSSid_TraceElement, null);
			// mapping statements
			t4qvtrContext.setIsImplicit(ValueUtil.TRUE_VALUE);
			t4qvtrContext.setName(STR_trace);
			t4qvtrRelation.setIsTopLevel(ValueUtil.TRUE_VALUE);
			t4qvtrContext.setType(TYP_qvttrace_c_c_TraceElement_0);
			final /*@Thrown*/ @Nullable Boolean mmapMatchedRule__qvtr__rest__ = ValueUtil.TRUE_VALUE;
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
	protected boolean MAP_mmapMatchedRule__super__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapMatchedRule_super trace_24)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapMatchedRule__super__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_24));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull MatchedRule t3atlChildRule = trace_24.getT3atlChildRule();
		final /*@NonInvalid*/ @Nullable TmapMatchedRule TmapMatchedRule = OPPOSITE_OF_TmapMatchedRule_t3matchedRule.get(t3atlChildRule);
		final /*@NonInvalid*/ boolean symbol_0 = TmapMatchedRule != null;
		/*@Thrown*/ @Nullable Boolean raw_when_mapMatchedRule;
		if (symbol_0) {
			if (TmapMatchedRule == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean s0global = TmapMatchedRule.getS0global();
			if (s0global == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean IF_s0global;
			if (s0global) {
				final /*@NonInvalid*/ @Nullable MatchedRule superRule = t3atlChildRule.getSuperRule();
				final /*@NonInvalid*/ boolean symbol_1 = superRule != null;
				/*@Thrown*/ @Nullable Boolean raw_atlSuperRule;
				if (symbol_1) {
					if (superRule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable TmapMatchedRule TmapMatchedRule_0 = OPPOSITE_OF_TmapMatchedRule_t3matchedRule.get(superRule);
					final /*@Thrown*/ boolean symbol_2 = TmapMatchedRule_0 != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapMatchedRule1;
					if (symbol_2) {
						if (TmapMatchedRule_0 == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean s0global_0 = TmapMatchedRule_0.getS0global();
						if (s0global_0 == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean IF_s0global_0;
						if (s0global_0) {
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull Relation t4qvtrRelation = TmapMatchedRule.getT4qvtrRelation();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull Relation t4qvtrRelation_0 = TmapMatchedRule_0.getT4qvtrRelation();
							// mapping statements
							t4qvtrRelation.getOverrides().add(t4qvtrRelation_0);
							trace_24.setT3atlSuperRule(superRule);
							trace_24.setT4qvtrOverriddenRelation(t4qvtrRelation_0);
							trace_24.setT4qvtrOverridesRelation(t4qvtrRelation);
							trace_24.setWmapMatchedRule1(TmapMatchedRule);
							trace_24.setWmapMatchedRule(TmapMatchedRule_0);
							final /*@Thrown*/ @Nullable Boolean mmapMatchedRule__super__qvtr__init__ = ValueUtil.TRUE_VALUE;
							IF_s0global_0 = mmapMatchedRule__super__qvtr__init__;
						}
						else {
							IF_s0global_0 = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapMatchedRule1 = IF_s0global_0;
					}
					else {
						raw_when_mapMatchedRule1 = ValueUtil.FALSE_VALUE;
					}
					raw_atlSuperRule = raw_when_mapMatchedRule1;
				}
				else {
					raw_atlSuperRule = ValueUtil.FALSE_VALUE;
				}
				IF_s0global = raw_atlSuperRule;
			}
			else {
				IF_s0global = ValueUtil.FALSE_VALUE;
			}
			raw_when_mapMatchedRule = IF_s0global;
		}
		else {
			raw_when_mapMatchedRule = ValueUtil.FALSE_VALUE;
		}
		trace_24.setS0global(raw_when_mapMatchedRule);
		objectManager.assigned(trace_24, trace_ATL2QVTrPackage.Literals.TMAP_MATCHED_RULE_SUPER__S0GLOBAL, raw_when_mapMatchedRule, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_mapMatchedRule ? "done "  : "fail ") + "MAP_mmapMatchedRule__super__qvtr__init__");
		}
		return raw_when_mapMatchedRule;
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
	protected boolean MAP_mmapSimpleOutPatternElement__qvtr__init__(final @NonNull Connection jm_TmapVariable, final /*@NonInvalid*/ @NonNull TmapSimpleOutPatternElement trace_25)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapSimpleOutPatternElement__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_25));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull SimpleOutPatternElement t3atlElement = trace_25.getT3atlElement();
		final /*@NonInvalid*/ @Nullable OclType temp1_atlType = t3atlElement.getType();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlType instanceof OclModelElement;
		/*@Thrown*/ @Nullable Boolean IF_symbol_0;
		if (symbol_0) {
			final /*@NonInvalid*/ @Nullable OclModelElement CAST_temp1_atlType = (OclModelElement)temp1_atlType;
			if (CAST_temp1_atlType == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull OclModel model = CAST_temp1_atlType.getModel();
			final /*@Thrown*/ @Nullable OclModel metamodel = model.getMetamodel();
			final /*@Thrown*/ boolean eq = metamodel == null;
			/*@Thrown*/ @Nullable Boolean IF_eq;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OutPattern outPattern = t3atlElement.getOutPattern();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Rule temp1_atlRule = outPattern.getRule();
				final /*@NonInvalid*/ boolean symbol_1 = temp1_atlRule instanceof MatchedRule;
				/*@Thrown*/ @Nullable Boolean IF_symbol_1;
				if (symbol_1) {
					final /*@NonInvalid*/ @NonNull MatchedRule CAST_temp1_atlRule = (MatchedRule)temp1_atlRule;
					final /*@NonInvalid*/ @Nullable TmapMatchedRule TmapMatchedRule = OPPOSITE_OF_TmapMatchedRule_t3matchedRule.get(CAST_temp1_atlRule);
					final /*@NonInvalid*/ boolean symbol_2 = TmapMatchedRule != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapMatchedRule;
					if (symbol_2) {
						if (TmapMatchedRule == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean s0global = TmapMatchedRule.getS0global();
						if (s0global == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean IF_s0global;
						if (s0global) {
							final /*@Thrown*/ @Nullable TmapOclMetamodel TmapOclMetamodel = OPPOSITE_OF_TmapOclMetamodel_t3oclMetamodel.get(model);
							final /*@Thrown*/ boolean symbol_3 = TmapOclMetamodel != null;
							/*@Thrown*/ @Nullable Boolean raw_when_mapOclMetamodel;
							if (symbol_3) {
								if (TmapOclMetamodel == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								final /*@Thrown*/ @Nullable Boolean s0global_0 = TmapOclMetamodel.getS0global();
								if (s0global_0 == null) {
									throw new InvalidEvaluationException("Null if condition");
								}
								/*@Thrown*/ @Nullable Boolean IF_s0global_0;
								if (s0global_0) {
									@SuppressWarnings("null")
									final /*@NonInvalid*/ @NonNull String varName = t3atlElement.getVarName();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull Relation t4qvtrRelation = TmapMatchedRule.getT4qvtrRelation();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull TypedModel t4qvtrTypedModel = TmapOclMetamodel.getT4qvtrTypedModel();
									final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(this, CAST_temp1_atlType)).instance;
									// creations
									final @NonNull RelationDomain qvtrDomain = QVTrelationFactory.eINSTANCE.createRelationDomain();
									models[3/*qvtr*/].add(qvtrDomain, false);
									if (debugCreations) {
										AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrDomain));
									}
									final @NonNull DomainPattern qvtrPattern = QVTrelationFactory.eINSTANCE.createDomainPattern();
									models[3/*qvtr*/].add(qvtrPattern, false);
									if (debugCreations) {
										AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrPattern));
									}
									final @NonNull ObjectTemplateExp qvtrTemplate = QVTtemplateFactory.eINSTANCE.createObjectTemplateExp();
									models[3/*qvtr*/].add(qvtrTemplate, false);
									if (debugCreations) {
										AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrTemplate));
									}
									final @NonNull TemplateVariable qvtrVariable = QVTrelationFactory.eINSTANCE.createTemplateVariable();
									models[3/*qvtr*/].add(qvtrVariable, false);
									if (debugCreations) {
										AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrVariable));
									}
									final @SuppressWarnings("null")@NonNull TmapVariable where_mapVariable = INSTANCE_ICACHE_TmapVariable.evaluate(t3atlElement, qvtrVariable);
									if (debugCreations) {
										AbstractTransformer.CREATIONS.println("created " + toDebugString(where_mapVariable));
									}
									// mapping statements
									qvtrVariable.setName(varName);
									trace_25.setT1elementName(varName);
									qvtrDomain.setRule(t4qvtrRelation);
									qvtrDomain.setTypedModel(t4qvtrTypedModel);
									qvtrPattern.setRelationDomain(qvtrDomain);
									qvtrPattern.setTemplateExpression(qvtrTemplate);
									qvtrTemplate.setBindsTo(qvtrVariable);
									qvtrTemplate.setReferredClass(getType);
									qvtrTemplate.setType(getType);
									objectManager.assigned(qvtrTemplate, PivotPackage.Literals.TYPED_ELEMENT__TYPE, getType, false);
									t4qvtrRelation.getVariable().add(qvtrVariable);
									qvtrDomain.getRootVariable().add(qvtrVariable);
									qvtrVariable.setType(getType);
									trace_25.setT3atlMetamodel(model);
									trace_25.setT3atlPattern(outPattern);
									trace_25.setT3atlRule(CAST_temp1_atlRule);
									trace_25.setT3atlType(CAST_temp1_atlType);
									trace_25.setT4qvtrDomain(qvtrDomain);
									trace_25.setT4qvtrPattern(qvtrPattern);
									trace_25.setT4qvtrRelation(t4qvtrRelation);
									trace_25.setT4qvtrTemplate(qvtrTemplate);
									trace_25.setT4qvtrType(getType);
									trace_25.setT4qvtrTypedModel(t4qvtrTypedModel);
									trace_25.setT4qvtrVariable(qvtrVariable);
									trace_25.setWmapMatchedRule(TmapMatchedRule);
									trace_25.setWmapOclMetamodel(TmapOclMetamodel);
									trace_25.setWmapVariable(where_mapVariable);
									jm_TmapVariable.appendElement(where_mapVariable);
									final /*@Thrown*/ @Nullable Boolean mmapSimpleOutPatternElement__qvtr__init__ = ValueUtil.TRUE_VALUE;
									IF_s0global_0 = mmapSimpleOutPatternElement__qvtr__init__;
								}
								else {
									IF_s0global_0 = ValueUtil.FALSE_VALUE;
								}
								raw_when_mapOclMetamodel = IF_s0global_0;
							}
							else {
								raw_when_mapOclMetamodel = ValueUtil.FALSE_VALUE;
							}
							IF_s0global = raw_when_mapOclMetamodel;
						}
						else {
							IF_s0global = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapMatchedRule = IF_s0global;
					}
					else {
						raw_when_mapMatchedRule = ValueUtil.FALSE_VALUE;
					}
					IF_symbol_1 = raw_when_mapMatchedRule;
				}
				else {
					IF_symbol_1 = ValueUtil.FALSE_VALUE;
				}
				IF_eq = IF_symbol_1;
			}
			else {
				IF_eq = ValueUtil.FALSE_VALUE;
			}
			IF_symbol_0 = IF_eq;
		}
		else {
			IF_symbol_0 = ValueUtil.FALSE_VALUE;
		}
		trace_25.setS0global(IF_symbol_0);
		objectManager.assigned(trace_25, trace_ATL2QVTrPackage.Literals.TMAP_SIMPLE_OUT_PATTERN_ELEMENT__S0GLOBAL, IF_symbol_0, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_symbol_0 ? "done "  : "fail ") + "MAP_mmapSimpleOutPatternElement__qvtr__init__");
		}
		return IF_symbol_0;
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
		protected final /*@NonInvalid*/ @NonNull TmapHelper_Attribute trace_26;

		public MAP_mmapHelper__Attribute__qvtr__loop__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			jm_TmapHelper__Context = (Connection)boundValues[0];
			trace_26 = (@NonNull TmapHelper_Attribute)boundValues[1];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_26.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapHelper_Attribute domapHelper_Attribute = dispatcher_0.getDomapHelper_Attribute();
			final /*@NonInvalid*/ boolean eq = trace_26.equals(domapHelper_Attribute);
			/*@Thrown*/ @Nullable Boolean IF_eq;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Helper d3atlHelper = dispatcher_0.getD3atlHelper();
				final /*@NonInvalid*/ @Nullable Boolean s0local = trace_26.getS0local();
				if (s0local == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0local;
				if (s0local) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace_26.getWmapOclExpression();
					SlotState.@NonNull Speculating outputSpeculatingSlotState = objectManager.getSpeculatingSlotState(trace_26, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__S0GLOBAL);
					Boolean outputSpeculatingSlotStatus = outputSpeculatingSlotState.getSpeculationStatus();
					if (outputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
						if (outputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
							trace_26.setS0global(ValueUtil.FALSE_VALUE);
							return ValueUtil.FALSE_VALUE;
						}
						SlotState.@NonNull Speculating inputSpeculatingSlotState;
						Boolean inputSpeculatingSlotStatus;
						boolean needsSpeculation = false;
						if (wmapOclExpression == null) {
							throw new InvalidEvaluationException("Null when_mapOclExpression speculation source");
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
					boolean symbol_9 = true;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String t1attributeName = trace_26.getT1attributeName();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclType t3atlType = trace_26.getT3atlType();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull RelationalTransformation t4qvtrTransformation = trace_26.getT4qvtrTransformation();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(ATL2QVTr.this, t3atlType)).instance;
					// creations
					final @NonNull Function qvtrFunction = QVTbaseFactory.eINSTANCE.createFunction();
					models[3/*qvtr*/].add(qvtrFunction, false);
					if (debugCreations) {
						AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrFunction));
					}
					final @SuppressWarnings("null")@NonNull TmapHelper_Context where_mapHelper_Context = INSTANCE_ICACHE_TmapHelper_Context.evaluate(d3atlHelper, qvtrFunction);
					if (debugCreations) {
						AbstractTransformer.CREATIONS.println("created " + toDebugString(where_mapHelper_Context));
					}
					// mapping statements
					qvtrFunction.setName(t1attributeName);
					dispatcher_0.setS0global((Boolean)ValueUtil.TRUE_VALUE);
					objectManager.assigned(dispatcher_0, trace_ATL2QVTrPackage.Literals.DMAP_HELPER__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
					dispatcher_0.setD4qvtrFunction(qvtrFunction);
					trace_26.setWmapHelper_Context(where_mapHelper_Context);
					qvtrFunction.setOwningClass(t4qvtrTransformation);
					qvtrFunction.setType(getType);
					jm_TmapHelper__Context.appendElement(where_mapHelper_Context);
					final /*@Thrown*/ @Nullable Boolean mmapHelper__Attribute__qvtr__loop__ = ValueUtil.TRUE_VALUE;
					IF_s0local = symbol_9;
				}
				else {
					IF_s0local = ValueUtil.FALSE_VALUE;
				}
				IF_eq = IF_s0local;
			}
			else {
				IF_eq = ValueUtil.FALSE_VALUE;
			}
			trace_26.setS0global(IF_eq);
			objectManager.assigned(trace_26, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__S0GLOBAL, IF_eq, false);
			return IF_eq;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(jm_TmapHelper__Context, thoseValues[0])
				&& idResolver.oclEquals(trace_26, thoseValues[1]);
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
	 * notify set qvtrParameter.isRequired := true;
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
		protected final @NonNull Connection jm_TmapVariable_0;
		protected final /*@NonInvalid*/ @NonNull TmapHelper_Context trace_27;

		public MAP_mmapHelper__Context__qvtr__loop__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			jm_TmapVariable_0 = (Connection)boundValues[0];
			trace_27 = (@NonNull TmapHelper_Context)boundValues[1];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Helper t3atlHelper = trace_27.getT3atlHelper();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Function t4qvtrFunction = trace_27.getT4qvtrFunction();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = t3atlHelper.getDefinition();
			final /*@NonInvalid*/ @Nullable OclContextDefinition context_ = definition.getContext_();
			final /*@NonInvalid*/ boolean symbol_0 = context_ != null;
			/*@Thrown*/ @Nullable Boolean raw_atlContext;
			if (symbol_0) {
				if (context_ == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull OclType context__0 = context_.getContext_();
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(ATL2QVTr.this, context__0)).instance;
				// creations
				final @NonNull FunctionParameter qvtrParameter = QVTbaseFactory.eINSTANCE.createFunctionParameter();
				models[3/*qvtr*/].add(qvtrParameter, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrParameter));
				}
				final @SuppressWarnings("null")@NonNull TmapVariable where_mapVariable = INSTANCE_ICACHE_TmapVariable.evaluate(t3atlHelper, qvtrParameter);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(where_mapVariable));
				}
				// mapping statements
				qvtrParameter.setIsRequired(ValueUtil.TRUE_VALUE);
				objectManager.assigned(qvtrParameter, PivotPackage.Literals.TYPED_ELEMENT__IS_REQUIRED, ValueUtil.TRUE_VALUE, false);
				qvtrParameter.setName(STR_self);
				objectManager.assigned(qvtrParameter, PivotPackage.Literals.NAMED_ELEMENT__NAME, STR_self, false);
				trace_27.setT3atlContext(context_);
				trace_27.setT3atlDefinition(definition);
				trace_27.setT3atlReturnType(context__0);
				trace_27.setT4qvtrParameter(qvtrParameter);
				trace_27.setWmapVariable(where_mapVariable);
				qvtrParameter.setOwningOperation(t4qvtrFunction);
				qvtrParameter.setType(getType);
				objectManager.assigned(qvtrParameter, PivotPackage.Literals.TYPED_ELEMENT__TYPE, getType, false);
				jm_TmapVariable_0.appendElement(where_mapVariable);
				final /*@Thrown*/ @Nullable Boolean mmapHelper__Context__qvtr__loop__ = ValueUtil.TRUE_VALUE;
				raw_atlContext = mmapHelper__Context__qvtr__loop__;
			}
			else {
				raw_atlContext = ValueUtil.FALSE_VALUE;
			}
			trace_27.setS0global(raw_atlContext);
			objectManager.assigned(trace_27, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_CONTEXT__S0GLOBAL, raw_atlContext, false);
			return raw_atlContext;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(jm_TmapVariable_0, thoseValues[0])
				&& idResolver.oclEquals(trace_27, thoseValues[1]);
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
		protected final @NonNull Connection jm_TmapHelper__Context_0;
		protected final /*@NonInvalid*/ @NonNull TmapHelper_Operation trace_28;

		public MAP_mmapHelper__Operation__qvtr__loop__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			jm_TmapHelper__Context_0 = (Connection)boundValues[0];
			trace_28 = (@NonNull TmapHelper_Operation)boundValues[1];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_28.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapHelper_Operation domapHelper_Operation = dispatcher_0.getDomapHelper_Operation();
			final /*@NonInvalid*/ boolean eq = trace_28.equals(domapHelper_Operation);
			/*@Thrown*/ @Nullable Boolean IF_eq;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Helper d3atlHelper = dispatcher_0.getD3atlHelper();
				final /*@NonInvalid*/ @Nullable Boolean s0local = trace_28.getS0local();
				if (s0local == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0local;
				if (s0local) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace_28.getWmapOclExpression();
					SlotState.@NonNull Speculating outputSpeculatingSlotState = objectManager.getSpeculatingSlotState(trace_28, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__S0GLOBAL);
					Boolean outputSpeculatingSlotStatus = outputSpeculatingSlotState.getSpeculationStatus();
					if (outputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
						if (outputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
							trace_28.setS0global(ValueUtil.FALSE_VALUE);
							return ValueUtil.FALSE_VALUE;
						}
						SlotState.@NonNull Speculating inputSpeculatingSlotState;
						Boolean inputSpeculatingSlotStatus;
						boolean needsSpeculation = false;
						if (wmapOclExpression == null) {
							throw new InvalidEvaluationException("Null when_mapOclExpression speculation source");
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
					boolean symbol_9 = true;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String t1operationName = trace_28.getT1operationName();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclType t3atlType = trace_28.getT3atlType();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull RelationalTransformation t4qvtrTransformation = trace_28.getT4qvtrTransformation();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(ATL2QVTr.this, t3atlType)).instance;
					// creations
					final @NonNull Function qvtrFunction = QVTbaseFactory.eINSTANCE.createFunction();
					models[3/*qvtr*/].add(qvtrFunction, false);
					if (debugCreations) {
						AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrFunction));
					}
					final @SuppressWarnings("null")@NonNull TmapHelper_Context where_mapHelper_Context = INSTANCE_ICACHE_TmapHelper_Context.evaluate(d3atlHelper, qvtrFunction);
					if (debugCreations) {
						AbstractTransformer.CREATIONS.println("created " + toDebugString(where_mapHelper_Context));
					}
					// mapping statements
					qvtrFunction.setName(t1operationName);
					dispatcher_0.setS0global((Boolean)ValueUtil.TRUE_VALUE);
					objectManager.assigned(dispatcher_0, trace_ATL2QVTrPackage.Literals.DMAP_HELPER__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
					dispatcher_0.setD4qvtrFunction(qvtrFunction);
					trace_28.setWmapHelper_Context(where_mapHelper_Context);
					qvtrFunction.setOwningClass(t4qvtrTransformation);
					qvtrFunction.setType(getType);
					jm_TmapHelper__Context_0.appendElement(where_mapHelper_Context);
					final /*@Thrown*/ @Nullable Boolean mmapHelper__Operation__qvtr__loop__ = ValueUtil.TRUE_VALUE;
					IF_s0local = symbol_9;
				}
				else {
					IF_s0local = ValueUtil.FALSE_VALUE;
				}
				IF_eq = IF_s0local;
			}
			else {
				IF_eq = ValueUtil.FALSE_VALUE;
			}
			trace_28.setS0global(IF_eq);
			objectManager.assigned(trace_28, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__S0GLOBAL, IF_eq, false);
			return IF_eq;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(jm_TmapHelper__Context_0, thoseValues[0])
				&& idResolver.oclEquals(trace_28, thoseValues[1]);
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
			final /*@NonInvalid*/ @Nullable TmapHelper_Attribute domapHelper_Attribute = mapHelper.getDomapHelper_Attribute();
			final /*@NonInvalid*/ boolean symbol_0 = domapHelper_Attribute != null;
			/*@Thrown*/ @Nullable Boolean raw_mapHelper_Attribute;
			if (symbol_0) {
				if (domapHelper_Attribute == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				objectManager.getting(domapHelper_Attribute, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__S0GLOBAL, false);
				final /*@Thrown*/ @Nullable Boolean s0global = domapHelper_Attribute.getS0global();
				final /*@Thrown*/ boolean eq = s0global == Boolean.FALSE;
				/*@Thrown*/ @Nullable Boolean IF_eq;
				if (eq) {
					final /*@NonInvalid*/ @Nullable TmapHelper_Operation domapHelper_Operation = mapHelper.getDomapHelper_Operation();
					final /*@NonInvalid*/ boolean symbol_1 = domapHelper_Operation != null;
					/*@Thrown*/ @Nullable Boolean raw_mapHelper_Operation;
					if (symbol_1) {
						if (domapHelper_Operation == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						objectManager.getting(domapHelper_Operation, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__S0GLOBAL, false);
						final /*@Thrown*/ @Nullable Boolean s0global_0 = domapHelper_Operation.getS0global();
						final /*@Thrown*/ boolean eq_0 = s0global_0 == Boolean.FALSE;
						/*@Thrown*/ @Nullable Boolean IF_eq_0;
						if (eq_0) {
							// mapping statements
							mapHelper.setS0global((Boolean)ValueUtil.FALSE_VALUE);
							objectManager.assigned(mapHelper, trace_ATL2QVTrPackage.Literals.DMAP_HELPER__S0GLOBAL, ValueUtil.FALSE_VALUE, false);
							final /*@Thrown*/ @Nullable Boolean mmapHelper__verdict__qvtr = ValueUtil.TRUE_VALUE;
							IF_eq_0 = mmapHelper__verdict__qvtr;
						}
						else {
							IF_eq_0 = ValueUtil.FALSE_VALUE;
						}
						raw_mapHelper_Operation = IF_eq_0;
					}
					else {
						raw_mapHelper_Operation = ValueUtil.FALSE_VALUE;
					}
					IF_eq = raw_mapHelper_Operation;
				}
				else {
					IF_eq = ValueUtil.FALSE_VALUE;
				}
				raw_mapHelper_Attribute = IF_eq;
			}
			else {
				raw_mapHelper_Attribute = ValueUtil.FALSE_VALUE;
			}
			return raw_mapHelper_Attribute;
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
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression1;
	 * var when_mapOclExpression1 : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var when_mapOclExpression2 : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression2;
	 * new:qvtr qvtrExpression : IfExp[1];
	 * notify set dispatcher.s0global := true;
	 * set dispatcher.d4qvtrExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_mmapIfExp__qvtr__loop__(final /*@NonInvalid*/ @NonNull TmapIfExp trace_29)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapIfExp__qvtr__loop__" +
				"\n\t\"trace\":" + toDebugString(trace_29) +
				"\n\t\"dispatcher\":" + toDebugString(trace_29.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_29.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_29.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_29.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapIfExp domapIfExp = dispatcher_0.getDomapIfExp();
		final /*@NonInvalid*/ boolean eq = trace_29.equals(domapIfExp);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			final /*@NonInvalid*/ @Nullable Boolean s0local = trace_29.getS0local();
			if (s0local == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean IF_s0local;
			if (s0local) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression1 = trace_29.getWmapOclExpression1();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace_29.getWmapOclExpression();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression2 = trace_29.getWmapOclExpression2();
				// creations
				final org.eclipse.ocl.pivot.@NonNull IfExp qvtrExpression = PivotFactory.eINSTANCE.createIfExp();
				models[3/*qvtr*/].add(qvtrExpression, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
				}
				// mapping statements
				dispatcher_0.setS0global((Boolean)ValueUtil.TRUE_VALUE);
				objectManager.assigned(dispatcher_0, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
				dispatcher_0.setD4qvtrExpression(qvtrExpression);
				final /*@Thrown*/ @Nullable Boolean mmapIfExp__qvtr__loop__ = ValueUtil.TRUE_VALUE;
				IF_s0local = mmapIfExp__qvtr__loop__;
			}
			else {
				IF_s0local = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_s0local;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		trace_29.setS0global(IF_eq);
		objectManager.assigned(trace_29, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_eq, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapIfExp__qvtr__loop__");
		}
		return IF_eq;
	}

	/**
	 *
	 * map:5 mmapModule__qvtr__rest__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapModule[1];
	 * check trace.s0global;
	 * var _1 : Package[1] := trace.t4_1;
	 * var _2 : Parameter[1] := trace.t4_2;
	 * var _3 : qvtbase::TypedModel[1] := trace.t4_3;
	 * set _1.name := '';
	 * notify set _2.isRequired := true;
	 * notify set _2.name := 'this';
	 * set _3.isTrace := true;
	 * set _3.name := 'middle';
	 *
	 */
	protected boolean MAP_mmapModule__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapModule trace_30)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapModule__qvtr__rest__" +
				"\n\t\"trace\":" + toDebugString(trace_30));
		}
		final /*@NonInvalid*/ @Nullable Boolean s0global = trace_30.getS0global();
		if (s0global == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean IF_s0global;
		if (s0global) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Package t4_1 = trace_30.getT4_1();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Parameter t4_2 = trace_30.getT4_2();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull TypedModel t4_3 = trace_30.getT4_3();
			// mapping statements
			t4_1.setName(STR_);
			t4_2.setIsRequired(ValueUtil.TRUE_VALUE);
			objectManager.assigned(t4_2, PivotPackage.Literals.TYPED_ELEMENT__IS_REQUIRED, ValueUtil.TRUE_VALUE, false);
			t4_2.setName(STR_this);
			objectManager.assigned(t4_2, PivotPackage.Literals.NAMED_ELEMENT__NAME, STR_this, false);
			t4_3.setIsTrace(ValueUtil.TRUE_VALUE);
			t4_3.setName(STR_middle);
			final /*@Thrown*/ @Nullable Boolean mmapModule__qvtr__rest__ = ValueUtil.TRUE_VALUE;
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
	 * observe ocl::TypedElement::isRequired var isRequired : Boolean[1] := ownedContext?.isRequired;
	 * observe ocl::TypedElement::type var type : Type[?] := ownedContext?.type;
	 * var propertyName : String[1] := atlExpression.name;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlSource.DmapOclExpression;
	 * var elements : OrderedSet(ATL::ModuleElement) := atlModule.elements;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var collect : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(i | i.definition)
	 *   ;
	 * var collect1 : Sequence(OCL::OclFeature) := collect->collect(i | i.feature)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Attribute) := collect1->selectByKind(OCL::Attribute)
	 *   ;
	 * var atlAttributes : Sequence(OCL::Attribute) := selectByKind1->select(i | i.name = propertyName)
	 *   ;
	 * var notEmpty : Boolean[1] := atlAttributes->notEmpty()
	 *   ;
	 * var _'if' : ATL::Helper[?] := if notEmpty
	 *   then
	 *     if atlAttributes->any(i | true).definition = null
	 *     then null
	 *     else atlAttributes->any(i | true).definition.Helper
	 *     endif
	 *   else null
	 *   endif;
	 * var when_mapHelper_Attribute : trace_ATL2QVTr::DmapHelper[1] := _'if'?.DmapHelper;
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
		protected final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_31;

		public MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__ini(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_31 = (@NonNull TmapNavigationOrAttributeCallExp_Helper)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_31.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Helper domapNavigationOrAttributeCallExp_Helper = dispatcher_0.getDomapNavigationOrAttributeCallExp_Helper();
			final /*@NonInvalid*/ boolean eq = trace_31.equals(domapNavigationOrAttributeCallExp_Helper);
			/*@Thrown*/ @Nullable Boolean IF_eq;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD3atlExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof NavigationOrAttributeCallExp;
				/*@Thrown*/ @Nullable Boolean IF_symbol_0;
				if (symbol_0) {
					final /*@NonInvalid*/ @NonNull NavigationOrAttributeCallExp CAST_temp1_atlExpression = (NavigationOrAttributeCallExp)temp1_atlExpression;
					final /*@NonInvalid*/ @NonNull Module getModule = ((FUN_getModule)FTOR_getModule.getUniqueComputation(ATL2QVTr.this, CAST_temp1_atlExpression)).instance;
					final /*@NonInvalid*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t3atlModule.get(getModule);
					final /*@NonInvalid*/ boolean symbol_1 = TmapModule != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
					if (symbol_1) {
						if (TmapModule == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean s0global = TmapModule.getS0global();
						if (s0global == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean IF_s0global;
						if (s0global) {
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull RelationalTransformation t4qvtrTransformation = TmapModule.getT4qvtrTransformation();
							final /*@Thrown*/ @Nullable Parameter ownedContext = t4qvtrTransformation.getOwnedContext();
							/*@Caught*/ @Nullable Object CAUGHT_ownedContext;
							try {
								CAUGHT_ownedContext = ownedContext;
							}
							catch (Exception e) {
								CAUGHT_ownedContext = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @NonNull Object name_2 = CAUGHT_ownedContext == null;
							/*@Thrown*/ @Nullable String safe_name_source;
							if (name_2 == Boolean.TRUE) {
								safe_name_source = null;
							}
							else {
								assert ownedContext != null;
								objectManager.getting(ownedContext, PivotPackage.Literals.NAMED_ELEMENT__NAME, false);
								final /*@Thrown*/ @Nullable String name_3 = ownedContext.getName();
								safe_name_source = name_3;
							}
							/*@Caught*/ @Nullable Object CAUGHT_ownedContext_0;
							try {
								CAUGHT_ownedContext_0 = ownedContext;
							}
							catch (Exception e) {
								CAUGHT_ownedContext_0 = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @NonNull Object isRequired = CAUGHT_ownedContext_0 == null;
							/*@Thrown*/ @Nullable Boolean safe_isRequired_source;
							if (isRequired == Boolean.TRUE) {
								safe_isRequired_source = null;
							}
							else {
								assert ownedContext != null;
								objectManager.getting(ownedContext, PivotPackage.Literals.TYPED_ELEMENT__IS_REQUIRED, false);
								final /*@Thrown*/ boolean isRequired_0 = ownedContext.isIsRequired();
								safe_isRequired_source = isRequired_0;
							}
							final /*@Thrown*/ boolean symbol_2 = safe_isRequired_source != null;
							/*@Thrown*/ @Nullable Boolean raw_isRequired;
							if (symbol_2) {
								if (safe_isRequired_source == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								/*@Caught*/ @Nullable Object CAUGHT_ownedContext_1;
								try {
									CAUGHT_ownedContext_1 = ownedContext;
								}
								catch (Exception e) {
									CAUGHT_ownedContext_1 = ValueUtil.createInvalidValue(e);
								}
								final /*@NonInvalid*/ @NonNull Object type_2 = CAUGHT_ownedContext_1 == null;
								/*@Thrown*/ @Nullable Type safe_type_source;
								if (type_2 == Boolean.TRUE) {
									safe_type_source = null;
								}
								else {
									assert ownedContext != null;
									objectManager.getting(ownedContext, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
									final /*@Thrown*/ @Nullable Type type_3 = ownedContext.getType();
									safe_type_source = type_3;
								}
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull String name_4 = CAST_temp1_atlExpression.getName();
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull OclExpression source = CAST_temp1_atlExpression.getSource();
								final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(source);
								final /*@NonInvalid*/ boolean symbol_3 = DmapOclExpression != null;
								/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
								if (symbol_3) {
									if (DmapOclExpression == null) {
										throw new InvalidEvaluationException("Null where non-null value required");
									}
									@SuppressWarnings("null")
									final /*@NonInvalid*/ @NonNull List<ModuleElement> elements = getModule.getElements();
									final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ATL_c_c_Helper_0 = idResolver.getClass(CLSSid_Helper, null);
									final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_elements = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleElement, elements);
									final /*@NonInvalid*/ @NonNull OrderedSetValue selectByKind = (@Nullable OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_elements, TYP_ATL_c_c_Helper_0);
									/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeatureDefinition);
									@NonNull Iterator<Object> ITERATOR_i = selectByKind.iterator();
									/*@NonInvalid*/ @NonNull SequenceValue collect;
									while (true) {
										if (!ITERATOR_i.hasNext()) {
											collect = accumulator;
											break;
										}
										@SuppressWarnings("null")
										/*@NonInvalid*/ @NonNull Helper i = (@NonNull Helper)ITERATOR_i.next();
										/**
										 * i.definition
										 */
										@SuppressWarnings("null")
										final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = i.getDefinition();
										//
										accumulator.add(definition);
									}
									/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeature);
									@NonNull Iterator<Object> ITERATOR_i_0 = collect.iterator();
									/*@NonInvalid*/ @NonNull SequenceValue collect_0;
									while (true) {
										if (!ITERATOR_i_0.hasNext()) {
											collect_0 = accumulator_0;
											break;
										}
										@SuppressWarnings("null")
										/*@NonInvalid*/ @NonNull OclFeatureDefinition i_0 = (@NonNull OclFeatureDefinition)ITERATOR_i_0.next();
										/**
										 * i.feature
										 */
										@SuppressWarnings("null")
										final /*@NonInvalid*/ @NonNull OclFeature feature = i_0.getFeature();
										//
										accumulator_0.add(feature);
									}
									final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_Attribute_0 = idResolver.getClass(CLSSid_Attribute, null);
									final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (@Nullable SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_0, TYP_OCL_c_c_Attribute_0);
									/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Attribute);
									@NonNull Iterator<Object> ITERATOR_i_1 = selectByKind_0.iterator();
									/*@NonInvalid*/ @NonNull SequenceValue select;
									while (true) {
										if (!ITERATOR_i_1.hasNext()) {
											select = accumulator_1;
											break;
										}
										@SuppressWarnings("null")
										/*@NonInvalid*/ @NonNull Attribute i_1 = (@NonNull Attribute)ITERATOR_i_1.next();
										/**
										 * i.name = propertyName
										 */
										@SuppressWarnings("null")
										final /*@NonInvalid*/ @NonNull String name_5 = i_1.getName();
										final /*@NonInvalid*/ boolean eq_0 = name_5.equals(name_4);
										//
										if (eq_0) {
											accumulator_1.add(i_1);
										}
									}
									final /*@NonInvalid*/ boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(select).booleanValue();
									/*@Thrown*/ @Nullable Helper IF_notEmpty;
									if (notEmpty) {
										@NonNull Iterator<Object> ITERATOR_i_2 = select.iterator();
										/*@NonInvalid*/ @NonNull Attribute any;
										while (true) {
											if (!ITERATOR_i_2.hasNext()) {
												throw new InvalidValueException("Nothing to return for ''any''");
											}
											@SuppressWarnings("null")
											/*@NonInvalid*/ @NonNull Attribute i_2 = (@NonNull Attribute)ITERATOR_i_2.next();
											/**
											 * true
											 */
											//
											if (ValueUtil.TRUE_VALUE) {			// Carry on till something found
												any = i_2;
												break;
											}
										}
										final /*@NonInvalid*/ @Nullable OclFeatureDefinition definition_0 = any.getDefinition();
										final /*@NonInvalid*/ boolean eq_1 = definition_0 == null;
										/*@Thrown*/ @Nullable Helper IF_eq_1;
										if (eq_1) {
											IF_eq_1 = null;
										}
										else {
											final /*@NonInvalid*/ @NonNull UnboxedCompositionProperty IMPPROPid_definition = new UnboxedCompositionProperty(PROPid_definition);
											if (definition_0 == null) {
												throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/gmt/2005/OCL\'::OclFeatureDefinition::Helper\'");
											}
											final /*@Thrown*/ @Nullable Helper Helper = (@Nullable Helper)IMPPROPid_definition.evaluate(executor, CLSSid_Helper, definition_0);
											IF_eq_1 = Helper;
										}
										IF_notEmpty = IF_eq_1;
									}
									else {
										IF_notEmpty = null;
									}
									/*@Caught*/ @Nullable Object CAUGHT_IF_notEmpty;
									try {
										CAUGHT_IF_notEmpty = IF_notEmpty;
									}
									catch (Exception e) {
										CAUGHT_IF_notEmpty = ValueUtil.createInvalidValue(e);
									}
									final /*@NonInvalid*/ @NonNull Object DmapHelper = CAUGHT_IF_notEmpty == null;
									/*@Thrown*/ @Nullable DmapHelper safe_d3atlHelper_source;
									if (DmapHelper == Boolean.TRUE) {
										safe_d3atlHelper_source = null;
									}
									else {
										assert IF_notEmpty != null;
										final /*@Thrown*/ @Nullable DmapHelper DmapHelper_0 = OPPOSITE_OF_DmapHelper_d3atlHelper.get(IF_notEmpty);
										safe_d3atlHelper_source = DmapHelper_0;
									}
									final /*@Thrown*/ boolean symbol_4 = safe_d3atlHelper_source != null;
									/*@Thrown*/ @Nullable Boolean raw_when_mapHelper_Attribute;
									if (symbol_4) {
										if (safe_d3atlHelper_source == null) {
											throw new InvalidEvaluationException("Null where non-null value required");
										}
										// mapping statements
										trace_31.setT1propertyName(name_4);
										objectManager.assigned(trace_31, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T1PROPERTY_NAME, name_4, false);
										final /*@NonInvalid*/ @NonNull List<Attribute> ECORE_select = idResolver.ecoreValueOfAll(Attribute.class, select);
										trace_31.getT3atlAttributes().addAll(ECORE_select);
										dispatcher_0.setResult(trace_31);
										objectManager.assigned(dispatcher_0, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__RESULT, trace_31, false);
										trace_31.setT3atlModule(getModule);
										trace_31.setT3atlSource(source);
										if (ownedContext == null) {
											throw new InvalidEvaluationException("Null value for trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper::t4qvtrThisVariable : VariableDeclaration[1] assignment");
										}
										trace_31.setT4qvtrThisVariable(ownedContext);
										objectManager.assigned(trace_31, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T4QVTR_THIS_VARIABLE, ownedContext, false);
										trace_31.setT4qvtrTransformation(t4qvtrTransformation);
										trace_31.setWmapHelper(safe_d3atlHelper_source);
										objectManager.assigned(trace_31, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__WMAP_HELPER, safe_d3atlHelper_source, false);
										trace_31.setWmapModule(TmapModule);
										trace_31.setWmapOclExpression(DmapOclExpression);
										objectManager.assigned(trace_31, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION, DmapOclExpression, false);
										final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Helper__qvtr__ini = ValueUtil.TRUE_VALUE;
										raw_when_mapHelper_Attribute = mmapNavigationOrAttributeCallExp__Helper__qvtr__ini;
									}
									else {
										raw_when_mapHelper_Attribute = ValueUtil.FALSE_VALUE;
									}
									raw_when_mapOclExpression = raw_when_mapHelper_Attribute;
								}
								else {
									raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
								}
								raw_isRequired = raw_when_mapOclExpression;
							}
							else {
								raw_isRequired = ValueUtil.FALSE_VALUE;
							}
							IF_s0global = raw_isRequired;
						}
						else {
							IF_s0global = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapModule = IF_s0global;
					}
					else {
						raw_when_mapModule = ValueUtil.FALSE_VALUE;
					}
					IF_symbol_0 = raw_when_mapModule;
				}
				else {
					IF_symbol_0 = ValueUtil.FALSE_VALUE;
				}
				IF_eq = IF_symbol_0;
			}
			else {
				IF_eq = ValueUtil.FALSE_VALUE;
			}
			trace_31.setS0local(IF_eq);
			objectManager.assigned(trace_31, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__S0LOCAL, IF_eq, false);
			return IF_eq;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_31, thoseValues[0]);
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
	 * observe ocl::TypedElement::isRequired var isRequired : Boolean[1] := ownedContext.isRequired;
	 * observe ocl::TypedElement::type var type : Type[?] := ownedContext.type;
	 * var when_mapHelper_Attribute : trace_ATL2QVTr::DmapHelper[1] := trace.wmapHelper;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * speculate when_mapHelper_Attribute.s0global, when_mapOclExpression.s0global;
	 * var propertyName : String[1] := trace.t1propertyName;
	 * new:qvtr qvtrExpression : OperationCallExp[1];
	 * new:qvtr qvtrSource : VariableExp[1];
	 * set qvtrExpression.name := propertyName;
	 * set qvtrSource.isRequired := isRequired;
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
		protected final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_32;

		public MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__loo(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_32 = (@NonNull TmapNavigationOrAttributeCallExp_Helper)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_32.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Helper domapNavigationOrAttributeCallExp_Helper = dispatcher_0.getDomapNavigationOrAttributeCallExp_Helper();
			final /*@NonInvalid*/ boolean eq = trace_32.equals(domapNavigationOrAttributeCallExp_Helper);
			/*@Thrown*/ @Nullable Boolean IF_eq;
			if (eq) {
				objectManager.getting(trace_32, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__S0LOCAL, false);
				final /*@NonInvalid*/ @Nullable Boolean s0local = trace_32.getS0local();
				if (s0local == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0local;
				if (s0local) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull VariableDeclaration temp1_ownedContext = trace_32.getT4qvtrThisVariable();
					final /*@NonInvalid*/ boolean symbol_0 = temp1_ownedContext instanceof Parameter;
					/*@Thrown*/ @Nullable Boolean IF_symbol_0;
					if (symbol_0) {
						final /*@NonInvalid*/ @NonNull Parameter CAST_temp1_ownedContext = (Parameter)temp1_ownedContext;
						objectManager.getting(CAST_temp1_ownedContext, PivotPackage.Literals.NAMED_ELEMENT__NAME, false);
						final /*@NonInvalid*/ @Nullable String name_2 = CAST_temp1_ownedContext.getName();
						objectManager.getting(CAST_temp1_ownedContext, PivotPackage.Literals.TYPED_ELEMENT__IS_REQUIRED, false);
						final /*@NonInvalid*/ boolean isRequired = CAST_temp1_ownedContext.isIsRequired();
						objectManager.getting(CAST_temp1_ownedContext, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@NonInvalid*/ @Nullable Type type_2 = CAST_temp1_ownedContext.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull DmapHelper wmapHelper = trace_32.getWmapHelper();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace_32.getWmapOclExpression();
						SlotState.@NonNull Speculating outputSpeculatingSlotState = objectManager.getSpeculatingSlotState(trace_32, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL);
						Boolean outputSpeculatingSlotStatus = outputSpeculatingSlotState.getSpeculationStatus();
						if (outputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
							if (outputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
								trace_32.setS0global(ValueUtil.FALSE_VALUE);
								return ValueUtil.FALSE_VALUE;
							}
							SlotState.@NonNull Speculating inputSpeculatingSlotState;
							Boolean inputSpeculatingSlotStatus;
							boolean needsSpeculation = false;
							if (wmapHelper == null) {
								throw new InvalidEvaluationException("Null when_mapHelper_Attribute speculation source");
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
								throw new InvalidEvaluationException("Null when_mapOclExpression speculation source");
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
						boolean symbol_13 = true;
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t1propertyName = trace_32.getT1propertyName();
						// creations
						final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
						models[3/*qvtr*/].add(qvtrExpression, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
						}
						final org.eclipse.ocl.pivot.@NonNull VariableExp qvtrSource = PivotFactory.eINSTANCE.createVariableExp();
						models[3/*qvtr*/].add(qvtrSource, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrSource));
						}
						// mapping statements
						qvtrExpression.setName(t1propertyName);
						qvtrSource.setIsRequired(isRequired);
						qvtrSource.setName(name_2);
						dispatcher_0.setS0global((Boolean)ValueUtil.TRUE_VALUE);
						objectManager.assigned(dispatcher_0, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
						dispatcher_0.setD4qvtrExpression(qvtrExpression);
						trace_32.setT4qvtrSource(qvtrSource);
						qvtrExpression.setOwnedSource(qvtrSource);
						qvtrSource.setReferredVariable(CAST_temp1_ownedContext);
						qvtrSource.setType(type_2);
						objectManager.assigned(qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_2, false);
						final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Helper__qvtr__loo = ValueUtil.TRUE_VALUE;
						IF_symbol_0 = symbol_13;
					}
					else {
						IF_symbol_0 = ValueUtil.FALSE_VALUE;
					}
					IF_s0local = IF_symbol_0;
				}
				else {
					IF_s0local = ValueUtil.FALSE_VALUE;
				}
				IF_eq = IF_s0local;
			}
			else {
				IF_eq = ValueUtil.FALSE_VALUE;
			}
			trace_32.setS0global(IF_eq);
			objectManager.assigned(trace_32, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_eq, false);
			return IF_eq;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_32, thoseValues[0]);
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
		protected final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace_33;

		public MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__l(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_33 = (@NonNull TmapNavigationOrAttributeCallExp_Property)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_33.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Property domapNavigationOrAttributeCallExp_Property = dispatcher_0.getDomapNavigationOrAttributeCallExp_Property();
			final /*@NonInvalid*/ boolean eq = trace_33.equals(domapNavigationOrAttributeCallExp_Property);
			/*@Thrown*/ @Nullable Boolean IF_eq;
			if (eq) {
				final /*@NonInvalid*/ @Nullable Boolean s0local = trace_33.getS0local();
				if (s0local == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0local;
				if (s0local) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace_33.getWmapOclExpression();
					SlotState.@NonNull Speculating outputSpeculatingSlotState = objectManager.getSpeculatingSlotState(trace_33, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL);
					Boolean outputSpeculatingSlotStatus = outputSpeculatingSlotState.getSpeculationStatus();
					if (outputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
						if (outputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
							trace_33.setS0global(ValueUtil.FALSE_VALUE);
							return ValueUtil.FALSE_VALUE;
						}
						SlotState.@NonNull Speculating inputSpeculatingSlotState;
						Boolean inputSpeculatingSlotStatus;
						boolean needsSpeculation = false;
						if (wmapOclExpression == null) {
							throw new InvalidEvaluationException("Null when_mapOclExpression speculation source");
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
					boolean symbol_5 = true;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String t1propertyName = trace_33.getT1propertyName();
					// creations
					final @NonNull PropertyCallExp qvtrExpression = PivotFactory.eINSTANCE.createPropertyCallExp();
					models[3/*qvtr*/].add(qvtrExpression, false);
					if (debugCreations) {
						AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
					}
					// mapping statements
					qvtrExpression.setName(t1propertyName);
					dispatcher_0.setS0global((Boolean)ValueUtil.TRUE_VALUE);
					objectManager.assigned(dispatcher_0, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
					dispatcher_0.setD4qvtrExpression(qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Property__qvtr__l = ValueUtil.TRUE_VALUE;
					IF_s0local = symbol_5;
				}
				else {
					IF_s0local = ValueUtil.FALSE_VALUE;
				}
				IF_eq = IF_s0local;
			}
			else {
				IF_eq = ValueUtil.FALSE_VALUE;
			}
			trace_33.setS0global(IF_eq);
			objectManager.assigned(trace_33, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_eq, false);
			return IF_eq;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_33, thoseValues[0]);
		}
	}

	/**
	 *
	 * map:5 mmapOclExpression__verdict__qvtr in ATL2QVTr {
	 * guard:middle mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1];
	 * var mapIntegerExp : trace_ATL2QVTr::TmapIntegerExp[1] := mapOclExpression.domapIntegerExp;
	 * check mapIntegerExp.s0global = false;
	 * var mapNavigationOrAttributeCallExp_Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1] := mapOclExpression.domapNavigationOrAttributeCallExp_Property;
	 * observe trace_ATL2QVTr::ImapOclExpression::s0global check mapNavigationOrAttributeCallExp_Property.s0global = false;
	 * var mapOperationCallExp_Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1] := mapOclExpression.domapOperationCallExp_Operation;
	 * observe trace_ATL2QVTr::ImapOclExpression::s0global check mapOperationCallExp_Operation.s0global = false;
	 * var mapOclType : trace_ATL2QVTr::TmapOclType[1] := mapOclExpression.domapOclType;
	 * check mapOclType.s0global = false;
	 * var mapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1] := mapOclExpression.domapOperatorCallExp;
	 * observe trace_ATL2QVTr::ImapOclExpression::s0global check mapOperatorCallExp.s0global = false;
	 * var mapOperationCallExp_Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1] := mapOclExpression.domapOperationCallExp_Helper;
	 * observe trace_ATL2QVTr::ImapOclExpression::s0global check mapOperationCallExp_Helper.s0global = false;
	 * var mapBooleanExp : trace_ATL2QVTr::TmapBooleanExp[1] := mapOclExpression.domapBooleanExp;
	 * check mapBooleanExp.s0global = false;
	 * var mapNullLiteralExp : trace_ATL2QVTr::TmapNullLiteralExp[1] := mapOclExpression.domapNullLiteralExp;
	 * check mapNullLiteralExp.s0global = false;
	 * var mapStringExp : trace_ATL2QVTr::TmapStringExp[1] := mapOclExpression.domapStringExp;
	 * check mapStringExp.s0global = false;
	 * var mapIfExp : trace_ATL2QVTr::TmapIfExp[1] := mapOclExpression.domapIfExp;
	 * observe trace_ATL2QVTr::ImapOclExpression::s0global check mapIfExp.s0global = false;
	 * var mapNavigationOrAttributeCallExp_Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1] := mapOclExpression.domapNavigationOrAttributeCallExp_Helper;
	 * observe trace_ATL2QVTr::ImapOclExpression::s0global check mapNavigationOrAttributeCallExp_Helper.s0global = false;
	 * var mapVariableExp : trace_ATL2QVTr::TmapVariableExp[1] := mapOclExpression.domapVariableExp;
	 * check mapVariableExp.s0global = false;
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
			final /*@NonInvalid*/ @Nullable TmapIntegerExp domapIntegerExp = mapOclExpression.getDomapIntegerExp();
			final /*@NonInvalid*/ boolean symbol_0 = domapIntegerExp != null;
			/*@Thrown*/ @Nullable Boolean raw_mapIntegerExp;
			if (symbol_0) {
				if (domapIntegerExp == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@Thrown*/ @Nullable Boolean s0global = domapIntegerExp.getS0global();
				final /*@Thrown*/ boolean eq = s0global == Boolean.FALSE;
				/*@Thrown*/ @Nullable Boolean IF_eq;
				if (eq) {
					final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Property domapNavigationOrAttributeCallExp_Property = mapOclExpression.getDomapNavigationOrAttributeCallExp_Property();
					final /*@NonInvalid*/ boolean symbol_1 = domapNavigationOrAttributeCallExp_Property != null;
					/*@Thrown*/ @Nullable Boolean raw_mapNavigationOrAttributeCallExp_Property;
					if (symbol_1) {
						if (domapNavigationOrAttributeCallExp_Property == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						objectManager.getting(domapNavigationOrAttributeCallExp_Property, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, false);
						final /*@Thrown*/ @Nullable Boolean s0global_0 = domapNavigationOrAttributeCallExp_Property.getS0global();
						final /*@Thrown*/ boolean eq_0 = s0global_0 == Boolean.FALSE;
						/*@Thrown*/ @Nullable Boolean IF_eq_0;
						if (eq_0) {
							final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Operation domapOperationCallExp_Operation = mapOclExpression.getDomapOperationCallExp_Operation();
							final /*@NonInvalid*/ boolean symbol_2 = domapOperationCallExp_Operation != null;
							/*@Thrown*/ @Nullable Boolean raw_mapOperationCallExp_Operation;
							if (symbol_2) {
								if (domapOperationCallExp_Operation == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								objectManager.getting(domapOperationCallExp_Operation, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, false);
								final /*@Thrown*/ @Nullable Boolean s0global_1 = domapOperationCallExp_Operation.getS0global();
								final /*@Thrown*/ boolean eq_1 = s0global_1 == Boolean.FALSE;
								/*@Thrown*/ @Nullable Boolean IF_eq_1;
								if (eq_1) {
									final /*@NonInvalid*/ @Nullable TmapOclType domapOclType = mapOclExpression.getDomapOclType();
									final /*@NonInvalid*/ boolean symbol_3 = domapOclType != null;
									/*@Thrown*/ @Nullable Boolean raw_mapOclType;
									if (symbol_3) {
										if (domapOclType == null) {
											throw new InvalidEvaluationException("Null where non-null value required");
										}
										final /*@Thrown*/ @Nullable Boolean s0global_2 = domapOclType.getS0global();
										final /*@Thrown*/ boolean eq_2 = s0global_2 == Boolean.FALSE;
										/*@Thrown*/ @Nullable Boolean IF_eq_2;
										if (eq_2) {
											final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = mapOclExpression.getDomapOperatorCallExp();
											final /*@NonInvalid*/ boolean symbol_4 = domapOperatorCallExp != null;
											/*@Thrown*/ @Nullable Boolean raw_mapOperatorCallExp;
											if (symbol_4) {
												if (domapOperatorCallExp == null) {
													throw new InvalidEvaluationException("Null where non-null value required");
												}
												objectManager.getting(domapOperatorCallExp, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, false);
												final /*@Thrown*/ @Nullable Boolean s0global_3 = domapOperatorCallExp.getS0global();
												final /*@Thrown*/ boolean eq_3 = s0global_3 == Boolean.FALSE;
												/*@Thrown*/ @Nullable Boolean IF_eq_3;
												if (eq_3) {
													final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Helper domapOperationCallExp_Helper = mapOclExpression.getDomapOperationCallExp_Helper();
													final /*@NonInvalid*/ boolean symbol_5 = domapOperationCallExp_Helper != null;
													/*@Thrown*/ @Nullable Boolean raw_mapOperationCallExp_Helper;
													if (symbol_5) {
														if (domapOperationCallExp_Helper == null) {
															throw new InvalidEvaluationException("Null where non-null value required");
														}
														objectManager.getting(domapOperationCallExp_Helper, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, false);
														final /*@Thrown*/ @Nullable Boolean s0global_4 = domapOperationCallExp_Helper.getS0global();
														final /*@Thrown*/ boolean eq_4 = s0global_4 == Boolean.FALSE;
														/*@Thrown*/ @Nullable Boolean IF_eq_4;
														if (eq_4) {
															final /*@NonInvalid*/ @Nullable TmapBooleanExp domapBooleanExp = mapOclExpression.getDomapBooleanExp();
															final /*@NonInvalid*/ boolean symbol_6 = domapBooleanExp != null;
															/*@Thrown*/ @Nullable Boolean raw_mapBooleanExp;
															if (symbol_6) {
																if (domapBooleanExp == null) {
																	throw new InvalidEvaluationException("Null where non-null value required");
																}
																final /*@Thrown*/ @Nullable Boolean s0global_5 = domapBooleanExp.getS0global();
																final /*@Thrown*/ boolean eq_5 = s0global_5 == Boolean.FALSE;
																/*@Thrown*/ @Nullable Boolean IF_eq_5;
																if (eq_5) {
																	final /*@NonInvalid*/ @Nullable TmapNullLiteralExp domapNullLiteralExp = mapOclExpression.getDomapNullLiteralExp();
																	final /*@NonInvalid*/ boolean symbol_7 = domapNullLiteralExp != null;
																	/*@Thrown*/ @Nullable Boolean raw_mapNullLiteralExp;
																	if (symbol_7) {
																		if (domapNullLiteralExp == null) {
																			throw new InvalidEvaluationException("Null where non-null value required");
																		}
																		final /*@Thrown*/ @Nullable Boolean s0global_6 = ((ImapOclExpression)domapNullLiteralExp).getS0global();
																		final /*@Thrown*/ boolean eq_6 = s0global_6 == Boolean.FALSE;
																		/*@Thrown*/ @Nullable Boolean IF_eq_6;
																		if (eq_6) {
																			final /*@NonInvalid*/ @Nullable TmapStringExp domapStringExp = mapOclExpression.getDomapStringExp();
																			final /*@NonInvalid*/ boolean symbol_8 = domapStringExp != null;
																			/*@Thrown*/ @Nullable Boolean raw_mapStringExp;
																			if (symbol_8) {
																				if (domapStringExp == null) {
																					throw new InvalidEvaluationException("Null where non-null value required");
																				}
																				final /*@Thrown*/ @Nullable Boolean s0global_7 = domapStringExp.getS0global();
																				final /*@Thrown*/ boolean eq_7 = s0global_7 == Boolean.FALSE;
																				/*@Thrown*/ @Nullable Boolean IF_eq_7;
																				if (eq_7) {
																					final /*@NonInvalid*/ @Nullable TmapIfExp domapIfExp = mapOclExpression.getDomapIfExp();
																					final /*@NonInvalid*/ boolean symbol_9 = domapIfExp != null;
																					/*@Thrown*/ @Nullable Boolean raw_mapIfExp;
																					if (symbol_9) {
																						if (domapIfExp == null) {
																							throw new InvalidEvaluationException("Null where non-null value required");
																						}
																						objectManager.getting(domapIfExp, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, false);
																						final /*@Thrown*/ @Nullable Boolean s0global_8 = domapIfExp.getS0global();
																						final /*@Thrown*/ boolean eq_8 = s0global_8 == Boolean.FALSE;
																						/*@Thrown*/ @Nullable Boolean IF_eq_8;
																						if (eq_8) {
																							final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Helper domapNavigationOrAttributeCallExp_Helper = mapOclExpression.getDomapNavigationOrAttributeCallExp_Helper();
																							final /*@NonInvalid*/ boolean symbol_10 = domapNavigationOrAttributeCallExp_Helper != null;
																							/*@Thrown*/ @Nullable Boolean raw_mapNavigationOrAttributeCallExp_Helper;
																							if (symbol_10) {
																								if (domapNavigationOrAttributeCallExp_Helper == null) {
																									throw new InvalidEvaluationException("Null where non-null value required");
																								}
																								objectManager.getting(domapNavigationOrAttributeCallExp_Helper, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, false);
																								final /*@Thrown*/ @Nullable Boolean s0global_9 = domapNavigationOrAttributeCallExp_Helper.getS0global();
																								final /*@Thrown*/ boolean eq_9 = s0global_9 == Boolean.FALSE;
																								/*@Thrown*/ @Nullable Boolean IF_eq_9;
																								if (eq_9) {
																									final /*@NonInvalid*/ @Nullable TmapVariableExp domapVariableExp = mapOclExpression.getDomapVariableExp();
																									final /*@NonInvalid*/ boolean symbol_11 = domapVariableExp != null;
																									/*@Thrown*/ @Nullable Boolean raw_mapVariableExp;
																									if (symbol_11) {
																										if (domapVariableExp == null) {
																											throw new InvalidEvaluationException("Null where non-null value required");
																										}
																										final /*@Thrown*/ @Nullable Boolean s0global_10 = domapVariableExp.getS0global();
																										final /*@Thrown*/ boolean eq_10 = s0global_10 == Boolean.FALSE;
																										/*@Thrown*/ @Nullable Boolean IF_eq_10;
																										if (eq_10) {
																											// mapping statements
																											mapOclExpression.setS0global((Boolean)ValueUtil.FALSE_VALUE);
																											objectManager.assigned(mapOclExpression, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.FALSE_VALUE, false);
																											final /*@Thrown*/ @Nullable Boolean mmapOclExpression__verdict__qvtr = ValueUtil.TRUE_VALUE;
																											IF_eq_10 = mmapOclExpression__verdict__qvtr;
																										}
																										else {
																											IF_eq_10 = ValueUtil.FALSE_VALUE;
																										}
																										raw_mapVariableExp = IF_eq_10;
																									}
																									else {
																										raw_mapVariableExp = ValueUtil.FALSE_VALUE;
																									}
																									IF_eq_9 = raw_mapVariableExp;
																								}
																								else {
																									IF_eq_9 = ValueUtil.FALSE_VALUE;
																								}
																								raw_mapNavigationOrAttributeCallExp_Helper = IF_eq_9;
																							}
																							else {
																								raw_mapNavigationOrAttributeCallExp_Helper = ValueUtil.FALSE_VALUE;
																							}
																							IF_eq_8 = raw_mapNavigationOrAttributeCallExp_Helper;
																						}
																						else {
																							IF_eq_8 = ValueUtil.FALSE_VALUE;
																						}
																						raw_mapIfExp = IF_eq_8;
																					}
																					else {
																						raw_mapIfExp = ValueUtil.FALSE_VALUE;
																					}
																					IF_eq_7 = raw_mapIfExp;
																				}
																				else {
																					IF_eq_7 = ValueUtil.FALSE_VALUE;
																				}
																				raw_mapStringExp = IF_eq_7;
																			}
																			else {
																				raw_mapStringExp = ValueUtil.FALSE_VALUE;
																			}
																			IF_eq_6 = raw_mapStringExp;
																		}
																		else {
																			IF_eq_6 = ValueUtil.FALSE_VALUE;
																		}
																		raw_mapNullLiteralExp = IF_eq_6;
																	}
																	else {
																		raw_mapNullLiteralExp = ValueUtil.FALSE_VALUE;
																	}
																	IF_eq_5 = raw_mapNullLiteralExp;
																}
																else {
																	IF_eq_5 = ValueUtil.FALSE_VALUE;
																}
																raw_mapBooleanExp = IF_eq_5;
															}
															else {
																raw_mapBooleanExp = ValueUtil.FALSE_VALUE;
															}
															IF_eq_4 = raw_mapBooleanExp;
														}
														else {
															IF_eq_4 = ValueUtil.FALSE_VALUE;
														}
														raw_mapOperationCallExp_Helper = IF_eq_4;
													}
													else {
														raw_mapOperationCallExp_Helper = ValueUtil.FALSE_VALUE;
													}
													IF_eq_3 = raw_mapOperationCallExp_Helper;
												}
												else {
													IF_eq_3 = ValueUtil.FALSE_VALUE;
												}
												raw_mapOperatorCallExp = IF_eq_3;
											}
											else {
												raw_mapOperatorCallExp = ValueUtil.FALSE_VALUE;
											}
											IF_eq_2 = raw_mapOperatorCallExp;
										}
										else {
											IF_eq_2 = ValueUtil.FALSE_VALUE;
										}
										raw_mapOclType = IF_eq_2;
									}
									else {
										raw_mapOclType = ValueUtil.FALSE_VALUE;
									}
									IF_eq_1 = raw_mapOclType;
								}
								else {
									IF_eq_1 = ValueUtil.FALSE_VALUE;
								}
								raw_mapOperationCallExp_Operation = IF_eq_1;
							}
							else {
								raw_mapOperationCallExp_Operation = ValueUtil.FALSE_VALUE;
							}
							IF_eq_0 = raw_mapOperationCallExp_Operation;
						}
						else {
							IF_eq_0 = ValueUtil.FALSE_VALUE;
						}
						raw_mapNavigationOrAttributeCallExp_Property = IF_eq_0;
					}
					else {
						raw_mapNavigationOrAttributeCallExp_Property = ValueUtil.FALSE_VALUE;
					}
					IF_eq = raw_mapNavigationOrAttributeCallExp_Property;
				}
				else {
					IF_eq = ValueUtil.FALSE_VALUE;
				}
				raw_mapIntegerExp = IF_eq;
			}
			else {
				raw_mapIntegerExp = ValueUtil.FALSE_VALUE;
			}
			return raw_mapIntegerExp;
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
	 * observe ocl::TypedElement::isRequired var isRequired : Boolean[1] := ownedContext?.isRequired;
	 * observe ocl::TypedElement::type var type : Type[?] := ownedContext?.type;
	 * var operationName : String[1] := atlExpression.operationName;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlSource.DmapOclExpression;
	 * var elements : OrderedSet(ATL::ModuleElement) := atlModule.elements;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var collect : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(i | i.definition)
	 *   ;
	 * var collect1 : Sequence(OCL::OclFeature) := collect->collect(i | i.feature)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Operation) := collect1->selectByKind(OCL::Operation)
	 *   ;
	 * var atlOperations : Sequence(OCL::Operation) := selectByKind1->select(i | i.name = operationName)
	 *   ;
	 * var notEmpty : Boolean[1] := atlOperations->notEmpty()
	 *   ;
	 * var _'if' : ATL::Helper[?] := if notEmpty
	 *   then
	 *     if atlOperations->any(i | true).definition = null
	 *     then null
	 *     else atlOperations->any(i | true).definition.Helper
	 *     endif
	 *   else null
	 *   endif;
	 * var when_mapHelper_Operation : trace_ATL2QVTr::DmapHelper[1] := _'if'?.DmapHelper;
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
		protected final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_34;

		public MAP_mmapOperationCallExp__Helper__qvtr__init__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_34 = (@NonNull TmapOperationCallExp_Helper)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_34.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Helper domapOperationCallExp_Helper = dispatcher_0.getDomapOperationCallExp_Helper();
			final /*@NonInvalid*/ boolean eq = trace_34.equals(domapOperationCallExp_Helper);
			/*@Thrown*/ @Nullable Boolean IF_eq;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD3atlExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof OperationCallExp;
				/*@Thrown*/ @Nullable Boolean IF_symbol_0;
				if (symbol_0) {
					final /*@NonInvalid*/ @NonNull OperationCallExp CAST_temp1_atlExpression = (OperationCallExp)temp1_atlExpression;
					final /*@NonInvalid*/ @NonNull Module getModule = ((FUN_getModule)FTOR_getModule.getUniqueComputation(ATL2QVTr.this, CAST_temp1_atlExpression)).instance;
					final /*@NonInvalid*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t3atlModule.get(getModule);
					final /*@NonInvalid*/ boolean symbol_1 = TmapModule != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
					if (symbol_1) {
						if (TmapModule == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean s0global = TmapModule.getS0global();
						if (s0global == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean IF_s0global;
						if (s0global) {
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull RelationalTransformation t4qvtrTransformation = TmapModule.getT4qvtrTransformation();
							final /*@Thrown*/ @Nullable Parameter ownedContext = t4qvtrTransformation.getOwnedContext();
							/*@Caught*/ @Nullable Object CAUGHT_ownedContext;
							try {
								CAUGHT_ownedContext = ownedContext;
							}
							catch (Exception e) {
								CAUGHT_ownedContext = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @NonNull Object name_2 = CAUGHT_ownedContext == null;
							/*@Thrown*/ @Nullable String safe_name_source;
							if (name_2 == Boolean.TRUE) {
								safe_name_source = null;
							}
							else {
								assert ownedContext != null;
								objectManager.getting(ownedContext, PivotPackage.Literals.NAMED_ELEMENT__NAME, false);
								final /*@Thrown*/ @Nullable String name_3 = ownedContext.getName();
								safe_name_source = name_3;
							}
							/*@Caught*/ @Nullable Object CAUGHT_ownedContext_0;
							try {
								CAUGHT_ownedContext_0 = ownedContext;
							}
							catch (Exception e) {
								CAUGHT_ownedContext_0 = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @NonNull Object isRequired = CAUGHT_ownedContext_0 == null;
							/*@Thrown*/ @Nullable Boolean safe_isRequired_source;
							if (isRequired == Boolean.TRUE) {
								safe_isRequired_source = null;
							}
							else {
								assert ownedContext != null;
								objectManager.getting(ownedContext, PivotPackage.Literals.TYPED_ELEMENT__IS_REQUIRED, false);
								final /*@Thrown*/ boolean isRequired_0 = ownedContext.isIsRequired();
								safe_isRequired_source = isRequired_0;
							}
							final /*@Thrown*/ boolean symbol_2 = safe_isRequired_source != null;
							/*@Thrown*/ @Nullable Boolean raw_isRequired;
							if (symbol_2) {
								if (safe_isRequired_source == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								/*@Caught*/ @Nullable Object CAUGHT_ownedContext_1;
								try {
									CAUGHT_ownedContext_1 = ownedContext;
								}
								catch (Exception e) {
									CAUGHT_ownedContext_1 = ValueUtil.createInvalidValue(e);
								}
								final /*@NonInvalid*/ @NonNull Object type_2 = CAUGHT_ownedContext_1 == null;
								/*@Thrown*/ @Nullable Type safe_type_source;
								if (type_2 == Boolean.TRUE) {
									safe_type_source = null;
								}
								else {
									assert ownedContext != null;
									objectManager.getting(ownedContext, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
									final /*@Thrown*/ @Nullable Type type_3 = ownedContext.getType();
									safe_type_source = type_3;
								}
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull String operationName = CAST_temp1_atlExpression.getOperationName();
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull OclExpression source = CAST_temp1_atlExpression.getSource();
								final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(source);
								final /*@NonInvalid*/ boolean symbol_3 = DmapOclExpression != null;
								/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
								if (symbol_3) {
									if (DmapOclExpression == null) {
										throw new InvalidEvaluationException("Null where non-null value required");
									}
									@SuppressWarnings("null")
									final /*@NonInvalid*/ @NonNull List<ModuleElement> elements = getModule.getElements();
									final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ATL_c_c_Helper_0 = idResolver.getClass(CLSSid_Helper, null);
									final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_elements = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleElement, elements);
									final /*@NonInvalid*/ @NonNull OrderedSetValue selectByKind = (@Nullable OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_elements, TYP_ATL_c_c_Helper_0);
									/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeatureDefinition);
									@NonNull Iterator<Object> ITERATOR_i = selectByKind.iterator();
									/*@NonInvalid*/ @NonNull SequenceValue collect;
									while (true) {
										if (!ITERATOR_i.hasNext()) {
											collect = accumulator;
											break;
										}
										@SuppressWarnings("null")
										/*@NonInvalid*/ @NonNull Helper i = (@NonNull Helper)ITERATOR_i.next();
										/**
										 * i.definition
										 */
										@SuppressWarnings("null")
										final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = i.getDefinition();
										//
										accumulator.add(definition);
									}
									/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeature);
									@NonNull Iterator<Object> ITERATOR_i_0 = collect.iterator();
									/*@NonInvalid*/ @NonNull SequenceValue collect_0;
									while (true) {
										if (!ITERATOR_i_0.hasNext()) {
											collect_0 = accumulator_0;
											break;
										}
										@SuppressWarnings("null")
										/*@NonInvalid*/ @NonNull OclFeatureDefinition i_0 = (@NonNull OclFeatureDefinition)ITERATOR_i_0.next();
										/**
										 * i.feature
										 */
										@SuppressWarnings("null")
										final /*@NonInvalid*/ @NonNull OclFeature feature = i_0.getFeature();
										//
										accumulator_0.add(feature);
									}
									final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
									final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (@Nullable SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_0, TYP_OCL_c_c_Operation_0);
									/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
									@NonNull Iterator<Object> ITERATOR_i_1 = selectByKind_0.iterator();
									/*@NonInvalid*/ @NonNull SequenceValue select;
									while (true) {
										if (!ITERATOR_i_1.hasNext()) {
											select = accumulator_1;
											break;
										}
										@SuppressWarnings("null")
										/*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation i_1 = (org.eclipse.m2m.atl.common.OCL.@NonNull Operation)ITERATOR_i_1.next();
										/**
										 * i.name = operationName
										 */
										@SuppressWarnings("null")
										final /*@NonInvalid*/ @NonNull String name_4 = i_1.getName();
										final /*@NonInvalid*/ boolean eq_0 = name_4.equals(operationName);
										//
										if (eq_0) {
											accumulator_1.add(i_1);
										}
									}
									final /*@NonInvalid*/ boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(select).booleanValue();
									/*@Thrown*/ @Nullable Helper IF_notEmpty;
									if (notEmpty) {
										@NonNull Iterator<Object> ITERATOR_i_2 = select.iterator();
										/*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation any;
										while (true) {
											if (!ITERATOR_i_2.hasNext()) {
												throw new InvalidValueException("Nothing to return for ''any''");
											}
											@SuppressWarnings("null")
											/*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation i_2 = (org.eclipse.m2m.atl.common.OCL.@NonNull Operation)ITERATOR_i_2.next();
											/**
											 * true
											 */
											//
											if (ValueUtil.TRUE_VALUE) {			// Carry on till something found
												any = i_2;
												break;
											}
										}
										final /*@NonInvalid*/ @Nullable OclFeatureDefinition definition_0 = any.getDefinition();
										final /*@NonInvalid*/ boolean eq_1 = definition_0 == null;
										/*@Thrown*/ @Nullable Helper IF_eq_1;
										if (eq_1) {
											IF_eq_1 = null;
										}
										else {
											final /*@NonInvalid*/ @NonNull UnboxedCompositionProperty IMPPROPid_definition = new UnboxedCompositionProperty(PROPid_definition);
											if (definition_0 == null) {
												throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/gmt/2005/OCL\'::OclFeatureDefinition::Helper\'");
											}
											final /*@Thrown*/ @Nullable Helper Helper = (@Nullable Helper)IMPPROPid_definition.evaluate(executor, CLSSid_Helper, definition_0);
											IF_eq_1 = Helper;
										}
										IF_notEmpty = IF_eq_1;
									}
									else {
										IF_notEmpty = null;
									}
									/*@Caught*/ @Nullable Object CAUGHT_IF_notEmpty;
									try {
										CAUGHT_IF_notEmpty = IF_notEmpty;
									}
									catch (Exception e) {
										CAUGHT_IF_notEmpty = ValueUtil.createInvalidValue(e);
									}
									final /*@NonInvalid*/ @NonNull Object DmapHelper = CAUGHT_IF_notEmpty == null;
									/*@Thrown*/ @Nullable DmapHelper safe_d3atlHelper_source;
									if (DmapHelper == Boolean.TRUE) {
										safe_d3atlHelper_source = null;
									}
									else {
										assert IF_notEmpty != null;
										final /*@Thrown*/ @Nullable DmapHelper DmapHelper_0 = OPPOSITE_OF_DmapHelper_d3atlHelper.get(IF_notEmpty);
										safe_d3atlHelper_source = DmapHelper_0;
									}
									final /*@Thrown*/ boolean symbol_4 = safe_d3atlHelper_source != null;
									/*@Thrown*/ @Nullable Boolean raw_when_mapHelper_Operation;
									if (symbol_4) {
										if (safe_d3atlHelper_source == null) {
											throw new InvalidEvaluationException("Null where non-null value required");
										}
										// mapping statements
										trace_34.setT1operationName(operationName);
										objectManager.assigned(trace_34, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__T1OPERATION_NAME, operationName, false);
										final /*@NonInvalid*/ @NonNull List<org.eclipse.m2m.atl.common.OCL.Operation> ECORE_select = idResolver.ecoreValueOfAll(org.eclipse.m2m.atl.common.OCL.Operation.class, select);
										trace_34.getT3atlOperations().addAll(ECORE_select);
										dispatcher_0.setResult(trace_34);
										objectManager.assigned(dispatcher_0, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__RESULT, trace_34, false);
										trace_34.setT3atlModule(getModule);
										trace_34.setT3atlSource(source);
										if (ownedContext == null) {
											throw new InvalidEvaluationException("Null value for trace_ATL2QVTr::TmapOperationCallExp_Helper::t4qvtrThisVariable : VariableDeclaration[1] assignment");
										}
										trace_34.setT4qvtrThisVariable(ownedContext);
										objectManager.assigned(trace_34, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__T4QVTR_THIS_VARIABLE, ownedContext, false);
										trace_34.setT4qvtrTransformation(t4qvtrTransformation);
										trace_34.setWmapHelper(safe_d3atlHelper_source);
										objectManager.assigned(trace_34, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_HELPER, safe_d3atlHelper_source, false);
										trace_34.setWmapModule(TmapModule);
										trace_34.setWmapOclExpression(DmapOclExpression);
										objectManager.assigned(trace_34, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION, DmapOclExpression, false);
										final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Helper__qvtr__init__ = ValueUtil.TRUE_VALUE;
										raw_when_mapHelper_Operation = mmapOperationCallExp__Helper__qvtr__init__;
									}
									else {
										raw_when_mapHelper_Operation = ValueUtil.FALSE_VALUE;
									}
									raw_when_mapOclExpression = raw_when_mapHelper_Operation;
								}
								else {
									raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
								}
								raw_isRequired = raw_when_mapOclExpression;
							}
							else {
								raw_isRequired = ValueUtil.FALSE_VALUE;
							}
							IF_s0global = raw_isRequired;
						}
						else {
							IF_s0global = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapModule = IF_s0global;
					}
					else {
						raw_when_mapModule = ValueUtil.FALSE_VALUE;
					}
					IF_symbol_0 = raw_when_mapModule;
				}
				else {
					IF_symbol_0 = ValueUtil.FALSE_VALUE;
				}
				IF_eq = IF_symbol_0;
			}
			else {
				IF_eq = ValueUtil.FALSE_VALUE;
			}
			trace_34.setS0local(IF_eq);
			objectManager.assigned(trace_34, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__S0LOCAL, IF_eq, false);
			return IF_eq;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_34, thoseValues[0]);
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
	 * observe ocl::TypedElement::isRequired var isRequired : Boolean[1] := ownedContext.isRequired;
	 * observe ocl::TypedElement::type var type : Type[?] := ownedContext.type;
	 * var when_mapHelper_Operation : trace_ATL2QVTr::DmapHelper[1] := trace.wmapHelper;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * speculate when_mapHelper_Operation.s0global, when_mapOclExpression.s0global;
	 * var operationName : String[1] := trace.t1operationName;
	 * new:qvtr qvtrExpression : OperationCallExp[1];
	 * new:qvtr qvtrSource : VariableExp[1];
	 * set qvtrExpression.name := operationName;
	 * set qvtrSource.isRequired := isRequired;
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
		protected final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_35;

		public MAP_mmapOperationCallExp__Helper__qvtr__loop__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_35 = (@NonNull TmapOperationCallExp_Helper)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_35.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Helper domapOperationCallExp_Helper = dispatcher_0.getDomapOperationCallExp_Helper();
			final /*@NonInvalid*/ boolean eq = trace_35.equals(domapOperationCallExp_Helper);
			/*@Thrown*/ @Nullable Boolean IF_eq;
			if (eq) {
				objectManager.getting(trace_35, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__S0LOCAL, false);
				final /*@NonInvalid*/ @Nullable Boolean s0local = trace_35.getS0local();
				if (s0local == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0local;
				if (s0local) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull VariableDeclaration temp1_ownedContext = trace_35.getT4qvtrThisVariable();
					final /*@NonInvalid*/ boolean symbol_0 = temp1_ownedContext instanceof Parameter;
					/*@Thrown*/ @Nullable Boolean IF_symbol_0;
					if (symbol_0) {
						final /*@NonInvalid*/ @NonNull Parameter CAST_temp1_ownedContext = (Parameter)temp1_ownedContext;
						objectManager.getting(CAST_temp1_ownedContext, PivotPackage.Literals.NAMED_ELEMENT__NAME, false);
						final /*@NonInvalid*/ @Nullable String name_2 = CAST_temp1_ownedContext.getName();
						objectManager.getting(CAST_temp1_ownedContext, PivotPackage.Literals.TYPED_ELEMENT__IS_REQUIRED, false);
						final /*@NonInvalid*/ boolean isRequired = CAST_temp1_ownedContext.isIsRequired();
						objectManager.getting(CAST_temp1_ownedContext, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@NonInvalid*/ @Nullable Type type_2 = CAST_temp1_ownedContext.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull DmapHelper wmapHelper = trace_35.getWmapHelper();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace_35.getWmapOclExpression();
						SlotState.@NonNull Speculating outputSpeculatingSlotState = objectManager.getSpeculatingSlotState(trace_35, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL);
						Boolean outputSpeculatingSlotStatus = outputSpeculatingSlotState.getSpeculationStatus();
						if (outputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
							if (outputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
								trace_35.setS0global(ValueUtil.FALSE_VALUE);
								return ValueUtil.FALSE_VALUE;
							}
							SlotState.@NonNull Speculating inputSpeculatingSlotState;
							Boolean inputSpeculatingSlotStatus;
							boolean needsSpeculation = false;
							if (wmapHelper == null) {
								throw new InvalidEvaluationException("Null when_mapHelper_Operation speculation source");
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
								throw new InvalidEvaluationException("Null when_mapOclExpression speculation source");
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
						boolean symbol_13 = true;
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t1operationName = trace_35.getT1operationName();
						// creations
						final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
						models[3/*qvtr*/].add(qvtrExpression, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
						}
						final org.eclipse.ocl.pivot.@NonNull VariableExp qvtrSource = PivotFactory.eINSTANCE.createVariableExp();
						models[3/*qvtr*/].add(qvtrSource, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrSource));
						}
						// mapping statements
						qvtrExpression.setName(t1operationName);
						qvtrSource.setIsRequired(isRequired);
						qvtrSource.setName(name_2);
						dispatcher_0.setS0global((Boolean)ValueUtil.TRUE_VALUE);
						objectManager.assigned(dispatcher_0, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
						dispatcher_0.setD4qvtrExpression(qvtrExpression);
						trace_35.setT4qvtrSource(qvtrSource);
						qvtrExpression.setOwnedSource(qvtrSource);
						qvtrSource.setReferredVariable(CAST_temp1_ownedContext);
						qvtrSource.setType(type_2);
						objectManager.assigned(qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_2, false);
						final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Helper__qvtr__loop__ = ValueUtil.TRUE_VALUE;
						IF_symbol_0 = symbol_13;
					}
					else {
						IF_symbol_0 = ValueUtil.FALSE_VALUE;
					}
					IF_s0local = IF_symbol_0;
				}
				else {
					IF_s0local = ValueUtil.FALSE_VALUE;
				}
				IF_eq = IF_s0local;
			}
			else {
				IF_eq = ValueUtil.FALSE_VALUE;
			}
			trace_35.setS0global(IF_eq);
			objectManager.assigned(trace_35, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_eq, false);
			return IF_eq;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_35, thoseValues[0]);
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
		protected final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace_36;

		public MAP_mmapOperationCallExp__Operation__qvtr__loop__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_36 = (@NonNull TmapOperationCallExp_Operation)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_36.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Operation domapOperationCallExp_Operation = dispatcher_0.getDomapOperationCallExp_Operation();
			final /*@NonInvalid*/ boolean eq = trace_36.equals(domapOperationCallExp_Operation);
			/*@Thrown*/ @Nullable Boolean IF_eq;
			if (eq) {
				final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher_0.getDomapOperatorCallExp();
				final /*@NonInvalid*/ boolean symbol_0 = domapOperatorCallExp != null;
				/*@Thrown*/ @Nullable Boolean raw_not_mapOperatorCallExp;
				if (symbol_0) {
					if (domapOperatorCallExp == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@NonInvalid*/ @Nullable Boolean s0local = trace_36.getS0local();
					if (s0local == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean IF_s0local;
					if (s0local) {
						objectManager.getting(domapOperatorCallExp, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, false);
						final /*@Thrown*/ @Nullable Boolean s0global = domapOperatorCallExp.getS0global();
						final /*@Thrown*/ boolean eq_0 = s0global == Boolean.FALSE;
						/*@Thrown*/ @Nullable Boolean IF_eq_0;
						if (eq_0) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace_36.getWmapOclExpression();
							SlotState.@NonNull Speculating outputSpeculatingSlotState = objectManager.getSpeculatingSlotState(trace_36, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL);
							Boolean outputSpeculatingSlotStatus = outputSpeculatingSlotState.getSpeculationStatus();
							if (outputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
								if (outputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
									trace_36.setS0global(ValueUtil.FALSE_VALUE);
									return ValueUtil.FALSE_VALUE;
								}
								SlotState.@NonNull Speculating inputSpeculatingSlotState;
								Boolean inputSpeculatingSlotStatus;
								boolean needsSpeculation = false;
								if (wmapOclExpression == null) {
									throw new InvalidEvaluationException("Null when_mapOclExpression speculation source");
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
							boolean symbol_6 = true;
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String t1operationName = trace_36.getT1operationName();
							// creations
							final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
							models[3/*qvtr*/].add(qvtrExpression, false);
							if (debugCreations) {
								AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
							}
							// mapping statements
							qvtrExpression.setName(t1operationName);
							dispatcher_0.setS0global((Boolean)ValueUtil.TRUE_VALUE);
							objectManager.assigned(dispatcher_0, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
							dispatcher_0.setD4qvtrExpression(qvtrExpression);
							final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Operation__qvtr__loop__ = ValueUtil.TRUE_VALUE;
							IF_eq_0 = symbol_6;
						}
						else {
							IF_eq_0 = ValueUtil.FALSE_VALUE;
						}
						IF_s0local = IF_eq_0;
					}
					else {
						IF_s0local = ValueUtil.FALSE_VALUE;
					}
					raw_not_mapOperatorCallExp = IF_s0local;
				}
				else {
					raw_not_mapOperatorCallExp = ValueUtil.FALSE_VALUE;
				}
				IF_eq = raw_not_mapOperatorCallExp;
			}
			else {
				IF_eq = ValueUtil.FALSE_VALUE;
			}
			trace_36.setS0global(IF_eq);
			objectManager.assigned(trace_36, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_eq, false);
			return IF_eq;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_36, thoseValues[0]);
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
		protected final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace_37;

		public MAP_mmapOperatorCallExp__qvtr__loop__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_37 = (@NonNull TmapOperatorCallExp)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_37.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher_0.getDomapOperatorCallExp();
			final /*@NonInvalid*/ boolean eq = trace_37.equals(domapOperatorCallExp);
			/*@Thrown*/ @Nullable Boolean IF_eq;
			if (eq) {
				final /*@NonInvalid*/ @Nullable Boolean s0local = trace_37.getS0local();
				if (s0local == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0local;
				if (s0local) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace_37.getWmapOclExpression();
					SlotState.@NonNull Speculating outputSpeculatingSlotState = objectManager.getSpeculatingSlotState(trace_37, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL);
					Boolean outputSpeculatingSlotStatus = outputSpeculatingSlotState.getSpeculationStatus();
					if (outputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
						if (outputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
							trace_37.setS0global(ValueUtil.FALSE_VALUE);
							return ValueUtil.FALSE_VALUE;
						}
						SlotState.@NonNull Speculating inputSpeculatingSlotState;
						Boolean inputSpeculatingSlotStatus;
						boolean needsSpeculation = false;
						if (wmapOclExpression == null) {
							throw new InvalidEvaluationException("Null when_mapOclExpression speculation source");
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
					boolean symbol_5 = true;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String t1operationName = trace_37.getT1operationName();
					// creations
					final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
					models[3/*qvtr*/].add(qvtrExpression, false);
					if (debugCreations) {
						AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
					}
					// mapping statements
					qvtrExpression.setName(t1operationName);
					dispatcher_0.setS0global((Boolean)ValueUtil.TRUE_VALUE);
					objectManager.assigned(dispatcher_0, trace_ATL2QVTrPackage.Literals.DMAP_OCL_EXPRESSION__S0GLOBAL, ValueUtil.TRUE_VALUE, false);
					dispatcher_0.setD4qvtrExpression(qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean mmapOperatorCallExp__qvtr__loop__ = ValueUtil.TRUE_VALUE;
					IF_s0local = symbol_5;
				}
				else {
					IF_s0local = ValueUtil.FALSE_VALUE;
				}
				IF_eq = IF_s0local;
			}
			else {
				IF_eq = ValueUtil.FALSE_VALUE;
			}
			trace_37.setS0global(IF_eq);
			objectManager.assigned(trace_37, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__S0GLOBAL, IF_eq, false);
			return IF_eq;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_37, thoseValues[0]);
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
	protected boolean MAP_mmapInPattern__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapInPattern trace_38)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapInPattern__qvtr__rest__" +
				"\n\t\"trace\":" + toDebugString(trace_38));
		}
		final /*@NonInvalid*/ @Nullable Boolean s0global = trace_38.getS0global();
		if (s0global == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean IF_s0global;
		if (s0global) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull RelationDomain t4qvtrDomain = trace_38.getT4qvtrDomain();
			// mapping statements
			t4qvtrDomain.setIsCheckable(ValueUtil.TRUE_VALUE);
			t4qvtrDomain.setIsEnforceable(ValueUtil.FALSE_VALUE);
			final /*@Thrown*/ @Nullable Boolean mmapInPattern__qvtr__rest__ = ValueUtil.TRUE_VALUE;
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
	protected boolean MAP_mmapSimpleInPatternElement__qvtr__init__(final @NonNull Connection jm_TmapVariable_1, final /*@NonInvalid*/ @NonNull TmapSimpleInPatternElement trace_39)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapSimpleInPatternElement__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_39));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull SimpleInPatternElement t3atlElement = trace_39.getT3atlElement();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull InPattern inPattern = t3atlElement.getInPattern();
		final /*@NonInvalid*/ @Nullable TmapInPattern TmapInPattern = OPPOSITE_OF_TmapInPattern_t3atlPattern.get(inPattern);
		final /*@NonInvalid*/ boolean symbol_0 = TmapInPattern != null;
		/*@Thrown*/ @Nullable Boolean raw_when_mapInPattern;
		if (symbol_0) {
			if (TmapInPattern == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean s0global = TmapInPattern.getS0global();
			if (s0global == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean IF_s0global;
			if (s0global) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull MatchedRule rule = inPattern.getRule();
				final /*@NonInvalid*/ @Nullable TmapMatchedRule TmapMatchedRule = OPPOSITE_OF_TmapMatchedRule_t3matchedRule.get(rule);
				final /*@NonInvalid*/ boolean symbol_1 = TmapMatchedRule != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapMatchedRule;
				if (symbol_1) {
					if (TmapMatchedRule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable Boolean s0global_0 = TmapMatchedRule.getS0global();
					if (s0global_0 == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean IF_s0global_0;
					if (s0global_0) {
						final /*@NonInvalid*/ @Nullable OclType type_2 = t3atlElement.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String varName = t3atlElement.getVarName();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull RelationDomain t4qvtrDomain = TmapInPattern.getT4qvtrDomain();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull Relation t4qvtrRelation = TmapMatchedRule.getT4qvtrRelation();
						final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(this, type_2)).instance;
						// creations
						final @NonNull DomainPattern qvtrPattern = QVTrelationFactory.eINSTANCE.createDomainPattern();
						models[3/*qvtr*/].add(qvtrPattern, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrPattern));
						}
						final @NonNull ObjectTemplateExp qvtrTemplate = QVTtemplateFactory.eINSTANCE.createObjectTemplateExp();
						models[3/*qvtr*/].add(qvtrTemplate, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrTemplate));
						}
						final @NonNull TemplateVariable qvtrVariable = QVTrelationFactory.eINSTANCE.createTemplateVariable();
						models[3/*qvtr*/].add(qvtrVariable, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrVariable));
						}
						final @SuppressWarnings("null")@NonNull TmapVariable where_mapVariable = INSTANCE_ICACHE_TmapVariable.evaluate(t3atlElement, qvtrVariable);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(where_mapVariable));
						}
						// mapping statements
						qvtrVariable.setName(varName);
						trace_39.setT1elementName(varName);
						qvtrPattern.setRelationDomain(t4qvtrDomain);
						qvtrPattern.setTemplateExpression(qvtrTemplate);
						qvtrTemplate.setBindsTo(qvtrVariable);
						qvtrTemplate.setReferredClass(getType);
						qvtrTemplate.setType(getType);
						objectManager.assigned(qvtrTemplate, PivotPackage.Literals.TYPED_ELEMENT__TYPE, getType, false);
						t4qvtrRelation.getVariable().add(qvtrVariable);
						t4qvtrDomain.getRootVariable().add(qvtrVariable);
						qvtrVariable.setType(getType);
						trace_39.setT3atlPattern(inPattern);
						trace_39.setT3atlRule(rule);
						trace_39.setT4qvtrDomain(t4qvtrDomain);
						trace_39.setT4qvtrPattern(qvtrPattern);
						trace_39.setT4qvtrRelation(t4qvtrRelation);
						trace_39.setT4qvtrTemplate(qvtrTemplate);
						trace_39.setT4qvtrVariable(qvtrVariable);
						trace_39.setWmapInPattern(TmapInPattern);
						trace_39.setWmapMatchedRule(TmapMatchedRule);
						trace_39.setWmapVariable(where_mapVariable);
						jm_TmapVariable_1.appendElement(where_mapVariable);
						final /*@Thrown*/ @Nullable Boolean mmapSimpleInPatternElement__qvtr__init__ = ValueUtil.TRUE_VALUE;
						IF_s0global_0 = mmapSimpleInPatternElement__qvtr__init__;
					}
					else {
						IF_s0global_0 = ValueUtil.FALSE_VALUE;
					}
					raw_when_mapMatchedRule = IF_s0global_0;
				}
				else {
					raw_when_mapMatchedRule = ValueUtil.FALSE_VALUE;
				}
				IF_s0global = raw_when_mapMatchedRule;
			}
			else {
				IF_s0global = ValueUtil.FALSE_VALUE;
			}
			raw_when_mapInPattern = IF_s0global;
		}
		else {
			raw_when_mapInPattern = ValueUtil.FALSE_VALUE;
		}
		trace_39.setS0global(raw_when_mapInPattern);
		objectManager.assigned(trace_39, trace_ATL2QVTrPackage.Literals.TMAP_SIMPLE_IN_PATTERN_ELEMENT__S0GLOBAL, raw_when_mapInPattern, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_mapInPattern ? "done "  : "fail ") + "MAP_mmapSimpleInPatternElement__qvtr__init__");
		}
		return raw_when_mapInPattern;
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
	protected boolean MAP_mmapSimpleOutPatternElement__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapSimpleOutPatternElement trace_40)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapSimpleOutPatternElement__qvtr__rest__" +
				"\n\t\"trace\":" + toDebugString(trace_40));
		}
		final /*@NonInvalid*/ @Nullable Boolean s0global = trace_40.getS0global();
		if (s0global == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean IF_s0global;
		if (s0global) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull RelationDomain t4qvtrDomain = trace_40.getT4qvtrDomain();
			// mapping statements
			t4qvtrDomain.setIsCheckable(ValueUtil.FALSE_VALUE);
			t4qvtrDomain.setIsEnforceable(ValueUtil.TRUE_VALUE);
			final /*@Thrown*/ @Nullable Boolean mmapSimpleOutPatternElement__qvtr__rest__ = ValueUtil.TRUE_VALUE;
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
	protected boolean MAP_mmapVariableExp__referredVariable__Helper__qvtr__in(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_Helper trace_41)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariableExp__referredVariable__Helper__qvtr__in" +
				"\n\t\"trace\":" + toDebugString(trace_41) +
				"\n\t\"dispatcher\":" + toDebugString(trace_41.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_41.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_41.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher_0 = trace_41.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_Helper domapVariableExp_referredVariable_Helper = dispatcher_0.getDomapVariableExp_referredVariable_Helper();
		final /*@NonInvalid*/ boolean eq = trace_41.equals(domapVariableExp_referredVariable_Helper);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull VariableExp d3atlExpression = dispatcher_0.getD3atlExpression();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp d4qvtrExpression = dispatcher_0.getD4qvtrExpression();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableDeclaration referredVariable = d3atlExpression.getReferredVariable();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String varName = referredVariable.getVarName();
			final /*@NonInvalid*/ boolean eq_0 = varName.equals(STR_self);
			/*@Thrown*/ @Nullable Boolean IF_eq_0;
			if (eq_0) {
				final /*@NonInvalid*/ @Nullable Helper getHelper = ((FUN_getHelper)FTOR_getHelper.getUniqueComputation(this, d3atlExpression)).instance;
				// mapping statements
				dispatcher_0.setResult(trace_41);
				trace_41.setT3atlHelper(getHelper);
				trace_41.setT3atlVariable(referredVariable);
				final /*@Thrown*/ @Nullable Boolean mmapVariableExp__referredVariable__Helper__qvtr__in = ValueUtil.TRUE_VALUE;
				IF_eq_0 = mmapVariableExp__referredVariable__Helper__qvtr__in;
			}
			else {
				IF_eq_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_eq_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		trace_41.setS0local(IF_eq);
		objectManager.assigned(trace_41, trace_ATL2QVTrPackage.Literals.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__S0LOCAL, IF_eq, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapVariableExp__referredVariable__Helper__qvtr__in");
		}
		return IF_eq;
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
	protected boolean MAP_mmapBinding__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapBinding trace_42)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapBinding__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_42));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Binding t3atlBinding = trace_42.getT3atlBinding();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OutPatternElement temp1_atlOutPatternElement = t3atlBinding.getOutPatternElement();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlOutPatternElement instanceof SimpleOutPatternElement;
		/*@Thrown*/ @Nullable Boolean IF_symbol_0;
		if (symbol_0) {
			final /*@NonInvalid*/ @NonNull SimpleOutPatternElement CAST_temp1_atlOutPatternElement = (SimpleOutPatternElement)temp1_atlOutPatternElement;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression value = t3atlBinding.getValue();
			final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(value);
			final /*@NonInvalid*/ boolean symbol_1 = DmapOclExpression != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
			if (symbol_1) {
				if (DmapOclExpression == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@Thrown*/ @Nullable Boolean s0global = DmapOclExpression.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0global;
				if (s0global) {
					final /*@NonInvalid*/ @Nullable TmapSimpleOutPatternElement TmapSimpleOutPatternElement = OPPOSITE_OF_TmapSimpleOutPatternElement_t3atlElement.get(CAST_temp1_atlOutPatternElement);
					final /*@NonInvalid*/ boolean symbol_2 = TmapSimpleOutPatternElement != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapSimpleOutPatternElement;
					if (symbol_2) {
						if (TmapSimpleOutPatternElement == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean s0global_0 = TmapSimpleOutPatternElement.getS0global();
						if (s0global_0 == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean IF_s0global_0;
						if (s0global_0) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String propertyName = t3atlBinding.getPropertyName();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull OCLExpression d4qvtrExpression = DmapOclExpression.getD4qvtrExpression();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull ObjectTemplateExp t4qvtrTemplate = TmapSimpleOutPatternElement.getT4qvtrTemplate();
							final /*@Thrown*/ @Nullable Type type_2 = t4qvtrTemplate.getType();
							final /*@Thrown*/ @NonNull Property getProperty = ((FUN_getProperty)FTOR_getProperty.getUniqueComputation(this, type_2, propertyName)).instance;
							// creations
							final @NonNull PropertyTemplateItem qvtrPart = QVTtemplateFactory.eINSTANCE.createPropertyTemplateItem();
							models[3/*qvtr*/].add(qvtrPart, false);
							if (debugCreations) {
								AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrPart));
							}
							// mapping statements
							trace_42.setT1propertyName(propertyName);
							qvtrPart.setObjContainer(t4qvtrTemplate);
							qvtrPart.setReferredProperty(getProperty);
							qvtrPart.setValue(d4qvtrExpression);
							trace_42.setT3atlExpression(value);
							trace_42.setT3atlOutPatternElement(CAST_temp1_atlOutPatternElement);
							trace_42.setT4qvtrExpression(d4qvtrExpression);
							trace_42.setT4qvtrPart(qvtrPart);
							trace_42.setT4qvtrTemplate(t4qvtrTemplate);
							trace_42.setWmapOclExpression(DmapOclExpression);
							trace_42.setWmapSimpleOutPatternElement(TmapSimpleOutPatternElement);
							final /*@Thrown*/ @Nullable Boolean mmapBinding__qvtr__init__ = ValueUtil.TRUE_VALUE;
							IF_s0global_0 = mmapBinding__qvtr__init__;
						}
						else {
							IF_s0global_0 = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapSimpleOutPatternElement = IF_s0global_0;
					}
					else {
						raw_when_mapSimpleOutPatternElement = ValueUtil.FALSE_VALUE;
					}
					IF_s0global = raw_when_mapSimpleOutPatternElement;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				raw_when_mapOclExpression = IF_s0global;
			}
			else {
				raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
			}
			IF_symbol_0 = raw_when_mapOclExpression;
		}
		else {
			IF_symbol_0 = ValueUtil.FALSE_VALUE;
		}
		trace_42.setS0global(IF_symbol_0);
		objectManager.assigned(trace_42, trace_ATL2QVTrPackage.Literals.TMAP_BINDING__S0GLOBAL, IF_symbol_0, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_symbol_0 ? "done "  : "fail ") + "MAP_mmapBinding__qvtr__init__");
		}
		return IF_symbol_0;
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
	protected boolean MAP_mmapHelper__Attribute__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapHelper_Attribute trace_43)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapHelper__Attribute__qvtr__rest__" +
				"\n\t\"trace\":" + toDebugString(trace_43) +
				"\n\t\"dispatcher\":" + toDebugString(trace_43.getDispatcher()) +
				"\n\t\"dispatcher.d3atlHelper\":" + toDebugString(trace_43.getDispatcher().getD3atlHelper()) +
				"\n\t\"dispatcher.d4qvtrFunction\":" + toDebugString(trace_43.getDispatcher().getD4qvtrFunction()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_43.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapHelper_Attribute domapHelper_Attribute = dispatcher_0.getDomapHelper_Attribute();
		final /*@NonInvalid*/ boolean eq = trace_43.equals(domapHelper_Attribute);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Function d4qvtrFunction = dispatcher_0.getD4qvtrFunction();
			final /*@NonInvalid*/ @Nullable Boolean s0global = trace_43.getS0global();
			if (s0global == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean IF_s0global;
			if (s0global) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace_43.getWmapOclExpression();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = wmapOclExpression.getD4qvtrExpression();
				// mapping statements
				trace_43.setT4qvtrExpression(d4qvtrExpression);
				d4qvtrFunction.setQueryExpression(d4qvtrExpression);
				final /*@Thrown*/ @Nullable Boolean mmapHelper__Attribute__qvtr__rest__ = ValueUtil.TRUE_VALUE;
				IF_s0global = mmapHelper__Attribute__qvtr__rest__;
			}
			else {
				IF_s0global = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_s0global;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapHelper__Attribute__qvtr__rest__");
		}
		return IF_eq;
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
	protected boolean MAP_mmapHelper__Operation__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapHelper_Operation trace_44)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapHelper__Operation__qvtr__rest__" +
				"\n\t\"trace\":" + toDebugString(trace_44) +
				"\n\t\"dispatcher\":" + toDebugString(trace_44.getDispatcher()) +
				"\n\t\"dispatcher.d3atlHelper\":" + toDebugString(trace_44.getDispatcher().getD3atlHelper()) +
				"\n\t\"dispatcher.d4qvtrFunction\":" + toDebugString(trace_44.getDispatcher().getD4qvtrFunction()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_44.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapHelper_Operation domapHelper_Operation = dispatcher_0.getDomapHelper_Operation();
		final /*@NonInvalid*/ boolean eq = trace_44.equals(domapHelper_Operation);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Function d4qvtrFunction = dispatcher_0.getD4qvtrFunction();
			final /*@NonInvalid*/ @Nullable Boolean s0global = trace_44.getS0global();
			if (s0global == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean IF_s0global;
			if (s0global) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace_44.getWmapOclExpression();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = wmapOclExpression.getD4qvtrExpression();
				// mapping statements
				trace_44.setT4qvtrExpression(d4qvtrExpression);
				d4qvtrFunction.setQueryExpression(d4qvtrExpression);
				final /*@Thrown*/ @Nullable Boolean mmapHelper__Operation__qvtr__rest__ = ValueUtil.TRUE_VALUE;
				IF_s0global = mmapHelper__Operation__qvtr__rest__;
			}
			else {
				IF_s0global = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_s0global;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapHelper__Operation__qvtr__rest__");
		}
		return IF_eq;
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
	 * var qvtrElse : OCLExpression[1] := when_mapOclExpression2.d4qvtrExpression;
	 * var qvtrThen : OCLExpression[1] := when_mapOclExpression.d4qvtrExpression;
	 * set trace.t4qvtrCondition := qvtrCondition;
	 * set trace.t4qvtrElse := qvtrElse;
	 * set trace.t4qvtrThen := qvtrThen;
	 * set qvtrExpression.ownedCondition := qvtrCondition;
	 * set qvtrExpression.ownedElse := qvtrElse;
	 * set qvtrExpression.ownedThen := qvtrThen;
	 *
	 */
	protected boolean MAP_mmapIfExp__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapIfExp trace_45)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapIfExp__qvtr__rest__" +
				"\n\t\"trace\":" + toDebugString(trace_45) +
				"\n\t\"dispatcher\":" + toDebugString(trace_45.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_45.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_45.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_45.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapIfExp domapIfExp = dispatcher_0.getDomapIfExp();
		final /*@NonInvalid*/ boolean eq = trace_45.equals(domapIfExp);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.IfExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull IfExp CAST_temp1_qvtrExpression = (org.eclipse.ocl.pivot.IfExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace_45.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0global;
				if (s0global) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace_45.getWmapOclExpression();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression1 = trace_45.getWmapOclExpression1();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression2 = trace_45.getWmapOclExpression2();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = wmapOclExpression1.getD4qvtrExpression();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression_0 = wmapOclExpression2.getD4qvtrExpression();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression_1 = wmapOclExpression.getD4qvtrExpression();
					// mapping statements
					trace_45.setT4qvtrCondition(d4qvtrExpression);
					trace_45.setT4qvtrElse(d4qvtrExpression_0);
					trace_45.setT4qvtrThen(d4qvtrExpression_1);
					CAST_temp1_qvtrExpression.setOwnedCondition(d4qvtrExpression);
					CAST_temp1_qvtrExpression.setOwnedElse(d4qvtrExpression_0);
					CAST_temp1_qvtrExpression.setOwnedThen(d4qvtrExpression_1);
					final /*@Thrown*/ @Nullable Boolean mmapIfExp__qvtr__rest__ = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapIfExp__qvtr__rest__;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_s0global;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapIfExp__qvtr__rest__");
		}
		return IF_eq;
	}

	/**
	 *
	 * map:7 mmapInPattern__filter__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapInPattern_filter[1] success s0global;
	 * var atlPattern : ATL::InPattern[1] := trace.t3atlPattern;
	 * var atlExpression : OCL::OclExpression[1] := atlPattern.filter;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlExpression.DmapOclExpression;
	 * check when_mapOclExpression.s0global;
	 * var atlRule : ATL::MatchedRule[1] := atlPattern.rule;
	 * var when_mapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1] := atlRule.TmapMatchedRule;
	 * check when_mapMatchedRule.s0global;
	 * var qvtrExpression : OCLExpression[1] := when_mapOclExpression.d4qvtrExpression;
	 * var qvtrRelation : qvtrelation::Relation[1] := when_mapMatchedRule.t4qvtrRelation;
	 * new:qvtr qvtrPattern : qvtbase::Pattern[1];
	 * new:qvtr qvtrPredicate : qvtbase::Predicate[1];
	 * set qvtrRelation.when := qvtrPattern;
	 * set qvtrPredicate.conditionExpression := qvtrExpression;
	 * set qvtrPredicate.pattern := qvtrPattern;
	 * set trace.t3atlExpression := atlExpression;
	 * set trace.t3atlRule := atlRule;
	 * set trace.t4qvtrExpression := qvtrExpression;
	 * set trace.t4qvtrPattern := qvtrPattern;
	 * set trace.t4qvtrPredicate := qvtrPredicate;
	 * set trace.t4qvtrRelation := qvtrRelation;
	 * set trace.wmapMatchedRule := when_mapMatchedRule;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected boolean MAP_mmapInPattern__filter__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapInPattern_filter trace_46)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapInPattern__filter__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_46));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull InPattern t3atlPattern = trace_46.getT3atlPattern();
		final /*@NonInvalid*/ @Nullable OclExpression filter = t3atlPattern.getFilter();
		final /*@NonInvalid*/ boolean symbol_0 = filter != null;
		/*@Thrown*/ @Nullable Boolean raw_atlExpression;
		if (symbol_0) {
			if (filter == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(filter);
			final /*@Thrown*/ boolean symbol_1 = DmapOclExpression != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
			if (symbol_1) {
				if (DmapOclExpression == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@Thrown*/ @Nullable Boolean s0global = DmapOclExpression.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0global;
				if (s0global) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull MatchedRule rule = t3atlPattern.getRule();
					final /*@NonInvalid*/ @Nullable TmapMatchedRule TmapMatchedRule = OPPOSITE_OF_TmapMatchedRule_t3matchedRule.get(rule);
					final /*@NonInvalid*/ boolean symbol_2 = TmapMatchedRule != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapMatchedRule;
					if (symbol_2) {
						if (TmapMatchedRule == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean s0global_0 = TmapMatchedRule.getS0global();
						if (s0global_0 == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean IF_s0global_0;
						if (s0global_0) {
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull OCLExpression d4qvtrExpression = DmapOclExpression.getD4qvtrExpression();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull Relation t4qvtrRelation = TmapMatchedRule.getT4qvtrRelation();
							// creations
							final @NonNull Pattern qvtrPattern = QVTbaseFactory.eINSTANCE.createPattern();
							models[3/*qvtr*/].add(qvtrPattern, false);
							if (debugCreations) {
								AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrPattern));
							}
							final @NonNull Predicate qvtrPredicate = QVTbaseFactory.eINSTANCE.createPredicate();
							models[3/*qvtr*/].add(qvtrPredicate, false);
							if (debugCreations) {
								AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrPredicate));
							}
							// mapping statements
							t4qvtrRelation.setWhen(qvtrPattern);
							qvtrPredicate.setConditionExpression(d4qvtrExpression);
							qvtrPredicate.setPattern(qvtrPattern);
							trace_46.setT3atlExpression(filter);
							trace_46.setT3atlRule(rule);
							trace_46.setT4qvtrExpression(d4qvtrExpression);
							trace_46.setT4qvtrPattern(qvtrPattern);
							trace_46.setT4qvtrPredicate(qvtrPredicate);
							trace_46.setT4qvtrRelation(t4qvtrRelation);
							trace_46.setWmapMatchedRule(TmapMatchedRule);
							trace_46.setWmapOclExpression(DmapOclExpression);
							final /*@Thrown*/ @Nullable Boolean mmapInPattern__filter__qvtr__init__ = ValueUtil.TRUE_VALUE;
							IF_s0global_0 = mmapInPattern__filter__qvtr__init__;
						}
						else {
							IF_s0global_0 = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapMatchedRule = IF_s0global_0;
					}
					else {
						raw_when_mapMatchedRule = ValueUtil.FALSE_VALUE;
					}
					IF_s0global = raw_when_mapMatchedRule;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				raw_when_mapOclExpression = IF_s0global;
			}
			else {
				raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
			}
			raw_atlExpression = raw_when_mapOclExpression;
		}
		else {
			raw_atlExpression = ValueUtil.FALSE_VALUE;
		}
		trace_46.setS0global(raw_atlExpression);
		objectManager.assigned(trace_46, trace_ATL2QVTrPackage.Literals.TMAP_IN_PATTERN_FILTER__S0GLOBAL, raw_atlExpression, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_atlExpression ? "done "  : "fail ") + "MAP_mmapInPattern__filter__qvtr__init__");
		}
		return raw_atlExpression;
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
	protected boolean MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__res(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_47)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__res" +
				"\n\t\"trace\":" + toDebugString(trace_47) +
				"\n\t\"dispatcher\":" + toDebugString(trace_47.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_47.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_47.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_47.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Helper domapNavigationOrAttributeCallExp_Helper = dispatcher_0.getDomapNavigationOrAttributeCallExp_Helper();
		final /*@NonInvalid*/ boolean eq = trace_47.equals(domapNavigationOrAttributeCallExp_Helper);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp CAST_temp1_qvtrExpression = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace_47.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0global;
				if (s0global) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapHelper wmapHelper = trace_47.getWmapHelper();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace_47.getWmapOclExpression();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull Function d4qvtrFunction = wmapHelper.getD4qvtrFunction();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = wmapOclExpression.getD4qvtrExpression();
					// mapping statements
					CAST_temp1_qvtrExpression.getOwnedArguments().add(d4qvtrExpression);
					trace_47.setT4qvtrOperation(d4qvtrFunction);
					trace_47.setT4qvtrSourceArgument(d4qvtrExpression);
					CAST_temp1_qvtrExpression.setReferredOperation(d4qvtrFunction);
					final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Helper__qvtr__res = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapNavigationOrAttributeCallExp__Helper__qvtr__res;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_s0global;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__res");
		}
		return IF_eq;
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
	protected boolean MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__r(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace_48)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__r" +
				"\n\t\"trace\":" + toDebugString(trace_48) +
				"\n\t\"dispatcher\":" + toDebugString(trace_48.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_48.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_48.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_48.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Property domapNavigationOrAttributeCallExp_Property = dispatcher_0.getDomapNavigationOrAttributeCallExp_Property();
		final /*@NonInvalid*/ boolean eq = trace_48.equals(domapNavigationOrAttributeCallExp_Property);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof PropertyCallExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull PropertyCallExp CAST_temp1_qvtrExpression = (PropertyCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace_48.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0global;
				if (s0global) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace_48.getWmapOclExpression();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = wmapOclExpression.getD4qvtrExpression();
					// mapping statements
					trace_48.setT4qvtrSource(d4qvtrExpression);
					CAST_temp1_qvtrExpression.setOwnedSource(d4qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Property__qvtr__r = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapNavigationOrAttributeCallExp__Property__qvtr__r;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_s0global;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__r");
		}
		return IF_eq;
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
	protected boolean MAP_mmapOperationCallExp__Helper__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_49)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperationCallExp__Helper__qvtr__rest__" +
				"\n\t\"trace\":" + toDebugString(trace_49) +
				"\n\t\"dispatcher\":" + toDebugString(trace_49.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_49.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_49.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_49.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Helper domapOperationCallExp_Helper = dispatcher_0.getDomapOperationCallExp_Helper();
		final /*@NonInvalid*/ boolean eq = trace_49.equals(domapOperationCallExp_Helper);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp CAST_temp1_qvtrExpression = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace_49.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0global;
				if (s0global) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapHelper wmapHelper = trace_49.getWmapHelper();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace_49.getWmapOclExpression();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull Function d4qvtrFunction = wmapHelper.getD4qvtrFunction();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = wmapOclExpression.getD4qvtrExpression();
					// mapping statements
					CAST_temp1_qvtrExpression.getOwnedArguments().add(d4qvtrExpression);
					trace_49.setT4qvtrOperation(d4qvtrFunction);
					trace_49.setT4qvtrSourceArgument(d4qvtrExpression);
					CAST_temp1_qvtrExpression.setReferredOperation(d4qvtrFunction);
					final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Helper__qvtr__rest__ = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapOperationCallExp__Helper__qvtr__rest__;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_s0global;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapOperationCallExp__Helper__qvtr__rest__");
		}
		return IF_eq;
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
	protected boolean MAP_mmapOperationCallExp__Operation__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace_50)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperationCallExp__Operation__qvtr__rest__" +
				"\n\t\"trace\":" + toDebugString(trace_50) +
				"\n\t\"dispatcher\":" + toDebugString(trace_50.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_50.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_50.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_50.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Operation domapOperationCallExp_Operation = dispatcher_0.getDomapOperationCallExp_Operation();
		final /*@NonInvalid*/ boolean eq = trace_50.equals(domapOperationCallExp_Operation);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp CAST_temp1_qvtrExpression = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace_50.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0global;
				if (s0global) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace_50.getWmapOclExpression();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = wmapOclExpression.getD4qvtrExpression();
					// mapping statements
					trace_50.setT4qvtrSource(d4qvtrExpression);
					CAST_temp1_qvtrExpression.setOwnedSource(d4qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Operation__qvtr__rest__ = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapOperationCallExp__Operation__qvtr__rest__;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_s0global;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapOperationCallExp__Operation__qvtr__rest__");
		}
		return IF_eq;
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
	protected boolean MAP_mmapOperationCallExp__argument__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_argument trace_51)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperationCallExp__argument__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_51));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression t3atlArgument = trace_51.getT3atlArgument();
		final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(t3atlArgument);
		final /*@NonInvalid*/ boolean symbol_0 = DmapOclExpression != null;
		/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
		if (symbol_0) {
			if (DmapOclExpression == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean s0global = DmapOclExpression.getS0global();
			if (s0global == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean IF_s0global;
			if (s0global) {
				final /*@NonInvalid*/ @Nullable OperationCallExp parentOperation = t3atlArgument.getParentOperation();
				final /*@NonInvalid*/ boolean symbol_1 = parentOperation != null;
				/*@Thrown*/ @Nullable Boolean raw_atlParent;
				if (symbol_1) {
					if (parentOperation == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable DmapOclExpression DmapOclExpression_0 = OPPOSITE_OF_DmapOclExpression_d3atlExpression.get(parentOperation);
					final /*@Thrown*/ boolean symbol_2 = DmapOclExpression_0 != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOperationCallExp;
					if (symbol_2) {
						if (DmapOclExpression_0 == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean s0global_0 = DmapOclExpression_0.getS0global();
						if (s0global_0 == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean IF_s0global_0;
						if (s0global_0) {
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull OCLExpression temp1_qvtrParent = DmapOclExpression_0.getD4qvtrExpression();
							final /*@NonInvalid*/ boolean symbol_3 = temp1_qvtrParent instanceof org.eclipse.ocl.pivot.OperationCallExp;
							/*@Thrown*/ @Nullable Boolean IF_symbol_3;
							if (symbol_3) {
								final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp CAST_temp1_qvtrParent = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrParent;
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull OCLExpression d4qvtrExpression = DmapOclExpression.getD4qvtrExpression();
								// mapping statements
								CAST_temp1_qvtrParent.getOwnedArguments().add(d4qvtrExpression);
								trace_51.setT3atlParent(parentOperation);
								trace_51.setT4qvtrArgument(d4qvtrExpression);
								trace_51.setT4qvtrParent(CAST_temp1_qvtrParent);
								trace_51.setWmapOclExpression1(DmapOclExpression_0);
								trace_51.setWmapOclExpression(DmapOclExpression);
								final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__argument__qvtr__init__ = ValueUtil.TRUE_VALUE;
								IF_symbol_3 = mmapOperationCallExp__argument__qvtr__init__;
							}
							else {
								IF_symbol_3 = ValueUtil.FALSE_VALUE;
							}
							IF_s0global_0 = IF_symbol_3;
						}
						else {
							IF_s0global_0 = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapOperationCallExp = IF_s0global_0;
					}
					else {
						raw_when_mapOperationCallExp = ValueUtil.FALSE_VALUE;
					}
					raw_atlParent = raw_when_mapOperationCallExp;
				}
				else {
					raw_atlParent = ValueUtil.FALSE_VALUE;
				}
				IF_s0global = raw_atlParent;
			}
			else {
				IF_s0global = ValueUtil.FALSE_VALUE;
			}
			raw_when_mapOclExpression = IF_s0global;
		}
		else {
			raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
		}
		trace_51.setS0global(raw_when_mapOclExpression);
		objectManager.assigned(trace_51, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_ARGUMENT__S0GLOBAL, raw_when_mapOclExpression, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_mapOclExpression ? "done "  : "fail ") + "MAP_mmapOperationCallExp__argument__qvtr__init__");
		}
		return raw_when_mapOclExpression;
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
	protected boolean MAP_mmapOperatorCallExp__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace_52)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperatorCallExp__qvtr__rest__" +
				"\n\t\"trace\":" + toDebugString(trace_52) +
				"\n\t\"dispatcher\":" + toDebugString(trace_52.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_52.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_52.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_52.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher_0.getDomapOperatorCallExp();
		final /*@NonInvalid*/ boolean eq = trace_52.equals(domapOperatorCallExp);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp CAST_temp1_qvtrExpression = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace_52.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0global;
				if (s0global) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression wmapOclExpression = trace_52.getWmapOclExpression();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression d4qvtrExpression = wmapOclExpression.getD4qvtrExpression();
					// mapping statements
					trace_52.setT4qvtrSource(d4qvtrExpression);
					CAST_temp1_qvtrExpression.setOwnedSource(d4qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean mmapOperatorCallExp__qvtr__rest__ = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapOperatorCallExp__qvtr__rest__;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_s0global;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapOperatorCallExp__qvtr__rest__");
		}
		return IF_eq;
	}

	/**
	 *
	 * map:7 mmapSimpleInPatternElement__qvtr__rest__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapSimpleInPatternElement[1];
	 * check trace.s0global;
	 * var qvtrVariable : qvtrelation::TemplateVariable[1] := trace.t4qvtrVariable;
	 * set qvtrVariable.isRequired := true;
	 *
	 */
	protected boolean MAP_mmapSimpleInPatternElement__qvtr__rest__(final /*@NonInvalid*/ @NonNull TmapSimpleInPatternElement trace_53)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapSimpleInPatternElement__qvtr__rest__" +
				"\n\t\"trace\":" + toDebugString(trace_53));
		}
		final /*@NonInvalid*/ @Nullable Boolean s0global = trace_53.getS0global();
		if (s0global == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean IF_s0global;
		if (s0global) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull TemplateVariable t4qvtrVariable = trace_53.getT4qvtrVariable();
			// mapping statements
			t4qvtrVariable.setIsRequired(ValueUtil.TRUE_VALUE);
			final /*@Thrown*/ @Nullable Boolean mmapSimpleInPatternElement__qvtr__rest__ = ValueUtil.TRUE_VALUE;
			IF_s0global = mmapSimpleInPatternElement__qvtr__rest__;
		}
		else {
			IF_s0global = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_s0global ? "done "  : "fail ") + "MAP_mmapSimpleInPatternElement__qvtr__rest__");
		}
		return IF_s0global;
	}

	/**
	 *
	 * map:7 mmapVariable__qvtr__init__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariable[1] success s0global;
	 * var atlVariable : ATL::LocatedElement[1] := trace.t3atlVariable;
	 * var qvtrVariable : VariableDeclaration[1] := trace.t4qvtrVariable;
	 *
	 */
	protected boolean MAP_mmapVariable__qvtr__init__(final /*@NonInvalid*/ @NonNull TmapVariable trace_54)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariable__qvtr__init__" +
				"\n\t\"trace\":" + toDebugString(trace_54));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull LocatedElement t3atlVariable = trace_54.getT3atlVariable();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull VariableDeclaration t4qvtrVariable = trace_54.getT4qvtrVariable();
		// mapping statements
		final /*@Thrown*/ @Nullable Boolean mmapVariable__qvtr__init__ = ValueUtil.TRUE_VALUE;
		trace_54.setS0global(mmapVariable__qvtr__init__);
		objectManager.assigned(trace_54, trace_ATL2QVTrPackage.Literals.TMAP_VARIABLE__S0GLOBAL, mmapVariable__qvtr__init__, false);
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
	 * var isRequired : Boolean[1] := qvtrOperation.isRequired;
	 * var type : Type[?] := qvtrOperation.type;
	 * set qvtrExpression.isRequired := isRequired;
	 * notify set qvtrExpression.type := type;
	 *
	 */
	protected boolean MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__xtr(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_55)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__xtr" +
				"\n\t\"trace\":" + toDebugString(trace_55) +
				"\n\t\"dispatcher\":" + toDebugString(trace_55.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_55.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_55.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_55.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Helper domapNavigationOrAttributeCallExp_Helper = dispatcher_0.getDomapNavigationOrAttributeCallExp_Helper();
		final /*@NonInvalid*/ boolean eq = trace_55.equals(domapNavigationOrAttributeCallExp_Helper);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp CAST_temp1_qvtrExpression = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace_55.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0global;
				if (s0global) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull Operation t4qvtrOperation = trace_55.getT4qvtrOperation();
					final /*@NonInvalid*/ boolean isRequired = t4qvtrOperation.isIsRequired();
					final /*@NonInvalid*/ @Nullable Type type_2 = t4qvtrOperation.getType();
					// mapping statements
					CAST_temp1_qvtrExpression.setIsRequired(isRequired);
					CAST_temp1_qvtrExpression.setType(type_2);
					objectManager.assigned(CAST_temp1_qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_2, false);
					final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Helper__qvtr__xtr = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapNavigationOrAttributeCallExp__Helper__qvtr__xtr;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_s0global;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__xtr");
		}
		return IF_eq;
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
	 * var isRequired : Boolean[1] := qvtrOperation.isRequired;
	 * var type : Type[?] := qvtrOperation.type;
	 * set qvtrExpression.isRequired := isRequired;
	 * notify set qvtrExpression.type := type;
	 *
	 */
	protected boolean MAP_mmapOperationCallExp__Helper__qvtr__xtra__(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_56)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperationCallExp__Helper__qvtr__xtra__" +
				"\n\t\"trace\":" + toDebugString(trace_56) +
				"\n\t\"dispatcher\":" + toDebugString(trace_56.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_56.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_56.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_56.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Helper domapOperationCallExp_Helper = dispatcher_0.getDomapOperationCallExp_Helper();
		final /*@NonInvalid*/ boolean eq = trace_56.equals(domapOperationCallExp_Helper);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD4qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp CAST_temp1_qvtrExpression = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean s0global = trace_56.getS0global();
				if (s0global == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0global;
				if (s0global) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull Operation t4qvtrOperation = trace_56.getT4qvtrOperation();
					final /*@NonInvalid*/ boolean isRequired = t4qvtrOperation.isIsRequired();
					final /*@NonInvalid*/ @Nullable Type type_2 = t4qvtrOperation.getType();
					// mapping statements
					CAST_temp1_qvtrExpression.setIsRequired(isRequired);
					CAST_temp1_qvtrExpression.setType(type_2);
					objectManager.assigned(CAST_temp1_qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_2, false);
					final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Helper__qvtr__xtra__ = ValueUtil.TRUE_VALUE;
					IF_s0global = mmapOperationCallExp__Helper__qvtr__xtra__;
				}
				else {
					IF_s0global = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_s0global;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapOperationCallExp__Helper__qvtr__xtra__");
		}
		return IF_eq;
	}

	/**
	 *
	 * map:8 mmapVariableExp__referredVariable__Helper__qvtr__lo in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1] success s0global;
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 * check trace = dispatcher.domapVariableExp_referredVariable_Helper;
	 * var qvtrExpression : VariableExp[1] := dispatcher.d4qvtrExpression;
	 * check trace.s0local;
	 * var atlHelper : ATL::Helper[?] := trace.t3atlHelper;
	 * var when_mapVariable : trace_ATL2QVTr::TmapVariable[1] := atlHelper?.TmapVariable;
	 * speculate when_mapVariable.s0global;
	 * var qvtrVariable : VariableDeclaration[1] := when_mapVariable.t4qvtrVariable;
	 * var isRequired : Boolean[1] := qvtrVariable.isRequired;
	 * set qvtrExpression.isRequired := isRequired;
	 * set qvtrExpression.name := 'self';
	 * set dispatcher.s0global := true;
	 * set qvtrExpression.referredVariable := qvtrVariable;
	 * set trace.t4qvtrVariable := qvtrVariable;
	 *
	 */
	protected class MAP_mmapVariableExp__referredVariable__Helper__qvtr__lo extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_Helper trace_57;

		public MAP_mmapVariableExp__referredVariable__Helper__qvtr__lo(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_57 = (@NonNull TmapVariableExp_referredVariable_Helper)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher_0 = trace_57.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_Helper domapVariableExp_referredVariable_Helper = dispatcher_0.getDomapVariableExp_referredVariable_Helper();
			final /*@NonInvalid*/ boolean eq = trace_57.equals(domapVariableExp_referredVariable_Helper);
			/*@Thrown*/ @Nullable Boolean IF_eq;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp d4qvtrExpression = dispatcher_0.getD4qvtrExpression();
				final /*@NonInvalid*/ @Nullable Boolean s0local = trace_57.getS0local();
				if (s0local == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_s0local;
				if (s0local) {
					final /*@NonInvalid*/ @Nullable Helper t3atlHelper = trace_57.getT3atlHelper();
					final /*@NonInvalid*/ @NonNull Object TmapVariable = t3atlHelper == null;
					/*@Thrown*/ @Nullable TmapVariable safe_t3atlVariable_source;
					if (TmapVariable == Boolean.TRUE) {
						safe_t3atlVariable_source = null;
					}
					else {
						assert t3atlHelper != null;
						final /*@Thrown*/ @Nullable TmapVariable TmapVariable_0 = OPPOSITE_OF_TmapVariable_t3atlVariable.get(t3atlHelper);
						safe_t3atlVariable_source = TmapVariable_0;
					}
					final /*@Thrown*/ boolean symbol_0 = safe_t3atlVariable_source != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapVariable;
					if (symbol_0) {
						if (safe_t3atlVariable_source == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						SlotState.@NonNull Speculating outputSpeculatingSlotState = objectManager.getSpeculatingSlotState(trace_57, trace_ATL2QVTrPackage.Literals.IMAP_VARIABLE_EXP_REFERRED_VARIABLE__S0GLOBAL);
						Boolean outputSpeculatingSlotStatus = outputSpeculatingSlotState.getSpeculationStatus();
						if (outputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
							if (outputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
								trace_57.setS0global(ValueUtil.FALSE_VALUE);
								return ValueUtil.FALSE_VALUE;
							}
							SlotState.@NonNull Speculating inputSpeculatingSlotState;
							Boolean inputSpeculatingSlotStatus;
							boolean needsSpeculation = false;
							if (safe_t3atlVariable_source == null) {
								throw new InvalidEvaluationException("Null when_mapVariable speculation source");
							}
							inputSpeculatingSlotState = objectManager.getSpeculatingSlotState(safe_t3atlVariable_source, trace_ATL2QVTrPackage.Literals.TMAP_VARIABLE__S0GLOBAL);
							inputSpeculatingSlotStatus = inputSpeculatingSlotState.getSpeculationStatus();
							if (inputSpeculatingSlotStatus != ValueUtil.TRUE_VALUE) {
								if (inputSpeculatingSlotStatus == ValueUtil.FALSE_VALUE) {
									safe_t3atlVariable_source.setS0global(ValueUtil.FALSE_VALUE);
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
						boolean symbol_8 = true;
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull VariableDeclaration t4qvtrVariable = safe_t3atlVariable_source.getT4qvtrVariable();
						final /*@Thrown*/ boolean isRequired = t4qvtrVariable.isIsRequired();
						// mapping statements
						d4qvtrExpression.setIsRequired(isRequired);
						d4qvtrExpression.setName(STR_self);
						dispatcher_0.setS0global((Boolean)ValueUtil.TRUE_VALUE);
						d4qvtrExpression.setReferredVariable(t4qvtrVariable);
						trace_57.setT4qvtrVariable(t4qvtrVariable);
						final /*@Thrown*/ @Nullable Boolean mmapVariableExp__referredVariable__Helper__qvtr__lo = ValueUtil.TRUE_VALUE;
						raw_when_mapVariable = symbol_8;
					}
					else {
						raw_when_mapVariable = ValueUtil.FALSE_VALUE;
					}
					IF_s0local = raw_when_mapVariable;
				}
				else {
					IF_s0local = ValueUtil.FALSE_VALUE;
				}
				IF_eq = IF_s0local;
			}
			else {
				IF_eq = ValueUtil.FALSE_VALUE;
			}
			trace_57.setS0global(IF_eq);
			objectManager.assigned(trace_57, trace_ATL2QVTrPackage.Literals.IMAP_VARIABLE_EXP_REFERRED_VARIABLE__S0GLOBAL, IF_eq, false);
			return IF_eq;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_57, thoseValues[0]);
		}
	}

	/**
	 *
	 * map:8 mmapVariableExp__referredVariable__VariableDeclarat in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1] success s0local;
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 * check trace = dispatcher.domapVariableExp_referredVariable_VariableDeclaration;
	 * var atlExpression : OCL::VariableExp[1] := dispatcher.d3atlExpression;
	 * var qvtrExpression : VariableExp[1] := dispatcher.d4qvtrExpression;
	 * check var atlVariable : ATL::PatternElement[1] := atlExpression.referredVariable;
	 * var when_mapVariable : trace_ATL2QVTr::TmapVariable[1] := atlVariable.TmapVariable;
	 * var qvtrVariable : VariableDeclaration[1] := when_mapVariable.t4qvtrVariable;
	 * var name : String[?] := qvtrVariable.name;
	 * var isRequired : Boolean[1] := qvtrVariable.isRequired;
	 * var type : Type[?] := qvtrVariable.type;
	 * set qvtrExpression.isRequired := isRequired;
	 * set qvtrExpression.name := name;
	 * set dispatcher.result := trace;
	 * set qvtrExpression.referredVariable := qvtrVariable;
	 * notify set qvtrExpression.type := type;
	 * set trace.t3atlVariable := atlVariable;
	 * set trace.t4qvtrVariable := qvtrVariable;
	 *
	 */
	protected boolean MAP_mmapVariableExp__referredVariable__VariableDeclarat(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_VariableDeclaration trace_58)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariableExp__referredVariable__VariableDeclarat" +
				"\n\t\"trace\":" + toDebugString(trace_58) +
				"\n\t\"dispatcher\":" + toDebugString(trace_58.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_58.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_58.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher_0 = trace_58.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_VariableDeclaration domapVariableExp_referredVariable_VariableDeclaration = dispatcher_0.getDomapVariableExp_referredVariable_VariableDeclaration();
		final /*@NonInvalid*/ boolean eq = trace_58.equals(domapVariableExp_referredVariable_VariableDeclaration);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull VariableExp d3atlExpression = dispatcher_0.getD3atlExpression();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp d4qvtrExpression = dispatcher_0.getD4qvtrExpression();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableDeclaration temp1_atlVariable = d3atlExpression.getReferredVariable();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_atlVariable instanceof PatternElement;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull PatternElement CAST_temp1_atlVariable = (PatternElement)temp1_atlVariable;
				final /*@NonInvalid*/ @Nullable TmapVariable TmapVariable = OPPOSITE_OF_TmapVariable_t3atlVariable.get(CAST_temp1_atlVariable);
				final /*@NonInvalid*/ boolean symbol_1 = TmapVariable != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapVariable;
				if (symbol_1) {
					if (TmapVariable == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull VariableDeclaration t4qvtrVariable = TmapVariable.getT4qvtrVariable();
					final /*@Thrown*/ @Nullable String name_2 = t4qvtrVariable.getName();
					final /*@Thrown*/ boolean isRequired = t4qvtrVariable.isIsRequired();
					final /*@Thrown*/ @Nullable Type type_2 = t4qvtrVariable.getType();
					// mapping statements
					d4qvtrExpression.setIsRequired(isRequired);
					d4qvtrExpression.setName(name_2);
					dispatcher_0.setResult(trace_58);
					d4qvtrExpression.setReferredVariable(t4qvtrVariable);
					d4qvtrExpression.setType(type_2);
					objectManager.assigned(d4qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_2, false);
					trace_58.setT3atlVariable(CAST_temp1_atlVariable);
					trace_58.setT4qvtrVariable(t4qvtrVariable);
					final /*@Thrown*/ @Nullable Boolean mmapVariableExp__referredVariable__VariableDeclarat = ValueUtil.TRUE_VALUE;
					raw_when_mapVariable = mmapVariableExp__referredVariable__VariableDeclarat;
				}
				else {
					raw_when_mapVariable = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = raw_when_mapVariable;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_symbol_0;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		trace_58.setS0local(IF_eq);
		objectManager.assigned(trace_58, trace_ATL2QVTrPackage.Literals.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__S0LOCAL, IF_eq, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapVariableExp__referredVariable__VariableDeclarat");
		}
		return IF_eq;
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
	protected boolean MAP_mmapVariableExp__referredVariable__Helper__qvtr__xt(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_Helper trace_59)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariableExp__referredVariable__Helper__qvtr__xt" +
				"\n\t\"trace\":" + toDebugString(trace_59) +
				"\n\t\"dispatcher\":" + toDebugString(trace_59.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_59.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_59.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher_0 = trace_59.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_Helper domapVariableExp_referredVariable_Helper = dispatcher_0.getDomapVariableExp_referredVariable_Helper();
		final /*@NonInvalid*/ boolean eq = trace_59.equals(domapVariableExp_referredVariable_Helper);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp d4qvtrExpression = dispatcher_0.getD4qvtrExpression();
			final /*@NonInvalid*/ @Nullable Boolean s0global = trace_59.getS0global();
			if (s0global == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean IF_s0global;
			if (s0global) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull VariableDeclaration t4qvtrVariable = trace_59.getT4qvtrVariable();
				final /*@NonInvalid*/ @Nullable Type type_2 = t4qvtrVariable.getType();
				// mapping statements
				d4qvtrExpression.setType(type_2);
				objectManager.assigned(d4qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_2, false);
				final /*@Thrown*/ @Nullable Boolean mmapVariableExp__referredVariable__Helper__qvtr__xt = ValueUtil.TRUE_VALUE;
				IF_s0global = mmapVariableExp__referredVariable__Helper__qvtr__xt;
			}
			else {
				IF_s0global = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_s0global;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapVariableExp__referredVariable__Helper__qvtr__xt");
		}
		return IF_eq;
	}

	/**
	 *
	 * map:9 mmapVariableExp__referredVariable__VariableDeclarat_1 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1] success s0global;
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 * check trace = dispatcher.domapVariableExp_referredVariable_VariableDeclaration;
	 * check trace.s0local;
	 * var atlVariable : ATL::PatternElement[1] := trace.t3atlVariable;
	 * var when_mapVariable : trace_ATL2QVTr::TmapVariable[1] := atlVariable.TmapVariable;
	 * set dispatcher.s0global := true;
	 *
	 */
	protected boolean MAP_mmapVariableExp__referredVariable__VariableDeclarat_1(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_VariableDeclaration trace_60)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariableExp__referredVariable__VariableDeclarat_1" +
				"\n\t\"trace\":" + toDebugString(trace_60) +
				"\n\t\"dispatcher\":" + toDebugString(trace_60.getDispatcher()) +
				"\n\t\"dispatcher.d3atlExpression\":" + toDebugString(trace_60.getDispatcher().getD3atlExpression()) +
				"\n\t\"dispatcher.d4qvtrExpression\":" + toDebugString(trace_60.getDispatcher().getD4qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher_0 = trace_60.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_VariableDeclaration domapVariableExp_referredVariable_VariableDeclaration = dispatcher_0.getDomapVariableExp_referredVariable_VariableDeclaration();
		final /*@NonInvalid*/ boolean eq = trace_60.equals(domapVariableExp_referredVariable_VariableDeclaration);
		/*@Thrown*/ @Nullable Boolean IF_eq;
		if (eq) {
			final /*@NonInvalid*/ @Nullable Boolean s0local = trace_60.getS0local();
			if (s0local == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean IF_s0local;
			if (s0local) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull PatternElement t3atlVariable = trace_60.getT3atlVariable();
				final /*@NonInvalid*/ @Nullable TmapVariable TmapVariable = OPPOSITE_OF_TmapVariable_t3atlVariable.get(t3atlVariable);
				final /*@NonInvalid*/ boolean symbol_0 = TmapVariable != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapVariable;
				if (symbol_0) {
					if (TmapVariable == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					// mapping statements
					dispatcher_0.setS0global((Boolean)ValueUtil.TRUE_VALUE);
					final /*@Thrown*/ @Nullable Boolean mmapVariableExp__referredVariable__VariableDeclarat_1 = ValueUtil.TRUE_VALUE;
					raw_when_mapVariable = mmapVariableExp__referredVariable__VariableDeclarat_1;
				}
				else {
					raw_when_mapVariable = ValueUtil.FALSE_VALUE;
				}
				IF_s0local = raw_when_mapVariable;
			}
			else {
				IF_s0local = ValueUtil.FALSE_VALUE;
			}
			IF_eq = IF_s0local;
		}
		else {
			IF_eq = ValueUtil.FALSE_VALUE;
		}
		trace_60.setS0global(IF_eq);
		objectManager.assigned(trace_60, trace_ATL2QVTrPackage.Literals.IMAP_VARIABLE_EXP_REFERRED_VARIABLE__S0GLOBAL, IF_eq, false);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((IF_eq ? "done "  : "fail ") + "MAP_mmapVariableExp__referredVariable__VariableDeclarat_1");
		}
		return IF_eq;
	}

	/**
	 *
	 * map:10 mmapVariableExp__referredVariable__verdict__qvtr in ATL2QVTr {
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
		final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_Helper domapVariableExp_referredVariable_Helper = mapVariableExp_referredVariable.getDomapVariableExp_referredVariable_Helper();
		final /*@NonInvalid*/ boolean symbol_0 = domapVariableExp_referredVariable_Helper != null;
		/*@Thrown*/ @Nullable Boolean raw_mapVariableExp_referredVariable_Helper;
		if (symbol_0) {
			if (domapVariableExp_referredVariable_Helper == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean s0global = domapVariableExp_referredVariable_Helper.getS0global();
			final /*@Thrown*/ boolean eq = s0global == Boolean.FALSE;
			/*@Thrown*/ @Nullable Boolean IF_eq;
			if (eq) {
				final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_VariableDeclaration domapVariableExp_referredVariable_VariableDeclaration = mapVariableExp_referredVariable.getDomapVariableExp_referredVariable_VariableDeclaration();
				final /*@NonInvalid*/ boolean symbol_1 = domapVariableExp_referredVariable_VariableDeclaration != null;
				/*@Thrown*/ @Nullable Boolean raw_mapVariableExp_referredVariable_VariableDeclaration;
				if (symbol_1) {
					if (domapVariableExp_referredVariable_VariableDeclaration == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable Boolean s0global_0 = domapVariableExp_referredVariable_VariableDeclaration.getS0global();
					final /*@Thrown*/ boolean eq_0 = s0global_0 == Boolean.FALSE;
					/*@Thrown*/ @Nullable Boolean IF_eq_0;
					if (eq_0) {
						// mapping statements
						mapVariableExp_referredVariable.setS0global((Boolean)ValueUtil.FALSE_VALUE);
						final /*@Thrown*/ @Nullable Boolean mmapVariableExp__referredVariable__verdict__qvtr = ValueUtil.TRUE_VALUE;
						IF_eq_0 = mmapVariableExp__referredVariable__verdict__qvtr;
					}
					else {
						IF_eq_0 = ValueUtil.FALSE_VALUE;
					}
					raw_mapVariableExp_referredVariable_VariableDeclaration = IF_eq_0;
				}
				else {
					raw_mapVariableExp_referredVariable_VariableDeclaration = ValueUtil.FALSE_VALUE;
				}
				IF_eq = raw_mapVariableExp_referredVariable_VariableDeclaration;
			}
			else {
				IF_eq = ValueUtil.FALSE_VALUE;
			}
			raw_mapVariableExp_referredVariable_Helper = IF_eq;
		}
		else {
			raw_mapVariableExp_referredVariable_Helper = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_mapVariableExp_referredVariable_Helper ? "done "  : "fail ") + "MAP_mmapVariableExp__referredVariable__verdict__qvtr");
		}
		return raw_mapVariableExp_referredVariable_Helper;
	}

	/**
	 *
	 * map:11 mmapIfExp__qvtr__xtra__ in ATL2QVTr {
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
		protected final /*@NonInvalid*/ @NonNull TmapIfExp trace_61;

		public MAP_mmapIfExp__qvtr__xtra__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_61 = (@NonNull TmapIfExp)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_61.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapIfExp domapIfExp = dispatcher_0.getDomapIfExp();
			final /*@NonInvalid*/ boolean eq = trace_61.equals(domapIfExp);
			/*@Thrown*/ @Nullable Boolean IF_eq;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD4qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.IfExp;
				/*@Thrown*/ @Nullable Boolean IF_symbol_0;
				if (symbol_0) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull IfExp CAST_temp1_qvtrExpression = (org.eclipse.ocl.pivot.IfExp)temp1_qvtrExpression;
					final /*@NonInvalid*/ @Nullable Boolean s0global = trace_61.getS0global();
					if (s0global == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean IF_s0global;
					if (s0global) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OCLExpression t4qvtrThen = trace_61.getT4qvtrThen();
						objectManager.getting(t4qvtrThen, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@NonInvalid*/ @Nullable Type type_2 = t4qvtrThen.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OCLExpression t4qvtrElse = trace_61.getT4qvtrElse();
						objectManager.getting(t4qvtrElse, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@NonInvalid*/ @Nullable Type type_3 = t4qvtrElse.getType();
						final /*@Thrown*/ @NonNull Type getCommonType = ((FUN_getCommonType)FTOR_getCommonType.getUniqueComputation(ATL2QVTr.this, type_2, type_3)).instance;
						// mapping statements
						CAST_temp1_qvtrExpression.setType(getCommonType);
						objectManager.assigned(CAST_temp1_qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, getCommonType, false);
						final /*@Thrown*/ @Nullable Boolean mmapIfExp__qvtr__xtra__ = ValueUtil.TRUE_VALUE;
						IF_s0global = mmapIfExp__qvtr__xtra__;
					}
					else {
						IF_s0global = ValueUtil.FALSE_VALUE;
					}
					IF_symbol_0 = IF_s0global;
				}
				else {
					IF_symbol_0 = ValueUtil.FALSE_VALUE;
				}
				IF_eq = IF_symbol_0;
			}
			else {
				IF_eq = ValueUtil.FALSE_VALUE;
			}
			return IF_eq;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_61, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:11 mmapNavigationOrAttributeCallExp__Property__qvtr__x in ATL2QVTr {
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
	 * var isRequired : Boolean[1] := qvtrProperty.isRequired;
	 * var type1 : Type[?] := qvtrProperty.type;
	 * set qvtrExpression.isRequired := isRequired;
	 * set trace.t4qvtrProperty := qvtrProperty;
	 * set qvtrExpression.referredProperty := qvtrProperty;
	 * notify set qvtrExpression.type := type1;
	 *
	 */
	protected class MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__x extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace_62;

		public MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__x(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_62 = (@NonNull TmapNavigationOrAttributeCallExp_Property)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_62.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Property domapNavigationOrAttributeCallExp_Property = dispatcher_0.getDomapNavigationOrAttributeCallExp_Property();
			final /*@NonInvalid*/ boolean eq = trace_62.equals(domapNavigationOrAttributeCallExp_Property);
			/*@Thrown*/ @Nullable Boolean IF_eq;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD4qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof PropertyCallExp;
				/*@Thrown*/ @Nullable Boolean IF_symbol_0;
				if (symbol_0) {
					final /*@NonInvalid*/ @NonNull PropertyCallExp CAST_temp1_qvtrExpression = (PropertyCallExp)temp1_qvtrExpression;
					final /*@NonInvalid*/ @Nullable Boolean s0global = trace_62.getS0global();
					if (s0global == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean IF_s0global;
					if (s0global) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OCLExpression t4qvtrSource = trace_62.getT4qvtrSource();
						objectManager.getting(t4qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@NonInvalid*/ @Nullable Type type_2 = t4qvtrSource.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t1propertyName = trace_62.getT1propertyName();
						final /*@Thrown*/ @NonNull Property getProperty = ((FUN_getProperty)FTOR_getProperty.getUniqueComputation(ATL2QVTr.this, type_2, t1propertyName)).instance;
						final /*@Thrown*/ boolean isRequired = getProperty.isIsRequired();
						final /*@Thrown*/ @Nullable Type type_3 = getProperty.getType();
						// mapping statements
						CAST_temp1_qvtrExpression.setIsRequired(isRequired);
						trace_62.setT4qvtrProperty(getProperty);
						CAST_temp1_qvtrExpression.setReferredProperty(getProperty);
						CAST_temp1_qvtrExpression.setType(type_3);
						objectManager.assigned(CAST_temp1_qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_3, false);
						final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Property__qvtr__x = ValueUtil.TRUE_VALUE;
						IF_s0global = mmapNavigationOrAttributeCallExp__Property__qvtr__x;
					}
					else {
						IF_s0global = ValueUtil.FALSE_VALUE;
					}
					IF_symbol_0 = IF_s0global;
				}
				else {
					IF_symbol_0 = ValueUtil.FALSE_VALUE;
				}
				IF_eq = IF_symbol_0;
			}
			else {
				IF_eq = ValueUtil.FALSE_VALUE;
			}
			return IF_eq;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_62, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:11 mmapOperationCallExp__Operation__qvtr__xtra__ in ATL2QVTr {
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
	 * var isRequired : Boolean[1] := getOperation1.isRequired;
	 * var type1 : Type[?] := getOperation1.type;
	 * set qvtrExpression.isRequired := isRequired;
	 * set trace.t4qvtrOperation := getOperation1;
	 * set qvtrExpression.referredOperation := getOperation1;
	 * notify set qvtrExpression.type := type1;
	 *
	 */
	protected class MAP_mmapOperationCallExp__Operation__qvtr__xtra__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace_63;

		public MAP_mmapOperationCallExp__Operation__qvtr__xtra__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_63 = (@NonNull TmapOperationCallExp_Operation)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_63.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Operation domapOperationCallExp_Operation = dispatcher_0.getDomapOperationCallExp_Operation();
			final /*@NonInvalid*/ boolean eq = trace_63.equals(domapOperationCallExp_Operation);
			/*@Thrown*/ @Nullable Boolean IF_eq;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD4qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
				/*@Thrown*/ @Nullable Boolean IF_symbol_0;
				if (symbol_0) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp CAST_temp1_qvtrExpression = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
					final /*@NonInvalid*/ @Nullable Boolean s0global = trace_63.getS0global();
					if (s0global == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean IF_s0global;
					if (s0global) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OCLExpression t4qvtrSource = trace_63.getT4qvtrSource();
						objectManager.getting(t4qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@NonInvalid*/ @Nullable Type type_2 = t4qvtrSource.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t1operationName = trace_63.getT1operationName();
						final /*@Thrown*/ @NonNull Operation getOperation = ((FUN_getOperation)FTOR_getOperation.getUniqueComputation(ATL2QVTr.this, type_2, t1operationName)).instance;
						final /*@Thrown*/ boolean isRequired = getOperation.isIsRequired();
						final /*@Thrown*/ @Nullable Type type_3 = getOperation.getType();
						// mapping statements
						CAST_temp1_qvtrExpression.setIsRequired(isRequired);
						trace_63.setT4qvtrOperation(getOperation);
						CAST_temp1_qvtrExpression.setReferredOperation(getOperation);
						CAST_temp1_qvtrExpression.setType(type_3);
						objectManager.assigned(CAST_temp1_qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_3, false);
						final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Operation__qvtr__xtra__ = ValueUtil.TRUE_VALUE;
						IF_s0global = mmapOperationCallExp__Operation__qvtr__xtra__;
					}
					else {
						IF_s0global = ValueUtil.FALSE_VALUE;
					}
					IF_symbol_0 = IF_s0global;
				}
				else {
					IF_symbol_0 = ValueUtil.FALSE_VALUE;
				}
				IF_eq = IF_symbol_0;
			}
			else {
				IF_eq = ValueUtil.FALSE_VALUE;
			}
			return IF_eq;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_63, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:11 mmapOperatorCallExp__qvtr__xtra__ in ATL2QVTr {
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
	 * var isRequired : Boolean[1] := qvtrOperation.isRequired;
	 * var type1 : Type[?] := qvtrOperation.type;
	 * set qvtrExpression.isRequired := isRequired;
	 * set trace.t4qvtrOperation := qvtrOperation;
	 * set qvtrExpression.referredOperation := qvtrOperation;
	 * notify set qvtrExpression.type := type1;
	 *
	 */
	protected class MAP_mmapOperatorCallExp__qvtr__xtra__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace_64;

		public MAP_mmapOperatorCallExp__qvtr__xtra__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_64 = (@NonNull TmapOperatorCallExp)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_64.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher_0.getDomapOperatorCallExp();
			final /*@NonInvalid*/ boolean eq = trace_64.equals(domapOperatorCallExp);
			/*@Thrown*/ @Nullable Boolean IF_eq;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD4qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
				/*@Thrown*/ @Nullable Boolean IF_symbol_0;
				if (symbol_0) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp CAST_temp1_qvtrExpression = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
					final /*@NonInvalid*/ @Nullable Boolean s0global = trace_64.getS0global();
					if (s0global == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean IF_s0global;
					if (s0global) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OCLExpression t4qvtrSource = trace_64.getT4qvtrSource();
						objectManager.getting(t4qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@NonInvalid*/ @Nullable Type type_2 = t4qvtrSource.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t1operationName = trace_64.getT1operationName();
						final /*@Thrown*/ @NonNull Operation getOperation = ((FUN_getOperation)FTOR_getOperation.getUniqueComputation(ATL2QVTr.this, type_2, t1operationName)).instance;
						final /*@Thrown*/ boolean isRequired = getOperation.isIsRequired();
						final /*@Thrown*/ @Nullable Type type_3 = getOperation.getType();
						// mapping statements
						CAST_temp1_qvtrExpression.setIsRequired(isRequired);
						trace_64.setT4qvtrOperation(getOperation);
						CAST_temp1_qvtrExpression.setReferredOperation(getOperation);
						CAST_temp1_qvtrExpression.setType(type_3);
						objectManager.assigned(CAST_temp1_qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_3, false);
						final /*@Thrown*/ @Nullable Boolean mmapOperatorCallExp__qvtr__xtra__ = ValueUtil.TRUE_VALUE;
						IF_s0global = mmapOperatorCallExp__qvtr__xtra__;
					}
					else {
						IF_s0global = ValueUtil.FALSE_VALUE;
					}
					IF_symbol_0 = IF_s0global;
				}
				else {
					IF_symbol_0 = ValueUtil.FALSE_VALUE;
				}
				IF_eq = IF_symbol_0;
			}
			else {
				IF_eq = ValueUtil.FALSE_VALUE;
			}
			return IF_eq;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_64, thoseValues[0]);
		}
	}
}
