/*******************************************************************************
 * Copyright (c) 2014, 2025 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 *   /org.eclipse.qvtd.cs2as.compiler.tests/models/SimpleClasses/Classes.ecore
 * using:
 *   /org.eclipse.qvtd.cs2as.compiler.tests/models/SimpleClasses/Classes.genmodel
 *   org.eclipse.ocl.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package example2.classes;

// import example2.classes.ClassesPackage;
// import example2.classes.ClassesTables;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.flat.FlatClass;
import org.eclipse.ocl.pivot.flat.FlatFragment;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.PartialStandardLibraryImpl;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.AbstractTables;
import org.eclipse.ocl.pivot.utilities.ValueUtil;

/**
 * ClassesTables provides the dispatch tables for the classes for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
public class ClassesTables extends AbstractTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The overall library of all packages and types.
	 */
	public static final PartialStandardLibraryImpl.@NonNull ReadOnly LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	The AS package for the ClassesPackage.eINSTANCE EPackage.
	 */
	public static final org.eclipse.ocl.pivot.@NonNull Package PACKAGE = LIBRARY.createPackage(ClassesPackage.eINSTANCE);

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
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classes/1.0", "classes", ClassesPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Argument = ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Argument", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CallExp = ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("CallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Operation = ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Operation", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OperationCallExp = ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("OperationCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Package = ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Package", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Parameter = ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Parameter", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Property = ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Property", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_PropertyCallExp = ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("PropertyCallExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Root = ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Root", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TypedElement = ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("TypedElement", 0);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_Class = TypeId.BAG.getSpecializedId(ClassesTables.CLSSid_Class, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_OperationCallExp = TypeId.BAG.getSpecializedId(ClassesTables.CLSSid_OperationCallExp, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_PropertyCallExp = TypeId.BAG.getSpecializedId(ClassesTables.CLSSid_PropertyCallExp, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_TypedElement = TypeId.BAG.getSpecializedId(ClassesTables.CLSSid_TypedElement, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Argument = TypeId.ORDERED_SET.getSpecializedId(ClassesTables.CLSSid_Argument, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_CallExp = TypeId.ORDERED_SET.getSpecializedId(ClassesTables.CLSSid_CallExp, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Class = TypeId.ORDERED_SET.getSpecializedId(ClassesTables.CLSSid_Class, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Operation = TypeId.ORDERED_SET.getSpecializedId(ClassesTables.CLSSid_Operation, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Package = TypeId.ORDERED_SET.getSpecializedId(ClassesTables.CLSSid_Package, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Parameter = TypeId.ORDERED_SET.getSpecializedId(ClassesTables.CLSSid_Parameter, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Property = TypeId.ORDERED_SET.getSpecializedId(ClassesTables.CLSSid_Property, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			ClassesTables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ClassesTables::TypeParameters and all preceding sub-packages.
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

		public static final org.eclipse.ocl.pivot.@NonNull Class _Argument = LIBRARY.createClass(PivotPackage.Literals.CLASS, ClassesPackage.Literals.ARGUMENT, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _CallExp = LIBRARY.createClass(PivotPackage.Literals.CLASS, ClassesPackage.Literals.CALL_EXP, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Class = LIBRARY.createClass(PivotPackage.Literals.CLASS, ClassesPackage.Literals.CLASS, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Element = LIBRARY.createClass(PivotPackage.Literals.CLASS, ClassesPackage.Literals.ELEMENT, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _NamedElement = LIBRARY.createClass(PivotPackage.Literals.CLASS, ClassesPackage.Literals.NAMED_ELEMENT, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Namespace = LIBRARY.createClass(PivotPackage.Literals.CLASS, ClassesPackage.Literals.NAMESPACE, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Operation = LIBRARY.createClass(PivotPackage.Literals.CLASS, ClassesPackage.Literals.OPERATION, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _OperationCallExp = LIBRARY.createClass(PivotPackage.Literals.CLASS, ClassesPackage.Literals.OPERATION_CALL_EXP, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Package = LIBRARY.createClass(PivotPackage.Literals.CLASS, ClassesPackage.Literals.PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Parameter = LIBRARY.createClass(PivotPackage.Literals.CLASS, ClassesPackage.Literals.PARAMETER, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Property = LIBRARY.createClass(PivotPackage.Literals.CLASS, ClassesPackage.Literals.PROPERTY, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _PropertyCallExp = LIBRARY.createClass(PivotPackage.Literals.CLASS, ClassesPackage.Literals.PROPERTY_CALL_EXP, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Root = LIBRARY.createClass(PivotPackage.Literals.CLASS, ClassesPackage.Literals.ROOT, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _TypedElement = LIBRARY.createClass(PivotPackage.Literals.CLASS, ClassesPackage.Literals.TYPED_ELEMENT, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Visitable = LIBRARY.createClass(PivotPackage.Literals.CLASS, ClassesPackage.Literals.VISITABLE, null, 0 | FlatClass.ABSTRACT);

		private static final org.eclipse.ocl.pivot.@NonNull Class @NonNull [] types = {
			_Argument,
			_CallExp,
			_Class,
			_Element,
			_NamedElement,
			_Namespace,
			_Operation,
			_OperationCallExp,
			_Package,
			_Parameter,
			_Property,
			_PropertyCallExp,
			_Root,
			_TypedElement,
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
		 * Force initialization of the fields of ClassesTables::Types and all preceding sub-packages.
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

		private static final @NonNull FlatFragment _Argument__Argument = LIBRARY.createFragment(Types._Argument, Types._Argument);
		private static final @NonNull FlatFragment _Argument__Element = LIBRARY.createFragment(Types._Argument, Types._Element);
		private static final @NonNull FlatFragment _Argument__NamedElement = LIBRARY.createFragment(Types._Argument, Types._NamedElement);
		private static final @NonNull FlatFragment _Argument__OclAny = LIBRARY.createFragment(Types._Argument, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Argument__OclElement = LIBRARY.createFragment(Types._Argument, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Argument__Visitable = LIBRARY.createFragment(Types._Argument, Types._Visitable);

		private static final @NonNull FlatFragment _CallExp__CallExp = LIBRARY.createFragment(Types._CallExp, Types._CallExp);
		private static final @NonNull FlatFragment _CallExp__Element = LIBRARY.createFragment(Types._CallExp, Types._Element);
		private static final @NonNull FlatFragment _CallExp__OclAny = LIBRARY.createFragment(Types._CallExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _CallExp__OclElement = LIBRARY.createFragment(Types._CallExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _CallExp__TypedElement = LIBRARY.createFragment(Types._CallExp, Types._TypedElement);
		private static final @NonNull FlatFragment _CallExp__Visitable = LIBRARY.createFragment(Types._CallExp, Types._Visitable);

		private static final @NonNull FlatFragment _Class__Class = LIBRARY.createFragment(Types._Class, Types._Class);
		private static final @NonNull FlatFragment _Class__Element = LIBRARY.createFragment(Types._Class, Types._Element);
		private static final @NonNull FlatFragment _Class__NamedElement = LIBRARY.createFragment(Types._Class, Types._NamedElement);
		private static final @NonNull FlatFragment _Class__OclAny = LIBRARY.createFragment(Types._Class, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Class__OclElement = LIBRARY.createFragment(Types._Class, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Class__Visitable = LIBRARY.createFragment(Types._Class, Types._Visitable);

		private static final @NonNull FlatFragment _Element__Element = LIBRARY.createFragment(Types._Element, Types._Element);
		private static final @NonNull FlatFragment _Element__OclAny = LIBRARY.createFragment(Types._Element, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Element__OclElement = LIBRARY.createFragment(Types._Element, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Element__Visitable = LIBRARY.createFragment(Types._Element, Types._Visitable);

		private static final @NonNull FlatFragment _NamedElement__Element = LIBRARY.createFragment(Types._NamedElement, Types._Element);
		private static final @NonNull FlatFragment _NamedElement__NamedElement = LIBRARY.createFragment(Types._NamedElement, Types._NamedElement);
		private static final @NonNull FlatFragment _NamedElement__OclAny = LIBRARY.createFragment(Types._NamedElement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _NamedElement__OclElement = LIBRARY.createFragment(Types._NamedElement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _NamedElement__Visitable = LIBRARY.createFragment(Types._NamedElement, Types._Visitable);

		private static final @NonNull FlatFragment _Namespace__Element = LIBRARY.createFragment(Types._Namespace, Types._Element);
		private static final @NonNull FlatFragment _Namespace__Namespace = LIBRARY.createFragment(Types._Namespace, Types._Namespace);
		private static final @NonNull FlatFragment _Namespace__OclAny = LIBRARY.createFragment(Types._Namespace, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Namespace__OclElement = LIBRARY.createFragment(Types._Namespace, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Namespace__Visitable = LIBRARY.createFragment(Types._Namespace, Types._Visitable);

		private static final @NonNull FlatFragment _Operation__Element = LIBRARY.createFragment(Types._Operation, Types._Element);
		private static final @NonNull FlatFragment _Operation__NamedElement = LIBRARY.createFragment(Types._Operation, Types._NamedElement);
		private static final @NonNull FlatFragment _Operation__OclAny = LIBRARY.createFragment(Types._Operation, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Operation__OclElement = LIBRARY.createFragment(Types._Operation, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Operation__Operation = LIBRARY.createFragment(Types._Operation, Types._Operation);
		private static final @NonNull FlatFragment _Operation__TypedElement = LIBRARY.createFragment(Types._Operation, Types._TypedElement);
		private static final @NonNull FlatFragment _Operation__Visitable = LIBRARY.createFragment(Types._Operation, Types._Visitable);

		private static final @NonNull FlatFragment _OperationCallExp__CallExp = LIBRARY.createFragment(Types._OperationCallExp, Types._CallExp);
		private static final @NonNull FlatFragment _OperationCallExp__Element = LIBRARY.createFragment(Types._OperationCallExp, Types._Element);
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
		private static final @NonNull FlatFragment _Parameter__Visitable = LIBRARY.createFragment(Types._Parameter, Types._Visitable);

		private static final @NonNull FlatFragment _Property__Element = LIBRARY.createFragment(Types._Property, Types._Element);
		private static final @NonNull FlatFragment _Property__NamedElement = LIBRARY.createFragment(Types._Property, Types._NamedElement);
		private static final @NonNull FlatFragment _Property__OclAny = LIBRARY.createFragment(Types._Property, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Property__OclElement = LIBRARY.createFragment(Types._Property, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Property__Property = LIBRARY.createFragment(Types._Property, Types._Property);
		private static final @NonNull FlatFragment _Property__TypedElement = LIBRARY.createFragment(Types._Property, Types._TypedElement);
		private static final @NonNull FlatFragment _Property__Visitable = LIBRARY.createFragment(Types._Property, Types._Visitable);

		private static final @NonNull FlatFragment _PropertyCallExp__CallExp = LIBRARY.createFragment(Types._PropertyCallExp, Types._CallExp);
		private static final @NonNull FlatFragment _PropertyCallExp__Element = LIBRARY.createFragment(Types._PropertyCallExp, Types._Element);
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

		private static final @NonNull FlatFragment _Visitable__OclAny = LIBRARY.createFragment(Types._Visitable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Visitable__OclElement = LIBRARY.createFragment(Types._Visitable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Visitable__Visitable = LIBRARY.createFragment(Types._Visitable, Types._Visitable);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ClassesTables::Fragments and all preceding sub-packages.
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
		 * Force initialization of the fields of ClassesTables::Parameters and all preceding sub-packages.
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
		 * Force initialization of the fields of ClassesTables::Operations and all preceding sub-packages.
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

		public static final @NonNull Property _Argument__OperationCallExp__ownedArguments = LIBRARY.createOppositeProperty(Types._Argument, "OperationCallExp", Types._OperationCallExp, 0 | IsImplicit | IsResolveProxies, ClassesPackage.Literals.OPERATION_CALL_EXP__OWNED_ARGUMENTS);

		public static final @NonNull Property _CallExp__ownedCallExp = LIBRARY.createProperty(Types._CallExp, ClassesPackage.Literals.CALL_EXP__OWNED_CALL_EXP, Types._CallExp, 0 | IsComposite | IsResolveProxies);
		public static final @NonNull Property _CallExp__owningSource = LIBRARY.createProperty(Types._CallExp, ClassesPackage.Literals.CALL_EXP__OWNING_SOURCE, Types._CallExp, 1 | IsResolveProxies);
		public static final @NonNull Property _CallExp__Operation__ownedExpressions = LIBRARY.createOppositeProperty(Types._CallExp, "Operation", Types._Operation, 2 | IsImplicit | IsResolveProxies, ClassesPackage.Literals.OPERATION__OWNED_EXPRESSIONS);

		public static final @NonNull Property _Class__ownedOperations = LIBRARY.createProperty(Types._Class, ClassesPackage.Literals.CLASS__OWNED_OPERATIONS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Operation), 0 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Class__ownedProperties = LIBRARY.createProperty(Types._Class, ClassesPackage.Literals.CLASS__OWNED_PROPERTIES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Property), 1 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Class__superClass = LIBRARY.createProperty(Types._Class, ClassesPackage.Literals.CLASS__SUPER_CLASS, Types._Class, 2 | IsResolveProxies);
		public static final @NonNull Property _Class__Class__superClass = LIBRARY.createOppositeProperty(Types._Class, "Class", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._Class), 3 | IsImplicit | IsRequired | IsResolveProxies, ClassesPackage.Literals.CLASS__SUPER_CLASS);
		public static final @NonNull Property _Class__Package__ownedClasses = LIBRARY.createOppositeProperty(Types._Class, "Package", Types._Package, 4 | IsImplicit | IsResolveProxies, ClassesPackage.Literals.PACKAGE__OWNED_CLASSES);
		public static final @NonNull Property _Class__TypedElement__type = LIBRARY.createOppositeProperty(Types._Class, "TypedElement", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._TypedElement), 5 | IsImplicit | IsRequired | IsResolveProxies, ClassesPackage.Literals.TYPED_ELEMENT__TYPE);

		public static final @NonNull Property _NamedElement__name = LIBRARY.createProperty(Types._NamedElement, ClassesPackage.Literals.NAMED_ELEMENT__NAME, OCLstdlibTables.Types._String, 0 | IsResolveProxies);

		public static final @NonNull Property _Operation__ownedExpressions = LIBRARY.createProperty(Types._Operation, ClassesPackage.Literals.OPERATION__OWNED_EXPRESSIONS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._CallExp), 0 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Operation__ownedParameters = LIBRARY.createProperty(Types._Operation, ClassesPackage.Literals.OPERATION__OWNED_PARAMETERS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Parameter), 1 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Operation__Class__ownedOperations = LIBRARY.createOppositeProperty(Types._Operation, "Class", Types._Class, 2 | IsImplicit | IsResolveProxies, ClassesPackage.Literals.CLASS__OWNED_OPERATIONS);
		public static final @NonNull Property _Operation__OperationCallExp__referredOperation = LIBRARY.createOppositeProperty(Types._Operation, "OperationCallExp", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._OperationCallExp), 3 | IsImplicit | IsRequired | IsResolveProxies, ClassesPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION);

		public static final @NonNull Property _OperationCallExp__ownedArguments = LIBRARY.createProperty(Types._OperationCallExp, ClassesPackage.Literals.OPERATION_CALL_EXP__OWNED_ARGUMENTS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Argument), 0 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _OperationCallExp__referredOperation = LIBRARY.createProperty(Types._OperationCallExp, ClassesPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION, Types._Operation, 1 | IsResolveProxies);

		public static final @NonNull Property _Package__ownedClasses = LIBRARY.createProperty(Types._Package, ClassesPackage.Literals.PACKAGE__OWNED_CLASSES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Class), 0 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Package__ownedPackages = LIBRARY.createProperty(Types._Package, ClassesPackage.Literals.PACKAGE__OWNED_PACKAGES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Package), 1 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _Package__Package__ownedPackages = LIBRARY.createOppositeProperty(Types._Package, "Package", Types._Package, 2 | IsImplicit | IsResolveProxies, ClassesPackage.Literals.PACKAGE__OWNED_PACKAGES);
		public static final @NonNull Property _Package__Root__ownedPackages = LIBRARY.createOppositeProperty(Types._Package, "Root", Types._Root, 3 | IsImplicit | IsResolveProxies, ClassesPackage.Literals.ROOT__OWNED_PACKAGES);

		public static final @NonNull Property _Parameter__Operation__ownedParameters = LIBRARY.createOppositeProperty(Types._Parameter, "Operation", Types._Operation, 0 | IsImplicit | IsResolveProxies, ClassesPackage.Literals.OPERATION__OWNED_PARAMETERS);

		public static final @NonNull Property _Property__Class__ownedProperties = LIBRARY.createOppositeProperty(Types._Property, "Class", Types._Class, 0 | IsImplicit | IsResolveProxies, ClassesPackage.Literals.CLASS__OWNED_PROPERTIES);
		public static final @NonNull Property _Property__PropertyCallExp__referredProperty = LIBRARY.createOppositeProperty(Types._Property, "PropertyCallExp", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._PropertyCallExp), 1 | IsImplicit | IsRequired | IsResolveProxies, ClassesPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY);

		public static final @NonNull Property _PropertyCallExp__referredProperty = LIBRARY.createProperty(Types._PropertyCallExp, ClassesPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, Types._Property, 0 | IsResolveProxies);

		public static final @NonNull Property _Root__ownedPackages = LIBRARY.createProperty(Types._Root, ClassesPackage.Literals.ROOT__OWNED_PACKAGES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._Package), 0 | IsComposite | IsRequired | IsResolveProxies);

		public static final @NonNull Property _TypedElement__type = LIBRARY.createProperty(Types._TypedElement, ClassesPackage.Literals.TYPED_ELEMENT__TYPE, Types._Class, 0 | IsResolveProxies);

		static {
			_Argument__OperationCallExp__ownedArguments.setOpposite(_OperationCallExp__ownedArguments);

			_CallExp__ownedCallExp.setOpposite(_CallExp__owningSource);
			_CallExp__owningSource.setOpposite(_CallExp__ownedCallExp);
			_CallExp__Operation__ownedExpressions.setOpposite(_Operation__ownedExpressions);

			_Class__ownedOperations.setOpposite(_Operation__Class__ownedOperations);
			_Class__ownedProperties.setOpposite(_Property__Class__ownedProperties);
			_Class__superClass.setOpposite(_Class__Class__superClass);
			_Class__Class__superClass.setOpposite(_Class__superClass);
			_Class__Package__ownedClasses.setOpposite(_Package__ownedClasses);
			_Class__TypedElement__type.setOpposite(_TypedElement__type);


			_Operation__ownedExpressions.setOpposite(_CallExp__Operation__ownedExpressions);
			_Operation__ownedParameters.setOpposite(_Parameter__Operation__ownedParameters);
			_Operation__Class__ownedOperations.setOpposite(_Class__ownedOperations);
			_Operation__OperationCallExp__referredOperation.setOpposite(_OperationCallExp__referredOperation);

			_OperationCallExp__ownedArguments.setOpposite(_Argument__OperationCallExp__ownedArguments);
			_OperationCallExp__referredOperation.setOpposite(_Operation__OperationCallExp__referredOperation);

			_Package__ownedClasses.setOpposite(_Class__Package__ownedClasses);
			_Package__ownedPackages.setOpposite(_Package__Package__ownedPackages);
			_Package__Package__ownedPackages.setOpposite(_Package__ownedPackages);
			_Package__Root__ownedPackages.setOpposite(_Root__ownedPackages);

			_Parameter__Operation__ownedParameters.setOpposite(_Operation__ownedParameters);

			_Property__Class__ownedProperties.setOpposite(_Class__ownedProperties);
			_Property__PropertyCallExp__referredProperty.setOpposite(_PropertyCallExp__referredProperty);

			_PropertyCallExp__referredProperty.setOpposite(_Property__PropertyCallExp__referredProperty);

			_Root__ownedPackages.setOpposite(_Package__Root__ownedPackages);

			_TypedElement__type.setOpposite(_Class__TypedElement__type);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ClassesTables::Properties and all preceding sub-packages.
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

		private static final @NonNull FlatFragment @NonNull [] _Argument =
			{
				Fragments._Argument__OclAny /* 0 */,
				Fragments._Argument__OclElement /* 1 */,
				Fragments._Argument__Visitable /* 2 */,
				Fragments._Argument__Element /* 3 */,
				Fragments._Argument__NamedElement /* 4 */,
				Fragments._Argument__Argument /* 5 */
			};
		private static final int @NonNull [] __Argument = { 1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _CallExp =
			{
				Fragments._CallExp__OclAny /* 0 */,
				Fragments._CallExp__OclElement /* 1 */,
				Fragments._CallExp__Visitable /* 2 */,
				Fragments._CallExp__Element /* 3 */,
				Fragments._CallExp__TypedElement /* 4 */,
				Fragments._CallExp__CallExp /* 5 */
			};
		private static final int @NonNull [] __CallExp = { 1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Class =
			{
				Fragments._Class__OclAny /* 0 */,
				Fragments._Class__OclElement /* 1 */,
				Fragments._Class__Visitable /* 2 */,
				Fragments._Class__Element /* 3 */,
				Fragments._Class__NamedElement /* 4 */,
				Fragments._Class__Class /* 5 */
			};
		private static final int @NonNull [] __Class = { 1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Element =
			{
				Fragments._Element__OclAny /* 0 */,
				Fragments._Element__OclElement /* 1 */,
				Fragments._Element__Visitable /* 2 */,
				Fragments._Element__Element /* 3 */
			};
		private static final int @NonNull [] __Element = { 1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _NamedElement =
			{
				Fragments._NamedElement__OclAny /* 0 */,
				Fragments._NamedElement__OclElement /* 1 */,
				Fragments._NamedElement__Visitable /* 2 */,
				Fragments._NamedElement__Element /* 3 */,
				Fragments._NamedElement__NamedElement /* 4 */
			};
		private static final int @NonNull [] __NamedElement = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Namespace =
			{
				Fragments._Namespace__OclAny /* 0 */,
				Fragments._Namespace__OclElement /* 1 */,
				Fragments._Namespace__Visitable /* 2 */,
				Fragments._Namespace__Element /* 3 */,
				Fragments._Namespace__Namespace /* 4 */
			};
		private static final int @NonNull [] __Namespace = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Operation =
			{
				Fragments._Operation__OclAny /* 0 */,
				Fragments._Operation__OclElement /* 1 */,
				Fragments._Operation__Visitable /* 2 */,
				Fragments._Operation__Element /* 3 */,
				Fragments._Operation__NamedElement /* 4 */,
				Fragments._Operation__TypedElement /* 4 */,
				Fragments._Operation__Operation /* 5 */
			};
		private static final int @NonNull [] __Operation = { 1,1,1,1,2,1 };

		private static final @NonNull FlatFragment @NonNull [] _OperationCallExp =
			{
				Fragments._OperationCallExp__OclAny /* 0 */,
				Fragments._OperationCallExp__OclElement /* 1 */,
				Fragments._OperationCallExp__Visitable /* 2 */,
				Fragments._OperationCallExp__Element /* 3 */,
				Fragments._OperationCallExp__TypedElement /* 4 */,
				Fragments._OperationCallExp__CallExp /* 5 */,
				Fragments._OperationCallExp__OperationCallExp /* 6 */
			};
		private static final int @NonNull [] __OperationCallExp = { 1,1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Package =
			{
				Fragments._Package__OclAny /* 0 */,
				Fragments._Package__OclElement /* 1 */,
				Fragments._Package__Visitable /* 2 */,
				Fragments._Package__Element /* 3 */,
				Fragments._Package__NamedElement /* 4 */,
				Fragments._Package__Namespace /* 4 */,
				Fragments._Package__Package /* 5 */
			};
		private static final int @NonNull [] __Package = { 1,1,1,1,2,1 };

		private static final @NonNull FlatFragment @NonNull [] _Parameter =
			{
				Fragments._Parameter__OclAny /* 0 */,
				Fragments._Parameter__OclElement /* 1 */,
				Fragments._Parameter__Visitable /* 2 */,
				Fragments._Parameter__Element /* 3 */,
				Fragments._Parameter__NamedElement /* 4 */,
				Fragments._Parameter__Parameter /* 5 */
			};
		private static final int @NonNull [] __Parameter = { 1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Property =
			{
				Fragments._Property__OclAny /* 0 */,
				Fragments._Property__OclElement /* 1 */,
				Fragments._Property__Visitable /* 2 */,
				Fragments._Property__Element /* 3 */,
				Fragments._Property__NamedElement /* 4 */,
				Fragments._Property__TypedElement /* 4 */,
				Fragments._Property__Property /* 5 */
			};
		private static final int @NonNull [] __Property = { 1,1,1,1,2,1 };

		private static final @NonNull FlatFragment @NonNull [] _PropertyCallExp =
			{
				Fragments._PropertyCallExp__OclAny /* 0 */,
				Fragments._PropertyCallExp__OclElement /* 1 */,
				Fragments._PropertyCallExp__Visitable /* 2 */,
				Fragments._PropertyCallExp__Element /* 3 */,
				Fragments._PropertyCallExp__TypedElement /* 4 */,
				Fragments._PropertyCallExp__CallExp /* 5 */,
				Fragments._PropertyCallExp__PropertyCallExp /* 6 */
			};
		private static final int @NonNull [] __PropertyCallExp = { 1,1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Root =
			{
				Fragments._Root__OclAny /* 0 */,
				Fragments._Root__OclElement /* 1 */,
				Fragments._Root__Visitable /* 2 */,
				Fragments._Root__Element /* 3 */,
				Fragments._Root__Root /* 4 */
			};
		private static final int @NonNull [] __Root = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _TypedElement =
			{
				Fragments._TypedElement__OclAny /* 0 */,
				Fragments._TypedElement__OclElement /* 1 */,
				Fragments._TypedElement__Visitable /* 2 */,
				Fragments._TypedElement__Element /* 3 */,
				Fragments._TypedElement__TypedElement /* 4 */
			};
		private static final int @NonNull [] __TypedElement = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Visitable =
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
			Types._Argument.initFragments(_Argument, __Argument);
			Types._CallExp.initFragments(_CallExp, __CallExp);
			Types._Class.initFragments(_Class, __Class);
			Types._Element.initFragments(_Element, __Element);
			Types._NamedElement.initFragments(_NamedElement, __NamedElement);
			Types._Namespace.initFragments(_Namespace, __Namespace);
			Types._Operation.initFragments(_Operation, __Operation);
			Types._OperationCallExp.initFragments(_OperationCallExp, __OperationCallExp);
			Types._Package.initFragments(_Package, __Package);
			Types._Parameter.initFragments(_Parameter, __Parameter);
			Types._Property.initFragments(_Property, __Property);
			Types._PropertyCallExp.initFragments(_PropertyCallExp, __PropertyCallExp);
			Types._Root.initFragments(_Root, __Root);
			Types._TypedElement.initFragments(_TypedElement, __TypedElement);
			Types._Visitable.initFragments(_Visitable, __Visitable);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ClassesTables::TypeFragments and all preceding sub-packages.
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

		private static final @NonNull Operation @NonNull [] _Argument__Argument = {};
		private static final @NonNull Operation @NonNull [] _Argument__Element = {};
		private static final @NonNull Operation @NonNull [] _Argument__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _Argument__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _Argument__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _Argument__Visitable = {};

		private static final @NonNull Operation @NonNull [] _CallExp__CallExp = {};
		private static final @NonNull Operation @NonNull [] _CallExp__Element = {};
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

		private static final @NonNull Operation @NonNull [] _Operation__Operation = {};
		private static final @NonNull Operation @NonNull [] _Operation__Element = {};
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
		private static final @NonNull Operation @NonNull [] _Parameter__Visitable = {};

		private static final @NonNull Operation @NonNull [] _Property__Property = {};
		private static final @NonNull Operation @NonNull [] _Property__Element = {};
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
			Fragments._Argument__Argument.initOperations(_Argument__Argument);
			Fragments._Argument__Element.initOperations(_Argument__Element);
			Fragments._Argument__NamedElement.initOperations(_Argument__NamedElement);
			Fragments._Argument__OclAny.initOperations(_Argument__OclAny);
			Fragments._Argument__OclElement.initOperations(_Argument__OclElement);
			Fragments._Argument__Visitable.initOperations(_Argument__Visitable);

			Fragments._CallExp__CallExp.initOperations(_CallExp__CallExp);
			Fragments._CallExp__Element.initOperations(_CallExp__Element);
			Fragments._CallExp__OclAny.initOperations(_CallExp__OclAny);
			Fragments._CallExp__OclElement.initOperations(_CallExp__OclElement);
			Fragments._CallExp__TypedElement.initOperations(_CallExp__TypedElement);
			Fragments._CallExp__Visitable.initOperations(_CallExp__Visitable);

			Fragments._Class__Class.initOperations(_Class__Class);
			Fragments._Class__Element.initOperations(_Class__Element);
			Fragments._Class__NamedElement.initOperations(_Class__NamedElement);
			Fragments._Class__OclAny.initOperations(_Class__OclAny);
			Fragments._Class__OclElement.initOperations(_Class__OclElement);
			Fragments._Class__Visitable.initOperations(_Class__Visitable);

			Fragments._Element__Element.initOperations(_Element__Element);
			Fragments._Element__OclAny.initOperations(_Element__OclAny);
			Fragments._Element__OclElement.initOperations(_Element__OclElement);
			Fragments._Element__Visitable.initOperations(_Element__Visitable);

			Fragments._NamedElement__Element.initOperations(_NamedElement__Element);
			Fragments._NamedElement__NamedElement.initOperations(_NamedElement__NamedElement);
			Fragments._NamedElement__OclAny.initOperations(_NamedElement__OclAny);
			Fragments._NamedElement__OclElement.initOperations(_NamedElement__OclElement);
			Fragments._NamedElement__Visitable.initOperations(_NamedElement__Visitable);

			Fragments._Namespace__Element.initOperations(_Namespace__Element);
			Fragments._Namespace__Namespace.initOperations(_Namespace__Namespace);
			Fragments._Namespace__OclAny.initOperations(_Namespace__OclAny);
			Fragments._Namespace__OclElement.initOperations(_Namespace__OclElement);
			Fragments._Namespace__Visitable.initOperations(_Namespace__Visitable);

			Fragments._Operation__Element.initOperations(_Operation__Element);
			Fragments._Operation__NamedElement.initOperations(_Operation__NamedElement);
			Fragments._Operation__OclAny.initOperations(_Operation__OclAny);
			Fragments._Operation__OclElement.initOperations(_Operation__OclElement);
			Fragments._Operation__Operation.initOperations(_Operation__Operation);
			Fragments._Operation__TypedElement.initOperations(_Operation__TypedElement);
			Fragments._Operation__Visitable.initOperations(_Operation__Visitable);

			Fragments._OperationCallExp__CallExp.initOperations(_OperationCallExp__CallExp);
			Fragments._OperationCallExp__Element.initOperations(_OperationCallExp__Element);
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
			Fragments._Parameter__Visitable.initOperations(_Parameter__Visitable);

			Fragments._Property__Element.initOperations(_Property__Element);
			Fragments._Property__NamedElement.initOperations(_Property__NamedElement);
			Fragments._Property__OclAny.initOperations(_Property__OclAny);
			Fragments._Property__OclElement.initOperations(_Property__OclElement);
			Fragments._Property__Property.initOperations(_Property__Property);
			Fragments._Property__TypedElement.initOperations(_Property__TypedElement);
			Fragments._Property__Visitable.initOperations(_Property__Visitable);

			Fragments._PropertyCallExp__CallExp.initOperations(_PropertyCallExp__CallExp);
			Fragments._PropertyCallExp__Element.initOperations(_PropertyCallExp__Element);
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

			Fragments._Visitable__OclAny.initOperations(_Visitable__OclAny);
			Fragments._Visitable__OclElement.initOperations(_Visitable__OclElement);
			Fragments._Visitable__Visitable.initOperations(_Visitable__Visitable);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ClassesTables::FragmentOperations and all preceding sub-packages.
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

		private static final @NonNull Property @NonNull [] _Argument = {
			Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _CallExp = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._CallExp__ownedCallExp,
			Properties._CallExp__owningSource,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _Class = {
			Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Class__ownedOperations,
			Properties._Class__ownedProperties,
			Properties._Class__superClass
		};

		private static final @NonNull Property @NonNull [] _Element = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _NamedElement = {
			Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _Namespace = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _Operation = {
			Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Operation__ownedExpressions,
			Properties._Operation__ownedParameters,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _OperationCallExp = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._OperationCallExp__ownedArguments,
			Properties._CallExp__ownedCallExp,
			Properties._CallExp__owningSource,
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
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _Property = {
			Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _PropertyCallExp = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._CallExp__ownedCallExp,
			Properties._CallExp__owningSource,
			Properties._PropertyCallExp__referredProperty,
			Properties._TypedElement__type
		};

		private static final @NonNull Property @NonNull [] _Root = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._Root__ownedPackages
		};

		private static final @NonNull Property @NonNull [] _TypedElement = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
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
			Fragments._Argument__Argument.initProperties(_Argument);
			Fragments._CallExp__CallExp.initProperties(_CallExp);
			Fragments._Class__Class.initProperties(_Class);
			Fragments._Element__Element.initProperties(_Element);
			Fragments._NamedElement__NamedElement.initProperties(_NamedElement);
			Fragments._Namespace__Namespace.initProperties(_Namespace);
			Fragments._Operation__Operation.initProperties(_Operation);
			Fragments._OperationCallExp__OperationCallExp.initProperties(_OperationCallExp);
			Fragments._Package__Package.initProperties(_Package);
			Fragments._Parameter__Parameter.initProperties(_Parameter);
			Fragments._Property__Property.initProperties(_Property);
			Fragments._PropertyCallExp__PropertyCallExp.initProperties(_PropertyCallExp);
			Fragments._Root__Root.initProperties(_Root);
			Fragments._TypedElement__TypedElement.initProperties(_TypedElement);
			Fragments._Visitable__Visitable.initProperties(_Visitable);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ClassesTables::FragmentProperties and all preceding sub-packages.
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

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ClassesTables::EnumerationLiterals and all preceding sub-packages.
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
		new ClassesTables();
	}

	private ClassesTables() {
		super(ClassesPackage.eNS_URI);
	}
}
