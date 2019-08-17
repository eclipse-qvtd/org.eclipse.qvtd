/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
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
import org.eclipse.ocl.pivot.NullLiteralExp;
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
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.internal.manager.FinalAnalysis;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil.ToStringComparator;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.internal.usage.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtbase.utilities.StandardLibraryHelper;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.util.AbstractExtendingQVTcoreVisitor;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * The DependencyAnalyzer performs an simulated execution of an expression tree propagating dependencies to called operations
 * and returning the referenced types and the hidden type/property-path accesses within the execution.
 * Cached Operation analyses are specialized wrt their invocation arguments so that the analysis of each OperationCallExp
 * is sensitive to actual usage.
 */
public class OperationDependencyAnalysis
{
	public static final @NonNull TracingOption ATTEMPT = new TracingOption(CompilerConstants.PLUGIN_ID, "dependency/attempt");
	public static final @NonNull TracingOption CALL = new TracingOption(CompilerConstants.PLUGIN_ID, "dependency/call");
	public static final @NonNull TracingOption CREATE = new TracingOption(CompilerConstants.PLUGIN_ID, "dependency/create");
	public static final @NonNull TracingOption HYPOTHECATING = new TracingOption(CompilerConstants.PLUGIN_ID, "dependency/hypothecating");
	public static final @NonNull TracingOption PENDING = new TracingOption(CompilerConstants.PLUGIN_ID, "dependency/pending");
	public static final @NonNull TracingOption REFINING = new TracingOption(CompilerConstants.PLUGIN_ID, "dependency/refining");
	public static final @NonNull TracingOption RESULT = new TracingOption(CompilerConstants.PLUGIN_ID, "dependency/result");
	public static final @NonNull TracingOption START = new TracingOption(CompilerConstants.PLUGIN_ID, "dependency/start");

	/**
	 * The DependencyStepFactory ensures that all DependencyStep instances are singletons. This in turn ensures that List<DependencyStep>
	 * and Set<List<DependencyStep>> are compatibly hashed for use as keys ensuring singleton DependencyPaths.
	 */
	protected static class DependencyStepFactory
	{
		protected final @NonNull DomainUsage usage;
		private final @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull ClassDependencyStep> class2step = new HashMap<>();
		private final @NonNull Map<@NonNull VariableDeclaration, @NonNull ParameterDependencyStep> parameter2step = new HashMap<>();
		private final @NonNull Map<@NonNull Property, @NonNull NavigationDependencyStep> property2step = new HashMap<>();

		protected DependencyStepFactory(@NonNull DomainUsage usage) {
			this.usage = ClassUtil.nonNullState(usage);
		}

		public @NonNull ClassDependencyStep createClassDependencyStep(org.eclipse.ocl.pivot.@NonNull Class type, @NonNull Element element) {
			ClassDependencyStep dependencyStep = class2step.get(type);
			if (dependencyStep == null) {
				dependencyStep = new ClassDependencyStep(usage, type, element);
				class2step.put(type, dependencyStep);
			}
			return dependencyStep;
		}

