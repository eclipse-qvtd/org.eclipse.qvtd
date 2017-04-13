/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.umlx.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2ASReferenceSwitch;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelInvocationEdge;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.TxPartNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXNamedElement;
import org.eclipse.qvtd.umlx.UMLXTypedElement;

/**
 * Class owning methods used for service: umlx. The service methods
 * should be prefixed by umlx to avoid conflict with other services.
 */
public class UMLXServices
{
	public UMLXServices() {}

	protected void appendMultiplicity(@NonNull StringBuilder s, int lower, int upper) {
		if (upper == 1) {
			s.append(lower == 1 ? "[1]" : "[?]");
		}
		else {
			if (upper < 0) {
				if (lower == 0) {
					s.append("[*]");
				}
				else if (lower == 1) {
					s.append("[+]");
				}
				else {
					s.append("[" + lower + "..*]");
				}
			}
			else if (lower == upper) {
				s.append("[" + lower + "]");
			}
			else {
				s.append("[" + lower + ".." + upper + "]");
			}
		}
	}

	protected void appendType(StringBuilder s, @NonNull UMLXTypedElement umlxTypedElement) {
		if (umlxTypedElement.isIsMany()) {
			if (umlxTypedElement.isIsUnique()) {
				s.append(umlxTypedElement.isIsOrdered() ? "OrderedSet" : "Set");
			}
			else {
				s.append(umlxTypedElement.isIsOrdered() ? "Sequence" : "Bag");
			}
			s.append("(");
		}
		EClassifier eClassifier = umlxTypedElement.getReferredEClassifier();
		if (eClassifier != null) {
			s.append(eClassifier.eIsProxy() ? EcoreUtil.getURI(eClassifier) : String.valueOf(eClassifier.getName()));
		}
		if (umlxTypedElement.isIsMany()) {
			s.append(")");
		}
		else {
			s.append(umlxTypedElement.isIsRequired() ? "[1]" : "[?]");
		}
	}

	protected void appendTypedElement(StringBuilder s, @NonNull UMLXTypedElement umlxTypedElement, @NonNull String nameTypeSeparator) {
		s.append(String.valueOf(umlxTypedElement.getName()));
		s.append(nameTypeSeparator);
		appendType(s, umlxTypedElement);
	}

	protected @NonNull String defaultName(@NonNull EObject context, @NonNull Class<? extends UMLXNamedElement> newClass, @NonNull String prefix) {
		Set<@NonNull String> allNames = new HashSet<>();
		Resource eResource = context.eResource();
		assert eResource != null;
		for (EObject eObject : new TreeIterable(eResource)) {
			if (newClass.isAssignableFrom(eObject.getClass())) {
				allNames.add(UMLXUtil.getName((UMLXNamedElement)eObject));
			}
		}
		for (int i = allNames.size(); true; i++) {
			String newName = prefix + i;
			if (!allNames.contains(newName)) {
				return newName;
			}
		}
	}

	private int getEOppositeLower(@NonNull EReference eReference) {
		EReference eOpposite = eReference.getEOpposite();
		if (eOpposite != null) {
			return eOpposite.getLowerBound();
		}
		EAnnotation oppositeRole = eReference.getEAnnotation(EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI_2_0);
		if (oppositeRole != null) {
			EMap<String, String> details = oppositeRole.getDetails();
			String oppositeName = details.get(Ecore2ASReferenceSwitch.PROPERTY_OPPOSITE_ROLE_NAME_KEY);
			if (oppositeName != null) {
				String lowerValue = details.get(Ecore2ASReferenceSwitch.PROPERTY_OPPOSITE_ROLE_LOWER_KEY);
				IntegerValue one = ValueUtil.ONE_VALUE;
				IntegerValue lower = lowerValue != null ? ValueUtil.integerValueOf(lowerValue) : one;
				if (lower.isInvalid()) {
					//						logger.error("Invalid " + Ecore2ASReferenceSwitch.PROPERTY_OPPOSITE_ROLE_LOWER_KEY + " " + lower);
					lower = one;
				}
				return lower.intValue();
			}
		}
		else {
			oppositeRole = eReference.getEAnnotation(EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE);
			if (oppositeRole != null) {
				EMap<String, String> details = oppositeRole.getDetails();
				String oppositeName = details.get(EMOFExtendedMetaData.EMOF_COMMENT_BODY);
				if (oppositeName != null) {
					String lowerValue = details.get("lower");
					IntegerValue lower = lowerValue != null ? ValueUtil.integerValueOf(lowerValue) :  PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_LOWER_VALUE;
					if (lower.isInvalid()) {
						//						logger.error("Invalid " + Ecore2ASReferenceSwitch.PROPERTY_OPPOSITE_ROLE_LOWER_KEY + " " + lower);
						lower = PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_LOWER_VALUE;
					}
					return lower.intValue();
				}
			}
		}
		return 0;
	}

