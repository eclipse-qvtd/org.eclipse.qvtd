/*******************************************************************************
 * <copyright>
 * 
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 *   /org.eclipse.qvtd.pivot.qvtschedule/model/QVTschedule.ecore
 * using:
 *   /org.eclipse.qvtd.pivot.qvtschedule/model/QVTschedule.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorEnumeration;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorEnumerationLiteral;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorFragment;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorOperation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorType;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables;

/**
 * QVTscheduleTables provides the dispatch tables for the qvtschedule for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
@SuppressWarnings("nls")
public class QVTscheduleTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final @NonNull EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(QVTschedulePackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final @NonNull ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2017/QVTschedule", null, org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Role = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Role", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull EnumerationId ENUMid_Phase = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getEnumerationId("Phase");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull EnumerationLiteralId ELITid_CONSTANT = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId("CONSTANT");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull EnumerationLiteralId ELITid_LOADED = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId("LOADED");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull EnumerationLiteralId ELITid_PREDICATED = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId("PREDICATED");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull EnumerationLiteralId ELITid_REALIZED = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId("REALIZED");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull EnumerationLiteralId ELITid_SPECULATED = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId("SPECULATED");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull EnumerationLiteralId ELITid_SPECULATION = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId("SPECULATION");

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			QVTscheduleTables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTscheduleTables::TypeParameters and all preceding sub-packages.
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

		public static final @NonNull EcoreExecutorType _EdgeRole = new EcoreExecutorType(QVTschedulePackage.Literals.EDGE_ROLE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _NodeRole = new EcoreExecutorType(QVTschedulePackage.Literals.NODE_ROLE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorEnumeration _Phase = new EcoreExecutorEnumeration(QVTschedulePackage.Literals.PHASE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Role = new EcoreExecutorType(QVTschedulePackage.Literals.ROLE, PACKAGE, 0 | ExecutorType.ABSTRACT);

		private static final @NonNull EcoreExecutorType @NonNull [] types = {
			_EdgeRole,
			_NodeRole,
			_Phase,
			_Role
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTscheduleTables::Types and all preceding sub-packages.
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

		private static final @NonNull ExecutorFragment _EdgeRole__EdgeRole = new ExecutorFragment(Types._EdgeRole, QVTscheduleTables.Types._EdgeRole);
		private static final @NonNull ExecutorFragment _EdgeRole__Element = new ExecutorFragment(Types._EdgeRole, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _EdgeRole__OclAny = new ExecutorFragment(Types._EdgeRole, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _EdgeRole__OclElement = new ExecutorFragment(Types._EdgeRole, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _EdgeRole__Role = new ExecutorFragment(Types._EdgeRole, QVTscheduleTables.Types._Role);
		private static final @NonNull ExecutorFragment _EdgeRole__Visitable = new ExecutorFragment(Types._EdgeRole, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _NodeRole__Element = new ExecutorFragment(Types._NodeRole, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _NodeRole__NodeRole = new ExecutorFragment(Types._NodeRole, QVTscheduleTables.Types._NodeRole);
		private static final @NonNull ExecutorFragment _NodeRole__OclAny = new ExecutorFragment(Types._NodeRole, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NodeRole__OclElement = new ExecutorFragment(Types._NodeRole, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _NodeRole__Role = new ExecutorFragment(Types._NodeRole, QVTscheduleTables.Types._Role);
		private static final @NonNull ExecutorFragment _NodeRole__Visitable = new ExecutorFragment(Types._NodeRole, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Phase__OclAny = new ExecutorFragment(Types._Phase, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Phase__OclElement = new ExecutorFragment(Types._Phase, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Phase__OclEnumeration = new ExecutorFragment(Types._Phase, OCLstdlibTables.Types._OclEnumeration);
		private static final @NonNull ExecutorFragment _Phase__OclType = new ExecutorFragment(Types._Phase, OCLstdlibTables.Types._OclType);
		private static final @NonNull ExecutorFragment _Phase__Phase = new ExecutorFragment(Types._Phase, QVTscheduleTables.Types._Phase);

		private static final @NonNull ExecutorFragment _Role__Element = new ExecutorFragment(Types._Role, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Role__OclAny = new ExecutorFragment(Types._Role, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Role__OclElement = new ExecutorFragment(Types._Role, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Role__Role = new ExecutorFragment(Types._Role, QVTscheduleTables.Types._Role);
		private static final @NonNull ExecutorFragment _Role__Visitable = new ExecutorFragment(Types._Role, PivotTables.Types._Visitable);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTscheduleTables::Fragments and all preceding sub-packages.
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
		 * Force initialization of the fields of QVTscheduleTables::Parameters and all preceding sub-packages.
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
		 * Force initialization of the fields of QVTscheduleTables::Operations and all preceding sub-packages.
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


		public static final @NonNull ExecutorProperty _Role__constant = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROLE__CONSTANT, Types._Role, 0);
		public static final @NonNull ExecutorProperty _Role__loaded = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROLE__LOADED, Types._Role, 1);
		public static final @NonNull ExecutorProperty _Role__new = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROLE__NEW, Types._Role, 2);
		public static final @NonNull ExecutorProperty _Role__old = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROLE__OLD, Types._Role, 3);
		public static final @NonNull ExecutorProperty _Role__phase = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROLE__PHASE, Types._Role, 4);
		public static final @NonNull ExecutorProperty _Role__predicated = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROLE__PREDICATED, Types._Role, 5);
		public static final @NonNull ExecutorProperty _Role__realized = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROLE__REALIZED, Types._Role, 6);
		public static final @NonNull ExecutorProperty _Role__speculated = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROLE__SPECULATED, Types._Role, 7);
		public static final @NonNull ExecutorProperty _Role__speculation = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROLE__SPECULATION, Types._Role, 8);
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTscheduleTables::Properties and all preceding sub-packages.
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

		private static final @NonNull ExecutorFragment @NonNull [] _EdgeRole =
		{
			Fragments._EdgeRole__OclAny /* 0 */,
			Fragments._EdgeRole__OclElement /* 1 */,
			Fragments._EdgeRole__Visitable /* 2 */,
			Fragments._EdgeRole__Element /* 3 */,
			Fragments._EdgeRole__Role /* 4 */,
			Fragments._EdgeRole__EdgeRole /* 5 */
		};
		private static final int @NonNull [] __EdgeRole = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _NodeRole =
		{
			Fragments._NodeRole__OclAny /* 0 */,
			Fragments._NodeRole__OclElement /* 1 */,
			Fragments._NodeRole__Visitable /* 2 */,
			Fragments._NodeRole__Element /* 3 */,
			Fragments._NodeRole__Role /* 4 */,
			Fragments._NodeRole__NodeRole /* 5 */
		};
		private static final int @NonNull [] __NodeRole = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Phase =
		{
			Fragments._Phase__OclAny /* 0 */,
			Fragments._Phase__OclElement /* 1 */,
			Fragments._Phase__OclType /* 2 */,
			Fragments._Phase__OclEnumeration /* 3 */,
			Fragments._Phase__Phase /* 4 */
		};
		private static final int @NonNull [] __Phase = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Role =
		{
			Fragments._Role__OclAny /* 0 */,
			Fragments._Role__OclElement /* 1 */,
			Fragments._Role__Visitable /* 2 */,
			Fragments._Role__Element /* 3 */,
			Fragments._Role__Role /* 4 */
		};
		private static final int @NonNull [] __Role = { 1,1,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._EdgeRole.initFragments(_EdgeRole, __EdgeRole);
			Types._NodeRole.initFragments(_NodeRole, __NodeRole);
			Types._Phase.initFragments(_Phase, __Phase);
			Types._Role.initFragments(_Role, __Role);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTscheduleTables::TypeFragments and all preceding sub-packages.
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

		private static final @NonNull ExecutorOperation @NonNull [] _EdgeRole__EdgeRole = {};
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeRole__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeRole__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeRole__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeRole__Role = {};
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeRole__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _NodeRole__NodeRole = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NodeRole__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NodeRole__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _NodeRole__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NodeRole__Role = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NodeRole__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Phase__Phase = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Phase__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Phase__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Phase__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Phase__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _Role__Role = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Role__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Role__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Role__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Role__Visitable = {};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._EdgeRole__EdgeRole.initOperations(_EdgeRole__EdgeRole);
			Fragments._EdgeRole__Element.initOperations(_EdgeRole__Element);
			Fragments._EdgeRole__OclAny.initOperations(_EdgeRole__OclAny);
			Fragments._EdgeRole__OclElement.initOperations(_EdgeRole__OclElement);
			Fragments._EdgeRole__Role.initOperations(_EdgeRole__Role);
			Fragments._EdgeRole__Visitable.initOperations(_EdgeRole__Visitable);

			Fragments._NodeRole__Element.initOperations(_NodeRole__Element);
			Fragments._NodeRole__NodeRole.initOperations(_NodeRole__NodeRole);
			Fragments._NodeRole__OclAny.initOperations(_NodeRole__OclAny);
			Fragments._NodeRole__OclElement.initOperations(_NodeRole__OclElement);
			Fragments._NodeRole__Role.initOperations(_NodeRole__Role);
			Fragments._NodeRole__Visitable.initOperations(_NodeRole__Visitable);

			Fragments._Phase__OclAny.initOperations(_Phase__OclAny);
			Fragments._Phase__OclElement.initOperations(_Phase__OclElement);
			Fragments._Phase__OclEnumeration.initOperations(_Phase__OclEnumeration);
			Fragments._Phase__OclType.initOperations(_Phase__OclType);
			Fragments._Phase__Phase.initOperations(_Phase__Phase);

			Fragments._Role__Element.initOperations(_Role__Element);
			Fragments._Role__OclAny.initOperations(_Role__OclAny);
			Fragments._Role__OclElement.initOperations(_Role__OclElement);
			Fragments._Role__Role.initOperations(_Role__Role);
			Fragments._Role__Visitable.initOperations(_Role__Visitable);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTscheduleTables::FragmentOperations and all preceding sub-packages.
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

		private static final @NonNull ExecutorProperty @NonNull [] _EdgeRole = {
			QVTscheduleTables.Properties._Role__constant,
			QVTscheduleTables.Properties._Role__loaded,
			QVTscheduleTables.Properties._Role__new,
			QVTscheduleTables.Properties._Role__old,
			QVTscheduleTables.Properties._Role__phase,
			QVTscheduleTables.Properties._Role__predicated,
			QVTscheduleTables.Properties._Role__realized,
			QVTscheduleTables.Properties._Role__speculated,
			QVTscheduleTables.Properties._Role__speculation
		};

		private static final @NonNull ExecutorProperty @NonNull [] _NodeRole = {
			QVTscheduleTables.Properties._Role__constant,
			QVTscheduleTables.Properties._Role__loaded,
			QVTscheduleTables.Properties._Role__new,
			QVTscheduleTables.Properties._Role__old,
			QVTscheduleTables.Properties._Role__phase,
			QVTscheduleTables.Properties._Role__predicated,
			QVTscheduleTables.Properties._Role__realized,
			QVTscheduleTables.Properties._Role__speculated,
			QVTscheduleTables.Properties._Role__speculation
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Phase = {};

		private static final @NonNull ExecutorProperty @NonNull [] _Role = {
			QVTscheduleTables.Properties._Role__constant,
			QVTscheduleTables.Properties._Role__loaded,
			QVTscheduleTables.Properties._Role__new,
			QVTscheduleTables.Properties._Role__old,
			QVTscheduleTables.Properties._Role__phase,
			QVTscheduleTables.Properties._Role__predicated,
			QVTscheduleTables.Properties._Role__realized,
			QVTscheduleTables.Properties._Role__speculated,
			QVTscheduleTables.Properties._Role__speculation
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._EdgeRole__EdgeRole.initProperties(_EdgeRole);
			Fragments._NodeRole__NodeRole.initProperties(_NodeRole);
			Fragments._Phase__Phase.initProperties(_Phase);
			Fragments._Role__Role.initProperties(_Role);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTscheduleTables::FragmentProperties and all preceding sub-packages.
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

		public static final @NonNull EcoreExecutorEnumerationLiteral _Phase__CONSTANT = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.PHASE.getEEnumLiteral("CONSTANT"), Types._Phase, 0);
		public static final @NonNull EcoreExecutorEnumerationLiteral _Phase__LOADED = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.PHASE.getEEnumLiteral("LOADED"), Types._Phase, 1);
		public static final @NonNull EcoreExecutorEnumerationLiteral _Phase__REALIZED = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.PHASE.getEEnumLiteral("REALIZED"), Types._Phase, 2);
		public static final @NonNull EcoreExecutorEnumerationLiteral _Phase__PREDICATED = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.PHASE.getEEnumLiteral("PREDICATED"), Types._Phase, 3);
		public static final @NonNull EcoreExecutorEnumerationLiteral _Phase__SPECULATION = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.PHASE.getEEnumLiteral("SPECULATION"), Types._Phase, 4);
		public static final @NonNull EcoreExecutorEnumerationLiteral _Phase__SPECULATED = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.PHASE.getEEnumLiteral("SPECULATED"), Types._Phase, 5);
		public static final @NonNull EcoreExecutorEnumerationLiteral _Phase__OTHER = new EcoreExecutorEnumerationLiteral(QVTschedulePackage.Literals.PHASE.getEEnumLiteral("OTHER"), Types._Phase, 6);
		private static final @NonNull EcoreExecutorEnumerationLiteral @NonNull [] _Phase = {
			_Phase__CONSTANT,
			_Phase__LOADED,
			_Phase__REALIZED,
			_Phase__PREDICATED,
			_Phase__SPECULATION,
			_Phase__SPECULATED,
			_Phase__OTHER
		};

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {
			Types._Phase.initLiterals(_Phase);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTscheduleTables::EnumerationLiterals and all preceding sub-packages.
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
