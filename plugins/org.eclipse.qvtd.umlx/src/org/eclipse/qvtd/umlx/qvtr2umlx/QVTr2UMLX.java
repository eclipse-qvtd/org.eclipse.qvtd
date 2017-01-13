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

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.util.AbstractExtendingQVTrelationVisitor;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.umlx.RelConstraintNode;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelInvocationEdge;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.RelNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.TxPartNode;
import org.eclipse.qvtd.umlx.TxTransformationNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXElement;
import org.eclipse.qvtd.umlx.UMLXFactory;
import org.eclipse.qvtd.umlx.UMLXModel;
import org.eclipse.qvtd.umlx.UMLXNode;
import org.eclipse.qvtd.umlx.util.AbstractExtendingUMLXVisitor;

import com.google.common.collect.Iterables;

public class QVTr2UMLX
{
	protected static class CreateVisitor extends AbstractExtendingQVTrelationVisitor<@Nullable UMLXElement, @NonNull QVTr2UMLX>
	{
		protected final @NonNull UMLXModel umlxModel;

		public CreateVisitor(@NonNull QVTr2UMLX context, @NonNull UMLXModel umlxModel) {
			super(context);
			this.umlxModel = umlxModel;
		}

		public <T1 extends Element, T2 extends UMLXElement> @Nullable T2 create(@Nullable T1 source) {
			if (source == null) {
				return null;
			}
			@SuppressWarnings("unchecked") @Nullable T2 target = (T2) source.accept(this);
			return target;
		}

