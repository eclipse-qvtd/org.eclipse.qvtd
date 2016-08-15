/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
import org.eclipse.ocl.pivot.LetExp;
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
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.EdgeRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigationEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NodeConnection;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SchedulerConstants;
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
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.AssignmentComparator;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractExtendingQVTimperativeVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

import com.google.common.collect.Iterables;

public class BasicRegion2Mapping extends AbstractRegion2Mapping
{
	private class ExpressionCreator extends AbstractExtendingQVTimperativeVisitor<@NonNull OCLExpression, @NonNull BasicRegion2Mapping>
	{
		protected final @NonNull Set<@NonNull Node> multiAccessedNodes = new HashSet<>();
		protected final @NonNull Set<@NonNull Node> conditionalNodes = new HashSet<>();

		public ExpressionCreator() {
			super(BasicRegion2Mapping.this);
			analyzeExpressions(multiAccessedNodes, conditionalNodes);
		}

		/**
		 * Compute the nodes that are only evaluated if a run-time if-condition is satisfied, and the nodes that are always accessed more than once.
		 */
		private void analyzeExpressions(@NonNull Set<Node> multiAccessedNodes, @NonNull Set<Node> conditionalNodes) {
			Set<@NonNull Node> unconditionalNodes = new HashSet<>();
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
				return helper.createNullLiteralExp();
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
				theVariable = createBottomVariable(node, initExpression);
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
			List<@NonNull OCLExpression> newTypedElements = new ArrayList<>(oldTypedElements.size());
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
			List<@NonNull Variable> newVariables = new ArrayList<>(oldVariables.size());
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
				return helper.createNullLiteralExp();
			}
			Variable variable = node2variable.get(node);
			if (variable != null) {
				return PivotUtil.createVariableExp(variable);
			}
			if (node.isOperation()) {
				Iterable<@NonNull TypedElement> typedElements = node.getTypedElements();
				assert Iterables.size(typedElements) >= 1;
				return typedElements.iterator().next().accept(inlineExpressionCreator);

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
						return PivotUtil.createNavigationCallExp(source, ((NavigationEdge)edge).getProperty());
					}
				}
			}
			for (@NonNull Edge edge : node.getIncomingEdges()) {
				EdgeRole edgeRole = edge.getEdgeRole();
				if (edgeRole.isExpression()) {
					OCLExpression source = create(edge.getSource());
					return source;
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

		//		public boolean isConditional(@NonNull Node node) {
		//			return conditionalNodes.contains(node);
		//		}

		@Override
		public @NonNull OCLExpression visitCollectionLiteralExp(@NonNull CollectionLiteralExp pCollectionLiteralExp) {
			List<@NonNull CollectionLiteralPart> clonedParts = new ArrayList<>();
			for (@NonNull CollectionLiteralPart pPart : ClassUtil.nullFree(pCollectionLiteralExp.getOwnedParts())) {
				if (pPart instanceof CollectionItem) {
					OCLExpression item = createNonNull(((CollectionItem)pPart).getOwnedItem());
					clonedParts.add(helper.createCollectionItem(item));
				}
				else {
					CollectionRange pCollectionRange = (CollectionRange)pPart;
					OCLExpression first = createNonNull(pCollectionRange.getOwnedFirst());
					OCLExpression last = createNonNull(pCollectionRange.getOwnedLast());
					clonedParts.add(helper.createCollectionRange(first, last));
				}
			}
			CollectionType collectionType = (CollectionType)pCollectionLiteralExp.getType();
			assert collectionType != null;
			return helper.createCollectionLiteralExp(collectionType, clonedParts);
		}

		@Override
		public @NonNull OCLExpression visitIfExp(@NonNull IfExp pIfExp) {
			PivotMetamodelManager metamodelManager = visitor.getMetamodelManager();
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
			return helper.createIterateExp(iSource, referredIteration, iIterators, result, iBody);
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
			return helper.createIteratorExp(iSource, referredIteration, iIterators, iBody);
		}

		@Override
		public @NonNull OCLExpression visitLetExp(@NonNull LetExp pLetExp) {
			Variable asVariable = createVariable(ClassUtil.nonNull(pLetExp.getOwnedVariable()));
			OCLExpression asInExpression = create(pLetExp.getOwnedIn());
			assert asInExpression != null;
			return helper.createLetExp(asVariable, asInExpression);
		}

		@Override
		public @NonNull OCLExpression visitMapLiteralExp(@NonNull MapLiteralExp pMapLiteralExp) {
			List<@NonNull MapLiteralPart> clonedParts = new ArrayList<>();
			for (@NonNull MapLiteralPart pPart : ClassUtil.nullFree(pMapLiteralExp.getOwnedParts())) {
				OCLExpression key = createNonNull(pPart.getOwnedKey());
				OCLExpression value = createNonNull(pPart.getOwnedValue());
				clonedParts.add(helper.createMapLiteralPart(key, value));
			}
			MapType mapType = (MapType)pMapLiteralExp.getType();
			assert mapType != null;
			return helper.createMapLiteralExp(mapType, clonedParts);
		}

		@Override
		public @NonNull OCLExpression visitOperationCallExp(@NonNull OperationCallExp pOperationCallExp) {
			OCLExpression iSource = create(pOperationCallExp.getOwnedSource());
			List<@NonNull OCLExpression> iArguments = createAll(ClassUtil.nullFree(pOperationCallExp.getOwnedArguments()));
			Operation referredOperation = visitor.create(pOperationCallExp.getReferredOperation());
			assert referredOperation != null;
			if ((iSource == null) && (referredOperation instanceof Function)) {
				SchedulerConstants scheduler = getRegion().getMultiRegion().getSchedulerConstants();
				StandardLibrary standardLibrary = scheduler.getStandardLibrary();
				Variable thisVariable = QVTbaseUtil.getContextVariable(standardLibrary, visitor.getTransformation());
				iSource = PivotUtil.createVariableExp(thisVariable);
			}
			return helper.createOperationCallExp(iSource, referredOperation, iArguments);
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
			return helper.createNavigationCallExp(iSource, referredProperty);
		}

		@Override
		public @NonNull OCLExpression visitShadowExp(@NonNull ShadowExp pShadowExp) {
			List<@NonNull ShadowPart> clonedParts = new ArrayList<>();
			for (@NonNull ShadowPart pPart : ClassUtil.nullFree(pShadowExp.getOwnedParts())) {
				OCLExpression init = createNonNull(pPart.getOwnedInit());
				String name = pPart.getName();
				Type type = pPart.getType();
				assert (name != null) && (type != null);
				Property referredProperty = pPart.getReferredProperty();
				assert referredProperty != null;
				clonedParts.add(helper.createShadowPart(referredProperty, init));
			}
			org.eclipse.ocl.pivot.Class shadowType = pShadowExp.getType();
			assert shadowType != null;
			return helper.createShadowExp(shadowType, clonedParts);
		}

		@Override
		public @NonNull OCLExpression visitTupleLiteralExp(@NonNull TupleLiteralExp pTupleLiteralExp) {
			List<@NonNull TupleLiteralPart> clonedParts = new ArrayList<>();
			for (@NonNull TupleLiteralPart pPart : ClassUtil.nullFree(pTupleLiteralExp.getOwnedParts())) {
				OCLExpression init = createNonNull(pPart.getOwnedInit());
				String name = pPart.getName();
				Type type = pPart.getType();
				assert (name != null) && (type != null);
				clonedParts.add(helper.createTupleLiteralPart(name, type, pPart.isIsRequired(), init));
			}
			TupleType tupleType = (TupleType)pTupleLiteralExp.getType();
			assert tupleType != null;
			return helper.createTupleLiteralExp(tupleType, clonedParts);
		}

		@Override
		public @NonNull OCLExpression visitTypeExp(@NonNull TypeExp pTypeExp) {
			Type referredType = pTypeExp.getReferredType();
			assert referredType != null;
			return helper.createTypeExp(referredType);
		}

		//		@Override		-- should not be invoked; results in use of input not output variable
		//		public @NonNull OCLExpression visitVariable(@NonNull Variable pVariable) {
		//			return helper.createVariableExp(pVariable);
		//		}

		@Override
		public @NonNull OCLExpression visitVariableExp(@NonNull VariableExp pVariableExp) {
			VariableDeclaration pVariable = pVariableExp.getReferredVariable();
			Node node = getNode(pVariable);
			if (node == null) {
				SchedulerConstants scheduler = getRegion().getMultiRegion().getSchedulerConstants();
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
			if (node != null) {
				Variable iVariable = getVariable(node);
				assert iVariable != null;
				return PivotUtil.createVariableExp(iVariable);
			}
			else {
				System.err.println("Creating unexpected variable for " + pVariable + " in " + region);
				BottomPattern bottomPattern = mapping.getBottomPattern();
				assert bottomPattern != null;
				Type variableType = pVariable.getType();
				assert variableType != null;
				String safeName = getSafeName(ClassUtil.nonNullState(pVariable.getName()));
				Variable iVariable = PivotUtil.createVariable(safeName, variableType, pVariable.isIsRequired(), null);
				bottomPattern.getVariable().add(iVariable);
				//				Variable oldVariable = node2variable.put(node, iVariable);
				//				assert oldVariable == null;
				return PivotUtil.createVariableExp(iVariable);
			}
		}
	}

	private class InlineExpressionCreator extends ExpressionCreator
	{
		@Override
		public @NonNull OCLExpression create(/*@NonNull*/ Node node) {
			if (node.isNull()) {
				return helper.createNullLiteralExp();
			}
			Variable theVariable = node2variable.get(node);
			if (theVariable == null) {
				TypedElement oldTypedElement = node.getTypedElements().iterator().next();
				assert oldTypedElement != null;
				if ((oldTypedElement instanceof Variable) && (((Variable)oldTypedElement).getOwnedInit() == null)) {
					//					for (@NonNull Edge edge : node.getIncomingEdges()) {
					//						if (edge.isArgument() || edge.isCast()) {
					theVariable = createBottomVariable(node, null);
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
	private final @NonNull List<@NonNull Node> headNodes = new ArrayList<>();

	/**
	 * The subset of possible guard nodes that all callers can pass.
	 */
	private final @NonNull List<@NonNull Node> guardNodes = new ArrayList<>();

	/**
	 * Mapping from the scheduled Nodes to their QVTi variables.
	 */
	private final @NonNull Map<@NonNull Node, @NonNull Variable> node2variable = new HashMap<>();

	/**
	 * Mapping from the TypedModel to its ImperativeDomain.
	 */
	private final @NonNull Map<@NonNull TypedModel, @NonNull ImperativeDomain> typedModel2domain = new HashMap<>();

	private final @NonNull ExpressionCreator expressionCreator;
	private final @NonNull ExpressionCreator inlineExpressionCreator;

	public BasicRegion2Mapping(@NonNull QVTs2QVTiVisitor visitor, @NonNull Region region) {
		super(visitor, region);
		this.expressionCreator = new ExpressionCreator();
		this.inlineExpressionCreator = new InlineExpressionCreator();
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

	private @NonNull Variable createBottomVariable(@NonNull Node node, @Nullable OCLExpression initExpression) {
		Area area = getArea(node.getClassDatumAnalysis());
		Type variableType = node.getCompleteClass().getPrimaryClass();
		assert variableType != null;
		boolean isRequired = true;
		for (@NonNull TypedElement typedElement : node.getTypedElements()) {
			if (!typedElement.isIsRequired()) {
				isRequired = false;
			}
		}
		if ((initExpression != null) && initExpression.isIsRequired()) {
			isRequired = true;
		}
		Variable variable = PivotUtil.createVariable(getSafeName(node), variableType, isRequired, null);


		BottomPattern bottomPattern = area.getBottomPattern();
		bottomPattern.getVariable().add(variable);
		if (initExpression != null) {
			VariableAssignment variableAssignment = helper.createVariableAssignment(variable, initExpression);
			mapping.getBottomPattern().getAssignment().add(variableAssignment);
		}
		Variable oldVariable = node2variable.put(node, variable);
		assert oldVariable == null;
		return variable;
	}

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
		Set<@NonNull TypedModel> checkableTypedModels = new HashSet<>();
		Set<@NonNull TypedModel> enforceableTypedModels = new HashSet<>();
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
				else if (domainUsage.isMiddle()) {
					TypedModel qvtiTypedModel = visitor.getQVTiTypedModel(null);
					assert qvtiTypedModel != null;
					enforceableTypedModels.add(qvtiTypedModel);
				}
				else if (domainUsage.isOutput()) {		// EObject is $primitive$
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
		EList<@NonNull Domain> domains = ClassUtil.nullFree(mapping.getDomain());
		ECollections.sort(domains, QVTbaseUtil.DomainNameComparator.INSTANCE);
	}

	/**
	 * Create a predicate expression for each TRUE 'head'.
	 */
	private void createExternalPredicates() {
		/*		for (@NonNull Node node : region.getNodes()) {
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
		} */
		for (@NonNull Edge edge : region.getEdges()) {
			if (edge.isPredicate()) {
				Node sourceNode = edge.getSource();
				Node targetNode = edge.getTarget();
				OCLExpression conditionExpression = inlineExpressionCreator.getExpression(sourceNode);
				assert conditionExpression != null;
				if (!targetNode.isTrue()) {
					String name = ClassUtil.nonNullState(edge.getName()).trim();
					if (name.length() >= 2) {
						name = name.substring(1, name.length()-1);		// Lose guillemets
					}
					OCLExpression targetExpression = inlineExpressionCreator.getExpression(targetNode);
					assert targetExpression != null;
					conditionExpression = helper.createOperationCallExp(conditionExpression, name, targetExpression);
				}
				Predicate asPredicate = QVTbaseFactory.eINSTANCE.createPredicate();
				asPredicate.setConditionExpression(conditionExpression);
				addPredicate(asPredicate);
			}
		}
	}

	private @NonNull Variable createGuardVariable(@NonNull Node guardNode) {
		Area area = getArea(guardNode.getClassDatumAnalysis());
		GuardPattern guardPattern = area.getGuardPattern();
		assert guardPattern != null;
		Type variableType = guardNode.getCompleteClass().getPrimaryClass();
		Variable guardVariable = PivotUtil.createVariable(getSafeName(guardNode), variableType, true, null);
		guardPattern.getVariable().add(guardVariable);
		Variable oldVariable = node2variable.put(guardNode, guardVariable);
		assert oldVariable == null;
		return guardVariable;
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
			if (bestHeadNode != null) {
				headNodes.add(bestHeadNode);
			}
			else if (!isExtraGuard) {
				System.err.println("No best head for " + region);
			}
		}
		guardNodes.addAll(headNodes);
		for (@NonNull Node guardNode : region.getOldNodes()) {
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
			createGuardVariable(guardNode);
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
			List<@NonNull MappingCallBinding> mappingCallBindings = new ArrayList<>();
			for (Map.Entry<@NonNull Node, @NonNull Node> entry2 : entry.getValue().entrySet()) {
				@NonNull Node sourceNode = entry2.getKey();
				@NonNull Node targetNode = entry2.getValue();
				OCLExpression sourceExpression = getSourceExpression(sourceNode);
				Type type = sourceExpression.getType();
				if (type instanceof CollectionType) {
					if (loopVariables == null) {
						loopVariables = new HashMap<>();
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
	 * Recurse over the guard nodes and loaded/predicates region and convert the non-guard nodes to unrealized variables
	 * and edges to predicates or initializations
	 */
	private void createNavigablePredicates() {
		@SuppressWarnings("unused")String name = region.getName();
		//
		//	Create the navigation forest for the guardNodes roots and navigation edges.
		//
		NavigationForestBuilder navigationForest = new NavigationForestBuilder(guardNodes, region.getNavigationEdges());
		//
		//	Convert the ordered forest edges to unrealized variables and initializers.
		//
		for (@NonNull NavigationEdge traversedEdge : navigationForest.getForestNavigations()) {
			Node sourceNode = traversedEdge.getSource();
			Node targetNode = traversedEdge.getTarget();
			Property property = traversedEdge.getProperty();
			OCLExpression sourceExp = createVariableExp(sourceNode);
			OCLExpression source2targetExp = createCallExp(sourceExp, property);
			Variable nodeVariable = node2variable.get(targetNode);
			assert nodeVariable == null;
			//			if (nodeVariable == null) {
			createBottomVariable(targetNode, source2targetExp);
			//			}
		}
		//
		//	Convert the ordered non-forest edges to predicates.
		//
		for (@NonNull NavigationEdge untraversedEdge : navigationForest.getGraphPredicates()) {
			Node sourceNode = untraversedEdge.getSource();
			Node targetNode = untraversedEdge.getTarget();
			Property property = untraversedEdge.getProperty();
			OCLExpression sourceExp = createVariableExp(sourceNode);
			OCLExpression targetExp = createVariableExp(targetNode);
			OCLExpression source2targetExp = createCallExp(sourceExp, property);
			OCLExpression matchesExp = targetNode.isNull()
					? helper.createOperationCallExp(source2targetExp, "=", targetExp)
						: helper.createOperationCallExp(targetExp, "=", source2targetExp);
					Predicate asPredicate = QVTbaseFactory.eINSTANCE.createPredicate();
					asPredicate.setConditionExpression(matchesExp);
					addPredicate(asPredicate);
		}
		/*		Set<@NonNull Node> reachableNodes = new HashSet<>(guardNodes);
		List<@NonNull Node> sourcesList = new ArrayList<>(guardNodes);
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
		ImperativeBottomPattern bottomPattern = (ImperativeBottomPattern) mapping.getBottomPattern();
		for (@NonNull NavigationEdge edge : NavigationEdgeSorter.getSortedAssignments(region.getRealizedNavigationEdges())) {
			Node sourceNode = edge.getSource();
			Node targetNode = edge.getTarget();
			if (targetNode.isDataType()) {
				OCLExpression slotVariableExp = createVariableExp(sourceNode);
				Property property = edge.getProperty();
				OCLExpression valueExp = expressionCreator.getExpression(targetNode);
				if (valueExp == null) {
					valueExp = expressionCreator.getExpression(targetNode);		// FIXME debugging
				}
				if (valueExp != null) {
					PropertyAssignment propertyAssignment = QVTimperativeUtil.createPropertyAssignment(slotVariableExp, property, valueExp);
					bottomPattern.getAssignment().add(propertyAssignment);
				}
				else {
					System.err.println("No assignment in " + this + " to " + slotVariableExp + "." + property);
				}
			}
			else {
				if (classAssignments == null) {
					classAssignments = new HashMap<>();
				}
				List<@NonNull NavigationEdge> edges = classAssignments.get(sourceNode);
				if (edges == null) {
					edges = new ArrayList<>();
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
		@SuppressWarnings("null")
		@NonNull EList<@NonNull Assignment> bottomAssignments = bottomPattern.getOrderedAssignment();
		ECollections.sort(bottomAssignments, new AssignmentComparator(bottomAssignments));
	}

	private void createRealizedVariables() {
		for (@NonNull Node newNode : region.getNewNodes()) {
			if (newNode.isPattern() && newNode.isClass()) {
				OCLExpression constructor = null;
				for (Edge edge : newNode.getIncomingEdges()) {
					if (edge.isExpression()) {
						Node sourceNode = edge.getSource();
						if (sourceNode.isOperation()) {
							constructor = ((OperationCallExp)sourceNode.getTypedElements().iterator().next()).accept(expressionCreator);
						}
					}
				}
				ClassDatumAnalysis classDatumAnalysis = newNode.getClassDatumAnalysis();
				BottomPattern bottomPattern = getArea(classDatumAnalysis).getBottomPattern();
				RealizedVariable realizedVariable = QVTimperativeUtil.createRealizedVariable(getSafeName(newNode), classDatumAnalysis.getCompleteClass().getPrimaryClass());
				realizedVariable.setOwnedInit(constructor);
				bottomPattern.getRealizedVariable().add(realizedVariable);
				Variable oldVariable = node2variable.put(newNode, realizedVariable);
				assert oldVariable == null;
			}
		}
	}

	@Override
	public void createStatements() {
		Map<@NonNull Region, @NonNull Map<@NonNull Node, @NonNull Node>> calls = null;
		//		for (@SuppressWarnings("null")@NonNull Region calledRegion : getEarliestFirstCalledRegions()) {
		for (@NonNull Region calledRegion : region.getCallableChildren()) {
			if (calls == null) {
				calls = new HashMap<>();
			}
			Map<@NonNull Node, @NonNull Node> source2target = calls.get(calledRegion);
			if (source2target == null) {
				source2target = new HashMap<>();
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

	private @NonNull OCLExpression createVariableExp(@NonNull Node node) {
		if (node.isNull()) {
			return helper.createNullLiteralExp();
		}
		else {
			Variable variable = node2variable.get(node);
			if (variable == null) {
				//				for (@NonNull Edge edge : node.getIncomingEdges()) {
				//					if (edge.isExpression() || edge.isCast()) {
				//				OCLExpression initExpression = edge.getSource().getTypedElements().iterator().next().accept(expressionCreator);
				OCLExpression initExpression = node.getTypedElements().iterator().next().accept(expressionCreator);
				variable = createBottomVariable(node, initExpression);
				//						break;
				//					}
				//				}
			}
			if (variable == null) {
				for (@NonNull Edge edge : node.getIncomingEdges()) {
					boolean isPredicated = edge.isPredicated();
					boolean isNavigable = edge.isNavigable();
					boolean isNavigation = edge.isNavigation();
					if (isPredicated && !isNavigable && isNavigation) {
						OCLExpression initExpression = edge.getSource().getTypedElements().iterator().next().accept(expressionCreator);
						variable = createBottomVariable(node, initExpression);
						break;
					}
				}
			}
			if (variable == null) {
				System.err.println("Creating dummy variable for " + node + " in " + region);
				BottomPattern bottomPattern = mapping.getBottomPattern();
				assert bottomPattern != null;
				Type variableType = node.getCompleteClass().getPrimaryClass();
				assert variableType != null;
				variable = PivotUtil.createVariable(getSafeName(node), variableType, false, null);
				bottomPattern.getVariable().add(variable);
				Variable oldVariable = node2variable.put(node, variable);
				assert oldVariable == null;
			}
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

	private @NonNull Area getArea(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		TypedModel qvtpTypedModel = classDatumAnalysis.getTypedModel();
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
		for (@NonNull Node sourceNode : new ArrayList<>(classAssignments.keySet())) {
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