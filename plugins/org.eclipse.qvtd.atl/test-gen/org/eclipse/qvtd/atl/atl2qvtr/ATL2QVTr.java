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
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
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
import org.eclipse.ocl.pivot.library.collection.CollectionIsEmptyOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionNotEmptyOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapBinding;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapBooleanExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Context;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Operation;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapIfExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapInPattern;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapInPattern_filter;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapIntegerExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule_super;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapModule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Property;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOclMetamodel;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOclModel_IN;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOclModel_OUT;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperationCallExp_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperationCallExp_Operation;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperationCallExp_argument;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperatorCallExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOutPattern;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleOutPatternElement;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapStringExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable_VariableDeclaration;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapHelper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapHelper_Attribute;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapHelper_Operation;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperationCallExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WC_mapVariableExp_referredVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WI_mapVariableExp_referredVariable;
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
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbase", "qvtb", QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTrelation", "qvtr", QVTrelationPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTtemplate = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTtemplate", null, QVTtemplatePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd-example/org/eclipse/qvtd/atl/atl2qvtr/ATL2QVTr", "PATL2QVTr", trace_ATL2QVTrPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Attribute = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("Attribute", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Binding = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("Binding", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BooleanExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("BooleanExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BooleanLiteralExp = PACKid_$metamodel$.getClassId("BooleanLiteralExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
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
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_SimpleInPatternElement = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("SimpleInPatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_SimpleOutPatternElement = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_ATL.getClassId("SimpleOutPatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_StringExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("StringExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_StringLiteralExp = PACKid_$metamodel$.getClassId("StringLiteralExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapBinding = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapBinding", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapBooleanExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapBooleanExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapHelper_Attribute = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapHelper_Attribute", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapHelper_Context = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapHelper_Context", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapHelper_Operation = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapHelper_Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapIfExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapIfExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapInPattern = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapInPattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapInPattern_filter = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapInPattern_filter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapIntegerExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapIntegerExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapMatchedRule = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapMatchedRule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapMatchedRule_super = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapMatchedRule_super", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapModule = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapModule", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapNavigationOrAttributeCallExp_Helper = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapNavigationOrAttributeCallExp_Helper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapNavigationOrAttributeCallExp_Property = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapNavigationOrAttributeCallExp_Property", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapOclMetamodel = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapOclMetamodel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapOclModel_IN = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapOclModel_IN", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapOclModel_OUT = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapOclModel_OUT", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapOperationCallExp_Helper = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapOperationCallExp_Helper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapOperationCallExp_Operation = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapOperationCallExp_Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapOperationCallExp_argument = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapOperationCallExp_argument", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapOperatorCallExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapOperatorCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapOutPattern = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapOutPattern", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapSimpleInPatternElement = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapSimpleInPatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapSimpleOutPatternElement = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapSimpleOutPatternElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapStringExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapStringExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapVariable = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapVariableExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapVariableExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapVariableExp_referredVariable_Helper = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapVariableExp_referredVariable_Helper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TC_mapVariableExp_referredVariable_VariableDeclaration = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TC_mapVariableExp_referredVariable_VariableDeclaration", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TI_mapHelper = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TI_mapHelper", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TI_mapHelper_Attribute = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TI_mapHelper_Attribute", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TI_mapHelper_Operation = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TI_mapHelper_Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TI_mapOclExpression = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TI_mapOclExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TI_mapOperationCallExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("TI_mapOperationCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TemplateVariable = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTrelation.getClassId("TemplateVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Type = PACKid_$metamodel$.getClassId("Type", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TypedModel = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("TypedModel", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Variable = PACKid_$metamodel$.getClassId("Variable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableDeclaration = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("VariableDeclaration", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableDeclaration_0 = PACKid_$metamodel$.getClassId("VariableDeclaration", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableExp = PACKid_http_c_s_s_www_eclipse_org_s_gmt_s_2005_s_OCL.getClassId("VariableExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableExp_0 = PACKid_$metamodel$.getClassId("VariableExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_WC_mapVariableExp_referredVariable = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("WC_mapVariableExp_referredVariable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_WI_mapVariableExp_referredVariable = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_m_example_s_org_s_eclipse_s_qvtd_s_atl_s_atl2qvtr_s_ATL2QVTr.getClassId("WI_mapVariableExp_referredVariable", 0);
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_qvtd = PACKid_eclipse.getNestedPackageId("qvtd");
	public static final /*@NonInvalid*/ @NonNull String STR_ = "";
	public static final /*@NonInvalid*/ @NonNull String STR_self = "self";
	public static final /*@NonInvalid*/ @NonNull String STR_this = "this";
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_OclModelElement = TypeId.BAG.getSpecializedId(CLSSid_OclModelElement);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_OclType = TypeId.BAG.getSpecializedId(CLSSid_OclType);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Helper = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Helper);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_ModuleElement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ModuleElement);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_OclModel = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OclModel);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_OutPatternElement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OutPatternElement);
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_atl = PACKid_qvtd.getNestedPackageId("atl");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_atl_atlElement_0 = CLSSid_TC_mapSimpleOutPatternElement.getPropertyId("atl_atlElement");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_atl_atlExpression_5 = CLSSid_WI_mapVariableExp_referredVariable.getPropertyId("atl_atlExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_atl_atlExpression_6 = CLSSid_TI_mapOclExpression.getPropertyId("atl_atlExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_atl_atlHelper_0 = CLSSid_TI_mapHelper.getPropertyId("atl_atlHelper");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_atl_atlHelper_1 = CLSSid_TC_mapHelper_Context.getPropertyId("atl_atlHelper");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_atl_atlModule_9 = CLSSid_TC_mapModule.getPropertyId("atl_atlModule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_atl_atlPattern_2 = CLSSid_TC_mapInPattern.getPropertyId("atl_atlPattern");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_atl_atlPattern_3 = CLSSid_TC_mapOutPattern.getPropertyId("atl_atlPattern");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_atl_atlVariable_2 = CLSSid_TC_mapVariable.getPropertyId("atl_atlVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_atl_matchedRule = CLSSid_TC_mapMatchedRule.getPropertyId("atl_matchedRule");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_atl_oclMetamodel_1 = CLSSid_TC_mapOclMetamodel.getPropertyId("atl_oclMetamodel");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_definition = CLSSid_Helper.getPropertyId("definition");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_inModels = CLSSid_Module.getPropertyId("inModels");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_outModels = CLSSid_Module.getPropertyId("outModels");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Attribute = TypeId.SEQUENCE.getSpecializedId(CLSSid_Attribute);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_OclFeature = TypeId.SEQUENCE.getSpecializedId(CLSSid_OclFeature);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_OclFeatureDefinition = TypeId.SEQUENCE.getSpecializedId(CLSSid_OclFeatureDefinition);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_OclModelElement = TypeId.SEQUENCE.getSpecializedId(CLSSid_OclModelElement);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_OclType = TypeId.SEQUENCE.getSpecializedId(CLSSid_OclType);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Operation = TypeId.SEQUENCE.getSpecializedId(CLSSid_Operation);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_InPatternElement = TypeId.SET.getSpecializedId(CLSSid_InPatternElement);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_OclModel = TypeId.SET.getSpecializedId(CLSSid_OclModel);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Package = TypeId.SET.getSpecializedId(CLSSid_Package);
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_atl2qvtr = PACKid_atl.getNestedPackageId("atl2qvtr");
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ATL2QVTr = PACKid_atl2qvtr.getClassId("ATL2QVTr", 0);

	/*
	 * Property-source to Property-target unnavigable navigation caches
	 */
	protected final @NonNull Map<Helper,TC_mapHelper_Context> OPPOSITE_OF_TC_mapHelper_Context_atl_atlHelper = new HashMap<Helper,TC_mapHelper_Context>();
	protected final @NonNull Map<InPattern,TC_mapInPattern> OPPOSITE_OF_TC_mapInPattern_atl_atlPattern = new HashMap<InPattern,TC_mapInPattern>();
	protected final @NonNull Map<MatchedRule,TC_mapMatchedRule> OPPOSITE_OF_TC_mapMatchedRule_atl_matchedRule = new HashMap<MatchedRule,TC_mapMatchedRule>();
	protected final @NonNull Map<Module,TC_mapModule> OPPOSITE_OF_TC_mapModule_atl_atlModule = new HashMap<Module,TC_mapModule>();
	protected final @NonNull Map<OclModel,TC_mapOclMetamodel> OPPOSITE_OF_TC_mapOclMetamodel_atl_oclMetamodel = new HashMap<OclModel,TC_mapOclMetamodel>();
	protected final @NonNull Map<OutPattern,TC_mapOutPattern> OPPOSITE_OF_TC_mapOutPattern_atl_atlPattern = new HashMap<OutPattern,TC_mapOutPattern>();
	protected final @NonNull Map<SimpleOutPatternElement,TC_mapSimpleOutPatternElement> OPPOSITE_OF_TC_mapSimpleOutPatternElement_atl_atlElement = new HashMap<SimpleOutPatternElement,TC_mapSimpleOutPatternElement>();
	protected final @NonNull Map<LocatedElement,TC_mapVariable> OPPOSITE_OF_TC_mapVariable_atl_atlVariable = new HashMap<LocatedElement,TC_mapVariable>();
	protected final @NonNull Map<Helper,TI_mapHelper> OPPOSITE_OF_TI_mapHelper_atl_atlHelper = new HashMap<Helper,TI_mapHelper>();
	protected final @NonNull Map<OclExpression,TI_mapOclExpression> OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression = new HashMap<OclExpression,TI_mapOclExpression>();
	protected final @NonNull Map<org.eclipse.m2m.atl.common.OCL.VariableExp,WI_mapVariableExp_referredVariable> OPPOSITE_OF_WI_mapVariableExp_referredVariable_atl_atlExpression = new HashMap<org.eclipse.m2m.atl.common.OCL.VariableExp,WI_mapVariableExp_referredVariable>();

	/*
	 * Array of the source PropertyIds of each Property for which unnavigable opposite property navigation may occur.
	 */
	private static final @NonNull PropertyId @NonNull [] oppositeIndex2propertyId = new @NonNull PropertyId[]{
		PROPid_atl_atlModule_9,		// 0 => atl_atlModule
		PROPid_atl_matchedRule,		// 1 => atl_matchedRule
		PROPid_atl_oclMetamodel_1,		// 2 => atl_oclMetamodel
		PROPid_atl_atlPattern_2,		// 3 => atl_atlPattern
		PROPid_atl_atlPattern_3,		// 4 => atl_atlPattern
		PROPid_atl_atlExpression_6,		// 5 => atl_atlExpression
		PROPid_atl_atlHelper_1,		// 6 => atl_atlHelper
		PROPid_atl_atlHelper_0,		// 7 => atl_atlHelper
		PROPid_atl_atlExpression_5,		// 8 => atl_atlExpression
		PROPid_atl_atlVariable_2,		// 9 => atl_atlVariable
		PROPid_atl_atlElement_0		// 10 => atl_atlElement
	};

	/*
	 * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
	 */
	private static final @NonNull ClassId @NonNull [] classIndex2classId = new @NonNull ClassId[]{
		CLSSid_Binding,                       // 0 => Binding
		CLSSid_BooleanExp,                    // 1 => BooleanExp
		CLSSid_Helper,                        // 2 => Helper
		CLSSid_InPattern,                     // 3 => InPattern
		CLSSid_IntegerExp,                    // 4 => IntegerExp
		CLSSid_LocatedElement,                // 5 => LocatedElement
		CLSSid_MatchedRule,                   // 6 => MatchedRule
		CLSSid_Module,                        // 7 => Module
		CLSSid_NavigationOrAttributeCallExp,  // 8 => NavigationOrAttributeCallExp
		CLSSid_OclContextDefinition,          // 9 => OclContextDefinition
		CLSSid_OclExpression,                 // 10 => OclExpression
		CLSSid_OclModel,                      // 11 => OclModel
		CLSSid_OperationCallExp,              // 12 => OperationCallExp
		CLSSid_OperatorCallExp,               // 13 => OperatorCallExp
		CLSSid_OutPattern,                    // 14 => OutPattern
		CLSSid_SimpleInPatternElement,        // 15 => SimpleInPatternElement
		CLSSid_SimpleOutPatternElement,       // 16 => SimpleOutPatternElement
		CLSSid_StringExp,                     // 17 => StringExp
		CLSSid_VariableExp                    // 18 => VariableExp
	};

	/*
	 * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
	 * may contribute results to an allInstances() invocation.
	 * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
	 * instance of the derived classId contributes to derived and inherited ClassIndexes.
	 */
	private final static int @NonNull [] @NonNull [] classIndex2allClassIndexes = new int @NonNull [] @NonNull [] {
		{0,5},                        // 0 : Binding -> {Binding,LocatedElement}
		{1,5,10},                     // 1 : BooleanExp -> {BooleanExp,LocatedElement,OclExpression}
		{2,5},                        // 2 : Helper -> {Helper,LocatedElement}
		{3,5},                        // 3 : InPattern -> {InPattern,LocatedElement}
		{4,5,10},                     // 4 : IntegerExp -> {IntegerExp,LocatedElement,OclExpression}
		{5},                          // 5 : LocatedElement -> {LocatedElement}
		{6,5},                        // 6 : MatchedRule -> {MatchedRule,LocatedElement}
		{7,5},                        // 7 : Module -> {Module,LocatedElement}
		{8,5,10},                     // 8 : NavigationOrAttributeCallExp -> {NavigationOrAttributeCallExp,LocatedElement,OclExpression}
		{9,5},                        // 9 : OclContextDefinition -> {OclContextDefinition,LocatedElement}
		{10,5},                       // 10 : OclExpression -> {OclExpression,LocatedElement}
		{11,5},                       // 11 : OclModel -> {OclModel,LocatedElement}
		{12,5,10},                    // 12 : OperationCallExp -> {OperationCallExp,LocatedElement,OclExpression}
		{13,5,10,12},                 // 13 : OperatorCallExp -> {OperatorCallExp,LocatedElement,OclExpression,OperationCallExp}
		{14,5},                       // 14 : OutPattern -> {OutPattern,LocatedElement}
		{15,5},                       // 15 : SimpleInPatternElement -> {SimpleInPatternElement,LocatedElement}
		{16,5},                       // 16 : SimpleOutPatternElement -> {SimpleOutPatternElement,LocatedElement}
		{17,5,10},                    // 17 : StringExp -> {StringExp,LocatedElement,OclExpression}
		{18,5,10}                     // 18 : VariableExp -> {VariableExp,LocatedElement,OclExpression}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR___root__ = new AbstractInvocationConstructor(invocationManager, "__root__", false)
	{
		@Override
		public @NonNull MAP___root__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP___root__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_m_TC__mapNavigationOrAttributeCallExp__Property__typ_p5 = new AbstractInvocationConstructor(invocationManager, "m_TC__mapNavigationOrAttributeCallExp__Property__typ_p5", false)
	{
		@Override
		public @NonNull MAP_m_TC__mapNavigationOrAttributeCallExp__Property__typ_p5 newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_m_TC__mapNavigationOrAttributeCallExp__Property__typ_p5(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_m_TC__mapOperationCallExp__Operation__type_p5 = new AbstractInvocationConstructor(invocationManager, "m_TC__mapOperationCallExp__Operation__type_p5", false)
	{
		@Override
		public @NonNull MAP_m_TC__mapOperationCallExp__Operation__type_p5 newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_m_TC__mapOperationCallExp__Operation__type_p5(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_m_TC__mapOperatorCallExp__type_p5 = new AbstractInvocationConstructor(invocationManager, "m_TC__mapOperatorCallExp__type_p5", false)
	{
		@Override
		public @NonNull MAP_m_TC__mapOperatorCallExp__type_p5 newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_m_TC__mapOperatorCallExp__type_p5(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_m_TC__mapIfExp__type_p6 = new AbstractInvocationConstructor(invocationManager, "m_TC__mapIfExp__type_p6", false)
	{
		@Override
		public @NonNull MAP_m_TC__mapIfExp__type_p6 newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_m_TC__mapIfExp__type_p6(this, values);
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
		super(executor, new @NonNull String[] {"middle", "atl", "qvtr", "$primitive$"}, oppositeIndex2propertyId, classIndex2classId, classIndex2allClassIndexes);
	}

	@Override
	public boolean run() {
		final @NonNull Connection ji_Binding = models[1/*atl*/].getConnection(0/*ATL::Binding*/);
		final @NonNull Connection ji_BooleanExp = models[1/*atl*/].getConnection(1/*OCL::BooleanExp*/);
		final @NonNull Connection ji_Helper = models[1/*atl*/].getConnection(2/*ATL::Helper*/);
		final @NonNull Connection ji_InPattern = models[1/*atl*/].getConnection(3/*ATL::InPattern*/);
		final @NonNull Connection ji_IntegerExp = models[1/*atl*/].getConnection(4/*OCL::IntegerExp*/);
		final @NonNull Connection ji_LocatedElement = models[1/*atl*/].getConnection(5/*ATL::LocatedElement*/);
		final @NonNull Connection ji_MatchedRule = models[1/*atl*/].getConnection(6/*ATL::MatchedRule*/);
		final @NonNull Connection ji_Module = models[1/*atl*/].getConnection(7/*ATL::Module*/);
		final @NonNull Connection ji_NavigationOrAttributeCallExp = models[1/*atl*/].getConnection(8/*OCL::NavigationOrAttributeCallExp*/);
		final @NonNull Connection ji_OclContextDefinition = models[1/*atl*/].getConnection(9/*OCL::OclContextDefinition*/);
		final @NonNull Connection ji_OclExpression = models[1/*atl*/].getConnection(10/*OCL::OclExpression*/);
		final @NonNull Connection ji_OclModel = models[1/*atl*/].getConnection(11/*OCL::OclModel*/);
		final @NonNull Connection ji_OperationCallExp = models[1/*atl*/].getConnection(12/*OCL::OperationCallExp*/);
		final @NonNull Connection ji_OperatorCallExp = models[1/*atl*/].getConnection(13/*OCL::OperatorCallExp*/);
		final @NonNull Connection ji_OutPattern = models[1/*atl*/].getConnection(14/*ATL::OutPattern*/);
		final @NonNull Connection ji_SimpleInPatternElement = models[1/*atl*/].getConnection(15/*ATL::SimpleInPatternElement*/);
		final @NonNull Connection ji_SimpleOutPatternElement = models[1/*atl*/].getConnection(16/*ATL::SimpleOutPatternElement*/);
		final @NonNull Connection ji_StringExp = models[1/*atl*/].getConnection(17/*OCL::StringExp*/);
		final @NonNull Connection ji_VariableExp = models[1/*atl*/].getConnection(18/*OCL::VariableExp*/);
		CTOR___root__.invoke(ji_Binding, ji_BooleanExp, ji_Helper, ji_InPattern, ji_IntegerExp, ji_LocatedElement, ji_MatchedRule, ji_Module, ji_NavigationOrAttributeCallExp, ji_OclContextDefinition, ji_OclExpression, ji_OclModel, ji_OperationCallExp, ji_OperatorCallExp, ji_OutPattern, ji_SimpleInPatternElement, ji_SimpleOutPatternElement, ji_StringExp, ji_VariableExp);
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

		public FUN_getCommonType(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.type1 = (Type)boundValues[1];
			this.type2 = (Type)boundValues[2];
			this.instance = (Type)org.eclipse.qvtd.atl.atl2qvtr.Helper4getCommonType.INSTANCE.evaluate(executor, CLSSid_Type, type1, type2);
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
	 * ::getHelper(element : ATL::LocatedElement[?]) : ATL::Helper[?]
	 */
	protected class FUN_getHelper extends AbstractComputation
	{
		protected final @NonNull ATL2QVTr self;
		protected /*@NonInvalid*/ LocatedElement element;
		protected final /*@Thrown*/ @Nullable Helper instance;

		public FUN_getHelper(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.element = (LocatedElement)boundValues[1];
			this.instance = (Helper)org.eclipse.qvtd.atl.atl2qvtr.Helper4getHelper.INSTANCE.evaluate(executor, CLSSid_Helper, element);
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

		public FUN_getModule(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.element_0 = (LocatedElement)boundValues[1];
			this.instance = (Module)org.eclipse.qvtd.atl.atl2qvtr.Helper4getModule.INSTANCE.evaluate(executor, CLSSid_Module, element_0);
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

		public FUN_getOperation(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.type = (Type)boundValues[1];
			this.name = (String)boundValues[2];
			this.instance = (org.eclipse.ocl.pivot.Operation)org.eclipse.qvtd.atl.atl2qvtr.Helper4getOperation.INSTANCE.evaluate(executor, CLSSid_Operation_0, type, name);
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

		public FUN_getPackage(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.atlModule_0 = (Module)boundValues[1];
			this.name_0 = (String)boundValues[2];
			this.instance = (Package)org.eclipse.qvtd.atl.atl2qvtr.Helper4getPackage.INSTANCE.evaluate(executor, CLSSid_Package, atlModule_0, name_0);
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

		public FUN_getProperty(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.type_0 = (Type)boundValues[1];
			this.name_1 = (String)boundValues[2];
			this.instance = (Property)org.eclipse.qvtd.atl.atl2qvtr.Helper4getProperty.INSTANCE.evaluate(executor, CLSSid_Property, type_0, name_1);
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

		public FUN_getType(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (ATL2QVTr)boundValues[0];
			this.type_1 = (OclType)boundValues[1];
			this.instance = (Class)org.eclipse.qvtd.atl.atl2qvtr.Helper4getType.INSTANCE.evaluate(executor, CLSSid_Class, type_1);
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
	 * append ji_BooleanExp  : OCL::BooleanExp[1];
	 * append ji_Helper  : ATL::Helper[1];
	 * append ji_InPattern  : ATL::InPattern[1];
	 * append ji_IntegerExp  : OCL::IntegerExp[1];
	 * append ji_LocatedElement  : ATL::LocatedElement[1];
	 * append ji_MatchedRule  : ATL::MatchedRule[1];
	 * append ji_Module  : ATL::Module[1];
	 * append ji_NavigationOrAttributeCallExp  : OCL::NavigationOrAttributeCallExp[1];
	 * append ji_OclContextDefinition  : OCL::OclContextDefinition[1];
	 * append ji_OclExpression  : OCL::OclExpression[1];
	 * append ji_OclModel  : OCL::OclModel[1];
	 * append ji_OperationCallExp  : OCL::OperationCallExp[1];
	 * append ji_OperatorCallExp  : OCL::OperatorCallExp[1];
	 * append ji_OutPattern  : ATL::OutPattern[1];
	 * append ji_SimpleInPatternElement  : ATL::SimpleInPatternElement[1];
	 * append ji_SimpleOutPatternElement  : ATL::SimpleOutPatternElement[1];
	 * append ji_StringExp  : OCL::StringExp[1];
	 * append ji_VariableExp  : OCL::VariableExp[1];
	 * ::jm_TC__mapHelper__Attribute : trace_ATL2QVTr::TC_mapHelper_Attribute[1]::jm_TC__mapHelper__Attribute_1 : trace_ATL2QVTr::TC_mapHelper_Attribute[1]::jm_TC__mapHelper__Operation : trace_ATL2QVTr::TC_mapHelper_Operation[1]::jm_TC__mapHelper__Operation_1 : trace_ATL2QVTr::TC_mapHelper_Operation[1]::jm_TC__mapIfExp : trace_ATL2QVTr::TC_mapIfExp[1]::jm_TC__mapIfExp_1 : trace_ATL2QVTr::TC_mapIfExp[1]::jm_TC__mapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Helper[1]::jm_TC__mapNavigationOrAttributeCallExp__Helper_1 : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Helper[1]::jm_TC__mapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Property[1]::jm_TC__mapNavigationOrAttributeCallExp__Property_1 : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Property[1]::jm_TC__mapOperationCallExp__Helper : trace_ATL2QVTr::TC_mapOperationCallExp_Helper[1]::jm_TC__mapOperationCallExp__Helper_1 : trace_ATL2QVTr::TC_mapOperationCallExp_Helper[1]::jm_TC__mapOperationCallExp__Operation : trace_ATL2QVTr::TC_mapOperationCallExp_Operation[1]::jm_TC__mapOperationCallExp__Operation_1 : trace_ATL2QVTr::TC_mapOperationCallExp_Operation[1]::jm_TC__mapOperatorCallExp : trace_ATL2QVTr::TC_mapOperatorCallExp[1]::jm_TC__mapOperatorCallExp_1 : trace_ATL2QVTr::TC_mapOperatorCallExp[1]install m_TC__mapBooleanExp_atl_atlExpression_primitive_symb {
	 * atlExpression consumes append ji_BooleanExp  : OCL::BooleanExp[1];
	 * ;
	 * }
	 *   install m_Helper {
	 * atlHelper consumes append ji_Helper  : ATL::Helper[1];
	 * ;
	 * }
	 *   install m_TC__mapIntegerExp_atl_atlExpression_primitive_symb {
	 * atlExpression consumes append ji_IntegerExp  : OCL::IntegerExp[1];
	 * ;
	 * }
	 *   install m_TC__mapModule_atl_atlModule_primitive_txName_qvtr_ {
	 * atlModule consumes append ji_Module  : ATL::Module[1];
	 * ;
	 * }
	 *   install m_TC__mapMatchedRule_atl_atlModule_atl_matchedRule_p {
	 * matchedRule consumes append ji_MatchedRule  : ATL::MatchedRule[1];
	 * ;
	 * }
	 *   install m_TC__mapMatchedRule__super_atl_atlChildRule_atl_atl {
	 * atlChildRule consumes append ji_MatchedRule  : ATL::MatchedRule[1];
	 * ;
	 * }
	 *   install m_NavigationOrAttributeCallExp {
	 * atlExpression consumes append ji_NavigationOrAttributeCallExp  : OCL::NavigationOrAttributeCallExp[1];
	 * ;
	 * }
	 *   install m_OclExpression {
	 * atlExpression consumes append ji_OclExpression  : OCL::OclExpression[1];
	 * ;
	 * }
	 *   install m_TC__mapOclMetamodel_atl_oclMetamodel_primitive_tmN {
	 * oclMetamodel consumes append ji_OclModel  : OCL::OclModel[1];
	 * ;
	 * }
	 *   install m_TC__mapInPattern_atl_atlModel_atl_atlPattern_atl_a {
	 * atlPattern consumes append ji_InPattern  : ATL::InPattern[1];
	 * ;
	 * }
	 *   install m_TC__mapOclModel__IN_atl_atlModule_atl_oclMetamodel {
	 * oclModel consumes append ji_OclModel  : OCL::OclModel[1];
	 * ;
	 * }
	 *   install m_TC__mapOclModel__OUT_atl_atlModule_atl_oclMetamode {
	 * oclModel consumes append ji_OclModel  : OCL::OclModel[1];
	 * ;
	 * }
	 *   install m_OperationCallExp {
	 * atlExpression consumes append ji_OperationCallExp  : OCL::OperationCallExp[1];
	 * ;
	 * }
	 *   install m_TC__mapOutPattern_atl_atlPattern_atl_atlRule_qvtr_ {
	 * atlPattern consumes append ji_OutPattern  : ATL::OutPattern[1];
	 * ;
	 * }
	 *   install m_TC__mapSimpleInPatternElement_atl_atlElement_atl_a {
	 * atlElement consumes append ji_SimpleInPatternElement  : ATL::SimpleInPatternElement[1];
	 * ;
	 * }
	 *   install m_TC__mapSimpleOutPatternElement_atl_atlElement_atl_ {
	 * atlElement consumes append ji_SimpleOutPatternElement  : ATL::SimpleOutPatternElement[1];
	 * ;
	 * }
	 *   install m_TC__mapStringExp_atl_atlExpression_primitive_symbo {
	 * atlExpression consumes append ji_StringExp  : OCL::StringExp[1];
	 * ;
	 * }
	 *   install m_TC__mapVariableExp_atl_atlExpression_atl_atlVariab {
	 * atlExpression consumes append ji_VariableExp  : OCL::VariableExp[1];
	 * ;
	 * }
	 *   install m_VariableExp {
	 * atlExpression consumes append ji_VariableExp  : OCL::VariableExp[1];
	 * ;
	 * }
	 *   install m_LocatedElement {
	 * atlVariable consumes append ji_LocatedElement  : ATL::LocatedElement[1];
	 * ;
	 * }
	 *   install m_TC__mapHelper__Attribute_atl_atlDefinition_atl_atl_p0 {
	 * atlExpression consumes append ji_OclExpression  : OCL::OclExpression[1];
	 * ;
	 * jm_TC__mapHelper__Attribute_1 appendsTo jm_TC__mapHelper__Attribute_1;
	 * }
	 *   install m_TC__mapHelper__Operation_atl_atlDefinition_atl_atl_p0 {
	 * atlExpression consumes append ji_OclExpression  : OCL::OclExpression[1];
	 * ;
	 * jm_TC__mapHelper__Operation_1 appendsTo jm_TC__mapHelper__Operation_1;
	 * }
	 *   install m_TC__mapIfExp_atl_atlCondition_atl_atlElse_atl_atlE_p0 {
	 * atlCondition consumes append ji_OclExpression  : OCL::OclExpression[1];
	 * ;
	 * jm_TC__mapIfExp_1 appendsTo jm_TC__mapIfExp_1;
	 * }
	 *   install m_TC__mapNavigationOrAttributeCallExp__Helper_atl_at_p0 {
	 * atlExpression consumes append ji_NavigationOrAttributeCallExp  : OCL::NavigationOrAttributeCallExp[1];
	 * ;
	 * jm_TC__mapNavigationOrAttributeCallExp__Helper_1 appendsTo jm_TC__mapNavigationOrAttributeCallExp__Helper_1;
	 * }
	 *   install m_TC__mapNavigationOrAttributeCallExp__Property_atl__p0 {
	 * atlExpression consumes append ji_NavigationOrAttributeCallExp  : OCL::NavigationOrAttributeCallExp[1];
	 * ;
	 * jm_TC__mapNavigationOrAttributeCallExp__Property_1 appendsTo jm_TC__mapNavigationOrAttributeCallExp__Property_1;
	 * }
	 *   install m_TC__mapOperationCallExp__Helper_atl_atlExpression__p0 {
	 * atlExpression consumes append ji_OperationCallExp  : OCL::OperationCallExp[1];
	 * ;
	 * jm_TC__mapOperationCallExp__Helper_1 appendsTo jm_TC__mapOperationCallExp__Helper_1;
	 * }
	 *   install m_TC__mapOperationCallExp__Operation_atl_atlExpressi_p0 {
	 * atlExpression consumes append ji_OperationCallExp  : OCL::OperationCallExp[1];
	 * ;
	 * jm_TC__mapOperationCallExp__Operation_1 appendsTo jm_TC__mapOperationCallExp__Operation_1;
	 * }
	 *   install m_TC__mapOperatorCallExp_atl_atlExpression_atl_atlSo_p0 {
	 * atlExpression consumes append ji_OperatorCallExp  : OCL::OperatorCallExp[1];
	 * ;
	 * jm_TC__mapOperatorCallExp_1 appendsTo jm_TC__mapOperatorCallExp_1;
	 * }
	 *   install m_TC__mapHelper__Attribute_invocation_mapHelper_Cont_p1 {
	 * jm_TC__mapHelper__Attribute appendsTo jm_TC__mapHelper__Attribute;
	 * trace consumes ::jm_TC__mapHelper__Attribute_1 : trace_ATL2QVTr::TC_mapHelper_Attribute[1];
	 * }
	 *   install m_TC__mapHelper__Attribute_qvtr_qvtrFunction_p2 {
	 * trace consumes ::jm_TC__mapHelper__Attribute : trace_ATL2QVTr::TC_mapHelper_Attribute[1];
	 * }
	 *   install m_TC__mapHelper__Operation_invocation_mapHelper_Cont_p1 {
	 * jm_TC__mapHelper__Operation appendsTo jm_TC__mapHelper__Operation;
	 * trace consumes ::jm_TC__mapHelper__Operation_1 : trace_ATL2QVTr::TC_mapHelper_Operation[1];
	 * }
	 *   install m_TC__mapHelper__Operation_qvtr_qvtrFunction_p2 {
	 * trace consumes ::jm_TC__mapHelper__Operation : trace_ATL2QVTr::TC_mapHelper_Operation[1];
	 * }
	 *   install m_TC__mapHelper__Attribute__TC_mapHelper_Context_qvt_p4 {
	 * trace consumes ::jm_TC__mapHelper__Attribute : trace_ATL2QVTr::TC_mapHelper_Attribute[1];
	 * }
	 *   install m_TC__mapHelper__Operation__TC_mapHelper_Context_qvt_p4 {
	 * trace consumes ::jm_TC__mapHelper__Operation : trace_ATL2QVTr::TC_mapHelper_Operation[1];
	 * }
	 *   install m_TC__mapHelper__Context_atl_atlContext_atl_atlDefin {
	 * atlContext consumes append ji_OclContextDefinition  : OCL::OclContextDefinition[1];
	 * ;
	 * }
	 *   install m_TC__mapIfExp_status_p1 {
	 * jm_TC__mapIfExp appendsTo jm_TC__mapIfExp;
	 * trace consumes ::jm_TC__mapIfExp_1 : trace_ATL2QVTr::TC_mapIfExp[1];
	 * }
	 *   install m_TC__mapIfExp_qvtr_qvtrExpression_p2 {
	 * trace consumes ::jm_TC__mapIfExp : trace_ATL2QVTr::TC_mapIfExp[1];
	 * }
	 *   install m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p1 {
	 * jm_TC__mapNavigationOrAttributeCallExp__Helper appendsTo jm_TC__mapNavigationOrAttributeCallExp__Helper;
	 * trace consumes ::jm_TC__mapNavigationOrAttributeCallExp__Helper_1 : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p2 {
	 * trace consumes ::jm_TC__mapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install m_TC__mapNavigationOrAttributeCallExp__Property_stat_p1 {
	 * jm_TC__mapNavigationOrAttributeCallExp__Property appendsTo jm_TC__mapNavigationOrAttributeCallExp__Property;
	 * trace consumes ::jm_TC__mapNavigationOrAttributeCallExp__Property_1 : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Property[1];
	 * }
	 *   install m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p2 {
	 * trace consumes ::jm_TC__mapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Property[1];
	 * }
	 *   install m_TC__mapOperationCallExp__Helper_qvtr_qvtrOperation_p1 {
	 * jm_TC__mapOperationCallExp__Helper appendsTo jm_TC__mapOperationCallExp__Helper;
	 * trace consumes ::jm_TC__mapOperationCallExp__Helper_1 : trace_ATL2QVTr::TC_mapOperationCallExp_Helper[1];
	 * }
	 *   install m_WI__mapVariableExp__referredVariable_result {
	 * atlExpression consumes append ji_VariableExp  : OCL::VariableExp[1];
	 * ;
	 * }
	 *   install m_WI__mapVariableExp__referredVariable_result_1 {
	 * atlExpression consumes append ji_VariableExp  : OCL::VariableExp[1];
	 * ;
	 * }
	 *   install m_TC__mapOperationCallExp__Helper_qvtr_qvtrExpressio_p2 {
	 * trace consumes ::jm_TC__mapOperationCallExp__Helper : trace_ATL2QVTr::TC_mapOperationCallExp_Helper[1];
	 * }
	 *   install m_TC__mapOperationCallExp__Operation_status_p1 {
	 * jm_TC__mapOperationCallExp__Operation appendsTo jm_TC__mapOperationCallExp__Operation;
	 * trace consumes ::jm_TC__mapOperationCallExp__Operation_1 : trace_ATL2QVTr::TC_mapOperationCallExp_Operation[1];
	 * }
	 *   install m_TC__mapOperationCallExp__Operation_qvtr_qvtrExpres_p2 {
	 * trace consumes ::jm_TC__mapOperationCallExp__Operation : trace_ATL2QVTr::TC_mapOperationCallExp_Operation[1];
	 * }
	 *   install m_TC__mapOperatorCallExp_atl_atlModule_status_p1 {
	 * jm_TC__mapOperatorCallExp appendsTo jm_TC__mapOperatorCallExp;
	 * trace consumes ::jm_TC__mapOperatorCallExp_1 : trace_ATL2QVTr::TC_mapOperatorCallExp[1];
	 * }
	 *   install m_TC__mapOperatorCallExp_qvtr_qvtrTransformation_p6 {
	 * trace consumes ::jm_TC__mapOperatorCallExp : trace_ATL2QVTr::TC_mapOperatorCallExp[1];
	 * }
	 *   install m_TC__mapOperatorCallExp_qvtr_qvtrExpression_p2 {
	 * trace consumes ::jm_TC__mapOperatorCallExp : trace_ATL2QVTr::TC_mapOperatorCallExp[1];
	 * }
	 *   install m_TC__mapBinding_atl_atlBinding_atl_atlExpression_at {
	 * atlBinding consumes append ji_Binding  : ATL::Binding[1];
	 * ;
	 * }
	 *   install m_TC__mapInPattern__filter_atl_atlExpression_atl_atl {
	 * atlPattern consumes append ji_InPattern  : ATL::InPattern[1];
	 * ;
	 * }
	 *   install m_TC__mapOperationCallExp__argument_atl_atlArgument_ {
	 * atlArgument consumes append ji_OclExpression  : OCL::OclExpression[1];
	 * ;
	 * }
	 *   install m_TC__mapHelper__Attribute_qvtr_qvtrExpression_p3 {
	 * trace consumes ::jm_TC__mapHelper__Attribute : trace_ATL2QVTr::TC_mapHelper_Attribute[1];
	 * }
	 *   install m_TC__mapHelper__Operation_qvtr_qvtrExpression_p3 {
	 * trace consumes ::jm_TC__mapHelper__Operation : trace_ATL2QVTr::TC_mapHelper_Operation[1];
	 * }
	 *   install m_TC__mapIfExp_qvtr_qvtrCondition_p3 {
	 * trace consumes ::jm_TC__mapIfExp : trace_ATL2QVTr::TC_mapIfExp[1];
	 * }
	 *   install m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p3 {
	 * trace consumes ::jm_TC__mapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p3 {
	 * trace consumes ::jm_TC__mapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Property[1];
	 * }
	 *   install m_TC__mapOperationCallExp__Helper_qvtr_qvtrSourceArg_p3 {
	 * trace consumes ::jm_TC__mapOperationCallExp__Helper : trace_ATL2QVTr::TC_mapOperationCallExp_Helper[1];
	 * }
	 *   install m_TC__mapOperationCallExp__Operation_qvtr_qvtrSource_p3 {
	 * trace consumes ::jm_TC__mapOperationCallExp__Operation : trace_ATL2QVTr::TC_mapOperationCallExp_Operation[1];
	 * }
	 *   install m_TC__mapOperatorCallExp_qvtr_qvtrSource_p3 {
	 * trace consumes ::jm_TC__mapOperatorCallExp : trace_ATL2QVTr::TC_mapOperatorCallExp[1];
	 * }
	 *   install m_TC__mapIfExp_qvtr_qvtrElse_p4 {
	 * trace consumes ::jm_TC__mapIfExp : trace_ATL2QVTr::TC_mapIfExp[1];
	 * }
	 *   install m_TC__mapNavigationOrAttributeCallExp__Helper__CallE_p4 {
	 * trace consumes ::jm_TC__mapNavigationOrAttributeCallExp__Helper : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Helper[1];
	 * }
	 *   install m_TC__mapOperationCallExp__Helper__CallExp_ownedSour_p4 {
	 * trace consumes ::jm_TC__mapOperationCallExp__Helper : trace_ATL2QVTr::TC_mapOperationCallExp_Helper[1];
	 * }
	 *   install m_TC__mapIfExp_qvtr_qvtrThen_p5 {
	 * trace consumes ::jm_TC__mapIfExp : trace_ATL2QVTr::TC_mapIfExp[1];
	 * }
	 *   install m_TC__mapNavigationOrAttributeCallExp__Property__typ_p5 {
	 * trace consumes ::jm_TC__mapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Property[1];
	 * }
	 *   install m_TC__mapOperationCallExp__Operation__type_p5 {
	 * trace consumes ::jm_TC__mapOperationCallExp__Operation : trace_ATL2QVTr::TC_mapOperationCallExp_Operation[1];
	 * }
	 *   install m_TC__mapOperatorCallExp__type_p5 {
	 * trace consumes ::jm_TC__mapOperatorCallExp : trace_ATL2QVTr::TC_mapOperatorCallExp[1];
	 * }
	 *   install m_TC__mapIfExp__type_p6 {
	 * trace consumes ::jm_TC__mapIfExp : trace_ATL2QVTr::TC_mapIfExp[1];
	 * }
	 *   install m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p4 {
	 * trace consumes ::jm_TC__mapNavigationOrAttributeCallExp__Property : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Property[1];
	 * }
	 *   install m_TC__mapOperationCallExp__Operation_qvtr_qvtrOperat_p4 {
	 * trace consumes ::jm_TC__mapOperationCallExp__Operation : trace_ATL2QVTr::TC_mapOperationCallExp_Operation[1];
	 * }
	 *   install m_TC__mapOperatorCallExp_qvtr_qvtrOperation_p4 {
	 * trace consumes ::jm_TC__mapOperatorCallExp : trace_ATL2QVTr::TC_mapOperatorCallExp[1];
	 * }
	 */
	protected class MAP___root__ extends AbstractInvocation
	{
		protected final @NonNull Connection ji_Binding;
		protected final @NonNull Connection ji_BooleanExp;
		protected final @NonNull Connection ji_Helper;
		protected final @NonNull Connection ji_InPattern;
		protected final @NonNull Connection ji_IntegerExp;
		protected final @NonNull Connection ji_LocatedElement;
		protected final @NonNull Connection ji_MatchedRule;
		protected final @NonNull Connection ji_Module;
		protected final @NonNull Connection ji_NavigationOrAttributeCallExp;
		protected final @NonNull Connection ji_OclContextDefinition;
		protected final @NonNull Connection ji_OclExpression;
		protected final @NonNull Connection ji_OclModel;
		protected final @NonNull Connection ji_OperationCallExp;
		protected final @NonNull Connection ji_OperatorCallExp;
		protected final @NonNull Connection ji_OutPattern;
		protected final @NonNull Connection ji_SimpleInPatternElement;
		protected final @NonNull Connection ji_SimpleOutPatternElement;
		protected final @NonNull Connection ji_StringExp;
		protected final @NonNull Connection ji_VariableExp;

		public MAP___root__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			ji_Binding = (Connection)boundValues[0];
			ji_BooleanExp = (Connection)boundValues[1];
			ji_Helper = (Connection)boundValues[2];
			ji_InPattern = (Connection)boundValues[3];
			ji_IntegerExp = (Connection)boundValues[4];
			ji_LocatedElement = (Connection)boundValues[5];
			ji_MatchedRule = (Connection)boundValues[6];
			ji_Module = (Connection)boundValues[7];
			ji_NavigationOrAttributeCallExp = (Connection)boundValues[8];
			ji_OclContextDefinition = (Connection)boundValues[9];
			ji_OclExpression = (Connection)boundValues[10];
			ji_OclModel = (Connection)boundValues[11];
			ji_OperationCallExp = (Connection)boundValues[12];
			ji_OperatorCallExp = (Connection)boundValues[13];
			ji_OutPattern = (Connection)boundValues[14];
			ji_SimpleInPatternElement = (Connection)boundValues[15];
			ji_SimpleOutPatternElement = (Connection)boundValues[16];
			ji_StringExp = (Connection)boundValues[17];
			ji_VariableExp = (Connection)boundValues[18];
		}

		@Override
		public boolean execute()  {
			// connection variables
			final @NonNull Connection jm_TC__mapHelper__Attribute_2 = createConnection("jm_TC__mapHelper__Attribute", CLSSid_TC_mapHelper_Attribute, false);
			final @NonNull Connection jm_TC__mapHelper__Attribute_1_1 = createConnection("jm_TC__mapHelper__Attribute_1", CLSSid_TC_mapHelper_Attribute, false);
			final @NonNull Connection jm_TC__mapHelper__Operation_2 = createConnection("jm_TC__mapHelper__Operation", CLSSid_TC_mapHelper_Operation, false);
			final @NonNull Connection jm_TC__mapHelper__Operation_1_1 = createConnection("jm_TC__mapHelper__Operation_1", CLSSid_TC_mapHelper_Operation, false);
			final @NonNull Connection jm_TC__mapIfExp_2 = createConnection("jm_TC__mapIfExp", CLSSid_TC_mapIfExp, false);
			final @NonNull Connection jm_TC__mapIfExp_1_1 = createConnection("jm_TC__mapIfExp_1", CLSSid_TC_mapIfExp, false);
			final @NonNull Connection jm_TC__mapNavigationOrAttributeCallExp__Helper_2 = createConnection("jm_TC__mapNavigationOrAttributeCallExp__Helper", CLSSid_TC_mapNavigationOrAttributeCallExp_Helper, false);
			final @NonNull Connection jm_TC__mapNavigationOrAttributeCallExp__Helper_1_1 = createConnection("jm_TC__mapNavigationOrAttributeCallExp__Helper_1", CLSSid_TC_mapNavigationOrAttributeCallExp_Helper, false);
			final @NonNull Connection jm_TC__mapNavigationOrAttributeCallExp__Property_2 = createConnection("jm_TC__mapNavigationOrAttributeCallExp__Property", CLSSid_TC_mapNavigationOrAttributeCallExp_Property, false);
			final @NonNull Connection jm_TC__mapNavigationOrAttributeCallExp__Property_1_1 = createConnection("jm_TC__mapNavigationOrAttributeCallExp__Property_1", CLSSid_TC_mapNavigationOrAttributeCallExp_Property, false);
			final @NonNull Connection jm_TC__mapOperationCallExp__Helper_2 = createConnection("jm_TC__mapOperationCallExp__Helper", CLSSid_TC_mapOperationCallExp_Helper, false);
			final @NonNull Connection jm_TC__mapOperationCallExp__Helper_1_1 = createConnection("jm_TC__mapOperationCallExp__Helper_1", CLSSid_TC_mapOperationCallExp_Helper, false);
			final @NonNull Connection jm_TC__mapOperationCallExp__Operation_2 = createConnection("jm_TC__mapOperationCallExp__Operation", CLSSid_TC_mapOperationCallExp_Operation, false);
			final @NonNull Connection jm_TC__mapOperationCallExp__Operation_1_1 = createConnection("jm_TC__mapOperationCallExp__Operation_1", CLSSid_TC_mapOperationCallExp_Operation, false);
			final @NonNull Connection jm_TC__mapOperatorCallExp_2 = createConnection("jm_TC__mapOperatorCallExp", CLSSid_TC_mapOperatorCallExp, false);
			final @NonNull Connection jm_TC__mapOperatorCallExp_1_1 = createConnection("jm_TC__mapOperatorCallExp_1", CLSSid_TC_mapOperatorCallExp, false);
			// mapping statements
			for (@NonNull BooleanExp atlExpression_16 : ji_BooleanExp.typedIterable(BooleanExp.class)) {
				MAP_m_TC__mapBooleanExp_atl_atlExpression_primitive_symb(atlExpression_16);
			}
			for (@NonNull Helper atlHelper_0 : ji_Helper.typedIterable(Helper.class)) {
				MAP_m_Helper(atlHelper_0);
			}
			for (@NonNull IntegerExp atlExpression_17 : ji_IntegerExp.typedIterable(IntegerExp.class)) {
				MAP_m_TC__mapIntegerExp_atl_atlExpression_primitive_symb(atlExpression_17);
			}
			for (@NonNull Module atlModule_1 : ji_Module.typedIterable(Module.class)) {
				MAP_m_TC__mapModule_atl_atlModule_primitive_txName_qvtr_(atlModule_1);
			}
			for (@NonNull MatchedRule matchedRule_0 : ji_MatchedRule.typedIterable(MatchedRule.class)) {
				MAP_m_TC__mapMatchedRule_atl_atlModule_atl_matchedRule_p(matchedRule_0);
			}
			for (@NonNull MatchedRule atlChildRule_0 : ji_MatchedRule.typedIterable(MatchedRule.class)) {
				MAP_m_TC__mapMatchedRule__super_atl_atlChildRule_atl_atl(atlChildRule_0);
			}
			for (@NonNull NavigationOrAttributeCallExp atlExpression_18 : ji_NavigationOrAttributeCallExp.typedIterable(NavigationOrAttributeCallExp.class)) {
				MAP_m_NavigationOrAttributeCallExp(atlExpression_18);
			}
			for (@NonNull OclExpression atlExpression_19 : ji_OclExpression.typedIterable(OclExpression.class)) {
				MAP_m_OclExpression(atlExpression_19);
			}
			for (@NonNull OclModel oclMetamodel_0 : ji_OclModel.typedIterable(OclModel.class)) {
				MAP_m_TC__mapOclMetamodel_atl_oclMetamodel_primitive_tmN(oclMetamodel_0);
			}
			for (@NonNull InPattern atlPattern_2 : ji_InPattern.typedIterable(InPattern.class)) {
				MAP_m_TC__mapInPattern_atl_atlModel_atl_atlPattern_atl_a(atlPattern_2);
			}
			for (@NonNull OclModel oclModel_1 : ji_OclModel.typedIterable(OclModel.class)) {
				MAP_m_TC__mapOclModel__IN_atl_atlModule_atl_oclMetamodel(oclModel_1);
			}
			for (@NonNull OclModel oclModel_2 : ji_OclModel.typedIterable(OclModel.class)) {
				MAP_m_TC__mapOclModel__OUT_atl_atlModule_atl_oclMetamode(oclModel_2);
			}
			for (org.eclipse.m2m.atl.common.OCL.@NonNull OperationCallExp atlExpression_20 : ji_OperationCallExp.typedIterable(org.eclipse.m2m.atl.common.OCL.OperationCallExp.class)) {
				MAP_m_OperationCallExp(atlExpression_20);
			}
			for (@NonNull OutPattern atlPattern_3 : ji_OutPattern.typedIterable(OutPattern.class)) {
				MAP_m_TC__mapOutPattern_atl_atlPattern_atl_atlRule_qvtr_(atlPattern_3);
			}
			for (@NonNull SimpleInPatternElement atlElement_1 : ji_SimpleInPatternElement.typedIterable(SimpleInPatternElement.class)) {
				MAP_m_TC__mapSimpleInPatternElement_atl_atlElement_atl_a(atlElement_1);
			}
			for (@NonNull SimpleOutPatternElement atlElement_2 : ji_SimpleOutPatternElement.typedIterable(SimpleOutPatternElement.class)) {
				MAP_m_TC__mapSimpleOutPatternElement_atl_atlElement_atl_(atlElement_2);
			}
			for (@NonNull StringExp atlExpression_21 : ji_StringExp.typedIterable(StringExp.class)) {
				MAP_m_TC__mapStringExp_atl_atlExpression_primitive_symbo(atlExpression_21);
			}
			for (org.eclipse.m2m.atl.common.OCL.@NonNull VariableExp atlExpression_22 : ji_VariableExp.typedIterable(org.eclipse.m2m.atl.common.OCL.VariableExp.class)) {
				MAP_m_TC__mapVariableExp_atl_atlExpression_atl_atlVariab(atlExpression_22);
			}
			for (org.eclipse.m2m.atl.common.OCL.@NonNull VariableExp atlExpression_23 : ji_VariableExp.typedIterable(org.eclipse.m2m.atl.common.OCL.VariableExp.class)) {
				MAP_m_VariableExp(atlExpression_23);
			}
			for (@NonNull LocatedElement atlVariable_0 : ji_LocatedElement.typedIterable(LocatedElement.class)) {
				MAP_m_LocatedElement(atlVariable_0);
			}
			for (@NonNull OclExpression atlExpression_24 : ji_OclExpression.typedIterable(OclExpression.class)) {
				MAP_m_TC__mapHelper__Attribute_atl_atlDefinition_atl_atl_p0(atlExpression_24, jm_TC__mapHelper__Attribute_1_1);
			}
			for (@NonNull OclExpression atlExpression_25 : ji_OclExpression.typedIterable(OclExpression.class)) {
				MAP_m_TC__mapHelper__Operation_atl_atlDefinition_atl_atl_p0(atlExpression_25, jm_TC__mapHelper__Operation_1_1);
			}
			for (@NonNull OclExpression atlCondition_0 : ji_OclExpression.typedIterable(OclExpression.class)) {
				MAP_m_TC__mapIfExp_atl_atlCondition_atl_atlElse_atl_atlE_p0(atlCondition_0, jm_TC__mapIfExp_1_1);
			}
			for (@NonNull NavigationOrAttributeCallExp atlExpression_26 : ji_NavigationOrAttributeCallExp.typedIterable(NavigationOrAttributeCallExp.class)) {
				MAP_m_TC__mapNavigationOrAttributeCallExp__Helper_atl_at_p0(atlExpression_26, jm_TC__mapNavigationOrAttributeCallExp__Helper_1_1);
			}
			for (@NonNull NavigationOrAttributeCallExp atlExpression_27 : ji_NavigationOrAttributeCallExp.typedIterable(NavigationOrAttributeCallExp.class)) {
				MAP_m_TC__mapNavigationOrAttributeCallExp__Property_atl__p0(atlExpression_27, jm_TC__mapNavigationOrAttributeCallExp__Property_1_1);
			}
			for (org.eclipse.m2m.atl.common.OCL.@NonNull OperationCallExp atlExpression_28 : ji_OperationCallExp.typedIterable(org.eclipse.m2m.atl.common.OCL.OperationCallExp.class)) {
				MAP_m_TC__mapOperationCallExp__Helper_atl_atlExpression__p0(atlExpression_28, jm_TC__mapOperationCallExp__Helper_1_1);
			}
			for (org.eclipse.m2m.atl.common.OCL.@NonNull OperationCallExp atlExpression_29 : ji_OperationCallExp.typedIterable(org.eclipse.m2m.atl.common.OCL.OperationCallExp.class)) {
				MAP_m_TC__mapOperationCallExp__Operation_atl_atlExpressi_p0(atlExpression_29, jm_TC__mapOperationCallExp__Operation_1_1);
			}
			for (@NonNull OperatorCallExp atlExpression_30 : ji_OperatorCallExp.typedIterable(OperatorCallExp.class)) {
				MAP_m_TC__mapOperatorCallExp_atl_atlExpression_atl_atlSo_p0(atlExpression_30, jm_TC__mapOperatorCallExp_1_1);
			}
			for (@NonNull TC_mapHelper_Attribute trace_37 : jm_TC__mapHelper__Attribute_1_1.typedIterable(TC_mapHelper_Attribute.class)) {
				MAP_m_TC__mapHelper__Attribute_invocation_mapHelper_Cont_p1(jm_TC__mapHelper__Attribute_2, trace_37);
			}
			for (@NonNull TC_mapHelper_Attribute trace_38 : jm_TC__mapHelper__Attribute_2.typedIterable(TC_mapHelper_Attribute.class)) {
				MAP_m_TC__mapHelper__Attribute_qvtr_qvtrFunction_p2(trace_38);
			}
			for (@NonNull TC_mapHelper_Operation trace_39 : jm_TC__mapHelper__Operation_1_1.typedIterable(TC_mapHelper_Operation.class)) {
				MAP_m_TC__mapHelper__Operation_invocation_mapHelper_Cont_p1(jm_TC__mapHelper__Operation_2, trace_39);
			}
			for (@NonNull TC_mapHelper_Operation trace_40 : jm_TC__mapHelper__Operation_2.typedIterable(TC_mapHelper_Operation.class)) {
				MAP_m_TC__mapHelper__Operation_qvtr_qvtrFunction_p2(trace_40);
			}
			for (@NonNull TC_mapHelper_Attribute trace_41 : jm_TC__mapHelper__Attribute_2.typedIterable(TC_mapHelper_Attribute.class)) {
				MAP_m_TC__mapHelper__Attribute__TC_mapHelper_Context_qvt_p4(trace_41);
			}
			for (@NonNull TC_mapHelper_Operation trace_42 : jm_TC__mapHelper__Operation_2.typedIterable(TC_mapHelper_Operation.class)) {
				MAP_m_TC__mapHelper__Operation__TC_mapHelper_Context_qvt_p4(trace_42);
			}
			for (@NonNull OclContextDefinition atlContext_0 : ji_OclContextDefinition.typedIterable(OclContextDefinition.class)) {
				MAP_m_TC__mapHelper__Context_atl_atlContext_atl_atlDefin(atlContext_0);
			}
			for (@NonNull TC_mapIfExp trace_43 : jm_TC__mapIfExp_1_1.typedIterable(TC_mapIfExp.class)) {
				MAP_m_TC__mapIfExp_status_p1(jm_TC__mapIfExp_2, trace_43);
			}
			for (@NonNull TC_mapIfExp trace_44 : jm_TC__mapIfExp_2.typedIterable(TC_mapIfExp.class)) {
				MAP_m_TC__mapIfExp_qvtr_qvtrExpression_p2(trace_44);
			}
			for (@NonNull TC_mapNavigationOrAttributeCallExp_Helper trace_45 : jm_TC__mapNavigationOrAttributeCallExp__Helper_1_1.typedIterable(TC_mapNavigationOrAttributeCallExp_Helper.class)) {
				MAP_m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p1(jm_TC__mapNavigationOrAttributeCallExp__Helper_2, trace_45);
			}
			for (@NonNull TC_mapNavigationOrAttributeCallExp_Helper trace_46 : jm_TC__mapNavigationOrAttributeCallExp__Helper_2.typedIterable(TC_mapNavigationOrAttributeCallExp_Helper.class)) {
				MAP_m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p2(trace_46);
			}
			for (@NonNull TC_mapNavigationOrAttributeCallExp_Property trace_47 : jm_TC__mapNavigationOrAttributeCallExp__Property_1_1.typedIterable(TC_mapNavigationOrAttributeCallExp_Property.class)) {
				MAP_m_TC__mapNavigationOrAttributeCallExp__Property_stat_p1(jm_TC__mapNavigationOrAttributeCallExp__Property_2, trace_47);
			}
			for (@NonNull TC_mapNavigationOrAttributeCallExp_Property trace_48 : jm_TC__mapNavigationOrAttributeCallExp__Property_2.typedIterable(TC_mapNavigationOrAttributeCallExp_Property.class)) {
				MAP_m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p2(trace_48);
			}
			for (@NonNull TC_mapOperationCallExp_Helper trace_49 : jm_TC__mapOperationCallExp__Helper_1_1.typedIterable(TC_mapOperationCallExp_Helper.class)) {
				MAP_m_TC__mapOperationCallExp__Helper_qvtr_qvtrOperation_p1(jm_TC__mapOperationCallExp__Helper_2, trace_49);
			}
			for (org.eclipse.m2m.atl.common.OCL.@NonNull VariableExp atlExpression_31 : ji_VariableExp.typedIterable(org.eclipse.m2m.atl.common.OCL.VariableExp.class)) {
				MAP_m_WI__mapVariableExp__referredVariable_result(atlExpression_31);
			}
			for (org.eclipse.m2m.atl.common.OCL.@NonNull VariableExp atlExpression_32 : ji_VariableExp.typedIterable(org.eclipse.m2m.atl.common.OCL.VariableExp.class)) {
				MAP_m_WI__mapVariableExp__referredVariable_result_1(atlExpression_32);
			}
			for (@NonNull TC_mapOperationCallExp_Helper trace_50 : jm_TC__mapOperationCallExp__Helper_2.typedIterable(TC_mapOperationCallExp_Helper.class)) {
				MAP_m_TC__mapOperationCallExp__Helper_qvtr_qvtrExpressio_p2(trace_50);
			}
			for (@NonNull TC_mapOperationCallExp_Operation trace_51 : jm_TC__mapOperationCallExp__Operation_1_1.typedIterable(TC_mapOperationCallExp_Operation.class)) {
				MAP_m_TC__mapOperationCallExp__Operation_status_p1(jm_TC__mapOperationCallExp__Operation_2, trace_51);
			}
			for (@NonNull TC_mapOperationCallExp_Operation trace_52 : jm_TC__mapOperationCallExp__Operation_2.typedIterable(TC_mapOperationCallExp_Operation.class)) {
				MAP_m_TC__mapOperationCallExp__Operation_qvtr_qvtrExpres_p2(trace_52);
			}
			for (@NonNull TC_mapOperatorCallExp trace_53 : jm_TC__mapOperatorCallExp_1_1.typedIterable(TC_mapOperatorCallExp.class)) {
				MAP_m_TC__mapOperatorCallExp_atl_atlModule_status_p1(jm_TC__mapOperatorCallExp_2, trace_53);
			}
			for (@NonNull TC_mapOperatorCallExp trace_54 : jm_TC__mapOperatorCallExp_2.typedIterable(TC_mapOperatorCallExp.class)) {
				MAP_m_TC__mapOperatorCallExp_qvtr_qvtrTransformation_p6(trace_54);
			}
			for (@NonNull TC_mapOperatorCallExp trace_55 : jm_TC__mapOperatorCallExp_2.typedIterable(TC_mapOperatorCallExp.class)) {
				MAP_m_TC__mapOperatorCallExp_qvtr_qvtrExpression_p2(trace_55);
			}
			for (@NonNull Binding atlBinding_0 : ji_Binding.typedIterable(Binding.class)) {
				MAP_m_TC__mapBinding_atl_atlBinding_atl_atlExpression_at(atlBinding_0);
			}
			for (@NonNull InPattern atlPattern_4 : ji_InPattern.typedIterable(InPattern.class)) {
				MAP_m_TC__mapInPattern__filter_atl_atlExpression_atl_atl(atlPattern_4);
			}
			for (@NonNull OclExpression atlArgument_0 : ji_OclExpression.typedIterable(OclExpression.class)) {
				MAP_m_TC__mapOperationCallExp__argument_atl_atlArgument_(atlArgument_0);
			}
			for (@NonNull TC_mapHelper_Attribute trace_56 : jm_TC__mapHelper__Attribute_2.typedIterable(TC_mapHelper_Attribute.class)) {
				MAP_m_TC__mapHelper__Attribute_qvtr_qvtrExpression_p3(trace_56);
			}
			for (@NonNull TC_mapHelper_Operation trace_57 : jm_TC__mapHelper__Operation_2.typedIterable(TC_mapHelper_Operation.class)) {
				MAP_m_TC__mapHelper__Operation_qvtr_qvtrExpression_p3(trace_57);
			}
			for (@NonNull TC_mapIfExp trace_58 : jm_TC__mapIfExp_2.typedIterable(TC_mapIfExp.class)) {
				MAP_m_TC__mapIfExp_qvtr_qvtrCondition_p3(trace_58);
			}
			for (@NonNull TC_mapNavigationOrAttributeCallExp_Helper trace_59 : jm_TC__mapNavigationOrAttributeCallExp__Helper_2.typedIterable(TC_mapNavigationOrAttributeCallExp_Helper.class)) {
				MAP_m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p3(trace_59);
			}
			for (@NonNull TC_mapNavigationOrAttributeCallExp_Property trace_60 : jm_TC__mapNavigationOrAttributeCallExp__Property_2.typedIterable(TC_mapNavigationOrAttributeCallExp_Property.class)) {
				MAP_m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p3(trace_60);
			}
			for (@NonNull TC_mapOperationCallExp_Helper trace_61 : jm_TC__mapOperationCallExp__Helper_2.typedIterable(TC_mapOperationCallExp_Helper.class)) {
				MAP_m_TC__mapOperationCallExp__Helper_qvtr_qvtrSourceArg_p3(trace_61);
			}
			for (@NonNull TC_mapOperationCallExp_Operation trace_62 : jm_TC__mapOperationCallExp__Operation_2.typedIterable(TC_mapOperationCallExp_Operation.class)) {
				MAP_m_TC__mapOperationCallExp__Operation_qvtr_qvtrSource_p3(trace_62);
			}
			for (@NonNull TC_mapOperatorCallExp trace_63 : jm_TC__mapOperatorCallExp_2.typedIterable(TC_mapOperatorCallExp.class)) {
				MAP_m_TC__mapOperatorCallExp_qvtr_qvtrSource_p3(trace_63);
			}
			for (@NonNull TC_mapIfExp trace_64 : jm_TC__mapIfExp_2.typedIterable(TC_mapIfExp.class)) {
				MAP_m_TC__mapIfExp_qvtr_qvtrElse_p4(trace_64);
			}
			for (@NonNull TC_mapNavigationOrAttributeCallExp_Helper trace_65 : jm_TC__mapNavigationOrAttributeCallExp__Helper_2.typedIterable(TC_mapNavigationOrAttributeCallExp_Helper.class)) {
				MAP_m_TC__mapNavigationOrAttributeCallExp__Helper__CallE_p4(trace_65);
			}
			for (@NonNull TC_mapOperationCallExp_Helper trace_66 : jm_TC__mapOperationCallExp__Helper_2.typedIterable(TC_mapOperationCallExp_Helper.class)) {
				MAP_m_TC__mapOperationCallExp__Helper__CallExp_ownedSour_p4(trace_66);
			}
			for (@NonNull TC_mapIfExp trace_67 : jm_TC__mapIfExp_2.typedIterable(TC_mapIfExp.class)) {
				MAP_m_TC__mapIfExp_qvtr_qvtrThen_p5(trace_67);
			}
			invocationManager.flush();
			CTOR_m_TC__mapNavigationOrAttributeCallExp__Property__typ_p5.addConsumedConnection(jm_TC__mapNavigationOrAttributeCallExp__Property_2);
			invocationManager.flush();
			invocationManager.flush();
			CTOR_m_TC__mapOperationCallExp__Operation__type_p5.addConsumedConnection(jm_TC__mapOperationCallExp__Operation_2);
			invocationManager.flush();
			invocationManager.flush();
			CTOR_m_TC__mapOperatorCallExp__type_p5.addConsumedConnection(jm_TC__mapOperatorCallExp_2);
			invocationManager.flush();
			invocationManager.flush();
			CTOR_m_TC__mapIfExp__type_p6.addConsumedConnection(jm_TC__mapIfExp_2);
			invocationManager.flush();
			for (@NonNull TC_mapNavigationOrAttributeCallExp_Property trace_72 : jm_TC__mapNavigationOrAttributeCallExp__Property_2.typedIterable(TC_mapNavigationOrAttributeCallExp_Property.class)) {
				MAP_m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p4(trace_72);
			}
			for (@NonNull TC_mapOperationCallExp_Operation trace_73 : jm_TC__mapOperationCallExp__Operation_2.typedIterable(TC_mapOperationCallExp_Operation.class)) {
				MAP_m_TC__mapOperationCallExp__Operation_qvtr_qvtrOperat_p4(trace_73);
			}
			for (@NonNull TC_mapOperatorCallExp trace_74 : jm_TC__mapOperatorCallExp_2.typedIterable(TC_mapOperatorCallExp.class)) {
				MAP_m_TC__mapOperatorCallExp_qvtr_qvtrOperation_p4(trace_74);
			}
			final /*@Thrown*/ @Nullable Boolean __root__ = ValueUtil.TRUE_VALUE;
			return __root__;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(ji_Binding, thoseValues[0])
				&& idResolver.oclEquals(ji_BooleanExp, thoseValues[1])
				&& idResolver.oclEquals(ji_Helper, thoseValues[2])
				&& idResolver.oclEquals(ji_InPattern, thoseValues[3])
				&& idResolver.oclEquals(ji_IntegerExp, thoseValues[4])
				&& idResolver.oclEquals(ji_LocatedElement, thoseValues[5])
				&& idResolver.oclEquals(ji_MatchedRule, thoseValues[6])
				&& idResolver.oclEquals(ji_Module, thoseValues[7])
				&& idResolver.oclEquals(ji_NavigationOrAttributeCallExp, thoseValues[8])
				&& idResolver.oclEquals(ji_OclContextDefinition, thoseValues[9])
				&& idResolver.oclEquals(ji_OclExpression, thoseValues[10])
				&& idResolver.oclEquals(ji_OclModel, thoseValues[11])
				&& idResolver.oclEquals(ji_OperationCallExp, thoseValues[12])
				&& idResolver.oclEquals(ji_OperatorCallExp, thoseValues[13])
				&& idResolver.oclEquals(ji_OutPattern, thoseValues[14])
				&& idResolver.oclEquals(ji_SimpleInPatternElement, thoseValues[15])
				&& idResolver.oclEquals(ji_SimpleOutPatternElement, thoseValues[16])
				&& idResolver.oclEquals(ji_StringExp, thoseValues[17])
				&& idResolver.oclEquals(ji_VariableExp, thoseValues[18]);
		}
	}

	/**
	 *
	 * map m_TC__mapBooleanExp_atl_atlExpression_primitive_symb in ATL2QVTr {
	 * guard:atl atlExpression : OCL::BooleanExp[1];
	 * var symbol : Boolean[1] := atlExpression.booleanSymbol;
	 * var Boolean1 : Class[1] := PrimitiveTypes::Boolean;
	 * new:qvtr qvtrExpression : BooleanLiteralExp[1];
	 * new:middle trace : trace_ATL2QVTr::TC_mapBooleanExp[1];
	 * set qvtrExpression.booleanSymbol := symbol;
	 * set trace.primitive_symbol := symbol;
	 * set trace.atl_atlExpression := atlExpression;
	 * set trace.qvtr_qvtrExpression := qvtrExpression;
	 * notify set qvtrExpression.type := Boolean1;
	 *
	 */
	protected boolean MAP_m_TC__mapBooleanExp_atl_atlExpression_primitive_symb(final /*@NonInvalid*/ @NonNull BooleanExp atlExpression)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapBooleanExp_atl_atlExpression_primitive_symb" + ", " + atlExpression);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ boolean booleanSymbol = atlExpression.isBooleanSymbol();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_Boolean_0 = idResolver.getClass(TypeId.BOOLEAN, null);
		// creations
		final @NonNull BooleanLiteralExp qvtrExpression = PivotFactory.eINSTANCE.createBooleanLiteralExp();
		models[2/*qvtr*/].add(qvtrExpression, false);
		final @SuppressWarnings("null")@NonNull TC_mapBooleanExp trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapBooleanExp();
		models[0/*middle*/].add(trace_37, false);
		// mapping statements
		qvtrExpression.setBooleanSymbol(booleanSymbol);
		trace_37.setPrimitive_symbol(booleanSymbol);
		OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.put(atlExpression, trace_37);
		trace_37.setAtl_atlExpression(atlExpression);
		trace_37.setQvtr_qvtrExpression(qvtrExpression);
		qvtrExpression.setType(TYP_Boolean_0);
		objectManager.assigned(qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, TYP_Boolean_0);
		final /*@Thrown*/ @Nullable Boolean m_TC__mapBooleanExp_atl_atlExpression_primitive_symb = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((m_TC__mapBooleanExp_atl_atlExpression_primitive_symb ? "done "  : "fail ") + "MAP_m_TC__mapBooleanExp_atl_atlExpression_primitive_symb");
		}
		return m_TC__mapBooleanExp_atl_atlExpression_primitive_symb;
	}

	/**
	 * map m_Helper in ATL2QVTr {
	 * guard:atl atlHelper : ATL::Helper[1];
	 * check false;
	 *
	 */
	protected boolean MAP_m_Helper(final /*@NonInvalid*/ @NonNull Helper atlHelper)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_Helper" + ", " + atlHelper);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((ValueUtil.FALSE_VALUE ? "done "  : "fail ") + "MAP_m_Helper");
		}
		return ValueUtil.FALSE_VALUE;
	}

	/**
	 *
	 * map m_TC__mapIntegerExp_atl_atlExpression_primitive_symb in ATL2QVTr {
	 * guard:atl atlExpression : OCL::IntegerExp[1];
	 * var symbol : Integer[1] := atlExpression.integerSymbol;
	 * var Integer1 : Class[1] := PrimitiveTypes::Integer;
	 * new:qvtr qvtrExpression : IntegerLiteralExp[1];
	 * new:middle trace : trace_ATL2QVTr::TC_mapIntegerExp[1];
	 * set qvtrExpression.integerSymbol := symbol;
	 * set trace.primitive_symbol := symbol;
	 * notify set qvtrExpression.type := Integer1;
	 * set trace.atl_atlExpression := atlExpression;
	 * set trace.qvtr_qvtrExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_m_TC__mapIntegerExp_atl_atlExpression_primitive_symb(final /*@NonInvalid*/ @NonNull IntegerExp atlExpression_0)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapIntegerExp_atl_atlExpression_primitive_symb" + ", " + atlExpression_0);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ int integerSymbol = atlExpression_0.getIntegerSymbol();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_Integer_0 = idResolver.getClass(TypeId.INTEGER, null);
		// creations
		final @NonNull IntegerLiteralExp qvtrExpression = PivotFactory.eINSTANCE.createIntegerLiteralExp();
		models[2/*qvtr*/].add(qvtrExpression, false);
		final @SuppressWarnings("null")@NonNull TC_mapIntegerExp trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapIntegerExp();
		models[0/*middle*/].add(trace_37, false);
		// mapping statements
		qvtrExpression.setIntegerSymbol(integerSymbol);
		trace_37.setPrimitive_symbol(ValueUtil.bigIntegerValueOf(integerSymbol));
		qvtrExpression.setType(TYP_Integer_0);
		objectManager.assigned(qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, TYP_Integer_0);
		OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.put(atlExpression_0, trace_37);
		trace_37.setAtl_atlExpression(atlExpression_0);
		trace_37.setQvtr_qvtrExpression(qvtrExpression);
		final /*@Thrown*/ @Nullable Boolean m_TC__mapIntegerExp_atl_atlExpression_primitive_symb = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((m_TC__mapIntegerExp_atl_atlExpression_primitive_symb ? "done "  : "fail ") + "MAP_m_TC__mapIntegerExp_atl_atlExpression_primitive_symb");
		}
		return m_TC__mapIntegerExp_atl_atlExpression_primitive_symb;
	}

	/**
	 *
	 * map m_TC__mapModule_atl_atlModule_primitive_txName_qvtr_ in ATL2QVTr {
	 * guard:atl atlModule : ATL::Module[1];
	 * var txName : String[1] := atlModule.name;
	 * contained new:qvtr _3 : Package[1];
	 * new:qvtr _4 : qvtrelation::RelationModel[1];
	 * contained new:qvtr _5 : ParameterVariable[1];
	 * contained new:qvtr qvtrTransformation : qvtrelation::RelationalTransformation[1];
	 * new:middle trace : trace_ATL2QVTr::TC_mapModule[1];
	 * set _3.name := '';
	 * set _5.isRequired := true;
	 * set _5.name := 'this';
	 * set qvtrTransformation.name := txName;
	 * set trace.primitive_txName := txName;
	 * set _4.ownedPackages := _3;
	 * set trace.atl_atlModule := atlModule;
	 * set trace.qvtr__3 := _3;
	 * set trace.qvtr__4 := _4;
	 * set trace.qvtr__5 := _5;
	 * set trace.qvtr_qvtrTransformation := qvtrTransformation;
	 * set qvtrTransformation.ownedContext := _5;
	 * set qvtrTransformation.owningPackage := _3;
	 * set _5.type := qvtrTransformation;
	 *
	 */
	protected boolean MAP_m_TC__mapModule_atl_atlModule_primitive_txName_qvtr_(final /*@NonInvalid*/ @NonNull Module atlModule)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapModule_atl_atlModule_primitive_txName_qvtr_" + ", " + atlModule);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String name_2 = atlModule.getName();
		// creations
		final @SuppressWarnings("null")org.eclipse.ocl.pivot.@NonNull Package _3 = PivotFactory.eINSTANCE.createPackage();
		models[2/*qvtr*/].add(_3, true);
		final @NonNull RelationModel _4 = QVTrelationFactory.eINSTANCE.createRelationModel();
		models[2/*qvtr*/].add(_4, false);
		final @NonNull ParameterVariable _5 = PivotFactory.eINSTANCE.createParameterVariable();
		models[2/*qvtr*/].add(_5, true);
		final @NonNull RelationalTransformation qvtrTransformation = QVTrelationFactory.eINSTANCE.createRelationalTransformation();
		models[2/*qvtr*/].add(qvtrTransformation, true);
		final @SuppressWarnings("null")@NonNull TC_mapModule trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapModule();
		models[0/*middle*/].add(trace_37, false);
		// mapping statements
		_3.setName(STR_);
		_5.setIsRequired(ValueUtil.TRUE_VALUE);
		_5.setName(STR_this);
		qvtrTransformation.setName(name_2);
		trace_37.setPrimitive_txName(name_2);
		_4.getOwnedPackages().add(_3);
		OPPOSITE_OF_TC_mapModule_atl_atlModule.put(atlModule, trace_37);
		trace_37.setAtl_atlModule(atlModule);
		trace_37.setQvtr__3(_3);
		trace_37.setQvtr__4(_4);
		trace_37.setQvtr__5(_5);
		trace_37.setQvtr_qvtrTransformation(qvtrTransformation);
		qvtrTransformation.setOwnedContext(_5);
		qvtrTransformation.setOwningPackage(_3);
		_5.setType(qvtrTransformation);
		final /*@Thrown*/ @Nullable Boolean m_TC__mapModule_atl_atlModule_primitive_txName_qvtr_ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((m_TC__mapModule_atl_atlModule_primitive_txName_qvtr_ ? "done "  : "fail ") + "MAP_m_TC__mapModule_atl_atlModule_primitive_txName_qvtr_");
		}
		return m_TC__mapModule_atl_atlModule_primitive_txName_qvtr_;
	}

	/**
	 *
	 * map m_TC__mapMatchedRule_atl_atlModule_atl_matchedRule_p in ATL2QVTr {
	 * guard:atl matchedRule : ATL::MatchedRule[1];
	 * var isAbstract : Boolean[1] := matchedRule.isAbstract;
	 * var atlModule : ATL::Module[1] := matchedRule.module;
	 * var ruleName : String[1] := matchedRule.name;
	 * var when_TC_mapModule : trace_ATL2QVTr::TC_mapModule[1] := atlModule.TC_mapModule;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_TC_mapModule.qvtr_qvtrTransformation;
	 * contained new:qvtr qvtrRelation : qvtrelation::Relation[1];
	 * new:middle trace : trace_ATL2QVTr::TC_mapMatchedRule[1];
	 * set qvtrRelation.isAbstract := isAbstract;
	 * set qvtrRelation.isTopLevel := true;
	 * set qvtrRelation.name := ruleName;
	 * set trace.primitive_ruleName := ruleName;
	 * set qvtrRelation.transformation := qvtrTransformation;
	 * set trace.atl_atlModule := atlModule;
	 * set trace.atl_matchedRule := matchedRule;
	 * set trace.qvtr_qvtrRelation := qvtrRelation;
	 * set trace.qvtr_qvtrTransformation := qvtrTransformation;
	 *
	 */
	protected boolean MAP_m_TC__mapMatchedRule_atl_atlModule_atl_matchedRule_p(final /*@NonInvalid*/ @NonNull MatchedRule matchedRule)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapMatchedRule_atl_atlModule_atl_matchedRule_p" + ", " + matchedRule);
		}
		final /*@NonInvalid*/ boolean isAbstract = matchedRule.isIsAbstract();
		final /*@NonInvalid*/ @Nullable Module module = matchedRule.getModule();
		final /*@NonInvalid*/ boolean symbol_0 = module != null;
		/*@Thrown*/ @Nullable Boolean raw_atlModule;
		if (symbol_0) {
			if (module == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name_2 = matchedRule.getName();
			final /*@Thrown*/ @Nullable TC_mapModule TC_mapModule = OPPOSITE_OF_TC_mapModule_atl_atlModule.get(module);
			final /*@Thrown*/ boolean symbol_1 = TC_mapModule != null;
			/*@Thrown*/ @Nullable Boolean raw_when_TC_mapModule;
			if (symbol_1) {
				if (TC_mapModule == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull RelationalTransformation qvtr_qvtrTransformation = TC_mapModule.getQvtr_qvtrTransformation();
				// creations
				final @NonNull Relation qvtrRelation = QVTrelationFactory.eINSTANCE.createRelation();
				models[2/*qvtr*/].add(qvtrRelation, true);
				final @SuppressWarnings("null")@NonNull TC_mapMatchedRule trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapMatchedRule();
				models[0/*middle*/].add(trace_37, false);
				// mapping statements
				qvtrRelation.setIsAbstract(isAbstract);
				qvtrRelation.setIsTopLevel(ValueUtil.TRUE_VALUE);
				qvtrRelation.setName(name_2);
				trace_37.setPrimitive_ruleName(name_2);
				qvtrRelation.setTransformation(qvtr_qvtrTransformation);
				trace_37.setAtl_atlModule(module);
				OPPOSITE_OF_TC_mapMatchedRule_atl_matchedRule.put(matchedRule, trace_37);
				trace_37.setAtl_matchedRule(matchedRule);
				trace_37.setQvtr_qvtrRelation(qvtrRelation);
				trace_37.setQvtr_qvtrTransformation(qvtr_qvtrTransformation);
				final /*@Thrown*/ @Nullable Boolean m_TC__mapMatchedRule_atl_atlModule_atl_matchedRule_p = ValueUtil.TRUE_VALUE;
				raw_when_TC_mapModule = m_TC__mapMatchedRule_atl_atlModule_atl_matchedRule_p;
			}
			else {
				raw_when_TC_mapModule = ValueUtil.FALSE_VALUE;
			}
			raw_atlModule = raw_when_TC_mapModule;
		}
		else {
			raw_atlModule = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_atlModule ? "done "  : "fail ") + "MAP_m_TC__mapMatchedRule_atl_atlModule_atl_matchedRule_p");
		}
		return raw_atlModule;
	}

	/**
	 *
	 * map m_TC__mapMatchedRule__super_atl_atlChildRule_atl_atl in ATL2QVTr {
	 * guard:atl atlChildRule : ATL::MatchedRule[1];
	 * var atlSuperRule : ATL::MatchedRule[1] := atlChildRule.superRule;
	 * var when_TC_mapMatchedRule_0 : trace_ATL2QVTr::TC_mapMatchedRule[1] := atlChildRule.TC_mapMatchedRule;
	 * var when_TC_mapMatchedRule : trace_ATL2QVTr::TC_mapMatchedRule[1] := atlSuperRule.TC_mapMatchedRule;
	 * var qvtrOverridesRelation : qvtrelation::Relation[1] := when_TC_mapMatchedRule_0.qvtr_qvtrRelation;
	 * var qvtrOverriddenRelation : qvtrelation::Relation[1] := when_TC_mapMatchedRule.qvtr_qvtrRelation;
	 * new:middle trace : trace_ATL2QVTr::TC_mapMatchedRule_super[1];
	 * set qvtrOverridesRelation.overrides := qvtrOverriddenRelation;
	 * set trace.atl_atlChildRule := atlChildRule;
	 * set trace.atl_atlSuperRule := atlSuperRule;
	 * set trace.qvtr_qvtrOverriddenRelation := qvtrOverriddenRelation;
	 * set trace.qvtr_qvtrOverridesRelation := qvtrOverridesRelation;
	 *
	 */
	protected boolean MAP_m_TC__mapMatchedRule__super_atl_atlChildRule_atl_atl(final /*@NonInvalid*/ @NonNull MatchedRule atlChildRule)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapMatchedRule__super_atl_atlChildRule_atl_atl" + ", " + atlChildRule);
		}
		final /*@NonInvalid*/ @Nullable MatchedRule superRule = atlChildRule.getSuperRule();
		final /*@NonInvalid*/ boolean symbol_0 = superRule != null;
		/*@Thrown*/ @Nullable Boolean raw_atlSuperRule;
		if (symbol_0) {
			if (superRule == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@NonInvalid*/ @Nullable TC_mapMatchedRule TC_mapMatchedRule = OPPOSITE_OF_TC_mapMatchedRule_atl_matchedRule.get(atlChildRule);
			final /*@NonInvalid*/ boolean symbol_1 = TC_mapMatchedRule != null;
			/*@Thrown*/ @Nullable Boolean raw_when_TC_mapMatchedRule_0;
			if (symbol_1) {
				if (TC_mapMatchedRule == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@Thrown*/ @Nullable TC_mapMatchedRule TC_mapMatchedRule_0 = OPPOSITE_OF_TC_mapMatchedRule_atl_matchedRule.get(superRule);
				final /*@Thrown*/ boolean symbol_2 = TC_mapMatchedRule_0 != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TC_mapMatchedRule;
				if (symbol_2) {
					if (TC_mapMatchedRule_0 == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull Relation qvtr_qvtrRelation = TC_mapMatchedRule.getQvtr_qvtrRelation();
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull Relation qvtr_qvtrRelation_0 = TC_mapMatchedRule_0.getQvtr_qvtrRelation();
					// creations
					final @SuppressWarnings("null")@NonNull TC_mapMatchedRule_super trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapMatchedRule_super();
					models[0/*middle*/].add(trace_37, false);
					// mapping statements
					qvtr_qvtrRelation.getOverrides().add(qvtr_qvtrRelation_0);
					trace_37.setAtl_atlChildRule(atlChildRule);
					trace_37.setAtl_atlSuperRule(superRule);
					trace_37.setQvtr_qvtrOverriddenRelation(qvtr_qvtrRelation_0);
					trace_37.setQvtr_qvtrOverridesRelation(qvtr_qvtrRelation);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapMatchedRule__super_atl_atlChildRule_atl_atl = ValueUtil.TRUE_VALUE;
					raw_when_TC_mapMatchedRule = m_TC__mapMatchedRule__super_atl_atlChildRule_atl_atl;
				}
				else {
					raw_when_TC_mapMatchedRule = ValueUtil.FALSE_VALUE;
				}
				raw_when_TC_mapMatchedRule_0 = raw_when_TC_mapMatchedRule;
			}
			else {
				raw_when_TC_mapMatchedRule_0 = ValueUtil.FALSE_VALUE;
			}
			raw_atlSuperRule = raw_when_TC_mapMatchedRule_0;
		}
		else {
			raw_atlSuperRule = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_atlSuperRule ? "done "  : "fail ") + "MAP_m_TC__mapMatchedRule__super_atl_atlChildRule_atl_atl");
		}
		return raw_atlSuperRule;
	}

	/**
	 *
	 * map m_NavigationOrAttributeCallExp in ATL2QVTr {
	 * guard:atl atlExpression : OCL::NavigationOrAttributeCallExp[1];
	 * check false;
	 *
	 */
	protected boolean MAP_m_NavigationOrAttributeCallExp(final /*@NonInvalid*/ @NonNull NavigationOrAttributeCallExp atlExpression_1)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_NavigationOrAttributeCallExp" + ", " + atlExpression_1);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((ValueUtil.FALSE_VALUE ? "done "  : "fail ") + "MAP_m_NavigationOrAttributeCallExp");
		}
		return ValueUtil.FALSE_VALUE;
	}

	/**
	 *
	 * map m_OclExpression in ATL2QVTr {
	 * guard:atl atlExpression : OCL::OclExpression[1];
	 * check false;
	 *
	 */
	protected boolean MAP_m_OclExpression(final /*@NonInvalid*/ @NonNull OclExpression atlExpression_2)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_OclExpression" + ", " + atlExpression_2);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((ValueUtil.FALSE_VALUE ? "done "  : "fail ") + "MAP_m_OclExpression");
		}
		return ValueUtil.FALSE_VALUE;
	}

	/**
	 *
	 * map m_TC__mapOclMetamodel_atl_oclMetamodel_primitive_tmN in ATL2QVTr {
	 *
	 *   guard:atl oclMetamodel : OCL::OclModel[1];
	 * var model : Set(OCL::OclModel) := oclMetamodel.model;
	 * var notEmpty : Boolean[1] := model->notEmpty();
	 * check notEmpty;
	 * var tmName : String[1] := oclMetamodel.name;
	 * new:qvtr qvtrTypedModel : qvtbase::TypedModel[1];
	 * new:middle trace : trace_ATL2QVTr::TC_mapOclMetamodel[1];
	 * set qvtrTypedModel.name := tmName;
	 * set trace.primitive_tmName := tmName;
	 * set trace.atl_oclMetamodel := oclMetamodel;
	 * set trace.qvtr_qvtrTypedModel := qvtrTypedModel;
	 *
	 */
	protected boolean MAP_m_TC__mapOclMetamodel_atl_oclMetamodel_primitive_tmN(final /*@NonInvalid*/ @NonNull OclModel oclMetamodel)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOclMetamodel_atl_oclMetamodel_primitive_tmN" + ", " + oclMetamodel);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull List<OclModel> model = oclMetamodel.getModel();
		final /*@NonInvalid*/ @NonNull SetValue BOXED_model = idResolver.createSetOfAll(SET_CLSSid_OclModel, model);
		final /*@NonInvalid*/ boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(BOXED_model).booleanValue();
		/*@Thrown*/ @Nullable Boolean symbol_5;
		if (notEmpty) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name_2 = oclMetamodel.getName();
			// creations
			final @NonNull TypedModel qvtrTypedModel = QVTbaseFactory.eINSTANCE.createTypedModel();
			models[2/*qvtr*/].add(qvtrTypedModel, false);
			final @SuppressWarnings("null")@NonNull TC_mapOclMetamodel trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapOclMetamodel();
			models[0/*middle*/].add(trace_37, false);
			// mapping statements
			qvtrTypedModel.setName(name_2);
			trace_37.setPrimitive_tmName(name_2);
			OPPOSITE_OF_TC_mapOclMetamodel_atl_oclMetamodel.put(oclMetamodel, trace_37);
			trace_37.setAtl_oclMetamodel(oclMetamodel);
			trace_37.setQvtr_qvtrTypedModel(qvtrTypedModel);
			final /*@Thrown*/ @Nullable Boolean m_TC__mapOclMetamodel_atl_oclMetamodel_primitive_tmN = ValueUtil.TRUE_VALUE;
			symbol_5 = m_TC__mapOclMetamodel_atl_oclMetamodel_primitive_tmN;
		}
		else {
			symbol_5 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_5 ? "done "  : "fail ") + "MAP_m_TC__mapOclMetamodel_atl_oclMetamodel_primitive_tmN");
		}
		return symbol_5;
	}

	/**
	 *
	 * map m_TC__mapInPattern_atl_atlModel_atl_atlPattern_atl_a in ATL2QVTr {
	 *
	 *   guard:atl atlPattern : ATL::InPattern[1];
	 * var elements : Set(ATL::InPatternElement) := atlPattern.elements;
	 * var atlRule : ATL::MatchedRule[1] := atlPattern.rule;
	 * var when_TC_mapMatchedRule : trace_ATL2QVTr::TC_mapMatchedRule[1] := atlRule.TC_mapMatchedRule;
	 * var qvtrRelation : qvtrelation::Relation[1] := when_TC_mapMatchedRule.qvtr_qvtrRelation;
	 * var selectByKind : Bag(OCL::OclModelElement) := elements->collect(_'1_' | _'1_'.type)
	 *   ->selectByKind(OCL::OclModelElement)
	 *   ;
	 * var _'\u00ABcollect\u00BB' : Bag(OCL::OclType[*|?]) := elements->collect(_'1_' | _'1_'.type)
	 *   ;
	 * var _'\u00ABany\u00BB' : OCL::OclModelElement[?] := selectByKind->any(_'1__0' | true);
	 * var atlModel : OCL::OclModel[1] := _'\u00ABany\u00BB'?.model;
	 * var when_TC_mapOclMetamodel : trace_ATL2QVTr::TC_mapOclMetamodel[1] := atlModel.TC_mapOclMetamodel;
	 * var qvtrTypedModel : qvtbase::TypedModel[1] := when_TC_mapOclMetamodel.qvtr_qvtrTypedModel;
	 * contained new:qvtr qvtrDomain : qvtrelation::RelationDomain[1];
	 * new:middle trace : trace_ATL2QVTr::TC_mapInPattern[1];
	 * set qvtrDomain.isCheckable := true;
	 * set qvtrDomain.isEnforceable := false;
	 * set qvtrDomain.rule := qvtrRelation;
	 * set qvtrDomain.typedModel := qvtrTypedModel;
	 * set trace.atl_atlModel := atlModel;
	 * set trace.atl_atlPattern := atlPattern;
	 * set trace.atl_atlRule := atlRule;
	 * set trace.qvtr_qvtrDomain := qvtrDomain;
	 * set trace.qvtr_qvtrRelation := qvtrRelation;
	 * set trace.qvtr_qvtrTypedModel := qvtrTypedModel;
	 *
	 */
	protected boolean MAP_m_TC__mapInPattern_atl_atlModel_atl_atlPattern_atl_a(final /*@NonInvalid*/ @NonNull InPattern atlPattern)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapInPattern_atl_atlModel_atl_atlPattern_atl_a" + ", " + atlPattern);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull List<InPatternElement> elements = atlPattern.getElements();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull MatchedRule rule = atlPattern.getRule();
		final /*@NonInvalid*/ @Nullable TC_mapMatchedRule TC_mapMatchedRule = OPPOSITE_OF_TC_mapMatchedRule_atl_matchedRule.get(rule);
		final /*@NonInvalid*/ boolean symbol_0 = TC_mapMatchedRule != null;
		/*@Thrown*/ @Nullable Boolean raw_when_TC_mapMatchedRule;
		if (symbol_0) {
			if (TC_mapMatchedRule == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull Relation qvtr_qvtrRelation = TC_mapMatchedRule.getQvtr_qvtrRelation();
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
			@NonNull Iterator<Object> ITERATOR__49___0 = selectByKind.iterator();
			/*@Thrown*/ @Nullable OclModelElement any;
			while (true) {
				if (!ITERATOR__49___0.hasNext()) {
					throw new InvalidValueException("No matching content for 'any'");
				}
				@SuppressWarnings("null")
				/*@NonInvalid*/ @NonNull OclModelElement _49___0 = (OclModelElement)ITERATOR__49___0.next();
				/**
				 * true
				 */
				//
				if (ValueUtil.TRUE_VALUE != ValueUtil.FALSE_VALUE) {			// Carry on till something found
					any = _49___0;
					break;
				}
			}
			/*@Caught*/ @Nullable Object CAUGHT_any;
			try {
				CAUGHT_any = any;
			}
			catch (Exception e) {
				CAUGHT_any = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ @NonNull Object model = CAUGHT_any == null;
			/*@Thrown*/ @Nullable OclModel safe_model_source;
			if (model == Boolean.TRUE) {
				safe_model_source = null;
			}
			else {
				assert any != null;
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull OclModel model_0 = any.getModel();
				safe_model_source = model_0;
			}
			final /*@Thrown*/ boolean symbol_1 = safe_model_source != null;
			/*@Thrown*/ @Nullable Boolean raw_atlModel;
			if (symbol_1) {
				if (safe_model_source == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@Thrown*/ @Nullable TC_mapOclMetamodel TC_mapOclMetamodel = OPPOSITE_OF_TC_mapOclMetamodel_atl_oclMetamodel.get(safe_model_source);
				final /*@Thrown*/ boolean symbol_2 = TC_mapOclMetamodel != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TC_mapOclMetamodel;
				if (symbol_2) {
					if (TC_mapOclMetamodel == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull TypedModel qvtr_qvtrTypedModel = TC_mapOclMetamodel.getQvtr_qvtrTypedModel();
					// creations
					final @NonNull RelationDomain qvtrDomain = QVTrelationFactory.eINSTANCE.createRelationDomain();
					models[2/*qvtr*/].add(qvtrDomain, true);
					final @SuppressWarnings("null")@NonNull TC_mapInPattern trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapInPattern();
					models[0/*middle*/].add(trace_37, false);
					// mapping statements
					qvtrDomain.setIsCheckable(ValueUtil.TRUE_VALUE);
					qvtrDomain.setIsEnforceable(ValueUtil.FALSE_VALUE);
					qvtrDomain.setRule(qvtr_qvtrRelation);
					qvtrDomain.setTypedModel(qvtr_qvtrTypedModel);
					trace_37.setAtl_atlModel(safe_model_source);
					OPPOSITE_OF_TC_mapInPattern_atl_atlPattern.put(atlPattern, trace_37);
					trace_37.setAtl_atlPattern(atlPattern);
					trace_37.setAtl_atlRule(rule);
					trace_37.setQvtr_qvtrDomain(qvtrDomain);
					trace_37.setQvtr_qvtrRelation(qvtr_qvtrRelation);
					trace_37.setQvtr_qvtrTypedModel(qvtr_qvtrTypedModel);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapInPattern_atl_atlModel_atl_atlPattern_atl_a = ValueUtil.TRUE_VALUE;
					raw_when_TC_mapOclMetamodel = m_TC__mapInPattern_atl_atlModel_atl_atlPattern_atl_a;
				}
				else {
					raw_when_TC_mapOclMetamodel = ValueUtil.FALSE_VALUE;
				}
				raw_atlModel = raw_when_TC_mapOclMetamodel;
			}
			else {
				raw_atlModel = ValueUtil.FALSE_VALUE;
			}
			raw_when_TC_mapMatchedRule = raw_atlModel;
		}
		else {
			raw_when_TC_mapMatchedRule = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_TC_mapMatchedRule ? "done "  : "fail ") + "MAP_m_TC__mapInPattern_atl_atlModel_atl_atlPattern_atl_a");
		}
		return raw_when_TC_mapMatchedRule;
	}

	/**
	 *
	 * map m_TC__mapOclModel__IN_atl_atlModule_atl_oclMetamodel in ATL2QVTr {
	 *
	 *   guard:atl oclModel : OCL::OclModel[1];
	 * var atlModule : ATL::Module[1] := oclModel.Module;
	 * var oclMetamodel : OCL::OclModel[1] := oclModel.metamodel;
	 * var tmName : String[1] := oclMetamodel.name;
	 * var when_TC_mapModule : trace_ATL2QVTr::TC_mapModule[1] := atlModule.TC_mapModule;
	 * var when_TC_mapOclMetamodel : trace_ATL2QVTr::TC_mapOclMetamodel[1] := oclMetamodel.TC_mapOclMetamodel;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_TC_mapModule.qvtr_qvtrTransformation;
	 * var qvtrTypedModel : qvtbase::TypedModel[1] := when_TC_mapOclMetamodel.qvtr_qvtrTypedModel;
	 * var oclAsSet : Set(Package[0|1]) := this.getPackage(atlModule, tmName)
	 *   .oclAsSet()
	 *   ;
	 * var getPackage1 : Package[?] := this.getPackage(atlModule, tmName);
	 * new:middle trace : trace_ATL2QVTr::TC_mapOclModel_IN[1];
	 * set trace.primitive_tmName := tmName;
	 * set qvtrTypedModel.usedPackage := oclAsSet;
	 * set trace.atl_atlModule := atlModule;
	 * set trace.atl_oclMetamodel := oclMetamodel;
	 * set trace.atl_oclModel := oclModel;
	 * set trace.qvtr_qvtrTransformation := qvtrTransformation;
	 * set trace.qvtr_qvtrTypedModel := qvtrTypedModel;
	 * set qvtrTypedModel.transformation := qvtrTransformation;
	 *
	 */
	protected boolean MAP_m_TC__mapOclModel__IN_atl_atlModule_atl_oclMetamodel(final /*@NonInvalid*/ @NonNull OclModel oclModel)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOclModel__IN_atl_atlModule_atl_oclMetamodel" + ", " + oclModel);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @NonNull UnboxedCompositionProperty IMPPROPid_inModels = new UnboxedCompositionProperty(PROPid_inModels);
		final /*@NonInvalid*/ @Nullable Module Module = (Module)IMPPROPid_inModels.evaluate(executor, CLSSid_Module, oclModel);
		final /*@NonInvalid*/ boolean symbol_0 = Module != null;
		/*@Thrown*/ @Nullable Boolean raw_atlModule;
		if (symbol_0) {
			if (Module == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclModel metamodel = oclModel.getMetamodel();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name_2 = metamodel.getName();
			final /*@Thrown*/ @Nullable TC_mapModule TC_mapModule = OPPOSITE_OF_TC_mapModule_atl_atlModule.get(Module);
			final /*@Thrown*/ boolean symbol_1 = TC_mapModule != null;
			/*@Thrown*/ @Nullable Boolean raw_when_TC_mapModule;
			if (symbol_1) {
				if (TC_mapModule == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@NonInvalid*/ @Nullable TC_mapOclMetamodel TC_mapOclMetamodel = OPPOSITE_OF_TC_mapOclMetamodel_atl_oclMetamodel.get(metamodel);
				final /*@NonInvalid*/ boolean symbol_2 = TC_mapOclMetamodel != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TC_mapOclMetamodel;
				if (symbol_2) {
					if (TC_mapOclMetamodel == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull RelationalTransformation qvtr_qvtrTransformation = TC_mapModule.getQvtr_qvtrTransformation();
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull TypedModel qvtr_qvtrTypedModel = TC_mapOclMetamodel.getQvtr_qvtrTypedModel();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Package getPackage_0 = ((FUN_getPackage)FTOR_getPackage.getUniqueComputation(this, Module, name_2)).instance;
					final /*@Thrown*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Package, getPackage_0);
					// creations
					final @SuppressWarnings("null")@NonNull TC_mapOclModel_IN trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapOclModel_IN();
					models[0/*middle*/].add(trace_37, false);
					// mapping statements
					trace_37.setPrimitive_tmName(name_2);
					final /*@Thrown*/ @NonNull List<Package> ECORE_oclAsSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, oclAsSet);
					qvtr_qvtrTypedModel.getUsedPackage().addAll(ECORE_oclAsSet);
					trace_37.setAtl_atlModule(Module);
					trace_37.setAtl_oclMetamodel(metamodel);
					trace_37.setAtl_oclModel(oclModel);
					trace_37.setQvtr_qvtrTransformation(qvtr_qvtrTransformation);
					trace_37.setQvtr_qvtrTypedModel(qvtr_qvtrTypedModel);
					qvtr_qvtrTypedModel.setTransformation(qvtr_qvtrTransformation);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapOclModel__IN_atl_atlModule_atl_oclMetamodel = ValueUtil.TRUE_VALUE;
					raw_when_TC_mapOclMetamodel = m_TC__mapOclModel__IN_atl_atlModule_atl_oclMetamodel;
				}
				else {
					raw_when_TC_mapOclMetamodel = ValueUtil.FALSE_VALUE;
				}
				raw_when_TC_mapModule = raw_when_TC_mapOclMetamodel;
			}
			else {
				raw_when_TC_mapModule = ValueUtil.FALSE_VALUE;
			}
			raw_atlModule = raw_when_TC_mapModule;
		}
		else {
			raw_atlModule = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_atlModule ? "done "  : "fail ") + "MAP_m_TC__mapOclModel__IN_atl_atlModule_atl_oclMetamodel");
		}
		return raw_atlModule;
	}

	/**
	 *
	 * map m_TC__mapOclModel__OUT_atl_atlModule_atl_oclMetamode in ATL2QVTr {
	 *
	 *   guard:atl oclModel : OCL::OclModel[1];
	 * var atlModule : ATL::Module[1] := oclModel.Module;
	 * var oclMetamodel : OCL::OclModel[1] := oclModel.metamodel;
	 * var tmName : String[1] := oclMetamodel.name;
	 * var when_TC_mapModule : trace_ATL2QVTr::TC_mapModule[1] := atlModule.TC_mapModule;
	 * var when_TC_mapOclMetamodel : trace_ATL2QVTr::TC_mapOclMetamodel[1] := oclMetamodel.TC_mapOclMetamodel;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_TC_mapModule.qvtr_qvtrTransformation;
	 * var qvtrTypedModel : qvtbase::TypedModel[1] := when_TC_mapOclMetamodel.qvtr_qvtrTypedModel;
	 * var oclAsSet : Set(Package[0|1]) := this.getPackage(atlModule, tmName)
	 *   .oclAsSet()
	 *   ;
	 * var getPackage1 : Package[?] := this.getPackage(atlModule, tmName);
	 * new:middle trace : trace_ATL2QVTr::TC_mapOclModel_OUT[1];
	 * set trace.primitive_tmName := tmName;
	 * set qvtrTypedModel.usedPackage := oclAsSet;
	 * set qvtrTypedModel.transformation := qvtrTransformation;
	 * set trace.atl_atlModule := atlModule;
	 * set trace.atl_oclMetamodel := oclMetamodel;
	 * set trace.atl_oclModel := oclModel;
	 * set trace.qvtr_qvtrTransformation := qvtrTransformation;
	 * set trace.qvtr_qvtrTypedModel := qvtrTypedModel;
	 *
	 */
	protected boolean MAP_m_TC__mapOclModel__OUT_atl_atlModule_atl_oclMetamode(final /*@NonInvalid*/ @NonNull OclModel oclModel_0)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOclModel__OUT_atl_atlModule_atl_oclMetamode" + ", " + oclModel_0);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @NonNull UnboxedCompositionProperty IMPPROPid_outModels = new UnboxedCompositionProperty(PROPid_outModels);
		final /*@NonInvalid*/ @Nullable Module Module = (Module)IMPPROPid_outModels.evaluate(executor, CLSSid_Module, oclModel_0);
		final /*@NonInvalid*/ boolean symbol_0 = Module != null;
		/*@Thrown*/ @Nullable Boolean raw_atlModule;
		if (symbol_0) {
			if (Module == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclModel metamodel = oclModel_0.getMetamodel();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name_2 = metamodel.getName();
			final /*@Thrown*/ @Nullable TC_mapModule TC_mapModule = OPPOSITE_OF_TC_mapModule_atl_atlModule.get(Module);
			final /*@Thrown*/ boolean symbol_1 = TC_mapModule != null;
			/*@Thrown*/ @Nullable Boolean raw_when_TC_mapModule;
			if (symbol_1) {
				if (TC_mapModule == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@NonInvalid*/ @Nullable TC_mapOclMetamodel TC_mapOclMetamodel = OPPOSITE_OF_TC_mapOclMetamodel_atl_oclMetamodel.get(metamodel);
				final /*@NonInvalid*/ boolean symbol_2 = TC_mapOclMetamodel != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TC_mapOclMetamodel;
				if (symbol_2) {
					if (TC_mapOclMetamodel == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull RelationalTransformation qvtr_qvtrTransformation = TC_mapModule.getQvtr_qvtrTransformation();
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull TypedModel qvtr_qvtrTypedModel = TC_mapOclMetamodel.getQvtr_qvtrTypedModel();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Package getPackage_0 = ((FUN_getPackage)FTOR_getPackage.getUniqueComputation(this, Module, name_2)).instance;
					final /*@Thrown*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Package, getPackage_0);
					// creations
					final @SuppressWarnings("null")@NonNull TC_mapOclModel_OUT trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapOclModel_OUT();
					models[0/*middle*/].add(trace_37, false);
					// mapping statements
					trace_37.setPrimitive_tmName(name_2);
					final /*@Thrown*/ @NonNull List<Package> ECORE_oclAsSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, oclAsSet);
					qvtr_qvtrTypedModel.getUsedPackage().addAll(ECORE_oclAsSet);
					qvtr_qvtrTypedModel.setTransformation(qvtr_qvtrTransformation);
					trace_37.setAtl_atlModule(Module);
					trace_37.setAtl_oclMetamodel(metamodel);
					trace_37.setAtl_oclModel(oclModel_0);
					trace_37.setQvtr_qvtrTransformation(qvtr_qvtrTransformation);
					trace_37.setQvtr_qvtrTypedModel(qvtr_qvtrTypedModel);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapOclModel__OUT_atl_atlModule_atl_oclMetamode = ValueUtil.TRUE_VALUE;
					raw_when_TC_mapOclMetamodel = m_TC__mapOclModel__OUT_atl_atlModule_atl_oclMetamode;
				}
				else {
					raw_when_TC_mapOclMetamodel = ValueUtil.FALSE_VALUE;
				}
				raw_when_TC_mapModule = raw_when_TC_mapOclMetamodel;
			}
			else {
				raw_when_TC_mapModule = ValueUtil.FALSE_VALUE;
			}
			raw_atlModule = raw_when_TC_mapModule;
		}
		else {
			raw_atlModule = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_atlModule ? "done "  : "fail ") + "MAP_m_TC__mapOclModel__OUT_atl_atlModule_atl_oclMetamode");
		}
		return raw_atlModule;
	}

	/**
	 *
	 * map m_OperationCallExp in ATL2QVTr {
	 * guard:atl atlExpression : OCL::OperationCallExp[1];
	 * check false;
	 *
	 */
	protected boolean MAP_m_OperationCallExp(final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull OperationCallExp atlExpression_3)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_OperationCallExp" + ", " + atlExpression_3);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((ValueUtil.FALSE_VALUE ? "done "  : "fail ") + "MAP_m_OperationCallExp");
		}
		return ValueUtil.FALSE_VALUE;
	}

	/**
	 *
	 * map m_TC__mapOutPattern_atl_atlPattern_atl_atlRule_qvtr_ in ATL2QVTr {
	 *
	 *   guard:atl atlPattern : ATL::OutPattern[1];
	 * check var atlRule : ATL::MatchedRule[1] := atlPattern.rule;
	 * var elements : OrderedSet(ATL::OutPatternElement) := atlPattern.elements;
	 * var when_TC_mapMatchedRule : trace_ATL2QVTr::TC_mapMatchedRule[1] := atlRule.TC_mapMatchedRule;
	 * var qvtrRelation : qvtrelation::Relation[1] := when_TC_mapMatchedRule.qvtr_qvtrRelation;
	 * var selectByKind : Sequence(OCL::OclModelElement) := elements->collect(_'1__0' | _'1__0'.type)
	 *   ->selectByKind(OCL::OclModelElement)
	 *   ;
	 * var _'\u00ABcollect\u00BB' : Sequence(OCL::OclType[*|?]) := elements->collect(_'1__0' | _'1__0'.type)
	 *   ;
	 * var _'\u00ABany\u00BB' : OCL::OclModelElement[?] := selectByKind->any(_'1_' | true);
	 * var model : OCL::OclModel[1] := _'\u00ABany\u00BB'?.model;
	 * var when_TC_mapOclMetamodel : trace_ATL2QVTr::TC_mapOclMetamodel[1] := model.TC_mapOclMetamodel;
	 * var qvtrTypedModel : qvtbase::TypedModel[1] := when_TC_mapOclMetamodel.qvtr_qvtrTypedModel;
	 * contained new:qvtr qvtrDomain : qvtrelation::RelationDomain[1];
	 * new:middle trace : trace_ATL2QVTr::TC_mapOutPattern[1];
	 * set qvtrDomain.isCheckable := false;
	 * set qvtrDomain.isEnforceable := true;
	 * set qvtrDomain.rule := qvtrRelation;
	 * set qvtrDomain.typedModel := qvtrTypedModel;
	 * set trace.atl_atlPattern := atlPattern;
	 * set trace.atl_atlRule := atlRule;
	 * set trace.qvtr_qvtrDomain := qvtrDomain;
	 * set trace.qvtr_qvtrRelation := qvtrRelation;
	 * set trace.qvtr_qvtrTypedModel := qvtrTypedModel;
	 *
	 */
	protected boolean MAP_m_TC__mapOutPattern_atl_atlPattern_atl_atlRule_qvtr_(final /*@NonInvalid*/ @NonNull OutPattern atlPattern_0)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOutPattern_atl_atlPattern_atl_atlRule_qvtr_" + ", " + atlPattern_0);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Rule temp1_atlRule = atlPattern_0.getRule();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlRule instanceof MatchedRule;
		/*@Thrown*/ @Nullable Boolean symbol_15;
		if (symbol_0) {
			final /*@NonInvalid*/ @NonNull MatchedRule symbol_1 = (MatchedRule)temp1_atlRule;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<OutPatternElement> elements = atlPattern_0.getElements();
			final /*@NonInvalid*/ @Nullable TC_mapMatchedRule TC_mapMatchedRule = OPPOSITE_OF_TC_mapMatchedRule_atl_matchedRule.get(symbol_1);
			final /*@NonInvalid*/ boolean symbol_2 = TC_mapMatchedRule != null;
			/*@Thrown*/ @Nullable Boolean raw_when_TC_mapMatchedRule;
			if (symbol_2) {
				if (TC_mapMatchedRule == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull Relation qvtr_qvtrRelation = TC_mapMatchedRule.getQvtr_qvtrRelation();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_OclModelElement_0 = idResolver.getClass(CLSSid_OclModelElement, null);
				final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_elements_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_OutPatternElement, elements);
				/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclType);
				@NonNull Iterator<Object> ITERATOR__49___0_0 = BOXED_elements_0.iterator();
				/*@Thrown*/ @NonNull SequenceValue collect_0;
				while (true) {
					if (!ITERATOR__49___0_0.hasNext()) {
						collect_0 = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull OutPatternElement _49___0_0 = (OutPatternElement)ITERATOR__49___0_0.next();
					/**
					 * _'1__0'.type
					 */
					final /*@NonInvalid*/ @Nullable OclType type_3 = _49___0_0.getType();
					//
					accumulator.add(type_3);
				}
				final /*@Thrown*/ @NonNull SequenceValue selectByKind = (SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_0, TYP_OCL_c_c_OclModelElement_0);
				@NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
				/*@Thrown*/ @Nullable OclModelElement any;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						throw new InvalidValueException("No matching content for 'any'");
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull OclModelElement _1 = (OclModelElement)ITERATOR__1.next();
					/**
					 * true
					 */
					//
					if (ValueUtil.TRUE_VALUE != ValueUtil.FALSE_VALUE) {			// Carry on till something found
						any = _1;
						break;
					}
				}
				/*@Caught*/ @Nullable Object CAUGHT_any;
				try {
					CAUGHT_any = any;
				}
				catch (Exception e) {
					CAUGHT_any = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ @NonNull Object model = CAUGHT_any == null;
				/*@Thrown*/ @Nullable OclModel safe_model_source;
				if (model == Boolean.TRUE) {
					safe_model_source = null;
				}
				else {
					assert any != null;
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OclModel model_0 = any.getModel();
					safe_model_source = model_0;
				}
				final /*@Thrown*/ boolean symbol_3 = safe_model_source != null;
				/*@Thrown*/ @Nullable Boolean raw_model;
				if (symbol_3) {
					if (safe_model_source == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable TC_mapOclMetamodel TC_mapOclMetamodel = OPPOSITE_OF_TC_mapOclMetamodel_atl_oclMetamodel.get(safe_model_source);
					final /*@Thrown*/ boolean symbol_4 = TC_mapOclMetamodel != null;
					/*@Thrown*/ @Nullable Boolean raw_when_TC_mapOclMetamodel;
					if (symbol_4) {
						if (TC_mapOclMetamodel == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull TypedModel qvtr_qvtrTypedModel = TC_mapOclMetamodel.getQvtr_qvtrTypedModel();
						// creations
						final @NonNull RelationDomain qvtrDomain = QVTrelationFactory.eINSTANCE.createRelationDomain();
						models[2/*qvtr*/].add(qvtrDomain, true);
						final @SuppressWarnings("null")@NonNull TC_mapOutPattern trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapOutPattern();
						models[0/*middle*/].add(trace_37, false);
						// mapping statements
						qvtrDomain.setIsCheckable(ValueUtil.FALSE_VALUE);
						qvtrDomain.setIsEnforceable(ValueUtil.TRUE_VALUE);
						qvtrDomain.setRule(qvtr_qvtrRelation);
						qvtrDomain.setTypedModel(qvtr_qvtrTypedModel);
						OPPOSITE_OF_TC_mapOutPattern_atl_atlPattern.put(atlPattern_0, trace_37);
						trace_37.setAtl_atlPattern(atlPattern_0);
						trace_37.setAtl_atlRule(symbol_1);
						trace_37.setQvtr_qvtrDomain(qvtrDomain);
						trace_37.setQvtr_qvtrRelation(qvtr_qvtrRelation);
						trace_37.setQvtr_qvtrTypedModel(qvtr_qvtrTypedModel);
						final /*@Thrown*/ @Nullable Boolean m_TC__mapOutPattern_atl_atlPattern_atl_atlRule_qvtr_ = ValueUtil.TRUE_VALUE;
						raw_when_TC_mapOclMetamodel = m_TC__mapOutPattern_atl_atlPattern_atl_atlRule_qvtr_;
					}
					else {
						raw_when_TC_mapOclMetamodel = ValueUtil.FALSE_VALUE;
					}
					raw_model = raw_when_TC_mapOclMetamodel;
				}
				else {
					raw_model = ValueUtil.FALSE_VALUE;
				}
				raw_when_TC_mapMatchedRule = raw_model;
			}
			else {
				raw_when_TC_mapMatchedRule = ValueUtil.FALSE_VALUE;
			}
			symbol_15 = raw_when_TC_mapMatchedRule;
		}
		else {
			symbol_15 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_15 ? "done "  : "fail ") + "MAP_m_TC__mapOutPattern_atl_atlPattern_atl_atlRule_qvtr_");
		}
		return symbol_15;
	}

	/**
	 *
	 * map m_TC__mapSimpleInPatternElement_atl_atlElement_atl_a in ATL2QVTr {
	 *
	 *   guard:atl atlElement : ATL::SimpleInPatternElement[1];
	 * var atlPattern : ATL::InPattern[1] := atlElement.inPattern;
	 * var type : OCL::OclType[?] := atlElement.type;
	 * var elementName : String[1] := atlElement.varName;
	 * var atlRule : ATL::MatchedRule[1] := atlPattern.rule;
	 * var when_TC_mapInPattern : trace_ATL2QVTr::TC_mapInPattern[1] := atlPattern.TC_mapInPattern;
	 * var when_TC_mapMatchedRule : trace_ATL2QVTr::TC_mapMatchedRule[1] := atlRule.TC_mapMatchedRule;
	 * var qvtrDomain : qvtrelation::RelationDomain[1] := when_TC_mapInPattern.qvtr_qvtrDomain;
	 * var qvtrRelation : qvtrelation::Relation[1] := when_TC_mapMatchedRule.qvtr_qvtrRelation;
	 * var getType1 : Class[1] := this.getType(type);
	 * new:qvtr qvtrPattern : qvtrelation::DomainPattern[1];
	 * contained new:qvtr qvtrTemplate : qvttemplate::ObjectTemplateExp[1];
	 * contained new:qvtr qvtrVariable : qvtrelation::TemplateVariable[1];
	 * new:middle trace : trace_ATL2QVTr::TC_mapSimpleInPatternElement[1];
	 * new:middle where_TC_mapVariable : trace_ATL2QVTr::TC_mapVariable[1];
	 * set qvtrVariable.name := elementName;
	 * set trace.primitive_elementName := elementName;
	 * set qvtrDomain.pattern := qvtrPattern;
	 * set qvtrPattern.templateExpression := qvtrTemplate;
	 * set qvtrTemplate.bindsTo := qvtrVariable;
	 * set qvtrTemplate.referredClass := getType1;
	 * notify set qvtrTemplate.type := getType1;
	 * set where_TC_mapVariable.atl_atlVariable := atlElement;
	 * set where_TC_mapVariable.qvtr_qvtrVariable := qvtrVariable;
	 * set qvtrRelation.variable := qvtrVariable;
	 * set qvtrDomain.rootVariable := qvtrVariable;
	 * notify set qvtrVariable.type := getType1;
	 * set trace.atl_atlElement := atlElement;
	 * set trace.atl_atlPattern := atlPattern;
	 * set trace.atl_atlRule := atlRule;
	 * set trace.invocation_mapVariable := where_TC_mapVariable;
	 * set trace.qvtr_qvtrDomain1 := qvtrDomain;
	 * set trace.qvtr_qvtrPattern := qvtrPattern;
	 * set trace.qvtr_qvtrRelation := qvtrRelation;
	 * set trace.qvtr_qvtrTemplate := qvtrTemplate;
	 * set trace.qvtr_qvtrVariable := qvtrVariable;
	 *
	 */
	protected boolean MAP_m_TC__mapSimpleInPatternElement_atl_atlElement_atl_a(final /*@NonInvalid*/ @NonNull SimpleInPatternElement atlElement)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapSimpleInPatternElement_atl_atlElement_atl_a" + ", " + atlElement);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull InPattern inPattern = atlElement.getInPattern();
		final /*@NonInvalid*/ @Nullable OclType type_2 = atlElement.getType();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String varName = atlElement.getVarName();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull MatchedRule rule = inPattern.getRule();
		final /*@NonInvalid*/ @Nullable TC_mapInPattern TC_mapInPattern = OPPOSITE_OF_TC_mapInPattern_atl_atlPattern.get(inPattern);
		final /*@NonInvalid*/ boolean symbol_0 = TC_mapInPattern != null;
		/*@Thrown*/ @Nullable Boolean raw_when_TC_mapInPattern;
		if (symbol_0) {
			if (TC_mapInPattern == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@NonInvalid*/ @Nullable TC_mapMatchedRule TC_mapMatchedRule = OPPOSITE_OF_TC_mapMatchedRule_atl_matchedRule.get(rule);
			final /*@NonInvalid*/ boolean symbol_1 = TC_mapMatchedRule != null;
			/*@Thrown*/ @Nullable Boolean raw_when_TC_mapMatchedRule;
			if (symbol_1) {
				if (TC_mapMatchedRule == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull RelationDomain qvtr_qvtrDomain = TC_mapInPattern.getQvtr_qvtrDomain();
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull Relation qvtr_qvtrRelation = TC_mapMatchedRule.getQvtr_qvtrRelation();
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(this, type_2)).instance;
				// creations
				final @NonNull DomainPattern qvtrPattern = QVTrelationFactory.eINSTANCE.createDomainPattern();
				models[2/*qvtr*/].add(qvtrPattern, false);
				final @NonNull ObjectTemplateExp qvtrTemplate = QVTtemplateFactory.eINSTANCE.createObjectTemplateExp();
				models[2/*qvtr*/].add(qvtrTemplate, true);
				final @NonNull TemplateVariable qvtrVariable = QVTrelationFactory.eINSTANCE.createTemplateVariable();
				models[2/*qvtr*/].add(qvtrVariable, true);
				final @SuppressWarnings("null")@NonNull TC_mapSimpleInPatternElement trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapSimpleInPatternElement();
				models[0/*middle*/].add(trace_37, false);
				final @SuppressWarnings("null")@NonNull TC_mapVariable where_TC_mapVariable = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapVariable();
				models[0/*middle*/].add(where_TC_mapVariable, false);
				// mapping statements
				qvtrTemplate.setType(getType);
				objectManager.assigned(qvtrTemplate, PivotPackage.Literals.TYPED_ELEMENT__TYPE, getType);
				qvtrVariable.setName(varName);
				trace_37.setPrimitive_elementName(varName);
				qvtr_qvtrDomain.getPattern().add(qvtrPattern);
				qvtrPattern.setTemplateExpression(qvtrTemplate);
				qvtrTemplate.setBindsTo(qvtrVariable);
				OPPOSITE_OF_TC_mapVariable_atl_atlVariable.put(atlElement, where_TC_mapVariable);
				where_TC_mapVariable.setAtl_atlVariable(atlElement);
				where_TC_mapVariable.setQvtr_qvtrVariable(qvtrVariable);
				qvtr_qvtrRelation.getVariable().add(qvtrVariable);
				qvtr_qvtrDomain.getRootVariable().add(qvtrVariable);
				qvtrVariable.setType(getType);
				objectManager.assigned(qvtrVariable, PivotPackage.Literals.TYPED_ELEMENT__TYPE, getType);
				trace_37.setAtl_atlElement(atlElement);
				trace_37.setAtl_atlPattern(inPattern);
				trace_37.setAtl_atlRule(rule);
				trace_37.setInvocation_mapVariable(where_TC_mapVariable);
				trace_37.setQvtr_qvtrDomain1(qvtr_qvtrDomain);
				trace_37.setQvtr_qvtrPattern(qvtrPattern);
				trace_37.setQvtr_qvtrRelation(qvtr_qvtrRelation);
				trace_37.setQvtr_qvtrTemplate(qvtrTemplate);
				trace_37.setQvtr_qvtrVariable(qvtrVariable);
				final /*@Thrown*/ @Nullable Boolean m_TC__mapSimpleInPatternElement_atl_atlElement_atl_a = ValueUtil.TRUE_VALUE;
				raw_when_TC_mapMatchedRule = m_TC__mapSimpleInPatternElement_atl_atlElement_atl_a;
			}
			else {
				raw_when_TC_mapMatchedRule = ValueUtil.FALSE_VALUE;
			}
			raw_when_TC_mapInPattern = raw_when_TC_mapMatchedRule;
		}
		else {
			raw_when_TC_mapInPattern = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_TC_mapInPattern ? "done "  : "fail ") + "MAP_m_TC__mapSimpleInPatternElement_atl_atlElement_atl_a");
		}
		return raw_when_TC_mapInPattern;
	}

	/**
	 *
	 * map m_TC__mapSimpleOutPatternElement_atl_atlElement_atl_ in ATL2QVTr {
	 *
	 *   guard:atl atlElement : ATL::SimpleOutPatternElement[1];
	 * var atlPattern : ATL::OutPattern[1] := atlElement.outPattern;
	 * check var atlRule : ATL::MatchedRule[1] := atlPattern.rule;
	 * var type : OCL::OclType[?] := atlElement.type;
	 * var elementName : String[1] := atlElement.varName;
	 * var when_TC_mapOutPattern : trace_ATL2QVTr::TC_mapOutPattern[1] := atlPattern.TC_mapOutPattern;
	 * var when_TC_mapMatchedRule : trace_ATL2QVTr::TC_mapMatchedRule[1] := atlRule.TC_mapMatchedRule;
	 * var qvtrDomain : qvtrelation::RelationDomain[1] := when_TC_mapOutPattern.qvtr_qvtrDomain;
	 * var qvtrRelation : qvtrelation::Relation[1] := when_TC_mapMatchedRule.qvtr_qvtrRelation;
	 * var getType1 : Class[1] := this.getType(type);
	 * new:qvtr qvtrPattern : qvtrelation::DomainPattern[1];
	 * contained new:qvtr qvtrTemplate : qvttemplate::ObjectTemplateExp[1];
	 * contained new:qvtr qvtrVariable : qvtrelation::TemplateVariable[1];
	 * new:middle trace : trace_ATL2QVTr::TC_mapSimpleOutPatternElement[1];
	 * new:middle where_TC_mapVariable : trace_ATL2QVTr::TC_mapVariable[1];
	 * set qvtrVariable.name := elementName;
	 * set trace.primitive_elementName := elementName;
	 * set qvtrDomain.pattern := qvtrPattern;
	 * set trace.atl_atlElement := atlElement;
	 * set trace.atl_atlPattern := atlPattern;
	 * set trace.atl_atlRule := atlRule;
	 * set trace.invocation_mapVariable := where_TC_mapVariable;
	 * set trace.qvtr_qvtrDomain := qvtrDomain;
	 * set trace.qvtr_qvtrPattern := qvtrPattern;
	 * set trace.qvtr_qvtrRelation := qvtrRelation;
	 * set trace.qvtr_qvtrTemplate := qvtrTemplate;
	 * set trace.qvtr_qvtrVariable := qvtrVariable;
	 * set qvtrTemplate.bindsTo := qvtrVariable;
	 * set qvtrTemplate.referredClass := getType1;
	 * notify set qvtrTemplate.type := getType1;
	 * set qvtrRelation.variable := qvtrVariable;
	 * set qvtrDomain.rootVariable := qvtrVariable;
	 * notify set qvtrVariable.type := getType1;
	 * set qvtrPattern.templateExpression := qvtrTemplate;
	 * set where_TC_mapVariable.atl_atlVariable := atlElement;
	 * set where_TC_mapVariable.qvtr_qvtrVariable := qvtrVariable;
	 *
	 */
	protected boolean MAP_m_TC__mapSimpleOutPatternElement_atl_atlElement_atl_(final /*@NonInvalid*/ @NonNull SimpleOutPatternElement atlElement_0)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapSimpleOutPatternElement_atl_atlElement_atl_" + ", " + atlElement_0);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OutPattern outPattern = atlElement_0.getOutPattern();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Rule temp1_atlRule = outPattern.getRule();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlRule instanceof MatchedRule;
		/*@Thrown*/ @Nullable Boolean symbol_26;
		if (symbol_0) {
			final /*@NonInvalid*/ @NonNull MatchedRule symbol_1 = (MatchedRule)temp1_atlRule;
			final /*@NonInvalid*/ @Nullable OclType type_2 = atlElement_0.getType();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String varName = atlElement_0.getVarName();
			final /*@NonInvalid*/ @Nullable TC_mapOutPattern TC_mapOutPattern = OPPOSITE_OF_TC_mapOutPattern_atl_atlPattern.get(outPattern);
			final /*@NonInvalid*/ boolean symbol_2 = TC_mapOutPattern != null;
			/*@Thrown*/ @Nullable Boolean raw_when_TC_mapOutPattern;
			if (symbol_2) {
				if (TC_mapOutPattern == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@NonInvalid*/ @Nullable TC_mapMatchedRule TC_mapMatchedRule = OPPOSITE_OF_TC_mapMatchedRule_atl_matchedRule.get(symbol_1);
				final /*@NonInvalid*/ boolean symbol_3 = TC_mapMatchedRule != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TC_mapMatchedRule;
				if (symbol_3) {
					if (TC_mapMatchedRule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull RelationDomain qvtr_qvtrDomain = TC_mapOutPattern.getQvtr_qvtrDomain();
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull Relation qvtr_qvtrRelation = TC_mapMatchedRule.getQvtr_qvtrRelation();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(this, type_2)).instance;
					// creations
					final @NonNull DomainPattern qvtrPattern = QVTrelationFactory.eINSTANCE.createDomainPattern();
					models[2/*qvtr*/].add(qvtrPattern, false);
					final @NonNull ObjectTemplateExp qvtrTemplate = QVTtemplateFactory.eINSTANCE.createObjectTemplateExp();
					models[2/*qvtr*/].add(qvtrTemplate, true);
					final @NonNull TemplateVariable qvtrVariable = QVTrelationFactory.eINSTANCE.createTemplateVariable();
					models[2/*qvtr*/].add(qvtrVariable, true);
					final @SuppressWarnings("null")@NonNull TC_mapSimpleOutPatternElement trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapSimpleOutPatternElement();
					models[0/*middle*/].add(trace_37, false);
					final @SuppressWarnings("null")@NonNull TC_mapVariable where_TC_mapVariable = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapVariable();
					models[0/*middle*/].add(where_TC_mapVariable, false);
					// mapping statements
					qvtrTemplate.setType(getType);
					objectManager.assigned(qvtrTemplate, PivotPackage.Literals.TYPED_ELEMENT__TYPE, getType);
					qvtrVariable.setName(varName);
					trace_37.setPrimitive_elementName(varName);
					qvtr_qvtrDomain.getPattern().add(qvtrPattern);
					OPPOSITE_OF_TC_mapSimpleOutPatternElement_atl_atlElement.put(atlElement_0, trace_37);
					trace_37.setAtl_atlElement(atlElement_0);
					trace_37.setAtl_atlPattern(outPattern);
					trace_37.setAtl_atlRule(symbol_1);
					trace_37.setInvocation_mapVariable(where_TC_mapVariable);
					trace_37.setQvtr_qvtrDomain(qvtr_qvtrDomain);
					trace_37.setQvtr_qvtrPattern(qvtrPattern);
					trace_37.setQvtr_qvtrRelation(qvtr_qvtrRelation);
					trace_37.setQvtr_qvtrTemplate(qvtrTemplate);
					trace_37.setQvtr_qvtrVariable(qvtrVariable);
					qvtrTemplate.setBindsTo(qvtrVariable);
					qvtr_qvtrRelation.getVariable().add(qvtrVariable);
					qvtr_qvtrDomain.getRootVariable().add(qvtrVariable);
					qvtrVariable.setType(getType);
					objectManager.assigned(qvtrVariable, PivotPackage.Literals.TYPED_ELEMENT__TYPE, getType);
					qvtrPattern.setTemplateExpression(qvtrTemplate);
					OPPOSITE_OF_TC_mapVariable_atl_atlVariable.put(atlElement_0, where_TC_mapVariable);
					where_TC_mapVariable.setAtl_atlVariable(atlElement_0);
					where_TC_mapVariable.setQvtr_qvtrVariable(qvtrVariable);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapSimpleOutPatternElement_atl_atlElement_atl_ = ValueUtil.TRUE_VALUE;
					raw_when_TC_mapMatchedRule = m_TC__mapSimpleOutPatternElement_atl_atlElement_atl_;
				}
				else {
					raw_when_TC_mapMatchedRule = ValueUtil.FALSE_VALUE;
				}
				raw_when_TC_mapOutPattern = raw_when_TC_mapMatchedRule;
			}
			else {
				raw_when_TC_mapOutPattern = ValueUtil.FALSE_VALUE;
			}
			symbol_26 = raw_when_TC_mapOutPattern;
		}
		else {
			symbol_26 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_26 ? "done "  : "fail ") + "MAP_m_TC__mapSimpleOutPatternElement_atl_atlElement_atl_");
		}
		return symbol_26;
	}

	/**
	 *
	 * map m_TC__mapStringExp_atl_atlExpression_primitive_symbo in ATL2QVTr {
	 * guard:atl atlExpression : OCL::StringExp[1];
	 * var symbol : String[1] := atlExpression.stringSymbol;
	 * var String1 : Class[1] := PrimitiveTypes::String;
	 * new:qvtr qvtrExpression : StringLiteralExp[1];
	 * new:middle trace : trace_ATL2QVTr::TC_mapStringExp[1];
	 * set qvtrExpression.stringSymbol := symbol;
	 * set trace.primitive_symbol := symbol;
	 * set trace.atl_atlExpression := atlExpression;
	 * set trace.qvtr_qvtrExpression := qvtrExpression;
	 * notify set qvtrExpression.type := String1;
	 *
	 */
	protected boolean MAP_m_TC__mapStringExp_atl_atlExpression_primitive_symbo(final /*@NonInvalid*/ @NonNull StringExp atlExpression_4)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapStringExp_atl_atlExpression_primitive_symbo" + ", " + atlExpression_4);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String stringSymbol = atlExpression_4.getStringSymbol();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_String_0 = idResolver.getClass(TypeId.STRING, null);
		// creations
		final @NonNull StringLiteralExp qvtrExpression = PivotFactory.eINSTANCE.createStringLiteralExp();
		models[2/*qvtr*/].add(qvtrExpression, false);
		final @SuppressWarnings("null")@NonNull TC_mapStringExp trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapStringExp();
		models[0/*middle*/].add(trace_37, false);
		// mapping statements
		qvtrExpression.setStringSymbol(stringSymbol);
		trace_37.setPrimitive_symbol(stringSymbol);
		OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.put(atlExpression_4, trace_37);
		trace_37.setAtl_atlExpression(atlExpression_4);
		trace_37.setQvtr_qvtrExpression(qvtrExpression);
		qvtrExpression.setType(TYP_String_0);
		objectManager.assigned(qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, TYP_String_0);
		final /*@Thrown*/ @Nullable Boolean m_TC__mapStringExp_atl_atlExpression_primitive_symbo = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((m_TC__mapStringExp_atl_atlExpression_primitive_symbo ? "done "  : "fail ") + "MAP_m_TC__mapStringExp_atl_atlExpression_primitive_symbo");
		}
		return m_TC__mapStringExp_atl_atlExpression_primitive_symbo;
	}

	/**
	 *
	 * map m_TC__mapVariableExp_atl_atlExpression_atl_atlVariab in ATL2QVTr {
	 * guard:atl atlExpression : OCL::VariableExp[1];
	 * var atlVariable : OCL::VariableDeclaration[1] := atlExpression.referredVariable;
	 * var varName : String[1] := atlVariable.varName;
	 * new:qvtr qvtrExpression : VariableExp[1];
	 * new:middle trace : trace_ATL2QVTr::TC_mapVariableExp[1];
	 * new:middle where_WC_mapVariableExp_referredVariable : trace_ATL2QVTr::WC_mapVariableExp_referredVariable[1];
	 * set qvtrExpression.name := varName;
	 * set trace.primitive_varName := varName;
	 * set where_WC_mapVariableExp_referredVariable.atl_atlExpression := atlExpression;
	 * set where_WC_mapVariableExp_referredVariable.qvtr_qvtrExpression := qvtrExpression;
	 * set trace.atl_atlExpression := atlExpression;
	 * set trace.atl_atlVariable := atlVariable;
	 * set trace.invocation_mapVariableExp_referredVariable := where_WC_mapVariableExp_referredVariable;
	 * set trace.qvtr_qvtrExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_m_TC__mapVariableExp_atl_atlExpression_atl_atlVariab(final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableExp atlExpression_5)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapVariableExp_atl_atlExpression_atl_atlVariab" + ", " + atlExpression_5);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableDeclaration referredVariable = atlExpression_5.getReferredVariable();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String varName = referredVariable.getVarName();
		// creations
		final org.eclipse.ocl.pivot.@NonNull VariableExp qvtrExpression = PivotFactory.eINSTANCE.createVariableExp();
		models[2/*qvtr*/].add(qvtrExpression, false);
		final @SuppressWarnings("null")@NonNull TC_mapVariableExp trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapVariableExp();
		models[0/*middle*/].add(trace_37, false);
		final @SuppressWarnings("null")@NonNull WC_mapVariableExp_referredVariable where_WC_mapVariableExp_referredVariable = trace_ATL2QVTrFactory.eINSTANCE.createWC_mapVariableExp_referredVariable();
		models[0/*middle*/].add(where_WC_mapVariableExp_referredVariable, false);
		// mapping statements
		qvtrExpression.setName(varName);
		trace_37.setPrimitive_varName(varName);
		OPPOSITE_OF_WI_mapVariableExp_referredVariable_atl_atlExpression.put(atlExpression_5, where_WC_mapVariableExp_referredVariable);
		where_WC_mapVariableExp_referredVariable.setAtl_atlExpression(atlExpression_5);
		where_WC_mapVariableExp_referredVariable.setQvtr_qvtrExpression(qvtrExpression);
		OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.put(atlExpression_5, trace_37);
		trace_37.setAtl_atlExpression(atlExpression_5);
		trace_37.setAtl_atlVariable(referredVariable);
		trace_37.setInvocation_mapVariableExp_referredVariable(where_WC_mapVariableExp_referredVariable);
		trace_37.setQvtr_qvtrExpression(qvtrExpression);
		final /*@Thrown*/ @Nullable Boolean m_TC__mapVariableExp_atl_atlExpression_atl_atlVariab = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((m_TC__mapVariableExp_atl_atlExpression_atl_atlVariab ? "done "  : "fail ") + "MAP_m_TC__mapVariableExp_atl_atlExpression_atl_atlVariab");
		}
		return m_TC__mapVariableExp_atl_atlExpression_atl_atlVariab;
	}

	/**
	 *
	 * map m_VariableExp in ATL2QVTr {
	 * guard:atl atlExpression : OCL::VariableExp[1];
	 * check false;
	 *
	 */
	protected boolean MAP_m_VariableExp(final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableExp atlExpression_6)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_VariableExp" + ", " + atlExpression_6);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((ValueUtil.FALSE_VALUE ? "done "  : "fail ") + "MAP_m_VariableExp");
		}
		return ValueUtil.FALSE_VALUE;
	}

	/**
	 *
	 * map m_LocatedElement in ATL2QVTr {
	 * guard:atl atlVariable : ATL::LocatedElement[1];
	 * check false;
	 *
	 */
	protected boolean MAP_m_LocatedElement(final /*@NonInvalid*/ @NonNull LocatedElement atlVariable)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_LocatedElement" + ", " + atlVariable);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((ValueUtil.FALSE_VALUE ? "done "  : "fail ") + "MAP_m_LocatedElement");
		}
		return ValueUtil.FALSE_VALUE;
	}

	/**
	 *
	 * map m_TC__mapHelper__Attribute_atl_atlDefinition_atl_atl_p0 in ATL2QVTr {
	 * guard:atl atlExpression : OCL::OclExpression[1];
	 * append jm_TC__mapHelper__Attribute_1  : trace_ATL2QVTr::TC_mapHelper_Attribute[1];
	 * var atlFeature : OCL::Attribute[1] := atlExpression.owningAttribute;
	 * var attributeName : String[1] := atlFeature.name;
	 * var atlType : OCL::OclType[1] := atlFeature.type;
	 * var atlDefinition : OCL::OclFeatureDefinition[1] := atlFeature.definition;
	 * var atlHelper : ATL::Helper[1] := atlDefinition.Helper;
	 * var atlModule : ATL::Module[1] := atlHelper.module;
	 * var when_TC_mapModule : trace_ATL2QVTr::TC_mapModule[1] := atlModule.TC_mapModule;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_TC_mapModule.qvtr_qvtrTransformation;
	 * new:middle trace : trace_ATL2QVTr::TC_mapHelper_Attribute[1];
	 * set trace.primitive_attributeName := attributeName;
	 * set trace.atl_atlDefinition := atlDefinition;
	 * set trace.atl_atlExpression := atlExpression;
	 * set trace.atl_atlFeature := atlFeature;
	 * set trace.atl_atlHelper := atlHelper;
	 * set trace.atl_atlModule := atlModule;
	 * set trace.atl_atlType := atlType;
	 * set trace.qvtr_qvtrTransformation := qvtrTransformation;
	 * add jm_TC__mapHelper__Attribute_1 += trace;
	 *
	 */
	protected boolean MAP_m_TC__mapHelper__Attribute_atl_atlDefinition_atl_atl_p0(final /*@NonInvalid*/ @NonNull OclExpression atlExpression_7, final @NonNull Connection jm_TC__mapHelper__Attribute_1)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapHelper__Attribute_atl_atlDefinition_atl_atl_p0" + ", " + atlExpression_7 + ", " + jm_TC__mapHelper__Attribute_1);
		}
		final /*@NonInvalid*/ @Nullable Attribute owningAttribute = atlExpression_7.getOwningAttribute();
		final /*@NonInvalid*/ boolean symbol_0 = owningAttribute != null;
		/*@Thrown*/ @Nullable Boolean raw_atlFeature;
		if (symbol_0) {
			if (owningAttribute == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull String name_2 = owningAttribute.getName();
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull OclType type_2 = owningAttribute.getType();
			final /*@Thrown*/ @Nullable OclFeatureDefinition definition = owningAttribute.getDefinition();
			final /*@Thrown*/ boolean symbol_1 = definition != null;
			/*@Thrown*/ @Nullable Boolean raw_atlDefinition;
			if (symbol_1) {
				if (definition == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@NonInvalid*/ @NonNull UnboxedCompositionProperty IMPPROPid_definition = new UnboxedCompositionProperty(PROPid_definition);
				final /*@Thrown*/ @Nullable Helper Helper = (Helper)IMPPROPid_definition.evaluate(executor, CLSSid_Helper, definition);
				final /*@Thrown*/ boolean symbol_2 = Helper != null;
				/*@Thrown*/ @Nullable Boolean raw_atlHelper;
				if (symbol_2) {
					if (Helper == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable Module module = Helper.getModule();
					final /*@Thrown*/ boolean symbol_3 = module != null;
					/*@Thrown*/ @Nullable Boolean raw_atlModule;
					if (symbol_3) {
						if (module == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable TC_mapModule TC_mapModule = OPPOSITE_OF_TC_mapModule_atl_atlModule.get(module);
						final /*@Thrown*/ boolean symbol_4 = TC_mapModule != null;
						/*@Thrown*/ @Nullable Boolean raw_when_TC_mapModule;
						if (symbol_4) {
							if (TC_mapModule == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull RelationalTransformation qvtr_qvtrTransformation = TC_mapModule.getQvtr_qvtrTransformation();
							// creations
							final @SuppressWarnings("null")@NonNull TC_mapHelper_Attribute trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapHelper_Attribute();
							models[0/*middle*/].add(trace_37, false);
							// mapping statements
							trace_37.setPrimitive_attributeName(name_2);
							trace_37.setAtl_atlDefinition(definition);
							trace_37.setAtl_atlExpression(atlExpression_7);
							trace_37.setAtl_atlFeature(owningAttribute);
							OPPOSITE_OF_TI_mapHelper_atl_atlHelper.put(Helper, trace_37);
							trace_37.setAtl_atlHelper(Helper);
							trace_37.setAtl_atlModule(module);
							trace_37.setAtl_atlType(type_2);
							trace_37.setQvtr_qvtrTransformation(qvtr_qvtrTransformation);
							jm_TC__mapHelper__Attribute_1.appendElement(trace_37);
							final /*@Thrown*/ @Nullable Boolean m_TC__mapHelper__Attribute_atl_atlDefinition_atl_atl_p0 = ValueUtil.TRUE_VALUE;
							raw_when_TC_mapModule = m_TC__mapHelper__Attribute_atl_atlDefinition_atl_atl_p0;
						}
						else {
							raw_when_TC_mapModule = ValueUtil.FALSE_VALUE;
						}
						raw_atlModule = raw_when_TC_mapModule;
					}
					else {
						raw_atlModule = ValueUtil.FALSE_VALUE;
					}
					raw_atlHelper = raw_atlModule;
				}
				else {
					raw_atlHelper = ValueUtil.FALSE_VALUE;
				}
				raw_atlDefinition = raw_atlHelper;
			}
			else {
				raw_atlDefinition = ValueUtil.FALSE_VALUE;
			}
			raw_atlFeature = raw_atlDefinition;
		}
		else {
			raw_atlFeature = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_atlFeature ? "done "  : "fail ") + "MAP_m_TC__mapHelper__Attribute_atl_atlDefinition_atl_atl_p0");
		}
		return raw_atlFeature;
	}

	/**
	 *
	 * map m_TC__mapHelper__Operation_atl_atlDefinition_atl_atl_p0 in ATL2QVTr {
	 * guard:atl atlExpression : OCL::OclExpression[1];
	 * append jm_TC__mapHelper__Operation_1  : trace_ATL2QVTr::TC_mapHelper_Operation[1];
	 * var atlFeature : OCL::Operation[1] := atlExpression.owningOperation;
	 * var operationName : String[1] := atlFeature.name;
	 * var atlType : OCL::OclType[1] := atlFeature.returnType;
	 * var atlDefinition : OCL::OclFeatureDefinition[1] := atlFeature.definition;
	 * var atlHelper : ATL::Helper[1] := atlDefinition.Helper;
	 * var atlModule : ATL::Module[1] := atlHelper.module;
	 * var when_TC_mapModule : trace_ATL2QVTr::TC_mapModule[1] := atlModule.TC_mapModule;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_TC_mapModule.qvtr_qvtrTransformation;
	 * new:middle trace : trace_ATL2QVTr::TC_mapHelper_Operation[1];
	 * set trace.primitive_operationName := operationName;
	 * set trace.atl_atlDefinition := atlDefinition;
	 * set trace.atl_atlExpression := atlExpression;
	 * set trace.atl_atlFeature := atlFeature;
	 * set trace.atl_atlHelper := atlHelper;
	 * set trace.atl_atlModule := atlModule;
	 * set trace.atl_atlType := atlType;
	 * set trace.qvtr_qvtrTransformation := qvtrTransformation;
	 * add jm_TC__mapHelper__Operation_1 += trace;
	 *
	 */
	protected boolean MAP_m_TC__mapHelper__Operation_atl_atlDefinition_atl_atl_p0(final /*@NonInvalid*/ @NonNull OclExpression atlExpression_8, final @NonNull Connection jm_TC__mapHelper__Operation_1)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapHelper__Operation_atl_atlDefinition_atl_atl_p0" + ", " + atlExpression_8 + ", " + jm_TC__mapHelper__Operation_1);
		}
		final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@Nullable Operation owningOperation = atlExpression_8.getOwningOperation();
		final /*@NonInvalid*/ boolean symbol_0 = owningOperation != null;
		/*@Thrown*/ @Nullable Boolean raw_atlFeature;
		if (symbol_0) {
			if (owningOperation == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull String name_2 = owningOperation.getName();
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull OclType returnType = owningOperation.getReturnType();
			final /*@Thrown*/ @Nullable OclFeatureDefinition definition = owningOperation.getDefinition();
			final /*@Thrown*/ boolean symbol_1 = definition != null;
			/*@Thrown*/ @Nullable Boolean raw_atlDefinition;
			if (symbol_1) {
				if (definition == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@NonInvalid*/ @NonNull UnboxedCompositionProperty IMPPROPid_definition = new UnboxedCompositionProperty(PROPid_definition);
				final /*@Thrown*/ @Nullable Helper Helper = (Helper)IMPPROPid_definition.evaluate(executor, CLSSid_Helper, definition);
				final /*@Thrown*/ boolean symbol_2 = Helper != null;
				/*@Thrown*/ @Nullable Boolean raw_atlHelper;
				if (symbol_2) {
					if (Helper == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable Module module = Helper.getModule();
					final /*@Thrown*/ boolean symbol_3 = module != null;
					/*@Thrown*/ @Nullable Boolean raw_atlModule;
					if (symbol_3) {
						if (module == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable TC_mapModule TC_mapModule = OPPOSITE_OF_TC_mapModule_atl_atlModule.get(module);
						final /*@Thrown*/ boolean symbol_4 = TC_mapModule != null;
						/*@Thrown*/ @Nullable Boolean raw_when_TC_mapModule;
						if (symbol_4) {
							if (TC_mapModule == null) {
								throw new InvalidEvaluationException("Null where non-null value required");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull RelationalTransformation qvtr_qvtrTransformation = TC_mapModule.getQvtr_qvtrTransformation();
							// creations
							final @SuppressWarnings("null")@NonNull TC_mapHelper_Operation trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapHelper_Operation();
							models[0/*middle*/].add(trace_37, false);
							// mapping statements
							trace_37.setPrimitive_operationName(name_2);
							trace_37.setAtl_atlDefinition(definition);
							trace_37.setAtl_atlExpression(atlExpression_8);
							trace_37.setAtl_atlFeature(owningOperation);
							OPPOSITE_OF_TI_mapHelper_atl_atlHelper.put(Helper, trace_37);
							trace_37.setAtl_atlHelper(Helper);
							trace_37.setAtl_atlModule(module);
							trace_37.setAtl_atlType(returnType);
							trace_37.setQvtr_qvtrTransformation(qvtr_qvtrTransformation);
							jm_TC__mapHelper__Operation_1.appendElement(trace_37);
							final /*@Thrown*/ @Nullable Boolean m_TC__mapHelper__Operation_atl_atlDefinition_atl_atl_p0 = ValueUtil.TRUE_VALUE;
							raw_when_TC_mapModule = m_TC__mapHelper__Operation_atl_atlDefinition_atl_atl_p0;
						}
						else {
							raw_when_TC_mapModule = ValueUtil.FALSE_VALUE;
						}
						raw_atlModule = raw_when_TC_mapModule;
					}
					else {
						raw_atlModule = ValueUtil.FALSE_VALUE;
					}
					raw_atlHelper = raw_atlModule;
				}
				else {
					raw_atlHelper = ValueUtil.FALSE_VALUE;
				}
				raw_atlDefinition = raw_atlHelper;
			}
			else {
				raw_atlDefinition = ValueUtil.FALSE_VALUE;
			}
			raw_atlFeature = raw_atlDefinition;
		}
		else {
			raw_atlFeature = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_atlFeature ? "done "  : "fail ") + "MAP_m_TC__mapHelper__Operation_atl_atlDefinition_atl_atl_p0");
		}
		return raw_atlFeature;
	}

	/**
	 *
	 * map m_TC__mapIfExp_atl_atlCondition_atl_atlElse_atl_atlE_p0 in ATL2QVTr {
	 * guard:atl atlCondition : OCL::OclExpression[1];
	 * append jm_TC__mapIfExp_1  : trace_ATL2QVTr::TC_mapIfExp[1];
	 * var atlExpression : OCL::IfExp[1] := atlCondition.ifExp1;
	 * var atlElse : OCL::OclExpression[1] := atlExpression.elseExpression;
	 * var atlThen : OCL::OclExpression[1] := atlExpression.thenExpression;
	 * new:middle trace : trace_ATL2QVTr::TC_mapIfExp[1];
	 * set trace.atl_atlCondition := atlCondition;
	 * set trace.atl_atlElse := atlElse;
	 * set trace.atl_atlExpression := atlExpression;
	 * set trace.atl_atlThen := atlThen;
	 * add jm_TC__mapIfExp_1 += trace;
	 *
	 */
	protected boolean MAP_m_TC__mapIfExp_atl_atlCondition_atl_atlElse_atl_atlE_p0(final /*@NonInvalid*/ @NonNull OclExpression atlCondition, final @NonNull Connection jm_TC__mapIfExp_1)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapIfExp_atl_atlCondition_atl_atlElse_atl_atlE_p0" + ", " + atlCondition + ", " + jm_TC__mapIfExp_1);
		}
		final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@Nullable IfExp ifExp1 = atlCondition.getIfExp1();
		final /*@NonInvalid*/ boolean symbol_0 = ifExp1 != null;
		/*@Thrown*/ @Nullable Boolean raw_atlExpression;
		if (symbol_0) {
			if (ifExp1 == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull OclExpression elseExpression = ifExp1.getElseExpression();
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull OclExpression thenExpression = ifExp1.getThenExpression();
			// creations
			final @SuppressWarnings("null")@NonNull TC_mapIfExp trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapIfExp();
			models[0/*middle*/].add(trace_37, false);
			// mapping statements
			trace_37.setAtl_atlCondition(atlCondition);
			trace_37.setAtl_atlElse(elseExpression);
			OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.put(ifExp1, trace_37);
			trace_37.setAtl_atlExpression(ifExp1);
			trace_37.setAtl_atlThen(thenExpression);
			jm_TC__mapIfExp_1.appendElement(trace_37);
			final /*@Thrown*/ @Nullable Boolean m_TC__mapIfExp_atl_atlCondition_atl_atlElse_atl_atlE_p0 = ValueUtil.TRUE_VALUE;
			raw_atlExpression = m_TC__mapIfExp_atl_atlCondition_atl_atlElse_atl_atlE_p0;
		}
		else {
			raw_atlExpression = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_atlExpression ? "done "  : "fail ") + "MAP_m_TC__mapIfExp_atl_atlCondition_atl_atlElse_atl_atlE_p0");
		}
		return raw_atlExpression;
	}

	/**
	 *
	 * map m_TC__mapNavigationOrAttributeCallExp__Helper_atl_at_p0 in ATL2QVTr {
	 *
	 *   guard:atl atlExpression : OCL::NavigationOrAttributeCallExp[1];
	 * append jm_TC__mapNavigationOrAttributeCallExp__Helper_1  : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Helper[1];
	 * var atlModule : ATL::Module[1] := this.getModule(atlExpression)
	 *   ;
	 * var elements : OrderedSet(ATL::ModuleElement) := atlModule.elements;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var _'\u00ABcollect\u00BB' : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(_'1_' | _'1_'.definition)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Attribute) := _'\u00ABcollect\u00BB'->collect(_'1__0' | _'1__0'.feature)
	 *   ->selectByKind(OCL::Attribute)
	 *   ;
	 * var _'\u00ABselect\u00BB' : Sequence(OCL::Attribute) := selectByKind1->select(_'1__1' | _'1__1'.name = atlExpression.name)
	 *   ;
	 * var notEmpty : Boolean[1] := _'\u00ABselect\u00BB'->notEmpty()
	 *   ;
	 * check notEmpty;
	 * var propertyName : String[1] := atlExpression.name;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * var _'\u00ABcollect\u00BB1' : Sequence(OCL::OclFeature) := _'\u00ABcollect\u00BB'->collect(_'1__0' | _'1__0'.feature);
	 * new:middle trace : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Helper[1];
	 * set trace.primitive_propertyName := propertyName;
	 * set trace.atl_atlAttributes := _'\u00ABselect\u00BB';
	 * set trace.atl_atlExpression := atlExpression;
	 * set trace.atl_atlModule := atlModule;
	 * set trace.atl_atlSource := atlSource;
	 * add jm_TC__mapNavigationOrAttributeCallExp__Helper_1 += trace;
	 *
	 */
	protected boolean MAP_m_TC__mapNavigationOrAttributeCallExp__Helper_atl_at_p0(final /*@NonInvalid*/ @NonNull NavigationOrAttributeCallExp atlExpression_9, final @NonNull Connection jm_TC__mapNavigationOrAttributeCallExp__Helper_1)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapNavigationOrAttributeCallExp__Helper_atl_at_p0" + ", " + atlExpression_9 + ", " + jm_TC__mapNavigationOrAttributeCallExp__Helper_1);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @NonNull Module getModule = ((FUN_getModule)FTOR_getModule.getUniqueComputation(this, atlExpression_9)).instance;
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
		@NonNull Iterator<Object> ITERATOR__49___0 = collect.iterator();
		/*@NonInvalid*/ @NonNull SequenceValue collect_0;
		while (true) {
			if (!ITERATOR__49___0.hasNext()) {
				collect_0 = accumulator_0;
				break;
			}
			@SuppressWarnings("null")
			/*@NonInvalid*/ @NonNull OclFeatureDefinition _49___0 = (OclFeatureDefinition)ITERATOR__49___0.next();
			/**
			 * _'1__0'.feature
			 */
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclFeature feature = _49___0.getFeature();
			//
			accumulator_0.add(feature);
		}
		final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_0, TYP_OCL_c_c_Attribute_0);
		/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Attribute);
		@NonNull Iterator<Object> ITERATOR__49___1 = selectByKind_0.iterator();
		/*@NonInvalid*/ @NonNull SequenceValue select;
		while (true) {
			if (!ITERATOR__49___1.hasNext()) {
				select = accumulator_1;
				break;
			}
			@SuppressWarnings("null")
			/*@NonInvalid*/ @NonNull Attribute _49___1 = (Attribute)ITERATOR__49___1.next();
			/**
			 * _'1__1'.name = atlExpression.name
			 */
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name_2 = _49___1.getName();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name_3 = atlExpression_9.getName();
			final /*@NonInvalid*/ boolean eq = name_2.equals(name_3);
			//
			if (eq == ValueUtil.TRUE_VALUE) {
				accumulator_1.add(_49___1);
			}
		}
		final /*@NonInvalid*/ boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(select).booleanValue();
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (notEmpty) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name_4 = atlExpression_9.getName();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression source = atlExpression_9.getSource();
			// creations
			final @SuppressWarnings("null")@NonNull TC_mapNavigationOrAttributeCallExp_Helper trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapNavigationOrAttributeCallExp_Helper();
			models[0/*middle*/].add(trace_37, false);
			// mapping statements
			trace_37.setPrimitive_propertyName(name_4);
			final /*@NonInvalid*/ @NonNull List<Attribute> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Attribute.class, select);
			trace_37.getAtl_atlAttributes().addAll(ECORE_select);
			OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.put(atlExpression_9, trace_37);
			trace_37.setAtl_atlExpression(atlExpression_9);
			trace_37.setAtl_atlModule(getModule);
			trace_37.setAtl_atlSource(source);
			jm_TC__mapNavigationOrAttributeCallExp__Helper_1.appendElement(trace_37);
			final /*@Thrown*/ @Nullable Boolean m_TC__mapNavigationOrAttributeCallExp__Helper_atl_at_p0 = ValueUtil.TRUE_VALUE;
			symbol_7 = m_TC__mapNavigationOrAttributeCallExp__Helper_atl_at_p0;
		}
		else {
			symbol_7 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_m_TC__mapNavigationOrAttributeCallExp__Helper_atl_at_p0");
		}
		return symbol_7;
	}

	/**
	 *
	 * map m_TC__mapNavigationOrAttributeCallExp__Property_atl__p0 in ATL2QVTr {
	 *
	 *   guard:atl atlExpression : OCL::NavigationOrAttributeCallExp[1];
	 * append jm_TC__mapNavigationOrAttributeCallExp__Property_1  : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Property[1];
	 * var atlModule : ATL::Module[1] := this.getModule(atlExpression)
	 *   ;
	 * var elements : OrderedSet(ATL::ModuleElement) := atlModule.elements;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var _'\u00ABcollect\u00BB' : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(_'1_' | _'1_'.definition)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Attribute) := _'\u00ABcollect\u00BB'->collect(_'1__0' | _'1__0'.feature)
	 *   ->selectByKind(OCL::Attribute)
	 *   ;
	 * var _'\u00ABselect\u00BB' : Sequence(OCL::Attribute) := selectByKind1->select(_'1__1' | _'1__1'.name = atlExpression.name)
	 *   ;
	 * var isEmpty : Boolean[1] := _'\u00ABselect\u00BB'->isEmpty()
	 *   ;
	 * check isEmpty;
	 * var propertyName : String[1] := atlExpression.name;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * var _'\u00ABcollect\u00BB1' : Sequence(OCL::OclFeature) := _'\u00ABcollect\u00BB'->collect(_'1__0' | _'1__0'.feature);
	 * new:middle trace : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Property[1];
	 * set trace.primitive_propertyName := propertyName;
	 * set trace.atl_atlAttributes := _'\u00ABselect\u00BB';
	 * set trace.atl_atlExpression := atlExpression;
	 * set trace.atl_atlModule := atlModule;
	 * set trace.atl_atlSource := atlSource;
	 * add jm_TC__mapNavigationOrAttributeCallExp__Property_1 += trace;
	 *
	 */
	protected boolean MAP_m_TC__mapNavigationOrAttributeCallExp__Property_atl__p0(final /*@NonInvalid*/ @NonNull NavigationOrAttributeCallExp atlExpression_10, final @NonNull Connection jm_TC__mapNavigationOrAttributeCallExp__Property_1)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapNavigationOrAttributeCallExp__Property_atl__p0" + ", " + atlExpression_10 + ", " + jm_TC__mapNavigationOrAttributeCallExp__Property_1);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @NonNull Module getModule = ((FUN_getModule)FTOR_getModule.getUniqueComputation(this, atlExpression_10)).instance;
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
		@NonNull Iterator<Object> ITERATOR__49___0 = collect.iterator();
		/*@NonInvalid*/ @NonNull SequenceValue collect_0;
		while (true) {
			if (!ITERATOR__49___0.hasNext()) {
				collect_0 = accumulator_0;
				break;
			}
			@SuppressWarnings("null")
			/*@NonInvalid*/ @NonNull OclFeatureDefinition _49___0 = (OclFeatureDefinition)ITERATOR__49___0.next();
			/**
			 * _'1__0'.feature
			 */
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclFeature feature = _49___0.getFeature();
			//
			accumulator_0.add(feature);
		}
		final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_0, TYP_OCL_c_c_Attribute_0);
		/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Attribute);
		@NonNull Iterator<Object> ITERATOR__49___1 = selectByKind_0.iterator();
		/*@NonInvalid*/ @NonNull SequenceValue select;
		while (true) {
			if (!ITERATOR__49___1.hasNext()) {
				select = accumulator_1;
				break;
			}
			@SuppressWarnings("null")
			/*@NonInvalid*/ @NonNull Attribute _49___1 = (Attribute)ITERATOR__49___1.next();
			/**
			 * _'1__1'.name = atlExpression.name
			 */
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name_2 = _49___1.getName();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name_3 = atlExpression_10.getName();
			final /*@NonInvalid*/ boolean eq = name_2.equals(name_3);
			//
			if (eq == ValueUtil.TRUE_VALUE) {
				accumulator_1.add(_49___1);
			}
		}
		final /*@NonInvalid*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(select).booleanValue();
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (isEmpty) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String name_4 = atlExpression_10.getName();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression source = atlExpression_10.getSource();
			// creations
			final @SuppressWarnings("null")@NonNull TC_mapNavigationOrAttributeCallExp_Property trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapNavigationOrAttributeCallExp_Property();
			models[0/*middle*/].add(trace_37, false);
			// mapping statements
			trace_37.setPrimitive_propertyName(name_4);
			final /*@NonInvalid*/ @NonNull List<Attribute> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Attribute.class, select);
			trace_37.getAtl_atlAttributes().addAll(ECORE_select);
			OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.put(atlExpression_10, trace_37);
			trace_37.setAtl_atlExpression(atlExpression_10);
			trace_37.setAtl_atlModule(getModule);
			trace_37.setAtl_atlSource(source);
			jm_TC__mapNavigationOrAttributeCallExp__Property_1.appendElement(trace_37);
			final /*@Thrown*/ @Nullable Boolean m_TC__mapNavigationOrAttributeCallExp__Property_atl__p0 = ValueUtil.TRUE_VALUE;
			symbol_7 = m_TC__mapNavigationOrAttributeCallExp__Property_atl__p0;
		}
		else {
			symbol_7 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_m_TC__mapNavigationOrAttributeCallExp__Property_atl__p0");
		}
		return symbol_7;
	}

	/**
	 *
	 * map m_TC__mapOperationCallExp__Helper_atl_atlExpression__p0 in ATL2QVTr {
	 *
	 *   guard:atl atlExpression : OCL::OperationCallExp[1];
	 * append jm_TC__mapOperationCallExp__Helper_1  : trace_ATL2QVTr::TC_mapOperationCallExp_Helper[1];
	 * var _'not' : Boolean[?] := not atlExpression.oclIsKindOf(OCL::OperatorCallExp)
	 *   ;
	 * check _'not';
	 * var atlModule : ATL::Module[1] := this.getModule(atlExpression)
	 *   ;
	 * var elements : OrderedSet(ATL::ModuleElement) := atlModule.elements;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var _'\u00ABcollect\u00BB' : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(_'1_' | _'1_'.definition)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Operation) := _'\u00ABcollect\u00BB'->collect(_'1__0' | _'1__0'.feature)
	 *   ->selectByKind(OCL::Operation)
	 *   ;
	 * var _'\u00ABselect\u00BB' : Sequence(OCL::Operation) := selectByKind1->select(_'1__1' | _'1__1'.name = atlExpression.operationName)
	 *   ;
	 * var notEmpty : Boolean[1] := _'\u00ABselect\u00BB'->notEmpty()
	 *   ;
	 * check notEmpty;
	 * var operationName : String[1] := atlExpression.operationName;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * var _'oclIsKindOf\\nOCL::OperatorCallExp' : Boolean[1] := atlExpression.oclIsKindOf(OCL::OperatorCallExp)
	 *   ;
	 * var _'\u00ABcollect\u00BB1' : Sequence(OCL::OclFeature) := _'\u00ABcollect\u00BB'->collect(_'1__0' | _'1__0'.feature);
	 * new:middle trace : trace_ATL2QVTr::TC_mapOperationCallExp_Helper[1];
	 * set trace.primitive_operationName := operationName;
	 * set trace.atl_atlOperations := _'\u00ABselect\u00BB';
	 * set trace.atl_atlExpression := atlExpression;
	 * set trace.atl_atlModule := atlModule;
	 * set trace.atl_atlSource := atlSource;
	 * add jm_TC__mapOperationCallExp__Helper_1 += trace;
	 *
	 */
	protected boolean MAP_m_TC__mapOperationCallExp__Helper_atl_atlExpression__p0(final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull OperationCallExp atlExpression_11, final org.eclipse.qvtd.runtime.evaluation.@org.eclipse.jdt.annotation.NonNull Connection jm_TC__mapOperationCallExp__Helper_1)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOperationCallExp__Helper_atl_atlExpression__p0" + ", " + atlExpression_11 + ", " + jm_TC__mapOperationCallExp__Helper_1);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_OperatorCallExp_0 = idResolver.getClass(CLSSid_OperatorCallExp, null);
		final /*@NonInvalid*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, atlExpression_11, TYP_OCL_c_c_OperatorCallExp_0).booleanValue();
		final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
		if (not == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_8;
		if (not) {
			final /*@NonInvalid*/ @NonNull Module getModule = ((FUN_getModule)FTOR_getModule.getUniqueComputation(this, atlExpression_11)).instance;
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
			@NonNull Iterator<Object> ITERATOR__49___0 = collect.iterator();
			/*@NonInvalid*/ @NonNull SequenceValue collect_0;
			while (true) {
				if (!ITERATOR__49___0.hasNext()) {
					collect_0 = accumulator_0;
					break;
				}
				@SuppressWarnings("null")
				/*@NonInvalid*/ @NonNull OclFeatureDefinition _49___0 = (OclFeatureDefinition)ITERATOR__49___0.next();
				/**
				 * _'1__0'.feature
				 */
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclFeature feature = _49___0.getFeature();
				//
				accumulator_0.add(feature);
			}
			final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_0, TYP_OCL_c_c_Operation_0);
			/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
			@NonNull Iterator<Object> ITERATOR__49___1 = selectByKind_0.iterator();
			/*@NonInvalid*/ @NonNull SequenceValue select;
			while (true) {
				if (!ITERATOR__49___1.hasNext()) {
					select = accumulator_1;
					break;
				}
				@SuppressWarnings("null")
				/*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation _49___1 = (org.eclipse.m2m.atl.common.OCL.Operation)ITERATOR__49___1.next();
				/**
				 * _'1__1'.name = atlExpression.operationName
				 */
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String name_2 = _49___1.getName();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String operationName = atlExpression_11.getOperationName();
				final /*@NonInvalid*/ boolean eq = name_2.equals(operationName);
				//
				if (eq == ValueUtil.TRUE_VALUE) {
					accumulator_1.add(_49___1);
				}
			}
			final /*@NonInvalid*/ boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(select).booleanValue();
			/*@Thrown*/ @Nullable Boolean symbol_7;
			if (notEmpty) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String operationName_0 = atlExpression_11.getOperationName();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression source = atlExpression_11.getSource();
				// creations
				final @SuppressWarnings("null")@NonNull TC_mapOperationCallExp_Helper trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapOperationCallExp_Helper();
				models[0/*middle*/].add(trace_37, false);
				// mapping statements
				trace_37.setPrimitive_operationName(operationName_0);
				final /*@NonInvalid*/ @NonNull List<org.eclipse.m2m.atl.common.OCL.Operation> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.m2m.atl.common.OCL.Operation.class, select);
				trace_37.getAtl_atlOperations().addAll(ECORE_select);
				OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.put(atlExpression_11, trace_37);
				trace_37.setAtl_atlExpression(atlExpression_11);
				trace_37.setAtl_atlModule(getModule);
				trace_37.setAtl_atlSource(source);
				jm_TC__mapOperationCallExp__Helper_1.appendElement(trace_37);
				final /*@Thrown*/ @Nullable Boolean m_TC__mapOperationCallExp__Helper_atl_atlExpression__p0 = ValueUtil.TRUE_VALUE;
				symbol_7 = m_TC__mapOperationCallExp__Helper_atl_atlExpression__p0;
			}
			else {
				symbol_7 = ValueUtil.FALSE_VALUE;
			}
			symbol_8 = symbol_7;
		}
		else {
			symbol_8 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_8 ? "done "  : "fail ") + "MAP_m_TC__mapOperationCallExp__Helper_atl_atlExpression__p0");
		}
		return symbol_8;
	}

	/**
	 *
	 * map m_TC__mapOperationCallExp__Operation_atl_atlExpressi_p0 in ATL2QVTr {
	 *
	 *   guard:atl atlExpression : OCL::OperationCallExp[1];
	 * append jm_TC__mapOperationCallExp__Operation_1  : trace_ATL2QVTr::TC_mapOperationCallExp_Operation[1];
	 * var _'not' : Boolean[?] := not atlExpression.oclIsKindOf(OCL::OperatorCallExp)
	 *   ;
	 * check _'not';
	 * var atlModule : ATL::Module[1] := this.getModule(atlExpression)
	 *   ;
	 * var elements : OrderedSet(ATL::ModuleElement) := atlModule.elements;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var _'\u00ABcollect\u00BB' : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(_'1_' | _'1_'.definition)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Operation) := _'\u00ABcollect\u00BB'->collect(_'1__0' | _'1__0'.feature)
	 *   ->selectByKind(OCL::Operation)
	 *   ;
	 * var _'\u00ABselect\u00BB' : Sequence(OCL::Operation) := selectByKind1->select(_'1__1' | _'1__1'.name = atlExpression.operationName)
	 *   ;
	 * var isEmpty : Boolean[1] := _'\u00ABselect\u00BB'->isEmpty()
	 *   ;
	 * check isEmpty;
	 * var operationName : String[1] := atlExpression.operationName;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * var _'oclIsKindOf\\nOCL::OperatorCallExp' : Boolean[1] := atlExpression.oclIsKindOf(OCL::OperatorCallExp)
	 *   ;
	 * var _'\u00ABcollect\u00BB1' : Sequence(OCL::OclFeature) := _'\u00ABcollect\u00BB'->collect(_'1__0' | _'1__0'.feature);
	 * new:middle trace : trace_ATL2QVTr::TC_mapOperationCallExp_Operation[1];
	 * set trace.primitive_operationName := operationName;
	 * set trace.atl_atlOperations := _'\u00ABselect\u00BB';
	 * set trace.atl_atlExpression := atlExpression;
	 * set trace.atl_atlModule := atlModule;
	 * set trace.atl_atlSource := atlSource;
	 * add jm_TC__mapOperationCallExp__Operation_1 += trace;
	 *
	 */
	protected boolean MAP_m_TC__mapOperationCallExp__Operation_atl_atlExpressi_p0(final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull OperationCallExp atlExpression_12, final org.eclipse.qvtd.runtime.evaluation.@org.eclipse.jdt.annotation.NonNull Connection jm_TC__mapOperationCallExp__Operation_1)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOperationCallExp__Operation_atl_atlExpressi_p0" + ", " + atlExpression_12 + ", " + jm_TC__mapOperationCallExp__Operation_1);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_OperatorCallExp_0 = idResolver.getClass(CLSSid_OperatorCallExp, null);
		final /*@NonInvalid*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, atlExpression_12, TYP_OCL_c_c_OperatorCallExp_0).booleanValue();
		final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
		if (not == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_8;
		if (not) {
			final /*@NonInvalid*/ @NonNull Module getModule = ((FUN_getModule)FTOR_getModule.getUniqueComputation(this, atlExpression_12)).instance;
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
			@NonNull Iterator<Object> ITERATOR__49___0 = collect.iterator();
			/*@NonInvalid*/ @NonNull SequenceValue collect_0;
			while (true) {
				if (!ITERATOR__49___0.hasNext()) {
					collect_0 = accumulator_0;
					break;
				}
				@SuppressWarnings("null")
				/*@NonInvalid*/ @NonNull OclFeatureDefinition _49___0 = (OclFeatureDefinition)ITERATOR__49___0.next();
				/**
				 * _'1__0'.feature
				 */
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclFeature feature = _49___0.getFeature();
				//
				accumulator_0.add(feature);
			}
			final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_0, TYP_OCL_c_c_Operation_0);
			/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
			@NonNull Iterator<Object> ITERATOR__49___1 = selectByKind_0.iterator();
			/*@NonInvalid*/ @NonNull SequenceValue select;
			while (true) {
				if (!ITERATOR__49___1.hasNext()) {
					select = accumulator_1;
					break;
				}
				@SuppressWarnings("null")
				/*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation _49___1 = (org.eclipse.m2m.atl.common.OCL.Operation)ITERATOR__49___1.next();
				/**
				 * _'1__1'.name = atlExpression.operationName
				 */
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String name_2 = _49___1.getName();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String operationName = atlExpression_12.getOperationName();
				final /*@NonInvalid*/ boolean eq = name_2.equals(operationName);
				//
				if (eq == ValueUtil.TRUE_VALUE) {
					accumulator_1.add(_49___1);
				}
			}
			final /*@NonInvalid*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(select).booleanValue();
			/*@Thrown*/ @Nullable Boolean symbol_7;
			if (isEmpty) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String operationName_0 = atlExpression_12.getOperationName();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression source = atlExpression_12.getSource();
				// creations
				final @SuppressWarnings("null")@NonNull TC_mapOperationCallExp_Operation trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapOperationCallExp_Operation();
				models[0/*middle*/].add(trace_37, false);
				// mapping statements
				trace_37.setPrimitive_operationName(operationName_0);
				final /*@NonInvalid*/ @NonNull List<org.eclipse.m2m.atl.common.OCL.Operation> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.m2m.atl.common.OCL.Operation.class, select);
				trace_37.getAtl_atlOperations().addAll(ECORE_select);
				OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.put(atlExpression_12, trace_37);
				trace_37.setAtl_atlExpression(atlExpression_12);
				trace_37.setAtl_atlModule(getModule);
				trace_37.setAtl_atlSource(source);
				jm_TC__mapOperationCallExp__Operation_1.appendElement(trace_37);
				final /*@Thrown*/ @Nullable Boolean m_TC__mapOperationCallExp__Operation_atl_atlExpressi_p0 = ValueUtil.TRUE_VALUE;
				symbol_7 = m_TC__mapOperationCallExp__Operation_atl_atlExpressi_p0;
			}
			else {
				symbol_7 = ValueUtil.FALSE_VALUE;
			}
			symbol_8 = symbol_7;
		}
		else {
			symbol_8 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_8 ? "done "  : "fail ") + "MAP_m_TC__mapOperationCallExp__Operation_atl_atlExpressi_p0");
		}
		return symbol_8;
	}

	/**
	 *
	 * map m_TC__mapOperatorCallExp_atl_atlExpression_atl_atlSo_p0 in ATL2QVTr {
	 * guard:atl atlExpression : OCL::OperatorCallExp[1];
	 * append jm_TC__mapOperatorCallExp_1  : trace_ATL2QVTr::TC_mapOperatorCallExp[1];
	 * var operationName : String[1] := atlExpression.operationName;
	 * var atlSource : OCL::OclExpression[1] := atlExpression.source;
	 * new:middle trace : trace_ATL2QVTr::TC_mapOperatorCallExp[1];
	 * set trace.primitive_operationName := operationName;
	 * set trace.atl_atlExpression := atlExpression;
	 * set trace.atl_atlSource := atlSource;
	 * add jm_TC__mapOperatorCallExp_1 += trace;
	 *
	 */
	protected boolean MAP_m_TC__mapOperatorCallExp_atl_atlExpression_atl_atlSo_p0(final /*@NonInvalid*/ @NonNull OperatorCallExp atlExpression_13, final @NonNull Connection jm_TC__mapOperatorCallExp_1)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOperatorCallExp_atl_atlExpression_atl_atlSo_p0" + ", " + atlExpression_13 + ", " + jm_TC__mapOperatorCallExp_1);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String operationName = atlExpression_13.getOperationName();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression source = atlExpression_13.getSource();
		// creations
		final @SuppressWarnings("null")@NonNull TC_mapOperatorCallExp trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapOperatorCallExp();
		models[0/*middle*/].add(trace_37, false);
		// mapping statements
		trace_37.setPrimitive_operationName(operationName);
		OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.put(atlExpression_13, trace_37);
		trace_37.setAtl_atlExpression(atlExpression_13);
		trace_37.setAtl_atlSource(source);
		jm_TC__mapOperatorCallExp_1.appendElement(trace_37);
		final /*@Thrown*/ @Nullable Boolean m_TC__mapOperatorCallExp_atl_atlExpression_atl_atlSo_p0 = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((m_TC__mapOperatorCallExp_atl_atlExpression_atl_atlSo_p0 ? "done "  : "fail ") + "MAP_m_TC__mapOperatorCallExp_atl_atlExpression_atl_atlSo_p0");
		}
		return m_TC__mapOperatorCallExp_atl_atlExpression_atl_atlSo_p0;
	}

	/**
	 *
	 * map m_TC__mapHelper__Attribute_invocation_mapHelper_Cont_p1 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapHelper_Attribute[1] success status;
	 * append jm_TC__mapHelper__Attribute  : trace_ATL2QVTr::TC_mapHelper_Attribute[1];
	 * var atlExpression : OCL::OclExpression[1] := trace.atl_atlExpression;
	 * var atlHelper : ATL::Helper[1] := trace.atl_atlHelper;
	 * var when_TI_mapOclExpression : trace_ATL2QVTr::TI_mapOclExpression[1] := atlExpression.TI_mapOclExpression;
	 * new:middle where_TC_mapHelper_Context : trace_ATL2QVTr::TC_mapHelper_Context[1];
	 * set where_TC_mapHelper_Context.atl_atlHelper := atlHelper;
	 * set trace.invocation_mapHelper_Context := where_TC_mapHelper_Context;
	 * add jm_TC__mapHelper__Attribute += trace;
	 *
	 */
	protected boolean MAP_m_TC__mapHelper__Attribute_invocation_mapHelper_Cont_p1(final @NonNull Connection jm_TC__mapHelper__Attribute, final /*@NonInvalid*/ @NonNull TC_mapHelper_Attribute trace)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapHelper__Attribute_invocation_mapHelper_Cont_p1" + ", " + jm_TC__mapHelper__Attribute + ", " + trace);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression atl_atlExpression = trace.getAtl_atlExpression();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Helper atl_atlHelper = trace.getAtl_atlHelper();
		final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlExpression);
		final /*@NonInvalid*/ boolean symbol_0 = TI_mapOclExpression != null;
		/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression;
		if (symbol_0) {
			if (TI_mapOclExpression == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			// creations
			final @SuppressWarnings("null")@NonNull TC_mapHelper_Context where_TC_mapHelper_Context = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapHelper_Context();
			models[0/*middle*/].add(where_TC_mapHelper_Context, false);
			// mapping statements
			OPPOSITE_OF_TC_mapHelper_Context_atl_atlHelper.put(atl_atlHelper, where_TC_mapHelper_Context);
			where_TC_mapHelper_Context.setAtl_atlHelper(atl_atlHelper);
			trace.setInvocation_mapHelper_Context(where_TC_mapHelper_Context);
			jm_TC__mapHelper__Attribute.appendElement(trace);
			final /*@Thrown*/ @Nullable Boolean m_TC__mapHelper__Attribute_invocation_mapHelper_Cont_p1 = ValueUtil.TRUE_VALUE;
			raw_when_TI_mapOclExpression = m_TC__mapHelper__Attribute_invocation_mapHelper_Cont_p1;
		}
		else {
			raw_when_TI_mapOclExpression = ValueUtil.FALSE_VALUE;
		}
		trace.setStatus(raw_when_TI_mapOclExpression);
		if (raw_when_TI_mapOclExpression) {
			objectManager.assigned(trace, trace_ATL2QVTrPackage.Literals.TI_MAP_HELPER__STATUS, raw_when_TI_mapOclExpression);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_TI_mapOclExpression ? "done "  : "fail ") + "MAP_m_TC__mapHelper__Attribute_invocation_mapHelper_Cont_p1");
		}
		return raw_when_TI_mapOclExpression;
	}

	/**
	 *
	 * map m_TC__mapHelper__Attribute_qvtr_qvtrFunction_p2 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TC_mapHelper_Attribute[1];
	 * check trace.status;
	 * var atlType : OCL::OclType[1] := trace.atl_atlType;
	 * var attributeName : String[1] := trace.primitive_attributeName;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := trace.qvtr_qvtrTransformation;
	 * var getType1 : Class[1] := this.getType(atlType);
	 * contained new:qvtr qvtrFunction : qvtbase::Function[1];
	 * set qvtrFunction.name := attributeName;
	 * set qvtrFunction.owningClass := qvtrTransformation;
	 * set qvtrFunction.type := getType1;
	 * set trace.qvtr_qvtrFunction := qvtrFunction;
	 *
	 */
	protected boolean MAP_m_TC__mapHelper__Attribute_qvtr_qvtrFunction_p2(final /*@NonInvalid*/ @NonNull TC_mapHelper_Attribute trace_0)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapHelper__Attribute_qvtr_qvtrFunction_p2" + ", " + trace_0);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_0.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_5;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclType atl_atlType = trace_0.getAtl_atlType();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String primitive_attributeName = trace_0.getPrimitive_attributeName();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull RelationalTransformation qvtr_qvtrTransformation = trace_0.getQvtr_qvtrTransformation();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(this, atl_atlType)).instance;
			// creations
			final @NonNull Function qvtrFunction = QVTbaseFactory.eINSTANCE.createFunction();
			models[2/*qvtr*/].add(qvtrFunction, true);
			// mapping statements
			qvtrFunction.setName(primitive_attributeName);
			qvtrFunction.setOwningClass(qvtr_qvtrTransformation);
			qvtrFunction.setType(getType);
			trace_0.setQvtr_qvtrFunction(qvtrFunction);
			final /*@Thrown*/ @Nullable Boolean m_TC__mapHelper__Attribute_qvtr_qvtrFunction_p2 = ValueUtil.TRUE_VALUE;
			symbol_5 = m_TC__mapHelper__Attribute_qvtr_qvtrFunction_p2;
		}
		else {
			symbol_5 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_5 ? "done "  : "fail ") + "MAP_m_TC__mapHelper__Attribute_qvtr_qvtrFunction_p2");
		}
		return symbol_5;
	}

	/**
	 *
	 * map m_TC__mapHelper__Operation_invocation_mapHelper_Cont_p1 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapHelper_Operation[1] success status;
	 * append jm_TC__mapHelper__Operation  : trace_ATL2QVTr::TC_mapHelper_Operation[1];
	 * var atlExpression : OCL::OclExpression[1] := trace.atl_atlExpression;
	 * var atlHelper : ATL::Helper[1] := trace.atl_atlHelper;
	 * var when_TI_mapOclExpression : trace_ATL2QVTr::TI_mapOclExpression[1] := atlExpression.TI_mapOclExpression;
	 * new:middle where_TC_mapHelper_Context : trace_ATL2QVTr::TC_mapHelper_Context[1];
	 * set trace.invocation_mapHelper_Context := where_TC_mapHelper_Context;
	 * set where_TC_mapHelper_Context.atl_atlHelper := atlHelper;
	 * add jm_TC__mapHelper__Operation += trace;
	 *
	 */
	protected boolean MAP_m_TC__mapHelper__Operation_invocation_mapHelper_Cont_p1(final @NonNull Connection jm_TC__mapHelper__Operation, final /*@NonInvalid*/ @NonNull TC_mapHelper_Operation trace_1)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapHelper__Operation_invocation_mapHelper_Cont_p1" + ", " + jm_TC__mapHelper__Operation + ", " + trace_1);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression atl_atlExpression = trace_1.getAtl_atlExpression();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Helper atl_atlHelper = trace_1.getAtl_atlHelper();
		final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlExpression);
		final /*@NonInvalid*/ boolean symbol_0 = TI_mapOclExpression != null;
		/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression;
		if (symbol_0) {
			if (TI_mapOclExpression == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			// creations
			final @SuppressWarnings("null")@NonNull TC_mapHelper_Context where_TC_mapHelper_Context = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapHelper_Context();
			models[0/*middle*/].add(where_TC_mapHelper_Context, false);
			// mapping statements
			trace_1.setInvocation_mapHelper_Context(where_TC_mapHelper_Context);
			OPPOSITE_OF_TC_mapHelper_Context_atl_atlHelper.put(atl_atlHelper, where_TC_mapHelper_Context);
			where_TC_mapHelper_Context.setAtl_atlHelper(atl_atlHelper);
			jm_TC__mapHelper__Operation.appendElement(trace_1);
			final /*@Thrown*/ @Nullable Boolean m_TC__mapHelper__Operation_invocation_mapHelper_Cont_p1 = ValueUtil.TRUE_VALUE;
			raw_when_TI_mapOclExpression = m_TC__mapHelper__Operation_invocation_mapHelper_Cont_p1;
		}
		else {
			raw_when_TI_mapOclExpression = ValueUtil.FALSE_VALUE;
		}
		trace_1.setStatus(raw_when_TI_mapOclExpression);
		if (raw_when_TI_mapOclExpression) {
			objectManager.assigned(trace_1, trace_ATL2QVTrPackage.Literals.TI_MAP_HELPER__STATUS, raw_when_TI_mapOclExpression);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_TI_mapOclExpression ? "done "  : "fail ") + "MAP_m_TC__mapHelper__Operation_invocation_mapHelper_Cont_p1");
		}
		return raw_when_TI_mapOclExpression;
	}

	/**
	 *
	 * map m_TC__mapHelper__Operation_qvtr_qvtrFunction_p2 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TC_mapHelper_Operation[1];
	 * check trace.status;
	 * var atlType : OCL::OclType[1] := trace.atl_atlType;
	 * var operationName : String[1] := trace.primitive_operationName;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := trace.qvtr_qvtrTransformation;
	 * var getType1 : Class[1] := this.getType(atlType);
	 * contained new:qvtr qvtrFunction : qvtbase::Function[1];
	 * set qvtrFunction.name := operationName;
	 * set qvtrFunction.owningClass := qvtrTransformation;
	 * set qvtrFunction.type := getType1;
	 * set trace.qvtr_qvtrFunction := qvtrFunction;
	 *
	 */
	protected boolean MAP_m_TC__mapHelper__Operation_qvtr_qvtrFunction_p2(final /*@NonInvalid*/ @NonNull TC_mapHelper_Operation trace_2)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapHelper__Operation_qvtr_qvtrFunction_p2" + ", " + trace_2);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_2.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_5;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclType atl_atlType = trace_2.getAtl_atlType();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String primitive_operationName = trace_2.getPrimitive_operationName();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull RelationalTransformation qvtr_qvtrTransformation = trace_2.getQvtr_qvtrTransformation();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(this, atl_atlType)).instance;
			// creations
			final @NonNull Function qvtrFunction = QVTbaseFactory.eINSTANCE.createFunction();
			models[2/*qvtr*/].add(qvtrFunction, true);
			// mapping statements
			qvtrFunction.setName(primitive_operationName);
			qvtrFunction.setOwningClass(qvtr_qvtrTransformation);
			qvtrFunction.setType(getType);
			trace_2.setQvtr_qvtrFunction(qvtrFunction);
			final /*@Thrown*/ @Nullable Boolean m_TC__mapHelper__Operation_qvtr_qvtrFunction_p2 = ValueUtil.TRUE_VALUE;
			symbol_5 = m_TC__mapHelper__Operation_qvtr_qvtrFunction_p2;
		}
		else {
			symbol_5 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_5 ? "done "  : "fail ") + "MAP_m_TC__mapHelper__Operation_qvtr_qvtrFunction_p2");
		}
		return symbol_5;
	}

	/**
	 *
	 * map m_TC__mapHelper__Attribute__TC_mapHelper_Context_qvt_p4 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapHelper_Attribute[1];
	 * check trace.status;
	 * var where_TC_mapHelper_Context : trace_ATL2QVTr::TC_mapHelper_Context[1] := trace.invocation_mapHelper_Context;
	 * var qvtrFunction : qvtbase::Function[1] := trace.qvtr_qvtrFunction;
	 * set where_TC_mapHelper_Context.qvtr_qvtrFunction := qvtrFunction;
	 *
	 */
	protected boolean MAP_m_TC__mapHelper__Attribute__TC_mapHelper_Context_qvt_p4(final /*@NonInvalid*/ @NonNull TC_mapHelper_Attribute trace_3)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapHelper__Attribute__TC_mapHelper_Context_qvt_p4" + ", " + trace_3);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_3.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_3;
		if (status) {
			final /*@NonInvalid*/ @Nullable TC_mapHelper_Context invocation_mapHelper_Context = trace_3.getInvocation_mapHelper_Context();
			final /*@NonInvalid*/ boolean symbol_0 = invocation_mapHelper_Context != null;
			/*@Thrown*/ @Nullable Boolean raw_where_TC_mapHelper_Context;
			if (symbol_0) {
				if (invocation_mapHelper_Context == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Function qvtr_qvtrFunction = trace_3.getQvtr_qvtrFunction();
				// mapping statements
				invocation_mapHelper_Context.setQvtr_qvtrFunction(qvtr_qvtrFunction);
				final /*@Thrown*/ @Nullable Boolean m_TC__mapHelper__Attribute__TC_mapHelper_Context_qvt_p4 = ValueUtil.TRUE_VALUE;
				raw_where_TC_mapHelper_Context = m_TC__mapHelper__Attribute__TC_mapHelper_Context_qvt_p4;
			}
			else {
				raw_where_TC_mapHelper_Context = ValueUtil.FALSE_VALUE;
			}
			symbol_3 = raw_where_TC_mapHelper_Context;
		}
		else {
			symbol_3 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_3 ? "done "  : "fail ") + "MAP_m_TC__mapHelper__Attribute__TC_mapHelper_Context_qvt_p4");
		}
		return symbol_3;
	}

	/**
	 *
	 * map m_TC__mapHelper__Operation__TC_mapHelper_Context_qvt_p4 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapHelper_Operation[1];
	 * check trace.status;
	 * var where_TC_mapHelper_Context : trace_ATL2QVTr::TC_mapHelper_Context[1] := trace.invocation_mapHelper_Context;
	 * var qvtrFunction : qvtbase::Function[1] := trace.qvtr_qvtrFunction;
	 * set where_TC_mapHelper_Context.qvtr_qvtrFunction := qvtrFunction;
	 *
	 */
	protected boolean MAP_m_TC__mapHelper__Operation__TC_mapHelper_Context_qvt_p4(final /*@NonInvalid*/ @NonNull TC_mapHelper_Operation trace_4)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapHelper__Operation__TC_mapHelper_Context_qvt_p4" + ", " + trace_4);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_4.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_3;
		if (status) {
			final /*@NonInvalid*/ @Nullable TC_mapHelper_Context invocation_mapHelper_Context = trace_4.getInvocation_mapHelper_Context();
			final /*@NonInvalid*/ boolean symbol_0 = invocation_mapHelper_Context != null;
			/*@Thrown*/ @Nullable Boolean raw_where_TC_mapHelper_Context;
			if (symbol_0) {
				if (invocation_mapHelper_Context == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Function qvtr_qvtrFunction = trace_4.getQvtr_qvtrFunction();
				// mapping statements
				invocation_mapHelper_Context.setQvtr_qvtrFunction(qvtr_qvtrFunction);
				final /*@Thrown*/ @Nullable Boolean m_TC__mapHelper__Operation__TC_mapHelper_Context_qvt_p4 = ValueUtil.TRUE_VALUE;
				raw_where_TC_mapHelper_Context = m_TC__mapHelper__Operation__TC_mapHelper_Context_qvt_p4;
			}
			else {
				raw_where_TC_mapHelper_Context = ValueUtil.FALSE_VALUE;
			}
			symbol_3 = raw_where_TC_mapHelper_Context;
		}
		else {
			symbol_3 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_3 ? "done "  : "fail ") + "MAP_m_TC__mapHelper__Operation__TC_mapHelper_Context_qvt_p4");
		}
		return symbol_3;
	}

	/**
	 *
	 * map m_TC__mapHelper__Context_atl_atlContext_atl_atlDefin in ATL2QVTr {
	 *
	 *   guard:atl atlContext : OCL::OclContextDefinition[1];
	 * var atlReturnType : OCL::OclType[1] := atlContext.context_;
	 * var atlDefinition : OCL::OclFeatureDefinition[1] := atlContext.definition;
	 * var atlHelper : ATL::Helper[1] := atlDefinition.Helper;
	 * var trace : trace_ATL2QVTr::TC_mapHelper_Context[1] := atlHelper.TC_mapHelper_Context;
	 * var qvtrFunction : qvtbase::Function[1] := trace.qvtr_qvtrFunction;
	 * var getType1 : Class[1] := this.getType(atlReturnType);
	 * new:qvtr qvtrParameter : qvtbase::FunctionParameter[1];
	 * new:middle where_TC_mapVariable : trace_ATL2QVTr::TC_mapVariable[1];
	 * set qvtrParameter.name := 'self';
	 * set qvtrFunction.ownedParameters := qvtrParameter;
	 * set qvtrParameter.type := getType1;
	 * set trace.atl_atlContext := atlContext;
	 * set trace.atl_atlDefinition := atlDefinition;
	 * set trace.atl_atlReturnType := atlReturnType;
	 * set trace.invocation_mapVariable := where_TC_mapVariable;
	 * set trace.qvtr_qvtrParameter := qvtrParameter;
	 * set where_TC_mapVariable.atl_atlVariable := atlHelper;
	 * set where_TC_mapVariable.qvtr_qvtrVariable := qvtrParameter;
	 *
	 */
	protected boolean MAP_m_TC__mapHelper__Context_atl_atlContext_atl_atlDefin(final /*@NonInvalid*/ @NonNull OclContextDefinition atlContext)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapHelper__Context_atl_atlContext_atl_atlDefin" + ", " + atlContext);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclType context_ = atlContext.getContext_();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition = atlContext.getDefinition();
		final /*@NonInvalid*/ @NonNull UnboxedCompositionProperty IMPPROPid_definition = new UnboxedCompositionProperty(PROPid_definition);
		final /*@NonInvalid*/ @Nullable Helper Helper = (Helper)IMPPROPid_definition.evaluate(executor, CLSSid_Helper, definition);
		final /*@NonInvalid*/ boolean symbol_0 = Helper != null;
		/*@Thrown*/ @Nullable Boolean raw_atlHelper;
		if (symbol_0) {
			if (Helper == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable TC_mapHelper_Context TC_mapHelper_Context = OPPOSITE_OF_TC_mapHelper_Context_atl_atlHelper.get(Helper);
			final /*@Thrown*/ boolean symbol_1 = TC_mapHelper_Context != null;
			/*@Thrown*/ @Nullable Boolean raw_trace;
			if (symbol_1) {
				if (TC_mapHelper_Context == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull Function qvtr_qvtrFunction = TC_mapHelper_Context.getQvtr_qvtrFunction();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class getType = ((FUN_getType)FTOR_getType.getUniqueComputation(this, context_)).instance;
				// creations
				final @NonNull FunctionParameter qvtrParameter = QVTbaseFactory.eINSTANCE.createFunctionParameter();
				models[2/*qvtr*/].add(qvtrParameter, false);
				final @SuppressWarnings("null")@NonNull TC_mapVariable where_TC_mapVariable = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapVariable();
				models[0/*middle*/].add(where_TC_mapVariable, false);
				// mapping statements
				qvtrParameter.setName(STR_self);
				qvtr_qvtrFunction.getOwnedParameters().add(qvtrParameter);
				qvtrParameter.setType(getType);
				TC_mapHelper_Context.setAtl_atlContext(atlContext);
				TC_mapHelper_Context.setAtl_atlDefinition(definition);
				TC_mapHelper_Context.setAtl_atlReturnType(context_);
				TC_mapHelper_Context.setInvocation_mapVariable(where_TC_mapVariable);
				TC_mapHelper_Context.setQvtr_qvtrParameter(qvtrParameter);
				OPPOSITE_OF_TC_mapVariable_atl_atlVariable.put(Helper, where_TC_mapVariable);
				where_TC_mapVariable.setAtl_atlVariable(Helper);
				where_TC_mapVariable.setQvtr_qvtrVariable(qvtrParameter);
				final /*@Thrown*/ @Nullable Boolean m_TC__mapHelper__Context_atl_atlContext_atl_atlDefin = ValueUtil.TRUE_VALUE;
				raw_trace = m_TC__mapHelper__Context_atl_atlContext_atl_atlDefin;
			}
			else {
				raw_trace = ValueUtil.FALSE_VALUE;
			}
			raw_atlHelper = raw_trace;
		}
		else {
			raw_atlHelper = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_atlHelper ? "done "  : "fail ") + "MAP_m_TC__mapHelper__Context_atl_atlContext_atl_atlDefin");
		}
		return raw_atlHelper;
	}

	/**
	 *
	 * map m_TC__mapIfExp_status_p1 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapIfExp[1] success status;
	 * append jm_TC__mapIfExp  : trace_ATL2QVTr::TC_mapIfExp[1];
	 * var atlCondition : OCL::OclExpression[1] := trace.atl_atlCondition;
	 * var atlElse : OCL::OclExpression[1] := trace.atl_atlElse;
	 * var atlThen : OCL::OclExpression[1] := trace.atl_atlThen;
	 * var when_TI_mapOclExpression : trace_ATL2QVTr::TI_mapOclExpression[1] := atlCondition.TI_mapOclExpression;
	 * var when_TI_mapOclExpression_1 : trace_ATL2QVTr::TI_mapOclExpression[1] := atlElse.TI_mapOclExpression;
	 * var when_TI_mapOclExpression_0 : trace_ATL2QVTr::TI_mapOclExpression[1] := atlThen.TI_mapOclExpression;
	 * add jm_TC__mapIfExp += trace;
	 *
	 */
	protected boolean MAP_m_TC__mapIfExp_status_p1(final @NonNull Connection jm_TC__mapIfExp, final /*@NonInvalid*/ @NonNull TC_mapIfExp trace_5)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapIfExp_status_p1" + ", " + jm_TC__mapIfExp + ", " + trace_5);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression atl_atlCondition = trace_5.getAtl_atlCondition();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression atl_atlElse = trace_5.getAtl_atlElse();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression atl_atlThen = trace_5.getAtl_atlThen();
		final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlCondition);
		final /*@NonInvalid*/ boolean symbol_0 = TI_mapOclExpression != null;
		/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression;
		if (symbol_0) {
			if (TI_mapOclExpression == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression_0 = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlElse);
			final /*@NonInvalid*/ boolean symbol_1 = TI_mapOclExpression_0 != null;
			/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression_1;
			if (symbol_1) {
				if (TI_mapOclExpression_0 == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression_1 = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlThen);
				final /*@NonInvalid*/ boolean symbol_2 = TI_mapOclExpression_1 != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression_0;
				if (symbol_2) {
					if (TI_mapOclExpression_1 == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					// mapping statements
					jm_TC__mapIfExp.appendElement(trace_5);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapIfExp_status_p1 = ValueUtil.TRUE_VALUE;
					raw_when_TI_mapOclExpression_0 = m_TC__mapIfExp_status_p1;
				}
				else {
					raw_when_TI_mapOclExpression_0 = ValueUtil.FALSE_VALUE;
				}
				raw_when_TI_mapOclExpression_1 = raw_when_TI_mapOclExpression_0;
			}
			else {
				raw_when_TI_mapOclExpression_1 = ValueUtil.FALSE_VALUE;
			}
			raw_when_TI_mapOclExpression = raw_when_TI_mapOclExpression_1;
		}
		else {
			raw_when_TI_mapOclExpression = ValueUtil.FALSE_VALUE;
		}
		trace_5.setStatus(raw_when_TI_mapOclExpression);
		if (raw_when_TI_mapOclExpression) {
			objectManager.assigned(trace_5, trace_ATL2QVTrPackage.Literals.TI_MAP_OCL_EXPRESSION__STATUS, raw_when_TI_mapOclExpression);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_TI_mapOclExpression ? "done "  : "fail ") + "MAP_m_TC__mapIfExp_status_p1");
		}
		return raw_when_TI_mapOclExpression;
	}

	/**
	 *
	 * map m_TC__mapIfExp_qvtr_qvtrExpression_p2 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapIfExp[1];
	 * check trace.status;
	 * new:qvtr qvtrExpression : IfExp[1];
	 * set trace.qvtr_qvtrExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_m_TC__mapIfExp_qvtr_qvtrExpression_p2(final /*@NonInvalid*/ @NonNull TC_mapIfExp trace_6)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapIfExp_qvtr_qvtrExpression_p2" + ", " + trace_6);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_6.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_2;
		if (status) {
			// creations
			final org.eclipse.ocl.pivot.@NonNull IfExp qvtrExpression = PivotFactory.eINSTANCE.createIfExp();
			models[2/*qvtr*/].add(qvtrExpression, false);
			// mapping statements
			trace_6.setQvtr_qvtrExpression(qvtrExpression);
			final /*@Thrown*/ @Nullable Boolean m_TC__mapIfExp_qvtr_qvtrExpression_p2 = ValueUtil.TRUE_VALUE;
			symbol_2 = m_TC__mapIfExp_qvtr_qvtrExpression_p2;
		}
		else {
			symbol_2 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_2 ? "done "  : "fail ") + "MAP_m_TC__mapIfExp_qvtr_qvtrExpression_p2");
		}
		return symbol_2;
	}

	/**
	 *
	 * map m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p1 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Helper[1] success status;
	 * append jm_TC__mapNavigationOrAttributeCallExp__Helper  : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Helper[1];
	 * check var atlExpression : OCL::NavigationOrAttributeCallExp[1] := trace.atl_atlExpression;
	 * var _'\u00ABselect\u00BB' : Sequence(OCL::Attribute) := trace.atl_atlAttributes;
	 * var _'\u00ABany\u00BB' : OCL::Attribute[?] := _'\u00ABselect\u00BB'->any(_'1__2' | true)
	 *   ;
	 * var definition : OCL::OclFeatureDefinition[?] := _'\u00ABany\u00BB'?.definition;
	 * var Helper1 : ATL::Helper[?] := definition?.Helper;
	 * check var when_TI_mapHelper_Attribute : trace_ATL2QVTr::TI_mapHelper_Attribute[1] := Helper1?.TI_mapHelper;
	 * var atlModule : ATL::Module[1] := trace.atl_atlModule;
	 * var atlSource : OCL::OclExpression[1] := trace.atl_atlSource;
	 * var propertyName : String[1] := trace.primitive_propertyName;
	 * var elements : OrderedSet(ATL::ModuleElement) := atlModule.elements;
	 * var when_TC_mapModule : trace_ATL2QVTr::TC_mapModule[1] := atlModule.TC_mapModule;
	 * var when_TI_mapOclExpression : trace_ATL2QVTr::TI_mapOclExpression[1] := atlSource.TI_mapOclExpression;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_TC_mapModule.qvtr_qvtrTransformation;
	 * var qvtrThisVariable : Variable[?] := qvtrTransformation.ownedContext;
	 * var name : String[?] := qvtrThisVariable?.name;
	 * var type : Type[?] := qvtrThisVariable?.type;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var qvtrOperation : Operation[1] := when_TI_mapHelper_Attribute.qvtr_qvtrFunction;
	 * var type1 : Type[?] := qvtrOperation.type;
	 * var _'\u00ABcollect\u00BB' : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(_'1_' | _'1_'.definition)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Attribute) := _'\u00ABcollect\u00BB'->collect(_'1__0' | _'1__0'.feature)
	 *   ->selectByKind(OCL::Attribute)
	 *   ;
	 * var _'\u00ABcollect\u00BB1' : Sequence(OCL::OclFeature) := _'\u00ABcollect\u00BB'->collect(_'1__0' | _'1__0'.feature);
	 * contained new:qvtr qvtrSource : VariableExp[1];
	 * set qvtrSource.name := name;
	 * set qvtrSource.referredVariable := qvtrThisVariable;
	 * notify set qvtrSource.type := type;
	 * set trace.qvtr_qvtrOperation := qvtrOperation;
	 * set trace.qvtr_qvtrSource := qvtrSource;
	 * set trace.qvtr_qvtrThisVariable := qvtrThisVariable;
	 * set trace.qvtr_qvtrTransformation := qvtrTransformation;
	 * add jm_TC__mapNavigationOrAttributeCallExp__Helper += trace;
	 *
	 */
	protected boolean MAP_m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p1(final @NonNull Connection jm_TC__mapNavigationOrAttributeCallExp__Helper, final /*@NonInvalid*/ @NonNull TC_mapNavigationOrAttributeCallExp_Helper trace_7)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p1" + ", " + jm_TC__mapNavigationOrAttributeCallExp__Helper + ", " + trace_7);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = trace_7.getAtl_atlExpression();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof NavigationOrAttributeCallExp;
		/*@Thrown*/ @Nullable Boolean symbol_16;
		if (symbol_0) {
			final /*@NonInvalid*/ @NonNull NavigationOrAttributeCallExp symbol_1 = (NavigationOrAttributeCallExp)temp1_atlExpression;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<Attribute> atl_atlAttributes = trace_7.getAtl_atlAttributes();
			final /*@NonInvalid*/ @NonNull SequenceValue BOXED_atl_atlAttributes = idResolver.createSequenceOfAll(SEQ_CLSSid_Attribute, atl_atlAttributes);
			@NonNull Iterator<Object> ITERATOR__49___2 = BOXED_atl_atlAttributes.iterator();
			/*@Thrown*/ @Nullable Attribute any;
			while (true) {
				if (!ITERATOR__49___2.hasNext()) {
					throw new InvalidValueException("No matching content for 'any'");
				}
				@SuppressWarnings("null")
				/*@NonInvalid*/ @NonNull Attribute _49___2 = (Attribute)ITERATOR__49___2.next();
				/**
				 * true
				 */
				//
				if (ValueUtil.TRUE_VALUE != ValueUtil.FALSE_VALUE) {			// Carry on till something found
					any = _49___2;
					break;
				}
			}
			/*@Caught*/ @Nullable Object CAUGHT_any;
			try {
				CAUGHT_any = any;
			}
			catch (Exception e) {
				CAUGHT_any = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ @NonNull Object definition = CAUGHT_any == null;
			/*@Thrown*/ @Nullable OclFeatureDefinition safe_definition_source;
			if (definition == Boolean.TRUE) {
				safe_definition_source = null;
			}
			else {
				assert any != null;
				final /*@Thrown*/ @Nullable OclFeatureDefinition definition_0 = any.getDefinition();
				safe_definition_source = definition_0;
			}
			/*@Caught*/ @Nullable Object CAUGHT_safe_definition_source;
			try {
				CAUGHT_safe_definition_source = safe_definition_source;
			}
			catch (Exception e) {
				CAUGHT_safe_definition_source = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ @NonNull Object Helper = CAUGHT_safe_definition_source == null;
			/*@Thrown*/ @Nullable Helper safe_definition_source_0;
			if (Helper == Boolean.TRUE) {
				safe_definition_source_0 = null;
			}
			else {
				final /*@NonInvalid*/ @NonNull UnboxedCompositionProperty IMPPROPid_definition = new UnboxedCompositionProperty(PROPid_definition);
				assert safe_definition_source != null;
				final /*@Thrown*/ @Nullable Helper Helper_0 = (Helper)IMPPROPid_definition.evaluate(executor, CLSSid_Helper, safe_definition_source);
				safe_definition_source_0 = Helper_0;
			}
			/*@Caught*/ @Nullable Object CAUGHT_safe_definition_source_0;
			try {
				CAUGHT_safe_definition_source_0 = safe_definition_source_0;
			}
			catch (Exception e) {
				CAUGHT_safe_definition_source_0 = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ @NonNull Object TI_mapHelper = CAUGHT_safe_definition_source_0 == null;
			/*@Thrown*/ @Nullable TI_mapHelper safe_atl_atlHelper_source;
			if (TI_mapHelper == Boolean.TRUE) {
				safe_atl_atlHelper_source = null;
			}
			else {
				assert safe_definition_source_0 != null;
				final /*@Thrown*/ @Nullable TI_mapHelper TI_mapHelper_0 = OPPOSITE_OF_TI_mapHelper_atl_atlHelper.get(safe_definition_source_0);
				safe_atl_atlHelper_source = TI_mapHelper_0;
			}
			final /*@NonInvalid*/ boolean symbol_2 = safe_atl_atlHelper_source instanceof TI_mapHelper_Attribute;
			/*@Thrown*/ @Nullable Boolean symbol_15;
			if (symbol_2) {
				final /*@Thrown*/ @Nullable TI_mapHelper_Attribute symbol_3 = (TI_mapHelper_Attribute)safe_atl_atlHelper_source;
				if (symbol_3 == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Module atl_atlModule = trace_7.getAtl_atlModule();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression atl_atlSource = trace_7.getAtl_atlSource();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String primitive_propertyName = trace_7.getPrimitive_propertyName();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<ModuleElement> elements = atl_atlModule.getElements();
				final /*@NonInvalid*/ @Nullable TC_mapModule TC_mapModule = OPPOSITE_OF_TC_mapModule_atl_atlModule.get(atl_atlModule);
				final /*@NonInvalid*/ boolean symbol_4 = TC_mapModule != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TC_mapModule;
				if (symbol_4) {
					if (TC_mapModule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlSource);
					final /*@NonInvalid*/ boolean symbol_5 = TI_mapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression;
					if (symbol_5) {
						if (TI_mapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull RelationalTransformation qvtr_qvtrTransformation = TC_mapModule.getQvtr_qvtrTransformation();
						final /*@Thrown*/ @Nullable Variable ownedContext = qvtr_qvtrTransformation.getOwnedContext();
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
						/*@Caught*/ @Nullable Object CAUGHT_ownedContext_0;
						try {
							CAUGHT_ownedContext_0 = ownedContext;
						}
						catch (Exception e) {
							CAUGHT_ownedContext_0 = ValueUtil.createInvalidValue(e);
						}
						final /*@NonInvalid*/ @NonNull Object type_2 = CAUGHT_ownedContext_0 == null;
						/*@Thrown*/ @Nullable Type safe_type_source;
						if (type_2 == Boolean.TRUE) {
							safe_type_source = null;
						}
						else {
							assert ownedContext != null;
							final /*@Thrown*/ @Nullable Type type_3 = ownedContext.getType();
							safe_type_source = type_3;
						}
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ATL_c_c_Helper_0 = idResolver.getClass(CLSSid_Helper, null);
						final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_elements = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleElement, elements);
						final /*@NonInvalid*/ @NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_elements, TYP_ATL_c_c_Helper_0);
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull Function qvtr_qvtrFunction = symbol_3.getQvtr_qvtrFunction();
						final /*@Thrown*/ @Nullable Type type_4 = qvtr_qvtrFunction.getType();
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
							final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition_1 = _1.getDefinition();
							//
							accumulator.add(definition_1);
						}
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_Attribute_0 = idResolver.getClass(CLSSid_Attribute, null);
						/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeature);
						@NonNull Iterator<Object> ITERATOR__49___0_0 = collect.iterator();
						/*@NonInvalid*/ @NonNull SequenceValue collect_1;
						while (true) {
							if (!ITERATOR__49___0_0.hasNext()) {
								collect_1 = accumulator_0;
								break;
							}
							@SuppressWarnings("null")
							/*@NonInvalid*/ @NonNull OclFeatureDefinition _49___0_0 = (OclFeatureDefinition)ITERATOR__49___0_0.next();
							/**
							 * _'1__0'.feature
							 */
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OclFeature feature_0 = _49___0_0.getFeature();
							//
							accumulator_0.add(feature_0);
						}
						final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_1, TYP_OCL_c_c_Attribute_0);
						// creations
						final org.eclipse.ocl.pivot.@NonNull VariableExp qvtrSource = PivotFactory.eINSTANCE.createVariableExp();
						models[2/*qvtr*/].add(qvtrSource, true);
						// mapping statements
						qvtrSource.setName(safe_name_source);
						qvtrSource.setReferredVariable(ownedContext);
						qvtrSource.setType(safe_type_source);
						objectManager.assigned(qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, safe_type_source);
						trace_7.setQvtr_qvtrOperation(qvtr_qvtrFunction);
						trace_7.setQvtr_qvtrSource(qvtrSource);
						trace_7.setQvtr_qvtrThisVariable(ownedContext);
						trace_7.setQvtr_qvtrTransformation(qvtr_qvtrTransformation);
						jm_TC__mapNavigationOrAttributeCallExp__Helper.appendElement(trace_7);
						final /*@Thrown*/ @Nullable Boolean m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p1 = ValueUtil.TRUE_VALUE;
						raw_when_TI_mapOclExpression = m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p1;
					}
					else {
						raw_when_TI_mapOclExpression = ValueUtil.FALSE_VALUE;
					}
					raw_when_TC_mapModule = raw_when_TI_mapOclExpression;
				}
				else {
					raw_when_TC_mapModule = ValueUtil.FALSE_VALUE;
				}
				symbol_15 = raw_when_TC_mapModule;
			}
			else {
				symbol_15 = ValueUtil.FALSE_VALUE;
			}
			symbol_16 = symbol_15;
		}
		else {
			symbol_16 = ValueUtil.FALSE_VALUE;
		}
		trace_7.setStatus(symbol_16);
		if (symbol_16) {
			objectManager.assigned(trace_7, trace_ATL2QVTrPackage.Literals.TI_MAP_OCL_EXPRESSION__STATUS, symbol_16);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_16 ? "done "  : "fail ") + "MAP_m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p1");
		}
		return symbol_16;
	}

	/**
	 *
	 * map m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p2 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Helper[1];
	 * check trace.status;
	 * var propertyName : String[1] := trace.primitive_propertyName;
	 * var qvtrOperation : Operation[1] := trace.qvtr_qvtrOperation;
	 * var type : Type[?] := qvtrOperation.type;
	 * new:qvtr qvtrExpression : OperationCallExp[1];
	 * set qvtrExpression.name := propertyName;
	 * set trace.qvtr_qvtrExpression := qvtrExpression;
	 * set qvtrExpression.referredOperation := qvtrOperation;
	 * notify set qvtrExpression.type := type;
	 *
	 */
	protected boolean MAP_m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p2(final /*@NonInvalid*/ @NonNull TC_mapNavigationOrAttributeCallExp_Helper trace_8)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p2" + ", " + trace_8);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_8.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_5;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String primitive_propertyName = trace_8.getPrimitive_propertyName();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Operation qvtr_qvtrOperation = trace_8.getQvtr_qvtrOperation();
			final /*@NonInvalid*/ @Nullable Type type_2 = qvtr_qvtrOperation.getType();
			// creations
			final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
			models[2/*qvtr*/].add(qvtrExpression, false);
			// mapping statements
			qvtrExpression.setName(primitive_propertyName);
			trace_8.setQvtr_qvtrExpression(qvtrExpression);
			qvtrExpression.setReferredOperation(qvtr_qvtrOperation);
			qvtrExpression.setType(type_2);
			objectManager.assigned(qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_2);
			final /*@Thrown*/ @Nullable Boolean m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p2 = ValueUtil.TRUE_VALUE;
			symbol_5 = m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p2;
		}
		else {
			symbol_5 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_5 ? "done "  : "fail ") + "MAP_m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p2");
		}
		return symbol_5;
	}

	/**
	 *
	 * map m_TC__mapNavigationOrAttributeCallExp__Property_stat_p1 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Property[1] success status;
	 * append jm_TC__mapNavigationOrAttributeCallExp__Property  : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Property[1];
	 * var atlSource : OCL::OclExpression[1] := trace.atl_atlSource;
	 * var when_TI_mapOclExpression : trace_ATL2QVTr::TI_mapOclExpression[1] := atlSource.TI_mapOclExpression;
	 * add jm_TC__mapNavigationOrAttributeCallExp__Property += trace;
	 *
	 */
	protected boolean MAP_m_TC__mapNavigationOrAttributeCallExp__Property_stat_p1(final @NonNull Connection jm_TC__mapNavigationOrAttributeCallExp__Property, final /*@NonInvalid*/ @NonNull TC_mapNavigationOrAttributeCallExp_Property trace_9)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapNavigationOrAttributeCallExp__Property_stat_p1" + ", " + jm_TC__mapNavigationOrAttributeCallExp__Property + ", " + trace_9);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression atl_atlSource = trace_9.getAtl_atlSource();
		final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlSource);
		final /*@NonInvalid*/ boolean symbol_0 = TI_mapOclExpression != null;
		/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression;
		if (symbol_0) {
			if (TI_mapOclExpression == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			// mapping statements
			jm_TC__mapNavigationOrAttributeCallExp__Property.appendElement(trace_9);
			final /*@Thrown*/ @Nullable Boolean m_TC__mapNavigationOrAttributeCallExp__Property_stat_p1 = ValueUtil.TRUE_VALUE;
			raw_when_TI_mapOclExpression = m_TC__mapNavigationOrAttributeCallExp__Property_stat_p1;
		}
		else {
			raw_when_TI_mapOclExpression = ValueUtil.FALSE_VALUE;
		}
		trace_9.setStatus(raw_when_TI_mapOclExpression);
		if (raw_when_TI_mapOclExpression) {
			objectManager.assigned(trace_9, trace_ATL2QVTrPackage.Literals.TI_MAP_OCL_EXPRESSION__STATUS, raw_when_TI_mapOclExpression);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_TI_mapOclExpression ? "done "  : "fail ") + "MAP_m_TC__mapNavigationOrAttributeCallExp__Property_stat_p1");
		}
		return raw_when_TI_mapOclExpression;
	}

	/**
	 *
	 * map m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p2 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Property[1];
	 * check trace.status;
	 * var propertyName : String[1] := trace.primitive_propertyName;
	 * new:qvtr qvtrExpression : PropertyCallExp[1];
	 * set qvtrExpression.name := propertyName;
	 * set trace.qvtr_qvtrExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p2(final /*@NonInvalid*/ @NonNull TC_mapNavigationOrAttributeCallExp_Property trace_10)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p2" + ", " + trace_10);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_10.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_3;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String primitive_propertyName = trace_10.getPrimitive_propertyName();
			// creations
			final @NonNull PropertyCallExp qvtrExpression = PivotFactory.eINSTANCE.createPropertyCallExp();
			models[2/*qvtr*/].add(qvtrExpression, false);
			// mapping statements
			qvtrExpression.setName(primitive_propertyName);
			trace_10.setQvtr_qvtrExpression(qvtrExpression);
			final /*@Thrown*/ @Nullable Boolean m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p2 = ValueUtil.TRUE_VALUE;
			symbol_3 = m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p2;
		}
		else {
			symbol_3 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_3 ? "done "  : "fail ") + "MAP_m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p2");
		}
		return symbol_3;
	}

	/**
	 *
	 * map m_TC__mapOperationCallExp__Helper_qvtr_qvtrOperation_p1 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TC_mapOperationCallExp_Helper[1] success status;
	 * append jm_TC__mapOperationCallExp__Helper  : trace_ATL2QVTr::TC_mapOperationCallExp_Helper[1];
	 * check var atlExpression : OCL::OperationCallExp[1] := trace.atl_atlExpression;
	 * var _'\u00ABselect\u00BB' : Sequence(OCL::Operation) := trace.atl_atlOperations;
	 * var _'\u00ABany\u00BB' : OCL::Operation[?] := _'\u00ABselect\u00BB'->any(_'1__2' | true)
	 *   ;
	 * var definition : OCL::OclFeatureDefinition[?] := _'\u00ABany\u00BB'?.definition;
	 * var Helper1 : ATL::Helper[?] := definition?.Helper;
	 * check var when_TI_mapHelper_Operation : trace_ATL2QVTr::TI_mapHelper_Operation[1] := Helper1?.TI_mapHelper;
	 * var atlModule : ATL::Module[1] := trace.atl_atlModule;
	 * var atlSource : OCL::OclExpression[1] := trace.atl_atlSource;
	 * var operationName : String[1] := trace.primitive_operationName;
	 * var elements : OrderedSet(ATL::ModuleElement) := atlModule.elements;
	 * var when_TC_mapModule : trace_ATL2QVTr::TC_mapModule[1] := atlModule.TC_mapModule;
	 * var when_TI_mapOclExpression : trace_ATL2QVTr::TI_mapOclExpression[1] := atlSource.TI_mapOclExpression;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_TC_mapModule.qvtr_qvtrTransformation;
	 * var qvtrThisVariable : Variable[?] := qvtrTransformation.ownedContext;
	 * var name : String[?] := qvtrThisVariable?.name;
	 * var type : Type[?] := qvtrThisVariable?.type;
	 * var selectByKind : OrderedSet(ATL::Helper) := elements->selectByKind(ATL::Helper)
	 *   ;
	 * var qvtrOperation : Operation[1] := when_TI_mapHelper_Operation.qvtr_qvtrFunction;
	 * var type1 : Type[?] := qvtrOperation.type;
	 * var _'\u00ABcollect\u00BB' : Sequence(OCL::OclFeatureDefinition) := selectByKind->collect(_'1_' | _'1_'.definition)
	 *   ;
	 * var selectByKind1 : Sequence(OCL::Operation) := _'\u00ABcollect\u00BB'->collect(_'1__0' | _'1__0'.feature)
	 *   ->selectByKind(OCL::Operation)
	 *   ;
	 * var _'\u00ABcollect\u00BB1' : Sequence(OCL::OclFeature) := _'\u00ABcollect\u00BB'->collect(_'1__0' | _'1__0'.feature);
	 * contained new:qvtr qvtrSource : VariableExp[1];
	 * set qvtrSource.name := name;
	 * set trace.qvtr_qvtrOperation := qvtrOperation;
	 * set trace.qvtr_qvtrSource := qvtrSource;
	 * set trace.qvtr_qvtrThisVariable := qvtrThisVariable;
	 * set trace.qvtr_qvtrTransformation := qvtrTransformation;
	 * set qvtrSource.referredVariable := qvtrThisVariable;
	 * notify set qvtrSource.type := type;
	 * add jm_TC__mapOperationCallExp__Helper += trace;
	 *
	 */
	protected boolean MAP_m_TC__mapOperationCallExp__Helper_qvtr_qvtrOperation_p1(final @NonNull Connection jm_TC__mapOperationCallExp__Helper, final /*@NonInvalid*/ @NonNull TC_mapOperationCallExp_Helper trace_11)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOperationCallExp__Helper_qvtr_qvtrOperation_p1" + ", " + jm_TC__mapOperationCallExp__Helper + ", " + trace_11);
		}
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = trace_11.getAtl_atlExpression();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof org.eclipse.m2m.atl.common.OCL.OperationCallExp;
		/*@Thrown*/ @Nullable Boolean symbol_16;
		if (symbol_0) {
			final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull OperationCallExp symbol_1 = (org.eclipse.m2m.atl.common.OCL.OperationCallExp)temp1_atlExpression;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<org.eclipse.m2m.atl.common.OCL.Operation> atl_atlOperations = trace_11.getAtl_atlOperations();
			final /*@NonInvalid*/ @NonNull SequenceValue BOXED_atl_atlOperations = idResolver.createSequenceOfAll(SEQ_CLSSid_Operation, atl_atlOperations);
			@NonNull Iterator<Object> ITERATOR__49___2 = BOXED_atl_atlOperations.iterator();
			/*@Thrown*/ org.eclipse.m2m.atl.common.OCL.@Nullable Operation any;
			while (true) {
				if (!ITERATOR__49___2.hasNext()) {
					throw new InvalidValueException("No matching content for 'any'");
				}
				@SuppressWarnings("null")
				/*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull Operation _49___2 = (org.eclipse.m2m.atl.common.OCL.Operation)ITERATOR__49___2.next();
				/**
				 * true
				 */
				//
				if (ValueUtil.TRUE_VALUE != ValueUtil.FALSE_VALUE) {			// Carry on till something found
					any = _49___2;
					break;
				}
			}
			/*@Caught*/ @Nullable Object CAUGHT_any;
			try {
				CAUGHT_any = any;
			}
			catch (Exception e) {
				CAUGHT_any = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ @NonNull Object definition = CAUGHT_any == null;
			/*@Thrown*/ @Nullable OclFeatureDefinition safe_definition_source;
			if (definition == Boolean.TRUE) {
				safe_definition_source = null;
			}
			else {
				assert any != null;
				final /*@Thrown*/ @Nullable OclFeatureDefinition definition_0 = any.getDefinition();
				safe_definition_source = definition_0;
			}
			/*@Caught*/ @Nullable Object CAUGHT_safe_definition_source;
			try {
				CAUGHT_safe_definition_source = safe_definition_source;
			}
			catch (Exception e) {
				CAUGHT_safe_definition_source = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ @NonNull Object Helper = CAUGHT_safe_definition_source == null;
			/*@Thrown*/ @Nullable Helper safe_definition_source_0;
			if (Helper == Boolean.TRUE) {
				safe_definition_source_0 = null;
			}
			else {
				final /*@NonInvalid*/ @NonNull UnboxedCompositionProperty IMPPROPid_definition = new UnboxedCompositionProperty(PROPid_definition);
				assert safe_definition_source != null;
				final /*@Thrown*/ @Nullable Helper Helper_0 = (Helper)IMPPROPid_definition.evaluate(executor, CLSSid_Helper, safe_definition_source);
				safe_definition_source_0 = Helper_0;
			}
			/*@Caught*/ @Nullable Object CAUGHT_safe_definition_source_0;
			try {
				CAUGHT_safe_definition_source_0 = safe_definition_source_0;
			}
			catch (Exception e) {
				CAUGHT_safe_definition_source_0 = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ @NonNull Object TI_mapHelper = CAUGHT_safe_definition_source_0 == null;
			/*@Thrown*/ @Nullable TI_mapHelper safe_atl_atlHelper_source;
			if (TI_mapHelper == Boolean.TRUE) {
				safe_atl_atlHelper_source = null;
			}
			else {
				assert safe_definition_source_0 != null;
				final /*@Thrown*/ @Nullable TI_mapHelper TI_mapHelper_0 = OPPOSITE_OF_TI_mapHelper_atl_atlHelper.get(safe_definition_source_0);
				safe_atl_atlHelper_source = TI_mapHelper_0;
			}
			final /*@NonInvalid*/ boolean symbol_2 = safe_atl_atlHelper_source instanceof TI_mapHelper_Operation;
			/*@Thrown*/ @Nullable Boolean symbol_15;
			if (symbol_2) {
				final /*@Thrown*/ @Nullable TI_mapHelper_Operation symbol_3 = (TI_mapHelper_Operation)safe_atl_atlHelper_source;
				if (symbol_3 == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Module atl_atlModule = trace_11.getAtl_atlModule();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression atl_atlSource = trace_11.getAtl_atlSource();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String primitive_operationName = trace_11.getPrimitive_operationName();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<ModuleElement> elements = atl_atlModule.getElements();
				final /*@NonInvalid*/ @Nullable TC_mapModule TC_mapModule = OPPOSITE_OF_TC_mapModule_atl_atlModule.get(atl_atlModule);
				final /*@NonInvalid*/ boolean symbol_4 = TC_mapModule != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TC_mapModule;
				if (symbol_4) {
					if (TC_mapModule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlSource);
					final /*@NonInvalid*/ boolean symbol_5 = TI_mapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression;
					if (symbol_5) {
						if (TI_mapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull RelationalTransformation qvtr_qvtrTransformation = TC_mapModule.getQvtr_qvtrTransformation();
						final /*@Thrown*/ @Nullable Variable ownedContext = qvtr_qvtrTransformation.getOwnedContext();
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
						/*@Caught*/ @Nullable Object CAUGHT_ownedContext_0;
						try {
							CAUGHT_ownedContext_0 = ownedContext;
						}
						catch (Exception e) {
							CAUGHT_ownedContext_0 = ValueUtil.createInvalidValue(e);
						}
						final /*@NonInvalid*/ @NonNull Object type_2 = CAUGHT_ownedContext_0 == null;
						/*@Thrown*/ @Nullable Type safe_type_source;
						if (type_2 == Boolean.TRUE) {
							safe_type_source = null;
						}
						else {
							assert ownedContext != null;
							final /*@Thrown*/ @Nullable Type type_3 = ownedContext.getType();
							safe_type_source = type_3;
						}
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ATL_c_c_Helper_0 = idResolver.getClass(CLSSid_Helper, null);
						final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_elements = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModuleElement, elements);
						final /*@NonInvalid*/ @NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_elements, TYP_ATL_c_c_Helper_0);
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull Function qvtr_qvtrFunction = symbol_3.getQvtr_qvtrFunction();
						final /*@Thrown*/ @Nullable Type type_4 = qvtr_qvtrFunction.getType();
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
							final /*@NonInvalid*/ @NonNull OclFeatureDefinition definition_1 = _1.getDefinition();
							//
							accumulator.add(definition_1);
						}
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OCL_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
						/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_OclFeature);
						@NonNull Iterator<Object> ITERATOR__49___0_0 = collect.iterator();
						/*@NonInvalid*/ @NonNull SequenceValue collect_1;
						while (true) {
							if (!ITERATOR__49___0_0.hasNext()) {
								collect_1 = accumulator_0;
								break;
							}
							@SuppressWarnings("null")
							/*@NonInvalid*/ @NonNull OclFeatureDefinition _49___0_0 = (OclFeatureDefinition)ITERATOR__49___0_0.next();
							/**
							 * _'1__0'.feature
							 */
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OclFeature feature_0 = _49___0_0.getFeature();
							//
							accumulator_0.add(feature_0);
						}
						final /*@NonInvalid*/ @NonNull SequenceValue selectByKind_0 = (SequenceValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, collect_1, TYP_OCL_c_c_Operation_0);
						// creations
						final org.eclipse.ocl.pivot.@NonNull VariableExp qvtrSource = PivotFactory.eINSTANCE.createVariableExp();
						models[2/*qvtr*/].add(qvtrSource, true);
						// mapping statements
						qvtrSource.setName(safe_name_source);
						trace_11.setQvtr_qvtrOperation(qvtr_qvtrFunction);
						trace_11.setQvtr_qvtrSource(qvtrSource);
						trace_11.setQvtr_qvtrThisVariable(ownedContext);
						trace_11.setQvtr_qvtrTransformation(qvtr_qvtrTransformation);
						qvtrSource.setReferredVariable(ownedContext);
						qvtrSource.setType(safe_type_source);
						objectManager.assigned(qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, safe_type_source);
						jm_TC__mapOperationCallExp__Helper.appendElement(trace_11);
						final /*@Thrown*/ @Nullable Boolean m_TC__mapOperationCallExp__Helper_qvtr_qvtrOperation_p1 = ValueUtil.TRUE_VALUE;
						raw_when_TI_mapOclExpression = m_TC__mapOperationCallExp__Helper_qvtr_qvtrOperation_p1;
					}
					else {
						raw_when_TI_mapOclExpression = ValueUtil.FALSE_VALUE;
					}
					raw_when_TC_mapModule = raw_when_TI_mapOclExpression;
				}
				else {
					raw_when_TC_mapModule = ValueUtil.FALSE_VALUE;
				}
				symbol_15 = raw_when_TC_mapModule;
			}
			else {
				symbol_15 = ValueUtil.FALSE_VALUE;
			}
			symbol_16 = symbol_15;
		}
		else {
			symbol_16 = ValueUtil.FALSE_VALUE;
		}
		trace_11.setStatus(symbol_16);
		if (symbol_16) {
			objectManager.assigned(trace_11, trace_ATL2QVTrPackage.Literals.TI_MAP_OCL_EXPRESSION__STATUS, symbol_16);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_16 ? "done "  : "fail ") + "MAP_m_TC__mapOperationCallExp__Helper_qvtr_qvtrOperation_p1");
		}
		return symbol_16;
	}

	/**
	 *
	 * map m_WI__mapVariableExp__referredVariable_result in ATL2QVTr {
	 * guard:atl atlExpression : OCL::VariableExp[1];
	 * var atlVariable : OCL::VariableDeclaration[1] := atlExpression.referredVariable;
	 * var varName : String[1] := atlVariable.varName;
	 * var _'=' : Boolean[1] := varName =
	 *   'self';
	 * check _'=';
	 * var invocation : trace_ATL2QVTr::WI_mapVariableExp_referredVariable[1] := atlExpression.WI_mapVariableExp_referredVariable;
	 * var qvtrExpression : VariableExp[1] := invocation.qvtr_qvtrExpression;
	 * var atlHelper : ATL::Helper[?] := this.getHelper(atlExpression);
	 * var atlHelper1 : ATL::Helper[1] := atlHelper;
	 * var when_TC_mapVariable : trace_ATL2QVTr::TC_mapVariable[1] := atlHelper1.TC_mapVariable;
	 * var qvtrVariable : VariableDeclaration[1] := when_TC_mapVariable.qvtr_qvtrVariable;
	 * var type : Type[?] := qvtrVariable.type;
	 * new:middle trace : trace_ATL2QVTr::TC_mapVariableExp_referredVariable_Helper[1];
	 * set qvtrExpression.name := 'self';
	 * set invocation.result := trace;
	 * set trace.atl_atlExpression := atlExpression;
	 * set trace.atl_atlHelper := atlHelper1;
	 * set trace.atl_atlVariable := atlVariable;
	 * set trace.qvtr_qvtrExpression := qvtrExpression;
	 * set trace.qvtr_qvtrVariable := qvtrVariable;
	 * set qvtrExpression.referredVariable := qvtrVariable;
	 * notify set qvtrExpression.type := type;
	 *
	 */
	protected boolean MAP_m_WI__mapVariableExp__referredVariable_result(final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableExp atlExpression_14)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_WI__mapVariableExp__referredVariable_result" + ", " + atlExpression_14);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableDeclaration referredVariable = atlExpression_14.getReferredVariable();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String varName = referredVariable.getVarName();
		final /*@NonInvalid*/ boolean eq = varName.equals(STR_self);
		/*@Thrown*/ @Nullable Boolean symbol_13;
		if (eq) {
			final /*@NonInvalid*/ @Nullable WI_mapVariableExp_referredVariable WI_mapVariableExp_referredVariable = OPPOSITE_OF_WI_mapVariableExp_referredVariable_atl_atlExpression.get(atlExpression_14);
			final /*@NonInvalid*/ boolean symbol_0 = WI_mapVariableExp_referredVariable != null;
			/*@Thrown*/ @Nullable Boolean raw_invocation;
			if (symbol_0) {
				if (WI_mapVariableExp_referredVariable == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull VariableExp qvtr_qvtrExpression = WI_mapVariableExp_referredVariable.getQvtr_qvtrExpression();
				final /*@NonInvalid*/ @Nullable Helper getHelper = ((FUN_getHelper)FTOR_getHelper.getUniqueComputation(this, atlExpression_14)).instance;
				final /*@NonInvalid*/ boolean symbol_1 = getHelper != null;
				/*@Thrown*/ @Nullable Boolean raw_atlHelper1;
				if (symbol_1) {
					if (getHelper == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable TC_mapVariable TC_mapVariable = OPPOSITE_OF_TC_mapVariable_atl_atlVariable.get(getHelper);
					final /*@Thrown*/ boolean symbol_2 = TC_mapVariable != null;
					/*@Thrown*/ @Nullable Boolean raw_when_TC_mapVariable;
					if (symbol_2) {
						if (TC_mapVariable == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull VariableDeclaration qvtr_qvtrVariable = TC_mapVariable.getQvtr_qvtrVariable();
						final /*@Thrown*/ @Nullable Type type_2 = qvtr_qvtrVariable.getType();
						// creations
						final @SuppressWarnings("null")@NonNull TC_mapVariableExp_referredVariable_Helper trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapVariableExp_referredVariable_Helper();
						models[0/*middle*/].add(trace_37, false);
						// mapping statements
						qvtr_qvtrExpression.setName(STR_self);
						WI_mapVariableExp_referredVariable.setResult(trace_37);
						trace_37.setAtl_atlExpression(atlExpression_14);
						trace_37.setAtl_atlHelper(getHelper);
						trace_37.setAtl_atlVariable(referredVariable);
						trace_37.setQvtr_qvtrExpression(qvtr_qvtrExpression);
						trace_37.setQvtr_qvtrVariable(qvtr_qvtrVariable);
						qvtr_qvtrExpression.setReferredVariable(qvtr_qvtrVariable);
						qvtr_qvtrExpression.setType(type_2);
						objectManager.assigned(qvtr_qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_2);
						final /*@Thrown*/ @Nullable Boolean m_WI__mapVariableExp__referredVariable_result = ValueUtil.TRUE_VALUE;
						raw_when_TC_mapVariable = m_WI__mapVariableExp__referredVariable_result;
					}
					else {
						raw_when_TC_mapVariable = ValueUtil.FALSE_VALUE;
					}
					raw_atlHelper1 = raw_when_TC_mapVariable;
				}
				else {
					raw_atlHelper1 = ValueUtil.FALSE_VALUE;
				}
				raw_invocation = raw_atlHelper1;
			}
			else {
				raw_invocation = ValueUtil.FALSE_VALUE;
			}
			symbol_13 = raw_invocation;
		}
		else {
			symbol_13 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_13 ? "done "  : "fail ") + "MAP_m_WI__mapVariableExp__referredVariable_result");
		}
		return symbol_13;
	}

	/**
	 *
	 * map m_WI__mapVariableExp__referredVariable_result_1 in ATL2QVTr {
	 * guard:atl atlExpression : OCL::VariableExp[1];
	 * check var atlVariable : ATL::PatternElement[1] := atlExpression.referredVariable;
	 * var invocation : trace_ATL2QVTr::WI_mapVariableExp_referredVariable[1] := atlExpression.WI_mapVariableExp_referredVariable;
	 * var when_TC_mapVariable : trace_ATL2QVTr::TC_mapVariable[1] := atlVariable.TC_mapVariable;
	 * var qvtrExpression : VariableExp[1] := invocation.qvtr_qvtrExpression;
	 * var qvtrVariable : VariableDeclaration[1] := when_TC_mapVariable.qvtr_qvtrVariable;
	 * var name : String[?] := qvtrVariable.name;
	 * var type : Type[?] := qvtrVariable.type;
	 * new:middle trace : trace_ATL2QVTr::TC_mapVariableExp_referredVariable_VariableDeclaration[1];
	 * set qvtrExpression.name := name;
	 * set qvtrExpression.referredVariable := qvtrVariable;
	 * notify set qvtrExpression.type := type;
	 * set invocation.result := trace;
	 * set trace.atl_atlExpression := atlExpression;
	 * set trace.atl_atlVariable := atlVariable;
	 * set trace.qvtr_qvtrExpression := qvtrExpression;
	 * set trace.qvtr_qvtrVariable := qvtrVariable;
	 *
	 */
	protected boolean MAP_m_WI__mapVariableExp__referredVariable_result_1(final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableExp atlExpression_15)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_WI__mapVariableExp__referredVariable_result_1" + ", " + atlExpression_15);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@NonNull VariableDeclaration temp1_atlVariable = atlExpression_15.getReferredVariable();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlVariable instanceof PatternElement;
		/*@Thrown*/ @Nullable Boolean symbol_13;
		if (symbol_0) {
			final /*@NonInvalid*/ @NonNull PatternElement symbol_1 = (PatternElement)temp1_atlVariable;
			final /*@NonInvalid*/ @Nullable WI_mapVariableExp_referredVariable WI_mapVariableExp_referredVariable = OPPOSITE_OF_WI_mapVariableExp_referredVariable_atl_atlExpression.get(atlExpression_15);
			final /*@NonInvalid*/ boolean symbol_2 = WI_mapVariableExp_referredVariable != null;
			/*@Thrown*/ @Nullable Boolean raw_invocation;
			if (symbol_2) {
				if (WI_mapVariableExp_referredVariable == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@NonInvalid*/ @Nullable TC_mapVariable TC_mapVariable = OPPOSITE_OF_TC_mapVariable_atl_atlVariable.get(symbol_1);
				final /*@NonInvalid*/ boolean symbol_3 = TC_mapVariable != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TC_mapVariable;
				if (symbol_3) {
					if (TC_mapVariable == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull VariableExp qvtr_qvtrExpression = WI_mapVariableExp_referredVariable.getQvtr_qvtrExpression();
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull VariableDeclaration qvtr_qvtrVariable = TC_mapVariable.getQvtr_qvtrVariable();
					final /*@Thrown*/ @Nullable String name_2 = qvtr_qvtrVariable.getName();
					final /*@Thrown*/ @Nullable Type type_2 = qvtr_qvtrVariable.getType();
					// creations
					final @SuppressWarnings("null")@NonNull TC_mapVariableExp_referredVariable_VariableDeclaration trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapVariableExp_referredVariable_VariableDeclaration();
					models[0/*middle*/].add(trace_37, false);
					// mapping statements
					qvtr_qvtrExpression.setName(name_2);
					qvtr_qvtrExpression.setReferredVariable(qvtr_qvtrVariable);
					qvtr_qvtrExpression.setType(type_2);
					objectManager.assigned(qvtr_qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_2);
					WI_mapVariableExp_referredVariable.setResult(trace_37);
					trace_37.setAtl_atlExpression(atlExpression_15);
					trace_37.setAtl_atlVariable(symbol_1);
					trace_37.setQvtr_qvtrExpression(qvtr_qvtrExpression);
					trace_37.setQvtr_qvtrVariable(qvtr_qvtrVariable);
					final /*@Thrown*/ @Nullable Boolean m_WI__mapVariableExp__referredVariable_result_1 = ValueUtil.TRUE_VALUE;
					raw_when_TC_mapVariable = m_WI__mapVariableExp__referredVariable_result_1;
				}
				else {
					raw_when_TC_mapVariable = ValueUtil.FALSE_VALUE;
				}
				raw_invocation = raw_when_TC_mapVariable;
			}
			else {
				raw_invocation = ValueUtil.FALSE_VALUE;
			}
			symbol_13 = raw_invocation;
		}
		else {
			symbol_13 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_13 ? "done "  : "fail ") + "MAP_m_WI__mapVariableExp__referredVariable_result_1");
		}
		return symbol_13;
	}

	/**
	 *
	 * map m_TC__mapOperationCallExp__Helper_qvtr_qvtrExpressio_p2 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapOperationCallExp_Helper[1];
	 * check trace.status;
	 * var operationName : String[1] := trace.primitive_operationName;
	 * var qvtrOperation : Operation[1] := trace.qvtr_qvtrOperation;
	 * var type : Type[?] := qvtrOperation.type;
	 * new:qvtr qvtrExpression : OperationCallExp[1];
	 * set qvtrExpression.name := operationName;
	 * set trace.qvtr_qvtrExpression := qvtrExpression;
	 * set qvtrExpression.referredOperation := qvtrOperation;
	 * notify set qvtrExpression.type := type;
	 *
	 */
	protected boolean MAP_m_TC__mapOperationCallExp__Helper_qvtr_qvtrExpressio_p2(final /*@NonInvalid*/ @NonNull TC_mapOperationCallExp_Helper trace_12)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOperationCallExp__Helper_qvtr_qvtrExpressio_p2" + ", " + trace_12);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_12.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_5;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String primitive_operationName = trace_12.getPrimitive_operationName();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Operation qvtr_qvtrOperation = trace_12.getQvtr_qvtrOperation();
			final /*@NonInvalid*/ @Nullable Type type_2 = qvtr_qvtrOperation.getType();
			// creations
			final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
			models[2/*qvtr*/].add(qvtrExpression, false);
			// mapping statements
			qvtrExpression.setName(primitive_operationName);
			trace_12.setQvtr_qvtrExpression(qvtrExpression);
			qvtrExpression.setReferredOperation(qvtr_qvtrOperation);
			qvtrExpression.setType(type_2);
			objectManager.assigned(qvtrExpression, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_2);
			final /*@Thrown*/ @Nullable Boolean m_TC__mapOperationCallExp__Helper_qvtr_qvtrExpressio_p2 = ValueUtil.TRUE_VALUE;
			symbol_5 = m_TC__mapOperationCallExp__Helper_qvtr_qvtrExpressio_p2;
		}
		else {
			symbol_5 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_5 ? "done "  : "fail ") + "MAP_m_TC__mapOperationCallExp__Helper_qvtr_qvtrExpressio_p2");
		}
		return symbol_5;
	}

	/**
	 *
	 * map m_TC__mapOperationCallExp__Operation_status_p1 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapOperationCallExp_Operation[1] success status;
	 * append jm_TC__mapOperationCallExp__Operation  : trace_ATL2QVTr::TC_mapOperationCallExp_Operation[1];
	 * var atlSource : OCL::OclExpression[1] := trace.atl_atlSource;
	 * var when_TI_mapOclExpression : trace_ATL2QVTr::TI_mapOclExpression[1] := atlSource.TI_mapOclExpression;
	 * add jm_TC__mapOperationCallExp__Operation += trace;
	 *
	 */
	protected boolean MAP_m_TC__mapOperationCallExp__Operation_status_p1(final @NonNull Connection jm_TC__mapOperationCallExp__Operation, final /*@NonInvalid*/ @NonNull TC_mapOperationCallExp_Operation trace_13)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOperationCallExp__Operation_status_p1" + ", " + jm_TC__mapOperationCallExp__Operation + ", " + trace_13);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression atl_atlSource = trace_13.getAtl_atlSource();
		final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlSource);
		final /*@NonInvalid*/ boolean symbol_0 = TI_mapOclExpression != null;
		/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression;
		if (symbol_0) {
			if (TI_mapOclExpression == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			// mapping statements
			jm_TC__mapOperationCallExp__Operation.appendElement(trace_13);
			final /*@Thrown*/ @Nullable Boolean m_TC__mapOperationCallExp__Operation_status_p1 = ValueUtil.TRUE_VALUE;
			raw_when_TI_mapOclExpression = m_TC__mapOperationCallExp__Operation_status_p1;
		}
		else {
			raw_when_TI_mapOclExpression = ValueUtil.FALSE_VALUE;
		}
		trace_13.setStatus(raw_when_TI_mapOclExpression);
		if (raw_when_TI_mapOclExpression) {
			objectManager.assigned(trace_13, trace_ATL2QVTrPackage.Literals.TI_MAP_OCL_EXPRESSION__STATUS, raw_when_TI_mapOclExpression);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_when_TI_mapOclExpression ? "done "  : "fail ") + "MAP_m_TC__mapOperationCallExp__Operation_status_p1");
		}
		return raw_when_TI_mapOclExpression;
	}

	/**
	 *
	 * map m_TC__mapOperationCallExp__Operation_qvtr_qvtrExpres_p2 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapOperationCallExp_Operation[1];
	 * check trace.status;
	 * var operationName : String[1] := trace.primitive_operationName;
	 * new:qvtr qvtrExpression : OperationCallExp[1];
	 * set qvtrExpression.name := operationName;
	 * set trace.qvtr_qvtrExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_m_TC__mapOperationCallExp__Operation_qvtr_qvtrExpres_p2(final /*@NonInvalid*/ @NonNull TC_mapOperationCallExp_Operation trace_14)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOperationCallExp__Operation_qvtr_qvtrExpres_p2" + ", " + trace_14);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_14.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_3;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String primitive_operationName = trace_14.getPrimitive_operationName();
			// creations
			final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
			models[2/*qvtr*/].add(qvtrExpression, false);
			// mapping statements
			qvtrExpression.setName(primitive_operationName);
			trace_14.setQvtr_qvtrExpression(qvtrExpression);
			final /*@Thrown*/ @Nullable Boolean m_TC__mapOperationCallExp__Operation_qvtr_qvtrExpres_p2 = ValueUtil.TRUE_VALUE;
			symbol_3 = m_TC__mapOperationCallExp__Operation_qvtr_qvtrExpres_p2;
		}
		else {
			symbol_3 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_3 ? "done "  : "fail ") + "MAP_m_TC__mapOperationCallExp__Operation_qvtr_qvtrExpres_p2");
		}
		return symbol_3;
	}

	/**
	 *
	 * map m_TC__mapOperatorCallExp_atl_atlModule_status_p1 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TC_mapOperatorCallExp[1] success status;
	 * append jm_TC__mapOperatorCallExp  : trace_ATL2QVTr::TC_mapOperatorCallExp[1];
	 * check var atlExpression : OCL::OperatorCallExp[1] := trace.atl_atlExpression;
	 * var atlSource : OCL::OclExpression[1] := trace.atl_atlSource;
	 * var when_TI_mapOclExpression : trace_ATL2QVTr::TI_mapOclExpression[1] := atlSource.TI_mapOclExpression;
	 * var atlModule : ATL::Module[1] := this.getModule(atlExpression);
	 * var when_TC_mapModule : trace_ATL2QVTr::TC_mapModule[1] := atlModule.TC_mapModule;
	 * set trace.atl_atlModule := atlModule;
	 * add jm_TC__mapOperatorCallExp += trace;
	 *
	 */
	protected boolean MAP_m_TC__mapOperatorCallExp_atl_atlModule_status_p1(final @NonNull Connection jm_TC__mapOperatorCallExp, final /*@NonInvalid*/ @NonNull TC_mapOperatorCallExp trace_15)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOperatorCallExp_atl_atlModule_status_p1" + ", " + jm_TC__mapOperatorCallExp + ", " + trace_15);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = trace_15.getAtl_atlExpression();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof OperatorCallExp;
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (symbol_0) {
			final /*@NonInvalid*/ @NonNull OperatorCallExp symbol_1 = (OperatorCallExp)temp1_atlExpression;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression atl_atlSource = trace_15.getAtl_atlSource();
			final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlSource);
			final /*@NonInvalid*/ boolean symbol_2 = TI_mapOclExpression != null;
			/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression;
			if (symbol_2) {
				if (TI_mapOclExpression == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@NonInvalid*/ @NonNull Module getModule = ((FUN_getModule)FTOR_getModule.getUniqueComputation(this, symbol_1)).instance;
				final /*@NonInvalid*/ @Nullable TC_mapModule TC_mapModule = OPPOSITE_OF_TC_mapModule_atl_atlModule.get(getModule);
				final /*@NonInvalid*/ boolean symbol_3 = TC_mapModule != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TC_mapModule;
				if (symbol_3) {
					if (TC_mapModule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					// mapping statements
					trace_15.setAtl_atlModule(getModule);
					jm_TC__mapOperatorCallExp.appendElement(trace_15);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapOperatorCallExp_atl_atlModule_status_p1 = ValueUtil.TRUE_VALUE;
					raw_when_TC_mapModule = m_TC__mapOperatorCallExp_atl_atlModule_status_p1;
				}
				else {
					raw_when_TC_mapModule = ValueUtil.FALSE_VALUE;
				}
				raw_when_TI_mapOclExpression = raw_when_TC_mapModule;
			}
			else {
				raw_when_TI_mapOclExpression = ValueUtil.FALSE_VALUE;
			}
			symbol_7 = raw_when_TI_mapOclExpression;
		}
		else {
			symbol_7 = ValueUtil.FALSE_VALUE;
		}
		trace_15.setStatus(symbol_7);
		if (symbol_7) {
			objectManager.assigned(trace_15, trace_ATL2QVTrPackage.Literals.TI_MAP_OCL_EXPRESSION__STATUS, symbol_7);
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_m_TC__mapOperatorCallExp_atl_atlModule_status_p1");
		}
		return symbol_7;
	}

	/**
	 *
	 * map m_TC__mapOperatorCallExp_qvtr_qvtrTransformation_p6 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapOperatorCallExp[1];
	 * check trace.status;
	 * check var atlExpression : OCL::OperatorCallExp[1] := trace.atl_atlExpression;
	 * var atlModule : ATL::Module[1] := trace.atl_atlModule;
	 * var when_TC_mapModule : trace_ATL2QVTr::TC_mapModule[1] := atlModule.TC_mapModule;
	 * var qvtrTransformation : qvtrelation::RelationalTransformation[1] := when_TC_mapModule.qvtr_qvtrTransformation;
	 * set trace.qvtr_qvtrTransformation := qvtrTransformation;
	 *
	 */
	protected boolean MAP_m_TC__mapOperatorCallExp_qvtr_qvtrTransformation_p6(final /*@NonInvalid*/ @NonNull TC_mapOperatorCallExp trace_16)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOperatorCallExp_qvtr_qvtrTransformation_p6" + ", " + trace_16);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_16.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_6;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression temp1_atlExpression = trace_16.getAtl_atlExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_atlExpression instanceof OperatorCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull OperatorCallExp symbol_1 = (OperatorCallExp)temp1_atlExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Module atl_atlModule = trace_16.getAtl_atlModule();
				final /*@NonInvalid*/ @Nullable TC_mapModule TC_mapModule = OPPOSITE_OF_TC_mapModule_atl_atlModule.get(atl_atlModule);
				final /*@NonInvalid*/ boolean symbol_2 = TC_mapModule != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TC_mapModule;
				if (symbol_2) {
					if (TC_mapModule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull RelationalTransformation qvtr_qvtrTransformation = TC_mapModule.getQvtr_qvtrTransformation();
					// mapping statements
					trace_16.setQvtr_qvtrTransformation(qvtr_qvtrTransformation);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapOperatorCallExp_qvtr_qvtrTransformation_p6 = ValueUtil.TRUE_VALUE;
					raw_when_TC_mapModule = m_TC__mapOperatorCallExp_qvtr_qvtrTransformation_p6;
				}
				else {
					raw_when_TC_mapModule = ValueUtil.FALSE_VALUE;
				}
				symbol_5 = raw_when_TC_mapModule;
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
			AbstractTransformer.INVOCATIONS.println((symbol_6 ? "done "  : "fail ") + "MAP_m_TC__mapOperatorCallExp_qvtr_qvtrTransformation_p6");
		}
		return symbol_6;
	}

	/**
	 *
	 * map m_TC__mapOperatorCallExp_qvtr_qvtrExpression_p2 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapOperatorCallExp[1];
	 * check trace.status;
	 * var operationName : String[1] := trace.primitive_operationName;
	 * new:qvtr qvtrExpression : OperationCallExp[1];
	 * set qvtrExpression.name := operationName;
	 * set trace.qvtr_qvtrExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_m_TC__mapOperatorCallExp_qvtr_qvtrExpression_p2(final /*@NonInvalid*/ @NonNull TC_mapOperatorCallExp trace_17)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOperatorCallExp_qvtr_qvtrExpression_p2" + ", " + trace_17);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_17.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_3;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String primitive_operationName = trace_17.getPrimitive_operationName();
			// creations
			final org.eclipse.ocl.pivot.@NonNull OperationCallExp qvtrExpression = PivotFactory.eINSTANCE.createOperationCallExp();
			models[2/*qvtr*/].add(qvtrExpression, false);
			// mapping statements
			qvtrExpression.setName(primitive_operationName);
			trace_17.setQvtr_qvtrExpression(qvtrExpression);
			final /*@Thrown*/ @Nullable Boolean m_TC__mapOperatorCallExp_qvtr_qvtrExpression_p2 = ValueUtil.TRUE_VALUE;
			symbol_3 = m_TC__mapOperatorCallExp_qvtr_qvtrExpression_p2;
		}
		else {
			symbol_3 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_3 ? "done "  : "fail ") + "MAP_m_TC__mapOperatorCallExp_qvtr_qvtrExpression_p2");
		}
		return symbol_3;
	}

	/**
	 *
	 * map m_TC__mapBinding_atl_atlBinding_atl_atlExpression_at in ATL2QVTr {
	 *
	 *   guard:atl atlBinding : ATL::Binding[1];
	 * check var atlOutPatternElement : ATL::SimpleOutPatternElement[1] := atlBinding.outPatternElement;
	 * var propertyName : String[1] := atlBinding.propertyName;
	 * var atlExpression : OCL::OclExpression[1] := atlBinding.value;
	 * var when_TI_mapOclExpression : trace_ATL2QVTr::TI_mapOclExpression[1] := atlExpression.TI_mapOclExpression;
	 * var when_TC_mapSimpleOutPatternElement : trace_ATL2QVTr::TC_mapSimpleOutPatternElement[1] := atlOutPatternElement.TC_mapSimpleOutPatternElement;
	 * var qvtrTemplate : qvttemplate::ObjectTemplateExp[1] := when_TC_mapSimpleOutPatternElement.qvtr_qvtrTemplate;
	 * var qvtrExpression : OCLExpression[1] := when_TI_mapOclExpression.qvtr_qvtrExpression;
	 * var type : Type[?] := qvtrTemplate.type;
	 * var getProperty1 : Property[1] := this.getProperty(type, propertyName);
	 * contained new:qvtr qvtrPart : qvttemplate::PropertyTemplateItem[1];
	 * new:middle trace : trace_ATL2QVTr::TC_mapBinding[1];
	 * set trace.primitive_propertyName := propertyName;
	 * set trace.atl_atlBinding := atlBinding;
	 * set trace.atl_atlExpression := atlExpression;
	 * set trace.atl_atlOutPatternElement := atlOutPatternElement;
	 * set trace.qvtr_qvtrExpression := qvtrExpression;
	 * set trace.qvtr_qvtrPart := qvtrPart;
	 * set trace.qvtr_qvtrTemplate := qvtrTemplate;
	 * set qvtrPart.objContainer := qvtrTemplate;
	 * set qvtrPart.referredProperty := getProperty1;
	 * set qvtrPart.value := qvtrExpression;
	 *
	 */
	protected boolean MAP_m_TC__mapBinding_atl_atlBinding_atl_atlExpression_at(final /*@NonInvalid*/ @NonNull Binding atlBinding)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapBinding_atl_atlBinding_atl_atlExpression_at" + ", " + atlBinding);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull OutPatternElement temp1_atlOutPatternElement = atlBinding.getOutPatternElement();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_atlOutPatternElement instanceof SimpleOutPatternElement;
		/*@Thrown*/ @Nullable Boolean symbol_15;
		if (symbol_0) {
			final /*@NonInvalid*/ @NonNull SimpleOutPatternElement symbol_1 = (SimpleOutPatternElement)temp1_atlOutPatternElement;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull String propertyName = atlBinding.getPropertyName();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression value = atlBinding.getValue();
			final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(value);
			final /*@NonInvalid*/ boolean symbol_2 = TI_mapOclExpression != null;
			/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression;
			if (symbol_2) {
				if (TI_mapOclExpression == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@NonInvalid*/ @Nullable TC_mapSimpleOutPatternElement TC_mapSimpleOutPatternElement = OPPOSITE_OF_TC_mapSimpleOutPatternElement_atl_atlElement.get(symbol_1);
				final /*@NonInvalid*/ boolean symbol_3 = TC_mapSimpleOutPatternElement != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TC_mapSimpleOutPatternElement;
				if (symbol_3) {
					if (TC_mapSimpleOutPatternElement == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull ObjectTemplateExp qvtr_qvtrTemplate = TC_mapSimpleOutPatternElement.getQvtr_qvtrTemplate();
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression qvtr_qvtrExpression = TI_mapOclExpression.getQvtr_qvtrExpression();
					final /*@Thrown*/ @Nullable Type type_2 = qvtr_qvtrTemplate.getType();
					final /*@Thrown*/ @NonNull Property getProperty = ((FUN_getProperty)FTOR_getProperty.getUniqueComputation(this, type_2, propertyName)).instance;
					// creations
					final @NonNull PropertyTemplateItem qvtrPart = QVTtemplateFactory.eINSTANCE.createPropertyTemplateItem();
					models[2/*qvtr*/].add(qvtrPart, true);
					final @SuppressWarnings("null")@NonNull TC_mapBinding trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapBinding();
					models[0/*middle*/].add(trace_37, false);
					// mapping statements
					trace_37.setPrimitive_propertyName(propertyName);
					trace_37.setAtl_atlBinding(atlBinding);
					trace_37.setAtl_atlExpression(value);
					trace_37.setAtl_atlOutPatternElement(symbol_1);
					trace_37.setQvtr_qvtrExpression(qvtr_qvtrExpression);
					trace_37.setQvtr_qvtrPart(qvtrPart);
					trace_37.setQvtr_qvtrTemplate(qvtr_qvtrTemplate);
					qvtrPart.setObjContainer(qvtr_qvtrTemplate);
					qvtrPart.setReferredProperty(getProperty);
					qvtrPart.setValue(qvtr_qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapBinding_atl_atlBinding_atl_atlExpression_at = ValueUtil.TRUE_VALUE;
					raw_when_TC_mapSimpleOutPatternElement = m_TC__mapBinding_atl_atlBinding_atl_atlExpression_at;
				}
				else {
					raw_when_TC_mapSimpleOutPatternElement = ValueUtil.FALSE_VALUE;
				}
				raw_when_TI_mapOclExpression = raw_when_TC_mapSimpleOutPatternElement;
			}
			else {
				raw_when_TI_mapOclExpression = ValueUtil.FALSE_VALUE;
			}
			symbol_15 = raw_when_TI_mapOclExpression;
		}
		else {
			symbol_15 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_15 ? "done "  : "fail ") + "MAP_m_TC__mapBinding_atl_atlBinding_atl_atlExpression_at");
		}
		return symbol_15;
	}

	/**
	 *
	 * map m_TC__mapInPattern__filter_atl_atlExpression_atl_atl in ATL2QVTr {
	 * guard:atl atlPattern : ATL::InPattern[1];
	 * var atlExpression : OCL::OclExpression[1] := atlPattern.filter;
	 * var atlRule : ATL::MatchedRule[1] := atlPattern.rule;
	 * var when_TC_mapInPattern : trace_ATL2QVTr::TC_mapInPattern[1] := atlPattern.TC_mapInPattern;
	 * var when_TC_mapMatchedRule : trace_ATL2QVTr::TC_mapMatchedRule[1] := atlRule.TC_mapMatchedRule;
	 * var when_TI_mapOclExpression : trace_ATL2QVTr::TI_mapOclExpression[1] := atlExpression.TI_mapOclExpression;
	 * var qvtrDomain : qvtrelation::RelationDomain[1] := when_TC_mapInPattern.qvtr_qvtrDomain;
	 * var qvtrRelation : qvtrelation::Relation[1] := when_TC_mapMatchedRule.qvtr_qvtrRelation;
	 * var qvtrExpression : OCLExpression[1] := when_TI_mapOclExpression.qvtr_qvtrExpression;
	 * new:qvtr p : qvtbase::Predicate[1];
	 * new:middle trace : trace_ATL2QVTr::TC_mapInPattern_filter[1];
	 * contained new:qvtr w : qvtbase::Pattern[1];
	 * set qvtrRelation.when := w;
	 * set qvtrDomain.rule := qvtrRelation;
	 * set w.predicate := p;
	 * set trace.atl_atlExpression := atlExpression;
	 * set trace.atl_atlPattern := atlPattern;
	 * set trace.atl_atlRule := atlRule;
	 * set trace.qvtr_p := p;
	 * set trace.qvtr_qvtrDomain := qvtrDomain;
	 * set trace.qvtr_qvtrExpression := qvtrExpression;
	 * set trace.qvtr_qvtrRelation := qvtrRelation;
	 * set trace.qvtr_w := w;
	 * set p.conditionExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_m_TC__mapInPattern__filter_atl_atlExpression_atl_atl(final /*@NonInvalid*/ @NonNull InPattern atlPattern_1)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapInPattern__filter_atl_atlExpression_atl_atl" + ", " + atlPattern_1);
		}
		final /*@NonInvalid*/ @Nullable OclExpression filter = atlPattern_1.getFilter();
		final /*@NonInvalid*/ boolean symbol_0 = filter != null;
		/*@Thrown*/ @Nullable Boolean raw_atlExpression;
		if (symbol_0) {
			if (filter == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull MatchedRule rule = atlPattern_1.getRule();
			final /*@NonInvalid*/ @Nullable TC_mapInPattern TC_mapInPattern = OPPOSITE_OF_TC_mapInPattern_atl_atlPattern.get(atlPattern_1);
			final /*@NonInvalid*/ boolean symbol_1 = TC_mapInPattern != null;
			/*@Thrown*/ @Nullable Boolean raw_when_TC_mapInPattern;
			if (symbol_1) {
				if (TC_mapInPattern == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				final /*@NonInvalid*/ @Nullable TC_mapMatchedRule TC_mapMatchedRule = OPPOSITE_OF_TC_mapMatchedRule_atl_matchedRule.get(rule);
				final /*@NonInvalid*/ boolean symbol_2 = TC_mapMatchedRule != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TC_mapMatchedRule;
				if (symbol_2) {
					if (TC_mapMatchedRule == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(filter);
					final /*@Thrown*/ boolean symbol_3 = TI_mapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression;
					if (symbol_3) {
						if (TI_mapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull RelationDomain qvtr_qvtrDomain = TC_mapInPattern.getQvtr_qvtrDomain();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull Relation qvtr_qvtrRelation = TC_mapMatchedRule.getQvtr_qvtrRelation();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull OCLExpression qvtr_qvtrExpression = TI_mapOclExpression.getQvtr_qvtrExpression();
						// creations
						final @NonNull Predicate p = QVTbaseFactory.eINSTANCE.createPredicate();
						models[2/*qvtr*/].add(p, false);
						final @SuppressWarnings("null")@NonNull TC_mapInPattern_filter trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapInPattern_filter();
						models[0/*middle*/].add(trace_37, false);
						final @NonNull Pattern w = QVTbaseFactory.eINSTANCE.createPattern();
						models[2/*qvtr*/].add(w, true);
						// mapping statements
						qvtr_qvtrRelation.setWhen(w);
						qvtr_qvtrDomain.setRule(qvtr_qvtrRelation);
						w.getPredicate().add(p);
						trace_37.setAtl_atlExpression(filter);
						trace_37.setAtl_atlPattern(atlPattern_1);
						trace_37.setAtl_atlRule(rule);
						trace_37.setQvtr_p(p);
						trace_37.setQvtr_qvtrDomain(qvtr_qvtrDomain);
						trace_37.setQvtr_qvtrExpression(qvtr_qvtrExpression);
						trace_37.setQvtr_qvtrRelation(qvtr_qvtrRelation);
						trace_37.setQvtr_w(w);
						p.setConditionExpression(qvtr_qvtrExpression);
						final /*@Thrown*/ @Nullable Boolean m_TC__mapInPattern__filter_atl_atlExpression_atl_atl = ValueUtil.TRUE_VALUE;
						raw_when_TI_mapOclExpression = m_TC__mapInPattern__filter_atl_atlExpression_atl_atl;
					}
					else {
						raw_when_TI_mapOclExpression = ValueUtil.FALSE_VALUE;
					}
					raw_when_TC_mapMatchedRule = raw_when_TI_mapOclExpression;
				}
				else {
					raw_when_TC_mapMatchedRule = ValueUtil.FALSE_VALUE;
				}
				raw_when_TC_mapInPattern = raw_when_TC_mapMatchedRule;
			}
			else {
				raw_when_TC_mapInPattern = ValueUtil.FALSE_VALUE;
			}
			raw_atlExpression = raw_when_TC_mapInPattern;
		}
		else {
			raw_atlExpression = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_atlExpression ? "done "  : "fail ") + "MAP_m_TC__mapInPattern__filter_atl_atlExpression_atl_atl");
		}
		return raw_atlExpression;
	}

	/**
	 *
	 * map m_TC__mapOperationCallExp__argument_atl_atlArgument_ in ATL2QVTr {
	 * guard:atl atlArgument : OCL::OclExpression[1];
	 * var atlParent : OCL::OperationCallExp[1] := atlArgument.parentOperation;
	 * check var when_TI_mapOperationCallExp : trace_ATL2QVTr::TI_mapOperationCallExp[1] := atlParent.TI_mapOclExpression;
	 * check var qvtrParent : OperationCallExp[1] := when_TI_mapOperationCallExp.qvtr_qvtrExpression;
	 * var when_TI_mapOclExpression : trace_ATL2QVTr::TI_mapOclExpression[1] := atlArgument.TI_mapOclExpression;
	 * var qvtrArgument : OCLExpression[1] := when_TI_mapOclExpression.qvtr_qvtrExpression;
	 * new:middle trace : trace_ATL2QVTr::TC_mapOperationCallExp_argument[1];
	 * set trace.atl_atlArgument := atlArgument;
	 * set trace.atl_atlParent := atlParent;
	 * set trace.qvtr_qvtrArgument := qvtrArgument;
	 * set trace.qvtr_qvtrParent := qvtrParent;
	 * set qvtrParent.ownedArguments := qvtrArgument;
	 *
	 */
	protected boolean MAP_m_TC__mapOperationCallExp__argument_atl_atlArgument_(final /*@NonInvalid*/ @NonNull OclExpression atlArgument)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOperationCallExp__argument_atl_atlArgument_" + ", " + atlArgument);
		}
		final /*@NonInvalid*/ org.eclipse.m2m.atl.common.OCL.@Nullable OperationCallExp parentOperation = atlArgument.getParentOperation();
		final /*@NonInvalid*/ boolean symbol_0 = parentOperation != null;
		/*@Thrown*/ @Nullable Boolean raw_atlParent;
		if (symbol_0) {
			if (parentOperation == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@Thrown*/ @Nullable TI_mapOclExpression temp1_when_TI_mapOperationCallExp = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(parentOperation);
			final /*@NonInvalid*/ boolean symbol_1 = temp1_when_TI_mapOperationCallExp instanceof TI_mapOperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_13;
			if (symbol_1) {
				final /*@Thrown*/ @Nullable TI_mapOperationCallExp symbol_2 = (TI_mapOperationCallExp)temp1_when_TI_mapOperationCallExp;
				if (symbol_2 == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull OCLExpression temp1_qvtrParent = symbol_2.getQvtr_qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_3 = temp1_qvtrParent instanceof org.eclipse.ocl.pivot.OperationCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_12;
				if (symbol_3) {
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_4 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrParent;
					final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atlArgument);
					final /*@NonInvalid*/ boolean symbol_5 = TI_mapOclExpression != null;
					/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression;
					if (symbol_5) {
						if (TI_mapOclExpression == null) {
							throw new InvalidEvaluationException("Null where non-null value required");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull OCLExpression qvtr_qvtrExpression = TI_mapOclExpression.getQvtr_qvtrExpression();
						// creations
						final @SuppressWarnings("null")@NonNull TC_mapOperationCallExp_argument trace_37 = trace_ATL2QVTrFactory.eINSTANCE.createTC_mapOperationCallExp_argument();
						models[0/*middle*/].add(trace_37, false);
						// mapping statements
						trace_37.setAtl_atlArgument(atlArgument);
						trace_37.setAtl_atlParent(parentOperation);
						trace_37.setQvtr_qvtrArgument(qvtr_qvtrExpression);
						trace_37.setQvtr_qvtrParent(symbol_4);
						symbol_4.getOwnedArguments().add(qvtr_qvtrExpression);
						final /*@Thrown*/ @Nullable Boolean m_TC__mapOperationCallExp__argument_atl_atlArgument_ = ValueUtil.TRUE_VALUE;
						raw_when_TI_mapOclExpression = m_TC__mapOperationCallExp__argument_atl_atlArgument_;
					}
					else {
						raw_when_TI_mapOclExpression = ValueUtil.FALSE_VALUE;
					}
					symbol_12 = raw_when_TI_mapOclExpression;
				}
				else {
					symbol_12 = ValueUtil.FALSE_VALUE;
				}
				symbol_13 = symbol_12;
			}
			else {
				symbol_13 = ValueUtil.FALSE_VALUE;
			}
			raw_atlParent = symbol_13;
		}
		else {
			raw_atlParent = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((raw_atlParent ? "done "  : "fail ") + "MAP_m_TC__mapOperationCallExp__argument_atl_atlArgument_");
		}
		return raw_atlParent;
	}

	/**
	 *
	 * map m_TC__mapHelper__Attribute_qvtr_qvtrExpression_p3 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapHelper_Attribute[1];
	 * check trace.status;
	 * var atlExpression : OCL::OclExpression[1] := trace.atl_atlExpression;
	 * var qvtrFunction : qvtbase::Function[1] := trace.qvtr_qvtrFunction;
	 * var when_TI_mapOclExpression : trace_ATL2QVTr::TI_mapOclExpression[1] := atlExpression.TI_mapOclExpression;
	 * var qvtrExpression : OCLExpression[1] := when_TI_mapOclExpression.qvtr_qvtrExpression;
	 * set trace.qvtr_qvtrExpression := qvtrExpression;
	 * set qvtrFunction.queryExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_m_TC__mapHelper__Attribute_qvtr_qvtrExpression_p3(final /*@NonInvalid*/ @NonNull TC_mapHelper_Attribute trace_18)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapHelper__Attribute_qvtr_qvtrExpression_p3" + ", " + trace_18);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_18.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_4;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression atl_atlExpression = trace_18.getAtl_atlExpression();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Function qvtr_qvtrFunction = trace_18.getQvtr_qvtrFunction();
			final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlExpression);
			final /*@NonInvalid*/ boolean symbol_0 = TI_mapOclExpression != null;
			/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression;
			if (symbol_0) {
				if (TI_mapOclExpression == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull OCLExpression qvtr_qvtrExpression = TI_mapOclExpression.getQvtr_qvtrExpression();
				// mapping statements
				trace_18.setQvtr_qvtrExpression(qvtr_qvtrExpression);
				qvtr_qvtrFunction.setQueryExpression(qvtr_qvtrExpression);
				final /*@Thrown*/ @Nullable Boolean m_TC__mapHelper__Attribute_qvtr_qvtrExpression_p3 = ValueUtil.TRUE_VALUE;
				raw_when_TI_mapOclExpression = m_TC__mapHelper__Attribute_qvtr_qvtrExpression_p3;
			}
			else {
				raw_when_TI_mapOclExpression = ValueUtil.FALSE_VALUE;
			}
			symbol_4 = raw_when_TI_mapOclExpression;
		}
		else {
			symbol_4 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_4 ? "done "  : "fail ") + "MAP_m_TC__mapHelper__Attribute_qvtr_qvtrExpression_p3");
		}
		return symbol_4;
	}

	/**
	 *
	 * map m_TC__mapHelper__Operation_qvtr_qvtrExpression_p3 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapHelper_Operation[1];
	 * check trace.status;
	 * var atlExpression : OCL::OclExpression[1] := trace.atl_atlExpression;
	 * var qvtrFunction : qvtbase::Function[1] := trace.qvtr_qvtrFunction;
	 * var when_TI_mapOclExpression : trace_ATL2QVTr::TI_mapOclExpression[1] := atlExpression.TI_mapOclExpression;
	 * var qvtrExpression : OCLExpression[1] := when_TI_mapOclExpression.qvtr_qvtrExpression;
	 * set trace.qvtr_qvtrExpression := qvtrExpression;
	 * set qvtrFunction.queryExpression := qvtrExpression;
	 *
	 */
	protected boolean MAP_m_TC__mapHelper__Operation_qvtr_qvtrExpression_p3(final /*@NonInvalid*/ @NonNull TC_mapHelper_Operation trace_19)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapHelper__Operation_qvtr_qvtrExpression_p3" + ", " + trace_19);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_19.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_4;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OclExpression atl_atlExpression = trace_19.getAtl_atlExpression();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Function qvtr_qvtrFunction = trace_19.getQvtr_qvtrFunction();
			final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlExpression);
			final /*@NonInvalid*/ boolean symbol_0 = TI_mapOclExpression != null;
			/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression;
			if (symbol_0) {
				if (TI_mapOclExpression == null) {
					throw new InvalidEvaluationException("Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull OCLExpression qvtr_qvtrExpression = TI_mapOclExpression.getQvtr_qvtrExpression();
				// mapping statements
				trace_19.setQvtr_qvtrExpression(qvtr_qvtrExpression);
				qvtr_qvtrFunction.setQueryExpression(qvtr_qvtrExpression);
				final /*@Thrown*/ @Nullable Boolean m_TC__mapHelper__Operation_qvtr_qvtrExpression_p3 = ValueUtil.TRUE_VALUE;
				raw_when_TI_mapOclExpression = m_TC__mapHelper__Operation_qvtr_qvtrExpression_p3;
			}
			else {
				raw_when_TI_mapOclExpression = ValueUtil.FALSE_VALUE;
			}
			symbol_4 = raw_when_TI_mapOclExpression;
		}
		else {
			symbol_4 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_4 ? "done "  : "fail ") + "MAP_m_TC__mapHelper__Operation_qvtr_qvtrExpression_p3");
		}
		return symbol_4;
	}

	/**
	 *
	 * map m_TC__mapIfExp_qvtr_qvtrCondition_p3 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapIfExp[1];
	 * check trace.status;
	 * check var qvtrExpression : IfExp[1] := trace.qvtr_qvtrExpression;
	 * var atlCondition : OCL::OclExpression[1] := trace.atl_atlCondition;
	 * var when_TI_mapOclExpression : trace_ATL2QVTr::TI_mapOclExpression[1] := atlCondition.TI_mapOclExpression;
	 * var qvtrCondition : OCLExpression[1] := when_TI_mapOclExpression.qvtr_qvtrExpression;
	 * set trace.qvtr_qvtrCondition := qvtrCondition;
	 * set qvtrExpression.ownedCondition := qvtrCondition;
	 *
	 */
	protected boolean MAP_m_TC__mapIfExp_qvtr_qvtrCondition_p3(final /*@NonInvalid*/ @NonNull TC_mapIfExp trace_20)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapIfExp_qvtr_qvtrCondition_p3" + ", " + trace_20);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_20.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = trace_20.getQvtr_qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.IfExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull IfExp symbol_1 = (org.eclipse.ocl.pivot.IfExp)temp1_qvtrExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression atl_atlCondition = trace_20.getAtl_atlCondition();
				final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlCondition);
				final /*@NonInvalid*/ boolean symbol_2 = TI_mapOclExpression != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression;
				if (symbol_2) {
					if (TI_mapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression qvtr_qvtrExpression = TI_mapOclExpression.getQvtr_qvtrExpression();
					// mapping statements
					trace_20.setQvtr_qvtrCondition(qvtr_qvtrExpression);
					symbol_1.setOwnedCondition(qvtr_qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapIfExp_qvtr_qvtrCondition_p3 = ValueUtil.TRUE_VALUE;
					raw_when_TI_mapOclExpression = m_TC__mapIfExp_qvtr_qvtrCondition_p3;
				}
				else {
					raw_when_TI_mapOclExpression = ValueUtil.FALSE_VALUE;
				}
				symbol_6 = raw_when_TI_mapOclExpression;
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
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_m_TC__mapIfExp_qvtr_qvtrCondition_p3");
		}
		return symbol_7;
	}

	/**
	 *
	 * map m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p3 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Helper[1];
	 * check trace.status;
	 * check var qvtrExpression : OperationCallExp[1] := trace.qvtr_qvtrExpression;
	 * var atlSource : OCL::OclExpression[1] := trace.atl_atlSource;
	 * var when_TI_mapOclExpression : trace_ATL2QVTr::TI_mapOclExpression[1] := atlSource.TI_mapOclExpression;
	 * var qvtrSourceArgument : OCLExpression[1] := when_TI_mapOclExpression.qvtr_qvtrExpression;
	 * set trace.qvtr_qvtrSourceArgument := qvtrSourceArgument;
	 * set qvtrExpression.ownedArguments := qvtrSourceArgument;
	 *
	 */
	protected boolean MAP_m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p3(final /*@NonInvalid*/ @NonNull TC_mapNavigationOrAttributeCallExp_Helper trace_21)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p3" + ", " + trace_21);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_21.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = trace_21.getQvtr_qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression atl_atlSource = trace_21.getAtl_atlSource();
				final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlSource);
				final /*@NonInvalid*/ boolean symbol_2 = TI_mapOclExpression != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression;
				if (symbol_2) {
					if (TI_mapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression qvtr_qvtrExpression = TI_mapOclExpression.getQvtr_qvtrExpression();
					// mapping statements
					trace_21.setQvtr_qvtrSourceArgument(qvtr_qvtrExpression);
					symbol_1.getOwnedArguments().add(qvtr_qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p3 = ValueUtil.TRUE_VALUE;
					raw_when_TI_mapOclExpression = m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p3;
				}
				else {
					raw_when_TI_mapOclExpression = ValueUtil.FALSE_VALUE;
				}
				symbol_6 = raw_when_TI_mapOclExpression;
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
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_m_TC__mapNavigationOrAttributeCallExp__Helper_qvtr_q_p3");
		}
		return symbol_7;
	}

	/**
	 *
	 * map m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p3 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Property[1];
	 * check trace.status;
	 * check var qvtrExpression : PropertyCallExp[1] := trace.qvtr_qvtrExpression;
	 * var atlSource : OCL::OclExpression[1] := trace.atl_atlSource;
	 * var when_TI_mapOclExpression : trace_ATL2QVTr::TI_mapOclExpression[1] := atlSource.TI_mapOclExpression;
	 * var qvtrSource : OCLExpression[1] := when_TI_mapOclExpression.qvtr_qvtrExpression;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 * set trace.qvtr_qvtrSource := qvtrSource;
	 *
	 */
	protected boolean MAP_m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p3(final /*@NonInvalid*/ @NonNull TC_mapNavigationOrAttributeCallExp_Property trace_22)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p3" + ", " + trace_22);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_22.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = trace_22.getQvtr_qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof PropertyCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull PropertyCallExp symbol_1 = (PropertyCallExp)temp1_qvtrExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression atl_atlSource = trace_22.getAtl_atlSource();
				final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlSource);
				final /*@NonInvalid*/ boolean symbol_2 = TI_mapOclExpression != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression;
				if (symbol_2) {
					if (TI_mapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression qvtr_qvtrExpression = TI_mapOclExpression.getQvtr_qvtrExpression();
					// mapping statements
					symbol_1.setOwnedSource(qvtr_qvtrExpression);
					trace_22.setQvtr_qvtrSource(qvtr_qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p3 = ValueUtil.TRUE_VALUE;
					raw_when_TI_mapOclExpression = m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p3;
				}
				else {
					raw_when_TI_mapOclExpression = ValueUtil.FALSE_VALUE;
				}
				symbol_6 = raw_when_TI_mapOclExpression;
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
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p3");
		}
		return symbol_7;
	}

	/**
	 *
	 * map m_TC__mapOperationCallExp__Helper_qvtr_qvtrSourceArg_p3 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapOperationCallExp_Helper[1];
	 * check trace.status;
	 * check var qvtrExpression : OperationCallExp[1] := trace.qvtr_qvtrExpression;
	 * var atlSource : OCL::OclExpression[1] := trace.atl_atlSource;
	 * var when_TI_mapOclExpression : trace_ATL2QVTr::TI_mapOclExpression[1] := atlSource.TI_mapOclExpression;
	 * var qvtrSourceArgument : OCLExpression[1] := when_TI_mapOclExpression.qvtr_qvtrExpression;
	 * set trace.qvtr_qvtrSourceArgument := qvtrSourceArgument;
	 * set qvtrExpression.ownedArguments := qvtrSourceArgument;
	 *
	 */
	protected boolean MAP_m_TC__mapOperationCallExp__Helper_qvtr_qvtrSourceArg_p3(final /*@NonInvalid*/ @NonNull TC_mapOperationCallExp_Helper trace_23)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOperationCallExp__Helper_qvtr_qvtrSourceArg_p3" + ", " + trace_23);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_23.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = trace_23.getQvtr_qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression atl_atlSource = trace_23.getAtl_atlSource();
				final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlSource);
				final /*@NonInvalid*/ boolean symbol_2 = TI_mapOclExpression != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression;
				if (symbol_2) {
					if (TI_mapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression qvtr_qvtrExpression = TI_mapOclExpression.getQvtr_qvtrExpression();
					// mapping statements
					trace_23.setQvtr_qvtrSourceArgument(qvtr_qvtrExpression);
					symbol_1.getOwnedArguments().add(qvtr_qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapOperationCallExp__Helper_qvtr_qvtrSourceArg_p3 = ValueUtil.TRUE_VALUE;
					raw_when_TI_mapOclExpression = m_TC__mapOperationCallExp__Helper_qvtr_qvtrSourceArg_p3;
				}
				else {
					raw_when_TI_mapOclExpression = ValueUtil.FALSE_VALUE;
				}
				symbol_6 = raw_when_TI_mapOclExpression;
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
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_m_TC__mapOperationCallExp__Helper_qvtr_qvtrSourceArg_p3");
		}
		return symbol_7;
	}

	/**
	 *
	 * map m_TC__mapOperationCallExp__Operation_qvtr_qvtrSource_p3 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapOperationCallExp_Operation[1];
	 * check trace.status;
	 * check var qvtrExpression : OperationCallExp[1] := trace.qvtr_qvtrExpression;
	 * var atlSource : OCL::OclExpression[1] := trace.atl_atlSource;
	 * var when_TI_mapOclExpression : trace_ATL2QVTr::TI_mapOclExpression[1] := atlSource.TI_mapOclExpression;
	 * var qvtrSource : OCLExpression[1] := when_TI_mapOclExpression.qvtr_qvtrExpression;
	 * set trace.qvtr_qvtrSource := qvtrSource;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 *
	 */
	protected boolean MAP_m_TC__mapOperationCallExp__Operation_qvtr_qvtrSource_p3(final /*@NonInvalid*/ @NonNull TC_mapOperationCallExp_Operation trace_24)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOperationCallExp__Operation_qvtr_qvtrSource_p3" + ", " + trace_24);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_24.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = trace_24.getQvtr_qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression atl_atlSource = trace_24.getAtl_atlSource();
				final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlSource);
				final /*@NonInvalid*/ boolean symbol_2 = TI_mapOclExpression != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression;
				if (symbol_2) {
					if (TI_mapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression qvtr_qvtrExpression = TI_mapOclExpression.getQvtr_qvtrExpression();
					// mapping statements
					trace_24.setQvtr_qvtrSource(qvtr_qvtrExpression);
					symbol_1.setOwnedSource(qvtr_qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapOperationCallExp__Operation_qvtr_qvtrSource_p3 = ValueUtil.TRUE_VALUE;
					raw_when_TI_mapOclExpression = m_TC__mapOperationCallExp__Operation_qvtr_qvtrSource_p3;
				}
				else {
					raw_when_TI_mapOclExpression = ValueUtil.FALSE_VALUE;
				}
				symbol_6 = raw_when_TI_mapOclExpression;
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
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_m_TC__mapOperationCallExp__Operation_qvtr_qvtrSource_p3");
		}
		return symbol_7;
	}

	/**
	 *
	 * map m_TC__mapOperatorCallExp_qvtr_qvtrSource_p3 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapOperatorCallExp[1];
	 * check trace.status;
	 * check var qvtrExpression : OperationCallExp[1] := trace.qvtr_qvtrExpression;
	 * var atlSource : OCL::OclExpression[1] := trace.atl_atlSource;
	 * var when_TI_mapOclExpression : trace_ATL2QVTr::TI_mapOclExpression[1] := atlSource.TI_mapOclExpression;
	 * var qvtrSource : OCLExpression[1] := when_TI_mapOclExpression.qvtr_qvtrExpression;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 * set trace.qvtr_qvtrSource := qvtrSource;
	 *
	 */
	protected boolean MAP_m_TC__mapOperatorCallExp_qvtr_qvtrSource_p3(final /*@NonInvalid*/ @NonNull TC_mapOperatorCallExp trace_25)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOperatorCallExp_qvtr_qvtrSource_p3" + ", " + trace_25);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_25.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = trace_25.getQvtr_qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression atl_atlSource = trace_25.getAtl_atlSource();
				final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlSource);
				final /*@NonInvalid*/ boolean symbol_2 = TI_mapOclExpression != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression;
				if (symbol_2) {
					if (TI_mapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression qvtr_qvtrExpression = TI_mapOclExpression.getQvtr_qvtrExpression();
					// mapping statements
					symbol_1.setOwnedSource(qvtr_qvtrExpression);
					trace_25.setQvtr_qvtrSource(qvtr_qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapOperatorCallExp_qvtr_qvtrSource_p3 = ValueUtil.TRUE_VALUE;
					raw_when_TI_mapOclExpression = m_TC__mapOperatorCallExp_qvtr_qvtrSource_p3;
				}
				else {
					raw_when_TI_mapOclExpression = ValueUtil.FALSE_VALUE;
				}
				symbol_6 = raw_when_TI_mapOclExpression;
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
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_m_TC__mapOperatorCallExp_qvtr_qvtrSource_p3");
		}
		return symbol_7;
	}

	/**
	 *
	 * map m_TC__mapIfExp_qvtr_qvtrElse_p4 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapIfExp[1];
	 * check trace.status;
	 * check var qvtrExpression : IfExp[1] := trace.qvtr_qvtrExpression;
	 * var atlElse : OCL::OclExpression[1] := trace.atl_atlElse;
	 * var when_TI_mapOclExpression_1 : trace_ATL2QVTr::TI_mapOclExpression[1] := atlElse.TI_mapOclExpression;
	 * var qvtrElse : OCLExpression[1] := when_TI_mapOclExpression_1.qvtr_qvtrExpression;
	 * set qvtrExpression.ownedElse := qvtrElse;
	 * set trace.qvtr_qvtrElse := qvtrElse;
	 *
	 */
	protected boolean MAP_m_TC__mapIfExp_qvtr_qvtrElse_p4(final /*@NonInvalid*/ @NonNull TC_mapIfExp trace_26)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapIfExp_qvtr_qvtrElse_p4" + ", " + trace_26);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_26.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = trace_26.getQvtr_qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.IfExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull IfExp symbol_1 = (org.eclipse.ocl.pivot.IfExp)temp1_qvtrExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression atl_atlElse = trace_26.getAtl_atlElse();
				final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlElse);
				final /*@NonInvalid*/ boolean symbol_2 = TI_mapOclExpression != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression_1;
				if (symbol_2) {
					if (TI_mapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression qvtr_qvtrExpression = TI_mapOclExpression.getQvtr_qvtrExpression();
					// mapping statements
					symbol_1.setOwnedElse(qvtr_qvtrExpression);
					trace_26.setQvtr_qvtrElse(qvtr_qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapIfExp_qvtr_qvtrElse_p4 = ValueUtil.TRUE_VALUE;
					raw_when_TI_mapOclExpression_1 = m_TC__mapIfExp_qvtr_qvtrElse_p4;
				}
				else {
					raw_when_TI_mapOclExpression_1 = ValueUtil.FALSE_VALUE;
				}
				symbol_6 = raw_when_TI_mapOclExpression_1;
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
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_m_TC__mapIfExp_qvtr_qvtrElse_p4");
		}
		return symbol_7;
	}

	/**
	 *
	 * map m_TC__mapNavigationOrAttributeCallExp__Helper__CallE_p4 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Helper[1];
	 * check trace.status;
	 * check var qvtrExpression : OperationCallExp[1] := trace.qvtr_qvtrExpression;
	 * var qvtrSource : VariableExp[1] := trace.qvtr_qvtrSource;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 *
	 */
	protected boolean MAP_m_TC__mapNavigationOrAttributeCallExp__Helper__CallE_p4(final /*@NonInvalid*/ @NonNull TC_mapNavigationOrAttributeCallExp_Helper trace_27)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapNavigationOrAttributeCallExp__Helper__CallE_p4" + ", " + trace_27);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_27.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_5;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = trace_27.getQvtr_qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_4;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp qvtr_qvtrSource = trace_27.getQvtr_qvtrSource();
				// mapping statements
				symbol_1.setOwnedSource(qvtr_qvtrSource);
				final /*@Thrown*/ @Nullable Boolean m_TC__mapNavigationOrAttributeCallExp__Helper__CallE_p4 = ValueUtil.TRUE_VALUE;
				symbol_4 = m_TC__mapNavigationOrAttributeCallExp__Helper__CallE_p4;
			}
			else {
				symbol_4 = ValueUtil.FALSE_VALUE;
			}
			symbol_5 = symbol_4;
		}
		else {
			symbol_5 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_5 ? "done "  : "fail ") + "MAP_m_TC__mapNavigationOrAttributeCallExp__Helper__CallE_p4");
		}
		return symbol_5;
	}

	/**
	 *
	 * map m_TC__mapOperationCallExp__Helper__CallExp_ownedSour_p4 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapOperationCallExp_Helper[1];
	 * check trace.status;
	 * check var qvtrExpression : OperationCallExp[1] := trace.qvtr_qvtrExpression;
	 * var qvtrSource : VariableExp[1] := trace.qvtr_qvtrSource;
	 * set qvtrExpression.ownedSource := qvtrSource;
	 *
	 */
	protected boolean MAP_m_TC__mapOperationCallExp__Helper__CallExp_ownedSour_p4(final /*@NonInvalid*/ @NonNull TC_mapOperationCallExp_Helper trace_28)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOperationCallExp__Helper__CallExp_ownedSour_p4" + ", " + trace_28);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_28.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_5;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = trace_28.getQvtr_qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_4;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp qvtr_qvtrSource = trace_28.getQvtr_qvtrSource();
				// mapping statements
				symbol_1.setOwnedSource(qvtr_qvtrSource);
				final /*@Thrown*/ @Nullable Boolean m_TC__mapOperationCallExp__Helper__CallExp_ownedSour_p4 = ValueUtil.TRUE_VALUE;
				symbol_4 = m_TC__mapOperationCallExp__Helper__CallExp_ownedSour_p4;
			}
			else {
				symbol_4 = ValueUtil.FALSE_VALUE;
			}
			symbol_5 = symbol_4;
		}
		else {
			symbol_5 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_5 ? "done "  : "fail ") + "MAP_m_TC__mapOperationCallExp__Helper__CallExp_ownedSour_p4");
		}
		return symbol_5;
	}

	/**
	 *
	 * map m_TC__mapIfExp_qvtr_qvtrThen_p5 in ATL2QVTr {
	 * guard:middle trace : trace_ATL2QVTr::TC_mapIfExp[1];
	 * check trace.status;
	 * check var qvtrExpression : IfExp[1] := trace.qvtr_qvtrExpression;
	 * var atlThen : OCL::OclExpression[1] := trace.atl_atlThen;
	 * var when_TI_mapOclExpression_0 : trace_ATL2QVTr::TI_mapOclExpression[1] := atlThen.TI_mapOclExpression;
	 * var qvtrThen : OCLExpression[1] := when_TI_mapOclExpression_0.qvtr_qvtrExpression;
	 * set trace.qvtr_qvtrThen := qvtrThen;
	 * set qvtrExpression.ownedThen := qvtrThen;
	 *
	 */
	protected boolean MAP_m_TC__mapIfExp_qvtr_qvtrThen_p5(final /*@NonInvalid*/ @NonNull TC_mapIfExp trace_29)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapIfExp_qvtr_qvtrThen_p5" + ", " + trace_29);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_29.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = trace_29.getQvtr_qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.IfExp;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull IfExp symbol_1 = (org.eclipse.ocl.pivot.IfExp)temp1_qvtrExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OclExpression atl_atlThen = trace_29.getAtl_atlThen();
				final /*@NonInvalid*/ @Nullable TI_mapOclExpression TI_mapOclExpression = OPPOSITE_OF_TI_mapOclExpression_atl_atlExpression.get(atl_atlThen);
				final /*@NonInvalid*/ boolean symbol_2 = TI_mapOclExpression != null;
				/*@Thrown*/ @Nullable Boolean raw_when_TI_mapOclExpression_0;
				if (symbol_2) {
					if (TI_mapOclExpression == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OCLExpression qvtr_qvtrExpression = TI_mapOclExpression.getQvtr_qvtrExpression();
					// mapping statements
					trace_29.setQvtr_qvtrThen(qvtr_qvtrExpression);
					symbol_1.setOwnedThen(qvtr_qvtrExpression);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapIfExp_qvtr_qvtrThen_p5 = ValueUtil.TRUE_VALUE;
					raw_when_TI_mapOclExpression_0 = m_TC__mapIfExp_qvtr_qvtrThen_p5;
				}
				else {
					raw_when_TI_mapOclExpression_0 = ValueUtil.FALSE_VALUE;
				}
				symbol_6 = raw_when_TI_mapOclExpression_0;
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
			AbstractTransformer.INVOCATIONS.println((symbol_7 ? "done "  : "fail ") + "MAP_m_TC__mapIfExp_qvtr_qvtrThen_p5");
		}
		return symbol_7;
	}

	/**
	 *
	 * map m_TC__mapNavigationOrAttributeCallExp__Property__typ_p5 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Property[1];
	 * check trace.status;
	 * check var qvtrExpression : PropertyCallExp[1] := trace.qvtr_qvtrExpression;
	 * var qvtrSource : OCLExpression[1] := trace.qvtr_qvtrSource;
	 * var type : Type[?] := qvtrSource.type;
	 * var propertyName : String[1] := trace.primitive_propertyName;
	 * var qvtrProperty : Property[1] := this.getProperty(type, propertyName);
	 * var type1 : Type[?] := qvtrProperty.type;
	 * notify set qvtrExpression.type := type1;
	 *
	 */
	protected class MAP_m_TC__mapNavigationOrAttributeCallExp__Property__typ_p5 extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TC_mapNavigationOrAttributeCallExp_Property trace_30;

		public MAP_m_TC__mapNavigationOrAttributeCallExp__Property__typ_p5(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_30 = (TC_mapNavigationOrAttributeCallExp_Property)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @Nullable Boolean status = trace_30.getStatus();
			if (status == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (status) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = trace_30.getQvtr_qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof PropertyCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_4;
				if (symbol_0) {
					final /*@NonInvalid*/ @NonNull PropertyCallExp symbol_1 = (PropertyCallExp)temp1_qvtrExpression;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression qvtr_qvtrSource = trace_30.getQvtr_qvtrSource();
					objectManager.getting(qvtr_qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
					final /*@NonInvalid*/ @Nullable Type type_2 = qvtr_qvtrSource.getType();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String primitive_propertyName = trace_30.getPrimitive_propertyName();
					final /*@Thrown*/ @NonNull Property getProperty = ((FUN_getProperty)FTOR_getProperty.getUniqueComputation(ATL2QVTr.this, type_2, primitive_propertyName)).instance;
					objectManager.getting(getProperty, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
					final /*@Thrown*/ @Nullable Type type_3 = getProperty.getType();
					// mapping statements
					symbol_1.setType(type_3);
					objectManager.assigned(symbol_1, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_3);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapNavigationOrAttributeCallExp__Property__typ_p5 = ValueUtil.TRUE_VALUE;
					symbol_4 = m_TC__mapNavigationOrAttributeCallExp__Property__typ_p5;
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
			return idResolver.oclEquals(trace_30, thoseValues[0]);
		}
	}

	/**
	 *
	 * map m_TC__mapOperationCallExp__Operation__type_p5 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TC_mapOperationCallExp_Operation[1];
	 * check trace.status;
	 * check var qvtrExpression : OperationCallExp[1] := trace.qvtr_qvtrExpression;
	 * var qvtrSource : OCLExpression[1] := trace.qvtr_qvtrSource;
	 * var type : Type[?] := qvtrSource.type;
	 * var operationName : String[1] := trace.primitive_operationName;
	 * var qvtrOperation : Operation[1] := this.getOperation(type, operationName);
	 * var type1 : Type[?] := qvtrOperation.type;
	 * notify set qvtrExpression.type := type1;
	 *
	 */
	protected class MAP_m_TC__mapOperationCallExp__Operation__type_p5 extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TC_mapOperationCallExp_Operation trace_31;

		public MAP_m_TC__mapOperationCallExp__Operation__type_p5(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_31 = (TC_mapOperationCallExp_Operation)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @Nullable Boolean status = trace_31.getStatus();
			if (status == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (status) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = trace_31.getQvtr_qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_4;
				if (symbol_0) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression qvtr_qvtrSource = trace_31.getQvtr_qvtrSource();
					objectManager.getting(qvtr_qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
					final /*@NonInvalid*/ @Nullable Type type_2 = qvtr_qvtrSource.getType();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String primitive_operationName = trace_31.getPrimitive_operationName();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Operation getOperation = ((FUN_getOperation)FTOR_getOperation.getUniqueComputation(ATL2QVTr.this, type_2, primitive_operationName)).instance;
					objectManager.getting(getOperation, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
					final /*@Thrown*/ @Nullable Type type_3 = getOperation.getType();
					// mapping statements
					symbol_1.setType(type_3);
					objectManager.assigned(symbol_1, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_3);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapOperationCallExp__Operation__type_p5 = ValueUtil.TRUE_VALUE;
					symbol_4 = m_TC__mapOperationCallExp__Operation__type_p5;
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
			return idResolver.oclEquals(trace_31, thoseValues[0]);
		}
	}

	/**
	 *
	 * map m_TC__mapOperatorCallExp__type_p5 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TC_mapOperatorCallExp[1];
	 * check trace.status;
	 * check var qvtrExpression : OperationCallExp[1] := trace.qvtr_qvtrExpression;
	 * var qvtrSource : OCLExpression[1] := trace.qvtr_qvtrSource;
	 * var type : Type[?] := qvtrSource.type;
	 * var operationName : String[1] := trace.primitive_operationName;
	 * var qvtrOperation : Operation[1] := this.getOperation(type, operationName);
	 * var type1 : Type[?] := qvtrOperation.type;
	 * notify set qvtrExpression.type := type1;
	 *
	 */
	protected class MAP_m_TC__mapOperatorCallExp__type_p5 extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TC_mapOperatorCallExp trace_32;

		public MAP_m_TC__mapOperatorCallExp__type_p5(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_32 = (TC_mapOperatorCallExp)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @Nullable Boolean status = trace_32.getStatus();
			if (status == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (status) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = trace_32.getQvtr_qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_4;
				if (symbol_0) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression qvtr_qvtrSource = trace_32.getQvtr_qvtrSource();
					objectManager.getting(qvtr_qvtrSource, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
					final /*@NonInvalid*/ @Nullable Type type_2 = qvtr_qvtrSource.getType();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull String primitive_operationName = trace_32.getPrimitive_operationName();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Operation getOperation = ((FUN_getOperation)FTOR_getOperation.getUniqueComputation(ATL2QVTr.this, type_2, primitive_operationName)).instance;
					objectManager.getting(getOperation, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
					final /*@Thrown*/ @Nullable Type type_3 = getOperation.getType();
					// mapping statements
					symbol_1.setType(type_3);
					objectManager.assigned(symbol_1, PivotPackage.Literals.TYPED_ELEMENT__TYPE, type_3);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapOperatorCallExp__type_p5 = ValueUtil.TRUE_VALUE;
					symbol_4 = m_TC__mapOperatorCallExp__type_p5;
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
			return idResolver.oclEquals(trace_32, thoseValues[0]);
		}
	}

	/**
	 *
	 * map m_TC__mapIfExp__type_p6 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TC_mapIfExp[1];
	 * check trace.status;
	 * check var qvtrExpression : IfExp[1] := trace.qvtr_qvtrExpression;
	 * var qvtrThen : OCLExpression[1] := trace.qvtr_qvtrThen;
	 * var type : Type[?] := qvtrThen.type;
	 * var qvtrElse : OCLExpression[1] := trace.qvtr_qvtrElse;
	 * var type1 : Type[?] := qvtrElse.type;
	 * var getCommonType1 : Type[1] := this.getCommonType(type, type1);
	 * notify set qvtrExpression.type := getCommonType1;
	 *
	 */
	protected class MAP_m_TC__mapIfExp__type_p6 extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull TC_mapIfExp trace_33;

		public MAP_m_TC__mapIfExp__type_p6(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			trace_33 = (TC_mapIfExp)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @Nullable Boolean status = trace_33.getStatus();
			if (status == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (status) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = trace_33.getQvtr_qvtrExpression();
				final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.IfExp;
				/*@Thrown*/ @Nullable Boolean symbol_4;
				if (symbol_0) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull IfExp symbol_1 = (org.eclipse.ocl.pivot.IfExp)temp1_qvtrExpression;
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression qvtr_qvtrThen = trace_33.getQvtr_qvtrThen();
					objectManager.getting(qvtr_qvtrThen, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
					final /*@NonInvalid*/ @Nullable Type type_2 = qvtr_qvtrThen.getType();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression qvtr_qvtrElse = trace_33.getQvtr_qvtrElse();
					objectManager.getting(qvtr_qvtrElse, PivotPackage.Literals.TYPED_ELEMENT__TYPE, false);
					final /*@NonInvalid*/ @Nullable Type type_3 = qvtr_qvtrElse.getType();
					final /*@Thrown*/ @NonNull Type getCommonType = ((FUN_getCommonType)FTOR_getCommonType.getUniqueComputation(ATL2QVTr.this, type_2, type_3)).instance;
					// mapping statements
					symbol_1.setType(getCommonType);
					objectManager.assigned(symbol_1, PivotPackage.Literals.TYPED_ELEMENT__TYPE, getCommonType);
					final /*@Thrown*/ @Nullable Boolean m_TC__mapIfExp__type_p6 = ValueUtil.TRUE_VALUE;
					symbol_4 = m_TC__mapIfExp__type_p6;
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
			return idResolver.oclEquals(trace_33, thoseValues[0]);
		}
	}

	/**
	 *
	 * map m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p4 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TC_mapNavigationOrAttributeCallExp_Property[1];
	 * check trace.status;
	 * check var qvtrExpression : PropertyCallExp[1] := trace.qvtr_qvtrExpression;
	 * var propertyName : String[1] := trace.primitive_propertyName;
	 * var qvtrSource : OCLExpression[1] := trace.qvtr_qvtrSource;
	 * var type : Type[?] := qvtrSource.type;
	 * var qvtrProperty : Property[1] := this.getProperty(type, propertyName);
	 * set qvtrExpression.referredProperty := qvtrProperty;
	 * set trace.qvtr_qvtrProperty := qvtrProperty;
	 *
	 */
	protected boolean MAP_m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p4(final /*@NonInvalid*/ @NonNull TC_mapNavigationOrAttributeCallExp_Property trace_34)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p4" + ", " + trace_34);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_34.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_6;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = trace_34.getQvtr_qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof PropertyCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (symbol_0) {
				final /*@NonInvalid*/ @NonNull PropertyCallExp symbol_1 = (PropertyCallExp)temp1_qvtrExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String primitive_propertyName = trace_34.getPrimitive_propertyName();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression qvtr_qvtrSource = trace_34.getQvtr_qvtrSource();
				final /*@NonInvalid*/ @Nullable Type type_2 = qvtr_qvtrSource.getType();
				final /*@Thrown*/ @NonNull Property getProperty = ((FUN_getProperty)FTOR_getProperty.getUniqueComputation(this, type_2, primitive_propertyName)).instance;
				// mapping statements
				symbol_1.setReferredProperty(getProperty);
				trace_34.setQvtr_qvtrProperty(getProperty);
				final /*@Thrown*/ @Nullable Boolean m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p4 = ValueUtil.TRUE_VALUE;
				symbol_5 = m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p4;
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
			AbstractTransformer.INVOCATIONS.println((symbol_6 ? "done "  : "fail ") + "MAP_m_TC__mapNavigationOrAttributeCallExp__Property_qvtr_p4");
		}
		return symbol_6;
	}

	/**
	 *
	 * map m_TC__mapOperationCallExp__Operation_qvtr_qvtrOperat_p4 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TC_mapOperationCallExp_Operation[1];
	 * check trace.status;
	 * check var qvtrExpression : OperationCallExp[1] := trace.qvtr_qvtrExpression;
	 * var operationName : String[1] := trace.primitive_operationName;
	 * var qvtrSource : OCLExpression[1] := trace.qvtr_qvtrSource;
	 * var type : Type[?] := qvtrSource.type;
	 * var qvtrOperation : Operation[1] := this.getOperation(type, operationName);
	 * set qvtrExpression.referredOperation := qvtrOperation;
	 * set trace.qvtr_qvtrOperation := qvtrOperation;
	 *
	 */
	protected boolean MAP_m_TC__mapOperationCallExp__Operation_qvtr_qvtrOperat_p4(final /*@NonInvalid*/ @NonNull TC_mapOperationCallExp_Operation trace_35)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOperationCallExp__Operation_qvtr_qvtrOperat_p4" + ", " + trace_35);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_35.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_6;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = trace_35.getQvtr_qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String primitive_operationName = trace_35.getPrimitive_operationName();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression qvtr_qvtrSource = trace_35.getQvtr_qvtrSource();
				final /*@NonInvalid*/ @Nullable Type type_2 = qvtr_qvtrSource.getType();
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Operation getOperation = ((FUN_getOperation)FTOR_getOperation.getUniqueComputation(this, type_2, primitive_operationName)).instance;
				// mapping statements
				symbol_1.setReferredOperation(getOperation);
				trace_35.setQvtr_qvtrOperation(getOperation);
				final /*@Thrown*/ @Nullable Boolean m_TC__mapOperationCallExp__Operation_qvtr_qvtrOperat_p4 = ValueUtil.TRUE_VALUE;
				symbol_5 = m_TC__mapOperationCallExp__Operation_qvtr_qvtrOperat_p4;
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
			AbstractTransformer.INVOCATIONS.println((symbol_6 ? "done "  : "fail ") + "MAP_m_TC__mapOperationCallExp__Operation_qvtr_qvtrOperat_p4");
		}
		return symbol_6;
	}

	/**
	 *
	 * map m_TC__mapOperatorCallExp_qvtr_qvtrOperation_p4 in ATL2QVTr {
	 *
	 *   guard:middle trace : trace_ATL2QVTr::TC_mapOperatorCallExp[1];
	 * check trace.status;
	 * check var qvtrExpression : OperationCallExp[1] := trace.qvtr_qvtrExpression;
	 * var operationName : String[1] := trace.primitive_operationName;
	 * var qvtrSource : OCLExpression[1] := trace.qvtr_qvtrSource;
	 * var type : Type[?] := qvtrSource.type;
	 * var qvtrOperation : Operation[1] := this.getOperation(type, operationName);
	 * set qvtrExpression.referredOperation := qvtrOperation;
	 * set trace.qvtr_qvtrOperation := qvtrOperation;
	 *
	 */
	protected boolean MAP_m_TC__mapOperatorCallExp_qvtr_qvtrOperation_p4(final /*@NonInvalid*/ @NonNull TC_mapOperatorCallExp trace_36)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_TC__mapOperatorCallExp_qvtr_qvtrOperation_p4" + ", " + trace_36);
		}
		final /*@NonInvalid*/ @Nullable Boolean status = trace_36.getStatus();
		if (status == null) {
			throw new InvalidEvaluationException("Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_6;
		if (status) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull OCLExpression temp1_qvtrExpression = trace_36.getQvtr_qvtrExpression();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_qvtrExpression instanceof org.eclipse.ocl.pivot.OperationCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OperationCallExp symbol_1 = (org.eclipse.ocl.pivot.OperationCallExp)temp1_qvtrExpression;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String primitive_operationName = trace_36.getPrimitive_operationName();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression qvtr_qvtrSource = trace_36.getQvtr_qvtrSource();
				final /*@NonInvalid*/ @Nullable Type type_2 = qvtr_qvtrSource.getType();
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Operation getOperation = ((FUN_getOperation)FTOR_getOperation.getUniqueComputation(this, type_2, primitive_operationName)).instance;
				// mapping statements
				symbol_1.setReferredOperation(getOperation);
				trace_36.setQvtr_qvtrOperation(getOperation);
				final /*@Thrown*/ @Nullable Boolean m_TC__mapOperatorCallExp_qvtr_qvtrOperation_p4 = ValueUtil.TRUE_VALUE;
				symbol_5 = m_TC__mapOperatorCallExp_qvtr_qvtrOperation_p4;
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
			AbstractTransformer.INVOCATIONS.println((symbol_6 ? "done "  : "fail ") + "MAP_m_TC__mapOperatorCallExp_qvtr_qvtrOperation_p4");
		}
		return symbol_6;
	}
}