	private String getEOppositeName(@NonNull EReference eReference) {
		EReference eOpposite = eReference.getEOpposite();
		if (eOpposite != null) {
			return eOpposite.getName();
		}
		EAnnotation oppositeRole = eReference.getEAnnotation(EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI_2_0);
		if (oppositeRole != null) {
			EMap<String, String> details = oppositeRole.getDetails();
			String oppositeName = details.get(Ecore2ASReferenceSwitch.PROPERTY_OPPOSITE_ROLE_NAME_KEY);
			if (oppositeName != null) {
				return oppositeName;
			}
		}
		else {
			oppositeRole = eReference.getEAnnotation(EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE);
			if (oppositeRole != null) {
				EMap<String, String> details = oppositeRole.getDetails();
				String oppositeName = details.get(EMOFExtendedMetaData.EMOF_COMMENT_BODY);
				if (oppositeName != null) {
					return oppositeName;
				}
			}
		}
		return "«inferred»";
	}

	private int getEOppositeUpper(@NonNull EReference eReference) {
		EReference eOpposite = eReference.getEOpposite();
		if (eOpposite != null) {
			return eOpposite.getUpperBound();
		}
		EAnnotation oppositeRole = eReference.getEAnnotation(EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI_2_0);
		if (oppositeRole != null) {
			EMap<String, String> details = oppositeRole.getDetails();
			String oppositeName = details.get(Ecore2ASReferenceSwitch.PROPERTY_OPPOSITE_ROLE_NAME_KEY);
			if (oppositeName != null) {
				String upperValue = details.get(Ecore2ASReferenceSwitch.PROPERTY_OPPOSITE_ROLE_UPPER_KEY);
				UnlimitedNaturalValue unlimitedOne = ValueUtil.UNLIMITED_ONE_VALUE;
				UnlimitedNaturalValue upper = upperValue != null ? ValueUtil.unlimitedNaturalValueOf(upperValue) : unlimitedOne;
				if (upper.isInvalid()) {
					//						logger.error("Invalid " + Ecore2ASReferenceSwitch.PROPERTY_OPPOSITE_ROLE_UPPER_KEY + " " + upper);
					upper = unlimitedOne;
				}
				return upper.intValue();
			}
		}
		else {
			oppositeRole = eReference.getEAnnotation(EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE);
			if (oppositeRole != null) {
				EMap<String, String> details = oppositeRole.getDetails();
				String oppositeName = details.get(EMOFExtendedMetaData.EMOF_COMMENT_BODY);
				if (oppositeName != null) {
					String upperValue = details.get("upper");
					UnlimitedNaturalValue upper = upperValue != null ? ValueUtil.unlimitedNaturalValueOf(upperValue) : PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_UPPER_VALUE;
					if (upper.isInvalid()) {
						//						logger.error("Invalid " + Ecore2ASReferenceSwitch.PROPERTY_OPPOSITE_ROLE_UPPER_KEY + " " + upper);
						upper = PivotConstantsInternal.ANNOTATED_IMPLICIT_OPPOSITE_UPPER_VALUE;
					}
					return upper.intValue();
				}
			}
		}
		return 0;
	}

	public int umlxBorderSize(EObject context) {
		return 4;
	}

	/**
	 * Return a default name for context.
	 */
	public @NonNull String umlxDefaultName(EObject context) {
		if ((context instanceof RelPatternNode) && !((RelPatternNode)context).isExpression()) {
			return defaultName(context, RelPatternNode.class, "NewClass");
		}
		else if (context instanceof RelDiagram) {
			return defaultName(context, RelDiagram.class, "NewRelation");
		}
		else if (context instanceof TxTypedModelNode) {
			return defaultName(context, TxTypedModelNode.class, "NewTypedModel");
		}
		return "«umlxDefaultName»";
	}

	public EObject umlxEdgeContext(EObject context) {
		if (context instanceof RelInvocationNode) {
			return context;
		}
		else if (context instanceof RelPatternNode) {
			return ((RelPatternNode)context).getOwningRelDomainNode();
		}
		return context;
	}

