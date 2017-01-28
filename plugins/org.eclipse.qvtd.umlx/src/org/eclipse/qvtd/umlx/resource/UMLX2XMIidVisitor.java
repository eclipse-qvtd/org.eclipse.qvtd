/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.umlx.resource;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelInvocationEdge;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.RelPatternClassNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternExpressionNode;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxImportNode;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.TxParameterNode;
import org.eclipse.qvtd.umlx.TxPartNode;
import org.eclipse.qvtd.umlx.TxQueryNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXElement;
import org.eclipse.qvtd.umlx.UMLXModel;
import org.eclipse.qvtd.umlx.UMLXNamedElement;
import org.eclipse.qvtd.umlx.util.AbstractExtendingUMLXVisitor;
import org.eclipse.qvtd.umlx.utilities.UMLXUtil;

/**
 * The UMLX2XMIidVisitor generates an xmi:id for a UMLX element. Using one of three policies.
 * <p>
 * null - no xmi:id generated - saves space
 * <p>
 * false - xmi:id generated/reuses UUID - UUID only used internally so no need for predictability
 * <p>
 * true - xmi:id generated/reuses friendly name - ID may be independently generated - must be predictable
 * <p>
 * Simple elements such as Package/Type/Property get a dot-separated hierarchical name.
 * <p>
 * Operations get a dot-separated hierarchical name suffixed by dot-dot-separated argument types.
 * <p>
 * Internally referenceable elements such as TemplateSignature get a UUID, reusing any xmi:id provided
 * in the context Moniker to XMIId Map.
 * ----
 * Since just about everything may be referenced from a *.aird file, everything needs an xmi:id, but we do not
 * want ridiculously long xmi:ids just in case there is a similar usage, therefore regenerated xmi:ids for a
 * chnaged may occasionally differ in the regions of near duplication.
 *
 */
public class UMLX2XMIidVisitor extends AbstractExtendingUMLXVisitor<Boolean, UMLX2XMIid>
{
	public static final int OVERFLOW_LIMIT = 1024;
	public static final @NonNull String OVERFLOW_MARKER = "##"; //$NON-NLS-1$

	public static final @NonNull String NULL_MARKER = "-null-element-"; //$NON-NLS-1$

	public static final @NonNull String DISAMBIGUATION_SEPARATOR = "~"; //$NON-NLS-1$
	public static final @NonNull String FIELD_SEPARATOR = ".."; //$NON-NLS-1$ */
	public static final @NonNull String FRAGMENT_SEPARATOR = "#"; //$NON-NLS-1$
	public static final @NonNull String OPPOSITE_SEPARATOR = "~"; //$NON-NLS-1$
	public static final @NonNull String SCOPE_SEPARATOR = "."; //$NON-NLS-1$

	public static final @NonNull String REL_DIAGRAM_PREFIX = "R."; //$NON-NLS-1$
	public static final @NonNull String REL_DOMAIN_PREFIX = "D."; //$NON-NLS-1$
	public static final @NonNull String REL_INVOCATION_PREFIX = "V."; //$NON-NLS-1$
	public static final @NonNull String REL_INVOCATION_EDGE_PREFIX = "A."; //$NON-NLS-1$
	public static final @NonNull String REL_PATTERN_CLASS_PREFIX = "C."; //$NON-NLS-1$
	public static final @NonNull String REL_PATTERN_EDGE_PREFIX = "E."; //$NON-NLS-1$
	public static final @NonNull String REL_PATTERN_EXPRESSION_PREFIX = "X."; //$NON-NLS-1$
	public static final @NonNull String TX_DIAGRAM_PREFIX = "T."; //$NON-NLS-1$
	public static final @NonNull String TX_IMPORT_PREFIX = "I."; //$NON-NLS-1$
	public static final @NonNull String TX_KEY_PREFIX = "K."; //$NON-NLS-1$
	public static final @NonNull String TX_KEY_PART_PREFIX = "Kp."; //$NON-NLS-1$
	public static final @NonNull String TX_MODEL_PARAMETER_PREFIX = "Tp."; //$NON-NLS-1$
	public static final @NonNull String TX_QUERY_PREFIX = "Q."; //$NON-NLS-1$
	public static final @NonNull String TX_QUERY_PARAMETER_PREFIX = "Qp."; //$NON-NLS-1$
	public static final @NonNull String TX_USED_PACKAGE_PREFIX = "U."; //$NON-NLS-1$

