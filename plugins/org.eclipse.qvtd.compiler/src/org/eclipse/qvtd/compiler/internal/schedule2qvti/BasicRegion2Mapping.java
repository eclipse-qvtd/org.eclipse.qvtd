/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.schedule2qvti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PrimitiveLiteralExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.qvtd.compiler.internal.scheduler.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.scheduler.Connection;
import org.eclipse.qvtd.compiler.internal.scheduler.Edge;
import org.eclipse.qvtd.compiler.internal.scheduler.EdgeRole;
import org.eclipse.qvtd.compiler.internal.scheduler.NavigationEdge;
import org.eclipse.qvtd.compiler.internal.scheduler.Node;
import org.eclipse.qvtd.compiler.internal.scheduler.Region;
import org.eclipse.qvtd.compiler.internal.scheduler.SchedulerConstants;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractExtendingQVTimperativeVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

import com.google.common.collect.Iterables;

public class BasicRegion2Mapping extends AbstractRegion2Mapping
{		
	private static final class DomainNameComparator implements Comparator<Domain>
	{
		public static final @NonNull DomainNameComparator INSTANCE = new DomainNameComparator();

		@Override
		public int compare(Domain o1, Domain o2) {
			TypedModel t1 = o1.getTypedModel();
			TypedModel t2 = o2.getTypedModel();
			String n1 = t1 != null ? t1.getName() : null;
			String n2 = t2 != null ? t2.getName() : null;
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	private class ExpressionCreator extends AbstractExtendingQVTimperativeVisitor<@NonNull OCLExpression, @NonNull BasicRegion2Mapping>
	{
		protected final @NonNull Set<Node> multiAccessedNodes = new HashSet<Node>();
		protected final @NonNull Set<Node> conditionalNodes = new HashSet<Node>();

		public ExpressionCreator() {
			super(BasicRegion2Mapping.this);
			analyzeExpressions(multiAccessedNodes, conditionalNodes);
		}

		/**
		 * Compute the nodes that are only evaluated if a run-time if-condition is satisfied, and the nodes that are always accessed more than once.
		 */
		private void analyzeExpressions(@NonNull Set<Node> multiAccessedNodes, @NonNull Set<Node> conditionalNodes) {
			Set<Node> unconditionalNodes = new HashSet<Node>();
			for (@SuppressWarnings("null")@NonNull Edge edge : region.getRealizedEdges()) {
				analyzeIncomingPath(edge.getTarget(), unconditionalNodes, conditionalNodes, false);
			}
			conditionalNodes.removeAll(unconditionalNodes);
//			if (conditionalNodes.size() > 0) {
//				System.out.println("Conditional nodes for " + this);
//				for (Node conditionalNode : conditionalNodes) {
//					System.out.println("  " + conditionalNode);
//				}
//			}
			for (@SuppressWarnings("null")@NonNull Node node : unconditionalNodes) {
				int accesses = 0;
				for (Edge outgoingEdge : node.getOutgoingEdges()) {
					if (outgoingEdge.isNavigation() || outgoingEdge.isComputation()) {
						accesses++;
					}
				}
				if (accesses > 1) {
					multiAccessedNodes.add(node);
				}
			}
//			if (multiAccessedNodes.size() > 0) {
//				System.out.println("multi-accessed nodes for " + this);
//				for (Node multiAccessedNode : multiAccessedNodes) {
//					System.out.println("  " + multiAccessedNode);
//				}
//			}
		}

		private void analyzeIncomingPath(@NonNull Node node, @NonNull Set<Node> unconditionalNodes, @NonNull Set<Node> conditionalNodes, boolean isConditional) {
			if ((isConditional ? conditionalNodes : unconditionalNodes).add(node)) {
				boolean isIf = isIfExp(node);
				for (@SuppressWarnings("null")@NonNull Edge edge : node.getIncomingEdges()) {
					if (edge.isComputation()) {
						boolean isIfThenOrElse = isIf && ("then".equals(edge.getName()) || "else".equals(edge.getName()));
						analyzeIncomingPath(edge.getSource(), unconditionalNodes, conditionalNodes, isConditional || isIfThenOrElse);
					}
					else if (edge.isNavigation()) {
						analyzeIncomingPath(edge.getSource(), unconditionalNodes, conditionalNodes, isConditional);
					}
				}
				return;
			}
		}
		
		protected @NonNull OCLExpression create(/*@NonNull*/ Node node) {
			if (node.isNull()) {
				return createNullLiteralExp();
			}
			Variable theVariable = node2variable.get(node);
			if (theVariable == null) {
				TypedElement oldTypedElement = node.getTypedElements().iterator().next();
				assert oldTypedElement != null;
				OCLExpression initExpression = oldTypedElement.accept(this);
				assert initExpression != null;
//				Type type = newExpression.getType();
//				assert type != null;
//				theVariable = PivotUtil.createVariable(getSafeName(node), type, true, newExpression);
//				mapping.getBottomPattern().getVariable().add(theVariable);
//				node2variable.put(node, theVariable);
				if ((initExpression instanceof PrimitiveLiteralExp) || conditionalNodes.contains(node)) {
					return initExpression;
				}
				@SuppressWarnings("null")@NonNull BottomPattern bottomPattern = mapping.getBottomPattern();
				theVariable = createUnrealizedVariable(bottomPattern, node, initExpression);
			}
			return PivotUtil.createVariableExp(theVariable);
		}

		private @Nullable OCLExpression create(@Nullable OCLExpression oldTypedElement) {
			if (oldTypedElement == null) {
				return null;
			}
			Node node = context.getNode(oldTypedElement);
			if (node == null) {
				node = context.getNode(oldTypedElement);		// FIXME debugging
			}
			if (node != null) {
				return create(node);
			}
			else {
				return oldTypedElement.accept(this);
			}
		}

		private @NonNull CollectionItem createCollectionItem(@NonNull OCLExpression asItem) {
			CollectionItem collectionItem = PivotFactory.eINSTANCE.createCollectionItem();
			collectionItem.setOwnedItem(asItem);
			collectionItem.setType(asItem.getType());
			collectionItem.setIsRequired(asItem.isIsRequired());
			return collectionItem;
		}

		private @NonNull OCLExpression createCollectionLiteralExp(@NonNull CollectionType asType, @NonNull Iterable<CollectionLiteralPart> asParts) {
			CollectionLiteralExp collectionLiteralExp = PivotFactory.eINSTANCE.createCollectionLiteralExp();
			Iterables.addAll(collectionLiteralExp.getOwnedParts(), asParts);
			collectionLiteralExp.setType(asType);
			collectionLiteralExp.setKind(TypeUtil.getCollectionKind(asType));
			collectionLiteralExp.setIsRequired(true);
			return collectionLiteralExp;
		}

		private @NonNull CollectionRange createCollectionRange(@NonNull OCLExpression asFirst, @NonNull OCLExpression asLast) {
			CollectionRange collectionRange = PivotFactory.eINSTANCE.createCollectionRange();
			collectionRange.setOwnedFirst(asFirst);
			collectionRange.setOwnedLast(asLast);
			collectionRange.setType(visitor.getStandardLibrary().getIntegerType());
			collectionRange.setIsRequired(true);
			return collectionRange;
		}

		private @NonNull OCLExpression createMapLiteralExp(@NonNull MapType asType, @NonNull Iterable<MapLiteralPart> asParts) {
			MapLiteralExp mapLiteralExp = PivotFactory.eINSTANCE.createMapLiteralExp();
			Iterables.addAll(mapLiteralExp.getOwnedParts(), asParts);
			mapLiteralExp.setType(asType);
			mapLiteralExp.setIsRequired(true);
			return mapLiteralExp;
		}

		private @NonNull MapLiteralPart createMapLiteralPart(@NonNull OCLExpression asKey, @NonNull OCLExpression asValue) {
			MapLiteralPart mapLiteralPart = PivotFactory.eINSTANCE.createMapLiteralPart();
			mapLiteralPart.setOwnedKey(asKey);
			mapLiteralPart.setOwnedValue(asValue);
//			mapLiteralPart.setType(asItem.getType());
//			mapLiteralPart.setIsRequired(true);
			return mapLiteralPart;
		}

		private @NonNull OCLExpression createShadowExp(org.eclipse.ocl.pivot.@NonNull Class asClass, @NonNull Iterable<ShadowPart> asParts) {
			ShadowExp shadowExp = PivotFactory.eINSTANCE.createShadowExp();
			Iterables.addAll(shadowExp.getOwnedParts(), asParts);
			shadowExp.setType(asClass);
			shadowExp.setIsRequired(true);
			return shadowExp;
		}

		private @NonNull ShadowPart createShadowPart(@NonNull Property asProperty, @NonNull OCLExpression asValue) {
			ShadowPart shadowPart = PivotFactory.eINSTANCE.createShadowPart();
			shadowPart.setReferredProperty(asProperty);
			shadowPart.setType(asProperty.getType());
			shadowPart.setIsRequired(asProperty.isIsRequired());
			shadowPart.setOwnedInit(asValue);
			return shadowPart;
		}

		private @NonNull OCLExpression createTupleLiteralExp(@NonNull TupleType asType, @NonNull Iterable<TupleLiteralPart> asParts) {
			TupleLiteralExp tupleLiteralExp = PivotFactory.eINSTANCE.createTupleLiteralExp();
			Iterables.addAll(tupleLiteralExp.getOwnedParts(), asParts);
			tupleLiteralExp.setType(asType);
			tupleLiteralExp.setIsRequired(true);
			return tupleLiteralExp;
		}

		private @NonNull TupleLiteralPart createTupleLiteralPart(@NonNull String name, @NonNull Type asType, boolean isRequired, @NonNull OCLExpression asValue) {
			TupleLiteralPart tupleLiteralPart = PivotFactory.eINSTANCE.createTupleLiteralPart();
			tupleLiteralPart.setName(name);
			tupleLiteralPart.setType(asType);
			tupleLiteralPart.setIsRequired(isRequired);
			tupleLiteralPart.setOwnedInit(asValue);
			return tupleLiteralPart;
		}

		private @NonNull OCLExpression createNonNull(@Nullable OCLExpression oldTypedElement) {
			assert oldTypedElement != null;
			Node node = context.getNode(oldTypedElement);
			if (node == null) {
				node = context.getNode(oldTypedElement);		// FIXME debugging
			}
			return create(node);
		}

		private @NonNull List<OCLExpression> createAll(@NonNull List<OCLExpression> oldTypedElements) {
			List<OCLExpression> newTypedElements = new ArrayList<OCLExpression>(oldTypedElements.size());
			for (@SuppressWarnings("null")@NonNull OCLExpression oldTypedElement : oldTypedElements) {
				newTypedElements.add(create(oldTypedElement));
			}
			return newTypedElements;
		}

		private @NonNull List<Variable> createVariables(@NonNull List<Variable> oldVariables) {
			List<Variable> newVariables = new ArrayList<Variable>(oldVariables.size());
			for (@SuppressWarnings("null")@NonNull Variable oldVariable : oldVariables) {
				String name = oldVariable.getName();
				assert name != null;
				Type type = oldVariable.getType();
				assert type != null;
				Variable newVariable = PivotUtil.createVariable(name, type, oldVariable.isIsRequired(), create(oldVariable.getOwnedInit()));
				newVariables.add(newVariable);
				Node variableNode = getNode(oldVariable);
				if (variableNode != null) {
					node2variable.put(variableNode, newVariable);
				}
			}
			return newVariables;
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + " " + region;
		}

		@Override
		public @NonNull OCLExpression visiting(@NonNull Visitable visitable) {
			throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
		}

		public @Nullable OCLExpression getExpression(@NonNull Node node) {		
			if (node.isNull()) {
				return createNullLiteralExp();
			}
			Variable variable = node2variable.get(node);
			if (variable != null) {
				return PivotUtil.createVariableExp(variable);
			}
			for (Edge edge : node.getArgumentEdges()) {
				Node expNode = edge.getSource();
//				TypedElement oldTypedElement = expNode.getTypedElements().iterator().next();
//				assert oldTypedElement != null;
				OCLExpression clonedElement = create(expNode);
//				assert clonedNode != null;
//				TypedElement typedElement = clonedNode.getTypedElements().iterator().next();
				if (clonedElement instanceof VariableExp) {
					VariableDeclaration referredVariable = ((VariableExp)clonedElement).getReferredVariable();
					if (referredVariable instanceof Variable) {
						node2variable.put(node, (Variable) referredVariable);
					}
				}
				return clonedElement;
			}
			for (Edge edge : node.getIncomingEdges()) {
				EdgeRole edgeRole = edge.getEdgeRole();
				if (edgeRole.isNavigation() && edgeRole.isLoaded()) {
					OCLExpression source = getExpression(edge.getSource());
					if (source != null) {
						return PivotUtil.createNavigationCallExp(source, ((NavigationEdge)edge).getProperty());
					}
				}
			}
			return null;
		}

		public boolean isConditional(@NonNull Node node) {
			return conditionalNodes.contains(node);
		}

		@Override
		public @NonNull OCLExpression visitCollectionLiteralExp(@NonNull CollectionLiteralExp pCollectionLiteralExp) {
			List<CollectionLiteralPart> clonedParts = new ArrayList<CollectionLiteralPart>();
			for (CollectionLiteralPart pPart : pCollectionLiteralExp.getOwnedParts()) {
				if (pPart instanceof CollectionItem) {
					OCLExpression item = createNonNull(((CollectionItem)pPart).getOwnedItem());
					clonedParts.add(createCollectionItem(item));
				}
				else {
					CollectionRange pCollectionRange = (CollectionRange)pPart;
					OCLExpression first = createNonNull(pCollectionRange.getOwnedFirst());
					OCLExpression last = createNonNull(pCollectionRange.getOwnedLast());
					clonedParts.add(createCollectionRange(first, last));
				}
			}
			CollectionType collectionType = (CollectionType)pCollectionLiteralExp.getType();
			assert collectionType != null;
			return createCollectionLiteralExp(collectionType, clonedParts);
		}

		@Override
		public @NonNull OCLExpression visitIfExp(@NonNull IfExp pIfExp) {
			PivotMetamodelManager metamodelManager = (PivotMetamodelManager)visitor.getMetamodelManager();
			return metamodelManager.createIfExp(createNonNull(pIfExp.getOwnedCondition()),
				inlineExpressionCreator.createNonNull(pIfExp.getOwnedThen()),
				inlineExpressionCreator.createNonNull(pIfExp.getOwnedElse()));
		}

		@Override
		public @NonNull OCLExpression visitIterateExp(@NonNull IterateExp pIterateExp) {
			return visiting(pIterateExp);
		}

		@Override
		public @NonNull OCLExpression visitIteratorExp(@NonNull IteratorExp pIteratorExp) {
			OCLExpression iSource = create(pIteratorExp.getOwnedSource());
			assert iSource != null;
			List<? extends Variable> iIterators = createVariables(pIteratorExp.getOwnedIterators());
			Iteration referredIteration = (Iteration) visitor.create(pIteratorExp.getReferredIteration());
			assert referredIteration != null;
			OCLExpression iBody = inlineExpressionCreator.create(pIteratorExp.getOwnedBody());
			assert iBody != null;
			return createIteratorExp(iSource, referredIteration, iIterators, iBody);
		}

		public @NonNull IteratorExp createIteratorExp(@NonNull OCLExpression asSource, @NonNull Iteration asIteration, @NonNull List<? extends Variable> asIterators, @NonNull OCLExpression asBody) {
			IteratorExp asCallExp = PivotFactory.eINSTANCE.createIteratorExp();
			asCallExp.setReferredIteration(asIteration);
			asCallExp.setOwnedSource(asSource);
			asCallExp.getOwnedIterators().addAll(asIterators);
			asCallExp.setOwnedBody(asBody);
			Type formalType = asIteration.getType();
			assert formalType != null;
			asCallExp.setType(formalType);
			asCallExp.setIsRequired(asIteration.isIsRequired());
			Type actualType = asSource.getType();
			assert actualType != null;
			Type returnType = getMetamodelManager().specializeType(formalType, asCallExp, actualType, asSource.getTypeValue());
			asCallExp.setType(returnType);
			return asCallExp;
		}

		@Override
		public @NonNull OCLExpression visitMapLiteralExp(@NonNull MapLiteralExp pMapLiteralExp) {
			List<MapLiteralPart> clonedParts = new ArrayList<MapLiteralPart>();
			for (MapLiteralPart pPart : pMapLiteralExp.getOwnedParts()) {
				OCLExpression key = createNonNull(pPart.getOwnedKey());
				OCLExpression value = createNonNull(pPart.getOwnedValue());
				clonedParts.add(createMapLiteralPart(key, value));
			}
			MapType mapType = (MapType)pMapLiteralExp.getType();
			assert mapType != null;
			return createMapLiteralExp(mapType, clonedParts);
		}

		@Override
		public @NonNull OCLExpression visitOperationCallExp(@NonNull OperationCallExp pOperationCallExp) {
			OCLExpression iSource = create(pOperationCallExp.getOwnedSource());
			List<OCLExpression> iArguments = createAll(pOperationCallExp.getOwnedArguments());
			Operation referredOperation = visitor.create(pOperationCallExp.getReferredOperation());
			assert referredOperation != null;
			if ((iSource == null) && (referredOperation instanceof Function)) {
				SchedulerConstants scheduler = getRegion().getSuperRegion().getSchedulerConstants();
				StandardLibrary standardLibrary = scheduler.getStandardLibrary();
				Variable thisVariable = QVTbaseUtil.getContextVariable(standardLibrary, visitor.getTransformation());
				iSource = PivotUtil.createVariableExp(thisVariable);
			}
			return createOperationCallExp(iSource, referredOperation, iArguments);
		}

		public @NonNull OperationCallExp createOperationCallExp(@Nullable OCLExpression asSource, @NonNull Operation asOperation, @NonNull List<OCLExpression> asArguments) {
			Type formalType = asOperation.getType();
			OperationCallExp asCallExp = PivotFactory.eINSTANCE.createOperationCallExp();
			asCallExp.setReferredOperation(asOperation);
			asCallExp.setOwnedSource(asSource);
			asCallExp.getOwnedArguments().addAll(asArguments);
			asCallExp.setIsRequired(asOperation.isIsRequired());

			Type sourceType = null;
			Type sourceTypeValue = null;
			if (asSource != null) {
				sourceType = asSource.getType();
				sourceTypeValue = asSource.getTypeValue();
			}
			Type returnType = null;
			if ((formalType != null) && (sourceType != null)) {
				PivotMetamodelManager metamodelManager = getMetamodelManager();
				if (asOperation.isIsTypeof()) {
					returnType = metamodelManager.specializeType(formalType, asCallExp, sourceType, null);
				}
				else {
					returnType = metamodelManager.specializeType(formalType, asCallExp, sourceType, sourceTypeValue);
				}
			}
			asCallExp.setType(returnType);
			return asCallExp;
		}

		@Override
		public @NonNull OCLExpression visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp pOppositePropertyCallExp) {
			OCLExpression iSource = createNonNull(pOppositePropertyCallExp.getOwnedSource());
			Property referredProperty = pOppositePropertyCallExp.getReferredProperty();
			assert referredProperty != null;
			return PivotUtil.createNavigationCallExp(iSource, referredProperty);
		}

		@Override
		public @NonNull OCLExpression visitPrimitiveLiteralExp(@NonNull PrimitiveLiteralExp pPrimitiveLiteralExp) {
			return EcoreUtil.copy(pPrimitiveLiteralExp);
		}

		@Override
		public @NonNull OCLExpression visitPropertyCallExp(@NonNull PropertyCallExp pPropertyCallExp) {
			OCLExpression iSource = createNonNull(pPropertyCallExp.getOwnedSource());
			Property referredProperty = pPropertyCallExp.getReferredProperty();
			assert referredProperty != null;
			assert referredProperty.eContainer() != null;
			return PivotUtil.createNavigationCallExp(iSource, referredProperty);
		}

		@Override
		public @NonNull OCLExpression visitShadowExp(@NonNull ShadowExp pShadowExp) {
			List<ShadowPart> clonedParts = new ArrayList<ShadowPart>();
			for (ShadowPart pPart : pShadowExp.getOwnedParts()) {
				OCLExpression init = createNonNull(pPart.getOwnedInit());
				String name = pPart.getName();
				Type type = pPart.getType();
				assert (name != null) && (type != null);
				Property referredProperty = pPart.getReferredProperty();
				assert referredProperty != null;
				clonedParts.add(createShadowPart(referredProperty, init));
			}
			org.eclipse.ocl.pivot.Class shadowType = pShadowExp.getType();
			assert shadowType != null;
			return createShadowExp(shadowType, clonedParts);
		}

		@Override
		public @NonNull OCLExpression visitTupleLiteralExp(@NonNull TupleLiteralExp pTupleLiteralExp) {
			List<TupleLiteralPart> clonedParts = new ArrayList<TupleLiteralPart>();
			for (TupleLiteralPart pPart : pTupleLiteralExp.getOwnedParts()) {
				OCLExpression init = createNonNull(pPart.getOwnedInit());
				String name = pPart.getName();
				Type type = pPart.getType();
				assert (name != null) && (type != null);
				clonedParts.add(createTupleLiteralPart(name, type, pPart.isIsRequired(), init));
			}
			TupleType tupleType = (TupleType)pTupleLiteralExp.getType();
			assert tupleType != null;
			return createTupleLiteralExp(tupleType, clonedParts);
		}

		@Override
		public @NonNull OCLExpression visitTypeExp(@NonNull TypeExp pTypeExp) {
			Type referredType = pTypeExp.getReferredType();
			TypeExp typeExp = PivotFactory.eINSTANCE.createTypeExp();
			typeExp.setReferredType(referredType);
			typeExp.setType(getMetamodelManager().getStandardLibrary().getClassType());
			typeExp.setIsRequired(true);
			typeExp.setTypeValue(referredType);	
			return typeExp;
		}

		@Override
		public @NonNull OCLExpression visitVariableExp(@NonNull VariableExp pVariableExp) {
			VariableDeclaration pVariable = pVariableExp.getReferredVariable();
			Node node = getNode(pVariable);
			if (node == null) {
				SchedulerConstants scheduler = getRegion().getSuperRegion().getSchedulerConstants();
				StandardLibrary standardLibrary = scheduler.getStandardLibrary();
				Transformation pTransformation = QVTbaseUtil.getContainingTransformation(pVariableExp);
				if (pTransformation != null) {
					Variable pThisVariable = QVTbaseUtil.getContextVariable(standardLibrary, pTransformation);
					if (pVariableExp.getReferredVariable() == pThisVariable) {
						Variable iThisVariable = QVTbaseUtil.getContextVariable(standardLibrary, visitor.getTransformation());
						return PivotUtil.createVariableExp(iThisVariable);
					}
				}
			}
			assert node != null;
			Variable iVariable = getVariable(node);
			assert iVariable != null;
			return PivotUtil.createVariableExp(iVariable);
		}
	}
	