	/**
	 * Return the label at the target end of an InvocationEdge.
	 */
	public @NonNull String umlxInvocationEdgeEndLabel(EObject context) {
		if (context instanceof RelInvocationEdge) {
			RelPatternNode relPatternNode = ((RelInvocationEdge)context).getReferredRelPatternNode();
			if (relPatternNode != null) {
				return String.valueOf(relPatternNode.getName());
			}
		}
		return "";
	}

	/**
	 * Return true if this part of a UMLX:then (QVTr:where) clause
	 */
	public boolean umlxInvocationIsThen(EObject context) {
		if (context instanceof RelInvocationNode) {
			return ((RelInvocationNode)context).isIsThen();
		}
		if (context instanceof RelInvocationEdge) {
			RelInvocationNode owningSource = ((RelInvocationEdge)context).getOwningRelInvocationNode();
			return (owningSource != null) && owningSource.isIsThen();
		}
		return false;
	}

	/**
	 * Return the label at the source end of a PatternEdge.
	 */
	public @NonNull String umlxPatternEdgeBeginLabel(EObject context) {
		if (context instanceof RelPatternEdge) {
			EStructuralFeature eStructuralFeature = ((RelPatternEdge)context).getReferredEStructuralFeature();
			if (eStructuralFeature instanceof EReference) {
				EReference eReference = (EReference)eStructuralFeature;
				StringBuilder s = new StringBuilder();
				s.append(getEOppositeName(eReference));
				s.append(" ");
				appendMultiplicity(s, getEOppositeLower(eReference), getEOppositeUpper(eReference));
				return s.toString();
			}
		}
		return "";
	}

	/**
	 * Return the label at the source end of a PatternEdge.
	 */
	public @NonNull String umlxPatternEdgeCenterLabel(EObject context) {
		if (context instanceof RelPatternEdge) {
			int sourceIndex = ((RelPatternEdge)context).getSourceIndex();
			if (sourceIndex > 0) {
				return "«" + sourceIndex + "»";
			}
			else if (sourceIndex < 0) {
				return "«rest»";
			}
		}
		return "";
	}

	/**
	 * Return the label at the target end of a PatternEdge.
	 */
	public @NonNull String umlxPatternEdgeEndLabel(EObject context) {
		if (context instanceof RelPatternEdge) {
			EStructuralFeature eStructuralFeature = ((RelPatternEdge)context).getReferredEStructuralFeature();
			if (eStructuralFeature != null) {
				StringBuilder s = new StringBuilder();
				s.append(String.valueOf(eStructuralFeature.getName()));
				s.append(" ");
				appendMultiplicity(s, eStructuralFeature.getLowerBound(), eStructuralFeature.getUpperBound());
				return s.toString();
			}
		}
		return "";
	}

	/**
	 * Return true if the PatternEdge source is the target's container.
	 */
	public boolean umlxPatternEdgeSourceIsContainer(EObject context) {
		if (context instanceof RelPatternEdge) {
			EStructuralFeature eStructuralFeature = ((RelPatternEdge)context).getReferredEStructuralFeature();
			if (eStructuralFeature instanceof EReference) {
				EReference eOpposite = ((EReference)eStructuralFeature).getEOpposite();
				return (eOpposite != null) && eOpposite.isContainer();
			}
		}
		return false;
	}

	/**
	 * Return true if a PatternEdge target is the source's container.
	 */
	public boolean umlxPatternEdgeTargetIsContainer(EObject context) {
		if (context instanceof RelPatternEdge) {
			EStructuralFeature eStructuralFeature = ((RelPatternEdge)context).getReferredEStructuralFeature();
			if (eStructuralFeature instanceof EReference) {
				return ((EReference)eStructuralFeature).isContainer();
			}
		}
		return false;
	}

