/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.qvtd.cs2as.compiler.internal.CS2ASJavaCompilerImpl$1
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.qvtd.doc.minioclcs.xtext._MiniOCLCS2AS_qvtm_qvtcas;

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
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.MutableIterable;
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
import org.eclipse.qvtd.doc.minioclcs.xtext.tx.Connection;
import org.eclipse.qvtd.doc.minioclcs.xtext.tx.InvalidEvaluationException;
import org.eclipse.qvtd.doc.minioclcs.xtext.tx.InvocationConstructor;
import org.eclipse.qvtd.doc.minioclcs.xtext.tx.TransformationExecutor;
import org.eclipse.qvtd.doc.minioclcs.xtext.tx.AbstractCS2ASTransformer;
import org.eclipse.qvtd.doc.minioclcs.xtext.internal.tx.AbstractInvocationConstructor;

/**
 * The MiniOCLCS2AS_qvtm_qvtcas transformation:
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
public class MiniOCLCS2AS_qvtm_qvtcas extends AbstractCS2ASTransformer
{
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/doc/MiniOCLCS", null, MinioclcsPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0 = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/doc/MiniOCL/1.0", null, MiniOCLPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_Lookup_s_1_0 = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0", null, EnvironmentPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CSTrace = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("CSTrace", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CallExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("CallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CallExpCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("CallExpCS", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ClassCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("ClassCS", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class_0 = PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Element = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Element", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ExpCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("ExpCS", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ExpressionInOCL = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("ExpressionInOCL", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_LookupEnvironment = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_Lookup_s_1_0.getClassId("LookupEnvironment", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_NameExpCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("NameExpCS", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_NamedElement = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("NamedElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_NavigationExpCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("NavigationExpCS", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OCLExpression = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("OCLExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OpaqueExpression = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("OpaqueExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Operation = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OperationCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("OperationCS", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Package = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Package", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_PackageCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("PackageCS", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Parameter = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Parameter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ParameterCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("ParameterCS", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_PathElementCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("PathElementCS", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_PathNameCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("PathNameCS", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Property = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Property", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_PropertyCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("PropertyCS", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_PropertyCallExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("PropertyCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Root = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Root", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RootCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("RootCS", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RoundedBracketClauseCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("RoundedBracketClauseCS", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TypedElement = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("TypedElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Variable = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Variable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableExp = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("VariableExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Visitable = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Visitable", 0);
	public static final /*@NonInvalid*/ @NonNull DataTypeId DATAid_EString = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EString", 0);
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_1 = ValueUtil.integerValueOf("1");
	public static final /*@NonInvalid*/ @NonNull String STR_OCL = "OCL";
	public static final /*@NonInvalid*/ @NonNull String STR_self = "self";
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Class = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Class);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_ClassCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ClassCS);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_NamedElement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_NamedElement);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Operation = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Operation);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_OperationCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OperationCS);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Package = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Package);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_PackageCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PackageCS);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Parameter = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Parameter);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_ParameterCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ParameterCS);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_PathElementCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PathElementCS);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Property = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Property);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_PropertyCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PropertyCS);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Variable = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Variable);
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_language = CLSSid_OpaqueExpression.getPropertyId("language");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_name = CLSSid_NamedElement.getPropertyId("name");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ownedBody = CLSSid_ExpressionInOCL.getPropertyId("ownedBody");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ownedSelfVar = CLSSid_ExpressionInOCL.getPropertyId("ownedSelfVar");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_parentEnv = CLSSid_LookupEnvironment.getPropertyId("parentEnv");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_referredVariable = CLSSid_VariableExp.getPropertyId("referredVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_type = CLSSid_TypedElement.getPropertyId("type");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Class = TypeId.SEQUENCE.getSpecializedId(CLSSid_Class);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Operation = TypeId.SEQUENCE.getSpecializedId(CLSSid_Operation);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Package = TypeId.SEQUENCE.getSpecializedId(CLSSid_Package);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Parameter = TypeId.SEQUENCE.getSpecializedId(CLSSid_Parameter);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Property = TypeId.SEQUENCE.getSpecializedId(CLSSid_Property);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Class = TypeId.SET.getSpecializedId(CLSSid_Class);

	/*
	 * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
	 */
	private static final @NonNull ClassId @NonNull [] classIndex2classId = new @NonNull ClassId[]{
		CLSSid_CallExpCS,                     // 0 => CallExpCS
		CLSSid_ClassCS,                       // 1 => ClassCS
		CLSSid_NameExpCS,                     // 2 => NameExpCS
		CLSSid_NavigationExpCS,               // 3 => NavigationExpCS
		CLSSid_OperationCS,                   // 4 => OperationCS
		CLSSid_PackageCS,                     // 5 => PackageCS
		CLSSid_ParameterCS,                   // 6 => ParameterCS
		CLSSid_PropertyCS,                    // 7 => PropertyCS
		CLSSid_RootCS                         // 8 => RootCS
	};

	/*
	 * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
	 * may contribute results to an allInstances() invocation.
	 * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
	 * instance of the derived classId contributes to derived and inherited ClassIndexes.
	 */
	private final static int @NonNull [] @NonNull [] classIndex2allClassIndexes = new int @NonNull [] @NonNull [] {
		{0},                          // 0 : CallExpCS -> {CallExpCS}
		{1},                          // 1 : ClassCS -> {ClassCS}
		{2,3,0},                      // 2 : NameExpCS -> {NameExpCS,NavigationExpCS,CallExpCS}
		{3},                          // 3 : NavigationExpCS -> {NavigationExpCS}
		{4},                          // 4 : OperationCS -> {OperationCS}
		{5},                          // 5 : PackageCS -> {PackageCS}
		{6},                          // 6 : ParameterCS -> {ParameterCS}
		{7},                          // 7 : PropertyCS -> {PropertyCS}
		{8}                           // 8 : RootCS -> {RootCS}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR___root__ = new AbstractInvocationConstructor(invocationManager, "__root__", false)
	{
		@Override
		public @NonNull MAP___root__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP___root__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_m_Element__Operation_ownedBodyExpression = new AbstractInvocationConstructor(invocationManager, "m_Element__Operation_ownedBodyExpression", false)
	{
		@Override
		public @NonNull MAP_m_Element__Operation_ownedBodyExpression newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_m_Element__Operation_ownedBodyExpression(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_m_Element__type_1 = new AbstractInvocationConstructor(invocationManager, "m_Element__type_1", false)
	{
		@Override
		public @NonNull MAP_m_Element__type_1 newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_m_Element__type_1(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_m_Element__CallExp_ownedSource = new AbstractInvocationConstructor(invocationManager, "m_Element__CallExp_ownedSource", false)
	{
		@Override
		public @NonNull MAP_m_Element__CallExp_ownedSource newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_m_Element__CallExp_ownedSource(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_m_Element__referredProperty_1 = new AbstractInvocationConstructor(invocationManager, "m_Element__referredProperty_1", false)
	{
		@Override
		public @NonNull MAP_m_Element__referredProperty_1 newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_m_Element__referredProperty_1(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_m_CollectionRange__CallExp_ownedSource = new AbstractInvocationConstructor(invocationManager, "m_CollectionRange__CallExp_ownedSource", false)
	{
		@Override
		public @NonNull MAP_m_CollectionRange__CallExp_ownedSource newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_m_CollectionRange__CallExp_ownedSource(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_m_CollectionRange__referredVariable = new AbstractInvocationConstructor(invocationManager, "m_CollectionRange__referredVariable", false)
	{
		@Override
		public @NonNull MAP_m_CollectionRange__referredVariable newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_m_CollectionRange__referredVariable(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_m_Element__type_2 = new AbstractInvocationConstructor(invocationManager, "m_Element__type_2", false)
	{
		@Override
		public @NonNull MAP_m_Element__type_2 newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_m_Element__type_2(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_m_Element__referredProperty = new AbstractInvocationConstructor(invocationManager, "m_Element__referredProperty", false)
	{
		@Override
		public @NonNull MAP_m_Element__referredProperty newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_m_Element__referredProperty(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_m_Element__type = new AbstractInvocationConstructor(invocationManager, "m_Element__type", false)
	{
		@Override
		public @NonNull MAP_m_Element__type newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_m_Element__type(this, values);
		}
	};

	private final MiniOCLLookupSolver lookupSolver = new MiniOCLLookupSolver(executor);

	public MiniOCLCS2AS_qvtm_qvtcas(final @NonNull TransformationExecutor executor) {
		super(executor, new @NonNull String[] {"leftCS", "rightAS", "$primitive$"}, null, classIndex2classId, classIndex2allClassIndexes);
	}

	@Override
	public boolean run() {
		final @NonNull Connection ji_CallExpCS = models[0/*leftCS*/].getConnection(0/*minioclcs::CallExpCS*/);
		final @NonNull Connection ji_ClassCS = models[0/*leftCS*/].getConnection(1/*minioclcs::ClassCS*/);
		final @NonNull Connection ji_NameExpCS = models[0/*leftCS*/].getConnection(2/*minioclcs::NameExpCS*/);
		final @NonNull Connection ji_NavigationExpCS = models[0/*leftCS*/].getConnection(3/*minioclcs::NavigationExpCS*/);
		final @NonNull Connection ji_OperationCS = models[0/*leftCS*/].getConnection(4/*minioclcs::OperationCS*/);
		final @NonNull Connection ji_PackageCS = models[0/*leftCS*/].getConnection(5/*minioclcs::PackageCS*/);
		final @NonNull Connection ji_ParameterCS = models[0/*leftCS*/].getConnection(6/*minioclcs::ParameterCS*/);
		final @NonNull Connection ji_PropertyCS = models[0/*leftCS*/].getConnection(7/*minioclcs::PropertyCS*/);
		final @NonNull Connection ji_RootCS = models[0/*leftCS*/].getConnection(8/*minioclcs::RootCS*/);
		CTOR___root__.invoke(ji_CallExpCS, ji_ClassCS, ji_NameExpCS, ji_NavigationExpCS, ji_OperationCS, ji_PackageCS, ji_ParameterCS, ji_PropertyCS, ji_RootCS);
		return invocationManager.flush();
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
	public class CACHE_NameExpCS_parentAsCallExpCS extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull NameExpCS self_0 = (/*@NonInvalid*/ @NonNull NameExpCS)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Object container = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, self_0);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_minioclcs_c_c_CallExpCS = idResolver.getClass(CLSSid_CallExpCS, null);
			final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, container, TYP_minioclcs_c_c_CallExpCS).booleanValue();
			/*@Thrown*/ @Nullable CallExpCS symbol_0;
			if (oclIsKindOf) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_minioclcs_c_c_CallExpCS_0 = idResolver.getClass(CLSSid_CallExpCS, null);
				final /*@Thrown*/ @NonNull CallExpCS oclAsType = ClassUtil.nonNullState((CallExpCS)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container, TYP_minioclcs_c_c_CallExpCS_0));
				symbol_0 = oclAsType;
			}
			else {
				symbol_0 = null;
			}
			return symbol_0;
		}

		public CallExpCS evaluate(final /*@NonInvalid*/ @NonNull NameExpCS self_0) {
			return (CallExpCS)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_0});
		}
	}

	protected final @NonNull CACHE_NameExpCS_parentAsCallExpCS INSTANCE_NameExpCS_parentAsCallExpCS = new CACHE_NameExpCS_parentAsCallExpCS();

	/**
	 * miniocl::Visitable::_lookupClass(env : lookup::LookupEnvironment[?], cName : String[?]) : OrderedSet(miniocl::Class)
	 *
	 *
	 * let
	 *   foundClass : OrderedSet(miniocl::Class) = env.namedElements->selectByKind(Class)
	 *   ->select(name = cName)
	 * in
	 *   if foundClass->isEmpty() and not (env.parentEnv = null)
	 *   then _lookupClass(env.parentEnv, cName)
	 *   else foundClass
	 *   endif
	 */
	public class CACHE_Visitable__lookupClass extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Visitable self_1 = (/*@NonInvalid*/ @NonNull Visitable)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable LookupEnvironment env = (/*@NonInvalid*/ @Nullable LookupEnvironment)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @Nullable String cName = (/*@NonInvalid*/ @Nullable String)sourceAndArgumentValues[2];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			/*@Caught*/ @NonNull Object CAUGHT_foundClass;
			try {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Class_1 = idResolver.getClass(CLSSid_Class, null);
				if (env == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::namedElements\'");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull List<NamedElement> namedElements = env.getNamedElements();
				final /*@Thrown*/ @NonNull CollectionValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
				final /*@Thrown*/ @NonNull CollectionValue selectByKind = CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_namedElements, TYP_miniocl_c_c_Class_1);
				/*@Thrown*/ @NonNull MutableIterable accumulator = ValueUtil.createCollectionAccumulatorValue(ORD_CLSSid_Class);
				@NonNull Iterator<Object> ITERATOR__1 = selectByKind.eagerIterator();
				/*@Thrown*/ @NonNull CollectionValue foundClass;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						foundClass = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class _1 = (org.eclipse.qvtd.doc.miniocl.Class)ITERATOR__1.next();
					/**
					 * name = cName
					 */
					final /*@NonInvalid*/ @Nullable String name = _1.getName();
					final /*@NonInvalid*/ boolean eq = (name != null) ? name.equals(cName) : (cName == null);
					//
					if (eq == ValueUtil.TRUE_VALUE) {
						accumulator.mutableIncluding(_1);
					}
				}
				CAUGHT_foundClass = foundClass;
			}
			catch (Exception e) {
				CAUGHT_foundClass = ValueUtil.createInvalidValue(e);
			}
			if (CAUGHT_foundClass instanceof CollectionValue) {
				((CollectionValue)CAUGHT_foundClass).cachedIterable();
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
			/*@Caught*/ @NonNull Object CAUGHT_eq_0;
			try {
				if (env == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
				}
				final /*@Thrown*/ @Nullable LookupEnvironment parentEnv = env.getParentEnv();
				final /*@Thrown*/ boolean eq_0 = parentEnv == null;
				CAUGHT_eq_0 = eq_0;
			}
			catch (Exception e) {
				CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_eq_0);
			final /*@Thrown*/ @Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_isEmpty, not);
			if (and == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @NonNull CollectionValue symbol_0;
			if (and) {
				if (env == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
				}
				final /*@Thrown*/ @Nullable LookupEnvironment parentEnv_0 = env.getParentEnv();
				final /*@Thrown*/ @NonNull CollectionValue _lookupClass = INSTANCE_Visitable__lookupClass.evaluate(self_1, parentEnv_0, cName);
				symbol_0 = _lookupClass;
			}
			else {
				if (CAUGHT_foundClass instanceof InvalidValueException) {
					throw (InvalidValueException)CAUGHT_foundClass;
				}
				symbol_0 = (CollectionValue)CAUGHT_foundClass;
			}
			return symbol_0;
		}

		@SuppressWarnings("null")
		public @NonNull CollectionValue evaluate(final /*@NonInvalid*/ @NonNull Visitable self_1, final /*@NonInvalid*/ @Nullable LookupEnvironment env, final /*@NonInvalid*/ @Nullable String cName) {
			return (@NonNull CollectionValue)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_1, env, cName});
		}
	}

	protected final @NonNull CACHE_Visitable__lookupClass INSTANCE_Visitable__lookupClass = new CACHE_Visitable__lookupClass();

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
	public class CACHE_OclElement_parentEnv_Class extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_4 = (/*@NonInvalid*/ @NonNull Object)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, self_4);
			final /*@NonInvalid*/ boolean eq = parent == null;
			/*@Thrown*/ @NonNull LookupEnvironment symbol_1;
			if (eq) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment = idResolver.getClass(CLSSid_LookupEnvironment, null);
				final /*@NonInvalid*/ @NonNull LookupEnvironment symbol_0 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment.createInstance();
				symbol_1 = symbol_0;
			}
			else {
				if (parent == null) {
					throw new InvalidEvaluationException("Null source for \'OclElement::_unqualified_env_Class(OclElement[?]) : lookup::LookupEnvironment[1]\'");
				}
				final /*@Thrown*/ @NonNull LookupEnvironment _unqualified_env_Class = INSTANCE_OclElement__unqualified_env_Class.evaluate(parent, self_4);
				symbol_1 = _unqualified_env_Class;
			}
			return symbol_1;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_4) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_4});
		}
	}

	protected final @NonNull CACHE_OclElement_parentEnv_Class INSTANCE_OclElement_parentEnv_Class = new CACHE_OclElement_parentEnv_Class();

	/**
	 * ocl::OclElement::_unqualified_env_Class(child : OclElement[?]) : lookup::LookupEnvironment[1]
	 *
	 * parentEnv_Class()
	 */
	public class CACHE_OclElement__unqualified_env_Class extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_3 = (/*@NonInvalid*/ @NonNull Object)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child = (/*@NonInvalid*/ @Nullable Object)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull LookupEnvironment parentEnv_Class = INSTANCE_OclElement_parentEnv_Class.evaluate(self_3);
			return parentEnv_Class;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_3, final /*@NonInvalid*/ @Nullable Object child) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_3, child});
		}
	}

	protected final @NonNull CACHE_OclElement__unqualified_env_Class INST_OclElement__unqualified_env_Class = new CACHE_OclElement__unqualified_env_Class();

	/**
	 * miniocl::Package::_unqualified_env_Class(child : OclElement[?]) : lookup::LookupEnvironment[?]
	 *
	 * parentEnv_Class().nestedEnv().addElements(ownedClasses)
	 */
	public class CACHE_Package__unqualified_env_Class extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package self_5 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Package)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_0 = (/*@NonInvalid*/ @Nullable Object)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull LookupEnvironment self_21 = INSTANCE_OclElement_parentEnv_Class.evaluate(self_5);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
			final /*@Thrown*/ @NonNull LookupEnvironment symbol_0 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
			CTORid_parentEnv.initValue(symbol_0, self_21);
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = self_5.getOwnedClasses();
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull LookupEnvironment addElements = symbol_0.addElements(ownedClasses);
			return addElements;
		}

		public LookupEnvironment evaluate(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package self_5, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_0) {
			return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_5, child_0});
		}
	}

	protected final @NonNull CACHE_Package__unqualified_env_Class INST_Package__unqualified_env_Class = new CACHE_Package__unqualified_env_Class();

	/**
	 * ocl::OclElement::unqualified_env_Class() : lookup::LookupEnvironment[1]
	 *
	 * _unqualified_env_Class(null)
	 */
	public class CACHE_OclElement_unqualified_env_Class extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_2 = (/*@NonInvalid*/ @NonNull Object)sourceAndArgumentValues[0];
			final /*@Thrown*/ @NonNull LookupEnvironment _unqualified_env_Class = INSTANCE_OclElement__unqualified_env_Class.evaluate(self_2, null);
			return _unqualified_env_Class;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_2) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_2});
		}
	}

	protected final @NonNull CACHE_OclElement_unqualified_env_Class INSTANCE_OclElement_unqualified_env_Class = new CACHE_OclElement_unqualified_env_Class();

	/**
	 * miniocl::Visitable::_lookupPackage(env : lookup::LookupEnvironment[?], pName : String[?]) : OrderedSet(miniocl::Package)
	 *
	 *
	 * let
	 *   foundPackage : OrderedSet(miniocl::Package) = env.namedElements->selectByKind(Package)
	 *   ->select(name = pName)
	 * in
	 *   if foundPackage->isEmpty() and not (env.parentEnv = null)
	 *   then _lookupPackage(env.parentEnv, pName)
	 *   else foundPackage
	 *   endif
	 */
	public class CACHE_Visitable__lookupPackage extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Visitable self_7 = (/*@NonInvalid*/ @NonNull Visitable)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable LookupEnvironment env_0 = (/*@NonInvalid*/ @Nullable LookupEnvironment)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @Nullable String pName = (/*@NonInvalid*/ @Nullable String)sourceAndArgumentValues[2];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			/*@Caught*/ @NonNull Object CAUGHT_foundPackage;
			try {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Package_2 = idResolver.getClass(CLSSid_Package, null);
				if (env_0 == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::namedElements\'");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull List<NamedElement> namedElements = env_0.getNamedElements();
				final /*@Thrown*/ @NonNull CollectionValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
				final /*@Thrown*/ @NonNull CollectionValue selectByKind = CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_namedElements, TYP_miniocl_c_c_Package_2);
				/*@Thrown*/ @NonNull MutableIterable accumulator = ValueUtil.createCollectionAccumulatorValue(ORD_CLSSid_Package);
				@NonNull Iterator<Object> ITERATOR__1 = selectByKind.eagerIterator();
				/*@Thrown*/ @NonNull CollectionValue foundPackage;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						foundPackage = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package _1 = (Package)ITERATOR__1.next();
					/**
					 * name = pName
					 */
					final /*@NonInvalid*/ @Nullable String name = _1.getName();
					final /*@NonInvalid*/ boolean eq = (name != null) ? name.equals(pName) : (pName == null);
					//
					if (eq == ValueUtil.TRUE_VALUE) {
						accumulator.mutableIncluding(_1);
					}
				}
				CAUGHT_foundPackage = foundPackage;
			}
			catch (Exception e) {
				CAUGHT_foundPackage = ValueUtil.createInvalidValue(e);
			}
			if (CAUGHT_foundPackage instanceof CollectionValue) {
				((CollectionValue)CAUGHT_foundPackage).cachedIterable();
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
			/*@Caught*/ @NonNull Object CAUGHT_eq_0;
			try {
				if (env_0 == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
				}
				final /*@Thrown*/ @Nullable LookupEnvironment parentEnv = env_0.getParentEnv();
				final /*@Thrown*/ boolean eq_0 = parentEnv == null;
				CAUGHT_eq_0 = eq_0;
			}
			catch (Exception e) {
				CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_eq_0);
			final /*@Thrown*/ @Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_isEmpty, not);
			if (and == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @NonNull CollectionValue symbol_0;
			if (and) {
				if (env_0 == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
				}
				final /*@Thrown*/ @Nullable LookupEnvironment parentEnv_0 = env_0.getParentEnv();
				final /*@Thrown*/ @NonNull CollectionValue _lookupPackage = INSTANCE_Visitable__lookupPackage.evaluate(self_7, parentEnv_0, pName);
				symbol_0 = _lookupPackage;
			}
			else {
				if (CAUGHT_foundPackage instanceof InvalidValueException) {
					throw (InvalidValueException)CAUGHT_foundPackage;
				}
				symbol_0 = (CollectionValue)CAUGHT_foundPackage;
			}
			return symbol_0;
		}

		@SuppressWarnings("null")
		public @NonNull CollectionValue evaluate(final /*@NonInvalid*/ @NonNull Visitable self_7, final /*@NonInvalid*/ @Nullable LookupEnvironment env_0, final /*@NonInvalid*/ @Nullable String pName) {
			return (@NonNull CollectionValue)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_7, env_0, pName});
		}
	}

	protected final @NonNull CACHE_Visitable__lookupPackage INSTANCE_Visitable__lookupPackage = new CACHE_Visitable__lookupPackage();

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
	public class CACHE_OclElement_parentEnv_Package extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_10 = (/*@NonInvalid*/ @NonNull Object)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, self_10);
			final /*@NonInvalid*/ boolean eq = parent == null;
			/*@Thrown*/ @NonNull LookupEnvironment symbol_1;
			if (eq) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_1 = idResolver.getClass(CLSSid_LookupEnvironment, null);
				final /*@NonInvalid*/ @NonNull LookupEnvironment symbol_0 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_1.createInstance();
				symbol_1 = symbol_0;
			}
			else {
				if (parent == null) {
					throw new InvalidEvaluationException("Null source for \'OclElement::_unqualified_env_Package(OclElement[?]) : lookup::LookupEnvironment[1]\'");
				}
				final /*@Thrown*/ @NonNull LookupEnvironment _unqualified_env_Package = INSTANCE_OclElement__unqualified_env_Package.evaluate(parent, self_10);
				symbol_1 = _unqualified_env_Package;
			}
			return symbol_1;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_10) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_10});
		}
	}

	protected final @NonNull CACHE_OclElement_parentEnv_Package INSTANCE_OclElement_parentEnv_Package = new CACHE_OclElement_parentEnv_Package();

	/**
	 * ocl::OclElement::_unqualified_env_Package(child : OclElement[?]) : lookup::LookupEnvironment[1]
	 *
	 * parentEnv_Package()
	 */
	public class CACHE_OclElement__unqualified_env_Package extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_9 = (/*@NonInvalid*/ @NonNull Object)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_1 = (/*@NonInvalid*/ @Nullable Object)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull LookupEnvironment parentEnv_Package = INSTANCE_OclElement_parentEnv_Package.evaluate(self_9);
			return parentEnv_Package;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_9, final /*@NonInvalid*/ @Nullable Object child_1) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_9, child_1});
		}
	}

	protected final @NonNull CACHE_OclElement__unqualified_env_Package INST_OclElement__unqualified_env_Package = new CACHE_OclElement__unqualified_env_Package();

	/**
	 * miniocl::Package::_unqualified_env_Package(child : OclElement[?]) : lookup::LookupEnvironment[?]
	 *
	 * parentEnv_Package().nestedEnv().addElements(ownedPackages)
	 */
	public class CACHE_Package__unqualified_env_Package extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package self_11 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Package)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_2 = (/*@NonInvalid*/ @Nullable Object)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull LookupEnvironment self_21 = INSTANCE_OclElement_parentEnv_Package.evaluate(self_11);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_2 = idResolver.getClass(CLSSid_LookupEnvironment, null);
			final /*@Thrown*/ @NonNull LookupEnvironment symbol_0 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_2.createInstance();
			CTORid_parentEnv.initValue(symbol_0, self_21);
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<Package> ownedPackages = self_11.getOwnedPackages();
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull LookupEnvironment addElements = symbol_0.addElements(ownedPackages);
			return addElements;
		}

		public LookupEnvironment evaluate(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package self_11, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_2) {
			return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_11, child_2});
		}
	}

	protected final @NonNull CACHE_Package__unqualified_env_Package INST_Package__unqualified_env_Package = new CACHE_Package__unqualified_env_Package();

	/**
	 * miniocl::Root::_unqualified_env_Package(child : OclElement[?]) : lookup::LookupEnvironment[?]
	 *
	 * parentEnv_Package().addElements(ownedPackages)
	 */
	public class CACHE_Root__unqualified_env_Package extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Root self_12 = (/*@NonInvalid*/ @NonNull Root)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_3 = (/*@NonInvalid*/ @Nullable Object)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull LookupEnvironment parentEnv_Package = INSTANCE_OclElement_parentEnv_Package.evaluate(self_12);
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<Package> ownedPackages = self_12.getOwnedPackages();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull LookupEnvironment addElements = parentEnv_Package.addElements(ownedPackages);
			return addElements;
		}

		public LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Root self_12, final /*@NonInvalid*/ @Nullable Object child_3) {
			return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_12, child_3});
		}
	}

	protected final @NonNull CACHE_Root__unqualified_env_Package INST_Root__unqualified_env_Package = new CACHE_Root__unqualified_env_Package();

	/**
	 * ocl::OclElement::unqualified_env_Package() : lookup::LookupEnvironment[1]
	 *
	 * _unqualified_env_Package(null)
	 */
	public class CACHE_OclElement_unqualified_env_Package extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_8 = (/*@NonInvalid*/ @NonNull Object)sourceAndArgumentValues[0];
			final /*@Thrown*/ @NonNull LookupEnvironment _unqualified_env_Package = INSTANCE_OclElement__unqualified_env_Package.evaluate(self_8, null);
			return _unqualified_env_Package;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_8) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_8});
		}
	}

	protected final @NonNull CACHE_OclElement_unqualified_env_Package INSTANCE_OclElement_unqualified_env_Package = new CACHE_OclElement_unqualified_env_Package();

	/**
	 * miniocl::Visitable::lookupPackage(segments : OrderedSet(minioclcs::PathElementCS)) : miniocl::Package[?]
	 *
	 *
	 * if segments->size() = 1
	 * then lookupPackage(segments->first())
	 * else
	 *   let
	 *     qualifierSegments : OrderedSet(minioclcs::PathElementCS[*|?]) = segments->subOrderedSet(1,
	 *       segments->size() - 1)
	 *   in
	 *     let
	 *       qualifier : Package[?] = lookupPackage(qualifierSegments)
	 *     in qualifier?.lookupQualifiedPackage(segments->last())
	 * endif
	 */
	public class CACHE_Visitable_lookupPackage extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Visitable self_6 = (/*@NonInvalid*/ @NonNull Visitable)sourceAndArgumentValues[0];
			@SuppressWarnings("unchecked") final /*@NonInvalid*/ @NonNull CollectionValue segments = (/*@NonInvalid*/ @NonNull CollectionValue)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(segments);
			final /*@NonInvalid*/ boolean eq = size.equals(INT_1);
			/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package symbol_3;
			if (eq) {
				final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(segments);
				if (aPathElementCS == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
				}
				final /*@Thrown*/ @Nullable String pName_1 = aPathElementCS.getElementName();
				final /*@NonInvalid*/ @NonNull LookupEnvironment unqualified_env_Package = INSTANCE_OclElement_unqualified_env_Package.evaluate(self_6);
				final /*@Thrown*/ @NonNull CollectionValue foundPackage = INSTANCE_Visitable__lookupPackage.evaluate(self_6, unqualified_env_Package, pName_1);
				foundPackage.cachedIterable();
				final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundPackage).booleanValue();
				/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package symbol_0;
				if (isEmpty) {
					symbol_0 = null;
				}
				else {
					final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package first = (Package)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundPackage);
					symbol_0 = first;
				}
				symbol_3 = symbol_0;
			}
			else {
				final /*@NonInvalid*/ @NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
				final /*@Thrown*/ @NonNull CollectionValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(segments, INT_1, diff);
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package qualifier = INSTANCE_Visitable_lookupPackage.evaluate(self_6, qualifierSegments);
				/*@Caught*/ @Nullable Object CAUGHT_qualifier;
				try {
					CAUGHT_qualifier = qualifier;
				}
				catch (Exception e) {
					CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ @NonNull Object symbol_1 = CAUGHT_qualifier == null;
				/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package safe_lookupQualifiedPackage_source;
				if (symbol_1 == Boolean.TRUE) {
					safe_lookupQualifiedPackage_source = null;
				}
				else {
					if (qualifier == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(segments);
					if (aPathElementCS_0 == null) {
						throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
					}
					final /*@Thrown*/ @Nullable String pName_2 = aPathElementCS_0.getElementName();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_3 = idResolver.getClass(CLSSid_LookupEnvironment, null);
					final /*@NonInvalid*/ @NonNull LookupEnvironment env_3 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_3.createInstance();
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull List<Package> ownedPackages = qualifier.getOwnedPackages();
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull LookupEnvironment addElements = env_3.addElements(ownedPackages);
					final /*@Thrown*/ @NonNull CollectionValue foundPackage_0 = INSTANCE_Visitable__lookupPackage.evaluate(qualifier, addElements, pName_2);
					foundPackage_0.cachedIterable();
					final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundPackage_0).booleanValue();
					/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package symbol_2;
					if (isEmpty_0) {
						symbol_2 = null;
					}
					else {
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package first_0 = (Package)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundPackage_0);
						symbol_2 = first_0;
					}
					safe_lookupQualifiedPackage_source = symbol_2;
				}
				symbol_3 = safe_lookupQualifiedPackage_source;
			}
			return symbol_3;
		}

		public Package evaluate(final /*@NonInvalid*/ @NonNull Visitable self_6, final /*@NonInvalid*/ @NonNull CollectionValue segments) {
			return (Package)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_6, segments});
		}
	}

	protected final @NonNull CACHE_Visitable_lookupPackage INSTANCE_Visitable_lookupPackage = new CACHE_Visitable_lookupPackage();

	/**
	 * miniocl::Visitable::_lookupVariable(env : lookup::LookupEnvironment[?], vName : String[?]) : OrderedSet(miniocl::Variable)
	 *
	 *
	 * let
	 *   foundVariable : OrderedSet(miniocl::Variable) = env.namedElements->selectByKind(Variable)
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
	public class CACHE_Visitable__lookupVariable extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Visitable self_14 = (/*@NonInvalid*/ @NonNull Visitable)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable LookupEnvironment env_1 = (/*@NonInvalid*/ @Nullable LookupEnvironment)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @Nullable String vName = (/*@NonInvalid*/ @Nullable String)sourceAndArgumentValues[2];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			/*@Caught*/ @NonNull Object CAUGHT_foundVariable;
			try {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Variable_0 = idResolver.getClass(CLSSid_Variable, null);
				if (env_1 == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::namedElements\'");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull List<NamedElement> namedElements = env_1.getNamedElements();
				final /*@Thrown*/ @NonNull CollectionValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
				final /*@Thrown*/ @NonNull CollectionValue selectByKind = CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_namedElements, TYP_miniocl_c_c_Variable_0);
				/*@Thrown*/ @NonNull MutableIterable accumulator = ValueUtil.createCollectionAccumulatorValue(ORD_CLSSid_Variable);
				@NonNull Iterator<Object> ITERATOR__1 = selectByKind.eagerIterator();
				/*@Thrown*/ @NonNull CollectionValue foundVariable;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						foundVariable = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull Variable _1 = (Variable)ITERATOR__1.next();
					/**
					 * name = vName
					 */
					final /*@NonInvalid*/ @Nullable String name = _1.getName();
					final /*@NonInvalid*/ boolean eq = (name != null) ? name.equals(vName) : (vName == null);
					//
					if (eq == ValueUtil.TRUE_VALUE) {
						accumulator.mutableIncluding(_1);
					}
				}
				CAUGHT_foundVariable = foundVariable;
			}
			catch (Exception e) {
				CAUGHT_foundVariable = ValueUtil.createInvalidValue(e);
			}
			if (CAUGHT_foundVariable instanceof CollectionValue) {
				((CollectionValue)CAUGHT_foundVariable).cachedIterable();
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
			/*@Caught*/ @NonNull Object CAUGHT_eq_0;
			try {
				if (env_1 == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
				}
				final /*@Thrown*/ @Nullable LookupEnvironment parentEnv = env_1.getParentEnv();
				final /*@Thrown*/ boolean eq_0 = parentEnv == null;
				CAUGHT_eq_0 = eq_0;
			}
			catch (Exception e) {
				CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_eq_0);
			final /*@Thrown*/ @Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_isEmpty, not);
			if (and == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @NonNull CollectionValue symbol_0;
			if (and) {
				if (env_1 == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
				}
				final /*@Thrown*/ @Nullable LookupEnvironment parentEnv_0 = env_1.getParentEnv();
				final /*@Thrown*/ @NonNull CollectionValue _lookupVariable = INSTANCE_Visitable__lookupVariable.evaluate(self_14, parentEnv_0, vName);
				symbol_0 = _lookupVariable;
			}
			else {
				if (CAUGHT_foundVariable instanceof InvalidValueException) {
					throw (InvalidValueException)CAUGHT_foundVariable;
				}
				symbol_0 = (CollectionValue)CAUGHT_foundVariable;
			}
			return symbol_0;
		}

		@SuppressWarnings("null")
		public @NonNull CollectionValue evaluate(final /*@NonInvalid*/ @NonNull Visitable self_14, final /*@NonInvalid*/ @Nullable LookupEnvironment env_1, final /*@NonInvalid*/ @Nullable String vName) {
			return (@NonNull CollectionValue)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_14, env_1, vName});
		}
	}

	protected final @NonNull CACHE_Visitable__lookupVariable INSTANCE_Visitable__lookupVariable = new CACHE_Visitable__lookupVariable();

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
	public class CACHE_OclElement_parentEnv_Variable extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_17 = (/*@NonInvalid*/ @NonNull Object)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, self_17);
			final /*@NonInvalid*/ boolean eq = parent == null;
			/*@Thrown*/ @NonNull LookupEnvironment symbol_1;
			if (eq) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_6 = idResolver.getClass(CLSSid_LookupEnvironment, null);
				final /*@NonInvalid*/ @NonNull LookupEnvironment symbol_0 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_6.createInstance();
				symbol_1 = symbol_0;
			}
			else {
				if (parent == null) {
					throw new InvalidEvaluationException("Null source for \'OclElement::_unqualified_env_Variable(OclElement[?]) : lookup::LookupEnvironment[1]\'");
				}
				final /*@Thrown*/ @NonNull LookupEnvironment _unqualified_env_Variable = INSTANCE_OclElement__unqualified_env_Variable.evaluate(parent, self_17);
				symbol_1 = _unqualified_env_Variable;
			}
			return symbol_1;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_17) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_17});
		}
	}

	protected final @NonNull CACHE_OclElement_parentEnv_Variable INSTANCE_OclElement_parentEnv_Variable = new CACHE_OclElement_parentEnv_Variable();

	/**
	 * miniocl::ExpressionInOCL::_unqualified_env_Variable(child : OclElement[?]) : lookup::LookupEnvironment[?]
	 *
	 * parentEnv_Variable().nestedEnv().addElements(ownedSelfVar)
	 */
	public class CACHE_ExpressionInOCL__unqualified_env_Variable extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull ExpressionInOCL self_16 = (/*@NonInvalid*/ @NonNull ExpressionInOCL)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_4 = (/*@NonInvalid*/ @Nullable Object)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull LookupEnvironment self_21 = INSTANCE_OclElement_parentEnv_Variable.evaluate(self_16);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_7 = idResolver.getClass(CLSSid_LookupEnvironment, null);
			final /*@Thrown*/ @NonNull LookupEnvironment symbol_0 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_7.createInstance();
			CTORid_parentEnv.initValue(symbol_0, self_21);
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Variable ownedSelfVar = self_16.getOwnedSelfVar();
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull LookupEnvironment addElements = symbol_0.addElements(ownedSelfVar);
			return addElements;
		}

		public LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull ExpressionInOCL self_16, final /*@NonInvalid*/ @Nullable Object child_4) {
			return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_16, child_4});
		}
	}

	protected final @NonNull CACHE_ExpressionInOCL__unqualified_env_Variable INST_ExpressionInOCL__unqualified_env_Variable = new CACHE_ExpressionInOCL__unqualified_env_Variable();

	/**
	 * ocl::OclElement::_unqualified_env_Variable(child : OclElement[?]) : lookup::LookupEnvironment[1]
	 *
	 * parentEnv_Variable()
	 */
	public class CACHE_OclElement__unqualified_env_Variable extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_18 = (/*@NonInvalid*/ @NonNull Object)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_5 = (/*@NonInvalid*/ @Nullable Object)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull LookupEnvironment parentEnv_Variable = INSTANCE_OclElement_parentEnv_Variable.evaluate(self_18);
			return parentEnv_Variable;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_18, final /*@NonInvalid*/ @Nullable Object child_5) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_18, child_5});
		}
	}

	protected final @NonNull CACHE_OclElement__unqualified_env_Variable INST_OclElement__unqualified_env_Variable = new CACHE_OclElement__unqualified_env_Variable();

	/**
	 * miniocl::Operation::_unqualified_env_Variable(child : OclElement[?]) : lookup::LookupEnvironment[?]
	 *
	 * parentEnv_Variable().nestedEnv().addElements(ownedParameters)
	 */
	public class CACHE_Operation__unqualified_env_Variable extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Operation self_19 = (/*@NonInvalid*/ @NonNull Operation)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_6 = (/*@NonInvalid*/ @Nullable Object)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull LookupEnvironment self_21 = INSTANCE_OclElement_parentEnv_Variable.evaluate(self_19);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_8 = idResolver.getClass(CLSSid_LookupEnvironment, null);
			final /*@Thrown*/ @NonNull LookupEnvironment symbol_0 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_8.createInstance();
			CTORid_parentEnv.initValue(symbol_0, self_21);
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<Parameter> ownedParameters = self_19.getOwnedParameters();
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull LookupEnvironment addElements = symbol_0.addElements(ownedParameters);
			return addElements;
		}

		public LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Operation self_19, final /*@NonInvalid*/ @Nullable Object child_6) {
			return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_19, child_6});
		}
	}

	protected final @NonNull CACHE_Operation__unqualified_env_Variable INST_Operation__unqualified_env_Variable = new CACHE_Operation__unqualified_env_Variable();

	/**
	 * ocl::OclElement::unqualified_env_Variable() : lookup::LookupEnvironment[1]
	 *
	 * _unqualified_env_Variable(null)
	 */
	public class CACHE_OclElement_unqualified_env_Variable extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_15 = (/*@NonInvalid*/ @NonNull Object)sourceAndArgumentValues[0];
			final /*@Thrown*/ @NonNull LookupEnvironment _unqualified_env_Variable = INSTANCE_OclElement__unqualified_env_Variable.evaluate(self_15, null);
			return _unqualified_env_Variable;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_15) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_15});
		}
	}

	protected final @NonNull CACHE_OclElement_unqualified_env_Variable INSTANCE_OclElement_unqualified_env_Variable = new CACHE_OclElement_unqualified_env_Variable();

	/**
	 * minioclcs::NameExpCS::lookupVariableToDisambiguate() : miniocl::Variable[?]
	 *
	 *
	 * oclContainer()
	 * .oclAsType(CSTrace)
	 * .ast.lookupVariable(expName.pathElements->first())
	 */
	public class CACHE_NameExpCS_lookupVariableToDisambiguate extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull NameExpCS self_13 = (/*@NonInvalid*/ @NonNull NameExpCS)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_minioclcs_c_c_CSTrace_0 = idResolver.getClass(CLSSid_CSTrace, null);
			final /*@NonInvalid*/ @Nullable Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, self_13);
			final /*@Thrown*/ @NonNull CSTrace oclAsType = ClassUtil.nonNullState((CSTrace)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer, TYP_minioclcs_c_c_CSTrace_0));
			final /*@Thrown*/ @Nullable Element self_21 = oclAsType.getAst();
			if (self_21 == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@NonInvalid*/ @Nullable PathNameCS expName = self_13.getExpName();
			if (expName == null) {
				throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
			}
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName.getPathElements();
			final /*@Thrown*/ @NonNull CollectionValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
			final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_pathElements);
			if (aPathElementCS == null) {
				throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
			}
			final /*@Thrown*/ @Nullable String vName_0 = aPathElementCS.getElementName();
			final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Variable = INSTANCE_OclElement_unqualified_env_Variable.evaluate(self_21);
			final /*@Thrown*/ @NonNull CollectionValue foundVariable = INSTANCE_Visitable__lookupVariable.evaluate(self_21, unqualified_env_Variable, vName_0);
			foundVariable.cachedIterable();
			final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundVariable).booleanValue();
			/*@Thrown*/ @Nullable Variable symbol_0;
			if (isEmpty) {
				symbol_0 = null;
			}
			else {
				final /*@Thrown*/ @Nullable Variable first = (Variable)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundVariable);
				symbol_0 = first;
			}
			return symbol_0;
		}

		public Variable evaluate(final /*@NonInvalid*/ @NonNull NameExpCS self_13) {
			return (Variable)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_13});
		}
	}

	protected final @NonNull CACHE_NameExpCS_lookupVariableToDisambiguate INSTANCE_NameExpCS_lookupVariableToDisambiguate = new CACHE_NameExpCS_lookupVariableToDisambiguate();

	/**
	 * miniocl::Visitable::_lookupProperty(env : lookup::LookupEnvironment[?], pName : String[?]) : OrderedSet(miniocl::Property)
	 *
	 *
	 * let
	 *   foundProperty : OrderedSet(miniocl::Property) = env.namedElements->selectByKind(Property)
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
	public class CACHE_Visitable__lookupProperty extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Visitable self_20 = (/*@NonInvalid*/ @NonNull Visitable)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable LookupEnvironment env_2 = (/*@NonInvalid*/ @Nullable LookupEnvironment)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @Nullable String pName_0 = (/*@NonInvalid*/ @Nullable String)sourceAndArgumentValues[2];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			/*@Caught*/ @NonNull Object CAUGHT_foundProperty;
			try {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Property_1 = idResolver.getClass(CLSSid_Property, null);
				if (env_2 == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::namedElements\'");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull List<NamedElement> namedElements = env_2.getNamedElements();
				final /*@Thrown*/ @NonNull CollectionValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
				final /*@Thrown*/ @NonNull CollectionValue selectByKind = CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_namedElements, TYP_miniocl_c_c_Property_1);
				/*@Thrown*/ @NonNull MutableIterable accumulator = ValueUtil.createCollectionAccumulatorValue(ORD_CLSSid_Property);
				@NonNull Iterator<Object> ITERATOR__1 = selectByKind.eagerIterator();
				/*@Thrown*/ @NonNull CollectionValue foundProperty;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						foundProperty = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Property _1 = (org.eclipse.qvtd.doc.miniocl.Property)ITERATOR__1.next();
					/**
					 * name = pName
					 */
					final /*@NonInvalid*/ @Nullable String name = _1.getName();
					final /*@NonInvalid*/ boolean eq = (name != null) ? name.equals(pName_0) : (pName_0 == null);
					//
					if (eq == ValueUtil.TRUE_VALUE) {
						accumulator.mutableIncluding(_1);
					}
				}
				CAUGHT_foundProperty = foundProperty;
			}
			catch (Exception e) {
				CAUGHT_foundProperty = ValueUtil.createInvalidValue(e);
			}
			if (CAUGHT_foundProperty instanceof CollectionValue) {
				((CollectionValue)CAUGHT_foundProperty).cachedIterable();
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
			/*@Caught*/ @NonNull Object CAUGHT_eq_0;
			try {
				if (env_2 == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
				}
				final /*@Thrown*/ @Nullable LookupEnvironment parentEnv = env_2.getParentEnv();
				final /*@Thrown*/ boolean eq_0 = parentEnv == null;
				CAUGHT_eq_0 = eq_0;
			}
			catch (Exception e) {
				CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_eq_0);
			final /*@Thrown*/ @Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_isEmpty, not);
			if (and == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @NonNull CollectionValue symbol_0;
			if (and) {
				if (env_2 == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
				}
				final /*@Thrown*/ @Nullable LookupEnvironment parentEnv_0 = env_2.getParentEnv();
				final /*@Thrown*/ @NonNull CollectionValue _lookupProperty = INSTANCE_Visitable__lookupProperty.evaluate(self_20, parentEnv_0, pName_0);
				symbol_0 = _lookupProperty;
			}
			else {
				if (CAUGHT_foundProperty instanceof InvalidValueException) {
					throw (InvalidValueException)CAUGHT_foundProperty;
				}
				symbol_0 = (CollectionValue)CAUGHT_foundProperty;
			}
			return symbol_0;
		}

		@SuppressWarnings("null")
		public @NonNull CollectionValue evaluate(final /*@NonInvalid*/ @NonNull Visitable self_20, final /*@NonInvalid*/ @Nullable LookupEnvironment env_2, final /*@NonInvalid*/ @Nullable String pName_0) {
			return (@NonNull CollectionValue)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_20, env_2, pName_0});
		}
	}

	protected final @NonNull CACHE_Visitable__lookupProperty INSTANCE_Visitable__lookupProperty = new CACHE_Visitable__lookupProperty();

	protected class VCACHE_OclElement__unqualified_env_Class extends AbstractDispatchOperation
	{
		private VCACHE_OclElement__unqualified_env_Class() {
			install(Object.class, INST_OclElement__unqualified_env_Class);
			install(Package.class, INST_Package__unqualified_env_Class);
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_3, final /*@NonInvalid*/ @Nullable Object child) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_3, child});
		}
	}

	protected final @NonNull VCACHE_OclElement__unqualified_env_Class INSTANCE_OclElement__unqualified_env_Class = new VCACHE_OclElement__unqualified_env_Class();

	protected class VCACHE_OclElement__unqualified_env_Package extends AbstractDispatchOperation
	{
		private VCACHE_OclElement__unqualified_env_Package() {
			install(Object.class, INST_OclElement__unqualified_env_Package);
			install(Package.class, INST_Package__unqualified_env_Package);
			install(Root.class, INST_Root__unqualified_env_Package);
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_9, final /*@NonInvalid*/ @Nullable Object child_1) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_9, child_1});
		}
	}

	protected final @NonNull VCACHE_OclElement__unqualified_env_Package INSTANCE_OclElement__unqualified_env_Package = new VCACHE_OclElement__unqualified_env_Package();

	protected class VCACHE_OclElement__unqualified_env_Variable extends AbstractDispatchOperation
	{
		private VCACHE_OclElement__unqualified_env_Variable() {
			install(ExpressionInOCL.class, INST_ExpressionInOCL__unqualified_env_Variable);
			install(Object.class, INST_OclElement__unqualified_env_Variable);
			install(Operation.class, INST_Operation__unqualified_env_Variable);
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_18, final /*@NonInvalid*/ @Nullable Object child_5) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_18, child_5});
		}
	}

	protected final @NonNull VCACHE_OclElement__unqualified_env_Variable INSTANCE_OclElement__unqualified_env_Variable = new VCACHE_OclElement__unqualified_env_Variable();

	/**
	 *
	 * map __root__ in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   append ji_CallExpCS  : minioclcs::CallExpCS[1];
	 * append ji_ClassCS  : minioclcs::ClassCS[1];
	 * append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * append ji_NavigationExpCS  : minioclcs::NavigationExpCS[1];
	 * append ji_OperationCS  : minioclcs::OperationCS[1];
	 * append ji_PackageCS  : minioclcs::PackageCS[1];
	 * append ji_ParameterCS  : minioclcs::ParameterCS[1];
	 * append ji_PropertyCS  : minioclcs::PropertyCS[1];
	 * append ji_RootCS  : minioclcs::RootCS[1];
	 * install m_Class_name_e {
	 * lClassCS consumes append ji_ClassCS  : minioclcs::ClassCS[1];
	 * ;
	 * }
	 *   install m_PropertyCallExp__ast {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install m_Operation_name_e {
	 * lOperationCS consumes append ji_OperationCS  : minioclcs::OperationCS[1];
	 * ;
	 * }
	 *   install m_Package_name_e {
	 * lPackageCS consumes append ji_PackageCS  : minioclcs::PackageCS[1];
	 * ;
	 * }
	 *   install m_Parameter_name_e {
	 * lParameterCS consumes append ji_ParameterCS  : minioclcs::ParameterCS[1];
	 * ;
	 * }
	 *   install m_Property_name_e {
	 * lPropertyCS consumes append ji_PropertyCS  : minioclcs::PropertyCS[1];
	 * ;
	 * }
	 *   install m_Root__ast {
	 * lRootCS consumes append ji_RootCS  : minioclcs::RootCS[1];
	 * ;
	 * }
	 *   install m_Element__ownedOperations_ownedProperties_lc {
	 * lClassCS consumes append ji_ClassCS  : minioclcs::ClassCS[1];
	 * ;
	 * }
	 *   install m_m_NavigationExpCS_ast0 {
	 * lNavigationExpCS consumes append ji_NavigationExpCS  : minioclcs::NavigationExpCS[1];
	 * ;
	 * }
	 *   install m_Element__ownedParameters {
	 * lOperationCS consumes append ji_OperationCS  : minioclcs::OperationCS[1];
	 * ;
	 * }
	 *   install m_Element__ownedClasses_ownedPackages_lc {
	 * lPackageCS consumes append ji_PackageCS  : minioclcs::PackageCS[1];
	 * ;
	 * }
	 *   install m_Element__ownedPackages_1 {
	 * lRootCS consumes append ji_RootCS  : minioclcs::RootCS[1];
	 * ;
	 * }
	 *   install m_Element__ast {
	 * lCallExpCS consumes append ji_CallExpCS  : minioclcs::CallExpCS[1];
	 * ;
	 * }
	 *   install m_Element__Operation_ownedBodyExpression {
	 * lOperationCS consumes append ji_OperationCS  : minioclcs::OperationCS[1];
	 * ;
	 * }
	 *   install m_CollectionRange__type_1 {
	 * lParameterCS consumes append ji_ParameterCS  : minioclcs::ParameterCS[1];
	 * ;
	 * }
	 *   install m_CollectionRange__type_2 {
	 * lPropertyCS consumes append ji_PropertyCS  : minioclcs::PropertyCS[1];
	 * ;
	 * }
	 *   install m_Element__type_1 {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install m_Element__CallExp_ownedSource {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install m_CollectionRange__ast {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install m_Element__referredProperty_1 {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install m_CollectionRange__ast_1 {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install m_CollectionRange__CallExp_ownedSource {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install m_CollectionRange__referredVariable {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install m_Element__type_2 {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install m_CollectionRange__type {
	 * lOperationCS consumes append ji_OperationCS  : minioclcs::OperationCS[1];
	 * ;
	 * }
	 *   install m_Element__referredProperty {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install m_Element__type {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 */
	protected class MAP___root__ extends AbstractInvocation
	{
		protected final @NonNull Connection ji_CallExpCS;
		protected final @NonNull Connection ji_ClassCS;
		protected final @NonNull Connection ji_NameExpCS;
		protected final @NonNull Connection ji_NavigationExpCS;
		protected final @NonNull Connection ji_OperationCS;
		protected final @NonNull Connection ji_PackageCS;
		protected final @NonNull Connection ji_ParameterCS;
		protected final @NonNull Connection ji_PropertyCS;
		protected final @NonNull Connection ji_RootCS;

		public MAP___root__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			ji_CallExpCS = (Connection)boundValues[0];
			ji_ClassCS = (Connection)boundValues[1];
			ji_NameExpCS = (Connection)boundValues[2];
			ji_NavigationExpCS = (Connection)boundValues[3];
			ji_OperationCS = (Connection)boundValues[4];
			ji_PackageCS = (Connection)boundValues[5];
			ji_ParameterCS = (Connection)boundValues[6];
			ji_PropertyCS = (Connection)boundValues[7];
			ji_RootCS = (Connection)boundValues[8];
		}

		@Override
		public boolean execute()  {
			// mapping statements
			for (@NonNull ClassCS lClassCS_1 : ji_ClassCS.typedIterable(ClassCS.class)) {
				MAP_m_Class_name_e(lClassCS_1);
			}
			for (@NonNull NameExpCS lNameExpCS_10 : ji_NameExpCS.typedIterable(NameExpCS.class)) {
				MAP_m_PropertyCallExp__ast(lNameExpCS_10);
			}
			for (@NonNull OperationCS lOperationCS_3 : ji_OperationCS.typedIterable(OperationCS.class)) {
				MAP_m_Operation_name_e(lOperationCS_3);
			}
			for (@NonNull PackageCS lPackageCS_1 : ji_PackageCS.typedIterable(PackageCS.class)) {
				MAP_m_Package_name_e(lPackageCS_1);
			}
			for (@NonNull ParameterCS lParameterCS_1 : ji_ParameterCS.typedIterable(ParameterCS.class)) {
				MAP_m_Parameter_name_e(lParameterCS_1);
			}
			for (@NonNull PropertyCS lPropertyCS_1 : ji_PropertyCS.typedIterable(PropertyCS.class)) {
				MAP_m_Property_name_e(lPropertyCS_1);
			}
			for (@NonNull RootCS lRootCS_1 : ji_RootCS.typedIterable(RootCS.class)) {
				MAP_m_Root__ast(lRootCS_1);
			}
			for (@NonNull ClassCS lClassCS_2 : ji_ClassCS.typedIterable(ClassCS.class)) {
				MAP_m_Element__ownedOperations_ownedProperties_lc(lClassCS_2);
			}
			for (@NonNull NavigationExpCS lNavigationExpCS_0 : ji_NavigationExpCS.typedIterable(NavigationExpCS.class)) {
				MAP_m_m_NavigationExpCS_ast0(lNavigationExpCS_0);
			}
			for (@NonNull OperationCS lOperationCS_4 : ji_OperationCS.typedIterable(OperationCS.class)) {
				MAP_m_Element__ownedParameters(lOperationCS_4);
			}
			for (@NonNull PackageCS lPackageCS_2 : ji_PackageCS.typedIterable(PackageCS.class)) {
				MAP_m_Element__ownedClasses_ownedPackages_lc(lPackageCS_2);
			}
			for (@NonNull RootCS lRootCS_2 : ji_RootCS.typedIterable(RootCS.class)) {
				MAP_m_Element__ownedPackages_1(lRootCS_2);
			}
			for (@NonNull CallExpCS lCallExpCS_0 : ji_CallExpCS.typedIterable(CallExpCS.class)) {
				MAP_m_Element__ast(lCallExpCS_0);
			}
			invocationManager.flush();
			CTOR_m_Element__Operation_ownedBodyExpression.addConsumedConnection(ji_OperationCS);
			invocationManager.flush();
			for (@NonNull ParameterCS lParameterCS_2 : ji_ParameterCS.typedIterable(ParameterCS.class)) {
				MAP_m_CollectionRange__type_1(lParameterCS_2);
			}
			for (@NonNull PropertyCS lPropertyCS_2 : ji_PropertyCS.typedIterable(PropertyCS.class)) {
				MAP_m_CollectionRange__type_2(lPropertyCS_2);
			}
			invocationManager.flush();
			CTOR_m_Element__type_1.addConsumedConnection(ji_NameExpCS);
			invocationManager.flush();
			invocationManager.flush();
			CTOR_m_Element__CallExp_ownedSource.addConsumedConnection(ji_NameExpCS);
			invocationManager.flush();
			for (@NonNull NameExpCS lNameExpCS_13 : ji_NameExpCS.typedIterable(NameExpCS.class)) {
				MAP_m_CollectionRange__ast(lNameExpCS_13);
			}
			invocationManager.flush();
			CTOR_m_Element__referredProperty_1.addConsumedConnection(ji_NameExpCS);
			invocationManager.flush();
			for (@NonNull NameExpCS lNameExpCS_15 : ji_NameExpCS.typedIterable(NameExpCS.class)) {
				MAP_m_CollectionRange__ast_1(lNameExpCS_15);
			}
			invocationManager.flush();
			CTOR_m_CollectionRange__CallExp_ownedSource.addConsumedConnection(ji_NameExpCS);
			invocationManager.flush();
			invocationManager.flush();
			CTOR_m_CollectionRange__referredVariable.addConsumedConnection(ji_NameExpCS);
			invocationManager.flush();
			invocationManager.flush();
			CTOR_m_Element__type_2.addConsumedConnection(ji_NameExpCS);
			invocationManager.flush();
			for (@NonNull OperationCS lOperationCS_6 : ji_OperationCS.typedIterable(OperationCS.class)) {
				MAP_m_CollectionRange__type(lOperationCS_6);
			}
			invocationManager.flush();
			CTOR_m_Element__referredProperty.addConsumedConnection(ji_NameExpCS);
			invocationManager.flush();
			invocationManager.flush();
			CTOR_m_Element__type.addConsumedConnection(ji_NameExpCS);
			invocationManager.flush();
			final /*@Thrown*/ @Nullable Boolean __root__ = ValueUtil.TRUE_VALUE;
			return __root__;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(ji_CallExpCS, thoseValues[0])
				&& idResolver.oclEquals(ji_ClassCS, thoseValues[1])
				&& idResolver.oclEquals(ji_NameExpCS, thoseValues[2])
				&& idResolver.oclEquals(ji_NavigationExpCS, thoseValues[3])
				&& idResolver.oclEquals(ji_OperationCS, thoseValues[4])
				&& idResolver.oclEquals(ji_PackageCS, thoseValues[5])
				&& idResolver.oclEquals(ji_ParameterCS, thoseValues[6])
				&& idResolver.oclEquals(ji_PropertyCS, thoseValues[7])
				&& idResolver.oclEquals(ji_RootCS, thoseValues[8]);
		}
	}

	/**
	 *
	 * map m_Class_name_e in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lClassCS  : minioclcs::ClassCS[1];
	 * var name : ecore::EString[?] := lClassCS.name;
	 * new:rightAS rClass : miniocl::Class[1];
	 * set lClassCS.ast := rClass;
	 * set rClass.name := name.toString();
	 *
	 */
	protected boolean MAP_m_Class_name_e(final /*@NonInvalid*/ @NonNull ClassCS lClassCS)  {
		final /*@NonInvalid*/ @Nullable String name = lClassCS.getName();
		// creations
		final @SuppressWarnings("null")org.eclipse.qvtd.doc.miniocl.@NonNull Class rClass = MiniOCLFactory.eINSTANCE.createClass();
		models[1/*rightAS*/].add(rClass, false);
		// mapping statements
		lClassCS.setAst(rClass);
		final /*@Thrown*/ @NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
		rClass.setName(toString);
		final /*@Thrown*/ @Nullable Boolean m_Class_name_e = ValueUtil.TRUE_VALUE;
		return m_Class_name_e;
	}

	/**
	 *
	 * map m_PropertyCallExp__ast in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
	 * check lNameExpCS.isPropCallExpWithExplicitSource();
	 * new:rightAS rPropertyCallExp : miniocl::PropertyCallExp[1];
	 * notify set lNameExpCS.ast := rPropertyCallExp;
	 *
	 */
	protected boolean MAP_m_PropertyCallExp__ast(final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS)  {
		final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS.getRoundedBrackets();
		final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
		/*@Thrown*/ boolean and;
		if (eq) {
			final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS);
			final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
			/*@Thrown*/ boolean symbol_0;
			if (eq_0) {
				symbol_0 = ValueUtil.FALSE_VALUE;
			}
			else {
				if (parentCallExpCS == null) {
					throw throwNull(lNameExpCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
				}
				final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
				final /*@Thrown*/ boolean eq_1 = lNameExpCS.equals(navExp);
				symbol_0 = eq_1;
			}
			and = symbol_0;
		}
		else {
			and = ValueUtil.FALSE_VALUE;
		}
		/*@Thrown*/ @Nullable Boolean symbol_3;
		if (and) {
			// creations
			final @SuppressWarnings("null")@NonNull PropertyCallExp rPropertyCallExp = MiniOCLFactory.eINSTANCE.createPropertyCallExp();
			models[1/*rightAS*/].add(rPropertyCallExp, false);
			// mapping statements
			lNameExpCS.setAst(rPropertyCallExp);
			objectManager.assigned(lNameExpCS, MinioclcsPackage.Literals.CS_TRACE__AST, rPropertyCallExp, null);
			final /*@Thrown*/ @Nullable Boolean m_PropertyCallExp__ast = ValueUtil.TRUE_VALUE;
			symbol_3 = m_PropertyCallExp__ast;
		}
		else {
			symbol_3 = ValueUtil.FALSE_VALUE;
		}
		return symbol_3;
	}

	/**
	 *
	 * map m_Operation_name_e in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lOperationCS  : minioclcs::OperationCS[1];
	 * var name : ecore::EString[?] := lOperationCS.name;
	 * new:rightAS rOperation : miniocl::Operation[1];
	 * set lOperationCS.ast := rOperation;
	 * set rOperation.name := name.toString();
	 *
	 */
	protected boolean MAP_m_Operation_name_e(final /*@NonInvalid*/ @NonNull OperationCS lOperationCS)  {
		final /*@NonInvalid*/ @Nullable String name = lOperationCS.getName();
		// creations
		final @SuppressWarnings("null")@NonNull Operation rOperation = MiniOCLFactory.eINSTANCE.createOperation();
		models[1/*rightAS*/].add(rOperation, false);
		// mapping statements
		lOperationCS.setAst(rOperation);
		final /*@Thrown*/ @NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
		rOperation.setName(toString);
		final /*@Thrown*/ @Nullable Boolean m_Operation_name_e = ValueUtil.TRUE_VALUE;
		return m_Operation_name_e;
	}

	/**
	 *
	 * map m_Package_name_e in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lPackageCS  : minioclcs::PackageCS[1];
	 * var name : ecore::EString[?] := lPackageCS.name;
	 * new:rightAS rPackage : miniocl::Package[1];
	 * set lPackageCS.ast := rPackage;
	 * set rPackage.name := name.toString();
	 *
	 */
	protected boolean MAP_m_Package_name_e(final /*@NonInvalid*/ @NonNull PackageCS lPackageCS)  {
		final /*@NonInvalid*/ @Nullable String name = lPackageCS.getName();
		// creations
		final @SuppressWarnings("null")org.eclipse.qvtd.doc.miniocl.@NonNull Package rPackage = MiniOCLFactory.eINSTANCE.createPackage();
		models[1/*rightAS*/].add(rPackage, false);
		// mapping statements
		lPackageCS.setAst(rPackage);
		final /*@Thrown*/ @NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
		rPackage.setName(toString);
		final /*@Thrown*/ @Nullable Boolean m_Package_name_e = ValueUtil.TRUE_VALUE;
		return m_Package_name_e;
	}

	/**
	 *
	 * map m_Parameter_name_e in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lParameterCS  : minioclcs::ParameterCS[1];
	 * var name : ecore::EString[?] := lParameterCS.name;
	 * new:rightAS rParameter : miniocl::Parameter[1];
	 * set lParameterCS.ast := rParameter;
	 * set rParameter.name := name.toString();
	 *
	 */
	protected boolean MAP_m_Parameter_name_e(final /*@NonInvalid*/ @NonNull ParameterCS lParameterCS)  {
		final /*@NonInvalid*/ @Nullable String name = lParameterCS.getName();
		// creations
		final @SuppressWarnings("null")@NonNull Parameter rParameter = MiniOCLFactory.eINSTANCE.createParameter();
		models[1/*rightAS*/].add(rParameter, false);
		// mapping statements
		lParameterCS.setAst(rParameter);
		final /*@Thrown*/ @NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
		rParameter.setName(toString);
		final /*@Thrown*/ @Nullable Boolean m_Parameter_name_e = ValueUtil.TRUE_VALUE;
		return m_Parameter_name_e;
	}

	/**
	 *
	 * map m_Property_name_e in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lPropertyCS  : minioclcs::PropertyCS[1];
	 * var name : ecore::EString[?] := lPropertyCS.name;
	 * new:rightAS rProperty : miniocl::Property[1];
	 * set lPropertyCS.ast := rProperty;
	 * set rProperty.name := name.toString();
	 *
	 */
	protected boolean MAP_m_Property_name_e(final /*@NonInvalid*/ @NonNull PropertyCS lPropertyCS)  {
		final /*@NonInvalid*/ @Nullable String name = lPropertyCS.getName();
		// creations
		final @SuppressWarnings("null")org.eclipse.qvtd.doc.miniocl.@NonNull Property rProperty = MiniOCLFactory.eINSTANCE.createProperty();
		models[1/*rightAS*/].add(rProperty, false);
		// mapping statements
		lPropertyCS.setAst(rProperty);
		final /*@Thrown*/ @NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
		rProperty.setName(toString);
		final /*@Thrown*/ @Nullable Boolean m_Property_name_e = ValueUtil.TRUE_VALUE;
		return m_Property_name_e;
	}

	/**
	 *
	 * map m_Root__ast in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lRootCS  : minioclcs::RootCS[1];
	 * new:rightAS rRoot : miniocl::Root[1];
	 * set lRootCS.ast := rRoot;
	 *
	 */
	protected boolean MAP_m_Root__ast(final /*@NonInvalid*/ @NonNull RootCS lRootCS)  {
		// creations
		final @SuppressWarnings("null")@NonNull Root rRoot = MiniOCLFactory.eINSTANCE.createRoot();
		models[1/*rightAS*/].add(rRoot, false);
		// mapping statements
		lRootCS.setAst(rRoot);
		final /*@Thrown*/ @Nullable Boolean m_Root__ast = ValueUtil.TRUE_VALUE;
		return m_Root__ast;
	}

	/**
	 *
	 * map m_Element__ownedOperations_ownedProperties_lc in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lClassCS  : minioclcs::ClassCS[1];
	 * var ast : miniocl::Element[1] := lClassCS.ast;
	 * var ast2 : miniocl::Element[1] := lClassCS.ast;
	 * var operations : OrderedSet(minioclcs::OperationCS) := lClassCS.operations;
	 * var properties : OrderedSet(minioclcs::PropertyCS) := lClassCS.properties;
	 * check var ast1 : miniocl::Class[1] := ast;
	 * check ast2 =
	 *   lClassCS.ast;
	 * set ast1.ownedOperations := operations->collect(_'1_' |
	 *     _'1_'.ast.oclAsType(miniocl::Operation))
	 *   ->asOrderedSet()
	 *   ;
	 * set ast1.ownedProperties := properties->collect(_'1_' |
	 *     _'1_'.ast.oclAsType(miniocl::Property))
	 *   ->asOrderedSet();
	 *
	 */
	protected boolean MAP_m_Element__ownedOperations_ownedProperties_lc(final /*@NonInvalid*/ @NonNull ClassCS lClassCS_0)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lClassCS_0.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lClassCS_0, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast != null;
			/*@Thrown*/ @Nullable Boolean raw_ast2;
			if (symbol_1) {
				if (ast == null) {
					throw throwNull(lClassCS_0, "Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<OperationCS> operations = lClassCS_0.getOperations();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<PropertyCS> properties = lClassCS_0.getProperties();
				final /*@NonInvalid*/ boolean symbol_2 = ast instanceof org.eclipse.qvtd.doc.miniocl.Class;
				/*@Thrown*/ @Nullable Boolean symbol_9;
				if (symbol_2) {
					final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class symbol_3 = (org.eclipse.qvtd.doc.miniocl.Class)ast;
					final /*@Thrown*/ boolean symbol_4 = ast.equals(ast);
					/*@Thrown*/ @Nullable Boolean symbol_8;
					if (symbol_4) {
						// mapping statements
						final /*@NonInvalid*/ @NonNull CollectionValue BOXED_operations = idResolver.createOrderedSetOfAll(ORD_CLSSid_OperationCS, operations);
						/*@Thrown*/ @NonNull MutableIterable accumulator = ValueUtil.createCollectionAccumulatorValue(SEQ_CLSSid_Operation);
						@NonNull Iterator<Object> ITERATOR__1 = BOXED_operations.lazyIterator();
						/*@Thrown*/ @NonNull CollectionValue collect;
						while (true) {
							if (!ITERATOR__1.hasNext()) {
								collect = accumulator;
								break;
							}
							@SuppressWarnings("null")
							/*@NonInvalid*/ @NonNull OperationCS _1 = (OperationCS)ITERATOR__1.next();
							/**
							 * _'1_'.ast.oclAsType(miniocl::Operation)
							 */
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Operation = idResolver.getClass(CLSSid_Operation, null);
							final /*@NonInvalid*/ @Nullable Element ast_2 = _1.getAst();
							final /*@Thrown*/ @NonNull Operation oclAsType = ClassUtil.nonNullState((Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_2, TYP_miniocl_c_c_Operation));
							//
							accumulator.mutableIncluding(oclAsType);
						}
						final /*@Thrown*/ @NonNull CollectionValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
						final /*@Thrown*/ @NonNull List<Operation> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Operation.class, asOrderedSet);
						symbol_3.getOwnedOperations().addAll(ECORE_asOrderedSet);
						final /*@NonInvalid*/ @NonNull CollectionValue BOXED_properties = idResolver.createOrderedSetOfAll(ORD_CLSSid_PropertyCS, properties);
						/*@Thrown*/ @NonNull MutableIterable accumulator_0 = ValueUtil.createCollectionAccumulatorValue(SEQ_CLSSid_Property);
						@NonNull Iterator<Object> ITERATOR__1_0 = BOXED_properties.lazyIterator();
						/*@Thrown*/ @NonNull CollectionValue collect_0;
						while (true) {
							if (!ITERATOR__1_0.hasNext()) {
								collect_0 = accumulator_0;
								break;
							}
							@SuppressWarnings("null")
							/*@NonInvalid*/ @NonNull PropertyCS _1_0 = (PropertyCS)ITERATOR__1_0.next();
							/**
							 * _'1_'.ast.oclAsType(miniocl::Property)
							 */
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Property = idResolver.getClass(CLSSid_Property, null);
							final /*@NonInvalid*/ @Nullable Element ast_3 = _1_0.getAst();
							final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Property oclAsType_0 = ClassUtil.nonNullState((org.eclipse.qvtd.doc.miniocl.Property)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_3, TYP_miniocl_c_c_Property));
							//
							accumulator_0.mutableIncluding(oclAsType_0);
						}
						final /*@Thrown*/ @NonNull CollectionValue asOrderedSet_0 = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect_0);
						final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ECORE_asOrderedSet_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.qvtd.doc.miniocl.Property.class, asOrderedSet_0);
						symbol_3.getOwnedProperties().addAll(ECORE_asOrderedSet_0);
						final /*@Thrown*/ @Nullable Boolean m_Element__ownedOperations_ownedProperties_lc = ValueUtil.TRUE_VALUE;
						symbol_8 = m_Element__ownedOperations_ownedProperties_lc;
					}
					else {
						symbol_8 = ValueUtil.FALSE_VALUE;
					}
					symbol_9 = symbol_8;
				}
				else {
					symbol_9 = ValueUtil.FALSE_VALUE;
				}
				raw_ast2 = symbol_9;
			}
			else {
				raw_ast2 = ValueUtil.FALSE_VALUE;
			}
			raw_ast = raw_ast2;
		}
		else {
			raw_ast = ValueUtil.FALSE_VALUE;
		}
		return raw_ast;
	}

	/**
	 *
	 * map m_m_NavigationExpCS_ast0 in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNavigationExpCS  : minioclcs::NavigationExpCS[1];
	 * check lNavigationExpCS.oclIsTypeOf(minioclcs::NavigationExpCS);
	 * set lNavigationExpCS.ast := null;
	 *
	 */
	protected boolean MAP_m_m_NavigationExpCS_ast0(final /*@NonInvalid*/ @NonNull NavigationExpCS lNavigationExpCS)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_minioclcs_c_c_NavigationExpCS = idResolver.getClass(CLSSid_NavigationExpCS, null);
		final /*@NonInvalid*/ boolean oclIsTypeOf = OclAnyOclIsTypeOfOperation.INSTANCE.evaluate(executor, lNavigationExpCS, TYP_minioclcs_c_c_NavigationExpCS).booleanValue();
		/*@Thrown*/ @Nullable Boolean symbol_2;
		if (oclIsTypeOf) {
			// mapping statements
			lNavigationExpCS.setAst(null);
			final /*@Thrown*/ @Nullable Boolean m_m_NavigationExpCS_ast0 = ValueUtil.TRUE_VALUE;
			symbol_2 = m_m_NavigationExpCS_ast0;
		}
		else {
			symbol_2 = ValueUtil.FALSE_VALUE;
		}
		return symbol_2;
	}

	/**
	 *
	 * map m_Element__ownedParameters in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lOperationCS  : minioclcs::OperationCS[1];
	 * var ast : miniocl::Element[1] := lOperationCS.ast;
	 * var params : OrderedSet(minioclcs::ParameterCS) := lOperationCS.params;
	 * check var ast1 : miniocl::Operation[1] := ast;
	 * set ast1.ownedParameters := params->collect(_'1_' |
	 *     _'1_'.ast.oclAsType(miniocl::Parameter))
	 *   ->asOrderedSet();
	 *
	 */
	protected boolean MAP_m_Element__ownedParameters(final /*@NonInvalid*/ @NonNull OperationCS lOperationCS_0)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lOperationCS_0.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lOperationCS_0, "Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<ParameterCS> params = lOperationCS_0.getParams();
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof Operation;
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (symbol_1) {
				final /*@Thrown*/ @NonNull Operation symbol_2 = (Operation)ast;
				// mapping statements
				final /*@NonInvalid*/ @NonNull CollectionValue BOXED_params = idResolver.createOrderedSetOfAll(ORD_CLSSid_ParameterCS, params);
				/*@Thrown*/ @NonNull MutableIterable accumulator = ValueUtil.createCollectionAccumulatorValue(SEQ_CLSSid_Parameter);
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_params.lazyIterator();
				/*@Thrown*/ @NonNull CollectionValue collect;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						collect = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull ParameterCS _1 = (ParameterCS)ITERATOR__1.next();
					/**
					 * _'1_'.ast.oclAsType(miniocl::Parameter)
					 */
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Parameter = idResolver.getClass(CLSSid_Parameter, null);
					final /*@NonInvalid*/ @Nullable Element ast_0 = _1.getAst();
					final /*@Thrown*/ @NonNull Parameter oclAsType = ClassUtil.nonNullState((Parameter)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_miniocl_c_c_Parameter));
					//
					accumulator.mutableIncluding(oclAsType);
				}
				final /*@Thrown*/ @NonNull CollectionValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
				final /*@Thrown*/ @NonNull List<Parameter> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Parameter.class, asOrderedSet);
				symbol_2.getOwnedParameters().addAll(ECORE_asOrderedSet);
				final /*@Thrown*/ @Nullable Boolean m_Element__ownedParameters = ValueUtil.TRUE_VALUE;
				symbol_5 = m_Element__ownedParameters;
			}
			else {
				symbol_5 = ValueUtil.FALSE_VALUE;
			}
			raw_ast = symbol_5;
		}
		else {
			raw_ast = ValueUtil.FALSE_VALUE;
		}
		return raw_ast;
	}

	/**
	 *
	 * map m_Element__ownedClasses_ownedPackages_lc in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lPackageCS  : minioclcs::PackageCS[1];
	 * var ast : miniocl::Element[1] := lPackageCS.ast;
	 * var ast2 : miniocl::Element[1] := lPackageCS.ast;
	 * var classes : OrderedSet(minioclcs::ClassCS) := lPackageCS.classes;
	 * var packages : OrderedSet(minioclcs::PackageCS) := lPackageCS.packages;
	 * check var ast1 : miniocl::Package[1] := ast;
	 * check ast2 =
	 *   lPackageCS.ast;
	 * set ast1.ownedClasses := classes->collect(_'1_' |
	 *     _'1_'.ast.oclAsType(miniocl::Class))
	 *   ->asOrderedSet()
	 *   ;
	 * set ast1.ownedPackages := packages->collect(_'1_' |
	 *     _'1_'.ast.oclAsType(miniocl::Package))
	 *   ->asOrderedSet();
	 *
	 */
	protected boolean MAP_m_Element__ownedClasses_ownedPackages_lc(final /*@NonInvalid*/ @NonNull PackageCS lPackageCS_0)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lPackageCS_0.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lPackageCS_0, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast != null;
			/*@Thrown*/ @Nullable Boolean raw_ast2;
			if (symbol_1) {
				if (ast == null) {
					throw throwNull(lPackageCS_0, "Null where non-null value required");
				}
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<ClassCS> classes = lPackageCS_0.getClasses();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<PackageCS> packages = lPackageCS_0.getPackages();
				final /*@NonInvalid*/ boolean symbol_2 = ast instanceof Package;
				/*@Thrown*/ @Nullable Boolean symbol_9;
				if (symbol_2) {
					final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package symbol_3 = (Package)ast;
					final /*@Thrown*/ boolean symbol_4 = ast.equals(ast);
					/*@Thrown*/ @Nullable Boolean symbol_8;
					if (symbol_4) {
						// mapping statements
						final /*@NonInvalid*/ @NonNull CollectionValue BOXED_classes = idResolver.createOrderedSetOfAll(ORD_CLSSid_ClassCS, classes);
						/*@Thrown*/ @NonNull MutableIterable accumulator = ValueUtil.createCollectionAccumulatorValue(SEQ_CLSSid_Class);
						@NonNull Iterator<Object> ITERATOR__1 = BOXED_classes.lazyIterator();
						/*@Thrown*/ @NonNull CollectionValue collect;
						while (true) {
							if (!ITERATOR__1.hasNext()) {
								collect = accumulator;
								break;
							}
							@SuppressWarnings("null")
							/*@NonInvalid*/ @NonNull ClassCS _1 = (ClassCS)ITERATOR__1.next();
							/**
							 * _'1_'.ast.oclAsType(miniocl::Class)
							 */
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
							final /*@NonInvalid*/ @Nullable Element ast_2 = _1.getAst();
							final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class oclAsType = ClassUtil.nonNullState((org.eclipse.qvtd.doc.miniocl.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_2, TYP_miniocl_c_c_Class_0));
							//
							accumulator.mutableIncluding(oclAsType);
						}
						final /*@Thrown*/ @NonNull CollectionValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
						final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.qvtd.doc.miniocl.Class.class, asOrderedSet);
						symbol_3.getOwnedClasses().addAll(ECORE_asOrderedSet);
						final /*@NonInvalid*/ @NonNull CollectionValue BOXED_packages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, packages);
						/*@Thrown*/ @NonNull MutableIterable accumulator_0 = ValueUtil.createCollectionAccumulatorValue(SEQ_CLSSid_Package);
						@NonNull Iterator<Object> ITERATOR__1_0 = BOXED_packages.lazyIterator();
						/*@Thrown*/ @NonNull CollectionValue collect_0;
						while (true) {
							if (!ITERATOR__1_0.hasNext()) {
								collect_0 = accumulator_0;
								break;
							}
							@SuppressWarnings("null")
							/*@NonInvalid*/ @NonNull PackageCS _1_0 = (PackageCS)ITERATOR__1_0.next();
							/**
							 * _'1_'.ast.oclAsType(miniocl::Package)
							 */
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
							final /*@NonInvalid*/ @Nullable Element ast_3 = _1_0.getAst();
							final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package oclAsType_0 = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_3, TYP_miniocl_c_c_Package_0));
							//
							accumulator_0.mutableIncluding(oclAsType_0);
						}
						final /*@Thrown*/ @NonNull CollectionValue asOrderedSet_0 = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect_0);
						final /*@Thrown*/ @NonNull List<Package> ECORE_asOrderedSet_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, asOrderedSet_0);
						symbol_3.getOwnedPackages().addAll(ECORE_asOrderedSet_0);
						final /*@Thrown*/ @Nullable Boolean m_Element__ownedClasses_ownedPackages_lc = ValueUtil.TRUE_VALUE;
						symbol_8 = m_Element__ownedClasses_ownedPackages_lc;
					}
					else {
						symbol_8 = ValueUtil.FALSE_VALUE;
					}
					symbol_9 = symbol_8;
				}
				else {
					symbol_9 = ValueUtil.FALSE_VALUE;
				}
				raw_ast2 = symbol_9;
			}
			else {
				raw_ast2 = ValueUtil.FALSE_VALUE;
			}
			raw_ast = raw_ast2;
		}
		else {
			raw_ast = ValueUtil.FALSE_VALUE;
		}
		return raw_ast;
	}

	/**
	 *
	 * map m_Element__ownedPackages_1 in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lRootCS  : minioclcs::RootCS[1];
	 * var ast : miniocl::Element[1] := lRootCS.ast;
	 * var packages : OrderedSet(minioclcs::PackageCS) := lRootCS.packages;
	 * check var ast1 : miniocl::Root[1] := ast;
	 * set ast1.ownedPackages := packages->collect(_'1_' |
	 *     _'1_'.ast.oclAsType(miniocl::Package))
	 *   ->asOrderedSet();
	 *
	 */
	protected boolean MAP_m_Element__ownedPackages_1(final /*@NonInvalid*/ @NonNull RootCS lRootCS_0)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lRootCS_0.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lRootCS_0, "Null where non-null value required");
			}
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<PackageCS> packages = lRootCS_0.getPackages();
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof Root;
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (symbol_1) {
				final /*@Thrown*/ @NonNull Root symbol_2 = (Root)ast;
				// mapping statements
				final /*@NonInvalid*/ @NonNull CollectionValue BOXED_packages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, packages);
				/*@Thrown*/ @NonNull MutableIterable accumulator = ValueUtil.createCollectionAccumulatorValue(SEQ_CLSSid_Package);
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_packages.lazyIterator();
				/*@Thrown*/ @NonNull CollectionValue collect;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						collect = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull PackageCS _1 = (PackageCS)ITERATOR__1.next();
					/**
					 * _'1_'.ast.oclAsType(miniocl::Package)
					 */
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Package_1 = idResolver.getClass(CLSSid_Package, null);
					final /*@NonInvalid*/ @Nullable Element ast_0 = _1.getAst();
					final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package oclAsType = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_miniocl_c_c_Package_1));
					//
					accumulator.mutableIncluding(oclAsType);
				}
				final /*@Thrown*/ @NonNull CollectionValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
				final /*@Thrown*/ @NonNull List<Package> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, asOrderedSet);
				symbol_2.getOwnedPackages().addAll(ECORE_asOrderedSet);
				final /*@Thrown*/ @Nullable Boolean m_Element__ownedPackages_1 = ValueUtil.TRUE_VALUE;
				symbol_5 = m_Element__ownedPackages_1;
			}
			else {
				symbol_5 = ValueUtil.FALSE_VALUE;
			}
			raw_ast = symbol_5;
		}
		else {
			raw_ast = ValueUtil.FALSE_VALUE;
		}
		return raw_ast;
	}

	/**
	 *
	 * map m_Element__ast in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lCallExpCS  : minioclcs::CallExpCS[1];
	 * var navExp : minioclcs::NavigationExpCS[?] := lCallExpCS.navExp;
	 * check lCallExpCS.oclIsTypeOf(minioclcs::CallExpCS);
	 * var ast : miniocl::Element[?] := navExp?.ast;
	 * check var ast1 : miniocl::CallExp[?] := ast;
	 * notify set lCallExpCS.ast := ast1;
	 *
	 */
	protected boolean MAP_m_Element__ast(final /*@NonInvalid*/ @NonNull CallExpCS lCallExpCS)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable NavigationExpCS navExp = lCallExpCS.getNavExp();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_minioclcs_c_c_CallExpCS_1 = idResolver.getClass(CLSSid_CallExpCS, null);
		final /*@NonInvalid*/ boolean oclIsTypeOf = OclAnyOclIsTypeOfOperation.INSTANCE.evaluate(executor, lCallExpCS, TYP_minioclcs_c_c_CallExpCS_1).booleanValue();
		/*@Thrown*/ @Nullable Boolean symbol_6;
		if (oclIsTypeOf) {
			final /*@NonInvalid*/ @NonNull Object symbol_0 = navExp == null;
			/*@Thrown*/ @Nullable Element safe_ast_source;
			if (symbol_0 == Boolean.TRUE) {
				safe_ast_source = null;
			}
			else {
				assert navExp != null;
				final /*@Thrown*/ @Nullable Element ast = navExp.getAst();
				safe_ast_source = ast;
			}
			final /*@NonInvalid*/ boolean symbol_1 = safe_ast_source instanceof CallExp;
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (symbol_1) {
				final /*@Thrown*/ @Nullable CallExp symbol_2 = (CallExp)safe_ast_source;
				// mapping statements
				lCallExpCS.setAst(symbol_2);
				objectManager.assigned(lCallExpCS, MinioclcsPackage.Literals.CS_TRACE__AST, symbol_2, null);
				final /*@Thrown*/ @Nullable Boolean m_Element__ast = ValueUtil.TRUE_VALUE;
				symbol_5 = m_Element__ast;
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

	/**
	 *
	 * map m_Element__Operation_ownedBodyExpression in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lOperationCS  : minioclcs::OperationCS[1];
	 * var ast : miniocl::Element[1] := lOperationCS.ast;
	 * var body : minioclcs::ExpCS[?] := lOperationCS.body;
	 * check var ast1 : miniocl::Operation[1] := ast;
	 * var ast2 : miniocl::Element[?] := body?.ast;
	 * check var ast21 : miniocl::OCLExpression[?] := ast2;
	 * var owningClass : miniocl::Class[?] := ast1.owningClass;
	 * var Variable1 : miniocl::Variable[1] := miniocl::Variable{name = 'self', type = owningClass
	 *   }
	 *   ;
	 * var type : miniocl::Class[?] := ast21?.type;
	 * var ExpressionInOCL1 : miniocl::ExpressionInOCL[1] := miniocl::ExpressionInOCL{language = 'OCL', ownedBody = ast21, ownedSelfVar = Variable1, type = type
	 *   };
	 * notify set ast1.ownedBodyExpression := ExpressionInOCL1;
	 *
	 */
	protected class MAP_m_Element__Operation_ownedBodyExpression extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull OperationCS lOperationCS_1;

		public MAP_m_Element__Operation_ownedBodyExpression(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lOperationCS_1 = (OperationCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Element ast = lOperationCS_1.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = ast != null;
			/*@Thrown*/ @Nullable Boolean raw_ast;
			if (symbol_0) {
				if (ast == null) {
					throw throwNull(lOperationCS_1, "Null where non-null value required");
				}
				final /*@NonInvalid*/ @Nullable ExpCS body = lOperationCS_1.getBody();
				final /*@NonInvalid*/ boolean symbol_1 = ast instanceof Operation;
				/*@Thrown*/ @Nullable Boolean symbol_18;
				if (symbol_1) {
					final /*@Thrown*/ @NonNull Operation symbol_2 = (Operation)ast;
					final /*@NonInvalid*/ @NonNull Object symbol_3 = body == null;
					/*@Thrown*/ @Nullable Element safe_ast_source;
					if (symbol_3 == Boolean.TRUE) {
						safe_ast_source = null;
					}
					else {
						assert body != null;
						final /*@Thrown*/ @Nullable Element ast_0 = body.getAst();
						safe_ast_source = ast_0;
					}
					final /*@NonInvalid*/ boolean symbol_4 = safe_ast_source instanceof OCLExpression;
					/*@Thrown*/ @Nullable Boolean symbol_17;
					if (symbol_4) {
						final /*@Thrown*/ @Nullable OCLExpression symbol_5 = (OCLExpression)safe_ast_source;
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class owningClass = symbol_2.getOwningClass();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property CTORid_name = idResolver.getProperty(PROPid_name);
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property CTORid_type = idResolver.getProperty(PROPid_type);
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Variable = idResolver.getClass(CLSSid_Variable, null);
						final /*@Thrown*/ @NonNull Variable symbol_8 = (Variable)TYP_miniocl_c_c_Variable.createInstance();
						CTORid_name.initValue(symbol_8, STR_self);
						CTORid_type.initValue(symbol_8, owningClass);
						/*@Caught*/ @Nullable Object CAUGHT_safe_ast_source;
						try {
							CAUGHT_safe_ast_source = symbol_5;
						}
						catch (Exception e) {
							CAUGHT_safe_ast_source = ValueUtil.createInvalidValue(e);
						}
						final /*@NonInvalid*/ @NonNull Object symbol_9 = CAUGHT_safe_ast_source == null;
						/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class safe_type_source;
						if (symbol_9 == Boolean.TRUE) {
							safe_type_source = null;
						}
						else {
							assert symbol_5 != null;
							objectManager.getting(symbol_5, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, false);
							@SuppressWarnings("null")
							final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type = symbol_5.getType();
							safe_type_source = type;
						}
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property CTORid_language = idResolver.getProperty(PROPid_language);
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property CTORid_ownedBody = idResolver.getProperty(PROPid_ownedBody);
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property CTORid_ownedSelfVar = idResolver.getProperty(PROPid_ownedSelfVar);
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_ExpressionInOCL = idResolver.getClass(CLSSid_ExpressionInOCL, null);
						final /*@Thrown*/ @NonNull ExpressionInOCL symbol_14 = (ExpressionInOCL)TYP_miniocl_c_c_ExpressionInOCL.createInstance();
						CTORid_language.initValue(symbol_14, STR_OCL);
						CTORid_ownedBody.initValue(symbol_14, symbol_5);
						CTORid_ownedSelfVar.initValue(symbol_14, symbol_8);
						CTORid_type.initValue(symbol_14, safe_type_source);
						// mapping statements
						symbol_2.setOwnedBodyExpression(symbol_14);
						objectManager.assigned(symbol_2, MiniOCLPackage.Literals.OPERATION__OWNED_BODY_EXPRESSION, symbol_14, null);
						final /*@Thrown*/ @Nullable Boolean m_Element__Operation_ownedBodyExpression = ValueUtil.TRUE_VALUE;
						symbol_17 = m_Element__Operation_ownedBodyExpression;
					}
					else {
						symbol_17 = ValueUtil.FALSE_VALUE;
					}
					symbol_18 = symbol_17;
				}
				else {
					symbol_18 = ValueUtil.FALSE_VALUE;
				}
				raw_ast = symbol_18;
			}
			else {
				raw_ast = ValueUtil.FALSE_VALUE;
			}
			return raw_ast;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lOperationCS_1, thoseValues[0]);
		}
	}

	/**
	 *
	 * map m_CollectionRange__type_1 in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lParameterCS  : minioclcs::ParameterCS[1];
	 * var ast : miniocl::Element[1] := lParameterCS.ast;
	 * var typeRef : minioclcs::PathNameCS[?] := lParameterCS.typeRef;
	 * check var ast1 : miniocl::Parameter[1] := ast;
	 * var lookupClass : miniocl::Class[?] := ast1.lookupClass(typeRef);
	 * notify set ast1.type := lookupClass;
	 *
	 */
	protected boolean MAP_m_CollectionRange__type_1(final /*@NonInvalid*/ @NonNull ParameterCS lParameterCS_0)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lParameterCS_0.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lParameterCS_0, "Null where non-null value required");
			}
			final /*@NonInvalid*/ @Nullable PathNameCS typeRef = lParameterCS_0.getTypeRef();
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof Parameter;
			/*@Thrown*/ @Nullable Boolean symbol_9;
			if (symbol_1) {
				final /*@Thrown*/ @NonNull Parameter symbol_2 = (Parameter)ast;
				if (typeRef == null) {
					throw throwNull(lParameterCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull List<PathElementCS> segments_0 = typeRef.getPathElements();
				final /*@Thrown*/ @NonNull CollectionValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
				final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
				final /*@Thrown*/ boolean eq = size.equals(INT_1);
				/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_6;
				if (eq) {
					final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
					if (aPathElementCS == null) {
						throw throwNull(lParameterCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
					}
					final /*@Thrown*/ @Nullable String cName_0 = aPathElementCS.getElementName();
					final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Class = INSTANCE_OclElement_unqualified_env_Class.evaluate(symbol_2);
					final /*@Thrown*/ @NonNull CollectionValue foundClass = INSTANCE_Visitable__lookupClass.evaluate(symbol_2, unqualified_env_Class, cName_0);
					final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
					/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_3;
					if (isEmpty) {
						symbol_3 = null;
					}
					else {
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
						symbol_3 = first;
					}
					symbol_6 = symbol_3;
				}
				else {
					final /*@Thrown*/ @NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
					final /*@Thrown*/ @NonNull CollectionValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
					final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package qualifier = INSTANCE_Visitable_lookupPackage.evaluate(symbol_2, qualifierSegments);
					/*@Caught*/ @Nullable Object CAUGHT_qualifier;
					try {
						CAUGHT_qualifier = qualifier;
					}
					catch (Exception e) {
						CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ @NonNull Object symbol_4 = CAUGHT_qualifier == null;
					/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class safe_lookupQualifiedClass_source;
					if (symbol_4 == Boolean.TRUE) {
						safe_lookupQualifiedClass_source = null;
					}
					else {
						if (qualifier == null) {
							throw throwNull(lParameterCS_0, "Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
						if (aPathElementCS_0 == null) {
							throw throwNull(lParameterCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
						}
						final /*@Thrown*/ @Nullable String cName_1 = aPathElementCS_0.getElementName();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_4 = idResolver.getClass(CLSSid_LookupEnvironment, null);
						final /*@NonInvalid*/ @NonNull LookupEnvironment env_3 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_4.createInstance();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = qualifier.getOwnedClasses();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull LookupEnvironment addElements = env_3.addElements(ownedClasses);
						final /*@Thrown*/ @NonNull CollectionValue foundClass_0 = INSTANCE_Visitable__lookupClass.evaluate(qualifier, addElements, cName_1);
						final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass_0).booleanValue();
						/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_5;
						if (isEmpty_0) {
							symbol_5 = null;
						}
						else {
							final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
							symbol_5 = first_0;
						}
						safe_lookupQualifiedClass_source = symbol_5;
					}
					symbol_6 = safe_lookupQualifiedClass_source;
				}
				// mapping statements
				if (symbol_6 == null) {
					throw throwNull(lParameterCS_0, "Null value for miniocl::TypedElement::type assignment");
				}
				symbol_2.setType(symbol_6);
				objectManager.assigned(symbol_2, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, symbol_6, null);
				final /*@Thrown*/ @Nullable Boolean m_CollectionRange__type_1 = ValueUtil.TRUE_VALUE;
				symbol_9 = m_CollectionRange__type_1;
			}
			else {
				symbol_9 = ValueUtil.FALSE_VALUE;
			}
			raw_ast = symbol_9;
		}
		else {
			raw_ast = ValueUtil.FALSE_VALUE;
		}
		return raw_ast;
	}

	/**
	 *
	 * map m_CollectionRange__type_2 in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lPropertyCS  : minioclcs::PropertyCS[1];
	 * var ast : miniocl::Element[1] := lPropertyCS.ast;
	 * var typeRef : minioclcs::PathNameCS[?] := lPropertyCS.typeRef;
	 * check var ast1 : miniocl::Property[1] := ast;
	 * var lookupClass : miniocl::Class[?] := ast1.lookupClass(typeRef);
	 * notify set ast1.type := lookupClass;
	 *
	 */
	protected boolean MAP_m_CollectionRange__type_2(final /*@NonInvalid*/ @NonNull PropertyCS lPropertyCS_0)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lPropertyCS_0.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lPropertyCS_0, "Null where non-null value required");
			}
			final /*@NonInvalid*/ @Nullable PathNameCS typeRef = lPropertyCS_0.getTypeRef();
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof org.eclipse.qvtd.doc.miniocl.Property;
			/*@Thrown*/ @Nullable Boolean symbol_9;
			if (symbol_1) {
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Property symbol_2 = (org.eclipse.qvtd.doc.miniocl.Property)ast;
				if (typeRef == null) {
					throw throwNull(lPropertyCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull List<PathElementCS> segments_0 = typeRef.getPathElements();
				final /*@Thrown*/ @NonNull CollectionValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
				final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
				final /*@Thrown*/ boolean eq = size.equals(INT_1);
				/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_6;
				if (eq) {
					final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
					if (aPathElementCS == null) {
						throw throwNull(lPropertyCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
					}
					final /*@Thrown*/ @Nullable String cName_0 = aPathElementCS.getElementName();
					final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Class = INSTANCE_OclElement_unqualified_env_Class.evaluate(symbol_2);
					final /*@Thrown*/ @NonNull CollectionValue foundClass = INSTANCE_Visitable__lookupClass.evaluate(symbol_2, unqualified_env_Class, cName_0);
					final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
					/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_3;
					if (isEmpty) {
						symbol_3 = null;
					}
					else {
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
						symbol_3 = first;
					}
					symbol_6 = symbol_3;
				}
				else {
					final /*@Thrown*/ @NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
					final /*@Thrown*/ @NonNull CollectionValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
					final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package qualifier = INSTANCE_Visitable_lookupPackage.evaluate(symbol_2, qualifierSegments);
					/*@Caught*/ @Nullable Object CAUGHT_qualifier;
					try {
						CAUGHT_qualifier = qualifier;
					}
					catch (Exception e) {
						CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ @NonNull Object symbol_4 = CAUGHT_qualifier == null;
					/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class safe_lookupQualifiedClass_source;
					if (symbol_4 == Boolean.TRUE) {
						safe_lookupQualifiedClass_source = null;
					}
					else {
						if (qualifier == null) {
							throw throwNull(lPropertyCS_0, "Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
						if (aPathElementCS_0 == null) {
							throw throwNull(lPropertyCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
						}
						final /*@Thrown*/ @Nullable String cName_1 = aPathElementCS_0.getElementName();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_5 = idResolver.getClass(CLSSid_LookupEnvironment, null);
						final /*@NonInvalid*/ @NonNull LookupEnvironment env_3 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_5.createInstance();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = qualifier.getOwnedClasses();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull LookupEnvironment addElements = env_3.addElements(ownedClasses);
						final /*@Thrown*/ @NonNull CollectionValue foundClass_0 = INSTANCE_Visitable__lookupClass.evaluate(qualifier, addElements, cName_1);
						final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass_0).booleanValue();
						/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_5;
						if (isEmpty_0) {
							symbol_5 = null;
						}
						else {
							final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
							symbol_5 = first_0;
						}
						safe_lookupQualifiedClass_source = symbol_5;
					}
					symbol_6 = safe_lookupQualifiedClass_source;
				}
				// mapping statements
				if (symbol_6 == null) {
					throw throwNull(lPropertyCS_0, "Null value for miniocl::TypedElement::type assignment");
				}
				symbol_2.setType(symbol_6);
				objectManager.assigned(symbol_2, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, symbol_6, null);
				final /*@Thrown*/ @Nullable Boolean m_CollectionRange__type_2 = ValueUtil.TRUE_VALUE;
				symbol_9 = m_CollectionRange__type_2;
			}
			else {
				symbol_9 = ValueUtil.FALSE_VALUE;
			}
			raw_ast = symbol_9;
		}
		else {
			raw_ast = ValueUtil.FALSE_VALUE;
		}
		return raw_ast;
	}

	/**
	 *
	 * map m_Element__type_1 in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
	 * var ast : miniocl::Element[1] := lNameExpCS.ast;
	 * check lNameExpCS.isPropCallExpWithExplicitSource();
	 * check var ast1 : miniocl::PropertyCallExp[1] := ast;
	 * var unsafe : miniocl::Property[1] := ast1.referredProperty;
	 * var _'=' : Boolean[1] := unsafe =
	 *   null;
	 * var type : miniocl::Class[1] := unsafe.type;
	 * var _'if' : miniocl::Class[?] := if _'='
	 *   then null
	 *   else type
	 *   endif;
	 * notify set ast1.type := _'if';
	 *
	 */
	protected class MAP_m_Element__type_1 extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_0;

		public MAP_m_Element__type_1(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_0 = (NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @Nullable Element ast = lNameExpCS_0.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = ast != null;
			/*@Thrown*/ @Nullable Boolean raw_ast;
			if (symbol_0) {
				if (ast == null) {
					throw throwNull(lNameExpCS_0, "Null where non-null value required");
				}
				final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_0.getRoundedBrackets();
				final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
				/*@Thrown*/ boolean and;
				if (eq) {
					final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_0);
					final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
					/*@Thrown*/ boolean symbol_1;
					if (eq_0) {
						symbol_1 = ValueUtil.FALSE_VALUE;
					}
					else {
						if (parentCallExpCS == null) {
							throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
						}
						final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
						final /*@Thrown*/ boolean eq_1 = lNameExpCS_0.equals(navExp);
						symbol_1 = eq_1;
					}
					and = symbol_1;
				}
				else {
					and = ValueUtil.FALSE_VALUE;
				}
				/*@Thrown*/ @Nullable Boolean symbol_7;
				if (and) {
					final /*@NonInvalid*/ boolean symbol_2 = ast instanceof PropertyCallExp;
					/*@Thrown*/ @Nullable Boolean symbol_6;
					if (symbol_2) {
						final /*@Thrown*/ @NonNull PropertyCallExp symbol_3 = (PropertyCallExp)ast;
						objectManager.getting(symbol_3, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, false);
						@SuppressWarnings("null")
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Property referredProperty = symbol_3.getReferredProperty();
						objectManager.getting(referredProperty, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, false);
						@SuppressWarnings("null")
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type = referredProperty.getType();
						// mapping statements
						symbol_3.setType(type);
						objectManager.assigned(symbol_3, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, type, null);
						final /*@Thrown*/ @Nullable Boolean m_Element__type_1 = ValueUtil.TRUE_VALUE;
						symbol_6 = m_Element__type_1;
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
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS_0, thoseValues[0]);
		}
	}

	/**
	 *
	 * map m_Element__CallExp_ownedSource in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
	 * var ast : miniocl::Element[1] := lNameExpCS.ast;
	 * var parentAsCallExpCS : minioclcs::CallExpCS[?] := lNameExpCS.parentAsCallExpCS()
	 *   ;
	 * check lNameExpCS.isPropCallExpWithExplicitSource();
	 * var _'=' : Boolean[1] := parentAsCallExpCS = null;
	 * check var ast1 : miniocl::PropertyCallExp[1] := ast;
	 * var source : minioclcs::CallExpCS[?] := parentAsCallExpCS.source;
	 * check source =
	 *   parentAsCallExpCS?.source;
	 * var _'if' : minioclcs::CallExpCS[?] := if _'='
	 *   then null
	 *   else source
	 *   endif;
	 * var _'=1' : Boolean[1] := _'if' =
	 *   null;
	 * var if1 : miniocl::Element[?] := if _'=1'
	 *   then null
	 *   else _'if'.ast
	 *   endif;
	 * var _'=2' : Boolean[1] := if1 =
	 *   null;
	 * var if2 : miniocl::CallExp[?] := if _'=2'
	 *   then null
	 *   else if1.oclAsType(miniocl::CallExp)
	 *   endif;
	 * notify set ast1.ownedSource := if2;
	 *
	 */
	protected class MAP_m_Element__CallExp_ownedSource extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_1;

		public MAP_m_Element__CallExp_ownedSource(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_1 = (NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			objectManager.getting(lNameExpCS_1, MinioclcsPackage.Literals.CS_TRACE__AST, false);
			final /*@NonInvalid*/ @Nullable Element ast = lNameExpCS_1.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = ast != null;
			/*@Thrown*/ @Nullable Boolean raw_ast;
			if (symbol_0) {
				if (ast == null) {
					throw throwNull(lNameExpCS_1, "Null where non-null value required");
				}
				final /*@NonInvalid*/ @Nullable CallExpCS parentAsCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_1);
				final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_1.getRoundedBrackets();
				final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
				/*@Thrown*/ boolean and;
				if (eq) {
					final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_1);
					final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
					/*@Thrown*/ boolean symbol_1;
					if (eq_0) {
						symbol_1 = ValueUtil.FALSE_VALUE;
					}
					else {
						if (parentCallExpCS == null) {
							throw throwNull(lNameExpCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
						}
						final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
						final /*@Thrown*/ boolean eq_1 = lNameExpCS_1.equals(navExp);
						symbol_1 = eq_1;
					}
					and = symbol_1;
				}
				else {
					and = ValueUtil.FALSE_VALUE;
				}
				/*@Thrown*/ @Nullable Boolean symbol_16;
				if (and) {
					final /*@NonInvalid*/ boolean symbol_2 = parentAsCallExpCS == null;
					final /*@NonInvalid*/ boolean symbol_3 = ast instanceof PropertyCallExp;
					/*@Thrown*/ @Nullable Boolean symbol_15;
					if (symbol_3) {
						final /*@Thrown*/ @NonNull PropertyCallExp symbol_4 = (PropertyCallExp)ast;
						if (parentAsCallExpCS == null) {
							throw throwNull(lNameExpCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::source\'");
						}
						final /*@Thrown*/ @Nullable CallExpCS source = parentAsCallExpCS.getSource();
						final /*@NonInvalid*/ @NonNull Object symbol_5 = parentAsCallExpCS == null;
						/*@Thrown*/ @Nullable CallExpCS safe_source_source;
						if (symbol_5 == Boolean.TRUE) {
							safe_source_source = null;
						}
						else {
							assert parentAsCallExpCS != null;
							final /*@Thrown*/ @Nullable CallExpCS source_0 = parentAsCallExpCS.getSource();
							safe_source_source = source_0;
						}
						final /*@Thrown*/ boolean symbol_6 = (source != null) ? source.equals(safe_source_source) : (safe_source_source == null);
						/*@Thrown*/ @Nullable Boolean symbol_14;
						if (symbol_6) {
							/*@Thrown*/ @Nullable CallExpCS symbol_7;
							if (symbol_2) {
								symbol_7 = null;
							}
							else {
								symbol_7 = source;
							}
							final /*@Thrown*/ boolean symbol_8 = symbol_7 == null;
							/*@Thrown*/ @Nullable Element symbol_9;
							if (symbol_8) {
								symbol_9 = null;
							}
							else {
								if (symbol_7 == null) {
									throw throwNull(lNameExpCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CSTrace::ast\'");
								}
								objectManager.getting(symbol_7, MinioclcsPackage.Literals.CS_TRACE__AST, false);
								final /*@Thrown*/ @Nullable Element ast_0 = symbol_7.getAst();
								symbol_9 = ast_0;
							}
							final /*@Thrown*/ boolean symbol_10 = symbol_9 == null;
							/*@Thrown*/ @Nullable CallExp symbol_11;
							if (symbol_10) {
								symbol_11 = null;
							}
							else {
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_CallExp_0 = idResolver.getClass(CLSSid_CallExp, null);
								final /*@Thrown*/ @NonNull CallExp oclAsType = ClassUtil.nonNullState((CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, symbol_9, TYP_miniocl_c_c_CallExp_0));
								symbol_11 = oclAsType;
							}
							// mapping statements
							if (symbol_11 == null) {
								throw throwNull(lNameExpCS_1, "Null value for miniocl::CallExp::ownedSource assignment");
							}
							symbol_4.setOwnedSource(symbol_11);
							objectManager.assigned(symbol_4, MiniOCLPackage.Literals.CALL_EXP__OWNED_SOURCE, symbol_11, null);
							final /*@Thrown*/ @Nullable Boolean m_Element__CallExp_ownedSource = ValueUtil.TRUE_VALUE;
							symbol_14 = m_Element__CallExp_ownedSource;
						}
						else {
							symbol_14 = ValueUtil.FALSE_VALUE;
						}
						symbol_15 = symbol_14;
					}
					else {
						symbol_15 = ValueUtil.FALSE_VALUE;
					}
					symbol_16 = symbol_15;
				}
				else {
					symbol_16 = ValueUtil.FALSE_VALUE;
				}
				raw_ast = symbol_16;
			}
			else {
				raw_ast = ValueUtil.FALSE_VALUE;
			}
			return raw_ast;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS_1, thoseValues[0]);
		}
	}

	/**
	 *
	 * map m_CollectionRange__ast in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
	 * check lNameExpCS.isPropCallExpWithImplicitSource()
	 *   ;
	 * check not lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * check not lNameExpCS.isVariableExp();
	 * new:rightAS rPropertyCallExp : miniocl::PropertyCallExp[1];
	 * notify set lNameExpCS.ast := rPropertyCallExp;
	 *
	 */
	protected boolean MAP_m_CollectionRange__ast(final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_2)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_2.getRoundedBrackets();
		final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
		/*@NonInvalid*/ @Nullable Boolean and;
		if (eq) {
			/*@Caught*/ @NonNull Object CAUGHT_symbol_0;
			try {
				final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_2);
				final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
				/*@Thrown*/ boolean symbol_0;
				if (eq_0) {
					symbol_0 = ValueUtil.FALSE_VALUE;
				}
				else {
					if (parentCallExpCS == null) {
						throw throwNull(lNameExpCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
					}
					final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
					final /*@Thrown*/ boolean eq_1 = lNameExpCS_2.equals(navExp);
					symbol_0 = eq_1;
				}
				CAUGHT_symbol_0 = symbol_0;
			}
			catch (Exception e) {
				CAUGHT_symbol_0 = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_0);
			and = not;
		}
		else {
			and = ValueUtil.FALSE_VALUE;
		}
		if (and == null) {
			throw throwNull(lNameExpCS_2, "Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_7;
		if (and) {
			/*@Caught*/ @NonNull Object CAUGHT_and_0;
			try {
				final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_2.getRoundedBrackets();
				final /*@NonInvalid*/ boolean eq_2 = roundedBrackets_0 == null;
				/*@Thrown*/ boolean and_0;
				if (eq_2) {
					final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_2);
					final /*@NonInvalid*/ boolean eq_3 = parentCallExpCS_0 == null;
					/*@Thrown*/ boolean symbol_1;
					if (eq_3) {
						symbol_1 = ValueUtil.FALSE_VALUE;
					}
					else {
						if (parentCallExpCS_0 == null) {
							throw throwNull(lNameExpCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
						}
						final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
						final /*@Thrown*/ boolean eq_4 = lNameExpCS_2.equals(navExp_0);
						symbol_1 = eq_4;
					}
					and_0 = symbol_1;
				}
				else {
					and_0 = ValueUtil.FALSE_VALUE;
				}
				CAUGHT_and_0 = and_0;
			}
			catch (Exception e) {
				CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ @Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_0);
			if (not_0 == null) {
				throw throwNull(lNameExpCS_2, "Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (not_0) {
				/*@Caught*/ @Nullable Object CAUGHT_and_3;
				try {
					/*@Caught*/ @Nullable Object CAUGHT_and_2;
					try {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_1 = lNameExpCS_2.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq_5 = roundedBrackets_1 == null;
						/*@NonInvalid*/ @Nullable Boolean and_1;
						if (eq_5) {
							/*@Caught*/ @NonNull Object CAUGHT_symbol_2;
							try {
								final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_1 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_2);
								final /*@NonInvalid*/ boolean eq_6 = parentCallExpCS_1 == null;
								/*@Thrown*/ boolean symbol_2;
								if (eq_6) {
									symbol_2 = ValueUtil.FALSE_VALUE;
								}
								else {
									if (parentCallExpCS_1 == null) {
										throw throwNull(lNameExpCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
									}
									final /*@Thrown*/ @Nullable NavigationExpCS navExp_1 = parentCallExpCS_1.getNavExp();
									final /*@Thrown*/ boolean eq_7 = lNameExpCS_2.equals(navExp_1);
									symbol_2 = eq_7;
								}
								CAUGHT_symbol_2 = symbol_2;
							}
							catch (Exception e) {
								CAUGHT_symbol_2 = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @Nullable Boolean not_1 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_2);
							and_1 = not_1;
						}
						else {
							and_1 = ValueUtil.FALSE_VALUE;
						}
						/*@Caught*/ @NonNull Object CAUGHT_eq_8;
						try {
							final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_2.getExpName();
							if (expName == null) {
								throw throwNull(lNameExpCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName.getPathElements();
							final /*@Thrown*/ @NonNull CollectionValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
							final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
							final /*@Thrown*/ boolean eq_8 = size.equals(INT_1);
							CAUGHT_eq_8 = eq_8;
						}
						catch (Exception e) {
							CAUGHT_eq_8 = ValueUtil.createInvalidValue(e);
						}
						final /*@Thrown*/ @Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(and_1, CAUGHT_eq_8);
						CAUGHT_and_2 = and_2;
					}
					catch (Exception e) {
						CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_2);
					final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
					final /*@Thrown*/ @Nullable Boolean and_3 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_2, ne);
					CAUGHT_and_3 = and_3;
				}
				catch (Exception e) {
					CAUGHT_and_3 = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ @Nullable Boolean not_2 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_3);
				if (not_2 == null) {
					throw throwNull(lNameExpCS_2, "Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (not_2) {
					// creations
					final @SuppressWarnings("null")@NonNull PropertyCallExp rPropertyCallExp = MiniOCLFactory.eINSTANCE.createPropertyCallExp();
					models[1/*rightAS*/].add(rPropertyCallExp, false);
					// mapping statements
					lNameExpCS_2.setAst(rPropertyCallExp);
					objectManager.assigned(lNameExpCS_2, MinioclcsPackage.Literals.CS_TRACE__AST, rPropertyCallExp, null);
					final /*@Thrown*/ @Nullable Boolean m_CollectionRange__ast = ValueUtil.TRUE_VALUE;
					symbol_5 = m_CollectionRange__ast;
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

	/**
	 *
	 * map m_Element__referredProperty_1 in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
	 * var ast : miniocl::Element[1] := lNameExpCS.ast;
	 * var expName : minioclcs::PathNameCS[?] := lNameExpCS.expName;
	 * check lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * check var ast1 : miniocl::PropertyCallExp[1] := ast;
	 * var ownedSource : miniocl::OCLExpression[1] := ast1.ownedSource;
	 * var type : miniocl::Class[1] := ownedSource.type;
	 * var lookupPropertyFrom : miniocl::Property[?] := ast1.lookupPropertyFrom(type, expName);
	 * notify set ast1.referredProperty := lookupPropertyFrom;
	 *
	 */
	protected class MAP_m_Element__referredProperty_1 extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_3;

		public MAP_m_Element__referredProperty_1(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_3 = (NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
			final /*@NonInvalid*/ @Nullable Element ast = lNameExpCS_3.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = ast != null;
			/*@Thrown*/ @Nullable Boolean raw_ast;
			if (symbol_0) {
				if (ast == null) {
					throw throwNull(lNameExpCS_3, "Null where non-null value required");
				}
				final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_3.getExpName();
				final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_3.getRoundedBrackets();
				final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
				/*@Thrown*/ boolean and;
				if (eq) {
					final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_3);
					final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
					/*@Thrown*/ boolean symbol_1;
					if (eq_0) {
						symbol_1 = ValueUtil.FALSE_VALUE;
					}
					else {
						if (parentCallExpCS == null) {
							throw throwNull(lNameExpCS_3, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
						}
						final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
						final /*@Thrown*/ boolean eq_1 = lNameExpCS_3.equals(navExp);
						symbol_1 = eq_1;
					}
					and = symbol_1;
				}
				else {
					and = ValueUtil.FALSE_VALUE;
				}
				/*@Thrown*/ @Nullable Boolean symbol_16;
				if (and) {
					final /*@NonInvalid*/ boolean symbol_2 = ast instanceof PropertyCallExp;
					/*@Thrown*/ @Nullable Boolean symbol_15;
					if (symbol_2) {
						final /*@Thrown*/ @NonNull PropertyCallExp symbol_3 = (PropertyCallExp)ast;
						objectManager.getting(symbol_3, MiniOCLPackage.Literals.CALL_EXP__OWNED_SOURCE, false);
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull OCLExpression ownedSource = symbol_3.getOwnedSource();
						objectManager.getting(ownedSource, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, false);
						@SuppressWarnings("null")
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type = ownedSource.getType();
						if (expName == null) {
							throw throwNull(lNameExpCS_3, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull List<PathElementCS> segments_0 = expName.getPathElements();
						final /*@Thrown*/ @NonNull CollectionValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
						final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
						final /*@Thrown*/ boolean eq_2 = size.equals(INT_1);
						/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property symbol_12;
						if (eq_2) {
							final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
							if (aPathElementCS == null) {
								throw throwNull(lNameExpCS_3, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
							}
							final /*@Thrown*/ @Nullable String pName_1 = aPathElementCS.getElementName();
							final /*@Thrown*/ @NonNull CollectionValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Class, type);
							final org.eclipse.ocl.pivot.@NonNull Class TYPE_superClasses_1 = executor.getStaticTypeOf(oclAsSet);
							final LibraryIteration.@NonNull LibraryIterationExtension IMPL_superClasses_1 = (LibraryIteration.LibraryIterationExtension)TYPE_superClasses_1.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
							final @NonNull Object ACC_superClasses_1 = IMPL_superClasses_1.createAccumulatorValue(executor, SET_CLSSid_Class, ORD_CLSSid_Class);
							/**
							 * Implementation of the iterator body.
							 */
							final @NonNull AbstractBinaryOperation BODY_superClasses_1 = new AbstractBinaryOperation()
							{
								/**
								 * ::_'null' : OrderedSet(miniocl::Class)
								 */
								@Override
								public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ @Nullable Object _1) {
									final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_4 = (org.eclipse.qvtd.doc.miniocl.Class)_1;
									if (symbol_4 == null) {
										throw throwNull(lNameExpCS_3, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/1.0\'::Class::superClasses\'");
									}
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> superClasses_0 = symbol_4.getSuperClasses();
									final /*@Thrown*/ @NonNull CollectionValue BOXED_superClasses_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_Class, superClasses_0);
									return BOXED_superClasses_0;
								}
							};
							final @NonNull  ExecutorSingleIterationManager MGR_superClasses_1 = new ExecutorSingleIterationManager(executor, SET_CLSSid_Class, BODY_superClasses_1, oclAsSet, ACC_superClasses_1);
							final /*@Thrown*/ @NonNull CollectionValue superClasses = ClassUtil.nonNullState((CollectionValue)IMPL_superClasses_1.evaluateIteration(MGR_superClasses_1));
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_9 = idResolver.getClass(CLSSid_LookupEnvironment, null);
							final /*@NonInvalid*/ @NonNull LookupEnvironment env_3 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_9.createInstance();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ownedProperties = type.getOwnedProperties();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull LookupEnvironment addElements = env_3.addElements(ownedProperties);
							final /*@Thrown*/ @NonNull CollectionValue foundProperty = INSTANCE_Visitable__lookupProperty.evaluate(type, addElements, pName_1);
							final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundProperty).booleanValue();
							/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property symbol_5;
							if (isEmpty) {
								symbol_5 = null;
							}
							else {
								final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property first = (org.eclipse.qvtd.doc.miniocl.Property)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundProperty);
								symbol_5 = first;
							}
							symbol_12 = symbol_5;
						}
						else {
							final /*@Thrown*/ @NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
							final /*@Thrown*/ @NonNull CollectionValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
							final /*@Thrown*/ @NonNull IntegerValue size_1 = CollectionSizeOperation.INSTANCE.evaluate(qualifierSegments);
							final /*@Thrown*/ boolean eq_3 = size_1.equals(INT_1);
							/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_9;
							if (eq_3) {
								final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(qualifierSegments);
								if (aPathElementCS_0 == null) {
									throw throwNull(lNameExpCS_3, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
								}
								final /*@Thrown*/ @Nullable String cName_0 = aPathElementCS_0.getElementName();
								final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Class = INSTANCE_OclElement_unqualified_env_Class.evaluate(symbol_3);
								final /*@Thrown*/ @NonNull CollectionValue foundClass = INSTANCE_Visitable__lookupClass.evaluate(symbol_3, unqualified_env_Class, cName_0);
								final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
								/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_6;
								if (isEmpty_0) {
									symbol_6 = null;
								}
								else {
									final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
									symbol_6 = first_0;
								}
								symbol_9 = symbol_6;
							}
							else {
								final /*@Thrown*/ @NonNull IntegerValue diff_0 = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_1, INT_1);
								final /*@Thrown*/ @NonNull CollectionValue qualifierSegments_0 = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(qualifierSegments, INT_1, diff_0);
								final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package qualifier = INSTANCE_Visitable_lookupPackage.evaluate(symbol_3, qualifierSegments_0);
								/*@Caught*/ @Nullable Object CAUGHT_qualifier;
								try {
									CAUGHT_qualifier = qualifier;
								}
								catch (Exception e) {
									CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
								}
								final /*@NonInvalid*/ @NonNull Object symbol_7 = CAUGHT_qualifier == null;
								/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class safe_lookupQualifiedClass_source;
								if (symbol_7 == Boolean.TRUE) {
									safe_lookupQualifiedClass_source = null;
								}
								else {
									if (qualifier == null) {
										throw throwNull(lNameExpCS_3, "Null where non-null value required");
									}
									final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_1 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(qualifierSegments);
									if (aPathElementCS_1 == null) {
										throw throwNull(lNameExpCS_3, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
									}
									final /*@Thrown*/ @Nullable String cName_1 = aPathElementCS_1.getElementName();
									final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_10 = idResolver.getClass(CLSSid_LookupEnvironment, null);
									final /*@NonInvalid*/ @NonNull LookupEnvironment env_4 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_10.createInstance();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = qualifier.getOwnedClasses();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull LookupEnvironment addElements_0 = env_4.addElements(ownedClasses);
									final /*@Thrown*/ @NonNull CollectionValue foundClass_0 = INSTANCE_Visitable__lookupClass.evaluate(qualifier, addElements_0, cName_1);
									final /*@Thrown*/ boolean isEmpty_1 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass_0).booleanValue();
									/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_8;
									if (isEmpty_1) {
										symbol_8 = null;
									}
									else {
										final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_1 = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
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
							/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property safe_lookupQualifiedProperty_source;
							if (symbol_10 == Boolean.TRUE) {
								safe_lookupQualifiedProperty_source = null;
							}
							else {
								if (symbol_9 == null) {
									throw throwNull(lNameExpCS_3, "Null where non-null value required");
								}
								final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_2 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
								if (aPathElementCS_2 == null) {
									throw throwNull(lNameExpCS_3, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
								}
								final /*@Thrown*/ @Nullable String pName_2 = aPathElementCS_2.getElementName();
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_11 = idResolver.getClass(CLSSid_LookupEnvironment, null);
								final /*@NonInvalid*/ @NonNull LookupEnvironment env_5 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_11.createInstance();
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ownedProperties_0 = symbol_9.getOwnedProperties();
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull LookupEnvironment addElements_1 = env_5.addElements(ownedProperties_0);
								final /*@Thrown*/ @NonNull CollectionValue foundProperty_0 = INSTANCE_Visitable__lookupProperty.evaluate(symbol_9, addElements_1, pName_2);
								final /*@Thrown*/ boolean isEmpty_2 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundProperty_0).booleanValue();
								/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property symbol_11;
								if (isEmpty_2) {
									symbol_11 = null;
								}
								else {
									final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property first_2 = (org.eclipse.qvtd.doc.miniocl.Property)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundProperty_0);
									symbol_11 = first_2;
								}
								safe_lookupQualifiedProperty_source = symbol_11;
							}
							symbol_12 = safe_lookupQualifiedProperty_source;
						}
						// mapping statements
						if (symbol_12 == null) {
							throw throwNull(lNameExpCS_3, "Null value for miniocl::PropertyCallExp::referredProperty assignment");
						}
						symbol_3.setReferredProperty(symbol_12);
						objectManager.assigned(symbol_3, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, symbol_12, null);
						final /*@Thrown*/ @Nullable Boolean m_Element__referredProperty_1 = ValueUtil.TRUE_VALUE;
						symbol_15 = m_Element__referredProperty_1;
					}
					else {
						symbol_15 = ValueUtil.FALSE_VALUE;
					}
					symbol_16 = symbol_15;
				}
				else {
					symbol_16 = ValueUtil.FALSE_VALUE;
				}
				raw_ast = symbol_16;
			}
			else {
				raw_ast = ValueUtil.FALSE_VALUE;
			}
			return raw_ast;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS_3, thoseValues[0]);
		}
	}

	/**
	 *
	 * map m_CollectionRange__ast_1 in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
	 * check not lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * check lNameExpCS.isVariableExp();
	 * new:rightAS rVariableExp : miniocl::VariableExp[1];
	 * notify set lNameExpCS.ast := rVariableExp;
	 *
	 */
	protected boolean MAP_m_CollectionRange__ast_1(final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_4)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		/*@Caught*/ @NonNull Object CAUGHT_and;
		try {
			final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_4.getRoundedBrackets();
			final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
			/*@Thrown*/ boolean and;
			if (eq) {
				final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_4);
				final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
				/*@Thrown*/ boolean symbol_0;
				if (eq_0) {
					symbol_0 = ValueUtil.FALSE_VALUE;
				}
				else {
					if (parentCallExpCS == null) {
						throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
					}
					final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
					final /*@Thrown*/ boolean eq_1 = lNameExpCS_4.equals(navExp);
					symbol_0 = eq_1;
				}
				and = symbol_0;
			}
			else {
				and = ValueUtil.FALSE_VALUE;
			}
			CAUGHT_and = and;
		}
		catch (Exception e) {
			CAUGHT_and = ValueUtil.createInvalidValue(e);
		}
		final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and);
		if (not == null) {
			throw throwNull(lNameExpCS_4, "Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_5;
		if (not) {
			/*@Caught*/ @Nullable Object CAUGHT_and_1;
			try {
				final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_4.getRoundedBrackets();
				final /*@NonInvalid*/ boolean eq_2 = roundedBrackets_0 == null;
				/*@NonInvalid*/ @Nullable Boolean and_0;
				if (eq_2) {
					/*@Caught*/ @NonNull Object CAUGHT_symbol_1;
					try {
						final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_4);
						final /*@NonInvalid*/ boolean eq_3 = parentCallExpCS_0 == null;
						/*@Thrown*/ boolean symbol_1;
						if (eq_3) {
							symbol_1 = ValueUtil.FALSE_VALUE;
						}
						else {
							if (parentCallExpCS_0 == null) {
								throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
							}
							final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
							final /*@Thrown*/ boolean eq_4 = lNameExpCS_4.equals(navExp_0);
							symbol_1 = eq_4;
						}
						CAUGHT_symbol_1 = symbol_1;
					}
					catch (Exception e) {
						CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ @Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_1);
					and_0 = not_0;
				}
				else {
					and_0 = ValueUtil.FALSE_VALUE;
				}
				/*@Caught*/ @NonNull Object CAUGHT_eq_5;
				try {
					final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_4.getExpName();
					if (expName == null) {
						throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName.getPathElements();
					final /*@Thrown*/ @NonNull CollectionValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
					final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
					final /*@Thrown*/ boolean eq_5 = size.equals(INT_1);
					CAUGHT_eq_5 = eq_5;
				}
				catch (Exception e) {
					CAUGHT_eq_5 = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ @Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(and_0, CAUGHT_eq_5);
				CAUGHT_and_1 = and_1;
			}
			catch (Exception e) {
				CAUGHT_and_1 = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_4);
			final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
			final /*@Thrown*/ @Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_1, ne);
			if (and_2 == null) {
				throw throwNull(lNameExpCS_4, "Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean symbol_4;
			if (and_2) {
				// creations
				final @SuppressWarnings("null")@NonNull VariableExp rVariableExp = MiniOCLFactory.eINSTANCE.createVariableExp();
				models[1/*rightAS*/].add(rVariableExp, false);
				// mapping statements
				lNameExpCS_4.setAst(rVariableExp);
				objectManager.assigned(lNameExpCS_4, MinioclcsPackage.Literals.CS_TRACE__AST, rVariableExp, null);
				final /*@Thrown*/ @Nullable Boolean m_CollectionRange__ast_1 = ValueUtil.TRUE_VALUE;
				symbol_4 = m_CollectionRange__ast_1;
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

	/**
	 *
	 * map m_CollectionRange__CallExp_ownedSource in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
	 * var ast : miniocl::Element[1] := lNameExpCS.ast;
	 * check not lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * check not lNameExpCS.isVariableExp()
	 *   ;
	 * check lNameExpCS.isPropCallExpWithImplicitSource()
	 *   ;
	 * check var ast1 : miniocl::PropertyCallExp[1] := ast;
	 * var lookupVariable : miniocl::Variable[?] := ast1.lookupVariable('self')
	 *   ;
	 * var type : miniocl::Class[1] := lookupVariable.type;
	 * var VariableExp1 : miniocl::VariableExp[1] := miniocl::VariableExp{referredVariable = lookupVariable, type = type
	 *   };
	 * check type = lookupVariable?.type;
	 * notify set ast1.ownedSource := VariableExp1;
	 *
	 */
	protected class MAP_m_CollectionRange__CallExp_ownedSource extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_5;

		public MAP_m_CollectionRange__CallExp_ownedSource(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_5 = (NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			objectManager.getting(lNameExpCS_5, MinioclcsPackage.Literals.CS_TRACE__AST, false);
			final /*@NonInvalid*/ @Nullable Element ast = lNameExpCS_5.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = ast != null;
			/*@Thrown*/ @Nullable Boolean raw_ast;
			if (symbol_0) {
				if (ast == null) {
					throw throwNull(lNameExpCS_5, "Null where non-null value required");
				}
				/*@Caught*/ @NonNull Object CAUGHT_and;
				try {
					final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_5.getRoundedBrackets();
					final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
					/*@Thrown*/ boolean and;
					if (eq) {
						final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_5);
						final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
						/*@Thrown*/ boolean symbol_1;
						if (eq_0) {
							symbol_1 = ValueUtil.FALSE_VALUE;
						}
						else {
							if (parentCallExpCS == null) {
								throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
							}
							final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
							final /*@Thrown*/ boolean eq_1 = lNameExpCS_5.equals(navExp);
							symbol_1 = eq_1;
						}
						and = symbol_1;
					}
					else {
						and = ValueUtil.FALSE_VALUE;
					}
					CAUGHT_and = and;
				}
				catch (Exception e) {
					CAUGHT_and = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and);
				if (not == null) {
					throw throwNull(lNameExpCS_5, "Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_18;
				if (not) {
					/*@Caught*/ @Nullable Object CAUGHT_and_2;
					try {
						/*@Caught*/ @Nullable Object CAUGHT_and_1;
						try {
							final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_5.getRoundedBrackets();
							final /*@NonInvalid*/ boolean eq_2 = roundedBrackets_0 == null;
							/*@NonInvalid*/ @Nullable Boolean and_0;
							if (eq_2) {
								/*@Caught*/ @NonNull Object CAUGHT_symbol_2;
								try {
									final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_5);
									final /*@NonInvalid*/ boolean eq_3 = parentCallExpCS_0 == null;
									/*@Thrown*/ boolean symbol_2;
									if (eq_3) {
										symbol_2 = ValueUtil.FALSE_VALUE;
									}
									else {
										if (parentCallExpCS_0 == null) {
											throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
										}
										final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
										final /*@Thrown*/ boolean eq_4 = lNameExpCS_5.equals(navExp_0);
										symbol_2 = eq_4;
									}
									CAUGHT_symbol_2 = symbol_2;
								}
								catch (Exception e) {
									CAUGHT_symbol_2 = ValueUtil.createInvalidValue(e);
								}
								final /*@NonInvalid*/ @Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_2);
								and_0 = not_0;
							}
							else {
								and_0 = ValueUtil.FALSE_VALUE;
							}
							/*@Caught*/ @NonNull Object CAUGHT_eq_5;
							try {
								final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_5.getExpName();
								if (expName == null) {
									throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
								}
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName.getPathElements();
								final /*@Thrown*/ @NonNull CollectionValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
								final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
								final /*@Thrown*/ boolean eq_5 = size.equals(INT_1);
								CAUGHT_eq_5 = eq_5;
							}
							catch (Exception e) {
								CAUGHT_eq_5 = ValueUtil.createInvalidValue(e);
							}
							final /*@Thrown*/ @Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(and_0, CAUGHT_eq_5);
							CAUGHT_and_1 = and_1;
						}
						catch (Exception e) {
							CAUGHT_and_1 = ValueUtil.createInvalidValue(e);
						}
						final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_5);
						final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
						final /*@Thrown*/ @Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_1, ne);
						CAUGHT_and_2 = and_2;
					}
					catch (Exception e) {
						CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ @Nullable Boolean not_1 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_2);
					if (not_1 == null) {
						throw throwNull(lNameExpCS_5, "Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_17;
					if (not_1) {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_1 = lNameExpCS_5.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq_6 = roundedBrackets_1 == null;
						/*@NonInvalid*/ @Nullable Boolean and_3;
						if (eq_6) {
							/*@Caught*/ @NonNull Object CAUGHT_symbol_3;
							try {
								final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_1 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_5);
								final /*@NonInvalid*/ boolean eq_7 = parentCallExpCS_1 == null;
								/*@Thrown*/ boolean symbol_3;
								if (eq_7) {
									symbol_3 = ValueUtil.FALSE_VALUE;
								}
								else {
									if (parentCallExpCS_1 == null) {
										throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
									}
									final /*@Thrown*/ @Nullable NavigationExpCS navExp_1 = parentCallExpCS_1.getNavExp();
									final /*@Thrown*/ boolean eq_8 = lNameExpCS_5.equals(navExp_1);
									symbol_3 = eq_8;
								}
								CAUGHT_symbol_3 = symbol_3;
							}
							catch (Exception e) {
								CAUGHT_symbol_3 = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @Nullable Boolean not_2 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_3);
							and_3 = not_2;
						}
						else {
							and_3 = ValueUtil.FALSE_VALUE;
						}
						if (and_3 == null) {
							throw throwNull(lNameExpCS_5, "Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_16;
						if (and_3) {
							final /*@NonInvalid*/ boolean symbol_4 = ast instanceof PropertyCallExp;
							/*@Thrown*/ @Nullable Boolean symbol_15;
							if (symbol_4) {
								final /*@Thrown*/ @NonNull PropertyCallExp symbol_5 = (PropertyCallExp)ast;
								final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Variable = INSTANCE_OclElement_unqualified_env_Variable.evaluate(symbol_5);
								final /*@Thrown*/ @NonNull CollectionValue foundVariable = INSTANCE_Visitable__lookupVariable.evaluate(symbol_5, unqualified_env_Variable, STR_self);
								final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundVariable).booleanValue();
								/*@Thrown*/ @Nullable Variable symbol_6;
								if (isEmpty) {
									symbol_6 = null;
								}
								else {
									final /*@Thrown*/ @Nullable Variable first = (Variable)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundVariable);
									symbol_6 = first;
								}
								if (symbol_6 == null) {
									throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/1.0\'::TypedElement::type\'");
								}
								objectManager.getting(symbol_6, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, false);
								@SuppressWarnings("null")
								final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type = symbol_6.getType();
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property CTORid_referredVariable = idResolver.getProperty(PROPid_referredVariable);
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property CTORid_type = idResolver.getProperty(PROPid_type);
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_VariableExp = idResolver.getClass(CLSSid_VariableExp, null);
								final /*@Thrown*/ @NonNull VariableExp symbol_9 = (VariableExp)TYP_miniocl_c_c_VariableExp.createInstance();
								CTORid_referredVariable.initValue(symbol_9, symbol_6);
								CTORid_type.initValue(symbol_9, type);
								/*@Caught*/ @Nullable Object CAUGHT_symbol_6;
								try {
									CAUGHT_symbol_6 = symbol_6;
								}
								catch (Exception e) {
									CAUGHT_symbol_6 = ValueUtil.createInvalidValue(e);
								}
								final /*@NonInvalid*/ @NonNull Object symbol_10 = CAUGHT_symbol_6 == null;
								/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class safe_type_source;
								if (symbol_10 == Boolean.TRUE) {
									safe_type_source = null;
								}
								else {
									assert symbol_6 != null;
									objectManager.getting(symbol_6, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, false);
									@SuppressWarnings("null")
									final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type_0 = symbol_6.getType();
									safe_type_source = type_0;
								}
								final /*@Thrown*/ boolean symbol_11 = type.equals(safe_type_source);
								/*@Thrown*/ @Nullable Boolean symbol_14;
								if (symbol_11) {
									// mapping statements
									symbol_5.setOwnedSource(symbol_9);
									objectManager.assigned(symbol_5, MiniOCLPackage.Literals.CALL_EXP__OWNED_SOURCE, symbol_9, null);
									final /*@Thrown*/ @Nullable Boolean m_CollectionRange__CallExp_ownedSource = ValueUtil.TRUE_VALUE;
									symbol_14 = m_CollectionRange__CallExp_ownedSource;
								}
								else {
									symbol_14 = ValueUtil.FALSE_VALUE;
								}
								symbol_15 = symbol_14;
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
					symbol_18 = symbol_17;
				}
				else {
					symbol_18 = ValueUtil.FALSE_VALUE;
				}
				raw_ast = symbol_18;
			}
			else {
				raw_ast = ValueUtil.FALSE_VALUE;
			}
			return raw_ast;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS_5, thoseValues[0]);
		}
	}

	/**
	 *
	 * map m_CollectionRange__referredVariable in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
	 * var ast : miniocl::Element[1] := lNameExpCS.ast;
	 * var expName : minioclcs::PathNameCS[?] := lNameExpCS.expName;
	 * check lNameExpCS.isVariableExp()
	 *   ;
	 * check not lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * check var ast1 : miniocl::VariableExp[1] := ast;
	 * var pathElements : OrderedSet(minioclcs::PathElementCS)[?] := expName?.pathElements;
	 * var first : minioclcs::PathElementCS[1] := pathElements->first()
	 *   ;
	 * var lookupVariable : miniocl::Variable[?] := ast1.lookupVariable(first);
	 * notify set ast1.referredVariable := lookupVariable;
	 *
	 */
	protected class MAP_m_CollectionRange__referredVariable extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_6;

		public MAP_m_CollectionRange__referredVariable(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_6 = (NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			objectManager.getting(lNameExpCS_6, MinioclcsPackage.Literals.CS_TRACE__AST, false);
			final /*@NonInvalid*/ @Nullable Element ast = lNameExpCS_6.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = ast != null;
			/*@Thrown*/ @Nullable Boolean raw_ast;
			if (symbol_0) {
				if (ast == null) {
					throw throwNull(lNameExpCS_6, "Null where non-null value required");
				}
				final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_6.getExpName();
				/*@Caught*/ @Nullable Object CAUGHT_and_0;
				try {
					final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_6.getRoundedBrackets();
					final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
					/*@NonInvalid*/ @Nullable Boolean and;
					if (eq) {
						/*@Caught*/ @NonNull Object CAUGHT_symbol_1;
						try {
							final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_6);
							final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
							/*@Thrown*/ boolean symbol_1;
							if (eq_0) {
								symbol_1 = ValueUtil.FALSE_VALUE;
							}
							else {
								if (parentCallExpCS == null) {
									throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
								}
								final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
								final /*@Thrown*/ boolean eq_1 = lNameExpCS_6.equals(navExp);
								symbol_1 = eq_1;
							}
							CAUGHT_symbol_1 = symbol_1;
						}
						catch (Exception e) {
							CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
						}
						final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_1);
						and = not;
					}
					else {
						and = ValueUtil.FALSE_VALUE;
					}
					/*@Caught*/ @NonNull Object CAUGHT_eq_2;
					try {
						final /*@NonInvalid*/ @Nullable PathNameCS expName_0 = lNameExpCS_6.getExpName();
						if (expName_0 == null) {
							throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName_0.getPathElements();
						final /*@Thrown*/ @NonNull CollectionValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
						final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
						final /*@Thrown*/ boolean eq_2 = size.equals(INT_1);
						CAUGHT_eq_2 = eq_2;
					}
					catch (Exception e) {
						CAUGHT_eq_2 = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ @Nullable Boolean and_0 = BooleanAndOperation.INSTANCE.evaluate(and, CAUGHT_eq_2);
					CAUGHT_and_0 = and_0;
				}
				catch (Exception e) {
					CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_6);
				final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
				final /*@Thrown*/ @Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_0, ne);
				if (and_1 == null) {
					throw throwNull(lNameExpCS_6, "Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_11;
				if (and_1) {
					/*@Caught*/ @NonNull Object CAUGHT_and_2;
					try {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_6.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq_3 = roundedBrackets_0 == null;
						/*@Thrown*/ boolean and_2;
						if (eq_3) {
							final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_6);
							final /*@NonInvalid*/ boolean eq_4 = parentCallExpCS_0 == null;
							/*@Thrown*/ boolean symbol_2;
							if (eq_4) {
								symbol_2 = ValueUtil.FALSE_VALUE;
							}
							else {
								if (parentCallExpCS_0 == null) {
									throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
								}
								final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
								final /*@Thrown*/ boolean eq_5 = lNameExpCS_6.equals(navExp_0);
								symbol_2 = eq_5;
							}
							and_2 = symbol_2;
						}
						else {
							and_2 = ValueUtil.FALSE_VALUE;
						}
						CAUGHT_and_2 = and_2;
					}
					catch (Exception e) {
						CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ @Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_2);
					if (not_0 == null) {
						throw throwNull(lNameExpCS_6, "Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_10;
					if (not_0) {
						final /*@NonInvalid*/ boolean symbol_3 = ast instanceof VariableExp;
						/*@Thrown*/ @Nullable Boolean symbol_9;
						if (symbol_3) {
							final /*@Thrown*/ @NonNull VariableExp symbol_4 = (VariableExp)ast;
							final /*@NonInvalid*/ @NonNull Object symbol_5 = expName == null;
							/*@Thrown*/ @Nullable CollectionValue safe_pathElements_source;
							if (symbol_5 == Boolean.TRUE) {
								safe_pathElements_source = null;
							}
							else {
								assert expName != null;
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull List<PathElementCS> pathElements_0 = expName.getPathElements();
								final /*@Thrown*/ @NonNull CollectionValue BOXED_pathElements_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements_0);
								safe_pathElements_source = BOXED_pathElements_0;
							}
							final /*@Thrown*/ @Nullable PathElementCS first = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(safe_pathElements_source);
							if (first == null) {
								throw throwNull(lNameExpCS_6, "Null where non-null value required");
							}
							final /*@Thrown*/ @Nullable String vName_0 = first.getElementName();
							final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Variable = INSTANCE_OclElement_unqualified_env_Variable.evaluate(symbol_4);
							final /*@Thrown*/ @NonNull CollectionValue foundVariable = INSTANCE_Visitable__lookupVariable.evaluate(symbol_4, unqualified_env_Variable, vName_0);
							final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundVariable).booleanValue();
							/*@Thrown*/ @Nullable Variable symbol_6;
							if (isEmpty) {
								symbol_6 = null;
							}
							else {
								final /*@Thrown*/ @Nullable Variable first_0 = (Variable)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundVariable);
								symbol_6 = first_0;
							}
							// mapping statements
							if (symbol_6 == null) {
								throw throwNull(lNameExpCS_6, "Null value for miniocl::VariableExp::referredVariable assignment");
							}
							symbol_4.setReferredVariable(symbol_6);
							objectManager.assigned(symbol_4, MiniOCLPackage.Literals.VARIABLE_EXP__REFERRED_VARIABLE, symbol_6, null);
							final /*@Thrown*/ @Nullable Boolean m_CollectionRange__referredVariable = ValueUtil.TRUE_VALUE;
							symbol_9 = m_CollectionRange__referredVariable;
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
				raw_ast = symbol_11;
			}
			else {
				raw_ast = ValueUtil.FALSE_VALUE;
			}
			return raw_ast;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS_6, thoseValues[0]);
		}
	}

	/**
	 *
	 * map m_Element__type_2 in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
	 * var ast : miniocl::Element[1] := lNameExpCS.ast;
	 * check not lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * check lNameExpCS.isVariableExp();
	 * check var ast1 : miniocl::VariableExp[1] := ast;
	 * var referredVariable : miniocl::Variable[1] := ast1.referredVariable;
	 * var type : miniocl::Class[1] := referredVariable.type;
	 * notify set ast1.type := type;
	 *
	 */
	protected class MAP_m_Element__type_2 extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_7;

		public MAP_m_Element__type_2(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_7 = (NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			objectManager.getting(lNameExpCS_7, MinioclcsPackage.Literals.CS_TRACE__AST, false);
			final /*@NonInvalid*/ @Nullable Element ast = lNameExpCS_7.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = ast != null;
			/*@Thrown*/ @Nullable Boolean raw_ast;
			if (symbol_0) {
				if (ast == null) {
					throw throwNull(lNameExpCS_7, "Null where non-null value required");
				}
				/*@Caught*/ @NonNull Object CAUGHT_and;
				try {
					final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_7.getRoundedBrackets();
					final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
					/*@Thrown*/ boolean and;
					if (eq) {
						final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_7);
						final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
						/*@Thrown*/ boolean symbol_1;
						if (eq_0) {
							symbol_1 = ValueUtil.FALSE_VALUE;
						}
						else {
							if (parentCallExpCS == null) {
								throw throwNull(lNameExpCS_7, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
							}
							final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
							final /*@Thrown*/ boolean eq_1 = lNameExpCS_7.equals(navExp);
							symbol_1 = eq_1;
						}
						and = symbol_1;
					}
					else {
						and = ValueUtil.FALSE_VALUE;
					}
					CAUGHT_and = and;
				}
				catch (Exception e) {
					CAUGHT_and = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and);
				if (not == null) {
					throw throwNull(lNameExpCS_7, "Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_9;
				if (not) {
					/*@Caught*/ @Nullable Object CAUGHT_and_1;
					try {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_7.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq_2 = roundedBrackets_0 == null;
						/*@NonInvalid*/ @Nullable Boolean and_0;
						if (eq_2) {
							/*@Caught*/ @NonNull Object CAUGHT_symbol_2;
							try {
								final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_7);
								final /*@NonInvalid*/ boolean eq_3 = parentCallExpCS_0 == null;
								/*@Thrown*/ boolean symbol_2;
								if (eq_3) {
									symbol_2 = ValueUtil.FALSE_VALUE;
								}
								else {
									if (parentCallExpCS_0 == null) {
										throw throwNull(lNameExpCS_7, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
									}
									final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
									final /*@Thrown*/ boolean eq_4 = lNameExpCS_7.equals(navExp_0);
									symbol_2 = eq_4;
								}
								CAUGHT_symbol_2 = symbol_2;
							}
							catch (Exception e) {
								CAUGHT_symbol_2 = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_2);
							and_0 = not_0;
						}
						else {
							and_0 = ValueUtil.FALSE_VALUE;
						}
						/*@Caught*/ @NonNull Object CAUGHT_eq_5;
						try {
							final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_7.getExpName();
							if (expName == null) {
								throw throwNull(lNameExpCS_7, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName.getPathElements();
							final /*@Thrown*/ @NonNull CollectionValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
							final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
							final /*@Thrown*/ boolean eq_5 = size.equals(INT_1);
							CAUGHT_eq_5 = eq_5;
						}
						catch (Exception e) {
							CAUGHT_eq_5 = ValueUtil.createInvalidValue(e);
						}
						final /*@Thrown*/ @Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(and_0, CAUGHT_eq_5);
						CAUGHT_and_1 = and_1;
					}
					catch (Exception e) {
						CAUGHT_and_1 = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_7);
					final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
					final /*@Thrown*/ @Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_1, ne);
					if (and_2 == null) {
						throw throwNull(lNameExpCS_7, "Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_8;
					if (and_2) {
						final /*@NonInvalid*/ boolean symbol_3 = ast instanceof VariableExp;
						/*@Thrown*/ @Nullable Boolean symbol_7;
						if (symbol_3) {
							final /*@Thrown*/ @NonNull VariableExp symbol_4 = (VariableExp)ast;
							objectManager.getting(symbol_4, MiniOCLPackage.Literals.VARIABLE_EXP__REFERRED_VARIABLE, false);
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull Variable referredVariable = symbol_4.getReferredVariable();
							objectManager.getting(referredVariable, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, false);
							@SuppressWarnings("null")
							final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type = referredVariable.getType();
							// mapping statements
							symbol_4.setType(type);
							objectManager.assigned(symbol_4, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, type, null);
							final /*@Thrown*/ @Nullable Boolean m_Element__type_2 = ValueUtil.TRUE_VALUE;
							symbol_7 = m_Element__type_2;
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
				raw_ast = symbol_9;
			}
			else {
				raw_ast = ValueUtil.FALSE_VALUE;
			}
			return raw_ast;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS_7, thoseValues[0]);
		}
	}

	/**
	 *
	 * map m_CollectionRange__type in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lOperationCS  : minioclcs::OperationCS[1];
	 * var ast : miniocl::Element[1] := lOperationCS.ast;
	 * var resultRef : minioclcs::PathNameCS[?] := lOperationCS.resultRef;
	 * check var ast1 : miniocl::Operation[1] := ast;
	 * var lookupClass : miniocl::Class[?] := ast1.lookupClass(resultRef);
	 * set ast1.type := lookupClass;
	 *
	 */
	protected boolean MAP_m_CollectionRange__type(final /*@NonInvalid*/ @NonNull OperationCS lOperationCS_2)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lOperationCS_2.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lOperationCS_2, "Null where non-null value required");
			}
			final /*@NonInvalid*/ @Nullable PathNameCS resultRef = lOperationCS_2.getResultRef();
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof Operation;
			/*@Thrown*/ @Nullable Boolean symbol_9;
			if (symbol_1) {
				final /*@Thrown*/ @NonNull Operation symbol_2 = (Operation)ast;
				if (resultRef == null) {
					throw throwNull(lOperationCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull List<PathElementCS> segments_0 = resultRef.getPathElements();
				final /*@Thrown*/ @NonNull CollectionValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
				final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
				final /*@Thrown*/ boolean eq = size.equals(INT_1);
				/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_6;
				if (eq) {
					final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
					if (aPathElementCS == null) {
						throw throwNull(lOperationCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
					}
					final /*@Thrown*/ @Nullable String cName_0 = aPathElementCS.getElementName();
					final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Class = INSTANCE_OclElement_unqualified_env_Class.evaluate(symbol_2);
					final /*@Thrown*/ @NonNull CollectionValue foundClass = INSTANCE_Visitable__lookupClass.evaluate(symbol_2, unqualified_env_Class, cName_0);
					final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
					/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_3;
					if (isEmpty) {
						symbol_3 = null;
					}
					else {
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
						symbol_3 = first;
					}
					symbol_6 = symbol_3;
				}
				else {
					final /*@Thrown*/ @NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
					final /*@Thrown*/ @NonNull CollectionValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
					final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package qualifier = INSTANCE_Visitable_lookupPackage.evaluate(symbol_2, qualifierSegments);
					/*@Caught*/ @Nullable Object CAUGHT_qualifier;
					try {
						CAUGHT_qualifier = qualifier;
					}
					catch (Exception e) {
						CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ @NonNull Object symbol_4 = CAUGHT_qualifier == null;
					/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class safe_lookupQualifiedClass_source;
					if (symbol_4 == Boolean.TRUE) {
						safe_lookupQualifiedClass_source = null;
					}
					else {
						if (qualifier == null) {
							throw throwNull(lOperationCS_2, "Null where non-null value required");
						}
						final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
						if (aPathElementCS_0 == null) {
							throw throwNull(lOperationCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
						}
						final /*@Thrown*/ @Nullable String cName_1 = aPathElementCS_0.getElementName();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_12 = idResolver.getClass(CLSSid_LookupEnvironment, null);
						final /*@NonInvalid*/ @NonNull LookupEnvironment env_3 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_12.createInstance();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = qualifier.getOwnedClasses();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull LookupEnvironment addElements = env_3.addElements(ownedClasses);
						final /*@Thrown*/ @NonNull CollectionValue foundClass_0 = INSTANCE_Visitable__lookupClass.evaluate(qualifier, addElements, cName_1);
						final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass_0).booleanValue();
						/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_5;
						if (isEmpty_0) {
							symbol_5 = null;
						}
						else {
							final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
							symbol_5 = first_0;
						}
						safe_lookupQualifiedClass_source = symbol_5;
					}
					symbol_6 = safe_lookupQualifiedClass_source;
				}
				// mapping statements
				if (symbol_6 == null) {
					throw throwNull(lOperationCS_2, "Null value for miniocl::TypedElement::type assignment");
				}
				symbol_2.setType(symbol_6);
				final /*@Thrown*/ @Nullable Boolean m_CollectionRange__type = ValueUtil.TRUE_VALUE;
				symbol_9 = m_CollectionRange__type;
			}
			else {
				symbol_9 = ValueUtil.FALSE_VALUE;
			}
			raw_ast = symbol_9;
		}
		else {
			raw_ast = ValueUtil.FALSE_VALUE;
		}
		return raw_ast;
	}

	/**
	 *
	 * map m_Element__referredProperty in MiniOCLCS2AS_qvtm_qvtcas {
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
	 * check var ast1 : miniocl::PropertyCallExp[1] := ast;
	 * var ownedSource : miniocl::OCLExpression[1] := ast1.ownedSource;
	 * var type : miniocl::Class[1] := ownedSource.type;
	 * var lookupPropertyFrom : miniocl::Property[?] := ast1.lookupPropertyFrom(type, expName);
	 * notify set ast1.referredProperty := lookupPropertyFrom;
	 *
	 */
	protected class MAP_m_Element__referredProperty extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_8;

		public MAP_m_Element__referredProperty(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_8 = (NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
			objectManager.getting(lNameExpCS_8, MinioclcsPackage.Literals.CS_TRACE__AST, false);
			final /*@NonInvalid*/ @Nullable Element ast = lNameExpCS_8.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = ast != null;
			/*@Thrown*/ @Nullable Boolean raw_ast;
			if (symbol_0) {
				if (ast == null) {
					throw throwNull(lNameExpCS_8, "Null where non-null value required");
				}
				final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_8.getExpName();
				/*@Caught*/ @Nullable Object CAUGHT_and_1;
				try {
					/*@Caught*/ @Nullable Object CAUGHT_and_0;
					try {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_8.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
						/*@NonInvalid*/ @Nullable Boolean and;
						if (eq) {
							/*@Caught*/ @NonNull Object CAUGHT_symbol_1;
							try {
								final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_8);
								final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
								/*@Thrown*/ boolean symbol_1;
								if (eq_0) {
									symbol_1 = ValueUtil.FALSE_VALUE;
								}
								else {
									if (parentCallExpCS == null) {
										throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
									}
									final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
									final /*@Thrown*/ boolean eq_1 = lNameExpCS_8.equals(navExp);
									symbol_1 = eq_1;
								}
								CAUGHT_symbol_1 = symbol_1;
							}
							catch (Exception e) {
								CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_1);
							and = not;
						}
						else {
							and = ValueUtil.FALSE_VALUE;
						}
						/*@Caught*/ @NonNull Object CAUGHT_eq_2;
						try {
							final /*@NonInvalid*/ @Nullable PathNameCS expName_0 = lNameExpCS_8.getExpName();
							if (expName_0 == null) {
								throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName_0.getPathElements();
							final /*@Thrown*/ @NonNull CollectionValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
							final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
							final /*@Thrown*/ boolean eq_2 = size.equals(INT_1);
							CAUGHT_eq_2 = eq_2;
						}
						catch (Exception e) {
							CAUGHT_eq_2 = ValueUtil.createInvalidValue(e);
						}
						final /*@Thrown*/ @Nullable Boolean and_0 = BooleanAndOperation.INSTANCE.evaluate(and, CAUGHT_eq_2);
						CAUGHT_and_0 = and_0;
					}
					catch (Exception e) {
						CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_8);
					final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
					final /*@Thrown*/ @Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_0, ne);
					CAUGHT_and_1 = and_1;
				}
				catch (Exception e) {
					CAUGHT_and_1 = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ @Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_1);
				if (not_0 == null) {
					throw throwNull(lNameExpCS_8, "Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_20;
				if (not_0) {
					/*@Caught*/ @NonNull Object CAUGHT_and_2;
					try {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_8.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq_3 = roundedBrackets_0 == null;
						/*@Thrown*/ boolean and_2;
						if (eq_3) {
							final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_8);
							final /*@NonInvalid*/ boolean eq_4 = parentCallExpCS_0 == null;
							/*@Thrown*/ boolean symbol_2;
							if (eq_4) {
								symbol_2 = ValueUtil.FALSE_VALUE;
							}
							else {
								if (parentCallExpCS_0 == null) {
									throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
								}
								final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
								final /*@Thrown*/ boolean eq_5 = lNameExpCS_8.equals(navExp_0);
								symbol_2 = eq_5;
							}
							and_2 = symbol_2;
						}
						else {
							and_2 = ValueUtil.FALSE_VALUE;
						}
						CAUGHT_and_2 = and_2;
					}
					catch (Exception e) {
						CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ @Nullable Boolean not_1 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_2);
					if (not_1 == null) {
						throw throwNull(lNameExpCS_8, "Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_19;
					if (not_1) {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_1 = lNameExpCS_8.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq_6 = roundedBrackets_1 == null;
						/*@NonInvalid*/ @Nullable Boolean and_3;
						if (eq_6) {
							/*@Caught*/ @NonNull Object CAUGHT_symbol_3;
							try {
								final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_1 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_8);
								final /*@NonInvalid*/ boolean eq_7 = parentCallExpCS_1 == null;
								/*@Thrown*/ boolean symbol_3;
								if (eq_7) {
									symbol_3 = ValueUtil.FALSE_VALUE;
								}
								else {
									if (parentCallExpCS_1 == null) {
										throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
									}
									final /*@Thrown*/ @Nullable NavigationExpCS navExp_1 = parentCallExpCS_1.getNavExp();
									final /*@Thrown*/ boolean eq_8 = lNameExpCS_8.equals(navExp_1);
									symbol_3 = eq_8;
								}
								CAUGHT_symbol_3 = symbol_3;
							}
							catch (Exception e) {
								CAUGHT_symbol_3 = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @Nullable Boolean not_2 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_3);
							and_3 = not_2;
						}
						else {
							and_3 = ValueUtil.FALSE_VALUE;
						}
						if (and_3 == null) {
							throw throwNull(lNameExpCS_8, "Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_18;
						if (and_3) {
							final /*@NonInvalid*/ boolean symbol_4 = ast instanceof PropertyCallExp;
							/*@Thrown*/ @Nullable Boolean symbol_17;
							if (symbol_4) {
								final /*@Thrown*/ @NonNull PropertyCallExp symbol_5 = (PropertyCallExp)ast;
								objectManager.getting(symbol_5, MiniOCLPackage.Literals.CALL_EXP__OWNED_SOURCE, false);
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull OCLExpression ownedSource = symbol_5.getOwnedSource();
								objectManager.getting(ownedSource, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, false);
								@SuppressWarnings("null")
								final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type = ownedSource.getType();
								if (expName == null) {
									throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
								}
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull List<PathElementCS> segments_0 = expName.getPathElements();
								final /*@Thrown*/ @NonNull CollectionValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
								final /*@Thrown*/ @NonNull IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
								final /*@Thrown*/ boolean eq_9 = size_0.equals(INT_1);
								/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property symbol_14;
								if (eq_9) {
									final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
									if (aPathElementCS == null) {
										throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
									}
									final /*@Thrown*/ @Nullable String pName_1 = aPathElementCS.getElementName();
									final /*@Thrown*/ @NonNull CollectionValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Class, type);
									final org.eclipse.ocl.pivot.@NonNull Class TYPE_superClasses_1 = executor.getStaticTypeOf(oclAsSet);
									final LibraryIteration.@NonNull LibraryIterationExtension IMPL_superClasses_1 = (LibraryIteration.LibraryIterationExtension)TYPE_superClasses_1.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
									final @NonNull Object ACC_superClasses_1 = IMPL_superClasses_1.createAccumulatorValue(executor, SET_CLSSid_Class, ORD_CLSSid_Class);
									/**
									 * Implementation of the iterator body.
									 */
									final @NonNull AbstractBinaryOperation BODY_superClasses_1 = new AbstractBinaryOperation()
									{
										/**
										 * ::_'null' : OrderedSet(miniocl::Class)
										 */
										@Override
										public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ @Nullable Object _1) {
											final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_6 = (org.eclipse.qvtd.doc.miniocl.Class)_1;
											if (symbol_6 == null) {
												throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/1.0\'::Class::superClasses\'");
											}
											@SuppressWarnings("null")
											final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> superClasses_0 = symbol_6.getSuperClasses();
											final /*@Thrown*/ @NonNull CollectionValue BOXED_superClasses_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_Class, superClasses_0);
											return BOXED_superClasses_0;
										}
									};
									final @NonNull  ExecutorSingleIterationManager MGR_superClasses_1 = new ExecutorSingleIterationManager(executor, SET_CLSSid_Class, BODY_superClasses_1, oclAsSet, ACC_superClasses_1);
									final /*@Thrown*/ @NonNull CollectionValue superClasses = ClassUtil.nonNullState((CollectionValue)IMPL_superClasses_1.evaluateIteration(MGR_superClasses_1));
									final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_13 = idResolver.getClass(CLSSid_LookupEnvironment, null);
									final /*@NonInvalid*/ @NonNull LookupEnvironment env_3 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_13.createInstance();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ownedProperties = type.getOwnedProperties();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull LookupEnvironment addElements = env_3.addElements(ownedProperties);
									final /*@Thrown*/ @NonNull CollectionValue foundProperty = INSTANCE_Visitable__lookupProperty.evaluate(type, addElements, pName_1);
									final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundProperty).booleanValue();
									/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property symbol_7;
									if (isEmpty) {
										symbol_7 = null;
									}
									else {
										final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property first = (org.eclipse.qvtd.doc.miniocl.Property)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundProperty);
										symbol_7 = first;
									}
									symbol_14 = symbol_7;
								}
								else {
									final /*@Thrown*/ @NonNull IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_0, INT_1);
									final /*@Thrown*/ @NonNull CollectionValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
									final /*@Thrown*/ @NonNull IntegerValue size_2 = CollectionSizeOperation.INSTANCE.evaluate(qualifierSegments);
									final /*@Thrown*/ boolean eq_10 = size_2.equals(INT_1);
									/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_11;
									if (eq_10) {
										final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(qualifierSegments);
										if (aPathElementCS_0 == null) {
											throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
										}
										final /*@Thrown*/ @Nullable String cName_0 = aPathElementCS_0.getElementName();
										final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Class = INSTANCE_OclElement_unqualified_env_Class.evaluate(symbol_5);
										final /*@Thrown*/ @NonNull CollectionValue foundClass = INSTANCE_Visitable__lookupClass.evaluate(symbol_5, unqualified_env_Class, cName_0);
										final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
										/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_8;
										if (isEmpty_0) {
											symbol_8 = null;
										}
										else {
											final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
											symbol_8 = first_0;
										}
										symbol_11 = symbol_8;
									}
									else {
										final /*@Thrown*/ @NonNull IntegerValue diff_0 = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_2, INT_1);
										final /*@Thrown*/ @NonNull CollectionValue qualifierSegments_0 = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(qualifierSegments, INT_1, diff_0);
										final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package qualifier = INSTANCE_Visitable_lookupPackage.evaluate(symbol_5, qualifierSegments_0);
										/*@Caught*/ @Nullable Object CAUGHT_qualifier;
										try {
											CAUGHT_qualifier = qualifier;
										}
										catch (Exception e) {
											CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
										}
										final /*@NonInvalid*/ @NonNull Object symbol_9 = CAUGHT_qualifier == null;
										/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class safe_lookupQualifiedClass_source;
										if (symbol_9 == Boolean.TRUE) {
											safe_lookupQualifiedClass_source = null;
										}
										else {
											if (qualifier == null) {
												throw throwNull(lNameExpCS_8, "Null where non-null value required");
											}
											final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_1 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(qualifierSegments);
											if (aPathElementCS_1 == null) {
												throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
											}
											final /*@Thrown*/ @Nullable String cName_1 = aPathElementCS_1.getElementName();
											final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_14 = idResolver.getClass(CLSSid_LookupEnvironment, null);
											final /*@NonInvalid*/ @NonNull LookupEnvironment env_4 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_14.createInstance();
											@SuppressWarnings("null")
											final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = qualifier.getOwnedClasses();
											@SuppressWarnings("null")
											final /*@Thrown*/ @NonNull LookupEnvironment addElements_0 = env_4.addElements(ownedClasses);
											final /*@Thrown*/ @NonNull CollectionValue foundClass_0 = INSTANCE_Visitable__lookupClass.evaluate(qualifier, addElements_0, cName_1);
											final /*@Thrown*/ boolean isEmpty_1 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass_0).booleanValue();
											/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_10;
											if (isEmpty_1) {
												symbol_10 = null;
											}
											else {
												final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_1 = (org.eclipse.qvtd.doc.miniocl.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
												symbol_10 = first_1;
											}
											safe_lookupQualifiedClass_source = symbol_10;
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
									/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property safe_lookupQualifiedProperty_source;
									if (symbol_12 == Boolean.TRUE) {
										safe_lookupQualifiedProperty_source = null;
									}
									else {
										if (symbol_11 == null) {
											throw throwNull(lNameExpCS_8, "Null where non-null value required");
										}
										final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_2 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
										if (aPathElementCS_2 == null) {
											throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
										}
										final /*@Thrown*/ @Nullable String pName_2 = aPathElementCS_2.getElementName();
										final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_15 = idResolver.getClass(CLSSid_LookupEnvironment, null);
										final /*@NonInvalid*/ @NonNull LookupEnvironment env_5 = (LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_15.createInstance();
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ownedProperties_0 = symbol_11.getOwnedProperties();
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull LookupEnvironment addElements_1 = env_5.addElements(ownedProperties_0);
										final /*@Thrown*/ @NonNull CollectionValue foundProperty_0 = INSTANCE_Visitable__lookupProperty.evaluate(symbol_11, addElements_1, pName_2);
										final /*@Thrown*/ boolean isEmpty_2 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundProperty_0).booleanValue();
										/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property symbol_13;
										if (isEmpty_2) {
											symbol_13 = null;
										}
										else {
											final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property first_2 = (org.eclipse.qvtd.doc.miniocl.Property)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundProperty_0);
											symbol_13 = first_2;
										}
										safe_lookupQualifiedProperty_source = symbol_13;
									}
									symbol_14 = safe_lookupQualifiedProperty_source;
								}
								// mapping statements
								if (symbol_14 == null) {
									throw throwNull(lNameExpCS_8, "Null value for miniocl::PropertyCallExp::referredProperty assignment");
								}
								symbol_5.setReferredProperty(symbol_14);
								objectManager.assigned(symbol_5, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, symbol_14, null);
								final /*@Thrown*/ @Nullable Boolean m_Element__referredProperty = ValueUtil.TRUE_VALUE;
								symbol_17 = m_Element__referredProperty;
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
					symbol_20 = symbol_19;
				}
				else {
					symbol_20 = ValueUtil.FALSE_VALUE;
				}
				raw_ast = symbol_20;
			}
			else {
				raw_ast = ValueUtil.FALSE_VALUE;
			}
			return raw_ast;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS_8, thoseValues[0]);
		}
	}

	/**
	 *
	 * map m_Element__type in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS  : minioclcs::NameExpCS[1];
	 * var ast : miniocl::Element[1] := lNameExpCS.ast;
	 * check lNameExpCS.isPropCallExpWithImplicitSource()
	 *   ;
	 * check not lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * check not lNameExpCS.isVariableExp();
	 * check var ast1 : miniocl::PropertyCallExp[1] := ast;
	 * var unsafe : miniocl::Property[1] := ast1.referredProperty;
	 * var _'=' : Boolean[1] := unsafe =
	 *   null;
	 * var type : miniocl::Class[1] := unsafe.type;
	 * var _'if' : miniocl::Class[?] := if _'='
	 *   then null
	 *   else type
	 *   endif;
	 * notify set ast1.type := _'if';
	 *
	 */
	protected class MAP_m_Element__type extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_9;

		public MAP_m_Element__type(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_9 = (NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			objectManager.getting(lNameExpCS_9, MinioclcsPackage.Literals.CS_TRACE__AST, false);
			final /*@NonInvalid*/ @Nullable Element ast = lNameExpCS_9.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = ast != null;
			/*@Thrown*/ @Nullable Boolean raw_ast;
			if (symbol_0) {
				if (ast == null) {
					throw throwNull(lNameExpCS_9, "Null where non-null value required");
				}
				final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_9.getRoundedBrackets();
				final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
				/*@NonInvalid*/ @Nullable Boolean and;
				if (eq) {
					/*@Caught*/ @NonNull Object CAUGHT_symbol_1;
					try {
						final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_9);
						final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
						/*@Thrown*/ boolean symbol_1;
						if (eq_0) {
							symbol_1 = ValueUtil.FALSE_VALUE;
						}
						else {
							if (parentCallExpCS == null) {
								throw throwNull(lNameExpCS_9, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
							}
							final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
							final /*@Thrown*/ boolean eq_1 = lNameExpCS_9.equals(navExp);
							symbol_1 = eq_1;
						}
						CAUGHT_symbol_1 = symbol_1;
					}
					catch (Exception e) {
						CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_1);
					and = not;
				}
				else {
					and = ValueUtil.FALSE_VALUE;
				}
				if (and == null) {
					throw throwNull(lNameExpCS_9, "Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean symbol_11;
				if (and) {
					/*@Caught*/ @NonNull Object CAUGHT_and_0;
					try {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_9.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq_2 = roundedBrackets_0 == null;
						/*@Thrown*/ boolean and_0;
						if (eq_2) {
							final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_9);
							final /*@NonInvalid*/ boolean eq_3 = parentCallExpCS_0 == null;
							/*@Thrown*/ boolean symbol_2;
							if (eq_3) {
								symbol_2 = ValueUtil.FALSE_VALUE;
							}
							else {
								if (parentCallExpCS_0 == null) {
									throw throwNull(lNameExpCS_9, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
								}
								final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
								final /*@Thrown*/ boolean eq_4 = lNameExpCS_9.equals(navExp_0);
								symbol_2 = eq_4;
							}
							and_0 = symbol_2;
						}
						else {
							and_0 = ValueUtil.FALSE_VALUE;
						}
						CAUGHT_and_0 = and_0;
					}
					catch (Exception e) {
						CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ @Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_0);
					if (not_0 == null) {
						throw throwNull(lNameExpCS_9, "Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_10;
					if (not_0) {
						/*@Caught*/ @Nullable Object CAUGHT_and_3;
						try {
							/*@Caught*/ @Nullable Object CAUGHT_and_2;
							try {
								final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_1 = lNameExpCS_9.getRoundedBrackets();
								final /*@NonInvalid*/ boolean eq_5 = roundedBrackets_1 == null;
								/*@NonInvalid*/ @Nullable Boolean and_1;
								if (eq_5) {
									/*@Caught*/ @NonNull Object CAUGHT_symbol_3;
									try {
										final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_1 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_9);
										final /*@NonInvalid*/ boolean eq_6 = parentCallExpCS_1 == null;
										/*@Thrown*/ boolean symbol_3;
										if (eq_6) {
											symbol_3 = ValueUtil.FALSE_VALUE;
										}
										else {
											if (parentCallExpCS_1 == null) {
												throw throwNull(lNameExpCS_9, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
											}
											final /*@Thrown*/ @Nullable NavigationExpCS navExp_1 = parentCallExpCS_1.getNavExp();
											final /*@Thrown*/ boolean eq_7 = lNameExpCS_9.equals(navExp_1);
											symbol_3 = eq_7;
										}
										CAUGHT_symbol_3 = symbol_3;
									}
									catch (Exception e) {
										CAUGHT_symbol_3 = ValueUtil.createInvalidValue(e);
									}
									final /*@NonInvalid*/ @Nullable Boolean not_1 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_3);
									and_1 = not_1;
								}
								else {
									and_1 = ValueUtil.FALSE_VALUE;
								}
								/*@Caught*/ @NonNull Object CAUGHT_eq_8;
								try {
									final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_9.getExpName();
									if (expName == null) {
										throw throwNull(lNameExpCS_9, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
									}
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName.getPathElements();
									final /*@Thrown*/ @NonNull CollectionValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
									final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
									final /*@Thrown*/ boolean eq_8 = size.equals(INT_1);
									CAUGHT_eq_8 = eq_8;
								}
								catch (Exception e) {
									CAUGHT_eq_8 = ValueUtil.createInvalidValue(e);
								}
								final /*@Thrown*/ @Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(and_1, CAUGHT_eq_8);
								CAUGHT_and_2 = and_2;
							}
							catch (Exception e) {
								CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_9);
							final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
							final /*@Thrown*/ @Nullable Boolean and_3 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_2, ne);
							CAUGHT_and_3 = and_3;
						}
						catch (Exception e) {
							CAUGHT_and_3 = ValueUtil.createInvalidValue(e);
						}
						final /*@NonInvalid*/ @Nullable Boolean not_2 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_3);
						if (not_2 == null) {
							throw throwNull(lNameExpCS_9, "Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_9;
						if (not_2) {
							final /*@NonInvalid*/ boolean symbol_4 = ast instanceof PropertyCallExp;
							/*@Thrown*/ @Nullable Boolean symbol_8;
							if (symbol_4) {
								final /*@Thrown*/ @NonNull PropertyCallExp symbol_5 = (PropertyCallExp)ast;
								objectManager.getting(symbol_5, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, false);
								@SuppressWarnings("null")
								final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Property referredProperty = symbol_5.getReferredProperty();
								objectManager.getting(referredProperty, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, false);
								@SuppressWarnings("null")
								final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type = referredProperty.getType();
								// mapping statements
								symbol_5.setType(type);
								objectManager.assigned(symbol_5, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, type, null);
								final /*@Thrown*/ @Nullable Boolean m_Element__type = ValueUtil.TRUE_VALUE;
								symbol_8 = m_Element__type;
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
					symbol_11 = symbol_10;
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
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS_9, thoseValues[0]);
		}
	}
}
