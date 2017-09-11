/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.umlx.umlx2qvtr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.SharedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelInvocationEdge;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.utilities.UMLXUtil;

import com.google.common.collect.Iterables;

class PatternForest
{
	private class TreeEdge
	{
		private @NonNull RelPatternEdge patternEdge;
		private boolean isGraph;
		private boolean isOpposite;
		private @NonNull TreeClassNode parent;
		private @NonNull TreeNode child;

		public TreeEdge(boolean isGraph, @NonNull RelPatternEdge patternEdge, boolean isOpposite, @NonNull TreeClassNode parent, @NonNull TreeNode child) {
			this.isGraph = isGraph;
			this.patternEdge = patternEdge;
			this.isOpposite = isOpposite;
			this.parent = parent;
			this.child = child;
			parent.addChildEdge(this);
			TreeEdge oldEdge = patternEdge2treeEdge.put(patternEdge, this);
			assert oldEdge == null;
			if (isGraph) {
				child.addGraphEdge(this);
			}
			//			else {
			//				assert child.parentEdge == this; --not yet constructed
			//			}
			if (isOpposite) {
				toString();
			}
		}

		@Override
		public String toString() {
			return patternEdge.toString();
		}
	}

	private static abstract class TreeNode
	{
		protected @Nullable TreeEdge parentEdge = null;
		protected @Nullable List<@NonNull TreeEdge> graphEdges = null;
		//		protected boolean isInvoked = false;

		public void addGraphEdge(@NonNull TreeEdge graphEdge) {
			List<@NonNull TreeEdge> graphEdges2 = graphEdges;
			if (graphEdges2 == null) {
				graphEdges = graphEdges2 = new ArrayList<>();
			}
			assert !graphEdges2.contains(graphEdge);
			graphEdges2.add(graphEdge);
		}

		protected abstract void toString(@NonNull StringBuilder s, int depth);
	}

	private class TreeClassNode extends TreeNode
	{
		// Definition structure
		private @NonNull TreeRoot treeRoot;
		private @NonNull RelPatternNode patternNode;
		private @NonNull List<@NonNull TreeEdge> childEdges = new ArrayList<>();
		// Derived structure
		//			private boolean isShared = false;
		private Variable variable = null;
		protected boolean isRealized = false;

		public TreeClassNode(@NonNull TreeRoot treeRoot, @NonNull RelPatternNode rootPatternNode) {
			UMLXUtil.assertClassNode(rootPatternNode);
			this.treeRoot = treeRoot;
			this.patternNode = rootPatternNode;
			TreeNode oldNode = patternNode2treeNode.put(rootPatternNode, this);
			assert oldNode == null;
			allNodes.add(rootPatternNode);
			treeRoot.addNode(this);
		}

		public TreeClassNode(@NonNull RelPatternEdge patternEdge, boolean isOpposite, @NonNull TreeClassNode parentNode) {
			this.treeRoot = parentNode.treeRoot;
			this.patternNode = isOpposite ? UMLXUtil.getSource(patternEdge) : UMLXUtil.getTarget(patternEdge);
			UMLXUtil.assertClassNode(patternNode);
			this.parentEdge = new TreeEdge(false, patternEdge, isOpposite, parentNode, this);
			assert parentNode.patternNode == (isOpposite ? patternEdge.getTarget() : patternEdge.getSource());
			TreeNode oldNode = patternNode2treeNode.put(patternNode, this);
			assert oldNode == null;
			allNodes.add(patternNode);
		}

		public void addChildEdge(@NonNull TreeEdge childEdge) {
			assert !childEdges.contains(childEdge);
			childEdges.add(childEdge);
		}

		public @NonNull Variable getVariable() {
			Variable variable2 = variable;
			if (variable2 == null) {
				org.eclipse.ocl.pivot.Class asClass = umlx2qvtr.getReferredType(patternNode);
				TreeEdge parentEdge2 = parentEdge;
				boolean isRestVariable = isRestVariable(parentEdge2);
				boolean isGraphLeafVariable = isGraphLeafVariable();
				boolean isUnenforcedLeafVariable = isUnrealizedLeafVariable();
				if (isRestVariable || isGraphLeafVariable || isUnenforcedLeafVariable) {
					String name = patternNode.isIsAnon() ? null : UMLXUtil.getName(patternNode);
					variable2 = umlx2qvtr.createSharedVariable(name, asClass, patternNode.isIsRequired(), null);
					umlx2qvtr.install(patternNode, variable2);
				}
				else {
					variable2 = umlx2qvtr.createTemplateVariable(UMLXUtil.getName(patternNode), asClass, patternNode.isIsRequired(), null);
				}
				//					}
				allVariables.add(variable2);
				variable = variable2;
			}
			return variable2;
		}