		public <@NonNull T1 extends Element, T2 extends UMLXElement> void createAll(/*@NonNull*/ Iterable<T1> sources, /*@NonNull*/ List<? super T2> targets) {
			for (T1 source : sources) {
				@SuppressWarnings("unchecked") T2 target = (T2) source.accept(this);
				if ((target != null) && (targets != null)) {
					targets.add(target);
				}
			}
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

		@Override
		public @Nullable UMLXElement visitCollectionTemplateExp(@NonNull CollectionTemplateExp qvtrCollectionTemplateExp) {
			RelPatternNode relPatternNode = context.getUMLXElement(RelPatternNode.class, qvtrCollectionTemplateExp);
			/*			for (@NonNull PropertyTemplateItem qvtrPropertyTemplateItem : QVTrelationUtil.getOwnedParts(qvtrObjectTemplateExp)) {
				Property partProperty = QVTrelationUtil.getReferredProperty(qvtrPropertyTemplateItem);
				OCLExpression partValue = QVTrelationUtil.getOwnedValue(qvtrPropertyTemplateItem);
				RelNode relPartPatternNode = visit(RelNode.class, partValue);
				RelPatternEdge relPatternEdge = UMLXFactory.eINSTANCE.createRelPatternEdge();
				relPatternEdge.setOwningSource(relPatternNode);
				relPatternEdge.setReferredProperty((EStructuralFeature) partProperty.getESObject());
				relPatternEdge.setTarget(relPartPatternNode);
			} */
			return relPatternNode;
		}

		@Override
		public @Nullable UMLXElement visitKey(@NonNull Key qvtrKey) {
			TxKeyNode txKeyNode = UMLXFactory.eINSTANCE.createTxKeyNode();
			context.putQVTr2UMLXTrace(qvtrKey, txKeyNode);
			txKeyNode.setReferredClass(context.getEcoreOf(qvtrKey.getIdentifies()));
			for (Property qvtrPart : qvtrKey.getPart()) {
				TxPartNode txPartNode = UMLXFactory.eINSTANCE.createTxPartNode();
				//				context.addTrace(usedPackage, txPartNode);
				txPartNode.setReferredProperty(context.getEcoreOf(qvtrPart));
				txKeyNode.getTxPartNodes().add(txPartNode);
			}
			for (Property qvtrPart : qvtrKey.getOppositePart()) {
				TxPartNode txPartNode = UMLXFactory.eINSTANCE.createTxPartNode();
				//				context.addTrace(usedPackage, txPartNode);
				txPartNode.setReferredProperty(context.getEcoreOf(qvtrPart));
				txPartNode.setIsOpposite(true);
				txKeyNode.getTxPartNodes().add(txPartNode);
			}
			return txKeyNode;
		}

		@Override
		public @Nullable UMLXElement visitOCLExpression(@NonNull OCLExpression qvtrExpression) {
			Relation qvtrRelation = QVTrelationUtil.getContainingRelation(qvtrExpression);
			RelDiagram relDiagram = context.getUMLXElement(RelDiagram.class, qvtrRelation);
			RelConstraintNode relConstraintNode = UMLXFactory.eINSTANCE.createRelConstraintNode();
			context.putQVTr2UMLXTrace(qvtrExpression, relConstraintNode);
			relConstraintNode.setExpression(PrettyPrinter.print(qvtrExpression));
			relDiagram.getOwnedNodes().add(relConstraintNode);
			return relConstraintNode;
		}

		@Override
		public @Nullable UMLXElement visitObjectTemplateExp(@NonNull ObjectTemplateExp qvtrObjectTemplateExp) {
			RelPatternNode relPatternNode = context.getUMLXElement(RelPatternNode.class, qvtrObjectTemplateExp);
			for (@NonNull PropertyTemplateItem qvtrPropertyTemplateItem : QVTrelationUtil.getOwnedParts(qvtrObjectTemplateExp)) {
				Property partProperty = QVTrelationUtil.getReferredProperty(qvtrPropertyTemplateItem);
				OCLExpression partValue = QVTrelationUtil.getOwnedValue(qvtrPropertyTemplateItem);
				RelNode relPartPatternNode = visit(RelNode.class, partValue);
				RelPatternEdge relPatternEdge = UMLXFactory.eINSTANCE.createRelPatternEdge();
				Property oppositeProperty = partProperty.getOpposite();
				if (partProperty.isIsComposite()) {
					relPatternEdge.setIsOpposite(false);
					relPatternEdge.setReferredProperty(context.getEcoreOf(partProperty));
					relPatternEdge.setOwningSource(relPatternNode);
					relPatternEdge.setTarget(relPartPatternNode);
				}
				else if ((oppositeProperty != null) && oppositeProperty.isIsComposite()) {
					relPatternEdge.setIsOpposite(false);
					relPatternEdge.setReferredProperty(context.getEcoreOf(oppositeProperty));
					relPatternEdge.setOwningSource(relPartPatternNode);
					relPatternEdge.setTarget(relPatternNode);
				}
				else if ((oppositeProperty != null) && partProperty.isIsImplicit()) {
					relPatternEdge.setIsOpposite(true);
					relPatternEdge.setReferredProperty(context.getEcoreOf(oppositeProperty));
					relPatternEdge.setOwningSource(relPartPatternNode);
					relPatternEdge.setTarget(relPatternNode);
				}
				else {
					relPatternEdge.setIsOpposite(false);
					relPatternEdge.setReferredProperty(context.getEcoreOf(partProperty));
					relPatternEdge.setOwningSource(relPatternNode);
					relPatternEdge.setTarget(relPartPatternNode);
				}
			}
			return relPatternNode;
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
			RelDiagram relDiagram = UMLXFactory.eINSTANCE.createRelDiagram();
			context.putQVTr2UMLXTrace(qvtrRelation, relDiagram);
			relDiagram.setIsTop(qvtrRelation.isIsTopLevel());
			relDiagram.setName(qvtrRelation.getName());
			List<UMLXNode> ownedNodes = relDiagram.getOwnedNodes();
			for (@NonNull EObject eObject : new TreeIterable(qvtrRelation, false)) {
				if (eObject instanceof TemplateExp) {
					@NonNull RelPatternNode relPatternNode = UMLXFactory.eINSTANCE.createRelPatternNode();
					TemplateExp qvtrTemplateExp = (TemplateExp)eObject;
					context.putQVTr2UMLXTrace(qvtrTemplateExp, relPatternNode);
					Variable qvtrVariable = qvtrTemplateExp.getBindsTo();
					context.putQVTr2UMLXTrace(qvtrVariable, relPatternNode);
					relPatternNode.setName(qvtrVariable.getName());
					relPatternNode.setReferredClass(context.getEcoreOf(PivotUtil.getClass(qvtrVariable)));
					ownedNodes.add(relPatternNode);
				}
			}
			for (@NonNull Variable qvtrVariable : QVTrelationUtil.getOwnedVariable(qvtrRelation)) {
				RelPatternNode relPatternNode = context.basicGetUMLXElement(RelPatternNode.class, qvtrVariable);
				if (relPatternNode == null) {
					relPatternNode = UMLXFactory.eINSTANCE.createRelPatternNode();
					context.putQVTr2UMLXTrace(qvtrVariable, relPatternNode);
					relPatternNode.setName(qvtrVariable.getName());
					relPatternNode.setReferredClass(context.getEcoreOf(PivotUtil.getClass(qvtrVariable)));
					ownedNodes.add(relPatternNode);
				}
			}
			createAll(QVTrelationUtil.getOwnedDomains(qvtrRelation), ownedNodes);
			Pattern qvtrWhen = qvtrRelation.getWhen();
			if (qvtrWhen != null) {
				for (@NonNull Predicate qvtrPredicate : QVTrelationUtil.getPredicates(qvtrWhen)) {
					QVTrelationUtil.getConditionExpression(qvtrPredicate).accept(this);
				}
			}
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
			context.putQVTr2UMLXTrace(qvtrRelationCallExp, relInvocationNode);
			relInvocationNode.setIsThen(isWhen == Boolean.FALSE);
			relDiagram.getOwnedNodes().add(relInvocationNode);
			for (@NonNull OCLExpression qvtrArgument : QVTrelationUtil.getOwnedArguments(qvtrRelationCallExp)) {
				RelNode relArgumentNode = create(qvtrArgument);
				RelInvocationEdge relInvocationEdge = UMLXFactory.eINSTANCE.createRelInvocationEdge();
				relInvocationEdge.setOwningSource(relInvocationNode);
				relInvocationEdge.setTarget(relArgumentNode);
			}
			context.putUMLX2QVTrTrace(relInvocationNode, qvtrRelationCallExp);
			context.addReference(relInvocationNode);
			return relInvocationNode;
		}

		@Override
		public @Nullable UMLXElement visitRelationDomain(@NonNull RelationDomain qvtrRelationDomain) {
			RelDomainNode relDomainNode = UMLXFactory.eINSTANCE.createRelDomainNode();
			context.putQVTr2UMLXTrace(qvtrRelationDomain, relDomainNode);
			relDomainNode.setReferredTypedModelNode(context.getUMLXElement(TxTypedModelNode.class, QVTrelationUtil.getTypedModel(qvtrRelationDomain)));
			//			relDomainNode.setIsCheck(qvtrRelationDomain.isIsCheckable());
			//			relDomainNode.setIsEnforce(qvtrRelationDomain.isIsEnforceable());
			for (@NonNull DomainPattern qvtrPattern : QVTrelationUtil.getOwnedPatterns(qvtrRelationDomain)) {
				TemplateExp qvtrTemplateExpression = QVTrelationUtil.getOwnedTemplateExpression(qvtrPattern);
				RelPatternNode relPatternNode = context.getUMLXElement(RelPatternNode.class, qvtrTemplateExpression);
				relDomainNode.getRootPatternNodes().add(relPatternNode);
				qvtrTemplateExpression.accept(this);
			}
			return relDomainNode;
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
			context.putQVTr2UMLXTrace(qvtrModel, umlxModel);
			//		    createAll(relationModel.getOwnedImports(), umlxModel.getOwnedImports());
			createAll(PivotUtil.getOwnedPackages(qvtrModel), null); //umlxModel.getOwnedPackages());
			//			createAll(relationModel.getOwnedComments(), umlxModel.getOwnedComments());
			return null;
		}

		@Override
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
		}

