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
package org.eclipse.qvtd.umlx.qvtr2umlx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.SharedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.util.AbstractExtendingQVTrelationVisitor;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelInvocationEdge;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
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
import org.eclipse.qvtd.umlx.UMLXFactory;
import org.eclipse.qvtd.umlx.UMLXModel;
import org.eclipse.qvtd.umlx.UMLXTypedElement;
import org.eclipse.qvtd.umlx.utilities.UMLXUtil;

import com.google.common.collect.Iterables;

public class QVTr2UMLX
{
	protected static abstract class AbstractVisitor extends AbstractExtendingQVTrelationVisitor<@Nullable UMLXElement, @NonNull QVTr2UMLX>
	{
		public AbstractVisitor(@NonNull QVTr2UMLX context) {
			super(context);
		}

		protected <T1 extends Element, T2 extends UMLXElement> @Nullable T2 create(@Nullable T1 source) {
			if (source == null) {
				return null;
			}
			@SuppressWarnings("unchecked") @Nullable T2 target = (T2) source.accept(this);
			return target;
		}

		protected <@NonNull T1 extends Element, T2 extends UMLXElement> void createAll(/*@NonNull*/ Iterable<T1> sources, /*@NonNull*/ List<? super T2> targets) {
			for (T1 source : sources) {
				@SuppressWarnings("unchecked") T2 target = (T2) source.accept(this);
				if ((target != null) && (targets != null)) {
					targets.add(target);
				}
			}
		}

		protected void setReferredEType(@NonNull UMLXTypedElement umlxTypedElement, @NonNull TypedElement qvtrTypedElement) {
			umlxTypedElement.setIsRequired(qvtrTypedElement.isIsRequired());
			Type qvtrType = PivotUtil.getType(qvtrTypedElement);
			if (qvtrType instanceof CollectionType) {
				CollectionType qvtrCollectionType = (CollectionType)qvtrType;
				umlxTypedElement.setIsMany(true);
				umlxTypedElement.setIsNullFree(qvtrCollectionType.isIsNullFree());
				umlxTypedElement.setIsOrdered(qvtrCollectionType.isOrdered());
				umlxTypedElement.setIsUnique(qvtrCollectionType.isUnique());
				qvtrType = PivotUtil.getElementalType(qvtrCollectionType);
			}
			umlxTypedElement.setReferredEClassifier(context.getEcoreOf(qvtrType));
		}

		protected <T extends UMLXElement> @NonNull T visit(@NonNull Class<T> umlxClass, @NonNull Element qvtrElement) {
			UMLXElement umlxElement = qvtrElement.accept(this);
			if (umlxElement == null) {
				throw new IllegalArgumentException("Missing UMLX element for " + qvtrElement);
			}
			if (!umlxClass.isAssignableFrom(umlxElement.getClass())) {
				throw new ClassCastException("UMLX element " + umlxElement + " cannot be cast to " + umlxClass);
			}
			@SuppressWarnings("unchecked")T castElement = (T)umlxElement;
			return castElement;
		}

		//		@Override
		//		public @Nullable String visitOCLExpression(@NonNull OCLExpression qvtrExpression) {
		//			return PrettyPrinter.print(qvtrExpression);
		//		}

		@Override
		public @Nullable UMLXElement visitOCLExpression(@NonNull OCLExpression qvtrExpression) {
			RelDomainNode relDomainNode = context.getContainingRelDomainNode(qvtrExpression);
			RelPatternNode relPatternExpressionNode = UMLXFactory.eINSTANCE.createRelPatternNode();
			context.install(qvtrExpression, relPatternExpressionNode);
			for (String line : PrettyPrinter.print(qvtrExpression).split("\\n")) {
				relPatternExpressionNode.getInitExpressionLines().add(line);
			}
			relDomainNode.getOwnedRelPatternNodes().add(relPatternExpressionNode);
			return relPatternExpressionNode;
		}

		@Override
		public @Nullable RelPatternNode visitVariableExp(@NonNull VariableExp qvtrVariableExp) {
			RelPatternNode relPatternNode = context.getUMLXElement(RelPatternNode.class, PivotUtil.getReferredVariable(qvtrVariableExp));
			return relPatternNode;
		}

		@Override
		public @Nullable UMLXElement visiting(@NonNull Visitable visitable) {
			//			System.out.println("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
			//			return null;
			throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
		}
	}

	protected static class CreateRelationVisitor extends AbstractVisitor
	{
		protected final @NonNull Relation qvtrRelation;
		private final @NonNull Map<@NonNull VariableDeclaration, @NonNull List<@NonNull RelationDomain>> variable2domains  = new HashMap<>();
		private @Nullable List<@NonNull RelPatternNode> ownedPrimitiveNodes = null;
		private final @NonNull RelDiagram relDiagram;