		private boolean isGraphLeafVariable() {
			if (childEdges.isEmpty()) {
				List<@NonNull TreeEdge> graphEdges2 = graphEdges;
				if (graphEdges2 != null) {
					for (@NonNull TreeEdge graphEdge : graphEdges2) {
						if (graphEdge.parent.treeRoot != treeRoot) {
							return true;
						}
					}
				}
			}
			return false;
		}

		private boolean isRestVariable(TreeEdge parentEdge2) {
			return (parentEdge2 != null) && (parentEdge2.patternEdge.getSourceIndex() < 0);
		}

		private boolean isUnrealizedLeafVariable() {
			//			if (!isRealized) {
			//				return false;
			//			}
			if (parentEdge == null) {
				return false;
			}
			if (isRealized) {
				return false;
			}
			if (!childEdges.isEmpty()) {
				return false;
			}
			//			if (treeRoot.relDomainNode.getReferredTxTypedModelNode().isEnforce()) {
			//				return false;
			//			}
			//			if (isInvoked) {
			//				return true;
			//			}
			if ((graphEdges != null) && !graphEdges.isEmpty()) {
				return true;
			}
			return false;
		}

		public void setIsRealized() {
			if (!isRealized) {
				isRealized = true;
				for (@NonNull TreeEdge childEdge : childEdges) {
					EStructuralFeature eStructuralFeature = childEdge.patternEdge.getReferredEStructuralFeature();
					if ((eStructuralFeature == null) || ((eStructuralFeature instanceof EReference) && ((EReference)eStructuralFeature).isContainment())) {
						TreeNode childNode = childEdge.child;
						if (childNode instanceof TreeClassNode) {
							((TreeClassNode)childNode).setIsRealized();
						}
					}
				}
			}
		}

		@Override
		public String toString() {
			return patternNode.toString();
		}

		@Override
		protected void toString(@NonNull StringBuilder s, int depth) {
			s.append(patternNode);
			depth++;
			for (@NonNull TreeEdge treeEdge : childEdges) {
				s.append("\n");
				for (int i = 0; i < depth; i++) {
					s.append("  ");
				}
				EStructuralFeature eStructuralFeature = treeEdge.patternEdge.getReferredEStructuralFeature();
				if (eStructuralFeature != null) {
					s.append(eStructuralFeature.getName());
				}
				else {
					s.append(treeEdge.patternEdge);
				}
				if (treeEdge.isGraph) {
					s.append(" => ");
					s.append(treeEdge.child);
				}
				else if (treeEdge.child instanceof TreeExpressionNode) {
					s.append(" := ");
					s.append(treeEdge.child);
				}
				else {
					s.append(" = ");
					treeEdge.child.toString(s, depth);
				}
			}
		}
	}

	private class TreeExpressionNode extends TreeNode
	{
		private @NonNull RelPatternNode patternNode;

		public TreeExpressionNode(@NonNull RelPatternEdge patternEdge, @NonNull TreeClassNode parentNode) {
			this.patternNode = UMLXUtil.getTarget(patternEdge);
			UMLXUtil.assertExpressionNode(patternNode);
			this.parentEdge = new TreeEdge(false, patternEdge, false, parentNode, this);
			assert parentNode.patternNode == patternEdge.getSource();
			TreeNode oldNode = patternNode2treeNode.put(patternNode, this);
			assert oldNode == null;
		}

		@Override
		public String toString() {
			return patternNode.toString();
		}

		@Override
		protected void toString(@NonNull StringBuilder s, int depth) {
			s.append(patternNode);
		}
	}

	private class TreeRoot
	{
		protected final @NonNull RelDomainNode relDomainNode;
		private @NonNull List<@NonNull TreeClassNode> rootNodes = new ArrayList<>();

		public TreeRoot(@NonNull RelDomainNode relDomainNode) {
			this.relDomainNode = relDomainNode;
			treeRoots.add(this);
		}

