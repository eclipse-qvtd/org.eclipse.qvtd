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
 *   /org.eclipse.qvtd.cs2as.compiler.tests/models/Source2Target/TargetMM1.ecore
 * using:
 *   /org.eclipse.qvtd.cs2as.compiler.tests/models/Source2Target/TargetMM1.genmodel
 *   org.eclipse.ocl.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package example1.target;

// import example1.target.TargetPackage;
// import example1.target.TargetTables;
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
 * TargetTables provides the dispatch tables for the target for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
public class TargetTables extends AbstractTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The library of all packages and types.
	 */
	public static final PartialStandardLibraryImpl.@NonNull ReadOnly LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	The package descriptor for the package.
	 */
	public static final org.eclipse.ocl.pivot.@NonNull Package PACKAGE = LIBRARY.createPackage(TargetPackage.eINSTANCE, null);

	/**
	 *	Constants used by auto-generated code.
	 */
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example1/targetMM/1.0", null, TargetPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_A = TargetTables.PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_A1 = TargetTables.PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A1", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_A2 = TargetTables.PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A2", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_B = TargetTables.PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("B", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_C = TargetTables.PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("C", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_D = TargetTables.PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("D", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TRoot = TargetTables.PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("TRoot", 0);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_D = TypeId.BAG.getSpecializedId(TargetTables.CLSSid_D, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_A = TypeId.ORDERED_SET.getSpecializedId(TargetTables.CLSSid_A, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_B = TypeId.ORDERED_SET.getSpecializedId(TargetTables.CLSSid_B, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_C = TypeId.ORDERED_SET.getSpecializedId(TargetTables.CLSSid_C, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			TargetTables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TargetTables::TypeParameters and all preceding sub-packages.
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

		public static final org.eclipse.ocl.pivot.@NonNull Class _A = LIBRARY.createClass(PivotPackage.Literals.CLASS, TargetPackage.Literals.A, PACKAGE, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _A1 = LIBRARY.createClass(PivotPackage.Literals.CLASS, TargetPackage.Literals.A1, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _A2 = LIBRARY.createClass(PivotPackage.Literals.CLASS, TargetPackage.Literals.A2, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _A3 = LIBRARY.createClass(PivotPackage.Literals.CLASS, TargetPackage.Literals.A3, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _B = LIBRARY.createClass(PivotPackage.Literals.CLASS, TargetPackage.Literals.B, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _C = LIBRARY.createClass(PivotPackage.Literals.CLASS, TargetPackage.Literals.C, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _D = LIBRARY.createClass(PivotPackage.Literals.CLASS, TargetPackage.Literals.D, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _NamedElement = LIBRARY.createClass(PivotPackage.Literals.CLASS, TargetPackage.Literals.NAMED_ELEMENT, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Namespace = LIBRARY.createClass(PivotPackage.Literals.CLASS, TargetPackage.Literals.NAMESPACE, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _TRoot = LIBRARY.createClass(PivotPackage.Literals.CLASS, TargetPackage.Literals.TROOT, PACKAGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _Visitable = LIBRARY.createClass(PivotPackage.Literals.CLASS, TargetPackage.Literals.VISITABLE, PACKAGE, null, 0 | FlatClass.ABSTRACT);

		private static final org.eclipse.ocl.pivot.@NonNull Class @NonNull [] types = {
			_A,
			_A1,
			_A2,
			_A3,
			_B,
			_C,
			_D,
			_NamedElement,
			_Namespace,
			_TRoot,
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
		 * Force initialization of the fields of TargetTables::Types and all preceding sub-packages.
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

		private static final @NonNull FlatFragment _A__A = LIBRARY.createFragment(Types._A, TargetTables.Types._A);
		private static final @NonNull FlatFragment _A__NamedElement = LIBRARY.createFragment(Types._A, TargetTables.Types._NamedElement);
		private static final @NonNull FlatFragment _A__Namespace = LIBRARY.createFragment(Types._A, TargetTables.Types._Namespace);
		private static final @NonNull FlatFragment _A__OclAny = LIBRARY.createFragment(Types._A, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _A__OclElement = LIBRARY.createFragment(Types._A, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _A__Visitable = LIBRARY.createFragment(Types._A, TargetTables.Types._Visitable);

		private static final @NonNull FlatFragment _A1__A = LIBRARY.createFragment(Types._A1, TargetTables.Types._A);
		private static final @NonNull FlatFragment _A1__A1 = LIBRARY.createFragment(Types._A1, TargetTables.Types._A1);
		private static final @NonNull FlatFragment _A1__NamedElement = LIBRARY.createFragment(Types._A1, TargetTables.Types._NamedElement);
		private static final @NonNull FlatFragment _A1__Namespace = LIBRARY.createFragment(Types._A1, TargetTables.Types._Namespace);
		private static final @NonNull FlatFragment _A1__OclAny = LIBRARY.createFragment(Types._A1, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _A1__OclElement = LIBRARY.createFragment(Types._A1, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _A1__Visitable = LIBRARY.createFragment(Types._A1, TargetTables.Types._Visitable);

		private static final @NonNull FlatFragment _A2__A = LIBRARY.createFragment(Types._A2, TargetTables.Types._A);
		private static final @NonNull FlatFragment _A2__A2 = LIBRARY.createFragment(Types._A2, TargetTables.Types._A2);
		private static final @NonNull FlatFragment _A2__NamedElement = LIBRARY.createFragment(Types._A2, TargetTables.Types._NamedElement);
		private static final @NonNull FlatFragment _A2__Namespace = LIBRARY.createFragment(Types._A2, TargetTables.Types._Namespace);
		private static final @NonNull FlatFragment _A2__OclAny = LIBRARY.createFragment(Types._A2, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _A2__OclElement = LIBRARY.createFragment(Types._A2, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _A2__Visitable = LIBRARY.createFragment(Types._A2, TargetTables.Types._Visitable);

		private static final @NonNull FlatFragment _A3__A = LIBRARY.createFragment(Types._A3, TargetTables.Types._A);
		private static final @NonNull FlatFragment _A3__A2 = LIBRARY.createFragment(Types._A3, TargetTables.Types._A2);
		private static final @NonNull FlatFragment _A3__A3 = LIBRARY.createFragment(Types._A3, TargetTables.Types._A3);
		private static final @NonNull FlatFragment _A3__NamedElement = LIBRARY.createFragment(Types._A3, TargetTables.Types._NamedElement);
		private static final @NonNull FlatFragment _A3__Namespace = LIBRARY.createFragment(Types._A3, TargetTables.Types._Namespace);
		private static final @NonNull FlatFragment _A3__OclAny = LIBRARY.createFragment(Types._A3, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _A3__OclElement = LIBRARY.createFragment(Types._A3, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _A3__Visitable = LIBRARY.createFragment(Types._A3, TargetTables.Types._Visitable);

		private static final @NonNull FlatFragment _B__B = LIBRARY.createFragment(Types._B, TargetTables.Types._B);
		private static final @NonNull FlatFragment _B__NamedElement = LIBRARY.createFragment(Types._B, TargetTables.Types._NamedElement);
		private static final @NonNull FlatFragment _B__Namespace = LIBRARY.createFragment(Types._B, TargetTables.Types._Namespace);
		private static final @NonNull FlatFragment _B__OclAny = LIBRARY.createFragment(Types._B, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _B__OclElement = LIBRARY.createFragment(Types._B, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _B__Visitable = LIBRARY.createFragment(Types._B, TargetTables.Types._Visitable);

		private static final @NonNull FlatFragment _C__C = LIBRARY.createFragment(Types._C, TargetTables.Types._C);
		private static final @NonNull FlatFragment _C__NamedElement = LIBRARY.createFragment(Types._C, TargetTables.Types._NamedElement);
		private static final @NonNull FlatFragment _C__Namespace = LIBRARY.createFragment(Types._C, TargetTables.Types._Namespace);
		private static final @NonNull FlatFragment _C__OclAny = LIBRARY.createFragment(Types._C, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _C__OclElement = LIBRARY.createFragment(Types._C, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _C__Visitable = LIBRARY.createFragment(Types._C, TargetTables.Types._Visitable);

		private static final @NonNull FlatFragment _D__D = LIBRARY.createFragment(Types._D, TargetTables.Types._D);
		private static final @NonNull FlatFragment _D__NamedElement = LIBRARY.createFragment(Types._D, TargetTables.Types._NamedElement);
		private static final @NonNull FlatFragment _D__OclAny = LIBRARY.createFragment(Types._D, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _D__OclElement = LIBRARY.createFragment(Types._D, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _D__Visitable = LIBRARY.createFragment(Types._D, TargetTables.Types._Visitable);

		private static final @NonNull FlatFragment _NamedElement__NamedElement = LIBRARY.createFragment(Types._NamedElement, TargetTables.Types._NamedElement);
		private static final @NonNull FlatFragment _NamedElement__OclAny = LIBRARY.createFragment(Types._NamedElement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _NamedElement__OclElement = LIBRARY.createFragment(Types._NamedElement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _NamedElement__Visitable = LIBRARY.createFragment(Types._NamedElement, TargetTables.Types._Visitable);

		private static final @NonNull FlatFragment _Namespace__NamedElement = LIBRARY.createFragment(Types._Namespace, TargetTables.Types._NamedElement);
		private static final @NonNull FlatFragment _Namespace__Namespace = LIBRARY.createFragment(Types._Namespace, TargetTables.Types._Namespace);
		private static final @NonNull FlatFragment _Namespace__OclAny = LIBRARY.createFragment(Types._Namespace, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Namespace__OclElement = LIBRARY.createFragment(Types._Namespace, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Namespace__Visitable = LIBRARY.createFragment(Types._Namespace, TargetTables.Types._Visitable);

		private static final @NonNull FlatFragment _TRoot__OclAny = LIBRARY.createFragment(Types._TRoot, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _TRoot__OclElement = LIBRARY.createFragment(Types._TRoot, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _TRoot__TRoot = LIBRARY.createFragment(Types._TRoot, TargetTables.Types._TRoot);
		private static final @NonNull FlatFragment _TRoot__Visitable = LIBRARY.createFragment(Types._TRoot, TargetTables.Types._Visitable);

		private static final @NonNull FlatFragment _Visitable__OclAny = LIBRARY.createFragment(Types._Visitable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _Visitable__OclElement = LIBRARY.createFragment(Types._Visitable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _Visitable__Visitable = LIBRARY.createFragment(Types._Visitable, TargetTables.Types._Visitable);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TargetTables::Fragments and all preceding sub-packages.
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
		 * Force initialization of the fields of TargetTables::Parameters and all preceding sub-packages.
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
		 * Force initialization of the fields of TargetTables::Operations and all preceding sub-packages.
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

		public static final @NonNull Property _A__D__toA = LIBRARY.createOppositeProperty("D", Types._A, 0, TargetPackage.Literals.D__TO_A);
		public static final @NonNull Property _A__TRoot__ownedA = LIBRARY.createOppositeProperty("TRoot", Types._A, 1, TargetPackage.Literals.TROOT__OWNED_A);

		public static final @NonNull Property _A1__ownsB = LIBRARY.createProperty(TargetPackage.Literals.A1__OWNS_B, Types._A1, 0);

		public static final @NonNull Property _A2__ownsC = LIBRARY.createProperty(TargetPackage.Literals.A2__OWNS_C, Types._A2, 0);

		public static final @NonNull Property _B__ownsD = LIBRARY.createProperty(TargetPackage.Literals.B__OWNS_D, Types._B, 0);
		public static final @NonNull Property _B__toA1 = LIBRARY.createProperty(TargetPackage.Literals.B__TO_A1, Types._B, 1);
		public static final @NonNull Property _B__D__refsB = LIBRARY.createOppositeProperty("D", Types._B, 2, TargetPackage.Literals.D__REFS_B);

		public static final @NonNull Property _C__ownsD = LIBRARY.createProperty(TargetPackage.Literals.C__OWNS_D, Types._C, 0);
		public static final @NonNull Property _C__toA2 = LIBRARY.createProperty(TargetPackage.Literals.C__TO_A2, Types._C, 1);
		public static final @NonNull Property _C__D__refsC = LIBRARY.createOppositeProperty("D", Types._C, 2, TargetPackage.Literals.D__REFS_C);

		public static final @NonNull Property _D__refsB = LIBRARY.createProperty(TargetPackage.Literals.D__REFS_B, Types._D, 0);
		public static final @NonNull Property _D__refsC = LIBRARY.createProperty(TargetPackage.Literals.D__REFS_C, Types._D, 1);
		public static final @NonNull Property _D__toA = LIBRARY.createProperty(TargetPackage.Literals.D__TO_A, Types._D, 2);
		public static final @NonNull Property _D__toB = LIBRARY.createProperty(TargetPackage.Literals.D__TO_B, Types._D, 3);
		public static final @NonNull Property _D__toC = LIBRARY.createProperty(TargetPackage.Literals.D__TO_C, Types._D, 4);

		public static final @NonNull Property _NamedElement__name = LIBRARY.createProperty(TargetPackage.Literals.NAMED_ELEMENT__NAME, Types._NamedElement, 0);

		public static final @NonNull Property _TRoot__ownedA = LIBRARY.createProperty(TargetPackage.Literals.TROOT__OWNED_A, Types._TRoot, 0);
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TargetTables::Properties and all preceding sub-packages.
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

		private static final @NonNull FlatFragment @NonNull [] _A =
			{
				Fragments._A__OclAny /* 0 */,
				Fragments._A__OclElement /* 1 */,
				Fragments._A__Visitable /* 2 */,
				Fragments._A__NamedElement /* 3 */,
				Fragments._A__Namespace /* 4 */,
				Fragments._A__A /* 5 */
			};
		private static final int @NonNull [] __A = { 1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _A1 =
			{
				Fragments._A1__OclAny /* 0 */,
				Fragments._A1__OclElement /* 1 */,
				Fragments._A1__Visitable /* 2 */,
				Fragments._A1__NamedElement /* 3 */,
				Fragments._A1__Namespace /* 4 */,
				Fragments._A1__A /* 5 */,
				Fragments._A1__A1 /* 6 */
			};
		private static final int @NonNull [] __A1 = { 1,1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _A2 =
			{
				Fragments._A2__OclAny /* 0 */,
				Fragments._A2__OclElement /* 1 */,
				Fragments._A2__Visitable /* 2 */,
				Fragments._A2__NamedElement /* 3 */,
				Fragments._A2__Namespace /* 4 */,
				Fragments._A2__A /* 5 */,
				Fragments._A2__A2 /* 6 */
			};
		private static final int @NonNull [] __A2 = { 1,1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _A3 =
			{
				Fragments._A3__OclAny /* 0 */,
				Fragments._A3__OclElement /* 1 */,
				Fragments._A3__Visitable /* 2 */,
				Fragments._A3__NamedElement /* 3 */,
				Fragments._A3__Namespace /* 4 */,
				Fragments._A3__A /* 5 */,
				Fragments._A3__A2 /* 6 */,
				Fragments._A3__A3 /* 7 */
			};
		private static final int @NonNull [] __A3 = { 1,1,1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _B =
			{
				Fragments._B__OclAny /* 0 */,
				Fragments._B__OclElement /* 1 */,
				Fragments._B__Visitable /* 2 */,
				Fragments._B__NamedElement /* 3 */,
				Fragments._B__Namespace /* 4 */,
				Fragments._B__B /* 5 */
			};
		private static final int @NonNull [] __B = { 1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _C =
			{
				Fragments._C__OclAny /* 0 */,
				Fragments._C__OclElement /* 1 */,
				Fragments._C__Visitable /* 2 */,
				Fragments._C__NamedElement /* 3 */,
				Fragments._C__Namespace /* 4 */,
				Fragments._C__C /* 5 */
			};
		private static final int @NonNull [] __C = { 1,1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _D =
			{
				Fragments._D__OclAny /* 0 */,
				Fragments._D__OclElement /* 1 */,
				Fragments._D__Visitable /* 2 */,
				Fragments._D__NamedElement /* 3 */,
				Fragments._D__D /* 4 */
			};
		private static final int @NonNull [] __D = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _NamedElement =
			{
				Fragments._NamedElement__OclAny /* 0 */,
				Fragments._NamedElement__OclElement /* 1 */,
				Fragments._NamedElement__Visitable /* 2 */,
				Fragments._NamedElement__NamedElement /* 3 */
			};
		private static final int @NonNull [] __NamedElement = { 1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _Namespace =
			{
				Fragments._Namespace__OclAny /* 0 */,
				Fragments._Namespace__OclElement /* 1 */,
				Fragments._Namespace__Visitable /* 2 */,
				Fragments._Namespace__NamedElement /* 3 */,
				Fragments._Namespace__Namespace /* 4 */
			};
		private static final int @NonNull [] __Namespace = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _TRoot =
			{
				Fragments._TRoot__OclAny /* 0 */,
				Fragments._TRoot__OclElement /* 1 */,
				Fragments._TRoot__Visitable /* 2 */,
				Fragments._TRoot__TRoot /* 3 */
			};
		private static final int @NonNull [] __TRoot = { 1,1,1,1 };

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
			Types._A.initFragments(_A, __A);
			Types._A1.initFragments(_A1, __A1);
			Types._A2.initFragments(_A2, __A2);
			Types._A3.initFragments(_A3, __A3);
			Types._B.initFragments(_B, __B);
			Types._C.initFragments(_C, __C);
			Types._D.initFragments(_D, __D);
			Types._NamedElement.initFragments(_NamedElement, __NamedElement);
			Types._Namespace.initFragments(_Namespace, __Namespace);
			Types._TRoot.initFragments(_TRoot, __TRoot);
			Types._Visitable.initFragments(_Visitable, __Visitable);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TargetTables::TypeFragments and all preceding sub-packages.
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

		private static final @NonNull Operation @NonNull [] _A__A = {};
		private static final @NonNull Operation @NonNull [] _A__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _A__Namespace = {};
		private static final @NonNull Operation @NonNull [] _A__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _A__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _A__Visitable = {};

		private static final @NonNull Operation @NonNull [] _A1__A1 = {};
		private static final @NonNull Operation @NonNull [] _A1__A = {};
		private static final @NonNull Operation @NonNull [] _A1__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _A1__Namespace = {};
		private static final @NonNull Operation @NonNull [] _A1__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _A1__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _A1__Visitable = {};

		private static final @NonNull Operation @NonNull [] _A2__A2 = {};
		private static final @NonNull Operation @NonNull [] _A2__A = {};
		private static final @NonNull Operation @NonNull [] _A2__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _A2__Namespace = {};
		private static final @NonNull Operation @NonNull [] _A2__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _A2__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _A2__Visitable = {};

		private static final @NonNull Operation @NonNull [] _A3__A3 = {};
		private static final @NonNull Operation @NonNull [] _A3__A = {};
		private static final @NonNull Operation @NonNull [] _A3__A2 = {};
		private static final @NonNull Operation @NonNull [] _A3__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _A3__Namespace = {};
		private static final @NonNull Operation @NonNull [] _A3__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _A3__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _A3__Visitable = {};

		private static final @NonNull Operation @NonNull [] _B__B = {};
		private static final @NonNull Operation @NonNull [] _B__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _B__Namespace = {};
		private static final @NonNull Operation @NonNull [] _B__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _B__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _B__Visitable = {};

		private static final @NonNull Operation @NonNull [] _C__C = {};
		private static final @NonNull Operation @NonNull [] _C__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _C__Namespace = {};
		private static final @NonNull Operation @NonNull [] _C__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _C__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _C__Visitable = {};

		private static final @NonNull Operation @NonNull [] _D__D = {};
		private static final @NonNull Operation @NonNull [] _D__NamedElement = {};
		private static final @NonNull Operation @NonNull [] _D__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _D__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _D__Visitable = {};

		private static final @NonNull Operation @NonNull [] _NamedElement__NamedElement = {};
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

		private static final @NonNull Operation @NonNull [] _TRoot__TRoot = {};
		private static final @NonNull Operation @NonNull [] _TRoot__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _TRoot__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _TRoot__Visitable = {};

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
			Fragments._A__A.initOperations(_A__A);
			Fragments._A__NamedElement.initOperations(_A__NamedElement);
			Fragments._A__Namespace.initOperations(_A__Namespace);
			Fragments._A__OclAny.initOperations(_A__OclAny);
			Fragments._A__OclElement.initOperations(_A__OclElement);
			Fragments._A__Visitable.initOperations(_A__Visitable);

			Fragments._A1__A.initOperations(_A1__A);
			Fragments._A1__A1.initOperations(_A1__A1);
			Fragments._A1__NamedElement.initOperations(_A1__NamedElement);
			Fragments._A1__Namespace.initOperations(_A1__Namespace);
			Fragments._A1__OclAny.initOperations(_A1__OclAny);
			Fragments._A1__OclElement.initOperations(_A1__OclElement);
			Fragments._A1__Visitable.initOperations(_A1__Visitable);

			Fragments._A2__A.initOperations(_A2__A);
			Fragments._A2__A2.initOperations(_A2__A2);
			Fragments._A2__NamedElement.initOperations(_A2__NamedElement);
			Fragments._A2__Namespace.initOperations(_A2__Namespace);
			Fragments._A2__OclAny.initOperations(_A2__OclAny);
			Fragments._A2__OclElement.initOperations(_A2__OclElement);
			Fragments._A2__Visitable.initOperations(_A2__Visitable);

			Fragments._A3__A.initOperations(_A3__A);
			Fragments._A3__A2.initOperations(_A3__A2);
			Fragments._A3__A3.initOperations(_A3__A3);
			Fragments._A3__NamedElement.initOperations(_A3__NamedElement);
			Fragments._A3__Namespace.initOperations(_A3__Namespace);
			Fragments._A3__OclAny.initOperations(_A3__OclAny);
			Fragments._A3__OclElement.initOperations(_A3__OclElement);
			Fragments._A3__Visitable.initOperations(_A3__Visitable);

			Fragments._B__B.initOperations(_B__B);
			Fragments._B__NamedElement.initOperations(_B__NamedElement);
			Fragments._B__Namespace.initOperations(_B__Namespace);
			Fragments._B__OclAny.initOperations(_B__OclAny);
			Fragments._B__OclElement.initOperations(_B__OclElement);
			Fragments._B__Visitable.initOperations(_B__Visitable);

			Fragments._C__C.initOperations(_C__C);
			Fragments._C__NamedElement.initOperations(_C__NamedElement);
			Fragments._C__Namespace.initOperations(_C__Namespace);
			Fragments._C__OclAny.initOperations(_C__OclAny);
			Fragments._C__OclElement.initOperations(_C__OclElement);
			Fragments._C__Visitable.initOperations(_C__Visitable);

			Fragments._D__D.initOperations(_D__D);
			Fragments._D__NamedElement.initOperations(_D__NamedElement);
			Fragments._D__OclAny.initOperations(_D__OclAny);
			Fragments._D__OclElement.initOperations(_D__OclElement);
			Fragments._D__Visitable.initOperations(_D__Visitable);

			Fragments._NamedElement__NamedElement.initOperations(_NamedElement__NamedElement);
			Fragments._NamedElement__OclAny.initOperations(_NamedElement__OclAny);
			Fragments._NamedElement__OclElement.initOperations(_NamedElement__OclElement);
			Fragments._NamedElement__Visitable.initOperations(_NamedElement__Visitable);

			Fragments._Namespace__NamedElement.initOperations(_Namespace__NamedElement);
			Fragments._Namespace__Namespace.initOperations(_Namespace__Namespace);
			Fragments._Namespace__OclAny.initOperations(_Namespace__OclAny);
			Fragments._Namespace__OclElement.initOperations(_Namespace__OclElement);
			Fragments._Namespace__Visitable.initOperations(_Namespace__Visitable);

			Fragments._TRoot__OclAny.initOperations(_TRoot__OclAny);
			Fragments._TRoot__OclElement.initOperations(_TRoot__OclElement);
			Fragments._TRoot__TRoot.initOperations(_TRoot__TRoot);
			Fragments._TRoot__Visitable.initOperations(_TRoot__Visitable);

			Fragments._Visitable__OclAny.initOperations(_Visitable__OclAny);
			Fragments._Visitable__OclElement.initOperations(_Visitable__OclElement);
			Fragments._Visitable__Visitable.initOperations(_Visitable__Visitable);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TargetTables::FragmentOperations and all preceding sub-packages.
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

		private static final @NonNull Property @NonNull [] _A = {
			TargetTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _A1 = {
			TargetTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			TargetTables.Properties._A1__ownsB
		};

		private static final @NonNull Property @NonNull [] _A2 = {
			TargetTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			TargetTables.Properties._A2__ownsC
		};

		private static final @NonNull Property @NonNull [] _A3 = {
			TargetTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			TargetTables.Properties._A2__ownsC
		};

		private static final @NonNull Property @NonNull [] _B = {
			TargetTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			TargetTables.Properties._B__ownsD,
			TargetTables.Properties._B__toA1
		};

		private static final @NonNull Property @NonNull [] _C = {
			TargetTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			TargetTables.Properties._C__ownsD,
			TargetTables.Properties._C__toA2
		};

		private static final @NonNull Property @NonNull [] _D = {
			TargetTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			TargetTables.Properties._D__refsB,
			TargetTables.Properties._D__refsC,
			TargetTables.Properties._D__toA,
			TargetTables.Properties._D__toB,
			TargetTables.Properties._D__toC
		};

		private static final @NonNull Property @NonNull [] _NamedElement = {
			TargetTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _Namespace = {
			TargetTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _TRoot = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			TargetTables.Properties._TRoot__ownedA
		};

		private static final @NonNull Property @NonNull [] _Visitable = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._A__A.initProperties(_A);
			Fragments._A1__A1.initProperties(_A1);
			Fragments._A2__A2.initProperties(_A2);
			Fragments._A3__A3.initProperties(_A3);
			Fragments._B__B.initProperties(_B);
			Fragments._C__C.initProperties(_C);
			Fragments._D__D.initProperties(_D);
			Fragments._NamedElement__NamedElement.initProperties(_NamedElement);
			Fragments._Namespace__Namespace.initProperties(_Namespace);
			Fragments._TRoot__TRoot.initProperties(_TRoot);
			Fragments._Visitable__Visitable.initProperties(_Visitable);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TargetTables::FragmentProperties and all preceding sub-packages.
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
		 * Force initialization of the fields of TargetTables::EnumerationLiterals and all preceding sub-packages.
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
		new TargetTables();
	}

	private TargetTables() {
		super(TargetPackage.eNS_URI);
	}
}