		public CreateRelationVisitor(@NonNull QVTr2UMLX context, @NonNull Relation qvtrRelation) {
			super(context);
			this.qvtrRelation = qvtrRelation;
			for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(qvtrRelation)) {
				analyzeTree(rDomain, rDomain);
			}
			Pattern rWhen = qvtrRelation.getWhen();
			if (rWhen != null) {
				analyzeTree(rWhen, null);
			}
			Pattern rWhere = qvtrRelation.getWhere();
			if (rWhere != null) {
				analyzeTree(rWhere, null);
			}
			for (@NonNull Variable rVariable : QVTrelationUtil.getOwnedVariables(qvtrRelation)) {
				OCLExpression rExpression = rVariable.getOwnedInit();
				if (rExpression != null) {
					List<@NonNull RelationDomain> referencedDomains = analyzeTree(rExpression, null);
					for (@NonNull RelationDomain rDomain : referencedDomains) {
						add(rVariable, rDomain);
					}
				}
			}
			this.relDiagram = UMLXFactory.eINSTANCE.createRelDiagram();
		}

		private @NonNull List<@NonNull RelationDomain> add(@NonNull VariableDeclaration variable, @Nullable RelationDomain rDomain) {
			List<@NonNull RelationDomain> domains = variable2domains.get(variable);
			if (domains == null) {
				domains = new ArrayList<>();
				variable2domains.put(variable, domains);
			}
			if ((rDomain != null) && !domains.contains(rDomain)) {		// FIXME null can be resolved from RelationCallExp arg
				domains.add(rDomain);
			}
			return domains;
		}

		private @NonNull List<@NonNull RelationDomain> analyzeTree(@NonNull Element rElement, @Nullable RelationDomain rDomain) {
			List<@NonNull RelationDomain> referencedDomains = new ArrayList<>();
			for (EObject eObject : new TreeIterable(rElement, true)) {
				VariableDeclaration variable =null;
				if (eObject instanceof VariableExp) {
					variable = PivotUtil.getReferredVariable((VariableExp)eObject);
				}
				else if (eObject instanceof TemplateExp) {
					variable = QVTrelationUtil.getBindsTo((TemplateExp)eObject);
				}
				if (variable != null) {
					for (@NonNull RelationDomain domain : add(variable, rDomain)) {
						if (!referencedDomains.contains(domain)) {
							referencedDomains.add(domain);
						}
					}
				}
			}
			return referencedDomains;
		}

		protected @NonNull RelPatternNode createRelPatternClassNode(@NonNull TypedElement qvtrTypedElement) {
			RelPatternNode relPatternClassNode = UMLXFactory.eINSTANCE.createRelPatternNode();
			context.install(qvtrTypedElement, relPatternClassNode);
			boolean isImplicit = (qvtrTypedElement instanceof Variable) && ((Variable)qvtrTypedElement).isIsImplicit();
			if (isImplicit) {
				relPatternClassNode.setIsAnon(true);
				relPatternClassNode.setName("");
			}
			else {
				relPatternClassNode.setIsAnon(false);
				relPatternClassNode.setName(qvtrTypedElement.getName());
			}
			setReferredEType(relPatternClassNode, qvtrTypedElement);
			return relPatternClassNode;
		}

		private @NonNull List<@NonNull RelPatternNode> getPrimitiveNodes() {
			List<@NonNull RelPatternNode> ownedPrimitiveNodes2 = ownedPrimitiveNodes;
			if (ownedPrimitiveNodes2 == null) {
				RelDomainNode relDomainNode = context.getPrimitiveRelDomainNode(relDiagram);
				ownedPrimitiveNodes = ownedPrimitiveNodes2 = UMLXUtil.Internal.getOwnedRelPatternNodesList(relDomainNode);
			}
			return ownedPrimitiveNodes2;
		}

		@Override
		public @NonNull String toString() {
			StringBuilder s = new StringBuilder();
			s.append(qvtrRelation.getName());
			List<@NonNull VariableDeclaration> variables = new ArrayList<>(variable2domains.keySet());
			Collections.sort(variables, NameUtil.NAMEABLE_COMPARATOR);
			for (@NonNull VariableDeclaration variable : variables) {
				List<@NonNull RelationDomain> domains = variable2domains.get(variable);
				assert domains != null;
				s.append("\n\t'");
				s.append(variable.getName());
				s.append("' =>");
				for (@NonNull RelationDomain domain : domains) {
					s.append(" '");
					s.append(domain.getName());
					s.append("'");
				}
			}
			return s.toString();
		}

