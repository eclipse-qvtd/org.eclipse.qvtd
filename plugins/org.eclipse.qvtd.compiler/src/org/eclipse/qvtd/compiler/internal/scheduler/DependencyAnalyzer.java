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
package org.eclipse.qvtd.compiler.internal.scheduler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.LiteralExp;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.manager.FinalAnalysis;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractExtendingQVTimperativeVisitor;

public class DependencyAnalyzer
{
//	private static final @SuppressWarnings("null")@NonNull Set<List<DependencyStep>> EMPTY_ELEMENTS = Collections.emptySet();
		
	@SuppressWarnings("serial")
	protected static class BlockedAnalysisException extends RuntimeException
	{
		private @NonNull Collection<@NonNull OperationAnalysis> failedAnalyses;

		public BlockedAnalysisException(@NonNull Collection<@NonNull OperationAnalysis> failedAnalyses) {
			this.failedAnalyses = /*new ArrayList<OperationAnalysis>(*/failedAnalyses;//);
		}

		public @NonNull Collection<@NonNull OperationAnalysis> getFailedAnalyses() {
			return failedAnalyses;
		}
	}

	protected static class DependencyStepFactory
	{
		protected final @NonNull DomainUsage usage;
		private final @NonNull Map<org.eclipse.ocl.pivot.Class, ClassDependencyStep> class2step = new HashMap<org.eclipse.ocl.pivot.Class, ClassDependencyStep>();
		private final @NonNull Map<Property, NavigationDependencyStep> property2step = new HashMap<Property, NavigationDependencyStep>();

		protected DependencyStepFactory(@NonNull DomainUsage usage) {
			this.usage = usage;
		}
		
		public @NonNull ClassDependencyStep createClassDependencyStep(org.eclipse.ocl.pivot.@NonNull Class type, @NonNull Element element) {
			ClassDependencyStep dependencyStep = class2step.get(type);
			if (dependencyStep == null) {
				dependencyStep = new ClassDependencyStep(usage, type, element);
				class2step.put(type, dependencyStep);
			}
			return dependencyStep;
		}
		
		public @NonNull NavigationDependencyStep createPropertyDependencyStep(@NonNull NavigationCallExp navigationCallExp) {
			Property property = PivotUtil.getReferredProperty(navigationCallExp);
			assert property != null;
			NavigationDependencyStep dependencyStep = property2step.get(property);
			if (dependencyStep == null) {
				dependencyStep = new NavigationDependencyStep(usage, property, navigationCallExp);
				property2step.put(property, dependencyStep);
			}
			return dependencyStep;
		}

		public @NonNull DomainUsage getUsage() {
			return usage;
		}
	}
	
	protected abstract static class DependencyStep
	{
		protected final @NonNull DomainUsage usage;
		protected final @NonNull Element element;

		protected DependencyStep(@NonNull DomainUsage usage, @NonNull Element element) {
			this.usage = usage;
			this.element = element;
		}

		public @NonNull Element getElement() {
			return element;
		}

		public abstract org.eclipse.ocl.pivot.@NonNull Class getElementalType();

		public abstract String getName();

		public @NonNull DomainUsage getUsage() {
			return usage;
		}
	}
	
	protected static class ClassDependencyStep extends DependencyStep
	{
		private final org.eclipse.ocl.pivot.@NonNull Class type;
		
		public ClassDependencyStep(@NonNull DomainUsage usage, org.eclipse.ocl.pivot.@NonNull Class type, @NonNull Element element) {
			super(usage, element);
			this.type = type;
			assert !(type instanceof CollectionType);
		}

		@Override
		public org.eclipse.ocl.pivot.@NonNull Class getElementalType() {
			return type;
		}

		@Override
		public String getName() {
			return type.getName();
		}

		@Override
		public String toString() {
			return usage + " «" + type.eClass().getName() + "»" + type.toString();
		}
	}
	
	protected static class NavigationDependencyStep extends DependencyStep
	{
		protected final @NonNull Property property;
		
		public NavigationDependencyStep(@NonNull DomainUsage usage, @NonNull Property property, @NonNull NavigationCallExp element) {
			super(usage, element);
			this.property = property;
		}

		@Override
		public org.eclipse.ocl.pivot.@NonNull Class getElementalType() {
			Type type = property.getType();
			assert type != null;
			while (type instanceof CollectionType) {
				type = ((CollectionType)type).getElementType();
				assert type != null;
			}
			return (org.eclipse.ocl.pivot.Class) type;
		}

		@Override
		public String getName() {
			return property.getName();
		}

		public @NonNull NavigationCallExp getNavigationCallExp() {
			return (NavigationCallExp) element;
		}

		public @NonNull Property getProperty() {
			return property;
		}

//		@Override
//		public org.eclipse.ocl.pivot.@NonNull Class getType() {
//			Type type = property.getType();
//			assert type != null;
//			return (org.eclipse.ocl.pivot.Class) type;
//		}

		@Override
		public String toString() {
			return usage + " «" + property.eClass().getName() + "»" + property.toString();
		}
	}
	
	protected static class UnknownDependencyStep extends DependencyStep
	{
		private final org.eclipse.ocl.pivot.@NonNull Class type;
		