	private class InlineExpressionCreator extends ExpressionCreator
	{
		@Override
		public @NonNull OCLExpression create(/*@NonNull*/ Node node) {
			if (node.isNull()) {
				return createNullLiteralExp();
			}
			Variable theVariable = node2variable.get(node);
			if (theVariable == null) {
				TypedElement oldTypedElement = node.getTypedElements().iterator().next();
				assert oldTypedElement != null;
				OCLExpression initExpression = oldTypedElement.accept(this);
				assert initExpression != null;
				return initExpression;
			}
			return PivotUtil.createVariableExp(theVariable);
		}
	}
	
	/**
	 * The selected head from each head group that is actually passed. Other heads are computed.
	 */
	private final @NonNull List<Node> headNodes = new ArrayList<Node>();

	/**
	 * The subset of possible guard nodes that all callers can pass..
	 */
	private final @NonNull List<Node> guardNodes = new ArrayList<Node>();

	/**
	 * Mapping from the scheduled Nodes to their QVTi variables.
	 */
	private final @NonNull Map<Node, Variable> node2variable = new HashMap<Node, Variable>();

	/**
	 * Mapping from the TypedModel to its ImperativeDomain.
	 */
	private final @NonNull Map<TypedModel, ImperativeDomain> typedModel2domain = new HashMap<TypedModel, ImperativeDomain>();
	