		@Override
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
		}

		@Override
		public @Nullable UMLXElement visitVariableExp(@NonNull VariableExp qvtrVariableExp) {
			RelPatternNode relPatternNode = context.getUMLXElement(RelPatternNode.class, PivotUtil.getReferredVariable(qvtrVariableExp));
			return relPatternNode;
		}

		@Override
		public @Nullable UMLXElement visiting(@NonNull Visitable visitable) {
			System.out.println("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
			return null;
			//			throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
		}
	}

	protected static class ReferenceVisitor extends AbstractExtendingUMLXVisitor<@Nullable Object, @NonNull QVTr2UMLX>
	{
		public ReferenceVisitor(@NonNull QVTr2UMLX context) {
			super(context);
		}

		@Override
		public @Nullable Object visiting(@NonNull UMLXElement visitable) {
			//			System.out.println("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
			return null;
			//			throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
		}

		@Override
		public @Nullable Object visitRelInvocationNode(@NonNull RelInvocationNode relInvocationNode) {
			RelationCallExp qvtrRelationCallExp = context.getQVTrElement(RelationCallExp.class, relInvocationNode);
			Relation qvtrReferredRelation = QVTrelationUtil.getReferredRelation(qvtrRelationCallExp);
			RelDiagram relReferredDiagram = context.getUMLXElement(RelDiagram.class, qvtrReferredRelation);
			relInvocationNode.setReferredRelationNode(relReferredDiagram);
			return null;
		}
	}