		public void addNode(@NonNull TreeClassNode rootNode) {
			rootNodes.add(rootNode);
		}

		public @NonNull String getName() {
			TxTypedModelNode txTypedModelNode = relDomainNode.getReferredTxTypedModelNode();
			if (txTypedModelNode != null) {
				return UMLXUtil.getName(txTypedModelNode);
			}
			else {
				return "«primitive»";
			}
		}

		@Override
		public String toString() {
			return relDomainNode.toString();
		}
	}

	protected final @NonNull UMLX2QVTr umlx2qvtr;
	protected final @NonNull MetamodelManager metamodelManager;
	protected final @NonNull RelDiagram relDiagram;
	//
	private final @NonNull List<@NonNull RelPatternNode> allNodes = new ArrayList<>();
	private final @NonNull List<@NonNull TreeRoot> treeRoots =  new ArrayList<>();
	private final Map<@NonNull RelDomainNode, @NonNull TreeRoot> domainNode2treeRoot =  new HashMap<>();
	private final Map<@NonNull RelPatternNode, @NonNull TreeNode> patternNode2treeNode =  new HashMap<>();
	private final Map<@NonNull RelPatternEdge, @NonNull TreeEdge> patternEdge2treeEdge =  new HashMap<>();
	private final @NonNull Map<@NonNull RelPatternNode, @NonNull Element> relPatternNode2qvtrElement = new HashMap<>();
	private final @NonNull List<@NonNull RelationDomain> allDomains = new ArrayList<>();
	private final @NonNull List<@NonNull Variable> allVariables = new ArrayList<>();

	public PatternForest(@NonNull UMLX2QVTr umlx2qvtr, @NonNull RelDiagram relDiagram) {
		this.umlx2qvtr = umlx2qvtr;
		EnvironmentFactory environmentFactory = umlx2qvtr.getEnvironmentFactory();
		this.metamodelManager = environmentFactory.getMetamodelManager();
		this.relDiagram = relDiagram;
		analyzePatternRoots();
		analyzePatternTree();
		//		analyzeIsolatedNodes();
		analyzeRealizedEdges();	// FIXME not needed
		//		analyzeInvocationEdges(); // FIXME not needed
	}

	/*	private void analyzeInvocationEdges() {
		for (@NonNull RelInvocationNode relInvocationNode : UMLXUtil.getOwnedRelInvocationNodes(relDiagram)) {
			for (@NonNull RelInvocationEdge relInvocationEdge : UMLXUtil.getOwnedRelInvocationEdges(relInvocationNode)) {
				RelPatternNode invokingRelPatternNode = relInvocationEdge.getInvokingRelPatternNode();
				TreeNode treeNode = patternNode2treeNode.get(invokingRelPatternNode);
				assert treeNode != null;
				treeNode.isInvoked = true;
			}
		}
	} */

	private void analyzePatternRoots() {
		for (@NonNull RelDomainNode relDomainNode : UMLXUtil.getOwnedRelDomainNodes(relDiagram)) {
			TreeRoot treeRoot = new TreeRoot(relDomainNode);
			domainNode2treeRoot.put(relDomainNode, treeRoot);
			for (@NonNull RelPatternNode relPatternNode : UMLXUtil.getOwnedRelPatternNodes(relDomainNode)) {
				if (relPatternNode.isIsRoot() && !relPatternNode.isExpression()) {
					patternNode2treeNode.put(relPatternNode, new TreeClassNode(treeRoot, relPatternNode));
				}
			}
		}
	}

	private void analyzePatternTree() {
		int iSimple = 0;
		for (; iSimple < allNodes.size(); iSimple++) {
			connectSimpleTreeEdges(allNodes.get(iSimple));
		}
		for (int iComplex = 0; iComplex < allNodes.size(); iComplex++) {
			connectComplexTreeEdges(allNodes.get(iComplex));
			for (; iSimple < allNodes.size(); iSimple++) {
				connectSimpleTreeEdges(allNodes.get(iSimple));
			}
		}
		//
		//	Identify the shared leaf nodes to be realized as shared variables.
		//
		//			Set<@NonNull TreeNode> sharedTreeLeafNodes = new HashSet<>();
		//			for (@NonNull TreeNode rootTreeNode : treeRoots) {
		//				rootTreeNode.gatherSharedTreeLeafNodes(sharedTreeLeafNodes);
		//			}
	}