	/**
	 * Mapping from QVTi expression to Schedule Node.
	 */
//	private final @NonNull Map<TypedElement, Node> qvti2node = new HashMap<TypedElement, Node>();

	private final @NonNull ExpressionCreator expressionCreator;
	private final @NonNull ExpressionCreator inlineExpressionCreator = new InlineExpressionCreator();

	public BasicRegion2Mapping(@NonNull QVTs2QVTiVisitor visitor, @NonNull Region region) {
		super(visitor, region);
		this.expressionCreator = new ExpressionCreator();
		createEmptyDomainsAndPatterns();
		createHeadAndGuardNodeVariables();
		createExternalPredicates();
		createNavigablePredicates();
		createRealizedVariables();
		createPropertyAssignments();
		createConnectionAssignments();
		createPollingDependencies();
	}

/*	@Override
	public void checkAndEnforceRealizations(@NonNull Map<TypedModel, Map<Property, List<NavigationEdge>>> typedModel2property2realizedEdges) {
		boolean doDebug = QVTs2QVTiVisitor.POLLED_PROPERTIES.isActive();
		for (NavigationEdge predicatedEdge : region.getPredicatedNavigationEdges()) {
			Node laterNode = predicatedEdge.getTarget();
			ClassDatumAnalysis classDatumAnalysis = laterNode.getClassDatumAnalysis();
			TypedModel typedModel = classDatumAnalysis.getTypedModel();
			Property property = predicatedEdge.getProperty();
			Map<Property, List<NavigationEdge>> property2realizedEdges = typedModel2property2realizedEdges.get(typedModel);
			assert property2realizedEdges != null;
			List<NavigationEdge> realizedEdges = property2realizedEdges.get(property);
			assert realizedEdges != null;
			for (NavigationEdge realizedEdge : realizedEdges) {
				Node earlierNode = realizedEdge.getTarget();
				Region earlierRegion = earlierNode.getRegion();
				boolean isAfter = isAfter(earlierRegion, region);
				if (!isAfter) {
					Area laterArea = QVTimperativeUtil.getArea(mapping, typedModel);
					if (laterArea instanceof ImperativeArea) {
						if (((ImperativeArea)laterArea).getCheckedProperties().add(property)) {
							if (doDebug) {
								QVTs2QVTiVisitor.POLLED_PROPERTIES.println("    checks " + property +
									" at " + region.getEarliestIndex() + ".." + region.getLatestIndex() + " in " + typedModel + " for " + region);
							}
						}
					}
					AbstractRegion2Mapping earlierRegion2Mapping = visitor.getRegion2Mapping(earlierRegion);
					Mapping earlierMapping = earlierRegion2Mapping.getMapping();
					Area earlierArea = QVTimperativeUtil.getArea(earlierMapping, typedModel);
					if (earlierArea instanceof ImperativeArea) {
						if (((ImperativeArea)earlierArea).getEnforcedProperties().add(property)) {
							if (doDebug) {
								QVTs2QVTiVisitor.POLLED_PROPERTIES.println("    enforces " + property +
									" at " + earlierRegion.getEarliestIndex() + ".." + earlierRegion.getLatestIndex() + " in " + typedModel + " for " + earlierRegion);
							}
						}
					}
				}
				else if (doDebug) {
					QVTs2QVTiVisitor.POLLED_PROPERTIES.println("  " + region + "::" + laterNode.getName() + "(" + region.getEarliestIndex() + ".." + region.getLatestIndex() + ")" + 
						" isAfter (" + earlierRegion.getEarliestIndex() + ".." + earlierRegion.getLatestIndex() + ")" + earlierRegion + "::" + earlierNode.getName());
				}
			}
		}
	}  */

/*	@Override
	public void computeCheckedProperties() {
		boolean doDebug = QVTs2QVTiVisitor.POLLED_PROPERTIES.isActive();
		if (doDebug) {
			QVTs2QVTiVisitor.POLLED_PROPERTIES.println("Computing polled properties for " + this);
		}
		for (NavigationEdge laterEdge : region.getNavigationEdges()) {
			Node laterNode = laterEdge.getTarget();
//			Region laterRegion = laterNode.getRegion();
			for (@SuppressWarnings("null")@NonNull Node earlierNode : laterNode.getUsedBindingSources()) {
				Region earlierRegion = earlierNode.getRegion();
				boolean isAfter = isAfter(earlierRegion, region);
				if (!isAfter) {
					ClassDatumAnalysis classDatumAnalysis = laterNode.getClassDatumAnalysis();
					TypedModel typedModel = classDatumAnalysis.getTypedModel();
					Property property = laterEdge.getProperty();
					Area laterArea = QVTimperativeUtil.getArea(mapping, typedModel);
					if (laterArea instanceof ImperativeArea) {
						if (((ImperativeArea)laterArea).getCheckedProperties().add(property)) {
							if (doDebug) {
								QVTs2QVTiVisitor.POLLED_PROPERTIES.println("    checks " + property +
									" at " + region.getEarliestIndex() + ".." + region.getLatestIndex() + " in " + typedModel + " for " + region);
							}
						}
					}
					AbstractRegion2Mapping earlierRegion2Mapping = visitor.getRegion2Mapping(earlierRegion);
					Mapping earlierMapping = earlierRegion2Mapping.getMapping();
					Area earlierArea = QVTimperativeUtil.getArea(earlierMapping, typedModel);
					if (earlierArea instanceof ImperativeArea) {
						if (((ImperativeArea)earlierArea).getEnforcedProperties().add(property)) {
							if (doDebug) {
								QVTs2QVTiVisitor.POLLED_PROPERTIES.println("    enforces " + property +
									" at " + earlierRegion.getEarliestIndex() + ".." + earlierRegion.getLatestIndex() + " in " + typedModel + " for " + earlierRegion);
							}
						}
					}
				}
				else if (doDebug) {
					QVTs2QVTiVisitor.POLLED_PROPERTIES.println("  " + region + "::" + laterNode.getName() + "(" + region.getEarliestIndex() + ".." + region.getLatestIndex() + ")" + 
						" isAfter (" + earlierRegion.getEarliestIndex() + ".." + earlierRegion.getLatestIndex() + ")" + earlierRegion + "::" + earlierNode.getName());
				}
			}
		}
	} */