		public @NonNull ParameterDependencyStep createParameterDependencyStep(org.eclipse.ocl.pivot.@NonNull Class type, @NonNull VariableDeclaration parameter) {
			ParameterDependencyStep dependencyStep = parameter2step.get(parameter);
			if (dependencyStep == null) {
				dependencyStep = new ParameterDependencyStep(usage, type, parameter);
				parameter2step.put(parameter, dependencyStep);
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

		public @NonNull NavigationDependencyStep createPropertyDependencyStep(@NonNull Property containerProperty, @NonNull OperationCallExp oclContainerCallExp) {
			NavigationDependencyStep dependencyStep = property2step.get(containerProperty);
			if (dependencyStep == null) {
				dependencyStep = new NavigationDependencyStep(usage, containerProperty, oclContainerCallExp);
				property2step.put(containerProperty, dependencyStep);
			}
			return dependencyStep;
		}

		public @NonNull DomainUsage getUsage() {
			return usage;
		}
	}

	protected abstract static class BasicDependencyStep implements OperationDependencyStep
	{
		protected final @NonNull DomainUsage usage;
		protected final @NonNull Element element;

		protected BasicDependencyStep(@NonNull DomainUsage usage, @NonNull Element element) {
			this.usage = usage;
			this.element = element;
		}

		@Override
		public @NonNull Element getElement() {
			return element;
		}

		public @Nullable CallExp getCallExp() {
			return null;
		}

		public @Nullable Property getProperty() {
			return null;
		}

		@Override
		public @NonNull DomainUsage getUsage() {
			return usage;
		}

		public boolean isParameter() {
			return false;
		}
	}

	protected static class ClassDependencyStep extends BasicDependencyStep implements OperationDependencyStep.ClassStep
	{
		private final org.eclipse.ocl.pivot.@NonNull Class type;

		public ClassDependencyStep(@NonNull DomainUsage usage, org.eclipse.ocl.pivot.@NonNull Class type, @NonNull Element element) {
			super(usage, element);
			this.type = type;
			assert !(type instanceof CollectionType);
			assert !(type instanceof VoidType);
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
		public @NonNull Element getPathElement() {
			return type;
		}

		@Override
		public String toString() {
			return usage + " «" + type.eClass().getName() + "»" + type.toString();
		}
	}

	protected static class NavigationDependencyStep extends BasicDependencyStep implements OperationDependencyStep.PropertyStep
	{
		protected final @NonNull Property property;

		public NavigationDependencyStep(@NonNull DomainUsage usage, @NonNull Property property, @NonNull CallExp element) {
			super(usage, element);
			this.property = property;
		}

		@Override
		public @NonNull CallExp getCallExp() {
			return (CallExp) element;
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

		@Override
		public @NonNull Element getPathElement() {
			return property;
		}

		@Override
		public @NonNull Property getProperty() {
			return property;
		}

		@Override
		public String toString() {
			return usage + " «" + property.eClass().getName() + "»" + property.toString();
		}
	}

	protected static class ParameterDependencyStep extends BasicDependencyStep
	{
		private final org.eclipse.ocl.pivot.@NonNull Class type;

		public ParameterDependencyStep(@NonNull DomainUsage usage, org.eclipse.ocl.pivot.@NonNull Class type, @NonNull VariableDeclaration parameter) {
			super(usage, parameter);
			this.type = type;
			assert !(type instanceof CollectionType);
		}

		@Override
		public org.eclipse.ocl.pivot.@NonNull Class getElementalType() {
			return type;
		}

		@Override
		public String getName() {
			return ((VariableDeclaration)element).getName();
		}

		@Override
		public boolean isParameter() {
			return true;
		}

		@Override
		public @NonNull Element getPathElement() {
			return element;
		}

		@Override
		public String toString() {
			return usage + " «" + type.eClass().getName() + "»" + ((VariableDeclaration)element).getName() + ":" + type.toString();
		}
	}

	/**
	 * DependencyPaths describes the set of alternative usages of an analyzed operation input/output value.
	 *
	 * Each usage is a sequence of dependency steps, rooted by a ClassDependencyStp and optionally suffixed by
	 * NavigationDependencySteps.
	 *
	 * Each usage comprises overt usages that contribute to the analyze value and further hidden usages
	 * that are used behind the scenes. e.g. a.b=c, has Boolean as an explicit return and A::b, C as hidden usages.
	 */
	protected static class BasicDependencyPaths implements OperationDependencyPaths
	{
		protected final @NonNull OperationDependencyAnalysis operationDependencyAnalysis;
		private final @NonNull Set<@NonNull List<@NonNull OperationDependencyStep>> returnPaths;
		private final @NonNull Set<@NonNull List<@NonNull OperationDependencyStep>> hiddenPaths;

		protected BasicDependencyPaths(@NonNull OperationDependencyAnalysis operationDependencyAnalysis,
				@Nullable Set<@NonNull List<@NonNull OperationDependencyStep>> returnPaths,
				@Nullable Set<@NonNull List<@NonNull OperationDependencyStep>> hiddenPaths) {
			this.operationDependencyAnalysis = operationDependencyAnalysis;
			Set<@NonNull List<@NonNull OperationDependencyStep>> immutableReturnPaths;
			if (returnPaths != null) {
				immutableReturnPaths = new HashSet<>(returnPaths.size());
				for (@NonNull List<@NonNull OperationDependencyStep> returnPath : returnPaths) {
					immutableReturnPaths.add(Collections.unmodifiableList(returnPath));
				}
			}
			else {
				immutableReturnPaths = Collections.emptySet();
			}
			this.returnPaths = Collections.unmodifiableSet(immutableReturnPaths);
			Set<@NonNull List<@NonNull OperationDependencyStep>> immutableHiddenPaths;
			if (hiddenPaths != null) {
				immutableHiddenPaths = new HashSet<>(hiddenPaths.size());
				for (@NonNull List<@NonNull OperationDependencyStep> hiddenPath : hiddenPaths) {
					immutableHiddenPaths.add(Collections.unmodifiableList(hiddenPath));
				}
			}
			else {
				immutableHiddenPaths = Collections.emptySet();
			}
			this.hiddenPaths = Collections.unmodifiableSet(immutableHiddenPaths);
		}

		/**
		 * Return a new DependencyPaths formed by the addition of both the returnPaths and the hiddenPaths of secondPath to these hiddenPaths
		 */
		public @NonNull BasicDependencyPaths addHidden(@NonNull BasicDependencyPaths secondPath) {
			Set<@NonNull List<@NonNull OperationDependencyStep>> newHiddenPaths = hiddenPaths;
			Set<@NonNull List<@NonNull OperationDependencyStep>> secondPathHiddenPaths = secondPath.basicGetHiddenPaths();
			newHiddenPaths = new HashSet<>(newHiddenPaths);
			newHiddenPaths.addAll(secondPathHiddenPaths);
			Set<@NonNull List<@NonNull OperationDependencyStep>> secondPathReturnPaths = secondPath.basicGetReturnPaths();
			newHiddenPaths = new HashSet<>(newHiddenPaths);
			newHiddenPaths.addAll(secondPathReturnPaths);
			return operationDependencyAnalysis.createDependencyPaths(returnPaths, newHiddenPaths);
		}

		/**
		 * Return a new DependencyPaths formed by the addition of the returnPaths of secondPath to these returnPaths
		 * and the addition of the hiddenPaths of secondPath to these hiddenPaths
		 */
		public @NonNull BasicDependencyPaths addReturn(@NonNull BasicDependencyPaths secondPath) {
			Set<@NonNull List<@NonNull OperationDependencyStep>> newReturnPaths;
			Set<@NonNull List<@NonNull OperationDependencyStep>> secondPathReturnPaths = secondPath.basicGetReturnPaths();
			newReturnPaths = new HashSet<>(returnPaths);
			newReturnPaths.addAll(secondPathReturnPaths);
			Set<@NonNull List<@NonNull OperationDependencyStep>> newHiddenPaths;
			Set<@NonNull List<@NonNull OperationDependencyStep>> secondPathHiddenPaths = secondPath.basicGetHiddenPaths();
			newHiddenPaths = new HashSet<>(hiddenPaths);
			newHiddenPaths.addAll(secondPathHiddenPaths);
			return operationDependencyAnalysis.createDependencyPaths(newReturnPaths, newHiddenPaths);
		}

		public @NonNull BasicDependencyPaths append(@NonNull NavigationDependencyStep propertyDependencyStep) {
			Set<@NonNull List<@NonNull OperationDependencyStep>> oldReturnPaths = returnPaths;
			if (isRedundant(oldReturnPaths, propertyDependencyStep.getProperty())) {
				return this;
			}
			StandardLibrary standardLibrary = operationDependencyAnalysis.getStandardLibrary();
			Set<@NonNull List<@NonNull OperationDependencyStep>> newReturnPaths = new HashSet<>();
			for (@NonNull List<@NonNull OperationDependencyStep> oldReturnPath : oldReturnPaths) {
				List<@NonNull OperationDependencyStep> newReturnPath = null;
				int size = oldReturnPath.size();
				assert size > 0;
				if ((size > 0) && (oldReturnPath.get(size-1) == propertyDependencyStep)) {	// ?? conformance
					newReturnPath = oldReturnPath;
				}
				else {
					org.eclipse.ocl.pivot.Class endClass = oldReturnPath.get(size-1).getElementalType();
					org.eclipse.ocl.pivot.Class sourceClass = propertyDependencyStep.getProperty().getOwningClass();
					assert sourceClass != null;
					if (endClass.conformsTo(standardLibrary, sourceClass)) {
						newReturnPath = new ArrayList<>(oldReturnPath);
						newReturnPath.add(propertyDependencyStep);
					}
					else if (sourceClass.conformsTo(standardLibrary, endClass)) {
						if (oldReturnPath.size() == 1) {
							ClassDependencyStep newClassDependencyStep = operationDependencyAnalysis.createClassDependencyStep(sourceClass, oldReturnPath.get(0).getElement());
							newReturnPath = new ArrayList<>();
							newReturnPath.add(newClassDependencyStep);
						}
						else {
							newReturnPath = new ArrayList<>(oldReturnPath);	// Consumer is responsible for observing the retyping from endClass to sourceClass
						}
						newReturnPath.add(propertyDependencyStep);
					}
					else {
						newReturnPath = oldReturnPath;
					}
				}
				newReturnPaths.add(newReturnPath);
			}
			return operationDependencyAnalysis.createDependencyPaths(newReturnPaths, hiddenPaths);
		}

		//	@Override
		public @NonNull Set<@NonNull List<@NonNull OperationDependencyStep>> basicGetHiddenPaths() {
			return hiddenPaths;
		}

		//	@Override
		public @NonNull Set<@NonNull List<@NonNull OperationDependencyStep>> basicGetReturnPaths() {
			return returnPaths;
		}

		/**
		 * Return the hidden paths as an ordered iterable.
		 */
		@Override
		public @NonNull Iterable<@NonNull List<@NonNull OperationDependencyStep>> getHiddenPaths() {
			Map<@NonNull String, @NonNull List<@NonNull OperationDependencyStep>> map = new HashMap<>();
			for (@NonNull List<@NonNull OperationDependencyStep> list : hiddenPaths) {
				map.put(String.valueOf(list), list);
			}
			List<@NonNull String> sortedKeys = new ArrayList<>(map.keySet());
			Collections.sort(sortedKeys);
			List<@NonNull List<@NonNull OperationDependencyStep>> sortedList = new ArrayList<>();
			for (@NonNull String key : sortedKeys) {
				List<@NonNull OperationDependencyStep> steps = map.get(key);
				assert steps != null;
				sortedList.add(steps);
			}
			return sortedList;
		}

		/**
		 * Return the return paths as an ordered iterable.
		 */
		@Override
		public @NonNull Iterable<@NonNull List<@NonNull OperationDependencyStep>> getReturnPaths() {
			Map<@NonNull String, @NonNull List<@NonNull OperationDependencyStep>> map = new HashMap<>();
			for (@NonNull List<@NonNull OperationDependencyStep> list : returnPaths) {
				map.put(String.valueOf(list), list);
			}
			List<@NonNull String> sortedKeys = new ArrayList<@NonNull String>(map.keySet());
			Collections.sort(sortedKeys);
			List<@NonNull List<@NonNull OperationDependencyStep>> sortedList = new ArrayList<>();
			for (@NonNull String key : sortedKeys) {
				List<@NonNull OperationDependencyStep> steps = map.get(key);
				assert steps != null;
				sortedList.add(steps);
			}
			return sortedList;
		}

		/**
		 * A property isRedundant if all paths have property as their final navigation.
		 */
		protected static boolean isRedundant(@NonNull Set<@NonNull List<@NonNull OperationDependencyStep>> paths, @NonNull Property property) {
			for (@NonNull List<@NonNull OperationDependencyStep> path : paths) {
				int size = path.size();
				if (size <= 0) {
					return false;
				}
				OperationDependencyStep dependencyStep = path.get(size-1);
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
		public @NonNull String toString() {
			StringBuilder s = new StringBuilder();
			s.append("{");
			Iterable<@NonNull List<@NonNull OperationDependencyStep>> returnPaths2 = getReturnPaths();
			boolean iFirst = true;
			for (@NonNull List<@NonNull OperationDependencyStep> path : returnPaths2) {
				if (!iFirst) {
					s.append("|");
				}
				boolean jFirst = true;
				for (@NonNull OperationDependencyStep step : path) {
					if (!jFirst) {
						s.append("::");
					}
					s.append(step.getName());
					jFirst = false;
				}
				iFirst = false;
			}
			s.append("}++{");
			Iterable<@NonNull List<@NonNull OperationDependencyStep>> hiddenPaths2 = getHiddenPaths();
			iFirst = true;
			for (@NonNull List<@NonNull OperationDependencyStep> path : hiddenPaths2) {
				if (!iFirst) {
					s.append("|");
				}
				boolean jFirst = true;
				for (@NonNull OperationDependencyStep step : path) {
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

	/**
	 * A DependencyAnalyzerVisitor performs an analyzed execution of a QVTi expression propagating the set of returned and used paths as
	 * the analysis result.
	 */
	protected class DependencyAnalyzerVisitor extends AbstractExtendingQVTcoreVisitor<@Nullable BasicDependencyPaths, @Nullable Object>
	{
		private final @NonNull AbstractOperationAnalysis analysis;

		/**
		 * True if an exact result (or null) is required. False if a partial result is permitted in order to unlock an analysis loop.
		 */
		private final boolean exactResult;
		private final @Nullable DependencyAnalyzerVisitor parent;
		private final @NonNull Map<@NonNull VariableDeclaration, @NonNull BasicDependencyPaths> variable2dependencies = new HashMap<>();

		protected DependencyAnalyzerVisitor(@NonNull AbstractOperationAnalysis analysis, boolean exactResult) {
			super(null);
			this.analysis = analysis;
			this.exactResult = exactResult;
			this.parent = null;
		}

		protected DependencyAnalyzerVisitor(@NonNull DependencyAnalyzerVisitor parent) {
			super(null);
			this.analysis = parent.analysis;
			this.exactResult = parent.exactResult;
			this.parent = parent;
		}

		private @Nullable BasicDependencyPaths addHidden(@Nullable BasicDependencyPaths accumulatingResult, @Nullable BasicDependencyPaths additionalResult) {
			if (exactResultRequired()) {
				if ((accumulatingResult == null) || (additionalResult == null)) {
					return null;
				}
				else {
					return accumulatingResult.addHidden(additionalResult);
				}
			}
			else {
				assert accumulatingResult != null;
				if (additionalResult == null) {
					return accumulatingResult;
				}
				else {
					return accumulatingResult.addHidden(additionalResult);
				}
			}
		}

		private @Nullable BasicDependencyPaths addReturn(@Nullable BasicDependencyPaths accumulatingResult, @Nullable BasicDependencyPaths additionalResult) {
			if (exactResultRequired()) {
				if ((accumulatingResult == null) || (additionalResult == null)) {
					return null;
				}
				else {
					return accumulatingResult.addReturn(additionalResult);
				}
			}
			else {
				assert accumulatingResult != null;
				if (additionalResult == null) {
					return accumulatingResult;
				}
				else {
					return accumulatingResult.addReturn(additionalResult);
				}
			}
		}

		private void addVariable(@NonNull VariableDeclaration variable, @NonNull BasicDependencyPaths value) {
			variable2dependencies.put(variable, value);
		}

		public @Nullable BasicDependencyPaths analyze(/*@NonNull*/ Visitable element) {
			return element.accept(this);
		}

		public @NonNull OperationDependencyPaths analyzeOperation(@NonNull OperationCallExp operationCallExp) {
			Operation referredOperation = operationCallExp.getReferredOperation();
			assert referredOperation != null;
			//
			//	Form the resultPaths by retaining all hidden dependencies; all dependencies are passed out.
			//
			List<@NonNull BasicDependencyPaths> resultPaths = getResultPaths(operationCallExp);
			assert resultPaths != null;
			List<@NonNull BasicDependencyPaths> allSourceAndArgumentPaths = getAllSourceAndArgumentPaths(resultPaths);
			BasicDependencyPaths result = emptyDependencyPaths;
			for (@NonNull List<@NonNull BasicDependencyPaths> aSourceAndArgumentPaths : getEachSourceAndArgumentPaths(allSourceAndArgumentPaths)) {
				OperationDependencyPaths sourcePaths = aSourceAndArgumentPaths.get(0);
				for (@NonNull List<@NonNull OperationDependencyStep> steps : sourcePaths.getReturnPaths()) {
					for (@NonNull OperationDependencyStep step : steps) {
						org.eclipse.ocl.pivot.Class sourceClass = step.getElementalType();
						CompleteClass selfClass = completeModel.getCompleteClass(sourceClass);
						Iterable<@NonNull Operation> overrides = getOverrides(selfClass, referredOperation);
						for (@NonNull Operation operation : overrides) {
							OperationId operationId = operation.getOperationId();
							Map<@NonNull List<@NonNull BasicDependencyPaths>, @NonNull OperationAnalysis> args2result = operation2paths2analysis.get(operationId);
							if (args2result != null) {
								OperationAnalysis operationAnalysis = args2result.get(aSourceAndArgumentPaths);
								if (operationAnalysis != null) {
									BasicDependencyPaths operationResult = operationAnalysis.basicGetResult();
									if (operationResult != null) {
										result = result.addReturn(operationResult);
									}
								}
							}
						}
					}
				}
			}
			return result;
		}


		private @NonNull BasicDependencyPaths analyzeOperationCallExp_oclContainer(@NonNull OperationCallExp operationCallExp, @NonNull List<@NonNull BasicDependencyPaths> sourceAndArgumentPaths) {
			assert sourceAndArgumentPaths.size() == 1;
			BasicDependencyPaths sourcePath = sourceAndArgumentPaths.get(0);
			Iterable<@NonNull List<@NonNull OperationDependencyStep>> oldReturnPaths = sourcePath.getReturnPaths();
			BasicDependencyPaths result = null;
			//
			//	The simple case of a single property can be appended to the existing path.
			//
			if (Iterables.size(oldReturnPaths) == 1) {
				List<@NonNull OperationDependencyStep> steps = oldReturnPaths.iterator().next();
				int size = steps.size();
				assert size > 0;
				OperationDependencyStep lastStep = steps.get(size-1);
				CompleteClass containedClass = completeModel.getCompleteClass(lastStep.getElementalType());
				Iterable<@NonNull Property> containmentProperties = containmentAnalysis.getContainmentProperties(containedClass);	// FIXME exploit an oclAsType
				if (Iterables.size(containmentProperties) == 1) {
					Property containmentProperty = containmentProperties.iterator().next();
					Property containerProperty = containmentProperty.getOpposite();
					if (containerProperty != null) {
						result = sourcePath.append(createPropertyDependencyStep(containerProperty, operationCallExp));
					}
				}
			}
			//
			//	The more complex case risks a combinatorial explosion of possible paths. Therefore the new container types become the return types,
			//	and each possible containment is a hidden path in addition to all the source paths.
			//
			if (result == null) {
				Set<@NonNull List<@NonNull OperationDependencyStep>> newReturnPaths = new HashSet<>();
				Set<@NonNull List<@NonNull OperationDependencyStep>> newHiddenPaths = new HashSet<>();
				Iterables.addAll(newHiddenPaths, oldReturnPaths);
				Iterables.addAll(newHiddenPaths, sourcePath.getHiddenPaths());
				for (@NonNull List<@NonNull OperationDependencyStep> steps : oldReturnPaths) {
					int size = steps.size();
					assert size > 0;
					OperationDependencyStep lastStep = steps.get(size-1);
					CompleteClass containedClass = completeModel.getCompleteClass(lastStep.getElementalType());
					Iterable<@NonNull Property> containmentProperties = containmentAnalysis.getContainmentProperties(containedClass);	// FIXME exploit an oclAsType
					for (@NonNull Property containmentProperty : containmentProperties) {
						org.eclipse.ocl.pivot.Class containerClass = PivotUtil.getOwningClass(containmentProperty);
						ClassDependencyStep classDependencyStep = createClassDependencyStep(containerClass, operationCallExp);
						newReturnPaths.add(Lists.newArrayList(classDependencyStep));
						newHiddenPaths.add(Lists.newArrayList(classDependencyStep, createPropertyDependencyStep(containmentProperty, operationCallExp)));
					}
				}
				result = createDependencyPaths(newReturnPaths, newHiddenPaths);
			}
			if (RESULT.isActive()) {
				StringBuilder s = new StringBuilder();
				for (@NonNull OperationDependencyPaths paths : sourceAndArgumentPaths) {
					s.append("\n\t=> " + paths.toString());
				}
				s.append("\n\t= " + result.toString());
				RESULT.println(operationCallExp.getReferredOperation() + s.toString());
			}
			return result;
		}

		private boolean exactResultRequired() {
			return exactResult || (pending.size() > 0);
		}

		/*		private @NonNull DependencyPaths analyzeOperationCallExp_collectionSelectByKind(@NonNull OperationCallExp operationCallExp,
				@NonNull List<@NonNull DependencyPaths> argumentPaths) {
			OCLExpression oclExpression = operationCallExp.getOwnedArguments().get(0);
			Type typeValue = oclExpression.getTypeValue();
			DependencyPaths result = emptyDependencyPaths;
			for (DependencyPaths argumentPath : argumentPaths) {
				if (argumentPath.conformsTo(typeValue)) {
					result.addReturn(argumentPath);
				}
			}
			return result;
		} */

		protected @NonNull List<@NonNull BasicDependencyPaths> getAllSourceAndArgumentPaths(@NonNull List<@NonNull BasicDependencyPaths> resultPaths) {
			List<@NonNull BasicDependencyPaths> sourceAndArgumentPaths = new ArrayList<>(resultPaths.size());
			for (@NonNull BasicDependencyPaths resultPath : resultPaths) {
				Set<@NonNull List<@NonNull OperationDependencyStep>> typePaths = new HashSet<>();
				for (@NonNull List<@NonNull OperationDependencyStep> path : resultPath.basicGetReturnPaths()) {
					OperationDependencyStep lastStep = path.get(path.size()-1);
					TypedElement typedElement = (TypedElement)lastStep.getElement();
					assert typedElement != null;
					Type type = typedElement.getType();
					assert type != null;
					ClassDependencyStep classStep = createClassDependencyStep(type, typedElement);
					typePaths.add(Collections.singletonList(classStep));
				}
				sourceAndArgumentPaths.add(createDependencyPaths(typePaths, null));
			}
			return sourceAndArgumentPaths;
		}

		protected @NonNull Iterable<@NonNull List<@NonNull BasicDependencyPaths>> getEachSourceAndArgumentPaths(@NonNull List<@NonNull BasicDependencyPaths> allSourceAndArgumentPaths) {
			List<@NonNull List<@NonNull BasicDependencyPaths>> eachSourceAndArgumentPaths = new ArrayList<>();
			for (@NonNull List<@NonNull OperationDependencyStep> aSourceStep : allSourceAndArgumentPaths.get(0).getReturnPaths()) {
				List<@NonNull BasicDependencyPaths> aSourceAndArgumentPaths = new ArrayList<>();
				aSourceAndArgumentPaths.add(createDependencyPaths(Collections.singleton(aSourceStep), null));
				for (int i = 1; i < allSourceAndArgumentPaths.size(); i++) {
					aSourceAndArgumentPaths.add(allSourceAndArgumentPaths.get(i));
				}
				eachSourceAndArgumentPaths.add(aSourceAndArgumentPaths);
			}
			return eachSourceAndArgumentPaths;
		}

		protected @NonNull Iterable<@NonNull Operation> getOverrides(@NonNull CompleteClass selfClass, @NonNull Operation referredOperation) {
			if ((selfClass == oclVoidCompleteClass) || (selfClass == oclInvalidCompleteClass)) {
				return Collections.emptyList();
			}
			return finalAnalysis.getOverrides(referredOperation, selfClass);
		}

		protected @Nullable List<@NonNull BasicDependencyPaths> getResultPaths(@NonNull OperationCallExp operationCallExp) {
			List<@NonNull BasicDependencyPaths> resultPaths = new ArrayList<>();
			BasicDependencyPaths sourcePaths = analyze(operationCallExp.getOwnedSource());
			if (sourcePaths == null) {
				return null;
			}
			resultPaths.add(createDependencyPaths(sourcePaths.basicGetReturnPaths(), sourcePaths.basicGetHiddenPaths()));
			List<@NonNull OCLExpression> arguments = ClassUtil.nullFree(operationCallExp.getOwnedArguments());
			for (@NonNull OCLExpression argument : arguments) {
				BasicDependencyPaths argumentPaths = analyze(argument);
				if (argumentPaths == null) {
					return null;
				}
				resultPaths.add(createDependencyPaths(argumentPaths.basicGetReturnPaths(), argumentPaths.basicGetHiddenPaths()));
			}
			return resultPaths;
		}

		protected @NonNull BasicDependencyPaths getVariable(@NonNull VariableDeclaration variable) {
			BasicDependencyPaths result = variable2dependencies.get(variable);
			if (result != null) {
				return result;
			}
			else if (parent != null) {
				return parent.getVariable(variable);
			}
			else {
				EObject eContainer = variable.eContainer();
				if (eContainer instanceof CorePattern) {
					return createParameterDependencyPaths(variable);
				}
				else {
					return createDependencyPaths(variable);
				}
			}
		}

		@Override
		public @Nullable BasicDependencyPaths visiting(@NonNull Visitable visitable) {
			throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
		}

		@Override
		public @Nullable BasicDependencyPaths visitCollectionLiteralExp(@NonNull CollectionLiteralExp collectionLiteralExp) {
			BasicDependencyPaths result = emptyDependencyPaths;
			for (@NonNull CollectionLiteralPart ownedPart : ClassUtil.nullFree(collectionLiteralExp.getOwnedParts())) {
				result = addReturn(result, analyze(ownedPart));
			}
			return result;
		}

		@Override
		public @Nullable BasicDependencyPaths visitCollectionItem(@NonNull CollectionItem collectionItem) {
			return analyze(collectionItem.getOwnedItem());
		}

		@Override
		public @Nullable BasicDependencyPaths visitCollectionRange(@NonNull CollectionRange collectionRange) {
			return null;
		}

		@Override
		public @Nullable BasicDependencyPaths visitIfExp(@NonNull IfExp ifExp) {
			if (ifExp.toString().contains("lookupPackage")) {
				ifExp.toString();
			}
			BasicDependencyPaths result = analyze(ifExp.getOwnedThen());
			result = addReturn(result, analyze(ifExp.getOwnedElse()));
			result = addHidden(result, analyze(ifExp.getOwnedCondition()));
			return result;
		}

		@Override
		public @Nullable BasicDependencyPaths visitLetExp(@NonNull LetExp letExp) {
			Variable ownedVariable = letExp.getOwnedVariable();
			BasicDependencyPaths initResult = analyze(ownedVariable.getOwnedInit());
			if (initResult == null) {
				return null;
			}
			DependencyAnalyzerVisitor nestedAnalyzer = new DependencyAnalyzerVisitor(this);
			nestedAnalyzer.addVariable(ownedVariable, initResult);
			BasicDependencyPaths inResult = nestedAnalyzer.analyze(letExp.getOwnedIn());
			if (inResult == null) {
				return null;
			}
			BasicDependencyPaths result = addHidden(inResult, initResult);
			return result;
		}

		@Override
		public @NonNull BasicDependencyPaths visitLiteralExp(@NonNull LiteralExp literalExp) {
			return createDependencyPaths(literalExp);
		}

		@Override
		public @Nullable BasicDependencyPaths visitLoopExp(@NonNull LoopExp loopExp) {
			BasicDependencyPaths sourcePaths = analyze(loopExp.getOwnedSource());
			if (sourcePaths == null) {
				return null;
			}
			DependencyAnalyzerVisitor nestedAnalyzer = new DependencyAnalyzerVisitor(this);
			for (@SuppressWarnings("null")@NonNull Variable iterator : loopExp.getOwnedIterators()) {
				nestedAnalyzer.addVariable(iterator, sourcePaths);
			}
			return addHidden(nestedAnalyzer.analyze(loopExp.getOwnedBody()), sourcePaths);
		}

		@Override
		public @Nullable BasicDependencyPaths visitMapLiteralExp(@NonNull MapLiteralExp mapLiteralExp) {
			BasicDependencyPaths result = emptyDependencyPaths;
			for (MapLiteralPart ownedPart : mapLiteralExp.getOwnedParts()) {
				result = addReturn(result, analyze(ownedPart));
			}
			return result;
		}

		@Override
		public @Nullable BasicDependencyPaths visitMapLiteralPart(@NonNull MapLiteralPart mapLiteralPart) {
			return analyze(mapLiteralPart.getOwnedValue());
		}

		@Override
		public @Nullable BasicDependencyPaths visitNavigationCallExp(@NonNull NavigationCallExp navigationCallExp) {
			BasicDependencyPaths sourcePaths = analyze(navigationCallExp.getOwnedSource());
			if (sourcePaths == null) {
				return null;
			}
			NavigationDependencyStep dependencyStep = createPropertyDependencyStep(navigationCallExp);
			BasicDependencyPaths result = sourcePaths.append(dependencyStep);
			return result.addHidden(sourcePaths);
		}

		@Override
		public @Nullable BasicDependencyPaths visitNullLiteralExp(@NonNull NullLiteralExp object) {
			return emptyDependencyPaths;		// We do not need OclVoid dependencies
		}

		@Override
		public @Nullable BasicDependencyPaths visitOperationCallExp(@NonNull OperationCallExp operationCallExp) {
			Operation referredOperation = operationCallExp.getReferredOperation();
			assert referredOperation != null;
			//
			//	Form the resultPaths by retaining all hidden dependencies; the result of an operationCallExp
			//	includes all dependencies from the source and argument expressions.
			//
			List<@NonNull BasicDependencyPaths> resultPaths = getResultPaths(operationCallExp);
			if (resultPaths == null) {
				return null;
			}
			//
			//	Form the sourceAndArgumentPaths by stripping all hidden dependencies; only source and argument type dependencies are
			//	passed into the operation.
			//
			List<@NonNull BasicDependencyPaths> allSourceAndArgumentPaths = getAllSourceAndArgumentPaths(resultPaths);
			if (CALL.isActive()) {
				StringBuilder s = new StringBuilder();
				for (@NonNull OperationDependencyPaths paths : allSourceAndArgumentPaths) {
					s.append("\n\t=> " + paths.toString());
				}
				CALL.println(referredOperation + s.toString());
			}
			//
			//	Analyze each possible source type
			//
			BasicDependencyPaths result = emptyDependencyPaths;
			StringBuilder s = ATTEMPT.isActive() || RESULT.isActive() ? new StringBuilder() : null;
			if (s != null) {
				Operation containingOperation = PivotUtil.getContainingOperation(operationCallExp);
				if (containingOperation != null) {
					s.append("\n\tin: " + containingOperation);
				}
				else {
					Mapping containingMapping = QVTcoreUtil.getContainingMapping(operationCallExp);
					if (containingMapping != null) {
						s.append("\n\tin: " + containingMapping);
					}
				}
				String indent = "\n\t";
				for (DependencyAnalyzerVisitor visitor = this; visitor != null; visitor = visitor.parent) {
					indent = indent + "  ";
					List<@NonNull VariableDeclaration> variables = new ArrayList<>(visitor.variable2dependencies.keySet());
					Collections.sort(variables, NameUtil.NAMEABLE_COMPARATOR);
					for (@NonNull VariableDeclaration variable : variables) {
						s.append(indent);
						s.append(variable.getName());
						s.append(": ");
						s.append(visitor.variable2dependencies.get(variable));
					}
				}
			}
			for (@NonNull List<@NonNull BasicDependencyPaths> aSourceAndArgumentPaths : getEachSourceAndArgumentPaths(allSourceAndArgumentPaths)) {
				if (s != null) {
					int i = 0;
					for (@NonNull BasicDependencyPaths callPath : aSourceAndArgumentPaths) {
						s.append("\n\t=> ");
						s.append(i == 0 ?"self" : referredOperation.getOwnedParameters().get(i-1).getName());
						s.append(": ");
						s.append(callPath.toString());
						i++;
					}
				}
				//
				//	Analyze each possible override
				//
				BasicDependencyPaths aSourcePath = aSourceAndArgumentPaths.get(0);
				Iterable<@NonNull List<@NonNull OperationDependencyStep>> aSourceReturnPaths = aSourcePath.getReturnPaths();
				assert Iterables.size(aSourceReturnPaths) == 1;
				List<@NonNull OperationDependencyStep> steps2 = aSourceReturnPaths.iterator().next();
				int size = steps2.size();
				assert size > 0;
				OperationDependencyStep lastStep = steps2.get(size-1);
				org.eclipse.ocl.pivot.Class sourceClass = lastStep.getElementalType();
				CompleteClass selfClass = completeModel.getCompleteClass(sourceClass);
				List<@NonNull Operation> sortedOverrides = Lists.newArrayList(getOverrides(selfClass, referredOperation));
				Collections.sort(sortedOverrides, ToStringComparator.INSTANCE);
				for (@NonNull Operation operation : sortedOverrides) {
					OperationId operationId = operation.getOperationId();
					Map<@NonNull List<@NonNull BasicDependencyPaths>, @NonNull OperationAnalysis> args2result = operation2paths2analysis.get(operationId);
					if (args2result == null) {
						args2result = new HashMap<>();
						operation2paths2analysis.put(operationId, args2result);
					}
					OperationAnalysis operationAnalysis = args2result.get(aSourceAndArgumentPaths);
					if (operationAnalysis == null) {
						if (referredOperation.getBodyExpression() != null) {
							operationAnalysis = new OperationAnalysis(OperationDependencyAnalysis.this, operation, aSourceAndArgumentPaths, null);
							addPendingAnalysis(operationAnalysis);				// Queue for evaluation later
							result = null;
						}
						else {
							BasicDependencyPaths localResult;
							if (PivotUtil.isSameOperation(operationId, standardLibraryHelper.getOclElementOclContainerId())) {
								localResult = analyzeOperationCallExp_oclContainer(operationCallExp, aSourceAndArgumentPaths);
							}
							//			if (PivotUtil.isSameOperation(operationId, scheduler.getCollectionSelectByKindId())) {
							//				result = analyzeOperationCallExp_collectionSelectByKind(operationCallExp, argumentPaths);
							//			}
							//			else if (PivotUtil.isSameOperation(operationId, scheduler.getOclAnyOclIsKindOfId())) {
							//				result = analyzeOperationCallExp_oclIsKindOf(sourceNode, operationCallExp);
							//			}
							else {
								localResult = createDependencyPaths(operationCallExp);
							}
							operationAnalysis = new OperationAnalysis(OperationDependencyAnalysis.this, operation, aSourceAndArgumentPaths, localResult);
							result = addReturn(result, localResult);
						}
						for (@NonNull BasicDependencyPaths callPath : aSourceAndArgumentPaths) {
							assert Iterables.isEmpty(callPath.getHiddenPaths());
						}
						args2result.put(aSourceAndArgumentPaths, operationAnalysis);
					}
					BasicDependencyPaths operationResult = operationAnalysis.getResult(analysis);
					if (s != null) {
						s.append("\n\tto: " + operation);
						s.append("\n\t\t<= " + operationResult);
					}
					if (operationResult != null) {
						result = addReturn(result, operationResult);
					}
					else if (exactResultRequired()) {
						result = null;
					}
					else {
						Type type = operation.getType();
						assert type != null;
						ClassDependencyStep classDependencyStep = createClassDependencyStep(type, operationCallExp);
						BasicDependencyPaths dependencyPaths = createDependencyPaths(classDependencyStep);
						result = addReturn(result, dependencyPaths);
					}
				}
			}
			if (result != null) {
				for (@NonNull BasicDependencyPaths argumentPath : resultPaths) {
					result = addHidden(result, argumentPath);
				}
			}
			if (s != null) {
				s.append("\n\t" + (exactResultRequired() ? "«exact» " : "«partial» ") + result);
				(result != null ? RESULT : ATTEMPT).println(operationCallExp + s.toString());
			}
			return result;
		}

		@Override
		public @Nullable BasicDependencyPaths visitOppositePropertyAssignment(@NonNull OppositePropertyAssignment propertyAssignment) {
			return visiting(propertyAssignment);		// No OppositePropertyAssignment in Operation
		}

		@Override
		public @Nullable BasicDependencyPaths visitPropertyAssignment(@NonNull PropertyAssignment propertyAssignment) {
			return visiting(propertyAssignment);		// No PropertyAssignment in Operation
		}

		@Override
		public @Nullable BasicDependencyPaths visitShadowExp(@NonNull ShadowExp shadowExp) {
			BasicDependencyPaths result = createDependencyPaths(shadowExp);
			for (ShadowPart ownedPart : shadowExp.getOwnedParts()) {
				result = addReturn(result, analyze(ownedPart));
			}
			return result;
		}

		@Override
		public @Nullable BasicDependencyPaths visitShadowPart(@NonNull ShadowPart shadowPart) {
			return analyze(shadowPart.getOwnedInit());
		}

		@Override
		public @Nullable BasicDependencyPaths visitTupleLiteralExp(@NonNull TupleLiteralExp tupleLiteralExp) {
			BasicDependencyPaths result = emptyDependencyPaths;
			for (TupleLiteralPart ownedPart : tupleLiteralExp.getOwnedParts()) {
				result = addReturn(result, analyze(ownedPart));
			}
			return result;
		}

		@Override
		public @Nullable BasicDependencyPaths visitTupleLiteralPart(@NonNull TupleLiteralPart tupleLiteralPart) {
			return analyze(tupleLiteralPart.getOwnedInit());
		}

		@Override
		public @Nullable BasicDependencyPaths visitTypeExp(@NonNull TypeExp typeExp) {
			return emptyDependencyPaths;
		}

		@Override
		public @Nullable BasicDependencyPaths visitVariableExp(@NonNull VariableExp variableExp) {
			VariableDeclaration referredVariable = variableExp.getReferredVariable();
			assert referredVariable != null;
			return getVariable(referredVariable);
		}
	}

	public static abstract class AbstractOperationAnalysis
	{
		protected final @NonNull OperationDependencyAnalysis operationDependencyAnalysis;

		/**
		 * Nested operation invocations whose analysis returned a future result.
		 */
		protected @Nullable Collection<@NonNull OperationAnalysis> invokedFutureAnalyses = null;

		/**
		 * Invoking analyses that use the future result of this analysis.
		 */
		protected @Nullable Set<@NonNull AbstractOperationAnalysis> invokingFutureAnalyses = null;

		/**
		 * The definitive analyzed execution result once all nested invocations have been fully analyzed.
		 */
		protected /*@LazyNonNull*/ BasicDependencyPaths result = null;

		protected AbstractOperationAnalysis(@NonNull OperationDependencyAnalysis operationDependencyAnalysis) {
			this.operationDependencyAnalysis = operationDependencyAnalysis;
		}

		protected void addInvokedFutureAnalysis(@NonNull OperationAnalysis invokedAnalysis) {
			Collection<@NonNull OperationAnalysis> invokedFutureAnalyses2 = invokedFutureAnalyses;
			if (invokedFutureAnalyses2 == null) {
				invokedFutureAnalyses = invokedFutureAnalyses2 = new HashSet<>();
			}
			invokedFutureAnalyses2.add(invokedAnalysis);
		}

		protected void addInvokingFutureAnalysis(@NonNull AbstractOperationAnalysis invokingAnalysis) {
			Set<@NonNull AbstractOperationAnalysis> invokingFutureAnalyses2 = invokingFutureAnalyses;
			if (invokingFutureAnalyses2 == null) {
				invokingFutureAnalyses = invokingFutureAnalyses2 = new HashSet<>();
			}
			invokingFutureAnalyses2.add(invokingAnalysis);
		}

		public abstract void analyze(boolean exactResult);

		public @Nullable BasicDependencyPaths basicGetResult() {
			return result;
		}

		public void check() {
			Collection<@NonNull OperationAnalysis> invokedFutureAnalyses2 = invokedFutureAnalyses;
			Collection<@NonNull AbstractOperationAnalysis> invokingFutureAnalyses2 = invokingFutureAnalyses;
			if (result != null) {							// KNOWN
				assert (invokedFutureAnalyses2 == null) || invokedFutureAnalyses2.isEmpty() : "Analysis with result should not invoke futures:" + this;
				assert (invokingFutureAnalyses2 == null) || invokingFutureAnalyses2.isEmpty() : "Analysis with result should not be invoked as a future: " + this;
				assert !operationDependencyAnalysis.pending.contains(this) : "Analysis with result should not be pending: " + this;
				assert !operationDependencyAnalysis.refining.contains(this) : "Analysis with result should not be refining: " + this;
			}
			else {											// PENDING / REFINING
				//				assert (invokingFutureAnalyses2 != null) && !invokingFutureAnalyses2.isEmpty() : "Analysis with future result should be invoking a future: " + this;
				if (operationDependencyAnalysis.refining.contains(this)) {											// REFINING
					assert !operationDependencyAnalysis.pending.contains(this) : "Analysis with refining result should not be pending: " + this;
					//					assert (invokingFutureAnalyses2 != null) && !invokingFutureAnalyses2.isEmpty() : "Analysis with future result should be invoking a future: " + this;
				}
				else {
					assert operationDependencyAnalysis.pending.contains(this) : "Analysis with pending result should be pending: " + this;
					assert !operationDependencyAnalysis.refining.contains(this) : "Analysis with pending result should not be refining: " + this;
				}
			}
		}

		protected void removeInvokedAnalysis(@NonNull OperationAnalysis operationAnalysis) {
			assert invokedFutureAnalyses != null;
			boolean wasRemoved = invokedFutureAnalyses.remove(operationAnalysis);
			assert wasRemoved;
		}

		protected void removeInvokingAnalysis(@NonNull AbstractOperationAnalysis operationAnalysis) {
			assert invokingFutureAnalyses != null;
			boolean wasRemoved = invokingFutureAnalyses.remove(operationAnalysis);
			assert wasRemoved;
		}

		protected void resetInvokedFutureAnalyses() {
			Collection<@NonNull OperationAnalysis> invokedFutureAnalyses2 = invokedFutureAnalyses;
			if (invokedFutureAnalyses2 != null) {
				for (@NonNull OperationAnalysis invokedFutureAnalysis : invokedFutureAnalyses2) {
					invokedFutureAnalysis.removeInvokingAnalysis(this);
				}
				invokedFutureAnalyses2.clear();
			}
		}
	}

	protected static class RootOperationAnalysis extends AbstractOperationAnalysis
	{
		protected final @NonNull OperationCallExp operationCallExp;
		protected final @NonNull DependencyAnalyzerVisitor visitor;

		public RootOperationAnalysis(@NonNull OperationDependencyAnalysis operationDependencyAnalysis, @NonNull OperationCallExp operationCallExp) {
			super(operationDependencyAnalysis);
			this.operationCallExp = operationCallExp;
			this.visitor = operationDependencyAnalysis.createDependencyAnalyzerVisitor(this, true);
		}

		@Override
		public void analyze(boolean exactResult) {
			visitor.analyze(operationCallExp);
		}

		//		@Override
		//		public @NonNull DependencyPaths getResult(@NonNull AbstractOperationAnalysis invokingAnalysis) {
		//			return ClassUtil.nonNullState(result);
		//		}

		/*		public void assignUnknownResult() {
			DependencyPaths dependencyPaths = sourceAndArgumentPaths.get(0);
			Iterable<@NonNull List<@NonNull DependencyStep>> returnPaths = dependencyPaths.getReturnPaths();
			DependencyStep step = returnPaths.iterator().next().get(0);
			result = createDependencyPaths("result", new UnknownDependencyStep(step.getUsage(), step.getElementalType(), step.getElement()));
			if (invokingFutureAnalyses != null) {
				for (OperationAnalysis invokingAnalysis : new ArrayList<OperationAnalysis>(invokingFutureAnalyses)) {
					invokingFutureAnalyses.remove(invokingAnalysis);
					invokingAnalysis.removeFailedAnalysis(this);
				}
				//				invokingFutureAnalyses.clear();
			}
			if (invokedFutureAnalyses != null) {
				for (@NonNull OperationAnalysis failedAnalysis : new ArrayList<@NonNull OperationAnalysis>(invokedFutureAnalyses)) {
					invokedFutureAnalyses.remove(failedAnalysis);
					failedAnalysis.removeInvokingAnalysis(this);
				}
				//				invokedFutureAnalyses.clear();
			}
			unblock(this);
			checkAll();
		} */

	}

	/**
	 * An OperationAnalysis captures the dependencies of an operation invocation with a particular combination of source and argument dependencies.
	 *
	 * An Analysis has four states:
	 * - UNKNOWN - no OperationAnalysis has been created
	 * - PENDING - an OperationAnalysis has been created and is ready for (re-)analysis.
	 * - REFINING - an OperationAnalysis has been created and analyzed and awaits progress wrt an invoked analysis before re-analyzing
	 * - KNOWN - an OperationAnalysis has been created and successfully analyzed to give a definitive result.
	 *
	 * Transitions:
	 * - UNKNOWN->PENDING construction as a result of an OperationCallExp analysis
	 * - PENDING->KNOWN successful analysis
	 * - PENDING->REFINING unsuccessful analysis
	 * - REFINING->PENDING successful analysis of an invoked operation
	 *
	 * State identification
	 * - UNKNOWN - no object
	 * - KNOWN - result<>null
	 * - PENDING - result=null, analyzer.pending->includes(self)
	 * - REFINING - result=null, analyzer.refining->includes(self)
	 *
	 * State invariants
	 * - UNKNOWN - no object
	 * - KNOWN - invokedFutureAnalyses->isEmpty(), invokingFutureAnalyses->isEmpty(),
	 * 		not analyzer.pending->includes(self), not analyzer.refining->includes(self)
	 * - PENDING invokingFutureAnalyses->notEmpty(), not analyzer.refining->includes(self)
	 * - REFINING invokingFutureAnalyses->notEmpty(), not analyzer.pending->includes(self)
	 */
	protected static class OperationAnalysis extends AbstractOperationAnalysis
	{
		/**
		 * The analyzed operation.
		 */
		private final @NonNull Operation operation;

		/**
		 * The source and arguments for th analyzed execution.
		 */
		private final @NonNull List<@NonNull BasicDependencyPaths> sourceAndArgumentPaths;

		public OperationAnalysis(@NonNull OperationDependencyAnalysis operationDependencyAnalysis, @NonNull Operation operation, @NonNull List<@NonNull BasicDependencyPaths> sourceAndArgumentPaths, @Nullable BasicDependencyPaths result) {
			super(operationDependencyAnalysis);
			this.operation = operation;
			this.sourceAndArgumentPaths = sourceAndArgumentPaths;
			this.result = result;
			CREATE.println(toString());
		}

		@Override
		public void analyze(boolean exactResult) {
			assert result == null;
			if (START.isActive()) {
				StringBuilder s = new StringBuilder();
				toDebug(s);
				START.println(s.toString());
			}
			resetInvokedFutureAnalyses();
			DependencyAnalyzerVisitor visitor = operationDependencyAnalysis.createDependencyAnalyzerVisitor(this, exactResult);
			LanguageExpression bodyExpression;
			List<? extends VariableDeclaration> ownedParameters;
			OCLExpression ownedBody;
			if (operation instanceof Function) {
				Function function  = (Function)operation;
				Transformation transformation = QVTbaseUtil.getContainingTransformation(function);
				Variable thisVariable = QVTbaseUtil.getContextVariable(operationDependencyAnalysis.metamodelManager.getStandardLibrary(), transformation);
				visitor.addVariable(thisVariable, ClassUtil.nonNullState(sourceAndArgumentPaths.get(0)));
				ownedParameters = function.getOwnedParameters();
				ownedBody = function.getQueryExpression();
			}
			else {
				bodyExpression = ClassUtil.nonNullState(operation.getBodyExpression());
				ExpressionInOCL specification;
				try {
					specification = operationDependencyAnalysis.environmentFactory.parseSpecification(bodyExpression);
				} catch (ParserException e) {
					throw new IllegalStateException(e);
				}
				visitor.addVariable(ClassUtil.nonNullState(specification.getOwnedContext()), ClassUtil.nonNullState(sourceAndArgumentPaths.get(0)));
				ownedParameters = specification.getOwnedParameters();
				ownedBody = specification.getOwnedBody();
			}
			int iMax = Math.min(ownedParameters.size(), sourceAndArgumentPaths.size()-1);
			for (int i = 0; i < iMax; i++) {
				visitor.addVariable(ClassUtil.nonNullState(ownedParameters.get(i)), ClassUtil.nonNullState(sourceAndArgumentPaths.get(i+1)));
			}
			BasicDependencyPaths analysisResult = visitor.analyze(ownedBody);
			Collection<@NonNull OperationAnalysis> invokedFutureAnalyses2 = invokedFutureAnalyses;
			if (analysisResult != null) {
				if (exactResult) {
					assert (invokedFutureAnalyses2 == null) || (invokedFutureAnalyses2.size() == 0);
				}
				else {
					resetInvokedFutureAnalyses();
					operationDependencyAnalysis.removeRefiningAnalysis(this);
				}
				//
				//	If this analysis has a result, everyone that invokes this analysis needs waking up.
				//
				Collection<@NonNull AbstractOperationAnalysis> invokingFutureAnalyses2 = invokingFutureAnalyses;
				if (invokingFutureAnalyses2 != null) {
					List<@NonNull AbstractOperationAnalysis> sortedInvokingFutureAnalyses = new ArrayList<>(invokingFutureAnalyses2);
					Collections.sort(sortedInvokingFutureAnalyses, ToStringComparator.INSTANCE);
					for (@NonNull AbstractOperationAnalysis invokingFutureAnalysis : sortedInvokingFutureAnalyses) {
						operationDependencyAnalysis.addPendingAnalysis(invokingFutureAnalysis);
						invokingFutureAnalysis.removeInvokedAnalysis(this);
					}
					invokingFutureAnalyses2.clear();
				}
				result = analysisResult;
			}
			else {
				//
				//	If this analysis has no result, this analysis goes into the refining queue.
				//
				assert (invokedFutureAnalyses2 != null) && (invokedFutureAnalyses2.size() > 0);
				if (!operationDependencyAnalysis.pending.contains(this)) {
					operationDependencyAnalysis.addRefiningAnalysis(this);
				}
			}
			//			}
			if ((result != null) && RESULT.isActive()) {
				StringBuilder s = new StringBuilder();
				toDebug(s);
				RESULT.println(s.toString());
			}
		}

		public @Nullable BasicDependencyPaths getResult(@NonNull AbstractOperationAnalysis invokingAnalysis) {
			if (result != null) {
				return result;
			}
			this.addInvokingFutureAnalysis(invokingAnalysis);
			invokingAnalysis.addInvokedFutureAnalysis(this);
			return null;
		}

		private void toDebug(@NonNull StringBuilder s) {
			s.append(operation);
			int i = 0;
			for (@NonNull OperationDependencyPaths sourceAndArgumentPath : sourceAndArgumentPaths) {
				s.append("\n\t=> ");
				s.append((i == 0 ? "self" : operation.getOwnedParameters().get(i-1).getName()));
				s.append(": " + sourceAndArgumentPath);
				i++;
			}
			s.append("\n\t<= " + result);
		}

		@Override
		public @NonNull String toString() {
			return operation.toString() + "; " + result + " <= " + sourceAndArgumentPaths;
		}
	}

	private final @NonNull EnvironmentFactoryInternalExtension environmentFactory;
	private final @NonNull MetamodelManager metamodelManager;
	private final @NonNull CompleteModel completeModel;
	protected final @NonNull StandardLibraryHelper standardLibraryHelper;
	protected final @NonNull RootDomainUsageAnalysis domainUsageAnalysis;
	//	protected final @NonNull ScheduleModel scheduler;
	private final @NonNull Map<@NonNull List<@Nullable Object>, @NonNull BasicDependencyPaths> content2path = new HashMap<>();
	private final @NonNull BasicDependencyPaths emptyDependencyPaths = createDependencyPaths(null, null);
	private final @NonNull Map<@NonNull OperationId, @NonNull Map<@NonNull List<@NonNull BasicDependencyPaths>, @NonNull OperationAnalysis>> operation2paths2analysis = new HashMap<>();
	private final @NonNull Map<org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage, @NonNull DependencyStepFactory> usage2factory = new HashMap<>();
	private final @NonNull ContainmentAnalysis containmentAnalysis;
	private final @NonNull FinalAnalysis finalAnalysis;
	protected final @NonNull CompleteClass oclVoidCompleteClass;
	protected final @NonNull CompleteClass oclInvalidCompleteClass;

	/**
	 * OperationAnalysis instances for which a (re-)analysis is pending.
	 */
	private final @NonNull Deque<@NonNull AbstractOperationAnalysis> pending = new LinkedList<>();

	/**
	 * OperationAnalysis instances for which a (re-)analysis awaits progress by one of its invoked analyses.
	 */
	private final @NonNull Set<@NonNull OperationAnalysis> refining = new HashSet<>();

	public OperationDependencyAnalysis(@NonNull ContainmentAnalysis containmentAnalysis, @NonNull RootDomainUsageAnalysis domainUsageAnalysis) {
		this.environmentFactory = (EnvironmentFactoryInternalExtension) containmentAnalysis.getEnvironmentFactory();
		this.metamodelManager = environmentFactory.getMetamodelManager();
		StandardLibrary standardLibrary = environmentFactory.getStandardLibrary();
		this.standardLibraryHelper = new StandardLibraryHelper(standardLibrary);
		this.domainUsageAnalysis = domainUsageAnalysis;
		this.containmentAnalysis = containmentAnalysis;
		//		this.scheduler = scheduler;
		this.finalAnalysis = ((PivotMetamodelManager)metamodelManager).getFinalAnalysis(); //new FinalAnalysis((CompleteModelInternal) environmentFactory.getCompleteModel());
		this.completeModel = environmentFactory.getCompleteModel();
		this.oclVoidCompleteClass = completeModel.getCompleteClass(standardLibrary.getOclVoidType());
		this.oclInvalidCompleteClass = completeModel.getCompleteClass(standardLibrary.getOclInvalidType());
	}

	protected void addPendingAnalysis(@NonNull AbstractOperationAnalysis operationAnalysis) {
		PENDING.println(operationAnalysis.toString()); // + "\n from " + failedAnalysis);
		assert operationAnalysis.basicGetResult() == null;
		refining.remove(operationAnalysis);
		if (!pending.contains(operationAnalysis)) {
			pending.add(operationAnalysis);
		}
	}

	protected void addRefiningAnalysis(@NonNull OperationAnalysis operationAnalysis) {
		REFINING.println(operationAnalysis.toString()); // + "\n from " + failedAnalysis);
		assert !pending.contains(operationAnalysis);
		assert operationAnalysis.basicGetResult() == null;
		refining.add(operationAnalysis);
	}

	public @NonNull OperationDependencyPaths analyze(@NonNull OperationCallExp operationCallExp) {
		RootOperationAnalysis rootAnalysis = new RootOperationAnalysis(this, operationCallExp);
		return analyze(rootAnalysis.visitor, rootAnalysis.operationCallExp);
	}

	private @NonNull OperationDependencyPaths analyze(@NonNull DependencyAnalyzerVisitor visitor, @NonNull Element element) {
		@SuppressWarnings("unused")
		OperationDependencyPaths result = visitor.analyze(element);
		while ((pending.size() > 0) || (refining.size() > 0)) {
			while (pending.size() > 0) {
				checkAll();
				AbstractOperationAnalysis analysis = pending.remove();
				analysis.analyze(true);
			}
			if (refining.size() > 0) {
				checkAll();
				OperationAnalysis analysis = removeRefining();
				analysis.analyze(false);
			}
		}
		OperationDependencyPaths result2 = visitor.analyze(element);
		return ClassUtil.nonNullState(result2);
	}

	public @NonNull OperationDependencyPaths analyzeOperation(@NonNull OperationCallExp operationCallExp) {
		RootOperationAnalysis rootAnalysis = new RootOperationAnalysis(this, operationCallExp);
		analyze(rootAnalysis.visitor, operationCallExp);
		return rootAnalysis.visitor.analyzeOperation(operationCallExp);
	}

	private void checkAll() {
		for (@NonNull Map<@NonNull List<@NonNull BasicDependencyPaths>, @NonNull OperationAnalysis> paths2analysis : operation2paths2analysis.values()) {
			for (@NonNull List<@NonNull BasicDependencyPaths> paths : paths2analysis.keySet()) {
				for (@NonNull OperationDependencyPaths path : paths) {
					assert Iterables.isEmpty(path.getHiddenPaths());
					for (@NonNull List<@NonNull OperationDependencyStep> steps : path.getReturnPaths()) {
						for (@NonNull OperationDependencyStep step : steps) {
							assert step instanceof ClassDependencyStep;
						}
					}
				}
			}
			for (@NonNull OperationAnalysis operationAnalysis : paths2analysis.values()) {
				operationAnalysis.check();
			}
		}
	}

	protected @NonNull ClassDependencyStep createClassDependencyStep(@NonNull Type type, @NonNull Element element) {
		while (type instanceof CollectionType) {
			type = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class) ((CollectionType)type).getElementType());
		}
		DomainUsage usage1 = domainUsageAnalysis.basicGetUsage(type);
		DomainUsage usage = usage1 != null ? usage1 : getUsage(element);
		DependencyStepFactory factory = getDependencyStepFactory(usage);
		return factory.createClassDependencyStep((org.eclipse.ocl.pivot.Class)type, element);
	}

	protected @NonNull DependencyAnalyzerVisitor createDependencyAnalyzerVisitor(@NonNull AbstractOperationAnalysis operationAnalysis, boolean exactResult) {
		return new DependencyAnalyzerVisitor(operationAnalysis, exactResult);
	}

	public @NonNull BasicDependencyPaths createDependencyPaths(@NonNull TypedElement typedElement) {
		org.eclipse.ocl.pivot.Class type = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)typedElement.getType());
		return createDependencyPaths(createClassDependencyStep(type, typedElement));
	}

	protected @NonNull BasicDependencyPaths createDependencyPaths(@NonNull OperationDependencyStep returnStep) {
		Set<@NonNull List<@NonNull OperationDependencyStep>> returnPaths = new HashSet<>();
		returnPaths.add(Collections.singletonList(returnStep));
		return createDependencyPaths(returnPaths, null);
	}

	protected @NonNull BasicDependencyPaths createDependencyPaths(@Nullable Set<@NonNull List<@NonNull OperationDependencyStep>> returnPaths, @Nullable Set<@NonNull List<@NonNull OperationDependencyStep>> hiddenPaths) {
		List<@Nullable Object> content = new ArrayList<>();
		content.add(returnPaths);
		content.add(hiddenPaths);
		BasicDependencyPaths path = content2path.get(content);
		if (path == null) {
			path = new BasicDependencyPaths(this, returnPaths, hiddenPaths);
			content2path.put(content, path);
		}
		return path;
	}

	public @NonNull BasicDependencyPaths createParameterDependencyPaths(@NonNull VariableDeclaration parameter) {
		return createDependencyPaths(createParameterDependencyStep(parameter));
	}

	protected @NonNull ParameterDependencyStep createParameterDependencyStep(@NonNull VariableDeclaration parameter) {
		Type type = parameter.getType();
		while (type instanceof CollectionType) {
			type = ClassUtil.nonNullState(((CollectionType)type).getElementType());
		}
		assert type != null;
		DomainUsage usage1 = domainUsageAnalysis.basicGetUsage(type);
		DomainUsage usage = usage1 != null ? usage1 : getUsage(parameter);
		DependencyStepFactory factory = getDependencyStepFactory(usage);
		return factory.createParameterDependencyStep((org.eclipse.ocl.pivot.Class)type, parameter);
	}

	protected @NonNull NavigationDependencyStep createPropertyDependencyStep(@NonNull NavigationCallExp navigationCallExp) {
		DomainUsage usage = getUsage(navigationCallExp);
		DependencyStepFactory factory = getDependencyStepFactory(usage);
		return factory.createPropertyDependencyStep(navigationCallExp);
	}

	protected @NonNull NavigationDependencyStep createPropertyDependencyStep(@NonNull Property containmentProperty, @NonNull OperationCallExp oclContainerCallExp) {
		DomainUsage usage = getUsage(containmentProperty);
		DependencyStepFactory factory = getDependencyStepFactory(usage);
		return factory.createPropertyDependencyStep(containmentProperty, oclContainerCallExp);
	}

	public void dump() {
		List<@NonNull OperationId> operationIds = new ArrayList<>(operation2paths2analysis.keySet());
		Collections.sort(operationIds, new Comparator<@NonNull OperationId>(){
			@Override
			public int compare(@NonNull OperationId o1, @NonNull OperationId o2) {
				return o1.getName().compareTo(o2.getName());
			}});
		for (@NonNull OperationId operationId : operationIds) {
			System.out.println(operationId);
			Map<@NonNull List<@NonNull BasicDependencyPaths>, @NonNull OperationAnalysis> map = operation2paths2analysis.get(operationId);
			assert map != null;
			for (@NonNull List<@NonNull BasicDependencyPaths> paths : map.keySet()) {
				for (@NonNull BasicDependencyPaths path : paths) {
					System.out.println("\t" + path);
				}
				System.out.println("\t=>" + map.get(paths));
			}
		}
	}

	protected @NonNull DependencyStepFactory getDependencyStepFactory(@NonNull DomainUsage usage) {
		DependencyStepFactory factory = usage2factory.get(usage);
		if (factory == null) {
			factory = new DependencyStepFactory(usage);
			usage2factory.put(usage, factory);
		}
		return factory;
	}

	private @NonNull Set<@NonNull AbstractOperationAnalysis> getInvokers(@NonNull AbstractOperationAnalysis analysis, @NonNull Set<@NonNull AbstractOperationAnalysis> invokers) {
		if (invokers.add(analysis) && (analysis.invokingFutureAnalyses != null)) {
			for (@NonNull AbstractOperationAnalysis invokingAnalysis : analysis.invokingFutureAnalyses) {
				getInvokers(invokingAnalysis, invokers);
			}
		}
		return invokers;
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return standardLibraryHelper.getStandardLibrary();
	}

	protected @NonNull DomainUsage getUsage(@NonNull Element element) {
		DomainUsage usage = domainUsageAnalysis.getUsage(element);
		assert usage != null;
		return usage;
	}

	protected void removeRefiningAnalysis(@NonNull OperationAnalysis operationAnalysis) {
		//		REFINING.println(operationAnalysis.toString()); // + "\n from " + failedAnalysis);
		//		assert !pending.contains(operationAnalysis);
		//		assert operationAnalysis.basicGetResult() == null;
		refining.remove(operationAnalysis);
	}

	private @NonNull OperationAnalysis removeRefining() {
		final @NonNull Map<@NonNull OperationAnalysis, @NonNull Set<@NonNull AbstractOperationAnalysis>> analysis2invokers = new HashMap<>();
		Map<@NonNull String, @NonNull OperationAnalysis> key2analysis = new HashMap<>();
		for (@NonNull OperationAnalysis analysis : refining) {
			key2analysis.put(analysis.toString(), analysis);
			analysis2invokers.put(analysis, getInvokers(analysis, new HashSet<>()));
			analysis.check();
		}
		List<@NonNull OperationAnalysis> sortedBlockedAnalyses = new ArrayList<>(refining);
		Collections.sort(sortedBlockedAnalyses, new Comparator<@NonNull AbstractOperationAnalysis>()
		{
			@Override
			public int compare(@NonNull AbstractOperationAnalysis o1, @NonNull AbstractOperationAnalysis o2) {
				Set<@NonNull AbstractOperationAnalysis> s1 = analysis2invokers.get(o1);
				Set<@NonNull AbstractOperationAnalysis> s2 = analysis2invokers.get(o2);
				assert (s1 != null) && (s2 != null);
				int i1 = s1.size();
				int i2 = s2.size();
				int diff = i1 - i2;
				if (diff != 0) {
					return diff;
				}
				return ClassUtil.safeCompareTo(o1.toString(), o2.toString());
			}});
		OperationAnalysis mostBlocked = null;
		mostBlocked = sortedBlockedAnalyses.get(sortedBlockedAnalyses.size()-1);
		//			System.out.println("Most blocked " + mostBlockedCount + " : " + mostBlocked);
		assert mostBlocked != null;
		refining.remove(mostBlocked);
		HYPOTHECATING.println(mostBlocked.toString()); // + "\n from " + failedAnalysis);
		return mostBlocked;
	}
}