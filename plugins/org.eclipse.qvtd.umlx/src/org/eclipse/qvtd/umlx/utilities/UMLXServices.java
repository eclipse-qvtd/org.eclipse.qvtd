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
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelInvocationEdge;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.RelPatternClassNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxImportNode;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.TxPartNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;

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

	public int umlxBorderSize(EObject context) {
		return 4;
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
			return owningSource.isIsThen();
		}
		return false;
	}

	/**
	 * Return the label of a KeyNode.
	 */
	public @NonNull String umlxLabel(EObject context) {
		if (context instanceof RelDiagram) {
			RelDiagram relDiagram = (RelDiagram)context;
			if (((RelDiagram)context).isIsTop()) {
				return "«top»\n" + String.valueOf(relDiagram.getName());
			}
			else {
				return String.valueOf(relDiagram.getName());
			}
		}
		else if (context instanceof RelDomainNode) {
			TxTypedModelNode txTypedModelNode = ((RelDomainNode)context).getReferredTxTypedModelNode();
			if (txTypedModelNode != null) {
				return String.valueOf(txTypedModelNode.getName());
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
		}
		else if (context instanceof RelPatternClassNode) {
			StringBuilder s = new StringBuilder();
			s.append(String.valueOf(((RelPatternClassNode)context).getName()));
			s.append(" : ");
			EClassifier eClassifier = ((RelPatternClassNode)context).getReferredClass();
			if (eClassifier != null) {
				s.append(eClassifier.eIsProxy() ? EcoreUtil.getURI(eClassifier) : String.valueOf(eClassifier.getName()));
			}
			return s.toString();
		}
		else if (context instanceof TxImportNode) {
			return String.valueOf(((TxImportNode)context).getName());
		}
		else if (context instanceof TxKeyNode) {
			EClassifier eClassifier = ((TxKeyNode)context).getReferredClass();
			if (eClassifier != null) {
				return String.valueOf(eClassifier.getName());
			}
		}
		else if (context instanceof TxPackageNode) {
			return LabelUtil.QUALIFIED_NAME_REGISTRY.labelFor(((TxPackageNode)context).getReferredPackage());
		}
		else if (context instanceof TxPartNode) {
			EStructuralFeature eStructuralFeature = ((TxPartNode)context).getReferredProperty();
			if (eStructuralFeature != null) {
				return String.valueOf(eStructuralFeature.getName());
			}
		}
		else if (context instanceof TxTypedModelNode) {
			return String.valueOf(((TxTypedModelNode)context).getName());
		}
		return "«umlxLabel - " + context.getClass().getName() + " - " + context.eClass().getName() + "»";
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
				s.append(" ");
				appendMultiplicity(s, eOpposite);
				return s.toString();
			}
		}
		return "";
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
				s.append(" ");
				appendMultiplicity(s, eStructuralFeature);
				return s.toString();
			}
		}
		return "";
	}

	/**
	 * Return the label at the target end of an InvocationEdge.
	 */
	public @NonNull String umlxInvocationEdgeEndLabel(EObject context) {
		if (context instanceof RelInvocationEdge) {
			RelPatternClassNode relPatternNode = ((RelInvocationEdge)context).getReferredRelPatternNode();
			if (relPatternNode != null) {
				return String.valueOf(relPatternNode.getName());
			}
		}
		return "";
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
	 * Return true if this is not a required pattern node
	 */
	public boolean umlxRelPatternNodeIsOptional(EObject context) {
		if (context instanceof RelPatternClassNode) {
			return !((RelPatternClassNode)context).isIsRequired();
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

	public @NonNull Collection<@NonNull EObject> umlxTxTransformationNodeCandidates(EObject context) {
		List<@NonNull EObject> candidates = new ArrayList<@NonNull EObject>();
		if (context instanceof TxDiagram) {
			candidates.addAll(ClassUtil.nullFree(((TxDiagram)context).getOwnedTxKeyNodes()));
			candidates.addAll(ClassUtil.nullFree(((TxDiagram)context).getOwnedTxTypedModelNodes()));
		}
		return candidates;
	}
}