	protected final @NonNull EnvironmentFactory environmentFactory;
	//    private final @NonNull QVTrelationHelper helper;

	private final @NonNull Resource qvtrResource;
	private final @NonNull Resource umlxResource;
	private final @NonNull Map<@NonNull Element, @NonNull UMLXElement> qvtr2umlx = new HashMap<>();
	private final @NonNull Map<@NonNull UMLXElement, @NonNull Element> umlx2qvtr = new HashMap<>();
	private final @NonNull Set<@NonNull UMLXElement> references = new HashSet<>();

	//    private final @NonNull Stack<@NonNull UMLXElement> scopeStack = new Stack<@NonNull UMLXElement>();

	///	private @NonNull Model umlxModel;

	public QVTr2UMLX(@NonNull EnvironmentFactory environmentFactory, @NonNull Resource qvtrResource, @NonNull Resource umlxResource) {
		this.environmentFactory = environmentFactory;
		this.qvtrResource = qvtrResource;
		this.umlxResource = umlxResource;
		//		this.helper = new QVTrelationHelper(environmentFactory);
		//		this.nameGenerator = new QVTrNameGenerator(this);
		//		this.umlxModel = UMLXFactory.INSTANCE.createModel();
	}

	public void addReference(@NonNull UMLXElement umlxElement) {
		references.add(umlxElement);
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

	// Save the qvtc resource
	public void dispose() {
		// What about the trace model? we need to separate them
		//qvtcSource.getContents().addAll(traceData.getRootOutputELements());
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
	 * context.
	 *
	 * @param source the source of the trace
	 * @param generated the list of generated objects
	 * @param context the context in which the trace is valid
	 */
	protected void putQVTr2UMLXTrace(@NonNull Element qvtrElement, @NonNull UMLXElement umlxElement) {
		UMLXElement oldUmlxElement = qvtr2umlx.put(qvtrElement, umlxElement);
		assert oldUmlxElement == null;
	}

	//    public void popScope() {
	//    	scopeStack.pop();
	//    }

	//    public void pushScope(@NonNull UMLXElement scope) {
	//    	assert !scopeStack.contains(scope);
	//    	scopeStack.push(scope);
	//    }

	/**
	 * Create a new trace for the given list of generated objects for the given
	 * context.
	 *
	 * @param source the source of the trace
	 * @param generated the list of generated objects
	 * @param context the context in which the trace is valid
	 */
	protected void putUMLX2QVTrTrace(@NonNull UMLXElement umlxElement, @NonNull Element qvtrElement) {
		Element oldQVTrElement = umlx2qvtr.put(umlxElement, qvtrElement);
		assert oldQVTrElement == null;
	}

	public void transform() throws CompilerChainException {
		for (EObject eObject : qvtrResource.getContents()) {
			if (eObject instanceof RelationModel) {
				UMLXModel umlxModel = UMLXFactory.eINSTANCE.createUMLXModel();
				((Element)eObject).accept(new CreateVisitor(this, umlxModel));
				umlxResource.getContents().add(umlxModel);
			}
		}
		if (!references.isEmpty()) {
			ReferenceVisitor referenceVisitor = new ReferenceVisitor(this);
			for (EObject eObject : new TreeIterable(umlxResource)) {
				if (eObject instanceof UMLXElement) {
					((UMLXElement)eObject).accept(referenceVisitor);
				}
			}
		}
	}
}