		public UnknownDependencyStep(@NonNull DomainUsage usage, org.eclipse.ocl.pivot.@NonNull Class type, @NonNull Element element) {
			super(usage, element);
			this.type = type;
			assert !(type instanceof CollectionType);
		}

		@Override
		public org.eclipse.ocl.pivot.@NonNull Class getElementalType() {
			return type;
		}

		@Override
		public String getName() {
			return "???";
		}

		@Override
		public String toString() {
			return usage + " ??«" + type.eClass().getName() + "»" + type.toString();
		}
	}
		
	protected static class DependencyPaths
	{
		protected final @NonNull DependencyAnalyzer dependencyAnalyzer;
		private final @Nullable Set<List<DependencyStep>> returnPaths;
		private final @Nullable Set<List<DependencyStep>> hiddenPaths;

		protected DependencyPaths(@NonNull DependencyAnalyzer dependencyAnalyzer, @Nullable Set<List<DependencyStep>> returnPaths, @Nullable Set<List<DependencyStep>> hiddenPaths) {
			this.dependencyAnalyzer = dependencyAnalyzer;
			this.returnPaths = returnPaths;
			this.hiddenPaths = hiddenPaths;
		}

		public @NonNull DependencyPaths addHidden(@NonNull DependencyPaths secondPath) {
			Set<List<DependencyStep>> newHiddenPaths = hiddenPaths;
			Set<List<DependencyStep>> secondPathHiddenPaths = secondPath.hiddenPaths;
			if (secondPathHiddenPaths != null) {
				if (newHiddenPaths != null) {
					newHiddenPaths = new HashSet<List<DependencyStep>>(newHiddenPaths);
					newHiddenPaths.addAll(secondPathHiddenPaths);
				}
				else {
					newHiddenPaths = secondPathHiddenPaths;
				}
			}
			@Nullable
			Set<List<DependencyStep>> secondPathReturnPaths = secondPath.returnPaths;
			if (secondPathReturnPaths != null) {
				if (newHiddenPaths != null) {
					newHiddenPaths = new HashSet<List<DependencyStep>>(newHiddenPaths);
					newHiddenPaths.addAll(secondPathReturnPaths);
				}
				else {
					newHiddenPaths = secondPathReturnPaths;
				}
			}
			return dependencyAnalyzer.createDependencyPaths(returnPaths, newHiddenPaths);
		}

		public @NonNull DependencyPaths addReturn(@NonNull DependencyPaths secondPath) {
			Set<List<DependencyStep>> newReturnPaths;
			@Nullable
			Set<List<DependencyStep>> secondPathReturnPaths = secondPath.returnPaths;
			if (secondPathReturnPaths != null) {
				if (returnPaths != null) {
					newReturnPaths = new HashSet<List<DependencyStep>>(returnPaths);
					newReturnPaths.addAll(secondPathReturnPaths);
				}
				else {
					newReturnPaths = secondPathReturnPaths;
				}
			}
			else {
				newReturnPaths = returnPaths;
			}
			Set<List<DependencyStep>> newHiddenPaths;
			Set<List<DependencyStep>> secondPathHiddenPaths = secondPath.hiddenPaths;
			if (secondPathHiddenPaths != null) {
				if (hiddenPaths != null) {
					newHiddenPaths = new HashSet<List<DependencyStep>>(hiddenPaths);
					newHiddenPaths.addAll(secondPathHiddenPaths);
				}
				else {
					newHiddenPaths = secondPathHiddenPaths;
				}
			}
			else {
				newHiddenPaths = hiddenPaths;
			}
			return dependencyAnalyzer.createDependencyPaths(newReturnPaths, newHiddenPaths);
		}
		
		public @NonNull DependencyPaths append(@NonNull NavigationDependencyStep propertyDependencyStep) {
			Set<List<DependencyStep>> oldReturnPaths = returnPaths;
			if (oldReturnPaths == null) {
				return this;				// navigating from null
			}
			if (isRedundant(oldReturnPaths, propertyDependencyStep.getProperty())) {
				return this;
			}
			Set<List<DependencyStep>> newReturnPaths = new HashSet<List<DependencyStep>>();
			for (List<DependencyStep> oldReturnPath : oldReturnPaths) {
				List<DependencyStep> newReturnPath = null;
				int size = oldReturnPath.size();
				assert size > 0;
				if ((size > 0) && (oldReturnPath.get(size-1) == propertyDependencyStep)) {
					newReturnPath = oldReturnPath;
				}
				else {
					org.eclipse.ocl.pivot.Class endClass = oldReturnPath.get(size-1).getElementalType();
					org.eclipse.ocl.pivot.Class sourceClass = propertyDependencyStep.getProperty().getOwningClass();
					assert sourceClass != null;
					if (!endClass.conformsTo(dependencyAnalyzer.getStandardLibrary(), sourceClass)) {
						newReturnPath = oldReturnPath;
					}
					else {
						newReturnPath = new ArrayList<DependencyStep>(oldReturnPath);
						newReturnPath.add(propertyDependencyStep);
					}
				}
				newReturnPaths.add(newReturnPath);
			}
			return dependencyAnalyzer.createDependencyPaths(newReturnPaths, hiddenPaths);
		}

