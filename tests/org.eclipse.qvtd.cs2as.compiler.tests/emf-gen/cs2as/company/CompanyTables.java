/*******************************************************************************
 * Copyright (c)  2016 Willink Transformations, Univesity of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 *   /org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/cs2as/compiler/tests/models/companies/Company.ecore
 * using:
 *   /org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/cs2as/compiler/tests/models/companies/Company.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package cs2as.company;

import cs2as.company.CompanyTables;
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
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorType;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;

/**
 * CompanyTables provides the dispatch tables for the company for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
@SuppressWarnings("nls")
public class CompanyTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final @NonNull EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(CompanyPackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final @NonNull ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_companies_s_AS_s_1_0 = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://cs2as/tests/companies/AS/1.0", null, cs2as.company.CompanyPackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, org.eclipse.emf.ecore.EcorePackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Company = cs2as.company.CompanyTables.PACKid_http_c_s_s_cs2as_s_tests_s_companies_s_AS_s_1_0.getClassId("Company", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Department = cs2as.company.CompanyTables.PACKid_http_c_s_s_cs2as_s_tests_s_companies_s_AS_s_1_0.getClassId("Department", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Employee = cs2as.company.CompanyTables.PACKid_http_c_s_s_cs2as_s_tests_s_companies_s_AS_s_1_0.getClassId("Employee", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull DataTypeId DATAid_EDouble = cs2as.company.CompanyTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EDouble", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_Employee = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(cs2as.company.CompanyTables.CLSSid_Employee);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Department = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(cs2as.company.CompanyTables.CLSSid_Department);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Employee = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(cs2as.company.CompanyTables.CLSSid_Employee);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			CompanyTables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CompanyTables::TypeParameters and all preceding sub-packages.
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

		public static final @NonNull EcoreExecutorType _Company = new EcoreExecutorType(CompanyPackage.Literals.COMPANY, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Department = new EcoreExecutorType(CompanyPackage.Literals.DEPARTMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Employee = new EcoreExecutorType(CompanyPackage.Literals.EMPLOYEE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Visitable = new EcoreExecutorType(CompanyPackage.Literals.VISITABLE, PACKAGE, 0 | ExecutorType.ABSTRACT);

		private static final @NonNull EcoreExecutorType @NonNull [] types = {
			_Company,
			_Department,
			_Employee,
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
		 * Force initialization of the fields of CompanyTables::Types and all preceding sub-packages.
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

		private static final @NonNull ExecutorFragment _Company__Company = new ExecutorFragment(Types._Company, CompanyTables.Types._Company);
		private static final @NonNull ExecutorFragment _Company__OclAny = new ExecutorFragment(Types._Company, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Company__OclElement = new ExecutorFragment(Types._Company, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Company__Visitable = new ExecutorFragment(Types._Company, CompanyTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Department__Department = new ExecutorFragment(Types._Department, CompanyTables.Types._Department);
		private static final @NonNull ExecutorFragment _Department__OclAny = new ExecutorFragment(Types._Department, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Department__OclElement = new ExecutorFragment(Types._Department, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Department__Visitable = new ExecutorFragment(Types._Department, CompanyTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Employee__Employee = new ExecutorFragment(Types._Employee, CompanyTables.Types._Employee);
		private static final @NonNull ExecutorFragment _Employee__OclAny = new ExecutorFragment(Types._Employee, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Employee__OclElement = new ExecutorFragment(Types._Employee, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Employee__Visitable = new ExecutorFragment(Types._Employee, CompanyTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Visitable__OclAny = new ExecutorFragment(Types._Visitable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Visitable__OclElement = new ExecutorFragment(Types._Visitable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Visitable__Visitable = new ExecutorFragment(Types._Visitable, CompanyTables.Types._Visitable);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CompanyTables::Fragments and all preceding sub-packages.
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
		 * Force initialization of the fields of CompanyTables::Parameters and all preceding sub-packages.
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
		 * Force initialization of the fields of CompanyTables::Operations and all preceding sub-packages.
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

		public static final @NonNull ExecutorProperty _Company__depts = new EcoreExecutorProperty(CompanyPackage.Literals.COMPANY__DEPTS, Types._Company, 0);
		public static final @NonNull ExecutorProperty _Company__name = new EcoreExecutorProperty(CompanyPackage.Literals.COMPANY__NAME, Types._Company, 1);

		public static final @NonNull ExecutorProperty _Department__employees = new EcoreExecutorProperty(CompanyPackage.Literals.DEPARTMENT__EMPLOYEES, Types._Department, 0);
		public static final @NonNull ExecutorProperty _Department__manager = new EcoreExecutorProperty(CompanyPackage.Literals.DEPARTMENT__MANAGER, Types._Department, 1);
		public static final @NonNull ExecutorProperty _Department__name = new EcoreExecutorProperty(CompanyPackage.Literals.DEPARTMENT__NAME, Types._Department, 2);
		public static final @NonNull ExecutorProperty _Department__subdepts = new EcoreExecutorProperty(CompanyPackage.Literals.DEPARTMENT__SUBDEPTS, Types._Department, 3);
		public static final @NonNull ExecutorProperty _Department__Company__depts = new ExecutorPropertyWithImplementation("Company", Types._Department, 4, new EcoreLibraryOppositeProperty(CompanyPackage.Literals.COMPANY__DEPTS));
		public static final @NonNull ExecutorProperty _Department__Department__subdepts = new ExecutorPropertyWithImplementation("Department", Types._Department, 5, new EcoreLibraryOppositeProperty(CompanyPackage.Literals.DEPARTMENT__SUBDEPTS));

		public static final @NonNull ExecutorProperty _Employee__address = new EcoreExecutorProperty(CompanyPackage.Literals.EMPLOYEE__ADDRESS, Types._Employee, 0);
		public static final @NonNull ExecutorProperty _Employee__mentor = new EcoreExecutorProperty(CompanyPackage.Literals.EMPLOYEE__MENTOR, Types._Employee, 1);
		public static final @NonNull ExecutorProperty _Employee__name = new EcoreExecutorProperty(CompanyPackage.Literals.EMPLOYEE__NAME, Types._Employee, 2);
		public static final @NonNull ExecutorProperty _Employee__salary = new EcoreExecutorProperty(CompanyPackage.Literals.EMPLOYEE__SALARY, Types._Employee, 3);
		public static final @NonNull ExecutorProperty _Employee__Department__employees = new ExecutorPropertyWithImplementation("Department", Types._Employee, 4, new EcoreLibraryOppositeProperty(CompanyPackage.Literals.DEPARTMENT__EMPLOYEES));
		public static final @NonNull ExecutorProperty _Employee__Department__manager = new ExecutorPropertyWithImplementation("Department", Types._Employee, 5, new EcoreLibraryOppositeProperty(CompanyPackage.Literals.DEPARTMENT__MANAGER));
		public static final @NonNull ExecutorProperty _Employee__Employee__mentor = new ExecutorPropertyWithImplementation("Employee", Types._Employee, 6, new EcoreLibraryOppositeProperty(CompanyPackage.Literals.EMPLOYEE__MENTOR));
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CompanyTables::Properties and all preceding sub-packages.
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

		private static final @NonNull ExecutorFragment @NonNull [] _Company =
		{
			Fragments._Company__OclAny /* 0 */,
			Fragments._Company__OclElement /* 1 */,
			Fragments._Company__Visitable /* 2 */,
			Fragments._Company__Company /* 3 */
		};
		private static final int @NonNull [] __Company = { 1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Department =
		{
			Fragments._Department__OclAny /* 0 */,
			Fragments._Department__OclElement /* 1 */,
			Fragments._Department__Visitable /* 2 */,
			Fragments._Department__Department /* 3 */
		};
		private static final int @NonNull [] __Department = { 1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Employee =
		{
			Fragments._Employee__OclAny /* 0 */,
			Fragments._Employee__OclElement /* 1 */,
			Fragments._Employee__Visitable /* 2 */,
			Fragments._Employee__Employee /* 3 */
		};
		private static final int @NonNull [] __Employee = { 1,1,1,1 };

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
			Types._Company.initFragments(_Company, __Company);
			Types._Department.initFragments(_Department, __Department);
			Types._Employee.initFragments(_Employee, __Employee);
			Types._Visitable.initFragments(_Visitable, __Visitable);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CompanyTables::TypeFragments and all preceding sub-packages.
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

		private static final @NonNull ExecutorOperation @NonNull [] _Company__Company = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Company__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Company__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Company__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Department__Department = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Department__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Department__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Department__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Employee__Employee = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Employee__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Employee__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Employee__Visitable = {};

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
			Fragments._Company__Company.initOperations(_Company__Company);
			Fragments._Company__OclAny.initOperations(_Company__OclAny);
			Fragments._Company__OclElement.initOperations(_Company__OclElement);
			Fragments._Company__Visitable.initOperations(_Company__Visitable);

			Fragments._Department__Department.initOperations(_Department__Department);
			Fragments._Department__OclAny.initOperations(_Department__OclAny);
			Fragments._Department__OclElement.initOperations(_Department__OclElement);
			Fragments._Department__Visitable.initOperations(_Department__Visitable);

			Fragments._Employee__Employee.initOperations(_Employee__Employee);
			Fragments._Employee__OclAny.initOperations(_Employee__OclAny);
			Fragments._Employee__OclElement.initOperations(_Employee__OclElement);
			Fragments._Employee__Visitable.initOperations(_Employee__Visitable);

			Fragments._Visitable__OclAny.initOperations(_Visitable__OclAny);
			Fragments._Visitable__OclElement.initOperations(_Visitable__OclElement);
			Fragments._Visitable__Visitable.initOperations(_Visitable__Visitable);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CompanyTables::FragmentOperations and all preceding sub-packages.
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

		private static final @NonNull ExecutorProperty @NonNull [] _Company = {
			CompanyTables.Properties._Company__depts,
			CompanyTables.Properties._Company__name
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Department = {
			CompanyTables.Properties._Department__employees,
			CompanyTables.Properties._Department__manager,
			CompanyTables.Properties._Department__name,
			CompanyTables.Properties._Department__subdepts
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Employee = {
			CompanyTables.Properties._Employee__address,
			CompanyTables.Properties._Employee__mentor,
			CompanyTables.Properties._Employee__name,
			CompanyTables.Properties._Employee__salary
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Visitable = {};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._Company__Company.initProperties(_Company);
			Fragments._Department__Department.initProperties(_Department);
			Fragments._Employee__Employee.initProperties(_Employee);
			Fragments._Visitable__Visitable.initProperties(_Visitable);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CompanyTables::FragmentProperties and all preceding sub-packages.
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
		 * Force initialization of the fields of CompanyTables::EnumerationLiterals and all preceding sub-packages.
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
