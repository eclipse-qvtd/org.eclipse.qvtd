/*******************************************************************************
 * Copyright (c) 2014, 2021 Willink Transformations and others.
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
 *   /org.eclipse.qvtd.cs2as.compiler.tests/models/BaseAndDerived/TargetBaseMM.ecore
 * using:
 *   /org.eclipse.qvtd.cs2as.compiler.tests/models/BaseAndDerived/TargetBaseMM.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package example5.tbase;

// import example5.tbase.TbasePackage;
// import example5.tbase.TbaseTables;
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
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorType;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.AbstractTables;

/**
 * TbaseTables provides the dispatch tables for the tbase for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
public class TbaseTables extends AbstractTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(TbasePackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
	public static final /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetBaseMM_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example5/targetBaseMM/1.0", null, TbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ ClassId CLSSid_A = TbaseTables.PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetBaseMM_s_1_0.getClassId("A", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_B = TbaseTables.PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetBaseMM_s_1_0.getClassId("B", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_C = TbaseTables.PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetBaseMM_s_1_0.getClassId("C", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_TRoot = TbaseTables.PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetBaseMM_s_1_0.getClassId("TRoot", 0);
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_A = TypeId.ORDERED_SET.getSpecializedId(TbaseTables.CLSSid_A);
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_B = TypeId.ORDERED_SET.getSpecializedId(TbaseTables.CLSSid_B);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			TbaseTables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TbaseTables::TypeParameters and all preceding sub-packages.
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

		public static final EcoreExecutorType _A = new EcoreExecutorType(TbasePackage.Literals.A, PACKAGE, 0);
		public static final EcoreExecutorType _B = new EcoreExecutorType(TbasePackage.Literals.B, PACKAGE, 0);
		public static final EcoreExecutorType _C = new EcoreExecutorType(TbasePackage.Literals.C, PACKAGE, 0);
		public static final EcoreExecutorType _Element = new EcoreExecutorType(TbasePackage.Literals.ELEMENT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final EcoreExecutorType _NamedElement = new EcoreExecutorType(TbasePackage.Literals.NAMED_ELEMENT, PACKAGE, 0);
		public static final EcoreExecutorType _TRoot = new EcoreExecutorType(TbasePackage.Literals.TROOT, PACKAGE, 0);

		private static final EcoreExecutorType /*@NonNull*/ [] types = {
			_A,
			_B,
			_C,
			_Element,
			_NamedElement,
			_TRoot
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TbaseTables::Types and all preceding sub-packages.
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

		private static final ExecutorFragment _A__A = new ExecutorFragment(Types._A, TbaseTables.Types._A);
		private static final ExecutorFragment _A__Element = new ExecutorFragment(Types._A, TbaseTables.Types._Element);
		private static final ExecutorFragment _A__NamedElement = new ExecutorFragment(Types._A, TbaseTables.Types._NamedElement);
		private static final ExecutorFragment _A__OclAny = new ExecutorFragment(Types._A, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _A__OclElement = new ExecutorFragment(Types._A, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _B__B = new ExecutorFragment(Types._B, TbaseTables.Types._B);
		private static final ExecutorFragment _B__Element = new ExecutorFragment(Types._B, TbaseTables.Types._Element);
		private static final ExecutorFragment _B__NamedElement = new ExecutorFragment(Types._B, TbaseTables.Types._NamedElement);
		private static final ExecutorFragment _B__OclAny = new ExecutorFragment(Types._B, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _B__OclElement = new ExecutorFragment(Types._B, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _C__C = new ExecutorFragment(Types._C, TbaseTables.Types._C);
		private static final ExecutorFragment _C__Element = new ExecutorFragment(Types._C, TbaseTables.Types._Element);
		private static final ExecutorFragment _C__OclAny = new ExecutorFragment(Types._C, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _C__OclElement = new ExecutorFragment(Types._C, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _Element__Element = new ExecutorFragment(Types._Element, TbaseTables.Types._Element);
		private static final ExecutorFragment _Element__OclAny = new ExecutorFragment(Types._Element, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Element__OclElement = new ExecutorFragment(Types._Element, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _NamedElement__Element = new ExecutorFragment(Types._NamedElement, TbaseTables.Types._Element);
		private static final ExecutorFragment _NamedElement__NamedElement = new ExecutorFragment(Types._NamedElement, TbaseTables.Types._NamedElement);
		private static final ExecutorFragment _NamedElement__OclAny = new ExecutorFragment(Types._NamedElement, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _NamedElement__OclElement = new ExecutorFragment(Types._NamedElement, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _TRoot__Element = new ExecutorFragment(Types._TRoot, TbaseTables.Types._Element);
		private static final ExecutorFragment _TRoot__OclAny = new ExecutorFragment(Types._TRoot, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _TRoot__OclElement = new ExecutorFragment(Types._TRoot, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _TRoot__TRoot = new ExecutorFragment(Types._TRoot, TbaseTables.Types._TRoot);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TbaseTables::Fragments and all preceding sub-packages.
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
		 * Force initialization of the fields of TbaseTables::Parameters and all preceding sub-packages.
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
		 * Force initialization of the fields of TbaseTables::Operations and all preceding sub-packages.
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

		public static final ExecutorProperty _A__ownsB = new EcoreExecutorProperty(TbasePackage.Literals.A__OWNS_B, Types._A, 0);
		public static final ExecutorProperty _A__TRoot__ownedA = new ExecutorPropertyWithImplementation("TRoot", Types._A, 1, new EcoreLibraryOppositeProperty(TbasePackage.Literals.TROOT__OWNED_A));

		public static final ExecutorProperty _B__ownsC = new EcoreExecutorProperty(TbasePackage.Literals.B__OWNS_C, Types._B, 0);
		public static final ExecutorProperty _B__A__ownsB = new ExecutorPropertyWithImplementation("A", Types._B, 1, new EcoreLibraryOppositeProperty(TbasePackage.Literals.A__OWNS_B));

		public static final ExecutorProperty _C__B__ownsC = new ExecutorPropertyWithImplementation("B", Types._C, 0, new EcoreLibraryOppositeProperty(TbasePackage.Literals.B__OWNS_C));

		public static final ExecutorProperty _NamedElement__name = new EcoreExecutorProperty(TbasePackage.Literals.NAMED_ELEMENT__NAME, Types._NamedElement, 0);

		public static final ExecutorProperty _TRoot__ownedA = new EcoreExecutorProperty(TbasePackage.Literals.TROOT__OWNED_A, Types._TRoot, 0);
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TbaseTables::Properties and all preceding sub-packages.
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

		private static final ExecutorFragment /*@NonNull*/ [] _A =
			{
				Fragments._A__OclAny /* 0 */,
				Fragments._A__OclElement /* 1 */,
				Fragments._A__Element /* 2 */,
				Fragments._A__NamedElement /* 3 */,
				Fragments._A__A /* 4 */
			};
		private static final int /*@NonNull*/ [] __A = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _B =
			{
				Fragments._B__OclAny /* 0 */,
				Fragments._B__OclElement /* 1 */,
				Fragments._B__Element /* 2 */,
				Fragments._B__NamedElement /* 3 */,
				Fragments._B__B /* 4 */
			};
		private static final int /*@NonNull*/ [] __B = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _C =
			{
				Fragments._C__OclAny /* 0 */,
				Fragments._C__OclElement /* 1 */,
				Fragments._C__Element /* 2 */,
				Fragments._C__C /* 3 */
			};
		private static final int /*@NonNull*/ [] __C = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Element =
			{
				Fragments._Element__OclAny /* 0 */,
				Fragments._Element__OclElement /* 1 */,
				Fragments._Element__Element /* 2 */
			};
		private static final int /*@NonNull*/ [] __Element = { 1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _NamedElement =
			{
				Fragments._NamedElement__OclAny /* 0 */,
				Fragments._NamedElement__OclElement /* 1 */,
				Fragments._NamedElement__Element /* 2 */,
				Fragments._NamedElement__NamedElement /* 3 */
			};
		private static final int /*@NonNull*/ [] __NamedElement = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _TRoot =
			{
				Fragments._TRoot__OclAny /* 0 */,
				Fragments._TRoot__OclElement /* 1 */,
				Fragments._TRoot__Element /* 2 */,
				Fragments._TRoot__TRoot /* 3 */
			};
		private static final int /*@NonNull*/ [] __TRoot = { 1,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._A.initFragments(_A, __A);
			Types._B.initFragments(_B, __B);
			Types._C.initFragments(_C, __C);
			Types._Element.initFragments(_Element, __Element);
			Types._NamedElement.initFragments(_NamedElement, __NamedElement);
			Types._TRoot.initFragments(_TRoot, __TRoot);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TbaseTables::TypeFragments and all preceding sub-packages.
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

		private static final ExecutorOperation /*@NonNull*/ [] _A__A = {};
		private static final ExecutorOperation /*@NonNull*/ [] _A__Element = {};
		private static final ExecutorOperation /*@NonNull*/ [] _A__NamedElement = {};
		private static final ExecutorOperation /*@NonNull*/ [] _A__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _A__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _B__B = {};
		private static final ExecutorOperation /*@NonNull*/ [] _B__Element = {};
		private static final ExecutorOperation /*@NonNull*/ [] _B__NamedElement = {};
		private static final ExecutorOperation /*@NonNull*/ [] _B__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _B__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _C__C = {};
		private static final ExecutorOperation /*@NonNull*/ [] _C__Element = {};
		private static final ExecutorOperation /*@NonNull*/ [] _C__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _C__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Element__Element = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Element__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _Element__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _NamedElement__NamedElement = {};
		private static final ExecutorOperation /*@NonNull*/ [] _NamedElement__Element = {};
		private static final ExecutorOperation /*@NonNull*/ [] _NamedElement__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _NamedElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _TRoot__TRoot = {};
		private static final ExecutorOperation /*@NonNull*/ [] _TRoot__Element = {};
		private static final ExecutorOperation /*@NonNull*/ [] _TRoot__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _TRoot__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._A__A.initOperations(_A__A);
			Fragments._A__Element.initOperations(_A__Element);
			Fragments._A__NamedElement.initOperations(_A__NamedElement);
			Fragments._A__OclAny.initOperations(_A__OclAny);
			Fragments._A__OclElement.initOperations(_A__OclElement);

			Fragments._B__B.initOperations(_B__B);
			Fragments._B__Element.initOperations(_B__Element);
			Fragments._B__NamedElement.initOperations(_B__NamedElement);
			Fragments._B__OclAny.initOperations(_B__OclAny);
			Fragments._B__OclElement.initOperations(_B__OclElement);

			Fragments._C__C.initOperations(_C__C);
			Fragments._C__Element.initOperations(_C__Element);
			Fragments._C__OclAny.initOperations(_C__OclAny);
			Fragments._C__OclElement.initOperations(_C__OclElement);

			Fragments._Element__Element.initOperations(_Element__Element);
			Fragments._Element__OclAny.initOperations(_Element__OclAny);
			Fragments._Element__OclElement.initOperations(_Element__OclElement);

			Fragments._NamedElement__Element.initOperations(_NamedElement__Element);
			Fragments._NamedElement__NamedElement.initOperations(_NamedElement__NamedElement);
			Fragments._NamedElement__OclAny.initOperations(_NamedElement__OclAny);
			Fragments._NamedElement__OclElement.initOperations(_NamedElement__OclElement);

			Fragments._TRoot__Element.initOperations(_TRoot__Element);
			Fragments._TRoot__OclAny.initOperations(_TRoot__OclAny);
			Fragments._TRoot__OclElement.initOperations(_TRoot__OclElement);
			Fragments._TRoot__TRoot.initOperations(_TRoot__TRoot);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TbaseTables::FragmentOperations and all preceding sub-packages.
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

		private static final ExecutorProperty /*@NonNull*/ [] _A = {
			TbaseTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			TbaseTables.Properties._A__ownsB
		};

		private static final ExecutorProperty /*@NonNull*/ [] _B = {
			TbaseTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			TbaseTables.Properties._B__ownsC
		};

		private static final ExecutorProperty /*@NonNull*/ [] _C = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Element = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _NamedElement = {
			TbaseTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _TRoot = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			TbaseTables.Properties._TRoot__ownedA
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._A__A.initProperties(_A);
			Fragments._B__B.initProperties(_B);
			Fragments._C__C.initProperties(_C);
			Fragments._Element__Element.initProperties(_Element);
			Fragments._NamedElement__NamedElement.initProperties(_NamedElement);
			Fragments._TRoot__TRoot.initProperties(_TRoot);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TbaseTables::FragmentProperties and all preceding sub-packages.
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
		 * Force initialization of the fields of TbaseTables::EnumerationLiterals and all preceding sub-packages.
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
		new TbaseTables();
	}

	private TbaseTables() {
		super(TbasePackage.eNS_URI);
	}
}
