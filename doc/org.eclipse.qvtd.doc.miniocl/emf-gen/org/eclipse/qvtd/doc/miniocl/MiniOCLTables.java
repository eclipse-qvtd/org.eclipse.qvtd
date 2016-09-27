/*******************************************************************************
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 *   /org.eclipse.qvtd.doc.miniocl/model/MiniOCL.ecore
 * using:
 *   /org.eclipse.qvtd.doc.miniocl/model/MiniOCL.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.qvtd.doc.miniocl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorEnumeration;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorEnumerationLiteral;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreLibraryOppositeProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorFragment;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorOperation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorPropertyWithImplementation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorType;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.qvtd.doc.miniocl.MiniOCLTables;

/**
 * MiniOCLTables provides the dispatch tables for the miniocl for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
@SuppressWarnings("nls")
public class MiniOCLTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final @NonNull EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(MiniOCLPackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final @NonNull ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, org.eclipse.emf.ecore.EcorePackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0 = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/doc/MiniOCL/1.0", null, org.eclipse.qvtd.doc.miniocl.MiniOCLPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_CallExp = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("CallExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_CollectionItem = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("CollectionItem", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_CollectionLiteralExp = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("CollectionLiteralExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_CollectionLiteralPart = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("CollectionLiteralPart", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_CollectionRange = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("CollectionRange", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Constraint = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Constraint", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ExpressionInOCL = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("ExpressionInOCL", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Import = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Import", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_IterateExp = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("IterateExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_LetExp = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("LetExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_LoopExp = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("LoopExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OCLExpression = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("OCLExpression", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Operation = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Operation", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OperationCallExp = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("OperationCallExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Package = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Package", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Parameter = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Parameter", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Property = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Property", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PropertyCallExp = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("PropertyCallExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Root = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Root", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TypedElement = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("TypedElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Variable = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Variable", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_VariableExp = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("VariableExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull DataTypeId DATAid_EInt = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EInt", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull EnumerationId ENUMid_CollectionKind = org.eclipse.qvtd.doc.miniocl.MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getEnumerationId("CollectionKind");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_Class = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.doc.miniocl.MiniOCLTables.CLSSid_Class);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_Constraint = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.doc.miniocl.MiniOCLTables.CLSSid_Constraint);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_LoopExp = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.doc.miniocl.MiniOCLTables.CLSSid_LoopExp);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_OperationCallExp = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.doc.miniocl.MiniOCLTables.CLSSid_OperationCallExp);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_PropertyCallExp = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.doc.miniocl.MiniOCLTables.CLSSid_PropertyCallExp);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_TypedElement = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.doc.miniocl.MiniOCLTables.CLSSid_TypedElement);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_VariableExp = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.doc.miniocl.MiniOCLTables.CLSSid_VariableExp);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Class = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.doc.miniocl.MiniOCLTables.CLSSid_Class);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_CollectionLiteralPart = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.doc.miniocl.MiniOCLTables.CLSSid_CollectionLiteralPart);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Constraint = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.doc.miniocl.MiniOCLTables.CLSSid_Constraint);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Import = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.doc.miniocl.MiniOCLTables.CLSSid_Import);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_OCLExpression = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.doc.miniocl.MiniOCLTables.CLSSid_OCLExpression);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Operation = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.doc.miniocl.MiniOCLTables.CLSSid_Operation);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Package = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.doc.miniocl.MiniOCLTables.CLSSid_Package);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Parameter = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.doc.miniocl.MiniOCLTables.CLSSid_Parameter);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Property = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.doc.miniocl.MiniOCLTables.CLSSid_Property);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			MiniOCLTables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MiniOCLTables::TypeParameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The type descriptors for each type.
	 */
	public static class Types {
		static {
			Init.initStart();
			TypeParameters.init();
		}

		public static final @NonNull EcoreExecutorType _BooleanLiteralExp = new EcoreExecutorType(MiniOCLPackage.Literals.BOOLEAN_LITERAL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CallExp = new EcoreExecutorType(MiniOCLPackage.Literals.CALL_EXP, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _Class = new EcoreExecutorType(MiniOCLPackage.Literals.CLASS, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CollectionItem = new EcoreExecutorType(MiniOCLPackage.Literals.COLLECTION_ITEM, PACKAGE, 0);
		public static final @NonNull EcoreExecutorEnumeration _CollectionKind = new EcoreExecutorEnumeration(MiniOCLPackage.Literals.COLLECTION_KIND, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CollectionLiteralExp = new EcoreExecutorType(MiniOCLPackage.Literals.COLLECTION_LITERAL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CollectionLiteralPart = new EcoreExecutorType(MiniOCLPackage.Literals.COLLECTION_LITERAL_PART, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _CollectionRange = new EcoreExecutorType(MiniOCLPackage.Literals.COLLECTION_RANGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Constraint = new EcoreExecutorType(MiniOCLPackage.Literals.CONSTRAINT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Element = new EcoreExecutorType(MiniOCLPackage.Literals.ELEMENT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _ExpressionInOCL = new EcoreExecutorType(MiniOCLPackage.Literals.EXPRESSION_IN_OCL, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Feature = new EcoreExecutorType(MiniOCLPackage.Literals.FEATURE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Import = new EcoreExecutorType(MiniOCLPackage.Literals.IMPORT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _IntegerLiteralExp = new EcoreExecutorType(MiniOCLPackage.Literals.INTEGER_LITERAL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _IterateExp = new EcoreExecutorType(MiniOCLPackage.Literals.ITERATE_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _IteratorExp = new EcoreExecutorType(MiniOCLPackage.Literals.ITERATOR_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _LetExp = new EcoreExecutorType(MiniOCLPackage.Literals.LET_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _LiteralExp = new EcoreExecutorType(MiniOCLPackage.Literals.LITERAL_EXP, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _LoopExp = new EcoreExecutorType(MiniOCLPackage.Literals.LOOP_EXP, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _NamedElement = new EcoreExecutorType(MiniOCLPackage.Literals.NAMED_ELEMENT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _Namespace = new EcoreExecutorType(MiniOCLPackage.Literals.NAMESPACE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _NullLiteralExp = new EcoreExecutorType(MiniOCLPackage.Literals.NULL_LITERAL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OCLExpression = new EcoreExecutorType(MiniOCLPackage.Literals.OCL_EXPRESSION, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _OpaqueExpression = new EcoreExecutorType(MiniOCLPackage.Literals.OPAQUE_EXPRESSION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Operation = new EcoreExecutorType(MiniOCLPackage.Literals.OPERATION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OperationCallExp = new EcoreExecutorType(MiniOCLPackage.Literals.OPERATION_CALL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Package = new EcoreExecutorType(MiniOCLPackage.Literals.PACKAGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Parameter = new EcoreExecutorType(MiniOCLPackage.Literals.PARAMETER, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _PrimitiveLiteralExp = new EcoreExecutorType(MiniOCLPackage.Literals.PRIMITIVE_LITERAL_EXP, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _Property = new EcoreExecutorType(MiniOCLPackage.Literals.PROPERTY, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _PropertyCallExp = new EcoreExecutorType(MiniOCLPackage.Literals.PROPERTY_CALL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Root = new EcoreExecutorType(MiniOCLPackage.Literals.ROOT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TypedElement = new EcoreExecutorType(MiniOCLPackage.Literals.TYPED_ELEMENT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _Variable = new EcoreExecutorType(MiniOCLPackage.Literals.VARIABLE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _VariableExp = new EcoreExecutorType(MiniOCLPackage.Literals.VARIABLE_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Visitable = new EcoreExecutorType(MiniOCLPackage.Literals.VISITABLE, PACKAGE, 0 | ExecutorType.ABSTRACT);

		private static final @NonNull EcoreExecutorType @NonNull [] types = {
			_BooleanLiteralExp,
			_CallExp,
			_Class,
			_CollectionItem,
			_CollectionKind,
			_CollectionLiteralExp,
			_CollectionLiteralPart,
			_CollectionRange,
			_Constraint,
			_Element,
			_ExpressionInOCL,
			_Feature,
			_Import,
			_IntegerLiteralExp,
			_IterateExp,
			_IteratorExp,
			_LetExp,
			_LiteralExp,
			_LoopExp,
			_NamedElement,
			_Namespace,
			_NullLiteralExp,
			_OCLExpression,
			_OpaqueExpression,
			_Operation,
			_OperationCallExp,
			_Package,
			_Parameter,
			_PrimitiveLiteralExp,
			_Property,
			_PropertyCallExp,
			_Root,
			_TypedElement,
			_Variable,
			_VariableExp,
			_Visitable
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MiniOCLTables::Types and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragment descriptors for the local elements of each type and its supertypes.
	 */
	public static class Fragments {
		static {
			Init.initStart();
			Types.init();
		}

		private static final @NonNull ExecutorFragment _BooleanLiteralExp__BooleanLiteralExp = new ExecutorFragment(Types._BooleanLiteralExp, MiniOCLTables.Types._BooleanLiteralExp);
		private static final @NonNull ExecutorFragment _BooleanLiteralExp__Element = new ExecutorFragment(Types._BooleanLiteralExp, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _BooleanLiteralExp__LiteralExp = new ExecutorFragment(Types._BooleanLiteralExp, MiniOCLTables.Types._LiteralExp);
		private static final @NonNull ExecutorFragment _BooleanLiteralExp__OCLExpression = new ExecutorFragment(Types._BooleanLiteralExp, MiniOCLTables.Types._OCLExpression);
		private static final @NonNull ExecutorFragment _BooleanLiteralExp__OclAny = new ExecutorFragment(Types._BooleanLiteralExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _BooleanLiteralExp__OclElement = new ExecutorFragment(Types._BooleanLiteralExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _BooleanLiteralExp__PrimitiveLiteralExp = new ExecutorFragment(Types._BooleanLiteralExp, MiniOCLTables.Types._PrimitiveLiteralExp);
		private static final @NonNull ExecutorFragment _BooleanLiteralExp__TypedElement = new ExecutorFragment(Types._BooleanLiteralExp, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _BooleanLiteralExp__Visitable = new ExecutorFragment(Types._BooleanLiteralExp, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _CallExp__CallExp = new ExecutorFragment(Types._CallExp, MiniOCLTables.Types._CallExp);
		private static final @NonNull ExecutorFragment _CallExp__Element = new ExecutorFragment(Types._CallExp, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _CallExp__OCLExpression = new ExecutorFragment(Types._CallExp, MiniOCLTables.Types._OCLExpression);
		private static final @NonNull ExecutorFragment _CallExp__OclAny = new ExecutorFragment(Types._CallExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _CallExp__OclElement = new ExecutorFragment(Types._CallExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _CallExp__TypedElement = new ExecutorFragment(Types._CallExp, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _CallExp__Visitable = new ExecutorFragment(Types._CallExp, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Class__Class = new ExecutorFragment(Types._Class, MiniOCLTables.Types._Class);
		private static final @NonNull ExecutorFragment _Class__Element = new ExecutorFragment(Types._Class, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _Class__NamedElement = new ExecutorFragment(Types._Class, MiniOCLTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Class__Namespace = new ExecutorFragment(Types._Class, MiniOCLTables.Types._Namespace);
		private static final @NonNull ExecutorFragment _Class__OclAny = new ExecutorFragment(Types._Class, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Class__OclElement = new ExecutorFragment(Types._Class, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Class__Visitable = new ExecutorFragment(Types._Class, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _CollectionItem__CollectionItem = new ExecutorFragment(Types._CollectionItem, MiniOCLTables.Types._CollectionItem);
		private static final @NonNull ExecutorFragment _CollectionItem__CollectionLiteralPart = new ExecutorFragment(Types._CollectionItem, MiniOCLTables.Types._CollectionLiteralPart);
		private static final @NonNull ExecutorFragment _CollectionItem__Element = new ExecutorFragment(Types._CollectionItem, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _CollectionItem__OclAny = new ExecutorFragment(Types._CollectionItem, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _CollectionItem__OclElement = new ExecutorFragment(Types._CollectionItem, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _CollectionItem__TypedElement = new ExecutorFragment(Types._CollectionItem, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _CollectionItem__Visitable = new ExecutorFragment(Types._CollectionItem, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _CollectionKind__CollectionKind = new ExecutorFragment(Types._CollectionKind, MiniOCLTables.Types._CollectionKind);
		private static final @NonNull ExecutorFragment _CollectionKind__OclAny = new ExecutorFragment(Types._CollectionKind, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _CollectionKind__OclElement = new ExecutorFragment(Types._CollectionKind, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _CollectionKind__OclEnumeration = new ExecutorFragment(Types._CollectionKind, OCLstdlibTables.Types._OclEnumeration);
		private static final @NonNull ExecutorFragment _CollectionKind__OclType = new ExecutorFragment(Types._CollectionKind, OCLstdlibTables.Types._OclType);

		private static final @NonNull ExecutorFragment _CollectionLiteralExp__CollectionLiteralExp = new ExecutorFragment(Types._CollectionLiteralExp, MiniOCLTables.Types._CollectionLiteralExp);
		private static final @NonNull ExecutorFragment _CollectionLiteralExp__Element = new ExecutorFragment(Types._CollectionLiteralExp, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _CollectionLiteralExp__LiteralExp = new ExecutorFragment(Types._CollectionLiteralExp, MiniOCLTables.Types._LiteralExp);
		private static final @NonNull ExecutorFragment _CollectionLiteralExp__OCLExpression = new ExecutorFragment(Types._CollectionLiteralExp, MiniOCLTables.Types._OCLExpression);
		private static final @NonNull ExecutorFragment _CollectionLiteralExp__OclAny = new ExecutorFragment(Types._CollectionLiteralExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _CollectionLiteralExp__OclElement = new ExecutorFragment(Types._CollectionLiteralExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _CollectionLiteralExp__TypedElement = new ExecutorFragment(Types._CollectionLiteralExp, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _CollectionLiteralExp__Visitable = new ExecutorFragment(Types._CollectionLiteralExp, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _CollectionLiteralPart__CollectionLiteralPart = new ExecutorFragment(Types._CollectionLiteralPart, MiniOCLTables.Types._CollectionLiteralPart);
		private static final @NonNull ExecutorFragment _CollectionLiteralPart__Element = new ExecutorFragment(Types._CollectionLiteralPart, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _CollectionLiteralPart__OclAny = new ExecutorFragment(Types._CollectionLiteralPart, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _CollectionLiteralPart__OclElement = new ExecutorFragment(Types._CollectionLiteralPart, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _CollectionLiteralPart__TypedElement = new ExecutorFragment(Types._CollectionLiteralPart, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _CollectionLiteralPart__Visitable = new ExecutorFragment(Types._CollectionLiteralPart, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _CollectionRange__CollectionLiteralPart = new ExecutorFragment(Types._CollectionRange, MiniOCLTables.Types._CollectionLiteralPart);
		private static final @NonNull ExecutorFragment _CollectionRange__CollectionRange = new ExecutorFragment(Types._CollectionRange, MiniOCLTables.Types._CollectionRange);
		private static final @NonNull ExecutorFragment _CollectionRange__Element = new ExecutorFragment(Types._CollectionRange, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _CollectionRange__OclAny = new ExecutorFragment(Types._CollectionRange, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _CollectionRange__OclElement = new ExecutorFragment(Types._CollectionRange, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _CollectionRange__TypedElement = new ExecutorFragment(Types._CollectionRange, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _CollectionRange__Visitable = new ExecutorFragment(Types._CollectionRange, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Constraint__Constraint = new ExecutorFragment(Types._Constraint, MiniOCLTables.Types._Constraint);
		private static final @NonNull ExecutorFragment _Constraint__Element = new ExecutorFragment(Types._Constraint, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _Constraint__NamedElement = new ExecutorFragment(Types._Constraint, MiniOCLTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Constraint__OclAny = new ExecutorFragment(Types._Constraint, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Constraint__OclElement = new ExecutorFragment(Types._Constraint, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Constraint__Visitable = new ExecutorFragment(Types._Constraint, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Element__Element = new ExecutorFragment(Types._Element, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _Element__OclAny = new ExecutorFragment(Types._Element, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Element__OclElement = new ExecutorFragment(Types._Element, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Element__Visitable = new ExecutorFragment(Types._Element, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _ExpressionInOCL__Element = new ExecutorFragment(Types._ExpressionInOCL, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _ExpressionInOCL__ExpressionInOCL = new ExecutorFragment(Types._ExpressionInOCL, MiniOCLTables.Types._ExpressionInOCL);
		private static final @NonNull ExecutorFragment _ExpressionInOCL__OclAny = new ExecutorFragment(Types._ExpressionInOCL, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ExpressionInOCL__OclElement = new ExecutorFragment(Types._ExpressionInOCL, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _ExpressionInOCL__OpaqueExpression = new ExecutorFragment(Types._ExpressionInOCL, MiniOCLTables.Types._OpaqueExpression);
		private static final @NonNull ExecutorFragment _ExpressionInOCL__TypedElement = new ExecutorFragment(Types._ExpressionInOCL, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _ExpressionInOCL__Visitable = new ExecutorFragment(Types._ExpressionInOCL, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Feature__Element = new ExecutorFragment(Types._Feature, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _Feature__Feature = new ExecutorFragment(Types._Feature, MiniOCLTables.Types._Feature);
		private static final @NonNull ExecutorFragment _Feature__NamedElement = new ExecutorFragment(Types._Feature, MiniOCLTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Feature__OclAny = new ExecutorFragment(Types._Feature, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Feature__OclElement = new ExecutorFragment(Types._Feature, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Feature__TypedElement = new ExecutorFragment(Types._Feature, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _Feature__Visitable = new ExecutorFragment(Types._Feature, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Import__Element = new ExecutorFragment(Types._Import, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _Import__Import = new ExecutorFragment(Types._Import, MiniOCLTables.Types._Import);
		private static final @NonNull ExecutorFragment _Import__OclAny = new ExecutorFragment(Types._Import, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Import__OclElement = new ExecutorFragment(Types._Import, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Import__Visitable = new ExecutorFragment(Types._Import, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _IntegerLiteralExp__Element = new ExecutorFragment(Types._IntegerLiteralExp, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _IntegerLiteralExp__IntegerLiteralExp = new ExecutorFragment(Types._IntegerLiteralExp, MiniOCLTables.Types._IntegerLiteralExp);
		private static final @NonNull ExecutorFragment _IntegerLiteralExp__LiteralExp = new ExecutorFragment(Types._IntegerLiteralExp, MiniOCLTables.Types._LiteralExp);
		private static final @NonNull ExecutorFragment _IntegerLiteralExp__OCLExpression = new ExecutorFragment(Types._IntegerLiteralExp, MiniOCLTables.Types._OCLExpression);
		private static final @NonNull ExecutorFragment _IntegerLiteralExp__OclAny = new ExecutorFragment(Types._IntegerLiteralExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _IntegerLiteralExp__OclElement = new ExecutorFragment(Types._IntegerLiteralExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _IntegerLiteralExp__PrimitiveLiteralExp = new ExecutorFragment(Types._IntegerLiteralExp, MiniOCLTables.Types._PrimitiveLiteralExp);
		private static final @NonNull ExecutorFragment _IntegerLiteralExp__TypedElement = new ExecutorFragment(Types._IntegerLiteralExp, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _IntegerLiteralExp__Visitable = new ExecutorFragment(Types._IntegerLiteralExp, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _IterateExp__CallExp = new ExecutorFragment(Types._IterateExp, MiniOCLTables.Types._CallExp);
		private static final @NonNull ExecutorFragment _IterateExp__Element = new ExecutorFragment(Types._IterateExp, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _IterateExp__IterateExp = new ExecutorFragment(Types._IterateExp, MiniOCLTables.Types._IterateExp);
		private static final @NonNull ExecutorFragment _IterateExp__LoopExp = new ExecutorFragment(Types._IterateExp, MiniOCLTables.Types._LoopExp);
		private static final @NonNull ExecutorFragment _IterateExp__OCLExpression = new ExecutorFragment(Types._IterateExp, MiniOCLTables.Types._OCLExpression);
		private static final @NonNull ExecutorFragment _IterateExp__OclAny = new ExecutorFragment(Types._IterateExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _IterateExp__OclElement = new ExecutorFragment(Types._IterateExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _IterateExp__TypedElement = new ExecutorFragment(Types._IterateExp, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _IterateExp__Visitable = new ExecutorFragment(Types._IterateExp, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _IteratorExp__CallExp = new ExecutorFragment(Types._IteratorExp, MiniOCLTables.Types._CallExp);
		private static final @NonNull ExecutorFragment _IteratorExp__Element = new ExecutorFragment(Types._IteratorExp, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _IteratorExp__IteratorExp = new ExecutorFragment(Types._IteratorExp, MiniOCLTables.Types._IteratorExp);
		private static final @NonNull ExecutorFragment _IteratorExp__LoopExp = new ExecutorFragment(Types._IteratorExp, MiniOCLTables.Types._LoopExp);
		private static final @NonNull ExecutorFragment _IteratorExp__OCLExpression = new ExecutorFragment(Types._IteratorExp, MiniOCLTables.Types._OCLExpression);
		private static final @NonNull ExecutorFragment _IteratorExp__OclAny = new ExecutorFragment(Types._IteratorExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _IteratorExp__OclElement = new ExecutorFragment(Types._IteratorExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _IteratorExp__TypedElement = new ExecutorFragment(Types._IteratorExp, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _IteratorExp__Visitable = new ExecutorFragment(Types._IteratorExp, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _LetExp__Element = new ExecutorFragment(Types._LetExp, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _LetExp__LetExp = new ExecutorFragment(Types._LetExp, MiniOCLTables.Types._LetExp);
		private static final @NonNull ExecutorFragment _LetExp__OCLExpression = new ExecutorFragment(Types._LetExp, MiniOCLTables.Types._OCLExpression);
		private static final @NonNull ExecutorFragment _LetExp__OclAny = new ExecutorFragment(Types._LetExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _LetExp__OclElement = new ExecutorFragment(Types._LetExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _LetExp__TypedElement = new ExecutorFragment(Types._LetExp, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _LetExp__Visitable = new ExecutorFragment(Types._LetExp, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _LiteralExp__Element = new ExecutorFragment(Types._LiteralExp, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _LiteralExp__LiteralExp = new ExecutorFragment(Types._LiteralExp, MiniOCLTables.Types._LiteralExp);
		private static final @NonNull ExecutorFragment _LiteralExp__OCLExpression = new ExecutorFragment(Types._LiteralExp, MiniOCLTables.Types._OCLExpression);
		private static final @NonNull ExecutorFragment _LiteralExp__OclAny = new ExecutorFragment(Types._LiteralExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _LiteralExp__OclElement = new ExecutorFragment(Types._LiteralExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _LiteralExp__TypedElement = new ExecutorFragment(Types._LiteralExp, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _LiteralExp__Visitable = new ExecutorFragment(Types._LiteralExp, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _LoopExp__CallExp = new ExecutorFragment(Types._LoopExp, MiniOCLTables.Types._CallExp);
		private static final @NonNull ExecutorFragment _LoopExp__Element = new ExecutorFragment(Types._LoopExp, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _LoopExp__LoopExp = new ExecutorFragment(Types._LoopExp, MiniOCLTables.Types._LoopExp);
		private static final @NonNull ExecutorFragment _LoopExp__OCLExpression = new ExecutorFragment(Types._LoopExp, MiniOCLTables.Types._OCLExpression);
		private static final @NonNull ExecutorFragment _LoopExp__OclAny = new ExecutorFragment(Types._LoopExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _LoopExp__OclElement = new ExecutorFragment(Types._LoopExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _LoopExp__TypedElement = new ExecutorFragment(Types._LoopExp, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _LoopExp__Visitable = new ExecutorFragment(Types._LoopExp, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _NamedElement__Element = new ExecutorFragment(Types._NamedElement, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _NamedElement__NamedElement = new ExecutorFragment(Types._NamedElement, MiniOCLTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _NamedElement__OclAny = new ExecutorFragment(Types._NamedElement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NamedElement__OclElement = new ExecutorFragment(Types._NamedElement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _NamedElement__Visitable = new ExecutorFragment(Types._NamedElement, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Namespace__Element = new ExecutorFragment(Types._Namespace, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _Namespace__NamedElement = new ExecutorFragment(Types._Namespace, MiniOCLTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Namespace__Namespace = new ExecutorFragment(Types._Namespace, MiniOCLTables.Types._Namespace);
		private static final @NonNull ExecutorFragment _Namespace__OclAny = new ExecutorFragment(Types._Namespace, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Namespace__OclElement = new ExecutorFragment(Types._Namespace, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Namespace__Visitable = new ExecutorFragment(Types._Namespace, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _NullLiteralExp__Element = new ExecutorFragment(Types._NullLiteralExp, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _NullLiteralExp__LiteralExp = new ExecutorFragment(Types._NullLiteralExp, MiniOCLTables.Types._LiteralExp);
		private static final @NonNull ExecutorFragment _NullLiteralExp__NullLiteralExp = new ExecutorFragment(Types._NullLiteralExp, MiniOCLTables.Types._NullLiteralExp);
		private static final @NonNull ExecutorFragment _NullLiteralExp__OCLExpression = new ExecutorFragment(Types._NullLiteralExp, MiniOCLTables.Types._OCLExpression);
		private static final @NonNull ExecutorFragment _NullLiteralExp__OclAny = new ExecutorFragment(Types._NullLiteralExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NullLiteralExp__OclElement = new ExecutorFragment(Types._NullLiteralExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _NullLiteralExp__TypedElement = new ExecutorFragment(Types._NullLiteralExp, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _NullLiteralExp__Visitable = new ExecutorFragment(Types._NullLiteralExp, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _OCLExpression__Element = new ExecutorFragment(Types._OCLExpression, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _OCLExpression__OCLExpression = new ExecutorFragment(Types._OCLExpression, MiniOCLTables.Types._OCLExpression);
		private static final @NonNull ExecutorFragment _OCLExpression__OclAny = new ExecutorFragment(Types._OCLExpression, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OCLExpression__OclElement = new ExecutorFragment(Types._OCLExpression, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _OCLExpression__TypedElement = new ExecutorFragment(Types._OCLExpression, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _OCLExpression__Visitable = new ExecutorFragment(Types._OCLExpression, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _OpaqueExpression__Element = new ExecutorFragment(Types._OpaqueExpression, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _OpaqueExpression__OclAny = new ExecutorFragment(Types._OpaqueExpression, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OpaqueExpression__OclElement = new ExecutorFragment(Types._OpaqueExpression, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _OpaqueExpression__OpaqueExpression = new ExecutorFragment(Types._OpaqueExpression, MiniOCLTables.Types._OpaqueExpression);
		private static final @NonNull ExecutorFragment _OpaqueExpression__TypedElement = new ExecutorFragment(Types._OpaqueExpression, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _OpaqueExpression__Visitable = new ExecutorFragment(Types._OpaqueExpression, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Operation__Element = new ExecutorFragment(Types._Operation, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _Operation__Feature = new ExecutorFragment(Types._Operation, MiniOCLTables.Types._Feature);
		private static final @NonNull ExecutorFragment _Operation__NamedElement = new ExecutorFragment(Types._Operation, MiniOCLTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Operation__OclAny = new ExecutorFragment(Types._Operation, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Operation__OclElement = new ExecutorFragment(Types._Operation, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Operation__Operation = new ExecutorFragment(Types._Operation, MiniOCLTables.Types._Operation);
		private static final @NonNull ExecutorFragment _Operation__TypedElement = new ExecutorFragment(Types._Operation, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _Operation__Visitable = new ExecutorFragment(Types._Operation, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _OperationCallExp__CallExp = new ExecutorFragment(Types._OperationCallExp, MiniOCLTables.Types._CallExp);
		private static final @NonNull ExecutorFragment _OperationCallExp__Element = new ExecutorFragment(Types._OperationCallExp, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _OperationCallExp__OCLExpression = new ExecutorFragment(Types._OperationCallExp, MiniOCLTables.Types._OCLExpression);
		private static final @NonNull ExecutorFragment _OperationCallExp__OclAny = new ExecutorFragment(Types._OperationCallExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OperationCallExp__OclElement = new ExecutorFragment(Types._OperationCallExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _OperationCallExp__OperationCallExp = new ExecutorFragment(Types._OperationCallExp, MiniOCLTables.Types._OperationCallExp);
		private static final @NonNull ExecutorFragment _OperationCallExp__TypedElement = new ExecutorFragment(Types._OperationCallExp, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _OperationCallExp__Visitable = new ExecutorFragment(Types._OperationCallExp, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Package__Element = new ExecutorFragment(Types._Package, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _Package__NamedElement = new ExecutorFragment(Types._Package, MiniOCLTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Package__Namespace = new ExecutorFragment(Types._Package, MiniOCLTables.Types._Namespace);
		private static final @NonNull ExecutorFragment _Package__OclAny = new ExecutorFragment(Types._Package, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Package__OclElement = new ExecutorFragment(Types._Package, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Package__Package = new ExecutorFragment(Types._Package, MiniOCLTables.Types._Package);
		private static final @NonNull ExecutorFragment _Package__Visitable = new ExecutorFragment(Types._Package, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Parameter__Element = new ExecutorFragment(Types._Parameter, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _Parameter__NamedElement = new ExecutorFragment(Types._Parameter, MiniOCLTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Parameter__OclAny = new ExecutorFragment(Types._Parameter, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Parameter__OclElement = new ExecutorFragment(Types._Parameter, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Parameter__Parameter = new ExecutorFragment(Types._Parameter, MiniOCLTables.Types._Parameter);
		private static final @NonNull ExecutorFragment _Parameter__TypedElement = new ExecutorFragment(Types._Parameter, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _Parameter__Variable = new ExecutorFragment(Types._Parameter, MiniOCLTables.Types._Variable);
		private static final @NonNull ExecutorFragment _Parameter__Visitable = new ExecutorFragment(Types._Parameter, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _PrimitiveLiteralExp__Element = new ExecutorFragment(Types._PrimitiveLiteralExp, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _PrimitiveLiteralExp__LiteralExp = new ExecutorFragment(Types._PrimitiveLiteralExp, MiniOCLTables.Types._LiteralExp);
		private static final @NonNull ExecutorFragment _PrimitiveLiteralExp__OCLExpression = new ExecutorFragment(Types._PrimitiveLiteralExp, MiniOCLTables.Types._OCLExpression);
		private static final @NonNull ExecutorFragment _PrimitiveLiteralExp__OclAny = new ExecutorFragment(Types._PrimitiveLiteralExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _PrimitiveLiteralExp__OclElement = new ExecutorFragment(Types._PrimitiveLiteralExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _PrimitiveLiteralExp__PrimitiveLiteralExp = new ExecutorFragment(Types._PrimitiveLiteralExp, MiniOCLTables.Types._PrimitiveLiteralExp);
		private static final @NonNull ExecutorFragment _PrimitiveLiteralExp__TypedElement = new ExecutorFragment(Types._PrimitiveLiteralExp, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _PrimitiveLiteralExp__Visitable = new ExecutorFragment(Types._PrimitiveLiteralExp, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Property__Element = new ExecutorFragment(Types._Property, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _Property__Feature = new ExecutorFragment(Types._Property, MiniOCLTables.Types._Feature);
		private static final @NonNull ExecutorFragment _Property__NamedElement = new ExecutorFragment(Types._Property, MiniOCLTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Property__OclAny = new ExecutorFragment(Types._Property, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Property__OclElement = new ExecutorFragment(Types._Property, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Property__Property = new ExecutorFragment(Types._Property, MiniOCLTables.Types._Property);
		private static final @NonNull ExecutorFragment _Property__TypedElement = new ExecutorFragment(Types._Property, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _Property__Visitable = new ExecutorFragment(Types._Property, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _PropertyCallExp__CallExp = new ExecutorFragment(Types._PropertyCallExp, MiniOCLTables.Types._CallExp);
		private static final @NonNull ExecutorFragment _PropertyCallExp__Element = new ExecutorFragment(Types._PropertyCallExp, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _PropertyCallExp__OCLExpression = new ExecutorFragment(Types._PropertyCallExp, MiniOCLTables.Types._OCLExpression);
		private static final @NonNull ExecutorFragment _PropertyCallExp__OclAny = new ExecutorFragment(Types._PropertyCallExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _PropertyCallExp__OclElement = new ExecutorFragment(Types._PropertyCallExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _PropertyCallExp__PropertyCallExp = new ExecutorFragment(Types._PropertyCallExp, MiniOCLTables.Types._PropertyCallExp);
		private static final @NonNull ExecutorFragment _PropertyCallExp__TypedElement = new ExecutorFragment(Types._PropertyCallExp, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _PropertyCallExp__Visitable = new ExecutorFragment(Types._PropertyCallExp, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Root__Element = new ExecutorFragment(Types._Root, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _Root__OclAny = new ExecutorFragment(Types._Root, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Root__OclElement = new ExecutorFragment(Types._Root, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Root__Root = new ExecutorFragment(Types._Root, MiniOCLTables.Types._Root);
		private static final @NonNull ExecutorFragment _Root__Visitable = new ExecutorFragment(Types._Root, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _TypedElement__Element = new ExecutorFragment(Types._TypedElement, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _TypedElement__OclAny = new ExecutorFragment(Types._TypedElement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _TypedElement__OclElement = new ExecutorFragment(Types._TypedElement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _TypedElement__TypedElement = new ExecutorFragment(Types._TypedElement, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _TypedElement__Visitable = new ExecutorFragment(Types._TypedElement, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Variable__Element = new ExecutorFragment(Types._Variable, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _Variable__NamedElement = new ExecutorFragment(Types._Variable, MiniOCLTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Variable__OclAny = new ExecutorFragment(Types._Variable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Variable__OclElement = new ExecutorFragment(Types._Variable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Variable__TypedElement = new ExecutorFragment(Types._Variable, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _Variable__Variable = new ExecutorFragment(Types._Variable, MiniOCLTables.Types._Variable);
		private static final @NonNull ExecutorFragment _Variable__Visitable = new ExecutorFragment(Types._Variable, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _VariableExp__Element = new ExecutorFragment(Types._VariableExp, MiniOCLTables.Types._Element);
		private static final @NonNull ExecutorFragment _VariableExp__OCLExpression = new ExecutorFragment(Types._VariableExp, MiniOCLTables.Types._OCLExpression);
		private static final @NonNull ExecutorFragment _VariableExp__OclAny = new ExecutorFragment(Types._VariableExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _VariableExp__OclElement = new ExecutorFragment(Types._VariableExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _VariableExp__TypedElement = new ExecutorFragment(Types._VariableExp, MiniOCLTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _VariableExp__VariableExp = new ExecutorFragment(Types._VariableExp, MiniOCLTables.Types._VariableExp);
		private static final @NonNull ExecutorFragment _VariableExp__Visitable = new ExecutorFragment(Types._VariableExp, MiniOCLTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Visitable__OclAny = new ExecutorFragment(Types._Visitable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Visitable__OclElement = new ExecutorFragment(Types._Visitable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Visitable__Visitable = new ExecutorFragment(Types._Visitable, MiniOCLTables.Types._Visitable);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MiniOCLTables::Fragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The parameter lists shared by operations.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Parameters {
		static {
			Init.initStart();
			Fragments.init();
		}


		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MiniOCLTables::Parameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The operation descriptors for each operation of each type.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Operations {
		static {
			Init.initStart();
			Parameters.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MiniOCLTables::Operations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The property descriptors for each property of each type.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Properties {
		static {
			Init.initStart();
			Operations.init();
		}

		public static final @NonNull ExecutorProperty _BooleanLiteralExp__booleanSymbol = new EcoreExecutorProperty(MiniOCLPackage.Literals.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL, Types._BooleanLiteralExp, 0);

		public static final @NonNull ExecutorProperty _CallExp__ownedSource = new EcoreExecutorProperty(MiniOCLPackage.Literals.CALL_EXP__OWNED_SOURCE, Types._CallExp, 0);

		public static final @NonNull ExecutorProperty _Class__ownedOperations = new EcoreExecutorProperty(MiniOCLPackage.Literals.CLASS__OWNED_OPERATIONS, Types._Class, 0);
		public static final @NonNull ExecutorProperty _Class__ownedProperties = new EcoreExecutorProperty(MiniOCLPackage.Literals.CLASS__OWNED_PROPERTIES, Types._Class, 1);
		public static final @NonNull ExecutorProperty _Class__superClasses = new EcoreExecutorProperty(MiniOCLPackage.Literals.CLASS__SUPER_CLASSES, Types._Class, 2);
		public static final @NonNull ExecutorProperty _Class__Class__superClasses = new ExecutorPropertyWithImplementation("Class", Types._Class, 3, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.CLASS__SUPER_CLASSES));
		public static final @NonNull ExecutorProperty _Class__Constraint__constrainedElement = new ExecutorPropertyWithImplementation("Constraint", Types._Class, 4, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.CONSTRAINT__CONSTRAINED_ELEMENT));
		public static final @NonNull ExecutorProperty _Class__Package__ownedClasses = new ExecutorPropertyWithImplementation("Package", Types._Class, 5, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.PACKAGE__OWNED_CLASSES));
		public static final @NonNull ExecutorProperty _Class__TypedElement__type = new ExecutorPropertyWithImplementation("TypedElement", Types._Class, 6, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE));

		public static final @NonNull ExecutorProperty _CollectionItem__ownedItem = new EcoreExecutorProperty(MiniOCLPackage.Literals.COLLECTION_ITEM__OWNED_ITEM, Types._CollectionItem, 0);

		public static final @NonNull ExecutorProperty _CollectionLiteralExp__kind = new EcoreExecutorProperty(MiniOCLPackage.Literals.COLLECTION_LITERAL_EXP__KIND, Types._CollectionLiteralExp, 0);
		public static final @NonNull ExecutorProperty _CollectionLiteralExp__ownedParts = new EcoreExecutorProperty(MiniOCLPackage.Literals.COLLECTION_LITERAL_EXP__OWNED_PARTS, Types._CollectionLiteralExp, 1);

		public static final @NonNull ExecutorProperty _CollectionLiteralPart__CollectionLiteralExp__ownedParts = new ExecutorPropertyWithImplementation("CollectionLiteralExp", Types._CollectionLiteralPart, 0, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.COLLECTION_LITERAL_EXP__OWNED_PARTS));

		public static final @NonNull ExecutorProperty _CollectionRange__ownedFirst = new EcoreExecutorProperty(MiniOCLPackage.Literals.COLLECTION_RANGE__OWNED_FIRST, Types._CollectionRange, 0);
		public static final @NonNull ExecutorProperty _CollectionRange__ownedLast = new EcoreExecutorProperty(MiniOCLPackage.Literals.COLLECTION_RANGE__OWNED_LAST, Types._CollectionRange, 1);

		public static final @NonNull ExecutorProperty _Constraint__constrainedElement = new EcoreExecutorProperty(MiniOCLPackage.Literals.CONSTRAINT__CONSTRAINED_ELEMENT, Types._Constraint, 0);
		public static final @NonNull ExecutorProperty _Constraint__ownedSpecification = new EcoreExecutorProperty(MiniOCLPackage.Literals.CONSTRAINT__OWNED_SPECIFICATION, Types._Constraint, 1);
		public static final @NonNull ExecutorProperty _Constraint__Root__ownedConstraints = new ExecutorPropertyWithImplementation("Root", Types._Constraint, 2, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.ROOT__OWNED_CONSTRAINTS));

		public static final @NonNull ExecutorProperty _ExpressionInOCL__ownedBody = new EcoreExecutorProperty(MiniOCLPackage.Literals.EXPRESSION_IN_OCL__OWNED_BODY, Types._ExpressionInOCL, 0);
		public static final @NonNull ExecutorProperty _ExpressionInOCL__ownedSelfVar = new EcoreExecutorProperty(MiniOCLPackage.Literals.EXPRESSION_IN_OCL__OWNED_SELF_VAR, Types._ExpressionInOCL, 1);
		public static final @NonNull ExecutorProperty _ExpressionInOCL__Constraint__ownedSpecification = new ExecutorPropertyWithImplementation("Constraint", Types._ExpressionInOCL, 2, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.CONSTRAINT__OWNED_SPECIFICATION));
		public static final @NonNull ExecutorProperty _ExpressionInOCL__Operation__ownedBodyExpression = new ExecutorPropertyWithImplementation("Operation", Types._ExpressionInOCL, 3, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.OPERATION__OWNED_BODY_EXPRESSION));

		public static final @NonNull ExecutorProperty _Import__alias = new EcoreExecutorProperty(MiniOCLPackage.Literals.IMPORT__ALIAS, Types._Import, 0);
		public static final @NonNull ExecutorProperty _Import__uri = new EcoreExecutorProperty(MiniOCLPackage.Literals.IMPORT__URI, Types._Import, 1);
		public static final @NonNull ExecutorProperty _Import__Root__ownedImports = new ExecutorPropertyWithImplementation("Root", Types._Import, 2, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.ROOT__OWNED_IMPORTS));

		public static final @NonNull ExecutorProperty _IntegerLiteralExp__integerSymbol = new EcoreExecutorProperty(MiniOCLPackage.Literals.INTEGER_LITERAL_EXP__INTEGER_SYMBOL, Types._IntegerLiteralExp, 0);

		public static final @NonNull ExecutorProperty _IterateExp__ownedResult = new EcoreExecutorProperty(MiniOCLPackage.Literals.ITERATE_EXP__OWNED_RESULT, Types._IterateExp, 0);

		public static final @NonNull ExecutorProperty _IteratorExp__iterator = new EcoreExecutorProperty(MiniOCLPackage.Literals.ITERATOR_EXP__ITERATOR, Types._IteratorExp, 0);

		public static final @NonNull ExecutorProperty _LetExp__ownedIn = new EcoreExecutorProperty(MiniOCLPackage.Literals.LET_EXP__OWNED_IN, Types._LetExp, 0);
		public static final @NonNull ExecutorProperty _LetExp__ownedVariable = new EcoreExecutorProperty(MiniOCLPackage.Literals.LET_EXP__OWNED_VARIABLE, Types._LetExp, 1);

		public static final @NonNull ExecutorProperty _LoopExp__ownedBody = new EcoreExecutorProperty(MiniOCLPackage.Literals.LOOP_EXP__OWNED_BODY, Types._LoopExp, 0);
		public static final @NonNull ExecutorProperty _LoopExp__ownedIterator = new EcoreExecutorProperty(MiniOCLPackage.Literals.LOOP_EXP__OWNED_ITERATOR, Types._LoopExp, 1);

		public static final @NonNull ExecutorProperty _NamedElement__name = new EcoreExecutorProperty(MiniOCLPackage.Literals.NAMED_ELEMENT__NAME, Types._NamedElement, 0);

		public static final @NonNull ExecutorProperty _OCLExpression__CallExp__ownedSource = new ExecutorPropertyWithImplementation("CallExp", Types._OCLExpression, 0, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.CALL_EXP__OWNED_SOURCE));
		public static final @NonNull ExecutorProperty _OCLExpression__CollectionItem__ownedItem = new ExecutorPropertyWithImplementation("CollectionItem", Types._OCLExpression, 1, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.COLLECTION_ITEM__OWNED_ITEM));
		public static final @NonNull ExecutorProperty _OCLExpression__CollectionRange__ownedFirst = new ExecutorPropertyWithImplementation("CollectionRange", Types._OCLExpression, 2, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.COLLECTION_RANGE__OWNED_FIRST));
		public static final @NonNull ExecutorProperty _OCLExpression__CollectionRange__ownedLast = new ExecutorPropertyWithImplementation("CollectionRange", Types._OCLExpression, 3, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.COLLECTION_RANGE__OWNED_LAST));
		public static final @NonNull ExecutorProperty _OCLExpression__ExpressionInOCL__ownedBody = new ExecutorPropertyWithImplementation("ExpressionInOCL", Types._OCLExpression, 4, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.EXPRESSION_IN_OCL__OWNED_BODY));
		public static final @NonNull ExecutorProperty _OCLExpression__LetExp__ownedIn = new ExecutorPropertyWithImplementation("LetExp", Types._OCLExpression, 5, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.LET_EXP__OWNED_IN));
		public static final @NonNull ExecutorProperty _OCLExpression__LoopExp__ownedBody = new ExecutorPropertyWithImplementation("LoopExp", Types._OCLExpression, 6, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.LOOP_EXP__OWNED_BODY));
		public static final @NonNull ExecutorProperty _OCLExpression__OperationCallExp__ownedArguments = new ExecutorPropertyWithImplementation("OperationCallExp", Types._OCLExpression, 7, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.OPERATION_CALL_EXP__OWNED_ARGUMENTS));
		public static final @NonNull ExecutorProperty _OCLExpression__Variable__ownedInitExp = new ExecutorPropertyWithImplementation("Variable", Types._OCLExpression, 8, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.VARIABLE__OWNED_INIT_EXP));

		public static final @NonNull ExecutorProperty _OpaqueExpression__language = new EcoreExecutorProperty(MiniOCLPackage.Literals.OPAQUE_EXPRESSION__LANGUAGE, Types._OpaqueExpression, 0);

		public static final @NonNull ExecutorProperty _Operation__ownedBodyExpression = new EcoreExecutorProperty(MiniOCLPackage.Literals.OPERATION__OWNED_BODY_EXPRESSION, Types._Operation, 0);
		public static final @NonNull ExecutorProperty _Operation__ownedParameters = new EcoreExecutorProperty(MiniOCLPackage.Literals.OPERATION__OWNED_PARAMETERS, Types._Operation, 1);
		public static final @NonNull ExecutorProperty _Operation__owningClass = new EcoreExecutorProperty(MiniOCLPackage.Literals.OPERATION__OWNING_CLASS, Types._Operation, 2);
		public static final @NonNull ExecutorProperty _Operation__OperationCallExp__referredOperation = new ExecutorPropertyWithImplementation("OperationCallExp", Types._Operation, 3, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION));

		public static final @NonNull ExecutorProperty _OperationCallExp__ownedArguments = new EcoreExecutorProperty(MiniOCLPackage.Literals.OPERATION_CALL_EXP__OWNED_ARGUMENTS, Types._OperationCallExp, 0);
		public static final @NonNull ExecutorProperty _OperationCallExp__referredOperation = new EcoreExecutorProperty(MiniOCLPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION, Types._OperationCallExp, 1);

		public static final @NonNull ExecutorProperty _Package__ownedClasses = new EcoreExecutorProperty(MiniOCLPackage.Literals.PACKAGE__OWNED_CLASSES, Types._Package, 0);
		public static final @NonNull ExecutorProperty _Package__ownedPackages = new EcoreExecutorProperty(MiniOCLPackage.Literals.PACKAGE__OWNED_PACKAGES, Types._Package, 1);
		public static final @NonNull ExecutorProperty _Package__Package__ownedPackages = new ExecutorPropertyWithImplementation("Package", Types._Package, 2, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.PACKAGE__OWNED_PACKAGES));
		public static final @NonNull ExecutorProperty _Package__Root__ownedPackages = new ExecutorPropertyWithImplementation("Root", Types._Package, 3, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.ROOT__OWNED_PACKAGES));

		public static final @NonNull ExecutorProperty _Parameter__Operation__ownedParameters = new ExecutorPropertyWithImplementation("Operation", Types._Parameter, 0, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.OPERATION__OWNED_PARAMETERS));

		public static final @NonNull ExecutorProperty _Property__lowerBound = new EcoreExecutorProperty(MiniOCLPackage.Literals.PROPERTY__LOWER_BOUND, Types._Property, 0);
		public static final @NonNull ExecutorProperty _Property__owningClass = new EcoreExecutorProperty(MiniOCLPackage.Literals.PROPERTY__OWNING_CLASS, Types._Property, 1);
		public static final @NonNull ExecutorProperty _Property__upperBound = new EcoreExecutorProperty(MiniOCLPackage.Literals.PROPERTY__UPPER_BOUND, Types._Property, 2);
		public static final @NonNull ExecutorProperty _Property__PropertyCallExp__referredProperty = new ExecutorPropertyWithImplementation("PropertyCallExp", Types._Property, 3, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY));

		public static final @NonNull ExecutorProperty _PropertyCallExp__referredProperty = new EcoreExecutorProperty(MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, Types._PropertyCallExp, 0);

		public static final @NonNull ExecutorProperty _Root__ownedConstraints = new EcoreExecutorProperty(MiniOCLPackage.Literals.ROOT__OWNED_CONSTRAINTS, Types._Root, 0);
		public static final @NonNull ExecutorProperty _Root__ownedImports = new EcoreExecutorProperty(MiniOCLPackage.Literals.ROOT__OWNED_IMPORTS, Types._Root, 1);
		public static final @NonNull ExecutorProperty _Root__ownedPackages = new EcoreExecutorProperty(MiniOCLPackage.Literals.ROOT__OWNED_PACKAGES, Types._Root, 2);

		public static final @NonNull ExecutorProperty _TypedElement__type = new EcoreExecutorProperty(MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, Types._TypedElement, 0);

		public static final @NonNull ExecutorProperty _Variable__ownedInitExp = new EcoreExecutorProperty(MiniOCLPackage.Literals.VARIABLE__OWNED_INIT_EXP, Types._Variable, 0);
		public static final @NonNull ExecutorProperty _Variable__ExpressionInOCL__ownedSelfVar = new ExecutorPropertyWithImplementation("ExpressionInOCL", Types._Variable, 1, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.EXPRESSION_IN_OCL__OWNED_SELF_VAR));
		public static final @NonNull ExecutorProperty _Variable__IterateExp__ownedResult = new ExecutorPropertyWithImplementation("IterateExp", Types._Variable, 2, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.ITERATE_EXP__OWNED_RESULT));
		public static final @NonNull ExecutorProperty _Variable__LetExp__ownedVariable = new ExecutorPropertyWithImplementation("LetExp", Types._Variable, 3, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.LET_EXP__OWNED_VARIABLE));
		public static final @NonNull ExecutorProperty _Variable__LoopExp__ownedIterator = new ExecutorPropertyWithImplementation("LoopExp", Types._Variable, 4, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.LOOP_EXP__OWNED_ITERATOR));
		public static final @NonNull ExecutorProperty _Variable__VariableExp__referredVariable = new ExecutorPropertyWithImplementation("VariableExp", Types._Variable, 5, new EcoreLibraryOppositeProperty(MiniOCLPackage.Literals.VARIABLE_EXP__REFERRED_VARIABLE));

		public static final @NonNull ExecutorProperty _VariableExp__referredVariable = new EcoreExecutorProperty(MiniOCLPackage.Literals.VARIABLE_EXP__REFERRED_VARIABLE, Types._VariableExp, 0);
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MiniOCLTables::Properties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragments for all base types in depth order: OclAny first, OclSelf last.
	 */
	public static class TypeFragments {
		static {
			Init.initStart();
			Properties.init();
		}

		private static final @NonNull ExecutorFragment @NonNull [] _BooleanLiteralExp =
		{
			Fragments._BooleanLiteralExp__OclAny /* 0 */,
			Fragments._BooleanLiteralExp__OclElement /* 1 */,
			Fragments._BooleanLiteralExp__Visitable /* 2 */,
			Fragments._BooleanLiteralExp__Element /* 3 */,
			Fragments._BooleanLiteralExp__TypedElement /* 4 */,
			Fragments._BooleanLiteralExp__OCLExpression /* 5 */,
			Fragments._BooleanLiteralExp__LiteralExp /* 6 */,
			Fragments._BooleanLiteralExp__PrimitiveLiteralExp /* 7 */,
			Fragments._BooleanLiteralExp__BooleanLiteralExp /* 8 */
		};
		private static final int @NonNull [] __BooleanLiteralExp = { 1,1,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _CallExp =
		{
			Fragments._CallExp__OclAny /* 0 */,
			Fragments._CallExp__OclElement /* 1 */,
			Fragments._CallExp__Visitable /* 2 */,
			Fragments._CallExp__Element /* 3 */,
			Fragments._CallExp__TypedElement /* 4 */,
			Fragments._CallExp__OCLExpression /* 5 */,
			Fragments._CallExp__CallExp /* 6 */
		};
		private static final int @NonNull [] __CallExp = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Class =
		{
			Fragments._Class__OclAny /* 0 */,
			Fragments._Class__OclElement /* 1 */,
			Fragments._Class__Visitable /* 2 */,
			Fragments._Class__Element /* 3 */,
			Fragments._Class__NamedElement /* 4 */,
			Fragments._Class__Namespace /* 5 */,
			Fragments._Class__Class /* 6 */
		};
		private static final int @NonNull [] __Class = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _CollectionItem =
		{
			Fragments._CollectionItem__OclAny /* 0 */,
			Fragments._CollectionItem__OclElement /* 1 */,
			Fragments._CollectionItem__Visitable /* 2 */,
			Fragments._CollectionItem__Element /* 3 */,
			Fragments._CollectionItem__TypedElement /* 4 */,
			Fragments._CollectionItem__CollectionLiteralPart /* 5 */,
			Fragments._CollectionItem__CollectionItem /* 6 */
		};
		private static final int @NonNull [] __CollectionItem = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _CollectionKind =
		{
			Fragments._CollectionKind__OclAny /* 0 */,
			Fragments._CollectionKind__OclElement /* 1 */,
			Fragments._CollectionKind__OclType /* 2 */,
			Fragments._CollectionKind__OclEnumeration /* 3 */,
			Fragments._CollectionKind__CollectionKind /* 4 */
		};
		private static final int @NonNull [] __CollectionKind = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _CollectionLiteralExp =
		{
			Fragments._CollectionLiteralExp__OclAny /* 0 */,
			Fragments._CollectionLiteralExp__OclElement /* 1 */,
			Fragments._CollectionLiteralExp__Visitable /* 2 */,
			Fragments._CollectionLiteralExp__Element /* 3 */,
			Fragments._CollectionLiteralExp__TypedElement /* 4 */,
			Fragments._CollectionLiteralExp__OCLExpression /* 5 */,
			Fragments._CollectionLiteralExp__LiteralExp /* 6 */,
			Fragments._CollectionLiteralExp__CollectionLiteralExp /* 7 */
		};
		private static final int @NonNull [] __CollectionLiteralExp = { 1,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _CollectionLiteralPart =
		{
			Fragments._CollectionLiteralPart__OclAny /* 0 */,
			Fragments._CollectionLiteralPart__OclElement /* 1 */,
			Fragments._CollectionLiteralPart__Visitable /* 2 */,
			Fragments._CollectionLiteralPart__Element /* 3 */,
			Fragments._CollectionLiteralPart__TypedElement /* 4 */,
			Fragments._CollectionLiteralPart__CollectionLiteralPart /* 5 */
		};
		private static final int @NonNull [] __CollectionLiteralPart = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _CollectionRange =
		{
			Fragments._CollectionRange__OclAny /* 0 */,
			Fragments._CollectionRange__OclElement /* 1 */,
			Fragments._CollectionRange__Visitable /* 2 */,
			Fragments._CollectionRange__Element /* 3 */,
			Fragments._CollectionRange__TypedElement /* 4 */,
			Fragments._CollectionRange__CollectionLiteralPart /* 5 */,
			Fragments._CollectionRange__CollectionRange /* 6 */
		};
		private static final int @NonNull [] __CollectionRange = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Constraint =
		{
			Fragments._Constraint__OclAny /* 0 */,
			Fragments._Constraint__OclElement /* 1 */,
			Fragments._Constraint__Visitable /* 2 */,
			Fragments._Constraint__Element /* 3 */,
			Fragments._Constraint__NamedElement /* 4 */,
			Fragments._Constraint__Constraint /* 5 */
		};
		private static final int @NonNull [] __Constraint = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Element =
		{
			Fragments._Element__OclAny /* 0 */,
			Fragments._Element__OclElement /* 1 */,
			Fragments._Element__Visitable /* 2 */,
			Fragments._Element__Element /* 3 */
		};
		private static final int @NonNull [] __Element = { 1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ExpressionInOCL =
		{
			Fragments._ExpressionInOCL__OclAny /* 0 */,
			Fragments._ExpressionInOCL__OclElement /* 1 */,
			Fragments._ExpressionInOCL__Visitable /* 2 */,
			Fragments._ExpressionInOCL__Element /* 3 */,
			Fragments._ExpressionInOCL__TypedElement /* 4 */,
			Fragments._ExpressionInOCL__OpaqueExpression /* 5 */,
			Fragments._ExpressionInOCL__ExpressionInOCL /* 6 */
		};
		private static final int @NonNull [] __ExpressionInOCL = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Feature =
		{
			Fragments._Feature__OclAny /* 0 */,
			Fragments._Feature__OclElement /* 1 */,
			Fragments._Feature__Visitable /* 2 */,
			Fragments._Feature__Element /* 3 */,
			Fragments._Feature__NamedElement /* 4 */,
			Fragments._Feature__TypedElement /* 4 */,
			Fragments._Feature__Feature /* 5 */
		};
		private static final int @NonNull [] __Feature = { 1,1,1,1,2,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Import =
		{
			Fragments._Import__OclAny /* 0 */,
			Fragments._Import__OclElement /* 1 */,
			Fragments._Import__Visitable /* 2 */,
			Fragments._Import__Element /* 3 */,
			Fragments._Import__Import /* 4 */
		};
		private static final int @NonNull [] __Import = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _IntegerLiteralExp =
		{
			Fragments._IntegerLiteralExp__OclAny /* 0 */,
			Fragments._IntegerLiteralExp__OclElement /* 1 */,
			Fragments._IntegerLiteralExp__Visitable /* 2 */,
			Fragments._IntegerLiteralExp__Element /* 3 */,
			Fragments._IntegerLiteralExp__TypedElement /* 4 */,
			Fragments._IntegerLiteralExp__OCLExpression /* 5 */,
			Fragments._IntegerLiteralExp__LiteralExp /* 6 */,
			Fragments._IntegerLiteralExp__PrimitiveLiteralExp /* 7 */,
			Fragments._IntegerLiteralExp__IntegerLiteralExp /* 8 */
		};
		private static final int @NonNull [] __IntegerLiteralExp = { 1,1,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _IterateExp =
		{
			Fragments._IterateExp__OclAny /* 0 */,
			Fragments._IterateExp__OclElement /* 1 */,
			Fragments._IterateExp__Visitable /* 2 */,
			Fragments._IterateExp__Element /* 3 */,
			Fragments._IterateExp__TypedElement /* 4 */,
			Fragments._IterateExp__OCLExpression /* 5 */,
			Fragments._IterateExp__CallExp /* 6 */,
			Fragments._IterateExp__LoopExp /* 7 */,
			Fragments._IterateExp__IterateExp /* 8 */
		};
		private static final int @NonNull [] __IterateExp = { 1,1,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _IteratorExp =
		{
			Fragments._IteratorExp__OclAny /* 0 */,
			Fragments._IteratorExp__OclElement /* 1 */,
			Fragments._IteratorExp__Visitable /* 2 */,
			Fragments._IteratorExp__Element /* 3 */,
			Fragments._IteratorExp__TypedElement /* 4 */,
			Fragments._IteratorExp__OCLExpression /* 5 */,
			Fragments._IteratorExp__CallExp /* 6 */,
			Fragments._IteratorExp__LoopExp /* 7 */,
			Fragments._IteratorExp__IteratorExp /* 8 */
		};
		private static final int @NonNull [] __IteratorExp = { 1,1,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _LetExp =
		{
			Fragments._LetExp__OclAny /* 0 */,
			Fragments._LetExp__OclElement /* 1 */,
			Fragments._LetExp__Visitable /* 2 */,
			Fragments._LetExp__Element /* 3 */,
			Fragments._LetExp__TypedElement /* 4 */,
			Fragments._LetExp__OCLExpression /* 5 */,
			Fragments._LetExp__LetExp /* 6 */
		};
		private static final int @NonNull [] __LetExp = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _LiteralExp =
		{
			Fragments._LiteralExp__OclAny /* 0 */,
			Fragments._LiteralExp__OclElement /* 1 */,
			Fragments._LiteralExp__Visitable /* 2 */,
			Fragments._LiteralExp__Element /* 3 */,
			Fragments._LiteralExp__TypedElement /* 4 */,
			Fragments._LiteralExp__OCLExpression /* 5 */,
			Fragments._LiteralExp__LiteralExp /* 6 */
		};
		private static final int @NonNull [] __LiteralExp = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _LoopExp =
		{
			Fragments._LoopExp__OclAny /* 0 */,
			Fragments._LoopExp__OclElement /* 1 */,
			Fragments._LoopExp__Visitable /* 2 */,
			Fragments._LoopExp__Element /* 3 */,
			Fragments._LoopExp__TypedElement /* 4 */,
			Fragments._LoopExp__OCLExpression /* 5 */,
			Fragments._LoopExp__CallExp /* 6 */,
			Fragments._LoopExp__LoopExp /* 7 */
		};
		private static final int @NonNull [] __LoopExp = { 1,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _NamedElement =
		{
			Fragments._NamedElement__OclAny /* 0 */,
			Fragments._NamedElement__OclElement /* 1 */,
			Fragments._NamedElement__Visitable /* 2 */,
			Fragments._NamedElement__Element /* 3 */,
			Fragments._NamedElement__NamedElement /* 4 */
		};
		private static final int @NonNull [] __NamedElement = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Namespace =
		{
			Fragments._Namespace__OclAny /* 0 */,
			Fragments._Namespace__OclElement /* 1 */,
			Fragments._Namespace__Visitable /* 2 */,
			Fragments._Namespace__Element /* 3 */,
			Fragments._Namespace__NamedElement /* 4 */,
			Fragments._Namespace__Namespace /* 5 */
		};
		private static final int @NonNull [] __Namespace = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _NullLiteralExp =
		{
			Fragments._NullLiteralExp__OclAny /* 0 */,
			Fragments._NullLiteralExp__OclElement /* 1 */,
			Fragments._NullLiteralExp__Visitable /* 2 */,
			Fragments._NullLiteralExp__Element /* 3 */,
			Fragments._NullLiteralExp__TypedElement /* 4 */,
			Fragments._NullLiteralExp__OCLExpression /* 5 */,
			Fragments._NullLiteralExp__LiteralExp /* 6 */,
			Fragments._NullLiteralExp__NullLiteralExp /* 7 */
		};
		private static final int @NonNull [] __NullLiteralExp = { 1,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OCLExpression =
		{
			Fragments._OCLExpression__OclAny /* 0 */,
			Fragments._OCLExpression__OclElement /* 1 */,
			Fragments._OCLExpression__Visitable /* 2 */,
			Fragments._OCLExpression__Element /* 3 */,
			Fragments._OCLExpression__TypedElement /* 4 */,
			Fragments._OCLExpression__OCLExpression /* 5 */
		};
		private static final int @NonNull [] __OCLExpression = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OpaqueExpression =
		{
			Fragments._OpaqueExpression__OclAny /* 0 */,
			Fragments._OpaqueExpression__OclElement /* 1 */,
			Fragments._OpaqueExpression__Visitable /* 2 */,
			Fragments._OpaqueExpression__Element /* 3 */,
			Fragments._OpaqueExpression__TypedElement /* 4 */,
			Fragments._OpaqueExpression__OpaqueExpression /* 5 */
		};
		private static final int @NonNull [] __OpaqueExpression = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Operation =
		{
			Fragments._Operation__OclAny /* 0 */,
			Fragments._Operation__OclElement /* 1 */,
			Fragments._Operation__Visitable /* 2 */,
			Fragments._Operation__Element /* 3 */,
			Fragments._Operation__NamedElement /* 4 */,
			Fragments._Operation__TypedElement /* 4 */,
			Fragments._Operation__Feature /* 5 */,
			Fragments._Operation__Operation /* 6 */
		};
		private static final int @NonNull [] __Operation = { 1,1,1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OperationCallExp =
		{
			Fragments._OperationCallExp__OclAny /* 0 */,
			Fragments._OperationCallExp__OclElement /* 1 */,
			Fragments._OperationCallExp__Visitable /* 2 */,
			Fragments._OperationCallExp__Element /* 3 */,
			Fragments._OperationCallExp__TypedElement /* 4 */,
			Fragments._OperationCallExp__OCLExpression /* 5 */,
			Fragments._OperationCallExp__CallExp /* 6 */,
			Fragments._OperationCallExp__OperationCallExp /* 7 */
		};
		private static final int @NonNull [] __OperationCallExp = { 1,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Package =
		{
			Fragments._Package__OclAny /* 0 */,
			Fragments._Package__OclElement /* 1 */,
			Fragments._Package__Visitable /* 2 */,
			Fragments._Package__Element /* 3 */,
			Fragments._Package__NamedElement /* 4 */,
			Fragments._Package__Namespace /* 5 */,
			Fragments._Package__Package /* 6 */
		};
		private static final int @NonNull [] __Package = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Parameter =
		{
			Fragments._Parameter__OclAny /* 0 */,
			Fragments._Parameter__OclElement /* 1 */,
			Fragments._Parameter__Visitable /* 2 */,
			Fragments._Parameter__Element /* 3 */,
			Fragments._Parameter__NamedElement /* 4 */,
			Fragments._Parameter__TypedElement /* 4 */,
			Fragments._Parameter__Variable /* 5 */,
			Fragments._Parameter__Parameter /* 6 */
		};
		private static final int @NonNull [] __Parameter = { 1,1,1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _PrimitiveLiteralExp =
		{
			Fragments._PrimitiveLiteralExp__OclAny /* 0 */,
			Fragments._PrimitiveLiteralExp__OclElement /* 1 */,
			Fragments._PrimitiveLiteralExp__Visitable /* 2 */,
			Fragments._PrimitiveLiteralExp__Element /* 3 */,
			Fragments._PrimitiveLiteralExp__TypedElement /* 4 */,
			Fragments._PrimitiveLiteralExp__OCLExpression /* 5 */,
			Fragments._PrimitiveLiteralExp__LiteralExp /* 6 */,
			Fragments._PrimitiveLiteralExp__PrimitiveLiteralExp /* 7 */
		};
		private static final int @NonNull [] __PrimitiveLiteralExp = { 1,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Property =
		{
			Fragments._Property__OclAny /* 0 */,
			Fragments._Property__OclElement /* 1 */,
			Fragments._Property__Visitable /* 2 */,
			Fragments._Property__Element /* 3 */,
			Fragments._Property__NamedElement /* 4 */,
			Fragments._Property__TypedElement /* 4 */,
			Fragments._Property__Feature /* 5 */,
			Fragments._Property__Property /* 6 */
		};
		private static final int @NonNull [] __Property = { 1,1,1,1,2,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _PropertyCallExp =
		{
			Fragments._PropertyCallExp__OclAny /* 0 */,
			Fragments._PropertyCallExp__OclElement /* 1 */,
			Fragments._PropertyCallExp__Visitable /* 2 */,
			Fragments._PropertyCallExp__Element /* 3 */,
			Fragments._PropertyCallExp__TypedElement /* 4 */,
			Fragments._PropertyCallExp__OCLExpression /* 5 */,
			Fragments._PropertyCallExp__CallExp /* 6 */,
			Fragments._PropertyCallExp__PropertyCallExp /* 7 */
		};
		private static final int @NonNull [] __PropertyCallExp = { 1,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Root =
		{
			Fragments._Root__OclAny /* 0 */,
			Fragments._Root__OclElement /* 1 */,
			Fragments._Root__Visitable /* 2 */,
			Fragments._Root__Element /* 3 */,
			Fragments._Root__Root /* 4 */
		};
		private static final int @NonNull [] __Root = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _TypedElement =
		{
			Fragments._TypedElement__OclAny /* 0 */,
			Fragments._TypedElement__OclElement /* 1 */,
			Fragments._TypedElement__Visitable /* 2 */,
			Fragments._TypedElement__Element /* 3 */,
			Fragments._TypedElement__TypedElement /* 4 */
		};
		private static final int @NonNull [] __TypedElement = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Variable =
		{
			Fragments._Variable__OclAny /* 0 */,
			Fragments._Variable__OclElement /* 1 */,
			Fragments._Variable__Visitable /* 2 */,
			Fragments._Variable__Element /* 3 */,
			Fragments._Variable__NamedElement /* 4 */,
			Fragments._Variable__TypedElement /* 4 */,
			Fragments._Variable__Variable /* 5 */
		};
		private static final int @NonNull [] __Variable = { 1,1,1,1,2,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _VariableExp =
		{
			Fragments._VariableExp__OclAny /* 0 */,
			Fragments._VariableExp__OclElement /* 1 */,
			Fragments._VariableExp__Visitable /* 2 */,
			Fragments._VariableExp__Element /* 3 */,
			Fragments._VariableExp__TypedElement /* 4 */,
			Fragments._VariableExp__OCLExpression /* 5 */,
			Fragments._VariableExp__VariableExp /* 6 */
		};
		private static final int @NonNull [] __VariableExp = { 1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Visitable =
		{
			Fragments._Visitable__OclAny /* 0 */,
			Fragments._Visitable__OclElement /* 1 */,
			Fragments._Visitable__Visitable /* 2 */
		};
		private static final int @NonNull [] __Visitable = { 1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._BooleanLiteralExp.initFragments(_BooleanLiteralExp, __BooleanLiteralExp);
			Types._CallExp.initFragments(_CallExp, __CallExp);
			Types._Class.initFragments(_Class, __Class);
			Types._CollectionItem.initFragments(_CollectionItem, __CollectionItem);
			Types._CollectionKind.initFragments(_CollectionKind, __CollectionKind);
			Types._CollectionLiteralExp.initFragments(_CollectionLiteralExp, __CollectionLiteralExp);
			Types._CollectionLiteralPart.initFragments(_CollectionLiteralPart, __CollectionLiteralPart);
			Types._CollectionRange.initFragments(_CollectionRange, __CollectionRange);
			Types._Constraint.initFragments(_Constraint, __Constraint);
			Types._Element.initFragments(_Element, __Element);
			Types._ExpressionInOCL.initFragments(_ExpressionInOCL, __ExpressionInOCL);
			Types._Feature.initFragments(_Feature, __Feature);
			Types._Import.initFragments(_Import, __Import);
			Types._IntegerLiteralExp.initFragments(_IntegerLiteralExp, __IntegerLiteralExp);
			Types._IterateExp.initFragments(_IterateExp, __IterateExp);
			Types._IteratorExp.initFragments(_IteratorExp, __IteratorExp);
			Types._LetExp.initFragments(_LetExp, __LetExp);
			Types._LiteralExp.initFragments(_LiteralExp, __LiteralExp);
			Types._LoopExp.initFragments(_LoopExp, __LoopExp);
			Types._NamedElement.initFragments(_NamedElement, __NamedElement);
			Types._Namespace.initFragments(_Namespace, __Namespace);
			Types._NullLiteralExp.initFragments(_NullLiteralExp, __NullLiteralExp);
			Types._OCLExpression.initFragments(_OCLExpression, __OCLExpression);
			Types._OpaqueExpression.initFragments(_OpaqueExpression, __OpaqueExpression);
			Types._Operation.initFragments(_Operation, __Operation);
			Types._OperationCallExp.initFragments(_OperationCallExp, __OperationCallExp);
			Types._Package.initFragments(_Package, __Package);
			Types._Parameter.initFragments(_Parameter, __Parameter);
			Types._PrimitiveLiteralExp.initFragments(_PrimitiveLiteralExp, __PrimitiveLiteralExp);
			Types._Property.initFragments(_Property, __Property);
			Types._PropertyCallExp.initFragments(_PropertyCallExp, __PropertyCallExp);
			Types._Root.initFragments(_Root, __Root);
			Types._TypedElement.initFragments(_TypedElement, __TypedElement);
			Types._Variable.initFragments(_Variable, __Variable);
			Types._VariableExp.initFragments(_VariableExp, __VariableExp);
			Types._Visitable.initFragments(_Visitable, __Visitable);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MiniOCLTables::TypeFragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local operations or local operation overrides for each fragment of each type.
	 */
	public static class FragmentOperations {
		static {
			Init.initStart();
			TypeFragments.init();
		}

		private static final @NonNull ExecutorOperation @NonNull [] _BooleanLiteralExp__BooleanLiteralExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanLiteralExp__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanLiteralExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanLiteralExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanLiteralExp__PrimitiveLiteralExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanLiteralExp__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BooleanLiteralExp__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _CallExp__CallExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CallExp__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CallExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CallExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CallExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CallExp__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CallExp__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Class__Class = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Class__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Class__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Class__Namespace = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Class__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Class__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Class__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _CollectionItem__CollectionItem = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionItem__CollectionLiteralPart = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionItem__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionItem__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionItem__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionItem__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionItem__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _CollectionKind__CollectionKind = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionKind__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionKind__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionKind__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionKind__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralExp__CollectionLiteralExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralExp__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralExp__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralExp__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralPart__CollectionLiteralPart = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralPart__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralPart__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralPart__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralPart__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionLiteralPart__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _CollectionRange__CollectionRange = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionRange__CollectionLiteralPart = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionRange__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionRange__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionRange__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionRange__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionRange__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Constraint__Constraint = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Constraint__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Constraint__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Constraint__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Constraint__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Constraint__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Element__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Element__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Element__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Element__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionInOCL__ExpressionInOCL = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionInOCL__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionInOCL__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionInOCL__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionInOCL__OpaqueExpression = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionInOCL__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionInOCL__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Feature__Feature = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Feature__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Feature__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Feature__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Feature__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Feature__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Feature__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Import__Import = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Import__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Import__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Import__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Import__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _IntegerLiteralExp__IntegerLiteralExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IntegerLiteralExp__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IntegerLiteralExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IntegerLiteralExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IntegerLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _IntegerLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _IntegerLiteralExp__PrimitiveLiteralExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IntegerLiteralExp__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IntegerLiteralExp__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _IterateExp__IterateExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IterateExp__CallExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IterateExp__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IterateExp__LoopExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IterateExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IterateExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _IterateExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _IterateExp__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IterateExp__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _IteratorExp__IteratorExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorExp__CallExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorExp__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorExp__LoopExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorExp__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorExp__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _LetExp__LetExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LetExp__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LetExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LetExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _LetExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _LetExp__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LetExp__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _LiteralExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LiteralExp__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LiteralExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _LiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _LiteralExp__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LiteralExp__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _LoopExp__LoopExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LoopExp__CallExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LoopExp__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LoopExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LoopExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _LoopExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _LoopExp__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _LoopExp__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _NamedElement__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedElement__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedElement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedElement__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Namespace__Namespace = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Namespace__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Namespace__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Namespace__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Namespace__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Namespace__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _NullLiteralExp__NullLiteralExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NullLiteralExp__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NullLiteralExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NullLiteralExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NullLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NullLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NullLiteralExp__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NullLiteralExp__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _OCLExpression__OCLExpression = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OCLExpression__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OCLExpression__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OCLExpression__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OCLExpression__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OCLExpression__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _OpaqueExpression__OpaqueExpression = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OpaqueExpression__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OpaqueExpression__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OpaqueExpression__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OpaqueExpression__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OpaqueExpression__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Operation__Operation = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Operation__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Operation__Feature = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Operation__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Operation__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Operation__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Operation__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Operation__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallExp__OperationCallExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallExp__CallExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallExp__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallExp__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallExp__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Package__Package = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Package__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Package__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Package__Namespace = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Package__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Package__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Package__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Parameter__Parameter = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Parameter__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Parameter__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Parameter__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Parameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Parameter__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Parameter__Variable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Parameter__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _PrimitiveLiteralExp__PrimitiveLiteralExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PrimitiveLiteralExp__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PrimitiveLiteralExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PrimitiveLiteralExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PrimitiveLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PrimitiveLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PrimitiveLiteralExp__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PrimitiveLiteralExp__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Property__Property = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Property__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Property__Feature = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Property__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Property__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Property__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Property__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Property__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _PropertyCallExp__PropertyCallExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyCallExp__CallExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyCallExp__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyCallExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyCallExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyCallExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyCallExp__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyCallExp__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Root__Root = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Root__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Root__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Root__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Root__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _TypedElement__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TypedElement__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TypedElement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TypedElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TypedElement__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Variable__Variable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Variable__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Variable__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Variable__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Variable__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Variable__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Variable__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _VariableExp__VariableExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableExp__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableExp__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableExp__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Visitable__Visitable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Visitable__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Visitable__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._BooleanLiteralExp__BooleanLiteralExp.initOperations(_BooleanLiteralExp__BooleanLiteralExp);
			Fragments._BooleanLiteralExp__Element.initOperations(_BooleanLiteralExp__Element);
			Fragments._BooleanLiteralExp__LiteralExp.initOperations(_BooleanLiteralExp__LiteralExp);
			Fragments._BooleanLiteralExp__OCLExpression.initOperations(_BooleanLiteralExp__OCLExpression);
			Fragments._BooleanLiteralExp__OclAny.initOperations(_BooleanLiteralExp__OclAny);
			Fragments._BooleanLiteralExp__OclElement.initOperations(_BooleanLiteralExp__OclElement);
			Fragments._BooleanLiteralExp__PrimitiveLiteralExp.initOperations(_BooleanLiteralExp__PrimitiveLiteralExp);
			Fragments._BooleanLiteralExp__TypedElement.initOperations(_BooleanLiteralExp__TypedElement);
			Fragments._BooleanLiteralExp__Visitable.initOperations(_BooleanLiteralExp__Visitable);

			Fragments._CallExp__CallExp.initOperations(_CallExp__CallExp);
			Fragments._CallExp__Element.initOperations(_CallExp__Element);
			Fragments._CallExp__OCLExpression.initOperations(_CallExp__OCLExpression);
			Fragments._CallExp__OclAny.initOperations(_CallExp__OclAny);
			Fragments._CallExp__OclElement.initOperations(_CallExp__OclElement);
			Fragments._CallExp__TypedElement.initOperations(_CallExp__TypedElement);
			Fragments._CallExp__Visitable.initOperations(_CallExp__Visitable);

			Fragments._Class__Class.initOperations(_Class__Class);
			Fragments._Class__Element.initOperations(_Class__Element);
			Fragments._Class__NamedElement.initOperations(_Class__NamedElement);
			Fragments._Class__Namespace.initOperations(_Class__Namespace);
			Fragments._Class__OclAny.initOperations(_Class__OclAny);
			Fragments._Class__OclElement.initOperations(_Class__OclElement);
			Fragments._Class__Visitable.initOperations(_Class__Visitable);

			Fragments._CollectionItem__CollectionItem.initOperations(_CollectionItem__CollectionItem);
			Fragments._CollectionItem__CollectionLiteralPart.initOperations(_CollectionItem__CollectionLiteralPart);
			Fragments._CollectionItem__Element.initOperations(_CollectionItem__Element);
			Fragments._CollectionItem__OclAny.initOperations(_CollectionItem__OclAny);
			Fragments._CollectionItem__OclElement.initOperations(_CollectionItem__OclElement);
			Fragments._CollectionItem__TypedElement.initOperations(_CollectionItem__TypedElement);
			Fragments._CollectionItem__Visitable.initOperations(_CollectionItem__Visitable);

			Fragments._CollectionKind__CollectionKind.initOperations(_CollectionKind__CollectionKind);
			Fragments._CollectionKind__OclAny.initOperations(_CollectionKind__OclAny);
			Fragments._CollectionKind__OclElement.initOperations(_CollectionKind__OclElement);
			Fragments._CollectionKind__OclEnumeration.initOperations(_CollectionKind__OclEnumeration);
			Fragments._CollectionKind__OclType.initOperations(_CollectionKind__OclType);

			Fragments._CollectionLiteralExp__CollectionLiteralExp.initOperations(_CollectionLiteralExp__CollectionLiteralExp);
			Fragments._CollectionLiteralExp__Element.initOperations(_CollectionLiteralExp__Element);
			Fragments._CollectionLiteralExp__LiteralExp.initOperations(_CollectionLiteralExp__LiteralExp);
			Fragments._CollectionLiteralExp__OCLExpression.initOperations(_CollectionLiteralExp__OCLExpression);
			Fragments._CollectionLiteralExp__OclAny.initOperations(_CollectionLiteralExp__OclAny);
			Fragments._CollectionLiteralExp__OclElement.initOperations(_CollectionLiteralExp__OclElement);
			Fragments._CollectionLiteralExp__TypedElement.initOperations(_CollectionLiteralExp__TypedElement);
			Fragments._CollectionLiteralExp__Visitable.initOperations(_CollectionLiteralExp__Visitable);

			Fragments._CollectionLiteralPart__CollectionLiteralPart.initOperations(_CollectionLiteralPart__CollectionLiteralPart);
			Fragments._CollectionLiteralPart__Element.initOperations(_CollectionLiteralPart__Element);
			Fragments._CollectionLiteralPart__OclAny.initOperations(_CollectionLiteralPart__OclAny);
			Fragments._CollectionLiteralPart__OclElement.initOperations(_CollectionLiteralPart__OclElement);
			Fragments._CollectionLiteralPart__TypedElement.initOperations(_CollectionLiteralPart__TypedElement);
			Fragments._CollectionLiteralPart__Visitable.initOperations(_CollectionLiteralPart__Visitable);

			Fragments._CollectionRange__CollectionLiteralPart.initOperations(_CollectionRange__CollectionLiteralPart);
			Fragments._CollectionRange__CollectionRange.initOperations(_CollectionRange__CollectionRange);
			Fragments._CollectionRange__Element.initOperations(_CollectionRange__Element);
			Fragments._CollectionRange__OclAny.initOperations(_CollectionRange__OclAny);
			Fragments._CollectionRange__OclElement.initOperations(_CollectionRange__OclElement);
			Fragments._CollectionRange__TypedElement.initOperations(_CollectionRange__TypedElement);
			Fragments._CollectionRange__Visitable.initOperations(_CollectionRange__Visitable);

			Fragments._Constraint__Constraint.initOperations(_Constraint__Constraint);
			Fragments._Constraint__Element.initOperations(_Constraint__Element);
			Fragments._Constraint__NamedElement.initOperations(_Constraint__NamedElement);
			Fragments._Constraint__OclAny.initOperations(_Constraint__OclAny);
			Fragments._Constraint__OclElement.initOperations(_Constraint__OclElement);
			Fragments._Constraint__Visitable.initOperations(_Constraint__Visitable);

			Fragments._Element__Element.initOperations(_Element__Element);
			Fragments._Element__OclAny.initOperations(_Element__OclAny);
			Fragments._Element__OclElement.initOperations(_Element__OclElement);
			Fragments._Element__Visitable.initOperations(_Element__Visitable);

			Fragments._ExpressionInOCL__Element.initOperations(_ExpressionInOCL__Element);
			Fragments._ExpressionInOCL__ExpressionInOCL.initOperations(_ExpressionInOCL__ExpressionInOCL);
			Fragments._ExpressionInOCL__OclAny.initOperations(_ExpressionInOCL__OclAny);
			Fragments._ExpressionInOCL__OclElement.initOperations(_ExpressionInOCL__OclElement);
			Fragments._ExpressionInOCL__OpaqueExpression.initOperations(_ExpressionInOCL__OpaqueExpression);
			Fragments._ExpressionInOCL__TypedElement.initOperations(_ExpressionInOCL__TypedElement);
			Fragments._ExpressionInOCL__Visitable.initOperations(_ExpressionInOCL__Visitable);

			Fragments._Feature__Element.initOperations(_Feature__Element);
			Fragments._Feature__Feature.initOperations(_Feature__Feature);
			Fragments._Feature__NamedElement.initOperations(_Feature__NamedElement);
			Fragments._Feature__OclAny.initOperations(_Feature__OclAny);
			Fragments._Feature__OclElement.initOperations(_Feature__OclElement);
			Fragments._Feature__TypedElement.initOperations(_Feature__TypedElement);
			Fragments._Feature__Visitable.initOperations(_Feature__Visitable);

			Fragments._Import__Element.initOperations(_Import__Element);
			Fragments._Import__Import.initOperations(_Import__Import);
			Fragments._Import__OclAny.initOperations(_Import__OclAny);
			Fragments._Import__OclElement.initOperations(_Import__OclElement);
			Fragments._Import__Visitable.initOperations(_Import__Visitable);

			Fragments._IntegerLiteralExp__Element.initOperations(_IntegerLiteralExp__Element);
			Fragments._IntegerLiteralExp__IntegerLiteralExp.initOperations(_IntegerLiteralExp__IntegerLiteralExp);
			Fragments._IntegerLiteralExp__LiteralExp.initOperations(_IntegerLiteralExp__LiteralExp);
			Fragments._IntegerLiteralExp__OCLExpression.initOperations(_IntegerLiteralExp__OCLExpression);
			Fragments._IntegerLiteralExp__OclAny.initOperations(_IntegerLiteralExp__OclAny);
			Fragments._IntegerLiteralExp__OclElement.initOperations(_IntegerLiteralExp__OclElement);
			Fragments._IntegerLiteralExp__PrimitiveLiteralExp.initOperations(_IntegerLiteralExp__PrimitiveLiteralExp);
			Fragments._IntegerLiteralExp__TypedElement.initOperations(_IntegerLiteralExp__TypedElement);
			Fragments._IntegerLiteralExp__Visitable.initOperations(_IntegerLiteralExp__Visitable);

			Fragments._IterateExp__CallExp.initOperations(_IterateExp__CallExp);
			Fragments._IterateExp__Element.initOperations(_IterateExp__Element);
			Fragments._IterateExp__IterateExp.initOperations(_IterateExp__IterateExp);
			Fragments._IterateExp__LoopExp.initOperations(_IterateExp__LoopExp);
			Fragments._IterateExp__OCLExpression.initOperations(_IterateExp__OCLExpression);
			Fragments._IterateExp__OclAny.initOperations(_IterateExp__OclAny);
			Fragments._IterateExp__OclElement.initOperations(_IterateExp__OclElement);
			Fragments._IterateExp__TypedElement.initOperations(_IterateExp__TypedElement);
			Fragments._IterateExp__Visitable.initOperations(_IterateExp__Visitable);

			Fragments._IteratorExp__CallExp.initOperations(_IteratorExp__CallExp);
			Fragments._IteratorExp__Element.initOperations(_IteratorExp__Element);
			Fragments._IteratorExp__IteratorExp.initOperations(_IteratorExp__IteratorExp);
			Fragments._IteratorExp__LoopExp.initOperations(_IteratorExp__LoopExp);
			Fragments._IteratorExp__OCLExpression.initOperations(_IteratorExp__OCLExpression);
			Fragments._IteratorExp__OclAny.initOperations(_IteratorExp__OclAny);
			Fragments._IteratorExp__OclElement.initOperations(_IteratorExp__OclElement);
			Fragments._IteratorExp__TypedElement.initOperations(_IteratorExp__TypedElement);
			Fragments._IteratorExp__Visitable.initOperations(_IteratorExp__Visitable);

			Fragments._LetExp__Element.initOperations(_LetExp__Element);
			Fragments._LetExp__LetExp.initOperations(_LetExp__LetExp);
			Fragments._LetExp__OCLExpression.initOperations(_LetExp__OCLExpression);
			Fragments._LetExp__OclAny.initOperations(_LetExp__OclAny);
			Fragments._LetExp__OclElement.initOperations(_LetExp__OclElement);
			Fragments._LetExp__TypedElement.initOperations(_LetExp__TypedElement);
			Fragments._LetExp__Visitable.initOperations(_LetExp__Visitable);

			Fragments._LiteralExp__Element.initOperations(_LiteralExp__Element);
			Fragments._LiteralExp__LiteralExp.initOperations(_LiteralExp__LiteralExp);
			Fragments._LiteralExp__OCLExpression.initOperations(_LiteralExp__OCLExpression);
			Fragments._LiteralExp__OclAny.initOperations(_LiteralExp__OclAny);
			Fragments._LiteralExp__OclElement.initOperations(_LiteralExp__OclElement);
			Fragments._LiteralExp__TypedElement.initOperations(_LiteralExp__TypedElement);
			Fragments._LiteralExp__Visitable.initOperations(_LiteralExp__Visitable);

			Fragments._LoopExp__CallExp.initOperations(_LoopExp__CallExp);
			Fragments._LoopExp__Element.initOperations(_LoopExp__Element);
			Fragments._LoopExp__LoopExp.initOperations(_LoopExp__LoopExp);
			Fragments._LoopExp__OCLExpression.initOperations(_LoopExp__OCLExpression);
			Fragments._LoopExp__OclAny.initOperations(_LoopExp__OclAny);
			Fragments._LoopExp__OclElement.initOperations(_LoopExp__OclElement);
			Fragments._LoopExp__TypedElement.initOperations(_LoopExp__TypedElement);
			Fragments._LoopExp__Visitable.initOperations(_LoopExp__Visitable);

			Fragments._NamedElement__Element.initOperations(_NamedElement__Element);
			Fragments._NamedElement__NamedElement.initOperations(_NamedElement__NamedElement);
			Fragments._NamedElement__OclAny.initOperations(_NamedElement__OclAny);
			Fragments._NamedElement__OclElement.initOperations(_NamedElement__OclElement);
			Fragments._NamedElement__Visitable.initOperations(_NamedElement__Visitable);

			Fragments._Namespace__Element.initOperations(_Namespace__Element);
			Fragments._Namespace__NamedElement.initOperations(_Namespace__NamedElement);
			Fragments._Namespace__Namespace.initOperations(_Namespace__Namespace);
			Fragments._Namespace__OclAny.initOperations(_Namespace__OclAny);
			Fragments._Namespace__OclElement.initOperations(_Namespace__OclElement);
			Fragments._Namespace__Visitable.initOperations(_Namespace__Visitable);

			Fragments._NullLiteralExp__Element.initOperations(_NullLiteralExp__Element);
			Fragments._NullLiteralExp__LiteralExp.initOperations(_NullLiteralExp__LiteralExp);
			Fragments._NullLiteralExp__NullLiteralExp.initOperations(_NullLiteralExp__NullLiteralExp);
			Fragments._NullLiteralExp__OCLExpression.initOperations(_NullLiteralExp__OCLExpression);
			Fragments._NullLiteralExp__OclAny.initOperations(_NullLiteralExp__OclAny);
			Fragments._NullLiteralExp__OclElement.initOperations(_NullLiteralExp__OclElement);
			Fragments._NullLiteralExp__TypedElement.initOperations(_NullLiteralExp__TypedElement);
			Fragments._NullLiteralExp__Visitable.initOperations(_NullLiteralExp__Visitable);

			Fragments._OCLExpression__Element.initOperations(_OCLExpression__Element);
			Fragments._OCLExpression__OCLExpression.initOperations(_OCLExpression__OCLExpression);
			Fragments._OCLExpression__OclAny.initOperations(_OCLExpression__OclAny);
			Fragments._OCLExpression__OclElement.initOperations(_OCLExpression__OclElement);
			Fragments._OCLExpression__TypedElement.initOperations(_OCLExpression__TypedElement);
			Fragments._OCLExpression__Visitable.initOperations(_OCLExpression__Visitable);

			Fragments._OpaqueExpression__Element.initOperations(_OpaqueExpression__Element);
			Fragments._OpaqueExpression__OclAny.initOperations(_OpaqueExpression__OclAny);
			Fragments._OpaqueExpression__OclElement.initOperations(_OpaqueExpression__OclElement);
			Fragments._OpaqueExpression__OpaqueExpression.initOperations(_OpaqueExpression__OpaqueExpression);
			Fragments._OpaqueExpression__TypedElement.initOperations(_OpaqueExpression__TypedElement);
			Fragments._OpaqueExpression__Visitable.initOperations(_OpaqueExpression__Visitable);

			Fragments._Operation__Element.initOperations(_Operation__Element);
			Fragments._Operation__Feature.initOperations(_Operation__Feature);
			Fragments._Operation__NamedElement.initOperations(_Operation__NamedElement);
			Fragments._Operation__OclAny.initOperations(_Operation__OclAny);
			Fragments._Operation__OclElement.initOperations(_Operation__OclElement);
			Fragments._Operation__Operation.initOperations(_Operation__Operation);
			Fragments._Operation__TypedElement.initOperations(_Operation__TypedElement);
			Fragments._Operation__Visitable.initOperations(_Operation__Visitable);

			Fragments._OperationCallExp__CallExp.initOperations(_OperationCallExp__CallExp);
			Fragments._OperationCallExp__Element.initOperations(_OperationCallExp__Element);
			Fragments._OperationCallExp__OCLExpression.initOperations(_OperationCallExp__OCLExpression);
			Fragments._OperationCallExp__OclAny.initOperations(_OperationCallExp__OclAny);
			Fragments._OperationCallExp__OclElement.initOperations(_OperationCallExp__OclElement);
			Fragments._OperationCallExp__OperationCallExp.initOperations(_OperationCallExp__OperationCallExp);
			Fragments._OperationCallExp__TypedElement.initOperations(_OperationCallExp__TypedElement);
			Fragments._OperationCallExp__Visitable.initOperations(_OperationCallExp__Visitable);

			Fragments._Package__Element.initOperations(_Package__Element);
			Fragments._Package__NamedElement.initOperations(_Package__NamedElement);
			Fragments._Package__Namespace.initOperations(_Package__Namespace);
			Fragments._Package__OclAny.initOperations(_Package__OclAny);
			Fragments._Package__OclElement.initOperations(_Package__OclElement);
			Fragments._Package__Package.initOperations(_Package__Package);
			Fragments._Package__Visitable.initOperations(_Package__Visitable);

			Fragments._Parameter__Element.initOperations(_Parameter__Element);
			Fragments._Parameter__NamedElement.initOperations(_Parameter__NamedElement);
			Fragments._Parameter__OclAny.initOperations(_Parameter__OclAny);
			Fragments._Parameter__OclElement.initOperations(_Parameter__OclElement);
			Fragments._Parameter__Parameter.initOperations(_Parameter__Parameter);
			Fragments._Parameter__TypedElement.initOperations(_Parameter__TypedElement);
			Fragments._Parameter__Variable.initOperations(_Parameter__Variable);
			Fragments._Parameter__Visitable.initOperations(_Parameter__Visitable);

			Fragments._PrimitiveLiteralExp__Element.initOperations(_PrimitiveLiteralExp__Element);
			Fragments._PrimitiveLiteralExp__LiteralExp.initOperations(_PrimitiveLiteralExp__LiteralExp);
			Fragments._PrimitiveLiteralExp__OCLExpression.initOperations(_PrimitiveLiteralExp__OCLExpression);
			Fragments._PrimitiveLiteralExp__OclAny.initOperations(_PrimitiveLiteralExp__OclAny);
			Fragments._PrimitiveLiteralExp__OclElement.initOperations(_PrimitiveLiteralExp__OclElement);
			Fragments._PrimitiveLiteralExp__PrimitiveLiteralExp.initOperations(_PrimitiveLiteralExp__PrimitiveLiteralExp);
			Fragments._PrimitiveLiteralExp__TypedElement.initOperations(_PrimitiveLiteralExp__TypedElement);
			Fragments._PrimitiveLiteralExp__Visitable.initOperations(_PrimitiveLiteralExp__Visitable);

			Fragments._Property__Element.initOperations(_Property__Element);
			Fragments._Property__Feature.initOperations(_Property__Feature);
			Fragments._Property__NamedElement.initOperations(_Property__NamedElement);
			Fragments._Property__OclAny.initOperations(_Property__OclAny);
			Fragments._Property__OclElement.initOperations(_Property__OclElement);
			Fragments._Property__Property.initOperations(_Property__Property);
			Fragments._Property__TypedElement.initOperations(_Property__TypedElement);
			Fragments._Property__Visitable.initOperations(_Property__Visitable);

			Fragments._PropertyCallExp__CallExp.initOperations(_PropertyCallExp__CallExp);
			Fragments._PropertyCallExp__Element.initOperations(_PropertyCallExp__Element);
			Fragments._PropertyCallExp__OCLExpression.initOperations(_PropertyCallExp__OCLExpression);
			Fragments._PropertyCallExp__OclAny.initOperations(_PropertyCallExp__OclAny);
			Fragments._PropertyCallExp__OclElement.initOperations(_PropertyCallExp__OclElement);
			Fragments._PropertyCallExp__PropertyCallExp.initOperations(_PropertyCallExp__PropertyCallExp);
			Fragments._PropertyCallExp__TypedElement.initOperations(_PropertyCallExp__TypedElement);
			Fragments._PropertyCallExp__Visitable.initOperations(_PropertyCallExp__Visitable);

			Fragments._Root__Element.initOperations(_Root__Element);
			Fragments._Root__OclAny.initOperations(_Root__OclAny);
			Fragments._Root__OclElement.initOperations(_Root__OclElement);
			Fragments._Root__Root.initOperations(_Root__Root);
			Fragments._Root__Visitable.initOperations(_Root__Visitable);

			Fragments._TypedElement__Element.initOperations(_TypedElement__Element);
			Fragments._TypedElement__OclAny.initOperations(_TypedElement__OclAny);
			Fragments._TypedElement__OclElement.initOperations(_TypedElement__OclElement);
			Fragments._TypedElement__TypedElement.initOperations(_TypedElement__TypedElement);
			Fragments._TypedElement__Visitable.initOperations(_TypedElement__Visitable);

			Fragments._Variable__Element.initOperations(_Variable__Element);
			Fragments._Variable__NamedElement.initOperations(_Variable__NamedElement);
			Fragments._Variable__OclAny.initOperations(_Variable__OclAny);
			Fragments._Variable__OclElement.initOperations(_Variable__OclElement);
			Fragments._Variable__TypedElement.initOperations(_Variable__TypedElement);
			Fragments._Variable__Variable.initOperations(_Variable__Variable);
			Fragments._Variable__Visitable.initOperations(_Variable__Visitable);

			Fragments._VariableExp__Element.initOperations(_VariableExp__Element);
			Fragments._VariableExp__OCLExpression.initOperations(_VariableExp__OCLExpression);
			Fragments._VariableExp__OclAny.initOperations(_VariableExp__OclAny);
			Fragments._VariableExp__OclElement.initOperations(_VariableExp__OclElement);
			Fragments._VariableExp__TypedElement.initOperations(_VariableExp__TypedElement);
			Fragments._VariableExp__VariableExp.initOperations(_VariableExp__VariableExp);
			Fragments._VariableExp__Visitable.initOperations(_VariableExp__Visitable);

			Fragments._Visitable__OclAny.initOperations(_Visitable__OclAny);
			Fragments._Visitable__OclElement.initOperations(_Visitable__OclElement);
			Fragments._Visitable__Visitable.initOperations(_Visitable__Visitable);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MiniOCLTables::FragmentOperations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local properties for the local fragment of each type.
	 */
	public static class FragmentProperties {
		static {
			Init.initStart();
			FragmentOperations.init();
		}

		private static final @NonNull ExecutorProperty @NonNull [] _BooleanLiteralExp = {
			MiniOCLTables.Properties._BooleanLiteralExp__booleanSymbol,
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._OCLExpression__CallExp__ownedSource,
			MiniOCLTables.Properties._OCLExpression__CollectionItem__ownedItem,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedFirst,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedLast,
			MiniOCLTables.Properties._OCLExpression__ExpressionInOCL__ownedBody,
			MiniOCLTables.Properties._OCLExpression__LetExp__ownedIn,
			MiniOCLTables.Properties._OCLExpression__LoopExp__ownedBody,
			MiniOCLTables.Properties._OCLExpression__OperationCallExp__ownedArguments,
			MiniOCLTables.Properties._OCLExpression__Variable__ownedInitExp
		};

		private static final @NonNull ExecutorProperty @NonNull [] _CallExp = {
			MiniOCLTables.Properties._CallExp__ownedSource,
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._OCLExpression__CallExp__ownedSource,
			MiniOCLTables.Properties._OCLExpression__CollectionItem__ownedItem,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedFirst,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedLast,
			MiniOCLTables.Properties._OCLExpression__ExpressionInOCL__ownedBody,
			MiniOCLTables.Properties._OCLExpression__LetExp__ownedIn,
			MiniOCLTables.Properties._OCLExpression__LoopExp__ownedBody,
			MiniOCLTables.Properties._OCLExpression__OperationCallExp__ownedArguments,
			MiniOCLTables.Properties._OCLExpression__Variable__ownedInitExp
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Class = {
			MiniOCLTables.Properties._NamedElement__name,
			MiniOCLTables.Properties._Class__ownedOperations,
			MiniOCLTables.Properties._Class__ownedProperties,
			MiniOCLTables.Properties._Class__superClasses,
			MiniOCLTables.Properties._Class__Class__superClasses,
			MiniOCLTables.Properties._Class__Constraint__constrainedElement,
			MiniOCLTables.Properties._Class__Package__ownedClasses,
			MiniOCLTables.Properties._Class__TypedElement__type
		};

		private static final @NonNull ExecutorProperty @NonNull [] _CollectionItem = {
			MiniOCLTables.Properties._CollectionItem__ownedItem,
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._CollectionLiteralPart__CollectionLiteralExp__ownedParts
		};

		private static final @NonNull ExecutorProperty @NonNull [] _CollectionKind = {};

		private static final @NonNull ExecutorProperty @NonNull [] _CollectionLiteralExp = {
			MiniOCLTables.Properties._CollectionLiteralExp__kind,
			MiniOCLTables.Properties._CollectionLiteralExp__ownedParts,
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._OCLExpression__CallExp__ownedSource,
			MiniOCLTables.Properties._OCLExpression__CollectionItem__ownedItem,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedFirst,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedLast,
			MiniOCLTables.Properties._OCLExpression__ExpressionInOCL__ownedBody,
			MiniOCLTables.Properties._OCLExpression__LetExp__ownedIn,
			MiniOCLTables.Properties._OCLExpression__LoopExp__ownedBody,
			MiniOCLTables.Properties._OCLExpression__OperationCallExp__ownedArguments,
			MiniOCLTables.Properties._OCLExpression__Variable__ownedInitExp
		};

		private static final @NonNull ExecutorProperty @NonNull [] _CollectionLiteralPart = {
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._CollectionLiteralPart__CollectionLiteralExp__ownedParts
		};

		private static final @NonNull ExecutorProperty @NonNull [] _CollectionRange = {
			MiniOCLTables.Properties._CollectionRange__ownedFirst,
			MiniOCLTables.Properties._CollectionRange__ownedLast,
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._CollectionLiteralPart__CollectionLiteralExp__ownedParts
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Constraint = {
			MiniOCLTables.Properties._Constraint__constrainedElement,
			MiniOCLTables.Properties._NamedElement__name,
			MiniOCLTables.Properties._Constraint__ownedSpecification,
			MiniOCLTables.Properties._Constraint__Root__ownedConstraints
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Element = {};

		private static final @NonNull ExecutorProperty @NonNull [] _ExpressionInOCL = {
			MiniOCLTables.Properties._OpaqueExpression__language,
			MiniOCLTables.Properties._ExpressionInOCL__ownedBody,
			MiniOCLTables.Properties._ExpressionInOCL__ownedSelfVar,
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._ExpressionInOCL__Constraint__ownedSpecification,
			MiniOCLTables.Properties._ExpressionInOCL__Operation__ownedBodyExpression
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Feature = {
			MiniOCLTables.Properties._NamedElement__name,
			MiniOCLTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Import = {
			MiniOCLTables.Properties._Import__alias,
			MiniOCLTables.Properties._Import__uri,
			MiniOCLTables.Properties._Import__Root__ownedImports
		};

		private static final @NonNull ExecutorProperty @NonNull [] _IntegerLiteralExp = {
			MiniOCLTables.Properties._IntegerLiteralExp__integerSymbol,
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._OCLExpression__CallExp__ownedSource,
			MiniOCLTables.Properties._OCLExpression__CollectionItem__ownedItem,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedFirst,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedLast,
			MiniOCLTables.Properties._OCLExpression__ExpressionInOCL__ownedBody,
			MiniOCLTables.Properties._OCLExpression__LetExp__ownedIn,
			MiniOCLTables.Properties._OCLExpression__LoopExp__ownedBody,
			MiniOCLTables.Properties._OCLExpression__OperationCallExp__ownedArguments,
			MiniOCLTables.Properties._OCLExpression__Variable__ownedInitExp
		};

		private static final @NonNull ExecutorProperty @NonNull [] _IterateExp = {
			MiniOCLTables.Properties._LoopExp__ownedBody,
			MiniOCLTables.Properties._LoopExp__ownedIterator,
			MiniOCLTables.Properties._IterateExp__ownedResult,
			MiniOCLTables.Properties._CallExp__ownedSource,
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._OCLExpression__CallExp__ownedSource,
			MiniOCLTables.Properties._OCLExpression__CollectionItem__ownedItem,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedFirst,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedLast,
			MiniOCLTables.Properties._OCLExpression__ExpressionInOCL__ownedBody,
			MiniOCLTables.Properties._OCLExpression__LetExp__ownedIn,
			MiniOCLTables.Properties._OCLExpression__LoopExp__ownedBody,
			MiniOCLTables.Properties._OCLExpression__OperationCallExp__ownedArguments,
			MiniOCLTables.Properties._OCLExpression__Variable__ownedInitExp
		};

		private static final @NonNull ExecutorProperty @NonNull [] _IteratorExp = {
			MiniOCLTables.Properties._IteratorExp__iterator,
			MiniOCLTables.Properties._LoopExp__ownedBody,
			MiniOCLTables.Properties._LoopExp__ownedIterator,
			MiniOCLTables.Properties._CallExp__ownedSource,
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._OCLExpression__CallExp__ownedSource,
			MiniOCLTables.Properties._OCLExpression__CollectionItem__ownedItem,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedFirst,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedLast,
			MiniOCLTables.Properties._OCLExpression__ExpressionInOCL__ownedBody,
			MiniOCLTables.Properties._OCLExpression__LetExp__ownedIn,
			MiniOCLTables.Properties._OCLExpression__LoopExp__ownedBody,
			MiniOCLTables.Properties._OCLExpression__OperationCallExp__ownedArguments,
			MiniOCLTables.Properties._OCLExpression__Variable__ownedInitExp
		};

		private static final @NonNull ExecutorProperty @NonNull [] _LetExp = {
			MiniOCLTables.Properties._LetExp__ownedIn,
			MiniOCLTables.Properties._LetExp__ownedVariable,
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._OCLExpression__CallExp__ownedSource,
			MiniOCLTables.Properties._OCLExpression__CollectionItem__ownedItem,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedFirst,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedLast,
			MiniOCLTables.Properties._OCLExpression__ExpressionInOCL__ownedBody,
			MiniOCLTables.Properties._OCLExpression__LetExp__ownedIn,
			MiniOCLTables.Properties._OCLExpression__LoopExp__ownedBody,
			MiniOCLTables.Properties._OCLExpression__OperationCallExp__ownedArguments,
			MiniOCLTables.Properties._OCLExpression__Variable__ownedInitExp
		};

		private static final @NonNull ExecutorProperty @NonNull [] _LiteralExp = {
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._OCLExpression__CallExp__ownedSource,
			MiniOCLTables.Properties._OCLExpression__CollectionItem__ownedItem,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedFirst,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedLast,
			MiniOCLTables.Properties._OCLExpression__ExpressionInOCL__ownedBody,
			MiniOCLTables.Properties._OCLExpression__LetExp__ownedIn,
			MiniOCLTables.Properties._OCLExpression__LoopExp__ownedBody,
			MiniOCLTables.Properties._OCLExpression__OperationCallExp__ownedArguments,
			MiniOCLTables.Properties._OCLExpression__Variable__ownedInitExp
		};

		private static final @NonNull ExecutorProperty @NonNull [] _LoopExp = {
			MiniOCLTables.Properties._LoopExp__ownedBody,
			MiniOCLTables.Properties._LoopExp__ownedIterator,
			MiniOCLTables.Properties._CallExp__ownedSource,
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._OCLExpression__CallExp__ownedSource,
			MiniOCLTables.Properties._OCLExpression__CollectionItem__ownedItem,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedFirst,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedLast,
			MiniOCLTables.Properties._OCLExpression__ExpressionInOCL__ownedBody,
			MiniOCLTables.Properties._OCLExpression__LetExp__ownedIn,
			MiniOCLTables.Properties._OCLExpression__LoopExp__ownedBody,
			MiniOCLTables.Properties._OCLExpression__OperationCallExp__ownedArguments,
			MiniOCLTables.Properties._OCLExpression__Variable__ownedInitExp
		};

		private static final @NonNull ExecutorProperty @NonNull [] _NamedElement = {
			MiniOCLTables.Properties._NamedElement__name
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Namespace = {
			MiniOCLTables.Properties._NamedElement__name
		};

		private static final @NonNull ExecutorProperty @NonNull [] _NullLiteralExp = {
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._OCLExpression__CallExp__ownedSource,
			MiniOCLTables.Properties._OCLExpression__CollectionItem__ownedItem,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedFirst,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedLast,
			MiniOCLTables.Properties._OCLExpression__ExpressionInOCL__ownedBody,
			MiniOCLTables.Properties._OCLExpression__LetExp__ownedIn,
			MiniOCLTables.Properties._OCLExpression__LoopExp__ownedBody,
			MiniOCLTables.Properties._OCLExpression__OperationCallExp__ownedArguments,
			MiniOCLTables.Properties._OCLExpression__Variable__ownedInitExp
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OCLExpression = {
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._OCLExpression__CallExp__ownedSource,
			MiniOCLTables.Properties._OCLExpression__CollectionItem__ownedItem,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedFirst,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedLast,
			MiniOCLTables.Properties._OCLExpression__ExpressionInOCL__ownedBody,
			MiniOCLTables.Properties._OCLExpression__LetExp__ownedIn,
			MiniOCLTables.Properties._OCLExpression__LoopExp__ownedBody,
			MiniOCLTables.Properties._OCLExpression__OperationCallExp__ownedArguments,
			MiniOCLTables.Properties._OCLExpression__Variable__ownedInitExp
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OpaqueExpression = {
			MiniOCLTables.Properties._OpaqueExpression__language,
			MiniOCLTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Operation = {
			MiniOCLTables.Properties._NamedElement__name,
			MiniOCLTables.Properties._Operation__ownedBodyExpression,
			MiniOCLTables.Properties._Operation__ownedParameters,
			MiniOCLTables.Properties._Operation__owningClass,
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._Operation__OperationCallExp__referredOperation
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OperationCallExp = {
			MiniOCLTables.Properties._OperationCallExp__ownedArguments,
			MiniOCLTables.Properties._CallExp__ownedSource,
			MiniOCLTables.Properties._OperationCallExp__referredOperation,
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._OCLExpression__CallExp__ownedSource,
			MiniOCLTables.Properties._OCLExpression__CollectionItem__ownedItem,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedFirst,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedLast,
			MiniOCLTables.Properties._OCLExpression__ExpressionInOCL__ownedBody,
			MiniOCLTables.Properties._OCLExpression__LetExp__ownedIn,
			MiniOCLTables.Properties._OCLExpression__LoopExp__ownedBody,
			MiniOCLTables.Properties._OCLExpression__OperationCallExp__ownedArguments,
			MiniOCLTables.Properties._OCLExpression__Variable__ownedInitExp
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Package = {
			MiniOCLTables.Properties._NamedElement__name,
			MiniOCLTables.Properties._Package__ownedClasses,
			MiniOCLTables.Properties._Package__ownedPackages,
			MiniOCLTables.Properties._Package__Package__ownedPackages,
			MiniOCLTables.Properties._Package__Root__ownedPackages
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Parameter = {
			MiniOCLTables.Properties._NamedElement__name,
			MiniOCLTables.Properties._Variable__ownedInitExp,
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._Variable__ExpressionInOCL__ownedSelfVar,
			MiniOCLTables.Properties._Variable__IterateExp__ownedResult,
			MiniOCLTables.Properties._Variable__LetExp__ownedVariable,
			MiniOCLTables.Properties._Variable__LoopExp__ownedIterator,
			MiniOCLTables.Properties._Parameter__Operation__ownedParameters,
			MiniOCLTables.Properties._Variable__VariableExp__referredVariable
		};

		private static final @NonNull ExecutorProperty @NonNull [] _PrimitiveLiteralExp = {
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._OCLExpression__CallExp__ownedSource,
			MiniOCLTables.Properties._OCLExpression__CollectionItem__ownedItem,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedFirst,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedLast,
			MiniOCLTables.Properties._OCLExpression__ExpressionInOCL__ownedBody,
			MiniOCLTables.Properties._OCLExpression__LetExp__ownedIn,
			MiniOCLTables.Properties._OCLExpression__LoopExp__ownedBody,
			MiniOCLTables.Properties._OCLExpression__OperationCallExp__ownedArguments,
			MiniOCLTables.Properties._OCLExpression__Variable__ownedInitExp
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Property = {
			MiniOCLTables.Properties._Property__lowerBound,
			MiniOCLTables.Properties._NamedElement__name,
			MiniOCLTables.Properties._Property__owningClass,
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._Property__upperBound,
			MiniOCLTables.Properties._Property__PropertyCallExp__referredProperty
		};

		private static final @NonNull ExecutorProperty @NonNull [] _PropertyCallExp = {
			MiniOCLTables.Properties._CallExp__ownedSource,
			MiniOCLTables.Properties._PropertyCallExp__referredProperty,
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._OCLExpression__CallExp__ownedSource,
			MiniOCLTables.Properties._OCLExpression__CollectionItem__ownedItem,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedFirst,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedLast,
			MiniOCLTables.Properties._OCLExpression__ExpressionInOCL__ownedBody,
			MiniOCLTables.Properties._OCLExpression__LetExp__ownedIn,
			MiniOCLTables.Properties._OCLExpression__LoopExp__ownedBody,
			MiniOCLTables.Properties._OCLExpression__OperationCallExp__ownedArguments,
			MiniOCLTables.Properties._OCLExpression__Variable__ownedInitExp
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Root = {
			MiniOCLTables.Properties._Root__ownedConstraints,
			MiniOCLTables.Properties._Root__ownedImports,
			MiniOCLTables.Properties._Root__ownedPackages
		};

		private static final @NonNull ExecutorProperty @NonNull [] _TypedElement = {
			MiniOCLTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Variable = {
			MiniOCLTables.Properties._NamedElement__name,
			MiniOCLTables.Properties._Variable__ownedInitExp,
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._Variable__ExpressionInOCL__ownedSelfVar,
			MiniOCLTables.Properties._Variable__IterateExp__ownedResult,
			MiniOCLTables.Properties._Variable__LetExp__ownedVariable,
			MiniOCLTables.Properties._Variable__LoopExp__ownedIterator,
			MiniOCLTables.Properties._Variable__VariableExp__referredVariable
		};

		private static final @NonNull ExecutorProperty @NonNull [] _VariableExp = {
			MiniOCLTables.Properties._VariableExp__referredVariable,
			MiniOCLTables.Properties._TypedElement__type,
			MiniOCLTables.Properties._OCLExpression__CallExp__ownedSource,
			MiniOCLTables.Properties._OCLExpression__CollectionItem__ownedItem,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedFirst,
			MiniOCLTables.Properties._OCLExpression__CollectionRange__ownedLast,
			MiniOCLTables.Properties._OCLExpression__ExpressionInOCL__ownedBody,
			MiniOCLTables.Properties._OCLExpression__LetExp__ownedIn,
			MiniOCLTables.Properties._OCLExpression__LoopExp__ownedBody,
			MiniOCLTables.Properties._OCLExpression__OperationCallExp__ownedArguments,
			MiniOCLTables.Properties._OCLExpression__Variable__ownedInitExp
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Visitable = {};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._BooleanLiteralExp__BooleanLiteralExp.initProperties(_BooleanLiteralExp);
			Fragments._CallExp__CallExp.initProperties(_CallExp);
			Fragments._Class__Class.initProperties(_Class);
			Fragments._CollectionItem__CollectionItem.initProperties(_CollectionItem);
			Fragments._CollectionKind__CollectionKind.initProperties(_CollectionKind);
			Fragments._CollectionLiteralExp__CollectionLiteralExp.initProperties(_CollectionLiteralExp);
			Fragments._CollectionLiteralPart__CollectionLiteralPart.initProperties(_CollectionLiteralPart);
			Fragments._CollectionRange__CollectionRange.initProperties(_CollectionRange);
			Fragments._Constraint__Constraint.initProperties(_Constraint);
			Fragments._Element__Element.initProperties(_Element);
			Fragments._ExpressionInOCL__ExpressionInOCL.initProperties(_ExpressionInOCL);
			Fragments._Feature__Feature.initProperties(_Feature);
			Fragments._Import__Import.initProperties(_Import);
			Fragments._IntegerLiteralExp__IntegerLiteralExp.initProperties(_IntegerLiteralExp);
			Fragments._IterateExp__IterateExp.initProperties(_IterateExp);
			Fragments._IteratorExp__IteratorExp.initProperties(_IteratorExp);
			Fragments._LetExp__LetExp.initProperties(_LetExp);
			Fragments._LiteralExp__LiteralExp.initProperties(_LiteralExp);
			Fragments._LoopExp__LoopExp.initProperties(_LoopExp);
			Fragments._NamedElement__NamedElement.initProperties(_NamedElement);
			Fragments._Namespace__Namespace.initProperties(_Namespace);
			Fragments._NullLiteralExp__NullLiteralExp.initProperties(_NullLiteralExp);
			Fragments._OCLExpression__OCLExpression.initProperties(_OCLExpression);
			Fragments._OpaqueExpression__OpaqueExpression.initProperties(_OpaqueExpression);
			Fragments._Operation__Operation.initProperties(_Operation);
			Fragments._OperationCallExp__OperationCallExp.initProperties(_OperationCallExp);
			Fragments._Package__Package.initProperties(_Package);
			Fragments._Parameter__Parameter.initProperties(_Parameter);
			Fragments._PrimitiveLiteralExp__PrimitiveLiteralExp.initProperties(_PrimitiveLiteralExp);
			Fragments._Property__Property.initProperties(_Property);
			Fragments._PropertyCallExp__PropertyCallExp.initProperties(_PropertyCallExp);
			Fragments._Root__Root.initProperties(_Root);
			Fragments._TypedElement__TypedElement.initProperties(_TypedElement);
			Fragments._Variable__Variable.initProperties(_Variable);
			Fragments._VariableExp__VariableExp.initProperties(_VariableExp);
			Fragments._Visitable__Visitable.initProperties(_Visitable);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MiniOCLTables::FragmentProperties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of enumeration literals for each enumeration.
	 */
	public static class EnumerationLiterals {
		static {
			Init.initStart();
			FragmentProperties.init();
		}

		public static final @NonNull EcoreExecutorEnumerationLiteral _CollectionKind__Collection = new EcoreExecutorEnumerationLiteral(MiniOCLPackage.Literals.COLLECTION_KIND.getEEnumLiteral("Collection"), Types._CollectionKind, 0);
		private static final @NonNull EcoreExecutorEnumerationLiteral @NonNull [] _CollectionKind = {
			_CollectionKind__Collection
		};

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {
			Types._CollectionKind.initLiterals(_CollectionKind);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MiniOCLTables::EnumerationLiterals and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 * The multiple packages above avoid problems with the Java 65536 byte limit but introduce a difficulty in ensuring that
	 * static construction occurs in the disciplined order of the packages when construction may start in any of the packages.
	 * The problem is resolved by ensuring that the static construction of each package first initializes its immediate predecessor.
	 * On completion of predecessor initialization, the residual packages are initialized by starting an initialization in the last package.
	 * This class maintains a count so that the various predecessors can distinguish whether they are the starting point and so
	 * ensure that residual construction occurs just once after all predecessors.
	 */
	private static class Init {
		/**
		 * Counter of nested static constructions. On return to zero residual construction starts. -ve once residual construction started.
		 */
		private static int initCount = 0;

		/**
		 * Invoked at the start of a static construction to defer residual cobstruction until primary constructions complete.
		 */
		private static void initStart() {
			if (initCount >= 0) {
				initCount++;
			}
		}

		/**
		 * Invoked at the end of a static construction to activate residual cobstruction once primary constructions complete.
		 */
		private static void initEnd() {
			if (initCount > 0) {
				if (--initCount == 0) {
					initCount = -1;
					EnumerationLiterals.init();
				}
			}
		}
	}

	static {
		Init.initEnd();
	}

	/*
	 * Force initialization of outer fields. Inner fields are lazily initialized.
	 */
	public static void init() {}
}