	private void analyzeRealizedEdges() {
		for (@NonNull TreeRoot treeRoot : treeRoots) {
			TxTypedModelNode txTypedModelNode = treeRoot.relDomainNode.getReferredTxTypedModelNode();
			if ((txTypedModelNode != null) && txTypedModelNode.isEnforce()) {
				for (@NonNull TreeClassNode rootNode : treeRoot.rootNodes) {
					rootNode.setIsRealized();
				}
			}
		}
	}

	private void connectComplexTreeEdges(@NonNull RelPatternNode relNode) {
		UMLXUtil.assertClassNode(relNode);
		for (@NonNull RelPatternEdge relPatternEdge : Iterables.concat(UMLXUtil.getOutgoing(relNode), UMLXUtil.getIncoming(relNode))) {
			if (!patternEdge2treeEdge.containsKey(relPatternEdge)) {
				RelPatternNode sourceNode = UMLXUtil.getSource(relPatternEdge);
				TreeClassNode parentNode = (TreeClassNode) patternNode2treeNode.get(sourceNode);
				if (parentNode != null) {
					RelPatternNode targetNode = UMLXUtil.getTarget(relPatternEdge);
					TreeNode childNode = patternNode2treeNode.get(targetNode);
					if (childNode != null) {
						new TreeEdge(true, relPatternEdge, false, parentNode, childNode);
					}
					else {
						new TreeClassNode(relPatternEdge, false, parentNode);
					}
				}
				else if (relPatternEdge.getReferredEStructuralFeature() instanceof EReference){
					sourceNode = UMLXUtil.getTarget(relPatternEdge);
					parentNode = (TreeClassNode) patternNode2treeNode.get(sourceNode);
					if (parentNode != null) {
						RelPatternNode targetNode = UMLXUtil.getSource(relPatternEdge);
						TreeNode childNode = patternNode2treeNode.get(targetNode);
						if (childNode != null) {
							new TreeEdge(true, relPatternEdge, true, parentNode, childNode);
						}
						else {
							new TreeClassNode(relPatternEdge, true, parentNode);
						}
					}
				}
			}
		}
	}

	private void connectSimpleTreeEdges(@NonNull RelPatternNode relNode) {
		UMLXUtil.assertClassNode(relNode);
		for (@NonNull RelPatternEdge relPatternEdge : Iterables.concat(UMLXUtil.getOutgoing(relNode), UMLXUtil.getIncoming(relNode))) {
			if (!patternEdge2treeEdge.containsKey(relPatternEdge)) {
				RelPatternNode sourceNode = UMLXUtil.getSource(relPatternEdge);
				TreeClassNode parentNode = (TreeClassNode) patternNode2treeNode.get(sourceNode);
				if (parentNode != null) {
					EStructuralFeature eStructuralFeature = relPatternEdge.getReferredEStructuralFeature();
					if ((eStructuralFeature != null) && !eStructuralFeature.isMany()) {
						RelPatternNode targetNode = UMLXUtil.getTarget(relPatternEdge);
						TreeNode childNode = patternNode2treeNode.get(targetNode);
						if (childNode != null) {
							new TreeEdge(true, relPatternEdge, false, parentNode, childNode);
						}
						else if (!targetNode.isExpression()) {
							new TreeClassNode(relPatternEdge, false, parentNode);
						}
						else {
							new TreeExpressionNode(relPatternEdge, parentNode);
						}
					}
				}
			}
		}
	}