	/*	public static final @NonNull String ACCUMULATOR_PREFIX = "a"; //$NON-NLS-1$
	public static final @NonNull String BODYCONDITION_PREFIX = "c="; //$NON-NLS-1$
	public static final @NonNull String ENUMERATION_LITERAL_PREFIX = "e."; //$NON-NLS-1$
	public static final @NonNull String INVARIANT_PREFIX = "ci"; //$NON-NLS-1$
	public static final @NonNull String ITERATION_PREFIX = "i."; //$NON-NLS-1$
	public static final @NonNull String ITERATOR_PREFIX = "i"; //$NON-NLS-1$
	public static final @NonNull String OPERATION_PREFIX = "o."; //$NON-NLS-1$
	public static final @NonNull String OPPOSITE_PROPERTY_PREFIX = "op."; //$NON-NLS-1$
	public static final @NonNull String PARAMETER_PREFIX = "p"; //$NON-NLS-1$
	public static final @NonNull String PACKAGE_PREFIX = "P."; //$NON-NLS-1$
	public static final @NonNull String POSTCONDITION_PREFIX = "c+"; //$NON-NLS-1$
	public static final @NonNull String PRECONDITION_PREFIX = "c-"; //$NON-NLS-1$
	public static final @NonNull String PRECEDENCE_PREFIX = "Z."; //$NON-NLS-1$
	public static final @NonNull String PROPERTY_PREFIX = "p."; //$NON-NLS-1$
	public static final @NonNull String TEMPLATE_PARAMETER_PREFIX = "t."; //$NON-NLS-1$
	public static final @NonNull String TEMPLATE_SIGNATURE_PREFIX = "s."; //$NON-NLS-1$
	public static final @NonNull String TYPE_PREFIX = "T."; //$NON-NLS-1$

	public static final @NonNull String OPERATION_PARAMETER_SEPARATOR = ".."; //$NON-NLS-1$
	public static final @NonNull String TEMPLATE_PARAMETER_SEPARATOR = ".."; //$NON-NLS-1$ */

	protected final @NonNull StringBuilder s = new StringBuilder();

	public UMLX2XMIidVisitor(@NonNull UMLX2XMIid context) {
		super(context);
	}

	protected static void appendEPackage(@NonNull StringBuilder s, @NonNull EPackage ePackage) {
		EPackage eSuperPackage = ePackage.getESuperPackage();
		if (eSuperPackage != null) {
			appendEPackage(s, eSuperPackage);
			s.append(SCOPE_SEPARATOR);
		}
		appendName(s, ePackage.getName());
	}

	protected static void appendName(@NonNull StringBuilder s, @Nullable String name) {
		if (name == null) {
			s.append(NULL_MARKER);
		}
		else {
			for (int i = 0; i < name.length(); i++) {
				char c = name.charAt(i);
				if (('0' <= c) && (c <= '9')) {
					s.append(c);
				}
				else if (('A' <= c) && (c <= 'Z')) {
					s.append(c);
				}
				else if (('a' <= c) && (c <= 'z')) {
					s.append(c);
				}
				else if (c == '_') {
					s.append(c);
				}
				else if (c == '$') {
					s.append(c);
				}
				else if (c == '%') {
					s.append("%%");
				}
				else {
					s.append("%");
					s.append((int)c);
					s.append("%");
				}
			}
		}
	}