	private void createClassPropertyAssignments(@NonNull Iterable<List<NavigationEdge>> classAssignments) {
		for (List<NavigationEdge> edges : classAssignments) {
			for (NavigationEdge edge : edges) {
				Node sourceNode = edge.getSource();
				Node targetNode = edge.getTarget();
				OCLExpression slotVariableExp = createVariableExp(sourceNode);
				Property property = edge.getProperty();
				OCLExpression targetVariableExp = createVariableExp(targetNode);
				PropertyAssignment propertyAssignment = QVTimperativeUtil.createPropertyAssignment(slotVariableExp, property, targetVariableExp);
				mapping.getBottomPattern().getAssignment().add(propertyAssignment);
			}
		}
	}

	/**
	 *	Create accumulation assignments for connections.
	 */
	private void createConnectionAssignments() {
		if (connection2variable != null) {
			for (Connection connection : connection2variable.keySet()) {
				Node sourceNode = connection.getSource(region);
				OCLExpression variableExpression = createVariableExp(sourceNode);
				Variable connectionVariable = connection2variable.get(connection);
				assert connectionVariable != null;
				createConnectionAssignment(connectionVariable, variableExpression);
			}
		}
	}

	/**
	 * Create the domains and guard/bottom patterns.
	 */
	private void createEmptyDomainsAndPatterns() {
		Set<TypedModel> checkableTypedModels = new HashSet<TypedModel>();
		Set<TypedModel> enforceableTypedModels = new HashSet<TypedModel>();
		for (Node node : region.getNodes()) {
			ClassDatumAnalysis classDatumAnalysis = node.getClassDatumAnalysis();
			Type type = classDatumAnalysis.getClassDatum().getType();
			if (!(type instanceof DataType) && !(type instanceof AnyType) && !(type instanceof VoidType) && !(type instanceof InvalidType)) {
				DomainUsage domainUsage = classDatumAnalysis.getDomainUsage();
				if (domainUsage.isCheckable()) {		// EObject is $primitive$
					for (@SuppressWarnings("null")@NonNull TypedModel typedModel : domainUsage.getTypedModels()) {
						checkableTypedModels.add(visitor.getQVTiTypedModel(typedModel));
					}
				}
				if (domainUsage.isEnforceable()) {		// EObject is $primitive$
					for (@SuppressWarnings("null")@NonNull TypedModel typedModel : domainUsage.getTypedModels()) {
						enforceableTypedModels.add(visitor.getQVTiTypedModel(typedModel));
					}
				}
			}
		}
		checkableTypedModels.removeAll(enforceableTypedModels);
		for (@SuppressWarnings("null")@NonNull TypedModel qvtiTypedModel : checkableTypedModels) {
			ImperativeDomain domain = QVTimperativeUtil.createImperativeDomain(qvtiTypedModel);
			domain.setIsCheckable(true);
			mapping.getDomain().add(domain);
			ImperativeDomain oldDomain = typedModel2domain.put(qvtiTypedModel, domain);
			assert oldDomain == null;
		}
		for (@SuppressWarnings("null")@NonNull TypedModel qvtiTypedModel : enforceableTypedModels) {
			ImperativeDomain domain = QVTimperativeUtil.createImperativeDomain(qvtiTypedModel);
			domain.setIsEnforceable(true);
			mapping.getDomain().add(domain);
			ImperativeDomain oldDomain = typedModel2domain.put(qvtiTypedModel, domain);
			assert oldDomain == null;
		}
		ECollections.sort(mapping.getDomain(), DomainNameComparator.INSTANCE);
	}

