/*******************************************************************************
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 *   platform:/resource/org.eclipse.qvtd.build.cs2as.tests/src/org/eclipse/qvtd/build/cs2as/tests/models/example2/EnvExample2.ecore
 * using:
 *   platform:/resource/org.eclipse.qvtd.build.cs2as.tests/src/org/eclipse/qvtd/build/cs2as/tests/models/example2/EnvExample2.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package example2.env;

import example2.classes.ClassesTables;
import example2.env.EnvironmentPackage;
import example2.env.EnvironmentTables;
import org.eclipse.ocl.pivot.ParameterTypes;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.PropertyId;
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
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.TypeUtil;

/**
 * EnvironmentTables provides the dispatch tables for the env for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
@SuppressWarnings("nls")
public class EnvironmentTables
{
	/**
	 *	The package descriptor for the package.
	 */
	public static final /*@NonNull*/ EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(EnvironmentPackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final /*@NonNull*/ ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classes/1.0", null, null);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_env_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/env/1.0", null, EnvironmentPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Environment = EnvironmentTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_env_s_1_0.getClassId("Environment", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Evaluator = EnvironmentTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_env_s_1_0.getClassId("Evaluator", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_NamedElement = EnvironmentTables.PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("NamedElement", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_Environment = TypeId.BAG.getSpecializedId(EnvironmentTables.CLSSid_Environment);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId COL_CLSSid_NamedElement = TypeId.COLLECTION.getSpecializedId(EnvironmentTables.CLSSid_NamedElement);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_NamedElement = TypeId.ORDERED_SET.getSpecializedId(EnvironmentTables.CLSSid_NamedElement);
    public static final /*@NonNull*/ /*@NonInvalid*/ PropertyId PROPid_namedElements = EnvironmentTables.CLSSid_Environment.getPropertyId("namedElements");
    public static final /*@NonNull*/ /*@NonInvalid*/ PropertyId PROPid_parentEnv = EnvironmentTables.CLSSid_Environment.getPropertyId("parentEnv");

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {	}

	/**
	 *	The type descriptors for each type.
	 */
	public static class Types {
		public static final /*@NonNull*/ EcoreExecutorType _Env4CG = new EcoreExecutorType(EnvironmentPackage.Literals.ENV4_CG, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _Environment = new EcoreExecutorType(EnvironmentPackage.Literals.ENVIRONMENT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _Evaluator = new EcoreExecutorType(EnvironmentPackage.Literals.EVALUATOR, PACKAGE, 0);

		private static final /*@NonNull*/ EcoreExecutorType[] types = {
			_Env4CG,
			_Environment,
			_Evaluator
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			TypeFragments.init();
			FragmentOperations.init();
			FragmentProperties.init();
		}

		public static void init() {}
	}

	/**
	 *	The fragment descriptors for the local elements of each type and its supertypes.
	 */
	public static class Fragments {
		private static final /*@NonNull*/ ExecutorFragment _Env4CG__Env4CG = new ExecutorFragment(Types._Env4CG, EnvironmentTables.Types._Env4CG);
		private static final /*@NonNull*/ ExecutorFragment _Env4CG__OclAny = new ExecutorFragment(Types._Env4CG, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Env4CG__OclElement = new ExecutorFragment(Types._Env4CG, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _Environment__Env4CG = new ExecutorFragment(Types._Environment, EnvironmentTables.Types._Env4CG);
		private static final /*@NonNull*/ ExecutorFragment _Environment__Environment = new ExecutorFragment(Types._Environment, EnvironmentTables.Types._Environment);
		private static final /*@NonNull*/ ExecutorFragment _Environment__OclAny = new ExecutorFragment(Types._Environment, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Environment__OclElement = new ExecutorFragment(Types._Environment, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _Evaluator__Evaluator = new ExecutorFragment(Types._Evaluator, EnvironmentTables.Types._Evaluator);
		private static final /*@NonNull*/ ExecutorFragment _Evaluator__OclAny = new ExecutorFragment(Types._Evaluator, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Evaluator__OclElement = new ExecutorFragment(Types._Evaluator, OCLstdlibTables.Types._OclElement);

		/*
		 * Force initialization.
		 */
		public static void init() {
			Types.init();
		}
	}

	/**
	 *	The parameter lists shared by operations.
	 */
	public static class Parameters {
		public static final /*@NonNull*/ ParameterTypes _ = TypeUtil.createParameterTypes();
		public static final /*@NonNull*/ ParameterTypes _NamedElement = TypeUtil.createParameterTypes(ClassesTables.Types._NamedElement);
		public static final /*@NonNull*/ ParameterTypes _OrderedSet__NamedElement__ = TypeUtil.createParameterTypes(new ExecutorSpecializedType("OrderedSet", ClassesTables.Types._NamedElement));
	}

	/**
	 *	The operation descriptors for each operation of each type.
	 */
	public static class Operations {
		public static final /*@NonNull*/ ExecutorOperation _Env4CG__getEvaluator = new ExecutorOperation("getEvaluator", Parameters._, Types._Env4CG,
			0, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _Env4CG__hasFinalResult = new ExecutorOperation("hasFinalResult", Parameters._, Types._Env4CG,
			1, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _Environment__addElement = new ExecutorOperation("addElement", Parameters._NamedElement, Types._Environment,
			0, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _Environment__addElements = new ExecutorOperation("addElements", Parameters._OrderedSet__NamedElement__, Types._Environment,
			1, TemplateParameters.EMPTY_LIST, null);

	}

	/**
	 *	The property descriptors for each property of each type.
	 */
	public static class Properties {

		public static final /*@NonNull*/ ExecutorProperty _Environment__namedElements = new EcoreExecutorProperty(EnvironmentPackage.Literals.ENVIRONMENT__NAMED_ELEMENTS, Types._Environment, 0);
		public static final /*@NonNull*/ ExecutorProperty _Environment__parentEnv = new EcoreExecutorProperty(EnvironmentPackage.Literals.ENVIRONMENT__PARENT_ENV, Types._Environment, 1);
		public static final /*@NonNull*/ ExecutorProperty _Environment__Environment__parentEnv = new ExecutorPropertyWithImplementation("Environment", Types._Environment, 2, new EcoreLibraryOppositeProperty(EnvironmentPackage.Literals.ENVIRONMENT__PARENT_ENV));

		/*
		 * Force initialization.
		 */
		public static void init() {
			Types.init();
		}
	}

	/**
	 *	The fragments for all base types in depth order: OclAny first, OclSelf last.
	 */
	public static class TypeFragments {
		private static final /*@NonNull*/ ExecutorFragment[] _Env4CG =
		{
			Fragments._Env4CG__OclAny /* 0 */,
			Fragments._Env4CG__OclElement /* 1 */,
			Fragments._Env4CG__Env4CG /* 2 */
		};
		private static final /*@NonNull*/ int[] __Env4CG = { 1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _Environment =
		{
			Fragments._Environment__OclAny /* 0 */,
			Fragments._Environment__OclElement /* 1 */,
			Fragments._Environment__Env4CG /* 2 */,
			Fragments._Environment__Environment /* 3 */
		};
		private static final /*@NonNull*/ int[] __Environment = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _Evaluator =
		{
			Fragments._Evaluator__OclAny /* 0 */,
			Fragments._Evaluator__OclElement /* 1 */,
			Fragments._Evaluator__Evaluator /* 2 */
		};
		private static final /*@NonNull*/ int[] __Evaluator = { 1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		public static void init() {
			Fragments.init();
			Properties.init();

			Types._Env4CG.initFragments(_Env4CG, __Env4CG);
			Types._Environment.initFragments(_Environment, __Environment);
			Types._Evaluator.initFragments(_Evaluator, __Evaluator);
		}
	}

	/**
	 *	The lists of local operations or local operation overrides for each fragment of each type.
	 */
	public static class FragmentOperations {
		private static final /*@NonNull*/ ExecutorOperation[] _Env4CG__Env4CG = {
			EnvironmentTables.Operations._Env4CG__getEvaluator /* getEvaluator() */,
			EnvironmentTables.Operations._Env4CG__hasFinalResult /* hasFinalResult() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Env4CG__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Env4CG__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _Environment__Environment = {
			EnvironmentTables.Operations._Environment__addElement /* addElement(NamedElement[?]) */,
			EnvironmentTables.Operations._Environment__addElements /* addElements(OrderedSet(classes::NamedElement)) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Environment__Env4CG = {
			EnvironmentTables.Operations._Env4CG__getEvaluator /* getEvaluator() */,
			EnvironmentTables.Operations._Env4CG__hasFinalResult /* hasFinalResult() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Environment__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Environment__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _Evaluator__Evaluator = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Evaluator__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Evaluator__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		public static void init() {
			TypeFragments.init();

			Fragments._Env4CG__Env4CG.initOperations(_Env4CG__Env4CG);
			Fragments._Env4CG__OclAny.initOperations(_Env4CG__OclAny);
			Fragments._Env4CG__OclElement.initOperations(_Env4CG__OclElement);

			Fragments._Environment__Env4CG.initOperations(_Environment__Env4CG);
			Fragments._Environment__Environment.initOperations(_Environment__Environment);
			Fragments._Environment__OclAny.initOperations(_Environment__OclAny);
			Fragments._Environment__OclElement.initOperations(_Environment__OclElement);

			Fragments._Evaluator__Evaluator.initOperations(_Evaluator__Evaluator);
			Fragments._Evaluator__OclAny.initOperations(_Evaluator__OclAny);
			Fragments._Evaluator__OclElement.initOperations(_Evaluator__OclElement);
		}
	}

	/**
	 *	The lists of local properties for the local fragment of each type.
	 */
	public static class FragmentProperties {
		private static final /*@NonNull*/ ExecutorProperty[] _Env4CG = {};

		private static final /*@NonNull*/ ExecutorProperty[] _Environment = {
			EnvironmentTables.Properties._Environment__namedElements,
			EnvironmentTables.Properties._Environment__parentEnv,
			EnvironmentTables.Properties._Environment__Environment__parentEnv
		};

		private static final /*@NonNull*/ ExecutorProperty[] _Evaluator = {};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		public static void init() {
			TypeFragments.init();

			Fragments._Env4CG__Env4CG.initProperties(_Env4CG);
			Fragments._Environment__Environment.initProperties(_Environment);
			Fragments._Evaluator__Evaluator.initProperties(_Evaluator);
		}
	}

	/**
	 *	The lists of enumeration literals for each enumeration.
	 */
	public static class EnumerationLiterals {
		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {
		}

		public static void init() {}
	}

	/*
	 * Force initialization.
	 */
	static {
		Types.init();
	}
}