		@Override
		public @Nullable UMLXElement visitRelation(@NonNull Relation qvtrRelation) {
			context.install(qvtrRelation, relDiagram);
			relDiagram.setIsTop(qvtrRelation.isIsTopLevel());
			relDiagram.setName(qvtrRelation.getName());
			//
			//	Create the domains and their variables
			//
			createAll(QVTrelationUtil.getOwnedDomains(qvtrRelation), relDiagram.getOwnedRelDomainNodes());
			//
			//	Create the primitive domain and its variables
			//
			for (@NonNull Variable qvtrVariable : QVTrelationUtil.getOwnedVariables(qvtrRelation)) {
				RelPatternNode relPatternClassNode = context.basicGetUMLXElement(RelPatternNode.class, qvtrVariable);
				if (relPatternClassNode == null) {
					relPatternClassNode = createRelPatternClassNode(qvtrVariable);
					OCLExpression ownedInit = qvtrVariable.getOwnedInit();
					if (ownedInit != null) {
						for (String line : PrettyPrinter.print(ownedInit).split("\\n")) {
							relPatternClassNode.getInitExpressionLines().add(line);
						}
					}
					List<@NonNull RelPatternNode> ownedNodes = null;
					List<@NonNull RelationDomain> qvtrDomains = variable2domains.get(qvtrVariable);
					if (qvtrDomains == null) {
						System.out.println("Dead variable " + qvtrRelation.getName() + "." + qvtrVariable.getName());
					}
					else if (qvtrDomains.size() == 1) {
						RelationDomain qvtrDomain = qvtrDomains.get(0);
						RelDomainNode relDomainNode = context.basicGetUMLXElement(RelDomainNode.class, qvtrDomain);
						assert relDomainNode != null;
						ownedNodes = UMLXUtil.Internal.getOwnedRelPatternNodesList(relDomainNode);
					}
					if (ownedNodes == null) {
						ownedNodes = getPrimitiveNodes();
					}
					ownedNodes.add(relPatternClassNode);
				}
			}
			//
			//	Create the when predicate
			//
			Pattern qvtrWhen = qvtrRelation.getWhen();
			if (qvtrWhen != null) {
				for (@NonNull Predicate qvtrPredicate : QVTrelationUtil.getPredicates(qvtrWhen)) {
					QVTrelationUtil.getConditionExpression(qvtrPredicate).accept(this);
				}
			}
			//
			//	Create the where predicate
			//
			Pattern qvtrWhere = qvtrRelation.getWhere();
			if (qvtrWhere != null) {
				for (@NonNull Predicate qvtrPredicate : QVTrelationUtil.getPredicates(qvtrWhere)) {
					QVTrelationUtil.getConditionExpression(qvtrPredicate).accept(this);
				}
			}
			return relDiagram;
		}

		@Override
		public @Nullable UMLXElement visitRelationCallExp(@NonNull RelationCallExp qvtrRelationCallExp) {
			Predicate qvtrPredicate = QVTrelationUtil.getContainingPredicate(qvtrRelationCallExp);
			Relation qvtrRelation = QVTrelationUtil.getContainingRelation(qvtrRelationCallExp);
			Boolean isWhen = null;
			Pattern qvtrWhen = qvtrRelation.getWhen();
			Pattern qvtrWhere = qvtrRelation.getWhere();
			if ((qvtrWhen != null) && Iterables.contains(QVTrelationUtil.getPredicates(qvtrWhen), qvtrPredicate)) {
				isWhen = true;
			}
			else if ((qvtrWhere != null) && Iterables.contains(QVTrelationUtil.getPredicates(qvtrWhere), qvtrPredicate)) {
				isWhen = false;
			}
			RelDiagram relDiagram = context.getUMLXElement(RelDiagram.class, qvtrRelation);
			RelInvocationNode relInvocationNode = UMLXFactory.eINSTANCE.createRelInvocationNode();
			context.install(qvtrRelationCallExp, relInvocationNode);
			relInvocationNode.setIsThen(isWhen == Boolean.FALSE);
			relDiagram.getOwnedRelInvocationNodes().add(relInvocationNode);
			context.addReference(qvtrRelationCallExp);
			return relInvocationNode;
		}

