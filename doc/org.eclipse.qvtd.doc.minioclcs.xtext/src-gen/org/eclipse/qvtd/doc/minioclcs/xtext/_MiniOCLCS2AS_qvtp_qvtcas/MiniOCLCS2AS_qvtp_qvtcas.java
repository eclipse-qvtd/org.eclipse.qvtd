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
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionAsOrderedSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionFirstOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionLastOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedSetSubOrderedSetOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanAndOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.numeric.NumericMinusOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsTypeOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyToStringOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.doc.miniocl.Element;
import org.eclipse.qvtd.doc.miniocl.ExpressionInOCL;
import org.eclipse.qvtd.doc.miniocl.MiniOCLFactory;
import org.eclipse.qvtd.doc.miniocl.MiniOCLPackage;
import org.eclipse.qvtd.doc.miniocl.OCLExpression;
import org.eclipse.qvtd.doc.miniocl.Operation;
import org.eclipse.qvtd.doc.miniocl.Package;
import org.eclipse.qvtd.doc.miniocl.Parameter;
import org.eclipse.qvtd.doc.miniocl.PropertyCallExp;
import org.eclipse.qvtd.doc.miniocl.Root;
import org.eclipse.qvtd.doc.miniocl.Variable;
import org.eclipse.qvtd.doc.miniocl.VariableExp;
import org.eclipse.qvtd.doc.miniocl.lookup.util.MiniOCLLookupResult;
import org.eclipse.qvtd.doc.miniocl.lookup.util.MiniOCLLookupSolver;
import org.eclipse.qvtd.doc.miniocl.util.Visitable;
import org.eclipse.qvtd.doc.minioclcs.CallExpCS;
import org.eclipse.qvtd.doc.minioclcs.ClassCS;
import org.eclipse.qvtd.doc.minioclcs.ExpCS;
import org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage;
import org.eclipse.qvtd.doc.minioclcs.NameExpCS;
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
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_CallExpCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("CallExpCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ClassCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("ClassCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class_0 = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Element = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Element", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ExpCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("ExpCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ExpressionInOCL = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("ExpressionInOCL", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Model = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary.getClassId("Model", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_NameExpCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("NameExpCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_NamedElement = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("NamedElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OCLExpression = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("OCLExpression", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
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
    public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_self = "self";
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Class = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Class_0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_ClassCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ClassCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Operation = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Operation);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_OperationCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OperationCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Package = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Package);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_PackageCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PackageCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Parameter = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Parameter);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_ParameterCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ParameterCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_PathElementCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PathElementCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Property = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Property);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_PropertyCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PropertyCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull PropertyId PROPid_name = CLSSid_NamedElement.getPropertyId("name");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull PropertyId PROPid_ownedBody = CLSSid_ExpressionInOCL.getPropertyId("ownedBody");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull PropertyId PROPid_ownedSelfVar = CLSSid_ExpressionInOCL.getPropertyId("ownedSelfVar");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull PropertyId PROPid_referredVariable = CLSSid_VariableExp.getPropertyId("referredVariable");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull PropertyId PROPid_type = CLSSid_TypedElement.getPropertyId("type");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Class = TypeId.SEQUENCE.getSpecializedId(CLSSid_Class_0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Operation = TypeId.SEQUENCE.getSpecializedId(CLSSid_Operation);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Package = TypeId.SEQUENCE.getSpecializedId(CLSSid_Package);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Parameter = TypeId.SEQUENCE.getSpecializedId(CLSSid_Parameter);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Property = TypeId.SEQUENCE.getSpecializedId(CLSSid_Property);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_CallExpCS = TypeId.SET.getSpecializedId(CLSSid_CallExpCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_ClassCS = TypeId.SET.getSpecializedId(CLSSid_ClassCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_NameExpCS = TypeId.SET.getSpecializedId(CLSSid_NameExpCS);
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
        CLSSid_OperationCS,             // 3 => OperationCS
        CLSSid_PackageCS,               // 4 => PackageCS
        CLSSid_ParameterCS,             // 5 => ParameterCS
        CLSSid_PropertyCS,              // 6 => PropertyCS
        CLSSid_RootCS                   // 7 => RootCS
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
        {2,0},                  // 2 : NameExpCS -> {NameExpCS,CallExpCS}
        {3},                    // 3 : OperationCS -> {OperationCS}
        {4},                    // 4 : PackageCS -> {PackageCS}
        {5},                    // 5 : ParameterCS -> {ParameterCS}
        {6},                    // 6 : PropertyCS -> {PropertyCS}
        {7}                     // 7 : RootCS -> {RootCS}
    };
    
    protected final @NonNull AbstractInvocationConstructor CTOR_m_NameExpCS_ast_3 = new AbstractInvocationConstructor(idResolver)
    {
        @Override
        public @NonNull MAP_m_NameExpCS_ast_3 newInstance(@NonNull Object @NonNull [] values) {
            return new MAP_m_NameExpCS_ast_3(values);
        }
    };
    
    protected final @NonNull AbstractInvocationConstructor CTOR_m_NameExpCS_ast_4 = new AbstractInvocationConstructor(idResolver)
    {
        @Override
        public @NonNull MAP_m_NameExpCS_ast_4 newInstance(@NonNull Object @NonNull [] values) {
            return new MAP_m_NameExpCS_ast_4(values);
        }
    };
    
    protected final @NonNull AbstractInvocationConstructor CTOR_m_NameExpCS_ast_expName_1 = new AbstractInvocationConstructor(idResolver)
    {
        @Override
        public @NonNull MAP_m_NameExpCS_ast_expName_1 newInstance(@NonNull Object @NonNull [] values) {
            return new MAP_m_NameExpCS_ast_expName_1(values);
        }
    };
    
    protected final @NonNull AbstractInvocationConstructor CTOR_m_NameExpCS_ast_expName_2 = new AbstractInvocationConstructor(idResolver)
    {
        @Override
        public @NonNull MAP_m_NameExpCS_ast_expName_2 newInstance(@NonNull Object @NonNull [] values) {
            return new MAP_m_NameExpCS_ast_expName_2(values);
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
    public /*@NonInvalid*/ Package lookupPackage(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.util.@org.eclipse.jdt.annotation.NonNull Visitable self_0, final /*@NonInvalid*/ List<PathElementCS> segments) {
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments);
        final /*@NonInvalid*/ boolean eq = size.equals(INT_1);
        /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package symbol_1;
        if (eq) {
            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments);
            if (aPathElementCS == null) {
                throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName = aPathElementCS.getPathName();
            MiniOCLLookupResult<Package> _lookupResult = lookupSolver._lookupUnqualifiedPackage(self_0, (String)pathName);
            Package _lookupUnqualifiedPackage = null;
            if (_lookupResult.size() == 1) {
                _lookupUnqualifiedPackage = _lookupResult.getSingleResult();
            } else {
                handleLookupError(aPathElementCS,pathName);
            };
            symbol_1 = _lookupUnqualifiedPackage;
        }
        else {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments, INT_1, diff);
            final List<PathElementCS> UNBOXED_qualifierSegments = qualifierSegments.asEcoreObjects(idResolver, PathElementCS.class);
            assert UNBOXED_qualifierSegments != null;
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package qualifier = this.lookupPackage(self_0, UNBOXED_qualifierSegments);
            /*@Caught*/ @Nullable Object CAUGHT_qualifier;
            try {
                CAUGHT_qualifier = qualifier;
            }
            catch (Exception e) {
                CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
            }
            final /*@NonInvalid*/ @NonNull Object symbol_0 = CAUGHT_qualifier == null;
            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package safe_lookupQualifiedPackage_source;
            if (symbol_0 == Boolean.TRUE) {
                safe_lookupQualifiedPackage_source = null;
            }
            else {
                if (qualifier == null) {
                    throw new InvalidValueException("Null where non-null value required");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments);
                if (aPathElementCS_0 == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName_0 = aPathElementCS_0.getPathName();
                MiniOCLLookupResult<Package> _lookupResult_0 = lookupSolver._lookupQualifiedPackage(qualifier, (String)pathName_0);
                Package _lookupQualifiedPackage = null;
                if (_lookupResult_0.size() == 1) {
                    _lookupQualifiedPackage = _lookupResult_0.getSingleResult();
                } else {
                    handleLookupError(aPathElementCS_0,pathName_0);
                };
                safe_lookupQualifiedPackage_source = _lookupQualifiedPackage;
            }
            symbol_1 = safe_lookupQualifiedPackage_source;
        }
        return symbol_1;
    }
    
    /**
     * 
     * map __root__ in MiniOCLCS2AS_qvtp_qvtcas {
     *   where ( |)
     * {_'\u00ABCallExpCS\u00BB' : Set(minioclcs::CallExpCS) = leftCS.objectsOfKind(minioclcs::CallExpCS)
     *   ;
     * _'\u00ABClassCS\u00BB' : Set(minioclcs::ClassCS) = leftCS.objectsOfKind(minioclcs::ClassCS)
     *   ;
     * _'\u00ABNameExpCS\u00BB' : Set(minioclcs::NameExpCS) = leftCS.objectsOfKind(minioclcs::NameExpCS)
     *   ;
     * _'\u00ABOperationCS\u00BB' : Set(minioclcs::OperationCS) = leftCS.objectsOfKind(minioclcs::OperationCS)
     *   ;
     * _'\u00ABPackageCS\u00BB' : Set(minioclcs::PackageCS) = leftCS.objectsOfKind(minioclcs::PackageCS)
     *   ;
     * _'\u00ABParameterCS\u00BB' : Set(minioclcs::ParameterCS) = leftCS.objectsOfKind(minioclcs::ParameterCS)
     *   ;
     * _'\u00ABPropertyCS\u00BB' : Set(minioclcs::PropertyCS) = leftCS.objectsOfKind(minioclcs::PropertyCS)
     *   ;
     * _'\u00ABRootCS\u00BB' : Set(minioclcs::RootCS) = leftCS.objectsOfKind(minioclcs::RootCS)
     *   ;
     * ji_CallExpCS : Set(minioclcs::CallExpCS)[*|1] = _'\u00ABCallExpCS\u00BB';
     * ji_ClassCS : Set(minioclcs::ClassCS)[*|1] = _'\u00ABClassCS\u00BB';
     * ji_NameExpCS : Set(minioclcs::NameExpCS)[*|1] = _'\u00ABNameExpCS\u00BB';
     * ji_OperationCS : Set(minioclcs::OperationCS)[*|1] = _'\u00ABOperationCS\u00BB';
     * ji_PackageCS : Set(minioclcs::PackageCS)[*|1] = _'\u00ABPackageCS\u00BB';
     * ji_ParameterCS : Set(minioclcs::ParameterCS)[*|1] = _'\u00ABParameterCS\u00BB';
     * ji_PropertyCS : Set(minioclcs::PropertyCS)[*|1] = _'\u00ABPropertyCS\u00BB';
     * ji_RootCS : Set(minioclcs::RootCS)[*|1] = _'\u00ABRootCS\u00BB';
     *  |}
     * for loop0 : minioclcs::ClassCS in ji_ClassCS {
     *     call m_Class_ClassCS {
     * lClassCS := loop0;
     * }}
     *   for loop0 : minioclcs::NameExpCS in ji_NameExpCS {
     *     call m_PropertyCallExp_NameExpCS {
     * lNameExpCS := loop0;
     * }}
     *   for loop0 : minioclcs::OperationCS in ji_OperationCS {
     *     call m_Operation_OperationCS {
     * lOperationCS := loop0;
     * }}
     *   for loop0 : minioclcs::PackageCS in ji_PackageCS {
     *     call m_Package_PackageCS {
     * lPackageCS := loop0;
     * }}
     *   for loop0 : minioclcs::ParameterCS in ji_ParameterCS {
     *     call m_Parameter_ParameterCS {
     * lParameterCS := loop0;
     * }}
     *   for loop0 : minioclcs::PropertyCS in ji_PropertyCS {
     *     call m_Property_PropertyCS {
     * lPropertyCS := loop0;
     * }}
     *   for loop0 : minioclcs::RootCS in ji_RootCS {
     *     call m_Root_RootCS {
     * lRootCS := loop0;
     * }}
     *   for loop0 : minioclcs::ClassCS in ji_ClassCS {
     *     call m_OrderedSet_ClassCS {
     * lClassCS := loop0;
     * }}
     *   for loop0 : minioclcs::OperationCS in ji_OperationCS {
     *     call m_OrderedSet_OperationCS {
     * lOperationCS := loop0;
     * }}
     *   for loop0 : minioclcs::PackageCS in ji_PackageCS {
     *     call m_OrderedSet_PackageCS {
     * lPackageCS := loop0;
     * }}
     *   for loop0 : minioclcs::ParameterCS in ji_ParameterCS {
     *     call m_String_ParameterCS {
     * lParameterCS := loop0;
     * }}
     *   for loop0 : minioclcs::NameExpCS in ji_NameExpCS {
     *     call m_PropertyCallExp_NameExpCS_NamedElement_Variable {
     * lNameExpCS := loop0;
     * }}
     *   for loop0 : minioclcs::NameExpCS in ji_NameExpCS {
     *     call m_VariableExp_NameExpCS_NamedElement_Variable {
     * lNameExpCS := loop0;
     * }}
     *   for loop0 : minioclcs::CallExpCS in ji_CallExpCS {
     *     call m_CallExpCS_ast_nameExp {
     * lCallExpCS := loop0;
     * }}
     *   for loop0 : minioclcs::NameExpCS in ji_NameExpCS {
     *     call m_NameExpCS_ast {
     * lNameExpCS := loop0;
     * }}
     *   for loop0 : minioclcs::OperationCS in ji_OperationCS {
     *     call m_OperationCS_ast_body {
     * lOperationCS := loop0;
     * }}
     *   for loop0 : minioclcs::NameExpCS in ji_NameExpCS {
     *     call m_NameExpCS_ast_expName {
     * lNameExpCS := loop0;
     * }}
     *   for loop0 : minioclcs::PropertyCS in ji_PropertyCS {
     *     call m_String_PropertyCS {
     * lPropertyCS := loop0;
     * }}
     *   for loop0 : minioclcs::RootCS in ji_RootCS {
     *     call m_OrderedSet_RootCS {
     * lRootCS := loop0;
     * }}
     *   for loop0 : minioclcs::ClassCS in ji_ClassCS {
     *     call m_ClassCS_ast_extends {
     * lClassCS := loop0;
     * }}
     *   for loop0 : minioclcs::OperationCS in ji_OperationCS {
     *     call m_OperationCS_ast_resultRef {
     * lOperationCS := loop0;
     * }}
     *   for loop0 : minioclcs::ParameterCS in ji_ParameterCS {
     *     call m_ParameterCS_ast_typeRef {
     * lParameterCS := loop0;
     * }}
     *   for loop0 : minioclcs::NameExpCS in ji_NameExpCS {
     *     call m_NameExpCS_ast_1 {
     * lNameExpCS := loop0;
     * }}
     *   for loop0 : minioclcs::NameExpCS in ji_NameExpCS {
     *     call m_NameExpCS_ast_2 {
     * lNameExpCS := loop0;
     * }}
     *   for loop0 : minioclcs::PropertyCS in ji_PropertyCS {
     *     call m_PropertyCS_ast_typeRef {
     * lPropertyCS := loop0;
     * }}
     *   for loop0 : minioclcs::NameExpCS in ji_NameExpCS {
     *     call m_NameExpCS_ast_expName_1 {
     * lNameExpCS := loop0;
     * }}
     *   for loop0 : minioclcs::NameExpCS in ji_NameExpCS {
     *     call m_NameExpCS_ast_3 {
     * lNameExpCS := loop0;
     * }}
     *   for loop0 : minioclcs::NameExpCS in ji_NameExpCS {
     *     call m_NameExpCS_ast_expName_2 {
     * lNameExpCS := loop0;
     * }}
     *   for loop0 : minioclcs::NameExpCS in ji_NameExpCS {
     *     call m_NameExpCS_ast_4 {
     * lNameExpCS := loop0;
     * }}
     */
    protected boolean MAP___root__()  {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_CallExpCS_1 = idResolver.getClass(CLSSid_CallExpCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_CallExpCS, models[0/*leftCS*/], TYP_minioclcs_c_c_CallExpCS_1);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_ClassCS_0 = idResolver.getClass(CLSSid_ClassCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_0 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_ClassCS, models[0/*leftCS*/], TYP_minioclcs_c_c_ClassCS_0);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_NameExpCS_0 = idResolver.getClass(CLSSid_NameExpCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_1 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_NameExpCS, models[0/*leftCS*/], TYP_minioclcs_c_c_NameExpCS_0);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_OperationCS_0 = idResolver.getClass(CLSSid_OperationCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_2 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_OperationCS, models[0/*leftCS*/], TYP_minioclcs_c_c_OperationCS_0);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_PackageCS_0 = idResolver.getClass(CLSSid_PackageCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_3 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_PackageCS, models[0/*leftCS*/], TYP_minioclcs_c_c_PackageCS_0);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_ParameterCS_0 = idResolver.getClass(CLSSid_ParameterCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_4 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_ParameterCS, models[0/*leftCS*/], TYP_minioclcs_c_c_ParameterCS_0);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_PropertyCS_0 = idResolver.getClass(CLSSid_PropertyCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_5 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_PropertyCS, models[0/*leftCS*/], TYP_minioclcs_c_c_PropertyCS_0);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_RootCS_0 = idResolver.getClass(CLSSid_RootCS, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind_6 = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_RootCS, models[0/*leftCS*/], TYP_minioclcs_c_c_RootCS_0);
            // connection variables
            final SetValue.@NonNull Accumulator ji_CallExpCS = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_CallExpCS);
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CallExpCS iterator : ValueUtil.typedIterable(CallExpCS.class, objectsOfKind)) {
                ji_CallExpCS.add(iterator);
            }
            final SetValue.@NonNull Accumulator ji_ClassCS = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_ClassCS);
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ClassCS iterator_0 : ValueUtil.typedIterable(ClassCS.class, objectsOfKind_0)) {
                ji_ClassCS.add(iterator_0);
            }
            final SetValue.@NonNull Accumulator ji_NameExpCS = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_NameExpCS);
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS iterator_1 : ValueUtil.typedIterable(NameExpCS.class, objectsOfKind_1)) {
                ji_NameExpCS.add(iterator_1);
            }
            final SetValue.@NonNull Accumulator ji_OperationCS = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_OperationCS);
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS iterator_2 : ValueUtil.typedIterable(OperationCS.class, objectsOfKind_2)) {
                ji_OperationCS.add(iterator_2);
            }
            final SetValue.@NonNull Accumulator ji_PackageCS = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_PackageCS);
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PackageCS iterator_3 : ValueUtil.typedIterable(PackageCS.class, objectsOfKind_3)) {
                ji_PackageCS.add(iterator_3);
            }
            final SetValue.@NonNull Accumulator ji_ParameterCS = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_ParameterCS);
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ParameterCS iterator_4 : ValueUtil.typedIterable(ParameterCS.class, objectsOfKind_4)) {
                ji_ParameterCS.add(iterator_4);
            }
            final SetValue.@NonNull Accumulator ji_PropertyCS = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_PropertyCS);
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PropertyCS iterator_5 : ValueUtil.typedIterable(PropertyCS.class, objectsOfKind_5)) {
                ji_PropertyCS.add(iterator_5);
            }
            final SetValue.@NonNull Accumulator ji_RootCS = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_RootCS);
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull RootCS iterator_6 : ValueUtil.typedIterable(RootCS.class, objectsOfKind_6)) {
                ji_RootCS.add(iterator_6);
            }
            // mapping statements
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ClassCS loop0 : ValueUtil.typedIterable(ClassCS.class, ji_ClassCS)) {
                MAP_m_Class_ClassCS(loop0);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_0 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                MAP_m_PropertyCallExp_NameExpCS(loop0_0);
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
                MAP_m_OrderedSet_ClassCS(loop0_6);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS loop0_7 : ValueUtil.typedIterable(OperationCS.class, ji_OperationCS)) {
                MAP_m_OrderedSet_OperationCS(loop0_7);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PackageCS loop0_8 : ValueUtil.typedIterable(PackageCS.class, ji_PackageCS)) {
                MAP_m_OrderedSet_PackageCS(loop0_8);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ParameterCS loop0_9 : ValueUtil.typedIterable(ParameterCS.class, ji_ParameterCS)) {
                MAP_m_String_ParameterCS(loop0_9);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_10 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                MAP_m_PropertyCallExp_NameExpCS_NamedElement_Variable(loop0_10);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_11 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                MAP_m_VariableExp_NameExpCS_NamedElement_Variable(loop0_11);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CallExpCS loop0_12 : ValueUtil.typedIterable(CallExpCS.class, ji_CallExpCS)) {
                MAP_m_CallExpCS_ast_nameExp(loop0_12);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_13 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                MAP_m_NameExpCS_ast(loop0_13);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS loop0_14 : ValueUtil.typedIterable(OperationCS.class, ji_OperationCS)) {
                MAP_m_OperationCS_ast_body(loop0_14);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_15 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                MAP_m_NameExpCS_ast_expName(loop0_15);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PropertyCS loop0_16 : ValueUtil.typedIterable(PropertyCS.class, ji_PropertyCS)) {
                MAP_m_String_PropertyCS(loop0_16);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull RootCS loop0_17 : ValueUtil.typedIterable(RootCS.class, ji_RootCS)) {
                MAP_m_OrderedSet_RootCS(loop0_17);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ClassCS loop0_18 : ValueUtil.typedIterable(ClassCS.class, ji_ClassCS)) {
                MAP_m_ClassCS_ast_extends(loop0_18);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS loop0_19 : ValueUtil.typedIterable(OperationCS.class, ji_OperationCS)) {
                MAP_m_OperationCS_ast_resultRef(loop0_19);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ParameterCS loop0_20 : ValueUtil.typedIterable(ParameterCS.class, ji_ParameterCS)) {
                MAP_m_ParameterCS_ast_typeRef(loop0_20);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_21 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                MAP_m_NameExpCS_ast_1(loop0_21);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_22 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                MAP_m_NameExpCS_ast_2(loop0_22);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PropertyCS loop0_23 : ValueUtil.typedIterable(PropertyCS.class, ji_PropertyCS)) {
                MAP_m_PropertyCS_ast_typeRef(loop0_23);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_24 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                invoke(CTOR_m_NameExpCS_ast_expName_1, loop0_24);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_25 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                invoke(CTOR_m_NameExpCS_ast_3, loop0_25);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_26 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                invoke(CTOR_m_NameExpCS_ast_expName_2, loop0_26);
            }
            for (org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS loop0_27 : ValueUtil.typedIterable(NameExpCS.class, ji_NameExpCS)) {
                invoke(CTOR_m_NameExpCS_ast_4, loop0_27);
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean __root__ = ValueUtil.TRUE_VALUE;
            return __root__;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP___root__", e);
        }
    }
    
    /**
     * 
     * map m_CallExpCS_ast_nameExp in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lCallExpCS : minioclcs::CallExpCS[1];
     *  |)
     * {nameExp : minioclcs::NameExpCS[?];
     *  |}
     * rightAS ( |)
     * {aOCLExpression : miniocl::OCLExpression[1];
     * ast : miniocl::Element[1];
     *  |}
     * where ( |
     * lCallExpCS.oclIsTypeOf(minioclcs::CallExpCS))
     * { |
     * nameExp := lCallExpCS.nameExp;
     * aOCLExpression := nameExp.ast;
     * ast := nameExp.ast;
     * lCallExpCS.ast := aOCLExpression;
     * }
     * 
     */
    protected boolean MAP_m_CallExpCS_ast_nameExp(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CallExpCS lCallExpCS)  {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_CallExpCS_0_0 = idResolver.getClass(CLSSid_CallExpCS, null);
            final /*@NonInvalid*/ boolean oclIsTypeOf = OclAnyOclIsTypeOfOperation.INSTANCE.evaluate(executor, lCallExpCS, TYP_minioclcs_c_c_CallExpCS_0_0).booleanValue();
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_6;
            if (oclIsTypeOf) {
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp = lCallExpCS.getNameExp();
                if (nameExp == null) {
                    throw throwNull(lCallExpCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CSTrace::ast\'");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = nameExp.getAst();
                final /*@Thrown*/ boolean symbol_0 = ast != null;
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aOCLExpression;
                if (symbol_0) {
                    final /*@NonInvalid*/ boolean symbol_1 = ast instanceof OCLExpression;
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_5;
                    if (symbol_1) {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable OCLExpression symbol_2 = (OCLExpression)ast;
                        if (symbol_2 == null) {
                            throw throwNull(lCallExpCS, "Null where non-null value required");
                        }
                        final /*@Thrown*/ boolean symbol_3 = ast != null;
                        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                        if (symbol_3) {
                            if (ast == null) {
                                throw throwNull(lCallExpCS, "Null where non-null value required");
                            }
                            // property assignments
                            lCallExpCS.setAst(symbol_2);
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_CallExpCS_ast_nameExp = ValueUtil.TRUE_VALUE;
                            raw_ast = m_CallExpCS_ast_nameExp;
                        }
                        else {
                            raw_ast = ValueUtil.FALSE_VALUE;
                        }
                        symbol_5 = raw_ast;
                    }
                    else {
                        symbol_5 = ValueUtil.FALSE_VALUE;
                    }
                    raw_aOCLExpression = symbol_5;
                }
                else {
                    raw_aOCLExpression = ValueUtil.FALSE_VALUE;
                }
                symbol_6 = raw_aOCLExpression;
            }
            else {
                symbol_6 = ValueUtil.FALSE_VALUE;
            }
            return symbol_6;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_CallExpCS_ast_nameExp", e);
        }
    }
    
    /**
     * 
     * map m_ClassCS_ast_extends in MiniOCLCS2AS_qvtp_qvtcas {leftCS (lClassCS : minioclcs::ClassCS[1];
     *  |)
     * {extends : minioclcs::PathNameCS[?];
     *  |}
     * rightAS ( |)
     * {aClass : miniocl::Class[1];
     * ast : miniocl::Element[1];
     * superClass : miniocl::Class[1];
     *  |}
     * where ( |)
     * {_'=' : Boolean[1];
     *  |
     * aClass := lClassCS.ast;
     * ast := lClassCS.ast;
     * extends := lClassCS.extends;
     * _'=' := extends =
     *   null;
     * superClass := if _'='
     *   then null
     *   else aClass.lookupClass(extends)
     *   endif;
     * aClass.superClass := superClass;
     * }
     * 
     */
    protected boolean MAP_m_ClassCS_ast_extends(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ClassCS lClassCS)  {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lClassCS.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aClass;
            if (symbol_0) {
                final /*@NonInvalid*/ boolean symbol_1 = ast instanceof org.eclipse.qvtd.doc.miniocl.Class;
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_11;
                if (symbol_1) {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_2 = (org.eclipse.qvtd.doc.miniocl.Class)ast;
                    if (symbol_2 == null) {
                        throw throwNull(lClassCS, "Null where non-null value required");
                    }
                    final /*@Thrown*/ boolean symbol_3 = ast != null;
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                    if (symbol_3) {
                        if (ast == null) {
                            throw throwNull(lClassCS, "Null where non-null value required");
                        }
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS symbol_4 = lClassCS.getExtends();
                        final /*@Thrown*/ boolean symbol_5 = symbol_4 == null;
                        /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_8;
                        if (symbol_5) {
                            symbol_8 = null;
                        }
                        else {
                            if (symbol_4 == null) {
                                throw throwNull(lClassCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                            }
                            @SuppressWarnings("null")
                            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = symbol_4.getPath();
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
                            final /*@Thrown*/ boolean eq = size.equals(INT_1);
                            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_7;
                            if (eq) {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                                if (aPathElementCS == null) {
                                    throw throwNull(lClassCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                                }
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName = aPathElementCS.getPathName();
                                MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Class> _lookupResult = lookupSolver._lookupUnqualifiedClass(symbol_2, (String)pathName);
                                org.eclipse.qvtd.doc.miniocl.Class _lookupUnqualifiedClass = null;
                                if (_lookupResult.size() == 1) {
                                    _lookupUnqualifiedClass = _lookupResult.getSingleResult();
                                } else {
                                    handleLookupError(aPathElementCS,pathName);
                                };
                                symbol_7 = _lookupUnqualifiedClass;
                            }
                            else {
                                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
                                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
                                final List<PathElementCS> UNBOXED_qualifierSegments = qualifierSegments.asEcoreObjects(idResolver, PathElementCS.class);
                                assert UNBOXED_qualifierSegments != null;
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package qualifier = this.lookupPackage(symbol_2, UNBOXED_qualifierSegments);
                                /*@Caught*/ @Nullable Object CAUGHT_qualifier;
                                try {
                                    CAUGHT_qualifier = qualifier;
                                }
                                catch (Exception e) {
                                    CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                                }
                                final /*@NonInvalid*/ @NonNull Object symbol_6 = CAUGHT_qualifier == null;
                                /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
                                if (symbol_6 == Boolean.TRUE) {
                                    safe_lookupQualifiedClass_source = null;
                                }
                                else {
                                    if (qualifier == null) {
                                        throw throwNull(lClassCS, "Null where non-null value required");
                                    }
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                                    if (aPathElementCS_0 == null) {
                                        throw throwNull(lClassCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                                    }
                                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName_0 = aPathElementCS_0.getPathName();
                                    MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Class> _lookupResult_0 = lookupSolver._lookupQualifiedClass(qualifier, (String)pathName_0);
                                    org.eclipse.qvtd.doc.miniocl.Class _lookupQualifiedClass = null;
                                    if (_lookupResult_0.size() == 1) {
                                        _lookupQualifiedClass = _lookupResult_0.getSingleResult();
                                    } else {
                                        handleLookupError(aPathElementCS_0,pathName_0);
                                    };
                                    safe_lookupQualifiedClass_source = _lookupQualifiedClass;
                                }
                                symbol_7 = safe_lookupQualifiedClass_source;
                            }
                            symbol_8 = symbol_7;
                        }
                        final /*@Thrown*/ boolean symbol_9 = symbol_8 != null;
                        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_superClass;
                        if (symbol_9) {
                            if (symbol_8 == null) {
                                throw throwNull(lClassCS, "Null where non-null value required");
                            }
                            // property assignments
                            symbol_2.setSuperClass(symbol_8);
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_ClassCS_ast_extends = ValueUtil.TRUE_VALUE;
                            raw_superClass = m_ClassCS_ast_extends;
                        }
                        else {
                            raw_superClass = ValueUtil.FALSE_VALUE;
                        }
                        raw_ast = raw_superClass;
                    }
                    else {
                        raw_ast = ValueUtil.FALSE_VALUE;
                    }
                    symbol_11 = raw_ast;
                }
                else {
                    symbol_11 = ValueUtil.FALSE_VALUE;
                }
                raw_aClass = symbol_11;
            }
            else {
                raw_aClass = ValueUtil.FALSE_VALUE;
            }
            return raw_aClass;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_ClassCS_ast_extends", e);
        }
    }
    
    /**
     * 
     * map m_Class_ClassCS in MiniOCLCS2AS_qvtp_qvtcas {leftCS (lClassCS : minioclcs::ClassCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize rClass : miniocl::Class[1];
     *  |}
     * where ( |)
     * { |
     * lClassCS.ast := rClass;
     * }
     * 
     */
    protected boolean MAP_m_Class_ClassCS(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ClassCS lClassCS_0)  {
        try {
            // predicates and unrealized variables
            // creations
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class rClass = MiniOCLFactory.eINSTANCE.createClass();
            assert rClass != null;
            models[1/*rightAS*/].add(rClass);
            // property assignments
            lClassCS_0.setAst(rClass);
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Class_ClassCS = ValueUtil.TRUE_VALUE;
            return m_Class_ClassCS;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_Class_ClassCS", e);
        }
    }
    
    /**
     * 
     * map m_NameExpCS_ast in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lNameExpCS : minioclcs::NameExpCS[1];
     *  |)
     * {_'if' : minioclcs::CallExpCS[?];
     * parentAsCallExpCS : minioclcs::CallExpCS[?];
     *  |}
     * rightAS ( |)
     * {aPropertyCallExp : miniocl::PropertyCallExp[1];
     * ast : miniocl::Element[1];
     * if1 : miniocl::Element[?];
     * ownedSource : miniocl::OCLExpression[1];
     *  |}
     * where ( |
     * lNameExpCS.isPropCallExpWithExplicitSource()
     *   )
     * {_'=' : Boolean[1];
     * _'=1' : Boolean[1];
     * _'=2' : Boolean[1];
     *  |
     * aPropertyCallExp := lNameExpCS.ast;
     * ast := lNameExpCS.ast;
     * parentAsCallExpCS := lNameExpCS.parentAsCallExpCS();
     * _'=' := parentAsCallExpCS =
     *   null;
     * _'if' := if _'='
     *   then null
     *   else parentAsCallExpCS.source
     *   endif;
     * _'=1' := _'if' =
     *   null;
     * if1 := if _'=1'
     *   then null
     *   else _'if'.ast
     *   endif;
     * _'=2' := if1 =
     *   null;
     * ownedSource := if _'=2'
     *   then null
     *   else if1.oclAsType(miniocl::OCLExpression)
     *   endif;
     * aPropertyCallExp.ownedSource := ownedSource;
     * }
     * 
     */
    protected boolean MAP_m_NameExpCS_ast(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS)  {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            /*@Caught*/ @NonNull Object CAUGHT_eq;
            try {
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS.getRoundedBrackets();
                final /*@Thrown*/ boolean eq = roundedBrackets == null;
                CAUGHT_eq = eq;
            }
            catch (Exception e) {
                CAUGHT_eq = ValueUtil.createInvalidValue(e);
            }
            /*@Caught*/ @NonNull Object CAUGHT_symbol_1;
            try {
                final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS);
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
                final /*@Thrown*/ boolean eq_0 = symbol_0 == null;
                /*@Thrown*/ boolean symbol_1;
                if (eq_0) {
                    symbol_1 = ValueUtil.FALSE_VALUE;
                }
                else {
                    if (symbol_0 == null) {
                        throw throwNull(lNameExpCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp = symbol_0.getNameExp();
                    final /*@Thrown*/ boolean eq_1 = lNameExpCS.equals(nameExp);
                    symbol_1 = eq_1;
                }
                CAUGHT_symbol_1 = symbol_1;
            }
            catch (Exception e) {
                CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_1);
            if (and == null) {
                throw throwNull(lNameExpCS, "Null if condition");
            }
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_16;
            if (and) {
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lNameExpCS.getAst();
                final /*@Thrown*/ boolean symbol_2 = ast != null;
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aPropertyCallExp;
                if (symbol_2) {
                    final /*@NonInvalid*/ boolean symbol_3 = ast instanceof PropertyCallExp;
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_15;
                    if (symbol_3) {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable PropertyCallExp symbol_4 = (PropertyCallExp)ast;
                        if (symbol_4 == null) {
                            throw throwNull(lNameExpCS, "Null where non-null value required");
                        }
                        final /*@Thrown*/ boolean symbol_5 = ast != null;
                        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                        if (symbol_5) {
                            if (ast == null) {
                                throw throwNull(lNameExpCS, "Null where non-null value required");
                            }
                            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS);
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_CallExpCS_4 = idResolver.getClass(CLSSid_CallExpCS, null);
                            final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, container_0, TYP_minioclcs_c_c_CallExpCS_4).booleanValue();
                            /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS symbol_6;
                            if (oclIsKindOf_0) {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CallExpCS oclAsType_0 = ClassUtil.nonNullState((CallExpCS)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container_0, TYP_minioclcs_c_c_CallExpCS_4));
                                symbol_6 = oclAsType_0;
                            }
                            else {
                                symbol_6 = null;
                            }
                            final /*@Thrown*/ boolean symbol_7 = symbol_6 == null;
                            /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS symbol_8;
                            if (symbol_7) {
                                symbol_8 = null;
                            }
                            else {
                                if (symbol_6 == null) {
                                    throw throwNull(lNameExpCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::source\'");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS source = symbol_6.getSource();
                                symbol_8 = source;
                            }
                            final /*@Thrown*/ boolean symbol_9 = symbol_8 == null;
                            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element symbol_10;
                            if (symbol_9) {
                                symbol_10 = null;
                            }
                            else {
                                if (symbol_8 == null) {
                                    throw throwNull(lNameExpCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CSTrace::ast\'");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast_1 = symbol_8.getAst();
                                symbol_10 = ast_1;
                            }
                            final /*@Thrown*/ boolean symbol_11 = symbol_10 == null;
                            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable OCLExpression symbol_12;
                            if (symbol_11) {
                                symbol_12 = null;
                            }
                            else {
                                final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_OCLExpression_0 = idResolver.getClass(CLSSid_OCLExpression, null);
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull OCLExpression oclAsType_1 = ClassUtil.nonNullState((OCLExpression)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, symbol_10, TYP_miniocl_c_c_OCLExpression_0));
                                symbol_12 = oclAsType_1;
                            }
                            final /*@Thrown*/ boolean symbol_13 = symbol_12 != null;
                            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ownedSource;
                            if (symbol_13) {
                                if (symbol_12 == null) {
                                    throw throwNull(lNameExpCS, "Null where non-null value required");
                                }
                                // property assignments
                                symbol_4.setOwnedSource(symbol_12);
                                objectManager.assigned(symbol_4, MiniOCLPackage.Literals.CALL_EXP__OWNED_SOURCE, symbol_12, null);
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_NameExpCS_ast = ValueUtil.TRUE_VALUE;
                                raw_ownedSource = m_NameExpCS_ast;
                            }
                            else {
                                raw_ownedSource = ValueUtil.FALSE_VALUE;
                            }
                            raw_ast = raw_ownedSource;
                        }
                        else {
                            raw_ast = ValueUtil.FALSE_VALUE;
                        }
                        symbol_15 = raw_ast;
                    }
                    else {
                        symbol_15 = ValueUtil.FALSE_VALUE;
                    }
                    raw_aPropertyCallExp = symbol_15;
                }
                else {
                    raw_aPropertyCallExp = ValueUtil.FALSE_VALUE;
                }
                symbol_16 = raw_aPropertyCallExp;
            }
            else {
                symbol_16 = ValueUtil.FALSE_VALUE;
            }
            return symbol_16;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_NameExpCS_ast", e);
        }
    }
    
    /**
     * 
     * map m_NameExpCS_ast_1 in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lNameExpCS : minioclcs::NameExpCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {aPropertyCallExp : miniocl::PropertyCallExp[1];
     * ast : miniocl::Element[1];
     * lookupVariable : miniocl::Variable[?];
     * ownedSource : miniocl::OCLExpression[1];
     * type : miniocl::Class[1];
     *  |}
     * where ( |
     * not lNameExpCS.isPropCallExpWithExplicitSource()
     *   not lNameExpCS.isVariableExp()
     *   lNameExpCS.isPropCallExpWithImplicitSource()
     *   )
     * { |
     * aPropertyCallExp := lNameExpCS.ast;
     * ast := lNameExpCS.ast;
     * lookupVariable := aPropertyCallExp.lookupVariable('self')
     *   ;
     * type := lookupVariable.type;
     * ownedSource := miniocl::VariableExp{referredVariable = lookupVariable, type = type
     *   };
     * aPropertyCallExp.ownedSource := ownedSource;
     * }
     * 
     */
    protected boolean MAP_m_NameExpCS_ast_1(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_0)  {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
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
                final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_0);
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
                final /*@Thrown*/ boolean eq_0 = symbol_0 == null;
                /*@Thrown*/ boolean symbol_1;
                if (eq_0) {
                    symbol_1 = ValueUtil.FALSE_VALUE;
                }
                else {
                    if (symbol_0 == null) {
                        throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp = symbol_0.getNameExp();
                    final /*@Thrown*/ boolean eq_1 = lNameExpCS_0.equals(nameExp);
                    symbol_1 = eq_1;
                }
                CAUGHT_symbol_1 = symbol_1;
            }
            catch (Exception e) {
                CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_1);
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(and);
            if (not == null) {
                throw throwNull(lNameExpCS_0, "Null if condition");
            }
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_17;
            if (not) {
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
                            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_0);
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_CallExpCS_4 = idResolver.getClass(CLSSid_CallExpCS, null);
                            final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, container_0, TYP_minioclcs_c_c_CallExpCS_4).booleanValue();
                            /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS symbol_2;
                            if (oclIsKindOf_0) {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CallExpCS oclAsType_0 = ClassUtil.nonNullState((CallExpCS)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container_0, TYP_minioclcs_c_c_CallExpCS_4));
                                symbol_2 = oclAsType_0;
                            }
                            else {
                                symbol_2 = null;
                            }
                            final /*@Thrown*/ boolean eq_3 = symbol_2 == null;
                            /*@Thrown*/ boolean symbol_3;
                            if (eq_3) {
                                symbol_3 = ValueUtil.FALSE_VALUE;
                            }
                            else {
                                if (symbol_2 == null) {
                                    throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp_0 = symbol_2.getNameExp();
                                final /*@Thrown*/ boolean eq_4 = lNameExpCS_0.equals(nameExp_0);
                                symbol_3 = eq_4;
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(symbol_3);
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
                            throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                        }
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> path = expName.getPath();
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_path = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path);
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_path);
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
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element self_1 = lNameExpCS_0.getAst();
                    if (self_1 == null) {
                        throw throwNull(lNameExpCS_0, "Null where non-null value required");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName_0 = lNameExpCS_0.getExpName();
                    if (expName_0 == null) {
                        throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                    }
                    @SuppressWarnings("null")
                    final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> path_0 = expName_0.getPath();
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_path_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path_0);
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_path_0);
                    if (aPathElementCS == null) {
                        throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName = aPathElementCS.getPathName();
                    MiniOCLLookupResult<Variable> _lookupResult = lookupSolver._lookupUnqualifiedVariable(self_1, (String)pathName);
                    Variable _lookupUnqualifiedVariable = null;
                    if (_lookupResult.size() == 1) {
                        _lookupUnqualifiedVariable = _lookupResult.getSingleResult();
                    } else {
                        handleLookupError(aPathElementCS,pathName);
                    };
                    final /*@Thrown*/ boolean ne = _lookupUnqualifiedVariable != null;
                    CAUGHT_ne = ne;
                }
                catch (Exception e) {
                    CAUGHT_ne = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_1, CAUGHT_ne);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_1 = BooleanNotOperation.INSTANCE.evaluate(and_2);
                if (not_1 == null) {
                    throw throwNull(lNameExpCS_0, "Null if condition");
                }
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_16;
                if (not_1) {
                    /*@Caught*/ @Nullable Object CAUGHT_and_3;
                    try {
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
                            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container_1 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_0);
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_CallExpCS_6 = idResolver.getClass(CLSSid_CallExpCS, null);
                            final /*@Thrown*/ boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, container_1, TYP_minioclcs_c_c_CallExpCS_6).booleanValue();
                            /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS symbol_4;
                            if (oclIsKindOf_1) {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CallExpCS oclAsType_1 = ClassUtil.nonNullState((CallExpCS)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container_1, TYP_minioclcs_c_c_CallExpCS_6));
                                symbol_4 = oclAsType_1;
                            }
                            else {
                                symbol_4 = null;
                            }
                            final /*@Thrown*/ boolean eq_7 = symbol_4 == null;
                            /*@Thrown*/ boolean symbol_5;
                            if (eq_7) {
                                symbol_5 = ValueUtil.FALSE_VALUE;
                            }
                            else {
                                if (symbol_4 == null) {
                                    throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp_1 = symbol_4.getNameExp();
                                final /*@Thrown*/ boolean eq_8 = lNameExpCS_0.equals(nameExp_1);
                                symbol_5 = eq_8;
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_2 = BooleanNotOperation.INSTANCE.evaluate(symbol_5);
                            CAUGHT_not_2 = not_2;
                        }
                        catch (Exception e) {
                            CAUGHT_not_2 = ValueUtil.createInvalidValue(e);
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_3 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_6, CAUGHT_not_2);
                        CAUGHT_and_3 = and_3;
                    }
                    catch (Exception e) {
                        CAUGHT_and_3 = ValueUtil.createInvalidValue(e);
                    }
                    /*@Caught*/ @NonNull Object CAUGHT_eq_9;
                    try {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element self_2 = lNameExpCS_0.getAst();
                        if (self_2 == null) {
                            throw throwNull(lNameExpCS_0, "Null where non-null value required");
                        }
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName_1 = lNameExpCS_0.getExpName();
                        if (expName_1 == null) {
                            throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                        }
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> path_1 = expName_1.getPath();
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_path_1 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path_1);
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_path_1);
                        if (aPathElementCS_0 == null) {
                            throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName_0 = aPathElementCS_0.getPathName();
                        MiniOCLLookupResult<Variable> _lookupResult_0 = lookupSolver._lookupUnqualifiedVariable(self_2, (String)pathName_0);
                        Variable _lookupUnqualifiedVariable_0 = null;
                        if (_lookupResult_0.size() == 1) {
                            _lookupUnqualifiedVariable_0 = _lookupResult_0.getSingleResult();
                        } else {
                            handleLookupError(aPathElementCS_0,pathName_0);
                        };
                        final /*@Thrown*/ boolean eq_9 = _lookupUnqualifiedVariable_0 == null;
                        CAUGHT_eq_9 = eq_9;
                    }
                    catch (Exception e) {
                        CAUGHT_eq_9 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_4 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_3, CAUGHT_eq_9);
                    if (and_4 == null) {
                        throw throwNull(lNameExpCS_0, "Null if condition");
                    }
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_15;
                    if (and_4) {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lNameExpCS_0.getAst();
                        final /*@Thrown*/ boolean symbol_6 = ast != null;
                        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aPropertyCallExp;
                        if (symbol_6) {
                            final /*@NonInvalid*/ boolean symbol_7 = ast instanceof PropertyCallExp;
                            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_14;
                            if (symbol_7) {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable PropertyCallExp symbol_8 = (PropertyCallExp)ast;
                                if (symbol_8 == null) {
                                    throw throwNull(lNameExpCS_0, "Null where non-null value required");
                                }
                                final /*@Thrown*/ boolean symbol_9 = ast != null;
                                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                                if (symbol_9) {
                                    if (ast == null) {
                                        throw throwNull(lNameExpCS_0, "Null where non-null value required");
                                    }
                                    MiniOCLLookupResult<Variable> _lookupResult_1 = lookupSolver._lookupUnqualifiedVariable(symbol_8, STR_self);
                                    Variable _lookupUnqualifiedVariable_1 = null;
                                    if (_lookupResult_1.size() == 1) {
                                        _lookupUnqualifiedVariable_1 = _lookupResult_1.getSingleResult();
                                    } else {
                                    };
                                    if (_lookupUnqualifiedVariable_1 == null) {
                                        throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/1.0\'::TypedElement::type\'");
                                    }
                                    @SuppressWarnings("null")
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class type = _lookupUnqualifiedVariable_1.getType();
                                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property CTORid_referredVariable = idResolver.getProperty(PROPid_referredVariable);
                                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property CTORid_type = idResolver.getProperty(PROPid_type);
                                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_VariableExp_0 = idResolver.getClass(CLSSid_VariableExp, null);
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull VariableExp symbol_12 = (VariableExp)TYP_miniocl_c_c_VariableExp_0.createInstance();
                                    CTORid_referredVariable.initValue(symbol_12, _lookupUnqualifiedVariable_1);
                                    CTORid_type.initValue(symbol_12, type);
                                    models[1/*rightAS*/].add(symbol_12);
                                    // property assignments
                                    symbol_8.setOwnedSource(symbol_12);
                                    objectManager.assigned(symbol_8, MiniOCLPackage.Literals.CALL_EXP__OWNED_SOURCE, symbol_12, null);
                                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_NameExpCS_ast_1 = ValueUtil.TRUE_VALUE;
                                    raw_ast = m_NameExpCS_ast_1;
                                }
                                else {
                                    raw_ast = ValueUtil.FALSE_VALUE;
                                }
                                symbol_14 = raw_ast;
                            }
                            else {
                                symbol_14 = ValueUtil.FALSE_VALUE;
                            }
                            raw_aPropertyCallExp = symbol_14;
                        }
                        else {
                            raw_aPropertyCallExp = ValueUtil.FALSE_VALUE;
                        }
                        symbol_15 = raw_aPropertyCallExp;
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
            return symbol_17;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_NameExpCS_ast_1", e);
        }
    }
    
    /**
     * 
     * map m_NameExpCS_ast_2 in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lNameExpCS : minioclcs::NameExpCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {aVariableExp : miniocl::VariableExp[1];
     * ast : miniocl::Element[1];
     * referredVariable : miniocl::Variable[1];
     * type : miniocl::Class[1];
     *  |}
     * where ( |
     * lNameExpCS.isVariableExp()
     *   not lNameExpCS.isPropCallExpWithExplicitSource())
     * { |
     * aVariableExp := lNameExpCS.ast;
     * ast := lNameExpCS.ast;
     * referredVariable := aVariableExp.referredVariable;
     * type := referredVariable.type;
     * aVariableExp.type := type;
     * }
     * 
     */
    protected boolean MAP_m_NameExpCS_ast_2(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_1)  {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            /*@Caught*/ @Nullable Object CAUGHT_and_0;
            try {
                /*@Caught*/ @Nullable Object CAUGHT_and;
                try {
                    /*@Caught*/ @NonNull Object CAUGHT_eq;
                    try {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_1.getRoundedBrackets();
                        final /*@Thrown*/ boolean eq = roundedBrackets == null;
                        CAUGHT_eq = eq;
                    }
                    catch (Exception e) {
                        CAUGHT_eq = ValueUtil.createInvalidValue(e);
                    }
                    /*@Caught*/ @Nullable Object CAUGHT_not;
                    try {
                        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_1);
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
                        final /*@Thrown*/ boolean eq_0 = symbol_0 == null;
                        /*@Thrown*/ boolean symbol_1;
                        if (eq_0) {
                            symbol_1 = ValueUtil.FALSE_VALUE;
                        }
                        else {
                            if (symbol_0 == null) {
                                throw throwNull(lNameExpCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                            }
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp = symbol_0.getNameExp();
                            final /*@Thrown*/ boolean eq_1 = lNameExpCS_1.equals(nameExp);
                            symbol_1 = eq_1;
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(symbol_1);
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
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName = lNameExpCS_1.getExpName();
                    if (expName == null) {
                        throw throwNull(lNameExpCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                    }
                    @SuppressWarnings("null")
                    final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> path = expName.getPath();
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_path = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path);
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_path);
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
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element self_1 = lNameExpCS_1.getAst();
                if (self_1 == null) {
                    throw throwNull(lNameExpCS_1, "Null where non-null value required");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName_0 = lNameExpCS_1.getExpName();
                if (expName_0 == null) {
                    throw throwNull(lNameExpCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> path_0 = expName_0.getPath();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_path_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path_0);
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_path_0);
                if (aPathElementCS == null) {
                    throw throwNull(lNameExpCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName = aPathElementCS.getPathName();
                MiniOCLLookupResult<Variable> _lookupResult = lookupSolver._lookupUnqualifiedVariable(self_1, (String)pathName);
                Variable _lookupUnqualifiedVariable = null;
                if (_lookupResult.size() == 1) {
                    _lookupUnqualifiedVariable = _lookupResult.getSingleResult();
                } else {
                    handleLookupError(aPathElementCS,pathName);
                };
                final /*@Thrown*/ boolean ne = _lookupUnqualifiedVariable != null;
                CAUGHT_ne = ne;
            }
            catch (Exception e) {
                CAUGHT_ne = ValueUtil.createInvalidValue(e);
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_0, CAUGHT_ne);
            if (and_1 == null) {
                throw throwNull(lNameExpCS_1, "Null if condition");
            }
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_11;
            if (and_1) {
                /*@Caught*/ @NonNull Object CAUGHT_eq_3;
                try {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_1.getRoundedBrackets();
                    final /*@Thrown*/ boolean eq_3 = roundedBrackets_0 == null;
                    CAUGHT_eq_3 = eq_3;
                }
                catch (Exception e) {
                    CAUGHT_eq_3 = ValueUtil.createInvalidValue(e);
                }
                /*@Caught*/ @NonNull Object CAUGHT_symbol_3;
                try {
                    final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_1);
                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_CallExpCS_4 = idResolver.getClass(CLSSid_CallExpCS, null);
                    final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, container_0, TYP_minioclcs_c_c_CallExpCS_4).booleanValue();
                    /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS symbol_2;
                    if (oclIsKindOf_0) {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CallExpCS oclAsType_0 = ClassUtil.nonNullState((CallExpCS)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container_0, TYP_minioclcs_c_c_CallExpCS_4));
                        symbol_2 = oclAsType_0;
                    }
                    else {
                        symbol_2 = null;
                    }
                    final /*@Thrown*/ boolean eq_4 = symbol_2 == null;
                    /*@Thrown*/ boolean symbol_3;
                    if (eq_4) {
                        symbol_3 = ValueUtil.FALSE_VALUE;
                    }
                    else {
                        if (symbol_2 == null) {
                            throw throwNull(lNameExpCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                        }
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp_0 = symbol_2.getNameExp();
                        final /*@Thrown*/ boolean eq_5 = lNameExpCS_1.equals(nameExp_0);
                        symbol_3 = eq_5;
                    }
                    CAUGHT_symbol_3 = symbol_3;
                }
                catch (Exception e) {
                    CAUGHT_symbol_3 = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_3, CAUGHT_symbol_3);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(and_2);
                if (not_0 == null) {
                    throw throwNull(lNameExpCS_1, "Null if condition");
                }
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_10;
                if (not_0) {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lNameExpCS_1.getAst();
                    final /*@Thrown*/ boolean symbol_4 = ast != null;
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aVariableExp;
                    if (symbol_4) {
                        final /*@NonInvalid*/ boolean symbol_5 = ast instanceof VariableExp;
                        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_9;
                        if (symbol_5) {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable VariableExp symbol_6 = (VariableExp)ast;
                            if (symbol_6 == null) {
                                throw throwNull(lNameExpCS_1, "Null where non-null value required");
                            }
                            final /*@Thrown*/ boolean symbol_7 = ast != null;
                            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                            if (symbol_7) {
                                if (ast == null) {
                                    throw throwNull(lNameExpCS_1, "Null where non-null value required");
                                }
                                @SuppressWarnings("null")
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Variable referredVariable = symbol_6.getReferredVariable();
                                @SuppressWarnings("null")
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class type = referredVariable.getType();
                                // property assignments
                                symbol_6.setType(type);
                                objectManager.assigned(symbol_6, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, type, null);
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_NameExpCS_ast_2 = ValueUtil.TRUE_VALUE;
                                raw_ast = m_NameExpCS_ast_2;
                            }
                            else {
                                raw_ast = ValueUtil.FALSE_VALUE;
                            }
                            symbol_9 = raw_ast;
                        }
                        else {
                            symbol_9 = ValueUtil.FALSE_VALUE;
                        }
                        raw_aVariableExp = symbol_9;
                    }
                    else {
                        raw_aVariableExp = ValueUtil.FALSE_VALUE;
                    }
                    symbol_10 = raw_aVariableExp;
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
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_NameExpCS_ast_2", e);
        }
    }
    
    /**
     * 
     * map m_NameExpCS_ast_3 in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lNameExpCS : minioclcs::NameExpCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {aPropertyCallExp : miniocl::PropertyCallExp[1];
     * ast : miniocl::Element[1];
     * referredProperty : miniocl::Property[1];
     * type : miniocl::Class[1];
     *  |}
     * where ( |
     * not lNameExpCS.isPropCallExpWithExplicitSource()
     *   lNameExpCS.isPropCallExpWithImplicitSource()
     *   not lNameExpCS.isVariableExp())
     * {_'=' : Boolean[1];
     *  |
     * aPropertyCallExp := lNameExpCS.ast;
     * ast := lNameExpCS.ast;
     * referredProperty := aPropertyCallExp.referredProperty;
     * _'=' := referredProperty =
     *   null;
     * type := if _'='
     *   then null
     *   else referredProperty.type
     *   endif;
     * aPropertyCallExp.type := type;
     * }
     * 
     */
    protected class MAP_m_NameExpCS_ast_3 extends AbstractInvocation
    {
        protected final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_2;
        
        public MAP_m_NameExpCS_ast_3(@NonNull Object @NonNull [] boundValues) {
            lNameExpCS_2 = (NameExpCS)boundValues[0];
        }
        
        public boolean execute()  {
            try {
                // predicates and unrealized variables
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
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
                    final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_2);
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
                    final /*@Thrown*/ boolean eq_0 = symbol_0 == null;
                    /*@Thrown*/ boolean symbol_1;
                    if (eq_0) {
                        symbol_1 = ValueUtil.FALSE_VALUE;
                    }
                    else {
                        if (symbol_0 == null) {
                            throw throwNull(lNameExpCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                        }
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp = symbol_0.getNameExp();
                        final /*@Thrown*/ boolean eq_1 = lNameExpCS_2.equals(nameExp);
                        symbol_1 = eq_1;
                    }
                    CAUGHT_symbol_1 = symbol_1;
                }
                catch (Exception e) {
                    CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_1);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(and);
                if (not == null) {
                    throw throwNull(lNameExpCS_2, "Null if condition");
                }
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_14;
                if (not) {
                    /*@Caught*/ @Nullable Object CAUGHT_and_0;
                    try {
                        /*@Caught*/ @NonNull Object CAUGHT_eq_2;
                        try {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_2.getRoundedBrackets();
                            final /*@Thrown*/ boolean eq_2 = roundedBrackets_0 == null;
                            CAUGHT_eq_2 = eq_2;
                        }
                        catch (Exception e) {
                            CAUGHT_eq_2 = ValueUtil.createInvalidValue(e);
                        }
                        /*@Caught*/ @Nullable Object CAUGHT_not_0;
                        try {
                            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_2);
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_CallExpCS_4 = idResolver.getClass(CLSSid_CallExpCS, null);
                            final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, container_0, TYP_minioclcs_c_c_CallExpCS_4).booleanValue();
                            /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS symbol_2;
                            if (oclIsKindOf_0) {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CallExpCS oclAsType_0 = ClassUtil.nonNullState((CallExpCS)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container_0, TYP_minioclcs_c_c_CallExpCS_4));
                                symbol_2 = oclAsType_0;
                            }
                            else {
                                symbol_2 = null;
                            }
                            final /*@Thrown*/ boolean eq_3 = symbol_2 == null;
                            /*@Thrown*/ boolean symbol_3;
                            if (eq_3) {
                                symbol_3 = ValueUtil.FALSE_VALUE;
                            }
                            else {
                                if (symbol_2 == null) {
                                    throw throwNull(lNameExpCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp_0 = symbol_2.getNameExp();
                                final /*@Thrown*/ boolean eq_4 = lNameExpCS_2.equals(nameExp_0);
                                symbol_3 = eq_4;
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(symbol_3);
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
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element self_1 = lNameExpCS_2.getAst();
                        if (self_1 == null) {
                            throw throwNull(lNameExpCS_2, "Null where non-null value required");
                        }
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName = lNameExpCS_2.getExpName();
                        if (expName == null) {
                            throw throwNull(lNameExpCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                        }
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> path = expName.getPath();
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_path = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path);
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_path);
                        if (aPathElementCS == null) {
                            throw throwNull(lNameExpCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName = aPathElementCS.getPathName();
                        MiniOCLLookupResult<Variable> _lookupResult = lookupSolver._lookupUnqualifiedVariable(self_1, (String)pathName);
                        Variable _lookupUnqualifiedVariable = null;
                        if (_lookupResult.size() == 1) {
                            _lookupUnqualifiedVariable = _lookupResult.getSingleResult();
                        } else {
                            handleLookupError(aPathElementCS,pathName);
                        };
                        final /*@Thrown*/ boolean eq_5 = _lookupUnqualifiedVariable == null;
                        CAUGHT_eq_5 = eq_5;
                    }
                    catch (Exception e) {
                        CAUGHT_eq_5 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_0, CAUGHT_eq_5);
                    if (and_1 == null) {
                        throw throwNull(lNameExpCS_2, "Null if condition");
                    }
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_13;
                    if (and_1) {
                        /*@Caught*/ @Nullable Object CAUGHT_and_3;
                        try {
                            /*@Caught*/ @Nullable Object CAUGHT_and_2;
                            try {
                                /*@Caught*/ @NonNull Object CAUGHT_eq_6;
                                try {
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets_1 = lNameExpCS_2.getRoundedBrackets();
                                    final /*@Thrown*/ boolean eq_6 = roundedBrackets_1 == null;
                                    CAUGHT_eq_6 = eq_6;
                                }
                                catch (Exception e) {
                                    CAUGHT_eq_6 = ValueUtil.createInvalidValue(e);
                                }
                                /*@Caught*/ @Nullable Object CAUGHT_not_1;
                                try {
                                    final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container_1 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_2);
                                    final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_CallExpCS_6 = idResolver.getClass(CLSSid_CallExpCS, null);
                                    final /*@Thrown*/ boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, container_1, TYP_minioclcs_c_c_CallExpCS_6).booleanValue();
                                    /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS symbol_4;
                                    if (oclIsKindOf_1) {
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CallExpCS oclAsType_1 = ClassUtil.nonNullState((CallExpCS)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container_1, TYP_minioclcs_c_c_CallExpCS_6));
                                        symbol_4 = oclAsType_1;
                                    }
                                    else {
                                        symbol_4 = null;
                                    }
                                    final /*@Thrown*/ boolean eq_7 = symbol_4 == null;
                                    /*@Thrown*/ boolean symbol_5;
                                    if (eq_7) {
                                        symbol_5 = ValueUtil.FALSE_VALUE;
                                    }
                                    else {
                                        if (symbol_4 == null) {
                                            throw throwNull(lNameExpCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                                        }
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp_1 = symbol_4.getNameExp();
                                        final /*@Thrown*/ boolean eq_8 = lNameExpCS_2.equals(nameExp_1);
                                        symbol_5 = eq_8;
                                    }
                                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_1 = BooleanNotOperation.INSTANCE.evaluate(symbol_5);
                                    CAUGHT_not_1 = not_1;
                                }
                                catch (Exception e) {
                                    CAUGHT_not_1 = ValueUtil.createInvalidValue(e);
                                }
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_6, CAUGHT_not_1);
                                CAUGHT_and_2 = and_2;
                            }
                            catch (Exception e) {
                                CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
                            }
                            /*@Caught*/ @NonNull Object CAUGHT_eq_9;
                            try {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName_0 = lNameExpCS_2.getExpName();
                                if (expName_0 == null) {
                                    throw throwNull(lNameExpCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                                }
                                @SuppressWarnings("null")
                                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> path_0 = expName_0.getPath();
                                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_path_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path_0);
                                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_path_0);
                                final /*@Thrown*/ boolean eq_9 = size.equals(INT_1);
                                CAUGHT_eq_9 = eq_9;
                            }
                            catch (Exception e) {
                                CAUGHT_eq_9 = ValueUtil.createInvalidValue(e);
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_3 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_2, CAUGHT_eq_9);
                            CAUGHT_and_3 = and_3;
                        }
                        catch (Exception e) {
                            CAUGHT_and_3 = ValueUtil.createInvalidValue(e);
                        }
                        /*@Caught*/ @NonNull Object CAUGHT_ne;
                        try {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element self_2 = lNameExpCS_2.getAst();
                            if (self_2 == null) {
                                throw throwNull(lNameExpCS_2, "Null where non-null value required");
                            }
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName_1 = lNameExpCS_2.getExpName();
                            if (expName_1 == null) {
                                throw throwNull(lNameExpCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                            }
                            @SuppressWarnings("null")
                            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> path_1 = expName_1.getPath();
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_path_1 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path_1);
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_path_1);
                            if (aPathElementCS_0 == null) {
                                throw throwNull(lNameExpCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName_0 = aPathElementCS_0.getPathName();
                            MiniOCLLookupResult<Variable> _lookupResult_0 = lookupSolver._lookupUnqualifiedVariable(self_2, (String)pathName_0);
                            Variable _lookupUnqualifiedVariable_0 = null;
                            if (_lookupResult_0.size() == 1) {
                                _lookupUnqualifiedVariable_0 = _lookupResult_0.getSingleResult();
                            } else {
                                handleLookupError(aPathElementCS_0,pathName_0);
                            };
                            final /*@Thrown*/ boolean ne = _lookupUnqualifiedVariable_0 != null;
                            CAUGHT_ne = ne;
                        }
                        catch (Exception e) {
                            CAUGHT_ne = ValueUtil.createInvalidValue(e);
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_4 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_3, CAUGHT_ne);
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_2 = BooleanNotOperation.INSTANCE.evaluate(and_4);
                        if (not_2 == null) {
                            throw throwNull(lNameExpCS_2, "Null if condition");
                        }
                        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_12;
                        if (not_2) {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lNameExpCS_2.getAst();
                            final /*@Thrown*/ boolean symbol_6 = ast != null;
                            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aPropertyCallExp;
                            if (symbol_6) {
                                final /*@NonInvalid*/ boolean symbol_7 = ast instanceof PropertyCallExp;
                                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_11;
                                if (symbol_7) {
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable PropertyCallExp symbol_8 = (PropertyCallExp)ast;
                                    if (symbol_8 == null) {
                                        throw throwNull(lNameExpCS_2, "Null where non-null value required");
                                    }
                                    final /*@Thrown*/ boolean symbol_9 = ast != null;
                                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                                    if (symbol_9) {
                                        if (ast == null) {
                                            throw throwNull(lNameExpCS_2, "Null where non-null value required");
                                        }
                                        objectManager.getting(symbol_8, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, false);
                                        @SuppressWarnings("null")
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Property referredProperty = symbol_8.getReferredProperty();
                                        @SuppressWarnings("null")
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class type = referredProperty.getType();
                                        // property assignments
                                        symbol_8.setType(type);
                                        objectManager.assigned(symbol_8, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, type, null);
                                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_NameExpCS_ast_3 = ValueUtil.TRUE_VALUE;
                                        raw_ast = m_NameExpCS_ast_3;
                                    }
                                    else {
                                        raw_ast = ValueUtil.FALSE_VALUE;
                                    }
                                    symbol_11 = raw_ast;
                                }
                                else {
                                    symbol_11 = ValueUtil.FALSE_VALUE;
                                }
                                raw_aPropertyCallExp = symbol_11;
                            }
                            else {
                                raw_aPropertyCallExp = ValueUtil.FALSE_VALUE;
                            }
                            symbol_12 = raw_aPropertyCallExp;
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
                return symbol_14;
            } catch (Throwable e) {
                return handleExecutionFailure("MAP_m_NameExpCS_ast_3", e);
            }
        }
        
        public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
            return idResolver.oclEquals(lNameExpCS_2, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map m_NameExpCS_ast_4 in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lNameExpCS : minioclcs::NameExpCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {aPropertyCallExp : miniocl::PropertyCallExp[1];
     * ast : miniocl::Element[1];
     * referredProperty : miniocl::Property[1];
     * type : miniocl::Class[1];
     *  |}
     * where ( |
     * lNameExpCS.isPropCallExpWithExplicitSource())
     * {_'=' : Boolean[1];
     *  |
     * aPropertyCallExp := lNameExpCS.ast;
     * ast := lNameExpCS.ast;
     * referredProperty := aPropertyCallExp.referredProperty;
     * _'=' := referredProperty =
     *   null;
     * type := if _'='
     *   then null
     *   else referredProperty.type
     *   endif;
     * aPropertyCallExp.type := type;
     * }
     * 
     */
    protected class MAP_m_NameExpCS_ast_4 extends AbstractInvocation
    {
        protected final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_3;
        
        public MAP_m_NameExpCS_ast_4(@NonNull Object @NonNull [] boundValues) {
            lNameExpCS_3 = (NameExpCS)boundValues[0];
        }
        
        public boolean execute()  {
            try {
                // predicates and unrealized variables
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
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
                    final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_3);
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
                    final /*@Thrown*/ boolean eq_0 = symbol_0 == null;
                    /*@Thrown*/ boolean symbol_1;
                    if (eq_0) {
                        symbol_1 = ValueUtil.FALSE_VALUE;
                    }
                    else {
                        if (symbol_0 == null) {
                            throw throwNull(lNameExpCS_3, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                        }
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp = symbol_0.getNameExp();
                        final /*@Thrown*/ boolean eq_1 = lNameExpCS_3.equals(nameExp);
                        symbol_1 = eq_1;
                    }
                    CAUGHT_symbol_1 = symbol_1;
                }
                catch (Exception e) {
                    CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_1);
                if (and == null) {
                    throw throwNull(lNameExpCS_3, "Null if condition");
                }
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_8;
                if (and) {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lNameExpCS_3.getAst();
                    final /*@Thrown*/ boolean symbol_2 = ast != null;
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aPropertyCallExp;
                    if (symbol_2) {
                        final /*@NonInvalid*/ boolean symbol_3 = ast instanceof PropertyCallExp;
                        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_7;
                        if (symbol_3) {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable PropertyCallExp symbol_4 = (PropertyCallExp)ast;
                            if (symbol_4 == null) {
                                throw throwNull(lNameExpCS_3, "Null where non-null value required");
                            }
                            final /*@Thrown*/ boolean symbol_5 = ast != null;
                            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                            if (symbol_5) {
                                if (ast == null) {
                                    throw throwNull(lNameExpCS_3, "Null where non-null value required");
                                }
                                objectManager.getting(symbol_4, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, false);
                                @SuppressWarnings("null")
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Property referredProperty = symbol_4.getReferredProperty();
                                @SuppressWarnings("null")
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class type = referredProperty.getType();
                                // property assignments
                                symbol_4.setType(type);
                                objectManager.assigned(symbol_4, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, type, null);
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_NameExpCS_ast_4 = ValueUtil.TRUE_VALUE;
                                raw_ast = m_NameExpCS_ast_4;
                            }
                            else {
                                raw_ast = ValueUtil.FALSE_VALUE;
                            }
                            symbol_7 = raw_ast;
                        }
                        else {
                            symbol_7 = ValueUtil.FALSE_VALUE;
                        }
                        raw_aPropertyCallExp = symbol_7;
                    }
                    else {
                        raw_aPropertyCallExp = ValueUtil.FALSE_VALUE;
                    }
                    symbol_8 = raw_aPropertyCallExp;
                }
                else {
                    symbol_8 = ValueUtil.FALSE_VALUE;
                }
                return symbol_8;
            } catch (Throwable e) {
                return handleExecutionFailure("MAP_m_NameExpCS_ast_4", e);
            }
        }
        
        public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
            return idResolver.oclEquals(lNameExpCS_3, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map m_NameExpCS_ast_expName in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lNameExpCS : minioclcs::NameExpCS[1];
     *  |)
     * {expName : minioclcs::PathNameCS[?];
     * first : minioclcs::PathElementCS[?];
     * path : OrderedSet(minioclcs::PathElementCS)[*|1];
     *  |}
     * rightAS ( |)
     * {aVariableExp : miniocl::VariableExp[1];
     * ast : miniocl::Element[1];
     * referredVariable : miniocl::Variable[1];
     *  |}
     * where ( |
     * not lNameExpCS.isPropCallExpWithExplicitSource()
     *   lNameExpCS.isVariableExp()
     *   )
     * { |
     * aVariableExp := lNameExpCS.ast;
     * ast := lNameExpCS.ast;
     * expName := lNameExpCS.expName;
     * path := expName.path;
     * first := path->first()
     *   ;
     * referredVariable := aVariableExp.lookupVariable(first);
     * aVariableExp.referredVariable := referredVariable;
     * }
     * 
     */
    protected boolean MAP_m_NameExpCS_ast_expName(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_4)  {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            /*@Caught*/ @NonNull Object CAUGHT_eq;
            try {
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_4.getRoundedBrackets();
                final /*@Thrown*/ boolean eq = roundedBrackets == null;
                CAUGHT_eq = eq;
            }
            catch (Exception e) {
                CAUGHT_eq = ValueUtil.createInvalidValue(e);
            }
            /*@Caught*/ @NonNull Object CAUGHT_symbol_1;
            try {
                final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_4);
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
                final /*@Thrown*/ boolean eq_0 = symbol_0 == null;
                /*@Thrown*/ boolean symbol_1;
                if (eq_0) {
                    symbol_1 = ValueUtil.FALSE_VALUE;
                }
                else {
                    if (symbol_0 == null) {
                        throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp = symbol_0.getNameExp();
                    final /*@Thrown*/ boolean eq_1 = lNameExpCS_4.equals(nameExp);
                    symbol_1 = eq_1;
                }
                CAUGHT_symbol_1 = symbol_1;
            }
            catch (Exception e) {
                CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_1);
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(and);
            if (not == null) {
                throw throwNull(lNameExpCS_4, "Null if condition");
            }
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_12;
            if (not) {
                /*@Caught*/ @Nullable Object CAUGHT_and_1;
                try {
                    /*@Caught*/ @Nullable Object CAUGHT_and_0;
                    try {
                        /*@Caught*/ @NonNull Object CAUGHT_eq_2;
                        try {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_4.getRoundedBrackets();
                            final /*@Thrown*/ boolean eq_2 = roundedBrackets_0 == null;
                            CAUGHT_eq_2 = eq_2;
                        }
                        catch (Exception e) {
                            CAUGHT_eq_2 = ValueUtil.createInvalidValue(e);
                        }
                        /*@Caught*/ @Nullable Object CAUGHT_not_0;
                        try {
                            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_4);
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_CallExpCS_4 = idResolver.getClass(CLSSid_CallExpCS, null);
                            final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, container_0, TYP_minioclcs_c_c_CallExpCS_4).booleanValue();
                            /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS symbol_2;
                            if (oclIsKindOf_0) {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CallExpCS oclAsType_0 = ClassUtil.nonNullState((CallExpCS)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container_0, TYP_minioclcs_c_c_CallExpCS_4));
                                symbol_2 = oclAsType_0;
                            }
                            else {
                                symbol_2 = null;
                            }
                            final /*@Thrown*/ boolean eq_3 = symbol_2 == null;
                            /*@Thrown*/ boolean symbol_3;
                            if (eq_3) {
                                symbol_3 = ValueUtil.FALSE_VALUE;
                            }
                            else {
                                if (symbol_2 == null) {
                                    throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp_0 = symbol_2.getNameExp();
                                final /*@Thrown*/ boolean eq_4 = lNameExpCS_4.equals(nameExp_0);
                                symbol_3 = eq_4;
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(symbol_3);
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
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName = lNameExpCS_4.getExpName();
                        if (expName == null) {
                            throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                        }
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> path = expName.getPath();
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_path = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path);
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_path);
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
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element self_1 = lNameExpCS_4.getAst();
                    if (self_1 == null) {
                        throw throwNull(lNameExpCS_4, "Null where non-null value required");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName_0 = lNameExpCS_4.getExpName();
                    if (expName_0 == null) {
                        throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                    }
                    @SuppressWarnings("null")
                    final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> path_0 = expName_0.getPath();
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_path_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path_0);
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_path_0);
                    if (aPathElementCS == null) {
                        throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName = aPathElementCS.getPathName();
                    MiniOCLLookupResult<Variable> _lookupResult = lookupSolver._lookupUnqualifiedVariable(self_1, (String)pathName);
                    Variable _lookupUnqualifiedVariable = null;
                    if (_lookupResult.size() == 1) {
                        _lookupUnqualifiedVariable = _lookupResult.getSingleResult();
                    } else {
                        handleLookupError(aPathElementCS,pathName);
                    };
                    final /*@Thrown*/ boolean ne = _lookupUnqualifiedVariable != null;
                    CAUGHT_ne = ne;
                }
                catch (Exception e) {
                    CAUGHT_ne = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_1, CAUGHT_ne);
                if (and_2 == null) {
                    throw throwNull(lNameExpCS_4, "Null if condition");
                }
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_11;
                if (and_2) {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lNameExpCS_4.getAst();
                    final /*@Thrown*/ boolean symbol_4 = ast != null;
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aVariableExp;
                    if (symbol_4) {
                        final /*@NonInvalid*/ boolean symbol_5 = ast instanceof VariableExp;
                        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_10;
                        if (symbol_5) {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable VariableExp symbol_6 = (VariableExp)ast;
                            if (symbol_6 == null) {
                                throw throwNull(lNameExpCS_4, "Null where non-null value required");
                            }
                            final /*@Thrown*/ boolean symbol_7 = ast != null;
                            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                            if (symbol_7) {
                                if (ast == null) {
                                    throw throwNull(lNameExpCS_4, "Null where non-null value required");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName_1 = lNameExpCS_4.getExpName();
                                if (expName_1 == null) {
                                    throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                                }
                                @SuppressWarnings("null")
                                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> path_1 = expName_1.getPath();
                                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_path_1 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path_1);
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS first = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_path_1);
                                if (first == null) {
                                    throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                                }
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName_0 = first.getPathName();
                                MiniOCLLookupResult<Variable> _lookupResult_0 = lookupSolver._lookupUnqualifiedVariable(symbol_6, (String)pathName_0);
                                Variable _lookupUnqualifiedVariable_0 = null;
                                if (_lookupResult_0.size() == 1) {
                                    _lookupUnqualifiedVariable_0 = _lookupResult_0.getSingleResult();
                                } else {
                                    handleLookupError(first,pathName_0);
                                };
                                final /*@Thrown*/ boolean symbol_8 = _lookupUnqualifiedVariable_0 != null;
                                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_referredVariable;
                                if (symbol_8) {
                                    if (_lookupUnqualifiedVariable_0 == null) {
                                        throw throwNull(lNameExpCS_4, "Null where non-null value required");
                                    }
                                    // property assignments
                                    symbol_6.setReferredVariable(_lookupUnqualifiedVariable_0);
                                    objectManager.assigned(symbol_6, MiniOCLPackage.Literals.VARIABLE_EXP__REFERRED_VARIABLE, _lookupUnqualifiedVariable_0, null);
                                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_NameExpCS_ast_expName = ValueUtil.TRUE_VALUE;
                                    raw_referredVariable = m_NameExpCS_ast_expName;
                                }
                                else {
                                    raw_referredVariable = ValueUtil.FALSE_VALUE;
                                }
                                raw_ast = raw_referredVariable;
                            }
                            else {
                                raw_ast = ValueUtil.FALSE_VALUE;
                            }
                            symbol_10 = raw_ast;
                        }
                        else {
                            symbol_10 = ValueUtil.FALSE_VALUE;
                        }
                        raw_aVariableExp = symbol_10;
                    }
                    else {
                        raw_aVariableExp = ValueUtil.FALSE_VALUE;
                    }
                    symbol_11 = raw_aVariableExp;
                }
                else {
                    symbol_11 = ValueUtil.FALSE_VALUE;
                }
                symbol_12 = symbol_11;
            }
            else {
                symbol_12 = ValueUtil.FALSE_VALUE;
            }
            return symbol_12;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_NameExpCS_ast_expName", e);
        }
    }
    
    /**
     * 
     * map m_NameExpCS_ast_expName_1 in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lNameExpCS : minioclcs::NameExpCS[1];
     *  |)
     * {expName : minioclcs::PathNameCS[?];
     *  |}
     * rightAS ( |)
     * {aPropertyCallExp : miniocl::PropertyCallExp[1];
     * ast : miniocl::Element[1];
     * ownedSource : miniocl::OCLExpression[1];
     * referredProperty : miniocl::Property[1];
     * type : miniocl::Class[1];
     *  |}
     * where ( |
     * not lNameExpCS.isVariableExp()
     *   lNameExpCS.isPropCallExpWithImplicitSource()
     *   not lNameExpCS.isPropCallExpWithExplicitSource()
     *   )
     * { |
     * aPropertyCallExp := lNameExpCS.ast;
     * ast := lNameExpCS.ast;
     * expName := lNameExpCS.expName;
     * ownedSource := aPropertyCallExp.ownedSource;
     * type := ownedSource.type;
     * referredProperty := aPropertyCallExp.lookupPropertyFrom(type, expName);
     * aPropertyCallExp.referredProperty := referredProperty;
     * }
     * 
     */
    protected class MAP_m_NameExpCS_ast_expName_1 extends AbstractInvocation
    {
        protected final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_5;
        
        public MAP_m_NameExpCS_ast_expName_1(@NonNull Object @NonNull [] boundValues) {
            lNameExpCS_5 = (NameExpCS)boundValues[0];
        }
        
        public boolean execute()  {
            try {
                // predicates and unrealized variables
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
                /*@Caught*/ @Nullable Object CAUGHT_and_0;
                try {
                    /*@Caught*/ @Nullable Object CAUGHT_and;
                    try {
                        /*@Caught*/ @NonNull Object CAUGHT_eq;
                        try {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_5.getRoundedBrackets();
                            final /*@Thrown*/ boolean eq = roundedBrackets == null;
                            CAUGHT_eq = eq;
                        }
                        catch (Exception e) {
                            CAUGHT_eq = ValueUtil.createInvalidValue(e);
                        }
                        /*@Caught*/ @Nullable Object CAUGHT_not;
                        try {
                            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_5);
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
                            final /*@Thrown*/ boolean eq_0 = symbol_0 == null;
                            /*@Thrown*/ boolean symbol_1;
                            if (eq_0) {
                                symbol_1 = ValueUtil.FALSE_VALUE;
                            }
                            else {
                                if (symbol_0 == null) {
                                    throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp = symbol_0.getNameExp();
                                final /*@Thrown*/ boolean eq_1 = lNameExpCS_5.equals(nameExp);
                                symbol_1 = eq_1;
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(symbol_1);
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
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName = lNameExpCS_5.getExpName();
                        if (expName == null) {
                            throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                        }
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> path = expName.getPath();
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_path = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path);
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_path);
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
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element self_1 = lNameExpCS_5.getAst();
                    if (self_1 == null) {
                        throw throwNull(lNameExpCS_5, "Null where non-null value required");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName_0 = lNameExpCS_5.getExpName();
                    if (expName_0 == null) {
                        throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                    }
                    @SuppressWarnings("null")
                    final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> path_0 = expName_0.getPath();
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_path_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path_0);
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_path_0);
                    if (aPathElementCS == null) {
                        throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName = aPathElementCS.getPathName();
                    MiniOCLLookupResult<Variable> _lookupResult = lookupSolver._lookupUnqualifiedVariable(self_1, (String)pathName);
                    Variable _lookupUnqualifiedVariable = null;
                    if (_lookupResult.size() == 1) {
                        _lookupUnqualifiedVariable = _lookupResult.getSingleResult();
                    } else {
                        handleLookupError(aPathElementCS,pathName);
                    };
                    final /*@Thrown*/ boolean ne = _lookupUnqualifiedVariable != null;
                    CAUGHT_ne = ne;
                }
                catch (Exception e) {
                    CAUGHT_ne = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_0, CAUGHT_ne);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(and_1);
                if (not_0 == null) {
                    throw throwNull(lNameExpCS_5, "Null if condition");
                }
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_19;
                if (not_0) {
                    /*@Caught*/ @Nullable Object CAUGHT_and_2;
                    try {
                        /*@Caught*/ @NonNull Object CAUGHT_eq_3;
                        try {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_5.getRoundedBrackets();
                            final /*@Thrown*/ boolean eq_3 = roundedBrackets_0 == null;
                            CAUGHT_eq_3 = eq_3;
                        }
                        catch (Exception e) {
                            CAUGHT_eq_3 = ValueUtil.createInvalidValue(e);
                        }
                        /*@Caught*/ @Nullable Object CAUGHT_not_1;
                        try {
                            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_5);
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_CallExpCS_4 = idResolver.getClass(CLSSid_CallExpCS, null);
                            final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, container_0, TYP_minioclcs_c_c_CallExpCS_4).booleanValue();
                            /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS symbol_2;
                            if (oclIsKindOf_0) {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CallExpCS oclAsType_0 = ClassUtil.nonNullState((CallExpCS)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container_0, TYP_minioclcs_c_c_CallExpCS_4));
                                symbol_2 = oclAsType_0;
                            }
                            else {
                                symbol_2 = null;
                            }
                            final /*@Thrown*/ boolean eq_4 = symbol_2 == null;
                            /*@Thrown*/ boolean symbol_3;
                            if (eq_4) {
                                symbol_3 = ValueUtil.FALSE_VALUE;
                            }
                            else {
                                if (symbol_2 == null) {
                                    throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp_0 = symbol_2.getNameExp();
                                final /*@Thrown*/ boolean eq_5 = lNameExpCS_5.equals(nameExp_0);
                                symbol_3 = eq_5;
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_1 = BooleanNotOperation.INSTANCE.evaluate(symbol_3);
                            CAUGHT_not_1 = not_1;
                        }
                        catch (Exception e) {
                            CAUGHT_not_1 = ValueUtil.createInvalidValue(e);
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_3, CAUGHT_not_1);
                        CAUGHT_and_2 = and_2;
                    }
                    catch (Exception e) {
                        CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
                    }
                    /*@Caught*/ @NonNull Object CAUGHT_eq_6;
                    try {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element self_2 = lNameExpCS_5.getAst();
                        if (self_2 == null) {
                            throw throwNull(lNameExpCS_5, "Null where non-null value required");
                        }
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName_1 = lNameExpCS_5.getExpName();
                        if (expName_1 == null) {
                            throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                        }
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> path_1 = expName_1.getPath();
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_path_1 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path_1);
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_path_1);
                        if (aPathElementCS_0 == null) {
                            throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName_0 = aPathElementCS_0.getPathName();
                        MiniOCLLookupResult<Variable> _lookupResult_0 = lookupSolver._lookupUnqualifiedVariable(self_2, (String)pathName_0);
                        Variable _lookupUnqualifiedVariable_0 = null;
                        if (_lookupResult_0.size() == 1) {
                            _lookupUnqualifiedVariable_0 = _lookupResult_0.getSingleResult();
                        } else {
                            handleLookupError(aPathElementCS_0,pathName_0);
                        };
                        final /*@Thrown*/ boolean eq_6 = _lookupUnqualifiedVariable_0 == null;
                        CAUGHT_eq_6 = eq_6;
                    }
                    catch (Exception e) {
                        CAUGHT_eq_6 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_3 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_2, CAUGHT_eq_6);
                    if (and_3 == null) {
                        throw throwNull(lNameExpCS_5, "Null if condition");
                    }
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_18;
                    if (and_3) {
                        /*@Caught*/ @NonNull Object CAUGHT_eq_7;
                        try {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets_1 = lNameExpCS_5.getRoundedBrackets();
                            final /*@Thrown*/ boolean eq_7 = roundedBrackets_1 == null;
                            CAUGHT_eq_7 = eq_7;
                        }
                        catch (Exception e) {
                            CAUGHT_eq_7 = ValueUtil.createInvalidValue(e);
                        }
                        /*@Caught*/ @NonNull Object CAUGHT_symbol_5;
                        try {
                            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container_1 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_5);
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_CallExpCS_6 = idResolver.getClass(CLSSid_CallExpCS, null);
                            final /*@Thrown*/ boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, container_1, TYP_minioclcs_c_c_CallExpCS_6).booleanValue();
                            /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS symbol_4;
                            if (oclIsKindOf_1) {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CallExpCS oclAsType_1 = ClassUtil.nonNullState((CallExpCS)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container_1, TYP_minioclcs_c_c_CallExpCS_6));
                                symbol_4 = oclAsType_1;
                            }
                            else {
                                symbol_4 = null;
                            }
                            final /*@Thrown*/ boolean eq_8 = symbol_4 == null;
                            /*@Thrown*/ boolean symbol_5;
                            if (eq_8) {
                                symbol_5 = ValueUtil.FALSE_VALUE;
                            }
                            else {
                                if (symbol_4 == null) {
                                    throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp_1 = symbol_4.getNameExp();
                                final /*@Thrown*/ boolean eq_9 = lNameExpCS_5.equals(nameExp_1);
                                symbol_5 = eq_9;
                            }
                            CAUGHT_symbol_5 = symbol_5;
                        }
                        catch (Exception e) {
                            CAUGHT_symbol_5 = ValueUtil.createInvalidValue(e);
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_4 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_7, CAUGHT_symbol_5);
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_2 = BooleanNotOperation.INSTANCE.evaluate(and_4);
                        if (not_2 == null) {
                            throw throwNull(lNameExpCS_5, "Null if condition");
                        }
                        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_17;
                        if (not_2) {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lNameExpCS_5.getAst();
                            final /*@Thrown*/ boolean symbol_6 = ast != null;
                            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aPropertyCallExp;
                            if (symbol_6) {
                                final /*@NonInvalid*/ boolean symbol_7 = ast instanceof PropertyCallExp;
                                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_16;
                                if (symbol_7) {
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable PropertyCallExp symbol_8 = (PropertyCallExp)ast;
                                    if (symbol_8 == null) {
                                        throw throwNull(lNameExpCS_5, "Null where non-null value required");
                                    }
                                    final /*@Thrown*/ boolean symbol_9 = ast != null;
                                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                                    if (symbol_9) {
                                        if (ast == null) {
                                            throw throwNull(lNameExpCS_5, "Null where non-null value required");
                                        }
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName_2 = lNameExpCS_5.getExpName();
                                        @SuppressWarnings("null")
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull OCLExpression ownedSource = symbol_8.getOwnedSource();
                                        objectManager.getting(ownedSource, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, false);
                                        @SuppressWarnings("null")
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class type = ownedSource.getType();
                                        if (expName_2 == null) {
                                            throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                                        }
                                        @SuppressWarnings("null")
                                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = expName_2.getPath();
                                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
                                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
                                        final /*@Thrown*/ boolean eq_10 = size_0.equals(INT_1);
                                        /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Property symbol_13;
                                        if (eq_10) {
                                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_1 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                                            if (aPathElementCS_1 == null) {
                                                throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                                            }
                                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName_1 = aPathElementCS_1.getPathName();
                                            MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Property> _lookupResult_1 = lookupSolver._lookupExportedProperty(type, symbol_8, (String)pathName_1);
                                            org.eclipse.qvtd.doc.miniocl.Property _lookupExportedProperty = null;
                                            if (_lookupResult_1.size() == 1) {
                                                _lookupExportedProperty = _lookupResult_1.getSingleResult();
                                            } else {
                                                handleLookupError(symbol_8,symbol_8);
                                            };
                                            symbol_13 = _lookupExportedProperty;
                                        }
                                        else {
                                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_0, INT_1);
                                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
                                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size_2 = CollectionSizeOperation.INSTANCE.evaluate(qualifierSegments);
                                            final /*@Thrown*/ boolean eq_11 = size_2.equals(INT_1);
                                            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_11;
                                            if (eq_11) {
                                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_2 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(qualifierSegments);
                                                if (aPathElementCS_2 == null) {
                                                    throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                                                }
                                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName_2 = aPathElementCS_2.getPathName();
                                                MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Class> _lookupResult_2 = lookupSolver._lookupUnqualifiedClass(symbol_8, (String)pathName_2);
                                                org.eclipse.qvtd.doc.miniocl.Class _lookupUnqualifiedClass = null;
                                                if (_lookupResult_2.size() == 1) {
                                                    _lookupUnqualifiedClass = _lookupResult_2.getSingleResult();
                                                } else {
                                                    handleLookupError(aPathElementCS_2,pathName_2);
                                                };
                                                symbol_11 = _lookupUnqualifiedClass;
                                            }
                                            else {
                                                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff_0 = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_2, INT_1);
                                                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments_0 = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(qualifierSegments, INT_1, diff_0);
                                                final List<PathElementCS> UNBOXED_qualifierSegments_0 = qualifierSegments_0.asEcoreObjects(idResolver, PathElementCS.class);
                                                assert UNBOXED_qualifierSegments_0 != null;
                                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package qualifier = MiniOCLCS2AS_qvtp_qvtcas.this.lookupPackage(symbol_8, UNBOXED_qualifierSegments_0);
                                                /*@Caught*/ @Nullable Object CAUGHT_qualifier;
                                                try {
                                                    CAUGHT_qualifier = qualifier;
                                                }
                                                catch (Exception e) {
                                                    CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                                                }
                                                final /*@NonInvalid*/ @NonNull Object symbol_10 = CAUGHT_qualifier == null;
                                                /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
                                                if (symbol_10 == Boolean.TRUE) {
                                                    safe_lookupQualifiedClass_source = null;
                                                }
                                                else {
                                                    if (qualifier == null) {
                                                        throw throwNull(lNameExpCS_5, "Null where non-null value required");
                                                    }
                                                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_3 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(qualifierSegments);
                                                    if (aPathElementCS_3 == null) {
                                                        throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                                                    }
                                                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName_3 = aPathElementCS_3.getPathName();
                                                    MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Class> _lookupResult_3 = lookupSolver._lookupQualifiedClass(qualifier, (String)pathName_3);
                                                    org.eclipse.qvtd.doc.miniocl.Class _lookupQualifiedClass = null;
                                                    if (_lookupResult_3.size() == 1) {
                                                        _lookupQualifiedClass = _lookupResult_3.getSingleResult();
                                                    } else {
                                                        handleLookupError(aPathElementCS_3,pathName_3);
                                                    };
                                                    safe_lookupQualifiedClass_source = _lookupQualifiedClass;
                                                }
                                                symbol_11 = safe_lookupQualifiedClass_source;
                                            }
                                            /*@Caught*/ @Nullable Object CAUGHT_symbol_11;
                                            try {
                                                CAUGHT_symbol_11 = symbol_11;
                                            }
                                            catch (Exception e) {
                                                CAUGHT_symbol_11 = ValueUtil.createInvalidValue(e);
                                            }
                                            final /*@NonInvalid*/ @NonNull Object symbol_12 = CAUGHT_symbol_11 == null;
                                            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Property safe_lookupQualifiedProperty_source;
                                            if (symbol_12 == Boolean.TRUE) {
                                                safe_lookupQualifiedProperty_source = null;
                                            }
                                            else {
                                                if (symbol_11 == null) {
                                                    throw throwNull(lNameExpCS_5, "Null where non-null value required");
                                                }
                                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_4 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                                                if (aPathElementCS_4 == null) {
                                                    throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                                                }
                                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName_4 = aPathElementCS_4.getPathName();
                                                MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Property> _lookupResult_4 = lookupSolver._lookupQualifiedProperty(symbol_11, (String)pathName_4);
                                                org.eclipse.qvtd.doc.miniocl.Property _lookupQualifiedProperty = null;
                                                if (_lookupResult_4.size() == 1) {
                                                    _lookupQualifiedProperty = _lookupResult_4.getSingleResult();
                                                } else {
                                                    handleLookupError(aPathElementCS_4,pathName_4);
                                                };
                                                safe_lookupQualifiedProperty_source = _lookupQualifiedProperty;
                                            }
                                            symbol_13 = safe_lookupQualifiedProperty_source;
                                        }
                                        final /*@Thrown*/ boolean symbol_14 = symbol_13 != null;
                                        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_referredProperty;
                                        if (symbol_14) {
                                            if (symbol_13 == null) {
                                                throw throwNull(lNameExpCS_5, "Null where non-null value required");
                                            }
                                            // property assignments
                                            symbol_8.setReferredProperty(symbol_13);
                                            objectManager.assigned(symbol_8, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, symbol_13, null);
                                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_NameExpCS_ast_expName_1 = ValueUtil.TRUE_VALUE;
                                            raw_referredProperty = m_NameExpCS_ast_expName_1;
                                        }
                                        else {
                                            raw_referredProperty = ValueUtil.FALSE_VALUE;
                                        }
                                        raw_ast = raw_referredProperty;
                                    }
                                    else {
                                        raw_ast = ValueUtil.FALSE_VALUE;
                                    }
                                    symbol_16 = raw_ast;
                                }
                                else {
                                    symbol_16 = ValueUtil.FALSE_VALUE;
                                }
                                raw_aPropertyCallExp = symbol_16;
                            }
                            else {
                                raw_aPropertyCallExp = ValueUtil.FALSE_VALUE;
                            }
                            symbol_17 = raw_aPropertyCallExp;
                        }
                        else {
                            symbol_17 = ValueUtil.FALSE_VALUE;
                        }
                        symbol_18 = symbol_17;
                    }
                    else {
                        symbol_18 = ValueUtil.FALSE_VALUE;
                    }
                    symbol_19 = symbol_18;
                }
                else {
                    symbol_19 = ValueUtil.FALSE_VALUE;
                }
                return symbol_19;
            } catch (Throwable e) {
                return handleExecutionFailure("MAP_m_NameExpCS_ast_expName_1", e);
            }
        }
        
        public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
            return idResolver.oclEquals(lNameExpCS_5, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map m_NameExpCS_ast_expName_2 in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lNameExpCS : minioclcs::NameExpCS[1];
     *  |)
     * {expName : minioclcs::PathNameCS[?];
     *  |}
     * rightAS ( |)
     * {aPropertyCallExp : miniocl::PropertyCallExp[1];
     * ast : miniocl::Element[1];
     * ownedSource : miniocl::OCLExpression[1];
     * referredProperty : miniocl::Property[1];
     * type : miniocl::Class[1];
     *  |}
     * where ( |
     * lNameExpCS.isPropCallExpWithExplicitSource()
     *   )
     * { |
     * aPropertyCallExp := lNameExpCS.ast;
     * ast := lNameExpCS.ast;
     * expName := lNameExpCS.expName;
     * ownedSource := aPropertyCallExp.ownedSource;
     * type := ownedSource.type;
     * referredProperty := aPropertyCallExp.lookupPropertyFrom(type, expName);
     * aPropertyCallExp.referredProperty := referredProperty;
     * }
     * 
     */
    protected class MAP_m_NameExpCS_ast_expName_2 extends AbstractInvocation
    {
        protected final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_6;
        
        public MAP_m_NameExpCS_ast_expName_2(@NonNull Object @NonNull [] boundValues) {
            lNameExpCS_6 = (NameExpCS)boundValues[0];
        }
        
        public boolean execute()  {
            try {
                // predicates and unrealized variables
                final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
                /*@Caught*/ @NonNull Object CAUGHT_eq;
                try {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_6.getRoundedBrackets();
                    final /*@Thrown*/ boolean eq = roundedBrackets == null;
                    CAUGHT_eq = eq;
                }
                catch (Exception e) {
                    CAUGHT_eq = ValueUtil.createInvalidValue(e);
                }
                /*@Caught*/ @NonNull Object CAUGHT_symbol_1;
                try {
                    final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_6);
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
                    final /*@Thrown*/ boolean eq_0 = symbol_0 == null;
                    /*@Thrown*/ boolean symbol_1;
                    if (eq_0) {
                        symbol_1 = ValueUtil.FALSE_VALUE;
                    }
                    else {
                        if (symbol_0 == null) {
                            throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                        }
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp = symbol_0.getNameExp();
                        final /*@Thrown*/ boolean eq_1 = lNameExpCS_6.equals(nameExp);
                        symbol_1 = eq_1;
                    }
                    CAUGHT_symbol_1 = symbol_1;
                }
                catch (Exception e) {
                    CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_1);
                if (and == null) {
                    throw throwNull(lNameExpCS_6, "Null if condition");
                }
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_13;
                if (and) {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lNameExpCS_6.getAst();
                    final /*@Thrown*/ boolean symbol_2 = ast != null;
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aPropertyCallExp;
                    if (symbol_2) {
                        final /*@NonInvalid*/ boolean symbol_3 = ast instanceof PropertyCallExp;
                        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_12;
                        if (symbol_3) {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable PropertyCallExp symbol_4 = (PropertyCallExp)ast;
                            if (symbol_4 == null) {
                                throw throwNull(lNameExpCS_6, "Null where non-null value required");
                            }
                            final /*@Thrown*/ boolean symbol_5 = ast != null;
                            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                            if (symbol_5) {
                                if (ast == null) {
                                    throw throwNull(lNameExpCS_6, "Null where non-null value required");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName = lNameExpCS_6.getExpName();
                                @SuppressWarnings("null")
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull OCLExpression ownedSource = symbol_4.getOwnedSource();
                                objectManager.getting(ownedSource, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, false);
                                @SuppressWarnings("null")
                                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class type = ownedSource.getType();
                                if (expName == null) {
                                    throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                                }
                                @SuppressWarnings("null")
                                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = expName.getPath();
                                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
                                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
                                final /*@Thrown*/ boolean eq_2 = size.equals(INT_1);
                                /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Property symbol_9;
                                if (eq_2) {
                                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                                    if (aPathElementCS == null) {
                                        throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                                    }
                                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName = aPathElementCS.getPathName();
                                    MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Property> _lookupResult = lookupSolver._lookupExportedProperty(type, symbol_4, (String)pathName);
                                    org.eclipse.qvtd.doc.miniocl.Property _lookupExportedProperty = null;
                                    if (_lookupResult.size() == 1) {
                                        _lookupExportedProperty = _lookupResult.getSingleResult();
                                    } else {
                                        handleLookupError(symbol_4,symbol_4);
                                    };
                                    symbol_9 = _lookupExportedProperty;
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
                                            throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                                        }
                                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName_0 = aPathElementCS_0.getPathName();
                                        MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Class> _lookupResult_0 = lookupSolver._lookupUnqualifiedClass(symbol_4, (String)pathName_0);
                                        org.eclipse.qvtd.doc.miniocl.Class _lookupUnqualifiedClass = null;
                                        if (_lookupResult_0.size() == 1) {
                                            _lookupUnqualifiedClass = _lookupResult_0.getSingleResult();
                                        } else {
                                            handleLookupError(aPathElementCS_0,pathName_0);
                                        };
                                        symbol_7 = _lookupUnqualifiedClass;
                                    }
                                    else {
                                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff_0 = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_1, INT_1);
                                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments_0 = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(qualifierSegments, INT_1, diff_0);
                                        final List<PathElementCS> UNBOXED_qualifierSegments_0 = qualifierSegments_0.asEcoreObjects(idResolver, PathElementCS.class);
                                        assert UNBOXED_qualifierSegments_0 != null;
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package qualifier = MiniOCLCS2AS_qvtp_qvtcas.this.lookupPackage(symbol_4, UNBOXED_qualifierSegments_0);
                                        /*@Caught*/ @Nullable Object CAUGHT_qualifier;
                                        try {
                                            CAUGHT_qualifier = qualifier;
                                        }
                                        catch (Exception e) {
                                            CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                                        }
                                        final /*@NonInvalid*/ @NonNull Object symbol_6 = CAUGHT_qualifier == null;
                                        /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
                                        if (symbol_6 == Boolean.TRUE) {
                                            safe_lookupQualifiedClass_source = null;
                                        }
                                        else {
                                            if (qualifier == null) {
                                                throw throwNull(lNameExpCS_6, "Null where non-null value required");
                                            }
                                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_1 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(qualifierSegments);
                                            if (aPathElementCS_1 == null) {
                                                throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                                            }
                                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName_1 = aPathElementCS_1.getPathName();
                                            MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Class> _lookupResult_1 = lookupSolver._lookupQualifiedClass(qualifier, (String)pathName_1);
                                            org.eclipse.qvtd.doc.miniocl.Class _lookupQualifiedClass = null;
                                            if (_lookupResult_1.size() == 1) {
                                                _lookupQualifiedClass = _lookupResult_1.getSingleResult();
                                            } else {
                                                handleLookupError(aPathElementCS_1,pathName_1);
                                            };
                                            safe_lookupQualifiedClass_source = _lookupQualifiedClass;
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
                                            throw throwNull(lNameExpCS_6, "Null where non-null value required");
                                        }
                                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_2 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                                        if (aPathElementCS_2 == null) {
                                            throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                                        }
                                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName_2 = aPathElementCS_2.getPathName();
                                        MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Property> _lookupResult_2 = lookupSolver._lookupQualifiedProperty(symbol_7, (String)pathName_2);
                                        org.eclipse.qvtd.doc.miniocl.Property _lookupQualifiedProperty = null;
                                        if (_lookupResult_2.size() == 1) {
                                            _lookupQualifiedProperty = _lookupResult_2.getSingleResult();
                                        } else {
                                            handleLookupError(aPathElementCS_2,pathName_2);
                                        };
                                        safe_lookupQualifiedProperty_source = _lookupQualifiedProperty;
                                    }
                                    symbol_9 = safe_lookupQualifiedProperty_source;
                                }
                                final /*@Thrown*/ boolean symbol_10 = symbol_9 != null;
                                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_referredProperty;
                                if (symbol_10) {
                                    if (symbol_9 == null) {
                                        throw throwNull(lNameExpCS_6, "Null where non-null value required");
                                    }
                                    // property assignments
                                    symbol_4.setReferredProperty(symbol_9);
                                    objectManager.assigned(symbol_4, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, symbol_9, null);
                                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_NameExpCS_ast_expName_2 = ValueUtil.TRUE_VALUE;
                                    raw_referredProperty = m_NameExpCS_ast_expName_2;
                                }
                                else {
                                    raw_referredProperty = ValueUtil.FALSE_VALUE;
                                }
                                raw_ast = raw_referredProperty;
                            }
                            else {
                                raw_ast = ValueUtil.FALSE_VALUE;
                            }
                            symbol_12 = raw_ast;
                        }
                        else {
                            symbol_12 = ValueUtil.FALSE_VALUE;
                        }
                        raw_aPropertyCallExp = symbol_12;
                    }
                    else {
                        raw_aPropertyCallExp = ValueUtil.FALSE_VALUE;
                    }
                    symbol_13 = raw_aPropertyCallExp;
                }
                else {
                    symbol_13 = ValueUtil.FALSE_VALUE;
                }
                return symbol_13;
            } catch (Throwable e) {
                return handleExecutionFailure("MAP_m_NameExpCS_ast_expName_2", e);
            }
        }
        
        public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
            return idResolver.oclEquals(lNameExpCS_6, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map m_OperationCS_ast_body in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lOperationCS : minioclcs::OperationCS[1];
     *  |)
     * {body : minioclcs::ExpCS[?];
     *  |}
     * rightAS ( |)
     * {Variable : miniocl::Variable[1];
     * aOCLExpression : miniocl::OCLExpression[1];
     * aOperation : miniocl::Operation[1];
     * ast : miniocl::Element[1];
     * ast1 : miniocl::Element[1];
     * ownedBodyExpression : miniocl::ExpressionInOCL[1];
     * owningClass : miniocl::Class[?];
     *  |}
     * where ( |)
     * { |
     * aOperation := lOperationCS.ast;
     * ast := lOperationCS.ast;
     * body := lOperationCS.body;
     * ast1 := body.ast;
     * owningClass := aOperation.owningClass;
     * Variable := miniocl::Variable{name = 'self', type = owningClass
     *   }
     *   ;
     * aOCLExpression := ast1.oclAsType(miniocl::OCLExpression)
     *   ;
     * ownedBodyExpression := miniocl::ExpressionInOCL{ownedBody = aOCLExpression, ownedSelfVar = Variable
     *   };
     * aOperation.ownedBodyExpression := ownedBodyExpression;
     * }
     * 
     */
    protected boolean MAP_m_OperationCS_ast_body(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS lOperationCS)  {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lOperationCS.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aOperation;
            if (symbol_0) {
                final /*@NonInvalid*/ boolean symbol_1 = ast instanceof Operation;
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_12;
                if (symbol_1) {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Operation symbol_2 = (Operation)ast;
                    if (symbol_2 == null) {
                        throw throwNull(lOperationCS, "Null where non-null value required");
                    }
                    final /*@Thrown*/ boolean symbol_3 = ast != null;
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                    if (symbol_3) {
                        if (ast == null) {
                            throw throwNull(lOperationCS, "Null where non-null value required");
                        }
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable ExpCS body = lOperationCS.getBody();
                        if (body == null) {
                            throw throwNull(lOperationCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CSTrace::ast\'");
                        }
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast_1 = body.getAst();
                        final /*@Thrown*/ boolean symbol_4 = ast_1 != null;
                        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast1;
                        if (symbol_4) {
                            if (ast_1 == null) {
                                throw throwNull(lOperationCS, "Null where non-null value required");
                            }
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class owningClass = symbol_2.getOwningClass();
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property CTORid_name = idResolver.getProperty(PROPid_name);
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property CTORid_type = idResolver.getProperty(PROPid_type);
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Variable_0 = idResolver.getClass(CLSSid_Variable, null);
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Variable symbol_7 = (Variable)TYP_miniocl_c_c_Variable_0.createInstance();
                            CTORid_name.initValue(symbol_7, STR_self);
                            CTORid_type.initValue(symbol_7, owningClass);
                            models[1/*rightAS*/].add(symbol_7);
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_OCLExpression_0 = idResolver.getClass(CLSSid_OCLExpression, null);
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull OCLExpression oclAsType = ClassUtil.nonNullState((OCLExpression)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_1, TYP_miniocl_c_c_OCLExpression_0));
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property CTORid_ownedBody = idResolver.getProperty(PROPid_ownedBody);
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property CTORid_ownedSelfVar = idResolver.getProperty(PROPid_ownedSelfVar);
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_ExpressionInOCL_0 = idResolver.getClass(CLSSid_ExpressionInOCL, null);
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull ExpressionInOCL symbol_10 = (ExpressionInOCL)TYP_miniocl_c_c_ExpressionInOCL_0.createInstance();
                            CTORid_ownedBody.initValue(symbol_10, oclAsType);
                            CTORid_ownedSelfVar.initValue(symbol_10, symbol_7);
                            models[1/*rightAS*/].add(symbol_10);
                            // property assignments
                            symbol_2.setOwnedBodyExpression(symbol_10);
                            objectManager.assigned(symbol_2, MiniOCLPackage.Literals.OPERATION__OWNED_BODY_EXPRESSION, symbol_10, null);
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
                    symbol_12 = raw_ast;
                }
                else {
                    symbol_12 = ValueUtil.FALSE_VALUE;
                }
                raw_aOperation = symbol_12;
            }
            else {
                raw_aOperation = ValueUtil.FALSE_VALUE;
            }
            return raw_aOperation;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_OperationCS_ast_body", e);
        }
    }
    
    /**
     * 
     * map m_OperationCS_ast_resultRef in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lOperationCS : minioclcs::OperationCS[1];
     *  |)
     * {resultRef : minioclcs::PathNameCS[?];
     *  |}
     * rightAS ( |)
     * {aOperation : miniocl::Operation[1];
     * ast : miniocl::Element[1];
     * type : miniocl::Class[1];
     *  |}
     * where ( |)
     * { |
     * aOperation := lOperationCS.ast;
     * ast := lOperationCS.ast;
     * resultRef := lOperationCS.resultRef;
     * type := aOperation.lookupClass(resultRef);
     * aOperation.type := type;
     * }
     * 
     */
    protected boolean MAP_m_OperationCS_ast_resultRef(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS lOperationCS_0)  {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lOperationCS_0.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aOperation;
            if (symbol_0) {
                final /*@NonInvalid*/ boolean symbol_1 = ast instanceof Operation;
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_8;
                if (symbol_1) {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Operation symbol_2 = (Operation)ast;
                    if (symbol_2 == null) {
                        throw throwNull(lOperationCS_0, "Null where non-null value required");
                    }
                    final /*@Thrown*/ boolean symbol_3 = ast != null;
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                    if (symbol_3) {
                        if (ast == null) {
                            throw throwNull(lOperationCS_0, "Null where non-null value required");
                        }
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS resultRef = lOperationCS_0.getResultRef();
                        if (resultRef == null) {
                            throw throwNull(lOperationCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                        }
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = resultRef.getPath();
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
                        final /*@Thrown*/ boolean eq = size.equals(INT_1);
                        /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_5;
                        if (eq) {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                            if (aPathElementCS == null) {
                                throw throwNull(lOperationCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName = aPathElementCS.getPathName();
                            MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Class> _lookupResult = lookupSolver._lookupUnqualifiedClass(symbol_2, (String)pathName);
                            org.eclipse.qvtd.doc.miniocl.Class _lookupUnqualifiedClass = null;
                            if (_lookupResult.size() == 1) {
                                _lookupUnqualifiedClass = _lookupResult.getSingleResult();
                            } else {
                                handleLookupError(aPathElementCS,pathName);
                            };
                            symbol_5 = _lookupUnqualifiedClass;
                        }
                        else {
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
                            final List<PathElementCS> UNBOXED_qualifierSegments = qualifierSegments.asEcoreObjects(idResolver, PathElementCS.class);
                            assert UNBOXED_qualifierSegments != null;
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package qualifier = this.lookupPackage(symbol_2, UNBOXED_qualifierSegments);
                            /*@Caught*/ @Nullable Object CAUGHT_qualifier;
                            try {
                                CAUGHT_qualifier = qualifier;
                            }
                            catch (Exception e) {
                                CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                            }
                            final /*@NonInvalid*/ @NonNull Object symbol_4 = CAUGHT_qualifier == null;
                            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
                            if (symbol_4 == Boolean.TRUE) {
                                safe_lookupQualifiedClass_source = null;
                            }
                            else {
                                if (qualifier == null) {
                                    throw throwNull(lOperationCS_0, "Null where non-null value required");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                                if (aPathElementCS_0 == null) {
                                    throw throwNull(lOperationCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                                }
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName_0 = aPathElementCS_0.getPathName();
                                MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Class> _lookupResult_0 = lookupSolver._lookupQualifiedClass(qualifier, (String)pathName_0);
                                org.eclipse.qvtd.doc.miniocl.Class _lookupQualifiedClass = null;
                                if (_lookupResult_0.size() == 1) {
                                    _lookupQualifiedClass = _lookupResult_0.getSingleResult();
                                } else {
                                    handleLookupError(aPathElementCS_0,pathName_0);
                                };
                                safe_lookupQualifiedClass_source = _lookupQualifiedClass;
                            }
                            symbol_5 = safe_lookupQualifiedClass_source;
                        }
                        final /*@Thrown*/ boolean symbol_6 = symbol_5 != null;
                        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_type;
                        if (symbol_6) {
                            if (symbol_5 == null) {
                                throw throwNull(lOperationCS_0, "Null where non-null value required");
                            }
                            // property assignments
                            symbol_2.setType(symbol_5);
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_OperationCS_ast_resultRef = ValueUtil.TRUE_VALUE;
                            raw_type = m_OperationCS_ast_resultRef;
                        }
                        else {
                            raw_type = ValueUtil.FALSE_VALUE;
                        }
                        raw_ast = raw_type;
                    }
                    else {
                        raw_ast = ValueUtil.FALSE_VALUE;
                    }
                    symbol_8 = raw_ast;
                }
                else {
                    symbol_8 = ValueUtil.FALSE_VALUE;
                }
                raw_aOperation = symbol_8;
            }
            else {
                raw_aOperation = ValueUtil.FALSE_VALUE;
            }
            return raw_aOperation;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_OperationCS_ast_resultRef", e);
        }
    }
    
    /**
     * 
     * map m_Operation_OperationCS in MiniOCLCS2AS_qvtp_qvtcas {leftCS (lOperationCS : minioclcs::OperationCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize rOperation : miniocl::Operation[1];
     *  |}
     * where ( |)
     * { |
     * lOperationCS.ast := rOperation;
     * }
     * 
     */
    protected boolean MAP_m_Operation_OperationCS(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS lOperationCS_1)  {
        try {
            // predicates and unrealized variables
            // creations
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Operation rOperation = MiniOCLFactory.eINSTANCE.createOperation();
            assert rOperation != null;
            models[1/*rightAS*/].add(rOperation);
            // property assignments
            lOperationCS_1.setAst(rOperation);
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Operation_OperationCS = ValueUtil.TRUE_VALUE;
            return m_Operation_OperationCS;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_Operation_OperationCS", e);
        }
    }
    
    /**
     * 
     * map m_OrderedSet_ClassCS in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lClassCS : minioclcs::ClassCS[1];
     *  |)
     * {operations : OrderedSet(minioclcs::OperationCS)[*|1];
     * properties : OrderedSet(minioclcs::PropertyCS)[*|1];
     *  |}
     * rightAS ( |)
     * {aClass : miniocl::Class[1];
     * asOrderedSet : OrderedSet(miniocl::Property)[*|1];
     * asOrderedSet1 : OrderedSet(miniocl::Operation)[*|1];
     * ast : miniocl::Element[1];
     * _'\u00ABcollect\u00BB' : Sequence(miniocl::Property)[*|1];
     * _'\u00ABcollect\u00BB1' : Sequence(miniocl::Operation)[*|1];
     *  |}
     * where ( |)
     * {name : ecore::EString[?];
     * toString : String[1];
     *  |
     * aClass := lClassCS.ast;
     * ast := lClassCS.ast;
     * name := lClassCS.name;
     * operations := lClassCS.operations;
     * properties := lClassCS.properties;
     * toString := name.toString()
     *   ;
     * _'\u00ABcollect\u00BB' := properties->collect(_'1_' |
     *     _'1_'.ast.oclAsType(miniocl::Property))
     *   ;
     * _'\u00ABcollect\u00BB1' := operations->collect(_'1_' |
     *     _'1_'.ast.oclAsType(miniocl::Operation))
     *   ;
     * asOrderedSet := _'\u00ABcollect\u00BB'->asOrderedSet()
     *   ;
     * asOrderedSet1 := _'\u00ABcollect\u00BB1'->asOrderedSet();
     * aClass.name := toString;
     * aClass.ownedOperations := asOrderedSet1;
     * aClass.ownedProperties := asOrderedSet;
     * }
     * 
     */
    protected boolean MAP_m_OrderedSet_ClassCS(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ClassCS lClassCS_1)  {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lClassCS_1.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aClass;
            if (symbol_0) {
                final /*@NonInvalid*/ boolean symbol_1 = ast instanceof org.eclipse.qvtd.doc.miniocl.Class;
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_7;
                if (symbol_1) {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_2 = (org.eclipse.qvtd.doc.miniocl.Class)ast;
                    if (symbol_2 == null) {
                        throw throwNull(lClassCS_1, "Null where non-null value required");
                    }
                    final /*@Thrown*/ boolean symbol_3 = ast != null;
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                    if (symbol_3) {
                        if (ast == null) {
                            throw throwNull(lClassCS_1, "Null where non-null value required");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = lClassCS_1.getName();
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<OperationCS> operations = lClassCS_1.getOperations();
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PropertyCS> properties = lClassCS_1.getProperties();
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
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
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast_1 = _1.getAst();
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Property oclAsType = ClassUtil.nonNullState((org.eclipse.qvtd.doc.miniocl.Property)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_1, TYP_miniocl_c_c_Property_0));
                            //
                            accumulator.add(oclAsType);
                        }
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_operations = idResolver.createOrderedSetOfAll(ORD_CLSSid_OperationCS, operations);
                        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
                        @NonNull Iterator<Object> ITERATOR__1_0 = BOXED_operations.iterator();
                        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect_0;
                        while (true) {
                            if (!ITERATOR__1_0.hasNext()) {
                                collect_0 = accumulator_0;
                                break;
                            }
                            @SuppressWarnings("null")
                            /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS _1_0 = (OperationCS)ITERATOR__1_0.next();
                            /**
                             * _'1_'.ast.oclAsType(miniocl::Operation)
                             */
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast_2 = _1_0.getAst();
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Operation oclAsType_0 = ClassUtil.nonNullState((Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_2, TYP_miniocl_c_c_Operation_0));
                            //
                            accumulator_0.add(oclAsType_0);
                        }
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue asOrderedSet_0 = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect_0);
                        // property assignments
                        symbol_2.setName(toString);
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Operation> ECORE_asOrderedSet_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Operation.class, asOrderedSet_0);
                        symbol_2.getOwnedOperations().addAll(ECORE_asOrderedSet_0);
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.qvtd.doc.miniocl.Property.class, asOrderedSet);
                        symbol_2.getOwnedProperties().addAll(ECORE_asOrderedSet);
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_OrderedSet_ClassCS = ValueUtil.TRUE_VALUE;
                        raw_ast = m_OrderedSet_ClassCS;
                    }
                    else {
                        raw_ast = ValueUtil.FALSE_VALUE;
                    }
                    symbol_7 = raw_ast;
                }
                else {
                    symbol_7 = ValueUtil.FALSE_VALUE;
                }
                raw_aClass = symbol_7;
            }
            else {
                raw_aClass = ValueUtil.FALSE_VALUE;
            }
            return raw_aClass;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_OrderedSet_ClassCS", e);
        }
    }
    
    /**
     * 
     * map m_OrderedSet_OperationCS in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lOperationCS : minioclcs::OperationCS[1];
     *  |)
     * {params : OrderedSet(minioclcs::ParameterCS)[*|1];
     *  |}
     * rightAS ( |)
     * {aOperation : miniocl::Operation[1];
     * asOrderedSet : OrderedSet(miniocl::Parameter)[*|1];
     * ast : miniocl::Element[1];
     * _'\u00ABcollect\u00BB' : Sequence(miniocl::Parameter)[*|1];
     *  |}
     * where ( |)
     * {name : ecore::EString[?];
     * toString : String[1];
     *  |
     * aOperation := lOperationCS.ast;
     * ast := lOperationCS.ast;
     * name := lOperationCS.name;
     * params := lOperationCS.params;
     * toString := name.toString()
     *   ;
     * _'\u00ABcollect\u00BB' := params->collect(_'1_' |
     *     _'1_'.ast.oclAsType(miniocl::Parameter))
     *   ;
     * asOrderedSet := _'\u00ABcollect\u00BB'->asOrderedSet();
     * aOperation.name := toString;
     * aOperation.ownedParameters := asOrderedSet;
     * }
     * 
     */
    protected boolean MAP_m_OrderedSet_OperationCS(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull OperationCS lOperationCS_2)  {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lOperationCS_2.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aOperation;
            if (symbol_0) {
                final /*@NonInvalid*/ boolean symbol_1 = ast instanceof Operation;
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_6;
                if (symbol_1) {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Operation symbol_2 = (Operation)ast;
                    if (symbol_2 == null) {
                        throw throwNull(lOperationCS_2, "Null where non-null value required");
                    }
                    final /*@Thrown*/ boolean symbol_3 = ast != null;
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                    if (symbol_3) {
                        if (ast == null) {
                            throw throwNull(lOperationCS_2, "Null where non-null value required");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = lOperationCS_2.getName();
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<ParameterCS> params = lOperationCS_2.getParams();
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
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
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast_1 = _1.getAst();
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Parameter oclAsType = ClassUtil.nonNullState((Parameter)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_1, TYP_miniocl_c_c_Parameter_0));
                            //
                            accumulator.add(oclAsType);
                        }
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
                        // property assignments
                        symbol_2.setName(toString);
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Parameter> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Parameter.class, asOrderedSet);
                        symbol_2.getOwnedParameters().addAll(ECORE_asOrderedSet);
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_OrderedSet_OperationCS = ValueUtil.TRUE_VALUE;
                        raw_ast = m_OrderedSet_OperationCS;
                    }
                    else {
                        raw_ast = ValueUtil.FALSE_VALUE;
                    }
                    symbol_6 = raw_ast;
                }
                else {
                    symbol_6 = ValueUtil.FALSE_VALUE;
                }
                raw_aOperation = symbol_6;
            }
            else {
                raw_aOperation = ValueUtil.FALSE_VALUE;
            }
            return raw_aOperation;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_OrderedSet_OperationCS", e);
        }
    }
    
    /**
     * 
     * map m_OrderedSet_PackageCS in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lPackageCS : minioclcs::PackageCS[1];
     *  |)
     * {classes : OrderedSet(minioclcs::ClassCS)[*|1];
     * packages : OrderedSet(minioclcs::PackageCS)[*|1];
     *  |}
     * rightAS ( |)
     * {aPackage : miniocl::Package[1];
     * asOrderedSet : OrderedSet(miniocl::Class)[*|1];
     * asOrderedSet1 : OrderedSet(miniocl::Package)[*|1];
     * ast : miniocl::Element[1];
     * _'\u00ABcollect\u00BB' : Sequence(miniocl::Class)[*|1];
     * _'\u00ABcollect\u00BB1' : Sequence(miniocl::Package)[*|1];
     *  |}
     * where ( |)
     * {name : ecore::EString[?];
     * toString : String[1];
     *  |
     * aPackage := lPackageCS.ast;
     * ast := lPackageCS.ast;
     * classes := lPackageCS.classes;
     * name := lPackageCS.name;
     * packages := lPackageCS.packages;
     * toString := name.toString()
     *   ;
     * _'\u00ABcollect\u00BB' := classes->collect(_'1_' |
     *     _'1_'.ast.oclAsType(miniocl::Class))
     *   ;
     * _'\u00ABcollect\u00BB1' := packages->collect(_'1_' |
     *     _'1_'.ast.oclAsType(miniocl::Package))
     *   ;
     * asOrderedSet := _'\u00ABcollect\u00BB'->asOrderedSet()
     *   ;
     * asOrderedSet1 := _'\u00ABcollect\u00BB1'->asOrderedSet();
     * aPackage.name := toString;
     * aPackage.ownedClasses := asOrderedSet;
     * aPackage.ownedPackages := asOrderedSet1;
     * }
     * 
     */
    protected boolean MAP_m_OrderedSet_PackageCS(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PackageCS lPackageCS)  {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lPackageCS.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aPackage;
            if (symbol_0) {
                final /*@NonInvalid*/ boolean symbol_1 = ast instanceof Package;
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_7;
                if (symbol_1) {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package symbol_2 = (Package)ast;
                    if (symbol_2 == null) {
                        throw throwNull(lPackageCS, "Null where non-null value required");
                    }
                    final /*@Thrown*/ boolean symbol_3 = ast != null;
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                    if (symbol_3) {
                        if (ast == null) {
                            throw throwNull(lPackageCS, "Null where non-null value required");
                        }
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<ClassCS> classes = lPackageCS.getClasses();
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = lPackageCS.getName();
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PackageCS> packages = lPackageCS.getPackages();
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
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
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast_1 = _1.getAst();
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class oclAsType = ClassUtil.nonNullState((org.eclipse.qvtd.doc.miniocl.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_1, TYP_miniocl_c_c_Class_0));
                            //
                            accumulator.add(oclAsType);
                        }
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_packages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, packages);
                        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
                        @NonNull Iterator<Object> ITERATOR__1_0 = BOXED_packages.iterator();
                        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect_0;
                        while (true) {
                            if (!ITERATOR__1_0.hasNext()) {
                                collect_0 = accumulator_0;
                                break;
                            }
                            @SuppressWarnings("null")
                            /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PackageCS _1_0 = (PackageCS)ITERATOR__1_0.next();
                            /**
                             * _'1_'.ast.oclAsType(miniocl::Package)
                             */
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_miniocl_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast_2 = _1_0.getAst();
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Package oclAsType_0 = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_2, TYP_miniocl_c_c_Package_0));
                            //
                            accumulator_0.add(oclAsType_0);
                        }
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue asOrderedSet_0 = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect_0);
                        // property assignments
                        symbol_2.setName(toString);
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.qvtd.doc.miniocl.Class.class, asOrderedSet);
                        symbol_2.getOwnedClasses().addAll(ECORE_asOrderedSet);
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Package> ECORE_asOrderedSet_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, asOrderedSet_0);
                        symbol_2.getOwnedPackages().addAll(ECORE_asOrderedSet_0);
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_OrderedSet_PackageCS = ValueUtil.TRUE_VALUE;
                        raw_ast = m_OrderedSet_PackageCS;
                    }
                    else {
                        raw_ast = ValueUtil.FALSE_VALUE;
                    }
                    symbol_7 = raw_ast;
                }
                else {
                    symbol_7 = ValueUtil.FALSE_VALUE;
                }
                raw_aPackage = symbol_7;
            }
            else {
                raw_aPackage = ValueUtil.FALSE_VALUE;
            }
            return raw_aPackage;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_OrderedSet_PackageCS", e);
        }
    }
    
    /**
     * 
     * map m_OrderedSet_RootCS in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lRootCS : minioclcs::RootCS[1];
     *  |)
     * {packages : OrderedSet(minioclcs::PackageCS)[*|1];
     *  |}
     * rightAS ( |)
     * {aRoot : miniocl::Root[1];
     * asOrderedSet : OrderedSet(miniocl::Package)[*|1];
     * ast : miniocl::Element[1];
     * _'\u00ABcollect\u00BB' : Sequence(miniocl::Package)[*|1];
     *  |}
     * where ( |)
     * { |
     * aRoot := lRootCS.ast;
     * ast := lRootCS.ast;
     * packages := lRootCS.packages;
     * _'\u00ABcollect\u00BB' := packages->collect(_'1_' |
     *     _'1_'.ast.oclAsType(miniocl::Package))
     *   ;
     * asOrderedSet := _'\u00ABcollect\u00BB'->asOrderedSet();
     * aRoot.ownedPackages := asOrderedSet;
     * }
     * 
     */
    protected boolean MAP_m_OrderedSet_RootCS(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull RootCS lRootCS)  {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lRootCS.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aRoot;
            if (symbol_0) {
                final /*@NonInvalid*/ boolean symbol_1 = ast instanceof Root;
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_5;
                if (symbol_1) {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Root symbol_2 = (Root)ast;
                    if (symbol_2 == null) {
                        throw throwNull(lRootCS, "Null where non-null value required");
                    }
                    final /*@Thrown*/ boolean symbol_3 = ast != null;
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                    if (symbol_3) {
                        if (ast == null) {
                            throw throwNull(lRootCS, "Null where non-null value required");
                        }
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PackageCS> packages = lRootCS.getPackages();
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
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast_1 = _1.getAst();
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Package oclAsType = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_1, TYP_miniocl_c_c_Package_0));
                            //
                            accumulator.add(oclAsType);
                        }
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
                        // property assignments
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Package> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, asOrderedSet);
                        symbol_2.getOwnedPackages().addAll(ECORE_asOrderedSet);
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_OrderedSet_RootCS = ValueUtil.TRUE_VALUE;
                        raw_ast = m_OrderedSet_RootCS;
                    }
                    else {
                        raw_ast = ValueUtil.FALSE_VALUE;
                    }
                    symbol_5 = raw_ast;
                }
                else {
                    symbol_5 = ValueUtil.FALSE_VALUE;
                }
                raw_aRoot = symbol_5;
            }
            else {
                raw_aRoot = ValueUtil.FALSE_VALUE;
            }
            return raw_aRoot;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_OrderedSet_RootCS", e);
        }
    }
    
    /**
     * 
     * map m_Package_PackageCS in MiniOCLCS2AS_qvtp_qvtcas {leftCS (lPackageCS : minioclcs::PackageCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize rPackage : miniocl::Package[1];
     *  |}
     * where ( |)
     * { |
     * lPackageCS.ast := rPackage;
     * }
     * 
     */
    protected boolean MAP_m_Package_PackageCS(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PackageCS lPackageCS_0)  {
        try {
            // predicates and unrealized variables
            // creations
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package rPackage = MiniOCLFactory.eINSTANCE.createPackage();
            assert rPackage != null;
            models[1/*rightAS*/].add(rPackage);
            // property assignments
            lPackageCS_0.setAst(rPackage);
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Package_PackageCS = ValueUtil.TRUE_VALUE;
            return m_Package_PackageCS;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_Package_PackageCS", e);
        }
    }
    
    /**
     * 
     * map m_ParameterCS_ast_typeRef in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lParameterCS : minioclcs::ParameterCS[1];
     *  |)
     * {typeRef : minioclcs::PathNameCS[?];
     *  |}
     * rightAS ( |)
     * {aParameter : miniocl::Parameter[1];
     * ast : miniocl::Element[1];
     * type : miniocl::Class[1];
     *  |}
     * where ( |)
     * { |
     * aParameter := lParameterCS.ast;
     * ast := lParameterCS.ast;
     * typeRef := lParameterCS.typeRef;
     * type := aParameter.lookupClass(typeRef);
     * aParameter.type := type;
     * }
     * 
     */
    protected boolean MAP_m_ParameterCS_ast_typeRef(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ParameterCS lParameterCS)  {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lParameterCS.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aParameter;
            if (symbol_0) {
                final /*@NonInvalid*/ boolean symbol_1 = ast instanceof Parameter;
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_8;
                if (symbol_1) {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Parameter symbol_2 = (Parameter)ast;
                    if (symbol_2 == null) {
                        throw throwNull(lParameterCS, "Null where non-null value required");
                    }
                    final /*@Thrown*/ boolean symbol_3 = ast != null;
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                    if (symbol_3) {
                        if (ast == null) {
                            throw throwNull(lParameterCS, "Null where non-null value required");
                        }
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS typeRef = lParameterCS.getTypeRef();
                        if (typeRef == null) {
                            throw throwNull(lParameterCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                        }
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = typeRef.getPath();
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
                        final /*@Thrown*/ boolean eq = size.equals(INT_1);
                        /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_5;
                        if (eq) {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                            if (aPathElementCS == null) {
                                throw throwNull(lParameterCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName = aPathElementCS.getPathName();
                            MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Class> _lookupResult = lookupSolver._lookupUnqualifiedClass(symbol_2, (String)pathName);
                            org.eclipse.qvtd.doc.miniocl.Class _lookupUnqualifiedClass = null;
                            if (_lookupResult.size() == 1) {
                                _lookupUnqualifiedClass = _lookupResult.getSingleResult();
                            } else {
                                handleLookupError(aPathElementCS,pathName);
                            };
                            symbol_5 = _lookupUnqualifiedClass;
                        }
                        else {
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
                            final List<PathElementCS> UNBOXED_qualifierSegments = qualifierSegments.asEcoreObjects(idResolver, PathElementCS.class);
                            assert UNBOXED_qualifierSegments != null;
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package qualifier = this.lookupPackage(symbol_2, UNBOXED_qualifierSegments);
                            /*@Caught*/ @Nullable Object CAUGHT_qualifier;
                            try {
                                CAUGHT_qualifier = qualifier;
                            }
                            catch (Exception e) {
                                CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                            }
                            final /*@NonInvalid*/ @NonNull Object symbol_4 = CAUGHT_qualifier == null;
                            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
                            if (symbol_4 == Boolean.TRUE) {
                                safe_lookupQualifiedClass_source = null;
                            }
                            else {
                                if (qualifier == null) {
                                    throw throwNull(lParameterCS, "Null where non-null value required");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                                if (aPathElementCS_0 == null) {
                                    throw throwNull(lParameterCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                                }
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName_0 = aPathElementCS_0.getPathName();
                                MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Class> _lookupResult_0 = lookupSolver._lookupQualifiedClass(qualifier, (String)pathName_0);
                                org.eclipse.qvtd.doc.miniocl.Class _lookupQualifiedClass = null;
                                if (_lookupResult_0.size() == 1) {
                                    _lookupQualifiedClass = _lookupResult_0.getSingleResult();
                                } else {
                                    handleLookupError(aPathElementCS_0,pathName_0);
                                };
                                safe_lookupQualifiedClass_source = _lookupQualifiedClass;
                            }
                            symbol_5 = safe_lookupQualifiedClass_source;
                        }
                        final /*@Thrown*/ boolean symbol_6 = symbol_5 != null;
                        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_type;
                        if (symbol_6) {
                            if (symbol_5 == null) {
                                throw throwNull(lParameterCS, "Null where non-null value required");
                            }
                            // property assignments
                            symbol_2.setType(symbol_5);
                            objectManager.assigned(symbol_2, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, symbol_5, null);
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_ParameterCS_ast_typeRef = ValueUtil.TRUE_VALUE;
                            raw_type = m_ParameterCS_ast_typeRef;
                        }
                        else {
                            raw_type = ValueUtil.FALSE_VALUE;
                        }
                        raw_ast = raw_type;
                    }
                    else {
                        raw_ast = ValueUtil.FALSE_VALUE;
                    }
                    symbol_8 = raw_ast;
                }
                else {
                    symbol_8 = ValueUtil.FALSE_VALUE;
                }
                raw_aParameter = symbol_8;
            }
            else {
                raw_aParameter = ValueUtil.FALSE_VALUE;
            }
            return raw_aParameter;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_ParameterCS_ast_typeRef", e);
        }
    }
    
    /**
     * 
     * map m_Parameter_ParameterCS in MiniOCLCS2AS_qvtp_qvtcas {leftCS (lParameterCS : minioclcs::ParameterCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize rParameter : miniocl::Parameter[1];
     *  |}
     * where ( |)
     * { |
     * lParameterCS.ast := rParameter;
     * }
     * 
     */
    protected boolean MAP_m_Parameter_ParameterCS(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ParameterCS lParameterCS_0)  {
        try {
            // predicates and unrealized variables
            // creations
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Parameter rParameter = MiniOCLFactory.eINSTANCE.createParameter();
            assert rParameter != null;
            models[1/*rightAS*/].add(rParameter);
            // property assignments
            lParameterCS_0.setAst(rParameter);
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Parameter_ParameterCS = ValueUtil.TRUE_VALUE;
            return m_Parameter_ParameterCS;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_Parameter_ParameterCS", e);
        }
    }
    
    /**
     * 
     * map m_PropertyCS_ast_typeRef in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lPropertyCS : minioclcs::PropertyCS[1];
     *  |)
     * {typeRef : minioclcs::PathNameCS[?];
     *  |}
     * rightAS ( |)
     * {aProperty : miniocl::Property[1];
     * ast : miniocl::Element[1];
     * type : miniocl::Class[1];
     *  |}
     * where ( |)
     * { |
     * aProperty := lPropertyCS.ast;
     * ast := lPropertyCS.ast;
     * typeRef := lPropertyCS.typeRef;
     * type := aProperty.lookupClass(typeRef);
     * aProperty.type := type;
     * }
     * 
     */
    protected boolean MAP_m_PropertyCS_ast_typeRef(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PropertyCS lPropertyCS)  {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lPropertyCS.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aProperty;
            if (symbol_0) {
                final /*@NonInvalid*/ boolean symbol_1 = ast instanceof org.eclipse.qvtd.doc.miniocl.Property;
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_8;
                if (symbol_1) {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Property symbol_2 = (org.eclipse.qvtd.doc.miniocl.Property)ast;
                    if (symbol_2 == null) {
                        throw throwNull(lPropertyCS, "Null where non-null value required");
                    }
                    final /*@Thrown*/ boolean symbol_3 = ast != null;
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                    if (symbol_3) {
                        if (ast == null) {
                            throw throwNull(lPropertyCS, "Null where non-null value required");
                        }
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS typeRef = lPropertyCS.getTypeRef();
                        if (typeRef == null) {
                            throw throwNull(lPropertyCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                        }
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = typeRef.getPath();
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
                        final /*@Thrown*/ boolean eq = size.equals(INT_1);
                        /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_5;
                        if (eq) {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                            if (aPathElementCS == null) {
                                throw throwNull(lPropertyCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName = aPathElementCS.getPathName();
                            MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Class> _lookupResult = lookupSolver._lookupUnqualifiedClass(symbol_2, (String)pathName);
                            org.eclipse.qvtd.doc.miniocl.Class _lookupUnqualifiedClass = null;
                            if (_lookupResult.size() == 1) {
                                _lookupUnqualifiedClass = _lookupResult.getSingleResult();
                            } else {
                                handleLookupError(aPathElementCS,pathName);
                            };
                            symbol_5 = _lookupUnqualifiedClass;
                        }
                        else {
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
                            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
                            final List<PathElementCS> UNBOXED_qualifierSegments = qualifierSegments.asEcoreObjects(idResolver, PathElementCS.class);
                            assert UNBOXED_qualifierSegments != null;
                            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Package qualifier = this.lookupPackage(symbol_2, UNBOXED_qualifierSegments);
                            /*@Caught*/ @Nullable Object CAUGHT_qualifier;
                            try {
                                CAUGHT_qualifier = qualifier;
                            }
                            catch (Exception e) {
                                CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                            }
                            final /*@NonInvalid*/ @NonNull Object symbol_4 = CAUGHT_qualifier == null;
                            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
                            if (symbol_4 == Boolean.TRUE) {
                                safe_lookupQualifiedClass_source = null;
                            }
                            else {
                                if (qualifier == null) {
                                    throw throwNull(lPropertyCS, "Null where non-null value required");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                                if (aPathElementCS_0 == null) {
                                    throw throwNull(lPropertyCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                                }
                                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName_0 = aPathElementCS_0.getPathName();
                                MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Class> _lookupResult_0 = lookupSolver._lookupQualifiedClass(qualifier, (String)pathName_0);
                                org.eclipse.qvtd.doc.miniocl.Class _lookupQualifiedClass = null;
                                if (_lookupResult_0.size() == 1) {
                                    _lookupQualifiedClass = _lookupResult_0.getSingleResult();
                                } else {
                                    handleLookupError(aPathElementCS_0,pathName_0);
                                };
                                safe_lookupQualifiedClass_source = _lookupQualifiedClass;
                            }
                            symbol_5 = safe_lookupQualifiedClass_source;
                        }
                        final /*@Thrown*/ boolean symbol_6 = symbol_5 != null;
                        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_type;
                        if (symbol_6) {
                            if (symbol_5 == null) {
                                throw throwNull(lPropertyCS, "Null where non-null value required");
                            }
                            // property assignments
                            symbol_2.setType(symbol_5);
                            objectManager.assigned(symbol_2, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, symbol_5, null);
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_PropertyCS_ast_typeRef = ValueUtil.TRUE_VALUE;
                            raw_type = m_PropertyCS_ast_typeRef;
                        }
                        else {
                            raw_type = ValueUtil.FALSE_VALUE;
                        }
                        raw_ast = raw_type;
                    }
                    else {
                        raw_ast = ValueUtil.FALSE_VALUE;
                    }
                    symbol_8 = raw_ast;
                }
                else {
                    symbol_8 = ValueUtil.FALSE_VALUE;
                }
                raw_aProperty = symbol_8;
            }
            else {
                raw_aProperty = ValueUtil.FALSE_VALUE;
            }
            return raw_aProperty;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_PropertyCS_ast_typeRef", e);
        }
    }
    
    /**
     * 
     * map m_PropertyCallExp_NameExpCS in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lNameExpCS : minioclcs::NameExpCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize rPropertyCallExp : miniocl::PropertyCallExp[1];
     *  |}
     * where ( |
     * lNameExpCS.isPropCallExpWithExplicitSource())
     * { |
     * lNameExpCS.ast := rPropertyCallExp;
     * }
     * 
     */
    protected boolean MAP_m_PropertyCallExp_NameExpCS(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_7)  {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            /*@Caught*/ @NonNull Object CAUGHT_eq;
            try {
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_7.getRoundedBrackets();
                final /*@Thrown*/ boolean eq = roundedBrackets == null;
                CAUGHT_eq = eq;
            }
            catch (Exception e) {
                CAUGHT_eq = ValueUtil.createInvalidValue(e);
            }
            /*@Caught*/ @NonNull Object CAUGHT_symbol_1;
            try {
                final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_7);
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
                final /*@Thrown*/ boolean eq_0 = symbol_0 == null;
                /*@Thrown*/ boolean symbol_1;
                if (eq_0) {
                    symbol_1 = ValueUtil.FALSE_VALUE;
                }
                else {
                    if (symbol_0 == null) {
                        throw throwNull(lNameExpCS_7, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp = symbol_0.getNameExp();
                    final /*@Thrown*/ boolean eq_1 = lNameExpCS_7.equals(nameExp);
                    symbol_1 = eq_1;
                }
                CAUGHT_symbol_1 = symbol_1;
            }
            catch (Exception e) {
                CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_1);
            if (and == null) {
                throw throwNull(lNameExpCS_7, "Null if condition");
            }
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_3;
            if (and) {
                // creations
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable PropertyCallExp rPropertyCallExp = MiniOCLFactory.eINSTANCE.createPropertyCallExp();
                assert rPropertyCallExp != null;
                models[1/*rightAS*/].add(rPropertyCallExp);
                // property assignments
                lNameExpCS_7.setAst(rPropertyCallExp);
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_PropertyCallExp_NameExpCS = ValueUtil.TRUE_VALUE;
                symbol_3 = m_PropertyCallExp_NameExpCS;
            }
            else {
                symbol_3 = ValueUtil.FALSE_VALUE;
            }
            return symbol_3;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_PropertyCallExp_NameExpCS", e);
        }
    }
    
    /**
     * 
     * map m_PropertyCallExp_NameExpCS_NamedElement_Variable in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lNameExpCS : minioclcs::NameExpCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize rPropertyCallExp : miniocl::PropertyCallExp[1];
     *  |}
     * where ( |
     * not lNameExpCS.isVariableExp()
     *   lNameExpCS.isPropCallExpWithImplicitSource()
     *   not lNameExpCS.isPropCallExpWithExplicitSource())
     * { |
     * lNameExpCS.ast := rPropertyCallExp;
     * }
     * 
     */
    protected boolean MAP_m_PropertyCallExp_NameExpCS_NamedElement_Variable(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_8)  {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            /*@Caught*/ @Nullable Object CAUGHT_and_0;
            try {
                /*@Caught*/ @Nullable Object CAUGHT_and;
                try {
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
                        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_8);
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
                        final /*@Thrown*/ boolean eq_0 = symbol_0 == null;
                        /*@Thrown*/ boolean symbol_1;
                        if (eq_0) {
                            symbol_1 = ValueUtil.FALSE_VALUE;
                        }
                        else {
                            if (symbol_0 == null) {
                                throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                            }
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp = symbol_0.getNameExp();
                            final /*@Thrown*/ boolean eq_1 = lNameExpCS_8.equals(nameExp);
                            symbol_1 = eq_1;
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(symbol_1);
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
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName = lNameExpCS_8.getExpName();
                    if (expName == null) {
                        throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                    }
                    @SuppressWarnings("null")
                    final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> path = expName.getPath();
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_path = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path);
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_path);
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
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element self_1 = lNameExpCS_8.getAst();
                if (self_1 == null) {
                    throw throwNull(lNameExpCS_8, "Null where non-null value required");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName_0 = lNameExpCS_8.getExpName();
                if (expName_0 == null) {
                    throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> path_0 = expName_0.getPath();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_path_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path_0);
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_path_0);
                if (aPathElementCS == null) {
                    throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName = aPathElementCS.getPathName();
                MiniOCLLookupResult<Variable> _lookupResult = lookupSolver._lookupUnqualifiedVariable(self_1, (String)pathName);
                Variable _lookupUnqualifiedVariable = null;
                if (_lookupResult.size() == 1) {
                    _lookupUnqualifiedVariable = _lookupResult.getSingleResult();
                } else {
                    handleLookupError(aPathElementCS,pathName);
                };
                final /*@Thrown*/ boolean ne = _lookupUnqualifiedVariable != null;
                CAUGHT_ne = ne;
            }
            catch (Exception e) {
                CAUGHT_ne = ValueUtil.createInvalidValue(e);
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_0, CAUGHT_ne);
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(and_1);
            if (not_0 == null) {
                throw throwNull(lNameExpCS_8, "Null if condition");
            }
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_9;
            if (not_0) {
                /*@Caught*/ @Nullable Object CAUGHT_and_2;
                try {
                    /*@Caught*/ @NonNull Object CAUGHT_eq_3;
                    try {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_8.getRoundedBrackets();
                        final /*@Thrown*/ boolean eq_3 = roundedBrackets_0 == null;
                        CAUGHT_eq_3 = eq_3;
                    }
                    catch (Exception e) {
                        CAUGHT_eq_3 = ValueUtil.createInvalidValue(e);
                    }
                    /*@Caught*/ @Nullable Object CAUGHT_not_1;
                    try {
                        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_8);
                        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_CallExpCS_4 = idResolver.getClass(CLSSid_CallExpCS, null);
                        final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, container_0, TYP_minioclcs_c_c_CallExpCS_4).booleanValue();
                        /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS symbol_2;
                        if (oclIsKindOf_0) {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CallExpCS oclAsType_0 = ClassUtil.nonNullState((CallExpCS)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container_0, TYP_minioclcs_c_c_CallExpCS_4));
                            symbol_2 = oclAsType_0;
                        }
                        else {
                            symbol_2 = null;
                        }
                        final /*@Thrown*/ boolean eq_4 = symbol_2 == null;
                        /*@Thrown*/ boolean symbol_3;
                        if (eq_4) {
                            symbol_3 = ValueUtil.FALSE_VALUE;
                        }
                        else {
                            if (symbol_2 == null) {
                                throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                            }
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp_0 = symbol_2.getNameExp();
                            final /*@Thrown*/ boolean eq_5 = lNameExpCS_8.equals(nameExp_0);
                            symbol_3 = eq_5;
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_1 = BooleanNotOperation.INSTANCE.evaluate(symbol_3);
                        CAUGHT_not_1 = not_1;
                    }
                    catch (Exception e) {
                        CAUGHT_not_1 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_3, CAUGHT_not_1);
                    CAUGHT_and_2 = and_2;
                }
                catch (Exception e) {
                    CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
                }
                /*@Caught*/ @NonNull Object CAUGHT_eq_6;
                try {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element self_2 = lNameExpCS_8.getAst();
                    if (self_2 == null) {
                        throw throwNull(lNameExpCS_8, "Null where non-null value required");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName_1 = lNameExpCS_8.getExpName();
                    if (expName_1 == null) {
                        throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                    }
                    @SuppressWarnings("null")
                    final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> path_1 = expName_1.getPath();
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_path_1 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path_1);
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_path_1);
                    if (aPathElementCS_0 == null) {
                        throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName_0 = aPathElementCS_0.getPathName();
                    MiniOCLLookupResult<Variable> _lookupResult_0 = lookupSolver._lookupUnqualifiedVariable(self_2, (String)pathName_0);
                    Variable _lookupUnqualifiedVariable_0 = null;
                    if (_lookupResult_0.size() == 1) {
                        _lookupUnqualifiedVariable_0 = _lookupResult_0.getSingleResult();
                    } else {
                        handleLookupError(aPathElementCS_0,pathName_0);
                    };
                    final /*@Thrown*/ boolean eq_6 = _lookupUnqualifiedVariable_0 == null;
                    CAUGHT_eq_6 = eq_6;
                }
                catch (Exception e) {
                    CAUGHT_eq_6 = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_3 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_2, CAUGHT_eq_6);
                if (and_3 == null) {
                    throw throwNull(lNameExpCS_8, "Null if condition");
                }
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_8;
                if (and_3) {
                    /*@Caught*/ @NonNull Object CAUGHT_eq_7;
                    try {
                        final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets_1 = lNameExpCS_8.getRoundedBrackets();
                        final /*@Thrown*/ boolean eq_7 = roundedBrackets_1 == null;
                        CAUGHT_eq_7 = eq_7;
                    }
                    catch (Exception e) {
                        CAUGHT_eq_7 = ValueUtil.createInvalidValue(e);
                    }
                    /*@Caught*/ @NonNull Object CAUGHT_symbol_5;
                    try {
                        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container_1 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_8);
                        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_CallExpCS_6 = idResolver.getClass(CLSSid_CallExpCS, null);
                        final /*@Thrown*/ boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, container_1, TYP_minioclcs_c_c_CallExpCS_6).booleanValue();
                        /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS symbol_4;
                        if (oclIsKindOf_1) {
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CallExpCS oclAsType_1 = ClassUtil.nonNullState((CallExpCS)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container_1, TYP_minioclcs_c_c_CallExpCS_6));
                            symbol_4 = oclAsType_1;
                        }
                        else {
                            symbol_4 = null;
                        }
                        final /*@Thrown*/ boolean eq_8 = symbol_4 == null;
                        /*@Thrown*/ boolean symbol_5;
                        if (eq_8) {
                            symbol_5 = ValueUtil.FALSE_VALUE;
                        }
                        else {
                            if (symbol_4 == null) {
                                throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                            }
                            final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp_1 = symbol_4.getNameExp();
                            final /*@Thrown*/ boolean eq_9 = lNameExpCS_8.equals(nameExp_1);
                            symbol_5 = eq_9;
                        }
                        CAUGHT_symbol_5 = symbol_5;
                    }
                    catch (Exception e) {
                        CAUGHT_symbol_5 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_4 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_7, CAUGHT_symbol_5);
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_2 = BooleanNotOperation.INSTANCE.evaluate(and_4);
                    if (not_2 == null) {
                        throw throwNull(lNameExpCS_8, "Null if condition");
                    }
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_7;
                    if (not_2) {
                        // creations
                        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable PropertyCallExp rPropertyCallExp = MiniOCLFactory.eINSTANCE.createPropertyCallExp();
                        assert rPropertyCallExp != null;
                        models[1/*rightAS*/].add(rPropertyCallExp);
                        // property assignments
                        lNameExpCS_8.setAst(rPropertyCallExp);
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_PropertyCallExp_NameExpCS_NamedElement_Variable = ValueUtil.TRUE_VALUE;
                        symbol_7 = m_PropertyCallExp_NameExpCS_NamedElement_Variable;
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
            return symbol_9;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_PropertyCallExp_NameExpCS_NamedElement_Variable", e);
        }
    }
    
    /**
     * 
     * map m_Property_PropertyCS in MiniOCLCS2AS_qvtp_qvtcas {leftCS (lPropertyCS : minioclcs::PropertyCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize rProperty : miniocl::Property[1];
     *  |}
     * where ( |)
     * { |
     * lPropertyCS.ast := rProperty;
     * }
     * 
     */
    protected boolean MAP_m_Property_PropertyCS(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PropertyCS lPropertyCS_0)  {
        try {
            // predicates and unrealized variables
            // creations
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Property rProperty = MiniOCLFactory.eINSTANCE.createProperty();
            assert rProperty != null;
            models[1/*rightAS*/].add(rProperty);
            // property assignments
            lPropertyCS_0.setAst(rProperty);
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Property_PropertyCS = ValueUtil.TRUE_VALUE;
            return m_Property_PropertyCS;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_Property_PropertyCS", e);
        }
    }
    
    /**
     * 
     * map m_Root_RootCS in MiniOCLCS2AS_qvtp_qvtcas {leftCS (lRootCS : minioclcs::RootCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize rRoot : miniocl::Root[1];
     *  |}
     * where ( |)
     * { |
     * lRootCS.ast := rRoot;
     * }
     * 
     */
    protected boolean MAP_m_Root_RootCS(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull RootCS lRootCS_0)  {
        try {
            // predicates and unrealized variables
            // creations
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Root rRoot = MiniOCLFactory.eINSTANCE.createRoot();
            assert rRoot != null;
            models[1/*rightAS*/].add(rRoot);
            // property assignments
            lRootCS_0.setAst(rRoot);
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Root_RootCS = ValueUtil.TRUE_VALUE;
            return m_Root_RootCS;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_Root_RootCS", e);
        }
    }
    
    /**
     * 
     * map m_String_ParameterCS in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lParameterCS : minioclcs::ParameterCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {aParameter : miniocl::Parameter[1];
     * ast : miniocl::Element[1];
     *  |}
     * where ( |)
     * {name : ecore::EString[?];
     * toString : String[1];
     *  |
     * aParameter := lParameterCS.ast;
     * ast := lParameterCS.ast;
     * name := lParameterCS.name;
     * toString := name.toString();
     * aParameter.name := toString;
     * }
     * 
     */
    protected boolean MAP_m_String_ParameterCS(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull ParameterCS lParameterCS_1)  {
        try {
            // predicates and unrealized variables
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lParameterCS_1.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aParameter;
            if (symbol_0) {
                final /*@NonInvalid*/ boolean symbol_1 = ast instanceof Parameter;
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_5;
                if (symbol_1) {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Parameter symbol_2 = (Parameter)ast;
                    if (symbol_2 == null) {
                        throw throwNull(lParameterCS_1, "Null where non-null value required");
                    }
                    final /*@Thrown*/ boolean symbol_3 = ast != null;
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                    if (symbol_3) {
                        if (ast == null) {
                            throw throwNull(lParameterCS_1, "Null where non-null value required");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = lParameterCS_1.getName();
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
                        // property assignments
                        symbol_2.setName(toString);
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_String_ParameterCS = ValueUtil.TRUE_VALUE;
                        raw_ast = m_String_ParameterCS;
                    }
                    else {
                        raw_ast = ValueUtil.FALSE_VALUE;
                    }
                    symbol_5 = raw_ast;
                }
                else {
                    symbol_5 = ValueUtil.FALSE_VALUE;
                }
                raw_aParameter = symbol_5;
            }
            else {
                raw_aParameter = ValueUtil.FALSE_VALUE;
            }
            return raw_aParameter;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_String_ParameterCS", e);
        }
    }
    
    /**
     * 
     * map m_String_PropertyCS in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lPropertyCS : minioclcs::PropertyCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {aProperty : miniocl::Property[1];
     * ast : miniocl::Element[1];
     *  |}
     * where ( |)
     * {name : ecore::EString[?];
     * toString : String[1];
     *  |
     * aProperty := lPropertyCS.ast;
     * ast := lPropertyCS.ast;
     * name := lPropertyCS.name;
     * toString := name.toString();
     * aProperty.name := toString;
     * }
     * 
     */
    protected boolean MAP_m_String_PropertyCS(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull PropertyCS lPropertyCS_1)  {
        try {
            // predicates and unrealized variables
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element ast = lPropertyCS_1.getAst();
            final /*@Thrown*/ boolean symbol_0 = ast != null;
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_aProperty;
            if (symbol_0) {
                final /*@NonInvalid*/ boolean symbol_1 = ast instanceof org.eclipse.qvtd.doc.miniocl.Property;
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_5;
                if (symbol_1) {
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Property symbol_2 = (org.eclipse.qvtd.doc.miniocl.Property)ast;
                    if (symbol_2 == null) {
                        throw throwNull(lPropertyCS_1, "Null where non-null value required");
                    }
                    final /*@Thrown*/ boolean symbol_3 = ast != null;
                    /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean raw_ast;
                    if (symbol_3) {
                        if (ast == null) {
                            throw throwNull(lPropertyCS_1, "Null where non-null value required");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = lPropertyCS_1.getName();
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
                        // property assignments
                        symbol_2.setName(toString);
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_String_PropertyCS = ValueUtil.TRUE_VALUE;
                        raw_ast = m_String_PropertyCS;
                    }
                    else {
                        raw_ast = ValueUtil.FALSE_VALUE;
                    }
                    symbol_5 = raw_ast;
                }
                else {
                    symbol_5 = ValueUtil.FALSE_VALUE;
                }
                raw_aProperty = symbol_5;
            }
            else {
                raw_aProperty = ValueUtil.FALSE_VALUE;
            }
            return raw_aProperty;
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_String_PropertyCS", e);
        }
    }
    
    /**
     * 
     * map m_VariableExp_NameExpCS_NamedElement_Variable in MiniOCLCS2AS_qvtp_qvtcas {
     *   leftCS (lNameExpCS : minioclcs::NameExpCS[1];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize rVariableExp : miniocl::VariableExp[1];
     *  |}
     * where ( |
     * not lNameExpCS.isPropCallExpWithExplicitSource()
     *   lNameExpCS.isVariableExp())
     * { |
     * lNameExpCS.ast := rVariableExp;
     * }
     * 
     */
    protected boolean MAP_m_VariableExp_NameExpCS_NamedElement_Variable(final /*@NonInvalid*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull NameExpCS lNameExpCS_9)  {
        try {
            // predicates and unrealized variables
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            /*@Caught*/ @NonNull Object CAUGHT_eq;
            try {
                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_9.getRoundedBrackets();
                final /*@Thrown*/ boolean eq = roundedBrackets == null;
                CAUGHT_eq = eq;
            }
            catch (Exception e) {
                CAUGHT_eq = ValueUtil.createInvalidValue(e);
            }
            /*@Caught*/ @NonNull Object CAUGHT_symbol_1;
            try {
                final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_9);
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
                final /*@Thrown*/ boolean eq_0 = symbol_0 == null;
                /*@Thrown*/ boolean symbol_1;
                if (eq_0) {
                    symbol_1 = ValueUtil.FALSE_VALUE;
                }
                else {
                    if (symbol_0 == null) {
                        throw throwNull(lNameExpCS_9, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp = symbol_0.getNameExp();
                    final /*@Thrown*/ boolean eq_1 = lNameExpCS_9.equals(nameExp);
                    symbol_1 = eq_1;
                }
                CAUGHT_symbol_1 = symbol_1;
            }
            catch (Exception e) {
                CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_symbol_1);
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(and);
            if (not == null) {
                throw throwNull(lNameExpCS_9, "Null if condition");
            }
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_6;
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
                            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object container_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, lNameExpCS_9);
                            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_minioclcs_c_c_CallExpCS_4 = idResolver.getClass(CLSSid_CallExpCS, null);
                            final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, container_0, TYP_minioclcs_c_c_CallExpCS_4).booleanValue();
                            /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable CallExpCS symbol_2;
                            if (oclIsKindOf_0) {
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.NonNull CallExpCS oclAsType_0 = ClassUtil.nonNullState((CallExpCS)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container_0, TYP_minioclcs_c_c_CallExpCS_4));
                                symbol_2 = oclAsType_0;
                            }
                            else {
                                symbol_2 = null;
                            }
                            final /*@Thrown*/ boolean eq_3 = symbol_2 == null;
                            /*@Thrown*/ boolean symbol_3;
                            if (eq_3) {
                                symbol_3 = ValueUtil.FALSE_VALUE;
                            }
                            else {
                                if (symbol_2 == null) {
                                    throw throwNull(lNameExpCS_9, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::nameExp\'");
                                }
                                final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable NameExpCS nameExp_0 = symbol_2.getNameExp();
                                final /*@Thrown*/ boolean eq_4 = lNameExpCS_9.equals(nameExp_0);
                                symbol_3 = eq_4;
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(symbol_3);
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
                            throw throwNull(lNameExpCS_9, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                        }
                        @SuppressWarnings("null")
                        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> path = expName.getPath();
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_path = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path);
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_path);
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
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Element self_1 = lNameExpCS_9.getAst();
                    if (self_1 == null) {
                        throw throwNull(lNameExpCS_9, "Null where non-null value required");
                    }
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathNameCS expName_0 = lNameExpCS_9.getExpName();
                    if (expName_0 == null) {
                        throw throwNull(lNameExpCS_9, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::path\'");
                    }
                    @SuppressWarnings("null")
                    final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> path_0 = expName_0.getPath();
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_path_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, path_0);
                    final /*@Thrown*/ org.eclipse.qvtd.doc.minioclcs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_path_0);
                    if (aPathElementCS == null) {
                        throw throwNull(lNameExpCS_9, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::pathName\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String pathName = aPathElementCS.getPathName();
                    MiniOCLLookupResult<Variable> _lookupResult = lookupSolver._lookupUnqualifiedVariable(self_1, (String)pathName);
                    Variable _lookupUnqualifiedVariable = null;
                    if (_lookupResult.size() == 1) {
                        _lookupUnqualifiedVariable = _lookupResult.getSingleResult();
                    } else {
                        handleLookupError(aPathElementCS,pathName);
                    };
                    final /*@Thrown*/ boolean ne = _lookupUnqualifiedVariable != null;
                    CAUGHT_ne = ne;
                }
                catch (Exception e) {
                    CAUGHT_ne = ValueUtil.createInvalidValue(e);
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_1, CAUGHT_ne);
                if (and_2 == null) {
                    throw throwNull(lNameExpCS_9, "Null if condition");
                }
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_5;
                if (and_2) {
                    // creations
                    final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable VariableExp rVariableExp = MiniOCLFactory.eINSTANCE.createVariableExp();
                    assert rVariableExp != null;
                    models[1/*rightAS*/].add(rVariableExp);
                    // property assignments
                    lNameExpCS_9.setAst(rVariableExp);
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_VariableExp_NameExpCS_NamedElement_Variable = ValueUtil.TRUE_VALUE;
                    symbol_5 = m_VariableExp_NameExpCS_NamedElement_Variable;
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
        } catch (Throwable e) {
            return handleExecutionFailure("MAP_m_VariableExp_NameExpCS_NamedElement_Variable", e);
        }
    }
}
