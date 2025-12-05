/*******************************************************************************
 * Copyright (c) 2016, 2025 Willink Transformations and others.
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
 *   /org.eclipse.qvtd.umlx/model/UMLX.ecore
 * using:
 *   /org.eclipse.qvtd.umlx/model/UMLX.genmodel
 *   org.eclipse.ocl.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.qvtd.umlx;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.ParameterTypes;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.flat.FlatClass;
import org.eclipse.ocl.pivot.flat.FlatFragment;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.PartId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.PartialStandardLibraryImpl;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.types.TemplateParameters;
import org.eclipse.ocl.pivot.utilities.AbstractTables;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
// import org.eclipse.qvtd.umlx.UMLXPackage;
// import org.eclipse.qvtd.umlx.UMLXTables;

/**
 * UMLXTables provides the dispatch tables for the umlx for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
public class UMLXTables extends AbstractTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The overall library of all packages and types.
	 */
	public static final PartialStandardLibraryImpl.@NonNull ReadOnly LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	The AS package for the UMLXPackage.eINSTANCE EPackage.
	 */
	public static final org.eclipse.ocl.pivot.@NonNull Package PACKAGE = LIBRARY.createPackage(UMLXPackage.eINSTANCE);

	/**
	 *	The AS model for the AS package and its additional orphans.
	 */
	public static final AbstractTables.@NonNull BuiltInModel MODEL = LIBRARY.createModel(PACKAGE);

	/**
	 *	The EMF Resource containing the AS model, its AS package and its additional orphans.
	 */
	public static final @NonNull Resource RESOURCE = LIBRARY.createResource(MODEL);

	/**
	 *	Constants used by auto-generated code.
	 */
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", "ecore", EcorePackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2016/UMLX", "umlx", UMLXPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Class = UMLXTables.PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_EAttribute = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EAttribute", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_EClass = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EClass", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_EClassifier = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EClassifier", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_EPackage = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EPackage", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_EReference = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EReference", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_EStructuralFeature = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EStructuralFeature", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelDiagram = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("RelDiagram", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelDomainNode = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("RelDomainNode", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelInvocationEdge = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("RelInvocationEdge", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelInvocationNode = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("RelInvocationNode", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelPatternEdge = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("RelPatternEdge", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_RelPatternNode = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("RelPatternNode", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TxDiagram = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("TxDiagram", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TxKeyNode = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("TxKeyNode", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TxPackageNode = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("TxPackageNode", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TxParameterNode = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("TxParameterNode", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TxPartNode = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("TxPartNode", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TxQueryNode = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("TxQueryNode", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TxTypedModelNode = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("TxTypedModelNode", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_UMLXModel = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("UMLXModel", 0);
	public static final /*@NonInvalid*/ @NonNull DataTypeId DATAid_EInt = UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EInt", 0);
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_0 = ValueUtil.integerValueOf("0");
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_1 = ValueUtil.integerValueOf("1");
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_PRIMid_String = TypeId.ORDERED_SET.getSpecializedId(TypeId.STRING, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull PartId PARTid_ = IdManager.getPartId(1, "status", TypeId.BOOLEAN, true);
	public static final /*@NonInvalid*/ @NonNull PartId PARTid__0 = IdManager.getPartId(0, "message", TypeId.STRING, true);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_PRIMid_String = TypeId.SEQUENCE.getSpecializedId(TypeId.STRING, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_PRIMid_String = TypeId.SET.getSpecializedId(TypeId.STRING, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull String STR_ = "";
	public static final /*@NonInvalid*/ @NonNull String STR_RelDiagram_c_c_RelPatternNodeNamesAreUnique_c = "RelDiagram::RelPatternNodeNamesAreUnique:";
	public static final /*@NonInvalid*/ @NonNull String STR_RelInvocationNode_c_c_CompatibleEdges_32 = "RelInvocationNode::CompatibleEdges ";
	public static final /*@NonInvalid*/ @NonNull String STR__32_39 = " \'";
	public static final /*@NonInvalid*/ @NonNull String STR__32_are_32_not_32_unique_32_for_32 = " are not unique for ";
	public static final /*@NonInvalid*/ @NonNull String STR__39 = "\'";
	public static final /*@NonInvalid*/ @NonNull String STR_quot = "/";
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_RelDomainNode = TypeId.BAG.getSpecializedId(UMLXTables.CLSSid_RelDomainNode, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_RelInvocationEdge = TypeId.BAG.getSpecializedId(UMLXTables.CLSSid_RelInvocationEdge, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_RelInvocationNode = TypeId.BAG.getSpecializedId(UMLXTables.CLSSid_RelInvocationNode, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId BAG_CLSSid_TxTypedModelNode = TypeId.BAG.getSpecializedId(UMLXTables.CLSSid_TxTypedModelNode, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_EClass = TypeId.ORDERED_SET.getSpecializedId(UMLXTables.CLSSid_EClass, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_EClassifier = TypeId.ORDERED_SET.getSpecializedId(UMLXTables.CLSSid_EClassifier, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_RelDiagram = TypeId.ORDERED_SET.getSpecializedId(UMLXTables.CLSSid_RelDiagram, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_RelDomainNode = TypeId.ORDERED_SET.getSpecializedId(UMLXTables.CLSSid_RelDomainNode, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_RelInvocationEdge = TypeId.ORDERED_SET.getSpecializedId(UMLXTables.CLSSid_RelInvocationEdge, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_RelInvocationNode = TypeId.ORDERED_SET.getSpecializedId(UMLXTables.CLSSid_RelInvocationNode, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_RelPatternEdge = TypeId.ORDERED_SET.getSpecializedId(UMLXTables.CLSSid_RelPatternEdge, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_RelPatternNode = TypeId.ORDERED_SET.getSpecializedId(UMLXTables.CLSSid_RelPatternNode, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_TxDiagram = TypeId.ORDERED_SET.getSpecializedId(UMLXTables.CLSSid_TxDiagram, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_TxKeyNode = TypeId.ORDERED_SET.getSpecializedId(UMLXTables.CLSSid_TxKeyNode, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_TxPackageNode = TypeId.ORDERED_SET.getSpecializedId(UMLXTables.CLSSid_TxPackageNode, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_TxParameterNode = TypeId.ORDERED_SET.getSpecializedId(UMLXTables.CLSSid_TxParameterNode, false, ValueUtil.ONE_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_TxPartNode = TypeId.ORDERED_SET.getSpecializedId(UMLXTables.CLSSid_TxPartNode, false, ValueUtil.ONE_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_TxQueryNode = TypeId.ORDERED_SET.getSpecializedId(UMLXTables.CLSSid_TxQueryNode, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_TxTypedModelNode = TypeId.ORDERED_SET.getSpecializedId(UMLXTables.CLSSid_TxTypedModelNode, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_EClassifier = TypeId.SEQUENCE.getSpecializedId(UMLXTables.CLSSid_EClassifier, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_EPackage = TypeId.SEQUENCE.getSpecializedId(UMLXTables.CLSSid_EPackage, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_RelPatternNode = TypeId.SEQUENCE.getSpecializedId(UMLXTables.CLSSid_RelPatternNode, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SEQ_CLSSid_RelPatternNode_0 = TypeId.SEQUENCE.getSpecializedId(UMLXTables.CLSSid_RelPatternNode, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_EClass = TypeId.SET.getSpecializedId(UMLXTables.CLSSid_EClass, true, ValueUtil.ONE_VALUE, ValueUtil.ONE_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_EClass_0 = TypeId.SET.getSpecializedId(UMLXTables.CLSSid_EClass, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_RelPatternNode = TypeId.SET.getSpecializedId(UMLXTables.CLSSid_RelPatternNode, false, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId SET_CLSSid_RelPatternNode_0 = TypeId.SET.getSpecializedId(UMLXTables.CLSSid_RelPatternNode, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ @NonNull TupleTypeId TUPLid_ = IdManager.getTupleTypeId(UMLXTables.PARTid__0, UMLXTables.PARTid_);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			UMLXTables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of UMLXTables::TypeParameters and all preceding sub-packages.
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

		public static final org.eclipse.ocl.pivot.@NonNull Class _RelDiagram = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.REL_DIAGRAM, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _RelDomainNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.REL_DOMAIN_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _RelEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.REL_EDGE, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _RelInvocationEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.REL_INVOCATION_EDGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _RelInvocationNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.REL_INVOCATION_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _RelNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.REL_NODE, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _RelPatternEdge = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.REL_PATTERN_EDGE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _RelPatternNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.REL_PATTERN_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _TxDiagram = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.TX_DIAGRAM, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _TxKeyNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.TX_KEY_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _TxNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.TX_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _TxPackageNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.TX_PACKAGE_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _TxParameterNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.TX_PARAMETER_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _TxPartNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.TX_PART_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _TxQueryNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.TX_QUERY_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _TxTypedModelNode = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.TX_TYPED_MODEL_NODE, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _UMLXElement = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.UMLX_ELEMENT, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _UMLXModel = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.UMLX_MODEL, null, 0);
		public static final org.eclipse.ocl.pivot.@NonNull Class _UMLXNamedElement = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.UMLX_NAMED_ELEMENT, null, 0 | FlatClass.ABSTRACT);
		public static final org.eclipse.ocl.pivot.@NonNull Class _UMLXTypedElement = LIBRARY.createClass(PivotPackage.Literals.CLASS, UMLXPackage.Literals.UMLX_TYPED_ELEMENT, null, 0 | FlatClass.ABSTRACT);

		private static final org.eclipse.ocl.pivot.@NonNull Class @NonNull [] types = {
			_RelDiagram,
			_RelDomainNode,
			_RelEdge,
			_RelInvocationEdge,
			_RelInvocationNode,
			_RelNode,
			_RelPatternEdge,
			_RelPatternNode,
			_TxDiagram,
			_TxKeyNode,
			_TxNode,
			_TxPackageNode,
			_TxParameterNode,
			_TxPartNode,
			_TxQueryNode,
			_TxTypedModelNode,
			_UMLXElement,
			_UMLXModel,
			_UMLXNamedElement,
			_UMLXTypedElement
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			LIBRARY.initPackage(PACKAGE, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of UMLXTables::Types and all preceding sub-packages.
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

		private static final @NonNull FlatFragment _RelDiagram__OclAny = LIBRARY.createFragment(Types._RelDiagram, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _RelDiagram__OclElement = LIBRARY.createFragment(Types._RelDiagram, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _RelDiagram__RelDiagram = LIBRARY.createFragment(Types._RelDiagram, Types._RelDiagram);
		private static final @NonNull FlatFragment _RelDiagram__UMLXElement = LIBRARY.createFragment(Types._RelDiagram, Types._UMLXElement);
		private static final @NonNull FlatFragment _RelDiagram__UMLXNamedElement = LIBRARY.createFragment(Types._RelDiagram, Types._UMLXNamedElement);

		private static final @NonNull FlatFragment _RelDomainNode__OclAny = LIBRARY.createFragment(Types._RelDomainNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _RelDomainNode__OclElement = LIBRARY.createFragment(Types._RelDomainNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _RelDomainNode__RelDomainNode = LIBRARY.createFragment(Types._RelDomainNode, Types._RelDomainNode);
		private static final @NonNull FlatFragment _RelDomainNode__RelNode = LIBRARY.createFragment(Types._RelDomainNode, Types._RelNode);
		private static final @NonNull FlatFragment _RelDomainNode__UMLXElement = LIBRARY.createFragment(Types._RelDomainNode, Types._UMLXElement);

		private static final @NonNull FlatFragment _RelEdge__OclAny = LIBRARY.createFragment(Types._RelEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _RelEdge__OclElement = LIBRARY.createFragment(Types._RelEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _RelEdge__RelEdge = LIBRARY.createFragment(Types._RelEdge, Types._RelEdge);
		private static final @NonNull FlatFragment _RelEdge__UMLXElement = LIBRARY.createFragment(Types._RelEdge, Types._UMLXElement);

		private static final @NonNull FlatFragment _RelInvocationEdge__OclAny = LIBRARY.createFragment(Types._RelInvocationEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _RelInvocationEdge__OclElement = LIBRARY.createFragment(Types._RelInvocationEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _RelInvocationEdge__RelEdge = LIBRARY.createFragment(Types._RelInvocationEdge, Types._RelEdge);
		private static final @NonNull FlatFragment _RelInvocationEdge__RelInvocationEdge = LIBRARY.createFragment(Types._RelInvocationEdge, Types._RelInvocationEdge);
		private static final @NonNull FlatFragment _RelInvocationEdge__UMLXElement = LIBRARY.createFragment(Types._RelInvocationEdge, Types._UMLXElement);

		private static final @NonNull FlatFragment _RelInvocationNode__OclAny = LIBRARY.createFragment(Types._RelInvocationNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _RelInvocationNode__OclElement = LIBRARY.createFragment(Types._RelInvocationNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _RelInvocationNode__RelInvocationNode = LIBRARY.createFragment(Types._RelInvocationNode, Types._RelInvocationNode);
		private static final @NonNull FlatFragment _RelInvocationNode__RelNode = LIBRARY.createFragment(Types._RelInvocationNode, Types._RelNode);
		private static final @NonNull FlatFragment _RelInvocationNode__UMLXElement = LIBRARY.createFragment(Types._RelInvocationNode, Types._UMLXElement);

		private static final @NonNull FlatFragment _RelNode__OclAny = LIBRARY.createFragment(Types._RelNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _RelNode__OclElement = LIBRARY.createFragment(Types._RelNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _RelNode__RelNode = LIBRARY.createFragment(Types._RelNode, Types._RelNode);
		private static final @NonNull FlatFragment _RelNode__UMLXElement = LIBRARY.createFragment(Types._RelNode, Types._UMLXElement);

		private static final @NonNull FlatFragment _RelPatternEdge__OclAny = LIBRARY.createFragment(Types._RelPatternEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _RelPatternEdge__OclElement = LIBRARY.createFragment(Types._RelPatternEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _RelPatternEdge__RelEdge = LIBRARY.createFragment(Types._RelPatternEdge, Types._RelEdge);
		private static final @NonNull FlatFragment _RelPatternEdge__RelPatternEdge = LIBRARY.createFragment(Types._RelPatternEdge, Types._RelPatternEdge);
		private static final @NonNull FlatFragment _RelPatternEdge__UMLXElement = LIBRARY.createFragment(Types._RelPatternEdge, Types._UMLXElement);

		private static final @NonNull FlatFragment _RelPatternNode__OclAny = LIBRARY.createFragment(Types._RelPatternNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _RelPatternNode__OclElement = LIBRARY.createFragment(Types._RelPatternNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _RelPatternNode__RelNode = LIBRARY.createFragment(Types._RelPatternNode, Types._RelNode);
		private static final @NonNull FlatFragment _RelPatternNode__RelPatternNode = LIBRARY.createFragment(Types._RelPatternNode, Types._RelPatternNode);
		private static final @NonNull FlatFragment _RelPatternNode__UMLXElement = LIBRARY.createFragment(Types._RelPatternNode, Types._UMLXElement);
		private static final @NonNull FlatFragment _RelPatternNode__UMLXNamedElement = LIBRARY.createFragment(Types._RelPatternNode, Types._UMLXNamedElement);
		private static final @NonNull FlatFragment _RelPatternNode__UMLXTypedElement = LIBRARY.createFragment(Types._RelPatternNode, Types._UMLXTypedElement);

		private static final @NonNull FlatFragment _TxDiagram__OclAny = LIBRARY.createFragment(Types._TxDiagram, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _TxDiagram__OclElement = LIBRARY.createFragment(Types._TxDiagram, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _TxDiagram__TxDiagram = LIBRARY.createFragment(Types._TxDiagram, Types._TxDiagram);
		private static final @NonNull FlatFragment _TxDiagram__UMLXElement = LIBRARY.createFragment(Types._TxDiagram, Types._UMLXElement);
		private static final @NonNull FlatFragment _TxDiagram__UMLXNamedElement = LIBRARY.createFragment(Types._TxDiagram, Types._UMLXNamedElement);

		private static final @NonNull FlatFragment _TxKeyNode__OclAny = LIBRARY.createFragment(Types._TxKeyNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _TxKeyNode__OclElement = LIBRARY.createFragment(Types._TxKeyNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _TxKeyNode__TxKeyNode = LIBRARY.createFragment(Types._TxKeyNode, Types._TxKeyNode);
		private static final @NonNull FlatFragment _TxKeyNode__TxNode = LIBRARY.createFragment(Types._TxKeyNode, Types._TxNode);
		private static final @NonNull FlatFragment _TxKeyNode__UMLXElement = LIBRARY.createFragment(Types._TxKeyNode, Types._UMLXElement);

		private static final @NonNull FlatFragment _TxNode__OclAny = LIBRARY.createFragment(Types._TxNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _TxNode__OclElement = LIBRARY.createFragment(Types._TxNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _TxNode__TxNode = LIBRARY.createFragment(Types._TxNode, Types._TxNode);
		private static final @NonNull FlatFragment _TxNode__UMLXElement = LIBRARY.createFragment(Types._TxNode, Types._UMLXElement);

		private static final @NonNull FlatFragment _TxPackageNode__OclAny = LIBRARY.createFragment(Types._TxPackageNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _TxPackageNode__OclElement = LIBRARY.createFragment(Types._TxPackageNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _TxPackageNode__TxNode = LIBRARY.createFragment(Types._TxPackageNode, Types._TxNode);
		private static final @NonNull FlatFragment _TxPackageNode__TxPackageNode = LIBRARY.createFragment(Types._TxPackageNode, Types._TxPackageNode);
		private static final @NonNull FlatFragment _TxPackageNode__UMLXElement = LIBRARY.createFragment(Types._TxPackageNode, Types._UMLXElement);

		private static final @NonNull FlatFragment _TxParameterNode__OclAny = LIBRARY.createFragment(Types._TxParameterNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _TxParameterNode__OclElement = LIBRARY.createFragment(Types._TxParameterNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _TxParameterNode__TxNode = LIBRARY.createFragment(Types._TxParameterNode, Types._TxNode);
		private static final @NonNull FlatFragment _TxParameterNode__TxParameterNode = LIBRARY.createFragment(Types._TxParameterNode, Types._TxParameterNode);
		private static final @NonNull FlatFragment _TxParameterNode__UMLXElement = LIBRARY.createFragment(Types._TxParameterNode, Types._UMLXElement);
		private static final @NonNull FlatFragment _TxParameterNode__UMLXNamedElement = LIBRARY.createFragment(Types._TxParameterNode, Types._UMLXNamedElement);
		private static final @NonNull FlatFragment _TxParameterNode__UMLXTypedElement = LIBRARY.createFragment(Types._TxParameterNode, Types._UMLXTypedElement);

		private static final @NonNull FlatFragment _TxPartNode__OclAny = LIBRARY.createFragment(Types._TxPartNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _TxPartNode__OclElement = LIBRARY.createFragment(Types._TxPartNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _TxPartNode__TxNode = LIBRARY.createFragment(Types._TxPartNode, Types._TxNode);
		private static final @NonNull FlatFragment _TxPartNode__TxPartNode = LIBRARY.createFragment(Types._TxPartNode, Types._TxPartNode);
		private static final @NonNull FlatFragment _TxPartNode__UMLXElement = LIBRARY.createFragment(Types._TxPartNode, Types._UMLXElement);

		private static final @NonNull FlatFragment _TxQueryNode__OclAny = LIBRARY.createFragment(Types._TxQueryNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _TxQueryNode__OclElement = LIBRARY.createFragment(Types._TxQueryNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _TxQueryNode__TxNode = LIBRARY.createFragment(Types._TxQueryNode, Types._TxNode);
		private static final @NonNull FlatFragment _TxQueryNode__TxQueryNode = LIBRARY.createFragment(Types._TxQueryNode, Types._TxQueryNode);
		private static final @NonNull FlatFragment _TxQueryNode__UMLXElement = LIBRARY.createFragment(Types._TxQueryNode, Types._UMLXElement);
		private static final @NonNull FlatFragment _TxQueryNode__UMLXNamedElement = LIBRARY.createFragment(Types._TxQueryNode, Types._UMLXNamedElement);
		private static final @NonNull FlatFragment _TxQueryNode__UMLXTypedElement = LIBRARY.createFragment(Types._TxQueryNode, Types._UMLXTypedElement);

		private static final @NonNull FlatFragment _TxTypedModelNode__OclAny = LIBRARY.createFragment(Types._TxTypedModelNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _TxTypedModelNode__OclElement = LIBRARY.createFragment(Types._TxTypedModelNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _TxTypedModelNode__TxNode = LIBRARY.createFragment(Types._TxTypedModelNode, Types._TxNode);
		private static final @NonNull FlatFragment _TxTypedModelNode__TxTypedModelNode = LIBRARY.createFragment(Types._TxTypedModelNode, Types._TxTypedModelNode);
		private static final @NonNull FlatFragment _TxTypedModelNode__UMLXElement = LIBRARY.createFragment(Types._TxTypedModelNode, Types._UMLXElement);
		private static final @NonNull FlatFragment _TxTypedModelNode__UMLXNamedElement = LIBRARY.createFragment(Types._TxTypedModelNode, Types._UMLXNamedElement);

		private static final @NonNull FlatFragment _UMLXElement__OclAny = LIBRARY.createFragment(Types._UMLXElement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _UMLXElement__OclElement = LIBRARY.createFragment(Types._UMLXElement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _UMLXElement__UMLXElement = LIBRARY.createFragment(Types._UMLXElement, Types._UMLXElement);

		private static final @NonNull FlatFragment _UMLXModel__OclAny = LIBRARY.createFragment(Types._UMLXModel, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _UMLXModel__OclElement = LIBRARY.createFragment(Types._UMLXModel, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _UMLXModel__UMLXElement = LIBRARY.createFragment(Types._UMLXModel, Types._UMLXElement);
		private static final @NonNull FlatFragment _UMLXModel__UMLXModel = LIBRARY.createFragment(Types._UMLXModel, Types._UMLXModel);

		private static final @NonNull FlatFragment _UMLXNamedElement__OclAny = LIBRARY.createFragment(Types._UMLXNamedElement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _UMLXNamedElement__OclElement = LIBRARY.createFragment(Types._UMLXNamedElement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _UMLXNamedElement__UMLXElement = LIBRARY.createFragment(Types._UMLXNamedElement, Types._UMLXElement);
		private static final @NonNull FlatFragment _UMLXNamedElement__UMLXNamedElement = LIBRARY.createFragment(Types._UMLXNamedElement, Types._UMLXNamedElement);

		private static final @NonNull FlatFragment _UMLXTypedElement__OclAny = LIBRARY.createFragment(Types._UMLXTypedElement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull FlatFragment _UMLXTypedElement__OclElement = LIBRARY.createFragment(Types._UMLXTypedElement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull FlatFragment _UMLXTypedElement__UMLXElement = LIBRARY.createFragment(Types._UMLXTypedElement, Types._UMLXElement);
		private static final @NonNull FlatFragment _UMLXTypedElement__UMLXNamedElement = LIBRARY.createFragment(Types._UMLXTypedElement, Types._UMLXNamedElement);
		private static final @NonNull FlatFragment _UMLXTypedElement__UMLXTypedElement = LIBRARY.createFragment(Types._UMLXTypedElement, Types._UMLXTypedElement);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of UMLXTables::Fragments and all preceding sub-packages.
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
		 * Force initialization of the fields of UMLXTables::Parameters and all preceding sub-packages.
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

		public static final @NonNull Operation _RelPatternNode__isExpression = LIBRARY.createOperation(Types._RelPatternNode, "isExpression", ParameterTypes.EMPTY_LIST, OCLstdlibTables.Types._Boolean,
			0, TemplateParameters.EMPTY_LIST, null);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of UMLXTables::Operations and all preceding sub-packages.
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

		public static final @NonNull Property _RelDiagram__isAbstract = LIBRARY.createProperty(Types._RelDiagram, UMLXPackage.Literals.REL_DIAGRAM__IS_ABSTRACT, OCLstdlibTables.Types._Boolean, 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelDiagram__isTop = LIBRARY.createProperty(Types._RelDiagram, UMLXPackage.Literals.REL_DIAGRAM__IS_TOP, OCLstdlibTables.Types._Boolean, 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelDiagram__ownedRelDomainNodes = LIBRARY.createProperty(Types._RelDiagram, UMLXPackage.Literals.REL_DIAGRAM__OWNED_REL_DOMAIN_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._RelDomainNode, false), 2 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelDiagram__ownedRelInvocationNodes = LIBRARY.createProperty(Types._RelDiagram, UMLXPackage.Literals.REL_DIAGRAM__OWNED_REL_INVOCATION_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._RelInvocationNode, false), 3 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelDiagram__owningTxDiagram = LIBRARY.createProperty(Types._RelDiagram, UMLXPackage.Literals.REL_DIAGRAM__OWNING_TX_DIAGRAM, Types._TxDiagram, 4 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelDiagram__RelInvocationNode__referredRelDiagram = LIBRARY.createOppositeProperty(Types._RelDiagram, "RelInvocationNode", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._RelInvocationNode, false), 5 | IsImplicit | IsRequired | IsResolveProxies, UMLXPackage.Literals.REL_INVOCATION_NODE__REFERRED_REL_DIAGRAM);

		public static final @NonNull Property _RelDomainNode__isEnforced = LIBRARY.createProperty(Types._RelDomainNode, UMLXPackage.Literals.REL_DOMAIN_NODE__IS_ENFORCED, OCLstdlibTables.Types._Boolean, 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelDomainNode__ownedRelPatternEdges = LIBRARY.createProperty(Types._RelDomainNode, UMLXPackage.Literals.REL_DOMAIN_NODE__OWNED_REL_PATTERN_EDGES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._RelPatternEdge, false), 1 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelDomainNode__ownedRelPatternNodes = LIBRARY.createProperty(Types._RelDomainNode, UMLXPackage.Literals.REL_DOMAIN_NODE__OWNED_REL_PATTERN_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._RelPatternNode, false), 2 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelDomainNode__owningRelDiagram = LIBRARY.createProperty(Types._RelDomainNode, UMLXPackage.Literals.REL_DOMAIN_NODE__OWNING_REL_DIAGRAM, Types._RelDiagram, 3 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelDomainNode__referredTxTypedModelNode = LIBRARY.createProperty(Types._RelDomainNode, UMLXPackage.Literals.REL_DOMAIN_NODE__REFERRED_TX_TYPED_MODEL_NODE, Types._TxTypedModelNode, 4 | IsResolveProxies);

		public static final @NonNull Property _RelInvocationEdge__invokingRelPatternNode = LIBRARY.createProperty(Types._RelInvocationEdge, UMLXPackage.Literals.REL_INVOCATION_EDGE__INVOKING_REL_PATTERN_NODE, Types._RelPatternNode, 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelInvocationEdge__owningRelInvocationNode = LIBRARY.createProperty(Types._RelInvocationEdge, UMLXPackage.Literals.REL_INVOCATION_EDGE__OWNING_REL_INVOCATION_NODE, Types._RelInvocationNode, 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelInvocationEdge__referredRelPatternNode = LIBRARY.createProperty(Types._RelInvocationEdge, UMLXPackage.Literals.REL_INVOCATION_EDGE__REFERRED_REL_PATTERN_NODE, Types._RelPatternNode, 2 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _RelInvocationNode__isThen = LIBRARY.createProperty(Types._RelInvocationNode, UMLXPackage.Literals.REL_INVOCATION_NODE__IS_THEN, OCLstdlibTables.Types._Boolean, 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelInvocationNode__ownedRelInvocationEdges = LIBRARY.createProperty(Types._RelInvocationNode, UMLXPackage.Literals.REL_INVOCATION_NODE__OWNED_REL_INVOCATION_EDGES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._RelInvocationEdge, false), 1 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelInvocationNode__owningRelDiagram = LIBRARY.createProperty(Types._RelInvocationNode, UMLXPackage.Literals.REL_INVOCATION_NODE__OWNING_REL_DIAGRAM, Types._RelDiagram, 2 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelInvocationNode__referredRelDiagram = LIBRARY.createProperty(Types._RelInvocationNode, UMLXPackage.Literals.REL_INVOCATION_NODE__REFERRED_REL_DIAGRAM, Types._RelDiagram, 3 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _RelPatternEdge__owningRelDomainNode = LIBRARY.createProperty(Types._RelPatternEdge, UMLXPackage.Literals.REL_PATTERN_EDGE__OWNING_REL_DOMAIN_NODE, Types._RelDomainNode, 0 | IsResolveProxies);
		public static final @NonNull Property _RelPatternEdge__referredEStructuralFeature = LIBRARY.createProperty(Types._RelPatternEdge, UMLXPackage.Literals.REL_PATTERN_EDGE__REFERRED_ESTRUCTURAL_FEATURE, getASClass(EcorePackage.Literals.ESTRUCTURAL_FEATURE), 1 | IsResolveProxies);
		public static final @NonNull Property _RelPatternEdge__source = LIBRARY.createProperty(Types._RelPatternEdge, UMLXPackage.Literals.REL_PATTERN_EDGE__SOURCE, Types._RelPatternNode, 2 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelPatternEdge__sourceIndex = LIBRARY.createProperty(Types._RelPatternEdge, UMLXPackage.Literals.REL_PATTERN_EDGE__SOURCE_INDEX, OCLstdlibTables.Types._Integer, 3 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelPatternEdge__target = LIBRARY.createProperty(Types._RelPatternEdge, UMLXPackage.Literals.REL_PATTERN_EDGE__TARGET, Types._RelPatternNode, 4 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _RelPatternNode__incoming = LIBRARY.createProperty(Types._RelPatternNode, UMLXPackage.Literals.REL_PATTERN_NODE__INCOMING, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._RelPatternEdge, false), 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelPatternNode__initExpressionLines = LIBRARY.createProperty(Types._RelPatternNode, UMLXPackage.Literals.REL_PATTERN_NODE__INIT_EXPRESSION_LINES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, OCLstdlibTables.Types._String, false), 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelPatternNode__invokingRelInvocationEdges = LIBRARY.createProperty(Types._RelPatternNode, UMLXPackage.Literals.REL_PATTERN_NODE__INVOKING_REL_INVOCATION_EDGES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._RelInvocationEdge, false), 2 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelPatternNode__isAnon = LIBRARY.createProperty(Types._RelPatternNode, UMLXPackage.Literals.REL_PATTERN_NODE__IS_ANON, OCLstdlibTables.Types._Boolean, 3 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelPatternNode__isRoot = LIBRARY.createProperty(Types._RelPatternNode, UMLXPackage.Literals.REL_PATTERN_NODE__IS_ROOT, OCLstdlibTables.Types._Boolean, 4 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelPatternNode__outgoing = LIBRARY.createProperty(Types._RelPatternNode, UMLXPackage.Literals.REL_PATTERN_NODE__OUTGOING, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._RelPatternEdge, false), 5 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelPatternNode__owningRelDomainNode = LIBRARY.createProperty(Types._RelPatternNode, UMLXPackage.Literals.REL_PATTERN_NODE__OWNING_REL_DOMAIN_NODE, Types._RelDomainNode, 6 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _RelPatternNode__RelInvocationEdge__referredRelPatternNode = LIBRARY.createOppositeProperty(Types._RelPatternNode, "RelInvocationEdge", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._RelInvocationEdge, false), 7 | IsImplicit | IsRequired | IsResolveProxies, UMLXPackage.Literals.REL_INVOCATION_EDGE__REFERRED_REL_PATTERN_NODE);

		public static final @NonNull Property _TxDiagram__ownedRelDiagrams = LIBRARY.createProperty(Types._TxDiagram, UMLXPackage.Literals.TX_DIAGRAM__OWNED_REL_DIAGRAMS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._RelDiagram, false), 0 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxDiagram__ownedTxKeyNodes = LIBRARY.createProperty(Types._TxDiagram, UMLXPackage.Literals.TX_DIAGRAM__OWNED_TX_KEY_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._TxKeyNode, false), 1 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxDiagram__ownedTxPackageNodes = LIBRARY.createProperty(Types._TxDiagram, UMLXPackage.Literals.TX_DIAGRAM__OWNED_TX_PACKAGE_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._TxPackageNode, false), 2 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxDiagram__ownedTxQueryNodes = LIBRARY.createProperty(Types._TxDiagram, UMLXPackage.Literals.TX_DIAGRAM__OWNED_TX_QUERY_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._TxQueryNode, false), 3 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxDiagram__ownedTxTypedModelNodes = LIBRARY.createProperty(Types._TxDiagram, UMLXPackage.Literals.TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._TxTypedModelNode, false), 4 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxDiagram__package = LIBRARY.createProperty(Types._TxDiagram, UMLXPackage.Literals.TX_DIAGRAM__PACKAGE, OCLstdlibTables.Types._String, 5 | IsResolveProxies);
		public static final @NonNull Property _TxDiagram__UMLXModel__ownedTxDiagrams = LIBRARY.createOppositeProperty(Types._TxDiagram, "UMLXModel", Types._UMLXModel, 6 | IsImplicit | IsResolveProxies, UMLXPackage.Literals.UMLX_MODEL__OWNED_TX_DIAGRAMS);

		public static final @NonNull Property _TxKeyNode__ownedTxPartNodes = LIBRARY.createProperty(Types._TxKeyNode, UMLXPackage.Literals.TX_KEY_NODE__OWNED_TX_PART_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._TxPartNode, false), 0 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxKeyNode__owningTxDiagram = LIBRARY.createProperty(Types._TxKeyNode, UMLXPackage.Literals.TX_KEY_NODE__OWNING_TX_DIAGRAM, Types._TxDiagram, 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxKeyNode__referredEClass = LIBRARY.createProperty(Types._TxKeyNode, UMLXPackage.Literals.TX_KEY_NODE__REFERRED_ECLASS, getASClass(EcorePackage.Literals.ECLASS), 2 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _TxPackageNode__importAliases = LIBRARY.createProperty(Types._TxPackageNode, UMLXPackage.Literals.TX_PACKAGE_NODE__IMPORT_ALIASES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, OCLstdlibTables.Types._String, false), 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxPackageNode__owningTxDiagram = LIBRARY.createProperty(Types._TxPackageNode, UMLXPackage.Literals.TX_PACKAGE_NODE__OWNING_TX_DIAGRAM, Types._TxDiagram, 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxPackageNode__referredEPackage = LIBRARY.createProperty(Types._TxPackageNode, UMLXPackage.Literals.TX_PACKAGE_NODE__REFERRED_EPACKAGE, getASClass(EcorePackage.Literals.EPACKAGE), 2 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxPackageNode__TxTypedModelNode__usedTxPackageNodes = LIBRARY.createOppositeProperty(Types._TxPackageNode, "TxTypedModelNode", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._TxTypedModelNode, false), 3 | IsImplicit | IsRequired | IsResolveProxies, UMLXPackage.Literals.TX_TYPED_MODEL_NODE__USED_TX_PACKAGE_NODES);

		public static final @NonNull Property _TxParameterNode__owningTxQueryNode = LIBRARY.createProperty(Types._TxParameterNode, UMLXPackage.Literals.TX_PARAMETER_NODE__OWNING_TX_QUERY_NODE, Types._TxQueryNode, 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _TxPartNode__isOpposite = LIBRARY.createProperty(Types._TxPartNode, UMLXPackage.Literals.TX_PART_NODE__IS_OPPOSITE, OCLstdlibTables.Types._Boolean, 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxPartNode__owningTxKeyNode = LIBRARY.createProperty(Types._TxPartNode, UMLXPackage.Literals.TX_PART_NODE__OWNING_TX_KEY_NODE, Types._TxKeyNode, 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxPartNode__referredEStructuralFeature = LIBRARY.createProperty(Types._TxPartNode, UMLXPackage.Literals.TX_PART_NODE__REFERRED_ESTRUCTURAL_FEATURE, getASClass(EcorePackage.Literals.ESTRUCTURAL_FEATURE), 2 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _TxQueryNode__initExpressionLines = LIBRARY.createProperty(Types._TxQueryNode, UMLXPackage.Literals.TX_QUERY_NODE__INIT_EXPRESSION_LINES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, OCLstdlibTables.Types._String, false), 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxQueryNode__ownedTxParameterNodes = LIBRARY.createProperty(Types._TxQueryNode, UMLXPackage.Literals.TX_QUERY_NODE__OWNED_TX_PARAMETER_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._TxParameterNode, false), 1 | IsComposite | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxQueryNode__owningTxDiagram = LIBRARY.createProperty(Types._TxQueryNode, UMLXPackage.Literals.TX_QUERY_NODE__OWNING_TX_DIAGRAM, Types._TxDiagram, 2 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _TxTypedModelNode__check = LIBRARY.createProperty(Types._TxTypedModelNode, UMLXPackage.Literals.TX_TYPED_MODEL_NODE__CHECK, OCLstdlibTables.Types._Boolean, 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxTypedModelNode__dependsOns = LIBRARY.createProperty(Types._TxTypedModelNode, UMLXPackage.Literals.TX_TYPED_MODEL_NODE__DEPENDS_ONS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._TxTypedModelNode, false), 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxTypedModelNode__enforce = LIBRARY.createProperty(Types._TxTypedModelNode, UMLXPackage.Literals.TX_TYPED_MODEL_NODE__ENFORCE, OCLstdlibTables.Types._Boolean, 2 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxTypedModelNode__iterates = LIBRARY.createProperty(Types._TxTypedModelNode, UMLXPackage.Literals.TX_TYPED_MODEL_NODE__ITERATES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._TxTypedModelNode, false), 3 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxTypedModelNode__owningTxDiagram = LIBRARY.createProperty(Types._TxTypedModelNode, UMLXPackage.Literals.TX_TYPED_MODEL_NODE__OWNING_TX_DIAGRAM, Types._TxDiagram, 4 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxTypedModelNode__usedTxPackageNodes = LIBRARY.createProperty(Types._TxTypedModelNode, UMLXPackage.Literals.TX_TYPED_MODEL_NODE__USED_TX_PACKAGE_NODES, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._TxPackageNode, false), 5 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _TxTypedModelNode__RelDomainNode__referredTxTypedModelNode = LIBRARY.createOppositeProperty(Types._TxTypedModelNode, "RelDomainNode", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._RelDomainNode, false), 6 | IsImplicit | IsRequired | IsResolveProxies, UMLXPackage.Literals.REL_DOMAIN_NODE__REFERRED_TX_TYPED_MODEL_NODE);
		public static final @NonNull Property _TxTypedModelNode__TxTypedModelNode__dependsOns = LIBRARY.createOppositeProperty(Types._TxTypedModelNode, "TxTypedModelNode", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._TxTypedModelNode, false), 7 | IsImplicit | IsRequired | IsResolveProxies, UMLXPackage.Literals.TX_TYPED_MODEL_NODE__DEPENDS_ONS);
		public static final @NonNull Property _TxTypedModelNode__TxTypedModelNode__iterates = LIBRARY.createOppositeProperty(Types._TxTypedModelNode, "TxTypedModelNode", MODEL.getCollectionType(OCLstdlibTables.Types._Bag, Types._TxTypedModelNode, false), 8 | IsImplicit | IsRequired | IsResolveProxies, UMLXPackage.Literals.TX_TYPED_MODEL_NODE__ITERATES);

		public static final @NonNull Property _UMLXElement__comments = LIBRARY.createProperty(Types._UMLXElement, UMLXPackage.Literals.UMLX_ELEMENT__COMMENTS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, OCLstdlibTables.Types._String, false), 0 | IsRequired | IsResolveProxies);

		public static final @NonNull Property _UMLXModel__ownedTxDiagrams = LIBRARY.createProperty(Types._UMLXModel, UMLXPackage.Literals.UMLX_MODEL__OWNED_TX_DIAGRAMS, MODEL.getCollectionType(OCLstdlibTables.Types._OrderedSet, Types._TxDiagram, false), 0 | IsComposite | IsRequired | IsResolveProxies);

		public static final @NonNull Property _UMLXNamedElement__name = LIBRARY.createProperty(Types._UMLXNamedElement, UMLXPackage.Literals.UMLX_NAMED_ELEMENT__NAME, OCLstdlibTables.Types._String, 0 | IsResolveProxies);

		public static final @NonNull Property _UMLXTypedElement__isMany = LIBRARY.createProperty(Types._UMLXTypedElement, UMLXPackage.Literals.UMLX_TYPED_ELEMENT__IS_MANY, OCLstdlibTables.Types._Boolean, 0 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _UMLXTypedElement__isNullFree = LIBRARY.createProperty(Types._UMLXTypedElement, UMLXPackage.Literals.UMLX_TYPED_ELEMENT__IS_NULL_FREE, OCLstdlibTables.Types._Boolean, 1 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _UMLXTypedElement__isOrdered = LIBRARY.createProperty(Types._UMLXTypedElement, UMLXPackage.Literals.UMLX_TYPED_ELEMENT__IS_ORDERED, OCLstdlibTables.Types._Boolean, 2 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _UMLXTypedElement__isRequired = LIBRARY.createProperty(Types._UMLXTypedElement, UMLXPackage.Literals.UMLX_TYPED_ELEMENT__IS_REQUIRED, OCLstdlibTables.Types._Boolean, 3 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _UMLXTypedElement__isUnique = LIBRARY.createProperty(Types._UMLXTypedElement, UMLXPackage.Literals.UMLX_TYPED_ELEMENT__IS_UNIQUE, OCLstdlibTables.Types._Boolean, 4 | IsRequired | IsResolveProxies);
		public static final @NonNull Property _UMLXTypedElement__referredEClassifier = LIBRARY.createProperty(Types._UMLXTypedElement, UMLXPackage.Literals.UMLX_TYPED_ELEMENT__REFERRED_ECLASSIFIER, getASClass(EcorePackage.Literals.ECLASSIFIER), 5 | IsResolveProxies);

		static {
			_RelDiagram__isAbstract.setDefaultValueString("false");
			_RelDiagram__isTop.setDefaultValueString("false");
			_RelDiagram__ownedRelDomainNodes.setOpposite(_RelDomainNode__owningRelDiagram);
			_RelDiagram__ownedRelInvocationNodes.setOpposite(_RelInvocationNode__owningRelDiagram);
			_RelDiagram__owningTxDiagram.setOpposite(_TxDiagram__ownedRelDiagrams);
			_RelDiagram__RelInvocationNode__referredRelDiagram.setOpposite(_RelInvocationNode__referredRelDiagram);

			_RelDomainNode__isEnforced.setDefaultValueString("false");
			_RelDomainNode__ownedRelPatternEdges.setOpposite(_RelPatternEdge__owningRelDomainNode);
			_RelDomainNode__ownedRelPatternNodes.setOpposite(_RelPatternNode__owningRelDomainNode);
			_RelDomainNode__owningRelDiagram.setOpposite(_RelDiagram__ownedRelDomainNodes);
			_RelDomainNode__referredTxTypedModelNode.setOpposite(_TxTypedModelNode__RelDomainNode__referredTxTypedModelNode);

			_RelInvocationEdge__invokingRelPatternNode.setOpposite(_RelPatternNode__invokingRelInvocationEdges);
			_RelInvocationEdge__owningRelInvocationNode.setOpposite(_RelInvocationNode__ownedRelInvocationEdges);
			_RelInvocationEdge__referredRelPatternNode.setOpposite(_RelPatternNode__RelInvocationEdge__referredRelPatternNode);

			_RelInvocationNode__isThen.setDefaultValueString("true");
			_RelInvocationNode__ownedRelInvocationEdges.setOpposite(_RelInvocationEdge__owningRelInvocationNode);
			_RelInvocationNode__owningRelDiagram.setOpposite(_RelDiagram__ownedRelInvocationNodes);
			_RelInvocationNode__referredRelDiagram.setOpposite(_RelDiagram__RelInvocationNode__referredRelDiagram);

			_RelPatternEdge__owningRelDomainNode.setOpposite(_RelDomainNode__ownedRelPatternEdges);
			LIBRARY.createOpposite("RelPatternEdge", _RelPatternEdge__referredEStructuralFeature);
			_RelPatternEdge__source.setOpposite(_RelPatternNode__outgoing);
			_RelPatternEdge__target.setOpposite(_RelPatternNode__incoming);

			_RelPatternNode__incoming.setOpposite(_RelPatternEdge__target);
			_RelPatternNode__invokingRelInvocationEdges.setOpposite(_RelInvocationEdge__invokingRelPatternNode);
			_RelPatternNode__isAnon.setDefaultValueString("false");
			_RelPatternNode__isRoot.setDefaultValueString("false");
			_RelPatternNode__outgoing.setOpposite(_RelPatternEdge__source);
			_RelPatternNode__owningRelDomainNode.setOpposite(_RelDomainNode__ownedRelPatternNodes);
			_RelPatternNode__RelInvocationEdge__referredRelPatternNode.setOpposite(_RelInvocationEdge__referredRelPatternNode);

			_TxDiagram__ownedRelDiagrams.setOpposite(_RelDiagram__owningTxDiagram);
			_TxDiagram__ownedTxKeyNodes.setOpposite(_TxKeyNode__owningTxDiagram);
			_TxDiagram__ownedTxPackageNodes.setOpposite(_TxPackageNode__owningTxDiagram);
			_TxDiagram__ownedTxQueryNodes.setOpposite(_TxQueryNode__owningTxDiagram);
			_TxDiagram__ownedTxTypedModelNodes.setOpposite(_TxTypedModelNode__owningTxDiagram);
			_TxDiagram__UMLXModel__ownedTxDiagrams.setOpposite(_UMLXModel__ownedTxDiagrams);

			_TxKeyNode__ownedTxPartNodes.setOpposite(_TxPartNode__owningTxKeyNode);
			_TxKeyNode__owningTxDiagram.setOpposite(_TxDiagram__ownedTxKeyNodes);
			LIBRARY.createOpposite("TxKeyNode", _TxKeyNode__referredEClass);

			_TxPackageNode__owningTxDiagram.setOpposite(_TxDiagram__ownedTxPackageNodes);
			LIBRARY.createOpposite("TxPackageNode", _TxPackageNode__referredEPackage);
			_TxPackageNode__TxTypedModelNode__usedTxPackageNodes.setOpposite(_TxTypedModelNode__usedTxPackageNodes);

			_TxParameterNode__owningTxQueryNode.setOpposite(_TxQueryNode__ownedTxParameterNodes);

			_TxPartNode__isOpposite.setDefaultValueString("false");
			_TxPartNode__owningTxKeyNode.setOpposite(_TxKeyNode__ownedTxPartNodes);
			LIBRARY.createOpposite("TxPartNode", _TxPartNode__referredEStructuralFeature);

			_TxQueryNode__ownedTxParameterNodes.setOpposite(_TxParameterNode__owningTxQueryNode);
			_TxQueryNode__owningTxDiagram.setOpposite(_TxDiagram__ownedTxQueryNodes);

			_TxTypedModelNode__check.setDefaultValueString("false");
			_TxTypedModelNode__dependsOns.setOpposite(_TxTypedModelNode__TxTypedModelNode__dependsOns);
			_TxTypedModelNode__enforce.setDefaultValueString("false");
			_TxTypedModelNode__iterates.setOpposite(_TxTypedModelNode__TxTypedModelNode__iterates);
			_TxTypedModelNode__owningTxDiagram.setOpposite(_TxDiagram__ownedTxTypedModelNodes);
			_TxTypedModelNode__usedTxPackageNodes.setOpposite(_TxPackageNode__TxTypedModelNode__usedTxPackageNodes);
			_TxTypedModelNode__RelDomainNode__referredTxTypedModelNode.setOpposite(_RelDomainNode__referredTxTypedModelNode);
			_TxTypedModelNode__TxTypedModelNode__dependsOns.setOpposite(_TxTypedModelNode__dependsOns);
			_TxTypedModelNode__TxTypedModelNode__iterates.setOpposite(_TxTypedModelNode__iterates);


			_UMLXModel__ownedTxDiagrams.setOpposite(_TxDiagram__UMLXModel__ownedTxDiagrams);


			_UMLXTypedElement__isMany.setDefaultValueString("false");
			_UMLXTypedElement__isNullFree.setDefaultValueString("true");
			_UMLXTypedElement__isOrdered.setDefaultValueString("false");
			_UMLXTypedElement__isRequired.setDefaultValueString("true");
			_UMLXTypedElement__isUnique.setDefaultValueString("true");
			LIBRARY.createOpposite("UMLXTypedElement", _UMLXTypedElement__referredEClassifier);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of UMLXTables::Properties and all preceding sub-packages.
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

		private static final @NonNull FlatFragment @NonNull [] _RelDiagram =
			{
				Fragments._RelDiagram__OclAny /* 0 */,
				Fragments._RelDiagram__OclElement /* 1 */,
				Fragments._RelDiagram__UMLXElement /* 2 */,
				Fragments._RelDiagram__UMLXNamedElement /* 3 */,
				Fragments._RelDiagram__RelDiagram /* 4 */
			};
		private static final int @NonNull [] __RelDiagram = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _RelDomainNode =
			{
				Fragments._RelDomainNode__OclAny /* 0 */,
				Fragments._RelDomainNode__OclElement /* 1 */,
				Fragments._RelDomainNode__UMLXElement /* 2 */,
				Fragments._RelDomainNode__RelNode /* 3 */,
				Fragments._RelDomainNode__RelDomainNode /* 4 */
			};
		private static final int @NonNull [] __RelDomainNode = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _RelEdge =
			{
				Fragments._RelEdge__OclAny /* 0 */,
				Fragments._RelEdge__OclElement /* 1 */,
				Fragments._RelEdge__UMLXElement /* 2 */,
				Fragments._RelEdge__RelEdge /* 3 */
			};
		private static final int @NonNull [] __RelEdge = { 1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _RelInvocationEdge =
			{
				Fragments._RelInvocationEdge__OclAny /* 0 */,
				Fragments._RelInvocationEdge__OclElement /* 1 */,
				Fragments._RelInvocationEdge__UMLXElement /* 2 */,
				Fragments._RelInvocationEdge__RelEdge /* 3 */,
				Fragments._RelInvocationEdge__RelInvocationEdge /* 4 */
			};
		private static final int @NonNull [] __RelInvocationEdge = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _RelInvocationNode =
			{
				Fragments._RelInvocationNode__OclAny /* 0 */,
				Fragments._RelInvocationNode__OclElement /* 1 */,
				Fragments._RelInvocationNode__UMLXElement /* 2 */,
				Fragments._RelInvocationNode__RelNode /* 3 */,
				Fragments._RelInvocationNode__RelInvocationNode /* 4 */
			};
		private static final int @NonNull [] __RelInvocationNode = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _RelNode =
			{
				Fragments._RelNode__OclAny /* 0 */,
				Fragments._RelNode__OclElement /* 1 */,
				Fragments._RelNode__UMLXElement /* 2 */,
				Fragments._RelNode__RelNode /* 3 */
			};
		private static final int @NonNull [] __RelNode = { 1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _RelPatternEdge =
			{
				Fragments._RelPatternEdge__OclAny /* 0 */,
				Fragments._RelPatternEdge__OclElement /* 1 */,
				Fragments._RelPatternEdge__UMLXElement /* 2 */,
				Fragments._RelPatternEdge__RelEdge /* 3 */,
				Fragments._RelPatternEdge__RelPatternEdge /* 4 */
			};
		private static final int @NonNull [] __RelPatternEdge = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _RelPatternNode =
			{
				Fragments._RelPatternNode__OclAny /* 0 */,
				Fragments._RelPatternNode__OclElement /* 1 */,
				Fragments._RelPatternNode__UMLXElement /* 2 */,
				Fragments._RelPatternNode__RelNode /* 3 */,
				Fragments._RelPatternNode__UMLXNamedElement /* 3 */,
				Fragments._RelPatternNode__UMLXTypedElement /* 4 */,
				Fragments._RelPatternNode__RelPatternNode /* 5 */
			};
		private static final int @NonNull [] __RelPatternNode = { 1,1,1,2,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _TxDiagram =
			{
				Fragments._TxDiagram__OclAny /* 0 */,
				Fragments._TxDiagram__OclElement /* 1 */,
				Fragments._TxDiagram__UMLXElement /* 2 */,
				Fragments._TxDiagram__UMLXNamedElement /* 3 */,
				Fragments._TxDiagram__TxDiagram /* 4 */
			};
		private static final int @NonNull [] __TxDiagram = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _TxKeyNode =
			{
				Fragments._TxKeyNode__OclAny /* 0 */,
				Fragments._TxKeyNode__OclElement /* 1 */,
				Fragments._TxKeyNode__UMLXElement /* 2 */,
				Fragments._TxKeyNode__TxNode /* 3 */,
				Fragments._TxKeyNode__TxKeyNode /* 4 */
			};
		private static final int @NonNull [] __TxKeyNode = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _TxNode =
			{
				Fragments._TxNode__OclAny /* 0 */,
				Fragments._TxNode__OclElement /* 1 */,
				Fragments._TxNode__UMLXElement /* 2 */,
				Fragments._TxNode__TxNode /* 3 */
			};
		private static final int @NonNull [] __TxNode = { 1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _TxPackageNode =
			{
				Fragments._TxPackageNode__OclAny /* 0 */,
				Fragments._TxPackageNode__OclElement /* 1 */,
				Fragments._TxPackageNode__UMLXElement /* 2 */,
				Fragments._TxPackageNode__TxNode /* 3 */,
				Fragments._TxPackageNode__TxPackageNode /* 4 */
			};
		private static final int @NonNull [] __TxPackageNode = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _TxParameterNode =
			{
				Fragments._TxParameterNode__OclAny /* 0 */,
				Fragments._TxParameterNode__OclElement /* 1 */,
				Fragments._TxParameterNode__UMLXElement /* 2 */,
				Fragments._TxParameterNode__TxNode /* 3 */,
				Fragments._TxParameterNode__UMLXNamedElement /* 3 */,
				Fragments._TxParameterNode__UMLXTypedElement /* 4 */,
				Fragments._TxParameterNode__TxParameterNode /* 5 */
			};
		private static final int @NonNull [] __TxParameterNode = { 1,1,1,2,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _TxPartNode =
			{
				Fragments._TxPartNode__OclAny /* 0 */,
				Fragments._TxPartNode__OclElement /* 1 */,
				Fragments._TxPartNode__UMLXElement /* 2 */,
				Fragments._TxPartNode__TxNode /* 3 */,
				Fragments._TxPartNode__TxPartNode /* 4 */
			};
		private static final int @NonNull [] __TxPartNode = { 1,1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _TxQueryNode =
			{
				Fragments._TxQueryNode__OclAny /* 0 */,
				Fragments._TxQueryNode__OclElement /* 1 */,
				Fragments._TxQueryNode__UMLXElement /* 2 */,
				Fragments._TxQueryNode__TxNode /* 3 */,
				Fragments._TxQueryNode__UMLXNamedElement /* 3 */,
				Fragments._TxQueryNode__UMLXTypedElement /* 4 */,
				Fragments._TxQueryNode__TxQueryNode /* 5 */
			};
		private static final int @NonNull [] __TxQueryNode = { 1,1,1,2,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _TxTypedModelNode =
			{
				Fragments._TxTypedModelNode__OclAny /* 0 */,
				Fragments._TxTypedModelNode__OclElement /* 1 */,
				Fragments._TxTypedModelNode__UMLXElement /* 2 */,
				Fragments._TxTypedModelNode__TxNode /* 3 */,
				Fragments._TxTypedModelNode__UMLXNamedElement /* 3 */,
				Fragments._TxTypedModelNode__TxTypedModelNode /* 4 */
			};
		private static final int @NonNull [] __TxTypedModelNode = { 1,1,1,2,1 };

		private static final @NonNull FlatFragment @NonNull [] _UMLXElement =
			{
				Fragments._UMLXElement__OclAny /* 0 */,
				Fragments._UMLXElement__OclElement /* 1 */,
				Fragments._UMLXElement__UMLXElement /* 2 */
			};
		private static final int @NonNull [] __UMLXElement = { 1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _UMLXModel =
			{
				Fragments._UMLXModel__OclAny /* 0 */,
				Fragments._UMLXModel__OclElement /* 1 */,
				Fragments._UMLXModel__UMLXElement /* 2 */,
				Fragments._UMLXModel__UMLXModel /* 3 */
			};
		private static final int @NonNull [] __UMLXModel = { 1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _UMLXNamedElement =
			{
				Fragments._UMLXNamedElement__OclAny /* 0 */,
				Fragments._UMLXNamedElement__OclElement /* 1 */,
				Fragments._UMLXNamedElement__UMLXElement /* 2 */,
				Fragments._UMLXNamedElement__UMLXNamedElement /* 3 */
			};
		private static final int @NonNull [] __UMLXNamedElement = { 1,1,1,1 };

		private static final @NonNull FlatFragment @NonNull [] _UMLXTypedElement =
			{
				Fragments._UMLXTypedElement__OclAny /* 0 */,
				Fragments._UMLXTypedElement__OclElement /* 1 */,
				Fragments._UMLXTypedElement__UMLXElement /* 2 */,
				Fragments._UMLXTypedElement__UMLXNamedElement /* 3 */,
				Fragments._UMLXTypedElement__UMLXTypedElement /* 4 */
			};
		private static final int @NonNull [] __UMLXTypedElement = { 1,1,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._RelDiagram.initFragments(_RelDiagram, __RelDiagram);
			Types._RelDomainNode.initFragments(_RelDomainNode, __RelDomainNode);
			Types._RelEdge.initFragments(_RelEdge, __RelEdge);
			Types._RelInvocationEdge.initFragments(_RelInvocationEdge, __RelInvocationEdge);
			Types._RelInvocationNode.initFragments(_RelInvocationNode, __RelInvocationNode);
			Types._RelNode.initFragments(_RelNode, __RelNode);
			Types._RelPatternEdge.initFragments(_RelPatternEdge, __RelPatternEdge);
			Types._RelPatternNode.initFragments(_RelPatternNode, __RelPatternNode);
			Types._TxDiagram.initFragments(_TxDiagram, __TxDiagram);
			Types._TxKeyNode.initFragments(_TxKeyNode, __TxKeyNode);
			Types._TxNode.initFragments(_TxNode, __TxNode);
			Types._TxPackageNode.initFragments(_TxPackageNode, __TxPackageNode);
			Types._TxParameterNode.initFragments(_TxParameterNode, __TxParameterNode);
			Types._TxPartNode.initFragments(_TxPartNode, __TxPartNode);
			Types._TxQueryNode.initFragments(_TxQueryNode, __TxQueryNode);
			Types._TxTypedModelNode.initFragments(_TxTypedModelNode, __TxTypedModelNode);
			Types._UMLXElement.initFragments(_UMLXElement, __UMLXElement);
			Types._UMLXModel.initFragments(_UMLXModel, __UMLXModel);
			Types._UMLXNamedElement.initFragments(_UMLXNamedElement, __UMLXNamedElement);
			Types._UMLXTypedElement.initFragments(_UMLXTypedElement, __UMLXTypedElement);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of UMLXTables::TypeFragments and all preceding sub-packages.
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

		private static final @NonNull Operation @NonNull [] _RelDiagram__RelDiagram = {};
		private static final @NonNull Operation @NonNull [] _RelDiagram__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _RelDiagram__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _RelDiagram__UMLXElement = {};
		private static final @NonNull Operation @NonNull [] _RelDiagram__UMLXNamedElement = {};

		private static final @NonNull Operation @NonNull [] _RelDomainNode__RelDomainNode = {};
		private static final @NonNull Operation @NonNull [] _RelDomainNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _RelDomainNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _RelDomainNode__RelNode = {};
		private static final @NonNull Operation @NonNull [] _RelDomainNode__UMLXElement = {};

		private static final @NonNull Operation @NonNull [] _RelEdge__RelEdge = {};
		private static final @NonNull Operation @NonNull [] _RelEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _RelEdge__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _RelEdge__UMLXElement = {};

		private static final @NonNull Operation @NonNull [] _RelInvocationEdge__RelInvocationEdge = {};
		private static final @NonNull Operation @NonNull [] _RelInvocationEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _RelInvocationEdge__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _RelInvocationEdge__RelEdge = {};
		private static final @NonNull Operation @NonNull [] _RelInvocationEdge__UMLXElement = {};

		private static final @NonNull Operation @NonNull [] _RelInvocationNode__RelInvocationNode = {};
		private static final @NonNull Operation @NonNull [] _RelInvocationNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _RelInvocationNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _RelInvocationNode__RelNode = {};
		private static final @NonNull Operation @NonNull [] _RelInvocationNode__UMLXElement = {};

		private static final @NonNull Operation @NonNull [] _RelNode__RelNode = {};
		private static final @NonNull Operation @NonNull [] _RelNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _RelNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _RelNode__UMLXElement = {};

		private static final @NonNull Operation @NonNull [] _RelPatternEdge__RelPatternEdge = {};
		private static final @NonNull Operation @NonNull [] _RelPatternEdge__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _RelPatternEdge__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _RelPatternEdge__RelEdge = {};
		private static final @NonNull Operation @NonNull [] _RelPatternEdge__UMLXElement = {};

		private static final @NonNull Operation @NonNull [] _RelPatternNode__RelPatternNode = {
			Operations._RelPatternNode__isExpression /* isExpression() */
		};
		private static final @NonNull Operation @NonNull [] _RelPatternNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _RelPatternNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _RelPatternNode__RelNode = {};
		private static final @NonNull Operation @NonNull [] _RelPatternNode__UMLXElement = {};
		private static final @NonNull Operation @NonNull [] _RelPatternNode__UMLXNamedElement = {};
		private static final @NonNull Operation @NonNull [] _RelPatternNode__UMLXTypedElement = {};

		private static final @NonNull Operation @NonNull [] _TxDiagram__TxDiagram = {};
		private static final @NonNull Operation @NonNull [] _TxDiagram__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _TxDiagram__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _TxDiagram__UMLXElement = {};
		private static final @NonNull Operation @NonNull [] _TxDiagram__UMLXNamedElement = {};

		private static final @NonNull Operation @NonNull [] _TxKeyNode__TxKeyNode = {};
		private static final @NonNull Operation @NonNull [] _TxKeyNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _TxKeyNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _TxKeyNode__TxNode = {};
		private static final @NonNull Operation @NonNull [] _TxKeyNode__UMLXElement = {};

		private static final @NonNull Operation @NonNull [] _TxNode__TxNode = {};
		private static final @NonNull Operation @NonNull [] _TxNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _TxNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _TxNode__UMLXElement = {};

		private static final @NonNull Operation @NonNull [] _TxPackageNode__TxPackageNode = {};
		private static final @NonNull Operation @NonNull [] _TxPackageNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _TxPackageNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _TxPackageNode__TxNode = {};
		private static final @NonNull Operation @NonNull [] _TxPackageNode__UMLXElement = {};

		private static final @NonNull Operation @NonNull [] _TxParameterNode__TxParameterNode = {};
		private static final @NonNull Operation @NonNull [] _TxParameterNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _TxParameterNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _TxParameterNode__TxNode = {};
		private static final @NonNull Operation @NonNull [] _TxParameterNode__UMLXElement = {};
		private static final @NonNull Operation @NonNull [] _TxParameterNode__UMLXNamedElement = {};
		private static final @NonNull Operation @NonNull [] _TxParameterNode__UMLXTypedElement = {};

		private static final @NonNull Operation @NonNull [] _TxPartNode__TxPartNode = {};
		private static final @NonNull Operation @NonNull [] _TxPartNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _TxPartNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _TxPartNode__TxNode = {};
		private static final @NonNull Operation @NonNull [] _TxPartNode__UMLXElement = {};

		private static final @NonNull Operation @NonNull [] _TxQueryNode__TxQueryNode = {};
		private static final @NonNull Operation @NonNull [] _TxQueryNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _TxQueryNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _TxQueryNode__TxNode = {};
		private static final @NonNull Operation @NonNull [] _TxQueryNode__UMLXElement = {};
		private static final @NonNull Operation @NonNull [] _TxQueryNode__UMLXNamedElement = {};
		private static final @NonNull Operation @NonNull [] _TxQueryNode__UMLXTypedElement = {};

		private static final @NonNull Operation @NonNull [] _TxTypedModelNode__TxTypedModelNode = {};
		private static final @NonNull Operation @NonNull [] _TxTypedModelNode__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _TxTypedModelNode__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _TxTypedModelNode__TxNode = {};
		private static final @NonNull Operation @NonNull [] _TxTypedModelNode__UMLXElement = {};
		private static final @NonNull Operation @NonNull [] _TxTypedModelNode__UMLXNamedElement = {};

		private static final @NonNull Operation @NonNull [] _UMLXElement__UMLXElement = {};
		private static final @NonNull Operation @NonNull [] _UMLXElement__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _UMLXElement__OclElement = {
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

		private static final @NonNull Operation @NonNull [] _UMLXModel__UMLXModel = {};
		private static final @NonNull Operation @NonNull [] _UMLXModel__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _UMLXModel__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _UMLXModel__UMLXElement = {};

		private static final @NonNull Operation @NonNull [] _UMLXNamedElement__UMLXNamedElement = {};
		private static final @NonNull Operation @NonNull [] _UMLXNamedElement__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _UMLXNamedElement__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _UMLXNamedElement__UMLXElement = {};

		private static final @NonNull Operation @NonNull [] _UMLXTypedElement__UMLXTypedElement = {};
		private static final @NonNull Operation @NonNull [] _UMLXTypedElement__OclAny = {
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
		private static final @NonNull Operation @NonNull [] _UMLXTypedElement__OclElement = {
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
		private static final @NonNull Operation @NonNull [] _UMLXTypedElement__UMLXElement = {};
		private static final @NonNull Operation @NonNull [] _UMLXTypedElement__UMLXNamedElement = {};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._RelDiagram__OclAny.initOperations(_RelDiagram__OclAny);
			Fragments._RelDiagram__OclElement.initOperations(_RelDiagram__OclElement);
			Fragments._RelDiagram__RelDiagram.initOperations(_RelDiagram__RelDiagram);
			Fragments._RelDiagram__UMLXElement.initOperations(_RelDiagram__UMLXElement);
			Fragments._RelDiagram__UMLXNamedElement.initOperations(_RelDiagram__UMLXNamedElement);

			Fragments._RelDomainNode__OclAny.initOperations(_RelDomainNode__OclAny);
			Fragments._RelDomainNode__OclElement.initOperations(_RelDomainNode__OclElement);
			Fragments._RelDomainNode__RelDomainNode.initOperations(_RelDomainNode__RelDomainNode);
			Fragments._RelDomainNode__RelNode.initOperations(_RelDomainNode__RelNode);
			Fragments._RelDomainNode__UMLXElement.initOperations(_RelDomainNode__UMLXElement);

			Fragments._RelEdge__OclAny.initOperations(_RelEdge__OclAny);
			Fragments._RelEdge__OclElement.initOperations(_RelEdge__OclElement);
			Fragments._RelEdge__RelEdge.initOperations(_RelEdge__RelEdge);
			Fragments._RelEdge__UMLXElement.initOperations(_RelEdge__UMLXElement);

			Fragments._RelInvocationEdge__OclAny.initOperations(_RelInvocationEdge__OclAny);
			Fragments._RelInvocationEdge__OclElement.initOperations(_RelInvocationEdge__OclElement);
			Fragments._RelInvocationEdge__RelEdge.initOperations(_RelInvocationEdge__RelEdge);
			Fragments._RelInvocationEdge__RelInvocationEdge.initOperations(_RelInvocationEdge__RelInvocationEdge);
			Fragments._RelInvocationEdge__UMLXElement.initOperations(_RelInvocationEdge__UMLXElement);

			Fragments._RelInvocationNode__OclAny.initOperations(_RelInvocationNode__OclAny);
			Fragments._RelInvocationNode__OclElement.initOperations(_RelInvocationNode__OclElement);
			Fragments._RelInvocationNode__RelInvocationNode.initOperations(_RelInvocationNode__RelInvocationNode);
			Fragments._RelInvocationNode__RelNode.initOperations(_RelInvocationNode__RelNode);
			Fragments._RelInvocationNode__UMLXElement.initOperations(_RelInvocationNode__UMLXElement);

			Fragments._RelNode__OclAny.initOperations(_RelNode__OclAny);
			Fragments._RelNode__OclElement.initOperations(_RelNode__OclElement);
			Fragments._RelNode__RelNode.initOperations(_RelNode__RelNode);
			Fragments._RelNode__UMLXElement.initOperations(_RelNode__UMLXElement);

			Fragments._RelPatternEdge__OclAny.initOperations(_RelPatternEdge__OclAny);
			Fragments._RelPatternEdge__OclElement.initOperations(_RelPatternEdge__OclElement);
			Fragments._RelPatternEdge__RelEdge.initOperations(_RelPatternEdge__RelEdge);
			Fragments._RelPatternEdge__RelPatternEdge.initOperations(_RelPatternEdge__RelPatternEdge);
			Fragments._RelPatternEdge__UMLXElement.initOperations(_RelPatternEdge__UMLXElement);

			Fragments._RelPatternNode__OclAny.initOperations(_RelPatternNode__OclAny);
			Fragments._RelPatternNode__OclElement.initOperations(_RelPatternNode__OclElement);
			Fragments._RelPatternNode__RelNode.initOperations(_RelPatternNode__RelNode);
			Fragments._RelPatternNode__RelPatternNode.initOperations(_RelPatternNode__RelPatternNode);
			Fragments._RelPatternNode__UMLXElement.initOperations(_RelPatternNode__UMLXElement);
			Fragments._RelPatternNode__UMLXNamedElement.initOperations(_RelPatternNode__UMLXNamedElement);
			Fragments._RelPatternNode__UMLXTypedElement.initOperations(_RelPatternNode__UMLXTypedElement);

			Fragments._TxDiagram__OclAny.initOperations(_TxDiagram__OclAny);
			Fragments._TxDiagram__OclElement.initOperations(_TxDiagram__OclElement);
			Fragments._TxDiagram__TxDiagram.initOperations(_TxDiagram__TxDiagram);
			Fragments._TxDiagram__UMLXElement.initOperations(_TxDiagram__UMLXElement);
			Fragments._TxDiagram__UMLXNamedElement.initOperations(_TxDiagram__UMLXNamedElement);

			Fragments._TxKeyNode__OclAny.initOperations(_TxKeyNode__OclAny);
			Fragments._TxKeyNode__OclElement.initOperations(_TxKeyNode__OclElement);
			Fragments._TxKeyNode__TxKeyNode.initOperations(_TxKeyNode__TxKeyNode);
			Fragments._TxKeyNode__TxNode.initOperations(_TxKeyNode__TxNode);
			Fragments._TxKeyNode__UMLXElement.initOperations(_TxKeyNode__UMLXElement);

			Fragments._TxNode__OclAny.initOperations(_TxNode__OclAny);
			Fragments._TxNode__OclElement.initOperations(_TxNode__OclElement);
			Fragments._TxNode__TxNode.initOperations(_TxNode__TxNode);
			Fragments._TxNode__UMLXElement.initOperations(_TxNode__UMLXElement);

			Fragments._TxPackageNode__OclAny.initOperations(_TxPackageNode__OclAny);
			Fragments._TxPackageNode__OclElement.initOperations(_TxPackageNode__OclElement);
			Fragments._TxPackageNode__TxNode.initOperations(_TxPackageNode__TxNode);
			Fragments._TxPackageNode__TxPackageNode.initOperations(_TxPackageNode__TxPackageNode);
			Fragments._TxPackageNode__UMLXElement.initOperations(_TxPackageNode__UMLXElement);

			Fragments._TxParameterNode__OclAny.initOperations(_TxParameterNode__OclAny);
			Fragments._TxParameterNode__OclElement.initOperations(_TxParameterNode__OclElement);
			Fragments._TxParameterNode__TxNode.initOperations(_TxParameterNode__TxNode);
			Fragments._TxParameterNode__TxParameterNode.initOperations(_TxParameterNode__TxParameterNode);
			Fragments._TxParameterNode__UMLXElement.initOperations(_TxParameterNode__UMLXElement);
			Fragments._TxParameterNode__UMLXNamedElement.initOperations(_TxParameterNode__UMLXNamedElement);
			Fragments._TxParameterNode__UMLXTypedElement.initOperations(_TxParameterNode__UMLXTypedElement);

			Fragments._TxPartNode__OclAny.initOperations(_TxPartNode__OclAny);
			Fragments._TxPartNode__OclElement.initOperations(_TxPartNode__OclElement);
			Fragments._TxPartNode__TxNode.initOperations(_TxPartNode__TxNode);
			Fragments._TxPartNode__TxPartNode.initOperations(_TxPartNode__TxPartNode);
			Fragments._TxPartNode__UMLXElement.initOperations(_TxPartNode__UMLXElement);

			Fragments._TxQueryNode__OclAny.initOperations(_TxQueryNode__OclAny);
			Fragments._TxQueryNode__OclElement.initOperations(_TxQueryNode__OclElement);
			Fragments._TxQueryNode__TxNode.initOperations(_TxQueryNode__TxNode);
			Fragments._TxQueryNode__TxQueryNode.initOperations(_TxQueryNode__TxQueryNode);
			Fragments._TxQueryNode__UMLXElement.initOperations(_TxQueryNode__UMLXElement);
			Fragments._TxQueryNode__UMLXNamedElement.initOperations(_TxQueryNode__UMLXNamedElement);
			Fragments._TxQueryNode__UMLXTypedElement.initOperations(_TxQueryNode__UMLXTypedElement);

			Fragments._TxTypedModelNode__OclAny.initOperations(_TxTypedModelNode__OclAny);
			Fragments._TxTypedModelNode__OclElement.initOperations(_TxTypedModelNode__OclElement);
			Fragments._TxTypedModelNode__TxNode.initOperations(_TxTypedModelNode__TxNode);
			Fragments._TxTypedModelNode__TxTypedModelNode.initOperations(_TxTypedModelNode__TxTypedModelNode);
			Fragments._TxTypedModelNode__UMLXElement.initOperations(_TxTypedModelNode__UMLXElement);
			Fragments._TxTypedModelNode__UMLXNamedElement.initOperations(_TxTypedModelNode__UMLXNamedElement);

			Fragments._UMLXElement__OclAny.initOperations(_UMLXElement__OclAny);
			Fragments._UMLXElement__OclElement.initOperations(_UMLXElement__OclElement);
			Fragments._UMLXElement__UMLXElement.initOperations(_UMLXElement__UMLXElement);

			Fragments._UMLXModel__OclAny.initOperations(_UMLXModel__OclAny);
			Fragments._UMLXModel__OclElement.initOperations(_UMLXModel__OclElement);
			Fragments._UMLXModel__UMLXElement.initOperations(_UMLXModel__UMLXElement);
			Fragments._UMLXModel__UMLXModel.initOperations(_UMLXModel__UMLXModel);

			Fragments._UMLXNamedElement__OclAny.initOperations(_UMLXNamedElement__OclAny);
			Fragments._UMLXNamedElement__OclElement.initOperations(_UMLXNamedElement__OclElement);
			Fragments._UMLXNamedElement__UMLXElement.initOperations(_UMLXNamedElement__UMLXElement);
			Fragments._UMLXNamedElement__UMLXNamedElement.initOperations(_UMLXNamedElement__UMLXNamedElement);

			Fragments._UMLXTypedElement__OclAny.initOperations(_UMLXTypedElement__OclAny);
			Fragments._UMLXTypedElement__OclElement.initOperations(_UMLXTypedElement__OclElement);
			Fragments._UMLXTypedElement__UMLXElement.initOperations(_UMLXTypedElement__UMLXElement);
			Fragments._UMLXTypedElement__UMLXNamedElement.initOperations(_UMLXTypedElement__UMLXNamedElement);
			Fragments._UMLXTypedElement__UMLXTypedElement.initOperations(_UMLXTypedElement__UMLXTypedElement);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of UMLXTables::FragmentOperations and all preceding sub-packages.
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

		private static final @NonNull Property @NonNull [] _RelDiagram = {
			Properties._UMLXElement__comments,
			Properties._RelDiagram__isAbstract,
			Properties._RelDiagram__isTop,
			Properties._UMLXNamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._RelDiagram__ownedRelDomainNodes,
			Properties._RelDiagram__ownedRelInvocationNodes,
			Properties._RelDiagram__owningTxDiagram
		};

		private static final @NonNull Property @NonNull [] _RelDomainNode = {
			Properties._UMLXElement__comments,
			Properties._RelDomainNode__isEnforced,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._RelDomainNode__ownedRelPatternEdges,
			Properties._RelDomainNode__ownedRelPatternNodes,
			Properties._RelDomainNode__owningRelDiagram,
			Properties._RelDomainNode__referredTxTypedModelNode
		};

		private static final @NonNull Property @NonNull [] _RelEdge = {
			Properties._UMLXElement__comments,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _RelInvocationEdge = {
			Properties._UMLXElement__comments,
			Properties._RelInvocationEdge__invokingRelPatternNode,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._RelInvocationEdge__owningRelInvocationNode,
			Properties._RelInvocationEdge__referredRelPatternNode
		};

		private static final @NonNull Property @NonNull [] _RelInvocationNode = {
			Properties._UMLXElement__comments,
			Properties._RelInvocationNode__isThen,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._RelInvocationNode__ownedRelInvocationEdges,
			Properties._RelInvocationNode__owningRelDiagram,
			Properties._RelInvocationNode__referredRelDiagram
		};

		private static final @NonNull Property @NonNull [] _RelNode = {
			Properties._UMLXElement__comments,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _RelPatternEdge = {
			Properties._UMLXElement__comments,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._RelPatternEdge__owningRelDomainNode,
			Properties._RelPatternEdge__referredEStructuralFeature,
			Properties._RelPatternEdge__source,
			Properties._RelPatternEdge__sourceIndex,
			Properties._RelPatternEdge__target
		};

		private static final @NonNull Property @NonNull [] _RelPatternNode = {
			Properties._UMLXElement__comments,
			Properties._RelPatternNode__incoming,
			Properties._RelPatternNode__initExpressionLines,
			Properties._RelPatternNode__invokingRelInvocationEdges,
			Properties._RelPatternNode__isAnon,
			Properties._UMLXTypedElement__isMany,
			Properties._UMLXTypedElement__isNullFree,
			Properties._UMLXTypedElement__isOrdered,
			Properties._UMLXTypedElement__isRequired,
			Properties._RelPatternNode__isRoot,
			Properties._UMLXTypedElement__isUnique,
			Properties._UMLXNamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._RelPatternNode__outgoing,
			Properties._RelPatternNode__owningRelDomainNode,
			Properties._UMLXTypedElement__referredEClassifier
		};

		private static final @NonNull Property @NonNull [] _TxDiagram = {
			Properties._UMLXElement__comments,
			Properties._UMLXNamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._TxDiagram__ownedRelDiagrams,
			Properties._TxDiagram__ownedTxKeyNodes,
			Properties._TxDiagram__ownedTxPackageNodes,
			Properties._TxDiagram__ownedTxQueryNodes,
			Properties._TxDiagram__ownedTxTypedModelNodes,
			Properties._TxDiagram__package
		};

		private static final @NonNull Property @NonNull [] _TxKeyNode = {
			Properties._UMLXElement__comments,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._TxKeyNode__ownedTxPartNodes,
			Properties._TxKeyNode__owningTxDiagram,
			Properties._TxKeyNode__referredEClass
		};

		private static final @NonNull Property @NonNull [] _TxNode = {
			Properties._UMLXElement__comments,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _TxPackageNode = {
			Properties._UMLXElement__comments,
			Properties._TxPackageNode__importAliases,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._TxPackageNode__owningTxDiagram,
			Properties._TxPackageNode__referredEPackage
		};

		private static final @NonNull Property @NonNull [] _TxParameterNode = {
			Properties._UMLXElement__comments,
			Properties._UMLXTypedElement__isMany,
			Properties._UMLXTypedElement__isNullFree,
			Properties._UMLXTypedElement__isOrdered,
			Properties._UMLXTypedElement__isRequired,
			Properties._UMLXTypedElement__isUnique,
			Properties._UMLXNamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._TxParameterNode__owningTxQueryNode,
			Properties._UMLXTypedElement__referredEClassifier
		};

		private static final @NonNull Property @NonNull [] _TxPartNode = {
			Properties._UMLXElement__comments,
			Properties._TxPartNode__isOpposite,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._TxPartNode__owningTxKeyNode,
			Properties._TxPartNode__referredEStructuralFeature
		};

		private static final @NonNull Property @NonNull [] _TxQueryNode = {
			Properties._UMLXElement__comments,
			Properties._TxQueryNode__initExpressionLines,
			Properties._UMLXTypedElement__isMany,
			Properties._UMLXTypedElement__isNullFree,
			Properties._UMLXTypedElement__isOrdered,
			Properties._UMLXTypedElement__isRequired,
			Properties._UMLXTypedElement__isUnique,
			Properties._UMLXNamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._TxQueryNode__ownedTxParameterNodes,
			Properties._TxQueryNode__owningTxDiagram,
			Properties._UMLXTypedElement__referredEClassifier
		};

		private static final @NonNull Property @NonNull [] _TxTypedModelNode = {
			Properties._TxTypedModelNode__check,
			Properties._UMLXElement__comments,
			Properties._TxTypedModelNode__dependsOns,
			Properties._TxTypedModelNode__enforce,
			Properties._TxTypedModelNode__iterates,
			Properties._UMLXNamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._TxTypedModelNode__owningTxDiagram,
			Properties._TxTypedModelNode__usedTxPackageNodes
		};

		private static final @NonNull Property @NonNull [] _UMLXElement = {
			Properties._UMLXElement__comments,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _UMLXModel = {
			Properties._UMLXElement__comments,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._UMLXModel__ownedTxDiagrams
		};

		private static final @NonNull Property @NonNull [] _UMLXNamedElement = {
			Properties._UMLXElement__comments,
			Properties._UMLXNamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final @NonNull Property @NonNull [] _UMLXTypedElement = {
			Properties._UMLXElement__comments,
			Properties._UMLXTypedElement__isMany,
			Properties._UMLXTypedElement__isNullFree,
			Properties._UMLXTypedElement__isOrdered,
			Properties._UMLXTypedElement__isRequired,
			Properties._UMLXTypedElement__isUnique,
			Properties._UMLXNamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			Properties._UMLXTypedElement__referredEClassifier
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._RelDiagram__RelDiagram.initProperties(_RelDiagram);
			Fragments._RelDomainNode__RelDomainNode.initProperties(_RelDomainNode);
			Fragments._RelEdge__RelEdge.initProperties(_RelEdge);
			Fragments._RelInvocationEdge__RelInvocationEdge.initProperties(_RelInvocationEdge);
			Fragments._RelInvocationNode__RelInvocationNode.initProperties(_RelInvocationNode);
			Fragments._RelNode__RelNode.initProperties(_RelNode);
			Fragments._RelPatternEdge__RelPatternEdge.initProperties(_RelPatternEdge);
			Fragments._RelPatternNode__RelPatternNode.initProperties(_RelPatternNode);
			Fragments._TxDiagram__TxDiagram.initProperties(_TxDiagram);
			Fragments._TxKeyNode__TxKeyNode.initProperties(_TxKeyNode);
			Fragments._TxNode__TxNode.initProperties(_TxNode);
			Fragments._TxPackageNode__TxPackageNode.initProperties(_TxPackageNode);
			Fragments._TxParameterNode__TxParameterNode.initProperties(_TxParameterNode);
			Fragments._TxPartNode__TxPartNode.initProperties(_TxPartNode);
			Fragments._TxQueryNode__TxQueryNode.initProperties(_TxQueryNode);
			Fragments._TxTypedModelNode__TxTypedModelNode.initProperties(_TxTypedModelNode);
			Fragments._UMLXElement__UMLXElement.initProperties(_UMLXElement);
			Fragments._UMLXModel__UMLXModel.initProperties(_UMLXModel);
			Fragments._UMLXNamedElement__UMLXNamedElement.initProperties(_UMLXNamedElement);
			Fragments._UMLXTypedElement__UMLXTypedElement.initProperties(_UMLXTypedElement);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of UMLXTables::FragmentProperties and all preceding sub-packages.
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
		 * Force initialization of the fields of UMLXTables::EnumerationLiterals and all preceding sub-packages.
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
					LIBRARY.freeze(RESOURCE);
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
		new UMLXTables();
	}

	private UMLXTables() {
		super(UMLXPackage.eNS_URI);
	}
}
