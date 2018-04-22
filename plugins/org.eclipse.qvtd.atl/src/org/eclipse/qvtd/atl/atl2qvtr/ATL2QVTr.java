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
import org.eclipse.m2m.atl.common.OCL.OperatorCallExp;
import org.eclipse.m2m.atl.common.OCL.StringExp;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.ParameterVariable;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
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
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
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
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern;
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
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.InvalidEvaluationException;
import org.eclipse.qvtd.runtime.evaluation.InvocationConstructor;
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
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOperationCallExp_Helper = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOperationCallExp_Helper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOperationCallExp_Operation = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOperationCallExp_Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOperationCallExp_argument = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOperationCallExp_argument", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOperatorCallExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOperatorCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TmapOutPattern = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TmapOutPattern", 0);
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
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_OutPatternElement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OutPatternElement);
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_atl = PACKid_qvtd.getNestedPackageId("atl");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_d1atlExpression_0 = CLSSid_DmapOclExpression.getPropertyId("d1atlExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_d1atlHelper = CLSSid_DmapHelper.getPropertyId("d1atlHelper");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_definition = CLSSid_Helper.getPropertyId("definition");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_inModels = CLSSid_Module.getPropertyId("inModels");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_outModels = CLSSid_Module.getPropertyId("outModels");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1atlElement_0 = CLSSid_TmapSimpleOutPatternElement.getPropertyId("t1atlElement");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1atlModule_4 = CLSSid_TmapModule.getPropertyId("t1atlModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1atlPattern_2 = CLSSid_TmapInPattern.getPropertyId("t1atlPattern");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1atlPattern_3 = CLSSid_TmapOutPattern.getPropertyId("t1atlPattern");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1atlVariable_2 = CLSSid_TmapVariable.getPropertyId("t1atlVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1matchedRule = CLSSid_TmapMatchedRule.getPropertyId("t1matchedRule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_t1oclMetamodel_1 = CLSSid_TmapOclMetamodel.getPropertyId("t1oclMetamodel");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Attribute = TypeId.SEQUENCE.getSpecializedId(CLSSid_Attribute);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_OclFeature = TypeId.SEQUENCE.getSpecializedId(CLSSid_OclFeature);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_OclFeatureDefinition = TypeId.SEQUENCE.getSpecializedId(CLSSid_OclFeatureDefinition);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_OclModelElement = TypeId.SEQUENCE.getSpecializedId(CLSSid_OclModelElement);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_OclType = TypeId.SEQUENCE.getSpecializedId(CLSSid_OclType);
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
	protected final @NonNull Map<OutPattern,TmapOutPattern> OPPOSITE_OF_TmapOutPattern_t1atlPattern = new HashMap<>();
	protected final @NonNull Map<SimpleOutPatternElement,TmapSimpleOutPatternElement> OPPOSITE_OF_TmapSimpleOutPatternElement_t1atlElement = new HashMap<>();
	protected final @NonNull Map<LocatedElement,TmapVariable> OPPOSITE_OF_TmapVariable_t1atlVariable = new HashMap<>();

	/*
	 * Array of the source PropertyIds of each Property for which unnavigable opposite property navigation may occur.
	 */
	private static final @NonNull PropertyId @NonNull [] oppositeIndex2propertyId = new @NonNull PropertyId[]{
		PROPid_d1atlExpression_0,		// 0 => d1atlExpression
		PROPid_t1atlModule_4,		// 1 => t1atlModule
		PROPid_t1matchedRule,		// 2 => t1matchedRule
		PROPid_d1atlHelper,		// 3 => d1atlHelper
		PROPid_t1oclMetamodel_1,		// 4 => t1oclMetamodel
		PROPid_t1atlPattern_2,		// 5 => t1atlPattern
		PROPid_t1atlPattern_3,		// 6 => t1atlPattern
		PROPid_t1atlElement_0,		// 7 => t1atlElement
		PROPid_t1atlVariable_2		// 8 => t1atlVariable
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
		CLSSid_OclExpression,                 // 5 => OclExpression
		CLSSid_OclModel,                      // 6 => OclModel
		CLSSid_OutPattern,                    // 7 => OutPattern
		CLSSid_SimpleInPatternElement,        // 8 => SimpleInPatternElement
		CLSSid_SimpleOutPatternElement        // 9 => SimpleOutPatternElement
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
		{5},                          // 5 : OclExpression -> {OclExpression}
		{6},                          // 6 : OclModel -> {OclModel}
		{7},                          // 7 : OutPattern -> {OutPattern}
		{8},                          // 8 : SimpleInPatternElement -> {SimpleInPatternElement}
		{9}                           // 9 : SimpleOutPatternElement -> {SimpleOutPatternElement}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR___root__ = new AbstractInvocationConstructor(invocationManager, "__root__", false)
	{
		@Override
		public @NonNull MAP___root__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP___root__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mTmapNavigationOrAttributeCallExp__Property__type_p5 = new AbstractInvocationConstructor(invocationManager, "mTmapNavigationOrAttributeCallExp__Property__type_p5", false)
	{
		@Override
		public @NonNull MAP_mTmapNavigationOrAttributeCallExp__Property__type_p5 newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mTmapNavigationOrAttributeCallExp__Property__type_p5(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mTmapOperationCallExp__Operation__type_p5 = new AbstractInvocationConstructor(invocationManager, "mTmapOperationCallExp__Operation__type_p5", false)
	{
		@Override
		public @NonNull MAP_mTmapOperationCallExp__Operation__type_p5 newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mTmapOperationCallExp__Operation__type_p5(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mTmapOperatorCallExp__type_p5 = new AbstractInvocationConstructor(invocationManager, "mTmapOperatorCallExp__type_p5", false)
	{
		@Override
		public @NonNull MAP_mTmapOperatorCallExp__type_p5 newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mTmapOperatorCallExp__type_p5(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mTmapIfExp__type_p6 = new AbstractInvocationConstructor(invocationManager, "mTmapIfExp__type_p6", false)
	{
		@Override
		public @NonNull MAP_mTmapIfExp__type_p6 newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mTmapIfExp__type_p6(this, values);
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
		final @NonNull Connection ji_OclExpression = models[0/*atl*/].getConnection(5/*OCL::OclExpression*/);
		final @NonNull Connection ji_OclModel = models[0/*atl*/].getConnection(6/*OCL::OclModel*/);
		final @NonNull Connection ji_OutPattern = models[0/*atl*/].getConnection(7/*ATL::OutPattern*/);
		final @NonNull Connection ji_SimpleInPatternElement = models[0/*atl*/].getConnection(8/*ATL::SimpleInPatternElement*/);
		final @NonNull Connection ji_SimpleOutPatternElement = models[0/*atl*/].getConnection(9/*ATL::SimpleOutPatternElement*/);
		CTOR___root__.invoke(ji_Binding, ji_Helper, ji_InPattern, ji_MatchedRule, ji_Module, ji_OclExpression, ji_OclModel, ji_OutPattern, ji_SimpleInPatternElement, ji_SimpleOutPatternElement);
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
			this.type1 = (Type)boundValues[1];
			this.type2 = (Type)boundValues[2];
			this.instance = org.eclipse.qvtd.atl.atl2qvtr.utilities.Helper4getCommonType.INSTANCE.evaluate(executor, CLSSid_Type, type1, type2);
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
	 * ::getHelper(element : ATL::LocatedElement[1]) : ATL::Helper[1]
	 */
	protected class FUN_getHelper extends AbstractComputation
	{
		protected final @NonNull ATL2QVTr self;
		protected /*@NonInvalid*/ @NonNull LocatedElement element;
		protected final /*@Thrown*/ @NonNull Helper instance;

		/**
		 *
		 * element->closure(e | e.oclContainer())
		 * ->selectByKind(ATL::Helper)
		 * ->any(true)
		 */
		@SuppressWarnings("null")
		public FUN_getHelper(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.element = (LocatedElement)boundValues[1];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ATL_c_c_Helper_0 = idResolver.getClass(CLSSid_Helper, null);
			final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
			final /*@NonInvalid*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_LocatedElement, element);
			final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure_0 = executor.getStaticTypeOf(oclAsSet);
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
					final /*@NonInvalid*/ @Nullable Object symbol_0 = (Object)e_0;
					final /*@Thrown*/ @Nullable Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, symbol_0);
					return oclContainer;
				}
			};
			final @NonNull  ExecutorSingleIterationManager MGR_closure_0 = new ExecutorSingleIterationManager(executor, SET_CLSSid_OclElement, BODY_closure_0, oclAsSet, ACC_closure_0);
			final /*@Thrown*/ @NonNull SetValue closure = ClassUtil.nonNullState((SetValue)IMPL_closure_0.evaluateIteration(MGR_closure_0));
			final /*@Thrown*/ @NonNull SetValue selectByKind = (SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, closure, TYP_ATL_c_c_Helper_0);
			@NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
			/*@Thrown*/ @NonNull Helper any;
			while (true) {
				if (!ITERATOR__1.hasNext()) {
					throw new InvalidValueException("No matching content for 'any'");
				}
				@SuppressWarnings("null")
				/*@NonInvalid*/ @NonNull Helper _1 = (Helper)ITERATOR__1.next();
				/**
				 * true
				 */
				//
				if (ValueUtil.TRUE_VALUE != ValueUtil.FALSE_VALUE) {			// Carry on till something found
					any = _1;
					break;
				}
			}
			this.instance = any;
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
			this.element_0 = (LocatedElement)boundValues[1];
			this.instance = org.eclipse.qvtd.atl.atl2qvtr.utilities.Helper4getModule.INSTANCE.evaluate(executor, CLSSid_Module, element_0);
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
		protected final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Operation instance;

		@SuppressWarnings("null")
		public FUN_getOperation(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.type = (Type)boundValues[1];
			this.name = (String)boundValues[2];
			this.instance = org.eclipse.qvtd.atl.atl2qvtr.utilities.Helper4getOperation.INSTANCE.evaluate(executor, CLSSid_Operation_0, type, name);
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
			this.atlModule_0 = (Module)boundValues[1];
			this.name_0 = (String)boundValues[2];
			this.instance = org.eclipse.qvtd.atl.atl2qvtr.utilities.Helper4getPackage.INSTANCE.evaluate(executor, CLSSid_Package, atlModule_0, name_0);
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
			this.type_0 = (Type)boundValues[1];
			this.name_1 = (String)boundValues[2];
			this.instance = org.eclipse.qvtd.atl.atl2qvtr.utilities.Helper4getProperty.INSTANCE.evaluate(executor, CLSSid_Property, type_0, name_1);
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
			this.type_1 = (OclType)boundValues[1];
			this.instance = org.eclipse.qvtd.atl.atl2qvtr.utilities.Helper4getType.INSTANCE.evaluate(executor, CLSSid_Class, type_1);
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
	 * map __root__ in ATL2QVTr {
	 *
	 *   append ji_Binding  : ATL::Binding[1];
	 * append ji_Helper  : ATL::Helper[1];
	 * append ji_InPattern  : ATL::InPattern[1];
	 * append ji_MatchedRule  : ATL::MatchedRule[1];
	 * append ji_Module  : ATL::Module[1];
	 * append ji_OclExpression  : OCL::OclExpression[1];
	 * append ji_OclModel  : OCL::OclModel[1];
	 * append ji_OutPattern  : ATL::OutPattern[1];
	 * append ji_SimpleInPatternElement  : ATL::SimpleInPatternElement[1];
	 * append ji_SimpleOutPatternElement  : ATL::SimpleOutPatternElement[1];
	 * ::jm_DmapHelper : trace_ATL2QVTr::DmapHelper[1]::jm_DmapOclExpression : trace_ATL2QVTr::DmapOclExpression[1]::jm_DmapVariableExp__referredVariable : trace_ATL2QVTr::DmapVariableExp_referredVariable[1]::jm_TmapBinding : trace_ATL2QVTr::TmapBinding[1]::jm_TmapBooleanExp : trace_ATL2QVTr::TmapBooleanExp[1]::jm_TmapHelper__Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1]::jm_TmapHelper__Context : trace_ATL2QVTr::TmapHelper_Context[1]::jm_TmapHelper__Operation : trace_ATL2QVTr::TmapHelper_Operation[1]::jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1]::jm_TmapInPattern : trace_ATL2QVTr::TmapInPattern[1]::jm_TmapInPattern__filter : trace_ATL2QVTr::TmapInPattern_filter[1]::jm_TmapIntegerExp : trace_ATL2QVTr::TmapIntegerExp[1]::jm_TmapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1]::jm_TmapMatchedRule__super : trace_ATL2QVTr::TmapMatchedRule_super[1]::jm_TmapModule : trace_ATL2QVTr::TmapModule[1]::jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1]::jm_TmapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1]::jm_TmapOclMetamodel : trace_ATL2QVTr::TmapOclMetamodel[1]::jm_TmapOclModel__IN : trace_ATL2QVTr::TmapOclModel_IN[1]::jm_TmapOclModel__OUT : trace_ATL2QVTr::TmapOclModel_OUT[1]::jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1]::jm_TmapOperationCallExp__Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1]::jm_TmapOperationCallExp__argument : trace_ATL2QVTr::TmapOperationCallExp_argument[1]::jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1]::jm_TmapOutPattern : trace_ATL2QVTr::TmapOutPattern[1]::jm_TmapSimpleInPatternElement : trace_ATL2QVTr::TmapSimpleInPatternElement[1]::jm_TmapSimpleOutPatternElement : trace_ATL2QVTr::TmapSimpleOutPatternElement[1]::jm_TmapStringExp : trace_ATL2QVTr::TmapStringExp[1]::jm_TmapVariable : trace_ATL2QVTr::TmapVariable[1]::jm_TmapVariableExp : trace_ATL2QVTr::TmapVariableExp[1]::jm_TmapVariableExp__referredVariable__Helper : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1]::jm_TmapVariableExp__referredVariable__VariableDecl : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1]install mHelper_DmapHelper {
	 * atlHelper consumes append ji_Helper  : ATL::Helper[1];
	 * ;
	 * jm_DmapHelper appendsTo jm_DmapHelper;
	 * jm_TmapHelper__Attribute appendsTo jm_TmapHelper__Attribute;
	 * jm_TmapHelper__Operation appendsTo jm_TmapHelper__Operation;
	 * }
	 *   install mOclExpression_DmapOclExpression {
	 * atlExpression consumes append ji_OclExpression  : OCL::OclExpression[1];
	 * ;
	 * jm_DmapOclExpression appendsTo jm_DmapOclExpression;
	 * jm_TmapBooleanExp appendsTo jm_TmapBooleanExp;
	 * jm_TmapIfExp appendsTo jm_TmapIfExp;
	 * jm_TmapIntegerExp appendsTo jm_TmapIntegerExp;
	 * jm_TmapNavigationOrAttributeCallExp__Helper appendsTo jm_TmapNavigationOrAttributeCallExp__Helper;
	 * jm_TmapNavigationOrAttributeCallExp__Property appendsTo jm_TmapNavigationOrAttributeCallExp__Property;
	 * jm_TmapOperationCallExp__Helper appendsTo jm_TmapOperationCallExp__Helper;
	 * jm_TmapOperationCallExp__Operation appendsTo jm_TmapOperationCallExp__Operation;
	 * jm_TmapOperatorCallExp appendsTo jm_TmapOperatorCallExp;
	 * jm_TmapStringExp appendsTo jm_TmapStringExp;
	 * jm_TmapVariableExp appendsTo jm_TmapVariableExp;
	 * }
	 *   install mTmapBooleanExp_success_t0symbol {
	 * trace consumes ::jm_TmapBooleanExp : trace_ATL2QVTr::TmapBooleanExp[1];
	 * }
	 *   install mTmapIntegerExp_success_t0symbol {
	 * trace consumes ::jm_TmapIntegerExp : trace_ATL2QVTr::TmapIntegerExp[1];
	 * }
	 *   install mTmapStringExp_success_t0symbol {
	 * trace consumes ::jm_TmapStringExp : trace_ATL2QVTr::TmapStringExp[1];
	 * }
	 *   install mTmapIfExp_t1atlCondition_t1atlElse_t1atlThen_p0 {
	 * trace consumes ::jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * }
	 *   install mTmapIfExp_success_wmapOclExpression_wmapOclExpress_p1 {
	 * trace consumes ::jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * }
	 *   install mTmapIfExp__DmapOclExpression_d2qvtrExpression_p2 {
	 * trace consumes ::jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * }
	 *   install mTmapNavigationOrAttributeCallExp__Helper_t0propert_p0 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install mTmapNavigationOrAttributeCallExp__Property_t0prope_p0 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * }
	 *   install mTmapNavigationOrAttributeCallExp__Property_success_p1 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * }
	 *   install mTmapNavigationOrAttributeCallExp__Property__DmapOc_p2 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * }
	 *   install mTmapOperationCallExp__Helper_t0operationName_t1atl_p0 {
	 * trace consumes ::jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * }
	 *   install mTmapOperationCallExp__Operation_t0operationName_t1_p0 {
	 * trace consumes ::jm_TmapOperationCallExp__Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * }
	 *   install mTmapOperationCallExp__Operation_success_wmapOclExp_p1 {
	 * trace consumes ::jm_TmapOperationCallExp__Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * }
	 *   install mTmapOperationCallExp__Operation__DmapOclExpression_p2 {
	 * trace consumes ::jm_TmapOperationCallExp__Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * }
	 *   install mTmapOperatorCallExp_t0operationName_t1atlSource_p0 {
	 * trace consumes ::jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * }
	 *   install mTmapVariableExp_success_t0varName_t1atlVariable_wm {
	 * jm_DmapVariableExp__referredVariable appendsTo jm_DmapVariableExp__referredVariable;
	 * trace consumes ::jm_TmapVariableExp : trace_ATL2QVTr::TmapVariableExp[1];
	 * }
	 *   install mDmapVariableExp__referredVariable_domapVariableExp {
	 * dispatcher consumes ::jm_DmapVariableExp__referredVariable : trace_ATL2QVTr::DmapVariableExp_referredVariable[1];
	 * jm_TmapVariableExp__referredVariable__Helper appendsTo jm_TmapVariableExp__referredVariable__Helper;
	 * jm_TmapVariableExp__referredVariable__VariableDecl appendsTo jm_TmapVariableExp__referredVariable__VariableDecl;
	 * }
	 *   install mTmapVariableExp__referredVariable__Helper_t1atlVar_p0 {
	 * trace consumes ::jm_TmapVariableExp__referredVariable__Helper : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * }
	 *   install mTmapVariableExp__referredVariable__VariableDeclara_p0 {
	 * trace consumes ::jm_TmapVariableExp__referredVariable__VariableDecl : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1];
	 * }
	 *   install mBinding_TmapBinding_p0 {
	 * atlBinding consumes append ji_Binding  : ATL::Binding[1];
	 * ;
	 * jm_TmapBinding appendsTo jm_TmapBinding;
	 * }
	 *   install mMatchedRule__t1atlRule_p0 {
	 * atlRule consumes append ji_MatchedRule  : ATL::MatchedRule[1];
	 * ;
	 * jm_TmapInPattern__filter appendsTo jm_TmapInPattern__filter;
	 * }
	 *   install mInPattern_TmapInPattern_p0 {
	 * atlPattern consumes append ji_InPattern  : ATL::InPattern[1];
	 * ;
	 * jm_TmapInPattern appendsTo jm_TmapInPattern;
	 * }
	 *   install mMatchedRule_TmapMatchedRule_p0 {
	 * jm_TmapMatchedRule appendsTo jm_TmapMatchedRule;
	 * matchedRule consumes append ji_MatchedRule  : ATL::MatchedRule[1];
	 * ;
	 * }
	 *   install mMatchedRule_TmapMatchedRule_super_p0 {
	 * atlChildRule consumes append ji_MatchedRule  : ATL::MatchedRule[1];
	 * ;
	 * jm_TmapMatchedRule__super appendsTo jm_TmapMatchedRule__super;
	 * }
	 *   install mModule_TmapModule_p0 {
	 * atlModule consumes append ji_Module  : ATL::Module[1];
	 * ;
	 * jm_TmapModule appendsTo jm_TmapModule;
	 * }
	 *   install mTmapModule_t0txName_t2_1_t2_2_t2_3_t2_4_t2qvtrTran_p1 {
	 * trace consumes ::jm_TmapModule : trace_ATL2QVTr::TmapModule[1];
	 * }
	 *   install mTmapMatchedRule_success_t0ruleName_t1atlModule_t2__p1 {
	 * trace consumes ::jm_TmapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1];
	 * }
	 *   install mTmapMatchedRule__super_t1atlSuperRule_t2qvtrOverri_p1 {
	 * trace consumes ::jm_TmapMatchedRule__super : trace_ATL2QVTr::TmapMatchedRule_super[1];
	 * }
	 *   install mTmapNavigationOrAttributeCallExp__Helper_success_w_p1 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install mTmapNavigationOrAttributeCallExp__Helper_t2qvtrSou_p2 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install mTmapOperationCallExp__Helper_success_wmapHelper_wm_p1 {
	 * trace consumes ::jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * }
	 *   install mTmapOperationCallExp__Helper_t2qvtrSource_p2 {
	 * trace consumes ::jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * }
	 *   install mTmapOperatorCallExp_success_wmapModule_wmapOclExpr_p1 {
	 * trace consumes ::jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * }
	 *   install mDmapOclExpression_success {
	 * mapOclExpression consumes ::jm_DmapOclExpression : trace_ATL2QVTr::DmapOclExpression[1];
	 * }
	 *   install mTmapOperatorCallExp_t2qvtrTransformation_p6 {
	 * trace consumes ::jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * }
	 *   install mTmapOperatorCallExp__DmapOclExpression_d2qvtrExpre_p2 {
	 * trace consumes ::jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * }
	 *   install mTmapHelper__Attribute_t0attributeName_t1atlDefinit_p0 {
	 * trace consumes ::jm_TmapHelper__Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * }
	 *   install mTmapHelper__Attribute_success_wmapOclExpression_p1 {
	 * trace consumes ::jm_TmapHelper__Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * }
	 *   install mTmapHelper__Operation_t0operationName_t1atlDefinit_p0 {
	 * trace consumes ::jm_TmapHelper__Operation : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * }
	 *   install mTmapHelper__Operation_success_wmapOclExpression_p1 {
	 * trace consumes ::jm_TmapHelper__Operation : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * }
	 *   install mDmapHelper_success {
	 * mapHelper consumes ::jm_DmapHelper : trace_ATL2QVTr::DmapHelper[1];
	 * }
	 *   install mOclModel_TmapOclMetamodel_p0 {
	 * jm_TmapOclMetamodel appendsTo jm_TmapOclMetamodel;
	 * oclMetamodel consumes append ji_OclModel  : OCL::OclModel[1];
	 * ;
	 * }
	 *   install mTmapOclMetamodel_t0tmName_t2qvtrTypedModel_p1 {
	 * trace consumes ::jm_TmapOclMetamodel : trace_ATL2QVTr::TmapOclMetamodel[1];
	 * }
	 *   install mTmapInPattern_success_t1atlModel_t1atlRule_t2qvtrD_p1 {
	 * trace consumes ::jm_TmapInPattern : trace_ATL2QVTr::TmapInPattern[1];
	 * }
	 *   install mOclModel_TmapOclModel_IN_p0 {
	 * jm_TmapOclModel__IN appendsTo jm_TmapOclModel__IN;
	 * oclModel consumes append ji_OclModel  : OCL::OclModel[1];
	 * ;
	 * }
	 *   install mTmapOclModel__IN_t0tmName_t1atlModule_t1oclMetamod_p1 {
	 * trace consumes ::jm_TmapOclModel__IN : trace_ATL2QVTr::TmapOclModel_IN[1];
	 * }
	 *   install mOclModel_TmapOclModel_OUT_p0 {
	 * jm_TmapOclModel__OUT appendsTo jm_TmapOclModel__OUT;
	 * oclModel consumes append ji_OclModel  : OCL::OclModel[1];
	 * ;
	 * }
	 *   install mTmapOclModel__OUT_t0tmName_t1atlModule_t1oclMetamo_p1 {
	 * trace consumes ::jm_TmapOclModel__OUT : trace_ATL2QVTr::TmapOclModel_OUT[1];
	 * }
	 *   install mOclExpression_TmapOperationCallExp_argument_p0 {
	 * atlArgument consumes append ji_OclExpression  : OCL::OclExpression[1];
	 * ;
	 * jm_TmapOperationCallExp__argument appendsTo jm_TmapOperationCallExp__argument;
	 * }
	 *   install mOutPattern_TmapOutPattern_p0 {
	 * atlPattern consumes append ji_OutPattern  : ATL::OutPattern[1];
	 * ;
	 * jm_TmapOutPattern appendsTo jm_TmapOutPattern;
	 * }
	 *   install mTmapOutPattern_success_t1atlRule_t2qvtrDomain_t2qv_p1 {
	 * trace consumes ::jm_TmapOutPattern : trace_ATL2QVTr::TmapOutPattern[1];
	 * }
	 *   install mSimpleInPatternElement_TmapSimpleInPatternElement_p0 {
	 * atlElement consumes append ji_SimpleInPatternElement  : ATL::SimpleInPatternElement[1];
	 * ;
	 * jm_TmapSimpleInPatternElement appendsTo jm_TmapSimpleInPatternElement;
	 * }
	 *   install mSimpleOutPatternElement_TmapSimpleOutPatternElemen_p0 {
	 * atlElement consumes append ji_SimpleOutPatternElement  : ATL::SimpleOutPatternElement[1];
	 * ;
	 * jm_TmapSimpleOutPatternElement appendsTo jm_TmapSimpleOutPatternElement;
	 * }
	 *   install mTmapSimpleInPatternElement_t0elementName_t1atlPatt_p1 {
	 * jm_TmapVariable appendsTo jm_TmapVariable;
	 * trace consumes ::jm_TmapSimpleInPatternElement : trace_ATL2QVTr::TmapSimpleInPatternElement[1];
	 * }
	 *   install mTmapSimpleOutPatternElement_success_t0elementName__p1 {
	 * jm_TmapVariable appendsTo jm_TmapVariable;
	 * trace consumes ::jm_TmapSimpleOutPatternElement : trace_ATL2QVTr::TmapSimpleOutPatternElement[1];
	 * }
	 *   install mTmapIfExp_t2qvtrCondition_p3 {
	 * trace consumes ::jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * }
	 *   install mTmapNavigationOrAttributeCallExp__Helper_t2qvtrSou_p3 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install mTmapNavigationOrAttributeCallExp__Property_t2qvtrS_p3 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * }
	 *   install mTmapOperationCallExp__Helper_t2qvtrSourceArgument_p3 {
	 * trace consumes ::jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * }
	 *   install mTmapOperationCallExp__Operation_t2qvtrSource_p3 {
	 * trace consumes ::jm_TmapOperationCallExp__Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * }
	 *   install mTmapOperatorCallExp_t2qvtrSource_p3 {
	 * trace consumes ::jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * }
	 *   install mTmapIfExp_t2qvtrElse_p4 {
	 * trace consumes ::jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * }
	 *   install mTmapNavigationOrAttributeCallExp__Helper_t2qvtrTra_p4 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install mTmapOperationCallExp__Helper_t2qvtrTransformation_p4 {
	 * trace consumes ::jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * }
	 *   install mTmapIfExp_t2qvtrThen_p5 {
	 * trace consumes ::jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * }
	 *   install mTmapNavigationOrAttributeCallExp__Helper__type_p5 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install mTmapOperationCallExp__Helper__type_p5 {
	 * trace consumes ::jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * }
	 *   install mTmapBinding_t0propertyName_t1atlExpression_t1atlOu_p1 {
	 * trace consumes ::jm_TmapBinding : trace_ATL2QVTr::TmapBinding[1];
	 * }
	 *   install mTmapInPattern__filter_t1atlExpression_t1atlPattern_p1 {
	 * trace consumes ::jm_TmapInPattern__filter : trace_ATL2QVTr::TmapInPattern_filter[1];
	 * }
	 *   install mTmapOperationCallExp__argument_t1atlParent_t2qvtrA_p1 {
	 * trace consumes ::jm_TmapOperationCallExp__argument : trace_ATL2QVTr::TmapOperationCallExp_argument[1];
	 * }
	 *   install mTmapVariableExp__referredVariable__VariableDeclara_p1 {
	 * trace consumes ::jm_TmapVariableExp__referredVariable__VariableDecl : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1];
	 * }
	 *   install mTmapVariableExp__referredVariable__VariableDeclara_p2 {
	 * trace consumes ::jm_TmapVariableExp__referredVariable__VariableDecl : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1];
	 * }
	 *   install mTmapHelper__Attribute_wmapHelper_Context_p2 {
	 * jm_TmapHelper__Context appendsTo jm_TmapHelper__Context;
	 * trace consumes ::jm_TmapHelper__Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * }
	 *   install mTmapHelper__Operation_wmapHelper_Context_p2 {
	 * jm_TmapHelper__Context appendsTo jm_TmapHelper__Context;
	 * trace consumes ::jm_TmapHelper__Operation : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * }
	 *   install mTmapHelper__Attribute_t2qvtrExpression_p3 {
	 * trace consumes ::jm_TmapHelper__Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * }
	 *   install mTmapHelper__Operation_t2qvtrExpression_p3 {
	 * trace consumes ::jm_TmapHelper__Operation : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * }
	 *   install mTmapHelper__Attribute__type_p4 {
	 * trace consumes ::jm_TmapHelper__Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * }
	 *   install mTmapHelper__Operation__type_p4 {
	 * trace consumes ::jm_TmapHelper__Operation : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * }
	 *   install mTmapNavigationOrAttributeCallExp__Helper_t2qvtrOpe_p6 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install mTmapOperationCallExp__Helper_t2qvtrOperation_p6 {
	 * trace consumes ::jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * }
	 *   install mTmapNavigationOrAttributeCallExp__Helper__type_p7 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install mTmapOperationCallExp__Helper__type_p7 {
	 * trace consumes ::jm_TmapOperationCallExp__Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * }
	 *   install mTmapHelper__Context_t1atlContext_t1atlDefinition_t {
	 * jm_TmapVariable appendsTo jm_TmapVariable;
	 * trace consumes ::jm_TmapHelper__Context : trace_ATL2QVTr::TmapHelper_Context[1];
	 * }
	 *   install mTmapVariable_success {
	 * trace consumes ::jm_TmapVariable : trace_ATL2QVTr::TmapVariable[1];
	 * }
	 *   install mTmapVariableExp__referredVariable__VariableDeclara_p3 {
	 * trace consumes ::jm_TmapVariableExp__referredVariable__VariableDecl : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1];
	 * }
	 *   install mTmapVariableExp__referredVariable__VariableDeclara_p4 {
	 * trace consumes ::jm_TmapVariableExp__referredVariable__VariableDecl : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1];
	 * }
	 *   install mTmapVariableExp__referredVariable__Helper_success_p1 {
	 * trace consumes ::jm_TmapVariableExp__referredVariable__Helper : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * }
	 *   install mDmapVariableExp__referredVariable_success {
	 * mapVariableExp_referredVariable consumes ::jm_DmapVariableExp__referredVariable : trace_ATL2QVTr::DmapVariableExp_referredVariable[1];
	 * }
	 *   install mTmapVariableExp__referredVariable__Helper_t2qvtrVa_p3 {
	 * trace consumes ::jm_TmapVariableExp__referredVariable__Helper : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * }
	 *   install mTmapVariableExp__referredVariable__Helper__type_p4 {
	 * trace consumes ::jm_TmapVariableExp__referredVariable__Helper : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * }
	 *   install mTmapVariableExp__referredVariable__Helper__name_p5 {
	 * trace consumes ::jm_TmapVariableExp__referredVariable__Helper : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * }
	 *   install mTmapVariableExp__referredVariable__Helper_TmapVari_p2 {
	 * trace consumes ::jm_TmapVariableExp__referredVariable__Helper : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * }
	 *   install mTmapNavigationOrAttributeCallExp__Property__type_p5 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * }
	 *   install mTmapOperationCallExp__Operation__type_p5 {
	 * trace consumes ::jm_TmapOperationCallExp__Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * }
	 *   install mTmapOperatorCallExp__type_p5 {
	 * trace consumes ::jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * }
	 *   install mTmapIfExp__type_p6 {
	 * trace consumes ::jm_TmapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * }
	 *   install mTmapNavigationOrAttributeCallExp__Property__referr_p4 {
	 * trace consumes ::jm_TmapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * }
	 *   install mTmapOperationCallExp__Operation__referredOperation_p4 {
	 * trace consumes ::jm_TmapOperationCallExp__Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * }
	 *   install mTmapOperatorCallExp__referredOperation_p4 {
	 * trace consumes ::jm_TmapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * }
	 */
	protected class MAP___root__ extends AbstractInvocation
	{
		protected final @NonNull Connection ji_Binding;
		protected final @NonNull Connection ji_Helper;
		protected final @NonNull Connection ji_InPattern;
		protected final @NonNull Connection ji_MatchedRule;
		protected final @NonNull Connection ji_Module;
		protected final @NonNull Connection ji_OclExpression;
		protected final @NonNull Connection ji_OclModel;
		protected final @NonNull Connection ji_OutPattern;
		protected final @NonNull Connection ji_SimpleInPatternElement;
		protected final @NonNull Connection ji_SimpleOutPatternElement;

		public MAP___root__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			ji_Binding = (Connection)boundValues[0];
			ji_Helper = (Connection)boundValues[1];
			ji_InPattern = (Connection)boundValues[2];
			ji_MatchedRule = (Connection)boundValues[3];
			ji_Module = (Connection)boundValues[4];
			ji_OclExpression = (Connection)boundValues[5];
			ji_OclModel = (Connection)boundValues[6];
			ji_OutPattern = (Connection)boundValues[7];
			ji_SimpleInPatternElement = (Connection)boundValues[8];
			ji_SimpleOutPatternElement = (Connection)boundValues[9];
		}

		@Override
		public boolean execute()  {
			// connection variables
			final @NonNull Connection jm_DmapHelper_1 = createConnection("jm_DmapHelper", CLSSid_DmapHelper, false);
			final @NonNull Connection jm_DmapOclExpression_1 = createConnection("jm_DmapOclExpression", CLSSid_DmapOclExpression, false);
			final @NonNull Connection jm_DmapVariableExp__referredVariable_1 = createConnection("jm_DmapVariableExp__referredVariable", CLSSid_DmapVariableExp_referredVariable, false);
			final @NonNull Connection jm_TmapBinding_1 = createConnection("jm_TmapBinding", CLSSid_TmapBinding, false);
			final @NonNull Connection jm_TmapBooleanExp_1 = createConnection("jm_TmapBooleanExp", CLSSid_TmapBooleanExp, false);
			final @NonNull Connection jm_TmapHelper__Attribute_1 = createConnection("jm_TmapHelper__Attribute", CLSSid_TmapHelper_Attribute, false);
			final @NonNull Connection jm_TmapHelper__Context_3 = createConnection("jm_TmapHelper__Context", CLSSid_TmapHelper_Context, false);
			final @NonNull Connection jm_TmapHelper__Operation_1 = createConnection("jm_TmapHelper__Operation", CLSSid_TmapHelper_Operation, false);
			final @NonNull Connection jm_TmapIfExp_1 = createConnection("jm_TmapIfExp", CLSSid_TmapIfExp, false);
			final @NonNull Connection jm_TmapInPattern_1 = createConnection("jm_TmapInPattern", CLSSid_TmapInPattern, false);
			final @NonNull Connection jm_TmapInPattern__filter_1 = createConnection("jm_TmapInPattern__filter", CLSSid_TmapInPattern_filter, false);
			final @NonNull Connection jm_TmapIntegerExp_1 = createConnection("jm_TmapIntegerExp", CLSSid_TmapIntegerExp, false);
			final @NonNull Connection jm_TmapMatchedRule_1 = createConnection("jm_TmapMatchedRule", CLSSid_TmapMatchedRule, false);
			final @NonNull Connection jm_TmapMatchedRule__super_1 = createConnection("jm_TmapMatchedRule__super", CLSSid_TmapMatchedRule_super, false);
			final @NonNull Connection jm_TmapModule_1 = createConnection("jm_TmapModule", CLSSid_TmapModule, false);
			final @NonNull Connection jm_TmapNavigationOrAttributeCallExp__Helper_1 = createConnection("jm_TmapNavigationOrAttributeCallExp__Helper", CLSSid_TmapNavigationOrAttributeCallExp_Helper, false);
			final @NonNull Connection jm_TmapNavigationOrAttributeCallExp__Property_1 = createConnection("jm_TmapNavigationOrAttributeCallExp__Property", CLSSid_TmapNavigationOrAttributeCallExp_Property, false);
			final @NonNull Connection jm_TmapOclMetamodel_1 = createConnection("jm_TmapOclMetamodel", CLSSid_TmapOclMetamodel, false);
			final @NonNull Connection jm_TmapOclModel__IN_1 = createConnection("jm_TmapOclModel__IN", CLSSid_TmapOclModel_IN, false);
			final @NonNull Connection jm_TmapOclModel__OUT_1 = createConnection("jm_TmapOclModel__OUT", CLSSid_TmapOclModel_OUT, false);
			final @NonNull Connection jm_TmapOperationCallExp__Helper_1 = createConnection("jm_TmapOperationCallExp__Helper", CLSSid_TmapOperationCallExp_Helper, false);
			final @NonNull Connection jm_TmapOperationCallExp__Operation_1 = createConnection("jm_TmapOperationCallExp__Operation", CLSSid_TmapOperationCallExp_Operation, false);
			final @NonNull Connection jm_TmapOperationCallExp__argument_1 = createConnection("jm_TmapOperationCallExp__argument", CLSSid_TmapOperationCallExp_argument, false);
			final @NonNull Connection jm_TmapOperatorCallExp_1 = createConnection("jm_TmapOperatorCallExp", CLSSid_TmapOperatorCallExp, false);
			final @NonNull Connection jm_TmapOutPattern_1 = createConnection("jm_TmapOutPattern", CLSSid_TmapOutPattern, false);
			final @NonNull Connection jm_TmapSimpleInPatternElement_1 = createConnection("jm_TmapSimpleInPatternElement", CLSSid_TmapSimpleInPatternElement, false);
			final @NonNull Connection jm_TmapSimpleOutPatternElement_1 = createConnection("jm_TmapSimpleOutPatternElement", CLSSid_TmapSimpleOutPatternElement, false);
			final @NonNull Connection jm_TmapStringExp_1 = createConnection("jm_TmapStringExp", CLSSid_TmapStringExp, false);
			final @NonNull Connection jm_TmapVariable_5 = createConnection("jm_TmapVariable", CLSSid_TmapVariable, false);
			final @NonNull Connection jm_TmapVariableExp_1 = createConnection("jm_TmapVariableExp", CLSSid_TmapVariableExp, false);
			final @NonNull Connection jm_TmapVariableExp__referredVariable__Helper_1 = createConnection("jm_TmapVariableExp__referredVariable__Helper", CLSSid_TmapVariableExp_referredVariable_Helper, false);
			final @NonNull Connection jm_TmapVariableExp__referredVariable__VariableDecl_1 = createConnection("jm_TmapVariableExp__referredVariable__VariableDecl", CLSSid_TmapVariableExp_referredVariable_VariableDeclaration, false);
			// mapping statements
			for (@NonNull Helper atlHelper_0 : ji_Helper.typedIterable(Helper.class)) {
				MAP_mHelper_DmapHelper(atlHelper_0, jm_DmapHelper_1, jm_TmapHelper__Attribute_1, jm_TmapHelper__Operation_1);
			}
			for (@NonNull OclExpression atlExpression_0 : ji_OclExpression.typedIterable(OclExpression.class)) {
				MAP_mOclExpression_DmapOclExpression(atlExpression_0, jm_DmapOclExpression_1, jm_TmapBooleanExp_1, jm_TmapIfExp_1, jm_TmapIntegerExp_1, jm_TmapNavigationOrAttributeCallExp__Helper_1, jm_TmapNavigationOrAttributeCallExp__Property_1, jm_TmapOperationCallExp__Helper_1, jm_TmapOperationCallExp__Operation_1, jm_TmapOperatorCallExp_1, jm_TmapStringExp_1, jm_TmapVariableExp_1);
			}
			for (@NonNull TmapBooleanExp trace_81 : jm_TmapBooleanExp_1.typedIterable(TmapBooleanExp.class)) {
				MAP_mTmapBooleanExp_success_t0symbol(trace_81);
			}
			for (@NonNull TmapIntegerExp trace_82 : jm_TmapIntegerExp_1.typedIterable(TmapIntegerExp.class)) {
				MAP_mTmapIntegerExp_success_t0symbol(trace_82);
			}
			for (@NonNull TmapStringExp trace_83 : jm_TmapStringExp_1.typedIterable(TmapStringExp.class)) {
				MAP_mTmapStringExp_success_t0symbol(trace_83);
			}
			for (@NonNull TmapIfExp trace_84 : jm_TmapIfExp_1.typedIterable(TmapIfExp.class)) {
				MAP_mTmapIfExp_t1atlCondition_t1atlElse_t1atlThen_p0(trace_84);
			}
			for (@NonNull TmapIfExp trace_85 : jm_TmapIfExp_1.typedIterable(TmapIfExp.class)) {
				MAP_mTmapIfExp_success_wmapOclExpression_wmapOclExpress_p1(trace_85);
			}
			for (@NonNull TmapIfExp trace_86 : jm_TmapIfExp_1.typedIterable(TmapIfExp.class)) {
				MAP_mTmapIfExp__DmapOclExpression_d2qvtrExpression_p2(trace_86);
			}
			for (@NonNull TmapNavigationOrAttributeCallExp_Helper trace_87 : jm_TmapNavigationOrAttributeCallExp__Helper_1.typedIterable(TmapNavigationOrAttributeCallExp_Helper.class)) {
				MAP_mTmapNavigationOrAttributeCallExp__Helper_t0propert_p0(trace_87);
			}
			for (@NonNull TmapNavigationOrAttributeCallExp_Property trace_88 : jm_TmapNavigationOrAttributeCallExp__Property_1.typedIterable(TmapNavigationOrAttributeCallExp_Property.class)) {
				MAP_mTmapNavigationOrAttributeCallExp__Property_t0prope_p0(trace_88);
			}
			for (@NonNull TmapNavigationOrAttributeCallExp_Property trace_89 : jm_TmapNavigationOrAttributeCallExp__Property_1.typedIterable(TmapNavigationOrAttributeCallExp_Property.class)) {
				MAP_mTmapNavigationOrAttributeCallExp__Property_success_p1(trace_89);
			}
			for (@NonNull TmapNavigationOrAttributeCallExp_Property trace_90 : jm_TmapNavigationOrAttributeCallExp__Property_1.typedIterable(TmapNavigationOrAttributeCallExp_Property.class)) {
				MAP_mTmapNavigationOrAttributeCallExp__Property__DmapOc_p2(trace_90);
			}
			for (@NonNull TmapOperationCallExp_Helper trace_91 : jm_TmapOperationCallExp__Helper_1.typedIterable(TmapOperationCallExp_Helper.class)) {
				MAP_mTmapOperationCallExp__Helper_t0operationName_t1atl_p0(trace_91);
			}
			for (@NonNull TmapOperationCallExp_Operation trace_92 : jm_TmapOperationCallExp__Operation_1.typedIterable(TmapOperationCallExp_Operation.class)) {
				MAP_mTmapOperationCallExp__Operation_t0operationName_t1_p0(trace_92);
			}
			for (@NonNull TmapOperationCallExp_Operation trace_93 : jm_TmapOperationCallExp__Operation_1.typedIterable(TmapOperationCallExp_Operation.class)) {
				MAP_mTmapOperationCallExp__Operation_success_wmapOclExp_p1(trace_93);
			}
			for (@NonNull TmapOperationCallExp_Operation trace_94 : jm_TmapOperationCallExp__Operation_1.typedIterable(TmapOperationCallExp_Operation.class)) {
				MAP_mTmapOperationCallExp__Operation__DmapOclExpression_p2(trace_94);
			}
			for (@NonNull TmapOperatorCallExp trace_95 : jm_TmapOperatorCallExp_1.typedIterable(TmapOperatorCallExp.class)) {
				MAP_mTmapOperatorCallExp_t0operationName_t1atlSource_p0(trace_95);
			}
			for (@NonNull TmapVariableExp trace_96 : jm_TmapVariableExp_1.typedIterable(TmapVariableExp.class)) {
				MAP_mTmapVariableExp_success_t0varName_t1atlVariable_wm(jm_DmapVariableExp__referredVariable_1, trace_96);
			}
			for (@NonNull DmapVariableExp_referredVariable dispatcher_0 : jm_DmapVariableExp__referredVariable_1.typedIterable(DmapVariableExp_referredVariable.class)) {
				MAP_mDmapVariableExp__referredVariable_domapVariableExp(dispatcher_0, jm_TmapVariableExp__referredVariable__Helper_1, jm_TmapVariableExp__referredVariable__VariableDecl_1);
			}
			for (@NonNull TmapVariableExp_referredVariable_Helper trace_97 : jm_TmapVariableExp__referredVariable__Helper_1.typedIterable(TmapVariableExp_referredVariable_Helper.class)) {
				MAP_mTmapVariableExp__referredVariable__Helper_t1atlVar_p0(trace_97);
			}
			for (@NonNull TmapVariableExp_referredVariable_VariableDeclaration trace_98 : jm_TmapVariableExp__referredVariable__VariableDecl_1.typedIterable(TmapVariableExp_referredVariable_VariableDeclaration.class)) {
				MAP_mTmapVariableExp__referredVariable__VariableDeclara_p0(trace_98);
			}
			for (@NonNull Binding atlBinding_0 : ji_Binding.typedIterable(Binding.class)) {
				MAP_mBinding_TmapBinding_p0(atlBinding_0, jm_TmapBinding_1);
			}
			for (@NonNull MatchedRule atlRule_0 : ji_MatchedRule.typedIterable(MatchedRule.class)) {
				MAP_mMatchedRule__t1atlRule_p0(atlRule_0, jm_TmapInPattern__filter_1);
			}
			for (@NonNull InPattern atlPattern_1 : ji_InPattern.typedIterable(InPattern.class)) {
				MAP_mInPattern_TmapInPattern_p0(atlPattern_1, jm_TmapInPattern_1);
			}
			for (@NonNull MatchedRule matchedRule_0 : ji_MatchedRule.typedIterable(MatchedRule.class)) {
				MAP_mMatchedRule_TmapMatchedRule_p0(jm_TmapMatchedRule_1, matchedRule_0);
			}
			for (@NonNull MatchedRule atlChildRule_0 : ji_MatchedRule.typedIterable(MatchedRule.class)) {
				MAP_mMatchedRule_TmapMatchedRule_super_p0(atlChildRule_0, jm_TmapMatchedRule__super_1);
			}
			for (@NonNull Module atlModule_1 : ji_Module.typedIterable(Module.class)) {
				MAP_mModule_TmapModule_p0(atlModule_1, jm_TmapModule_1);
			}
			for (@NonNull TmapModule trace_99 : jm_TmapModule_1.typedIterable(TmapModule.class)) {
				MAP_mTmapModule_t0txName_t2_1_t2_2_t2_3_t2_4_t2qvtrTran_p1(trace_99);
			}
			for (@NonNull TmapMatchedRule trace_100 : jm_TmapMatchedRule_1.typedIterable(TmapMatchedRule.class)) {
				MAP_mTmapMatchedRule_success_t0ruleName_t1atlModule_t2__p1(trace_100);
			}
			for (@NonNull TmapMatchedRule_super trace_101 : jm_TmapMatchedRule__super_1.typedIterable(TmapMatchedRule_super.class)) {
				MAP_mTmapMatchedRule__super_t1atlSuperRule_t2qvtrOverri_p1(trace_101);
			}
			for (@NonNull TmapNavigationOrAttributeCallExp_Helper trace_102 : jm_TmapNavigationOrAttributeCallExp__Helper_1.typedIterable(TmapNavigationOrAttributeCallExp_Helper.class)) {
				MAP_mTmapNavigationOrAttributeCallExp__Helper_success_w_p1(trace_102);
			}
			for (@NonNull TmapNavigationOrAttributeCallExp_Helper trace_103 : jm_TmapNavigationOrAttributeCallExp__Helper_1.typedIterable(TmapNavigationOrAttributeCallExp_Helper.class)) {
				MAP_mTmapNavigationOrAttributeCallExp__Helper_t2qvtrSou_p2(trace_103);
			}
			for (@NonNull TmapOperationCallExp_Helper trace_104 : jm_TmapOperationCallExp__Helper_1.typedIterable(TmapOperationCallExp_Helper.class)) {
				MAP_mTmapOperationCallExp__Helper_success_wmapHelper_wm_p1(trace_104);
			}
			for (@NonNull TmapOperationCallExp_Helper trace_105 : jm_TmapOperationCallExp__Helper_1.typedIterable(TmapOperationCallExp_Helper.class)) {
				MAP_mTmapOperationCallExp__Helper_t2qvtrSource_p2(trace_105);
			}
			for (@NonNull TmapOperatorCallExp trace_106 : jm_TmapOperatorCallExp_1.typedIterable(TmapOperatorCallExp.class)) {
				MAP_mTmapOperatorCallExp_success_wmapModule_wmapOclExpr_p1(trace_106);
			}
			for (@NonNull DmapOclExpression mapOclExpression_0 : jm_DmapOclExpression_1.typedIterable(DmapOclExpression.class)) {
				MAP_mDmapOclExpression_success(mapOclExpression_0);
			}
			for (@NonNull TmapOperatorCallExp trace_107 : jm_TmapOperatorCallExp_1.typedIterable(TmapOperatorCallExp.class)) {
				MAP_mTmapOperatorCallExp_t2qvtrTransformation_p6(trace_107);
			}
			for (@NonNull TmapOperatorCallExp trace_108 : jm_TmapOperatorCallExp_1.typedIterable(TmapOperatorCallExp.class)) {
				MAP_mTmapOperatorCallExp__DmapOclExpression_d2qvtrExpre_p2(trace_108);
			}
			for (@NonNull TmapHelper_Attribute trace_109 : jm_TmapHelper__Attribute_1.typedIterable(TmapHelper_Attribute.class)) {
				MAP_mTmapHelper__Attribute_t0attributeName_t1atlDefinit_p0(trace_109);
			}
			for (@NonNull TmapHelper_Attribute trace_110 : jm_TmapHelper__Attribute_1.typedIterable(TmapHelper_Attribute.class)) {
				MAP_mTmapHelper__Attribute_success_wmapOclExpression_p1(trace_110);
			}
			for (@NonNull TmapHelper_Operation trace_111 : jm_TmapHelper__Operation_1.typedIterable(TmapHelper_Operation.class)) {
				MAP_mTmapHelper__Operation_t0operationName_t1atlDefinit_p0(trace_111);
			}
			for (@NonNull TmapHelper_Operation trace_112 : jm_TmapHelper__Operation_1.typedIterable(TmapHelper_Operation.class)) {
				MAP_mTmapHelper__Operation_success_wmapOclExpression_p1(trace_112);
			}
			for (@NonNull DmapHelper mapHelper_0 : jm_DmapHelper_1.typedIterable(DmapHelper.class)) {
				MAP_mDmapHelper_success(mapHelper_0);
			}
			for (@NonNull OclModel oclMetamodel_0 : ji_OclModel.typedIterable(OclModel.class)) {
				MAP_mOclModel_TmapOclMetamodel_p0(jm_TmapOclMetamodel_1, oclMetamodel_0);
			}
			for (@NonNull TmapOclMetamodel trace_113 : jm_TmapOclMetamodel_1.typedIterable(TmapOclMetamodel.class)) {
				MAP_mTmapOclMetamodel_t0tmName_t2qvtrTypedModel_p1(trace_113);
			}
			for (@NonNull TmapInPattern trace_114 : jm_TmapInPattern_1.typedIterable(TmapInPattern.class)) {
				MAP_mTmapInPattern_success_t1atlModel_t1atlRule_t2qvtrD_p1(trace_114);
			}
			for (@NonNull OclModel oclModel_1 : ji_OclModel.typedIterable(OclModel.class)) {
				MAP_mOclModel_TmapOclModel_IN_p0(jm_TmapOclModel__IN_1, oclModel_1);
			}
			for (@NonNull TmapOclModel_IN trace_115 : jm_TmapOclModel__IN_1.typedIterable(TmapOclModel_IN.class)) {
				MAP_mTmapOclModel__IN_t0tmName_t1atlModule_t1oclMetamod_p1(trace_115);
			}
			for (@NonNull OclModel oclModel_2 : ji_OclModel.typedIterable(OclModel.class)) {
				MAP_mOclModel_TmapOclModel_OUT_p0(jm_TmapOclModel__OUT_1, oclModel_2);
			}
			for (@NonNull TmapOclModel_OUT trace_116 : jm_TmapOclModel__OUT_1.typedIterable(TmapOclModel_OUT.class)) {
				MAP_mTmapOclModel__OUT_t0tmName_t1atlModule_t1oclMetamo_p1(trace_116);
			}
			for (@NonNull OclExpression atlArgument_0 : ji_OclExpression.typedIterable(OclExpression.class)) {
				MAP_mOclExpression_TmapOperationCallExp_argument_p0(atlArgument_0, jm_TmapOperationCallExp__argument_1);
			}
			for (@NonNull OutPattern atlPattern_2 : ji_OutPattern.typedIterable(OutPattern.class)) {
				MAP_mOutPattern_TmapOutPattern_p0(atlPattern_2, jm_TmapOutPattern_1);
			}
			for (@NonNull TmapOutPattern trace_117 : jm_TmapOutPattern_1.typedIterable(TmapOutPattern.class)) {
				MAP_mTmapOutPattern_success_t1atlRule_t2qvtrDomain_t2qv_p1(trace_117);
			}
			for (@NonNull SimpleInPatternElement atlElement_1 : ji_SimpleInPatternElement.typedIterable(SimpleInPatternElement.class)) {
				MAP_mSimpleInPatternElement_TmapSimpleInPatternElement_p0(atlElement_1, jm_TmapSimpleInPatternElement_1);
			}
			for (@NonNull SimpleOutPatternElement atlElement_2 : ji_SimpleOutPatternElement.typedIterable(SimpleOutPatternElement.class)) {
				MAP_mSimpleOutPatternElement_TmapSimpleOutPatternElemen_p0(atlElement_2, jm_TmapSimpleOutPatternElement_1);
			}
			for (@NonNull TmapSimpleInPatternElement trace_118 : jm_TmapSimpleInPatternElement_1.typedIterable(TmapSimpleInPatternElement.class)) {
				MAP_mTmapSimpleInPatternElement_t0elementName_t1atlPatt_p1(jm_TmapVariable_5, trace_118);
			}
			for (@NonNull TmapSimpleOutPatternElement trace_119 : jm_TmapSimpleOutPatternElement_1.typedIterable(TmapSimpleOutPatternElement.class)) {
				MAP_mTmapSimpleOutPatternElement_success_t0elementName__p1(jm_TmapVariable_5, trace_119);
			}
			for (@NonNull TmapIfExp trace_120 : jm_TmapIfExp_1.typedIterable(TmapIfExp.class)) {
				MAP_mTmapIfExp_t2qvtrCondition_p3(trace_120);
			}
			for (@NonNull TmapNavigationOrAttributeCallExp_Helper trace_121 : jm_TmapNavigationOrAttributeCallExp__Helper_1.typedIterable(TmapNavigationOrAttributeCallExp_Helper.class)) {
				MAP_mTmapNavigationOrAttributeCallExp__Helper_t2qvtrSou_p3(trace_121);
			}
			for (@NonNull TmapNavigationOrAttributeCallExp_Property trace_122 : jm_TmapNavigationOrAttributeCallExp__Property_1.typedIterable(TmapNavigationOrAttributeCallExp_Property.class)) {
				MAP_mTmapNavigationOrAttributeCallExp__Property_t2qvtrS_p3(trace_122);
			}
			for (@NonNull TmapOperationCallExp_Helper trace_123 : jm_TmapOperationCallExp__Helper_1.typedIterable(TmapOperationCallExp_Helper.class)) {
				MAP_mTmapOperationCallExp__Helper_t2qvtrSourceArgument_p3(trace_123);
			}
			for (@NonNull TmapOperationCallExp_Operation trace_124 : jm_TmapOperationCallExp__Operation_1.typedIterable(TmapOperationCallExp_Operation.class)) {
				MAP_mTmapOperationCallExp__Operation_t2qvtrSource_p3(trace_124);
			}
			for (@NonNull TmapOperatorCallExp trace_125 : jm_TmapOperatorCallExp_1.typedIterable(TmapOperatorCallExp.class)) {
				MAP_mTmapOperatorCallExp_t2qvtrSource_p3(trace_125);
			}
			for (@NonNull TmapIfExp trace_126 : jm_TmapIfExp_1.typedIterable(TmapIfExp.class)) {
				MAP_mTmapIfExp_t2qvtrElse_p4(trace_126);
			}
			for (@NonNull TmapNavigationOrAttributeCallExp_Helper trace_127 : jm_TmapNavigationOrAttributeCallExp__Helper_1.typedIterable(TmapNavigationOrAttributeCallExp_Helper.class)) {
				MAP_mTmapNavigationOrAttributeCallExp__Helper_t2qvtrTra_p4(trace_127);
			}
			for (@NonNull TmapOperationCallExp_Helper trace_128 : jm_TmapOperationCallExp__Helper_1.typedIterable(TmapOperationCallExp_Helper.class)) {
				MAP_mTmapOperationCallExp__Helper_t2qvtrTransformation_p4(trace_128);
			}
			for (@NonNull TmapIfExp trace_129 : jm_TmapIfExp_1.typedIterable(TmapIfExp.class)) {
				MAP_mTmapIfExp_t2qvtrThen_p5(trace_129);
			}
			for (@NonNull TmapNavigationOrAttributeCallExp_Helper trace_130 : jm_TmapNavigationOrAttributeCallExp__Helper_1.typedIterable(TmapNavigationOrAttributeCallExp_Helper.class)) {
				MAP_mTmapNavigationOrAttributeCallExp__Helper__type_p5(trace_130);
			}
			for (@NonNull TmapOperationCallExp_Helper trace_131 : jm_TmapOperationCallExp__Helper_1.typedIterable(TmapOperationCallExp_Helper.class)) {
				MAP_mTmapOperationCallExp__Helper__type_p5(trace_131);
			}
			for (@NonNull TmapBinding trace_132 : jm_TmapBinding_1.typedIterable(TmapBinding.class)) {
				MAP_mTmapBinding_t0propertyName_t1atlExpression_t1atlOu_p1(trace_132);
			}
			for (@NonNull TmapInPattern_filter trace_133 : jm_TmapInPattern__filter_1.typedIterable(TmapInPattern_filter.class)) {
				MAP_mTmapInPattern__filter_t1atlExpression_t1atlPattern_p1(trace_133);
			}
			for (@NonNull TmapOperationCallExp_argument trace_134 : jm_TmapOperationCallExp__argument_1.typedIterable(TmapOperationCallExp_argument.class)) {
				MAP_mTmapOperationCallExp__argument_t1atlParent_t2qvtrA_p1(trace_134);
			}
			for (@NonNull TmapVariableExp_referredVariable_VariableDeclaration trace_135 : jm_TmapVariableExp__referredVariable__VariableDecl_1.typedIterable(TmapVariableExp_referredVariable_VariableDeclaration.class)) {
				MAP_mTmapVariableExp__referredVariable__VariableDeclara_p1(trace_135);
			}
			for (@NonNull TmapVariableExp_referredVariable_VariableDeclaration trace_136 : jm_TmapVariableExp__referredVariable__VariableDecl_1.typedIterable(TmapVariableExp_referredVariable_VariableDeclaration.class)) {
				MAP_mTmapVariableExp__referredVariable__VariableDeclara_p2(trace_136);
			}
			for (@NonNull TmapHelper_Attribute trace_137 : jm_TmapHelper__Attribute_1.typedIterable(TmapHelper_Attribute.class)) {
				MAP_mTmapHelper__Attribute_wmapHelper_Context_p2(jm_TmapHelper__Context_3, trace_137);
			}
			for (@NonNull TmapHelper_Operation trace_138 : jm_TmapHelper__Operation_1.typedIterable(TmapHelper_Operation.class)) {
				MAP_mTmapHelper__Operation_wmapHelper_Context_p2(jm_TmapHelper__Context_3, trace_138);
			}
			for (@NonNull TmapHelper_Attribute trace_139 : jm_TmapHelper__Attribute_1.typedIterable(TmapHelper_Attribute.class)) {
				MAP_mTmapHelper__Attribute_t2qvtrExpression_p3(trace_139);
			}
			for (@NonNull TmapHelper_Operation trace_140 : jm_TmapHelper__Operation_1.typedIterable(TmapHelper_Operation.class)) {
				MAP_mTmapHelper__Operation_t2qvtrExpression_p3(trace_140);
			}
			for (@NonNull TmapHelper_Attribute trace_141 : jm_TmapHelper__Attribute_1.typedIterable(TmapHelper_Attribute.class)) {
				MAP_mTmapHelper__Attribute__type_p4(trace_141);
			}
			for (@NonNull TmapHelper_Operation trace_142 : jm_TmapHelper__Operation_1.typedIterable(TmapHelper_Operation.class)) {
				MAP_mTmapHelper__Operation__type_p4(trace_142);
			}
			for (@NonNull TmapNavigationOrAttributeCallExp_Helper trace_143 : jm_TmapNavigationOrAttributeCallExp__Helper_1.typedIterable(TmapNavigationOrAttributeCallExp_Helper.class)) {
				MAP_mTmapNavigationOrAttributeCallExp__Helper_t2qvtrOpe_p6(trace_143);
			}
			for (@NonNull TmapOperationCallExp_Helper trace_144 : jm_TmapOperationCallExp__Helper_1.typedIterable(TmapOperationCallExp_Helper.class)) {
				MAP_mTmapOperationCallExp__Helper_t2qvtrOperation_p6(trace_144);
			}
			for (@NonNull TmapNavigationOrAttributeCallExp_Helper trace_145 : jm_TmapNavigationOrAttributeCallExp__Helper_1.typedIterable(TmapNavigationOrAttributeCallExp_Helper.class)) {
				MAP_mTmapNavigationOrAttributeCallExp__Helper__type_p7(trace_145);
			}
			for (@NonNull TmapOperationCallExp_Helper trace_146 : jm_TmapOperationCallExp__Helper_1.typedIterable(TmapOperationCallExp_Helper.class)) {
				MAP_mTmapOperationCallExp__Helper__type_p7(trace_146);
			}
			for (@NonNull TmapHelper_Context trace_147 : jm_TmapHelper__Context_3.typedIterable(TmapHelper_Context.class)) {
				MAP_mTmapHelper__Context_t1atlContext_t1atlDefinition_t(jm_TmapVariable_5, trace_147);
			}
			for (@NonNull TmapVariable trace_148 : jm_TmapVariable_5.typedIterable(TmapVariable.class)) {
				MAP_mTmapVariable_success(trace_148);
			}
			for (@NonNull TmapVariableExp_referredVariable_VariableDeclaration trace_149 : jm_TmapVariableExp__referredVariable__VariableDecl_1.typedIterable(TmapVariableExp_referredVariable_VariableDeclaration.class)) {
				MAP_mTmapVariableExp__referredVariable__VariableDeclara_p3(trace_149);
			}
			for (@NonNull TmapVariableExp_referredVariable_VariableDeclaration trace_150 : jm_TmapVariableExp__referredVariable__VariableDecl_1.typedIterable(TmapVariableExp_referredVariable_VariableDeclaration.class)) {
				MAP_mTmapVariableExp__referredVariable__VariableDeclara_p4(trace_150);
			}
			for (@NonNull TmapVariableExp_referredVariable_Helper trace_151 : jm_TmapVariableExp__referredVariable__Helper_1.typedIterable(TmapVariableExp_referredVariable_Helper.class)) {
				MAP_mTmapVariableExp__referredVariable__Helper_success_p1(trace_151);
			}
			for (@NonNull DmapVariableExp_referredVariable mapVariableExp_referredVariable_0 : jm_DmapVariableExp__referredVariable_1.typedIterable(DmapVariableExp_referredVariable.class)) {
				MAP_mDmapVariableExp__referredVariable_success(mapVariableExp_referredVariable_0);
			}
			for (@NonNull TmapVariableExp_referredVariable_Helper trace_152 : jm_TmapVariableExp__referredVariable__Helper_1.typedIterable(TmapVariableExp_referredVariable_Helper.class)) {
				MAP_mTmapVariableExp__referredVariable__Helper_t2qvtrVa_p3(trace_152);
			}
			for (@NonNull TmapVariableExp_referredVariable_Helper trace_153 : jm_TmapVariableExp__referredVariable__Helper_1.typedIterable(TmapVariableExp_referredVariable_Helper.class)) {
				MAP_mTmapVariableExp__referredVariable__Helper__type_p4(trace_153);
			}
			for (@NonNull TmapVariableExp_referredVariable_Helper trace_154 : jm_TmapVariableExp__referredVariable__Helper_1.typedIterable(TmapVariableExp_referredVariable_Helper.class)) {
				MAP_mTmapVariableExp__referredVariable__Helper__name_p5(trace_154);
			}
			for (@NonNull TmapVariableExp_referredVariable_Helper trace_155 : jm_TmapVariableExp__referredVariable__Helper_1.typedIterable(TmapVariableExp_referredVariable_Helper.class)) {
				MAP_mTmapVariableExp__referredVariable__Helper_TmapVari_p2(trace_155);
			}
			invocationManager.flush();
			CTOR_mTmapNavigationOrAttributeCallExp__Property__type_p5.addConsumedConnection(jm_TmapNavigationOrAttributeCallExp__Property_1);
			invocationManager.flush();
			invocationManager.flush();
			CTOR_mTmapOperationCallExp__Operation__type_p5.addConsumedConnection(jm_TmapOperationCallExp__Operation_1);
			invocationManager.flush();
			invocationManager.flush();
			CTOR_mTmapOperatorCallExp__type_p5.addConsumedConnection(jm_TmapOperatorCallExp_1);
			invocationManager.flush();
			invocationManager.flush();
			CTOR_mTmapIfExp__type_p6.addConsumedConnection(jm_TmapIfExp_1);
			invocationManager.flush();
			for (@NonNull TmapNavigationOrAttributeCallExp_Property trace_160 : jm_TmapNavigationOrAttributeCallExp__Property_1.typedIterable(TmapNavigationOrAttributeCallExp_Property.class)) {
				MAP_mTmapNavigationOrAttributeCallExp__Property__referr_p4(trace_160);
			}
			for (@NonNull TmapOperationCallExp_Operation trace_161 : jm_TmapOperationCallExp__Operation_1.typedIterable(TmapOperationCallExp_Operation.class)) {
				MAP_mTmapOperationCallExp__Operation__referredOperation_p4(trace_161);
			}
			for (@NonNull TmapOperatorCallExp trace_162 : jm_TmapOperatorCallExp_1.typedIterable(TmapOperatorCallExp.class)) {
				MAP_mTmapOperatorCallExp__referredOperation_p4(trace_162);
			}
			final /*@Thrown*/ @Nullable Boolean __root__ = ValueUtil.TRUE_VALUE;
			return __root__;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(ji_Binding, thoseValues[0])
				&& idResolver.oclEquals(ji_Helper, thoseValues[1])
				&& idResolver.oclEquals(ji_InPattern, thoseValues[2])
				&& idResolver.oclEquals(ji_MatchedRule, thoseValues[3])
				&& idResolver.oclEquals(ji_Module, thoseValues[4])
				&& idResolver.oclEquals(ji_OclExpression, thoseValues[5])
				&& idResolver.oclEquals(ji_OclModel, thoseValues[6])
				&& idResolver.oclEquals(ji_OutPattern, thoseValues[7])
				&& idResolver.oclEquals(ji_SimpleInPatternElement, thoseValues[8])
				&& idResolver.oclEquals(ji_SimpleOutPatternElement, thoseValues[9]);
		}
	}

	/**
	 *
	 * map mHelper_DmapHelper in ATL2QVTr {
	 * guard:atl atlHelper : ATL::Helper[1];
	 * append jm_DmapHelper  : trace_ATL2QVTr::DmapHelper[1];
	 * append jm_TmapHelper__Operation  : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * append jm_TmapHelper__Attribute  : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * new:middle dispatcher : trace_ATL2QVTr::DmapHelper[1];
	 * new:middle mapHelper_Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * new:middle mapHelper_Operation : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * set dispatcher.d1atlHelper := atlHelper;
	 * set dispatcher.domapHelper_Attribute := mapHelper_Attribute;
	 * set dispatcher.domapHelper_Operation := mapHelper_Operation;
	 * add jm_TmapHelper__Attribute += mapHelper_Attribute;
	 * add jm_DmapHelper += dispatcher;
	 * add jm_TmapHelper__Operation += mapHelper_Operation;
	 *
	 */
	protected boolean MAP_mHelper_DmapHelper(final /*@NonInvalid*/ @NonNull Helper atlHelper, final @NonNull Connection jm_DmapHelper, final @NonNull Connection jm_TmapHelper__Attribute, final @NonNull Connection jm_TmapHelper__Operation)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mHelper_DmapHelper" + ", " + atlHelper + ", " + jm_DmapHelper + ", " + jm_TmapHelper__Attribute + ", " + jm_TmapHelper__Operation);
		}
		// creations
		final @SuppressWarnings("null")@NonNull DmapHelper dispatcher_0 = trace_ATL2QVTrFactory.eINSTANCE.createDmapHelper();
		models[2/*middle*/].add(dispatcher_0, false);
		final @SuppressWarnings("null")@NonNull TmapHelper_Attribute mapHelper_Attribute = trace_ATL2QVTrFactory.eINSTANCE.createTmapHelper_Attribute();
		models[2/*middle*/].add(mapHelper_Attribute, false);
		final @SuppressWarnings("null")@NonNull TmapHelper_Operation mapHelper_Operation = trace_ATL2QVTrFactory.eINSTANCE.createTmapHelper_Operation();
		models[2/*middle*/].add(mapHelper_Operation, false);
		// mapping statements
		OPPOSITE_OF_DmapHelper_d1atlHelper.put(atlHelper, dispatcher_0);
		dispatcher_0.setD1atlHelper(atlHelper);
		dispatcher_0.setDomapHelper_Attribute(mapHelper_Attribute);
		dispatcher_0.setDomapHelper_Operation(mapHelper_Operation);
		jm_TmapHelper__Attribute.appendElement(mapHelper_Attribute);
		jm_DmapHelper.appendElement(dispatcher_0);
		jm_TmapHelper__Operation.appendElement(mapHelper_Operation);
		final /*@Thrown*/ @Nullable Boolean mHelper_DmapHelper = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mHelper_DmapHelper ? "done "  : "fail ") + "MAP_mHelper_DmapHelper");
		}
		return mHelper_DmapHelper;
	}

	/**
	 *
	 * map mOclExpression_DmapOclExpression in ATL2QVTr {
	 * guard:atl atlExpression : OCL::OclExpression[1];
	 * append jm_TmapNavigationOrAttributeCallExp__Helper  : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * append jm_TmapOperatorCallExp  : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * append jm_DmapOclExpression  : trace_ATL2QVTr::DmapOclExpression[1];
	 * append jm_TmapOperationCallExp__Operation  : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * append jm_TmapBooleanExp  : trace_ATL2QVTr::TmapBooleanExp[1];
	 * append jm_TmapIntegerExp  : trace_ATL2QVTr::TmapIntegerExp[1];
	 * append jm_TmapNavigationOrAttributeCallExp__Property  : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * append jm_TmapVariableExp  : trace_ATL2QVTr::TmapVariableExp[1];
	 * append jm_TmapOperationCallExp__Helper  : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * append jm_TmapIfExp  : trace_ATL2QVTr::TmapIfExp[1];
	 * append jm_TmapStringExp  : trace_ATL2QVTr::TmapStringExp[1];
	 * new:middle dispatcher : trace_ATL2QVTr::DmapOclExpression[1];
	 * new:middle mapBooleanExp : trace_ATL2QVTr::TmapBooleanExp[1];
	 * new:middle mapIfExp : trace_ATL2QVTr::TmapIfExp[1];
	 * new:middle mapIntegerExp : trace_ATL2QVTr::TmapIntegerExp[1];
	 * new:middle mapNavigationOrAttributeCallExp_Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * new:middle mapNavigationOrAttributeCallExp_Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
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
	 * set dispatcher.domapOperationCallExp_Helper := mapOperationCallExp_Helper;
	 * set dispatcher.domapOperationCallExp_Operation := mapOperationCallExp_Operation;
	 * set dispatcher.domapOperatorCallExp := mapOperatorCallExp;
	 * set dispatcher.domapStringExp := mapStringExp;
	 * set dispatcher.domapVariableExp := mapVariableExp;
	 * add jm_TmapOperationCallExp__Operation += mapOperationCallExp_Operation;
	 * add jm_TmapBooleanExp += mapBooleanExp;
	 * add jm_TmapNavigationOrAttributeCallExp__Helper += mapNavigationOrAttributeCallExp_Helper;
	 * add jm_TmapOperatorCallExp += mapOperatorCallExp;
	 * add jm_TmapIntegerExp += mapIntegerExp;
	 * add jm_TmapNavigationOrAttributeCallExp__Property += mapNavigationOrAttributeCallExp_Property;
	 * add jm_TmapVariableExp += mapVariableExp;
	 * add jm_TmapOperationCallExp__Helper += mapOperationCallExp_Helper;
	 * add jm_TmapIfExp += mapIfExp;
	 * add jm_DmapOclExpression += dispatcher;
	 * add jm_TmapStringExp += mapStringExp;
	 *
	 */
	protected boolean MAP_mOclExpression_DmapOclExpression(final /*@NonInvalid*/ @NonNull OclExpression atlExpression, final @NonNull Connection jm_DmapOclExpression, final @NonNull Connection jm_TmapBooleanExp, final @NonNull Connection jm_TmapIfExp, final @NonNull Connection jm_TmapIntegerExp, final @NonNull Connection jm_TmapNavigationOrAttributeCallExp__Helper, final @NonNull Connection jm_TmapNavigationOrAttributeCallExp__Property, final @NonNull Connection jm_TmapOperationCallExp__Helper, final @NonNull Connection jm_TmapOperationCallExp__Operation, final @NonNull Connection jm_TmapOperatorCallExp, final @NonNull Connection jm_TmapStringExp, final @NonNull Connection jm_TmapVariableExp)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mOclExpression_DmapOclExpression" + ", " + atlExpression + ", " + jm_DmapOclExpression + ", " + jm_TmapBooleanExp + ", " + jm_TmapIfExp + ", " + jm_TmapIntegerExp + ", " + jm_TmapNavigationOrAttributeCallExp__Helper + ", " + jm_TmapNavigationOrAttributeCallExp__Property + ", " + jm_TmapOperationCallExp__Helper + ", " + jm_TmapOperationCallExp__Operation + ", " + jm_TmapOperatorCallExp + ", " + jm_TmapStringExp + ", " + jm_TmapVariableExp);
		}
		// creations
		final @SuppressWarnings("null")@NonNull DmapOclExpression dispatcher_0 = trace_ATL2QVTrFactory.eINSTANCE.createDmapOclExpression();
		models[2/*middle*/].add(dispatcher_0, false);
		final @SuppressWarnings("null")@NonNull TmapBooleanExp mapBooleanExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapBooleanExp();
		models[2/*middle*/].add(mapBooleanExp, false);
		final @SuppressWarnings("null")@NonNull TmapIfExp mapIfExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapIfExp();
		models[2/*middle*/].add(mapIfExp, false);
		final @SuppressWarnings("null")@NonNull TmapIntegerExp mapIntegerExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapIntegerExp();
		models[2/*middle*/].add(mapIntegerExp, false);
		final @SuppressWarnings("null")@NonNull TmapNavigationOrAttributeCallExp_Helper mapNavigationOrAttributeCallExp_Helper = trace_ATL2QVTrFactory.eINSTANCE.createTmapNavigationOrAttributeCallExp_Helper();
		models[2/*middle*/].add(mapNavigationOrAttributeCallExp_Helper, false);
		final @SuppressWarnings("null")@NonNull TmapNavigationOrAttributeCallExp_Property mapNavigationOrAttributeCallExp_Property = trace_ATL2QVTrFactory.eINSTANCE.createTmapNavigationOrAttributeCallExp_Property();
		models[2/*middle*/].add(mapNavigationOrAttributeCallExp_Property, false);
		final @SuppressWarnings("null")@NonNull TmapOperationCallExp_Helper mapOperationCallExp_Helper = trace_ATL2QVTrFactory.eINSTANCE.createTmapOperationCallExp_Helper();
		models[2/*middle*/].add(mapOperationCallExp_Helper, false);
		final @SuppressWarnings("null")@NonNull TmapOperationCallExp_Operation mapOperationCallExp_Operation = trace_ATL2QVTrFactory.eINSTANCE.createTmapOperationCallExp_Operation();
		models[2/*middle*/].add(mapOperationCallExp_Operation, false);
		final @SuppressWarnings("null")@NonNull TmapOperatorCallExp mapOperatorCallExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapOperatorCallExp();
		models[2/*middle*/].add(mapOperatorCallExp, false);
		final @SuppressWarnings("null")@NonNull TmapStringExp mapStringExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapStringExp();
		models[2/*middle*/].add(mapStringExp, false);
		final @SuppressWarnings("null")@NonNull TmapVariableExp mapVariableExp = trace_ATL2QVTrFactory.eINSTANCE.createTmapVariableExp();
		models[2/*middle*/].add(mapVariableExp, false);
		// mapping statements
		OPPOSITE_OF_DmapOclExpression_d1atlExpression.put(atlExpression, dispatcher_0);
		dispatcher_0.setD1atlExpression(atlExpression);
		dispatcher_0.setDomapBooleanExp(mapBooleanExp);
		dispatcher_0.setDomapIfExp(mapIfExp);
		dispatcher_0.setDomapIntegerExp(mapIntegerExp);
		dispatcher_0.setDomapNavigationOrAttributeCallExp_Helper(mapNavigationOrAttributeCallExp_Helper);
		dispatcher_0.setDomapNavigationOrAttributeCallExp_Property(mapNavigationOrAttributeCallExp_Property);
		dispatcher_0.setDomapOperationCallExp_Helper(mapOperationCallExp_Helper);
		dispatcher_0.setDomapOperationCallExp_Operation(mapOperationCallExp_Operation);
		dispatcher_0.setDomapOperatorCallExp(mapOperatorCallExp);
		dispatcher_0.setDomapStringExp(mapStringExp);
		dispatcher_0.setDomapVariableExp(mapVariableExp);
		jm_TmapOperationCallExp__Operation.appendElement(mapOperationCallExp_Operation);
		jm_TmapBooleanExp.appendElement(mapBooleanExp);
		jm_TmapNavigationOrAttributeCallExp__Helper.appendElement(mapNavigationOrAttributeCallExp_Helper);
		jm_TmapOperatorCallExp.appendElement(mapOperatorCallExp);
		jm_TmapIntegerExp.appendElement(mapIntegerExp);
		jm_TmapNavigationOrAttributeCallExp__Property.appendElement(mapNavigationOrAttributeCallExp_Property);
		jm_TmapVariableExp.appendElement(mapVariableExp);
		jm_TmapOperationCallExp__Helper.appendElement(mapOperationCallExp_Helper);
		jm_TmapIfExp.appendElement(mapIfExp);
		jm_DmapOclExpression.appendElement(dispatcher_0);
		jm_TmapStringExp.appendElement(mapStringExp);
		final /*@Thrown*/ @Nullable Boolean mOclExpression_DmapOclExpression = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mOclExpression_DmapOclExpression ? "done "  : "fail ") + "MAP_mOclExpression_DmapOclExpression");
		}
		return mOclExpression_DmapOclExpression;
	}

	/**
	 *
	 * map mTmapBooleanExp_success_t0symbol in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapBooleanExp[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var atlExpression : OCL::BooleanExp[1] := dispatcher.d1atlExpression;
	 * var symbol : Boolean[1] := atlExpression.booleanSymbol;
	 * var Boolean1 : Class[1] := PrimitiveTypes::Boolean;
	 * new:qvtr qvtrExpression : BooleanLiteralExp[1];
	 * set trace.t0symbol := symbol;
	 * set qvtrExpression.booleanSymbol := symbol;
	 * set dispatcher.success := true;
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 * set dispatcher.result := trace;
	 * notify set qvtrExpression.type := Boolean1;
	 *
	 */
	protected boolean MAP_mTmapBooleanExp_success_t0symbol(final /*@NonInvalid*/ @NonNull TmapBooleanExp trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapBooleanExp_success_t0symbol" + ", " + trace);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace.getDispatcher();
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
			// mapping statements
			trace.setT0symbol(booleanSymbol);
			qvtrExpression.setBooleanSymbol(booleanSymbol);
			dispatcher_0.setSuccess((Boolean)ValueUtil.TRUE_VALUE);
			dispatcher_0.setD2qvtrExpression(qvtrExpression);
			dispatcher_0.setResult(trace);
			qvtrExpression.setType(TYP_Boolean_0);
			objectManager.assigned(qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, TYP_Boolean_0);
			final /*@Thrown*/ @Nullable Boolean mTmapBooleanExp_success_t0symbol = ValueUtil.TRUE_VALUE;
			symbol_9 = mTmapBooleanExp_success_t0symbol;
		}
		else {
			symbol_9 = ValueUtil.FALSE_VALUE;
		}
		trace.setSuccess(symbol_9);
		if (symbol_9) {
			objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_9);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_9 ? "done "  : "fail ") + "MAP_mTmapBooleanExp_success_t0symbol");
		}
		return symbol_9;
	}

	/**
	 *
	 * map mTmapIntegerExp_success_t0symbol in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapIntegerExp[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var atlExpression : OCL::IntegerExp[1] := dispatcher.d1atlExpression;
	 * var symbol : Integer[1] := atlExpression.integerSymbol;
	 * var Integer1 : Class[1] := PrimitiveTypes::Integer;
	 * new:qvtr qvtrExpression : IntegerLiteralExp[1];
	 * set trace.t0symbol := symbol;
	 * set qvtrExpression.integerSymbol := symbol;
	 * set dispatcher.success := true;
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 * set dispatcher.result := trace;
	 * notify set qvtrExpression.type := Integer1;
	 *
	 */
	protected boolean MAP_mTmapIntegerExp_success_t0symbol(final /*@NonInvalid*/ @NonNull TmapIntegerExp trace_0)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapIntegerExp_success_t0symbol" + ", " + trace_0);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_0.getDispatcher();
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
			// mapping statements
			trace_0.setT0symbol(ValueUtil.bigIntegerValueOf(integerSymbol));
			qvtrExpression.setIntegerSymbol(integerSymbol);
			dispatcher_0.setSuccess((Boolean)ValueUtil.TRUE_VALUE);
			dispatcher_0.setD2qvtrExpression(qvtrExpression);
			dispatcher_0.setResult(trace_0);
			qvtrExpression.setType(TYP_Integer_0);
			objectManager.assigned(qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, TYP_Integer_0);
			final /*@Thrown*/ @Nullable Boolean mTmapIntegerExp_success_t0symbol = ValueUtil.TRUE_VALUE;
			symbol_9 = mTmapIntegerExp_success_t0symbol;
		}
		else {
			symbol_9 = ValueUtil.FALSE_VALUE;
		}
		trace_0.setSuccess(symbol_9);
		if (symbol_9) {
			objectManager.assigned(trace_0, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_9);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_9 ? "done "  : "fail ") + "MAP_mTmapIntegerExp_success_t0symbol");
		}
		return symbol_9;
	}

	/**
	 *
	 * map mTmapStringExp_success_t0symbol in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapStringExp[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var atlExpression : OCL::StringExp[1] := dispatcher.d1atlExpression;
	 * var symbol : String[1] := atlExpression.stringSymbol;
	 * var String1 : Class[1] := PrimitiveTypes::String;
	 * new:qvtr qvtrExpression : StringLiteralExp[1];
	 * set trace.t0symbol := symbol;
	 * set qvtrExpression.stringSymbol := symbol;
	 * set dispatcher.success := true;
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 * set dispatcher.result := trace;
	 * notify set qvtrExpression.type := String1;
	 *
	 */
	protected boolean MAP_mTmapStringExp_success_t0symbol(final /*@NonInvalid*/ @NonNull TmapStringExp trace_1)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapStringExp_success_t0symbol" + ", " + trace_1);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_1.getDispatcher();
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
			// mapping statements
			trace_1.setT0symbol(stringSymbol);
			qvtrExpression.setStringSymbol(stringSymbol);
			dispatcher_0.setSuccess((Boolean)ValueUtil.TRUE_VALUE);
			dispatcher_0.setD2qvtrExpression(qvtrExpression);
			dispatcher_0.setResult(trace_1);
			qvtrExpression.setType(TYP_String_0);
			objectManager.assigned(qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, TYP_String_0);
			final /*@Thrown*/ @Nullable Boolean mTmapStringExp_success_t0symbol = ValueUtil.TRUE_VALUE;
			symbol_9 = mTmapStringExp_success_t0symbol;
		}
		else {
			symbol_9 = ValueUtil.FALSE_VALUE;
		}
		trace_1.setSuccess(symbol_9);
		if (symbol_9) {
			objectManager.assigned(trace_1, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_9);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_9 ? "done "  : "fail ") + "MAP_mTmapStringExp_success_t0symbol");
		}
		return symbol_9;
	}

	/**
	 *
	 * map mTmapIfExp_t1atlCondition_t1atlElse_t1atlThen_p0 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapIfExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var atlExpression : OCL::IfExp[1] := dispatcher.d1atlExpression;
	 * var atlCondition : OCL::OclExpression[1] := atlExpression.condition;
	 * var atlElse : OCL::OclExpression[1] := atlExpression.elseExpression;
	 * var atlThen : OCL::OclExpression[1] := atlExpression.thenExpression;
	 * set trace.t1atlCondition := atlCondition;
	 * set trace.t1atlElse := atlElse;
	 * set trace.t1atlThen := atlThen;
	 *
	 */
	protected boolean MAP_mTmapIfExp_t1atlCondition_t1atlElse_t1atlThen_p0(final /*@NonInvalid*/ @NonNull TmapIfExp trace_2)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapIfExp_t1atlCondition_t1atlElse_t1atlThen_p0" + ", " + trace_2);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_2.getDispatcher();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof org.eclipse.m2m.atl.common.OCL.IfExp;
		/*@Thrown*/ @Nullable Boolean symbol_6;
		if (symbol_0) {
			final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull IfExp symbol_1 = (org.eclipse.m2m.atl.common.OCL.IfExp)temp1_atlExpression;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression condition = symbol_1.getCondition();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression elseExpression = symbol_1.getElseExpression();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression thenExpression = symbol_1.getThenExpression();
			// mapping statements
			trace_2.setT1atlCondition(condition);
			trace_2.setT1atlElse(elseExpression);
			trace_2.setT1atlThen(thenExpression);
			final /*@Thrown*/ @Nullable Boolean mTmapIfExp_t1atlCondition_t1atlElse_t1atlThen_p0 = ValueUtil.TRUE_VALUE;
			symbol_6 = mTmapIfExp_t1atlCondition_t1atlElse_t1atlThen_p0;
		}
		else {
			symbol_6 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_6 ? "done "  : "fail ") + "MAP_mTmapIfExp_t1atlCondition_t1atlElse_t1atlThen_p0");
		}
		return symbol_6;
	}

	/**
	 *
	 * map mTmapIfExp_success_wmapOclExpression_wmapOclExpress_p1 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapIfExp[1] success success;
	 * var atlThen : OCL::OclExpression[1] := trace.t1atlThen;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlThen.DmapOclExpression;
	 * var atlElse : OCL::OclExpression[1] := trace.t1atlElse;
	 * var when_mapOclExpression1 : trace_ATL2QVTr::DmapOclExpression[1] := atlElse.DmapOclExpression;
	 * var atlCondition : OCL::OclExpression[1] := trace.t1atlCondition;
	 * var when_mapOclExpression2 : trace_ATL2QVTr::DmapOclExpression[1] := atlCondition.DmapOclExpression;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * set dispatcher.success := true;
	 * set dispatcher.result := trace;
	 * set trace.wmapOclExpression1 := when_mapOclExpression1;
	 * set trace.wmapOclExpression2 := when_mapOclExpression;
	 * set trace.wmapOclExpression := when_mapOclExpression2;
	 *
	 */
	protected boolean MAP_mTmapIfExp_success_wmapOclExpression_wmapOclExpress_p1(final /*@NonInvalid*/ @NonNull TmapIfExp trace_3)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapIfExp_success_wmapOclExpression_wmapOclExpress_p1" + ", " + trace_3);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression t1atlThen = trace_3.getT1atlThen();
		final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(t1atlThen);
		final /*@NonInvalid*/ boolean symbol_0 = DmapOclExpression != null;
		/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
		if (symbol_0) {
			if (DmapOclExpression == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression t1atlElse = trace_3.getT1atlElse();
			final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression_0 = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(t1atlElse);
			final /*@NonInvalid*/ boolean symbol_1 = DmapOclExpression_0 != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression1;
			if (symbol_1) {
				if (DmapOclExpression_0 == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression t1atlCondition = trace_3.getT1atlCondition();
				final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression_1 = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(t1atlCondition);
				final /*@NonInvalid*/ boolean symbol_2 = DmapOclExpression_1 != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression2;
				if (symbol_2) {
					if (DmapOclExpression_1 == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_3.getDispatcher();
					// mapping statements
					dispatcher_0.setSuccess((Boolean)ValueUtil.TRUE_VALUE);
					dispatcher_0.setResult(trace_3);
					trace_3.setWmapOclExpression1(DmapOclExpression_0);
					trace_3.setWmapOclExpression2(DmapOclExpression);
					trace_3.setWmapOclExpression(DmapOclExpression_1);
					final /*@Thrown*/ @Nullable Boolean mTmapIfExp_success_wmapOclExpression_wmapOclExpress_p1 = ValueUtil.TRUE_VALUE;
					raw_when_mapOclExpression2 = mTmapIfExp_success_wmapOclExpression_wmapOclExpress_p1;
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
		trace_3.setSuccess(raw_when_mapOclExpression);
		if (raw_when_mapOclExpression) {
			objectManager.assigned(trace_3, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, raw_when_mapOclExpression);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_mapOclExpression ? "done "  : "fail ") + "MAP_mTmapIfExp_success_wmapOclExpression_wmapOclExpress_p1");
		}
		return raw_when_mapOclExpression;
	}

	/**
	 *
	 * map mTmapIfExp__DmapOclExpression_d2qvtrExpression_p2 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapIfExp[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * new:qvtr qvtrExpression : IfExp[1];
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_mTmapIfExp__DmapOclExpression_d2qvtrExpression_p2(final /*@NonInvalid*/ @NonNull TmapIfExp trace_4)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapIfExp__DmapOclExpression_d2qvtrExpression_p2" + ", " + trace_4);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_4.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_2;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_4.getDispatcher();
			// creations
			final org.eclipse.ocl.pivot.@NonNull IfExp qvtrExpression = PivotFactory.eINSTANCE.createIfExp();
			models[1/*qvtr*/].add(qvtrExpression, false);
			// mapping statements
			dispatcher_0.setD2qvtrExpression(qvtrExpression);
			final /*@Thrown*/ @Nullable Boolean mTmapIfExp__DmapOclExpression_d2qvtrExpression_p2 = ValueUtil.TRUE_VALUE;
			symbol_2 = mTmapIfExp__DmapOclExpression_d2qvtrExpression_p2;
		}
		else {
			symbol_2 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_2 ? "done "  : "fail ") + "MAP_mTmapIfExp__DmapOclExpression_d2qvtrExpression_p2");
		}
		return symbol_2;
	}

	/**
	 *
	 * map mTmapNavigationOrAttributeCallExp__Helper_t0propert_p0 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var atlExpression : OCL::NavigationOrAttributeCallExp[1] := dispatcher.d1atlExpression;
	 * var propertyName : String[1] := atlExpression.name;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * set trace.t0propertyName := propertyName;
	 * set trace.t1atlSource := atlSource;
	 *
	 */
	protected boolean MAP_mTmapNavigationOrAttributeCallExp__Helper_t0propert_p0(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_5)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapNavigationOrAttributeCallExp__Helper_t0propert_p0" + ", " + trace_5);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_5.getDispatcher();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof NavigationOrAttributeCallExp;
		/*@Thrown*/ @Nullable Boolean symbol_5;
		if (symbol_0) {
			final /*@NonInvalid*/ @NonNull NavigationOrAttributeCallExp symbol_1 = (NavigationOrAttributeCallExp)temp1_atlExpression;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name_2 = symbol_1.getName();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression source = symbol_1.getSource();
			// mapping statements
			trace_5.setT0propertyName(name_2);
			trace_5.setT1atlSource(source);
			final /*@Thrown*/ @Nullable Boolean mTmapNavigationOrAttributeCallExp__Helper_t0propert_p0 = ValueUtil.TRUE_VALUE;
			symbol_5 = mTmapNavigationOrAttributeCallExp__Helper_t0propert_p0;
		}
		else {
			symbol_5 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_5 ? "done "  : "fail ") + "MAP_mTmapNavigationOrAttributeCallExp__Helper_t0propert_p0");
		}
		return symbol_5;
	}

	/**
	 *
	 * map mTmapNavigationOrAttributeCallExp__Property_t0prope_p0 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var atlExpression : OCL::NavigationOrAttributeCallExp[1] := dispatcher.d1atlExpression;
	 * var propertyName : String[1] := atlExpression.name;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * set trace.t0propertyName := propertyName;
	 * set trace.t1atlSource := atlSource;
	 *
	 */
	protected boolean MAP_mTmapNavigationOrAttributeCallExp__Property_t0prope_p0(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace_6)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapNavigationOrAttributeCallExp__Property_t0prope_p0" + ", " + trace_6);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_6.getDispatcher();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof NavigationOrAttributeCallExp;
		/*@Thrown*/ @Nullable Boolean symbol_5;
		if (symbol_0) {
			final /*@NonInvalid*/ @NonNull NavigationOrAttributeCallExp symbol_1 = (NavigationOrAttributeCallExp)temp1_atlExpression;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name_2 = symbol_1.getName();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression source = symbol_1.getSource();
			// mapping statements
			trace_6.setT0propertyName(name_2);
			trace_6.setT1atlSource(source);
			final /*@Thrown*/ @Nullable Boolean mTmapNavigationOrAttributeCallExp__Property_t0prope_p0 = ValueUtil.TRUE_VALUE;
			symbol_5 = mTmapNavigationOrAttributeCallExp__Property_t0prope_p0;
		}
		else {
			symbol_5 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_5 ? "done "  : "fail ") + "MAP_mTmapNavigationOrAttributeCallExp__Property_t0prope_p0");
		}
		return symbol_5;
	}

	/**
	 *
	 * map mTmapNavigationOrAttributeCallExp__Property_success_p1 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var atlExpression : OCL::NavigationOrAttributeCallExp[1] := dispatcher.d1atlExpression;
	 * var atlSource : OCL::OclExpression[1] := trace.t1atlSource;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlSource.DmapOclExpression;
	 * var atlModule : ATL::Module[1] := this.getModule(atlExpression)
	 *   ;
	 * var elements : OrderedSet(ATL::ModuleElement) := atlModule.elements;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var _'\u00ABcollect\u00BB' : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(_'1_' | _'1_'.definition)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Attribute) := _'\u00ABcollect\u00BB'->collect(_'1_' | _'1_'.feature)
	 *   ->selectByKind(OCL::Attribute)
	 *   ;
	 * var _'\u00ABselect\u00BB' : Sequence(OCL::Attribute) := selectByKind1->select(_'1_' | _'1_'.name = trace.t0propertyName)
	 *   ;
	 * var isEmpty : Boolean[1] := _'\u00ABselect\u00BB'->isEmpty()
	 *   ;
	 * check isEmpty;
	 * var propertyName : String[1] := trace.t0propertyName;
	 * var _'\u00ABcollect\u00BB1' : Sequence(OCL::OclFeature) := _'\u00ABcollect\u00BB'->collect(_'1_' | _'1_'.feature);
	 * set dispatcher.success := true;
	 * set dispatcher.result := trace;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected boolean MAP_mTmapNavigationOrAttributeCallExp__Property_success_p1(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace_7)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapNavigationOrAttributeCallExp__Property_success_p1" + ", " + trace_7);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_7.getDispatcher();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof NavigationOrAttributeCallExp;
		/*@Thrown*/ @Nullable Boolean symbol_8;
		if (symbol_0) {
			final /*@NonInvalid*/ @NonNull NavigationOrAttributeCallExp symbol_1 = (NavigationOrAttributeCallExp)temp1_atlExpression;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression t1atlSource = trace_7.getT1atlSource();
			final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(t1atlSource);
			final /*@NonInvalid*/ boolean symbol_2 = DmapOclExpression != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
			if (symbol_2) {
				if (DmapOclExpression == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@NonInvalid*/ @NonNull Module getModule = ((FUN_getModule)FTOR_getModule.getUniqueComputation(this, symbol_1)).instance;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<ModuleElement> elements = getModule.getElements();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ATL_c_c_Helper_0 = idResolver.getClass(CLSSid_Helper, null);
				final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_elements = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleElement, elements);
				final /*@NonInvalid*/ @NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_elements, TYP_ATL_c_c_Helper_0);
				/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeatureDefinition);
				@NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
				/*@NonInvalid*/ @NonNull SequenceValue collect;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						collect = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull Helper _1 = (Helper)ITERATOR__1.next();
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
					/*@NonInvalid*/ @NonNull OclFeatureDefinition _1_0 = (OclFeatureDefinition)ITERATOR__1_0.next();
					/**
					 * _'1_'.feature
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclFeature feature = _1_0.getFeature();
					//
					accumulator_0.add(feature);
				}
				final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_0, TYP_OCL_c_c_Attribute_0);
				/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Attribute);
				@NonNull Iterator<Object> ITERATOR__1_1 = selectByKind_0.iterator();
				/*@NonInvalid*/ @NonNull SequenceValue select;
				while (true) {
					if (!ITERATOR__1_1.hasNext()) {
						select = accumulator_1;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull Attribute _1_1 = (Attribute)ITERATOR__1_1.next();
					/**
					 * _'1_'.name = trace.t0propertyName
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String name_2 = _1_1.getName();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String t0propertyName = trace_7.getT0propertyName();
					final /*@NonInvalid*/ boolean eq = name_2.equals(t0propertyName);
					//
					if (eq == ValueUtil.TRUE_VALUE) {
						accumulator_1.add(_1_1);
					}
				}
				final /*@NonInvalid*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(select).booleanValue();
				/*@Thrown*/ @Nullable Boolean symbol_7;
				if (isEmpty) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String t0propertyName_0 = trace_7.getT0propertyName();
					// mapping statements
					dispatcher_0.setSuccess((Boolean)ValueUtil.TRUE_VALUE);
					dispatcher_0.setResult(trace_7);
					trace_7.setWmapOclExpression(DmapOclExpression);
					final /*@Thrown*/ @Nullable Boolean mTmapNavigationOrAttributeCallExp__Property_success_p1 = ValueUtil.TRUE_VALUE;
					symbol_7 = mTmapNavigationOrAttributeCallExp__Property_success_p1;
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
		trace_7.setSuccess(symbol_8);
		if (symbol_8) {
			objectManager.assigned(trace_7, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_8);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_8 ? "done "  : "fail ") + "MAP_mTmapNavigationOrAttributeCallExp__Property_success_p1");
		}
		return symbol_8;
	}

	/**
	 *
	 * map mTmapNavigationOrAttributeCallExp__Property__DmapOc_p2 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * var propertyName : String[1] := trace.t0propertyName;
	 * new:qvtr qvtrExpression : PropertyCallExp[1];
	 * set qvtrExpression.name := propertyName;
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_mTmapNavigationOrAttributeCallExp__Property__DmapOc_p2(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace_8)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapNavigationOrAttributeCallExp__Property__DmapOc_p2" + ", " + trace_8);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_8.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_3;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_8.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String t0propertyName = trace_8.getT0propertyName();
			// creations
			final @NonNull PropertyCallExp qvtrExpression = PivotFactory.eINSTANCE.createPropertyCallExp();
			models[1/*qvtr*/].add(qvtrExpression, false);
			// mapping statements
			qvtrExpression.setName(t0propertyName);
			dispatcher_0.setD2qvtrExpression(qvtrExpression);
			final /*@Thrown*/ @Nullable Boolean mTmapNavigationOrAttributeCallExp__Property__DmapOc_p2 = ValueUtil.TRUE_VALUE;
			symbol_3 = mTmapNavigationOrAttributeCallExp__Property__DmapOc_p2;
		}
		else {
			symbol_3 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_3 ? "done "  : "fail ") + "MAP_mTmapNavigationOrAttributeCallExp__Property__DmapOc_p2");
		}
		return symbol_3;
	}

	/**
	 *
	 * map mTmapOperationCallExp__Helper_t0operationName_t1atl_p0 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var atlExpression : OCL::OperationCallExp[1] := dispatcher.d1atlExpression;
	 * var operationName : String[1] := atlExpression.operationName;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * set trace.t0operationName := operationName;
	 * set trace.t1atlSource := atlSource;
	 *
	 */
	protected boolean MAP_mTmapOperationCallExp__Helper_t0operationName_t1atl_p0(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_9)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperationCallExp__Helper_t0operationName_t1atl_p0" + ", " + trace_9);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_9.getDispatcher();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof org.eclipse.m2m.atl.common.OCL.OperationCallExp;
		/*@Thrown*/ @Nullable Boolean symbol_5;
		if (symbol_0) {
			final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull OperationCallExp symbol_1 = (org.eclipse.m2m.atl.common.OCL.OperationCallExp)temp1_atlExpression;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String operationName = symbol_1.getOperationName();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression source = symbol_1.getSource();
			// mapping statements
			trace_9.setT0operationName(operationName);
			trace_9.setT1atlSource(source);
			final /*@Thrown*/ @Nullable Boolean mTmapOperationCallExp__Helper_t0operationName_t1atl_p0 = ValueUtil.TRUE_VALUE;
			symbol_5 = mTmapOperationCallExp__Helper_t0operationName_t1atl_p0;
		}
		else {
			symbol_5 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_5 ? "done "  : "fail ") + "MAP_mTmapOperationCallExp__Helper_t0operationName_t1atl_p0");
		}
		return symbol_5;
	}

	/**
	 *
	 * map mTmapOperationCallExp__Operation_t0operationName_t1_p0 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var atlExpression : OCL::OperationCallExp[1] := dispatcher.d1atlExpression;
	 * var operationName : String[1] := atlExpression.operationName;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * set trace.t0operationName := operationName;
	 * set trace.t1atlSource := atlSource;
	 *
	 */
	protected boolean MAP_mTmapOperationCallExp__Operation_t0operationName_t1_p0(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace_10)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperationCallExp__Operation_t0operationName_t1_p0" + ", " + trace_10);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_10.getDispatcher();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof org.eclipse.m2m.atl.common.OCL.OperationCallExp;
		/*@Thrown*/ @Nullable Boolean symbol_5;
		if (symbol_0) {
			final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull OperationCallExp symbol_1 = (org.eclipse.m2m.atl.common.OCL.OperationCallExp)temp1_atlExpression;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String operationName = symbol_1.getOperationName();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression source = symbol_1.getSource();
			// mapping statements
			trace_10.setT0operationName(operationName);
			trace_10.setT1atlSource(source);
			final /*@Thrown*/ @Nullable Boolean mTmapOperationCallExp__Operation_t0operationName_t1_p0 = ValueUtil.TRUE_VALUE;
			symbol_5 = mTmapOperationCallExp__Operation_t0operationName_t1_p0;
		}
		else {
			symbol_5 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_5 ? "done "  : "fail ") + "MAP_mTmapOperationCallExp__Operation_t0operationName_t1_p0");
		}
		return symbol_5;
	}

	/**
	 *
	 * map mTmapOperationCallExp__Operation_success_wmapOclExp_p1 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Operation[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var atlExpression : OCL::OperationCallExp[1] := dispatcher.d1atlExpression;
	 * var atlSource : OCL::OclExpression[1] := trace.t1atlSource;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlSource.DmapOclExpression;
	 * var _'oclIsKindOf\\nOCL::OperatorCallExp' : Boolean[1] := atlExpression.oclIsKindOf(OCL::OperatorCallExp)
	 *   ;
	 * var _'not' : Boolean[?] := not _'oclIsKindOf\\nOCL::OperatorCallExp';
	 * check _'not';
	 * var atlModule : ATL::Module[1] := this.getModule(atlExpression)
	 *   ;
	 * var elements : OrderedSet(ATL::ModuleElement) := atlModule.elements;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var _'\u00ABcollect\u00BB' : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(_'1_' | _'1_'.definition)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Operation) := _'\u00ABcollect\u00BB'->collect(_'1_' | _'1_'.feature)
	 *   ->selectByKind(OCL::Operation)
	 *   ;
	 * var _'\u00ABselect\u00BB' : Sequence(OCL::Operation) := selectByKind1->select(_'1_' | _'1_'.name = trace.t0operationName)
	 *   ;
	 * var isEmpty : Boolean[1] := _'\u00ABselect\u00BB'->isEmpty()
	 *   ;
	 * check isEmpty;
	 * var operationName : String[1] := trace.t0operationName;
	 * var _'\u00ABcollect\u00BB1' : Sequence(OCL::OclFeature) := _'\u00ABcollect\u00BB'->collect(_'1_' | _'1_'.feature);
	 * set dispatcher.success := true;
	 * set dispatcher.result := trace;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected boolean MAP_mTmapOperationCallExp__Operation_success_wmapOclExp_p1(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace_11)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperationCallExp__Operation_success_wmapOclExp_p1" + ", " + trace_11);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_11.getDispatcher();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof org.eclipse.m2m.atl.common.OCL.OperationCallExp;
		/*@Thrown*/ @Nullable Boolean symbol_9;
		if (symbol_0) {
			final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull OperationCallExp symbol_1 = (org.eclipse.m2m.atl.common.OCL.OperationCallExp)temp1_atlExpression;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression t1atlSource = trace_11.getT1atlSource();
			final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(t1atlSource);
			final /*@NonInvalid*/ boolean symbol_2 = DmapOclExpression != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
			if (symbol_2) {
				if (DmapOclExpression == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_OperatorCallExp_0 = idResolver.getClass(CLSSid_OperatorCallExp, null);
				final /*@NonInvalid*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, symbol_1, TYP_OCL_c_c_OperatorCallExp_0).booleanValue();
				final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
				if (not == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_8;
				if (not) {
					final /*@NonInvalid*/ @NonNull Module getModule = ((FUN_getModule)FTOR_getModule.getUniqueComputation(this, symbol_1)).instance;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<ModuleElement> elements = getModule.getElements();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ATL_c_c_Helper_0 = idResolver.getClass(CLSSid_Helper, null);
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_elements = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleElement, elements);
					final /*@NonInvalid*/ @NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_elements, TYP_ATL_c_c_Helper_0);
					/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeatureDefinition);
					@NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
					/*@NonInvalid*/ @NonNull SequenceValue collect;
					while (true) {
						if (!ITERATOR__1.hasNext()) {
							collect = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull Helper _1 = (Helper)ITERATOR__1.next();
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
						/*@NonInvalid*/ @NonNull OclFeatureDefinition _1_0 = (OclFeatureDefinition)ITERATOR__1_0.next();
						/**
						 * _'1_'.feature
						 */
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OclFeature feature = _1_0.getFeature();
						//
						accumulator_0.add(feature);
					}
					final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_0, TYP_OCL_c_c_Operation_0);
					/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
					@NonNull Iterator<Object> ITERATOR__1_1 = selectByKind_0.iterator();
					/*@NonInvalid*/ @NonNull SequenceValue select;
					while (true) {
						if (!ITERATOR__1_1.hasNext()) {
							select = accumulator_1;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation _1_1 = (org.eclipse.m2m.atl.common.OCL.Operation)ITERATOR__1_1.next();
						/**
						 * _'1_'.name = trace.t0operationName
						 */
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String name_2 = _1_1.getName();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t0operationName = trace_11.getT0operationName();
						final /*@NonInvalid*/ boolean eq = name_2.equals(t0operationName);
						//
						if (eq == ValueUtil.TRUE_VALUE) {
							accumulator_1.add(_1_1);
						}
					}
					final /*@NonInvalid*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(select).booleanValue();
					/*@Thrown*/ @Nullable Boolean symbol_7;
					if (isEmpty) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t0operationName_0 = trace_11.getT0operationName();
						// mapping statements
						dispatcher_0.setSuccess((Boolean)ValueUtil.TRUE_VALUE);
						dispatcher_0.setResult(trace_11);
						trace_11.setWmapOclExpression(DmapOclExpression);
						final /*@Thrown*/ @Nullable Boolean mTmapOperationCallExp__Operation_success_wmapOclExp_p1 = ValueUtil.TRUE_VALUE;
						symbol_7 = mTmapOperationCallExp__Operation_success_wmapOclExp_p1;
					}
					else {
						symbol_7 = ValueUtil.FALSE_VALUE;
					}
					symbol_8 = symbol_7;
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
		trace_11.setSuccess(symbol_9);
		if (symbol_9) {
			objectManager.assigned(trace_11, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_9);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_9 ? "done "  : "fail ") + "MAP_mTmapOperationCallExp__Operation_success_wmapOclExp_p1");
		}
		return symbol_9;
	}

	/**
	 *
	 * map mTmapOperationCallExp__Operation__DmapOclExpression_p2 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * var operationName : String[1] := trace.t0operationName;
	 * new:qvtr qvtrExpression : OperationCallExp[1];
	 * set qvtrExpression.name := operationName;
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_mTmapOperationCallExp__Operation__DmapOclExpression_p2(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace_12)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperationCallExp__Operation__DmapOclExpression_p2" + ", " + trace_12);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_12.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_3;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_12.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String t0operationName = trace_12.getT0operationName();
			// creations
			final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
			models[1/*qvtr*/].add(qvtrExpression, false);
			// mapping statements
			qvtrExpression.setName(t0operationName);
			dispatcher_0.setD2qvtrExpression(qvtrExpression);
			final /*@Thrown*/ @Nullable Boolean mTmapOperationCallExp__Operation__DmapOclExpression_p2 = ValueUtil.TRUE_VALUE;
			symbol_3 = mTmapOperationCallExp__Operation__DmapOclExpression_p2;
		}
		else {
			symbol_3 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_3 ? "done "  : "fail ") + "MAP_mTmapOperationCallExp__Operation__DmapOclExpression_p2");
		}
		return symbol_3;
	}

	/**
	 *
	 * map mTmapOperatorCallExp_t0operationName_t1atlSource_p0 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var atlExpression : OCL::OperatorCallExp[1] := dispatcher.d1atlExpression;
	 * var operationName : String[1] := atlExpression.operationName;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * set trace.t0operationName := operationName;
	 * set trace.t1atlSource := atlSource;
	 *
	 */
	protected boolean MAP_mTmapOperatorCallExp_t0operationName_t1atlSource_p0(final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace_13)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperatorCallExp_t0operationName_t1atlSource_p0" + ", " + trace_13);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_13.getDispatcher();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof OperatorCallExp;
		/*@Thrown*/ @Nullable Boolean symbol_5;
		if (symbol_0) {
			final /*@NonInvalid*/ @NonNull OperatorCallExp symbol_1 = (OperatorCallExp)temp1_atlExpression;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String operationName = symbol_1.getOperationName();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression source = symbol_1.getSource();
			// mapping statements
			trace_13.setT0operationName(operationName);
			trace_13.setT1atlSource(source);
			final /*@Thrown*/ @Nullable Boolean mTmapOperatorCallExp_t0operationName_t1atlSource_p0 = ValueUtil.TRUE_VALUE;
			symbol_5 = mTmapOperatorCallExp_t0operationName_t1atlSource_p0;
		}
		else {
			symbol_5 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_5 ? "done "  : "fail ") + "MAP_mTmapOperatorCallExp_t0operationName_t1atlSource_p0");
		}
		return symbol_5;
	}

	/**
	 *
	 * map mTmapVariableExp_success_t0varName_t1atlVariable_wm in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp[1] success success;
	 * append jm_DmapVariableExp__referredVariable  : trace_ATL2QVTr::DmapVariableExp_referredVariable[1];
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var atlExpression : OCL::VariableExp[1] := dispatcher.d1atlExpression;
	 * var atlVariable : OCL::VariableDeclaration[1] := atlExpression.referredVariable;
	 * var varName : String[1] := atlVariable.varName;
	 * new:qvtr qvtrExpression : VariableExp[1];
	 * new:middle where_mapVariableExp_referredVariable : trace_ATL2QVTr::DmapVariableExp_referredVariable[1];
	 * set trace.t0varName := varName;
	 * set qvtrExpression.name := varName;
	 * set dispatcher.success := true;
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 * set dispatcher.result := trace;
	 * set trace.t1atlVariable := atlVariable;
	 * set trace.wmapVariableExp_referredVariable := where_mapVariableExp_referredVariable;
	 * set where_mapVariableExp_referredVariable.d1atlExpression := atlExpression;
	 * set where_mapVariableExp_referredVariable.d2qvtrExpression := qvtrExpression;
	 * add jm_DmapVariableExp__referredVariable += where_mapVariableExp_referredVariable;
	 *
	 */
	protected boolean MAP_mTmapVariableExp_success_t0varName_t1atlVariable_wm(final @NonNull Connection jm_DmapVariableExp__referredVariable, final /*@NonInvalid*/ @NonNull TmapVariableExp trace_14)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapVariableExp_success_t0varName_t1atlVariable_wm" + ", " + jm_DmapVariableExp__referredVariable + ", " + trace_14);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_14.getDispatcher();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof org.eclipse.m2m.atl.common.OCL.VariableExp;
		/*@Thrown*/ @Nullable Boolean symbol_13;
		if (symbol_0) {
			final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableExp symbol_1 = (org.eclipse.m2m.atl.common.OCL.VariableExp)temp1_atlExpression;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableDeclaration referredVariable = symbol_1.getReferredVariable();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String varName = referredVariable.getVarName();
			// creations
			final org.eclipse.ocl.pivot.@NonNull VariableExp qvtrExpression = PivotFactory.eINSTANCE.createVariableExp();
			models[1/*qvtr*/].add(qvtrExpression, false);
			final @SuppressWarnings("null")@NonNull DmapVariableExp_referredVariable where_mapVariableExp_referredVariable = trace_ATL2QVTrFactory.eINSTANCE.createDmapVariableExp_referredVariable();
			models[2/*middle*/].add(where_mapVariableExp_referredVariable, false);
			// mapping statements
			trace_14.setT0varName(varName);
			qvtrExpression.setName(varName);
			dispatcher_0.setSuccess((Boolean)ValueUtil.TRUE_VALUE);
			dispatcher_0.setD2qvtrExpression(qvtrExpression);
			dispatcher_0.setResult(trace_14);
			trace_14.setT1atlVariable(referredVariable);
			trace_14.setWmapVariableExp_referredVariable(where_mapVariableExp_referredVariable);
			where_mapVariableExp_referredVariable.setD1atlExpression(symbol_1);
			where_mapVariableExp_referredVariable.setD2qvtrExpression(qvtrExpression);
			jm_DmapVariableExp__referredVariable.appendElement(where_mapVariableExp_referredVariable);
			final /*@Thrown*/ @Nullable Boolean mTmapVariableExp_success_t0varName_t1atlVariable_wm = ValueUtil.TRUE_VALUE;
			symbol_13 = mTmapVariableExp_success_t0varName_t1atlVariable_wm;
		}
		else {
			symbol_13 = ValueUtil.FALSE_VALUE;
		}
		trace_14.setSuccess(symbol_13);
		if (symbol_13) {
			objectManager.assigned(trace_14, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_13);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_13 ? "done "  : "fail ") + "MAP_mTmapVariableExp_success_t0varName_t1atlVariable_wm");
		}
		return symbol_13;
	}

	/**
	 *
	 * map mDmapVariableExp__referredVariable_domapVariableExp in ATL2QVTr {
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
	protected boolean MAP_mDmapVariableExp__referredVariable_domapVariableExp(final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher, final @NonNull Connection jm_TmapVariableExp__referredVariable__Helper, final @NonNull Connection jm_TmapVariableExp__referredVariable__VariableDecl)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mDmapVariableExp__referredVariable_domapVariableExp" + ", " + dispatcher + ", " + jm_TmapVariableExp__referredVariable__Helper + ", " + jm_TmapVariableExp__referredVariable__VariableDecl);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableExp d1atlExpression = dispatcher.getD1atlExpression();
		// creations
		final @SuppressWarnings("null")@NonNull TmapVariableExp_referredVariable_Helper mapVariableExp_referredVariable_Helper = trace_ATL2QVTrFactory.eINSTANCE.createTmapVariableExp_referredVariable_Helper();
		models[2/*middle*/].add(mapVariableExp_referredVariable_Helper, false);
		final @SuppressWarnings("null")@NonNull TmapVariableExp_referredVariable_VariableDeclaration mapVariableExp_referredVariable_VariableDeclaration = trace_ATL2QVTrFactory.eINSTANCE.createTmapVariableExp_referredVariable_VariableDeclaration();
		models[2/*middle*/].add(mapVariableExp_referredVariable_VariableDeclaration, false);
		// mapping statements
		dispatcher.setDomapVariableExp_referredVariable_Helper(mapVariableExp_referredVariable_Helper);
		dispatcher.setDomapVariableExp_referredVariable_VariableDeclaration(mapVariableExp_referredVariable_VariableDeclaration);
		jm_TmapVariableExp__referredVariable__VariableDecl.appendElement(mapVariableExp_referredVariable_VariableDeclaration);
		jm_TmapVariableExp__referredVariable__Helper.appendElement(mapVariableExp_referredVariable_Helper);
		final /*@Thrown*/ @Nullable Boolean mDmapVariableExp__referredVariable_domapVariableExp = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mDmapVariableExp__referredVariable_domapVariableExp ? "done "  : "fail ") + "MAP_mDmapVariableExp__referredVariable_domapVariableExp");
		}
		return mDmapVariableExp__referredVariable_domapVariableExp;
	}

	/**
	 *
	 * map mTmapVariableExp__referredVariable__Helper_t1atlVar_p0 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 * var atlExpression : OCL::VariableExp[1] := dispatcher.d1atlExpression;
	 * var atlVariable : OCL::VariableDeclaration[1] := atlExpression.referredVariable;
	 * set trace.t1atlVariable := atlVariable;
	 *
	 */
	protected boolean MAP_mTmapVariableExp__referredVariable__Helper_t1atlVar_p0(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_Helper trace_15)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapVariableExp__referredVariable__Helper_t1atlVar_p0" + ", " + trace_15);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher_0 = trace_15.getDispatcher();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableExp d1atlExpression = dispatcher_0.getD1atlExpression();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableDeclaration referredVariable = d1atlExpression.getReferredVariable();
		// mapping statements
		trace_15.setT1atlVariable(referredVariable);
		final /*@Thrown*/ @Nullable Boolean mTmapVariableExp__referredVariable__Helper_t1atlVar_p0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mTmapVariableExp__referredVariable__Helper_t1atlVar_p0 ? "done "  : "fail ") + "MAP_mTmapVariableExp__referredVariable__Helper_t1atlVar_p0");
		}
		return mTmapVariableExp__referredVariable__Helper_t1atlVar_p0;
	}

	/**
	 *
	 * map mTmapVariableExp__referredVariable__VariableDeclara_p0 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1];
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 * var atlExpression : OCL::VariableExp[1] := dispatcher.d1atlExpression;
	 * check var atlVariable : ATL::PatternElement[1] := atlExpression.referredVariable;
	 * set trace.t1atlVariable := atlVariable;
	 *
	 */
	protected boolean MAP_mTmapVariableExp__referredVariable__VariableDeclara_p0(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_VariableDeclaration trace_16)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapVariableExp__referredVariable__VariableDeclara_p0" + ", " + trace_16);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher_0 = trace_16.getDispatcher();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableExp d1atlExpression = dispatcher_0.getD1atlExpression();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableDeclaration temp1_atlVariable = d1atlExpression.getReferredVariable();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlVariable instanceof PatternElement;
		/*@Thrown*/ @Nullable Boolean symbol_4;
		if (symbol_0) {
			final /*@NonInvalid*/ @NonNull PatternElement symbol_1 = (PatternElement)temp1_atlVariable;
			// mapping statements
			trace_16.setT1atlVariable(symbol_1);
			final /*@Thrown*/ @Nullable Boolean mTmapVariableExp__referredVariable__VariableDeclara_p0 = ValueUtil.TRUE_VALUE;
			symbol_4 = mTmapVariableExp__referredVariable__VariableDeclara_p0;
		}
		else {
			symbol_4 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_4 ? "done "  : "fail ") + "MAP_mTmapVariableExp__referredVariable__VariableDeclara_p0");
		}
		return symbol_4;
	}

	/**
	 *
	 * map mBinding_TmapBinding_p0 in ATL2QVTr {
	 * guard:atl atlBinding : ATL::Binding[1];
	 * append jm_TmapBinding  : trace_ATL2QVTr::TmapBinding[1];
	 * new:middle trace : trace_ATL2QVTr::TmapBinding[1];
	 * set trace.t1atlBinding := atlBinding;
	 * add jm_TmapBinding += trace;
	 *
	 */
	protected boolean MAP_mBinding_TmapBinding_p0(final /*@NonInvalid*/ @NonNull Binding atlBinding, final @NonNull Connection jm_TmapBinding)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mBinding_TmapBinding_p0" + ", " + atlBinding + ", " + jm_TmapBinding);
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapBinding trace_81 = trace_ATL2QVTrFactory.eINSTANCE.createTmapBinding();
		models[2/*middle*/].add(trace_81, false);
		// mapping statements
		trace_81.setT1atlBinding(atlBinding);
		jm_TmapBinding.appendElement(trace_81);
		final /*@Thrown*/ @Nullable Boolean mBinding_TmapBinding_p0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mBinding_TmapBinding_p0 ? "done "  : "fail ") + "MAP_mBinding_TmapBinding_p0");
		}
		return mBinding_TmapBinding_p0;
	}

	/**
	 *
	 * map mMatchedRule__t1atlRule_p0 in ATL2QVTr {
	 * guard:atl atlRule : ATL::MatchedRule[1];
	 * append jm_TmapInPattern__filter  : trace_ATL2QVTr::TmapInPattern_filter[1];
	 * new:middle trace : trace_ATL2QVTr::TmapInPattern_filter[1];
	 * set trace.t1atlRule := atlRule;
	 * add jm_TmapInPattern__filter += trace;
	 *
	 */
	protected boolean MAP_mMatchedRule__t1atlRule_p0(final /*@NonInvalid*/ @NonNull MatchedRule atlRule, final @NonNull Connection jm_TmapInPattern__filter)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mMatchedRule__t1atlRule_p0" + ", " + atlRule + ", " + jm_TmapInPattern__filter);
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapInPattern_filter trace_81 = trace_ATL2QVTrFactory.eINSTANCE.createTmapInPattern_filter();
		models[2/*middle*/].add(trace_81, false);
		// mapping statements
		trace_81.setT1atlRule(atlRule);
		jm_TmapInPattern__filter.appendElement(trace_81);
		final /*@Thrown*/ @Nullable Boolean mMatchedRule__t1atlRule_p0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mMatchedRule__t1atlRule_p0 ? "done "  : "fail ") + "MAP_mMatchedRule__t1atlRule_p0");
		}
		return mMatchedRule__t1atlRule_p0;
	}

	/**
	 *
	 * map mInPattern_TmapInPattern_p0 in ATL2QVTr {
	 * guard:atl atlPattern : ATL::InPattern[1];
	 * append jm_TmapInPattern  : trace_ATL2QVTr::TmapInPattern[1];
	 * new:middle trace : trace_ATL2QVTr::TmapInPattern[1];
	 * set trace.t1atlPattern := atlPattern;
	 * add jm_TmapInPattern += trace;
	 *
	 */
	protected boolean MAP_mInPattern_TmapInPattern_p0(final /*@NonInvalid*/ @NonNull InPattern atlPattern, final @NonNull Connection jm_TmapInPattern)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mInPattern_TmapInPattern_p0" + ", " + atlPattern + ", " + jm_TmapInPattern);
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapInPattern trace_81 = trace_ATL2QVTrFactory.eINSTANCE.createTmapInPattern();
		models[2/*middle*/].add(trace_81, false);
		// mapping statements
		OPPOSITE_OF_TmapInPattern_t1atlPattern.put(atlPattern, trace_81);
		trace_81.setT1atlPattern(atlPattern);
		jm_TmapInPattern.appendElement(trace_81);
		final /*@Thrown*/ @Nullable Boolean mInPattern_TmapInPattern_p0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mInPattern_TmapInPattern_p0 ? "done "  : "fail ") + "MAP_mInPattern_TmapInPattern_p0");
		}
		return mInPattern_TmapInPattern_p0;
	}

	/**
	 *
	 * map mMatchedRule_TmapMatchedRule_p0 in ATL2QVTr {
	 * guard:atl matchedRule : ATL::MatchedRule[1];
	 * append jm_TmapMatchedRule  : trace_ATL2QVTr::TmapMatchedRule[1];
	 * new:middle trace : trace_ATL2QVTr::TmapMatchedRule[1];
	 * set trace.t1matchedRule := matchedRule;
	 * add jm_TmapMatchedRule += trace;
	 *
	 */
	protected boolean MAP_mMatchedRule_TmapMatchedRule_p0(final @NonNull Connection jm_TmapMatchedRule, final /*@NonInvalid*/ @NonNull MatchedRule matchedRule)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mMatchedRule_TmapMatchedRule_p0" + ", " + jm_TmapMatchedRule + ", " + matchedRule);
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapMatchedRule trace_81 = trace_ATL2QVTrFactory.eINSTANCE.createTmapMatchedRule();
		models[2/*middle*/].add(trace_81, false);
		// mapping statements
		OPPOSITE_OF_TmapMatchedRule_t1matchedRule.put(matchedRule, trace_81);
		trace_81.setT1matchedRule(matchedRule);
		jm_TmapMatchedRule.appendElement(trace_81);
		final /*@Thrown*/ @Nullable Boolean mMatchedRule_TmapMatchedRule_p0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mMatchedRule_TmapMatchedRule_p0 ? "done "  : "fail ") + "MAP_mMatchedRule_TmapMatchedRule_p0");
		}
		return mMatchedRule_TmapMatchedRule_p0;
	}

	/**
	 *
	 * map mMatchedRule_TmapMatchedRule_super_p0 in ATL2QVTr {
	 * guard:atl atlChildRule : ATL::MatchedRule[1];
	 * append jm_TmapMatchedRule__super  : trace_ATL2QVTr::TmapMatchedRule_super[1];
	 * new:middle trace : trace_ATL2QVTr::TmapMatchedRule_super[1];
	 * set trace.t1atlChildRule := atlChildRule;
	 * add jm_TmapMatchedRule__super += trace;
	 *
	 */
	protected boolean MAP_mMatchedRule_TmapMatchedRule_super_p0(final /*@NonInvalid*/ @NonNull MatchedRule atlChildRule, final @NonNull Connection jm_TmapMatchedRule__super)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mMatchedRule_TmapMatchedRule_super_p0" + ", " + atlChildRule + ", " + jm_TmapMatchedRule__super);
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapMatchedRule_super trace_81 = trace_ATL2QVTrFactory.eINSTANCE.createTmapMatchedRule_super();
		models[2/*middle*/].add(trace_81, false);
		// mapping statements
		trace_81.setT1atlChildRule(atlChildRule);
		jm_TmapMatchedRule__super.appendElement(trace_81);
		final /*@Thrown*/ @Nullable Boolean mMatchedRule_TmapMatchedRule_super_p0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mMatchedRule_TmapMatchedRule_super_p0 ? "done "  : "fail ") + "MAP_mMatchedRule_TmapMatchedRule_super_p0");
		}
		return mMatchedRule_TmapMatchedRule_super_p0;
	}

	/**
	 *
	 * map mModule_TmapModule_p0 in ATL2QVTr {
	 * guard:atl atlModule : ATL::Module[1];
	 * append jm_TmapModule  : trace_ATL2QVTr::TmapModule[1];
	 * new:middle trace : trace_ATL2QVTr::TmapModule[1];
	 * set trace.t1atlModule := atlModule;
	 * add jm_TmapModule += trace;
	 *
	 */
	protected boolean MAP_mModule_TmapModule_p0(final /*@NonInvalid*/ @NonNull Module atlModule, final @NonNull Connection jm_TmapModule)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mModule_TmapModule_p0" + ", " + atlModule + ", " + jm_TmapModule);
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapModule trace_81 = trace_ATL2QVTrFactory.eINSTANCE.createTmapModule();
		models[2/*middle*/].add(trace_81, false);
		// mapping statements
		OPPOSITE_OF_TmapModule_t1atlModule.put(atlModule, trace_81);
		trace_81.setT1atlModule(atlModule);
		jm_TmapModule.appendElement(trace_81);
		final /*@Thrown*/ @Nullable Boolean mModule_TmapModule_p0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mModule_TmapModule_p0 ? "done "  : "fail ") + "MAP_mModule_TmapModule_p0");
		}
		return mModule_TmapModule_p0;
	}

	/**
	 *
	 * map mTmapModule_t0txName_t2_1_t2_2_t2_3_t2_4_t2qvtrTran_p1 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapModule[1];
	 * var atlModule : ATL::Module[1] := trace.t1atlModule;
	 * var txName : String[1] := atlModule.name;
	 * new:qvtr _1 : Package[1];
	 * new:qvtr _2 : ParameterVariable[1];
	 * new:qvtr _3 : qvtbase::TypedModel[1];
	 * new:qvtr _4 : qvtrelation::RelationModel[1];
	 * new:qvtr qvtrTransformation : qvtrelation::RelationalTransformation[1];
	 * set _1.name := '';
	 * set _2.isRequired := true;
	 * set _2.name := 'this';
	 * set _3.isTrace := true;
	 * set _3.name := 'middle';
	 * set qvtrTransformation.name := txName;
	 * set trace.t0txName := txName;
	 * set _4.ownedPackages := _1;
	 * set _2.type := qvtrTransformation;
	 * set qvtrTransformation.modelParameter := _3;
	 * set qvtrTransformation.ownedContext := _2;
	 * set qvtrTransformation.owningPackage := _1;
	 * set trace.t2_1 := _1;
	 * set trace.t2_2 := _2;
	 * set trace.t2_3 := _3;
	 * set trace.t2_4 := _4;
	 * set trace.t2qvtrTransformation := qvtrTransformation;
	 *
	 */
	protected boolean MAP_mTmapModule_t0txName_t2_1_t2_2_t2_3_t2_4_t2qvtrTran_p1(final /*@NonInvalid*/ @NonNull TmapModule trace_17)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapModule_t0txName_t2_1_t2_2_t2_3_t2_4_t2qvtrTran_p1" + ", " + trace_17);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Module t1atlModule = trace_17.getT1atlModule();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String name_2 = t1atlModule.getName();
		// creations
		final @SuppressWarnings("null")org.eclipse.ocl.pivot.@NonNull Package _1 = PivotFactory.eINSTANCE.createPackage();
		models[1/*qvtr*/].add(_1, false);
		final @NonNull ParameterVariable _2 = PivotFactory.eINSTANCE.createParameterVariable();
		models[1/*qvtr*/].add(_2, false);
		final @NonNull TypedModel _3 = QVTbaseFactory.eINSTANCE.createTypedModel();
		models[1/*qvtr*/].add(_3, false);
		final @NonNull RelationModel _4 = QVTrelationFactory.eINSTANCE.createRelationModel();
		models[1/*qvtr*/].add(_4, false);
		final @NonNull RelationalTransformation qvtrTransformation = QVTrelationFactory.eINSTANCE.createRelationalTransformation();
		models[1/*qvtr*/].add(qvtrTransformation, false);
		// mapping statements
		_1.setName(STR_);
		_2.setIsRequired(ValueUtil.TRUE_VALUE);
		_2.setName(STR_this);
		_3.setIsTrace(ValueUtil.TRUE_VALUE);
		_3.setName(STR_middle);
		qvtrTransformation.setName(name_2);
		trace_17.setT0txName(name_2);
		_4.getOwnedPackages().add(_1);
		_2.setType(qvtrTransformation);
		qvtrTransformation.getModelParameter().add(_3);
		qvtrTransformation.setOwnedContext(_2);
		qvtrTransformation.setOwningPackage(_1);
		trace_17.setT2_1(_1);
		trace_17.setT2_2(_2);
		trace_17.setT2_3(_3);
		trace_17.setT2_4(_4);
		trace_17.setT2qvtrTransformation(qvtrTransformation);
		final /*@Thrown*/ @Nullable Boolean mTmapModule_t0txName_t2_1_t2_2_t2_3_t2_4_t2qvtrTran_p1 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mTmapModule_t0txName_t2_1_t2_2_t2_3_t2_4_t2qvtrTran_p1 ? "done "  : "fail ") + "MAP_mTmapModule_t0txName_t2_1_t2_2_t2_3_t2_4_t2qvtrTran_p1");
		}
		return mTmapModule_t0txName_t2_1_t2_2_t2_3_t2_4_t2qvtrTran_p1;
	}

	/**
	 *
	 * map mTmapMatchedRule_success_t0ruleName_t1atlModule_t2__p1 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapMatchedRule[1] success success;
	 * var matchedRule : ATL::MatchedRule[1] := trace.t1matchedRule;
	 * var isAbstract : Boolean[1] := matchedRule.isAbstract;
	 * var atlModule : ATL::Module[1] := matchedRule.module;
	 * var ruleName : String[1] := matchedRule.name;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t2qvtrTransformation;
	 * var TraceElement : Class[1] := qvttrace::TraceElement;
	 * new:qvtr _1 : qvtrelation::SharedVariable[1];
	 * new:qvtr qvtrRelation : qvtrelation::Relation[1];
	 * set _1.isImplicit := true;
	 * set _1.name := 'trace';
	 * set qvtrRelation.isAbstract := isAbstract;
	 * set qvtrRelation.isTopLevel := true;
	 * set qvtrRelation.name := ruleName;
	 * set trace.t0ruleName := ruleName;
	 * set _1.type := TraceElement;
	 * set qvtrRelation.transformation := qvtrTransformation;
	 * set qvtrRelation.variable := _1;
	 * set trace.t1atlModule := atlModule;
	 * set trace.t2_1 := _1;
	 * set trace.t2qvtrRelation := qvtrRelation;
	 * set trace.t2qvtrTransformation := qvtrTransformation;
	 * set trace.wmapModule := when_mapModule;
	 *
	 */
	protected boolean MAP_mTmapMatchedRule_success_t0ruleName_t1atlModule_t2__p1(final /*@NonInvalid*/ @NonNull TmapMatchedRule trace_18)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapMatchedRule_success_t0ruleName_t1atlModule_t2__p1" + ", " + trace_18);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull MatchedRule t1matchedRule = trace_18.getT1matchedRule();
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
			final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t1atlModule.get(module);
			final /*@Thrown*/ boolean symbol_1 = TmapModule != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
			if (symbol_1) {
				if (TmapModule == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull RelationalTransformation t2qvtrTransformation = TmapModule.getT2qvtrTransformation();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvttrace_c_c_TraceElement_0 = idResolver.getClass(CLSSid_TraceElement, null);
				// creations
				final @NonNull SharedVariable _1 = QVTrelationFactory.eINSTANCE.createSharedVariable();
				models[1/*qvtr*/].add(_1, false);
				final @NonNull Relation qvtrRelation = QVTrelationFactory.eINSTANCE.createRelation();
				models[1/*qvtr*/].add(qvtrRelation, false);
				// mapping statements
				_1.setIsImplicit(ValueUtil.TRUE_VALUE);
				_1.setName(STR_trace);
				qvtrRelation.setIsAbstract(isAbstract);
				qvtrRelation.setIsTopLevel(ValueUtil.TRUE_VALUE);
				qvtrRelation.setName(name_2);
				trace_18.setT0ruleName(name_2);
				_1.setType(TYP_qvttrace_c_c_TraceElement_0);
				qvtrRelation.setTransformation(t2qvtrTransformation);
				qvtrRelation.getVariable().add(_1);
				trace_18.setT1atlModule(module);
				trace_18.setT2_1(_1);
				trace_18.setT2qvtrRelation(qvtrRelation);
				trace_18.setT2qvtrTransformation(t2qvtrTransformation);
				trace_18.setWmapModule(TmapModule);
				final /*@Thrown*/ @Nullable Boolean mTmapMatchedRule_success_t0ruleName_t1atlModule_t2__p1 = ValueUtil.TRUE_VALUE;
				raw_when_mapModule = mTmapMatchedRule_success_t0ruleName_t1atlModule_t2__p1;
			}
			else {
				raw_when_mapModule = ValueUtil.FALSE_VALUE;
			}
			raw_atlModule = raw_when_mapModule;
		}
		else {
			raw_atlModule = ValueUtil.FALSE_VALUE;
		}
		trace_18.setSuccess(raw_atlModule);
		if (raw_atlModule) {
			objectManager.assigned(trace_18, trace_ATL2QVTrPackage.Literals.TMAP_MATCHED_RULE__SUCCESS, raw_atlModule);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_atlModule ? "done "  : "fail ") + "MAP_mTmapMatchedRule_success_t0ruleName_t1atlModule_t2__p1");
		}
		return raw_atlModule;
	}

	/**
	 *
	 * map mTmapMatchedRule__super_t1atlSuperRule_t2qvtrOverri_p1 in ATL2QVTr {
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
	 * set trace.wmapMatchedRule1 := when_mapMatchedRule1;
	 * set trace.wmapMatchedRule := when_mapMatchedRule;
	 *
	 */
	protected boolean MAP_mTmapMatchedRule__super_t1atlSuperRule_t2qvtrOverri_p1(final /*@NonInvalid*/ @NonNull TmapMatchedRule_super trace_19)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapMatchedRule__super_t1atlSuperRule_t2qvtrOverri_p1" + ", " + trace_19);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull MatchedRule t1atlChildRule = trace_19.getT1atlChildRule();
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
							trace_19.setT1atlSuperRule(superRule);
							trace_19.setT2qvtrOverriddenRelation(t2qvtrRelation_0);
							trace_19.setT2qvtrOverridesRelation(t2qvtrRelation);
							trace_19.setWmapMatchedRule1(TmapMatchedRule_0);
							trace_19.setWmapMatchedRule(TmapMatchedRule);
							final /*@Thrown*/ @Nullable Boolean mTmapMatchedRule__super_t1atlSuperRule_t2qvtrOverri_p1 = ValueUtil.TRUE_VALUE;
							symbol_10 = mTmapMatchedRule__super_t1atlSuperRule_t2qvtrOverri_p1;
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
			AbstractTransformer.INVOCATIONS.println((raw_when_mapMatchedRule ? "done "  : "fail ") + "MAP_mTmapMatchedRule__super_t1atlSuperRule_t2qvtrOverri_p1");
		}
		return raw_when_mapMatchedRule;
	}

	/**
	 *
	 * map mTmapNavigationOrAttributeCallExp__Helper_success_w_p1 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var atlExpression : OCL::NavigationOrAttributeCallExp[1] := dispatcher.d1atlExpression;
	 * var atlSource : OCL::OclExpression[1] := trace.t1atlSource;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlSource.DmapOclExpression;
	 * var atlModule : ATL::Module[1] := this.getModule(atlExpression)
	 *   ;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * var elements : OrderedSet(ATL::ModuleElement) := atlModule.elements;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var _'\u00ABcollect\u00BB' : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(_'1_' | _'1_'.definition)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Attribute) := _'\u00ABcollect\u00BB'->collect(_'1_' | _'1_'.feature)
	 *   ->selectByKind(OCL::Attribute)
	 *   ;
	 * var _'\u00ABselect\u00BB' : Sequence(OCL::Attribute) := selectByKind1->select(_'1_' | _'1_'.name = trace.t0propertyName)
	 *   ;
	 * var notEmpty : Boolean[1] := _'\u00ABselect\u00BB'->notEmpty()
	 *   ;
	 * check notEmpty;
	 * var _'\u00ABany\u00BB' : OCL::Attribute[1] := _'\u00ABselect\u00BB'->any(_'1_' | true)
	 *   ;
	 * var definition : OCL::OclFeatureDefinition[?] := _'\u00ABany\u00BB'.definition;
	 * var Helper1 : ATL::Helper[?] := definition?.Helper;
	 * var when_mapHelper_Attribute : trace_ATL2QVTr::DmapHelper[1] := Helper1?.DmapHelper;
	 * var propertyName : String[1] := trace.t0propertyName;
	 * var _'\u00ABcollect\u00BB1' : Sequence(OCL::OclFeature) := _'\u00ABcollect\u00BB'->collect(_'1_' | _'1_'.feature);
	 * set dispatcher.success := true;
	 * set dispatcher.result := trace;
	 * set trace.wmapHelper := when_mapHelper_Attribute;
	 * set trace.wmapModule := when_mapModule;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected boolean MAP_mTmapNavigationOrAttributeCallExp__Helper_success_w_p1(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_20)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapNavigationOrAttributeCallExp__Helper_success_w_p1" + ", " + trace_20);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_20.getDispatcher();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof NavigationOrAttributeCallExp;
		/*@Thrown*/ @Nullable Boolean symbol_12;
		if (symbol_0) {
			final /*@NonInvalid*/ @NonNull NavigationOrAttributeCallExp symbol_1 = (NavigationOrAttributeCallExp)temp1_atlExpression;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression t1atlSource = trace_20.getT1atlSource();
			final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(t1atlSource);
			final /*@NonInvalid*/ boolean symbol_2 = DmapOclExpression != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
			if (symbol_2) {
				if (DmapOclExpression == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@NonInvalid*/ @NonNull Module getModule = ((FUN_getModule)FTOR_getModule.getUniqueComputation(this, symbol_1)).instance;
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
					final /*@NonInvalid*/ @NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_elements, TYP_ATL_c_c_Helper_0);
					/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeatureDefinition);
					@NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
					/*@NonInvalid*/ @NonNull SequenceValue collect;
					while (true) {
						if (!ITERATOR__1.hasNext()) {
							collect = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull Helper _1 = (Helper)ITERATOR__1.next();
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
						/*@NonInvalid*/ @NonNull OclFeatureDefinition _1_0 = (OclFeatureDefinition)ITERATOR__1_0.next();
						/**
						 * _'1_'.feature
						 */
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OclFeature feature = _1_0.getFeature();
						//
						accumulator_0.add(feature);
					}
					final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_0, TYP_OCL_c_c_Attribute_0);
					/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Attribute);
					@NonNull Iterator<Object> ITERATOR__1_1 = selectByKind_0.iterator();
					/*@NonInvalid*/ @NonNull SequenceValue select;
					while (true) {
						if (!ITERATOR__1_1.hasNext()) {
							select = accumulator_1;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull Attribute _1_1 = (Attribute)ITERATOR__1_1.next();
						/**
						 * _'1_'.name = trace.t0propertyName
						 */
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String name_2 = _1_1.getName();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t0propertyName = trace_20.getT0propertyName();
						final /*@NonInvalid*/ boolean eq = name_2.equals(t0propertyName);
						//
						if (eq == ValueUtil.TRUE_VALUE) {
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
								throw new InvalidValueException("No matching content for 'any'");
							}
							@SuppressWarnings("null")
							/*@NonInvalid*/ @NonNull Attribute _1_2 = (Attribute)ITERATOR__1_2.next();
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
							final /*@Thrown*/ @Nullable Helper Helper_0 = (Helper)IMPPROPid_definition.evaluate(executor, CLSSid_Helper, definition_0);
							safe_definition_source = Helper_0;
						}
						/*@Caught*/ @Nullable Object CAUGHT_safe_definition_source;
						try {
							CAUGHT_safe_definition_source = safe_definition_source;
						}
						catch (Exception e) {
							CAUGHT_safe_definition_source = ValueUtil.createInvalidValue(e);
						}
						final /*@NonInvalid*/ @NonNull Object DmapHelper = CAUGHT_safe_definition_source == null;
						/*@Thrown*/ @Nullable DmapHelper safe_d1atlHelper_source;
						if (DmapHelper == Boolean.TRUE) {
							safe_d1atlHelper_source = null;
						}
						else {
							assert safe_definition_source != null;
							final /*@Thrown*/ @Nullable DmapHelper DmapHelper_0 = OPPOSITE_OF_DmapHelper_d1atlHelper.get(safe_definition_source);
							safe_d1atlHelper_source = DmapHelper_0;
						}
						final /*@Thrown*/ boolean symbol_4 = safe_d1atlHelper_source != null;
						/*@Thrown*/ @Nullable Boolean raw_when_mapHelper_Attribute;
						if (symbol_4) {
							if (safe_d1atlHelper_source == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String t0propertyName_0 = trace_20.getT0propertyName();
							// mapping statements
							dispatcher_0.setSuccess((Boolean)ValueUtil.TRUE_VALUE);
							dispatcher_0.setResult(trace_20);
							trace_20.setWmapHelper(safe_d1atlHelper_source);
							trace_20.setWmapModule(TmapModule);
							trace_20.setWmapOclExpression(DmapOclExpression);
							final /*@Thrown*/ @Nullable Boolean mTmapNavigationOrAttributeCallExp__Helper_success_w_p1 = ValueUtil.TRUE_VALUE;
							raw_when_mapHelper_Attribute = mTmapNavigationOrAttributeCallExp__Helper_success_w_p1;
						}
						else {
							raw_when_mapHelper_Attribute = ValueUtil.FALSE_VALUE;
						}
						symbol_11 = raw_when_mapHelper_Attribute;
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
		trace_20.setSuccess(symbol_12);
		if (symbol_12) {
			objectManager.assigned(trace_20, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_12);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_12 ? "done "  : "fail ") + "MAP_mTmapNavigationOrAttributeCallExp__Helper_success_w_p1");
		}
		return symbol_12;
	}

	/**
	 *
	 * map mTmapNavigationOrAttributeCallExp__Helper_t2qvtrSou_p2 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * var propertyName : String[1] := trace.t0propertyName;
	 * new:qvtr qvtrExpression : OperationCallExp[1];
	 * new:qvtr qvtrSource : VariableExp[1];
	 * set qvtrExpression.name := propertyName;
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 * set trace.t2qvtrSource := qvtrSource;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 *
	 */
	protected boolean MAP_mTmapNavigationOrAttributeCallExp__Helper_t2qvtrSou_p2(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_21)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapNavigationOrAttributeCallExp__Helper_t2qvtrSou_p2" + ", " + trace_21);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_21.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_5;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_21.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String t0propertyName = trace_21.getT0propertyName();
			// creations
			final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
			models[1/*qvtr*/].add(qvtrExpression, false);
			final org.eclipse.ocl.pivot.@NonNull VariableExp qvtrSource = PivotFactory.eINSTANCE.createVariableExp();
			models[1/*qvtr*/].add(qvtrSource, false);
			// mapping statements
			qvtrExpression.setName(t0propertyName);
			dispatcher_0.setD2qvtrExpression(qvtrExpression);
			trace_21.setT2qvtrSource(qvtrSource);
			qvtrExpression.setOwnedSource(qvtrSource);
			final /*@Thrown*/ @Nullable Boolean mTmapNavigationOrAttributeCallExp__Helper_t2qvtrSou_p2 = ValueUtil.TRUE_VALUE;
			symbol_5 = mTmapNavigationOrAttributeCallExp__Helper_t2qvtrSou_p2;
		}
		else {
			symbol_5 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_5 ? "done "  : "fail ") + "MAP_mTmapNavigationOrAttributeCallExp__Helper_t2qvtrSou_p2");
		}
		return symbol_5;
	}

	/**
	 *
	 * map mTmapOperationCallExp__Helper_success_wmapHelper_wm_p1 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var atlExpression : OCL::OperationCallExp[1] := dispatcher.d1atlExpression;
	 * var atlSource : OCL::OclExpression[1] := trace.t1atlSource;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlSource.DmapOclExpression;
	 * var _'oclIsKindOf\\nOCL::OperatorCallExp' : Boolean[1] := atlExpression.oclIsKindOf(OCL::OperatorCallExp)
	 *   ;
	 * var _'not' : Boolean[?] := not _'oclIsKindOf\\nOCL::OperatorCallExp';
	 * check _'not';
	 * var atlModule : ATL::Module[1] := this.getModule(atlExpression)
	 *   ;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * var elements : OrderedSet(ATL::ModuleElement) := atlModule.elements;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var _'\u00ABcollect\u00BB' : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(_'1_' | _'1_'.definition)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Operation) := _'\u00ABcollect\u00BB'->collect(_'1_' | _'1_'.feature)
	 *   ->selectByKind(OCL::Operation)
	 *   ;
	 * var _'\u00ABselect\u00BB' : Sequence(OCL::Operation) := selectByKind1->select(_'1_' | _'1_'.name = trace.t0operationName)
	 *   ;
	 * var notEmpty : Boolean[1] := _'\u00ABselect\u00BB'->notEmpty()
	 *   ;
	 * check notEmpty;
	 * var _'\u00ABany\u00BB' : OCL::Operation[1] := _'\u00ABselect\u00BB'->any(_'1_' | true)
	 *   ;
	 * var definition : OCL::OclFeatureDefinition[?] := _'\u00ABany\u00BB'.definition;
	 * var Helper1 : ATL::Helper[?] := definition?.Helper;
	 * var when_mapHelper_Operation : trace_ATL2QVTr::DmapHelper[1] := Helper1?.DmapHelper;
	 * var operationName : String[1] := trace.t0operationName;
	 * var _'\u00ABcollect\u00BB1' : Sequence(OCL::OclFeature) := _'\u00ABcollect\u00BB'->collect(_'1_' | _'1_'.feature);
	 * set dispatcher.success := true;
	 * set dispatcher.result := trace;
	 * set trace.wmapHelper := when_mapHelper_Operation;
	 * set trace.wmapModule := when_mapModule;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected boolean MAP_mTmapOperationCallExp__Helper_success_wmapHelper_wm_p1(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_22)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperationCallExp__Helper_success_wmapHelper_wm_p1" + ", " + trace_22);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_22.getDispatcher();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof org.eclipse.m2m.atl.common.OCL.OperationCallExp;
		/*@Thrown*/ @Nullable Boolean symbol_13;
		if (symbol_0) {
			final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull OperationCallExp symbol_1 = (org.eclipse.m2m.atl.common.OCL.OperationCallExp)temp1_atlExpression;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression t1atlSource = trace_22.getT1atlSource();
			final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(t1atlSource);
			final /*@NonInvalid*/ boolean symbol_2 = DmapOclExpression != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
			if (symbol_2) {
				if (DmapOclExpression == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_OperatorCallExp_0 = idResolver.getClass(CLSSid_OperatorCallExp, null);
				final /*@NonInvalid*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, symbol_1, TYP_OCL_c_c_OperatorCallExp_0).booleanValue();
				final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
				if (not == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_12;
				if (not) {
					final /*@NonInvalid*/ @NonNull Module getModule = ((FUN_getModule)FTOR_getModule.getUniqueComputation(this, symbol_1)).instance;
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
						final /*@NonInvalid*/ @NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_elements, TYP_ATL_c_c_Helper_0);
						/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeatureDefinition);
						@NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
						/*@NonInvalid*/ @NonNull SequenceValue collect;
						while (true) {
							if (!ITERATOR__1.hasNext()) {
								collect = accumulator;
								break;
							}
							@SuppressWarnings("null")
							/*@NonInvalid*/ @NonNull Helper _1 = (Helper)ITERATOR__1.next();
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
							/*@NonInvalid*/ @NonNull OclFeatureDefinition _1_0 = (OclFeatureDefinition)ITERATOR__1_0.next();
							/**
							 * _'1_'.feature
							 */
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OclFeature feature = _1_0.getFeature();
							//
							accumulator_0.add(feature);
						}
						final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_0, TYP_OCL_c_c_Operation_0);
						/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
						@NonNull Iterator<Object> ITERATOR__1_1 = selectByKind_0.iterator();
						/*@NonInvalid*/ @NonNull SequenceValue select;
						while (true) {
							if (!ITERATOR__1_1.hasNext()) {
								select = accumulator_1;
								break;
							}
							@SuppressWarnings("null")
							/*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation _1_1 = (org.eclipse.m2m.atl.common.OCL.Operation)ITERATOR__1_1.next();
							/**
							 * _'1_'.name = trace.t0operationName
							 */
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String name_2 = _1_1.getName();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String t0operationName = trace_22.getT0operationName();
							final /*@NonInvalid*/ boolean eq = name_2.equals(t0operationName);
							//
							if (eq == ValueUtil.TRUE_VALUE) {
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
									throw new InvalidValueException("No matching content for 'any'");
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation _1_2 = (org.eclipse.m2m.atl.common.OCL.Operation)ITERATOR__1_2.next();
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
								final /*@Thrown*/ @Nullable Helper Helper_0 = (Helper)IMPPROPid_definition.evaluate(executor, CLSSid_Helper, definition_0);
								safe_definition_source = Helper_0;
							}
							/*@Caught*/ @Nullable Object CAUGHT_safe_definition_source;
							try {
								CAUGHT_safe_definition_source = safe_definition_source;
							}
							catch (Exception e) {
								CAUGHT_safe_definition_source = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @NonNull Object DmapHelper = CAUGHT_safe_definition_source == null;
							/*@Thrown*/ @Nullable DmapHelper safe_d1atlHelper_source;
							if (DmapHelper == Boolean.TRUE) {
								safe_d1atlHelper_source = null;
							}
							else {
								assert safe_definition_source != null;
								final /*@Thrown*/ @Nullable DmapHelper DmapHelper_0 = OPPOSITE_OF_DmapHelper_d1atlHelper.get(safe_definition_source);
								safe_d1atlHelper_source = DmapHelper_0;
							}
							final /*@Thrown*/ boolean symbol_4 = safe_d1atlHelper_source != null;
							/*@Thrown*/ @Nullable Boolean raw_when_mapHelper_Operation;
							if (symbol_4) {
								if (safe_d1atlHelper_source == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull String t0operationName_0 = trace_22.getT0operationName();
								// mapping statements
								dispatcher_0.setSuccess((Boolean)ValueUtil.TRUE_VALUE);
								dispatcher_0.setResult(trace_22);
								trace_22.setWmapHelper(safe_d1atlHelper_source);
								trace_22.setWmapModule(TmapModule);
								trace_22.setWmapOclExpression(DmapOclExpression);
								final /*@Thrown*/ @Nullable Boolean mTmapOperationCallExp__Helper_success_wmapHelper_wm_p1 = ValueUtil.TRUE_VALUE;
								raw_when_mapHelper_Operation = mTmapOperationCallExp__Helper_success_wmapHelper_wm_p1;
							}
							else {
								raw_when_mapHelper_Operation = ValueUtil.FALSE_VALUE;
							}
							symbol_11 = raw_when_mapHelper_Operation;
						}
						else {
							symbol_11 = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapModule = symbol_11;
					}
					else {
						raw_when_mapModule = ValueUtil.FALSE_VALUE;
					}
					symbol_12 = raw_when_mapModule;
				}
				else {
					symbol_12 = ValueUtil.FALSE_VALUE;
				}
				raw_when_mapOclExpression = symbol_12;
			}
			else {
				raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
			}
			symbol_13 = raw_when_mapOclExpression;
		}
		else {
			symbol_13 = ValueUtil.FALSE_VALUE;
		}
		trace_22.setSuccess(symbol_13);
		if (symbol_13) {
			objectManager.assigned(trace_22, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_13);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_13 ? "done "  : "fail ") + "MAP_mTmapOperationCallExp__Helper_success_wmapHelper_wm_p1");
		}
		return symbol_13;
	}

	/**
	 *
	 * map mTmapOperationCallExp__Helper_t2qvtrSource_p2 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * var operationName : String[1] := trace.t0operationName;
	 * new:qvtr qvtrExpression : OperationCallExp[1];
	 * new:qvtr qvtrSource : VariableExp[1];
	 * set qvtrExpression.name := operationName;
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 * set trace.t2qvtrSource := qvtrSource;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 *
	 */
	protected boolean MAP_mTmapOperationCallExp__Helper_t2qvtrSource_p2(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_23)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperationCallExp__Helper_t2qvtrSource_p2" + ", " + trace_23);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_23.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_5;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_23.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String t0operationName = trace_23.getT0operationName();
			// creations
			final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
			models[1/*qvtr*/].add(qvtrExpression, false);
			final org.eclipse.ocl.pivot.@NonNull VariableExp qvtrSource = PivotFactory.eINSTANCE.createVariableExp();
			models[1/*qvtr*/].add(qvtrSource, false);
			// mapping statements
			qvtrExpression.setName(t0operationName);
			dispatcher_0.setD2qvtrExpression(qvtrExpression);
			trace_23.setT2qvtrSource(qvtrSource);
			qvtrExpression.setOwnedSource(qvtrSource);
			final /*@Thrown*/ @Nullable Boolean mTmapOperationCallExp__Helper_t2qvtrSource_p2 = ValueUtil.TRUE_VALUE;
			symbol_5 = mTmapOperationCallExp__Helper_t2qvtrSource_p2;
		}
		else {
			symbol_5 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_5 ? "done "  : "fail ") + "MAP_mTmapOperationCallExp__Helper_t2qvtrSource_p2");
		}
		return symbol_5;
	}

	/**
	 *
	 * map mTmapOperatorCallExp_success_wmapModule_wmapOclExpr_p1 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapOperatorCallExp[1] success success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var atlExpression : OCL::OperatorCallExp[1] := dispatcher.d1atlExpression;
	 * var atlSource : OCL::OclExpression[1] := trace.t1atlSource;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlSource.DmapOclExpression;
	 * var atlModule : ATL::Module[1] := this.getModule(atlExpression);
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * set dispatcher.success := true;
	 * set dispatcher.result := trace;
	 * set trace.wmapModule := when_mapModule;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected boolean MAP_mTmapOperatorCallExp_success_wmapModule_wmapOclExpr_p1(final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace_24)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperatorCallExp_success_wmapModule_wmapOclExpr_p1" + ", " + trace_24);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_24.getDispatcher();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = dispatcher_0.getD1atlExpression();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof OperatorCallExp;
		/*@Thrown*/ @Nullable Boolean symbol_9;
		if (symbol_0) {
			final /*@NonInvalid*/ @NonNull OperatorCallExp symbol_1 = (OperatorCallExp)temp1_atlExpression;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression t1atlSource = trace_24.getT1atlSource();
			final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(t1atlSource);
			final /*@NonInvalid*/ boolean symbol_2 = DmapOclExpression != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
			if (symbol_2) {
				if (DmapOclExpression == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@NonInvalid*/ @NonNull Module getModule = ((FUN_getModule)FTOR_getModule.getUniqueComputation(this, symbol_1)).instance;
				final /*@NonInvalid*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t1atlModule.get(getModule);
				final /*@NonInvalid*/ boolean symbol_3 = TmapModule != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
				if (symbol_3) {
					if (TmapModule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					// mapping statements
					dispatcher_0.setSuccess((Boolean)ValueUtil.TRUE_VALUE);
					dispatcher_0.setResult(trace_24);
					trace_24.setWmapModule(TmapModule);
					trace_24.setWmapOclExpression(DmapOclExpression);
					final /*@Thrown*/ @Nullable Boolean mTmapOperatorCallExp_success_wmapModule_wmapOclExpr_p1 = ValueUtil.TRUE_VALUE;
					raw_when_mapModule = mTmapOperatorCallExp_success_wmapModule_wmapOclExpr_p1;
				}
				else {
					raw_when_mapModule = ValueUtil.FALSE_VALUE;
				}
				raw_when_mapOclExpression = raw_when_mapModule;
			}
			else {
				raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
			}
			symbol_9 = raw_when_mapOclExpression;
		}
		else {
			symbol_9 = ValueUtil.FALSE_VALUE;
		}
		trace_24.setSuccess(symbol_9);
		if (symbol_9) {
			objectManager.assigned(trace_24, trace_ATL2QVTrPackage.Literals.IMAP_OCL_EXPRESSION__SUCCESS, symbol_9);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_9 ? "done "  : "fail ") + "MAP_mTmapOperatorCallExp_success_wmapModule_wmapOclExpr_p1");
		}
		return symbol_9;
	}

	/**
	 *
	 * map mDmapOclExpression_success in ATL2QVTr {
	 * guard:middle mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1];
	 * var mapVariableExp : trace_ATL2QVTr::TmapVariableExp[1] := mapOclExpression.domapVariableExp;
	 * check mapVariableExp.success = false;
	 * var mapIfExp : trace_ATL2QVTr::TmapIfExp[1] := mapOclExpression.domapIfExp;
	 * check mapIfExp.success = false;
	 * var mapOperationCallExp_Operation : trace_ATL2QVTr::TmapOperationCallExp_Operation[1] := mapOclExpression.domapOperationCallExp_Operation;
	 * check mapOperationCallExp_Operation.success = false;
	 * var mapIntegerExp : trace_ATL2QVTr::TmapIntegerExp[1] := mapOclExpression.domapIntegerExp;
	 * check mapIntegerExp.success = false;
	 * var mapNavigationOrAttributeCallExp_Helper : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1] := mapOclExpression.domapNavigationOrAttributeCallExp_Helper;
	 * check mapNavigationOrAttributeCallExp_Helper.success = false;
	 * var mapOperatorCallExp : trace_ATL2QVTr::TmapOperatorCallExp[1] := mapOclExpression.domapOperatorCallExp;
	 * check mapOperatorCallExp.success = false;
	 * var mapNavigationOrAttributeCallExp_Property : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1] := mapOclExpression.domapNavigationOrAttributeCallExp_Property;
	 * check mapNavigationOrAttributeCallExp_Property.success = false;
	 * var mapStringExp : trace_ATL2QVTr::TmapStringExp[1] := mapOclExpression.domapStringExp;
	 * check mapStringExp.success = false;
	 * var mapBooleanExp : trace_ATL2QVTr::TmapBooleanExp[1] := mapOclExpression.domapBooleanExp;
	 * check mapBooleanExp.success = false;
	 * var mapOperationCallExp_Helper : trace_ATL2QVTr::TmapOperationCallExp_Helper[1] := mapOclExpression.domapOperationCallExp_Helper;
	 * check mapOperationCallExp_Helper.success = false;
	 * set mapOclExpression.success := false;
	 *
	 */
	protected boolean MAP_mDmapOclExpression_success(final /*@NonInvalid*/ @NonNull DmapOclExpression mapOclExpression)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mDmapOclExpression_success" + ", " + mapOclExpression);
		}
		final /*@NonInvalid*/ @Nullable TmapVariableExp domapVariableExp = mapOclExpression.getDomapVariableExp();
		final /*@NonInvalid*/ boolean symbol_0 = domapVariableExp != null;
		/*@Thrown*/ @Nullable Boolean raw_mapVariableExp;
		if (symbol_0) {
			if (domapVariableExp == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean success = domapVariableExp.getSuccess();
			final /*@Thrown*/ boolean eq = success == Boolean.FALSE;
			/*@Thrown*/ @Nullable Boolean symbol_21;
			if (eq) {
				final /*@NonInvalid*/ @Nullable TmapIfExp domapIfExp = mapOclExpression.getDomapIfExp();
				final /*@NonInvalid*/ boolean symbol_1 = domapIfExp != null;
				/*@Thrown*/ @Nullable Boolean raw_mapIfExp;
				if (symbol_1) {
					if (domapIfExp == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable Boolean success_0 = domapIfExp.getSuccess();
					final /*@Thrown*/ boolean eq_0 = success_0 == Boolean.FALSE;
					/*@Thrown*/ @Nullable Boolean symbol_20;
					if (eq_0) {
						final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Operation domapOperationCallExp_Operation = mapOclExpression.getDomapOperationCallExp_Operation();
						final /*@NonInvalid*/ boolean symbol_2 = domapOperationCallExp_Operation != null;
						/*@Thrown*/ @Nullable Boolean raw_mapOperationCallExp_Operation;
						if (symbol_2) {
							if (domapOperationCallExp_Operation == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							final /*@Thrown*/ @Nullable Boolean success_1 = domapOperationCallExp_Operation.getSuccess();
							final /*@Thrown*/ boolean eq_1 = success_1 == Boolean.FALSE;
							/*@Thrown*/ @Nullable Boolean symbol_19;
							if (eq_1) {
								final /*@NonInvalid*/ @Nullable TmapIntegerExp domapIntegerExp = mapOclExpression.getDomapIntegerExp();
								final /*@NonInvalid*/ boolean symbol_3 = domapIntegerExp != null;
								/*@Thrown*/ @Nullable Boolean raw_mapIntegerExp;
								if (symbol_3) {
									if (domapIntegerExp == null) {
										throw new InvalidEvaluationException("Null where non-null value required");
									}
									final /*@Thrown*/ @Nullable Boolean success_2 = domapIntegerExp.getSuccess();
									final /*@Thrown*/ boolean eq_2 = success_2 == Boolean.FALSE;
									/*@Thrown*/ @Nullable Boolean symbol_18;
									if (eq_2) {
										final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Helper domapNavigationOrAttributeCallExp_Helper = mapOclExpression.getDomapNavigationOrAttributeCallExp_Helper();
										final /*@NonInvalid*/ boolean symbol_4 = domapNavigationOrAttributeCallExp_Helper != null;
										/*@Thrown*/ @Nullable Boolean raw_mapNavigationOrAttributeCallExp_Helper;
										if (symbol_4) {
											if (domapNavigationOrAttributeCallExp_Helper == null) {
												throw new InvalidEvaluationException("Null where non-null value required");
											}
											final /*@Thrown*/ @Nullable Boolean success_3 = domapNavigationOrAttributeCallExp_Helper.getSuccess();
											final /*@Thrown*/ boolean eq_3 = success_3 == Boolean.FALSE;
											/*@Thrown*/ @Nullable Boolean symbol_17;
											if (eq_3) {
												final /*@NonInvalid*/ @Nullable TmapOperatorCallExp domapOperatorCallExp = mapOclExpression.getDomapOperatorCallExp();
												final /*@NonInvalid*/ boolean symbol_5 = domapOperatorCallExp != null;
												/*@Thrown*/ @Nullable Boolean raw_mapOperatorCallExp;
												if (symbol_5) {
													if (domapOperatorCallExp == null) {
														throw new InvalidEvaluationException("Null where non-null value required");
													}
													final /*@Thrown*/ @Nullable Boolean success_4 = domapOperatorCallExp.getSuccess();
													final /*@Thrown*/ boolean eq_4 = success_4 == Boolean.FALSE;
													/*@Thrown*/ @Nullable Boolean symbol_16;
													if (eq_4) {
														final /*@NonInvalid*/ @Nullable TmapNavigationOrAttributeCallExp_Property domapNavigationOrAttributeCallExp_Property = mapOclExpression.getDomapNavigationOrAttributeCallExp_Property();
														final /*@NonInvalid*/ boolean symbol_6 = domapNavigationOrAttributeCallExp_Property != null;
														/*@Thrown*/ @Nullable Boolean raw_mapNavigationOrAttributeCallExp_Property;
														if (symbol_6) {
															if (domapNavigationOrAttributeCallExp_Property == null) {
																throw new InvalidEvaluationException("Null where non-null value required");
															}
															final /*@Thrown*/ @Nullable Boolean success_5 = domapNavigationOrAttributeCallExp_Property.getSuccess();
															final /*@Thrown*/ boolean eq_5 = success_5 == Boolean.FALSE;
															/*@Thrown*/ @Nullable Boolean symbol_15;
															if (eq_5) {
																final /*@NonInvalid*/ @Nullable TmapStringExp domapStringExp = mapOclExpression.getDomapStringExp();
																final /*@NonInvalid*/ boolean symbol_7 = domapStringExp != null;
																/*@Thrown*/ @Nullable Boolean raw_mapStringExp;
																if (symbol_7) {
																	if (domapStringExp == null) {
																		throw new InvalidEvaluationException("Null where non-null value required");
																	}
																	final /*@Thrown*/ @Nullable Boolean success_6 = domapStringExp.getSuccess();
																	final /*@Thrown*/ boolean eq_6 = success_6 == Boolean.FALSE;
																	/*@Thrown*/ @Nullable Boolean symbol_14;
																	if (eq_6) {
																		final /*@NonInvalid*/ @Nullable TmapBooleanExp domapBooleanExp = mapOclExpression.getDomapBooleanExp();
																		final /*@NonInvalid*/ boolean symbol_8 = domapBooleanExp != null;
																		/*@Thrown*/ @Nullable Boolean raw_mapBooleanExp;
																		if (symbol_8) {
																			if (domapBooleanExp == null) {
																				throw new InvalidEvaluationException("Null where non-null value required");
																			}
																			final /*@Thrown*/ @Nullable Boolean success_7 = domapBooleanExp.getSuccess();
																			final /*@Thrown*/ boolean eq_7 = success_7 == Boolean.FALSE;
																			/*@Thrown*/ @Nullable Boolean symbol_13;
																			if (eq_7) {
																				final /*@NonInvalid*/ @Nullable TmapOperationCallExp_Helper domapOperationCallExp_Helper = mapOclExpression.getDomapOperationCallExp_Helper();
																				final /*@NonInvalid*/ boolean symbol_9 = domapOperationCallExp_Helper != null;
																				/*@Thrown*/ @Nullable Boolean raw_mapOperationCallExp_Helper;
																				if (symbol_9) {
																					if (domapOperationCallExp_Helper == null) {
																						throw new InvalidEvaluationException("Null where non-null value required");
																					}
																					final /*@Thrown*/ @Nullable Boolean success_8 = domapOperationCallExp_Helper.getSuccess();
																					final /*@Thrown*/ boolean eq_8 = success_8 == Boolean.FALSE;
																					/*@Thrown*/ @Nullable Boolean symbol_12;
																					if (eq_8) {
																						// mapping statements
																						mapOclExpression.setSuccess((Boolean)ValueUtil.FALSE_VALUE);
																						final /*@Thrown*/ @Nullable Boolean mDmapOclExpression_success = ValueUtil.TRUE_VALUE;
																						symbol_12 = mDmapOclExpression_success;
																					}
																					else {
																						symbol_12 = ValueUtil.FALSE_VALUE;
																					}
																					raw_mapOperationCallExp_Helper = symbol_12;
																				}
																				else {
																					raw_mapOperationCallExp_Helper = ValueUtil.FALSE_VALUE;
																				}
																				symbol_13 = raw_mapOperationCallExp_Helper;
																			}
																			else {
																				symbol_13 = ValueUtil.FALSE_VALUE;
																			}
																			raw_mapBooleanExp = symbol_13;
																		}
																		else {
																			raw_mapBooleanExp = ValueUtil.FALSE_VALUE;
																		}
																		symbol_14 = raw_mapBooleanExp;
																	}
																	else {
																		symbol_14 = ValueUtil.FALSE_VALUE;
																	}
																	raw_mapStringExp = symbol_14;
																}
																else {
																	raw_mapStringExp = ValueUtil.FALSE_VALUE;
																}
																symbol_15 = raw_mapStringExp;
															}
															else {
																symbol_15 = ValueUtil.FALSE_VALUE;
															}
															raw_mapNavigationOrAttributeCallExp_Property = symbol_15;
														}
														else {
															raw_mapNavigationOrAttributeCallExp_Property = ValueUtil.FALSE_VALUE;
														}
														symbol_16 = raw_mapNavigationOrAttributeCallExp_Property;
													}
													else {
														symbol_16 = ValueUtil.FALSE_VALUE;
													}
													raw_mapOperatorCallExp = symbol_16;
												}
												else {
													raw_mapOperatorCallExp = ValueUtil.FALSE_VALUE;
												}
												symbol_17 = raw_mapOperatorCallExp;
											}
											else {
												symbol_17 = ValueUtil.FALSE_VALUE;
											}
											raw_mapNavigationOrAttributeCallExp_Helper = symbol_17;
										}
										else {
											raw_mapNavigationOrAttributeCallExp_Helper = ValueUtil.FALSE_VALUE;
										}
										symbol_18 = raw_mapNavigationOrAttributeCallExp_Helper;
									}
									else {
										symbol_18 = ValueUtil.FALSE_VALUE;
									}
									raw_mapIntegerExp = symbol_18;
								}
								else {
									raw_mapIntegerExp = ValueUtil.FALSE_VALUE;
								}
								symbol_19 = raw_mapIntegerExp;
							}
							else {
								symbol_19 = ValueUtil.FALSE_VALUE;
							}
							raw_mapOperationCallExp_Operation = symbol_19;
						}
						else {
							raw_mapOperationCallExp_Operation = ValueUtil.FALSE_VALUE;
						}
						symbol_20 = raw_mapOperationCallExp_Operation;
					}
					else {
						symbol_20 = ValueUtil.FALSE_VALUE;
					}
					raw_mapIfExp = symbol_20;
				}
				else {
					raw_mapIfExp = ValueUtil.FALSE_VALUE;
				}
				symbol_21 = raw_mapIfExp;
			}
			else {
				symbol_21 = ValueUtil.FALSE_VALUE;
			}
			raw_mapVariableExp = symbol_21;
		}
		else {
			raw_mapVariableExp = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_mapVariableExp ? "done "  : "fail ") + "MAP_mDmapOclExpression_success");
		}
		return raw_mapVariableExp;
	}

	/**
	 *
	 * map mTmapOperatorCallExp_t2qvtrTransformation_p6 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := trace.wmapModule;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t2qvtrTransformation;
	 * set trace.t2qvtrTransformation := qvtrTransformation;
	 *
	 */
	protected boolean MAP_mTmapOperatorCallExp_t2qvtrTransformation_p6(final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace_25)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperatorCallExp_t2qvtrTransformation_p6" + ", " + trace_25);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_25.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_3;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_25.getDispatcher();
			final /*@NonInvalid*/ @Nullable TmapModule wmapModule = trace_25.getWmapModule();
			final /*@NonInvalid*/ boolean symbol_0 = wmapModule != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
			if (symbol_0) {
				if (wmapModule == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull RelationalTransformation t2qvtrTransformation = wmapModule.getT2qvtrTransformation();
				// mapping statements
				trace_25.setT2qvtrTransformation(t2qvtrTransformation);
				final /*@Thrown*/ @Nullable Boolean mTmapOperatorCallExp_t2qvtrTransformation_p6 = ValueUtil.TRUE_VALUE;
				raw_when_mapModule = mTmapOperatorCallExp_t2qvtrTransformation_p6;
			}
			else {
				raw_when_mapModule = ValueUtil.FALSE_VALUE;
			}
			symbol_3 = raw_when_mapModule;
		}
		else {
			symbol_3 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_3 ? "done "  : "fail ") + "MAP_mTmapOperatorCallExp_t2qvtrTransformation_p6");
		}
		return symbol_3;
	}

	/**
	 *
	 * map mTmapOperatorCallExp__DmapOclExpression_d2qvtrExpre_p2 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * var operationName : String[1] := trace.t0operationName;
	 * new:qvtr qvtrExpression : OperationCallExp[1];
	 * set qvtrExpression.name := operationName;
	 * set dispatcher.d2qvtrExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_mTmapOperatorCallExp__DmapOclExpression_d2qvtrExpre_p2(final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace_26)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperatorCallExp__DmapOclExpression_d2qvtrExpre_p2" + ", " + trace_26);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_26.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_3;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_26.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String t0operationName = trace_26.getT0operationName();
			// creations
			final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
			models[1/*qvtr*/].add(qvtrExpression, false);
			// mapping statements
			qvtrExpression.setName(t0operationName);
			dispatcher_0.setD2qvtrExpression(qvtrExpression);
			final /*@Thrown*/ @Nullable Boolean mTmapOperatorCallExp__DmapOclExpression_d2qvtrExpre_p2 = ValueUtil.TRUE_VALUE;
			symbol_3 = mTmapOperatorCallExp__DmapOclExpression_d2qvtrExpre_p2;
		}
		else {
			symbol_3 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_3 ? "done "  : "fail ") + "MAP_mTmapOperatorCallExp__DmapOclExpression_d2qvtrExpre_p2");
		}
		return symbol_3;
	}

	/**
	 *
	 * map mTmapHelper__Attribute_t0attributeName_t1atlDefinit_p0 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * var atlHelper : ATL::Helper[1] := dispatcher.d1atlHelper;
	 * var atlDefinition : OCL::OclFeatureDefinition[1] := atlHelper.definition;
	 * check var atlFeature : OCL::Attribute[1] := atlDefinition.feature;
	 * var atlModule : ATL::Module[1] := atlHelper.module;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * var atlExpression : OCL::OclExpression[1] := atlFeature.initExpression;
	 * var attributeName : String[1] := atlFeature.name;
	 * var atlType : OCL::OclType[1] := atlFeature.type;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t2qvtrTransformation;
	 * set trace.t0attributeName := attributeName;
	 * set trace.t1atlDefinition := atlDefinition;
	 * set trace.t1atlExpression := atlExpression;
	 * set trace.t1atlFeature := atlFeature;
	 * set trace.t1atlModule := atlModule;
	 * set trace.t1atlType := atlType;
	 * set trace.t2qvtrTransformation := qvtrTransformation;
	 * set trace.wmapModule := when_mapModule;
	 *
	 */
	protected boolean MAP_mTmapHelper__Attribute_t0attributeName_t1atlDefinit_p0(final /*@NonInvalid*/ @NonNull TmapHelper_Attribute trace_27)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapHelper__Attribute_t0attributeName_t1atlDefinit_p0" + ", " + trace_27);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_27.getDispatcher();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Helper d1atlHelper = dispatcher_0.getD1atlHelper();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = d1atlHelper.getDefinition();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclFeature temp1_atlFeature = definition.getFeature();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlFeature instanceof Attribute;
		/*@Thrown*/ @Nullable Boolean symbol_13;
		if (symbol_0) {
			final /*@NonInvalid*/ @NonNull Attribute symbol_1 = (Attribute)temp1_atlFeature;
			final /*@NonInvalid*/ @Nullable Module module = d1atlHelper.getModule();
			final /*@NonInvalid*/ boolean symbol_2 = module != null;
			/*@Thrown*/ @Nullable Boolean raw_atlModule;
			if (symbol_2) {
				if (module == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t1atlModule.get(module);
				final /*@Thrown*/ boolean symbol_3 = TmapModule != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
				if (symbol_3) {
					if (TmapModule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclExpression initExpression = symbol_1.getInitExpression();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String name_2 = symbol_1.getName();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclType type_2 = symbol_1.getType();
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull RelationalTransformation t2qvtrTransformation = TmapModule.getT2qvtrTransformation();
					// mapping statements
					trace_27.setT0attributeName(name_2);
					trace_27.setT1atlDefinition(definition);
					trace_27.setT1atlExpression(initExpression);
					trace_27.setT1atlFeature(symbol_1);
					trace_27.setT1atlModule(module);
					trace_27.setT1atlType(type_2);
					trace_27.setT2qvtrTransformation(t2qvtrTransformation);
					trace_27.setWmapModule(TmapModule);
					final /*@Thrown*/ @Nullable Boolean mTmapHelper__Attribute_t0attributeName_t1atlDefinit_p0 = ValueUtil.TRUE_VALUE;
					raw_when_mapModule = mTmapHelper__Attribute_t0attributeName_t1atlDefinit_p0;
				}
				else {
					raw_when_mapModule = ValueUtil.FALSE_VALUE;
				}
				raw_atlModule = raw_when_mapModule;
			}
			else {
				raw_atlModule = ValueUtil.FALSE_VALUE;
			}
			symbol_13 = raw_atlModule;
		}
		else {
			symbol_13 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_13 ? "done "  : "fail ") + "MAP_mTmapHelper__Attribute_t0attributeName_t1atlDefinit_p0");
		}
		return symbol_13;
	}

	/**
	 *
	 * map mTmapHelper__Attribute_success_wmapOclExpression_p1 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Attribute[1] success success;
	 * var atlExpression : OCL::OclExpression[1] := trace.t1atlExpression;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlExpression.DmapOclExpression;
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * set dispatcher.success := true;
	 * set dispatcher.result := trace;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected boolean MAP_mTmapHelper__Attribute_success_wmapOclExpression_p1(final /*@NonInvalid*/ @NonNull TmapHelper_Attribute trace_28)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapHelper__Attribute_success_wmapOclExpression_p1" + ", " + trace_28);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression t1atlExpression = trace_28.getT1atlExpression();
		final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(t1atlExpression);
		final /*@NonInvalid*/ boolean symbol_0 = DmapOclExpression != null;
		/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
		if (symbol_0) {
			if (DmapOclExpression == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_28.getDispatcher();
			// mapping statements
			dispatcher_0.setSuccess((Boolean)ValueUtil.TRUE_VALUE);
			dispatcher_0.setResult(trace_28);
			trace_28.setWmapOclExpression(DmapOclExpression);
			final /*@Thrown*/ @Nullable Boolean mTmapHelper__Attribute_success_wmapOclExpression_p1 = ValueUtil.TRUE_VALUE;
			raw_when_mapOclExpression = mTmapHelper__Attribute_success_wmapOclExpression_p1;
		}
		else {
			raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
		}
		trace_28.setSuccess(raw_when_mapOclExpression);
		if (raw_when_mapOclExpression) {
			objectManager.assigned(trace_28, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__SUCCESS, raw_when_mapOclExpression);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_mapOclExpression ? "done "  : "fail ") + "MAP_mTmapHelper__Attribute_success_wmapOclExpression_p1");
		}
		return raw_when_mapOclExpression;
	}

	/**
	 *
	 * map mTmapHelper__Operation_t0operationName_t1atlDefinit_p0 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * var atlHelper : ATL::Helper[1] := dispatcher.d1atlHelper;
	 * var atlDefinition : OCL::OclFeatureDefinition[1] := atlHelper.definition;
	 * check var atlFeature : OCL::Operation[1] := atlDefinition.feature;
	 * var atlModule : ATL::Module[1] := atlHelper.module;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * var atlExpression : OCL::OclExpression[1] := atlFeature.body;
	 * var operationName : String[1] := atlFeature.name;
	 * var atlType : OCL::OclType[1] := atlFeature.returnType;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t2qvtrTransformation;
	 * set trace.t0operationName := operationName;
	 * set trace.t1atlDefinition := atlDefinition;
	 * set trace.t1atlExpression := atlExpression;
	 * set trace.t1atlFeature := atlFeature;
	 * set trace.t1atlModule := atlModule;
	 * set trace.t1atlType := atlType;
	 * set trace.t2qvtrTransformation := qvtrTransformation;
	 * set trace.wmapModule := when_mapModule;
	 *
	 */
	protected boolean MAP_mTmapHelper__Operation_t0operationName_t1atlDefinit_p0(final /*@NonInvalid*/ @NonNull TmapHelper_Operation trace_29)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapHelper__Operation_t0operationName_t1atlDefinit_p0" + ", " + trace_29);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_29.getDispatcher();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Helper d1atlHelper = dispatcher_0.getD1atlHelper();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = d1atlHelper.getDefinition();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclFeature temp1_atlFeature = definition.getFeature();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlFeature instanceof org.eclipse.m2m.atl.common.OCL.Operation;
		/*@Thrown*/ @Nullable Boolean symbol_13;
		if (symbol_0) {
			final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation symbol_1 = (org.eclipse.m2m.atl.common.OCL.Operation)temp1_atlFeature;
			final /*@NonInvalid*/ @Nullable Module module = d1atlHelper.getModule();
			final /*@NonInvalid*/ boolean symbol_2 = module != null;
			/*@Thrown*/ @Nullable Boolean raw_atlModule;
			if (symbol_2) {
				if (module == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t1atlModule.get(module);
				final /*@Thrown*/ boolean symbol_3 = TmapModule != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
				if (symbol_3) {
					if (TmapModule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclExpression body = symbol_1.getBody();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String name_2 = symbol_1.getName();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OclType returnType = symbol_1.getReturnType();
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull RelationalTransformation t2qvtrTransformation = TmapModule.getT2qvtrTransformation();
					// mapping statements
					trace_29.setT0operationName(name_2);
					trace_29.setT1atlDefinition(definition);
					trace_29.setT1atlExpression(body);
					trace_29.setT1atlFeature(symbol_1);
					trace_29.setT1atlModule(module);
					trace_29.setT1atlType(returnType);
					trace_29.setT2qvtrTransformation(t2qvtrTransformation);
					trace_29.setWmapModule(TmapModule);
					final /*@Thrown*/ @Nullable Boolean mTmapHelper__Operation_t0operationName_t1atlDefinit_p0 = ValueUtil.TRUE_VALUE;
					raw_when_mapModule = mTmapHelper__Operation_t0operationName_t1atlDefinit_p0;
				}
				else {
					raw_when_mapModule = ValueUtil.FALSE_VALUE;
				}
				raw_atlModule = raw_when_mapModule;
			}
			else {
				raw_atlModule = ValueUtil.FALSE_VALUE;
			}
			symbol_13 = raw_atlModule;
		}
		else {
			symbol_13 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_13 ? "done "  : "fail ") + "MAP_mTmapHelper__Operation_t0operationName_t1atlDefinit_p0");
		}
		return symbol_13;
	}

	/**
	 *
	 * map mTmapHelper__Operation_success_wmapOclExpression_p1 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Operation[1] success success;
	 * var atlExpression : OCL::OclExpression[1] := trace.t1atlExpression;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlExpression.DmapOclExpression;
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * set dispatcher.success := true;
	 * set dispatcher.result := trace;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected boolean MAP_mTmapHelper__Operation_success_wmapOclExpression_p1(final /*@NonInvalid*/ @NonNull TmapHelper_Operation trace_30)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapHelper__Operation_success_wmapOclExpression_p1" + ", " + trace_30);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression t1atlExpression = trace_30.getT1atlExpression();
		final /*@NonInvalid*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(t1atlExpression);
		final /*@NonInvalid*/ boolean symbol_0 = DmapOclExpression != null;
		/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
		if (symbol_0) {
			if (DmapOclExpression == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_30.getDispatcher();
			// mapping statements
			dispatcher_0.setSuccess((Boolean)ValueUtil.TRUE_VALUE);
			dispatcher_0.setResult(trace_30);
			trace_30.setWmapOclExpression(DmapOclExpression);
			final /*@Thrown*/ @Nullable Boolean mTmapHelper__Operation_success_wmapOclExpression_p1 = ValueUtil.TRUE_VALUE;
			raw_when_mapOclExpression = mTmapHelper__Operation_success_wmapOclExpression_p1;
		}
		else {
			raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
		}
		trace_30.setSuccess(raw_when_mapOclExpression);
		if (raw_when_mapOclExpression) {
			objectManager.assigned(trace_30, trace_ATL2QVTrPackage.Literals.IMAP_HELPER__SUCCESS, raw_when_mapOclExpression);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_mapOclExpression ? "done "  : "fail ") + "MAP_mTmapHelper__Operation_success_wmapOclExpression_p1");
		}
		return raw_when_mapOclExpression;
	}

	/**
	 *
	 * map mDmapHelper_success in ATL2QVTr {
	 * guard:middle mapHelper : trace_ATL2QVTr::DmapHelper[1];
	 * var mapHelper_Attribute : trace_ATL2QVTr::TmapHelper_Attribute[1] := mapHelper.domapHelper_Attribute;
	 * check mapHelper_Attribute.success = false;
	 * var mapHelper_Operation : trace_ATL2QVTr::TmapHelper_Operation[1] := mapHelper.domapHelper_Operation;
	 * check mapHelper_Operation.success = false;
	 * set mapHelper.success := false;
	 *
	 */
	protected boolean MAP_mDmapHelper_success(final /*@NonInvalid*/ @NonNull DmapHelper mapHelper)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mDmapHelper_success" + ", " + mapHelper);
		}
		final /*@NonInvalid*/ @Nullable TmapHelper_Attribute domapHelper_Attribute = mapHelper.getDomapHelper_Attribute();
		final /*@NonInvalid*/ boolean symbol_0 = domapHelper_Attribute != null;
		/*@Thrown*/ @Nullable Boolean raw_mapHelper_Attribute;
		if (symbol_0) {
			if (domapHelper_Attribute == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean success = domapHelper_Attribute.getSuccess();
			final /*@Thrown*/ boolean eq = success == Boolean.FALSE;
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (eq) {
				final /*@NonInvalid*/ @Nullable TmapHelper_Operation domapHelper_Operation = mapHelper.getDomapHelper_Operation();
				final /*@NonInvalid*/ boolean symbol_1 = domapHelper_Operation != null;
				/*@Thrown*/ @Nullable Boolean raw_mapHelper_Operation;
				if (symbol_1) {
					if (domapHelper_Operation == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable Boolean success_0 = domapHelper_Operation.getSuccess();
					final /*@Thrown*/ boolean eq_0 = success_0 == Boolean.FALSE;
					/*@Thrown*/ @Nullable Boolean symbol_4;
					if (eq_0) {
						// mapping statements
						mapHelper.setSuccess((Boolean)ValueUtil.FALSE_VALUE);
						final /*@Thrown*/ @Nullable Boolean mDmapHelper_success = ValueUtil.TRUE_VALUE;
						symbol_4 = mDmapHelper_success;
					}
					else {
						symbol_4 = ValueUtil.FALSE_VALUE;
					}
					raw_mapHelper_Operation = symbol_4;
				}
				else {
					raw_mapHelper_Operation = ValueUtil.FALSE_VALUE;
				}
				symbol_5 = raw_mapHelper_Operation;
			}
			else {
				symbol_5 = ValueUtil.FALSE_VALUE;
			}
			raw_mapHelper_Attribute = symbol_5;
		}
		else {
			raw_mapHelper_Attribute = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_mapHelper_Attribute ? "done "  : "fail ") + "MAP_mDmapHelper_success");
		}
		return raw_mapHelper_Attribute;
	}

	/**
	 *
	 * map mOclModel_TmapOclMetamodel_p0 in ATL2QVTr {
	 * guard:atl oclMetamodel : OCL::OclModel[1];
	 * append jm_TmapOclMetamodel  : trace_ATL2QVTr::TmapOclMetamodel[1];
	 * new:middle trace : trace_ATL2QVTr::TmapOclMetamodel[1];
	 * set trace.t1oclMetamodel := oclMetamodel;
	 * add jm_TmapOclMetamodel += trace;
	 *
	 */
	protected boolean MAP_mOclModel_TmapOclMetamodel_p0(final @NonNull Connection jm_TmapOclMetamodel, final /*@NonInvalid*/ @NonNull OclModel oclMetamodel)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mOclModel_TmapOclMetamodel_p0" + ", " + jm_TmapOclMetamodel + ", " + oclMetamodel);
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapOclMetamodel trace_81 = trace_ATL2QVTrFactory.eINSTANCE.createTmapOclMetamodel();
		models[2/*middle*/].add(trace_81, false);
		// mapping statements
		OPPOSITE_OF_TmapOclMetamodel_t1oclMetamodel.put(oclMetamodel, trace_81);
		trace_81.setT1oclMetamodel(oclMetamodel);
		jm_TmapOclMetamodel.appendElement(trace_81);
		final /*@Thrown*/ @Nullable Boolean mOclModel_TmapOclMetamodel_p0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mOclModel_TmapOclMetamodel_p0 ? "done "  : "fail ") + "MAP_mOclModel_TmapOclMetamodel_p0");
		}
		return mOclModel_TmapOclMetamodel_p0;
	}

	/**
	 *
	 * map mTmapOclMetamodel_t0tmName_t2qvtrTypedModel_p1 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapOclMetamodel[1];
	 * var oclMetamodel : OCL::OclModel[1] := trace.t1oclMetamodel;
	 * var model : Set(OCL::OclModel) := oclMetamodel.model;
	 * var notEmpty : Boolean[1] := model->notEmpty();
	 * check notEmpty;
	 * var tmName : String[1] := oclMetamodel.name;
	 * new:qvtr qvtrTypedModel : qvtbase::TypedModel[1];
	 * set qvtrTypedModel.name := tmName;
	 * set trace.t0tmName := tmName;
	 * set trace.t2qvtrTypedModel := qvtrTypedModel;
	 *
	 */
	protected boolean MAP_mTmapOclMetamodel_t0tmName_t2qvtrTypedModel_p1(final /*@NonInvalid*/ @NonNull TmapOclMetamodel trace_31)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOclMetamodel_t0tmName_t2qvtrTypedModel_p1" + ", " + trace_31);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclModel t1oclMetamodel = trace_31.getT1oclMetamodel();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull List<OclModel> model = t1oclMetamodel.getModel();
		final /*@NonInvalid*/ @NonNull SetValue BOXED_model = idResolver.createSetOfAll(SET_CLSSid_OclModel, model);
		final /*@NonInvalid*/ boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(BOXED_model).booleanValue();
		/*@Thrown*/ @Nullable Boolean symbol_4;
		if (notEmpty) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name_2 = t1oclMetamodel.getName();
			// creations
			final @NonNull TypedModel qvtrTypedModel = QVTbaseFactory.eINSTANCE.createTypedModel();
			models[1/*qvtr*/].add(qvtrTypedModel, false);
			// mapping statements
			qvtrTypedModel.setName(name_2);
			trace_31.setT0tmName(name_2);
			trace_31.setT2qvtrTypedModel(qvtrTypedModel);
			final /*@Thrown*/ @Nullable Boolean mTmapOclMetamodel_t0tmName_t2qvtrTypedModel_p1 = ValueUtil.TRUE_VALUE;
			symbol_4 = mTmapOclMetamodel_t0tmName_t2qvtrTypedModel_p1;
		}
		else {
			symbol_4 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_4 ? "done "  : "fail ") + "MAP_mTmapOclMetamodel_t0tmName_t2qvtrTypedModel_p1");
		}
		return symbol_4;
	}

	/**
	 *
	 * map mTmapInPattern_success_t1atlModel_t1atlRule_t2qvtrD_p1 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapInPattern[1] success success;
	 * var atlPattern : ATL::InPattern[1] := trace.t1atlPattern;
	 * var atlRule : ATL::MatchedRule[1] := atlPattern.rule;
	 * var when_mapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1] := atlRule.TmapMatchedRule;
	 * check when_mapMatchedRule.success;
	 * var elements : Set(ATL::InPatternElement[+|1]) := atlPattern.elements;
	 * var qvtrRelation : qvtrelation::Relation[1] := when_mapMatchedRule.t2qvtrRelation;
	 * var selectByKind : Bag(OCL::OclModelElement) := elements->collect(_'1_' | _'1_'.type)
	 *   ->selectByKind(OCL::OclModelElement)
	 *   ;
	 * var _'\u00ABcollect\u00BB' : Bag(OCL::OclType[*|?]) := elements->collect(_'1_' | _'1_'.type)
	 *   ;
	 * var _'\u00ABany\u00BB' : OCL::OclModelElement[1] := selectByKind->any(_'1_' | true);
	 * var atlModel : OCL::OclModel[1] := _'\u00ABany\u00BB'.model;
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
	protected boolean MAP_mTmapInPattern_success_t1atlModel_t1atlRule_t2qvtrD_p1(final /*@NonInvalid*/ @NonNull TmapInPattern trace_32)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapInPattern_success_t1atlModel_t1atlRule_t2qvtrD_p1" + ", " + trace_32);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull InPattern t1atlPattern = trace_32.getT1atlPattern();
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
			/*@Thrown*/ @Nullable Boolean symbol_14;
			if (success) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<InPatternElement> elements = t1atlPattern.getElements();
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull Relation t2qvtrRelation = TmapMatchedRule.getT2qvtrRelation();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_OclModelElement_0 = idResolver.getClass(CLSSid_OclModelElement, null);
				final /*@NonInvalid*/ @NonNull SetValue BOXED_elements_0 = idResolver.createSetOfAll(SET_CLSSid_InPatternElement, elements);
				/*@Thrown*/ BagValue.@NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_OclType);
				@NonNull Iterator<Object> ITERATOR__1_0 = BOXED_elements_0.iterator();
				/*@Thrown*/ @NonNull BagValue collect_0;
				while (true) {
					if (!ITERATOR__1_0.hasNext()) {
						collect_0 = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull InPatternElement _1_0 = (InPatternElement)ITERATOR__1_0.next();
					/**
					 * _'1_'.type
					 */
					final /*@NonInvalid*/ @Nullable OclType type_3 = _1_0.getType();
					//
					accumulator.add(type_3);
				}
				final /*@Thrown*/ @NonNull BagValue selectByKind = (BagValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_0, TYP_OCL_c_c_OclModelElement_0);
				@NonNull Iterator<Object> ITERATOR__1_1 = selectByKind.iterator();
				/*@Thrown*/ @NonNull OclModelElement any;
				while (true) {
					if (!ITERATOR__1_1.hasNext()) {
						throw new InvalidValueException("No matching content for 'any'");
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull OclModelElement _1_1 = (OclModelElement)ITERATOR__1_1.next();
					/**
					 * true
					 */
					//
					if (ValueUtil.TRUE_VALUE != ValueUtil.FALSE_VALUE) {			// Carry on till something found
						any = _1_1;
						break;
					}
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull OclModel model = any.getModel();
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
					// mapping statements
					qvtrDomain.setIsCheckable(ValueUtil.TRUE_VALUE);
					qvtrDomain.setIsEnforceable(ValueUtil.FALSE_VALUE);
					qvtrDomain.setRule(t2qvtrRelation);
					qvtrDomain.setTypedModel(t2qvtrTypedModel);
					trace_32.setT1atlModel(model);
					trace_32.setT1atlRule(rule);
					trace_32.setT2qvtrDomain(qvtrDomain);
					trace_32.setT2qvtrRelation(t2qvtrRelation);
					trace_32.setT2qvtrTypedModel(t2qvtrTypedModel);
					trace_32.setWmapMatchedRule(TmapMatchedRule);
					trace_32.setWmapOclMetamodel(TmapOclMetamodel);
					final /*@Thrown*/ @Nullable Boolean mTmapInPattern_success_t1atlModel_t1atlRule_t2qvtrD_p1 = ValueUtil.TRUE_VALUE;
					raw_when_mapOclMetamodel = mTmapInPattern_success_t1atlModel_t1atlRule_t2qvtrD_p1;
				}
				else {
					raw_when_mapOclMetamodel = ValueUtil.FALSE_VALUE;
				}
				symbol_14 = raw_when_mapOclMetamodel;
			}
			else {
				symbol_14 = ValueUtil.FALSE_VALUE;
			}
			raw_when_mapMatchedRule = symbol_14;
		}
		else {
			raw_when_mapMatchedRule = ValueUtil.FALSE_VALUE;
		}
		trace_32.setSuccess(raw_when_mapMatchedRule);
		if (raw_when_mapMatchedRule) {
			objectManager.assigned(trace_32, trace_ATL2QVTrPackage.Literals.TMAP_IN_PATTERN__SUCCESS, raw_when_mapMatchedRule);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_mapMatchedRule ? "done "  : "fail ") + "MAP_mTmapInPattern_success_t1atlModel_t1atlRule_t2qvtrD_p1");
		}
		return raw_when_mapMatchedRule;
	}

	/**
	 *
	 * map mOclModel_TmapOclModel_IN_p0 in ATL2QVTr {
	 * guard:atl oclModel : OCL::OclModel[1];
	 * append jm_TmapOclModel__IN  : trace_ATL2QVTr::TmapOclModel_IN[1];
	 * new:middle trace : trace_ATL2QVTr::TmapOclModel_IN[1];
	 * set trace.t1oclModel := oclModel;
	 * add jm_TmapOclModel__IN += trace;
	 *
	 */
	protected boolean MAP_mOclModel_TmapOclModel_IN_p0(final @NonNull Connection jm_TmapOclModel__IN, final /*@NonInvalid*/ @NonNull OclModel oclModel)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mOclModel_TmapOclModel_IN_p0" + ", " + jm_TmapOclModel__IN + ", " + oclModel);
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapOclModel_IN trace_81 = trace_ATL2QVTrFactory.eINSTANCE.createTmapOclModel_IN();
		models[2/*middle*/].add(trace_81, false);
		// mapping statements
		trace_81.setT1oclModel(oclModel);
		jm_TmapOclModel__IN.appendElement(trace_81);
		final /*@Thrown*/ @Nullable Boolean mOclModel_TmapOclModel_IN_p0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mOclModel_TmapOclModel_IN_p0 ? "done "  : "fail ") + "MAP_mOclModel_TmapOclModel_IN_p0");
		}
		return mOclModel_TmapOclModel_IN_p0;
	}

	/**
	 *
	 * map mTmapOclModel__IN_t0tmName_t1atlModule_t1oclMetamod_p1 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapOclModel_IN[1];
	 * var oclModel : OCL::OclModel[1] := trace.t1oclModel;
	 * var atlModule : ATL::Module[1] := oclModel.Module;
	 * var oclMetamodel : OCL::OclModel[1] := oclModel.metamodel;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * var when_mapOclMetamodel : trace_ATL2QVTr::TmapOclMetamodel[1] := oclMetamodel.TmapOclMetamodel;
	 * var tmName : String[1] := oclMetamodel.name;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t2qvtrTransformation;
	 * var qvtrTypedModel : qvtbase::TypedModel[1] := when_mapOclMetamodel.t2qvtrTypedModel;
	 * var oclAsSet : Set(Package[0|1]) := this.getPackage(atlModule, tmName)
	 *   .oclAsSet()
	 *   ;
	 * var getPackage1 : Package[?] := this.getPackage(atlModule, tmName);
	 * set trace.t0tmName := tmName;
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
	protected boolean MAP_mTmapOclModel__IN_t0tmName_t1atlModule_t1oclMetamod_p1(final /*@NonInvalid*/ @NonNull TmapOclModel_IN trace_33)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOclModel__IN_t0tmName_t1atlModule_t1oclMetamod_p1" + ", " + trace_33);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclModel t1oclModel = trace_33.getT1oclModel();
		final /*@NonInvalid*/ @NonNull UnboxedCompositionProperty IMPPROPid_inModels = new UnboxedCompositionProperty(PROPid_inModels);
		final /*@NonInvalid*/ @Nullable Module Module = (Module)IMPPROPid_inModels.evaluate(executor, CLSSid_Module, t1oclModel);
		final /*@NonInvalid*/ boolean symbol_0 = Module != null;
		/*@Thrown*/ @Nullable Boolean raw_atlModule;
		if (symbol_0) {
			if (Module == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@NonInvalid*/ @Nullable OclModel metamodel = t1oclModel.getMetamodel();
			final /*@NonInvalid*/ boolean symbol_1 = metamodel != null;
			/*@Thrown*/ @Nullable Boolean raw_oclMetamodel;
			if (symbol_1) {
				if (metamodel == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t1atlModule.get(Module);
				final /*@Thrown*/ boolean symbol_2 = TmapModule != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
				if (symbol_2) {
					if (TmapModule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable TmapOclMetamodel TmapOclMetamodel = OPPOSITE_OF_TmapOclMetamodel_t1oclMetamodel.get(metamodel);
					final /*@Thrown*/ boolean symbol_3 = TmapOclMetamodel != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclMetamodel;
					if (symbol_3) {
						if (TmapOclMetamodel == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull String name_2 = metamodel.getName();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull RelationalTransformation t2qvtrTransformation = TmapModule.getT2qvtrTransformation();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull TypedModel t2qvtrTypedModel = TmapOclMetamodel.getT2qvtrTypedModel();
						final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Package getPackage_0 = ((FUN_getPackage)FTOR_getPackage.getUniqueComputation(this, Module, name_2)).instance;
						final /*@Thrown*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Package, getPackage_0);
						// mapping statements
						trace_33.setT0tmName(name_2);
						final /*@Thrown*/ @NonNull List<Package> ECORE_oclAsSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, oclAsSet);
						t2qvtrTypedModel.getUsedPackage().addAll(ECORE_oclAsSet);
						t2qvtrTypedModel.setTransformation(t2qvtrTransformation);
						trace_33.setT1atlModule(Module);
						trace_33.setT1oclMetamodel(metamodel);
						trace_33.setT2qvtrTransformation(t2qvtrTransformation);
						trace_33.setT2qvtrTypedModel(t2qvtrTypedModel);
						trace_33.setWmapModule(TmapModule);
						trace_33.setWmapOclMetamodel(TmapOclMetamodel);
						final /*@Thrown*/ @Nullable Boolean mTmapOclModel__IN_t0tmName_t1atlModule_t1oclMetamod_p1 = ValueUtil.TRUE_VALUE;
						raw_when_mapOclMetamodel = mTmapOclModel__IN_t0tmName_t1atlModule_t1oclMetamod_p1;
					}
					else {
						raw_when_mapOclMetamodel = ValueUtil.FALSE_VALUE;
					}
					raw_when_mapModule = raw_when_mapOclMetamodel;
				}
				else {
					raw_when_mapModule = ValueUtil.FALSE_VALUE;
				}
				raw_oclMetamodel = raw_when_mapModule;
			}
			else {
				raw_oclMetamodel = ValueUtil.FALSE_VALUE;
			}
			raw_atlModule = raw_oclMetamodel;
		}
		else {
			raw_atlModule = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_atlModule ? "done "  : "fail ") + "MAP_mTmapOclModel__IN_t0tmName_t1atlModule_t1oclMetamod_p1");
		}
		return raw_atlModule;
	}

	/**
	 *
	 * map mOclModel_TmapOclModel_OUT_p0 in ATL2QVTr {
	 * guard:atl oclModel : OCL::OclModel[1];
	 * append jm_TmapOclModel__OUT  : trace_ATL2QVTr::TmapOclModel_OUT[1];
	 * new:middle trace : trace_ATL2QVTr::TmapOclModel_OUT[1];
	 * set trace.t1oclModel := oclModel;
	 * add jm_TmapOclModel__OUT += trace;
	 *
	 */
	protected boolean MAP_mOclModel_TmapOclModel_OUT_p0(final @NonNull Connection jm_TmapOclModel__OUT, final /*@NonInvalid*/ @NonNull OclModel oclModel_0)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mOclModel_TmapOclModel_OUT_p0" + ", " + jm_TmapOclModel__OUT + ", " + oclModel_0);
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapOclModel_OUT trace_81 = trace_ATL2QVTrFactory.eINSTANCE.createTmapOclModel_OUT();
		models[2/*middle*/].add(trace_81, false);
		// mapping statements
		trace_81.setT1oclModel(oclModel_0);
		jm_TmapOclModel__OUT.appendElement(trace_81);
		final /*@Thrown*/ @Nullable Boolean mOclModel_TmapOclModel_OUT_p0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mOclModel_TmapOclModel_OUT_p0 ? "done "  : "fail ") + "MAP_mOclModel_TmapOclModel_OUT_p0");
		}
		return mOclModel_TmapOclModel_OUT_p0;
	}

	/**
	 *
	 * map mTmapOclModel__OUT_t0tmName_t1atlModule_t1oclMetamo_p1 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapOclModel_OUT[1];
	 * var oclModel : OCL::OclModel[1] := trace.t1oclModel;
	 * var atlModule : ATL::Module[1] := oclModel.Module;
	 * var oclMetamodel : OCL::OclModel[1] := oclModel.metamodel;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := atlModule.TmapModule;
	 * var when_mapOclMetamodel : trace_ATL2QVTr::TmapOclMetamodel[1] := oclMetamodel.TmapOclMetamodel;
	 * var tmName : String[1] := oclMetamodel.name;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t2qvtrTransformation;
	 * var qvtrTypedModel : qvtbase::TypedModel[1] := when_mapOclMetamodel.t2qvtrTypedModel;
	 * var oclAsSet : Set(Package[0|1]) := this.getPackage(atlModule, tmName)
	 *   .oclAsSet()
	 *   ;
	 * var getPackage1 : Package[?] := this.getPackage(atlModule, tmName);
	 * set trace.t0tmName := tmName;
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
	protected boolean MAP_mTmapOclModel__OUT_t0tmName_t1atlModule_t1oclMetamo_p1(final /*@NonInvalid*/ @NonNull TmapOclModel_OUT trace_34)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOclModel__OUT_t0tmName_t1atlModule_t1oclMetamo_p1" + ", " + trace_34);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclModel t1oclModel = trace_34.getT1oclModel();
		final /*@NonInvalid*/ @NonNull UnboxedCompositionProperty IMPPROPid_outModels = new UnboxedCompositionProperty(PROPid_outModels);
		final /*@NonInvalid*/ @Nullable Module Module = (Module)IMPPROPid_outModels.evaluate(executor, CLSSid_Module, t1oclModel);
		final /*@NonInvalid*/ boolean symbol_0 = Module != null;
		/*@Thrown*/ @Nullable Boolean raw_atlModule;
		if (symbol_0) {
			if (Module == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@NonInvalid*/ @Nullable OclModel metamodel = t1oclModel.getMetamodel();
			final /*@NonInvalid*/ boolean symbol_1 = metamodel != null;
			/*@Thrown*/ @Nullable Boolean raw_oclMetamodel;
			if (symbol_1) {
				if (metamodel == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@Thrown*/ @Nullable TmapModule TmapModule = OPPOSITE_OF_TmapModule_t1atlModule.get(Module);
				final /*@Thrown*/ boolean symbol_2 = TmapModule != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
				if (symbol_2) {
					if (TmapModule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable TmapOclMetamodel TmapOclMetamodel = OPPOSITE_OF_TmapOclMetamodel_t1oclMetamodel.get(metamodel);
					final /*@Thrown*/ boolean symbol_3 = TmapOclMetamodel != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclMetamodel;
					if (symbol_3) {
						if (TmapOclMetamodel == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull String name_2 = metamodel.getName();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull RelationalTransformation t2qvtrTransformation = TmapModule.getT2qvtrTransformation();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull TypedModel t2qvtrTypedModel = TmapOclMetamodel.getT2qvtrTypedModel();
						final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Package getPackage_0 = ((FUN_getPackage)FTOR_getPackage.getUniqueComputation(this, Module, name_2)).instance;
						final /*@Thrown*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Package, getPackage_0);
						// mapping statements
						trace_34.setT0tmName(name_2);
						final /*@Thrown*/ @NonNull List<Package> ECORE_oclAsSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, oclAsSet);
						t2qvtrTypedModel.getUsedPackage().addAll(ECORE_oclAsSet);
						t2qvtrTypedModel.setTransformation(t2qvtrTransformation);
						trace_34.setT1atlModule(Module);
						trace_34.setT1oclMetamodel(metamodel);
						trace_34.setT2qvtrTransformation(t2qvtrTransformation);
						trace_34.setT2qvtrTypedModel(t2qvtrTypedModel);
						trace_34.setWmapModule(TmapModule);
						trace_34.setWmapOclMetamodel(TmapOclMetamodel);
						final /*@Thrown*/ @Nullable Boolean mTmapOclModel__OUT_t0tmName_t1atlModule_t1oclMetamo_p1 = ValueUtil.TRUE_VALUE;
						raw_when_mapOclMetamodel = mTmapOclModel__OUT_t0tmName_t1atlModule_t1oclMetamo_p1;
					}
					else {
						raw_when_mapOclMetamodel = ValueUtil.FALSE_VALUE;
					}
					raw_when_mapModule = raw_when_mapOclMetamodel;
				}
				else {
					raw_when_mapModule = ValueUtil.FALSE_VALUE;
				}
				raw_oclMetamodel = raw_when_mapModule;
			}
			else {
				raw_oclMetamodel = ValueUtil.FALSE_VALUE;
			}
			raw_atlModule = raw_oclMetamodel;
		}
		else {
			raw_atlModule = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_atlModule ? "done "  : "fail ") + "MAP_mTmapOclModel__OUT_t0tmName_t1atlModule_t1oclMetamo_p1");
		}
		return raw_atlModule;
	}

	/**
	 *
	 * map mOclExpression_TmapOperationCallExp_argument_p0 in ATL2QVTr {
	 * guard:atl atlArgument : OCL::OclExpression[1];
	 * append jm_TmapOperationCallExp__argument  : trace_ATL2QVTr::TmapOperationCallExp_argument[1];
	 * new:middle trace : trace_ATL2QVTr::TmapOperationCallExp_argument[1];
	 * set trace.t1atlArgument := atlArgument;
	 * add jm_TmapOperationCallExp__argument += trace;
	 *
	 */
	protected boolean MAP_mOclExpression_TmapOperationCallExp_argument_p0(final /*@NonInvalid*/ @NonNull OclExpression atlArgument, final @NonNull Connection jm_TmapOperationCallExp__argument)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mOclExpression_TmapOperationCallExp_argument_p0" + ", " + atlArgument + ", " + jm_TmapOperationCallExp__argument);
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapOperationCallExp_argument trace_81 = trace_ATL2QVTrFactory.eINSTANCE.createTmapOperationCallExp_argument();
		models[2/*middle*/].add(trace_81, false);
		// mapping statements
		trace_81.setT1atlArgument(atlArgument);
		jm_TmapOperationCallExp__argument.appendElement(trace_81);
		final /*@Thrown*/ @Nullable Boolean mOclExpression_TmapOperationCallExp_argument_p0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mOclExpression_TmapOperationCallExp_argument_p0 ? "done "  : "fail ") + "MAP_mOclExpression_TmapOperationCallExp_argument_p0");
		}
		return mOclExpression_TmapOperationCallExp_argument_p0;
	}

	/**
	 *
	 * map mOutPattern_TmapOutPattern_p0 in ATL2QVTr {
	 * guard:atl atlPattern : ATL::OutPattern[1];
	 * append jm_TmapOutPattern  : trace_ATL2QVTr::TmapOutPattern[1];
	 * new:middle trace : trace_ATL2QVTr::TmapOutPattern[1];
	 * set trace.t1atlPattern := atlPattern;
	 * add jm_TmapOutPattern += trace;
	 *
	 */
	protected boolean MAP_mOutPattern_TmapOutPattern_p0(final /*@NonInvalid*/ @NonNull OutPattern atlPattern_0, final @NonNull Connection jm_TmapOutPattern)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mOutPattern_TmapOutPattern_p0" + ", " + atlPattern_0 + ", " + jm_TmapOutPattern);
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapOutPattern trace_81 = trace_ATL2QVTrFactory.eINSTANCE.createTmapOutPattern();
		models[2/*middle*/].add(trace_81, false);
		// mapping statements
		OPPOSITE_OF_TmapOutPattern_t1atlPattern.put(atlPattern_0, trace_81);
		trace_81.setT1atlPattern(atlPattern_0);
		jm_TmapOutPattern.appendElement(trace_81);
		final /*@Thrown*/ @Nullable Boolean mOutPattern_TmapOutPattern_p0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mOutPattern_TmapOutPattern_p0 ? "done "  : "fail ") + "MAP_mOutPattern_TmapOutPattern_p0");
		}
		return mOutPattern_TmapOutPattern_p0;
	}

	/**
	 *
	 * map mTmapOutPattern_success_t1atlRule_t2qvtrDomain_t2qv_p1 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapOutPattern[1] success success;
	 * var atlPattern : ATL::OutPattern[1] := trace.t1atlPattern;
	 * check var atlRule : ATL::MatchedRule[1] := atlPattern.rule;
	 * var when_mapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1] := atlRule.TmapMatchedRule;
	 * check when_mapMatchedRule.success;
	 * var elements : OrderedSet(ATL::OutPatternElement[+|1]) := atlPattern.elements;
	 * var qvtrRelation : qvtrelation::Relation[1] := when_mapMatchedRule.t2qvtrRelation;
	 * var selectByKind : Sequence(OCL::OclModelElement) := elements->collect(_'1_' | _'1_'.type)
	 *   ->selectByKind(OCL::OclModelElement)
	 *   ;
	 * var _'\u00ABcollect\u00BB' : Sequence(OCL::OclType[*|?]) := elements->collect(_'1_' | _'1_'.type)
	 *   ;
	 * var _'\u00ABany\u00BB' : OCL::OclModelElement[1] := selectByKind->any(_'1_' | true);
	 * var model : OCL::OclModel[1] := _'\u00ABany\u00BB'.model;
	 * var when_mapOclMetamodel : trace_ATL2QVTr::TmapOclMetamodel[1] := model.TmapOclMetamodel;
	 * var qvtrTypedModel : qvtbase::TypedModel[1] := when_mapOclMetamodel.t2qvtrTypedModel;
	 * new:qvtr qvtrDomain : qvtrelation::RelationDomain[1];
	 * set qvtrDomain.isCheckable := false;
	 * set qvtrDomain.isEnforceable := true;
	 * set qvtrDomain.rule := qvtrRelation;
	 * set qvtrDomain.typedModel := qvtrTypedModel;
	 * set trace.t1atlRule := atlRule;
	 * set trace.t2qvtrDomain := qvtrDomain;
	 * set trace.t2qvtrRelation := qvtrRelation;
	 * set trace.t2qvtrTypedModel := qvtrTypedModel;
	 * set trace.wmapMatchedRule := when_mapMatchedRule;
	 * set trace.wmapOclMetamodel := when_mapOclMetamodel;
	 *
	 */
	protected boolean MAP_mTmapOutPattern_success_t1atlRule_t2qvtrDomain_t2qv_p1(final /*@NonInvalid*/ @NonNull TmapOutPattern trace_35)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOutPattern_success_t1atlRule_t2qvtrDomain_t2qv_p1" + ", " + trace_35);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OutPattern t1atlPattern = trace_35.getT1atlPattern();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Rule temp1_atlRule = t1atlPattern.getRule();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlRule instanceof MatchedRule;
		/*@Thrown*/ @Nullable Boolean symbol_16;
		if (symbol_0) {
			final /*@NonInvalid*/ @NonNull MatchedRule symbol_1 = (MatchedRule)temp1_atlRule;
			final /*@NonInvalid*/ @Nullable TmapMatchedRule TmapMatchedRule = OPPOSITE_OF_TmapMatchedRule_t1matchedRule.get(symbol_1);
			final /*@NonInvalid*/ boolean symbol_2 = TmapMatchedRule != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapMatchedRule;
			if (symbol_2) {
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
					final /*@NonInvalid*/ @NonNull List<OutPatternElement> elements = t1atlPattern.getElements();
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull Relation t2qvtrRelation = TmapMatchedRule.getT2qvtrRelation();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_OclModelElement_0 = idResolver.getClass(CLSSid_OclModelElement, null);
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_elements_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_OutPatternElement, elements);
					/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclType);
					@NonNull Iterator<Object> ITERATOR__1_0 = BOXED_elements_0.iterator();
					/*@Thrown*/ @NonNull SequenceValue collect_0;
					while (true) {
						if (!ITERATOR__1_0.hasNext()) {
							collect_0 = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull OutPatternElement _1_0 = (OutPatternElement)ITERATOR__1_0.next();
						/**
						 * _'1_'.type
						 */
						final /*@NonInvalid*/ @Nullable OclType type_3 = _1_0.getType();
						//
						accumulator.add(type_3);
					}
					final /*@Thrown*/ @NonNull SequenceValue selectByKind = (SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_0, TYP_OCL_c_c_OclModelElement_0);
					@NonNull Iterator<Object> ITERATOR__1_1 = selectByKind.iterator();
					/*@Thrown*/ @NonNull OclModelElement any;
					while (true) {
						if (!ITERATOR__1_1.hasNext()) {
							throw new InvalidValueException("No matching content for 'any'");
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull OclModelElement _1_1 = (OclModelElement)ITERATOR__1_1.next();
						/**
						 * true
						 */
						//
						if (ValueUtil.TRUE_VALUE != ValueUtil.FALSE_VALUE) {			// Carry on till something found
							any = _1_1;
							break;
						}
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OclModel model = any.getModel();
					final /*@Thrown*/ @Nullable TmapOclMetamodel TmapOclMetamodel = OPPOSITE_OF_TmapOclMetamodel_t1oclMetamodel.get(model);
					final /*@Thrown*/ boolean symbol_3 = TmapOclMetamodel != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclMetamodel;
					if (symbol_3) {
						if (TmapOclMetamodel == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull TypedModel t2qvtrTypedModel = TmapOclMetamodel.getT2qvtrTypedModel();
						// creations
						final @NonNull RelationDomain qvtrDomain = QVTrelationFactory.eINSTANCE.createRelationDomain();
						models[1/*qvtr*/].add(qvtrDomain, false);
						// mapping statements
						qvtrDomain.setIsCheckable(ValueUtil.FALSE_VALUE);
						qvtrDomain.setIsEnforceable(ValueUtil.TRUE_VALUE);
						qvtrDomain.setRule(t2qvtrRelation);
						qvtrDomain.setTypedModel(t2qvtrTypedModel);
						trace_35.setT1atlRule(symbol_1);
						trace_35.setT2qvtrDomain(qvtrDomain);
						trace_35.setT2qvtrRelation(t2qvtrRelation);
						trace_35.setT2qvtrTypedModel(t2qvtrTypedModel);
						trace_35.setWmapMatchedRule(TmapMatchedRule);
						trace_35.setWmapOclMetamodel(TmapOclMetamodel);
						final /*@Thrown*/ @Nullable Boolean mTmapOutPattern_success_t1atlRule_t2qvtrDomain_t2qv_p1 = ValueUtil.TRUE_VALUE;
						raw_when_mapOclMetamodel = mTmapOutPattern_success_t1atlRule_t2qvtrDomain_t2qv_p1;
					}
					else {
						raw_when_mapOclMetamodel = ValueUtil.FALSE_VALUE;
					}
					symbol_15 = raw_when_mapOclMetamodel;
				}
				else {
					symbol_15 = ValueUtil.FALSE_VALUE;
				}
				raw_when_mapMatchedRule = symbol_15;
			}
			else {
				raw_when_mapMatchedRule = ValueUtil.FALSE_VALUE;
			}
			symbol_16 = raw_when_mapMatchedRule;
		}
		else {
			symbol_16 = ValueUtil.FALSE_VALUE;
		}
		trace_35.setSuccess(symbol_16);
		if (symbol_16) {
			objectManager.assigned(trace_35, trace_ATL2QVTrPackage.Literals.TMAP_OUT_PATTERN__SUCCESS, symbol_16);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_16 ? "done "  : "fail ") + "MAP_mTmapOutPattern_success_t1atlRule_t2qvtrDomain_t2qv_p1");
		}
		return symbol_16;
	}

	/**
	 *
	 * map mSimpleInPatternElement_TmapSimpleInPatternElement_p0 in ATL2QVTr {
	 * guard:atl atlElement : ATL::SimpleInPatternElement[1];
	 * append jm_TmapSimpleInPatternElement  : trace_ATL2QVTr::TmapSimpleInPatternElement[1];
	 * new:middle trace : trace_ATL2QVTr::TmapSimpleInPatternElement[1];
	 * set trace.t1atlElement := atlElement;
	 * add jm_TmapSimpleInPatternElement += trace;
	 *
	 */
	protected boolean MAP_mSimpleInPatternElement_TmapSimpleInPatternElement_p0(final /*@NonInvalid*/ @NonNull SimpleInPatternElement atlElement, final @NonNull Connection jm_TmapSimpleInPatternElement)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mSimpleInPatternElement_TmapSimpleInPatternElement_p0" + ", " + atlElement + ", " + jm_TmapSimpleInPatternElement);
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapSimpleInPatternElement trace_81 = trace_ATL2QVTrFactory.eINSTANCE.createTmapSimpleInPatternElement();
		models[2/*middle*/].add(trace_81, false);
		// mapping statements
		trace_81.setT1atlElement(atlElement);
		jm_TmapSimpleInPatternElement.appendElement(trace_81);
		final /*@Thrown*/ @Nullable Boolean mSimpleInPatternElement_TmapSimpleInPatternElement_p0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mSimpleInPatternElement_TmapSimpleInPatternElement_p0 ? "done "  : "fail ") + "MAP_mSimpleInPatternElement_TmapSimpleInPatternElement_p0");
		}
		return mSimpleInPatternElement_TmapSimpleInPatternElement_p0;
	}

	/**
	 *
	 * map mSimpleOutPatternElement_TmapSimpleOutPatternElemen_p0 in ATL2QVTr {
	 * guard:atl atlElement : ATL::SimpleOutPatternElement[1];
	 * append jm_TmapSimpleOutPatternElement  : trace_ATL2QVTr::TmapSimpleOutPatternElement[1];
	 * new:middle trace : trace_ATL2QVTr::TmapSimpleOutPatternElement[1];
	 * set trace.t1atlElement := atlElement;
	 * add jm_TmapSimpleOutPatternElement += trace;
	 *
	 */
	protected boolean MAP_mSimpleOutPatternElement_TmapSimpleOutPatternElemen_p0(final /*@NonInvalid*/ @NonNull SimpleOutPatternElement atlElement_0, final @NonNull Connection jm_TmapSimpleOutPatternElement)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mSimpleOutPatternElement_TmapSimpleOutPatternElemen_p0" + ", " + atlElement_0 + ", " + jm_TmapSimpleOutPatternElement);
		}
		// creations
		final @SuppressWarnings("null")@NonNull TmapSimpleOutPatternElement trace_81 = trace_ATL2QVTrFactory.eINSTANCE.createTmapSimpleOutPatternElement();
		models[2/*middle*/].add(trace_81, false);
		// mapping statements
		OPPOSITE_OF_TmapSimpleOutPatternElement_t1atlElement.put(atlElement_0, trace_81);
		trace_81.setT1atlElement(atlElement_0);
		jm_TmapSimpleOutPatternElement.appendElement(trace_81);
		final /*@Thrown*/ @Nullable Boolean mSimpleOutPatternElement_TmapSimpleOutPatternElemen_p0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mSimpleOutPatternElement_TmapSimpleOutPatternElemen_p0 ? "done "  : "fail ") + "MAP_mSimpleOutPatternElement_TmapSimpleOutPatternElemen_p0");
		}
		return mSimpleOutPatternElement_TmapSimpleOutPatternElemen_p0;
	}

	/**
	 *
	 * map mTmapSimpleInPatternElement_t0elementName_t1atlPatt_p1 in ATL2QVTr {
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
	 * var getType1 : Class[1] := this.getType(type);
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
	 * notify set qvtrTemplate.type := getType1;
	 * set qvtrRelation.variable := qvtrVariable;
	 * set qvtrDomain.rootVariable := qvtrVariable;
	 * notify set qvtrVariable.type := getType1;
	 * set where_mapVariable.t1atlVariable := atlElement;
	 * set where_mapVariable.t2qvtrVariable := qvtrVariable;
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
	 * add jm_TmapVariable += where_mapVariable;
	 *
	 */
	protected boolean MAP_mTmapSimpleInPatternElement_t0elementName_t1atlPatt_p1(final @NonNull Connection jm_TmapVariable, final /*@NonInvalid*/ @NonNull TmapSimpleInPatternElement trace_36)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapSimpleInPatternElement_t0elementName_t1atlPatt_p1" + ", " + jm_TmapVariable + ", " + trace_36);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull SimpleInPatternElement t1atlElement = trace_36.getT1atlElement();
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
						final @NonNull ObjectTemplateExp qvtrTemplate = QVTtemplateFactory.eINSTANCE.createObjectTemplateExp();
						models[1/*qvtr*/].add(qvtrTemplate, false);
						final @NonNull TemplateVariable qvtrVariable = QVTrelationFactory.eINSTANCE.createTemplateVariable();
						models[1/*qvtr*/].add(qvtrVariable, false);
						final @SuppressWarnings("null")@NonNull TmapVariable where_mapVariable = trace_ATL2QVTrFactory.eINSTANCE.createTmapVariable();
						models[2/*middle*/].add(where_mapVariable, false);
						// mapping statements
						qvtrVariable.setName(varName);
						trace_36.setT0elementName(varName);
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
						OPPOSITE_OF_TmapVariable_t1atlVariable.put(t1atlElement, where_mapVariable);
						where_mapVariable.setT1atlVariable(t1atlElement);
						where_mapVariable.setT2qvtrVariable(qvtrVariable);
						trace_36.setT1atlPattern(inPattern);
						trace_36.setT1atlRule(rule);
						trace_36.setT2qvtrDomain(t2qvtrDomain);
						trace_36.setT2qvtrPattern(qvtrPattern);
						trace_36.setT2qvtrRelation(t2qvtrRelation);
						trace_36.setT2qvtrTemplate(qvtrTemplate);
						trace_36.setT2qvtrVariable(qvtrVariable);
						trace_36.setWmapInPattern(TmapInPattern);
						trace_36.setWmapMatchedRule(TmapMatchedRule);
						trace_36.setWmapVariable(where_mapVariable);
						jm_TmapVariable.appendElement(where_mapVariable);
						final /*@Thrown*/ @Nullable Boolean mTmapSimpleInPatternElement_t0elementName_t1atlPatt_p1 = ValueUtil.TRUE_VALUE;
						symbol_26 = mTmapSimpleInPatternElement_t0elementName_t1atlPatt_p1;
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
			AbstractTransformer.INVOCATIONS.println((raw_when_mapInPattern ? "done "  : "fail ") + "MAP_mTmapSimpleInPatternElement_t0elementName_t1atlPatt_p1");
		}
		return raw_when_mapInPattern;
	}

	/**
	 *
	 * map mTmapSimpleOutPatternElement_success_t0elementName__p1 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapSimpleOutPatternElement[1] success success;
	 * append jm_TmapVariable  : trace_ATL2QVTr::TmapVariable[1];
	 * var atlElement : ATL::SimpleOutPatternElement[1] := trace.t1atlElement;
	 * var atlPattern : ATL::OutPattern[1] := atlElement.outPattern;
	 * check var atlRule : ATL::MatchedRule[1] := atlPattern.rule;
	 * var when_mapOutPattern : trace_ATL2QVTr::TmapOutPattern[1] := atlPattern.TmapOutPattern;
	 * check when_mapOutPattern.success;
	 * var when_mapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1] := atlRule.TmapMatchedRule;
	 * check when_mapMatchedRule.success;
	 * var type : OCL::OclType[?] := atlElement.type;
	 * var elementName : String[1] := atlElement.varName;
	 * var qvtrDomain : qvtrelation::RelationDomain[1] := when_mapOutPattern.t2qvtrDomain;
	 * var qvtrRelation : qvtrelation::Relation[1] := when_mapMatchedRule.t2qvtrRelation;
	 * var getType1 : Class[1] := this.getType(type);
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
	 * notify set qvtrTemplate.type := getType1;
	 * set qvtrRelation.variable := qvtrVariable;
	 * set qvtrDomain.rootVariable := qvtrVariable;
	 * notify set qvtrVariable.type := getType1;
	 * set where_mapVariable.t1atlVariable := atlElement;
	 * set where_mapVariable.t2qvtrVariable := qvtrVariable;
	 * set trace.t1atlPattern := atlPattern;
	 * set trace.t1atlRule := atlRule;
	 * set trace.t2qvtrDomain := qvtrDomain;
	 * set trace.t2qvtrPattern := qvtrPattern;
	 * set trace.t2qvtrRelation := qvtrRelation;
	 * set trace.t2qvtrTemplate := qvtrTemplate;
	 * set trace.t2qvtrVariable := qvtrVariable;
	 * set trace.wmapMatchedRule := when_mapMatchedRule;
	 * set trace.wmapOutPattern := when_mapOutPattern;
	 * set trace.wmapVariable := where_mapVariable;
	 * add jm_TmapVariable += where_mapVariable;
	 *
	 */
	protected boolean MAP_mTmapSimpleOutPatternElement_success_t0elementName__p1(final @NonNull Connection jm_TmapVariable_0, final /*@NonInvalid*/ @NonNull TmapSimpleOutPatternElement trace_37)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapSimpleOutPatternElement_success_t0elementName__p1" + ", " + jm_TmapVariable_0 + ", " + trace_37);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull SimpleOutPatternElement t1atlElement = trace_37.getT1atlElement();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OutPattern outPattern = t1atlElement.getOutPattern();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Rule temp1_atlRule = outPattern.getRule();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlRule instanceof MatchedRule;
		/*@Thrown*/ @Nullable Boolean symbol_30;
		if (symbol_0) {
			final /*@NonInvalid*/ @NonNull MatchedRule symbol_1 = (MatchedRule)temp1_atlRule;
			final /*@NonInvalid*/ @Nullable TmapOutPattern TmapOutPattern = OPPOSITE_OF_TmapOutPattern_t1atlPattern.get(outPattern);
			final /*@NonInvalid*/ boolean symbol_2 = TmapOutPattern != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapOutPattern;
			if (symbol_2) {
				if (TmapOutPattern == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@Thrown*/ @Nullable Boolean success = TmapOutPattern.getSuccess();
				if (success == null) {
					throw new InvalidEvaluationException("Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_29;
				if (success) {
					final /*@NonInvalid*/ @Nullable TmapMatchedRule TmapMatchedRule = OPPOSITE_OF_TmapMatchedRule_t1matchedRule.get(symbol_1);
					final /*@NonInvalid*/ boolean symbol_3 = TmapMatchedRule != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapMatchedRule;
					if (symbol_3) {
						if (TmapMatchedRule == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean success_0 = TmapMatchedRule.getSuccess();
						if (success_0 == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_28;
						if (success_0) {
							final /*@NonInvalid*/ @Nullable OclType type_2 = t1atlElement.getType();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull String varName = t1atlElement.getVarName();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull RelationDomain t2qvtrDomain = TmapOutPattern.getT2qvtrDomain();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull Relation t2qvtrRelation = TmapMatchedRule.getT2qvtrRelation();
							final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(this, type_2)).instance;
							// creations
							final @NonNull DomainPattern qvtrPattern = QVTrelationFactory.eINSTANCE.createDomainPattern();
							models[1/*qvtr*/].add(qvtrPattern, false);
							final @NonNull ObjectTemplateExp qvtrTemplate = QVTtemplateFactory.eINSTANCE.createObjectTemplateExp();
							models[1/*qvtr*/].add(qvtrTemplate, false);
							final @NonNull TemplateVariable qvtrVariable = QVTrelationFactory.eINSTANCE.createTemplateVariable();
							models[1/*qvtr*/].add(qvtrVariable, false);
							final @SuppressWarnings("null")@NonNull TmapVariable where_mapVariable = trace_ATL2QVTrFactory.eINSTANCE.createTmapVariable();
							models[2/*middle*/].add(where_mapVariable, false);
							// mapping statements
							qvtrVariable.setName(varName);
							trace_37.setT0elementName(varName);
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
							OPPOSITE_OF_TmapVariable_t1atlVariable.put(t1atlElement, where_mapVariable);
							where_mapVariable.setT1atlVariable(t1atlElement);
							where_mapVariable.setT2qvtrVariable(qvtrVariable);
							trace_37.setT1atlPattern(outPattern);
							trace_37.setT1atlRule(symbol_1);
							trace_37.setT2qvtrDomain(t2qvtrDomain);
							trace_37.setT2qvtrPattern(qvtrPattern);
							trace_37.setT2qvtrRelation(t2qvtrRelation);
							trace_37.setT2qvtrTemplate(qvtrTemplate);
							trace_37.setT2qvtrVariable(qvtrVariable);
							trace_37.setWmapMatchedRule(TmapMatchedRule);
							trace_37.setWmapOutPattern(TmapOutPattern);
							trace_37.setWmapVariable(where_mapVariable);
							jm_TmapVariable_0.appendElement(where_mapVariable);
							final /*@Thrown*/ @Nullable Boolean mTmapSimpleOutPatternElement_success_t0elementName__p1 = ValueUtil.TRUE_VALUE;
							symbol_28 = mTmapSimpleOutPatternElement_success_t0elementName__p1;
						}
						else {
							symbol_28 = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapMatchedRule = symbol_28;
					}
					else {
						raw_when_mapMatchedRule = ValueUtil.FALSE_VALUE;
					}
					symbol_29 = raw_when_mapMatchedRule;
				}
				else {
					symbol_29 = ValueUtil.FALSE_VALUE;
				}
				raw_when_mapOutPattern = symbol_29;
			}
			else {
				raw_when_mapOutPattern = ValueUtil.FALSE_VALUE;
			}
			symbol_30 = raw_when_mapOutPattern;
		}
		else {
			symbol_30 = ValueUtil.FALSE_VALUE;
		}
		trace_37.setSuccess(symbol_30);
		if (symbol_30) {
			objectManager.assigned(trace_37, trace_ATL2QVTrPackage.Literals.TMAP_SIMPLE_OUT_PATTERN_ELEMENT__SUCCESS, symbol_30);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_30 ? "done "  : "fail ") + "MAP_mTmapSimpleOutPatternElement_success_t0elementName__p1");
		}
		return symbol_30;
	}

	/**
	 *
	 * map mTmapIfExp_t2qvtrCondition_p3 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapIfExp[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var qvtrExpression : IfExp[1] := dispatcher.d2qvtrExpression;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrCondition : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * set qvtrExpression.ownedCondition := qvtrCondition;
	 * set trace.t2qvtrCondition := qvtrCondition;
	 *
	 */
	protected boolean MAP_mTmapIfExp_t2qvtrCondition_p3(final /*@NonInvalid*/ @NonNull TmapIfExp trace_38)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapIfExp_t2qvtrCondition_p3" + ", " + trace_38);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_38.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_38.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.IfExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull IfExp symbol_1 = (org.eclipse.ocl.pivot.IfExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_38.getWmapOclExpression();
				final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
				if (symbol_2) {
					if (wmapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
					// mapping statements
					symbol_1.setOwnedCondition(d2qvtrExpression);
					trace_38.setT2qvtrCondition(d2qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean mTmapIfExp_t2qvtrCondition_p3 = ValueUtil.TRUE_VALUE;
					raw_when_mapOclExpression = mTmapIfExp_t2qvtrCondition_p3;
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
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_mTmapIfExp_t2qvtrCondition_p3");
		}
		return symbol_7;
	}

	/**
	 *
	 * map mTmapNavigationOrAttributeCallExp__Helper_t2qvtrSou_p3 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrSourceArgument : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * set qvtrExpression.ownedArguments := qvtrSourceArgument;
	 * set trace.t2qvtrSourceArgument := qvtrSourceArgument;
	 *
	 */
	protected boolean MAP_mTmapNavigationOrAttributeCallExp__Helper_t2qvtrSou_p3(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_39)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapNavigationOrAttributeCallExp__Helper_t2qvtrSou_p3" + ", " + trace_39);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_39.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_39.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_39.getWmapOclExpression();
				final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
				if (symbol_2) {
					if (wmapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
					// mapping statements
					symbol_1.getOwnedArguments().add(d2qvtrExpression);
					trace_39.setT2qvtrSourceArgument(d2qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean mTmapNavigationOrAttributeCallExp__Helper_t2qvtrSou_p3 = ValueUtil.TRUE_VALUE;
					raw_when_mapOclExpression = mTmapNavigationOrAttributeCallExp__Helper_t2qvtrSou_p3;
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
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_mTmapNavigationOrAttributeCallExp__Helper_t2qvtrSou_p3");
		}
		return symbol_7;
	}

	/**
	 *
	 * map mTmapNavigationOrAttributeCallExp__Property_t2qvtrS_p3 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var qvtrExpression : PropertyCallExp[1] := dispatcher.d2qvtrExpression;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrSource : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 * set trace.t2qvtrSource := qvtrSource;
	 *
	 */
	protected boolean MAP_mTmapNavigationOrAttributeCallExp__Property_t2qvtrS_p3(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace_40)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapNavigationOrAttributeCallExp__Property_t2qvtrS_p3" + ", " + trace_40);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_40.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_40.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof PropertyCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull PropertyCallExp symbol_1 = (PropertyCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_40.getWmapOclExpression();
				final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
				if (symbol_2) {
					if (wmapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
					// mapping statements
					symbol_1.setOwnedSource(d2qvtrExpression);
					trace_40.setT2qvtrSource(d2qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean mTmapNavigationOrAttributeCallExp__Property_t2qvtrS_p3 = ValueUtil.TRUE_VALUE;
					raw_when_mapOclExpression = mTmapNavigationOrAttributeCallExp__Property_t2qvtrS_p3;
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
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_mTmapNavigationOrAttributeCallExp__Property_t2qvtrS_p3");
		}
		return symbol_7;
	}

	/**
	 *
	 * map mTmapOperationCallExp__Helper_t2qvtrSourceArgument_p3 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrSourceArgument : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * set qvtrExpression.ownedArguments := qvtrSourceArgument;
	 * set trace.t2qvtrSourceArgument := qvtrSourceArgument;
	 *
	 */
	protected boolean MAP_mTmapOperationCallExp__Helper_t2qvtrSourceArgument_p3(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_41)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperationCallExp__Helper_t2qvtrSourceArgument_p3" + ", " + trace_41);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_41.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_41.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_41.getWmapOclExpression();
				final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
				if (symbol_2) {
					if (wmapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
					// mapping statements
					symbol_1.getOwnedArguments().add(d2qvtrExpression);
					trace_41.setT2qvtrSourceArgument(d2qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean mTmapOperationCallExp__Helper_t2qvtrSourceArgument_p3 = ValueUtil.TRUE_VALUE;
					raw_when_mapOclExpression = mTmapOperationCallExp__Helper_t2qvtrSourceArgument_p3;
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
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_mTmapOperationCallExp__Helper_t2qvtrSourceArgument_p3");
		}
		return symbol_7;
	}

	/**
	 *
	 * map mTmapOperationCallExp__Operation_t2qvtrSource_p3 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrSource : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 * set trace.t2qvtrSource := qvtrSource;
	 *
	 */
	protected boolean MAP_mTmapOperationCallExp__Operation_t2qvtrSource_p3(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace_42)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperationCallExp__Operation_t2qvtrSource_p3" + ", " + trace_42);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_42.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_42.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_42.getWmapOclExpression();
				final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
				if (symbol_2) {
					if (wmapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
					// mapping statements
					symbol_1.setOwnedSource(d2qvtrExpression);
					trace_42.setT2qvtrSource(d2qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean mTmapOperationCallExp__Operation_t2qvtrSource_p3 = ValueUtil.TRUE_VALUE;
					raw_when_mapOclExpression = mTmapOperationCallExp__Operation_t2qvtrSource_p3;
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
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_mTmapOperationCallExp__Operation_t2qvtrSource_p3");
		}
		return symbol_7;
	}

	/**
	 *
	 * map mTmapOperatorCallExp_t2qvtrSource_p3 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrSource : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 * set trace.t2qvtrSource := qvtrSource;
	 *
	 */
	protected boolean MAP_mTmapOperatorCallExp_t2qvtrSource_p3(final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace_43)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperatorCallExp_t2qvtrSource_p3" + ", " + trace_43);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_43.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_43.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_43.getWmapOclExpression();
				final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
				if (symbol_2) {
					if (wmapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
					// mapping statements
					symbol_1.setOwnedSource(d2qvtrExpression);
					trace_43.setT2qvtrSource(d2qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean mTmapOperatorCallExp_t2qvtrSource_p3 = ValueUtil.TRUE_VALUE;
					raw_when_mapOclExpression = mTmapOperatorCallExp_t2qvtrSource_p3;
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
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_mTmapOperatorCallExp_t2qvtrSource_p3");
		}
		return symbol_7;
	}

	/**
	 *
	 * map mTmapIfExp_t2qvtrElse_p4 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapIfExp[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var qvtrExpression : IfExp[1] := dispatcher.d2qvtrExpression;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression1;
	 * var qvtrElse : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * set qvtrExpression.ownedElse := qvtrElse;
	 * set trace.t2qvtrElse := qvtrElse;
	 *
	 */
	protected boolean MAP_mTmapIfExp_t2qvtrElse_p4(final /*@NonInvalid*/ @NonNull TmapIfExp trace_44)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapIfExp_t2qvtrElse_p4" + ", " + trace_44);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_44.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_44.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.IfExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull IfExp symbol_1 = (org.eclipse.ocl.pivot.IfExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression1 = trace_44.getWmapOclExpression1();
				final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression1 != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
				if (symbol_2) {
					if (wmapOclExpression1 == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression1.getD2qvtrExpression();
					// mapping statements
					symbol_1.setOwnedElse(d2qvtrExpression);
					trace_44.setT2qvtrElse(d2qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean mTmapIfExp_t2qvtrElse_p4 = ValueUtil.TRUE_VALUE;
					raw_when_mapOclExpression = mTmapIfExp_t2qvtrElse_p4;
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
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_mTmapIfExp_t2qvtrElse_p4");
		}
		return symbol_7;
	}

	/**
	 *
	 * map mTmapNavigationOrAttributeCallExp__Helper_t2qvtrTra_p4 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * var qvtrSource : VariableExp[1] := trace.t2qvtrSource;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := trace.wmapModule;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t2qvtrTransformation;
	 * var qvtrThisVariable : Variable[?] := qvtrTransformation.ownedContext;
	 * var name : String[?] := qvtrThisVariable?.name;
	 * set qvtrSource.name := name;
	 * set qvtrSource.referredVariable := qvtrThisVariable;
	 * set trace.t2qvtrTransformation := qvtrTransformation;
	 *
	 */
	protected boolean MAP_mTmapNavigationOrAttributeCallExp__Helper_t2qvtrTra_p4(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_45)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapNavigationOrAttributeCallExp__Helper_t2qvtrTra_p4" + ", " + trace_45);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_45.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_5;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_45.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp t2qvtrSource = trace_45.getT2qvtrSource();
			final /*@NonInvalid*/ @Nullable TmapModule wmapModule = trace_45.getWmapModule();
			final /*@NonInvalid*/ boolean symbol_0 = wmapModule != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
			if (symbol_0) {
				if (wmapModule == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull RelationalTransformation t2qvtrTransformation = wmapModule.getT2qvtrTransformation();
				final /*@Thrown*/ @Nullable Variable ownedContext = t2qvtrTransformation.getOwnedContext();
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
					final /*@Thrown*/ @Nullable String name_3 = ownedContext.getName();
					safe_name_source = name_3;
				}
				// mapping statements
				t2qvtrSource.setName(safe_name_source);
				t2qvtrSource.setReferredVariable(ownedContext);
				trace_45.setT2qvtrTransformation(t2qvtrTransformation);
				final /*@Thrown*/ @Nullable Boolean mTmapNavigationOrAttributeCallExp__Helper_t2qvtrTra_p4 = ValueUtil.TRUE_VALUE;
				raw_when_mapModule = mTmapNavigationOrAttributeCallExp__Helper_t2qvtrTra_p4;
			}
			else {
				raw_when_mapModule = ValueUtil.FALSE_VALUE;
			}
			symbol_5 = raw_when_mapModule;
		}
		else {
			symbol_5 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_5 ? "done "  : "fail ") + "MAP_mTmapNavigationOrAttributeCallExp__Helper_t2qvtrTra_p4");
		}
		return symbol_5;
	}

	/**
	 *
	 * map mTmapOperationCallExp__Helper_t2qvtrTransformation_p4 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * var qvtrSource : VariableExp[1] := trace.t2qvtrSource;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := trace.wmapModule;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t2qvtrTransformation;
	 * var qvtrThisVariable : Variable[?] := qvtrTransformation.ownedContext;
	 * var name : String[?] := qvtrThisVariable?.name;
	 * set qvtrSource.name := name;
	 * set qvtrSource.referredVariable := qvtrThisVariable;
	 * set trace.t2qvtrTransformation := qvtrTransformation;
	 *
	 */
	protected boolean MAP_mTmapOperationCallExp__Helper_t2qvtrTransformation_p4(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_46)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperationCallExp__Helper_t2qvtrTransformation_p4" + ", " + trace_46);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_46.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_5;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_46.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp t2qvtrSource = trace_46.getT2qvtrSource();
			final /*@NonInvalid*/ @Nullable TmapModule wmapModule = trace_46.getWmapModule();
			final /*@NonInvalid*/ boolean symbol_0 = wmapModule != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
			if (symbol_0) {
				if (wmapModule == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull RelationalTransformation t2qvtrTransformation = wmapModule.getT2qvtrTransformation();
				final /*@Thrown*/ @Nullable Variable ownedContext = t2qvtrTransformation.getOwnedContext();
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
					final /*@Thrown*/ @Nullable String name_3 = ownedContext.getName();
					safe_name_source = name_3;
				}
				// mapping statements
				t2qvtrSource.setName(safe_name_source);
				t2qvtrSource.setReferredVariable(ownedContext);
				trace_46.setT2qvtrTransformation(t2qvtrTransformation);
				final /*@Thrown*/ @Nullable Boolean mTmapOperationCallExp__Helper_t2qvtrTransformation_p4 = ValueUtil.TRUE_VALUE;
				raw_when_mapModule = mTmapOperationCallExp__Helper_t2qvtrTransformation_p4;
			}
			else {
				raw_when_mapModule = ValueUtil.FALSE_VALUE;
			}
			symbol_5 = raw_when_mapModule;
		}
		else {
			symbol_5 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_5 ? "done "  : "fail ") + "MAP_mTmapOperationCallExp__Helper_t2qvtrTransformation_p4");
		}
		return symbol_5;
	}

	/**
	 *
	 * map mTmapIfExp_t2qvtrThen_p5 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapIfExp[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var qvtrExpression : IfExp[1] := dispatcher.d2qvtrExpression;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression2;
	 * var qvtrThen : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * set qvtrExpression.ownedThen := qvtrThen;
	 * set trace.t2qvtrThen := qvtrThen;
	 *
	 */
	protected boolean MAP_mTmapIfExp_t2qvtrThen_p5(final /*@NonInvalid*/ @NonNull TmapIfExp trace_47)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapIfExp_t2qvtrThen_p5" + ", " + trace_47);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_47.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_47.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.IfExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull IfExp symbol_1 = (org.eclipse.ocl.pivot.IfExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression2 = trace_47.getWmapOclExpression2();
				final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression2 != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
				if (symbol_2) {
					if (wmapOclExpression2 == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression2.getD2qvtrExpression();
					// mapping statements
					symbol_1.setOwnedThen(d2qvtrExpression);
					trace_47.setT2qvtrThen(d2qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean mTmapIfExp_t2qvtrThen_p5 = ValueUtil.TRUE_VALUE;
					raw_when_mapOclExpression = mTmapIfExp_t2qvtrThen_p5;
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
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_mTmapIfExp_t2qvtrThen_p5");
		}
		return symbol_7;
	}

	/**
	 *
	 * map mTmapNavigationOrAttributeCallExp__Helper__type_p5 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * var qvtrSource : VariableExp[1] := trace.t2qvtrSource;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := trace.wmapModule;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t2qvtrTransformation;
	 * var qvtrThisVariable : Variable[?] := qvtrTransformation.ownedContext;
	 * var type : Type[?] := qvtrThisVariable?.type;
	 * notify set qvtrSource.type := type;
	 *
	 */
	protected boolean MAP_mTmapNavigationOrAttributeCallExp__Helper__type_p5(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_48)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapNavigationOrAttributeCallExp__Helper__type_p5" + ", " + trace_48);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_48.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_3;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_48.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp t2qvtrSource = trace_48.getT2qvtrSource();
			final /*@NonInvalid*/ @Nullable TmapModule wmapModule = trace_48.getWmapModule();
			final /*@NonInvalid*/ boolean symbol_0 = wmapModule != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
			if (symbol_0) {
				if (wmapModule == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull RelationalTransformation t2qvtrTransformation = wmapModule.getT2qvtrTransformation();
				final /*@Thrown*/ @Nullable Variable ownedContext = t2qvtrTransformation.getOwnedContext();
				/*@Caught*/ @Nullable Object CAUGHT_ownedContext;
				try {
					CAUGHT_ownedContext = ownedContext;
				}
				catch (Exception e) {
					CAUGHT_ownedContext = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ @NonNull Object type_2 = CAUGHT_ownedContext == null;
				/*@Thrown*/ @Nullable Type safe_type_source;
				if (type_2 == Boolean.TRUE) {
					safe_type_source = null;
				}
				else {
					assert ownedContext != null;
					final /*@Thrown*/ @Nullable Type type_3 = ownedContext.getType();
					safe_type_source = type_3;
				}
				// mapping statements
				t2qvtrSource.setType(safe_type_source);
				objectManager.assigned(t2qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, safe_type_source);
				final /*@Thrown*/ @Nullable Boolean mTmapNavigationOrAttributeCallExp__Helper__type_p5 = ValueUtil.TRUE_VALUE;
				raw_when_mapModule = mTmapNavigationOrAttributeCallExp__Helper__type_p5;
			}
			else {
				raw_when_mapModule = ValueUtil.FALSE_VALUE;
			}
			symbol_3 = raw_when_mapModule;
		}
		else {
			symbol_3 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_3 ? "done "  : "fail ") + "MAP_mTmapNavigationOrAttributeCallExp__Helper__type_p5");
		}
		return symbol_3;
	}

	/**
	 *
	 * map mTmapOperationCallExp__Helper__type_p5 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * var qvtrSource : VariableExp[1] := trace.t2qvtrSource;
	 * var when_mapModule : trace_ATL2QVTr::TmapModule[1] := trace.wmapModule;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_mapModule.t2qvtrTransformation;
	 * var qvtrThisVariable : Variable[?] := qvtrTransformation.ownedContext;
	 * var type : Type[?] := qvtrThisVariable?.type;
	 * notify set qvtrSource.type := type;
	 *
	 */
	protected boolean MAP_mTmapOperationCallExp__Helper__type_p5(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_49)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperationCallExp__Helper__type_p5" + ", " + trace_49);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_49.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_3;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_49.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp t2qvtrSource = trace_49.getT2qvtrSource();
			final /*@NonInvalid*/ @Nullable TmapModule wmapModule = trace_49.getWmapModule();
			final /*@NonInvalid*/ boolean symbol_0 = wmapModule != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapModule;
			if (symbol_0) {
				if (wmapModule == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull RelationalTransformation t2qvtrTransformation = wmapModule.getT2qvtrTransformation();
				final /*@Thrown*/ @Nullable Variable ownedContext = t2qvtrTransformation.getOwnedContext();
				/*@Caught*/ @Nullable Object CAUGHT_ownedContext;
				try {
					CAUGHT_ownedContext = ownedContext;
				}
				catch (Exception e) {
					CAUGHT_ownedContext = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ @NonNull Object type_2 = CAUGHT_ownedContext == null;
				/*@Thrown*/ @Nullable Type safe_type_source;
				if (type_2 == Boolean.TRUE) {
					safe_type_source = null;
				}
				else {
					assert ownedContext != null;
					final /*@Thrown*/ @Nullable Type type_3 = ownedContext.getType();
					safe_type_source = type_3;
				}
				// mapping statements
				t2qvtrSource.setType(safe_type_source);
				objectManager.assigned(t2qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, safe_type_source);
				final /*@Thrown*/ @Nullable Boolean mTmapOperationCallExp__Helper__type_p5 = ValueUtil.TRUE_VALUE;
				raw_when_mapModule = mTmapOperationCallExp__Helper__type_p5;
			}
			else {
				raw_when_mapModule = ValueUtil.FALSE_VALUE;
			}
			symbol_3 = raw_when_mapModule;
		}
		else {
			symbol_3 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_3 ? "done "  : "fail ") + "MAP_mTmapOperationCallExp__Helper__type_p5");
		}
		return symbol_3;
	}

	/**
	 *
	 * map mTmapBinding_t0propertyName_t1atlExpression_t1atlOu_p1 in ATL2QVTr {
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
	protected boolean MAP_mTmapBinding_t0propertyName_t1atlExpression_t1atlOu_p1(final /*@NonInvalid*/ @NonNull TmapBinding trace_50)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapBinding_t0propertyName_t1atlExpression_t1atlOu_p1" + ", " + trace_50);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Binding t1atlBinding = trace_50.getT1atlBinding();
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
							// mapping statements
							trace_50.setT0propertyName(propertyName);
							qvtrPart.setObjContainer(t2qvtrTemplate);
							qvtrPart.setReferredProperty(getProperty);
							qvtrPart.setValue(d2qvtrExpression);
							trace_50.setT1atlExpression(value);
							trace_50.setT1atlOutPatternElement(symbol_1);
							trace_50.setT2qvtrExpression(d2qvtrExpression);
							trace_50.setT2qvtrPart(qvtrPart);
							trace_50.setT2qvtrTemplate(t2qvtrTemplate);
							trace_50.setWmapOclExpression(DmapOclExpression);
							trace_50.setWmapSimpleOutPatternElement(TmapSimpleOutPatternElement);
							final /*@Thrown*/ @Nullable Boolean mTmapBinding_t0propertyName_t1atlExpression_t1atlOu_p1 = ValueUtil.TRUE_VALUE;
							symbol_16 = mTmapBinding_t0propertyName_t1atlExpression_t1atlOu_p1;
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
			AbstractTransformer.INVOCATIONS.println((symbol_18 ? "done "  : "fail ") + "MAP_mTmapBinding_t0propertyName_t1atlExpression_t1atlOu_p1");
		}
		return symbol_18;
	}

	/**
	 *
	 * map mTmapInPattern__filter_t1atlExpression_t1atlPattern_p1 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapInPattern_filter[1];
	 * var atlRule : ATL::MatchedRule[1] := trace.t1atlRule;
	 * var when_mapMatchedRule : trace_ATL2QVTr::TmapMatchedRule[1] := atlRule.TmapMatchedRule;
	 * check when_mapMatchedRule.success;
	 * var atlPattern : ATL::InPattern[1] := atlRule.inPattern;
	 * var when_mapInPattern : trace_ATL2QVTr::TmapInPattern[1] := atlPattern.TmapInPattern;
	 * check when_mapInPattern.success;
	 * var atlExpression : OCL::OclExpression[1] := atlPattern.filter;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := atlExpression.DmapOclExpression;
	 * check when_mapOclExpression.success;
	 * var qvtrRelation : qvtrelation::Relation[1] := when_mapMatchedRule.t2qvtrRelation;
	 * var qvtrDomain : qvtrelation::RelationDomain[1] := when_mapInPattern.t2qvtrDomain;
	 * var qvtrExpression : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * new:qvtr p : qvtbase::Predicate[1];
	 * new:qvtr w : qvtbase::Pattern[1];
	 * set qvtrDomain.rule := qvtrRelation;
	 * set qvtrRelation.when := w;
	 * set p.conditionExpression := qvtrExpression;
	 * set w.predicate := p;
	 * set trace.t1atlExpression := atlExpression;
	 * set trace.t1atlPattern := atlPattern;
	 * set trace.t2p := p;
	 * set trace.t2qvtrDomain := qvtrDomain;
	 * set trace.t2qvtrExpression := qvtrExpression;
	 * set trace.t2qvtrRelation := qvtrRelation;
	 * set trace.t2w := w;
	 * set trace.wmapInPattern := when_mapInPattern;
	 * set trace.wmapMatchedRule := when_mapMatchedRule;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected boolean MAP_mTmapInPattern__filter_t1atlExpression_t1atlPattern_p1(final /*@NonInvalid*/ @NonNull TmapInPattern_filter trace_51)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapInPattern__filter_t1atlExpression_t1atlPattern_p1" + ", " + trace_51);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull MatchedRule t1atlRule = trace_51.getT1atlRule();
		final /*@NonInvalid*/ @Nullable TmapMatchedRule TmapMatchedRule = OPPOSITE_OF_TmapMatchedRule_t1matchedRule.get(t1atlRule);
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
			/*@Thrown*/ @Nullable Boolean symbol_22;
			if (success) {
				final /*@NonInvalid*/ @Nullable InPattern inPattern = t1atlRule.getInPattern();
				final /*@NonInvalid*/ boolean symbol_1 = inPattern != null;
				/*@Thrown*/ @Nullable Boolean raw_atlPattern;
				if (symbol_1) {
					if (inPattern == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable TmapInPattern TmapInPattern = OPPOSITE_OF_TmapInPattern_t1atlPattern.get(inPattern);
					final /*@Thrown*/ boolean symbol_2 = TmapInPattern != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapInPattern;
					if (symbol_2) {
						if (TmapInPattern == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable Boolean success_0 = TmapInPattern.getSuccess();
						if (success_0 == null) {
							throw new InvalidEvaluationException("Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_21;
						if (success_0) {
							final /*@Thrown*/ @Nullable OclExpression filter = inPattern.getFilter();
							final /*@Thrown*/ boolean symbol_3 = filter != null;
							/*@Thrown*/ @Nullable Boolean raw_atlExpression;
							if (symbol_3) {
								if (filter == null) {
									throw new InvalidEvaluationException("Null where non-null value required");
								}
								final /*@Thrown*/ @Nullable DmapOclExpression DmapOclExpression = OPPOSITE_OF_DmapOclExpression_d1atlExpression.get(filter);
								final /*@Thrown*/ boolean symbol_4 = DmapOclExpression != null;
								/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
								if (symbol_4) {
									if (DmapOclExpression == null) {
										throw new InvalidEvaluationException("Null where non-null value required");
									}
									final /*@Thrown*/ @Nullable Boolean success_1 = DmapOclExpression.getSuccess();
									if (success_1 == null) {
										throw new InvalidEvaluationException("Null if condition");
									}
									/*@Thrown*/ @Nullable Boolean symbol_20;
									if (success_1) {
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull Relation t2qvtrRelation = TmapMatchedRule.getT2qvtrRelation();
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull RelationDomain t2qvtrDomain = TmapInPattern.getT2qvtrDomain();
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = DmapOclExpression.getD2qvtrExpression();
										// creations
										final @NonNull Predicate p = QVTbaseFactory.eINSTANCE.createPredicate();
										models[1/*qvtr*/].add(p, false);
										final @NonNull Pattern w = QVTbaseFactory.eINSTANCE.createPattern();
										models[1/*qvtr*/].add(w, false);
										// mapping statements
										t2qvtrDomain.setRule(t2qvtrRelation);
										t2qvtrRelation.setWhen(w);
										p.setConditionExpression(d2qvtrExpression);
										w.getPredicate().add(p);
										trace_51.setT1atlExpression(filter);
										trace_51.setT1atlPattern(inPattern);
										trace_51.setT2p(p);
										trace_51.setT2qvtrDomain(t2qvtrDomain);
										trace_51.setT2qvtrExpression(d2qvtrExpression);
										trace_51.setT2qvtrRelation(t2qvtrRelation);
										trace_51.setT2w(w);
										trace_51.setWmapInPattern(TmapInPattern);
										trace_51.setWmapMatchedRule(TmapMatchedRule);
										trace_51.setWmapOclExpression(DmapOclExpression);
										final /*@Thrown*/ @Nullable Boolean mTmapInPattern__filter_t1atlExpression_t1atlPattern_p1 = ValueUtil.TRUE_VALUE;
										symbol_20 = mTmapInPattern__filter_t1atlExpression_t1atlPattern_p1;
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
					raw_atlPattern = raw_when_mapInPattern;
				}
				else {
					raw_atlPattern = ValueUtil.FALSE_VALUE;
				}
				symbol_22 = raw_atlPattern;
			}
			else {
				symbol_22 = ValueUtil.FALSE_VALUE;
			}
			raw_when_mapMatchedRule = symbol_22;
		}
		else {
			raw_when_mapMatchedRule = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_mapMatchedRule ? "done "  : "fail ") + "MAP_mTmapInPattern__filter_t1atlExpression_t1atlPattern_p1");
		}
		return raw_when_mapMatchedRule;
	}

	/**
	 *
	 * map mTmapOperationCallExp__argument_t1atlParent_t2qvtrA_p1 in ATL2QVTr {
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
	 * set trace.wmapOclExpression1 := when_mapOperationCallExp;
	 * set trace.wmapOclExpression := when_mapOclExpression;
	 *
	 */
	protected boolean MAP_mTmapOperationCallExp__argument_t1atlParent_t2qvtrA_p1(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_argument trace_52)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperationCallExp__argument_t1atlParent_t2qvtrA_p1" + ", " + trace_52);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression t1atlArgument = trace_52.getT1atlArgument();
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
				final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@Nullable OperationCallExp parentOperation = t1atlArgument.getParentOperation();
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
								trace_52.setT1atlParent(parentOperation);
								trace_52.setT2qvtrArgument(d2qvtrExpression);
								trace_52.setT2qvtrParent(symbol_4);
								trace_52.setWmapOclExpression1(DmapOclExpression_0);
								trace_52.setWmapOclExpression(DmapOclExpression);
								final /*@Thrown*/ @Nullable Boolean mTmapOperationCallExp__argument_t1atlParent_t2qvtrA_p1 = ValueUtil.TRUE_VALUE;
								symbol_12 = mTmapOperationCallExp__argument_t1atlParent_t2qvtrA_p1;
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
			AbstractTransformer.INVOCATIONS.println((raw_when_mapOclExpression ? "done "  : "fail ") + "MAP_mTmapOperationCallExp__argument_t1atlParent_t2qvtrA_p1");
		}
		return raw_when_mapOclExpression;
	}

	/**
	 *
	 * map mTmapVariableExp__referredVariable__VariableDeclara_p1 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1] success success;
	 * var atlVariable : ATL::PatternElement[1] := trace.t1atlVariable;
	 * var when_mapVariable : trace_ATL2QVTr::TmapVariable[1] := atlVariable.TmapVariable;
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 * set dispatcher.success := true;
	 * set dispatcher.result := trace;
	 *
	 */
	protected boolean MAP_mTmapVariableExp__referredVariable__VariableDeclara_p1(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_VariableDeclaration trace_53)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapVariableExp__referredVariable__VariableDeclara_p1" + ", " + trace_53);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull PatternElement t1atlVariable = trace_53.getT1atlVariable();
		final /*@NonInvalid*/ @Nullable TmapVariable TmapVariable = OPPOSITE_OF_TmapVariable_t1atlVariable.get(t1atlVariable);
		final /*@NonInvalid*/ boolean symbol_0 = TmapVariable != null;
		/*@Thrown*/ @Nullable Boolean raw_when_mapVariable;
		if (symbol_0) {
			if (TmapVariable == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher_0 = trace_53.getDispatcher();
			// mapping statements
			dispatcher_0.setSuccess((Boolean)ValueUtil.TRUE_VALUE);
			dispatcher_0.setResult(trace_53);
			final /*@Thrown*/ @Nullable Boolean mTmapVariableExp__referredVariable__VariableDeclara_p1 = ValueUtil.TRUE_VALUE;
			raw_when_mapVariable = mTmapVariableExp__referredVariable__VariableDeclara_p1;
		}
		else {
			raw_when_mapVariable = ValueUtil.FALSE_VALUE;
		}
		trace_53.setSuccess(raw_when_mapVariable);
		if (raw_when_mapVariable) {
			objectManager.assigned(trace_53, trace_ATL2QVTrPackage.Literals.IMAP_VARIABLE_EXP_REFERRED_VARIABLE__SUCCESS, raw_when_mapVariable);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_mapVariable ? "done "  : "fail ") + "MAP_mTmapVariableExp__referredVariable__VariableDeclara_p1");
		}
		return raw_when_mapVariable;
	}

	/**
	 *
	 * map mTmapVariableExp__referredVariable__VariableDeclara_p2 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 *
	 */
	protected boolean MAP_mTmapVariableExp__referredVariable__VariableDeclara_p2(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_VariableDeclaration trace_54)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapVariableExp__referredVariable__VariableDeclara_p2" + ", " + trace_54);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_54.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_1;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher_0 = trace_54.getDispatcher();
			// mapping statements
			final /*@Thrown*/ @Nullable Boolean mTmapVariableExp__referredVariable__VariableDeclara_p2 = ValueUtil.TRUE_VALUE;
			symbol_1 = mTmapVariableExp__referredVariable__VariableDeclara_p2;
		}
		else {
			symbol_1 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_1 ? "done "  : "fail ") + "MAP_mTmapVariableExp__referredVariable__VariableDeclara_p2");
		}
		return symbol_1;
	}

	/**
	 *
	 * map mTmapHelper__Attribute_wmapHelper_Context_p2 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * append jm_TmapHelper__Context  : trace_ATL2QVTr::TmapHelper_Context[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * var attributeName : String[1] := trace.t0attributeName;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := trace.t2qvtrTransformation;
	 * var atlHelper : ATL::Helper[1] := dispatcher.d1atlHelper;
	 * new:qvtr qvtrFunction : qvtbase::Function[1];
	 * new:middle where_mapHelper_Context : trace_ATL2QVTr::TmapHelper_Context[1];
	 * set qvtrFunction.name := attributeName;
	 * set dispatcher.d2qvtrFunction := qvtrFunction;
	 * set trace.wmapHelper_Context := where_mapHelper_Context;
	 * set qvtrFunction.owningClass := qvtrTransformation;
	 * set where_mapHelper_Context.t1atlHelper := atlHelper;
	 * set where_mapHelper_Context.t2qvtrFunction := qvtrFunction;
	 * add jm_TmapHelper__Context += where_mapHelper_Context;
	 *
	 */
	protected boolean MAP_mTmapHelper__Attribute_wmapHelper_Context_p2(final @NonNull Connection jm_TmapHelper__Context, final /*@NonInvalid*/ @NonNull TmapHelper_Attribute trace_55)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapHelper__Attribute_wmapHelper_Context_p2" + ", " + jm_TmapHelper__Context + ", " + trace_55);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_55.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_8;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_55.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String t0attributeName = trace_55.getT0attributeName();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull RelationalTransformation t2qvtrTransformation = trace_55.getT2qvtrTransformation();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Helper d1atlHelper = dispatcher_0.getD1atlHelper();
			// creations
			final @NonNull Function qvtrFunction = QVTbaseFactory.eINSTANCE.createFunction();
			models[1/*qvtr*/].add(qvtrFunction, false);
			final @SuppressWarnings("null")@NonNull TmapHelper_Context where_mapHelper_Context = trace_ATL2QVTrFactory.eINSTANCE.createTmapHelper_Context();
			models[2/*middle*/].add(where_mapHelper_Context, false);
			// mapping statements
			qvtrFunction.setName(t0attributeName);
			dispatcher_0.setD2qvtrFunction(qvtrFunction);
			trace_55.setWmapHelper_Context(where_mapHelper_Context);
			qvtrFunction.setOwningClass(t2qvtrTransformation);
			where_mapHelper_Context.setT1atlHelper(d1atlHelper);
			where_mapHelper_Context.setT2qvtrFunction(qvtrFunction);
			jm_TmapHelper__Context.appendElement(where_mapHelper_Context);
			final /*@Thrown*/ @Nullable Boolean mTmapHelper__Attribute_wmapHelper_Context_p2 = ValueUtil.TRUE_VALUE;
			symbol_8 = mTmapHelper__Attribute_wmapHelper_Context_p2;
		}
		else {
			symbol_8 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_8 ? "done "  : "fail ") + "MAP_mTmapHelper__Attribute_wmapHelper_Context_p2");
		}
		return symbol_8;
	}

	/**
	 *
	 * map mTmapHelper__Operation_wmapHelper_Context_p2 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * append jm_TmapHelper__Context  : trace_ATL2QVTr::TmapHelper_Context[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * var operationName : String[1] := trace.t0operationName;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := trace.t2qvtrTransformation;
	 * var atlHelper : ATL::Helper[1] := dispatcher.d1atlHelper;
	 * new:qvtr qvtrFunction : qvtbase::Function[1];
	 * new:middle where_mapHelper_Context : trace_ATL2QVTr::TmapHelper_Context[1];
	 * set qvtrFunction.name := operationName;
	 * set dispatcher.d2qvtrFunction := qvtrFunction;
	 * set trace.wmapHelper_Context := where_mapHelper_Context;
	 * set qvtrFunction.owningClass := qvtrTransformation;
	 * set where_mapHelper_Context.t1atlHelper := atlHelper;
	 * set where_mapHelper_Context.t2qvtrFunction := qvtrFunction;
	 * add jm_TmapHelper__Context += where_mapHelper_Context;
	 *
	 */
	protected boolean MAP_mTmapHelper__Operation_wmapHelper_Context_p2(final @NonNull Connection jm_TmapHelper__Context_0, final /*@NonInvalid*/ @NonNull TmapHelper_Operation trace_56)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapHelper__Operation_wmapHelper_Context_p2" + ", " + jm_TmapHelper__Context_0 + ", " + trace_56);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_56.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_8;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_56.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String t0operationName = trace_56.getT0operationName();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull RelationalTransformation t2qvtrTransformation = trace_56.getT2qvtrTransformation();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Helper d1atlHelper = dispatcher_0.getD1atlHelper();
			// creations
			final @NonNull Function qvtrFunction = QVTbaseFactory.eINSTANCE.createFunction();
			models[1/*qvtr*/].add(qvtrFunction, false);
			final @SuppressWarnings("null")@NonNull TmapHelper_Context where_mapHelper_Context = trace_ATL2QVTrFactory.eINSTANCE.createTmapHelper_Context();
			models[2/*middle*/].add(where_mapHelper_Context, false);
			// mapping statements
			qvtrFunction.setName(t0operationName);
			dispatcher_0.setD2qvtrFunction(qvtrFunction);
			trace_56.setWmapHelper_Context(where_mapHelper_Context);
			qvtrFunction.setOwningClass(t2qvtrTransformation);
			where_mapHelper_Context.setT1atlHelper(d1atlHelper);
			where_mapHelper_Context.setT2qvtrFunction(qvtrFunction);
			jm_TmapHelper__Context_0.appendElement(where_mapHelper_Context);
			final /*@Thrown*/ @Nullable Boolean mTmapHelper__Operation_wmapHelper_Context_p2 = ValueUtil.TRUE_VALUE;
			symbol_8 = mTmapHelper__Operation_wmapHelper_Context_p2;
		}
		else {
			symbol_8 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_8 ? "done "  : "fail ") + "MAP_mTmapHelper__Operation_wmapHelper_Context_p2");
		}
		return symbol_8;
	}

	/**
	 *
	 * map mTmapHelper__Attribute_t2qvtrExpression_p3 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrFunction : qvtbase::Function[1] := dispatcher.d2qvtrFunction;
	 * var qvtrExpression : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * set qvtrFunction.queryExpression := qvtrExpression;
	 * set trace.t2qvtrExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_mTmapHelper__Attribute_t2qvtrExpression_p3(final /*@NonInvalid*/ @NonNull TmapHelper_Attribute trace_57)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapHelper__Attribute_t2qvtrExpression_p3" + ", " + trace_57);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_57.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_4;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_57.getDispatcher();
			final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_57.getWmapOclExpression();
			final /*@NonInvalid*/ boolean symbol_0 = wmapOclExpression != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
			if (symbol_0) {
				if (wmapOclExpression == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Function d2qvtrFunction = dispatcher_0.getD2qvtrFunction();
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
				// mapping statements
				d2qvtrFunction.setQueryExpression(d2qvtrExpression);
				trace_57.setT2qvtrExpression(d2qvtrExpression);
				final /*@Thrown*/ @Nullable Boolean mTmapHelper__Attribute_t2qvtrExpression_p3 = ValueUtil.TRUE_VALUE;
				raw_when_mapOclExpression = mTmapHelper__Attribute_t2qvtrExpression_p3;
			}
			else {
				raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
			}
			symbol_4 = raw_when_mapOclExpression;
		}
		else {
			symbol_4 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_4 ? "done "  : "fail ") + "MAP_mTmapHelper__Attribute_t2qvtrExpression_p3");
		}
		return symbol_4;
	}

	/**
	 *
	 * map mTmapHelper__Operation_t2qvtrExpression_p3 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrFunction : qvtbase::Function[1] := dispatcher.d2qvtrFunction;
	 * var qvtrExpression : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * set qvtrFunction.queryExpression := qvtrExpression;
	 * set trace.t2qvtrExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_mTmapHelper__Operation_t2qvtrExpression_p3(final /*@NonInvalid*/ @NonNull TmapHelper_Operation trace_58)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapHelper__Operation_t2qvtrExpression_p3" + ", " + trace_58);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_58.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_4;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_58.getDispatcher();
			final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_58.getWmapOclExpression();
			final /*@NonInvalid*/ boolean symbol_0 = wmapOclExpression != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
			if (symbol_0) {
				if (wmapOclExpression == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Function d2qvtrFunction = dispatcher_0.getD2qvtrFunction();
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
				// mapping statements
				d2qvtrFunction.setQueryExpression(d2qvtrExpression);
				trace_58.setT2qvtrExpression(d2qvtrExpression);
				final /*@Thrown*/ @Nullable Boolean mTmapHelper__Operation_t2qvtrExpression_p3 = ValueUtil.TRUE_VALUE;
				raw_when_mapOclExpression = mTmapHelper__Operation_t2qvtrExpression_p3;
			}
			else {
				raw_when_mapOclExpression = ValueUtil.FALSE_VALUE;
			}
			symbol_4 = raw_when_mapOclExpression;
		}
		else {
			symbol_4 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_4 ? "done "  : "fail ") + "MAP_mTmapHelper__Operation_t2qvtrExpression_p3");
		}
		return symbol_4;
	}

	/**
	 *
	 * map mTmapHelper__Attribute__type_p4 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapHelper_Attribute[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * var atlType : OCL::OclType[1] := trace.t1atlType;
	 * var qvtrFunction : qvtbase::Function[1] := dispatcher.d2qvtrFunction;
	 * var getType1 : Class[1] := this.getType(atlType);
	 * set qvtrFunction.type := getType1;
	 *
	 */
	protected boolean MAP_mTmapHelper__Attribute__type_p4(final /*@NonInvalid*/ @NonNull TmapHelper_Attribute trace_59)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapHelper__Attribute__type_p4" + ", " + trace_59);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_59.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_2;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_59.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclType t1atlType = trace_59.getT1atlType();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Function d2qvtrFunction = dispatcher_0.getD2qvtrFunction();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(this, t1atlType)).instance;
			// mapping statements
			d2qvtrFunction.setType(getType);
			final /*@Thrown*/ @Nullable Boolean mTmapHelper__Attribute__type_p4 = ValueUtil.TRUE_VALUE;
			symbol_2 = mTmapHelper__Attribute__type_p4;
		}
		else {
			symbol_2 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_2 ? "done "  : "fail ") + "MAP_mTmapHelper__Attribute__type_p4");
		}
		return symbol_2;
	}

	/**
	 *
	 * map mTmapHelper__Operation__type_p4 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapHelper_Operation[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapHelper[1] := trace.dispatcher;
	 * var atlType : OCL::OclType[1] := trace.t1atlType;
	 * var qvtrFunction : qvtbase::Function[1] := dispatcher.d2qvtrFunction;
	 * var getType1 : Class[1] := this.getType(atlType);
	 * set qvtrFunction.type := getType1;
	 *
	 */
	protected boolean MAP_mTmapHelper__Operation__type_p4(final /*@NonInvalid*/ @NonNull TmapHelper_Operation trace_60)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapHelper__Operation__type_p4" + ", " + trace_60);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_60.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_2;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapHelper dispatcher_0 = trace_60.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclType t1atlType = trace_60.getT1atlType();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Function d2qvtrFunction = dispatcher_0.getD2qvtrFunction();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(this, t1atlType)).instance;
			// mapping statements
			d2qvtrFunction.setType(getType);
			final /*@Thrown*/ @Nullable Boolean mTmapHelper__Operation__type_p4 = ValueUtil.TRUE_VALUE;
			symbol_2 = mTmapHelper__Operation__type_p4;
		}
		else {
			symbol_2 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_2 ? "done "  : "fail ") + "MAP_mTmapHelper__Operation__type_p4");
		}
		return symbol_2;
	}

	/**
	 *
	 * map mTmapNavigationOrAttributeCallExp__Helper_t2qvtrOpe_p6 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * var when_mapHelper_Attribute : trace_ATL2QVTr::DmapHelper[1] := trace.wmapHelper;
	 * var qvtrOperation : Operation[1] := when_mapHelper_Attribute.d2qvtrFunction;
	 * set qvtrExpression.referredOperation := qvtrOperation;
	 * set trace.t2qvtrOperation := qvtrOperation;
	 *
	 */
	protected boolean MAP_mTmapNavigationOrAttributeCallExp__Helper_t2qvtrOpe_p6(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_61)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapNavigationOrAttributeCallExp__Helper_t2qvtrOpe_p6" + ", " + trace_61);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_61.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_61.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable DmapHelper wmapHelper = trace_61.getWmapHelper();
				final /*@NonInvalid*/ boolean symbol_2 = wmapHelper != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapHelper_Attribute;
				if (symbol_2) {
					if (wmapHelper == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull Function d2qvtrFunction = wmapHelper.getD2qvtrFunction();
					// mapping statements
					symbol_1.setReferredOperation(d2qvtrFunction);
					trace_61.setT2qvtrOperation(d2qvtrFunction);
					final /*@Thrown*/ @Nullable Boolean mTmapNavigationOrAttributeCallExp__Helper_t2qvtrOpe_p6 = ValueUtil.TRUE_VALUE;
					raw_when_mapHelper_Attribute = mTmapNavigationOrAttributeCallExp__Helper_t2qvtrOpe_p6;
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
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_mTmapNavigationOrAttributeCallExp__Helper_t2qvtrOpe_p6");
		}
		return symbol_7;
	}

	/**
	 *
	 * map mTmapOperationCallExp__Helper_t2qvtrOperation_p6 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * var when_mapHelper_Operation : trace_ATL2QVTr::DmapHelper[1] := trace.wmapHelper;
	 * var qvtrOperation : Operation[1] := when_mapHelper_Operation.d2qvtrFunction;
	 * set qvtrExpression.referredOperation := qvtrOperation;
	 * set trace.t2qvtrOperation := qvtrOperation;
	 *
	 */
	protected boolean MAP_mTmapOperationCallExp__Helper_t2qvtrOperation_p6(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_62)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperationCallExp__Helper_t2qvtrOperation_p6" + ", " + trace_62);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_62.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_62.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable DmapHelper wmapHelper = trace_62.getWmapHelper();
				final /*@NonInvalid*/ boolean symbol_2 = wmapHelper != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapHelper_Operation;
				if (symbol_2) {
					if (wmapHelper == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull Function d2qvtrFunction = wmapHelper.getD2qvtrFunction();
					// mapping statements
					symbol_1.setReferredOperation(d2qvtrFunction);
					trace_62.setT2qvtrOperation(d2qvtrFunction);
					final /*@Thrown*/ @Nullable Boolean mTmapOperationCallExp__Helper_t2qvtrOperation_p6 = ValueUtil.TRUE_VALUE;
					raw_when_mapHelper_Operation = mTmapOperationCallExp__Helper_t2qvtrOperation_p6;
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
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_mTmapOperationCallExp__Helper_t2qvtrOperation_p6");
		}
		return symbol_7;
	}

	/**
	 *
	 * map mTmapNavigationOrAttributeCallExp__Helper__type_p7 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Helper[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * var when_mapHelper_Attribute : trace_ATL2QVTr::DmapHelper[1] := trace.wmapHelper;
	 * var qvtrOperation : Operation[1] := when_mapHelper_Attribute.d2qvtrFunction;
	 * var type : Type[?] := qvtrOperation.type;
	 * notify set qvtrExpression.type := type;
	 *
	 */
	protected boolean MAP_mTmapNavigationOrAttributeCallExp__Helper__type_p7(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Helper trace_63)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapNavigationOrAttributeCallExp__Helper__type_p7" + ", " + trace_63);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_63.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_6;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_63.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable DmapHelper wmapHelper = trace_63.getWmapHelper();
				final /*@NonInvalid*/ boolean symbol_2 = wmapHelper != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapHelper_Attribute;
				if (symbol_2) {
					if (wmapHelper == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull Function d2qvtrFunction = wmapHelper.getD2qvtrFunction();
					final /*@Thrown*/ @Nullable Type type_2 = d2qvtrFunction.getType();
					// mapping statements
					symbol_1.setType(type_2);
					objectManager.assigned(symbol_1, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_2);
					final /*@Thrown*/ @Nullable Boolean mTmapNavigationOrAttributeCallExp__Helper__type_p7 = ValueUtil.TRUE_VALUE;
					raw_when_mapHelper_Attribute = mTmapNavigationOrAttributeCallExp__Helper__type_p7;
				}
				else {
					raw_when_mapHelper_Attribute = ValueUtil.FALSE_VALUE;
				}
				symbol_5 = raw_when_mapHelper_Attribute;
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
			AbstractTransformer.INVOCATIONS.println((symbol_6 ? "done "  : "fail ") + "MAP_mTmapNavigationOrAttributeCallExp__Helper__type_p7");
		}
		return symbol_6;
	}

	/**
	 *
	 * map mTmapOperationCallExp__Helper__type_p7 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Helper[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * var when_mapHelper_Operation : trace_ATL2QVTr::DmapHelper[1] := trace.wmapHelper;
	 * var qvtrOperation : Operation[1] := when_mapHelper_Operation.d2qvtrFunction;
	 * var type : Type[?] := qvtrOperation.type;
	 * notify set qvtrExpression.type := type;
	 *
	 */
	protected boolean MAP_mTmapOperationCallExp__Helper__type_p7(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Helper trace_64)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperationCallExp__Helper__type_p7" + ", " + trace_64);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_64.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_6;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_64.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				final /*@NonInvalid*/ @Nullable DmapHelper wmapHelper = trace_64.getWmapHelper();
				final /*@NonInvalid*/ boolean symbol_2 = wmapHelper != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapHelper_Operation;
				if (symbol_2) {
					if (wmapHelper == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull Function d2qvtrFunction = wmapHelper.getD2qvtrFunction();
					final /*@Thrown*/ @Nullable Type type_2 = d2qvtrFunction.getType();
					// mapping statements
					symbol_1.setType(type_2);
					objectManager.assigned(symbol_1, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_2);
					final /*@Thrown*/ @Nullable Boolean mTmapOperationCallExp__Helper__type_p7 = ValueUtil.TRUE_VALUE;
					raw_when_mapHelper_Operation = mTmapOperationCallExp__Helper__type_p7;
				}
				else {
					raw_when_mapHelper_Operation = ValueUtil.FALSE_VALUE;
				}
				symbol_5 = raw_when_mapHelper_Operation;
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
			AbstractTransformer.INVOCATIONS.println((symbol_6 ? "done "  : "fail ") + "MAP_mTmapOperationCallExp__Helper__type_p7");
		}
		return symbol_6;
	}

	/**
	 *
	 * map mTmapHelper__Context_t1atlContext_t1atlDefinition_t in ATL2QVTr {
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
	protected boolean MAP_mTmapHelper__Context_t1atlContext_t1atlDefinition_t(final @NonNull Connection jm_TmapVariable_1, final /*@NonInvalid*/ @NonNull TmapHelper_Context trace_65)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapHelper__Context_t1atlContext_t1atlDefinition_t" + ", " + jm_TmapVariable_1 + ", " + trace_65);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Helper t1atlHelper = trace_65.getT1atlHelper();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Function t2qvtrFunction = trace_65.getT2qvtrFunction();
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
			final @SuppressWarnings("null")@NonNull TmapVariable where_mapVariable = trace_ATL2QVTrFactory.eINSTANCE.createTmapVariable();
			models[2/*middle*/].add(where_mapVariable, false);
			// mapping statements
			qvtrParameter.setName(STR_self);
			t2qvtrFunction.getOwnedParameters().add(qvtrParameter);
			trace_65.setT1atlContext(context_);
			trace_65.setT1atlDefinition(definition);
			trace_65.setT1atlReturnType(context__0);
			trace_65.setT2qvtrParameter(qvtrParameter);
			trace_65.setWmapVariable(where_mapVariable);
			qvtrParameter.setType(getType);
			OPPOSITE_OF_TmapVariable_t1atlVariable.put(t1atlHelper, where_mapVariable);
			where_mapVariable.setT1atlVariable(t1atlHelper);
			where_mapVariable.setT2qvtrVariable(qvtrParameter);
			jm_TmapVariable_1.appendElement(where_mapVariable);
			final /*@Thrown*/ @Nullable Boolean mTmapHelper__Context_t1atlContext_t1atlDefinition_t = ValueUtil.TRUE_VALUE;
			raw_atlContext = mTmapHelper__Context_t1atlContext_t1atlDefinition_t;
		}
		else {
			raw_atlContext = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_atlContext ? "done "  : "fail ") + "MAP_mTmapHelper__Context_t1atlContext_t1atlDefinition_t");
		}
		return raw_atlContext;
	}

	/**
	 *
	 * map mTmapVariable_success in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariable[1] success success;
	 * var atlVariable : ATL::LocatedElement[1] := trace.t1atlVariable;
	 * var qvtrVariable : VariableDeclaration[1] := trace.t2qvtrVariable;
	 *
	 */
	protected boolean MAP_mTmapVariable_success(final /*@NonInvalid*/ @NonNull TmapVariable trace_66)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapVariable_success" + ", " + trace_66);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull LocatedElement t1atlVariable = trace_66.getT1atlVariable();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableDeclaration t2qvtrVariable = trace_66.getT2qvtrVariable();
		// mapping statements
		final /*@Thrown*/ @Nullable Boolean mTmapVariable_success = ValueUtil.TRUE_VALUE;
		trace_66.setSuccess(mTmapVariable_success);
		if (mTmapVariable_success) {
			objectManager.assigned(trace_66, trace_ATL2QVTrPackage.Literals.TMAP_VARIABLE__SUCCESS, mTmapVariable_success);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((mTmapVariable_success ? "done "  : "fail ") + "MAP_mTmapVariable_success");
		}
		return mTmapVariable_success;
	}

	/**
	 *
	 * map mTmapVariableExp__referredVariable__VariableDeclara_p3 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 * var atlVariable : ATL::PatternElement[1] := trace.t1atlVariable;
	 * var qvtrExpression : VariableExp[1] := dispatcher.d2qvtrExpression;
	 * var when_mapVariable : trace_ATL2QVTr::TmapVariable[1] := atlVariable.TmapVariable;
	 * var qvtrVariable : VariableDeclaration[1] := when_mapVariable.t2qvtrVariable;
	 * var name : String[?] := qvtrVariable.name;
	 * set qvtrExpression.name := name;
	 * set qvtrExpression.referredVariable := qvtrVariable;
	 * set trace.t2qvtrVariable := qvtrVariable;
	 *
	 */
	protected boolean MAP_mTmapVariableExp__referredVariable__VariableDeclara_p3(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_VariableDeclaration trace_67)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapVariableExp__referredVariable__VariableDeclara_p3" + ", " + trace_67);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_67.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_5;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher_0 = trace_67.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull PatternElement t1atlVariable = trace_67.getT1atlVariable();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp d2qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ @Nullable TmapVariable TmapVariable = OPPOSITE_OF_TmapVariable_t1atlVariable.get(t1atlVariable);
			final /*@NonInvalid*/ boolean symbol_0 = TmapVariable != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapVariable;
			if (symbol_0) {
				if (TmapVariable == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull VariableDeclaration t2qvtrVariable = TmapVariable.getT2qvtrVariable();
				final /*@Thrown*/ @Nullable String name_2 = t2qvtrVariable.getName();
				// mapping statements
				d2qvtrExpression.setName(name_2);
				d2qvtrExpression.setReferredVariable(t2qvtrVariable);
				trace_67.setT2qvtrVariable(t2qvtrVariable);
				final /*@Thrown*/ @Nullable Boolean mTmapVariableExp__referredVariable__VariableDeclara_p3 = ValueUtil.TRUE_VALUE;
				raw_when_mapVariable = mTmapVariableExp__referredVariable__VariableDeclara_p3;
			}
			else {
				raw_when_mapVariable = ValueUtil.FALSE_VALUE;
			}
			symbol_5 = raw_when_mapVariable;
		}
		else {
			symbol_5 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_5 ? "done "  : "fail ") + "MAP_mTmapVariableExp__referredVariable__VariableDeclara_p3");
		}
		return symbol_5;
	}

	/**
	 *
	 * map mTmapVariableExp__referredVariable__VariableDeclara_p4 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 * var atlVariable : ATL::PatternElement[1] := trace.t1atlVariable;
	 * var qvtrExpression : VariableExp[1] := dispatcher.d2qvtrExpression;
	 * var when_mapVariable : trace_ATL2QVTr::TmapVariable[1] := atlVariable.TmapVariable;
	 * var qvtrVariable : VariableDeclaration[1] := when_mapVariable.t2qvtrVariable;
	 * var type : Type[?] := qvtrVariable.type;
	 * notify set qvtrExpression.type := type;
	 *
	 */
	protected boolean MAP_mTmapVariableExp__referredVariable__VariableDeclara_p4(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_VariableDeclaration trace_68)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapVariableExp__referredVariable__VariableDeclara_p4" + ", " + trace_68);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_68.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_3;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher_0 = trace_68.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull PatternElement t1atlVariable = trace_68.getT1atlVariable();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp d2qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ @Nullable TmapVariable TmapVariable = OPPOSITE_OF_TmapVariable_t1atlVariable.get(t1atlVariable);
			final /*@NonInvalid*/ boolean symbol_0 = TmapVariable != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapVariable;
			if (symbol_0) {
				if (TmapVariable == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull VariableDeclaration t2qvtrVariable = TmapVariable.getT2qvtrVariable();
				final /*@Thrown*/ @Nullable Type type_2 = t2qvtrVariable.getType();
				// mapping statements
				d2qvtrExpression.setType(type_2);
				objectManager.assigned(d2qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_2);
				final /*@Thrown*/ @Nullable Boolean mTmapVariableExp__referredVariable__VariableDeclara_p4 = ValueUtil.TRUE_VALUE;
				raw_when_mapVariable = mTmapVariableExp__referredVariable__VariableDeclara_p4;
			}
			else {
				raw_when_mapVariable = ValueUtil.FALSE_VALUE;
			}
			symbol_3 = raw_when_mapVariable;
		}
		else {
			symbol_3 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_3 ? "done "  : "fail ") + "MAP_mTmapVariableExp__referredVariable__VariableDeclara_p4");
		}
		return symbol_3;
	}

	/**
	 *
	 * map mTmapVariableExp__referredVariable__Helper_success_p1 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1] success success;
	 * var atlVariable : OCL::VariableDeclaration[1] := trace.t1atlVariable;
	 * check atlVariable.varName =
	 *   'self';
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 * var atlExpression : OCL::VariableExp[1] := dispatcher.d1atlExpression;
	 * var atlHelper : ATL::Helper[1] := this.getHelper(atlExpression);
	 * var when_mapVariable : trace_ATL2QVTr::TmapVariable[1] := atlHelper.TmapVariable;
	 * set dispatcher.success := true;
	 * set dispatcher.result := trace;
	 *
	 */
	protected boolean MAP_mTmapVariableExp__referredVariable__Helper_success_p1(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_Helper trace_69)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapVariableExp__referredVariable__Helper_success_p1" + ", " + trace_69);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableDeclaration t1atlVariable = trace_69.getT1atlVariable();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String varName = t1atlVariable.getVarName();
		final /*@NonInvalid*/ boolean eq = varName.equals(STR_self);
		/*@Thrown*/ @Nullable Boolean symbol_4;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher_0 = trace_69.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableExp d1atlExpression = dispatcher_0.getD1atlExpression();
			final /*@NonInvalid*/ @NonNull Helper getHelper = ((FUN_getHelper)FTOR_getHelper.getUniqueComputation(this, d1atlExpression)).instance;
			final /*@NonInvalid*/ @Nullable TmapVariable TmapVariable = OPPOSITE_OF_TmapVariable_t1atlVariable.get(getHelper);
			final /*@NonInvalid*/ boolean symbol_0 = TmapVariable != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapVariable;
			if (symbol_0) {
				if (TmapVariable == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				// mapping statements
				dispatcher_0.setSuccess((Boolean)ValueUtil.TRUE_VALUE);
				dispatcher_0.setResult(trace_69);
				final /*@Thrown*/ @Nullable Boolean mTmapVariableExp__referredVariable__Helper_success_p1 = ValueUtil.TRUE_VALUE;
				raw_when_mapVariable = mTmapVariableExp__referredVariable__Helper_success_p1;
			}
			else {
				raw_when_mapVariable = ValueUtil.FALSE_VALUE;
			}
			symbol_4 = raw_when_mapVariable;
		}
		else {
			symbol_4 = ValueUtil.FALSE_VALUE;
		}
		trace_69.setSuccess(symbol_4);
		if (symbol_4) {
			objectManager.assigned(trace_69, trace_ATL2QVTrPackage.Literals.IMAP_VARIABLE_EXP_REFERRED_VARIABLE__SUCCESS, symbol_4);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_4 ? "done "  : "fail ") + "MAP_mTmapVariableExp__referredVariable__Helper_success_p1");
		}
		return symbol_4;
	}

	/**
	 *
	 * map mDmapVariableExp__referredVariable_success in ATL2QVTr {
	 * guard:middle mapVariableExp_referredVariable : trace_ATL2QVTr::DmapVariableExp_referredVariable[1];
	 * var mapVariableExp_referredVariable_Helper : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1] := mapVariableExp_referredVariable.domapVariableExp_referredVariable_Helper;
	 * check mapVariableExp_referredVariable_Helper.success = false;
	 * var mapVariableExp_referredVariable_VariableDeclaration : trace_ATL2QVTr::TmapVariableExp_referredVariable_VariableDeclaration[1] := mapVariableExp_referredVariable.domapVariableExp_referredVariable_VariableDeclaration;
	 * check mapVariableExp_referredVariable_VariableDeclaration.success = false;
	 * set mapVariableExp_referredVariable.success := false;
	 *
	 */
	protected boolean MAP_mDmapVariableExp__referredVariable_success(final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable mapVariableExp_referredVariable)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mDmapVariableExp__referredVariable_success" + ", " + mapVariableExp_referredVariable);
		}
		final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_Helper domapVariableExp_referredVariable_Helper = mapVariableExp_referredVariable.getDomapVariableExp_referredVariable_Helper();
		final /*@NonInvalid*/ boolean symbol_0 = domapVariableExp_referredVariable_Helper != null;
		/*@Thrown*/ @Nullable Boolean raw_mapVariableExp_referredVariable_Helper;
		if (symbol_0) {
			if (domapVariableExp_referredVariable_Helper == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable Boolean success = domapVariableExp_referredVariable_Helper.getSuccess();
			final /*@Thrown*/ boolean eq = success == Boolean.FALSE;
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (eq) {
				final /*@NonInvalid*/ @Nullable TmapVariableExp_referredVariable_VariableDeclaration domapVariableExp_referredVariable_VariableDeclaration = mapVariableExp_referredVariable.getDomapVariableExp_referredVariable_VariableDeclaration();
				final /*@NonInvalid*/ boolean symbol_1 = domapVariableExp_referredVariable_VariableDeclaration != null;
				/*@Thrown*/ @Nullable Boolean raw_mapVariableExp_referredVariable_VariableDeclaration;
				if (symbol_1) {
					if (domapVariableExp_referredVariable_VariableDeclaration == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable Boolean success_0 = domapVariableExp_referredVariable_VariableDeclaration.getSuccess();
					final /*@Thrown*/ boolean eq_0 = success_0 == Boolean.FALSE;
					/*@Thrown*/ @Nullable Boolean symbol_4;
					if (eq_0) {
						// mapping statements
						mapVariableExp_referredVariable.setSuccess((Boolean)ValueUtil.FALSE_VALUE);
						final /*@Thrown*/ @Nullable Boolean mDmapVariableExp__referredVariable_success = ValueUtil.TRUE_VALUE;
						symbol_4 = mDmapVariableExp__referredVariable_success;
					}
					else {
						symbol_4 = ValueUtil.FALSE_VALUE;
					}
					raw_mapVariableExp_referredVariable_VariableDeclaration = symbol_4;
				}
				else {
					raw_mapVariableExp_referredVariable_VariableDeclaration = ValueUtil.FALSE_VALUE;
				}
				symbol_5 = raw_mapVariableExp_referredVariable_VariableDeclaration;
			}
			else {
				symbol_5 = ValueUtil.FALSE_VALUE;
			}
			raw_mapVariableExp_referredVariable_Helper = symbol_5;
		}
		else {
			raw_mapVariableExp_referredVariable_Helper = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_mapVariableExp_referredVariable_Helper ? "done "  : "fail ") + "MAP_mDmapVariableExp__referredVariable_success");
		}
		return raw_mapVariableExp_referredVariable_Helper;
	}

	/**
	 *
	 * map mTmapVariableExp__referredVariable__Helper_t2qvtrVa_p3 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 * var atlExpression : OCL::VariableExp[1] := dispatcher.d1atlExpression;
	 * var qvtrExpression : VariableExp[1] := dispatcher.d2qvtrExpression;
	 * var atlHelper : ATL::Helper[1] := this.getHelper(atlExpression);
	 * var when_mapVariable : trace_ATL2QVTr::TmapVariable[1] := atlHelper.TmapVariable;
	 * var qvtrVariable : VariableDeclaration[1] := when_mapVariable.t2qvtrVariable;
	 * set qvtrExpression.referredVariable := qvtrVariable;
	 * set trace.t2qvtrVariable := qvtrVariable;
	 *
	 */
	protected boolean MAP_mTmapVariableExp__referredVariable__Helper_t2qvtrVa_p3(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_Helper trace_70)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapVariableExp__referredVariable__Helper_t2qvtrVa_p3" + ", " + trace_70);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_70.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_4;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher_0 = trace_70.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableExp d1atlExpression = dispatcher_0.getD1atlExpression();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp d2qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ @NonNull Helper getHelper = ((FUN_getHelper)FTOR_getHelper.getUniqueComputation(this, d1atlExpression)).instance;
			final /*@NonInvalid*/ @Nullable TmapVariable TmapVariable = OPPOSITE_OF_TmapVariable_t1atlVariable.get(getHelper);
			final /*@NonInvalid*/ boolean symbol_0 = TmapVariable != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapVariable;
			if (symbol_0) {
				if (TmapVariable == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull VariableDeclaration t2qvtrVariable = TmapVariable.getT2qvtrVariable();
				// mapping statements
				d2qvtrExpression.setReferredVariable(t2qvtrVariable);
				trace_70.setT2qvtrVariable(t2qvtrVariable);
				final /*@Thrown*/ @Nullable Boolean mTmapVariableExp__referredVariable__Helper_t2qvtrVa_p3 = ValueUtil.TRUE_VALUE;
				raw_when_mapVariable = mTmapVariableExp__referredVariable__Helper_t2qvtrVa_p3;
			}
			else {
				raw_when_mapVariable = ValueUtil.FALSE_VALUE;
			}
			symbol_4 = raw_when_mapVariable;
		}
		else {
			symbol_4 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_4 ? "done "  : "fail ") + "MAP_mTmapVariableExp__referredVariable__Helper_t2qvtrVa_p3");
		}
		return symbol_4;
	}

	/**
	 *
	 * map mTmapVariableExp__referredVariable__Helper__type_p4 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 * var atlExpression : OCL::VariableExp[1] := dispatcher.d1atlExpression;
	 * var qvtrExpression : VariableExp[1] := dispatcher.d2qvtrExpression;
	 * var atlHelper : ATL::Helper[1] := this.getHelper(atlExpression);
	 * var when_mapVariable : trace_ATL2QVTr::TmapVariable[1] := atlHelper.TmapVariable;
	 * var qvtrVariable : VariableDeclaration[1] := when_mapVariable.t2qvtrVariable;
	 * var type : Type[?] := qvtrVariable.type;
	 * notify set qvtrExpression.type := type;
	 *
	 */
	protected boolean MAP_mTmapVariableExp__referredVariable__Helper__type_p4(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_Helper trace_71)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapVariableExp__referredVariable__Helper__type_p4" + ", " + trace_71);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_71.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_3;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher_0 = trace_71.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableExp d1atlExpression = dispatcher_0.getD1atlExpression();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp d2qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ @NonNull Helper getHelper = ((FUN_getHelper)FTOR_getHelper.getUniqueComputation(this, d1atlExpression)).instance;
			final /*@NonInvalid*/ @Nullable TmapVariable TmapVariable = OPPOSITE_OF_TmapVariable_t1atlVariable.get(getHelper);
			final /*@NonInvalid*/ boolean symbol_0 = TmapVariable != null;
			/*@Thrown*/ @Nullable Boolean raw_when_mapVariable;
			if (symbol_0) {
				if (TmapVariable == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull VariableDeclaration t2qvtrVariable = TmapVariable.getT2qvtrVariable();
				final /*@Thrown*/ @Nullable Type type_2 = t2qvtrVariable.getType();
				// mapping statements
				d2qvtrExpression.setType(type_2);
				objectManager.assigned(d2qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_2);
				final /*@Thrown*/ @Nullable Boolean mTmapVariableExp__referredVariable__Helper__type_p4 = ValueUtil.TRUE_VALUE;
				raw_when_mapVariable = mTmapVariableExp__referredVariable__Helper__type_p4;
			}
			else {
				raw_when_mapVariable = ValueUtil.FALSE_VALUE;
			}
			symbol_3 = raw_when_mapVariable;
		}
		else {
			symbol_3 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_3 ? "done "  : "fail ") + "MAP_mTmapVariableExp__referredVariable__Helper__type_p4");
		}
		return symbol_3;
	}

	/**
	 *
	 * map mTmapVariableExp__referredVariable__Helper__name_p5 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 * var qvtrExpression : VariableExp[1] := dispatcher.d2qvtrExpression;
	 * set qvtrExpression.name := 'self';
	 *
	 */
	protected boolean MAP_mTmapVariableExp__referredVariable__Helper__name_p5(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_Helper trace_72)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapVariableExp__referredVariable__Helper__name_p5" + ", " + trace_72);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_72.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_2;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher_0 = trace_72.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp d2qvtrExpression = dispatcher_0.getD2qvtrExpression();
			// mapping statements
			d2qvtrExpression.setName(STR_self);
			final /*@Thrown*/ @Nullable Boolean mTmapVariableExp__referredVariable__Helper__name_p5 = ValueUtil.TRUE_VALUE;
			symbol_2 = mTmapVariableExp__referredVariable__Helper__name_p5;
		}
		else {
			symbol_2 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_2 ? "done "  : "fail ") + "MAP_mTmapVariableExp__referredVariable__Helper__name_p5");
		}
		return symbol_2;
	}

	/**
	 *
	 * map mTmapVariableExp__referredVariable__Helper_TmapVari_p2 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TmapVariableExp_referredVariable_Helper[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapVariableExp_referredVariable[1] := trace.dispatcher;
	 *
	 */
	protected boolean MAP_mTmapVariableExp__referredVariable__Helper_TmapVari_p2(final /*@NonInvalid*/ @NonNull TmapVariableExp_referredVariable_Helper trace_73)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapVariableExp__referredVariable__Helper_TmapVari_p2" + ", " + trace_73);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_73.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_1;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapVariableExp_referredVariable dispatcher_0 = trace_73.getDispatcher();
			// mapping statements
			final /*@Thrown*/ @Nullable Boolean mTmapVariableExp__referredVariable__Helper_TmapVari_p2 = ValueUtil.TRUE_VALUE;
			symbol_1 = mTmapVariableExp__referredVariable__Helper_TmapVari_p2;
		}
		else {
			symbol_1 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_1 ? "done "  : "fail ") + "MAP_mTmapVariableExp__referredVariable__Helper_TmapVari_p2");
		}
		return symbol_1;
	}

	/**
	 *
	 * map mTmapNavigationOrAttributeCallExp__Property__type_p5 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var qvtrExpression : PropertyCallExp[1] := dispatcher.d2qvtrExpression;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrSource : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * var type : Type[?] := qvtrSource.type;
	 * var propertyName : String[1] := trace.t0propertyName;
	 * var qvtrProperty : Property[1] := this.getProperty(type, propertyName);
	 * var type1 : Type[?] := qvtrProperty.type;
	 * notify set qvtrExpression.type := type1;
	 *
	 */
	protected class MAP_mTmapNavigationOrAttributeCallExp__Property__type_p5 extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace_74;

		public MAP_mTmapNavigationOrAttributeCallExp__Property__type_p5(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_74 = (TmapNavigationOrAttributeCallExp_Property)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @Nullable Boolean success = trace_74.getSuccess();
			if (success == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (success) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_74.getDispatcher();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof PropertyCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (symbol_0) {
					final /*@NonInvalid*/ @NonNull PropertyCallExp symbol_1 = (PropertyCallExp)temp1_qvtrExpression;
					final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_74.getWmapOclExpression();
					final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
					if (symbol_2) {
						if (wmapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
						objectManager.getting(d2qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@Thrown*/ @Nullable Type type_2 = d2qvtrExpression.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t0propertyName = trace_74.getT0propertyName();
						final /*@Thrown*/ @NonNull Property getProperty = ((FUN_getProperty)FTOR_getProperty.getUniqueComputation(ATL2QVTr.this, type_2, t0propertyName)).instance;
						objectManager.getting(getProperty, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@Thrown*/ @Nullable Type type_3 = getProperty.getType();
						// mapping statements
						symbol_1.setType(type_3);
						objectManager.assigned(symbol_1, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_3);
						final /*@Thrown*/ @Nullable Boolean mTmapNavigationOrAttributeCallExp__Property__type_p5 = ValueUtil.TRUE_VALUE;
						raw_when_mapOclExpression = mTmapNavigationOrAttributeCallExp__Property__type_p5;
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
			return symbol_6;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_74, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mTmapOperationCallExp__Operation__type_p5 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrSource : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * var type : Type[?] := qvtrSource.type;
	 * var operationName : String[1] := trace.t0operationName;
	 * var qvtrOperation : Operation[1] := this.getOperation(type, operationName);
	 * var type1 : Type[?] := qvtrOperation.type;
	 * notify set qvtrExpression.type := type1;
	 *
	 */
	protected class MAP_mTmapOperationCallExp__Operation__type_p5 extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace_75;

		public MAP_mTmapOperationCallExp__Operation__type_p5(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_75 = (TmapOperationCallExp_Operation)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @Nullable Boolean success = trace_75.getSuccess();
			if (success == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (success) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_75.getDispatcher();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (symbol_0) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
					final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_75.getWmapOclExpression();
					final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
					if (symbol_2) {
						if (wmapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
						objectManager.getting(d2qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@Thrown*/ @Nullable Type type_2 = d2qvtrExpression.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t0operationName = trace_75.getT0operationName();
						final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Operation getOperation = ((FUN_getOperation)FTOR_getOperation.getUniqueComputation(ATL2QVTr.this, type_2, t0operationName)).instance;
						objectManager.getting(getOperation, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@Thrown*/ @Nullable Type type_3 = getOperation.getType();
						// mapping statements
						symbol_1.setType(type_3);
						objectManager.assigned(symbol_1, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_3);
						final /*@Thrown*/ @Nullable Boolean mTmapOperationCallExp__Operation__type_p5 = ValueUtil.TRUE_VALUE;
						raw_when_mapOclExpression = mTmapOperationCallExp__Operation__type_p5;
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
			return symbol_6;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_75, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mTmapOperatorCallExp__type_p5 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrSource : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * var type : Type[?] := qvtrSource.type;
	 * var operationName : String[1] := trace.t0operationName;
	 * var qvtrOperation : Operation[1] := this.getOperation(type, operationName);
	 * var type1 : Type[?] := qvtrOperation.type;
	 * notify set qvtrExpression.type := type1;
	 *
	 */
	protected class MAP_mTmapOperatorCallExp__type_p5 extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace_76;

		public MAP_mTmapOperatorCallExp__type_p5(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_76 = (TmapOperatorCallExp)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @Nullable Boolean success = trace_76.getSuccess();
			if (success == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (success) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_76.getDispatcher();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (symbol_0) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
					final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_76.getWmapOclExpression();
					final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
					if (symbol_2) {
						if (wmapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
						objectManager.getting(d2qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@Thrown*/ @Nullable Type type_2 = d2qvtrExpression.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String t0operationName = trace_76.getT0operationName();
						final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Operation getOperation = ((FUN_getOperation)FTOR_getOperation.getUniqueComputation(ATL2QVTr.this, type_2, t0operationName)).instance;
						objectManager.getting(getOperation, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@Thrown*/ @Nullable Type type_3 = getOperation.getType();
						// mapping statements
						symbol_1.setType(type_3);
						objectManager.assigned(symbol_1, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_3);
						final /*@Thrown*/ @Nullable Boolean mTmapOperatorCallExp__type_p5 = ValueUtil.TRUE_VALUE;
						raw_when_mapOclExpression = mTmapOperatorCallExp__type_p5;
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
			return symbol_6;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_76, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mTmapIfExp__type_p6 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapIfExp[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var qvtrExpression : IfExp[1] := dispatcher.d2qvtrExpression;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression2;
	 * var qvtrThen : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * var type : Type[?] := qvtrThen.type;
	 * var when_mapOclExpression1 : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression1;
	 * var qvtrElse : OCLExpression[1] := when_mapOclExpression1.d2qvtrExpression;
	 * var type1 : Type[?] := qvtrElse.type;
	 * var getCommonType1 : Type[1] := this.getCommonType(type, type1);
	 * notify set qvtrExpression.type := getCommonType1;
	 *
	 */
	protected class MAP_mTmapIfExp__type_p6 extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TmapIfExp trace_77;

		public MAP_mTmapIfExp__type_p6(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_77 = (TmapIfExp)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @Nullable Boolean success = trace_77.getSuccess();
			if (success == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_7;
			if (success) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_77.getDispatcher();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.IfExp;
				/*@Thrown*/ @Nullable Boolean symbol_6;
				if (symbol_0) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull IfExp symbol_1 = (org.eclipse.ocl.pivot.IfExp)temp1_qvtrExpression;
					final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression2 = trace_77.getWmapOclExpression2();
					final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression2 != null;
					/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
					if (symbol_2) {
						if (wmapOclExpression2 == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression2.getD2qvtrExpression();
						objectManager.getting(d2qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
						final /*@Thrown*/ @Nullable Type type_2 = d2qvtrExpression.getType();
						final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression1 = trace_77.getWmapOclExpression1();
						final /*@NonInvalid*/ boolean symbol_3 = wmapOclExpression1 != null;
						/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression1;
						if (symbol_3) {
							if (wmapOclExpression1 == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression_0 = wmapOclExpression1.getD2qvtrExpression();
							objectManager.getting(d2qvtrExpression_0, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
							final /*@Thrown*/ @Nullable Type type_3 = d2qvtrExpression_0.getType();
							final /*@Thrown*/ @NonNull Type getCommonType = ((FUN_getCommonType)FTOR_getCommonType.getUniqueComputation(ATL2QVTr.this, type_2, type_3)).instance;
							// mapping statements
							symbol_1.setType(getCommonType);
							objectManager.assigned(symbol_1, PivotPackage.Literals.TYPED_ELEMENT__TYPE, getCommonType);
							final /*@Thrown*/ @Nullable Boolean mTmapIfExp__type_p6 = ValueUtil.TRUE_VALUE;
							raw_when_mapOclExpression1 = mTmapIfExp__type_p6;
						}
						else {
							raw_when_mapOclExpression1 = ValueUtil.FALSE_VALUE;
						}
						raw_when_mapOclExpression = raw_when_mapOclExpression1;
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
			return symbol_7;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(trace_77, thoseValues[0]);
		}
	}

	/**
	 *
	 * map mTmapNavigationOrAttributeCallExp__Property__referr_p4 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapNavigationOrAttributeCallExp_Property[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var qvtrExpression : PropertyCallExp[1] := dispatcher.d2qvtrExpression;
	 * var propertyName : String[1] := trace.t0propertyName;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrSource : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * var type : Type[?] := qvtrSource.type;
	 * var qvtrProperty : Property[1] := this.getProperty(type, propertyName);
	 * set qvtrExpression.referredProperty := qvtrProperty;
	 *
	 */
	protected boolean MAP_mTmapNavigationOrAttributeCallExp__Property__referr_p4(final /*@NonInvalid*/ @NonNull TmapNavigationOrAttributeCallExp_Property trace_78)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapNavigationOrAttributeCallExp__Property__referr_p4" + ", " + trace_78);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_78.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_6;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_78.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof PropertyCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull PropertyCallExp symbol_1 = (PropertyCallExp)temp1_qvtrExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String t0propertyName = trace_78.getT0propertyName();
				final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_78.getWmapOclExpression();
				final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
				if (symbol_2) {
					if (wmapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
					final /*@Thrown*/ @Nullable Type type_2 = d2qvtrExpression.getType();
					final /*@Thrown*/ @NonNull Property getProperty = ((FUN_getProperty)FTOR_getProperty.getUniqueComputation(this, type_2, t0propertyName)).instance;
					// mapping statements
					symbol_1.setReferredProperty(getProperty);
					final /*@Thrown*/ @Nullable Boolean mTmapNavigationOrAttributeCallExp__Property__referr_p4 = ValueUtil.TRUE_VALUE;
					raw_when_mapOclExpression = mTmapNavigationOrAttributeCallExp__Property__referr_p4;
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
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_6 ? "done "  : "fail ") + "MAP_mTmapNavigationOrAttributeCallExp__Property__referr_p4");
		}
		return symbol_6;
	}

	/**
	 *
	 * map mTmapOperationCallExp__Operation__referredOperation_p4 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapOperationCallExp_Operation[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * var operationName : String[1] := trace.t0operationName;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrSource : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * var type : Type[?] := qvtrSource.type;
	 * var qvtrOperation : Operation[1] := this.getOperation(type, operationName);
	 * set qvtrExpression.referredOperation := qvtrOperation;
	 *
	 */
	protected boolean MAP_mTmapOperationCallExp__Operation__referredOperation_p4(final /*@NonInvalid*/ @NonNull TmapOperationCallExp_Operation trace_79)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperationCallExp__Operation__referredOperation_p4" + ", " + trace_79);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_79.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_6;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_79.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String t0operationName = trace_79.getT0operationName();
				final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_79.getWmapOclExpression();
				final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
				if (symbol_2) {
					if (wmapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
					final /*@Thrown*/ @Nullable Type type_2 = d2qvtrExpression.getType();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Operation getOperation = ((FUN_getOperation)FTOR_getOperation.getUniqueComputation(this, type_2, t0operationName)).instance;
					// mapping statements
					symbol_1.setReferredOperation(getOperation);
					final /*@Thrown*/ @Nullable Boolean mTmapOperationCallExp__Operation__referredOperation_p4 = ValueUtil.TRUE_VALUE;
					raw_when_mapOclExpression = mTmapOperationCallExp__Operation__referredOperation_p4;
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
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_6 ? "done "  : "fail ") + "MAP_mTmapOperationCallExp__Operation__referredOperation_p4");
		}
		return symbol_6;
	}

	/**
	 *
	 * map mTmapOperatorCallExp__referredOperation_p4 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TmapOperatorCallExp[1];
	 * check trace.success;
	 * var dispatcher : trace_ATL2QVTr::DmapOclExpression[1] := trace.dispatcher;
	 * check var qvtrExpression : OperationCallExp[1] := dispatcher.d2qvtrExpression;
	 * var operationName : String[1] := trace.t0operationName;
	 * var when_mapOclExpression : trace_ATL2QVTr::DmapOclExpression[1] := trace.wmapOclExpression;
	 * var qvtrSource : OCLExpression[1] := when_mapOclExpression.d2qvtrExpression;
	 * var type : Type[?] := qvtrSource.type;
	 * var qvtrOperation : Operation[1] := this.getOperation(type, operationName);
	 * set qvtrExpression.referredOperation := qvtrOperation;
	 *
	 */
	protected boolean MAP_mTmapOperatorCallExp__referredOperation_p4(final /*@NonInvalid*/ @NonNull TmapOperatorCallExp trace_80)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_mTmapOperatorCallExp__referredOperation_p4" + ", " + trace_80);
		}
		final /*@NonInvalid*/ @Nullable Boolean success = trace_80.getSuccess();
		if (success == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_6;
		if (success) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull DmapOclExpression dispatcher_0 = trace_80.getDispatcher();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = dispatcher_0.getD2qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String t0operationName = trace_80.getT0operationName();
				final /*@NonInvalid*/ @Nullable DmapOclExpression wmapOclExpression = trace_80.getWmapOclExpression();
				final /*@NonInvalid*/ boolean symbol_2 = wmapOclExpression != null;
				/*@Thrown*/ @Nullable Boolean raw_when_mapOclExpression;
				if (symbol_2) {
					if (wmapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression d2qvtrExpression = wmapOclExpression.getD2qvtrExpression();
					final /*@Thrown*/ @Nullable Type type_2 = d2qvtrExpression.getType();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Operation getOperation = ((FUN_getOperation)FTOR_getOperation.getUniqueComputation(this, type_2, t0operationName)).instance;
					// mapping statements
					symbol_1.setReferredOperation(getOperation);
					final /*@Thrown*/ @Nullable Boolean mTmapOperatorCallExp__referredOperation_p4 = ValueUtil.TRUE_VALUE;
					raw_when_mapOclExpression = mTmapOperatorCallExp__referredOperation_p4;
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
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_6 ? "done "  : "fail ") + "MAP_mTmapOperatorCallExp__referredOperation_p4");
		}
		return symbol_6;
	}
}
