package org.eclipse.qvtd.umlx.services;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;

/**
 * Class owning methods used for service: umlx. The service methods
 * should be prefixed by umlx to avoid conflict with other services.
 */
public class UMLXServices {

    /**
     * Default constructor.
     */
    public UMLXServices() {
    }

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
        return "<<unknown>>";
    }

    /**
     * Return the label of an InvocationNode.
     */
    public @NonNull String umlxInvocationNodeLabel(EObject context) {
    	if (context instanceof RelInvocationNode) {
    		return "";
    	}
        return "<<unknown>>";
    }

    /**
     * Return the label at the source end of a PatternEdge.
     */
    public @NonNull String umlxPatternEdgeBeginLabel(EObject context) {
    	if (context instanceof RelPatternEdge) {
    		EStructuralFeature eStructuralFeature = ((RelPatternEdge)context).getReferredProperty();
    		if (eStructuralFeature instanceof EReference) {
    			EReference eOpposite = ((EReference)eStructuralFeature).getEOpposite();
    			StringBuilder s = new StringBuilder();
    			s.append(String.valueOf(eOpposite.getName()));
    			s.append("\n");
    			appendMultiplicity(s, eOpposite);
    			return s.toString();
    		}
    	}
        return "<<unknown>>";
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
        return "<<unknown>>";
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
    	//aql:self.name + '\n' + self.referredClass.name
    	if (context instanceof RelPatternNode) {
			StringBuilder s = new StringBuilder();
			s.append(String.valueOf(((RelPatternNode)context).getName()));
			s.append("\n");
    		EClassifier eClassifier = ((RelPatternNode)context).getReferredClass();
    		if (eClassifier != null) {
    			s.append(String.valueOf(eClassifier.getName()));
    		}
			return s.toString();
    	}
        return "<<unknown>>";
    }
}
