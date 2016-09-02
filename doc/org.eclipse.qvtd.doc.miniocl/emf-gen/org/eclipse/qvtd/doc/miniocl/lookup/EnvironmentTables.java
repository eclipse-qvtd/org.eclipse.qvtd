/*******************************************************************************
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 *   /org.eclipse.qvtd.doc.miniocl/model/Lookup.ecore
 * using:
 *   /org.eclipse.qvtd.doc.miniocl/model/Lookup.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.qvtd.doc.miniocl.lookup;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ParameterTypes;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreLibraryOppositeProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorFragment;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorOperation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorPropertyWithImplementation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSpecializedType;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorType;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorTypeParameter;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.qvtd.doc.miniocl.MiniOCLTables;
import org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables;

/**
 * EnvironmentTables provides the dispatch tables for the lookup for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
@SuppressWarnings("nls")
public class EnvironmentTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final @NonNull EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(EnvironmentPackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final @NonNull ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId COL_PRIMid_OclAny = org.eclipse.ocl.pivot.ids.TypeId.COLLECTION.getSpecializedId(org.eclipse.ocl.pivot.ids.TypeId.OCL_ANY);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId COL_TMPLid_ = org.eclipse.ocl.pivot.ids.TypeId.COLLECTION.getSpecializedId(org.eclipse.ocl.pivot.ids.IdManager.getTemplateParameterId(0));
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0 = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/doc/MiniOCL/1.0", null, org.eclipse.qvtd.doc.miniocl.MiniOCLPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_Lookup_s_1_0 = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0", null, org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Executor = org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_Lookup_s_1_0.getClassId("Executor", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_LookupEnvironment = org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_Lookup_s_1_0.getClassId("LookupEnvironment", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_NamedElement = org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables.PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("NamedElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_LookupEnvironment = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables.CLSSid_LookupEnvironment);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_NamedElement = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables.CLSSid_NamedElement);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull PropertyId PROPid_namedElements = org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables.CLSSid_LookupEnvironment.getPropertyId("namedElements");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull PropertyId PROPid_parentEnv = org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentTables.CLSSid_LookupEnvironment.getPropertyId("parentEnv");

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			EnvironmentTables.init();
		}
		public static final @NonNull ExecutorTypeParameter __LookupEnvironment__0_addElements_NE = new ExecutorTypeParameter(TypeId.T_1, "NE");

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of EnvironmentTables::TypeParameters and all preceding sub-packages.
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

		public static final @NonNull EcoreExecutorType _Env4CG = new EcoreExecutorType(EnvironmentPackage.Literals.ENV4_CG, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _Executor = new EcoreExecutorType(EnvironmentPackage.Literals.EXECUTOR, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _LookupEnvironment = new EcoreExecutorType(EnvironmentPackage.Literals.LOOKUP_ENVIRONMENT, PACKAGE, 0);

		private static final @NonNull EcoreExecutorType @NonNull [] types = {
			_Env4CG,
			_Executor,
			_LookupEnvironment
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of EnvironmentTables::Types and all preceding sub-packages.
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

		private static final @NonNull ExecutorFragment _Env4CG__Env4CG = new ExecutorFragment(Types._Env4CG, EnvironmentTables.Types._Env4CG);
		private static final @NonNull ExecutorFragment _Env4CG__OclAny = new ExecutorFragment(Types._Env4CG, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Env4CG__OclElement = new ExecutorFragment(Types._Env4CG, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _Executor__Executor = new ExecutorFragment(Types._Executor, EnvironmentTables.Types._Executor);
		private static final @NonNull ExecutorFragment _Executor__OclAny = new ExecutorFragment(Types._Executor, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Executor__OclElement = new ExecutorFragment(Types._Executor, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _LookupEnvironment__Env4CG = new ExecutorFragment(Types._LookupEnvironment, EnvironmentTables.Types._Env4CG);
		private static final @NonNull ExecutorFragment _LookupEnvironment__LookupEnvironment = new ExecutorFragment(Types._LookupEnvironment, EnvironmentTables.Types._LookupEnvironment);
		private static final @NonNull ExecutorFragment _LookupEnvironment__OclAny = new ExecutorFragment(Types._LookupEnvironment, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _LookupEnvironment__OclElement = new ExecutorFragment(Types._LookupEnvironment, OCLstdlibTables.Types._OclElement);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of EnvironmentTables::Fragments and all preceding sub-packages.
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

		public static final @NonNull ParameterTypes _Collection__LookupEnvironment_0_addElements_NE__ = TypeUtil.createParameterTypes(new ExecutorSpecializedType("Collection", EnvironmentTables.TypeParameters.__LookupEnvironment__0_addElements_NE));
		public static final @NonNull ParameterTypes _NamedElement = TypeUtil.createParameterTypes(MiniOCLTables.Types._NamedElement);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of EnvironmentTables::Parameters and all preceding sub-packages.
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

		public static final @NonNull ExecutorOperation _Env4CG__getExecutor = new ExecutorOperation("getExecutor", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Env4CG,
			0, TemplateParameters.EMPTY_LIST, null);
		public static final @NonNull ExecutorOperation _Env4CG__hasFinalResult = new ExecutorOperation("hasFinalResult", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Env4CG,
			1, TemplateParameters.EMPTY_LIST, null);

		public static final @NonNull ExecutorOperation _LookupEnvironment__0_addElements = new ExecutorOperation("addElements", Parameters._Collection__LookupEnvironment_0_addElements_NE__, Types._LookupEnvironment,
			0, TypeUtil.createTemplateParameters(TypeParameters.__LookupEnvironment__0_addElements_NE), null);
		public static final @NonNull ExecutorOperation _LookupEnvironment__1_addElements = new ExecutorOperation("addElements", Parameters._NamedElement, Types._LookupEnvironment,
			1, TemplateParameters.EMPTY_LIST, null);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of EnvironmentTables::Operations and all preceding sub-packages.
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


		public static final @NonNull ExecutorProperty _LookupEnvironment__namedElements = new EcoreExecutorProperty(EnvironmentPackage.Literals.LOOKUP_ENVIRONMENT__NAMED_ELEMENTS, Types._LookupEnvironment, 0);
		public static final @NonNull ExecutorProperty _LookupEnvironment__parentEnv = new EcoreExecutorProperty(EnvironmentPackage.Literals.LOOKUP_ENVIRONMENT__PARENT_ENV, Types._LookupEnvironment, 1);
		public static final @NonNull ExecutorProperty _LookupEnvironment__LookupEnvironment__parentEnv = new ExecutorPropertyWithImplementation("LookupEnvironment", Types._LookupEnvironment, 2, new EcoreLibraryOppositeProperty(EnvironmentPackage.Literals.LOOKUP_ENVIRONMENT__PARENT_ENV));
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of EnvironmentTables::Properties and all preceding sub-packages.
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

		private static final @NonNull ExecutorFragment @NonNull [] _Env4CG =
		{
			Fragments._Env4CG__OclAny /* 0 */,
			Fragments._Env4CG__OclElement /* 1 */,
			Fragments._Env4CG__Env4CG /* 2 */
		};
		private static final int @NonNull [] __Env4CG = { 1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Executor =
		{
			Fragments._Executor__OclAny /* 0 */,
			Fragments._Executor__OclElement /* 1 */,
			Fragments._Executor__Executor /* 2 */
		};
		private static final int @NonNull [] __Executor = { 1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _LookupEnvironment =
		{
			Fragments._LookupEnvironment__OclAny /* 0 */,
			Fragments._LookupEnvironment__OclElement /* 1 */,
			Fragments._LookupEnvironment__Env4CG /* 2 */,
			Fragments._LookupEnvironment__LookupEnvironment /* 3 */
		};
		private static final int @NonNull [] __LookupEnvironment = { 1,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._Env4CG.initFragments(_Env4CG, __Env4CG);
			Types._Executor.initFragments(_Executor, __Executor);
			Types._LookupEnvironment.initFragments(_LookupEnvironment, __LookupEnvironment);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of EnvironmentTables::TypeFragments and all preceding sub-packages.
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

		private static final @NonNull ExecutorOperation @NonNull [] _Env4CG__Env4CG = {
			EnvironmentTables.Operations._Env4CG__getExecutor /* getExecutor() */,
			EnvironmentTables.Operations._Env4CG__hasFinalResult /* hasFinalResult() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Env4CG__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Env4CG__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Executor__Executor = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Executor__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Executor__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _LookupEnvironment__LookupEnvironment = {
			EnvironmentTables.Operations._LookupEnvironment__0_addElements /* addElements(NE)(Collection(NE)) */,
			EnvironmentTables.Operations._LookupEnvironment__1_addElements /* addElements(NamedElement[?]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _LookupEnvironment__Env4CG = {
			EnvironmentTables.Operations._Env4CG__getExecutor /* getExecutor() */,
			EnvironmentTables.Operations._Env4CG__hasFinalResult /* hasFinalResult() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _LookupEnvironment__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _LookupEnvironment__OclElement = {
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
			Fragments._Env4CG__Env4CG.initOperations(_Env4CG__Env4CG);
			Fragments._Env4CG__OclAny.initOperations(_Env4CG__OclAny);
			Fragments._Env4CG__OclElement.initOperations(_Env4CG__OclElement);

			Fragments._Executor__Executor.initOperations(_Executor__Executor);
			Fragments._Executor__OclAny.initOperations(_Executor__OclAny);
			Fragments._Executor__OclElement.initOperations(_Executor__OclElement);

			Fragments._LookupEnvironment__Env4CG.initOperations(_LookupEnvironment__Env4CG);
			Fragments._LookupEnvironment__LookupEnvironment.initOperations(_LookupEnvironment__LookupEnvironment);
			Fragments._LookupEnvironment__OclAny.initOperations(_LookupEnvironment__OclAny);
			Fragments._LookupEnvironment__OclElement.initOperations(_LookupEnvironment__OclElement);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of EnvironmentTables::FragmentOperations and all preceding sub-packages.
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

		private static final @NonNull ExecutorProperty @NonNull [] _Env4CG = {};

		private static final @NonNull ExecutorProperty @NonNull [] _Executor = {};

		private static final @NonNull ExecutorProperty @NonNull [] _LookupEnvironment = {
			EnvironmentTables.Properties._LookupEnvironment__namedElements,
			EnvironmentTables.Properties._LookupEnvironment__parentEnv,
			EnvironmentTables.Properties._LookupEnvironment__LookupEnvironment__parentEnv
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._Env4CG__Env4CG.initProperties(_Env4CG);
			Fragments._Executor__Executor.initProperties(_Executor);
			Fragments._LookupEnvironment__LookupEnvironment.initProperties(_LookupEnvironment);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of EnvironmentTables::FragmentProperties and all preceding sub-packages.
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
		 * Force initialization of the fields of EnvironmentTables::EnumerationLiterals and all preceding sub-packages.
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