	/**
	 * First pass, create all the declared elements.
	 */
	public @NonNull Relation create() {
		Iterable<@NonNull RelDomainNode> relDomainNodes = UMLXUtil.getOwnedRelDomainNodes(relDiagram);
		//
		//	Create the nodes of the QVTr template pattern.
		//
		for (@NonNull RelDomainNode relDomainNode : relDomainNodes) {
			for (@NonNull RelPatternNode relPatternNode : UMLXUtil.getOwnedRelPatternNodes(relDomainNode)) {
				if (!relPatternNode.isExpression()) {
					createRelationNode(relPatternNode);
				}
			}
		}
		//
		//	Create the edges of the QVTr template pattern.
		//
		for (@NonNull RelDomainNode relDomainNode : relDomainNodes) {
			for (@NonNull RelPatternEdge relPatternEdge : UMLXUtil.getOwnedRelPatternEdges(relDomainNode)) {
				createRelationEdge(relPatternEdge);
			}
		}
		//
		//	Create the patterns of the QVTr template pattern.
		//
		for (@NonNull RelDomainNode relDomainNode : relDomainNodes) {
			if (relDomainNode.getReferredTxTypedModelNode() != null) {
				createRelationDomain(relDomainNode);
			}
		}
		//
		//	Create the Relation
		//
		Relation qvtrRelation = createRelation();
		//
		//	Create non-pattern shared variables
		//
		for (@NonNull RelDomainNode relDomainNode : relDomainNodes) {
			for (@NonNull RelPatternNode relPatternNode : UMLXUtil.getOwnedRelPatternNodes(relDomainNode)) {
				if (!relPatternNode.isIsRoot() && !relPatternNode.isExpression()) {
					TreeNode treeNode = patternNode2treeNode.get(relPatternNode);
					if (treeNode == null) {
						org.eclipse.ocl.pivot.Class asClass = umlx2qvtr.getReferredType(relPatternNode);
						String name = relPatternNode.isIsAnon() ? null : UMLXUtil.getName(relPatternNode);
						Variable variable = umlx2qvtr.createSharedVariable(name, asClass, relPatternNode.isIsRequired(), null);
						qvtrRelation.getVariable().add(variable);
						umlx2qvtr.install(relPatternNode, variable);
					}
				}
			}
		}
		//
		//	Compute derived properties
		//
		for (@NonNull RelationDomain qvtrRelationDomain : allDomains) {
			for (@NonNull DomainPattern qvtrDomainPattern : QVTrelationUtil.getOwnedPatterns(qvtrRelationDomain)) {
				TemplateExp rootTemplateExpression = QVTrelationUtil.getOwnedTemplateExpression(qvtrDomainPattern);
				qvtrRelationDomain.getRootVariable().add(QVTrelationUtil.getBindsTo(rootTemplateExpression));
				List<@NonNull Variable> boundVariables = new ArrayList<>();
				umlx2qvtr.computeBoundVariables(boundVariables, rootTemplateExpression);
				List<Variable> bindsTo = qvtrDomainPattern.getBindsTo();
				Iterables.addAll(ClassUtil.nullFree(bindsTo), boundVariables);
			}
		}
		return qvtrRelation;
	}

	private @NonNull Relation createRelation() {
		Relation qvtrRelation = umlx2qvtr.createRelation(UMLXUtil.getName(relDiagram), allDomains);
		umlx2qvtr.install(relDiagram, qvtrRelation);
		//			Collections.sort(qvtrAllVariables, NameUtil.NAMEABLE_COMPARATOR);
		//			Iterables.addAll(QVTrelationUtil.Internal.getOwnedVariablesList(qvtrRelation), qvtrAllVariables);
		qvtrRelation.setIsAbstract(relDiagram.isIsAbstract());
		qvtrRelation.setIsTopLevel(relDiagram.isIsTop());
		qvtrRelation.getVariable().addAll(allVariables);
		return qvtrRelation;
	}

	private @NonNull RelationDomain createRelationDomain(@NonNull RelDomainNode relDomainNode) {
		TxTypedModelNode txTypedModelNode = UMLXUtil.getReferredTxTypedModelNode(relDomainNode);
		TypedModel qvtrTypedModel = umlx2qvtr.getQVTrElement(TypedModel.class, txTypedModelNode);
		RelationDomain qvtrRelationDomain = umlx2qvtr.createRelationDomain(qvtrTypedModel);
		qvtrRelationDomain.setIsCheckable(txTypedModelNode.isCheck());
		qvtrRelationDomain.setIsEnforceable(relDomainNode.isIsEnforced());
		umlx2qvtr.install(relDomainNode, qvtrRelationDomain);
		allDomains.add(qvtrRelationDomain);
		//
		TreeRoot treeRoot = domainNode2treeRoot.get(relDomainNode);
		assert treeRoot != null;
		for (@NonNull TreeClassNode rootNode : treeRoot.rootNodes) {
			Element qvtrElement = relPatternNode2qvtrElement.get(rootNode.patternNode);
			assert qvtrElement != null;
			qvtrRelationDomain.getPattern().add(umlx2qvtr.createDomainPattern((TemplateExp)qvtrElement));
		}
		return qvtrRelationDomain;
	}

