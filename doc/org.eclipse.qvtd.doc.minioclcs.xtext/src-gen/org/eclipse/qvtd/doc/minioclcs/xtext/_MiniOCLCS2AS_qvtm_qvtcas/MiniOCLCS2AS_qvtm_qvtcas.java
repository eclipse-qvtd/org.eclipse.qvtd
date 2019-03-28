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
import org.eclipse.ocl.pivot.Property;
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
import org.eclipse.qvtd.doc.minioclcs.xtext.internal.tx.AbstractInvocationConstructor;
import org.eclipse.qvtd.doc.minioclcs.xtext.tx.AbstractCS2ASTransformer;
import org.eclipse.qvtd.doc.minioclcs.xtext.tx.AbstractInvocation;
import org.eclipse.qvtd.doc.minioclcs.xtext.tx.AbstractSimpleInvocation;
import org.eclipse.qvtd.doc.minioclcs.xtext.tx.Connection;
import org.eclipse.qvtd.doc.minioclcs.xtext.tx.InvalidEvaluationException;
import org.eclipse.qvtd.doc.minioclcs.xtext.tx.InvocationConstructor;
import org.eclipse.qvtd.doc.minioclcs.xtext.tx.TransformationExecutor;

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
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ClassCS = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS.getClassId("ClassCS", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class_0 = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Class", 0);
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
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Class = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Class_0);
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
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Class = TypeId.SEQUENCE.getSpecializedId(CLSSid_Class_0);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Operation = TypeId.SEQUENCE.getSpecializedId(CLSSid_Operation);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Package = TypeId.SEQUENCE.getSpecializedId(CLSSid_Package);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Parameter = TypeId.SEQUENCE.getSpecializedId(CLSSid_Parameter);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Property = TypeId.SEQUENCE.getSpecializedId(CLSSid_Property);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Class = TypeId.SET.getSpecializedId(CLSSid_Class_0);

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

	protected final @NonNull AbstractInvocationConstructor CTOR_r_MiniOCLCS2AS_46_ocl____load__ = new AbstractInvocationConstructor(invocationManager, "r_MiniOCLCS2AS_46_ocl____load__", false, lazyCreateInterval(0))
	{
		@Override
		public @NonNull MAP_r_MiniOCLCS2AS_46_ocl____load__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_r_MiniOCLCS2AS_46_ocl____load__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muNameExpCS__2__PropertyCallExp__0__ownedSource = new AbstractInvocationConstructor(invocationManager, "muNameExpCS__2__PropertyCallExp__0__ownedSource", false, lazyCreateInterval(6))
	{
		@Override
		public @NonNull MAP_muNameExpCS__2__PropertyCallExp__0__ownedSource newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muNameExpCS__2__PropertyCallExp__0__ownedSource(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muNameExpCS__2__PropertyCallExp__0__referredPropert = new AbstractInvocationConstructor(invocationManager, "muNameExpCS__2__PropertyCallExp__0__referredPropert", false, lazyCreateInterval(9))
	{
		@Override
		public @NonNull MAP_muNameExpCS__2__PropertyCallExp__0__referredPropert newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muNameExpCS__2__PropertyCallExp__0__referredPropert(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muNameExpCS__2__PropertyCallExp__1__referredPropert = new AbstractInvocationConstructor(invocationManager, "muNameExpCS__2__PropertyCallExp__1__referredPropert", false, lazyCreateInterval(9))
	{
		@Override
		public @NonNull MAP_muNameExpCS__2__PropertyCallExp__1__referredPropert newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muNameExpCS__2__PropertyCallExp__1__referredPropert(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muNameExpCS__2__PropertyCallExp__1__type = new AbstractInvocationConstructor(invocationManager, "muNameExpCS__2__PropertyCallExp__1__type", false, lazyCreateInterval(10))
	{
		@Override
		public @NonNull MAP_muNameExpCS__2__PropertyCallExp__1__type newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muNameExpCS__2__PropertyCallExp__1__type(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muNameExpCS__2__PropertyCallExp__0__type = new AbstractInvocationConstructor(invocationManager, "muNameExpCS__2__PropertyCallExp__0__type", false, lazyCreateInterval(10))
	{
		@Override
		public @NonNull MAP_muNameExpCS__2__PropertyCallExp__0__type newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muNameExpCS__2__PropertyCallExp__0__type(this, values);
		}
	};

	private final MiniOCLLookupSolver lookupSolver = new MiniOCLLookupSolver(executor);

	public MiniOCLCS2AS_qvtm_qvtcas(final @NonNull TransformationExecutor executor) {
		super(executor, new @NonNull String[] {"leftCS", "rightAS"}, null, classIndex2classId, classIndex2allClassIndexes);
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
		CTOR_r_MiniOCLCS2AS_46_ocl____load__.invoke(ji_CallExpCS, ji_ClassCS, ji_NameExpCS, ji_NavigationExpCS, ji_OperationCS, ji_PackageCS, ji_ParameterCS, ji_PropertyCS, ji_RootCS);
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
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_minioclcs_c_c_CallExpCS_2 = idResolver.getClass(CLSSid_CallExpCS, null);
			final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, container, TYP_minioclcs_c_c_CallExpCS_2).booleanValue();
			/*@Thrown*/ @Nullable CallExpCS symbol_0;
			if (oclIsKindOf) {
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull CallExpCS oclAsType = (@NonNull CallExpCS)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container, TYP_minioclcs_c_c_CallExpCS_2);
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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Visitable self_2 = (/*@NonInvalid*/ @NonNull Visitable)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable LookupEnvironment env = (/*@NonInvalid*/ @Nullable LookupEnvironment)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @Nullable String vName = (/*@NonInvalid*/ @Nullable String)sourceAndArgumentValues[2];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			/*@Caught*/ @NonNull Object CAUGHT_foundVariable;
			try {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Variable_0 = idResolver.getClass(CLSSid_Variable, null);
				if (env == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::namedElements\'");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull List<NamedElement> namedElements = env.getNamedElements();
				final /*@Thrown*/ @NonNull OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
				final /*@Thrown*/ @NonNull OrderedSetValue selectByKind = (@Nullable OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_namedElements, TYP_miniocl_c_c_Variable_0);
				/*@Thrown*/ OrderedSetValue.@NonNull Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Variable);
				@NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
				/*@Thrown*/ @NonNull OrderedSetValue foundVariable;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						foundVariable = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull Variable _1 = (@NonNull Variable)ITERATOR__1.next();
					/**
					 * name = vName
					 */
					final /*@NonInvalid*/ @Nullable String name = _1.getName();
					final /*@NonInvalid*/ boolean eq = (name != null) ? name.equals(vName) : (vName == null);
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
			/*@Thrown*/ @NonNull OrderedSetValue symbol_0;
			if (and) {
				if (env == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
				}
				final /*@Thrown*/ @Nullable LookupEnvironment parentEnv_0 = env.getParentEnv();
				final /*@Thrown*/ @NonNull OrderedSetValue _lookupVariable = INSTANCE_Visitable__lookupVariable.evaluate(self_2, parentEnv_0, vName);
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

		@SuppressWarnings("null")
		public @NonNull OrderedSetValue evaluate(final /*@NonInvalid*/ @NonNull Visitable self_2, final /*@NonInvalid*/ @Nullable LookupEnvironment env, final /*@NonInvalid*/ @Nullable String vName) {
			return (@NonNull OrderedSetValue)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_2, env, vName});
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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_5 = sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, self_5);
			final /*@NonInvalid*/ boolean eq = parent == null;
			/*@Thrown*/ @NonNull LookupEnvironment symbol_1;
			if (eq) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
				final /*@NonInvalid*/ @NonNull LookupEnvironment symbol_0 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
				symbol_1 = symbol_0;
			}
			else {
				if (parent == null) {
					throw new InvalidEvaluationException("Null source for \'OclElement::_unqualified_env_Variable(OclElement[?]) : lookup::LookupEnvironment[1]\'");
				}
				final /*@Thrown*/ @NonNull LookupEnvironment _unqualified_env_Variable = INSTANCE_OclElement__unqualified_env_Variable.evaluate(parent, self_5);
				symbol_1 = _unqualified_env_Variable;
			}
			return symbol_1;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_5) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_5});
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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull ExpressionInOCL self_4 = (/*@NonInvalid*/ @NonNull ExpressionInOCL)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child = sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull LookupEnvironment self_21 = INSTANCE_OclElement_parentEnv_Variable.evaluate(self_4);
			final /*@NonInvalid*/ @NonNull Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
			final /*@Thrown*/ @NonNull LookupEnvironment symbol_0 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
			CTORid_parentEnv.initValue(symbol_0, self_21);
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Variable ownedSelfVar = self_4.getOwnedSelfVar();
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull LookupEnvironment addElements = symbol_0.addElements(ownedSelfVar);
			return addElements;
		}

		public LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull ExpressionInOCL self_4, final /*@NonInvalid*/ @Nullable Object child) {
			return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_4, child});
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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_6 = sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_0 = sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull LookupEnvironment parentEnv_Variable = INSTANCE_OclElement_parentEnv_Variable.evaluate(self_6);
			return parentEnv_Variable;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_6, final /*@NonInvalid*/ @Nullable Object child_0) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_6, child_0});
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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Operation self_7 = (/*@NonInvalid*/ @NonNull Operation)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_1 = sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull LookupEnvironment self_21 = INSTANCE_OclElement_parentEnv_Variable.evaluate(self_7);
			final /*@NonInvalid*/ @NonNull Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
			final /*@Thrown*/ @NonNull LookupEnvironment symbol_0 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
			CTORid_parentEnv.initValue(symbol_0, self_21);
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<Parameter> ownedParameters = self_7.getOwnedParameters();
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull LookupEnvironment addElements = symbol_0.addElements(ownedParameters);
			return addElements;
		}

		public LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Operation self_7, final /*@NonInvalid*/ @Nullable Object child_1) {
			return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_7, child_1});
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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_3 = sourceAndArgumentValues[0];
			final /*@Thrown*/ @NonNull LookupEnvironment _unqualified_env_Variable = INSTANCE_OclElement__unqualified_env_Variable.evaluate(self_3, null);
			return _unqualified_env_Variable;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_3) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_3});
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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull NameExpCS self_1 = (/*@NonInvalid*/ @NonNull NameExpCS)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_minioclcs_c_c_CSTrace_0 = idResolver.getClass(CLSSid_CSTrace, null);
			final /*@NonInvalid*/ @Nullable Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, self_1);
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull CSTrace oclAsType = (@NonNull CSTrace)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer, TYP_minioclcs_c_c_CSTrace_0);
			final /*@Thrown*/ @Nullable Element self_21 = oclAsType.getAst();
			if (self_21 == null) {
				throw new InvalidEvaluationException("Null where non-null value required");
			}
			final /*@NonInvalid*/ @Nullable PathNameCS expName = self_1.getExpName();
			if (expName == null) {
				throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
			}
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName.getPathElements();
			final /*@Thrown*/ @NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
			final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_pathElements);
			if (aPathElementCS == null) {
				throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
			}
			final /*@Thrown*/ @Nullable String vName_0 = aPathElementCS.getElementName();
			final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Variable = INSTANCE_OclElement_unqualified_env_Variable.evaluate(self_21);
			final /*@Thrown*/ @NonNull OrderedSetValue foundVariable = INSTANCE_Visitable__lookupVariable.evaluate(self_21, unqualified_env_Variable, vName_0);
			final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundVariable).booleanValue();
			/*@Thrown*/ @Nullable Variable symbol_0;
			if (isEmpty) {
				symbol_0 = null;
			}
			else {
				final /*@Thrown*/ @Nullable Variable first = (@Nullable Variable)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundVariable);
				symbol_0 = first;
			}
			return symbol_0;
		}

		public Variable evaluate(final /*@NonInvalid*/ @NonNull NameExpCS self_1) {
			return (Variable)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_1});
		}
	}

	protected final @NonNull CACHE_NameExpCS_lookupVariableToDisambiguate INSTANCE_NameExpCS_lookupVariableToDisambiguate = new CACHE_NameExpCS_lookupVariableToDisambiguate();

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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Visitable self_8 = (/*@NonInvalid*/ @NonNull Visitable)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable LookupEnvironment env_0 = (/*@NonInvalid*/ @Nullable LookupEnvironment)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @Nullable String cName = (/*@NonInvalid*/ @Nullable String)sourceAndArgumentValues[2];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			/*@Caught*/ @NonNull Object CAUGHT_foundClass;
			try {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Class_0 = idResolver.getClass(CLSSid_Class_0, null);
				if (env_0 == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::namedElements\'");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull List<NamedElement> namedElements = env_0.getNamedElements();
				final /*@Thrown*/ @NonNull OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
				final /*@Thrown*/ @NonNull OrderedSetValue selectByKind = (@Nullable OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_namedElements, TYP_miniocl_c_c_Class_0);
				/*@Thrown*/ OrderedSetValue.@NonNull Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Class);
				@NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
				/*@Thrown*/ @NonNull OrderedSetValue foundClass;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						foundClass = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class _1 = (org.eclipse.qvtd.doc.miniocl.@NonNull Class)ITERATOR__1.next();
					/**
					 * name = cName
					 */
					final /*@NonInvalid*/ @Nullable String name = _1.getName();
					final /*@NonInvalid*/ boolean eq = (name != null) ? name.equals(cName) : (cName == null);
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
			/*@Thrown*/ @NonNull OrderedSetValue symbol_0;
			if (and) {
				if (env_0 == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
				}
				final /*@Thrown*/ @Nullable LookupEnvironment parentEnv_0 = env_0.getParentEnv();
				final /*@Thrown*/ @NonNull OrderedSetValue _lookupClass = INSTANCE_Visitable__lookupClass.evaluate(self_8, parentEnv_0, cName);
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

		@SuppressWarnings("null")
		public @NonNull OrderedSetValue evaluate(final /*@NonInvalid*/ @NonNull Visitable self_8, final /*@NonInvalid*/ @Nullable LookupEnvironment env_0, final /*@NonInvalid*/ @Nullable String cName) {
			return (@NonNull OrderedSetValue)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_8, env_0, cName});
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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_11 = sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, self_11);
			final /*@NonInvalid*/ boolean eq = parent == null;
			/*@Thrown*/ @NonNull LookupEnvironment symbol_1;
			if (eq) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
				final /*@NonInvalid*/ @NonNull LookupEnvironment symbol_0 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
				symbol_1 = symbol_0;
			}
			else {
				if (parent == null) {
					throw new InvalidEvaluationException("Null source for \'OclElement::_unqualified_env_Class(OclElement[?]) : lookup::LookupEnvironment[1]\'");
				}
				final /*@Thrown*/ @NonNull LookupEnvironment _unqualified_env_Class = INSTANCE_OclElement__unqualified_env_Class.evaluate(parent, self_11);
				symbol_1 = _unqualified_env_Class;
			}
			return symbol_1;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_11) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_11});
		}
	}

	protected final @NonNull CACHE_OclElement_parentEnv_Class INSTANCE_OclElement_parentEnv_Class = new CACHE_OclElement_parentEnv_Class();

	/**
	 * miniocl::Package::_unqualified_env_Class(child : OclElement[?]) : lookup::LookupEnvironment[?]
	 *
	 * parentEnv_Class().nestedEnv().addElements(ownedClasses)
	 */
	public class CACHE_Package__unqualified_env_Class extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package self_10 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_2 = sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull LookupEnvironment self_21 = INSTANCE_OclElement_parentEnv_Class.evaluate(self_10);
			final /*@NonInvalid*/ @NonNull Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
			final /*@Thrown*/ @NonNull LookupEnvironment symbol_0 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
			CTORid_parentEnv.initValue(symbol_0, self_21);
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = self_10.getOwnedClasses();
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull LookupEnvironment addElements = symbol_0.addElements(ownedClasses);
			return addElements;
		}

		public LookupEnvironment evaluate(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package self_10, final /*@NonInvalid*/ @Nullable Object child_2) {
			return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_10, child_2});
		}
	}

	protected final @NonNull CACHE_Package__unqualified_env_Class INST_Package__unqualified_env_Class = new CACHE_Package__unqualified_env_Class();

	/**
	 * ocl::OclElement::_unqualified_env_Class(child : OclElement[?]) : lookup::LookupEnvironment[1]
	 *
	 * parentEnv_Class()
	 */
	public class CACHE_OclElement__unqualified_env_Class extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_12 = sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_3 = sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull LookupEnvironment parentEnv_Class = INSTANCE_OclElement_parentEnv_Class.evaluate(self_12);
			return parentEnv_Class;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_12, final /*@NonInvalid*/ @Nullable Object child_3) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_12, child_3});
		}
	}

	protected final @NonNull CACHE_OclElement__unqualified_env_Class INST_OclElement__unqualified_env_Class = new CACHE_OclElement__unqualified_env_Class();

	/**
	 * ocl::OclElement::unqualified_env_Class() : lookup::LookupEnvironment[1]
	 *
	 * _unqualified_env_Class(null)
	 */
	public class CACHE_OclElement_unqualified_env_Class extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_9 = sourceAndArgumentValues[0];
			final /*@Thrown*/ @NonNull LookupEnvironment _unqualified_env_Class = INSTANCE_OclElement__unqualified_env_Class.evaluate(self_9, null);
			return _unqualified_env_Class;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_9) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_9});
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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Visitable self_14 = (/*@NonInvalid*/ @NonNull Visitable)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable LookupEnvironment env_1 = (/*@NonInvalid*/ @Nullable LookupEnvironment)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @Nullable String pName = (/*@NonInvalid*/ @Nullable String)sourceAndArgumentValues[2];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			/*@Caught*/ @NonNull Object CAUGHT_foundPackage;
			try {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
				if (env_1 == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::namedElements\'");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull List<NamedElement> namedElements = env_1.getNamedElements();
				final /*@Thrown*/ @NonNull OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
				final /*@Thrown*/ @NonNull OrderedSetValue selectByKind = (@Nullable OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_namedElements, TYP_miniocl_c_c_Package_0);
				/*@Thrown*/ OrderedSetValue.@NonNull Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Package);
				@NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
				/*@Thrown*/ @NonNull OrderedSetValue foundPackage;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						foundPackage = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package _1 = (org.eclipse.qvtd.doc.miniocl.@NonNull Package)ITERATOR__1.next();
					/**
					 * name = pName
					 */
					final /*@NonInvalid*/ @Nullable String name = _1.getName();
					final /*@NonInvalid*/ boolean eq = (name != null) ? name.equals(pName) : (pName == null);
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
			/*@Thrown*/ @NonNull OrderedSetValue symbol_0;
			if (and) {
				if (env_1 == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
				}
				final /*@Thrown*/ @Nullable LookupEnvironment parentEnv_0 = env_1.getParentEnv();
				final /*@Thrown*/ @NonNull OrderedSetValue _lookupPackage = INSTANCE_Visitable__lookupPackage.evaluate(self_14, parentEnv_0, pName);
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

		@SuppressWarnings("null")
		public @NonNull OrderedSetValue evaluate(final /*@NonInvalid*/ @NonNull Visitable self_14, final /*@NonInvalid*/ @Nullable LookupEnvironment env_1, final /*@NonInvalid*/ @Nullable String pName) {
			return (@NonNull OrderedSetValue)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_14, env_1, pName});
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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_17 = sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, self_17);
			final /*@NonInvalid*/ boolean eq = parent == null;
			/*@Thrown*/ @NonNull LookupEnvironment symbol_1;
			if (eq) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
				final /*@NonInvalid*/ @NonNull LookupEnvironment symbol_0 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
				symbol_1 = symbol_0;
			}
			else {
				if (parent == null) {
					throw new InvalidEvaluationException("Null source for \'OclElement::_unqualified_env_Package(OclElement[?]) : lookup::LookupEnvironment[1]\'");
				}
				final /*@Thrown*/ @NonNull LookupEnvironment _unqualified_env_Package = INSTANCE_OclElement__unqualified_env_Package.evaluate(parent, self_17);
				symbol_1 = _unqualified_env_Package;
			}
			return symbol_1;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_17) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_17});
		}
	}

	protected final @NonNull CACHE_OclElement_parentEnv_Package INSTANCE_OclElement_parentEnv_Package = new CACHE_OclElement_parentEnv_Package();

	/**
	 * miniocl::Package::_unqualified_env_Package(child : OclElement[?]) : lookup::LookupEnvironment[?]
	 *
	 * parentEnv_Package().nestedEnv().addElements(ownedPackages)
	 */
	public class CACHE_Package__unqualified_env_Package extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package self_16 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_4 = sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull LookupEnvironment self_21 = INSTANCE_OclElement_parentEnv_Package.evaluate(self_16);
			final /*@NonInvalid*/ @NonNull Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
			final /*@Thrown*/ @NonNull LookupEnvironment symbol_0 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
			CTORid_parentEnv.initValue(symbol_0, self_21);
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Package> ownedPackages = self_16.getOwnedPackages();
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull LookupEnvironment addElements = symbol_0.addElements(ownedPackages);
			return addElements;
		}

		public LookupEnvironment evaluate(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package self_16, final /*@NonInvalid*/ @Nullable Object child_4) {
			return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_16, child_4});
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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Root self_19 = (/*@NonInvalid*/ @NonNull Root)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_6 = sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull LookupEnvironment parentEnv_Package = INSTANCE_OclElement_parentEnv_Package.evaluate(self_19);
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Package> ownedPackages = self_19.getOwnedPackages();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull LookupEnvironment addElements = parentEnv_Package.addElements(ownedPackages);
			return addElements;
		}

		public LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Root self_19, final /*@NonInvalid*/ @Nullable Object child_6) {
			return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_19, child_6});
		}
	}

	protected final @NonNull CACHE_Root__unqualified_env_Package INST_Root__unqualified_env_Package = new CACHE_Root__unqualified_env_Package();

	/**
	 * ocl::OclElement::_unqualified_env_Package(child : OclElement[?]) : lookup::LookupEnvironment[1]
	 *
	 * parentEnv_Package()
	 */
	public class CACHE_OclElement__unqualified_env_Package extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_18 = sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_5 = sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull LookupEnvironment parentEnv_Package = INSTANCE_OclElement_parentEnv_Package.evaluate(self_18);
			return parentEnv_Package;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_18, final /*@NonInvalid*/ @Nullable Object child_5) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_18, child_5});
		}
	}

	protected final @NonNull CACHE_OclElement__unqualified_env_Package INST_OclElement__unqualified_env_Package = new CACHE_OclElement__unqualified_env_Package();

	/**
	 * ocl::OclElement::unqualified_env_Package() : lookup::LookupEnvironment[1]
	 *
	 * _unqualified_env_Package(null)
	 */
	public class CACHE_OclElement_unqualified_env_Package extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_15 = sourceAndArgumentValues[0];
			final /*@Thrown*/ @NonNull LookupEnvironment _unqualified_env_Package = INSTANCE_OclElement__unqualified_env_Package.evaluate(self_15, null);
			return _unqualified_env_Package;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_15) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_15});
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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Visitable self_13 = (/*@NonInvalid*/ @NonNull Visitable)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @NonNull OrderedSetValue segments = (/*@NonInvalid*/ @NonNull OrderedSetValue)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(segments);
			final /*@NonInvalid*/ boolean eq = size.equals(INT_1);
			/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package symbol_2;
			if (eq) {
				final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(segments);
				if (aPathElementCS == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
				}
				final /*@Thrown*/ @Nullable String pName_1 = aPathElementCS.getElementName();
				final /*@NonInvalid*/ @NonNull LookupEnvironment unqualified_env_Package = INSTANCE_OclElement_unqualified_env_Package.evaluate(self_13);
				final /*@Thrown*/ @NonNull OrderedSetValue foundPackage = INSTANCE_Visitable__lookupPackage.evaluate(self_13, unqualified_env_Package, pName_1);
				final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundPackage).booleanValue();
				/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package symbol_0;
				if (isEmpty) {
					symbol_0 = null;
				}
				else {
					final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package first = (org.eclipse.qvtd.doc.miniocl.@Nullable Package)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundPackage);
					symbol_0 = first;
				}
				symbol_2 = symbol_0;
			}
			else {
				final /*@NonInvalid*/ @NonNull IntegerValue diff = (@Nullable IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
				final /*@Thrown*/ @NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(segments, INT_1, diff);
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package qualifier = INSTANCE_Visitable_lookupPackage.evaluate(self_13, qualifierSegments);
				/*@Caught*/ @Nullable Object CAUGHT_qualifier;
				try {
					CAUGHT_qualifier = qualifier;
				}
				catch (Exception e) {
					CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ @NonNull Object lookupQualifiedPackage = CAUGHT_qualifier == null;
				/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package safe_lookupQualifiedPackage_source;
				if (lookupQualifiedPackage == Boolean.TRUE) {
					safe_lookupQualifiedPackage_source = null;
				}
				else {
					if (qualifier == null) {
						throw new InvalidEvaluationException("Null where non-null value required");
					}
					final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_0 = (@Nullable PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(segments);
					if (aPathElementCS_0 == null) {
						throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
					}
					final /*@Thrown*/ @Nullable String pName_2 = aPathElementCS_0.getElementName();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
					final /*@NonInvalid*/ @NonNull LookupEnvironment env_3 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Package> ownedPackages = qualifier.getOwnedPackages();
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull LookupEnvironment addElements = env_3.addElements(ownedPackages);
					final /*@Thrown*/ @NonNull OrderedSetValue foundPackage_0 = INSTANCE_Visitable__lookupPackage.evaluate(qualifier, addElements, pName_2);
					final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundPackage_0).booleanValue();
					/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package symbol_1;
					if (isEmpty_0) {
						symbol_1 = null;
					}
					else {
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package first_0 = (org.eclipse.qvtd.doc.miniocl.@Nullable Package)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundPackage_0);
						symbol_1 = first_0;
					}
					safe_lookupQualifiedPackage_source = symbol_1;
				}
				symbol_2 = safe_lookupQualifiedPackage_source;
			}
			return symbol_2;
		}

		public org.eclipse.qvtd.doc.miniocl.Package evaluate(final /*@NonInvalid*/ @NonNull Visitable self_13, final /*@NonInvalid*/ @NonNull OrderedSetValue segments) {
			return (org.eclipse.qvtd.doc.miniocl.Package)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_13, segments});
		}
	}

	protected final @NonNull CACHE_Visitable_lookupPackage INSTANCE_Visitable_lookupPackage = new CACHE_Visitable_lookupPackage();

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
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Property_0 = idResolver.getClass(CLSSid_Property, null);
				if (env_2 == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::namedElements\'");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull List<NamedElement> namedElements = env_2.getNamedElements();
				final /*@Thrown*/ @NonNull OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
				final /*@Thrown*/ @NonNull OrderedSetValue selectByKind = (@Nullable OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_namedElements, TYP_miniocl_c_c_Property_0);
				/*@Thrown*/ OrderedSetValue.@NonNull Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Property);
				@NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
				/*@Thrown*/ @NonNull OrderedSetValue foundProperty;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						foundProperty = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Property _1 = (org.eclipse.qvtd.doc.miniocl.@NonNull Property)ITERATOR__1.next();
					/**
					 * name = pName
					 */
					final /*@NonInvalid*/ @Nullable String name = _1.getName();
					final /*@NonInvalid*/ boolean eq = (name != null) ? name.equals(pName_0) : (pName_0 == null);
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
			/*@Thrown*/ @NonNull OrderedSetValue symbol_0;
			if (and) {
				if (env_2 == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
				}
				final /*@Thrown*/ @Nullable LookupEnvironment parentEnv_0 = env_2.getParentEnv();
				final /*@Thrown*/ @NonNull OrderedSetValue _lookupProperty = INSTANCE_Visitable__lookupProperty.evaluate(self_20, parentEnv_0, pName_0);
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

		@SuppressWarnings("null")
		public @NonNull OrderedSetValue evaluate(final /*@NonInvalid*/ @NonNull Visitable self_20, final /*@NonInvalid*/ @Nullable LookupEnvironment env_2, final /*@NonInvalid*/ @Nullable String pName_0) {
			return (@NonNull OrderedSetValue)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_20, env_2, pName_0});
		}
	}

	protected final @NonNull CACHE_Visitable__lookupProperty INSTANCE_Visitable__lookupProperty = new CACHE_Visitable__lookupProperty();

	protected class VCACHE_OclElement__unqualified_env_Variable extends AbstractDispatchOperation
	{
		private VCACHE_OclElement__unqualified_env_Variable() {
			install(ExpressionInOCL.class, INST_ExpressionInOCL__unqualified_env_Variable);
			install(Object.class, INST_OclElement__unqualified_env_Variable);
			install(Operation.class, INST_Operation__unqualified_env_Variable);
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_6, final /*@NonInvalid*/ @Nullable Object child_0) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_6, child_0});
		}
	}

	protected final @NonNull VCACHE_OclElement__unqualified_env_Variable INSTANCE_OclElement__unqualified_env_Variable = new VCACHE_OclElement__unqualified_env_Variable();

	protected class VCACHE_OclElement__unqualified_env_Class extends AbstractDispatchOperation
	{
		private VCACHE_OclElement__unqualified_env_Class() {
			install(org.eclipse.qvtd.doc.miniocl.Package.class, INST_Package__unqualified_env_Class);
			install(Object.class, INST_OclElement__unqualified_env_Class);
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_12, final /*@NonInvalid*/ @Nullable Object child_3) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_12, child_3});
		}
	}

	protected final @NonNull VCACHE_OclElement__unqualified_env_Class INSTANCE_OclElement__unqualified_env_Class = new VCACHE_OclElement__unqualified_env_Class();

	protected class VCACHE_OclElement__unqualified_env_Package extends AbstractDispatchOperation
	{
		private VCACHE_OclElement__unqualified_env_Package() {
			install(org.eclipse.qvtd.doc.miniocl.Package.class, INST_Package__unqualified_env_Package);
			install(Root.class, INST_Root__unqualified_env_Package);
			install(Object.class, INST_OclElement__unqualified_env_Package);
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_18, final /*@NonInvalid*/ @Nullable Object child_5) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_18, child_5});
		}
	}

	protected final @NonNull VCACHE_OclElement__unqualified_env_Package INSTANCE_OclElement__unqualified_env_Package = new VCACHE_OclElement__unqualified_env_Package();

	/**
	 *
	 * map r_MiniOCLCS2AS_46_ocl____load__ in MiniOCLCS2AS_qvtm_qvtcas {
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
	 * install mcParameterCS__2__Parameter {
	 * lParameterCS consumes append ji_ParameterCS  : minioclcs::ParameterCS[1];
	 * ;
	 * }
	 *   install mcRootCS__2__Root {
	 * lRootCS consumes append ji_RootCS  : minioclcs::RootCS[1];
	 * ;
	 * }
	 *   install mcPropertyCS__2__Property {
	 * lPropertyCS consumes append ji_PropertyCS  : minioclcs::PropertyCS[1];
	 * ;
	 * }
	 *   install muNavigationExpCS__ast {
	 * lNavigationExpCS consumes append ji_NavigationExpCS  : minioclcs::NavigationExpCS[1];
	 * ;
	 * }
	 *   install mcNameExpCS__2__PropertyCallExp__1 {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install mcClassCS__2__Class {
	 * lClassCS consumes append ji_ClassCS  : minioclcs::ClassCS[1];
	 * ;
	 * }
	 *   install mcOperationCS__2__Operation {
	 * lOperationCS consumes append ji_OperationCS  : minioclcs::OperationCS[1];
	 * ;
	 * }
	 *   install mcPackageCS__2__Package {
	 * lPackageCS consumes append ji_PackageCS  : minioclcs::PackageCS[1];
	 * ;
	 * }
	 *   install muPropertyCS__2__Property__name {
	 * lPropertyCS consumes append ji_PropertyCS  : minioclcs::PropertyCS[1];
	 * ;
	 * }
	 *   install muParameterCS__2__Parameter__name {
	 * lParameterCS consumes append ji_ParameterCS  : minioclcs::ParameterCS[1];
	 * ;
	 * }
	 *   install muPackageCS__2__Package__ownedPackages {
	 * lPackageCS consumes append ji_PackageCS  : minioclcs::PackageCS[1];
	 * ;
	 * }
	 *   install muPackageCS__2__Package__ownedClasses {
	 * lPackageCS consumes append ji_PackageCS  : minioclcs::PackageCS[1];
	 * ;
	 * }
	 *   install muOperationCS__2__Operation__name {
	 * lOperationCS consumes append ji_OperationCS  : minioclcs::OperationCS[1];
	 * ;
	 * }
	 *   install muOperationCS__2__Operation__ownedParameters {
	 * lOperationCS consumes append ji_OperationCS  : minioclcs::OperationCS[1];
	 * ;
	 * }
	 *   install muRootCS__2__Root__ownedPackages {
	 * lRootCS consumes append ji_RootCS  : minioclcs::RootCS[1];
	 * ;
	 * }
	 *   install muClassCS__2__Class__ownedProperties {
	 * lClassCS consumes append ji_ClassCS  : minioclcs::ClassCS[1];
	 * ;
	 * }
	 *   install muClassCS__2__Class__name {
	 * lClassCS consumes append ji_ClassCS  : minioclcs::ClassCS[1];
	 * ;
	 * }
	 *   install muPackageCS__2__Package__name {
	 * lPackageCS consumes append ji_PackageCS  : minioclcs::PackageCS[1];
	 * ;
	 * }
	 *   install muClassCS__2__Class__ownedOperations {
	 * lClassCS consumes append ji_ClassCS  : minioclcs::ClassCS[1];
	 * ;
	 * }
	 *   install mcNameExpCS__2__PropertyCallExp__0 {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install mcNameExpCS__2__VariableExp__1 {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install muCallExpCS__ast {
	 * lCallExpCS consumes append ji_CallExpCS  : minioclcs::CallExpCS[1];
	 * ;
	 * }
	 *   install muNameExpCS__2__PropertyCallExp__1__ownedSource {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install muParameterCS__2__Parameter__type {
	 * lParameterCS consumes append ji_ParameterCS  : minioclcs::ParameterCS[1];
	 * ;
	 * }
	 *   install muNameExpCS__2__PropertyCallExp__0__ownedSource {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install muPropertyCS__2__Property__type {
	 * lPropertyCS consumes append ji_PropertyCS  : minioclcs::PropertyCS[1];
	 * ;
	 * }
	 *   install muNameExpCS__2__VariableExp__1__referredVariable {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install muOperationCS__2__Operation__type {
	 * lOperationCS consumes append ji_OperationCS  : minioclcs::OperationCS[1];
	 * ;
	 * }
	 *   install muNameExpCS__2__VariableExp__1__type {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install muNameExpCS__2__PropertyCallExp__0__referredPropert {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install muNameExpCS__2__PropertyCallExp__1__referredPropert {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install muNameExpCS__2__PropertyCallExp__1__type {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install muNameExpCS__2__PropertyCallExp__0__type {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install muOperationCS__2__Operation__ownedBodyExpression {
	 * lOperationCS consumes append ji_OperationCS  : minioclcs::OperationCS[1];
	 * ;
	 * }
	 */
	protected class MAP_r_MiniOCLCS2AS_46_ocl____load__ extends AbstractInvocation
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

		public MAP_r_MiniOCLCS2AS_46_ocl____load__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
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
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mcParameterCS__2__Parameter") {
				@Override
				public boolean execute() {
					for (@NonNull ParameterCS lParameterCS_2 : ji_ParameterCS.typedIterable(ParameterCS.class)) {
						MAP_mcParameterCS__2__Parameter(lParameterCS_2);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mcRootCS__2__Root") {
				@Override
				public boolean execute() {
					for (@NonNull RootCS lRootCS_1 : ji_RootCS.typedIterable(RootCS.class)) {
						MAP_mcRootCS__2__Root(lRootCS_1);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mcPropertyCS__2__Property") {
				@Override
				public boolean execute() {
					for (@NonNull PropertyCS lPropertyCS_2 : ji_PropertyCS.typedIterable(PropertyCS.class)) {
						MAP_mcPropertyCS__2__Property(lPropertyCS_2);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "muNavigationExpCS__ast") {
				@Override
				public boolean execute() {
					for (@NonNull NavigationExpCS lNavigationExpCS_0 : ji_NavigationExpCS.typedIterable(NavigationExpCS.class)) {
						MAP_muNavigationExpCS__ast(lNavigationExpCS_0);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mcNameExpCS__2__PropertyCallExp__1") {
				@Override
				public boolean execute() {
					for (@NonNull NameExpCS lNameExpCS_10 : ji_NameExpCS.typedIterable(NameExpCS.class)) {
						MAP_mcNameExpCS__2__PropertyCallExp__1(lNameExpCS_10);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mcClassCS__2__Class") {
				@Override
				public boolean execute() {
					for (@NonNull ClassCS lClassCS_3 : ji_ClassCS.typedIterable(ClassCS.class)) {
						MAP_mcClassCS__2__Class(lClassCS_3);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mcOperationCS__2__Operation") {
				@Override
				public boolean execute() {
					for (@NonNull OperationCS lOperationCS_4 : ji_OperationCS.typedIterable(OperationCS.class)) {
						MAP_mcOperationCS__2__Operation(lOperationCS_4);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mcPackageCS__2__Package") {
				@Override
				public boolean execute() {
					for (@NonNull PackageCS lPackageCS_3 : ji_PackageCS.typedIterable(PackageCS.class)) {
						MAP_mcPackageCS__2__Package(lPackageCS_3);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "muPropertyCS__2__Property__name") {
				@Override
				public boolean execute() {
					for (@NonNull PropertyCS lPropertyCS_3 : ji_PropertyCS.typedIterable(PropertyCS.class)) {
						MAP_muPropertyCS__2__Property__name(lPropertyCS_3);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "muParameterCS__2__Parameter__name") {
				@Override
				public boolean execute() {
					for (@NonNull ParameterCS lParameterCS_3 : ji_ParameterCS.typedIterable(ParameterCS.class)) {
						MAP_muParameterCS__2__Parameter__name(lParameterCS_3);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "muPackageCS__2__Package__ownedPackages") {
				@Override
				public boolean execute() {
					for (@NonNull PackageCS lPackageCS_4 : ji_PackageCS.typedIterable(PackageCS.class)) {
						MAP_muPackageCS__2__Package__ownedPackages(lPackageCS_4);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "muPackageCS__2__Package__ownedClasses") {
				@Override
				public boolean execute() {
					for (@NonNull PackageCS lPackageCS_5 : ji_PackageCS.typedIterable(PackageCS.class)) {
						MAP_muPackageCS__2__Package__ownedClasses(lPackageCS_5);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "muOperationCS__2__Operation__name") {
				@Override
				public boolean execute() {
					for (@NonNull OperationCS lOperationCS_5 : ji_OperationCS.typedIterable(OperationCS.class)) {
						MAP_muOperationCS__2__Operation__name(lOperationCS_5);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "muOperationCS__2__Operation__ownedParameters") {
				@Override
				public boolean execute() {
					for (@NonNull OperationCS lOperationCS_6 : ji_OperationCS.typedIterable(OperationCS.class)) {
						MAP_muOperationCS__2__Operation__ownedParameters(lOperationCS_6);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "muRootCS__2__Root__ownedPackages") {
				@Override
				public boolean execute() {
					for (@NonNull RootCS lRootCS_2 : ji_RootCS.typedIterable(RootCS.class)) {
						MAP_muRootCS__2__Root__ownedPackages(lRootCS_2);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "muClassCS__2__Class__ownedProperties") {
				@Override
				public boolean execute() {
					for (@NonNull ClassCS lClassCS_4 : ji_ClassCS.typedIterable(ClassCS.class)) {
						MAP_muClassCS__2__Class__ownedProperties(lClassCS_4);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "muClassCS__2__Class__name") {
				@Override
				public boolean execute() {
					for (@NonNull ClassCS lClassCS_5 : ji_ClassCS.typedIterable(ClassCS.class)) {
						MAP_muClassCS__2__Class__name(lClassCS_5);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "muPackageCS__2__Package__name") {
				@Override
				public boolean execute() {
					for (@NonNull PackageCS lPackageCS_6 : ji_PackageCS.typedIterable(PackageCS.class)) {
						MAP_muPackageCS__2__Package__name(lPackageCS_6);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(2/*..null*/), "muClassCS__2__Class__ownedOperations") {
				@Override
				public boolean execute() {
					for (@NonNull ClassCS lClassCS_6 : ji_ClassCS.typedIterable(ClassCS.class)) {
						MAP_muClassCS__2__Class__ownedOperations(lClassCS_6);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mcNameExpCS__2__PropertyCallExp__0") {
				@Override
				public boolean execute() {
					for (@NonNull NameExpCS lNameExpCS_11 : ji_NameExpCS.typedIterable(NameExpCS.class)) {
						MAP_mcNameExpCS__2__PropertyCallExp__0(lNameExpCS_11);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "mcNameExpCS__2__VariableExp__1") {
				@Override
				public boolean execute() {
					for (@NonNull NameExpCS lNameExpCS_12 : ji_NameExpCS.typedIterable(NameExpCS.class)) {
						MAP_mcNameExpCS__2__VariableExp__1(lNameExpCS_12);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(3/*..null*/), "muCallExpCS__ast") {
				@Override
				public boolean execute() {
					for (@NonNull CallExpCS lCallExpCS_0 : ji_CallExpCS.typedIterable(CallExpCS.class)) {
						MAP_muCallExpCS__ast(lCallExpCS_0);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(4/*..null*/), "muNameExpCS__2__PropertyCallExp__1__ownedSource") {
				@Override
				public boolean execute() {
					for (@NonNull NameExpCS lNameExpCS_13 : ji_NameExpCS.typedIterable(NameExpCS.class)) {
						MAP_muNameExpCS__2__PropertyCallExp__1__ownedSource(lNameExpCS_13);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(5/*..6*/), "muParameterCS__2__Parameter__type") {
				@Override
				public boolean execute() {
					for (@NonNull ParameterCS lParameterCS_4 : ji_ParameterCS.typedIterable(ParameterCS.class)) {
						MAP_muParameterCS__2__Parameter__type(lParameterCS_4);
					}
					return true;
				}
			};
			CTOR_muNameExpCS__2__PropertyCallExp__0__ownedSource.addConsumedConnection(ji_NameExpCS);
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "muPropertyCS__2__Property__type") {
				@Override
				public boolean execute() {
					for (@NonNull PropertyCS lPropertyCS_4 : ji_PropertyCS.typedIterable(PropertyCS.class)) {
						MAP_muPropertyCS__2__Property__type(lPropertyCS_4);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "muNameExpCS__2__VariableExp__1__referredVariable") {
				@Override
				public boolean execute() {
					for (@NonNull NameExpCS lNameExpCS_15 : ji_NameExpCS.typedIterable(NameExpCS.class)) {
						MAP_muNameExpCS__2__VariableExp__1__referredVariable(lNameExpCS_15);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(7/*..null*/), "muOperationCS__2__Operation__type") {
				@Override
				public boolean execute() {
					for (@NonNull OperationCS lOperationCS_7 : ji_OperationCS.typedIterable(OperationCS.class)) {
						MAP_muOperationCS__2__Operation__type(lOperationCS_7);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(8/*..null*/), "muNameExpCS__2__VariableExp__1__type") {
				@Override
				public boolean execute() {
					for (@NonNull NameExpCS lNameExpCS_16 : ji_NameExpCS.typedIterable(NameExpCS.class)) {
						MAP_muNameExpCS__2__VariableExp__1__type(lNameExpCS_16);
					}
					return true;
				}
			};
			CTOR_muNameExpCS__2__PropertyCallExp__0__referredPropert.addConsumedConnection(ji_NameExpCS);
			CTOR_muNameExpCS__2__PropertyCallExp__1__referredPropert.addConsumedConnection(ji_NameExpCS);
			CTOR_muNameExpCS__2__PropertyCallExp__1__type.addConsumedConnection(ji_NameExpCS);
			CTOR_muNameExpCS__2__PropertyCallExp__0__type.addConsumedConnection(ji_NameExpCS);
			new AbstractSimpleInvocation(lazyCreateInterval(11/*..null*/), "muOperationCS__2__Operation__ownedBodyExpression") {
				@Override
				public boolean execute() {
					for (@NonNull OperationCS lOperationCS_8 : ji_OperationCS.typedIterable(OperationCS.class)) {
						MAP_muOperationCS__2__Operation__ownedBodyExpression(lOperationCS_8);
					}
					return true;
				}
			};
			final /*@Thrown*/ @Nullable Boolean r_MiniOCLCS2AS_46_ocl____load__ = ValueUtil.TRUE_VALUE;
			return r_MiniOCLCS2AS_46_ocl____load__;
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
	 * map mcPropertyCS__2__Property in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lPropertyCS : minioclcs::PropertyCS[1];
	 * new:rightAS rProperty : miniocl::Property[1];
	 * set lPropertyCS.ast := rProperty;
	 *
	 */
	protected boolean MAP_mcPropertyCS__2__Property(final /*@NonInvalid*/ @NonNull PropertyCS lPropertyCS)  {
		// creations
		final @SuppressWarnings("null")org.eclipse.qvtd.doc.miniocl.@NonNull Property rProperty = MiniOCLFactory.eINSTANCE.createProperty();
		models[1/*rightAS*/].add(rProperty, false);
		// mapping statements
		lPropertyCS.setAst(rProperty);
		final /*@Thrown*/ @Nullable Boolean mcPropertyCS__2__Property = ValueUtil.TRUE_VALUE;
		return mcPropertyCS__2__Property;
	}

	/**
	 *
	 * map mcNameExpCS__2__PropertyCallExp__1 in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource();
	 * check isPropCallExpWithExplicitSource;
	 * new:rightAS rPropertyCallExp : miniocl::PropertyCallExp[1];
	 * notify set lNameExpCS.ast := rPropertyCallExp;
	 *
	 */
	protected boolean MAP_mcNameExpCS__2__PropertyCallExp__1(final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS)  {
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
			objectManager.assigned(lNameExpCS, MinioclcsPackage.Literals.CS_TRACE__AST, rPropertyCallExp);
			final /*@Thrown*/ @Nullable Boolean mcNameExpCS__2__PropertyCallExp__1 = ValueUtil.TRUE_VALUE;
			symbol_3 = mcNameExpCS__2__PropertyCallExp__1;
		}
		else {
			symbol_3 = ValueUtil.FALSE_VALUE;
		}
		return symbol_3;
	}

	/**
	 *
	 * map mcRootCS__2__Root in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lRootCS : minioclcs::RootCS[1];
	 * new:rightAS rRoot : miniocl::Root[1];
	 * set lRootCS.ast := rRoot;
	 *
	 */
	protected boolean MAP_mcRootCS__2__Root(final /*@NonInvalid*/ @NonNull RootCS lRootCS)  {
		// creations
		final @SuppressWarnings("null")@NonNull Root rRoot = MiniOCLFactory.eINSTANCE.createRoot();
		models[1/*rightAS*/].add(rRoot, false);
		// mapping statements
		lRootCS.setAst(rRoot);
		final /*@Thrown*/ @Nullable Boolean mcRootCS__2__Root = ValueUtil.TRUE_VALUE;
		return mcRootCS__2__Root;
	}

	/**
	 *
	 * map muNavigationExpCS__ast in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNavigationExpCS : minioclcs::NavigationExpCS[1];
	 * var oclIsTypeOf : Boolean[1] := lNavigationExpCS.oclIsTypeOf(minioclcs::NavigationExpCS);
	 * check oclIsTypeOf;
	 * set lNavigationExpCS.ast := null;
	 *
	 */
	protected boolean MAP_muNavigationExpCS__ast(final /*@NonInvalid*/ @NonNull NavigationExpCS lNavigationExpCS)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_minioclcs_c_c_NavigationExpCS_0 = idResolver.getClass(CLSSid_NavigationExpCS, null);
		final /*@NonInvalid*/ boolean oclIsTypeOf = OclAnyOclIsTypeOfOperation.INSTANCE.evaluate(executor, lNavigationExpCS, TYP_minioclcs_c_c_NavigationExpCS_0).booleanValue();
		/*@Thrown*/ @Nullable Boolean symbol_2;
		if (oclIsTypeOf) {
			// mapping statements
			lNavigationExpCS.setAst(null);
			final /*@Thrown*/ @Nullable Boolean muNavigationExpCS__ast = ValueUtil.TRUE_VALUE;
			symbol_2 = muNavigationExpCS__ast;
		}
		else {
			symbol_2 = ValueUtil.FALSE_VALUE;
		}
		return symbol_2;
	}

	/**
	 *
	 * map mcParameterCS__2__Parameter in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lParameterCS : minioclcs::ParameterCS[1];
	 * new:rightAS rParameter : miniocl::Parameter[1];
	 * set lParameterCS.ast := rParameter;
	 *
	 */
	protected boolean MAP_mcParameterCS__2__Parameter(final /*@NonInvalid*/ @NonNull ParameterCS lParameterCS)  {
		// creations
		final @SuppressWarnings("null")@NonNull Parameter rParameter = MiniOCLFactory.eINSTANCE.createParameter();
		models[1/*rightAS*/].add(rParameter, false);
		// mapping statements
		lParameterCS.setAst(rParameter);
		final /*@Thrown*/ @Nullable Boolean mcParameterCS__2__Parameter = ValueUtil.TRUE_VALUE;
		return mcParameterCS__2__Parameter;
	}

	/**
	 *
	 * map mcClassCS__2__Class in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lClassCS : minioclcs::ClassCS[1];
	 * new:rightAS rClass : miniocl::Class[1];
	 * set lClassCS.ast := rClass;
	 *
	 */
	protected boolean MAP_mcClassCS__2__Class(final /*@NonInvalid*/ @NonNull ClassCS lClassCS)  {
		// creations
		final @SuppressWarnings("null")org.eclipse.qvtd.doc.miniocl.@NonNull Class rClass = MiniOCLFactory.eINSTANCE.createClass();
		models[1/*rightAS*/].add(rClass, false);
		// mapping statements
		lClassCS.setAst(rClass);
		final /*@Thrown*/ @Nullable Boolean mcClassCS__2__Class = ValueUtil.TRUE_VALUE;
		return mcClassCS__2__Class;
	}

	/**
	 *
	 * map mcOperationCS__2__Operation in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lOperationCS : minioclcs::OperationCS[1];
	 * new:rightAS rOperation : miniocl::Operation[1];
	 * set lOperationCS.ast := rOperation;
	 *
	 */
	protected boolean MAP_mcOperationCS__2__Operation(final /*@NonInvalid*/ @NonNull OperationCS lOperationCS)  {
		// creations
		final @SuppressWarnings("null")@NonNull Operation rOperation = MiniOCLFactory.eINSTANCE.createOperation();
		models[1/*rightAS*/].add(rOperation, false);
		// mapping statements
		lOperationCS.setAst(rOperation);
		final /*@Thrown*/ @Nullable Boolean mcOperationCS__2__Operation = ValueUtil.TRUE_VALUE;
		return mcOperationCS__2__Operation;
	}

	/**
	 *
	 * map mcPackageCS__2__Package in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lPackageCS : minioclcs::PackageCS[1];
	 * new:rightAS rPackage : miniocl::Package[1];
	 * set lPackageCS.ast := rPackage;
	 *
	 */
	protected boolean MAP_mcPackageCS__2__Package(final /*@NonInvalid*/ @NonNull PackageCS lPackageCS)  {
		// creations
		final @SuppressWarnings("null")org.eclipse.qvtd.doc.miniocl.@NonNull Package rPackage = MiniOCLFactory.eINSTANCE.createPackage();
		models[1/*rightAS*/].add(rPackage, false);
		// mapping statements
		lPackageCS.setAst(rPackage);
		final /*@Thrown*/ @Nullable Boolean mcPackageCS__2__Package = ValueUtil.TRUE_VALUE;
		return mcPackageCS__2__Package;
	}

	/**
	 *
	 * map muPropertyCS__2__Property__name in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lPropertyCS : minioclcs::PropertyCS[1];
	 * var ast : miniocl::Element[1] := lPropertyCS.ast;
	 * check var ast1 : miniocl::Property[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::Property)
	 *   ;
	 * var name : ecore::EString[?] := lPropertyCS.name;
	 * var toString : String[1] := name.toString();
	 * set ast1.name := toString;
	 *
	 */
	protected boolean MAP_muPropertyCS__2__Property__name(final /*@NonInvalid*/ @NonNull PropertyCS lPropertyCS_0)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lPropertyCS_0.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lPropertyCS_0, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof org.eclipse.qvtd.doc.miniocl.Property;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_1) {
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Property symbol_2 = (org.eclipse.qvtd.doc.miniocl.Property)ast;
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Property_0 = idResolver.getClass(CLSSid_Property, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Property oclAsType = (org.eclipse.qvtd.doc.miniocl.@NonNull Property)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Property_0);
				final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (eq) {
					final /*@NonInvalid*/ @Nullable String name = lPropertyCS_0.getName();
					final /*@Thrown*/ @NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
					// mapping statements
					symbol_2.setName(toString);
					final /*@Thrown*/ @Nullable Boolean muPropertyCS__2__Property__name = ValueUtil.TRUE_VALUE;
					symbol_5 = muPropertyCS__2__Property__name;
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
	}

	/**
	 *
	 * map muParameterCS__2__Parameter__name in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lParameterCS : minioclcs::ParameterCS[1];
	 * var ast : miniocl::Element[1] := lParameterCS.ast;
	 * check var ast1 : miniocl::Parameter[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::Parameter)
	 *   ;
	 * var name : ecore::EString[?] := lParameterCS.name;
	 * var toString : String[1] := name.toString();
	 * set ast1.name := toString;
	 *
	 */
	protected boolean MAP_muParameterCS__2__Parameter__name(final /*@NonInvalid*/ @NonNull ParameterCS lParameterCS_0)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lParameterCS_0.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lParameterCS_0, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof Parameter;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_1) {
				final /*@Thrown*/ @NonNull Parameter symbol_2 = (Parameter)ast;
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Parameter_0 = idResolver.getClass(CLSSid_Parameter, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull Parameter oclAsType = (@NonNull Parameter)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Parameter_0);
				final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (eq) {
					final /*@NonInvalid*/ @Nullable String name = lParameterCS_0.getName();
					final /*@Thrown*/ @NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
					// mapping statements
					symbol_2.setName(toString);
					final /*@Thrown*/ @Nullable Boolean muParameterCS__2__Parameter__name = ValueUtil.TRUE_VALUE;
					symbol_5 = muParameterCS__2__Parameter__name;
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
	}

	/**
	 *
	 * map muRootCS__2__Root__ownedPackages in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lRootCS : minioclcs::RootCS[1];
	 * var ast : miniocl::Element[1] := lRootCS.ast;
	 * check var ast1 : miniocl::Root[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::Root)
	 *   ;
	 * var packages : OrderedSet(minioclcs::PackageCS) := lRootCS.packages;
	 * var asOrderedSet : OrderedSet(miniocl::Package) := packages->collect(_'1_' |
	 *     _'1_'.ast.oclAsType(miniocl::Package))
	 *   ->asOrderedSet()
	 *   ;
	 * var collect : Sequence(miniocl::Package) := packages->collect(_'1_' |
	 *     _'1_'.ast.oclAsType(miniocl::Package));
	 * set ast1.ownedPackages := asOrderedSet;
	 *
	 */
	protected boolean MAP_muRootCS__2__Root__ownedPackages(final /*@NonInvalid*/ @NonNull RootCS lRootCS_0)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lRootCS_0.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lRootCS_0, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof Root;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_1) {
				final /*@Thrown*/ @NonNull Root symbol_2 = (Root)ast;
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Root_0 = idResolver.getClass(CLSSid_Root, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull Root oclAsType = (@NonNull Root)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Root_0);
				final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (eq) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<PackageCS> packages = lRootCS_0.getPackages();
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_packages_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, packages);
					/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
					@NonNull Iterator<Object> ITERATOR__1_0 = BOXED_packages_0.iterator();
					/*@Thrown*/ @NonNull SequenceValue collect_0;
					while (true) {
						if (!ITERATOR__1_0.hasNext()) {
							collect_0 = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull PackageCS _1_0 = (@NonNull PackageCS)ITERATOR__1_0.next();
						/**
						 * _'1_'.ast.oclAsType(miniocl::Package)
						 */
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Package_1 = idResolver.getClass(CLSSid_Package, null);
						final /*@NonInvalid*/ @Nullable Element ast_1 = _1_0.getAst();
						@SuppressWarnings("null")
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package oclAsType_1 = (org.eclipse.qvtd.doc.miniocl.@NonNull Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_1, TYP_miniocl_c_c_Package_1);
						//
						accumulator.add(oclAsType_1);
					}
					final /*@Thrown*/ @NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect_0);
					// mapping statements
					final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Package> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.qvtd.doc.miniocl.Package.class, asOrderedSet);
					symbol_2.getOwnedPackages().addAll(ECORE_asOrderedSet);
					final /*@Thrown*/ @Nullable Boolean muRootCS__2__Root__ownedPackages = ValueUtil.TRUE_VALUE;
					symbol_5 = muRootCS__2__Root__ownedPackages;
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
	}

	/**
	 *
	 * map muPackageCS__2__Package__ownedPackages in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lPackageCS : minioclcs::PackageCS[1];
	 * var ast : miniocl::Element[1] := lPackageCS.ast;
	 * check var ast1 : miniocl::Package[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::Package)
	 *   ;
	 * var packages : OrderedSet(minioclcs::PackageCS) := lPackageCS.packages;
	 * var asOrderedSet : OrderedSet(miniocl::Package) := packages->collect(_'1_' |
	 *     _'1_'.ast.oclAsType(miniocl::Package))
	 *   ->asOrderedSet()
	 *   ;
	 * var collect : Sequence(miniocl::Package) := packages->collect(_'1_' |
	 *     _'1_'.ast.oclAsType(miniocl::Package));
	 * set ast1.ownedPackages := asOrderedSet;
	 *
	 */
	protected boolean MAP_muPackageCS__2__Package__ownedPackages(final /*@NonInvalid*/ @NonNull PackageCS lPackageCS_0)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lPackageCS_0.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lPackageCS_0, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof org.eclipse.qvtd.doc.miniocl.Package;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_1) {
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package symbol_2 = (org.eclipse.qvtd.doc.miniocl.Package)ast;
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package oclAsType = (org.eclipse.qvtd.doc.miniocl.@NonNull Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Package_0);
				final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (eq) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<PackageCS> packages = lPackageCS_0.getPackages();
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_packages_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, packages);
					/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
					@NonNull Iterator<Object> ITERATOR__1_0 = BOXED_packages_0.iterator();
					/*@Thrown*/ @NonNull SequenceValue collect_0;
					while (true) {
						if (!ITERATOR__1_0.hasNext()) {
							collect_0 = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull PackageCS _1_0 = (@NonNull PackageCS)ITERATOR__1_0.next();
						/**
						 * _'1_'.ast.oclAsType(miniocl::Package)
						 */
						final /*@NonInvalid*/ @Nullable Element ast_1 = _1_0.getAst();
						@SuppressWarnings("null")
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package oclAsType_1 = (org.eclipse.qvtd.doc.miniocl.@NonNull Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_1, TYP_miniocl_c_c_Package_0);
						//
						accumulator.add(oclAsType_1);
					}
					final /*@Thrown*/ @NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect_0);
					// mapping statements
					final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Package> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.qvtd.doc.miniocl.Package.class, asOrderedSet);
					symbol_2.getOwnedPackages().addAll(ECORE_asOrderedSet);
					final /*@Thrown*/ @Nullable Boolean muPackageCS__2__Package__ownedPackages = ValueUtil.TRUE_VALUE;
					symbol_5 = muPackageCS__2__Package__ownedPackages;
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
	}

	/**
	 *
	 * map muOperationCS__2__Operation__name in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lOperationCS : minioclcs::OperationCS[1];
	 * var ast : miniocl::Element[1] := lOperationCS.ast;
	 * check var ast1 : miniocl::Operation[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::Operation)
	 *   ;
	 * var name : ecore::EString[?] := lOperationCS.name;
	 * var toString : String[1] := name.toString();
	 * set ast1.name := toString;
	 *
	 */
	protected boolean MAP_muOperationCS__2__Operation__name(final /*@NonInvalid*/ @NonNull OperationCS lOperationCS_0)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lOperationCS_0.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lOperationCS_0, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof Operation;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_1) {
				final /*@Thrown*/ @NonNull Operation symbol_2 = (Operation)ast;
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull Operation oclAsType = (@NonNull Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Operation_0);
				final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (eq) {
					final /*@NonInvalid*/ @Nullable String name = lOperationCS_0.getName();
					final /*@Thrown*/ @NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
					// mapping statements
					symbol_2.setName(toString);
					final /*@Thrown*/ @Nullable Boolean muOperationCS__2__Operation__name = ValueUtil.TRUE_VALUE;
					symbol_5 = muOperationCS__2__Operation__name;
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
	}

	/**
	 *
	 * map muClassCS__2__Class__name in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lClassCS : minioclcs::ClassCS[1];
	 * var ast : miniocl::Element[1] := lClassCS.ast;
	 * check var ast1 : miniocl::Class[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::Class)
	 *   ;
	 * var name : ecore::EString[?] := lClassCS.name;
	 * var toString : String[1] := name.toString();
	 * set ast1.name := toString;
	 *
	 */
	protected boolean MAP_muClassCS__2__Class__name(final /*@NonInvalid*/ @NonNull ClassCS lClassCS_0)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lClassCS_0.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lClassCS_0, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof org.eclipse.qvtd.doc.miniocl.Class;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_1) {
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class symbol_2 = (org.eclipse.qvtd.doc.miniocl.Class)ast;
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Class_0 = idResolver.getClass(CLSSid_Class_0, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class oclAsType = (org.eclipse.qvtd.doc.miniocl.@NonNull Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Class_0);
				final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (eq) {
					final /*@NonInvalid*/ @Nullable String name = lClassCS_0.getName();
					final /*@Thrown*/ @NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
					// mapping statements
					symbol_2.setName(toString);
					final /*@Thrown*/ @Nullable Boolean muClassCS__2__Class__name = ValueUtil.TRUE_VALUE;
					symbol_5 = muClassCS__2__Class__name;
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
	}

	/**
	 *
	 * map muPackageCS__2__Package__ownedClasses in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lPackageCS : minioclcs::PackageCS[1];
	 * var ast : miniocl::Element[1] := lPackageCS.ast;
	 * check var ast1 : miniocl::Package[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::Package)
	 *   ;
	 * var classes : OrderedSet(minioclcs::ClassCS) := lPackageCS.classes;
	 * var asOrderedSet : OrderedSet(miniocl::Class) := classes->collect(_'1_' |
	 *     _'1_'.ast.oclAsType(miniocl::Class))
	 *   ->asOrderedSet()
	 *   ;
	 * var collect : Sequence(miniocl::Class) := classes->collect(_'1_' |
	 *     _'1_'.ast.oclAsType(miniocl::Class));
	 * set ast1.ownedClasses := asOrderedSet;
	 *
	 */
	protected boolean MAP_muPackageCS__2__Package__ownedClasses(final /*@NonInvalid*/ @NonNull PackageCS lPackageCS_1)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lPackageCS_1.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lPackageCS_1, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof org.eclipse.qvtd.doc.miniocl.Package;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_1) {
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package symbol_2 = (org.eclipse.qvtd.doc.miniocl.Package)ast;
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package oclAsType = (org.eclipse.qvtd.doc.miniocl.@NonNull Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Package_0);
				final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (eq) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<ClassCS> classes = lPackageCS_1.getClasses();
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_classes_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_ClassCS, classes);
					/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Class);
					@NonNull Iterator<Object> ITERATOR__1_0 = BOXED_classes_0.iterator();
					/*@Thrown*/ @NonNull SequenceValue collect_0;
					while (true) {
						if (!ITERATOR__1_0.hasNext()) {
							collect_0 = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull ClassCS _1_0 = (@NonNull ClassCS)ITERATOR__1_0.next();
						/**
						 * _'1_'.ast.oclAsType(miniocl::Class)
						 */
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Class_1 = idResolver.getClass(CLSSid_Class_0, null);
						final /*@NonInvalid*/ @Nullable Element ast_1 = _1_0.getAst();
						@SuppressWarnings("null")
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class oclAsType_1 = (org.eclipse.qvtd.doc.miniocl.@NonNull Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_1, TYP_miniocl_c_c_Class_1);
						//
						accumulator.add(oclAsType_1);
					}
					final /*@Thrown*/ @NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect_0);
					// mapping statements
					final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.qvtd.doc.miniocl.Class.class, asOrderedSet);
					symbol_2.getOwnedClasses().addAll(ECORE_asOrderedSet);
					final /*@Thrown*/ @Nullable Boolean muPackageCS__2__Package__ownedClasses = ValueUtil.TRUE_VALUE;
					symbol_5 = muPackageCS__2__Package__ownedClasses;
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
	}

	/**
	 *
	 * map muOperationCS__2__Operation__ownedParameters in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lOperationCS : minioclcs::OperationCS[1];
	 * var ast : miniocl::Element[1] := lOperationCS.ast;
	 * check var ast1 : miniocl::Operation[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::Operation)
	 *   ;
	 * var params : OrderedSet(minioclcs::ParameterCS) := lOperationCS.params;
	 * var asOrderedSet : OrderedSet(miniocl::Parameter) := params->collect(_'1_' |
	 *     _'1_'.ast.oclAsType(miniocl::Parameter))
	 *   ->asOrderedSet()
	 *   ;
	 * var collect : Sequence(miniocl::Parameter) := params->collect(_'1_' |
	 *     _'1_'.ast.oclAsType(miniocl::Parameter));
	 * set ast1.ownedParameters := asOrderedSet;
	 *
	 */
	protected boolean MAP_muOperationCS__2__Operation__ownedParameters(final /*@NonInvalid*/ @NonNull OperationCS lOperationCS_1)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lOperationCS_1.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lOperationCS_1, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof Operation;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_1) {
				final /*@Thrown*/ @NonNull Operation symbol_2 = (Operation)ast;
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull Operation oclAsType = (@NonNull Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Operation_0);
				final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (eq) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<ParameterCS> params = lOperationCS_1.getParams();
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_params_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_ParameterCS, params);
					/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Parameter);
					@NonNull Iterator<Object> ITERATOR__1_0 = BOXED_params_0.iterator();
					/*@Thrown*/ @NonNull SequenceValue collect_0;
					while (true) {
						if (!ITERATOR__1_0.hasNext()) {
							collect_0 = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull ParameterCS _1_0 = (@NonNull ParameterCS)ITERATOR__1_0.next();
						/**
						 * _'1_'.ast.oclAsType(miniocl::Parameter)
						 */
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Parameter_1 = idResolver.getClass(CLSSid_Parameter, null);
						final /*@NonInvalid*/ @Nullable Element ast_1 = _1_0.getAst();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull Parameter oclAsType_1 = (@NonNull Parameter)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_1, TYP_miniocl_c_c_Parameter_1);
						//
						accumulator.add(oclAsType_1);
					}
					final /*@Thrown*/ @NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect_0);
					// mapping statements
					final /*@Thrown*/ @NonNull List<Parameter> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Parameter.class, asOrderedSet);
					symbol_2.getOwnedParameters().addAll(ECORE_asOrderedSet);
					final /*@Thrown*/ @Nullable Boolean muOperationCS__2__Operation__ownedParameters = ValueUtil.TRUE_VALUE;
					symbol_5 = muOperationCS__2__Operation__ownedParameters;
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
	}

	/**
	 *
	 * map muClassCS__2__Class__ownedProperties in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lClassCS : minioclcs::ClassCS[1];
	 * var ast : miniocl::Element[1] := lClassCS.ast;
	 * check var ast1 : miniocl::Class[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::Class)
	 *   ;
	 * var properties : OrderedSet(minioclcs::PropertyCS) := lClassCS.properties;
	 * var asOrderedSet : OrderedSet(miniocl::Property) := properties->collect(_'1_' |
	 *     _'1_'.ast.oclAsType(miniocl::Property))
	 *   ->asOrderedSet()
	 *   ;
	 * var collect : Sequence(miniocl::Property) := properties->collect(_'1_' |
	 *     _'1_'.ast.oclAsType(miniocl::Property));
	 * set ast1.ownedProperties := asOrderedSet;
	 *
	 */
	protected boolean MAP_muClassCS__2__Class__ownedProperties(final /*@NonInvalid*/ @NonNull ClassCS lClassCS_1)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lClassCS_1.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lClassCS_1, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof org.eclipse.qvtd.doc.miniocl.Class;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_1) {
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class symbol_2 = (org.eclipse.qvtd.doc.miniocl.Class)ast;
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Class_0 = idResolver.getClass(CLSSid_Class_0, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class oclAsType = (org.eclipse.qvtd.doc.miniocl.@NonNull Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Class_0);
				final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (eq) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<PropertyCS> properties = lClassCS_1.getProperties();
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_properties_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PropertyCS, properties);
					/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Property);
					@NonNull Iterator<Object> ITERATOR__1_0 = BOXED_properties_0.iterator();
					/*@Thrown*/ @NonNull SequenceValue collect_0;
					while (true) {
						if (!ITERATOR__1_0.hasNext()) {
							collect_0 = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull PropertyCS _1_0 = (@NonNull PropertyCS)ITERATOR__1_0.next();
						/**
						 * _'1_'.ast.oclAsType(miniocl::Property)
						 */
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Property_1 = idResolver.getClass(CLSSid_Property, null);
						final /*@NonInvalid*/ @Nullable Element ast_1 = _1_0.getAst();
						@SuppressWarnings("null")
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Property oclAsType_1 = (org.eclipse.qvtd.doc.miniocl.@NonNull Property)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_1, TYP_miniocl_c_c_Property_1);
						//
						accumulator.add(oclAsType_1);
					}
					final /*@Thrown*/ @NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect_0);
					// mapping statements
					final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(org.eclipse.qvtd.doc.miniocl.Property.class, asOrderedSet);
					symbol_2.getOwnedProperties().addAll(ECORE_asOrderedSet);
					final /*@Thrown*/ @Nullable Boolean muClassCS__2__Class__ownedProperties = ValueUtil.TRUE_VALUE;
					symbol_5 = muClassCS__2__Class__ownedProperties;
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
	}

	/**
	 *
	 * map muPackageCS__2__Package__name in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lPackageCS : minioclcs::PackageCS[1];
	 * var ast : miniocl::Element[1] := lPackageCS.ast;
	 * check var ast1 : miniocl::Package[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::Package)
	 *   ;
	 * var name : ecore::EString[?] := lPackageCS.name;
	 * var toString : String[1] := name.toString();
	 * set ast1.name := toString;
	 *
	 */
	protected boolean MAP_muPackageCS__2__Package__name(final /*@NonInvalid*/ @NonNull PackageCS lPackageCS_2)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lPackageCS_2.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lPackageCS_2, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof org.eclipse.qvtd.doc.miniocl.Package;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_1) {
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package symbol_2 = (org.eclipse.qvtd.doc.miniocl.Package)ast;
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package oclAsType = (org.eclipse.qvtd.doc.miniocl.@NonNull Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Package_0);
				final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (eq) {
					final /*@NonInvalid*/ @Nullable String name = lPackageCS_2.getName();
					final /*@Thrown*/ @NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
					// mapping statements
					symbol_2.setName(toString);
					final /*@Thrown*/ @Nullable Boolean muPackageCS__2__Package__name = ValueUtil.TRUE_VALUE;
					symbol_5 = muPackageCS__2__Package__name;
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
	}

	/**
	 *
	 * map muClassCS__2__Class__ownedOperations in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lClassCS : minioclcs::ClassCS[1];
	 * var ast : miniocl::Element[1] := lClassCS.ast;
	 * check var ast1 : miniocl::Class[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::Class)
	 *   ;
	 * var operations : OrderedSet(minioclcs::OperationCS) := lClassCS.operations;
	 * var asOrderedSet : OrderedSet(miniocl::Operation) := operations->collect(_'1_' |
	 *     _'1_'.ast.oclAsType(miniocl::Operation))
	 *   ->asOrderedSet()
	 *   ;
	 * var collect : Sequence(miniocl::Operation) := operations->collect(_'1_' |
	 *     _'1_'.ast.oclAsType(miniocl::Operation));
	 * set ast1.ownedOperations := asOrderedSet;
	 *
	 */
	protected boolean MAP_muClassCS__2__Class__ownedOperations(final /*@NonInvalid*/ @NonNull ClassCS lClassCS_2)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lClassCS_2.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lClassCS_2, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof org.eclipse.qvtd.doc.miniocl.Class;
			/*@Thrown*/ @Nullable Boolean symbol_6;
			if (symbol_1) {
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class symbol_2 = (org.eclipse.qvtd.doc.miniocl.Class)ast;
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Class_0 = idResolver.getClass(CLSSid_Class_0, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class oclAsType = (org.eclipse.qvtd.doc.miniocl.@NonNull Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Class_0);
				final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (eq) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<OperationCS> operations = lClassCS_2.getOperations();
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_operations_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_OperationCS, operations);
					/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
					@NonNull Iterator<Object> ITERATOR__1_0 = BOXED_operations_0.iterator();
					/*@Thrown*/ @NonNull SequenceValue collect_0;
					while (true) {
						if (!ITERATOR__1_0.hasNext()) {
							collect_0 = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull OperationCS _1_0 = (@NonNull OperationCS)ITERATOR__1_0.next();
						/**
						 * _'1_'.ast.oclAsType(miniocl::Operation)
						 */
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Operation_1 = idResolver.getClass(CLSSid_Operation, null);
						final /*@NonInvalid*/ @Nullable Element ast_1 = _1_0.getAst();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull Operation oclAsType_1 = (@NonNull Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_1, TYP_miniocl_c_c_Operation_1);
						//
						accumulator.add(oclAsType_1);
					}
					final /*@Thrown*/ @NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect_0);
					// mapping statements
					final /*@Thrown*/ @NonNull List<Operation> ECORE_asOrderedSet = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Operation.class, asOrderedSet);
					symbol_2.getOwnedOperations().addAll(ECORE_asOrderedSet);
					final /*@Thrown*/ @Nullable Boolean muClassCS__2__Class__ownedOperations = ValueUtil.TRUE_VALUE;
					symbol_5 = muClassCS__2__Class__ownedOperations;
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
	}

	/**
	 *
	 * map mcNameExpCS__2__PropertyCallExp__0 in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * var isPropCallExpWithImplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithImplicitSource()
	 *   ;
	 * check isPropCallExpWithImplicitSource;
	 * var isVariableExp : Boolean[?] := lNameExpCS.isVariableExp()
	 *   ;
	 * var _'not' : Boolean[1] := not isVariableExp;
	 * check _'not';
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource();
	 * var not1 : Boolean[1] := not isPropCallExpWithExplicitSource;
	 * check not1;
	 * new:rightAS rPropertyCallExp : miniocl::PropertyCallExp[1];
	 * notify set lNameExpCS.ast := rPropertyCallExp;
	 *
	 */
	protected boolean MAP_mcNameExpCS__2__PropertyCallExp__0(final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_0)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_0.getRoundedBrackets();
		final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
		/*@NonInvalid*/ @Nullable Boolean and;
		if (eq) {
			/*@Caught*/ @NonNull Object CAUGHT_symbol_0;
			try {
				final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_0);
				final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
				/*@Thrown*/ boolean symbol_0;
				if (eq_0) {
					symbol_0 = ValueUtil.FALSE_VALUE;
				}
				else {
					if (parentCallExpCS == null) {
						throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
					}
					final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
					final /*@Thrown*/ boolean eq_1 = lNameExpCS_0.equals(navExp);
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
			throw throwNull(lNameExpCS_0, "Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_9;
		if (and) {
			/*@Caught*/ @Nullable Object CAUGHT_and_2;
			try {
				/*@Caught*/ @Nullable Object CAUGHT_and_1;
				try {
					final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_0.getRoundedBrackets();
					final /*@NonInvalid*/ boolean eq_2 = roundedBrackets_0 == null;
					/*@NonInvalid*/ @Nullable Boolean and_0;
					if (eq_2) {
						/*@Caught*/ @NonNull Object CAUGHT_symbol_1;
						try {
							final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_0);
							final /*@NonInvalid*/ boolean eq_3 = parentCallExpCS_0 == null;
							/*@Thrown*/ boolean symbol_1;
							if (eq_3) {
								symbol_1 = ValueUtil.FALSE_VALUE;
							}
							else {
								if (parentCallExpCS_0 == null) {
									throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
								}
								final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
								final /*@Thrown*/ boolean eq_4 = lNameExpCS_0.equals(navExp_0);
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
						final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_0.getExpName();
						if (expName == null) {
							throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName.getPathElements();
						final /*@Thrown*/ @NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
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
				final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_0);
				final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
				final /*@Thrown*/ @Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_1, ne);
				CAUGHT_and_2 = and_2;
			}
			catch (Exception e) {
				CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ @Nullable Boolean not_1 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_2);
			final /*@NonInvalid*/ boolean symbol_2 = not_1 != null;
			/*@Thrown*/ @Nullable Boolean raw_not;
			if (symbol_2) {
				if (not_1 == null) {
					throw throwNull(lNameExpCS_0, "Null where non-null value required");
				}
				/*@Thrown*/ @Nullable Boolean symbol_8;
				if (not_1) {
					/*@Caught*/ @NonNull Object CAUGHT_and_3;
					try {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_1 = lNameExpCS_0.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq_6 = roundedBrackets_1 == null;
						/*@Thrown*/ boolean and_3;
						if (eq_6) {
							final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_1 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_0);
							final /*@NonInvalid*/ boolean eq_7 = parentCallExpCS_1 == null;
							/*@Thrown*/ boolean symbol_3;
							if (eq_7) {
								symbol_3 = ValueUtil.FALSE_VALUE;
							}
							else {
								if (parentCallExpCS_1 == null) {
									throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
								}
								final /*@Thrown*/ @Nullable NavigationExpCS navExp_1 = parentCallExpCS_1.getNavExp();
								final /*@Thrown*/ boolean eq_8 = lNameExpCS_0.equals(navExp_1);
								symbol_3 = eq_8;
							}
							and_3 = symbol_3;
						}
						else {
							and_3 = ValueUtil.FALSE_VALUE;
						}
						CAUGHT_and_3 = and_3;
					}
					catch (Exception e) {
						CAUGHT_and_3 = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ @Nullable Boolean not_2 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_3);
					final /*@NonInvalid*/ boolean symbol_4 = not_2 != null;
					/*@Thrown*/ @Nullable Boolean raw_not1;
					if (symbol_4) {
						if (not_2 == null) {
							throw throwNull(lNameExpCS_0, "Null where non-null value required");
						}
						/*@Thrown*/ @Nullable Boolean symbol_7;
						if (not_2) {
							// creations
							final @SuppressWarnings("null")@NonNull PropertyCallExp rPropertyCallExp = MiniOCLFactory.eINSTANCE.createPropertyCallExp();
							models[1/*rightAS*/].add(rPropertyCallExp, false);
							// mapping statements
							lNameExpCS_0.setAst(rPropertyCallExp);
							objectManager.assigned(lNameExpCS_0, MinioclcsPackage.Literals.CS_TRACE__AST, rPropertyCallExp);
							final /*@Thrown*/ @Nullable Boolean mcNameExpCS__2__PropertyCallExp__0 = ValueUtil.TRUE_VALUE;
							symbol_7 = mcNameExpCS__2__PropertyCallExp__0;
						}
						else {
							symbol_7 = ValueUtil.FALSE_VALUE;
						}
						raw_not1 = symbol_7;
					}
					else {
						raw_not1 = ValueUtil.FALSE_VALUE;
					}
					symbol_8 = raw_not1;
				}
				else {
					symbol_8 = ValueUtil.FALSE_VALUE;
				}
				raw_not = symbol_8;
			}
			else {
				raw_not = ValueUtil.FALSE_VALUE;
			}
			symbol_9 = raw_not;
		}
		else {
			symbol_9 = ValueUtil.FALSE_VALUE;
		}
		return symbol_9;
	}

	/**
	 *
	 * map mcNameExpCS__2__VariableExp__1 in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * var isVariableExp : Boolean[?] := lNameExpCS.isVariableExp()
	 *   ;
	 * check isVariableExp;
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource();
	 * var _'not' : Boolean[1] := not isPropCallExpWithExplicitSource;
	 * check _'not';
	 * new:rightAS rVariableExp : miniocl::VariableExp[1];
	 * notify set lNameExpCS.ast := rVariableExp;
	 *
	 */
	protected boolean MAP_mcNameExpCS__2__VariableExp__1(final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_1)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		/*@Caught*/ @Nullable Object CAUGHT_and_0;
		try {
			final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_1.getRoundedBrackets();
			final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
			/*@NonInvalid*/ @Nullable Boolean and;
			if (eq) {
				/*@Caught*/ @NonNull Object CAUGHT_symbol_0;
				try {
					final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_1);
					final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
					/*@Thrown*/ boolean symbol_0;
					if (eq_0) {
						symbol_0 = ValueUtil.FALSE_VALUE;
					}
					else {
						if (parentCallExpCS == null) {
							throw throwNull(lNameExpCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
						}
						final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
						final /*@Thrown*/ boolean eq_1 = lNameExpCS_1.equals(navExp);
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
			/*@Caught*/ @NonNull Object CAUGHT_eq_2;
			try {
				final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_1.getExpName();
				if (expName == null) {
					throw throwNull(lNameExpCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName.getPathElements();
				final /*@Thrown*/ @NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
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
		final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_1);
		final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
		final /*@Thrown*/ @Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_0, ne);
		if (and_1 == null) {
			throw throwNull(lNameExpCS_1, "Null if condition");
		}
		/*@Thrown*/ @Nullable Boolean symbol_6;
		if (and_1) {
			/*@Caught*/ @NonNull Object CAUGHT_and_2;
			try {
				final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_1.getRoundedBrackets();
				final /*@NonInvalid*/ boolean eq_3 = roundedBrackets_0 == null;
				/*@Thrown*/ boolean and_2;
				if (eq_3) {
					final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_1);
					final /*@NonInvalid*/ boolean eq_4 = parentCallExpCS_0 == null;
					/*@Thrown*/ boolean symbol_1;
					if (eq_4) {
						symbol_1 = ValueUtil.FALSE_VALUE;
					}
					else {
						if (parentCallExpCS_0 == null) {
							throw throwNull(lNameExpCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
						}
						final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
						final /*@Thrown*/ boolean eq_5 = lNameExpCS_1.equals(navExp_0);
						symbol_1 = eq_5;
					}
					and_2 = symbol_1;
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
			final /*@NonInvalid*/ boolean symbol_2 = not_0 != null;
			/*@Thrown*/ @Nullable Boolean raw_not;
			if (symbol_2) {
				if (not_0 == null) {
					throw throwNull(lNameExpCS_1, "Null where non-null value required");
				}
				/*@Thrown*/ @Nullable Boolean symbol_5;
				if (not_0) {
					// creations
					final @SuppressWarnings("null")@NonNull VariableExp rVariableExp = MiniOCLFactory.eINSTANCE.createVariableExp();
					models[1/*rightAS*/].add(rVariableExp, false);
					// mapping statements
					lNameExpCS_1.setAst(rVariableExp);
					objectManager.assigned(lNameExpCS_1, MinioclcsPackage.Literals.CS_TRACE__AST, rVariableExp);
					final /*@Thrown*/ @Nullable Boolean mcNameExpCS__2__VariableExp__1 = ValueUtil.TRUE_VALUE;
					symbol_5 = mcNameExpCS__2__VariableExp__1;
				}
				else {
					symbol_5 = ValueUtil.FALSE_VALUE;
				}
				raw_not = symbol_5;
			}
			else {
				raw_not = ValueUtil.FALSE_VALUE;
			}
			symbol_6 = raw_not;
		}
		else {
			symbol_6 = ValueUtil.FALSE_VALUE;
		}
		return symbol_6;
	}

	/**
	 *
	 * map muCallExpCS__ast in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lCallExpCS : minioclcs::CallExpCS[1];
	 * var navExp : minioclcs::NavigationExpCS[?] := lCallExpCS.navExp;
	 * var ast : miniocl::Element[?] := navExp?.ast;
	 * check var ast1 : miniocl::CallExp[?] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::CallExp)
	 *   ;
	 * var oclIsTypeOf : Boolean[1] := lCallExpCS.oclIsTypeOf(minioclcs::CallExpCS);
	 * check oclIsTypeOf;
	 * notify set lCallExpCS.ast := ast1;
	 *
	 */
	protected boolean MAP_muCallExpCS__ast(final /*@NonInvalid*/ @NonNull CallExpCS lCallExpCS)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable NavigationExpCS navExp = lCallExpCS.getNavExp();
		final /*@NonInvalid*/ @NonNull Object ast = navExp == null;
		/*@Thrown*/ @Nullable Element safe_ast_source;
		if (ast == Boolean.TRUE) {
			safe_ast_source = null;
		}
		else {
			assert navExp != null;
			final /*@Thrown*/ @Nullable Element ast_0 = navExp.getAst();
			safe_ast_source = ast_0;
		}
		final /*@NonInvalid*/ boolean symbol_0 = safe_ast_source instanceof CallExp;
		/*@Thrown*/ @Nullable Boolean symbol_6;
		if (symbol_0) {
			final /*@Thrown*/ @Nullable CallExp symbol_1 = (CallExp)safe_ast_source;
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_CallExp_0 = idResolver.getClass(CLSSid_CallExp, null);
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull CallExp oclAsType = (@NonNull CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, safe_ast_source, TYP_miniocl_c_c_CallExp_0);
			final /*@Thrown*/ boolean eq = oclAsType.equals(symbol_1);
			/*@Thrown*/ @Nullable Boolean symbol_5;
			if (eq) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_minioclcs_c_c_CallExpCS_0_0 = idResolver.getClass(CLSSid_CallExpCS, null);
				final /*@NonInvalid*/ boolean oclIsTypeOf = OclAnyOclIsTypeOfOperation.INSTANCE.evaluate(executor, lCallExpCS, TYP_minioclcs_c_c_CallExpCS_0_0).booleanValue();
				/*@Thrown*/ @Nullable Boolean symbol_4;
				if (oclIsTypeOf) {
					// mapping statements
					lCallExpCS.setAst(symbol_1);
					objectManager.assigned(lCallExpCS, MinioclcsPackage.Literals.CS_TRACE__AST, symbol_1);
					final /*@Thrown*/ @Nullable Boolean muCallExpCS__ast = ValueUtil.TRUE_VALUE;
					symbol_4 = muCallExpCS__ast;
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
		return symbol_6;
	}

	/**
	 *
	 * map muNameExpCS__2__PropertyCallExp__1__ownedSource in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * var ast : miniocl::Element[1] := lNameExpCS.ast;
	 * check var ast1 : miniocl::PropertyCallExp[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::PropertyCallExp)
	 *   ;
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * check isPropCallExpWithExplicitSource;
	 * var unsafe : minioclcs::CallExpCS[?] := lNameExpCS.parentAsCallExpCS()
	 *   ;
	 * var source : minioclcs::CallExpCS[?] := unsafe?.source;
	 * var _'if' : minioclcs::CallExpCS[?] := if unsafe = null
	 *   then null
	 *   else source
	 *   endif;
	 * var _'=' : Boolean[1] := unsafe =
	 *   null;
	 * var if1 : miniocl::Element[?] := if _'if' = null
	 *   then null
	 *   else _'if'.ast
	 *   endif;
	 * var _'=1' : Boolean[1] := _'if' =
	 *   null;
	 * var if2 : miniocl::CallExp[?] := if if1 = null
	 *   then null
	 *   else if1.oclAsType(miniocl::CallExp)
	 *   endif;
	 * var _'=2' : Boolean[1] := if1 = null;
	 * notify set ast1.ownedSource := if2;
	 *
	 */
	protected boolean MAP_muNameExpCS__2__PropertyCallExp__1__ownedSource(final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_2)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lNameExpCS_2.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lNameExpCS_2, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof PropertyCallExp;
			/*@Thrown*/ @Nullable Boolean symbol_11;
			if (symbol_1) {
				final /*@Thrown*/ @NonNull PropertyCallExp symbol_2 = (PropertyCallExp)ast;
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_PropertyCallExp_0 = idResolver.getClass(CLSSid_PropertyCallExp, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull PropertyCallExp oclAsType = (@NonNull PropertyCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_PropertyCallExp_0);
				final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
				/*@Thrown*/ @Nullable Boolean symbol_10;
				if (eq) {
					final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_2.getRoundedBrackets();
					final /*@NonInvalid*/ boolean eq_0 = roundedBrackets == null;
					/*@Thrown*/ boolean and;
					if (eq_0) {
						final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_2);
						final /*@NonInvalid*/ boolean eq_1 = parentCallExpCS == null;
						/*@Thrown*/ boolean symbol_3;
						if (eq_1) {
							symbol_3 = ValueUtil.FALSE_VALUE;
						}
						else {
							if (parentCallExpCS == null) {
								throw throwNull(lNameExpCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
							}
							final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
							final /*@Thrown*/ boolean eq_2 = lNameExpCS_2.equals(navExp);
							symbol_3 = eq_2;
						}
						and = symbol_3;
					}
					else {
						and = ValueUtil.FALSE_VALUE;
					}
					/*@Thrown*/ @Nullable Boolean symbol_9;
					if (and) {
						final /*@NonInvalid*/ @Nullable CallExpCS parentAsCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_2);
						final /*@NonInvalid*/ @NonNull Object source = parentAsCallExpCS == null;
						/*@Thrown*/ @Nullable CallExpCS safe_source_source;
						if (source == Boolean.TRUE) {
							safe_source_source = null;
						}
						else {
							assert parentAsCallExpCS != null;
							final /*@Thrown*/ @Nullable CallExpCS source_0 = parentAsCallExpCS.getSource();
							safe_source_source = source_0;
						}
						final /*@NonInvalid*/ boolean eq_4 = parentAsCallExpCS == null;
						/*@Thrown*/ @Nullable CallExpCS symbol_4;
						if (eq_4) {
							symbol_4 = null;
						}
						else {
							symbol_4 = safe_source_source;
						}
						final /*@Thrown*/ boolean eq_6 = symbol_4 == null;
						/*@Thrown*/ @Nullable Element symbol_5;
						if (eq_6) {
							symbol_5 = null;
						}
						else {
							if (symbol_4 == null) {
								throw throwNull(lNameExpCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CSTrace::ast\'");
							}
							final /*@Thrown*/ @Nullable Element ast_0 = symbol_4.getAst();
							symbol_5 = ast_0;
						}
						final /*@Thrown*/ boolean eq_8 = symbol_5 == null;
						/*@Thrown*/ @Nullable CallExp symbol_6;
						if (eq_8) {
							symbol_6 = null;
						}
						else {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_CallExp_0 = idResolver.getClass(CLSSid_CallExp, null);
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull CallExp oclAsType_0 = (@NonNull CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, symbol_5, TYP_miniocl_c_c_CallExp_0);
							symbol_6 = oclAsType_0;
						}
						// mapping statements
						if (symbol_6 == null) {
							throw throwNull(lNameExpCS_2, "Null value for miniocl::CallExp::ownedSource assignment");
						}
						symbol_2.setOwnedSource(symbol_6);
						objectManager.assigned(symbol_2, MiniOCLPackage.Literals.CALL_EXP__OWNED_SOURCE, symbol_6);
						final /*@Thrown*/ @Nullable Boolean muNameExpCS__2__PropertyCallExp__1__ownedSource = ValueUtil.TRUE_VALUE;
						symbol_9 = muNameExpCS__2__PropertyCallExp__1__ownedSource;
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

	/**
	 *
	 * map muParameterCS__2__Parameter__type in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lParameterCS : minioclcs::ParameterCS[1];
	 * var ast : miniocl::Element[1] := lParameterCS.ast;
	 * check var ast1 : miniocl::Parameter[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::Parameter)
	 *   ;
	 * var typeRef : minioclcs::PathNameCS[?] := lParameterCS.typeRef;
	 * var lookupClass : miniocl::Class[?] := ast1.lookupClass(typeRef);
	 * notify set ast1.type := lookupClass;
	 *
	 */
	protected boolean MAP_muParameterCS__2__Parameter__type(final /*@NonInvalid*/ @NonNull ParameterCS lParameterCS_1)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lParameterCS_1.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lParameterCS_1, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof Parameter;
			/*@Thrown*/ @Nullable Boolean symbol_9;
			if (symbol_1) {
				final /*@Thrown*/ @NonNull Parameter symbol_2 = (Parameter)ast;
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Parameter_0 = idResolver.getClass(CLSSid_Parameter, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull Parameter oclAsType = (@NonNull Parameter)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Parameter_0);
				final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
				/*@Thrown*/ @Nullable Boolean symbol_8;
				if (eq) {
					final /*@NonInvalid*/ @Nullable PathNameCS typeRef = lParameterCS_1.getTypeRef();
					if (typeRef == null) {
						throw throwNull(lParameterCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull List<PathElementCS> segments_0 = typeRef.getPathElements();
					final /*@Thrown*/ @NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
					final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
					final /*@Thrown*/ boolean eq_0 = size.equals(INT_1);
					/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_5;
					if (eq_0) {
						final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
						if (aPathElementCS == null) {
							throw throwNull(lParameterCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
						}
						final /*@Thrown*/ @Nullable String cName_0 = aPathElementCS.getElementName();
						final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Class = INSTANCE_OclElement_unqualified_env_Class.evaluate(symbol_2);
						final /*@Thrown*/ @NonNull OrderedSetValue foundClass = INSTANCE_Visitable__lookupClass.evaluate(symbol_2, unqualified_env_Class, cName_0);
						final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
						/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_3;
						if (isEmpty) {
							symbol_3 = null;
						}
						else {
							final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
							symbol_3 = first;
						}
						symbol_5 = symbol_3;
					}
					else {
						final /*@Thrown*/ @NonNull IntegerValue diff = (@Nullable IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
						final /*@Thrown*/ @NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package qualifier = INSTANCE_Visitable_lookupPackage.evaluate(symbol_2, qualifierSegments);
						/*@Caught*/ @Nullable Object CAUGHT_qualifier;
						try {
							CAUGHT_qualifier = qualifier;
						}
						catch (Exception e) {
							CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
						}
						final /*@NonInvalid*/ @NonNull Object lookupQualifiedClass = CAUGHT_qualifier == null;
						/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class safe_lookupQualifiedClass_source;
						if (lookupQualifiedClass == Boolean.TRUE) {
							safe_lookupQualifiedClass_source = null;
						}
						else {
							if (qualifier == null) {
								throw throwNull(lParameterCS_1, "Null where non-null value required");
							}
							final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_0 = (@Nullable PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
							if (aPathElementCS_0 == null) {
								throw throwNull(lParameterCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
							}
							final /*@Thrown*/ @Nullable String cName_1 = aPathElementCS_0.getElementName();
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
							final /*@NonInvalid*/ @NonNull LookupEnvironment env_3 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = qualifier.getOwnedClasses();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull LookupEnvironment addElements = env_3.addElements(ownedClasses);
							final /*@Thrown*/ @NonNull OrderedSetValue foundClass_0 = INSTANCE_Visitable__lookupClass.evaluate(qualifier, addElements, cName_1);
							final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass_0).booleanValue();
							/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_4;
							if (isEmpty_0) {
								symbol_4 = null;
							}
							else {
								final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
								symbol_4 = first_0;
							}
							safe_lookupQualifiedClass_source = symbol_4;
						}
						symbol_5 = safe_lookupQualifiedClass_source;
					}
					// mapping statements
					if (symbol_5 == null) {
						throw throwNull(lParameterCS_1, "Null value for miniocl::TypedElement::type assignment");
					}
					symbol_2.setType(symbol_5);
					objectManager.assigned(symbol_2, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, symbol_5);
					final /*@Thrown*/ @Nullable Boolean muParameterCS__2__Parameter__type = ValueUtil.TRUE_VALUE;
					symbol_8 = muParameterCS__2__Parameter__type;
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

	/**
	 *
	 * map muNameExpCS__2__PropertyCallExp__0__ownedSource in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * var ast : miniocl::Element[1] := lNameExpCS.ast;
	 * check var ast1 : miniocl::PropertyCallExp[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::PropertyCallExp)
	 *   ;
	 * var isPropCallExpWithImplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithImplicitSource()
	 *   ;
	 * check isPropCallExpWithImplicitSource;
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * var _'not' : Boolean[1] := not isPropCallExpWithExplicitSource;
	 * check _'not';
	 * var isVariableExp : Boolean[?] := lNameExpCS.isVariableExp()
	 *   ;
	 * var not1 : Boolean[1] := not isVariableExp;
	 * check not1;
	 * var referredVar : miniocl::Variable[?] := ast1.lookupVariable('self')
	 *   ;
	 * observe miniocl::TypedElement::type var type : miniocl::Class[?] := referredVar?.type;
	 * var shadow : miniocl::VariableExp[1] := miniocl::VariableExp{referredVariable = referredVar, type = type
	 *   };
	 * notify set ast1.ownedSource := shadow;
	 *
	 */
	protected class MAP_muNameExpCS__2__PropertyCallExp__0__ownedSource extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_3;

		public MAP_muNameExpCS__2__PropertyCallExp__0__ownedSource(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_3 = (@NonNull NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Element ast = lNameExpCS_3.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = ast != null;
			/*@Thrown*/ @Nullable Boolean raw_ast;
			if (symbol_0) {
				if (ast == null) {
					throw throwNull(lNameExpCS_3, "Null where non-null value required");
				}
				final /*@NonInvalid*/ boolean symbol_1 = ast instanceof PropertyCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_18;
				if (symbol_1) {
					final /*@Thrown*/ @NonNull PropertyCallExp symbol_2 = (PropertyCallExp)ast;
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_PropertyCallExp_0 = idResolver.getClass(CLSSid_PropertyCallExp, null);
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull PropertyCallExp oclAsType = (@NonNull PropertyCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_PropertyCallExp_0);
					final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
					/*@Thrown*/ @Nullable Boolean symbol_17;
					if (eq) {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_3.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq_0 = roundedBrackets == null;
						/*@NonInvalid*/ @Nullable Boolean and;
						if (eq_0) {
							/*@Caught*/ @NonNull Object CAUGHT_symbol_3;
							try {
								final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_3);
								final /*@NonInvalid*/ boolean eq_1 = parentCallExpCS == null;
								/*@Thrown*/ boolean symbol_3;
								if (eq_1) {
									symbol_3 = ValueUtil.FALSE_VALUE;
								}
								else {
									if (parentCallExpCS == null) {
										throw throwNull(lNameExpCS_3, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
									}
									final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
									final /*@Thrown*/ boolean eq_2 = lNameExpCS_3.equals(navExp);
									symbol_3 = eq_2;
								}
								CAUGHT_symbol_3 = symbol_3;
							}
							catch (Exception e) {
								CAUGHT_symbol_3 = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_3);
							and = not;
						}
						else {
							and = ValueUtil.FALSE_VALUE;
						}
						if (and == null) {
							throw throwNull(lNameExpCS_3, "Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_16;
						if (and) {
							/*@Caught*/ @NonNull Object CAUGHT_and_0;
							try {
								final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_3.getRoundedBrackets();
								final /*@NonInvalid*/ boolean eq_3 = roundedBrackets_0 == null;
								/*@Thrown*/ boolean and_0;
								if (eq_3) {
									final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_3);
									final /*@NonInvalid*/ boolean eq_4 = parentCallExpCS_0 == null;
									/*@Thrown*/ boolean symbol_4;
									if (eq_4) {
										symbol_4 = ValueUtil.FALSE_VALUE;
									}
									else {
										if (parentCallExpCS_0 == null) {
											throw throwNull(lNameExpCS_3, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
										}
										final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
										final /*@Thrown*/ boolean eq_5 = lNameExpCS_3.equals(navExp_0);
										symbol_4 = eq_5;
									}
									and_0 = symbol_4;
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
							final /*@NonInvalid*/ boolean symbol_5 = not_0 != null;
							/*@Thrown*/ @Nullable Boolean raw_not;
							if (symbol_5) {
								if (not_0 == null) {
									throw throwNull(lNameExpCS_3, "Null where non-null value required");
								}
								/*@Thrown*/ @Nullable Boolean symbol_15;
								if (not_0) {
									/*@Caught*/ @Nullable Object CAUGHT_and_3;
									try {
										/*@Caught*/ @Nullable Object CAUGHT_and_2;
										try {
											final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_1 = lNameExpCS_3.getRoundedBrackets();
											final /*@NonInvalid*/ boolean eq_6 = roundedBrackets_1 == null;
											/*@NonInvalid*/ @Nullable Boolean and_1;
											if (eq_6) {
												/*@Caught*/ @NonNull Object CAUGHT_symbol_6;
												try {
													final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_1 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_3);
													final /*@NonInvalid*/ boolean eq_7 = parentCallExpCS_1 == null;
													/*@Thrown*/ boolean symbol_6;
													if (eq_7) {
														symbol_6 = ValueUtil.FALSE_VALUE;
													}
													else {
														if (parentCallExpCS_1 == null) {
															throw throwNull(lNameExpCS_3, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
														}
														final /*@Thrown*/ @Nullable NavigationExpCS navExp_1 = parentCallExpCS_1.getNavExp();
														final /*@Thrown*/ boolean eq_8 = lNameExpCS_3.equals(navExp_1);
														symbol_6 = eq_8;
													}
													CAUGHT_symbol_6 = symbol_6;
												}
												catch (Exception e) {
													CAUGHT_symbol_6 = ValueUtil.createInvalidValue(e);
												}
												final /*@NonInvalid*/ @Nullable Boolean not_1 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_6);
												and_1 = not_1;
											}
											else {
												and_1 = ValueUtil.FALSE_VALUE;
											}
											/*@Caught*/ @NonNull Object CAUGHT_eq_9;
											try {
												final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_3.getExpName();
												if (expName == null) {
													throw throwNull(lNameExpCS_3, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
												}
												@SuppressWarnings("null")
												final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName.getPathElements();
												final /*@Thrown*/ @NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
												final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
												final /*@Thrown*/ boolean eq_9 = size.equals(INT_1);
												CAUGHT_eq_9 = eq_9;
											}
											catch (Exception e) {
												CAUGHT_eq_9 = ValueUtil.createInvalidValue(e);
											}
											final /*@Thrown*/ @Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(and_1, CAUGHT_eq_9);
											CAUGHT_and_2 = and_2;
										}
										catch (Exception e) {
											CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
										}
										final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_3);
										final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
										final /*@Thrown*/ @Nullable Boolean and_3 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_2, ne);
										CAUGHT_and_3 = and_3;
									}
									catch (Exception e) {
										CAUGHT_and_3 = ValueUtil.createInvalidValue(e);
									}
									final /*@NonInvalid*/ @Nullable Boolean not_2 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_3);
									final /*@NonInvalid*/ boolean symbol_7 = not_2 != null;
									/*@Thrown*/ @Nullable Boolean raw_not1;
									if (symbol_7) {
										if (not_2 == null) {
											throw throwNull(lNameExpCS_3, "Null where non-null value required");
										}
										/*@Thrown*/ @Nullable Boolean symbol_14;
										if (not_2) {
											final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Variable = INSTANCE_OclElement_unqualified_env_Variable.evaluate(symbol_2);
											final /*@Thrown*/ @NonNull OrderedSetValue foundVariable = INSTANCE_Visitable__lookupVariable.evaluate(symbol_2, unqualified_env_Variable, STR_self);
											final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundVariable).booleanValue();
											/*@Thrown*/ @Nullable Variable symbol_8;
											if (isEmpty) {
												symbol_8 = null;
											}
											else {
												final /*@Thrown*/ @Nullable Variable first = (@Nullable Variable)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundVariable);
												symbol_8 = first;
											}
											/*@Caught*/ @Nullable Object CAUGHT_symbol_8;
											try {
												CAUGHT_symbol_8 = symbol_8;
											}
											catch (Exception e) {
												CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
											}
											final /*@NonInvalid*/ @NonNull Object type = CAUGHT_symbol_8 == null;
											/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class safe_type_source;
											if (type == Boolean.TRUE) {
												safe_type_source = null;
											}
											else {
												assert symbol_8 != null;
												objectManager.getting(symbol_8, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, false);
												@SuppressWarnings("null")
												final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type_0 = symbol_8.getType();
												safe_type_source = type_0;
											}
											final /*@NonInvalid*/ @NonNull Property CTORid_referredVariable = idResolver.getProperty(PROPid_referredVariable);
											final /*@NonInvalid*/ @NonNull Property CTORid_type = idResolver.getProperty(PROPid_type);
											final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_VariableExp_0 = idResolver.getClass(CLSSid_VariableExp, null);
											final /*@Thrown*/ @NonNull VariableExp symbol_11 = (@NonNull VariableExp)TYP_miniocl_c_c_VariableExp_0.createInstance();
											CTORid_referredVariable.initValue(symbol_11, symbol_8);
											CTORid_type.initValue(symbol_11, safe_type_source);
											// mapping statements
											symbol_2.setOwnedSource(symbol_11);
											objectManager.assigned(symbol_2, MiniOCLPackage.Literals.CALL_EXP__OWNED_SOURCE, symbol_11);
											final /*@Thrown*/ @Nullable Boolean muNameExpCS__2__PropertyCallExp__0__ownedSource = ValueUtil.TRUE_VALUE;
											symbol_14 = muNameExpCS__2__PropertyCallExp__0__ownedSource;
										}
										else {
											symbol_14 = ValueUtil.FALSE_VALUE;
										}
										raw_not1 = symbol_14;
									}
									else {
										raw_not1 = ValueUtil.FALSE_VALUE;
									}
									symbol_15 = raw_not1;
								}
								else {
									symbol_15 = ValueUtil.FALSE_VALUE;
								}
								raw_not = symbol_15;
							}
							else {
								raw_not = ValueUtil.FALSE_VALUE;
							}
							symbol_16 = raw_not;
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
			return idResolver.oclEquals(lNameExpCS_3, thoseValues[0]);
		}
	}

	/**
	 *
	 * map muNameExpCS__2__VariableExp__1__referredVariable in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * var ast : miniocl::Element[1] := lNameExpCS.ast;
	 * check var ast1 : miniocl::VariableExp[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::VariableExp)
	 *   ;
	 * var isVariableExp : Boolean[?] := lNameExpCS.isVariableExp()
	 *   ;
	 * check isVariableExp;
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * var _'not' : Boolean[1] := not isPropCallExpWithExplicitSource;
	 * check _'not';
	 * var expName : minioclcs::PathNameCS[?] := lNameExpCS.expName;
	 * var pathElements : OrderedSet(minioclcs::PathElementCS)[?] := expName?.pathElements;
	 * var lookupVariable : miniocl::Variable[?] := ast1.lookupVariable(
	 *     pathElements->first())
	 *   ;
	 * var first : minioclcs::PathElementCS[1] := pathElements->first();
	 * set ast1.referredVariable := lookupVariable;
	 *
	 */
	protected boolean MAP_muNameExpCS__2__VariableExp__1__referredVariable(final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_4)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lNameExpCS_4.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lNameExpCS_4, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof VariableExp;
			/*@Thrown*/ @Nullable Boolean symbol_12;
			if (symbol_1) {
				final /*@Thrown*/ @NonNull VariableExp symbol_2 = (VariableExp)ast;
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_VariableExp_0 = idResolver.getClass(CLSSid_VariableExp, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull VariableExp oclAsType = (@NonNull VariableExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_VariableExp_0);
				final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
				/*@Thrown*/ @Nullable Boolean symbol_11;
				if (eq) {
					/*@Caught*/ @Nullable Object CAUGHT_and_0;
					try {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_4.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq_0 = roundedBrackets == null;
						/*@NonInvalid*/ @Nullable Boolean and;
						if (eq_0) {
							/*@Caught*/ @NonNull Object CAUGHT_symbol_3;
							try {
								final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_4);
								final /*@NonInvalid*/ boolean eq_1 = parentCallExpCS == null;
								/*@Thrown*/ boolean symbol_3;
								if (eq_1) {
									symbol_3 = ValueUtil.FALSE_VALUE;
								}
								else {
									if (parentCallExpCS == null) {
										throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
									}
									final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
									final /*@Thrown*/ boolean eq_2 = lNameExpCS_4.equals(navExp);
									symbol_3 = eq_2;
								}
								CAUGHT_symbol_3 = symbol_3;
							}
							catch (Exception e) {
								CAUGHT_symbol_3 = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_3);
							and = not;
						}
						else {
							and = ValueUtil.FALSE_VALUE;
						}
						/*@Caught*/ @NonNull Object CAUGHT_eq_3;
						try {
							final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_4.getExpName();
							if (expName == null) {
								throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName.getPathElements();
							final /*@Thrown*/ @NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
							final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
							final /*@Thrown*/ boolean eq_3 = size.equals(INT_1);
							CAUGHT_eq_3 = eq_3;
						}
						catch (Exception e) {
							CAUGHT_eq_3 = ValueUtil.createInvalidValue(e);
						}
						final /*@Thrown*/ @Nullable Boolean and_0 = BooleanAndOperation.INSTANCE.evaluate(and, CAUGHT_eq_3);
						CAUGHT_and_0 = and_0;
					}
					catch (Exception e) {
						CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_4);
					final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
					final /*@Thrown*/ @Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_0, ne);
					if (and_1 == null) {
						throw throwNull(lNameExpCS_4, "Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_10;
					if (and_1) {
						/*@Caught*/ @NonNull Object CAUGHT_and_2;
						try {
							final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_4.getRoundedBrackets();
							final /*@NonInvalid*/ boolean eq_4 = roundedBrackets_0 == null;
							/*@Thrown*/ boolean and_2;
							if (eq_4) {
								final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_4);
								final /*@NonInvalid*/ boolean eq_5 = parentCallExpCS_0 == null;
								/*@Thrown*/ boolean symbol_4;
								if (eq_5) {
									symbol_4 = ValueUtil.FALSE_VALUE;
								}
								else {
									if (parentCallExpCS_0 == null) {
										throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
									}
									final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
									final /*@Thrown*/ boolean eq_6 = lNameExpCS_4.equals(navExp_0);
									symbol_4 = eq_6;
								}
								and_2 = symbol_4;
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
						final /*@NonInvalid*/ boolean symbol_5 = not_0 != null;
						/*@Thrown*/ @Nullable Boolean raw_not;
						if (symbol_5) {
							if (not_0 == null) {
								throw throwNull(lNameExpCS_4, "Null where non-null value required");
							}
							/*@Thrown*/ @Nullable Boolean symbol_9;
							if (not_0) {
								final /*@NonInvalid*/ @Nullable PathNameCS expName_0 = lNameExpCS_4.getExpName();
								final /*@NonInvalid*/ @NonNull Object pathElements_0 = expName_0 == null;
								/*@Thrown*/ @Nullable OrderedSetValue safe_pathElements_source;
								if (pathElements_0 == Boolean.TRUE) {
									safe_pathElements_source = null;
								}
								else {
									assert expName_0 != null;
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull List<PathElementCS> pathElements_1 = expName_0.getPathElements();
									final /*@Thrown*/ @NonNull OrderedSetValue BOXED_pathElements_1 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements_1);
									safe_pathElements_source = BOXED_pathElements_1;
								}
								final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(safe_pathElements_source);
								if (aPathElementCS == null) {
									throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
								}
								final /*@Thrown*/ @Nullable String vName_0 = aPathElementCS.getElementName();
								final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Variable = INSTANCE_OclElement_unqualified_env_Variable.evaluate(symbol_2);
								final /*@Thrown*/ @NonNull OrderedSetValue foundVariable = INSTANCE_Visitable__lookupVariable.evaluate(symbol_2, unqualified_env_Variable, vName_0);
								final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundVariable).booleanValue();
								/*@Thrown*/ @Nullable Variable symbol_6;
								if (isEmpty) {
									symbol_6 = null;
								}
								else {
									final /*@Thrown*/ @Nullable Variable first = (@Nullable Variable)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundVariable);
									symbol_6 = first;
								}
								final /*@Thrown*/ @Nullable PathElementCS first_0 = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(safe_pathElements_source);
								if (first_0 == null) {
									throw throwNull(lNameExpCS_4, "Null where non-null value required");
								}
								// mapping statements
								if (symbol_6 == null) {
									throw throwNull(lNameExpCS_4, "Null value for miniocl::VariableExp::referredVariable assignment");
								}
								symbol_2.setReferredVariable(symbol_6);
								final /*@Thrown*/ @Nullable Boolean muNameExpCS__2__VariableExp__1__referredVariable = ValueUtil.TRUE_VALUE;
								symbol_9 = muNameExpCS__2__VariableExp__1__referredVariable;
							}
							else {
								symbol_9 = ValueUtil.FALSE_VALUE;
							}
							raw_not = symbol_9;
						}
						else {
							raw_not = ValueUtil.FALSE_VALUE;
						}
						symbol_10 = raw_not;
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
	}

	/**
	 *
	 * map muPropertyCS__2__Property__type in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lPropertyCS : minioclcs::PropertyCS[1];
	 * var ast : miniocl::Element[1] := lPropertyCS.ast;
	 * check var ast1 : miniocl::Property[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::Property)
	 *   ;
	 * var typeRef : minioclcs::PathNameCS[?] := lPropertyCS.typeRef;
	 * var lookupClass : miniocl::Class[?] := ast1.lookupClass(typeRef);
	 * set ast1.type := lookupClass;
	 *
	 */
	protected boolean MAP_muPropertyCS__2__Property__type(final /*@NonInvalid*/ @NonNull PropertyCS lPropertyCS_1)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lPropertyCS_1.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lPropertyCS_1, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof org.eclipse.qvtd.doc.miniocl.Property;
			/*@Thrown*/ @Nullable Boolean symbol_9;
			if (symbol_1) {
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Property symbol_2 = (org.eclipse.qvtd.doc.miniocl.Property)ast;
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Property_0 = idResolver.getClass(CLSSid_Property, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Property oclAsType = (org.eclipse.qvtd.doc.miniocl.@NonNull Property)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Property_0);
				final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
				/*@Thrown*/ @Nullable Boolean symbol_8;
				if (eq) {
					final /*@NonInvalid*/ @Nullable PathNameCS typeRef = lPropertyCS_1.getTypeRef();
					if (typeRef == null) {
						throw throwNull(lPropertyCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull List<PathElementCS> segments_0 = typeRef.getPathElements();
					final /*@Thrown*/ @NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
					final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
					final /*@Thrown*/ boolean eq_0 = size.equals(INT_1);
					/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_5;
					if (eq_0) {
						final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
						if (aPathElementCS == null) {
							throw throwNull(lPropertyCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
						}
						final /*@Thrown*/ @Nullable String cName_0 = aPathElementCS.getElementName();
						final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Class = INSTANCE_OclElement_unqualified_env_Class.evaluate(symbol_2);
						final /*@Thrown*/ @NonNull OrderedSetValue foundClass = INSTANCE_Visitable__lookupClass.evaluate(symbol_2, unqualified_env_Class, cName_0);
						final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
						/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_3;
						if (isEmpty) {
							symbol_3 = null;
						}
						else {
							final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
							symbol_3 = first;
						}
						symbol_5 = symbol_3;
					}
					else {
						final /*@Thrown*/ @NonNull IntegerValue diff = (@Nullable IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
						final /*@Thrown*/ @NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package qualifier = INSTANCE_Visitable_lookupPackage.evaluate(symbol_2, qualifierSegments);
						/*@Caught*/ @Nullable Object CAUGHT_qualifier;
						try {
							CAUGHT_qualifier = qualifier;
						}
						catch (Exception e) {
							CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
						}
						final /*@NonInvalid*/ @NonNull Object lookupQualifiedClass = CAUGHT_qualifier == null;
						/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class safe_lookupQualifiedClass_source;
						if (lookupQualifiedClass == Boolean.TRUE) {
							safe_lookupQualifiedClass_source = null;
						}
						else {
							if (qualifier == null) {
								throw throwNull(lPropertyCS_1, "Null where non-null value required");
							}
							final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_0 = (@Nullable PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
							if (aPathElementCS_0 == null) {
								throw throwNull(lPropertyCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
							}
							final /*@Thrown*/ @Nullable String cName_1 = aPathElementCS_0.getElementName();
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
							final /*@NonInvalid*/ @NonNull LookupEnvironment env_3 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = qualifier.getOwnedClasses();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull LookupEnvironment addElements = env_3.addElements(ownedClasses);
							final /*@Thrown*/ @NonNull OrderedSetValue foundClass_0 = INSTANCE_Visitable__lookupClass.evaluate(qualifier, addElements, cName_1);
							final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass_0).booleanValue();
							/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_4;
							if (isEmpty_0) {
								symbol_4 = null;
							}
							else {
								final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
								symbol_4 = first_0;
							}
							safe_lookupQualifiedClass_source = symbol_4;
						}
						symbol_5 = safe_lookupQualifiedClass_source;
					}
					// mapping statements
					if (symbol_5 == null) {
						throw throwNull(lPropertyCS_1, "Null value for miniocl::TypedElement::type assignment");
					}
					symbol_2.setType(symbol_5);
					final /*@Thrown*/ @Nullable Boolean muPropertyCS__2__Property__type = ValueUtil.TRUE_VALUE;
					symbol_8 = muPropertyCS__2__Property__type;
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

	/**
	 *
	 * map muOperationCS__2__Operation__type in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lOperationCS : minioclcs::OperationCS[1];
	 * var ast : miniocl::Element[1] := lOperationCS.ast;
	 * check var ast1 : miniocl::Operation[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::Operation)
	 *   ;
	 * var resultRef : minioclcs::PathNameCS[?] := lOperationCS.resultRef;
	 * var lookupClass : miniocl::Class[?] := ast1.lookupClass(resultRef);
	 * set ast1.type := lookupClass;
	 *
	 */
	protected boolean MAP_muOperationCS__2__Operation__type(final /*@NonInvalid*/ @NonNull OperationCS lOperationCS_2)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lOperationCS_2.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lOperationCS_2, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof Operation;
			/*@Thrown*/ @Nullable Boolean symbol_9;
			if (symbol_1) {
				final /*@Thrown*/ @NonNull Operation symbol_2 = (Operation)ast;
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull Operation oclAsType = (@NonNull Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Operation_0);
				final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
				/*@Thrown*/ @Nullable Boolean symbol_8;
				if (eq) {
					final /*@NonInvalid*/ @Nullable PathNameCS resultRef = lOperationCS_2.getResultRef();
					if (resultRef == null) {
						throw throwNull(lOperationCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull List<PathElementCS> segments_0 = resultRef.getPathElements();
					final /*@Thrown*/ @NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
					final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
					final /*@Thrown*/ boolean eq_0 = size.equals(INT_1);
					/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_5;
					if (eq_0) {
						final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
						if (aPathElementCS == null) {
							throw throwNull(lOperationCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
						}
						final /*@Thrown*/ @Nullable String cName_0 = aPathElementCS.getElementName();
						final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Class = INSTANCE_OclElement_unqualified_env_Class.evaluate(symbol_2);
						final /*@Thrown*/ @NonNull OrderedSetValue foundClass = INSTANCE_Visitable__lookupClass.evaluate(symbol_2, unqualified_env_Class, cName_0);
						final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
						/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_3;
						if (isEmpty) {
							symbol_3 = null;
						}
						else {
							final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
							symbol_3 = first;
						}
						symbol_5 = symbol_3;
					}
					else {
						final /*@Thrown*/ @NonNull IntegerValue diff = (@Nullable IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
						final /*@Thrown*/ @NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package qualifier = INSTANCE_Visitable_lookupPackage.evaluate(symbol_2, qualifierSegments);
						/*@Caught*/ @Nullable Object CAUGHT_qualifier;
						try {
							CAUGHT_qualifier = qualifier;
						}
						catch (Exception e) {
							CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
						}
						final /*@NonInvalid*/ @NonNull Object lookupQualifiedClass = CAUGHT_qualifier == null;
						/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class safe_lookupQualifiedClass_source;
						if (lookupQualifiedClass == Boolean.TRUE) {
							safe_lookupQualifiedClass_source = null;
						}
						else {
							if (qualifier == null) {
								throw throwNull(lOperationCS_2, "Null where non-null value required");
							}
							final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_0 = (@Nullable PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
							if (aPathElementCS_0 == null) {
								throw throwNull(lOperationCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
							}
							final /*@Thrown*/ @Nullable String cName_1 = aPathElementCS_0.getElementName();
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
							final /*@NonInvalid*/ @NonNull LookupEnvironment env_3 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = qualifier.getOwnedClasses();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull LookupEnvironment addElements = env_3.addElements(ownedClasses);
							final /*@Thrown*/ @NonNull OrderedSetValue foundClass_0 = INSTANCE_Visitable__lookupClass.evaluate(qualifier, addElements, cName_1);
							final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass_0).booleanValue();
							/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_4;
							if (isEmpty_0) {
								symbol_4 = null;
							}
							else {
								final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
								symbol_4 = first_0;
							}
							safe_lookupQualifiedClass_source = symbol_4;
						}
						symbol_5 = safe_lookupQualifiedClass_source;
					}
					// mapping statements
					if (symbol_5 == null) {
						throw throwNull(lOperationCS_2, "Null value for miniocl::TypedElement::type assignment");
					}
					symbol_2.setType(symbol_5);
					final /*@Thrown*/ @Nullable Boolean muOperationCS__2__Operation__type = ValueUtil.TRUE_VALUE;
					symbol_8 = muOperationCS__2__Operation__type;
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

	/**
	 *
	 * map muNameExpCS__2__VariableExp__1__type in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * var ast : miniocl::Element[1] := lNameExpCS.ast;
	 * check var ast1 : miniocl::VariableExp[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::VariableExp)
	 *   ;
	 * var isVariableExp : Boolean[?] := lNameExpCS.isVariableExp()
	 *   ;
	 * check isVariableExp;
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource();
	 * var _'not' : Boolean[1] := not isPropCallExpWithExplicitSource;
	 * check _'not';
	 * var referredVariable : miniocl::Variable[1] := ast1.referredVariable;
	 * var type : miniocl::Class[1] := referredVariable.type;
	 * notify set ast1.type := type;
	 *
	 */
	protected boolean MAP_muNameExpCS__2__VariableExp__1__type(final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_5)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lNameExpCS_5.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lNameExpCS_5, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof VariableExp;
			/*@Thrown*/ @Nullable Boolean symbol_11;
			if (symbol_1) {
				final /*@Thrown*/ @NonNull VariableExp symbol_2 = (VariableExp)ast;
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_VariableExp_0 = idResolver.getClass(CLSSid_VariableExp, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull VariableExp oclAsType = (@NonNull VariableExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_VariableExp_0);
				final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
				/*@Thrown*/ @Nullable Boolean symbol_10;
				if (eq) {
					/*@Caught*/ @Nullable Object CAUGHT_and_0;
					try {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_5.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq_0 = roundedBrackets == null;
						/*@NonInvalid*/ @Nullable Boolean and;
						if (eq_0) {
							/*@Caught*/ @NonNull Object CAUGHT_symbol_3;
							try {
								final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_5);
								final /*@NonInvalid*/ boolean eq_1 = parentCallExpCS == null;
								/*@Thrown*/ boolean symbol_3;
								if (eq_1) {
									symbol_3 = ValueUtil.FALSE_VALUE;
								}
								else {
									if (parentCallExpCS == null) {
										throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
									}
									final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
									final /*@Thrown*/ boolean eq_2 = lNameExpCS_5.equals(navExp);
									symbol_3 = eq_2;
								}
								CAUGHT_symbol_3 = symbol_3;
							}
							catch (Exception e) {
								CAUGHT_symbol_3 = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_3);
							and = not;
						}
						else {
							and = ValueUtil.FALSE_VALUE;
						}
						/*@Caught*/ @NonNull Object CAUGHT_eq_3;
						try {
							final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_5.getExpName();
							if (expName == null) {
								throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName.getPathElements();
							final /*@Thrown*/ @NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
							final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
							final /*@Thrown*/ boolean eq_3 = size.equals(INT_1);
							CAUGHT_eq_3 = eq_3;
						}
						catch (Exception e) {
							CAUGHT_eq_3 = ValueUtil.createInvalidValue(e);
						}
						final /*@Thrown*/ @Nullable Boolean and_0 = BooleanAndOperation.INSTANCE.evaluate(and, CAUGHT_eq_3);
						CAUGHT_and_0 = and_0;
					}
					catch (Exception e) {
						CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_5);
					final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
					final /*@Thrown*/ @Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_0, ne);
					if (and_1 == null) {
						throw throwNull(lNameExpCS_5, "Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean symbol_9;
					if (and_1) {
						/*@Caught*/ @NonNull Object CAUGHT_and_2;
						try {
							final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_5.getRoundedBrackets();
							final /*@NonInvalid*/ boolean eq_4 = roundedBrackets_0 == null;
							/*@Thrown*/ boolean and_2;
							if (eq_4) {
								final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_5);
								final /*@NonInvalid*/ boolean eq_5 = parentCallExpCS_0 == null;
								/*@Thrown*/ boolean symbol_4;
								if (eq_5) {
									symbol_4 = ValueUtil.FALSE_VALUE;
								}
								else {
									if (parentCallExpCS_0 == null) {
										throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
									}
									final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
									final /*@Thrown*/ boolean eq_6 = lNameExpCS_5.equals(navExp_0);
									symbol_4 = eq_6;
								}
								and_2 = symbol_4;
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
						final /*@NonInvalid*/ boolean symbol_5 = not_0 != null;
						/*@Thrown*/ @Nullable Boolean raw_not;
						if (symbol_5) {
							if (not_0 == null) {
								throw throwNull(lNameExpCS_5, "Null where non-null value required");
							}
							/*@Thrown*/ @Nullable Boolean symbol_8;
							if (not_0) {
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull Variable referredVariable = symbol_2.getReferredVariable();
								@SuppressWarnings("null")
								final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type = referredVariable.getType();
								// mapping statements
								symbol_2.setType(type);
								objectManager.assigned(symbol_2, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, type);
								final /*@Thrown*/ @Nullable Boolean muNameExpCS__2__VariableExp__1__type = ValueUtil.TRUE_VALUE;
								symbol_8 = muNameExpCS__2__VariableExp__1__type;
							}
							else {
								symbol_8 = ValueUtil.FALSE_VALUE;
							}
							raw_not = symbol_8;
						}
						else {
							raw_not = ValueUtil.FALSE_VALUE;
						}
						symbol_9 = raw_not;
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

	/**
	 *
	 * map muNameExpCS__2__PropertyCallExp__0__referredPropert in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * var ast : miniocl::Element[1] := lNameExpCS.ast;
	 * check var ast1 : miniocl::PropertyCallExp[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::PropertyCallExp)
	 *   ;
	 * var isPropCallExpWithImplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithImplicitSource()
	 *   ;
	 * check isPropCallExpWithImplicitSource;
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * var _'not' : Boolean[1] := not isPropCallExpWithExplicitSource;
	 * check _'not';
	 * var isVariableExp : Boolean[?] := lNameExpCS.isVariableExp()
	 *   ;
	 * var not1 : Boolean[1] := not isVariableExp;
	 * check not1;
	 * var ownedSource : miniocl::OCLExpression[1] := ast1.ownedSource;
	 * observe miniocl::TypedElement::type var type : miniocl::Class[1] := ownedSource.type;
	 * var expName : minioclcs::PathNameCS[?] := lNameExpCS.expName;
	 * var lookupPropertyFrom : miniocl::Property[?] := ast1.lookupPropertyFrom(type, expName);
	 * notify set ast1.referredProperty := lookupPropertyFrom;
	 *
	 */
	protected class MAP_muNameExpCS__2__PropertyCallExp__0__referredPropert extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_6;

		public MAP_muNameExpCS__2__PropertyCallExp__0__referredPropert(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_6 = (@NonNull NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
			final /*@NonInvalid*/ @Nullable Element ast = lNameExpCS_6.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = ast != null;
			/*@Thrown*/ @Nullable Boolean raw_ast;
			if (symbol_0) {
				if (ast == null) {
					throw throwNull(lNameExpCS_6, "Null where non-null value required");
				}
				final /*@NonInvalid*/ boolean symbol_1 = ast instanceof PropertyCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_21;
				if (symbol_1) {
					final /*@Thrown*/ @NonNull PropertyCallExp symbol_2 = (PropertyCallExp)ast;
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_PropertyCallExp_0 = idResolver.getClass(CLSSid_PropertyCallExp, null);
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull PropertyCallExp oclAsType = (@NonNull PropertyCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_PropertyCallExp_0);
					final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
					/*@Thrown*/ @Nullable Boolean symbol_20;
					if (eq) {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_6.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq_0 = roundedBrackets == null;
						/*@NonInvalid*/ @Nullable Boolean and;
						if (eq_0) {
							/*@Caught*/ @NonNull Object CAUGHT_symbol_3;
							try {
								final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_6);
								final /*@NonInvalid*/ boolean eq_1 = parentCallExpCS == null;
								/*@Thrown*/ boolean symbol_3;
								if (eq_1) {
									symbol_3 = ValueUtil.FALSE_VALUE;
								}
								else {
									if (parentCallExpCS == null) {
										throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
									}
									final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
									final /*@Thrown*/ boolean eq_2 = lNameExpCS_6.equals(navExp);
									symbol_3 = eq_2;
								}
								CAUGHT_symbol_3 = symbol_3;
							}
							catch (Exception e) {
								CAUGHT_symbol_3 = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_3);
							and = not;
						}
						else {
							and = ValueUtil.FALSE_VALUE;
						}
						if (and == null) {
							throw throwNull(lNameExpCS_6, "Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_19;
						if (and) {
							/*@Caught*/ @NonNull Object CAUGHT_and_0;
							try {
								final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_6.getRoundedBrackets();
								final /*@NonInvalid*/ boolean eq_3 = roundedBrackets_0 == null;
								/*@Thrown*/ boolean and_0;
								if (eq_3) {
									final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_6);
									final /*@NonInvalid*/ boolean eq_4 = parentCallExpCS_0 == null;
									/*@Thrown*/ boolean symbol_4;
									if (eq_4) {
										symbol_4 = ValueUtil.FALSE_VALUE;
									}
									else {
										if (parentCallExpCS_0 == null) {
											throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
										}
										final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
										final /*@Thrown*/ boolean eq_5 = lNameExpCS_6.equals(navExp_0);
										symbol_4 = eq_5;
									}
									and_0 = symbol_4;
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
							final /*@NonInvalid*/ boolean symbol_5 = not_0 != null;
							/*@Thrown*/ @Nullable Boolean raw_not;
							if (symbol_5) {
								if (not_0 == null) {
									throw throwNull(lNameExpCS_6, "Null where non-null value required");
								}
								/*@Thrown*/ @Nullable Boolean symbol_18;
								if (not_0) {
									/*@Caught*/ @Nullable Object CAUGHT_and_3;
									try {
										/*@Caught*/ @Nullable Object CAUGHT_and_2;
										try {
											final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_1 = lNameExpCS_6.getRoundedBrackets();
											final /*@NonInvalid*/ boolean eq_6 = roundedBrackets_1 == null;
											/*@NonInvalid*/ @Nullable Boolean and_1;
											if (eq_6) {
												/*@Caught*/ @NonNull Object CAUGHT_symbol_6;
												try {
													final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_1 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_6);
													final /*@NonInvalid*/ boolean eq_7 = parentCallExpCS_1 == null;
													/*@Thrown*/ boolean symbol_6;
													if (eq_7) {
														symbol_6 = ValueUtil.FALSE_VALUE;
													}
													else {
														if (parentCallExpCS_1 == null) {
															throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
														}
														final /*@Thrown*/ @Nullable NavigationExpCS navExp_1 = parentCallExpCS_1.getNavExp();
														final /*@Thrown*/ boolean eq_8 = lNameExpCS_6.equals(navExp_1);
														symbol_6 = eq_8;
													}
													CAUGHT_symbol_6 = symbol_6;
												}
												catch (Exception e) {
													CAUGHT_symbol_6 = ValueUtil.createInvalidValue(e);
												}
												final /*@NonInvalid*/ @Nullable Boolean not_1 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_6);
												and_1 = not_1;
											}
											else {
												and_1 = ValueUtil.FALSE_VALUE;
											}
											/*@Caught*/ @NonNull Object CAUGHT_eq_9;
											try {
												final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_6.getExpName();
												if (expName == null) {
													throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
												}
												@SuppressWarnings("null")
												final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName.getPathElements();
												final /*@Thrown*/ @NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
												final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
												final /*@Thrown*/ boolean eq_9 = size.equals(INT_1);
												CAUGHT_eq_9 = eq_9;
											}
											catch (Exception e) {
												CAUGHT_eq_9 = ValueUtil.createInvalidValue(e);
											}
											final /*@Thrown*/ @Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(and_1, CAUGHT_eq_9);
											CAUGHT_and_2 = and_2;
										}
										catch (Exception e) {
											CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
										}
										final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_6);
										final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
										final /*@Thrown*/ @Nullable Boolean and_3 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_2, ne);
										CAUGHT_and_3 = and_3;
									}
									catch (Exception e) {
										CAUGHT_and_3 = ValueUtil.createInvalidValue(e);
									}
									final /*@NonInvalid*/ @Nullable Boolean not_2 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_3);
									final /*@NonInvalid*/ boolean symbol_7 = not_2 != null;
									/*@Thrown*/ @Nullable Boolean raw_not1;
									if (symbol_7) {
										if (not_2 == null) {
											throw throwNull(lNameExpCS_6, "Null where non-null value required");
										}
										/*@Thrown*/ @Nullable Boolean symbol_17;
										if (not_2) {
											@SuppressWarnings("null")
											final /*@Thrown*/ @NonNull OCLExpression ownedSource = symbol_2.getOwnedSource();
											objectManager.getting(ownedSource, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, false);
											@SuppressWarnings("null")
											final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type = ownedSource.getType();
											final /*@NonInvalid*/ @Nullable PathNameCS expName_0 = lNameExpCS_6.getExpName();
											if (expName_0 == null) {
												throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
											}
											@SuppressWarnings("null")
											final /*@Thrown*/ @NonNull List<PathElementCS> segments_0 = expName_0.getPathElements();
											final /*@Thrown*/ @NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
											final /*@Thrown*/ @NonNull IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
											final /*@Thrown*/ boolean eq_10 = size_0.equals(INT_1);
											/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property symbol_14;
											if (eq_10) {
												final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
												if (aPathElementCS == null) {
													throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
												}
												final /*@Thrown*/ @Nullable String pName_1 = aPathElementCS.getElementName();
												final /*@Thrown*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Class, type);
												final org.eclipse.ocl.pivot.@NonNull Class TYPE_superClasses_1 = executor.getStaticTypeOfValue(null, oclAsSet);
												final LibraryIteration.@NonNull LibraryIterationExtension IMPL_superClasses_1 = (LibraryIteration.LibraryIterationExtension)TYPE_superClasses_1.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
												final @NonNull Object ACC_superClasses_1 = IMPL_superClasses_1.createAccumulatorValue(executor, SET_CLSSid_Class, ORD_CLSSid_Class);
												/**
												 * Implementation of the iterator body.
												 */
												final @NonNull AbstractBinaryOperation BODY_superClasses_1 = new AbstractBinaryOperation()
												{
													/**
													 * ::superClasses : OrderedSet(miniocl::Class)
													 */
													@Override
													public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ @Nullable Object _1) {
														final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_8 = (org.eclipse.qvtd.doc.miniocl.Class)_1;
														if (symbol_8 == null) {
															throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/1.0\'::Class::superClasses\'");
														}
														@SuppressWarnings("null")
														final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> superClasses_0 = symbol_8.getSuperClasses();
														final /*@Thrown*/ @NonNull OrderedSetValue BOXED_superClasses_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_Class, superClasses_0);
														return BOXED_superClasses_0;
													}
												};
												final @NonNull ExecutorSingleIterationManager MGR_superClasses_1 = new ExecutorSingleIterationManager(executor, SET_CLSSid_Class, BODY_superClasses_1, oclAsSet, ACC_superClasses_1);
												@SuppressWarnings("null")
												final /*@Thrown*/ @NonNull SetValue superClasses = (@NonNull SetValue)IMPL_superClasses_1.evaluateIteration(MGR_superClasses_1);
												final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
												final /*@NonInvalid*/ @NonNull LookupEnvironment env_3 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
												@SuppressWarnings("null")
												final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ownedProperties = type.getOwnedProperties();
												@SuppressWarnings("null")
												final /*@Thrown*/ @NonNull LookupEnvironment addElements = env_3.addElements(ownedProperties);
												final /*@Thrown*/ @NonNull OrderedSetValue foundProperty = INSTANCE_Visitable__lookupProperty.evaluate(type, addElements, pName_1);
												final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundProperty).booleanValue();
												/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property symbol_9;
												if (isEmpty) {
													symbol_9 = null;
												}
												else {
													final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property first = (org.eclipse.qvtd.doc.miniocl.@Nullable Property)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundProperty);
													symbol_9 = first;
												}
												symbol_14 = symbol_9;
											}
											else {
												final /*@Thrown*/ @NonNull IntegerValue diff = (@Nullable IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_0, INT_1);
												final /*@Thrown*/ @NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
												final /*@Thrown*/ @NonNull IntegerValue size_2 = CollectionSizeOperation.INSTANCE.evaluate(qualifierSegments);
												final /*@Thrown*/ boolean eq_11 = size_2.equals(INT_1);
												/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_12;
												if (eq_11) {
													final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_0 = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(qualifierSegments);
													if (aPathElementCS_0 == null) {
														throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
													}
													final /*@Thrown*/ @Nullable String cName_0 = aPathElementCS_0.getElementName();
													final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Class = INSTANCE_OclElement_unqualified_env_Class.evaluate(symbol_2);
													final /*@Thrown*/ @NonNull OrderedSetValue foundClass = INSTANCE_Visitable__lookupClass.evaluate(symbol_2, unqualified_env_Class, cName_0);
													final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
													/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_10;
													if (isEmpty_0) {
														symbol_10 = null;
													}
													else {
														final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
														symbol_10 = first_0;
													}
													symbol_12 = symbol_10;
												}
												else {
													final /*@Thrown*/ @NonNull IntegerValue diff_0 = (@Nullable IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_2, INT_1);
													final /*@Thrown*/ @NonNull OrderedSetValue qualifierSegments_0 = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(qualifierSegments, INT_1, diff_0);
													final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package qualifier = INSTANCE_Visitable_lookupPackage.evaluate(symbol_2, qualifierSegments_0);
													/*@Caught*/ @Nullable Object CAUGHT_qualifier;
													try {
														CAUGHT_qualifier = qualifier;
													}
													catch (Exception e) {
														CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
													}
													final /*@NonInvalid*/ @NonNull Object lookupQualifiedClass = CAUGHT_qualifier == null;
													/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class safe_lookupQualifiedClass_source;
													if (lookupQualifiedClass == Boolean.TRUE) {
														safe_lookupQualifiedClass_source = null;
													}
													else {
														if (qualifier == null) {
															throw throwNull(lNameExpCS_6, "Null where non-null value required");
														}
														final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_1 = (@Nullable PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(qualifierSegments);
														if (aPathElementCS_1 == null) {
															throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
														}
														final /*@Thrown*/ @Nullable String cName_1 = aPathElementCS_1.getElementName();
														final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_1 = idResolver.getClass(CLSSid_LookupEnvironment, null);
														final /*@NonInvalid*/ @NonNull LookupEnvironment env_4 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_1.createInstance();
														@SuppressWarnings("null")
														final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = qualifier.getOwnedClasses();
														@SuppressWarnings("null")
														final /*@Thrown*/ @NonNull LookupEnvironment addElements_0 = env_4.addElements(ownedClasses);
														final /*@Thrown*/ @NonNull OrderedSetValue foundClass_0 = INSTANCE_Visitable__lookupClass.evaluate(qualifier, addElements_0, cName_1);
														final /*@Thrown*/ boolean isEmpty_1 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass_0).booleanValue();
														/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_11;
														if (isEmpty_1) {
															symbol_11 = null;
														}
														else {
															final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_1 = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
															symbol_11 = first_1;
														}
														safe_lookupQualifiedClass_source = symbol_11;
													}
													symbol_12 = safe_lookupQualifiedClass_source;
												}
												/*@Caught*/ @Nullable Object CAUGHT_symbol_12;
												try {
													CAUGHT_symbol_12 = symbol_12;
												}
												catch (Exception e) {
													CAUGHT_symbol_12 = ValueUtil.createInvalidValue(e);
												}
												final /*@NonInvalid*/ @NonNull Object lookupQualifiedProperty = CAUGHT_symbol_12 == null;
												/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property safe_lookupQualifiedProperty_source;
												if (lookupQualifiedProperty == Boolean.TRUE) {
													safe_lookupQualifiedProperty_source = null;
												}
												else {
													if (symbol_12 == null) {
														throw throwNull(lNameExpCS_6, "Null where non-null value required");
													}
													final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_2 = (@Nullable PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
													if (aPathElementCS_2 == null) {
														throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
													}
													final /*@Thrown*/ @Nullable String pName_2 = aPathElementCS_2.getElementName();
													final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_2 = idResolver.getClass(CLSSid_LookupEnvironment, null);
													final /*@NonInvalid*/ @NonNull LookupEnvironment env_5 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_2.createInstance();
													@SuppressWarnings("null")
													final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ownedProperties_0 = symbol_12.getOwnedProperties();
													@SuppressWarnings("null")
													final /*@Thrown*/ @NonNull LookupEnvironment addElements_1 = env_5.addElements(ownedProperties_0);
													final /*@Thrown*/ @NonNull OrderedSetValue foundProperty_0 = INSTANCE_Visitable__lookupProperty.evaluate(symbol_12, addElements_1, pName_2);
													final /*@Thrown*/ boolean isEmpty_2 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundProperty_0).booleanValue();
													/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property symbol_13;
													if (isEmpty_2) {
														symbol_13 = null;
													}
													else {
														final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property first_2 = (org.eclipse.qvtd.doc.miniocl.@Nullable Property)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundProperty_0);
														symbol_13 = first_2;
													}
													safe_lookupQualifiedProperty_source = symbol_13;
												}
												symbol_14 = safe_lookupQualifiedProperty_source;
											}
											// mapping statements
											if (symbol_14 == null) {
												throw throwNull(lNameExpCS_6, "Null value for miniocl::PropertyCallExp::referredProperty assignment");
											}
											symbol_2.setReferredProperty(symbol_14);
											objectManager.assigned(symbol_2, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, symbol_14);
											final /*@Thrown*/ @Nullable Boolean muNameExpCS__2__PropertyCallExp__0__referredPropert = ValueUtil.TRUE_VALUE;
											symbol_17 = muNameExpCS__2__PropertyCallExp__0__referredPropert;
										}
										else {
											symbol_17 = ValueUtil.FALSE_VALUE;
										}
										raw_not1 = symbol_17;
									}
									else {
										raw_not1 = ValueUtil.FALSE_VALUE;
									}
									symbol_18 = raw_not1;
								}
								else {
									symbol_18 = ValueUtil.FALSE_VALUE;
								}
								raw_not = symbol_18;
							}
							else {
								raw_not = ValueUtil.FALSE_VALUE;
							}
							symbol_19 = raw_not;
						}
						else {
							symbol_19 = ValueUtil.FALSE_VALUE;
						}
						symbol_20 = symbol_19;
					}
					else {
						symbol_20 = ValueUtil.FALSE_VALUE;
					}
					symbol_21 = symbol_20;
				}
				else {
					symbol_21 = ValueUtil.FALSE_VALUE;
				}
				raw_ast = symbol_21;
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
	 * map muNameExpCS__2__PropertyCallExp__1__referredPropert in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * var ast : miniocl::Element[1] := lNameExpCS.ast;
	 * check var ast1 : miniocl::PropertyCallExp[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::PropertyCallExp)
	 *   ;
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * check isPropCallExpWithExplicitSource;
	 * var ownedSource : miniocl::OCLExpression[1] := ast1.ownedSource;
	 * observe miniocl::TypedElement::type var type : miniocl::Class[1] := ownedSource.type;
	 * var expName : minioclcs::PathNameCS[?] := lNameExpCS.expName;
	 * var lookupPropertyFrom : miniocl::Property[?] := ast1.lookupPropertyFrom(type, expName);
	 * notify set ast1.referredProperty := lookupPropertyFrom;
	 *
	 */
	protected class MAP_muNameExpCS__2__PropertyCallExp__1__referredPropert extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_7;

		public MAP_muNameExpCS__2__PropertyCallExp__1__referredPropert(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_7 = (@NonNull NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
			final /*@NonInvalid*/ @Nullable Element ast = lNameExpCS_7.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = ast != null;
			/*@Thrown*/ @Nullable Boolean raw_ast;
			if (symbol_0) {
				if (ast == null) {
					throw throwNull(lNameExpCS_7, "Null where non-null value required");
				}
				final /*@NonInvalid*/ boolean symbol_1 = ast instanceof PropertyCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_15;
				if (symbol_1) {
					final /*@Thrown*/ @NonNull PropertyCallExp symbol_2 = (PropertyCallExp)ast;
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_PropertyCallExp_0 = idResolver.getClass(CLSSid_PropertyCallExp, null);
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull PropertyCallExp oclAsType = (@NonNull PropertyCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_PropertyCallExp_0);
					final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
					/*@Thrown*/ @Nullable Boolean symbol_14;
					if (eq) {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_7.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq_0 = roundedBrackets == null;
						/*@Thrown*/ boolean and;
						if (eq_0) {
							final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_7);
							final /*@NonInvalid*/ boolean eq_1 = parentCallExpCS == null;
							/*@Thrown*/ boolean symbol_3;
							if (eq_1) {
								symbol_3 = ValueUtil.FALSE_VALUE;
							}
							else {
								if (parentCallExpCS == null) {
									throw throwNull(lNameExpCS_7, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
								}
								final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
								final /*@Thrown*/ boolean eq_2 = lNameExpCS_7.equals(navExp);
								symbol_3 = eq_2;
							}
							and = symbol_3;
						}
						else {
							and = ValueUtil.FALSE_VALUE;
						}
						/*@Thrown*/ @Nullable Boolean symbol_13;
						if (and) {
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull OCLExpression ownedSource = symbol_2.getOwnedSource();
							objectManager.getting(ownedSource, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, false);
							@SuppressWarnings("null")
							final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type = ownedSource.getType();
							final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_7.getExpName();
							if (expName == null) {
								throw throwNull(lNameExpCS_7, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull List<PathElementCS> segments_0 = expName.getPathElements();
							final /*@Thrown*/ @NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
							final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
							final /*@Thrown*/ boolean eq_3 = size.equals(INT_1);
							/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property symbol_10;
							if (eq_3) {
								final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
								if (aPathElementCS == null) {
									throw throwNull(lNameExpCS_7, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
								}
								final /*@Thrown*/ @Nullable String pName_1 = aPathElementCS.getElementName();
								final /*@Thrown*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Class, type);
								final org.eclipse.ocl.pivot.@NonNull Class TYPE_superClasses_1 = executor.getStaticTypeOfValue(null, oclAsSet);
								final LibraryIteration.@NonNull LibraryIterationExtension IMPL_superClasses_1 = (LibraryIteration.LibraryIterationExtension)TYPE_superClasses_1.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
								final @NonNull Object ACC_superClasses_1 = IMPL_superClasses_1.createAccumulatorValue(executor, SET_CLSSid_Class, ORD_CLSSid_Class);
								/**
								 * Implementation of the iterator body.
								 */
								final @NonNull AbstractBinaryOperation BODY_superClasses_1 = new AbstractBinaryOperation()
								{
									/**
									 * ::superClasses : OrderedSet(miniocl::Class)
									 */
									@Override
									public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ @Nullable Object _1) {
										final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_4 = (org.eclipse.qvtd.doc.miniocl.Class)_1;
										if (symbol_4 == null) {
											throw throwNull(lNameExpCS_7, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/1.0\'::Class::superClasses\'");
										}
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> superClasses_0 = symbol_4.getSuperClasses();
										final /*@Thrown*/ @NonNull OrderedSetValue BOXED_superClasses_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_Class, superClasses_0);
										return BOXED_superClasses_0;
									}
								};
								final @NonNull ExecutorSingleIterationManager MGR_superClasses_1 = new ExecutorSingleIterationManager(executor, SET_CLSSid_Class, BODY_superClasses_1, oclAsSet, ACC_superClasses_1);
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull SetValue superClasses = (@NonNull SetValue)IMPL_superClasses_1.evaluateIteration(MGR_superClasses_1);
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
								final /*@NonInvalid*/ @NonNull LookupEnvironment env_3 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ownedProperties = type.getOwnedProperties();
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull LookupEnvironment addElements = env_3.addElements(ownedProperties);
								final /*@Thrown*/ @NonNull OrderedSetValue foundProperty = INSTANCE_Visitable__lookupProperty.evaluate(type, addElements, pName_1);
								final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundProperty).booleanValue();
								/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property symbol_5;
								if (isEmpty) {
									symbol_5 = null;
								}
								else {
									final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property first = (org.eclipse.qvtd.doc.miniocl.@Nullable Property)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundProperty);
									symbol_5 = first;
								}
								symbol_10 = symbol_5;
							}
							else {
								final /*@Thrown*/ @NonNull IntegerValue diff = (@Nullable IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
								final /*@Thrown*/ @NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
								final /*@Thrown*/ @NonNull IntegerValue size_1 = CollectionSizeOperation.INSTANCE.evaluate(qualifierSegments);
								final /*@Thrown*/ boolean eq_4 = size_1.equals(INT_1);
								/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_8;
								if (eq_4) {
									final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_0 = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(qualifierSegments);
									if (aPathElementCS_0 == null) {
										throw throwNull(lNameExpCS_7, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
									}
									final /*@Thrown*/ @Nullable String cName_0 = aPathElementCS_0.getElementName();
									final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Class = INSTANCE_OclElement_unqualified_env_Class.evaluate(symbol_2);
									final /*@Thrown*/ @NonNull OrderedSetValue foundClass = INSTANCE_Visitable__lookupClass.evaluate(symbol_2, unqualified_env_Class, cName_0);
									final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
									/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_6;
									if (isEmpty_0) {
										symbol_6 = null;
									}
									else {
										final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
										symbol_6 = first_0;
									}
									symbol_8 = symbol_6;
								}
								else {
									final /*@Thrown*/ @NonNull IntegerValue diff_0 = (@Nullable IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_1, INT_1);
									final /*@Thrown*/ @NonNull OrderedSetValue qualifierSegments_0 = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(qualifierSegments, INT_1, diff_0);
									final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package qualifier = INSTANCE_Visitable_lookupPackage.evaluate(symbol_2, qualifierSegments_0);
									/*@Caught*/ @Nullable Object CAUGHT_qualifier;
									try {
										CAUGHT_qualifier = qualifier;
									}
									catch (Exception e) {
										CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
									}
									final /*@NonInvalid*/ @NonNull Object lookupQualifiedClass = CAUGHT_qualifier == null;
									/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class safe_lookupQualifiedClass_source;
									if (lookupQualifiedClass == Boolean.TRUE) {
										safe_lookupQualifiedClass_source = null;
									}
									else {
										if (qualifier == null) {
											throw throwNull(lNameExpCS_7, "Null where non-null value required");
										}
										final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_1 = (@Nullable PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(qualifierSegments);
										if (aPathElementCS_1 == null) {
											throw throwNull(lNameExpCS_7, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
										}
										final /*@Thrown*/ @Nullable String cName_1 = aPathElementCS_1.getElementName();
										final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_1 = idResolver.getClass(CLSSid_LookupEnvironment, null);
										final /*@NonInvalid*/ @NonNull LookupEnvironment env_4 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_1.createInstance();
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = qualifier.getOwnedClasses();
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull LookupEnvironment addElements_0 = env_4.addElements(ownedClasses);
										final /*@Thrown*/ @NonNull OrderedSetValue foundClass_0 = INSTANCE_Visitable__lookupClass.evaluate(qualifier, addElements_0, cName_1);
										final /*@Thrown*/ boolean isEmpty_1 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass_0).booleanValue();
										/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class symbol_7;
										if (isEmpty_1) {
											symbol_7 = null;
										}
										else {
											final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_1 = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
											symbol_7 = first_1;
										}
										safe_lookupQualifiedClass_source = symbol_7;
									}
									symbol_8 = safe_lookupQualifiedClass_source;
								}
								/*@Caught*/ @Nullable Object CAUGHT_symbol_8;
								try {
									CAUGHT_symbol_8 = symbol_8;
								}
								catch (Exception e) {
									CAUGHT_symbol_8 = ValueUtil.createInvalidValue(e);
								}
								final /*@NonInvalid*/ @NonNull Object lookupQualifiedProperty = CAUGHT_symbol_8 == null;
								/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property safe_lookupQualifiedProperty_source;
								if (lookupQualifiedProperty == Boolean.TRUE) {
									safe_lookupQualifiedProperty_source = null;
								}
								else {
									if (symbol_8 == null) {
										throw throwNull(lNameExpCS_7, "Null where non-null value required");
									}
									final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_2 = (@Nullable PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
									if (aPathElementCS_2 == null) {
										throw throwNull(lNameExpCS_7, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
									}
									final /*@Thrown*/ @Nullable String pName_2 = aPathElementCS_2.getElementName();
									final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_2 = idResolver.getClass(CLSSid_LookupEnvironment, null);
									final /*@NonInvalid*/ @NonNull LookupEnvironment env_5 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_2.createInstance();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ownedProperties_0 = symbol_8.getOwnedProperties();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull LookupEnvironment addElements_1 = env_5.addElements(ownedProperties_0);
									final /*@Thrown*/ @NonNull OrderedSetValue foundProperty_0 = INSTANCE_Visitable__lookupProperty.evaluate(symbol_8, addElements_1, pName_2);
									final /*@Thrown*/ boolean isEmpty_2 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundProperty_0).booleanValue();
									/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property symbol_9;
									if (isEmpty_2) {
										symbol_9 = null;
									}
									else {
										final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property first_2 = (org.eclipse.qvtd.doc.miniocl.@Nullable Property)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundProperty_0);
										symbol_9 = first_2;
									}
									safe_lookupQualifiedProperty_source = symbol_9;
								}
								symbol_10 = safe_lookupQualifiedProperty_source;
							}
							// mapping statements
							if (symbol_10 == null) {
								throw throwNull(lNameExpCS_7, "Null value for miniocl::PropertyCallExp::referredProperty assignment");
							}
							symbol_2.setReferredProperty(symbol_10);
							objectManager.assigned(symbol_2, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, symbol_10);
							final /*@Thrown*/ @Nullable Boolean muNameExpCS__2__PropertyCallExp__1__referredPropert = ValueUtil.TRUE_VALUE;
							symbol_13 = muNameExpCS__2__PropertyCallExp__1__referredPropert;
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
				raw_ast = symbol_15;
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
	 * map muNameExpCS__2__PropertyCallExp__1__type in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * var ast : miniocl::Element[1] := lNameExpCS.ast;
	 * check var ast1 : miniocl::PropertyCallExp[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::PropertyCallExp)
	 *   ;
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * check isPropCallExpWithExplicitSource;
	 * observe miniocl::PropertyCallExp::referredProperty var unsafe : miniocl::Property[1] := ast1.referredProperty;
	 * var type : miniocl::Class[1] := unsafe.type;
	 * var _'if' : miniocl::Class[?] := if unsafe = null
	 *   then null
	 *   else type
	 *   endif;
	 * var _'=' : Boolean[1] := unsafe = null;
	 * notify set ast1.type := _'if';
	 *
	 */
	protected class MAP_muNameExpCS__2__PropertyCallExp__1__type extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_8;

		public MAP_muNameExpCS__2__PropertyCallExp__1__type(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_8 = (@NonNull NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Element ast = lNameExpCS_8.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = ast != null;
			/*@Thrown*/ @Nullable Boolean raw_ast;
			if (symbol_0) {
				if (ast == null) {
					throw throwNull(lNameExpCS_8, "Null where non-null value required");
				}
				final /*@NonInvalid*/ boolean symbol_1 = ast instanceof PropertyCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_8;
				if (symbol_1) {
					final /*@Thrown*/ @NonNull PropertyCallExp symbol_2 = (PropertyCallExp)ast;
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_PropertyCallExp_0 = idResolver.getClass(CLSSid_PropertyCallExp, null);
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull PropertyCallExp oclAsType = (@NonNull PropertyCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_PropertyCallExp_0);
					final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
					/*@Thrown*/ @Nullable Boolean symbol_7;
					if (eq) {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_8.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq_0 = roundedBrackets == null;
						/*@Thrown*/ boolean and;
						if (eq_0) {
							final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_8);
							final /*@NonInvalid*/ boolean eq_1 = parentCallExpCS == null;
							/*@Thrown*/ boolean symbol_3;
							if (eq_1) {
								symbol_3 = ValueUtil.FALSE_VALUE;
							}
							else {
								if (parentCallExpCS == null) {
									throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
								}
								final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
								final /*@Thrown*/ boolean eq_2 = lNameExpCS_8.equals(navExp);
								symbol_3 = eq_2;
							}
							and = symbol_3;
						}
						else {
							and = ValueUtil.FALSE_VALUE;
						}
						/*@Thrown*/ @Nullable Boolean symbol_6;
						if (and) {
							objectManager.getting(symbol_2, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, false);
							@SuppressWarnings("null")
							final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Property referredProperty = symbol_2.getReferredProperty();
							@SuppressWarnings("null")
							final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type = referredProperty.getType();
							// mapping statements
							symbol_2.setType(type);
							objectManager.assigned(symbol_2, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, type);
							final /*@Thrown*/ @Nullable Boolean muNameExpCS__2__PropertyCallExp__1__type = ValueUtil.TRUE_VALUE;
							symbol_6 = muNameExpCS__2__PropertyCallExp__1__type;
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
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS_8, thoseValues[0]);
		}
	}

	/**
	 *
	 * map muNameExpCS__2__PropertyCallExp__0__type in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * var ast : miniocl::Element[1] := lNameExpCS.ast;
	 * check var ast1 : miniocl::PropertyCallExp[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::PropertyCallExp)
	 *   ;
	 * var isPropCallExpWithImplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithImplicitSource()
	 *   ;
	 * check isPropCallExpWithImplicitSource;
	 * observe miniocl::PropertyCallExp::referredProperty var unsafe : miniocl::Property[1] := ast1.referredProperty;
	 * var isVariableExp : Boolean[?] := lNameExpCS.isVariableExp()
	 *   ;
	 * var _'not' : Boolean[1] := not isVariableExp;
	 * check _'not';
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * var not1 : Boolean[1] := not isPropCallExpWithExplicitSource;
	 * check not1;
	 * var type : miniocl::Class[1] := unsafe.type;
	 * var _'if' : miniocl::Class[?] := if unsafe = null
	 *   then null
	 *   else type
	 *   endif;
	 * var _'=' : Boolean[1] := unsafe = null;
	 * notify set ast1.type := _'if';
	 *
	 */
	protected class MAP_muNameExpCS__2__PropertyCallExp__0__type extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_9;

		public MAP_muNameExpCS__2__PropertyCallExp__0__type(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_9 = (@NonNull NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Element ast = lNameExpCS_9.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = ast != null;
			/*@Thrown*/ @Nullable Boolean raw_ast;
			if (symbol_0) {
				if (ast == null) {
					throw throwNull(lNameExpCS_9, "Null where non-null value required");
				}
				final /*@NonInvalid*/ boolean symbol_1 = ast instanceof PropertyCallExp;
				/*@Thrown*/ @Nullable Boolean symbol_14;
				if (symbol_1) {
					final /*@Thrown*/ @NonNull PropertyCallExp symbol_2 = (PropertyCallExp)ast;
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_PropertyCallExp_0 = idResolver.getClass(CLSSid_PropertyCallExp, null);
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull PropertyCallExp oclAsType = (@NonNull PropertyCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_PropertyCallExp_0);
					final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
					/*@Thrown*/ @Nullable Boolean symbol_13;
					if (eq) {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_9.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq_0 = roundedBrackets == null;
						/*@NonInvalid*/ @Nullable Boolean and;
						if (eq_0) {
							/*@Caught*/ @NonNull Object CAUGHT_symbol_3;
							try {
								final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_9);
								final /*@NonInvalid*/ boolean eq_1 = parentCallExpCS == null;
								/*@Thrown*/ boolean symbol_3;
								if (eq_1) {
									symbol_3 = ValueUtil.FALSE_VALUE;
								}
								else {
									if (parentCallExpCS == null) {
										throw throwNull(lNameExpCS_9, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
									}
									final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
									final /*@Thrown*/ boolean eq_2 = lNameExpCS_9.equals(navExp);
									symbol_3 = eq_2;
								}
								CAUGHT_symbol_3 = symbol_3;
							}
							catch (Exception e) {
								CAUGHT_symbol_3 = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_3);
							and = not;
						}
						else {
							and = ValueUtil.FALSE_VALUE;
						}
						if (and == null) {
							throw throwNull(lNameExpCS_9, "Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean symbol_12;
						if (and) {
							objectManager.getting(symbol_2, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, false);
							@SuppressWarnings("null")
							final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Property referredProperty = symbol_2.getReferredProperty();
							/*@Caught*/ @Nullable Object CAUGHT_and_2;
							try {
								/*@Caught*/ @Nullable Object CAUGHT_and_1;
								try {
									final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_9.getRoundedBrackets();
									final /*@NonInvalid*/ boolean eq_3 = roundedBrackets_0 == null;
									/*@NonInvalid*/ @Nullable Boolean and_0;
									if (eq_3) {
										/*@Caught*/ @NonNull Object CAUGHT_symbol_4;
										try {
											final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_9);
											final /*@NonInvalid*/ boolean eq_4 = parentCallExpCS_0 == null;
											/*@Thrown*/ boolean symbol_4;
											if (eq_4) {
												symbol_4 = ValueUtil.FALSE_VALUE;
											}
											else {
												if (parentCallExpCS_0 == null) {
													throw throwNull(lNameExpCS_9, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
												}
												final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
												final /*@Thrown*/ boolean eq_5 = lNameExpCS_9.equals(navExp_0);
												symbol_4 = eq_5;
											}
											CAUGHT_symbol_4 = symbol_4;
										}
										catch (Exception e) {
											CAUGHT_symbol_4 = ValueUtil.createInvalidValue(e);
										}
										final /*@NonInvalid*/ @Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_symbol_4);
										and_0 = not_0;
									}
									else {
										and_0 = ValueUtil.FALSE_VALUE;
									}
									/*@Caught*/ @NonNull Object CAUGHT_eq_6;
									try {
										final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_9.getExpName();
										if (expName == null) {
											throw throwNull(lNameExpCS_9, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
										}
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName.getPathElements();
										final /*@Thrown*/ @NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
										final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
										final /*@Thrown*/ boolean eq_6 = size.equals(INT_1);
										CAUGHT_eq_6 = eq_6;
									}
									catch (Exception e) {
										CAUGHT_eq_6 = ValueUtil.createInvalidValue(e);
									}
									final /*@Thrown*/ @Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(and_0, CAUGHT_eq_6);
									CAUGHT_and_1 = and_1;
								}
								catch (Exception e) {
									CAUGHT_and_1 = ValueUtil.createInvalidValue(e);
								}
								final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_9);
								final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
								final /*@Thrown*/ @Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_1, ne);
								CAUGHT_and_2 = and_2;
							}
							catch (Exception e) {
								CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @Nullable Boolean not_1 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_2);
							final /*@NonInvalid*/ boolean symbol_5 = not_1 != null;
							/*@Thrown*/ @Nullable Boolean raw_not;
							if (symbol_5) {
								if (not_1 == null) {
									throw throwNull(lNameExpCS_9, "Null where non-null value required");
								}
								/*@Thrown*/ @Nullable Boolean symbol_11;
								if (not_1) {
									/*@Caught*/ @NonNull Object CAUGHT_and_3;
									try {
										final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_1 = lNameExpCS_9.getRoundedBrackets();
										final /*@NonInvalid*/ boolean eq_7 = roundedBrackets_1 == null;
										/*@Thrown*/ boolean and_3;
										if (eq_7) {
											final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_1 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_9);
											final /*@NonInvalid*/ boolean eq_8 = parentCallExpCS_1 == null;
											/*@Thrown*/ boolean symbol_6;
											if (eq_8) {
												symbol_6 = ValueUtil.FALSE_VALUE;
											}
											else {
												if (parentCallExpCS_1 == null) {
													throw throwNull(lNameExpCS_9, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
												}
												final /*@Thrown*/ @Nullable NavigationExpCS navExp_1 = parentCallExpCS_1.getNavExp();
												final /*@Thrown*/ boolean eq_9 = lNameExpCS_9.equals(navExp_1);
												symbol_6 = eq_9;
											}
											and_3 = symbol_6;
										}
										else {
											and_3 = ValueUtil.FALSE_VALUE;
										}
										CAUGHT_and_3 = and_3;
									}
									catch (Exception e) {
										CAUGHT_and_3 = ValueUtil.createInvalidValue(e);
									}
									final /*@NonInvalid*/ @Nullable Boolean not_2 = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and_3);
									final /*@NonInvalid*/ boolean symbol_7 = not_2 != null;
									/*@Thrown*/ @Nullable Boolean raw_not1;
									if (symbol_7) {
										if (not_2 == null) {
											throw throwNull(lNameExpCS_9, "Null where non-null value required");
										}
										/*@Thrown*/ @Nullable Boolean symbol_10;
										if (not_2) {
											@SuppressWarnings("null")
											final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type = referredProperty.getType();
											// mapping statements
											symbol_2.setType(type);
											objectManager.assigned(symbol_2, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, type);
											final /*@Thrown*/ @Nullable Boolean muNameExpCS__2__PropertyCallExp__0__type = ValueUtil.TRUE_VALUE;
											symbol_10 = muNameExpCS__2__PropertyCallExp__0__type;
										}
										else {
											symbol_10 = ValueUtil.FALSE_VALUE;
										}
										raw_not1 = symbol_10;
									}
									else {
										raw_not1 = ValueUtil.FALSE_VALUE;
									}
									symbol_11 = raw_not1;
								}
								else {
									symbol_11 = ValueUtil.FALSE_VALUE;
								}
								raw_not = symbol_11;
							}
							else {
								raw_not = ValueUtil.FALSE_VALUE;
							}
							symbol_12 = raw_not;
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
				raw_ast = symbol_14;
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

	/**
	 *
	 * map muOperationCS__2__Operation__ownedBodyExpression in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lOperationCS : minioclcs::OperationCS[1];
	 * var ast : miniocl::Element[1] := lOperationCS.ast;
	 * check var ast1 : miniocl::Operation[1] := ast;
	 * check ast1 =
	 *   ast.oclAsType(miniocl::Operation);
	 * var body : minioclcs::ExpCS[?] := lOperationCS.body;
	 * var ast2 : miniocl::Element[?] := body?.ast;
	 * check var ast21 : miniocl::OCLExpression[?] := ast2;
	 * check ast21 =
	 *   ast2.oclAsType(miniocl::OCLExpression)
	 *   ;
	 * var owningClass : miniocl::Class[?] := ast1.owningClass;
	 * var type : miniocl::Class[?] := ast21?.type;
	 * var shadow : miniocl::ExpressionInOCL[1] := miniocl::ExpressionInOCL{
	 *     language = 'OCL', ownedBody = ast21, ownedSelfVar = miniocl::Variable{name = 'self', type = owningClass
	 *     }, type = type
	 *   }
	 *   ;
	 * var shadow1 : miniocl::Variable[1] := miniocl::Variable{name = 'self', type = owningClass
	 *   };
	 * set ast1.ownedBodyExpression := shadow;
	 *
	 */
	protected boolean MAP_muOperationCS__2__Operation__ownedBodyExpression(final /*@NonInvalid*/ @NonNull OperationCS lOperationCS_3)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element ast = lOperationCS_3.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = ast != null;
		/*@Thrown*/ @Nullable Boolean raw_ast;
		if (symbol_0) {
			if (ast == null) {
				throw throwNull(lOperationCS_3, "Null where non-null value required");
			}
			final /*@NonInvalid*/ boolean symbol_1 = ast instanceof Operation;
			/*@Thrown*/ @Nullable Boolean symbol_21;
			if (symbol_1) {
				final /*@Thrown*/ @NonNull Operation symbol_2 = (Operation)ast;
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull Operation oclAsType = (@NonNull Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_miniocl_c_c_Operation_0);
				final /*@Thrown*/ boolean eq = symbol_2.equals(oclAsType);
				/*@Thrown*/ @Nullable Boolean symbol_20;
				if (eq) {
					final /*@NonInvalid*/ @Nullable ExpCS body = lOperationCS_3.getBody();
					final /*@NonInvalid*/ @NonNull Object ast_0 = body == null;
					/*@Thrown*/ @Nullable Element safe_ast_source;
					if (ast_0 == Boolean.TRUE) {
						safe_ast_source = null;
					}
					else {
						assert body != null;
						final /*@Thrown*/ @Nullable Element ast_1 = body.getAst();
						safe_ast_source = ast_1;
					}
					final /*@NonInvalid*/ boolean symbol_3 = safe_ast_source instanceof OCLExpression;
					/*@Thrown*/ @Nullable Boolean symbol_19;
					if (symbol_3) {
						final /*@Thrown*/ @Nullable OCLExpression symbol_4 = (OCLExpression)safe_ast_source;
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_OCLExpression_0 = idResolver.getClass(CLSSid_OCLExpression, null);
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull OCLExpression oclAsType_0 = (@NonNull OCLExpression)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, safe_ast_source, TYP_miniocl_c_c_OCLExpression_0);
						final /*@Thrown*/ boolean eq_0 = oclAsType_0.equals(symbol_4);
						/*@Thrown*/ @Nullable Boolean symbol_18;
						if (eq_0) {
							final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class owningClass = symbol_2.getOwningClass();
							/*@Caught*/ @Nullable Object CAUGHT_safe_ast_source;
							try {
								CAUGHT_safe_ast_source = symbol_4;
							}
							catch (Exception e) {
								CAUGHT_safe_ast_source = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @NonNull Object type = CAUGHT_safe_ast_source == null;
							/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class safe_type_source;
							if (type == Boolean.TRUE) {
								safe_type_source = null;
							}
							else {
								assert symbol_4 != null;
								@SuppressWarnings("null")
								final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type_0 = symbol_4.getType();
								safe_type_source = type_0;
							}
							final /*@NonInvalid*/ @NonNull Property CTORid_language = idResolver.getProperty(PROPid_language);
							final /*@NonInvalid*/ @NonNull Property CTORid_name_0 = idResolver.getProperty(PROPid_name);
							final /*@NonInvalid*/ @NonNull Property CTORid_ownedBody = idResolver.getProperty(PROPid_ownedBody);
							final /*@NonInvalid*/ @NonNull Property CTORid_ownedSelfVar = idResolver.getProperty(PROPid_ownedSelfVar);
							final /*@NonInvalid*/ @NonNull Property CTORid_type_0 = idResolver.getProperty(PROPid_type);
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_ExpressionInOCL_0 = idResolver.getClass(CLSSid_ExpressionInOCL, null);
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Variable_1 = idResolver.getClass(CLSSid_Variable, null);
							final /*@Thrown*/ @NonNull ExpressionInOCL symbol_12 = (@NonNull ExpressionInOCL)TYP_miniocl_c_c_ExpressionInOCL_0.createInstance();
							CTORid_language.initValue(symbol_12, STR_OCL);
							CTORid_ownedBody.initValue(symbol_12, symbol_4);
							final /*@Thrown*/ @NonNull Variable symbol_9 = (@NonNull Variable)TYP_miniocl_c_c_Variable_1.createInstance();
							CTORid_name_0.initValue(symbol_9, STR_self);
							CTORid_type_0.initValue(symbol_9, owningClass);
							CTORid_ownedSelfVar.initValue(symbol_12, symbol_9);
							CTORid_type_0.initValue(symbol_12, safe_type_source);
							final /*@Thrown*/ @NonNull Variable symbol_15 = (@NonNull Variable)TYP_miniocl_c_c_Variable_1.createInstance();
							CTORid_name_0.initValue(symbol_15, STR_self);
							CTORid_type_0.initValue(symbol_15, owningClass);
							// mapping statements
							symbol_2.setOwnedBodyExpression(symbol_12);
							final /*@Thrown*/ @Nullable Boolean muOperationCS__2__Operation__ownedBodyExpression = ValueUtil.TRUE_VALUE;
							symbol_18 = muOperationCS__2__Operation__ownedBodyExpression;
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
				symbol_21 = symbol_20;
			}
			else {
				symbol_21 = ValueUtil.FALSE_VALUE;
			}
			raw_ast = symbol_21;
		}
		else {
			raw_ast = ValueUtil.FALSE_VALUE;
		}
		return raw_ast;
	}
}
