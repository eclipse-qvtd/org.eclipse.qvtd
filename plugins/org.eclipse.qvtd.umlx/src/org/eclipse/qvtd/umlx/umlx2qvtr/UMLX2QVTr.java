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
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.NameUtil;
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
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelInvocationEdge;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.RelNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxImportNode;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.TxPartNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXEdge;
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
		private final @NonNull Map<@NonNull RelPatternNode, @NonNull OCLExpression> relPatternNode2qvtrExpression = new HashMap<>();
		private final @NonNull Set<@NonNull RelPatternEdge> connectedEdges = new HashSet<>();

		public ConnectionHelper(@NonNull UMLX2QVTr context) {
			this.context = context;
			this.metamodelManager = context.getMetamodelManager();
		}

		private void connect(@NonNull ObjectTemplateExp sourceTemplateExp, @NonNull EStructuralFeature eStructuralFeature, @NonNull OCLExpression targetExpression) {
			Property asProperty = metamodelManager.getASOfEcore(Property.class, eStructuralFeature);
			assert asProperty != null;
			//			if (txPartNode.isIsOpposite()) {
			//				asProperty = asProperty.getOpposite();
			//			}
			PropertyTemplateItem qvtrPropertyTemplateItem = context.createPropertyTemplateItem(asProperty, targetExpression);
			QVTrelationUtil.Internal.getOwnedPartsList(sourceTemplateExp).add(qvtrPropertyTemplateItem);
		}

		private void connect(@NonNull RelPatternNode sourceNode, @NonNull EStructuralFeature eStructuralFeature, @NonNull RelPatternNode targetNode) {
			ObjectTemplateExp sourceTemplateExp = (ObjectTemplateExp) relPatternNode2qvtrExpression.get(sourceNode);
			OCLExpression targetTemplateExp = relPatternNode2qvtrExpression.get(targetNode);
			assert sourceTemplateExp != null;
			if (targetTemplateExp == null) {
				SharedVariable sharedVariable = context.getQVTrElement(SharedVariable.class, targetNode);
				targetTemplateExp = context.createVariableExp(sharedVariable);
			}
			connect(sourceTemplateExp, eStructuralFeature, targetTemplateExp);
		}

		private @NonNull Iterable<@NonNull RelPatternNode> connectComplexEdges(@NonNull RelPatternNode relNode) {
			List<@NonNull RelPatternNode> newNodes = new ArrayList<>();
			/*				for (@NonNull RelPatternEdge relEdge : UMLXUtil.getOutgoingEdges(relNode)) {
						if (!connectedEdges.contains(relEdge)) {
							EStructuralFeature eStructuralFeature = UMLXUtil.getReferredProperty(relEdge);
							if (eStructuralFeature.isMany() && (eStructuralFeature instanceof EReference)) {
								EReference eOpposite = ((EReference)eStructuralFeature).getEOpposite();
								if (eOpposite != null) {

								}
								else {
									RelPatternNode targetNode = UMLXUtil.getTarget(relEdge);
									connect2(connectionHelper, targetNode,
										eStructuralFeature, relNode);
									newNodes.add(targetNode);
									connectedEdges.add(relEdge);
								}
							}
						}
					}
					for (@NonNull RelPatternEdge relEdge : UMLXUtil.getIncomingEdges(relNode)) {
						if (!connectedEdges.contains(relEdge)) {
							EStructuralFeature eStructuralFeature = UMLXUtil.getReferredProperty(relEdge);
							if (eStructuralFeature.isMany() && (eStructuralFeature instanceof EReference)) {
								RelPatternNode sourceNode = UMLXUtil.getSource(relEdge);
								ObjectTemplateExp targetTemplateExp = (ObjectTemplateExp) get(relNode);
								OCLExpression sourceTemplateExp = get(sourceNode);
								assert targetTemplateExp != null;
								if (sourceTemplateExp == null) {
									SharedVariable sharedVariable = context.getQVTrElement(SharedVariable.class, sourceNode);
									sourceTemplateExp = context.createVariableExp(sharedVariable);
								}
								connect((ObjectTemplateExp) sourceTemplateExp, eStructuralFeature, targetTemplateExp);
								newNodes.add(sourceNode);
								connectedEdges.add(relEdge);
							}
						}
					} */
			return newNodes;
		}

		public void connectNodes(@NonNull Iterable<@NonNull RelPatternNode> relRootPatternNodes) {
			List<@NonNull RelPatternNode> connectedNodes = Lists.newArrayList(relRootPatternNodes);
			for (int i = 0; i < connectedNodes.size(); i++) {
				RelPatternNode connectableNode = connectedNodes.get(i);
				//				connectableNode.toString();
				Iterable<@NonNull RelPatternNode> newNodes = connectSimpleEdges(connectableNode);
				for (@NonNull RelPatternNode newNode : newNodes) {
					if (!connectedNodes.contains(newNode)) {
						connectedNodes.add(newNode);
					}
				}
			}
			for (int i = 0; i < connectedNodes.size(); i++) {
				RelPatternNode connectableNode = connectedNodes.get(i);
				Iterable<@NonNull RelPatternNode> newNodes = connectComplexEdges(connectableNode);
				for (@NonNull RelPatternNode newNode : newNodes) {
					if (!connectedNodes.contains(newNode)) {
						connectedNodes.add(newNode);
					}
				}
				for (int j = i; j < connectedNodes.size(); j++) {
					RelPatternNode connectableNode2 = connectedNodes.get(j);
					Iterable<@NonNull RelPatternNode> newNodes2 = connectSimpleEdges(connectableNode2);
					for (@NonNull RelPatternNode newNode : newNodes2) {
						if (!connectedNodes.contains(newNode)) {
							connectedNodes.add(newNode);
						}
					}
				}
			}
		}

		private @NonNull Iterable<@NonNull RelPatternNode> connectSimpleEdges(@NonNull RelPatternNode relNode) {
			List<@NonNull RelPatternNode> newNodes = new ArrayList<>();
			for (@NonNull RelPatternEdge relEdge : UMLXUtil.getOutgoingEdges(relNode)) {
				if (!connectedEdges.contains(relEdge)) {
					RelPatternNode sourceNode = relNode;
					EStructuralFeature eStructuralFeature = UMLXUtil.getReferredProperty(relEdge);
					RelPatternNode targetNode = UMLXUtil.getTarget(relEdge);
					if (connectSimpleEdge(sourceNode, eStructuralFeature, targetNode)) {
						newNodes.add(targetNode);
						connectedEdges.add(relEdge);
					}
				}
			}
			for (@NonNull RelPatternEdge relEdge : UMLXUtil.getIncomingEdges(relNode)) {
				if (!connectedEdges.contains(relEdge)) {
					RelPatternNode sourceNode = UMLXUtil.getSource(relEdge);
					EStructuralFeature eStructuralFeature = UMLXUtil.getReferredProperty(relEdge);
					RelPatternNode targetNode = relNode;
					if (connectSimpleEdge(sourceNode, eStructuralFeature, targetNode)) {
						newNodes.add(targetNode);
						connectedEdges.add(relEdge);
					}
				}
			}
			return newNodes;
		}

		private boolean connectSimpleEdge(@NonNull RelPatternNode sourceNode, @NonNull EStructuralFeature eStructuralFeature, @NonNull RelPatternNode targetNode) {
			if (eStructuralFeature instanceof EAttribute) {
				EAttribute eAttribute = (EAttribute)eStructuralFeature;
				connect(sourceNode, eAttribute, targetNode);
				return true;
			}
			EReference eReference = (EReference)eStructuralFeature;
			if (!eReference.isMany()) {
				connect(sourceNode, eReference, targetNode);
				return true;
			}
			EReference eOpposite = eReference.getEOpposite();
			if (eOpposite != null) {
				connect(targetNode, eOpposite, sourceNode);
				return true;
			}
			return false;
		}

		private OCLExpression get(@NonNull RelPatternNode relPatternNode) {
			return relPatternNode2qvtrExpression.get(relPatternNode);
		}

		private void put(@NonNull RelPatternNode relPatternNode, @NonNull OCLExpression qvtrExpression) {
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
		private @NonNull OCLExpression createDomainPatternNodes(@NonNull RelPatternNode relPatternNode, @NonNull ConnectionHelper connectionHelper) {
			OCLExpression qvtrTemplateExp = connectionHelper.get(relPatternNode);
			if (qvtrTemplateExp == null) {
				TemplateVariable asVariable = visit(TemplateVariable.class, relPatternNode);
				org.eclipse.ocl.pivot.Class asClass = metamodelManager.getASOfEcore(org.eclipse.ocl.pivot.Class.class, relPatternNode.getReferredClass());
				assert asClass != null;
				qvtrTemplateExp = context.createObjectTemplateExp(asVariable, asClass, relPatternNode.isIsRequired());
				//				context.putUMLX2QVTrTrace(relPatternNode, qvtrTemplateExp);
				connectionHelper.put(relPatternNode, qvtrTemplateExp);
				for (UMLXEdge relEdge : relPatternNode.getOwnedOutgoingEdges()) {
					if (relEdge instanceof RelPatternEdge) {
						RelPatternEdge relPatternEdge = (RelPatternEdge)relEdge;
						RelPatternNode relTargetNode = UMLXUtil.getTarget(relPatternEdge);
						EStructuralFeature eStructuralFeature = relPatternEdge.getReferredProperty();
						if (eStructuralFeature instanceof EReference) {
							createDomainPatternNodes(relTargetNode, connectionHelper);
						}
					}
				}
				for (UMLXEdge relEdge : relPatternNode.getIncomingEdges()) {
					if (relEdge instanceof RelPatternEdge) {
						RelPatternEdge relPatternEdge = (RelPatternEdge)relEdge;
						RelPatternNode relSourceNode = UMLXUtil.getSource(relPatternEdge);
						EStructuralFeature eStructuralFeature = relPatternEdge.getReferredProperty();
						if (eStructuralFeature instanceof EReference) {
							createDomainPatternNodes(relSourceNode, connectionHelper);
						}
					}
				}
			}
			return qvtrTemplateExp;
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
			Iterable<@NonNull RelNode> relNodes = UMLXUtil.getOwnedNodes(relDiagram);
			List<@NonNull RelPatternNode> relRootPatternNodes = new ArrayList<>();
			for (@NonNull RelNode relNode : relNodes) {
				if (relNode instanceof RelDomainNode) {
					RelDomainNode relDomainNode = (RelDomainNode) relNode;
					//
					//	Create the RelationDomain
					//
					RelationDomain qvtrRelationDomain = visit(RelationDomain.class, relDomainNode);
					qvtrRelationDomains.add(qvtrRelationDomain);
					//
					//	Create each DomainPattern, TemplateExp and TemplateVariable
					//
					for (@NonNull RelPatternNode relRootPatternNode : UMLXUtil.getRootPatternNodes(relDomainNode)) {
						OCLExpression qvtrTemplateExp = createDomainPatternNodes(relRootPatternNode, connectionHelper);
						DomainPattern qvtrRootPattern = context.createDomainPattern((ObjectTemplateExp)qvtrTemplateExp);
						qvtrRelationDomain.getPattern().add(qvtrRootPattern);
						relRootPatternNodes.add(relRootPatternNode);
					}
				}
				else if (relNode instanceof RelInvocationNode) {
					visit(relNode);
				}
			}
			//
			//	Gather the TemplateVariables, create the SharedVariables
			//
			List<@NonNull Variable> qvtrAllVariables = new ArrayList<>();
			for (@NonNull RelNode relNode : relNodes) {
				if (relNode instanceof RelPatternNode) {
					RelPatternNode relPatternNode = (RelPatternNode) relNode;
					Variable asVariable = context.basicGetQVTrElement(TemplateVariable.class, relPatternNode);
					if (asVariable == null) {
						asVariable = visit(SharedVariable.class, relPatternNode);
					}
					qvtrAllVariables.add(asVariable);
				}
			}
			//
			//	Establish the TemplateVariable interrelationships
			//
			connectionHelper.connectNodes(relRootPatternNodes);
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
			TxTypedModelNode txTypedModelNode = UMLXUtil.getReferredTypedModelNode(relDomainNode);
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
		public @Nullable Element visitRelPatternNode(@NonNull RelPatternNode relPatternNode) {
			EClassifier eClassifier = UMLXUtil.getReferredClassifier(relPatternNode);
			if (eClassifier instanceof EClass) {
				org.eclipse.ocl.pivot.Class asClass = metamodelManager.getASOfEcore(org.eclipse.ocl.pivot.Class.class, eClassifier);
				assert asClass != null;
				Variable asVariable = context.createTemplateVariable(UMLXUtil.getName(relPatternNode), asClass, relPatternNode.isIsRequired(), null);
				context.install(relPatternNode, asVariable);
				return asVariable;
			}
			else {
				DataType asDataType = metamodelManager.getASOfEcore(DataType.class, eClassifier);
				assert asDataType != null;
				Variable asVariable = context.createSharedVariable(UMLXUtil.getName(relPatternNode), asDataType, relPatternNode.isIsRequired(), null);
				context.install(relPatternNode, asVariable);
				return asVariable;
			}
		}

		@Override
		public @Nullable Element visitTxDiagram(@NonNull TxDiagram txDiagram) {
			List<@NonNull Key> qvtrKeys = new ArrayList<>();
			createAll(UMLXUtil.getTxKeyNodes(txDiagram), qvtrKeys);
			List<@NonNull TypedModel> qvtrTypedModels = new ArrayList<>();
			createAll(UMLXUtil.getTxTypedModelNodes(txDiagram), qvtrTypedModels);
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
			createAll(UMLXUtil.getOwnedDiagrams(txDiagram), allRelationsList);
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
			EClass eClass = UMLXUtil.getReferredClass(txKeyNode);
			org.eclipse.ocl.pivot.Class asClass = metamodelManager.getASOfEcore(org.eclipse.ocl.pivot.Class.class, eClass);
			assert asClass != null;
			List<@NonNull Property> asProperties = new ArrayList<>();
			createAll(UMLXUtil.getTxPartNodes(txKeyNode), asProperties);
			Key asKey = context.createKey(asClass, asProperties);
			context.install(txKeyNode, asKey);
			return asKey;
		}

		@Override
		public @Nullable Element visitTxPackageNode(@NonNull TxPackageNode txPackageNode) {
			EPackage ePackage = UMLXUtil.getReferredPackage(txPackageNode);
			return metamodelManager.getASOfEcore(org.eclipse.ocl.pivot.Package.class, ePackage);
		}

		@Override
		public @Nullable Element visitTxPartNode(@NonNull TxPartNode txPartNode) {
			EStructuralFeature eStructuralFeature = UMLXUtil.getReferredProperty(txPartNode);
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
			createAll(UMLXUtil.getTxPackageNodes(txTypedModelNode), usedPackages);
			TypedModel asTypedModel = context.createTypedModel(UMLXUtil.getName(txTypedModelNode), usedPackages);
			context.install(txTypedModelNode, asTypedModel);
			return asTypedModel;
		}

		@Override
		public @Nullable Element visitUMLXModel(@NonNull UMLXModel umlxModel) {
			qvtrModel.setExternalURI(context.qvtrResource.getURI().toString());
			context.install(umlxModel, qvtrModel);
			Iterable<@NonNull TxDiagram> txDiagrams = UMLXUtil.getOwnedDiagrams(umlxModel);
			visitAll(txDiagrams);
			List<@NonNull TxImportNode> txImports = new ArrayList<>();
			for (@NonNull TxDiagram txDiagram : txDiagrams) {
				Iterables.addAll(txImports, UMLXUtil.getTxImportNodes(txDiagram));
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
			for (UMLXEdge edge : relInvocationNode.getOwnedOutgoingEdges()) {
				if (edge instanceof RelInvocationEdge) {
					RelInvocationEdge relInvocationEdge = (RelInvocationEdge)edge;
					//					relInvocationEdge.get
					RelPatternNode referredRelPatternNode = UMLXUtil.getTarget(relInvocationEdge); //UMLXUtil.getReferredRelPatternNode(relInvocationEdge);
					Variable qvtrVariable = context.getQVTrElement(Variable.class, referredRelPatternNode);
					qvtrArguments.add(context.createVariableExp(qvtrVariable));
				}
			}
			RelDiagram referredRelDiagram = UMLXUtil.getReferredRelDiagram(relInvocationNode);
			Relation qvtrReferredRelation = context.getQVTrElement(Relation.class, referredRelDiagram);
			RelationCallExp qvtrRelationCallExp = context.createRelationCallExp(qvtrReferredRelation, qvtrArguments);
			RelDiagram relDiagram = UMLXUtil.getDiagram(relInvocationNode);
			Relation qvtrRelation = context.getQVTrElement(Relation.class, relDiagram);
			if (!relInvocationNode.isIsThen()) {
				context.addWhenPredicate(qvtrRelation, qvtrRelationCallExp);
			}
			else {
				context.addWherePredicate(qvtrRelation, qvtrRelationCallExp);
			}
			return qvtrRelationCallExp;
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
