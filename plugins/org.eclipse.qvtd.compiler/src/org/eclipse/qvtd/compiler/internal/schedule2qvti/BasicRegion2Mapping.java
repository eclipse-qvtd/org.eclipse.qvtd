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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.qvtd.compiler.internal.scheduler.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.scheduler.Edge;
import org.eclipse.qvtd.compiler.internal.scheduler.EdgeRole;
import org.eclipse.qvtd.compiler.internal.scheduler.NavigationEdge;
import org.eclipse.qvtd.compiler.internal.scheduler.Node;
import org.eclipse.qvtd.compiler.internal.scheduler.NodeConnection;
import org.eclipse.qvtd.compiler.internal.scheduler.Region;
import org.eclipse.qvtd.compiler.internal.scheduler.RegionUtil;
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
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractExtendingQVTimperativeVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

import com.google.common.collect.Iterables;

public class BasicRegion2Mapping extends AbstractRegion2Mapping
{		
	private static final class DomainNameComparator implements Comparator<@NonNull Domain>
	{
		public static final @NonNull DomainNameComparator INSTANCE = new DomainNameComparator();

		@Override
		public int compare(@NonNull Domain o1, @NonNull Domain o2) {
			TypedModel t1 = o1.getTypedModel();
			TypedModel t2 = o2.getTypedModel();
			String n1 = t1 != null ? t1.getName() : null;
			String n2 = t2 != null ? t2.getName() : null;
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	private class ExpressionCreator extends AbstractExtendingQVTimperativeVisitor<@NonNull OCLExpression, @NonNull BasicRegion2Mapping>
	{
		protected final @NonNull Set<@NonNull Node> multiAccessedNodes = new HashSet<@NonNull Node>();
		protected final @NonNull Set<@NonNull Node> conditionalNodes = new HashSet<@NonNull Node>();

		public ExpressionCreator() {
			super(BasicRegion2Mapping.this);
			analyzeExpressions(multiAccessedNodes, conditionalNodes);
		}

		/**
		 * Compute the nodes that are only evaluated if a run-time if-condition is satisfied, and the nodes that are always accessed more than once.
		 */
		private void analyzeExpressions(@NonNull Set<Node> multiAccessedNodes, @NonNull Set<Node> conditionalNodes) {
			Set<@NonNull Node> unconditionalNodes = new HashSet<@NonNull Node>();
			for (@NonNull Edge edge : region.getRealizedEdges()) {
				analyzeIncomingPath(edge.getTarget(), unconditionalNodes, conditionalNodes, false);
			}
			conditionalNodes.removeAll(unconditionalNodes);
//			if (conditionalNodes.size() > 0) {
//				System.out.println("Conditional nodes for " + this);
//				for (Node conditionalNode : conditionalNodes) {
//					System.out.println("  " + conditionalNode);
//				}
//			}
			for (@NonNull Node node : unconditionalNodes) {
				int accesses = 0;
				for (@NonNull Edge outgoingEdge : node.getOutgoingEdges()) {
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
				for (@NonNull Edge edge : node.getIncomingEdges()) {
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
				if ((initExpression instanceof PrimitiveLiteralExp) || hasRealizedVariableReference(initExpression) || conditionalNodes.contains(node)) {
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

		private @NonNull List<@NonNull OCLExpression> createAll(@NonNull List<@NonNull OCLExpression> oldTypedElements) {
			List<@NonNull OCLExpression> newTypedElements = new ArrayList<@NonNull OCLExpression>(oldTypedElements.size());
			for (@NonNull OCLExpression oldTypedElement : oldTypedElements) {
				OCLExpression newTypedElement = create(oldTypedElement);
				assert newTypedElement != null;
				newTypedElements.add(newTypedElement);
			}
			return newTypedElements;
		}

		private @NonNull OCLExpression createNonNull(@Nullable OCLExpression oldTypedElement) {
			assert oldTypedElement != null;
			Node node = context.getNode(oldTypedElement);
			if (node == null) {
				node = context.getNode(oldTypedElement);		// FIXME debugging
			}
			return create(node);
		}

		private @NonNull List<@NonNull Variable> createVariables(@NonNull List<@NonNull Variable> oldVariables) {
			List<@NonNull Variable> newVariables = new ArrayList<@NonNull Variable>(oldVariables.size());
			for (@NonNull Variable oldVariable : oldVariables) {
				Variable newVariable = createVariable(oldVariable);
				newVariables.add(newVariable);
			}
			return newVariables;
		}

		private @NonNull Variable createVariable(@NonNull Variable oldVariable) {
			String name = oldVariable.getName();
			assert name != null;
			Type type = oldVariable.getType();
			assert type != null;
			Variable newVariable = PivotUtil.createVariable(name, type, oldVariable.isIsRequired(), create(oldVariable.getOwnedInit()));
			Node variableNode = getNode(oldVariable);
			if (variableNode != null) {
				node2variable.put(variableNode, newVariable);
			}
			return newVariable;
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
			for (@NonNull Edge edge : node.getArgumentEdges()) {
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
			for (@NonNull Edge edge : node.getIncomingEdges()) {
				EdgeRole edgeRole = edge.getEdgeRole();
				if (edgeRole.isNavigation()) {
					if (edgeRole.isLoaded()) {
						OCLExpression source = getExpression(edge.getSource());
						if (source != null) {
							return PivotUtil.createNavigationCallExp(source, ((NavigationEdge)edge).getProperty());
						}
					}
					else if (edgeRole.isPredicated()) {
						OCLExpression source = create(edge.getSource());
						if (source != null) {
							return PivotUtil.createNavigationCallExp(source, ((NavigationEdge)edge).getProperty());
						}
					}
				}
			}
			return null;
		}

		private boolean hasRealizedVariableReference(@NonNull OCLExpression oclExpression) {
			for (TreeIterator<EObject> tit = oclExpression.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof VariableExp) {
					if (((VariableExp)eObject).getReferredVariable() instanceof RealizedVariable) {
						return true;
					}
				}
			}
			return false;
		}

		public boolean isConditional(@NonNull Node node) {
			return conditionalNodes.contains(node);
		}

		@Override
		public @NonNull OCLExpression visitCollectionLiteralExp(@NonNull CollectionLiteralExp pCollectionLiteralExp) {
			List<@NonNull CollectionLiteralPart> clonedParts = new ArrayList<@NonNull CollectionLiteralPart>();
			for (@NonNull CollectionLiteralPart pPart : ClassUtil.nullFree(pCollectionLiteralExp.getOwnedParts())) {
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
			OCLExpression iSource = create(pIterateExp.getOwnedSource());
			assert iSource != null;
			List<@NonNull ? extends Variable> iIterators = createVariables(ClassUtil.nullFree(pIterateExp.getOwnedIterators()));
			Variable result = createVariable(ClassUtil.nonNull(pIterateExp.getOwnedResult()));
			Iteration referredIteration = (Iteration) visitor.create(pIterateExp.getReferredIteration());
			assert referredIteration != null;
			OCLExpression iBody = inlineExpressionCreator.create(pIterateExp.getOwnedBody());
			assert iBody != null;
			return createIterateExp(iSource, referredIteration, iIterators, result, iBody);
		}

		@Override
		public @NonNull OCLExpression visitIteratorExp(@NonNull IteratorExp pIteratorExp) {
			OCLExpression iSource = create(pIteratorExp.getOwnedSource());
			assert iSource != null;
			List<@NonNull ? extends Variable> iIterators = createVariables(ClassUtil.nullFree(pIteratorExp.getOwnedIterators()));
			Iteration referredIteration = (Iteration) visitor.create(pIteratorExp.getReferredIteration());
			assert referredIteration != null;
			OCLExpression iBody = inlineExpressionCreator.create(pIteratorExp.getOwnedBody());
			assert iBody != null;
			return createIteratorExp(iSource, referredIteration, iIterators, iBody);
		}

		@Override
		public @NonNull OCLExpression visitMapLiteralExp(@NonNull MapLiteralExp pMapLiteralExp) {
			List<@NonNull MapLiteralPart> clonedParts = new ArrayList<@NonNull MapLiteralPart>();
			for (@NonNull MapLiteralPart pPart : ClassUtil.nullFree(pMapLiteralExp.getOwnedParts())) {
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
			List<@NonNull OCLExpression> iArguments = createAll(ClassUtil.nullFree(pOperationCallExp.getOwnedArguments()));
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
			List<@NonNull ShadowPart> clonedParts = new ArrayList<@NonNull ShadowPart>();
			for (@NonNull ShadowPart pPart : ClassUtil.nullFree(pShadowExp.getOwnedParts())) {
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
			List<@NonNull TupleLiteralPart> clonedParts = new ArrayList<@NonNull TupleLiteralPart>();
			for (@NonNull TupleLiteralPart pPart : ClassUtil.nullFree(pTupleLiteralExp.getOwnedParts())) {
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
			assert referredType != null;
			return createTypeExp(referredType);
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
				if ((oldTypedElement instanceof Variable) && (((Variable)oldTypedElement).getOwnedInit() == null)) {
//					for (@NonNull Edge edge : node.getIncomingEdges()) {
//						if (edge.isArgument() || edge.isCast()) {
							BottomPattern bottomPattern = mapping.getBottomPattern();
							assert bottomPattern != null;
							theVariable = createUnrealizedVariable(bottomPattern, node, null);
//							break;
//						}
//					}
				}
				else {
					return oldTypedElement.accept(this);
				}
				assert theVariable != null;
			}
			return PivotUtil.createVariableExp(theVariable);
		}
	}
	
	/**
	 * The selected head from each head group that is actually passed. Other heads are computed.
	 */
	private final @NonNull List<@NonNull Node> headNodes = new ArrayList<@NonNull Node>();

	/**
	 * The subset of possible guard nodes that all callers can pass..
	 */
	private final @NonNull List<@NonNull Node> guardNodes = new ArrayList<@NonNull Node>();

	/**
	 * Mapping from the scheduled Nodes to their QVTi variables.
	 */
	private final @NonNull Map<@NonNull Node, @NonNull Variable> node2variable = new HashMap<@NonNull Node, @NonNull Variable>();

	/**
	 * Mapping from the TypedModel to its ImperativeDomain.
	 */
	private final @NonNull Map<@NonNull TypedModel, @NonNull ImperativeDomain> typedModel2domain = new HashMap<@NonNull TypedModel, @NonNull ImperativeDomain>();
	
	/**
	 * Mapping from QVTi expression to Schedule Node.
	 */
//	private final @NonNull Map<TypedElement, Node> qvti2node = new HashMap<TypedElement, Node>();

	private final @NonNull ExpressionCreator expressionCreator;
	private final @NonNull ExpressionCreator inlineExpressionCreator = new InlineExpressionCreator();

	public BasicRegion2Mapping(@NonNull QVTs2QVTiVisitor visitor, @NonNull Region region) {
		super(visitor, region);
		this.expressionCreator = new ExpressionCreator();
		@SuppressWarnings("unused")String name = region.getName();
		createEmptyDomainsAndPatterns();
		createHeadAndGuardNodeVariables();
		createNavigablePredicates();
		createExternalPredicates();
		createRealizedVariables();
		createPropertyAssignments();
		createConnectionAssignments();
		createPollingDependencies();
	}

	/**
	 * Add asPredicate to the bottom pattern if any bottom variable is referenced, otherwise add to the guard pattern.
	 */
	protected void addPredicate(@NonNull Predicate asPredicate) {
		boolean isBottom = false;
		for (TreeIterator<EObject> tit = asPredicate.eAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof VariableExp) {
				VariableDeclaration variable = ((VariableExp)eObject).getReferredVariable();
				if ((variable != null) && (variable.eContainer() instanceof BottomPattern)) {
					isBottom = true;
					break;
				}
			}
		}
		if (isBottom) {
			mapping.getBottomPattern().getPredicate().add(asPredicate);
		}
		else {
			mapping.getGuardPattern().getPredicate().add(asPredicate);
		}
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

	private void createClassPropertyAssignments(@NonNull Iterable<@NonNull List<@NonNull NavigationEdge>> classAssignments) {
		for (@NonNull List<@NonNull NavigationEdge> edges : classAssignments) {
			for (@NonNull NavigationEdge edge : edges) {
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
			for (@NonNull NodeConnection connection : connection2variable.keySet()) {
				Node sourceNode = connection.getSource(region);
				OCLExpression variableExpression = createVariableExp(sourceNode);
				ConnectionVariable connectionVariable = (ConnectionVariable)connection2variable.get(connection);
				assert connectionVariable != null;
				createConnectionAssignment(connectionVariable, variableExpression);
			}
		}
	}

	/**
	 * Create the domains and guard/bottom patterns.
	 */
	private void createEmptyDomainsAndPatterns() {
		Set<@NonNull TypedModel> checkableTypedModels = new HashSet<@NonNull TypedModel>();
		Set<@NonNull TypedModel> enforceableTypedModels = new HashSet<@NonNull TypedModel>();
		for (@NonNull Node node : region.getNodes()) {
			ClassDatumAnalysis classDatumAnalysis = node.getClassDatumAnalysis();
			Type type = classDatumAnalysis.getClassDatum().getType();
			if (!(type instanceof DataType) && !(type instanceof AnyType) && !(type instanceof VoidType) && !(type instanceof InvalidType)) {
				DomainUsage domainUsage = classDatumAnalysis.getDomainUsage();
				if (domainUsage.isInput()) {		// EObject is $primitive$
					for (@NonNull TypedModel typedModel : domainUsage.getTypedModels()) {
						TypedModel qvtiTypedModel = visitor.getQVTiTypedModel(typedModel);
						assert qvtiTypedModel != null;
						checkableTypedModels.add(qvtiTypedModel);
					}
				}
				if (domainUsage.isOutput()) {		// EObject is $primitive$
					for (@NonNull TypedModel typedModel : domainUsage.getTypedModels()) {
						TypedModel qvtiTypedModel = visitor.getQVTiTypedModel(typedModel);
						assert qvtiTypedModel != null;
						enforceableTypedModels.add(qvtiTypedModel);
					}
				}
			}
		}
		checkableTypedModels.removeAll(enforceableTypedModels);
		for (@NonNull TypedModel qvtiTypedModel : checkableTypedModels) {
			ImperativeDomain domain = QVTimperativeUtil.createImperativeDomain(qvtiTypedModel);
			domain.setIsCheckable(true);
			mapping.getDomain().add(domain);
			ImperativeDomain oldDomain = typedModel2domain.put(qvtiTypedModel, domain);
			assert oldDomain == null;
		}
		for (@NonNull TypedModel qvtiTypedModel : enforceableTypedModels) {
			ImperativeDomain domain = QVTimperativeUtil.createImperativeDomain(qvtiTypedModel);
			domain.setIsEnforceable(true);
			mapping.getDomain().add(domain);
			ImperativeDomain oldDomain = typedModel2domain.put(qvtiTypedModel, domain);
			assert oldDomain == null;
		}
		ECollections.sort(ClassUtil.nullFree(mapping.getDomain()), DomainNameComparator.INSTANCE);
	}

	/**
	 * Create a predicate expression for each TRUE 'head'.
	 */
	private void createExternalPredicates() {
		for (@NonNull Node node : region.getNodes()) {
			if (node.isTrue()) {
				for (@NonNull Edge edge : node.getArgumentEdges()) {
					Node predicateNode = edge.getSource();
					for (@NonNull TypedElement typedElement : predicateNode.getTypedElements()) {
						OCLExpression conditionExpression = typedElement.accept(inlineExpressionCreator);
						Predicate asPredicate = QVTbaseFactory.eINSTANCE.createPredicate();
						asPredicate.setConditionExpression(conditionExpression);
						addPredicate(asPredicate);
					}
				}
			}
		}
	}

	/**
	 * Identify the headNodes/guardNodes and create a guard variable for each guard node.
	 */
	private void createHeadAndGuardNodeVariables() {
		Set<@NonNull Region> headCallingRegions = new HashSet<@NonNull Region>();
		Iterable<@NonNull Edge> recursionEdges = region.getRecursionEdges();
		if (Iterables.size(recursionEdges) > 0) {
			headCallingRegions.add(region);
		}
		for (@NonNull Node headNode : region.getHeadNodes()) {
			Node bestHeadNode = null;
			boolean isExtraGuard = false;
			Iterable<@NonNull Node> callingSources = headNode.getPassedBindingSources();
			if (!Iterables.isEmpty(callingSources)) {
				bestHeadNode = headNode;
			}
			else if (headNode.getNodeRole().isExtraGuardVariable()) {
				isExtraGuard = true;
			}
			for (@NonNull Node callingSource : callingSources) {
				headCallingRegions.add(callingSource.getRegion());
			}
			if (!isExtraGuard || (bestHeadNode != null)) {
				assert bestHeadNode != null;
				headNodes.add(bestHeadNode);
			}
		}
		guardNodes.addAll(headNodes);
		for (@NonNull Node guardNode : region.getGuardNodes()) {
			if (!guardNodes.contains(guardNode)) {
				NodeConnection connection = guardNode.getIncomingUsedConnection();
				if (connection != null) {				// null for LOADED
					Set<Region> guardCallingRegions = new HashSet<Region>();
					boolean canBeGuard = true;
					for (@NonNull Node callingSource : guardNode.getUsedBindingSources()) {
						if (callingSource.getNodeRole().isComposed()) {
							canBeGuard = false;
							break;
						}
						guardCallingRegions.add(callingSource.getRegion());
					}
					for (@NonNull Node recursionSource : guardNode.getRecursionSources()) {
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
		for (@NonNull Node guardNode : guardNodes) {
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

	private void createMappingStatements(@NonNull Map<@NonNull Region, @NonNull Map<@NonNull Node, @NonNull Node>> calls) {
		MappingStatement mappingStatement = null;
		Map<@NonNull Variable, @NonNull OCLExpression> loopVariables = null;
		for (Map.Entry<@NonNull Region, @NonNull Map<@NonNull Node, @NonNull Node>> entry : calls.entrySet()) {
			@NonNull Region calledRegion = entry.getKey();
			AbstractRegion2Mapping calledRegion2Mapping = visitor.getRegion2Mapping(calledRegion);
			List<@NonNull MappingCallBinding> mappingCallBindings = new ArrayList<@NonNull MappingCallBinding>();
			for (Map.Entry<@NonNull Node, @NonNull Node> entry2 : entry.getValue().entrySet()) {
				@NonNull Node sourceNode = entry2.getKey();
				@NonNull Node targetNode = entry2.getValue();
				OCLExpression sourceExpression = getSourceExpression(sourceNode);
				Type type = sourceExpression.getType();
				if (type instanceof CollectionType) {
					if (loopVariables == null) {
						loopVariables = new HashMap<@NonNull Variable, @NonNull OCLExpression>();
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
			MappingStatement mappingCallStatement = calledRegion2Mapping.createMappingCall(mappingCallBindings);
			if (loopVariables != null) {
				for (Map.Entry<@NonNull Variable, @NonNull OCLExpression> loopEntry : loopVariables.entrySet()) {
					@NonNull Variable loopVariable = loopEntry.getKey();
					@NonNull OCLExpression loopSource = loopEntry.getValue();
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
		String name = region.getName();
		//
		//	Categorize the relevant navigation edges
		//
		Set<@NonNull NavigationEdge> backwardEdges = new HashSet<@NonNull NavigationEdge>();
		Set<@NonNull NavigationEdge> forwardEdges = new HashSet<@NonNull NavigationEdge>();
//		Set<@NonNull NavigationEdge> attributeEdges = new HashSet<@NonNull NavigationEdge>();
		/*
		 * The nodes that form the traversal forest.
		 */
		Set<@NonNull Node> navigableNodes = new HashSet<@NonNull Node>();
		/*
		 * The edges that are not traversed while locating each node.
		 */
		Set<@NonNull NavigationEdge> untraversedEdges = new HashSet<@NonNull NavigationEdge>();
		for (@NonNull NavigationEdge edge : region.getNavigationEdges()) {
			if (edge.isRealized()) {}
			else if (!edge.isNavigable()) {}
			else if (edge.isCast()) {}
			else {
				assert !edge.isArgument();
				assert !edge.isComputation();
				Node sourceNode = edge.getSource();
				navigableNodes.add(sourceNode);
				Node targetNode = edge.getTarget();
				if (targetNode.isNull()) {
					untraversedEdges.add(edge);
				}
				else {
					targetNode = RegionUtil.getCastTarget(targetNode);
					Property property = edge.getProperty();
					if (property.isIsImplicit()) {
						backwardEdges.add(edge);
						navigableNodes.add(targetNode);
					}
	//				else if (targetNode.isAttributeNode()) {
	//					attributeEdges.add(edge);
	//				}
					else {
						forwardEdges.add(edge);
						navigableNodes.add(targetNode);
					}
				}
			}
		}
		//
		//	Identify the edges that need traversal to reach as all nodes preferring forwardEdges.
		//
		/*
		 * The edges that are traversed while locating each node and their depth in the traversal forest.
		 */
		Map<@NonNull NavigationEdge, @NonNull Integer> traversedEdge2depth = new HashMap<@NonNull NavigationEdge, @NonNull Integer>();
		/*
		 * The incoming edge for each node in the traversal forest, null at a root.
		 */
		Map<@NonNull Node, @Nullable NavigationEdge> traversedNode2incomingEdge = new HashMap<@NonNull Node, @Nullable NavigationEdge>();
		for (@NonNull Node guardNode : guardNodes) {
			traversedNode2incomingEdge.put(guardNode, null);
		}
		Set<@NonNull Node> moreNodes = new HashSet<@NonNull Node>(guardNodes);
		int depth = 0;
		while (moreNodes.size() > 0) {
			//
			//	Select the forward edges that make progress.
			//
			Set<@NonNull Node> moreMoreNodes = new HashSet<@NonNull Node>();
			for (@NonNull Node sourceNode : moreNodes) {
				for (@NonNull NavigationEdge edge : sourceNode.getNavigationEdges()) {
					if (forwardEdges.contains(edge)) {
						Node targetNode = RegionUtil.getCastTarget(edge.getTarget());
						if (!traversedNode2incomingEdge.containsKey(targetNode)) {
							traversedNode2incomingEdge.put(targetNode, edge);
							moreMoreNodes.add(targetNode);
							traversedEdge2depth.put(edge, depth);
						}
						else {
							untraversedEdges.add(edge);
						}
					}
				}
			}
			if (moreMoreNodes.isEmpty() && (traversedNode2incomingEdge.size() < navigableNodes.size())) {
				//
				//	Unblock an incomplete traversal by choosing a backward edge.
				//
				for (@NonNull NavigationEdge edge : backwardEdges) {		// FIXME maintain reducing list of possibles
					Node sourceNode = edge.getSource();
					if (traversedNode2incomingEdge.containsKey(sourceNode)) {
						Node targetNode = edge.getTarget();
						if (!traversedNode2incomingEdge.containsKey(targetNode)) {
							traversedNode2incomingEdge.put(targetNode, edge);
							moreMoreNodes.add(targetNode);
							traversedEdge2depth.put(edge, depth);
							break;
						}
					}
				}
			}
			moreNodes = moreMoreNodes;
			depth++;
		}
		//
		//	Traverse the attributes too.
		//
/*		for (@NonNull NavigationEdge edge : attributeEdges) {
			Node targetNode = edge.getTarget();
			if (!traversedNode2incomingEdge.containsKey(targetNode)) {
				traversedNode2incomingEdge.put(targetNode, edge);
			}
			else {
				untraversedEdges.add(edge);
			}
		} */
		//
		//	Identify the remaining untraversed edges that are not used to reach nodes and so must be reified as predicates to check nodes.
		//
		for (@NonNull NavigationEdge edge : forwardEdges) {
			if (!traversedEdge2depth.containsKey(edge)) {
				NavigationEdge oppositeEdge = getOppositeEdge(edge);
				if ((oppositeEdge == null) || !traversedEdge2depth.containsKey(oppositeEdge)) {
					untraversedEdges.add(edge);
				}
			}
		}
		for (@NonNull NavigationEdge edge : backwardEdges) {
			if (!traversedEdge2depth.containsKey(edge) && !untraversedEdges.contains(edge)) {
				NavigationEdge oppositeEdge = getOppositeEdge(edge);
				if ((oppositeEdge == null) || (!traversedEdge2depth.containsKey(oppositeEdge) && !untraversedEdges.contains(edge))) {
					untraversedEdges.add(edge);
				}
			}
		}
		//
		//	Order the traversal edges shallowest first then alphabetically.
		//
		List<@NonNull NavigationEdge> traversedEdges = new ArrayList<@NonNull NavigationEdge>(traversedEdge2depth.keySet());
		Collections.sort(traversedEdges, new Comparator<@NonNull NavigationEdge>() {
			@Override
			public int compare(@NonNull NavigationEdge o1, @NonNull NavigationEdge o2) {
				Integer d1 = traversedEdge2depth.get(o1);
				Integer d2 = traversedEdge2depth.get(o2);
				assert (d1 != null) && (d2 != null);
				if (d1 != d2) {
					return d1 - d2;
				}
				String n1 = o1.getDisplayName();
				String n2 = o2.getDisplayName();
				return n1.compareTo(n2);
			}
		});
		//
		//	Convert the traversed edges to unrealized variables and initializers.
		//
		BottomPattern bottomPattern = mapping.getBottomPattern();
		assert bottomPattern != null;
		for (@NonNull NavigationEdge traversedEdge : traversedEdges) {
			Node sourceNode = traversedEdge.getSource();
			Node targetNode = traversedEdge.getTarget();
			Property property = traversedEdge.getProperty();
			OCLExpression sourceExp = createVariableExp(sourceNode);
			OCLExpression source2targetExp = createCallExp(sourceExp, property);
			if (targetNode.isAttributeNode()) {
				Variable attributeVariable = node2variable.get(targetNode);
				assert attributeVariable == null;
				createUnrealizedVariable(bottomPattern, targetNode, source2targetExp);
			}
			else {
				Variable classVariable = node2variable.get(targetNode);
				assert classVariable == null;
				createUnrealizedVariable(bottomPattern, targetNode, source2targetExp);
/*				}
				else {
					OCLExpression ownedInit = classVariable.getOwnedInit();
					assert ownedInit == null;
					if (source2targetExp != null) {
						Type variableType = classVariable.getType();
						Type initType = source2targetExp.getType();
						assert variableType != null;
						if (!initType.conformsTo(visitor.getStandardLibrary(), variableType)) {
							source2targetExp = createOclAsTypeCallExp(source2targetExp, variableType);
						}
					}
					classVariable.setOwnedInit(source2targetExp);
				} */
			}
		}
		//
		//	Convert the untraversed edges to predicates.
		//
		for (@NonNull NavigationEdge untraversedEdge : untraversedEdges) {
			Node sourceNode = untraversedEdge.getSource();
			Node targetNode = untraversedEdge.getTarget();
			Property property = untraversedEdge.getProperty();
			OCLExpression sourceExp = createVariableExp(sourceNode);
			OCLExpression targetExp = createVariableExp(targetNode);
			OCLExpression source2targetExp = createCallExp(sourceExp, property);
			OCLExpression matchesExp = targetNode.isNull()
					? createOperationCallExp(source2targetExp, visitor.getEqualsOperation(), targetExp)
					: createOperationCallExp(targetExp, visitor.getEqualsOperation(), source2targetExp);
			Predicate asPredicate = QVTbaseFactory.eINSTANCE.createPredicate();
			asPredicate.setConditionExpression(matchesExp);
			addPredicate(asPredicate);
		}
/*		Set<@NonNull Node> reachableNodes = new HashSet<@NonNull Node>(guardNodes);
		List<@NonNull Node> sourcesList = new ArrayList<@NonNull Node>(guardNodes);
		for (int i = 0; i < sourcesList.size(); i++) {
			@NonNull Node sourceNode = sourcesList.get(i);
			for (@NonNull NavigationEdge edge : sourceNode.getNavigationEdges()) {		// if !edge.getEdgeRole().isRealized() && !targetNode.isNull()
				EdgeRole edgeRole = edge.getEdgeRole();
				if (!edgeRole.isRealized()) {
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
									} * /
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
									if (source2targetExp != null) {
										Type variableType = classVariable.getType();
										Type initType = source2targetExp.getType();
										assert variableType != null;
										if (!initType.conformsTo(visitor.getStandardLibrary(), variableType)) {
											source2targetExp = createOclAsTypeCallExp(source2targetExp, variableType);
										}
									}
									classVariable.setOwnedInit(source2targetExp);
								}
								
		/*							else {
										OCLExpression targetExp = PivotUtil.createVariableExp(attributeVariable);
										OCLExpression matchesExp = createOperationCallExp(targetExp, visitor.getEqualsOperation(), source2targetExp);
										Predicate asPredicate = QVTbaseFactory.eINSTANCE.createPredicate();
										asPredicate.setConditionExpression(matchesExp);
										mapping.getBottomPattern().getPredicate().add(asPredicate);
									} * /
							}
							else {
								sourcesList.add(targetNode);
								Iterable<@NonNull Node> callingSources = targetNode.getPassedBindingSources();		// Used
								if (Iterables.size(callingSources) <= 0) {			// FIXME check predicate in source etc
									OCLExpression sourceExp = createVariableExp(sourceNode);
									OCLExpression targetExp = createVariableExp(targetNode);
									OCLExpression source2targetExp = createCallExp(sourceExp, property);
									OCLExpression matchesExp = createOperationCallExp(targetExp, visitor.getEqualsOperation(), source2targetExp);
									Predicate asPredicate = QVTbaseFactory.eINSTANCE.createPredicate();
									asPredicate.setConditionExpression(matchesExp);
									addPredicate(asPredicate);
								}
							}
						}
					}
				}
			}
		} */
	}

	private void createPollingDependencies() {
		DomainUsage anyUsage = region.getSchedulerConstants().getDomainAnalysis().getAnyUsage();
		for (@NonNull TypedModel qvtpTypedModel : anyUsage.getTypedModels()) {
			TypedModel qvtiTypedModel = visitor.getQVTiTypedModel(qvtpTypedModel);
			ImperativeDomain domain = typedModel2domain.get(qvtiTypedModel);
			ImperativeArea imperativeArea = domain != null ? (ImperativeArea)domain : mapping;
			Iterable<@NonNull NavigationEdge> checkedEdges = region.getCheckedEdges(qvtpTypedModel);
			if (checkedEdges != null) {
				List<Property> checkedProperties = imperativeArea.getCheckedProperties();
				for (NavigationEdge checkedEdge : checkedEdges) {
					checkedProperties.add(checkedEdge.getProperty());
				}
			}
			Iterable<@NonNull NavigationEdge> enforcedEdges = region.getEnforcedEdges(qvtpTypedModel);
			if (enforcedEdges != null) {
				List<@NonNull Property> enforcedProperties = ClassUtil.nullFree(imperativeArea.getEnforcedProperties());
				for (@NonNull NavigationEdge enforcedEdge : enforcedEdges) {
					enforcedProperties.add(enforcedEdge.getProperty());
				}
			}
		}
	}

	private void createPropertyAssignments() {
		Map<@NonNull Node, @NonNull List<@NonNull NavigationEdge>> classAssignments = null;
		for (@NonNull NavigationEdge edge : region.getRealizedNavigationEdges()) {
			Node sourceNode = edge.getSource();
			Node targetNode = edge.getTarget();
			if (targetNode.isAttributeNode()) {
				OCLExpression slotVariableExp = createVariableExp(sourceNode);
				Property property = edge.getProperty();
				OCLExpression valueExp = expressionCreator.getExpression(targetNode);
				if (valueExp == null) {
					valueExp = expressionCreator.getExpression(targetNode);		// FIXME debugging
				}
				if (valueExp != null) {
					PropertyAssignment propertyAssignment = QVTimperativeUtil.createPropertyAssignment(slotVariableExp, property, valueExp);
					mapping.getBottomPattern().getAssignment().add(propertyAssignment);
				}
				else {
					System.err.println("No assignment in " + this + " to " + slotVariableExp);
				}
			}
			else {
				if (classAssignments == null) {
					classAssignments = new HashMap<@NonNull Node, @NonNull List<@NonNull NavigationEdge>>();
				}
				List<@NonNull NavigationEdge> edges = classAssignments.get(sourceNode);
				if (edges == null) {
					edges = new ArrayList<@NonNull NavigationEdge>();
					classAssignments.put(sourceNode, edges);
				}
				edges.add(edge);
			}
		}
		if (classAssignments != null) {
			pruneClassAssignments(classAssignments);
			Collection<@NonNull List<@NonNull NavigationEdge>> values = classAssignments.values();
			createClassPropertyAssignments(values);
		}
		@SuppressWarnings("null") EList<@NonNull Assignment> bottomAssignments = mapping.getBottomPattern().getAssignment();
		ECollections.sort(bottomAssignments, new Comparator<@NonNull Assignment>()
		{
			@Override
			public int compare(@NonNull Assignment o1, @NonNull Assignment o2) {
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
		for (@NonNull Node node : region.getRealizedVariableNodes()) {
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
		Map<@NonNull Region, @NonNull Map<@NonNull Node, @NonNull Node>> calls = null;
//		for (@SuppressWarnings("null")@NonNull Region calledRegion : getEarliestFirstCalledRegions()) {
		for (@NonNull Region calledRegion : region.getCallableChildren()) {
			if (calls == null) {
				calls = new HashMap<@NonNull Region, @NonNull Map<@NonNull Node, @NonNull Node>>();
			}
			Map<@NonNull Node, @NonNull Node> source2target = calls.get(calledRegion);
			if (source2target == null) {
				source2target = new HashMap<@NonNull Node, @NonNull Node>();
				calls.put(calledRegion, source2target);
			}
			AbstractRegion2Mapping calledRegion2Mapping = visitor.getRegion2Mapping(calledRegion);
			for (@NonNull Node calledGuardNode : calledRegion2Mapping.getGuardNodes()) {
				for (@NonNull Node callingNode : calledGuardNode.getPassedBindingSources()) {
					if (callingNode.getRegion() == region) {
						Node oldNode = source2target.put(callingNode, calledGuardNode);
						assert oldNode == null;
					}
				}
				for (@NonNull Node callingNode : calledGuardNode.getUsedBindingSources()) {
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
				for (@NonNull Edge edge : node.getIncomingEdges()) {
					if (edge.isArgument() || edge.isCast()) {
						OCLExpression initExpression = edge.getSource().getTypedElements().iterator().next().accept(expressionCreator);
						BottomPattern bottomPattern = mapping.getBottomPattern();
						assert bottomPattern != null;
						variable = createUnrealizedVariable(bottomPattern, node, initExpression);
						break;
					}
				}
			}
			if (variable == null) {
				for (@NonNull Edge edge : node.getIncomingEdges()) {
					boolean isPredicated = edge.isPredicated();
					boolean isNavigable = edge.isNavigable();
					boolean isNavigation = edge.isNavigation();
					if (isPredicated && !isNavigable && isNavigation) {
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
	public @NonNull List<@NonNull Node> getGuardNodes() {
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

	private @Nullable NavigationEdge getOppositeEdge(@NonNull NavigationEdge edge) {
		Node targetNode = edge.getTarget();
		Property property = edge.getProperty();
		Property oppositeProperty = property.getOpposite();
		if (oppositeProperty == null) {
			return null;
		}
		NavigationEdge oppositeEdge = targetNode.getNavigationEdge(oppositeProperty);
		if (oppositeEdge == null) {
			return null;
		}
		assert oppositeEdge.getTarget() == edge.getSource();
		return oppositeEdge;
	}

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
	private void pruneClassAssignments(@NonNull Map<@NonNull Node, @NonNull List<@NonNull NavigationEdge>> classAssignments) {
		for (@NonNull Node sourceNode : new ArrayList<@NonNull Node>(classAssignments.keySet())) {
			List<@NonNull NavigationEdge> forwardEdges = classAssignments.get(sourceNode);
			assert forwardEdges != null;
			for (int iForward = forwardEdges.size()-1; iForward >= 0; iForward--) {
				NavigationEdge forwardEdge = forwardEdges.get(iForward);
				Node targetNode = forwardEdge.getTarget();
				List<@NonNull NavigationEdge> reverseEdges = classAssignments.get(targetNode);
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