		public @NonNull Iterable<List<DependencyStep>> getHiddenPaths() {
			Map<String, List<DependencyStep>> map = new HashMap<String, List<DependencyStep>>();
			if (hiddenPaths != null) {
				for (List<DependencyStep> list : hiddenPaths) {
					map.put(list.toString(), list);
				}
			}
			List<String> sortedKeys = new ArrayList<String>(map.keySet());
			Collections.sort(sortedKeys);
			List<List<DependencyStep>> sortedList = new ArrayList<List<DependencyStep>>();
			for (String key : sortedKeys) {
				sortedList.add(map.get(key));
			}
			return sortedList;
		}

		public @NonNull Iterable<List<DependencyStep>> getReturnPaths() {
			Map<String, List<DependencyStep>> map = new HashMap<String, List<DependencyStep>>();
			if (returnPaths != null) {
				for (List<DependencyStep> list : returnPaths) {
					map.put(list.toString(), list);
				}
			}
			List<String> sortedKeys = new ArrayList<String>(map.keySet());
			Collections.sort(sortedKeys);
			List<List<DependencyStep>> sortedList = new ArrayList<List<DependencyStep>>();
			for (String key : sortedKeys) {
				sortedList.add(map.get(key));
			}
			return sortedList;
		}

		protected boolean isRedundant(@NonNull Set<List<DependencyStep>> paths, @NonNull Property property) {
			for (List<DependencyStep> path : paths) {
				int size = path.size();
				if (size <= 0) {
					return false;
				}
				DependencyStep dependencyStep = path.get(size-1);
				if (!(dependencyStep instanceof NavigationDependencyStep)) {
					return false;
				}
				if (((NavigationDependencyStep)dependencyStep).getProperty() != property) {
					return false;
				}
			}
			return true;
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append("{");
			Iterable<List<DependencyStep>> returnPaths2 = getReturnPaths();
			boolean iFirst = true;
			for (List<DependencyStep> path : returnPaths2) {
				if (!iFirst) {
					s.append(", ");
				}
				boolean jFirst = true;
				for (DependencyStep step : path) {
					if (!jFirst) {
						s.append("::");
					}
					s.append(step.getName());
					jFirst = false;
				}
				iFirst = false;
			}
			s.append(" | ");
			Iterable<List<DependencyStep>> hiddenPaths2 = getHiddenPaths();
			iFirst = true;
			for (List<DependencyStep> path : hiddenPaths2) {
				if (!iFirst) {
					s.append(", ");
				}
				boolean jFirst = true;
				for (DependencyStep step : path) {
					if (!jFirst) {
						s.append("::");
					}
					s.append(step.getName());
					jFirst = false;
				}
				iFirst = false;
			}
			s.append("}");
			return s.toString();
		}
	}

	protected class DependencyAnalyzerVisitor extends AbstractExtendingQVTimperativeVisitor<DependencyPaths, Object>
	{
		private final @Nullable DependencyAnalyzerVisitor parent;
		private final @NonNull Map<VariableDeclaration, DependencyPaths> variable2dependencies = new HashMap<VariableDeclaration, DependencyPaths>();		
		
		protected DependencyAnalyzerVisitor(@Nullable DependencyAnalyzerVisitor parent) {
			super(DependencyAnalyzer.class);
			this.parent = parent;
		}

		private void addVariable(@NonNull VariableDeclaration variable, @NonNull DependencyPaths value) {
			variable2dependencies.put(variable, value);
		}
		
		public @NonNull DependencyPaths analyze(/*@NonNull*/ Visitable element) {
			DependencyPaths accept = element.accept(this);
			assert accept != null;
			return accept;
		}
		
