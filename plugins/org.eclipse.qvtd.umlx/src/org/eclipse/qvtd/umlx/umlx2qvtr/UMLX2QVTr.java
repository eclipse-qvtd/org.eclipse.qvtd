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
package org.eclipse.qvtd.umlx.umlx2qvtr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.context.AbstractParserContext;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationFactory;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.SharedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationHelper;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelInvocationEdge;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternExpressionNode;
import org.eclipse.qvtd.umlx.RelPatternClassNode;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxImportNode;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.TxPartNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXElement;
import org.eclipse.qvtd.umlx.UMLXModel;
import org.eclipse.qvtd.umlx.util.AbstractExtendingUMLXVisitor;
import org.eclipse.qvtd.umlx.utilities.UMLXUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class UMLX2QVTr extends QVTrelationHelper
{
	protected static class ConnectionHelper
	{
		protected final @NonNull UMLX2QVTr context;
		protected final @NonNull MetamodelManager metamodelManager;
		private final @NonNull Map<@NonNull RelPatternClassNode, @NonNull OCLExpression> relPatternNode2qvtrExpression = new HashMap<>();
		private final @NonNull Set<@NonNull RelPatternEdge> connectedEdges = new HashSet<>();
		private final @NonNull Set<@NonNull RelPatternClassNode> connectedClassNodeSet = new HashSet<>();

		public ConnectionHelper(@NonNull UMLX2QVTr context) {
			this.context = context;
			this.metamodelManager = context.getMetamodelManager();
		}

		private boolean connectCollectionEdge(@NonNull RelPatternClassNode sourceNode, int sourceIndex, @NonNull RelPatternNode targetNode) {
			CollectionTemplateExp sourceTemplateExp = (CollectionTemplateExp) relPatternNode2qvtrExpression.get(sourceNode);
			OCLExpression targetExpression = relPatternNode2qvtrExpression.get(targetNode);
			assert sourceTemplateExp != null;
			if (sourceIndex > 0) {
				if (targetExpression == null) {
					if (targetNode instanceof RelPatternExpressionNode) {
						targetExpression = createUnparsedExpression((RelPatternExpressionNode) targetNode);
					}
					else {
						SharedVariable sharedVariable = context.getQVTrElement(SharedVariable.class, targetNode);
						targetExpression = context.createVariableExp(sharedVariable);
					}
				}
				List<@NonNull OCLExpression> ownedMembersList = QVTrelationUtil.Internal.getOwnedMembersList(sourceTemplateExp);
				int javaIndex = sourceIndex - 1;
				while (ownedMembersList.size() < javaIndex) {
					ownedMembersList.add(context.createNullLiteralExp());
				}
				if (ownedMembersList.size() == javaIndex) {
					ownedMembersList.add(targetExpression);
				}
				else {
					ownedMembersList.set(javaIndex, targetExpression);
				}
				return true;
			}
			else if (sourceIndex < 0) {
				SharedVariable sharedVariable = context.getQVTrElement(SharedVariable.class, targetNode);
				sourceTemplateExp.setRest(sharedVariable);
				return true;
			}
			else {
				return false;
			}
		}

		private boolean connectComplexEdge(@NonNull RelPatternClassNode sourceNode, @NonNull EStructuralFeature eStructuralFeature, @NonNull RelPatternNode targetNode) {
			EReference eReference = (EReference)eStructuralFeature;
			//			assert !eReference.isMany();
			//			EReference eOpposite = eReference.getEOpposite();
			//			if ((eOpposite != null) && (targetNode instanceof RelPatternClassNode)) {
			//				connect((RelPatternClassNode)targetNode, eOpposite, sourceNode);
			//				return true;
			//			}
			connectObjectEdge(sourceNode, eStructuralFeature, targetNode);
			return true;
			//			throw new UnsupportedOperationException();
			//			return false;
		}

		private @NonNull Iterable<@NonNull RelPatternClassNode> connectComplexEdges(@NonNull RelPatternClassNode relNode) {
			List<@NonNull RelPatternClassNode> newClassNodes = new ArrayList<>();
			for (@NonNull RelPatternEdge relEdge : UMLXUtil.getOutgoing(relNode)) {
				if (!connectedEdges.contains(relEdge)) {
					RelPatternClassNode sourceNode = relNode;
					EStructuralFeature eStructuralFeature = relEdge.getReferredEStructuralFeature();
					RelPatternNode targetNode = UMLXUtil.getTarget(relEdge);
					if (eStructuralFeature != null) {
						if (connectComplexEdge(sourceNode, eStructuralFeature, targetNode)) {
							if (targetNode instanceof RelPatternClassNode) {
								newClassNodes.add((RelPatternClassNode)targetNode);
							}
							connectedEdges.add(relEdge);
						}
					}
					else {
						if (connectCollectionEdge(sourceNode, relEdge.getSourceIndex(), targetNode)) {
							if (targetNode instanceof RelPatternClassNode) {
								newClassNodes.add((RelPatternClassNode)targetNode);
							}
							connectedEdges.add(relEdge);
						}
					}
				}
			}
			for (@NonNull RelPatternEdge relEdge : UMLXUtil.getIncoming(relNode)) {
				if (!connectedEdges.contains(relEdge)) {
					RelPatternClassNode sourceNode = UMLXUtil.getSource(relEdge);
					EStructuralFeature eStructuralFeature = relEdge.getReferredEStructuralFeature();
					RelPatternClassNode targetNode = relNode;
					if (eStructuralFeature != null) {
						if (connectComplexEdge(sourceNode, eStructuralFeature, targetNode)) {
							newClassNodes.add(targetNode);
							connectedEdges.add(relEdge);
						}
					}
					else {
						if (connectCollectionEdge(sourceNode, relEdge.getSourceIndex(), targetNode)) {
							if (targetNode instanceof RelPatternClassNode) {
								newClassNodes.add(targetNode);
							}
							connectedEdges.add(relEdge);
						}
					}
				}
			}
			return newClassNodes;
		}

		public void connectNodes(@NonNull Iterable<@NonNull RelPatternClassNode> relRootPatternClassNodes) {
			List<@NonNull RelPatternClassNode> connectedClassNodeList = Lists.newArrayList(relRootPatternClassNodes);
			connectedClassNodeSet.addAll(connectedClassNodeList);
			int iSimple = 0;
			for (; iSimple < connectedClassNodeList.size(); iSimple++) {
				RelPatternClassNode connectableClassNode = connectedClassNodeList.get(iSimple);
				Iterable<@NonNull RelPatternClassNode> newClassNodes = connectSimpleEdges(connectableClassNode);
				for (@NonNull RelPatternClassNode newClassNode : newClassNodes) {
					if (connectedClassNodeSet.add(newClassNode)) {
						connectedClassNodeList.add(newClassNode);
					}
				}
			}
			for (int iComplex = 0; iComplex < connectedClassNodeList.size(); iComplex++) {
				RelPatternClassNode connectableClassNode = connectedClassNodeList.get(iComplex);
				Iterable<@NonNull RelPatternClassNode> newClassNodes = connectComplexEdges(connectableClassNode);
				for (@NonNull RelPatternClassNode newClassNode : newClassNodes) {
					if (connectedClassNodeSet.add(newClassNode)) {
						connectedClassNodeList.add(newClassNode);
					}
				}
				for (; iSimple < connectedClassNodeList.size(); iSimple++) {
					RelPatternClassNode connectableClassNode2 = connectedClassNodeList.get(iSimple);
					Iterable<@NonNull RelPatternClassNode> newClassNodes2 = connectSimpleEdges(connectableClassNode2);
					for (@NonNull RelPatternClassNode newClassNode : newClassNodes2) {
						if (connectedClassNodeSet.add(newClassNode)) {
							connectedClassNodeList.add(newClassNode);
						}
					}
				}
			}
		}

		private void connectObjectEdge(@NonNull RelPatternClassNode sourceNode, @NonNull EStructuralFeature eStructuralFeature, @NonNull RelPatternNode targetNode) {
			ObjectTemplateExp sourceTemplateExp = (ObjectTemplateExp) relPatternNode2qvtrExpression.get(sourceNode);
			OCLExpression targetExpression = relPatternNode2qvtrExpression.get(targetNode);
			assert sourceTemplateExp != null;
			if (targetExpression == null) {
				if (targetNode instanceof RelPatternExpressionNode) {
					targetExpression = createUnparsedExpression((RelPatternExpressionNode)targetNode);
				}
				else {
					SharedVariable sharedVariable = context.getQVTrElement(SharedVariable.class, targetNode);
					targetExpression = context.createVariableExp(sharedVariable);
				}
			}
			Property asProperty = metamodelManager.getASOfEcore(Property.class, eStructuralFeature);
			assert asProperty != null;
			//			if (txPartNode.isIsOpposite()) {
			//				asProperty = asProperty.getOpposite();
			//			}
			PropertyTemplateItem qvtrPropertyTemplateItem = context.createPropertyTemplateItem(asProperty, targetExpression);
			QVTrelationUtil.Internal.getOwnedPartsList(sourceTemplateExp).add(qvtrPropertyTemplateItem);
		}

		private boolean connectSimpleEdge(@NonNull RelPatternClassNode sourceNode, @NonNull EStructuralFeature eStructuralFeature, @NonNull RelPatternNode targetNode) {
			if (eStructuralFeature instanceof EAttribute) {
				EAttribute eAttribute = (EAttribute)eStructuralFeature;
				connectObjectEdge(sourceNode, eAttribute, targetNode);
				return true;
			}
			EReference eReference = (EReference)eStructuralFeature;
			if (!eReference.isMany()) {
				connectObjectEdge(sourceNode, eReference, targetNode);
				return true;
			}
			if (connectedClassNodeSet.contains(targetNode)) {
				EReference eOpposite = eReference.getEOpposite();
				if (eOpposite != null) {
					connectObjectEdge((RelPatternClassNode)targetNode, eOpposite, sourceNode);
					return true;
				}
			}
			return false;
		}

		private @NonNull Iterable<@NonNull RelPatternClassNode> connectSimpleEdges(@NonNull RelPatternClassNode relNode) {
			List<@NonNull RelPatternClassNode> newClassNodes = new ArrayList<>();
			for (@NonNull RelPatternEdge relEdge : UMLXUtil.getOutgoing(relNode)) {
				if (!connectedEdges.contains(relEdge)) {
					RelPatternClassNode sourceNode = relNode;
					EStructuralFeature eStructuralFeature = relEdge.getReferredEStructuralFeature();
					RelPatternNode targetNode = UMLXUtil.getTarget(relEdge);
					if (eStructuralFeature != null) {
						if (connectSimpleEdge(sourceNode, eStructuralFeature, targetNode)) {
							if (targetNode instanceof RelPatternClassNode) {
								newClassNodes.add((RelPatternClassNode)targetNode);
							}
							connectedEdges.add(relEdge);
						}
					}
					else {
						if (connectCollectionEdge(sourceNode, relEdge.getSourceIndex(), targetNode)) {
							if (targetNode instanceof RelPatternClassNode) {
								newClassNodes.add((RelPatternClassNode)targetNode);
							}
							connectedEdges.add(relEdge);
						}
					}
				}
			}
			for (@NonNull RelPatternEdge relEdge : UMLXUtil.getIncoming(relNode)) {
				if (!connectedEdges.contains(relEdge)) {
					RelPatternClassNode sourceNode = UMLXUtil.getSource(relEdge);
					EStructuralFeature eStructuralFeature = relEdge.getReferredEStructuralFeature();
					RelPatternClassNode targetNode = relNode;
					if (eStructuralFeature != null) {
						if (connectSimpleEdge(sourceNode, eStructuralFeature, targetNode)) {
							newClassNodes.add(targetNode);
							connectedEdges.add(relEdge);
						}
					}
					else {
						if (connectCollectionEdge(sourceNode, relEdge.getSourceIndex(), targetNode)) {
							if (targetNode instanceof RelPatternClassNode) {
								newClassNodes.add(targetNode);
							}
							connectedEdges.add(relEdge);
						}
					}
				}
			}
			return newClassNodes;
		}

		protected @NonNull OCLExpression createUnparsedExpression(@NonNull RelPatternExpressionNode relPatternExpressionNode) {
			OCLExpression targetExpression = context.createStringLiteralExp(UMLXUtil.getExpression(relPatternExpressionNode));
			context.install(relPatternExpressionNode, targetExpression);
			context.addReference(relPatternExpressionNode);
			return targetExpression;
		}

		private OCLExpression get(@NonNull RelPatternClassNode relPatternNode) {
			return relPatternNode2qvtrExpression.get(relPatternNode);
		}

		private void put(@NonNull RelPatternClassNode relPatternNode, @NonNull OCLExpression qvtrExpression) {
			relPatternNode2qvtrExpression.put(relPatternNode, qvtrExpression);
		}
	}

	protected static class CreateVisitor extends AbstractExtendingUMLXVisitor<@Nullable Element, @NonNull UMLX2QVTr>
	{
		protected final @NonNull MetamodelManager metamodelManager;
		protected final @NonNull RelationModel qvtrModel;

		public CreateVisitor(@NonNull UMLX2QVTr context, @NonNull RelationModel qvtrModel) {
			super(context);
			EnvironmentFactory environmentFactory = context.getEnvironmentFactory();
			this.metamodelManager = environmentFactory.getMetamodelManager();
			this.qvtrModel = qvtrModel;
		}

		public <T1 extends UMLXElement, T2 extends Element> @Nullable T2 create(@Nullable T1 source) {
			if (source == null) {
				return null;
			}
			@SuppressWarnings("unchecked") @Nullable T2 target = (T2) source.accept(this);
			return target;
		}

		public <@NonNull T1 extends UMLXElement, T2 extends Element> void createAll(/*@NonNull*/ Iterable<T1> sources, /*@NonNull*/ List<? super T2> targets) {
			for (T1 source : sources) {
				@SuppressWarnings("unchecked") T2 target = (T2) source.accept(this);
				if ((target != null) && (targets != null)) {
					targets.add(target);
				}
			}
		}

		/**
		 * Accumulate a TemplateExp and TemplateVariable for relPatternNode and all transitively EReference-connection RelPatternNode in qvtrDomainClassNodes.
		 * No relationships between TemplateExps are established here.
		 * Return the TemplateExp for relPatternNode.
		 */
		private @NonNull OCLExpression createDomainPatternNodes(@NonNull RelPatternClassNode relPatternClassNode, @NonNull ConnectionHelper connectionHelper) {
			OCLExpression qvtrTemplateExp = connectionHelper.get(relPatternClassNode);
			if (qvtrTemplateExp == null) {
				Variable asVariable = visit(Variable.class, relPatternClassNode);
				if (asVariable instanceof TemplateVariable) {
					TemplateVariable asTemplateVariable = (TemplateVariable)asVariable;
					org.eclipse.ocl.pivot.Class asClass = metamodelManager.getASOfEcore(org.eclipse.ocl.pivot.Class.class, relPatternClassNode.getReferredEClassifier());
					assert asClass != null;
					if (relPatternClassNode.isIsMany()/*asClass instanceof CollectionType*/) {
						qvtrTemplateExp = context.createCollectionTemplateExp(asTemplateVariable, (CollectionType)asVariable.getType(), relPatternClassNode.isIsRequired());
					}
					else {
						qvtrTemplateExp = context.createObjectTemplateExp(asTemplateVariable, asClass, relPatternClassNode.isIsRequired());
					}
					//				context.putUMLX2QVTrTrace(relPatternNode, qvtrTemplateExp);
					connectionHelper.put(relPatternClassNode, qvtrTemplateExp);
					for (@NonNull RelPatternEdge relPatternEdge : UMLXUtil.getOutgoing(relPatternClassNode)) {
						RelPatternNode relTargetNode = UMLXUtil.getTarget(relPatternEdge);
						EStructuralFeature eStructuralFeature = relPatternEdge.getReferredEStructuralFeature();
						if ((relTargetNode instanceof RelPatternClassNode) && !(eStructuralFeature instanceof EAttribute)) {
							createDomainPatternNodes((RelPatternClassNode)relTargetNode, connectionHelper);
						}
					}
					for (@NonNull RelPatternEdge relPatternEdge : UMLXUtil.getIncoming(relPatternClassNode)) {
						RelPatternClassNode relSourceNode = UMLXUtil.getSource(relPatternEdge);
						EStructuralFeature eStructuralFeature = relPatternEdge.getReferredEStructuralFeature();
						if (!(eStructuralFeature instanceof EAttribute)) {
							createDomainPatternNodes(relSourceNode, connectionHelper);
						}
					}
				}
				else {
					qvtrTemplateExp = context.createVariableExp(asVariable);
				}
			}
			return qvtrTemplateExp;
		}

		/**
		 * Return the most positive non-zero source index of all incoming edges. Returns null if no incoming edge has a
		 * non-zeto source index.
		 */
		private @Nullable Integer getIncomingSourceIndex(@NonNull RelPatternClassNode relPatternClassNode) {
			Integer mostPositiveSourceIndex = null;
			for (@NonNull RelPatternEdge relPatternEdge : UMLXUtil.getIncoming(relPatternClassNode)) {
				int sourceIndex = relPatternEdge.getSourceIndex();
				if (sourceIndex != 0) {
					if (mostPositiveSourceIndex == null) {
						mostPositiveSourceIndex = sourceIndex;
					}
					else if (mostPositiveSourceIndex < sourceIndex) {
						mostPositiveSourceIndex = sourceIndex;
					}
				}
			}
			return mostPositiveSourceIndex;
		}

		public org.eclipse.ocl.pivot.@NonNull Package getPackage(org.eclipse.ocl.pivot.@Nullable Package asParentPackage, @NonNull String name) {
			List<org.eclipse.ocl.pivot.@NonNull Package> asPackages = (asParentPackage != null ? QVTbaseUtil.Internal.getOwnedPackagesList(asParentPackage) : QVTbaseUtil.Internal.getOwnedPackagesList(qvtrModel));
			org.eclipse.ocl.pivot.Package qvtrPackage = NameUtil.getNameable(asPackages, name);
			if (qvtrPackage ==  null) {
				@NonNull String nsURI = "http:/fixme";		// FIXME
				qvtrPackage = PivotUtil.createPackage(name, null, nsURI, null);
				qvtrPackage.setURI(null);
				asPackages.add(qvtrPackage);
			}
			return qvtrPackage;
		}

		public org.eclipse.ocl.pivot.@NonNull Package getRootPackage(@NonNull String name) {
			org.eclipse.ocl.pivot.Package qvtrPackage = NameUtil.getNameable(qvtrModel.getOwnedPackages(), name);
			if (qvtrPackage ==  null) {
				@NonNull String nsURI = "http:/fixme";		// FIXME
				qvtrPackage = PivotUtil.createPackage(name, null, nsURI, null);
				qvtrModel.getOwnedPackages().add(qvtrPackage);
			}
			return qvtrPackage;
		}

		protected <T extends Element> @NonNull T visit(@NonNull Class<T> qvtrClass, @NonNull UMLXElement umlxElement) {
			Element qvtrElement = umlxElement.accept(this);
			if (qvtrElement == null) {
				throw new IllegalArgumentException("Missing UMLX element for " + umlxElement);
			}
			if (!qvtrClass.isAssignableFrom(qvtrElement.getClass())) {
				throw new ClassCastException("UMLX element " + qvtrElement + " cannot be cast to " + qvtrClass);
			}
			@SuppressWarnings("unchecked")T castElement = (T)qvtrElement;
			return castElement;
		}

		public void visitAll(/*@NonNull*/ Iterable<? extends @NonNull UMLXElement> sources) {
			for (@NonNull UMLXElement source : sources) {
				source.accept(this);
			}
		}

		@Override
		public @Nullable Element visitRelDiagram(@NonNull RelDiagram relDiagram) {
			List<@NonNull RelationDomain> qvtrRelationDomains = new ArrayList<>();
			ConnectionHelper connectionHelper = new ConnectionHelper(context);
			//			Iterable<@NonNull RelPatternNode> relNodes = UMLXUtil.getOwnedNodes(relDiagram);
			List<@NonNull RelPatternClassNode> relRootPatternClassNodes = new ArrayList<>();
			for (@NonNull RelDomainNode relDomainNode : UMLXUtil.getOwnedRelDomainNodes(relDiagram)) {
				if (relDomainNode.getReferredTxTypedModelNode() != null) {
					//
					//	Create the RelationDomain
					//
					RelationDomain qvtrRelationDomain = visit(RelationDomain.class, relDomainNode);
					qvtrRelationDomains.add(qvtrRelationDomain);
					//
					//	Create each DomainPattern, TemplateExp and TemplateVariable
					//
					for (@NonNull RelPatternNode relPatternNode : UMLXUtil.getOwnedRelPatternNodes(relDomainNode)) {
						if (relPatternNode.isIsRoot() && (relPatternNode instanceof RelPatternClassNode)) {
							OCLExpression qvtrTemplateExp = createDomainPatternNodes((@NonNull RelPatternClassNode) relPatternNode, connectionHelper);
							DomainPattern qvtrRootPattern = context.createDomainPattern((TemplateExp) qvtrTemplateExp);
							qvtrRelationDomain.getPattern().add(qvtrRootPattern);
							relRootPatternClassNodes.add((RelPatternClassNode) relPatternNode);
						}
					}
				}
			}
			for (@NonNull RelInvocationNode relInvocationNode : UMLXUtil.getOwnedRelInvocationNodes(relDiagram)) {
				visit(relInvocationNode);
			}
			//
			//	Gather the TemplateVariables, create the SharedVariables
			//
			List<@NonNull Variable> qvtrAllVariables = new ArrayList<>();
			for (@NonNull RelDomainNode relDomainNode : UMLXUtil.getOwnedRelDomainNodes(relDiagram)) {
				for (@NonNull RelPatternNode relNode : UMLXUtil.getOwnedRelPatternNodes(relDomainNode)) {
					if (relNode instanceof RelPatternClassNode) {
						RelPatternClassNode relPatternNode = (RelPatternClassNode) relNode;
						Variable asVariable = context.basicGetQVTrElement(Variable.class, relPatternNode);
						if (asVariable == null) {
							asVariable = visit(SharedVariable.class, relPatternNode);
						}
						qvtrAllVariables.add(asVariable);
					}
				}
			}
			//
			//	Establish the TemplateVariable interrelationships
			//
			connectionHelper.connectNodes(relRootPatternClassNodes);
			//
			//	Create the Relation
			//
			//			Collections.sort(qvtrRelationDomains, NameUtil.NAMEABLE_COMPARATOR);
			Relation qvtrRelation = context.createRelation(UMLXUtil.getName(relDiagram), qvtrRelationDomains);
			context.install(relDiagram, qvtrRelation);
			//			Collections.sort(qvtrAllVariables, NameUtil.NAMEABLE_COMPARATOR);
			Iterables.addAll(QVTrelationUtil.Internal.getOwnedVariablesList(qvtrRelation), qvtrAllVariables);
			qvtrRelation.setIsTopLevel(relDiagram.isIsTop());
			//
			//	Compute derived properties
			//
			for (@NonNull RelationDomain qvtrRelationDomain : qvtrRelationDomains) {
				for (@NonNull DomainPattern qvtrDomainPattern : QVTrelationUtil.getOwnedPatterns(qvtrRelationDomain)) {
					TemplateExp rootTemplateExpression = QVTrelationUtil.getOwnedTemplateExpression(qvtrDomainPattern);
					qvtrRelationDomain.getRootVariable().add(QVTrelationUtil.getBindsTo(rootTemplateExpression));
					List<@NonNull Variable> boundVariables = new ArrayList<>();
					context.computeBoundVariables(boundVariables, rootTemplateExpression);
					List<Variable> bindsTo = qvtrDomainPattern.getBindsTo();
					Iterables.addAll(ClassUtil.nullFree(bindsTo), boundVariables);
				}
			}
			return qvtrRelation;
		}

		@Override
		public @Nullable RelationDomain visitRelDomainNode(@NonNull RelDomainNode relDomainNode) {
			TxTypedModelNode txTypedModelNode = UMLXUtil.getReferredTxTypedModelNode(relDomainNode);
			TypedModel qvtrTypedModel = context.getQVTrElement(TypedModel.class, txTypedModelNode);
			RelationDomain qvtrRelationDomain = context.createRelationDomain(qvtrTypedModel);
			qvtrRelationDomain.setIsCheckable(txTypedModelNode.isCheck());
			qvtrRelationDomain.setIsEnforceable(txTypedModelNode.isEnforce());
			context.install(relDomainNode, qvtrRelationDomain);
			return qvtrRelationDomain;
		}

		@Override
		public @Nullable Element visitRelInvocationNode(@NonNull RelInvocationNode relInvocationNode) {
			context.addReference(relInvocationNode);
			return null;
		}

		@Override
		public @Nullable Element visitRelPatternClassNode(@NonNull RelPatternClassNode relPatternClassNode) {
			EClassifier eClassifier = UMLXUtil.getReferredEClassifier(relPatternClassNode);
			if (eClassifier instanceof EClass) {
				org.eclipse.ocl.pivot.Class asClass = metamodelManager.getASOfEcore(org.eclipse.ocl.pivot.Class.class, eClassifier);
				assert asClass != null;
				if (relPatternClassNode.isIsMany()) {
					asClass = ((PivotMetamodelManager)metamodelManager).getCollectionType(relPatternClassNode.isIsOrdered(), relPatternClassNode.isIsUnique(), asClass,
						relPatternClassNode.isIsNullFree(), null, null);
				}
				Variable asVariable;
				Integer mostPositiveSourceIndex = getIncomingSourceIndex(relPatternClassNode);
				if (mostPositiveSourceIndex == null) {
					asVariable = context.createTemplateVariable(UMLXUtil.getName(relPatternClassNode), asClass, relPatternClassNode.isIsRequired(), null);
				}
				else if (mostPositiveSourceIndex > 0) {
					asVariable = context.createTemplateVariable(UMLXUtil.getName(relPatternClassNode), asClass, relPatternClassNode.isIsRequired(), null);
				}
				else {
					asVariable = context.createSharedVariable(relPatternClassNode.isIsAnon() ? null :  UMLXUtil.getName(relPatternClassNode), asClass, relPatternClassNode.isIsRequired(), null);
				}
				context.install(relPatternClassNode, asVariable);
				return asVariable;
			}
			else {
				DataType asDataType = metamodelManager.getASOfEcore(DataType.class, eClassifier);
				assert asDataType != null;
				Variable asVariable = context.createSharedVariable(UMLXUtil.getName(relPatternClassNode), asDataType, relPatternClassNode.isIsRequired(), null);
				context.install(relPatternClassNode, asVariable);
				return asVariable;
			}
		}

		@Override
		public @Nullable Element visitTxDiagram(@NonNull TxDiagram txDiagram) {
			List<@NonNull Key> qvtrKeys = new ArrayList<>();
			createAll(UMLXUtil.getOwnedTxKeyNodes(txDiagram), qvtrKeys);
			List<@NonNull TypedModel> qvtrTypedModels = new ArrayList<>();
			createAll(UMLXUtil.getOwnedTxTypedModelNodes(txDiagram), qvtrTypedModels);
			RelationalTransformation qvtrRelationalTransformation = context.createRelationalTransformation(UMLXUtil.getName(txDiagram), qvtrTypedModels);
			context.install(txDiagram, qvtrRelationalTransformation);
			org.eclipse.ocl.pivot.Package asPackage = null;
			String packagePath = txDiagram.getPackage();
			if (packagePath != null) {
				for (StringTokenizer tokenizer = new StringTokenizer(packagePath, "::"); tokenizer.hasMoreTokens(); ) {
					String token = tokenizer.nextToken();
					asPackage = getPackage(asPackage, token);
				}
			}
			if (asPackage == null) {
				asPackage = getPackage(null, "");
			}
			//			Collections.sort(qvtrKeys, NameUtil.NAMEABLE_COMPARATOR);
			Iterables.addAll(QVTrelationUtil.Internal.getOwnedKeysList(qvtrRelationalTransformation), qvtrKeys);
			QVTbaseUtil.Internal.getOwnedClassesList(asPackage).add(qvtrRelationalTransformation);

			List<@NonNull Rule> allRelationsList = new ArrayList<>();
			createAll(UMLXUtil.getOwnedRelDiagrams(txDiagram), allRelationsList);
			//			Collections.sort(allRelationsList, NameUtil.NAMEABLE_COMPARATOR);
			Iterables.addAll(QVTrelationUtil.Internal.getOwnedRelationsList(qvtrRelationalTransformation), allRelationsList);
			QVTbaseUtil.getContextVariable(context.getStandardLibrary(), qvtrRelationalTransformation);
			return qvtrRelationalTransformation;
		}

		@Override
		public @Nullable Element visitTxImportNode(@NonNull TxImportNode txImportNode) {
			String uri = txImportNode.getUri();
			EObject eObject = context.getEnvironmentFactory().getResourceSet().getEObject(URI.createURI(uri), true);
			try {
				Namespace asNamespace = metamodelManager.getASOf(Namespace.class, eObject);
				if (asNamespace != null) {
					Import asImport = context.createImport(UMLXUtil.getName(txImportNode), asNamespace);
					context.install(txImportNode, asImport);
					return asImport;
				}
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public @Nullable Element visitTxKeyNode(@NonNull TxKeyNode txKeyNode) {
			EClass eClass = UMLXUtil.getReferredEClass(txKeyNode);
			org.eclipse.ocl.pivot.Class asClass = metamodelManager.getASOfEcore(org.eclipse.ocl.pivot.Class.class, eClass);
			assert asClass != null;
			List<@NonNull Property> asProperties = new ArrayList<>();
			createAll(UMLXUtil.getOwnedTxPartNodes(txKeyNode), asProperties);
			Key asKey = context.createKey(asClass, asProperties);
			context.install(txKeyNode, asKey);
			return asKey;
		}

		@Override
		public @Nullable Element visitTxPackageNode(@NonNull TxPackageNode txPackageNode) {
			EPackage ePackage = UMLXUtil.getReferredEPackage(txPackageNode);
			return metamodelManager.getASOfEcore(org.eclipse.ocl.pivot.Package.class, ePackage);
		}

		@Override
		public @Nullable Element visitTxPartNode(@NonNull TxPartNode txPartNode) {
			EStructuralFeature eStructuralFeature = UMLXUtil.getReferredEStructuralFeature(txPartNode);
			Property asProperty = metamodelManager.getASOfEcore(Property.class, eStructuralFeature);
			assert asProperty != null;
			if (txPartNode.isIsOpposite()) {
				asProperty = asProperty.getOpposite();
			}
			return asProperty;
		}

		@Override
		public @Nullable Element visitTxTypedModelNode(@NonNull TxTypedModelNode txTypedModelNode) {
			List<org.eclipse.ocl.pivot.@NonNull Package> usedPackages = new ArrayList<>();
			createAll(UMLXUtil.getOwnedTxPackageNodes(txTypedModelNode), usedPackages);
			TypedModel asTypedModel = context.createTypedModel(UMLXUtil.getName(txTypedModelNode), usedPackages);
			context.install(txTypedModelNode, asTypedModel);
			return asTypedModel;
		}

		@Override
		public @Nullable Element visitUMLXModel(@NonNull UMLXModel umlxModel) {
			qvtrModel.setExternalURI(context.qvtrResource.getURI().toString());
			context.install(umlxModel, qvtrModel);
			Iterable<@NonNull TxDiagram> txDiagrams = UMLXUtil.getOwnedTxDiagrams(umlxModel);
			visitAll(txDiagrams);
			List<@NonNull TxImportNode> txImports = new ArrayList<>();
			for (@NonNull TxDiagram txDiagram : txDiagrams) {
				Iterables.addAll(txImports, UMLXUtil.getOwnedTxImportNodes(txDiagram));
			}
			createAll(txImports, qvtrModel.getOwnedImports());
			//			createAll(PivotUtil.getOwnedPackages(qvtrModel), null); //umlxModel.getOwnedPackages());
			//			createAll(relationModel.getOwnedComments(), umlxModel.getOwnedComments());
			return null;
		}

		/*		@Override
		public @Nullable UMLXElement visitRelationalTransformation(@NonNull RelationalTransformation qvtrTransformation) {
			TxDiagram txDiagram = UMLXFactory.eINSTANCE.createTxDiagram();
			txDiagram.setName(qvtrTransformation.getName());
			TxTransformationNode txTransformationNode = UMLXFactory.eINSTANCE.createTxTransformationNode();
			context.putQVTr2UMLXTrace(qvtrTransformation, txTransformationNode);
			txTransformationNode.setName(qvtrTransformation.getName());
			//			txTransformationNode.setOwnedContext(create(qvtrTransformation.getOwnedContext()));
			//		    createAll(qvtrTransformation.getOwnedOperations(), txTransformationNode.getOwnedOperations());
			createAll(QVTrelationUtil.getModelParameters(qvtrTransformation), txTransformationNode.getTxTypedModelNodes());
			createAll(QVTrelationUtil.getOwnedKey(qvtrTransformation), txTransformationNode.getTxKeyNodes());
			createAll(QVTrelationUtil.getRule(qvtrTransformation), txDiagram.getOwnedDiagrams());
			//		    doRules(qvtrTransformation, txTransformationNode);
			//			createAll(qvtrTransformation.getOwnedComments(), txTransformationNode.getOwnedComments());
			txDiagram.getOwnedNodes().add(txTransformationNode);
			umlxModel.getOwnedDiagrams().add(txDiagram);
			return null;
		} */

		/*		@Override
		public @Nullable UMLXElement visitTypedModel(@NonNull TypedModel qvtrTypedModel) {
			TxTypedModelNode txTypedModelNode = UMLXFactory.eINSTANCE.createTxTypedModelNode();
			context.putQVTr2UMLXTrace(qvtrTypedModel, txTypedModelNode);
			txTypedModelNode.setName(qvtrTypedModel.getName());
			for (org.eclipse.ocl.pivot.@NonNull Package usedPackage : QVTrelationUtil.getUsedPackages(qvtrTypedModel)) {
				TxPackageNode txPackageNode = UMLXFactory.eINSTANCE.createTxPackageNode();
				//				context.addTrace(usedPackage, txPackageNode);
				txPackageNode.setReferredPackage(usedPackage.getEPackage());
				txTypedModelNode.getTxPackageNodes().add(txPackageNode);
			}
			return txTypedModelNode;
		} */

		/*		@Override
		public @Nullable UMLXElement visitVariableExp(@NonNull VariableExp qvtrVariableExp) {
			RelPatternNode relPatternNode = context.getUMLXElement(RelPatternNode.class, PivotUtil.getReferredVariable(qvtrVariableExp));
			return relPatternNode;
		} */

		@Override
		public @Nullable Element visiting(@NonNull UMLXElement umlxElement) {
			System.out.println("Unsupported " + umlxElement.eClass().getName() + " for " + getClass().getSimpleName());
			return null;
			//			throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
		}
	}

	protected static class ReferenceVisitor extends AbstractExtendingUMLXVisitor<@Nullable Object, @NonNull UMLX2QVTr>
	{
		public ReferenceVisitor(@NonNull UMLX2QVTr context) {
			super(context);
		}

		@Override
		public @Nullable Object visiting(@NonNull UMLXElement visitable) {
			System.out.println("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
			return null;
			//			throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
		}

		@Override
		public @Nullable Object visitRelInvocationNode(@NonNull RelInvocationNode relInvocationNode) {
			List<@NonNull VariableExp> qvtrArguments = new ArrayList<>();
			for (@NonNull RelInvocationEdge relInvocationEdge : UMLXUtil.getOwnedRelInvocationEdges(relInvocationNode)) {
				//					relInvocationEdge.get
				RelPatternNode referredRelPatternNode = UMLXUtil.getInvokingRelPatternNode(relInvocationEdge); //UMLXUtil.getReferredRelPatternNode(relInvocationEdge);
				Variable qvtrVariable = context.getQVTrElement(Variable.class, referredRelPatternNode);
				qvtrArguments.add(context.createVariableExp(qvtrVariable));
			}
			RelDiagram referredRelDiagram = UMLXUtil.getReferredRelDiagram(relInvocationNode);
			Relation qvtrReferredRelation = context.getQVTrElement(Relation.class, referredRelDiagram);
			RelationCallExp qvtrRelationCallExp = context.createRelationCallExp(qvtrReferredRelation, qvtrArguments);
			RelDiagram relDiagram = UMLXUtil.getOwningRelDiagram(relInvocationNode);
			Relation qvtrRelation = context.getQVTrElement(Relation.class, relDiagram);
			if (!relInvocationNode.isIsThen()) {
				context.addWhenPredicate(qvtrRelation, qvtrRelationCallExp);
			}
			else {
				context.addWherePredicate(qvtrRelation, qvtrRelationCallExp);
			}
			return qvtrRelationCallExp;
		}

		@Override
		public @Nullable Element visitRelPatternExpressionNode( @NonNull RelPatternExpressionNode relPatternExpressionNode) {
			StringLiteralExp stringExpression = context.getQVTrElement(StringLiteralExp.class, relPatternExpressionNode);
			String textExpression = stringExpression.getStringSymbol();
			final EObject eContainer = stringExpression.eContainer();
			//			context.getEnvironmentFactory().getMetamodelManager().parseSpecification(specification);
			ParserContext parserContext = new AbstractParserContext(context.getEnvironmentFactory(), null) {

				@Override
				public @Nullable ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {

					EObject pivot = eContainer;
					if ((pivot instanceof Element) && (pivot.eResource() != null) && !(pivot instanceof InvalidType)) {
						environmentView.computeLookups((Element) pivot, null); //PivotUtil.getPivot(Element.class, scopeView.getChild());
					}
					return scopeView.getParent();
				}
			};
			//			if (parserContext == null) {
			//				throw new ParserException(PivotMessagesInternal.UnknownContextType_ERROR_, NameUtil.qualifiedNameFor(contextElement), PivotUtilInternal.getSpecificationRole(specification));
			//			}
			parserContext.setRootElement((Element) eContainer);
			try {
				ExpressionInOCL expressionInOCL = parserContext.parse(eContainer, textExpression);
				if (expressionInOCL != null) {
					OCLExpression qvtrExpression = expressionInOCL.getOwnedBody();
					EReference eContainmentFeature = stringExpression.eContainmentFeature();
					PivotUtilInternal.resetContainer(stringExpression);
					PivotUtilInternal.resetContainer(qvtrExpression);
					eContainer.eSet(eContainmentFeature, qvtrExpression);
				}
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}

	private final @NonNull Resource umlxResource;
	private final @NonNull Resource qvtrResource;
	private final @NonNull Map<@NonNull UMLXElement, @NonNull Element> umlx2qvtr = new HashMap<>();
	private final @NonNull Set<@NonNull UMLXElement> references = new HashSet<>();

	public UMLX2QVTr(@NonNull EnvironmentFactory environmentFactory, @NonNull Resource umlxResource, @NonNull Resource qvtrResource) {
		super(environmentFactory);
		this.umlxResource = umlxResource;
		this.qvtrResource = qvtrResource;
	}

	public void addReference(@NonNull UMLXElement umlxElement) {
		references.add(umlxElement);
	}

	protected <T extends Element> @Nullable T basicGetQVTrElement(@NonNull Class<T> qvtrClass, @NonNull UMLXElement umlxElement) {
		Element qvtrElement = umlx2qvtr.get(umlxElement);
		if (qvtrElement == null) {
			return null;
		}
		if (!qvtrClass.isAssignableFrom(qvtrElement.getClass())) {
			throw new ClassCastException("QVTr element " + umlxElement + " cannot be cast to " + qvtrClass);
		}
		@SuppressWarnings("unchecked")T castElement = (T)qvtrElement;
		return castElement;
	}

	public @Nullable EStructuralFeature getEcoreOf(@NonNull Property qvtrProperty) {
		EStructuralFeature ecoreOfPivot = environmentFactory.getMetamodelManager().getEcoreOfPivot(EStructuralFeature.class, qvtrProperty);
		return ecoreOfPivot;
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	public @NonNull String getProjectName(@NonNull URI traceURI) {
		URI trimFileExtension = traceURI.trimFileExtension();
		if (trimFileExtension.isPlatform()) {
			return trimFileExtension.segment(1);
		}
		else {
			return trimFileExtension.segment(0);
		}
	}

	protected <T extends Element> @NonNull T getQVTrElement(@NonNull Class<T> qvtrClass, @NonNull UMLXElement umlxElement) {
		Element qvtrElement = umlx2qvtr.get(umlxElement);
		if (qvtrElement == null) {
			throw new IllegalArgumentException("Missing UMLX element for " + umlxElement);
		}
		if (!qvtrClass.isAssignableFrom(qvtrElement.getClass())) {
			throw new ClassCastException("QVTr element " + umlxElement + " cannot be cast to " + qvtrClass);
		}
		@SuppressWarnings("unchecked")T castElement = (T)qvtrElement;
		return castElement;
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return environmentFactory.getStandardLibrary();
	}

	/**
	 * Create a new trace for the given list of generated objects for the given
	 * context.
	 */
	protected void install(@NonNull UMLXElement umlxElement, @NonNull Element qvtrElement) {
		Element oldQVTrElement = umlx2qvtr.put(umlxElement, qvtrElement);
		assert oldQVTrElement == null;
		for (@NonNull String comment : UMLXUtil.getComments(umlxElement)) {
			qvtrElement.getOwnedComments().add(createComment(comment));
		}
	}

	public void transform() throws CompilerChainException {
		for (EObject eObject : umlxResource.getContents()) {
			if (eObject instanceof UMLXModel) {
				RelationModel qvtrModel = QVTrelationFactory.eINSTANCE.createRelationModel();
				qvtrModel.setExternalURI(qvtrResource.getURI().toString());
				((UMLXModel)eObject).accept(new CreateVisitor(this, qvtrModel));
				qvtrResource.getContents().add(qvtrModel);
			}
		}
		if (!references.isEmpty()) {
			ReferenceVisitor referenceVisitor = new ReferenceVisitor(this);
			for (@NonNull UMLXElement element : references) {
				element.accept(referenceVisitor);
			}
		}
	}
}
