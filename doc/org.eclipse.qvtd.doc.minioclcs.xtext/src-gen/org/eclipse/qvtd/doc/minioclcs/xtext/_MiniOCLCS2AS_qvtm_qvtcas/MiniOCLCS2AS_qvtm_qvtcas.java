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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
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
import org.eclipse.qvtd.doc.minioclcs.xtext.tx.AbstractInvocation;
import org.eclipse.qvtd.doc.minioclcs.xtext.tx.AbstractSimpleInvocation;
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
 * Populate each input model with {@link addRootEObjects(String,List)}
 * <br>
 * {@link run()}
 * <br>
 * Extract each output model with {@link getRootEObjects(String)}
 */
@SuppressWarnings("unused")
public class MiniOCLCS2AS_qvtm_qvtcas extends AbstractCS2ASTransformer
{
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCLCS = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/doc/MiniOCLCS", "minioclcs", MinioclcsPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0 = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/doc/MiniOCL/1.0", "mocl", MiniOCLPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_Lookup_s_1_0 = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0", "lookup", EnvironmentPackage.eINSTANCE);
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
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_1 = ValueUtil.integerValueOf("1");
	public static final /*@NonInvalid*/ @NonNull String STR_OCL = "OCL";
	public static final /*@NonInvalid*/ @NonNull String STR_self = "self";
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Class = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Class, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_ClassCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ClassCS, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Class_0 = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Class, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_NamedElement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_NamedElement, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Operation = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Operation, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_OperationCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OperationCS, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Package = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Package, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_PackageCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PackageCS, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Package_0 = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Package, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Parameter = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Parameter, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_ParameterCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ParameterCS, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Parameter_0 = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Parameter, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_PathElementCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PathElementCS, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Property = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Property, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_PropertyCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PropertyCS, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Property_0 = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Property, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Variable = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Variable, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Variable_0 = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Variable, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ast = CLSSid_CSTrace.getPropertyId("ast");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_language = CLSSid_OpaqueExpression.getPropertyId("language");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_name = CLSSid_NamedElement.getPropertyId("name");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ownedBody = CLSSid_ExpressionInOCL.getPropertyId("ownedBody");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ownedBodyExpression = CLSSid_Operation.getPropertyId("ownedBodyExpression");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ownedClasses = CLSSid_Package.getPropertyId("ownedClasses");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ownedOperations = CLSSid_Class.getPropertyId("ownedOperations");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ownedPackages = CLSSid_Package.getPropertyId("ownedPackages");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ownedPackages_0 = CLSSid_Root.getPropertyId("ownedPackages");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ownedParameters = CLSSid_Operation.getPropertyId("ownedParameters");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ownedProperties = CLSSid_Class.getPropertyId("ownedProperties");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ownedSelfVar = CLSSid_ExpressionInOCL.getPropertyId("ownedSelfVar");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_ownedSource = CLSSid_CallExp.getPropertyId("ownedSource");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_parentEnv = CLSSid_LookupEnvironment.getPropertyId("parentEnv");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_referredProperty = CLSSid_PropertyCallExp.getPropertyId("referredProperty");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_referredVariable = CLSSid_VariableExp.getPropertyId("referredVariable");
	public static final /*@NonInvalid*/ @NonNull PropertyId PROPid_type = CLSSid_TypedElement.getPropertyId("type");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Class = TypeId.SEQUENCE.getSpecializedId(CLSSid_Class, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Element = TypeId.SEQUENCE.getSpecializedId(CLSSid_Element, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Operation = TypeId.SEQUENCE.getSpecializedId(CLSSid_Operation, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Package = TypeId.SEQUENCE.getSpecializedId(CLSSid_Package, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Parameter = TypeId.SEQUENCE.getSpecializedId(CLSSid_Parameter, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_Property = TypeId.SEQUENCE.getSpecializedId(CLSSid_Property, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Class = TypeId.SET.getSpecializedId(CLSSid_Class, true, ValueUtil.ONE_VALUE, ValueUtil.ONE_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_Class_0 = TypeId.SET.getSpecializedId(CLSSid_Class, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);

	protected final @NonNull AbstractInvocationConstructor CTOR_r_MiniOCLCS2AS_46_ocl__load__ = new AbstractInvocationConstructor(invocationManager, "r_MiniOCLCS2AS_46_ocl__load__", false, lazyCreateInterval(0))
	{
		@Override
		public @NonNull MAP_r_MiniOCLCS2AS_46_ocl__load__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_r_MiniOCLCS2AS_46_ocl__load__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mcNameExpCS__2__PropertyCallExp__1 = new AbstractInvocationConstructor(invocationManager, "mcNameExpCS__2__PropertyCallExp__1", true, lazyCreateInterval(1))
	{
		@Override
		public @NonNull MAP_mcNameExpCS__2__PropertyCallExp__1 newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mcNameExpCS__2__PropertyCallExp__1(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muNavigationExpCS__ast = new AbstractInvocationConstructor(invocationManager, "muNavigationExpCS__ast", true, lazyCreateInterval(1))
	{
		@Override
		public @NonNull MAP_muNavigationExpCS__ast newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muNavigationExpCS__ast(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muClassCS__2__Class__name = new AbstractInvocationConstructor(invocationManager, "muClassCS__2__Class__name", true, lazyCreateInterval(2))
	{
		@Override
		public @NonNull MAP_muClassCS__2__Class__name newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muClassCS__2__Class__name(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muClassCS__2__Class__ownedOperations = new AbstractInvocationConstructor(invocationManager, "muClassCS__2__Class__ownedOperations", true, lazyCreateInterval(2))
	{
		@Override
		public @NonNull MAP_muClassCS__2__Class__ownedOperations newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muClassCS__2__Class__ownedOperations(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muClassCS__2__Class__ownedProperties = new AbstractInvocationConstructor(invocationManager, "muClassCS__2__Class__ownedProperties", true, lazyCreateInterval(2))
	{
		@Override
		public @NonNull MAP_muClassCS__2__Class__ownedProperties newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muClassCS__2__Class__ownedProperties(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muOperationCS__2__Operation__name = new AbstractInvocationConstructor(invocationManager, "muOperationCS__2__Operation__name", true, lazyCreateInterval(2))
	{
		@Override
		public @NonNull MAP_muOperationCS__2__Operation__name newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muOperationCS__2__Operation__name(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muOperationCS__2__Operation__ownedParameters = new AbstractInvocationConstructor(invocationManager, "muOperationCS__2__Operation__ownedParameters", true, lazyCreateInterval(2))
	{
		@Override
		public @NonNull MAP_muOperationCS__2__Operation__ownedParameters newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muOperationCS__2__Operation__ownedParameters(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muPackageCS__2__Package__name = new AbstractInvocationConstructor(invocationManager, "muPackageCS__2__Package__name", true, lazyCreateInterval(2))
	{
		@Override
		public @NonNull MAP_muPackageCS__2__Package__name newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muPackageCS__2__Package__name(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muPackageCS__2__Package__ownedClasses = new AbstractInvocationConstructor(invocationManager, "muPackageCS__2__Package__ownedClasses", true, lazyCreateInterval(2))
	{
		@Override
		public @NonNull MAP_muPackageCS__2__Package__ownedClasses newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muPackageCS__2__Package__ownedClasses(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muPackageCS__2__Package__ownedPackages = new AbstractInvocationConstructor(invocationManager, "muPackageCS__2__Package__ownedPackages", true, lazyCreateInterval(2))
	{
		@Override
		public @NonNull MAP_muPackageCS__2__Package__ownedPackages newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muPackageCS__2__Package__ownedPackages(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muParameterCS__2__Parameter__name = new AbstractInvocationConstructor(invocationManager, "muParameterCS__2__Parameter__name", true, lazyCreateInterval(2))
	{
		@Override
		public @NonNull MAP_muParameterCS__2__Parameter__name newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muParameterCS__2__Parameter__name(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muPropertyCS__2__Property__name = new AbstractInvocationConstructor(invocationManager, "muPropertyCS__2__Property__name", true, lazyCreateInterval(2))
	{
		@Override
		public @NonNull MAP_muPropertyCS__2__Property__name newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muPropertyCS__2__Property__name(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muRootCS__2__Root__ownedPackages = new AbstractInvocationConstructor(invocationManager, "muRootCS__2__Root__ownedPackages", true, lazyCreateInterval(2))
	{
		@Override
		public @NonNull MAP_muRootCS__2__Root__ownedPackages newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muRootCS__2__Root__ownedPackages(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mcNameExpCS__2__PropertyCallExp__0 = new AbstractInvocationConstructor(invocationManager, "mcNameExpCS__2__PropertyCallExp__0", true, lazyCreateInterval(3))
	{
		@Override
		public @NonNull MAP_mcNameExpCS__2__PropertyCallExp__0 newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mcNameExpCS__2__PropertyCallExp__0(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_mcNameExpCS__2__VariableExp__1 = new AbstractInvocationConstructor(invocationManager, "mcNameExpCS__2__VariableExp__1", true, lazyCreateInterval(3))
	{
		@Override
		public @NonNull MAP_mcNameExpCS__2__VariableExp__1 newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_mcNameExpCS__2__VariableExp__1(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muCallExpCS__ast = new AbstractInvocationConstructor(invocationManager, "muCallExpCS__ast", true, lazyCreateInterval(3))
	{
		@Override
		public @NonNull MAP_muCallExpCS__ast newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muCallExpCS__ast(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muNameExpCS__2__PropertyCallExp__1__ownedSource = new AbstractInvocationConstructor(invocationManager, "muNameExpCS__2__PropertyCallExp__1__ownedSource", true, lazyCreateInterval(4))
	{
		@Override
		public @NonNull MAP_muNameExpCS__2__PropertyCallExp__1__ownedSource newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muNameExpCS__2__PropertyCallExp__1__ownedSource(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muNameExpCS__2__PropertyCallExp__0__ownedSource = new AbstractInvocationConstructor(invocationManager, "muNameExpCS__2__PropertyCallExp__0__ownedSource", true, lazyCreateInterval(5))
	{
		@Override
		public @NonNull MAP_muNameExpCS__2__PropertyCallExp__0__ownedSource newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muNameExpCS__2__PropertyCallExp__0__ownedSource(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muNameExpCS__2__VariableExp__1__referredVariable = new AbstractInvocationConstructor(invocationManager, "muNameExpCS__2__VariableExp__1__referredVariable", true, lazyCreateInterval(6))
	{
		@Override
		public @NonNull MAP_muNameExpCS__2__VariableExp__1__referredVariable newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muNameExpCS__2__VariableExp__1__referredVariable(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muNameExpCS__2__VariableExp__1__type = new AbstractInvocationConstructor(invocationManager, "muNameExpCS__2__VariableExp__1__type", true, lazyCreateInterval(7))
	{
		@Override
		public @NonNull MAP_muNameExpCS__2__VariableExp__1__type newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muNameExpCS__2__VariableExp__1__type(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muNameExpCS__2__PropertyCallExp__0__referredPropert = new AbstractInvocationConstructor(invocationManager, "muNameExpCS__2__PropertyCallExp__0__referredPropert", true, lazyCreateInterval(8))
	{
		@Override
		public @NonNull MAP_muNameExpCS__2__PropertyCallExp__0__referredPropert newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muNameExpCS__2__PropertyCallExp__0__referredPropert(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muNameExpCS__2__PropertyCallExp__0__type = new AbstractInvocationConstructor(invocationManager, "muNameExpCS__2__PropertyCallExp__0__type", true, lazyCreateInterval(8))
	{
		@Override
		public @NonNull MAP_muNameExpCS__2__PropertyCallExp__0__type newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muNameExpCS__2__PropertyCallExp__0__type(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muNameExpCS__2__PropertyCallExp__1__referredPropert = new AbstractInvocationConstructor(invocationManager, "muNameExpCS__2__PropertyCallExp__1__referredPropert", true, lazyCreateInterval(8))
	{
		@Override
		public @NonNull MAP_muNameExpCS__2__PropertyCallExp__1__referredPropert newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muNameExpCS__2__PropertyCallExp__1__referredPropert(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_muNameExpCS__2__PropertyCallExp__1__type = new AbstractInvocationConstructor(invocationManager, "muNameExpCS__2__PropertyCallExp__1__type", true, lazyCreateInterval(8))
	{
		@Override
		public @NonNull MAP_muNameExpCS__2__PropertyCallExp__1__type newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_muNameExpCS__2__PropertyCallExp__1__type(this, values);
		}
	};

	private final MiniOCLLookupSolver lookupSolver = new MiniOCLLookupSolver(executor);

	/*
	 * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex for TypedModel 2.
	 */
	private static final @NonNull ClassId @NonNull [] classIndex2classId_2 = new @NonNull ClassId[]{
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
	 * Mapping from each TypedModel 2 ClassIndex to all the ClassIndexes
	 * to which an object of the outer index may contribute results to an allInstances() invocation.
	 * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
	 * instance of the derived classId contributes to derived and inherited ClassIndexes.
	 */
	private final static int @NonNull [] @NonNull [] classIndex2allClassIndexes_2 = new int @NonNull [] @NonNull [] {
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

	public MiniOCLCS2AS_qvtm_qvtcas(final @NonNull TransformationExecutor executor) {
		super(executor, 5);
		initModel(0, "$primitive$");
		initModel(1, "$this$");
		initModel(2, "leftCS").initClassIds(classIndex2classId_2, classIndex2allClassIndexes_2);
		initModel(3, "rightAS");
		initModel(4, "$other$");
		initConnections();
	}

	@Override
	public boolean run(@NonNull String targetName) {
		return run();
	}

	@Override
	public boolean run() {
		final @NonNull Connection ji_CallExpCS = models[2/*leftCS*/].getConnection(0/*minioclcs::CallExpCS*/);
		final @NonNull Connection ji_ClassCS = models[2/*leftCS*/].getConnection(1/*minioclcs::ClassCS*/);
		final @NonNull Connection ji_NameExpCS = models[2/*leftCS*/].getConnection(2/*minioclcs::NameExpCS*/);
		final @NonNull Connection ji_NavigationExpCS = models[2/*leftCS*/].getConnection(3/*minioclcs::NavigationExpCS*/);
		final @NonNull Connection ji_OperationCS = models[2/*leftCS*/].getConnection(4/*minioclcs::OperationCS*/);
		final @NonNull Connection ji_PackageCS = models[2/*leftCS*/].getConnection(5/*minioclcs::PackageCS*/);
		final @NonNull Connection ji_ParameterCS = models[2/*leftCS*/].getConnection(6/*minioclcs::ParameterCS*/);
		final @NonNull Connection ji_PropertyCS = models[2/*leftCS*/].getConnection(7/*minioclcs::PropertyCS*/);
		final @NonNull Connection ji_RootCS = models[2/*leftCS*/].getConnection(8/*minioclcs::RootCS*/);
		CTOR_r_MiniOCLCS2AS_46_ocl__load__.invoke(ji_CallExpCS, ji_ClassCS, ji_NameExpCS, ji_NavigationExpCS, ji_OperationCS, ji_PackageCS, ji_ParameterCS, ji_PropertyCS, ji_RootCS);
		return invocationManager.flush();
	}

	/**
	 * minioclcs::NameExpCS::parentAsCallExpCS() : minioclcs::CallExpCS[?]
	 *
	 *
	 * let container : qvtruntimelibrary::OclElement[?] = self.oclContainer()
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
			/*@Thrown*/ @Nullable CallExpCS IF_oclIsKindOf;
			if (oclIsKindOf) {
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull CallExpCS oclAsType = (@NonNull CallExpCS)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container, TYP_minioclcs_c_c_CallExpCS_2);
				IF_oclIsKindOf = oclAsType;
			}
			else {
				IF_oclIsKindOf = null;
			}
			return IF_oclIsKindOf;
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
				/*@Thrown*/ OrderedSetValue.@NonNull Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Variable_0);
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
					if (eq) {
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
			final /*@Thrown*/ @Nullable Boolean and;
			if (CAUGHT_isEmpty == ValueUtil.FALSE_VALUE) {
				and = ValueUtil.FALSE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_not;
				try {
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
					if (CAUGHT_eq_0 instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_eq_0;
					}
					final /*@Thrown*/ @Nullable Boolean not;
					if (CAUGHT_eq_0 == ValueUtil.FALSE_VALUE) {
						not = ValueUtil.TRUE_VALUE;
					}
					else {
						if (CAUGHT_eq_0 == ValueUtil.TRUE_VALUE) {
							not = ValueUtil.FALSE_VALUE;
						}
						else {
							not = null;
						}
					}
					CAUGHT_not = not;
				}
				catch (Exception e) {
					CAUGHT_not = ValueUtil.createInvalidValue(e);
				}
				if (CAUGHT_not == ValueUtil.FALSE_VALUE) {
					and = ValueUtil.FALSE_VALUE;
				}
				else {
					if (CAUGHT_isEmpty instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_isEmpty;
					}
					if (CAUGHT_not instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_not;
					}
					if (CAUGHT_not == null) {
						and = null;
					}
					else {
						and = ValueUtil.TRUE_VALUE;
					}
				}
			}
			if (and == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @NonNull OrderedSetValue IF_and;
			if (and) {
				if (env == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
				}
				final /*@Thrown*/ @Nullable LookupEnvironment parentEnv_0 = env.getParentEnv();
				final /*@Thrown*/ @NonNull OrderedSetValue _lookupVariable = INSTANCE_Visitable__lookupVariable.evaluate(self_2, parentEnv_0, vName);
				IF_and = _lookupVariable;
			}
			else {
				if (CAUGHT_foundVariable instanceof InvalidValueException) {
					throw (InvalidValueException)CAUGHT_foundVariable;
				}
				IF_and = (OrderedSetValue)CAUGHT_foundVariable;
			}
			return IF_and;
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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_5 = (/*@NonInvalid*/ @NonNull Object)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, self_5);
			final /*@NonInvalid*/ boolean eq = parent == null;
			/*@Thrown*/ @NonNull LookupEnvironment IF_eq;
			if (eq) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
				final /*@NonInvalid*/ @NonNull LookupEnvironment symbol_0 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
				IF_eq = symbol_0;
			}
			else {
				if (parent == null) {
					throw new InvalidEvaluationException("Null source for \'ocl::OclElement::_unqualified_env_Variable(OclElement) : lookup::LookupEnvironment[1]\'");
				}
				final /*@Thrown*/ @NonNull LookupEnvironment _unqualified_env_Variable = INSTANCE_OclElement__unqualified_env_Variable.evaluate(parent, self_5);
				IF_eq = _unqualified_env_Variable;
			}
			return IF_eq;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_5) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_5});
		}
	}

	protected final @NonNull CACHE_OclElement_parentEnv_Variable INSTANCE_OclElement_parentEnv_Variable = new CACHE_OclElement_parentEnv_Variable();

	/**
	 * ocl::OclElement::_unqualified_env_Variable(child : OclElement[?]) : lookup::LookupEnvironment[1]
	 *
	 * parentEnv_Variable()
	 */
	public class CACHE_OclElement__unqualified_env_Variable extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_4 = (/*@NonInvalid*/ @NonNull Object)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child = (/*@NonInvalid*/ @Nullable Object)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull LookupEnvironment parentEnv_Variable = INSTANCE_OclElement_parentEnv_Variable.evaluate(self_4);
			return parentEnv_Variable;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_4, final /*@NonInvalid*/ @Nullable Object child) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_4, child});
		}
	}

	protected final @NonNull CACHE_OclElement__unqualified_env_Variable INST_OclElement__unqualified_env_Variable = new CACHE_OclElement__unqualified_env_Variable();

	/**
	 * miniocl::ExpressionInOCL::_unqualified_env_Variable(child : OclElement[?]) : lookup::LookupEnvironment[?]
	 *
	 * parentEnv_Variable().nestedEnv().addElements(ownedSelfVar)
	 */
	public class CACHE_ExpressionInOCL__unqualified_env_Variable extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull ExpressionInOCL self_6 = (/*@NonInvalid*/ @NonNull ExpressionInOCL)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_0 = (/*@NonInvalid*/ @Nullable Object)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull LookupEnvironment self_22 = INSTANCE_OclElement_parentEnv_Variable.evaluate(self_6);
			final /*@NonInvalid*/ @NonNull Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
			final /*@NonInvalid*/ @NonNull LookupEnvironment symbol_0 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
			CTORid_parentEnv.initValue(symbol_0, self_22);
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull Variable ownedSelfVar = self_6.getOwnedSelfVar();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull LookupEnvironment addElements = symbol_0.addElements(ownedSelfVar);
			return addElements;
		}

		public LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull ExpressionInOCL self_6, final /*@NonInvalid*/ @Nullable Object child_0) {
			return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_6, child_0});
		}
	}

	protected final @NonNull CACHE_ExpressionInOCL__unqualified_env_Variable INST_ExpressionInOCL__unqualified_env_Variable = new CACHE_ExpressionInOCL__unqualified_env_Variable();

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
			final /*@NonInvalid*/ @Nullable Object child_1 = (/*@NonInvalid*/ @Nullable Object)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull LookupEnvironment self_22 = INSTANCE_OclElement_parentEnv_Variable.evaluate(self_7);
			final /*@NonInvalid*/ @NonNull Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
			final /*@NonInvalid*/ @NonNull LookupEnvironment symbol_0 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
			CTORid_parentEnv.initValue(symbol_0, self_22);
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<Parameter> ownedParameters = self_7.getOwnedParameters();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull LookupEnvironment addElements = symbol_0.addElements(ownedParameters);
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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_3 = (/*@NonInvalid*/ @NonNull Object)sourceAndArgumentValues[0];
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
			final /*@Thrown*/ @Nullable Element self_22 = oclAsType.getAst();
			if (self_22 == null) {
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
			final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Variable = INSTANCE_OclElement_unqualified_env_Variable.evaluate(self_22);
			final /*@Thrown*/ @NonNull OrderedSetValue foundVariable = INSTANCE_Visitable__lookupVariable.evaluate(self_22, unqualified_env_Variable, vName_0);
			final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundVariable).booleanValue();
			/*@Thrown*/ @Nullable Variable IF_isEmpty;
			if (isEmpty) {
				IF_isEmpty = null;
			}
			else {
				final /*@Thrown*/ @Nullable Variable first = (@Nullable Variable)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundVariable);
				IF_isEmpty = first;
			}
			return IF_isEmpty;
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
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
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
					if (eq) {
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
			final /*@Thrown*/ @Nullable Boolean and;
			if (CAUGHT_isEmpty == ValueUtil.FALSE_VALUE) {
				and = ValueUtil.FALSE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_not;
				try {
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
					if (CAUGHT_eq_0 instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_eq_0;
					}
					final /*@Thrown*/ @Nullable Boolean not;
					if (CAUGHT_eq_0 == ValueUtil.FALSE_VALUE) {
						not = ValueUtil.TRUE_VALUE;
					}
					else {
						if (CAUGHT_eq_0 == ValueUtil.TRUE_VALUE) {
							not = ValueUtil.FALSE_VALUE;
						}
						else {
							not = null;
						}
					}
					CAUGHT_not = not;
				}
				catch (Exception e) {
					CAUGHT_not = ValueUtil.createInvalidValue(e);
				}
				if (CAUGHT_not == ValueUtil.FALSE_VALUE) {
					and = ValueUtil.FALSE_VALUE;
				}
				else {
					if (CAUGHT_isEmpty instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_isEmpty;
					}
					if (CAUGHT_not instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_not;
					}
					if (CAUGHT_not == null) {
						and = null;
					}
					else {
						and = ValueUtil.TRUE_VALUE;
					}
				}
			}
			if (and == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @NonNull OrderedSetValue IF_and;
			if (and) {
				if (env_0 == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
				}
				final /*@Thrown*/ @Nullable LookupEnvironment parentEnv_0 = env_0.getParentEnv();
				final /*@Thrown*/ @NonNull OrderedSetValue _lookupClass = INSTANCE_Visitable__lookupClass.evaluate(self_8, parentEnv_0, cName);
				IF_and = _lookupClass;
			}
			else {
				if (CAUGHT_foundClass instanceof InvalidValueException) {
					throw (InvalidValueException)CAUGHT_foundClass;
				}
				IF_and = (OrderedSetValue)CAUGHT_foundClass;
			}
			return IF_and;
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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_11 = (/*@NonInvalid*/ @NonNull Object)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, self_11);
			final /*@NonInvalid*/ boolean eq = parent == null;
			/*@Thrown*/ @NonNull LookupEnvironment IF_eq;
			if (eq) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
				final /*@NonInvalid*/ @NonNull LookupEnvironment symbol_0 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
				IF_eq = symbol_0;
			}
			else {
				if (parent == null) {
					throw new InvalidEvaluationException("Null source for \'ocl::OclElement::_unqualified_env_Class(OclElement) : lookup::LookupEnvironment[1]\'");
				}
				final /*@Thrown*/ @NonNull LookupEnvironment _unqualified_env_Class = INSTANCE_OclElement__unqualified_env_Class.evaluate(parent, self_11);
				IF_eq = _unqualified_env_Class;
			}
			return IF_eq;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_11) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_11});
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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_10 = (/*@NonInvalid*/ @NonNull Object)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_2 = (/*@NonInvalid*/ @Nullable Object)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull LookupEnvironment parentEnv_Class = INSTANCE_OclElement_parentEnv_Class.evaluate(self_10);
			return parentEnv_Class;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_10, final /*@NonInvalid*/ @Nullable Object child_2) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_10, child_2});
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
			@SuppressWarnings("null") final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package self_12 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_3 = (/*@NonInvalid*/ @Nullable Object)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull LookupEnvironment self_22 = INSTANCE_OclElement_parentEnv_Class.evaluate(self_12);
			final /*@NonInvalid*/ @NonNull Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
			final /*@NonInvalid*/ @NonNull LookupEnvironment symbol_0 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
			CTORid_parentEnv.initValue(symbol_0, self_22);
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = self_12.getOwnedClasses();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull LookupEnvironment addElements = symbol_0.addElements(ownedClasses);
			return addElements;
		}

		public LookupEnvironment evaluate(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package self_12, final /*@NonInvalid*/ @Nullable Object child_3) {
			return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_12, child_3});
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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_9 = (/*@NonInvalid*/ @NonNull Object)sourceAndArgumentValues[0];
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
					if (eq) {
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
			final /*@Thrown*/ @Nullable Boolean and;
			if (CAUGHT_isEmpty == ValueUtil.FALSE_VALUE) {
				and = ValueUtil.FALSE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_not;
				try {
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
					if (CAUGHT_eq_0 instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_eq_0;
					}
					final /*@Thrown*/ @Nullable Boolean not;
					if (CAUGHT_eq_0 == ValueUtil.FALSE_VALUE) {
						not = ValueUtil.TRUE_VALUE;
					}
					else {
						if (CAUGHT_eq_0 == ValueUtil.TRUE_VALUE) {
							not = ValueUtil.FALSE_VALUE;
						}
						else {
							not = null;
						}
					}
					CAUGHT_not = not;
				}
				catch (Exception e) {
					CAUGHT_not = ValueUtil.createInvalidValue(e);
				}
				if (CAUGHT_not == ValueUtil.FALSE_VALUE) {
					and = ValueUtil.FALSE_VALUE;
				}
				else {
					if (CAUGHT_isEmpty instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_isEmpty;
					}
					if (CAUGHT_not instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_not;
					}
					if (CAUGHT_not == null) {
						and = null;
					}
					else {
						and = ValueUtil.TRUE_VALUE;
					}
				}
			}
			if (and == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @NonNull OrderedSetValue IF_and;
			if (and) {
				if (env_1 == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
				}
				final /*@Thrown*/ @Nullable LookupEnvironment parentEnv_0 = env_1.getParentEnv();
				final /*@Thrown*/ @NonNull OrderedSetValue _lookupPackage = INSTANCE_Visitable__lookupPackage.evaluate(self_14, parentEnv_0, pName);
				IF_and = _lookupPackage;
			}
			else {
				if (CAUGHT_foundPackage instanceof InvalidValueException) {
					throw (InvalidValueException)CAUGHT_foundPackage;
				}
				IF_and = (OrderedSetValue)CAUGHT_foundPackage;
			}
			return IF_and;
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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_17 = (/*@NonInvalid*/ @NonNull Object)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, self_17);
			final /*@NonInvalid*/ boolean eq = parent == null;
			/*@Thrown*/ @NonNull LookupEnvironment IF_eq;
			if (eq) {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
				final /*@NonInvalid*/ @NonNull LookupEnvironment symbol_0 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
				IF_eq = symbol_0;
			}
			else {
				if (parent == null) {
					throw new InvalidEvaluationException("Null source for \'ocl::OclElement::_unqualified_env_Package(OclElement) : lookup::LookupEnvironment[1]\'");
				}
				final /*@Thrown*/ @NonNull LookupEnvironment _unqualified_env_Package = INSTANCE_OclElement__unqualified_env_Package.evaluate(parent, self_17);
				IF_eq = _unqualified_env_Package;
			}
			return IF_eq;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_17) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_17});
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
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_16 = (/*@NonInvalid*/ @NonNull Object)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_4 = (/*@NonInvalid*/ @Nullable Object)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull LookupEnvironment parentEnv_Package = INSTANCE_OclElement_parentEnv_Package.evaluate(self_16);
			return parentEnv_Package;
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_16, final /*@NonInvalid*/ @Nullable Object child_4) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_16, child_4});
		}
	}

	protected final @NonNull CACHE_OclElement__unqualified_env_Package INST_OclElement__unqualified_env_Package = new CACHE_OclElement__unqualified_env_Package();

	/**
	 * miniocl::Root::_unqualified_env_Package(child : OclElement[?]) : lookup::LookupEnvironment[?]
	 *
	 * parentEnv_Package().addElements(ownedPackages)
	 */
	public class CACHE_Root__unqualified_env_Package extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Root self_18 = (/*@NonInvalid*/ @NonNull Root)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_5 = (/*@NonInvalid*/ @Nullable Object)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull LookupEnvironment parentEnv_Package = INSTANCE_OclElement_parentEnv_Package.evaluate(self_18);
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Package> ownedPackages = self_18.getOwnedPackages();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull LookupEnvironment addElements = parentEnv_Package.addElements(ownedPackages);
			return addElements;
		}

		public LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Root self_18, final /*@NonInvalid*/ @Nullable Object child_5) {
			return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_18, child_5});
		}
	}

	protected final @NonNull CACHE_Root__unqualified_env_Package INST_Root__unqualified_env_Package = new CACHE_Root__unqualified_env_Package();

	/**
	 * miniocl::Package::_unqualified_env_Package(child : OclElement[?]) : lookup::LookupEnvironment[?]
	 *
	 * parentEnv_Package().nestedEnv().addElements(ownedPackages)
	 */
	public class CACHE_Package__unqualified_env_Package extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package self_19 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object child_6 = (/*@NonInvalid*/ @Nullable Object)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull LookupEnvironment self_22 = INSTANCE_OclElement_parentEnv_Package.evaluate(self_19);
			final /*@NonInvalid*/ @NonNull Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
			final /*@NonInvalid*/ @NonNull LookupEnvironment symbol_0 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
			CTORid_parentEnv.initValue(symbol_0, self_22);
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Package> ownedPackages = self_19.getOwnedPackages();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull LookupEnvironment addElements = symbol_0.addElements(ownedPackages);
			return addElements;
		}

		public LookupEnvironment evaluate(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Package self_19, final /*@NonInvalid*/ @Nullable Object child_6) {
			return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_19, child_6});
		}
	}

	protected final @NonNull CACHE_Package__unqualified_env_Package INST_Package__unqualified_env_Package = new CACHE_Package__unqualified_env_Package();

	/**
	 * ocl::OclElement::unqualified_env_Package() : lookup::LookupEnvironment[1]
	 *
	 * _unqualified_env_Package(null)
	 */
	public class CACHE_OclElement_unqualified_env_Package extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Object self_15 = (/*@NonInvalid*/ @NonNull Object)sourceAndArgumentValues[0];
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
	 *     qualifierSegments : OrderedSet(minioclcs::PathElementCS) = segments->subOrderedSet(1,
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
			@SuppressWarnings("unchecked") final /*@NonInvalid*/ @NonNull OrderedSetValue segments = (/*@NonInvalid*/ @NonNull OrderedSetValue)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(segments);
			final /*@NonInvalid*/ boolean eq = size.equals(INT_1);
			/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package IF_eq;
			if (eq) {
				final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(segments);
				if (aPathElementCS == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
				}
				final /*@Thrown*/ @Nullable String pName_1 = aPathElementCS.getElementName();
				final /*@NonInvalid*/ @NonNull LookupEnvironment unqualified_env_Package = INSTANCE_OclElement_unqualified_env_Package.evaluate(self_13);
				final /*@Thrown*/ @NonNull OrderedSetValue foundPackage = INSTANCE_Visitable__lookupPackage.evaluate(self_13, unqualified_env_Package, pName_1);
				final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundPackage).booleanValue();
				/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package IF_isEmpty;
				if (isEmpty) {
					IF_isEmpty = null;
				}
				else {
					final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package first = (org.eclipse.qvtd.doc.miniocl.@Nullable Package)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundPackage);
					IF_isEmpty = first;
				}
				IF_eq = IF_isEmpty;
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
					/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package IF_isEmpty_0;
					if (isEmpty_0) {
						IF_isEmpty_0 = null;
					}
					else {
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package first_0 = (org.eclipse.qvtd.doc.miniocl.@Nullable Package)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundPackage_0);
						IF_isEmpty_0 = first_0;
					}
					safe_lookupQualifiedPackage_source = IF_isEmpty_0;
				}
				IF_eq = safe_lookupQualifiedPackage_source;
			}
			return IF_eq;
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
					if (eq) {
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
			final /*@Thrown*/ @Nullable Boolean and;
			if (CAUGHT_isEmpty == ValueUtil.FALSE_VALUE) {
				and = ValueUtil.FALSE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_not;
				try {
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
					if (CAUGHT_eq_0 instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_eq_0;
					}
					final /*@Thrown*/ @Nullable Boolean not;
					if (CAUGHT_eq_0 == ValueUtil.FALSE_VALUE) {
						not = ValueUtil.TRUE_VALUE;
					}
					else {
						if (CAUGHT_eq_0 == ValueUtil.TRUE_VALUE) {
							not = ValueUtil.FALSE_VALUE;
						}
						else {
							not = null;
						}
					}
					CAUGHT_not = not;
				}
				catch (Exception e) {
					CAUGHT_not = ValueUtil.createInvalidValue(e);
				}
				if (CAUGHT_not == ValueUtil.FALSE_VALUE) {
					and = ValueUtil.FALSE_VALUE;
				}
				else {
					if (CAUGHT_isEmpty instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_isEmpty;
					}
					if (CAUGHT_not instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_not;
					}
					if (CAUGHT_not == null) {
						and = null;
					}
					else {
						and = ValueUtil.TRUE_VALUE;
					}
				}
			}
			if (and == null) {
				throw new InvalidEvaluationException("Null if condition");
			}
			/*@Thrown*/ @NonNull OrderedSetValue IF_and;
			if (and) {
				if (env_2 == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0\'::LookupEnvironment::parentEnv\'");
				}
				final /*@Thrown*/ @Nullable LookupEnvironment parentEnv_0 = env_2.getParentEnv();
				final /*@Thrown*/ @NonNull OrderedSetValue _lookupProperty = INSTANCE_Visitable__lookupProperty.evaluate(self_20, parentEnv_0, pName_0);
				IF_and = _lookupProperty;
			}
			else {
				if (CAUGHT_foundProperty instanceof InvalidValueException) {
					throw (InvalidValueException)CAUGHT_foundProperty;
				}
				IF_and = (OrderedSetValue)CAUGHT_foundProperty;
			}
			return IF_and;
		}

		@SuppressWarnings("null")
		public @NonNull OrderedSetValue evaluate(final /*@NonInvalid*/ @NonNull Visitable self_20, final /*@NonInvalid*/ @Nullable LookupEnvironment env_2, final /*@NonInvalid*/ @Nullable String pName_0) {
			return (@NonNull OrderedSetValue)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_20, env_2, pName_0});
		}
	}

	protected final @NonNull CACHE_Visitable__lookupProperty INSTANCE_Visitable__lookupProperty = new CACHE_Visitable__lookupProperty();

	/**
	 * miniocl::Class::_exported_env_Property(importer : OclElement[?]) : lookup::LookupEnvironment[?]
	 *
	 *
	 * let
	 *   superClasses : Set(miniocl::Class) = self->closure(superClasses)
	 * in
	 *   let env : lookup::LookupEnvironment[?] = lookup::LookupEnvironment{}
	 *   in env.addElements(ownedProperties)
	 */
	public class CACHE_Class__exported_env_Property extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class self_21 = (/*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ @Nullable Object importer = (/*@NonInvalid*/ @Nullable Object)sourceAndArgumentValues[1];
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
			final /*@NonInvalid*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Class, self_21);
			final org.eclipse.ocl.pivot.@NonNull Class TYPE_superClasses_1 = executor.getStaticClassOf(oclAsSet);
			final @NonNull LibraryIteration IMPL_superClasses_1 = (LibraryIteration)TYPE_superClasses_1.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
			final @NonNull Object ACC_superClasses_1 = IMPL_superClasses_1.createAccumulatorValue(executor, SET_CLSSid_Class_0, ORD_CLSSid_Class_0);
			/**
			 * Implementation of the iteration evaluation body.
			 */
			final @NonNull AbstractBinaryOperation BODY0_superClasses_2 = new AbstractBinaryOperation()
			{
				/**
				 * superClasses
				 */
				@Override
				public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ @Nullable Object _1) {
					final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class CAST_null = (org.eclipse.qvtd.doc.miniocl.Class)_1;
					if (CAST_null == null) {
						throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/1.0\'::Class::superClasses\'");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> superClasses_0 = CAST_null.getSuperClasses();
					final /*@Thrown*/ @NonNull OrderedSetValue BOXED_superClasses_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_Class_0, superClasses_0);
					return BOXED_superClasses_0;
				}
			};
			final @NonNull ExecutorSingleIterationManager MGR_superClasses_1 = new ExecutorSingleIterationManager(executor, SET_CLSSid_Class_0, BODY0_superClasses_2, oclAsSet, ACC_superClasses_1);
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull SetValue superClasses = (@NonNull SetValue)IMPL_superClasses_1.evaluateIteration(MGR_superClasses_1);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
			final /*@NonInvalid*/ @NonNull LookupEnvironment env_3 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ownedProperties = self_21.getOwnedProperties();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull LookupEnvironment addElements = env_3.addElements(ownedProperties);
			return addElements;
		}

		public LookupEnvironment evaluate(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class self_21, final /*@NonInvalid*/ @Nullable Object importer) {
			return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_21, importer});
		}
	}

	protected final @NonNull CACHE_Class__exported_env_Property INSTANCE_Class__exported_env_Property = new CACHE_Class__exported_env_Property();

	protected class VCACHE_OclElement__unqualified_env_Variable extends AbstractDispatchOperation
	{
		private VCACHE_OclElement__unqualified_env_Variable() {
			install(Object.class, INST_OclElement__unqualified_env_Variable);
			install(ExpressionInOCL.class, INST_ExpressionInOCL__unqualified_env_Variable);
			install(Operation.class, INST_Operation__unqualified_env_Variable);
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_4, final /*@NonInvalid*/ @Nullable Object child) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_4, child});
		}
	}

	protected final @NonNull VCACHE_OclElement__unqualified_env_Variable INSTANCE_OclElement__unqualified_env_Variable = new VCACHE_OclElement__unqualified_env_Variable();

	protected class VCACHE_OclElement__unqualified_env_Class extends AbstractDispatchOperation
	{
		private VCACHE_OclElement__unqualified_env_Class() {
			install(Object.class, INST_OclElement__unqualified_env_Class);
			install(org.eclipse.qvtd.doc.miniocl.Package.class, INST_Package__unqualified_env_Class);
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_10, final /*@NonInvalid*/ @Nullable Object child_2) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_10, child_2});
		}
	}

	protected final @NonNull VCACHE_OclElement__unqualified_env_Class INSTANCE_OclElement__unqualified_env_Class = new VCACHE_OclElement__unqualified_env_Class();

	protected class VCACHE_OclElement__unqualified_env_Package extends AbstractDispatchOperation
	{
		private VCACHE_OclElement__unqualified_env_Package() {
			install(Object.class, INST_OclElement__unqualified_env_Package);
			install(Root.class, INST_Root__unqualified_env_Package);
			install(org.eclipse.qvtd.doc.miniocl.Package.class, INST_Package__unqualified_env_Package);
		}

		@SuppressWarnings("null")
		public @NonNull LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Object self_16, final /*@NonInvalid*/ @Nullable Object child_4) {
			return (@NonNull LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{self_16, child_4});
		}
	}

	protected final @NonNull VCACHE_OclElement__unqualified_env_Package INSTANCE_OclElement__unqualified_env_Package = new VCACHE_OclElement__unqualified_env_Package();

	/**
	 *
	 * entry r_MiniOCLCS2AS_46_ocl__load__input leftCSinput _'$other$'output rightAS in MiniOCLCS2AS_qvtm_qvtcas {
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
	 * install mcClassCS__2__Class {
	 * lClassCS consumes append ji_ClassCS  : minioclcs::ClassCS[1];
	 * ;
	 * }
	 *   install mcNameExpCS__2__PropertyCallExp__1 {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
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
	 *   install mcParameterCS__2__Parameter {
	 * lParameterCS consumes append ji_ParameterCS  : minioclcs::ParameterCS[1];
	 * ;
	 * }
	 *   install mcPropertyCS__2__Property {
	 * lPropertyCS consumes append ji_PropertyCS  : minioclcs::PropertyCS[1];
	 * ;
	 * }
	 *   install mcRootCS__2__Root {
	 * lRootCS consumes append ji_RootCS  : minioclcs::RootCS[1];
	 * ;
	 * }
	 *   install muNavigationExpCS__ast {
	 * lNavigationExpCS consumes append ji_NavigationExpCS  : minioclcs::NavigationExpCS[1];
	 * ;
	 * }
	 *   install muClassCS__2__Class__name {
	 * lClassCS consumes append ji_ClassCS  : minioclcs::ClassCS[1];
	 * ;
	 * }
	 *   install muClassCS__2__Class__ownedOperations {
	 * lClassCS consumes append ji_ClassCS  : minioclcs::ClassCS[1];
	 * ;
	 * }
	 *   install muClassCS__2__Class__ownedProperties {
	 * lClassCS consumes append ji_ClassCS  : minioclcs::ClassCS[1];
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
	 *   install muPackageCS__2__Package__name {
	 * lPackageCS consumes append ji_PackageCS  : minioclcs::PackageCS[1];
	 * ;
	 * }
	 *   install muPackageCS__2__Package__ownedClasses {
	 * lPackageCS consumes append ji_PackageCS  : minioclcs::PackageCS[1];
	 * ;
	 * }
	 *   install muPackageCS__2__Package__ownedPackages {
	 * lPackageCS consumes append ji_PackageCS  : minioclcs::PackageCS[1];
	 * ;
	 * }
	 *   install muParameterCS__2__Parameter__name {
	 * lParameterCS consumes append ji_ParameterCS  : minioclcs::ParameterCS[1];
	 * ;
	 * }
	 *   install muPropertyCS__2__Property__name {
	 * lPropertyCS consumes append ji_PropertyCS  : minioclcs::PropertyCS[1];
	 * ;
	 * }
	 *   install muRootCS__2__Root__ownedPackages {
	 * lRootCS consumes append ji_RootCS  : minioclcs::RootCS[1];
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
	 *   install muNameExpCS__2__PropertyCallExp__0__ownedSource {
	 * lNameExpCS consumes append ji_NameExpCS  : minioclcs::NameExpCS[1];
	 * ;
	 * }
	 *   install muParameterCS__2__Parameter__type {
	 * lParameterCS consumes append ji_ParameterCS  : minioclcs::ParameterCS[1];
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
	 *   install muPropertyCS__2__Property__type {
	 * lPropertyCS consumes append ji_PropertyCS  : minioclcs::PropertyCS[1];
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
	 *   install muNameExpCS__2__PropertyCallExp__0__type {
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
	 *   install muOperationCS__2__Operation__ownedBodyExpression {
	 * lOperationCS consumes append ji_OperationCS  : minioclcs::OperationCS[1];
	 * ;
	 * }
	 */
	protected class MAP_r_MiniOCLCS2AS_46_ocl__load__ extends AbstractInvocation
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

		public MAP_r_MiniOCLCS2AS_46_ocl__load__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
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
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mcClassCS__2__Class") {
				@Override
				public boolean execute() {
					for (@NonNull ClassCS lClassCS_3 : ji_ClassCS.typedIterable(ClassCS.class)) {
						MAP_mcClassCS__2__Class(lClassCS_3);
					}
					return true;
				}
			};
			CTOR_mcNameExpCS__2__PropertyCallExp__1.addConsumedConnection(ji_NameExpCS);
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
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mcParameterCS__2__Parameter") {
				@Override
				public boolean execute() {
					for (@NonNull ParameterCS lParameterCS_2 : ji_ParameterCS.typedIterable(ParameterCS.class)) {
						MAP_mcParameterCS__2__Parameter(lParameterCS_2);
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
			new AbstractSimpleInvocation(lazyCreateInterval(1/*..null*/), "mcRootCS__2__Root") {
				@Override
				public boolean execute() {
					for (@NonNull RootCS lRootCS_1 : ji_RootCS.typedIterable(RootCS.class)) {
						MAP_mcRootCS__2__Root(lRootCS_1);
					}
					return true;
				}
			};
			CTOR_muNavigationExpCS__ast.addConsumedConnection(ji_NavigationExpCS);
			CTOR_muClassCS__2__Class__name.addConsumedConnection(ji_ClassCS);
			CTOR_muClassCS__2__Class__ownedOperations.addConsumedConnection(ji_ClassCS);
			CTOR_muClassCS__2__Class__ownedProperties.addConsumedConnection(ji_ClassCS);
			CTOR_muOperationCS__2__Operation__name.addConsumedConnection(ji_OperationCS);
			CTOR_muOperationCS__2__Operation__ownedParameters.addConsumedConnection(ji_OperationCS);
			CTOR_muPackageCS__2__Package__name.addConsumedConnection(ji_PackageCS);
			CTOR_muPackageCS__2__Package__ownedClasses.addConsumedConnection(ji_PackageCS);
			CTOR_muPackageCS__2__Package__ownedPackages.addConsumedConnection(ji_PackageCS);
			CTOR_muParameterCS__2__Parameter__name.addConsumedConnection(ji_ParameterCS);
			CTOR_muPropertyCS__2__Property__name.addConsumedConnection(ji_PropertyCS);
			CTOR_muRootCS__2__Root__ownedPackages.addConsumedConnection(ji_RootCS);
			CTOR_mcNameExpCS__2__PropertyCallExp__0.addConsumedConnection(ji_NameExpCS);
			CTOR_mcNameExpCS__2__VariableExp__1.addConsumedConnection(ji_NameExpCS);
			CTOR_muCallExpCS__ast.addConsumedConnection(ji_CallExpCS);
			CTOR_muNameExpCS__2__PropertyCallExp__1__ownedSource.addConsumedConnection(ji_NameExpCS);
			CTOR_muNameExpCS__2__PropertyCallExp__0__ownedSource.addConsumedConnection(ji_NameExpCS);
			new AbstractSimpleInvocation(lazyCreateInterval(5/*..null*/), "muParameterCS__2__Parameter__type") {
				@Override
				public boolean execute() {
					for (@NonNull ParameterCS lParameterCS_4 : ji_ParameterCS.typedIterable(ParameterCS.class)) {
						MAP_muParameterCS__2__Parameter__type(lParameterCS_4);
					}
					return true;
				}
			};
			CTOR_muNameExpCS__2__VariableExp__1__referredVariable.addConsumedConnection(ji_NameExpCS);
			new AbstractSimpleInvocation(lazyCreateInterval(6/*..null*/), "muOperationCS__2__Operation__type") {
				@Override
				public boolean execute() {
					for (@NonNull OperationCS lOperationCS_7 : ji_OperationCS.typedIterable(OperationCS.class)) {
						MAP_muOperationCS__2__Operation__type(lOperationCS_7);
					}
					return true;
				}
			};
			new AbstractSimpleInvocation(lazyCreateInterval(6/*..null*/), "muPropertyCS__2__Property__type") {
				@Override
				public boolean execute() {
					for (@NonNull PropertyCS lPropertyCS_4 : ji_PropertyCS.typedIterable(PropertyCS.class)) {
						MAP_muPropertyCS__2__Property__type(lPropertyCS_4);
					}
					return true;
				}
			};
			CTOR_muNameExpCS__2__VariableExp__1__type.addConsumedConnection(ji_NameExpCS);
			CTOR_muNameExpCS__2__PropertyCallExp__0__referredPropert.addConsumedConnection(ji_NameExpCS);
			CTOR_muNameExpCS__2__PropertyCallExp__0__type.addConsumedConnection(ji_NameExpCS);
			CTOR_muNameExpCS__2__PropertyCallExp__1__referredPropert.addConsumedConnection(ji_NameExpCS);
			CTOR_muNameExpCS__2__PropertyCallExp__1__type.addConsumedConnection(ji_NameExpCS);
			new AbstractSimpleInvocation(lazyCreateInterval(9/*..null*/), "muOperationCS__2__Operation__ownedBodyExpression") {
				@Override
				public boolean execute() {
					for (@NonNull OperationCS lOperationCS_8 : ji_OperationCS.typedIterable(OperationCS.class)) {
						MAP_muOperationCS__2__Operation__ownedBodyExpression(lOperationCS_8);
					}
					return true;
				}
			};
			final /*@Thrown*/ @Nullable Boolean r_MiniOCLCS2AS_46_ocl__load__ = ValueUtil.TRUE_VALUE;
			return r_MiniOCLCS2AS_46_ocl__load__;
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
	 * map:1 mcClassCS__2__Class in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lClassCS : minioclcs::ClassCS[1];
	 * new:rightAS rClass : miniocl::Class[1];
	 * set lClassCS.ast := rClass;
	 *
	 */
	protected boolean MAP_mcClassCS__2__Class(final /*@NonInvalid*/ @NonNull ClassCS lClassCS)  {
		// creations
		final @SuppressWarnings("null")org.eclipse.qvtd.doc.miniocl.@NonNull Class rClass = MiniOCLFactory.eINSTANCE.createClass();
		models[3/*rightAS*/].add(rClass, false);
		// mapping statements
		lClassCS.setAst(rClass);
		final /*@Thrown*/ @Nullable Boolean mcClassCS__2__Class = ValueUtil.TRUE_VALUE;
		return mcClassCS__2__Class;
	}

	/**
	 *
	 * strict map:1 mcNameExpCS__2__PropertyCallExp__1 in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource();
	 * check isPropCallExpWithExplicitSource;
	 * new:rightAS rPropertyCallExp : miniocl::PropertyCallExp[1];
	 * notify set lNameExpCS.ast := rPropertyCallExp;
	 *
	 */
	protected class MAP_mcNameExpCS__2__PropertyCallExp__1 extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS;

		public MAP_mcNameExpCS__2__PropertyCallExp__1(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS = (@NonNull NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS.getRoundedBrackets();
			final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
			final /*@Thrown*/ @Nullable Boolean and;
			if (!eq) {
				and = ValueUtil.FALSE_VALUE;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_IF_eq_0;
				try {
					final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS);
					final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
					/*@Thrown*/ boolean IF_eq_0;
					if (eq_0) {
						IF_eq_0 = false;
					}
					else {
						if (parentCallExpCS == null) {
							throw throwNull(lNameExpCS, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
						}
						final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
						final /*@Thrown*/ boolean eq_1 = lNameExpCS.equals(navExp);
						IF_eq_0 = eq_1;
					}
					CAUGHT_IF_eq_0 = IF_eq_0;
				}
				catch (Exception e) {
					CAUGHT_IF_eq_0 = ValueUtil.createInvalidValue(e);
				}
				if (CAUGHT_IF_eq_0 == ValueUtil.FALSE_VALUE) {
					and = ValueUtil.FALSE_VALUE;
				}
				else {
					if (CAUGHT_IF_eq_0 instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_IF_eq_0;
					}
					and = ValueUtil.TRUE_VALUE;
				}
			}
			if (and == null) {
				throw throwNull(lNameExpCS, "Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean IF_and;
			if (and) {
				// creations
				final @SuppressWarnings("null")@NonNull PropertyCallExp rPropertyCallExp = MiniOCLFactory.eINSTANCE.createPropertyCallExp();
				models[3/*rightAS*/].add(rPropertyCallExp, false);
				// mapping statements
				lNameExpCS.setAst(rPropertyCallExp);
				objectManager.assigned(lNameExpCS, MinioclcsPackage.Literals.CS_TRACE__AST, rPropertyCallExp, false);
				final /*@Thrown*/ @Nullable Boolean mcNameExpCS__2__PropertyCallExp__1 = ValueUtil.TRUE_VALUE;
				IF_and = mcNameExpCS__2__PropertyCallExp__1;
			}
			else {
				IF_and = ValueUtil.FALSE_VALUE;
			}
			return IF_and;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS, thoseValues[0]);
		}
	}

	/**
	 *
	 * map:1 mcOperationCS__2__Operation in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lOperationCS : minioclcs::OperationCS[1];
	 * new:rightAS rOperation : miniocl::Operation[1];
	 * set lOperationCS.ast := rOperation;
	 *
	 */
	protected boolean MAP_mcOperationCS__2__Operation(final /*@NonInvalid*/ @NonNull OperationCS lOperationCS)  {
		// creations
		final @SuppressWarnings("null")@NonNull Operation rOperation = MiniOCLFactory.eINSTANCE.createOperation();
		models[3/*rightAS*/].add(rOperation, false);
		// mapping statements
		lOperationCS.setAst(rOperation);
		final /*@Thrown*/ @Nullable Boolean mcOperationCS__2__Operation = ValueUtil.TRUE_VALUE;
		return mcOperationCS__2__Operation;
	}

	/**
	 *
	 * map:1 mcPackageCS__2__Package in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lPackageCS : minioclcs::PackageCS[1];
	 * new:rightAS rPackage : miniocl::Package[1];
	 * set lPackageCS.ast := rPackage;
	 *
	 */
	protected boolean MAP_mcPackageCS__2__Package(final /*@NonInvalid*/ @NonNull PackageCS lPackageCS)  {
		// creations
		final @SuppressWarnings("null")org.eclipse.qvtd.doc.miniocl.@NonNull Package rPackage = MiniOCLFactory.eINSTANCE.createPackage();
		models[3/*rightAS*/].add(rPackage, false);
		// mapping statements
		lPackageCS.setAst(rPackage);
		final /*@Thrown*/ @Nullable Boolean mcPackageCS__2__Package = ValueUtil.TRUE_VALUE;
		return mcPackageCS__2__Package;
	}

	/**
	 *
	 * map:1 mcParameterCS__2__Parameter in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lParameterCS : minioclcs::ParameterCS[1];
	 * new:rightAS rParameter : miniocl::Parameter[1];
	 * set lParameterCS.ast := rParameter;
	 *
	 */
	protected boolean MAP_mcParameterCS__2__Parameter(final /*@NonInvalid*/ @NonNull ParameterCS lParameterCS)  {
		// creations
		final @SuppressWarnings("null")@NonNull Parameter rParameter = MiniOCLFactory.eINSTANCE.createParameter();
		models[3/*rightAS*/].add(rParameter, false);
		// mapping statements
		lParameterCS.setAst(rParameter);
		final /*@Thrown*/ @Nullable Boolean mcParameterCS__2__Parameter = ValueUtil.TRUE_VALUE;
		return mcParameterCS__2__Parameter;
	}

	/**
	 *
	 * map:1 mcPropertyCS__2__Property in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lPropertyCS : minioclcs::PropertyCS[1];
	 * new:rightAS rProperty : miniocl::Property[1];
	 * set lPropertyCS.ast := rProperty;
	 *
	 */
	protected boolean MAP_mcPropertyCS__2__Property(final /*@NonInvalid*/ @NonNull PropertyCS lPropertyCS)  {
		// creations
		final @SuppressWarnings("null")org.eclipse.qvtd.doc.miniocl.@NonNull Property rProperty = MiniOCLFactory.eINSTANCE.createProperty();
		models[3/*rightAS*/].add(rProperty, false);
		// mapping statements
		lPropertyCS.setAst(rProperty);
		final /*@Thrown*/ @Nullable Boolean mcPropertyCS__2__Property = ValueUtil.TRUE_VALUE;
		return mcPropertyCS__2__Property;
	}

	/**
	 *
	 * map:1 mcRootCS__2__Root in MiniOCLCS2AS_qvtm_qvtcas {
	 * guard:leftCS lRootCS : minioclcs::RootCS[1];
	 * new:rightAS rRoot : miniocl::Root[1];
	 * set lRootCS.ast := rRoot;
	 *
	 */
	protected boolean MAP_mcRootCS__2__Root(final /*@NonInvalid*/ @NonNull RootCS lRootCS)  {
		// creations
		final @SuppressWarnings("null")@NonNull Root rRoot = MiniOCLFactory.eINSTANCE.createRoot();
		models[3/*rightAS*/].add(rRoot, false);
		// mapping statements
		lRootCS.setAst(rRoot);
		final /*@Thrown*/ @Nullable Boolean mcRootCS__2__Root = ValueUtil.TRUE_VALUE;
		return mcRootCS__2__Root;
	}

	/**
	 *
	 * strict map:1 muNavigationExpCS__ast in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNavigationExpCS : minioclcs::NavigationExpCS[1];
	 * var oclIsTypeOf : Boolean[1] := lNavigationExpCS.oclIsTypeOf(minioclcs::NavigationExpCS);
	 * check oclIsTypeOf;
	 * notify set lNavigationExpCS.ast := null;
	 *
	 */
	protected class MAP_muNavigationExpCS__ast extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NavigationExpCS lNavigationExpCS;

		public MAP_muNavigationExpCS__ast(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNavigationExpCS = (@NonNull NavigationExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_minioclcs_c_c_NavigationExpCS_0 = idResolver.getClass(CLSSid_NavigationExpCS, null);
			final /*@NonInvalid*/ boolean oclIsTypeOf = OclAnyOclIsTypeOfOperation.INSTANCE.evaluate(executor, lNavigationExpCS, TYP_minioclcs_c_c_NavigationExpCS_0).booleanValue();
			/*@Thrown*/ @Nullable Boolean IF_oclIsTypeOf;
			if (oclIsTypeOf) {
				// mapping statements
				lNavigationExpCS.setAst(null);
				objectManager.assigned(lNavigationExpCS, MinioclcsPackage.Literals.CS_TRACE__AST, null, false);
				final /*@Thrown*/ @Nullable Boolean muNavigationExpCS__ast = ValueUtil.TRUE_VALUE;
				IF_oclIsTypeOf = muNavigationExpCS__ast;
			}
			else {
				IF_oclIsTypeOf = ValueUtil.FALSE_VALUE;
			}
			return IF_oclIsTypeOf;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNavigationExpCS, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:2 muClassCS__2__Class__name in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lClassCS : minioclcs::ClassCS[1];
	 * check var ast : miniocl::Class[?] := lClassCS.ast;
	 * var name : String[?] := lClassCS.name;
	 * var toString : String[1] := name.toString();
	 * set ast.name := toString;
	 *
	 */
	protected class MAP_muClassCS__2__Class__name extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull ClassCS lClassCS_0;

		public MAP_muClassCS__2__Class__name(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lClassCS_0 = (@NonNull ClassCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @Nullable Element temp1_ast = lClassCS_0.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof org.eclipse.qvtd.doc.miniocl.Class;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class CAST_temp1_ast = (org.eclipse.qvtd.doc.miniocl.Class)temp1_ast;
				final /*@NonInvalid*/ @Nullable String name = lClassCS_0.getName();
				final /*@Thrown*/ @NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
				// mapping statements
				CAST_temp1_ast.setName(toString);
				final /*@Thrown*/ @Nullable Boolean muClassCS__2__Class__name = ValueUtil.TRUE_VALUE;
				IF_symbol_0 = muClassCS__2__Class__name;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lClassCS_0, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:2 muClassCS__2__Class__ownedOperations in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lClassCS : minioclcs::ClassCS[1];
	 * check var ast : miniocl::Class[?] := lClassCS.ast;
	 * var operations : OrderedSet(minioclcs::OperationCS) := lClassCS.operations;
	 * check var collect : Sequence(miniocl::Operation) := operations->collect(i | i.ast)
	 *   ;
	 * var asOrderedSet : OrderedSet(miniocl::Operation) := collect->asOrderedSet();
	 * set ast.ownedOperations := asOrderedSet;
	 *
	 */
	protected class MAP_muClassCS__2__Class__ownedOperations extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull ClassCS lClassCS_1;

		public MAP_muClassCS__2__Class__ownedOperations(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lClassCS_1 = (@NonNull ClassCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Element temp1_ast = lClassCS_1.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof org.eclipse.qvtd.doc.miniocl.Class;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class CAST_temp1_ast = (org.eclipse.qvtd.doc.miniocl.Class)temp1_ast;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<OperationCS> operations = lClassCS_1.getOperations();
				final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_operations = idResolver.createOrderedSetOfAll(ORD_CLSSid_OperationCS, operations);
				/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Element);
				@NonNull Iterator<Object> ITERATOR_i = BOXED_operations.iterator();
				/*@Thrown*/ @NonNull SequenceValue temp1_collect;
				while (true) {
					if (!ITERATOR_i.hasNext()) {
						temp1_collect = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull OperationCS i = (@NonNull OperationCS)ITERATOR_i.next();
					/**
					 * i.ast
					 */
					final /*@NonInvalid*/ @Nullable Element ast = i.getAst();
					//
					accumulator.add(ast);
				}
				final /*@NonInvalid*/ boolean symbol_1 = temp1_collect instanceof SequenceValue;
				/*@Thrown*/ @Nullable Boolean IF_symbol_1;
				if (symbol_1) {
					final /*@Thrown*/ @NonNull SequenceValue CAST_temp1_collect = (SequenceValue)temp1_collect;
					final /*@Thrown*/ @NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(CAST_temp1_collect);
					// mapping statements
					final /*@Thrown*/ @NonNull List<Operation> ECORE_asOrderedSet = idResolver.ecoreValueOfAll(Operation.class, asOrderedSet);
					CAST_temp1_ast.getOwnedOperations().addAll(ECORE_asOrderedSet);
					final /*@Thrown*/ @Nullable Boolean muClassCS__2__Class__ownedOperations = ValueUtil.TRUE_VALUE;
					IF_symbol_1 = muClassCS__2__Class__ownedOperations;
				}
				else {
					IF_symbol_1 = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_symbol_1;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lClassCS_1, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:2 muClassCS__2__Class__ownedProperties in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lClassCS : minioclcs::ClassCS[1];
	 * check var ast : miniocl::Class[?] := lClassCS.ast;
	 * var properties : OrderedSet(minioclcs::PropertyCS) := lClassCS.properties;
	 * check var collect : Sequence(miniocl::Property) := properties->collect(i | i.ast)
	 *   ;
	 * var asOrderedSet : OrderedSet(miniocl::Property) := collect->asOrderedSet();
	 * set ast.ownedProperties := asOrderedSet;
	 *
	 */
	protected class MAP_muClassCS__2__Class__ownedProperties extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull ClassCS lClassCS_2;

		public MAP_muClassCS__2__Class__ownedProperties(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lClassCS_2 = (@NonNull ClassCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Element temp1_ast = lClassCS_2.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof org.eclipse.qvtd.doc.miniocl.Class;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class CAST_temp1_ast = (org.eclipse.qvtd.doc.miniocl.Class)temp1_ast;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<PropertyCS> properties = lClassCS_2.getProperties();
				final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_properties = idResolver.createOrderedSetOfAll(ORD_CLSSid_PropertyCS, properties);
				/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Element);
				@NonNull Iterator<Object> ITERATOR_i = BOXED_properties.iterator();
				/*@Thrown*/ @NonNull SequenceValue temp1_collect;
				while (true) {
					if (!ITERATOR_i.hasNext()) {
						temp1_collect = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull PropertyCS i = (@NonNull PropertyCS)ITERATOR_i.next();
					/**
					 * i.ast
					 */
					final /*@NonInvalid*/ @Nullable Element ast = i.getAst();
					//
					accumulator.add(ast);
				}
				final /*@NonInvalid*/ boolean symbol_1 = temp1_collect instanceof SequenceValue;
				/*@Thrown*/ @Nullable Boolean IF_symbol_1;
				if (symbol_1) {
					final /*@Thrown*/ @NonNull SequenceValue CAST_temp1_collect = (SequenceValue)temp1_collect;
					final /*@Thrown*/ @NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(CAST_temp1_collect);
					// mapping statements
					final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ECORE_asOrderedSet = idResolver.ecoreValueOfAll(org.eclipse.qvtd.doc.miniocl.Property.class, asOrderedSet);
					CAST_temp1_ast.getOwnedProperties().addAll(ECORE_asOrderedSet);
					final /*@Thrown*/ @Nullable Boolean muClassCS__2__Class__ownedProperties = ValueUtil.TRUE_VALUE;
					IF_symbol_1 = muClassCS__2__Class__ownedProperties;
				}
				else {
					IF_symbol_1 = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_symbol_1;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lClassCS_2, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:2 muOperationCS__2__Operation__name in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lOperationCS : minioclcs::OperationCS[1];
	 * check var ast : miniocl::Operation[?] := lOperationCS.ast;
	 * var name : String[?] := lOperationCS.name;
	 * var toString : String[1] := name.toString();
	 * set ast.name := toString;
	 *
	 */
	protected class MAP_muOperationCS__2__Operation__name extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull OperationCS lOperationCS_0;

		public MAP_muOperationCS__2__Operation__name(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lOperationCS_0 = (@NonNull OperationCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @Nullable Element temp1_ast = lOperationCS_0.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof Operation;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @Nullable Operation CAST_temp1_ast = (Operation)temp1_ast;
				final /*@NonInvalid*/ @Nullable String name = lOperationCS_0.getName();
				final /*@Thrown*/ @NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
				// mapping statements
				CAST_temp1_ast.setName(toString);
				final /*@Thrown*/ @Nullable Boolean muOperationCS__2__Operation__name = ValueUtil.TRUE_VALUE;
				IF_symbol_0 = muOperationCS__2__Operation__name;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lOperationCS_0, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:2 muOperationCS__2__Operation__ownedParameters in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lOperationCS : minioclcs::OperationCS[1];
	 * check var ast : miniocl::Operation[?] := lOperationCS.ast;
	 * var params : OrderedSet(minioclcs::ParameterCS) := lOperationCS.params;
	 * check var collect : Sequence(miniocl::Parameter) := params->collect(i | i.ast)
	 *   ;
	 * var asOrderedSet : OrderedSet(miniocl::Parameter) := collect->asOrderedSet();
	 * set ast.ownedParameters := asOrderedSet;
	 *
	 */
	protected class MAP_muOperationCS__2__Operation__ownedParameters extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull OperationCS lOperationCS_1;

		public MAP_muOperationCS__2__Operation__ownedParameters(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lOperationCS_1 = (@NonNull OperationCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Element temp1_ast = lOperationCS_1.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof Operation;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @Nullable Operation CAST_temp1_ast = (Operation)temp1_ast;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<ParameterCS> params = lOperationCS_1.getParams();
				final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_params = idResolver.createOrderedSetOfAll(ORD_CLSSid_ParameterCS, params);
				/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Element);
				@NonNull Iterator<Object> ITERATOR_i = BOXED_params.iterator();
				/*@Thrown*/ @NonNull SequenceValue temp1_collect;
				while (true) {
					if (!ITERATOR_i.hasNext()) {
						temp1_collect = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull ParameterCS i = (@NonNull ParameterCS)ITERATOR_i.next();
					/**
					 * i.ast
					 */
					final /*@NonInvalid*/ @Nullable Element ast = i.getAst();
					//
					accumulator.add(ast);
				}
				final /*@NonInvalid*/ boolean symbol_1 = temp1_collect instanceof SequenceValue;
				/*@Thrown*/ @Nullable Boolean IF_symbol_1;
				if (symbol_1) {
					final /*@Thrown*/ @NonNull SequenceValue CAST_temp1_collect = (SequenceValue)temp1_collect;
					final /*@Thrown*/ @NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(CAST_temp1_collect);
					// mapping statements
					final /*@Thrown*/ @NonNull List<Parameter> ECORE_asOrderedSet = idResolver.ecoreValueOfAll(Parameter.class, asOrderedSet);
					CAST_temp1_ast.getOwnedParameters().addAll(ECORE_asOrderedSet);
					final /*@Thrown*/ @Nullable Boolean muOperationCS__2__Operation__ownedParameters = ValueUtil.TRUE_VALUE;
					IF_symbol_1 = muOperationCS__2__Operation__ownedParameters;
				}
				else {
					IF_symbol_1 = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_symbol_1;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lOperationCS_1, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:2 muPackageCS__2__Package__name in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lPackageCS : minioclcs::PackageCS[1];
	 * check var ast : miniocl::Package[?] := lPackageCS.ast;
	 * var name : String[?] := lPackageCS.name;
	 * var toString : String[1] := name.toString();
	 * set ast.name := toString;
	 *
	 */
	protected class MAP_muPackageCS__2__Package__name extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull PackageCS lPackageCS_0;

		public MAP_muPackageCS__2__Package__name(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lPackageCS_0 = (@NonNull PackageCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @Nullable Element temp1_ast = lPackageCS_0.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof org.eclipse.qvtd.doc.miniocl.Package;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package CAST_temp1_ast = (org.eclipse.qvtd.doc.miniocl.Package)temp1_ast;
				final /*@NonInvalid*/ @Nullable String name = lPackageCS_0.getName();
				final /*@Thrown*/ @NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
				// mapping statements
				CAST_temp1_ast.setName(toString);
				final /*@Thrown*/ @Nullable Boolean muPackageCS__2__Package__name = ValueUtil.TRUE_VALUE;
				IF_symbol_0 = muPackageCS__2__Package__name;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lPackageCS_0, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:2 muPackageCS__2__Package__ownedClasses in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lPackageCS : minioclcs::PackageCS[1];
	 * check var ast : miniocl::Package[?] := lPackageCS.ast;
	 * var classes : OrderedSet(minioclcs::ClassCS) := lPackageCS.classes;
	 * check var collect : Sequence(miniocl::Class) := classes->collect(i | i.ast)
	 *   ;
	 * var asOrderedSet : OrderedSet(miniocl::Class) := collect->asOrderedSet();
	 * set ast.ownedClasses := asOrderedSet;
	 *
	 */
	protected class MAP_muPackageCS__2__Package__ownedClasses extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull PackageCS lPackageCS_1;

		public MAP_muPackageCS__2__Package__ownedClasses(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lPackageCS_1 = (@NonNull PackageCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Element temp1_ast = lPackageCS_1.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof org.eclipse.qvtd.doc.miniocl.Package;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package CAST_temp1_ast = (org.eclipse.qvtd.doc.miniocl.Package)temp1_ast;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<ClassCS> classes = lPackageCS_1.getClasses();
				final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_classes = idResolver.createOrderedSetOfAll(ORD_CLSSid_ClassCS, classes);
				/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Element);
				@NonNull Iterator<Object> ITERATOR_i = BOXED_classes.iterator();
				/*@Thrown*/ @NonNull SequenceValue temp1_collect;
				while (true) {
					if (!ITERATOR_i.hasNext()) {
						temp1_collect = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull ClassCS i = (@NonNull ClassCS)ITERATOR_i.next();
					/**
					 * i.ast
					 */
					final /*@NonInvalid*/ @Nullable Element ast = i.getAst();
					//
					accumulator.add(ast);
				}
				final /*@NonInvalid*/ boolean symbol_1 = temp1_collect instanceof SequenceValue;
				/*@Thrown*/ @Nullable Boolean IF_symbol_1;
				if (symbol_1) {
					final /*@Thrown*/ @NonNull SequenceValue CAST_temp1_collect = (SequenceValue)temp1_collect;
					final /*@Thrown*/ @NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(CAST_temp1_collect);
					// mapping statements
					final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ECORE_asOrderedSet = idResolver.ecoreValueOfAll(org.eclipse.qvtd.doc.miniocl.Class.class, asOrderedSet);
					CAST_temp1_ast.getOwnedClasses().addAll(ECORE_asOrderedSet);
					final /*@Thrown*/ @Nullable Boolean muPackageCS__2__Package__ownedClasses = ValueUtil.TRUE_VALUE;
					IF_symbol_1 = muPackageCS__2__Package__ownedClasses;
				}
				else {
					IF_symbol_1 = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_symbol_1;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lPackageCS_1, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:2 muPackageCS__2__Package__ownedPackages in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lPackageCS : minioclcs::PackageCS[1];
	 * check var ast : miniocl::Package[?] := lPackageCS.ast;
	 * var packages : OrderedSet(minioclcs::PackageCS) := lPackageCS.packages;
	 * check var collect : Sequence(miniocl::Package) := packages->collect(i | i.ast)
	 *   ;
	 * var asOrderedSet : OrderedSet(miniocl::Package) := collect->asOrderedSet();
	 * set ast.ownedPackages := asOrderedSet;
	 *
	 */
	protected class MAP_muPackageCS__2__Package__ownedPackages extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull PackageCS lPackageCS_2;

		public MAP_muPackageCS__2__Package__ownedPackages(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lPackageCS_2 = (@NonNull PackageCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Element temp1_ast = lPackageCS_2.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof org.eclipse.qvtd.doc.miniocl.Package;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package CAST_temp1_ast = (org.eclipse.qvtd.doc.miniocl.Package)temp1_ast;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<PackageCS> packages = lPackageCS_2.getPackages();
				final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_packages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, packages);
				/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Element);
				@NonNull Iterator<Object> ITERATOR_i = BOXED_packages.iterator();
				/*@Thrown*/ @NonNull SequenceValue temp1_collect;
				while (true) {
					if (!ITERATOR_i.hasNext()) {
						temp1_collect = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull PackageCS i = (@NonNull PackageCS)ITERATOR_i.next();
					/**
					 * i.ast
					 */
					final /*@NonInvalid*/ @Nullable Element ast = i.getAst();
					//
					accumulator.add(ast);
				}
				final /*@NonInvalid*/ boolean symbol_1 = temp1_collect instanceof SequenceValue;
				/*@Thrown*/ @Nullable Boolean IF_symbol_1;
				if (symbol_1) {
					final /*@Thrown*/ @NonNull SequenceValue CAST_temp1_collect = (SequenceValue)temp1_collect;
					final /*@Thrown*/ @NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(CAST_temp1_collect);
					// mapping statements
					final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Package> ECORE_asOrderedSet = idResolver.ecoreValueOfAll(org.eclipse.qvtd.doc.miniocl.Package.class, asOrderedSet);
					CAST_temp1_ast.getOwnedPackages().addAll(ECORE_asOrderedSet);
					final /*@Thrown*/ @Nullable Boolean muPackageCS__2__Package__ownedPackages = ValueUtil.TRUE_VALUE;
					IF_symbol_1 = muPackageCS__2__Package__ownedPackages;
				}
				else {
					IF_symbol_1 = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_symbol_1;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lPackageCS_2, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:2 muParameterCS__2__Parameter__name in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lParameterCS : minioclcs::ParameterCS[1];
	 * check var ast : miniocl::Parameter[?] := lParameterCS.ast;
	 * var name : String[?] := lParameterCS.name;
	 * var toString : String[1] := name.toString();
	 * set ast.name := toString;
	 *
	 */
	protected class MAP_muParameterCS__2__Parameter__name extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull ParameterCS lParameterCS_0;

		public MAP_muParameterCS__2__Parameter__name(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lParameterCS_0 = (@NonNull ParameterCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @Nullable Element temp1_ast = lParameterCS_0.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof Parameter;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @Nullable Parameter CAST_temp1_ast = (Parameter)temp1_ast;
				final /*@NonInvalid*/ @Nullable String name = lParameterCS_0.getName();
				final /*@Thrown*/ @NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
				// mapping statements
				CAST_temp1_ast.setName(toString);
				final /*@Thrown*/ @Nullable Boolean muParameterCS__2__Parameter__name = ValueUtil.TRUE_VALUE;
				IF_symbol_0 = muParameterCS__2__Parameter__name;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lParameterCS_0, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:2 muPropertyCS__2__Property__name in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lPropertyCS : minioclcs::PropertyCS[1];
	 * check var ast : miniocl::Property[?] := lPropertyCS.ast;
	 * var name : String[?] := lPropertyCS.name;
	 * var toString : String[1] := name.toString();
	 * set ast.name := toString;
	 *
	 */
	protected class MAP_muPropertyCS__2__Property__name extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull PropertyCS lPropertyCS_0;

		public MAP_muPropertyCS__2__Property__name(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lPropertyCS_0 = (@NonNull PropertyCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @Nullable Element temp1_ast = lPropertyCS_0.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof org.eclipse.qvtd.doc.miniocl.Property;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property CAST_temp1_ast = (org.eclipse.qvtd.doc.miniocl.Property)temp1_ast;
				final /*@NonInvalid*/ @Nullable String name = lPropertyCS_0.getName();
				final /*@Thrown*/ @NonNull String toString = OclAnyToStringOperation.INSTANCE.evaluate(name);
				// mapping statements
				CAST_temp1_ast.setName(toString);
				final /*@Thrown*/ @Nullable Boolean muPropertyCS__2__Property__name = ValueUtil.TRUE_VALUE;
				IF_symbol_0 = muPropertyCS__2__Property__name;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lPropertyCS_0, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:2 muRootCS__2__Root__ownedPackages in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lRootCS : minioclcs::RootCS[1];
	 * check var ast : miniocl::Root[?] := lRootCS.ast;
	 * var packages : OrderedSet(minioclcs::PackageCS) := lRootCS.packages;
	 * check var collect : Sequence(miniocl::Package) := packages->collect(i | i.ast)
	 *   ;
	 * var asOrderedSet : OrderedSet(miniocl::Package) := collect->asOrderedSet();
	 * set ast.ownedPackages := asOrderedSet;
	 *
	 */
	protected class MAP_muRootCS__2__Root__ownedPackages extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull RootCS lRootCS_0;

		public MAP_muRootCS__2__Root__ownedPackages(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lRootCS_0 = (@NonNull RootCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Element temp1_ast = lRootCS_0.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof Root;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @Nullable Root CAST_temp1_ast = (Root)temp1_ast;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<PackageCS> packages = lRootCS_0.getPackages();
				final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_packages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, packages);
				/*@Thrown*/ SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Element);
				@NonNull Iterator<Object> ITERATOR_i = BOXED_packages.iterator();
				/*@Thrown*/ @NonNull SequenceValue temp1_collect;
				while (true) {
					if (!ITERATOR_i.hasNext()) {
						temp1_collect = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull PackageCS i = (@NonNull PackageCS)ITERATOR_i.next();
					/**
					 * i.ast
					 */
					final /*@NonInvalid*/ @Nullable Element ast = i.getAst();
					//
					accumulator.add(ast);
				}
				final /*@NonInvalid*/ boolean symbol_1 = temp1_collect instanceof SequenceValue;
				/*@Thrown*/ @Nullable Boolean IF_symbol_1;
				if (symbol_1) {
					final /*@Thrown*/ @NonNull SequenceValue CAST_temp1_collect = (SequenceValue)temp1_collect;
					final /*@Thrown*/ @NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(CAST_temp1_collect);
					// mapping statements
					final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Package> ECORE_asOrderedSet = idResolver.ecoreValueOfAll(org.eclipse.qvtd.doc.miniocl.Package.class, asOrderedSet);
					CAST_temp1_ast.getOwnedPackages().addAll(ECORE_asOrderedSet);
					final /*@Thrown*/ @Nullable Boolean muRootCS__2__Root__ownedPackages = ValueUtil.TRUE_VALUE;
					IF_symbol_1 = muRootCS__2__Root__ownedPackages;
				}
				else {
					IF_symbol_1 = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_symbol_1;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lRootCS_0, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:3 mcNameExpCS__2__PropertyCallExp__0 in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * var isPropCallExpWithImplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithImplicitSource()
	 *   ;
	 * check isPropCallExpWithImplicitSource;
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * var _'not' : Boolean[?] := not isPropCallExpWithExplicitSource;
	 * check _'not';
	 * var isVariableExp : Boolean[?] := lNameExpCS.isVariableExp();
	 * var not1 : Boolean[?] := not isVariableExp;
	 * check not1;
	 * new:rightAS rPropertyCallExp : miniocl::PropertyCallExp[1];
	 * notify set lNameExpCS.ast := rPropertyCallExp;
	 *
	 */
	protected class MAP_mcNameExpCS__2__PropertyCallExp__0 extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_0;

		public MAP_mcNameExpCS__2__PropertyCallExp__0(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_0 = (@NonNull NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_0.getRoundedBrackets();
			final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
			final /*@Thrown*/ @Nullable Boolean and;
			if (!eq) {
				and = ValueUtil.FALSE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_not;
				try {
					/*@Caught*/ @NonNull Object CAUGHT_IF_eq_0;
					try {
						final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_0);
						final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
						/*@Thrown*/ boolean IF_eq_0;
						if (eq_0) {
							IF_eq_0 = false;
						}
						else {
							if (parentCallExpCS == null) {
								throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
							}
							final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
							final /*@Thrown*/ boolean eq_1 = lNameExpCS_0.equals(navExp);
							IF_eq_0 = eq_1;
						}
						CAUGHT_IF_eq_0 = IF_eq_0;
					}
					catch (Exception e) {
						CAUGHT_IF_eq_0 = ValueUtil.createInvalidValue(e);
					}
					if (CAUGHT_IF_eq_0 instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_IF_eq_0;
					}
					final /*@Thrown*/ @Nullable Boolean not;
					if (CAUGHT_IF_eq_0 == ValueUtil.FALSE_VALUE) {
						not = ValueUtil.TRUE_VALUE;
					}
					else {
						if (CAUGHT_IF_eq_0 == ValueUtil.TRUE_VALUE) {
							not = ValueUtil.FALSE_VALUE;
						}
						else {
							not = null;
						}
					}
					CAUGHT_not = not;
				}
				catch (Exception e) {
					CAUGHT_not = ValueUtil.createInvalidValue(e);
				}
				if (CAUGHT_not == ValueUtil.FALSE_VALUE) {
					and = ValueUtil.FALSE_VALUE;
				}
				else {
					if (CAUGHT_not instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_not;
					}
					if (CAUGHT_not == null) {
						and = null;
					}
					else {
						and = ValueUtil.TRUE_VALUE;
					}
				}
			}
			if (and == null) {
				throw throwNull(lNameExpCS_0, "Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean IF_and;
			if (and) {
				/*@Caught*/ @Nullable Object CAUGHT_and_0;
				try {
					final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_0.getRoundedBrackets();
					final /*@NonInvalid*/ boolean eq_2 = roundedBrackets_0 == null;
					final /*@Thrown*/ @Nullable Boolean and_0;
					if (!eq_2) {
						and_0 = ValueUtil.FALSE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_IF_eq_3;
						try {
							final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_0);
							final /*@NonInvalid*/ boolean eq_3 = parentCallExpCS_0 == null;
							/*@Thrown*/ boolean IF_eq_3;
							if (eq_3) {
								IF_eq_3 = false;
							}
							else {
								if (parentCallExpCS_0 == null) {
									throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
								}
								final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
								final /*@Thrown*/ boolean eq_4 = lNameExpCS_0.equals(navExp_0);
								IF_eq_3 = eq_4;
							}
							CAUGHT_IF_eq_3 = IF_eq_3;
						}
						catch (Exception e) {
							CAUGHT_IF_eq_3 = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_IF_eq_3 == ValueUtil.FALSE_VALUE) {
							and_0 = ValueUtil.FALSE_VALUE;
						}
						else {
							if (CAUGHT_IF_eq_3 instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_IF_eq_3;
							}
							and_0 = ValueUtil.TRUE_VALUE;
						}
					}
					CAUGHT_and_0 = and_0;
				}
				catch (Exception e) {
					CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
				}
				if (CAUGHT_and_0 instanceof InvalidValueException) {
					throw (InvalidValueException)CAUGHT_and_0;
				}
				final /*@Thrown*/ @Nullable Boolean not_0;
				if (CAUGHT_and_0 == ValueUtil.FALSE_VALUE) {
					not_0 = ValueUtil.TRUE_VALUE;
				}
				else {
					if (CAUGHT_and_0 == ValueUtil.TRUE_VALUE) {
						not_0 = ValueUtil.FALSE_VALUE;
					}
					else {
						not_0 = null;
					}
				}
				if (not_0 == null) {
					throw throwNull(lNameExpCS_0, "Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_not_0;
				if (not_0) {
					/*@Caught*/ @Nullable Object CAUGHT_and_3;
					try {
						/*@Caught*/ @Nullable Object CAUGHT_and_2;
						try {
							/*@Caught*/ @Nullable Object CAUGHT_and_1;
							try {
								final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_1 = lNameExpCS_0.getRoundedBrackets();
								final /*@NonInvalid*/ boolean eq_5 = roundedBrackets_1 == null;
								final /*@Thrown*/ @Nullable Boolean and_1;
								if (!eq_5) {
									and_1 = ValueUtil.FALSE_VALUE;
								}
								else {
									/*@Caught*/ @Nullable Object CAUGHT_not_1;
									try {
										/*@Caught*/ @NonNull Object CAUGHT_IF_eq_6;
										try {
											final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_1 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_0);
											final /*@NonInvalid*/ boolean eq_6 = parentCallExpCS_1 == null;
											/*@Thrown*/ boolean IF_eq_6;
											if (eq_6) {
												IF_eq_6 = false;
											}
											else {
												if (parentCallExpCS_1 == null) {
													throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
												}
												final /*@Thrown*/ @Nullable NavigationExpCS navExp_1 = parentCallExpCS_1.getNavExp();
												final /*@Thrown*/ boolean eq_7 = lNameExpCS_0.equals(navExp_1);
												IF_eq_6 = eq_7;
											}
											CAUGHT_IF_eq_6 = IF_eq_6;
										}
										catch (Exception e) {
											CAUGHT_IF_eq_6 = ValueUtil.createInvalidValue(e);
										}
										if (CAUGHT_IF_eq_6 instanceof InvalidValueException) {
											throw (InvalidValueException)CAUGHT_IF_eq_6;
										}
										final /*@Thrown*/ @Nullable Boolean not_1;
										if (CAUGHT_IF_eq_6 == ValueUtil.FALSE_VALUE) {
											not_1 = ValueUtil.TRUE_VALUE;
										}
										else {
											if (CAUGHT_IF_eq_6 == ValueUtil.TRUE_VALUE) {
												not_1 = ValueUtil.FALSE_VALUE;
											}
											else {
												not_1 = null;
											}
										}
										CAUGHT_not_1 = not_1;
									}
									catch (Exception e) {
										CAUGHT_not_1 = ValueUtil.createInvalidValue(e);
									}
									if (CAUGHT_not_1 == ValueUtil.FALSE_VALUE) {
										and_1 = ValueUtil.FALSE_VALUE;
									}
									else {
										if (CAUGHT_not_1 instanceof InvalidValueException) {
											throw (InvalidValueException)CAUGHT_not_1;
										}
										if (CAUGHT_not_1 == null) {
											and_1 = null;
										}
										else {
											and_1 = ValueUtil.TRUE_VALUE;
										}
									}
								}
								CAUGHT_and_1 = and_1;
							}
							catch (Exception e) {
								CAUGHT_and_1 = ValueUtil.createInvalidValue(e);
							}
							final /*@Thrown*/ @Nullable Boolean and_2;
							if (CAUGHT_and_1 == ValueUtil.FALSE_VALUE) {
								and_2 = ValueUtil.FALSE_VALUE;
							}
							else {
								/*@Caught*/ @NonNull Object CAUGHT_eq_8;
								try {
									final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_0.getExpName();
									if (expName == null) {
										throw throwNull(lNameExpCS_0, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
									}
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName.getPathElements();
									final /*@Thrown*/ @NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
									final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
									final /*@Thrown*/ boolean eq_8 = size.equals(INT_1);
									CAUGHT_eq_8 = eq_8;
								}
								catch (Exception e) {
									CAUGHT_eq_8 = ValueUtil.createInvalidValue(e);
								}
								if (CAUGHT_eq_8 == ValueUtil.FALSE_VALUE) {
									and_2 = ValueUtil.FALSE_VALUE;
								}
								else {
									if (CAUGHT_and_1 instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_and_1;
									}
									if (CAUGHT_eq_8 instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_eq_8;
									}
									if (CAUGHT_and_1 == null) {
										and_2 = null;
									}
									else {
										and_2 = ValueUtil.TRUE_VALUE;
									}
								}
							}
							CAUGHT_and_2 = and_2;
						}
						catch (Exception e) {
							CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
						}
						final /*@Thrown*/ @Nullable Boolean and_3;
						if (CAUGHT_and_2 == ValueUtil.FALSE_VALUE) {
							and_3 = ValueUtil.FALSE_VALUE;
						}
						else {
							final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_0);
							final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
							if (!ne) {
								and_3 = ValueUtil.FALSE_VALUE;
							}
							else {
								if (CAUGHT_and_2 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_and_2;
								}
								if (CAUGHT_and_2 == null) {
									and_3 = null;
								}
								else {
									and_3 = ValueUtil.TRUE_VALUE;
								}
							}
						}
						CAUGHT_and_3 = and_3;
					}
					catch (Exception e) {
						CAUGHT_and_3 = ValueUtil.createInvalidValue(e);
					}
					if (CAUGHT_and_3 instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_and_3;
					}
					final /*@Thrown*/ @Nullable Boolean not_2;
					if (CAUGHT_and_3 == ValueUtil.FALSE_VALUE) {
						not_2 = ValueUtil.TRUE_VALUE;
					}
					else {
						if (CAUGHT_and_3 == ValueUtil.TRUE_VALUE) {
							not_2 = ValueUtil.FALSE_VALUE;
						}
						else {
							not_2 = null;
						}
					}
					if (not_2 == null) {
						throw throwNull(lNameExpCS_0, "Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean IF_not_2;
					if (not_2) {
						// creations
						final @SuppressWarnings("null")@NonNull PropertyCallExp rPropertyCallExp = MiniOCLFactory.eINSTANCE.createPropertyCallExp();
						models[3/*rightAS*/].add(rPropertyCallExp, false);
						// mapping statements
						lNameExpCS_0.setAst(rPropertyCallExp);
						objectManager.assigned(lNameExpCS_0, MinioclcsPackage.Literals.CS_TRACE__AST, rPropertyCallExp, false);
						final /*@Thrown*/ @Nullable Boolean mcNameExpCS__2__PropertyCallExp__0 = ValueUtil.TRUE_VALUE;
						IF_not_2 = mcNameExpCS__2__PropertyCallExp__0;
					}
					else {
						IF_not_2 = ValueUtil.FALSE_VALUE;
					}
					IF_not_0 = IF_not_2;
				}
				else {
					IF_not_0 = ValueUtil.FALSE_VALUE;
				}
				IF_and = IF_not_0;
			}
			else {
				IF_and = ValueUtil.FALSE_VALUE;
			}
			return IF_and;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS_0, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:3 mcNameExpCS__2__VariableExp__1 in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * var isVariableExp : Boolean[?] := lNameExpCS.isVariableExp()
	 *   ;
	 * check isVariableExp;
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource();
	 * var _'not' : Boolean[?] := not isPropCallExpWithExplicitSource;
	 * check _'not';
	 * new:rightAS rVariableExp : miniocl::VariableExp[1];
	 * notify set lNameExpCS.ast := rVariableExp;
	 *
	 */
	protected class MAP_mcNameExpCS__2__VariableExp__1 extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_1;

		public MAP_mcNameExpCS__2__VariableExp__1(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_1 = (@NonNull NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			/*@Caught*/ @Nullable Object CAUGHT_and_0;
			try {
				/*@Caught*/ @Nullable Object CAUGHT_and;
				try {
					final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_1.getRoundedBrackets();
					final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
					final /*@Thrown*/ @Nullable Boolean and;
					if (!eq) {
						and = ValueUtil.FALSE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_not;
						try {
							/*@Caught*/ @NonNull Object CAUGHT_IF_eq_0;
							try {
								final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_1);
								final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
								/*@Thrown*/ boolean IF_eq_0;
								if (eq_0) {
									IF_eq_0 = false;
								}
								else {
									if (parentCallExpCS == null) {
										throw throwNull(lNameExpCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
									}
									final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
									final /*@Thrown*/ boolean eq_1 = lNameExpCS_1.equals(navExp);
									IF_eq_0 = eq_1;
								}
								CAUGHT_IF_eq_0 = IF_eq_0;
							}
							catch (Exception e) {
								CAUGHT_IF_eq_0 = ValueUtil.createInvalidValue(e);
							}
							if (CAUGHT_IF_eq_0 instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_IF_eq_0;
							}
							final /*@Thrown*/ @Nullable Boolean not;
							if (CAUGHT_IF_eq_0 == ValueUtil.FALSE_VALUE) {
								not = ValueUtil.TRUE_VALUE;
							}
							else {
								if (CAUGHT_IF_eq_0 == ValueUtil.TRUE_VALUE) {
									not = ValueUtil.FALSE_VALUE;
								}
								else {
									not = null;
								}
							}
							CAUGHT_not = not;
						}
						catch (Exception e) {
							CAUGHT_not = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_not == ValueUtil.FALSE_VALUE) {
							and = ValueUtil.FALSE_VALUE;
						}
						else {
							if (CAUGHT_not instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_not;
							}
							if (CAUGHT_not == null) {
								and = null;
							}
							else {
								and = ValueUtil.TRUE_VALUE;
							}
						}
					}
					CAUGHT_and = and;
				}
				catch (Exception e) {
					CAUGHT_and = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ @Nullable Boolean and_0;
				if (CAUGHT_and == ValueUtil.FALSE_VALUE) {
					and_0 = ValueUtil.FALSE_VALUE;
				}
				else {
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
					if (CAUGHT_eq_2 == ValueUtil.FALSE_VALUE) {
						and_0 = ValueUtil.FALSE_VALUE;
					}
					else {
						if (CAUGHT_and instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_and;
						}
						if (CAUGHT_eq_2 instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_eq_2;
						}
						if (CAUGHT_and == null) {
							and_0 = null;
						}
						else {
							and_0 = ValueUtil.TRUE_VALUE;
						}
					}
				}
				CAUGHT_and_0 = and_0;
			}
			catch (Exception e) {
				CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
			}
			final /*@Thrown*/ @Nullable Boolean and_1;
			if (CAUGHT_and_0 == ValueUtil.FALSE_VALUE) {
				and_1 = ValueUtil.FALSE_VALUE;
			}
			else {
				final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_1);
				final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
				if (!ne) {
					and_1 = ValueUtil.FALSE_VALUE;
				}
				else {
					if (CAUGHT_and_0 instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_and_0;
					}
					if (CAUGHT_and_0 == null) {
						and_1 = null;
					}
					else {
						and_1 = ValueUtil.TRUE_VALUE;
					}
				}
			}
			if (and_1 == null) {
				throw throwNull(lNameExpCS_1, "Null if condition");
			}
			/*@Thrown*/ @Nullable Boolean IF_and_1;
			if (and_1) {
				/*@Caught*/ @Nullable Object CAUGHT_and_2;
				try {
					final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_1.getRoundedBrackets();
					final /*@NonInvalid*/ boolean eq_3 = roundedBrackets_0 == null;
					final /*@Thrown*/ @Nullable Boolean and_2;
					if (!eq_3) {
						and_2 = ValueUtil.FALSE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_IF_eq_4;
						try {
							final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_1);
							final /*@NonInvalid*/ boolean eq_4 = parentCallExpCS_0 == null;
							/*@Thrown*/ boolean IF_eq_4;
							if (eq_4) {
								IF_eq_4 = false;
							}
							else {
								if (parentCallExpCS_0 == null) {
									throw throwNull(lNameExpCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
								}
								final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
								final /*@Thrown*/ boolean eq_5 = lNameExpCS_1.equals(navExp_0);
								IF_eq_4 = eq_5;
							}
							CAUGHT_IF_eq_4 = IF_eq_4;
						}
						catch (Exception e) {
							CAUGHT_IF_eq_4 = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_IF_eq_4 == ValueUtil.FALSE_VALUE) {
							and_2 = ValueUtil.FALSE_VALUE;
						}
						else {
							if (CAUGHT_IF_eq_4 instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_IF_eq_4;
							}
							and_2 = ValueUtil.TRUE_VALUE;
						}
					}
					CAUGHT_and_2 = and_2;
				}
				catch (Exception e) {
					CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
				}
				if (CAUGHT_and_2 instanceof InvalidValueException) {
					throw (InvalidValueException)CAUGHT_and_2;
				}
				final /*@Thrown*/ @Nullable Boolean not_0;
				if (CAUGHT_and_2 == ValueUtil.FALSE_VALUE) {
					not_0 = ValueUtil.TRUE_VALUE;
				}
				else {
					if (CAUGHT_and_2 == ValueUtil.TRUE_VALUE) {
						not_0 = ValueUtil.FALSE_VALUE;
					}
					else {
						not_0 = null;
					}
				}
				if (not_0 == null) {
					throw throwNull(lNameExpCS_1, "Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_not_0;
				if (not_0) {
					// creations
					final @SuppressWarnings("null")@NonNull VariableExp rVariableExp = MiniOCLFactory.eINSTANCE.createVariableExp();
					models[3/*rightAS*/].add(rVariableExp, false);
					// mapping statements
					lNameExpCS_1.setAst(rVariableExp);
					objectManager.assigned(lNameExpCS_1, MinioclcsPackage.Literals.CS_TRACE__AST, rVariableExp, false);
					final /*@Thrown*/ @Nullable Boolean mcNameExpCS__2__VariableExp__1 = ValueUtil.TRUE_VALUE;
					IF_not_0 = mcNameExpCS__2__VariableExp__1;
				}
				else {
					IF_not_0 = ValueUtil.FALSE_VALUE;
				}
				IF_and_1 = IF_not_0;
			}
			else {
				IF_and_1 = ValueUtil.FALSE_VALUE;
			}
			return IF_and_1;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS_1, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:3 muCallExpCS__ast in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lCallExpCS : minioclcs::CallExpCS[1];
	 * var navExp : minioclcs::NavigationExpCS[?] := lCallExpCS.navExp;
	 * observe minioclcs::CSTrace::ast check var ast : miniocl::CallExp[?] := navExp?.ast;
	 * var oclIsTypeOf : Boolean[1] := lCallExpCS.oclIsTypeOf(minioclcs::CallExpCS);
	 * check oclIsTypeOf;
	 * notify set lCallExpCS.ast := ast;
	 *
	 */
	protected class MAP_muCallExpCS__ast extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull CallExpCS lCallExpCS;

		public MAP_muCallExpCS__ast(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lCallExpCS = (@NonNull CallExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable NavigationExpCS navExp = lCallExpCS.getNavExp();
			final /*@NonInvalid*/ @NonNull Object ast = navExp == null;
			/*@Thrown*/ @Nullable Element safe_ast_source;
			if (ast == Boolean.TRUE) {
				safe_ast_source = null;
			}
			else {
				assert navExp != null;
				objectManager.getting(navExp, MinioclcsPackage.Literals.CS_TRACE__AST, false);
				final /*@Thrown*/ @Nullable Element ast_0 = navExp.getAst();
				safe_ast_source = ast_0;
			}
			final /*@NonInvalid*/ boolean symbol_0 = safe_ast_source instanceof CallExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@Thrown*/ @Nullable CallExp CAST_safe_ast_source = (CallExp)safe_ast_source;
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_minioclcs_c_c_CallExpCS_0_0 = idResolver.getClass(CLSSid_CallExpCS, null);
				final /*@NonInvalid*/ boolean oclIsTypeOf = OclAnyOclIsTypeOfOperation.INSTANCE.evaluate(executor, lCallExpCS, TYP_minioclcs_c_c_CallExpCS_0_0).booleanValue();
				/*@Thrown*/ @Nullable Boolean IF_oclIsTypeOf;
				if (oclIsTypeOf) {
					// mapping statements
					lCallExpCS.setAst(CAST_safe_ast_source);
					objectManager.assigned(lCallExpCS, MinioclcsPackage.Literals.CS_TRACE__AST, CAST_safe_ast_source, false);
					final /*@Thrown*/ @Nullable Boolean muCallExpCS__ast = ValueUtil.TRUE_VALUE;
					IF_oclIsTypeOf = muCallExpCS__ast;
				}
				else {
					IF_oclIsTypeOf = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_oclIsTypeOf;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lCallExpCS, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:4 muNameExpCS__2__PropertyCallExp__1__ownedSource in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * check var ast : miniocl::PropertyCallExp[?] := lNameExpCS.ast;
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * check isPropCallExpWithExplicitSource;
	 * var unsafe : minioclcs::CallExpCS[?] := lNameExpCS.parentAsCallExpCS();
	 * var _'=' : Boolean[1] := unsafe =
	 *   null;
	 * var _'if' : minioclcs::CallExpCS[?] := if _'='
	 *   then null
	 *   else unsafe.source
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
	 * notify set ast.ownedSource := if2;
	 *
	 */
	protected class MAP_muNameExpCS__2__PropertyCallExp__1__ownedSource extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_2;

		public MAP_muNameExpCS__2__PropertyCallExp__1__ownedSource(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_2 = (@NonNull NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Element temp1_ast = lNameExpCS_2.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof PropertyCallExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @Nullable PropertyCallExp CAST_temp1_ast = (PropertyCallExp)temp1_ast;
				final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_2.getRoundedBrackets();
				final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
				final /*@Thrown*/ @Nullable Boolean and;
				if (!eq) {
					and = ValueUtil.FALSE_VALUE;
				}
				else {
					/*@Caught*/ @NonNull Object CAUGHT_IF_eq_0;
					try {
						final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_2);
						final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
						/*@Thrown*/ boolean IF_eq_0;
						if (eq_0) {
							IF_eq_0 = false;
						}
						else {
							if (parentCallExpCS == null) {
								throw throwNull(lNameExpCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
							}
							final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
							final /*@Thrown*/ boolean eq_1 = lNameExpCS_2.equals(navExp);
							IF_eq_0 = eq_1;
						}
						CAUGHT_IF_eq_0 = IF_eq_0;
					}
					catch (Exception e) {
						CAUGHT_IF_eq_0 = ValueUtil.createInvalidValue(e);
					}
					if (CAUGHT_IF_eq_0 == ValueUtil.FALSE_VALUE) {
						and = ValueUtil.FALSE_VALUE;
					}
					else {
						if (CAUGHT_IF_eq_0 instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_IF_eq_0;
						}
						and = ValueUtil.TRUE_VALUE;
					}
				}
				if (and == null) {
					throw throwNull(lNameExpCS_2, "Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_and;
				if (and) {
					final /*@NonInvalid*/ @Nullable CallExpCS parentAsCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_2);
					final /*@NonInvalid*/ boolean eq_2 = parentAsCallExpCS == null;
					/*@Thrown*/ @Nullable CallExpCS IF_eq_2;
					if (eq_2) {
						IF_eq_2 = null;
					}
					else {
						if (parentAsCallExpCS == null) {
							throw throwNull(lNameExpCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::source\'");
						}
						final /*@Thrown*/ @Nullable CallExpCS source = parentAsCallExpCS.getSource();
						IF_eq_2 = source;
					}
					final /*@Thrown*/ boolean eq_3 = IF_eq_2 == null;
					/*@Thrown*/ @Nullable Element IF_eq_3;
					if (eq_3) {
						IF_eq_3 = null;
					}
					else {
						if (IF_eq_2 == null) {
							throw throwNull(lNameExpCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CSTrace::ast\'");
						}
						final /*@Thrown*/ @Nullable Element ast = IF_eq_2.getAst();
						IF_eq_3 = ast;
					}
					final /*@Thrown*/ boolean eq_4 = IF_eq_3 == null;
					/*@Thrown*/ @Nullable CallExp IF_eq_4;
					if (eq_4) {
						IF_eq_4 = null;
					}
					else {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_CallExp_0 = idResolver.getClass(CLSSid_CallExp, null);
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull CallExp oclAsType = (@NonNull CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, IF_eq_3, TYP_miniocl_c_c_CallExp_0);
						IF_eq_4 = oclAsType;
					}
					// mapping statements
					if (IF_eq_4 == null) {
						throw throwNull(lNameExpCS_2, "Null value for miniocl::CallExp::ownedSource : miniocl::OCLExpression[1] assignment");
					}
					CAST_temp1_ast.setOwnedSource(IF_eq_4);
					objectManager.assigned(CAST_temp1_ast, MiniOCLPackage.Literals.CALL_EXP__OWNED_SOURCE, IF_eq_4, false);
					final /*@Thrown*/ @Nullable Boolean muNameExpCS__2__PropertyCallExp__1__ownedSource = ValueUtil.TRUE_VALUE;
					IF_and = muNameExpCS__2__PropertyCallExp__1__ownedSource;
				}
				else {
					IF_and = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_and;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS_2, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:5 muNameExpCS__2__PropertyCallExp__0__ownedSource in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * check var ast : miniocl::PropertyCallExp[?] := lNameExpCS.ast;
	 * var isPropCallExpWithImplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithImplicitSource()
	 *   ;
	 * check isPropCallExpWithImplicitSource;
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * var _'not' : Boolean[?] := not isPropCallExpWithExplicitSource;
	 * check _'not';
	 * var isVariableExp : Boolean[?] := lNameExpCS.isVariableExp()
	 *   ;
	 * var not1 : Boolean[?] := not isVariableExp;
	 * check not1;
	 * var referredVar : miniocl::Variable[?] := ast.lookupVariable('self')
	 *   ;
	 * observe miniocl::TypedElement::type var type : miniocl::Class[1] := referredVar?.type;
	 * var shadow : miniocl::VariableExp[1] := miniocl::VariableExp{referredVariable = referredVar, type = type
	 *   };
	 * notify set ast.ownedSource := shadow;
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
			final /*@NonInvalid*/ @Nullable Element temp1_ast = lNameExpCS_3.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof PropertyCallExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @Nullable PropertyCallExp CAST_temp1_ast = (PropertyCallExp)temp1_ast;
				final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_3.getRoundedBrackets();
				final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
				final /*@Thrown*/ @Nullable Boolean and;
				if (!eq) {
					and = ValueUtil.FALSE_VALUE;
				}
				else {
					/*@Caught*/ @Nullable Object CAUGHT_not;
					try {
						/*@Caught*/ @NonNull Object CAUGHT_IF_eq_0;
						try {
							final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_3);
							final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
							/*@Thrown*/ boolean IF_eq_0;
							if (eq_0) {
								IF_eq_0 = false;
							}
							else {
								if (parentCallExpCS == null) {
									throw throwNull(lNameExpCS_3, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
								}
								final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
								final /*@Thrown*/ boolean eq_1 = lNameExpCS_3.equals(navExp);
								IF_eq_0 = eq_1;
							}
							CAUGHT_IF_eq_0 = IF_eq_0;
						}
						catch (Exception e) {
							CAUGHT_IF_eq_0 = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_IF_eq_0 instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_IF_eq_0;
						}
						final /*@Thrown*/ @Nullable Boolean not;
						if (CAUGHT_IF_eq_0 == ValueUtil.FALSE_VALUE) {
							not = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_IF_eq_0 == ValueUtil.TRUE_VALUE) {
								not = ValueUtil.FALSE_VALUE;
							}
							else {
								not = null;
							}
						}
						CAUGHT_not = not;
					}
					catch (Exception e) {
						CAUGHT_not = ValueUtil.createInvalidValue(e);
					}
					if (CAUGHT_not == ValueUtil.FALSE_VALUE) {
						and = ValueUtil.FALSE_VALUE;
					}
					else {
						if (CAUGHT_not instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_not;
						}
						if (CAUGHT_not == null) {
							and = null;
						}
						else {
							and = ValueUtil.TRUE_VALUE;
						}
					}
				}
				if (and == null) {
					throw throwNull(lNameExpCS_3, "Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_and;
				if (and) {
					/*@Caught*/ @Nullable Object CAUGHT_and_0;
					try {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_3.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq_2 = roundedBrackets_0 == null;
						final /*@Thrown*/ @Nullable Boolean and_0;
						if (!eq_2) {
							and_0 = ValueUtil.FALSE_VALUE;
						}
						else {
							/*@Caught*/ @NonNull Object CAUGHT_IF_eq_3;
							try {
								final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_3);
								final /*@NonInvalid*/ boolean eq_3 = parentCallExpCS_0 == null;
								/*@Thrown*/ boolean IF_eq_3;
								if (eq_3) {
									IF_eq_3 = false;
								}
								else {
									if (parentCallExpCS_0 == null) {
										throw throwNull(lNameExpCS_3, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
									}
									final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
									final /*@Thrown*/ boolean eq_4 = lNameExpCS_3.equals(navExp_0);
									IF_eq_3 = eq_4;
								}
								CAUGHT_IF_eq_3 = IF_eq_3;
							}
							catch (Exception e) {
								CAUGHT_IF_eq_3 = ValueUtil.createInvalidValue(e);
							}
							if (CAUGHT_IF_eq_3 == ValueUtil.FALSE_VALUE) {
								and_0 = ValueUtil.FALSE_VALUE;
							}
							else {
								if (CAUGHT_IF_eq_3 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_IF_eq_3;
								}
								and_0 = ValueUtil.TRUE_VALUE;
							}
						}
						CAUGHT_and_0 = and_0;
					}
					catch (Exception e) {
						CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
					}
					if (CAUGHT_and_0 instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_and_0;
					}
					final /*@Thrown*/ @Nullable Boolean not_0;
					if (CAUGHT_and_0 == ValueUtil.FALSE_VALUE) {
						not_0 = ValueUtil.TRUE_VALUE;
					}
					else {
						if (CAUGHT_and_0 == ValueUtil.TRUE_VALUE) {
							not_0 = ValueUtil.FALSE_VALUE;
						}
						else {
							not_0 = null;
						}
					}
					if (not_0 == null) {
						throw throwNull(lNameExpCS_3, "Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean IF_not_0;
					if (not_0) {
						/*@Caught*/ @Nullable Object CAUGHT_and_3;
						try {
							/*@Caught*/ @Nullable Object CAUGHT_and_2;
							try {
								/*@Caught*/ @Nullable Object CAUGHT_and_1;
								try {
									final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_1 = lNameExpCS_3.getRoundedBrackets();
									final /*@NonInvalid*/ boolean eq_5 = roundedBrackets_1 == null;
									final /*@Thrown*/ @Nullable Boolean and_1;
									if (!eq_5) {
										and_1 = ValueUtil.FALSE_VALUE;
									}
									else {
										/*@Caught*/ @Nullable Object CAUGHT_not_1;
										try {
											/*@Caught*/ @NonNull Object CAUGHT_IF_eq_6;
											try {
												final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_1 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_3);
												final /*@NonInvalid*/ boolean eq_6 = parentCallExpCS_1 == null;
												/*@Thrown*/ boolean IF_eq_6;
												if (eq_6) {
													IF_eq_6 = false;
												}
												else {
													if (parentCallExpCS_1 == null) {
														throw throwNull(lNameExpCS_3, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
													}
													final /*@Thrown*/ @Nullable NavigationExpCS navExp_1 = parentCallExpCS_1.getNavExp();
													final /*@Thrown*/ boolean eq_7 = lNameExpCS_3.equals(navExp_1);
													IF_eq_6 = eq_7;
												}
												CAUGHT_IF_eq_6 = IF_eq_6;
											}
											catch (Exception e) {
												CAUGHT_IF_eq_6 = ValueUtil.createInvalidValue(e);
											}
											if (CAUGHT_IF_eq_6 instanceof InvalidValueException) {
												throw (InvalidValueException)CAUGHT_IF_eq_6;
											}
											final /*@Thrown*/ @Nullable Boolean not_1;
											if (CAUGHT_IF_eq_6 == ValueUtil.FALSE_VALUE) {
												not_1 = ValueUtil.TRUE_VALUE;
											}
											else {
												if (CAUGHT_IF_eq_6 == ValueUtil.TRUE_VALUE) {
													not_1 = ValueUtil.FALSE_VALUE;
												}
												else {
													not_1 = null;
												}
											}
											CAUGHT_not_1 = not_1;
										}
										catch (Exception e) {
											CAUGHT_not_1 = ValueUtil.createInvalidValue(e);
										}
										if (CAUGHT_not_1 == ValueUtil.FALSE_VALUE) {
											and_1 = ValueUtil.FALSE_VALUE;
										}
										else {
											if (CAUGHT_not_1 instanceof InvalidValueException) {
												throw (InvalidValueException)CAUGHT_not_1;
											}
											if (CAUGHT_not_1 == null) {
												and_1 = null;
											}
											else {
												and_1 = ValueUtil.TRUE_VALUE;
											}
										}
									}
									CAUGHT_and_1 = and_1;
								}
								catch (Exception e) {
									CAUGHT_and_1 = ValueUtil.createInvalidValue(e);
								}
								final /*@Thrown*/ @Nullable Boolean and_2;
								if (CAUGHT_and_1 == ValueUtil.FALSE_VALUE) {
									and_2 = ValueUtil.FALSE_VALUE;
								}
								else {
									/*@Caught*/ @NonNull Object CAUGHT_eq_8;
									try {
										final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_3.getExpName();
										if (expName == null) {
											throw throwNull(lNameExpCS_3, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
										}
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName.getPathElements();
										final /*@Thrown*/ @NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
										final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
										final /*@Thrown*/ boolean eq_8 = size.equals(INT_1);
										CAUGHT_eq_8 = eq_8;
									}
									catch (Exception e) {
										CAUGHT_eq_8 = ValueUtil.createInvalidValue(e);
									}
									if (CAUGHT_eq_8 == ValueUtil.FALSE_VALUE) {
										and_2 = ValueUtil.FALSE_VALUE;
									}
									else {
										if (CAUGHT_and_1 instanceof InvalidValueException) {
											throw (InvalidValueException)CAUGHT_and_1;
										}
										if (CAUGHT_eq_8 instanceof InvalidValueException) {
											throw (InvalidValueException)CAUGHT_eq_8;
										}
										if (CAUGHT_and_1 == null) {
											and_2 = null;
										}
										else {
											and_2 = ValueUtil.TRUE_VALUE;
										}
									}
								}
								CAUGHT_and_2 = and_2;
							}
							catch (Exception e) {
								CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
							}
							final /*@Thrown*/ @Nullable Boolean and_3;
							if (CAUGHT_and_2 == ValueUtil.FALSE_VALUE) {
								and_3 = ValueUtil.FALSE_VALUE;
							}
							else {
								final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_3);
								final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
								if (!ne) {
									and_3 = ValueUtil.FALSE_VALUE;
								}
								else {
									if (CAUGHT_and_2 instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_and_2;
									}
									if (CAUGHT_and_2 == null) {
										and_3 = null;
									}
									else {
										and_3 = ValueUtil.TRUE_VALUE;
									}
								}
							}
							CAUGHT_and_3 = and_3;
						}
						catch (Exception e) {
							CAUGHT_and_3 = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_and_3 instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_and_3;
						}
						final /*@Thrown*/ @Nullable Boolean not_2;
						if (CAUGHT_and_3 == ValueUtil.FALSE_VALUE) {
							not_2 = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_and_3 == ValueUtil.TRUE_VALUE) {
								not_2 = ValueUtil.FALSE_VALUE;
							}
							else {
								not_2 = null;
							}
						}
						if (not_2 == null) {
							throw throwNull(lNameExpCS_3, "Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean IF_not_2;
						if (not_2) {
							if (CAST_temp1_ast == null) {
								throw throwNull(lNameExpCS_3, "Null where non-null value required");
							}
							final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Variable = INSTANCE_OclElement_unqualified_env_Variable.evaluate(CAST_temp1_ast);
							final /*@Thrown*/ @NonNull OrderedSetValue foundVariable = INSTANCE_Visitable__lookupVariable.evaluate(CAST_temp1_ast, unqualified_env_Variable, STR_self);
							final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundVariable).booleanValue();
							/*@Thrown*/ @Nullable Variable IF_isEmpty;
							if (isEmpty) {
								IF_isEmpty = null;
							}
							else {
								final /*@Thrown*/ @Nullable Variable first = (@Nullable Variable)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundVariable);
								IF_isEmpty = first;
							}
							/*@Caught*/ @Nullable Object CAUGHT_IF_isEmpty;
							try {
								CAUGHT_IF_isEmpty = IF_isEmpty;
							}
							catch (Exception e) {
								CAUGHT_IF_isEmpty = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @NonNull Object type = CAUGHT_IF_isEmpty == null;
							/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class safe_type_source;
							if (type == Boolean.TRUE) {
								safe_type_source = null;
							}
							else {
								assert IF_isEmpty != null;
								objectManager.getting(IF_isEmpty, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, false);
								@SuppressWarnings("null")
								final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type_0 = IF_isEmpty.getType();
								safe_type_source = type_0;
							}
							final /*@Thrown*/ boolean symbol_1 = safe_type_source != null;
							/*@Thrown*/ @Nullable Boolean raw_type;
							if (symbol_1) {
								if (safe_type_source == null) {
									throw throwNull(lNameExpCS_3, "Null where non-null value required");
								}
								final /*@NonInvalid*/ @NonNull Property CTORid_referredVariable = idResolver.getProperty(PROPid_referredVariable);
								final /*@NonInvalid*/ @NonNull Property CTORid_type = idResolver.getProperty(PROPid_type);
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_VariableExp_0 = idResolver.getClass(CLSSid_VariableExp, null);
								final /*@Thrown*/ @NonNull VariableExp symbol_2 = (@NonNull VariableExp)TYP_miniocl_c_c_VariableExp_0.createInstance();
								CTORid_referredVariable.initValue(symbol_2, IF_isEmpty);
								CTORid_type.initValue(symbol_2, safe_type_source);
								// mapping statements
								CAST_temp1_ast.setOwnedSource(symbol_2);
								objectManager.assigned(CAST_temp1_ast, MiniOCLPackage.Literals.CALL_EXP__OWNED_SOURCE, symbol_2, false);
								final /*@Thrown*/ @Nullable Boolean muNameExpCS__2__PropertyCallExp__0__ownedSource = ValueUtil.TRUE_VALUE;
								raw_type = muNameExpCS__2__PropertyCallExp__0__ownedSource;
							}
							else {
								raw_type = ValueUtil.FALSE_VALUE;
							}
							IF_not_2 = raw_type;
						}
						else {
							IF_not_2 = ValueUtil.FALSE_VALUE;
						}
						IF_not_0 = IF_not_2;
					}
					else {
						IF_not_0 = ValueUtil.FALSE_VALUE;
					}
					IF_and = IF_not_0;
				}
				else {
					IF_and = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_and;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS_3, thoseValues[0]);
		}
	}

	/**
	 *
	 * map:5 muParameterCS__2__Parameter__type in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lParameterCS : minioclcs::ParameterCS[1];
	 * check var ast : miniocl::Parameter[?] := lParameterCS.ast;
	 * var typeRef : minioclcs::PathNameCS[?] := lParameterCS.typeRef;
	 * var lookupClass : miniocl::Class[?] := ast.lookupClass(typeRef);
	 * notify set ast.type := lookupClass;
	 *
	 */
	protected boolean MAP_muParameterCS__2__Parameter__type(final /*@NonInvalid*/ @NonNull ParameterCS lParameterCS_1)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element temp1_ast = lParameterCS_1.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof Parameter;
		/*@Thrown*/ @Nullable Boolean IF_symbol_0;
		if (symbol_0) {
			final /*@NonInvalid*/ @Nullable Parameter CAST_temp1_ast = (Parameter)temp1_ast;
			final /*@NonInvalid*/ @Nullable PathNameCS typeRef = lParameterCS_1.getTypeRef();
			if (CAST_temp1_ast == null) {
				throw throwNull(lParameterCS_1, "Null where non-null value required");
			}
			if (typeRef == null) {
				throw throwNull(lParameterCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
			}
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull List<PathElementCS> segments_0 = typeRef.getPathElements();
			final /*@Thrown*/ @NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
			final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
			final /*@Thrown*/ boolean eq = size.equals(INT_1);
			/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class IF_eq;
			if (eq) {
				final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
				if (aPathElementCS == null) {
					throw throwNull(lParameterCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
				}
				final /*@Thrown*/ @Nullable String cName_0 = aPathElementCS.getElementName();
				final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Class = INSTANCE_OclElement_unqualified_env_Class.evaluate(CAST_temp1_ast);
				final /*@Thrown*/ @NonNull OrderedSetValue foundClass = INSTANCE_Visitable__lookupClass.evaluate(CAST_temp1_ast, unqualified_env_Class, cName_0);
				final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
				/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class IF_isEmpty;
				if (isEmpty) {
					IF_isEmpty = null;
				}
				else {
					final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
					IF_isEmpty = first;
				}
				IF_eq = IF_isEmpty;
			}
			else {
				final /*@Thrown*/ @NonNull IntegerValue diff = (@Nullable IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
				if (diff instanceof InvalidValueException) {
					throw (InvalidValueException)diff;
				}
				final /*@Thrown*/ @NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package qualifier = INSTANCE_Visitable_lookupPackage.evaluate(CAST_temp1_ast, qualifierSegments);
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
					/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class IF_isEmpty_0;
					if (isEmpty_0) {
						IF_isEmpty_0 = null;
					}
					else {
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
						IF_isEmpty_0 = first_0;
					}
					safe_lookupQualifiedClass_source = IF_isEmpty_0;
				}
				IF_eq = safe_lookupQualifiedClass_source;
			}
			// mapping statements
			if (IF_eq == null) {
				throw throwNull(lParameterCS_1, "Null value for miniocl::TypedElement::type : miniocl::Class[1] assignment");
			}
			CAST_temp1_ast.setType(IF_eq);
			objectManager.assigned(CAST_temp1_ast, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, IF_eq, false);
			final /*@Thrown*/ @Nullable Boolean muParameterCS__2__Parameter__type = ValueUtil.TRUE_VALUE;
			IF_symbol_0 = muParameterCS__2__Parameter__type;
		}
		else {
			IF_symbol_0 = ValueUtil.FALSE_VALUE;
		}
		return IF_symbol_0;
	}

	/**
	 *
	 * strict map:6 muNameExpCS__2__VariableExp__1__referredVariable in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * check var ast : miniocl::VariableExp[?] := lNameExpCS.ast;
	 * var isVariableExp : Boolean[?] := lNameExpCS.isVariableExp()
	 *   ;
	 * check isVariableExp;
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * var _'not' : Boolean[?] := not isPropCallExpWithExplicitSource;
	 * check _'not';
	 * var expName : minioclcs::PathNameCS[?] := lNameExpCS.expName;
	 * var pathElements : OrderedSet(minioclcs::PathElementCS) := expName?.pathElements;
	 * var first : minioclcs::PathElementCS[?] := pathElements->first()
	 *   ;
	 * var lookupVariable : miniocl::Variable[?] := ast.lookupVariable(first);
	 * set ast.referredVariable := lookupVariable;
	 *
	 */
	protected class MAP_muNameExpCS__2__VariableExp__1__referredVariable extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_4;

		public MAP_muNameExpCS__2__VariableExp__1__referredVariable(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_4 = (@NonNull NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Element temp1_ast = lNameExpCS_4.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof VariableExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @Nullable VariableExp CAST_temp1_ast = (VariableExp)temp1_ast;
				/*@Caught*/ @Nullable Object CAUGHT_and_0;
				try {
					/*@Caught*/ @Nullable Object CAUGHT_and;
					try {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_4.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
						final /*@Thrown*/ @Nullable Boolean and;
						if (!eq) {
							and = ValueUtil.FALSE_VALUE;
						}
						else {
							/*@Caught*/ @Nullable Object CAUGHT_not;
							try {
								/*@Caught*/ @NonNull Object CAUGHT_IF_eq_0;
								try {
									final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_4);
									final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
									/*@Thrown*/ boolean IF_eq_0;
									if (eq_0) {
										IF_eq_0 = false;
									}
									else {
										if (parentCallExpCS == null) {
											throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
										}
										final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
										final /*@Thrown*/ boolean eq_1 = lNameExpCS_4.equals(navExp);
										IF_eq_0 = eq_1;
									}
									CAUGHT_IF_eq_0 = IF_eq_0;
								}
								catch (Exception e) {
									CAUGHT_IF_eq_0 = ValueUtil.createInvalidValue(e);
								}
								if (CAUGHT_IF_eq_0 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_IF_eq_0;
								}
								final /*@Thrown*/ @Nullable Boolean not;
								if (CAUGHT_IF_eq_0 == ValueUtil.FALSE_VALUE) {
									not = ValueUtil.TRUE_VALUE;
								}
								else {
									if (CAUGHT_IF_eq_0 == ValueUtil.TRUE_VALUE) {
										not = ValueUtil.FALSE_VALUE;
									}
									else {
										not = null;
									}
								}
								CAUGHT_not = not;
							}
							catch (Exception e) {
								CAUGHT_not = ValueUtil.createInvalidValue(e);
							}
							if (CAUGHT_not == ValueUtil.FALSE_VALUE) {
								and = ValueUtil.FALSE_VALUE;
							}
							else {
								if (CAUGHT_not instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_not;
								}
								if (CAUGHT_not == null) {
									and = null;
								}
								else {
									and = ValueUtil.TRUE_VALUE;
								}
							}
						}
						CAUGHT_and = and;
					}
					catch (Exception e) {
						CAUGHT_and = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ @Nullable Boolean and_0;
					if (CAUGHT_and == ValueUtil.FALSE_VALUE) {
						and_0 = ValueUtil.FALSE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_eq_2;
						try {
							final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_4.getExpName();
							if (expName == null) {
								throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
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
						if (CAUGHT_eq_2 == ValueUtil.FALSE_VALUE) {
							and_0 = ValueUtil.FALSE_VALUE;
						}
						else {
							if (CAUGHT_and instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_and;
							}
							if (CAUGHT_eq_2 instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_eq_2;
							}
							if (CAUGHT_and == null) {
								and_0 = null;
							}
							else {
								and_0 = ValueUtil.TRUE_VALUE;
							}
						}
					}
					CAUGHT_and_0 = and_0;
				}
				catch (Exception e) {
					CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ @Nullable Boolean and_1;
				if (CAUGHT_and_0 == ValueUtil.FALSE_VALUE) {
					and_1 = ValueUtil.FALSE_VALUE;
				}
				else {
					final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_4);
					final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
					if (!ne) {
						and_1 = ValueUtil.FALSE_VALUE;
					}
					else {
						if (CAUGHT_and_0 instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_and_0;
						}
						if (CAUGHT_and_0 == null) {
							and_1 = null;
						}
						else {
							and_1 = ValueUtil.TRUE_VALUE;
						}
					}
				}
				if (and_1 == null) {
					throw throwNull(lNameExpCS_4, "Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_and_1;
				if (and_1) {
					/*@Caught*/ @Nullable Object CAUGHT_and_2;
					try {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_4.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq_3 = roundedBrackets_0 == null;
						final /*@Thrown*/ @Nullable Boolean and_2;
						if (!eq_3) {
							and_2 = ValueUtil.FALSE_VALUE;
						}
						else {
							/*@Caught*/ @NonNull Object CAUGHT_IF_eq_4;
							try {
								final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_4);
								final /*@NonInvalid*/ boolean eq_4 = parentCallExpCS_0 == null;
								/*@Thrown*/ boolean IF_eq_4;
								if (eq_4) {
									IF_eq_4 = false;
								}
								else {
									if (parentCallExpCS_0 == null) {
										throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
									}
									final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
									final /*@Thrown*/ boolean eq_5 = lNameExpCS_4.equals(navExp_0);
									IF_eq_4 = eq_5;
								}
								CAUGHT_IF_eq_4 = IF_eq_4;
							}
							catch (Exception e) {
								CAUGHT_IF_eq_4 = ValueUtil.createInvalidValue(e);
							}
							if (CAUGHT_IF_eq_4 == ValueUtil.FALSE_VALUE) {
								and_2 = ValueUtil.FALSE_VALUE;
							}
							else {
								if (CAUGHT_IF_eq_4 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_IF_eq_4;
								}
								and_2 = ValueUtil.TRUE_VALUE;
							}
						}
						CAUGHT_and_2 = and_2;
					}
					catch (Exception e) {
						CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
					}
					if (CAUGHT_and_2 instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_and_2;
					}
					final /*@Thrown*/ @Nullable Boolean not_0;
					if (CAUGHT_and_2 == ValueUtil.FALSE_VALUE) {
						not_0 = ValueUtil.TRUE_VALUE;
					}
					else {
						if (CAUGHT_and_2 == ValueUtil.TRUE_VALUE) {
							not_0 = ValueUtil.FALSE_VALUE;
						}
						else {
							not_0 = null;
						}
					}
					if (not_0 == null) {
						throw throwNull(lNameExpCS_4, "Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean IF_not_0;
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
						final /*@Thrown*/ boolean symbol_1 = safe_pathElements_source != null;
						/*@Thrown*/ @Nullable Boolean raw_pathElements;
						if (symbol_1) {
							if (safe_pathElements_source == null) {
								throw throwNull(lNameExpCS_4, "Null where non-null value required");
							}
							final /*@Thrown*/ @Nullable PathElementCS first = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(safe_pathElements_source);
							if (CAST_temp1_ast == null) {
								throw throwNull(lNameExpCS_4, "Null where non-null value required");
							}
							if (first == null) {
								throw throwNull(lNameExpCS_4, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
							}
							final /*@Thrown*/ @Nullable String vName_0 = first.getElementName();
							final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Variable = INSTANCE_OclElement_unqualified_env_Variable.evaluate(CAST_temp1_ast);
							final /*@Thrown*/ @NonNull OrderedSetValue foundVariable = INSTANCE_Visitable__lookupVariable.evaluate(CAST_temp1_ast, unqualified_env_Variable, vName_0);
							final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundVariable).booleanValue();
							/*@Thrown*/ @Nullable Variable IF_isEmpty;
							if (isEmpty) {
								IF_isEmpty = null;
							}
							else {
								final /*@Thrown*/ @Nullable Variable first_0 = (@Nullable Variable)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundVariable);
								IF_isEmpty = first_0;
							}
							// mapping statements
							if (IF_isEmpty == null) {
								throw throwNull(lNameExpCS_4, "Null value for miniocl::VariableExp::referredVariable : miniocl::Variable[1] assignment");
							}
							CAST_temp1_ast.setReferredVariable(IF_isEmpty);
							final /*@Thrown*/ @Nullable Boolean muNameExpCS__2__VariableExp__1__referredVariable = ValueUtil.TRUE_VALUE;
							raw_pathElements = muNameExpCS__2__VariableExp__1__referredVariable;
						}
						else {
							raw_pathElements = ValueUtil.FALSE_VALUE;
						}
						IF_not_0 = raw_pathElements;
					}
					else {
						IF_not_0 = ValueUtil.FALSE_VALUE;
					}
					IF_and_1 = IF_not_0;
				}
				else {
					IF_and_1 = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_and_1;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS_4, thoseValues[0]);
		}
	}

	/**
	 *
	 * map:6 muOperationCS__2__Operation__type in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lOperationCS : minioclcs::OperationCS[1];
	 * check var ast : miniocl::Operation[?] := lOperationCS.ast;
	 * var resultRef : minioclcs::PathNameCS[?] := lOperationCS.resultRef;
	 * var lookupClass : miniocl::Class[?] := ast.lookupClass(resultRef);
	 * set ast.type := lookupClass;
	 *
	 */
	protected boolean MAP_muOperationCS__2__Operation__type(final /*@NonInvalid*/ @NonNull OperationCS lOperationCS_2)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element temp1_ast = lOperationCS_2.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof Operation;
		/*@Thrown*/ @Nullable Boolean IF_symbol_0;
		if (symbol_0) {
			final /*@NonInvalid*/ @Nullable Operation CAST_temp1_ast = (Operation)temp1_ast;
			final /*@NonInvalid*/ @Nullable PathNameCS resultRef = lOperationCS_2.getResultRef();
			if (CAST_temp1_ast == null) {
				throw throwNull(lOperationCS_2, "Null where non-null value required");
			}
			if (resultRef == null) {
				throw throwNull(lOperationCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
			}
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull List<PathElementCS> segments_0 = resultRef.getPathElements();
			final /*@Thrown*/ @NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
			final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
			final /*@Thrown*/ boolean eq = size.equals(INT_1);
			/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class IF_eq;
			if (eq) {
				final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
				if (aPathElementCS == null) {
					throw throwNull(lOperationCS_2, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
				}
				final /*@Thrown*/ @Nullable String cName_0 = aPathElementCS.getElementName();
				final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Class = INSTANCE_OclElement_unqualified_env_Class.evaluate(CAST_temp1_ast);
				final /*@Thrown*/ @NonNull OrderedSetValue foundClass = INSTANCE_Visitable__lookupClass.evaluate(CAST_temp1_ast, unqualified_env_Class, cName_0);
				final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
				/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class IF_isEmpty;
				if (isEmpty) {
					IF_isEmpty = null;
				}
				else {
					final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
					IF_isEmpty = first;
				}
				IF_eq = IF_isEmpty;
			}
			else {
				final /*@Thrown*/ @NonNull IntegerValue diff = (@Nullable IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
				if (diff instanceof InvalidValueException) {
					throw (InvalidValueException)diff;
				}
				final /*@Thrown*/ @NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package qualifier = INSTANCE_Visitable_lookupPackage.evaluate(CAST_temp1_ast, qualifierSegments);
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
					/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class IF_isEmpty_0;
					if (isEmpty_0) {
						IF_isEmpty_0 = null;
					}
					else {
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
						IF_isEmpty_0 = first_0;
					}
					safe_lookupQualifiedClass_source = IF_isEmpty_0;
				}
				IF_eq = safe_lookupQualifiedClass_source;
			}
			// mapping statements
			if (IF_eq == null) {
				throw throwNull(lOperationCS_2, "Null value for miniocl::TypedElement::type : miniocl::Class[1] assignment");
			}
			CAST_temp1_ast.setType(IF_eq);
			final /*@Thrown*/ @Nullable Boolean muOperationCS__2__Operation__type = ValueUtil.TRUE_VALUE;
			IF_symbol_0 = muOperationCS__2__Operation__type;
		}
		else {
			IF_symbol_0 = ValueUtil.FALSE_VALUE;
		}
		return IF_symbol_0;
	}

	/**
	 *
	 * map:6 muPropertyCS__2__Property__type in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lPropertyCS : minioclcs::PropertyCS[1];
	 * check var ast : miniocl::Property[?] := lPropertyCS.ast;
	 * var typeRef : minioclcs::PathNameCS[?] := lPropertyCS.typeRef;
	 * var lookupClass : miniocl::Class[?] := ast.lookupClass(typeRef);
	 * set ast.type := lookupClass;
	 *
	 */
	protected boolean MAP_muPropertyCS__2__Property__type(final /*@NonInvalid*/ @NonNull PropertyCS lPropertyCS_1)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element temp1_ast = lPropertyCS_1.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof org.eclipse.qvtd.doc.miniocl.Property;
		/*@Thrown*/ @Nullable Boolean IF_symbol_0;
		if (symbol_0) {
			final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property CAST_temp1_ast = (org.eclipse.qvtd.doc.miniocl.Property)temp1_ast;
			final /*@NonInvalid*/ @Nullable PathNameCS typeRef = lPropertyCS_1.getTypeRef();
			if (CAST_temp1_ast == null) {
				throw throwNull(lPropertyCS_1, "Null where non-null value required");
			}
			if (typeRef == null) {
				throw throwNull(lPropertyCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
			}
			@SuppressWarnings("null")
			final /*@Thrown*/ @NonNull List<PathElementCS> segments_0 = typeRef.getPathElements();
			final /*@Thrown*/ @NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
			final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
			final /*@Thrown*/ boolean eq = size.equals(INT_1);
			/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class IF_eq;
			if (eq) {
				final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
				if (aPathElementCS == null) {
					throw throwNull(lPropertyCS_1, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
				}
				final /*@Thrown*/ @Nullable String cName_0 = aPathElementCS.getElementName();
				final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Class = INSTANCE_OclElement_unqualified_env_Class.evaluate(CAST_temp1_ast);
				final /*@Thrown*/ @NonNull OrderedSetValue foundClass = INSTANCE_Visitable__lookupClass.evaluate(CAST_temp1_ast, unqualified_env_Class, cName_0);
				final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
				/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class IF_isEmpty;
				if (isEmpty) {
					IF_isEmpty = null;
				}
				else {
					final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
					IF_isEmpty = first;
				}
				IF_eq = IF_isEmpty;
			}
			else {
				final /*@Thrown*/ @NonNull IntegerValue diff = (@Nullable IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
				if (diff instanceof InvalidValueException) {
					throw (InvalidValueException)diff;
				}
				final /*@Thrown*/ @NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package qualifier = INSTANCE_Visitable_lookupPackage.evaluate(CAST_temp1_ast, qualifierSegments);
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
					/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class IF_isEmpty_0;
					if (isEmpty_0) {
						IF_isEmpty_0 = null;
					}
					else {
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
						IF_isEmpty_0 = first_0;
					}
					safe_lookupQualifiedClass_source = IF_isEmpty_0;
				}
				IF_eq = safe_lookupQualifiedClass_source;
			}
			// mapping statements
			if (IF_eq == null) {
				throw throwNull(lPropertyCS_1, "Null value for miniocl::TypedElement::type : miniocl::Class[1] assignment");
			}
			CAST_temp1_ast.setType(IF_eq);
			final /*@Thrown*/ @Nullable Boolean muPropertyCS__2__Property__type = ValueUtil.TRUE_VALUE;
			IF_symbol_0 = muPropertyCS__2__Property__type;
		}
		else {
			IF_symbol_0 = ValueUtil.FALSE_VALUE;
		}
		return IF_symbol_0;
	}

	/**
	 *
	 * strict map:7 muNameExpCS__2__VariableExp__1__type in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * check var ast : miniocl::VariableExp[?] := lNameExpCS.ast;
	 * var isVariableExp : Boolean[?] := lNameExpCS.isVariableExp()
	 *   ;
	 * check isVariableExp;
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource();
	 * var _'not' : Boolean[?] := not isPropCallExpWithExplicitSource;
	 * check _'not';
	 * var referredVariable : miniocl::Variable[1] := ast?.referredVariable;
	 * var type : miniocl::Class[1] := referredVariable.type;
	 * notify set ast.type := type;
	 *
	 */
	protected class MAP_muNameExpCS__2__VariableExp__1__type extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_5;

		public MAP_muNameExpCS__2__VariableExp__1__type(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_5 = (@NonNull NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Element temp1_ast = lNameExpCS_5.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof VariableExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @Nullable VariableExp CAST_temp1_ast = (VariableExp)temp1_ast;
				/*@Caught*/ @Nullable Object CAUGHT_and_0;
				try {
					/*@Caught*/ @Nullable Object CAUGHT_and;
					try {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_5.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
						final /*@Thrown*/ @Nullable Boolean and;
						if (!eq) {
							and = ValueUtil.FALSE_VALUE;
						}
						else {
							/*@Caught*/ @Nullable Object CAUGHT_not;
							try {
								/*@Caught*/ @NonNull Object CAUGHT_IF_eq_0;
								try {
									final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_5);
									final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
									/*@Thrown*/ boolean IF_eq_0;
									if (eq_0) {
										IF_eq_0 = false;
									}
									else {
										if (parentCallExpCS == null) {
											throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
										}
										final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
										final /*@Thrown*/ boolean eq_1 = lNameExpCS_5.equals(navExp);
										IF_eq_0 = eq_1;
									}
									CAUGHT_IF_eq_0 = IF_eq_0;
								}
								catch (Exception e) {
									CAUGHT_IF_eq_0 = ValueUtil.createInvalidValue(e);
								}
								if (CAUGHT_IF_eq_0 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_IF_eq_0;
								}
								final /*@Thrown*/ @Nullable Boolean not;
								if (CAUGHT_IF_eq_0 == ValueUtil.FALSE_VALUE) {
									not = ValueUtil.TRUE_VALUE;
								}
								else {
									if (CAUGHT_IF_eq_0 == ValueUtil.TRUE_VALUE) {
										not = ValueUtil.FALSE_VALUE;
									}
									else {
										not = null;
									}
								}
								CAUGHT_not = not;
							}
							catch (Exception e) {
								CAUGHT_not = ValueUtil.createInvalidValue(e);
							}
							if (CAUGHT_not == ValueUtil.FALSE_VALUE) {
								and = ValueUtil.FALSE_VALUE;
							}
							else {
								if (CAUGHT_not instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_not;
								}
								if (CAUGHT_not == null) {
									and = null;
								}
								else {
									and = ValueUtil.TRUE_VALUE;
								}
							}
						}
						CAUGHT_and = and;
					}
					catch (Exception e) {
						CAUGHT_and = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ @Nullable Boolean and_0;
					if (CAUGHT_and == ValueUtil.FALSE_VALUE) {
						and_0 = ValueUtil.FALSE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_eq_2;
						try {
							final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_5.getExpName();
							if (expName == null) {
								throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
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
						if (CAUGHT_eq_2 == ValueUtil.FALSE_VALUE) {
							and_0 = ValueUtil.FALSE_VALUE;
						}
						else {
							if (CAUGHT_and instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_and;
							}
							if (CAUGHT_eq_2 instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_eq_2;
							}
							if (CAUGHT_and == null) {
								and_0 = null;
							}
							else {
								and_0 = ValueUtil.TRUE_VALUE;
							}
						}
					}
					CAUGHT_and_0 = and_0;
				}
				catch (Exception e) {
					CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ @Nullable Boolean and_1;
				if (CAUGHT_and_0 == ValueUtil.FALSE_VALUE) {
					and_1 = ValueUtil.FALSE_VALUE;
				}
				else {
					final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_5);
					final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
					if (!ne) {
						and_1 = ValueUtil.FALSE_VALUE;
					}
					else {
						if (CAUGHT_and_0 instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_and_0;
						}
						if (CAUGHT_and_0 == null) {
							and_1 = null;
						}
						else {
							and_1 = ValueUtil.TRUE_VALUE;
						}
					}
				}
				if (and_1 == null) {
					throw throwNull(lNameExpCS_5, "Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_and_1;
				if (and_1) {
					/*@Caught*/ @Nullable Object CAUGHT_and_2;
					try {
						final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_5.getRoundedBrackets();
						final /*@NonInvalid*/ boolean eq_3 = roundedBrackets_0 == null;
						final /*@Thrown*/ @Nullable Boolean and_2;
						if (!eq_3) {
							and_2 = ValueUtil.FALSE_VALUE;
						}
						else {
							/*@Caught*/ @NonNull Object CAUGHT_IF_eq_4;
							try {
								final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_5);
								final /*@NonInvalid*/ boolean eq_4 = parentCallExpCS_0 == null;
								/*@Thrown*/ boolean IF_eq_4;
								if (eq_4) {
									IF_eq_4 = false;
								}
								else {
									if (parentCallExpCS_0 == null) {
										throw throwNull(lNameExpCS_5, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
									}
									final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
									final /*@Thrown*/ boolean eq_5 = lNameExpCS_5.equals(navExp_0);
									IF_eq_4 = eq_5;
								}
								CAUGHT_IF_eq_4 = IF_eq_4;
							}
							catch (Exception e) {
								CAUGHT_IF_eq_4 = ValueUtil.createInvalidValue(e);
							}
							if (CAUGHT_IF_eq_4 == ValueUtil.FALSE_VALUE) {
								and_2 = ValueUtil.FALSE_VALUE;
							}
							else {
								if (CAUGHT_IF_eq_4 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_IF_eq_4;
								}
								and_2 = ValueUtil.TRUE_VALUE;
							}
						}
						CAUGHT_and_2 = and_2;
					}
					catch (Exception e) {
						CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
					}
					if (CAUGHT_and_2 instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_and_2;
					}
					final /*@Thrown*/ @Nullable Boolean not_0;
					if (CAUGHT_and_2 == ValueUtil.FALSE_VALUE) {
						not_0 = ValueUtil.TRUE_VALUE;
					}
					else {
						if (CAUGHT_and_2 == ValueUtil.TRUE_VALUE) {
							not_0 = ValueUtil.FALSE_VALUE;
						}
						else {
							not_0 = null;
						}
					}
					if (not_0 == null) {
						throw throwNull(lNameExpCS_5, "Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean IF_not_0;
					if (not_0) {
						final /*@NonInvalid*/ @NonNull Object referredVariable = CAST_temp1_ast == null;
						/*@Thrown*/ @Nullable Variable safe_referredVariable_source;
						if (referredVariable == Boolean.TRUE) {
							safe_referredVariable_source = null;
						}
						else {
							assert CAST_temp1_ast != null;
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull Variable referredVariable_0 = CAST_temp1_ast.getReferredVariable();
							safe_referredVariable_source = referredVariable_0;
						}
						final /*@Thrown*/ boolean symbol_1 = safe_referredVariable_source != null;
						/*@Thrown*/ @Nullable Boolean raw_referredVariable;
						if (symbol_1) {
							if (safe_referredVariable_source == null) {
								throw throwNull(lNameExpCS_5, "Null where non-null value required");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type = safe_referredVariable_source.getType();
							// mapping statements
							CAST_temp1_ast.setType(type);
							objectManager.assigned(CAST_temp1_ast, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, type, false);
							final /*@Thrown*/ @Nullable Boolean muNameExpCS__2__VariableExp__1__type = ValueUtil.TRUE_VALUE;
							raw_referredVariable = muNameExpCS__2__VariableExp__1__type;
						}
						else {
							raw_referredVariable = ValueUtil.FALSE_VALUE;
						}
						IF_not_0 = raw_referredVariable;
					}
					else {
						IF_not_0 = ValueUtil.FALSE_VALUE;
					}
					IF_and_1 = IF_not_0;
				}
				else {
					IF_and_1 = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_and_1;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS_5, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:8 muNameExpCS__2__PropertyCallExp__0__referredPropert in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * check var ast : miniocl::PropertyCallExp[?] := lNameExpCS.ast;
	 * var isPropCallExpWithImplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithImplicitSource()
	 *   ;
	 * check isPropCallExpWithImplicitSource;
	 * var ownedSource : miniocl::OCLExpression[1] := ast?.ownedSource;
	 * observe miniocl::TypedElement::type var type : miniocl::Class[1] := ownedSource.type;
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * var _'not' : Boolean[?] := not isPropCallExpWithExplicitSource;
	 * check _'not';
	 * var isVariableExp : Boolean[?] := lNameExpCS.isVariableExp()
	 *   ;
	 * var not1 : Boolean[?] := not isVariableExp;
	 * check not1;
	 * var expName : minioclcs::PathNameCS[?] := lNameExpCS.expName;
	 * var lookupPropertyFrom : miniocl::Property[?] := ast.lookupPropertyFrom(type, expName);
	 * notify set ast.referredProperty := lookupPropertyFrom;
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
			final /*@NonInvalid*/ @Nullable Element temp1_ast = lNameExpCS_6.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof PropertyCallExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @Nullable PropertyCallExp CAST_temp1_ast = (PropertyCallExp)temp1_ast;
				final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_6.getRoundedBrackets();
				final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
				final /*@Thrown*/ @Nullable Boolean and;
				if (!eq) {
					and = ValueUtil.FALSE_VALUE;
				}
				else {
					/*@Caught*/ @Nullable Object CAUGHT_not;
					try {
						/*@Caught*/ @NonNull Object CAUGHT_IF_eq_0;
						try {
							final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_6);
							final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
							/*@Thrown*/ boolean IF_eq_0;
							if (eq_0) {
								IF_eq_0 = false;
							}
							else {
								if (parentCallExpCS == null) {
									throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
								}
								final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
								final /*@Thrown*/ boolean eq_1 = lNameExpCS_6.equals(navExp);
								IF_eq_0 = eq_1;
							}
							CAUGHT_IF_eq_0 = IF_eq_0;
						}
						catch (Exception e) {
							CAUGHT_IF_eq_0 = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_IF_eq_0 instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_IF_eq_0;
						}
						final /*@Thrown*/ @Nullable Boolean not;
						if (CAUGHT_IF_eq_0 == ValueUtil.FALSE_VALUE) {
							not = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_IF_eq_0 == ValueUtil.TRUE_VALUE) {
								not = ValueUtil.FALSE_VALUE;
							}
							else {
								not = null;
							}
						}
						CAUGHT_not = not;
					}
					catch (Exception e) {
						CAUGHT_not = ValueUtil.createInvalidValue(e);
					}
					if (CAUGHT_not == ValueUtil.FALSE_VALUE) {
						and = ValueUtil.FALSE_VALUE;
					}
					else {
						if (CAUGHT_not instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_not;
						}
						if (CAUGHT_not == null) {
							and = null;
						}
						else {
							and = ValueUtil.TRUE_VALUE;
						}
					}
				}
				if (and == null) {
					throw throwNull(lNameExpCS_6, "Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_and;
				if (and) {
					final /*@NonInvalid*/ @NonNull Object ownedSource = CAST_temp1_ast == null;
					/*@Thrown*/ @Nullable OCLExpression safe_ownedSource_source;
					if (ownedSource == Boolean.TRUE) {
						safe_ownedSource_source = null;
					}
					else {
						assert CAST_temp1_ast != null;
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull OCLExpression ownedSource_0 = CAST_temp1_ast.getOwnedSource();
						safe_ownedSource_source = ownedSource_0;
					}
					final /*@Thrown*/ boolean symbol_1 = safe_ownedSource_source != null;
					/*@Thrown*/ @Nullable Boolean raw_ownedSource;
					if (symbol_1) {
						if (safe_ownedSource_source == null) {
							throw throwNull(lNameExpCS_6, "Null where non-null value required");
						}
						objectManager.getting(safe_ownedSource_source, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, false);
						@SuppressWarnings("null")
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type = safe_ownedSource_source.getType();
						/*@Caught*/ @Nullable Object CAUGHT_and_0;
						try {
							final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_6.getRoundedBrackets();
							final /*@NonInvalid*/ boolean eq_2 = roundedBrackets_0 == null;
							final /*@Thrown*/ @Nullable Boolean and_0;
							if (!eq_2) {
								and_0 = ValueUtil.FALSE_VALUE;
							}
							else {
								/*@Caught*/ @NonNull Object CAUGHT_IF_eq_3;
								try {
									final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_6);
									final /*@NonInvalid*/ boolean eq_3 = parentCallExpCS_0 == null;
									/*@Thrown*/ boolean IF_eq_3;
									if (eq_3) {
										IF_eq_3 = false;
									}
									else {
										if (parentCallExpCS_0 == null) {
											throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
										}
										final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
										final /*@Thrown*/ boolean eq_4 = lNameExpCS_6.equals(navExp_0);
										IF_eq_3 = eq_4;
									}
									CAUGHT_IF_eq_3 = IF_eq_3;
								}
								catch (Exception e) {
									CAUGHT_IF_eq_3 = ValueUtil.createInvalidValue(e);
								}
								if (CAUGHT_IF_eq_3 == ValueUtil.FALSE_VALUE) {
									and_0 = ValueUtil.FALSE_VALUE;
								}
								else {
									if (CAUGHT_IF_eq_3 instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_IF_eq_3;
									}
									and_0 = ValueUtil.TRUE_VALUE;
								}
							}
							CAUGHT_and_0 = and_0;
						}
						catch (Exception e) {
							CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_and_0 instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_and_0;
						}
						final /*@Thrown*/ @Nullable Boolean not_0;
						if (CAUGHT_and_0 == ValueUtil.FALSE_VALUE) {
							not_0 = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_and_0 == ValueUtil.TRUE_VALUE) {
								not_0 = ValueUtil.FALSE_VALUE;
							}
							else {
								not_0 = null;
							}
						}
						if (not_0 == null) {
							throw throwNull(lNameExpCS_6, "Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean IF_not_0;
						if (not_0) {
							/*@Caught*/ @Nullable Object CAUGHT_and_3;
							try {
								/*@Caught*/ @Nullable Object CAUGHT_and_2;
								try {
									/*@Caught*/ @Nullable Object CAUGHT_and_1;
									try {
										final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_1 = lNameExpCS_6.getRoundedBrackets();
										final /*@NonInvalid*/ boolean eq_5 = roundedBrackets_1 == null;
										final /*@Thrown*/ @Nullable Boolean and_1;
										if (!eq_5) {
											and_1 = ValueUtil.FALSE_VALUE;
										}
										else {
											/*@Caught*/ @Nullable Object CAUGHT_not_1;
											try {
												/*@Caught*/ @NonNull Object CAUGHT_IF_eq_6;
												try {
													final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_1 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_6);
													final /*@NonInvalid*/ boolean eq_6 = parentCallExpCS_1 == null;
													/*@Thrown*/ boolean IF_eq_6;
													if (eq_6) {
														IF_eq_6 = false;
													}
													else {
														if (parentCallExpCS_1 == null) {
															throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
														}
														final /*@Thrown*/ @Nullable NavigationExpCS navExp_1 = parentCallExpCS_1.getNavExp();
														final /*@Thrown*/ boolean eq_7 = lNameExpCS_6.equals(navExp_1);
														IF_eq_6 = eq_7;
													}
													CAUGHT_IF_eq_6 = IF_eq_6;
												}
												catch (Exception e) {
													CAUGHT_IF_eq_6 = ValueUtil.createInvalidValue(e);
												}
												if (CAUGHT_IF_eq_6 instanceof InvalidValueException) {
													throw (InvalidValueException)CAUGHT_IF_eq_6;
												}
												final /*@Thrown*/ @Nullable Boolean not_1;
												if (CAUGHT_IF_eq_6 == ValueUtil.FALSE_VALUE) {
													not_1 = ValueUtil.TRUE_VALUE;
												}
												else {
													if (CAUGHT_IF_eq_6 == ValueUtil.TRUE_VALUE) {
														not_1 = ValueUtil.FALSE_VALUE;
													}
													else {
														not_1 = null;
													}
												}
												CAUGHT_not_1 = not_1;
											}
											catch (Exception e) {
												CAUGHT_not_1 = ValueUtil.createInvalidValue(e);
											}
											if (CAUGHT_not_1 == ValueUtil.FALSE_VALUE) {
												and_1 = ValueUtil.FALSE_VALUE;
											}
											else {
												if (CAUGHT_not_1 instanceof InvalidValueException) {
													throw (InvalidValueException)CAUGHT_not_1;
												}
												if (CAUGHT_not_1 == null) {
													and_1 = null;
												}
												else {
													and_1 = ValueUtil.TRUE_VALUE;
												}
											}
										}
										CAUGHT_and_1 = and_1;
									}
									catch (Exception e) {
										CAUGHT_and_1 = ValueUtil.createInvalidValue(e);
									}
									final /*@Thrown*/ @Nullable Boolean and_2;
									if (CAUGHT_and_1 == ValueUtil.FALSE_VALUE) {
										and_2 = ValueUtil.FALSE_VALUE;
									}
									else {
										/*@Caught*/ @NonNull Object CAUGHT_eq_8;
										try {
											final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_6.getExpName();
											if (expName == null) {
												throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
											}
											@SuppressWarnings("null")
											final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName.getPathElements();
											final /*@Thrown*/ @NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
											final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
											final /*@Thrown*/ boolean eq_8 = size.equals(INT_1);
											CAUGHT_eq_8 = eq_8;
										}
										catch (Exception e) {
											CAUGHT_eq_8 = ValueUtil.createInvalidValue(e);
										}
										if (CAUGHT_eq_8 == ValueUtil.FALSE_VALUE) {
											and_2 = ValueUtil.FALSE_VALUE;
										}
										else {
											if (CAUGHT_and_1 instanceof InvalidValueException) {
												throw (InvalidValueException)CAUGHT_and_1;
											}
											if (CAUGHT_eq_8 instanceof InvalidValueException) {
												throw (InvalidValueException)CAUGHT_eq_8;
											}
											if (CAUGHT_and_1 == null) {
												and_2 = null;
											}
											else {
												and_2 = ValueUtil.TRUE_VALUE;
											}
										}
									}
									CAUGHT_and_2 = and_2;
								}
								catch (Exception e) {
									CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
								}
								final /*@Thrown*/ @Nullable Boolean and_3;
								if (CAUGHT_and_2 == ValueUtil.FALSE_VALUE) {
									and_3 = ValueUtil.FALSE_VALUE;
								}
								else {
									final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_6);
									final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
									if (!ne) {
										and_3 = ValueUtil.FALSE_VALUE;
									}
									else {
										if (CAUGHT_and_2 instanceof InvalidValueException) {
											throw (InvalidValueException)CAUGHT_and_2;
										}
										if (CAUGHT_and_2 == null) {
											and_3 = null;
										}
										else {
											and_3 = ValueUtil.TRUE_VALUE;
										}
									}
								}
								CAUGHT_and_3 = and_3;
							}
							catch (Exception e) {
								CAUGHT_and_3 = ValueUtil.createInvalidValue(e);
							}
							if (CAUGHT_and_3 instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_and_3;
							}
							final /*@Thrown*/ @Nullable Boolean not_2;
							if (CAUGHT_and_3 == ValueUtil.FALSE_VALUE) {
								not_2 = ValueUtil.TRUE_VALUE;
							}
							else {
								if (CAUGHT_and_3 == ValueUtil.TRUE_VALUE) {
									not_2 = ValueUtil.FALSE_VALUE;
								}
								else {
									not_2 = null;
								}
							}
							if (not_2 == null) {
								throw throwNull(lNameExpCS_6, "Null if condition");
							}
							/*@Thrown*/ @Nullable Boolean IF_not_2;
							if (not_2) {
								final /*@NonInvalid*/ @Nullable PathNameCS expName_0 = lNameExpCS_6.getExpName();
								if (CAST_temp1_ast == null) {
									throw throwNull(lNameExpCS_6, "Null where non-null value required");
								}
								if (expName_0 == null) {
									throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
								}
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull List<PathElementCS> segments_0 = expName_0.getPathElements();
								final /*@Thrown*/ @NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
								final /*@Thrown*/ @NonNull IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
								final /*@Thrown*/ boolean eq_9 = size_0.equals(INT_1);
								/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property IF_eq_9;
								if (eq_9) {
									final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
									if (aPathElementCS == null) {
										throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
									}
									final /*@Thrown*/ @Nullable String pName_1 = aPathElementCS.getElementName();
									final /*@Thrown*/ @Nullable LookupEnvironment _exported_env_Property = INSTANCE_Class__exported_env_Property.evaluate(type, CAST_temp1_ast);
									final /*@Thrown*/ @NonNull OrderedSetValue foundProperty = INSTANCE_Visitable__lookupProperty.evaluate(type, _exported_env_Property, pName_1);
									final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundProperty).booleanValue();
									/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property IF_isEmpty;
									if (isEmpty) {
										IF_isEmpty = null;
									}
									else {
										final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property first = (org.eclipse.qvtd.doc.miniocl.@Nullable Property)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundProperty);
										IF_isEmpty = first;
									}
									IF_eq_9 = IF_isEmpty;
								}
								else {
									final /*@Thrown*/ @NonNull IntegerValue diff = (@Nullable IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_0, INT_1);
									if (diff instanceof InvalidValueException) {
										throw (InvalidValueException)diff;
									}
									final /*@Thrown*/ @NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
									final /*@Thrown*/ @NonNull IntegerValue size_2 = CollectionSizeOperation.INSTANCE.evaluate(qualifierSegments);
									final /*@Thrown*/ boolean eq_10 = size_2.equals(INT_1);
									/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class IF_eq_10;
									if (eq_10) {
										final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_0 = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(qualifierSegments);
										if (aPathElementCS_0 == null) {
											throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
										}
										final /*@Thrown*/ @Nullable String cName_0 = aPathElementCS_0.getElementName();
										final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Class = INSTANCE_OclElement_unqualified_env_Class.evaluate(CAST_temp1_ast);
										final /*@Thrown*/ @NonNull OrderedSetValue foundClass = INSTANCE_Visitable__lookupClass.evaluate(CAST_temp1_ast, unqualified_env_Class, cName_0);
										final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
										/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class IF_isEmpty_0;
										if (isEmpty_0) {
											IF_isEmpty_0 = null;
										}
										else {
											final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
											IF_isEmpty_0 = first_0;
										}
										IF_eq_10 = IF_isEmpty_0;
									}
									else {
										final /*@Thrown*/ @NonNull IntegerValue diff_0 = (@Nullable IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_2, INT_1);
										if (diff_0 instanceof InvalidValueException) {
											throw (InvalidValueException)diff_0;
										}
										final /*@Thrown*/ @NonNull OrderedSetValue qualifierSegments_0 = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(qualifierSegments, INT_1, diff_0);
										final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package qualifier = INSTANCE_Visitable_lookupPackage.evaluate(CAST_temp1_ast, qualifierSegments_0);
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
											final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
											final /*@NonInvalid*/ @NonNull LookupEnvironment env_3 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
											@SuppressWarnings("null")
											final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = qualifier.getOwnedClasses();
											@SuppressWarnings("null")
											final /*@Thrown*/ @NonNull LookupEnvironment addElements = env_3.addElements(ownedClasses);
											final /*@Thrown*/ @NonNull OrderedSetValue foundClass_0 = INSTANCE_Visitable__lookupClass.evaluate(qualifier, addElements, cName_1);
											final /*@Thrown*/ boolean isEmpty_1 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass_0).booleanValue();
											/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class IF_isEmpty_1;
											if (isEmpty_1) {
												IF_isEmpty_1 = null;
											}
											else {
												final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_1 = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
												IF_isEmpty_1 = first_1;
											}
											safe_lookupQualifiedClass_source = IF_isEmpty_1;
										}
										IF_eq_10 = safe_lookupQualifiedClass_source;
									}
									/*@Caught*/ @Nullable Object CAUGHT_IF_eq_10;
									try {
										CAUGHT_IF_eq_10 = IF_eq_10;
									}
									catch (Exception e) {
										CAUGHT_IF_eq_10 = ValueUtil.createInvalidValue(e);
									}
									final /*@NonInvalid*/ @NonNull Object lookupQualifiedProperty = CAUGHT_IF_eq_10 == null;
									/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property safe_lookupQualifiedProperty_source;
									if (lookupQualifiedProperty == Boolean.TRUE) {
										safe_lookupQualifiedProperty_source = null;
									}
									else {
										if (IF_eq_10 == null) {
											throw throwNull(lNameExpCS_6, "Null where non-null value required");
										}
										final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_2 = (@Nullable PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
										if (aPathElementCS_2 == null) {
											throw throwNull(lNameExpCS_6, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
										}
										final /*@Thrown*/ @Nullable String pName_2 = aPathElementCS_2.getElementName();
										final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_1 = idResolver.getClass(CLSSid_LookupEnvironment, null);
										final /*@NonInvalid*/ @NonNull LookupEnvironment env_4 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_1.createInstance();
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ownedProperties = IF_eq_10.getOwnedProperties();
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull LookupEnvironment addElements_0 = env_4.addElements(ownedProperties);
										final /*@Thrown*/ @NonNull OrderedSetValue foundProperty_0 = INSTANCE_Visitable__lookupProperty.evaluate(IF_eq_10, addElements_0, pName_2);
										final /*@Thrown*/ boolean isEmpty_2 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundProperty_0).booleanValue();
										/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property IF_isEmpty_2;
										if (isEmpty_2) {
											IF_isEmpty_2 = null;
										}
										else {
											final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property first_2 = (org.eclipse.qvtd.doc.miniocl.@Nullable Property)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundProperty_0);
											IF_isEmpty_2 = first_2;
										}
										safe_lookupQualifiedProperty_source = IF_isEmpty_2;
									}
									IF_eq_9 = safe_lookupQualifiedProperty_source;
								}
								// mapping statements
								if (IF_eq_9 == null) {
									throw throwNull(lNameExpCS_6, "Null value for miniocl::PropertyCallExp::referredProperty : miniocl::Property[1] assignment");
								}
								CAST_temp1_ast.setReferredProperty(IF_eq_9);
								objectManager.assigned(CAST_temp1_ast, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, IF_eq_9, false);
								final /*@Thrown*/ @Nullable Boolean muNameExpCS__2__PropertyCallExp__0__referredPropert = ValueUtil.TRUE_VALUE;
								IF_not_2 = muNameExpCS__2__PropertyCallExp__0__referredPropert;
							}
							else {
								IF_not_2 = ValueUtil.FALSE_VALUE;
							}
							IF_not_0 = IF_not_2;
						}
						else {
							IF_not_0 = ValueUtil.FALSE_VALUE;
						}
						raw_ownedSource = IF_not_0;
					}
					else {
						raw_ownedSource = ValueUtil.FALSE_VALUE;
					}
					IF_and = raw_ownedSource;
				}
				else {
					IF_and = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_and;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS_6, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:8 muNameExpCS__2__PropertyCallExp__0__type in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * check var ast : miniocl::PropertyCallExp[?] := lNameExpCS.ast;
	 * observe miniocl::PropertyCallExp::referredProperty var unsafe : miniocl::Property[1] := ast?.referredProperty;
	 * var isPropCallExpWithImplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithImplicitSource()
	 *   ;
	 * check isPropCallExpWithImplicitSource;
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * var _'not' : Boolean[?] := not isPropCallExpWithExplicitSource;
	 * check _'not';
	 * var isVariableExp : Boolean[?] := lNameExpCS.isVariableExp();
	 * var not1 : Boolean[?] := not isVariableExp;
	 * check not1;
	 * var _'=' : Boolean[1] := unsafe =
	 *   null;
	 * var _'if' : miniocl::Class[?] := if _'='
	 *   then null
	 *   else unsafe.type
	 *   endif;
	 * notify set ast.type := _'if';
	 *
	 */
	protected class MAP_muNameExpCS__2__PropertyCallExp__0__type extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_7;

		public MAP_muNameExpCS__2__PropertyCallExp__0__type(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_7 = (@NonNull NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Element temp1_ast = lNameExpCS_7.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof PropertyCallExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @Nullable PropertyCallExp CAST_temp1_ast = (PropertyCallExp)temp1_ast;
				final /*@NonInvalid*/ @NonNull Object referredProperty = CAST_temp1_ast == null;
				/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property safe_referredProperty_source;
				if (referredProperty == Boolean.TRUE) {
					safe_referredProperty_source = null;
				}
				else {
					assert CAST_temp1_ast != null;
					objectManager.getting(CAST_temp1_ast, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, false);
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Property referredProperty_0 = CAST_temp1_ast.getReferredProperty();
					safe_referredProperty_source = referredProperty_0;
				}
				final /*@Thrown*/ boolean symbol_1 = safe_referredProperty_source != null;
				/*@Thrown*/ @Nullable Boolean raw_unsafe;
				if (symbol_1) {
					if (safe_referredProperty_source == null) {
						throw throwNull(lNameExpCS_7, "Null where non-null value required");
					}
					final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_7.getRoundedBrackets();
					final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
					final /*@Thrown*/ @Nullable Boolean and;
					if (!eq) {
						and = ValueUtil.FALSE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_not;
						try {
							/*@Caught*/ @NonNull Object CAUGHT_IF_eq_0;
							try {
								final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_7);
								final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
								/*@Thrown*/ boolean IF_eq_0;
								if (eq_0) {
									IF_eq_0 = false;
								}
								else {
									if (parentCallExpCS == null) {
										throw throwNull(lNameExpCS_7, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
									}
									final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
									final /*@Thrown*/ boolean eq_1 = lNameExpCS_7.equals(navExp);
									IF_eq_0 = eq_1;
								}
								CAUGHT_IF_eq_0 = IF_eq_0;
							}
							catch (Exception e) {
								CAUGHT_IF_eq_0 = ValueUtil.createInvalidValue(e);
							}
							if (CAUGHT_IF_eq_0 instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_IF_eq_0;
							}
							final /*@Thrown*/ @Nullable Boolean not;
							if (CAUGHT_IF_eq_0 == ValueUtil.FALSE_VALUE) {
								not = ValueUtil.TRUE_VALUE;
							}
							else {
								if (CAUGHT_IF_eq_0 == ValueUtil.TRUE_VALUE) {
									not = ValueUtil.FALSE_VALUE;
								}
								else {
									not = null;
								}
							}
							CAUGHT_not = not;
						}
						catch (Exception e) {
							CAUGHT_not = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_not == ValueUtil.FALSE_VALUE) {
							and = ValueUtil.FALSE_VALUE;
						}
						else {
							if (CAUGHT_not instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_not;
							}
							if (CAUGHT_not == null) {
								and = null;
							}
							else {
								and = ValueUtil.TRUE_VALUE;
							}
						}
					}
					if (and == null) {
						throw throwNull(lNameExpCS_7, "Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean IF_and;
					if (and) {
						/*@Caught*/ @Nullable Object CAUGHT_and_0;
						try {
							final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_0 = lNameExpCS_7.getRoundedBrackets();
							final /*@NonInvalid*/ boolean eq_2 = roundedBrackets_0 == null;
							final /*@Thrown*/ @Nullable Boolean and_0;
							if (!eq_2) {
								and_0 = ValueUtil.FALSE_VALUE;
							}
							else {
								/*@Caught*/ @NonNull Object CAUGHT_IF_eq_3;
								try {
									final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_0 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_7);
									final /*@NonInvalid*/ boolean eq_3 = parentCallExpCS_0 == null;
									/*@Thrown*/ boolean IF_eq_3;
									if (eq_3) {
										IF_eq_3 = false;
									}
									else {
										if (parentCallExpCS_0 == null) {
											throw throwNull(lNameExpCS_7, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
										}
										final /*@Thrown*/ @Nullable NavigationExpCS navExp_0 = parentCallExpCS_0.getNavExp();
										final /*@Thrown*/ boolean eq_4 = lNameExpCS_7.equals(navExp_0);
										IF_eq_3 = eq_4;
									}
									CAUGHT_IF_eq_3 = IF_eq_3;
								}
								catch (Exception e) {
									CAUGHT_IF_eq_3 = ValueUtil.createInvalidValue(e);
								}
								if (CAUGHT_IF_eq_3 == ValueUtil.FALSE_VALUE) {
									and_0 = ValueUtil.FALSE_VALUE;
								}
								else {
									if (CAUGHT_IF_eq_3 instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_IF_eq_3;
									}
									and_0 = ValueUtil.TRUE_VALUE;
								}
							}
							CAUGHT_and_0 = and_0;
						}
						catch (Exception e) {
							CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_and_0 instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_and_0;
						}
						final /*@Thrown*/ @Nullable Boolean not_0;
						if (CAUGHT_and_0 == ValueUtil.FALSE_VALUE) {
							not_0 = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_and_0 == ValueUtil.TRUE_VALUE) {
								not_0 = ValueUtil.FALSE_VALUE;
							}
							else {
								not_0 = null;
							}
						}
						if (not_0 == null) {
							throw throwNull(lNameExpCS_7, "Null if condition");
						}
						/*@Thrown*/ @Nullable Boolean IF_not_0;
						if (not_0) {
							/*@Caught*/ @Nullable Object CAUGHT_and_3;
							try {
								/*@Caught*/ @Nullable Object CAUGHT_and_2;
								try {
									/*@Caught*/ @Nullable Object CAUGHT_and_1;
									try {
										final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets_1 = lNameExpCS_7.getRoundedBrackets();
										final /*@NonInvalid*/ boolean eq_5 = roundedBrackets_1 == null;
										final /*@Thrown*/ @Nullable Boolean and_1;
										if (!eq_5) {
											and_1 = ValueUtil.FALSE_VALUE;
										}
										else {
											/*@Caught*/ @Nullable Object CAUGHT_not_1;
											try {
												/*@Caught*/ @NonNull Object CAUGHT_IF_eq_6;
												try {
													final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS_1 = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_7);
													final /*@NonInvalid*/ boolean eq_6 = parentCallExpCS_1 == null;
													/*@Thrown*/ boolean IF_eq_6;
													if (eq_6) {
														IF_eq_6 = false;
													}
													else {
														if (parentCallExpCS_1 == null) {
															throw throwNull(lNameExpCS_7, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
														}
														final /*@Thrown*/ @Nullable NavigationExpCS navExp_1 = parentCallExpCS_1.getNavExp();
														final /*@Thrown*/ boolean eq_7 = lNameExpCS_7.equals(navExp_1);
														IF_eq_6 = eq_7;
													}
													CAUGHT_IF_eq_6 = IF_eq_6;
												}
												catch (Exception e) {
													CAUGHT_IF_eq_6 = ValueUtil.createInvalidValue(e);
												}
												if (CAUGHT_IF_eq_6 instanceof InvalidValueException) {
													throw (InvalidValueException)CAUGHT_IF_eq_6;
												}
												final /*@Thrown*/ @Nullable Boolean not_1;
												if (CAUGHT_IF_eq_6 == ValueUtil.FALSE_VALUE) {
													not_1 = ValueUtil.TRUE_VALUE;
												}
												else {
													if (CAUGHT_IF_eq_6 == ValueUtil.TRUE_VALUE) {
														not_1 = ValueUtil.FALSE_VALUE;
													}
													else {
														not_1 = null;
													}
												}
												CAUGHT_not_1 = not_1;
											}
											catch (Exception e) {
												CAUGHT_not_1 = ValueUtil.createInvalidValue(e);
											}
											if (CAUGHT_not_1 == ValueUtil.FALSE_VALUE) {
												and_1 = ValueUtil.FALSE_VALUE;
											}
											else {
												if (CAUGHT_not_1 instanceof InvalidValueException) {
													throw (InvalidValueException)CAUGHT_not_1;
												}
												if (CAUGHT_not_1 == null) {
													and_1 = null;
												}
												else {
													and_1 = ValueUtil.TRUE_VALUE;
												}
											}
										}
										CAUGHT_and_1 = and_1;
									}
									catch (Exception e) {
										CAUGHT_and_1 = ValueUtil.createInvalidValue(e);
									}
									final /*@Thrown*/ @Nullable Boolean and_2;
									if (CAUGHT_and_1 == ValueUtil.FALSE_VALUE) {
										and_2 = ValueUtil.FALSE_VALUE;
									}
									else {
										/*@Caught*/ @NonNull Object CAUGHT_eq_8;
										try {
											final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_7.getExpName();
											if (expName == null) {
												throw throwNull(lNameExpCS_7, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
											}
											@SuppressWarnings("null")
											final /*@Thrown*/ @NonNull List<PathElementCS> pathElements = expName.getPathElements();
											final /*@Thrown*/ @NonNull OrderedSetValue BOXED_pathElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathElements);
											final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathElements);
											final /*@Thrown*/ boolean eq_8 = size.equals(INT_1);
											CAUGHT_eq_8 = eq_8;
										}
										catch (Exception e) {
											CAUGHT_eq_8 = ValueUtil.createInvalidValue(e);
										}
										if (CAUGHT_eq_8 == ValueUtil.FALSE_VALUE) {
											and_2 = ValueUtil.FALSE_VALUE;
										}
										else {
											if (CAUGHT_and_1 instanceof InvalidValueException) {
												throw (InvalidValueException)CAUGHT_and_1;
											}
											if (CAUGHT_eq_8 instanceof InvalidValueException) {
												throw (InvalidValueException)CAUGHT_eq_8;
											}
											if (CAUGHT_and_1 == null) {
												and_2 = null;
											}
											else {
												and_2 = ValueUtil.TRUE_VALUE;
											}
										}
									}
									CAUGHT_and_2 = and_2;
								}
								catch (Exception e) {
									CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
								}
								final /*@Thrown*/ @Nullable Boolean and_3;
								if (CAUGHT_and_2 == ValueUtil.FALSE_VALUE) {
									and_3 = ValueUtil.FALSE_VALUE;
								}
								else {
									final /*@NonInvalid*/ @Nullable Variable lookupVariableToDisambiguate = INSTANCE_NameExpCS_lookupVariableToDisambiguate.evaluate(lNameExpCS_7);
									final /*@NonInvalid*/ boolean ne = lookupVariableToDisambiguate != null;
									if (!ne) {
										and_3 = ValueUtil.FALSE_VALUE;
									}
									else {
										if (CAUGHT_and_2 instanceof InvalidValueException) {
											throw (InvalidValueException)CAUGHT_and_2;
										}
										if (CAUGHT_and_2 == null) {
											and_3 = null;
										}
										else {
											and_3 = ValueUtil.TRUE_VALUE;
										}
									}
								}
								CAUGHT_and_3 = and_3;
							}
							catch (Exception e) {
								CAUGHT_and_3 = ValueUtil.createInvalidValue(e);
							}
							if (CAUGHT_and_3 instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_and_3;
							}
							final /*@Thrown*/ @Nullable Boolean not_2;
							if (CAUGHT_and_3 == ValueUtil.FALSE_VALUE) {
								not_2 = ValueUtil.TRUE_VALUE;
							}
							else {
								if (CAUGHT_and_3 == ValueUtil.TRUE_VALUE) {
									not_2 = ValueUtil.FALSE_VALUE;
								}
								else {
									not_2 = null;
								}
							}
							if (not_2 == null) {
								throw throwNull(lNameExpCS_7, "Null if condition");
							}
							/*@Thrown*/ @Nullable Boolean IF_not_2;
							if (not_2) {
								final /*@Thrown*/ boolean eq_9 = false;
								/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class IF_eq_9;
								if (eq_9) {
									IF_eq_9 = null;
								}
								else {
									@SuppressWarnings("null")
									final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type = safe_referredProperty_source.getType();
									IF_eq_9 = type;
								}
								// mapping statements
								if (IF_eq_9 == null) {
									throw throwNull(lNameExpCS_7, "Null value for miniocl::TypedElement::type : miniocl::Class[1] assignment");
								}
								CAST_temp1_ast.setType(IF_eq_9);
								objectManager.assigned(CAST_temp1_ast, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, IF_eq_9, false);
								final /*@Thrown*/ @Nullable Boolean muNameExpCS__2__PropertyCallExp__0__type = ValueUtil.TRUE_VALUE;
								IF_not_2 = muNameExpCS__2__PropertyCallExp__0__type;
							}
							else {
								IF_not_2 = ValueUtil.FALSE_VALUE;
							}
							IF_not_0 = IF_not_2;
						}
						else {
							IF_not_0 = ValueUtil.FALSE_VALUE;
						}
						IF_and = IF_not_0;
					}
					else {
						IF_and = ValueUtil.FALSE_VALUE;
					}
					raw_unsafe = IF_and;
				}
				else {
					raw_unsafe = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = raw_unsafe;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS_7, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:8 muNameExpCS__2__PropertyCallExp__1__referredPropert in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * check var ast : miniocl::PropertyCallExp[?] := lNameExpCS.ast;
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource()
	 *   ;
	 * check isPropCallExpWithExplicitSource;
	 * var ownedSource : miniocl::OCLExpression[1] := ast?.ownedSource;
	 * observe miniocl::TypedElement::type var type : miniocl::Class[1] := ownedSource.type;
	 * var expName : minioclcs::PathNameCS[?] := lNameExpCS.expName;
	 * var lookupPropertyFrom : miniocl::Property[?] := ast.lookupPropertyFrom(type, expName);
	 * notify set ast.referredProperty := lookupPropertyFrom;
	 *
	 */
	protected class MAP_muNameExpCS__2__PropertyCallExp__1__referredPropert extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_8;

		public MAP_muNameExpCS__2__PropertyCallExp__1__referredPropert(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_8 = (@NonNull NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @Nullable Element temp1_ast = lNameExpCS_8.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof PropertyCallExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @Nullable PropertyCallExp CAST_temp1_ast = (PropertyCallExp)temp1_ast;
				final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_8.getRoundedBrackets();
				final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
				final /*@Thrown*/ @Nullable Boolean and;
				if (!eq) {
					and = ValueUtil.FALSE_VALUE;
				}
				else {
					/*@Caught*/ @NonNull Object CAUGHT_IF_eq_0;
					try {
						final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_8);
						final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
						/*@Thrown*/ boolean IF_eq_0;
						if (eq_0) {
							IF_eq_0 = false;
						}
						else {
							if (parentCallExpCS == null) {
								throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
							}
							final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
							final /*@Thrown*/ boolean eq_1 = lNameExpCS_8.equals(navExp);
							IF_eq_0 = eq_1;
						}
						CAUGHT_IF_eq_0 = IF_eq_0;
					}
					catch (Exception e) {
						CAUGHT_IF_eq_0 = ValueUtil.createInvalidValue(e);
					}
					if (CAUGHT_IF_eq_0 == ValueUtil.FALSE_VALUE) {
						and = ValueUtil.FALSE_VALUE;
					}
					else {
						if (CAUGHT_IF_eq_0 instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_IF_eq_0;
						}
						and = ValueUtil.TRUE_VALUE;
					}
				}
				if (and == null) {
					throw throwNull(lNameExpCS_8, "Null if condition");
				}
				/*@Thrown*/ @Nullable Boolean IF_and;
				if (and) {
					final /*@NonInvalid*/ @NonNull Object ownedSource = CAST_temp1_ast == null;
					/*@Thrown*/ @Nullable OCLExpression safe_ownedSource_source;
					if (ownedSource == Boolean.TRUE) {
						safe_ownedSource_source = null;
					}
					else {
						assert CAST_temp1_ast != null;
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull OCLExpression ownedSource_0 = CAST_temp1_ast.getOwnedSource();
						safe_ownedSource_source = ownedSource_0;
					}
					final /*@Thrown*/ boolean symbol_1 = safe_ownedSource_source != null;
					/*@Thrown*/ @Nullable Boolean raw_ownedSource;
					if (symbol_1) {
						if (safe_ownedSource_source == null) {
							throw throwNull(lNameExpCS_8, "Null where non-null value required");
						}
						objectManager.getting(safe_ownedSource_source, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, false);
						@SuppressWarnings("null")
						final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type = safe_ownedSource_source.getType();
						final /*@NonInvalid*/ @Nullable PathNameCS expName = lNameExpCS_8.getExpName();
						if (CAST_temp1_ast == null) {
							throw throwNull(lNameExpCS_8, "Null where non-null value required");
						}
						if (expName == null) {
							throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathNameCS::pathElements\'");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull List<PathElementCS> segments_0 = expName.getPathElements();
						final /*@Thrown*/ @NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
						final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0);
						final /*@Thrown*/ boolean eq_2 = size.equals(INT_1);
						/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property IF_eq_2;
						if (eq_2) {
							final /*@Thrown*/ @Nullable PathElementCS aPathElementCS = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
							if (aPathElementCS == null) {
								throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
							}
							final /*@Thrown*/ @Nullable String pName_1 = aPathElementCS.getElementName();
							final /*@Thrown*/ @Nullable LookupEnvironment _exported_env_Property = INSTANCE_Class__exported_env_Property.evaluate(type, CAST_temp1_ast);
							final /*@Thrown*/ @NonNull OrderedSetValue foundProperty = INSTANCE_Visitable__lookupProperty.evaluate(type, _exported_env_Property, pName_1);
							final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundProperty).booleanValue();
							/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property IF_isEmpty;
							if (isEmpty) {
								IF_isEmpty = null;
							}
							else {
								final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property first = (org.eclipse.qvtd.doc.miniocl.@Nullable Property)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundProperty);
								IF_isEmpty = first;
							}
							IF_eq_2 = IF_isEmpty;
						}
						else {
							final /*@Thrown*/ @NonNull IntegerValue diff = (@Nullable IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
							if (diff instanceof InvalidValueException) {
								throw (InvalidValueException)diff;
							}
							final /*@Thrown*/ @NonNull OrderedSetValue qualifierSegments = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff);
							final /*@Thrown*/ @NonNull IntegerValue size_1 = CollectionSizeOperation.INSTANCE.evaluate(qualifierSegments);
							final /*@Thrown*/ boolean eq_3 = size_1.equals(INT_1);
							/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class IF_eq_3;
							if (eq_3) {
								final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_0 = (@Nullable PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(qualifierSegments);
								if (aPathElementCS_0 == null) {
									throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
								}
								final /*@Thrown*/ @Nullable String cName_0 = aPathElementCS_0.getElementName();
								final /*@Thrown*/ @NonNull LookupEnvironment unqualified_env_Class = INSTANCE_OclElement_unqualified_env_Class.evaluate(CAST_temp1_ast);
								final /*@Thrown*/ @NonNull OrderedSetValue foundClass = INSTANCE_Visitable__lookupClass.evaluate(CAST_temp1_ast, unqualified_env_Class, cName_0);
								final /*@Thrown*/ boolean isEmpty_0 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass).booleanValue();
								/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class IF_isEmpty_0;
								if (isEmpty_0) {
									IF_isEmpty_0 = null;
								}
								else {
									final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_0 = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass);
									IF_isEmpty_0 = first_0;
								}
								IF_eq_3 = IF_isEmpty_0;
							}
							else {
								final /*@Thrown*/ @NonNull IntegerValue diff_0 = (@Nullable IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_1, INT_1);
								if (diff_0 instanceof InvalidValueException) {
									throw (InvalidValueException)diff_0;
								}
								final /*@Thrown*/ @NonNull OrderedSetValue qualifierSegments_0 = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(qualifierSegments, INT_1, diff_0);
								final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Package qualifier = INSTANCE_Visitable_lookupPackage.evaluate(CAST_temp1_ast, qualifierSegments_0);
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
										throw throwNull(lNameExpCS_8, "Null where non-null value required");
									}
									final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_1 = (@Nullable PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(qualifierSegments);
									if (aPathElementCS_1 == null) {
										throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
									}
									final /*@Thrown*/ @Nullable String cName_1 = aPathElementCS_1.getElementName();
									final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_0 = idResolver.getClass(CLSSid_LookupEnvironment, null);
									final /*@NonInvalid*/ @NonNull LookupEnvironment env_3 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_0.createInstance();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Class> ownedClasses = qualifier.getOwnedClasses();
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull LookupEnvironment addElements = env_3.addElements(ownedClasses);
									final /*@Thrown*/ @NonNull OrderedSetValue foundClass_0 = INSTANCE_Visitable__lookupClass.evaluate(qualifier, addElements, cName_1);
									final /*@Thrown*/ boolean isEmpty_1 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClass_0).booleanValue();
									/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class IF_isEmpty_1;
									if (isEmpty_1) {
										IF_isEmpty_1 = null;
									}
									else {
										final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class first_1 = (org.eclipse.qvtd.doc.miniocl.@Nullable Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClass_0);
										IF_isEmpty_1 = first_1;
									}
									safe_lookupQualifiedClass_source = IF_isEmpty_1;
								}
								IF_eq_3 = safe_lookupQualifiedClass_source;
							}
							/*@Caught*/ @Nullable Object CAUGHT_IF_eq_3;
							try {
								CAUGHT_IF_eq_3 = IF_eq_3;
							}
							catch (Exception e) {
								CAUGHT_IF_eq_3 = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ @NonNull Object lookupQualifiedProperty = CAUGHT_IF_eq_3 == null;
							/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property safe_lookupQualifiedProperty_source;
							if (lookupQualifiedProperty == Boolean.TRUE) {
								safe_lookupQualifiedProperty_source = null;
							}
							else {
								if (IF_eq_3 == null) {
									throw throwNull(lNameExpCS_8, "Null where non-null value required");
								}
								final /*@Thrown*/ @Nullable PathElementCS aPathElementCS_2 = (@Nullable PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
								if (aPathElementCS_2 == null) {
									throw throwNull(lNameExpCS_8, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::PathElementCS::elementName\'");
								}
								final /*@Thrown*/ @Nullable String pName_2 = aPathElementCS_2.getElementName();
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_lookup_c_c_LookupEnvironment_1 = idResolver.getClass(CLSSid_LookupEnvironment, null);
								final /*@NonInvalid*/ @NonNull LookupEnvironment env_4 = (@NonNull LookupEnvironment)TYP_lookup_c_c_LookupEnvironment_1.createInstance();
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull List<org.eclipse.qvtd.doc.miniocl.Property> ownedProperties = IF_eq_3.getOwnedProperties();
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull LookupEnvironment addElements_0 = env_4.addElements(ownedProperties);
								final /*@Thrown*/ @NonNull OrderedSetValue foundProperty_0 = INSTANCE_Visitable__lookupProperty.evaluate(IF_eq_3, addElements_0, pName_2);
								final /*@Thrown*/ boolean isEmpty_2 = CollectionIsEmptyOperation.INSTANCE.evaluate(foundProperty_0).booleanValue();
								/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property IF_isEmpty_2;
								if (isEmpty_2) {
									IF_isEmpty_2 = null;
								}
								else {
									final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property first_2 = (org.eclipse.qvtd.doc.miniocl.@Nullable Property)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundProperty_0);
									IF_isEmpty_2 = first_2;
								}
								safe_lookupQualifiedProperty_source = IF_isEmpty_2;
							}
							IF_eq_2 = safe_lookupQualifiedProperty_source;
						}
						// mapping statements
						if (IF_eq_2 == null) {
							throw throwNull(lNameExpCS_8, "Null value for miniocl::PropertyCallExp::referredProperty : miniocl::Property[1] assignment");
						}
						CAST_temp1_ast.setReferredProperty(IF_eq_2);
						objectManager.assigned(CAST_temp1_ast, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, IF_eq_2, false);
						final /*@Thrown*/ @Nullable Boolean muNameExpCS__2__PropertyCallExp__1__referredPropert = ValueUtil.TRUE_VALUE;
						raw_ownedSource = muNameExpCS__2__PropertyCallExp__1__referredPropert;
					}
					else {
						raw_ownedSource = ValueUtil.FALSE_VALUE;
					}
					IF_and = raw_ownedSource;
				}
				else {
					IF_and = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = IF_and;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS_8, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:8 muNameExpCS__2__PropertyCallExp__1__type in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lNameExpCS : minioclcs::NameExpCS[1];
	 * check var ast : miniocl::PropertyCallExp[?] := lNameExpCS.ast;
	 * observe miniocl::PropertyCallExp::referredProperty var unsafe : miniocl::Property[1] := ast?.referredProperty;
	 * var isPropCallExpWithExplicitSource : Boolean[?] := lNameExpCS.isPropCallExpWithExplicitSource();
	 * check isPropCallExpWithExplicitSource;
	 * var _'=' : Boolean[1] := unsafe =
	 *   null;
	 * var _'if' : miniocl::Class[?] := if _'='
	 *   then null
	 *   else unsafe.type
	 *   endif;
	 * notify set ast.type := _'if';
	 *
	 */
	protected class MAP_muNameExpCS__2__PropertyCallExp__1__type extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull NameExpCS lNameExpCS_9;

		public MAP_muNameExpCS__2__PropertyCallExp__1__type(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			lNameExpCS_9 = (@NonNull NameExpCS)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ @Nullable Element temp1_ast = lNameExpCS_9.getAst();
			final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof PropertyCallExp;
			/*@Thrown*/ @Nullable Boolean IF_symbol_0;
			if (symbol_0) {
				final /*@NonInvalid*/ @Nullable PropertyCallExp CAST_temp1_ast = (PropertyCallExp)temp1_ast;
				final /*@NonInvalid*/ @NonNull Object referredProperty = CAST_temp1_ast == null;
				/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Property safe_referredProperty_source;
				if (referredProperty == Boolean.TRUE) {
					safe_referredProperty_source = null;
				}
				else {
					assert CAST_temp1_ast != null;
					objectManager.getting(CAST_temp1_ast, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, false);
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Property referredProperty_0 = CAST_temp1_ast.getReferredProperty();
					safe_referredProperty_source = referredProperty_0;
				}
				final /*@Thrown*/ boolean symbol_1 = safe_referredProperty_source != null;
				/*@Thrown*/ @Nullable Boolean raw_unsafe;
				if (symbol_1) {
					if (safe_referredProperty_source == null) {
						throw throwNull(lNameExpCS_9, "Null where non-null value required");
					}
					final /*@NonInvalid*/ @Nullable RoundedBracketClauseCS roundedBrackets = lNameExpCS_9.getRoundedBrackets();
					final /*@NonInvalid*/ boolean eq = roundedBrackets == null;
					final /*@Thrown*/ @Nullable Boolean and;
					if (!eq) {
						and = ValueUtil.FALSE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_IF_eq_0;
						try {
							final /*@NonInvalid*/ @Nullable CallExpCS parentCallExpCS = INSTANCE_NameExpCS_parentAsCallExpCS.evaluate(lNameExpCS_9);
							final /*@NonInvalid*/ boolean eq_0 = parentCallExpCS == null;
							/*@Thrown*/ boolean IF_eq_0;
							if (eq_0) {
								IF_eq_0 = false;
							}
							else {
								if (parentCallExpCS == null) {
									throw throwNull(lNameExpCS_9, "Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCLCS\'::CallExpCS::navExp\'");
								}
								final /*@Thrown*/ @Nullable NavigationExpCS navExp = parentCallExpCS.getNavExp();
								final /*@Thrown*/ boolean eq_1 = lNameExpCS_9.equals(navExp);
								IF_eq_0 = eq_1;
							}
							CAUGHT_IF_eq_0 = IF_eq_0;
						}
						catch (Exception e) {
							CAUGHT_IF_eq_0 = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_IF_eq_0 == ValueUtil.FALSE_VALUE) {
							and = ValueUtil.FALSE_VALUE;
						}
						else {
							if (CAUGHT_IF_eq_0 instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_IF_eq_0;
							}
							and = ValueUtil.TRUE_VALUE;
						}
					}
					if (and == null) {
						throw throwNull(lNameExpCS_9, "Null if condition");
					}
					/*@Thrown*/ @Nullable Boolean IF_and;
					if (and) {
						final /*@Thrown*/ boolean eq_2 = false;
						/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class IF_eq_2;
						if (eq_2) {
							IF_eq_2 = null;
						}
						else {
							@SuppressWarnings("null")
							final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type = safe_referredProperty_source.getType();
							IF_eq_2 = type;
						}
						// mapping statements
						if (IF_eq_2 == null) {
							throw throwNull(lNameExpCS_9, "Null value for miniocl::TypedElement::type : miniocl::Class[1] assignment");
						}
						CAST_temp1_ast.setType(IF_eq_2);
						objectManager.assigned(CAST_temp1_ast, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, IF_eq_2, false);
						final /*@Thrown*/ @Nullable Boolean muNameExpCS__2__PropertyCallExp__1__type = ValueUtil.TRUE_VALUE;
						IF_and = muNameExpCS__2__PropertyCallExp__1__type;
					}
					else {
						IF_and = ValueUtil.FALSE_VALUE;
					}
					raw_unsafe = IF_and;
				}
				else {
					raw_unsafe = ValueUtil.FALSE_VALUE;
				}
				IF_symbol_0 = raw_unsafe;
			}
			else {
				IF_symbol_0 = ValueUtil.FALSE_VALUE;
			}
			return IF_symbol_0;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(lNameExpCS_9, thoseValues[0]);
		}
	}

	/**
	 *
	 * map:9 muOperationCS__2__Operation__ownedBodyExpression in MiniOCLCS2AS_qvtm_qvtcas {
	 *
	 *   guard:leftCS lOperationCS : minioclcs::OperationCS[1];
	 * check var ast : miniocl::Operation[?] := lOperationCS.ast;
	 * var body : minioclcs::ExpCS[?] := lOperationCS.body;
	 * check var ast1 : miniocl::OCLExpression[1] := body?.ast;
	 * var owningClass : miniocl::Class[?] := ast?.owningClass;
	 * var type : miniocl::Class[1] := ast1.type;
	 * var shadow : miniocl::Variable[1] := miniocl::Variable{name = 'self', type = owningClass
	 *   }
	 *   ;
	 * var shadow1 : miniocl::ExpressionInOCL[1] := miniocl::ExpressionInOCL{language = 'OCL', ownedBody = ast1, ownedSelfVar = shadow, type = type
	 *   };
	 * set ast.ownedBodyExpression := shadow1;
	 *
	 */
	protected boolean MAP_muOperationCS__2__Operation__ownedBodyExpression(final /*@NonInvalid*/ @NonNull OperationCS lOperationCS_3)  {
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Element temp1_ast = lOperationCS_3.getAst();
		final /*@NonInvalid*/ boolean symbol_0 = temp1_ast instanceof Operation;
		/*@Thrown*/ @Nullable Boolean IF_symbol_0;
		if (symbol_0) {
			final /*@NonInvalid*/ @Nullable Operation CAST_temp1_ast = (Operation)temp1_ast;
			final /*@NonInvalid*/ @Nullable ExpCS body = lOperationCS_3.getBody();
			final /*@NonInvalid*/ @NonNull Object ast = body == null;
			/*@Thrown*/ @Nullable Element safe_ast_source;
			if (ast == Boolean.TRUE) {
				safe_ast_source = null;
			}
			else {
				assert body != null;
				final /*@Thrown*/ @Nullable Element ast_0 = body.getAst();
				safe_ast_source = ast_0;
			}
			final /*@NonInvalid*/ boolean symbol_1 = safe_ast_source instanceof OCLExpression;
			/*@Thrown*/ @Nullable Boolean IF_symbol_1;
			if (symbol_1) {
				final /*@Thrown*/ @Nullable OCLExpression CAST_safe_ast_source = (OCLExpression)safe_ast_source;
				if (CAST_safe_ast_source == null) {
					throw throwNull(lOperationCS_3, "Null where non-null value required");
				}
				final /*@NonInvalid*/ @NonNull Object owningClass = CAST_temp1_ast == null;
				/*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class safe_owningClass_source;
				if (owningClass == Boolean.TRUE) {
					safe_owningClass_source = null;
				}
				else {
					assert CAST_temp1_ast != null;
					final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@Nullable Class owningClass_0 = CAST_temp1_ast.getOwningClass();
					safe_owningClass_source = owningClass_0;
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@NonNull Class type = CAST_safe_ast_source.getType();
				final /*@NonInvalid*/ @NonNull Property CTORid_name = idResolver.getProperty(PROPid_name);
				final /*@NonInvalid*/ @NonNull Property CTORid_type = idResolver.getProperty(PROPid_type);
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_Variable_0 = idResolver.getClass(CLSSid_Variable, null);
				final /*@Thrown*/ @NonNull Variable symbol_2 = (@NonNull Variable)TYP_miniocl_c_c_Variable_0.createInstance();
				CTORid_name.initValue(symbol_2, STR_self);
				CTORid_type.initValue(symbol_2, safe_owningClass_source);
				final /*@NonInvalid*/ @NonNull Property CTORid_language = idResolver.getProperty(PROPid_language);
				final /*@NonInvalid*/ @NonNull Property CTORid_ownedBody = idResolver.getProperty(PROPid_ownedBody);
				final /*@NonInvalid*/ @NonNull Property CTORid_ownedSelfVar = idResolver.getProperty(PROPid_ownedSelfVar);
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_miniocl_c_c_ExpressionInOCL_0 = idResolver.getClass(CLSSid_ExpressionInOCL, null);
				final /*@Thrown*/ @NonNull ExpressionInOCL symbol_3 = (@NonNull ExpressionInOCL)TYP_miniocl_c_c_ExpressionInOCL_0.createInstance();
				CTORid_language.initValue(symbol_3, STR_OCL);
				CTORid_ownedBody.initValue(symbol_3, CAST_safe_ast_source);
				CTORid_ownedSelfVar.initValue(symbol_3, symbol_2);
				CTORid_type.initValue(symbol_3, type);
				// mapping statements
				CAST_temp1_ast.setOwnedBodyExpression(symbol_3);
				final /*@Thrown*/ @Nullable Boolean muOperationCS__2__Operation__ownedBodyExpression = ValueUtil.TRUE_VALUE;
				IF_symbol_1 = muOperationCS__2__Operation__ownedBodyExpression;
			}
			else {
				IF_symbol_1 = ValueUtil.FALSE_VALUE;
			}
			IF_symbol_0 = IF_symbol_1;
		}
		else {
			IF_symbol_0 = ValueUtil.FALSE_VALUE;
		}
		return IF_symbol_0;
	}
}