		protected @NonNull DependencyPaths getVariable(@NonNull VariableDeclaration variable) {
			DependencyPaths result = variable2dependencies.get(variable);
			if (result != null) {
				return result;
			}
			else if (parent != null) {
				return parent.getVariable(variable);
			}
			else {
				org.eclipse.ocl.pivot.Class type = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)variable.getType());
				return createDependencyPaths(createClassDependencyStep(type, variable));
			}
		}

		@Override
		public @NonNull DependencyPaths visiting(@NonNull Visitable visitable) {
			throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
		}

		@Override
		public @NonNull DependencyPaths visitCollectionLiteralExp(@NonNull CollectionLiteralExp collectionLiteralExp) {
			DependencyPaths result = emptyDependencyPaths;
			for (CollectionLiteralPart ownedPart : collectionLiteralExp.getOwnedParts()) {
				result = result.addReturn(analyze(ownedPart));
			}
			return result;
		}

		@Override
		public @NonNull DependencyPaths visitCollectionItem(@NonNull CollectionItem collectionItem) {
			return analyze(collectionItem.getOwnedItem());
		}

		@Override
		public @NonNull DependencyPaths visitCollectionRange(@NonNull CollectionRange collectionRange) {
			return emptyDependencyPaths;
		}

		@Override
		public @NonNull DependencyPaths visitIfExp(@NonNull IfExp ifExp) {
			DependencyPaths result = analyze(ifExp.getOwnedThen());
			result = result.addReturn(analyze(ifExp.getOwnedElse()));
			result = result.addHidden(analyze(ifExp.getOwnedCondition()));
			return result;
		}

		@Override
		public @NonNull DependencyPaths visitLetExp(@NonNull LetExp letExp) {		
			Variable ownedVariable = letExp.getOwnedVariable();
			DependencyPaths result = analyze(ownedVariable.getOwnedInit());
			DependencyAnalyzerVisitor nestedAnalyzer = new DependencyAnalyzerVisitor(this);
			nestedAnalyzer.addVariable(ownedVariable, result);
			return nestedAnalyzer.analyze(letExp.getOwnedIn());
		}

		@Override
		public @NonNull DependencyPaths visitLiteralExp(@NonNull LiteralExp literalExp) {
			return emptyDependencyPaths;
		}

		@Override
		public @NonNull DependencyPaths visitLoopExp(@NonNull LoopExp loopExp) {
			DependencyPaths result = analyze(loopExp.getOwnedSource());
			DependencyAnalyzerVisitor nestedAnalyzer = new DependencyAnalyzerVisitor(this);
			for (@SuppressWarnings("null")@NonNull Variable iterator : loopExp.getOwnedIterators()) {
				nestedAnalyzer.addVariable(iterator, result);
			}
			return nestedAnalyzer.analyze(loopExp.getOwnedBody());
		}

		@Override
		public @NonNull DependencyPaths visitMapLiteralExp(@NonNull MapLiteralExp mapLiteralExp) {
			DependencyPaths result = emptyDependencyPaths;
			for (MapLiteralPart ownedPart : mapLiteralExp.getOwnedParts()) {
				result = result.addReturn(analyze(ownedPart));
			}
			return result;
		}

		@Override
		public @NonNull DependencyPaths visitMapLiteralPart(@NonNull MapLiteralPart mapLiteralPart) {
			return analyze(mapLiteralPart.getOwnedValue());
		}

		@Override
		public @NonNull DependencyPaths visitNavigationCallExp(@NonNull NavigationCallExp navigationCallExp) {
			DependencyPaths sourcePaths = analyze(navigationCallExp.getOwnedSource());
			NavigationDependencyStep dependencyStep = createPropertyDependencyStep(navigationCallExp);
			return sourcePaths.append(dependencyStep);
		}

		@Override
		public @NonNull DependencyPaths visitOperationCallExp(@NonNull OperationCallExp operationCallExp) {
			List<DependencyPaths> argumentPaths = new ArrayList<DependencyPaths>();
			argumentPaths.add(analyze(operationCallExp.getOwnedSource()));
			for (OCLExpression argument : operationCallExp.getOwnedArguments()) {
				argumentPaths.add(analyze(argument));
			}
			Operation referredOperation = operationCallExp.getReferredOperation();
			if (referredOperation.getBodyExpression() != null) {
				return executeOperationCall(operationCallExp, argumentPaths);
			}
			OperationId operationId = referredOperation.getOperationId();
//			if (operationId == scheduler.getOclAnyOclAsTypeId()) {
//				return analyzeOperationCallExp_oclAsType(sourceNode, operationCallExp);
//			}
			if (PivotUtil.isSameOperation(operationId, scheduler.getOclElementOclContainerId())) {
				return executeOperationCallExp_oclContainer(operationCallExp, argumentPaths);
			}
//			else if (PivotUtil.isSameOperation(operationId, scheduler.getOclAnyOclIsKindOfId())) {
//				return analyzeOperationCallExp_oclIsKindOf(sourceNode, operationCallExp);
//			}
//			else {
			org.eclipse.ocl.pivot.Class returnType = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class) operationCallExp.getType());
			DependencyStep step = createClassDependencyStep(returnType, operationCallExp);
			DependencyPaths result = createDependencyPaths(step);
			for (@SuppressWarnings("null")@NonNull DependencyPaths argumentPath : argumentPaths) {
				result = result.addHidden(argumentPath);
			}
			return result;
		}

		private @NonNull DependencyPaths executeOperationCallExp_oclContainer(@NonNull OperationCallExp operationCallExp,
				@NonNull List<DependencyPaths> argumentPaths) {
			assert argumentPaths.size() == 1;
			DependencyPaths sourcePath = argumentPaths.get(0);
			DependencyPaths result = emptyDependencyPaths;
			for (List<DependencyStep> steps : sourcePath.getReturnPaths()) {
				int size = steps.size();
				assert size > 0;
				DependencyStep lastStep = steps.get(size-1);
				org.eclipse.ocl.pivot.Class sourceClass = lastStep.getElementalType();
				for (org.eclipse.ocl.pivot.Class containerClass : scheduler.getClassRelationships().getContainerClasses(sourceClass)) {
					ClassDependencyStep classDependencyStep = createClassDependencyStep(containerClass, operationCallExp);
					result = result.addReturn(createDependencyPaths(classDependencyStep));
				}
			}
			return result;
		}

		@Override
		public @NonNull DependencyPaths visitPropertyAssignment(@NonNull PropertyAssignment propertyAssignment) {
			return visiting(propertyAssignment);		// No PropertyAssignment in Operation
		}

		@Override
		public @NonNull DependencyPaths visitShadowExp(@NonNull ShadowExp shadowExp) {
			org.eclipse.ocl.pivot.Class shadowType = ClassUtil.nonNullState(shadowExp.getType());
			ClassDependencyStep step = createClassDependencyStep(shadowType, shadowExp);
			DependencyPaths result = createDependencyPaths(step);
			for (ShadowPart ownedPart : shadowExp.getOwnedParts()) {
				result = result.addReturn(analyze(ownedPart));
			}
			return result;
		}

		@Override
		public @NonNull DependencyPaths visitShadowPart(@NonNull ShadowPart shadowPart) {
			return analyze(shadowPart.getOwnedInit());
		}

		@Override
		public @NonNull DependencyPaths visitTupleLiteralExp(@NonNull TupleLiteralExp tupleLiteralExp) {
			DependencyPaths result = emptyDependencyPaths;
			for (TupleLiteralPart ownedPart : tupleLiteralExp.getOwnedParts()) {
				result = result.addReturn(analyze(ownedPart));
			}
			return result;
		}

		@Override
		public @NonNull DependencyPaths visitTupleLiteralPart(@NonNull TupleLiteralPart tupleLiteralPart) {
			return analyze(tupleLiteralPart.getOwnedInit());
		}

		@Override
		public @NonNull DependencyPaths visitTypeExp(@NonNull TypeExp typeExp) {
			return emptyDependencyPaths;
		}

		@Override
		public @NonNull DependencyPaths visitVariableExp(@NonNull VariableExp variableExp) {
			VariableDeclaration referredVariable = variableExp.getReferredVariable();
			assert referredVariable != null;
			return getVariable(referredVariable);
		}
	}

	protected class OperationAnalysis
	{
		private final @NonNull Operation operation;
		private final @NonNull List<DependencyPaths> sourceAndArgumentPaths;
		private /*@LazyNonNull*/ DependencyPaths result = null;

		/**
		 * Failed analyses that block this analysis
		 */
		private Collection<OperationAnalysis> failedAnalyses = null;

		/**
		 * Analyses that this analysis blocks
		 */
		private Set<OperationAnalysis> invokingAnalyses = null;
		
		public OperationAnalysis(@NonNull Operation operation, @NonNull List<DependencyPaths> sourceAndArgumentPaths) {
			this.operation = operation;
			this.sourceAndArgumentPaths = sourceAndArgumentPaths;
			Scheduler.DEPENDENCY_ANALYSIS.println("Create " + this);
		}
		
		private void addFailedAnalysis(@NonNull OperationAnalysis failedAnalysis) {
			if (failedAnalyses == null) {
				failedAnalyses = new HashSet<OperationAnalysis>();
			}
			failedAnalyses.add(failedAnalysis);
		}
		
		private void addInvokingAnalysis(@NonNull OperationAnalysis invokingAnalysis) {
			if (invokingAnalyses == null) {
				invokingAnalyses = new HashSet<OperationAnalysis>();
			}
			invokingAnalyses.add(invokingAnalysis);
		}

		public @Nullable DependencyPaths analyze() {
			if (result != null) {
				return result;
			}
			Scheduler.DEPENDENCY_ANALYSIS.println("Start " + this);
			try {
				DependencyAnalyzerVisitor visitor = new DependencyAnalyzerVisitor(null);
				LanguageExpression bodyExpression;
				List<? extends VariableDeclaration> ownedParameters;
				OCLExpression ownedBody;
				if (operation instanceof Function) {
					Function function  = (Function)operation;
					Transformation transformation = QVTbaseUtil.getContainingTransformation(function);
					if (transformation != null) {
						Variable thisVariable = QVTbaseUtil.getContextVariable(metamodelManager.getStandardLibrary(), transformation);
						visitor.addVariable(thisVariable, ClassUtil.nonNullState(sourceAndArgumentPaths.get(0)));
					}
					ownedParameters = function.getOwnedParameters();
					ownedBody = function.getQueryExpression();
				}
				else {
					bodyExpression = ClassUtil.nonNullState(operation.getBodyExpression());
					ExpressionInOCL specification = metamodelManager.parseSpecification(bodyExpression);
					visitor.addVariable(ClassUtil.nonNullState(specification.getOwnedContext()), ClassUtil.nonNullState(sourceAndArgumentPaths.get(0)));
					ownedParameters = specification.getOwnedParameters();
					ownedBody = specification.getOwnedBody();
				}
				int iMax = Math.min(ownedParameters.size(), sourceAndArgumentPaths.size()-1);
				for (int i = 0; i < iMax; i++) {
					visitor.addVariable(ClassUtil.nonNullState(ownedParameters.get(i)), ClassUtil.nonNullState(sourceAndArgumentPaths.get(i+1)));
				}
				result = visitor.analyze(ownedBody);
				if (invokingAnalyses != null) {
					for (OperationAnalysis invokingAnalysis : invokingAnalyses) {
						invokingAnalysis.removeFailedAnalysis(this);
					}
					invokingAnalyses.clear();
				}
				Scheduler.DEPENDENCY_ANALYSIS.println("Finish " + this);
				return result;
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BlockedAnalysisException e) {
				Scheduler.DEPENDENCY_ANALYSIS.println("Fail " + this);
				for (OperationAnalysis analysis : e.getFailedAnalyses()) {
					block(this, analysis);
				}
			}
			return null;
		}

		public void assignUnknownResult() {
			DependencyPaths dependencyPaths = sourceAndArgumentPaths.get(0);
			Iterable<List<DependencyStep>> returnPaths = dependencyPaths.getReturnPaths();
			DependencyStep step = returnPaths.iterator().next().get(0);
			result = createDependencyPaths(new UnknownDependencyStep(step.getUsage(), step.getElementalType(), step.getElement()));
			if (invokingAnalyses != null) {
				for (OperationAnalysis invokingAnalysis : new ArrayList<OperationAnalysis>(invokingAnalyses)) {
					invokingAnalyses.remove(invokingAnalysis);
					invokingAnalysis.removeFailedAnalysis(this);
				}
//				invokingAnalyses.clear();
			}
			if (failedAnalyses != null) {
				for (OperationAnalysis failedAnalysis : new ArrayList<OperationAnalysis>(failedAnalyses)) {
					failedAnalyses.remove(failedAnalysis);
					failedAnalysis.removeInvokingAnalysis(this);
				}
//				failedAnalyses.clear();
			}
			unblock(this);
			checkAll();
		}

		public void check() {
			if ((failedAnalyses != null) && !failedAnalyses.isEmpty()) {
				assert DependencyAnalyzer.this.blockedAnalyses.contains(this) : "should be blocked " + this;
				for (OperationAnalysis blockingAnalysis : failedAnalyses) {
//					assert DependencyAnalyzer.this.blockedAnalyses.contains(blockingAnalysis);
					assert blockingAnalysis.invokingAnalyses.contains(this);
				}
			}
			if (invokingAnalyses != null) {
//				assert DependencyAnalyzer.this.blockedAnalyses.contains(this);
				for (OperationAnalysis blockedAnalysis : invokingAnalyses) {
					assert DependencyAnalyzer.this.blockedAnalyses.contains(blockedAnalysis);
					assert blockedAnalysis.failedAnalyses.contains(this);
				}
			}
		}

		public @Nullable DependencyPaths getResult() {
			return result;
		}
		
		private void removeFailedAnalysis(@NonNull OperationAnalysis operationAnalysis) {
			assert failedAnalyses != null;
			boolean wasRemoved = failedAnalyses.remove(operationAnalysis);
			assert wasRemoved;
			if (failedAnalyses.size() <= 0) {
				failedAnalyses = null;
				unblock(this);
			}
		}

		private void removeInvokingAnalysis(@NonNull OperationAnalysis operationAnalysis) {
			assert invokingAnalyses != null;
			boolean wasRemoved = invokingAnalyses.remove(operationAnalysis);
			assert wasRemoved;
		}

		@Override
		public String toString() {
			return operation.toString() + " " + sourceAndArgumentPaths;
		}
	}
	
	private final @NonNull MetamodelManager metamodelManager;
	protected final @NonNull RootDomainUsageAnalysis domainUsageAnalysis;
	protected final @NonNull SchedulerConstants scheduler;
	private final @NonNull Map<List<Object>, DependencyPaths> content2path = new HashMap<List<Object>, DependencyPaths>();
	private final @NonNull DependencyPaths emptyDependencyPaths = createDependencyPaths(null, null);
	private final @NonNull Map<OperationId, Map<List<DependencyPaths>, OperationAnalysis>> operation2result = new HashMap<OperationId, Map<List<DependencyPaths>, OperationAnalysis>>();
	private final @NonNull Map<DomainUsage, DependencyStepFactory> usage2factory = new HashMap<DomainUsage, DependencyStepFactory>();
	private final @NonNull FinalAnalysis finalAnalysis;
	private final @NonNull Set<OperationAnalysis> blockedAnalyses = new HashSet<OperationAnalysis>();
	private final @NonNull Deque<OperationAnalysis> unblockedAnalyses = new LinkedList<OperationAnalysis>();
	
	public DependencyAnalyzer(@NonNull SchedulerConstants scheduler) {
		EnvironmentFactory environmentFactory = scheduler.getEnvironmentFactory();
		this.metamodelManager = environmentFactory.getMetamodelManager();
		this.domainUsageAnalysis = scheduler.getDomainAnalysis();
		this.scheduler = scheduler;
		this.finalAnalysis = new FinalAnalysis((CompleteModelInternal) environmentFactory.getCompleteModel());
	}

	public @NonNull DependencyPaths analyze(@NonNull OperationCallExp operationCallExp) {
		DependencyAnalyzerVisitor visitor = new DependencyAnalyzerVisitor(null);
		return analyze(visitor, operationCallExp);
	}

	private @NonNull DependencyPaths analyze(@NonNull DependencyAnalyzerVisitor visitor, @NonNull Element element) {
		try {
			return visitor.analyze(element);
		}
		catch (BlockedAnalysisException e) {
			while (unblockedAnalyses.size() > 0) {
				OperationAnalysis analysis = unblockedAnalyses.removeFirst();
				checkAll();
				analysis.analyze();
			}
		}
		while (blockedAnalyses.size() > 0) {
//			System.out.println("blocked");
			Map<String, @NonNull OperationAnalysis> map = new HashMap<String, @NonNull OperationAnalysis>();
			for (OperationAnalysis analysis : blockedAnalyses) {
				map.put(analysis.toString(), analysis);
			}
			List<String> keys = new ArrayList<String>(map.keySet());
			Collections.sort(keys);
			OperationAnalysis mostBlocked = null;
			int mostBlockedCount = 0;
			for (String key : keys) {
				OperationAnalysis operationAnalysis = map.get(key);
				assert operationAnalysis != null;
//				System.out.println("  " + operationAnalysis);
//				for (OperationAnalysis blockingAnalysis : operationAnalysis.failedAnalyses) {
//					System.out.println("    " + blockingAnalysis);
//				}
				operationAnalysis.check();
				if ((operationAnalysis.invokingAnalyses != null) && (operationAnalysis.invokingAnalyses.size() > mostBlockedCount)) {
					mostBlocked = operationAnalysis;
					mostBlockedCount = operationAnalysis.invokingAnalyses.size();			
				}
			}
//			System.out.println("Most blocked " + mostBlockedCount + " : " + mostBlocked);
			assert mostBlocked != null;
			mostBlocked.assignUnknownResult();
			while (unblockedAnalyses.size() > 0) {
				OperationAnalysis analysis = unblockedAnalyses.removeFirst();
				checkAll();
				analysis.analyze();
			}
		}
		Map<String, @NonNull OperationAnalysis> map2 = new HashMap<String, @NonNull OperationAnalysis>();
//		System.out.println("not blocked");
		for (Map<List<DependencyPaths>, OperationAnalysis> values : operation2result.values()) {
			for (OperationAnalysis analysis : values.values()) {
				if (!blockedAnalyses.contains(analysis)) {
					map2.put(analysis.toString(), analysis);
				}
			}
		}
		List<String> keys2 = new ArrayList<String>(map2.keySet());
		Collections.sort(keys2);
		for (String key : keys2) {
			OperationAnalysis operationAnalysis = map2.get(key);
			assert operationAnalysis != null;
//			System.out.println("  " + operationAnalysis);
//			if (operationAnalysis.failedAnalyses != null) {
//				for (OperationAnalysis failedAnalysis : operationAnalysis.failedAnalyses) {
//					System.out.println("    " + failedAnalysis);
//				}
//			}
			operationAnalysis.check();
		}
		return analyze(visitor, element);
	}
	
	public @NonNull DependencyPaths analyze(/*@NonNull*/ Element element,
			@NonNull VariableDeclaration selfVariable, @Nullable DependencyPaths selfPath) {
		assert element != null;
		DependencyAnalyzerVisitor visitor = new DependencyAnalyzerVisitor(null);
		if (selfPath == null) {
			org.eclipse.ocl.pivot.Class type = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)selfVariable.getType());
			selfPath = createDependencyPaths(createClassDependencyStep(type, selfVariable));
		}
		visitor.addVariable(selfVariable, selfPath);
		return analyze(visitor, element);
	}
	
