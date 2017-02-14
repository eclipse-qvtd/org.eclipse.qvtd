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
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorEnumeration;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorEnumerationLiteral;
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
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorTypeParameter;
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
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = org.eclipse.ocl.pivot.ids.IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbase", null, org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTcore", null, org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2017/QVTschedule", null, org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_AbstractDatum = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("AbstractDatum", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ClassDatum = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("ClassDatum", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_CompleteClass = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getClassId("CompleteClass", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Edge = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Edge", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Mapping = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore.getClassId("Mapping", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_MappingAction = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("MappingAction", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Node = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Node", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Property = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_$metamodel$.getClassId("Property", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PropertyDatum = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("PropertyDatum", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Region = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Region", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Role = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getClassId("Role", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TypedModel = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbase.getClassId("TypedModel", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull EnumerationId ENUMid_Phase = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2017_s_QVTschedule.getEnumerationId("Phase");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_ClassDatum = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_ClassDatum);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_Edge = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_Edge);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_Node = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_Node);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_PropertyDatum = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_PropertyDatum);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull EnumerationLiteralId ELITid_CONSTANT = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId("CONSTANT");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull EnumerationLiteralId ELITid_LOADED = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId("LOADED");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull EnumerationLiteralId ELITid_PREDICATED = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId("PREDICATED");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull EnumerationLiteralId ELITid_REALIZED = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId("REALIZED");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull EnumerationLiteralId ELITid_SPECULATED = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId("SPECULATED");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull EnumerationLiteralId ELITid_SPECULATION = org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.ENUMid_Phase.getEnumerationLiteralId("SPECULATION");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_AbstractDatum = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_AbstractDatum);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_ClassDatum = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_ClassDatum);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Edge = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_Edge);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_MappingAction = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_MappingAction);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Node = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_Node);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_PropertyDatum = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleTables.CLSSid_PropertyDatum);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			QVTscheduleTables.init();
		}

		public static final @NonNull ExecutorTypeParameter _DatumConnection_CE = new ExecutorTypeParameter(TypeId.T_1, "CE");

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

		public static final @NonNull EcoreExecutorType _AbstractDatum = new EcoreExecutorType(QVTschedulePackage.Literals.ABSTRACT_DATUM, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _BasicMappingRegion = new EcoreExecutorType(QVTschedulePackage.Literals.BASIC_MAPPING_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CastEdge = new EcoreExecutorType(QVTschedulePackage.Literals.CAST_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ClassDatum = new EcoreExecutorType(QVTschedulePackage.Literals.CLASS_DATUM, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ClassDatumAnalysis = new EcoreExecutorType(QVTschedulePackage.Literals.CLASS_DATUM_ANALYSIS, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ComposedNode = new EcoreExecutorType(QVTschedulePackage.Literals.COMPOSED_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Connection = new EcoreExecutorType(QVTschedulePackage.Literals.CONNECTION, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _ConnectionEnd = new EcoreExecutorType(QVTschedulePackage.Literals.CONNECTION_END, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _ConnectionRole = new EcoreExecutorType(QVTschedulePackage.Literals.CONNECTION_ROLE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _DatumConnection = new EcoreExecutorType(QVTschedulePackage.Literals.DATUM_CONNECTION, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._DatumConnection_CE);
		public static final @NonNull EcoreExecutorType _DependencyNode = new EcoreExecutorType(QVTschedulePackage.Literals.DEPENDENCY_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Edge = new EcoreExecutorType(QVTschedulePackage.Literals.EDGE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _EdgeConnection = new EcoreExecutorType(QVTschedulePackage.Literals.EDGE_CONNECTION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ErrorNode = new EcoreExecutorType(QVTschedulePackage.Literals.ERROR_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ExpressionEdge = new EcoreExecutorType(QVTschedulePackage.Literals.EXPRESSION_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _GraphEdge = new EcoreExecutorType(QVTschedulePackage.Literals.GRAPH_EDGE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _GraphNode = new EcoreExecutorType(QVTschedulePackage.Literals.GRAPH_NODE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _InputNode = new EcoreExecutorType(QVTschedulePackage.Literals.INPUT_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _IteratedEdge = new EcoreExecutorType(QVTschedulePackage.Literals.ITERATED_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _IteratorNode = new EcoreExecutorType(QVTschedulePackage.Literals.ITERATOR_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _MappingAction = new EcoreExecutorType(QVTschedulePackage.Literals.MAPPING_ACTION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _MappingRegion = new EcoreExecutorType(QVTschedulePackage.Literals.MAPPING_REGION, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _MicroMappingRegion = new EcoreExecutorType(QVTschedulePackage.Literals.MICRO_MAPPING_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _MultiRegion = new EcoreExecutorType(QVTschedulePackage.Literals.MULTI_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _NamedMappingRegion = new EcoreExecutorType(QVTschedulePackage.Literals.NAMED_MAPPING_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _NavigableEdge = new EcoreExecutorType(QVTschedulePackage.Literals.NAVIGABLE_EDGE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _NavigationEdge = new EcoreExecutorType(QVTschedulePackage.Literals.NAVIGATION_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Node = new EcoreExecutorType(QVTschedulePackage.Literals.NODE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _NodeConnection = new EcoreExecutorType(QVTschedulePackage.Literals.NODE_CONNECTION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _NullNode = new EcoreExecutorType(QVTschedulePackage.Literals.NULL_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OperationNode = new EcoreExecutorType(QVTschedulePackage.Literals.OPERATION_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OperationRegion = new EcoreExecutorType(QVTschedulePackage.Literals.OPERATION_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _PatternTypedNode = new EcoreExecutorType(QVTschedulePackage.Literals.PATTERN_TYPED_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _PatternVariableNode = new EcoreExecutorType(QVTschedulePackage.Literals.PATTERN_VARIABLE_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorEnumeration _Phase = new EcoreExecutorEnumeration(QVTschedulePackage.Literals.PHASE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _PredicateEdge = new EcoreExecutorType(QVTschedulePackage.Literals.PREDICATE_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _PropertyDatum = new EcoreExecutorType(QVTschedulePackage.Literals.PROPERTY_DATUM, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _RecursionEdge = new EcoreExecutorType(QVTschedulePackage.Literals.RECURSION_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Region = new EcoreExecutorType(QVTschedulePackage.Literals.REGION, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _Role = new EcoreExecutorType(QVTschedulePackage.Literals.ROLE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _RootCompositionRegion = new EcoreExecutorType(QVTschedulePackage.Literals.ROOT_COMPOSITION_REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ScheduledRegion = new EcoreExecutorType(QVTschedulePackage.Literals.SCHEDULED_REGION, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _SchedulerConstants = new EcoreExecutorType(QVTschedulePackage.Literals.SCHEDULER_CONSTANTS, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _Symbolable = new EcoreExecutorType(QVTschedulePackage.Literals.SYMBOLABLE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _ToDOTable = new EcoreExecutorType(QVTschedulePackage.Literals.TO_DO_TABLE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _TrueNode = new EcoreExecutorType(QVTschedulePackage.Literals.TRUE_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _UnknownNode = new EcoreExecutorType(QVTschedulePackage.Literals.UNKNOWN_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _VariableNode = new EcoreExecutorType(QVTschedulePackage.Literals.VARIABLE_NODE, PACKAGE, 0 | ExecutorType.ABSTRACT);

		private static final @NonNull EcoreExecutorType @NonNull [] types = {
			_AbstractDatum,
			_BasicMappingRegion,
			_CastEdge,
			_ClassDatum,
			_ClassDatumAnalysis,
			_ComposedNode,
			_Connection,
			_ConnectionEnd,
			_ConnectionRole,
			_DatumConnection,
			_DependencyNode,
			_Edge,
			_EdgeConnection,
			_ErrorNode,
			_ExpressionEdge,
			_GraphEdge,
			_GraphNode,
			_InputNode,
			_IteratedEdge,
			_IteratorNode,
			_MappingAction,
			_MappingRegion,
			_MicroMappingRegion,
			_MultiRegion,
			_NamedMappingRegion,
			_NavigableEdge,
			_NavigationEdge,
			_Node,
			_NodeConnection,
			_NullNode,
			_OperationNode,
			_OperationRegion,
			_PatternTypedNode,
			_PatternVariableNode,
			_Phase,
			_PredicateEdge,
			_PropertyDatum,
			_RecursionEdge,
			_Region,
			_Role,
			_RootCompositionRegion,
			_ScheduledRegion,
			_SchedulerConstants,
			_Symbolable,
			_ToDOTable,
			_TrueNode,
			_UnknownNode,
			_VariableNode
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

		private static final @NonNull ExecutorFragment _AbstractDatum__AbstractDatum = new ExecutorFragment(Types._AbstractDatum, QVTscheduleTables.Types._AbstractDatum);
		private static final @NonNull ExecutorFragment _AbstractDatum__Element = new ExecutorFragment(Types._AbstractDatum, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _AbstractDatum__OclAny = new ExecutorFragment(Types._AbstractDatum, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _AbstractDatum__OclElement = new ExecutorFragment(Types._AbstractDatum, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _AbstractDatum__Visitable = new ExecutorFragment(Types._AbstractDatum, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _BasicMappingRegion__BasicMappingRegion = new ExecutorFragment(Types._BasicMappingRegion, QVTscheduleTables.Types._BasicMappingRegion);
		private static final @NonNull ExecutorFragment _BasicMappingRegion__Element = new ExecutorFragment(Types._BasicMappingRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _BasicMappingRegion__GraphNode = new ExecutorFragment(Types._BasicMappingRegion, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _BasicMappingRegion__MappingRegion = new ExecutorFragment(Types._BasicMappingRegion, QVTscheduleTables.Types._MappingRegion);
		private static final @NonNull ExecutorFragment _BasicMappingRegion__Nameable = new ExecutorFragment(Types._BasicMappingRegion, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _BasicMappingRegion__OclAny = new ExecutorFragment(Types._BasicMappingRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _BasicMappingRegion__OclElement = new ExecutorFragment(Types._BasicMappingRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _BasicMappingRegion__Region = new ExecutorFragment(Types._BasicMappingRegion, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _BasicMappingRegion__Symbolable = new ExecutorFragment(Types._BasicMappingRegion, QVTscheduleTables.Types._Symbolable);
		private static final @NonNull ExecutorFragment _BasicMappingRegion__ToDOTable = new ExecutorFragment(Types._BasicMappingRegion, QVTscheduleTables.Types._ToDOTable);
		private static final @NonNull ExecutorFragment _BasicMappingRegion__Visitable = new ExecutorFragment(Types._BasicMappingRegion, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _CastEdge__CastEdge = new ExecutorFragment(Types._CastEdge, QVTscheduleTables.Types._CastEdge);
		private static final @NonNull ExecutorFragment _CastEdge__ConnectionEnd = new ExecutorFragment(Types._CastEdge, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _CastEdge__Edge = new ExecutorFragment(Types._CastEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _CastEdge__Element = new ExecutorFragment(Types._CastEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _CastEdge__GraphEdge = new ExecutorFragment(Types._CastEdge, QVTscheduleTables.Types._GraphEdge);
		private static final @NonNull ExecutorFragment _CastEdge__Nameable = new ExecutorFragment(Types._CastEdge, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _CastEdge__NavigableEdge = new ExecutorFragment(Types._CastEdge, QVTscheduleTables.Types._NavigableEdge);
		private static final @NonNull ExecutorFragment _CastEdge__OclAny = new ExecutorFragment(Types._CastEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _CastEdge__OclElement = new ExecutorFragment(Types._CastEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _CastEdge__Visitable = new ExecutorFragment(Types._CastEdge, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _ClassDatum__AbstractDatum = new ExecutorFragment(Types._ClassDatum, QVTscheduleTables.Types._AbstractDatum);
		private static final @NonNull ExecutorFragment _ClassDatum__ClassDatum = new ExecutorFragment(Types._ClassDatum, QVTscheduleTables.Types._ClassDatum);
		private static final @NonNull ExecutorFragment _ClassDatum__Element = new ExecutorFragment(Types._ClassDatum, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ClassDatum__OclAny = new ExecutorFragment(Types._ClassDatum, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ClassDatum__OclElement = new ExecutorFragment(Types._ClassDatum, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _ClassDatum__Visitable = new ExecutorFragment(Types._ClassDatum, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _ClassDatumAnalysis__ClassDatumAnalysis = new ExecutorFragment(Types._ClassDatumAnalysis, QVTscheduleTables.Types._ClassDatumAnalysis);
		private static final @NonNull ExecutorFragment _ClassDatumAnalysis__Element = new ExecutorFragment(Types._ClassDatumAnalysis, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ClassDatumAnalysis__OclAny = new ExecutorFragment(Types._ClassDatumAnalysis, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ClassDatumAnalysis__OclElement = new ExecutorFragment(Types._ClassDatumAnalysis, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _ClassDatumAnalysis__Visitable = new ExecutorFragment(Types._ClassDatumAnalysis, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _ComposedNode__ComposedNode = new ExecutorFragment(Types._ComposedNode, QVTscheduleTables.Types._ComposedNode);
		private static final @NonNull ExecutorFragment _ComposedNode__ConnectionEnd = new ExecutorFragment(Types._ComposedNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _ComposedNode__Element = new ExecutorFragment(Types._ComposedNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ComposedNode__GraphNode = new ExecutorFragment(Types._ComposedNode, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _ComposedNode__Nameable = new ExecutorFragment(Types._ComposedNode, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _ComposedNode__Node = new ExecutorFragment(Types._ComposedNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _ComposedNode__OclAny = new ExecutorFragment(Types._ComposedNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ComposedNode__OclElement = new ExecutorFragment(Types._ComposedNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _ComposedNode__Visitable = new ExecutorFragment(Types._ComposedNode, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Connection__Connection = new ExecutorFragment(Types._Connection, QVTscheduleTables.Types._Connection);
		private static final @NonNull ExecutorFragment _Connection__Element = new ExecutorFragment(Types._Connection, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Connection__Nameable = new ExecutorFragment(Types._Connection, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _Connection__OclAny = new ExecutorFragment(Types._Connection, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Connection__OclElement = new ExecutorFragment(Types._Connection, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Connection__Symbolable = new ExecutorFragment(Types._Connection, QVTscheduleTables.Types._Symbolable);
		private static final @NonNull ExecutorFragment _Connection__Visitable = new ExecutorFragment(Types._Connection, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _ConnectionEnd__ConnectionEnd = new ExecutorFragment(Types._ConnectionEnd, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _ConnectionEnd__OclAny = new ExecutorFragment(Types._ConnectionEnd, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ConnectionEnd__OclElement = new ExecutorFragment(Types._ConnectionEnd, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _ConnectionRole__ConnectionRole = new ExecutorFragment(Types._ConnectionRole, QVTscheduleTables.Types._ConnectionRole);
		private static final @NonNull ExecutorFragment _ConnectionRole__Element = new ExecutorFragment(Types._ConnectionRole, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ConnectionRole__OclAny = new ExecutorFragment(Types._ConnectionRole, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ConnectionRole__OclElement = new ExecutorFragment(Types._ConnectionRole, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _ConnectionRole__Visitable = new ExecutorFragment(Types._ConnectionRole, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _DatumConnection__Connection = new ExecutorFragment(Types._DatumConnection, QVTscheduleTables.Types._Connection);
		private static final @NonNull ExecutorFragment _DatumConnection__DatumConnection = new ExecutorFragment(Types._DatumConnection, QVTscheduleTables.Types._DatumConnection);
		private static final @NonNull ExecutorFragment _DatumConnection__Element = new ExecutorFragment(Types._DatumConnection, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _DatumConnection__GraphEdge = new ExecutorFragment(Types._DatumConnection, QVTscheduleTables.Types._GraphEdge);
		private static final @NonNull ExecutorFragment _DatumConnection__GraphNode = new ExecutorFragment(Types._DatumConnection, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _DatumConnection__Nameable = new ExecutorFragment(Types._DatumConnection, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _DatumConnection__OclAny = new ExecutorFragment(Types._DatumConnection, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _DatumConnection__OclElement = new ExecutorFragment(Types._DatumConnection, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _DatumConnection__Symbolable = new ExecutorFragment(Types._DatumConnection, QVTscheduleTables.Types._Symbolable);
		private static final @NonNull ExecutorFragment _DatumConnection__Visitable = new ExecutorFragment(Types._DatumConnection, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _DependencyNode__ConnectionEnd = new ExecutorFragment(Types._DependencyNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _DependencyNode__DependencyNode = new ExecutorFragment(Types._DependencyNode, QVTscheduleTables.Types._DependencyNode);
		private static final @NonNull ExecutorFragment _DependencyNode__Element = new ExecutorFragment(Types._DependencyNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _DependencyNode__GraphNode = new ExecutorFragment(Types._DependencyNode, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _DependencyNode__Nameable = new ExecutorFragment(Types._DependencyNode, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _DependencyNode__Node = new ExecutorFragment(Types._DependencyNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _DependencyNode__OclAny = new ExecutorFragment(Types._DependencyNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _DependencyNode__OclElement = new ExecutorFragment(Types._DependencyNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _DependencyNode__Visitable = new ExecutorFragment(Types._DependencyNode, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Edge__Edge = new ExecutorFragment(Types._Edge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _Edge__Element = new ExecutorFragment(Types._Edge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Edge__GraphEdge = new ExecutorFragment(Types._Edge, QVTscheduleTables.Types._GraphEdge);
		private static final @NonNull ExecutorFragment _Edge__Nameable = new ExecutorFragment(Types._Edge, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _Edge__OclAny = new ExecutorFragment(Types._Edge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Edge__OclElement = new ExecutorFragment(Types._Edge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Edge__Visitable = new ExecutorFragment(Types._Edge, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _EdgeConnection__Connection = new ExecutorFragment(Types._EdgeConnection, QVTscheduleTables.Types._Connection);
		private static final @NonNull ExecutorFragment _EdgeConnection__DatumConnection = new ExecutorFragment(Types._EdgeConnection, QVTscheduleTables.Types._DatumConnection);
		private static final @NonNull ExecutorFragment _EdgeConnection__EdgeConnection = new ExecutorFragment(Types._EdgeConnection, QVTscheduleTables.Types._EdgeConnection);
		private static final @NonNull ExecutorFragment _EdgeConnection__Element = new ExecutorFragment(Types._EdgeConnection, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _EdgeConnection__GraphEdge = new ExecutorFragment(Types._EdgeConnection, QVTscheduleTables.Types._GraphEdge);
		private static final @NonNull ExecutorFragment _EdgeConnection__GraphNode = new ExecutorFragment(Types._EdgeConnection, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _EdgeConnection__Nameable = new ExecutorFragment(Types._EdgeConnection, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _EdgeConnection__OclAny = new ExecutorFragment(Types._EdgeConnection, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _EdgeConnection__OclElement = new ExecutorFragment(Types._EdgeConnection, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _EdgeConnection__Symbolable = new ExecutorFragment(Types._EdgeConnection, QVTscheduleTables.Types._Symbolable);
		private static final @NonNull ExecutorFragment _EdgeConnection__Visitable = new ExecutorFragment(Types._EdgeConnection, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _ErrorNode__ConnectionEnd = new ExecutorFragment(Types._ErrorNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _ErrorNode__Element = new ExecutorFragment(Types._ErrorNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ErrorNode__ErrorNode = new ExecutorFragment(Types._ErrorNode, QVTscheduleTables.Types._ErrorNode);
		private static final @NonNull ExecutorFragment _ErrorNode__GraphNode = new ExecutorFragment(Types._ErrorNode, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _ErrorNode__Nameable = new ExecutorFragment(Types._ErrorNode, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _ErrorNode__Node = new ExecutorFragment(Types._ErrorNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _ErrorNode__OclAny = new ExecutorFragment(Types._ErrorNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ErrorNode__OclElement = new ExecutorFragment(Types._ErrorNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _ErrorNode__Visitable = new ExecutorFragment(Types._ErrorNode, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _ExpressionEdge__Edge = new ExecutorFragment(Types._ExpressionEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _ExpressionEdge__Element = new ExecutorFragment(Types._ExpressionEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ExpressionEdge__ExpressionEdge = new ExecutorFragment(Types._ExpressionEdge, QVTscheduleTables.Types._ExpressionEdge);
		private static final @NonNull ExecutorFragment _ExpressionEdge__GraphEdge = new ExecutorFragment(Types._ExpressionEdge, QVTscheduleTables.Types._GraphEdge);
		private static final @NonNull ExecutorFragment _ExpressionEdge__Nameable = new ExecutorFragment(Types._ExpressionEdge, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _ExpressionEdge__OclAny = new ExecutorFragment(Types._ExpressionEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ExpressionEdge__OclElement = new ExecutorFragment(Types._ExpressionEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _ExpressionEdge__Visitable = new ExecutorFragment(Types._ExpressionEdge, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _GraphEdge__GraphEdge = new ExecutorFragment(Types._GraphEdge, QVTscheduleTables.Types._GraphEdge);
		private static final @NonNull ExecutorFragment _GraphEdge__OclAny = new ExecutorFragment(Types._GraphEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _GraphEdge__OclElement = new ExecutorFragment(Types._GraphEdge, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _GraphNode__GraphNode = new ExecutorFragment(Types._GraphNode, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _GraphNode__OclAny = new ExecutorFragment(Types._GraphNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _GraphNode__OclElement = new ExecutorFragment(Types._GraphNode, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _InputNode__ConnectionEnd = new ExecutorFragment(Types._InputNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _InputNode__Element = new ExecutorFragment(Types._InputNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _InputNode__GraphNode = new ExecutorFragment(Types._InputNode, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _InputNode__InputNode = new ExecutorFragment(Types._InputNode, QVTscheduleTables.Types._InputNode);
		private static final @NonNull ExecutorFragment _InputNode__Nameable = new ExecutorFragment(Types._InputNode, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _InputNode__Node = new ExecutorFragment(Types._InputNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _InputNode__OclAny = new ExecutorFragment(Types._InputNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _InputNode__OclElement = new ExecutorFragment(Types._InputNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _InputNode__Visitable = new ExecutorFragment(Types._InputNode, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _IteratedEdge__Edge = new ExecutorFragment(Types._IteratedEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _IteratedEdge__Element = new ExecutorFragment(Types._IteratedEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _IteratedEdge__GraphEdge = new ExecutorFragment(Types._IteratedEdge, QVTscheduleTables.Types._GraphEdge);
		private static final @NonNull ExecutorFragment _IteratedEdge__IteratedEdge = new ExecutorFragment(Types._IteratedEdge, QVTscheduleTables.Types._IteratedEdge);
		private static final @NonNull ExecutorFragment _IteratedEdge__Nameable = new ExecutorFragment(Types._IteratedEdge, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _IteratedEdge__OclAny = new ExecutorFragment(Types._IteratedEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _IteratedEdge__OclElement = new ExecutorFragment(Types._IteratedEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _IteratedEdge__Visitable = new ExecutorFragment(Types._IteratedEdge, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _IteratorNode__ConnectionEnd = new ExecutorFragment(Types._IteratorNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _IteratorNode__Element = new ExecutorFragment(Types._IteratorNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _IteratorNode__GraphNode = new ExecutorFragment(Types._IteratorNode, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _IteratorNode__IteratorNode = new ExecutorFragment(Types._IteratorNode, QVTscheduleTables.Types._IteratorNode);
		private static final @NonNull ExecutorFragment _IteratorNode__Nameable = new ExecutorFragment(Types._IteratorNode, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _IteratorNode__Node = new ExecutorFragment(Types._IteratorNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _IteratorNode__OclAny = new ExecutorFragment(Types._IteratorNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _IteratorNode__OclElement = new ExecutorFragment(Types._IteratorNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _IteratorNode__VariableNode = new ExecutorFragment(Types._IteratorNode, QVTscheduleTables.Types._VariableNode);
		private static final @NonNull ExecutorFragment _IteratorNode__Visitable = new ExecutorFragment(Types._IteratorNode, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _MappingAction__Element = new ExecutorFragment(Types._MappingAction, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _MappingAction__MappingAction = new ExecutorFragment(Types._MappingAction, QVTscheduleTables.Types._MappingAction);
		private static final @NonNull ExecutorFragment _MappingAction__OclAny = new ExecutorFragment(Types._MappingAction, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _MappingAction__OclElement = new ExecutorFragment(Types._MappingAction, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _MappingAction__Visitable = new ExecutorFragment(Types._MappingAction, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _MappingRegion__Element = new ExecutorFragment(Types._MappingRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _MappingRegion__GraphNode = new ExecutorFragment(Types._MappingRegion, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _MappingRegion__MappingRegion = new ExecutorFragment(Types._MappingRegion, QVTscheduleTables.Types._MappingRegion);
		private static final @NonNull ExecutorFragment _MappingRegion__Nameable = new ExecutorFragment(Types._MappingRegion, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _MappingRegion__OclAny = new ExecutorFragment(Types._MappingRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _MappingRegion__OclElement = new ExecutorFragment(Types._MappingRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _MappingRegion__Region = new ExecutorFragment(Types._MappingRegion, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _MappingRegion__Symbolable = new ExecutorFragment(Types._MappingRegion, QVTscheduleTables.Types._Symbolable);
		private static final @NonNull ExecutorFragment _MappingRegion__ToDOTable = new ExecutorFragment(Types._MappingRegion, QVTscheduleTables.Types._ToDOTable);
		private static final @NonNull ExecutorFragment _MappingRegion__Visitable = new ExecutorFragment(Types._MappingRegion, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _MicroMappingRegion__Element = new ExecutorFragment(Types._MicroMappingRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _MicroMappingRegion__GraphNode = new ExecutorFragment(Types._MicroMappingRegion, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _MicroMappingRegion__MappingRegion = new ExecutorFragment(Types._MicroMappingRegion, QVTscheduleTables.Types._MappingRegion);
		private static final @NonNull ExecutorFragment _MicroMappingRegion__MicroMappingRegion = new ExecutorFragment(Types._MicroMappingRegion, QVTscheduleTables.Types._MicroMappingRegion);
		private static final @NonNull ExecutorFragment _MicroMappingRegion__Nameable = new ExecutorFragment(Types._MicroMappingRegion, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _MicroMappingRegion__OclAny = new ExecutorFragment(Types._MicroMappingRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _MicroMappingRegion__OclElement = new ExecutorFragment(Types._MicroMappingRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _MicroMappingRegion__Region = new ExecutorFragment(Types._MicroMappingRegion, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _MicroMappingRegion__Symbolable = new ExecutorFragment(Types._MicroMappingRegion, QVTscheduleTables.Types._Symbolable);
		private static final @NonNull ExecutorFragment _MicroMappingRegion__ToDOTable = new ExecutorFragment(Types._MicroMappingRegion, QVTscheduleTables.Types._ToDOTable);
		private static final @NonNull ExecutorFragment _MicroMappingRegion__Visitable = new ExecutorFragment(Types._MicroMappingRegion, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _MultiRegion__Element = new ExecutorFragment(Types._MultiRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _MultiRegion__MultiRegion = new ExecutorFragment(Types._MultiRegion, QVTscheduleTables.Types._MultiRegion);
		private static final @NonNull ExecutorFragment _MultiRegion__OclAny = new ExecutorFragment(Types._MultiRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _MultiRegion__OclElement = new ExecutorFragment(Types._MultiRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _MultiRegion__Visitable = new ExecutorFragment(Types._MultiRegion, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _NamedMappingRegion__Element = new ExecutorFragment(Types._NamedMappingRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _NamedMappingRegion__GraphNode = new ExecutorFragment(Types._NamedMappingRegion, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _NamedMappingRegion__MappingRegion = new ExecutorFragment(Types._NamedMappingRegion, QVTscheduleTables.Types._MappingRegion);
		private static final @NonNull ExecutorFragment _NamedMappingRegion__Nameable = new ExecutorFragment(Types._NamedMappingRegion, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _NamedMappingRegion__NamedMappingRegion = new ExecutorFragment(Types._NamedMappingRegion, QVTscheduleTables.Types._NamedMappingRegion);
		private static final @NonNull ExecutorFragment _NamedMappingRegion__OclAny = new ExecutorFragment(Types._NamedMappingRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NamedMappingRegion__OclElement = new ExecutorFragment(Types._NamedMappingRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _NamedMappingRegion__Region = new ExecutorFragment(Types._NamedMappingRegion, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _NamedMappingRegion__Symbolable = new ExecutorFragment(Types._NamedMappingRegion, QVTscheduleTables.Types._Symbolable);
		private static final @NonNull ExecutorFragment _NamedMappingRegion__ToDOTable = new ExecutorFragment(Types._NamedMappingRegion, QVTscheduleTables.Types._ToDOTable);
		private static final @NonNull ExecutorFragment _NamedMappingRegion__Visitable = new ExecutorFragment(Types._NamedMappingRegion, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _NavigableEdge__ConnectionEnd = new ExecutorFragment(Types._NavigableEdge, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _NavigableEdge__Edge = new ExecutorFragment(Types._NavigableEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _NavigableEdge__Element = new ExecutorFragment(Types._NavigableEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _NavigableEdge__GraphEdge = new ExecutorFragment(Types._NavigableEdge, QVTscheduleTables.Types._GraphEdge);
		private static final @NonNull ExecutorFragment _NavigableEdge__Nameable = new ExecutorFragment(Types._NavigableEdge, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _NavigableEdge__NavigableEdge = new ExecutorFragment(Types._NavigableEdge, QVTscheduleTables.Types._NavigableEdge);
		private static final @NonNull ExecutorFragment _NavigableEdge__OclAny = new ExecutorFragment(Types._NavigableEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NavigableEdge__OclElement = new ExecutorFragment(Types._NavigableEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _NavigableEdge__Visitable = new ExecutorFragment(Types._NavigableEdge, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _NavigationEdge__ConnectionEnd = new ExecutorFragment(Types._NavigationEdge, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _NavigationEdge__Edge = new ExecutorFragment(Types._NavigationEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _NavigationEdge__Element = new ExecutorFragment(Types._NavigationEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _NavigationEdge__GraphEdge = new ExecutorFragment(Types._NavigationEdge, QVTscheduleTables.Types._GraphEdge);
		private static final @NonNull ExecutorFragment _NavigationEdge__Nameable = new ExecutorFragment(Types._NavigationEdge, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _NavigationEdge__NavigableEdge = new ExecutorFragment(Types._NavigationEdge, QVTscheduleTables.Types._NavigableEdge);
		private static final @NonNull ExecutorFragment _NavigationEdge__NavigationEdge = new ExecutorFragment(Types._NavigationEdge, QVTscheduleTables.Types._NavigationEdge);
		private static final @NonNull ExecutorFragment _NavigationEdge__OclAny = new ExecutorFragment(Types._NavigationEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NavigationEdge__OclElement = new ExecutorFragment(Types._NavigationEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _NavigationEdge__Visitable = new ExecutorFragment(Types._NavigationEdge, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Node__ConnectionEnd = new ExecutorFragment(Types._Node, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _Node__Element = new ExecutorFragment(Types._Node, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Node__GraphNode = new ExecutorFragment(Types._Node, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _Node__Nameable = new ExecutorFragment(Types._Node, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _Node__Node = new ExecutorFragment(Types._Node, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _Node__OclAny = new ExecutorFragment(Types._Node, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Node__OclElement = new ExecutorFragment(Types._Node, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Node__Visitable = new ExecutorFragment(Types._Node, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _NodeConnection__Connection = new ExecutorFragment(Types._NodeConnection, QVTscheduleTables.Types._Connection);
		private static final @NonNull ExecutorFragment _NodeConnection__DatumConnection = new ExecutorFragment(Types._NodeConnection, QVTscheduleTables.Types._DatumConnection);
		private static final @NonNull ExecutorFragment _NodeConnection__Element = new ExecutorFragment(Types._NodeConnection, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _NodeConnection__GraphEdge = new ExecutorFragment(Types._NodeConnection, QVTscheduleTables.Types._GraphEdge);
		private static final @NonNull ExecutorFragment _NodeConnection__GraphNode = new ExecutorFragment(Types._NodeConnection, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _NodeConnection__Nameable = new ExecutorFragment(Types._NodeConnection, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _NodeConnection__NodeConnection = new ExecutorFragment(Types._NodeConnection, QVTscheduleTables.Types._NodeConnection);
		private static final @NonNull ExecutorFragment _NodeConnection__OclAny = new ExecutorFragment(Types._NodeConnection, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NodeConnection__OclElement = new ExecutorFragment(Types._NodeConnection, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _NodeConnection__Symbolable = new ExecutorFragment(Types._NodeConnection, QVTscheduleTables.Types._Symbolable);
		private static final @NonNull ExecutorFragment _NodeConnection__Visitable = new ExecutorFragment(Types._NodeConnection, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _NullNode__ConnectionEnd = new ExecutorFragment(Types._NullNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _NullNode__Element = new ExecutorFragment(Types._NullNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _NullNode__GraphNode = new ExecutorFragment(Types._NullNode, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _NullNode__Nameable = new ExecutorFragment(Types._NullNode, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _NullNode__Node = new ExecutorFragment(Types._NullNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _NullNode__NullNode = new ExecutorFragment(Types._NullNode, QVTscheduleTables.Types._NullNode);
		private static final @NonNull ExecutorFragment _NullNode__OclAny = new ExecutorFragment(Types._NullNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _NullNode__OclElement = new ExecutorFragment(Types._NullNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _NullNode__Visitable = new ExecutorFragment(Types._NullNode, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _OperationNode__ConnectionEnd = new ExecutorFragment(Types._OperationNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _OperationNode__Element = new ExecutorFragment(Types._OperationNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _OperationNode__GraphNode = new ExecutorFragment(Types._OperationNode, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _OperationNode__Nameable = new ExecutorFragment(Types._OperationNode, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _OperationNode__Node = new ExecutorFragment(Types._OperationNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _OperationNode__OclAny = new ExecutorFragment(Types._OperationNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OperationNode__OclElement = new ExecutorFragment(Types._OperationNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _OperationNode__OperationNode = new ExecutorFragment(Types._OperationNode, QVTscheduleTables.Types._OperationNode);
		private static final @NonNull ExecutorFragment _OperationNode__Visitable = new ExecutorFragment(Types._OperationNode, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _OperationRegion__Element = new ExecutorFragment(Types._OperationRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _OperationRegion__GraphNode = new ExecutorFragment(Types._OperationRegion, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _OperationRegion__Nameable = new ExecutorFragment(Types._OperationRegion, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _OperationRegion__OclAny = new ExecutorFragment(Types._OperationRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _OperationRegion__OclElement = new ExecutorFragment(Types._OperationRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _OperationRegion__OperationRegion = new ExecutorFragment(Types._OperationRegion, QVTscheduleTables.Types._OperationRegion);
		private static final @NonNull ExecutorFragment _OperationRegion__Region = new ExecutorFragment(Types._OperationRegion, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _OperationRegion__Symbolable = new ExecutorFragment(Types._OperationRegion, QVTscheduleTables.Types._Symbolable);
		private static final @NonNull ExecutorFragment _OperationRegion__ToDOTable = new ExecutorFragment(Types._OperationRegion, QVTscheduleTables.Types._ToDOTable);
		private static final @NonNull ExecutorFragment _OperationRegion__Visitable = new ExecutorFragment(Types._OperationRegion, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _PatternTypedNode__ConnectionEnd = new ExecutorFragment(Types._PatternTypedNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _PatternTypedNode__Element = new ExecutorFragment(Types._PatternTypedNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _PatternTypedNode__GraphNode = new ExecutorFragment(Types._PatternTypedNode, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _PatternTypedNode__Nameable = new ExecutorFragment(Types._PatternTypedNode, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _PatternTypedNode__Node = new ExecutorFragment(Types._PatternTypedNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _PatternTypedNode__OclAny = new ExecutorFragment(Types._PatternTypedNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _PatternTypedNode__OclElement = new ExecutorFragment(Types._PatternTypedNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _PatternTypedNode__PatternTypedNode = new ExecutorFragment(Types._PatternTypedNode, QVTscheduleTables.Types._PatternTypedNode);
		private static final @NonNull ExecutorFragment _PatternTypedNode__Visitable = new ExecutorFragment(Types._PatternTypedNode, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _PatternVariableNode__ConnectionEnd = new ExecutorFragment(Types._PatternVariableNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _PatternVariableNode__Element = new ExecutorFragment(Types._PatternVariableNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _PatternVariableNode__GraphNode = new ExecutorFragment(Types._PatternVariableNode, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _PatternVariableNode__Nameable = new ExecutorFragment(Types._PatternVariableNode, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _PatternVariableNode__Node = new ExecutorFragment(Types._PatternVariableNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _PatternVariableNode__OclAny = new ExecutorFragment(Types._PatternVariableNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _PatternVariableNode__OclElement = new ExecutorFragment(Types._PatternVariableNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _PatternVariableNode__PatternVariableNode = new ExecutorFragment(Types._PatternVariableNode, QVTscheduleTables.Types._PatternVariableNode);
		private static final @NonNull ExecutorFragment _PatternVariableNode__VariableNode = new ExecutorFragment(Types._PatternVariableNode, QVTscheduleTables.Types._VariableNode);
		private static final @NonNull ExecutorFragment _PatternVariableNode__Visitable = new ExecutorFragment(Types._PatternVariableNode, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Phase__OclAny = new ExecutorFragment(Types._Phase, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Phase__OclElement = new ExecutorFragment(Types._Phase, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Phase__OclEnumeration = new ExecutorFragment(Types._Phase, OCLstdlibTables.Types._OclEnumeration);
		private static final @NonNull ExecutorFragment _Phase__OclType = new ExecutorFragment(Types._Phase, OCLstdlibTables.Types._OclType);
		private static final @NonNull ExecutorFragment _Phase__Phase = new ExecutorFragment(Types._Phase, QVTscheduleTables.Types._Phase);

		private static final @NonNull ExecutorFragment _PredicateEdge__Edge = new ExecutorFragment(Types._PredicateEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _PredicateEdge__Element = new ExecutorFragment(Types._PredicateEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _PredicateEdge__GraphEdge = new ExecutorFragment(Types._PredicateEdge, QVTscheduleTables.Types._GraphEdge);
		private static final @NonNull ExecutorFragment _PredicateEdge__Nameable = new ExecutorFragment(Types._PredicateEdge, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _PredicateEdge__OclAny = new ExecutorFragment(Types._PredicateEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _PredicateEdge__OclElement = new ExecutorFragment(Types._PredicateEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _PredicateEdge__PredicateEdge = new ExecutorFragment(Types._PredicateEdge, QVTscheduleTables.Types._PredicateEdge);
		private static final @NonNull ExecutorFragment _PredicateEdge__Visitable = new ExecutorFragment(Types._PredicateEdge, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _PropertyDatum__AbstractDatum = new ExecutorFragment(Types._PropertyDatum, QVTscheduleTables.Types._AbstractDatum);
		private static final @NonNull ExecutorFragment _PropertyDatum__Element = new ExecutorFragment(Types._PropertyDatum, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _PropertyDatum__OclAny = new ExecutorFragment(Types._PropertyDatum, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _PropertyDatum__OclElement = new ExecutorFragment(Types._PropertyDatum, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _PropertyDatum__PropertyDatum = new ExecutorFragment(Types._PropertyDatum, QVTscheduleTables.Types._PropertyDatum);
		private static final @NonNull ExecutorFragment _PropertyDatum__Visitable = new ExecutorFragment(Types._PropertyDatum, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _RecursionEdge__Edge = new ExecutorFragment(Types._RecursionEdge, QVTscheduleTables.Types._Edge);
		private static final @NonNull ExecutorFragment _RecursionEdge__Element = new ExecutorFragment(Types._RecursionEdge, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _RecursionEdge__GraphEdge = new ExecutorFragment(Types._RecursionEdge, QVTscheduleTables.Types._GraphEdge);
		private static final @NonNull ExecutorFragment _RecursionEdge__Nameable = new ExecutorFragment(Types._RecursionEdge, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _RecursionEdge__OclAny = new ExecutorFragment(Types._RecursionEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _RecursionEdge__OclElement = new ExecutorFragment(Types._RecursionEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _RecursionEdge__RecursionEdge = new ExecutorFragment(Types._RecursionEdge, QVTscheduleTables.Types._RecursionEdge);
		private static final @NonNull ExecutorFragment _RecursionEdge__Visitable = new ExecutorFragment(Types._RecursionEdge, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Region__Element = new ExecutorFragment(Types._Region, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Region__GraphNode = new ExecutorFragment(Types._Region, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _Region__Nameable = new ExecutorFragment(Types._Region, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _Region__OclAny = new ExecutorFragment(Types._Region, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Region__OclElement = new ExecutorFragment(Types._Region, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Region__Region = new ExecutorFragment(Types._Region, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _Region__Symbolable = new ExecutorFragment(Types._Region, QVTscheduleTables.Types._Symbolable);
		private static final @NonNull ExecutorFragment _Region__ToDOTable = new ExecutorFragment(Types._Region, QVTscheduleTables.Types._ToDOTable);
		private static final @NonNull ExecutorFragment _Region__Visitable = new ExecutorFragment(Types._Region, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Role__Element = new ExecutorFragment(Types._Role, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _Role__OclAny = new ExecutorFragment(Types._Role, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Role__OclElement = new ExecutorFragment(Types._Role, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Role__Role = new ExecutorFragment(Types._Role, QVTscheduleTables.Types._Role);
		private static final @NonNull ExecutorFragment _Role__Visitable = new ExecutorFragment(Types._Role, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _RootCompositionRegion__Element = new ExecutorFragment(Types._RootCompositionRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _RootCompositionRegion__GraphNode = new ExecutorFragment(Types._RootCompositionRegion, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _RootCompositionRegion__Nameable = new ExecutorFragment(Types._RootCompositionRegion, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _RootCompositionRegion__OclAny = new ExecutorFragment(Types._RootCompositionRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _RootCompositionRegion__OclElement = new ExecutorFragment(Types._RootCompositionRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _RootCompositionRegion__Region = new ExecutorFragment(Types._RootCompositionRegion, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _RootCompositionRegion__RootCompositionRegion = new ExecutorFragment(Types._RootCompositionRegion, QVTscheduleTables.Types._RootCompositionRegion);
		private static final @NonNull ExecutorFragment _RootCompositionRegion__Symbolable = new ExecutorFragment(Types._RootCompositionRegion, QVTscheduleTables.Types._Symbolable);
		private static final @NonNull ExecutorFragment _RootCompositionRegion__ToDOTable = new ExecutorFragment(Types._RootCompositionRegion, QVTscheduleTables.Types._ToDOTable);
		private static final @NonNull ExecutorFragment _RootCompositionRegion__Visitable = new ExecutorFragment(Types._RootCompositionRegion, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _ScheduledRegion__Element = new ExecutorFragment(Types._ScheduledRegion, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _ScheduledRegion__GraphNode = new ExecutorFragment(Types._ScheduledRegion, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _ScheduledRegion__Nameable = new ExecutorFragment(Types._ScheduledRegion, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _ScheduledRegion__OclAny = new ExecutorFragment(Types._ScheduledRegion, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ScheduledRegion__OclElement = new ExecutorFragment(Types._ScheduledRegion, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _ScheduledRegion__Region = new ExecutorFragment(Types._ScheduledRegion, QVTscheduleTables.Types._Region);
		private static final @NonNull ExecutorFragment _ScheduledRegion__ScheduledRegion = new ExecutorFragment(Types._ScheduledRegion, QVTscheduleTables.Types._ScheduledRegion);
		private static final @NonNull ExecutorFragment _ScheduledRegion__Symbolable = new ExecutorFragment(Types._ScheduledRegion, QVTscheduleTables.Types._Symbolable);
		private static final @NonNull ExecutorFragment _ScheduledRegion__ToDOTable = new ExecutorFragment(Types._ScheduledRegion, QVTscheduleTables.Types._ToDOTable);
		private static final @NonNull ExecutorFragment _ScheduledRegion__Visitable = new ExecutorFragment(Types._ScheduledRegion, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _SchedulerConstants__Element = new ExecutorFragment(Types._SchedulerConstants, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _SchedulerConstants__OclAny = new ExecutorFragment(Types._SchedulerConstants, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _SchedulerConstants__OclElement = new ExecutorFragment(Types._SchedulerConstants, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _SchedulerConstants__SchedulerConstants = new ExecutorFragment(Types._SchedulerConstants, QVTscheduleTables.Types._SchedulerConstants);
		private static final @NonNull ExecutorFragment _SchedulerConstants__Visitable = new ExecutorFragment(Types._SchedulerConstants, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Symbolable__OclAny = new ExecutorFragment(Types._Symbolable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Symbolable__OclElement = new ExecutorFragment(Types._Symbolable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _Symbolable__Symbolable = new ExecutorFragment(Types._Symbolable, QVTscheduleTables.Types._Symbolable);

		private static final @NonNull ExecutorFragment _ToDOTable__OclAny = new ExecutorFragment(Types._ToDOTable, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _ToDOTable__OclElement = new ExecutorFragment(Types._ToDOTable, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _ToDOTable__ToDOTable = new ExecutorFragment(Types._ToDOTable, QVTscheduleTables.Types._ToDOTable);

		private static final @NonNull ExecutorFragment _TrueNode__ConnectionEnd = new ExecutorFragment(Types._TrueNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _TrueNode__Element = new ExecutorFragment(Types._TrueNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _TrueNode__GraphNode = new ExecutorFragment(Types._TrueNode, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _TrueNode__Nameable = new ExecutorFragment(Types._TrueNode, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _TrueNode__Node = new ExecutorFragment(Types._TrueNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _TrueNode__OclAny = new ExecutorFragment(Types._TrueNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _TrueNode__OclElement = new ExecutorFragment(Types._TrueNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _TrueNode__TrueNode = new ExecutorFragment(Types._TrueNode, QVTscheduleTables.Types._TrueNode);
		private static final @NonNull ExecutorFragment _TrueNode__Visitable = new ExecutorFragment(Types._TrueNode, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _UnknownNode__ConnectionEnd = new ExecutorFragment(Types._UnknownNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _UnknownNode__Element = new ExecutorFragment(Types._UnknownNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _UnknownNode__GraphNode = new ExecutorFragment(Types._UnknownNode, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _UnknownNode__Nameable = new ExecutorFragment(Types._UnknownNode, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _UnknownNode__Node = new ExecutorFragment(Types._UnknownNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _UnknownNode__OclAny = new ExecutorFragment(Types._UnknownNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _UnknownNode__OclElement = new ExecutorFragment(Types._UnknownNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _UnknownNode__UnknownNode = new ExecutorFragment(Types._UnknownNode, QVTscheduleTables.Types._UnknownNode);
		private static final @NonNull ExecutorFragment _UnknownNode__Visitable = new ExecutorFragment(Types._UnknownNode, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _VariableNode__ConnectionEnd = new ExecutorFragment(Types._VariableNode, QVTscheduleTables.Types._ConnectionEnd);
		private static final @NonNull ExecutorFragment _VariableNode__Element = new ExecutorFragment(Types._VariableNode, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _VariableNode__GraphNode = new ExecutorFragment(Types._VariableNode, QVTscheduleTables.Types._GraphNode);
		private static final @NonNull ExecutorFragment _VariableNode__Nameable = new ExecutorFragment(Types._VariableNode, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _VariableNode__Node = new ExecutorFragment(Types._VariableNode, QVTscheduleTables.Types._Node);
		private static final @NonNull ExecutorFragment _VariableNode__OclAny = new ExecutorFragment(Types._VariableNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _VariableNode__OclElement = new ExecutorFragment(Types._VariableNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _VariableNode__VariableNode = new ExecutorFragment(Types._VariableNode, QVTscheduleTables.Types._VariableNode);
		private static final @NonNull ExecutorFragment _VariableNode__Visitable = new ExecutorFragment(Types._VariableNode, PivotTables.Types._Visitable);

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

		public static final @NonNull ExecutorProperty _AbstractDatum__producedBy = new EcoreExecutorProperty(QVTschedulePackage.Literals.ABSTRACT_DATUM__PRODUCED_BY, Types._AbstractDatum, 0);
		public static final @NonNull ExecutorProperty _AbstractDatum__requiredBy = new EcoreExecutorProperty(QVTschedulePackage.Literals.ABSTRACT_DATUM__REQUIRED_BY, Types._AbstractDatum, 1);
		public static final @NonNull ExecutorProperty _AbstractDatum__typedModel = new EcoreExecutorProperty(QVTschedulePackage.Literals.ABSTRACT_DATUM__TYPED_MODEL, Types._AbstractDatum, 2);

		public static final @NonNull ExecutorProperty _ClassDatum__completeClass = new EcoreExecutorProperty(QVTschedulePackage.Literals.CLASS_DATUM__COMPLETE_CLASS, Types._ClassDatum, 0);
		public static final @NonNull ExecutorProperty _ClassDatum__propertyDatums = new EcoreExecutorProperty(QVTschedulePackage.Literals.CLASS_DATUM__PROPERTY_DATUMS, Types._ClassDatum, 1);
		public static final @NonNull ExecutorProperty _ClassDatum__super = new EcoreExecutorProperty(QVTschedulePackage.Literals.CLASS_DATUM__SUPER, Types._ClassDatum, 2);
		public static final @NonNull ExecutorProperty _ClassDatum__ClassDatum__super = new ExecutorPropertyWithImplementation("ClassDatum", Types._ClassDatum, 3, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.CLASS_DATUM__SUPER));

		public static final @NonNull ExecutorProperty _ConnectionRole__node = new EcoreExecutorProperty(QVTschedulePackage.Literals.CONNECTION_ROLE__NODE, Types._ConnectionRole, 0);

		public static final @NonNull ExecutorProperty _Edge__edgeRole = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE__EDGE_ROLE, Types._Edge, 0);
		public static final @NonNull ExecutorProperty _Edge__name = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE__NAME, Types._Edge, 1);
		public static final @NonNull ExecutorProperty _Edge__region = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE__REGION, Types._Edge, 2);
		public static final @NonNull ExecutorProperty _Edge__sourceNode = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE__SOURCE_NODE, Types._Edge, 3);
		public static final @NonNull ExecutorProperty _Edge__targetNode = new EcoreExecutorProperty(QVTschedulePackage.Literals.EDGE__TARGET_NODE, Types._Edge, 4);

		public static final @NonNull ExecutorProperty _MappingAction__mapping = new EcoreExecutorProperty(QVTschedulePackage.Literals.MAPPING_ACTION__MAPPING, Types._MappingAction, 0);
		public static final @NonNull ExecutorProperty _MappingAction__productions = new EcoreExecutorProperty(QVTschedulePackage.Literals.MAPPING_ACTION__PRODUCTIONS, Types._MappingAction, 1);
		public static final @NonNull ExecutorProperty _MappingAction__requisites = new EcoreExecutorProperty(QVTschedulePackage.Literals.MAPPING_ACTION__REQUISITES, Types._MappingAction, 2);

		public static final @NonNull ExecutorProperty _Node__incomingEdges = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__INCOMING_EDGES, Types._Node, 0);
		public static final @NonNull ExecutorProperty _Node__name = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__NAME, Types._Node, 1);
		public static final @NonNull ExecutorProperty _Node__nodeRole = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__NODE_ROLE, Types._Node, 2);
		public static final @NonNull ExecutorProperty _Node__outgoingEdges = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__OUTGOING_EDGES, Types._Node, 3);
		public static final @NonNull ExecutorProperty _Node__region = new EcoreExecutorProperty(QVTschedulePackage.Literals.NODE__REGION, Types._Node, 4);

		public static final @NonNull ExecutorProperty _PropertyDatum__classDatum = new EcoreExecutorProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__CLASS_DATUM, Types._PropertyDatum, 0);
		public static final @NonNull ExecutorProperty _PropertyDatum__opposite = new EcoreExecutorProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__OPPOSITE, Types._PropertyDatum, 1);
		public static final @NonNull ExecutorProperty _PropertyDatum__property = new EcoreExecutorProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__PROPERTY, Types._PropertyDatum, 2);
		public static final @NonNull ExecutorProperty _PropertyDatum__super = new EcoreExecutorProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__SUPER, Types._PropertyDatum, 3);
		public static final @NonNull ExecutorProperty _PropertyDatum__PropertyDatum__opposite = new ExecutorPropertyWithImplementation("PropertyDatum", Types._PropertyDatum, 4, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__OPPOSITE));
		public static final @NonNull ExecutorProperty _PropertyDatum__PropertyDatum__super = new ExecutorPropertyWithImplementation("PropertyDatum", Types._PropertyDatum, 5, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.PROPERTY_DATUM__SUPER));

		public static final @NonNull ExecutorProperty _Region__edges = new EcoreExecutorProperty(QVTschedulePackage.Literals.REGION__EDGES, Types._Region, 0);
		public static final @NonNull ExecutorProperty _Region__nodes = new EcoreExecutorProperty(QVTschedulePackage.Literals.REGION__NODES, Types._Region, 1);

		public static final @NonNull ExecutorProperty _Role__constant = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROLE__CONSTANT, Types._Role, 0);
		public static final @NonNull ExecutorProperty _Role__loaded = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROLE__LOADED, Types._Role, 1);
		public static final @NonNull ExecutorProperty _Role__new = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROLE__NEW, Types._Role, 2);
		public static final @NonNull ExecutorProperty _Role__old = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROLE__OLD, Types._Role, 3);
		public static final @NonNull ExecutorProperty _Role__phase = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROLE__PHASE, Types._Role, 4);
		public static final @NonNull ExecutorProperty _Role__predicated = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROLE__PREDICATED, Types._Role, 5);
		public static final @NonNull ExecutorProperty _Role__realized = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROLE__REALIZED, Types._Role, 6);
		public static final @NonNull ExecutorProperty _Role__speculated = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROLE__SPECULATED, Types._Role, 7);
		public static final @NonNull ExecutorProperty _Role__speculation = new EcoreExecutorProperty(QVTschedulePackage.Literals.ROLE__SPECULATION, Types._Role, 8);
		public static final @NonNull ExecutorProperty _Role__Edge__edgeRole = new ExecutorPropertyWithImplementation("Edge", Types._Role, 9, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.EDGE__EDGE_ROLE));
		public static final @NonNull ExecutorProperty _Role__Node__nodeRole = new ExecutorPropertyWithImplementation("Node", Types._Role, 10, new EcoreLibraryOppositeProperty(QVTschedulePackage.Literals.NODE__NODE_ROLE));

		public static final @NonNull ExecutorProperty _ScheduledRegion__name = new EcoreExecutorProperty(QVTschedulePackage.Literals.SCHEDULED_REGION__NAME, Types._ScheduledRegion, 0);

		public static final @NonNull ExecutorProperty _Symbolable__symbolName = new EcoreExecutorProperty(QVTschedulePackage.Literals.SYMBOLABLE__SYMBOL_NAME, Types._Symbolable, 0);
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

		private static final @NonNull ExecutorFragment @NonNull [] _AbstractDatum =
		{
			Fragments._AbstractDatum__OclAny /* 0 */,
			Fragments._AbstractDatum__OclElement /* 1 */,
			Fragments._AbstractDatum__Visitable /* 2 */,
			Fragments._AbstractDatum__Element /* 3 */,
			Fragments._AbstractDatum__AbstractDatum /* 4 */
		};
		private static final int @NonNull [] __AbstractDatum = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _BasicMappingRegion =
		{
			Fragments._BasicMappingRegion__OclAny /* 0 */,
			Fragments._BasicMappingRegion__OclElement /* 1 */,
			Fragments._BasicMappingRegion__GraphNode /* 2 */,
			Fragments._BasicMappingRegion__Nameable /* 2 */,
			Fragments._BasicMappingRegion__Symbolable /* 2 */,
			Fragments._BasicMappingRegion__ToDOTable /* 2 */,
			Fragments._BasicMappingRegion__Visitable /* 2 */,
			Fragments._BasicMappingRegion__Element /* 3 */,
			Fragments._BasicMappingRegion__Region /* 4 */,
			Fragments._BasicMappingRegion__MappingRegion /* 5 */,
			Fragments._BasicMappingRegion__BasicMappingRegion /* 6 */
		};
		private static final int @NonNull [] __BasicMappingRegion = { 1,1,5,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _CastEdge =
		{
			Fragments._CastEdge__OclAny /* 0 */,
			Fragments._CastEdge__OclElement /* 1 */,
			Fragments._CastEdge__ConnectionEnd /* 2 */,
			Fragments._CastEdge__GraphEdge /* 2 */,
			Fragments._CastEdge__Nameable /* 2 */,
			Fragments._CastEdge__Visitable /* 2 */,
			Fragments._CastEdge__Element /* 3 */,
			Fragments._CastEdge__Edge /* 4 */,
			Fragments._CastEdge__NavigableEdge /* 5 */,
			Fragments._CastEdge__CastEdge /* 6 */
		};
		private static final int @NonNull [] __CastEdge = { 1,1,4,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ClassDatum =
		{
			Fragments._ClassDatum__OclAny /* 0 */,
			Fragments._ClassDatum__OclElement /* 1 */,
			Fragments._ClassDatum__Visitable /* 2 */,
			Fragments._ClassDatum__Element /* 3 */,
			Fragments._ClassDatum__AbstractDatum /* 4 */,
			Fragments._ClassDatum__ClassDatum /* 5 */
		};
		private static final int @NonNull [] __ClassDatum = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ClassDatumAnalysis =
		{
			Fragments._ClassDatumAnalysis__OclAny /* 0 */,
			Fragments._ClassDatumAnalysis__OclElement /* 1 */,
			Fragments._ClassDatumAnalysis__Visitable /* 2 */,
			Fragments._ClassDatumAnalysis__Element /* 3 */,
			Fragments._ClassDatumAnalysis__ClassDatumAnalysis /* 4 */
		};
		private static final int @NonNull [] __ClassDatumAnalysis = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ComposedNode =
		{
			Fragments._ComposedNode__OclAny /* 0 */,
			Fragments._ComposedNode__OclElement /* 1 */,
			Fragments._ComposedNode__ConnectionEnd /* 2 */,
			Fragments._ComposedNode__GraphNode /* 2 */,
			Fragments._ComposedNode__Nameable /* 2 */,
			Fragments._ComposedNode__Visitable /* 2 */,
			Fragments._ComposedNode__Element /* 3 */,
			Fragments._ComposedNode__Node /* 4 */,
			Fragments._ComposedNode__ComposedNode /* 5 */
		};
		private static final int @NonNull [] __ComposedNode = { 1,1,4,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Connection =
		{
			Fragments._Connection__OclAny /* 0 */,
			Fragments._Connection__OclElement /* 1 */,
			Fragments._Connection__Nameable /* 2 */,
			Fragments._Connection__Symbolable /* 2 */,
			Fragments._Connection__Visitable /* 2 */,
			Fragments._Connection__Element /* 3 */,
			Fragments._Connection__Connection /* 4 */
		};
		private static final int @NonNull [] __Connection = { 1,1,3,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ConnectionEnd =
		{
			Fragments._ConnectionEnd__OclAny /* 0 */,
			Fragments._ConnectionEnd__OclElement /* 1 */,
			Fragments._ConnectionEnd__ConnectionEnd /* 2 */
		};
		private static final int @NonNull [] __ConnectionEnd = { 1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ConnectionRole =
		{
			Fragments._ConnectionRole__OclAny /* 0 */,
			Fragments._ConnectionRole__OclElement /* 1 */,
			Fragments._ConnectionRole__Visitable /* 2 */,
			Fragments._ConnectionRole__Element /* 3 */,
			Fragments._ConnectionRole__ConnectionRole /* 4 */
		};
		private static final int @NonNull [] __ConnectionRole = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _DatumConnection =
		{
			Fragments._DatumConnection__OclAny /* 0 */,
			Fragments._DatumConnection__OclElement /* 1 */,
			Fragments._DatumConnection__GraphEdge /* 2 */,
			Fragments._DatumConnection__GraphNode /* 2 */,
			Fragments._DatumConnection__Nameable /* 2 */,
			Fragments._DatumConnection__Symbolable /* 2 */,
			Fragments._DatumConnection__Visitable /* 2 */,
			Fragments._DatumConnection__Element /* 3 */,
			Fragments._DatumConnection__Connection /* 4 */,
			Fragments._DatumConnection__DatumConnection /* 5 */
		};
		private static final int @NonNull [] __DatumConnection = { 1,1,5,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _DependencyNode =
		{
			Fragments._DependencyNode__OclAny /* 0 */,
			Fragments._DependencyNode__OclElement /* 1 */,
			Fragments._DependencyNode__ConnectionEnd /* 2 */,
			Fragments._DependencyNode__GraphNode /* 2 */,
			Fragments._DependencyNode__Nameable /* 2 */,
			Fragments._DependencyNode__Visitable /* 2 */,
			Fragments._DependencyNode__Element /* 3 */,
			Fragments._DependencyNode__Node /* 4 */,
			Fragments._DependencyNode__DependencyNode /* 5 */
		};
		private static final int @NonNull [] __DependencyNode = { 1,1,4,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Edge =
		{
			Fragments._Edge__OclAny /* 0 */,
			Fragments._Edge__OclElement /* 1 */,
			Fragments._Edge__GraphEdge /* 2 */,
			Fragments._Edge__Nameable /* 2 */,
			Fragments._Edge__Visitable /* 2 */,
			Fragments._Edge__Element /* 3 */,
			Fragments._Edge__Edge /* 4 */
		};
		private static final int @NonNull [] __Edge = { 1,1,3,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _EdgeConnection =
		{
			Fragments._EdgeConnection__OclAny /* 0 */,
			Fragments._EdgeConnection__OclElement /* 1 */,
			Fragments._EdgeConnection__GraphEdge /* 2 */,
			Fragments._EdgeConnection__GraphNode /* 2 */,
			Fragments._EdgeConnection__Nameable /* 2 */,
			Fragments._EdgeConnection__Symbolable /* 2 */,
			Fragments._EdgeConnection__Visitable /* 2 */,
			Fragments._EdgeConnection__Element /* 3 */,
			Fragments._EdgeConnection__Connection /* 4 */,
			Fragments._EdgeConnection__DatumConnection /* 5 */,
			Fragments._EdgeConnection__EdgeConnection /* 6 */
		};
		private static final int @NonNull [] __EdgeConnection = { 1,1,5,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ErrorNode =
		{
			Fragments._ErrorNode__OclAny /* 0 */,
			Fragments._ErrorNode__OclElement /* 1 */,
			Fragments._ErrorNode__ConnectionEnd /* 2 */,
			Fragments._ErrorNode__GraphNode /* 2 */,
			Fragments._ErrorNode__Nameable /* 2 */,
			Fragments._ErrorNode__Visitable /* 2 */,
			Fragments._ErrorNode__Element /* 3 */,
			Fragments._ErrorNode__Node /* 4 */,
			Fragments._ErrorNode__ErrorNode /* 5 */
		};
		private static final int @NonNull [] __ErrorNode = { 1,1,4,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ExpressionEdge =
		{
			Fragments._ExpressionEdge__OclAny /* 0 */,
			Fragments._ExpressionEdge__OclElement /* 1 */,
			Fragments._ExpressionEdge__GraphEdge /* 2 */,
			Fragments._ExpressionEdge__Nameable /* 2 */,
			Fragments._ExpressionEdge__Visitable /* 2 */,
			Fragments._ExpressionEdge__Element /* 3 */,
			Fragments._ExpressionEdge__Edge /* 4 */,
			Fragments._ExpressionEdge__ExpressionEdge /* 5 */
		};
		private static final int @NonNull [] __ExpressionEdge = { 1,1,3,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _GraphEdge =
		{
			Fragments._GraphEdge__OclAny /* 0 */,
			Fragments._GraphEdge__OclElement /* 1 */,
			Fragments._GraphEdge__GraphEdge /* 2 */
		};
		private static final int @NonNull [] __GraphEdge = { 1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _GraphNode =
		{
			Fragments._GraphNode__OclAny /* 0 */,
			Fragments._GraphNode__OclElement /* 1 */,
			Fragments._GraphNode__GraphNode /* 2 */
		};
		private static final int @NonNull [] __GraphNode = { 1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _InputNode =
		{
			Fragments._InputNode__OclAny /* 0 */,
			Fragments._InputNode__OclElement /* 1 */,
			Fragments._InputNode__ConnectionEnd /* 2 */,
			Fragments._InputNode__GraphNode /* 2 */,
			Fragments._InputNode__Nameable /* 2 */,
			Fragments._InputNode__Visitable /* 2 */,
			Fragments._InputNode__Element /* 3 */,
			Fragments._InputNode__Node /* 4 */,
			Fragments._InputNode__InputNode /* 5 */
		};
		private static final int @NonNull [] __InputNode = { 1,1,4,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _IteratedEdge =
		{
			Fragments._IteratedEdge__OclAny /* 0 */,
			Fragments._IteratedEdge__OclElement /* 1 */,
			Fragments._IteratedEdge__GraphEdge /* 2 */,
			Fragments._IteratedEdge__Nameable /* 2 */,
			Fragments._IteratedEdge__Visitable /* 2 */,
			Fragments._IteratedEdge__Element /* 3 */,
			Fragments._IteratedEdge__Edge /* 4 */,
			Fragments._IteratedEdge__IteratedEdge /* 5 */
		};
		private static final int @NonNull [] __IteratedEdge = { 1,1,3,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _IteratorNode =
		{
			Fragments._IteratorNode__OclAny /* 0 */,
			Fragments._IteratorNode__OclElement /* 1 */,
			Fragments._IteratorNode__ConnectionEnd /* 2 */,
			Fragments._IteratorNode__GraphNode /* 2 */,
			Fragments._IteratorNode__Nameable /* 2 */,
			Fragments._IteratorNode__Visitable /* 2 */,
			Fragments._IteratorNode__Element /* 3 */,
			Fragments._IteratorNode__Node /* 4 */,
			Fragments._IteratorNode__VariableNode /* 5 */,
			Fragments._IteratorNode__IteratorNode /* 6 */
		};
		private static final int @NonNull [] __IteratorNode = { 1,1,4,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _MappingAction =
		{
			Fragments._MappingAction__OclAny /* 0 */,
			Fragments._MappingAction__OclElement /* 1 */,
			Fragments._MappingAction__Visitable /* 2 */,
			Fragments._MappingAction__Element /* 3 */,
			Fragments._MappingAction__MappingAction /* 4 */
		};
		private static final int @NonNull [] __MappingAction = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _MappingRegion =
		{
			Fragments._MappingRegion__OclAny /* 0 */,
			Fragments._MappingRegion__OclElement /* 1 */,
			Fragments._MappingRegion__GraphNode /* 2 */,
			Fragments._MappingRegion__Nameable /* 2 */,
			Fragments._MappingRegion__Symbolable /* 2 */,
			Fragments._MappingRegion__ToDOTable /* 2 */,
			Fragments._MappingRegion__Visitable /* 2 */,
			Fragments._MappingRegion__Element /* 3 */,
			Fragments._MappingRegion__Region /* 4 */,
			Fragments._MappingRegion__MappingRegion /* 5 */
		};
		private static final int @NonNull [] __MappingRegion = { 1,1,5,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _MicroMappingRegion =
		{
			Fragments._MicroMappingRegion__OclAny /* 0 */,
			Fragments._MicroMappingRegion__OclElement /* 1 */,
			Fragments._MicroMappingRegion__GraphNode /* 2 */,
			Fragments._MicroMappingRegion__Nameable /* 2 */,
			Fragments._MicroMappingRegion__Symbolable /* 2 */,
			Fragments._MicroMappingRegion__ToDOTable /* 2 */,
			Fragments._MicroMappingRegion__Visitable /* 2 */,
			Fragments._MicroMappingRegion__Element /* 3 */,
			Fragments._MicroMappingRegion__Region /* 4 */,
			Fragments._MicroMappingRegion__MappingRegion /* 5 */,
			Fragments._MicroMappingRegion__MicroMappingRegion /* 6 */
		};
		private static final int @NonNull [] __MicroMappingRegion = { 1,1,5,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _MultiRegion =
		{
			Fragments._MultiRegion__OclAny /* 0 */,
			Fragments._MultiRegion__OclElement /* 1 */,
			Fragments._MultiRegion__Visitable /* 2 */,
			Fragments._MultiRegion__Element /* 3 */,
			Fragments._MultiRegion__MultiRegion /* 4 */
		};
		private static final int @NonNull [] __MultiRegion = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _NamedMappingRegion =
		{
			Fragments._NamedMappingRegion__OclAny /* 0 */,
			Fragments._NamedMappingRegion__OclElement /* 1 */,
			Fragments._NamedMappingRegion__GraphNode /* 2 */,
			Fragments._NamedMappingRegion__Nameable /* 2 */,
			Fragments._NamedMappingRegion__Symbolable /* 2 */,
			Fragments._NamedMappingRegion__ToDOTable /* 2 */,
			Fragments._NamedMappingRegion__Visitable /* 2 */,
			Fragments._NamedMappingRegion__Element /* 3 */,
			Fragments._NamedMappingRegion__Region /* 4 */,
			Fragments._NamedMappingRegion__MappingRegion /* 5 */,
			Fragments._NamedMappingRegion__NamedMappingRegion /* 6 */
		};
		private static final int @NonNull [] __NamedMappingRegion = { 1,1,5,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _NavigableEdge =
		{
			Fragments._NavigableEdge__OclAny /* 0 */,
			Fragments._NavigableEdge__OclElement /* 1 */,
			Fragments._NavigableEdge__ConnectionEnd /* 2 */,
			Fragments._NavigableEdge__GraphEdge /* 2 */,
			Fragments._NavigableEdge__Nameable /* 2 */,
			Fragments._NavigableEdge__Visitable /* 2 */,
			Fragments._NavigableEdge__Element /* 3 */,
			Fragments._NavigableEdge__Edge /* 4 */,
			Fragments._NavigableEdge__NavigableEdge /* 5 */
		};
		private static final int @NonNull [] __NavigableEdge = { 1,1,4,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _NavigationEdge =
		{
			Fragments._NavigationEdge__OclAny /* 0 */,
			Fragments._NavigationEdge__OclElement /* 1 */,
			Fragments._NavigationEdge__ConnectionEnd /* 2 */,
			Fragments._NavigationEdge__GraphEdge /* 2 */,
			Fragments._NavigationEdge__Nameable /* 2 */,
			Fragments._NavigationEdge__Visitable /* 2 */,
			Fragments._NavigationEdge__Element /* 3 */,
			Fragments._NavigationEdge__Edge /* 4 */,
			Fragments._NavigationEdge__NavigableEdge /* 5 */,
			Fragments._NavigationEdge__NavigationEdge /* 6 */
		};
		private static final int @NonNull [] __NavigationEdge = { 1,1,4,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Node =
		{
			Fragments._Node__OclAny /* 0 */,
			Fragments._Node__OclElement /* 1 */,
			Fragments._Node__ConnectionEnd /* 2 */,
			Fragments._Node__GraphNode /* 2 */,
			Fragments._Node__Nameable /* 2 */,
			Fragments._Node__Visitable /* 2 */,
			Fragments._Node__Element /* 3 */,
			Fragments._Node__Node /* 4 */
		};
		private static final int @NonNull [] __Node = { 1,1,4,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _NodeConnection =
		{
			Fragments._NodeConnection__OclAny /* 0 */,
			Fragments._NodeConnection__OclElement /* 1 */,
			Fragments._NodeConnection__GraphEdge /* 2 */,
			Fragments._NodeConnection__GraphNode /* 2 */,
			Fragments._NodeConnection__Nameable /* 2 */,
			Fragments._NodeConnection__Symbolable /* 2 */,
			Fragments._NodeConnection__Visitable /* 2 */,
			Fragments._NodeConnection__Element /* 3 */,
			Fragments._NodeConnection__Connection /* 4 */,
			Fragments._NodeConnection__DatumConnection /* 5 */,
			Fragments._NodeConnection__NodeConnection /* 6 */
		};
		private static final int @NonNull [] __NodeConnection = { 1,1,5,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _NullNode =
		{
			Fragments._NullNode__OclAny /* 0 */,
			Fragments._NullNode__OclElement /* 1 */,
			Fragments._NullNode__ConnectionEnd /* 2 */,
			Fragments._NullNode__GraphNode /* 2 */,
			Fragments._NullNode__Nameable /* 2 */,
			Fragments._NullNode__Visitable /* 2 */,
			Fragments._NullNode__Element /* 3 */,
			Fragments._NullNode__Node /* 4 */,
			Fragments._NullNode__NullNode /* 5 */
		};
		private static final int @NonNull [] __NullNode = { 1,1,4,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OperationNode =
		{
			Fragments._OperationNode__OclAny /* 0 */,
			Fragments._OperationNode__OclElement /* 1 */,
			Fragments._OperationNode__ConnectionEnd /* 2 */,
			Fragments._OperationNode__GraphNode /* 2 */,
			Fragments._OperationNode__Nameable /* 2 */,
			Fragments._OperationNode__Visitable /* 2 */,
			Fragments._OperationNode__Element /* 3 */,
			Fragments._OperationNode__Node /* 4 */,
			Fragments._OperationNode__OperationNode /* 5 */
		};
		private static final int @NonNull [] __OperationNode = { 1,1,4,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _OperationRegion =
		{
			Fragments._OperationRegion__OclAny /* 0 */,
			Fragments._OperationRegion__OclElement /* 1 */,
			Fragments._OperationRegion__GraphNode /* 2 */,
			Fragments._OperationRegion__Nameable /* 2 */,
			Fragments._OperationRegion__Symbolable /* 2 */,
			Fragments._OperationRegion__ToDOTable /* 2 */,
			Fragments._OperationRegion__Visitable /* 2 */,
			Fragments._OperationRegion__Element /* 3 */,
			Fragments._OperationRegion__Region /* 4 */,
			Fragments._OperationRegion__OperationRegion /* 5 */
		};
		private static final int @NonNull [] __OperationRegion = { 1,1,5,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _PatternTypedNode =
		{
			Fragments._PatternTypedNode__OclAny /* 0 */,
			Fragments._PatternTypedNode__OclElement /* 1 */,
			Fragments._PatternTypedNode__ConnectionEnd /* 2 */,
			Fragments._PatternTypedNode__GraphNode /* 2 */,
			Fragments._PatternTypedNode__Nameable /* 2 */,
			Fragments._PatternTypedNode__Visitable /* 2 */,
			Fragments._PatternTypedNode__Element /* 3 */,
			Fragments._PatternTypedNode__Node /* 4 */,
			Fragments._PatternTypedNode__PatternTypedNode /* 5 */
		};
		private static final int @NonNull [] __PatternTypedNode = { 1,1,4,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _PatternVariableNode =
		{
			Fragments._PatternVariableNode__OclAny /* 0 */,
			Fragments._PatternVariableNode__OclElement /* 1 */,
			Fragments._PatternVariableNode__ConnectionEnd /* 2 */,
			Fragments._PatternVariableNode__GraphNode /* 2 */,
			Fragments._PatternVariableNode__Nameable /* 2 */,
			Fragments._PatternVariableNode__Visitable /* 2 */,
			Fragments._PatternVariableNode__Element /* 3 */,
			Fragments._PatternVariableNode__Node /* 4 */,
			Fragments._PatternVariableNode__VariableNode /* 5 */,
			Fragments._PatternVariableNode__PatternVariableNode /* 6 */
		};
		private static final int @NonNull [] __PatternVariableNode = { 1,1,4,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Phase =
		{
			Fragments._Phase__OclAny /* 0 */,
			Fragments._Phase__OclElement /* 1 */,
			Fragments._Phase__OclType /* 2 */,
			Fragments._Phase__OclEnumeration /* 3 */,
			Fragments._Phase__Phase /* 4 */
		};
		private static final int @NonNull [] __Phase = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _PredicateEdge =
		{
			Fragments._PredicateEdge__OclAny /* 0 */,
			Fragments._PredicateEdge__OclElement /* 1 */,
			Fragments._PredicateEdge__GraphEdge /* 2 */,
			Fragments._PredicateEdge__Nameable /* 2 */,
			Fragments._PredicateEdge__Visitable /* 2 */,
			Fragments._PredicateEdge__Element /* 3 */,
			Fragments._PredicateEdge__Edge /* 4 */,
			Fragments._PredicateEdge__PredicateEdge /* 5 */
		};
		private static final int @NonNull [] __PredicateEdge = { 1,1,3,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _PropertyDatum =
		{
			Fragments._PropertyDatum__OclAny /* 0 */,
			Fragments._PropertyDatum__OclElement /* 1 */,
			Fragments._PropertyDatum__Visitable /* 2 */,
			Fragments._PropertyDatum__Element /* 3 */,
			Fragments._PropertyDatum__AbstractDatum /* 4 */,
			Fragments._PropertyDatum__PropertyDatum /* 5 */
		};
		private static final int @NonNull [] __PropertyDatum = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _RecursionEdge =
		{
			Fragments._RecursionEdge__OclAny /* 0 */,
			Fragments._RecursionEdge__OclElement /* 1 */,
			Fragments._RecursionEdge__GraphEdge /* 2 */,
			Fragments._RecursionEdge__Nameable /* 2 */,
			Fragments._RecursionEdge__Visitable /* 2 */,
			Fragments._RecursionEdge__Element /* 3 */,
			Fragments._RecursionEdge__Edge /* 4 */,
			Fragments._RecursionEdge__RecursionEdge /* 5 */
		};
		private static final int @NonNull [] __RecursionEdge = { 1,1,3,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Region =
		{
			Fragments._Region__OclAny /* 0 */,
			Fragments._Region__OclElement /* 1 */,
			Fragments._Region__GraphNode /* 2 */,
			Fragments._Region__Nameable /* 2 */,
			Fragments._Region__Symbolable /* 2 */,
			Fragments._Region__ToDOTable /* 2 */,
			Fragments._Region__Visitable /* 2 */,
			Fragments._Region__Element /* 3 */,
			Fragments._Region__Region /* 4 */
		};
		private static final int @NonNull [] __Region = { 1,1,5,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Role =
		{
			Fragments._Role__OclAny /* 0 */,
			Fragments._Role__OclElement /* 1 */,
			Fragments._Role__Visitable /* 2 */,
			Fragments._Role__Element /* 3 */,
			Fragments._Role__Role /* 4 */
		};
		private static final int @NonNull [] __Role = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _RootCompositionRegion =
		{
			Fragments._RootCompositionRegion__OclAny /* 0 */,
			Fragments._RootCompositionRegion__OclElement /* 1 */,
			Fragments._RootCompositionRegion__GraphNode /* 2 */,
			Fragments._RootCompositionRegion__Nameable /* 2 */,
			Fragments._RootCompositionRegion__Symbolable /* 2 */,
			Fragments._RootCompositionRegion__ToDOTable /* 2 */,
			Fragments._RootCompositionRegion__Visitable /* 2 */,
			Fragments._RootCompositionRegion__Element /* 3 */,
			Fragments._RootCompositionRegion__Region /* 4 */,
			Fragments._RootCompositionRegion__RootCompositionRegion /* 5 */
		};
		private static final int @NonNull [] __RootCompositionRegion = { 1,1,5,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ScheduledRegion =
		{
			Fragments._ScheduledRegion__OclAny /* 0 */,
			Fragments._ScheduledRegion__OclElement /* 1 */,
			Fragments._ScheduledRegion__GraphNode /* 2 */,
			Fragments._ScheduledRegion__Nameable /* 2 */,
			Fragments._ScheduledRegion__Symbolable /* 2 */,
			Fragments._ScheduledRegion__ToDOTable /* 2 */,
			Fragments._ScheduledRegion__Visitable /* 2 */,
			Fragments._ScheduledRegion__Element /* 3 */,
			Fragments._ScheduledRegion__Region /* 4 */,
			Fragments._ScheduledRegion__ScheduledRegion /* 5 */
		};
		private static final int @NonNull [] __ScheduledRegion = { 1,1,5,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _SchedulerConstants =
		{
			Fragments._SchedulerConstants__OclAny /* 0 */,
			Fragments._SchedulerConstants__OclElement /* 1 */,
			Fragments._SchedulerConstants__Visitable /* 2 */,
			Fragments._SchedulerConstants__Element /* 3 */,
			Fragments._SchedulerConstants__SchedulerConstants /* 4 */
		};
		private static final int @NonNull [] __SchedulerConstants = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _Symbolable =
		{
			Fragments._Symbolable__OclAny /* 0 */,
			Fragments._Symbolable__OclElement /* 1 */,
			Fragments._Symbolable__Symbolable /* 2 */
		};
		private static final int @NonNull [] __Symbolable = { 1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _ToDOTable =
		{
			Fragments._ToDOTable__OclAny /* 0 */,
			Fragments._ToDOTable__OclElement /* 1 */,
			Fragments._ToDOTable__ToDOTable /* 2 */
		};
		private static final int @NonNull [] __ToDOTable = { 1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _TrueNode =
		{
			Fragments._TrueNode__OclAny /* 0 */,
			Fragments._TrueNode__OclElement /* 1 */,
			Fragments._TrueNode__ConnectionEnd /* 2 */,
			Fragments._TrueNode__GraphNode /* 2 */,
			Fragments._TrueNode__Nameable /* 2 */,
			Fragments._TrueNode__Visitable /* 2 */,
			Fragments._TrueNode__Element /* 3 */,
			Fragments._TrueNode__Node /* 4 */,
			Fragments._TrueNode__TrueNode /* 5 */
		};
		private static final int @NonNull [] __TrueNode = { 1,1,4,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _UnknownNode =
		{
			Fragments._UnknownNode__OclAny /* 0 */,
			Fragments._UnknownNode__OclElement /* 1 */,
			Fragments._UnknownNode__ConnectionEnd /* 2 */,
			Fragments._UnknownNode__GraphNode /* 2 */,
			Fragments._UnknownNode__Nameable /* 2 */,
			Fragments._UnknownNode__Visitable /* 2 */,
			Fragments._UnknownNode__Element /* 3 */,
			Fragments._UnknownNode__Node /* 4 */,
			Fragments._UnknownNode__UnknownNode /* 5 */
		};
		private static final int @NonNull [] __UnknownNode = { 1,1,4,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _VariableNode =
		{
			Fragments._VariableNode__OclAny /* 0 */,
			Fragments._VariableNode__OclElement /* 1 */,
			Fragments._VariableNode__ConnectionEnd /* 2 */,
			Fragments._VariableNode__GraphNode /* 2 */,
			Fragments._VariableNode__Nameable /* 2 */,
			Fragments._VariableNode__Visitable /* 2 */,
			Fragments._VariableNode__Element /* 3 */,
			Fragments._VariableNode__Node /* 4 */,
			Fragments._VariableNode__VariableNode /* 5 */
		};
		private static final int @NonNull [] __VariableNode = { 1,1,4,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._AbstractDatum.initFragments(_AbstractDatum, __AbstractDatum);
			Types._BasicMappingRegion.initFragments(_BasicMappingRegion, __BasicMappingRegion);
			Types._CastEdge.initFragments(_CastEdge, __CastEdge);
			Types._ClassDatum.initFragments(_ClassDatum, __ClassDatum);
			Types._ClassDatumAnalysis.initFragments(_ClassDatumAnalysis, __ClassDatumAnalysis);
			Types._ComposedNode.initFragments(_ComposedNode, __ComposedNode);
			Types._Connection.initFragments(_Connection, __Connection);
			Types._ConnectionEnd.initFragments(_ConnectionEnd, __ConnectionEnd);
			Types._ConnectionRole.initFragments(_ConnectionRole, __ConnectionRole);
			Types._DatumConnection.initFragments(_DatumConnection, __DatumConnection);
			Types._DependencyNode.initFragments(_DependencyNode, __DependencyNode);
			Types._Edge.initFragments(_Edge, __Edge);
			Types._EdgeConnection.initFragments(_EdgeConnection, __EdgeConnection);
			Types._ErrorNode.initFragments(_ErrorNode, __ErrorNode);
			Types._ExpressionEdge.initFragments(_ExpressionEdge, __ExpressionEdge);
			Types._GraphEdge.initFragments(_GraphEdge, __GraphEdge);
			Types._GraphNode.initFragments(_GraphNode, __GraphNode);
			Types._InputNode.initFragments(_InputNode, __InputNode);
			Types._IteratedEdge.initFragments(_IteratedEdge, __IteratedEdge);
			Types._IteratorNode.initFragments(_IteratorNode, __IteratorNode);
			Types._MappingAction.initFragments(_MappingAction, __MappingAction);
			Types._MappingRegion.initFragments(_MappingRegion, __MappingRegion);
			Types._MicroMappingRegion.initFragments(_MicroMappingRegion, __MicroMappingRegion);
			Types._MultiRegion.initFragments(_MultiRegion, __MultiRegion);
			Types._NamedMappingRegion.initFragments(_NamedMappingRegion, __NamedMappingRegion);
			Types._NavigableEdge.initFragments(_NavigableEdge, __NavigableEdge);
			Types._NavigationEdge.initFragments(_NavigationEdge, __NavigationEdge);
			Types._Node.initFragments(_Node, __Node);
			Types._NodeConnection.initFragments(_NodeConnection, __NodeConnection);
			Types._NullNode.initFragments(_NullNode, __NullNode);
			Types._OperationNode.initFragments(_OperationNode, __OperationNode);
			Types._OperationRegion.initFragments(_OperationRegion, __OperationRegion);
			Types._PatternTypedNode.initFragments(_PatternTypedNode, __PatternTypedNode);
			Types._PatternVariableNode.initFragments(_PatternVariableNode, __PatternVariableNode);
			Types._Phase.initFragments(_Phase, __Phase);
			Types._PredicateEdge.initFragments(_PredicateEdge, __PredicateEdge);
			Types._PropertyDatum.initFragments(_PropertyDatum, __PropertyDatum);
			Types._RecursionEdge.initFragments(_RecursionEdge, __RecursionEdge);
			Types._Region.initFragments(_Region, __Region);
			Types._Role.initFragments(_Role, __Role);
			Types._RootCompositionRegion.initFragments(_RootCompositionRegion, __RootCompositionRegion);
			Types._ScheduledRegion.initFragments(_ScheduledRegion, __ScheduledRegion);
			Types._SchedulerConstants.initFragments(_SchedulerConstants, __SchedulerConstants);
			Types._Symbolable.initFragments(_Symbolable, __Symbolable);
			Types._ToDOTable.initFragments(_ToDOTable, __ToDOTable);
			Types._TrueNode.initFragments(_TrueNode, __TrueNode);
			Types._UnknownNode.initFragments(_UnknownNode, __UnknownNode);
			Types._VariableNode.initFragments(_VariableNode, __VariableNode);

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

		private static final @NonNull ExecutorOperation @NonNull [] _AbstractDatum__AbstractDatum = {};
		private static final @NonNull ExecutorOperation @NonNull [] _AbstractDatum__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _AbstractDatum__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _AbstractDatum__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _AbstractDatum__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _BasicMappingRegion__BasicMappingRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BasicMappingRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _BasicMappingRegion__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BasicMappingRegion__MappingRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BasicMappingRegion__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BasicMappingRegion__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _BasicMappingRegion__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _BasicMappingRegion__Region = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BasicMappingRegion__Symbolable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BasicMappingRegion__ToDOTable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _BasicMappingRegion__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _CastEdge__CastEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CastEdge__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CastEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CastEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CastEdge__GraphEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CastEdge__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CastEdge__NavigableEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _CastEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _CastEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _CastEdge__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _ClassDatum__ClassDatum = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ClassDatum__AbstractDatum = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ClassDatum__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ClassDatum__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ClassDatum__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ClassDatum__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _ClassDatumAnalysis__ClassDatumAnalysis = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ClassDatumAnalysis__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ClassDatumAnalysis__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ClassDatumAnalysis__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ClassDatumAnalysis__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _ComposedNode__ComposedNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ComposedNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ComposedNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ComposedNode__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ComposedNode__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ComposedNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ComposedNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ComposedNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ComposedNode__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Connection__Connection = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Connection__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Connection__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Connection__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Connection__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Connection__Symbolable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Connection__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionEnd__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionEnd__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionEnd__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionRole__ConnectionRole = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionRole__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionRole__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionRole__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ConnectionRole__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _DatumConnection__DatumConnection = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DatumConnection__Connection = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DatumConnection__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _DatumConnection__GraphEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DatumConnection__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DatumConnection__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DatumConnection__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _DatumConnection__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _DatumConnection__Symbolable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DatumConnection__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _DependencyNode__DependencyNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DependencyNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DependencyNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _DependencyNode__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DependencyNode__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DependencyNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _DependencyNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _DependencyNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _DependencyNode__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Edge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Edge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Edge__GraphEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Edge__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Edge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Edge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Edge__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _EdgeConnection__EdgeConnection = {};
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeConnection__Connection = {};
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeConnection__DatumConnection = {};
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeConnection__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeConnection__GraphEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeConnection__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeConnection__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeConnection__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeConnection__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeConnection__Symbolable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _EdgeConnection__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _ErrorNode__ErrorNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ErrorNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ErrorNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ErrorNode__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ErrorNode__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ErrorNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ErrorNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ErrorNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ErrorNode__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionEdge__ExpressionEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionEdge__GraphEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionEdge__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ExpressionEdge__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _GraphEdge__GraphEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _GraphEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _GraphEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _GraphNode__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _GraphNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _GraphNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _InputNode__InputNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _InputNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _InputNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _InputNode__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _InputNode__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _InputNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _InputNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _InputNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _InputNode__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _IteratedEdge__IteratedEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratedEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratedEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratedEdge__GraphEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratedEdge__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratedEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _IteratedEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratedEdge__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _IteratorNode__IteratorNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorNode__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorNode__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorNode__VariableNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _IteratorNode__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _MappingAction__MappingAction = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingAction__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingAction__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _MappingAction__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingAction__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _MappingRegion__MappingRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingRegion__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingRegion__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingRegion__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _MappingRegion__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingRegion__Region = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingRegion__Symbolable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingRegion__ToDOTable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MappingRegion__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _MicroMappingRegion__MicroMappingRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MicroMappingRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MicroMappingRegion__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MicroMappingRegion__MappingRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MicroMappingRegion__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MicroMappingRegion__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _MicroMappingRegion__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MicroMappingRegion__Region = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MicroMappingRegion__Symbolable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MicroMappingRegion__ToDOTable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MicroMappingRegion__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _MultiRegion__MultiRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _MultiRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MultiRegion__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _MultiRegion__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _MultiRegion__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _NamedMappingRegion__NamedMappingRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedMappingRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedMappingRegion__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedMappingRegion__MappingRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedMappingRegion__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedMappingRegion__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _NamedMappingRegion__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedMappingRegion__Region = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedMappingRegion__Symbolable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedMappingRegion__ToDOTable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NamedMappingRegion__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _NavigableEdge__NavigableEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigableEdge__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigableEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigableEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigableEdge__GraphEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigableEdge__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigableEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _NavigableEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigableEdge__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _NavigationEdge__NavigationEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigationEdge__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigationEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigationEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigationEdge__GraphEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigationEdge__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigationEdge__NavigableEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigationEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _NavigationEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NavigationEdge__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Node__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Node__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Node__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Node__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Node__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Node__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Node__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Node__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _NodeConnection__NodeConnection = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NodeConnection__Connection = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NodeConnection__DatumConnection = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NodeConnection__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NodeConnection__GraphEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NodeConnection__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NodeConnection__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NodeConnection__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _NodeConnection__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NodeConnection__Symbolable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NodeConnection__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _NullNode__NullNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NullNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NullNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NullNode__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NullNode__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NullNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _NullNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _NullNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _NullNode__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _OperationNode__OperationNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationNode__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationNode__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _OperationNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationNode__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _OperationRegion__OperationRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationRegion__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationRegion__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationRegion__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _OperationRegion__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationRegion__Region = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationRegion__Symbolable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationRegion__ToDOTable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _OperationRegion__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _PatternTypedNode__PatternTypedNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternTypedNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternTypedNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternTypedNode__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternTypedNode__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternTypedNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternTypedNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _PatternTypedNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternTypedNode__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _PatternVariableNode__PatternVariableNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternVariableNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternVariableNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternVariableNode__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternVariableNode__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternVariableNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternVariableNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _PatternVariableNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternVariableNode__VariableNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PatternVariableNode__Visitable = {};

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

		private static final @NonNull ExecutorOperation @NonNull [] _PredicateEdge__PredicateEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PredicateEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PredicateEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PredicateEdge__GraphEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PredicateEdge__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PredicateEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _PredicateEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PredicateEdge__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _PropertyDatum__PropertyDatum = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyDatum__AbstractDatum = {};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyDatum__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyDatum__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyDatum__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _PropertyDatum__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _RecursionEdge__RecursionEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RecursionEdge__Edge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RecursionEdge__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RecursionEdge__GraphEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RecursionEdge__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RecursionEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _RecursionEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RecursionEdge__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Region__Region = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Region__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Region__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Region__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Region__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Region__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _Region__Symbolable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Region__ToDOTable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Region__Visitable = {};

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

		private static final @NonNull ExecutorOperation @NonNull [] _RootCompositionRegion__RootCompositionRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RootCompositionRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RootCompositionRegion__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RootCompositionRegion__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RootCompositionRegion__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _RootCompositionRegion__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RootCompositionRegion__Region = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RootCompositionRegion__Symbolable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RootCompositionRegion__ToDOTable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RootCompositionRegion__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _ScheduledRegion__ScheduledRegion = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduledRegion__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduledRegion__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduledRegion__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduledRegion__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduledRegion__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduledRegion__Region = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduledRegion__Symbolable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduledRegion__ToDOTable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ScheduledRegion__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _SchedulerConstants__SchedulerConstants = {};
		private static final @NonNull ExecutorOperation @NonNull [] _SchedulerConstants__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SchedulerConstants__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _SchedulerConstants__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _SchedulerConstants__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _Symbolable__Symbolable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _Symbolable__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _Symbolable__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _ToDOTable__ToDOTable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _ToDOTable__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _ToDOTable__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _TrueNode__TrueNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TrueNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TrueNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TrueNode__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TrueNode__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TrueNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TrueNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _TrueNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TrueNode__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _UnknownNode__UnknownNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _UnknownNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _UnknownNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _UnknownNode__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _UnknownNode__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _UnknownNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _UnknownNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _UnknownNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _UnknownNode__Visitable = {};

		private static final @NonNull ExecutorOperation @NonNull [] _VariableNode__VariableNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableNode__ConnectionEnd = {};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableNode__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableNode__GraphNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableNode__Nameable = {};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableNode__Node = {};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _VariableNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _VariableNode__Visitable = {};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._AbstractDatum__AbstractDatum.initOperations(_AbstractDatum__AbstractDatum);
			Fragments._AbstractDatum__Element.initOperations(_AbstractDatum__Element);
			Fragments._AbstractDatum__OclAny.initOperations(_AbstractDatum__OclAny);
			Fragments._AbstractDatum__OclElement.initOperations(_AbstractDatum__OclElement);
			Fragments._AbstractDatum__Visitable.initOperations(_AbstractDatum__Visitable);

			Fragments._BasicMappingRegion__BasicMappingRegion.initOperations(_BasicMappingRegion__BasicMappingRegion);
			Fragments._BasicMappingRegion__Element.initOperations(_BasicMappingRegion__Element);
			Fragments._BasicMappingRegion__GraphNode.initOperations(_BasicMappingRegion__GraphNode);
			Fragments._BasicMappingRegion__MappingRegion.initOperations(_BasicMappingRegion__MappingRegion);
			Fragments._BasicMappingRegion__Nameable.initOperations(_BasicMappingRegion__Nameable);
			Fragments._BasicMappingRegion__OclAny.initOperations(_BasicMappingRegion__OclAny);
			Fragments._BasicMappingRegion__OclElement.initOperations(_BasicMappingRegion__OclElement);
			Fragments._BasicMappingRegion__Region.initOperations(_BasicMappingRegion__Region);
			Fragments._BasicMappingRegion__Symbolable.initOperations(_BasicMappingRegion__Symbolable);
			Fragments._BasicMappingRegion__ToDOTable.initOperations(_BasicMappingRegion__ToDOTable);
			Fragments._BasicMappingRegion__Visitable.initOperations(_BasicMappingRegion__Visitable);

			Fragments._CastEdge__CastEdge.initOperations(_CastEdge__CastEdge);
			Fragments._CastEdge__ConnectionEnd.initOperations(_CastEdge__ConnectionEnd);
			Fragments._CastEdge__Edge.initOperations(_CastEdge__Edge);
			Fragments._CastEdge__Element.initOperations(_CastEdge__Element);
			Fragments._CastEdge__GraphEdge.initOperations(_CastEdge__GraphEdge);
			Fragments._CastEdge__Nameable.initOperations(_CastEdge__Nameable);
			Fragments._CastEdge__NavigableEdge.initOperations(_CastEdge__NavigableEdge);
			Fragments._CastEdge__OclAny.initOperations(_CastEdge__OclAny);
			Fragments._CastEdge__OclElement.initOperations(_CastEdge__OclElement);
			Fragments._CastEdge__Visitable.initOperations(_CastEdge__Visitable);

			Fragments._ClassDatum__AbstractDatum.initOperations(_ClassDatum__AbstractDatum);
			Fragments._ClassDatum__ClassDatum.initOperations(_ClassDatum__ClassDatum);
			Fragments._ClassDatum__Element.initOperations(_ClassDatum__Element);
			Fragments._ClassDatum__OclAny.initOperations(_ClassDatum__OclAny);
			Fragments._ClassDatum__OclElement.initOperations(_ClassDatum__OclElement);
			Fragments._ClassDatum__Visitable.initOperations(_ClassDatum__Visitable);

			Fragments._ClassDatumAnalysis__ClassDatumAnalysis.initOperations(_ClassDatumAnalysis__ClassDatumAnalysis);
			Fragments._ClassDatumAnalysis__Element.initOperations(_ClassDatumAnalysis__Element);
			Fragments._ClassDatumAnalysis__OclAny.initOperations(_ClassDatumAnalysis__OclAny);
			Fragments._ClassDatumAnalysis__OclElement.initOperations(_ClassDatumAnalysis__OclElement);
			Fragments._ClassDatumAnalysis__Visitable.initOperations(_ClassDatumAnalysis__Visitable);

			Fragments._ComposedNode__ComposedNode.initOperations(_ComposedNode__ComposedNode);
			Fragments._ComposedNode__ConnectionEnd.initOperations(_ComposedNode__ConnectionEnd);
			Fragments._ComposedNode__Element.initOperations(_ComposedNode__Element);
			Fragments._ComposedNode__GraphNode.initOperations(_ComposedNode__GraphNode);
			Fragments._ComposedNode__Nameable.initOperations(_ComposedNode__Nameable);
			Fragments._ComposedNode__Node.initOperations(_ComposedNode__Node);
			Fragments._ComposedNode__OclAny.initOperations(_ComposedNode__OclAny);
			Fragments._ComposedNode__OclElement.initOperations(_ComposedNode__OclElement);
			Fragments._ComposedNode__Visitable.initOperations(_ComposedNode__Visitable);

			Fragments._Connection__Connection.initOperations(_Connection__Connection);
			Fragments._Connection__Element.initOperations(_Connection__Element);
			Fragments._Connection__Nameable.initOperations(_Connection__Nameable);
			Fragments._Connection__OclAny.initOperations(_Connection__OclAny);
			Fragments._Connection__OclElement.initOperations(_Connection__OclElement);
			Fragments._Connection__Symbolable.initOperations(_Connection__Symbolable);
			Fragments._Connection__Visitable.initOperations(_Connection__Visitable);

			Fragments._ConnectionEnd__ConnectionEnd.initOperations(_ConnectionEnd__ConnectionEnd);
			Fragments._ConnectionEnd__OclAny.initOperations(_ConnectionEnd__OclAny);
			Fragments._ConnectionEnd__OclElement.initOperations(_ConnectionEnd__OclElement);

			Fragments._ConnectionRole__ConnectionRole.initOperations(_ConnectionRole__ConnectionRole);
			Fragments._ConnectionRole__Element.initOperations(_ConnectionRole__Element);
			Fragments._ConnectionRole__OclAny.initOperations(_ConnectionRole__OclAny);
			Fragments._ConnectionRole__OclElement.initOperations(_ConnectionRole__OclElement);
			Fragments._ConnectionRole__Visitable.initOperations(_ConnectionRole__Visitable);

			Fragments._DatumConnection__Connection.initOperations(_DatumConnection__Connection);
			Fragments._DatumConnection__DatumConnection.initOperations(_DatumConnection__DatumConnection);
			Fragments._DatumConnection__Element.initOperations(_DatumConnection__Element);
			Fragments._DatumConnection__GraphEdge.initOperations(_DatumConnection__GraphEdge);
			Fragments._DatumConnection__GraphNode.initOperations(_DatumConnection__GraphNode);
			Fragments._DatumConnection__Nameable.initOperations(_DatumConnection__Nameable);
			Fragments._DatumConnection__OclAny.initOperations(_DatumConnection__OclAny);
			Fragments._DatumConnection__OclElement.initOperations(_DatumConnection__OclElement);
			Fragments._DatumConnection__Symbolable.initOperations(_DatumConnection__Symbolable);
			Fragments._DatumConnection__Visitable.initOperations(_DatumConnection__Visitable);

			Fragments._DependencyNode__ConnectionEnd.initOperations(_DependencyNode__ConnectionEnd);
			Fragments._DependencyNode__DependencyNode.initOperations(_DependencyNode__DependencyNode);
			Fragments._DependencyNode__Element.initOperations(_DependencyNode__Element);
			Fragments._DependencyNode__GraphNode.initOperations(_DependencyNode__GraphNode);
			Fragments._DependencyNode__Nameable.initOperations(_DependencyNode__Nameable);
			Fragments._DependencyNode__Node.initOperations(_DependencyNode__Node);
			Fragments._DependencyNode__OclAny.initOperations(_DependencyNode__OclAny);
			Fragments._DependencyNode__OclElement.initOperations(_DependencyNode__OclElement);
			Fragments._DependencyNode__Visitable.initOperations(_DependencyNode__Visitable);

			Fragments._Edge__Edge.initOperations(_Edge__Edge);
			Fragments._Edge__Element.initOperations(_Edge__Element);
			Fragments._Edge__GraphEdge.initOperations(_Edge__GraphEdge);
			Fragments._Edge__Nameable.initOperations(_Edge__Nameable);
			Fragments._Edge__OclAny.initOperations(_Edge__OclAny);
			Fragments._Edge__OclElement.initOperations(_Edge__OclElement);
			Fragments._Edge__Visitable.initOperations(_Edge__Visitable);

			Fragments._EdgeConnection__Connection.initOperations(_EdgeConnection__Connection);
			Fragments._EdgeConnection__DatumConnection.initOperations(_EdgeConnection__DatumConnection);
			Fragments._EdgeConnection__EdgeConnection.initOperations(_EdgeConnection__EdgeConnection);
			Fragments._EdgeConnection__Element.initOperations(_EdgeConnection__Element);
			Fragments._EdgeConnection__GraphEdge.initOperations(_EdgeConnection__GraphEdge);
			Fragments._EdgeConnection__GraphNode.initOperations(_EdgeConnection__GraphNode);
			Fragments._EdgeConnection__Nameable.initOperations(_EdgeConnection__Nameable);
			Fragments._EdgeConnection__OclAny.initOperations(_EdgeConnection__OclAny);
			Fragments._EdgeConnection__OclElement.initOperations(_EdgeConnection__OclElement);
			Fragments._EdgeConnection__Symbolable.initOperations(_EdgeConnection__Symbolable);
			Fragments._EdgeConnection__Visitable.initOperations(_EdgeConnection__Visitable);

			Fragments._ErrorNode__ConnectionEnd.initOperations(_ErrorNode__ConnectionEnd);
			Fragments._ErrorNode__Element.initOperations(_ErrorNode__Element);
			Fragments._ErrorNode__ErrorNode.initOperations(_ErrorNode__ErrorNode);
			Fragments._ErrorNode__GraphNode.initOperations(_ErrorNode__GraphNode);
			Fragments._ErrorNode__Nameable.initOperations(_ErrorNode__Nameable);
			Fragments._ErrorNode__Node.initOperations(_ErrorNode__Node);
			Fragments._ErrorNode__OclAny.initOperations(_ErrorNode__OclAny);
			Fragments._ErrorNode__OclElement.initOperations(_ErrorNode__OclElement);
			Fragments._ErrorNode__Visitable.initOperations(_ErrorNode__Visitable);

			Fragments._ExpressionEdge__Edge.initOperations(_ExpressionEdge__Edge);
			Fragments._ExpressionEdge__Element.initOperations(_ExpressionEdge__Element);
			Fragments._ExpressionEdge__ExpressionEdge.initOperations(_ExpressionEdge__ExpressionEdge);
			Fragments._ExpressionEdge__GraphEdge.initOperations(_ExpressionEdge__GraphEdge);
			Fragments._ExpressionEdge__Nameable.initOperations(_ExpressionEdge__Nameable);
			Fragments._ExpressionEdge__OclAny.initOperations(_ExpressionEdge__OclAny);
			Fragments._ExpressionEdge__OclElement.initOperations(_ExpressionEdge__OclElement);
			Fragments._ExpressionEdge__Visitable.initOperations(_ExpressionEdge__Visitable);

			Fragments._GraphEdge__GraphEdge.initOperations(_GraphEdge__GraphEdge);
			Fragments._GraphEdge__OclAny.initOperations(_GraphEdge__OclAny);
			Fragments._GraphEdge__OclElement.initOperations(_GraphEdge__OclElement);

			Fragments._GraphNode__GraphNode.initOperations(_GraphNode__GraphNode);
			Fragments._GraphNode__OclAny.initOperations(_GraphNode__OclAny);
			Fragments._GraphNode__OclElement.initOperations(_GraphNode__OclElement);

			Fragments._InputNode__ConnectionEnd.initOperations(_InputNode__ConnectionEnd);
			Fragments._InputNode__Element.initOperations(_InputNode__Element);
			Fragments._InputNode__GraphNode.initOperations(_InputNode__GraphNode);
			Fragments._InputNode__InputNode.initOperations(_InputNode__InputNode);
			Fragments._InputNode__Nameable.initOperations(_InputNode__Nameable);
			Fragments._InputNode__Node.initOperations(_InputNode__Node);
			Fragments._InputNode__OclAny.initOperations(_InputNode__OclAny);
			Fragments._InputNode__OclElement.initOperations(_InputNode__OclElement);
			Fragments._InputNode__Visitable.initOperations(_InputNode__Visitable);

			Fragments._IteratedEdge__Edge.initOperations(_IteratedEdge__Edge);
			Fragments._IteratedEdge__Element.initOperations(_IteratedEdge__Element);
			Fragments._IteratedEdge__GraphEdge.initOperations(_IteratedEdge__GraphEdge);
			Fragments._IteratedEdge__IteratedEdge.initOperations(_IteratedEdge__IteratedEdge);
			Fragments._IteratedEdge__Nameable.initOperations(_IteratedEdge__Nameable);
			Fragments._IteratedEdge__OclAny.initOperations(_IteratedEdge__OclAny);
			Fragments._IteratedEdge__OclElement.initOperations(_IteratedEdge__OclElement);
			Fragments._IteratedEdge__Visitable.initOperations(_IteratedEdge__Visitable);

			Fragments._IteratorNode__ConnectionEnd.initOperations(_IteratorNode__ConnectionEnd);
			Fragments._IteratorNode__Element.initOperations(_IteratorNode__Element);
			Fragments._IteratorNode__GraphNode.initOperations(_IteratorNode__GraphNode);
			Fragments._IteratorNode__IteratorNode.initOperations(_IteratorNode__IteratorNode);
			Fragments._IteratorNode__Nameable.initOperations(_IteratorNode__Nameable);
			Fragments._IteratorNode__Node.initOperations(_IteratorNode__Node);
			Fragments._IteratorNode__OclAny.initOperations(_IteratorNode__OclAny);
			Fragments._IteratorNode__OclElement.initOperations(_IteratorNode__OclElement);
			Fragments._IteratorNode__VariableNode.initOperations(_IteratorNode__VariableNode);
			Fragments._IteratorNode__Visitable.initOperations(_IteratorNode__Visitable);

			Fragments._MappingAction__Element.initOperations(_MappingAction__Element);
			Fragments._MappingAction__MappingAction.initOperations(_MappingAction__MappingAction);
			Fragments._MappingAction__OclAny.initOperations(_MappingAction__OclAny);
			Fragments._MappingAction__OclElement.initOperations(_MappingAction__OclElement);
			Fragments._MappingAction__Visitable.initOperations(_MappingAction__Visitable);

			Fragments._MappingRegion__Element.initOperations(_MappingRegion__Element);
			Fragments._MappingRegion__GraphNode.initOperations(_MappingRegion__GraphNode);
			Fragments._MappingRegion__MappingRegion.initOperations(_MappingRegion__MappingRegion);
			Fragments._MappingRegion__Nameable.initOperations(_MappingRegion__Nameable);
			Fragments._MappingRegion__OclAny.initOperations(_MappingRegion__OclAny);
			Fragments._MappingRegion__OclElement.initOperations(_MappingRegion__OclElement);
			Fragments._MappingRegion__Region.initOperations(_MappingRegion__Region);
			Fragments._MappingRegion__Symbolable.initOperations(_MappingRegion__Symbolable);
			Fragments._MappingRegion__ToDOTable.initOperations(_MappingRegion__ToDOTable);
			Fragments._MappingRegion__Visitable.initOperations(_MappingRegion__Visitable);

			Fragments._MicroMappingRegion__Element.initOperations(_MicroMappingRegion__Element);
			Fragments._MicroMappingRegion__GraphNode.initOperations(_MicroMappingRegion__GraphNode);
			Fragments._MicroMappingRegion__MappingRegion.initOperations(_MicroMappingRegion__MappingRegion);
			Fragments._MicroMappingRegion__MicroMappingRegion.initOperations(_MicroMappingRegion__MicroMappingRegion);
			Fragments._MicroMappingRegion__Nameable.initOperations(_MicroMappingRegion__Nameable);
			Fragments._MicroMappingRegion__OclAny.initOperations(_MicroMappingRegion__OclAny);
			Fragments._MicroMappingRegion__OclElement.initOperations(_MicroMappingRegion__OclElement);
			Fragments._MicroMappingRegion__Region.initOperations(_MicroMappingRegion__Region);
			Fragments._MicroMappingRegion__Symbolable.initOperations(_MicroMappingRegion__Symbolable);
			Fragments._MicroMappingRegion__ToDOTable.initOperations(_MicroMappingRegion__ToDOTable);
			Fragments._MicroMappingRegion__Visitable.initOperations(_MicroMappingRegion__Visitable);

			Fragments._MultiRegion__Element.initOperations(_MultiRegion__Element);
			Fragments._MultiRegion__MultiRegion.initOperations(_MultiRegion__MultiRegion);
			Fragments._MultiRegion__OclAny.initOperations(_MultiRegion__OclAny);
			Fragments._MultiRegion__OclElement.initOperations(_MultiRegion__OclElement);
			Fragments._MultiRegion__Visitable.initOperations(_MultiRegion__Visitable);

			Fragments._NamedMappingRegion__Element.initOperations(_NamedMappingRegion__Element);
			Fragments._NamedMappingRegion__GraphNode.initOperations(_NamedMappingRegion__GraphNode);
			Fragments._NamedMappingRegion__MappingRegion.initOperations(_NamedMappingRegion__MappingRegion);
			Fragments._NamedMappingRegion__Nameable.initOperations(_NamedMappingRegion__Nameable);
			Fragments._NamedMappingRegion__NamedMappingRegion.initOperations(_NamedMappingRegion__NamedMappingRegion);
			Fragments._NamedMappingRegion__OclAny.initOperations(_NamedMappingRegion__OclAny);
			Fragments._NamedMappingRegion__OclElement.initOperations(_NamedMappingRegion__OclElement);
			Fragments._NamedMappingRegion__Region.initOperations(_NamedMappingRegion__Region);
			Fragments._NamedMappingRegion__Symbolable.initOperations(_NamedMappingRegion__Symbolable);
			Fragments._NamedMappingRegion__ToDOTable.initOperations(_NamedMappingRegion__ToDOTable);
			Fragments._NamedMappingRegion__Visitable.initOperations(_NamedMappingRegion__Visitable);

			Fragments._NavigableEdge__ConnectionEnd.initOperations(_NavigableEdge__ConnectionEnd);
			Fragments._NavigableEdge__Edge.initOperations(_NavigableEdge__Edge);
			Fragments._NavigableEdge__Element.initOperations(_NavigableEdge__Element);
			Fragments._NavigableEdge__GraphEdge.initOperations(_NavigableEdge__GraphEdge);
			Fragments._NavigableEdge__Nameable.initOperations(_NavigableEdge__Nameable);
			Fragments._NavigableEdge__NavigableEdge.initOperations(_NavigableEdge__NavigableEdge);
			Fragments._NavigableEdge__OclAny.initOperations(_NavigableEdge__OclAny);
			Fragments._NavigableEdge__OclElement.initOperations(_NavigableEdge__OclElement);
			Fragments._NavigableEdge__Visitable.initOperations(_NavigableEdge__Visitable);

			Fragments._NavigationEdge__ConnectionEnd.initOperations(_NavigationEdge__ConnectionEnd);
			Fragments._NavigationEdge__Edge.initOperations(_NavigationEdge__Edge);
			Fragments._NavigationEdge__Element.initOperations(_NavigationEdge__Element);
			Fragments._NavigationEdge__GraphEdge.initOperations(_NavigationEdge__GraphEdge);
			Fragments._NavigationEdge__Nameable.initOperations(_NavigationEdge__Nameable);
			Fragments._NavigationEdge__NavigableEdge.initOperations(_NavigationEdge__NavigableEdge);
			Fragments._NavigationEdge__NavigationEdge.initOperations(_NavigationEdge__NavigationEdge);
			Fragments._NavigationEdge__OclAny.initOperations(_NavigationEdge__OclAny);
			Fragments._NavigationEdge__OclElement.initOperations(_NavigationEdge__OclElement);
			Fragments._NavigationEdge__Visitable.initOperations(_NavigationEdge__Visitable);

			Fragments._Node__ConnectionEnd.initOperations(_Node__ConnectionEnd);
			Fragments._Node__Element.initOperations(_Node__Element);
			Fragments._Node__GraphNode.initOperations(_Node__GraphNode);
			Fragments._Node__Nameable.initOperations(_Node__Nameable);
			Fragments._Node__Node.initOperations(_Node__Node);
			Fragments._Node__OclAny.initOperations(_Node__OclAny);
			Fragments._Node__OclElement.initOperations(_Node__OclElement);
			Fragments._Node__Visitable.initOperations(_Node__Visitable);

			Fragments._NodeConnection__Connection.initOperations(_NodeConnection__Connection);
			Fragments._NodeConnection__DatumConnection.initOperations(_NodeConnection__DatumConnection);
			Fragments._NodeConnection__Element.initOperations(_NodeConnection__Element);
			Fragments._NodeConnection__GraphEdge.initOperations(_NodeConnection__GraphEdge);
			Fragments._NodeConnection__GraphNode.initOperations(_NodeConnection__GraphNode);
			Fragments._NodeConnection__Nameable.initOperations(_NodeConnection__Nameable);
			Fragments._NodeConnection__NodeConnection.initOperations(_NodeConnection__NodeConnection);
			Fragments._NodeConnection__OclAny.initOperations(_NodeConnection__OclAny);
			Fragments._NodeConnection__OclElement.initOperations(_NodeConnection__OclElement);
			Fragments._NodeConnection__Symbolable.initOperations(_NodeConnection__Symbolable);
			Fragments._NodeConnection__Visitable.initOperations(_NodeConnection__Visitable);

			Fragments._NullNode__ConnectionEnd.initOperations(_NullNode__ConnectionEnd);
			Fragments._NullNode__Element.initOperations(_NullNode__Element);
			Fragments._NullNode__GraphNode.initOperations(_NullNode__GraphNode);
			Fragments._NullNode__Nameable.initOperations(_NullNode__Nameable);
			Fragments._NullNode__Node.initOperations(_NullNode__Node);
			Fragments._NullNode__NullNode.initOperations(_NullNode__NullNode);
			Fragments._NullNode__OclAny.initOperations(_NullNode__OclAny);
			Fragments._NullNode__OclElement.initOperations(_NullNode__OclElement);
			Fragments._NullNode__Visitable.initOperations(_NullNode__Visitable);

			Fragments._OperationNode__ConnectionEnd.initOperations(_OperationNode__ConnectionEnd);
			Fragments._OperationNode__Element.initOperations(_OperationNode__Element);
			Fragments._OperationNode__GraphNode.initOperations(_OperationNode__GraphNode);
			Fragments._OperationNode__Nameable.initOperations(_OperationNode__Nameable);
			Fragments._OperationNode__Node.initOperations(_OperationNode__Node);
			Fragments._OperationNode__OclAny.initOperations(_OperationNode__OclAny);
			Fragments._OperationNode__OclElement.initOperations(_OperationNode__OclElement);
			Fragments._OperationNode__OperationNode.initOperations(_OperationNode__OperationNode);
			Fragments._OperationNode__Visitable.initOperations(_OperationNode__Visitable);

			Fragments._OperationRegion__Element.initOperations(_OperationRegion__Element);
			Fragments._OperationRegion__GraphNode.initOperations(_OperationRegion__GraphNode);
			Fragments._OperationRegion__Nameable.initOperations(_OperationRegion__Nameable);
			Fragments._OperationRegion__OclAny.initOperations(_OperationRegion__OclAny);
			Fragments._OperationRegion__OclElement.initOperations(_OperationRegion__OclElement);
			Fragments._OperationRegion__OperationRegion.initOperations(_OperationRegion__OperationRegion);
			Fragments._OperationRegion__Region.initOperations(_OperationRegion__Region);
			Fragments._OperationRegion__Symbolable.initOperations(_OperationRegion__Symbolable);
			Fragments._OperationRegion__ToDOTable.initOperations(_OperationRegion__ToDOTable);
			Fragments._OperationRegion__Visitable.initOperations(_OperationRegion__Visitable);

			Fragments._PatternTypedNode__ConnectionEnd.initOperations(_PatternTypedNode__ConnectionEnd);
			Fragments._PatternTypedNode__Element.initOperations(_PatternTypedNode__Element);
			Fragments._PatternTypedNode__GraphNode.initOperations(_PatternTypedNode__GraphNode);
			Fragments._PatternTypedNode__Nameable.initOperations(_PatternTypedNode__Nameable);
			Fragments._PatternTypedNode__Node.initOperations(_PatternTypedNode__Node);
			Fragments._PatternTypedNode__OclAny.initOperations(_PatternTypedNode__OclAny);
			Fragments._PatternTypedNode__OclElement.initOperations(_PatternTypedNode__OclElement);
			Fragments._PatternTypedNode__PatternTypedNode.initOperations(_PatternTypedNode__PatternTypedNode);
			Fragments._PatternTypedNode__Visitable.initOperations(_PatternTypedNode__Visitable);

			Fragments._PatternVariableNode__ConnectionEnd.initOperations(_PatternVariableNode__ConnectionEnd);
			Fragments._PatternVariableNode__Element.initOperations(_PatternVariableNode__Element);
			Fragments._PatternVariableNode__GraphNode.initOperations(_PatternVariableNode__GraphNode);
			Fragments._PatternVariableNode__Nameable.initOperations(_PatternVariableNode__Nameable);
			Fragments._PatternVariableNode__Node.initOperations(_PatternVariableNode__Node);
			Fragments._PatternVariableNode__OclAny.initOperations(_PatternVariableNode__OclAny);
			Fragments._PatternVariableNode__OclElement.initOperations(_PatternVariableNode__OclElement);
			Fragments._PatternVariableNode__PatternVariableNode.initOperations(_PatternVariableNode__PatternVariableNode);
			Fragments._PatternVariableNode__VariableNode.initOperations(_PatternVariableNode__VariableNode);
			Fragments._PatternVariableNode__Visitable.initOperations(_PatternVariableNode__Visitable);

			Fragments._Phase__OclAny.initOperations(_Phase__OclAny);
			Fragments._Phase__OclElement.initOperations(_Phase__OclElement);
			Fragments._Phase__OclEnumeration.initOperations(_Phase__OclEnumeration);
			Fragments._Phase__OclType.initOperations(_Phase__OclType);
			Fragments._Phase__Phase.initOperations(_Phase__Phase);

			Fragments._PredicateEdge__Edge.initOperations(_PredicateEdge__Edge);
			Fragments._PredicateEdge__Element.initOperations(_PredicateEdge__Element);
			Fragments._PredicateEdge__GraphEdge.initOperations(_PredicateEdge__GraphEdge);
			Fragments._PredicateEdge__Nameable.initOperations(_PredicateEdge__Nameable);
			Fragments._PredicateEdge__OclAny.initOperations(_PredicateEdge__OclAny);
			Fragments._PredicateEdge__OclElement.initOperations(_PredicateEdge__OclElement);
			Fragments._PredicateEdge__PredicateEdge.initOperations(_PredicateEdge__PredicateEdge);
			Fragments._PredicateEdge__Visitable.initOperations(_PredicateEdge__Visitable);

			Fragments._PropertyDatum__AbstractDatum.initOperations(_PropertyDatum__AbstractDatum);
			Fragments._PropertyDatum__Element.initOperations(_PropertyDatum__Element);
			Fragments._PropertyDatum__OclAny.initOperations(_PropertyDatum__OclAny);
			Fragments._PropertyDatum__OclElement.initOperations(_PropertyDatum__OclElement);
			Fragments._PropertyDatum__PropertyDatum.initOperations(_PropertyDatum__PropertyDatum);
			Fragments._PropertyDatum__Visitable.initOperations(_PropertyDatum__Visitable);

			Fragments._RecursionEdge__Edge.initOperations(_RecursionEdge__Edge);
			Fragments._RecursionEdge__Element.initOperations(_RecursionEdge__Element);
			Fragments._RecursionEdge__GraphEdge.initOperations(_RecursionEdge__GraphEdge);
			Fragments._RecursionEdge__Nameable.initOperations(_RecursionEdge__Nameable);
			Fragments._RecursionEdge__OclAny.initOperations(_RecursionEdge__OclAny);
			Fragments._RecursionEdge__OclElement.initOperations(_RecursionEdge__OclElement);
			Fragments._RecursionEdge__RecursionEdge.initOperations(_RecursionEdge__RecursionEdge);
			Fragments._RecursionEdge__Visitable.initOperations(_RecursionEdge__Visitable);

			Fragments._Region__Element.initOperations(_Region__Element);
			Fragments._Region__GraphNode.initOperations(_Region__GraphNode);
			Fragments._Region__Nameable.initOperations(_Region__Nameable);
			Fragments._Region__OclAny.initOperations(_Region__OclAny);
			Fragments._Region__OclElement.initOperations(_Region__OclElement);
			Fragments._Region__Region.initOperations(_Region__Region);
			Fragments._Region__Symbolable.initOperations(_Region__Symbolable);
			Fragments._Region__ToDOTable.initOperations(_Region__ToDOTable);
			Fragments._Region__Visitable.initOperations(_Region__Visitable);

			Fragments._Role__Element.initOperations(_Role__Element);
			Fragments._Role__OclAny.initOperations(_Role__OclAny);
			Fragments._Role__OclElement.initOperations(_Role__OclElement);
			Fragments._Role__Role.initOperations(_Role__Role);
			Fragments._Role__Visitable.initOperations(_Role__Visitable);

			Fragments._RootCompositionRegion__Element.initOperations(_RootCompositionRegion__Element);
			Fragments._RootCompositionRegion__GraphNode.initOperations(_RootCompositionRegion__GraphNode);
			Fragments._RootCompositionRegion__Nameable.initOperations(_RootCompositionRegion__Nameable);
			Fragments._RootCompositionRegion__OclAny.initOperations(_RootCompositionRegion__OclAny);
			Fragments._RootCompositionRegion__OclElement.initOperations(_RootCompositionRegion__OclElement);
			Fragments._RootCompositionRegion__Region.initOperations(_RootCompositionRegion__Region);
			Fragments._RootCompositionRegion__RootCompositionRegion.initOperations(_RootCompositionRegion__RootCompositionRegion);
			Fragments._RootCompositionRegion__Symbolable.initOperations(_RootCompositionRegion__Symbolable);
			Fragments._RootCompositionRegion__ToDOTable.initOperations(_RootCompositionRegion__ToDOTable);
			Fragments._RootCompositionRegion__Visitable.initOperations(_RootCompositionRegion__Visitable);

			Fragments._ScheduledRegion__Element.initOperations(_ScheduledRegion__Element);
			Fragments._ScheduledRegion__GraphNode.initOperations(_ScheduledRegion__GraphNode);
			Fragments._ScheduledRegion__Nameable.initOperations(_ScheduledRegion__Nameable);
			Fragments._ScheduledRegion__OclAny.initOperations(_ScheduledRegion__OclAny);
			Fragments._ScheduledRegion__OclElement.initOperations(_ScheduledRegion__OclElement);
			Fragments._ScheduledRegion__Region.initOperations(_ScheduledRegion__Region);
			Fragments._ScheduledRegion__ScheduledRegion.initOperations(_ScheduledRegion__ScheduledRegion);
			Fragments._ScheduledRegion__Symbolable.initOperations(_ScheduledRegion__Symbolable);
			Fragments._ScheduledRegion__ToDOTable.initOperations(_ScheduledRegion__ToDOTable);
			Fragments._ScheduledRegion__Visitable.initOperations(_ScheduledRegion__Visitable);

			Fragments._SchedulerConstants__Element.initOperations(_SchedulerConstants__Element);
			Fragments._SchedulerConstants__OclAny.initOperations(_SchedulerConstants__OclAny);
			Fragments._SchedulerConstants__OclElement.initOperations(_SchedulerConstants__OclElement);
			Fragments._SchedulerConstants__SchedulerConstants.initOperations(_SchedulerConstants__SchedulerConstants);
			Fragments._SchedulerConstants__Visitable.initOperations(_SchedulerConstants__Visitable);

			Fragments._Symbolable__OclAny.initOperations(_Symbolable__OclAny);
			Fragments._Symbolable__OclElement.initOperations(_Symbolable__OclElement);
			Fragments._Symbolable__Symbolable.initOperations(_Symbolable__Symbolable);

			Fragments._ToDOTable__OclAny.initOperations(_ToDOTable__OclAny);
			Fragments._ToDOTable__OclElement.initOperations(_ToDOTable__OclElement);
			Fragments._ToDOTable__ToDOTable.initOperations(_ToDOTable__ToDOTable);

			Fragments._TrueNode__ConnectionEnd.initOperations(_TrueNode__ConnectionEnd);
			Fragments._TrueNode__Element.initOperations(_TrueNode__Element);
			Fragments._TrueNode__GraphNode.initOperations(_TrueNode__GraphNode);
			Fragments._TrueNode__Nameable.initOperations(_TrueNode__Nameable);
			Fragments._TrueNode__Node.initOperations(_TrueNode__Node);
			Fragments._TrueNode__OclAny.initOperations(_TrueNode__OclAny);
			Fragments._TrueNode__OclElement.initOperations(_TrueNode__OclElement);
			Fragments._TrueNode__TrueNode.initOperations(_TrueNode__TrueNode);
			Fragments._TrueNode__Visitable.initOperations(_TrueNode__Visitable);

			Fragments._UnknownNode__ConnectionEnd.initOperations(_UnknownNode__ConnectionEnd);
			Fragments._UnknownNode__Element.initOperations(_UnknownNode__Element);
			Fragments._UnknownNode__GraphNode.initOperations(_UnknownNode__GraphNode);
			Fragments._UnknownNode__Nameable.initOperations(_UnknownNode__Nameable);
			Fragments._UnknownNode__Node.initOperations(_UnknownNode__Node);
			Fragments._UnknownNode__OclAny.initOperations(_UnknownNode__OclAny);
			Fragments._UnknownNode__OclElement.initOperations(_UnknownNode__OclElement);
			Fragments._UnknownNode__UnknownNode.initOperations(_UnknownNode__UnknownNode);
			Fragments._UnknownNode__Visitable.initOperations(_UnknownNode__Visitable);

			Fragments._VariableNode__ConnectionEnd.initOperations(_VariableNode__ConnectionEnd);
			Fragments._VariableNode__Element.initOperations(_VariableNode__Element);
			Fragments._VariableNode__GraphNode.initOperations(_VariableNode__GraphNode);
			Fragments._VariableNode__Nameable.initOperations(_VariableNode__Nameable);
			Fragments._VariableNode__Node.initOperations(_VariableNode__Node);
			Fragments._VariableNode__OclAny.initOperations(_VariableNode__OclAny);
			Fragments._VariableNode__OclElement.initOperations(_VariableNode__OclElement);
			Fragments._VariableNode__VariableNode.initOperations(_VariableNode__VariableNode);
			Fragments._VariableNode__Visitable.initOperations(_VariableNode__Visitable);

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

		private static final @NonNull ExecutorProperty @NonNull [] _AbstractDatum = {
			QVTscheduleTables.Properties._AbstractDatum__producedBy,
			QVTscheduleTables.Properties._AbstractDatum__requiredBy,
			QVTscheduleTables.Properties._AbstractDatum__typedModel
		};

		private static final @NonNull ExecutorProperty @NonNull [] _BasicMappingRegion = {
			QVTscheduleTables.Properties._Region__edges,
			QVTscheduleTables.Properties._Region__nodes,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _CastEdge = {
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__region,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ClassDatum = {
			QVTscheduleTables.Properties._ClassDatum__completeClass,
			QVTscheduleTables.Properties._AbstractDatum__producedBy,
			QVTscheduleTables.Properties._ClassDatum__propertyDatums,
			QVTscheduleTables.Properties._AbstractDatum__requiredBy,
			QVTscheduleTables.Properties._ClassDatum__super,
			QVTscheduleTables.Properties._AbstractDatum__typedModel
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ClassDatumAnalysis = {};

		private static final @NonNull ExecutorProperty @NonNull [] _ComposedNode = {
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__region
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Connection = {
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ConnectionEnd = {};

		private static final @NonNull ExecutorProperty @NonNull [] _ConnectionRole = {
			QVTscheduleTables.Properties._ConnectionRole__node
		};

		private static final @NonNull ExecutorProperty @NonNull [] _DatumConnection = {
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _DependencyNode = {
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__region
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Edge = {
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__region,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _EdgeConnection = {
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ErrorNode = {
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__region
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ExpressionEdge = {
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__region,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _GraphEdge = {};

		private static final @NonNull ExecutorProperty @NonNull [] _GraphNode = {};

		private static final @NonNull ExecutorProperty @NonNull [] _InputNode = {
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__region
		};

		private static final @NonNull ExecutorProperty @NonNull [] _IteratedEdge = {
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__region,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _IteratorNode = {
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__region
		};

		private static final @NonNull ExecutorProperty @NonNull [] _MappingAction = {
			QVTscheduleTables.Properties._MappingAction__mapping,
			QVTscheduleTables.Properties._MappingAction__productions,
			QVTscheduleTables.Properties._MappingAction__requisites
		};

		private static final @NonNull ExecutorProperty @NonNull [] _MappingRegion = {
			QVTscheduleTables.Properties._Region__edges,
			QVTscheduleTables.Properties._Region__nodes,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _MicroMappingRegion = {
			QVTscheduleTables.Properties._Region__edges,
			QVTscheduleTables.Properties._Region__nodes,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _MultiRegion = {};

		private static final @NonNull ExecutorProperty @NonNull [] _NamedMappingRegion = {
			QVTscheduleTables.Properties._Region__edges,
			QVTscheduleTables.Properties._Region__nodes,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _NavigableEdge = {
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__region,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _NavigationEdge = {
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__region,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Node = {
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__region
		};

		private static final @NonNull ExecutorProperty @NonNull [] _NodeConnection = {
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _NullNode = {
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__region
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OperationNode = {
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__region
		};

		private static final @NonNull ExecutorProperty @NonNull [] _OperationRegion = {
			QVTscheduleTables.Properties._Region__edges,
			QVTscheduleTables.Properties._Region__nodes,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _PatternTypedNode = {
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__region
		};

		private static final @NonNull ExecutorProperty @NonNull [] _PatternVariableNode = {
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__region
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Phase = {};

		private static final @NonNull ExecutorProperty @NonNull [] _PredicateEdge = {
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__region,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _PropertyDatum = {
			QVTscheduleTables.Properties._PropertyDatum__classDatum,
			QVTscheduleTables.Properties._PropertyDatum__opposite,
			QVTscheduleTables.Properties._AbstractDatum__producedBy,
			QVTscheduleTables.Properties._PropertyDatum__property,
			QVTscheduleTables.Properties._AbstractDatum__requiredBy,
			QVTscheduleTables.Properties._PropertyDatum__super,
			QVTscheduleTables.Properties._AbstractDatum__typedModel
		};

		private static final @NonNull ExecutorProperty @NonNull [] _RecursionEdge = {
			QVTscheduleTables.Properties._Edge__edgeRole,
			QVTscheduleTables.Properties._Edge__name,
			QVTscheduleTables.Properties._Edge__region,
			QVTscheduleTables.Properties._Edge__sourceNode,
			QVTscheduleTables.Properties._Edge__targetNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _Region = {
			QVTscheduleTables.Properties._Region__edges,
			QVTscheduleTables.Properties._Region__nodes,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

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

		private static final @NonNull ExecutorProperty @NonNull [] _RootCompositionRegion = {
			QVTscheduleTables.Properties._Region__edges,
			QVTscheduleTables.Properties._Region__nodes,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ScheduledRegion = {
			QVTscheduleTables.Properties._Region__edges,
			QVTscheduleTables.Properties._ScheduledRegion__name,
			QVTscheduleTables.Properties._Region__nodes,
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _SchedulerConstants = {};

		private static final @NonNull ExecutorProperty @NonNull [] _Symbolable = {
			QVTscheduleTables.Properties._Symbolable__symbolName
		};

		private static final @NonNull ExecutorProperty @NonNull [] _ToDOTable = {};

		private static final @NonNull ExecutorProperty @NonNull [] _TrueNode = {
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__region
		};

		private static final @NonNull ExecutorProperty @NonNull [] _UnknownNode = {
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__region
		};

		private static final @NonNull ExecutorProperty @NonNull [] _VariableNode = {
			QVTscheduleTables.Properties._Node__incomingEdges,
			QVTscheduleTables.Properties._Node__name,
			QVTscheduleTables.Properties._Node__nodeRole,
			QVTscheduleTables.Properties._Node__outgoingEdges,
			QVTscheduleTables.Properties._Node__region
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._AbstractDatum__AbstractDatum.initProperties(_AbstractDatum);
			Fragments._BasicMappingRegion__BasicMappingRegion.initProperties(_BasicMappingRegion);
			Fragments._CastEdge__CastEdge.initProperties(_CastEdge);
			Fragments._ClassDatum__ClassDatum.initProperties(_ClassDatum);
			Fragments._ClassDatumAnalysis__ClassDatumAnalysis.initProperties(_ClassDatumAnalysis);
			Fragments._ComposedNode__ComposedNode.initProperties(_ComposedNode);
			Fragments._Connection__Connection.initProperties(_Connection);
			Fragments._ConnectionEnd__ConnectionEnd.initProperties(_ConnectionEnd);
			Fragments._ConnectionRole__ConnectionRole.initProperties(_ConnectionRole);
			Fragments._DatumConnection__DatumConnection.initProperties(_DatumConnection);
			Fragments._DependencyNode__DependencyNode.initProperties(_DependencyNode);
			Fragments._Edge__Edge.initProperties(_Edge);
			Fragments._EdgeConnection__EdgeConnection.initProperties(_EdgeConnection);
			Fragments._ErrorNode__ErrorNode.initProperties(_ErrorNode);
			Fragments._ExpressionEdge__ExpressionEdge.initProperties(_ExpressionEdge);
			Fragments._GraphEdge__GraphEdge.initProperties(_GraphEdge);
			Fragments._GraphNode__GraphNode.initProperties(_GraphNode);
			Fragments._InputNode__InputNode.initProperties(_InputNode);
			Fragments._IteratedEdge__IteratedEdge.initProperties(_IteratedEdge);
			Fragments._IteratorNode__IteratorNode.initProperties(_IteratorNode);
			Fragments._MappingAction__MappingAction.initProperties(_MappingAction);
			Fragments._MappingRegion__MappingRegion.initProperties(_MappingRegion);
			Fragments._MicroMappingRegion__MicroMappingRegion.initProperties(_MicroMappingRegion);
			Fragments._MultiRegion__MultiRegion.initProperties(_MultiRegion);
			Fragments._NamedMappingRegion__NamedMappingRegion.initProperties(_NamedMappingRegion);
			Fragments._NavigableEdge__NavigableEdge.initProperties(_NavigableEdge);
			Fragments._NavigationEdge__NavigationEdge.initProperties(_NavigationEdge);
			Fragments._Node__Node.initProperties(_Node);
			Fragments._NodeConnection__NodeConnection.initProperties(_NodeConnection);
			Fragments._NullNode__NullNode.initProperties(_NullNode);
			Fragments._OperationNode__OperationNode.initProperties(_OperationNode);
			Fragments._OperationRegion__OperationRegion.initProperties(_OperationRegion);
			Fragments._PatternTypedNode__PatternTypedNode.initProperties(_PatternTypedNode);
			Fragments._PatternVariableNode__PatternVariableNode.initProperties(_PatternVariableNode);
			Fragments._Phase__Phase.initProperties(_Phase);
			Fragments._PredicateEdge__PredicateEdge.initProperties(_PredicateEdge);
			Fragments._PropertyDatum__PropertyDatum.initProperties(_PropertyDatum);
			Fragments._RecursionEdge__RecursionEdge.initProperties(_RecursionEdge);
			Fragments._Region__Region.initProperties(_Region);
			Fragments._Role__Role.initProperties(_Role);
			Fragments._RootCompositionRegion__RootCompositionRegion.initProperties(_RootCompositionRegion);
			Fragments._ScheduledRegion__ScheduledRegion.initProperties(_ScheduledRegion);
			Fragments._SchedulerConstants__SchedulerConstants.initProperties(_SchedulerConstants);
			Fragments._Symbolable__Symbolable.initProperties(_Symbolable);
			Fragments._ToDOTable__ToDOTable.initProperties(_ToDOTable);
			Fragments._TrueNode__TrueNode.initProperties(_TrueNode);
			Fragments._UnknownNode__UnknownNode.initProperties(_UnknownNode);
			Fragments._VariableNode__VariableNode.initProperties(_VariableNode);

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
