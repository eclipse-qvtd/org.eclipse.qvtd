/*******************************************************************************
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 *   /org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/cs2as/compiler/tests/models/example2/Classes.ecore
 * using:
 *   /org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/cs2as/compiler/tests/models/example2/Classes.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package example2.classes;

import example2.classes.ClassesTables;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreLibraryOppositeProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorFragment;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorOperation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorPropertyWithImplementation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;

/**
 * ClassesTables provides the dispatch tables for the classes for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
@SuppressWarnings("nls")
public class ClassesTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final @NonNull EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(ClassesPackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final @NonNull ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0 = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://cs2as/tests/example2/classes/1.0", null, example2.classes.ClassesPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Argument = example2.classes.ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Argument", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_CallExp = example2.classes.ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("CallExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = example2.classes.ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Operation = example2.classes.ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Operation", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OperationCallExp = example2.classes.ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("OperationCallExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Package = example2.classes.ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Package", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Parameter = example2.classes.ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Parameter", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Property = example2.classes.ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Property", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PropertyCallExp = example2.classes.ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("PropertyCallExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Root = example2.classes.ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Root", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TypedElement = example2.classes.ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("TypedElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_Class = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(example2.classes.ClassesTables.CLSSid_Class);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_OperationCallExp = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(example2.classes.ClassesTables.CLSSid_OperationCallExp);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_PropertyCallExp = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(example2.classes.ClassesTables.CLSSid_PropertyCallExp);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_TypedElement = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(example2.classes.ClassesTables.CLSSid_TypedElement);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Argument = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(example2.classes.ClassesTables.CLSSid_Argument);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_CallExp = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(example2.classes.ClassesTables.CLSSid_CallExp);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Class = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(example2.classes.ClassesTables.CLSSid_Class);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Operation = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(example2.classes.ClassesTables.CLSSid_Operation);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Package = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(example2.classes.ClassesTables.CLSSid_Package);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Parameter = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(example2.classes.ClassesTables.CLSSid_Parameter);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Property = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(example2.classes.ClassesTables.CLSSid_Property);

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

		public static final @NonNull EcoreExecutorType _Argument = new EcoreExecutorType(ClassesPackage.Literals.ARGUMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CallExp = new EcoreExecutorType(ClassesPackage.Literals.CALL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Class = new EcoreExecutorType(ClassesPackage.Literals.CLASS, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Element = new EcoreExecutorType(ClassesPackage.Literals.ELEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _NamedElement = new EcoreExecutorType(ClassesPackage.Literals.NAMED_ELEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Namespace = new EcoreExecutorType(ClassesPackage.Literals.NAMESPACE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Operation = new EcoreExecutorType(ClassesPackage.Literals.OPERATION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OperationCallExp = new EcoreExecutorType(ClassesPackage.Literals.OPERATION_CALL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Package = new EcoreExecutorType(ClassesPackage.Literals.PACKAGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Parameter = new EcoreExecutorType(ClassesPackage.Literals.PARAMETER, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Property = new EcoreExecutorType(ClassesPackage.Literals.PROPERTY, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _PropertyCallExp = new EcoreExecutorType(ClassesPackage.Literals.PROPERTY_CALL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Root = new EcoreExecutorType(ClassesPackage.Literals.ROOT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TypedElement = new EcoreExecutorType(ClassesPackage.Literals.TYPED_ELEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Visitable = new EcoreExecutorType(ClassesPackage.Literals.VISITABLE, PACKAGE, 0);

		private static final @NonNull EcoreExecutorType @NonNull [] types = {
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
			PACKAGE.init(LIBRARY, types);
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

		private static final @NonNull ExecutorFragment _Argument__Argument = new ExecutorFragment(Types._Argument, ClassesTables.Types._Argument);
		private static final @NonNull ExecutorFragment _Argument__Element = new ExecutorFragment(Types._Argument, ClassesTables.Types._Element);
		private static final @NonNull ExecutorFragment _Argument__NamedElement = new ExecutorFragment(Types._Argument, ClassesTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Argument__OclAny = new ExecutorFragment(Types._Argument, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Argument__OclElement = new ExecutorFragment(Types._Argument, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Argument__Visitable = new ExecutorFragment(Types._Argument, ClassesTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _CallExp__CallExp = new ExecutorFragment(Types._CallExp, ClassesTables.Types._CallExp);
		private static final @NonNull ExecutorFragment _CallExp__Element = new ExecutorFragment(Types._CallExp, ClassesTables.Types._Element);
		private static final @NonNull ExecutorFragment _CallExp__OclAny = new ExecutorFragment(Types._CallExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _CallExp__OclElement = new ExecutorFragment(Types._CallExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _CallExp__TypedElement = new ExecutorFragment(Types._CallExp, ClassesTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _CallExp__Visitable = new ExecutorFragment(Types._CallExp, ClassesTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Class__Class = new ExecutorFragment(Types._Class, ClassesTables.Types._Class);
		private static final @NonNull ExecutorFragment _Class__Element = new ExecutorFragment(Types._Class, ClassesTables.Types._Element);
		private static final @NonNull ExecutorFragment _Class__NamedElement = new ExecutorFragment(Types._Class, ClassesTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Class__OclAny = new ExecutorFragment(Types._Class, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Class__OclElement = new ExecutorFragment(Types._Class, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Class__Visitable = new ExecutorFragment(Types._Class, ClassesTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Element__Element = new ExecutorFragment(Types._Element, ClassesTables.Types._Element);
		private static final @NonNull ExecutorFragment _Element__OclAny = new ExecutorFragment(Types._Element, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Element__OclElement = new ExecutorFragment(Types._Element, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Element__Visitable = new ExecutorFragment(Types._Element, ClassesTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _NamedElement__Element = new ExecutorFragment(Types._NamedElement, ClassesTables.Types._Element);
		private static final @NonNull ExecutorFragment _NamedElement__NamedElement = new ExecutorFragment(Types._NamedElement, ClassesTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _NamedElement__OclAny = new ExecutorFragment(Types._NamedElement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NamedElement__OclElement = new ExecutorFragment(Types._NamedElement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _NamedElement__Visitable = new ExecutorFragment(Types._NamedElement, ClassesTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Namespace__Element = new ExecutorFragment(Types._Namespace, ClassesTables.Types._Element);
		private static final @NonNull ExecutorFragment _Namespace__Namespace = new ExecutorFragment(Types._Namespace, ClassesTables.Types._Namespace);
		private static final @NonNull ExecutorFragment _Namespace__OclAny = new ExecutorFragment(Types._Namespace, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Namespace__OclElement = new ExecutorFragment(Types._Namespace, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Namespace__Visitable = new ExecutorFragment(Types._Namespace, ClassesTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Operation__Element = new ExecutorFragment(Types._Operation, ClassesTables.Types._Element);
		private static final @NonNull ExecutorFragment _Operation__NamedElement = new ExecutorFragment(Types._Operation, ClassesTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Operation__OclAny = new ExecutorFragment(Types._Operation, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Operation__OclElement = new ExecutorFragment(Types._Operation, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Operation__Operation = new ExecutorFragment(Types._Operation, ClassesTables.Types._Operation);
		private static final @NonNull ExecutorFragment _Operation__TypedElement = new ExecutorFragment(Types._Operation, ClassesTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _Operation__Visitable = new ExecutorFragment(Types._Operation, ClassesTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _OperationCallExp__CallExp = new ExecutorFragment(Types._OperationCallExp, ClassesTables.Types._CallExp);
		private static final @NonNull ExecutorFragment _OperationCallExp__Element = new ExecutorFragment(Types._OperationCallExp, ClassesTables.Types._Element);
		private static final @NonNull ExecutorFragment _OperationCallExp__OclAny = new ExecutorFragment(Types._OperationCallExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OperationCallExp__OclElement = new ExecutorFragment(Types._OperationCallExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _OperationCallExp__OperationCallExp = new ExecutorFragment(Types._OperationCallExp, ClassesTables.Types._OperationCallExp);
		private static final @NonNull ExecutorFragment _OperationCallExp__TypedElement = new ExecutorFragment(Types._OperationCallExp, ClassesTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _OperationCallExp__Visitable = new ExecutorFragment(Types._OperationCallExp, ClassesTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Package__Element = new ExecutorFragment(Types._Package, ClassesTables.Types._Element);
		private static final @NonNull ExecutorFragment _Package__NamedElement = new ExecutorFragment(Types._Package, ClassesTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Package__Namespace = new ExecutorFragment(Types._Package, ClassesTables.Types._Namespace);
		private static final @NonNull ExecutorFragment _Package__OclAny = new ExecutorFragment(Types._Package, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Package__OclElement = new ExecutorFragment(Types._Package, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Package__Package = new ExecutorFragment(Types._Package, ClassesTables.Types._Package);
		private static final @NonNull ExecutorFragment _Package__Visitable = new ExecutorFragment(Types._Package, ClassesTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Parameter__Element = new ExecutorFragment(Types._Parameter, ClassesTables.Types._Element);
		private static final @NonNull ExecutorFragment _Parameter__NamedElement = new ExecutorFragment(Types._Parameter, ClassesTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Parameter__OclAny = new ExecutorFragment(Types._Parameter, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Parameter__OclElement = new ExecutorFragment(Types._Parameter, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Parameter__Parameter = new ExecutorFragment(Types._Parameter, ClassesTables.Types._Parameter);
		private static final @NonNull ExecutorFragment _Parameter__Visitable = new ExecutorFragment(Types._Parameter, ClassesTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Property__Element = new ExecutorFragment(Types._Property, ClassesTables.Types._Element);
		private static final @NonNull ExecutorFragment _Property__NamedElement = new ExecutorFragment(Types._Property, ClassesTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Property__OclAny = new ExecutorFragment(Types._Property, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Property__OclElement = new ExecutorFragment(Types._Property, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Property__Property = new ExecutorFragment(Types._Property, ClassesTables.Types._Property);
		private static final @NonNull ExecutorFragment _Property__TypedElement = new ExecutorFragment(Types._Property, ClassesTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _Property__Visitable = new ExecutorFragment(Types._Property, ClassesTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _PropertyCallExp__CallExp = new ExecutorFragment(Types._PropertyCallExp, ClassesTables.Types._CallExp);
		private static final @NonNull ExecutorFragment _PropertyCallExp__Element = new ExecutorFragment(Types._PropertyCallExp, ClassesTables.Types._Element);
		private static final @NonNull ExecutorFragment _PropertyCallExp__OclAny = new ExecutorFragment(Types._PropertyCallExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _PropertyCallExp__OclElement = new ExecutorFragment(Types._PropertyCallExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _PropertyCallExp__PropertyCallExp = new ExecutorFragment(Types._PropertyCallExp, ClassesTables.Types._PropertyCallExp);
		private static final @NonNull ExecutorFragment _PropertyCallExp__TypedElement = new ExecutorFragment(Types._PropertyCallExp, ClassesTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _PropertyCallExp__Visitable = new ExecutorFragment(Types._PropertyCallExp, ClassesTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Root__Element = new ExecutorFragment(Types._Root, ClassesTables.Types._Element);
		private static final @NonNull ExecutorFragment _Root__OclAny = new ExecutorFragment(Types._Root, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Root__OclElement = new ExecutorFragment(Types._Root, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Root__Root = new ExecutorFragment(Types._Root, ClassesTables.Types._Root);
		private static final @NonNull ExecutorFragment _Root__Visitable = new ExecutorFragment(Types._Root, ClassesTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _TypedElement__Element = new ExecutorFragment(Types._TypedElement, ClassesTables.Types._Element);
		private static final @NonNull ExecutorFragment _TypedElement__OclAny = new ExecutorFragment(Types._TypedElement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _TypedElement__OclElement = new ExecutorFragment(Types._TypedElement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _TypedElement__TypedElement = new ExecutorFragment(Types._TypedElement, ClassesTables.Types._TypedElement);
		private static final @NonNull ExecutorFragment _TypedElement__Visitable = new ExecutorFragment(Types._TypedElement, ClassesTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Visitable__OclAny = new ExecutorFragment(Types._Visitable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Visitable__OclElement = new ExecutorFragment(Types._Visitable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Visitable__Visitable = new ExecutorFragment(Types._Visitable, ClassesTables.Types._Visitable);

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
	 */
	public static class Properties {
		static {
			Init.initStart();
			Operations.init();
		}

		public static final @NonNull ExecutorProperty _Argument__OperationCallExp__ownedArguments = new ExecutorPropertyWithImplementation("OperationCallExp", Types._Argument, 0, new EcoreLibraryOppositeProperty(ClassesPackage.Literals.OPERATION_CALL_EXP__OWNED_ARGUMENTS));

		public static final @NonNull ExecutorProperty _CallExp__ownedCallExp = new EcoreExecutorProperty(ClassesPackage.Literals.CALL_EXP__OWNED_CALL_EXP, Types._CallExp, 0);
		public static final @NonNull ExecutorProperty _CallExp__owningSource = new EcoreExecutorProperty(ClassesPackage.Literals.CALL_EXP__OWNING_SOURCE, Types._CallExp, 1);
		public static final @NonNull ExecutorProperty _CallExp__Operation__ownedExpressions = new ExecutorPropertyWithImplementation("Operation", Types._CallExp, 2, new EcoreLibraryOppositeProperty(ClassesPackage.Literals.OPERATION__OWNED_EXPRESSIONS));

		public static final @NonNull ExecutorProperty _Class__ownedOperations = new EcoreExecutorProperty(ClassesPackage.Literals.CLASS__OWNED_OPERATIONS, Types._Class, 0);
		public static final @NonNull ExecutorProperty _Class__ownedProperties = new EcoreExecutorProperty(ClassesPackage.Literals.CLASS__OWNED_PROPERTIES, Types._Class, 1);
		public static final @NonNull ExecutorProperty _Class__superClass = new EcoreExecutorProperty(ClassesPackage.Literals.CLASS__SUPER_CLASS, Types._Class, 2);
		public static final @NonNull ExecutorProperty _Class__Class__superClass = new ExecutorPropertyWithImplementation("Class", Types._Class, 3, new EcoreLibraryOppositeProperty(ClassesPackage.Literals.CLASS__SUPER_CLASS));
		public static final @NonNull ExecutorProperty _Class__Package__ownedClasses = new ExecutorPropertyWithImplementation("Package", Types._Class, 4, new EcoreLibraryOppositeProperty(ClassesPackage.Literals.PACKAGE__OWNED_CLASSES));
		public static final @NonNull ExecutorProperty _Class__TypedElement__type = new ExecutorPropertyWithImplementation("TypedElement", Types._Class, 5, new EcoreLibraryOppositeProperty(ClassesPackage.Literals.TYPED_ELEMENT__TYPE));

		public static final @NonNull ExecutorProperty _NamedElement__name = new EcoreExecutorProperty(ClassesPackage.Literals.NAMED_ELEMENT__NAME, Types._NamedElement, 0);

		public static final @NonNull ExecutorProperty _Operation__ownedExpressions = new EcoreExecutorProperty(ClassesPackage.Literals.OPERATION__OWNED_EXPRESSIONS, Types._Operation, 0);
		public static final @NonNull ExecutorProperty _Operation__ownedParameters = new EcoreExecutorProperty(ClassesPackage.Literals.OPERATION__OWNED_PARAMETERS, Types._Operation, 1);
		public static final @NonNull ExecutorProperty _Operation__Class__ownedOperations = new ExecutorPropertyWithImplementation("Class", Types._Operation, 2, new EcoreLibraryOppositeProperty(ClassesPackage.Literals.CLASS__OWNED_OPERATIONS));
		public static final @NonNull ExecutorProperty _Operation__OperationCallExp__referredOperation = new ExecutorPropertyWithImplementation("OperationCallExp", Types._Operation, 3, new EcoreLibraryOppositeProperty(ClassesPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION));

		public static final @NonNull ExecutorProperty _OperationCallExp__ownedArguments = new EcoreExecutorProperty(ClassesPackage.Literals.OPERATION_CALL_EXP__OWNED_ARGUMENTS, Types._OperationCallExp, 0);
		public static final @NonNull ExecutorProperty _OperationCallExp__referredOperation = new EcoreExecutorProperty(ClassesPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION, Types._OperationCallExp, 1);

		public static final @NonNull ExecutorProperty _Package__ownedClasses = new EcoreExecutorProperty(ClassesPackage.Literals.PACKAGE__OWNED_CLASSES, Types._Package, 0);
		public static final @NonNull ExecutorProperty _Package__ownedPackages = new EcoreExecutorProperty(ClassesPackage.Literals.PACKAGE__OWNED_PACKAGES, Types._Package, 1);
		public static final @NonNull ExecutorProperty _Package__Package__ownedPackages = new ExecutorPropertyWithImplementation("Package", Types._Package, 2, new EcoreLibraryOppositeProperty(ClassesPackage.Literals.PACKAGE__OWNED_PACKAGES));
		public static final @NonNull ExecutorProperty _Package__Root__ownedPackages = new ExecutorPropertyWithImplementation("Root", Types._Package, 3, new EcoreLibraryOppositeProperty(ClassesPackage.Literals.ROOT__OWNED_PACKAGES));

		public static final @NonNull ExecutorProperty _Parameter__Operation__ownedParameters = new ExecutorPropertyWithImplementation("Operation", Types._Parameter, 0, new EcoreLibraryOppositeProperty(ClassesPackage.Literals.OPERATION__OWNED_PARAMETERS));

		public static final @NonNull ExecutorProperty _Property__Class__ownedProperties = new ExecutorPropertyWithImplementation("Class", Types._Property, 0, new EcoreLibraryOppositeProperty(ClassesPackage.Literals.CLASS__OWNED_PROPERTIES));
		public static final @NonNull ExecutorProperty _Property__PropertyCallExp__referredProperty = new ExecutorPropertyWithImplementation("PropertyCallExp", Types._Property, 1, new EcoreLibraryOppositeProperty(ClassesPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY));

		public static final @NonNull ExecutorProperty _PropertyCallExp__referredProperty = new EcoreExecutorProperty(ClassesPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, Types._PropertyCallExp, 0);

		public static final @NonNull ExecutorProperty _Root__ownedPackages = new EcoreExecutorProperty(ClassesPackage.Literals.ROOT__OWNED_PACKAGES, Types._Root, 0);

		public static final @NonNull ExecutorProperty _TypedElement__type = new EcoreExecutorProperty(ClassesPackage.Literals.TYPED_ELEMENT__TYPE, Types._TypedElement, 0);
		static {
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

		private static final @NonNull ExecutorFragment @NonNull [] _Argument =
		{
			Fragments._Argument__OclAny /* 0 */,
			Fragments._Argument__OclElement /* 1 */,
			Fragments._Argument__Visitable /* 2 */,
			Fragments._Argument__Element /* 3 */,
			Fragments._Argument__NamedElement /* 4 */,
			Fragments._Argument__Argument /* 5 */
		};
		private static final int @NonNull [] __Argument = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _CallExp =
		{
			Fragments._CallExp__OclAny /* 0 */,
			Fragments._CallExp__OclElement /* 1 */,
			Fragments._CallExp__Visitable /* 2 */,
			Fragments._CallExp__Element /* 3 */,
			Fragments._CallExp__TypedElement /* 4 */,
			Fragments._CallExp__CallExp /* 5 */
		};
		private static final int @NonNull [] __CallExp = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Class =
		{
			Fragments._Class__OclAny /* 0 */,
			Fragments._Class__OclElement /* 1 */,
			Fragments._Class__Visitable /* 2 */,
			Fragments._Class__Element /* 3 */,
			Fragments._Class__NamedElement /* 4 */,
			Fragments._Class__Class /* 5 */
		};
		private static final int @NonNull [] __Class = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Element =
		{
			Fragments._Element__OclAny /* 0 */,
			Fragments._Element__OclElement /* 1 */,
			Fragments._Element__Visitable /* 2 */,
			Fragments._Element__Element /* 3 */
		};
		private static final int @NonNull [] __Element = { 1,1,1,1 };

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
			Fragments._Namespace__Namespace /* 4 */
		};
		private static final int @NonNull [] __Namespace = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Operation =
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

		private static final @NonNull ExecutorFragment @NonNull [] _OperationCallExp =
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

		private static final @NonNull ExecutorFragment @NonNull [] _Package =
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

		private static final @NonNull ExecutorFragment @NonNull [] _Parameter =
		{
			Fragments._Parameter__OclAny /* 0 */,
			Fragments._Parameter__OclElement /* 1 */,
			Fragments._Parameter__Visitable /* 2 */,
			Fragments._Parameter__Element /* 3 */,
			Fragments._Parameter__NamedElement /* 4 */,
			Fragments._Parameter__Parameter /* 5 */
		};
		private static final int @NonNull [] __Parameter = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Property =
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

		private static final @NonNull ExecutorFragment @NonNull [] _PropertyCallExp =
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

		private static final @NonNull ExecutorOperation @NonNull [] _Argument__Argument = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Argument__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Argument__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Argument__OclAny = {
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
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Argument__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Argument__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _CallExp__CallExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CallExp__Element = {};
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
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CallExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CallExp__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CallExp__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Class__Class = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Class__Element = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Class__NamedElement = {};
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
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Class__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Class__Visitable = {};

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
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Element__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Element__Visitable = {};

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
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedElement__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Namespace__Namespace = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Namespace__Element = {};
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
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Namespace__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Namespace__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Operation__Operation = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Operation__Element = {};
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
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Operation__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Operation__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Operation__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallExp__OperationCallExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallExp__CallExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallExp__Element = {};
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
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationCallExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
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
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Package__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
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
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Parameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Parameter__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Property__Property = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Property__Element = {};
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
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Property__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Property__TypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Property__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _PropertyCallExp__PropertyCallExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyCallExp__CallExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyCallExp__Element = {};
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
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyCallExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
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
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Root__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
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
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TypedElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TypedElement__Visitable = {};

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
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Visitable__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
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

		private static final @NonNull ExecutorProperty @NonNull [] _Argument = {
			ClassesTables.Properties._NamedElement__name,
			ClassesTables.Properties._Argument__OperationCallExp__ownedArguments
		};

		private static final @NonNull ExecutorProperty @NonNull [] _CallExp = {
			ClassesTables.Properties._CallExp__ownedCallExp,
			ClassesTables.Properties._CallExp__owningSource,
			ClassesTables.Properties._TypedElement__type,
			ClassesTables.Properties._CallExp__Operation__ownedExpressions
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Class = {
			ClassesTables.Properties._NamedElement__name,
			ClassesTables.Properties._Class__ownedOperations,
			ClassesTables.Properties._Class__ownedProperties,
			ClassesTables.Properties._Class__superClass,
			ClassesTables.Properties._Class__Class__superClass,
			ClassesTables.Properties._Class__Package__ownedClasses,
			ClassesTables.Properties._Class__TypedElement__type
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Element = {};

		private static final @NonNull ExecutorProperty @NonNull [] _NamedElement = {
			ClassesTables.Properties._NamedElement__name
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Namespace = {};

		private static final @NonNull ExecutorProperty @NonNull [] _Operation = {
			ClassesTables.Properties._NamedElement__name,
			ClassesTables.Properties._Operation__ownedExpressions,
			ClassesTables.Properties._Operation__ownedParameters,
			ClassesTables.Properties._TypedElement__type,
			ClassesTables.Properties._Operation__Class__ownedOperations,
			ClassesTables.Properties._Operation__OperationCallExp__referredOperation
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OperationCallExp = {
			ClassesTables.Properties._OperationCallExp__ownedArguments,
			ClassesTables.Properties._CallExp__ownedCallExp,
			ClassesTables.Properties._CallExp__owningSource,
			ClassesTables.Properties._OperationCallExp__referredOperation,
			ClassesTables.Properties._TypedElement__type,
			ClassesTables.Properties._CallExp__Operation__ownedExpressions
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Package = {
			ClassesTables.Properties._NamedElement__name,
			ClassesTables.Properties._Package__ownedClasses,
			ClassesTables.Properties._Package__ownedPackages,
			ClassesTables.Properties._Package__Package__ownedPackages,
			ClassesTables.Properties._Package__Root__ownedPackages
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Parameter = {
			ClassesTables.Properties._NamedElement__name,
			ClassesTables.Properties._Parameter__Operation__ownedParameters
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Property = {
			ClassesTables.Properties._NamedElement__name,
			ClassesTables.Properties._TypedElement__type,
			ClassesTables.Properties._Property__Class__ownedProperties,
			ClassesTables.Properties._Property__PropertyCallExp__referredProperty
		};

		private static final @NonNull ExecutorProperty @NonNull [] _PropertyCallExp = {
			ClassesTables.Properties._CallExp__ownedCallExp,
			ClassesTables.Properties._CallExp__owningSource,
			ClassesTables.Properties._PropertyCallExp__referredProperty,
			ClassesTables.Properties._TypedElement__type,
			ClassesTables.Properties._CallExp__Operation__ownedExpressions
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Root = {
			ClassesTables.Properties._Root__ownedPackages
		};

		private static final @NonNull ExecutorProperty @NonNull [] _TypedElement = {
			ClassesTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Visitable = {};

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
