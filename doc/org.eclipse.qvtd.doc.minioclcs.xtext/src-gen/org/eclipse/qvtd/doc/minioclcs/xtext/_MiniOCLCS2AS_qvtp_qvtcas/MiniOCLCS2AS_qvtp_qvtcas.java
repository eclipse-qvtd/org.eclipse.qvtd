/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.qvtd.cs2as.compiler.internal.CS2ASJavaCompilerImpl$1
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.qvtd.doc.minioclcs.xtext._MiniOCLCS2AS_qvtp_qvtcas;

import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.AbstractDispatchOperation;
import org.eclipse.ocl.pivot.internal.library.executor.AbstractEvaluationOperation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionAsOrderedSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIsEmptyOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionFirstOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionLastOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedSetSubOrderedSetOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanAndOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.numeric.NumericMinusOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsTypeOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyToStringOperation;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.doc.miniocl.CallExp;
import org.eclipse.qvtd.doc.miniocl.Element;
import org.eclipse.qvtd.doc.miniocl.ExpressionInOCL;
import org.eclipse.qvtd.doc.miniocl.MiniOCLFactory;
import org.eclipse.qvtd.doc.miniocl.MiniOCLPackage;
import org.eclipse.qvtd.doc.miniocl.NamedElement;
import org.eclipse.qvtd.doc.miniocl.OCLExpression;
import org.eclipse.qvtd.doc.miniocl.Operation;
import org.eclipse.qvtd.doc.miniocl.Package;
import org.eclipse.qvtd.doc.miniocl.Parameter;
import org.eclipse.qvtd.doc.miniocl.PropertyCallExp;
import org.eclipse.qvtd.doc.miniocl.Root;
import org.eclipse.qvtd.doc.miniocl.Variable;
import org.eclipse.qvtd.doc.miniocl.VariableExp;
import org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentPackage;
import org.eclipse.qvtd.doc.miniocl.lookup.LookupEnvironment;
import org.eclipse.qvtd.doc.miniocl.lookup.util.MiniOCLLookupSolver;
import org.eclipse.qvtd.doc.miniocl.util.Visitable;
import org.eclipse.qvtd.doc.minioclcs.CSTrace;
import org.eclipse.qvtd.doc.minioclcs.CallExpCS;
import org.eclipse.qvtd.doc.minioclcs.ClassCS;
import org.eclipse.qvtd.doc.minioclcs.ExpCS;
import org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage;
import org.eclipse.qvtd.doc.minioclcs.NameExpCS;
import org.eclipse.qvtd.doc.minioclcs.NavigationExpCS;
import org.eclipse.qvtd.doc.minioclcs.OperationCS;
import org.eclipse.qvtd.doc.minioclcs.PackageCS;
import org.eclipse.qvtd.doc.minioclcs.ParameterCS;
import org.eclipse.qvtd.doc.minioclcs.PathElementCS;
import org.eclipse.qvtd.doc.minioclcs.PathNameCS;
import org.eclipse.qvtd.doc.minioclcs.PropertyCS;
import org.eclipse.qvtd.doc.minioclcs.RootCS;
import org.eclipse.qvtd.doc.minioclcs.RoundedBracketClauseCS;
import org.eclipse.qvtd.doc.minioclcs.xtext.tx.AbstractInvocation;
import org.eclipse.qvtd.doc.minioclcs.xtext.tx.AbstractCS2ASTransformer;
import org.eclipse.qvtd.doc.minioclcs.xtext.internal.tx.AbstractInvocationConstructor;
import org.eclipse.qvtd.doc.minioclcs.xtext.library.model.ModelObjectsOfKindOperation;

/**
 * The MiniOCLCS2AS_qvtp_qvtcas transformation:
 * <p>
 * Construct with an evaluator
 * <br>
 * Populate each input model with {@link addRootObjects(String,List)}
 * <br>
 * {@link run()}
 * <br>
 * Extract each output model with {@link getRootObjects(String)}
 */
@SuppressWarnings("nls")
public class MiniOCLCS2AS_qvtp_qvtcas extends AbstractCS2ASTransformer
{
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbaseLibrary", "qvtbaselib", null);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/doc/MiniOCLCS", null, MinioclcsPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0 = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/doc/MiniOCL/1.0", null, MiniOCLPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_Lookup_s_1_0 = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0", null, EnvironmentPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_CSTrace = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("CSTrace", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_CallExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("CallExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_CallExpCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("CallExpCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ClassCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("ClassCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class_0 = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Element = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Element", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ExpCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("ExpCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ExpressionInOCL = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("ExpressionInOCL", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_LookupEnvironment = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_Lookup_s_1_0.getClassId("LookupEnvironment", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Model = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary.getClassId("Model", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_NameExpCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("NameExpCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_NamedElement = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("NamedElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_NavigationExpCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("NavigationExpCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OCLExpression = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("OCLExpression", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OpaqueExpression = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("OpaqueExpression", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Operation = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Operation", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OperationCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("OperationCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Package = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Package", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PackageCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("PackageCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Parameter = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Parameter", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ParameterCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("ParameterCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PathElementCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("PathElementCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PathNameCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("PathNameCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Property = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Property", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PropertyCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("PropertyCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PropertyCallExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("PropertyCallExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Root = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Root", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RootCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("RootCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RoundedBracketClauseCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("RoundedBracketClauseCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TypedElement = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("TypedElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Variable = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Variable", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_VariableExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("VariableExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Visitable = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Visitable", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull DataTypeId DATAid_EString = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EString", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue INT_1 = ValueUtil.integerValueOf("1");
    public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_OCL = "OCL";
    public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_self = "self";
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Class = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Class_0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_ClassCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ClassCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_NamedElement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_NamedElement);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Operation = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Operation);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_OperationCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OperationCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Package = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Package);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_PackageCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PackageCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Parameter = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Parameter);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_ParameterCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ParameterCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_PathElementCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PathElementCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Property = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Property);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_PropertyCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PropertyCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Variable = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Variable);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull PropertyId PROPid_language = CLSSid_OpaqueExpression.getPropertyId("language");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull PropertyId PROPid_name = CLSSid_NamedElement.getPropertyId("name");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull PropertyId PROPid_ownedBody = CLSSid_ExpressionInOCL.getPropertyId("ownedBody");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull PropertyId PROPid_ownedSelfVar = CLSSid_ExpressionInOCL.getPropertyId("ownedSelfVar");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull PropertyId PROPid_parentEnv = CLSSid_LookupEnvironment.getPropertyId("parentEnv");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull PropertyId PROPid_referredVariable = CLSSid_VariableExp.getPropertyId("referredVariable");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull PropertyId PROPid_type = CLSSid_TypedElement.getPropertyId("type");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Class = TypeId.SEQUENCE.getSpecializedId(CLSSid_Class_0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Operation = TypeId.SEQUENCE.getSpecializedId(CLSSid_Operation);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Package = TypeId.SEQUENCE.getSpecializedId(CLSSid_Package);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Parameter = TypeId.SEQUENCE.getSpecializedId(CLSSid_Parameter);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Property = TypeId.SEQUENCE.getSpecializedId(CLSSid_Property);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_CallExpCS = TypeId.SET.getSpecializedId(CLSSid_CallExpCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Class = TypeId.SET.getSpecializedId(CLSSid_Class_0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_ClassCS = TypeId.SET.getSpecializedId(CLSSid_ClassCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_NameExpCS = TypeId.SET.getSpecializedId(CLSSid_NameExpCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_NavigationExpCS = TypeId.SET.getSpecializedId(CLSSid_NavigationExpCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_OperationCS = TypeId.SET.getSpecializedId(CLSSid_OperationCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_PackageCS = TypeId.SET.getSpecializedId(CLSSid_PackageCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_ParameterCS = TypeId.SET.getSpecializedId(CLSSid_ParameterCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_PropertyCS = TypeId.SET.getSpecializedId(CLSSid_PropertyCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_RootCS = TypeId.SET.getSpecializedId(CLSSid_RootCS);
    
    /*
     * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
     */
    private static final @NonNull ClassId[] classIndex2classId = new @NonNull ClassId[]{
        CLSSid_CallExpCS,               // 0 => CallExpCS
        CLSSid_ClassCS,                 // 1 => ClassCS
        CLSSid_NameExpCS,               // 2 => NameExpCS
        CLSSid_NavigationExpCS,         // 3 => NavigationExpCS
        CLSSid_OperationCS,             // 4 => OperationCS
        CLSSid_PackageCS,               // 5 => PackageCS
        CLSSid_ParameterCS,             // 6 => ParameterCS
        CLSSid_PropertyCS,              // 7 => PropertyCS
        CLSSid_RootCS                   // 8 => RootCS
    };
    
    /*
     * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
     * may contribute results to an allInstances() invocation.
     * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
     * instance of the derived classId contributes to derived and inherited ClassIndexes.
     */
    private final static int @NonNull [] @NonNull [] classIndex2allClassIndexes = new int @NonNull [] @NonNull [] {
        {0},                    // 0 : CallExpCS -> {CallExpCS}
        {1},                    // 1 : ClassCS -> {ClassCS}
        {2,3,0},                // 2 : NameExpCS -> {NameExpCS,NavigationExpCS,CallExpCS}
        {3},                    // 3 : NavigationExpCS -> {NavigationExpCS}
        {4},                    // 4 : OperationCS -> {OperationCS}
        {5},                    // 5 : PackageCS -> {PackageCS}
        {6},                    // 6 : ParameterCS -> {ParameterCS}
        {7},                    // 7 : PropertyCS -> {PropertyCS}
        {8}                     // 8 : RootCS -> {RootCS}
    };
    
    protected final @NonNull AbstractInvocationConstructor CTOR_m_NameExpCS_ast_1 = new AbstractInvocationConstructor(idResolver)
    {
        @Override
        public @NonNull MAP_m_NameExpCS_ast_1 newInstance(@NonNull Object @NonNull [] values) {
            return new MAP_m_NameExpCS_ast_1(values);
        }
    };
    
    protected final @NonNull AbstractInvocationConstructor CTOR_m_NameExpCS_ast_3 = new AbstractInvocationConstructor(idResolver)
    {
        @Override
        public @NonNull MAP_m_NameExpCS_ast_3 newInstance(@NonNull Object @NonNull [] values) {
            return new MAP_m_NameExpCS_ast_3(values);
        }
    };
    
    protected final @NonNull AbstractInvocationConstructor CTOR_m_NameExpCS_ast_expName = new AbstractInvocationConstructor(idResolver)
    {
        @Override
        public @NonNull MAP_m_NameExpCS_ast_expName newInstance(@NonNull Object @NonNull [] values) {
            return new MAP_m_NameExpCS_ast_expName(values);
        }
    };
    
    protected final @NonNull AbstractInvocationConstructor CTOR_m_NameExpCS_ast_expName_1 = new AbstractInvocationConstructor(idResolver)
    {
        @Override
        public @NonNull MAP_m_NameExpCS_ast_expName_1 newInstance(@NonNull Object @NonNull [] values) {
            return new MAP_m_NameExpCS_ast_expName_1(values);
        }
    };
    
    private final MiniOCLLookupSolver lookupSolver = new MiniOCLLookupSolver(executor);
    
    public MiniOCLCS2AS_qvtp_qvtcas(final @NonNull Executor executor) {
        super(executor, new @NonNull String[] {"leftCS", "rightAS"}, null, classIndex2classId, classIndex2allClassIndexes);
    }
    
    @Override
    public boolean run() {
        return MAP___root__() && invocationManager.flush();
    }
    
    /**
     * minioclcs::NameExpCS::parentAsCallExpCS() : minioclcs::CallExpCS[?]
     * 
     * 
     * let container : OclElement[?] = self.oclContainer()
     * in
     *   if container.oclIsKindOf(CallExpCS)
     *   then container.oclAsType(CallExpCS)
     *   else null
     *   endif
     */
    protected class CACHE_NameExpCS_parentAsCallExpCS extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS self_0 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS)sourceAndArgumentValues[0];
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, self_0);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_CallExpCS_2 = idResolver.getClass(CLSSid_CallExpCS, null);
            final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, container, TYP_minioclcs_c_c_CallExpCS_2).booleanValue();
            /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS symbol_0;
            if (oclIsKindOf) {
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CallExpCS oclAsType = ClassUtil.nonNullState((CallExpCS)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container, TYP_minioclcs_c_c_CallExpCS_2));
                symbol_0 = oclAsType;
            }
            else {
                symbol_0 = null;
            }
            return symbol_0;
        }
        
        public CallExpCS evaluate(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS self_0) {
            return (CallExpCS)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_0});
        }
    }
    
    protected final @NonNull CACHE_NameExpCS_parentAsCallExpCS INST_NameExpCS_parentAsCallExpCS = new CACHE_NameExpCS_parentAsCallExpCS();
    
    /**
     * miniocl::Visitable::_lookupVariable(env : lookup::LookupEnvironment[?], vName : String[?]) : OrderedSet(miniocl::Variable)
     * 
     * 
     * let
     *   foundVariable : OrderedSet(miniocl::Variable)[*|1] = env.namedElements->selectByKind(Variable)
     *   ->select(name = vName)
     * in
     *   if
     *     foundVariable->isEmpty() and
     *     not (env.parentEnv = null
     *     )
     *   then _lookupVariable(env.parentEnv, vName)
     *   else foundVariable
     *   endif
     */
    protected class CACHE_Visitable__lookupVariable extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.util.@org.eclipse.jdt.annotation.NonNull Visitable self_2 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.util.@org.eclipse.jdt.annotation.NonNull Visitable)sourceAndArgumentValues[0];
            final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment env = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment)sourceAndArgumentValues[1];
            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable String vName = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable String)sourceAndArgumentValues[2];
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            /*@Caught*/ @NonNull Object CAUGHT_foundVariable;
            try {
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Variable_0 = idResolver.getClass(CLSSid_Variable, null);
                if (env == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::namedElements\'");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<NamedElement> namedElements = env.getNamedElements();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_namedElements, TYP_miniocl_c_c_Variable_0);
                /*@Thrown*/ OrderedSetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Variable);
                @NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
                /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundVariable;
                while (true) {
                    if (!ITERATOR__1.hasNext()) {
                        foundVariable = accumulator;
                        break;
                    }
                    @SuppressWarnings("null")
                    /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Variable _1 = (Variable)ITERATOR__1.next();
                    /**
                     * name = vName
                     */
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = _1.getName();
                    final /*@Thrown*/ boolean eq = (name != null) ? name.equals(vName) : (vName == null);
                    //
                    if (eq == ValueUtil.TRUE_VALUE) {
                        accumulator.add(_1);
                    }
                }
                CAUGHT_foundVariable = foundVariable;
            }
            catch (Exception e) {
                CAUGHT_foundVariable = ValueUtil.createInvalidValue(e);
            }
            /*@Caught*/ @NonNull Object CAUGHT_isEmpty;
            try {
                if (CAUGHT_foundVariable instanceof InvalidValueException) {
                    throw (InvalidValueException)CAUGHT_foundVariable;
                }
                final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(CAUGHT_foundVariable).booleanValue();
                CAUGHT_isEmpty = isEmpty;
            }
            catch (Exception e) {
                CAUGHT_isEmpty = ValueUtil.createInvalidValue(e);
            }
            /*@Caught*/ @Nullable Object CAUGHT_not;
            try {
                /*@Caught*/ @NonNull Object CAUGHT_eq_0;
                try {
                    if (env == null) {
                        throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = env.getParentEnv();
                    final /*@Thrown*/ boolean eq_0 = parentEnv == null;
                    CAUGHT_eq_0 = eq_0;
                }
                catch (Exception e) {
                    CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_eq_0);
                CAUGHT_not = not;
            }
            catch (Exception e) {
                CAUGHT_not = ValueUtil.createInvalidValue(e);
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_isEmpty, CAUGHT_not);
            if (and == null) {
                throw new InvalidValueException("Null if condition");
            }
            /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue symbol_0;
            if (and) {
                if (env == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv_0 = env.getParentEnv();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue _lookupVariable = INST_Visitable__lookupVariable.evaluate(self_2, parentEnv_0, vName);
                symbol_0 = _lookupVariable;
            }
            else {
                if (CAUGHT_foundVariable instanceof InvalidValueException) {
                    throw (InvalidValueException)CAUGHT_foundVariable;
                }
                symbol_0 = (OrderedSetValue)CAUGHT_foundVariable;
            }
            return symbol_0;
        }
        
        @SuppressWarnings("unchecked")
        public org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue evaluate(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.util.@org.eclipse.jdt.annotation.NonNull Visitable self_2, final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment env, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable String vName) {
            return (org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_2, env, vName});
        }
    }
    
    protected final @NonNull CACHE_Visitable__lookupVariable INST_Visitable__lookupVariable = new CACHE_Visitable__lookupVariable();
    
    protected class VCACHE_OclElement__unqualified_env_Variable extends AbstractDispatchOperation
    {
        private VCACHE_OclElement__unqualified_env_Variable() {
            install(Operation.class, new CACHE_Operation__unqualified_env_Variable());
            install(ExpressionInOCL.class, new CACHE_ExpressionInOCL__unqualified_env_Variable());
            install(Object.class, new CACHE_OclElement__unqualified_env_Variable());
        }
        
        @SuppressWarnings("null")
        public org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_6, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_0) {
            return (org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_6, child_0});
        }
    }
    
    protected final @NonNull VCACHE_OclElement__unqualified_env_Variable INST_OclElement__unqualified_env_Variable = new VCACHE_OclElement__unqualified_env_Variable();
    
    /**
     * ocl::OclElement::parentEnv_Variable() : lookup::LookupEnvironment[1]
     * 
     * 
     * let parent : OclElement[?] = oclContainer()
     * in
     *   if parent = null
     *   then lookup::LookupEnvironment{}
     *   else parent._unqualified_env_Variable(self)
     *   endif
     */
    protected class CACHE_OclElement_parentEnv_Variable extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_5 = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object)sourceAndArgumentValues[0];
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, self_5);
            final /*@NonInvalid*/ boolean eq = parent == null;
            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment symbol_1;
            if (eq) {
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
                final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment symbol_0 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
                symbol_1 = symbol_0;
            }
            else {
                if (parent == null) {
                    throw new InvalidValueException("Null source for \'OclElement::_unqualified_env_Variable(OclElement[?]) : lookup::LookupEnvironment[1]\'");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment _unqualified_env_Variable = INST_OclElement__unqualified_env_Variable.evaluate(parent, self_5);
                symbol_1 = _unqualified_env_Variable;
            }
            return symbol_1;
        }
        