	/**
	 * Create a predicate expression for each TRUE 'head'.
	 */
	private void createExternalPredicates() {
		List<Predicate> predicates = mapping.getGuardPattern().getPredicate();
		for (Node node : region.getNodes()) {
			if (node.isTrue()) {
				for (Edge edge : node.getArgumentEdges()) {
					Node predicateNode = edge.getSource();
					for (TypedElement typedElement : predicateNode.getTypedElements()) {
						OCLExpression conditionExpression = typedElement.accept(inlineExpressionCreator);
						Predicate predicate = QVTbaseFactory.eINSTANCE.createPredicate();
						predicate.setConditionExpression(conditionExpression);
						predicates.add(predicate);
					}
				}
			}
		}
	}

	/**
	 * Identify the headNodes/guardNodes and create a guard variable for each guard node.
	 */
	private void createHeadAndGuardNodeVariables() {
		Set<Region> headCallingRegions = new HashSet<Region>();
		Iterable<Edge> recursionEdges = region.getRecursionEdges();
		if (Iterables.size(recursionEdges) > 0) {
			headCallingRegions.add(region);
		}
		for (List<Node> headGroupNodes : region.getHeadNodeGroups()) {
			Node bestHeadNode = null;
			int bestSize = 0;
			boolean isExtraGuard = false;
			for (Node node : headGroupNodes) {
				Iterable<Node> callingSources = node.getPassedBindingSources();
				int size = Iterables.size(callingSources);
				if (size > bestSize) {
					bestHeadNode = node;
					bestSize = size;
				}
				else if (node.getNodeRole().isExtraGuardVariable()) {
					isExtraGuard = true;
				}
				for (Node callingSource : callingSources) {
					headCallingRegions.add(callingSource.getRegion());
				}
			}
			if (!isExtraGuard || (bestHeadNode != null)) {
				assert bestHeadNode != null;
				headNodes.add(bestHeadNode);
			}
		}
		guardNodes.addAll(headNodes);
		for (Node guardNode : region.getGuardNodes()) {
			if (!guardNodes.contains(guardNode)) {
				for (Connection connection : guardNode.getIncomingUsedConnections()) {
//				if (connection != null) {				// null for LOADED
					Set<Region> guardCallingRegions = new HashSet<Region>();
					boolean canBeGuard = true;
					for (Node callingSource : guardNode.getUsedBindingSources()) {
						if (callingSource.getNodeRole().isComposed()) {
							canBeGuard = false;
							break;
						}
						guardCallingRegions.add(callingSource.getRegion());
					}
					for (Node recursionSource : guardNode.getRecursionSources()) {
						guardCallingRegions.add(recursionSource.getRegion());
					}
					if (canBeGuard && guardCallingRegions.containsAll(headCallingRegions) && guardCallingRegions.contains(connection.getCommonRegion())) {
						if (!guardNodes.contains(guardNode)) {
							guardNodes.add(guardNode);
						}
					}
				}
			}
		}
		Collections.sort(guardNodes, NameUtil.NAMEABLE_COMPARATOR);
		for (@SuppressWarnings("null")@NonNull Node guardNode : guardNodes) {
			ClassDatumAnalysis classDatumAnalysis = guardNode.getClassDatumAnalysis();
			TypedModel typedModel = visitor.getQVTiTypedModel(classDatumAnalysis.getTypedModel());
			ImperativeDomain domain = typedModel2domain.get(typedModel);
			assert domain != null;
			GuardPattern guardPattern = domain.getGuardPattern();
			assert guardPattern != null;
			createUnrealizedVariable(guardPattern, guardNode, null);
		}
		//
		//	Create any connectionVariable guards
		//
		createConnectionGuardVariables();
	}

