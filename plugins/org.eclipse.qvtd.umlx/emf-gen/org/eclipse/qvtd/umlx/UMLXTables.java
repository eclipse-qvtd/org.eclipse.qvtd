/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 *   /org.eclipse.qvtd.umlx/model/UMLX.ecore
 * using:
 *   /org.eclipse.qvtd.umlx/model/UMLX.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package org.eclipse.qvtd.umlx;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.TemplateParameters;
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
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.qvtd.umlx.UMLXTables;

/**
 * UMLXTables provides the dispatch tables for the umlx for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
@SuppressWarnings("nls")
public class UMLXTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final @NonNull EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(UMLXPackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final @NonNull ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = org.eclipse.ocl.pivot.ids.IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, org.eclipse.emf.ecore.EcorePackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2016/UMLX", null, org.eclipse.qvtd.umlx.UMLXPackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = org.eclipse.qvtd.umlx.UMLXTables.PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_EAttribute = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EAttribute", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_EClass = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EClass", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_EClassifier = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EClassifier", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_EPackage = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EPackage", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_EReference = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EReference", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_EStructuralFeature = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EStructuralFeature", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RelDiagram = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("RelDiagram", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RelDomainNode = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("RelDomainNode", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RelInvocationEdge = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("RelInvocationEdge", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RelInvocationNode = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("RelInvocationNode", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RelPatternEdge = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("RelPatternEdge", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RelPatternNode = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("RelPatternNode", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TxDiagram = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("TxDiagram", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TxKeyNode = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("TxKeyNode", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TxPackageNode = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("TxPackageNode", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TxParameterNode = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("TxParameterNode", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TxPartNode = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("TxPartNode", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TxQueryNode = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("TxQueryNode", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TxTypedModelNode = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("TxTypedModelNode", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_UMLXModel = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2016_s_UMLX.getClassId("UMLXModel", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull DataTypeId DATAid_EInt = org.eclipse.qvtd.umlx.UMLXTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EInt", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue INT_0 = org.eclipse.ocl.pivot.utilities.ValueUtil.integerValueOf("0");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue INT_1 = org.eclipse.ocl.pivot.utilities.ValueUtil.integerValueOf("1");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_PRIMid_String = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.ocl.pivot.ids.TypeId.STRING);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull TuplePartId PARTid_ = org.eclipse.ocl.pivot.ids.IdManager.getTuplePartId(1, "status", org.eclipse.ocl.pivot.ids.TypeId.BOOLEAN);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull TuplePartId PARTid__0 = org.eclipse.ocl.pivot.ids.IdManager.getTuplePartId(0, "message", org.eclipse.ocl.pivot.ids.TypeId.STRING);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_PRIMid_String = org.eclipse.ocl.pivot.ids.TypeId.SEQUENCE.getSpecializedId(org.eclipse.ocl.pivot.ids.TypeId.STRING);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_PRIMid_String = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.ocl.pivot.ids.TypeId.STRING);
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_ = "";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelDiagram_c_c_NameIsRequired = "RelDiagram::NameIsRequired";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelDiagram_c_c_RelPatternNodeNamesAreUnique = "RelDiagram::RelPatternNodeNamesAreUnique";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelDiagram_c_c_RelPatternNodeNamesAreUnique_c = "RelDiagram::RelPatternNodeNamesAreUnique:";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelInvocationNode_c_c_CompatibleEdges = "RelInvocationNode::CompatibleEdges";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelInvocationNode_c_c_CompatibleEdges_32 = "RelInvocationNode::CompatibleEdges ";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelPatternEdge_c_c_CompatibleEAttributePropertyTarget = "RelPatternEdge::CompatibleEAttributePropertyTarget";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelPatternEdge_c_c_CompatibleEReferencePropertyTarget = "RelPatternEdge::CompatibleEReferencePropertyTarget";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelPatternEdge_c_c_CompatibleMemberPropertyTarget = "RelPatternEdge::CompatibleMemberPropertyTarget";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelPatternEdge_c_c_CompatiblePropertySource = "RelPatternEdge::CompatiblePropertySource";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelPatternEdge_c_c_CompatibleRestPropertyTarget = "RelPatternEdge::CompatibleRestPropertyTarget";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelPatternEdge_c_c_CompatibleSourceIndex = "RelPatternEdge::CompatibleSourceIndex";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelPatternEdge_c_c_CompatibleSourceMultiplicity = "RelPatternEdge::CompatibleSourceMultiplicity";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelPatternEdge_c_c_SourceIsClassNode = "RelPatternEdge::SourceIsClassNode";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelPatternEdge_c_c_SourceIsEClass = "RelPatternEdge::SourceIsEClass";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelPatternNode_c_c_AnonIsUnnamed = "RelPatternNode::AnonIsUnnamed";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelPatternNode_c_c_EClassifierIsInTypedModel = "RelPatternNode::EClassifierIsInTypedModel";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_RelPatternNode_c_c_TypeIsRequired = "RelPatternNode::TypeIsRequired";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_TxDiagram_c_c_NameIsRequired = "TxDiagram::NameIsRequired";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_TxDiagram_c_c_RelDiagramNamesAreUnique = "TxDiagram::RelDiagramNamesAreUnique";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_TxDiagram_c_c_TxQueryNodeNamesAreUnique = "TxDiagram::TxQueryNodeNamesAreUnique";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_TxDiagram_c_c_TxTypedModelNodeNamesAreUnique = "TxDiagram::TxTypedModelNodeNamesAreUnique";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_TxKeyNode_c_c_PartsAreUnique = "TxKeyNode::PartsAreUnique";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_TxParameterNode_c_c_NameIsRequired = "TxParameterNode::NameIsRequired";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_TxParameterNode_c_c_TypeIsRequired = "TxParameterNode::TypeIsRequired";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_TxPartNode_c_c_PartIsPropertyOfKey = "TxPartNode::PartIsPropertyOfKey";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_TxQueryNode_c_c_NameIsRequired = "TxQueryNode::NameIsRequired";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_TxQueryNode_c_c_ParametersAreUnique = "TxQueryNode::ParametersAreUnique";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_TxQueryNode_c_c_TypeIsRequired = "TxQueryNode::TypeIsRequired";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_TxTypedModelNode_c_c_NameIsRequired = "TxTypedModelNode::NameIsRequired";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_TxTypedModelNode_c_c_TxPackageNodePackagesAreUnique = "TxTypedModelNode::TxPackageNodePackagesAreUnique";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR__32_39 = " \'";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR__32_are_32_not_32_unique_32_for_32 = " are not unique for ";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR__39 = "\'";
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR_quot = "/";
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_RelDomainNode = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_RelDomainNode);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_RelInvocationEdge = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_RelInvocationEdge);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_RelInvocationNode = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_RelInvocationNode);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_TxTypedModelNode = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_TxTypedModelNode);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_EClass = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_EClass);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_EClassifier = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_EClassifier);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_RelDiagram = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_RelDiagram);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_RelDomainNode = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_RelDomainNode);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_RelInvocationEdge = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_RelInvocationEdge);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_RelInvocationNode = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_RelInvocationNode);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_RelPatternEdge = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_RelPatternEdge);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_RelPatternNode = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_RelPatternNode);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_TxDiagram = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_TxDiagram);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_TxKeyNode = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_TxKeyNode);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_TxPackageNode = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_TxPackageNode);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_TxParameterNode = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_TxParameterNode);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_TxPartNode = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_TxPartNode);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_TxQueryNode = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_TxQueryNode);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_TxTypedModelNode = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_TxTypedModelNode);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_EClassifier = org.eclipse.ocl.pivot.ids.TypeId.SEQUENCE.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_EClassifier);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_EPackage = org.eclipse.ocl.pivot.ids.TypeId.SEQUENCE.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_EPackage);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_RelPatternNode = org.eclipse.ocl.pivot.ids.TypeId.SEQUENCE.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_RelPatternNode);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_EClass = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_EClass);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_RelPatternNode = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(org.eclipse.qvtd.umlx.UMLXTables.CLSSid_RelPatternNode);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull TupleTypeId TUPLid_ = org.eclipse.ocl.pivot.ids.IdManager.getTupleTypeId("Tuple", org.eclipse.qvtd.umlx.UMLXTables.PARTid__0, org.eclipse.qvtd.umlx.UMLXTables.PARTid_);

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

		public static final @NonNull EcoreExecutorType _RelDiagram = new EcoreExecutorType(UMLXPackage.Literals.REL_DIAGRAM, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _RelDomainNode = new EcoreExecutorType(UMLXPackage.Literals.REL_DOMAIN_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _RelEdge = new EcoreExecutorType(UMLXPackage.Literals.REL_EDGE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _RelInvocationEdge = new EcoreExecutorType(UMLXPackage.Literals.REL_INVOCATION_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _RelInvocationNode = new EcoreExecutorType(UMLXPackage.Literals.REL_INVOCATION_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _RelNode = new EcoreExecutorType(UMLXPackage.Literals.REL_NODE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _RelPatternEdge = new EcoreExecutorType(UMLXPackage.Literals.REL_PATTERN_EDGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _RelPatternNode = new EcoreExecutorType(UMLXPackage.Literals.REL_PATTERN_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TxDiagram = new EcoreExecutorType(UMLXPackage.Literals.TX_DIAGRAM, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TxKeyNode = new EcoreExecutorType(UMLXPackage.Literals.TX_KEY_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TxNode = new EcoreExecutorType(UMLXPackage.Literals.TX_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TxPackageNode = new EcoreExecutorType(UMLXPackage.Literals.TX_PACKAGE_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TxParameterNode = new EcoreExecutorType(UMLXPackage.Literals.TX_PARAMETER_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TxPartNode = new EcoreExecutorType(UMLXPackage.Literals.TX_PART_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TxQueryNode = new EcoreExecutorType(UMLXPackage.Literals.TX_QUERY_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TxTypedModelNode = new EcoreExecutorType(UMLXPackage.Literals.TX_TYPED_MODEL_NODE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _UMLXElement = new EcoreExecutorType(UMLXPackage.Literals.UMLX_ELEMENT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _UMLXModel = new EcoreExecutorType(UMLXPackage.Literals.UMLX_MODEL, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _UMLXNamedElement = new EcoreExecutorType(UMLXPackage.Literals.UMLX_NAMED_ELEMENT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final @NonNull EcoreExecutorType _UMLXTypedElement = new EcoreExecutorType(UMLXPackage.Literals.UMLX_TYPED_ELEMENT, PACKAGE, 0 | ExecutorType.ABSTRACT);

		private static final @NonNull EcoreExecutorType @NonNull [] types = {
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
			PACKAGE.init(LIBRARY, types);
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

		private static final @NonNull ExecutorFragment _RelDiagram__OclAny = new ExecutorFragment(Types._RelDiagram, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _RelDiagram__OclElement = new ExecutorFragment(Types._RelDiagram, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _RelDiagram__RelDiagram = new ExecutorFragment(Types._RelDiagram, UMLXTables.Types._RelDiagram);
		private static final @NonNull ExecutorFragment _RelDiagram__UMLXElement = new ExecutorFragment(Types._RelDiagram, UMLXTables.Types._UMLXElement);
		private static final @NonNull ExecutorFragment _RelDiagram__UMLXNamedElement = new ExecutorFragment(Types._RelDiagram, UMLXTables.Types._UMLXNamedElement);

		private static final @NonNull ExecutorFragment _RelDomainNode__OclAny = new ExecutorFragment(Types._RelDomainNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _RelDomainNode__OclElement = new ExecutorFragment(Types._RelDomainNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _RelDomainNode__RelDomainNode = new ExecutorFragment(Types._RelDomainNode, UMLXTables.Types._RelDomainNode);
		private static final @NonNull ExecutorFragment _RelDomainNode__RelNode = new ExecutorFragment(Types._RelDomainNode, UMLXTables.Types._RelNode);
		private static final @NonNull ExecutorFragment _RelDomainNode__UMLXElement = new ExecutorFragment(Types._RelDomainNode, UMLXTables.Types._UMLXElement);

		private static final @NonNull ExecutorFragment _RelEdge__OclAny = new ExecutorFragment(Types._RelEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _RelEdge__OclElement = new ExecutorFragment(Types._RelEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _RelEdge__RelEdge = new ExecutorFragment(Types._RelEdge, UMLXTables.Types._RelEdge);
		private static final @NonNull ExecutorFragment _RelEdge__UMLXElement = new ExecutorFragment(Types._RelEdge, UMLXTables.Types._UMLXElement);

		private static final @NonNull ExecutorFragment _RelInvocationEdge__OclAny = new ExecutorFragment(Types._RelInvocationEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _RelInvocationEdge__OclElement = new ExecutorFragment(Types._RelInvocationEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _RelInvocationEdge__RelEdge = new ExecutorFragment(Types._RelInvocationEdge, UMLXTables.Types._RelEdge);
		private static final @NonNull ExecutorFragment _RelInvocationEdge__RelInvocationEdge = new ExecutorFragment(Types._RelInvocationEdge, UMLXTables.Types._RelInvocationEdge);
		private static final @NonNull ExecutorFragment _RelInvocationEdge__UMLXElement = new ExecutorFragment(Types._RelInvocationEdge, UMLXTables.Types._UMLXElement);

		private static final @NonNull ExecutorFragment _RelInvocationNode__OclAny = new ExecutorFragment(Types._RelInvocationNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _RelInvocationNode__OclElement = new ExecutorFragment(Types._RelInvocationNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _RelInvocationNode__RelInvocationNode = new ExecutorFragment(Types._RelInvocationNode, UMLXTables.Types._RelInvocationNode);
		private static final @NonNull ExecutorFragment _RelInvocationNode__RelNode = new ExecutorFragment(Types._RelInvocationNode, UMLXTables.Types._RelNode);
		private static final @NonNull ExecutorFragment _RelInvocationNode__UMLXElement = new ExecutorFragment(Types._RelInvocationNode, UMLXTables.Types._UMLXElement);

		private static final @NonNull ExecutorFragment _RelNode__OclAny = new ExecutorFragment(Types._RelNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _RelNode__OclElement = new ExecutorFragment(Types._RelNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _RelNode__RelNode = new ExecutorFragment(Types._RelNode, UMLXTables.Types._RelNode);
		private static final @NonNull ExecutorFragment _RelNode__UMLXElement = new ExecutorFragment(Types._RelNode, UMLXTables.Types._UMLXElement);

		private static final @NonNull ExecutorFragment _RelPatternEdge__OclAny = new ExecutorFragment(Types._RelPatternEdge, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _RelPatternEdge__OclElement = new ExecutorFragment(Types._RelPatternEdge, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _RelPatternEdge__RelEdge = new ExecutorFragment(Types._RelPatternEdge, UMLXTables.Types._RelEdge);
		private static final @NonNull ExecutorFragment _RelPatternEdge__RelPatternEdge = new ExecutorFragment(Types._RelPatternEdge, UMLXTables.Types._RelPatternEdge);
		private static final @NonNull ExecutorFragment _RelPatternEdge__UMLXElement = new ExecutorFragment(Types._RelPatternEdge, UMLXTables.Types._UMLXElement);

		private static final @NonNull ExecutorFragment _RelPatternNode__OclAny = new ExecutorFragment(Types._RelPatternNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _RelPatternNode__OclElement = new ExecutorFragment(Types._RelPatternNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _RelPatternNode__RelNode = new ExecutorFragment(Types._RelPatternNode, UMLXTables.Types._RelNode);
		private static final @NonNull ExecutorFragment _RelPatternNode__RelPatternNode = new ExecutorFragment(Types._RelPatternNode, UMLXTables.Types._RelPatternNode);
		private static final @NonNull ExecutorFragment _RelPatternNode__UMLXElement = new ExecutorFragment(Types._RelPatternNode, UMLXTables.Types._UMLXElement);
		private static final @NonNull ExecutorFragment _RelPatternNode__UMLXNamedElement = new ExecutorFragment(Types._RelPatternNode, UMLXTables.Types._UMLXNamedElement);
		private static final @NonNull ExecutorFragment _RelPatternNode__UMLXTypedElement = new ExecutorFragment(Types._RelPatternNode, UMLXTables.Types._UMLXTypedElement);

		private static final @NonNull ExecutorFragment _TxDiagram__OclAny = new ExecutorFragment(Types._TxDiagram, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _TxDiagram__OclElement = new ExecutorFragment(Types._TxDiagram, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _TxDiagram__TxDiagram = new ExecutorFragment(Types._TxDiagram, UMLXTables.Types._TxDiagram);
		private static final @NonNull ExecutorFragment _TxDiagram__UMLXElement = new ExecutorFragment(Types._TxDiagram, UMLXTables.Types._UMLXElement);
		private static final @NonNull ExecutorFragment _TxDiagram__UMLXNamedElement = new ExecutorFragment(Types._TxDiagram, UMLXTables.Types._UMLXNamedElement);

		private static final @NonNull ExecutorFragment _TxKeyNode__OclAny = new ExecutorFragment(Types._TxKeyNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _TxKeyNode__OclElement = new ExecutorFragment(Types._TxKeyNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _TxKeyNode__TxKeyNode = new ExecutorFragment(Types._TxKeyNode, UMLXTables.Types._TxKeyNode);
		private static final @NonNull ExecutorFragment _TxKeyNode__TxNode = new ExecutorFragment(Types._TxKeyNode, UMLXTables.Types._TxNode);
		private static final @NonNull ExecutorFragment _TxKeyNode__UMLXElement = new ExecutorFragment(Types._TxKeyNode, UMLXTables.Types._UMLXElement);

		private static final @NonNull ExecutorFragment _TxNode__OclAny = new ExecutorFragment(Types._TxNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _TxNode__OclElement = new ExecutorFragment(Types._TxNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _TxNode__TxNode = new ExecutorFragment(Types._TxNode, UMLXTables.Types._TxNode);
		private static final @NonNull ExecutorFragment _TxNode__UMLXElement = new ExecutorFragment(Types._TxNode, UMLXTables.Types._UMLXElement);

		private static final @NonNull ExecutorFragment _TxPackageNode__OclAny = new ExecutorFragment(Types._TxPackageNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _TxPackageNode__OclElement = new ExecutorFragment(Types._TxPackageNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _TxPackageNode__TxNode = new ExecutorFragment(Types._TxPackageNode, UMLXTables.Types._TxNode);
		private static final @NonNull ExecutorFragment _TxPackageNode__TxPackageNode = new ExecutorFragment(Types._TxPackageNode, UMLXTables.Types._TxPackageNode);
		private static final @NonNull ExecutorFragment _TxPackageNode__UMLXElement = new ExecutorFragment(Types._TxPackageNode, UMLXTables.Types._UMLXElement);

		private static final @NonNull ExecutorFragment _TxParameterNode__OclAny = new ExecutorFragment(Types._TxParameterNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _TxParameterNode__OclElement = new ExecutorFragment(Types._TxParameterNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _TxParameterNode__TxNode = new ExecutorFragment(Types._TxParameterNode, UMLXTables.Types._TxNode);
		private static final @NonNull ExecutorFragment _TxParameterNode__TxParameterNode = new ExecutorFragment(Types._TxParameterNode, UMLXTables.Types._TxParameterNode);
		private static final @NonNull ExecutorFragment _TxParameterNode__UMLXElement = new ExecutorFragment(Types._TxParameterNode, UMLXTables.Types._UMLXElement);
		private static final @NonNull ExecutorFragment _TxParameterNode__UMLXNamedElement = new ExecutorFragment(Types._TxParameterNode, UMLXTables.Types._UMLXNamedElement);
		private static final @NonNull ExecutorFragment _TxParameterNode__UMLXTypedElement = new ExecutorFragment(Types._TxParameterNode, UMLXTables.Types._UMLXTypedElement);

		private static final @NonNull ExecutorFragment _TxPartNode__OclAny = new ExecutorFragment(Types._TxPartNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _TxPartNode__OclElement = new ExecutorFragment(Types._TxPartNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _TxPartNode__TxNode = new ExecutorFragment(Types._TxPartNode, UMLXTables.Types._TxNode);
		private static final @NonNull ExecutorFragment _TxPartNode__TxPartNode = new ExecutorFragment(Types._TxPartNode, UMLXTables.Types._TxPartNode);
		private static final @NonNull ExecutorFragment _TxPartNode__UMLXElement = new ExecutorFragment(Types._TxPartNode, UMLXTables.Types._UMLXElement);

		private static final @NonNull ExecutorFragment _TxQueryNode__OclAny = new ExecutorFragment(Types._TxQueryNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _TxQueryNode__OclElement = new ExecutorFragment(Types._TxQueryNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _TxQueryNode__TxNode = new ExecutorFragment(Types._TxQueryNode, UMLXTables.Types._TxNode);
		private static final @NonNull ExecutorFragment _TxQueryNode__TxQueryNode = new ExecutorFragment(Types._TxQueryNode, UMLXTables.Types._TxQueryNode);
		private static final @NonNull ExecutorFragment _TxQueryNode__UMLXElement = new ExecutorFragment(Types._TxQueryNode, UMLXTables.Types._UMLXElement);
		private static final @NonNull ExecutorFragment _TxQueryNode__UMLXNamedElement = new ExecutorFragment(Types._TxQueryNode, UMLXTables.Types._UMLXNamedElement);
		private static final @NonNull ExecutorFragment _TxQueryNode__UMLXTypedElement = new ExecutorFragment(Types._TxQueryNode, UMLXTables.Types._UMLXTypedElement);

		private static final @NonNull ExecutorFragment _TxTypedModelNode__OclAny = new ExecutorFragment(Types._TxTypedModelNode, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _TxTypedModelNode__OclElement = new ExecutorFragment(Types._TxTypedModelNode, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _TxTypedModelNode__TxNode = new ExecutorFragment(Types._TxTypedModelNode, UMLXTables.Types._TxNode);
		private static final @NonNull ExecutorFragment _TxTypedModelNode__TxTypedModelNode = new ExecutorFragment(Types._TxTypedModelNode, UMLXTables.Types._TxTypedModelNode);
		private static final @NonNull ExecutorFragment _TxTypedModelNode__UMLXElement = new ExecutorFragment(Types._TxTypedModelNode, UMLXTables.Types._UMLXElement);
		private static final @NonNull ExecutorFragment _TxTypedModelNode__UMLXNamedElement = new ExecutorFragment(Types._TxTypedModelNode, UMLXTables.Types._UMLXNamedElement);

		private static final @NonNull ExecutorFragment _UMLXElement__OclAny = new ExecutorFragment(Types._UMLXElement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _UMLXElement__OclElement = new ExecutorFragment(Types._UMLXElement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _UMLXElement__UMLXElement = new ExecutorFragment(Types._UMLXElement, UMLXTables.Types._UMLXElement);

		private static final @NonNull ExecutorFragment _UMLXModel__OclAny = new ExecutorFragment(Types._UMLXModel, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _UMLXModel__OclElement = new ExecutorFragment(Types._UMLXModel, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _UMLXModel__UMLXElement = new ExecutorFragment(Types._UMLXModel, UMLXTables.Types._UMLXElement);
		private static final @NonNull ExecutorFragment _UMLXModel__UMLXModel = new ExecutorFragment(Types._UMLXModel, UMLXTables.Types._UMLXModel);

		private static final @NonNull ExecutorFragment _UMLXNamedElement__OclAny = new ExecutorFragment(Types._UMLXNamedElement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _UMLXNamedElement__OclElement = new ExecutorFragment(Types._UMLXNamedElement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _UMLXNamedElement__UMLXElement = new ExecutorFragment(Types._UMLXNamedElement, UMLXTables.Types._UMLXElement);
		private static final @NonNull ExecutorFragment _UMLXNamedElement__UMLXNamedElement = new ExecutorFragment(Types._UMLXNamedElement, UMLXTables.Types._UMLXNamedElement);

		private static final @NonNull ExecutorFragment _UMLXTypedElement__OclAny = new ExecutorFragment(Types._UMLXTypedElement, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _UMLXTypedElement__OclElement = new ExecutorFragment(Types._UMLXTypedElement, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _UMLXTypedElement__UMLXElement = new ExecutorFragment(Types._UMLXTypedElement, UMLXTables.Types._UMLXElement);
		private static final @NonNull ExecutorFragment _UMLXTypedElement__UMLXNamedElement = new ExecutorFragment(Types._UMLXTypedElement, UMLXTables.Types._UMLXNamedElement);
		private static final @NonNull ExecutorFragment _UMLXTypedElement__UMLXTypedElement = new ExecutorFragment(Types._UMLXTypedElement, UMLXTables.Types._UMLXTypedElement);

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

		public static final @NonNull ExecutorOperation _RelPatternNode__isExpression = new ExecutorOperation("isExpression", TypeUtil.EMPTY_PARAMETER_TYPES, Types._RelPatternNode,
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

		public static final @NonNull ExecutorProperty _RelDiagram__isAbstract = new EcoreExecutorProperty(UMLXPackage.Literals.REL_DIAGRAM__IS_ABSTRACT, Types._RelDiagram, 0);
		public static final @NonNull ExecutorProperty _RelDiagram__isTop = new EcoreExecutorProperty(UMLXPackage.Literals.REL_DIAGRAM__IS_TOP, Types._RelDiagram, 1);
		public static final @NonNull ExecutorProperty _RelDiagram__ownedRelDomainNodes = new EcoreExecutorProperty(UMLXPackage.Literals.REL_DIAGRAM__OWNED_REL_DOMAIN_NODES, Types._RelDiagram, 2);
		public static final @NonNull ExecutorProperty _RelDiagram__ownedRelInvocationNodes = new EcoreExecutorProperty(UMLXPackage.Literals.REL_DIAGRAM__OWNED_REL_INVOCATION_NODES, Types._RelDiagram, 3);
		public static final @NonNull ExecutorProperty _RelDiagram__owningTxDiagram = new EcoreExecutorProperty(UMLXPackage.Literals.REL_DIAGRAM__OWNING_TX_DIAGRAM, Types._RelDiagram, 4);
		public static final @NonNull ExecutorProperty _RelDiagram__RelInvocationNode__referredRelDiagram = new ExecutorPropertyWithImplementation("RelInvocationNode", Types._RelDiagram, 5, new EcoreLibraryOppositeProperty(UMLXPackage.Literals.REL_INVOCATION_NODE__REFERRED_REL_DIAGRAM));

		public static final @NonNull ExecutorProperty _RelDomainNode__isEnforced = new EcoreExecutorProperty(UMLXPackage.Literals.REL_DOMAIN_NODE__IS_ENFORCED, Types._RelDomainNode, 0);
		public static final @NonNull ExecutorProperty _RelDomainNode__ownedRelPatternEdges = new EcoreExecutorProperty(UMLXPackage.Literals.REL_DOMAIN_NODE__OWNED_REL_PATTERN_EDGES, Types._RelDomainNode, 1);
		public static final @NonNull ExecutorProperty _RelDomainNode__ownedRelPatternNodes = new EcoreExecutorProperty(UMLXPackage.Literals.REL_DOMAIN_NODE__OWNED_REL_PATTERN_NODES, Types._RelDomainNode, 2);
		public static final @NonNull ExecutorProperty _RelDomainNode__owningRelDiagram = new EcoreExecutorProperty(UMLXPackage.Literals.REL_DOMAIN_NODE__OWNING_REL_DIAGRAM, Types._RelDomainNode, 3);
		public static final @NonNull ExecutorProperty _RelDomainNode__referredTxTypedModelNode = new EcoreExecutorProperty(UMLXPackage.Literals.REL_DOMAIN_NODE__REFERRED_TX_TYPED_MODEL_NODE, Types._RelDomainNode, 4);

		public static final @NonNull ExecutorProperty _RelInvocationEdge__invokingRelPatternNode = new EcoreExecutorProperty(UMLXPackage.Literals.REL_INVOCATION_EDGE__INVOKING_REL_PATTERN_NODE, Types._RelInvocationEdge, 0);
		public static final @NonNull ExecutorProperty _RelInvocationEdge__owningRelInvocationNode = new EcoreExecutorProperty(UMLXPackage.Literals.REL_INVOCATION_EDGE__OWNING_REL_INVOCATION_NODE, Types._RelInvocationEdge, 1);
		public static final @NonNull ExecutorProperty _RelInvocationEdge__referredRelPatternNode = new EcoreExecutorProperty(UMLXPackage.Literals.REL_INVOCATION_EDGE__REFERRED_REL_PATTERN_NODE, Types._RelInvocationEdge, 2);

		public static final @NonNull ExecutorProperty _RelInvocationNode__isThen = new EcoreExecutorProperty(UMLXPackage.Literals.REL_INVOCATION_NODE__IS_THEN, Types._RelInvocationNode, 0);
		public static final @NonNull ExecutorProperty _RelInvocationNode__ownedRelInvocationEdges = new EcoreExecutorProperty(UMLXPackage.Literals.REL_INVOCATION_NODE__OWNED_REL_INVOCATION_EDGES, Types._RelInvocationNode, 1);
		public static final @NonNull ExecutorProperty _RelInvocationNode__owningRelDiagram = new EcoreExecutorProperty(UMLXPackage.Literals.REL_INVOCATION_NODE__OWNING_REL_DIAGRAM, Types._RelInvocationNode, 2);
		public static final @NonNull ExecutorProperty _RelInvocationNode__referredRelDiagram = new EcoreExecutorProperty(UMLXPackage.Literals.REL_INVOCATION_NODE__REFERRED_REL_DIAGRAM, Types._RelInvocationNode, 3);

		public static final @NonNull ExecutorProperty _RelPatternEdge__owningRelDomainNode = new EcoreExecutorProperty(UMLXPackage.Literals.REL_PATTERN_EDGE__OWNING_REL_DOMAIN_NODE, Types._RelPatternEdge, 0);
		public static final @NonNull ExecutorProperty _RelPatternEdge__referredEStructuralFeature = new EcoreExecutorProperty(UMLXPackage.Literals.REL_PATTERN_EDGE__REFERRED_ESTRUCTURAL_FEATURE, Types._RelPatternEdge, 1);
		public static final @NonNull ExecutorProperty _RelPatternEdge__source = new EcoreExecutorProperty(UMLXPackage.Literals.REL_PATTERN_EDGE__SOURCE, Types._RelPatternEdge, 2);
		public static final @NonNull ExecutorProperty _RelPatternEdge__sourceIndex = new EcoreExecutorProperty(UMLXPackage.Literals.REL_PATTERN_EDGE__SOURCE_INDEX, Types._RelPatternEdge, 3);
		public static final @NonNull ExecutorProperty _RelPatternEdge__target = new EcoreExecutorProperty(UMLXPackage.Literals.REL_PATTERN_EDGE__TARGET, Types._RelPatternEdge, 4);

		public static final @NonNull ExecutorProperty _RelPatternNode__incoming = new EcoreExecutorProperty(UMLXPackage.Literals.REL_PATTERN_NODE__INCOMING, Types._RelPatternNode, 0);
		public static final @NonNull ExecutorProperty _RelPatternNode__initExpressionLines = new EcoreExecutorProperty(UMLXPackage.Literals.REL_PATTERN_NODE__INIT_EXPRESSION_LINES, Types._RelPatternNode, 1);
		public static final @NonNull ExecutorProperty _RelPatternNode__invokingRelInvocationEdges = new EcoreExecutorProperty(UMLXPackage.Literals.REL_PATTERN_NODE__INVOKING_REL_INVOCATION_EDGES, Types._RelPatternNode, 2);
		public static final @NonNull ExecutorProperty _RelPatternNode__isAnon = new EcoreExecutorProperty(UMLXPackage.Literals.REL_PATTERN_NODE__IS_ANON, Types._RelPatternNode, 3);
		public static final @NonNull ExecutorProperty _RelPatternNode__isRoot = new EcoreExecutorProperty(UMLXPackage.Literals.REL_PATTERN_NODE__IS_ROOT, Types._RelPatternNode, 4);
		public static final @NonNull ExecutorProperty _RelPatternNode__outgoing = new EcoreExecutorProperty(UMLXPackage.Literals.REL_PATTERN_NODE__OUTGOING, Types._RelPatternNode, 5);
		public static final @NonNull ExecutorProperty _RelPatternNode__owningRelDomainNode = new EcoreExecutorProperty(UMLXPackage.Literals.REL_PATTERN_NODE__OWNING_REL_DOMAIN_NODE, Types._RelPatternNode, 6);
		public static final @NonNull ExecutorProperty _RelPatternNode__RelInvocationEdge__referredRelPatternNode = new ExecutorPropertyWithImplementation("RelInvocationEdge", Types._RelPatternNode, 7, new EcoreLibraryOppositeProperty(UMLXPackage.Literals.REL_INVOCATION_EDGE__REFERRED_REL_PATTERN_NODE));

		public static final @NonNull ExecutorProperty _TxDiagram__ownedRelDiagrams = new EcoreExecutorProperty(UMLXPackage.Literals.TX_DIAGRAM__OWNED_REL_DIAGRAMS, Types._TxDiagram, 0);
		public static final @NonNull ExecutorProperty _TxDiagram__ownedTxKeyNodes = new EcoreExecutorProperty(UMLXPackage.Literals.TX_DIAGRAM__OWNED_TX_KEY_NODES, Types._TxDiagram, 1);
		public static final @NonNull ExecutorProperty _TxDiagram__ownedTxPackageNodes = new EcoreExecutorProperty(UMLXPackage.Literals.TX_DIAGRAM__OWNED_TX_PACKAGE_NODES, Types._TxDiagram, 2);
		public static final @NonNull ExecutorProperty _TxDiagram__ownedTxQueryNodes = new EcoreExecutorProperty(UMLXPackage.Literals.TX_DIAGRAM__OWNED_TX_QUERY_NODES, Types._TxDiagram, 3);
		public static final @NonNull ExecutorProperty _TxDiagram__ownedTxTypedModelNodes = new EcoreExecutorProperty(UMLXPackage.Literals.TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES, Types._TxDiagram, 4);
		public static final @NonNull ExecutorProperty _TxDiagram__package = new EcoreExecutorProperty(UMLXPackage.Literals.TX_DIAGRAM__PACKAGE, Types._TxDiagram, 5);
		public static final @NonNull ExecutorProperty _TxDiagram__UMLXModel__ownedTxDiagrams = new ExecutorPropertyWithImplementation("UMLXModel", Types._TxDiagram, 6, new EcoreLibraryOppositeProperty(UMLXPackage.Literals.UMLX_MODEL__OWNED_TX_DIAGRAMS));

		public static final @NonNull ExecutorProperty _TxKeyNode__ownedTxPartNodes = new EcoreExecutorProperty(UMLXPackage.Literals.TX_KEY_NODE__OWNED_TX_PART_NODES, Types._TxKeyNode, 0);
		public static final @NonNull ExecutorProperty _TxKeyNode__owningTxDiagram = new EcoreExecutorProperty(UMLXPackage.Literals.TX_KEY_NODE__OWNING_TX_DIAGRAM, Types._TxKeyNode, 1);
		public static final @NonNull ExecutorProperty _TxKeyNode__referredEClass = new EcoreExecutorProperty(UMLXPackage.Literals.TX_KEY_NODE__REFERRED_ECLASS, Types._TxKeyNode, 2);

		public static final @NonNull ExecutorProperty _TxPackageNode__importAliases = new EcoreExecutorProperty(UMLXPackage.Literals.TX_PACKAGE_NODE__IMPORT_ALIASES, Types._TxPackageNode, 0);
		public static final @NonNull ExecutorProperty _TxPackageNode__owningTxDiagram = new EcoreExecutorProperty(UMLXPackage.Literals.TX_PACKAGE_NODE__OWNING_TX_DIAGRAM, Types._TxPackageNode, 1);
		public static final @NonNull ExecutorProperty _TxPackageNode__referredEPackage = new EcoreExecutorProperty(UMLXPackage.Literals.TX_PACKAGE_NODE__REFERRED_EPACKAGE, Types._TxPackageNode, 2);
		public static final @NonNull ExecutorProperty _TxPackageNode__TxTypedModelNode__usedTxPackageNodes = new ExecutorPropertyWithImplementation("TxTypedModelNode", Types._TxPackageNode, 3, new EcoreLibraryOppositeProperty(UMLXPackage.Literals.TX_TYPED_MODEL_NODE__USED_TX_PACKAGE_NODES));

		public static final @NonNull ExecutorProperty _TxParameterNode__owningTxQueryNode = new EcoreExecutorProperty(UMLXPackage.Literals.TX_PARAMETER_NODE__OWNING_TX_QUERY_NODE, Types._TxParameterNode, 0);

		public static final @NonNull ExecutorProperty _TxPartNode__isOpposite = new EcoreExecutorProperty(UMLXPackage.Literals.TX_PART_NODE__IS_OPPOSITE, Types._TxPartNode, 0);
		public static final @NonNull ExecutorProperty _TxPartNode__owningTxKeyNode = new EcoreExecutorProperty(UMLXPackage.Literals.TX_PART_NODE__OWNING_TX_KEY_NODE, Types._TxPartNode, 1);
		public static final @NonNull ExecutorProperty _TxPartNode__referredEStructuralFeature = new EcoreExecutorProperty(UMLXPackage.Literals.TX_PART_NODE__REFERRED_ESTRUCTURAL_FEATURE, Types._TxPartNode, 2);

		public static final @NonNull ExecutorProperty _TxQueryNode__initExpressionLines = new EcoreExecutorProperty(UMLXPackage.Literals.TX_QUERY_NODE__INIT_EXPRESSION_LINES, Types._TxQueryNode, 0);
		public static final @NonNull ExecutorProperty _TxQueryNode__ownedTxParameterNodes = new EcoreExecutorProperty(UMLXPackage.Literals.TX_QUERY_NODE__OWNED_TX_PARAMETER_NODES, Types._TxQueryNode, 1);
		public static final @NonNull ExecutorProperty _TxQueryNode__owningTxDiagram = new EcoreExecutorProperty(UMLXPackage.Literals.TX_QUERY_NODE__OWNING_TX_DIAGRAM, Types._TxQueryNode, 2);

		public static final @NonNull ExecutorProperty _TxTypedModelNode__check = new EcoreExecutorProperty(UMLXPackage.Literals.TX_TYPED_MODEL_NODE__CHECK, Types._TxTypedModelNode, 0);
		public static final @NonNull ExecutorProperty _TxTypedModelNode__dependsOns = new EcoreExecutorProperty(UMLXPackage.Literals.TX_TYPED_MODEL_NODE__DEPENDS_ONS, Types._TxTypedModelNode, 1);
		public static final @NonNull ExecutorProperty _TxTypedModelNode__enforce = new EcoreExecutorProperty(UMLXPackage.Literals.TX_TYPED_MODEL_NODE__ENFORCE, Types._TxTypedModelNode, 2);
		public static final @NonNull ExecutorProperty _TxTypedModelNode__owningTxDiagram = new EcoreExecutorProperty(UMLXPackage.Literals.TX_TYPED_MODEL_NODE__OWNING_TX_DIAGRAM, Types._TxTypedModelNode, 3);
		public static final @NonNull ExecutorProperty _TxTypedModelNode__usedTxPackageNodes = new EcoreExecutorProperty(UMLXPackage.Literals.TX_TYPED_MODEL_NODE__USED_TX_PACKAGE_NODES, Types._TxTypedModelNode, 4);
		public static final @NonNull ExecutorProperty _TxTypedModelNode__RelDomainNode__referredTxTypedModelNode = new ExecutorPropertyWithImplementation("RelDomainNode", Types._TxTypedModelNode, 5, new EcoreLibraryOppositeProperty(UMLXPackage.Literals.REL_DOMAIN_NODE__REFERRED_TX_TYPED_MODEL_NODE));
		public static final @NonNull ExecutorProperty _TxTypedModelNode__TxTypedModelNode__dependsOns = new ExecutorPropertyWithImplementation("TxTypedModelNode", Types._TxTypedModelNode, 6, new EcoreLibraryOppositeProperty(UMLXPackage.Literals.TX_TYPED_MODEL_NODE__DEPENDS_ONS));

		public static final @NonNull ExecutorProperty _UMLXElement__comments = new EcoreExecutorProperty(UMLXPackage.Literals.UMLX_ELEMENT__COMMENTS, Types._UMLXElement, 0);

		public static final @NonNull ExecutorProperty _UMLXModel__ownedTxDiagrams = new EcoreExecutorProperty(UMLXPackage.Literals.UMLX_MODEL__OWNED_TX_DIAGRAMS, Types._UMLXModel, 0);

		public static final @NonNull ExecutorProperty _UMLXNamedElement__name = new EcoreExecutorProperty(UMLXPackage.Literals.UMLX_NAMED_ELEMENT__NAME, Types._UMLXNamedElement, 0);

		public static final @NonNull ExecutorProperty _UMLXTypedElement__isMany = new EcoreExecutorProperty(UMLXPackage.Literals.UMLX_TYPED_ELEMENT__IS_MANY, Types._UMLXTypedElement, 0);
		public static final @NonNull ExecutorProperty _UMLXTypedElement__isNullFree = new EcoreExecutorProperty(UMLXPackage.Literals.UMLX_TYPED_ELEMENT__IS_NULL_FREE, Types._UMLXTypedElement, 1);
		public static final @NonNull ExecutorProperty _UMLXTypedElement__isOrdered = new EcoreExecutorProperty(UMLXPackage.Literals.UMLX_TYPED_ELEMENT__IS_ORDERED, Types._UMLXTypedElement, 2);
		public static final @NonNull ExecutorProperty _UMLXTypedElement__isRequired = new EcoreExecutorProperty(UMLXPackage.Literals.UMLX_TYPED_ELEMENT__IS_REQUIRED, Types._UMLXTypedElement, 3);
		public static final @NonNull ExecutorProperty _UMLXTypedElement__isUnique = new EcoreExecutorProperty(UMLXPackage.Literals.UMLX_TYPED_ELEMENT__IS_UNIQUE, Types._UMLXTypedElement, 4);
		public static final @NonNull ExecutorProperty _UMLXTypedElement__referredEClassifier = new EcoreExecutorProperty(UMLXPackage.Literals.UMLX_TYPED_ELEMENT__REFERRED_ECLASSIFIER, Types._UMLXTypedElement, 5);
		static {
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

		private static final @NonNull ExecutorFragment @NonNull [] _RelDiagram =
		{
			Fragments._RelDiagram__OclAny /* 0 */,
			Fragments._RelDiagram__OclElement /* 1 */,
			Fragments._RelDiagram__UMLXElement /* 2 */,
			Fragments._RelDiagram__UMLXNamedElement /* 3 */,
			Fragments._RelDiagram__RelDiagram /* 4 */
		};
		private static final int @NonNull [] __RelDiagram = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _RelDomainNode =
		{
			Fragments._RelDomainNode__OclAny /* 0 */,
			Fragments._RelDomainNode__OclElement /* 1 */,
			Fragments._RelDomainNode__UMLXElement /* 2 */,
			Fragments._RelDomainNode__RelNode /* 3 */,
			Fragments._RelDomainNode__RelDomainNode /* 4 */
		};
		private static final int @NonNull [] __RelDomainNode = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _RelEdge =
		{
			Fragments._RelEdge__OclAny /* 0 */,
			Fragments._RelEdge__OclElement /* 1 */,
			Fragments._RelEdge__UMLXElement /* 2 */,
			Fragments._RelEdge__RelEdge /* 3 */
		};
		private static final int @NonNull [] __RelEdge = { 1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _RelInvocationEdge =
		{
			Fragments._RelInvocationEdge__OclAny /* 0 */,
			Fragments._RelInvocationEdge__OclElement /* 1 */,
			Fragments._RelInvocationEdge__UMLXElement /* 2 */,
			Fragments._RelInvocationEdge__RelEdge /* 3 */,
			Fragments._RelInvocationEdge__RelInvocationEdge /* 4 */
		};
		private static final int @NonNull [] __RelInvocationEdge = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _RelInvocationNode =
		{
			Fragments._RelInvocationNode__OclAny /* 0 */,
			Fragments._RelInvocationNode__OclElement /* 1 */,
			Fragments._RelInvocationNode__UMLXElement /* 2 */,
			Fragments._RelInvocationNode__RelNode /* 3 */,
			Fragments._RelInvocationNode__RelInvocationNode /* 4 */
		};
		private static final int @NonNull [] __RelInvocationNode = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _RelNode =
		{
			Fragments._RelNode__OclAny /* 0 */,
			Fragments._RelNode__OclElement /* 1 */,
			Fragments._RelNode__UMLXElement /* 2 */,
			Fragments._RelNode__RelNode /* 3 */
		};
		private static final int @NonNull [] __RelNode = { 1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _RelPatternEdge =
		{
			Fragments._RelPatternEdge__OclAny /* 0 */,
			Fragments._RelPatternEdge__OclElement /* 1 */,
			Fragments._RelPatternEdge__UMLXElement /* 2 */,
			Fragments._RelPatternEdge__RelEdge /* 3 */,
			Fragments._RelPatternEdge__RelPatternEdge /* 4 */
		};
		private static final int @NonNull [] __RelPatternEdge = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _RelPatternNode =
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

		private static final @NonNull ExecutorFragment @NonNull [] _TxDiagram =
		{
			Fragments._TxDiagram__OclAny /* 0 */,
			Fragments._TxDiagram__OclElement /* 1 */,
			Fragments._TxDiagram__UMLXElement /* 2 */,
			Fragments._TxDiagram__UMLXNamedElement /* 3 */,
			Fragments._TxDiagram__TxDiagram /* 4 */
		};
		private static final int @NonNull [] __TxDiagram = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _TxKeyNode =
		{
			Fragments._TxKeyNode__OclAny /* 0 */,
			Fragments._TxKeyNode__OclElement /* 1 */,
			Fragments._TxKeyNode__UMLXElement /* 2 */,
			Fragments._TxKeyNode__TxNode /* 3 */,
			Fragments._TxKeyNode__TxKeyNode /* 4 */
		};
		private static final int @NonNull [] __TxKeyNode = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _TxNode =
		{
			Fragments._TxNode__OclAny /* 0 */,
			Fragments._TxNode__OclElement /* 1 */,
			Fragments._TxNode__UMLXElement /* 2 */,
			Fragments._TxNode__TxNode /* 3 */
		};
		private static final int @NonNull [] __TxNode = { 1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _TxPackageNode =
		{
			Fragments._TxPackageNode__OclAny /* 0 */,
			Fragments._TxPackageNode__OclElement /* 1 */,
			Fragments._TxPackageNode__UMLXElement /* 2 */,
			Fragments._TxPackageNode__TxNode /* 3 */,
			Fragments._TxPackageNode__TxPackageNode /* 4 */
		};
		private static final int @NonNull [] __TxPackageNode = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _TxParameterNode =
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

		private static final @NonNull ExecutorFragment @NonNull [] _TxPartNode =
		{
			Fragments._TxPartNode__OclAny /* 0 */,
			Fragments._TxPartNode__OclElement /* 1 */,
			Fragments._TxPartNode__UMLXElement /* 2 */,
			Fragments._TxPartNode__TxNode /* 3 */,
			Fragments._TxPartNode__TxPartNode /* 4 */
		};
		private static final int @NonNull [] __TxPartNode = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _TxQueryNode =
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

		private static final @NonNull ExecutorFragment @NonNull [] _TxTypedModelNode =
		{
			Fragments._TxTypedModelNode__OclAny /* 0 */,
			Fragments._TxTypedModelNode__OclElement /* 1 */,
			Fragments._TxTypedModelNode__UMLXElement /* 2 */,
			Fragments._TxTypedModelNode__TxNode /* 3 */,
			Fragments._TxTypedModelNode__UMLXNamedElement /* 3 */,
			Fragments._TxTypedModelNode__TxTypedModelNode /* 4 */
		};
		private static final int @NonNull [] __TxTypedModelNode = { 1,1,1,2,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _UMLXElement =
		{
			Fragments._UMLXElement__OclAny /* 0 */,
			Fragments._UMLXElement__OclElement /* 1 */,
			Fragments._UMLXElement__UMLXElement /* 2 */
		};
		private static final int @NonNull [] __UMLXElement = { 1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _UMLXModel =
		{
			Fragments._UMLXModel__OclAny /* 0 */,
			Fragments._UMLXModel__OclElement /* 1 */,
			Fragments._UMLXModel__UMLXElement /* 2 */,
			Fragments._UMLXModel__UMLXModel /* 3 */
		};
		private static final int @NonNull [] __UMLXModel = { 1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _UMLXNamedElement =
		{
			Fragments._UMLXNamedElement__OclAny /* 0 */,
			Fragments._UMLXNamedElement__OclElement /* 1 */,
			Fragments._UMLXNamedElement__UMLXElement /* 2 */,
			Fragments._UMLXNamedElement__UMLXNamedElement /* 3 */
		};
		private static final int @NonNull [] __UMLXNamedElement = { 1,1,1,1 };

		private static final @NonNull ExecutorFragment @NonNull [] _UMLXTypedElement =
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

		private static final @NonNull ExecutorOperation @NonNull [] _RelDiagram__RelDiagram = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelDiagram__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _RelDiagram__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelDiagram__UMLXElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelDiagram__UMLXNamedElement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _RelDomainNode__RelDomainNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelDomainNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _RelDomainNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelDomainNode__RelNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelDomainNode__UMLXElement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _RelEdge__RelEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _RelEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelEdge__UMLXElement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _RelInvocationEdge__RelInvocationEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelInvocationEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _RelInvocationEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelInvocationEdge__RelEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelInvocationEdge__UMLXElement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _RelInvocationNode__RelInvocationNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelInvocationNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _RelInvocationNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelInvocationNode__RelNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelInvocationNode__UMLXElement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _RelNode__RelNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _RelNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelNode__UMLXElement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _RelPatternEdge__RelPatternEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelPatternEdge__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _RelPatternEdge__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelPatternEdge__RelEdge = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelPatternEdge__UMLXElement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _RelPatternNode__RelPatternNode = {
			UMLXTables.Operations._RelPatternNode__isExpression /* isExpression() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelPatternNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _RelPatternNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _RelPatternNode__RelNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelPatternNode__UMLXElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelPatternNode__UMLXNamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _RelPatternNode__UMLXTypedElement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _TxDiagram__TxDiagram = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxDiagram__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _TxDiagram__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TxDiagram__UMLXElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxDiagram__UMLXNamedElement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _TxKeyNode__TxKeyNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxKeyNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _TxKeyNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TxKeyNode__TxNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxKeyNode__UMLXElement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _TxNode__TxNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _TxNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TxNode__UMLXElement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _TxPackageNode__TxPackageNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxPackageNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _TxPackageNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TxPackageNode__TxNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxPackageNode__UMLXElement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _TxParameterNode__TxParameterNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxParameterNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _TxParameterNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TxParameterNode__TxNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxParameterNode__UMLXElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxParameterNode__UMLXNamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxParameterNode__UMLXTypedElement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _TxPartNode__TxPartNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxPartNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _TxPartNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TxPartNode__TxNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxPartNode__UMLXElement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _TxQueryNode__TxQueryNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxQueryNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _TxQueryNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TxQueryNode__TxNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxQueryNode__UMLXElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxQueryNode__UMLXNamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxQueryNode__UMLXTypedElement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _TxTypedModelNode__TxTypedModelNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxTypedModelNode__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _TxTypedModelNode__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _TxTypedModelNode__TxNode = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxTypedModelNode__UMLXElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _TxTypedModelNode__UMLXNamedElement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _UMLXElement__UMLXElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _UMLXElement__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _UMLXElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final @NonNull ExecutorOperation @NonNull [] _UMLXModel__UMLXModel = {};
		private static final @NonNull ExecutorOperation @NonNull [] _UMLXModel__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _UMLXModel__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _UMLXModel__UMLXElement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _UMLXNamedElement__UMLXNamedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _UMLXNamedElement__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _UMLXNamedElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _UMLXNamedElement__UMLXElement = {};

		private static final @NonNull ExecutorOperation @NonNull [] _UMLXTypedElement__UMLXTypedElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _UMLXTypedElement__OclAny = {
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
		private static final @NonNull ExecutorOperation @NonNull [] _UMLXTypedElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final @NonNull ExecutorOperation @NonNull [] _UMLXTypedElement__UMLXElement = {};
		private static final @NonNull ExecutorOperation @NonNull [] _UMLXTypedElement__UMLXNamedElement = {};

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

		private static final @NonNull ExecutorProperty @NonNull [] _RelDiagram = {
			UMLXTables.Properties._UMLXElement__comments,
			UMLXTables.Properties._RelDiagram__isAbstract,
			UMLXTables.Properties._RelDiagram__isTop,
			UMLXTables.Properties._UMLXNamedElement__name,
			UMLXTables.Properties._RelDiagram__ownedRelDomainNodes,
			UMLXTables.Properties._RelDiagram__ownedRelInvocationNodes,
			UMLXTables.Properties._RelDiagram__owningTxDiagram
		};

		private static final @NonNull ExecutorProperty @NonNull [] _RelDomainNode = {
			UMLXTables.Properties._UMLXElement__comments,
			UMLXTables.Properties._RelDomainNode__isEnforced,
			UMLXTables.Properties._RelDomainNode__ownedRelPatternEdges,
			UMLXTables.Properties._RelDomainNode__ownedRelPatternNodes,
			UMLXTables.Properties._RelDomainNode__owningRelDiagram,
			UMLXTables.Properties._RelDomainNode__referredTxTypedModelNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _RelEdge = {
			UMLXTables.Properties._UMLXElement__comments
		};

		private static final @NonNull ExecutorProperty @NonNull [] _RelInvocationEdge = {
			UMLXTables.Properties._UMLXElement__comments,
			UMLXTables.Properties._RelInvocationEdge__invokingRelPatternNode,
			UMLXTables.Properties._RelInvocationEdge__owningRelInvocationNode,
			UMLXTables.Properties._RelInvocationEdge__referredRelPatternNode
		};

		private static final @NonNull ExecutorProperty @NonNull [] _RelInvocationNode = {
			UMLXTables.Properties._UMLXElement__comments,
			UMLXTables.Properties._RelInvocationNode__isThen,
			UMLXTables.Properties._RelInvocationNode__ownedRelInvocationEdges,
			UMLXTables.Properties._RelInvocationNode__owningRelDiagram,
			UMLXTables.Properties._RelInvocationNode__referredRelDiagram
		};

		private static final @NonNull ExecutorProperty @NonNull [] _RelNode = {
			UMLXTables.Properties._UMLXElement__comments
		};

		private static final @NonNull ExecutorProperty @NonNull [] _RelPatternEdge = {
			UMLXTables.Properties._UMLXElement__comments,
			UMLXTables.Properties._RelPatternEdge__owningRelDomainNode,
			UMLXTables.Properties._RelPatternEdge__referredEStructuralFeature,
			UMLXTables.Properties._RelPatternEdge__source,
			UMLXTables.Properties._RelPatternEdge__sourceIndex,
			UMLXTables.Properties._RelPatternEdge__target
		};

		private static final @NonNull ExecutorProperty @NonNull [] _RelPatternNode = {
			UMLXTables.Properties._UMLXElement__comments,
			UMLXTables.Properties._RelPatternNode__incoming,
			UMLXTables.Properties._RelPatternNode__initExpressionLines,
			UMLXTables.Properties._RelPatternNode__invokingRelInvocationEdges,
			UMLXTables.Properties._RelPatternNode__isAnon,
			UMLXTables.Properties._UMLXTypedElement__isMany,
			UMLXTables.Properties._UMLXTypedElement__isNullFree,
			UMLXTables.Properties._UMLXTypedElement__isOrdered,
			UMLXTables.Properties._UMLXTypedElement__isRequired,
			UMLXTables.Properties._RelPatternNode__isRoot,
			UMLXTables.Properties._UMLXTypedElement__isUnique,
			UMLXTables.Properties._UMLXNamedElement__name,
			UMLXTables.Properties._RelPatternNode__outgoing,
			UMLXTables.Properties._RelPatternNode__owningRelDomainNode,
			UMLXTables.Properties._UMLXTypedElement__referredEClassifier
		};

		private static final @NonNull ExecutorProperty @NonNull [] _TxDiagram = {
			UMLXTables.Properties._UMLXElement__comments,
			UMLXTables.Properties._UMLXNamedElement__name,
			UMLXTables.Properties._TxDiagram__ownedRelDiagrams,
			UMLXTables.Properties._TxDiagram__ownedTxKeyNodes,
			UMLXTables.Properties._TxDiagram__ownedTxPackageNodes,
			UMLXTables.Properties._TxDiagram__ownedTxQueryNodes,
			UMLXTables.Properties._TxDiagram__ownedTxTypedModelNodes,
			UMLXTables.Properties._TxDiagram__package
		};

		private static final @NonNull ExecutorProperty @NonNull [] _TxKeyNode = {
			UMLXTables.Properties._UMLXElement__comments,
			UMLXTables.Properties._TxKeyNode__ownedTxPartNodes,
			UMLXTables.Properties._TxKeyNode__owningTxDiagram,
			UMLXTables.Properties._TxKeyNode__referredEClass
		};

		private static final @NonNull ExecutorProperty @NonNull [] _TxNode = {
			UMLXTables.Properties._UMLXElement__comments
		};

		private static final @NonNull ExecutorProperty @NonNull [] _TxPackageNode = {
			UMLXTables.Properties._UMLXElement__comments,
			UMLXTables.Properties._TxPackageNode__importAliases,
			UMLXTables.Properties._TxPackageNode__owningTxDiagram,
			UMLXTables.Properties._TxPackageNode__referredEPackage
		};

		private static final @NonNull ExecutorProperty @NonNull [] _TxParameterNode = {
			UMLXTables.Properties._UMLXElement__comments,
			UMLXTables.Properties._UMLXTypedElement__isMany,
			UMLXTables.Properties._UMLXTypedElement__isNullFree,
			UMLXTables.Properties._UMLXTypedElement__isOrdered,
			UMLXTables.Properties._UMLXTypedElement__isRequired,
			UMLXTables.Properties._UMLXTypedElement__isUnique,
			UMLXTables.Properties._UMLXNamedElement__name,
			UMLXTables.Properties._TxParameterNode__owningTxQueryNode,
			UMLXTables.Properties._UMLXTypedElement__referredEClassifier
		};

		private static final @NonNull ExecutorProperty @NonNull [] _TxPartNode = {
			UMLXTables.Properties._UMLXElement__comments,
			UMLXTables.Properties._TxPartNode__isOpposite,
			UMLXTables.Properties._TxPartNode__owningTxKeyNode,
			UMLXTables.Properties._TxPartNode__referredEStructuralFeature
		};

		private static final @NonNull ExecutorProperty @NonNull [] _TxQueryNode = {
			UMLXTables.Properties._UMLXElement__comments,
			UMLXTables.Properties._TxQueryNode__initExpressionLines,
			UMLXTables.Properties._UMLXTypedElement__isMany,
			UMLXTables.Properties._UMLXTypedElement__isNullFree,
			UMLXTables.Properties._UMLXTypedElement__isOrdered,
			UMLXTables.Properties._UMLXTypedElement__isRequired,
			UMLXTables.Properties._UMLXTypedElement__isUnique,
			UMLXTables.Properties._UMLXNamedElement__name,
			UMLXTables.Properties._TxQueryNode__ownedTxParameterNodes,
			UMLXTables.Properties._TxQueryNode__owningTxDiagram,
			UMLXTables.Properties._UMLXTypedElement__referredEClassifier
		};

		private static final @NonNull ExecutorProperty @NonNull [] _TxTypedModelNode = {
			UMLXTables.Properties._TxTypedModelNode__check,
			UMLXTables.Properties._UMLXElement__comments,
			UMLXTables.Properties._TxTypedModelNode__dependsOns,
			UMLXTables.Properties._TxTypedModelNode__enforce,
			UMLXTables.Properties._UMLXNamedElement__name,
			UMLXTables.Properties._TxTypedModelNode__owningTxDiagram,
			UMLXTables.Properties._TxTypedModelNode__usedTxPackageNodes
		};

		private static final @NonNull ExecutorProperty @NonNull [] _UMLXElement = {
			UMLXTables.Properties._UMLXElement__comments
		};

		private static final @NonNull ExecutorProperty @NonNull [] _UMLXModel = {
			UMLXTables.Properties._UMLXElement__comments,
			UMLXTables.Properties._UMLXModel__ownedTxDiagrams
		};

		private static final @NonNull ExecutorProperty @NonNull [] _UMLXNamedElement = {
			UMLXTables.Properties._UMLXElement__comments,
			UMLXTables.Properties._UMLXNamedElement__name
		};

		private static final @NonNull ExecutorProperty @NonNull [] _UMLXTypedElement = {
			UMLXTables.Properties._UMLXElement__comments,
			UMLXTables.Properties._UMLXTypedElement__isMany,
			UMLXTables.Properties._UMLXTypedElement__isNullFree,
			UMLXTables.Properties._UMLXTypedElement__isOrdered,
			UMLXTables.Properties._UMLXTypedElement__isRequired,
			UMLXTables.Properties._UMLXTypedElement__isUnique,
			UMLXTables.Properties._UMLXNamedElement__name,
			UMLXTables.Properties._UMLXTypedElement__referredEClassifier
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