        @SuppressWarnings("null")
        public org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_5) {
            return (org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_5});
        }
    }
    
    protected final @NonNull CACHE_OclElement_parentEnv_Variable INST_OclElement_parentEnv_Variable = new CACHE_OclElement_parentEnv_Variable();
    
    /**
     * miniocl::Operation::_unqualified_env_Variable(child : OclElement[?]) : lookup::LookupEnvironment[?]
     * 
     * parentEnv_Variable().nestedEnv().addElements(ownedParameters)
     */
    protected class CACHE_Operation__unqualified_env_Variable extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Operation self_4 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Operation)sourceAndArgumentValues[0];
            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object)sourceAndArgumentValues[1];
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment self_21 = INST_OclElement_parentEnv_Variable.evaluate(self_4);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment symbol_0 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
            CTORid_parentEnv.initValue(symbol_0, self_21);
            @SuppressWarnings("null")
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Parameter> ownedParameters = self_4.getOwnedParameters();
            @SuppressWarnings("null")
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = symbol_0.addElements(ownedParameters);
            return addElements;
        }
        
        public LookupEnvironment evaluate(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Operation self_4, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child) {
            return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_4, child});
        }
    }
    
    /**
     * miniocl::ExpressionInOCL::_unqualified_env_Variable(child : OclElement[?]) : lookup::LookupEnvironment[?]
     * 
     * parentEnv_Variable().nestedEnv().addElements(ownedSelfVar)
     */
    protected class CACHE_ExpressionInOCL__unqualified_env_Variable extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull ExpressionInOCL self_7 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull ExpressionInOCL)sourceAndArgumentValues[0];
            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_1 = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object)sourceAndArgumentValues[1];
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment self_21 = INST_OclElement_parentEnv_Variable.evaluate(self_7);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment symbol_0 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
            CTORid_parentEnv.initValue(symbol_0, self_21);
            @SuppressWarnings("null")
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Variable ownedSelfVar = self_7.getOwnedSelfVar();
            @SuppressWarnings("null")
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = symbol_0.addElements(ownedSelfVar);
            return addElements;
        }
        
        public LookupEnvironment evaluate(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull ExpressionInOCL self_7, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_1) {
            return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_7, child_1});
        }
    }
    
    /**
     * ocl::OclElement::_unqualified_env_Variable(child : OclElement[?]) : lookup::LookupEnvironment[1]
     * 
     * parentEnv_Variable()
     */
    protected class CACHE_OclElement__unqualified_env_Variable extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_6 = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object)sourceAndArgumentValues[0];
            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_0 = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object)sourceAndArgumentValues[1];
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment parentEnv_Variable = INST_OclElement_parentEnv_Variable.evaluate(self_6);
            return parentEnv_Variable;
        }
        
        @SuppressWarnings("null")
        public org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_6, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_0) {
            return (org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_6, child_0});
        }
    }
    
    /**
     * ocl::OclElement::unqualified_env_Variable() : lookup::LookupEnvironment[1]
     * 
     * _unqualified_env_Variable(null)
     */
    protected class CACHE_OclElement_unqualified_env_Variable extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_3 = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object)sourceAndArgumentValues[0];
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment _unqualified_env_Variable = INST_OclElement__unqualified_env_Variable.evaluate(self_3, null);
            return _unqualified_env_Variable;
        }
        
        @SuppressWarnings("null")
        public org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_3) {
            return (org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_3});
        }
    }
    
    protected final @NonNull CACHE_OclElement_unqualified_env_Variable INST_OclElement_unqualified_env_Variable = new CACHE_OclElement_unqualified_env_Variable();
    
    /**
     * minioclcs::NameExpCS::lookupVariableToDisambiguate() : miniocl::Variable[?]
     * 
     * 
     * oclContainer()
     * .oclAsType(CSTrace)
     * .ast.lookupVariable(expName.pathElements->first())
     */
    protected class CACHE_NameExpCS_lookupVariableToDisambiguate extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS self_1 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS)sourceAndArgumentValues[0];
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_CSTrace_0 = idResolver.getClass(CLSSid_CSTrace, null);
            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, self_1);
            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CSTrace oclAsType = ClassUtil.nonNullState((CSTrace)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer, TYP_minioclcs_c_c_CSTrace_0));
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element self_21 = oclAsType.getAst();
            if (self_21 == null) {
                throw new InvalidValueException("Null where non-null value required");
            }
            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName = self_1.getExpName();
            if (expName == null) {
                throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
            }
            @SuppressWarnings("null")
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> pathElements = expName.getPathElements();
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_pathElements);
            if (aPathElementCS == null) {
                throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String vName_0 = aPathElementCS.getElementName();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment unqualified_env_Variable = INST_OclElement_unqualified_env_Variable.evaluate(self_21);
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundVariable = INST_Visitable__lookupVariable.evaluate(self_21, unqualified_env_Variable, vName_0);
            final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundVariable).booleanValue();
            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Variable symbol_0;
            if (isEmpty) {
                symbol_0 = null;
            }
            else {
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Variable first = (Variable)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundVariable);
                symbol_0 = first;
            }
            return symbol_0;
        }
        
        public Variable evaluate(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS self_1) {
            return (Variable)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_1});
        }
    }
    
    protected final @NonNull CACHE_NameExpCS_lookupVariableToDisambiguate INST_NameExpCS_lookupVariableToDisambiguate = new CACHE_NameExpCS_lookupVariableToDisambiguate();
    
    /**
     * miniocl::Visitable::_lookupProperty(env : lookup::LookupEnvironment[?], pName : String[?]) : OrderedSet(miniocl::Property)
     * 
     * 
     * let
     *   foundProperty : OrderedSet(miniocl::Property)[*|1] = env.namedElements->selectByKind(Property)
     *   ->select(name = pName)
     * in
     *   if
     *     foundProperty->isEmpty() and
     *     not (env.parentEnv = null
     *     )
     *   then _lookupProperty(env.parentEnv, pName)
     *   else foundProperty
     *   endif
     */
    protected class CACHE_Visitable__lookupProperty extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.util.@org.eclipse.jdt.annotation.NonNull Visitable self_8 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.util.@org.eclipse.jdt.annotation.NonNull Visitable)sourceAndArgumentValues[0];
            final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment env_0 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment)sourceAndArgumentValues[1];
            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pName = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable String)sourceAndArgumentValues[2];
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            /*@Caught*/ @NonNull Object CAUGHT_foundProperty;
            try {
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Property_0 = idResolver.getClass(CLSSid_Property, null);
                if (env_0 == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::namedElements\'");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<NamedElement> namedElements = env_0.getNamedElements();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_namedElements, TYP_miniocl_c_c_Property_0);
                /*@Thrown*/ OrderedSetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Property);
                @NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
                /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundProperty;
                while (true) {
                    if (!ITERATOR__1.hasNext()) {
                        foundProperty = accumulator;
                        break;
                    }
                    @SuppressWarnings("null")
                    /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Property _1 = (org.eclipse.qvtd.doc.miniocl.Property)ITERATOR__1.next();
                    /**
                     * name = pName
                     */
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = _1.getName();
                    final /*@Thrown*/ boolean eq = (name != null) ? name.equals(pName) : (pName == null);
                    //
                    if (eq == ValueUtil.TRUE_VALUE) {
                        accumulator.add(_1);
                    }
                }
                CAUGHT_foundProperty = foundProperty;
            }
            catch (Exception e) {
                CAUGHT_foundProperty = ValueUtil.createInvalidValue(e);
            }
            /*@Caught*/ @NonNull Object CAUGHT_isEmpty;
            try {
                if (CAUGHT_foundProperty instanceof InvalidValueException) {
                    throw (InvalidValueException)CAUGHT_foundProperty;
                }
                final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(CAUGHT_foundProperty).booleanValue();
                CAUGHT_isEmpty = isEmpty;
            }
            catch (Exception e) {
                CAUGHT_isEmpty = ValueUtil.createInvalidValue(e);
            }
            /*@Caught*/ @Nullable Object CAUGHT_not;
            try {
                /*@Caught*/ @NonNull Object CAUGHT_eq_0;
                try {
                    if (env_0 == null) {
                        throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = env_0.getParentEnv();
                    final /*@Thrown*/ boolean eq_0 = parentEnv == null;
                    CAUGHT_eq_0 = eq_0;
                }
                catch (Exception e) {
                    CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_eq_0);
                CAUGHT_not = not;
            }
            catch (Exception e) {
                CAUGHT_not = ValueUtil.createInvalidValue(e);
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_isEmpty, CAUGHT_not);
            if (and == null) {
                throw new InvalidValueException("Null if condition");
            }
            /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue symbol_0;
            if (and) {
                if (env_0 == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv_0 = env_0.getParentEnv();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue _lookupProperty = INST_Visitable__lookupProperty.evaluate(self_8, parentEnv_0, pName);
                symbol_0 = _lookupProperty;
            }
            else {
                if (CAUGHT_foundProperty instanceof InvalidValueException) {
                    throw (InvalidValueException)CAUGHT_foundProperty;
                }
                symbol_0 = (OrderedSetValue)CAUGHT_foundProperty;
            }
            return symbol_0;
        }
        
        @SuppressWarnings("unchecked")
        public org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue evaluate(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.util.@org.eclipse.jdt.annotation.NonNull Visitable self_8, final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment env_0, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pName) {
            return (org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_8, env_0, pName});
        }
    }
    
    protected final @NonNull CACHE_Visitable__lookupProperty INST_Visitable__lookupProperty = new CACHE_Visitable__lookupProperty();
    
    /**
     * miniocl::Visitable::_lookupClass(env : lookup::LookupEnvironment[?], cName : String[?]) : OrderedSet(miniocl::Class)
     * 
     * 
     * let
     *   foundClass : OrderedSet(miniocl::Class)[*|1] = env.namedElements->selectByKind(Class)
     *   ->select(name = cName)
     * in
     *   if foundClass->isEmpty() and not (env.parentEnv = null)
     *   then _lookupClass(env.parentEnv, cName)
     *   else foundClass
     *   endif
     */
    protected class CACHE_Visitable__lookupClass extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.util.@org.eclipse.jdt.annotation.NonNull Visitable self_9 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.util.@org.eclipse.jdt.annotation.NonNull Visitable)sourceAndArgumentValues[0];
            final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment env_1 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment)sourceAndArgumentValues[1];
            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable String cName = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable String)sourceAndArgumentValues[2];
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            /*@Caught*/ @NonNull Object CAUGHT_foundClass;
            try {
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Class_0 = idResolver.getClass(CLSSid_Class_0, null);
                if (env_1 == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::namedElements\'");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<NamedElement> namedElements = env_1.getNamedElements();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_namedElements, TYP_miniocl_c_c_Class_0);
                /*@Thrown*/ OrderedSetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Class);
                @NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
                /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundClass;
                while (true) {
                    if (!ITERATOR__1.hasNext()) {
                        foundClass = accumulator;
                        break;
                    }
                    @SuppressWarnings("null")
                    /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class _1 = (org.eclipse.qvtd.doc.miniocl.Class)ITERATOR__1.next();
                    /**
                     * name = cName
                     */
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = _1.getName();
                    final /*@Thrown*/ boolean eq = (name != null) ? name.equals(cName) : (cName == null);
                    //
                    if (eq == ValueUtil.TRUE_VALUE) {
                        accumulator.add(_1);
                    }
                }
                CAUGHT_foundClass = foundClass;
            }
            catch (Exception e) {
                CAUGHT_foundClass = ValueUtil.createInvalidValue(e);
            }
            /*@Caught*/ @NonNull Object CAUGHT_isEmpty;
            try {
                if (CAUGHT_foundClass instanceof InvalidValueException) {
                    throw (InvalidValueException)CAUGHT_foundClass;
                }
                final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(CAUGHT_foundClass).booleanValue();
                CAUGHT_isEmpty = isEmpty;
            }
            catch (Exception e) {
                CAUGHT_isEmpty = ValueUtil.createInvalidValue(e);
            }
            /*@Caught*/ @Nullable Object CAUGHT_not;
            try {
                /*@Caught*/ @NonNull Object CAUGHT_eq_0;
                try {
                    if (env_1 == null) {
                        throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = env_1.getParentEnv();
                    final /*@Thrown*/ boolean eq_0 = parentEnv == null;
                    CAUGHT_eq_0 = eq_0;
                }
                catch (Exception e) {
                    CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_eq_0);
                CAUGHT_not = not;
            }
            catch (Exception e) {
                CAUGHT_not = ValueUtil.createInvalidValue(e);
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_isEmpty, CAUGHT_not);
            if (and == null) {
                throw new InvalidValueException("Null if condition");
            }
            /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue symbol_0;
            if (and) {
                if (env_1 == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv_0 = env_1.getParentEnv();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue _lookupClass = INST_Visitable__lookupClass.evaluate(self_9, parentEnv_0, cName);
                symbol_0 = _lookupClass;
            }
            else {
                if (CAUGHT_foundClass instanceof InvalidValueException) {
                    throw (InvalidValueException)CAUGHT_foundClass;
                }
                symbol_0 = (OrderedSetValue)CAUGHT_foundClass;
            }
            return symbol_0;
        }
        
        @SuppressWarnings("unchecked")
        public org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue evaluate(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.util.@org.eclipse.jdt.annotation.NonNull Visitable self_9, final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment env_1, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable String cName) {
            return (org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_9, env_1, cName});
        }
    }
    
    protected final @NonNull CACHE_Visitable__lookupClass INST_Visitable__lookupClass = new CACHE_Visitable__lookupClass();
    
    protected class VCACHE_OclElement__unqualified_env_Class extends AbstractDispatchOperation
    {
        private VCACHE_OclElement__unqualified_env_Class() {
            install(Package.class, new CACHE_Package__unqualified_env_Class());
            install(Object.class, new CACHE_OclElement__unqualified_env_Class());
        }
        
        @SuppressWarnings("null")
        public org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_13, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_3) {
            return (org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_13, child_3});
        }
    }
    
    protected final @NonNull VCACHE_OclElement__unqualified_env_Class INST_OclElement__unqualified_env_Class = new VCACHE_OclElement__unqualified_env_Class();
    
    /**
     * ocl::OclElement::parentEnv_Class() : lookup::LookupEnvironment[1]
     * 
     * 
     * let parent : OclElement[?] = oclContainer()
     * in
     *   if parent = null
     *   then lookup::LookupEnvironment{}
     *   else parent._unqualified_env_Class(self)
     *   endif
     */
    protected class CACHE_OclElement_parentEnv_Class extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_12 = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object)sourceAndArgumentValues[0];
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, self_12);
            final /*@NonInvalid*/ boolean eq = parent == null;
            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment symbol_1;
            if (eq) {
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
                final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment symbol_0 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
                symbol_1 = symbol_0;
            }
            else {
                if (parent == null) {
                    throw new InvalidValueException("Null source for \'OclElement::_unqualified_env_Class(OclElement[?]) : lookup::LookupEnvironment[1]\'");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment _unqualified_env_Class = INST_OclElement__unqualified_env_Class.evaluate(parent, self_12);
                symbol_1 = _unqualified_env_Class;
            }
            return symbol_1;
        }
        
        @SuppressWarnings("null")
        public org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_12) {
            return (org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_12});
        }
    }
    
    protected final @NonNull CACHE_OclElement_parentEnv_Class INST_OclElement_parentEnv_Class = new CACHE_OclElement_parentEnv_Class();
    
    /**
     * miniocl::Package::_unqualified_env_Class(child : OclElement[?]) : lookup::LookupEnvironment[?]
     * 
     * parentEnv_Class().nestedEnv().addElements(ownedClasses)
     */
    protected class CACHE_Package__unqualified_env_Class extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Package self_11 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Package)sourceAndArgumentValues[0];
            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_2 = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object)sourceAndArgumentValues[1];
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment self_21 = INST_OclElement_parentEnv_Class.evaluate(self_11);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment symbol_0 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
            CTORid_parentEnv.initValue(symbol_0, self_21);
            @SuppressWarnings("null")
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = self_11.getOwnedClasses();
            @SuppressWarnings("null")
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = symbol_0.addElements(ownedClasses);
            return addElements;
        }
        
        public LookupEnvironment evaluate(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Package self_11, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_2) {
            return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_11, child_2});
        }
    }
    
    /**
     * ocl::OclElement::_unqualified_env_Class(child : OclElement[?]) : lookup::LookupEnvironment[1]
     * 
     * parentEnv_Class()
     */
    protected class CACHE_OclElement__unqualified_env_Class extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_13 = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object)sourceAndArgumentValues[0];
            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_3 = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object)sourceAndArgumentValues[1];
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment parentEnv_Class = INST_OclElement_parentEnv_Class.evaluate(self_13);
            return parentEnv_Class;
        }
        
        @SuppressWarnings("null")
        public org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_13, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_3) {
            return (org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_13, child_3});
        }
    }
    
    /**
     * ocl::OclElement::unqualified_env_Class() : lookup::LookupEnvironment[1]
     * 
     * _unqualified_env_Class(null)
     */
    protected class CACHE_OclElement_unqualified_env_Class extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_10 = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object)sourceAndArgumentValues[0];
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment _unqualified_env_Class = INST_OclElement__unqualified_env_Class.evaluate(self_10, null);
            return _unqualified_env_Class;
        }
        
        @SuppressWarnings("null")
        public org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_10) {
            return (org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_10});
        }
    }
    
    protected final @NonNull CACHE_OclElement_unqualified_env_Class INST_OclElement_unqualified_env_Class = new CACHE_OclElement_unqualified_env_Class();
    
    /**
     * miniocl::Visitable::_lookupPackage(env : lookup::LookupEnvironment[?], pName : String[?]) : OrderedSet(miniocl::Package)
     * 
     * 
     * let
     *   foundPackage : OrderedSet(miniocl::Package)[*|1] = env.namedElements->selectByKind(Package)
     *   ->select(name = pName)
     * in
     *   if foundPackage->isEmpty() and not (env.parentEnv = null)
     *   then _lookupPackage(env.parentEnv, pName)
     *   else foundPackage
     *   endif
     */
    protected class CACHE_Visitable__lookupPackage extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.util.@org.eclipse.jdt.annotation.NonNull Visitable self_15 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.util.@org.eclipse.jdt.annotation.NonNull Visitable)sourceAndArgumentValues[0];
            final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment env_2 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment)sourceAndArgumentValues[1];
            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pName_0 = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable String)sourceAndArgumentValues[2];
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            /*@Caught*/ @NonNull Object CAUGHT_foundPackage;
            try {
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
                if (env_2 == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::namedElements\'");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<NamedElement> namedElements = env_2.getNamedElements();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_namedElements, TYP_miniocl_c_c_Package_0);
                /*@Thrown*/ OrderedSetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Package);
                @NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
                /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundPackage;
                while (true) {
                    if (!ITERATOR__1.hasNext()) {
                        foundPackage = accumulator;
                        break;
                    }
                    @SuppressWarnings("null")
                    /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Package _1 = (Package)ITERATOR__1.next();
                    /**
                     * name = pName
                     */
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = _1.getName();
                    final /*@Thrown*/ boolean eq = (name != null) ? name.equals(pName_0) : (pName_0 == null);
                    //
                    if (eq == ValueUtil.TRUE_VALUE) {
                        accumulator.add(_1);
                    }
                }
                CAUGHT_foundPackage = foundPackage;
            }
            catch (Exception e) {
                CAUGHT_foundPackage = ValueUtil.createInvalidValue(e);
            }
            /*@Caught*/ @NonNull Object CAUGHT_isEmpty;
            try {
                if (CAUGHT_foundPackage instanceof InvalidValueException) {
                    throw (InvalidValueException)CAUGHT_foundPackage;
                }
                final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(CAUGHT_foundPackage).booleanValue();
                CAUGHT_isEmpty = isEmpty;
            }
            catch (Exception e) {
                CAUGHT_isEmpty = ValueUtil.createInvalidValue(e);
            }
            /*@Caught*/ @Nullable Object CAUGHT_not;
            try {
                /*@Caught*/ @NonNull Object CAUGHT_eq_0;
                try {
                    if (env_2 == null) {
                        throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = env_2.getParentEnv();
                    final /*@Thrown*/ boolean eq_0 = parentEnv == null;
                    CAUGHT_eq_0 = eq_0;
                }
                catch (Exception e) {
                    CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_eq_0);
                CAUGHT_not = not;
            }
            catch (Exception e) {
                CAUGHT_not = ValueUtil.createInvalidValue(e);
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_isEmpty, CAUGHT_not);
            if (and == null) {
                throw new InvalidValueException("Null if condition");
            }
            /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue symbol_0;
            if (and) {
                if (env_2 == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv_0 = env_2.getParentEnv();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue _lookupPackage = INST_Visitable__lookupPackage.evaluate(self_15, parentEnv_0, pName_0);
                symbol_0 = _lookupPackage;
            }
            else {
                if (CAUGHT_foundPackage instanceof InvalidValueException) {
                    throw (InvalidValueException)CAUGHT_foundPackage;
                }
                symbol_0 = (OrderedSetValue)CAUGHT_foundPackage;
            }
            return symbol_0;
        }
        
        @SuppressWarnings("unchecked")
        public org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue evaluate(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.util.@org.eclipse.jdt.annotation.NonNull Visitable self_15, final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment env_2, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pName_0) {
            return (org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_15, env_2, pName_0});
        }
    }
    
    protected final @NonNull CACHE_Visitable__lookupPackage INST_Visitable__lookupPackage = new CACHE_Visitable__lookupPackage();
    
    protected class VCACHE_OclElement__unqualified_env_Package extends AbstractDispatchOperation
    {
        private VCACHE_OclElement__unqualified_env_Package() {
            install(Object.class, new CACHE_OclElement__unqualified_env_Package());
            install(Root.class, new CACHE_Root__unqualified_env_Package());
            install(Package.class, new CACHE_Package__unqualified_env_Package());
        }
        
        @SuppressWarnings("null")
        public org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_17, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_4) {
            return (org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_17, child_4});
        }
    }
    
    protected final @NonNull VCACHE_OclElement__unqualified_env_Package INST_OclElement__unqualified_env_Package = new VCACHE_OclElement__unqualified_env_Package();
    
    /**
     * ocl::OclElement::parentEnv_Package() : lookup::LookupEnvironment[1]
     * 
     * 
     * let parent : OclElement[?] = oclContainer()
     * in
     *   if parent = null
     *   then lookup::LookupEnvironment{}
     *   else parent._unqualified_env_Package(self)
     *   endif
     */
    protected class CACHE_OclElement_parentEnv_Package extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_18 = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object)sourceAndArgumentValues[0];
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, self_18);
            final /*@NonInvalid*/ boolean eq = parent == null;
            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment symbol_1;
            if (eq) {
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
                final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment symbol_0 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
                symbol_1 = symbol_0;
            }
            else {
                if (parent == null) {
                    throw new InvalidValueException("Null source for \'OclElement::_unqualified_env_Package(OclElement[?]) : lookup::LookupEnvironment[1]\'");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment _unqualified_env_Package = INST_OclElement__unqualified_env_Package.evaluate(parent, self_18);
                symbol_1 = _unqualified_env_Package;
            }
            return symbol_1;
        }
        
        @SuppressWarnings("null")
        public org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_18) {
            return (org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_18});
        }
    }
    
    protected final @NonNull CACHE_OclElement_parentEnv_Package INST_OclElement_parentEnv_Package = new CACHE_OclElement_parentEnv_Package();
    
    /**
     * ocl::OclElement::_unqualified_env_Package(child : OclElement[?]) : lookup::LookupEnvironment[1]
     * 
     * parentEnv_Package()
     */
    protected class CACHE_OclElement__unqualified_env_Package extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_17 = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object)sourceAndArgumentValues[0];
            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_4 = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object)sourceAndArgumentValues[1];
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment parentEnv_Package = INST_OclElement_parentEnv_Package.evaluate(self_17);
            return parentEnv_Package;
        }
        
        @SuppressWarnings("null")
        public org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_17, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_4) {
            return (org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_17, child_4});
        }
    }
    
    /**
     * miniocl::Root::_unqualified_env_Package(child : OclElement[?]) : lookup::LookupEnvironment[?]
     * 
     * parentEnv_Package().addElements(ownedPackages)
     */
    protected class CACHE_Root__unqualified_env_Package extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Root self_19 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Root)sourceAndArgumentValues[0];
            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_5 = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object)sourceAndArgumentValues[1];
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment parentEnv_Package = INST_OclElement_parentEnv_Package.evaluate(self_19);
            @SuppressWarnings("null")
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Package> ownedPackages = self_19.getOwnedPackages();
            @SuppressWarnings("null")
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = parentEnv_Package.addElements(ownedPackages);
            return addElements;
        }
        
        public LookupEnvironment evaluate(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Root self_19, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_5) {
            return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_19, child_5});
        }
    }
    
    /**
     * miniocl::Package::_unqualified_env_Package(child : OclElement[?]) : lookup::LookupEnvironment[?]
     * 
     * parentEnv_Package().nestedEnv().addElements(ownedPackages)
     */
    protected class CACHE_Package__unqualified_env_Package extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Package self_20 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Package)sourceAndArgumentValues[0];
            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_6 = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object)sourceAndArgumentValues[1];
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment self_21 = INST_OclElement_parentEnv_Package.evaluate(self_20);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment symbol_0 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
            CTORid_parentEnv.initValue(symbol_0, self_21);
            @SuppressWarnings("null")
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Package> ownedPackages = self_20.getOwnedPackages();
            @SuppressWarnings("null")
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = symbol_0.addElements(ownedPackages);
            return addElements;
        }
        
        public LookupEnvironment evaluate(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Package self_20, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_6) {
            return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_20, child_6});
        }
    }
    
    /**
     * ocl::OclElement::unqualified_env_Package() : lookup::LookupEnvironment[1]
     * 
     * _unqualified_env_Package(null)
     */
    protected class CACHE_OclElement_unqualified_env_Package extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_16 = (/*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object)sourceAndArgumentValues[0];
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment _unqualified_env_Package = INST_OclElement__unqualified_env_Package.evaluate(self_16, null);
            return _unqualified_env_Package;
        }
        
        @SuppressWarnings("null")
        public org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull Object self_16) {
            return (org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_16});
        }
    }
    
    protected final @NonNull CACHE_OclElement_unqualified_env_Package INST_OclElement_unqualified_env_Package = new CACHE_OclElement_unqualified_env_Package();
    
    /**
     * miniocl::Visitable::lookupPackage(segments : OrderedSet(minioclcs::PathElementCS)) : miniocl::Package[?]
     * 
     * 
     * if segments->size() = 1
     * then lookupPackage(segments->first())
     * else
     *   let
     *     qualifierSegments : OrderedSet(minioclcs::PathElementCS) = segments->subOrderedSet(1,
     *       segments->size() - 1)
     *   in
     *     let
     *       qualifier : ::Package[?] = lookupPackage(qualifierSegments)
     *     in qualifier?.lookupQualifiedPackage(segments->last())
     * endif
     */
    protected class CACHE_Visitable_lookupPackage extends AbstractEvaluationOperation
    {
        @Override
        public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
            @SuppressWarnings("null") final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.util.@org.eclipse.jdt.annotation.NonNull Visitable self_14 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.util.@org.eclipse.jdt.annotation.NonNull Visitable)sourceAndArgumentValues[0];
            @SuppressWarnings("unchecked") final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue segments = (/*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue)sourceAndArgumentValues[1];
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(segments);
            final /*@NonInvalid*/ boolean eq = size.equals(INT_1);
            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package symbol_3;
            if (eq) {
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(segments);
                if (aPathElementCS == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pName_1 = aPathElementCS.getElementName();
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment unqualified_env_Package = INST_OclElement_unqualified_env_Package.evaluate(self_14);
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundPackage = INST_Visitable__lookupPackage.evaluate(self_14, unqualified_env_Package, pName_1);
                final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundPackage).booleanValue();
                /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package symbol_0;
                if (isEmpty) {
                    symbol_0 = null;
                }
                else {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package first = (Package)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundPackage);
                    symbol_0 = first;
                }
                symbol_3 = symbol_0;
            }
            else {
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(segments, INT_1, diff);
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package qualifier = INST_Visitable_lookupPackage.evaluate(self_14, qualifierSegments);
                /*@Caught*/ @Nullable Object CAUGHT_qualifier;
                try {
                    CAUGHT_qualifier = qualifier;
                }
                catch (Exception e) {
                    CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                }
                final /*@NonInvalid*/ @NonNull Object symbol_1 = CAUGHT_qualifier == null;
                /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package safe_lookupQualifiedPackage_source;
                if (symbol_1 == Boolean.TRUE) {
                    safe_lookupQualifiedPackage_source = null;
                }
                else {
                    if (qualifier == null) {
                        throw new InvalidValueException("Null where non-null value required");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(segments);
                    if (aPathElementCS_0 == null) {
                        throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pName_2 = aPathElementCS_0.getElementName();
                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
                    final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment env_3 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
                    @SuppressWarnings("null")
                    final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Package> ownedPackages = qualifier.getOwnedPackages();
                    @SuppressWarnings("null")
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = env_3.addElements(ownedPackages);
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundPackage_0 = INST_Visitable__lookupPackage.evaluate(qualifier, addElements, pName_2);
                    final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundPackage_0).booleanValue();
                    /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package symbol_2;
                    if (isEmpty_0) {
                        symbol_2 = null;
                    }
                    else {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package first_0 = (Package)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundPackage_0);
                        symbol_2 = first_0;
                    }
                    safe_lookupQualifiedPackage_source = symbol_2;
                }
                symbol_3 = safe_lookupQualifiedPackage_source;
            }
            return symbol_3;
        }
        
        public Package evaluate(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.util.@org.eclipse.jdt.annotation.NonNull Visitable self_14, final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue segments) {
            return (Package)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_14, segments});
        }
    }
    
    protected final @NonNull CACHE_Visitable_lookupPackage INST_Visitable_lookupPackage = new CACHE_Visitable_lookupPackage();
    
    /**
     * 
     * map __root__ in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   var _'\u00ABCallExpCS\u00BB' : Set(minioclcs::CallExpCS) := leftCS.objectsOfKind(minioclcs::CallExpCS)
     *   ;
     * ::ji_CallExpCS : Set(minioclcs::CallExpCS)[*|1]var _'\u00ABClassCS\u00BB' : Set(minioclcs::ClassCS) := leftCS.objectsOfKind(minioclcs::ClassCS)
     *   ;
     * ::ji_ClassCS : Set(minioclcs::ClassCS)[*|1]var _'\u00ABNameExpCS\u00BB' : Set(minioclcs::NameExpCS) := leftCS.objectsOfKind(minioclcs::NameExpCS)
     *   ;
     * ::ji_NameExpCS : Set(minioclcs::NameExpCS)[*|1]var _'\u00ABNavigationExpCS\u00BB' : Set(minioclcs::NavigationExpCS) := leftCS.objectsOfKind(minioclcs::NavigationExpCS)
     *   ;
     * ::ji_NavigationExpCS : Set(minioclcs::NavigationExpCS)[*|1]var _'\u00ABOperationCS\u00BB' : Set(minioclcs::OperationCS) := leftCS.objectsOfKind(minioclcs::OperationCS)
     *   ;
     * ::ji_OperationCS : Set(minioclcs::OperationCS)[*|1]var _'\u00ABPackageCS\u00BB' : Set(minioclcs::PackageCS) := leftCS.objectsOfKind(minioclcs::PackageCS)
     *   ;
     * ::ji_PackageCS : Set(minioclcs::PackageCS)[*|1]var _'\u00ABParameterCS\u00BB' : Set(minioclcs::ParameterCS) := leftCS.objectsOfKind(minioclcs::ParameterCS)
     *   ;
     * ::ji_ParameterCS : Set(minioclcs::ParameterCS)[*|1]var _'\u00ABPropertyCS\u00BB' : Set(minioclcs::PropertyCS) := leftCS.objectsOfKind(minioclcs::PropertyCS)
     *   ;
     * ::ji_PropertyCS : Set(minioclcs::PropertyCS)[*|1]var _'\u00ABRootCS\u00BB' : Set(minioclcs::RootCS) := leftCS.objectsOfKind(minioclcs::RootCS)
     *   ;
     * ::ji_RootCS : Set(minioclcs::RootCS)[*|1]for loop0 : minioclcs::ClassCS[1] in ji_ClassCS {
     *     call m_Class_ClassCS {
     * lClassCS iterates loop0 : minioclcs::ClassCS[1];
     * }}
     *   for loop0 : minioclcs::NameExpCS[1] in ji_NameExpCS {
     *     call m_PropertyCallExp_NameExpCS_Boolean {
     * lNameExpCS iterates loop0 : minioclcs::NameExpCS[1];
     * }}
     *   for loop0 : minioclcs::OperationCS[1] in ji_OperationCS {
     *     call m_Operation_OperationCS {
     * lOperationCS iterates loop0 : minioclcs::OperationCS[1];
     * }}
     *   for loop0 : minioclcs::PackageCS[1] in ji_PackageCS {
     *     call m_Package_PackageCS {
     * lPackageCS iterates loop0 : minioclcs::PackageCS[1];
     * }}
     *   for loop0 : minioclcs::ParameterCS[1] in ji_ParameterCS {
     *     call m_Parameter_ParameterCS {
     * lParameterCS iterates loop0 : minioclcs::ParameterCS[1];
     * }}
     *   for loop0 : minioclcs::PropertyCS[1] in ji_PropertyCS {
     *     call m_Property_PropertyCS {
     * lPropertyCS iterates loop0 : minioclcs::PropertyCS[1];
     * }}
     *   for loop0 : minioclcs::RootCS[1] in ji_RootCS {
     *     call m_Root_RootCS {
     * lRootCS iterates loop0 : minioclcs::RootCS[1];
     * }}
     *   for loop0 : minioclcs::ClassCS[1] in ji_ClassCS {
     *     call m_ClassCS_ast_name {
     * lClassCS iterates loop0 : minioclcs::ClassCS[1];
     * }}
     *   for loop0 : minioclcs::ClassCS[1] in ji_ClassCS {
     *     call m_ClassCS_ast_operations {
     * lClassCS iterates loop0 : minioclcs::ClassCS[1];
     * }}
     *   for loop0 : minioclcs::ClassCS[1] in ji_ClassCS {
     *     call m_ClassCS_ast_properties {
     * lClassCS iterates loop0 : minioclcs::ClassCS[1];
     * }}
     *   for loop0 : minioclcs::NavigationExpCS[1] in ji_NavigationExpCS {
     *     call m_NavigationExpCS_ast0 {
     * lNavigationExpCS iterates loop0 : minioclcs::NavigationExpCS[1];
     * }}
     *   for loop0 : minioclcs::OperationCS[1] in ji_OperationCS {
     *     call m_OperationCS_ast_name {
     * lOperationCS iterates loop0 : minioclcs::OperationCS[1];
     * }}
     *   for loop0 : minioclcs::OperationCS[1] in ji_OperationCS {
     *     call m_OperationCS_ast_params {
     * lOperationCS iterates loop0 : minioclcs::OperationCS[1];
     * }}
     *   for loop0 : minioclcs::PackageCS[1] in ji_PackageCS {
     *     call m_PackageCS_ast_name {
     * lPackageCS iterates loop0 : minioclcs::PackageCS[1];
     * }}
     *   for loop0 : minioclcs::PackageCS[1] in ji_PackageCS {
     *     call m_PackageCS_ast_classes {
     * lPackageCS iterates loop0 : minioclcs::PackageCS[1];
     * }}
     *   for loop0 : minioclcs::PackageCS[1] in ji_PackageCS {
     *     call m_PackageCS_ast_packages {
     * lPackageCS iterates loop0 : minioclcs::PackageCS[1];
     * }}
     *   for loop0 : minioclcs::ParameterCS[1] in ji_ParameterCS {
     *     call m_ParameterCS_ast_name {
     * lParameterCS iterates loop0 : minioclcs::ParameterCS[1];
     * }}
     *   for loop0 : minioclcs::PropertyCS[1] in ji_PropertyCS {
     *     call m_PropertyCS_ast_name {
     * lPropertyCS iterates loop0 : minioclcs::PropertyCS[1];
     * }}
     *   for loop0 : minioclcs::RootCS[1] in ji_RootCS {
     *     call m_RootCS_ast_packages {
     * lRootCS iterates loop0 : minioclcs::RootCS[1];
     * }}
     *   for loop0 : minioclcs::OperationCS[1] in ji_OperationCS {
     *     call m_OperationCS_ast_resultRef {
     * lOperationCS iterates loop0 : minioclcs::OperationCS[1];
     * }}
     *   for loop0 : minioclcs::ParameterCS[1] in ji_ParameterCS {
     *     call m_ParameterCS_ast_typeRef {
     * lParameterCS iterates loop0 : minioclcs::ParameterCS[1];
     * }}
     *   for loop0 : minioclcs::PropertyCS[1] in ji_PropertyCS {
     *     call m_PropertyCS_ast_typeRef {
     * lPropertyCS iterates loop0 : minioclcs::PropertyCS[1];
     * }}
     *   for loop0 : minioclcs::NameExpCS[1] in ji_NameExpCS {
     *     call m_PropertyCallExp_NameExpCS_Boolean_CallExpCS_Call {
     * lNameExpCS iterates loop0 : minioclcs::NameExpCS[1];
     * }}
     *   for loop0 : minioclcs::CallExpCS[1] in ji_CallExpCS {
     *     call m_CallExpCS_ast_navExp {
     * lCallExpCS iterates loop0 : minioclcs::CallExpCS[1];
     * }}
     *   for loop0 : minioclcs::NameExpCS[1] in ji_NameExpCS {
     *     call m_VariableExp_NameExpCS_Boolean_CallExpCS_CallExpC {
     * lNameExpCS iterates loop0 : minioclcs::NameExpCS[1];
     * }}
     *   for loop0 : minioclcs::NameExpCS[1] in ji_NameExpCS {
     *     call m_NameExpCS_ast {
     * lNameExpCS iterates loop0 : minioclcs::NameExpCS[1];
     * }}
     *   for loop0 : minioclcs::NameExpCS[1] in ji_NameExpCS {
     *     call m_NameExpCS_ast_2 {
     * lNameExpCS iterates loop0 : minioclcs::NameExpCS[1];
     * }}
     *   for loop0 : minioclcs::NameExpCS[1] in ji_NameExpCS {
     *     call m_NameExpCS_ast_expName_2 {
     * lNameExpCS iterates loop0 : minioclcs::NameExpCS[1];
     * }}
     *   for loop0 : minioclcs::NameExpCS[1] in ji_NameExpCS {
     *     call m_NameExpCS_ast_4 {
     * lNameExpCS iterates loop0 : minioclcs::NameExpCS[1];
     * }}
     *   for loop0 : minioclcs::NameExpCS[1] in ji_NameExpCS {
     *     call m_NameExpCS_ast_expName {
     * lNameExpCS iterates loop0 : minioclcs::NameExpCS[1];
     * }}
     *   for loop0 : minioclcs::NameExpCS[1] in ji_NameExpCS {
     *     call m_NameExpCS_ast_1 {
     * lNameExpCS iterates loop0 : minioclcs::NameExpCS[1];
     * }}
     *   for loop0 : minioclcs::NameExpCS[1] in ji_NameExpCS {
     *     call m_NameExpCS_ast_expName_1 {
     * lNameExpCS iterates loop0 : minioclcs::NameExpCS[1];
     * }}
     *   for loop0 : minioclcs::NameExpCS[1] in ji_NameExpCS {
     *     call m_NameExpCS_ast_3 {
     * lNameExpCS iterates loop0 : minioclcs::NameExpCS[1];
     * }}
     *   for loop0 : minioclcs::OperationCS[1] in ji_OperationCS {
     *     call m_OperationCS_ast_body {
     * lOperationCS iterates loop0 : minioclcs::OperationCS[1];
     * }}
     */
    protected boolean MAP___root__()  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_CallExpCS_1 = idResolver.getClass(CLSSid_CallExpCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_CallExpCS, models[0/*leftCS*/], TYP_minioclcs_c_c_CallExpCS_1);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_ClassCS_0 = idResolver.getClass(CLSSid_ClassCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_0 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_ClassCS, models[0/*leftCS*/], TYP_minioclcs_c_c_ClassCS_0);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_NameExpCS_0 = idResolver.getClass(CLSSid_NameExpCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_1 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_NameExpCS, models[0/*leftCS*/], TYP_minioclcs_c_c_NameExpCS_0);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_NavigationExpCS_1 = idResolver.getClass(CLSSid_NavigationExpCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_2 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_NavigationExpCS, models[0/*leftCS*/], TYP_minioclcs_c_c_NavigationExpCS_1);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_OperationCS_0 = idResolver.getClass(CLSSid_OperationCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_3 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_OperationCS, models[0/*leftCS*/], TYP_minioclcs_c_c_OperationCS_0);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_PackageCS_0 = idResolver.getClass(CLSSid_PackageCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_4 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_PackageCS, models[0/*leftCS*/], TYP_minioclcs_c_c_PackageCS_0);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_ParameterCS_0 = idResolver.getClass(CLSSid_ParameterCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_5 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_ParameterCS, models[0/*leftCS*/], TYP_minioclcs_c_c_ParameterCS_0);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_PropertyCS_0 = idResolver.getClass(CLSSid_PropertyCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_6 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_PropertyCS, models[0/*leftCS*/], TYP_minioclcs_c_c_PropertyCS_0);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_RootCS_0 = idResolver.getClass(CLSSid_RootCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_7 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_RootCS, models[0/*leftCS*/], TYP_minioclcs_c_c_RootCS_0);
            // connection variables
            final SetValue.@NonNull Accumulator ji_CallExpCS = createUnenforcedSetAccumulatorValue(SET_CLSSid_CallExpCS);
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CallExpCS iterator : ValueUtil.typedIterable(CallExpCS.class, objectsOfKind)) {
                ji_CallExpCS.add(iterator);
            }
            final SetValue.@NonNull Accumulator ji_ClassCS = createUnenforcedSetAccumulatorValue(SET_CLSSid_ClassCS);
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ClassCS iterator_0 : ValueUtil.typedIterable(ClassCS.class, objectsOfKind_0)) {
                ji_ClassCS.add(iterator_0);
            }
            final SetValue.@NonNull Accumulator ji_NameExpCS = createUnenforcedSetAccumulatorValue(SET_CLSSid_NameExpCS);
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS iterator_1 : ValueUtil.typedIterable(NameExpCS.class, objectsOfKind_1)) {
                ji_NameExpCS.add(iterator_1);
            }
            final SetValue.@NonNull Accumulator ji_NavigationExpCS = createUnenforcedSetAccumulatorValue(SET_CLSSid_NavigationExpCS);
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NavigationExpCS iterator_2 : ValueUtil.typedIterable(NavigationExpCS.class, objectsOfKind_2)) {
                ji_NavigationExpCS.add(iterator_2);
            }
            final SetValue.@NonNull Accumulator ji_OperationCS = createUnenforcedSetAccumulatorValue(SET_CLSSid_OperationCS);
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS iterator_3 : ValueUtil.typedIterable(OperationCS.class, objectsOfKind_3)) {
                ji_OperationCS.add(iterator_3);
            }
            final SetValue.@NonNull Accumulator ji_PackageCS = createUnenforcedSetAccumulatorValue(SET_CLSSid_PackageCS);
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PackageCS iterator_4 : ValueUtil.typedIterable(PackageCS.class, objectsOfKind_4)) {
                ji_PackageCS.add(iterator_4);
            }
            final SetValue.@NonNull Accumulator ji_ParameterCS = createUnenforcedSetAccumulatorValue(SET_CLSSid_ParameterCS);
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ParameterCS iterator_5 : ValueUtil.typedIterable(ParameterCS.class, objectsOfKind_5)) {
                ji_ParameterCS.add(iterator_5);
            }
            final SetValue.@NonNull Accumulator ji_PropertyCS = createUnenforcedSetAccumulatorValue(SET_CLSSid_PropertyCS);
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PropertyCS iterator_6 : ValueUtil.typedIterable(PropertyCS.class, objectsOfKind_6)) {
                ji_PropertyCS.add(iterator_6);
            }
            final SetValue.@NonNull Accumulator ji_RootCS = createUnenforcedSetAccumulatorValue(SET_CLSSid_RootCS);
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull RootCS iterator_7 : ValueUtil.typedIterable(RootCS.class, objectsOfKind_7)) {
                ji_RootCS.add(iterator_7);
            }
            // mapping statements
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ClassCS loop0 : ValueUtil.typedIterable(ClassCS.class, ji_ClassCS)) {
                MAP_m_Class_ClassCS(loop0);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_0 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                MAP_m_PropertyCallExp_NameExpCS_Boolean(loop0_0);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS loop0_1 : ValueUtil.typedIterable(OperationCS.class, ji_OperationCS)) {
                MAP_m_Operation_OperationCS(loop0_1);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PackageCS loop0_2 : ValueUtil.typedIterable(PackageCS.class, ji_PackageCS)) {
                MAP_m_Package_PackageCS(loop0_2);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ParameterCS loop0_3 : ValueUtil.typedIterable(ParameterCS.class, ji_ParameterCS)) {
                MAP_m_Parameter_ParameterCS(loop0_3);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PropertyCS loop0_4 : ValueUtil.typedIterable(PropertyCS.class, ji_PropertyCS)) {
                MAP_m_Property_PropertyCS(loop0_4);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull RootCS loop0_5 : ValueUtil.typedIterable(RootCS.class, ji_RootCS)) {
                MAP_m_Root_RootCS(loop0_5);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ClassCS loop0_6 : ValueUtil.typedIterable(ClassCS.class, ji_ClassCS)) {
                MAP_m_ClassCS_ast_name(loop0_6);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ClassCS loop0_7 : ValueUtil.typedIterable(ClassCS.class, ji_ClassCS)) {
                MAP_m_ClassCS_ast_operations(loop0_7);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ClassCS loop0_8 : ValueUtil.typedIterable(ClassCS.class, ji_ClassCS)) {
                MAP_m_ClassCS_ast_properties(loop0_8);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NavigationExpCS loop0_9 : ValueUtil.typedIterable(NavigationExpCS.class, ji_NavigationExpCS)) {
                MAP_m_NavigationExpCS_ast0(loop0_9);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS loop0_10 : ValueUtil.typedIterable(OperationCS.class, ji_OperationCS)) {
                MAP_m_OperationCS_ast_name(loop0_10);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS loop0_11 : ValueUtil.typedIterable(OperationCS.class, ji_OperationCS)) {
                MAP_m_OperationCS_ast_params(loop0_11);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PackageCS loop0_12 : ValueUtil.typedIterable(PackageCS.class, ji_PackageCS)) {
                MAP_m_PackageCS_ast_name(loop0_12);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PackageCS loop0_13 : ValueUtil.typedIterable(PackageCS.class, ji_PackageCS)) {
                MAP_m_PackageCS_ast_classes(loop0_13);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PackageCS loop0_14 : ValueUtil.typedIterable(PackageCS.class, ji_PackageCS)) {
                MAP_m_PackageCS_ast_packages(loop0_14);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ParameterCS loop0_15 : ValueUtil.typedIterable(ParameterCS.class, ji_ParameterCS)) {
                MAP_m_ParameterCS_ast_name(loop0_15);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PropertyCS loop0_16 : ValueUtil.typedIterable(PropertyCS.class, ji_PropertyCS)) {
                MAP_m_PropertyCS_ast_name(loop0_16);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull RootCS loop0_17 : ValueUtil.typedIterable(RootCS.class, ji_RootCS)) {
                MAP_m_RootCS_ast_packages(loop0_17);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS loop0_18 : ValueUtil.typedIterable(OperationCS.class, ji_OperationCS)) {
                MAP_m_OperationCS_ast_resultRef(loop0_18);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ParameterCS loop0_19 : ValueUtil.typedIterable(ParameterCS.class, ji_ParameterCS)) {
                MAP_m_ParameterCS_ast_typeRef(loop0_19);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PropertyCS loop0_20 : ValueUtil.typedIterable(PropertyCS.class, ji_PropertyCS)) {
                MAP_m_PropertyCS_ast_typeRef(loop0_20);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_21 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                MAP_m_PropertyCallExp_NameExpCS_Boolean_CallExpCS_Call(loop0_21);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CallExpCS loop0_22 : ValueUtil.typedIterable(CallExpCS.class, ji_CallExpCS)) {
                MAP_m_CallExpCS_ast_navExp(loop0_22);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_23 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                MAP_m_VariableExp_NameExpCS_Boolean_CallExpCS_CallExpC(loop0_23);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_24 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                MAP_m_NameExpCS_ast(loop0_24);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_25 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                MAP_m_NameExpCS_ast_2(loop0_25);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_26 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                MAP_m_NameExpCS_ast_expName_2(loop0_26);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_27 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                MAP_m_NameExpCS_ast_4(loop0_27);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_28 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                invoke(CTOR_m_NameExpCS_ast_expName, loop0_28);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_29 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                invoke(CTOR_m_NameExpCS_ast_1, loop0_29);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_30 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                invoke(CTOR_m_NameExpCS_ast_expName_1, loop0_30);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_31 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                invoke(CTOR_m_NameExpCS_ast_3, loop0_31);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS loop0_32 : ValueUtil.typedIterable(OperationCS.class, ji_OperationCS)) {
                MAP_m_OperationCS_ast_body(loop0_32);
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean __root__ = ValueUtil.TRUE_VALUE;
            return __root__;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP___root__", e);
        }
    }
    
    /**
     * 
     * map m_CallExpCS_ast_navExp in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lCallExpCS  : minioclcs::CallExpCS[1];
     * var navExp : minioclcs::NavigationExpCS[?] := lCallExpCS.navExp;
     * check lCallExpCS.oclIsTypeOf(minioclcs::CallExpCS)
     *   ;
     * var ast : miniocl::Element[?] := navExp.ast;
     * var aCallExp : miniocl::CallExp[1] := ast.oclAsType(miniocl::CallExp);
     * notify set lCallExpCS.ast := aCallExp;
     * 
     */
    protected boolean MAP_m_CallExpCS_ast_navExp(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CallExpCS lCallExpCS)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp = lCallExpCS.getNavExp();
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_CallExpCS_0_0 = idResolver.getClass(CLSSid_CallExpCS, null);
            final /*@NonInvalid*/ boolean oclIsTypeOf = OclAnyOclIsTypeOfOperation.INSTANCE.evaluate(executor, lCallExpCS, TYP_minioclcs_c_c_CallExpCS_0_0).booleanValue();
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_2;
            if (oclIsTypeOf) {
                if (navExp == null) {
                    throw throwNull(lCallExpCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CSTrace::ast\'");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = navExp.getAst();
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_CallExp_0 = idResolver.getClass(CLSSid_CallExp, null);
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull CallExp oclAsType = ClassUtil.nonNullState((CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_CallExp_0));
                // mapping statements
                lCallExpCS.setAst(oclAsType);
                objectManager.assigned(lCallExpCS, MinioclcsPackage.Literals.CS_TRACE__AST, oclAsType, null);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_CallExpCS_ast_navExp = ValueUtil.TRUE_VALUE;
                symbol_2 = m_CallExpCS_ast_navExp;
            }
            else {
                symbol_2 = ValueUtil.FALSE_VALUE;
            }
            return symbol_2;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_CallExpCS_ast_navExp", e);
        }
    }
    
    /**
     * 
     * map m_ClassCS_ast_name in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lClassCS  : minioclcs::ClassCS[1];
     * var ast : miniocl::Element[1] := lClassCS.ast;
     * var name : ecore::EString[?] := lClassCS.name;
     * var aClass : miniocl::Class[1] := ast.oclAsType(miniocl::Class)
     *   ;
     * set aClass.name := name.toString();
     * 
     */
    protected boolean MAP_m_ClassCS_ast_name(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ClassCS lClassCS)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lClassCS.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
            if (symbol_0) {
                if (ast == null) {
                    throw throwNull(lClassCS, "Null where non-null value required");
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = lClassCS.getName();
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Class_0 = idResolver.getClass(CLSSid_Class_0, null);
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class oclAsType = ClassUtil.nonNullState((org.eclipse.qvtd.doc.miniocl.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Class_0));
                // mapping statements
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
                oclAsType.setName(toString);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_ClassCS_ast_name = ValueUtil.TRUE_VALUE;
                raw_ast = m_ClassCS_ast_name;
            }
            else {
                raw_ast = ValueUtil.FALSE_VALUE;
            }
            return raw_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_ClassCS_ast_name", e);
        }
    }
    
    /**
     * 
     * map m_ClassCS_ast_operations in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lClassCS  : minioclcs::ClassCS[1];
     * var ast : miniocl::Element[1] := lClassCS.ast;
     * var operations : OrderedSet(minioclcs::OperationCS)[*|1] := lClassCS.operations;
     * var aClass : miniocl::Class[1] := ast.oclAsType(miniocl::Class)
     *   ;
     * var _'\u00ABcollect\u00BB' : Sequence(miniocl::Operation)[*|1] := operations->collect(_'1_' |
     *     _'1_'.ast.oclAsType(miniocl::Operation))
     *   ;
     * var asOrderedSet : OrderedSet(miniocl::Operation)[*|1] := _'\u00ABcollect\u00BB'->asOrderedSet();
     * set aClass.ownedOperations := asOrderedSet;
     * 
     */
    protected boolean MAP_m_ClassCS_ast_operations(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ClassCS lClassCS_0)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lClassCS_0.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
            if (symbol_0) {
                if (ast == null) {
                    throw throwNull(lClassCS_0, "Null where non-null value required");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<OperationCS> operations = lClassCS_0.getOperations();
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Class_0 = idResolver.getClass(CLSSid_Class_0, null);
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class oclAsType = ClassUtil.nonNullState((org.eclipse.qvtd.doc.miniocl.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Class_0));
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_operations = idResolver.createOrderedSetOfAll(ORD_CLSSid_OperationCS, operations);
                /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
                @NonNull Iterator<Object> ITERATOR__1 = BOXED_operations.iterator();
                /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
                while (true) {
                    if (!ITERATOR__1.hasNext()) {
                        collect = accumulator;
                        break;
                    }
                    @SuppressWarnings("null")
                    /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS _1 = (OperationCS)ITERATOR__1.next();
                    /**
                     * _'1_'.ast.oclAsType(miniocl::Operation)
                     */
                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast_0 = _1.getAst();
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Operation oclAsType_0 = ClassUtil.nonNullState((Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_miniocl_c_c_Operation_0));
                    //
                    accumulator.add(oclAsType_0);
                }
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
                // mapping statements
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Operation> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Operation.class, asOrderedSet);
                oclAsType.getOwnedOperations().addAll(ECORE_asOrderedSet);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_ClassCS_ast_operations = ValueUtil.TRUE_VALUE;
                raw_ast = m_ClassCS_ast_operations;
            }
            else {
                raw_ast = ValueUtil.FALSE_VALUE;
            }
            return raw_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_ClassCS_ast_operations", e);
        }
    }
    
    /**
     * 
     * map m_ClassCS_ast_properties in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lClassCS  : minioclcs::ClassCS[1];
     * var ast : miniocl::Element[1] := lClassCS.ast;
     * var properties : OrderedSet(minioclcs::PropertyCS)[*|1] := lClassCS.properties;
     * var aClass : miniocl::Class[1] := ast.oclAsType(miniocl::Class)
     *   ;
     * var _'\u00ABcollect\u00BB' : Sequence(miniocl::Property)[*|1] := properties->collect(_'1_' |
     *     _'1_'.ast.oclAsType(miniocl::Property))
     *   ;
     * var asOrderedSet : OrderedSet(miniocl::Property)[*|1] := _'\u00ABcollect\u00BB'->asOrderedSet();
     * set aClass.ownedProperties := asOrderedSet;
     * 
     */
    protected boolean MAP_m_ClassCS_ast_properties(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ClassCS lClassCS_1)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lClassCS_1.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
            if (symbol_0) {
                if (ast == null) {
                    throw throwNull(lClassCS_1, "Null where non-null value required");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PropertyCS> properties = lClassCS_1.getProperties();
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Class_0 = idResolver.getClass(CLSSid_Class_0, null);
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class oclAsType = ClassUtil.nonNullState((org.eclipse.qvtd.doc.miniocl.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Class_0));
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_properties = idResolver.createOrderedSetOfAll(ORD_CLSSid_PropertyCS, properties);
                /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Property);
                @NonNull Iterator<Object> ITERATOR__1 = BOXED_properties.iterator();
                /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
                while (true) {
                    if (!ITERATOR__1.hasNext()) {
                        collect = accumulator;
                        break;
                    }
                    @SuppressWarnings("null")
                    /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PropertyCS _1 = (PropertyCS)ITERATOR__1.next();
                    /**
                     * _'1_'.ast.oclAsType(miniocl::Property)
                     */
                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Property_0 = idResolver.getClass(CLSSid_Property, null);
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast_0 = _1.getAst();
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Property oclAsType_0 = ClassUtil.nonNullState((org.eclipse.qvtd.doc.miniocl.Property)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_miniocl_c_c_Property_0));
                    //
                    accumulator.add(oclAsType_0);
                }
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
                // mapping statements
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.qvtd.doc.miniocl.Property.class, asOrderedSet);
                oclAsType.getOwnedProperties().addAll(ECORE_asOrderedSet);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_ClassCS_ast_properties = ValueUtil.TRUE_VALUE;
                raw_ast = m_ClassCS_ast_properties;
            }
            else {
                raw_ast = ValueUtil.FALSE_VALUE;
            }
            return raw_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_ClassCS_ast_properties", e);
        }
    }
    
    /**
     * 
     * map m_Class_ClassCS in MiniOCLCS2AS_qvtp_qvtcas {
     * guard:leftCS lClassCS  : minioclcs::ClassCS[1];
     * new:rightAS rClass : miniocl::Class[1];
     * set lClassCS.ast := rClass;
     * 
     */
    protected boolean MAP_m_Class_ClassCS(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ClassCS lClassCS_2)  {
        try {
            // creations
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class rClass = MiniOCLFactory.eINSTANCE.createClass();
            assert rClass != null;
            models[1/*rightAS*/].add(rClass);
            // mapping statements
            lClassCS_2.setAst(rClass);
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Class_ClassCS = ValueUtil.TRUE_VALUE;
            return m_Class_ClassCS;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_Class_ClassCS", e);
        }
    }
    
    /**
     * 
     * map m_NameExpCS_ast in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
     * var ast : miniocl::Element[1] := lNameExpCS.ast;
     * check not lNameExpCS.isVariableExp()
     *   ;
     * check lNameExpCS.isPropCallExpWithImplicitSource()
     *   ;
     * check not lNameExpCS.isPropCallExpWithExplicitSource()
     *   ;
     * var aPropertyCallExp : miniocl::PropertyCallExp[1] := ast.oclAsType(miniocl::PropertyCallExp)
     *   ;
     * var lookupVariable : miniocl::Variable[?] := aPropertyCallExp.lookupVariable('self')
     *   ;
     * var type : miniocl::Class[1] := lookupVariable.type;
     * var VariableExp : miniocl::VariableExp[1] := miniocl::VariableExp{referredVariable = lookupVariable, type = type
     *   };
     * check type = lookupVariable.type;
     * set aPropertyCallExp.ownedSource := VariableExp;
     * 
     */
    protected boolean MAP_m_NameExpCS_ast(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lNameExpCS.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
            if (symbol_0) {
                if (ast == null) {
                    throw throwNull(lNameExpCS, "Null where non-null value required");
                }
                /*@Caught*/ @Nullable Object CAUGHT_and_1;
                try {
                    /*@Caught*/ @Nullable Object CAUGHT_and_0;
                    try {
                        /*@Caught*/ @Nullable Object CAUGHT_and;
                        try {
                            /*@Caught*/ @NonNull Object CAUGHT_eq;
                            try {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS.getRoundedBrackets();
                                final /*@Thrown*/ boolean eq = roundedBrackets == null;
                                CAUGHT_eq = eq;
                            }
                            catch (Exception e) {
                                CAUGHT_eq = ValueUtil.createInvalidValue(e);
                            }
                            /*@Caught*/ @Nullable Object CAUGHT_not;
                            try {
                                /*@Caught*/ @NonNull Object CAUGHT_symbol_1;
                                try {
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS);
                                    final /*@Thrown*/ boolean eq_0 = parentCallExpCS == null;
                                    /*@Thrown*/ boolean symbol_1;
                                    if (eq_0) {
                                        symbol_1 = ValueUtil.FALSE_VALUE;
                                    }
                                    else {
                                        if (parentCallExpCS == null) {
                                            throw throwNull(lNameExpCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                                        }
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
                                        final /*@Thrown*/ boolean eq_1 = lNameExpCS.equals(navExp);
                                        symbol_1 = eq_1;
                                    }
                                    CAUGHT_symbol_1 = symbol_1;
                                }
                                catch (Exception e) {
                                    CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
                                }
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_1);
                                CAUGHT_not = not;
                            }
                            catch (Exception e) {
                                CAUGHT_not = ValueUtil.createInvalidValue(e);
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_not);
                            CAUGHT_and = and;
                        }
                        catch (Exception e) {
                            CAUGHT_and = ValueUtil.createInvalidValue(e);
                        }
                        /*@Caught*/ @NonNull Object CAUGHT_eq_2;
                        try {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName = lNameExpCS.getExpName();
                            if (expName == null) {
                                throw throwNull(lNameExpCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
                            }
                            @SuppressWarnings("null")
                            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> pathElements = expName.getPathElements();
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
                            final /*@Thrown*/ boolean eq_2 = size.equals(INT_1);
                            CAUGHT_eq_2 = eq_2;
                        }
                        catch (Exception e) {
                            CAUGHT_eq_2 = ValueUtil.createInvalidValue(e);
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_0 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and, CAUGHT_eq_2);
                        CAUGHT_and_0 = and_0;
                    }
                    catch (Exception e) {
                        CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
                    }
                    /*@Caught*/ @NonNull Object CAUGHT_ne;
                    try {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Variable lookupVariableToDisambiguate = INST_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS);
                        final /*@Thrown*/ boolean ne = lookupVariableToDisambiguate != null;
                        CAUGHT_ne = ne;
                    }
                    catch (Exception e) {
                        CAUGHT_ne = ValueUtil.createInvalidValue(e);
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_0, CAUGHT_ne);
                    CAUGHT_and_1 = and_1;
                }
                catch (Exception e) {
                    CAUGHT_and_1 = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_1);
                if (not_0 == null) {
                    throw throwNull(lNameExpCS, "Null if condition");
                }
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_12;
                if (not_0) {
                    /*@Caught*/ @NonNull Object CAUGHT_eq_3;
                    try {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS.getRoundedBrackets();
                        final /*@Thrown*/ boolean eq_3 = roundedBrackets_0 == null;
                        CAUGHT_eq_3 = eq_3;
                    }
                    catch (Exception e) {
                        CAUGHT_eq_3 = ValueUtil.createInvalidValue(e);
                    }
                    /*@Caught*/ @Nullable Object CAUGHT_not_1;
                    try {
                        /*@Caught*/ @NonNull Object CAUGHT_symbol_2;
                        try {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS_0 = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS);
                            final /*@Thrown*/ boolean eq_4 = parentCallExpCS_0 == null;
                            /*@Thrown*/ boolean symbol_2;
                            if (eq_4) {
                                symbol_2 = ValueUtil.FALSE_VALUE;
                            }
                            else {
                                if (parentCallExpCS_0 == null) {
                                    throw throwNull(lNameExpCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
                                final /*@Thrown*/ boolean eq_5 = lNameExpCS.equals(navExp_0);
                                symbol_2 = eq_5;
                            }
                            CAUGHT_symbol_2 = symbol_2;
                        }
                        catch (Exception e) {
                            CAUGHT_symbol_2 = ValueUtil.createInvalidValue(e);
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_1 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_2);
                        CAUGHT_not_1 = not_1;
                    }
                    catch (Exception e) {
                        CAUGHT_not_1 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_3, CAUGHT_not_1);
                    if (and_2 == null) {
                        throw throwNull(lNameExpCS, "Null if condition");
                    }
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_11;
                    if (and_2) {
                        /*@Caught*/ @Nullable Object CAUGHT_and_3;
                        try {
                            /*@Caught*/ @NonNull Object CAUGHT_eq_6;
                            try {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets_1 = lNameExpCS.getRoundedBrackets();
                                final /*@Thrown*/ boolean eq_6 = roundedBrackets_1 == null;
                                CAUGHT_eq_6 = eq_6;
                            }
                            catch (Exception e) {
                                CAUGHT_eq_6 = ValueUtil.createInvalidValue(e);
                            }
                            /*@Caught*/ @NonNull Object CAUGHT_symbol_3;
                            try {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS_1 = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS);
                                final /*@Thrown*/ boolean eq_7 = parentCallExpCS_1 == null;
                                /*@Thrown*/ boolean symbol_3;
                                if (eq_7) {
                                    symbol_3 = ValueUtil.FALSE_VALUE;
                                }
                                else {
                                    if (parentCallExpCS_1 == null) {
                                        throw throwNull(lNameExpCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                                    }
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp_1 = parentCallExpCS_1.getNavExp();
                                    final /*@Thrown*/ boolean eq_8 = lNameExpCS.equals(navExp_1);
                                    symbol_3 = eq_8;
                                }
                                CAUGHT_symbol_3 = symbol_3;
                            }
                            catch (Exception e) {
                                CAUGHT_symbol_3 = ValueUtil.createInvalidValue(e);
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_3 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_6, CAUGHT_symbol_3);
                            CAUGHT_and_3 = and_3;
                        }
                        catch (Exception e) {
                            CAUGHT_and_3 = ValueUtil.createInvalidValue(e);
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_2 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_3);
                        if (not_2 == null) {
                            throw throwNull(lNameExpCS, "Null if condition");
                        }
                        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_10;
                        if (not_2) {
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_PropertyCallExp_0 = idResolver.getClass(CLSSid_PropertyCallExp, null);
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull PropertyCallExp oclAsType = ClassUtil.nonNullState((PropertyCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_PropertyCallExp_0));
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment unqualified_env_Variable = INST_OclElement_unqualified_env_Variable.evaluate(oclAsType);
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundVariable = INST_Visitable__lookupVariable.evaluate(oclAsType, unqualified_env_Variable, STR_self);
                            final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundVariable).booleanValue();
                            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Variable symbol_4;
                            if (isEmpty) {
                                symbol_4 = null;
                            }
                            else {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Variable first = (Variable)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundVariable);
                                symbol_4 = first;
                            }
                            if (symbol_4 == null) {
                                throw throwNull(lNameExpCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/1.0\'::TypedElement::type\'");
                            }
                            @SuppressWarnings("null")
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class type = symbol_4.getType();
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property CTORid_referredVariable = idResolver.getProperty(PROPid_referredVariable);
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property CTORid_type = idResolver.getProperty(PROPid_type);
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_VariableExp_0 = idResolver.getClass(CLSSid_VariableExp, null);
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull VariableExp symbol_7 = (VariableExp)TYP_miniocl_c_c_VariableExp_0.createInstance();
                            CTORid_referredVariable.initValue(symbol_7, symbol_4);
                            CTORid_type.initValue(symbol_7, type);
                            // mapping statements
                            oclAsType.setOwnedSource(symbol_7);
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_NameExpCS_ast = ValueUtil.TRUE_VALUE;
                            symbol_10 = m_NameExpCS_ast;
                        }
                        else {
                            symbol_10 = ValueUtil.FALSE_VALUE;
                        }
                        symbol_11 = symbol_10;
                    }
                    else {
                        symbol_11 = ValueUtil.FALSE_VALUE;
                    }
                    symbol_12 = symbol_11;
                }
                else {
                    symbol_12 = ValueUtil.FALSE_VALUE;
                }
                raw_ast = symbol_12;
            }
            else {
                raw_ast = ValueUtil.FALSE_VALUE;
            }
            return raw_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_NameExpCS_ast", e);
        }
    }
    
    /**
     * 
     * map m_NameExpCS_ast_1 in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
     * var ast : miniocl::Element[1] := lNameExpCS.ast;
     * check not lNameExpCS.isPropCallExpWithExplicitSource()
     *   ;
     * check not lNameExpCS.isVariableExp()
     *   ;
     * check lNameExpCS.isPropCallExpWithImplicitSource()
     *   ;
     * var aPropertyCallExp : miniocl::PropertyCallExp[1] := ast.oclAsType(miniocl::PropertyCallExp);
     * var referredProperty : miniocl::Property[1] := aPropertyCallExp.referredProperty;
     * var _'=' : Boolean[1] := referredProperty =
     *   null;
     * var type : miniocl::Class[1] := referredProperty.type;
     * var _'if' : miniocl::Class[?] := if _'='
     *   then null
     *   else type
     *   endif;
     * notify set aPropertyCallExp.type := _'if';
     * 
     */
    protected class MAP_m_NameExpCS_ast_1 extends AbstractInvocation
    {
        protected final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_0;
        
        public MAP_m_NameExpCS_ast_1(@NonNull Object @NonNull [] boundValues) {
            lNameExpCS_0 = (NameExpCS)boundValues[0];
        }
        
        @Override
        public boolean execute()  {
            try {
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lNameExpCS_0.getAst();
                final /*@Thrown*/ boolean symbol_0 = ast != null;
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                if (symbol_0) {
                    if (ast == null) {
                        throw throwNull(lNameExpCS_0, "Null where non-null value required");
                    }
                    /*@Caught*/ @Nullable Object CAUGHT_and;
                    try {
                        /*@Caught*/ @NonNull Object CAUGHT_eq;
                        try {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_0.getRoundedBrackets();
                            final /*@Thrown*/ boolean eq = roundedBrackets == null;
                            CAUGHT_eq = eq;
                        }
                        catch (Exception e) {
                            CAUGHT_eq = ValueUtil.createInvalidValue(e);
                        }
                        /*@Caught*/ @NonNull Object CAUGHT_symbol_1;
                        try {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_0);
                            final /*@Thrown*/ boolean eq_0 = parentCallExpCS == null;
                            /*@Thrown*/ boolean symbol_1;
                            if (eq_0) {
                                symbol_1 = ValueUtil.FALSE_VALUE;
                            }
                            else {
                                if (parentCallExpCS == null) {
                                    throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
                                final /*@Thrown*/ boolean eq_1 = lNameExpCS_0.equals(navExp);
                                symbol_1 = eq_1;
                            }
                            CAUGHT_symbol_1 = symbol_1;
                        }
                        catch (Exception e) {
                            CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_1);
                        CAUGHT_and = and;
                    }
                    catch (Exception e) {
                        CAUGHT_and = ValueUtil.createInvalidValue(e);
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and);
                    if (not == null) {
                        throw throwNull(lNameExpCS_0, "Null if condition");
                    }
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_8;
                    if (not) {
                        /*@Caught*/ @Nullable Object CAUGHT_and_2;
                        try {
                            /*@Caught*/ @Nullable Object CAUGHT_and_1;
                            try {
                                /*@Caught*/ @Nullable Object CAUGHT_and_0;
                                try {
                                    /*@Caught*/ @NonNull Object CAUGHT_eq_2;
                                    try {
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_0.getRoundedBrackets();
                                        final /*@Thrown*/ boolean eq_2 = roundedBrackets_0 == null;
                                        CAUGHT_eq_2 = eq_2;
                                    }
                                    catch (Exception e) {
                                        CAUGHT_eq_2 = ValueUtil.createInvalidValue(e);
                                    }
                                    /*@Caught*/ @Nullable Object CAUGHT_not_0;
                                    try {
                                        /*@Caught*/ @NonNull Object CAUGHT_symbol_2;
                                        try {
                                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS_0 = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_0);
                                            final /*@Thrown*/ boolean eq_3 = parentCallExpCS_0 == null;
                                            /*@Thrown*/ boolean symbol_2;
                                            if (eq_3) {
                                                symbol_2 = ValueUtil.FALSE_VALUE;
                                            }
                                            else {
                                                if (parentCallExpCS_0 == null) {
                                                    throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                                                }
                                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
                                                final /*@Thrown*/ boolean eq_4 = lNameExpCS_0.equals(navExp_0);
                                                symbol_2 = eq_4;
                                            }
                                            CAUGHT_symbol_2 = symbol_2;
                                        }
                                        catch (Exception e) {
                                            CAUGHT_symbol_2 = ValueUtil.createInvalidValue(e);
                                        }
                                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_2);
                                        CAUGHT_not_0 = not_0;
                                    }
                                    catch (Exception e) {
                                        CAUGHT_not_0 = ValueUtil.createInvalidValue(e);
                                    }
                                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_0 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_2, CAUGHT_not_0);
                                    CAUGHT_and_0 = and_0;
                                }
                                catch (Exception e) {
                                    CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
                                }
                                /*@Caught*/ @NonNull Object CAUGHT_eq_5;
                                try {
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName = lNameExpCS_0.getExpName();
                                    if (expName == null) {
                                        throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
                                    }
                                    @SuppressWarnings("null")
                                    final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> pathElements = expName.getPathElements();
                                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
                                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
                                    final /*@Thrown*/ boolean eq_5 = size.equals(INT_1);
                                    CAUGHT_eq_5 = eq_5;
                                }
                                catch (Exception e) {
                                    CAUGHT_eq_5 = ValueUtil.createInvalidValue(e);
                                }
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_0, CAUGHT_eq_5);
                                CAUGHT_and_1 = and_1;
                            }
                            catch (Exception e) {
                                CAUGHT_and_1 = ValueUtil.createInvalidValue(e);
                            }
                            /*@Caught*/ @NonNull Object CAUGHT_ne;
                            try {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Variable lookupVariableToDisambiguate = INST_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_0);
                                final /*@Thrown*/ boolean ne = lookupVariableToDisambiguate != null;
                                CAUGHT_ne = ne;
                            }
                            catch (Exception e) {
                                CAUGHT_ne = ValueUtil.createInvalidValue(e);
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_1, CAUGHT_ne);
                            CAUGHT_and_2 = and_2;
                        }
                        catch (Exception e) {
                            CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_1 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_2);
                        if (not_1 == null) {
                            throw throwNull(lNameExpCS_0, "Null if condition");
                        }
                        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_7;
                        if (not_1) {
                            /*@Caught*/ @NonNull Object CAUGHT_eq_6;
                            try {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets_1 = lNameExpCS_0.getRoundedBrackets();
                                final /*@Thrown*/ boolean eq_6 = roundedBrackets_1 == null;
                                CAUGHT_eq_6 = eq_6;
                            }
                            catch (Exception e) {
                                CAUGHT_eq_6 = ValueUtil.createInvalidValue(e);
                            }
                            /*@Caught*/ @Nullable Object CAUGHT_not_2;
                            try {
                                /*@Caught*/ @NonNull Object CAUGHT_symbol_3;
                                try {
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS_1 = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_0);
                                    final /*@Thrown*/ boolean eq_7 = parentCallExpCS_1 == null;
                                    /*@Thrown*/ boolean symbol_3;
                                    if (eq_7) {
                                        symbol_3 = ValueUtil.FALSE_VALUE;
                                    }
                                    else {
                                        if (parentCallExpCS_1 == null) {
                                            throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                                        }
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp_1 = parentCallExpCS_1.getNavExp();
                                        final /*@Thrown*/ boolean eq_8 = lNameExpCS_0.equals(navExp_1);
                                        symbol_3 = eq_8;
                                    }
                                    CAUGHT_symbol_3 = symbol_3;
                                }
                                catch (Exception e) {
                                    CAUGHT_symbol_3 = ValueUtil.createInvalidValue(e);
                                }
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_2 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_3);
                                CAUGHT_not_2 = not_2;
                            }
                            catch (Exception e) {
                                CAUGHT_not_2 = ValueUtil.createInvalidValue(e);
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_3 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_6, CAUGHT_not_2);
                            if (and_3 == null) {
                                throw throwNull(lNameExpCS_0, "Null if condition");
                            }
                            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_6;
                            if (and_3) {
                                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_PropertyCallExp_0 = idResolver.getClass(CLSSid_PropertyCallExp, null);
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull PropertyCallExp oclAsType = ClassUtil.nonNullState((PropertyCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_PropertyCallExp_0));
                                objectManager.getting(oclAsType, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, false);
                                @SuppressWarnings("null")
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Property referredProperty = oclAsType.getReferredProperty();
                                @SuppressWarnings("null")
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class type = referredProperty.getType();
                                // mapping statements
                                oclAsType.setType(type);
                                objectManager.assigned(oclAsType, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, type, null);
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_NameExpCS_ast_1 = ValueUtil.TRUE_VALUE;
                                symbol_6 = m_NameExpCS_ast_1;
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
                    raw_ast = symbol_8;
                }
                else {
                    raw_ast = ValueUtil.FALSE_VALUE;
                }
                return raw_ast;
            } catch (Throwable e) {
                return handleExecutionFailure("MAP_m_NameExpCS_ast_1", e);
            }
        }
        
        @Override
        public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
            return idResolver.oclEquals(lNameExpCS_0, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map m_NameExpCS_ast_2 in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
     * var ast : miniocl::Element[1] := lNameExpCS.ast;
     * var parentAsCallExpCS : minioclcs::CallExpCS[?] := lNameExpCS.parentAsCallExpCS()
     *   ;
     * check lNameExpCS.isPropCallExpWithExplicitSource();
     * var _'=' : Boolean[1] := parentAsCallExpCS =
     *   null;
     * var aPropertyCallExp : miniocl::PropertyCallExp[1] := ast.oclAsType(miniocl::PropertyCallExp)
     *   ;
     * var source : minioclcs::CallExpCS[?] := parentAsCallExpCS.source;
     * var _'if' : minioclcs::CallExpCS[?] := if _'='
     *   then null
     *   else parentAsCallExpCS.source
     *   endif;
     * check source = parentAsCallExpCS.source;
     * var _'=1' : Boolean[1] := _'if' = null;
     * var ast1 : miniocl::Element[1] := _'if'.ast;
     * check ast1 =
     *   _'if'.ast;
     * var if1 : miniocl::Element[?] := if _'=1'
     *   then null
     *   else ast1
     *   endif;
     * var _'=2' : Boolean[1] := if1 =
     *   null;
     * var if2 : miniocl::CallExp[?] := if _'=2'
     *   then null
     *   else if1.oclAsType(miniocl::CallExp)
     *   endif;
     * set aPropertyCallExp.ownedSource := if2;
     * 
     */
    protected boolean MAP_m_NameExpCS_ast_2(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_1)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lNameExpCS_1.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
            if (symbol_0) {
                if (ast == null) {
                    throw throwNull(lNameExpCS_1, "Null where non-null value required");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentAsCallExpCS = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_1);
                /*@Caught*/ @NonNull Object CAUGHT_eq;
                try {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_1.getRoundedBrackets();
                    final /*@Thrown*/ boolean eq = roundedBrackets == null;
                    CAUGHT_eq = eq;
                }
                catch (Exception e) {
                    CAUGHT_eq = ValueUtil.createInvalidValue(e);
                }
                /*@Caught*/ @NonNull Object CAUGHT_symbol_1;
                try {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_1);
                    final /*@Thrown*/ boolean eq_0 = parentCallExpCS == null;
                    /*@Thrown*/ boolean symbol_1;
                    if (eq_0) {
                        symbol_1 = ValueUtil.FALSE_VALUE;
                    }
                    else {
                        if (parentCallExpCS == null) {
                            throw throwNull(lNameExpCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                        }
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
                        final /*@Thrown*/ boolean eq_1 = lNameExpCS_1.equals(navExp);
                        symbol_1 = eq_1;
                    }
                    CAUGHT_symbol_1 = symbol_1;
                }
                catch (Exception e) {
                    CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_1);
                if (and == null) {
                    throw throwNull(lNameExpCS_1, "Null if condition");
                }
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_11;
                if (and) {
                    final /*@Thrown*/ boolean symbol_2 = parentAsCallExpCS == null;
                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_PropertyCallExp_0 = idResolver.getClass(CLSSid_PropertyCallExp, null);
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull PropertyCallExp oclAsType = ClassUtil.nonNullState((PropertyCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_PropertyCallExp_0));
                    if (parentAsCallExpCS == null) {
                        throw throwNull(lNameExpCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::source\'");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS source = parentAsCallExpCS.getSource();
                    /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS symbol_3;
                    if (symbol_2) {
                        symbol_3 = null;
                    }
                    else {
                        symbol_3 = source;
                    }
                    final /*@Thrown*/ boolean symbol_4 = symbol_3 == null;
                    if (symbol_3 == null) {
                        throw throwNull(lNameExpCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CSTrace::ast\'");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast_0 = symbol_3.getAst();
                    final /*@Thrown*/ boolean symbol_5 = ast_0 != null;
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast1;
                    if (symbol_5) {
                        if (ast_0 == null) {
                            throw throwNull(lNameExpCS_1, "Null where non-null value required");
                        }
                        /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element symbol_6;
                        if (symbol_4) {
                            symbol_6 = null;
                        }
                        else {
                            symbol_6 = ast_0;
                        }
                        final /*@Thrown*/ boolean symbol_7 = symbol_6 == null;
                        /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable CallExp symbol_8;
                        if (symbol_7) {
                            symbol_8 = null;
                        }
                        else {
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_CallExp_0 = idResolver.getClass(CLSSid_CallExp, null);
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull CallExp oclAsType_0 = ClassUtil.nonNullState((CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, symbol_6, TYP_miniocl_c_c_CallExp_0));
                            symbol_8 = oclAsType_0;
                        }
                        // mapping statements
                        if (symbol_8 == null) {
                            throw throwNull(lNameExpCS_1, "Null value for miniocl::CallExp::ownedSource assignment");
                        }
                        oclAsType.setOwnedSource(symbol_8);
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_NameExpCS_ast_2 = ValueUtil.TRUE_VALUE;
                        raw_ast1 = m_NameExpCS_ast_2;
                    }
                    else {
                        raw_ast1 = ValueUtil.FALSE_VALUE;
                    }
                    symbol_11 = raw_ast1;
                }
                else {
                    symbol_11 = ValueUtil.FALSE_VALUE;
                }
                raw_ast = symbol_11;
            }
            else {
                raw_ast = ValueUtil.FALSE_VALUE;
            }
            return raw_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_NameExpCS_ast_2", e);
        }
    }
    
    /**
     * 
     * map m_NameExpCS_ast_3 in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
     * var ast : miniocl::Element[1] := lNameExpCS.ast;
     * check lNameExpCS.isPropCallExpWithExplicitSource()
     *   ;
     * var aPropertyCallExp : miniocl::PropertyCallExp[1] := ast.oclAsType(miniocl::PropertyCallExp);
     * var referredProperty : miniocl::Property[1] := aPropertyCallExp.referredProperty;
     * var _'=' : Boolean[1] := referredProperty =
     *   null;
     * var type : miniocl::Class[1] := referredProperty.type;
     * var _'if' : miniocl::Class[?] := if _'='
     *   then null
     *   else type
     *   endif;
     * notify set aPropertyCallExp.type := _'if';
     * 
     */
    protected class MAP_m_NameExpCS_ast_3 extends AbstractInvocation
    {
        protected final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_2;
        
        public MAP_m_NameExpCS_ast_3(@NonNull Object @NonNull [] boundValues) {
            lNameExpCS_2 = (NameExpCS)boundValues[0];
        }
        
        @Override
        public boolean execute()  {
            try {
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lNameExpCS_2.getAst();
                final /*@Thrown*/ boolean symbol_0 = ast != null;
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                if (symbol_0) {
                    if (ast == null) {
                        throw throwNull(lNameExpCS_2, "Null where non-null value required");
                    }
                    /*@Caught*/ @NonNull Object CAUGHT_eq;
                    try {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_2.getRoundedBrackets();
                        final /*@Thrown*/ boolean eq = roundedBrackets == null;
                        CAUGHT_eq = eq;
                    }
                    catch (Exception e) {
                        CAUGHT_eq = ValueUtil.createInvalidValue(e);
                    }
                    /*@Caught*/ @NonNull Object CAUGHT_symbol_1;
                    try {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_2);
                        final /*@Thrown*/ boolean eq_0 = parentCallExpCS == null;
                        /*@Thrown*/ boolean symbol_1;
                        if (eq_0) {
                            symbol_1 = ValueUtil.FALSE_VALUE;
                        }
                        else {
                            if (parentCallExpCS == null) {
                                throw throwNull(lNameExpCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                            }
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
                            final /*@Thrown*/ boolean eq_1 = lNameExpCS_2.equals(navExp);
                            symbol_1 = eq_1;
                        }
                        CAUGHT_symbol_1 = symbol_1;
                    }
                    catch (Exception e) {
                        CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_1);
                    if (and == null) {
                        throw throwNull(lNameExpCS_2, "Null if condition");
                    }
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_4;
                    if (and) {
                        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_PropertyCallExp_0 = idResolver.getClass(CLSSid_PropertyCallExp, null);
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull PropertyCallExp oclAsType = ClassUtil.nonNullState((PropertyCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_PropertyCallExp_0));
                        objectManager.getting(oclAsType, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, false);
                        @SuppressWarnings("null")
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Property referredProperty = oclAsType.getReferredProperty();
                        @SuppressWarnings("null")
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class type = referredProperty.getType();
                        // mapping statements
                        oclAsType.setType(type);
                        objectManager.assigned(oclAsType, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, type, null);
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_NameExpCS_ast_3 = ValueUtil.TRUE_VALUE;
                        symbol_4 = m_NameExpCS_ast_3;
                    }
                    else {
                        symbol_4 = ValueUtil.FALSE_VALUE;
                    }
                    raw_ast = symbol_4;
                }
                else {
                    raw_ast = ValueUtil.FALSE_VALUE;
                }
                return raw_ast;
            } catch (Throwable e) {
                return handleExecutionFailure("MAP_m_NameExpCS_ast_3", e);
            }
        }
        
        @Override
        public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
            return idResolver.oclEquals(lNameExpCS_2, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map m_NameExpCS_ast_4 in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
     * var ast : miniocl::Element[1] := lNameExpCS.ast;
     * check not lNameExpCS.isPropCallExpWithExplicitSource()
     *   ;
     * check lNameExpCS.isVariableExp()
     *   ;
     * var aVariableExp : miniocl::VariableExp[1] := ast.oclAsType(miniocl::VariableExp);
     * var referredVariable : miniocl::Variable[1] := aVariableExp.referredVariable;
     * var type : miniocl::Class[1] := referredVariable.type;
     * notify set aVariableExp.type := type;
     * 
     */
    protected boolean MAP_m_NameExpCS_ast_4(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_3)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lNameExpCS_3.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
            if (symbol_0) {
                if (ast == null) {
                    throw throwNull(lNameExpCS_3, "Null where non-null value required");
                }
                /*@Caught*/ @Nullable Object CAUGHT_and;
                try {
                    /*@Caught*/ @NonNull Object CAUGHT_eq;
                    try {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_3.getRoundedBrackets();
                        final /*@Thrown*/ boolean eq = roundedBrackets == null;
                        CAUGHT_eq = eq;
                    }
                    catch (Exception e) {
                        CAUGHT_eq = ValueUtil.createInvalidValue(e);
                    }
                    /*@Caught*/ @NonNull Object CAUGHT_symbol_1;
                    try {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_3);
                        final /*@Thrown*/ boolean eq_0 = parentCallExpCS == null;
                        /*@Thrown*/ boolean symbol_1;
                        if (eq_0) {
                            symbol_1 = ValueUtil.FALSE_VALUE;
                        }
                        else {
                            if (parentCallExpCS == null) {
                                throw throwNull(lNameExpCS_3, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                            }
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
                            final /*@Thrown*/ boolean eq_1 = lNameExpCS_3.equals(navExp);
                            symbol_1 = eq_1;
                        }
                        CAUGHT_symbol_1 = symbol_1;
                    }
                    catch (Exception e) {
                        CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_1);
                    CAUGHT_and = and;
                }
                catch (Exception e) {
                    CAUGHT_and = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and);
                if (not == null) {
                    throw throwNull(lNameExpCS_3, "Null if condition");
                }
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_6;
                if (not) {
                    /*@Caught*/ @Nullable Object CAUGHT_and_1;
                    try {
                        /*@Caught*/ @Nullable Object CAUGHT_and_0;
                        try {
                            /*@Caught*/ @NonNull Object CAUGHT_eq_2;
                            try {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_3.getRoundedBrackets();
                                final /*@Thrown*/ boolean eq_2 = roundedBrackets_0 == null;
                                CAUGHT_eq_2 = eq_2;
                            }
                            catch (Exception e) {
                                CAUGHT_eq_2 = ValueUtil.createInvalidValue(e);
                            }
                            /*@Caught*/ @Nullable Object CAUGHT_not_0;
                            try {
                                /*@Caught*/ @NonNull Object CAUGHT_symbol_2;
                                try {
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS_0 = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_3);
                                    final /*@Thrown*/ boolean eq_3 = parentCallExpCS_0 == null;
                                    /*@Thrown*/ boolean symbol_2;
                                    if (eq_3) {
                                        symbol_2 = ValueUtil.FALSE_VALUE;
                                    }
                                    else {
                                        if (parentCallExpCS_0 == null) {
                                            throw throwNull(lNameExpCS_3, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                                        }
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
                                        final /*@Thrown*/ boolean eq_4 = lNameExpCS_3.equals(navExp_0);
                                        symbol_2 = eq_4;
                                    }
                                    CAUGHT_symbol_2 = symbol_2;
                                }
                                catch (Exception e) {
                                    CAUGHT_symbol_2 = ValueUtil.createInvalidValue(e);
                                }
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_2);
                                CAUGHT_not_0 = not_0;
                            }
                            catch (Exception e) {
                                CAUGHT_not_0 = ValueUtil.createInvalidValue(e);
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_0 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_2, CAUGHT_not_0);
                            CAUGHT_and_0 = and_0;
                        }
                        catch (Exception e) {
                            CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
                        }
                        /*@Caught*/ @NonNull Object CAUGHT_eq_5;
                        try {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName = lNameExpCS_3.getExpName();
                            if (expName == null) {
                                throw throwNull(lNameExpCS_3, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
                            }
                            @SuppressWarnings("null")
                            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> pathElements = expName.getPathElements();
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
                            final /*@Thrown*/ boolean eq_5 = size.equals(INT_1);
                            CAUGHT_eq_5 = eq_5;
                        }
                        catch (Exception e) {
                            CAUGHT_eq_5 = ValueUtil.createInvalidValue(e);
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_0, CAUGHT_eq_5);
                        CAUGHT_and_1 = and_1;
                    }
                    catch (Exception e) {
                        CAUGHT_and_1 = ValueUtil.createInvalidValue(e);
                    }
                    /*@Caught*/ @NonNull Object CAUGHT_ne;
                    try {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Variable lookupVariableToDisambiguate = INST_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_3);
                        final /*@Thrown*/ boolean ne = lookupVariableToDisambiguate != null;
                        CAUGHT_ne = ne;
                    }
                    catch (Exception e) {
                        CAUGHT_ne = ValueUtil.createInvalidValue(e);
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_1, CAUGHT_ne);
                    if (and_2 == null) {
                        throw throwNull(lNameExpCS_3, "Null if condition");
                    }
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_5;
                    if (and_2) {
                        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_VariableExp_0 = idResolver.getClass(CLSSid_VariableExp, null);
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull VariableExp oclAsType = ClassUtil.nonNullState((VariableExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_VariableExp_0));
                        @SuppressWarnings("null")
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Variable referredVariable = oclAsType.getReferredVariable();
                        @SuppressWarnings("null")
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class type = referredVariable.getType();
                        // mapping statements
                        oclAsType.setType(type);
                        objectManager.assigned(oclAsType, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, type, null);
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_NameExpCS_ast_4 = ValueUtil.TRUE_VALUE;
                        symbol_5 = m_NameExpCS_ast_4;
                    }
                    else {
                        symbol_5 = ValueUtil.FALSE_VALUE;
                    }
                    symbol_6 = symbol_5;
                }
                else {
                    symbol_6 = ValueUtil.FALSE_VALUE;
                }
                raw_ast = symbol_6;
            }
            else {
                raw_ast = ValueUtil.FALSE_VALUE;
            }
            return raw_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_NameExpCS_ast_4", e);
        }
    }
    
    /**
     * 
     * map m_NameExpCS_ast_expName in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
     * var ast : miniocl::Element[1] := lNameExpCS.ast;
     * var expName : minioclcs::PathNameCS[?] := lNameExpCS.expName;
     * check not lNameExpCS.isVariableExp()
     *   ;
     * check not lNameExpCS.isPropCallExpWithExplicitSource()
     *   ;
     * check lNameExpCS.isPropCallExpWithImplicitSource()
     *   ;
     * var aPropertyCallExp : miniocl::PropertyCallExp[1] := ast.oclAsType(miniocl::PropertyCallExp)
     *   ;
     * var ownedSource : miniocl::OCLExpression[1] := aPropertyCallExp.ownedSource;
     * var type : miniocl::Class[1] := ownedSource.type;
     * var lookupPropertyFrom : miniocl::Property[?] := aPropertyCallExp.lookupPropertyFrom(type, expName);
     * notify set aPropertyCallExp.referredProperty := lookupPropertyFrom;
     * 
     */
    protected class MAP_m_NameExpCS_ast_expName extends AbstractInvocation
    {
        protected final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_4;
        
        public MAP_m_NameExpCS_ast_expName(@NonNull Object @NonNull [] boundValues) {
            lNameExpCS_4 = (NameExpCS)boundValues[0];
        }
        
        @Override
        public boolean execute()  {
            try {
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lNameExpCS_4.getAst();
                final /*@Thrown*/ boolean symbol_0 = ast != null;
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                if (symbol_0) {
                    if (ast == null) {
                        throw throwNull(lNameExpCS_4, "Null where non-null value required");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName = lNameExpCS_4.getExpName();
                    /*@Caught*/ @Nullable Object CAUGHT_and_1;
                    try {
                        /*@Caught*/ @Nullable Object CAUGHT_and_0;
                        try {
                            /*@Caught*/ @Nullable Object CAUGHT_and;
                            try {
                                /*@Caught*/ @NonNull Object CAUGHT_eq;
                                try {
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_4.getRoundedBrackets();
                                    final /*@Thrown*/ boolean eq = roundedBrackets == null;
                                    CAUGHT_eq = eq;
                                }
                                catch (Exception e) {
                                    CAUGHT_eq = ValueUtil.createInvalidValue(e);
                                }
                                /*@Caught*/ @Nullable Object CAUGHT_not;
                                try {
                                    /*@Caught*/ @NonNull Object CAUGHT_symbol_1;
                                    try {
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_4);
                                        final /*@Thrown*/ boolean eq_0 = parentCallExpCS == null;
                                        /*@Thrown*/ boolean symbol_1;
                                        if (eq_0) {
                                            symbol_1 = ValueUtil.FALSE_VALUE;
                                        }
                                        else {
                                            if (parentCallExpCS == null) {
                                                throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                                            }
                                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
                                            final /*@Thrown*/ boolean eq_1 = lNameExpCS_4.equals(navExp);
                                            symbol_1 = eq_1;
                                        }
                                        CAUGHT_symbol_1 = symbol_1;
                                    }
                                    catch (Exception e) {
                                        CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
                                    }
                                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_1);
                                    CAUGHT_not = not;
                                }
                                catch (Exception e) {
                                    CAUGHT_not = ValueUtil.createInvalidValue(e);
                                }
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_not);
                                CAUGHT_and = and;
                            }
                            catch (Exception e) {
                                CAUGHT_and = ValueUtil.createInvalidValue(e);
                            }
                            /*@Caught*/ @NonNull Object CAUGHT_eq_2;
                            try {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName_0 = lNameExpCS_4.getExpName();
                                if (expName_0 == null) {
                                    throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
                                }
                                @SuppressWarnings("null")
                                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> pathElements = expName_0.getPathElements();
                                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
                                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
                                final /*@Thrown*/ boolean eq_2 = size.equals(INT_1);
                                CAUGHT_eq_2 = eq_2;
                            }
                            catch (Exception e) {
                                CAUGHT_eq_2 = ValueUtil.createInvalidValue(e);
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_0 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and, CAUGHT_eq_2);
                            CAUGHT_and_0 = and_0;
                        }
                        catch (Exception e) {
                            CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
                        }
                        /*@Caught*/ @NonNull Object CAUGHT_ne;
                        try {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Variable lookupVariableToDisambiguate = INST_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_4);
                            final /*@Thrown*/ boolean ne = lookupVariableToDisambiguate != null;
                            CAUGHT_ne = ne;
                        }
                        catch (Exception e) {
                            CAUGHT_ne = ValueUtil.createInvalidValue(e);
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_0, CAUGHT_ne);
                        CAUGHT_and_1 = and_1;
                    }
                    catch (Exception e) {
                        CAUGHT_and_1 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_1);
                    if (not_0 == null) {
                        throw throwNull(lNameExpCS_4, "Null if condition");
                    }
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_17;
                    if (not_0) {
                        /*@Caught*/ @Nullable Object CAUGHT_and_2;
                        try {
                            /*@Caught*/ @NonNull Object CAUGHT_eq_3;
                            try {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_4.getRoundedBrackets();
                                final /*@Thrown*/ boolean eq_3 = roundedBrackets_0 == null;
                                CAUGHT_eq_3 = eq_3;
                            }
                            catch (Exception e) {
                                CAUGHT_eq_3 = ValueUtil.createInvalidValue(e);
                            }
                            /*@Caught*/ @NonNull Object CAUGHT_symbol_2;
                            try {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS_0 = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_4);
                                final /*@Thrown*/ boolean eq_4 = parentCallExpCS_0 == null;
                                /*@Thrown*/ boolean symbol_2;
                                if (eq_4) {
                                    symbol_2 = ValueUtil.FALSE_VALUE;
                                }
                                else {
                                    if (parentCallExpCS_0 == null) {
                                        throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                                    }
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
                                    final /*@Thrown*/ boolean eq_5 = lNameExpCS_4.equals(navExp_0);
                                    symbol_2 = eq_5;
                                }
                                CAUGHT_symbol_2 = symbol_2;
                            }
                            catch (Exception e) {
                                CAUGHT_symbol_2 = ValueUtil.createInvalidValue(e);
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_3, CAUGHT_symbol_2);
                            CAUGHT_and_2 = and_2;
                        }
                        catch (Exception e) {
                            CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_1 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_2);
                        if (not_1 == null) {
                            throw throwNull(lNameExpCS_4, "Null if condition");
                        }
                        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_16;
                        if (not_1) {
                            /*@Caught*/ @NonNull Object CAUGHT_eq_6;
                            try {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets_1 = lNameExpCS_4.getRoundedBrackets();
                                final /*@Thrown*/ boolean eq_6 = roundedBrackets_1 == null;
                                CAUGHT_eq_6 = eq_6;
                            }
                            catch (Exception e) {
                                CAUGHT_eq_6 = ValueUtil.createInvalidValue(e);
                            }
                            /*@Caught*/ @Nullable Object CAUGHT_not_2;
                            try {
                                /*@Caught*/ @NonNull Object CAUGHT_symbol_3;
                                try {
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS_1 = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_4);
                                    final /*@Thrown*/ boolean eq_7 = parentCallExpCS_1 == null;
                                    /*@Thrown*/ boolean symbol_3;
                                    if (eq_7) {
                                        symbol_3 = ValueUtil.FALSE_VALUE;
                                    }
                                    else {
                                        if (parentCallExpCS_1 == null) {
                                            throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                                        }
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp_1 = parentCallExpCS_1.getNavExp();
                                        final /*@Thrown*/ boolean eq_8 = lNameExpCS_4.equals(navExp_1);
                                        symbol_3 = eq_8;
                                    }
                                    CAUGHT_symbol_3 = symbol_3;
                                }
                                catch (Exception e) {
                                    CAUGHT_symbol_3 = ValueUtil.createInvalidValue(e);
                                }
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_2 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_3);
                                CAUGHT_not_2 = not_2;
                            }
                            catch (Exception e) {
                                CAUGHT_not_2 = ValueUtil.createInvalidValue(e);
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_3 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_6, CAUGHT_not_2);
                            if (and_3 == null) {
                                throw throwNull(lNameExpCS_4, "Null if condition");
                            }
                            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_15;
                            if (and_3) {
                                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_PropertyCallExp_0 = idResolver.getClass(CLSSid_PropertyCallExp, null);
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull PropertyCallExp oclAsType = ClassUtil.nonNullState((PropertyCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_PropertyCallExp_0));
                                @SuppressWarnings("null")
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull OCLExpression ownedSource = oclAsType.getOwnedSource();
                                objectManager.getting(ownedSource, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, false);
                                @SuppressWarnings("null")
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class type = ownedSource.getType();
                                if (expName == null) {
                                    throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
                                }
                                @SuppressWarnings("null")
                                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = expName.getPathElements();
                                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
                                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
                                final /*@Thrown*/ boolean eq_9 = size_0.equals(INT_1);
                                /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Property symbol_12;
                                if (eq_9) {
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                                    if (aPathElementCS == null) {
                                        throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
                                    }
                                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pName_1 = aPathElementCS.getElementName();
                                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Class, type);
                                    final org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYPE_superClasses_1 = executor.getStaticTypeOf(oclAsSet);
                                    final LibraryIteration.@org.eclipse.jdt.annotation.NonNull LibraryIterationExtension IMPL_superClasses_1 = (LibraryIteration.LibraryIterationExtension)TYPE_superClasses_1.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
                                    final @NonNull Object ACC_superClasses_1 = IMPL_superClasses_1.createAccumulatorValue(executor, SET_CLSSid_Class, ORD_CLSSid_Class);
                                    /**
                                     * Implementation of the iterator body.
                                     */
                                    final @NonNull AbstractBinaryOperation BODY_superClasses_1 = new AbstractBinaryOperation()
                                    {
                                        /**
                                         * _'null' : OrderedSet(miniocl::Class)[*|1]
                                         */
                                        @Override
                                        public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object _1) {
                                            final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_4 = (org.eclipse.qvtd.doc.miniocl.Class)_1;
                                            if (symbol_4 == null) {
                                                throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/1.0\'::Class::superClasses\'");
                                            }
                                            @SuppressWarnings("null")
                                            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<org.eclipse.qvtd.doc.miniocl.Class> superClasses_0 = symbol_4.getSuperClasses();
                                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_superClasses_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_Class, superClasses_0);
                                            return BOXED_superClasses_0;
                                        }
                                    };
                                    final @NonNull  ExecutorSingleIterationManager MGR_superClasses_1 = new ExecutorSingleIterationManager(executor, SET_CLSSid_Class, BODY_superClasses_1, oclAsSet, ACC_superClasses_1);
                                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue superClasses = ClassUtil.nonNullState((SetValue)IMPL_superClasses_1.evaluateIteration(MGR_superClasses_1));
                                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
                                    final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment env_3 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
                                    @SuppressWarnings("null")
                                    final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ownedProperties = type.getOwnedProperties();
                                    @SuppressWarnings("null")
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = env_3.addElements(ownedProperties);
                                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundProperty = INST_Visitable__lookupProperty.evaluate(type, addElements, pName_1);
                                    final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundProperty).booleanValue();
                                    /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Property symbol_5;
                                    if (isEmpty) {
                                        symbol_5 = null;
                                    }
                                    else {
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Property first = (org.eclipse.qvtd.doc.miniocl.Property)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundProperty);
                                        symbol_5 = first;
                                    }
                                    symbol_12 = symbol_5;
                                }
                                else {
                                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_0, INT_1);
                                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
                                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size_2 = CollectionSizeOperation.INSTANCE.evaluate(qualifierSegments);
                                    final /*@Thrown*/ boolean eq_10 = size_2.equals(INT_1);
                                    /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_9;
                                    if (eq_10) {
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(qualifierSegments);
                                        if (aPathElementCS_0 == null) {
                                            throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
                                        }
                                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String cName_0 = aPathElementCS_0.getElementName();
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment unqualified_env_Class = INST_OclElement_unqualified_env_Class.evaluate(oclAsType);
                                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundClass = INST_Visitable__lookupClass.evaluate(oclAsType, unqualified_env_Class, cName_0);
                                        final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
                                        /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_6;
                                        if (isEmpty_0) {
                                            symbol_6 = null;
                                        }
                                        else {
                                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
                                            symbol_6 = first_0;
                                        }
                                        symbol_9 = symbol_6;
                                    }
                                    else {
                                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff_0 = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_2, INT_1);
                                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments_0 = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(qualifierSegments, INT_1, diff_0);
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package qualifier = INST_Visitable_lookupPackage.evaluate(oclAsType, qualifierSegments_0);
                                        /*@Caught*/ @Nullable Object CAUGHT_qualifier;
                                        try {
                                            CAUGHT_qualifier = qualifier;
                                        }
                                        catch (Exception e) {
                                            CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                                        }
                                        final /*@NonInvalid*/ @NonNull Object symbol_7 = CAUGHT_qualifier == null;
                                        /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
                                        if (symbol_7 == Boolean.TRUE) {
                                            safe_lookupQualifiedClass_source = null;
                                        }
                                        else {
                                            if (qualifier == null) {
                                                throw throwNull(lNameExpCS_4, "Null where non-null value required");
                                            }
                                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_1 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(qualifierSegments);
                                            if (aPathElementCS_1 == null) {
                                                throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
                                            }
                                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String cName_1 = aPathElementCS_1.getElementName();
                                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_lookup_c_c_LookupEnvironment_1 = idResolver.getClass(CLSSid_LookupEnvironment, null);
                                            final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment env_4 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_1.createInstance();
                                            @SuppressWarnings("null")
                                            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = qualifier.getOwnedClasses();
                                            @SuppressWarnings("null")
                                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements_0 = env_4.addElements(ownedClasses);
                                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundClass_0 = INST_Visitable__lookupClass.evaluate(qualifier, addElements_0, cName_1);
                                            final /*@Thrown*/ boolean isEmpty_1 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass_0).booleanValue();
                                            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_8;
                                            if (isEmpty_1) {
                                                symbol_8 = null;
                                            }
                                            else {
                                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class first_1 = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
                                                symbol_8 = first_1;
                                            }
                                            safe_lookupQualifiedClass_source = symbol_8;
                                        }
                                        symbol_9 = safe_lookupQualifiedClass_source;
                                    }
                                    /*@Caught*/ @Nullable Object CAUGHT_symbol_9;
                                    try {
                                        CAUGHT_symbol_9 = symbol_9;
                                    }
                                    catch (Exception e) {
                                        CAUGHT_symbol_9 = ValueUtil.createInvalidValue(e);
                                    }
                                    final /*@NonInvalid*/ @NonNull Object symbol_10 = CAUGHT_symbol_9 == null;
                                    /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Property safe_lookupQualifiedProperty_source;
                                    if (symbol_10 == Boolean.TRUE) {
                                        safe_lookupQualifiedProperty_source = null;
                                    }
                                    else {
                                        if (symbol_9 == null) {
                                            throw throwNull(lNameExpCS_4, "Null where non-null value required");
                                        }
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_2 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                                        if (aPathElementCS_2 == null) {
                                            throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
                                        }
                                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pName_2 = aPathElementCS_2.getElementName();
                                        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_lookup_c_c_LookupEnvironment_2 = idResolver.getClass(CLSSid_LookupEnvironment, null);
                                        final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment env_5 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_2.createInstance();
                                        @SuppressWarnings("null")
                                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ownedProperties_0 = symbol_9.getOwnedProperties();
                                        @SuppressWarnings("null")
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements_1 = env_5.addElements(ownedProperties_0);
                                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundProperty_0 = INST_Visitable__lookupProperty.evaluate(symbol_9, addElements_1, pName_2);
                                        final /*@Thrown*/ boolean isEmpty_2 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundProperty_0).booleanValue();
                                        /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Property symbol_11;
                                        if (isEmpty_2) {
                                            symbol_11 = null;
                                        }
                                        else {
                                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Property first_2 = (org.eclipse.qvtd.doc.miniocl.Property)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundProperty_0);
                                            symbol_11 = first_2;
                                        }
                                        safe_lookupQualifiedProperty_source = symbol_11;
                                    }
                                    symbol_12 = safe_lookupQualifiedProperty_source;
                                }
                                // mapping statements
                                if (symbol_12 == null) {
                                    throw throwNull(lNameExpCS_4, "Null value for miniocl::PropertyCallExp::referredProperty assignment");
                                }
                                oclAsType.setReferredProperty(symbol_12);
                                objectManager.assigned(oclAsType, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, symbol_12, null);
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_NameExpCS_ast_expName = ValueUtil.TRUE_VALUE;
                                symbol_15 = m_NameExpCS_ast_expName;
                            }
                            else {
                                symbol_15 = ValueUtil.FALSE_VALUE;
                            }
                            symbol_16 = symbol_15;
                        }
                        else {
                            symbol_16 = ValueUtil.FALSE_VALUE;
                        }
                        symbol_17 = symbol_16;
                    }
                    else {
                        symbol_17 = ValueUtil.FALSE_VALUE;
                    }
                    raw_ast = symbol_17;
                }
                else {
                    raw_ast = ValueUtil.FALSE_VALUE;
                }
                return raw_ast;
            } catch (Throwable e) {
                return handleExecutionFailure("MAP_m_NameExpCS_ast_expName", e);
            }
        }
        
        @Override
        public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
            return idResolver.oclEquals(lNameExpCS_4, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map m_NameExpCS_ast_expName_1 in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
     * var ast : miniocl::Element[1] := lNameExpCS.ast;
     * var expName : minioclcs::PathNameCS[?] := lNameExpCS.expName;
     * check lNameExpCS.isPropCallExpWithExplicitSource()
     *   ;
     * var aPropertyCallExp : miniocl::PropertyCallExp[1] := ast.oclAsType(miniocl::PropertyCallExp)
     *   ;
     * var ownedSource : miniocl::OCLExpression[1] := aPropertyCallExp.ownedSource;
     * var type : miniocl::Class[1] := ownedSource.type;
     * var lookupPropertyFrom : miniocl::Property[?] := aPropertyCallExp.lookupPropertyFrom(type, expName);
     * notify set aPropertyCallExp.referredProperty := lookupPropertyFrom;
     * 
     */
    protected class MAP_m_NameExpCS_ast_expName_1 extends AbstractInvocation
    {
        protected final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_5;
        
        public MAP_m_NameExpCS_ast_expName_1(@NonNull Object @NonNull [] boundValues) {
            lNameExpCS_5 = (NameExpCS)boundValues[0];
        }
        
        @Override
        public boolean execute()  {
            try {
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lNameExpCS_5.getAst();
                final /*@Thrown*/ boolean symbol_0 = ast != null;
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                if (symbol_0) {
                    if (ast == null) {
                        throw throwNull(lNameExpCS_5, "Null where non-null value required");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName = lNameExpCS_5.getExpName();
                    /*@Caught*/ @NonNull Object CAUGHT_eq;
                    try {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_5.getRoundedBrackets();
                        final /*@Thrown*/ boolean eq = roundedBrackets == null;
                        CAUGHT_eq = eq;
                    }
                    catch (Exception e) {
                        CAUGHT_eq = ValueUtil.createInvalidValue(e);
                    }
                    /*@Caught*/ @NonNull Object CAUGHT_symbol_1;
                    try {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_5);
                        final /*@Thrown*/ boolean eq_0 = parentCallExpCS == null;
                        /*@Thrown*/ boolean symbol_1;
                        if (eq_0) {
                            symbol_1 = ValueUtil.FALSE_VALUE;
                        }
                        else {
                            if (parentCallExpCS == null) {
                                throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                            }
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
                            final /*@Thrown*/ boolean eq_1 = lNameExpCS_5.equals(navExp);
                            symbol_1 = eq_1;
                        }
                        CAUGHT_symbol_1 = symbol_1;
                    }
                    catch (Exception e) {
                        CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_1);
                    if (and == null) {
                        throw throwNull(lNameExpCS_5, "Null if condition");
                    }
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_13;
                    if (and) {
                        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_PropertyCallExp_0 = idResolver.getClass(CLSSid_PropertyCallExp, null);
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull PropertyCallExp oclAsType = ClassUtil.nonNullState((PropertyCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_PropertyCallExp_0));
                        @SuppressWarnings("null")
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull OCLExpression ownedSource = oclAsType.getOwnedSource();
                        objectManager.getting(ownedSource, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, false);
                        @SuppressWarnings("null")
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class type = ownedSource.getType();
                        if (expName == null) {
                            throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
                        }
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = expName.getPathElements();
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
                        final /*@Thrown*/ boolean eq_2 = size.equals(INT_1);
                        /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Property symbol_10;
                        if (eq_2) {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                            if (aPathElementCS == null) {
                                throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pName_1 = aPathElementCS.getElementName();
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Class, type);
                            final org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYPE_superClasses_1 = executor.getStaticTypeOf(oclAsSet);
                            final LibraryIteration.@org.eclipse.jdt.annotation.NonNull LibraryIterationExtension IMPL_superClasses_1 = (LibraryIteration.LibraryIterationExtension)TYPE_superClasses_1.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
                            final @NonNull Object ACC_superClasses_1 = IMPL_superClasses_1.createAccumulatorValue(executor, SET_CLSSid_Class, ORD_CLSSid_Class);
                            /**
                             * Implementation of the iterator body.
                             */
                            final @NonNull AbstractBinaryOperation BODY_superClasses_1 = new AbstractBinaryOperation()
                            {
                                /**
                                 * _'null' : OrderedSet(miniocl::Class)[*|1]
                                 */
                                @Override
                                public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object _1) {
                                    final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_2 = (org.eclipse.qvtd.doc.miniocl.Class)_1;
                                    if (symbol_2 == null) {
                                        throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/1.0\'::Class::superClasses\'");
                                    }
                                    @SuppressWarnings("null")
                                    final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<org.eclipse.qvtd.doc.miniocl.Class> superClasses_0 = symbol_2.getSuperClasses();
                                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_superClasses_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_Class, superClasses_0);
                                    return BOXED_superClasses_0;
                                }
                            };
                            final @NonNull  ExecutorSingleIterationManager MGR_superClasses_1 = new ExecutorSingleIterationManager(executor, SET_CLSSid_Class, BODY_superClasses_1, oclAsSet, ACC_superClasses_1);
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue superClasses = ClassUtil.nonNullState((SetValue)IMPL_superClasses_1.evaluateIteration(MGR_superClasses_1));
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
                            final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment env_3 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
                            @SuppressWarnings("null")
                            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ownedProperties = type.getOwnedProperties();
                            @SuppressWarnings("null")
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = env_3.addElements(ownedProperties);
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundProperty = INST_Visitable__lookupProperty.evaluate(type, addElements, pName_1);
                            final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundProperty).booleanValue();
                            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Property symbol_3;
                            if (isEmpty) {
                                symbol_3 = null;
                            }
                            else {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Property first = (org.eclipse.qvtd.doc.miniocl.Property)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundProperty);
                                symbol_3 = first;
                            }
                            symbol_10 = symbol_3;
                        }
                        else {
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size_1 = CollectionSizeOperation.INSTANCE.evaluate(qualifierSegments);
                            final /*@Thrown*/ boolean eq_3 = size_1.equals(INT_1);
                            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_7;
                            if (eq_3) {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(qualifierSegments);
                                if (aPathElementCS_0 == null) {
                                    throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
                                }
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String cName_0 = aPathElementCS_0.getElementName();
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment unqualified_env_Class = INST_OclElement_unqualified_env_Class.evaluate(oclAsType);
                                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundClass = INST_Visitable__lookupClass.evaluate(oclAsType, unqualified_env_Class, cName_0);
                                final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
                                /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_4;
                                if (isEmpty_0) {
                                    symbol_4 = null;
                                }
                                else {
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
                                    symbol_4 = first_0;
                                }
                                symbol_7 = symbol_4;
                            }
                            else {
                                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff_0 = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_1, INT_1);
                                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments_0 = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(qualifierSegments, INT_1, diff_0);
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package qualifier = INST_Visitable_lookupPackage.evaluate(oclAsType, qualifierSegments_0);
                                /*@Caught*/ @Nullable Object CAUGHT_qualifier;
                                try {
                                    CAUGHT_qualifier = qualifier;
                                }
                                catch (Exception e) {
                                    CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                                }
                                final /*@NonInvalid*/ @NonNull Object symbol_5 = CAUGHT_qualifier == null;
                                /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
                                if (symbol_5 == Boolean.TRUE) {
                                    safe_lookupQualifiedClass_source = null;
                                }
                                else {
                                    if (qualifier == null) {
                                        throw throwNull(lNameExpCS_5, "Null where non-null value required");
                                    }
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_1 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(qualifierSegments);
                                    if (aPathElementCS_1 == null) {
                                        throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
                                    }
                                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String cName_1 = aPathElementCS_1.getElementName();
                                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_lookup_c_c_LookupEnvironment_1 = idResolver.getClass(CLSSid_LookupEnvironment, null);
                                    final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment env_4 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_1.createInstance();
                                    @SuppressWarnings("null")
                                    final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = qualifier.getOwnedClasses();
                                    @SuppressWarnings("null")
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements_0 = env_4.addElements(ownedClasses);
                                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundClass_0 = INST_Visitable__lookupClass.evaluate(qualifier, addElements_0, cName_1);
                                    final /*@Thrown*/ boolean isEmpty_1 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass_0).booleanValue();
                                    /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_6;
                                    if (isEmpty_1) {
                                        symbol_6 = null;
                                    }
                                    else {
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class first_1 = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
                                        symbol_6 = first_1;
                                    }
                                    safe_lookupQualifiedClass_source = symbol_6;
                                }
                                symbol_7 = safe_lookupQualifiedClass_source;
                            }
                            /*@Caught*/ @Nullable Object CAUGHT_symbol_7;
                            try {
                                CAUGHT_symbol_7 = symbol_7;
                            }
                            catch (Exception e) {
                                CAUGHT_symbol_7 = ValueUtil.createInvalidValue(e);
                            }
                            final /*@NonInvalid*/ @NonNull Object symbol_8 = CAUGHT_symbol_7 == null;
                            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Property safe_lookupQualifiedProperty_source;
                            if (symbol_8 == Boolean.TRUE) {
                                safe_lookupQualifiedProperty_source = null;
                            }
                            else {
                                if (symbol_7 == null) {
                                    throw throwNull(lNameExpCS_5, "Null where non-null value required");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_2 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                                if (aPathElementCS_2 == null) {
                                    throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
                                }
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pName_2 = aPathElementCS_2.getElementName();
                                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_lookup_c_c_LookupEnvironment_2 = idResolver.getClass(CLSSid_LookupEnvironment, null);
                                final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment env_5 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_2.createInstance();
                                @SuppressWarnings("null")
                                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ownedProperties_0 = symbol_7.getOwnedProperties();
                                @SuppressWarnings("null")
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements_1 = env_5.addElements(ownedProperties_0);
                                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundProperty_0 = INST_Visitable__lookupProperty.evaluate(symbol_7, addElements_1, pName_2);
                                final /*@Thrown*/ boolean isEmpty_2 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundProperty_0).booleanValue();
                                /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Property symbol_9;
                                if (isEmpty_2) {
                                    symbol_9 = null;
                                }
                                else {
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Property first_2 = (org.eclipse.qvtd.doc.miniocl.Property)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundProperty_0);
                                    symbol_9 = first_2;
                                }
                                safe_lookupQualifiedProperty_source = symbol_9;
                            }
                            symbol_10 = safe_lookupQualifiedProperty_source;
                        }
                        // mapping statements
                        if (symbol_10 == null) {
                            throw throwNull(lNameExpCS_5, "Null value for miniocl::PropertyCallExp::referredProperty assignment");
                        }
                        oclAsType.setReferredProperty(symbol_10);
                        objectManager.assigned(oclAsType, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, symbol_10, null);
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_NameExpCS_ast_expName_1 = ValueUtil.TRUE_VALUE;
                        symbol_13 = m_NameExpCS_ast_expName_1;
                    }
                    else {
                        symbol_13 = ValueUtil.FALSE_VALUE;
                    }
                    raw_ast = symbol_13;
                }
                else {
                    raw_ast = ValueUtil.FALSE_VALUE;
                }
                return raw_ast;
            } catch (Throwable e) {
                return handleExecutionFailure("MAP_m_NameExpCS_ast_expName_1", e);
            }
        }
        
        @Override
        public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
            return idResolver.oclEquals(lNameExpCS_5, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map m_NameExpCS_ast_expName_2 in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
     * var ast : miniocl::Element[1] := lNameExpCS.ast;
     * var expName : minioclcs::PathNameCS[?] := lNameExpCS.expName;
     * check lNameExpCS.isVariableExp()
     *   ;
     * check not lNameExpCS.isPropCallExpWithExplicitSource()
     *   ;
     * var aVariableExp : miniocl::VariableExp[1] := ast.oclAsType(miniocl::VariableExp)
     *   ;
     * var pathElements : OrderedSet(minioclcs::PathElementCS)[*|1] := expName.pathElements;
     * var first : minioclcs::PathElementCS[?] := pathElements->first()
     *   ;
     * var lookupVariable : miniocl::Variable[?] := aVariableExp.lookupVariable(first);
     * set aVariableExp.referredVariable := lookupVariable;
     * 
     */
    protected boolean MAP_m_NameExpCS_ast_expName_2(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_6)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lNameExpCS_6.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
            if (symbol_0) {
                if (ast == null) {
                    throw throwNull(lNameExpCS_6, "Null where non-null value required");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName = lNameExpCS_6.getExpName();
                /*@Caught*/ @Nullable Object CAUGHT_and_0;
                try {
                    /*@Caught*/ @Nullable Object CAUGHT_and;
                    try {
                        /*@Caught*/ @NonNull Object CAUGHT_eq;
                        try {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_6.getRoundedBrackets();
                            final /*@Thrown*/ boolean eq = roundedBrackets == null;
                            CAUGHT_eq = eq;
                        }
                        catch (Exception e) {
                            CAUGHT_eq = ValueUtil.createInvalidValue(e);
                        }
                        /*@Caught*/ @Nullable Object CAUGHT_not;
                        try {
                            /*@Caught*/ @NonNull Object CAUGHT_symbol_1;
                            try {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_6);
                                final /*@Thrown*/ boolean eq_0 = parentCallExpCS == null;
                                /*@Thrown*/ boolean symbol_1;
                                if (eq_0) {
                                    symbol_1 = ValueUtil.FALSE_VALUE;
                                }
                                else {
                                    if (parentCallExpCS == null) {
                                        throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                                    }
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
                                    final /*@Thrown*/ boolean eq_1 = lNameExpCS_6.equals(navExp);
                                    symbol_1 = eq_1;
                                }
                                CAUGHT_symbol_1 = symbol_1;
                            }
                            catch (Exception e) {
                                CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_1);
                            CAUGHT_not = not;
                        }
                        catch (Exception e) {
                            CAUGHT_not = ValueUtil.createInvalidValue(e);
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_not);
                        CAUGHT_and = and;
                    }
                    catch (Exception e) {
                        CAUGHT_and = ValueUtil.createInvalidValue(e);
                    }
                    /*@Caught*/ @NonNull Object CAUGHT_eq_2;
                    try {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName_0 = lNameExpCS_6.getExpName();
                        if (expName_0 == null) {
                            throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
                        }
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> pathElements = expName_0.getPathElements();
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
                        final /*@Thrown*/ boolean eq_2 = size.equals(INT_1);
                        CAUGHT_eq_2 = eq_2;
                    }
                    catch (Exception e) {
                        CAUGHT_eq_2 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_0 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and, CAUGHT_eq_2);
                    CAUGHT_and_0 = and_0;
                }
                catch (Exception e) {
                    CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
                }
                /*@Caught*/ @NonNull Object CAUGHT_ne;
                try {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Variable lookupVariableToDisambiguate = INST_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_6);
                    final /*@Thrown*/ boolean ne = lookupVariableToDisambiguate != null;
                    CAUGHT_ne = ne;
                }
                catch (Exception e) {
                    CAUGHT_ne = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_0, CAUGHT_ne);
                if (and_1 == null) {
                    throw throwNull(lNameExpCS_6, "Null if condition");
                }
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_7;
                if (and_1) {
                    /*@Caught*/ @Nullable Object CAUGHT_and_2;
                    try {
                        /*@Caught*/ @NonNull Object CAUGHT_eq_3;
                        try {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_6.getRoundedBrackets();
                            final /*@Thrown*/ boolean eq_3 = roundedBrackets_0 == null;
                            CAUGHT_eq_3 = eq_3;
                        }
                        catch (Exception e) {
                            CAUGHT_eq_3 = ValueUtil.createInvalidValue(e);
                        }
                        /*@Caught*/ @NonNull Object CAUGHT_symbol_2;
                        try {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS_0 = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_6);
                            final /*@Thrown*/ boolean eq_4 = parentCallExpCS_0 == null;
                            /*@Thrown*/ boolean symbol_2;
                            if (eq_4) {
                                symbol_2 = ValueUtil.FALSE_VALUE;
                            }
                            else {
                                if (parentCallExpCS_0 == null) {
                                    throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
                                final /*@Thrown*/ boolean eq_5 = lNameExpCS_6.equals(navExp_0);
                                symbol_2 = eq_5;
                            }
                            CAUGHT_symbol_2 = symbol_2;
                        }
                        catch (Exception e) {
                            CAUGHT_symbol_2 = ValueUtil.createInvalidValue(e);
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_3, CAUGHT_symbol_2);
                        CAUGHT_and_2 = and_2;
                    }
                    catch (Exception e) {
                        CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_2);
                    if (not_0 == null) {
                        throw throwNull(lNameExpCS_6, "Null if condition");
                    }
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_6;
                    if (not_0) {
                        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_VariableExp_0 = idResolver.getClass(CLSSid_VariableExp, null);
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull VariableExp oclAsType = ClassUtil.nonNullState((VariableExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_VariableExp_0));
                        if (expName == null) {
                            throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
                        }
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> pathElements_0 = expName.getPathElements();
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_pathElements_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements_0);
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS first = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_pathElements_0);
                        if (first == null) {
                            throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String vName_0 = first.getElementName();
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment unqualified_env_Variable = INST_OclElement_unqualified_env_Variable.evaluate(oclAsType);
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundVariable = INST_Visitable__lookupVariable.evaluate(oclAsType, unqualified_env_Variable, vName_0);
                        final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundVariable).booleanValue();
                        /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Variable symbol_3;
                        if (isEmpty) {
                            symbol_3 = null;
                        }
                        else {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Variable first_0 = (Variable)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundVariable);
                            symbol_3 = first_0;
                        }
                        // mapping statements
                        if (symbol_3 == null) {
                            throw throwNull(lNameExpCS_6, "Null value for miniocl::VariableExp::referredVariable assignment");
                        }
                        oclAsType.setReferredVariable(symbol_3);
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_NameExpCS_ast_expName_2 = ValueUtil.TRUE_VALUE;
                        symbol_6 = m_NameExpCS_ast_expName_2;
                    }
                    else {
                        symbol_6 = ValueUtil.FALSE_VALUE;
                    }
                    symbol_7 = symbol_6;
                }
                else {
                    symbol_7 = ValueUtil.FALSE_VALUE;
                }
                raw_ast = symbol_7;
            }
            else {
                raw_ast = ValueUtil.FALSE_VALUE;
            }
            return raw_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_NameExpCS_ast_expName_2", e);
        }
    }
    
    /**
     * 
     * map m_NavigationExpCS_ast0 in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lNavigationExpCS  : minioclcs::NavigationExpCS[1];
     * check lNavigationExpCS.oclIsTypeOf(minioclcs::NavigationExpCS);
     * set lNavigationExpCS.ast := null;
     * 
     */
    protected boolean MAP_m_NavigationExpCS_ast0(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NavigationExpCS lNavigationExpCS)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_NavigationExpCS_0_0 = idResolver.getClass(CLSSid_NavigationExpCS, null);
            final /*@NonInvalid*/ boolean oclIsTypeOf = OclAnyOclIsTypeOfOperation.INSTANCE.evaluate(executor, lNavigationExpCS, TYP_minioclcs_c_c_NavigationExpCS_0_0).booleanValue();
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_2;
            if (oclIsTypeOf) {
                // mapping statements
                lNavigationExpCS.setAst(null);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_NavigationExpCS_ast0 = ValueUtil.TRUE_VALUE;
                symbol_2 = m_NavigationExpCS_ast0;
            }
            else {
                symbol_2 = ValueUtil.FALSE_VALUE;
            }
            return symbol_2;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_NavigationExpCS_ast0", e);
        }
    }
    
    /**
     * 
     * map m_OperationCS_ast_body in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lOperationCS  : minioclcs::OperationCS[1];
     * var ast : miniocl::Element[1] := lOperationCS.ast;
     * var body : minioclcs::ExpCS[?] := lOperationCS.body;
     * var aOperation : miniocl::Operation[1] := ast.oclAsType(miniocl::Operation)
     *   ;
     * var ast1 : miniocl::Element[1] := body.ast;
     * var aOCLExpression : miniocl::OCLExpression[1] := ast1.oclAsType(miniocl::OCLExpression)
     *   ;
     * var owningClass : miniocl::Class[?] := aOperation.owningClass;
     * var Variable : miniocl::Variable[1] := miniocl::Variable{name = 'self', type = owningClass
     *   }
     *   ;
     * var type : miniocl::Class[1] := aOCLExpression.type;
     * var ExpressionInOCL : miniocl::ExpressionInOCL[1] := miniocl::ExpressionInOCL{language = 'OCL', ownedBody = aOCLExpression, ownedSelfVar = Variable, type = type
     *   };
     * set aOperation.ownedBodyExpression := ExpressionInOCL;
     * 
     */
    protected boolean MAP_m_OperationCS_ast_body(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS lOperationCS)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lOperationCS.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
            if (symbol_0) {
                if (ast == null) {
                    throw throwNull(lOperationCS, "Null where non-null value required");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable ExpCS body = lOperationCS.getBody();
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Operation oclAsType = ClassUtil.nonNullState((Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Operation_0));
                if (body == null) {
                    throw throwNull(lOperationCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CSTrace::ast\'");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast_0 = body.getAst();
                final /*@Thrown*/ boolean symbol_1 = ast_0 != null;
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast1;
                if (symbol_1) {
                    if (ast_0 == null) {
                        throw throwNull(lOperationCS, "Null where non-null value required");
                    }
                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_OCLExpression_0 = idResolver.getClass(CLSSid_OCLExpression, null);
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull OCLExpression oclAsType_0 = ClassUtil.nonNullState((OCLExpression)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_miniocl_c_c_OCLExpression_0));
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class owningClass = oclAsType.getOwningClass();
                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property CTORid_name = idResolver.getProperty(PROPid_name);
                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property CTORid_type = idResolver.getProperty(PROPid_type);
                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Variable_0 = idResolver.getClass(CLSSid_Variable, null);
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Variable symbol_4 = (Variable)TYP_miniocl_c_c_Variable_0.createInstance();
                    CTORid_name.initValue(symbol_4, STR_self);
                    CTORid_type.initValue(symbol_4, owningClass);
                    @SuppressWarnings("null")
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class type = oclAsType_0.getType();
                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property CTORid_language = idResolver.getProperty(PROPid_language);
                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property CTORid_ownedBody = idResolver.getProperty(PROPid_ownedBody);
                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property CTORid_ownedSelfVar = idResolver.getProperty(PROPid_ownedSelfVar);
                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_ExpressionInOCL_0 = idResolver.getClass(CLSSid_ExpressionInOCL, null);
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull ExpressionInOCL symbol_9 = (ExpressionInOCL)TYP_miniocl_c_c_ExpressionInOCL_0.createInstance();
                    CTORid_language.initValue(symbol_9, STR_OCL);
                    CTORid_ownedBody.initValue(symbol_9, oclAsType_0);
                    CTORid_ownedSelfVar.initValue(symbol_9, symbol_4);
                    CTORid_type.initValue(symbol_9, type);
                    // mapping statements
                    oclAsType.setOwnedBodyExpression(symbol_9);
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_OperationCS_ast_body = ValueUtil.TRUE_VALUE;
                    raw_ast1 = m_OperationCS_ast_body;
                }
                else {
                    raw_ast1 = ValueUtil.FALSE_VALUE;
                }
                raw_ast = raw_ast1;
            }
            else {
                raw_ast = ValueUtil.FALSE_VALUE;
            }
            return raw_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_OperationCS_ast_body", e);
        }
    }
    
    /**
     * 
     * map m_OperationCS_ast_name in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lOperationCS  : minioclcs::OperationCS[1];
     * var ast : miniocl::Element[1] := lOperationCS.ast;
     * var name : ecore::EString[?] := lOperationCS.name;
     * var aOperation : miniocl::Operation[1] := ast.oclAsType(miniocl::Operation)
     *   ;
     * set aOperation.name := name.toString();
     * 
     */
    protected boolean MAP_m_OperationCS_ast_name(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS lOperationCS_0)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lOperationCS_0.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
            if (symbol_0) {
                if (ast == null) {
                    throw throwNull(lOperationCS_0, "Null where non-null value required");
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = lOperationCS_0.getName();
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Operation oclAsType = ClassUtil.nonNullState((Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Operation_0));
                // mapping statements
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
                oclAsType.setName(toString);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_OperationCS_ast_name = ValueUtil.TRUE_VALUE;
                raw_ast = m_OperationCS_ast_name;
            }
            else {
                raw_ast = ValueUtil.FALSE_VALUE;
            }
            return raw_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_OperationCS_ast_name", e);
        }
    }
    
    /**
     * 
     * map m_OperationCS_ast_params in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lOperationCS  : minioclcs::OperationCS[1];
     * var ast : miniocl::Element[1] := lOperationCS.ast;
     * var params : OrderedSet(minioclcs::ParameterCS)[*|1] := lOperationCS.params;
     * var aOperation : miniocl::Operation[1] := ast.oclAsType(miniocl::Operation)
     *   ;
     * var _'\u00ABcollect\u00BB' : Sequence(miniocl::Parameter)[*|1] := params->collect(_'1_' |
     *     _'1_'.ast.oclAsType(miniocl::Parameter))
     *   ;
     * var asOrderedSet : OrderedSet(miniocl::Parameter)[*|1] := _'\u00ABcollect\u00BB'->asOrderedSet();
     * set aOperation.ownedParameters := asOrderedSet;
     * 
     */
    protected boolean MAP_m_OperationCS_ast_params(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS lOperationCS_1)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lOperationCS_1.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
            if (symbol_0) {
                if (ast == null) {
                    throw throwNull(lOperationCS_1, "Null where non-null value required");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<ParameterCS> params = lOperationCS_1.getParams();
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Operation oclAsType = ClassUtil.nonNullState((Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Operation_0));
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_params = idResolver.createOrderedSetOfAll(ORD_CLSSid_ParameterCS, params);
                /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Parameter);
                @NonNull Iterator<Object> ITERATOR__1 = BOXED_params.iterator();
                /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
                while (true) {
                    if (!ITERATOR__1.hasNext()) {
                        collect = accumulator;
                        break;
                    }
                    @SuppressWarnings("null")
                    /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ParameterCS _1 = (ParameterCS)ITERATOR__1.next();
                    /**
                     * _'1_'.ast.oclAsType(miniocl::Parameter)
                     */
                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Parameter_0 = idResolver.getClass(CLSSid_Parameter, null);
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast_0 = _1.getAst();
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Parameter oclAsType_0 = ClassUtil.nonNullState((Parameter)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_miniocl_c_c_Parameter_0));
                    //
                    accumulator.add(oclAsType_0);
                }
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
                // mapping statements
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Parameter> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Parameter.class, asOrderedSet);
                oclAsType.getOwnedParameters().addAll(ECORE_asOrderedSet);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_OperationCS_ast_params = ValueUtil.TRUE_VALUE;
                raw_ast = m_OperationCS_ast_params;
            }
            else {
                raw_ast = ValueUtil.FALSE_VALUE;
            }
            return raw_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_OperationCS_ast_params", e);
        }
    }
    
    /**
     * 
     * map m_OperationCS_ast_resultRef in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lOperationCS  : minioclcs::OperationCS[1];
     * var ast : miniocl::Element[1] := lOperationCS.ast;
     * var resultRef : minioclcs::PathNameCS[?] := lOperationCS.resultRef;
     * var aOperation : miniocl::Operation[1] := ast.oclAsType(miniocl::Operation)
     *   ;
     * var lookupClass : miniocl::Class[?] := aOperation.lookupClass(resultRef);
     * set aOperation.type := lookupClass;
     * 
     */
    protected boolean MAP_m_OperationCS_ast_resultRef(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS lOperationCS_2)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lOperationCS_2.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
            if (symbol_0) {
                if (ast == null) {
                    throw throwNull(lOperationCS_2, "Null where non-null value required");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS resultRef = lOperationCS_2.getResultRef();
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Operation oclAsType = ClassUtil.nonNullState((Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Operation_0));
                if (resultRef == null) {
                    throw throwNull(lOperationCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = resultRef.getPathElements();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
                final /*@Thrown*/ boolean eq = size.equals(INT_1);
                /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_4;
                if (eq) {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                    if (aPathElementCS == null) {
                        throw throwNull(lOperationCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String cName_0 = aPathElementCS.getElementName();
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment unqualified_env_Class = INST_OclElement_unqualified_env_Class.evaluate(oclAsType);
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundClass = INST_Visitable__lookupClass.evaluate(oclAsType, unqualified_env_Class, cName_0);
                    final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
                    /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_1;
                    if (isEmpty) {
                        symbol_1 = null;
                    }
                    else {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class first = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
                        symbol_1 = first;
                    }
                    symbol_4 = symbol_1;
                }
                else {
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package qualifier = INST_Visitable_lookupPackage.evaluate(oclAsType, qualifierSegments);
                    /*@Caught*/ @Nullable Object CAUGHT_qualifier;
                    try {
                        CAUGHT_qualifier = qualifier;
                    }
                    catch (Exception e) {
                        CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                    }
                    final /*@NonInvalid*/ @NonNull Object symbol_2 = CAUGHT_qualifier == null;
                    /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
                    if (symbol_2 == Boolean.TRUE) {
                        safe_lookupQualifiedClass_source = null;
                    }
                    else {
                        if (qualifier == null) {
                            throw throwNull(lOperationCS_2, "Null where non-null value required");
                        }
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                        if (aPathElementCS_0 == null) {
                            throw throwNull(lOperationCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String cName_1 = aPathElementCS_0.getElementName();
                        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
                        final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment env_3 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = qualifier.getOwnedClasses();
                        @SuppressWarnings("null")
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = env_3.addElements(ownedClasses);
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundClass_0 = INST_Visitable__lookupClass.evaluate(qualifier, addElements, cName_1);
                        final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass_0).booleanValue();
                        /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_3;
                        if (isEmpty_0) {
                            symbol_3 = null;
                        }
                        else {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
                            symbol_3 = first_0;
                        }
                        safe_lookupQualifiedClass_source = symbol_3;
                    }
                    symbol_4 = safe_lookupQualifiedClass_source;
                }
                // mapping statements
                if (symbol_4 == null) {
                    throw throwNull(lOperationCS_2, "Null value for miniocl::TypedElement::type assignment");
                }
                oclAsType.setType(symbol_4);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_OperationCS_ast_resultRef = ValueUtil.TRUE_VALUE;
                raw_ast = m_OperationCS_ast_resultRef;
            }
            else {
                raw_ast = ValueUtil.FALSE_VALUE;
            }
            return raw_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_OperationCS_ast_resultRef", e);
        }
    }
    
    /**
     * 
     * map m_Operation_OperationCS in MiniOCLCS2AS_qvtp_qvtcas {
     * guard:leftCS lOperationCS  : minioclcs::OperationCS[1];
     * new:rightAS rOperation : miniocl::Operation[1];
     * set lOperationCS.ast := rOperation;
     * 
     */
    protected boolean MAP_m_Operation_OperationCS(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS lOperationCS_3)  {
        try {
            // creations
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Operation rOperation = MiniOCLFactory.eINSTANCE.createOperation();
            assert rOperation != null;
            models[1/*rightAS*/].add(rOperation);
            // mapping statements
            lOperationCS_3.setAst(rOperation);
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Operation_OperationCS = ValueUtil.TRUE_VALUE;
            return m_Operation_OperationCS;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_Operation_OperationCS", e);
        }
    }
    
    /**
     * 
     * map m_PackageCS_ast_classes in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lPackageCS  : minioclcs::PackageCS[1];
     * var ast : miniocl::Element[1] := lPackageCS.ast;
     * var classes : OrderedSet(minioclcs::ClassCS)[*|1] := lPackageCS.classes;
     * var aPackage : miniocl::Package[1] := ast.oclAsType(miniocl::Package)
     *   ;
     * var _'\u00ABcollect\u00BB' : Sequence(miniocl::Class)[*|1] := classes->collect(_'1_' |
     *     _'1_'.ast.oclAsType(miniocl::Class))
     *   ;
     * var asOrderedSet : OrderedSet(miniocl::Class)[*|1] := _'\u00ABcollect\u00BB'->asOrderedSet();
     * set aPackage.ownedClasses := asOrderedSet;
     * 
     */
    protected boolean MAP_m_PackageCS_ast_classes(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PackageCS lPackageCS)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lPackageCS.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
            if (symbol_0) {
                if (ast == null) {
                    throw throwNull(lPackageCS, "Null where non-null value required");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<ClassCS> classes = lPackageCS.getClasses();
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Package oclAsType = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Package_0));
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_classes = idResolver.createOrderedSetOfAll(ORD_CLSSid_ClassCS, classes);
                /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Class);
                @NonNull Iterator<Object> ITERATOR__1 = BOXED_classes.iterator();
                /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
                while (true) {
                    if (!ITERATOR__1.hasNext()) {
                        collect = accumulator;
                        break;
                    }
                    @SuppressWarnings("null")
                    /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ClassCS _1 = (ClassCS)ITERATOR__1.next();
                    /**
                     * _'1_'.ast.oclAsType(miniocl::Class)
                     */
                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Class_0 = idResolver.getClass(CLSSid_Class_0, null);
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast_0 = _1.getAst();
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class oclAsType_0 = ClassUtil.nonNullState((org.eclipse.qvtd.doc.miniocl.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_miniocl_c_c_Class_0));
                    //
                    accumulator.add(oclAsType_0);
                }
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
                // mapping statements
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.qvtd.doc.miniocl.Class.class, asOrderedSet);
                oclAsType.getOwnedClasses().addAll(ECORE_asOrderedSet);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_PackageCS_ast_classes = ValueUtil.TRUE_VALUE;
                raw_ast = m_PackageCS_ast_classes;
            }
            else {
                raw_ast = ValueUtil.FALSE_VALUE;
            }
            return raw_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_PackageCS_ast_classes", e);
        }
    }
    
    /**
     * 
     * map m_PackageCS_ast_name in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lPackageCS  : minioclcs::PackageCS[1];
     * var ast : miniocl::Element[1] := lPackageCS.ast;
     * var name : ecore::EString[?] := lPackageCS.name;
     * var aPackage : miniocl::Package[1] := ast.oclAsType(miniocl::Package)
     *   ;
     * set aPackage.name := name.toString();
     * 
     */
    protected boolean MAP_m_PackageCS_ast_name(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PackageCS lPackageCS_0)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lPackageCS_0.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
            if (symbol_0) {
                if (ast == null) {
                    throw throwNull(lPackageCS_0, "Null where non-null value required");
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = lPackageCS_0.getName();
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Package oclAsType = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Package_0));
                // mapping statements
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
                oclAsType.setName(toString);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_PackageCS_ast_name = ValueUtil.TRUE_VALUE;
                raw_ast = m_PackageCS_ast_name;
            }
            else {
                raw_ast = ValueUtil.FALSE_VALUE;
            }
            return raw_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_PackageCS_ast_name", e);
        }
    }
    
    /**
     * 
     * map m_PackageCS_ast_packages in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lPackageCS  : minioclcs::PackageCS[1];
     * var ast : miniocl::Element[1] := lPackageCS.ast;
     * var packages : OrderedSet(minioclcs::PackageCS)[*|1] := lPackageCS.packages;
     * var aPackage : miniocl::Package[1] := ast.oclAsType(miniocl::Package)
     *   ;
     * var _'\u00ABcollect\u00BB' : Sequence(miniocl::Package)[*|1] := packages->collect(_'1_' |
     *     _'1_'.ast.oclAsType(miniocl::Package))
     *   ;
     * var asOrderedSet : OrderedSet(miniocl::Package)[*|1] := _'\u00ABcollect\u00BB'->asOrderedSet();
     * set aPackage.ownedPackages := asOrderedSet;
     * 
     */
    protected boolean MAP_m_PackageCS_ast_packages(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PackageCS lPackageCS_1)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lPackageCS_1.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
            if (symbol_0) {
                if (ast == null) {
                    throw throwNull(lPackageCS_1, "Null where non-null value required");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PackageCS> packages = lPackageCS_1.getPackages();
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Package oclAsType = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Package_0));
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_packages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, packages);
                /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
                @NonNull Iterator<Object> ITERATOR__1 = BOXED_packages.iterator();
                /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
                while (true) {
                    if (!ITERATOR__1.hasNext()) {
                        collect = accumulator;
                        break;
                    }
                    @SuppressWarnings("null")
                    /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PackageCS _1 = (PackageCS)ITERATOR__1.next();
                    /**
                     * _'1_'.ast.oclAsType(miniocl::Package)
                     */
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast_0 = _1.getAst();
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Package oclAsType_0 = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_miniocl_c_c_Package_0));
                    //
                    accumulator.add(oclAsType_0);
                }
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
                // mapping statements
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Package> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, asOrderedSet);
                oclAsType.getOwnedPackages().addAll(ECORE_asOrderedSet);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_PackageCS_ast_packages = ValueUtil.TRUE_VALUE;
                raw_ast = m_PackageCS_ast_packages;
            }
            else {
                raw_ast = ValueUtil.FALSE_VALUE;
            }
            return raw_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_PackageCS_ast_packages", e);
        }
    }
    
    /**
     * 
     * map m_Package_PackageCS in MiniOCLCS2AS_qvtp_qvtcas {
     * guard:leftCS lPackageCS  : minioclcs::PackageCS[1];
     * new:rightAS rPackage : miniocl::Package[1];
     * set lPackageCS.ast := rPackage;
     * 
     */
    protected boolean MAP_m_Package_PackageCS(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PackageCS lPackageCS_2)  {
        try {
            // creations
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package rPackage = MiniOCLFactory.eINSTANCE.createPackage();
            assert rPackage != null;
            models[1/*rightAS*/].add(rPackage);
            // mapping statements
            lPackageCS_2.setAst(rPackage);
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Package_PackageCS = ValueUtil.TRUE_VALUE;
            return m_Package_PackageCS;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_Package_PackageCS", e);
        }
    }
    
    /**
     * 
     * map m_ParameterCS_ast_name in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lParameterCS  : minioclcs::ParameterCS[1];
     * var ast : miniocl::Element[1] := lParameterCS.ast;
     * var name : ecore::EString[?] := lParameterCS.name;
     * var aParameter : miniocl::Parameter[1] := ast.oclAsType(miniocl::Parameter)
     *   ;
     * set aParameter.name := name.toString();
     * 
     */
    protected boolean MAP_m_ParameterCS_ast_name(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ParameterCS lParameterCS)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lParameterCS.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
            if (symbol_0) {
                if (ast == null) {
                    throw throwNull(lParameterCS, "Null where non-null value required");
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = lParameterCS.getName();
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Parameter_0 = idResolver.getClass(CLSSid_Parameter, null);
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Parameter oclAsType = ClassUtil.nonNullState((Parameter)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Parameter_0));
                // mapping statements
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
                oclAsType.setName(toString);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_ParameterCS_ast_name = ValueUtil.TRUE_VALUE;
                raw_ast = m_ParameterCS_ast_name;
            }
            else {
                raw_ast = ValueUtil.FALSE_VALUE;
            }
            return raw_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_ParameterCS_ast_name", e);
        }
    }
    
    /**
     * 
     * map m_ParameterCS_ast_typeRef in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lParameterCS  : minioclcs::ParameterCS[1];
     * var ast : miniocl::Element[1] := lParameterCS.ast;
     * var typeRef : minioclcs::PathNameCS[?] := lParameterCS.typeRef;
     * var aParameter : miniocl::Parameter[1] := ast.oclAsType(miniocl::Parameter)
     *   ;
     * var lookupClass : miniocl::Class[?] := aParameter.lookupClass(typeRef);
     * set aParameter.type := lookupClass;
     * 
     */
    protected boolean MAP_m_ParameterCS_ast_typeRef(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ParameterCS lParameterCS_0)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lParameterCS_0.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
            if (symbol_0) {
                if (ast == null) {
                    throw throwNull(lParameterCS_0, "Null where non-null value required");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS typeRef = lParameterCS_0.getTypeRef();
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Parameter_0 = idResolver.getClass(CLSSid_Parameter, null);
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Parameter oclAsType = ClassUtil.nonNullState((Parameter)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Parameter_0));
                if (typeRef == null) {
                    throw throwNull(lParameterCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = typeRef.getPathElements();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
                final /*@Thrown*/ boolean eq = size.equals(INT_1);
                /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_4;
                if (eq) {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                    if (aPathElementCS == null) {
                        throw throwNull(lParameterCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String cName_0 = aPathElementCS.getElementName();
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment unqualified_env_Class = INST_OclElement_unqualified_env_Class.evaluate(oclAsType);
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundClass = INST_Visitable__lookupClass.evaluate(oclAsType, unqualified_env_Class, cName_0);
                    final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
                    /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_1;
                    if (isEmpty) {
                        symbol_1 = null;
                    }
                    else {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class first = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
                        symbol_1 = first;
                    }
                    symbol_4 = symbol_1;
                }
                else {
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package qualifier = INST_Visitable_lookupPackage.evaluate(oclAsType, qualifierSegments);
                    /*@Caught*/ @Nullable Object CAUGHT_qualifier;
                    try {
                        CAUGHT_qualifier = qualifier;
                    }
                    catch (Exception e) {
                        CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                    }
                    final /*@NonInvalid*/ @NonNull Object symbol_2 = CAUGHT_qualifier == null;
                    /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
                    if (symbol_2 == Boolean.TRUE) {
                        safe_lookupQualifiedClass_source = null;
                    }
                    else {
                        if (qualifier == null) {
                            throw throwNull(lParameterCS_0, "Null where non-null value required");
                        }
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                        if (aPathElementCS_0 == null) {
                            throw throwNull(lParameterCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String cName_1 = aPathElementCS_0.getElementName();
                        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
                        final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment env_3 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = qualifier.getOwnedClasses();
                        @SuppressWarnings("null")
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = env_3.addElements(ownedClasses);
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundClass_0 = INST_Visitable__lookupClass.evaluate(qualifier, addElements, cName_1);
                        final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass_0).booleanValue();
                        /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_3;
                        if (isEmpty_0) {
                            symbol_3 = null;
                        }
                        else {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
                            symbol_3 = first_0;
                        }
                        safe_lookupQualifiedClass_source = symbol_3;
                    }
                    symbol_4 = safe_lookupQualifiedClass_source;
                }
                // mapping statements
                if (symbol_4 == null) {
                    throw throwNull(lParameterCS_0, "Null value for miniocl::TypedElement::type assignment");
                }
                oclAsType.setType(symbol_4);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_ParameterCS_ast_typeRef = ValueUtil.TRUE_VALUE;
                raw_ast = m_ParameterCS_ast_typeRef;
            }
            else {
                raw_ast = ValueUtil.FALSE_VALUE;
            }
            return raw_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_ParameterCS_ast_typeRef", e);
        }
    }
    
    /**
     * 
     * map m_Parameter_ParameterCS in MiniOCLCS2AS_qvtp_qvtcas {
     * guard:leftCS lParameterCS  : minioclcs::ParameterCS[1];
     * new:rightAS rParameter : miniocl::Parameter[1];
     * set lParameterCS.ast := rParameter;
     * 
     */
    protected boolean MAP_m_Parameter_ParameterCS(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ParameterCS lParameterCS_1)  {
        try {
            // creations
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Parameter rParameter = MiniOCLFactory.eINSTANCE.createParameter();
            assert rParameter != null;
            models[1/*rightAS*/].add(rParameter);
            // mapping statements
            lParameterCS_1.setAst(rParameter);
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Parameter_ParameterCS = ValueUtil.TRUE_VALUE;
            return m_Parameter_ParameterCS;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_Parameter_ParameterCS", e);
        }
    }
    
    /**
     * 
     * map m_PropertyCS_ast_name in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lPropertyCS  : minioclcs::PropertyCS[1];
     * var ast : miniocl::Element[1] := lPropertyCS.ast;
     * var name : ecore::EString[?] := lPropertyCS.name;
     * var aProperty : miniocl::Property[1] := ast.oclAsType(miniocl::Property)
     *   ;
     * set aProperty.name := name.toString();
     * 
     */
    protected boolean MAP_m_PropertyCS_ast_name(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PropertyCS lPropertyCS)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lPropertyCS.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
            if (symbol_0) {
                if (ast == null) {
                    throw throwNull(lPropertyCS, "Null where non-null value required");
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = lPropertyCS.getName();
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Property_0 = idResolver.getClass(CLSSid_Property, null);
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Property oclAsType = ClassUtil.nonNullState((org.eclipse.qvtd.doc.miniocl.Property)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Property_0));
                // mapping statements
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
                oclAsType.setName(toString);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_PropertyCS_ast_name = ValueUtil.TRUE_VALUE;
                raw_ast = m_PropertyCS_ast_name;
            }
            else {
                raw_ast = ValueUtil.FALSE_VALUE;
            }
            return raw_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_PropertyCS_ast_name", e);
        }
    }
    
    /**
     * 
     * map m_PropertyCS_ast_typeRef in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lPropertyCS  : minioclcs::PropertyCS[1];
     * var ast : miniocl::Element[1] := lPropertyCS.ast;
     * var typeRef : minioclcs::PathNameCS[?] := lPropertyCS.typeRef;
     * var aProperty : miniocl::Property[1] := ast.oclAsType(miniocl::Property)
     *   ;
     * var lookupClass : miniocl::Class[?] := aProperty.lookupClass(typeRef);
     * set aProperty.type := lookupClass;
     * 
     */
    protected boolean MAP_m_PropertyCS_ast_typeRef(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PropertyCS lPropertyCS_0)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lPropertyCS_0.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
            if (symbol_0) {
                if (ast == null) {
                    throw throwNull(lPropertyCS_0, "Null where non-null value required");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS typeRef = lPropertyCS_0.getTypeRef();
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Property_0 = idResolver.getClass(CLSSid_Property, null);
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Property oclAsType = ClassUtil.nonNullState((org.eclipse.qvtd.doc.miniocl.Property)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Property_0));
                if (typeRef == null) {
                    throw throwNull(lPropertyCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = typeRef.getPathElements();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
                final /*@Thrown*/ boolean eq = size.equals(INT_1);
                /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_4;
                if (eq) {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                    if (aPathElementCS == null) {
                        throw throwNull(lPropertyCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String cName_0 = aPathElementCS.getElementName();
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment unqualified_env_Class = INST_OclElement_unqualified_env_Class.evaluate(oclAsType);
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundClass = INST_Visitable__lookupClass.evaluate(oclAsType, unqualified_env_Class, cName_0);
                    final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
                    /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_1;
                    if (isEmpty) {
                        symbol_1 = null;
                    }
                    else {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class first = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
                        symbol_1 = first;
                    }
                    symbol_4 = symbol_1;
                }
                else {
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package qualifier = INST_Visitable_lookupPackage.evaluate(oclAsType, qualifierSegments);
                    /*@Caught*/ @Nullable Object CAUGHT_qualifier;
                    try {
                        CAUGHT_qualifier = qualifier;
                    }
                    catch (Exception e) {
                        CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                    }
                    final /*@NonInvalid*/ @NonNull Object symbol_2 = CAUGHT_qualifier == null;
                    /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
                    if (symbol_2 == Boolean.TRUE) {
                        safe_lookupQualifiedClass_source = null;
                    }
                    else {
                        if (qualifier == null) {
                            throw throwNull(lPropertyCS_0, "Null where non-null value required");
                        }
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                        if (aPathElementCS_0 == null) {
                            throw throwNull(lPropertyCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String cName_1 = aPathElementCS_0.getElementName();
                        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
                        final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment env_3 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = qualifier.getOwnedClasses();
                        @SuppressWarnings("null")
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = env_3.addElements(ownedClasses);
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue foundClass_0 = INST_Visitable__lookupClass.evaluate(qualifier, addElements, cName_1);
                        final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass_0).booleanValue();
                        /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_3;
                        if (isEmpty_0) {
                            symbol_3 = null;
                        }
                        else {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
                            symbol_3 = first_0;
                        }
                        safe_lookupQualifiedClass_source = symbol_3;
                    }
                    symbol_4 = safe_lookupQualifiedClass_source;
                }
                // mapping statements
                if (symbol_4 == null) {
                    throw throwNull(lPropertyCS_0, "Null value for miniocl::TypedElement::type assignment");
                }
                oclAsType.setType(symbol_4);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_PropertyCS_ast_typeRef = ValueUtil.TRUE_VALUE;
                raw_ast = m_PropertyCS_ast_typeRef;
            }
            else {
                raw_ast = ValueUtil.FALSE_VALUE;
            }
            return raw_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_PropertyCS_ast_typeRef", e);
        }
    }
    
    /**
     * 
     * map m_PropertyCallExp_NameExpCS_Boolean in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
     * check lNameExpCS.isPropCallExpWithExplicitSource();
     * new:rightAS rPropertyCallExp : miniocl::PropertyCallExp[1];
     * notify set lNameExpCS.ast := rPropertyCallExp;
     * 
     */
    protected boolean MAP_m_PropertyCallExp_NameExpCS_Boolean(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_7)  {
        try {
            /*@Caught*/ @NonNull Object CAUGHT_eq;
            try {
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_7.getRoundedBrackets();
                final /*@Thrown*/ boolean eq = roundedBrackets == null;
                CAUGHT_eq = eq;
            }
            catch (Exception e) {
                CAUGHT_eq = ValueUtil.createInvalidValue(e);
            }
            /*@Caught*/ @NonNull Object CAUGHT_symbol_0;
            try {
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_7);
                final /*@Thrown*/ boolean eq_0 = parentCallExpCS == null;
                /*@Thrown*/ boolean symbol_0;
                if (eq_0) {
                    symbol_0 = ValueUtil.FALSE_VALUE;
                }
                else {
                    if (parentCallExpCS == null) {
                        throw throwNull(lNameExpCS_7, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
                    final /*@Thrown*/ boolean eq_1 = lNameExpCS_7.equals(navExp);
                    symbol_0 = eq_1;
                }
                CAUGHT_symbol_0 = symbol_0;
            }
            catch (Exception e) {
                CAUGHT_symbol_0 = ValueUtil.createInvalidValue(e);
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_0);
            if (and == null) {
                throw throwNull(lNameExpCS_7, "Null if condition");
            }
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_3;
            if (and) {
                // creations
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable PropertyCallExp rPropertyCallExp = MiniOCLFactory.eINSTANCE.createPropertyCallExp();
                assert rPropertyCallExp != null;
                models[1/*rightAS*/].add(rPropertyCallExp);
                // mapping statements
                lNameExpCS_7.setAst(rPropertyCallExp);
                objectManager.assigned(lNameExpCS_7, MinioclcsPackage.Literals.CS_TRACE__AST, rPropertyCallExp, null);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_PropertyCallExp_NameExpCS_Boolean = ValueUtil.TRUE_VALUE;
                symbol_3 = m_PropertyCallExp_NameExpCS_Boolean;
            }
            else {
                symbol_3 = ValueUtil.FALSE_VALUE;
            }
            return symbol_3;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_PropertyCallExp_NameExpCS_Boolean", e);
        }
    }
    
    /**
     * 
     * map m_PropertyCallExp_NameExpCS_Boolean_CallExpCS_Call in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
     * check lNameExpCS.isPropCallExpWithImplicitSource()
     *   ;
     * check not lNameExpCS.isVariableExp()
     *   ;
     * check not lNameExpCS.isPropCallExpWithExplicitSource();
     * new:rightAS rPropertyCallExp : miniocl::PropertyCallExp[1];
     * notify set lNameExpCS.ast := rPropertyCallExp;
     * 
     */
    protected boolean MAP_m_PropertyCallExp_NameExpCS_Boolean_CallExpCS_Call(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_8)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            /*@Caught*/ @NonNull Object CAUGHT_eq;
            try {
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_8.getRoundedBrackets();
                final /*@Thrown*/ boolean eq = roundedBrackets == null;
                CAUGHT_eq = eq;
            }
            catch (Exception e) {
                CAUGHT_eq = ValueUtil.createInvalidValue(e);
            }
            /*@Caught*/ @Nullable Object CAUGHT_not;
            try {
                /*@Caught*/ @NonNull Object CAUGHT_symbol_0;
                try {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_8);
                    final /*@Thrown*/ boolean eq_0 = parentCallExpCS == null;
                    /*@Thrown*/ boolean symbol_0;
                    if (eq_0) {
                        symbol_0 = ValueUtil.FALSE_VALUE;
                    }
                    else {
                        if (parentCallExpCS == null) {
                            throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                        }
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
                        final /*@Thrown*/ boolean eq_1 = lNameExpCS_8.equals(navExp);
                        symbol_0 = eq_1;
                    }
                    CAUGHT_symbol_0 = symbol_0;
                }
                catch (Exception e) {
                    CAUGHT_symbol_0 = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_0);
                CAUGHT_not = not;
            }
            catch (Exception e) {
                CAUGHT_not = ValueUtil.createInvalidValue(e);
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_not);
            if (and == null) {
                throw throwNull(lNameExpCS_8, "Null if condition");
            }
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_7;
            if (and) {
                /*@Caught*/ @Nullable Object CAUGHT_and_2;
                try {
                    /*@Caught*/ @Nullable Object CAUGHT_and_1;
                    try {
                        /*@Caught*/ @Nullable Object CAUGHT_and_0;
                        try {
                            /*@Caught*/ @NonNull Object CAUGHT_eq_2;
                            try {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_8.getRoundedBrackets();
                                final /*@Thrown*/ boolean eq_2 = roundedBrackets_0 == null;
                                CAUGHT_eq_2 = eq_2;
                            }
                            catch (Exception e) {
                                CAUGHT_eq_2 = ValueUtil.createInvalidValue(e);
                            }
                            /*@Caught*/ @Nullable Object CAUGHT_not_0;
                            try {
                                /*@Caught*/ @NonNull Object CAUGHT_symbol_1;
                                try {
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS_0 = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_8);
                                    final /*@Thrown*/ boolean eq_3 = parentCallExpCS_0 == null;
                                    /*@Thrown*/ boolean symbol_1;
                                    if (eq_3) {
                                        symbol_1 = ValueUtil.FALSE_VALUE;
                                    }
                                    else {
                                        if (parentCallExpCS_0 == null) {
                                            throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                                        }
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
                                        final /*@Thrown*/ boolean eq_4 = lNameExpCS_8.equals(navExp_0);
                                        symbol_1 = eq_4;
                                    }
                                    CAUGHT_symbol_1 = symbol_1;
                                }
                                catch (Exception e) {
                                    CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
                                }
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_1);
                                CAUGHT_not_0 = not_0;
                            }
                            catch (Exception e) {
                                CAUGHT_not_0 = ValueUtil.createInvalidValue(e);
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_0 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_2, CAUGHT_not_0);
                            CAUGHT_and_0 = and_0;
                        }
                        catch (Exception e) {
                            CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
                        }
                        /*@Caught*/ @NonNull Object CAUGHT_eq_5;
                        try {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName = lNameExpCS_8.getExpName();
                            if (expName == null) {
                                throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
                            }
                            @SuppressWarnings("null")
                            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> pathElements = expName.getPathElements();
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
                            final /*@Thrown*/ boolean eq_5 = size.equals(INT_1);
                            CAUGHT_eq_5 = eq_5;
                        }
                        catch (Exception e) {
                            CAUGHT_eq_5 = ValueUtil.createInvalidValue(e);
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_0, CAUGHT_eq_5);
                        CAUGHT_and_1 = and_1;
                    }
                    catch (Exception e) {
                        CAUGHT_and_1 = ValueUtil.createInvalidValue(e);
                    }
                    /*@Caught*/ @NonNull Object CAUGHT_ne;
                    try {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Variable lookupVariableToDisambiguate = INST_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_8);
                        final /*@Thrown*/ boolean ne = lookupVariableToDisambiguate != null;
                        CAUGHT_ne = ne;
                    }
                    catch (Exception e) {
                        CAUGHT_ne = ValueUtil.createInvalidValue(e);
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_1, CAUGHT_ne);
                    CAUGHT_and_2 = and_2;
                }
                catch (Exception e) {
                    CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_1 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_2);
                if (not_1 == null) {
                    throw throwNull(lNameExpCS_8, "Null if condition");
                }
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_6;
                if (not_1) {
                    /*@Caught*/ @Nullable Object CAUGHT_and_3;
                    try {
                        /*@Caught*/ @NonNull Object CAUGHT_eq_6;
                        try {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets_1 = lNameExpCS_8.getRoundedBrackets();
                            final /*@Thrown*/ boolean eq_6 = roundedBrackets_1 == null;
                            CAUGHT_eq_6 = eq_6;
                        }
                        catch (Exception e) {
                            CAUGHT_eq_6 = ValueUtil.createInvalidValue(e);
                        }
                        /*@Caught*/ @NonNull Object CAUGHT_symbol_2;
                        try {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS_1 = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_8);
                            final /*@Thrown*/ boolean eq_7 = parentCallExpCS_1 == null;
                            /*@Thrown*/ boolean symbol_2;
                            if (eq_7) {
                                symbol_2 = ValueUtil.FALSE_VALUE;
                            }
                            else {
                                if (parentCallExpCS_1 == null) {
                                    throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp_1 = parentCallExpCS_1.getNavExp();
                                final /*@Thrown*/ boolean eq_8 = lNameExpCS_8.equals(navExp_1);
                                symbol_2 = eq_8;
                            }
                            CAUGHT_symbol_2 = symbol_2;
                        }
                        catch (Exception e) {
                            CAUGHT_symbol_2 = ValueUtil.createInvalidValue(e);
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_3 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_6, CAUGHT_symbol_2);
                        CAUGHT_and_3 = and_3;
                    }
                    catch (Exception e) {
                        CAUGHT_and_3 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_2 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_3);
                    if (not_2 == null) {
                        throw throwNull(lNameExpCS_8, "Null if condition");
                    }
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_5;
                    if (not_2) {
                        // creations
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable PropertyCallExp rPropertyCallExp = MiniOCLFactory.eINSTANCE.createPropertyCallExp();
                        assert rPropertyCallExp != null;
                        models[1/*rightAS*/].add(rPropertyCallExp);
                        // mapping statements
                        lNameExpCS_8.setAst(rPropertyCallExp);
                        objectManager.assigned(lNameExpCS_8, MinioclcsPackage.Literals.CS_TRACE__AST, rPropertyCallExp, null);
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_PropertyCallExp_NameExpCS_Boolean_CallExpCS_Call = ValueUtil.TRUE_VALUE;
                        symbol_5 = m_PropertyCallExp_NameExpCS_Boolean_CallExpCS_Call;
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
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_PropertyCallExp_NameExpCS_Boolean_CallExpCS_Call", e);
        }
    }
    
    /**
     * 
     * map m_Property_PropertyCS in MiniOCLCS2AS_qvtp_qvtcas {
     * guard:leftCS lPropertyCS  : minioclcs::PropertyCS[1];
     * new:rightAS rProperty : miniocl::Property[1];
     * set lPropertyCS.ast := rProperty;
     * 
     */
    protected boolean MAP_m_Property_PropertyCS(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PropertyCS lPropertyCS_1)  {
        try {
            // creations
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Property rProperty = MiniOCLFactory.eINSTANCE.createProperty();
            assert rProperty != null;
            models[1/*rightAS*/].add(rProperty);
            // mapping statements
            lPropertyCS_1.setAst(rProperty);
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Property_PropertyCS = ValueUtil.TRUE_VALUE;
            return m_Property_PropertyCS;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_Property_PropertyCS", e);
        }
    }
    
    /**
     * 
     * map m_RootCS_ast_packages in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lRootCS  : minioclcs::RootCS[1];
     * var ast : miniocl::Element[1] := lRootCS.ast;
     * var packages : OrderedSet(minioclcs::PackageCS)[*|1] := lRootCS.packages;
     * var aRoot : miniocl::Root[1] := ast.oclAsType(miniocl::Root)
     *   ;
     * var _'\u00ABcollect\u00BB' : Sequence(miniocl::Package)[*|1] := packages->collect(_'1_' |
     *     _'1_'.ast.oclAsType(miniocl::Package))
     *   ;
     * var asOrderedSet : OrderedSet(miniocl::Package)[*|1] := _'\u00ABcollect\u00BB'->asOrderedSet();
     * set aRoot.ownedPackages := asOrderedSet;
     * 
     */
    protected boolean MAP_m_RootCS_ast_packages(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull RootCS lRootCS)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lRootCS.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
            if (symbol_0) {
                if (ast == null) {
                    throw throwNull(lRootCS, "Null where non-null value required");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PackageCS> packages = lRootCS.getPackages();
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Root_0 = idResolver.getClass(CLSSid_Root, null);
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Root oclAsType = ClassUtil.nonNullState((Root)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Root_0));
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_packages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, packages);
                /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
                @NonNull Iterator<Object> ITERATOR__1 = BOXED_packages.iterator();
                /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
                while (true) {
                    if (!ITERATOR__1.hasNext()) {
                        collect = accumulator;
                        break;
                    }
                    @SuppressWarnings("null")
                    /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PackageCS _1 = (PackageCS)ITERATOR__1.next();
                    /**
                     * _'1_'.ast.oclAsType(miniocl::Package)
                     */
                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast_0 = _1.getAst();
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Package oclAsType_0 = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_miniocl_c_c_Package_0));
                    //
                    accumulator.add(oclAsType_0);
                }
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
                // mapping statements
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Package> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, asOrderedSet);
                oclAsType.getOwnedPackages().addAll(ECORE_asOrderedSet);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_RootCS_ast_packages = ValueUtil.TRUE_VALUE;
                raw_ast = m_RootCS_ast_packages;
            }
            else {
                raw_ast = ValueUtil.FALSE_VALUE;
            }
            return raw_ast;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_RootCS_ast_packages", e);
        }
    }
    
    /**
     * 
     * map m_Root_RootCS in MiniOCLCS2AS_qvtp_qvtcas {
     * guard:leftCS lRootCS  : minioclcs::RootCS[1];
     * new:rightAS rRoot : miniocl::Root[1];
     * set lRootCS.ast := rRoot;
     * 
     */
    protected boolean MAP_m_Root_RootCS(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull RootCS lRootCS_0)  {
        try {
            // creations
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Root rRoot = MiniOCLFactory.eINSTANCE.createRoot();
            assert rRoot != null;
            models[1/*rightAS*/].add(rRoot);
            // mapping statements
            lRootCS_0.setAst(rRoot);
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Root_RootCS = ValueUtil.TRUE_VALUE;
            return m_Root_RootCS;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_Root_RootCS", e);
        }
    }
    
    /**
     * 
     * map m_VariableExp_NameExpCS_Boolean_CallExpCS_CallExpC in MiniOCLCS2AS_qvtp_qvtcas {
     * 
     *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
     * check not lNameExpCS.isPropCallExpWithExplicitSource()
     *   ;
     * check lNameExpCS.isVariableExp();
     * new:rightAS rVariableExp : miniocl::VariableExp[1];
     * notify set lNameExpCS.ast := rVariableExp;
     * 
     */
    protected boolean MAP_m_VariableExp_NameExpCS_Boolean_CallExpCS_CallExpC(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_9)  {
        try {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            /*@Caught*/ @Nullable Object CAUGHT_and;
            try {
                /*@Caught*/ @NonNull Object CAUGHT_eq;
                try {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_9.getRoundedBrackets();
                    final /*@Thrown*/ boolean eq = roundedBrackets == null;
                    CAUGHT_eq = eq;
                }
                catch (Exception e) {
                    CAUGHT_eq = ValueUtil.createInvalidValue(e);
                }
                /*@Caught*/ @NonNull Object CAUGHT_symbol_0;
                try {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_9);
                    final /*@Thrown*/ boolean eq_0 = parentCallExpCS == null;
                    /*@Thrown*/ boolean symbol_0;
                    if (eq_0) {
                        symbol_0 = ValueUtil.FALSE_VALUE;
                    }
                    else {
                        if (parentCallExpCS == null) {
                            throw throwNull(lNameExpCS_9, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                        }
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
                        final /*@Thrown*/ boolean eq_1 = lNameExpCS_9.equals(navExp);
                        symbol_0 = eq_1;
                    }
                    CAUGHT_symbol_0 = symbol_0;
                }
                catch (Exception e) {
                    CAUGHT_symbol_0 = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_0);
                CAUGHT_and = and;
            }
            catch (Exception e) {
                CAUGHT_and = ValueUtil.createInvalidValue(e);
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and);
            if (not == null) {
                throw throwNull(lNameExpCS_9, "Null if condition");
            }
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_5;
            if (not) {
                /*@Caught*/ @Nullable Object CAUGHT_and_1;
                try {
                    /*@Caught*/ @Nullable Object CAUGHT_and_0;
                    try {
                        /*@Caught*/ @NonNull Object CAUGHT_eq_2;
                        try {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_9.getRoundedBrackets();
                            final /*@Thrown*/ boolean eq_2 = roundedBrackets_0 == null;
                            CAUGHT_eq_2 = eq_2;
                        }
                        catch (Exception e) {
                            CAUGHT_eq_2 = ValueUtil.createInvalidValue(e);
                        }
                        /*@Caught*/ @Nullable Object CAUGHT_not_0;
                        try {
                            /*@Caught*/ @NonNull Object CAUGHT_symbol_1;
                            try {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS parentCallExpCS_0 = INST_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_9);
                                final /*@Thrown*/ boolean eq_3 = parentCallExpCS_0 == null;
                                /*@Thrown*/ boolean symbol_1;
                                if (eq_3) {
                                    symbol_1 = ValueUtil.FALSE_VALUE;
                                }
                                else {
                                    if (parentCallExpCS_0 == null) {
                                        throw throwNull(lNameExpCS_9, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
                                    }
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
                                    final /*@Thrown*/ boolean eq_4 = lNameExpCS_9.equals(navExp_0);
                                    symbol_1 = eq_4;
                                }
                                CAUGHT_symbol_1 = symbol_1;
                            }
                            catch (Exception e) {
                                CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_1);
                            CAUGHT_not_0 = not_0;
                        }
                        catch (Exception e) {
                            CAUGHT_not_0 = ValueUtil.createInvalidValue(e);
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_0 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_2, CAUGHT_not_0);
                        CAUGHT_and_0 = and_0;
                    }
                    catch (Exception e) {
                        CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
                    }
                    /*@Caught*/ @NonNull Object CAUGHT_eq_5;
                    try {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName = lNameExpCS_9.getExpName();
                        if (expName == null) {
                            throw throwNull(lNameExpCS_9, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
                        }
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> pathElements = expName.getPathElements();
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
                        final /*@Thrown*/ boolean eq_5 = size.equals(INT_1);
                        CAUGHT_eq_5 = eq_5;
                    }
                    catch (Exception e) {
                        CAUGHT_eq_5 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_0, CAUGHT_eq_5);
                    CAUGHT_and_1 = and_1;
                }
                catch (Exception e) {
                    CAUGHT_and_1 = ValueUtil.createInvalidValue(e);
                }
                /*@Caught*/ @NonNull Object CAUGHT_ne;
                try {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Variable lookupVariableToDisambiguate = INST_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_9);
                    final /*@Thrown*/ boolean ne = lookupVariableToDisambiguate != null;
                    CAUGHT_ne = ne;
                }
                catch (Exception e) {
                    CAUGHT_ne = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_1, CAUGHT_ne);
                if (and_2 == null) {
                    throw throwNull(lNameExpCS_9, "Null if condition");
                }
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_4;
                if (and_2) {
                    // creations
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable VariableExp rVariableExp = MiniOCLFactory.eINSTANCE.createVariableExp();
                    assert rVariableExp != null;
                    models[1/*rightAS*/].add(rVariableExp);
                    // mapping statements
                    lNameExpCS_9.setAst(rVariableExp);
                    objectManager.assigned(lNameExpCS_9, MinioclcsPackage.Literals.CS_TRACE__AST, rVariableExp, null);
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_VariableExp_NameExpCS_Boolean_CallExpCS_CallExpC = ValueUtil.TRUE_VALUE;
                    symbol_4 = m_VariableExp_NameExpCS_Boolean_CallExpCS_CallExpC;
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
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_VariableExp_NameExpCS_Boolean_CallExpCS_CallExpC", e);
        }
    }
}
