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
import org.eclipse.m2m.atl.common.OCL.VariableDeclaration;
import org.eclipse.m2m.atl.common.OCL.VariableExp;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.ParameterVariable;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.Type;
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
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIsEmptyOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionNotEmptyOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.BagValue;
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
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrFactory;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;
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
import org.eclipse.qvtd.runtime.evaluation.ModeFactory;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractComputationConstructor;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractInvocationConstructor;
import org.eclipse.qvtd.runtime.qvttrace.QVTtracePackage;

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
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_org = IdManager.getRootPackageId("org");
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_eclipse = PACKid_org.getNestedPackageId("eclipse");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL = IdManager.getNsURIPackageId("http://www.eclipse.org/gmt/2005/ATL", null, ATLPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL = IdManager.getNsURIPackageId("http://www.eclipse.org/gmt/2005/OCL", null, OCLPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbase", null, QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTrelation", null, QVTrelationPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTtemplate = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTtemplate", null, QVTtemplatePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2018_s_QVTtrace = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2018/QVTtrace", null, QVTtracePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd-example/org/eclipse/qvtd/atl/atl2qvtr/ATL2QVTr", "PATL2QVTr", trace_ATL2QVTrPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Attribute = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("Attribute", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Binding = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("Binding", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BooleanExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("BooleanExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BooleanLiteralExp = PACKid_$metamodel$.getClassId("BooleanLiteralExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DmapHelper = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("DmapHelper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DmapOclExpression = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("DmapOclExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_DmapVariableExp_referredVariable = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("DmapVariableExp_referredVariable", 0);
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
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OperationCallExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("OperationCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OperationCallExp_0 = PACKid_$metamodel$.getClassId("OperationCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Operation_0 = PACKid_$metamodel$.getClassId("Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OperatorCallExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("OperatorCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OutPattern = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("OutPattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OutPatternElement = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("OutPatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Package = PACKid_$metamodel$.getClassId("Package", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ParameterVariable = PACKid_$metamodel$.getClassId("ParameterVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Pattern = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Pattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_PatternElement = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("PatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Predicate = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("Predicate", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Property = PACKid_$metamodel$.getClassId("Property", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_PropertyCallExp = PACKid_$metamodel$.getClassId("PropertyCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_PropertyTemplateItem = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTtemplate.getClassId("PropertyTemplateItem", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Relation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("Relation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelationDomain = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("RelationDomain", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelationModel = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("RelationModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelationalTransformation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("RelationalTransformation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Rule = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("Rule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_SharedVariable = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("SharedVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_SimpleInPatternElement = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("SimpleInPatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_SimpleOutPatternElement = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("SimpleOutPatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_StringExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("StringExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_StringLiteralExp = PACKid_$metamodel$.getClassId("StringLiteralExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TemplateVariable = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("TemplateVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapBinding = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapBinding", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapBooleanExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapBooleanExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapHelper_Attribute = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapHelper_Attribute", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapHelper_Context = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapHelper_Context", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapHelper_Operation = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapHelper_Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapIfExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapIfExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapInPattern = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapInPattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapInPattern_filter = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapInPattern_filter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapIntegerExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapIntegerExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapMatchedRule = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapMatchedRule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapMatchedRule_super = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapMatchedRule_super", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapModule = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapModule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapNavigationOrAttributeCallExp_Helper = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapNavigationOrAttributeCallExp_Helper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapNavigationOrAttributeCallExp_Property = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapNavigationOrAttributeCallExp_Property", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOclMetamodel = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOclMetamodel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOclModel_IN = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOclModel_IN", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOclModel_OUT = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOclModel_OUT", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOclType = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOclType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOperationCallExp_Helper = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOperationCallExp_Helper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOperationCallExp_Operation = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOperationCallExp_Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOperationCallExp_argument = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOperationCallExp_argument", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOperatorCallExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOperatorCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapSimpleInPatternElement = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapSimpleInPatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapSimpleOutPatternElement = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapSimpleOutPatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapStringExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapStringExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapVariable = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapVariableExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapVariableExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapVariableExp_referredVariable_Helper = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapVariableExp_referredVariable_Helper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapVariableExp_referredVariable_VariableDeclaration = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapVariableExp_referredVariable_VariableDeclaration", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TraceElement = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2018_s_QVTtrace.getClassId("TraceElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Type = PACKid_$metamodel$.getClassId("Type", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TypedModel = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("TypedModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Variable = PACKid_$metamodel$.getClassId("Variable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableDeclaration = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("VariableDeclaration", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableDeclaration_0 = PACKid_$metamodel$.getClassId("VariableDeclaration", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("VariableExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableExp_0 = PACKid_$metamodel$.getClassId("VariableExp", 0);
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_qvtd = PACKid_eclipse.getNestedPackageId("qvtd");
	public static final /*@NonInvalid*/ @NonNull String STR_ = "";
	public static final /*@NonInvalid*/ @NonNull String STR_middle = "middle";
	public static final /*@NonInvalid*/ @NonNull String STR_self = "self";
	public static final /*@NonInvalid*/ @NonNull String STR_this = "this";
	public static final /*@NonInvalid*/ @NonNull String STR_trace = "trace";
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_OclModelElement = TypeId.BAG.getSpecializedId(CLSSid_OclModelElement);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_OclType = TypeId.BAG.getSpecializedId(CLSSid_OclType);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Helper = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Helper);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_ModuleElement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ModuleElement);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_OclModel = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OclModel);
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_atl = PACKid_qvtd.getNestedPackageId("atl");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_d1atlExpression_0 = CLSSid_DmapOclExpression.getPropertyId("d1atlExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_d1atlHelper = CLSSid_DmapHelper.getPropertyId("d1atlHelper");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_definition = CLSSid_Helper.getPropertyId("definition");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_inModels = CLSSid_Module.getPropertyId("inModels");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_outModels = CLSSid_Module.getPropertyId("outModels");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1atlElement_0 = CLSSid_TmapSimpleOutPatternElement.getPropertyId("t1atlElement");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1atlModule_4 = CLSSid_TmapModule.getPropertyId("t1atlModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1atlPattern_2 = CLSSid_TmapInPattern.getPropertyId("t1atlPattern");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1atlVariable_2 = CLSSid_TmapVariable.getPropertyId("t1atlVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1matchedRule = CLSSid_TmapMatchedRule.getPropertyId("t1matchedRule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1oclMetamodel_1 = CLSSid_TmapOclMetamodel.getPropertyId("t1oclMetamodel");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Attribute = TypeId.SEQUENCE.getSpecializedId(CLSSid_Attribute);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_OclFeature = TypeId.SEQUENCE.getSpecializedId(CLSSid_OclFeature);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_OclFeatureDefinition = TypeId.SEQUENCE.getSpecializedId(CLSSid_OclFeatureDefinition);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Operation = TypeId.SEQUENCE.getSpecializedId(CLSSid_Operation);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Helper = TypeId.SET.getSpecializedId(CLSSid_Helper);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_InPatternElement = TypeId.SET.getSpecializedId(CLSSid_InPatternElement);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_LocatedElement = TypeId.SET.getSpecializedId(CLSSid_LocatedElement);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_OclElement = TypeId.SET.getSpecializedId(CLSSid_OclElement);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_OclModel = TypeId.SET.getSpecializedId(CLSSid_OclModel);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Package = TypeId.SET.getSpecializedId(CLSSid_Package);
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_atl2qvtr = PACKid_atl.getNestedPackageId("atl2qvtr");
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ATL2QVTr = PACKid_atl2qvtr.getClassId("ATL2QVTr", 0);

	/*
	 * Property-source to Property-target unnavigable navigation caches
	 */
	protected final @NonNull Map<Helper,DmapHelper> OPPOSITE_OF_DmapHelper_d1atlHelper = new HashMap<>();
	protected final @NonNull Map<OclExpression,DmapOclExpression> OPPOSITE_OF_DmapOclExpression_d1atlExpression = new HashMap<>();
	protected final @NonNull Map<InPattern,TmapInPattern> OPPOSITE_OF_TmapInPattern_t1atlPattern = new HashMap<>();
	protected final @NonNull Map<MatchedRule,TmapMatchedRule> OPPOSITE_OF_TmapMatchedRule_t1matchedRule = new HashMap<>();
	protected final @NonNull Map<Module,TmapModule> OPPOSITE_OF_TmapModule_t1atlModule = new HashMap<>();
	protected final @NonNull Map<OclModel,TmapOclMetamodel> OPPOSITE_OF_TmapOclMetamodel_t1oclMetamodel = new HashMap<>();
	protected final @NonNull Map<SimpleOutPatternElement,TmapSimpleOutPatternElement> OPPOSITE_OF_TmapSimpleOutPatternElement_t1atlElement = new HashMap<>();
	protected final @NonNull Map<LocatedElement,TmapVariable> OPPOSITE_OF_TmapVariable_t1atlVariable = new HashMap<>();

	/*
	 * Array of the source PropertyIds of each Property for which unnavigable opposite property navigation may occur.
	 */
	private static final @NonNull PropertyId @NonNull [] oppositeIndex2propertyId = new @NonNull PropertyId[]{
		PROPid_t1oclMetamodel_1,		// 0 => t1oclMetamodel
		PROPid_t1atlModule_4,		// 1 => t1atlModule
		PROPid_d1atlExpression_0,		// 2 => d1atlExpression
		PROPid_d1atlHelper,		// 3 => d1atlHelper
		PROPid_t1matchedRule,		// 4 => t1matchedRule
		PROPid_t1atlPattern_2,		// 5 => t1atlPattern
		PROPid_t1atlElement_0,		// 6 => t1atlElement
		PROPid_t1atlVariable_2		// 7 => t1atlVariable
	};

	/*
	 * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
	 */
	private static final @NonNull ClassId @NonNull [] classIndex2classId = new @NonNull ClassId[]{
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
	 * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
	 * may contribute results to an allInstances() invocation.
	 * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
	 * instance of the derived classId contributes to derived and inherited ClassIndexes.
	 */
	private final static int @NonNull [] @NonNull [] classIndex2allClassIndexes = new int @NonNull [] @NonNull [] {
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

	protected final @NonNull AbstractInvocationConstructor CTOR_r_atl2qvtr____load__ = new AbstractInvocationConstructor(invocationManager, "r_atl2qvtr____load__", false, lazyCreateInterval(0))
	{
		@Override
		public @NonNull MAP_r_atl2qvtr____load__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_r_atl2qvtr____load__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapHelper__Attribute__qvtr__local__ = new AbstractInvocationConstructor(invocationManager, "mmapHelper__Attribute__qvtr__local__", false, lazyCreateInterval(4))
	{
		@Override
		public @NonNull MAP_mmapHelper__Attribute__qvtr__local__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapHelper__Attribute__qvtr__local__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapIfExp__qvtr__local__ = new AbstractInvocationConstructor(invocationManager, "mmapIfExp__qvtr__local__", false, lazyCreateInterval(4))
	{
		@Override
		public @NonNull MAP_mmapIfExp__qvtr__local__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapIfExp__qvtr__local__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapHelper__Operation__qvtr__local__ = new AbstractInvocationConstructor(invocationManager, "mmapHelper__Operation__qvtr__local__", false, lazyCreateInterval(4))
	{
		@Override
		public @NonNull MAP_mmapHelper__Operation__qvtr__local__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapHelper__Operation__qvtr__local__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapNavigationOrAttributeCallExp__Helper__qvtr__loc = new AbstractInvocationConstructor(invocationManager, "mmapNavigationOrAttributeCallExp__Helper__qvtr__loc", false, lazyCreateInterval(4))
	{
		@Override
		public @NonNull MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__loc newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__loc(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapNavigationOrAttributeCallExp__Property__qvtr__l = new AbstractInvocationConstructor(invocationManager, "mmapNavigationOrAttributeCallExp__Property__qvtr__l", false, lazyCreateInterval(4))
	{
		@Override
		public @NonNull MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__l newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__l(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOperationCallExp__Helper__qvtr__local__ = new AbstractInvocationConstructor(invocationManager, "mmapOperationCallExp__Helper__qvtr__local__", false, lazyCreateInterval(4))
	{
		@Override
		public @NonNull MAP_mmapOperationCallExp__Helper__qvtr__local__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperationCallExp__Helper__qvtr__local__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOperatorCallExp__qvtr__local__ = new AbstractInvocationConstructor(invocationManager, "mmapOperatorCallExp__qvtr__local__", false, lazyCreateInterval(4))
	{
		@Override
		public @NonNull MAP_mmapOperatorCallExp__qvtr__local__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperatorCallExp__qvtr__local__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOperationCallExp__Operation__qvtr__local__ = new AbstractInvocationConstructor(invocationManager, "mmapOperationCallExp__Operation__qvtr__local__", false, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapOperationCallExp__Operation__qvtr__local__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperationCallExp__Operation__qvtr__local__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapHelper__Operation__qvtr__global__ = new AbstractInvocationConstructor(invocationManager, "mmapHelper__Operation__qvtr__global__", false, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapHelper__Operation__qvtr__global__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapHelper__Operation__qvtr__global__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOperatorCallExp__qvtr__global__ = new AbstractInvocationConstructor(invocationManager, "mmapOperatorCallExp__qvtr__global__", false, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapOperatorCallExp__qvtr__global__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperatorCallExp__qvtr__global__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapIfExp__qvtr__global__ = new AbstractInvocationConstructor(invocationManager, "mmapIfExp__qvtr__global__", false, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapIfExp__qvtr__global__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapIfExp__qvtr__global__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapNavigationOrAttributeCallExp__Property__qvtr__g = new AbstractInvocationConstructor(invocationManager, "mmapNavigationOrAttributeCallExp__Property__qvtr__g", false, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__g newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__g(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapHelper__Attribute__qvtr__global__ = new AbstractInvocationConstructor(invocationManager, "mmapHelper__Attribute__qvtr__global__", false, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapHelper__Attribute__qvtr__global__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapHelper__Attribute__qvtr__global__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOperationCallExp__Operation__qvtr__global__ = new AbstractInvocationConstructor(invocationManager, "mmapOperationCallExp__Operation__qvtr__global__", false, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapOperationCallExp__Operation__qvtr__global__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperationCallExp__Operation__qvtr__global__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapNavigationOrAttributeCallExp__Helper__qvtr__glo = new AbstractInvocationConstructor(invocationManager, "mmapNavigationOrAttributeCallExp__Helper__qvtr__glo", false, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__glo newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__glo(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOperationCallExp__Helper__qvtr__global__ = new AbstractInvocationConstructor(invocationManager, "mmapOperationCallExp__Helper__qvtr__global__", false, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_mmapOperationCallExp__Helper__qvtr__global__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperationCallExp__Helper__qvtr__global__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOperatorCallExp__qvtr__speculated__ = new AbstractInvocationConstructor(invocationManager, "mmapOperatorCallExp__qvtr__speculated__", false, lazyCreateInterval(6))
	{
		@Override
		public @NonNull MAP_mmapOperatorCallExp__qvtr__speculated__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperatorCallExp__qvtr__speculated__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapHelper__verdict__qvtr = new AbstractInvocationConstructor(invocationManager, "mmapHelper__verdict__qvtr", false, lazyCreateInterval(6))
	{
		@Override
		public @NonNull MAP_mmapHelper__verdict__qvtr newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapHelper__verdict__qvtr(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapHelper__Operation__qvtr__speculated__ = new AbstractInvocationConstructor(invocationManager, "mmapHelper__Operation__qvtr__speculated__", false, lazyCreateInterval(6))
	{
		@Override
		public @NonNull MAP_mmapHelper__Operation__qvtr__speculated__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapHelper__Operation__qvtr__speculated__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapIfExp__qvtr__speculated__ = new AbstractInvocationConstructor(invocationManager, "mmapIfExp__qvtr__speculated__", false, lazyCreateInterval(6))
	{
		@Override
		public @NonNull MAP_mmapIfExp__qvtr__speculated__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapIfExp__qvtr__speculated__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOclExpression__verdict__qvtr = new AbstractInvocationConstructor(invocationManager, "mmapOclExpression__verdict__qvtr", false, lazyCreateInterval(6))
	{
		@Override
		public @NonNull MAP_mmapOclExpression__verdict__qvtr newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOclExpression__verdict__qvtr(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapNavigationOrAttributeCallExp__Property__qvtr__s = new AbstractInvocationConstructor(invocationManager, "mmapNavigationOrAttributeCallExp__Property__qvtr__s", false, lazyCreateInterval(6))
	{
		@Override
		public @NonNull MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__s newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__s(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapHelper__Attribute__qvtr__speculated__ = new AbstractInvocationConstructor(invocationManager, "mmapHelper__Attribute__qvtr__speculated__", false, lazyCreateInterval(6))
	{
		@Override
		public @NonNull MAP_mmapHelper__Attribute__qvtr__speculated__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapHelper__Attribute__qvtr__speculated__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOperationCallExp__Operation__qvtr__speculated__ = new AbstractInvocationConstructor(invocationManager, "mmapOperationCallExp__Operation__qvtr__speculated__", false, lazyCreateInterval(6))
	{
		@Override
		public @NonNull MAP_mmapOperationCallExp__Operation__qvtr__speculated__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperationCallExp__Operation__qvtr__speculated__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOperationCallExp__Helper__qvtr__speculated__ = new AbstractInvocationConstructor(invocationManager, "mmapOperationCallExp__Helper__qvtr__speculated__", false, lazyCreateInterval(6))
	{
		@Override
		public @NonNull MAP_mmapOperationCallExp__Helper__qvtr__speculated__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperationCallExp__Helper__qvtr__speculated__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapNavigationOrAttributeCallExp__Helper__qvtr__spe = new AbstractInvocationConstructor(invocationManager, "mmapNavigationOrAttributeCallExp__Helper__qvtr__spe", false, lazyCreateInterval(6))
	{
		@Override
		public @NonNull MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__spe newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__spe(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOperationCallExp__Operation__qvtr__edge5__refer = new AbstractInvocationConstructor(invocationManager, "mmapOperationCallExp__Operation__qvtr__edge5__refer", false, lazyCreateInterval(10))
	{
		@Override
		public @NonNull MAP_mmapOperationCallExp__Operation__qvtr__edge5__refer newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperationCallExp__Operation__qvtr__edge5__refer(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOperatorCallExp__qvtr__edge5__referredOperation = new AbstractInvocationConstructor(invocationManager, "mmapOperatorCallExp__qvtr__edge5__referredOperation", false, lazyCreateInterval(10))
	{
		@Override
		public @NonNull MAP_mmapOperatorCallExp__qvtr__edge5__referredOperation newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperatorCallExp__qvtr__edge5__referredOperation(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapIfExp__qvtr__edge7__type__ = new AbstractInvocationConstructor(invocationManager, "mmapIfExp__qvtr__edge7__type__", false, lazyCreateInterval(10))
	{
		@Override
		public @NonNull MAP_mmapIfExp__qvtr__edge7__type__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapIfExp__qvtr__edge7__type__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapNavigationOrAttributeCallExp__Property__qvtr__e_1 = new AbstractInvocationConstructor(invocationManager, "mmapNavigationOrAttributeCallExp__Property__qvtr__e_1", false, lazyCreateInterval(10))
	{
		@Override
		public @NonNull MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__e_1 newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__e_1(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOperatorCallExp__qvtr__edge6__type__ = new AbstractInvocationConstructor(invocationManager, "mmapOperatorCallExp__qvtr__edge6__type__", false, lazyCreateInterval(11))
	{
		@Override
		public @NonNull MAP_mmapOperatorCallExp__qvtr__edge6__type__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperatorCallExp__qvtr__edge6__type__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapOperationCallExp__Operation__qvtr__edge6__type_ = new AbstractInvocationConstructor(invocationManager, "mmapOperationCallExp__Operation__qvtr__edge6__type_", false, lazyCreateInterval(11))
	{
		@Override
		public @NonNull MAP_mmapOperationCallExp__Operation__qvtr__edge6__type_ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapOperationCallExp__Operation__qvtr__edge6__type_(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mmapNavigationOrAttributeCallExp__Property__qvtr__e_2 = new AbstractInvocationConstructor(invocationManager, "mmapNavigationOrAttributeCallExp__Property__qvtr__e_2", false, lazyCreateInterval(11))
	{
		@Override
		public @NonNull MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__e_2 newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__e_2(this, values);
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


	public ATL2QVTr(final @NonNull TransformationExecutor executor) {
		super(executor, new @NonNull String[] {"atl", "qvtr", "middle"}, oppositeIndex2propertyId, classIndex2classId, classIndex2allClassIndexes);
	}

	@Override
	public boolean run() {
		final @NonNull Connection ji_Binding = models[0/*atl*/].getConnection(0/*ATL::Binding*/);
		final @NonNull Connection ji_Helper = models[0/*atl*/].getConnection(1/*ATL::Helper*/);
		final @NonNull Connection ji_InPattern = models[0/*atl*/].getConnection(2/*ATL::InPattern*/);
		final @NonNull Connection ji_MatchedRule = models[0/*atl*/].getConnection(3/*ATL::MatchedRule*/);
		final @NonNull Connection ji_Module = models[0/*atl*/].getConnection(4/*ATL::Module*/);
		final @NonNull Connection ji_NavigationOrAttributeCallExp = models[0/*atl*/].getConnection(5/*OCL::NavigationOrAttributeCallExp*/);
		final @NonNull Connection ji_OclExpression = models[0/*atl*/].getConnection(6/*OCL::OclExpression*/);
		final @NonNull Connection ji_OclModel = models[0/*atl*/].getConnection(7/*OCL::OclModel*/);
		final @NonNull Connection ji_OperationCallExp = models[0/*atl*/].getConnection(8/*OCL::OperationCallExp*/);
		final @NonNull Connection ji_SimpleInPatternElement = models[0/*atl*/].getConnection(9/*ATL::SimpleInPatternElement*/);
		final @NonNull Connection ji_SimpleOutPatternElement = models[0/*atl*/].getConnection(10/*ATL::SimpleOutPatternElement*/);
		final @NonNull Connection ji_VariableExp = models[0/*atl*/].getConnection(11/*OCL::VariableExp*/);
		CTOR_r_atl2qvtr____load__.invoke(ji_Binding, ji_Helper, ji_InPattern, ji_MatchedRule, ji_Module, ji_NavigationOrAttributeCallExp, ji_OclExpression, ji_OclModel, ji_OperationCallExp, ji_SimpleInPatternElement, ji_SimpleOutPatternElement, ji_VariableExp);
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
		protected final /*@Thrown*/ @NonNull Type instance;

		@SuppressWarnings("null")
		public FUN_getCommonType(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.type1 = (@NonNull Type)boundValues[1];
			this.type2 = (@NonNull Type)boundValues[2];
			this.instance = org.eclipse.qvtd.atl.atl2qvtr.utilities.Helper4getCommonType.INSTANCE.evaluate(executor, CLSSid_Type, this, type1, type2);
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
			final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure_0 = executor.getStaticTypeOfValue(null, oclAsSet);
			final LibraryIteration.@NonNull LibraryIterationExtension IMPL_closure_0 = (LibraryIteration.LibraryIterationExtension)TYPE_closure_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
			final @NonNull Object ACC_closure_0 = IMPL_closure_0.createAccumulatorValue(executor, SET_CLSSid_OclElement, CLSSid_OclElement);
			/**
			 * Implementation of the iterator body.
			 */
			final @NonNull AbstractBinaryOperation BODY_closure_0 = new AbstractBinaryOperation()
			{
				/**
				 * e.oclContainer()
				 */
				@Override
				public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ @Nullable Object e_0) {
					final /*@Thrown*/ @Nullable Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, e_0);
					return oclContainer;
				}
			};
			final @NonNull ExecutorSingleIterationManager MGR_closure_0 = new ExecutorSingleIterationManager(executor, SET_CLSSid_OclElement, BODY_closure_0, oclAsSet, ACC_closure_0);
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull SetValue closure = (@NonNull SetValue)IMPL_closure_0.evaluateIteration(MGR_closure_0);
			final /*@Thrown*/ @NonNull SetValue helpers = (@Nullable SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, closure, TYP_ATL_c_c_Helper_0);
			final /*@Thrown*/ boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(helpers).booleanValue();
			/*@Thrown*/ @Nullable Helper symbol_0;
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
					if (ValueUtil.TRUE_VALUE != ValueUtil.FALSE_VALUE) {			// Carry on till something found
						any = _1;
						break;
					}
				}
				symbol_0 = any;
			}
			else {
				symbol_0 = null;
			}
			this.instance = symbol_0;
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

		@SuppressWarnings("null")
		public FUN_getModule(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.element_0 = (@Nullable LocatedElement)boundValues[1];
			this.instance = org.eclipse.qvtd.atl.atl2qvtr.utilities.Helper4getModule.INSTANCE.evaluate(executor, CLSSid_Module, this, element_0);
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
		protected final /*@Thrown*/ @NonNull Operation instance;

		@SuppressWarnings("null")
		public FUN_getOperation(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.type = (@NonNull Type)boundValues[1];
			this.name = (@NonNull String)boundValues[2];
			this.instance = org.eclipse.qvtd.atl.atl2qvtr.utilities.Helper4getOperation.INSTANCE.evaluate(executor, CLSSid_Operation_0, this, type, name);
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
		protected final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Package instance;

		@SuppressWarnings("null")
		public FUN_getPackage(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.atlModule_0 = (@NonNull Module)boundValues[1];
			this.name_0 = (@NonNull String)boundValues[2];
			this.instance = org.eclipse.qvtd.atl.atl2qvtr.utilities.Helper4getPackage.INSTANCE.evaluate(executor, CLSSid_Package, this, atlModule_0, name_0);
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
		protected final /*@Thrown*/ @NonNull Property instance;

		@SuppressWarnings("null")
		public FUN_getProperty(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.type_0 = (@NonNull Type)boundValues[1];
			this.name_1 = (@NonNull String)boundValues[2];
			this.instance = org.eclipse.qvtd.atl.atl2qvtr.utilities.Helper4getProperty.INSTANCE.evaluate(executor, CLSSid_Property, this, type_0, name_1);
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

		@SuppressWarnings("null")
		public FUN_getType(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.type_1 = (@Nullable OclType)boundValues[1];
			this.instance = org.eclipse.qvtd.atl.atl2qvtr.utilities.Helper4getType.INSTANCE.evaluate(executor, CLSSid_Class, this, type_1);
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
	 * map r_atl2qvtr____load__ in ATL2QVTr {
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
	 * ::jm_DmapHelper : trace_ATL2QVTr::DmapHelper[1]::jm_DmapOclExpression : trace_ATL2QVTr::DmapOclExpression[1]::jm_DmapVariableExp__referredVariable : trace_ATL2QVTr::DmapVariableExp_referredVariable[1]::jm_TmapBinding : trace_ATL2QVTr::TmapBinding[1]::jm_TmapBooleanExp : trace_ATL2QVTr::TmapBooleanExp[1]::jm_TmapHelper__Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1]::jm_TmapHelper__Context : trace_ATL2QVTr::TmapHelper_Context[1]::jm_TmapHelper__Operation : trace_ATL2QVTr::TmapHelper_Operation[1]::jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1]::jm_TmapInPattern : trace_ATL2QVTr::TmapInPattern[1]::jm_TmapInPattern__filter : trace_ATL2QVTr::TmapInPattern_filter[1]::jm_TmapIntegerExp : trace_ATL2QVTr::TmapIntegerExp[1]::jm_TmapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1]::jm_TmapMatchedRule__super : trace_ATL2QVTr::TmapMatchedRule_super[1]::jm_TmapModule : trace_ATL2QVTr::TmapModule[1]::jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1]::jm_TmapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1]::jm_TmapOclMetamodel : trace_ATL2QVTr::TmapOclMetamodel[1]::jm_TmapOclModel__IN : trace_ATL2QVTr::TmapOclModel_IN[1]::jm_TmapOclModel__OUT : trace_ATL2QVTr::TmapOclModel_OUT[1]::jm_TmapOclType : trace_ATL2QVTr::TmapOclType[1]::jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1]::jm_TmapOperationCallExp__Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1]::jm_TmapOperationCallExp__argument : trace_ATL2QVTr::TmapOperationCallExp_argument[1]::jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1]::jm_TmapSimpleInPatternElement : trace_ATL2QVTr::TmapSimpleInPatternElement[1]::jm_TmapSimpleOutPatternElement : trace_ATL2QVTr::TmapSimpleOutPatternElement[1]::jm_TmapStringExp : trace_ATL2QVTr::TmapStringExp[1]::jm_TmapVariable : trace_ATL2QVTr::TmapVariable[1]::jm_TmapVariableExp : trace_ATL2QVTr::TmapVariableExp[1]::jm_TmapVariableExp__referredVariable__Helper : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1]::jm_TmapVariableExp__referredVariable__VariableDecl : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1]::jo_OperationCallExp : OperationCallExp[1]::jo_PropertyCallExp : PropertyCallExp[1]::jo_VariableExp : VariableExp[1]install mmapInPattern__filter__qvtr__activator__ {
	 * atlPattern consumes append ji_InPattern  : ATL::InPattern[1];
	 * ;
	 * jm_TmapInPattern__filter appendsTo jm_TmapInPattern__filter;
	 * }
	 *   install mmapSimpleOutPatternElement__qvtr__activator__ {
	 * atlElement consumes append ji_SimpleOutPatternElement  : ATL::SimpleOutPatternElement[1];
	 * ;
	 * jm_TmapSimpleOutPatternElement appendsTo jm_TmapSimpleOutPatternElement;
	 * }
	 *   install mmapMatchedRule__qvtr__activator__ {
	 * jm_TmapMatchedRule appendsTo jm_TmapMatchedRule;
	 * matchedRule consumes append ji_MatchedRule  : ATL::MatchedRule[1];
	 * ;
	 * }
	 *   install mmapBinding__qvtr__activator__ {
	 * atlBinding consumes append ji_Binding  : ATL::Binding[1];
	 * ;
	 * jm_TmapBinding appendsTo jm_TmapBinding;
	 * }
	 *   install mmapOclModel__IN__qvtr__activator__ {
	 * jm_TmapOclModel__IN appendsTo jm_TmapOclModel__IN;
	 * oclModel consumes append ji_OclModel  : OCL::OclModel[1];
	 * ;
	 * }
	 *   install mmapOclMetamodel__qvtr__activator__ {
	 * jm_TmapOclMetamodel appendsTo jm_TmapOclMetamodel;
	 * oclMetamodel consumes append ji_OclModel  : OCL::OclModel[1];
	 * ;
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
	 *   install mmapSimpleInPatternElement__qvtr__activator__ {
	 * atlElement consumes append ji_SimpleInPatternElement  : ATL::SimpleInPatternElement[1];
	 * ;
	 * jm_TmapSimpleInPatternElement appendsTo jm_TmapSimpleInPatternElement;
	 * }
	 *   install mmapOperationCallExp__argument__qvtr__activator__ {
	 * atlArgument consumes append ji_OclExpression  : OCL::OclExpression[1];
	 * ;
	 * jm_TmapOperationCallExp__argument appendsTo jm_TmapOperationCallExp__argument;
	 * }
	 *   install mmapModule__qvtr__activator__ {
	 * atlModule consumes append ji_Module  : ATL::Module[1];
	 * ;
	 * jm_TmapModule appendsTo jm_TmapModule;
	 * }
	 *   install mmapMatchedRule__super__qvtr__activator__ {
	 * atlChildRule consumes append ji_MatchedRule  : ATL::MatchedRule[1];
	 * ;
	 * jm_TmapMatchedRule__super appendsTo jm_TmapMatchedRule__super;
	 * }
	 *   install mmapHelper__dispatch__qvtr {
	 * atlHelper consumes append ji_Helper  : ATL::Helper[1];
	 * ;
	 * jm_DmapHelper appendsTo jm_DmapHelper;
	 * jm_TmapHelper__Attribute appendsTo jm_TmapHelper__Attribute;
	 * jm_TmapHelper__Operation appendsTo jm_TmapHelper__Operation;
	 * }
	 *   install mmapOclModel__OUT__qvtr__activator__ {
	 * jm_TmapOclModel__OUT appendsTo jm_TmapOclModel__OUT;
	 * oclModel consumes append ji_OclModel  : OCL::OclModel[1];
	 * ;
	 * }
	 *   install mmapInPattern__qvtr__activator__ {
	 * atlPattern consumes append ji_InPattern  : ATL::InPattern[1];
	 * ;
	 * jm_TmapInPattern appendsTo jm_TmapInPattern;
	 * }
	 *   install mmapVariableExp__qvtr {
	 * jm_DmapVariableExp__referredVariable appendsTo jm_DmapVariableExp__referredVariable;
	 * jo_VariableExp appendsTo jo_VariableExp;
	 * trace consumes ::jm_TmapVariableExp : trace_ATL2QVTr::TmapVariableExp[1];
	 * }
	 *   install mmapIntegerExp__qvtr {
	 * trace consumes ::jm_TmapIntegerExp : trace_ATL2QVTr::TmapIntegerExp[1];
	 * }
	 *   install mmapOclMetamodel__qvtr__residue__ {
	 * trace consumes ::jm_TmapOclMetamodel : trace_ATL2QVTr::TmapOclMetamodel[1];
	 * }
	 *   install mmapStringExp__qvtr {
	 * trace consumes ::jm_TmapStringExp : trace_ATL2QVTr::TmapStringExp[1];
	 * }
	 *   install mmapOclType__qvtr {
	 * trace consumes ::jm_TmapOclType : trace_ATL2QVTr::TmapOclType[1];
	 * }
	 *   install mmapModule__qvtr__residue__ {
	 * trace consumes ::jm_TmapModule : trace_ATL2QVTr::TmapModule[1];
	 * }
	 *   install mmapBooleanExp__qvtr {
	 * trace consumes ::jm_TmapBooleanExp : trace_ATL2QVTr::TmapBooleanExp[1];
	 * }
	 *   install mmapOclModel__IN__qvtr__residue__ {
	 * trace consumes ::jm_TmapOclModel__IN : trace_ATL2QVTr::TmapOclModel_IN[1];
	 * }
	 *   install mmapVariableExp__referredVariable__dispatch__qvtr {
	 * dispatcher consumes ::jm_DmapVariableExp__referredVariable : trace_ATL2QVTr::DmapVariableExp_referredVariable[1];
	 * jm_TmapVariableExp__referredVariable__Helper appendsTo jm_TmapVariableExp__referredVariable__Helper;
	 * jm_TmapVariableExp__referredVariable__VariableDecl appendsTo jm_TmapVariableExp__referredVariable__VariableDecl;
	 * }
	 *   install mmapMatchedRule__qvtr__residue__ {
	 * trace consumes ::jm_TmapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1];
	 * }
	 *   install mmapOclModel__OUT__qvtr__residue__ {
	 * trace consumes ::jm_TmapOclModel__OUT : trace_ATL2QVTr::TmapOclModel_OUT[1];
	 * }
	 *   install mmapHelper__Attribute__qvtr__local__ {
	 * trace consumes ::jm_TmapHelper__Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * }
	 *   install mmapHelper__Operation__qvtr__local__ {
	 * trace consumes ::jm_TmapHelper__Operation : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * }
	 *   install mmapOperationCallExp__Helper__qvtr__local__ {
	 * trace consumes ::jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * }
	 *   install mmapIfExp__qvtr__local__ {
	 * trace consumes ::jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Helper__qvtr__loc {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install mmapOperatorCallExp__qvtr__local__ {
	 * trace consumes ::jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Property__qvtr__l {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * }
	 *   install mmapOperationCallExp__Operation__qvtr__global__ {
	 * trace consumes ::jm_TmapOperationCallExp__Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * }
	 *   install mmapOperationCallExp__Operation__qvtr__local__ {
	 * trace consumes ::jm_TmapOperationCallExp__Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Helper__qvtr__glo {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install mmapOperationCallExp__Helper__qvtr__global__ {
	 * trace consumes ::jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * }
	 *   install mmapHelper__Operation__qvtr__global__ {
	 * trace consumes ::jm_TmapHelper__Operation : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * }
	 *   install mmapIfExp__qvtr__global__ {
	 * trace consumes ::jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Property__qvtr__g {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * }
	 *   install mmapHelper__Attribute__qvtr__global__ {
	 * trace consumes ::jm_TmapHelper__Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * }
	 *   install mmapOperatorCallExp__qvtr__global__ {
	 * trace consumes ::jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * }
	 *   install mmapOclExpression__verdict__qvtr {
	 * mapOclExpression consumes ::jm_DmapOclExpression : trace_ATL2QVTr::DmapOclExpression[1];
	 * }
	 *   install mmapHelper__Operation__qvtr__speculated__ {
	 * jm_TmapHelper__Context appendsTo jm_TmapHelper__Context;
	 * trace consumes ::jm_TmapHelper__Operation : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * }
	 *   install mmapOperatorCallExp__qvtr__speculated__ {
	 * jo_OperationCallExp appendsTo jo_OperationCallExp;
	 * trace consumes ::jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Property__qvtr__s {
	 * jo_PropertyCallExp appendsTo jo_PropertyCallExp;
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * }
	 *   install mmapHelper__Attribute__qvtr__speculated__ {
	 * jm_TmapHelper__Context appendsTo jm_TmapHelper__Context;
	 * trace consumes ::jm_TmapHelper__Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * }
	 *   install mmapOperationCallExp__Operation__qvtr__speculated__ {
	 * jo_OperationCallExp appendsTo jo_OperationCallExp;
	 * trace consumes ::jm_TmapOperationCallExp__Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * }
	 *   install mmapIfExp__qvtr__speculated__ {
	 * trace consumes ::jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * }
	 *   install mmapHelper__verdict__qvtr {
	 * mapHelper consumes ::jm_DmapHelper : trace_ATL2QVTr::DmapHelper[1];
	 * }
	 *   install mmapOperationCallExp__Helper__qvtr__speculated__ {
	 * jo_OperationCallExp appendsTo jo_OperationCallExp;
	 * jo_VariableExp appendsTo jo_VariableExp;
	 * trace consumes ::jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Helper__qvtr__spe {
	 * jo_OperationCallExp appendsTo jo_OperationCallExp;
	 * jo_VariableExp appendsTo jo_VariableExp;
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install mmapHelper__Operation__qvtr__edge4__type__ {
	 * trace consumes ::jm_TmapHelper__Operation : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Helper__qvtr__edg {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install mmapHelper__Attribute__qvtr__edge4__type__ {
	 * trace consumes ::jm_TmapHelper__Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * }
	 *   install mmapOperationCallExp__Helper__qvtr__edge8__referred {
	 * trace consumes ::jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * }
	 *   install mmapInPattern__qvtr__residue__ {
	 * trace consumes ::jm_TmapInPattern : trace_ATL2QVTr::TmapInPattern[1];
	 * }
	 *   install mmapSimpleOutPatternElement__qvtr__residue__ {
	 * jm_TmapVariable appendsTo jm_TmapVariable;
	 * trace consumes ::jm_TmapSimpleOutPatternElement : trace_ATL2QVTr::TmapSimpleOutPatternElement[1];
	 * }
	 *   install mmapHelper__Context__qvtr {
	 * jm_TmapVariable appendsTo jm_TmapVariable;
	 * trace consumes ::jm_TmapHelper__Context : trace_ATL2QVTr::TmapHelper_Context[1];
	 * }
	 *   install mmapMatchedRule__super__qvtr__residue__ {
	 * trace consumes ::jm_TmapMatchedRule__super : trace_ATL2QVTr::TmapMatchedRule_super[1];
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_1 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install mmapSimpleInPatternElement__qvtr__residue__ {
	 * jm_TmapVariable appendsTo jm_TmapVariable;
	 * trace consumes ::jm_TmapSimpleInPatternElement : trace_ATL2QVTr::TmapSimpleInPatternElement[1];
	 * }
	 *   install mmapOperationCallExp__Helper__qvtr__edge9__type__ {
	 * trace consumes ::jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_3 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install mmapIfExp__qvtr__edge5__ownedThen__edge4__ownedCond {
	 * trace consumes ::jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * }
	 *   install mmapOperationCallExp__argument__qvtr__residue__ {
	 * trace consumes ::jm_TmapOperationCallExp__argument : trace_ATL2QVTr::TmapOperationCallExp_argument[1];
	 * }
	 *   install mmapOperationCallExp__Helper__qvtr__edge4__referred {
	 * trace consumes ::jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * }
	 *   install mmapOperatorCallExp__qvtr__edge4__ownedSource__ {
	 * trace consumes ::jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * }
	 *   install mmapInPattern__filter__qvtr__residue__ {
	 * trace consumes ::jm_TmapInPattern__filter : trace_ATL2QVTr::TmapInPattern_filter[1];
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_2 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install mmapHelper__Operation__qvtr__edge5__queryExpression {
	 * trace consumes ::jm_TmapHelper__Operation : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * }
	 *   install mmapVariable__qvtr {
	 * trace consumes ::jm_TmapVariable : trace_ATL2QVTr::TmapVariable[1];
	 * }
	 *   install mmapIfExp__qvtr__edge5__ownedThen__edge4__ownedCond {
	 * trace consumes ::jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * }
	 *   install mmapHelper__Attribute__qvtr__edge5__queryExpression {
	 * trace consumes ::jm_TmapHelper__Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * }
	 *   install mmapOperationCallExp__Helper__qvtr__edge7__ownedArg {
	 * trace consumes ::jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * }
	 *   install mmapBinding__qvtr__residue__ {
	 * trace consumes ::jm_TmapBinding : trace_ATL2QVTr::TmapBinding[1];
	 * }
	 *   install mmapOperationCallExp__Operation__qvtr__edge4__owned {
	 * trace consumes ::jm_TmapOperationCallExp__Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Property__qvtr__e {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * }
	 *   install mmapIfExp__qvtr__edge5__ownedThen__edge4__ownedCond {
	 * trace consumes ::jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * }
	 *   install mmapVariableExp__referredVariable__VariableDeclarat {
	 * trace consumes ::jm_TmapVariableExp__referredVariable__VariableDecl : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1];
	 * }
	 *   install mmapOperationCallExp__Operation__qvtr__edge5__refer {
	 * trace consumes ::jm_TmapOperationCallExp__Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * }
	 *   install mmapVariableExp__referredVariable__Helper__qvtr {
	 * trace consumes ::jm_TmapVariableExp__referredVariable__Helper : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * }
	 *   install mmapIfExp__qvtr__edge7__type__ {
	 * trace consumes ::jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Property__qvtr__e_1 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * }
	 *   install mmapOperatorCallExp__qvtr__edge5__referredOperation {
	 * trace consumes ::jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * }
	 *   install mmapOperationCallExp__Operation__qvtr__edge6__type_ {
	 * trace consumes ::jm_TmapOperationCallExp__Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Property__qvtr__e_2 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * }
	 *   install mmapOperationCallExp__Helper__qvtr__edge6__name__ed {
	 * trace consumes ::jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * }
	 *   install mmapOperatorCallExp__qvtr__edge6__type__ {
	 * trace consumes ::jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * }
	 *   install mmapVariableExp__referredVariable__verdict__qvtr {
	 * mapVariableExp_referredVariable consumes ::jm_DmapVariableExp__referredVariable : trace_ATL2QVTr::DmapVariableExp_referredVariable[1];
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_4 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install mmapOperationCallExp__Helper__qvtr__edge6__name__ed {
	 * trace consumes ::jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * }
	 *   install mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_4 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 */
	protected class MAP_r_atl2qvtr____load__ extends AbstractInvocation
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

		public MAP_r_atl2qvtr____load__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
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
			final @NonNull Connection jm_DmapHelper_1 = rootInterval.createConnection("jm_DmapHelper", CLSSid_DmapHelper, false, modeFactory);
			final @NonNull Connection jm_DmapOclExpression_1 = rootInterval.createConnection("jm_DmapOclExpression", CLSSid_DmapOclExpression, false, modeFactory);
			final @NonNull Connection jm_DmapVariableExp__referredVariable_1 = rootInterval.createConnection("jm_DmapVariableExp__referredVariable", CLSSid_DmapVariableExp_referredVariable, false, modeFactory);
			final @NonNull Connection jm_TmapBinding_1 = rootInterval.createConnection("jm_TmapBinding", CLSSid_TmapBinding, false, modeFactory);
			final @NonNull Connection jm_TmapBooleanExp_1 = rootInterval.createConnection("jm_TmapBooleanExp", CLSSid_TmapBooleanExp, false, modeFactory);
			final @NonNull Connection jm_TmapHelper__Attribute_1 = rootInterval.createConnection("jm_TmapHelper__Attribute", CLSSid_TmapHelper_Attribute, false, modeFactory);
			final @NonNull Connection jm_TmapHelper__Context_3 = rootInterval.createConnection("jm_TmapHelper__Context", CLSSid_TmapHelper_Context, false, modeFactory);
			final @NonNull Connection jm_TmapHelper__Operation_1 = rootInterval.createConnection("jm_TmapHelper__Operation", CLSSid_TmapHelper_Operation, false, modeFactory);
			final @NonNull Connection jm_TmapIfExp_1 = rootInterval.createConnection("jm_TmapIfExp", CLSSid_TmapIfExp, false, modeFactory);
			final @NonNull Connection jm_TmapInPattern_1 = rootInterval.createConnection("jm_TmapInPattern", CLSSid_TmapInPattern, false, modeFactory);
			final @NonNull Connection jm_TmapInPattern__filter_1 = rootInterval.createConnection("jm_TmapInPattern__filter", CLSSid_TmapInPattern_filter, false, modeFactory);
			final @NonNull Connection jm_TmapIntegerExp_1 = rootInterval.createConnection("jm_TmapIntegerExp", CLSSid_TmapIntegerExp, false, modeFactory);
			final @NonNull Connection jm_TmapMatchedRule_1 = rootInterval.createConnection("jm_TmapMatchedRule", CLSSid_TmapMatchedRule, false, modeFactory);
			final @NonNull Connection jm_TmapMatchedRule__super_1 = rootInterval.createConnection("jm_TmapMatchedRule__super", CLSSid_TmapMatchedRule_super, false, modeFactory);
			final @NonNull Connection jm_TmapModule_1 = rootInterval.createConnection("jm_TmapModule", CLSSid_TmapModule, false, modeFactory);
			final @NonNull Connection jm_TmapNavigationOrAttributeCallExp__Helper_1 = rootInterval.createConnection("jm_TmapNavigationOrAttributeCallExp__Helper", CLSSid_TmapNavigationOrAttributeCallExp_Helper, false, modeFactory);
			final @NonNull Connection jm_TmapNavigationOrAttributeCallExp__Property_1 = rootInterval.createConnection("jm_TmapNavigationOrAttributeCallExp__Property", CLSSid_TmapNavigationOrAttributeCallExp_Property, false, modeFactory);
			final @NonNull Connection jm_TmapOclMetamodel_1 = rootInterval.createConnection("jm_TmapOclMetamodel", CLSSid_TmapOclMetamodel, false, modeFactory);
			final @NonNull Connection jm_TmapOclModel__IN_1 = rootInterval.createConnection("jm_TmapOclModel__IN", CLSSid_TmapOclModel_IN, false, modeFactory);
			final @NonNull Connection jm_TmapOclModel__OUT_1 = rootInterval.createConnection("jm_TmapOclModel__OUT", CLSSid_TmapOclModel_OUT, false, modeFactory);
			final @NonNull Connection jm_TmapOclType_1 = rootInterval.createConnection("jm_TmapOclType", CLSSid_TmapOclType, false, modeFactory);
			final @NonNull Connection jm_TmapOperationCallExp__Helper_1 = rootInterval.createConnection("jm_TmapOperationCallExp__Helper", CLSSid_TmapOperationCallExp_Helper, false, modeFactory);
			final @NonNull Connection jm_TmapOperationCallExp__Operation_1 = rootInterval.createConnection("jm_TmapOperationCallExp__Operation", CLSSid_TmapOperationCallExp_Operation, false, modeFactory);
			final @NonNull Connection jm_TmapOperationCallExp__argument_1 = rootInterval.createConnection("jm_TmapOperationCallExp__argument", CLSSid_TmapOperationCallExp_argument, false, modeFactory);
			final @NonNull Connection jm_TmapOperatorCallExp_1 = rootInterval.createConnection("jm_TmapOperatorCallExp", CLSSid_TmapOperatorCallExp, false, modeFactory);
			final @NonNull Connection jm_TmapSimpleInPatternElement_1 = rootInterval.createConnection("jm_TmapSimpleInPatternElement", CLSSid_TmapSimpleInPatternElement, false, modeFactory);
			final @NonNull Connection jm_TmapSimpleOutPatternElement_1 = rootInterval.createConnection("jm_TmapSimpleOutPatternElement", CLSSid_TmapSimpleOutPatternElement, false, modeFactory);
			final @NonNull Connection jm_TmapStringExp_1 = rootInterval.createConnection("jm_TmapStringExp", CLSSid_TmapStringExp, false, modeFactory);
			final @NonNull Connection jm_TmapVariable_5 = rootInterval.createConnection("jm_TmapVariable", CLSSid_TmapVariable, false, modeFactory);
			final @NonNull Connection jm_TmapVariableExp_1 = rootInterval.createConnection("jm_TmapVariableExp", CLSSid_TmapVariableExp, false, modeFactory);
			final @NonNull Connection jm_TmapVariableExp__referredVariable__Helper_1 = rootInterval.createConnection("jm_TmapVariableExp__referredVariable__Helper", CLSSid_TmapVariableExp_referredVariable_Helper, false, modeFactory);
			final @NonNull Connection jm_TmapVariableExp__referredVariable__VariableDecl_1 = rootInterval.createConnection("jm_TmapVariableExp__referredVariable__VariableDecl", CLSSid_TmapVariableExp_referredVariable_VariableDeclaration, false, modeFactory);
			final @NonNull Connection jo_OperationCallExp_7 = rootInterval.createConnection("jo_OperationCallExp", CLSSid_OperationCallExp_0, false, modeFactory);
			final @NonNull Connection jo_PropertyCallExp_1 = rootInterval.createConnection("jo_PropertyCallExp", CLSSid_PropertyCallExp, false, modeFactory);
			final @NonNull Connection jo_VariableExp_5 = rootInterval.createConnection("jo_VariableExp", CLSSid_VariableExp_0, false, modeFactory);
			// mapping statements
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapInPattern__filter__qvtr__activator__") {
				@Override
				public boolean execute() {
					for (@NonNull InPattern atlPattern_1 : ji_InPattern.typedIterable(InPattern.class)) {
						MAP_mmapInPattern__filter__qvtr__activator__(atlPattern_1, jm_TmapInPattern__filter_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapSimpleOutPatternElement__qvtr__activator__") {
				@Override
				public boolean execute() {
					for (@NonNull SimpleOutPatternElement atlElement_1 : ji_SimpleOutPatternElement.typedIterable(SimpleOutPatternElement.class)) {
						MAP_mmapSimpleOutPatternElement__qvtr__activator__(atlElement_1, jm_TmapSimpleOutPatternElement_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapMatchedRule__qvtr__activator__") {
				@Override
				public boolean execute() {
					for (@NonNull MatchedRule matchedRule_0 : ji_MatchedRule.typedIterable(MatchedRule.class)) {
						MAP_mmapMatchedRule__qvtr__activator__(jm_TmapMatchedRule_1, matchedRule_0);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapBinding__qvtr__activator__") {
				@Override
				public boolean execute() {
					for (@NonNull Binding atlBinding_0 : ji_Binding.typedIterable(Binding.class)) {
						MAP_mmapBinding__qvtr__activator__(atlBinding_0, jm_TmapBinding_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapOclModel__IN__qvtr__activator__") {
				@Override
				public boolean execute() {
					for (@NonNull OclModel oclModel_1 : ji_OclModel.typedIterable(OclModel.class)) {
						MAP_mmapOclModel__IN__qvtr__activator__(jm_TmapOclModel__IN_1, oclModel_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapOclMetamodel__qvtr__activator__") {
				@Override
				public boolean execute() {
					for (@NonNull OclModel oclMetamodel_0 : ji_OclModel.typedIterable(OclModel.class)) {
						MAP_mmapOclMetamodel__qvtr__activator__(jm_TmapOclMetamodel_1, oclMetamodel_0);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapOclExpression__dispatch__qvtr") {
				@Override
				public boolean execute() {
					for (@NonNull OclExpression atlExpression_0 : ji_OclExpression.typedIterable(OclExpression.class)) {
						MAP_mmapOclExpression__dispatch__qvtr(atlExpression_0, jm_DmapOclExpression_1, jm_TmapBooleanExp_1, jm_TmapIfExp_1, jm_TmapIntegerExp_1, jm_TmapNavigationOrAttributeCallExp__Helper_1, jm_TmapNavigationOrAttributeCallExp__Property_1, jm_TmapOclType_1, jm_TmapOperationCallExp__Helper_1, jm_TmapOperationCallExp__Operation_1, jm_TmapOperatorCallExp_1, jm_TmapStringExp_1, jm_TmapVariableExp_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapSimpleInPatternElement__qvtr__activator__") {
				@Override
				public boolean execute() {
					for (@NonNull SimpleInPatternElement atlElement_2 : ji_SimpleInPatternElement.typedIterable(SimpleInPatternElement.class)) {
						MAP_mmapSimpleInPatternElement__qvtr__activator__(atlElement_2, jm_TmapSimpleInPatternElement_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapOperationCallExp__argument__qvtr__activator__") {
				@Override
				public boolean execute() {
					for (@NonNull OclExpression atlArgument_0 : ji_OclExpression.typedIterable(OclExpression.class)) {
						MAP_mmapOperationCallExp__argument__qvtr__activator__(atlArgument_0, jm_TmapOperationCallExp__argument_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapModule__qvtr__activator__") {
				@Override
				public boolean execute() {
					for (@NonNull Module atlModule_1 : ji_Module.typedIterable(Module.class)) {
						MAP_mmapModule__qvtr__activator__(atlModule_1, jm_TmapModule_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapMatchedRule__super__qvtr__activator__") {
				@Override
				public boolean execute() {
					for (@NonNull MatchedRule atlChildRule_0 : ji_MatchedRule.typedIterable(MatchedRule.class)) {
						MAP_mmapMatchedRule__super__qvtr__activator__(atlChildRule_0, jm_TmapMatchedRule__super_1);
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
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapOclModel__OUT__qvtr__activator__") {
				@Override
				public boolean execute() {
					for (@NonNull OclModel oclModel_2 : ji_OclModel.typedIterable(OclModel.class)) {
						MAP_mmapOclModel__OUT__qvtr__activator__(jm_TmapOclModel__OUT_1, oclModel_2);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mmapInPattern__qvtr__activator__") {
				@Override
				public boolean execute() {
					for (@NonNull InPattern atlPattern_2 : ji_InPattern.typedIterable(InPattern.class)) {
						MAP_mmapInPattern__qvtr__activator__(atlPattern_2, jm_TmapInPattern_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapVariableExp__qvtr") {
				@Override
				public boolean execute() {
					for (@NonNull TmapVariableExp trace_69 : jm_TmapVariableExp_1.typedIterable(TmapVariableExp.class)) {
						MAP_mmapVariableExp__qvtr(jm_DmapVariableExp__referredVariable_1, jo_VariableExp_5, trace_69);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapIntegerExp__qvtr") {
				@Override
				public boolean execute() {
					for (@NonNull TmapIntegerExp trace_70 : jm_TmapIntegerExp_1.typedIterable(TmapIntegerExp.class)) {
						MAP_mmapIntegerExp__qvtr(trace_70);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapOclMetamodel__qvtr__residue__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOclMetamodel trace_71 : jm_TmapOclMetamodel_1.typedIterable(TmapOclMetamodel.class)) {
						MAP_mmapOclMetamodel__qvtr__residue__(trace_71);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapStringExp__qvtr") {
				@Override
				public boolean execute() {
					for (@NonNull TmapStringExp trace_72 : jm_TmapStringExp_1.typedIterable(TmapStringExp.class)) {
						MAP_mmapStringExp__qvtr(trace_72);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapOclType__qvtr") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOclType trace_73 : jm_TmapOclType_1.typedIterable(TmapOclType.class)) {
						MAP_mmapOclType__qvtr(trace_73);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapModule__qvtr__residue__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapModule trace_74 : jm_TmapModule_1.typedIterable(TmapModule.class)) {
						MAP_mmapModule__qvtr__residue__(trace_74);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "mmapBooleanExp__qvtr") {
				@Override
				public boolean execute() {
					for (@NonNull TmapBooleanExp trace_75 : jm_TmapBooleanExp_1.typedIterable(TmapBooleanExp.class)) {
						MAP_mmapBooleanExp__qvtr(trace_75);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapOclModel__IN__qvtr__residue__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOclModel_IN trace_76 : jm_TmapOclModel__IN_1.typedIterable(TmapOclModel_IN.class)) {
						MAP_mmapOclModel__IN__qvtr__residue__(trace_76);
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
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapMatchedRule__qvtr__residue__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapMatchedRule trace_77 : jm_TmapMatchedRule_1.typedIterable(TmapMatchedRule.class)) {
						MAP_mmapMatchedRule__qvtr__residue__(trace_77);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mmapOclModel__OUT__qvtr__residue__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOclModel_OUT trace_78 : jm_TmapOclModel__OUT_1.typedIterable(TmapOclModel_OUT.class)) {
						MAP_mmapOclModel__OUT__qvtr__residue__(trace_78);
					}
					return true;
				}
			};
			CTOR_mmapHelper__Attribute__qvtr__local__.addConsumedConnection(jm_TmapHelper__Attribute_1);
			CTOR_mmapHelper__Operation__qvtr__local__.addConsumedConnection(jm_TmapHelper__Operation_1);
			CTOR_mmapOperationCallExp__Helper__qvtr__local__.addConsumedConnection(jm_TmapOperationCallExp__Helper_1);
			CTOR_mmapIfExp__qvtr__local__.addConsumedConnection(jm_TmapIfExp_1);
			CTOR_mmapNavigationOrAttributeCallExp__Helper__qvtr__loc.addConsumedConnection(jm_TmapNavigationOrAttributeCallExp__Helper_1);
			CTOR_mmapOperatorCallExp__qvtr__local__.addConsumedConnection(jm_TmapOperatorCallExp_1);
			CTOR_mmapNavigationOrAttributeCallExp__Property__qvtr__l.addConsumedConnection(jm_TmapNavigationOrAttributeCallExp__Property_1);
			CTOR_mmapOperationCallExp__Operation__qvtr__global__.addConsumedConnection(jm_TmapOperationCallExp__Operation_1);
			CTOR_mmapOperationCallExp__Operation__qvtr__local__.addConsumedConnection(jm_TmapOperationCallExp__Operation_1);
			CTOR_mmapNavigationOrAttributeCallExp__Helper__qvtr__glo.addConsumedConnection(jm_TmapNavigationOrAttributeCallExp__Helper_1);
			CTOR_mmapOperationCallExp__Helper__qvtr__global__.addConsumedConnection(jm_TmapOperationCallExp__Helper_1);
			CTOR_mmapHelper__Operation__qvtr__global__.addConsumedConnection(jm_TmapHelper__Operation_1);
			CTOR_mmapIfExp__qvtr__global__.addConsumedConnection(jm_TmapIfExp_1);
			CTOR_mmapNavigationOrAttributeCallExp__Property__qvtr__g.addConsumedConnection(jm_TmapNavigationOrAttributeCallExp__Property_1);
			CTOR_mmapHelper__Attribute__qvtr__global__.addConsumedConnection(jm_TmapHelper__Attribute_1);
			CTOR_mmapOperatorCallExp__qvtr__global__.addConsumedConnection(jm_TmapOperatorCallExp_1);
			CTOR_mmapOclExpression__verdict__qvtr.addConsumedConnection(jm_DmapOclExpression_1);
			CTOR_mmapHelper__Operation__qvtr__speculated__.addAppendedConnection(jm_TmapHelper__Context_3);
			CTOR_mmapHelper__Operation__qvtr__speculated__.addConsumedConnection(jm_TmapHelper__Operation_1);
			CTOR_mmapOperatorCallExp__qvtr__speculated__.addAppendedConnection(jo_OperationCallExp_7);
			CTOR_mmapOperatorCallExp__qvtr__speculated__.addConsumedConnection(jm_TmapOperatorCallExp_1);
			CTOR_mmapNavigationOrAttributeCallExp__Property__qvtr__s.addAppendedConnection(jo_PropertyCallExp_1);
			CTOR_mmapNavigationOrAttributeCallExp__Property__qvtr__s.addConsumedConnection(jm_TmapNavigationOrAttributeCallExp__Property_1);
			CTOR_mmapHelper__Attribute__qvtr__speculated__.addAppendedConnection(jm_TmapHelper__Context_3);
			CTOR_mmapHelper__Attribute__qvtr__speculated__.addConsumedConnection(jm_TmapHelper__Attribute_1);
			CTOR_mmapOperationCallExp__Operation__qvtr__speculated__.addAppendedConnection(jo_OperationCallExp_7);
			CTOR_mmapOperationCallExp__Operation__qvtr__speculated__.addConsumedConnection(jm_TmapOperationCallExp__Operation_1);
			CTOR_mmapIfExp__qvtr__speculated__.addConsumedConnection(jm_TmapIfExp_1);
			CTOR_mmapHelper__verdict__qvtr.addConsumedConnection(jm_DmapHelper_1);
			CTOR_mmapOperationCallExp__Helper__qvtr__speculated__.addAppendedConnection(jo_OperationCallExp_7);
			CTOR_mmapOperationCallExp__Helper__qvtr__speculated__.addAppendedConnection(jo_VariableExp_5);
			CTOR_mmapOperationCallExp__Helper__qvtr__speculated__.addConsumedConnection(jm_TmapOperationCallExp__Helper_1);
			CTOR_mmapNavigationOrAttributeCallExp__Helper__qvtr__spe.addAppendedConnection(jo_OperationCallExp_7);
			CTOR_mmapNavigationOrAttributeCallExp__Helper__qvtr__spe.addAppendedConnection(jo_VariableExp_5);
			CTOR_mmapNavigationOrAttributeCallExp__Helper__qvtr__spe.addConsumedConnection(jm_TmapNavigationOrAttributeCallExp__Helper_1);
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapHelper__Operation__qvtr__edge4__type__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapHelper_Operation trace_103 : jm_TmapHelper__Operation_1.typedIterable(TmapHelper_Operation.class)) {
						MAP_mmapHelper__Operation__qvtr__edge4__type__(trace_103);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapNavigationOrAttributeCallExp__Helper__qvtr__edg") {
				@Override
				public boolean execute() {
					for (@NonNull TmapNavigationOrAttributeCallExp_Helper trace_104 : jm_TmapNavigationOrAttributeCallExp__Helper_1.typedIterable(TmapNavigationOrAttributeCallExp_Helper.class)) {
						MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg(trace_104);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapHelper__Attribute__qvtr__edge4__type__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapHelper_Attribute trace_105 : jm_TmapHelper__Attribute_1.typedIterable(TmapHelper_Attribute.class)) {
						MAP_mmapHelper__Attribute__qvtr__edge4__type__(trace_105);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapOperationCallExp__Helper__qvtr__edge8__referred") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperationCallExp_Helper trace_106 : jm_TmapOperationCallExp__Helper_1.typedIterable(TmapOperationCallExp_Helper.class)) {
						MAP_mmapOperationCallExp__Helper__qvtr__edge8__referred(trace_106);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapInPattern__qvtr__residue__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapInPattern trace_107 : jm_TmapInPattern_1.typedIterable(TmapInPattern.class)) {
						MAP_mmapInPattern__qvtr__residue__(trace_107);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapSimpleOutPatternElement__qvtr__residue__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapSimpleOutPatternElement trace_108 : jm_TmapSimpleOutPatternElement_1.typedIterable(TmapSimpleOutPatternElement.class)) {
						MAP_mmapSimpleOutPatternElement__qvtr__residue__(jm_TmapVariable_5, trace_108);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapHelper__Context__qvtr") {
				@Override
				public boolean execute() {
					for (@NonNull TmapHelper_Context trace_109 : jm_TmapHelper__Context_3.typedIterable(TmapHelper_Context.class)) {
						MAP_mmapHelper__Context__qvtr(jm_TmapVariable_5, trace_109);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "mmapMatchedRule__super__qvtr__residue__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapMatchedRule_super trace_110 : jm_TmapMatchedRule__super_1.typedIterable(TmapMatchedRule_super.class)) {
						MAP_mmapMatchedRule__super__qvtr__residue__(trace_110);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(8/*..null*/), "mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_1") {
				@Override
				public boolean execute() {
					for (@NonNull TmapNavigationOrAttributeCallExp_Helper trace_111 : jm_TmapNavigationOrAttributeCallExp__Helper_1.typedIterable(TmapNavigationOrAttributeCallExp_Helper.class)) {
						MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_1(trace_111);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(8/*..null*/), "mmapSimpleInPatternElement__qvtr__residue__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapSimpleInPatternElement trace_112 : jm_TmapSimpleInPatternElement_1.typedIterable(TmapSimpleInPatternElement.class)) {
						MAP_mmapSimpleInPatternElement__qvtr__residue__(jm_TmapVariable_5, trace_112);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(8/*..null*/), "mmapOperationCallExp__Helper__qvtr__edge9__type__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperationCallExp_Helper trace_113 : jm_TmapOperationCallExp__Helper_1.typedIterable(TmapOperationCallExp_Helper.class)) {
						MAP_mmapOperationCallExp__Helper__qvtr__edge9__type__(trace_113);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_3") {
				@Override
				public boolean execute() {
					for (@NonNull TmapNavigationOrAttributeCallExp_Helper trace_114 : jm_TmapNavigationOrAttributeCallExp__Helper_1.typedIterable(TmapNavigationOrAttributeCallExp_Helper.class)) {
						MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_3(trace_114);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapIfExp__qvtr__edge5__ownedThen__edge4__ownedCond") {
				@Override
				public boolean execute() {
					for (@NonNull TmapIfExp trace_115 : jm_TmapIfExp_1.typedIterable(TmapIfExp.class)) {
						MAP_mmapIfExp__qvtr__edge5__ownedThen__edge4__ownedCond(trace_115);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapOperationCallExp__argument__qvtr__residue__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperationCallExp_argument trace_116 : jm_TmapOperationCallExp__argument_1.typedIterable(TmapOperationCallExp_argument.class)) {
						MAP_mmapOperationCallExp__argument__qvtr__residue__(trace_116);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapOperationCallExp__Helper__qvtr__edge4__referred") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperationCallExp_Helper trace_117 : jm_TmapOperationCallExp__Helper_1.typedIterable(TmapOperationCallExp_Helper.class)) {
						MAP_mmapOperationCallExp__Helper__qvtr__edge4__referred(trace_117);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapOperatorCallExp__qvtr__edge4__ownedSource__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperatorCallExp trace_118 : jm_TmapOperatorCallExp_1.typedIterable(TmapOperatorCallExp.class)) {
						MAP_mmapOperatorCallExp__qvtr__edge4__ownedSource__(trace_118);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapInPattern__filter__qvtr__residue__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapInPattern_filter trace_119 : jm_TmapInPattern__filter_1.typedIterable(TmapInPattern_filter.class)) {
						MAP_mmapInPattern__filter__qvtr__residue__(trace_119);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_2") {
				@Override
				public boolean execute() {
					for (@NonNull TmapNavigationOrAttributeCallExp_Helper trace_120 : jm_TmapNavigationOrAttributeCallExp__Helper_1.typedIterable(TmapNavigationOrAttributeCallExp_Helper.class)) {
						MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_2(trace_120);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapHelper__Operation__qvtr__edge5__queryExpression") {
				@Override
				public boolean execute() {
					for (@NonNull TmapHelper_Operation trace_121 : jm_TmapHelper__Operation_1.typedIterable(TmapHelper_Operation.class)) {
						MAP_mmapHelper__Operation__qvtr__edge5__queryExpression(trace_121);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapVariable__qvtr") {
				@Override
				public boolean execute() {
					for (@NonNull TmapVariable trace_122 : jm_TmapVariable_5.typedIterable(TmapVariable.class)) {
						MAP_mmapVariable__qvtr(trace_122);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapIfExp__qvtr__edge5__ownedThen__edge4__ownedCond") {
				@Override
				public boolean execute() {
					for (@NonNull TmapIfExp trace_123 : jm_TmapIfExp_1.typedIterable(TmapIfExp.class)) {
						MAP_mmapIfExp__qvtr__edge5__ownedThen__edge4__ownedCond(trace_123);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapHelper__Attribute__qvtr__edge5__queryExpression") {
				@Override
				public boolean execute() {
					for (@NonNull TmapHelper_Attribute trace_124 : jm_TmapHelper__Attribute_1.typedIterable(TmapHelper_Attribute.class)) {
						MAP_mmapHelper__Attribute__qvtr__edge5__queryExpression(trace_124);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapOperationCallExp__Helper__qvtr__edge7__ownedArg") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperationCallExp_Helper trace_125 : jm_TmapOperationCallExp__Helper_1.typedIterable(TmapOperationCallExp_Helper.class)) {
						MAP_mmapOperationCallExp__Helper__qvtr__edge7__ownedArg(trace_125);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapBinding__qvtr__residue__") {
				@Override
				public boolean execute() {
					for (@NonNull TmapBinding trace_126 : jm_TmapBinding_1.typedIterable(TmapBinding.class)) {
						MAP_mmapBinding__qvtr__residue__(trace_126);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapOperationCallExp__Operation__qvtr__edge4__owned") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperationCallExp_Operation trace_127 : jm_TmapOperationCallExp__Operation_1.typedIterable(TmapOperationCallExp_Operation.class)) {
						MAP_mmapOperationCallExp__Operation__qvtr__edge4__owned(trace_127);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapNavigationOrAttributeCallExp__Property__qvtr__e") {
				@Override
				public boolean execute() {
					for (@NonNull TmapNavigationOrAttributeCallExp_Property trace_128 : jm_TmapNavigationOrAttributeCallExp__Property_1.typedIterable(TmapNavigationOrAttributeCallExp_Property.class)) {
						MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__e(trace_128);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "mmapIfExp__qvtr__edge5__ownedThen__edge4__ownedCond") {
				@Override
				public boolean execute() {
					for (@NonNull TmapIfExp trace_129 : jm_TmapIfExp_1.typedIterable(TmapIfExp.class)) {
						MAP_mmapIfExp__qvtr__edge5__ownedThen__edge4__ownedCond(trace_129);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(10/*..null*/), "mmapVariableExp__referredVariable__VariableDeclarat") {
				@Override
				public boolean execute() {
					for (@NonNull TmapVariableExp_referredVariable_VariableDeclaration trace_130 : jm_TmapVariableExp__referredVariable__VariableDecl_1.typedIterable(TmapVariableExp_referredVariable_VariableDeclaration.class)) {
						MAP_mmapVariableExp__referredVariable__VariableDeclarat(trace_130);
					}
					return true;
				}
			};
			CTOR_mmapOperationCallExp__Operation__qvtr__edge5__refer.addConsumedConnection(jm_TmapOperationCallExp__Operation_1);
			new AbstractSimpleInvocation(lazyCreateInterval(10/*..null*/), "mmapVariableExp__referredVariable__Helper__qvtr") {
				@Override
				public boolean execute() {
					for (@NonNull TmapVariableExp_referredVariable_Helper trace_132 : jm_TmapVariableExp__referredVariable__Helper_1.typedIterable(TmapVariableExp_referredVariable_Helper.class)) {
						MAP_mmapVariableExp__referredVariable__Helper__qvtr(trace_132);
					}
					return true;
				}
			};
			CTOR_mmapIfExp__qvtr__edge7__type__.addConsumedConnection(jm_TmapIfExp_1);
			CTOR_mmapNavigationOrAttributeCallExp__Property__qvtr__e_1.addConsumedConnection(jm_TmapNavigationOrAttributeCallExp__Property_1);
			CTOR_mmapOperatorCallExp__qvtr__edge5__referredOperation.addConsumedConnection(jm_TmapOperatorCallExp_1);
			CTOR_mmapOperationCallExp__Operation__qvtr__edge6__type_.addConsumedConnection(jm_TmapOperationCallExp__Operation_1);
			CTOR_mmapNavigationOrAttributeCallExp__Property__qvtr__e_2.addConsumedConnection(jm_TmapNavigationOrAttributeCallExp__Property_1);
			new AbstractSimpleInvocation(lazyCreateInterval(11/*..null*/), "mmapOperationCallExp__Helper__qvtr__edge6__name__ed") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperationCallExp_Helper trace_138 : jm_TmapOperationCallExp__Helper_1.typedIterable(TmapOperationCallExp_Helper.class)) {
						MAP_mmapOperationCallExp__Helper__qvtr__edge6__name__ed(trace_138);
					}
					return true;
				}
			};
			CTOR_mmapOperatorCallExp__qvtr__edge6__type__.addConsumedConnection(jm_TmapOperatorCallExp_1);
			new AbstractSimpleInvocation(lazyCreateInterval(11/*..null*/), "mmapVariableExp__referredVariable__verdict__qvtr") {
				@Override
				public boolean execute() {
					for (@NonNull DmapVariableExp_referredVariable mapVariableExp_referredVariable_0 : jm_DmapVariableExp__referredVariable_1.typedIterable(DmapVariableExp_referredVariable.class)) {
						MAP_mmapVariableExp__referredVariable__verdict__qvtr(mapVariableExp_referredVariable_0);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(11/*..null*/), "mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_4") {
				@Override
				public boolean execute() {
					for (@NonNull TmapNavigationOrAttributeCallExp_Helper trace_140 : jm_TmapNavigationOrAttributeCallExp__Helper_1.typedIterable(TmapNavigationOrAttributeCallExp_Helper.class)) {
						MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_4(trace_140);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(11/*..null*/), "mmapOperationCallExp__Helper__qvtr__edge6__name__ed") {
				@Override
				public boolean execute() {
					for (@NonNull TmapOperationCallExp_Helper trace_141 : jm_TmapOperationCallExp__Helper_1.typedIterable(TmapOperationCallExp_Helper.class)) {
						MAP_mmapOperationCallExp__Helper__qvtr__edge6__name__ed(trace_141);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(11/*..null*/), "mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_4") {
				@Override
				public boolean execute() {
					for (@NonNull TmapNavigationOrAttributeCallExp_Helper trace_142 : jm_TmapNavigationOrAttributeCallExp__Helper_1.typedIterable(TmapNavigationOrAttributeCallExp_Helper.class)) {
						MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_4(trace_142);
					}
					return true;
				}
			};
			final /*@Thrown*/ @Nullable Boolean r_atl2qvtr____load__ = ValueUtil.TRUE_VALUE;
			return r_atl2qvtr____load__;
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
	 * map mmapInPattern__filter__qvtr__activator__ in ATL2QVTr {
	 * guard:atl atlPattern : ATL::InPattern[1];
	 * append jm_TmapInPattern__filter  : trace_ATL2QVTr::TmapInPattern_filter[1];
	 * new:middle trace : trace_ATL2QVTr::TmapInPattern_filter[1];
	 * set trace.t1atlPattern := atlPattern;
	 * add jm_TmapInPattern__filter += trace;
	 *
	 */
	protected boolean MAP_mmapInPattern__filter__qvtr__activator__(final /*@NonInvalid*/ @NonNull InPattern atlPattern, final @NonNull Connection jm_TmapInPattern__filter)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapInPattern__filter__qvtr__activator__" +
					"\n\t\"atlPattern\":" + toDebugString(atlPattern));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapInPattern_filter trace_69 = trace_ATL2QVTrFactory.eINSTANCE.createTmapInPattern_filter();
		models[2/*middle*/].add(trace_69, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_69));
		}
		// mapping statements
		trace_69.setT1atlPattern(atlPattern);
		jm_TmapInPattern__filter.appendElement(trace_69);
		final /*@Thrown*/ @Nullable Boolean mmapInPattern__filter__qvtr__activator__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapInPattern__filter__qvtr__activator__ ? "done "  : "fail ") + "MAP_mmapInPattern__filter__qvtr__activator__");
		}
		return mmapInPattern__filter__qvtr__activator__;
	}

	/**
	 *
	 * map mmapSimpleOutPatternElement__qvtr__activator__ in ATL2QVTr {
	 * guard:atl atlElement : ATL::SimpleOutPatternElement[1];
	 * append jm_TmapSimpleOutPatternElement  : trace_ATL2QVTr::TmapSimpleOutPatternElement[1];
	 * new:middle trace : trace_ATL2QVTr::TmapSimpleOutPatternElement[1];
	 * set trace.t1atlElement := atlElement;
	 * add jm_TmapSimpleOutPatternElement += trace;
	 *
	 */
	protected boolean MAP_mmapSimpleOutPatternElement__qvtr__activator__(final /*@NonInvalid*/ @NonNull SimpleOutPatternElement atlElement, final @NonNull Connection jm_TmapSimpleOutPatternElement)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapSimpleOutPatternElement__qvtr__activator__" +
					"\n\t\"atlElement\":" + toDebugString(atlElement));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapSimpleOutPatternElement trace_69 = trace_ATL2QVTrFactory.eINSTANCE.createTmapSimpleOutPatternElement();
		models[2/*middle*/].add(trace_69, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_69));
		}
		// mapping statements
		OPPOSITE_OF_TmapSimpleOutPatternElement_t1atlElement.put(atlElement, trace_69);
		trace_69.setT1atlElement(atlElement);
		jm_TmapSimpleOutPatternElement.appendElement(trace_69);
		final /*@Thrown*/ @Nullable Boolean mmapSimpleOutPatternElement__qvtr__activator__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapSimpleOutPatternElement__qvtr__activator__ ? "done "  : "fail ") + "MAP_mmapSimpleOutPatternElement__qvtr__activator__");
		}
		return mmapSimpleOutPatternElement__qvtr__activator__;
	}

	/**
	 *
	 * map mmapMatchedRule__qvtr__activator__ in ATL2QVTr {
	 * guard:atl matchedRule : ATL::MatchedRule[1];
	 * append jm_TmapMatchedRule  : trace_ATL2QVTr::TmapMatchedRule[1];
	 * new:middle trace : trace_ATL2QVTr::TmapMatchedRule[1];
	 * set trace.t1matchedRule := matchedRule;
	 * add jm_TmapMatchedRule += trace;
	 *
	 */
	protected boolean MAP_mmapMatchedRule__qvtr__activator__(final @NonNull Connection jm_TmapMatchedRule, final /*@NonInvalid*/ @NonNull MatchedRule matchedRule)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapMatchedRule__qvtr__activator__" +
					"\n\t\"matchedRule\":" + toDebugString(matchedRule));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapMatchedRule trace_69 = trace_ATL2QVTrFactory.eINSTANCE.createTmapMatchedRule();
		models[2/*middle*/].add(trace_69, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_69));
		}
		// mapping statements
		OPPOSITE_OF_TmapMatchedRule_t1matchedRule.put(matchedRule, trace_69);
		trace_69.setT1matchedRule(matchedRule);
		jm_TmapMatchedRule.appendElement(trace_69);
		final /*@Thrown*/ @Nullable Boolean mmapMatchedRule__qvtr__activator__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapMatchedRule__qvtr__activator__ ? "done "  : "fail ") + "MAP_mmapMatchedRule__qvtr__activator__");
		}
		return mmapMatchedRule__qvtr__activator__;
	}

	/**
	 *
	 * map mmapOclModel__IN__qvtr__activator__ in ATL2QVTr {
	 * guard:atl oclModel : OCL::OclModel[1];
	 * append jm_TmapOclModel__IN  : trace_ATL2QVTr::TmapOclModel_IN[1];
	 * new:middle trace : trace_ATL2QVTr::TmapOclModel_IN[1];
	 * set trace.t1oclModel := oclModel;
	 * add jm_TmapOclModel__IN += trace;
	 *
	 */
	protected boolean MAP_mmapOclModel__IN__qvtr__activator__(final @NonNull Connection jm_TmapOclModel__IN, final /*@NonInvalid*/ @NonNull OclModel oclModel)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclModel__IN__qvtr__activator__" +
					"\n\t\"oclModel\":" + toDebugString(oclModel));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapOclModel_IN trace_69 = trace_ATL2QVTrFactory.eINSTANCE.createTmapOclModel_IN();
		models[2/*middle*/].add(trace_69, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_69));
		}
		// mapping statements
		trace_69.setT1oclModel(oclModel);
		jm_TmapOclModel__IN.appendElement(trace_69);
		final /*@Thrown*/ @Nullable Boolean mmapOclModel__IN__qvtr__activator__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapOclModel__IN__qvtr__activator__ ? "done "  : "fail ") + "MAP_mmapOclModel__IN__qvtr__activator__");
		}
		return mmapOclModel__IN__qvtr__activator__;
	}

	/**
	 *
	 * map mmapOclMetamodel__qvtr__activator__ in ATL2QVTr {
	 * guard:atl oclMetamodel : OCL::OclModel[1];
	 * append jm_TmapOclMetamodel  : trace_ATL2QVTr::TmapOclMetamodel[1];
	 * new:middle trace : trace_ATL2QVTr::TmapOclMetamodel[1];
	 * set trace.t1oclMetamodel := oclMetamodel;
	 * add jm_TmapOclMetamodel += trace;
	 *
	 */
	protected boolean MAP_mmapOclMetamodel__qvtr__activator__(final @NonNull Connection jm_TmapOclMetamodel, final /*@NonInvalid*/ @NonNull OclModel oclMetamodel)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclMetamodel__qvtr__activator__" +
					"\n\t\"oclMetamodel\":" + toDebugString(oclMetamodel));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapOclMetamodel trace_69 = trace_ATL2QVTrFactory.eINSTANCE.createTmapOclMetamodel();
		models[2/*middle*/].add(trace_69, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_69));
		}
		// mapping statements
		OPPOSITE_OF_TmapOclMetamodel_t1oclMetamodel.put(oclMetamodel, trace_69);
		trace_69.setT1oclMetamodel(oclMetamodel);
		jm_TmapOclMetamodel.appendElement(trace_69);
		final /*@Thrown*/ @Nullable Boolean mmapOclMetamodel__qvtr__activator__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapOclMetamodel__qvtr__activator__ ? "done "  : "fail ") + "MAP_mmapOclMetamodel__qvtr__activator__");
		}
		return mmapOclMetamodel__qvtr__activator__;
	}

	/**
	 *
	 * map mmapModule__qvtr__activator__ in ATL2QVTr {
	 * guard:atl atlModule : ATL::Module[1];
	 * append jm_TmapModule  : trace_ATL2QVTr::TmapModule[1];
	 * new:middle trace : trace_ATL2QVTr::TmapModule[1];
	 * set trace.t1atlModule := atlModule;
	 * add jm_TmapModule += trace;
	 *
	 */
	protected boolean MAP_mmapModule__qvtr__activator__(final /*@NonInvalid*/ @NonNull Module atlModule, final @NonNull Connection jm_TmapModule)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapModule__qvtr__activator__" +
					"\n\t\"atlModule\":" + toDebugString(atlModule));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapModule trace_69 = trace_ATL2QVTrFactory.eINSTANCE.createTmapModule();
		models[2/*middle*/].add(trace_69, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_69));
		}
		// mapping statements
		OPPOSITE_OF_TmapModule_t1atlModule.put(atlModule, trace_69);
		trace_69.setT1atlModule(atlModule);
		jm_TmapModule.appendElement(trace_69);
		final /*@Thrown*/ @Nullable Boolean mmapModule__qvtr__activator__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapModule__qvtr__activator__ ? "done "  : "fail ") + "MAP_mmapModule__qvtr__activator__");
		}
		return mmapModule__qvtr__activator__;
	}

	/**
	 *
	 * map mmapMatchedRule__super__qvtr__activator__ in ATL2QVTr {
	 * guard:atl atlChildRule : ATL::MatchedRule[1];
	 * append jm_TmapMatchedRule__super  : trace_ATL2QVTr::TmapMatchedRule_super[1];
	 * new:middle trace : trace_ATL2QVTr::TmapMatchedRule_super[1];
	 * set trace.t1atlChildRule := atlChildRule;
	 * add jm_TmapMatchedRule__super += trace;
	 *
	 */
	protected boolean MAP_mmapMatchedRule__super__qvtr__activator__(final /*@NonInvalid*/ @NonNull MatchedRule atlChildRule, final @NonNull Connection jm_TmapMatchedRule__super)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapMatchedRule__super__qvtr__activator__" +
					"\n\t\"atlChildRule\":" + toDebugString(atlChildRule));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapMatchedRule_super trace_69 = trace_ATL2QVTrFactory.eINSTANCE.createTmapMatchedRule_super();
		models[2/*middle*/].add(trace_69, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_69));
		}
		// mapping statements
		trace_69.setT1atlChildRule(atlChildRule);
		jm_TmapMatchedRule__super.appendElement(trace_69);
		final /*@Thrown*/ @Nullable Boolean mmapMatchedRule__super__qvtr__activator__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapMatchedRule__super__qvtr__activator__ ? "done "  : "fail ") + "MAP_mmapMatchedRule__super__qvtr__activator__");
		}
		return mmapMatchedRule__super__qvtr__activator__;
	}

	/**
	 *
	 * map mmapOclModel__OUT__qvtr__activator__ in ATL2QVTr {
	 * guard:atl oclModel : OCL::OclModel[1];
	 * append jm_TmapOclModel__OUT  : trace_ATL2QVTr::TmapOclModel_OUT[1];
	 * new:middle trace : trace_ATL2QVTr::TmapOclModel_OUT[1];
	 * set trace.t1oclModel := oclModel;
	 * add jm_TmapOclModel__OUT += trace;
	 *
	 */
	protected boolean MAP_mmapOclModel__OUT__qvtr__activator__(final @NonNull Connection jm_TmapOclModel__OUT, final /*@NonInvalid*/ @NonNull OclModel oclModel_0)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclModel__OUT__qvtr__activator__" +
					"\n\t\"oclModel\":" + toDebugString(oclModel_0));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapOclModel_OUT trace_69 = trace_ATL2QVTrFactory.eINSTANCE.createTmapOclModel_OUT();
		models[2/*middle*/].add(trace_69, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_69));
		}
		// mapping statements
		trace_69.setT1oclModel(oclModel_0);
		jm_TmapOclModel__OUT.appendElement(trace_69);
		final /*@Thrown*/ @Nullable Boolean mmapOclModel__OUT__qvtr__activator__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapOclModel__OUT__qvtr__activator__ ? "done "  : "fail ") + "MAP_mmapOclModel__OUT__qvtr__activator__");
		}
		return mmapOclModel__OUT__qvtr__activator__;
	}

	/**
	 *
	 * map mmapOclExpression__dispatch__qvtr in ATL2QVTr {
	 * guard:atl atlExpression : OCL::OclExpression[1];
	 * append jm_TmapVariableExp  : trace_ATL2QVTr::TmapVariableExp[1];
	 * append jm_TmapOperationCallExp__Operation  : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * append jm_TmapIntegerExp  : trace_ATL2QVTr::TmapIntegerExp[1];
	 * append jm_TmapOperatorCallExp  : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * append jm_TmapIfExp  : trace_ATL2QVTr::TmapIfExp[1];
	 * append jm_TmapNavigationOrAttributeCallExp__Helper  : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * append jm_TmapOperationCallExp__Helper  : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * append jm_TmapNavigationOrAttributeCallExp__Property  : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * append jm_DmapOclExpression  : trace_ATL2QVTr::DmapOclExpression[1];
	 * append jm_TmapOclType  : trace_ATL2QVTr::TmapOclType[1];
	 * append jm_TmapStringExp  : trace_ATL2QVTr::TmapStringExp[1];
	 * append jm_TmapBooleanExp  : trace_ATL2QVTr::TmapBooleanExp[1];
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
	 * set dispatcher.d1atlExpression := atlExpression;
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
	 * add jm_TmapVariableExp += mapVariableExp;
	 * add jm_TmapNavigationOrAttributeCallExp__Property += mapNavigationOrAttributeCallExp_Property;
	 * add jm_TmapOperatorCallExp += mapOperatorCallExp;
	 * add jm_TmapBooleanExp += mapBooleanExp;
	 * add jm_TmapIfExp += mapIfExp;
	 * add jm_TmapNavigationOrAttributeCallExp__Helper += mapNavigationOrAttributeCallExp_Helper;
	 * add jm_DmapOclExpression += dispatcher;
	 * add jm_TmapOperationCallExp__Operation += mapOperationCallExp_Operation;
	 * add jm_TmapOclType += mapOclType;
	 * add jm_TmapIntegerExp += mapIntegerExp;
	 * add jm_TmapStringExp += mapStringExp;
	 * add jm_TmapOperationCallExp__Helper += mapOperationCallExp_Helper;
	 *
	 */
	protected boolean MAP_mmapOclExpression__dispatch__qvtr(final /*@NonInvalid*/ @NonNull OclExpression atlExpression, final @NonNull Connection jm_DmapOclExpression, final @NonNull Connection jm_TmapBooleanExp, final @NonNull Connection jm_TmapIfExp, final @NonNull Connection jm_TmapIntegerExp, final @NonNull Connection jm_TmapNavigationOrAttributeCallExp__Helper, final @NonNull Connection jm_TmapNavigationOrAttributeCallExp__Property, final @NonNull Connection jm_TmapOclType, final @NonNull Connection jm_TmapOperationCallExp__Helper, final @NonNull Connection jm_TmapOperationCallExp__Operation, final @NonNull Connection jm_TmapOperatorCallExp, final @NonNull Connection jm_TmapStringExp, final @NonNull Connection jm_TmapVariableExp)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclExpression__dispatch__qvtr" +
					"\n\t\"atlExpression\":" + toDebugString(atlExpression));
		}
		// creations
		final @SuppressWarnings("null")@NonNull DmapOclExpression dispatcher_0 = trace_ATL2QVTrFactory.eINSTANCE.createDmapOclExpression();
		models[2/*middle*/].add(dispatcher_0, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(dispatcher_0));
		}
		final @SuppressWarnings("null")@NonNull TmapBooleanExp mapBooleanExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapBooleanExp();
		models[2/*middle*/].add(mapBooleanExp, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapBooleanExp));
		}
		final @SuppressWarnings("null")@NonNull TmapIfExp mapIfExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapIfExp();
		models[2/*middle*/].add(mapIfExp, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapIfExp));
		}
		final @SuppressWarnings("null")@NonNull TmapIntegerExp mapIntegerExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapIntegerExp();
		models[2/*middle*/].add(mapIntegerExp, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapIntegerExp));
		}
		final @SuppressWarnings("null")@NonNull TmapNavigationOrAttributeCallExp_Helper mapNavigationOrAttributeCallExp_Helper = trace_ATL2QVTrFactory.eINSTANCE.createTmapNavigationOrAttributeCallExp_Helper();
		models[2/*middle*/].add(mapNavigationOrAttributeCallExp_Helper, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapNavigationOrAttributeCallExp_Helper));
		}
		final @SuppressWarnings("null")@NonNull TmapNavigationOrAttributeCallExp_Property mapNavigationOrAttributeCallExp_Property = trace_ATL2QVTrFactory.eINSTANCE.createTmapNavigationOrAttributeCallExp_Property();
		models[2/*middle*/].add(mapNavigationOrAttributeCallExp_Property, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapNavigationOrAttributeCallExp_Property));
		}
		final @SuppressWarnings("null")@NonNull TmapOclType mapOclType = trace_ATL2QVTrFactory.eINSTANCE.createTmapOclType();
		models[2/*middle*/].add(mapOclType, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapOclType));
		}
		final @SuppressWarnings("null")@NonNull TmapOperationCallExp_Helper mapOperationCallExp_Helper = trace_ATL2QVTrFactory.eINSTANCE.createTmapOperationCallExp_Helper();
		models[2/*middle*/].add(mapOperationCallExp_Helper, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapOperationCallExp_Helper));
		}
		final @SuppressWarnings("null")@NonNull TmapOperationCallExp_Operation mapOperationCallExp_Operation = trace_ATL2QVTrFactory.eINSTANCE.createTmapOperationCallExp_Operation();
		models[2/*middle*/].add(mapOperationCallExp_Operation, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapOperationCallExp_Operation));
		}
		final @SuppressWarnings("null")@NonNull TmapOperatorCallExp mapOperatorCallExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapOperatorCallExp();
		models[2/*middle*/].add(mapOperatorCallExp, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapOperatorCallExp));
		}
		final @SuppressWarnings("null")@NonNull TmapStringExp mapStringExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapStringExp();
		models[2/*middle*/].add(mapStringExp, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapStringExp));
		}
		final @SuppressWarnings("null")@NonNull TmapVariableExp mapVariableExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapVariableExp();
		models[2/*middle*/].add(mapVariableExp, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapVariableExp));
		}
		// mapping statements
		OPPOSITE_OF_DmapOclExpression_d1atlExpression.put(atlExpression, dispatcher_0);
		dispatcher_0.setD1atlExpression(atlExpression);
		dispatcher_0.setDomapBooleanExp(mapBooleanExp);
		dispatcher_0.setDomapIfExp(mapIfExp);
		dispatcher_0.setDomapIntegerExp(mapIntegerExp);
		dispatcher_0.setDomapNavigationOrAttributeCallExp_Helper(mapNavigationOrAttributeCallExp_Helper);
		dispatcher_0.setDomapNavigationOrAttributeCallExp_Property(mapNavigationOrAttributeCallExp_Property);
		dispatcher_0.setDomapOclType(mapOclType);
		dispatcher_0.setDomapOperationCallExp_Helper(mapOperationCallExp_Helper);
		dispatcher_0.setDomapOperationCallExp_Operation(mapOperationCallExp_Operation);
		dispatcher_0.setDomapOperatorCallExp(mapOperatorCallExp);
		dispatcher_0.setDomapStringExp(mapStringExp);
		dispatcher_0.setDomapVariableExp(mapVariableExp);
		jm_TmapVariableExp.appendElement(mapVariableExp);
		jm_TmapNavigationOrAttributeCallExp__Property.appendElement(mapNavigationOrAttributeCallExp_Property);
		jm_TmapOperatorCallExp.appendElement(mapOperatorCallExp);
		jm_TmapBooleanExp.appendElement(mapBooleanExp);
		jm_TmapIfExp.appendElement(mapIfExp);
		jm_TmapNavigationOrAttributeCallExp__Helper.appendElement(mapNavigationOrAttributeCallExp_Helper);
		jm_DmapOclExpression.appendElement(dispatcher_0);
		jm_TmapOperationCallExp__Operation.appendElement(mapOperationCallExp_Operation);
		jm_TmapOclType.appendElement(mapOclType);
		jm_TmapIntegerExp.appendElement(mapIntegerExp);
		jm_TmapStringExp.appendElement(mapStringExp);
		jm_TmapOperationCallExp__Helper.appendElement(mapOperationCallExp_Helper);
		final /*@Thrown*/ @Nullable Boolean mmapOclExpression__dispatch__qvtr = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapOclExpression__dispatch__qvtr ? "done "  : "fail ") + "MAP_mmapOclExpression__dispatch__qvtr");
		}
		return mmapOclExpression__dispatch__qvtr;
	}

	/**
	 *
	 * map mmapSimpleInPatternElement__qvtr__activator__ in ATL2QVTr {
	 * guard:atl atlElement : ATL::SimpleInPatternElement[1];
	 * append jm_TmapSimpleInPatternElement  : trace_ATL2QVTr::TmapSimpleInPatternElement[1];
	 * new:middle trace : trace_ATL2QVTr::TmapSimpleInPatternElement[1];
	 * set trace.t1atlElement := atlElement;
	 * add jm_TmapSimpleInPatternElement += trace;
	 *
	 */
	protected boolean MAP_mmapSimpleInPatternElement__qvtr__activator__(final /*@NonInvalid*/ @NonNull SimpleInPatternElement atlElement_0, final @NonNull Connection jm_TmapSimpleInPatternElement)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapSimpleInPatternElement__qvtr__activator__" +
					"\n\t\"atlElement\":" + toDebugString(atlElement_0));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapSimpleInPatternElement trace_69 = trace_ATL2QVTrFactory.eINSTANCE.createTmapSimpleInPatternElement();
		models[2/*middle*/].add(trace_69, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_69));
		}
		// mapping statements
		trace_69.setT1atlElement(atlElement_0);
		jm_TmapSimpleInPatternElement.appendElement(trace_69);
		final /*@Thrown*/ @Nullable Boolean mmapSimpleInPatternElement__qvtr__activator__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapSimpleInPatternElement__qvtr__activator__ ? "done "  : "fail ") + "MAP_mmapSimpleInPatternElement__qvtr__activator__");
		}
		return mmapSimpleInPatternElement__qvtr__activator__;
	}

	/**
	 *
	 * map mmapHelper__dispatch__qvtr in ATL2QVTr {
	 * guard:atl atlHelper : ATL::Helper[1];
	 * append jm_TmapHelper__Attribute  : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * append jm_DmapHelper  : trace_ATL2QVTr::DmapHelper[1];
	 * append jm_TmapHelper__Operation  : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * new:middle dispatcher : trace_ATL2QVTr::DmapHelper[1];
	 * new:middle mapHelper_Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * new:middle mapHelper_Operation : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * set dispatcher.d1atlHelper := atlHelper;
	 * set dispatcher.domapHelper_Attribute := mapHelper_Attribute;
	 * set dispatcher.domapHelper_Operation := mapHelper_Operation;
	 * add jm_TmapHelper__Operation += mapHelper_Operation;
	 * add jm_TmapHelper__Attribute += mapHelper_Attribute;
	 * add jm_DmapHelper += dispatcher;
	 *
	 */
	protected boolean MAP_mmapHelper__dispatch__qvtr(final /*@NonInvalid*/ @NonNull Helper atlHelper, final @NonNull Connection jm_DmapHelper, final @NonNull Connection jm_TmapHelper__Attribute, final @NonNull Connection jm_TmapHelper__Operation)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapHelper__dispatch__qvtr" +
					"\n\t\"atlHelper\":" + toDebugString(atlHelper));
		}
		// creations
		final @SuppressWarnings("null")@NonNull DmapHelper dispatcher_0 = trace_ATL2QVTrFactory.eINSTANCE.createDmapHelper();
		models[2/*middle*/].add(dispatcher_0, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(dispatcher_0));
		}
		final @SuppressWarnings("null")@NonNull TmapHelper_Attribute mapHelper_Attribute = trace_ATL2QVTrFactory.eINSTANCE.createTmapHelper_Attribute();
		models[2/*middle*/].add(mapHelper_Attribute, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapHelper_Attribute));
		}
		final @SuppressWarnings("null")@NonNull TmapHelper_Operation mapHelper_Operation = trace_ATL2QVTrFactory.eINSTANCE.createTmapHelper_Operation();
		models[2/*middle*/].add(mapHelper_Operation, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapHelper_Operation));
		}
		// mapping statements
		OPPOSITE_OF_DmapHelper_d1atlHelper.put(atlHelper, dispatcher_0);
		dispatcher_0.setD1atlHelper(atlHelper);
		dispatcher_0.setDomapHelper_Attribute(mapHelper_Attribute);
		dispatcher_0.setDomapHelper_Operation(mapHelper_Operation);
		jm_TmapHelper__Operation.appendElement(mapHelper_Operation);
		jm_TmapHelper__Attribute.appendElement(mapHelper_Attribute);
		jm_DmapHelper.appendElement(dispatcher_0);
		final /*@Thrown*/ @Nullable Boolean mmapHelper__dispatch__qvtr = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapHelper__dispatch__qvtr ? "done "  : "fail ") + "MAP_mmapHelper__dispatch__qvtr");
		}
		return mmapHelper__dispatch__qvtr;
	}

	/**
	 *
	 * map mmapInPattern__qvtr__activator__ in ATL2QVTr {
	 * guard:atl atlPattern : ATL::InPattern[1];
	 * append jm_TmapInPattern  : trace_ATL2QVTr::TmapInPattern[1];
	 * new:middle trace : trace_ATL2QVTr::TmapInPattern[1];
	 * set trace.t1atlPattern := atlPattern;
	 * add jm_TmapInPattern += trace;
	 *
	 */
	protected boolean MAP_mmapInPattern__qvtr__activator__(final /*@NonInvalid*/ @NonNull InPattern atlPattern_0, final @NonNull Connection jm_TmapInPattern)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapInPattern__qvtr__activator__" +
					"\n\t\"atlPattern\":" + toDebugString(atlPattern_0));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapInPattern trace_69 = trace_ATL2QVTrFactory.eINSTANCE.createTmapInPattern();
		models[2/*middle*/].add(trace_69, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_69));
		}
		// mapping statements
		OPPOSITE_OF_TmapInPattern_t1atlPattern.put(atlPattern_0, trace_69);
		trace_69.setT1atlPattern(atlPattern_0);
		jm_TmapInPattern.appendElement(trace_69);
		final /*@Thrown*/ @Nullable Boolean mmapInPattern__qvtr__activator__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapInPattern__qvtr__activator__ ? "done "  : "fail ") + "MAP_mmapInPattern__qvtr__activator__");
		}
		return mmapInPattern__qvtr__activator__;
	}

	/**
	 *
	 * map mmapOperationCallExp__argument__qvtr__activator__ in ATL2QVTr {
	 * guard:atl atlArgument : OCL::OclExpression[1];
	 * append jm_TmapOperationCallExp__argument  : trace_ATL2QVTr::TmapOperationCallExp_argument[1];
	 * new:middle trace : trace_ATL2QVTr::TmapOperationCallExp_argument[1];
	 * set trace.t1atlArgument := atlArgument;
	 * add jm_TmapOperationCallExp__argument += trace;
	 *
	 */
	protected boolean MAP_mmapOperationCallExp__argument__qvtr__activator__(final /*@NonInvalid*/ @NonNull OclExpression atlArgument, final @NonNull Connection jm_TmapOperationCallExp__argument)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperationCallExp__argument__qvtr__activator__" +
					"\n\t\"atlArgument\":" + toDebugString(atlArgument));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapOperationCallExp_argument trace_69 = trace_ATL2QVTrFactory.eINSTANCE.createTmapOperationCallExp_argument();
		models[2/*middle*/].add(trace_69, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_69));
		}
		// mapping statements
		trace_69.setT1atlArgument(atlArgument);
		jm_TmapOperationCallExp__argument.appendElement(trace_69);
		final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__argument__qvtr__activator__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapOperationCallExp__argument__qvtr__activator__ ? "done "  : "fail ") + "MAP_mmapOperationCallExp__argument__qvtr__activator__");
		}
		return mmapOperationCallExp__argument__qvtr__activator__;
	}

	/**
	 *
	 * map mmapBinding__qvtr__activator__ in ATL2QVTr {
	 * guard:atl atlBinding : ATL::Binding[1];
	 * append jm_TmapBinding  : trace_ATL2QVTr::TmapBinding[1];
	 * new:middle trace : trace_ATL2QVTr::TmapBinding[1];
	 * set trace.t1atlBinding := atlBinding;
	 * add jm_TmapBinding += trace;
	 *
	 */
	protected boolean MAP_mmapBinding__qvtr__activator__(final /*@NonInvalid*/ @NonNull Binding atlBinding, final @NonNull Connection jm_TmapBinding)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapBinding__qvtr__activator__" +
					"\n\t\"atlBinding\":" + toDebugString(atlBinding));
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapBinding trace_69 = trace_ATL2QVTrFactory.eINSTANCE.createTmapBinding();
		models[2/*middle*/].add(trace_69, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(trace_69));
		}
		// mapping statements
		trace_69.setT1atlBinding(atlBinding);
		jm_TmapBinding.appendElement(trace_69);
		final /*@Thrown*/ @Nullable Boolean mmapBinding__qvtr__activator__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapBinding__qvtr__activator__ ? "done "  : "fail ") + "MAP_mmapBinding__qvtr__activator__");
		}
		return mmapBinding__qvtr__activator__;
	}

	/**
	 *
	 * map mmapBooleanExp__qvtr in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapBooleanExp[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapBooleanExp;
	 * check var atlExpression : OCL::BooleanExp[1] := dispatcher.d1atlExpression;
	 * var symbol : Boolean[1] := atlExpression.booleanSymbol;
	 * var Boolean1 : Class[1] := PrimitiveTypes::Boolean;
	 * new:qvtr qvtrExpression : BooleanLiteralExp[1];
	 * set trace.t0symbol := symbol;
	 * set qvtrExpression.booleanSymbol := symbol;
	 * notify set dispatcher.success := true;
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 * set dispatcher.result := trace;
	 * notify set qvtrExpression.type := Boolean1;
	 *
	 */
	protected boolean MAP_mmapBooleanExp__qvtr(final /*@NonInvalid*/ @NonNull TmapBooleanExp trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapBooleanExp__qvtr" +
					"\n\t\"trace\":" + toDebugString(trace) +
					"\n\t\"dispatcher\":" + toDebugString(trace.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace.getDispatcher().getD2qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapBooleanExp domapBooleanExp = dispatcher_0.getDomapBooleanExp();
		final /*@NonInvalid*/ boolean eq = trace.equals(domapBooleanExp);
		/*@Thrown*/ @Nullable Boolean symbol_10;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof BooleanExp;
			/*@Thrown*/ @Nullable Boolean symbol_9;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull BooleanExp symbol_1 = (BooleanExp)temp1_atlExpression;
				final /*@NonInvalid*/ boolean booleanSymbol = symbol_1.isBooleanSymbol();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_Boolean_0 = idResolver.getClass(TypeId.BOOLEAN, null);
				// creations
				final @NonNull BooleanLiteralExp qvtrExpression = PivotFactory.eINSTANCE.createBooleanLiteralExp();
				models[1/*qvtr*/].add(qvtrExpression, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
				}
				// mapping statements
				trace.setT0symbol(booleanSymbol);
				qvtrExpression.setBooleanSymbol(booleanSymbol);
				dispatcher_0.setSuccess(ValueUtil.TRUE_VALUE);
				objectManager.assigned(dispatcher_0, QVTtracePackage.Literals.DISPATCH__SUCCESS, ValueUtil.TRUE_VALUE);
				dispatcher_0.setD2qvtrExpression(qvtrExpression);
				dispatcher_0.setResult(trace);
				qvtrExpression.setType(TYP_Boolean_0);
				objectManager.assigned(qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, TYP_Boolean_0);
				final /*@Thrown*/ @Nullable Boolean mmapBooleanExp__qvtr = ValueUtil.TRUE_VALUE;
				symbol_9 = mmapBooleanExp__qvtr;
			}
			else {
				symbol_9 = ValueUtil.FALSE_VALUE;
			}
			symbol_10 = symbol_9;
		}
		else {
			symbol_10 = ValueUtil.FALSE_VALUE;
		}
		trace.setSuccess(symbol_10);
		objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_10);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_10 ? "done "  : "fail ") + "MAP_mmapBooleanExp__qvtr");
		}
		return symbol_10;
	}

	/**
	 *
	 * map mmapVariableExp__qvtr in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp[1] success success;
	 * append jo_VariableExp  : VariableExp[1];
	 * append jm_DmapVariableExp__referredVariable  : trace_ATL2QVTr::DmapVariableExp_referredVariable[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapVariableExp;
	 * check var atlExpression : OCL::VariableExp[1] := dispatcher.d1atlExpression;
	 * var atlVariable : OCL::VariableDeclaration[1] := atlExpression.referredVariable;
	 * var varName : String[1] := atlVariable.varName;
	 * new:qvtr qvtrExpression : VariableExp[1];
	 * new:middle where_mapVariableExp_referredVariable : trace_ATL2QVTr::DmapVariableExp_referredVariable[1];
	 * set trace.t0varName := varName;
	 * set qvtrExpression.name := varName;
	 * notify set dispatcher.success := true;
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 * set dispatcher.result := trace;
	 * set trace.t1atlVariable := atlVariable;
	 * set trace.wmapVariableExp_referredVariable := where_mapVariableExp_referredVariable;
	 * set where_mapVariableExp_referredVariable.d1atlExpression := atlExpression;
	 * set where_mapVariableExp_referredVariable.d2qvtrExpression := qvtrExpression;
	 * add jo_VariableExp += qvtrExpression;
	 * add jm_DmapVariableExp__referredVariable += where_mapVariableExp_referredVariable;
	 *
	 */
	protected boolean MAP_mmapVariableExp__qvtr(final @NonNull Connection jm_DmapVariableExp__referredVariable, final @NonNull Connection jo_VariableExp, final /*@NonInvalid*/ @NonNull TmapVariableExp trace_0)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariableExp__qvtr" +
					"\n\t\"trace\":" + toDebugString(trace_0) +
					"\n\t\"dispatcher\":" + toDebugString(trace_0.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_0.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_0.getDispatcher().getD2qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_0.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapVariableExp domapVariableExp = dispatcher_0.getDomapVariableExp();
		final /*@NonInvalid*/ boolean eq = trace_0.equals(domapVariableExp);
		/*@Thrown*/ @Nullable Boolean symbol_15;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof VariableExp;
			/*@Thrown*/ @Nullable Boolean symbol_14;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull VariableExp symbol_1 = (VariableExp)temp1_atlExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull VariableDeclaration referredVariable = symbol_1.getReferredVariable();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String varName = referredVariable.getVarName();
				// creations
				final org.eclipse.ocl.pivot.@NonNull VariableExp qvtrExpression = PivotFactory.eINSTANCE.createVariableExp();
				models[1/*qvtr*/].add(qvtrExpression, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
				}
				final @SuppressWarnings("null")@NonNull DmapVariableExp_referredVariable where_mapVariableExp_referredVariable = trace_ATL2QVTrFactory.eINSTANCE.createDmapVariableExp_referredVariable();
				models[2/*middle*/].add(where_mapVariableExp_referredVariable, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(where_mapVariableExp_referredVariable));
				}
				// mapping statements
				trace_0.setT0varName(varName);
				qvtrExpression.setName(varName);
				dispatcher_0.setSuccess(ValueUtil.TRUE_VALUE);
				objectManager.assigned(dispatcher_0, QVTtracePackage.Literals.DISPATCH__SUCCESS, ValueUtil.TRUE_VALUE);
				dispatcher_0.setD2qvtrExpression(qvtrExpression);
				dispatcher_0.setResult(trace_0);
				trace_0.setT1atlVariable(referredVariable);
				trace_0.setWmapVariableExp_referredVariable(where_mapVariableExp_referredVariable);
				where_mapVariableExp_referredVariable.setD1atlExpression(symbol_1);
				where_mapVariableExp_referredVariable.setD2qvtrExpression(qvtrExpression);
				jo_VariableExp.appendElement(qvtrExpression);
				jm_DmapVariableExp__referredVariable.appendElement(where_mapVariableExp_referredVariable);
				final /*@Thrown*/ @Nullable Boolean mmapVariableExp__qvtr = ValueUtil.TRUE_VALUE;
				symbol_14 = mmapVariableExp__qvtr;
			}
			else {
				symbol_14 = ValueUtil.FALSE_VALUE;
			}
			symbol_15 = symbol_14;
		}
		else {
			symbol_15 = ValueUtil.FALSE_VALUE;
		}
		trace_0.setSuccess(symbol_15);
		objectManager.assigned(trace_0, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_15);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_15 ? "done "  : "fail ") + "MAP_mmapVariableExp__qvtr");
		}
		return symbol_15;
	}

	/**
	 *
	 * map mmapModule__qvtr__residue__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapModule[1];
	 * var atlModule : ATL::Module[1] := trace.t1atlModule;
	 * var txName : String[1] := atlModule.name;
	 * new:qvtr _3 : Package[1];
	 * new:qvtr _4 : qvtrelation::RelationModel[1];
	 * new:qvtr _5 : ParameterVariable[1];
	 * new:qvtr _6 : qvtbase::TypedModel[1];
	 * new:qvtr qvtrTransformation : qvtrelation::RelationalTransformation[1];
	 * set _3.name := '';
	 * set _5.isRequired := true;
	 * set _5.name := 'this';
	 * set _6.isTrace := true;
	 * set _6.name := 'middle';
	 * set qvtrTransformation.name := txName;
	 * set trace.t0txName := txName;
	 * set _4.ownedPackages := _3;
	 * set _5.type := qvtrTransformation;
	 * set qvtrTransformation.modelParameter := _6;
	 * set qvtrTransformation.ownedContext := _5;
	 * set qvtrTransformation.owningPackage := _3;
	 * set trace.t2_3 := _3;
	 * set trace.t2_4 := _4;
	 * set trace.t2_5 := _5;
	 * set trace.t2_6 := _6;
	 * set trace.t2qvtrTransformation := qvtrTransformation;
	 *
	 */
	protected boolean MAP_mmapModule__qvtr__residue__(final /*@NonInvalid*/ @NonNull TmapModule trace_1)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapModule__qvtr__residue__" +
					"\n\t\"trace\":" + toDebugString(trace_1));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Module t1atlModule = trace_1.getT1atlModule();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String name_2 = t1atlModule.getName();
		// creations
		final org.eclipse.ocl.pivot.@NonNull Package _3 = PivotFactory.eINSTANCE.createPackage();
		models[1/*qvtr*/].add(_3, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(_3));
		}
		final @NonNull RelationModel _4 = QVTrelationFactory.eINSTANCE.createRelationModel();
		models[1/*qvtr*/].add(_4, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(_4));
		}
		final @NonNull Parameter _5 = PivotFactory.eINSTANCE.createParameter();
		models[1/*qvtr*/].add(_5, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(_5));
		}
		final @NonNull TypedModel _6 = QVTbaseFactory.eINSTANCE.createTypedModel();
		models[1/*qvtr*/].add(_6, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(_6));
		}
		final @NonNull RelationalTransformation qvtrTransformation = QVTrelationFactory.eINSTANCE.createRelationalTransformation();
		models[1/*qvtr*/].add(qvtrTransformation, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrTransformation));
		}
		// mapping statements
		_3.setName(STR_);
		_5.setIsRequired(ValueUtil.TRUE_VALUE);
		_5.setName(STR_this);
		_6.setIsTrace(ValueUtil.TRUE_VALUE);
		_6.setName(STR_middle);
		qvtrTransformation.setName(name_2);
		trace_1.setT0txName(name_2);
		_4.getOwnedPackages().add(_3);
		_5.setType(qvtrTransformation);
		qvtrTransformation.getModelParameter().add(_6);
		qvtrTransformation.setOwnedContext(_5);
		qvtrTransformation.setOwningPackage(_3);
		trace_1.setT2_3(_3);
		trace_1.setT2_4(_4);
		trace_1.setT2_5(_5);
		trace_1.setT2_6(_6);
		trace_1.setT2qvtrTransformation(qvtrTransformation);
		final /*@Thrown*/ @Nullable Boolean mmapModule__qvtr__residue__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapModule__qvtr__residue__ ? "done "  : "fail ") + "MAP_mmapModule__qvtr__residue__");
		}
		return mmapModule__qvtr__residue__;
	}

	/**
	 *
	 * map mmapOclMetamodel__qvtr__residue__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOclMetamodel[1];
	 * var oclMetamodel : OCL::OclModel[1] := trace.t1oclMetamodel;
	 * check oclMetamodel.metamodel = null;
	 * var tmName : String[1] := oclMetamodel.name;
	 * new:qvtr qvtrTypedModel : qvtbase::TypedModel[1];
	 * set qvtrTypedModel.name := tmName;
	 * set trace.t0tmName := tmName;
	 * set trace.t2qvtrTypedModel := qvtrTypedModel;
	 *
	 */
	protected boolean MAP_mmapOclMetamodel__qvtr__residue__(final /*@NonInvalid*/ @NonNull TmapOclMetamodel trace_2)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclMetamodel__qvtr__residue__" +
					"\n\t\"trace\":" + toDebugString(trace_2));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclModel t1oclMetamodel = trace_2.getT1oclMetamodel();
		final /*@NonInvalid*/ @Nullable OclModel metamodel = t1oclMetamodel.getMetamodel();
		final /*@NonInvalid*/ boolean eq = metamodel == null;
		/*@Thrown*/ @Nullable Boolean symbol_4;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name_2 = t1oclMetamodel.getName();
			// creations
			final @NonNull TypedModel qvtrTypedModel = QVTbaseFactory.eINSTANCE.createTypedModel();
			models[1/*qvtr*/].add(qvtrTypedModel, false);
			if (debugCreations) {
				AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrTypedModel));
			}
			// mapping statements
			qvtrTypedModel.setName(name_2);
			trace_2.setT0tmName(name_2);
			trace_2.setT2qvtrTypedModel(qvtrTypedModel);
			final /*@Thrown*/ @Nullable Boolean mmapOclMetamodel__qvtr__residue__ = ValueUtil.TRUE_VALUE;
			symbol_4 = mmapOclMetamodel__qvtr__residue__;
		}
		else {
			symbol_4 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_4 ? "done "  : "fail ") + "MAP_mmapOclMetamodel__qvtr__residue__");
		}
		return symbol_4;
	}

	/**
	 *
	 * map mmapIntegerExp__qvtr in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapIntegerExp[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapIntegerExp;
	 * check var atlExpression : OCL::IntegerExp[1] := dispatcher.d1atlExpression;
	 * var symbol : Integer[1] := atlExpression.integerSymbol;
	 * var Integer1 : Class[1] := PrimitiveTypes::Integer;
	 * new:qvtr qvtrExpression : IntegerLiteralExp[1];
	 * set trace.t0symbol := symbol;
	 * set qvtrExpression.integerSymbol := symbol;
	 * notify set dispatcher.success := true;
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 * set dispatcher.result := trace;
	 * notify set qvtrExpression.type := Integer1;
	 *
	 */
	protected boolean MAP_mmapIntegerExp__qvtr(final /*@NonInvalid*/ @NonNull TmapIntegerExp trace_3)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapIntegerExp__qvtr" +
					"\n\t\"trace\":" + toDebugString(trace_3) +
					"\n\t\"dispatcher\":" + toDebugString(trace_3.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_3.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_3.getDispatcher().getD2qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_3.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapIntegerExp domapIntegerExp = dispatcher_0.getDomapIntegerExp();
		final /*@NonInvalid*/ boolean eq = trace_3.equals(domapIntegerExp);
		/*@Thrown*/ @Nullable Boolean symbol_10;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof IntegerExp;
			/*@Thrown*/ @Nullable Boolean symbol_9;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull IntegerExp symbol_1 = (IntegerExp)temp1_atlExpression;
				final /*@NonInvalid*/ int integerSymbol = symbol_1.getIntegerSymbol();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_Integer_0 = idResolver.getClass(TypeId.INTEGER, null);
				// creations
				final @NonNull IntegerLiteralExp qvtrExpression = PivotFactory.eINSTANCE.createIntegerLiteralExp();
				models[1/*qvtr*/].add(qvtrExpression, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
				}
				// mapping statements
				trace_3.setT0symbol(ValueUtil.bigIntegerValueOf(integerSymbol));
				qvtrExpression.setIntegerSymbol(integerSymbol);
				dispatcher_0.setSuccess(ValueUtil.TRUE_VALUE);
				objectManager.assigned(dispatcher_0, QVTtracePackage.Literals.DISPATCH__SUCCESS, ValueUtil.TRUE_VALUE);
				dispatcher_0.setD2qvtrExpression(qvtrExpression);
				dispatcher_0.setResult(trace_3);
				qvtrExpression.setType(TYP_Integer_0);
				objectManager.assigned(qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, TYP_Integer_0);
				final /*@Thrown*/ @Nullable Boolean mmapIntegerExp__qvtr = ValueUtil.TRUE_VALUE;
				symbol_9 = mmapIntegerExp__qvtr;
			}
			else {
				symbol_9 = ValueUtil.FALSE_VALUE;
			}
			symbol_10 = symbol_9;
		}
		else {
			symbol_10 = ValueUtil.FALSE_VALUE;
		}
		trace_3.setSuccess(symbol_10);
		objectManager.assigned(trace_3, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_10);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_10 ? "done "  : "fail ") + "MAP_mmapIntegerExp__qvtr");
		}
		return symbol_10;
	}

	/**
	 *
	 * map mmapStringExp__qvtr in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapStringExp[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapStringExp;
	 * check var atlExpression : OCL::StringExp[1] := dispatcher.d1atlExpression;
	 * var symbol : String[1] := atlExpression.stringSymbol;
	 * var String1 : Class[1] := PrimitiveTypes::String;
	 * new:qvtr qvtrExpression : StringLiteralExp[1];
	 * set trace.t0symbol := symbol;
	 * set qvtrExpression.stringSymbol := symbol;
	 * notify set dispatcher.success := true;
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 * set dispatcher.result := trace;
	 * notify set qvtrExpression.type := String1;
	 *
	 */
	protected boolean MAP_mmapStringExp__qvtr(final /*@NonInvalid*/ @NonNull TmapStringExp trace_4)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapStringExp__qvtr" +
					"\n\t\"trace\":" + toDebugString(trace_4) +
					"\n\t\"dispatcher\":" + toDebugString(trace_4.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_4.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_4.getDispatcher().getD2qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_4.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapStringExp domapStringExp = dispatcher_0.getDomapStringExp();
		final /*@NonInvalid*/ boolean eq = trace_4.equals(domapStringExp);
		/*@Thrown*/ @Nullable Boolean symbol_10;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof StringExp;
			/*@Thrown*/ @Nullable Boolean symbol_9;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull StringExp symbol_1 = (StringExp)temp1_atlExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String stringSymbol = symbol_1.getStringSymbol();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_String_0 = idResolver.getClass(TypeId.STRING, null);
				// creations
				final @NonNull StringLiteralExp qvtrExpression = PivotFactory.eINSTANCE.createStringLiteralExp();
				models[1/*qvtr*/].add(qvtrExpression, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
				}
				// mapping statements
				trace_4.setT0symbol(stringSymbol);
				qvtrExpression.setStringSymbol(stringSymbol);
				dispatcher_0.setSuccess(ValueUtil.TRUE_VALUE);
				objectManager.assigned(dispatcher_0, QVTtracePackage.Literals.DISPATCH__SUCCESS, ValueUtil.TRUE_VALUE);
				dispatcher_0.setD2qvtrExpression(qvtrExpression);
				dispatcher_0.setResult(trace_4);
				qvtrExpression.setType(TYP_String_0);
				objectManager.assigned(qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, TYP_String_0);
				final /*@Thrown*/ @Nullable Boolean mmapStringExp__qvtr = ValueUtil.TRUE_VALUE;
				symbol_9 = mmapStringExp__qvtr;
			}
			else {
				symbol_9 = ValueUtil.FALSE_VALUE;
			}
			symbol_10 = symbol_9;
		}
		else {
			symbol_10 = ValueUtil.FALSE_VALUE;
		}
		trace_4.setSuccess(symbol_10);
		objectManager.assigned(trace_4, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_10);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_10 ? "done "  : "fail ") + "MAP_mmapStringExp__qvtr");
		}
		return symbol_10;
	}

	/**
	 *
	 * map mmapOclType__qvtr in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOclType[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOclType;
	 * check var atlExpression : OCL::OclType[1] := dispatcher.d1atlExpression;
	 * notify set dispatcher.success := true;
	 * set dispatcher.result := trace;
	 *
	 */
	protected boolean MAP_mmapOclType__qvtr(final /*@NonInvalid*/ @NonNull TmapOclType trace_5)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclType__qvtr" +
					"\n\t\"trace\":" + toDebugString(trace_5) +
					"\n\t\"dispatcher\":" + toDebugString(trace_5.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_5.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_5.getDispatcher().getD2qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_5.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOclType domapOclType = dispatcher_0.getDomapOclType();
		final /*@NonInvalid*/ boolean eq = trace_5.equals(domapOclType);
		/*@Thrown*/ @Nullable Boolean symbol_6;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof OclType;
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull OclType symbol_1 = (OclType)temp1_atlExpression;
				// mapping statements
				dispatcher_0.setSuccess(ValueUtil.TRUE_VALUE);
				objectManager.assigned(dispatcher_0, QVTtracePackage.Literals.DISPATCH__SUCCESS, ValueUtil.TRUE_VALUE);
				dispatcher_0.setResult(trace_5);
				final /*@Thrown*/ @Nullable Boolean mmapOclType__qvtr = ValueUtil.TRUE_VALUE;
				symbol_5 = mmapOclType__qvtr;
			}
			else {
				symbol_5 = ValueUtil.FALSE_VALUE;
			}
			symbol_6 = symbol_5;
		}
		else {
			symbol_6 = ValueUtil.FALSE_VALUE;
		}
		trace_5.setSuccess(symbol_6);
		objectManager.assigned(trace_5, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_6);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_6 ? "done "  : "fail ") + "MAP_mmapOclType__qvtr");
		}
		return symbol_6;
	}

	/**
	 *
	 * map mmapOclModel__IN__qvtr__residue__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOclModel_IN[1];
	 * var oclModel : OCL::OclModel[1] := trace.t1oclModel;
	 * var oclMetamodel : OCL::OclModel[1] := oclModel.metamodel;
	 * check oclMetamodel.metamodel =
	 *   null;
	 * var atlModule : ATL::Module[1] := oclModel.Module;
	 * var when_mapOclMetamodel : trace_ATL2QVTr::TmapOclMetamodel[1] := oclMetamodel.TmapOclMetamodel;
	 * var qvtrTypedModel : qvtbase::TypedModel[1] := when_mapOclMetamodel.t2qvtrTypedModel;
	 * var name : String[1] := oclMetamodel.name;
	 * var oclAsSet : Set(Package[0|1]) := this.getPackage(atlModule, name)
	 *   .oclAsSet()
	 *   ;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t2qvtrTransformation;
	 * var getPackage1 : Package[1] := this.getPackage(atlModule, name);
	 * set qvtrTypedModel.usedPackage := oclAsSet;
	 * set qvtrTypedModel.transformation := qvtrTransformation;
	 * set trace.t1atlModule := atlModule;
	 * set trace.t1oclMetamodel := oclMetamodel;
	 * set trace.t2qvtrTransformation := qvtrTransformation;
	 * set trace.t2qvtrTypedModel := qvtrTypedModel;
	 * set trace.wmapModule := when_mapModule;
	 * set trace.wmapOclMetamodel := when_mapOclMetamodel;
	 *
	 */
	protected boolean MAP_mmapOclModel__IN__qvtr__residue__(final /*@NonInvalid*/ @NonNull TmapOclModel_IN trace_6)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclModel__IN__qvtr__residue__" +
					"\n\t\"trace\":" + toDebugString(trace_6));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclModel t1oclModel = trace_6.getT1oclModel();
		final /*@NonInvalid*/ @Nullable OclModel metamodel = t1oclModel.getMetamodel();
		final /*@NonInvalid*/ boolean symbol_0 = metamodel != null;
		/*@Thrown*/ @Nullable Boolean raw_oclMetamodel;
		if (symbol_0) {
			if (metamodel == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable OclModel metamodel_0 = metamodel.getMetamodel();
			final /*@Thrown*/ boolean eq = metamodel_0 == null;
			/*@Thrown*/ @Nullable Boolean symbol_14;
			if (eq) {
				final /*@NonInvalid*/ @NonNull UnboxedCompositionProperty IMPPROPid_inModels = new UnboxedCompositionProperty(PROPid_inModels);
				final /*@NonInvalid*/ @Nullable Module Module = (@Nullable Module)IMPPROPid_inModels.evaluate(executor, CLSSid_Module, t1oclModel);
				final /*@NonInvalid*/ boolean symbol_1 = Module != null;
				/*@Thrown*/ @Nullable Boolean raw_atlModule;
				if (symbol_1) {
					if (Module == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable TmapOclMetamodel TmapOclMetamodel = OPPOSITE_OF_TmapOclMetamodel_t1oclMetamodel.get(metamodel);
					final /*@Thrown*/ boolean symbol_2 = TmapOclMetamodel != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclMetamodel;
					if (symbol_2) {
						if (TmapOclMetamodel == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull TypedModel t2qvtrTypedModel = TmapOclMetamodel.getT2qvtrTypedModel();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull String name_2 = metamodel.getName();
						final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Package getPackage = ((FUN_getPackage)FTOR_getPackage.getUniqueComputation(this, Module, name_2)).instance;
						final /*@Thrown*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Package, getPackage);
						final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t1atlModule.get(Module);
						final /*@Thrown*/ boolean symbol_3 = TmapModule != null;
						/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
						if (symbol_3) {
							if (TmapModule == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull RelationalTransformation t2qvtrTransformation = TmapModule.getT2qvtrTransformation();
							final /*@Thrown*/ boolean symbol_4 = getPackage != null;
							/*@Thrown*/ @Nullable Boolean raw_getPackage1;
							if (symbol_4) {
								if (getPackage == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								// mapping statements
								final /*@Thrown*/ @NonNull List<org.eclipse.ocl.pivot.Package> ECORE_oclAsSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.ocl.pivot.Package.class, oclAsSet);
								t2qvtrTypedModel.getUsedPackage().addAll(ECORE_oclAsSet);
								t2qvtrTypedModel.setTransformation(t2qvtrTransformation);
								trace_6.setT1atlModule(Module);
								trace_6.setT1oclMetamodel(metamodel);
								trace_6.setT2qvtrTransformation(t2qvtrTransformation);
								trace_6.setT2qvtrTypedModel(t2qvtrTypedModel);
								trace_6.setWmapModule(TmapModule);
								trace_6.setWmapOclMetamodel(TmapOclMetamodel);
								final /*@Thrown*/ @Nullable Boolean mmapOclModel__IN__qvtr__residue__ = ValueUtil.TRUE_VALUE;
								raw_getPackage1 = mmapOclModel__IN__qvtr__residue__;
							}
							else {
								raw_getPackage1 = ValueUtil.FALSE_VALUE;
							}
							raw_when_mapModule = raw_getPackage1;
						}
						else {
							raw_when_mapModule = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapOclMetamodel = raw_when_mapModule;
					}
					else {
						raw_when_mapOclMetamodel = ValueUtil.FALSE_VALUE;
					}
					raw_atlModule = raw_when_mapOclMetamodel;
				}
				else {
					raw_atlModule = ValueUtil.FALSE_VALUE;
				}
				symbol_14 = raw_atlModule;
			}
			else {
				symbol_14 = ValueUtil.FALSE_VALUE;
			}
			raw_oclMetamodel = symbol_14;
		}
		else {
			raw_oclMetamodel = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_oclMetamodel ? "done "  : "fail ") + "MAP_mmapOclModel__IN__qvtr__residue__");
		}
		return raw_oclMetamodel;
	}

	/**
	 *
	 * map mmapOclModel__OUT__qvtr__residue__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOclModel_OUT[1];
	 * var oclModel : OCL::OclModel[1] := trace.t1oclModel;
	 * var oclMetamodel : OCL::OclModel[1] := oclModel.metamodel;
	 * check oclMetamodel.metamodel =
	 *   null;
	 * var atlModule : ATL::Module[1] := oclModel.Module;
	 * var when_mapOclMetamodel : trace_ATL2QVTr::TmapOclMetamodel[1] := oclMetamodel.TmapOclMetamodel;
	 * var qvtrTypedModel : qvtbase::TypedModel[1] := when_mapOclMetamodel.t2qvtrTypedModel;
	 * var name : String[1] := oclMetamodel.name;
	 * var oclAsSet : Set(Package[0|1]) := this.getPackage(atlModule, name)
	 *   .oclAsSet()
	 *   ;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t2qvtrTransformation;
	 * var getPackage1 : Package[1] := this.getPackage(atlModule, name);
	 * set qvtrTypedModel.usedPackage := oclAsSet;
	 * set qvtrTypedModel.transformation := qvtrTransformation;
	 * set trace.t1atlModule := atlModule;
	 * set trace.t1oclMetamodel := oclMetamodel;
	 * set trace.t2qvtrTransformation := qvtrTransformation;
	 * set trace.t2qvtrTypedModel := qvtrTypedModel;
	 * set trace.wmapModule := when_mapModule;
	 * set trace.wmapOclMetamodel := when_mapOclMetamodel;
	 *
	 */
	protected boolean MAP_mmapOclModel__OUT__qvtr__residue__(final /*@NonInvalid*/ @NonNull TmapOclModel_OUT trace_7)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOclModel__OUT__qvtr__residue__" +
					"\n\t\"trace\":" + toDebugString(trace_7));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclModel t1oclModel = trace_7.getT1oclModel();
		final /*@NonInvalid*/ @Nullable OclModel metamodel = t1oclModel.getMetamodel();
		final /*@NonInvalid*/ boolean symbol_0 = metamodel != null;
		/*@Thrown*/ @Nullable Boolean raw_oclMetamodel;
		if (symbol_0) {
			if (metamodel == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable OclModel metamodel_0 = metamodel.getMetamodel();
			final /*@Thrown*/ boolean eq = metamodel_0 == null;
			/*@Thrown*/ @Nullable Boolean symbol_14;
			if (eq) {
				final /*@NonInvalid*/ @NonNull UnboxedCompositionProperty IMPPROPid_outModels = new UnboxedCompositionProperty(PROPid_outModels);
				final /*@NonInvalid*/ @Nullable Module Module = (@Nullable Module)IMPPROPid_outModels.evaluate(executor, CLSSid_Module, t1oclModel);
				final /*@NonInvalid*/ boolean symbol_1 = Module != null;
				/*@Thrown*/ @Nullable Boolean raw_atlModule;
				if (symbol_1) {
					if (Module == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable TmapOclMetamodel TmapOclMetamodel = OPPOSITE_OF_TmapOclMetamodel_t1oclMetamodel.get(metamodel);
					final /*@Thrown*/ boolean symbol_2 = TmapOclMetamodel != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclMetamodel;
					if (symbol_2) {
						if (TmapOclMetamodel == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull TypedModel t2qvtrTypedModel = TmapOclMetamodel.getT2qvtrTypedModel();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull String name_2 = metamodel.getName();
						final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Package getPackage = ((FUN_getPackage)FTOR_getPackage.getUniqueComputation(this, Module, name_2)).instance;
						final /*@Thrown*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Package, getPackage);
						final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t1atlModule.get(Module);
						final /*@Thrown*/ boolean symbol_3 = TmapModule != null;
						/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
						if (symbol_3) {
							if (TmapModule == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull RelationalTransformation t2qvtrTransformation = TmapModule.getT2qvtrTransformation();
							final /*@Thrown*/ boolean symbol_4 = getPackage != null;
							/*@Thrown*/ @Nullable Boolean raw_getPackage1;
							if (symbol_4) {
								if (getPackage == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								// mapping statements
								final /*@Thrown*/ @NonNull List<org.eclipse.ocl.pivot.Package> ECORE_oclAsSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.ocl.pivot.Package.class, oclAsSet);
								t2qvtrTypedModel.getUsedPackage().addAll(ECORE_oclAsSet);
								t2qvtrTypedModel.setTransformation(t2qvtrTransformation);
								trace_7.setT1atlModule(Module);
								trace_7.setT1oclMetamodel(metamodel);
								trace_7.setT2qvtrTransformation(t2qvtrTransformation);
								trace_7.setT2qvtrTypedModel(t2qvtrTypedModel);
								trace_7.setWmapModule(TmapModule);
								trace_7.setWmapOclMetamodel(TmapOclMetamodel);
								final /*@Thrown*/ @Nullable Boolean mmapOclModel__OUT__qvtr__residue__ = ValueUtil.TRUE_VALUE;
								raw_getPackage1 = mmapOclModel__OUT__qvtr__residue__;
							}
							else {
								raw_getPackage1 = ValueUtil.FALSE_VALUE;
							}
							raw_when_mapModule = raw_getPackage1;
						}
						else {
							raw_when_mapModule = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapOclMetamodel = raw_when_mapModule;
					}
					else {
						raw_when_mapOclMetamodel = ValueUtil.FALSE_VALUE;
					}
					raw_atlModule = raw_when_mapOclMetamodel;
				}
				else {
					raw_atlModule = ValueUtil.FALSE_VALUE;
				}
				symbol_14 = raw_atlModule;
			}
			else {
				symbol_14 = ValueUtil.FALSE_VALUE;
			}
			raw_oclMetamodel = symbol_14;
		}
		else {
			raw_oclMetamodel = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_oclMetamodel ? "done "  : "fail ") + "MAP_mmapOclModel__OUT__qvtr__residue__");
		}
		return raw_oclMetamodel;
	}

	/**
	 *
	 * map mmapMatchedRule__qvtr__residue__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapMatchedRule[1] success success;
	 * var matchedRule : ATL::MatchedRule[1] := trace.t1matchedRule;
	 * var isAbstract : Boolean[1] := matchedRule.isAbstract;
	 * var atlModule : ATL::Module[1] := matchedRule.module;
	 * var ruleName : String[1] := matchedRule.name;
	 * var atlOutPattern : ATL::OutPattern[1] := matchedRule.outPattern;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t2qvtrTransformation;
	 * var _'qvttrace::TraceElement' : Class[1] := qvttrace::TraceElement;
	 * new:qvtr _6 : qvtrelation::SharedVariable[1];
	 * new:qvtr qvtrRelation : qvtrelation::Relation[1];
	 * set _6.isImplicit := true;
	 * set _6.name := 'trace';
	 * set qvtrRelation.isAbstract := isAbstract;
	 * set qvtrRelation.isTopLevel := true;
	 * set qvtrRelation.name := ruleName;
	 * set trace.t0ruleName := ruleName;
	 * set _6.type := _'qvttrace::TraceElement';
	 * set qvtrRelation.transformation := qvtrTransformation;
	 * set qvtrRelation.variable := _6;
	 * set trace.t1atlModule := atlModule;
	 * set trace.t1atlOutPattern := atlOutPattern;
	 * set trace.t2_6 := _6;
	 * set trace.t2qvtrRelation := qvtrRelation;
	 * set trace.t2qvtrTransformation := qvtrTransformation;
	 * set trace.wmapModule := when_mapModule;
	 *
	 */
	protected boolean MAP_mmapMatchedRule__qvtr__residue__(final /*@NonInvalid*/ @NonNull TmapMatchedRule trace_8)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapMatchedRule__qvtr__residue__" +
					"\n\t\"trace\":" + toDebugString(trace_8));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull MatchedRule t1matchedRule = trace_8.getT1matchedRule();
		final /*@NonInvalid*/ boolean isAbstract = t1matchedRule.isIsAbstract();
		final /*@NonInvalid*/ @Nullable Module module = t1matchedRule.getModule();
		final /*@NonInvalid*/ boolean symbol_0 = module != null;
		/*@Thrown*/ @Nullable Boolean raw_atlModule;
		if (symbol_0) {
			if (module == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name_2 = t1matchedRule.getName();
			final /*@NonInvalid*/ @Nullable OutPattern outPattern = t1matchedRule.getOutPattern();
			final /*@NonInvalid*/ boolean symbol_1 = outPattern != null;
			/*@Thrown*/ @Nullable Boolean raw_atlOutPattern;
			if (symbol_1) {
				if (outPattern == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t1atlModule.get(module);
				final /*@Thrown*/ boolean symbol_2 = TmapModule != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
				if (symbol_2) {
					if (TmapModule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull RelationalTransformation t2qvtrTransformation = TmapModule.getT2qvtrTransformation();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvttrace_c_c_TraceElement_0 = idResolver.getClass(CLSSid_TraceElement, null);
					// creations
					final @NonNull SharedVariable _6 = QVTrelationFactory.eINSTANCE.createSharedVariable();
					models[1/*qvtr*/].add(_6, false);
					if (debugCreations) {
						AbstractTransformer.CREATIONS.println("created " + toDebugString(_6));
					}
					final @NonNull Relation qvtrRelation = QVTrelationFactory.eINSTANCE.createRelation();
					models[1/*qvtr*/].add(qvtrRelation, false);
					if (debugCreations) {
						AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrRelation));
					}
					// mapping statements
					_6.setIsImplicit(ValueUtil.TRUE_VALUE);
					_6.setName(STR_trace);
					qvtrRelation.setIsAbstract(isAbstract);
					qvtrRelation.setIsTopLevel(ValueUtil.TRUE_VALUE);
					qvtrRelation.setName(name_2);
					trace_8.setT0ruleName(name_2);
					_6.setType(TYP_qvttrace_c_c_TraceElement_0);
					qvtrRelation.setTransformation(t2qvtrTransformation);
					qvtrRelation.getVariable().add(_6);
					trace_8.setT1atlModule(module);
					trace_8.setT1atlOutPattern(outPattern);
					trace_8.setT2_6(_6);
					trace_8.setT2qvtrRelation(qvtrRelation);
					trace_8.setT2qvtrTransformation(t2qvtrTransformation);
					trace_8.setWmapModule(TmapModule);
					final /*@Thrown*/ @Nullable Boolean mmapMatchedRule__qvtr__residue__ = ValueUtil.TRUE_VALUE;
					raw_when_mapModule = mmapMatchedRule__qvtr__residue__;
				}
				else {
					raw_when_mapModule = ValueUtil.FALSE_VALUE;
				}
				raw_atlOutPattern = raw_when_mapModule;
			}
			else {
				raw_atlOutPattern = ValueUtil.FALSE_VALUE;
			}
			raw_atlModule = raw_atlOutPattern;
		}
		else {
			raw_atlModule = ValueUtil.FALSE_VALUE;
		}
		trace_8.setSuccess(raw_atlModule);
		objectManager.assigned(trace_8, trace_ATL2QVTrPackage.Literals.TMAP_MATCHED_RULE__SUCCESS, raw_atlModule);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_atlModule ? "done "  : "fail ") + "MAP_mmapMatchedRule__qvtr__residue__");
		}
		return raw_atlModule;
	}

	/**
	 *
	 * map mmapVariableExp__referredVariable__dispatch__qvtr in ATL2QVTr {
	 * guard:middle dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1];
	 * append jm_TmapVariableExp__referredVariable__VariableDecl  : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1];
	 * append jm_TmapVariableExp__referredVariable__Helper  : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * var atlExpression : OCL::VariableExp[1] := dispatcher.d1atlExpression;
	 * new:middle mapVariableExp_referredVariable_Helper : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * new:middle mapVariableExp_referredVariable_VariableDeclaration : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1];
	 * set dispatcher.domapVariableExp_referredVariable_Helper := mapVariableExp_referredVariable_Helper;
	 * set dispatcher.domapVariableExp_referredVariable_VariableDeclaration := mapVariableExp_referredVariable_VariableDeclaration;
	 * add jm_TmapVariableExp__referredVariable__VariableDecl += mapVariableExp_referredVariable_VariableDeclaration;
	 * add jm_TmapVariableExp__referredVariable__Helper += mapVariableExp_referredVariable_Helper;
	 *
	 */
	protected boolean MAP_mmapVariableExp__referredVariable__dispatch__qvtr(final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher, final @NonNull Connection jm_TmapVariableExp__referredVariable__Helper, final @NonNull Connection jm_TmapVariableExp__referredVariable__VariableDecl)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariableExp__referredVariable__dispatch__qvtr" +
					"\n\t\"dispatcher\":" + toDebugString(dispatcher));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull VariableExp d1atlExpression = dispatcher.getD1atlExpression();
		// creations
		final @SuppressWarnings("null")@NonNull TmapVariableExp_referredVariable_Helper mapVariableExp_referredVariable_Helper = trace_ATL2QVTrFactory.eINSTANCE.createTmapVariableExp_referredVariable_Helper();
		models[2/*middle*/].add(mapVariableExp_referredVariable_Helper, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapVariableExp_referredVariable_Helper));
		}
		final @SuppressWarnings("null")@NonNull TmapVariableExp_referredVariable_VariableDeclaration mapVariableExp_referredVariable_VariableDeclaration = trace_ATL2QVTrFactory.eINSTANCE.createTmapVariableExp_referredVariable_VariableDeclaration();
		models[2/*middle*/].add(mapVariableExp_referredVariable_VariableDeclaration, false);
		if (debugCreations) {
			AbstractTransformer.CREATIONS.println("created " + toDebugString(mapVariableExp_referredVariable_VariableDeclaration));
		}
		// mapping statements
		dispatcher.setDomapVariableExp_referredVariable_Helper(mapVariableExp_referredVariable_Helper);
		dispatcher.setDomapVariableExp_referredVariable_VariableDeclaration(mapVariableExp_referredVariable_VariableDeclaration);
		jm_TmapVariableExp__referredVariable__VariableDecl.appendElement(mapVariableExp_referredVariable_VariableDeclaration);
		jm_TmapVariableExp__referredVariable__Helper.appendElement(mapVariableExp_referredVariable_Helper);
		final /*@Thrown*/ @Nullable Boolean mmapVariableExp__referredVariable__dispatch__qvtr = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapVariableExp__referredVariable__dispatch__qvtr ? "done "  : "fail ") + "MAP_mmapVariableExp__referredVariable__dispatch__qvtr");
		}
		return mmapVariableExp__referredVariable__dispatch__qvtr;
	}

	/**
	 *
	 * map mmapHelper__Attribute__qvtr__local__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Attribute[1] success localSuccess;
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * check trace = dispatcher.domapHelper_Attribute;
	 * var atlHelper : ATL::Helper[1] := dispatcher.d1atlHelper;
	 * var atlDefinition : OCL::OclFeatureDefinition[1] := atlHelper.definition;
	 * check var atlFeature : OCL::Attribute[1] := atlDefinition.feature;
	 * var atlExpression : OCL::OclExpression[1] := atlFeature.initExpression;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlExpression.DmapOclExpression;
	 * observe qvttrace::Dispatch::success check when_mapOclExpression.success;
	 * var atlModule : ATL::Module[1] := atlHelper.module;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * var attributeName : String[1] := atlFeature.name;
	 * var atlType : OCL::OclType[1] := atlFeature.type;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t2qvtrTransformation;
	 * notify set trace.t0attributeName := attributeName;
	 * set trace.t1atlDefinition := atlDefinition;
	 * set trace.t1atlExpression := atlExpression;
	 * set trace.t1atlFeature := atlFeature;
	 * set trace.t1atlModule := atlModule;
	 * set trace.t1atlType := atlType;
	 * notify set trace.t2qvtrTransformation := qvtrTransformation;
	 * set trace.wmapModule := when_mapModule;
	 * notify set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected class MAP_mmapHelper__Attribute__qvtr__local__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapHelper_Attribute trace_9;

		public MAP_mmapHelper__Attribute__qvtr__local__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_9 = (@NonNull TmapHelper_Attribute)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_9.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapHelper_Attribute domapHelper_Attribute = dispatcher_0.getDomapHelper_Attribute();
			final /*@NonInvalid*/ boolean eq = trace_9.equals(domapHelper_Attribute);
			/*@Thrown*/ @Nullable Boolean symbol_17;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Helper d1atlHelper = dispatcher_0.getD1atlHelper();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = d1atlHelper.getDefinition();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclFeature temp1_atlFeature = definition.getFeature();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_atlFeature instanceof Attribute;
				/*@Thrown*/ @Nullable Boolean symbol_16;
				if (symbol_0) {
					final /*@NonInvalid*/ @NonNull Attribute symbol_1 = (Attribute)temp1_atlFeature;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclExpression initExpression = symbol_1.getInitExpression();
					final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(initExpression);
					final /*@NonInvalid*/ boolean symbol_2 = DmapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
					if (symbol_2) {
						if (DmapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						objectManager.getting(DmapOclExpression, QVTtracePackage.Literals.DISPATCH__SUCCESS, false);
						final /*@Thrown*/ @Nullable Boolean success = DmapOclExpression.getSuccess();
						if (success == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_15;
						if (success) {
							final /*@NonInvalid*/ @Nullable Module module = d1atlHelper.getModule();
							final /*@NonInvalid*/ boolean symbol_3 = module != null;
							/*@Thrown*/ @Nullable Boolean raw_atlModule;
							if (symbol_3) {
								if (module == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t1atlModule.get(module);
								final /*@Thrown*/ boolean symbol_4 = TmapModule != null;
								/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
								if (symbol_4) {
									if (TmapModule == null) {
										throw new InvalidEvaluationException("Null where non-null value required");
									}
									@SuppressWarnings("null")
									final /*@NonInvalid*/ @NonNull String name_2 = symbol_1.getName();
									@SuppressWarnings("null")
									final /*@NonInvalid*/ @NonNull OclType type_2 = symbol_1.getType();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull RelationalTransformation t2qvtrTransformation = TmapModule.getT2qvtrTransformation();
									// mapping statements
									trace_9.setT0attributeName(name_2);
									objectManager.assigned(trace_9, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_ATTRIBUTE__T0ATTRIBUTE_NAME, name_2);
									trace_9.setT1atlDefinition(definition);
									trace_9.setT1atlExpression(initExpression);
									trace_9.setT1atlFeature(symbol_1);
									trace_9.setT1atlModule(module);
									trace_9.setT1atlType(type_2);
									trace_9.setT2qvtrTransformation(t2qvtrTransformation);
									objectManager.assigned(trace_9, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_ATTRIBUTE__T2QVTR_TRANSFORMATION, t2qvtrTransformation);
									trace_9.setWmapModule(TmapModule);
									trace_9.setWmapOclExpression(DmapOclExpression);
									objectManager.assigned(trace_9, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_ATTRIBUTE__WMAP_OCL_EXPRESSION, DmapOclExpression);
									final /*@Thrown*/ @Nullable Boolean mmapHelper__Attribute__qvtr__local__ = ValueUtil.TRUE_VALUE;
									raw_when_mapModule = mmapHelper__Attribute__qvtr__local__;
								}
								else {
									raw_when_mapModule = ValueUtil.FALSE_VALUE;
								}
								raw_atlModule = raw_when_mapModule;
							}
							else {
								raw_atlModule = ValueUtil.FALSE_VALUE;
							}
							symbol_15 = raw_atlModule;
						}
						else {
							symbol_15 = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapOclExpression = symbol_15;
					}
					else {
						raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
					}
					symbol_16 = raw_when_mapOclExpression;
				}
				else {
					symbol_16 = ValueUtil.FALSE_VALUE;
				}
				symbol_17 = symbol_16;
			}
			else {
				symbol_17 = ValueUtil.FALSE_VALUE;
			}
			trace_9.setLocalSuccess(symbol_17);
			objectManager.assigned(trace_9, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_ATTRIBUTE__LOCAL_SUCCESS, symbol_17);
			return symbol_17;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_9, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapIfExp__qvtr__local__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapIfExp[1] success localSuccess;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapIfExp;
	 * check var atlExpression : OCL::IfExp[1] := dispatcher.d1atlExpression;
	 * var atlCondition : OCL::OclExpression[1] := atlExpression.condition;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlCondition.DmapOclExpression;
	 * observe qvttrace::Dispatch::success check when_mapOclExpression.success;
	 * var atlThen : OCL::OclExpression[1] := atlExpression.thenExpression;
	 * var when_mapOclExpression1 : trace_ATL2QVTr::DmapOclExpression[1] := atlThen.DmapOclExpression;
	 * observe qvttrace::Dispatch::success check when_mapOclExpression1.success;
	 * var atlElse : OCL::OclExpression[1] := atlExpression.elseExpression;
	 * var when_mapOclExpression2 : trace_ATL2QVTr::DmapOclExpression[1] := atlElse.DmapOclExpression;
	 * observe qvttrace::Dispatch::success check when_mapOclExpression2.success;
	 * set trace.t1atlCondition := atlCondition;
	 * set trace.t1atlElse := atlElse;
	 * set trace.t1atlThen := atlThen;
	 * notify set trace.wmapOclExpression1 := when_mapOclExpression1;
	 * notify set trace.wmapOclExpression2 := when_mapOclExpression2;
	 * notify set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected class MAP_mmapIfExp__qvtr__local__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapIfExp trace_10;

		public MAP_mmapIfExp__qvtr__local__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_10 = (@NonNull TmapIfExp)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_10.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapIfExp domapIfExp = dispatcher_0.getDomapIfExp();
			final /*@NonInvalid*/ boolean eq = trace_10.equals(domapIfExp);
			/*@Thrown*/ @Nullable Boolean symbol_16;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof IfExp;
				/*@Thrown*/ @Nullable Boolean symbol_15;
				if (symbol_0) {
					final /*@NonInvalid*/ @NonNull IfExp symbol_1 = (IfExp)temp1_atlExpression;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclExpression condition = symbol_1.getCondition();
					final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(condition);
					final /*@NonInvalid*/ boolean symbol_2 = DmapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
					if (symbol_2) {
						if (DmapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						objectManager.getting(DmapOclExpression, QVTtracePackage.Literals.DISPATCH__SUCCESS, false);
						final /*@Thrown*/ @Nullable Boolean success = DmapOclExpression.getSuccess();
						if (success == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_14;
						if (success) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OclExpression thenExpression = symbol_1.getThenExpression();
							final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression_0 = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(thenExpression);
							final /*@NonInvalid*/ boolean symbol_3 = DmapOclExpression_0 != null;
							/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression1;
							if (symbol_3) {
								if (DmapOclExpression_0 == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								objectManager.getting(DmapOclExpression_0, QVTtracePackage.Literals.DISPATCH__SUCCESS, false);
								final /*@Thrown*/ @Nullable Boolean success_0 = DmapOclExpression_0.getSuccess();
								if (success_0 == null) {
									throw new InvalidEvaluationException("Null if condition");
								}
								/*@Thrown*/ @Nullable Boolean symbol_13;
								if (success_0) {
									@SuppressWarnings("null")
									final /*@NonInvalid*/ @NonNull OclExpression elseExpression = symbol_1.getElseExpression();
									final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression_1 = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(elseExpression);
									final /*@NonInvalid*/ boolean symbol_4 = DmapOclExpression_1 != null;
									/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression2;
									if (symbol_4) {
										if (DmapOclExpression_1 == null) {
											throw new InvalidEvaluationException("Null where non-null value required");
										}
										objectManager.getting(DmapOclExpression_1, QVTtracePackage.Literals.DISPATCH__SUCCESS, false);
										final /*@Thrown*/ @Nullable Boolean success_1 = DmapOclExpression_1.getSuccess();
										if (success_1 == null) {
											throw new InvalidEvaluationException("Null if condition");
										}
										/*@Thrown*/ @Nullable Boolean symbol_12;
										if (success_1) {
											// mapping statements
											trace_10.setT1atlCondition(condition);
											trace_10.setT1atlElse(elseExpression);
											trace_10.setT1atlThen(thenExpression);
											trace_10.setWmapOclExpression1(DmapOclExpression_0);
											objectManager.assigned(trace_10, trace_ATL2QVTrPackage.Literals.TMAP_IF_EXP__WMAP_OCL_EXPRESSION1, DmapOclExpression_0);
											trace_10.setWmapOclExpression2(DmapOclExpression_1);
											objectManager.assigned(trace_10, trace_ATL2QVTrPackage.Literals.TMAP_IF_EXP__WMAP_OCL_EXPRESSION2, DmapOclExpression_1);
											trace_10.setWmapOclExpression(DmapOclExpression);
											objectManager.assigned(trace_10, trace_ATL2QVTrPackage.Literals.TMAP_IF_EXP__WMAP_OCL_EXPRESSION, DmapOclExpression);
											final /*@Thrown*/ @Nullable Boolean mmapIfExp__qvtr__local__ = ValueUtil.TRUE_VALUE;
											symbol_12 = mmapIfExp__qvtr__local__;
										}
										else {
											symbol_12 = ValueUtil.FALSE_VALUE;
										}
										raw_when_mapOclExpression2 = symbol_12;
									}
									else {
										raw_when_mapOclExpression2 = ValueUtil.FALSE_VALUE;
									}
									symbol_13 = raw_when_mapOclExpression2;
								}
								else {
									symbol_13 = ValueUtil.FALSE_VALUE;
								}
								raw_when_mapOclExpression1 = symbol_13;
							}
							else {
								raw_when_mapOclExpression1 = ValueUtil.FALSE_VALUE;
							}
							symbol_14 = raw_when_mapOclExpression1;
						}
						else {
							symbol_14 = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapOclExpression = symbol_14;
					}
					else {
						raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
					}
					symbol_15 = raw_when_mapOclExpression;
				}
				else {
					symbol_15 = ValueUtil.FALSE_VALUE;
				}
				symbol_16 = symbol_15;
			}
			else {
				symbol_16 = ValueUtil.FALSE_VALUE;
			}
			trace_10.setLocalSuccess(symbol_16);
			objectManager.assigned(trace_10, trace_ATL2QVTrPackage.Literals.TMAP_IF_EXP__LOCAL_SUCCESS, symbol_16);
			return symbol_16;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_10, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapHelper__Operation__qvtr__local__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Operation[1] success localSuccess;
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * check trace = dispatcher.domapHelper_Operation;
	 * var atlHelper : ATL::Helper[1] := dispatcher.d1atlHelper;
	 * var atlDefinition : OCL::OclFeatureDefinition[1] := atlHelper.definition;
	 * check var atlFeature : OCL::Operation[1] := atlDefinition.feature;
	 * var atlExpression : OCL::OclExpression[1] := atlFeature.body;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlExpression.DmapOclExpression;
	 * observe qvttrace::Dispatch::success check when_mapOclExpression.success;
	 * var atlModule : ATL::Module[1] := atlHelper.module;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * var operationName : String[1] := atlFeature.name;
	 * var atlType : OCL::OclType[1] := atlFeature.returnType;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t2qvtrTransformation;
	 * notify set trace.t0operationName := operationName;
	 * set trace.t1atlDefinition := atlDefinition;
	 * set trace.t1atlExpression := atlExpression;
	 * set trace.t1atlFeature := atlFeature;
	 * set trace.t1atlModule := atlModule;
	 * set trace.t1atlType := atlType;
	 * notify set trace.t2qvtrTransformation := qvtrTransformation;
	 * set trace.wmapModule := when_mapModule;
	 * notify set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected class MAP_mmapHelper__Operation__qvtr__local__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapHelper_Operation trace_11;

		public MAP_mmapHelper__Operation__qvtr__local__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_11 = (@NonNull TmapHelper_Operation)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_11.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapHelper_Operation domapHelper_Operation = dispatcher_0.getDomapHelper_Operation();
			final /*@NonInvalid*/ boolean eq = trace_11.equals(domapHelper_Operation);
			/*@Thrown*/ @Nullable Boolean symbol_17;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Helper d1atlHelper = dispatcher_0.getD1atlHelper();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = d1atlHelper.getDefinition();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclFeature temp1_atlFeature = definition.getFeature();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_atlFeature instanceof org.eclipse.m2m.atl.common.OCL.Operation;
				/*@Thrown*/ @Nullable Boolean symbol_16;
				if (symbol_0) {
					final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation symbol_1 = (org.eclipse.m2m.atl.common.OCL.Operation)temp1_atlFeature;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclExpression body = symbol_1.getBody();
					final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(body);
					final /*@NonInvalid*/ boolean symbol_2 = DmapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
					if (symbol_2) {
						if (DmapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						objectManager.getting(DmapOclExpression, QVTtracePackage.Literals.DISPATCH__SUCCESS, false);
						final /*@Thrown*/ @Nullable Boolean success = DmapOclExpression.getSuccess();
						if (success == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_15;
						if (success) {
							final /*@NonInvalid*/ @Nullable Module module = d1atlHelper.getModule();
							final /*@NonInvalid*/ boolean symbol_3 = module != null;
							/*@Thrown*/ @Nullable Boolean raw_atlModule;
							if (symbol_3) {
								if (module == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t1atlModule.get(module);
								final /*@Thrown*/ boolean symbol_4 = TmapModule != null;
								/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
								if (symbol_4) {
									if (TmapModule == null) {
										throw new InvalidEvaluationException("Null where non-null value required");
									}
									@SuppressWarnings("null")
									final /*@NonInvalid*/ @NonNull String name_2 = symbol_1.getName();
									@SuppressWarnings("null")
									final /*@NonInvalid*/ @NonNull OclType returnType = symbol_1.getReturnType();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull RelationalTransformation t2qvtrTransformation = TmapModule.getT2qvtrTransformation();
									// mapping statements
									trace_11.setT0operationName(name_2);
									objectManager.assigned(trace_11, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_OPERATION__T0OPERATION_NAME, name_2);
									trace_11.setT1atlDefinition(definition);
									trace_11.setT1atlExpression(body);
									trace_11.setT1atlFeature(symbol_1);
									trace_11.setT1atlModule(module);
									trace_11.setT1atlType(returnType);
									trace_11.setT2qvtrTransformation(t2qvtrTransformation);
									objectManager.assigned(trace_11, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_OPERATION__T2QVTR_TRANSFORMATION, t2qvtrTransformation);
									trace_11.setWmapModule(TmapModule);
									trace_11.setWmapOclExpression(DmapOclExpression);
									objectManager.assigned(trace_11, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_OPERATION__WMAP_OCL_EXPRESSION, DmapOclExpression);
									final /*@Thrown*/ @Nullable Boolean mmapHelper__Operation__qvtr__local__ = ValueUtil.TRUE_VALUE;
									raw_when_mapModule = mmapHelper__Operation__qvtr__local__;
								}
								else {
									raw_when_mapModule = ValueUtil.FALSE_VALUE;
								}
								raw_atlModule = raw_when_mapModule;
							}
							else {
								raw_atlModule = ValueUtil.FALSE_VALUE;
							}
							symbol_15 = raw_atlModule;
						}
						else {
							symbol_15 = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapOclExpression = symbol_15;
					}
					else {
						raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
					}
					symbol_16 = raw_when_mapOclExpression;
				}
				else {
					symbol_16 = ValueUtil.FALSE_VALUE;
				}
				symbol_17 = symbol_16;
			}
			else {
				symbol_17 = ValueUtil.FALSE_VALUE;
			}
			trace_11.setLocalSuccess(symbol_17);
			objectManager.assigned(trace_11, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_OPERATION__LOCAL_SUCCESS, symbol_17);
			return symbol_17;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_11, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapNavigationOrAttributeCallExp__Helper__qvtr__loc in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1] success localSuccess;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapNavigationOrAttributeCallExp_Helper;
	 * check var atlExpression : OCL::NavigationOrAttributeCallExp[1] := dispatcher.d1atlExpression;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlSource.DmapOclExpression;
	 * observe qvttrace::Dispatch::success check when_mapOclExpression.success;
	 * var propertyName : String[1] := atlExpression.name;
	 * notify set trace.t0propertyName := propertyName;
	 * set trace.t1atlSource := atlSource;
	 * notify set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected class MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__loc extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_12;

		public MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__loc(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_12 = (@NonNull TmapNavigationOrAttributeCallExp_Helper)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_12.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Helper domapNavigationOrAttributeCallExp_Helper = dispatcher_0.getDomapNavigationOrAttributeCallExp_Helper();
			final /*@NonInvalid*/ boolean eq = trace_12.equals(domapNavigationOrAttributeCallExp_Helper);
			/*@Thrown*/ @Nullable Boolean symbol_9;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof NavigationOrAttributeCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_8;
				if (symbol_0) {
					final /*@NonInvalid*/ @NonNull NavigationOrAttributeCallExp symbol_1 = (NavigationOrAttributeCallExp)temp1_atlExpression;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclExpression source = symbol_1.getSource();
					final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(source);
					final /*@NonInvalid*/ boolean symbol_2 = DmapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
					if (symbol_2) {
						if (DmapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						objectManager.getting(DmapOclExpression, QVTtracePackage.Literals.DISPATCH__SUCCESS, false);
						final /*@Thrown*/ @Nullable Boolean success = DmapOclExpression.getSuccess();
						if (success == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_7;
						if (success) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String name_2 = symbol_1.getName();
							// mapping statements
							trace_12.setT0propertyName(name_2);
							objectManager.assigned(trace_12, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T0PROPERTY_NAME, name_2);
							trace_12.setT1atlSource(source);
							trace_12.setWmapOclExpression(DmapOclExpression);
							objectManager.assigned(trace_12, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION, DmapOclExpression);
							final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Helper__qvtr__loc = ValueUtil.TRUE_VALUE;
							symbol_7 = mmapNavigationOrAttributeCallExp__Helper__qvtr__loc;
						}
						else {
							symbol_7 = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapOclExpression = symbol_7;
					}
					else {
						raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
					}
					symbol_8 = raw_when_mapOclExpression;
				}
				else {
					symbol_8 = ValueUtil.FALSE_VALUE;
				}
				symbol_9 = symbol_8;
			}
			else {
				symbol_9 = ValueUtil.FALSE_VALUE;
			}
			trace_12.setLocalSuccess(symbol_9);
			objectManager.assigned(trace_12, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__LOCAL_SUCCESS, symbol_9);
			return symbol_9;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_12, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapNavigationOrAttributeCallExp__Property__qvtr__l in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1] success localSuccess;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapNavigationOrAttributeCallExp_Property;
	 * check var atlExpression : OCL::NavigationOrAttributeCallExp[1] := dispatcher.d1atlExpression;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlSource.DmapOclExpression;
	 * observe qvttrace::Dispatch::success check when_mapOclExpression.success;
	 * var propertyName : String[1] := atlExpression.name;
	 * notify set trace.t0propertyName := propertyName;
	 * set trace.t1atlSource := atlSource;
	 * notify set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected class MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__l extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace_13;

		public MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__l(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_13 = (@NonNull TmapNavigationOrAttributeCallExp_Property)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_13.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Property domapNavigationOrAttributeCallExp_Property = dispatcher_0.getDomapNavigationOrAttributeCallExp_Property();
			final /*@NonInvalid*/ boolean eq = trace_13.equals(domapNavigationOrAttributeCallExp_Property);
			/*@Thrown*/ @Nullable Boolean symbol_9;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof NavigationOrAttributeCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_8;
				if (symbol_0) {
					final /*@NonInvalid*/ @NonNull NavigationOrAttributeCallExp symbol_1 = (NavigationOrAttributeCallExp)temp1_atlExpression;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclExpression source = symbol_1.getSource();
					final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(source);
					final /*@NonInvalid*/ boolean symbol_2 = DmapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
					if (symbol_2) {
						if (DmapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						objectManager.getting(DmapOclExpression, QVTtracePackage.Literals.DISPATCH__SUCCESS, false);
						final /*@Thrown*/ @Nullable Boolean success = DmapOclExpression.getSuccess();
						if (success == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_7;
						if (success) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String name_2 = symbol_1.getName();
							// mapping statements
							trace_13.setT0propertyName(name_2);
							objectManager.assigned(trace_13, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T0PROPERTY_NAME, name_2);
							trace_13.setT1atlSource(source);
							trace_13.setWmapOclExpression(DmapOclExpression);
							objectManager.assigned(trace_13, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__WMAP_OCL_EXPRESSION, DmapOclExpression);
							final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Property__qvtr__l = ValueUtil.TRUE_VALUE;
							symbol_7 = mmapNavigationOrAttributeCallExp__Property__qvtr__l;
						}
						else {
							symbol_7 = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapOclExpression = symbol_7;
					}
					else {
						raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
					}
					symbol_8 = raw_when_mapOclExpression;
				}
				else {
					symbol_8 = ValueUtil.FALSE_VALUE;
				}
				symbol_9 = symbol_8;
			}
			else {
				symbol_9 = ValueUtil.FALSE_VALUE;
			}
			trace_13.setLocalSuccess(symbol_9);
			objectManager.assigned(trace_13, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__LOCAL_SUCCESS, symbol_9);
			return symbol_9;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_13, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapOperationCallExp__Helper__qvtr__local__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1] success localSuccess;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperationCallExp_Helper;
	 * check var atlExpression : OCL::OperationCallExp[1] := dispatcher.d1atlExpression;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlSource.DmapOclExpression;
	 * observe qvttrace::Dispatch::success check when_mapOclExpression.success;
	 * var operationName : String[1] := atlExpression.operationName;
	 * notify set trace.t0operationName := operationName;
	 * set trace.t1atlSource := atlSource;
	 * notify set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected class MAP_mmapOperationCallExp__Helper__qvtr__local__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_14;

		public MAP_mmapOperationCallExp__Helper__qvtr__local__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_14 = (@NonNull TmapOperationCallExp_Helper)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_14.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Helper domapOperationCallExp_Helper = dispatcher_0.getDomapOperationCallExp_Helper();
			final /*@NonInvalid*/ boolean eq = trace_14.equals(domapOperationCallExp_Helper);
			/*@Thrown*/ @Nullable Boolean symbol_9;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof OperationCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_8;
				if (symbol_0) {
					final /*@NonInvalid*/ @NonNull OperationCallExp symbol_1 = (OperationCallExp)temp1_atlExpression;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclExpression source = symbol_1.getSource();
					final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(source);
					final /*@NonInvalid*/ boolean symbol_2 = DmapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
					if (symbol_2) {
						if (DmapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						objectManager.getting(DmapOclExpression, QVTtracePackage.Literals.DISPATCH__SUCCESS, false);
						final /*@Thrown*/ @Nullable Boolean success = DmapOclExpression.getSuccess();
						if (success == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_7;
						if (success) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String operationName = symbol_1.getOperationName();
							// mapping statements
							trace_14.setT0operationName(operationName);
							objectManager.assigned(trace_14, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__T0OPERATION_NAME, operationName);
							trace_14.setT1atlSource(source);
							trace_14.setWmapOclExpression(DmapOclExpression);
							objectManager.assigned(trace_14, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION, DmapOclExpression);
							final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Helper__qvtr__local__ = ValueUtil.TRUE_VALUE;
							symbol_7 = mmapOperationCallExp__Helper__qvtr__local__;
						}
						else {
							symbol_7 = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapOclExpression = symbol_7;
					}
					else {
						raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
					}
					symbol_8 = raw_when_mapOclExpression;
				}
				else {
					symbol_8 = ValueUtil.FALSE_VALUE;
				}
				symbol_9 = symbol_8;
			}
			else {
				symbol_9 = ValueUtil.FALSE_VALUE;
			}
			trace_14.setLocalSuccess(symbol_9);
			objectManager.assigned(trace_14, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__LOCAL_SUCCESS, symbol_9);
			return symbol_9;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_14, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapOperatorCallExp__qvtr__local__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperatorCallExp[1] success localSuccess;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperatorCallExp;
	 * check var atlExpression : OCL::OperatorCallExp[1] := dispatcher.d1atlExpression;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlSource.DmapOclExpression;
	 * observe qvttrace::Dispatch::success check when_mapOclExpression.success;
	 * var operationName : String[1] := atlExpression.operationName;
	 * notify set trace.t0operationName := operationName;
	 * set trace.t1atlSource := atlSource;
	 * notify set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected class MAP_mmapOperatorCallExp__qvtr__local__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace_15;

		public MAP_mmapOperatorCallExp__qvtr__local__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_15 = (@NonNull TmapOperatorCallExp)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_15.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher_0.getDomapOperatorCallExp();
			final /*@NonInvalid*/ boolean eq = trace_15.equals(domapOperatorCallExp);
			/*@Thrown*/ @Nullable Boolean symbol_9;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof OperatorCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_8;
				if (symbol_0) {
					final /*@NonInvalid*/ @NonNull OperatorCallExp symbol_1 = (OperatorCallExp)temp1_atlExpression;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclExpression source = symbol_1.getSource();
					final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(source);
					final /*@NonInvalid*/ boolean symbol_2 = DmapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
					if (symbol_2) {
						if (DmapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						objectManager.getting(DmapOclExpression, QVTtracePackage.Literals.DISPATCH__SUCCESS, false);
						final /*@Thrown*/ @Nullable Boolean success = DmapOclExpression.getSuccess();
						if (success == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_7;
						if (success) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String operationName = symbol_1.getOperationName();
							// mapping statements
							trace_15.setT0operationName(operationName);
							objectManager.assigned(trace_15, trace_ATL2QVTrPackage.Literals.TMAP_OPERATOR_CALL_EXP__T0OPERATION_NAME, operationName);
							trace_15.setT1atlSource(source);
							trace_15.setWmapOclExpression(DmapOclExpression);
							objectManager.assigned(trace_15, trace_ATL2QVTrPackage.Literals.TMAP_OPERATOR_CALL_EXP__WMAP_OCL_EXPRESSION, DmapOclExpression);
							final /*@Thrown*/ @Nullable Boolean mmapOperatorCallExp__qvtr__local__ = ValueUtil.TRUE_VALUE;
							symbol_7 = mmapOperatorCallExp__qvtr__local__;
						}
						else {
							symbol_7 = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapOclExpression = symbol_7;
					}
					else {
						raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
					}
					symbol_8 = raw_when_mapOclExpression;
				}
				else {
					symbol_8 = ValueUtil.FALSE_VALUE;
				}
				symbol_9 = symbol_8;
			}
			else {
				symbol_9 = ValueUtil.FALSE_VALUE;
			}
			trace_15.setLocalSuccess(symbol_9);
			objectManager.assigned(trace_15, trace_ATL2QVTrPackage.Literals.TMAP_OPERATOR_CALL_EXP__LOCAL_SUCCESS, symbol_9);
			return symbol_9;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_15, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapOperationCallExp__Operation__qvtr__local__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Operation[1] success localSuccess;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperationCallExp_Operation;
	 * check var atlExpression : OCL::OperationCallExp[1] := dispatcher.d1atlExpression;
	 * var not_mapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1] := dispatcher.domapOperatorCallExp;
	 * observe trace_ATL2QVTr::ImapOclExpression::success check not_mapOperatorCallExp.success = false;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlSource.DmapOclExpression;
	 * observe qvttrace::Dispatch::success check when_mapOclExpression.success;
	 * var operationName : String[1] := atlExpression.operationName;
	 * notify set trace.t0operationName := operationName;
	 * set trace.t1atlSource := atlSource;
	 * notify set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected class MAP_mmapOperationCallExp__Operation__qvtr__local__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace_16;

		public MAP_mmapOperationCallExp__Operation__qvtr__local__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_16 = (@NonNull TmapOperationCallExp_Operation)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_16.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Operation domapOperationCallExp_Operation = dispatcher_0.getDomapOperationCallExp_Operation();
			final /*@NonInvalid*/ boolean eq = trace_16.equals(domapOperationCallExp_Operation);
			/*@Thrown*/ @Nullable Boolean symbol_11;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof OperationCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_10;
				if (symbol_0) {
					final /*@NonInvalid*/ @NonNull OperationCallExp symbol_1 = (OperationCallExp)temp1_atlExpression;
					final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher_0.getDomapOperatorCallExp();
					final /*@NonInvalid*/ boolean symbol_2 = domapOperatorCallExp != null;
					/*@Thrown*/ @Nullable Boolean raw_not_mapOperatorCallExp;
					if (symbol_2) {
						if (domapOperatorCallExp == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						objectManager.getting(domapOperatorCallExp, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, false);
						final /*@Thrown*/ @Nullable Boolean success = domapOperatorCallExp.getSuccess();
						final /*@Thrown*/ boolean eq_0 = success == Boolean.FALSE;
						/*@Thrown*/ @Nullable Boolean symbol_9;
						if (eq_0) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OclExpression source = symbol_1.getSource();
							final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(source);
							final /*@NonInvalid*/ boolean symbol_3 = DmapOclExpression != null;
							/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
							if (symbol_3) {
								if (DmapOclExpression == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								objectManager.getting(DmapOclExpression, QVTtracePackage.Literals.DISPATCH__SUCCESS, false);
								final /*@Thrown*/ @Nullable Boolean success_0 = DmapOclExpression.getSuccess();
								if (success_0 == null) {
									throw new InvalidEvaluationException("Null if condition");
								}
								/*@Thrown*/ @Nullable Boolean symbol_8;
								if (success_0) {
									@SuppressWarnings("null")
									final /*@NonInvalid*/ @NonNull String operationName = symbol_1.getOperationName();
									// mapping statements
									trace_16.setT0operationName(operationName);
									objectManager.assigned(trace_16, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_OPERATION__T0OPERATION_NAME, operationName);
									trace_16.setT1atlSource(source);
									trace_16.setWmapOclExpression(DmapOclExpression);
									objectManager.assigned(trace_16, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_OPERATION__WMAP_OCL_EXPRESSION, DmapOclExpression);
									final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Operation__qvtr__local__ = ValueUtil.TRUE_VALUE;
									symbol_8 = mmapOperationCallExp__Operation__qvtr__local__;
								}
								else {
									symbol_8 = ValueUtil.FALSE_VALUE;
								}
								raw_when_mapOclExpression = symbol_8;
							}
							else {
								raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
							}
							symbol_9 = raw_when_mapOclExpression;
						}
						else {
							symbol_9 = ValueUtil.FALSE_VALUE;
						}
						raw_not_mapOperatorCallExp = symbol_9;
					}
					else {
						raw_not_mapOperatorCallExp = ValueUtil.FALSE_VALUE;
					}
					symbol_10 = raw_not_mapOperatorCallExp;
				}
				else {
					symbol_10 = ValueUtil.FALSE_VALUE;
				}
				symbol_11 = symbol_10;
			}
			else {
				symbol_11 = ValueUtil.FALSE_VALUE;
			}
			trace_16.setLocalSuccess(symbol_11);
			objectManager.assigned(trace_16, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_OPERATION__LOCAL_SUCCESS, symbol_11);
			return symbol_11;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_16, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapHelper__Operation__qvtr__global__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Operation[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * check trace = dispatcher.domapHelper_Operation;
	 * observe trace_ATL2QVTr::TmapHelper_Operation::localSuccess check trace.localSuccess;
	 * observe trace_ATL2QVTr::TmapHelper_Operation::wmapOclExpression var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * set dispatcher.result := trace;
	 *
	 */
	protected class MAP_mmapHelper__Operation__qvtr__global__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapHelper_Operation trace_17;

		public MAP_mmapHelper__Operation__qvtr__global__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_17 = (@NonNull TmapHelper_Operation)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_17.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapHelper_Operation domapHelper_Operation = dispatcher_0.getDomapHelper_Operation();
			final /*@NonInvalid*/ boolean eq = trace_17.equals(domapHelper_Operation);
			/*@Thrown*/ @Nullable Boolean symbol_4;
			if (eq) {
				objectManager.getting(trace_17, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_OPERATION__LOCAL_SUCCESS, false);
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_17.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_3;
				if (localSuccess) {
					objectManager.getting(trace_17, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_OPERATION__WMAP_OCL_EXPRESSION, false);
					final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_17.getWmapOclExpression();
					final /*@NonInvalid*/ boolean symbol_0 = wmapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
					if (symbol_0) {
						if (wmapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						// mapping statements
						dispatcher_0.setResult(trace_17);
						final /*@Thrown*/ @Nullable Boolean mmapHelper__Operation__qvtr__global__ = ValueUtil.TRUE_VALUE;
						raw_when_mapOclExpression = mmapHelper__Operation__qvtr__global__;
					}
					else {
						raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
					}
					symbol_3 = raw_when_mapOclExpression;
				}
				else {
					symbol_3 = ValueUtil.FALSE_VALUE;
				}
				symbol_4 = symbol_3;
			}
			else {
				symbol_4 = ValueUtil.FALSE_VALUE;
			}
			trace_17.setSuccess(symbol_4);
			objectManager.assigned(trace_17, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__SUCCESS, symbol_4);
			return symbol_4;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_17, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapOperatorCallExp__qvtr__global__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperatorCallExp[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperatorCallExp;
	 * observe trace_ATL2QVTr::TmapOperatorCallExp::localSuccess check trace.localSuccess;
	 * observe trace_ATL2QVTr::TmapOperatorCallExp::wmapOclExpression var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * set dispatcher.result := trace;
	 *
	 */
	protected class MAP_mmapOperatorCallExp__qvtr__global__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace_18;

		public MAP_mmapOperatorCallExp__qvtr__global__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_18 = (@NonNull TmapOperatorCallExp)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_18.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher_0.getDomapOperatorCallExp();
			final /*@NonInvalid*/ boolean eq = trace_18.equals(domapOperatorCallExp);
			/*@Thrown*/ @Nullable Boolean symbol_4;
			if (eq) {
				objectManager.getting(trace_18, trace_ATL2QVTrPackage.Literals.TMAP_OPERATOR_CALL_EXP__LOCAL_SUCCESS, false);
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_18.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_3;
				if (localSuccess) {
					objectManager.getting(trace_18, trace_ATL2QVTrPackage.Literals.TMAP_OPERATOR_CALL_EXP__WMAP_OCL_EXPRESSION, false);
					final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_18.getWmapOclExpression();
					final /*@NonInvalid*/ boolean symbol_0 = wmapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
					if (symbol_0) {
						if (wmapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						// mapping statements
						dispatcher_0.setResult(trace_18);
						final /*@Thrown*/ @Nullable Boolean mmapOperatorCallExp__qvtr__global__ = ValueUtil.TRUE_VALUE;
						raw_when_mapOclExpression = mmapOperatorCallExp__qvtr__global__;
					}
					else {
						raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
					}
					symbol_3 = raw_when_mapOclExpression;
				}
				else {
					symbol_3 = ValueUtil.FALSE_VALUE;
				}
				symbol_4 = symbol_3;
			}
			else {
				symbol_4 = ValueUtil.FALSE_VALUE;
			}
			trace_18.setSuccess(symbol_4);
			objectManager.assigned(trace_18, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_4);
			return symbol_4;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_18, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapIfExp__qvtr__global__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapIfExp[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapIfExp;
	 * observe trace_ATL2QVTr::TmapIfExp::localSuccess check trace.localSuccess;
	 * observe trace_ATL2QVTr::TmapIfExp::wmapOclExpression var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * observe trace_ATL2QVTr::TmapIfExp::wmapOclExpression2 var when_mapOclExpression1 : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression2;
	 * observe trace_ATL2QVTr::TmapIfExp::wmapOclExpression1 var when_mapOclExpression2 : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression1;
	 * set dispatcher.result := trace;
	 *
	 */
	protected class MAP_mmapIfExp__qvtr__global__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapIfExp trace_19;

		public MAP_mmapIfExp__qvtr__global__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_19 = (@NonNull TmapIfExp)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_19.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapIfExp domapIfExp = dispatcher_0.getDomapIfExp();
			final /*@NonInvalid*/ boolean eq = trace_19.equals(domapIfExp);
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (eq) {
				objectManager.getting(trace_19, trace_ATL2QVTrPackage.Literals.TMAP_IF_EXP__LOCAL_SUCCESS, false);
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_19.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (localSuccess) {
					objectManager.getting(trace_19, trace_ATL2QVTrPackage.Literals.TMAP_IF_EXP__WMAP_OCL_EXPRESSION, false);
					final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_19.getWmapOclExpression();
					final /*@NonInvalid*/ boolean symbol_0 = wmapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
					if (symbol_0) {
						if (wmapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						objectManager.getting(trace_19, trace_ATL2QVTrPackage.Literals.TMAP_IF_EXP__WMAP_OCL_EXPRESSION2, false);
						final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression2 = trace_19.getWmapOclExpression2();
						final /*@NonInvalid*/ boolean symbol_1 = wmapOclExpression2 != null;
						/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression1;
						if (symbol_1) {
							if (wmapOclExpression2 == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							objectManager.getting(trace_19, trace_ATL2QVTrPackage.Literals.TMAP_IF_EXP__WMAP_OCL_EXPRESSION1, false);
							final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression1 = trace_19.getWmapOclExpression1();
							final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression1 != null;
							/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression2;
							if (symbol_2) {
								if (wmapOclExpression1 == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								// mapping statements
								dispatcher_0.setResult(trace_19);
								final /*@Thrown*/ @Nullable Boolean mmapIfExp__qvtr__global__ = ValueUtil.TRUE_VALUE;
								raw_when_mapOclExpression2 = mmapIfExp__qvtr__global__;
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
					symbol_5 = raw_when_mapOclExpression;
				}
				else {
					symbol_5 = ValueUtil.FALSE_VALUE;
				}
				symbol_6 = symbol_5;
			}
			else {
				symbol_6 = ValueUtil.FALSE_VALUE;
			}
			trace_19.setSuccess(symbol_6);
			objectManager.assigned(trace_19, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_6);
			return symbol_6;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_19, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapNavigationOrAttributeCallExp__Property__qvtr__g in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapNavigationOrAttributeCallExp_Property;
	 * check var atlExpression : OCL::NavigationOrAttributeCallExp[1] := dispatcher.d1atlExpression;
	 * observe trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property::localSuccess check trace.localSuccess;
	 * observe trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property::wmapOclExpression var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * observe trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property::t0propertyName var propertyName : String[1] := trace.t0propertyName;
	 * var atlModule : ATL::Module[1] := this.getModule(atlExpression)
	 *   ;
	 * var elements : OrderedSet(ATL::ModuleElement) := atlModule.elements;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var collect : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(_'1_' | _'1_'.definition)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Attribute) := collect->collect(_'1_' | _'1_'.feature)
	 *   ->selectByKind(OCL::Attribute)
	 *   ;
	 * var select : Sequence(OCL::Attribute) := selectByKind1->select(_'1_' | _'1_'.name = propertyName)
	 *   ;
	 * var isEmpty : Boolean[1] := select->isEmpty()
	 *   ;
	 * check isEmpty;
	 * var collect1 : Sequence(OCL::OclFeature) := collect->collect(_'1_' | _'1_'.feature);
	 * set dispatcher.result := trace;
	 *
	 */
	protected class MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__g extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace_20;

		public MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__g(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_20 = (@NonNull TmapNavigationOrAttributeCallExp_Property)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_20.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Property domapNavigationOrAttributeCallExp_Property = dispatcher_0.getDomapNavigationOrAttributeCallExp_Property();
			final /*@NonInvalid*/ boolean eq = trace_20.equals(domapNavigationOrAttributeCallExp_Property);
			/*@Thrown*/ @Nullable Boolean symbol_8;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof NavigationOrAttributeCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_7;
				if (symbol_0) {
					final /*@NonInvalid*/ @NonNull NavigationOrAttributeCallExp symbol_1 = (NavigationOrAttributeCallExp)temp1_atlExpression;
					objectManager.getting(trace_20, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__LOCAL_SUCCESS, false);
					final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_20.getLocalSuccess();
					if (localSuccess == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_6;
					if (localSuccess) {
						objectManager.getting(trace_20, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__WMAP_OCL_EXPRESSION, false);
						final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_20.getWmapOclExpression();
						final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
						/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
						if (symbol_2) {
							if (wmapOclExpression == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							objectManager.getting(trace_20, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T0PROPERTY_NAME, false);
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String t0propertyName = trace_20.getT0propertyName();
							final /*@NonInvalid*/ @NonNull Module getModule = ((FUN_getModule)FTOR_getModule.getUniqueComputation(ATL2QVTr.this, symbol_1)).instance;
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull List<ModuleElement> elements = getModule.getElements();
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ATL_c_c_Helper_0 = idResolver.getClass(CLSSid_Helper, null);
							final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_elements = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleElement, elements);
							final /*@NonInvalid*/ @NonNull OrderedSetValue selectByKind = (@Nullable OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_elements, TYP_ATL_c_c_Helper_0);
							/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeatureDefinition);
							@NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
							/*@NonInvalid*/ @NonNull SequenceValue collect;
							while (true) {
								if (!ITERATOR__1.hasNext()) {
									collect = accumulator;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ @NonNull Helper _1 = (@NonNull Helper)ITERATOR__1.next();
								/**
								 * _'1_'.definition
								 */
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = _1.getDefinition();
								//
								accumulator.add(definition);
							}
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_Attribute_0 = idResolver.getClass(CLSSid_Attribute, null);
							/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeature);
							@NonNull Iterator<Object> ITERATOR__1_0 = collect.iterator();
							/*@NonInvalid*/ @NonNull SequenceValue collect_0;
							while (true) {
								if (!ITERATOR__1_0.hasNext()) {
									collect_0 = accumulator_0;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ @NonNull OclFeatureDefinition _1_0 = (@NonNull OclFeatureDefinition)ITERATOR__1_0.next();
								/**
								 * _'1_'.feature
								 */
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull OclFeature feature = _1_0.getFeature();
								//
								accumulator_0.add(feature);
							}
							final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (@Nullable SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_0, TYP_OCL_c_c_Attribute_0);
							/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Attribute);
							@NonNull Iterator<Object> ITERATOR__1_1 = selectByKind_0.iterator();
							/*@NonInvalid*/ @NonNull SequenceValue select;
							while (true) {
								if (!ITERATOR__1_1.hasNext()) {
									select = accumulator_1;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ @NonNull Attribute _1_1 = (@NonNull Attribute)ITERATOR__1_1.next();
								/**
								 * _'1_'.name = propertyName
								 */
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull String name_2 = _1_1.getName();
								final /*@NonInvalid*/ boolean eq_0 = name_2.equals(t0propertyName);
								//
								if (eq_0 == ValueUtil.TRUE_VALUE) {
									accumulator_1.add(_1_1);
								}
							}
							final /*@NonInvalid*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(select).booleanValue();
							/*@Thrown*/ @Nullable Boolean symbol_5;
							if (isEmpty) {
								// mapping statements
								dispatcher_0.setResult(trace_20);
								final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Property__qvtr__g = ValueUtil.TRUE_VALUE;
								symbol_5 = mmapNavigationOrAttributeCallExp__Property__qvtr__g;
							}
							else {
								symbol_5 = ValueUtil.FALSE_VALUE;
							}
							raw_when_mapOclExpression = symbol_5;
						}
						else {
							raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
						}
						symbol_6 = raw_when_mapOclExpression;
					}
					else {
						symbol_6 = ValueUtil.FALSE_VALUE;
					}
					symbol_7 = symbol_6;
				}
				else {
					symbol_7 = ValueUtil.FALSE_VALUE;
				}
				symbol_8 = symbol_7;
			}
			else {
				symbol_8 = ValueUtil.FALSE_VALUE;
			}
			trace_20.setSuccess(symbol_8);
			objectManager.assigned(trace_20, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_8);
			return symbol_8;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_20, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapHelper__Attribute__qvtr__global__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Attribute[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * check trace = dispatcher.domapHelper_Attribute;
	 * observe trace_ATL2QVTr::TmapHelper_Attribute::localSuccess check trace.localSuccess;
	 * observe trace_ATL2QVTr::TmapHelper_Attribute::wmapOclExpression var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * set dispatcher.result := trace;
	 *
	 */
	protected class MAP_mmapHelper__Attribute__qvtr__global__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapHelper_Attribute trace_21;

		public MAP_mmapHelper__Attribute__qvtr__global__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_21 = (@NonNull TmapHelper_Attribute)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_21.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapHelper_Attribute domapHelper_Attribute = dispatcher_0.getDomapHelper_Attribute();
			final /*@NonInvalid*/ boolean eq = trace_21.equals(domapHelper_Attribute);
			/*@Thrown*/ @Nullable Boolean symbol_4;
			if (eq) {
				objectManager.getting(trace_21, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_ATTRIBUTE__LOCAL_SUCCESS, false);
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_21.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_3;
				if (localSuccess) {
					objectManager.getting(trace_21, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_ATTRIBUTE__WMAP_OCL_EXPRESSION, false);
					final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_21.getWmapOclExpression();
					final /*@NonInvalid*/ boolean symbol_0 = wmapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
					if (symbol_0) {
						if (wmapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						// mapping statements
						dispatcher_0.setResult(trace_21);
						final /*@Thrown*/ @Nullable Boolean mmapHelper__Attribute__qvtr__global__ = ValueUtil.TRUE_VALUE;
						raw_when_mapOclExpression = mmapHelper__Attribute__qvtr__global__;
					}
					else {
						raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
					}
					symbol_3 = raw_when_mapOclExpression;
				}
				else {
					symbol_3 = ValueUtil.FALSE_VALUE;
				}
				symbol_4 = symbol_3;
			}
			else {
				symbol_4 = ValueUtil.FALSE_VALUE;
			}
			trace_21.setSuccess(symbol_4);
			objectManager.assigned(trace_21, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__SUCCESS, symbol_4);
			return symbol_4;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_21, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapOperationCallExp__Operation__qvtr__global__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Operation[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperationCallExp_Operation;
	 * check var atlExpression : OCL::OperationCallExp[1] := dispatcher.d1atlExpression;
	 * var not_mapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1] := dispatcher.domapOperatorCallExp;
	 * observe trace_ATL2QVTr::TmapOperationCallExp_Operation::localSuccess check trace.localSuccess;
	 * observe trace_ATL2QVTr::TmapOperationCallExp_Operation::wmapOclExpression var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * observe trace_ATL2QVTr::TmapOperationCallExp_Operation::t0operationName var operationName : String[1] := trace.t0operationName;
	 * observe trace_ATL2QVTr::ImapOclExpression::success check not_mapOperatorCallExp.success =
	 *   false;
	 * var getModule1 : ATL::Module[1] := this.getModule(atlExpression)
	 *   ;
	 * var elements : OrderedSet(ATL::ModuleElement) := getModule1.elements;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var collect : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(_'1_' | _'1_'.definition)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Operation) := collect->collect(_'1_' | _'1_'.feature)
	 *   ->selectByKind(OCL::Operation)
	 *   ;
	 * var select : Sequence(OCL::Operation) := selectByKind1->select(_'1_' | _'1_'.name = operationName)
	 *   ;
	 * var isEmpty : Boolean[1] := select->isEmpty()
	 *   ;
	 * check isEmpty;
	 * var collect1 : Sequence(OCL::OclFeature) := collect->collect(_'1_' | _'1_'.feature);
	 * set dispatcher.result := trace;
	 *
	 */
	protected class MAP_mmapOperationCallExp__Operation__qvtr__global__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace_22;

		public MAP_mmapOperationCallExp__Operation__qvtr__global__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_22 = (@NonNull TmapOperationCallExp_Operation)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_22.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Operation domapOperationCallExp_Operation = dispatcher_0.getDomapOperationCallExp_Operation();
			final /*@NonInvalid*/ boolean eq = trace_22.equals(domapOperationCallExp_Operation);
			/*@Thrown*/ @Nullable Boolean symbol_10;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof OperationCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_9;
				if (symbol_0) {
					final /*@NonInvalid*/ @NonNull OperationCallExp symbol_1 = (OperationCallExp)temp1_atlExpression;
					final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher_0.getDomapOperatorCallExp();
					final /*@NonInvalid*/ boolean symbol_2 = domapOperatorCallExp != null;
					/*@Thrown*/ @Nullable Boolean raw_not_mapOperatorCallExp;
					if (symbol_2) {
						if (domapOperatorCallExp == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						objectManager.getting(trace_22, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_OPERATION__LOCAL_SUCCESS, false);
						final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_22.getLocalSuccess();
						if (localSuccess == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_8;
						if (localSuccess) {
							objectManager.getting(trace_22, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_OPERATION__WMAP_OCL_EXPRESSION, false);
							final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_22.getWmapOclExpression();
							final /*@NonInvalid*/ boolean symbol_3 = wmapOclExpression != null;
							/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
							if (symbol_3) {
								if (wmapOclExpression == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								objectManager.getting(trace_22, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_OPERATION__T0OPERATION_NAME, false);
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull String t0operationName = trace_22.getT0operationName();
								objectManager.getting(domapOperatorCallExp, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, false);
								final /*@Thrown*/ @Nullable Boolean success = domapOperatorCallExp.getSuccess();
								final /*@Thrown*/ boolean eq_0 = success == Boolean.FALSE;
								/*@Thrown*/ @Nullable Boolean symbol_7;
								if (eq_0) {
									final /*@NonInvalid*/ @NonNull Module getModule = ((FUN_getModule)FTOR_getModule.getUniqueComputation(ATL2QVTr.this, symbol_1)).instance;
									@SuppressWarnings("null")
									final /*@NonInvalid*/ @NonNull List<ModuleElement> elements = getModule.getElements();
									final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ATL_c_c_Helper_0 = idResolver.getClass(CLSSid_Helper, null);
									final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_elements = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleElement, elements);
									final /*@NonInvalid*/ @NonNull OrderedSetValue selectByKind = (@Nullable OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_elements, TYP_ATL_c_c_Helper_0);
									/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeatureDefinition);
									@NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
									/*@NonInvalid*/ @NonNull SequenceValue collect;
									while (true) {
										if (!ITERATOR__1.hasNext()) {
											collect = accumulator;
											break;
										}
										@SuppressWarnings("null")
										/*@NonInvalid*/ @NonNull Helper _1 = (@NonNull Helper)ITERATOR__1.next();
										/**
										 * _'1_'.definition
										 */
										@SuppressWarnings("null")
										final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = _1.getDefinition();
										//
										accumulator.add(definition);
									}
									final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
									/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeature);
									@NonNull Iterator<Object> ITERATOR__1_0 = collect.iterator();
									/*@NonInvalid*/ @NonNull SequenceValue collect_0;
									while (true) {
										if (!ITERATOR__1_0.hasNext()) {
											collect_0 = accumulator_0;
											break;
										}
										@SuppressWarnings("null")
										/*@NonInvalid*/ @NonNull OclFeatureDefinition _1_0 = (@NonNull OclFeatureDefinition)ITERATOR__1_0.next();
										/**
										 * _'1_'.feature
										 */
										@SuppressWarnings("null")
										final /*@NonInvalid*/ @NonNull OclFeature feature = _1_0.getFeature();
										//
										accumulator_0.add(feature);
									}
									final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (@Nullable SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_0, TYP_OCL_c_c_Operation_0);
									/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
									@NonNull Iterator<Object> ITERATOR__1_1 = selectByKind_0.iterator();
									/*@NonInvalid*/ @NonNull SequenceValue select;
									while (true) {
										if (!ITERATOR__1_1.hasNext()) {
											select = accumulator_1;
											break;
										}
										@SuppressWarnings("null")
										/*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation _1_1 = (org.eclipse.m2m.atl.common.OCL.@NonNull Operation)ITERATOR__1_1.next();
										/**
										 * _'1_'.name = operationName
										 */
										@SuppressWarnings("null")
										final /*@NonInvalid*/ @NonNull String name_2 = _1_1.getName();
										final /*@NonInvalid*/ boolean eq_1 = name_2.equals(t0operationName);
										//
										if (eq_1 == ValueUtil.TRUE_VALUE) {
											accumulator_1.add(_1_1);
										}
									}
									final /*@NonInvalid*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(select).booleanValue();
									/*@Thrown*/ @Nullable Boolean symbol_6;
									if (isEmpty) {
										// mapping statements
										dispatcher_0.setResult(trace_22);
										final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Operation__qvtr__global__ = ValueUtil.TRUE_VALUE;
										symbol_6 = mmapOperationCallExp__Operation__qvtr__global__;
									}
									else {
										symbol_6 = ValueUtil.FALSE_VALUE;
									}
									symbol_7 = symbol_6;
								}
								else {
									symbol_7 = ValueUtil.FALSE_VALUE;
								}
								raw_when_mapOclExpression = symbol_7;
							}
							else {
								raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
							}
							symbol_8 = raw_when_mapOclExpression;
						}
						else {
							symbol_8 = ValueUtil.FALSE_VALUE;
						}
						raw_not_mapOperatorCallExp = symbol_8;
					}
					else {
						raw_not_mapOperatorCallExp = ValueUtil.FALSE_VALUE;
					}
					symbol_9 = raw_not_mapOperatorCallExp;
				}
				else {
					symbol_9 = ValueUtil.FALSE_VALUE;
				}
				symbol_10 = symbol_9;
			}
			else {
				symbol_10 = ValueUtil.FALSE_VALUE;
			}
			trace_22.setSuccess(symbol_10);
			objectManager.assigned(trace_22, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_10);
			return symbol_10;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_22, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapNavigationOrAttributeCallExp__Helper__qvtr__glo in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapNavigationOrAttributeCallExp_Helper;
	 * check var atlExpression : OCL::NavigationOrAttributeCallExp[1] := dispatcher.d1atlExpression;
	 * observe trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper::localSuccess check trace.localSuccess;
	 * observe trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper::wmapOclExpression var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * observe trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper::t0propertyName var propertyName : String[1] := trace.t0propertyName;
	 * var atlModule : ATL::Module[1] := this.getModule(atlExpression)
	 *   ;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * var elements : OrderedSet(ATL::ModuleElement) := atlModule.elements;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var collect : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(_'1_' | _'1_'.definition)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Attribute) := collect->collect(_'1_' | _'1_'.feature)
	 *   ->selectByKind(OCL::Attribute)
	 *   ;
	 * var atlAttributes : Sequence(OCL::Attribute) := selectByKind1->select(_'1_' | _'1_'.name = propertyName)
	 *   ;
	 * var notEmpty : Boolean[1] := atlAttributes->notEmpty()
	 *   ;
	 * check notEmpty;
	 * var any : OCL::Attribute[1] := atlAttributes->any(_'1_' | true)
	 *   ;
	 * var definition : OCL::OclFeatureDefinition[?] := any.definition;
	 * var Helper1 : ATL::Helper[?] := definition?.Helper;
	 * var _'if' : ATL::Helper[1] := if definition = null
	 *   then null
	 *   else Helper1
	 *   endif
	 *   ;
	 * var when_mapHelper_Attribute : trace_ATL2QVTr::DmapHelper[1] := _'if'.DmapHelper;
	 * var collect1 : Sequence(OCL::OclFeature) := collect->collect(_'1_' | _'1_'.feature);
	 * var equals : Boolean[1] := definition = null;
	 * set dispatcher.result := trace;
	 * set trace.wmapHelper := when_mapHelper_Attribute;
	 * set trace.wmapModule := when_mapModule;
	 *
	 */
	protected class MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__glo extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_23;

		public MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__glo(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_23 = (@NonNull TmapNavigationOrAttributeCallExp_Helper)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_23.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Helper domapNavigationOrAttributeCallExp_Helper = dispatcher_0.getDomapNavigationOrAttributeCallExp_Helper();
			final /*@NonInvalid*/ boolean eq = trace_23.equals(domapNavigationOrAttributeCallExp_Helper);
			/*@Thrown*/ @Nullable Boolean symbol_14;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof NavigationOrAttributeCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_13;
				if (symbol_0) {
					final /*@NonInvalid*/ @NonNull NavigationOrAttributeCallExp symbol_1 = (NavigationOrAttributeCallExp)temp1_atlExpression;
					objectManager.getting(trace_23, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__LOCAL_SUCCESS, false);
					final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_23.getLocalSuccess();
					if (localSuccess == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_12;
					if (localSuccess) {
						objectManager.getting(trace_23, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION, false);
						final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_23.getWmapOclExpression();
						final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
						/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
						if (symbol_2) {
							if (wmapOclExpression == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							objectManager.getting(trace_23, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T0PROPERTY_NAME, false);
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String t0propertyName = trace_23.getT0propertyName();
							final /*@NonInvalid*/ @NonNull Module getModule = ((FUN_getModule)FTOR_getModule.getUniqueComputation(ATL2QVTr.this, symbol_1)).instance;
							final /*@NonInvalid*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t1atlModule.get(getModule);
							final /*@NonInvalid*/ boolean symbol_3 = TmapModule != null;
							/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
							if (symbol_3) {
								if (TmapModule == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull List<ModuleElement> elements = getModule.getElements();
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ATL_c_c_Helper_0 = idResolver.getClass(CLSSid_Helper, null);
								final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_elements = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleElement, elements);
								final /*@NonInvalid*/ @NonNull OrderedSetValue selectByKind = (@Nullable OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_elements, TYP_ATL_c_c_Helper_0);
								/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeatureDefinition);
								@NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
								/*@NonInvalid*/ @NonNull SequenceValue collect;
								while (true) {
									if (!ITERATOR__1.hasNext()) {
										collect = accumulator;
										break;
									}
									@SuppressWarnings("null")
									/*@NonInvalid*/ @NonNull Helper _1 = (@NonNull Helper)ITERATOR__1.next();
									/**
									 * _'1_'.definition
									 */
									@SuppressWarnings("null")
									final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = _1.getDefinition();
									//
									accumulator.add(definition);
								}
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_Attribute_0 = idResolver.getClass(CLSSid_Attribute, null);
								/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeature);
								@NonNull Iterator<Object> ITERATOR__1_0 = collect.iterator();
								/*@NonInvalid*/ @NonNull SequenceValue collect_0;
								while (true) {
									if (!ITERATOR__1_0.hasNext()) {
										collect_0 = accumulator_0;
										break;
									}
									@SuppressWarnings("null")
									/*@NonInvalid*/ @NonNull OclFeatureDefinition _1_0 = (@NonNull OclFeatureDefinition)ITERATOR__1_0.next();
									/**
									 * _'1_'.feature
									 */
									@SuppressWarnings("null")
									final /*@NonInvalid*/ @NonNull OclFeature feature = _1_0.getFeature();
									//
									accumulator_0.add(feature);
								}
								final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (@Nullable SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_0, TYP_OCL_c_c_Attribute_0);
								/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Attribute);
								@NonNull Iterator<Object> ITERATOR__1_1 = selectByKind_0.iterator();
								/*@NonInvalid*/ @NonNull SequenceValue select;
								while (true) {
									if (!ITERATOR__1_1.hasNext()) {
										select = accumulator_1;
										break;
									}
									@SuppressWarnings("null")
									/*@NonInvalid*/ @NonNull Attribute _1_1 = (@NonNull Attribute)ITERATOR__1_1.next();
									/**
									 * _'1_'.name = propertyName
									 */
									@SuppressWarnings("null")
									final /*@NonInvalid*/ @NonNull String name_2 = _1_1.getName();
									final /*@NonInvalid*/ boolean eq_0 = name_2.equals(t0propertyName);
									//
									if (eq_0 == ValueUtil.TRUE_VALUE) {
										accumulator_1.add(_1_1);
									}
								}
								final /*@NonInvalid*/ boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(select).booleanValue();
								/*@Thrown*/ @Nullable Boolean symbol_11;
								if (notEmpty) {
									@NonNull Iterator<Object> ITERATOR__1_2 = select.iterator();
									/*@Thrown*/ @NonNull Attribute any;
									while (true) {
										if (!ITERATOR__1_2.hasNext()) {
											throw new InvalidValueException("Nothing to return for ''any''");
										}
										@SuppressWarnings("null")
										/*@NonInvalid*/ @NonNull Attribute _1_2 = (@NonNull Attribute)ITERATOR__1_2.next();
										/**
										 * true
										 */
										//
										if (ValueUtil.TRUE_VALUE != ValueUtil.FALSE_VALUE) {			// Carry on till something found
											any = _1_2;
											break;
										}
									}
									final /*@Thrown*/ @Nullable OclFeatureDefinition definition_0 = any.getDefinition();
									/*@Caught*/ @Nullable Object CAUGHT_definition_0;
									try {
										CAUGHT_definition_0 = definition_0;
									}
									catch (Exception e) {
										CAUGHT_definition_0 = ValueUtil.createInvalidValue(e);
									}
									final /*@NonInvalid*/ @NonNull Object Helper = CAUGHT_definition_0 == null;
									/*@Thrown*/ @Nullable Helper safe_definition_source;
									if (Helper == Boolean.TRUE) {
										safe_definition_source = null;
									}
									else {
										final /*@NonInvalid*/ @NonNull UnboxedCompositionProperty IMPPROPid_definition = new UnboxedCompositionProperty(PROPid_definition);
										assert definition_0 != null;
										final /*@Thrown*/ @Nullable Helper Helper_0 = (@Nullable Helper)IMPPROPid_definition.evaluate(executor, CLSSid_Helper, definition_0);
										safe_definition_source = Helper_0;
									}
									final /*@Thrown*/ boolean eq_1 = definition_0 == null;
									/*@Thrown*/ @Nullable Helper symbol_4;
									if (eq_1) {
										symbol_4 = null;
									}
									else {
										symbol_4 = safe_definition_source;
									}
									final /*@Thrown*/ boolean symbol_5 = symbol_4 != null;
									/*@Thrown*/ @Nullable Boolean raw_if;
									if (symbol_5) {
										if (symbol_4 == null) {
											throw new InvalidEvaluationException("Null where non-null value required");
										}
										final /*@Thrown*/ @Nullable DmapHelper DmapHelper = OPPOSITE_OF_DmapHelper_d1atlHelper.get(symbol_4);
										final /*@Thrown*/ boolean symbol_6 = DmapHelper != null;
										/*@Thrown*/ @Nullable Boolean raw_when_mapHelper_Attribute;
										if (symbol_6) {
											if (DmapHelper == null) {
												throw new InvalidEvaluationException("Null where non-null value required");
											}
											// mapping statements
											dispatcher_0.setResult(trace_23);
											trace_23.setWmapHelper(DmapHelper);
											trace_23.setWmapModule(TmapModule);
											final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Helper__qvtr__glo = ValueUtil.TRUE_VALUE;
											raw_when_mapHelper_Attribute = mmapNavigationOrAttributeCallExp__Helper__qvtr__glo;
										}
										else {
											raw_when_mapHelper_Attribute = ValueUtil.FALSE_VALUE;
										}
										raw_if = raw_when_mapHelper_Attribute;
									}
									else {
										raw_if = ValueUtil.FALSE_VALUE;
									}
									symbol_11 = raw_if;
								}
								else {
									symbol_11 = ValueUtil.FALSE_VALUE;
								}
								raw_when_mapModule = symbol_11;
							}
							else {
								raw_when_mapModule = ValueUtil.FALSE_VALUE;
							}
							raw_when_mapOclExpression = raw_when_mapModule;
						}
						else {
							raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
						}
						symbol_12 = raw_when_mapOclExpression;
					}
					else {
						symbol_12 = ValueUtil.FALSE_VALUE;
					}
					symbol_13 = symbol_12;
				}
				else {
					symbol_13 = ValueUtil.FALSE_VALUE;
				}
				symbol_14 = symbol_13;
			}
			else {
				symbol_14 = ValueUtil.FALSE_VALUE;
			}
			trace_23.setSuccess(symbol_14);
			objectManager.assigned(trace_23, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_14);
			return symbol_14;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_23, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapOperationCallExp__Helper__qvtr__global__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapOperationCallExp_Helper;
	 * check var atlExpression : OCL::OperationCallExp[1] := dispatcher.d1atlExpression;
	 * observe trace_ATL2QVTr::TmapOperationCallExp_Helper::localSuccess check trace.localSuccess;
	 * observe trace_ATL2QVTr::TmapOperationCallExp_Helper::wmapOclExpression var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * observe trace_ATL2QVTr::TmapOperationCallExp_Helper::t0operationName var operationName : String[1] := trace.t0operationName;
	 * var atlModule : ATL::Module[1] := this.getModule(atlExpression)
	 *   ;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * var elements : OrderedSet(ATL::ModuleElement) := atlModule.elements;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var collect : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(_'1_' | _'1_'.definition)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Operation) := collect->collect(_'1_' | _'1_'.feature)
	 *   ->selectByKind(OCL::Operation)
	 *   ;
	 * var atlOperations : Sequence(OCL::Operation) := selectByKind1->select(_'1_' | _'1_'.name = operationName)
	 *   ;
	 * var notEmpty : Boolean[1] := atlOperations->notEmpty()
	 *   ;
	 * check notEmpty;
	 * var any : OCL::Operation[1] := atlOperations->any(_'1_' | true)
	 *   ;
	 * var definition : OCL::OclFeatureDefinition[?] := any.definition;
	 * var Helper1 : ATL::Helper[?] := definition?.Helper;
	 * var _'if' : ATL::Helper[1] := if definition = null
	 *   then null
	 *   else Helper1
	 *   endif
	 *   ;
	 * var when_mapHelper_Operation : trace_ATL2QVTr::DmapHelper[1] := _'if'.DmapHelper;
	 * var collect1 : Sequence(OCL::OclFeature) := collect->collect(_'1_' | _'1_'.feature);
	 * var equals : Boolean[1] := definition = null;
	 * set dispatcher.result := trace;
	 * set trace.wmapHelper := when_mapHelper_Operation;
	 * set trace.wmapModule := when_mapModule;
	 *
	 */
	protected class MAP_mmapOperationCallExp__Helper__qvtr__global__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_24;

		public MAP_mmapOperationCallExp__Helper__qvtr__global__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_24 = (@NonNull TmapOperationCallExp_Helper)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_24.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Helper domapOperationCallExp_Helper = dispatcher_0.getDomapOperationCallExp_Helper();
			final /*@NonInvalid*/ boolean eq = trace_24.equals(domapOperationCallExp_Helper);
			/*@Thrown*/ @Nullable Boolean symbol_14;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof OperationCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_13;
				if (symbol_0) {
					final /*@NonInvalid*/ @NonNull OperationCallExp symbol_1 = (OperationCallExp)temp1_atlExpression;
					objectManager.getting(trace_24, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__LOCAL_SUCCESS, false);
					final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_24.getLocalSuccess();
					if (localSuccess == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_12;
					if (localSuccess) {
						objectManager.getting(trace_24, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION, false);
						final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_24.getWmapOclExpression();
						final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
						/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
						if (symbol_2) {
							if (wmapOclExpression == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							objectManager.getting(trace_24, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__T0OPERATION_NAME, false);
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String t0operationName = trace_24.getT0operationName();
							final /*@NonInvalid*/ @NonNull Module getModule = ((FUN_getModule)FTOR_getModule.getUniqueComputation(ATL2QVTr.this, symbol_1)).instance;
							final /*@NonInvalid*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t1atlModule.get(getModule);
							final /*@NonInvalid*/ boolean symbol_3 = TmapModule != null;
							/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
							if (symbol_3) {
								if (TmapModule == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull List<ModuleElement> elements = getModule.getElements();
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ATL_c_c_Helper_0 = idResolver.getClass(CLSSid_Helper, null);
								final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_elements = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleElement, elements);
								final /*@NonInvalid*/ @NonNull OrderedSetValue selectByKind = (@Nullable OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_elements, TYP_ATL_c_c_Helper_0);
								/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeatureDefinition);
								@NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
								/*@NonInvalid*/ @NonNull SequenceValue collect;
								while (true) {
									if (!ITERATOR__1.hasNext()) {
										collect = accumulator;
										break;
									}
									@SuppressWarnings("null")
									/*@NonInvalid*/ @NonNull Helper _1 = (@NonNull Helper)ITERATOR__1.next();
									/**
									 * _'1_'.definition
									 */
									@SuppressWarnings("null")
									final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = _1.getDefinition();
									//
									accumulator.add(definition);
								}
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
								/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeature);
								@NonNull Iterator<Object> ITERATOR__1_0 = collect.iterator();
								/*@NonInvalid*/ @NonNull SequenceValue collect_0;
								while (true) {
									if (!ITERATOR__1_0.hasNext()) {
										collect_0 = accumulator_0;
										break;
									}
									@SuppressWarnings("null")
									/*@NonInvalid*/ @NonNull OclFeatureDefinition _1_0 = (@NonNull OclFeatureDefinition)ITERATOR__1_0.next();
									/**
									 * _'1_'.feature
									 */
									@SuppressWarnings("null")
									final /*@NonInvalid*/ @NonNull OclFeature feature = _1_0.getFeature();
									//
									accumulator_0.add(feature);
								}
								final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (@Nullable SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_0, TYP_OCL_c_c_Operation_0);
								/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
								@NonNull Iterator<Object> ITERATOR__1_1 = selectByKind_0.iterator();
								/*@NonInvalid*/ @NonNull SequenceValue select;
								while (true) {
									if (!ITERATOR__1_1.hasNext()) {
										select = accumulator_1;
										break;
									}
									@SuppressWarnings("null")
									/*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation _1_1 = (org.eclipse.m2m.atl.common.OCL.@NonNull Operation)ITERATOR__1_1.next();
									/**
									 * _'1_'.name = operationName
									 */
									@SuppressWarnings("null")
									final /*@NonInvalid*/ @NonNull String name_2 = _1_1.getName();
									final /*@NonInvalid*/ boolean eq_0 = name_2.equals(t0operationName);
									//
									if (eq_0 == ValueUtil.TRUE_VALUE) {
										accumulator_1.add(_1_1);
									}
								}
								final /*@NonInvalid*/ boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(select).booleanValue();
								/*@Thrown*/ @Nullable Boolean symbol_11;
								if (notEmpty) {
									@NonNull Iterator<Object> ITERATOR__1_2 = select.iterator();
									/*@Thrown*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation any;
									while (true) {
										if (!ITERATOR__1_2.hasNext()) {
											throw new InvalidValueException("Nothing to return for ''any''");
										}
										@SuppressWarnings("null")
										/*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation _1_2 = (org.eclipse.m2m.atl.common.OCL.@NonNull Operation)ITERATOR__1_2.next();
										/**
										 * true
										 */
										//
										if (ValueUtil.TRUE_VALUE != ValueUtil.FALSE_VALUE) {			// Carry on till something found
											any = _1_2;
											break;
										}
									}
									final /*@Thrown*/ @Nullable OclFeatureDefinition definition_0 = any.getDefinition();
									/*@Caught*/ @Nullable Object CAUGHT_definition_0;
									try {
										CAUGHT_definition_0 = definition_0;
									}
									catch (Exception e) {
										CAUGHT_definition_0 = ValueUtil.createInvalidValue(e);
									}
									final /*@NonInvalid*/ @NonNull Object Helper = CAUGHT_definition_0 == null;
									/*@Thrown*/ @Nullable Helper safe_definition_source;
									if (Helper == Boolean.TRUE) {
										safe_definition_source = null;
									}
									else {
										final /*@NonInvalid*/ @NonNull UnboxedCompositionProperty IMPPROPid_definition = new UnboxedCompositionProperty(PROPid_definition);
										assert definition_0 != null;
										final /*@Thrown*/ @Nullable Helper Helper_0 = (@Nullable Helper)IMPPROPid_definition.evaluate(executor, CLSSid_Helper, definition_0);
										safe_definition_source = Helper_0;
									}
									final /*@Thrown*/ boolean eq_1 = definition_0 == null;
									/*@Thrown*/ @Nullable Helper symbol_4;
									if (eq_1) {
										symbol_4 = null;
									}
									else {
										symbol_4 = safe_definition_source;
									}
									final /*@Thrown*/ boolean symbol_5 = symbol_4 != null;
									/*@Thrown*/ @Nullable Boolean raw_if;
									if (symbol_5) {
										if (symbol_4 == null) {
											throw new InvalidEvaluationException("Null where non-null value required");
										}
										final /*@Thrown*/ @Nullable DmapHelper DmapHelper = OPPOSITE_OF_DmapHelper_d1atlHelper.get(symbol_4);
										final /*@Thrown*/ boolean symbol_6 = DmapHelper != null;
										/*@Thrown*/ @Nullable Boolean raw_when_mapHelper_Operation;
										if (symbol_6) {
											if (DmapHelper == null) {
												throw new InvalidEvaluationException("Null where non-null value required");
											}
											// mapping statements
											dispatcher_0.setResult(trace_24);
											trace_24.setWmapHelper(DmapHelper);
											trace_24.setWmapModule(TmapModule);
											final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Helper__qvtr__global__ = ValueUtil.TRUE_VALUE;
											raw_when_mapHelper_Operation = mmapOperationCallExp__Helper__qvtr__global__;
										}
										else {
											raw_when_mapHelper_Operation = ValueUtil.FALSE_VALUE;
										}
										raw_if = raw_when_mapHelper_Operation;
									}
									else {
										raw_if = ValueUtil.FALSE_VALUE;
									}
									symbol_11 = raw_if;
								}
								else {
									symbol_11 = ValueUtil.FALSE_VALUE;
								}
								raw_when_mapModule = symbol_11;
							}
							else {
								raw_when_mapModule = ValueUtil.FALSE_VALUE;
							}
							raw_when_mapOclExpression = raw_when_mapModule;
						}
						else {
							raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
						}
						symbol_12 = raw_when_mapOclExpression;
					}
					else {
						symbol_12 = ValueUtil.FALSE_VALUE;
					}
					symbol_13 = symbol_12;
				}
				else {
					symbol_13 = ValueUtil.FALSE_VALUE;
				}
				symbol_14 = symbol_13;
			}
			else {
				symbol_14 = ValueUtil.FALSE_VALUE;
			}
			trace_24.setSuccess(symbol_14);
			objectManager.assigned(trace_24, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_14);
			return symbol_14;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_24, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapOperatorCallExp__qvtr__speculated__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * append jo_OperationCallExp  : OperationCallExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperatorCallExp;
	 * observe trace_ATL2QVTr::TmapOperatorCallExp::localSuccess check trace.localSuccess;
	 * observe trace_ATL2QVTr::ImapOclExpression::success check trace.success;
	 * observe trace_ATL2QVTr::TmapOperatorCallExp::t0operationName var operationName : String[1] := trace.t0operationName;
	 * new:qvtr qvtrExpression : OperationCallExp[1];
	 * set qvtrExpression.name := operationName;
	 * notify set dispatcher.success := true;
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 * add jo_OperationCallExp += qvtrExpression;
	 *
	 */
	protected class MAP_mmapOperatorCallExp__qvtr__speculated__ extends AbstractInvocation
	{
		protected final @NonNull Connection jo_OperationCallExp;
		protected final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace_25;

		public MAP_mmapOperatorCallExp__qvtr__speculated__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			jo_OperationCallExp = (Connection)boundValues[0];
			trace_25 = (@NonNull TmapOperatorCallExp)boundValues[1];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_25.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher_0.getDomapOperatorCallExp();
			final /*@NonInvalid*/ boolean eq = trace_25.equals(domapOperatorCallExp);
			/*@Thrown*/ @Nullable Boolean symbol_7;
			if (eq) {
				objectManager.getting(trace_25, trace_ATL2QVTrPackage.Literals.TMAP_OPERATOR_CALL_EXP__LOCAL_SUCCESS, false);
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_25.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_6;
				if (localSuccess) {
					objectManager.getting(trace_25, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, false);
					final /*@NonInvalid*/ @Nullable Boolean success = trace_25.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_5;
					if (success) {
						objectManager.getting(trace_25, trace_ATL2QVTrPackage.Literals.TMAP_OPERATOR_CALL_EXP__T0OPERATION_NAME, false);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t0operationName = trace_25.getT0operationName();
						// creations
						final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
						models[1/*qvtr*/].add(qvtrExpression, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
						}
						// mapping statements
						qvtrExpression.setName(t0operationName);
						dispatcher_0.setSuccess(ValueUtil.TRUE_VALUE);
						objectManager.assigned(dispatcher_0, QVTtracePackage.Literals.DISPATCH__SUCCESS, ValueUtil.TRUE_VALUE);
						dispatcher_0.setD2qvtrExpression(qvtrExpression);
						jo_OperationCallExp.appendElement(qvtrExpression);
						final /*@Thrown*/ @Nullable Boolean mmapOperatorCallExp__qvtr__speculated__ = ValueUtil.TRUE_VALUE;
						symbol_5 = mmapOperatorCallExp__qvtr__speculated__;
					}
					else {
						symbol_5 = ValueUtil.FALSE_VALUE;
					}
					symbol_6 = symbol_5;
				}
				else {
					symbol_6 = ValueUtil.FALSE_VALUE;
				}
				symbol_7 = symbol_6;
			}
			else {
				symbol_7 = ValueUtil.FALSE_VALUE;
			}
			return symbol_7;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(jo_OperationCallExp, thoseValues[0])
					&& idResolver.oclEquals(trace_25, thoseValues[1]);
		}
	}

	/**
	 *
	 * map mmapHelper__verdict__qvtr in ATL2QVTr {
	 * guard:middle mapHelper : trace_ATL2QVTr::DmapHelper[1];
	 * var mapHelper_Operation : trace_ATL2QVTr::TmapHelper_Operation[1] := mapHelper.domapHelper_Operation;
	 * observe trace_ATL2QVTr::ImapHelper::success check mapHelper_Operation.success = false;
	 * var mapHelper_Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1] := mapHelper.domapHelper_Attribute;
	 * observe trace_ATL2QVTr::ImapHelper::success check mapHelper_Attribute.success = false;
	 * notify set mapHelper.success := false;
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
			final /*@NonInvalid*/ @Nullable TmapHelper_Operation domapHelper_Operation = mapHelper.getDomapHelper_Operation();
			final /*@NonInvalid*/ boolean symbol_0 = domapHelper_Operation != null;
			/*@Thrown*/ @Nullable Boolean raw_mapHelper_Operation;
			if (symbol_0) {
				if (domapHelper_Operation == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				objectManager.getting(domapHelper_Operation, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__SUCCESS, false);
				final /*@Thrown*/ @Nullable Boolean success = domapHelper_Operation.getSuccess();
				final /*@Thrown*/ boolean eq = success == Boolean.FALSE;
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (eq) {
					final /*@NonInvalid*/ @Nullable TmapHelper_Attribute domapHelper_Attribute = mapHelper.getDomapHelper_Attribute();
					final /*@NonInvalid*/ boolean symbol_1 = domapHelper_Attribute != null;
					/*@Thrown*/ @Nullable Boolean raw_mapHelper_Attribute;
					if (symbol_1) {
						if (domapHelper_Attribute == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						objectManager.getting(domapHelper_Attribute, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__SUCCESS, false);
						final /*@Thrown*/ @Nullable Boolean success_0 = domapHelper_Attribute.getSuccess();
						final /*@Thrown*/ boolean eq_0 = success_0 == Boolean.FALSE;
						/*@Thrown*/ @Nullable Boolean symbol_4;
						if (eq_0) {
							// mapping statements
							mapHelper.setSuccess(ValueUtil.FALSE_VALUE);
							objectManager.assigned(mapHelper, QVTtracePackage.Literals.DISPATCH__SUCCESS, ValueUtil.FALSE_VALUE);
							final /*@Thrown*/ @Nullable Boolean mmapHelper__verdict__qvtr = ValueUtil.TRUE_VALUE;
							symbol_4 = mmapHelper__verdict__qvtr;
						}
						else {
							symbol_4 = ValueUtil.FALSE_VALUE;
						}
						raw_mapHelper_Attribute = symbol_4;
					}
					else {
						raw_mapHelper_Attribute = ValueUtil.FALSE_VALUE;
					}
					symbol_5 = raw_mapHelper_Attribute;
				}
				else {
					symbol_5 = ValueUtil.FALSE_VALUE;
				}
				raw_mapHelper_Operation = symbol_5;
			}
			else {
				raw_mapHelper_Operation = ValueUtil.FALSE_VALUE;
			}
			return raw_mapHelper_Operation;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(mapHelper, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapHelper__Operation__qvtr__speculated__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * append jm_TmapHelper__Context  : trace_ATL2QVTr::TmapHelper_Context[1];
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * check trace = dispatcher.domapHelper_Operation;
	 * var atlHelper : ATL::Helper[1] := dispatcher.d1atlHelper;
	 * observe trace_ATL2QVTr::TmapHelper_Operation::localSuccess check trace.localSuccess;
	 * observe trace_ATL2QVTr::ImapHelper::success check trace.success;
	 * observe trace_ATL2QVTr::TmapHelper_Operation::t0operationName var operationName : String[1] := trace.t0operationName;
	 * observe trace_ATL2QVTr::TmapHelper_Operation::t2qvtrTransformation var qvtrTransformation : qvtrelation::RelationalTransformation[1] := trace.t2qvtrTransformation;
	 * new:qvtr qvtrFunction : qvtbase::Function[1];
	 * new:middle where_mapHelper_Context : trace_ATL2QVTr::TmapHelper_Context[1];
	 * set qvtrFunction.name := operationName;
	 * notify set dispatcher.success := true;
	 * set dispatcher.d2qvtrFunction := qvtrFunction;
	 * set trace.wmapHelper_Context := where_mapHelper_Context;
	 * set qvtrFunction.owningClass := qvtrTransformation;
	 * set where_mapHelper_Context.t1atlHelper := atlHelper;
	 * set where_mapHelper_Context.t2qvtrFunction := qvtrFunction;
	 * add jm_TmapHelper__Context += where_mapHelper_Context;
	 *
	 */
	protected class MAP_mmapHelper__Operation__qvtr__speculated__ extends AbstractInvocation
	{
		protected final @NonNull Connection jm_TmapHelper__Context;
		protected final /*@NonInvalid*/ @NonNull TmapHelper_Operation trace_26;

		public MAP_mmapHelper__Operation__qvtr__speculated__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			jm_TmapHelper__Context = (Connection)boundValues[0];
			trace_26 = (@NonNull TmapHelper_Operation)boundValues[1];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_26.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapHelper_Operation domapHelper_Operation = dispatcher_0.getDomapHelper_Operation();
			final /*@NonInvalid*/ boolean eq = trace_26.equals(domapHelper_Operation);
			/*@Thrown*/ @Nullable Boolean symbol_11;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Helper d1atlHelper = dispatcher_0.getD1atlHelper();
				objectManager.getting(trace_26, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_OPERATION__LOCAL_SUCCESS, false);
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_26.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_10;
				if (localSuccess) {
					objectManager.getting(trace_26, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__SUCCESS, false);
					final /*@NonInvalid*/ @Nullable Boolean success = trace_26.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_9;
					if (success) {
						objectManager.getting(trace_26, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_OPERATION__T0OPERATION_NAME, false);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t0operationName = trace_26.getT0operationName();
						objectManager.getting(trace_26, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_OPERATION__T2QVTR_TRANSFORMATION, false);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull RelationalTransformation t2qvtrTransformation = trace_26.getT2qvtrTransformation();
						// creations
						final @NonNull Function qvtrFunction = QVTbaseFactory.eINSTANCE.createFunction();
						models[1/*qvtr*/].add(qvtrFunction, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrFunction));
						}
						final @SuppressWarnings("null")@NonNull TmapHelper_Context where_mapHelper_Context = trace_ATL2QVTrFactory.eINSTANCE.createTmapHelper_Context();
						models[2/*middle*/].add(where_mapHelper_Context, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(where_mapHelper_Context));
						}
						// mapping statements
						qvtrFunction.setName(t0operationName);
						dispatcher_0.setSuccess(ValueUtil.TRUE_VALUE);
						objectManager.assigned(dispatcher_0, QVTtracePackage.Literals.DISPATCH__SUCCESS, ValueUtil.TRUE_VALUE);
						dispatcher_0.setD2qvtrFunction(qvtrFunction);
						trace_26.setWmapHelper_Context(where_mapHelper_Context);
						qvtrFunction.setOwningClass(t2qvtrTransformation);
						where_mapHelper_Context.setT1atlHelper(d1atlHelper);
						where_mapHelper_Context.setT2qvtrFunction(qvtrFunction);
						jm_TmapHelper__Context.appendElement(where_mapHelper_Context);
						final /*@Thrown*/ @Nullable Boolean mmapHelper__Operation__qvtr__speculated__ = ValueUtil.TRUE_VALUE;
						symbol_9 = mmapHelper__Operation__qvtr__speculated__;
					}
					else {
						symbol_9 = ValueUtil.FALSE_VALUE;
					}
					symbol_10 = symbol_9;
				}
				else {
					symbol_10 = ValueUtil.FALSE_VALUE;
				}
				symbol_11 = symbol_10;
			}
			else {
				symbol_11 = ValueUtil.FALSE_VALUE;
			}
			return symbol_11;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(jm_TmapHelper__Context, thoseValues[0])
					&& idResolver.oclEquals(trace_26, thoseValues[1]);
		}
	}

	/**
	 *
	 * map mmapIfExp__qvtr__speculated__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapIfExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapIfExp;
	 * observe trace_ATL2QVTr::TmapIfExp::localSuccess check trace.localSuccess;
	 * observe trace_ATL2QVTr::ImapOclExpression::success check trace.success;
	 * new:qvtr qvtrExpression : IfExp[1];
	 * notify set dispatcher.success := true;
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 *
	 */
	protected class MAP_mmapIfExp__qvtr__speculated__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapIfExp trace_27;

		public MAP_mmapIfExp__qvtr__speculated__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_27 = (@NonNull TmapIfExp)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_27.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapIfExp domapIfExp = dispatcher_0.getDomapIfExp();
			final /*@NonInvalid*/ boolean eq = trace_27.equals(domapIfExp);
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (eq) {
				objectManager.getting(trace_27, trace_ATL2QVTrPackage.Literals.TMAP_IF_EXP__LOCAL_SUCCESS, false);
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_27.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_4;
				if (localSuccess) {
					objectManager.getting(trace_27, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, false);
					final /*@NonInvalid*/ @Nullable Boolean success = trace_27.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_3;
					if (success) {
						// creations
						final org.eclipse.ocl.pivot.@NonNull IfExp qvtrExpression = PivotFactory.eINSTANCE.createIfExp();
						models[1/*qvtr*/].add(qvtrExpression, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
						}
						// mapping statements
						dispatcher_0.setSuccess(ValueUtil.TRUE_VALUE);
						objectManager.assigned(dispatcher_0, QVTtracePackage.Literals.DISPATCH__SUCCESS, ValueUtil.TRUE_VALUE);
						dispatcher_0.setD2qvtrExpression(qvtrExpression);
						final /*@Thrown*/ @Nullable Boolean mmapIfExp__qvtr__speculated__ = ValueUtil.TRUE_VALUE;
						symbol_3 = mmapIfExp__qvtr__speculated__;
					}
					else {
						symbol_3 = ValueUtil.FALSE_VALUE;
					}
					symbol_4 = symbol_3;
				}
				else {
					symbol_4 = ValueUtil.FALSE_VALUE;
				}
				symbol_5 = symbol_4;
			}
			else {
				symbol_5 = ValueUtil.FALSE_VALUE;
			}
			return symbol_5;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_27, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapOclExpression__verdict__qvtr in ATL2QVTr {
	 * guard:middle mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1];
	 * var mapStringExp : trace_ATL2QVTr::TmapStringExp[1] := mapOclExpression.domapStringExp;
	 * observe trace_ATL2QVTr::ImapOclExpression::success check mapStringExp.success = false;
	 * var mapNavigationOrAttributeCallExp_Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1] := mapOclExpression.domapNavigationOrAttributeCallExp_Helper;
	 * observe trace_ATL2QVTr::ImapOclExpression::success check mapNavigationOrAttributeCallExp_Helper.success = false;
	 * var mapOperationCallExp_Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1] := mapOclExpression.domapOperationCallExp_Helper;
	 * observe trace_ATL2QVTr::ImapOclExpression::success check mapOperationCallExp_Helper.success = false;
	 * var mapIntegerExp : trace_ATL2QVTr::TmapIntegerExp[1] := mapOclExpression.domapIntegerExp;
	 * observe trace_ATL2QVTr::ImapOclExpression::success check mapIntegerExp.success = false;
	 * var mapOclType : trace_ATL2QVTr::TmapOclType[1] := mapOclExpression.domapOclType;
	 * observe trace_ATL2QVTr::ImapOclExpression::success check mapOclType.success = false;
	 * var mapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1] := mapOclExpression.domapOperatorCallExp;
	 * observe trace_ATL2QVTr::ImapOclExpression::success check mapOperatorCallExp.success = false;
	 * var mapVariableExp : trace_ATL2QVTr::TmapVariableExp[1] := mapOclExpression.domapVariableExp;
	 * observe trace_ATL2QVTr::ImapOclExpression::success check mapVariableExp.success = false;
	 * var mapBooleanExp : trace_ATL2QVTr::TmapBooleanExp[1] := mapOclExpression.domapBooleanExp;
	 * observe trace_ATL2QVTr::ImapOclExpression::success check mapBooleanExp.success = false;
	 * var mapIfExp : trace_ATL2QVTr::TmapIfExp[1] := mapOclExpression.domapIfExp;
	 * observe trace_ATL2QVTr::ImapOclExpression::success check mapIfExp.success = false;
	 * var mapNavigationOrAttributeCallExp_Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1] := mapOclExpression.domapNavigationOrAttributeCallExp_Property;
	 * observe trace_ATL2QVTr::ImapOclExpression::success check mapNavigationOrAttributeCallExp_Property.success = false;
	 * var mapOperationCallExp_Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1] := mapOclExpression.domapOperationCallExp_Operation;
	 * observe trace_ATL2QVTr::ImapOclExpression::success check mapOperationCallExp_Operation.success = false;
	 * notify set mapOclExpression.success := false;
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
			final /*@NonInvalid*/ @Nullable TmapStringExp domapStringExp = mapOclExpression.getDomapStringExp();
			final /*@NonInvalid*/ boolean symbol_0 = domapStringExp != null;
			/*@Thrown*/ @Nullable Boolean raw_mapStringExp;
			if (symbol_0) {
				if (domapStringExp == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				objectManager.getting(domapStringExp, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, false);
				final /*@Thrown*/ @Nullable Boolean success = domapStringExp.getSuccess();
				final /*@Thrown*/ boolean eq = success == Boolean.FALSE;
				/*@Thrown*/ @Nullable Boolean symbol_23;
				if (eq) {
					final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Helper domapNavigationOrAttributeCallExp_Helper = mapOclExpression.getDomapNavigationOrAttributeCallExp_Helper();
					final /*@NonInvalid*/ boolean symbol_1 = domapNavigationOrAttributeCallExp_Helper != null;
					/*@Thrown*/ @Nullable Boolean raw_mapNavigationOrAttributeCallExp_Helper;
					if (symbol_1) {
						if (domapNavigationOrAttributeCallExp_Helper == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						objectManager.getting(domapNavigationOrAttributeCallExp_Helper, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, false);
						final /*@Thrown*/ @Nullable Boolean success_0 = domapNavigationOrAttributeCallExp_Helper.getSuccess();
						final /*@Thrown*/ boolean eq_0 = success_0 == Boolean.FALSE;
						/*@Thrown*/ @Nullable Boolean symbol_22;
						if (eq_0) {
							final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Helper domapOperationCallExp_Helper = mapOclExpression.getDomapOperationCallExp_Helper();
							final /*@NonInvalid*/ boolean symbol_2 = domapOperationCallExp_Helper != null;
							/*@Thrown*/ @Nullable Boolean raw_mapOperationCallExp_Helper;
							if (symbol_2) {
								if (domapOperationCallExp_Helper == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								objectManager.getting(domapOperationCallExp_Helper, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, false);
								final /*@Thrown*/ @Nullable Boolean success_1 = domapOperationCallExp_Helper.getSuccess();
								final /*@Thrown*/ boolean eq_1 = success_1 == Boolean.FALSE;
								/*@Thrown*/ @Nullable Boolean symbol_21;
								if (eq_1) {
									final /*@NonInvalid*/ @Nullable TmapIntegerExp domapIntegerExp = mapOclExpression.getDomapIntegerExp();
									final /*@NonInvalid*/ boolean symbol_3 = domapIntegerExp != null;
									/*@Thrown*/ @Nullable Boolean raw_mapIntegerExp;
									if (symbol_3) {
										if (domapIntegerExp == null) {
											throw new InvalidEvaluationException("Null where non-null value required");
										}
										objectManager.getting(domapIntegerExp, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, false);
										final /*@Thrown*/ @Nullable Boolean success_2 = domapIntegerExp.getSuccess();
										final /*@Thrown*/ boolean eq_2 = success_2 == Boolean.FALSE;
										/*@Thrown*/ @Nullable Boolean symbol_20;
										if (eq_2) {
											final /*@NonInvalid*/ @Nullable TmapOclType domapOclType = mapOclExpression.getDomapOclType();
											final /*@NonInvalid*/ boolean symbol_4 = domapOclType != null;
											/*@Thrown*/ @Nullable Boolean raw_mapOclType;
											if (symbol_4) {
												if (domapOclType == null) {
													throw new InvalidEvaluationException("Null where non-null value required");
												}
												objectManager.getting(domapOclType, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, false);
												final /*@Thrown*/ @Nullable Boolean success_3 = ((ImapOclExpression)domapOclType).getSuccess();
												final /*@Thrown*/ boolean eq_3 = success_3 == Boolean.FALSE;
												/*@Thrown*/ @Nullable Boolean symbol_19;
												if (eq_3) {
													final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = mapOclExpression.getDomapOperatorCallExp();
													final /*@NonInvalid*/ boolean symbol_5 = domapOperatorCallExp != null;
													/*@Thrown*/ @Nullable Boolean raw_mapOperatorCallExp;
													if (symbol_5) {
														if (domapOperatorCallExp == null) {
															throw new InvalidEvaluationException("Null where non-null value required");
														}
														objectManager.getting(domapOperatorCallExp, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, false);
														final /*@Thrown*/ @Nullable Boolean success_4 = domapOperatorCallExp.getSuccess();
														final /*@Thrown*/ boolean eq_4 = success_4 == Boolean.FALSE;
														/*@Thrown*/ @Nullable Boolean symbol_18;
														if (eq_4) {
															final /*@NonInvalid*/ @Nullable TmapVariableExp domapVariableExp = mapOclExpression.getDomapVariableExp();
															final /*@NonInvalid*/ boolean symbol_6 = domapVariableExp != null;
															/*@Thrown*/ @Nullable Boolean raw_mapVariableExp;
															if (symbol_6) {
																if (domapVariableExp == null) {
																	throw new InvalidEvaluationException("Null where non-null value required");
																}
																objectManager.getting(domapVariableExp, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, false);
																final /*@Thrown*/ @Nullable Boolean success_5 = domapVariableExp.getSuccess();
																final /*@Thrown*/ boolean eq_5 = success_5 == Boolean.FALSE;
																/*@Thrown*/ @Nullable Boolean symbol_17;
																if (eq_5) {
																	final /*@NonInvalid*/ @Nullable TmapBooleanExp domapBooleanExp = mapOclExpression.getDomapBooleanExp();
																	final /*@NonInvalid*/ boolean symbol_7 = domapBooleanExp != null;
																	/*@Thrown*/ @Nullable Boolean raw_mapBooleanExp;
																	if (symbol_7) {
																		if (domapBooleanExp == null) {
																			throw new InvalidEvaluationException("Null where non-null value required");
																		}
																		objectManager.getting(domapBooleanExp, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, false);
																		final /*@Thrown*/ @Nullable Boolean success_6 = domapBooleanExp.getSuccess();
																		final /*@Thrown*/ boolean eq_6 = success_6 == Boolean.FALSE;
																		/*@Thrown*/ @Nullable Boolean symbol_16;
																		if (eq_6) {
																			final /*@NonInvalid*/ @Nullable TmapIfExp domapIfExp = mapOclExpression.getDomapIfExp();
																			final /*@NonInvalid*/ boolean symbol_8 = domapIfExp != null;
																			/*@Thrown*/ @Nullable Boolean raw_mapIfExp;
																			if (symbol_8) {
																				if (domapIfExp == null) {
																					throw new InvalidEvaluationException("Null where non-null value required");
																				}
																				objectManager.getting(domapIfExp, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, false);
																				final /*@Thrown*/ @Nullable Boolean success_7 = domapIfExp.getSuccess();
																				final /*@Thrown*/ boolean eq_7 = success_7 == Boolean.FALSE;
																				/*@Thrown*/ @Nullable Boolean symbol_15;
																				if (eq_7) {
																					final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Property domapNavigationOrAttributeCallExp_Property = mapOclExpression.getDomapNavigationOrAttributeCallExp_Property();
																					final /*@NonInvalid*/ boolean symbol_9 = domapNavigationOrAttributeCallExp_Property != null;
																					/*@Thrown*/ @Nullable Boolean raw_mapNavigationOrAttributeCallExp_Property;
																					if (symbol_9) {
																						if (domapNavigationOrAttributeCallExp_Property == null) {
																							throw new InvalidEvaluationException("Null where non-null value required");
																						}
																						objectManager.getting(domapNavigationOrAttributeCallExp_Property, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, false);
																						final /*@Thrown*/ @Nullable Boolean success_8 = domapNavigationOrAttributeCallExp_Property.getSuccess();
																						final /*@Thrown*/ boolean eq_8 = success_8 == Boolean.FALSE;
																						/*@Thrown*/ @Nullable Boolean symbol_14;
																						if (eq_8) {
																							final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Operation domapOperationCallExp_Operation = mapOclExpression.getDomapOperationCallExp_Operation();
																							final /*@NonInvalid*/ boolean symbol_10 = domapOperationCallExp_Operation != null;
																							/*@Thrown*/ @Nullable Boolean raw_mapOperationCallExp_Operation;
																							if (symbol_10) {
																								if (domapOperationCallExp_Operation == null) {
																									throw new InvalidEvaluationException("Null where non-null value required");
																								}
																								objectManager.getting(domapOperationCallExp_Operation, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, false);
																								final /*@Thrown*/ @Nullable Boolean success_9 = domapOperationCallExp_Operation.getSuccess();
																								final /*@Thrown*/ boolean eq_9 = success_9 == Boolean.FALSE;
																								/*@Thrown*/ @Nullable Boolean symbol_13;
																								if (eq_9) {
																									// mapping statements
																									mapOclExpression.setSuccess(ValueUtil.FALSE_VALUE);
																									objectManager.assigned(mapOclExpression, QVTtracePackage.Literals.DISPATCH__SUCCESS, ValueUtil.FALSE_VALUE);
																									final /*@Thrown*/ @Nullable Boolean mmapOclExpression__verdict__qvtr = ValueUtil.TRUE_VALUE;
																									symbol_13 = mmapOclExpression__verdict__qvtr;
																								}
																								else {
																									symbol_13 = ValueUtil.FALSE_VALUE;
																								}
																								raw_mapOperationCallExp_Operation = symbol_13;
																							}
																							else {
																								raw_mapOperationCallExp_Operation = ValueUtil.FALSE_VALUE;
																							}
																							symbol_14 = raw_mapOperationCallExp_Operation;
																						}
																						else {
																							symbol_14 = ValueUtil.FALSE_VALUE;
																						}
																						raw_mapNavigationOrAttributeCallExp_Property = symbol_14;
																					}
																					else {
																						raw_mapNavigationOrAttributeCallExp_Property = ValueUtil.FALSE_VALUE;
																					}
																					symbol_15 = raw_mapNavigationOrAttributeCallExp_Property;
																				}
																				else {
																					symbol_15 = ValueUtil.FALSE_VALUE;
																				}
																				raw_mapIfExp = symbol_15;
																			}
																			else {
																				raw_mapIfExp = ValueUtil.FALSE_VALUE;
																			}
																			symbol_16 = raw_mapIfExp;
																		}
																		else {
																			symbol_16 = ValueUtil.FALSE_VALUE;
																		}
																		raw_mapBooleanExp = symbol_16;
																	}
																	else {
																		raw_mapBooleanExp = ValueUtil.FALSE_VALUE;
																	}
																	symbol_17 = raw_mapBooleanExp;
																}
																else {
																	symbol_17 = ValueUtil.FALSE_VALUE;
																}
																raw_mapVariableExp = symbol_17;
															}
															else {
																raw_mapVariableExp = ValueUtil.FALSE_VALUE;
															}
															symbol_18 = raw_mapVariableExp;
														}
														else {
															symbol_18 = ValueUtil.FALSE_VALUE;
														}
														raw_mapOperatorCallExp = symbol_18;
													}
													else {
														raw_mapOperatorCallExp = ValueUtil.FALSE_VALUE;
													}
													symbol_19 = raw_mapOperatorCallExp;
												}
												else {
													symbol_19 = ValueUtil.FALSE_VALUE;
												}
												raw_mapOclType = symbol_19;
											}
											else {
												raw_mapOclType = ValueUtil.FALSE_VALUE;
											}
											symbol_20 = raw_mapOclType;
										}
										else {
											symbol_20 = ValueUtil.FALSE_VALUE;
										}
										raw_mapIntegerExp = symbol_20;
									}
									else {
										raw_mapIntegerExp = ValueUtil.FALSE_VALUE;
									}
									symbol_21 = raw_mapIntegerExp;
								}
								else {
									symbol_21 = ValueUtil.FALSE_VALUE;
								}
								raw_mapOperationCallExp_Helper = symbol_21;
							}
							else {
								raw_mapOperationCallExp_Helper = ValueUtil.FALSE_VALUE;
							}
							symbol_22 = raw_mapOperationCallExp_Helper;
						}
						else {
							symbol_22 = ValueUtil.FALSE_VALUE;
						}
						raw_mapNavigationOrAttributeCallExp_Helper = symbol_22;
					}
					else {
						raw_mapNavigationOrAttributeCallExp_Helper = ValueUtil.FALSE_VALUE;
					}
					symbol_23 = raw_mapNavigationOrAttributeCallExp_Helper;
				}
				else {
					symbol_23 = ValueUtil.FALSE_VALUE;
				}
				raw_mapStringExp = symbol_23;
			}
			else {
				raw_mapStringExp = ValueUtil.FALSE_VALUE;
			}
			return raw_mapStringExp;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(mapOclExpression, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapNavigationOrAttributeCallExp__Property__qvtr__s in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * append jo_PropertyCallExp  : PropertyCallExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapNavigationOrAttributeCallExp_Property;
	 * observe trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property::localSuccess check trace.localSuccess;
	 * observe trace_ATL2QVTr::ImapOclExpression::success check trace.success;
	 * observe trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property::t0propertyName var propertyName : String[1] := trace.t0propertyName;
	 * new:qvtr qvtrExpression : PropertyCallExp[1];
	 * set qvtrExpression.name := propertyName;
	 * notify set dispatcher.success := true;
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 * add jo_PropertyCallExp += qvtrExpression;
	 *
	 */
	protected class MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__s extends AbstractInvocation
	{
		protected final @NonNull Connection jo_PropertyCallExp;
		protected final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace_28;

		public MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__s(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			jo_PropertyCallExp = (Connection)boundValues[0];
			trace_28 = (@NonNull TmapNavigationOrAttributeCallExp_Property)boundValues[1];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_28.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Property domapNavigationOrAttributeCallExp_Property = dispatcher_0.getDomapNavigationOrAttributeCallExp_Property();
			final /*@NonInvalid*/ boolean eq = trace_28.equals(domapNavigationOrAttributeCallExp_Property);
			/*@Thrown*/ @Nullable Boolean symbol_7;
			if (eq) {
				objectManager.getting(trace_28, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__LOCAL_SUCCESS, false);
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_28.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_6;
				if (localSuccess) {
					objectManager.getting(trace_28, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, false);
					final /*@NonInvalid*/ @Nullable Boolean success = trace_28.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_5;
					if (success) {
						objectManager.getting(trace_28, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T0PROPERTY_NAME, false);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t0propertyName = trace_28.getT0propertyName();
						// creations
						final @NonNull PropertyCallExp qvtrExpression = PivotFactory.eINSTANCE.createPropertyCallExp();
						models[1/*qvtr*/].add(qvtrExpression, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
						}
						// mapping statements
						qvtrExpression.setName(t0propertyName);
						dispatcher_0.setSuccess(ValueUtil.TRUE_VALUE);
						objectManager.assigned(dispatcher_0, QVTtracePackage.Literals.DISPATCH__SUCCESS, ValueUtil.TRUE_VALUE);
						dispatcher_0.setD2qvtrExpression(qvtrExpression);
						jo_PropertyCallExp.appendElement(qvtrExpression);
						final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Property__qvtr__s = ValueUtil.TRUE_VALUE;
						symbol_5 = mmapNavigationOrAttributeCallExp__Property__qvtr__s;
					}
					else {
						symbol_5 = ValueUtil.FALSE_VALUE;
					}
					symbol_6 = symbol_5;
				}
				else {
					symbol_6 = ValueUtil.FALSE_VALUE;
				}
				symbol_7 = symbol_6;
			}
			else {
				symbol_7 = ValueUtil.FALSE_VALUE;
			}
			return symbol_7;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(jo_PropertyCallExp, thoseValues[0])
					&& idResolver.oclEquals(trace_28, thoseValues[1]);
		}
	}

	/**
	 *
	 * map mmapHelper__Attribute__qvtr__speculated__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * append jm_TmapHelper__Context  : trace_ATL2QVTr::TmapHelper_Context[1];
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * check trace = dispatcher.domapHelper_Attribute;
	 * var atlHelper : ATL::Helper[1] := dispatcher.d1atlHelper;
	 * observe trace_ATL2QVTr::TmapHelper_Attribute::localSuccess check trace.localSuccess;
	 * observe trace_ATL2QVTr::ImapHelper::success check trace.success;
	 * observe trace_ATL2QVTr::TmapHelper_Attribute::t0attributeName var attributeName : String[1] := trace.t0attributeName;
	 * observe trace_ATL2QVTr::TmapHelper_Attribute::t2qvtrTransformation var qvtrTransformation : qvtrelation::RelationalTransformation[1] := trace.t2qvtrTransformation;
	 * new:qvtr qvtrFunction : qvtbase::Function[1];
	 * new:middle where_mapHelper_Context : trace_ATL2QVTr::TmapHelper_Context[1];
	 * set qvtrFunction.name := attributeName;
	 * notify set dispatcher.success := true;
	 * set dispatcher.d2qvtrFunction := qvtrFunction;
	 * set trace.wmapHelper_Context := where_mapHelper_Context;
	 * set qvtrFunction.owningClass := qvtrTransformation;
	 * set where_mapHelper_Context.t1atlHelper := atlHelper;
	 * set where_mapHelper_Context.t2qvtrFunction := qvtrFunction;
	 * add jm_TmapHelper__Context += where_mapHelper_Context;
	 *
	 */
	protected class MAP_mmapHelper__Attribute__qvtr__speculated__ extends AbstractInvocation
	{
		protected final @NonNull Connection jm_TmapHelper__Context_0;
		protected final /*@NonInvalid*/ @NonNull TmapHelper_Attribute trace_29;

		public MAP_mmapHelper__Attribute__qvtr__speculated__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			jm_TmapHelper__Context_0 = (Connection)boundValues[0];
			trace_29 = (@NonNull TmapHelper_Attribute)boundValues[1];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_29.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapHelper_Attribute domapHelper_Attribute = dispatcher_0.getDomapHelper_Attribute();
			final /*@NonInvalid*/ boolean eq = trace_29.equals(domapHelper_Attribute);
			/*@Thrown*/ @Nullable Boolean symbol_11;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Helper d1atlHelper = dispatcher_0.getD1atlHelper();
				objectManager.getting(trace_29, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_ATTRIBUTE__LOCAL_SUCCESS, false);
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_29.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_10;
				if (localSuccess) {
					objectManager.getting(trace_29, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__SUCCESS, false);
					final /*@NonInvalid*/ @Nullable Boolean success = trace_29.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_9;
					if (success) {
						objectManager.getting(trace_29, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_ATTRIBUTE__T0ATTRIBUTE_NAME, false);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t0attributeName = trace_29.getT0attributeName();
						objectManager.getting(trace_29, trace_ATL2QVTrPackage.Literals.TMAP_HELPER_ATTRIBUTE__T2QVTR_TRANSFORMATION, false);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull RelationalTransformation t2qvtrTransformation = trace_29.getT2qvtrTransformation();
						// creations
						final @NonNull Function qvtrFunction = QVTbaseFactory.eINSTANCE.createFunction();
						models[1/*qvtr*/].add(qvtrFunction, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrFunction));
						}
						final @SuppressWarnings("null")@NonNull TmapHelper_Context where_mapHelper_Context = trace_ATL2QVTrFactory.eINSTANCE.createTmapHelper_Context();
						models[2/*middle*/].add(where_mapHelper_Context, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(where_mapHelper_Context));
						}
						// mapping statements
						qvtrFunction.setName(t0attributeName);
						dispatcher_0.setSuccess(ValueUtil.TRUE_VALUE);
						objectManager.assigned(dispatcher_0, QVTtracePackage.Literals.DISPATCH__SUCCESS, ValueUtil.TRUE_VALUE);
						dispatcher_0.setD2qvtrFunction(qvtrFunction);
						trace_29.setWmapHelper_Context(where_mapHelper_Context);
						qvtrFunction.setOwningClass(t2qvtrTransformation);
						where_mapHelper_Context.setT1atlHelper(d1atlHelper);
						where_mapHelper_Context.setT2qvtrFunction(qvtrFunction);
						jm_TmapHelper__Context_0.appendElement(where_mapHelper_Context);
						final /*@Thrown*/ @Nullable Boolean mmapHelper__Attribute__qvtr__speculated__ = ValueUtil.TRUE_VALUE;
						symbol_9 = mmapHelper__Attribute__qvtr__speculated__;
					}
					else {
						symbol_9 = ValueUtil.FALSE_VALUE;
					}
					symbol_10 = symbol_9;
				}
				else {
					symbol_10 = ValueUtil.FALSE_VALUE;
				}
				symbol_11 = symbol_10;
			}
			else {
				symbol_11 = ValueUtil.FALSE_VALUE;
			}
			return symbol_11;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(jm_TmapHelper__Context_0, thoseValues[0])
					&& idResolver.oclEquals(trace_29, thoseValues[1]);
		}
	}

	/**
	 *
	 * map mmapOperationCallExp__Operation__qvtr__speculated__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * append jo_OperationCallExp  : OperationCallExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperationCallExp_Operation;
	 * observe trace_ATL2QVTr::TmapOperationCallExp_Operation::localSuccess check trace.localSuccess;
	 * observe trace_ATL2QVTr::ImapOclExpression::success check trace.success;
	 * observe trace_ATL2QVTr::TmapOperationCallExp_Operation::t0operationName var operationName : String[1] := trace.t0operationName;
	 * new:qvtr qvtrExpression : OperationCallExp[1];
	 * set qvtrExpression.name := operationName;
	 * notify set dispatcher.success := true;
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 * add jo_OperationCallExp += qvtrExpression;
	 *
	 */
	protected class MAP_mmapOperationCallExp__Operation__qvtr__speculated__ extends AbstractInvocation
	{
		protected final @NonNull Connection jo_OperationCallExp_0;
		protected final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace_30;

		public MAP_mmapOperationCallExp__Operation__qvtr__speculated__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			jo_OperationCallExp_0 = (Connection)boundValues[0];
			trace_30 = (@NonNull TmapOperationCallExp_Operation)boundValues[1];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_30.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Operation domapOperationCallExp_Operation = dispatcher_0.getDomapOperationCallExp_Operation();
			final /*@NonInvalid*/ boolean eq = trace_30.equals(domapOperationCallExp_Operation);
			/*@Thrown*/ @Nullable Boolean symbol_7;
			if (eq) {
				objectManager.getting(trace_30, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_OPERATION__LOCAL_SUCCESS, false);
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_30.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_6;
				if (localSuccess) {
					objectManager.getting(trace_30, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, false);
					final /*@NonInvalid*/ @Nullable Boolean success = trace_30.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_5;
					if (success) {
						objectManager.getting(trace_30, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_OPERATION__T0OPERATION_NAME, false);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t0operationName = trace_30.getT0operationName();
						// creations
						final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
						models[1/*qvtr*/].add(qvtrExpression, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
						}
						// mapping statements
						qvtrExpression.setName(t0operationName);
						dispatcher_0.setSuccess(ValueUtil.TRUE_VALUE);
						objectManager.assigned(dispatcher_0, QVTtracePackage.Literals.DISPATCH__SUCCESS, ValueUtil.TRUE_VALUE);
						dispatcher_0.setD2qvtrExpression(qvtrExpression);
						jo_OperationCallExp_0.appendElement(qvtrExpression);
						final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Operation__qvtr__speculated__ = ValueUtil.TRUE_VALUE;
						symbol_5 = mmapOperationCallExp__Operation__qvtr__speculated__;
					}
					else {
						symbol_5 = ValueUtil.FALSE_VALUE;
					}
					symbol_6 = symbol_5;
				}
				else {
					symbol_6 = ValueUtil.FALSE_VALUE;
				}
				symbol_7 = symbol_6;
			}
			else {
				symbol_7 = ValueUtil.FALSE_VALUE;
			}
			return symbol_7;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(jo_OperationCallExp_0, thoseValues[0])
					&& idResolver.oclEquals(trace_30, thoseValues[1]);
		}
	}

	/**
	 *
	 * map mmapOperationCallExp__Helper__qvtr__speculated__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * append jo_OperationCallExp  : OperationCallExp[1];
	 * append jo_VariableExp  : VariableExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperationCallExp_Helper;
	 * observe trace_ATL2QVTr::TmapOperationCallExp_Helper::localSuccess check trace.localSuccess;
	 * observe trace_ATL2QVTr::ImapOclExpression::success check trace.success;
	 * observe trace_ATL2QVTr::TmapOperationCallExp_Helper::t0operationName var operationName : String[1] := trace.t0operationName;
	 * new:qvtr qvtrExpression : OperationCallExp[1];
	 * new:qvtr qvtrSource : VariableExp[1];
	 * set qvtrExpression.name := operationName;
	 * notify set dispatcher.success := true;
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 * set trace.t2qvtrSource := qvtrSource;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 * add jo_OperationCallExp += qvtrExpression;
	 * add jo_VariableExp += qvtrSource;
	 *
	 */
	protected class MAP_mmapOperationCallExp__Helper__qvtr__speculated__ extends AbstractInvocation
	{
		protected final @NonNull Connection jo_OperationCallExp_1;
		protected final @NonNull Connection jo_VariableExp_0;
		protected final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_31;

		public MAP_mmapOperationCallExp__Helper__qvtr__speculated__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			jo_OperationCallExp_1 = (Connection)boundValues[0];
			jo_VariableExp_0 = (Connection)boundValues[1];
			trace_31 = (@NonNull TmapOperationCallExp_Helper)boundValues[2];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_31.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Helper domapOperationCallExp_Helper = dispatcher_0.getDomapOperationCallExp_Helper();
			final /*@NonInvalid*/ boolean eq = trace_31.equals(domapOperationCallExp_Helper);
			/*@Thrown*/ @Nullable Boolean symbol_10;
			if (eq) {
				objectManager.getting(trace_31, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__LOCAL_SUCCESS, false);
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_31.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_9;
				if (localSuccess) {
					objectManager.getting(trace_31, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, false);
					final /*@NonInvalid*/ @Nullable Boolean success = trace_31.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_8;
					if (success) {
						objectManager.getting(trace_31, trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER__T0OPERATION_NAME, false);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t0operationName = trace_31.getT0operationName();
						// creations
						final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
						models[1/*qvtr*/].add(qvtrExpression, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
						}
						final org.eclipse.ocl.pivot.@NonNull VariableExp qvtrSource = PivotFactory.eINSTANCE.createVariableExp();
						models[1/*qvtr*/].add(qvtrSource, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrSource));
						}
						// mapping statements
						qvtrExpression.setName(t0operationName);
						dispatcher_0.setSuccess(ValueUtil.TRUE_VALUE);
						objectManager.assigned(dispatcher_0, QVTtracePackage.Literals.DISPATCH__SUCCESS, ValueUtil.TRUE_VALUE);
						dispatcher_0.setD2qvtrExpression(qvtrExpression);
						trace_31.setT2qvtrSource(qvtrSource);
						qvtrExpression.setOwnedSource(qvtrSource);
						jo_OperationCallExp_1.appendElement(qvtrExpression);
						jo_VariableExp_0.appendElement(qvtrSource);
						final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Helper__qvtr__speculated__ = ValueUtil.TRUE_VALUE;
						symbol_8 = mmapOperationCallExp__Helper__qvtr__speculated__;
					}
					else {
						symbol_8 = ValueUtil.FALSE_VALUE;
					}
					symbol_9 = symbol_8;
				}
				else {
					symbol_9 = ValueUtil.FALSE_VALUE;
				}
				symbol_10 = symbol_9;
			}
			else {
				symbol_10 = ValueUtil.FALSE_VALUE;
			}
			return symbol_10;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(jo_OperationCallExp_1, thoseValues[0])
					&& idResolver.oclEquals(jo_VariableExp_0, thoseValues[1])
					&& idResolver.oclEquals(trace_31, thoseValues[2]);
		}
	}

	/**
	 *
	 * map mmapNavigationOrAttributeCallExp__Helper__qvtr__spe in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * append jo_OperationCallExp  : OperationCallExp[1];
	 * append jo_VariableExp  : VariableExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapNavigationOrAttributeCallExp_Helper;
	 * observe trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper::localSuccess check trace.localSuccess;
	 * observe trace_ATL2QVTr::ImapOclExpression::success check trace.success;
	 * observe trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper::t0propertyName var propertyName : String[1] := trace.t0propertyName;
	 * new:qvtr qvtrExpression : OperationCallExp[1];
	 * new:qvtr qvtrSource : VariableExp[1];
	 * set qvtrExpression.name := propertyName;
	 * notify set dispatcher.success := true;
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 * set trace.t2qvtrSource := qvtrSource;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 * add jo_OperationCallExp += qvtrExpression;
	 * add jo_VariableExp += qvtrSource;
	 *
	 */
	protected class MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__spe extends AbstractInvocation
	{
		protected final @NonNull Connection jo_OperationCallExp_2;
		protected final @NonNull Connection jo_VariableExp_1;
		protected final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_32;

		public MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__spe(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			jo_OperationCallExp_2 = (Connection)boundValues[0];
			jo_VariableExp_1 = (Connection)boundValues[1];
			trace_32 = (@NonNull TmapNavigationOrAttributeCallExp_Helper)boundValues[2];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_32.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Helper domapNavigationOrAttributeCallExp_Helper = dispatcher_0.getDomapNavigationOrAttributeCallExp_Helper();
			final /*@NonInvalid*/ boolean eq = trace_32.equals(domapNavigationOrAttributeCallExp_Helper);
			/*@Thrown*/ @Nullable Boolean symbol_10;
			if (eq) {
				objectManager.getting(trace_32, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__LOCAL_SUCCESS, false);
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_32.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_9;
				if (localSuccess) {
					objectManager.getting(trace_32, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, false);
					final /*@NonInvalid*/ @Nullable Boolean success = trace_32.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_8;
					if (success) {
						objectManager.getting(trace_32, trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T0PROPERTY_NAME, false);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t0propertyName = trace_32.getT0propertyName();
						// creations
						final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
						models[1/*qvtr*/].add(qvtrExpression, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrExpression));
						}
						final org.eclipse.ocl.pivot.@NonNull VariableExp qvtrSource = PivotFactory.eINSTANCE.createVariableExp();
						models[1/*qvtr*/].add(qvtrSource, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrSource));
						}
						// mapping statements
						qvtrExpression.setName(t0propertyName);
						dispatcher_0.setSuccess(ValueUtil.TRUE_VALUE);
						objectManager.assigned(dispatcher_0, QVTtracePackage.Literals.DISPATCH__SUCCESS, ValueUtil.TRUE_VALUE);
						dispatcher_0.setD2qvtrExpression(qvtrExpression);
						trace_32.setT2qvtrSource(qvtrSource);
						qvtrExpression.setOwnedSource(qvtrSource);
						jo_OperationCallExp_2.appendElement(qvtrExpression);
						jo_VariableExp_1.appendElement(qvtrSource);
						final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Helper__qvtr__spe = ValueUtil.TRUE_VALUE;
						symbol_8 = mmapNavigationOrAttributeCallExp__Helper__qvtr__spe;
					}
					else {
						symbol_8 = ValueUtil.FALSE_VALUE;
					}
					symbol_9 = symbol_8;
				}
				else {
					symbol_9 = ValueUtil.FALSE_VALUE;
				}
				symbol_10 = symbol_9;
			}
			else {
				symbol_10 = ValueUtil.FALSE_VALUE;
			}
			return symbol_10;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(jo_OperationCallExp_2, thoseValues[0])
					&& idResolver.oclEquals(jo_VariableExp_1, thoseValues[1])
					&& idResolver.oclEquals(trace_32, thoseValues[2]);
		}
	}

	/**
	 *
	 * map mmapNavigationOrAttributeCallExp__Helper__qvtr__edg in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapNavigationOrAttributeCallExp_Helper;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var when_mapHelper_Attribute : trace_ATL2QVTr::DmapHelper[1] := trace.wmapHelper;
	 * var qvtrOperation : Operation[1] := when_mapHelper_Attribute.d2qvtrFunction;
	 * set trace.t2qvtrOperation := qvtrOperation;
	 * set qvtrExpression.referredOperation := qvtrOperation;
	 *
	 */
	protected boolean MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_33)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg" +
					"\n\t\"trace\":" + toDebugString(trace_33) +
					"\n\t\"dispatcher\":" + toDebugString(trace_33.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_33.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_33.getDispatcher().getD2qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_33.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Helper domapNavigationOrAttributeCallExp_Helper = dispatcher_0.getDomapNavigationOrAttributeCallExp_Helper();
		final /*@NonInvalid*/ boolean eq = trace_33.equals(domapNavigationOrAttributeCallExp_Helper);
		/*@Thrown*/ @Nullable Boolean symbol_9;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_8;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_33.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_7;
				if (localSuccess) {
					final /*@NonInvalid*/ @Nullable Boolean success = trace_33.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_6;
					if (success) {
						final /*@NonInvalid*/ @Nullable DmapHelper wmapHelper = trace_33.getWmapHelper();
						final /*@NonInvalid*/ boolean symbol_2 = wmapHelper != null;
						/*@Thrown*/ @Nullable Boolean raw_when_mapHelper_Attribute;
						if (symbol_2) {
							if (wmapHelper == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull Function d2qvtrFunction = wmapHelper.getD2qvtrFunction();
							// mapping statements
							trace_33.setT2qvtrOperation(d2qvtrFunction);
							symbol_1.setReferredOperation(d2qvtrFunction);
							final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Helper__qvtr__edg = ValueUtil.TRUE_VALUE;
							raw_when_mapHelper_Attribute = mmapNavigationOrAttributeCallExp__Helper__qvtr__edg;
						}
						else {
							raw_when_mapHelper_Attribute = ValueUtil.FALSE_VALUE;
						}
						symbol_6 = raw_when_mapHelper_Attribute;
					}
					else {
						symbol_6 = ValueUtil.FALSE_VALUE;
					}
					symbol_7 = symbol_6;
				}
				else {
					symbol_7 = ValueUtil.FALSE_VALUE;
				}
				symbol_8 = symbol_7;
			}
			else {
				symbol_8 = ValueUtil.FALSE_VALUE;
			}
			symbol_9 = symbol_8;
		}
		else {
			symbol_9 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_9 ? "done "  : "fail ") + "MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg");
		}
		return symbol_9;
	}

	/**
	 *
	 * map mmapInPattern__qvtr__residue__ in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapInPattern[1] success success;
	 * var atlPattern : ATL::InPattern[1] := trace.t1atlPattern;
	 * var atlRule : ATL::MatchedRule[1] := atlPattern.rule;
	 * var when_mapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1] := atlRule.TmapMatchedRule;
	 * check when_mapMatchedRule.success;
	 * var elements : Set(ATL::InPatternElement[+|1]) := atlPattern.elements;
	 * var selectByKind : Bag(OCL::OclModelElement) := elements->collect(_'1_' | _'1_'.type)
	 *   ->selectByKind(OCL::OclModelElement)
	 *   ;
	 * var any : OCL::OclModelElement[1] := selectByKind->any(_'1_' | true);
	 * var atlModel : OCL::OclModel[1] := any.model;
	 * var metamodel : OCL::OclModel[?] := atlModel.metamodel;
	 * var _'=' : Boolean[1] := metamodel =
	 *   null;
	 * check _'=';
	 * var qvtrRelation : qvtrelation::Relation[1] := when_mapMatchedRule.t2qvtrRelation;
	 * var collect : Bag(OCL::OclType[*|?]) := elements->collect(_'1_' | _'1_'.type);
	 * var when_mapOclMetamodel : trace_ATL2QVTr::TmapOclMetamodel[1] := atlModel.TmapOclMetamodel;
	 * var qvtrTypedModel : qvtbase::TypedModel[1] := when_mapOclMetamodel.t2qvtrTypedModel;
	 * new:qvtr qvtrDomain : qvtrelation::RelationDomain[1];
	 * set qvtrDomain.isCheckable := true;
	 * set qvtrDomain.isEnforceable := false;
	 * set qvtrDomain.rule := qvtrRelation;
	 * set qvtrDomain.typedModel := qvtrTypedModel;
	 * set trace.t1atlModel := atlModel;
	 * set trace.t1atlRule := atlRule;
	 * set trace.t2qvtrDomain := qvtrDomain;
	 * set trace.t2qvtrRelation := qvtrRelation;
	 * set trace.t2qvtrTypedModel := qvtrTypedModel;
	 * set trace.wmapMatchedRule := when_mapMatchedRule;
	 * set trace.wmapOclMetamodel := when_mapOclMetamodel;
	 *
	 */
	protected boolean MAP_mmapInPattern__qvtr__residue__(final /*@NonInvalid*/ @NonNull TmapInPattern trace_34)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapInPattern__qvtr__residue__" +
					"\n\t\"trace\":" + toDebugString(trace_34));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull InPattern t1atlPattern = trace_34.getT1atlPattern();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull MatchedRule rule = t1atlPattern.getRule();
		final /*@NonInvalid*/ @Nullable TmapMatchedRule TmapMatchedRule = OPPOSITE_OF_TmapMatchedRule_t1matchedRule.get(rule);
		final /*@NonInvalid*/ boolean symbol_0 = TmapMatchedRule != null;
		/*@Thrown*/ @Nullable Boolean raw_when_mapMatchedRule;
		if (symbol_0) {
			if (TmapMatchedRule == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean success = TmapMatchedRule.getSuccess();
			if (success == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_15;
			if (success) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<InPatternElement> elements = t1atlPattern.getElements();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_OclModelElement_0 = idResolver.getClass(CLSSid_OclModelElement, null);
				final /*@NonInvalid*/ @NonNull SetValue BOXED_elements = idResolver.createSetOfAll(SET_CLSSid_InPatternElement, elements);
				/*@Thrown*/ BagValue.@NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_OclType);
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_elements.iterator();
				/*@Thrown*/ @NonNull BagValue collect;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						collect = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull InPatternElement _1 = (@NonNull InPatternElement)ITERATOR__1.next();
					/**
					 * _'1_'.type
					 */
					final /*@NonInvalid*/ @Nullable OclType type_2 = _1.getType();
					//
					accumulator.add(type_2);
				}
				final /*@Thrown*/ @NonNull BagValue selectByKind = (@Nullable BagValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect, TYP_OCL_c_c_OclModelElement_0);
				@NonNull Iterator<Object> ITERATOR__1_0 = selectByKind.iterator();
				/*@Thrown*/ @NonNull OclModelElement any;
				while (true) {
					if (!ITERATOR__1_0.hasNext()) {
						throw new InvalidValueException("Nothing to return for ''any''");
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull OclModelElement _1_0 = (@NonNull OclModelElement)ITERATOR__1_0.next();
					/**
					 * true
					 */
					//
					if (ValueUtil.TRUE_VALUE != ValueUtil.FALSE_VALUE) {			// Carry on till something found
						any = _1_0;
						break;
					}
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull OclModel model = any.getModel();
				final /*@Thrown*/ @Nullable OclModel metamodel = model.getMetamodel();
				final /*@Thrown*/ boolean eq = metamodel == null;
				/*@Thrown*/ @Nullable Boolean symbol_14;
				if (eq) {
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull Relation t2qvtrRelation = TmapMatchedRule.getT2qvtrRelation();
					final /*@Thrown*/ @Nullable TmapOclMetamodel TmapOclMetamodel = OPPOSITE_OF_TmapOclMetamodel_t1oclMetamodel.get(model);
					final /*@Thrown*/ boolean symbol_1 = TmapOclMetamodel != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclMetamodel;
					if (symbol_1) {
						if (TmapOclMetamodel == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull TypedModel t2qvtrTypedModel = TmapOclMetamodel.getT2qvtrTypedModel();
						// creations
						final @NonNull RelationDomain qvtrDomain = QVTrelationFactory.eINSTANCE.createRelationDomain();
						models[1/*qvtr*/].add(qvtrDomain, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrDomain));
						}
						// mapping statements
						qvtrDomain.setIsCheckable(ValueUtil.TRUE_VALUE);
						qvtrDomain.setIsEnforceable(ValueUtil.FALSE_VALUE);
						qvtrDomain.setRule(t2qvtrRelation);
						qvtrDomain.setTypedModel(t2qvtrTypedModel);
						trace_34.setT1atlModel(model);
						trace_34.setT1atlRule(rule);
						trace_34.setT2qvtrDomain(qvtrDomain);
						trace_34.setT2qvtrRelation(t2qvtrRelation);
						trace_34.setT2qvtrTypedModel(t2qvtrTypedModel);
						trace_34.setWmapMatchedRule(TmapMatchedRule);
						trace_34.setWmapOclMetamodel(TmapOclMetamodel);
						final /*@Thrown*/ @Nullable Boolean mmapInPattern__qvtr__residue__ = ValueUtil.TRUE_VALUE;
						raw_when_mapOclMetamodel = mmapInPattern__qvtr__residue__;
					}
					else {
						raw_when_mapOclMetamodel = ValueUtil.FALSE_VALUE;
					}
					symbol_14 = raw_when_mapOclMetamodel;
				}
				else {
					symbol_14 = ValueUtil.FALSE_VALUE;
				}
				symbol_15 = symbol_14;
			}
			else {
				symbol_15 = ValueUtil.FALSE_VALUE;
			}
			raw_when_mapMatchedRule = symbol_15;
		}
		else {
			raw_when_mapMatchedRule = ValueUtil.FALSE_VALUE;
		}
		trace_34.setSuccess(raw_when_mapMatchedRule);
		objectManager.assigned(trace_34, trace_ATL2QVTrPackage.Literals.TMAP_IN_PATTERN__SUCCESS, raw_when_mapMatchedRule);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_mapMatchedRule ? "done "  : "fail ") + "MAP_mmapInPattern__qvtr__residue__");
		}
		return raw_when_mapMatchedRule;
	}

	/**
	 *
	 * map mmapHelper__Operation__qvtr__edge4__type__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapHelper_Operation;
	 * var qvtrFunction : qvtbase::Function[1] := dispatcher.d2qvtrFunction;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var atlType : OCL::OclType[1] := trace.t1atlType;
	 * var getType1 : Class[1] := this.getType(atlType);
	 * set qvtrFunction.type := getType1;
	 *
	 */
	protected boolean MAP_mmapHelper__Operation__qvtr__edge4__type__(final /*@NonInvalid*/ @NonNull TmapHelper_Operation trace_35)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapHelper__Operation__qvtr__edge4__type__" +
					"\n\t\"trace\":" + toDebugString(trace_35) +
					"\n\t\"dispatcher\":" + toDebugString(trace_35.getDispatcher()) +
					"\n\t\"dispatcher.d1atlHelper\":" + toDebugString(trace_35.getDispatcher().getD1atlHelper()) +
					"\n\t\"dispatcher.d2qvtrFunction\":" + toDebugString(trace_35.getDispatcher().getD2qvtrFunction()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_35.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapHelper_Operation domapHelper_Operation = dispatcher_0.getDomapHelper_Operation();
		final /*@NonInvalid*/ boolean eq = trace_35.equals(domapHelper_Operation);
		/*@Thrown*/ @Nullable Boolean symbol_4;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Function d2qvtrFunction = dispatcher_0.getD2qvtrFunction();
			final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_35.getLocalSuccess();
			if (localSuccess == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_3;
			if (localSuccess) {
				final /*@NonInvalid*/ @Nullable Boolean success = trace_35.getSuccess();
				if (success == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_2;
				if (success) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclType t1atlType = trace_35.getT1atlType();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(this, t1atlType)).instance;
					// mapping statements
					d2qvtrFunction.setType(getType);
					final /*@Thrown*/ @Nullable Boolean mmapHelper__Operation__qvtr__edge4__type__ = ValueUtil.TRUE_VALUE;
					symbol_2 = mmapHelper__Operation__qvtr__edge4__type__;
				}
				else {
					symbol_2 = ValueUtil.FALSE_VALUE;
				}
				symbol_3 = symbol_2;
			}
			else {
				symbol_3 = ValueUtil.FALSE_VALUE;
			}
			symbol_4 = symbol_3;
		}
		else {
			symbol_4 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_4 ? "done "  : "fail ") + "MAP_mmapHelper__Operation__qvtr__edge4__type__");
		}
		return symbol_4;
	}

	/**
	 *
	 * map mmapHelper__Attribute__qvtr__edge4__type__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapHelper_Attribute;
	 * var qvtrFunction : qvtbase::Function[1] := dispatcher.d2qvtrFunction;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var atlType : OCL::OclType[1] := trace.t1atlType;
	 * var getType1 : Class[1] := this.getType(atlType);
	 * set qvtrFunction.type := getType1;
	 *
	 */
	protected boolean MAP_mmapHelper__Attribute__qvtr__edge4__type__(final /*@NonInvalid*/ @NonNull TmapHelper_Attribute trace_36)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapHelper__Attribute__qvtr__edge4__type__" +
					"\n\t\"trace\":" + toDebugString(trace_36) +
					"\n\t\"dispatcher\":" + toDebugString(trace_36.getDispatcher()) +
					"\n\t\"dispatcher.d1atlHelper\":" + toDebugString(trace_36.getDispatcher().getD1atlHelper()) +
					"\n\t\"dispatcher.d2qvtrFunction\":" + toDebugString(trace_36.getDispatcher().getD2qvtrFunction()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_36.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapHelper_Attribute domapHelper_Attribute = dispatcher_0.getDomapHelper_Attribute();
		final /*@NonInvalid*/ boolean eq = trace_36.equals(domapHelper_Attribute);
		/*@Thrown*/ @Nullable Boolean symbol_4;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Function d2qvtrFunction = dispatcher_0.getD2qvtrFunction();
			final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_36.getLocalSuccess();
			if (localSuccess == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_3;
			if (localSuccess) {
				final /*@NonInvalid*/ @Nullable Boolean success = trace_36.getSuccess();
				if (success == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_2;
				if (success) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclType t1atlType = trace_36.getT1atlType();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(this, t1atlType)).instance;
					// mapping statements
					d2qvtrFunction.setType(getType);
					final /*@Thrown*/ @Nullable Boolean mmapHelper__Attribute__qvtr__edge4__type__ = ValueUtil.TRUE_VALUE;
					symbol_2 = mmapHelper__Attribute__qvtr__edge4__type__;
				}
				else {
					symbol_2 = ValueUtil.FALSE_VALUE;
				}
				symbol_3 = symbol_2;
			}
			else {
				symbol_3 = ValueUtil.FALSE_VALUE;
			}
			symbol_4 = symbol_3;
		}
		else {
			symbol_4 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_4 ? "done "  : "fail ") + "MAP_mmapHelper__Attribute__qvtr__edge4__type__");
		}
		return symbol_4;
	}

	/**
	 *
	 * map mmapMatchedRule__super__qvtr__residue__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapMatchedRule_super[1];
	 * var atlChildRule : ATL::MatchedRule[1] := trace.t1atlChildRule;
	 * var when_mapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1] := atlChildRule.TmapMatchedRule;
	 * check when_mapMatchedRule.success;
	 * var atlSuperRule : ATL::MatchedRule[1] := atlChildRule.superRule;
	 * var when_mapMatchedRule1 : trace_ATL2QVTr::TmapMatchedRule[1] := atlSuperRule.TmapMatchedRule;
	 * check when_mapMatchedRule1.success;
	 * var qvtrOverridesRelation : qvtrelation::Relation[1] := when_mapMatchedRule.t2qvtrRelation;
	 * var qvtrOverriddenRelation : qvtrelation::Relation[1] := when_mapMatchedRule1.t2qvtrRelation;
	 * set qvtrOverridesRelation.overrides := qvtrOverriddenRelation;
	 * set trace.t1atlSuperRule := atlSuperRule;
	 * set trace.t2qvtrOverriddenRelation := qvtrOverriddenRelation;
	 * set trace.t2qvtrOverridesRelation := qvtrOverridesRelation;
	 * set trace.wmapMatchedRule1 := when_mapMatchedRule;
	 * set trace.wmapMatchedRule := when_mapMatchedRule1;
	 *
	 */
	protected boolean MAP_mmapMatchedRule__super__qvtr__residue__(final /*@NonInvalid*/ @NonNull TmapMatchedRule_super trace_37)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapMatchedRule__super__qvtr__residue__" +
					"\n\t\"trace\":" + toDebugString(trace_37));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull MatchedRule t1atlChildRule = trace_37.getT1atlChildRule();
		final /*@NonInvalid*/ @Nullable TmapMatchedRule TmapMatchedRule = OPPOSITE_OF_TmapMatchedRule_t1matchedRule.get(t1atlChildRule);
		final /*@NonInvalid*/ boolean symbol_0 = TmapMatchedRule != null;
		/*@Thrown*/ @Nullable Boolean raw_when_mapMatchedRule;
		if (symbol_0) {
			if (TmapMatchedRule == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean success = TmapMatchedRule.getSuccess();
			if (success == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_11;
			if (success) {
				final /*@NonInvalid*/ @Nullable MatchedRule superRule = t1atlChildRule.getSuperRule();
				final /*@NonInvalid*/ boolean symbol_1 = superRule != null;
				/*@Thrown*/ @Nullable Boolean raw_atlSuperRule;
				if (symbol_1) {
					if (superRule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable TmapMatchedRule TmapMatchedRule_0 = OPPOSITE_OF_TmapMatchedRule_t1matchedRule.get(superRule);
					final /*@Thrown*/ boolean symbol_2 = TmapMatchedRule_0 != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapMatchedRule1;
					if (symbol_2) {
						if (TmapMatchedRule_0 == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean success_0 = TmapMatchedRule_0.getSuccess();
						if (success_0 == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_10;
						if (success_0) {
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull Relation t2qvtrRelation = TmapMatchedRule.getT2qvtrRelation();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull Relation t2qvtrRelation_0 = TmapMatchedRule_0.getT2qvtrRelation();
							// mapping statements
							t2qvtrRelation.getOverrides().add(t2qvtrRelation_0);
							trace_37.setT1atlSuperRule(superRule);
							trace_37.setT2qvtrOverriddenRelation(t2qvtrRelation_0);
							trace_37.setT2qvtrOverridesRelation(t2qvtrRelation);
							trace_37.setWmapMatchedRule1(TmapMatchedRule);
							trace_37.setWmapMatchedRule(TmapMatchedRule_0);
							final /*@Thrown*/ @Nullable Boolean mmapMatchedRule__super__qvtr__residue__ = ValueUtil.TRUE_VALUE;
							symbol_10 = mmapMatchedRule__super__qvtr__residue__;
						}
						else {
							symbol_10 = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapMatchedRule1 = symbol_10;
					}
					else {
						raw_when_mapMatchedRule1 = ValueUtil.FALSE_VALUE;
					}
					raw_atlSuperRule = raw_when_mapMatchedRule1;
				}
				else {
					raw_atlSuperRule = ValueUtil.FALSE_VALUE;
				}
				symbol_11 = raw_atlSuperRule;
			}
			else {
				symbol_11 = ValueUtil.FALSE_VALUE;
			}
			raw_when_mapMatchedRule = symbol_11;
		}
		else {
			raw_when_mapMatchedRule = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_mapMatchedRule ? "done "  : "fail ") + "MAP_mmapMatchedRule__super__qvtr__residue__");
		}
		return raw_when_mapMatchedRule;
	}

	/**
	 *
	 * map mmapSimpleOutPatternElement__qvtr__residue__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapSimpleOutPatternElement[1] success success;
	 * append jm_TmapVariable  : trace_ATL2QVTr::TmapVariable[1];
	 * var atlElement : ATL::SimpleOutPatternElement[1] := trace.t1atlElement;
	 * check var atlType : OCL::OclModelElement[1] := atlElement.type;
	 * var atlPattern : ATL::OutPattern[1] := atlElement.outPattern;
	 * check var atlRule : ATL::MatchedRule[1] := atlPattern.rule;
	 * var when_mapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1] := atlRule.TmapMatchedRule;
	 * check when_mapMatchedRule.success;
	 * var atlMetamodel : OCL::OclModel[1] := atlType.model;
	 * check atlMetamodel.metamodel =
	 *   null;
	 * var elementName : String[1] := atlElement.varName;
	 * var when_mapOclMetamodel : trace_ATL2QVTr::TmapOclMetamodel[1] := atlMetamodel.TmapOclMetamodel;
	 * var qvtrRelation : qvtrelation::Relation[1] := when_mapMatchedRule.t2qvtrRelation;
	 * var qvtrTypedModel : qvtbase::TypedModel[1] := when_mapOclMetamodel.t2qvtrTypedModel;
	 * var getType1 : Class[1] := this.getType(atlType);
	 * new:qvtr qvtrDomain : qvtrelation::RelationDomain[1];
	 * new:qvtr qvtrPattern : qvtrelation::DomainPattern[1];
	 * new:qvtr qvtrTemplate : qvttemplate::ObjectTemplateExp[1];
	 * new:qvtr qvtrVariable : qvtrelation::TemplateVariable[1];
	 * new:middle where_mapVariable : trace_ATL2QVTr::TmapVariable[1];
	 * set qvtrDomain.isCheckable := false;
	 * set qvtrDomain.isEnforceable := true;
	 * set qvtrVariable.name := elementName;
	 * set trace.t0elementName := elementName;
	 * set qvtrDomain.rule := qvtrRelation;
	 * set qvtrDomain.typedModel := qvtrTypedModel;
	 * set qvtrPattern.relationDomain := qvtrDomain;
	 * set qvtrPattern.templateExpression := qvtrTemplate;
	 * set qvtrTemplate.bindsTo := qvtrVariable;
	 * set qvtrTemplate.referredClass := getType1;
	 * notify set qvtrTemplate.type := getType1;
	 * set qvtrRelation.variable := qvtrVariable;
	 * set qvtrDomain.rootVariable := qvtrVariable;
	 * notify set qvtrVariable.type := getType1;
	 * set trace.t1atlMetamodel := atlMetamodel;
	 * set trace.t1atlPattern := atlPattern;
	 * set trace.t1atlRule := atlRule;
	 * set trace.t1atlType := atlType;
	 * set trace.t2qvtrDomain := qvtrDomain;
	 * set trace.t2qvtrPattern := qvtrPattern;
	 * set trace.t2qvtrRelation := qvtrRelation;
	 * set trace.t2qvtrTemplate := qvtrTemplate;
	 * set trace.t2qvtrTypedModel := qvtrTypedModel;
	 * set trace.t2qvtrVariable := qvtrVariable;
	 * set trace.wmapMatchedRule := when_mapMatchedRule;
	 * set trace.wmapOclMetamodel := when_mapOclMetamodel;
	 * set trace.wmapVariable := where_mapVariable;
	 * set where_mapVariable.t1atlVariable := atlElement;
	 * set where_mapVariable.t2qvtrVariable := qvtrVariable;
	 * add jm_TmapVariable += where_mapVariable;
	 *
	 */
	protected boolean MAP_mmapSimpleOutPatternElement__qvtr__residue__(final @NonNull Connection jm_TmapVariable, final /*@NonInvalid*/ @NonNull TmapSimpleOutPatternElement trace_38)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapSimpleOutPatternElement__qvtr__residue__" +
					"\n\t\"trace\":" + toDebugString(trace_38));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull SimpleOutPatternElement t1atlElement = trace_38.getT1atlElement();
		final /*@NonInvalid*/ @Nullable OclType temp1_atlType = t1atlElement.getType();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlType instanceof OclModelElement;
		/*@Thrown*/ @Nullable Boolean symbol_40;
		if (symbol_0) {
			final /*@NonInvalid*/ @Nullable OclModelElement symbol_1 = (OclModelElement)temp1_atlType;
			if (symbol_1 == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OutPattern outPattern = t1atlElement.getOutPattern();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Rule temp1_atlRule = outPattern.getRule();
			final /*@NonInvalid*/ boolean symbol_2 = temp1_atlRule instanceof MatchedRule;
			/*@Thrown*/ @Nullable Boolean symbol_39;
			if (symbol_2) {
				final /*@NonInvalid*/ @NonNull MatchedRule symbol_3 = (MatchedRule)temp1_atlRule;
				final /*@NonInvalid*/ @Nullable TmapMatchedRule TmapMatchedRule = OPPOSITE_OF_TmapMatchedRule_t1matchedRule.get(symbol_3);
				final /*@NonInvalid*/ boolean symbol_4 = TmapMatchedRule != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapMatchedRule;
				if (symbol_4) {
					if (TmapMatchedRule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable Boolean success = TmapMatchedRule.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_38;
					if (success) {
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull OclModel model = symbol_1.getModel();
						final /*@Thrown*/ @Nullable OclModel metamodel = model.getMetamodel();
						final /*@Thrown*/ boolean eq = metamodel == null;
						/*@Thrown*/ @Nullable Boolean symbol_37;
						if (eq) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String varName = t1atlElement.getVarName();
							final /*@Thrown*/ @Nullable TmapOclMetamodel TmapOclMetamodel = OPPOSITE_OF_TmapOclMetamodel_t1oclMetamodel.get(model);
							final /*@Thrown*/ boolean symbol_5 = TmapOclMetamodel != null;
							/*@Thrown*/ @Nullable Boolean raw_when_mapOclMetamodel;
							if (symbol_5) {
								if (TmapOclMetamodel == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull Relation t2qvtrRelation = TmapMatchedRule.getT2qvtrRelation();
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull TypedModel t2qvtrTypedModel = TmapOclMetamodel.getT2qvtrTypedModel();
								final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(this, symbol_1)).instance;
								// creations
								final @NonNull RelationDomain qvtrDomain = QVTrelationFactory.eINSTANCE.createRelationDomain();
								models[1/*qvtr*/].add(qvtrDomain, false);
								if (debugCreations) {
									AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrDomain));
								}
								final @NonNull DomainPattern qvtrPattern = QVTrelationFactory.eINSTANCE.createDomainPattern();
								models[1/*qvtr*/].add(qvtrPattern, false);
								if (debugCreations) {
									AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrPattern));
								}
								final @NonNull ObjectTemplateExp qvtrTemplate = QVTtemplateFactory.eINSTANCE.createObjectTemplateExp();
								models[1/*qvtr*/].add(qvtrTemplate, false);
								if (debugCreations) {
									AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrTemplate));
								}
								final @NonNull TemplateVariable qvtrVariable = QVTrelationFactory.eINSTANCE.createTemplateVariable();
								models[1/*qvtr*/].add(qvtrVariable, false);
								if (debugCreations) {
									AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrVariable));
								}
								final @SuppressWarnings("null")@NonNull TmapVariable where_mapVariable = trace_ATL2QVTrFactory.eINSTANCE.createTmapVariable();
								models[2/*middle*/].add(where_mapVariable, false);
								if (debugCreations) {
									AbstractTransformer.CREATIONS.println("created " + toDebugString(where_mapVariable));
								}
								// mapping statements
								qvtrDomain.setIsCheckable(ValueUtil.FALSE_VALUE);
								qvtrDomain.setIsEnforceable(ValueUtil.TRUE_VALUE);
								qvtrVariable.setName(varName);
								trace_38.setT0elementName(varName);
								qvtrDomain.setRule(t2qvtrRelation);
								qvtrDomain.setTypedModel(t2qvtrTypedModel);
								qvtrPattern.setRelationDomain(qvtrDomain);
								qvtrPattern.setTemplateExpression(qvtrTemplate);
								qvtrTemplate.setBindsTo(qvtrVariable);
								qvtrTemplate.setReferredClass(getType);
								qvtrTemplate.setType(getType);
								objectManager.assigned(qvtrTemplate, PivotPackage.Literals.TYPED_ELEMENT__TYPE, getType);
								t2qvtrRelation.getVariable().add(qvtrVariable);
								qvtrDomain.getRootVariable().add(qvtrVariable);
								qvtrVariable.setType(getType);
								objectManager.assigned(qvtrVariable, PivotPackage.Literals.TYPED_ELEMENT__TYPE, getType);
								trace_38.setT1atlMetamodel(model);
								trace_38.setT1atlPattern(outPattern);
								trace_38.setT1atlRule(symbol_3);
								trace_38.setT1atlType(symbol_1);
								trace_38.setT2qvtrDomain(qvtrDomain);
								trace_38.setT2qvtrPattern(qvtrPattern);
								trace_38.setT2qvtrRelation(t2qvtrRelation);
								trace_38.setT2qvtrTemplate(qvtrTemplate);
								trace_38.setT2qvtrTypedModel(t2qvtrTypedModel);
								trace_38.setT2qvtrVariable(qvtrVariable);
								trace_38.setWmapMatchedRule(TmapMatchedRule);
								trace_38.setWmapOclMetamodel(TmapOclMetamodel);
								trace_38.setWmapVariable(where_mapVariable);
								OPPOSITE_OF_TmapVariable_t1atlVariable.put(t1atlElement, where_mapVariable);
								where_mapVariable.setT1atlVariable(t1atlElement);
								where_mapVariable.setT2qvtrVariable(qvtrVariable);
								jm_TmapVariable.appendElement(where_mapVariable);
								final /*@Thrown*/ @Nullable Boolean mmapSimpleOutPatternElement__qvtr__residue__ = ValueUtil.TRUE_VALUE;
								raw_when_mapOclMetamodel = mmapSimpleOutPatternElement__qvtr__residue__;
							}
							else {
								raw_when_mapOclMetamodel = ValueUtil.FALSE_VALUE;
							}
							symbol_37 = raw_when_mapOclMetamodel;
						}
						else {
							symbol_37 = ValueUtil.FALSE_VALUE;
						}
						symbol_38 = symbol_37;
					}
					else {
						symbol_38 = ValueUtil.FALSE_VALUE;
					}
					raw_when_mapMatchedRule = symbol_38;
				}
				else {
					raw_when_mapMatchedRule = ValueUtil.FALSE_VALUE;
				}
				symbol_39 = raw_when_mapMatchedRule;
			}
			else {
				symbol_39 = ValueUtil.FALSE_VALUE;
			}
			symbol_40 = symbol_39;
		}
		else {
			symbol_40 = ValueUtil.FALSE_VALUE;
		}
		trace_38.setSuccess(symbol_40);
		objectManager.assigned(trace_38, trace_ATL2QVTrPackage.Literals.TMAP_SIMPLE_OUT_PATTERN_ELEMENT__SUCCESS, symbol_40);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_40 ? "done "  : "fail ") + "MAP_mmapSimpleOutPatternElement__qvtr__residue__");
		}
		return symbol_40;
	}

	/**
	 *
	 * map mmapHelper__Context__qvtr in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapHelper_Context[1];
	 * append jm_TmapVariable  : trace_ATL2QVTr::TmapVariable[1];
	 * var atlHelper : ATL::Helper[1] := trace.t1atlHelper;
	 * var qvtrFunction : qvtbase::Function[1] := trace.t2qvtrFunction;
	 * var atlDefinition : OCL::OclFeatureDefinition[1] := atlHelper.definition;
	 * var atlContext : OCL::OclContextDefinition[1] := atlDefinition.context_;
	 * var atlReturnType : OCL::OclType[1] := atlContext.context_;
	 * var getType1 : Class[1] := this.getType(atlReturnType);
	 * new:qvtr qvtrParameter : qvtbase::FunctionParameter[1];
	 * new:middle where_mapVariable : trace_ATL2QVTr::TmapVariable[1];
	 * set qvtrParameter.name := 'self';
	 * set qvtrFunction.ownedParameters := qvtrParameter;
	 * set trace.t1atlContext := atlContext;
	 * set trace.t1atlDefinition := atlDefinition;
	 * set trace.t1atlReturnType := atlReturnType;
	 * set trace.t2qvtrParameter := qvtrParameter;
	 * set trace.wmapVariable := where_mapVariable;
	 * set qvtrParameter.type := getType1;
	 * set where_mapVariable.t1atlVariable := atlHelper;
	 * set where_mapVariable.t2qvtrVariable := qvtrParameter;
	 * add jm_TmapVariable += where_mapVariable;
	 *
	 */
	protected boolean MAP_mmapHelper__Context__qvtr(final @NonNull Connection jm_TmapVariable_0, final /*@NonInvalid*/ @NonNull TmapHelper_Context trace_39)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapHelper__Context__qvtr" +
					"\n\t\"trace\":" + toDebugString(trace_39));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Helper t1atlHelper = trace_39.getT1atlHelper();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Function t2qvtrFunction = trace_39.getT2qvtrFunction();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = t1atlHelper.getDefinition();
		final /*@NonInvalid*/ @Nullable OclContextDefinition context_ = definition.getContext_();
		final /*@NonInvalid*/ boolean symbol_0 = context_ != null;
		/*@Thrown*/ @Nullable Boolean raw_atlContext;
		if (symbol_0) {
			if (context_ == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull OclType context__0 = context_.getContext_();
			final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(this, context__0)).instance;
			// creations
			final @NonNull FunctionParameter qvtrParameter = QVTbaseFactory.eINSTANCE.createFunctionParameter();
			models[1/*qvtr*/].add(qvtrParameter, false);
			if (debugCreations) {
				AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrParameter));
			}
			final @SuppressWarnings("null")@NonNull TmapVariable where_mapVariable = trace_ATL2QVTrFactory.eINSTANCE.createTmapVariable();
			models[2/*middle*/].add(where_mapVariable, false);
			if (debugCreations) {
				AbstractTransformer.CREATIONS.println("created " + toDebugString(where_mapVariable));
			}
			// mapping statements
			qvtrParameter.setName(STR_self);
			t2qvtrFunction.getOwnedParameters().add(qvtrParameter);
			trace_39.setT1atlContext(context_);
			trace_39.setT1atlDefinition(definition);
			trace_39.setT1atlReturnType(context__0);
			trace_39.setT2qvtrParameter(qvtrParameter);
			trace_39.setWmapVariable(where_mapVariable);
			qvtrParameter.setType(getType);
			OPPOSITE_OF_TmapVariable_t1atlVariable.put(t1atlHelper, where_mapVariable);
			where_mapVariable.setT1atlVariable(t1atlHelper);
			where_mapVariable.setT2qvtrVariable(qvtrParameter);
			jm_TmapVariable_0.appendElement(where_mapVariable);
			final /*@Thrown*/ @Nullable Boolean mmapHelper__Context__qvtr = ValueUtil.TRUE_VALUE;
			raw_atlContext = mmapHelper__Context__qvtr;
		}
		else {
			raw_atlContext = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_atlContext ? "done "  : "fail ") + "MAP_mmapHelper__Context__qvtr");
		}
		return raw_atlContext;
	}

	/**
	 *
	 * map mmapOperationCallExp__Helper__qvtr__edge8__referred in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperationCallExp_Helper;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var when_mapHelper_Operation : trace_ATL2QVTr::DmapHelper[1] := trace.wmapHelper;
	 * var qvtrOperation : Operation[1] := when_mapHelper_Operation.d2qvtrFunction;
	 * set trace.t2qvtrOperation := qvtrOperation;
	 * set qvtrExpression.referredOperation := qvtrOperation;
	 *
	 */
	protected boolean MAP_mmapOperationCallExp__Helper__qvtr__edge8__referred(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_40)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperationCallExp__Helper__qvtr__edge8__referred" +
					"\n\t\"trace\":" + toDebugString(trace_40) +
					"\n\t\"dispatcher\":" + toDebugString(trace_40.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_40.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_40.getDispatcher().getD2qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_40.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Helper domapOperationCallExp_Helper = dispatcher_0.getDomapOperationCallExp_Helper();
		final /*@NonInvalid*/ boolean eq = trace_40.equals(domapOperationCallExp_Helper);
		/*@Thrown*/ @Nullable Boolean symbol_9;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_8;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_40.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_7;
				if (localSuccess) {
					final /*@NonInvalid*/ @Nullable Boolean success = trace_40.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_6;
					if (success) {
						final /*@NonInvalid*/ @Nullable DmapHelper wmapHelper = trace_40.getWmapHelper();
						final /*@NonInvalid*/ boolean symbol_2 = wmapHelper != null;
						/*@Thrown*/ @Nullable Boolean raw_when_mapHelper_Operation;
						if (symbol_2) {
							if (wmapHelper == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull Function d2qvtrFunction = wmapHelper.getD2qvtrFunction();
							// mapping statements
							trace_40.setT2qvtrOperation(d2qvtrFunction);
							symbol_1.setReferredOperation(d2qvtrFunction);
							final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Helper__qvtr__edge8__referred = ValueUtil.TRUE_VALUE;
							raw_when_mapHelper_Operation = mmapOperationCallExp__Helper__qvtr__edge8__referred;
						}
						else {
							raw_when_mapHelper_Operation = ValueUtil.FALSE_VALUE;
						}
						symbol_6 = raw_when_mapHelper_Operation;
					}
					else {
						symbol_6 = ValueUtil.FALSE_VALUE;
					}
					symbol_7 = symbol_6;
				}
				else {
					symbol_7 = ValueUtil.FALSE_VALUE;
				}
				symbol_8 = symbol_7;
			}
			else {
				symbol_8 = ValueUtil.FALSE_VALUE;
			}
			symbol_9 = symbol_8;
		}
		else {
			symbol_9 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_9 ? "done "  : "fail ") + "MAP_mmapOperationCallExp__Helper__qvtr__edge8__referred");
		}
		return symbol_9;
	}

	/**
	 *
	 * map mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_1 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapNavigationOrAttributeCallExp_Helper;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var qvtrOperation : Operation[1] := trace.t2qvtrOperation;
	 * var type : Type[?] := qvtrOperation.type;
	 * notify set qvtrExpression.type := type;
	 *
	 */
	protected boolean MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_1(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_41)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_1" +
					"\n\t\"trace\":" + toDebugString(trace_41) +
					"\n\t\"dispatcher\":" + toDebugString(trace_41.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_41.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_41.getDispatcher().getD2qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_41.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Helper domapNavigationOrAttributeCallExp_Helper = dispatcher_0.getDomapNavigationOrAttributeCallExp_Helper();
		final /*@NonInvalid*/ boolean eq = trace_41.equals(domapNavigationOrAttributeCallExp_Helper);
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_41.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (localSuccess) {
					final /*@NonInvalid*/ @Nullable Boolean success = trace_41.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_4;
					if (success) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull Operation t2qvtrOperation = trace_41.getT2qvtrOperation();
						final /*@NonInvalid*/ @Nullable Type type_2 = t2qvtrOperation.getType();
						// mapping statements
						symbol_1.setType(type_2);
						objectManager.assigned(symbol_1, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_2);
						final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_1 = ValueUtil.TRUE_VALUE;
						symbol_4 = mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_1;
					}
					else {
						symbol_4 = ValueUtil.FALSE_VALUE;
					}
					symbol_5 = symbol_4;
				}
				else {
					symbol_5 = ValueUtil.FALSE_VALUE;
				}
				symbol_6 = symbol_5;
			}
			else {
				symbol_6 = ValueUtil.FALSE_VALUE;
			}
			symbol_7 = symbol_6;
		}
		else {
			symbol_7 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_1");
		}
		return symbol_7;
	}

	/**
	 *
	 * map mmapOperationCallExp__Helper__qvtr__edge9__type__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperationCallExp_Helper;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var qvtrOperation : Operation[1] := trace.t2qvtrOperation;
	 * var type : Type[?] := qvtrOperation.type;
	 * notify set qvtrExpression.type := type;
	 *
	 */
	protected boolean MAP_mmapOperationCallExp__Helper__qvtr__edge9__type__(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_42)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperationCallExp__Helper__qvtr__edge9__type__" +
					"\n\t\"trace\":" + toDebugString(trace_42) +
					"\n\t\"dispatcher\":" + toDebugString(trace_42.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_42.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_42.getDispatcher().getD2qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_42.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Helper domapOperationCallExp_Helper = dispatcher_0.getDomapOperationCallExp_Helper();
		final /*@NonInvalid*/ boolean eq = trace_42.equals(domapOperationCallExp_Helper);
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_42.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (localSuccess) {
					final /*@NonInvalid*/ @Nullable Boolean success = trace_42.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_4;
					if (success) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull Operation t2qvtrOperation = trace_42.getT2qvtrOperation();
						final /*@NonInvalid*/ @Nullable Type type_2 = t2qvtrOperation.getType();
						// mapping statements
						symbol_1.setType(type_2);
						objectManager.assigned(symbol_1, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_2);
						final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Helper__qvtr__edge9__type__ = ValueUtil.TRUE_VALUE;
						symbol_4 = mmapOperationCallExp__Helper__qvtr__edge9__type__;
					}
					else {
						symbol_4 = ValueUtil.FALSE_VALUE;
					}
					symbol_5 = symbol_4;
				}
				else {
					symbol_5 = ValueUtil.FALSE_VALUE;
				}
				symbol_6 = symbol_5;
			}
			else {
				symbol_6 = ValueUtil.FALSE_VALUE;
			}
			symbol_7 = symbol_6;
		}
		else {
			symbol_7 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_mmapOperationCallExp__Helper__qvtr__edge9__type__");
		}
		return symbol_7;
	}

	/**
	 *
	 * map mmapSimpleInPatternElement__qvtr__residue__ in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapSimpleInPatternElement[1];
	 * append jm_TmapVariable  : trace_ATL2QVTr::TmapVariable[1];
	 * var atlElement : ATL::SimpleInPatternElement[1] := trace.t1atlElement;
	 * var atlPattern : ATL::InPattern[1] := atlElement.inPattern;
	 * var when_mapInPattern : trace_ATL2QVTr::TmapInPattern[1] := atlPattern.TmapInPattern;
	 * check when_mapInPattern.success;
	 * var atlRule : ATL::MatchedRule[1] := atlPattern.rule;
	 * var when_mapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1] := atlRule.TmapMatchedRule;
	 * check when_mapMatchedRule.success;
	 * var type : OCL::OclType[?] := atlElement.type;
	 * var elementName : String[1] := atlElement.varName;
	 * var qvtrDomain : qvtrelation::RelationDomain[1] := when_mapInPattern.t2qvtrDomain;
	 * var qvtrRelation : qvtrelation::Relation[1] := when_mapMatchedRule.t2qvtrRelation;
	 * var getType1 : Class[1] := this.getType(type)
	 *   ;
	 * var getType2 : Class[1] := this.getType(type);
	 * new:qvtr qvtrPattern : qvtrelation::DomainPattern[1];
	 * new:qvtr qvtrTemplate : qvttemplate::ObjectTemplateExp[1];
	 * new:qvtr qvtrVariable : qvtrelation::TemplateVariable[1];
	 * new:middle where_mapVariable : trace_ATL2QVTr::TmapVariable[1];
	 * set qvtrVariable.name := elementName;
	 * set trace.t0elementName := elementName;
	 * set qvtrDomain.pattern := qvtrPattern;
	 * set qvtrPattern.templateExpression := qvtrTemplate;
	 * set qvtrTemplate.bindsTo := qvtrVariable;
	 * set qvtrTemplate.referredClass := getType1;
	 * notify set qvtrTemplate.type := getType2;
	 * set qvtrRelation.variable := qvtrVariable;
	 * set qvtrDomain.rootVariable := qvtrVariable;
	 * notify set qvtrVariable.type := getType1;
	 * set trace.t1atlPattern := atlPattern;
	 * set trace.t1atlRule := atlRule;
	 * set trace.t2qvtrDomain := qvtrDomain;
	 * set trace.t2qvtrPattern := qvtrPattern;
	 * set trace.t2qvtrRelation := qvtrRelation;
	 * set trace.t2qvtrTemplate := qvtrTemplate;
	 * set trace.t2qvtrVariable := qvtrVariable;
	 * set trace.wmapInPattern := when_mapInPattern;
	 * set trace.wmapMatchedRule := when_mapMatchedRule;
	 * set trace.wmapVariable := where_mapVariable;
	 * set where_mapVariable.t1atlVariable := atlElement;
	 * set where_mapVariable.t2qvtrVariable := qvtrVariable;
	 * add jm_TmapVariable += where_mapVariable;
	 *
	 */
	protected boolean MAP_mmapSimpleInPatternElement__qvtr__residue__(final @NonNull Connection jm_TmapVariable_1, final /*@NonInvalid*/ @NonNull TmapSimpleInPatternElement trace_43)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapSimpleInPatternElement__qvtr__residue__" +
					"\n\t\"trace\":" + toDebugString(trace_43));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull SimpleInPatternElement t1atlElement = trace_43.getT1atlElement();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull InPattern inPattern = t1atlElement.getInPattern();
		final /*@NonInvalid*/ @Nullable TmapInPattern TmapInPattern = OPPOSITE_OF_TmapInPattern_t1atlPattern.get(inPattern);
		final /*@NonInvalid*/ boolean symbol_0 = TmapInPattern != null;
		/*@Thrown*/ @Nullable Boolean raw_when_mapInPattern;
		if (symbol_0) {
			if (TmapInPattern == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean success = TmapInPattern.getSuccess();
			if (success == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_27;
			if (success) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull MatchedRule rule = inPattern.getRule();
				final /*@NonInvalid*/ @Nullable TmapMatchedRule TmapMatchedRule = OPPOSITE_OF_TmapMatchedRule_t1matchedRule.get(rule);
				final /*@NonInvalid*/ boolean symbol_1 = TmapMatchedRule != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapMatchedRule;
				if (symbol_1) {
					if (TmapMatchedRule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable Boolean success_0 = TmapMatchedRule.getSuccess();
					if (success_0 == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_26;
					if (success_0) {
						final /*@NonInvalid*/ @Nullable OclType type_2 = t1atlElement.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String varName = t1atlElement.getVarName();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull RelationDomain t2qvtrDomain = TmapInPattern.getT2qvtrDomain();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull Relation t2qvtrRelation = TmapMatchedRule.getT2qvtrRelation();
						final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(this, type_2)).instance;
						// creations
						final @NonNull DomainPattern qvtrPattern = QVTrelationFactory.eINSTANCE.createDomainPattern();
						models[1/*qvtr*/].add(qvtrPattern, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrPattern));
						}
						final @NonNull ObjectTemplateExp qvtrTemplate = QVTtemplateFactory.eINSTANCE.createObjectTemplateExp();
						models[1/*qvtr*/].add(qvtrTemplate, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrTemplate));
						}
						final @NonNull TemplateVariable qvtrVariable = QVTrelationFactory.eINSTANCE.createTemplateVariable();
						models[1/*qvtr*/].add(qvtrVariable, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrVariable));
						}
						final @SuppressWarnings("null")@NonNull TmapVariable where_mapVariable = trace_ATL2QVTrFactory.eINSTANCE.createTmapVariable();
						models[2/*middle*/].add(where_mapVariable, false);
						if (debugCreations) {
							AbstractTransformer.CREATIONS.println("created " + toDebugString(where_mapVariable));
						}
						// mapping statements
						qvtrVariable.setName(varName);
						trace_43.setT0elementName(varName);
						t2qvtrDomain.getPattern().add(qvtrPattern);
						qvtrPattern.setTemplateExpression(qvtrTemplate);
						qvtrTemplate.setBindsTo(qvtrVariable);
						qvtrTemplate.setReferredClass(getType);
						qvtrTemplate.setType(getType);
						objectManager.assigned(qvtrTemplate, PivotPackage.Literals.TYPED_ELEMENT__TYPE, getType);
						t2qvtrRelation.getVariable().add(qvtrVariable);
						t2qvtrDomain.getRootVariable().add(qvtrVariable);
						qvtrVariable.setType(getType);
						objectManager.assigned(qvtrVariable, PivotPackage.Literals.TYPED_ELEMENT__TYPE, getType);
						trace_43.setT1atlPattern(inPattern);
						trace_43.setT1atlRule(rule);
						trace_43.setT2qvtrDomain(t2qvtrDomain);
						trace_43.setT2qvtrPattern(qvtrPattern);
						trace_43.setT2qvtrRelation(t2qvtrRelation);
						trace_43.setT2qvtrTemplate(qvtrTemplate);
						trace_43.setT2qvtrVariable(qvtrVariable);
						trace_43.setWmapInPattern(TmapInPattern);
						trace_43.setWmapMatchedRule(TmapMatchedRule);
						trace_43.setWmapVariable(where_mapVariable);
						OPPOSITE_OF_TmapVariable_t1atlVariable.put(t1atlElement, where_mapVariable);
						where_mapVariable.setT1atlVariable(t1atlElement);
						where_mapVariable.setT2qvtrVariable(qvtrVariable);
						jm_TmapVariable_1.appendElement(where_mapVariable);
						final /*@Thrown*/ @Nullable Boolean mmapSimpleInPatternElement__qvtr__residue__ = ValueUtil.TRUE_VALUE;
						symbol_26 = mmapSimpleInPatternElement__qvtr__residue__;
					}
					else {
						symbol_26 = ValueUtil.FALSE_VALUE;
					}
					raw_when_mapMatchedRule = symbol_26;
				}
				else {
					raw_when_mapMatchedRule = ValueUtil.FALSE_VALUE;
				}
				symbol_27 = raw_when_mapMatchedRule;
			}
			else {
				symbol_27 = ValueUtil.FALSE_VALUE;
			}
			raw_when_mapInPattern = symbol_27;
		}
		else {
			raw_when_mapInPattern = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_mapInPattern ? "done "  : "fail ") + "MAP_mmapSimpleInPatternElement__qvtr__residue__");
		}
		return raw_when_mapInPattern;
	}

	/**
	 *
	 * map mmapInPattern__filter__qvtr__residue__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapInPattern_filter[1];
	 * var atlPattern : ATL::InPattern[1] := trace.t1atlPattern;
	 * var when_mapInPattern : trace_ATL2QVTr::TmapInPattern[1] := atlPattern.TmapInPattern;
	 * check when_mapInPattern.success;
	 * var atlExpression : OCL::OclExpression[1] := atlPattern.filter;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlExpression.DmapOclExpression;
	 * check when_mapOclExpression.success;
	 * var atlRule : ATL::MatchedRule[1] := atlPattern.rule;
	 * var when_mapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1] := atlRule.TmapMatchedRule;
	 * check when_mapMatchedRule.success;
	 * var qvtrDomain : qvtrelation::RelationDomain[1] := when_mapInPattern.t2qvtrDomain;
	 * var qvtrExpression : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * var qvtrRelation : qvtrelation::Relation[1] := when_mapMatchedRule.t2qvtrRelation;
	 * new:qvtr p : qvtbase::Predicate[1];
	 * new:qvtr w : qvtbase::Pattern[1];
	 * set qvtrDomain.rule := qvtrRelation;
	 * set qvtrRelation.when := w;
	 * set p.conditionExpression := qvtrExpression;
	 * set trace.t1atlExpression := atlExpression;
	 * set trace.t1atlRule := atlRule;
	 * set trace.t2p := p;
	 * set trace.t2qvtrDomain := qvtrDomain;
	 * set trace.t2qvtrExpression := qvtrExpression;
	 * set trace.t2qvtrRelation := qvtrRelation;
	 * set trace.t2w := w;
	 * set trace.wmapInPattern := when_mapInPattern;
	 * set trace.wmapMatchedRule := when_mapMatchedRule;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 * set w.predicate := p;
	 *
	 */
	protected boolean MAP_mmapInPattern__filter__qvtr__residue__(final /*@NonInvalid*/ @NonNull TmapInPattern_filter trace_44)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapInPattern__filter__qvtr__residue__" +
					"\n\t\"trace\":" + toDebugString(trace_44));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull InPattern t1atlPattern = trace_44.getT1atlPattern();
		final /*@NonInvalid*/ @Nullable TmapInPattern TmapInPattern = OPPOSITE_OF_TmapInPattern_t1atlPattern.get(t1atlPattern);
		final /*@NonInvalid*/ boolean symbol_0 = TmapInPattern != null;
		/*@Thrown*/ @Nullable Boolean raw_when_mapInPattern;
		if (symbol_0) {
			if (TmapInPattern == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean success = TmapInPattern.getSuccess();
			if (success == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_21;
			if (success) {
				final /*@NonInvalid*/ @Nullable OclExpression filter = t1atlPattern.getFilter();
				final /*@NonInvalid*/ boolean symbol_1 = filter != null;
				/*@Thrown*/ @Nullable Boolean raw_atlExpression;
				if (symbol_1) {
					if (filter == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(filter);
					final /*@Thrown*/ boolean symbol_2 = DmapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
					if (symbol_2) {
						if (DmapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean success_0 = DmapOclExpression.getSuccess();
						if (success_0 == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_20;
						if (success_0) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull MatchedRule rule = t1atlPattern.getRule();
							final /*@NonInvalid*/ @Nullable TmapMatchedRule TmapMatchedRule = OPPOSITE_OF_TmapMatchedRule_t1matchedRule.get(rule);
							final /*@NonInvalid*/ boolean symbol_3 = TmapMatchedRule != null;
							/*@Thrown*/ @Nullable Boolean raw_when_mapMatchedRule;
							if (symbol_3) {
								if (TmapMatchedRule == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								final /*@Thrown*/ @Nullable Boolean success_1 = TmapMatchedRule.getSuccess();
								if (success_1 == null) {
									throw new InvalidEvaluationException("Null if condition");
								}
								/*@Thrown*/ @Nullable Boolean symbol_19;
								if (success_1) {
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull RelationDomain t2qvtrDomain = TmapInPattern.getT2qvtrDomain();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = DmapOclExpression.getD2qvtrExpression();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull Relation t2qvtrRelation = TmapMatchedRule.getT2qvtrRelation();
									// creations
									final @NonNull Predicate p = QVTbaseFactory.eINSTANCE.createPredicate();
									models[1/*qvtr*/].add(p, false);
									if (debugCreations) {
										AbstractTransformer.CREATIONS.println("created " + toDebugString(p));
									}
									final @NonNull Pattern w = QVTbaseFactory.eINSTANCE.createPattern();
									models[1/*qvtr*/].add(w, false);
									if (debugCreations) {
										AbstractTransformer.CREATIONS.println("created " + toDebugString(w));
									}
									// mapping statements
									t2qvtrDomain.setRule(t2qvtrRelation);
									t2qvtrRelation.setWhen(w);
									p.setConditionExpression(d2qvtrExpression);
									trace_44.setT1atlExpression(filter);
									trace_44.setT1atlRule(rule);
									trace_44.setT2p(p);
									trace_44.setT2qvtrDomain(t2qvtrDomain);
									trace_44.setT2qvtrExpression(d2qvtrExpression);
									trace_44.setT2qvtrRelation(t2qvtrRelation);
									trace_44.setT2w(w);
									trace_44.setWmapInPattern(TmapInPattern);
									trace_44.setWmapMatchedRule(TmapMatchedRule);
									trace_44.setWmapOclExpression(DmapOclExpression);
									w.getPredicate().add(p);
									final /*@Thrown*/ @Nullable Boolean mmapInPattern__filter__qvtr__residue__ = ValueUtil.TRUE_VALUE;
									symbol_19 = mmapInPattern__filter__qvtr__residue__;
								}
								else {
									symbol_19 = ValueUtil.FALSE_VALUE;
								}
								raw_when_mapMatchedRule = symbol_19;
							}
							else {
								raw_when_mapMatchedRule = ValueUtil.FALSE_VALUE;
							}
							symbol_20 = raw_when_mapMatchedRule;
						}
						else {
							symbol_20 = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapOclExpression = symbol_20;
					}
					else {
						raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
					}
					raw_atlExpression = raw_when_mapOclExpression;
				}
				else {
					raw_atlExpression = ValueUtil.FALSE_VALUE;
				}
				symbol_21 = raw_atlExpression;
			}
			else {
				symbol_21 = ValueUtil.FALSE_VALUE;
			}
			raw_when_mapInPattern = symbol_21;
		}
		else {
			raw_when_mapInPattern = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_mapInPattern ? "done "  : "fail ") + "MAP_mmapInPattern__filter__qvtr__residue__");
		}
		return raw_when_mapInPattern;
	}

	/**
	 *
	 * map mmapHelper__Operation__qvtr__edge5__queryExpression in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * check trace = dispatcher.domapHelper_Operation;
	 * var qvtrFunction : qvtbase::Function[1] := dispatcher.d2qvtrFunction;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrExpression : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * set trace.t2qvtrExpression := qvtrExpression;
	 * set qvtrFunction.queryExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_mmapHelper__Operation__qvtr__edge5__queryExpression(final /*@NonInvalid*/ @NonNull TmapHelper_Operation trace_45)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapHelper__Operation__qvtr__edge5__queryExpression" +
					"\n\t\"trace\":" + toDebugString(trace_45) +
					"\n\t\"dispatcher\":" + toDebugString(trace_45.getDispatcher()) +
					"\n\t\"dispatcher.d1atlHelper\":" + toDebugString(trace_45.getDispatcher().getD1atlHelper()) +
					"\n\t\"dispatcher.d2qvtrFunction\":" + toDebugString(trace_45.getDispatcher().getD2qvtrFunction()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_45.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapHelper_Operation domapHelper_Operation = dispatcher_0.getDomapHelper_Operation();
		final /*@NonInvalid*/ boolean eq = trace_45.equals(domapHelper_Operation);
		/*@Thrown*/ @Nullable Boolean symbol_6;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Function d2qvtrFunction = dispatcher_0.getD2qvtrFunction();
			final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_45.getLocalSuccess();
			if (localSuccess == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (localSuccess) {
				final /*@NonInvalid*/ @Nullable Boolean success = trace_45.getSuccess();
				if (success == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_4;
				if (success) {
					final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_45.getWmapOclExpression();
					final /*@NonInvalid*/ boolean symbol_0 = wmapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
					if (symbol_0) {
						if (wmapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
						// mapping statements
						trace_45.setT2qvtrExpression(d2qvtrExpression);
						d2qvtrFunction.setQueryExpression(d2qvtrExpression);
						final /*@Thrown*/ @Nullable Boolean mmapHelper__Operation__qvtr__edge5__queryExpression = ValueUtil.TRUE_VALUE;
						raw_when_mapOclExpression = mmapHelper__Operation__qvtr__edge5__queryExpression;
					}
					else {
						raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
					}
					symbol_4 = raw_when_mapOclExpression;
				}
				else {
					symbol_4 = ValueUtil.FALSE_VALUE;
				}
				symbol_5 = symbol_4;
			}
			else {
				symbol_5 = ValueUtil.FALSE_VALUE;
			}
			symbol_6 = symbol_5;
		}
		else {
			symbol_6 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_6 ? "done "  : "fail ") + "MAP_mmapHelper__Operation__qvtr__edge5__queryExpression");
		}
		return symbol_6;
	}

	/**
	 *
	 * map mmapOperationCallExp__Helper__qvtr__edge7__ownedArg in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperationCallExp_Helper;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrSourceArgument : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * set trace.t2qvtrSourceArgument := qvtrSourceArgument;
	 * set qvtrExpression.ownedArguments := qvtrSourceArgument;
	 *
	 */
	protected boolean MAP_mmapOperationCallExp__Helper__qvtr__edge7__ownedArg(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_46)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperationCallExp__Helper__qvtr__edge7__ownedArg" +
					"\n\t\"trace\":" + toDebugString(trace_46) +
					"\n\t\"dispatcher\":" + toDebugString(trace_46.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_46.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_46.getDispatcher().getD2qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_46.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Helper domapOperationCallExp_Helper = dispatcher_0.getDomapOperationCallExp_Helper();
		final /*@NonInvalid*/ boolean eq = trace_46.equals(domapOperationCallExp_Helper);
		/*@Thrown*/ @Nullable Boolean symbol_9;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_8;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_46.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_7;
				if (localSuccess) {
					final /*@NonInvalid*/ @Nullable Boolean success = trace_46.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_6;
					if (success) {
						final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_46.getWmapOclExpression();
						final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
						/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
						if (symbol_2) {
							if (wmapOclExpression == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
							// mapping statements
							trace_46.setT2qvtrSourceArgument(d2qvtrExpression);
							symbol_1.getOwnedArguments().add(d2qvtrExpression);
							final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Helper__qvtr__edge7__ownedArg = ValueUtil.TRUE_VALUE;
							raw_when_mapOclExpression = mmapOperationCallExp__Helper__qvtr__edge7__ownedArg;
						}
						else {
							raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
						}
						symbol_6 = raw_when_mapOclExpression;
					}
					else {
						symbol_6 = ValueUtil.FALSE_VALUE;
					}
					symbol_7 = symbol_6;
				}
				else {
					symbol_7 = ValueUtil.FALSE_VALUE;
				}
				symbol_8 = symbol_7;
			}
			else {
				symbol_8 = ValueUtil.FALSE_VALUE;
			}
			symbol_9 = symbol_8;
		}
		else {
			symbol_9 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_9 ? "done "  : "fail ") + "MAP_mmapOperationCallExp__Helper__qvtr__edge7__ownedArg");
		}
		return symbol_9;
	}

	/**
	 *
	 * map mmapOperationCallExp__Operation__qvtr__edge4__owned in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperationCallExp_Operation;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrSource : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * set trace.t2qvtrSource := qvtrSource;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 *
	 */
	protected boolean MAP_mmapOperationCallExp__Operation__qvtr__edge4__owned(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace_47)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperationCallExp__Operation__qvtr__edge4__owned" +
					"\n\t\"trace\":" + toDebugString(trace_47) +
					"\n\t\"dispatcher\":" + toDebugString(trace_47.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_47.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_47.getDispatcher().getD2qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_47.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Operation domapOperationCallExp_Operation = dispatcher_0.getDomapOperationCallExp_Operation();
		final /*@NonInvalid*/ boolean eq = trace_47.equals(domapOperationCallExp_Operation);
		/*@Thrown*/ @Nullable Boolean symbol_9;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_8;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_47.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_7;
				if (localSuccess) {
					final /*@NonInvalid*/ @Nullable Boolean success = trace_47.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_6;
					if (success) {
						final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_47.getWmapOclExpression();
						final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
						/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
						if (symbol_2) {
							if (wmapOclExpression == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
							// mapping statements
							trace_47.setT2qvtrSource(d2qvtrExpression);
							symbol_1.setOwnedSource(d2qvtrExpression);
							final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Operation__qvtr__edge4__owned = ValueUtil.TRUE_VALUE;
							raw_when_mapOclExpression = mmapOperationCallExp__Operation__qvtr__edge4__owned;
						}
						else {
							raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
						}
						symbol_6 = raw_when_mapOclExpression;
					}
					else {
						symbol_6 = ValueUtil.FALSE_VALUE;
					}
					symbol_7 = symbol_6;
				}
				else {
					symbol_7 = ValueUtil.FALSE_VALUE;
				}
				symbol_8 = symbol_7;
			}
			else {
				symbol_8 = ValueUtil.FALSE_VALUE;
			}
			symbol_9 = symbol_8;
		}
		else {
			symbol_9 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_9 ? "done "  : "fail ") + "MAP_mmapOperationCallExp__Operation__qvtr__edge4__owned");
		}
		return symbol_9;
	}

	/**
	 *
	 * map mmapOperationCallExp__Helper__qvtr__edge4__referred in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * check trace.localSuccess;
	 * check trace.success;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := trace.wmapModule;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t2qvtrTransformation;
	 * var ownedContext : Variable[?] := qvtrTransformation.ownedContext;
	 * check var ownedContext1 : VariableDeclaration[?] := ownedContext;
	 * check ownedContext1 =
	 *   ownedContext.oclAsType(VariableDeclaration);
	 * var qvtrSource : VariableExp[1] := trace.t2qvtrSource;
	 * set trace.t2qvtrTransformation := qvtrTransformation;
	 * set qvtrSource.referredVariable := ownedContext1;
	 *
	 */
	protected boolean MAP_mmapOperationCallExp__Helper__qvtr__edge4__referred(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_48)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperationCallExp__Helper__qvtr__edge4__referred" +
					"\n\t\"trace\":" + toDebugString(trace_48) +
					"\n\t\"dispatcher\":" + toDebugString(trace_48.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_48.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_48.getDispatcher().getD2qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_48.getLocalSuccess();
		if (localSuccess == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_9;
		if (localSuccess) {
			final /*@NonInvalid*/ @Nullable Boolean success = trace_48.getSuccess();
			if (success == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_8;
			if (success) {
				final /*@NonInvalid*/ @Nullable TmapModule wmapModule = trace_48.getWmapModule();
				final /*@NonInvalid*/ boolean symbol_0 = wmapModule != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
				if (symbol_0) {
					if (wmapModule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull RelationalTransformation t2qvtrTransformation = wmapModule.getT2qvtrTransformation();
					final /*@Thrown*/org.eclipse.ocl.pivot.VariableDeclaration ownedContext = t2qvtrTransformation.getOwnedContext();
					final /*@NonInvalid*/ boolean symbol_1 = ownedContext instanceof org.eclipse.ocl.pivot.VariableDeclaration;
					/*@Thrown*/ @Nullable Boolean symbol_7;
					if (symbol_1) {
						final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable VariableDeclaration symbol_2 = ownedContext;
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_VariableDeclaration_0 = idResolver.getClass(CLSSid_VariableDeclaration_0, null);
						@SuppressWarnings("null")
						final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull VariableDeclaration oclAsType = (org.eclipse.ocl.pivot.@NonNull VariableDeclaration)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ownedContext, TYP_VariableDeclaration_0);
						final /*@Thrown*/ boolean eq = oclAsType.equals(symbol_2);
						/*@Thrown*/ @Nullable Boolean symbol_6;
						if (eq) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp t2qvtrSource = trace_48.getT2qvtrSource();
							// mapping statements
							trace_48.setT2qvtrTransformation(t2qvtrTransformation);
							t2qvtrSource.setReferredVariable(symbol_2);
							final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Helper__qvtr__edge4__referred = ValueUtil.TRUE_VALUE;
							symbol_6 = mmapOperationCallExp__Helper__qvtr__edge4__referred;
						}
						else {
							symbol_6 = ValueUtil.FALSE_VALUE;
						}
						symbol_7 = symbol_6;
					}
					else {
						symbol_7 = ValueUtil.FALSE_VALUE;
					}
					raw_when_mapModule = symbol_7;
				}
				else {
					raw_when_mapModule = ValueUtil.FALSE_VALUE;
				}
				symbol_8 = raw_when_mapModule;
			}
			else {
				symbol_8 = ValueUtil.FALSE_VALUE;
			}
			symbol_9 = symbol_8;
		}
		else {
			symbol_9 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_9 ? "done "  : "fail ") + "MAP_mmapOperationCallExp__Helper__qvtr__edge4__referred");
		}
		return symbol_9;
	}

	/**
	 *
	 * map mmapOperatorCallExp__qvtr__edge4__ownedSource__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapOperatorCallExp;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrSource : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * set trace.t2qvtrSource := qvtrSource;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 *
	 */
	protected boolean MAP_mmapOperatorCallExp__qvtr__edge4__ownedSource__(final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace_49)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperatorCallExp__qvtr__edge4__ownedSource__" +
					"\n\t\"trace\":" + toDebugString(trace_49) +
					"\n\t\"dispatcher\":" + toDebugString(trace_49.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_49.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_49.getDispatcher().getD2qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_49.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher_0.getDomapOperatorCallExp();
		final /*@NonInvalid*/ boolean eq = trace_49.equals(domapOperatorCallExp);
		/*@Thrown*/ @Nullable Boolean symbol_9;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_8;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_49.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_7;
				if (localSuccess) {
					final /*@NonInvalid*/ @Nullable Boolean success = trace_49.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_6;
					if (success) {
						final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_49.getWmapOclExpression();
						final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
						/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
						if (symbol_2) {
							if (wmapOclExpression == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
							// mapping statements
							trace_49.setT2qvtrSource(d2qvtrExpression);
							symbol_1.setOwnedSource(d2qvtrExpression);
							final /*@Thrown*/ @Nullable Boolean mmapOperatorCallExp__qvtr__edge4__ownedSource__ = ValueUtil.TRUE_VALUE;
							raw_when_mapOclExpression = mmapOperatorCallExp__qvtr__edge4__ownedSource__;
						}
						else {
							raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
						}
						symbol_6 = raw_when_mapOclExpression;
					}
					else {
						symbol_6 = ValueUtil.FALSE_VALUE;
					}
					symbol_7 = symbol_6;
				}
				else {
					symbol_7 = ValueUtil.FALSE_VALUE;
				}
				symbol_8 = symbol_7;
			}
			else {
				symbol_8 = ValueUtil.FALSE_VALUE;
			}
			symbol_9 = symbol_8;
		}
		else {
			symbol_9 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_9 ? "done "  : "fail ") + "MAP_mmapOperatorCallExp__qvtr__edge4__ownedSource__");
		}
		return symbol_9;
	}

	/**
	 *
	 * map mmapVariable__qvtr in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariable[1] success success;
	 * var atlVariable : ATL::LocatedElement[1] := trace.t1atlVariable;
	 * var qvtrVariable : VariableDeclaration[1] := trace.t2qvtrVariable;
	 *
	 */
	protected boolean MAP_mmapVariable__qvtr(final /*@NonInvalid*/ @NonNull TmapVariable trace_50)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariable__qvtr" +
					"\n\t\"trace\":" + toDebugString(trace_50));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull LocatedElement t1atlVariable = trace_50.getT1atlVariable();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableDeclaration t2qvtrVariable = trace_50.getT2qvtrVariable();
		// mapping statements
		final /*@Thrown*/ @Nullable Boolean mmapVariable__qvtr = ValueUtil.TRUE_VALUE;
		trace_50.setSuccess(mmapVariable__qvtr);
		objectManager.assigned(trace_50, trace_ATL2QVTrPackage.Literals.TMAP_VARIABLE__SUCCESS, mmapVariable__qvtr);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mmapVariable__qvtr ? "done "  : "fail ") + "MAP_mmapVariable__qvtr");
		}
		return mmapVariable__qvtr;
	}

	/**
	 *
	 * map mmapHelper__Attribute__qvtr__edge5__queryExpression in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * check trace = dispatcher.domapHelper_Attribute;
	 * var qvtrFunction : qvtbase::Function[1] := dispatcher.d2qvtrFunction;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrExpression : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * set trace.t2qvtrExpression := qvtrExpression;
	 * set qvtrFunction.queryExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_mmapHelper__Attribute__qvtr__edge5__queryExpression(final /*@NonInvalid*/ @NonNull TmapHelper_Attribute trace_51)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapHelper__Attribute__qvtr__edge5__queryExpression" +
					"\n\t\"trace\":" + toDebugString(trace_51) +
					"\n\t\"dispatcher\":" + toDebugString(trace_51.getDispatcher()) +
					"\n\t\"dispatcher.d1atlHelper\":" + toDebugString(trace_51.getDispatcher().getD1atlHelper()) +
					"\n\t\"dispatcher.d2qvtrFunction\":" + toDebugString(trace_51.getDispatcher().getD2qvtrFunction()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_51.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapHelper_Attribute domapHelper_Attribute = dispatcher_0.getDomapHelper_Attribute();
		final /*@NonInvalid*/ boolean eq = trace_51.equals(domapHelper_Attribute);
		/*@Thrown*/ @Nullable Boolean symbol_6;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Function d2qvtrFunction = dispatcher_0.getD2qvtrFunction();
			final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_51.getLocalSuccess();
			if (localSuccess == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (localSuccess) {
				final /*@NonInvalid*/ @Nullable Boolean success = trace_51.getSuccess();
				if (success == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_4;
				if (success) {
					final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_51.getWmapOclExpression();
					final /*@NonInvalid*/ boolean symbol_0 = wmapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
					if (symbol_0) {
						if (wmapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
						// mapping statements
						trace_51.setT2qvtrExpression(d2qvtrExpression);
						d2qvtrFunction.setQueryExpression(d2qvtrExpression);
						final /*@Thrown*/ @Nullable Boolean mmapHelper__Attribute__qvtr__edge5__queryExpression = ValueUtil.TRUE_VALUE;
						raw_when_mapOclExpression = mmapHelper__Attribute__qvtr__edge5__queryExpression;
					}
					else {
						raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
					}
					symbol_4 = raw_when_mapOclExpression;
				}
				else {
					symbol_4 = ValueUtil.FALSE_VALUE;
				}
				symbol_5 = symbol_4;
			}
			else {
				symbol_5 = ValueUtil.FALSE_VALUE;
			}
			symbol_6 = symbol_5;
		}
		else {
			symbol_6 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_6 ? "done "  : "fail ") + "MAP_mmapHelper__Attribute__qvtr__edge5__queryExpression");
		}
		return symbol_6;
	}

	/**
	 *
	 * map mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_2 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapNavigationOrAttributeCallExp_Helper;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrSourceArgument : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * set trace.t2qvtrSourceArgument := qvtrSourceArgument;
	 * set qvtrExpression.ownedArguments := qvtrSourceArgument;
	 *
	 */
	protected boolean MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_2(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_52)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_2" +
					"\n\t\"trace\":" + toDebugString(trace_52) +
					"\n\t\"dispatcher\":" + toDebugString(trace_52.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_52.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_52.getDispatcher().getD2qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_52.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Helper domapNavigationOrAttributeCallExp_Helper = dispatcher_0.getDomapNavigationOrAttributeCallExp_Helper();
		final /*@NonInvalid*/ boolean eq = trace_52.equals(domapNavigationOrAttributeCallExp_Helper);
		/*@Thrown*/ @Nullable Boolean symbol_9;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_8;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_52.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_7;
				if (localSuccess) {
					final /*@NonInvalid*/ @Nullable Boolean success = trace_52.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_6;
					if (success) {
						final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_52.getWmapOclExpression();
						final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
						/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
						if (symbol_2) {
							if (wmapOclExpression == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
							// mapping statements
							trace_52.setT2qvtrSourceArgument(d2qvtrExpression);
							symbol_1.getOwnedArguments().add(d2qvtrExpression);
							final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_2 = ValueUtil.TRUE_VALUE;
							raw_when_mapOclExpression = mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_2;
						}
						else {
							raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
						}
						symbol_6 = raw_when_mapOclExpression;
					}
					else {
						symbol_6 = ValueUtil.FALSE_VALUE;
					}
					symbol_7 = symbol_6;
				}
				else {
					symbol_7 = ValueUtil.FALSE_VALUE;
				}
				symbol_8 = symbol_7;
			}
			else {
				symbol_8 = ValueUtil.FALSE_VALUE;
			}
			symbol_9 = symbol_8;
		}
		else {
			symbol_9 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_9 ? "done "  : "fail ") + "MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_2");
		}
		return symbol_9;
	}

	/**
	 *
	 * map mmapIfExp__qvtr__edge5__ownedThen__edge4__ownedCond in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapIfExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapIfExp;
	 * check var qvtrExpression : IfExp[1] := dispatcher.d2qvtrExpression;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var when_mapOclExpression1 : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression1;
	 * var when_mapOclExpression2 : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression2;
	 * var qvtrCondition : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * var qvtrElse : OCLExpression[1] := when_mapOclExpression2.d2qvtrExpression;
	 * var qvtrThen : OCLExpression[1] := when_mapOclExpression1.d2qvtrExpression;
	 * set trace.t2qvtrCondition := qvtrCondition;
	 * set trace.t2qvtrElse := qvtrElse;
	 * set trace.t2qvtrThen := qvtrThen;
	 * set qvtrExpression.ownedCondition := qvtrCondition;
	 * set qvtrExpression.ownedElse := qvtrElse;
	 * set qvtrExpression.ownedThen := qvtrThen;
	 *
	 */
	protected boolean MAP_mmapIfExp__qvtr__edge5__ownedThen__edge4__ownedCond(final /*@NonInvalid*/ @NonNull TmapIfExp trace_53)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapIfExp__qvtr__edge5__ownedThen__edge4__ownedCond" +
					"\n\t\"trace\":" + toDebugString(trace_53) +
					"\n\t\"dispatcher\":" + toDebugString(trace_53.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_53.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_53.getDispatcher().getD2qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_53.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapIfExp domapIfExp = dispatcher_0.getDomapIfExp();
		final /*@NonInvalid*/ boolean eq = trace_53.equals(domapIfExp);
		/*@Thrown*/ @Nullable Boolean symbol_15;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.IfExp;
			/*@Thrown*/ @Nullable Boolean symbol_14;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull IfExp symbol_1 = (org.eclipse.ocl.pivot.IfExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_53.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_13;
				if (localSuccess) {
					final /*@NonInvalid*/ @Nullable Boolean success = trace_53.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_12;
					if (success) {
						final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_53.getWmapOclExpression();
						final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
						/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
						if (symbol_2) {
							if (wmapOclExpression == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression1 = trace_53.getWmapOclExpression1();
							final /*@NonInvalid*/ boolean symbol_3 = wmapOclExpression1 != null;
							/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression1;
							if (symbol_3) {
								if (wmapOclExpression1 == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression2 = trace_53.getWmapOclExpression2();
								final /*@NonInvalid*/ boolean symbol_4 = wmapOclExpression2 != null;
								/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression2;
								if (symbol_4) {
									if (wmapOclExpression2 == null) {
										throw new InvalidEvaluationException("Null where non-null value required");
									}
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression_0 = wmapOclExpression2.getD2qvtrExpression();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression_1 = wmapOclExpression1.getD2qvtrExpression();
									// mapping statements
									trace_53.setT2qvtrCondition(d2qvtrExpression);
									trace_53.setT2qvtrElse(d2qvtrExpression_0);
									trace_53.setT2qvtrThen(d2qvtrExpression_1);
									symbol_1.setOwnedCondition(d2qvtrExpression);
									symbol_1.setOwnedElse(d2qvtrExpression_0);
									symbol_1.setOwnedThen(d2qvtrExpression_1);
									final /*@Thrown*/ @Nullable Boolean mmapIfExp__qvtr__edge5__ownedThen__edge4__ownedCond = ValueUtil.TRUE_VALUE;
									raw_when_mapOclExpression2 = mmapIfExp__qvtr__edge5__ownedThen__edge4__ownedCond;
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
						symbol_12 = raw_when_mapOclExpression;
					}
					else {
						symbol_12 = ValueUtil.FALSE_VALUE;
					}
					symbol_13 = symbol_12;
				}
				else {
					symbol_13 = ValueUtil.FALSE_VALUE;
				}
				symbol_14 = symbol_13;
			}
			else {
				symbol_14 = ValueUtil.FALSE_VALUE;
			}
			symbol_15 = symbol_14;
		}
		else {
			symbol_15 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_15 ? "done "  : "fail ") + "MAP_mmapIfExp__qvtr__edge5__ownedThen__edge4__ownedCond");
		}
		return symbol_15;
	}

	/**
	 *
	 * map mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_3 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * check trace.localSuccess;
	 * check trace.success;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := trace.wmapModule;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t2qvtrTransformation;
	 * var ownedContext : Variable[?] := qvtrTransformation.ownedContext;
	 * check var ownedContext1 : VariableDeclaration[?] := ownedContext;
	 * check ownedContext1 =
	 *   ownedContext.oclAsType(VariableDeclaration);
	 * var qvtrSource : VariableExp[1] := trace.t2qvtrSource;
	 * set trace.t2qvtrTransformation := qvtrTransformation;
	 * set qvtrSource.referredVariable := ownedContext1;
	 *
	 */
	protected boolean MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_3(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_54)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_3" +
					"\n\t\"trace\":" + toDebugString(trace_54) +
					"\n\t\"dispatcher\":" + toDebugString(trace_54.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_54.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_54.getDispatcher().getD2qvtrExpression()));
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_54.getLocalSuccess();
		if (localSuccess == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_9;
		if (localSuccess) {
			final /*@NonInvalid*/ @Nullable Boolean success = trace_54.getSuccess();
			if (success == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_8;
			if (success) {
				final /*@NonInvalid*/ @Nullable TmapModule wmapModule = trace_54.getWmapModule();
				final /*@NonInvalid*/ boolean symbol_0 = wmapModule != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
				if (symbol_0) {
					if (wmapModule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull RelationalTransformation t2qvtrTransformation = wmapModule.getT2qvtrTransformation();
					final /*@Thrown*/ org.eclipse.ocl.pivot.VariableDeclaration ownedContext = t2qvtrTransformation.getOwnedContext();
					final /*@NonInvalid*/ boolean symbol_1 = ownedContext instanceof org.eclipse.ocl.pivot.VariableDeclaration;
					/*@Thrown*/ @Nullable Boolean symbol_7;
					if (symbol_1) {
						final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable VariableDeclaration symbol_2 = ownedContext;
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_VariableDeclaration_0 = idResolver.getClass(CLSSid_VariableDeclaration_0, null);
						@SuppressWarnings("null")
						final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull VariableDeclaration oclAsType = (org.eclipse.ocl.pivot.@NonNull VariableDeclaration)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ownedContext, TYP_VariableDeclaration_0);
						final /*@Thrown*/ boolean eq = oclAsType.equals(symbol_2);
						/*@Thrown*/ @Nullable Boolean symbol_6;
						if (eq) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp t2qvtrSource = trace_54.getT2qvtrSource();
							// mapping statements
							trace_54.setT2qvtrTransformation(t2qvtrTransformation);
							t2qvtrSource.setReferredVariable(symbol_2);
							final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_3 = ValueUtil.TRUE_VALUE;
							symbol_6 = mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_3;
						}
						else {
							symbol_6 = ValueUtil.FALSE_VALUE;
						}
						symbol_7 = symbol_6;
					}
					else {
						symbol_7 = ValueUtil.FALSE_VALUE;
					}
					raw_when_mapModule = symbol_7;
				}
				else {
					raw_when_mapModule = ValueUtil.FALSE_VALUE;
				}
				symbol_8 = raw_when_mapModule;
			}
			else {
				symbol_8 = ValueUtil.FALSE_VALUE;
			}
			symbol_9 = symbol_8;
		}
		else {
			symbol_9 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_9 ? "done "  : "fail ") + "MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_3");
		}
		return symbol_9;
	}

	/**
	 *
	 * map mmapOperationCallExp__argument__qvtr__residue__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_argument[1];
	 * var atlArgument : OCL::OclExpression[1] := trace.t1atlArgument;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlArgument.DmapOclExpression;
	 * check when_mapOclExpression.success;
	 * var atlParent : OCL::OperationCallExp[1] := atlArgument.parentOperation;
	 * var when_mapOperationCallExp : trace_ATL2QVTr::DmapOclExpression[1] := atlParent.DmapOclExpression;
	 * check when_mapOperationCallExp.success;
	 * check var qvtrParent : OperationCallExp[1] := when_mapOperationCallExp.d2qvtrExpression;
	 * var qvtrArgument : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * set qvtrParent.ownedArguments := qvtrArgument;
	 * set trace.t1atlParent := atlParent;
	 * set trace.t2qvtrArgument := qvtrArgument;
	 * set trace.t2qvtrParent := qvtrParent;
	 * set trace.wmapOclExpression1 := when_mapOclExpression;
	 * set trace.wmapOclExpression := when_mapOperationCallExp;
	 *
	 */
	protected boolean MAP_mmapOperationCallExp__argument__qvtr__residue__(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_argument trace_55)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperationCallExp__argument__qvtr__residue__" +
					"\n\t\"trace\":" + toDebugString(trace_55));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression t1atlArgument = trace_55.getT1atlArgument();
		final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(t1atlArgument);
		final /*@NonInvalid*/ boolean symbol_0 = DmapOclExpression != null;
		/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
		if (symbol_0) {
			if (DmapOclExpression == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean success = DmapOclExpression.getSuccess();
			if (success == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_14;
			if (success) {
				final /*@NonInvalid*/ @Nullable OperationCallExp parentOperation = t1atlArgument.getParentOperation();
				final /*@NonInvalid*/ boolean symbol_1 = parentOperation != null;
				/*@Thrown*/ @Nullable Boolean raw_atlParent;
				if (symbol_1) {
					if (parentOperation == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable DmapOclExpression DmapOclExpression_0 = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(parentOperation);
					final /*@Thrown*/ boolean symbol_2 = DmapOclExpression_0 != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOperationCallExp;
					if (symbol_2) {
						if (DmapOclExpression_0 == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean success_0 = DmapOclExpression_0.getSuccess();
						if (success_0 == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_13;
						if (success_0) {
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull OCLExpression temp1_qvtrParent = DmapOclExpression_0.getD2qvtrExpression();
							final /*@NonInvalid*/ boolean symbol_3 = temp1_qvtrParent instanceof org.eclipse.ocl.pivot.OperationCallExp;
							/*@Thrown*/ @Nullable Boolean symbol_12;
							if (symbol_3) {
								final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_4 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrParent;
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = DmapOclExpression.getD2qvtrExpression();
								// mapping statements
								symbol_4.getOwnedArguments().add(d2qvtrExpression);
								trace_55.setT1atlParent(parentOperation);
								trace_55.setT2qvtrArgument(d2qvtrExpression);
								trace_55.setT2qvtrParent(symbol_4);
								trace_55.setWmapOclExpression1(DmapOclExpression);
								trace_55.setWmapOclExpression(DmapOclExpression_0);
								final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__argument__qvtr__residue__ = ValueUtil.TRUE_VALUE;
								symbol_12 = mmapOperationCallExp__argument__qvtr__residue__;
							}
							else {
								symbol_12 = ValueUtil.FALSE_VALUE;
							}
							symbol_13 = symbol_12;
						}
						else {
							symbol_13 = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapOperationCallExp = symbol_13;
					}
					else {
						raw_when_mapOperationCallExp = ValueUtil.FALSE_VALUE;
					}
					raw_atlParent = raw_when_mapOperationCallExp;
				}
				else {
					raw_atlParent = ValueUtil.FALSE_VALUE;
				}
				symbol_14 = raw_atlParent;
			}
			else {
				symbol_14 = ValueUtil.FALSE_VALUE;
			}
			raw_when_mapOclExpression = symbol_14;
		}
		else {
			raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_mapOclExpression ? "done "  : "fail ") + "MAP_mmapOperationCallExp__argument__qvtr__residue__");
		}
		return raw_when_mapOclExpression;
	}

	/**
	 *
	 * map mmapBinding__qvtr__residue__ in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapBinding[1];
	 * var atlBinding : ATL::Binding[1] := trace.t1atlBinding;
	 * check var atlOutPatternElement : ATL::SimpleOutPatternElement[1] := atlBinding.outPatternElement;
	 * var atlExpression : OCL::OclExpression[1] := atlBinding.value;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlExpression.DmapOclExpression;
	 * check when_mapOclExpression.success;
	 * var when_mapSimpleOutPatternElement : trace_ATL2QVTr::TmapSimpleOutPatternElement[1] := atlOutPatternElement.TmapSimpleOutPatternElement;
	 * check when_mapSimpleOutPatternElement.success;
	 * var propertyName : String[1] := atlBinding.propertyName;
	 * var qvtrExpression : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * var qvtrTemplate : qvttemplate::ObjectTemplateExp[1] := when_mapSimpleOutPatternElement.t2qvtrTemplate;
	 * var type : Type[?] := qvtrTemplate.type;
	 * var getProperty1 : Property[1] := this.getProperty(type, propertyName);
	 * new:qvtr qvtrPart : qvttemplate::PropertyTemplateItem[1];
	 * set trace.t0propertyName := propertyName;
	 * set qvtrPart.objContainer := qvtrTemplate;
	 * set qvtrPart.referredProperty := getProperty1;
	 * set qvtrPart.value := qvtrExpression;
	 * set trace.t1atlExpression := atlExpression;
	 * set trace.t1atlOutPatternElement := atlOutPatternElement;
	 * set trace.t2qvtrExpression := qvtrExpression;
	 * set trace.t2qvtrPart := qvtrPart;
	 * set trace.t2qvtrTemplate := qvtrTemplate;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 * set trace.wmapSimpleOutPatternElement := when_mapSimpleOutPatternElement;
	 *
	 */
	protected boolean MAP_mmapBinding__qvtr__residue__(final /*@NonInvalid*/ @NonNull TmapBinding trace_56)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapBinding__qvtr__residue__" +
					"\n\t\"trace\":" + toDebugString(trace_56));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Binding t1atlBinding = trace_56.getT1atlBinding();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OutPatternElement temp1_atlOutPatternElement = t1atlBinding.getOutPatternElement();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlOutPatternElement instanceof SimpleOutPatternElement;
		/*@Thrown*/ @Nullable Boolean symbol_18;
		if (symbol_0) {
			final /*@NonInvalid*/ @NonNull SimpleOutPatternElement symbol_1 = (SimpleOutPatternElement)temp1_atlOutPatternElement;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression value = t1atlBinding.getValue();
			final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(value);
			final /*@NonInvalid*/ boolean symbol_2 = DmapOclExpression != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
			if (symbol_2) {
				if (DmapOclExpression == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@Thrown*/ @Nullable Boolean success = DmapOclExpression.getSuccess();
				if (success == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_17;
				if (success) {
					final /*@NonInvalid*/ @Nullable TmapSimpleOutPatternElement TmapSimpleOutPatternElement = OPPOSITE_OF_TmapSimpleOutPatternElement_t1atlElement.get(symbol_1);
					final /*@NonInvalid*/ boolean symbol_3 = TmapSimpleOutPatternElement != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapSimpleOutPatternElement;
					if (symbol_3) {
						if (TmapSimpleOutPatternElement == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean success_0 = TmapSimpleOutPatternElement.getSuccess();
						if (success_0 == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_16;
						if (success_0) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String propertyName = t1atlBinding.getPropertyName();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = DmapOclExpression.getD2qvtrExpression();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull ObjectTemplateExp t2qvtrTemplate = TmapSimpleOutPatternElement.getT2qvtrTemplate();
							final /*@Thrown*/ @Nullable Type type_2 = t2qvtrTemplate.getType();
							final /*@Thrown*/ @NonNull Property getProperty = ((FUN_getProperty)FTOR_getProperty.getUniqueComputation(this, type_2, propertyName)).instance;
							// creations
							final @NonNull PropertyTemplateItem qvtrPart = QVTtemplateFactory.eINSTANCE.createPropertyTemplateItem();
							models[1/*qvtr*/].add(qvtrPart, false);
							if (debugCreations) {
								AbstractTransformer.CREATIONS.println("created " + toDebugString(qvtrPart));
							}
							// mapping statements
							trace_56.setT0propertyName(propertyName);
							qvtrPart.setObjContainer(t2qvtrTemplate);
							qvtrPart.setReferredProperty(getProperty);
							qvtrPart.setValue(d2qvtrExpression);
							trace_56.setT1atlExpression(value);
							trace_56.setT1atlOutPatternElement(symbol_1);
							trace_56.setT2qvtrExpression(d2qvtrExpression);
							trace_56.setT2qvtrPart(qvtrPart);
							trace_56.setT2qvtrTemplate(t2qvtrTemplate);
							trace_56.setWmapOclExpression(DmapOclExpression);
							trace_56.setWmapSimpleOutPatternElement(TmapSimpleOutPatternElement);
							final /*@Thrown*/ @Nullable Boolean mmapBinding__qvtr__residue__ = ValueUtil.TRUE_VALUE;
							symbol_16 = mmapBinding__qvtr__residue__;
						}
						else {
							symbol_16 = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapSimpleOutPatternElement = symbol_16;
					}
					else {
						raw_when_mapSimpleOutPatternElement = ValueUtil.FALSE_VALUE;
					}
					symbol_17 = raw_when_mapSimpleOutPatternElement;
				}
				else {
					symbol_17 = ValueUtil.FALSE_VALUE;
				}
				raw_when_mapOclExpression = symbol_17;
			}
			else {
				raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
			}
			symbol_18 = raw_when_mapOclExpression;
		}
		else {
			symbol_18 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_18 ? "done "  : "fail ") + "MAP_mmapBinding__qvtr__residue__");
		}
		return symbol_18;
	}

	/**
	 *
	 * map mmapNavigationOrAttributeCallExp__Property__qvtr__e in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace = dispatcher.domapNavigationOrAttributeCallExp_Property;
	 * check var qvtrExpression : PropertyCallExp[1] := dispatcher.d2qvtrExpression;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrSource : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * set trace.t2qvtrSource := qvtrSource;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 *
	 */
	protected boolean MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__e(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace_57)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__e" +
					"\n\t\"trace\":" + toDebugString(trace_57) +
					"\n\t\"dispatcher\":" + toDebugString(trace_57.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_57.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_57.getDispatcher().getD2qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_57.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Property domapNavigationOrAttributeCallExp_Property = dispatcher_0.getDomapNavigationOrAttributeCallExp_Property();
		final /*@NonInvalid*/ boolean eq = trace_57.equals(domapNavigationOrAttributeCallExp_Property);
		/*@Thrown*/ @Nullable Boolean symbol_9;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof PropertyCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_8;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull PropertyCallExp symbol_1 = (PropertyCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_57.getLocalSuccess();
				if (localSuccess == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_7;
				if (localSuccess) {
					final /*@NonInvalid*/ @Nullable Boolean success = trace_57.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_6;
					if (success) {
						final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_57.getWmapOclExpression();
						final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
						/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
						if (symbol_2) {
							if (wmapOclExpression == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
							// mapping statements
							trace_57.setT2qvtrSource(d2qvtrExpression);
							symbol_1.setOwnedSource(d2qvtrExpression);
							final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Property__qvtr__e = ValueUtil.TRUE_VALUE;
							raw_when_mapOclExpression = mmapNavigationOrAttributeCallExp__Property__qvtr__e;
						}
						else {
							raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
						}
						symbol_6 = raw_when_mapOclExpression;
					}
					else {
						symbol_6 = ValueUtil.FALSE_VALUE;
					}
					symbol_7 = symbol_6;
				}
				else {
					symbol_7 = ValueUtil.FALSE_VALUE;
				}
				symbol_8 = symbol_7;
			}
			else {
				symbol_8 = ValueUtil.FALSE_VALUE;
			}
			symbol_9 = symbol_8;
		}
		else {
			symbol_9 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_9 ? "done "  : "fail ") + "MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__e");
		}
		return symbol_9;
	}

	/**
	 *
	 * map mmapOperationCallExp__Operation__qvtr__edge5__refer in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapOperationCallExp_Operation;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var qvtrSource : OCLExpression[1] := trace.t2qvtrSource;
	 * observe ocl::TypedElement::type var type : Type[?] := qvtrSource.type;
	 * var operationName : String[1] := trace.t0operationName;
	 * var getOperation1 : Operation[1] := this.getOperation(type, operationName);
	 * notify set qvtrExpression.referredOperation := getOperation1;
	 *
	 */
	protected class MAP_mmapOperationCallExp__Operation__qvtr__edge5__refer extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace_58;

		public MAP_mmapOperationCallExp__Operation__qvtr__edge5__refer(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_58 = (@NonNull TmapOperationCallExp_Operation)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_58.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Operation domapOperationCallExp_Operation = dispatcher_0.getDomapOperationCallExp_Operation();
			final /*@NonInvalid*/ boolean eq = trace_58.equals(domapOperationCallExp_Operation);
			/*@Thrown*/ @Nullable Boolean symbol_7;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_6;
				if (symbol_0) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
					final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_58.getLocalSuccess();
					if (localSuccess == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_5;
					if (localSuccess) {
						final /*@NonInvalid*/ @Nullable Boolean success = trace_58.getSuccess();
						if (success == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_4;
						if (success) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OCLExpression t2qvtrSource = trace_58.getT2qvtrSource();
							objectManager.getting(t2qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
							final /*@NonInvalid*/ @Nullable Type type_2 = t2qvtrSource.getType();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String t0operationName = trace_58.getT0operationName();
							final /*@Thrown*/ @NonNull Operation getOperation = ((FUN_getOperation)FTOR_getOperation.getUniqueComputation(ATL2QVTr.this, type_2, t0operationName)).instance;
							// mapping statements
							symbol_1.setReferredOperation(getOperation);
							objectManager.assigned(symbol_1, PivotPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION, getOperation);
							final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Operation__qvtr__edge5__refer = ValueUtil.TRUE_VALUE;
							symbol_4 = mmapOperationCallExp__Operation__qvtr__edge5__refer;
						}
						else {
							symbol_4 = ValueUtil.FALSE_VALUE;
						}
						symbol_5 = symbol_4;
					}
					else {
						symbol_5 = ValueUtil.FALSE_VALUE;
					}
					symbol_6 = symbol_5;
				}
				else {
					symbol_6 = ValueUtil.FALSE_VALUE;
				}
				symbol_7 = symbol_6;
			}
			else {
				symbol_7 = ValueUtil.FALSE_VALUE;
			}
			return symbol_7;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_58, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapOperatorCallExp__qvtr__edge5__referredOperation in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapOperatorCallExp;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var qvtrSource : OCLExpression[1] := trace.t2qvtrSource;
	 * observe ocl::TypedElement::type var type : Type[?] := qvtrSource.type;
	 * var operationName : String[1] := trace.t0operationName;
	 * var qvtrOperation : Operation[1] := this.getOperation(type, operationName);
	 * notify set qvtrExpression.referredOperation := qvtrOperation;
	 *
	 */
	protected class MAP_mmapOperatorCallExp__qvtr__edge5__referredOperation extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace_59;

		public MAP_mmapOperatorCallExp__qvtr__edge5__referredOperation(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_59 = (@NonNull TmapOperatorCallExp)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_59.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher_0.getDomapOperatorCallExp();
			final /*@NonInvalid*/ boolean eq = trace_59.equals(domapOperatorCallExp);
			/*@Thrown*/ @Nullable Boolean symbol_7;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_6;
				if (symbol_0) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
					final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_59.getLocalSuccess();
					if (localSuccess == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_5;
					if (localSuccess) {
						final /*@NonInvalid*/ @Nullable Boolean success = trace_59.getSuccess();
						if (success == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_4;
						if (success) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OCLExpression t2qvtrSource = trace_59.getT2qvtrSource();
							objectManager.getting(t2qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
							final /*@NonInvalid*/ @Nullable Type type_2 = t2qvtrSource.getType();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String t0operationName = trace_59.getT0operationName();
							final /*@Thrown*/ @NonNull Operation getOperation = ((FUN_getOperation)FTOR_getOperation.getUniqueComputation(ATL2QVTr.this, type_2, t0operationName)).instance;
							// mapping statements
							symbol_1.setReferredOperation(getOperation);
							objectManager.assigned(symbol_1, PivotPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION, getOperation);
							final /*@Thrown*/ @Nullable Boolean mmapOperatorCallExp__qvtr__edge5__referredOperation = ValueUtil.TRUE_VALUE;
							symbol_4 = mmapOperatorCallExp__qvtr__edge5__referredOperation;
						}
						else {
							symbol_4 = ValueUtil.FALSE_VALUE;
						}
						symbol_5 = symbol_4;
					}
					else {
						symbol_5 = ValueUtil.FALSE_VALUE;
					}
					symbol_6 = symbol_5;
				}
				else {
					symbol_6 = ValueUtil.FALSE_VALUE;
				}
				symbol_7 = symbol_6;
			}
			else {
				symbol_7 = ValueUtil.FALSE_VALUE;
			}
			return symbol_7;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_59, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapVariableExp__referredVariable__VariableDeclarat in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 * check trace = dispatcher.domapVariableExp_referredVariable_VariableDeclaration;
	 * var atlExpression : OCL::VariableExp[1] := dispatcher.d1atlExpression;
	 * var qvtrExpression : VariableExp[1] := dispatcher.d2qvtrExpression;
	 * check var atlVariable : ATL::PatternElement[1] := atlExpression.referredVariable;
	 * var when_mapVariable : trace_ATL2QVTr::TmapVariable[1] := atlVariable.TmapVariable;
	 * check when_mapVariable.success;
	 * var qvtrVariable : VariableDeclaration[1] := when_mapVariable.t2qvtrVariable;
	 * var name : String[?] := qvtrVariable.name;
	 * var type : Type[?] := qvtrVariable.type;
	 * set qvtrExpression.name := name;
	 * set dispatcher.success := true;
	 * set dispatcher.result := trace;
	 * set qvtrExpression.referredVariable := qvtrVariable;
	 * notify set qvtrExpression.type := type;
	 * set trace.t1atlVariable := atlVariable;
	 * set trace.t2qvtrVariable := qvtrVariable;
	 *
	 */
	protected boolean MAP_mmapVariableExp__referredVariable__VariableDeclarat(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_VariableDeclaration trace_60)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariableExp__referredVariable__VariableDeclarat" +
					"\n\t\"trace\":" + toDebugString(trace_60) +
					"\n\t\"dispatcher\":" + toDebugString(trace_60.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_60.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_60.getDispatcher().getD2qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher_0 = trace_60.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_VariableDeclaration domapVariableExp_referredVariable_VariableDeclaration = dispatcher_0.getDomapVariableExp_referredVariable_VariableDeclaration();
		final /*@NonInvalid*/ boolean eq = trace_60.equals(domapVariableExp_referredVariable_VariableDeclaration);
		/*@Thrown*/ @Nullable Boolean symbol_13;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull VariableExp d1atlExpression = dispatcher_0.getD1atlExpression();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp d2qvtrExpression = dispatcher_0.getD2qvtrExpression();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull VariableDeclaration temp1_atlVariable = d1atlExpression.getReferredVariable();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_atlVariable instanceof PatternElement;
			/*@Thrown*/ @Nullable Boolean symbol_12;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull PatternElement symbol_1 = (PatternElement)temp1_atlVariable;
				final /*@NonInvalid*/ @Nullable TmapVariable TmapVariable = OPPOSITE_OF_TmapVariable_t1atlVariable.get(symbol_1);
				final /*@NonInvalid*/ boolean symbol_2 = TmapVariable != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapVariable;
				if (symbol_2) {
					if (TmapVariable == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable Boolean success = TmapVariable.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_11;
					if (success) {
						@SuppressWarnings("null")
						final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull VariableDeclaration t2qvtrVariable = TmapVariable.getT2qvtrVariable();
						final /*@Thrown*/ @Nullable String name_2 = t2qvtrVariable.getName();
						final /*@Thrown*/ @Nullable Type type_2 = t2qvtrVariable.getType();
						// mapping statements
						d2qvtrExpression.setName(name_2);
						dispatcher_0.setSuccess(ValueUtil.TRUE_VALUE);
						dispatcher_0.setResult(trace_60);
						d2qvtrExpression.setReferredVariable(t2qvtrVariable);
						d2qvtrExpression.setType(type_2);
						objectManager.assigned(d2qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_2);
						trace_60.setT1atlVariable(symbol_1);
						trace_60.setT2qvtrVariable(t2qvtrVariable);
						final /*@Thrown*/ @Nullable Boolean mmapVariableExp__referredVariable__VariableDeclarat = ValueUtil.TRUE_VALUE;
						symbol_11 = mmapVariableExp__referredVariable__VariableDeclarat;
					}
					else {
						symbol_11 = ValueUtil.FALSE_VALUE;
					}
					raw_when_mapVariable = symbol_11;
				}
				else {
					raw_when_mapVariable = ValueUtil.FALSE_VALUE;
				}
				symbol_12 = raw_when_mapVariable;
			}
			else {
				symbol_12 = ValueUtil.FALSE_VALUE;
			}
			symbol_13 = symbol_12;
		}
		else {
			symbol_13 = ValueUtil.FALSE_VALUE;
		}
		trace_60.setSuccess(symbol_13);
		objectManager.assigned(trace_60, trace_ATL2QVTrPackage.Literals.IMAP_VARIABLE_EXP_REFERRED_VARIABLE__SUCCESS, symbol_13);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_13 ? "done "  : "fail ") + "MAP_mmapVariableExp__referredVariable__VariableDeclarat");
		}
		return symbol_13;
	}

	/**
	 *
	 * map mmapIfExp__qvtr__edge7__type__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapIfExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapIfExp;
	 * check var qvtrExpression : IfExp[1] := dispatcher.d2qvtrExpression;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var qvtrElse : OCLExpression[1] := trace.t2qvtrElse;
	 * observe ocl::TypedElement::type var type : Type[?] := qvtrElse.type;
	 * var qvtrThen : OCLExpression[1] := trace.t2qvtrThen;
	 * observe ocl::TypedElement::type var type1 : Type[?] := qvtrThen.type;
	 * var getCommonType1 : Type[1] := this.getCommonType(type1, type);
	 * notify set qvtrExpression.type := getCommonType1;
	 *
	 */
	protected class MAP_mmapIfExp__qvtr__edge7__type__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapIfExp trace_61;

		public MAP_mmapIfExp__qvtr__edge7__type__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_61 = (@NonNull TmapIfExp)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_61.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapIfExp domapIfExp = dispatcher_0.getDomapIfExp();
			final /*@NonInvalid*/ boolean eq = trace_61.equals(domapIfExp);
			/*@Thrown*/ @Nullable Boolean symbol_7;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.IfExp;
				/*@Thrown*/ @Nullable Boolean symbol_6;
				if (symbol_0) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull IfExp symbol_1 = (org.eclipse.ocl.pivot.IfExp)temp1_qvtrExpression;
					final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_61.getLocalSuccess();
					if (localSuccess == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_5;
					if (localSuccess) {
						final /*@NonInvalid*/ @Nullable Boolean success = trace_61.getSuccess();
						if (success == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_4;
						if (success) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OCLExpression t2qvtrElse = trace_61.getT2qvtrElse();
							objectManager.getting(t2qvtrElse, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
							final /*@NonInvalid*/ @Nullable Type type_2 = t2qvtrElse.getType();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OCLExpression t2qvtrThen = trace_61.getT2qvtrThen();
							objectManager.getting(t2qvtrThen, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
							final /*@NonInvalid*/ @Nullable Type type_3 = t2qvtrThen.getType();
							final /*@Thrown*/ @NonNull Type getCommonType = ((FUN_getCommonType)FTOR_getCommonType.getUniqueComputation(ATL2QVTr.this, type_3, type_2)).instance;
							// mapping statements
							symbol_1.setType(getCommonType);
							objectManager.assigned(symbol_1, PivotPackage.Literals.TYPED_ELEMENT__TYPE, getCommonType);
							final /*@Thrown*/ @Nullable Boolean mmapIfExp__qvtr__edge7__type__ = ValueUtil.TRUE_VALUE;
							symbol_4 = mmapIfExp__qvtr__edge7__type__;
						}
						else {
							symbol_4 = ValueUtil.FALSE_VALUE;
						}
						symbol_5 = symbol_4;
					}
					else {
						symbol_5 = ValueUtil.FALSE_VALUE;
					}
					symbol_6 = symbol_5;
				}
				else {
					symbol_6 = ValueUtil.FALSE_VALUE;
				}
				symbol_7 = symbol_6;
			}
			else {
				symbol_7 = ValueUtil.FALSE_VALUE;
			}
			return symbol_7;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_61, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapVariableExp__referredVariable__Helper__qvtr in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapVariableExp_referredVariable_Helper;
	 * var atlExpression : OCL::VariableExp[1] := dispatcher.d1atlExpression;
	 * var qvtrExpression : VariableExp[1] := dispatcher.d2qvtrExpression;
	 * var atlHelper : ATL::Helper[1] := this.getHelper(atlExpression);
	 * var when_mapVariable : trace_ATL2QVTr::TmapVariable[1] := atlHelper.TmapVariable;
	 * check when_mapVariable.success;
	 * var atlVariable : OCL::VariableDeclaration[1] := atlExpression.referredVariable;
	 * check atlVariable.varName = 'self';
	 * var qvtrVariable : VariableDeclaration[1] := when_mapVariable.t2qvtrVariable;
	 * var type : Type[?] := qvtrVariable.type;
	 * set qvtrExpression.name := 'self';
	 * set dispatcher.success := true;
	 * set dispatcher.result := trace;
	 * set qvtrExpression.referredVariable := qvtrVariable;
	 * notify set qvtrExpression.type := type;
	 * set trace.t1atlVariable := atlVariable;
	 * set trace.t2qvtrVariable := qvtrVariable;
	 *
	 */
	protected boolean MAP_mmapVariableExp__referredVariable__Helper__qvtr(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_Helper trace_62)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariableExp__referredVariable__Helper__qvtr" +
					"\n\t\"trace\":" + toDebugString(trace_62) +
					"\n\t\"dispatcher\":" + toDebugString(trace_62.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_62.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_62.getDispatcher().getD2qvtrExpression()));
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher_0 = trace_62.getDispatcher();
		final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_Helper domapVariableExp_referredVariable_Helper = dispatcher_0.getDomapVariableExp_referredVariable_Helper();
		final /*@NonInvalid*/ boolean eq = trace_62.equals(domapVariableExp_referredVariable_Helper);
		/*@Thrown*/ @Nullable Boolean symbol_12;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull VariableExp d1atlExpression = dispatcher_0.getD1atlExpression();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp d2qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ @Nullable Helper getHelper = ((FUN_getHelper)FTOR_getHelper.getUniqueComputation(this, d1atlExpression)).instance;
			final /*@NonInvalid*/ boolean symbol_0 = getHelper != null;
			/*@Thrown*/ @Nullable Boolean raw_atlHelper;
			if (symbol_0) {
				if (getHelper == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@Thrown*/ @Nullable TmapVariable TmapVariable = OPPOSITE_OF_TmapVariable_t1atlVariable.get(getHelper);
				final /*@Thrown*/ boolean symbol_1 = TmapVariable != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapVariable;
				if (symbol_1) {
					if (TmapVariable == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable Boolean success = TmapVariable.getSuccess();
					if (success == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_11;
					if (success) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull VariableDeclaration referredVariable = d1atlExpression.getReferredVariable();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String varName = referredVariable.getVarName();
						final /*@NonInvalid*/ boolean eq_0 = varName.equals(STR_self);
						/*@Thrown*/ @Nullable Boolean symbol_10;
						if (eq_0) {
							@SuppressWarnings("null")
							final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull VariableDeclaration t2qvtrVariable = TmapVariable.getT2qvtrVariable();
							final /*@Thrown*/ @Nullable Type type_2 = t2qvtrVariable.getType();
							// mapping statements
							d2qvtrExpression.setName(STR_self);
							dispatcher_0.setSuccess(ValueUtil.TRUE_VALUE);
							dispatcher_0.setResult(trace_62);
							d2qvtrExpression.setReferredVariable(t2qvtrVariable);
							d2qvtrExpression.setType(type_2);
							objectManager.assigned(d2qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_2);
							trace_62.setT1atlVariable(referredVariable);
							trace_62.setT2qvtrVariable(t2qvtrVariable);
							final /*@Thrown*/ @Nullable Boolean mmapVariableExp__referredVariable__Helper__qvtr = ValueUtil.TRUE_VALUE;
							symbol_10 = mmapVariableExp__referredVariable__Helper__qvtr;
						}
						else {
							symbol_10 = ValueUtil.FALSE_VALUE;
						}
						symbol_11 = symbol_10;
					}
					else {
						symbol_11 = ValueUtil.FALSE_VALUE;
					}
					raw_when_mapVariable = symbol_11;
				}
				else {
					raw_when_mapVariable = ValueUtil.FALSE_VALUE;
				}
				raw_atlHelper = raw_when_mapVariable;
			}
			else {
				raw_atlHelper = ValueUtil.FALSE_VALUE;
			}
			symbol_12 = raw_atlHelper;
		}
		else {
			symbol_12 = ValueUtil.FALSE_VALUE;
		}
		trace_62.setSuccess(symbol_12);
		objectManager.assigned(trace_62, trace_ATL2QVTrPackage.Literals.IMAP_VARIABLE_EXP_REFERRED_VARIABLE__SUCCESS, symbol_12);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_12 ? "done "  : "fail ") + "MAP_mmapVariableExp__referredVariable__Helper__qvtr");
		}
		return symbol_12;
	}

	/**
	 *
	 * map mmapNavigationOrAttributeCallExp__Property__qvtr__e_1 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapNavigationOrAttributeCallExp_Property;
	 * check var qvtrExpression : PropertyCallExp[1] := dispatcher.d2qvtrExpression;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var qvtrSource : OCLExpression[1] := trace.t2qvtrSource;
	 * observe ocl::TypedElement::type var type : Type[?] := qvtrSource.type;
	 * var propertyName : String[1] := trace.t0propertyName;
	 * var qvtrProperty : Property[1] := this.getProperty(type, propertyName);
	 * notify set qvtrExpression.referredProperty := qvtrProperty;
	 *
	 */
	protected class MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__e_1 extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace_63;

		public MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__e_1(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_63 = (@NonNull TmapNavigationOrAttributeCallExp_Property)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_63.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Property domapNavigationOrAttributeCallExp_Property = dispatcher_0.getDomapNavigationOrAttributeCallExp_Property();
			final /*@NonInvalid*/ boolean eq = trace_63.equals(domapNavigationOrAttributeCallExp_Property);
			/*@Thrown*/ @Nullable Boolean symbol_7;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof PropertyCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_6;
				if (symbol_0) {
					final /*@NonInvalid*/ @NonNull PropertyCallExp symbol_1 = (PropertyCallExp)temp1_qvtrExpression;
					final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_63.getLocalSuccess();
					if (localSuccess == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_5;
					if (localSuccess) {
						final /*@NonInvalid*/ @Nullable Boolean success = trace_63.getSuccess();
						if (success == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_4;
						if (success) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OCLExpression t2qvtrSource = trace_63.getT2qvtrSource();
							objectManager.getting(t2qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
							final /*@NonInvalid*/ @Nullable Type type_2 = t2qvtrSource.getType();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String t0propertyName = trace_63.getT0propertyName();
							final /*@Thrown*/ @NonNull Property getProperty = ((FUN_getProperty)FTOR_getProperty.getUniqueComputation(ATL2QVTr.this, type_2, t0propertyName)).instance;
							// mapping statements
							symbol_1.setReferredProperty(getProperty);
							objectManager.assigned(symbol_1, PivotPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, getProperty);
							final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Property__qvtr__e_1 = ValueUtil.TRUE_VALUE;
							symbol_4 = mmapNavigationOrAttributeCallExp__Property__qvtr__e_1;
						}
						else {
							symbol_4 = ValueUtil.FALSE_VALUE;
						}
						symbol_5 = symbol_4;
					}
					else {
						symbol_5 = ValueUtil.FALSE_VALUE;
					}
					symbol_6 = symbol_5;
				}
				else {
					symbol_6 = ValueUtil.FALSE_VALUE;
				}
				symbol_7 = symbol_6;
			}
			else {
				symbol_7 = ValueUtil.FALSE_VALUE;
			}
			return symbol_7;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_63, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapOperatorCallExp__qvtr__edge6__type__ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapOperatorCallExp;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var qvtrSource : OCLExpression[1] := trace.t2qvtrSource;
	 * observe ocl::TypedElement::type var type : Type[?] := qvtrSource.type;
	 * var operationName : String[1] := trace.t0operationName;
	 * var qvtrOperation : Operation[1] := this.getOperation(type, operationName);
	 * observe ocl::OperationCallExp::referredOperation check qvtrOperation = qvtrExpression.referredOperation;
	 * observe ocl::TypedElement::type var type1 : Type[?] := qvtrOperation.type;
	 * notify set qvtrExpression.type := type1;
	 *
	 */
	protected class MAP_mmapOperatorCallExp__qvtr__edge6__type__ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace_64;

		public MAP_mmapOperatorCallExp__qvtr__edge6__type__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_64 = (@NonNull TmapOperatorCallExp)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_64.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = dispatcher_0.getDomapOperatorCallExp();
			final /*@NonInvalid*/ boolean eq = trace_64.equals(domapOperatorCallExp);
			/*@Thrown*/ @Nullable Boolean symbol_8;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_7;
				if (symbol_0) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
					final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_64.getLocalSuccess();
					if (localSuccess == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_6;
					if (localSuccess) {
						final /*@NonInvalid*/ @Nullable Boolean success = trace_64.getSuccess();
						if (success == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_5;
						if (success) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OCLExpression t2qvtrSource = trace_64.getT2qvtrSource();
							objectManager.getting(t2qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
							final /*@NonInvalid*/ @Nullable Type type_2 = t2qvtrSource.getType();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String t0operationName = trace_64.getT0operationName();
							final /*@Thrown*/ @NonNull Operation getOperation = ((FUN_getOperation)FTOR_getOperation.getUniqueComputation(ATL2QVTr.this, type_2, t0operationName)).instance;
							objectManager.getting(symbol_1, PivotPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION, false);
							final /*@NonInvalid*/ @Nullable Operation referredOperation = symbol_1.getReferredOperation();
							final /*@Thrown*/ boolean eq_0 = getOperation.equals(referredOperation);
							/*@Thrown*/ @Nullable Boolean symbol_4;
							if (eq_0) {
								objectManager.getting(getOperation, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
								final /*@Thrown*/ @Nullable Type type_3 = getOperation.getType();
								// mapping statements
								symbol_1.setType(type_3);
								objectManager.assigned(symbol_1, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_3);
								final /*@Thrown*/ @Nullable Boolean mmapOperatorCallExp__qvtr__edge6__type__ = ValueUtil.TRUE_VALUE;
								symbol_4 = mmapOperatorCallExp__qvtr__edge6__type__;
							}
							else {
								symbol_4 = ValueUtil.FALSE_VALUE;
							}
							symbol_5 = symbol_4;
						}
						else {
							symbol_5 = ValueUtil.FALSE_VALUE;
						}
						symbol_6 = symbol_5;
					}
					else {
						symbol_6 = ValueUtil.FALSE_VALUE;
					}
					symbol_7 = symbol_6;
				}
				else {
					symbol_7 = ValueUtil.FALSE_VALUE;
				}
				symbol_8 = symbol_7;
			}
			else {
				symbol_8 = ValueUtil.FALSE_VALUE;
			}
			return symbol_8;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_64, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapVariableExp__referredVariable__verdict__qvtr in ATL2QVTr {
	 * guard:middle mapVariableExp_referredVariable : trace_ATL2QVTr::DmapVariableExp_referredVariable[1];
	 * var mapVariableExp_referredVariable_VariableDeclaration : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1] := mapVariableExp_referredVariable.domapVariableExp_referredVariable_VariableDeclaration;
	 * check mapVariableExp_referredVariable_VariableDeclaration.success = false;
	 * var mapVariableExp_referredVariable_Helper : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1] := mapVariableExp_referredVariable.domapVariableExp_referredVariable_Helper;
	 * check mapVariableExp_referredVariable_Helper.success = false;
	 * set mapVariableExp_referredVariable.success := false;
	 *
	 */
	protected boolean MAP_mmapVariableExp__referredVariable__verdict__qvtr(final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable mapVariableExp_referredVariable)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapVariableExp__referredVariable__verdict__qvtr" +
					"\n\t\"mapVariableExp_referredVariable\":" + toDebugString(mapVariableExp_referredVariable));
		}
		final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_VariableDeclaration domapVariableExp_referredVariable_VariableDeclaration = mapVariableExp_referredVariable.getDomapVariableExp_referredVariable_VariableDeclaration();
		final /*@NonInvalid*/ boolean symbol_0 = domapVariableExp_referredVariable_VariableDeclaration != null;
		/*@Thrown*/ @Nullable Boolean raw_mapVariableExp_referredVariable_VariableDeclaration;
		if (symbol_0) {
			if (domapVariableExp_referredVariable_VariableDeclaration == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean success = domapVariableExp_referredVariable_VariableDeclaration.getSuccess();
			final /*@Thrown*/ boolean eq = success == Boolean.FALSE;
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (eq) {
				final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_Helper domapVariableExp_referredVariable_Helper = mapVariableExp_referredVariable.getDomapVariableExp_referredVariable_Helper();
				final /*@NonInvalid*/ boolean symbol_1 = domapVariableExp_referredVariable_Helper != null;
				/*@Thrown*/ @Nullable Boolean raw_mapVariableExp_referredVariable_Helper;
				if (symbol_1) {
					if (domapVariableExp_referredVariable_Helper == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable Boolean success_0 = domapVariableExp_referredVariable_Helper.getSuccess();
					final /*@Thrown*/ boolean eq_0 = success_0 == Boolean.FALSE;
					/*@Thrown*/ @Nullable Boolean symbol_4;
					if (eq_0) {
						// mapping statements
						mapVariableExp_referredVariable.setSuccess(ValueUtil.FALSE_VALUE);
						final /*@Thrown*/ @Nullable Boolean mmapVariableExp__referredVariable__verdict__qvtr = ValueUtil.TRUE_VALUE;
						symbol_4 = mmapVariableExp__referredVariable__verdict__qvtr;
					}
					else {
						symbol_4 = ValueUtil.FALSE_VALUE;
					}
					raw_mapVariableExp_referredVariable_Helper = symbol_4;
				}
				else {
					raw_mapVariableExp_referredVariable_Helper = ValueUtil.FALSE_VALUE;
				}
				symbol_5 = raw_mapVariableExp_referredVariable_Helper;
			}
			else {
				symbol_5 = ValueUtil.FALSE_VALUE;
			}
			raw_mapVariableExp_referredVariable_VariableDeclaration = symbol_5;
		}
		else {
			raw_mapVariableExp_referredVariable_VariableDeclaration = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_mapVariableExp_referredVariable_VariableDeclaration ? "done "  : "fail ") + "MAP_mmapVariableExp__referredVariable__verdict__qvtr");
		}
		return raw_mapVariableExp_referredVariable_VariableDeclaration;
	}

	/**
	 *
	 * map mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_4 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * check trace.localSuccess;
	 * check trace.success;
	 * var qvtrSource : VariableExp[1] := trace.t2qvtrSource;
	 * var aVariableDeclaration : VariableDeclaration[?] := qvtrSource.referredVariable;
	 * var name : String[?] := aVariableDeclaration?.name;
	 * var type : Type[?] := aVariableDeclaration?.type;
	 * set qvtrSource.name := name;
	 * set qvtrSource.type := type;
	 *
	 */
	protected boolean MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_4(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_65)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_4" +
					"\n\t\"trace\":" + toDebugString(trace_65) +
					"\n\t\"dispatcher\":" + toDebugString(trace_65.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_65.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_65.getDispatcher().getD2qvtrExpression()));
		}
		final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_65.getLocalSuccess();
		if (localSuccess == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_4;
		if (localSuccess) {
			final /*@NonInvalid*/ @Nullable Boolean success = trace_65.getSuccess();
			if (success == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_3;
			if (success) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp t2qvtrSource = trace_65.getT2qvtrSource();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable VariableDeclaration referredVariable = t2qvtrSource.getReferredVariable();
				final /*@NonInvalid*/ @NonNull Object name_2 = referredVariable == null;
				/*@Thrown*/ @Nullable String safe_name_source;
				if (name_2 == Boolean.TRUE) {
					safe_name_source = null;
				}
				else {
					assert referredVariable != null;
					final /*@Thrown*/ @Nullable String name_3 = referredVariable.getName();
					safe_name_source = name_3;
				}
				final /*@NonInvalid*/ @NonNull Object type_2 = referredVariable == null;
				/*@Thrown*/ @Nullable Type safe_type_source;
				if (type_2 == Boolean.TRUE) {
					safe_type_source = null;
				}
				else {
					assert referredVariable != null;
					final /*@Thrown*/ @Nullable Type type_3 = referredVariable.getType();
					safe_type_source = type_3;
				}
				// mapping statements
				t2qvtrSource.setName(safe_name_source);
				t2qvtrSource.setType(safe_type_source);
				final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_4 = ValueUtil.TRUE_VALUE;
				symbol_3 = mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_4;
			}
			else {
				symbol_3 = ValueUtil.FALSE_VALUE;
			}
			symbol_4 = symbol_3;
		}
		else {
			symbol_4 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_4 ? "done "  : "fail ") + "MAP_mmapNavigationOrAttributeCallExp__Helper__qvtr__edg_4");
		}
		return symbol_4;
	}

	/**
	 *
	 * map mmapOperationCallExp__Operation__qvtr__edge6__type_ in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapOperationCallExp_Operation;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var qvtrSource : OCLExpression[1] := trace.t2qvtrSource;
	 * observe ocl::TypedElement::type var type : Type[?] := qvtrSource.type;
	 * var operationName : String[1] := trace.t0operationName;
	 * var getOperation1 : Operation[1] := this.getOperation(type, operationName);
	 * observe ocl::OperationCallExp::referredOperation check getOperation1 = qvtrExpression.referredOperation;
	 * observe ocl::TypedElement::type var type1 : Type[?] := getOperation1.type;
	 * notify set qvtrExpression.type := type1;
	 *
	 */
	protected class MAP_mmapOperationCallExp__Operation__qvtr__edge6__type_ extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace_66;

		public MAP_mmapOperationCallExp__Operation__qvtr__edge6__type_(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_66 = (@NonNull TmapOperationCallExp_Operation)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_66.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Operation domapOperationCallExp_Operation = dispatcher_0.getDomapOperationCallExp_Operation();
			final /*@NonInvalid*/ boolean eq = trace_66.equals(domapOperationCallExp_Operation);
			/*@Thrown*/ @Nullable Boolean symbol_8;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_7;
				if (symbol_0) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
					final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_66.getLocalSuccess();
					if (localSuccess == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_6;
					if (localSuccess) {
						final /*@NonInvalid*/ @Nullable Boolean success = trace_66.getSuccess();
						if (success == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_5;
						if (success) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OCLExpression t2qvtrSource = trace_66.getT2qvtrSource();
							objectManager.getting(t2qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
							final /*@NonInvalid*/ @Nullable Type type_2 = t2qvtrSource.getType();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String t0operationName = trace_66.getT0operationName();
							final /*@Thrown*/ @NonNull Operation getOperation = ((FUN_getOperation)FTOR_getOperation.getUniqueComputation(ATL2QVTr.this, type_2, t0operationName)).instance;
							objectManager.getting(symbol_1, PivotPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION, false);
							final /*@NonInvalid*/ @Nullable Operation referredOperation = symbol_1.getReferredOperation();
							final /*@Thrown*/ boolean eq_0 = getOperation.equals(referredOperation);
							/*@Thrown*/ @Nullable Boolean symbol_4;
							if (eq_0) {
								objectManager.getting(getOperation, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
								final /*@Thrown*/ @Nullable Type type_3 = getOperation.getType();
								// mapping statements
								symbol_1.setType(type_3);
								objectManager.assigned(symbol_1, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_3);
								final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Operation__qvtr__edge6__type_ = ValueUtil.TRUE_VALUE;
								symbol_4 = mmapOperationCallExp__Operation__qvtr__edge6__type_;
							}
							else {
								symbol_4 = ValueUtil.FALSE_VALUE;
							}
							symbol_5 = symbol_4;
						}
						else {
							symbol_5 = ValueUtil.FALSE_VALUE;
						}
						symbol_6 = symbol_5;
					}
					else {
						symbol_6 = ValueUtil.FALSE_VALUE;
					}
					symbol_7 = symbol_6;
				}
				else {
					symbol_7 = ValueUtil.FALSE_VALUE;
				}
				symbol_8 = symbol_7;
			}
			else {
				symbol_8 = ValueUtil.FALSE_VALUE;
			}
			return symbol_8;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_66, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapNavigationOrAttributeCallExp__Property__qvtr__e_2 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check trace =
	 *   dispatcher.domapNavigationOrAttributeCallExp_Property;
	 * check var qvtrExpression : PropertyCallExp[1] := dispatcher.d2qvtrExpression;
	 * check trace.localSuccess;
	 * check trace.success;
	 * var qvtrSource : OCLExpression[1] := trace.t2qvtrSource;
	 * observe ocl::TypedElement::type var type : Type[?] := qvtrSource.type;
	 * var propertyName : String[1] := trace.t0propertyName;
	 * var qvtrProperty : Property[1] := this.getProperty(type, propertyName);
	 * observe ocl::PropertyCallExp::referredProperty check qvtrProperty = qvtrExpression.referredProperty;
	 * observe ocl::TypedElement::type var type1 : Type[?] := qvtrProperty.type;
	 * notify set qvtrExpression.type := type1;
	 *
	 */
	protected class MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__e_2 extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace_67;

		public MAP_mmapNavigationOrAttributeCallExp__Property__qvtr__e_2(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_67 = (@NonNull TmapNavigationOrAttributeCallExp_Property)boundValues[0];
		}

		@Override
		public boolean execute()  {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_67.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Property domapNavigationOrAttributeCallExp_Property = dispatcher_0.getDomapNavigationOrAttributeCallExp_Property();
			final /*@NonInvalid*/ boolean eq = trace_67.equals(domapNavigationOrAttributeCallExp_Property);
			/*@Thrown*/ @Nullable Boolean symbol_8;
			if (eq) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof PropertyCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_7;
				if (symbol_0) {
					final /*@NonInvalid*/ @NonNull PropertyCallExp symbol_1 = (PropertyCallExp)temp1_qvtrExpression;
					final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_67.getLocalSuccess();
					if (localSuccess == null) {
						throw new InvalidEvaluationException("Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_6;
					if (localSuccess) {
						final /*@NonInvalid*/ @Nullable Boolean success = trace_67.getSuccess();
						if (success == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_5;
						if (success) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OCLExpression t2qvtrSource = trace_67.getT2qvtrSource();
							objectManager.getting(t2qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
							final /*@NonInvalid*/ @Nullable Type type_2 = t2qvtrSource.getType();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String t0propertyName = trace_67.getT0propertyName();
							final /*@Thrown*/ @NonNull Property getProperty = ((FUN_getProperty)FTOR_getProperty.getUniqueComputation(ATL2QVTr.this, type_2, t0propertyName)).instance;
							objectManager.getting(symbol_1, PivotPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, false);
							final /*@NonInvalid*/ @Nullable Property referredProperty = symbol_1.getReferredProperty();
							final /*@Thrown*/ boolean eq_0 = getProperty.equals(referredProperty);
							/*@Thrown*/ @Nullable Boolean symbol_4;
							if (eq_0) {
								objectManager.getting(getProperty, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
								final /*@Thrown*/ @Nullable Type type_3 = getProperty.getType();
								// mapping statements
								symbol_1.setType(type_3);
								objectManager.assigned(symbol_1, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_3);
								final /*@Thrown*/ @Nullable Boolean mmapNavigationOrAttributeCallExp__Property__qvtr__e_2 = ValueUtil.TRUE_VALUE;
								symbol_4 = mmapNavigationOrAttributeCallExp__Property__qvtr__e_2;
							}
							else {
								symbol_4 = ValueUtil.FALSE_VALUE;
							}
							symbol_5 = symbol_4;
						}
						else {
							symbol_5 = ValueUtil.FALSE_VALUE;
						}
						symbol_6 = symbol_5;
					}
					else {
						symbol_6 = ValueUtil.FALSE_VALUE;
					}
					symbol_7 = symbol_6;
				}
				else {
					symbol_7 = ValueUtil.FALSE_VALUE;
				}
				symbol_8 = symbol_7;
			}
			else {
				symbol_8 = ValueUtil.FALSE_VALUE;
			}
			return symbol_8;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_67, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mmapOperationCallExp__Helper__qvtr__edge6__name__ed in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * check trace.localSuccess;
	 * check trace.success;
	 * var qvtrSource : VariableExp[1] := trace.t2qvtrSource;
	 * var aVariableDeclaration : VariableDeclaration[?] := qvtrSource.referredVariable;
	 * var name : String[?] := aVariableDeclaration?.name;
	 * var type : Type[?] := aVariableDeclaration?.type;
	 * set qvtrSource.name := name;
	 * set qvtrSource.type := type;
	 *
	 */
	protected boolean MAP_mmapOperationCallExp__Helper__qvtr__edge6__name__ed(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_68)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mmapOperationCallExp__Helper__qvtr__edge6__name__ed" +
					"\n\t\"trace\":" + toDebugString(trace_68) +
					"\n\t\"dispatcher\":" + toDebugString(trace_68.getDispatcher()) +
					"\n\t\"dispatcher.d1atlExpression\":" + toDebugString(trace_68.getDispatcher().getD1atlExpression()) +
					"\n\t\"dispatcher.d2qvtrExpression\":" + toDebugString(trace_68.getDispatcher().getD2qvtrExpression()));
		}
		final /*@NonInvalid*/ @Nullable Boolean localSuccess = trace_68.getLocalSuccess();
		if (localSuccess == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_4;
		if (localSuccess) {
			final /*@NonInvalid*/ @Nullable Boolean success = trace_68.getSuccess();
			if (success == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_3;
			if (success) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp t2qvtrSource = trace_68.getT2qvtrSource();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable VariableDeclaration referredVariable = t2qvtrSource.getReferredVariable();
				final /*@NonInvalid*/ @NonNull Object name_2 = referredVariable == null;
				/*@Thrown*/ @Nullable String safe_name_source;
				if (name_2 == Boolean.TRUE) {
					safe_name_source = null;
				}
				else {
					assert referredVariable != null;
					final /*@Thrown*/ @Nullable String name_3 = referredVariable.getName();
					safe_name_source = name_3;
				}
				final /*@NonInvalid*/ @NonNull Object type_2 = referredVariable == null;
				/*@Thrown*/ @Nullable Type safe_type_source;
				if (type_2 == Boolean.TRUE) {
					safe_type_source = null;
				}
				else {
					assert referredVariable != null;
					final /*@Thrown*/ @Nullable Type type_3 = referredVariable.getType();
					safe_type_source = type_3;
				}
				// mapping statements
				t2qvtrSource.setName(safe_name_source);
				t2qvtrSource.setType(safe_type_source);
				final /*@Thrown*/ @Nullable Boolean mmapOperationCallExp__Helper__qvtr__edge6__name__ed = ValueUtil.TRUE_VALUE;
				symbol_3 = mmapOperationCallExp__Helper__qvtr__edge6__name__ed;
			}
			else {
				symbol_3 = ValueUtil.FALSE_VALUE;
			}
			symbol_4 = symbol_3;
		}
		else {
			symbol_4 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_4 ? "done "  : "fail ") + "MAP_mmapOperationCallExp__Helper__qvtr__edge6__name__ed");
		}
		return symbol_4;
	}
}