	private @NonNull MappingCall createMappingCall(@NonNull AbstractRegion2Mapping calledRegion2Mapping, @NonNull List<MappingCallBinding> mappingCallBindings) {
		MappingCall mappingCall = QVTimperativeUtil.createMappingCall(calledRegion2Mapping.getMapping(), mappingCallBindings);
		if (calledRegion2Mapping.isInfinite()) {
			mappingCall.setIsInfinite(true);
		}
		return mappingCall;
	}

	private void createMappingStatements(@NonNull Map<Region, Map<Node, Node>> calls) {
		MappingStatement mappingStatement = null;
		Map<Variable, OCLExpression> loopVariables = null;
		for (Map.Entry<Region, Map<Node, Node>> entry : calls.entrySet()) {
			@SuppressWarnings("null")@NonNull Region calledRegion = entry.getKey();
			AbstractRegion2Mapping calledRegion2Mapping = visitor.getRegion2Mapping(calledRegion);
			List<MappingCallBinding> mappingCallBindings = new ArrayList<MappingCallBinding>();
			for (Map.Entry<Node, Node> entry2 : entry.getValue().entrySet()) {
				@SuppressWarnings("null")@NonNull Node sourceNode = entry2.getKey();
				@SuppressWarnings("null")@NonNull Node targetNode = entry2.getValue();
				OCLExpression sourceExpression = getSourceExpression(sourceNode);
				Type type = sourceExpression.getType();
				if (type instanceof CollectionType) {
					if (loopVariables == null) {
						loopVariables = new HashMap<Variable, OCLExpression>();
					}
					Type elementType = ((CollectionType)type).getElementType();
					assert elementType != null;
					Variable loopVariable = PivotUtil.createVariable("loop" + loopVariables.size(), elementType, true, sourceExpression);
					loopVariables.put(loopVariable, sourceExpression);
					sourceExpression = PivotUtil.createVariableExp(loopVariable);
				}
				Variable guardVariable = calledRegion2Mapping.getGuardVariable(targetNode);
				mappingCallBindings.add(QVTimperativeUtil.createMappingCallBinding(guardVariable, sourceExpression));
//					mappingCallBindings.add(QVTimperativeUtil.createMappingLoop(source, iterator, mappingStatement);
			}
/*			Mapping calledMapping = calledRegion2Mapping.getMapping();
			for (Node node : calledRegion2Mapping.getRegion().getPredicatedNodes()) {
				for (Edge edge : node.getIncomingUsedBindingEdges()) {
					Node sourceNode = edge.getSource();
					if (sourceNode.getRegion() == region) {
						OCLExpression sourceExpression = createVariableExp(sourceNode);
						Variable guardVariable = calledRegion2Mapping.getGuardVariable(edge.getTarget());
						MappingCallBinding mappingCallBinding = QVTimperativeUtil.createMappingCallBinding(guardVariable, sourceExpression);
						if (calledMapping.getPolledClasses().size() > 0) {
							mappingCallBinding.setIsPolled(true);		// FIXME temporary backward compatibility
						}
						mappingCallBindings.add(mappingCallBinding);
					}
					else {
						// FIXME find source
					}
				}
			} */
			Collections.sort(mappingCallBindings, QVTimperativeUtil.MappingCallBindingComparator.INSTANCE);
			MappingStatement mappingCallStatement = createMappingCall(calledRegion2Mapping, mappingCallBindings);
			if (loopVariables != null) {
				for (Map.Entry<Variable, OCLExpression> loopEntry : loopVariables.entrySet()) {
					@SuppressWarnings("null")@NonNull Variable loopVariable = loopEntry.getKey();
					@SuppressWarnings("null")@NonNull OCLExpression loopSource = loopEntry.getValue();
					mappingCallStatement = QVTimperativeUtil.createMappingLoop(loopSource, loopVariable, mappingCallStatement);
				}				
			}
			mappingStatement = QVTimperativeUtil.addMappingStatement(mappingStatement, mappingCallStatement);
		}
		mapping.setMappingStatement(mappingStatement);
	}

	/**
	 * Recurse over the guard nodes and loaded/predicates region and convert the edges to predicates and non-guard nodes to unrealized variables.
	 */
	private void createNavigablePredicates() {
		@SuppressWarnings("null")@NonNull BottomPattern bottomPattern = mapping.getBottomPattern();
		Set<Node> reachableNodes = new HashSet<Node>(guardNodes);
		List<Node> sourcesList = new ArrayList<Node>(guardNodes);
		for (int i = 0; i < sourcesList.size(); i++) {
			@SuppressWarnings("null")@NonNull Node sourceNode = sourcesList.get(i);
			for (NavigationEdge edge : sourceNode.getNavigationEdges()) {		// if !edge.getEdgeRole().isRealized() && !targetNode.isNull()
				EdgeRole edgeRole = edge.getEdgeRole();
				if (!edgeRole.isRealized() && !edgeRole.isComposition()) {
					Node targetNode = edge.getTarget();
					if (targetNode.isNull()) {
						// FIXME check in caller
					}
					else if (targetNode.isIterator()) {
						// Process in LoopExp
					}
					else {
						Property property = edge.getProperty();
						if (reachableNodes.add(targetNode)) {
							if (targetNode.isAttributeNode()) {
								if (targetNode.getCompleteClass().getPrimaryClass() instanceof CollectionType) {
									sourcesList.add(targetNode);
								}
								OCLExpression sourceExp = createVariableExp(sourceNode);
								OCLExpression source2targetExp = createCallExp(sourceExp, property);
//								qvti2node.put(source2targetExp, targetNode);
								Variable attributeVariable = node2variable.get(targetNode);
								if (attributeVariable == null) {
									createUnrealizedVariable(bottomPattern, targetNode, source2targetExp);
								}
		/*							else {
										OCLExpression targetExp = PivotUtil.createVariableExp(attributeVariable);
										OCLExpression matchesExp = createOperationCallExp(targetExp, visitor.getEqualsOperation(), source2targetExp);
										Predicate asPredicate = QVTbaseFactory.eINSTANCE.createPredicate();
										asPredicate.setConditionExpression(matchesExp);
										mapping.getBottomPattern().getPredicate().add(asPredicate);
									} */
							}
							else if (expressionCreator.isConditional(targetNode)) {
								
							}
							else if (!guardNodes.contains(targetNode)) {
								sourcesList.add(targetNode);
								OCLExpression sourceExp = createVariableExp(sourceNode);
								OCLExpression source2targetExp = createCallExp(sourceExp, property);
								Variable classVariable = node2variable.get(targetNode);
								if (classVariable == null) {
									classVariable = createUnrealizedVariable(bottomPattern, targetNode, source2targetExp);
								}
								else {
									OCLExpression ownedInit = classVariable.getOwnedInit();
									assert ownedInit == null;
									classVariable.setOwnedInit(source2targetExp);
								}
								
		/*							else {
										OCLExpression targetExp = PivotUtil.createVariableExp(attributeVariable);
										OCLExpression matchesExp = createOperationCallExp(targetExp, visitor.getEqualsOperation(), source2targetExp);
										Predicate asPredicate = QVTbaseFactory.eINSTANCE.createPredicate();
										asPredicate.setConditionExpression(matchesExp);
										mapping.getBottomPattern().getPredicate().add(asPredicate);
									} */
							}
							else {
								sourcesList.add(targetNode);
								Iterable<Node> callingSources = targetNode.getPassedBindingSources();		// Used
								if (Iterables.size(callingSources) <= 0) {			// FIXME check predicate in source etc
									OCLExpression sourceExp = createVariableExp(sourceNode);
									OCLExpression targetExp = createVariableExp(targetNode);
									OCLExpression source2targetExp = createCallExp(sourceExp, property);
									OCLExpression matchesExp = createOperationCallExp(targetExp, visitor.getEqualsOperation(), source2targetExp);
									Predicate asPredicate = QVTbaseFactory.eINSTANCE.createPredicate();
									asPredicate.setConditionExpression(matchesExp);
									mapping.getGuardPattern().getPredicate().add(asPredicate);
								}
							}
						}
					}
				}
			}
		}
	}

