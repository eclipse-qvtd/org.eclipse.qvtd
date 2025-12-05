/*******************************************************************************
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 *   /org.eclipse.qvtd.doc.miniocl/model/MiniOCL.ecore
 * using:
 *   /org.eclipse.qvtd.doc.miniocl/model/MiniOCL.genmodel
 *   org.eclipse.ocl.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.qvtd.doc.miniocl;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.flat.FlatClass;
import org.eclipse.ocl.pivot.flat.FlatFragment;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.EnumerationId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.PartialStandardLibraryImpl;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.AbstractTables;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
// import org.eclipse.qvtd.doc.miniocl.MiniOCLPackage;
// import org.eclipse.qvtd.doc.miniocl.MiniOCLTables;

/**
 * MiniOCLTables provides the dispatch tables for the miniocl for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
public class MiniOCLTables extends AbstractTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The overall library of all packages and types.
	 */
	public static final PartialStandardLibraryImpl.@NonNull ReadOnly LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	The AS package for the MiniOCLPackage.eINSTANCE EPackage.
	 */
	public static final org.eclipse.ocl.pivot.@NonNull Package PACKAGE = LIBRARY.createPackage(MiniOCLPackage.eINSTANCE);

	/**
	 *	The AS model for the AS package and its additional orphans.
	 */
	public static final AbstractTables.@NonNull BuiltInModel MODEL = LIBRARY.createModel(PACKAGE);

	/**
	 *	The EMF Resource containing the AS model, its AS package and its additional orphans.
	 */
	public static final @NonNull Resource RESOURCE = LIBRARY.createResource(MODEL);

	/**
	 *	Constants used by auto-generated code.
	 */
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", "ecore", EcorePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0 = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/doc/MiniOCL/1.0", "mocl", MiniOCLPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CallExp = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("CallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CollectionItem = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("CollectionItem", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CollectionLiteralExp = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("CollectionLiteralExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CollectionLiteralPart = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("CollectionLiteralPart", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CollectionRange = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("CollectionRange", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Constraint = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Constraint", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ExpressionInOCL = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("ExpressionInOCL", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Import = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Import", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_IterateExp = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("IterateExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_LetExp = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("LetExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_LoopExp = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("LoopExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OCLExpression = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("OCLExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Operation = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OperationCallExp = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("OperationCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Package = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Package", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Parameter = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Parameter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Property = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Property", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_PropertyCallExp = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("PropertyCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Root = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Root", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TypedElement = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("TypedElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Variable = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Variable", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_VariableExp = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("VariableExp", 0);
	public static final /*@NonInvalid*/ @NonNull DataTypeId DATAid_EInt = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EInt", 0);
	public static final /*@NonInvalid*/ @NonNull EnumerationId ENUMid_CollectionKind = MiniOCLTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getEnumerationId("CollectionKind");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_Class = TypeId.BAG.getSpecializedId(MiniOCLTables.CLSSid_Class, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_Constraint = TypeId.BAG.getSpecializedId(MiniOCLTables.CLSSid_Constraint, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_LoopExp = TypeId.BAG.getSpecializedId(MiniOCLTables.CLSSid_LoopExp, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_OperationCallExp = TypeId.BAG.getSpecializedId(MiniOCLTables.CLSSid_OperationCallExp, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_PropertyCallExp = TypeId.BAG.getSpecializedId(MiniOCLTables.CLSSid_PropertyCallExp, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_TypedElement = TypeId.BAG.getSpecializedId(MiniOCLTables.CLSSid_TypedElement, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_VariableExp = TypeId.BAG.getSpecializedId(MiniOCLTables.CLSSid_VariableExp, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Class = TypeId.ORDERED_SET.getSpecializedId(MiniOCLTables.CLSSid_Class, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_CollectionLiteralPart = TypeId.ORDERED_SET.getSpecializedId(MiniOCLTables.CLSSid_CollectionLiteralPart, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Constraint = TypeId.ORDERED_SET.getSpecializedId(MiniOCLTables.CLSSid_Constraint, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Import = TypeId.ORDERED_SET.getSpecializedId(MiniOCLTables.CLSSid_Import, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_OCLExpression = TypeId.ORDERED_SET.getSpecializedId(MiniOCLTables.CLSSid_OCLExpression, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Operation = TypeId.ORDERED_SET.getSpecializedId(MiniOCLTables.CLSSid_Operation, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Package = TypeId.ORDERED_SET.getSpecializedId(MiniOCLTables.CLSSid_Package, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Parameter = TypeId.ORDERED_SET.getSpecializedId(MiniOCLTables.CLSSid_Parameter, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Property = TypeId.ORDERED_SET.getSpecializedId(MiniOCLTables.CLSSid_Property, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);

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

		public static final org.eclipse.ocl.pivot.@NonNull Class _BooleanLiteralExp = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.BOOLEAN_LITERAL_EXP, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _CallExp = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.CALL_EXP, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Class = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.CLASS, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _CollectionItem = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.COLLECTION_ITEM, null, 0);
		public static final @NonNull Enumeration _CollectionKind = LIBRARY.createEnumeration(MiniOCLPackage.Literals.COLLECTION_KIND);
		public static final org.eclipse.ocl.pivot.@NonNull Class _CollectionLiteralExp = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.COLLECTION_LITERAL_EXP, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _CollectionLiteralPart = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.COLLECTION_LITERAL_PART, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _CollectionRange = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.COLLECTION_RANGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Constraint = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.CONSTRAINT, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Element = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.ELEMENT, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _ExpressionInOCL = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.EXPRESSION_IN_OCL, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Feature = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.FEATURE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Import = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.IMPORT, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _IntegerLiteralExp = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.INTEGER_LITERAL_EXP, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _IterateExp = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.ITERATE_EXP, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _IteratorExp = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.ITERATOR_EXP, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _LetExp = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.LET_EXP, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _LiteralExp = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.LITERAL_EXP, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _LoopExp = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.LOOP_EXP, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _NamedElement = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.NAMED_ELEMENT, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Namespace = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.NAMESPACE, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _NullLiteralExp = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.NULL_LITERAL_EXP, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _OCLExpression = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.OCL_EXPRESSION, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _OpaqueExpression = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.OPAQUE_EXPRESSION, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Operation = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.OPERATION, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _OperationCallExp = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.OPERATION_CALL_EXP, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Package = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Parameter = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.PARAMETER, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _PrimitiveLiteralExp = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.PRIMITIVE_LITERAL_EXP, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Property = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.PROPERTY, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _PropertyCallExp = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.PROPERTY_CALL_EXP, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Root = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.ROOT, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _TypedElement = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.TYPED_ELEMENT, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Variable = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.VARIABLE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _VariableExp = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.VARIABLE_EXP, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Visitable = LIBRARY.createClass(PivotPackage.Literals.CLASS, MiniOCLPackage.Literals.VISITABLE, null, 0 | FlatClass.ABSTRACT);

		private static final org.eclipse.ocl.pivot.@NonNull Class @NonNull [] types = {
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
			LIBRARY.initPackage(PACKAGE, types);
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

		private static final @NonNull FlatFragment _BooleanLiteralExp__BooleanLiteralExp = LIBRARY.createFragment(Types._BooleanLiteralExp, Types._BooleanLiteralExp);
		private static final @NonNull FlatFragment _BooleanLiteralExp__Element = LIBRARY.createFragment(Types._BooleanLiteralExp, Types._Element);
		private static final @NonNull FlatFragment _BooleanLiteralExp__LiteralExp = LIBRARY.createFragment(Types._BooleanLiteralExp, Types._LiteralExp);
		private static final @NonNull FlatFragment _BooleanLiteralExp__OCLExpression = LIBRARY.createFragment(Types._BooleanLiteralExp, Types._OCLExpression);
		private static final @NonNull FlatFragment _BooleanLiteralExp__OclAny = LIBRARY.createFragment(Types._BooleanLiteralExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _BooleanLiteralExp__OclElement = LIBRARY.createFragment(Types._BooleanLiteralExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _BooleanLiteralExp__PrimitiveLiteralExp = LIBRARY.createFragment(Types._BooleanLiteralExp, Types._PrimitiveLiteralExp);
		private static final @NonNull FlatFragment _BooleanLiteralExp__TypedElement = LIBRARY.createFragment(Types._BooleanLiteralExp, Types._TypedElement);
		private static final @NonNull FlatFragment _BooleanLiteralExp__Visitable = LIBRARY.createFragment(Types._BooleanLiteralExp, Types._Visitable);

		private static final @NonNull FlatFragment _CallExp__CallExp = LIBRARY.createFragment(Types._CallExp, Types._CallExp);
		private static final @NonNull FlatFragment _CallExp__Element = LIBRARY.createFragment(Types._CallExp, Types._Element);
		private static final @NonNull FlatFragment _CallExp__OCLExpression = LIBRARY.createFragment(Types._CallExp, Types._OCLExpression);
		private static final @NonNull FlatFragment _CallExp__OclAny = LIBRARY.createFragment(Types._CallExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _CallExp__OclElement = LIBRARY.createFragment(Types._CallExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _CallExp__TypedElement = LIBRARY.createFragment(Types._CallExp, Types._TypedElement);
		private static final @NonNull FlatFragment _CallExp__Visitable = LIBRARY.createFragment(Types._CallExp, Types._Visitable);

		private static final @NonNull FlatFragment _Class__Class = LIBRARY.createFragment(Types._Class, Types._Class);
		private static final @NonNull FlatFragment _Class__Element = LIBRARY.createFragment(Types._Class, Types._Element);
		private static final @NonNull FlatFragment _Class__NamedElement = LIBRARY.createFragment(Types._Class, Types._NamedElement);
		private static final @NonNull FlatFragment _Class__Namespace = LIBRARY.createFragment(Types._Class, Types._Namespace);
		private static final @NonNull FlatFragment _Class__OclAny = LIBRARY.createFragment(Types._Class, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Class__OclElement = LIBRARY.createFragment(Types._Class, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Class__Visitable = LIBRARY.createFragment(Types._Class, Types._Visitable);

		private static final @NonNull FlatFragment _CollectionItem__CollectionItem = LIBRARY.createFragment(Types._CollectionItem, Types._CollectionItem);
		private static final @NonNull FlatFragment _CollectionItem__CollectionLiteralPart = LIBRARY.createFragment(Types._CollectionItem, Types._CollectionLiteralPart);
		private static final @NonNull FlatFragment _CollectionItem__Element = LIBRARY.createFragment(Types._CollectionItem, Types._Element);
		private static final @NonNull FlatFragment _CollectionItem__OclAny = LIBRARY.createFragment(Types._CollectionItem, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _CollectionItem__OclElement = LIBRARY.createFragment(Types._CollectionItem, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _CollectionItem__TypedElement = LIBRARY.createFragment(Types._CollectionItem, Types._TypedElement);
		private static final @NonNull FlatFragment _CollectionItem__Visitable = LIBRARY.createFragment(Types._CollectionItem, Types._Visitable);

		private static final @NonNull FlatFragment _CollectionKind__CollectionKind = LIBRARY.createFragment(Types._CollectionKind, Types._CollectionKind);
		private static final @NonNull FlatFragment _CollectionKind__OclAny = LIBRARY.createFragment(Types._CollectionKind, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _CollectionKind__OclElement = LIBRARY.createFragment(Types._CollectionKind, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _CollectionKind__OclEnumeration = LIBRARY.createFragment(Types._CollectionKind, OCLstdlibTables.Types._OclEnumeration);
		private static final @NonNull FlatFragment _CollectionKind__OclType = LIBRARY.createFragment(Types._CollectionKind, OCLstdlibTables.Types._OclType);

		private static final @NonNull FlatFragment _CollectionLiteralExp__CollectionLiteralExp = LIBRARY.createFragment(Types._CollectionLiteralExp, Types._CollectionLiteralExp);
		private static final @NonNull FlatFragment _CollectionLiteralExp__Element = LIBRARY.createFragment(Types._CollectionLiteralExp, Types._Element);
		private static final @NonNull FlatFragment _CollectionLiteralExp__LiteralExp = LIBRARY.createFragment(Types._CollectionLiteralExp, Types._LiteralExp);
		private static final @NonNull FlatFragment _CollectionLiteralExp__OCLExpression = LIBRARY.createFragment(Types._CollectionLiteralExp, Types._OCLExpression);
		private static final @NonNull FlatFragment _CollectionLiteralExp__OclAny = LIBRARY.createFragment(Types._CollectionLiteralExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _CollectionLiteralExp__OclElement = LIBRARY.createFragment(Types._CollectionLiteralExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _CollectionLiteralExp__TypedElement = LIBRARY.createFragment(Types._CollectionLiteralExp, Types._TypedElement);
		private static final @NonNull FlatFragment _CollectionLiteralExp__Visitable = LIBRARY.createFragment(Types._CollectionLiteralExp, Types._Visitable);

		private static final @NonNull FlatFragment _CollectionLiteralPart__CollectionLiteralPart = LIBRARY.createFragment(Types._CollectionLiteralPart, Types._CollectionLiteralPart);
		private static final @NonNull FlatFragment _CollectionLiteralPart__Element = LIBRARY.createFragment(Types._CollectionLiteralPart, Types._Element);
		private static final @NonNull FlatFragment _CollectionLiteralPart__OclAny = LIBRARY.createFragment(Types._CollectionLiteralPart, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _CollectionLiteralPart__OclElement = LIBRARY.createFragment(Types._CollectionLiteralPart, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _CollectionLiteralPart__TypedElement = LIBRARY.createFragment(Types._CollectionLiteralPart, Types._TypedElement);
		private static final @NonNull FlatFragment _CollectionLiteralPart__Visitable = LIBRARY.createFragment(Types._CollectionLiteralPart, Types._Visitable);

		private static final @NonNull FlatFragment _CollectionRange__CollectionLiteralPart = LIBRARY.createFragment(Types._CollectionRange, Types._CollectionLiteralPart);
		private static final @NonNull FlatFragment _CollectionRange__CollectionRange = LIBRARY.createFragment(Types._CollectionRange, Types._CollectionRange);
		private static final @NonNull FlatFragment _CollectionRange__Element = LIBRARY.createFragment(Types._CollectionRange, Types._Element);
		private static final @NonNull FlatFragment _CollectionRange__OclAny = LIBRARY.createFragment(Types._CollectionRange, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _CollectionRange__OclElement = LIBRARY.createFragment(Types._CollectionRange, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _CollectionRange__TypedElement = LIBRARY.createFragment(Types._CollectionRange, Types._TypedElement);
		private static final @NonNull FlatFragment _CollectionRange__Visitable = LIBRARY.createFragment(Types._CollectionRange, Types._Visitable);

		private static final @NonNull FlatFragment _Constraint__Constraint = LIBRARY.createFragment(Types._Constraint, Types._Constraint);
		private static final @NonNull FlatFragment _Constraint__Element = LIBRARY.createFragment(Types._Constraint, Types._Element);
		private static final @NonNull FlatFragment _Constraint__NamedElement = LIBRARY.createFragment(Types._Constraint, Types._NamedElement);
		private static final @NonNull FlatFragment _Constraint__OclAny = LIBRARY.createFragment(Types._Constraint, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Constraint__OclElement = LIBRARY.createFragment(Types._Constraint, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Constraint__Visitable = LIBRARY.createFragment(Types._Constraint, Types._Visitable);

		private static final @NonNull FlatFragment _Element__Element = LIBRARY.createFragment(Types._Element, Types._Element);
		private static final @NonNull FlatFragment _Element__OclAny = LIBRARY.createFragment(Types._Element, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Element__OclElement = LIBRARY.createFragment(Types._Element, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Element__Visitable = LIBRARY.createFragment(Types._Element, Types._Visitable);

		private static final @NonNull FlatFragment _ExpressionInOCL__Element = LIBRARY.createFragment(Types._ExpressionInOCL, Types._Element);
		private static final @NonNull FlatFragment _ExpressionInOCL__ExpressionInOCL = LIBRARY.createFragment(Types._ExpressionInOCL, Types._ExpressionInOCL);
		private static final @NonNull FlatFragment _ExpressionInOCL__OclAny = LIBRARY.createFragment(Types._ExpressionInOCL, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _ExpressionInOCL__OclElement = LIBRARY.createFragment(Types._ExpressionInOCL, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _ExpressionInOCL__OpaqueExpression = LIBRARY.createFragment(Types._ExpressionInOCL, Types._OpaqueExpression);
		private static final @NonNull FlatFragment _ExpressionInOCL__TypedElement = LIBRARY.createFragment(Types._ExpressionInOCL, Types._TypedElement);
		private static final @NonNull FlatFragment _ExpressionInOCL__Visitable = LIBRARY.createFragment(Types._ExpressionInOCL, Types._Visitable);

		private static final @NonNull FlatFragment _Feature__Element = LIBRARY.createFragment(Types._Feature, Types._Element);
		private static final @NonNull FlatFragment _Feature__Feature = LIBRARY.createFragment(Types._Feature, Types._Feature);
		private static final @NonNull FlatFragment _Feature__NamedElement = LIBRARY.createFragment(Types._Feature, Types._NamedElement);
		private static final @NonNull FlatFragment _Feature__OclAny = LIBRARY.createFragment(Types._Feature, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Feature__OclElement = LIBRARY.createFragment(Types._Feature, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Feature__TypedElement = LIBRARY.createFragment(Types._Feature, Types._TypedElement);
		private static final @NonNull FlatFragment _Feature__Visitable = LIBRARY.createFragment(Types._Feature, Types._Visitable);

		private static final @NonNull FlatFragment _Import__Element = LIBRARY.createFragment(Types._Import, Types._Element);
		private static final @NonNull FlatFragment _Import__Import = LIBRARY.createFragment(Types._Import, Types._Import);
		private static final @NonNull FlatFragment _Import__OclAny = LIBRARY.createFragment(Types._Import, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Import__OclElement = LIBRARY.createFragment(Types._Import, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Import__Visitable = LIBRARY.createFragment(Types._Import, Types._Visitable);

		private static final @NonNull FlatFragment _IntegerLiteralExp__Element = LIBRARY.createFragment(Types._IntegerLiteralExp, Types._Element);
		private static final @NonNull FlatFragment _IntegerLiteralExp__IntegerLiteralExp = LIBRARY.createFragment(Types._IntegerLiteralExp, Types._IntegerLiteralExp);
		private static final @NonNull FlatFragment _IntegerLiteralExp__LiteralExp = LIBRARY.createFragment(Types._IntegerLiteralExp, Types._LiteralExp);
		private static final @NonNull FlatFragment _IntegerLiteralExp__OCLExpression = LIBRARY.createFragment(Types._IntegerLiteralExp, Types._OCLExpression);
		private static final @NonNull FlatFragment _IntegerLiteralExp__OclAny = LIBRARY.createFragment(Types._IntegerLiteralExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _IntegerLiteralExp__OclElement = LIBRARY.createFragment(Types._IntegerLiteralExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _IntegerLiteralExp__PrimitiveLiteralExp = LIBRARY.createFragment(Types._IntegerLiteralExp, Types._PrimitiveLiteralExp);
		private static final @NonNull FlatFragment _IntegerLiteralExp__TypedElement = LIBRARY.createFragment(Types._IntegerLiteralExp, Types._TypedElement);
		private static final @NonNull FlatFragment _IntegerLiteralExp__Visitable = LIBRARY.createFragment(Types._IntegerLiteralExp, Types._Visitable);

		private static final @NonNull FlatFragment _IterateExp__CallExp = LIBRARY.createFragment(Types._IterateExp, Types._CallExp);
		private static final @NonNull FlatFragment _IterateExp__Element = LIBRARY.createFragment(Types._IterateExp, Types._Element);
		private static final @NonNull FlatFragment _IterateExp__IterateExp = LIBRARY.createFragment(Types._IterateExp, Types._IterateExp);
		private static final @NonNull FlatFragment _IterateExp__LoopExp = LIBRARY.createFragment(Types._IterateExp, Types._LoopExp);
		private static final @NonNull FlatFragment _IterateExp__OCLExpression = LIBRARY.createFragment(Types._IterateExp, Types._OCLExpression);
		private static final @NonNull FlatFragment _IterateExp__OclAny = LIBRARY.createFragment(Types._IterateExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _IterateExp__OclElement = LIBRARY.createFragment(Types._IterateExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _IterateExp__TypedElement = LIBRARY.createFragment(Types._IterateExp, Types._TypedElement);
		private static final @NonNull FlatFragment _IterateExp__Visitable = LIBRARY.createFragment(Types._IterateExp, Types._Visitable);

		private static final @NonNull FlatFragment _IteratorExp__CallExp = LIBRARY.createFragment(Types._IteratorExp, Types._CallExp);
		private static final @NonNull FlatFragment _IteratorExp__Element = LIBRARY.createFragment(Types._IteratorExp, Types._Element);
		private static final @NonNull FlatFragment _IteratorExp__IteratorExp = LIBRARY.createFragment(Types._IteratorExp, Types._IteratorExp);
		private static final @NonNull FlatFragment _IteratorExp__LoopExp = LIBRARY.createFragment(Types._IteratorExp, Types._LoopExp);
		private static final @NonNull FlatFragment _IteratorExp__OCLExpression = LIBRARY.createFragment(Types._IteratorExp, Types._OCLExpression);
		private static final @NonNull FlatFragment _IteratorExp__OclAny = LIBRARY.createFragment(Types._IteratorExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _IteratorExp__OclElement = LIBRARY.createFragment(Types._IteratorExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _IteratorExp__TypedElement = LIBRARY.createFragment(Types._IteratorExp, Types._TypedElement);
		private static final @NonNull FlatFragment _IteratorExp__Visitable = LIBRARY.createFragment(Types._IteratorExp, Types._Visitable);

		private static final @NonNull FlatFragment _LetExp__Element = LIBRARY.createFragment(Types._LetExp, Types._Element);
		private static final @NonNull FlatFragment _LetExp__LetExp = LIBRARY.createFragment(Types._LetExp, Types._LetExp);
		private static final @NonNull FlatFragment _LetExp__OCLExpression = LIBRARY.createFragment(Types._LetExp, Types._OCLExpression);
		private static final @NonNull FlatFragment _LetExp__OclAny = LIBRARY.createFragment(Types._LetExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _LetExp__OclElement = LIBRARY.createFragment(Types._LetExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _LetExp__TypedElement = LIBRARY.createFragment(Types._LetExp, Types._TypedElement);
		private static final @NonNull FlatFragment _LetExp__Visitable = LIBRARY.createFragment(Types._LetExp, Types._Visitable);

		private static final @NonNull FlatFragment _LiteralExp__Element = LIBRARY.createFragment(Types._LiteralExp, Types._Element);
		private static final @NonNull FlatFragment _LiteralExp__LiteralExp = LIBRARY.createFragment(Types._LiteralExp, Types._LiteralExp);
		private static final @NonNull FlatFragment _LiteralExp__OCLExpression = LIBRARY.createFragment(Types._LiteralExp, Types._OCLExpression);
		private static final @NonNull FlatFragment _LiteralExp__OclAny = LIBRARY.createFragment(Types._LiteralExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _LiteralExp__OclElement = LIBRARY.createFragment(Types._LiteralExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _LiteralExp__TypedElement = LIBRARY.createFragment(Types._LiteralExp, Types._TypedElement);
		private static final @NonNull FlatFragment _LiteralExp__Visitable = LIBRARY.createFragment(Types._LiteralExp, Types._Visitable);

		private static final @NonNull FlatFragment _LoopExp__CallExp = LIBRARY.createFragment(Types._LoopExp, Types._CallExp);
		private static final @NonNull FlatFragment _LoopExp__Element = LIBRARY.createFragment(Types._LoopExp, Types._Element);
		private static final @NonNull FlatFragment _LoopExp__LoopExp = LIBRARY.createFragment(Types._LoopExp, Types._LoopExp);
		private static final @NonNull FlatFragment _LoopExp__OCLExpression = LIBRARY.createFragment(Types._LoopExp, Types._OCLExpression);
		private static final @NonNull FlatFragment _LoopExp__OclAny = LIBRARY.createFragment(Types._LoopExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _LoopExp__OclElement = LIBRARY.createFragment(Types._LoopExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _LoopExp__TypedElement = LIBRARY.createFragment(Types._LoopExp, Types._TypedElement);
		private static final @NonNull FlatFragment _LoopExp__Visitable = LIBRARY.createFragment(Types._LoopExp, Types._Visitable);

		private static final @NonNull FlatFragment _NamedElement__Element = LIBRARY.createFragment(Types._NamedElement, Types._Element);
		private static final @NonNull FlatFragment _NamedElement__NamedElement = LIBRARY.createFragment(Types._NamedElement, Types._NamedElement);
		private static final @NonNull FlatFragment _NamedElement__OclAny = LIBRARY.createFragment(Types._NamedElement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _NamedElement__OclElement = LIBRARY.createFragment(Types._NamedElement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _NamedElement__Visitable = LIBRARY.createFragment(Types._NamedElement, Types._Visitable);

		private static final @NonNull FlatFragment _Namespace__Element = LIBRARY.createFragment(Types._Namespace, Types._Element);
		private static final @NonNull FlatFragment _Namespace__NamedElement = LIBRARY.createFragment(Types._Namespace, Types._NamedElement);
		private static final @NonNull FlatFragment _Namespace__Namespace = LIBRARY.createFragment(Types._Namespace, Types._Namespace);
		private static final @NonNull FlatFragment _Namespace__OclAny = LIBRARY.createFragment(Types._Namespace, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Namespace__OclElement = LIBRARY.createFragment(Types._Namespace, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Namespace__Visitable = LIBRARY.createFragment(Types._Namespace, Types._Visitable);

		private static final @NonNull FlatFragment _NullLiteralExp__Element = LIBRARY.createFragment(Types._NullLiteralExp, Types._Element);
		private static final @NonNull FlatFragment _NullLiteralExp__LiteralExp = LIBRARY.createFragment(Types._NullLiteralExp, Types._LiteralExp);
		private static final @NonNull FlatFragment _NullLiteralExp__NullLiteralExp = LIBRARY.createFragment(Types._NullLiteralExp, Types._NullLiteralExp);
		private static final @NonNull FlatFragment _NullLiteralExp__OCLExpression = LIBRARY.createFragment(Types._NullLiteralExp, Types._OCLExpression);
		private static final @NonNull FlatFragment _NullLiteralExp__OclAny = LIBRARY.createFragment(Types._NullLiteralExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _NullLiteralExp__OclElement = LIBRARY.createFragment(Types._NullLiteralExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _NullLiteralExp__TypedElement = LIBRARY.createFragment(Types._NullLiteralExp, Types._TypedElement);
		private static final @NonNull FlatFragment _NullLiteralExp__Visitable = LIBRARY.createFragment(Types._NullLiteralExp, Types._Visitable);

		private static final @NonNull FlatFragment _OCLExpression__Element = LIBRARY.createFragment(Types._OCLExpression, Types._Element);
		private static final @NonNull FlatFragment _OCLExpression__OCLExpression = LIBRARY.createFragment(Types._OCLExpression, Types._OCLExpression);
		private static final @NonNull FlatFragment _OCLExpression__OclAny = LIBRARY.createFragment(Types._OCLExpression, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _OCLExpression__OclElement = LIBRARY.createFragment(Types._OCLExpression, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _OCLExpression__TypedElement = LIBRARY.createFragment(Types._OCLExpression, Types._TypedElement);
		private static final @NonNull FlatFragment _OCLExpression__Visitable = LIBRARY.createFragment(Types._OCLExpression, Types._Visitable);

		private static final @NonNull FlatFragment _OpaqueExpression__Element = LIBRARY.createFragment(Types._OpaqueExpression, Types._Element);
		private static final @NonNull FlatFragment _OpaqueExpression__OclAny = LIBRARY.createFragment(Types._OpaqueExpression, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _OpaqueExpression__OclElement = LIBRARY.createFragment(Types._OpaqueExpression, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _OpaqueExpression__OpaqueExpression = LIBRARY.createFragment(Types._OpaqueExpression, Types._OpaqueExpression);
		private static final @NonNull FlatFragment _OpaqueExpression__TypedElement = LIBRARY.createFragment(Types._OpaqueExpression, Types._TypedElement);
		private static final @NonNull FlatFragment _OpaqueExpression__Visitable = LIBRARY.createFragment(Types._OpaqueExpression, Types._Visitable);

		private static final @NonNull FlatFragment _Operation__Element = LIBRARY.createFragment(Types._Operation, Types._Element);
		private static final @NonNull FlatFragment _Operation__Feature = LIBRARY.createFragment(Types._Operation, Types._Feature);
		private static final @NonNull FlatFragment _Operation__NamedElement = LIBRARY.createFragment(Types._Operation, Types._NamedElement);
		private static final @NonNull FlatFragment _Operation__OclAny = LIBRARY.createFragment(Types._Operation, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Operation__OclElement = LIBRARY.createFragment(Types._Operation, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Operation__Operation = LIBRARY.createFragment(Types._Operation, Types._Operation);
		private static final @NonNull FlatFragment _Operation__TypedElement = LIBRARY.createFragment(Types._Operation, Types._TypedElement);
		private static final @NonNull FlatFragment _Operation__Visitable = LIBRARY.createFragment(Types._Operation, Types._Visitable);

		private static final @NonNull FlatFragment _OperationCallExp__CallExp = LIBRARY.createFragment(Types._OperationCallExp, Types._CallExp);
		private static final @NonNull FlatFragment _OperationCallExp__Element = LIBRARY.createFragment(Types._OperationCallExp, Types._Element);
		private static final @NonNull FlatFragment _OperationCallExp__OCLExpression = LIBRARY.createFragment(Types._OperationCallExp, Types._OCLExpression);
		private static final @NonNull FlatFragment _OperationCallExp__OclAny = LIBRARY.createFragment(Types._OperationCallExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _OperationCallExp__OclElement = LIBRARY.createFragment(Types._OperationCallExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _OperationCallExp__OperationCallExp = LIBRARY.createFragment(Types._OperationCallExp, Types._OperationCallExp);
		private static final @NonNull FlatFragment _OperationCallExp__TypedElement = LIBRARY.createFragment(Types._OperationCallExp, Types._TypedElement);
		private static final @NonNull FlatFragment _OperationCallExp__Visitable = LIBRARY.createFragment(Types._OperationCallExp, Types._Visitable);

		private static final @NonNull FlatFragment _Package__Element = LIBRARY.createFragment(Types._Package, Types._Element);
		private static final @NonNull FlatFragment _Package__NamedElement = LIBRARY.createFragment(Types._Package, Types._NamedElement);
		private static final @NonNull FlatFragment _Package__Namespace = LIBRARY.createFragment(Types._Package, Types._Namespace);
		private static final @NonNull FlatFragment _Package__OclAny = LIBRARY.createFragment(Types._Package, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Package__OclElement = LIBRARY.createFragment(Types._Package, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Package__Package = LIBRARY.createFragment(Types._Package, Types._Package);
		private static final @NonNull FlatFragment _Package__Visitable = LIBRARY.createFragment(Types._Package, Types._Visitable);

		private static final @NonNull FlatFragment _Parameter__Element = LIBRARY.createFragment(Types._Parameter, Types._Element);
		private static final @NonNull FlatFragment _Parameter__NamedElement = LIBRARY.createFragment(Types._Parameter, Types._NamedElement);
		private static final @NonNull FlatFragment _Parameter__OclAny = LIBRARY.createFragment(Types._Parameter, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Parameter__OclElement = LIBRARY.createFragment(Types._Parameter, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Parameter__Parameter = LIBRARY.createFragment(Types._Parameter, Types._Parameter);
		private static final @NonNull FlatFragment _Parameter__TypedElement = LIBRARY.createFragment(Types._Parameter, Types._TypedElement);
		private static final @NonNull FlatFragment _Parameter__Variable = LIBRARY.createFragment(Types._Parameter, Types._Variable);
		private static final @NonNull FlatFragment _Parameter__Visitable = LIBRARY.createFragment(Types._Parameter, Types._Visitable);

		private static final @NonNull FlatFragment _PrimitiveLiteralExp__Element = LIBRARY.createFragment(Types._PrimitiveLiteralExp, Types._Element);
		private static final @NonNull FlatFragment _PrimitiveLiteralExp__LiteralExp = LIBRARY.createFragment(Types._PrimitiveLiteralExp, Types._LiteralExp);
		private static final @NonNull FlatFragment _PrimitiveLiteralExp__OCLExpression = LIBRARY.createFragment(Types._PrimitiveLiteralExp, Types._OCLExpression);
		private static final @NonNull FlatFragment _PrimitiveLiteralExp__OclAny = LIBRARY.createFragment(Types._PrimitiveLiteralExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _PrimitiveLiteralExp__OclElement = LIBRARY.createFragment(Types._PrimitiveLiteralExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _PrimitiveLiteralExp__PrimitiveLiteralExp = LIBRARY.createFragment(Types._PrimitiveLiteralExp, Types._PrimitiveLiteralExp);
		private static final @NonNull FlatFragment _PrimitiveLiteralExp__TypedElement = LIBRARY.createFragment(Types._PrimitiveLiteralExp, Types._TypedElement);
		private static final @NonNull FlatFragment _PrimitiveLiteralExp__Visitable = LIBRARY.createFragment(Types._PrimitiveLiteralExp, Types._Visitable);

		private static final @NonNull FlatFragment _Property__Element = LIBRARY.createFragment(Types._Property, Types._Element);
		private static final @NonNull FlatFragment _Property__Feature = LIBRARY.createFragment(Types._Property, Types._Feature);
		private static final @NonNull FlatFragment _Property__NamedElement = LIBRARY.createFragment(Types._Property, Types._NamedElement);
		private static final @NonNull FlatFragment _Property__OclAny = LIBRARY.createFragment(Types._Property, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Property__OclElement = LIBRARY.createFragment(Types._Property, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Property__Property = LIBRARY.createFragment(Types._Property, Types._Property);
		private static final @NonNull FlatFragment _Property__TypedElement = LIBRARY.createFragment(Types._Property, Types._TypedElement);
		private static final @NonNull FlatFragment _Property__Visitable = LIBRARY.createFragment(Types._Property, Types._Visitable);

		private static final @NonNull FlatFragment _PropertyCallExp__CallExp = LIBRARY.createFragment(Types._PropertyCallExp, Types._CallExp);
		private static final @NonNull FlatFragment _PropertyCallExp__Element = LIBRARY.createFragment(Types._PropertyCallExp, Types._Element);
		private static final @NonNull FlatFragment _PropertyCallExp__OCLExpression = LIBRARY.createFragment(Types._PropertyCallExp, Types._OCLExpression);
		private static final @NonNull FlatFragment _PropertyCallExp__OclAny = LIBRARY.createFragment(Types._PropertyCallExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _PropertyCallExp__OclElement = LIBRARY.createFragment(Types._PropertyCallExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _PropertyCallExp__PropertyCallExp = LIBRARY.createFragment(Types._PropertyCallExp, Types._PropertyCallExp);
		private static final @NonNull FlatFragment _PropertyCallExp__TypedElement = LIBRARY.createFragment(Types._PropertyCallExp, Types._TypedElement);
		private static final @NonNull FlatFragment _PropertyCallExp__Visitable = LIBRARY.createFragment(Types._PropertyCallExp, Types._Visitable);

		private static final @NonNull FlatFragment _Root__Element = LIBRARY.createFragment(Types._Root, Types._Element);
		private static final @NonNull FlatFragment _Root__OclAny = LIBRARY.createFragment(Types._Root, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Root__OclElement = LIBRARY.createFragment(Types._Root, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Root__Root = LIBRARY.createFragment(Types._Root, Types._Root);
		private static final @NonNull FlatFragment _Root__Visitable = LIBRARY.createFragment(Types._Root, Types._Visitable);

		private static final @NonNull FlatFragment _TypedElement__Element = LIBRARY.createFragment(Types._TypedElement, Types._Element);
		private static final @NonNull FlatFragment _TypedElement__OclAny = LIBRARY.createFragment(Types._TypedElement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _TypedElement__OclElement = LIBRARY.createFragment(Types._TypedElement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _TypedElement__TypedElement = LIBRARY.createFragment(Types._TypedElement, Types._TypedElement);
		private static final @NonNull FlatFragment _TypedElement__Visitable = LIBRARY.createFragment(Types._TypedElement, Types._Visitable);

		private static final @NonNull FlatFragment _Variable__Element = LIBRARY.createFragment(Types._Variable, Types._Element);
		private static final @NonNull FlatFragment _Variable__NamedElement = LIBRARY.createFragment(Types._Variable, Types._NamedElement);
		private static final @NonNull FlatFragment _Variable__OclAny = LIBRARY.createFragment(Types._Variable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Variable__OclElement = LIBRARY.createFragment(Types._Variable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Variable__TypedElement = LIBRARY.createFragment(Types._Variable, Types._TypedElement);
		private static final @NonNull FlatFragment _Variable__Variable = LIBRARY.createFragment(Types._Variable, Types._Variable);
		private static final @NonNull FlatFragment _Variable__Visitable = LIBRARY.createFragment(Types._Variable, Types._Visitable);

		private static final @NonNull FlatFragment _VariableExp__Element = LIBRARY.createFragment(Types._VariableExp, Types._Element);
		private static final @NonNull FlatFragment _VariableExp__OCLExpression = LIBRARY.createFragment(Types._VariableExp, Types._OCLExpression);
		private static final @NonNull FlatFragment _VariableExp__OclAny = LIBRARY.createFragment(Types._VariableExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _VariableExp__OclElement = LIBRARY.createFragment(Types._VariableExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _VariableExp__TypedElement = LIBRARY.createFragment(Types._VariableExp, Types._TypedElement);
		private static final @NonNull FlatFragment _VariableExp__VariableExp = LIBRARY.createFragment(Types._VariableExp, Types._VariableExp);
		private static final @NonNull FlatFragment _VariableExp__Visitable = LIBRARY.createFragment(Types._VariableExp, Types._Visitable);

		private static final @NonNull FlatFragment _Visitable__OclAny = LIBRARY.createFragment(Types._Visitable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Visitable__OclElement = LIBRARY.createFragment(Types._Visitable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Visitable__Visitable = LIBRARY.createFragment(Types._Visitable, Types._Visitable);

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

		public static final @NonNull Property _BooleanLiteralExp__booleanSymbol = LIBRARY.createProperty(Types._BooleanLiteralExp, MiniOCLPackage.Literals.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL, OCLstdlibTables.Types._Boolean, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _CallExp__ownedSource = LIBRARY.createProperty(Types._CallExp, MiniOCLPackage.Literals.CALL_EXP__OWNED_SOURCE, Types._OCLExpression, 0 | IsComposite | IsRequired | IsResolveProxies);

		public static final @NonNull Property _Class__ownedOperations = LIBRARY.createProperty(Types._Class, MiniOCLPackage.Literals.CLASS__OWNED_OPERATIONS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Operation, false), 0 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Class__ownedProperties = LIBRARY.createProperty(Types._Class, MiniOCLPackage.Literals.CLASS__OWNED_PROPERTIES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Property, false), 1 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Class__superClasses = LIBRARY.createProperty(Types._Class, MiniOCLPackage.Literals.CLASS__SUPER_CLASSES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Class, false), 2 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Class__Class__superClasses = LIBRARY.createOppositeProperty(Types._Class, "Class", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._Class, false), 3 | IsImplicit | IsRequired | IsResolveProxies, MiniOCLPackage.Literals.CLASS__SUPER_CLASSES);
		public static final @NonNull Property _Class__Constraint__constrainedElement = LIBRARY.createOppositeProperty(Types._Class, "Constraint", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._Constraint, false), 4 | IsImplicit | IsRequired | IsResolveProxies, MiniOCLPackage.Literals.CONSTRAINT__CONSTRAINED_ELEMENT);
		public static final @NonNull Property _Class__Package__ownedClasses = LIBRARY.createOppositeProperty(Types._Class, "Package", Types._Package, 5 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.PACKAGE__OWNED_CLASSES);
		public static final @NonNull Property _Class__TypedElement__type = LIBRARY.createOppositeProperty(Types._Class, "TypedElement", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._TypedElement, false), 6 | IsImplicit | IsRequired | IsResolveProxies, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE);

		public static final @NonNull Property _CollectionItem__ownedItem = LIBRARY.createProperty(Types._CollectionItem, MiniOCLPackage.Literals.COLLECTION_ITEM__OWNED_ITEM, Types._OCLExpression, 0 | IsComposite | IsRequired | IsResolveProxies);

		public static final @NonNull Property _CollectionLiteralExp__kind = LIBRARY.createProperty(Types._CollectionLiteralExp, MiniOCLPackage.Literals.COLLECTION_LITERAL_EXP__KIND, Types._CollectionKind, 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _CollectionLiteralExp__ownedParts = LIBRARY.createProperty(Types._CollectionLiteralExp, MiniOCLPackage.Literals.COLLECTION_LITERAL_EXP__OWNED_PARTS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._CollectionLiteralPart, false), 1 | IsComposite | IsRequired | IsResolveProxies);

		public static final @NonNull Property _CollectionLiteralPart__CollectionLiteralExp__ownedParts = LIBRARY.createOppositeProperty(Types._CollectionLiteralPart, "CollectionLiteralExp", Types._CollectionLiteralExp, 0 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.COLLECTION_LITERAL_EXP__OWNED_PARTS);

		public static final @NonNull Property _CollectionRange__ownedFirst = LIBRARY.createProperty(Types._CollectionRange, MiniOCLPackage.Literals.COLLECTION_RANGE__OWNED_FIRST, Types._OCLExpression, 0 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _CollectionRange__ownedLast = LIBRARY.createProperty(Types._CollectionRange, MiniOCLPackage.Literals.COLLECTION_RANGE__OWNED_LAST, Types._OCLExpression, 1 | IsComposite | IsRequired | IsResolveProxies);

		public static final @NonNull Property _Constraint__constrainedElement = LIBRARY.createProperty(Types._Constraint, MiniOCLPackage.Literals.CONSTRAINT__CONSTRAINED_ELEMENT, Types._Class, 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Constraint__ownedSpecification = LIBRARY.createProperty(Types._Constraint, MiniOCLPackage.Literals.CONSTRAINT__OWNED_SPECIFICATION, Types._ExpressionInOCL, 1 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Constraint__Root__ownedConstraints = LIBRARY.createOppositeProperty(Types._Constraint, "Root", Types._Root, 2 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.ROOT__OWNED_CONSTRAINTS);

		public static final @NonNull Property _ExpressionInOCL__ownedBody = LIBRARY.createProperty(Types._ExpressionInOCL, MiniOCLPackage.Literals.EXPRESSION_IN_OCL__OWNED_BODY, Types._OCLExpression, 0 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _ExpressionInOCL__ownedSelfVar = LIBRARY.createProperty(Types._ExpressionInOCL, MiniOCLPackage.Literals.EXPRESSION_IN_OCL__OWNED_SELF_VAR, Types._Variable, 1 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _ExpressionInOCL__Constraint__ownedSpecification = LIBRARY.createOppositeProperty(Types._ExpressionInOCL, "Constraint", Types._Constraint, 2 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.CONSTRAINT__OWNED_SPECIFICATION);
		public static final @NonNull Property _ExpressionInOCL__Operation__ownedBodyExpression = LIBRARY.createOppositeProperty(Types._ExpressionInOCL, "Operation", Types._Operation, 3 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.OPERATION__OWNED_BODY_EXPRESSION);

		public static final @NonNull Property _Import__alias = LIBRARY.createProperty(Types._Import, MiniOCLPackage.Literals.IMPORT__ALIAS, OCLstdlibTables.Types._String, 0 | IsResolveProxies);
		public static final @NonNull Property _Import__uri = LIBRARY.createProperty(Types._Import, MiniOCLPackage.Literals.IMPORT__URI, OCLstdlibTables.Types._String, 1 | IsResolveProxies);
		public static final @NonNull Property _Import__Root__ownedImports = LIBRARY.createOppositeProperty(Types._Import, "Root", Types._Root, 2 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.ROOT__OWNED_IMPORTS);

		public static final @NonNull Property _IntegerLiteralExp__integerSymbol = LIBRARY.createProperty(Types._IntegerLiteralExp, MiniOCLPackage.Literals.INTEGER_LITERAL_EXP__INTEGER_SYMBOL, OCLstdlibTables.Types._Integer, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _IterateExp__ownedResult = LIBRARY.createProperty(Types._IterateExp, MiniOCLPackage.Literals.ITERATE_EXP__OWNED_RESULT, Types._Variable, 0 | IsComposite | IsRequired | IsResolveProxies);

		public static final @NonNull Property _IteratorExp__iterator = LIBRARY.createProperty(Types._IteratorExp, MiniOCLPackage.Literals.ITERATOR_EXP__ITERATOR, OCLstdlibTables.Types._String, 0 | IsResolveProxies);

		public static final @NonNull Property _LetExp__ownedIn = LIBRARY.createProperty(Types._LetExp, MiniOCLPackage.Literals.LET_EXP__OWNED_IN, Types._OCLExpression, 0 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _LetExp__ownedVariable = LIBRARY.createProperty(Types._LetExp, MiniOCLPackage.Literals.LET_EXP__OWNED_VARIABLE, Types._Variable, 1 | IsComposite | IsRequired | IsResolveProxies);

		public static final @NonNull Property _LoopExp__ownedBody = LIBRARY.createProperty(Types._LoopExp, MiniOCLPackage.Literals.LOOP_EXP__OWNED_BODY, Types._OCLExpression, 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _LoopExp__ownedIterator = LIBRARY.createProperty(Types._LoopExp, MiniOCLPackage.Literals.LOOP_EXP__OWNED_ITERATOR, Types._Variable, 1 | IsComposite | IsRequired | IsResolveProxies);

		public static final @NonNull Property _NamedElement__name = LIBRARY.createProperty(Types._NamedElement, MiniOCLPackage.Literals.NAMED_ELEMENT__NAME, OCLstdlibTables.Types._String, 0 | IsResolveProxies);

		public static final @NonNull Property _OCLExpression__CallExp__ownedSource = LIBRARY.createOppositeProperty(Types._OCLExpression, "CallExp", Types._CallExp, 0 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.CALL_EXP__OWNED_SOURCE);
		public static final @NonNull Property _OCLExpression__CollectionItem__ownedItem = LIBRARY.createOppositeProperty(Types._OCLExpression, "CollectionItem", Types._CollectionItem, 1 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.COLLECTION_ITEM__OWNED_ITEM);
		public static final @NonNull Property _OCLExpression__CollectionRange__ownedFirst = LIBRARY.createOppositeProperty(Types._OCLExpression, "CollectionRange", Types._CollectionRange, 2 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.COLLECTION_RANGE__OWNED_FIRST);
		public static final @NonNull Property _OCLExpression__CollectionRange__ownedLast = LIBRARY.createOppositeProperty(Types._OCLExpression, "CollectionRange", Types._CollectionRange, 3 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.COLLECTION_RANGE__OWNED_LAST);
		public static final @NonNull Property _OCLExpression__ExpressionInOCL__ownedBody = LIBRARY.createOppositeProperty(Types._OCLExpression, "ExpressionInOCL", Types._ExpressionInOCL, 4 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.EXPRESSION_IN_OCL__OWNED_BODY);
		public static final @NonNull Property _OCLExpression__LetExp__ownedIn = LIBRARY.createOppositeProperty(Types._OCLExpression, "LetExp", Types._LetExp, 5 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.LET_EXP__OWNED_IN);
		public static final @NonNull Property _OCLExpression__LoopExp__ownedBody = LIBRARY.createOppositeProperty(Types._OCLExpression, "LoopExp", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._LoopExp, false), 6 | IsImplicit | IsRequired | IsResolveProxies, MiniOCLPackage.Literals.LOOP_EXP__OWNED_BODY);
		public static final @NonNull Property _OCLExpression__OperationCallExp__ownedArguments = LIBRARY.createOppositeProperty(Types._OCLExpression, "OperationCallExp", Types._OperationCallExp, 7 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.OPERATION_CALL_EXP__OWNED_ARGUMENTS);
		public static final @NonNull Property _OCLExpression__Variable__ownedInitExp = LIBRARY.createOppositeProperty(Types._OCLExpression, "Variable", Types._Variable, 8 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.VARIABLE__OWNED_INIT_EXP);

		public static final @NonNull Property _OpaqueExpression__language = LIBRARY.createProperty(Types._OpaqueExpression, MiniOCLPackage.Literals.OPAQUE_EXPRESSION__LANGUAGE, OCLstdlibTables.Types._String, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _Operation__ownedBodyExpression = LIBRARY.createProperty(Types._Operation, MiniOCLPackage.Literals.OPERATION__OWNED_BODY_EXPRESSION, Types._ExpressionInOCL, 0 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Operation__ownedParameters = LIBRARY.createProperty(Types._Operation, MiniOCLPackage.Literals.OPERATION__OWNED_PARAMETERS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Parameter, false), 1 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Operation__owningClass = LIBRARY.createProperty(Types._Operation, MiniOCLPackage.Literals.OPERATION__OWNING_CLASS, Types._Class, 2 | IsResolveProxies);
		public static final @NonNull Property _Operation__OperationCallExp__referredOperation = LIBRARY.createOppositeProperty(Types._Operation, "OperationCallExp", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._OperationCallExp, false), 3 | IsImplicit | IsRequired | IsResolveProxies, MiniOCLPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION);

		public static final @NonNull Property _OperationCallExp__ownedArguments = LIBRARY.createProperty(Types._OperationCallExp, MiniOCLPackage.Literals.OPERATION_CALL_EXP__OWNED_ARGUMENTS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._OCLExpression, false), 0 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _OperationCallExp__referredOperation = LIBRARY.createProperty(Types._OperationCallExp, MiniOCLPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION, Types._Operation, 1 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _Package__ownedClasses = LIBRARY.createProperty(Types._Package, MiniOCLPackage.Literals.PACKAGE__OWNED_CLASSES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Class, false), 0 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Package__ownedPackages = LIBRARY.createProperty(Types._Package, MiniOCLPackage.Literals.PACKAGE__OWNED_PACKAGES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Package, false), 1 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Package__Package__ownedPackages = LIBRARY.createOppositeProperty(Types._Package, "Package", Types._Package, 2 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.PACKAGE__OWNED_PACKAGES);
		public static final @NonNull Property _Package__Root__ownedPackages = LIBRARY.createOppositeProperty(Types._Package, "Root", Types._Root, 3 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.ROOT__OWNED_PACKAGES);

		public static final @NonNull Property _Parameter__Operation__ownedParameters = LIBRARY.createOppositeProperty(Types._Parameter, "Operation", Types._Operation, 0 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.OPERATION__OWNED_PARAMETERS);

		public static final @NonNull Property _Property__lowerBound = LIBRARY.createProperty(Types._Property, MiniOCLPackage.Literals.PROPERTY__LOWER_BOUND, OCLstdlibTables.Types._Integer, 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Property__owningClass = LIBRARY.createProperty(Types._Property, MiniOCLPackage.Literals.PROPERTY__OWNING_CLASS, Types._Class, 1 | IsResolveProxies);
		public static final @NonNull Property _Property__upperBound = LIBRARY.createProperty(Types._Property, MiniOCLPackage.Literals.PROPERTY__UPPER_BOUND, OCLstdlibTables.Types._Integer, 2 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Property__PropertyCallExp__referredProperty = LIBRARY.createOppositeProperty(Types._Property, "PropertyCallExp", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._PropertyCallExp, false), 3 | IsImplicit | IsRequired | IsResolveProxies, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY);

		public static final @NonNull Property _PropertyCallExp__referredProperty = LIBRARY.createProperty(Types._PropertyCallExp, MiniOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, Types._Property, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _Root__ownedConstraints = LIBRARY.createProperty(Types._Root, MiniOCLPackage.Literals.ROOT__OWNED_CONSTRAINTS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Constraint, false), 0 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Root__ownedImports = LIBRARY.createProperty(Types._Root, MiniOCLPackage.Literals.ROOT__OWNED_IMPORTS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Import, false), 1 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Root__ownedPackages = LIBRARY.createProperty(Types._Root, MiniOCLPackage.Literals.ROOT__OWNED_PACKAGES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Package, false), 2 | IsComposite | IsRequired | IsResolveProxies);

		public static final @NonNull Property _TypedElement__type = LIBRARY.createProperty(Types._TypedElement, MiniOCLPackage.Literals.TYPED_ELEMENT__TYPE, Types._Class, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _Variable__ownedInitExp = LIBRARY.createProperty(Types._Variable, MiniOCLPackage.Literals.VARIABLE__OWNED_INIT_EXP, Types._OCLExpression, 0 | IsComposite | IsResolveProxies);
		public static final @NonNull Property _Variable__ExpressionInOCL__ownedSelfVar = LIBRARY.createOppositeProperty(Types._Variable, "ExpressionInOCL", Types._ExpressionInOCL, 1 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.EXPRESSION_IN_OCL__OWNED_SELF_VAR);
		public static final @NonNull Property _Variable__IterateExp__ownedResult = LIBRARY.createOppositeProperty(Types._Variable, "IterateExp", Types._IterateExp, 2 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.ITERATE_EXP__OWNED_RESULT);
		public static final @NonNull Property _Variable__LetExp__ownedVariable = LIBRARY.createOppositeProperty(Types._Variable, "LetExp", Types._LetExp, 3 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.LET_EXP__OWNED_VARIABLE);
		public static final @NonNull Property _Variable__LoopExp__ownedIterator = LIBRARY.createOppositeProperty(Types._Variable, "LoopExp", Types._LoopExp, 4 | IsImplicit | IsResolveProxies, MiniOCLPackage.Literals.LOOP_EXP__OWNED_ITERATOR);
		public static final @NonNull Property _Variable__VariableExp__referredVariable = LIBRARY.createOppositeProperty(Types._Variable, "VariableExp", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._VariableExp, false), 5 | IsImplicit | IsRequired | IsResolveProxies, MiniOCLPackage.Literals.VARIABLE_EXP__REFERRED_VARIABLE);

		public static final @NonNull Property _VariableExp__referredVariable = LIBRARY.createProperty(Types._VariableExp, MiniOCLPackage.Literals.VARIABLE_EXP__REFERRED_VARIABLE, Types._Variable, 0 | IsRequired | IsResolveProxies);

		static {

			_CallExp__ownedSource.setOpposite(_OCLExpression__CallExp__ownedSource);

			_Class__ownedOperations.setOpposite(_Operation__owningClass);
			_Class__ownedProperties.setOpposite(_Property__owningClass);
			_Class__superClasses.setOpposite(_Class__Class__superClasses);
			_Class__Class__superClasses.setOpposite(_Class__superClasses);
			_Class__Constraint__constrainedElement.setOpposite(_Constraint__constrainedElement);
			_Class__Package__ownedClasses.setOpposite(_Package__ownedClasses);
			_Class__TypedElement__type.setOpposite(_TypedElement__type);

			_CollectionItem__ownedItem.setOpposite(_OCLExpression__CollectionItem__ownedItem);

			_CollectionLiteralExp__ownedParts.setOpposite(_CollectionLiteralPart__CollectionLiteralExp__ownedParts);

			_CollectionLiteralPart__CollectionLiteralExp__ownedParts.setOpposite(_CollectionLiteralExp__ownedParts);

			_CollectionRange__ownedFirst.setOpposite(_OCLExpression__CollectionRange__ownedFirst);
			_CollectionRange__ownedLast.setOpposite(_OCLExpression__CollectionRange__ownedLast);

			_Constraint__constrainedElement.setOpposite(_Class__Constraint__constrainedElement);
			_Constraint__ownedSpecification.setOpposite(_ExpressionInOCL__Constraint__ownedSpecification);
			_Constraint__Root__ownedConstraints.setOpposite(_Root__ownedConstraints);

			_ExpressionInOCL__ownedBody.setOpposite(_OCLExpression__ExpressionInOCL__ownedBody);
			_ExpressionInOCL__ownedSelfVar.setOpposite(_Variable__ExpressionInOCL__ownedSelfVar);
			_ExpressionInOCL__Constraint__ownedSpecification.setOpposite(_Constraint__ownedSpecification);
			_ExpressionInOCL__Operation__ownedBodyExpression.setOpposite(_Operation__ownedBodyExpression);

			_Import__Root__ownedImports.setOpposite(_Root__ownedImports);


			_IterateExp__ownedResult.setOpposite(_Variable__IterateExp__ownedResult);


			_LetExp__ownedIn.setOpposite(_OCLExpression__LetExp__ownedIn);
			_LetExp__ownedVariable.setOpposite(_Variable__LetExp__ownedVariable);

			_LoopExp__ownedBody.setOpposite(_OCLExpression__LoopExp__ownedBody);
			_LoopExp__ownedIterator.setOpposite(_Variable__LoopExp__ownedIterator);


			_OCLExpression__CallExp__ownedSource.setOpposite(_CallExp__ownedSource);
			_OCLExpression__CollectionItem__ownedItem.setOpposite(_CollectionItem__ownedItem);
			_OCLExpression__CollectionRange__ownedFirst.setOpposite(_CollectionRange__ownedFirst);
			_OCLExpression__CollectionRange__ownedLast.setOpposite(_CollectionRange__ownedLast);
			_OCLExpression__ExpressionInOCL__ownedBody.setOpposite(_ExpressionInOCL__ownedBody);
			_OCLExpression__LetExp__ownedIn.setOpposite(_LetExp__ownedIn);
			_OCLExpression__LoopExp__ownedBody.setOpposite(_LoopExp__ownedBody);
			_OCLExpression__OperationCallExp__ownedArguments.setOpposite(_OperationCallExp__ownedArguments);
			_OCLExpression__Variable__ownedInitExp.setOpposite(_Variable__ownedInitExp);


			_Operation__ownedBodyExpression.setOpposite(_ExpressionInOCL__Operation__ownedBodyExpression);
			_Operation__ownedParameters.setOpposite(_Parameter__Operation__ownedParameters);
			_Operation__owningClass.setOpposite(_Class__ownedOperations);
			_Operation__OperationCallExp__referredOperation.setOpposite(_OperationCallExp__referredOperation);

			_OperationCallExp__ownedArguments.setOpposite(_OCLExpression__OperationCallExp__ownedArguments);
			_OperationCallExp__referredOperation.setOpposite(_Operation__OperationCallExp__referredOperation);

			_Package__ownedClasses.setOpposite(_Class__Package__ownedClasses);
			_Package__ownedPackages.setOpposite(_Package__Package__ownedPackages);
			_Package__Package__ownedPackages.setOpposite(_Package__ownedPackages);
			_Package__Root__ownedPackages.setOpposite(_Root__ownedPackages);

			_Parameter__Operation__ownedParameters.setOpposite(_Operation__ownedParameters);

			_Property__owningClass.setOpposite(_Class__ownedProperties);
			_Property__PropertyCallExp__referredProperty.setOpposite(_PropertyCallExp__referredProperty);

			_PropertyCallExp__referredProperty.setOpposite(_Property__PropertyCallExp__referredProperty);

			_Root__ownedConstraints.setOpposite(_Constraint__Root__ownedConstraints);
			_Root__ownedImports.setOpposite(_Import__Root__ownedImports);
			_Root__ownedPackages.setOpposite(_Package__Root__ownedPackages);

			_TypedElement__type.setOpposite(_Class__TypedElement__type);

			_Variable__ownedInitExp.setOpposite(_OCLExpression__Variable__ownedInitExp);
			_Variable__ExpressionInOCL__ownedSelfVar.setOpposite(_ExpressionInOCL__ownedSelfVar);
			_Variable__IterateExp__ownedResult.setOpposite(_IterateExp__ownedResult);
			_Variable__LetExp__ownedVariable.setOpposite(_LetExp__ownedVariable);
			_Variable__LoopExp__ownedIterator.setOpposite(_LoopExp__ownedIterator);
			_Variable__VariableExp__referredVariable.setOpposite(_VariableExp__referredVariable);

			_VariableExp__referredVariable.setOpposite(_Variable__VariableExp__referredVariable);

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

		private static final @NonNull FlatFragment @NonNull [] _BooleanLiteralExp =
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
		private static final int @NonNull [] __BooleanLiteralExp = { 0,1,2,3,4,5,6,7,8 };

		private static final @NonNull FlatFragment @NonNull [] _CallExp =
			{
				Fragments._CallExp__OclAny /* 0 */,
				Fragments._CallExp__OclElement /* 1 */,
				Fragments._CallExp__Visitable /* 2 */,
				Fragments._CallExp__Element /* 3 */,
				Fragments._CallExp__TypedElement /* 4 */,
				Fragments._CallExp__OCLExpression /* 5 */,
				Fragments._CallExp__CallExp /* 6 */
			};
		private static final int @NonNull [] __CallExp = { 0,1,2,3,4,5,6 };

		private static final @NonNull FlatFragment @NonNull [] _Class =
			{
				Fragments._Class__OclAny /* 0 */,
				Fragments._Class__OclElement /* 1 */,
				Fragments._Class__Visitable /* 2 */,
				Fragments._Class__Element /* 3 */,
				Fragments._Class__NamedElement /* 4 */,
				Fragments._Class__Namespace /* 5 */,
				Fragments._Class__Class /* 6 */
			};
		private static final int @NonNull [] __Class = { 0,1,2,3,4,5,6 };

		private static final @NonNull FlatFragment @NonNull [] _CollectionItem =
			{
				Fragments._CollectionItem__OclAny /* 0 */,
				Fragments._CollectionItem__OclElement /* 1 */,
				Fragments._CollectionItem__Visitable /* 2 */,
				Fragments._CollectionItem__Element /* 3 */,
				Fragments._CollectionItem__TypedElement /* 4 */,
				Fragments._CollectionItem__CollectionLiteralPart /* 5 */,
				Fragments._CollectionItem__CollectionItem /* 6 */
			};
		private static final int @NonNull [] __CollectionItem = { 0,1,2,3,4,5,6 };

		private static final @NonNull FlatFragment @NonNull [] _CollectionKind =
			{
				Fragments._CollectionKind__OclAny /* 0 */,
				Fragments._CollectionKind__OclElement /* 1 */,
				Fragments._CollectionKind__OclType /* 2 */,
				Fragments._CollectionKind__OclEnumeration /* 3 */,
				Fragments._CollectionKind__CollectionKind /* 4 */
			};
		private static final int @NonNull [] __CollectionKind = { 0,1,2,3,4 };

		private static final @NonNull FlatFragment @NonNull [] _CollectionLiteralExp =
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
		private static final int @NonNull [] __CollectionLiteralExp = { 0,1,2,3,4,5,6,7 };

		private static final @NonNull FlatFragment @NonNull [] _CollectionLiteralPart =
			{
				Fragments._CollectionLiteralPart__OclAny /* 0 */,
				Fragments._CollectionLiteralPart__OclElement /* 1 */,
				Fragments._CollectionLiteralPart__Visitable /* 2 */,
				Fragments._CollectionLiteralPart__Element /* 3 */,
				Fragments._CollectionLiteralPart__TypedElement /* 4 */,
				Fragments._CollectionLiteralPart__CollectionLiteralPart /* 5 */
			};
		private static final int @NonNull [] __CollectionLiteralPart = { 0,1,2,3,4,5 };

		private static final @NonNull FlatFragment @NonNull [] _CollectionRange =
			{
				Fragments._CollectionRange__OclAny /* 0 */,
				Fragments._CollectionRange__OclElement /* 1 */,
				Fragments._CollectionRange__Visitable /* 2 */,
				Fragments._CollectionRange__Element /* 3 */,
				Fragments._CollectionRange__TypedElement /* 4 */,
				Fragments._CollectionRange__CollectionLiteralPart /* 5 */,
				Fragments._CollectionRange__CollectionRange /* 6 */
			};
		private static final int @NonNull [] __CollectionRange = { 0,1,2,3,4,5,6 };

		private static final @NonNull FlatFragment @NonNull [] _Constraint =
			{
				Fragments._Constraint__OclAny /* 0 */,
				Fragments._Constraint__OclElement /* 1 */,
				Fragments._Constraint__Visitable /* 2 */,
				Fragments._Constraint__Element /* 3 */,
				Fragments._Constraint__NamedElement /* 4 */,
				Fragments._Constraint__Constraint /* 5 */
			};
		private static final int @NonNull [] __Constraint = { 0,1,2,3,4,5 };

		private static final @NonNull FlatFragment @NonNull [] _Element =
			{
				Fragments._Element__OclAny /* 0 */,
				Fragments._Element__OclElement /* 1 */,
				Fragments._Element__Visitable /* 2 */,
				Fragments._Element__Element /* 3 */
			};
		private static final int @NonNull [] __Element = { 0,1,2,3 };

		private static final @NonNull FlatFragment @NonNull [] _ExpressionInOCL =
			{
				Fragments._ExpressionInOCL__OclAny /* 0 */,
				Fragments._ExpressionInOCL__OclElement /* 1 */,
				Fragments._ExpressionInOCL__Visitable /* 2 */,
				Fragments._ExpressionInOCL__Element /* 3 */,
				Fragments._ExpressionInOCL__TypedElement /* 4 */,
				Fragments._ExpressionInOCL__OpaqueExpression /* 5 */,
				Fragments._ExpressionInOCL__ExpressionInOCL /* 6 */
			};
		private static final int @NonNull [] __ExpressionInOCL = { 0,1,2,3,4,5,6 };

		private static final @NonNull FlatFragment @NonNull [] _Feature =
			{
				Fragments._Feature__OclAny /* 0 */,
				Fragments._Feature__OclElement /* 1 */,
				Fragments._Feature__Visitable /* 2 */,
				Fragments._Feature__Element /* 3 */,
				Fragments._Feature__NamedElement /* 4 */,
				Fragments._Feature__TypedElement /* 4 */,
				Fragments._Feature__Feature /* 5 */
			};
		private static final int @NonNull [] __Feature = { 0,1,2,3,4,6 };

		private static final @NonNull FlatFragment @NonNull [] _Import =
			{
				Fragments._Import__OclAny /* 0 */,
				Fragments._Import__OclElement /* 1 */,
				Fragments._Import__Visitable /* 2 */,
				Fragments._Import__Element /* 3 */,
				Fragments._Import__Import /* 4 */
			};
		private static final int @NonNull [] __Import = { 0,1,2,3,4 };

		private static final @NonNull FlatFragment @NonNull [] _IntegerLiteralExp =
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
		private static final int @NonNull [] __IntegerLiteralExp = { 0,1,2,3,4,5,6,7,8 };

		private static final @NonNull FlatFragment @NonNull [] _IterateExp =
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
		private static final int @NonNull [] __IterateExp = { 0,1,2,3,4,5,6,7,8 };

		private static final @NonNull FlatFragment @NonNull [] _IteratorExp =
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
		private static final int @NonNull [] __IteratorExp = { 0,1,2,3,4,5,6,7,8 };

		private static final @NonNull FlatFragment @NonNull [] _LetExp =
			{
				Fragments._LetExp__OclAny /* 0 */,
				Fragments._LetExp__OclElement /* 1 */,
				Fragments._LetExp__Visitable /* 2 */,
				Fragments._LetExp__Element /* 3 */,
				Fragments._LetExp__TypedElement /* 4 */,
				Fragments._LetExp__OCLExpression /* 5 */,
				Fragments._LetExp__LetExp /* 6 */
			};
		private static final int @NonNull [] __LetExp = { 0,1,2,3,4,5,6 };

		private static final @NonNull FlatFragment @NonNull [] _LiteralExp =
			{
				Fragments._LiteralExp__OclAny /* 0 */,
				Fragments._LiteralExp__OclElement /* 1 */,
				Fragments._LiteralExp__Visitable /* 2 */,
				Fragments._LiteralExp__Element /* 3 */,
				Fragments._LiteralExp__TypedElement /* 4 */,
				Fragments._LiteralExp__OCLExpression /* 5 */,
				Fragments._LiteralExp__LiteralExp /* 6 */
			};
		private static final int @NonNull [] __LiteralExp = { 0,1,2,3,4,5,6 };

		private static final @NonNull FlatFragment @NonNull [] _LoopExp =
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
		private static final int @NonNull [] __LoopExp = { 0,1,2,3,4,5,6,7 };

		private static final @NonNull FlatFragment @NonNull [] _NamedElement =
			{
				Fragments._NamedElement__OclAny /* 0 */,
				Fragments._NamedElement__OclElement /* 1 */,
				Fragments._NamedElement__Visitable /* 2 */,
				Fragments._NamedElement__Element /* 3 */,
				Fragments._NamedElement__NamedElement /* 4 */
			};
		private static final int @NonNull [] __NamedElement = { 0,1,2,3,4 };

		private static final @NonNull FlatFragment @NonNull [] _Namespace =
			{
				Fragments._Namespace__OclAny /* 0 */,
				Fragments._Namespace__OclElement /* 1 */,
				Fragments._Namespace__Visitable /* 2 */,
				Fragments._Namespace__Element /* 3 */,
				Fragments._Namespace__NamedElement /* 4 */,
				Fragments._Namespace__Namespace /* 5 */
			};
		private static final int @NonNull [] __Namespace = { 0,1,2,3,4,5 };

		private static final @NonNull FlatFragment @NonNull [] _NullLiteralExp =
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
		private static final int @NonNull [] __NullLiteralExp = { 0,1,2,3,4,5,6,7 };

		private static final @NonNull FlatFragment @NonNull [] _OCLExpression =
			{
				Fragments._OCLExpression__OclAny /* 0 */,
				Fragments._OCLExpression__OclElement /* 1 */,
				Fragments._OCLExpression__Visitable /* 2 */,
				Fragments._OCLExpression__Element /* 3 */,
				Fragments._OCLExpression__TypedElement /* 4 */,
				Fragments._OCLExpression__OCLExpression /* 5 */
			};
		private static final int @NonNull [] __OCLExpression = { 0,1,2,3,4,5 };

		private static final @NonNull FlatFragment @NonNull [] _OpaqueExpression =
			{
				Fragments._OpaqueExpression__OclAny /* 0 */,
				Fragments._OpaqueExpression__OclElement /* 1 */,
				Fragments._OpaqueExpression__Visitable /* 2 */,
				Fragments._OpaqueExpression__Element /* 3 */,
				Fragments._OpaqueExpression__TypedElement /* 4 */,
				Fragments._OpaqueExpression__OpaqueExpression /* 5 */
			};
		private static final int @NonNull [] __OpaqueExpression = { 0,1,2,3,4,5 };

		private static final @NonNull FlatFragment @NonNull [] _Operation =
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
		private static final int @NonNull [] __Operation = { 0,1,2,3,4,6,7 };

		private static final @NonNull FlatFragment @NonNull [] _OperationCallExp =
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
		private static final int @NonNull [] __OperationCallExp = { 0,1,2,3,4,5,6,7 };

		private static final @NonNull FlatFragment @NonNull [] _Package =
			{
				Fragments._Package__OclAny /* 0 */,
				Fragments._Package__OclElement /* 1 */,
				Fragments._Package__Visitable /* 2 */,
				Fragments._Package__Element /* 3 */,
				Fragments._Package__NamedElement /* 4 */,
				Fragments._Package__Namespace /* 5 */,
				Fragments._Package__Package /* 6 */
			};
		private static final int @NonNull [] __Package = { 0,1,2,3,4,5,6 };

		private static final @NonNull FlatFragment @NonNull [] _Parameter =
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
		private static final int @NonNull [] __Parameter = { 0,1,2,3,4,6,7 };

		private static final @NonNull FlatFragment @NonNull [] _PrimitiveLiteralExp =
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
		private static final int @NonNull [] __PrimitiveLiteralExp = { 0,1,2,3,4,5,6,7 };

		private static final @NonNull FlatFragment @NonNull [] _Property =
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
		private static final int @NonNull [] __Property = { 0,1,2,3,4,6,7 };

		private static final @NonNull FlatFragment @NonNull [] _PropertyCallExp =
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
		private static final int @NonNull [] __PropertyCallExp = { 0,1,2,3,4,5,6,7 };

		private static final @NonNull FlatFragment @NonNull [] _Root =
			{
				Fragments._Root__OclAny /* 0 */,
				Fragments._Root__OclElement /* 1 */,
				Fragments._Root__Visitable /* 2 */,
				Fragments._Root__Element /* 3 */,
				Fragments._Root__Root /* 4 */
			};
		private static final int @NonNull [] __Root = { 0,1,2,3,4 };

		private static final @NonNull FlatFragment @NonNull [] _TypedElement =
			{
				Fragments._TypedElement__OclAny /* 0 */,
				Fragments._TypedElement__OclElement /* 1 */,
				Fragments._TypedElement__Visitable /* 2 */,
				Fragments._TypedElement__Element /* 3 */,
				Fragments._TypedElement__TypedElement /* 4 */
			};
		private static final int @NonNull [] __TypedElement = { 0,1,2,3,4 };

		private static final @NonNull FlatFragment @NonNull [] _Variable =
			{
				Fragments._Variable__OclAny /* 0 */,
				Fragments._Variable__OclElement /* 1 */,
				Fragments._Variable__Visitable /* 2 */,
				Fragments._Variable__Element /* 3 */,
				Fragments._Variable__NamedElement /* 4 */,
				Fragments._Variable__TypedElement /* 4 */,
				Fragments._Variable__Variable /* 5 */
			};
		private static final int @NonNull [] __Variable = { 0,1,2,3,4,6 };

		private static final @NonNull FlatFragment @NonNull [] _VariableExp =
			{
				Fragments._VariableExp__OclAny /* 0 */,
				Fragments._VariableExp__OclElement /* 1 */,
				Fragments._VariableExp__Visitable /* 2 */,
				Fragments._VariableExp__Element /* 3 */,
				Fragments._VariableExp__TypedElement /* 4 */,
				Fragments._VariableExp__OCLExpression /* 5 */,
				Fragments._VariableExp__VariableExp /* 6 */
			};
		private static final int @NonNull [] __VariableExp = { 0,1,2,3,4,5,6 };

		private static final @NonNull FlatFragment @NonNull [] _Visitable =
			{
				Fragments._Visitable__OclAny /* 0 */,
				Fragments._Visitable__OclElement /* 1 */,
				Fragments._Visitable__Visitable /* 2 */
			};
		private static final int @NonNull [] __Visitable = { 0,1,2 };

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

		private static final @NonNull Operation @NonNull [] _BooleanLiteralExp__BooleanLiteralExp = {};
		private static final @NonNull Operation @NonNull [] _BooleanLiteralExp__Element = {};
		private static final @NonNull Operation @NonNull [] _BooleanLiteralExp__LiteralExp = {};
		private static final @NonNull Operation @NonNull [] _BooleanLiteralExp__OCLExpression = {};
		private static final @NonNull Operation @NonNull [] _BooleanLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _BooleanLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _BooleanLiteralExp__PrimitiveLiteralExp = {};
		private static final @NonNull Operation @NonNull [] _BooleanLiteralExp__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _BooleanLiteralExp__Visitable = {};

		private static final @NonNull Operation @NonNull [] _CallExp__CallExp = {};
		private static final @NonNull Operation @NonNull [] _CallExp__Element = {};
		private static final @NonNull Operation @NonNull [] _CallExp__OCLExpression = {};
		private static final @NonNull Operation @NonNull [] _CallExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _CallExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _CallExp__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _CallExp__Visitable = {};

		private static final @NonNull Operation @NonNull [] _Class__Class = {};
		private static final @NonNull Operation @NonNull [] _Class__Element = {};
		private static final @NonNull Operation @NonNull [] _Class__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _Class__Namespace = {};
		private static final @NonNull Operation @NonNull [] _Class__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Class__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _Class__Visitable = {};

		private static final @NonNull Operation @NonNull [] _CollectionItem__CollectionItem = {};
		private static final @NonNull Operation @NonNull [] _CollectionItem__CollectionLiteralPart = {};
		private static final @NonNull Operation @NonNull [] _CollectionItem__Element = {};
		private static final @NonNull Operation @NonNull [] _CollectionItem__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _CollectionItem__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _CollectionItem__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _CollectionItem__Visitable = {};

		private static final @NonNull Operation @NonNull [] _CollectionKind__CollectionKind = {};
		private static final @NonNull Operation @NonNull [] _CollectionKind__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _CollectionKind__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _CollectionKind__OclEnumeration = {};
		private static final @NonNull Operation @NonNull [] _CollectionKind__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final @NonNull Operation @NonNull [] _CollectionLiteralExp__CollectionLiteralExp = {};
		private static final @NonNull Operation @NonNull [] _CollectionLiteralExp__Element = {};
		private static final @NonNull Operation @NonNull [] _CollectionLiteralExp__LiteralExp = {};
		private static final @NonNull Operation @NonNull [] _CollectionLiteralExp__OCLExpression = {};
		private static final @NonNull Operation @NonNull [] _CollectionLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _CollectionLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _CollectionLiteralExp__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _CollectionLiteralExp__Visitable = {};

		private static final @NonNull Operation @NonNull [] _CollectionLiteralPart__CollectionLiteralPart = {};
		private static final @NonNull Operation @NonNull [] _CollectionLiteralPart__Element = {};
		private static final @NonNull Operation @NonNull [] _CollectionLiteralPart__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _CollectionLiteralPart__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _CollectionLiteralPart__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _CollectionLiteralPart__Visitable = {};

		private static final @NonNull Operation @NonNull [] _CollectionRange__CollectionRange = {};
		private static final @NonNull Operation @NonNull [] _CollectionRange__CollectionLiteralPart = {};
		private static final @NonNull Operation @NonNull [] _CollectionRange__Element = {};
		private static final @NonNull Operation @NonNull [] _CollectionRange__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _CollectionRange__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _CollectionRange__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _CollectionRange__Visitable = {};

		private static final @NonNull Operation @NonNull [] _Constraint__Constraint = {};
		private static final @NonNull Operation @NonNull [] _Constraint__Element = {};
		private static final @NonNull Operation @NonNull [] _Constraint__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _Constraint__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Constraint__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _Constraint__Visitable = {};

		private static final @NonNull Operation @NonNull [] _Element__Element = {};
		private static final @NonNull Operation @NonNull [] _Element__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Element__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _Element__Visitable = {};

		private static final @NonNull Operation @NonNull [] _ExpressionInOCL__ExpressionInOCL = {};
		private static final @NonNull Operation @NonNull [] _ExpressionInOCL__Element = {};
		private static final @NonNull Operation @NonNull [] _ExpressionInOCL__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _ExpressionInOCL__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _ExpressionInOCL__OpaqueExpression = {};
		private static final @NonNull Operation @NonNull [] _ExpressionInOCL__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _ExpressionInOCL__Visitable = {};

		private static final @NonNull Operation @NonNull [] _Feature__Feature = {};
		private static final @NonNull Operation @NonNull [] _Feature__Element = {};
		private static final @NonNull Operation @NonNull [] _Feature__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _Feature__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Feature__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _Feature__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _Feature__Visitable = {};

		private static final @NonNull Operation @NonNull [] _Import__Import = {};
		private static final @NonNull Operation @NonNull [] _Import__Element = {};
		private static final @NonNull Operation @NonNull [] _Import__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Import__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _Import__Visitable = {};

		private static final @NonNull Operation @NonNull [] _IntegerLiteralExp__IntegerLiteralExp = {};
		private static final @NonNull Operation @NonNull [] _IntegerLiteralExp__Element = {};
		private static final @NonNull Operation @NonNull [] _IntegerLiteralExp__LiteralExp = {};
		private static final @NonNull Operation @NonNull [] _IntegerLiteralExp__OCLExpression = {};
		private static final @NonNull Operation @NonNull [] _IntegerLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _IntegerLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _IntegerLiteralExp__PrimitiveLiteralExp = {};
		private static final @NonNull Operation @NonNull [] _IntegerLiteralExp__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _IntegerLiteralExp__Visitable = {};

		private static final @NonNull Operation @NonNull [] _IterateExp__IterateExp = {};
		private static final @NonNull Operation @NonNull [] _IterateExp__CallExp = {};
		private static final @NonNull Operation @NonNull [] _IterateExp__Element = {};
		private static final @NonNull Operation @NonNull [] _IterateExp__LoopExp = {};
		private static final @NonNull Operation @NonNull [] _IterateExp__OCLExpression = {};
		private static final @NonNull Operation @NonNull [] _IterateExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _IterateExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _IterateExp__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _IterateExp__Visitable = {};

		private static final @NonNull Operation @NonNull [] _IteratorExp__IteratorExp = {};
		private static final @NonNull Operation @NonNull [] _IteratorExp__CallExp = {};
		private static final @NonNull Operation @NonNull [] _IteratorExp__Element = {};
		private static final @NonNull Operation @NonNull [] _IteratorExp__LoopExp = {};
		private static final @NonNull Operation @NonNull [] _IteratorExp__OCLExpression = {};
		private static final @NonNull Operation @NonNull [] _IteratorExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _IteratorExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _IteratorExp__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _IteratorExp__Visitable = {};

		private static final @NonNull Operation @NonNull [] _LetExp__LetExp = {};
		private static final @NonNull Operation @NonNull [] _LetExp__Element = {};
		private static final @NonNull Operation @NonNull [] _LetExp__OCLExpression = {};
		private static final @NonNull Operation @NonNull [] _LetExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _LetExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _LetExp__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _LetExp__Visitable = {};

		private static final @NonNull Operation @NonNull [] _LiteralExp__LiteralExp = {};
		private static final @NonNull Operation @NonNull [] _LiteralExp__Element = {};
		private static final @NonNull Operation @NonNull [] _LiteralExp__OCLExpression = {};
		private static final @NonNull Operation @NonNull [] _LiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _LiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _LiteralExp__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _LiteralExp__Visitable = {};

		private static final @NonNull Operation @NonNull [] _LoopExp__LoopExp = {};
		private static final @NonNull Operation @NonNull [] _LoopExp__CallExp = {};
		private static final @NonNull Operation @NonNull [] _LoopExp__Element = {};
		private static final @NonNull Operation @NonNull [] _LoopExp__OCLExpression = {};
		private static final @NonNull Operation @NonNull [] _LoopExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _LoopExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _LoopExp__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _LoopExp__Visitable = {};

		private static final @NonNull Operation @NonNull [] _NamedElement__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _NamedElement__Element = {};
		private static final @NonNull Operation @NonNull [] _NamedElement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _NamedElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _NamedElement__Visitable = {};

		private static final @NonNull Operation @NonNull [] _Namespace__Namespace = {};
		private static final @NonNull Operation @NonNull [] _Namespace__Element = {};
		private static final @NonNull Operation @NonNull [] _Namespace__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _Namespace__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Namespace__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _Namespace__Visitable = {};

		private static final @NonNull Operation @NonNull [] _NullLiteralExp__NullLiteralExp = {};
		private static final @NonNull Operation @NonNull [] _NullLiteralExp__Element = {};
		private static final @NonNull Operation @NonNull [] _NullLiteralExp__LiteralExp = {};
		private static final @NonNull Operation @NonNull [] _NullLiteralExp__OCLExpression = {};
		private static final @NonNull Operation @NonNull [] _NullLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _NullLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _NullLiteralExp__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _NullLiteralExp__Visitable = {};

		private static final @NonNull Operation @NonNull [] _OCLExpression__OCLExpression = {};
		private static final @NonNull Operation @NonNull [] _OCLExpression__Element = {};
		private static final @NonNull Operation @NonNull [] _OCLExpression__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _OCLExpression__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _OCLExpression__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _OCLExpression__Visitable = {};

		private static final @NonNull Operation @NonNull [] _OpaqueExpression__OpaqueExpression = {};
		private static final @NonNull Operation @NonNull [] _OpaqueExpression__Element = {};
		private static final @NonNull Operation @NonNull [] _OpaqueExpression__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _OpaqueExpression__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _OpaqueExpression__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _OpaqueExpression__Visitable = {};

		private static final @NonNull Operation @NonNull [] _Operation__Operation = {};
		private static final @NonNull Operation @NonNull [] _Operation__Element = {};
		private static final @NonNull Operation @NonNull [] _Operation__Feature = {};
		private static final @NonNull Operation @NonNull [] _Operation__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _Operation__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Operation__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _Operation__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _Operation__Visitable = {};

		private static final @NonNull Operation @NonNull [] _OperationCallExp__OperationCallExp = {};
		private static final @NonNull Operation @NonNull [] _OperationCallExp__CallExp = {};
		private static final @NonNull Operation @NonNull [] _OperationCallExp__Element = {};
		private static final @NonNull Operation @NonNull [] _OperationCallExp__OCLExpression = {};
		private static final @NonNull Operation @NonNull [] _OperationCallExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _OperationCallExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _OperationCallExp__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _OperationCallExp__Visitable = {};

		private static final @NonNull Operation @NonNull [] _Package__Package = {};
		private static final @NonNull Operation @NonNull [] _Package__Element = {};
		private static final @NonNull Operation @NonNull [] _Package__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _Package__Namespace = {};
		private static final @NonNull Operation @NonNull [] _Package__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Package__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _Package__Visitable = {};

		private static final @NonNull Operation @NonNull [] _Parameter__Parameter = {};
		private static final @NonNull Operation @NonNull [] _Parameter__Element = {};
		private static final @NonNull Operation @NonNull [] _Parameter__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _Parameter__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Parameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _Parameter__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _Parameter__Variable = {};
		private static final @NonNull Operation @NonNull [] _Parameter__Visitable = {};

		private static final @NonNull Operation @NonNull [] _PrimitiveLiteralExp__PrimitiveLiteralExp = {};
		private static final @NonNull Operation @NonNull [] _PrimitiveLiteralExp__Element = {};
		private static final @NonNull Operation @NonNull [] _PrimitiveLiteralExp__LiteralExp = {};
		private static final @NonNull Operation @NonNull [] _PrimitiveLiteralExp__OCLExpression = {};
		private static final @NonNull Operation @NonNull [] _PrimitiveLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _PrimitiveLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _PrimitiveLiteralExp__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _PrimitiveLiteralExp__Visitable = {};

		private static final @NonNull Operation @NonNull [] _Property__Property = {};
		private static final @NonNull Operation @NonNull [] _Property__Element = {};
		private static final @NonNull Operation @NonNull [] _Property__Feature = {};
		private static final @NonNull Operation @NonNull [] _Property__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _Property__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Property__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _Property__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _Property__Visitable = {};

		private static final @NonNull Operation @NonNull [] _PropertyCallExp__PropertyCallExp = {};
		private static final @NonNull Operation @NonNull [] _PropertyCallExp__CallExp = {};
		private static final @NonNull Operation @NonNull [] _PropertyCallExp__Element = {};
		private static final @NonNull Operation @NonNull [] _PropertyCallExp__OCLExpression = {};
		private static final @NonNull Operation @NonNull [] _PropertyCallExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _PropertyCallExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _PropertyCallExp__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _PropertyCallExp__Visitable = {};

		private static final @NonNull Operation @NonNull [] _Root__Root = {};
		private static final @NonNull Operation @NonNull [] _Root__Element = {};
		private static final @NonNull Operation @NonNull [] _Root__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Root__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _Root__Visitable = {};

		private static final @NonNull Operation @NonNull [] _TypedElement__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _TypedElement__Element = {};
		private static final @NonNull Operation @NonNull [] _TypedElement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _TypedElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _TypedElement__Visitable = {};

		private static final @NonNull Operation @NonNull [] _Variable__Variable = {};
		private static final @NonNull Operation @NonNull [] _Variable__Element = {};
		private static final @NonNull Operation @NonNull [] _Variable__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _Variable__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Variable__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _Variable__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _Variable__Visitable = {};

		private static final @NonNull Operation @NonNull [] _VariableExp__VariableExp = {};
		private static final @NonNull Operation @NonNull [] _VariableExp__Element = {};
		private static final @NonNull Operation @NonNull [] _VariableExp__OCLExpression = {};
		private static final @NonNull Operation @NonNull [] _VariableExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _VariableExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull Operation @NonNull [] _VariableExp__TypedElement = {};
		private static final @NonNull Operation @NonNull [] _VariableExp__Visitable = {};

		private static final @NonNull Operation @NonNull [] _Visitable__Visitable = {};
		private static final @NonNull Operation @NonNull [] _Visitable__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull Operation @NonNull [] _Visitable__OclElement = {
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
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

		private static final @NonNull Property @NonNull [] _BooleanLiteralExp = {
			Properties._BooleanLiteralExp__booleanSymbol,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _CallExp = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._CallExp__ownedSource,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _Class = {
			Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Class__ownedOperations,
			Properties._Class__ownedProperties,
			Properties._Class__superClasses
		};

		private static final @NonNull Property @NonNull [] _CollectionItem = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._CollectionItem__ownedItem,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _CollectionKind = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _CollectionLiteralExp = {
			Properties._CollectionLiteralExp__kind,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._CollectionLiteralExp__ownedParts,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _CollectionLiteralPart = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _CollectionRange = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._CollectionRange__ownedFirst,
			Properties._CollectionRange__ownedLast,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _Constraint = {
			Properties._Constraint__constrainedElement,
			Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Constraint__ownedSpecification
		};

		private static final @NonNull Property @NonNull [] _Element = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _ExpressionInOCL = {
			Properties._OpaqueExpression__language,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._ExpressionInOCL__ownedBody,
			Properties._ExpressionInOCL__ownedSelfVar,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _Feature = {
			Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _Import = {
			Properties._Import__alias,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Import__uri
		};

		private static final @NonNull Property @NonNull [] _IntegerLiteralExp = {
			Properties._IntegerLiteralExp__integerSymbol,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _IterateExp = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._LoopExp__ownedBody,
			Properties._LoopExp__ownedIterator,
			Properties._IterateExp__ownedResult,
			Properties._CallExp__ownedSource,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _IteratorExp = {
			Properties._IteratorExp__iterator,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._LoopExp__ownedBody,
			Properties._LoopExp__ownedIterator,
			Properties._CallExp__ownedSource,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _LetExp = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._LetExp__ownedIn,
			Properties._LetExp__ownedVariable,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _LiteralExp = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _LoopExp = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._LoopExp__ownedBody,
			Properties._LoopExp__ownedIterator,
			Properties._CallExp__ownedSource,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _NamedElement = {
			Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _Namespace = {
			Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _NullLiteralExp = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _OCLExpression = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _OpaqueExpression = {
			Properties._OpaqueExpression__language,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _Operation = {
			Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Operation__ownedBodyExpression,
			Properties._Operation__ownedParameters,
			Properties._Operation__owningClass,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _OperationCallExp = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._OperationCallExp__ownedArguments,
			Properties._CallExp__ownedSource,
			Properties._OperationCallExp__referredOperation,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _Package = {
			Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Package__ownedClasses,
			Properties._Package__ownedPackages
		};

		private static final @NonNull Property @NonNull [] _Parameter = {
			Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Variable__ownedInitExp,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _PrimitiveLiteralExp = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _Property = {
			Properties._Property__lowerBound,
			Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Property__owningClass,
			Properties._TypedElement__type,
			Properties._Property__upperBound
		};

		private static final @NonNull Property @NonNull [] _PropertyCallExp = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._CallExp__ownedSource,
			Properties._PropertyCallExp__referredProperty,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _Root = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Root__ownedConstraints,
			Properties._Root__ownedImports,
			Properties._Root__ownedPackages
		};

		private static final @NonNull Property @NonNull [] _TypedElement = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _Variable = {
			Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Variable__ownedInitExp,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _VariableExp = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._VariableExp__referredVariable,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _Visitable = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

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

		public static final @NonNull EnumerationLiteral _CollectionKind__Collection = LIBRARY.createEnumerationLiteral(MiniOCLPackage.Literals.COLLECTION_KIND.getEEnumLiteral("Collection"), Types._CollectionKind, 0);
		private static final @NonNull EnumerationLiteral @NonNull [] _CollectionKind = {
			_CollectionKind__Collection
		};

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {
			LIBRARY.initLiterals(Types._CollectionKind, _CollectionKind);

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
		 * Invoked at the start of a static construction to defer residual construction until primary constructions complete.
		 */
		private static void initStart() {
			if (initCount >= 0) {
				initCount++;
			}
		}

		/**
		 * Invoked at the end of a static construction to activate residual construction once primary constructions complete.
		 */
		private static void initEnd() {
			if (initCount > 0) {
				if (--initCount == 0) {
					initCount = -1;
					EnumerationLiterals.init();
					LIBRARY.freeze(RESOURCE);
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
	public static void init() {
		new MiniOCLTables();
	}

	private MiniOCLTables() {
		super(MiniOCLPackage.eNS_URI);
	}
}