	/**
	 * Return true if a PatternEdge target is a datatype.
	 */
	public boolean umlxPatternEdgeTargetIsDataType(EObject context) {
		if (context instanceof RelPatternEdge) {
			EStructuralFeature eStructuralFeature = ((RelPatternEdge)context).getReferredEStructuralFeature();
			if (eStructuralFeature instanceof EAttribute) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return true if a PatternEdge target is a member of the source.
	 */
	public boolean umlxPatternEdgeTargetIsMember(EObject context) {
		if (context instanceof RelPatternEdge) {
			return ((RelPatternEdge)context).getSourceIndex() > 0;
		}
		return false;
	}

	/**
	 * Return true if a PatternEdge target is the rest of the source.
	 */
	public boolean umlxPatternEdgeTargetIsRest(EObject context) {
		if (context instanceof RelPatternEdge) {
			return ((RelPatternEdge)context).getSourceIndex() < 0;
		}
		return false;
	}

	/*	public @NonNull EObject umlxRelDiagramRootExpression(EObject context) {
		if (context instanceof RelDiagram) {
			//			return "new " + ((TxDiagram)context).getName() + " TxDiagram";
		}
		return context;
	} */

	/*	public @NonNull Collection<EObject> umlxRelDiagramSelectExpression(EObject context) {
		if (context instanceof RelDiagram) {
			@SuppressWarnings("unchecked")
			RelDiagram relDiagram = (RelDiagram)context;
			List<EObject> result = new ArrayList<>();
			result.addAll(relDiagram.getOwnedRelDomainNodes());
			result.addAll(relDiagram.getOwnedRelInvocationNodes());
			return result;
		}
		return Collections.emptyList();
	} */

	public @NonNull String umlxRelDiagramTitleExpression(EObject context) {
		if (context instanceof RelDiagram) {
			return "UMLX Relation " + ((RelDiagram)context).getName();
		}
		return "new UMLX Relation Diagram";
	}

	public @NonNull Collection<EObject> umlxRelDiagramSemanticsCandidatesExpression(EObject context) {
		List<EObject> candidates = new ArrayList<>();
		if (context instanceof RelDiagram) {
			RelDiagram relDiagram = (RelDiagram)context;
			candidates.addAll(relDiagram.getOwnedRelDomainNodes());
			candidates.addAll(relDiagram.getOwnedRelInvocationNodes());
		}
		else {
			candidates.add(context);
		}
		return candidates;
	}

	/**
	 * Return the label of a KeyNode.
	 */
	public @NonNull String umlxRelLabel(EObject context) {
		if (context instanceof RelDiagram) {
			RelDiagram relDiagram = (RelDiagram)context;
			StringBuilder s = new StringBuilder();
			if (relDiagram.isIsTop()) {
				s.append("«top» ");
			}
			if (relDiagram.isIsAbstract()) {
				s.append("«abstract» ");
			}
			s.append(String.valueOf(relDiagram.getName()));
			return s.toString();
		}
		else if (context instanceof RelDomainNode) {
			TxTypedModelNode txTypedModelNode = ((RelDomainNode)context).getReferredTxTypedModelNode();
			if (txTypedModelNode != null) {
				if (((RelDomainNode)context).isIsEnforced()) {
					return "«enforce» " + String.valueOf(txTypedModelNode.getName());
				}
				else {
					return String.valueOf(txTypedModelNode.getName());
				}
			}
			else {
				return "«primitive»";
			}
		}
		else if (context instanceof RelInvocationNode) {
			RelDiagram relDiagram = ((RelInvocationNode)context).getReferredRelDiagram();
			if (relDiagram != null) {
				return String.valueOf(relDiagram.getName());
			}
			else {
				return "«null-referredDiagram»";
			}
		}
		else if ((context instanceof RelPatternNode) && !((RelPatternNode)context).isExpression()) {
			StringBuilder s = new StringBuilder();
			RelPatternNode relPatternClassNode = (RelPatternNode)context;
			s.append(String.valueOf(relPatternClassNode.getName()));
			//			appendTypedElement(s, relPatternClassNode, "\n");
			List<String> initExpressionLines = relPatternClassNode.getInitExpressionLines();
			if (initExpressionLines.size() > 0) {
				s.append(" :=");
				for (String line : initExpressionLines) {
					s.append("\n");
					s.append(line);
				}
			}
			return s.toString();
		}
		else if ((context instanceof RelPatternNode) && ((RelPatternNode)context).isExpression()) {
			StringBuilder s = new StringBuilder();
			boolean firstLine = true;
			for (String line : ((RelPatternNode)context).getInitExpressionLines()) {
				if (!firstLine) {
					s.append("\n");
				}
				s.append(line);
				firstLine = false;
			}
			return s.toString();
		}
		return "«umlxRelLabel - " + context.getClass().getName() + " - " + context.eClass().getName() + "»";
	}

	/**
	 * Return true if this is an expression pattern node
	 */
	public boolean umlxRelPatternNodeIsExpression(EObject context) {
		return (context instanceof RelPatternNode) && ((RelPatternNode)context).isExpression();
	}

	/**
	 * Return true if this is not a required pattern node
	 */
	public boolean umlxRelPatternNodeIsOptional(EObject context) {
		if ((context instanceof RelPatternNode) && !((RelPatternNode)context).isExpression()) {
			return !((RelPatternNode)context).isIsRequired();
		}
		return false;
	}

	/**
	 * Return true if this is a root of a pattern
	 */
	public boolean umlxRelPatternNodeIsRoot(EObject context) {
		if (context instanceof RelPatternNode) {
			return ((RelPatternNode)context).isIsRoot();
		}
		return false;
	}

	public EObject umlxSelfExpression(EObject context) {
		return context;
	}

	public int umlxSize(EObject context) {
		return 9;
	}

	public int umlxWidth(EObject context) {
		return 7;
	}

	public @NonNull String umlxTooltipExpression(EObject context) {
		return "Tooltip for " + context.eClass().getName();
	}

	/*	public @NonNull EObject umlxTxDiagramRootExpression(EObject context) {
		if (context instanceof TxDiagram) {
			//			return "new " + ((TxDiagram)context).getName() + " TxDiagram";
		}
		return context;
	} */

	public @NonNull String umlxTxDiagramTitleExpression(EObject context) {
		if (context instanceof TxDiagram) {
			return "UMLX Transformation " + ((TxDiagram)context).getName();
		}
		return "new UMLX Transformation Diagram";
	}

	/**
	 * Return the label of a KeyNode.
	 */
	public @NonNull String umlxTxLabel(EObject context) {
		if (context instanceof RelDiagram) {
			RelDiagram relDiagram = (RelDiagram)context;
			if (((RelDiagram)context).isIsTop()) {
				return "«top»\n" + String.valueOf(relDiagram.getName());
			}
			else {
				return String.valueOf(relDiagram.getName());
			}
		}
		else if (context instanceof TxKeyNode) {
			EClassifier eClassifier = ((TxKeyNode)context).getReferredEClass();
			if (eClassifier != null) {
				return String.valueOf(eClassifier.getName());
			}
			else {
				return "«null-referredClass»";
			}
		}
		else if (context instanceof TxPackageNode) {
			EPackage ePackage = ((TxPackageNode)context).getReferredEPackage();
			StringBuilder s = new StringBuilder();
			s.append(ePackage.getName());
			s.append(" : ");
			s.append(ePackage.getNsURI());
			s.append("\n");
			@NonNull
			URI uri = EcoreUtil.getURI(ePackage);
			uri = uri.deresolve(context.eResource().getURI());
			s.append(uri);
			return s.toString();
		}
		else if (context instanceof TxPartNode) {
			EStructuralFeature eStructuralFeature = ((TxPartNode)context).getReferredEStructuralFeature();
			if (eStructuralFeature != null) {
				return String.valueOf(eStructuralFeature.getName());
			}
			else {
				return "«null-referredProperty»";
			}
		}
		else if (context instanceof TxTypedModelNode) {
			return String.valueOf(((TxTypedModelNode)context).getName());
		}
		else if (context instanceof UMLXTypedElement) {
			StringBuilder s = new StringBuilder();
			appendTypedElement(s, (UMLXTypedElement)context, " : ");
			return s.toString();
		}
		return "«umlxTxLabel - " + context.getClass().getName() + " - " + context.eClass().getName() + "»";
	}

	public @NonNull Collection<@NonNull EObject> umlxTxTransformationNodeCandidates(EObject context) {
		List<@NonNull EObject> candidates = new ArrayList<@NonNull EObject>();
		if (context instanceof TxDiagram) {
			candidates.addAll(ClassUtil.nullFree(((TxDiagram)context).getOwnedTxKeyNodes()));
			candidates.addAll(ClassUtil.nullFree(((TxDiagram)context).getOwnedTxTypedModelNodes()));
		}
		return candidates;
	}

	/**
	 * Return the label of a KeyNode.
	 */
	public @NonNull String umlxTypeLabel(EObject context) {
		if (context instanceof UMLXTypedElement) {
			StringBuilder s = new StringBuilder();
			appendType(s, (UMLXTypedElement) context);
			return s.toString();
		}
		return "«umlxTypeLabel - " + context.getClass().getName() + " - " + context.eClass().getName() + "»";
	}
}