/*	private DependencyPaths analyzeOperationCall(@NonNull Operation operation, @NonNull List<DependencyPaths> sourceAndArgumentPaths) {
		OperationId operationId = operation.getOperationId();
		Scheduler.DEPENDENCY_ANALYSIS.println(++debugDepth  + " Call " + operationId);// + " for " + sourceAndArgumentPaths);
		Map<List<DependencyPaths>, OperationAnalysis> args2result = operation2result.get(operationId);
		if (args2result == null) {
			args2result = new HashMap<List<DependencyPaths>, DependencyPaths>();
			operation2result.put(operationId, args2result);
		}
		DependencyPaths result = args2result.get(sourceAndArgumentPaths);
		if (result == null) {
			if (args2result.containsKey(sourceAndArgumentPaths)) {
				throw new IllegalStateException();
			}
			args2result.put(sourceAndArgumentPaths, null);		// FIXME better recursion
			result = emptyDependencyPaths;
			DependencyAnalyzerVisitor visitor = new DependencyAnalyzerVisitor(null);
			LanguageExpression bodyExpression = ClassUtil.nonNullState(operation.getBodyExpression());
			try {
				ExpressionInOCL specification = metamodelManager.parseSpecification(bodyExpression);
				visitor.addVariable(ClassUtil.nonNullState(specification.getOwnedContext()), ClassUtil.nonNullState(sourceAndArgumentPaths.get(0)));
				List<Variable> ownedParameters = specification.getOwnedParameters();
				int iMax = Math.min(ownedParameters.size(), sourceAndArgumentPaths.size()-1);
				for (int i = 0; i < iMax; i++) {
					visitor.addVariable(ClassUtil.nonNullState(ownedParameters.get(i)), ClassUtil.nonNullState(sourceAndArgumentPaths.get(i+1)));
				}
				result = visitor.analyze(specification.getOwnedBody());
				args2result.put(sourceAndArgumentPaths, result);
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		assert result != emptyDependencyPaths;
		Scheduler.DEPENDENCY_ANALYSIS.println(debugDepth--  + " called " + operationId);// + " => " + result);
		return result;
	} */

	protected void block(@NonNull OperationAnalysis invokingAnalysis, @NonNull OperationAnalysis failedAnalysis) {
		Scheduler.DEPENDENCY_ANALYSIS.println("Block " + invokingAnalysis + "\n  " + failedAnalysis);
		blockedAnalyses.add(invokingAnalysis);
		invokingAnalysis.addFailedAnalysis(failedAnalysis);
		failedAnalysis.addInvokingAnalysis(invokingAnalysis);
	}
	
	private void checkAll() {
		for (OperationAnalysis operationAnalysis : blockedAnalyses) {
			operationAnalysis.check();
		}
	}
	
	protected @NonNull ClassDependencyStep createClassDependencyStep(org.eclipse.ocl.pivot.@NonNull Class type, @NonNull Element element) {
		while (type instanceof CollectionType) {
			type = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class) ((CollectionType)type).getElementType());
		}
		DomainUsage usage1 = domainUsageAnalysis.basicGetUsage(type);
		DomainUsage usage = usage1 != null ? usage1 : getUsage(element);
		DependencyStepFactory factory = getDependencyStepFactory(usage);
		return factory.createClassDependencyStep(type, element);
	}

	protected @NonNull DependencyPaths createDependencyPaths(@NonNull DependencyStep returnStep) {
		Set<List<DependencyStep>> returnPaths = new HashSet<List<DependencyStep>>();
		returnPaths.add(Collections.singletonList(returnStep));
		return createDependencyPaths(returnPaths, null);
	}

	protected @NonNull DependencyPaths createDependencyPaths(@Nullable Set<List<DependencyStep>> returnPaths, @Nullable Set<List<DependencyStep>> hiddenPaths) {
		List<Object> content = new ArrayList<Object>();
		content.add(returnPaths);
		content.add(hiddenPaths);
		DependencyPaths path = content2path.get(content);
		if (path == null) {
			path = new DependencyPaths(this, returnPaths, hiddenPaths);
			content2path.put(content, path);
		}
		return path;
	}

	protected @NonNull NavigationDependencyStep createPropertyDependencyStep(@NonNull NavigationCallExp navigationCallExp) {
		DomainUsage usage = getUsage(navigationCallExp);
		DependencyStepFactory factory = getDependencyStepFactory(usage);
		return factory.createPropertyDependencyStep(navigationCallExp);
	}
	
	/**
	 * Attempt to execute all applicable overloads of operationCallExp with a given concatenation of known source and argument paths.
	 * Throws a BlockedAnalysisException if any overload is blocked pending execution of some other operation.
	 */
	protected @NonNull DependencyPaths executeOperationCall(@NonNull OperationCallExp operationCallExp,
			@NonNull List<DependencyPaths> sourceAndArgumentPaths) throws BlockedAnalysisException {
		checkAll();
		Operation referredOperation = operationCallExp.getReferredOperation();
		assert referredOperation != null;
		assert sourceAndArgumentPaths.size() > 0;
		DependencyPaths sourcePath = sourceAndArgumentPaths.get(0);
		DependencyPaths result = emptyDependencyPaths;
		List<@NonNull OperationAnalysis> failedAnalyses = null;
		for (List<DependencyStep> steps : sourcePath.getReturnPaths()) {
			int size = steps.size();
			assert size > 0;
			DependencyStep lastStep = steps.get(size-1);
			org.eclipse.ocl.pivot.Class sourceClass = lastStep.getElementalType();
			CompleteClass selfClass = metamodelManager.getCompleteModel().getCompleteClass(sourceClass);
		
			
	//		CompleteClass selfClass = metamodelManager.getCompleteModel().getCompleteClass(operationCallExp.getOwnedSource().getType());
			Iterable<Operation> overrides = finalAnalysis.getOverrides(referredOperation, selfClass);
			for (@SuppressWarnings("null")@NonNull Operation operation : overrides) {
				OperationId operationId = operation.getOperationId();
				Map<List<DependencyPaths>, OperationAnalysis> args2result = operation2result.get(operationId);
				if (args2result == null) {
					args2result = new HashMap<List<DependencyPaths>, OperationAnalysis>();
					operation2result.put(operationId, args2result);
				}
				OperationAnalysis operationAnalysis = args2result.get(sourceAndArgumentPaths);
				if (operationAnalysis == null) {
					operationAnalysis = new OperationAnalysis(operation, sourceAndArgumentPaths);
					args2result.put(sourceAndArgumentPaths, operationAnalysis);
					unblockedAnalyses.add(operationAnalysis);
				}
				DependencyPaths operationResult = operationAnalysis.getResult();
				if (operationResult == null) {
					if (failedAnalyses == null) {
						failedAnalyses = new ArrayList<@NonNull OperationAnalysis>();
					}
					failedAnalyses.add(operationAnalysis);
				}
				else if (failedAnalyses == null) {
					result = result.addReturn(operationResult);
				}
			}
		}
		if (failedAnalyses != null) {
			throw new BlockedAnalysisException(failedAnalyses);
		}
		checkAll();
		return result;
	}

	protected @NonNull DependencyStepFactory getDependencyStepFactory(@NonNull DomainUsage usage) {
		DependencyStepFactory factory = usage2factory.get(usage);
		if (factory == null) {
			factory = new DependencyStepFactory(usage);
			usage2factory.put(usage, factory);
		}
		return factory;
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return metamodelManager.getStandardLibrary();
	}

	protected @NonNull DomainUsage getUsage(@NonNull Element element) {
		DomainUsage usage = domainUsageAnalysis.basicGetUsage(element);
		assert usage != null;
		return usage;
	}
	
	protected void unblock(@NonNull OperationAnalysis operationAnalysis) {
		Scheduler.DEPENDENCY_ANALYSIS.println("Unblock " + operationAnalysis);
		@SuppressWarnings("unused")boolean wasRemoved = blockedAnalyses.remove(operationAnalysis);
//		assert wasRemoved; -- multiple unblocking occur when introducing UnknownDependencySteps
		unblockedAnalyses.addLast(operationAnalysis);
	}
}