	protected static void appendNameOf(@NonNull StringBuilder s, @NonNull Object element) {
		if (element instanceof UMLXNamedElement) {
			s.append(((UMLXNamedElement)element).getName());
		}
		else if (element instanceof TxKeyNode) {
			EClass eClass = ((TxKeyNode)element).getReferredEClass();
			if (eClass != null) {
				EPackage ePackage = eClass.getEPackage();
				if (ePackage != null) {
					appendEPackage(s, ePackage);
					s.append(SCOPE_SEPARATOR);
				}
				appendName(s, eClass.getName());
			}
		}
		else if (element instanceof RelDomainNode) {
			TxTypedModelNode txTypedModelNode = ((RelDomainNode)element).getReferredTxTypedModelNode();
			String name = txTypedModelNode != null ? txTypedModelNode.getName() : "";
			if (name != null) {
				appendName(s, name);
			}
		}
		else if (element instanceof RelInvocationNode) {
			RelInvocationNode relInvocationNode = (RelInvocationNode)element;
			RelDiagram owningRelDiagram = UMLXUtil.getOwningRelDiagram(relInvocationNode);
			RelDiagram referredRelDiagram = relInvocationNode.getReferredRelDiagram();
			int duplicates = 0;
			for (@NonNull RelInvocationNode anInvocationNode : UMLXUtil.getOwnedRelInvocationNodes(owningRelDiagram)) {
				if (anInvocationNode.getReferredRelDiagram() == referredRelDiagram) {
					duplicates++;
				}
			}
			appendName(s, referredRelDiagram.getName());
			if (duplicates > 1) {
				s.append(DISAMBIGUATION_SEPARATOR);
				StringBuilder s2 = new StringBuilder();
				boolean needHash = false;
				List<@NonNull RelInvocationEdge> sortedInvocationEdges = UMLXUtil.getSortedInvocationEdges(relInvocationNode);
				for (@NonNull RelInvocationEdge relInvocationEdge : sortedInvocationEdges) {
					if (s2.length() > 0) {
						s2.append(SCOPE_SEPARATOR);
					}
					RelPatternNode invokingRelPatternNode = UMLXUtil.getInvokingRelPatternNode(relInvocationEdge);
					if (!(invokingRelPatternNode instanceof RelPatternClassNode)) {
						needHash = true;
					}
					appendNameOf(s2, invokingRelPatternNode);
				}
				String argsString = s2.toString();
				if (needHash) {
					s.append(Integer.toString(argsString.hashCode()));
				}
				else {
					s.append(argsString);
					s.append(DISAMBIGUATION_SEPARATOR);
				}
			}
		}
		else if (element instanceof RelPatternExpressionNode) {
			RelPatternExpressionNode relPatternExpressionNode = (RelPatternExpressionNode)element;
			List<@NonNull RelPatternEdge> incoming = UMLXUtil.Internal.getIncomingList(relPatternExpressionNode);
			if (incoming.size() == 1) {
				appendNameOf(s, UMLXUtil.getSource(incoming.get(0)));
			}
			else {
				List<String> initExpressionLines = relPatternExpressionNode.getInitExpressionLines();
				int hash = initExpressionLines.hashCode();
				s.append(Integer.toString(hash));
			}
		}
		else {
			s.append(System.identityHashCode(element));
		}
	}

	protected void appendParent(@Nullable EObject element) {
		appendParent(element, SCOPE_SEPARATOR);
	}

	protected void appendParent(@Nullable EObject element, @Nullable String suffixSeparator) {
		if (toString().length() >= OVERFLOW_LIMIT) {
			s.append(OVERFLOW_MARKER);
		}
		else if (element == null) {
			s.append(NULL_MARKER);
			if (suffixSeparator != null) {
				s.append(suffixSeparator);
			}
		}
		else {
			EObject eContainer = element.eContainer();
			if (eContainer instanceof UMLXModel) {
			}
			else if (eContainer != null) {
				//				if (!(eContainer instanceof TemplateParameter)) {
				appendParent(eContainer);
				//				}
				appendNameOf(s, eContainer);
				if (suffixSeparator != null) {
					s.append(suffixSeparator);
				}
			}
		}
	}

	public @Nullable String getID(@NonNull UMLXElement element, boolean internalUUIDs) {
		Boolean status = element.accept(this);
		if (status == null) {
			return null;
		}
		else if (status) {
			return s.toString();
		}
		else {
			return null; // FIXME context.getID(element, internalUUIDs);
		}
	}

	@Override
	public String toString() {
		return s.toString();
	}