		@Override
		public @Nullable UMLXElement visitRelationDomain(@NonNull RelationDomain qvtrRelationDomain) {
			RelDomainNode relDomainNode = UMLXFactory.eINSTANCE.createRelDomainNode();
			context.install(qvtrRelationDomain, relDomainNode);
			TxTypedModelNode tyTypedModelNode = context.getUMLXElement(TxTypedModelNode.class, QVTrelationUtil.getTypedModel(qvtrRelationDomain));
			relDomainNode.setReferredTxTypedModelNode(tyTypedModelNode);
			if (qvtrRelationDomain.isIsCheckable()) {
				tyTypedModelNode.setCheck(true);
			}
			if (qvtrRelationDomain.isIsEnforceable()) {
				tyTypedModelNode.setEnforce(true);
			}
			for (@NonNull EObject eObject : new TreeIterable(qvtrRelationDomain, false)) {
				if (eObject instanceof TemplateExp) {
					TemplateExp qvtrTemplateExp = (TemplateExp)eObject;
					RelPatternNode relPatternClassNode = createRelPatternClassNode(QVTrelationUtil.getBindsTo(qvtrTemplateExp));
					context.install(qvtrTemplateExp, relPatternClassNode);


					Variable qvtrVariable = qvtrTemplateExp.getBindsTo();
					List<@NonNull RelPatternNode> ownedNodes = null;
					List<@NonNull RelationDomain> qvtrDomains = variable2domains.get(qvtrVariable);
					if (qvtrDomains == null) {
						System.out.println("Dead variable " + qvtrRelation.getName() + "." + qvtrVariable.getName());
					}
					else if (qvtrDomains.size() == 1) {
						ownedNodes = UMLXUtil.Internal.getOwnedRelPatternNodesList(relDomainNode);
					}
					if (ownedNodes == null) {
						ownedNodes = getPrimitiveNodes();
					}
					ownedNodes.add(relPatternClassNode);
					if (eObject instanceof CollectionTemplateExp) {
						CollectionTemplateExp qvtrCollectionTemplateExp = (CollectionTemplateExp)eObject;
						Variable qvtrRestVariable = qvtrCollectionTemplateExp.getRest();
						if (qvtrRestVariable != null) {
							RelPatternNode relPatternRestNode = createRelPatternClassNode(qvtrRestVariable);
							ownedNodes.add(relPatternRestNode);
						}
					}
				}
			}
			context.addReference(qvtrRelationDomain);
			return relDomainNode;
		}
	}

	protected static class CreateTransformationVisitor extends AbstractVisitor
	{
		protected final @NonNull UMLXModel umlxModel;

		public CreateTransformationVisitor(@NonNull QVTr2UMLX context, @NonNull UMLXModel umlxModel) {
			super(context);
			this.umlxModel = umlxModel;
		}

		@Override
		public @Nullable UMLXElement visitFunction(@NonNull Function asFunction) {
			TxQueryNode txQueryNode = UMLXFactory.eINSTANCE.createTxQueryNode();
			context.install(asFunction, txQueryNode);
			txQueryNode.setName(asFunction.getName());
			setReferredEType(txQueryNode, asFunction);
			OCLExpression bodyExpression = asFunction.getQueryExpression();
			if (bodyExpression != null) {
				for (String line : PrettyPrinter.print(bodyExpression).split("\\n")) {
					txQueryNode.getInitExpressionLines().add(line);
				}
			}
			createAll(QVTrelationUtil.getOwnedParameters(asFunction), txQueryNode.getOwnedTxParameterNodes());
			return txQueryNode;
		}

		@Override
		public @Nullable UMLXElement visitFunctionParameter(@NonNull FunctionParameter asFunctionParameter) {
			TxParameterNode txParameterNode = UMLXFactory.eINSTANCE.createTxParameterNode();
			context.install(asFunctionParameter, txParameterNode);
			txParameterNode.setName(asFunctionParameter.getName());
			setReferredEType(txParameterNode, asFunctionParameter);
			return txParameterNode;
		}

		@Override
		public @Nullable UMLXElement visitImport(@NonNull Import asImport) {
			TxImportNode txImportNode = UMLXFactory.eINSTANCE.createTxImportNode();
			context.install(asImport, txImportNode);
			txImportNode.setName(asImport.getName());
			txImportNode.setUri(EcoreUtil.getURI(asImport.getImportedNamespace().getESObject()).toString());
			return txImportNode;
		}

		@Override
		public @Nullable UMLXElement visitKey(@NonNull Key qvtrKey) {
			TxKeyNode txKeyNode = UMLXFactory.eINSTANCE.createTxKeyNode();
			context.install(qvtrKey, txKeyNode);
			txKeyNode.setReferredEClass((EClass) context.getEcoreOf(QVTrelationUtil.getIdentifies(qvtrKey)));
			for (Property qvtrPart : QVTrelationUtil.getOwnedParts(qvtrKey)) {
				TxPartNode txPartNode = UMLXFactory.eINSTANCE.createTxPartNode();
				//				context.addTrace(usedPackage, txPartNode);
				txPartNode.setReferredEStructuralFeature(context.getEcoreOf(qvtrPart));
				txKeyNode.getOwnedTxPartNodes().add(txPartNode);
			}
			for (@NonNull Property qvtrPart : QVTrelationUtil.getOwnedOppositeParts(qvtrKey)) {
				TxPartNode txPartNode = UMLXFactory.eINSTANCE.createTxPartNode();
				//				context.addTrace(usedPackage, txPartNode);
				txPartNode.setReferredEStructuralFeature(context.getEcoreOf(qvtrPart));
				txPartNode.setIsOpposite(true);
				txKeyNode.getOwnedTxPartNodes().add(txPartNode);
			}
			return txKeyNode;
		}

		@Override
		public @Nullable UMLXElement visitPackage(org.eclipse.ocl.pivot.@NonNull Package qvtrPackage) {
			if (PivotConstants.ORPHANAGE_URI.equals(qvtrPackage.getURI())) {
				return null;
			}
			//		    Package umlxPackage = context.createPackage(qvtrPackage);
			createAll(PivotUtil.getOwnedClasses(qvtrPackage), null); //pOut.getOwnedClasses());
			createAll(PivotUtil.getOwnedPackages(qvtrPackage), null); //pOut.getOwnedPackages());
			//		    createAll(qvtrPackage.getOwnedComments(), pOut.getOwnedComments());
			return null;
		}

		@Override
		public @Nullable UMLXElement visitRelation(@NonNull Relation qvtrRelation) {
			CreateRelationVisitor createRelationVisitor = new CreateRelationVisitor(context, qvtrRelation);
			return qvtrRelation.accept(createRelationVisitor);
		}

		@Override
		public @Nullable UMLXElement visitRelationModel(@NonNull RelationModel qvtrModel) {
			String externalURI = qvtrModel.getExternalURI();
			if (externalURI.endsWith(".qvtras")) {
				externalURI = externalURI.replace(".qvtras", ".umlx");
			}
			else if (externalURI.endsWith(".qvtr")) {
				externalURI = externalURI.replace(".qvtr", ".umlx");
			}
			//			umlxModel.setExternalURI(externalURI);
			context.install(qvtrModel, umlxModel);
			//		    createAll(relationModel.getOwnedImports(), umlxModel.getOwnedImports());
			createAll(PivotUtil.getOwnedPackages(qvtrModel), null); //umlxModel.getOwnedPackages());
			//			createAll(relationModel.getOwnedComments(), umlxModel.getOwnedComments());
			return null;
		}

		@Override
		public @Nullable UMLXElement visitRelationalTransformation(@NonNull RelationalTransformation qvtrTransformation) {
			StringBuilder s = new StringBuilder();
			String packagePath = context.getPackagePath(s, QVTbaseUtil.getOwningPackage(qvtrTransformation));
			TxDiagram txDiagram = UMLXFactory.eINSTANCE.createTxDiagram();
			txDiagram.setName(qvtrTransformation.getName());
			txDiagram.setPackage(packagePath);
			context.install(qvtrTransformation, txDiagram);
			//			txTransformationNode.setOwnedContext(create(qvtrTransformation.getOwnedContext()));
			//		    createAll(qvtrTransformation.getOwnedOperations(), txTransformationNode.getOwnedOperations());
			createAll(QVTrelationUtil.getOwnedImports(QVTrelationUtil.getModel(context.qvtrResource)), txDiagram.getOwnedTxImportNodes());
			createAll(QVTrelationUtil.getModelParameters(qvtrTransformation), txDiagram.getOwnedTxTypedModelNodes());
			createAll(QVTrelationUtil.getOwnedKey(qvtrTransformation), txDiagram.getOwnedTxKeyNodes());
			createAll(QVTrelationUtil.getRule(qvtrTransformation), txDiagram.getOwnedRelDiagrams());
			createAll(QVTrelationUtil.getOwnedOperations(qvtrTransformation), txDiagram.getOwnedTxQueryNodes());
			//		    doRules(qvtrTransformation, txTransformationNode);
			//			createAll(qvtrTransformation.getOwnedComments(), txTransformationNode.getOwnedComments());
			umlxModel.getOwnedTxDiagrams().add(txDiagram);
			return null;
		}

		@Override
		public @Nullable UMLXElement visitTypedModel(@NonNull TypedModel qvtrTypedModel) {
			TxTypedModelNode txTypedModelNode = UMLXFactory.eINSTANCE.createTxTypedModelNode();
			context.install(qvtrTypedModel, txTypedModelNode);
			txTypedModelNode.setName(qvtrTypedModel.getName());
			for (org.eclipse.ocl.pivot.@NonNull Package usedPackage : QVTrelationUtil.getUsedPackages(qvtrTypedModel)) {
				TxPackageNode txPackageNode = UMLXFactory.eINSTANCE.createTxPackageNode();
				//				context.addTrace(usedPackage, txPackageNode);
				txPackageNode.setReferredEPackage(usedPackage.getEPackage());
				txTypedModelNode.getOwnedTxPackageNodes().add(txPackageNode);
			}
			if (qvtrTypedModel.getDependsOn().size() > 0) {
				context.addReference(qvtrTypedModel);
			}
			return txTypedModelNode;
		}
	}

	protected static class ReferenceVisitor extends AbstractVisitor
	{
		public ReferenceVisitor(@NonNull QVTr2UMLX context) {
			super(context);
		}

		@Override
		public @Nullable UMLXElement visitCollectionTemplateExp(@NonNull CollectionTemplateExp qvtrCollectionTemplateExp) {
			RelPatternNode relPatternNode = context.getUMLXElement(RelPatternNode.class, qvtrCollectionTemplateExp);
			//			CollectionType qvtrCollectionType = QVTrelationUtil.getReferredCollectionType(qvtrCollectionTemplateExp);
			assert relPatternNode.isIsMany();
			//			relPatternNode.setIsNullFree(qvtrCollectionType.isIsNullFree());
			//			relPatternNode.setIsOrdered(qvtrCollectionType.isOrdered());
			//			relPatternNode.setIsUnique(qvtrCollectionType.isUnique());
			int sourceIndex = 1;
			for (@NonNull OCLExpression qvtrMember : QVTrelationUtil.getOwnedMembers(qvtrCollectionTemplateExp)) {
				RelPatternNode relMemberPatternNode = visit(RelPatternNode.class, qvtrMember);
				RelPatternEdge relPatternEdge = UMLXFactory.eINSTANCE.createRelPatternEdge();
				relPatternEdge.setSourceIndex(sourceIndex);
				relPatternEdge.setSource(relPatternNode);
				relPatternEdge.setTarget(relMemberPatternNode);
				relMemberPatternNode.getOwningRelDomainNode().getOwnedRelPatternEdges().add(relPatternEdge);
				sourceIndex++;
			}
			Variable qvtrRest = qvtrCollectionTemplateExp.getRest();
			if (qvtrRest != null) {
				RelPatternNode relRestPatternNode = visit(RelPatternNode.class, qvtrRest);
				RelPatternEdge relPatternEdge = UMLXFactory.eINSTANCE.createRelPatternEdge();
				relPatternEdge.setSourceIndex(-1);
				relPatternEdge.setSource(relPatternNode);
				relPatternEdge.setTarget(relRestPatternNode);
				relRestPatternNode.getOwningRelDomainNode().getOwnedRelPatternEdges().add(relPatternEdge);
			}
			OCLExpression qvtrWhere = qvtrCollectionTemplateExp.getWhere();
			if (qvtrWhere != null) {
				RelPatternNode relWherePatternNode = (RelPatternNode) qvtrWhere.accept(this);
				relPatternNode.getOwningRelDomainNode().getOwnedRelPatternNodes().add(relWherePatternNode);
			}
			return relPatternNode;
		}

		@Override
		public @Nullable UMLXElement visitObjectTemplateExp(@NonNull ObjectTemplateExp qvtrObjectTemplateExp) {
			RelPatternNode relPatternNode = context.getUMLXElement(RelPatternNode.class, qvtrObjectTemplateExp);
			for (@NonNull PropertyTemplateItem qvtrPropertyTemplateItem : QVTrelationUtil.getOwnedParts(qvtrObjectTemplateExp)) {
				Property partProperty = QVTrelationUtil.getReferredProperty(qvtrPropertyTemplateItem);
				OCLExpression partValue = QVTrelationUtil.getOwnedValue(qvtrPropertyTemplateItem);
				RelPatternNode relPartPatternNode = visit(RelPatternNode.class, partValue);
				RelPatternEdge relPatternEdge = UMLXFactory.eINSTANCE.createRelPatternEdge();
				Property oppositeProperty = partProperty.getOpposite();
				if (partProperty.isIsComposite()) {	// FIXME direction only needs to avoid a null/implicit EReference
					//					relPatternEdge.setIsOpposite(false);
					relPatternEdge.setReferredEStructuralFeature(context.getEcoreOf(partProperty));
					relPatternEdge.setSource(relPatternNode);
					relPatternEdge.setTarget(relPartPatternNode);
				}
				else if ((oppositeProperty != null) && !relPartPatternNode.isExpression() && oppositeProperty.isIsComposite()) {
					//					relPatternEdge.setIsOpposite(false);
					relPatternEdge.setReferredEStructuralFeature(context.getEcoreOf(oppositeProperty));
					relPatternEdge.setSource(relPartPatternNode);
					relPatternEdge.setTarget(relPatternNode);
				}
				else if ((oppositeProperty != null) && !relPartPatternNode.isExpression() && partProperty.isIsImplicit()) {
					//					relPatternEdge.setIsOpposite(true);
					relPatternEdge.setReferredEStructuralFeature(context.getEcoreOf(oppositeProperty));
					relPatternEdge.setSource(relPartPatternNode);
					relPatternEdge.setTarget(relPatternNode);
				}
				else {
					//					relPatternEdge.setIsOpposite(false);
					relPatternEdge.setReferredEStructuralFeature(context.getEcoreOf(partProperty));
					relPatternEdge.setSource(relPatternNode);
					relPatternEdge.setTarget(relPartPatternNode);
				}
				relPartPatternNode.getOwningRelDomainNode().getOwnedRelPatternEdges().add(relPatternEdge);
			}
			OCLExpression qvtrWhere = qvtrObjectTemplateExp.getWhere();
			if (qvtrWhere != null) {
				RelPatternNode relWherePatternNode = (RelPatternNode) qvtrWhere.accept(this);
				relPatternNode.getOwningRelDomainNode().getOwnedRelPatternNodes().add(relWherePatternNode);
			}
			return relPatternNode;
		}

		@Override
		public @Nullable UMLXElement visitRelationCallExp(@NonNull RelationCallExp qvtrRelationCallExp) {
			RelInvocationNode relInvocationNode = context.getUMLXElement(RelInvocationNode.class, qvtrRelationCallExp);
			Relation qvtrReferredRelation = QVTrelationUtil.getReferredRelation(qvtrRelationCallExp);
			RelDiagram relReferredDiagram = context.getUMLXElement(RelDiagram.class, qvtrReferredRelation);
			relInvocationNode.setReferredRelDiagram(relReferredDiagram);
			Iterable<@NonNull Variable> qvtrRootVariables = QVTrelationUtil.getRootVariables(qvtrReferredRelation);
			Iterable<@NonNull OCLExpression> qvtrArguments = QVTrelationUtil.getOwnedArguments(qvtrRelationCallExp);
			Iterator<@NonNull Variable> itRootVariables = qvtrRootVariables.iterator();
			Iterator<@NonNull OCLExpression> itArguments = qvtrArguments.iterator();
			while (itRootVariables.hasNext() && itArguments.hasNext()) {
				Variable qvtrRootVariable = itRootVariables.next();
				OCLExpression qvtrArgument = itArguments.next();
				RelPatternNode umlxRootVariable = context.getUMLXElement(RelPatternNode.class, qvtrRootVariable);
				RelPatternNode relArgumentNode = create(qvtrArgument);
				RelInvocationEdge relInvocationEdge = UMLXFactory.eINSTANCE.createRelInvocationEdge();
				relInvocationEdge.setOwningRelInvocationNode(relInvocationNode);
				relInvocationEdge.setInvokingRelPatternNode(relArgumentNode);
				relInvocationEdge.setReferredRelPatternNode(umlxRootVariable);
			}
			return null;
		}

		@Override
		public @Nullable UMLXElement visitRelationDomain(@NonNull RelationDomain qvtrRelationDomain) {
			RelDomainNode relDomainNode = context.getUMLXElement(RelDomainNode.class, qvtrRelationDomain);
			for (@NonNull DomainPattern qvtrPattern : QVTrelationUtil.getOwnedPatterns(qvtrRelationDomain)) {
				TemplateExp qvtrTemplateExpression = QVTrelationUtil.getOwnedTemplateExpression(qvtrPattern);
				RelPatternNode relPatternNode = context.getUMLXElement(RelPatternNode.class, qvtrTemplateExpression);
				relPatternNode.setIsRoot(true);
				qvtrTemplateExpression.accept(this);
			}
			return relDomainNode;
		}

		@Override
		public @Nullable UMLXElement visitSharedVariable(@NonNull SharedVariable qvtrSharedVariable) {
			RelPatternNode relPatternNode = context.getUMLXElement(RelPatternNode.class, qvtrSharedVariable);
			return relPatternNode;
		}

		@Override
		public @Nullable UMLXElement visitTypedModel(@NonNull TypedModel qvtrTypedModel) {
			TxTypedModelNode txTypedModelNode = context.getUMLXElement(TxTypedModelNode.class, qvtrTypedModel);
			for (@NonNull TypedModel qvtrDependsOn : QVTrelationUtil.getDependsOns(qvtrTypedModel)) {
				TxTypedModelNode txDependsOn = context.getUMLXElement(TxTypedModelNode.class, qvtrDependsOn);
				txTypedModelNode.getDependsOns().add(txDependsOn);
			}
			return txTypedModelNode;
		}
	}

	protected final @NonNull EnvironmentFactory environmentFactory;
	private final @NonNull Resource qvtrResource;
	private final @NonNull Resource umlxResource;
	private final @NonNull Map<@NonNull Element, @NonNull UMLXElement> qvtr2umlx = new HashMap<>();
	private final @NonNull Set<@NonNull Element> references = new HashSet<>();

	public QVTr2UMLX(@NonNull EnvironmentFactory environmentFactory, @NonNull Resource qvtrResource, @NonNull Resource umlxResource) {
		this.environmentFactory = environmentFactory;
		this.qvtrResource = qvtrResource;
		this.umlxResource = umlxResource;
	}

	public void addReference(@NonNull Element qvtrElement) {
		references.add(qvtrElement);
	}

	protected <T extends UMLXElement> @Nullable T basicGetUMLXElement(@NonNull Class<T> umlxClass, @NonNull Element qvtrElement) {
		UMLXElement umlxElement = qvtr2umlx.get(qvtrElement);
		if (umlxElement == null) {
			return null;
		}
		if (!umlxClass.isAssignableFrom(umlxElement.getClass())) {
			throw new ClassCastException("UMLX element " + umlxElement + " cannot be cast to " + umlxClass);
		}
		@SuppressWarnings("unchecked")T castElement = (T)umlxElement;
		return castElement;
	}

	protected @NonNull RelDomainNode getContainingRelDomainNode(@NonNull OCLExpression qvtrExpression) {
		for (EObject eObject = qvtrExpression, eContainer; (eContainer = eObject.eContainer()) != null; eObject = eContainer) {
			if (eContainer instanceof RelationCallExp) {
				RelationCallExp qvtrRelationCallExp = (RelationCallExp) eContainer;
				int argumentIndex = qvtrRelationCallExp.getArgument().indexOf(eObject);
				assert argumentIndex >= 0;
				//				Relation referredRelation = QVTrelationUtil.getReferredRelation(qvtrRelationCallExp);
				RelationDomain referredDomain = QVTrelationUtil.getRelationCallExpArgumentDomain(qvtrRelationCallExp, argumentIndex);
				for (EObject eObject2 = qvtrRelationCallExp, eContainer2; (eContainer2 = eObject2.eContainer()) != null; eObject2 = eContainer2) {
					if (eContainer2 instanceof Relation) {
						Relation qvtrRelation = (Relation) eContainer2;
						RelationDomain rRelationDomain = QVTrelationUtil.getRelationDomain(qvtrRelation, QVTrelationUtil.getTypedModel(referredDomain));
						return getUMLXElement(RelDomainNode.class, rRelationDomain);
					}
				}
			}
			if (eContainer instanceof RelationDomain) {
				return getUMLXElement(RelDomainNode.class, (RelationDomain) eContainer);
			}
		}
		Relation qvtrRelation = QVTrelationUtil.getContainingRelation(qvtrExpression);
		RelDiagram relDiagram = getUMLXElement(RelDiagram.class, qvtrRelation);
		return getPrimitiveRelDomainNode(relDiagram);
	}

	public @Nullable EStructuralFeature getEcoreOf(@NonNull Property qvtrProperty) {
		EStructuralFeature ecoreOfPivot = environmentFactory.getMetamodelManager().getEcoreOfPivot(EStructuralFeature.class, qvtrProperty);
		return ecoreOfPivot;
	}

	public @Nullable EClassifier getEcoreOf(@NonNull Type qvtrType) {
		//		EClassifier ecoreOfPivot = environmentFactory.getMetamodelManager().getEcoreOfPivot(EClassifier.class, qvtrType); // CCE since RelationModel needs derived visitor
		EClassifier ecoreOfPivot = (EClassifier)qvtrType.getESObject();
		if ((ecoreOfPivot == null) && (qvtrType instanceof PrimitiveType)) {
			StandardLibrary standardLibrary = environmentFactory.getStandardLibrary();
			if (qvtrType == standardLibrary.getStringType()) {
				return EcorePackage.Literals.ESTRING;
			}
			else if (qvtrType == standardLibrary.getBooleanType()) {
				return EcorePackage.Literals.EBOOLEAN_OBJECT;
			}
			else if (qvtrType == standardLibrary.getIntegerType()) {
				return EcorePackage.Literals.EBIG_INTEGER;
			}
			else if (qvtrType == standardLibrary.getRealType()) {
				return EcorePackage.Literals.EBIG_DECIMAL;
			}
		}
		return ecoreOfPivot;
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	protected @NonNull String getPackagePath(@NonNull StringBuilder s, @NonNull Namespace qvtrNamespace) {
		EObject eContainer = qvtrNamespace.eContainer();
		if ((eContainer instanceof Namespace) && !(eContainer instanceof Model)) {
			getPackagePath(s, (Namespace)eContainer);
			s.append("::");
		}
		s.append(PivotUtil.getName(qvtrNamespace));
		return s.toString();
	}

	protected @NonNull RelDomainNode getPrimitiveRelDomainNode(@NonNull RelDiagram relDiagram) {
		for (@NonNull RelDomainNode relDomainNode : UMLXUtil.getOwnedRelDomainNodes(relDiagram)) {
			if (relDomainNode.getReferredTxTypedModelNode() == null) {
				return relDomainNode;
			}
		}
		RelDomainNode relDomainNode = UMLXFactory.eINSTANCE.createRelDomainNode();
		//			context.install(qvtrRelationDomain, relDomainNode);
		relDiagram.getOwnedRelDomainNodes().add(relDomainNode);
		return relDomainNode;
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

	public @NonNull StandardLibrary getStandardLibrary() {
		return environmentFactory.getStandardLibrary();
	}

	protected <T extends UMLXElement> @NonNull T getUMLXElement(@NonNull Class<T> umlxClass, @NonNull Element qvtrElement) {
		UMLXElement umlxElement = qvtr2umlx.get(qvtrElement);
		if (umlxElement == null) {
			throw new IllegalArgumentException("Missing UMLX element for " + qvtrElement);
		}
		if (!umlxClass.isAssignableFrom(umlxElement.getClass())) {
			throw new ClassCastException("UMLX element " + umlxElement + " cannot be cast to " + umlxClass);
		}
		@SuppressWarnings("unchecked")T castElement = (T)umlxElement;
		return castElement;
	}

	/**
	 * Create a new trace for the given list of generated objects for the given
	 * context and copy its comments.
	 */
	protected void install(@NonNull Element qvtrElement, @NonNull UMLXElement umlxElement) {
		UMLXElement oldUmlxElement = qvtr2umlx.put(qvtrElement, umlxElement);
		for (@NonNull Comment comment : QVTbaseUtil.getOwnedComments(qvtrElement)) {
			umlxElement.getComments().add(comment.getBody());
		}
		assert oldUmlxElement == null;
	}

	public void transform() throws CompilerChainException {
		for (EObject eObject : qvtrResource.getContents()) {
			if (eObject instanceof RelationModel) {
				UMLXModel umlxModel = UMLXFactory.eINSTANCE.createUMLXModel();
				((Element)eObject).accept(new CreateTransformationVisitor(this, umlxModel));
				umlxResource.getContents().add(umlxModel);
			}
		}
		if (!references.isEmpty()) {
			ReferenceVisitor referenceVisitor = new ReferenceVisitor(this);
			for (@NonNull Element element : references) {
				element.accept(referenceVisitor);
			}
		}
	}
}
