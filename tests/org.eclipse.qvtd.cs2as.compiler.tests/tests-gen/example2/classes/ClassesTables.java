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

import example2.classes.ClassesPackage;
import example2.classes.ClassesTables;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
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
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classes/1.0", null, ClassesPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class = ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Package = ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Package", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Root = ClassesTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Root", 0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_Class = TypeId.BAG.getSpecializedId(ClassesTables.CLSSid_Class);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Class = TypeId.ORDERED_SET.getSpecializedId(ClassesTables.CLSSid_Class);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Package = TypeId.ORDERED_SET.getSpecializedId(ClassesTables.CLSSid_Package);

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

		public static final @NonNull EcoreExecutorType _Class = new EcoreExecutorType(ClassesPackage.Literals.CLASS, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Element = new EcoreExecutorType(ClassesPackage.Literals.ELEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _NamedElement = new EcoreExecutorType(ClassesPackage.Literals.NAMED_ELEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Namespace = new EcoreExecutorType(ClassesPackage.Literals.NAMESPACE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Package = new EcoreExecutorType(ClassesPackage.Literals.PACKAGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Root = new EcoreExecutorType(ClassesPackage.Literals.ROOT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Visitable = new EcoreExecutorType(ClassesPackage.Literals.VISITABLE, PACKAGE, 0);

		private static final @NonNull EcoreExecutorType[] types = {
			_Class,
			_Element,
			_NamedElement,
			_Namespace,
			_Package,
			_Root,
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

		private static final @NonNull ExecutorFragment _Package__Element = new ExecutorFragment(Types._Package, ClassesTables.Types._Element);
		private static final @NonNull ExecutorFragment _Package__NamedElement = new ExecutorFragment(Types._Package, ClassesTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _Package__Namespace = new ExecutorFragment(Types._Package, ClassesTables.Types._Namespace);
		private static final @NonNull ExecutorFragment _Package__OclAny = new ExecutorFragment(Types._Package, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Package__OclElement = new ExecutorFragment(Types._Package, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Package__Package = new ExecutorFragment(Types._Package, ClassesTables.Types._Package);
		private static final @NonNull ExecutorFragment _Package__Visitable = new ExecutorFragment(Types._Package, ClassesTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Root__Element = new ExecutorFragment(Types._Root, ClassesTables.Types._Element);
		private static final @NonNull ExecutorFragment _Root__OclAny = new ExecutorFragment(Types._Root, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Root__OclElement = new ExecutorFragment(Types._Root, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Root__Root = new ExecutorFragment(Types._Root, ClassesTables.Types._Root);
		private static final @NonNull ExecutorFragment _Root__Visitable = new ExecutorFragment(Types._Root, ClassesTables.Types._Visitable);

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

		public static final @NonNull ExecutorProperty _Class__superClass = new EcoreExecutorProperty(ClassesPackage.Literals.CLASS__SUPER_CLASS, Types._Class, 0);
		public static final @NonNull ExecutorProperty _Class__Class__superClass = new ExecutorPropertyWithImplementation("Class", Types._Class, 1, new EcoreLibraryOppositeProperty(ClassesPackage.Literals.CLASS__SUPER_CLASS));
		public static final @NonNull ExecutorProperty _Class__Package__ownedClasses = new ExecutorPropertyWithImplementation("Package", Types._Class, 2, new EcoreLibraryOppositeProperty(ClassesPackage.Literals.PACKAGE__OWNED_CLASSES));

		public static final @NonNull ExecutorProperty _NamedElement__name = new EcoreExecutorProperty(ClassesPackage.Literals.NAMED_ELEMENT__NAME, Types._NamedElement, 0);

		public static final @NonNull ExecutorProperty _Package__ownedClasses = new EcoreExecutorProperty(ClassesPackage.Literals.PACKAGE__OWNED_CLASSES, Types._Package, 0);
		public static final @NonNull ExecutorProperty _Package__ownedPackages = new EcoreExecutorProperty(ClassesPackage.Literals.PACKAGE__OWNED_PACKAGES, Types._Package, 1);
		public static final @NonNull ExecutorProperty _Package__Package__ownedPackages = new ExecutorPropertyWithImplementation("Package", Types._Package, 2, new EcoreLibraryOppositeProperty(ClassesPackage.Literals.PACKAGE__OWNED_PACKAGES));
		public static final @NonNull ExecutorProperty _Package__Root__ownedPackages = new ExecutorPropertyWithImplementation("Root", Types._Package, 3, new EcoreLibraryOppositeProperty(ClassesPackage.Literals.ROOT__OWNED_PACKAGES));

		public static final @NonNull ExecutorProperty _Root__ownedPackages = new EcoreExecutorProperty(ClassesPackage.Literals.ROOT__OWNED_PACKAGES, Types._Root, 0);
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

		private static final @NonNull ExecutorFragment[] _Class =
		{
			Fragments._Class__OclAny /* 0 */,
			Fragments._Class__OclElement /* 1 */,
			Fragments._Class__Visitable /* 2 */,
			Fragments._Class__Element /* 3 */,
			Fragments._Class__NamedElement /* 4 */,
			Fragments._Class__Class /* 5 */
		};
		private static final @NonNull int[] __Class = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Element =
		{
			Fragments._Element__OclAny /* 0 */,
			Fragments._Element__OclElement /* 1 */,
			Fragments._Element__Visitable /* 2 */,
			Fragments._Element__Element /* 3 */
		};
		private static final @NonNull int[] __Element = { 1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _NamedElement =
		{
			Fragments._NamedElement__OclAny /* 0 */,
			Fragments._NamedElement__OclElement /* 1 */,
			Fragments._NamedElement__Visitable /* 2 */,
			Fragments._NamedElement__Element /* 3 */,
			Fragments._NamedElement__NamedElement /* 4 */
		};
		private static final @NonNull int[] __NamedElement = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Namespace =
		{
			Fragments._Namespace__OclAny /* 0 */,
			Fragments._Namespace__OclElement /* 1 */,
			Fragments._Namespace__Visitable /* 2 */,
			Fragments._Namespace__Element /* 3 */,
			Fragments._Namespace__Namespace /* 4 */
		};
		private static final @NonNull int[] __Namespace = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Package =
		{
			Fragments._Package__OclAny /* 0 */,
			Fragments._Package__OclElement /* 1 */,
			Fragments._Package__Visitable /* 2 */,
			Fragments._Package__Element /* 3 */,
			Fragments._Package__NamedElement /* 4 */,
			Fragments._Package__Namespace /* 4 */,
			Fragments._Package__Package /* 5 */
		};
		private static final @NonNull int[] __Package = { 1,1,1,1,2,1 };

		private static final @NonNull ExecutorFragment[] _Root =
		{
			Fragments._Root__OclAny /* 0 */,
			Fragments._Root__OclElement /* 1 */,
			Fragments._Root__Visitable /* 2 */,
			Fragments._Root__Element /* 3 */,
			Fragments._Root__Root /* 4 */
		};
		private static final @NonNull int[] __Root = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Visitable =
		{
			Fragments._Visitable__OclAny /* 0 */,
			Fragments._Visitable__OclElement /* 1 */,
			Fragments._Visitable__Visitable /* 2 */
		};
		private static final @NonNull int[] __Visitable = { 1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._Class.initFragments(_Class, __Class);
			Types._Element.initFragments(_Element, __Element);
			Types._NamedElement.initFragments(_NamedElement, __NamedElement);
			Types._Namespace.initFragments(_Namespace, __Namespace);
			Types._Package.initFragments(_Package, __Package);
			Types._Root.initFragments(_Root, __Root);
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

		private static final @NonNull ExecutorOperation[] _Class__Class = {};
		private static final @NonNull ExecutorOperation[] _Class__Element = {};
		private static final @NonNull ExecutorOperation[] _Class__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Class__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Class__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Class__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Element__Element = {};
		private static final @NonNull ExecutorOperation[] _Element__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Element__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Element__Visitable = {};

		private static final @NonNull ExecutorOperation[] _NamedElement__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _NamedElement__Element = {};
		private static final @NonNull ExecutorOperation[] _NamedElement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _NamedElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _NamedElement__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Namespace__Namespace = {};
		private static final @NonNull ExecutorOperation[] _Namespace__Element = {};
		private static final @NonNull ExecutorOperation[] _Namespace__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Namespace__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Namespace__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Package__Package = {};
		private static final @NonNull ExecutorOperation[] _Package__Element = {};
		private static final @NonNull ExecutorOperation[] _Package__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Package__Namespace = {};
		private static final @NonNull ExecutorOperation[] _Package__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Package__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Package__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Root__Root = {};
		private static final @NonNull ExecutorOperation[] _Root__Element = {};
		private static final @NonNull ExecutorOperation[] _Root__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Root__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Root__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Visitable__Visitable = {};
		private static final @NonNull ExecutorOperation[] _Visitable__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[1]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Visitable__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
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

			Fragments._Package__Element.initOperations(_Package__Element);
			Fragments._Package__NamedElement.initOperations(_Package__NamedElement);
			Fragments._Package__Namespace.initOperations(_Package__Namespace);
			Fragments._Package__OclAny.initOperations(_Package__OclAny);
			Fragments._Package__OclElement.initOperations(_Package__OclElement);
			Fragments._Package__Package.initOperations(_Package__Package);
			Fragments._Package__Visitable.initOperations(_Package__Visitable);

			Fragments._Root__Element.initOperations(_Root__Element);
			Fragments._Root__OclAny.initOperations(_Root__OclAny);
			Fragments._Root__OclElement.initOperations(_Root__OclElement);
			Fragments._Root__Root.initOperations(_Root__Root);
			Fragments._Root__Visitable.initOperations(_Root__Visitable);

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

		private static final @NonNull ExecutorProperty[] _Class = {
			ClassesTables.Properties._NamedElement__name,
			ClassesTables.Properties._Class__superClass,
			ClassesTables.Properties._Class__Class__superClass,
			ClassesTables.Properties._Class__Package__ownedClasses
		};

		private static final @NonNull ExecutorProperty[] _Element = {};

		private static final @NonNull ExecutorProperty[] _NamedElement = {
			ClassesTables.Properties._NamedElement__name
		};

		private static final @NonNull ExecutorProperty[] _Namespace = {};

		private static final @NonNull ExecutorProperty[] _Package = {
			ClassesTables.Properties._NamedElement__name,
			ClassesTables.Properties._Package__ownedClasses,
			ClassesTables.Properties._Package__ownedPackages,
			ClassesTables.Properties._Package__Package__ownedPackages,
			ClassesTables.Properties._Package__Root__ownedPackages
		};

		private static final @NonNull ExecutorProperty[] _Root = {
			ClassesTables.Properties._Root__ownedPackages
		};

		private static final @NonNull ExecutorProperty[] _Visitable = {};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._Class__Class.initProperties(_Class);
			Fragments._Element__Element.initProperties(_Element);
			Fragments._NamedElement__NamedElement.initProperties(_NamedElement);
			Fragments._Namespace__Namespace.initProperties(_Namespace);
			Fragments._Package__Package.initProperties(_Package);
			Fragments._Root__Root.initProperties(_Root);
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