	private @Nullable Element createRelationEdge(@NonNull RelPatternEdge relPatternEdge) {
		TreeEdge treeEdge = patternEdge2treeEdge.get(relPatternEdge);
		assert treeEdge != null;
		TreeNode treeSource = treeEdge.parent;
		TreeNode treeTarget = treeEdge.child;
		RelPatternNode relSource;
		RelPatternNode relTarget;
		EStructuralFeature eStructuralFeature = relPatternEdge.getReferredEStructuralFeature();
		int sourceIndex;
		if (treeEdge.isOpposite) {
			relSource = relPatternEdge.getTarget();
			relTarget = relPatternEdge.getSource();
			//			eStructuralFeature = ((EReference)relPatternEdge.getReferredEStructuralFeature()).getEOpposite();
			sourceIndex = 0;
		}
		else {
			relSource = relPatternEdge.getSource();
			relTarget = relPatternEdge.getTarget();
			//			eStructuralFeature = relPatternEdge.getReferredEStructuralFeature();
			sourceIndex = relPatternEdge.getSourceIndex();
		}
		TemplateExp qvtrSourceExpression = (TemplateExp)relPatternNode2qvtrElement.get(relSource);
		assert qvtrSourceExpression != null;
		Element qvtrTarget = relPatternNode2qvtrElement.get(relTarget);
		assert treeSource == patternNode2treeNode.get(relSource);
		assert treeTarget == patternNode2treeNode.get(relTarget);
		if (qvtrTarget == null) { // FIXME is a temporary StringLiteralExp still necessary?
			RelPatternNode relPatternExpressionNode = ((TreeExpressionNode)treeTarget).patternNode;
			UMLXUtil.assertExpressionNode(relPatternExpressionNode);
			StringBuilder s = new StringBuilder();
			for (String line : relPatternExpressionNode.getInitExpressionLines()) {
				s.append(line);
				s.append("\n");
			}
			OCLExpression targetExpression = umlx2qvtr.createStringLiteralExp(s.toString());
			umlx2qvtr.install(relPatternExpressionNode, targetExpression);
			//			addReference1(relPatternExpressionNode);
			qvtrTarget = targetExpression;
		}
		assert (sourceIndex == 0) == (eStructuralFeature != null);
		if (sourceIndex != 0) {
			CollectionTemplateExp qvtrCollectionTemplateExp = (CollectionTemplateExp) qvtrSourceExpression;
			if (sourceIndex < 0) {
				qvtrCollectionTemplateExp.setRest((SharedVariable)qvtrTarget);
			}
			else {
				int javaIndex = sourceIndex-1;
				while (qvtrCollectionTemplateExp.getMember().size() < javaIndex) {
					qvtrCollectionTemplateExp.getMember().add(umlx2qvtr.createNullLiteralExp());
				}
				if (qvtrTarget instanceof Variable) {
					qvtrTarget = umlx2qvtr.createVariableExp((Variable)qvtrTarget);
				}
				if (javaIndex < qvtrCollectionTemplateExp.getMember().size()) {
					qvtrCollectionTemplateExp.getMember().set(javaIndex, (OCLExpression)qvtrTarget);
				}
				else {
					qvtrCollectionTemplateExp.getMember().add((OCLExpression)qvtrTarget);
				}
			}
		}
		else {
			assert !(qvtrTarget instanceof VariableExp);
			if (treeEdge.isGraph && (qvtrTarget instanceof TemplateExp)) {
				qvtrTarget = ((TemplateExp)qvtrTarget).getBindsTo();
			}
			if (qvtrTarget instanceof VariableDeclaration) {
				qvtrTarget = umlx2qvtr.createVariableExp((VariableDeclaration)qvtrTarget);
			}
			ObjectTemplateExp qvtrObjectTemplateExp = (ObjectTemplateExp) qvtrSourceExpression;
			Property asProperty = metamodelManager.getASOfEcore(Property.class, eStructuralFeature);
			assert asProperty != null;
			if (treeEdge.isOpposite) {
				asProperty = asProperty.getOpposite();
				assert asProperty != null;
			}
			assert qvtrTarget != null;
			qvtrObjectTemplateExp.getPart().add(umlx2qvtr.createPropertyTemplateItem(asProperty, (OCLExpression)qvtrTarget));
		}
		return null;
	}

