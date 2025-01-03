/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2013, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 *   /org.eclipse.qvtd.pivot.qvttemplate/model/QVTtemplate.ecore
 * using:
 *   /org.eclipse.qvtd.pivot.qvttemplate/model/QVTtemplate.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvttemplate;

import java.lang.String;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorFragment;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorOperation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorType;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.AbstractTables;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
// import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;
// import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables;

/**
 * QVTtemplateTables provides the dispatch tables for the qvttemplate for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
public class QVTtemplateTables extends AbstractTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final @NonNull EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(QVTtemplatePackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final @NonNull ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTtemplate = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTtemplate", null, QVTtemplatePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_BooleanType = QVTtemplateTables.PACKid_$metamodel$.getClassId("BooleanType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = QVTtemplateTables.PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CollectionTemplateExp = QVTtemplateTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTtemplate.getClassId("CollectionTemplateExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CollectionType = QVTtemplateTables.PACKid_$metamodel$.getClassId("CollectionType", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OCLExpression = QVTtemplateTables.PACKid_$metamodel$.getClassId("OCLExpression", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ObjectTemplateExp = QVTtemplateTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTtemplate.getClassId("ObjectTemplateExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Property = QVTtemplateTables.PACKid_$metamodel$.getClassId("Property", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_PropertyTemplateItem = QVTtemplateTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTtemplate.getClassId("PropertyTemplateItem", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TemplateExp = QVTtemplateTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTtemplate.getClassId("TemplateExp", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Type = QVTtemplateTables.PACKid_$metamodel$.getClassId("Type", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Variable = QVTtemplateTables.PACKid_$metamodel$.getClassId("Variable", 0);
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_0 = ValueUtil.integerValueOf("0");
	public static final /*@NonInvalid*/ @NonNull TuplePartId PARTid_ = IdManager.getTuplePartId(0, "message", TypeId.STRING);
	public static final /*@NonInvalid*/ @NonNull TuplePartId PARTid__0 = IdManager.getTuplePartId(1, "status", TypeId.BOOLEAN);
	public static final /*@NonInvalid*/ @NonNull String STR__32_must_32_conform_32_to_32 = " must conform to ";
	public static final /*@NonInvalid*/ @NonNull String STR__32_or_32_vice_m_versa = " or vice-versa";
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_OCLExpression = TypeId.SET.getSpecializedId(QVTtemplateTables.CLSSid_OCLExpression, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_PropertyTemplateItem = TypeId.SET.getSpecializedId(QVTtemplateTables.CLSSid_PropertyTemplateItem, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull TupleTypeId TUPLid_ = IdManager.getTupleTypeId("Tuple", QVTtemplateTables.PARTid_, QVTtemplateTables.PARTid__0);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			QVTtemplateTables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTtemplateTables::TypeParameters and all preceding sub-packages.
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

		public static final @NonNull EcoreExecutorType _CollectionTemplateExp = new EcoreExecutorType(QVTtemplatePackage.Literals.COLLECTION_TEMPLATE_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ObjectTemplateExp = new EcoreExecutorType(QVTtemplatePackage.Literals.OBJECT_TEMPLATE_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _PropertyTemplateItem = new EcoreExecutorType(QVTtemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TemplateExp = new EcoreExecutorType(QVTtemplatePackage.Literals.TEMPLATE_EXP, PACKAGE, 0 | ExecutorType.ABSTRACT);

		private static final @NonNull EcoreExecutorType @NonNull [] types = {
			_CollectionTemplateExp,
			_ObjectTemplateExp,
			_PropertyTemplateItem,
			_TemplateExp
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTtemplateTables::Types and all preceding sub-packages.
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

		private static final @NonNull ExecutorFragment _CollectionTemplateExp__CollectionTemplateExp = new ExecutorFragment(Types._CollectionTemplateExp, QVTtemplateTables.Types._CollectionTemplateExp);
		private static final @NonNull ExecutorFragment _CollectionTemplateExp__Element = new ExecutorFragment(Types._CollectionTemplateExp, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _CollectionTemplateExp__LiteralExp = new ExecutorFragment(Types._CollectionTemplateExp, PivotTables.Types._LiteralExp);
		private static final @NonNull ExecutorFragment _CollectionTemplateExp__NamedElement = new ExecutorFragment(Types._CollectionTemplateExp, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _CollectionTemplateExp__OCLExpression = new ExecutorFragment(Types._CollectionTemplateExp, PivotTables.Types._OCLExpression);
		private static final @NonNull ExecutorFragment _CollectionTemplateExp__OclAny = new ExecutorFragment(Types._CollectionTemplateExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _CollectionTemplateExp__OclElement = new ExecutorFragment(Types._CollectionTemplateExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _CollectionTemplateExp__ReferringElement = new ExecutorFragment(Types._CollectionTemplateExp, PivotTables.Types._ReferringElement);
		private static final @NonNull ExecutorFragment _CollectionTemplateExp__TemplateExp = new ExecutorFragment(Types._CollectionTemplateExp, QVTtemplateTables.Types._TemplateExp);
		private static final @NonNull ExecutorFragment _CollectionTemplateExp__TypedElement = new ExecutorFragment(Types._CollectionTemplateExp, PivotTables.Types._TypedElement);

		private static final @NonNull ExecutorFragment _ObjectTemplateExp__Element = new ExecutorFragment(Types._ObjectTemplateExp, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ObjectTemplateExp__LiteralExp = new ExecutorFragment(Types._ObjectTemplateExp, PivotTables.Types._LiteralExp);
		private static final @NonNull ExecutorFragment _ObjectTemplateExp__NamedElement = new ExecutorFragment(Types._ObjectTemplateExp, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _ObjectTemplateExp__OCLExpression = new ExecutorFragment(Types._ObjectTemplateExp, PivotTables.Types._OCLExpression);
		private static final @NonNull ExecutorFragment _ObjectTemplateExp__ObjectTemplateExp = new ExecutorFragment(Types._ObjectTemplateExp, QVTtemplateTables.Types._ObjectTemplateExp);
		private static final @NonNull ExecutorFragment _ObjectTemplateExp__OclAny = new ExecutorFragment(Types._ObjectTemplateExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ObjectTemplateExp__OclElement = new ExecutorFragment(Types._ObjectTemplateExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _ObjectTemplateExp__ReferringElement = new ExecutorFragment(Types._ObjectTemplateExp, PivotTables.Types._ReferringElement);
		private static final @NonNull ExecutorFragment _ObjectTemplateExp__TemplateExp = new ExecutorFragment(Types._ObjectTemplateExp, QVTtemplateTables.Types._TemplateExp);
		private static final @NonNull ExecutorFragment _ObjectTemplateExp__TypedElement = new ExecutorFragment(Types._ObjectTemplateExp, PivotTables.Types._TypedElement);

		private static final @NonNull ExecutorFragment _PropertyTemplateItem__Element = new ExecutorFragment(Types._PropertyTemplateItem, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _PropertyTemplateItem__OclAny = new ExecutorFragment(Types._PropertyTemplateItem, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _PropertyTemplateItem__OclElement = new ExecutorFragment(Types._PropertyTemplateItem, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _PropertyTemplateItem__PropertyTemplateItem = new ExecutorFragment(Types._PropertyTemplateItem, QVTtemplateTables.Types._PropertyTemplateItem);
		private static final @NonNull ExecutorFragment _PropertyTemplateItem__ReferringElement = new ExecutorFragment(Types._PropertyTemplateItem, PivotTables.Types._ReferringElement);

		private static final @NonNull ExecutorFragment _TemplateExp__Element = new ExecutorFragment(Types._TemplateExp, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _TemplateExp__LiteralExp = new ExecutorFragment(Types._TemplateExp, PivotTables.Types._LiteralExp);
		private static final @NonNull ExecutorFragment _TemplateExp__NamedElement = new ExecutorFragment(Types._TemplateExp, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _TemplateExp__OCLExpression = new ExecutorFragment(Types._TemplateExp, PivotTables.Types._OCLExpression);
		private static final @NonNull ExecutorFragment _TemplateExp__OclAny = new ExecutorFragment(Types._TemplateExp, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _TemplateExp__OclElement = new ExecutorFragment(Types._TemplateExp, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _TemplateExp__ReferringElement = new ExecutorFragment(Types._TemplateExp, PivotTables.Types._ReferringElement);
		private static final @NonNull ExecutorFragment _TemplateExp__TemplateExp = new ExecutorFragment(Types._TemplateExp, QVTtemplateTables.Types._TemplateExp);
		private static final @NonNull ExecutorFragment _TemplateExp__TypedElement = new ExecutorFragment(Types._TemplateExp, PivotTables.Types._TypedElement);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTtemplateTables::Fragments and all preceding sub-packages.
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
		 * Force initialization of the fields of QVTtemplateTables::Parameters and all preceding sub-packages.
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
		 * Force initialization of the fields of QVTtemplateTables::Operations and all preceding sub-packages.
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

		public static final @NonNull ExecutorProperty _CollectionTemplateExp__member = new EcoreExecutorProperty(QVTtemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER, Types._CollectionTemplateExp, 0);
		public static final @NonNull ExecutorProperty _CollectionTemplateExp__referredCollectionType = new EcoreExecutorProperty(QVTtemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__REFERRED_COLLECTION_TYPE, Types._CollectionTemplateExp, 1);
		public static final @NonNull ExecutorProperty _CollectionTemplateExp__rest = new EcoreExecutorProperty(QVTtemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__REST, Types._CollectionTemplateExp, 2);

		public static final @NonNull ExecutorProperty _ObjectTemplateExp__part = new EcoreExecutorProperty(QVTtemplatePackage.Literals.OBJECT_TEMPLATE_EXP__PART, Types._ObjectTemplateExp, 0);
		public static final @NonNull ExecutorProperty _ObjectTemplateExp__referredClass = new EcoreExecutorProperty(QVTtemplatePackage.Literals.OBJECT_TEMPLATE_EXP__REFERRED_CLASS, Types._ObjectTemplateExp, 1);

		public static final @NonNull ExecutorProperty _PropertyTemplateItem__isOpposite = new EcoreExecutorProperty(QVTtemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__IS_OPPOSITE, Types._PropertyTemplateItem, 0);
		public static final @NonNull ExecutorProperty _PropertyTemplateItem__objContainer = new EcoreExecutorProperty(QVTtemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER, Types._PropertyTemplateItem, 1);
		public static final @NonNull ExecutorProperty _PropertyTemplateItem__referredProperty = new EcoreExecutorProperty(QVTtemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY, Types._PropertyTemplateItem, 2);
		public static final @NonNull ExecutorProperty _PropertyTemplateItem__resolvedProperty = new EcoreExecutorProperty(QVTtemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__RESOLVED_PROPERTY, Types._PropertyTemplateItem, 3);
		public static final @NonNull ExecutorProperty _PropertyTemplateItem__value = new EcoreExecutorProperty(QVTtemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE, Types._PropertyTemplateItem, 4);

		public static final @NonNull ExecutorProperty _TemplateExp__bindsTo = new EcoreExecutorProperty(QVTtemplatePackage.Literals.TEMPLATE_EXP__BINDS_TO, Types._TemplateExp, 0);
		public static final @NonNull ExecutorProperty _TemplateExp__where = new EcoreExecutorProperty(QVTtemplatePackage.Literals.TEMPLATE_EXP__WHERE, Types._TemplateExp, 1);
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTtemplateTables::Properties and all preceding sub-packages.
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

		private static final @NonNull ExecutorFragment @NonNull [] _CollectionTemplateExp =
			{
				Fragments._CollectionTemplateExp__OclAny /* 0 */,
				Fragments._CollectionTemplateExp__OclElement /* 1 */,
				Fragments._CollectionTemplateExp__Element /* 2 */,
				Fragments._CollectionTemplateExp__ReferringElement /* 2 */,
				Fragments._CollectionTemplateExp__NamedElement /* 3 */,
				Fragments._CollectionTemplateExp__TypedElement /* 4 */,
				Fragments._CollectionTemplateExp__OCLExpression /* 5 */,
				Fragments._CollectionTemplateExp__LiteralExp /* 6 */,
				Fragments._CollectionTemplateExp__TemplateExp /* 7 */,
				Fragments._CollectionTemplateExp__CollectionTemplateExp /* 8 */
			};
		private static final int @NonNull [] __CollectionTemplateExp = { 1,1,2,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ObjectTemplateExp =
			{
				Fragments._ObjectTemplateExp__OclAny /* 0 */,
				Fragments._ObjectTemplateExp__OclElement /* 1 */,
				Fragments._ObjectTemplateExp__Element /* 2 */,
				Fragments._ObjectTemplateExp__ReferringElement /* 2 */,
				Fragments._ObjectTemplateExp__NamedElement /* 3 */,
				Fragments._ObjectTemplateExp__TypedElement /* 4 */,
				Fragments._ObjectTemplateExp__OCLExpression /* 5 */,
				Fragments._ObjectTemplateExp__LiteralExp /* 6 */,
				Fragments._ObjectTemplateExp__TemplateExp /* 7 */,
				Fragments._ObjectTemplateExp__ObjectTemplateExp /* 8 */
			};
		private static final int @NonNull [] __ObjectTemplateExp = { 1,1,2,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _PropertyTemplateItem =
			{
				Fragments._PropertyTemplateItem__OclAny /* 0 */,
				Fragments._PropertyTemplateItem__OclElement /* 1 */,
				Fragments._PropertyTemplateItem__Element /* 2 */,
				Fragments._PropertyTemplateItem__ReferringElement /* 2 */,
				Fragments._PropertyTemplateItem__PropertyTemplateItem /* 3 */
			};
		private static final int @NonNull [] __PropertyTemplateItem = { 1,1,2,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _TemplateExp =
			{
				Fragments._TemplateExp__OclAny /* 0 */,
				Fragments._TemplateExp__OclElement /* 1 */,
				Fragments._TemplateExp__Element /* 2 */,
				Fragments._TemplateExp__ReferringElement /* 2 */,
				Fragments._TemplateExp__NamedElement /* 3 */,
				Fragments._TemplateExp__TypedElement /* 4 */,
				Fragments._TemplateExp__OCLExpression /* 5 */,
				Fragments._TemplateExp__LiteralExp /* 6 */,
				Fragments._TemplateExp__TemplateExp /* 7 */
			};
		private static final int @NonNull [] __TemplateExp = { 1,1,2,1,1,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._CollectionTemplateExp.initFragments(_CollectionTemplateExp, __CollectionTemplateExp);
			Types._ObjectTemplateExp.initFragments(_ObjectTemplateExp, __ObjectTemplateExp);
			Types._PropertyTemplateItem.initFragments(_PropertyTemplateItem, __PropertyTemplateItem);
			Types._TemplateExp.initFragments(_TemplateExp, __TemplateExp);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTtemplateTables::TypeFragments and all preceding sub-packages.
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

		private static final @NonNull ExecutorOperation @NonNull [] _CollectionTemplateExp__CollectionTemplateExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionTemplateExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionTemplateExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionTemplateExp__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionTemplateExp__OCLExpression = {
			PivotTables.Operations._OCLExpression__isNonNull /* isNonNull() */,
			PivotTables.Operations._OCLExpression__isNull /* isNull() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionTemplateExp__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionTemplateExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
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
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionTemplateExp__ReferringElement = {
			PivotTables.Operations._ReferringElement__getReferredElement /* getReferredElement() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionTemplateExp__TemplateExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CollectionTemplateExp__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _ObjectTemplateExp__ObjectTemplateExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ObjectTemplateExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ObjectTemplateExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ObjectTemplateExp__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ObjectTemplateExp__OCLExpression = {
			PivotTables.Operations._OCLExpression__isNonNull /* isNonNull() */,
			PivotTables.Operations._OCLExpression__isNull /* isNull() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ObjectTemplateExp__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ObjectTemplateExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
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
		private static final @NonNull ExecutorOperation @NonNull [] _ObjectTemplateExp__ReferringElement = {
			PivotTables.Operations._ReferringElement__getReferredElement /* getReferredElement() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ObjectTemplateExp__TemplateExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ObjectTemplateExp__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _PropertyTemplateItem__PropertyTemplateItem = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyTemplateItem__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyTemplateItem__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyTemplateItem__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
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
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyTemplateItem__ReferringElement = {
			PivotTables.Operations._ReferringElement__getReferredElement /* getReferredElement() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _TemplateExp__TemplateExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TemplateExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TemplateExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TemplateExp__NamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TemplateExp__OCLExpression = {
			PivotTables.Operations._OCLExpression__isNonNull /* isNonNull() */,
			PivotTables.Operations._OCLExpression__isNull /* isNull() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TemplateExp__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _TemplateExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
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
		private static final @NonNull ExecutorOperation @NonNull [] _TemplateExp__ReferringElement = {
			PivotTables.Operations._ReferringElement__getReferredElement /* getReferredElement() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TemplateExp__TypedElement = {
			PivotTables.Operations._TypedElement__CompatibleBody /* CompatibleBody(ValueSpecification[1]) */
		};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._CollectionTemplateExp__CollectionTemplateExp.initOperations(_CollectionTemplateExp__CollectionTemplateExp);
			Fragments._CollectionTemplateExp__Element.initOperations(_CollectionTemplateExp__Element);
			Fragments._CollectionTemplateExp__LiteralExp.initOperations(_CollectionTemplateExp__LiteralExp);
			Fragments._CollectionTemplateExp__NamedElement.initOperations(_CollectionTemplateExp__NamedElement);
			Fragments._CollectionTemplateExp__OCLExpression.initOperations(_CollectionTemplateExp__OCLExpression);
			Fragments._CollectionTemplateExp__OclAny.initOperations(_CollectionTemplateExp__OclAny);
			Fragments._CollectionTemplateExp__OclElement.initOperations(_CollectionTemplateExp__OclElement);
			Fragments._CollectionTemplateExp__ReferringElement.initOperations(_CollectionTemplateExp__ReferringElement);
			Fragments._CollectionTemplateExp__TemplateExp.initOperations(_CollectionTemplateExp__TemplateExp);
			Fragments._CollectionTemplateExp__TypedElement.initOperations(_CollectionTemplateExp__TypedElement);

			Fragments._ObjectTemplateExp__Element.initOperations(_ObjectTemplateExp__Element);
			Fragments._ObjectTemplateExp__LiteralExp.initOperations(_ObjectTemplateExp__LiteralExp);
			Fragments._ObjectTemplateExp__NamedElement.initOperations(_ObjectTemplateExp__NamedElement);
			Fragments._ObjectTemplateExp__OCLExpression.initOperations(_ObjectTemplateExp__OCLExpression);
			Fragments._ObjectTemplateExp__ObjectTemplateExp.initOperations(_ObjectTemplateExp__ObjectTemplateExp);
			Fragments._ObjectTemplateExp__OclAny.initOperations(_ObjectTemplateExp__OclAny);
			Fragments._ObjectTemplateExp__OclElement.initOperations(_ObjectTemplateExp__OclElement);
			Fragments._ObjectTemplateExp__ReferringElement.initOperations(_ObjectTemplateExp__ReferringElement);
			Fragments._ObjectTemplateExp__TemplateExp.initOperations(_ObjectTemplateExp__TemplateExp);
			Fragments._ObjectTemplateExp__TypedElement.initOperations(_ObjectTemplateExp__TypedElement);

			Fragments._PropertyTemplateItem__Element.initOperations(_PropertyTemplateItem__Element);
			Fragments._PropertyTemplateItem__OclAny.initOperations(_PropertyTemplateItem__OclAny);
			Fragments._PropertyTemplateItem__OclElement.initOperations(_PropertyTemplateItem__OclElement);
			Fragments._PropertyTemplateItem__PropertyTemplateItem.initOperations(_PropertyTemplateItem__PropertyTemplateItem);
			Fragments._PropertyTemplateItem__ReferringElement.initOperations(_PropertyTemplateItem__ReferringElement);

			Fragments._TemplateExp__Element.initOperations(_TemplateExp__Element);
			Fragments._TemplateExp__LiteralExp.initOperations(_TemplateExp__LiteralExp);
			Fragments._TemplateExp__NamedElement.initOperations(_TemplateExp__NamedElement);
			Fragments._TemplateExp__OCLExpression.initOperations(_TemplateExp__OCLExpression);
			Fragments._TemplateExp__OclAny.initOperations(_TemplateExp__OclAny);
			Fragments._TemplateExp__OclElement.initOperations(_TemplateExp__OclElement);
			Fragments._TemplateExp__ReferringElement.initOperations(_TemplateExp__ReferringElement);
			Fragments._TemplateExp__TemplateExp.initOperations(_TemplateExp__TemplateExp);
			Fragments._TemplateExp__TypedElement.initOperations(_TemplateExp__TypedElement);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTtemplateTables::FragmentOperations and all preceding sub-packages.
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

		private static final @NonNull ExecutorProperty @NonNull [] _CollectionTemplateExp = {
			PivotTables.Properties._Element__annotatingComments,
			QVTtemplateTables.Properties._TemplateExp__bindsTo,
			PivotTables.Properties._TypedElement__isMany,
			PivotTables.Properties._TypedElement__isRequired,
			QVTtemplateTables.Properties._CollectionTemplateExp__member,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTtemplateTables.Properties._CollectionTemplateExp__referredCollectionType,
			QVTtemplateTables.Properties._CollectionTemplateExp__rest,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._OCLExpression__typeValue,
			QVTtemplateTables.Properties._TemplateExp__where
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ObjectTemplateExp = {
			PivotTables.Properties._Element__annotatingComments,
			QVTtemplateTables.Properties._TemplateExp__bindsTo,
			PivotTables.Properties._TypedElement__isMany,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTtemplateTables.Properties._ObjectTemplateExp__part,
			QVTtemplateTables.Properties._ObjectTemplateExp__referredClass,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._OCLExpression__typeValue,
			QVTtemplateTables.Properties._TemplateExp__where
		};

		private static final @NonNull ExecutorProperty @NonNull [] _PropertyTemplateItem = {
			PivotTables.Properties._Element__annotatingComments,
			QVTtemplateTables.Properties._PropertyTemplateItem__isOpposite,
			QVTtemplateTables.Properties._PropertyTemplateItem__objContainer,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			QVTtemplateTables.Properties._PropertyTemplateItem__referredProperty,
			QVTtemplateTables.Properties._PropertyTemplateItem__resolvedProperty,
			QVTtemplateTables.Properties._PropertyTemplateItem__value
		};

		private static final @NonNull ExecutorProperty @NonNull [] _TemplateExp = {
			PivotTables.Properties._Element__annotatingComments,
			QVTtemplateTables.Properties._TemplateExp__bindsTo,
			PivotTables.Properties._TypedElement__isMany,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			PivotTables.Properties._Element__ownedAnnotations,
			PivotTables.Properties._Element__ownedComments,
			PivotTables.Properties._Element__ownedExtensions,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._OCLExpression__typeValue,
			QVTtemplateTables.Properties._TemplateExp__where
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._CollectionTemplateExp__CollectionTemplateExp.initProperties(_CollectionTemplateExp);
			Fragments._ObjectTemplateExp__ObjectTemplateExp.initProperties(_ObjectTemplateExp);
			Fragments._PropertyTemplateItem__PropertyTemplateItem.initProperties(_PropertyTemplateItem);
			Fragments._TemplateExp__TemplateExp.initProperties(_TemplateExp);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of QVTtemplateTables::FragmentProperties and all preceding sub-packages.
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
		 * Force initialization of the fields of QVTtemplateTables::EnumerationLiterals and all preceding sub-packages.
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
		new QVTtemplateTables();
	}

	private QVTtemplateTables() {
		super(QVTtemplatePackage.eNS_URI);
	}
}
