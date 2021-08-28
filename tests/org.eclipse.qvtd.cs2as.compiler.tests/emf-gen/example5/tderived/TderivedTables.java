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
 *   /org.eclipse.qvtd.cs2as.compiler.tests/models/BaseAndDerived/TargetDerivedMM.ecore
 * using:
 *   /org.eclipse.qvtd.cs2as.compiler.tests/models/BaseAndDerived/TargetDerivedMM.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package example5.tderived;

import example5.tbase.TbaseTables;
// import example5.tderived.TderivedPackage;
// import example5.tderived.TderivedTables;
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
import org.eclipse.ocl.pivot.utilities.AbstractTables;

/**
 * TderivedTables provides the dispatch tables for the tderived for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
public class TderivedTables extends AbstractTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(TderivedPackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
	public static final /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetDerivedMM_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example5/targetDerivedMM/1.0", null, TderivedPackage.eINSTANCE);
	public static final /*@NonInvalid*/ ClassId CLSSid_A2 = TderivedTables.PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetDerivedMM_s_1_0.getClassId("A2", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_D = TderivedTables.PACKid_http_c_s_s_cs2as_s_tests_s_example5_s_targetDerivedMM_s_1_0.getClassId("D", 0);
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_D = TypeId.ORDERED_SET.getSpecializedId(TderivedTables.CLSSid_D);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			TderivedTables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TderivedTables::TypeParameters and all preceding sub-packages.
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

		public static final EcoreExecutorType _A2 = new EcoreExecutorType(TderivedPackage.Literals.A2, PACKAGE, 0);
		public static final EcoreExecutorType _B2 = new EcoreExecutorType(TderivedPackage.Literals.B2, PACKAGE, 0);
		public static final EcoreExecutorType _D = new EcoreExecutorType(TderivedPackage.Literals.D, PACKAGE, 0);

		private static final EcoreExecutorType /*@NonNull*/ [] types = {
			_A2,
			_B2,
			_D
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TderivedTables::Types and all preceding sub-packages.
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

		private static final ExecutorFragment _A2__A = new ExecutorFragment(Types._A2, TbaseTables.Types._A);
		private static final ExecutorFragment _A2__A2 = new ExecutorFragment(Types._A2, TderivedTables.Types._A2);
		private static final ExecutorFragment _A2__Element = new ExecutorFragment(Types._A2, TbaseTables.Types._Element);
		private static final ExecutorFragment _A2__NamedElement = new ExecutorFragment(Types._A2, TbaseTables.Types._NamedElement);
		private static final ExecutorFragment _A2__OclAny = new ExecutorFragment(Types._A2, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _A2__OclElement = new ExecutorFragment(Types._A2, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _B2__B = new ExecutorFragment(Types._B2, TbaseTables.Types._B);
		private static final ExecutorFragment _B2__B2 = new ExecutorFragment(Types._B2, TderivedTables.Types._B2);
		private static final ExecutorFragment _B2__Element = new ExecutorFragment(Types._B2, TbaseTables.Types._Element);
		private static final ExecutorFragment _B2__NamedElement = new ExecutorFragment(Types._B2, TbaseTables.Types._NamedElement);
		private static final ExecutorFragment _B2__OclAny = new ExecutorFragment(Types._B2, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _B2__OclElement = new ExecutorFragment(Types._B2, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _D__D = new ExecutorFragment(Types._D, TderivedTables.Types._D);
		private static final ExecutorFragment _D__Element = new ExecutorFragment(Types._D, TbaseTables.Types._Element);
		private static final ExecutorFragment _D__OclAny = new ExecutorFragment(Types._D, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _D__OclElement = new ExecutorFragment(Types._D, OCLstdlibTables.Types._OclElement);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TderivedTables::Fragments and all preceding sub-packages.
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
		 * Force initialization of the fields of TderivedTables::Parameters and all preceding sub-packages.
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
		 * Force initialization of the fields of TderivedTables::Operations and all preceding sub-packages.
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

		public static final ExecutorProperty _A2__ownsD = new EcoreExecutorProperty(TderivedPackage.Literals.A2__OWNS_D, Types._A2, 0);

		public static final ExecutorProperty _B2__anotherName = new EcoreExecutorProperty(TderivedPackage.Literals.B2__ANOTHER_NAME, Types._B2, 0);

		public static final ExecutorProperty _D__A2__ownsD = new ExecutorPropertyWithImplementation("A2", Types._D, 0, new EcoreLibraryOppositeProperty(TderivedPackage.Literals.A2__OWNS_D));
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TderivedTables::Properties and all preceding sub-packages.
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

		private static final ExecutorFragment /*@NonNull*/ [] _A2 =
			{
				Fragments._A2__OclAny /* 0 */,
				Fragments._A2__OclElement /* 1 */,
				Fragments._A2__Element /* 2 */,
				Fragments._A2__NamedElement /* 3 */,
				Fragments._A2__A /* 4 */,
				Fragments._A2__A2 /* 5 */
			};
		private static final int /*@NonNull*/ [] __A2 = { 1,1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _B2 =
			{
				Fragments._B2__OclAny /* 0 */,
				Fragments._B2__OclElement /* 1 */,
				Fragments._B2__Element /* 2 */,
				Fragments._B2__NamedElement /* 3 */,
				Fragments._B2__B /* 4 */,
				Fragments._B2__B2 /* 5 */
			};
		private static final int /*@NonNull*/ [] __B2 = { 1,1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _D =
			{
				Fragments._D__OclAny /* 0 */,
				Fragments._D__OclElement /* 1 */,
				Fragments._D__Element /* 2 */,
				Fragments._D__D /* 3 */
			};
		private static final int /*@NonNull*/ [] __D = { 1,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._A2.initFragments(_A2, __A2);
			Types._B2.initFragments(_B2, __B2);
			Types._D.initFragments(_D, __D);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TderivedTables::TypeFragments and all preceding sub-packages.
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

		private static final ExecutorOperation /*@NonNull*/ [] _A2__A2 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _A2__A = {};
		private static final ExecutorOperation /*@NonNull*/ [] _A2__Element = {};
		private static final ExecutorOperation /*@NonNull*/ [] _A2__NamedElement = {};
		private static final ExecutorOperation /*@NonNull*/ [] _A2__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _A2__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _B2__B2 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _B2__B = {};
		private static final ExecutorOperation /*@NonNull*/ [] _B2__Element = {};
		private static final ExecutorOperation /*@NonNull*/ [] _B2__NamedElement = {};
		private static final ExecutorOperation /*@NonNull*/ [] _B2__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _B2__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _D__D = {};
		private static final ExecutorOperation /*@NonNull*/ [] _D__Element = {};
		private static final ExecutorOperation /*@NonNull*/ [] _D__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _D__OclElement = {
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
			Fragments._A2__A.initOperations(_A2__A);
			Fragments._A2__A2.initOperations(_A2__A2);
			Fragments._A2__Element.initOperations(_A2__Element);
			Fragments._A2__NamedElement.initOperations(_A2__NamedElement);
			Fragments._A2__OclAny.initOperations(_A2__OclAny);
			Fragments._A2__OclElement.initOperations(_A2__OclElement);

			Fragments._B2__B.initOperations(_B2__B);
			Fragments._B2__B2.initOperations(_B2__B2);
			Fragments._B2__Element.initOperations(_B2__Element);
			Fragments._B2__NamedElement.initOperations(_B2__NamedElement);
			Fragments._B2__OclAny.initOperations(_B2__OclAny);
			Fragments._B2__OclElement.initOperations(_B2__OclElement);

			Fragments._D__D.initOperations(_D__D);
			Fragments._D__Element.initOperations(_D__Element);
			Fragments._D__OclAny.initOperations(_D__OclAny);
			Fragments._D__OclElement.initOperations(_D__OclElement);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TderivedTables::FragmentOperations and all preceding sub-packages.
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

		private static final ExecutorProperty /*@NonNull*/ [] _A2 = {
			TbaseTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			TbaseTables.Properties._A__ownsB,
			TderivedTables.Properties._A2__ownsD
		};

		private static final ExecutorProperty /*@NonNull*/ [] _B2 = {
			TderivedTables.Properties._B2__anotherName,
			TbaseTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			TbaseTables.Properties._B__ownsC
		};

		private static final ExecutorProperty /*@NonNull*/ [] _D = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._A2__A2.initProperties(_A2);
			Fragments._B2__B2.initProperties(_B2);
			Fragments._D__D.initProperties(_D);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of TderivedTables::FragmentProperties and all preceding sub-packages.
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
		 * Force initialization of the fields of TderivedTables::EnumerationLiterals and all preceding sub-packages.
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
		new TderivedTables();
	}

	private TderivedTables() {
		super(TderivedPackage.eNS_URI);
	}
}