	private void createPollingDependencies() {
		DomainUsage anyUsage = region.getSchedulerConstants().getDomainAnalysis().getAnyUsage();
		for (@SuppressWarnings("null")@NonNull TypedModel qvtpTypedModel : anyUsage.getTypedModels()) {
			TypedModel qvtiTypedModel = visitor.getQVTiTypedModel(qvtpTypedModel);
			ImperativeDomain domain = typedModel2domain.get(qvtiTypedModel);
			ImperativeArea imperativeArea = domain != null ? (ImperativeArea)domain : mapping;
			Iterable<NavigationEdge> checkedEdges = region.getCheckedEdges(qvtpTypedModel);
			if (checkedEdges != null) {
				List<Property> checkedProperties = imperativeArea.getCheckedProperties();
				for (NavigationEdge checkedEdge : checkedEdges) {
					checkedProperties.add(checkedEdge.getProperty());
				}
			}
			Iterable<NavigationEdge> enforcedEdges = region.getEnforcedEdges(qvtpTypedModel);
			if (enforcedEdges != null) {
				List<Property> enforcedProperties = imperativeArea.getEnforcedProperties();
				for (NavigationEdge enforcedEdge : enforcedEdges) {
					enforcedProperties.add(enforcedEdge.getProperty());
				}
			}
		}
	}

	private void createPropertyAssignments() {
		Map<Node, List<NavigationEdge>> classAssignments = null;
		for (NavigationEdge edge : region.getRealizedNavigationEdges()) {
			Node sourceNode = edge.getSource();
			Node targetNode = edge.getTarget();
			if (targetNode.isAttributeNode()) {
				OCLExpression slotVariableExp = createVariableExp(sourceNode);
				Property property = edge.getProperty();
				OCLExpression valueExp = expressionCreator.getExpression(targetNode);
				if (valueExp == null) {
					valueExp = expressionCreator.getExpression(targetNode);		// FIXME debugging
				}
				assert valueExp != null;
				PropertyAssignment propertyAssignment = QVTimperativeUtil.createPropertyAssignment(slotVariableExp, property, valueExp);
				mapping.getBottomPattern().getAssignment().add(propertyAssignment);
			}
			else {
				if (classAssignments == null) {
					classAssignments = new HashMap<Node, List<NavigationEdge>>();
				}
				List<NavigationEdge> edges = classAssignments.get(sourceNode);
				if (edges == null) {
					edges = new ArrayList<NavigationEdge>();
					classAssignments.put(sourceNode, edges);
				}
				edges.add(edge);
			}
		}
		if (classAssignments != null) {
			pruneClassAssignments(classAssignments);
			Collection<List<NavigationEdge>> values = classAssignments.values();
			createClassPropertyAssignments(values);
		}
		ECollections.sort(mapping.getBottomPattern().getAssignment(), new Comparator<Assignment>()
		{
			@Override
			public int compare(Assignment o1, Assignment o2) {
				if (o1 instanceof PropertyAssignment) {
					if (o2 instanceof PropertyAssignment) {
						Property p1 = ((PropertyAssignment)o1).getTargetProperty();
						Property p2 = ((PropertyAssignment)o2).getTargetProperty();
						String n1 = p1.getName();
						String n2 = p2.getName();
						int diff = ClassUtil.safeCompareTo(n1, n2);
						if (diff != 0) {
							return diff;
						}
						n1 = p1.toString();
						n2 = p2.toString();
						return ClassUtil.safeCompareTo(n1, n2);
					}
					else {
						return -1;
					}
				}
				else if (o1 instanceof VariableAssignment) {
					if (o2 instanceof PropertyAssignment) {
						return -1;
					}
					else if (o2 instanceof VariableAssignment) {
						Variable v1 = ((VariableAssignment)o1).getTargetVariable();
						Variable v2 = ((VariableAssignment)o2).getTargetVariable();
						String n1 = v1.getName();
						String n2 = v2.getName();
						return ClassUtil.safeCompareTo(n1, n2);
					}
				}
				return 0;
			}
		});
	}

	private void createRealizedVariables() {
		for (Node node : region.getRealizedVariableNodes()) {
			ClassDatumAnalysis classDatumAnalysis = node.getClassDatumAnalysis();
			BottomPattern bottomPattern = getArea(classDatumAnalysis.getDomainUsage()).getBottomPattern();
			RealizedVariable realizedVariable = QVTimperativeUtil.createRealizedVariable(getSafeName(node), classDatumAnalysis.getCompleteClass().getPrimaryClass());
			bottomPattern.getRealizedVariable().add(realizedVariable);
			Variable oldVariable = node2variable.put(node, realizedVariable);
			assert oldVariable == null;
		}
	}

	@Override
	public void createStatements() {
		Map<Region, Map<Node, Node>> calls = null;
//		for (@SuppressWarnings("null")@NonNull Region calledRegion : getEarliestFirstCalledRegions()) {
		for (@SuppressWarnings("null")@NonNull Region calledRegion : region.getCallableChildren()) {
			if (calls == null) {
				calls = new HashMap<Region, Map<Node, Node>>();
			}
			Map<Node, Node> source2target = calls.get(calledRegion);
			if (source2target == null) {
				source2target = new HashMap<Node, Node>();
				calls.put(calledRegion, source2target);
			}
			AbstractRegion2Mapping calledRegion2Mapping = visitor.getRegion2Mapping(calledRegion);
			for (Node calledGuardNode : calledRegion2Mapping.getGuardNodes()) {
				for (Node callingNode : calledGuardNode.getPassedBindingSources()) {
					if (callingNode.getRegion() == region) {
						Node oldNode = source2target.put(callingNode, calledGuardNode);
						assert oldNode == null;
					}
				}
				for (Node callingNode : calledGuardNode.getUsedBindingSources()) {
					if (callingNode.getRegion() == region) {
						Node oldNode = source2target.put(callingNode, calledGuardNode);
						assert oldNode == null;
					}
				}
			}
		}
		if (calls != null) {
			createMappingStatements(calls);
		}
	}
	
