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
package org.eclipse.qvtd.umlx.design;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelInvocationEdge;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxPartNode;
import org.eclipse.qvtd.umlx.TxTransformationNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXNode;

/**
 * Class owning methods used for service: umlx. The service methods
 * should be prefixed by umlx to avoid conflict with other services.
 */
public class UMLXServices
{
	public UMLXServices() {}

	protected void appendMultiplicity(@NonNull StringBuilder s, @NonNull ETypedElement eTypedElement) {
		if (!eTypedElement.isMany()) {
			s.append(eTypedElement.isRequired() ? "[1]" : "[?]");
		}
		else {
			int lower = eTypedElement.getLowerBound();
			int upper = eTypedElement.getUpperBound();
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

	/**
	 * Return the label of a DomainNode.
	 */
	public @NonNull String umlxDomainNodeLabel(EObject context) {
		if (context instanceof RelDomainNode) {
			TxTypedModelNode txTypedModelNode = ((RelDomainNode)context).getReferredTypedModelNode();
			if (txTypedModelNode != null) {
				return String.valueOf(txTypedModelNode.getName());
			}
		}
		return "«unknown»";
	}

	/**
	 * Return the label of an InvocationNode.
	 */
	public @NonNull String umlxInvocationNodeLabel(EObject context) {
		if (context instanceof RelInvocationNode) {
			RelDiagram relDiagram = ((RelInvocationNode)context).getReferredRelationNode();
			if (relDiagram != null) {
				return String.valueOf(relDiagram.getName());
			}
		}
		return "«unknown»";
	}


	/**
	 * Return true if this part of a UMLX:then (QVTr:where) clause
	 */
	public boolean umlxInvocationIsThen(EObject context) {
		if (context instanceof RelInvocationNode) {
			return ((RelInvocationNode)context).isIsThen();
		}
		if (context instanceof RelInvocationEdge) {
			UMLXNode owningSource = ((RelInvocationEdge)context).getOwningSource();
			return ((RelInvocationNode)owningSource).isIsThen();
		}
		return false;
	}
	/**
	 * Return the label of a KeyNode.
	 */
	public @NonNull String umlxKeyNodeLabel(EObject context) {
		if (context instanceof TxKeyNode) {
			EClassifier eClassifier = ((TxKeyNode)context).getReferredClass();
			if (eClassifier != null) {
				return String.valueOf(eClassifier.getName());
			}
		}
		return "«unknown»";
	}

	/**
	 * Return the label of a PartNode.
	 */
	public @NonNull String umlxPartNodeLabel(EObject context) {
		if (context instanceof TxPartNode) {
			EStructuralFeature eStructuralFeature = ((TxPartNode)context).getReferredProperty();
			if (eStructuralFeature != null) {
				return String.valueOf(eStructuralFeature.getName());
			}
		}
		return "«unknown»";
	}

	/**
	 * Return the label at the source end of a PatternEdge.
	 */
	public @NonNull String umlxPatternEdgeBeginLabel(EObject context) {
		if (context instanceof RelPatternEdge) {
			EStructuralFeature eStructuralFeature = ((RelPatternEdge)context).getReferredProperty();
			if (eStructuralFeature instanceof EReference) {
				EReference eOpposite = ((EReference)eStructuralFeature).getEOpposite();
				if (eOpposite == null) {
					return "«inferred»";
				}
				StringBuilder s = new StringBuilder();
				s.append(String.valueOf(eOpposite.getName()));
				s.append("\n");
				appendMultiplicity(s, eOpposite);
				return s.toString();
			}
		}
		return "«unknown»";
	}

	/**
	 * Return the label at the target end of a PatternEdge.
	 */
	public @NonNull String umlxPatternEdgeEndLabel(EObject context) {
		if (context instanceof RelPatternEdge) {
			EStructuralFeature eStructuralFeature = ((RelPatternEdge)context).getReferredProperty();
			if (eStructuralFeature != null) {
				StringBuilder s = new StringBuilder();
				s.append(String.valueOf(eStructuralFeature.getName()));
				s.append("\n");
				appendMultiplicity(s, eStructuralFeature);
				return s.toString();
			}
		}
		return "«unknown»";
	}

	/**
	 * Return true if a PatternEdge is a composite.
	 */
	public boolean umlxPatternEdgeIsComposite(EObject context) {
		if (context instanceof RelPatternEdge) {
			EStructuralFeature eStructuralFeature = ((RelPatternEdge)context).getReferredProperty();
			if (eStructuralFeature instanceof EReference) {
				return ((EReference)eStructuralFeature).isContainer();
			}
		}
		return false;
	}

	/**
	 * Return true if a PatternEdge is not-a composite.
	 */
	public boolean umlxPatternEdgeIsNotComposite(EObject context) {
		if (context instanceof RelPatternEdge) {
			EStructuralFeature eStructuralFeature = ((RelPatternEdge)context).getReferredProperty();
			if (eStructuralFeature instanceof EReference) {
				return !((EReference)eStructuralFeature).isContainer();
			}
		}
		return false;
	}

	/**
	 * Return the label of a PatternNode.
	 */
	public @NonNull String umlxPatternNodeLabel(EObject context) {
		if (context instanceof RelPatternNode) {
			StringBuilder s = new StringBuilder();
			s.append(String.valueOf(((RelPatternNode)context).getName()));
			s.append("\n");
			EClassifier eClassifier = ((RelPatternNode)context).getReferredClass();
			if (eClassifier != null) {
				s.append(eClassifier.eIsProxy() ? EcoreUtil.getURI(eClassifier) : String.valueOf(eClassifier.getName()));
			}
			return s.toString();
		}
		return "«unknown»";
	}

	public @NonNull EObject umlxRelDiagramRootExpression(EObject context) {
		if (context instanceof RelDiagram) {
			//			return "new " + ((TxDiagram)context).getName() + " TxDiagram";
		}
		return context;
	}

	public @NonNull Collection<EObject> umlxRelDiagramSelectExpression(EObject context) {
		if (context instanceof RelDiagram) {
			return (Collection<EObject>)(Object)((RelDiagram)context).getOwnedNodes();
		}
		return Collections.EMPTY_LIST;
	}

	public @NonNull String umlxRelDiagramTitleExpression(EObject context) {
		if (context instanceof RelDiagram) {
			return "UMLX Relation " + ((RelDiagram)context).getName();
		}
		return "new UMLX Relation Diagram";
	}

	public @NonNull Collection<EObject> umlxRelDiagramSemanticsCandidatesExpression(EObject context) {
		List<EObject> candidates = new ArrayList<>();
		if (context instanceof RelDiagram) {
			candidates.addAll(((RelDiagram)context).getOwnedNodes());
		}
		else {
			candidates.add(context);
		}
		return candidates;
	}

	public @NonNull String umlxTooltipExpression(EObject context) {
		return "Tooltip for " + context.eClass().getName();
	}

	public @NonNull EObject umlxTxDiagramRootExpression(EObject context) {
		if (context instanceof TxDiagram) {
			//			return "new " + ((TxDiagram)context).getName() + " TxDiagram";
		}
		return context;
	}

	public @NonNull String umlxTxDiagramTitleExpression(EObject context) {
		if (context instanceof TxDiagram) {
			return "UMLX Transformation " + ((TxDiagram)context).getName();
		}
		return "new UMLX Transformation Diagram";
	}

	public @NonNull Collection<@NonNull EObject> umlxTxTransformationNodeCandidates(EObject context) {
		List<@NonNull EObject> candidates = new ArrayList<@NonNull EObject>();
		if (context instanceof TxTransformationNode) {
			candidates.addAll(ClassUtil.nullFree(((TxTransformationNode)context).getTxKeyNodes()));
			candidates.addAll(ClassUtil.nullFree(((TxTransformationNode)context).getTxTypedModelNodes()));
		}
		else if (context instanceof TxDiagram) {
			candidates.addAll(ClassUtil.nullFree(((TxDiagram)context).getOwnedNodes()));
		}
		return candidates;
	}
}