	@Override
	public @Nullable Boolean visiting(@NonNull UMLXElement visitable) {
		System.out.println("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
		return null;
		//		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
	}

	@Override
	public Boolean visitRelDiagram(@NonNull RelDiagram object) {
		s.append(REL_DIAGRAM_PREFIX);
		appendParent(object);
		appendNameOf(s, object);
		return true;
	}

	@Override
	public Boolean visitRelDomainNode(@NonNull RelDomainNode object) {
		s.append(REL_DOMAIN_PREFIX);
		appendParent(object);
		appendNameOf(s, object);
		return true;
	}

	@Override
	public Boolean visitRelInvocationEdge(@NonNull RelInvocationEdge object) {
		s.append(REL_INVOCATION_EDGE_PREFIX);
		appendParent(object);
		appendName(s, object.getReferredRelPatternNode().getName());
		return true;
	}

	@Override
	public Boolean visitRelInvocationNode(@NonNull RelInvocationNode object) {
		s.append(REL_INVOCATION_PREFIX);
		appendParent(object);
		appendNameOf(s, object);
		return true;
	}

	@Override
	public Boolean visitRelPatternClassNode(@NonNull RelPatternClassNode object) {
		s.append(REL_PATTERN_CLASS_PREFIX);
		appendParent(object);
		appendNameOf(s, object);
		return true;
	}

	@Override
	public Boolean visitRelPatternEdge(@NonNull RelPatternEdge object) {
		s.append(REL_PATTERN_EDGE_PREFIX);
		appendParent(object, FIELD_SEPARATOR);
		RelPatternClassNode source = object.getSource();
		if (source != null) {
			appendNameOf(s, source);
		}
		s.append(FIELD_SEPARATOR);
		RelPatternNode target = object.getTarget();
		if (target != null) {
			appendNameOf(s, target);
		}
		return true;
	}

	@Override
	public Boolean visitRelPatternExpressionNode(@NonNull RelPatternExpressionNode object) {
		s.append(REL_PATTERN_EXPRESSION_PREFIX);
		appendParent(object);
		appendNameOf(s, object);
		return true;
	}

	@Override
	public Boolean visitTxDiagram(@NonNull TxDiagram object) {
		s.append(TX_DIAGRAM_PREFIX);
		appendParent(object);
		appendNameOf(s, object);
		return true;
	}

	@Override
	public Boolean visitTxImportNode(@NonNull TxImportNode object) {
		s.append(TX_IMPORT_PREFIX);
		appendParent(object);
		appendNameOf(s, object);
		return true;
	}

	@Override
	public Boolean visitTxKeyNode(@NonNull TxKeyNode object) {
		s.append(TX_KEY_PREFIX);
		appendParent(object);
		appendNameOf(s, object);
		return true;
	}

	@Override
	public Boolean visitTxPackageNode(@NonNull TxPackageNode object) {
		String name = object.getReferredEPackage().getName();
		if (name != null) {
			s.append(TX_USED_PACKAGE_PREFIX);
			appendParent(object);
			appendName(s, name);
			return true;
		}
		return true;
	}

	@Override
	public Boolean visitTxParameterNode(@NonNull TxParameterNode object) {
		s.append(TX_QUERY_PARAMETER_PREFIX);
		appendParent(object);
		appendNameOf(s, object);
		return true;
	}

	@Override
	public Boolean visitTxPartNode(@NonNull TxPartNode object) {
		String name = object.getReferredEStructuralFeature().getName();
		if (name != null) {
			s.append(TX_KEY_PART_PREFIX);
			appendParent(object);
			if (object.isIsOpposite()) {
				s.append(OPPOSITE_SEPARATOR);
			}
			appendName(s, name);
			return true;
		}
		return true;
	}

	@Override
	public Boolean visitTxQueryNode(@NonNull TxQueryNode object) {
		s.append(TX_QUERY_PREFIX);
		appendParent(object);
		appendNameOf(s, object);
		for (TxParameterNode txParameterNode : object.getOwnedTxParameterNodes()) {
			s.append(FIELD_SEPARATOR);
			if (txParameterNode != null) {
				appendNameOf(s, txParameterNode);
			}
		}
		return true;
	}

	@Override
	public Boolean visitTxTypedModelNode(@NonNull TxTypedModelNode object) {
		String name = object.getName();
		if (name != null) {
			s.append(TX_MODEL_PARAMETER_PREFIX);
			appendParent(object);
			appendName(s, name);
			return true;
		}
		return true;
	}

	@Override
	public Boolean visitUMLXModel(@NonNull UMLXModel object) {
		return null;
	}
}