	private @Nullable Element createRelationNode(@NonNull RelPatternNode relPatternClassNode) {
		UMLXUtil.assertClassNode(relPatternClassNode);
		TreeClassNode treeNode = (TreeClassNode) patternNode2treeNode.get(relPatternClassNode);
		if (treeNode ==  null) {
			// FIXME create shared variable
			return null;
		}
		Variable asVariable = treeNode.getVariable();
		//		if (asVariable != null) {
		//			return asVariable;
		//		}
		if (asVariable instanceof TemplateVariable) {
			TemplateExp qvtrExpression = null;
			org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)asVariable.getType();
			if (type == null) {
				type = metamodelManager.getStandardLibrary().getOclInvalidType();
			}
			for (@NonNull TreeEdge childEdge : treeNode.childEdges) {
				if (childEdge.patternEdge.getSourceIndex() != 0) {
					qvtrExpression = umlx2qvtr.createCollectionTemplateExp((TemplateVariable) asVariable, type, asVariable.isIsRequired());
					break;
				}
			}
			if ((qvtrExpression == null) && asVariable.isIsMany()) {
				qvtrExpression = umlx2qvtr.createCollectionTemplateExp((TemplateVariable) asVariable, type, asVariable.isIsRequired());
			}
			if (qvtrExpression == null) {
				qvtrExpression = umlx2qvtr.createObjectTemplateExp((TemplateVariable) asVariable, type, asVariable.isIsRequired());
			}
			relPatternNode2qvtrElement.put(relPatternClassNode, qvtrExpression);
			umlx2qvtr.install(relPatternClassNode, qvtrExpression);
			return qvtrExpression;
		}
		else {
			relPatternNode2qvtrElement.put(relPatternClassNode, asVariable);
			return asVariable;
		}
	}

	/**
	 * Second pass after all internal and external symbol defined; parse the OCL expression text.
	 * @throws CompilerChainException
	 */
	public void resolveExpressions() throws CompilerChainException {
		for (@NonNull RelDomainNode relDomainNode : UMLXUtil.getOwnedRelDomainNodes(relDiagram)) {
			for (@NonNull RelPatternNode relPatternNode : UMLXUtil.getOwnedRelPatternNodes(relDomainNode)) {
				List<String> lines = relPatternNode.getInitExpressionLines();
				if (lines.size() > 0) {
					if (!relPatternNode.isExpression()) {
						resolveRelPatternClassNodeExpression(relPatternNode);
					}
					else {
						UMLXUtil.assertExpressionNode(relPatternNode);
						resolveRelPatternExpressionNodeExpression(relPatternNode);
					}
				}
			}
		}
		for (@NonNull RelInvocationNode relInvocationNode : UMLXUtil.getOwnedRelInvocationNodes(relDiagram)) {
			resolveInvocation(relInvocationNode);
			//			for (@NonNull RelInvocationEdge relInvocationEdge : UMLXUtil.getOwnedRelInvocationEdges(relInvocationNode)) {
			//				RelPatternNode invokingRelPatternNode = relInvocationEdge.getInvokingRelPatternNode();
			//				TreeNode treeNode = patternNode2treeNode.get(invokingRelPatternNode);
			//				assert treeNode != null;
			//				treeNode.isInvoked = true;
			//			}
		}
	}

	private void resolveRelPatternClassNodeExpression(@NonNull RelPatternNode relPatternClassNode) throws CompilerChainException {
		UMLXUtil.assertClassNode(relPatternClassNode);
		SharedVariable qvtrVariable = umlx2qvtr.getQVTrElement(SharedVariable.class, relPatternClassNode);
		List<String> lines = relPatternClassNode.getInitExpressionLines();
		if (lines.size() > 0) {
			OCLExpression qvtrExpression = umlx2qvtr.parseContextualExpression(qvtrVariable, lines);
			qvtrVariable.setOwnedInit(qvtrExpression);
		}
	}

	private void resolveRelPatternExpressionNodeExpression( @NonNull RelPatternNode relPatternExpressionNode) throws CompilerChainException {
		UMLXUtil.assertExpressionNode(relPatternExpressionNode);
		StringLiteralExp stringExpression = umlx2qvtr.basicGetQVTrElement(StringLiteralExp.class, relPatternExpressionNode);
		if (stringExpression != null) {
			resolveMemberExpression(relPatternExpressionNode, stringExpression);
		}
		else if (relPatternExpressionNode.getInvokingRelInvocationEdges().isEmpty()) {
			Relation qvtrRelation = umlx2qvtr.getQVTrElement(Relation.class, relDiagram);
			OCLExpression qvtrExpression = umlx2qvtr.parseContextualExpression(qvtrRelation, UMLXUtil.getInitExpressionLines(relPatternExpressionNode));
			umlx2qvtr.addWhenPredicate(qvtrRelation, qvtrExpression);
		}
		else {
			Relation qvtrRelation = umlx2qvtr.getQVTrElement(Relation.class, relDiagram);
			OCLExpression qvtrExpression = umlx2qvtr.parseContextualExpression(qvtrRelation, UMLXUtil.getInitExpressionLines(relPatternExpressionNode));
			assert qvtrExpression != null;
			umlx2qvtr.install(relPatternExpressionNode, qvtrExpression);
		}
	}

	protected void resolveMemberExpression(@NonNull RelPatternNode relPatternExpressionNode, @NonNull StringLiteralExp stringExpression) throws CompilerChainException {
		UMLXUtil.assertExpressionNode(relPatternExpressionNode);
		String textExpression = stringExpression.getStringSymbol();
		final EObject eContainer = stringExpression.eContainer();
		assert eContainer != null;
		OCLExpression qvtrExpression = umlx2qvtr.parseContextualExpression(eContainer, Collections.singletonList(textExpression));
		EReference eContainmentFeature = stringExpression.eContainmentFeature();
		PivotUtilInternal.resetContainer(stringExpression);
		eContainer.eSet(eContainmentFeature, qvtrExpression);
		//				context.reinstall(relPatternExpressionNode, qvtrExpression);
	}

	private @Nullable Element resolveInvocation(@NonNull RelInvocationNode relInvocationNode) {
		List<@NonNull OCLExpression> qvtrArguments = new ArrayList<>();
		for (@NonNull RelInvocationEdge relInvocationEdge : UMLXUtil.getOwnedRelInvocationEdges(relInvocationNode)) {
			//					relInvocationEdge.get
			RelPatternNode referredRelPatternNode = UMLXUtil.getInvokingRelPatternNode(relInvocationEdge); //UMLXUtil.getReferredRelPatternNode(relInvocationEdge);
			Element qvtrElement = umlx2qvtr.getQVTrElement(Element.class, referredRelPatternNode);
			if (qvtrElement instanceof TemplateExp) {
				qvtrElement = ((TemplateExp)qvtrElement).getBindsTo();
			}
			if (qvtrElement instanceof Variable) {
				qvtrElement = umlx2qvtr.createVariableExp((Variable)qvtrElement);
			}
			assert qvtrElement != null;
			qvtrArguments.add((OCLExpression)qvtrElement);
		}
		RelDiagram referredRelDiagram = UMLXUtil.getReferredRelDiagram(relInvocationNode);
		Relation qvtrReferredRelation = umlx2qvtr.getQVTrElement(Relation.class, referredRelDiagram);
		RelationCallExp qvtrRelationCallExp = umlx2qvtr.createRelationCallExp(qvtrReferredRelation, qvtrArguments);
		RelDiagram relDiagram = UMLXUtil.getOwningRelDiagram(relInvocationNode);
		Relation qvtrRelation = umlx2qvtr.getQVTrElement(Relation.class, relDiagram);
		if (!relInvocationNode.isIsThen()) {
			umlx2qvtr.addWhenPredicate(qvtrRelation, qvtrRelationCallExp);
		}
		else {
			umlx2qvtr.addWherePredicate(qvtrRelation, qvtrRelationCallExp);
		}
		return qvtrRelationCallExp;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(relDiagram.getName());
		for (@NonNull TreeRoot treeRoot : treeRoots) {
			s.append("\n" + String.valueOf(treeRoot.getName()));
			for (@NonNull TreeNode treeNode : treeRoot.rootNodes) {
				s.append("\n  ");
				treeNode.toString(s, 1);
			}
		}
		return s.toString();
	}
}