	private @NonNull Variable createUnrealizedVariable(@NonNull CorePattern pattern, @NonNull Node node, @Nullable OCLExpression initExpression) {
		Type variableType = node.getCompleteClass().getPrimaryClass();
		assert variableType != null;
		boolean isRequired = false;
		if (initExpression != null) {
			Type initType = initExpression.getType();
			assert variableType != null;
			if (!initType.conformsTo(visitor.getStandardLibrary(), variableType)) {
				initExpression = createOclAsTypeCallExp(initExpression, variableType);
			}
			isRequired = initExpression.isIsRequired();
		}
		Variable variable = PivotUtil.createVariable(getSafeName(node), variableType, isRequired, initExpression);
		pattern.getVariable().add(variable);
		Variable oldVariable = node2variable.put(node, variable);
		assert oldVariable == null;
		return variable;
	}

	private @NonNull OCLExpression createVariableExp(@NonNull Node node) {
		if (node.isNull()) {
			return createNullLiteralExp();
		}
		else {
			Variable variable = node2variable.get(node);
			if (variable == null) {
				for (Edge edge : node.getIncomingEdges()) {
					if (edge.isArgument() || edge.isCast()) {
						OCLExpression initExpression = edge.getSource().getTypedElements().iterator().next().accept(expressionCreator);
						BottomPattern bottomPattern = mapping.getBottomPattern();
						assert bottomPattern != null;
						variable = createUnrealizedVariable(bottomPattern, node, initExpression);
						break;
					}
				}
			}
			assert variable != null;
			return PivotUtil.createVariableExp(variable);
		}
	}
	
/*	private @Nullable Integer depthRecursion(@NonNull Node node, @NonNull Map<Node, Integer> node2pathDepth,
			@NonNull Map<Node, Integer> node2acyclicDepth, @NonNull Map<Node, Integer> node2cyclicDepth) {
		Integer pathDepth = node2pathDepth.get(node);
		if (pathDepth != null) {
			return pathDepth;
		}
		Integer recursiveDepth = null;
		pathDepth = node2pathDepth.size();
		node2pathDepth.put(node, pathDepth);
		for (Edge edge : node.getOutgoingEdges()) {
			if (edge.isNavigation() || edge.isComputation()) {
				Node nextNode = edge.getTarget();
				Integer nextDepth = depthRecursion(nextNode, node2pathDepth, node2acyclicDepth, node2cyclicDepth);
				if (nextDepth == null) {
					Integer acyclicDepth = node2acyclicDepth.get(node);
					if ((acyclicDepth == null) || (acyclicDepth < pathDepth)) {
						node2acyclicDepth.put(node, pathDepth);
					}
				}
				else {
					Integer cyclicDepth = node2cyclicDepth.get(node);
					if ((cyclicDepth == null) || (pathDepth < cyclicDepth)) {
						node2cyclicDepth.put(node, pathDepth);
					}
					if ((recursiveDepth == null) || (nextDepth < recursiveDepth)) {
						recursiveDepth = nextDepth;
					}
				}
			}
		}
		node2pathDepth.remove(node);
		return recursiveDepth;
	} */

	private @NonNull Area getArea(@NonNull DomainUsage domainUsage) {	
		TypedModel qvtpTypedModel = domainUsage.getTypedModel();
		ImperativeDomain coreDomain = typedModel2domain.get(qvtpTypedModel);
		if (coreDomain != null) {
			return coreDomain;
		}
		TypedModel qvtiTypedModel = visitor.qvtpTypedModel2qvtiTypedModel.get(qvtpTypedModel);		// FIXME shouldn't happen
		coreDomain = typedModel2domain.get(qvtiTypedModel);
		if (coreDomain != null) {
			return coreDomain;
		}
//		for (Domain domain : mapping.getDomain()) {
//			if (domain.getTypedModel() == qvtiTypedModel) {
//				return (ImperativeDomain)domain;
//			}
//		}
		return mapping;
	}

	@Override
	public @NonNull List<Node> getGuardNodes() {
		return guardNodes;
	}

	@Override
	public @NonNull Variable getGuardVariable(@NonNull Node node) {
//		Area area = getArea(mapping, node.getClassDatumAnalysis().getDomainUsage());
//		String name = getName(node);
//		Variable variable = NameUtil.getNameable(area.getGuardPattern().getVariable(),name);
		Variable variable = node2variable.get(node);
		assert variable != null;
		return variable;
	}

/*	@Override
	public @Nullable Node getNode(@Nullable TypedElement typedElement) {
		Node node = qvti2node.get(typedElement);
		if (node != null) {
			return node;
		}
		else {
			return super.getNode(typedElement);
		}
	} */

	private @NonNull OCLExpression getSourceExpression(@NonNull Node sourceNode) {
		return createVariableExp(sourceNode);
	}
	
	public @Nullable Variable getVariable(@NonNull Node node) {
		return node2variable.get(node);
	}

	private boolean isIfExp(@NonNull Node node) {
		if (node.isExpression()) {
			for (TypedElement typedElement : node.getTypedElements()) {
				if (typedElement instanceof IfExp) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean isInfinite() {
		if (region.getRecursionEdges().iterator().hasNext()) {		// FIXME unduly pessimistic
			return true;
		}	
		return false;
	}

	/**
	 * Filter classAssignments to retain only one of each opposite-property assignment pair.
	 */
	private void pruneClassAssignments(@NonNull Map<Node, List<NavigationEdge>> classAssignments) {
		for (Node sourceNode : new ArrayList<Node>(classAssignments.keySet())) {
			List<NavigationEdge> forwardEdges = classAssignments.get(sourceNode);
			assert forwardEdges != null;
			for (int iForward = forwardEdges.size()-1; iForward >= 0; iForward--) {
				NavigationEdge forwardEdge = forwardEdges.get(iForward);
				Node targetNode = forwardEdge.getTarget();
				List<NavigationEdge> reverseEdges = classAssignments.get(targetNode);
				if (reverseEdges != null) {
					for (int iReverse = reverseEdges.size()-1; iReverse >= 0; iReverse--) {
						NavigationEdge reverseEdge = reverseEdges.get(iReverse);
						if (sourceNode == reverseEdge.getTarget()) {
							Property forwardProperty = forwardEdge.getProperty();
							Property reverseProperty = reverseEdge.getProperty();
							if (forwardProperty.getOpposite() == reverseProperty) {
								if (forwardProperty.isIsImplicit()) {
									forwardEdges.remove(forwardEdge);
								}
								else if (reverseProperty.isIsImplicit()) {
									reverseEdges.remove(reverseEdge);
								}
								else if (sourceNode.isInternal()) {
									forwardEdges.remove(forwardEdge);
								}
								else if (targetNode.isInternal()) {
									reverseEdges.remove(reverseEdge);
								}
								else {		// FIXME do we prefer either direction ?
									reverseEdges.remove(reverseEdge);
								}
							}
						}
					}
				}
			}
		}
	}
}