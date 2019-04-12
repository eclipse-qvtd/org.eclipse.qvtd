/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation based on MtcBroker
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvti.analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.CompilerStep;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.MappingProblem;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractExtendingQVTimperativeVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

public class QVTiProductionConsumption extends AbstractExtendingQVTimperativeVisitor<@Nullable Object, @NonNull Resource>
{
	public static final @NonNull TracingOption SUMMARY = new TracingOption(CompilerConstants.PLUGIN_ID, "qvti/check/summary");

	/**
	 * PassRange captures a first..last range of passes.
	 */
	private static class PassRange
	{
		public static @NonNull PassRange create(@NonNull Element element) {
			Mapping mapping = QVTimperativeUtil.getContainingMapping(element);
			int firstPass = mapping.getFirstPass();
			Integer lastPass = mapping.getLastPass();
			return new PassRange(firstPass, lastPass == null ? firstPass : lastPass);
		}

		public static @NonNull PassRange create(@NonNull List<? extends @NonNull Element> elements) {
			PassRange passRange = new PassRange();
			for (@NonNull Element element : elements) {
				passRange = create(element).max(passRange);
			}
			return passRange;
		}

		private final int first;
		private final int last;

		public PassRange() {
			this(Integer.MAX_VALUE, Integer.MIN_VALUE);
		}

		public PassRange(int first, int last) {
			this.first = first;
			this.last = last;
		}

		@Override
		public boolean equals(Object obj) {
			PassRange that = (PassRange) obj;
			return (this.first == that.first) && (this.last == that.last);
		}

		@Override
		public int hashCode() {
			return this.first * 7 + this.last * 97;
		}

		public @NonNull PassRange max(@NonNull PassRange passRange) {
			if (this.equals(passRange)) {
				return this;
			}
			return new PassRange(Math.min(this.first, passRange.first), Math.max(this.last, passRange.last));
		}

		public boolean precedes(@NonNull PassRange passRange) {
			return this.last < passRange.first;
		}

		@Override
		public @NonNull String toString() {
			return first <= last ? "[" + first + ".." + last + "]" : "[]";
		}
	}

	/**
	 * BasePropertyAnalysis aggregates the AccessAnalysis for each access using a Property or its opposite.
	 */
	private class BasePropertyAnalysis implements Nameable
	{
		protected final @NonNull Property baseProperty;
		protected final @NonNull String name;
		protected final @NonNull Map<@NonNull CompleteClass, @NonNull Map<@NonNull CompleteClass, @NonNull AccessAnalysis>> sourceClass2targetClass2accessAnalysis = new HashMap<>();
		//	protected final @NonNull List<@NonNull AccessAnalysis> consumingAccessAnalyses = new ArrayList<>();
		//	protected final @NonNull List<@NonNull AccessAnalysis> producingAccessAnalyses = new ArrayList<>();
		protected final @NonNull Map<@NonNull Set<@NonNull AccessAnalysis>, @NonNull ConnectionAnalysis> producingAnalyses2connectionAnalysis = new HashMap<>();
		protected final @NonNull Map<@NonNull AccessAnalysis, @Nullable List<@NonNull ConnectionAnalysis>> producingAnalysis2connectionAnalyses = new HashMap<>();
		protected final @NonNull Map<@NonNull AccessAnalysis, @Nullable ConnectionAnalysis> consumingAnalysis2connectionAnalysis = new HashMap<>();

		public BasePropertyAnalysis(@NonNull Property baseProperty) {
			this.baseProperty = baseProperty;
			StringBuilder s = new StringBuilder();
			s.append(baseProperty.getOwningClass().getName());
			s.append("::");
			s.append(baseProperty.getName());
			this.name = s.toString();
			assert baseProperty == QVTscheduleUtil.getPrimaryProperty(baseProperty);
		}

		public void addConsumer(@NonNull NavigationCallExp navigationCallExp, @NonNull CompleteClass sourceClass, @NonNull Property property, @NonNull CompleteClass targetClass) {
			AccessAnalysis accessAnalysis = getAccessAnalysis(sourceClass, property, targetClass);
			accessAnalysis.addConsumer(navigationCallExp);
			if (!consumingAnalysis2connectionAnalysis.containsKey(accessAnalysis)) {
				consumingAnalysis2connectionAnalysis.put(accessAnalysis, null);
			}
		}

		public void addProducer(@NonNull NamedElement producer, @NonNull CompleteClass sourceClass, @NonNull Property property, @NonNull CompleteClass targetClass) {
			AccessAnalysis accessAnalysis = getAccessAnalysis(sourceClass, property, targetClass);
			accessAnalysis.addProducer(producer);
			if (!producingAnalysis2connectionAnalyses.containsKey(accessAnalysis)) {
				producingAnalysis2connectionAnalyses.put(accessAnalysis, null);
			}
		}

		public void analyze() {
			for (@NonNull AccessAnalysis consumingAnalysis : consumingAnalysis2connectionAnalysis.keySet()) {
				Set<@NonNull AccessAnalysis> conformingProducingAnalyses = null;
				for (@NonNull AccessAnalysis producingAnalysis : producingAnalysis2connectionAnalyses.keySet()) {
					if (isConforming(producingAnalysis, consumingAnalysis)) {
						if (conformingProducingAnalyses == null) {
							conformingProducingAnalyses = new HashSet<>();
						}
						conformingProducingAnalyses.add(producingAnalysis);
					}
				}
				if (conformingProducingAnalyses != null) {
					ConnectionAnalysis connectionAnalysis = getConnectionAnalysis(conformingProducingAnalyses);
					connectionAnalysis.addConsumingAnalysis(consumingAnalysis);
					consumingAnalysis2connectionAnalysis.put(consumingAnalysis, connectionAnalysis);
				}
			}
		}

		public @NonNull AccessAnalysis getAccessAnalysis(@NonNull CompleteClass sourceClass, @NonNull Property property, @NonNull CompleteClass targetClass) {
			Map<@NonNull CompleteClass, @NonNull AccessAnalysis> targetClass2accessAnalysis = sourceClass2targetClass2accessAnalysis.get(sourceClass);
			if (targetClass2accessAnalysis == null) {
				targetClass2accessAnalysis = new HashMap<>();
				sourceClass2targetClass2accessAnalysis.put(sourceClass, targetClass2accessAnalysis);
			}
			AccessAnalysis accessAnalysis = targetClass2accessAnalysis.get(sourceClass);
			if (accessAnalysis == null) {
				accessAnalysis = new AccessAnalysis(this, sourceClass, property, targetClass);
				targetClass2accessAnalysis.put(sourceClass, accessAnalysis);
			}
			return accessAnalysis;
		}

		protected @NonNull ConnectionAnalysis getConnectionAnalysis(@NonNull Set<@NonNull AccessAnalysis> producingAnalyses) {
			ConnectionAnalysis connectionAnalysis = producingAnalyses2connectionAnalysis.get(producingAnalyses);
			if (connectionAnalysis == null) {
				connectionAnalysis = new ConnectionAnalysis(this, producingAnalyses);
				producingAnalyses2connectionAnalysis.put(producingAnalyses, connectionAnalysis);
				for (@NonNull AccessAnalysis producingAnalysis : producingAnalyses) {
					List<@NonNull ConnectionAnalysis> connectionAnalyses = producingAnalysis2connectionAnalyses.get(producingAnalysis);
					if (connectionAnalyses == null) {
						connectionAnalyses = new ArrayList<>();
						producingAnalysis2connectionAnalyses.put(producingAnalysis, connectionAnalyses);
					}
					connectionAnalyses.add(connectionAnalysis);
				}
			}
			return connectionAnalysis;
		}

		@Override
		public @NonNull String getName() {
			return name;
		}

		private @NonNull StringBuilder initProblem(@Nullable String prefix, @NonNull NamedElement element, @Nullable String suffix) {
			StringBuilder s = new StringBuilder();
			if (prefix != null) {
				s.append(prefix);
			}
			s.append(element);
			/*	Integer firstProducer2 = firstProducer;
			s.append(" produced " + firstProducer2);
			if (firstProducer2 != null) {
				Integer lastProducer2 = lastProducer;
				if ((lastProducer2 != null) && (lastProducer2 > firstProducer2)) {
					s.append(".." + lastProducer2);
				}
			}
			Integer firstConsumer2 = firstConsumer;
			s.append(" consumed " + firstConsumer2);
			if (firstConsumer2 != null) {
				if ((lastConsumer != null) && (lastConsumer > firstConsumer2)) {
					s.append(".." + lastConsumer);
				}
			} */
			if (suffix != null) {
				s.append(suffix);
			}
			return s;
		}

		private boolean isConforming(@NonNull CompleteClass producingSourceClass, @NonNull Property producingProperty, @NonNull CompleteClass producingTargetClass,
				@NonNull CompleteClass consumingSourceClass, @NonNull Property consumingProperty, @NonNull CompleteClass consumingTargetClass) {
			boolean conformingSource = QVTscheduleUtil.conformsToClassOrBehavioralClass(producingSourceClass, consumingSourceClass)
					|| QVTscheduleUtil.conformsToClassOrBehavioralClass(consumingSourceClass, producingSourceClass);
			boolean conformingTarget = QVTscheduleUtil.conformsToClassOrBehavioralClass(producingTargetClass, consumingTargetClass)
					|| QVTscheduleUtil.conformsToClassOrBehavioralClass(consumingTargetClass, producingTargetClass);
			return conformingSource && conformingTarget;
		}

		protected boolean isConforming(@NonNull AccessAnalysis producingAnalysis, @NonNull AccessAnalysis consumingAnalysis) {
			Property consumingProperty = consumingAnalysis.property;
			CompleteClass consumingSourceClass;
			CompleteClass consumingTargetClass;
			if (consumingProperty == baseProperty) {
				consumingSourceClass = consumingAnalysis.sourceClass;
				consumingTargetClass = consumingAnalysis.targetClass;
			}
			else {
				consumingSourceClass = consumingAnalysis.targetClass;
				consumingTargetClass = consumingAnalysis.sourceClass;
			}
			Property producingProperty = producingAnalysis.property;
			CompleteClass producingSourceClass;
			CompleteClass producingTargetClass;
			if (producingProperty == baseProperty) {
				producingSourceClass = producingAnalysis.sourceClass;
				producingTargetClass = producingAnalysis.targetClass;
			}
			else {
				producingSourceClass = producingAnalysis.targetClass;
				producingTargetClass = producingAnalysis.sourceClass;
			}
			return isConforming(producingSourceClass, producingProperty, producingTargetClass, consumingSourceClass, consumingProperty, consumingTargetClass);
		}

		private boolean isNotify(@NonNull NamedElement producer) {
			if (producer instanceof SetStatement) {
				return ((SetStatement)producer).isIsNotify();
			}
			else {
				return false;
			}
		}

		private boolean isObserve(@NonNull NavigationCallExp callExp) {
			Statement statement = QVTimperativeUtil.getContainingStatement(callExp);
			if (statement instanceof ObservableStatement) {
				List<Property> observedProperties = ((ObservableStatement)statement).basicGetObservedProperties();
				if (observedProperties != null) {
					boolean contains1 = observedProperties.contains(baseProperty);
					boolean contains2 = observedProperties.contains(baseProperty.getOpposite());
					if (contains1) {
						return true;
					}
					else if (contains2) {
						return true;
					}
					else {
						return false;
					}
				}
			}
			return false;
		}

		@Override
		public @NonNull String toString() {
			return name;
		}

		public void validate(@Nullable StringBuilder s) {
			if (baseProperty.getName().equals("height")) {
				getClass();
			}
			if (s != null) {
				s.append("\n  " + name);
				for (@NonNull ConnectionAnalysis connectionAnalysis : producingAnalyses2connectionAnalysis.values()) {
					s.append("\n    connect produce " + connectionAnalysis.productionPassRange + " consume " + connectionAnalysis.consumptionPassRange);
					for (@NonNull AccessAnalysis producingAnalysis : connectionAnalysis.producingAnalyses) {
						s.append("\n      produce " + producingAnalysis.name + " " + producingAnalysis.getProductionPassRange());
						for (@NonNull NamedElement producer : producingAnalysis.producers) {
							Mapping mapping = QVTimperativeUtil.getContainingMapping(producer);
							s.append("\n        in " + mapping.getName() + " " + PassRange.create(mapping) + " " + producer);
						}
					}
					for (@NonNull AccessAnalysis consumingAnalysis : connectionAnalysis.consumingAnalyses) {
						s.append("\n      consume " + consumingAnalysis.name + " " + consumingAnalysis.getConsumptionPassRange()); // + (needsObserve ? " needsObserve" : " not-needsObserve"));
						for (@NonNull NavigationCallExp consumer : consumingAnalysis.consumers) {
							Mapping mapping = QVTimperativeUtil.getContainingMapping(consumer);
							s.append("\n        in " + mapping.getName() + " " + PassRange.create(mapping) + " " + consumer);
						}
					}
				}
			}
			List<@NonNull AccessAnalysis> producingAnalyses = new ArrayList<>(producingAnalysis2connectionAnalyses.keySet());
			Collections.sort(producingAnalyses, NameUtil.NAMEABLE_COMPARATOR);
			for (@NonNull AccessAnalysis producingAnalysis : producingAnalyses) {
				validateNotifies(s, producingAnalysis);
			}
			List<@NonNull AccessAnalysis> consumingAnalyses = new ArrayList<>(consumingAnalysis2connectionAnalysis.keySet());
			Collections.sort(producingAnalyses, NameUtil.NAMEABLE_COMPARATOR);
			for (@NonNull AccessAnalysis consumingAnalysis : consumingAnalyses) {
				validateObserves(s, consumingAnalysis);
			}
		}

		private void validateNotifies(@Nullable StringBuilder s, @NonNull AccessAnalysis producingAnalysis) {
			List<@NonNull ConnectionAnalysis> connectionAnalyses = producingAnalysis2connectionAnalyses.get(producingAnalysis);
			if (connectionAnalyses != null) {				// consumption is optional (may be produced only for output)
				boolean needsNotify = false;
				for (@NonNull ConnectionAnalysis connectionAnalysis : connectionAnalyses) {
					if (connectionAnalysis.needsNotify()) {
						needsNotify = true;
					}
				}
				for (@NonNull NamedElement producer : producingAnalysis.producers) {
					boolean isNotify = isNotify(producer);
					if (isNotify != needsNotify) {
						StringBuilder sProblem = initProblem("", producer, isNotify ? " should not be notified" : " should be notified");
						Mapping mapping = QVTimperativeUtil.getContainingMapping(producer);
						compilerStep.addProblem(new MappingProblem(CompilerProblem.Severity.ERROR, mapping, sProblem.toString()));
						if (s != null) {
							s.append("\n      BAD " + sProblem);
						}
					}
				}
			}
		}

		private void validateObserves(@Nullable StringBuilder s, @NonNull AccessAnalysis consumingAnalysis) {
			ConnectionAnalysis connectionAnalysis = consumingAnalysis2connectionAnalysis.get(consumingAnalysis);
			PassRange productionRange = connectionAnalysis != null ? connectionAnalysis.getProductionPassRange() : null;
			for (@NonNull NavigationCallExp consumer : consumingAnalysis.consumers) {
				if (productionRange == null) {
					StringBuilder sProblem = initProblem("", consumer, " is not produced");
					Mapping mapping = QVTimperativeUtil.getContainingMapping(consumer);
					compilerStep.addProblem(new MappingProblem(CompilerProblem.Severity.ERROR, mapping, sProblem.toString()));
					if (s != null) {
						s.append("\n      BAD " + sProblem);
					}
				}
				else {
					PassRange consumerPassRange = PassRange.create(consumer);
					boolean needsObserve = !productionRange.precedes(consumerPassRange);
					boolean isObserve = isObserve(consumer);
					if (isObserve != needsObserve) {
						StringBuilder sProblem = initProblem("", consumer, isObserve ? " should not be observed" : " should be observed");
						Mapping mapping = QVTimperativeUtil.getContainingMapping(consumer);
						compilerStep.addProblem(new MappingProblem(CompilerProblem.Severity.ERROR, mapping, sProblem.toString()));
						if (s != null) {
							s.append("\n      BAD " + sProblem);
						}
					}
				}
			}
		}
	}

	/**
	 * AccessAnalysis aggregates the producer/consumer analysis of a source-CompleteClass via property to target-CompleteClass slot value.
	 */
	private class AccessAnalysis implements Nameable
	{
		//	protected final @NonNull BasePropertyAnalysis basePropertyAnalysis;
		protected final @NonNull CompleteClass sourceClass;
		protected final @NonNull Property property;
		protected final @NonNull CompleteClass targetClass;
		protected final @NonNull String name;
		private final @NonNull List<@NonNull NamedElement> producers = new ArrayList<>();
		private final @NonNull List<@NonNull NavigationCallExp> consumers = new ArrayList<>();
		private @Nullable PassRange consumptionPassRange = null;
		private @Nullable PassRange productionPassRange = null;

		public AccessAnalysis(@NonNull BasePropertyAnalysis basePropertyAnalysis, @NonNull CompleteClass sourceClass, @NonNull Property property, @NonNull CompleteClass targetClass) {
			//	this.basePropertyAnalysis = basePropertyAnalysis;
			this.sourceClass = sourceClass;
			this.property = property;
			this.targetClass = targetClass;
			StringBuilder s = new StringBuilder();
			s.append(sourceClass.getName());
			s.append("::");
			s.append(property.getName());
			s.append(" : ");
			s.append(targetClass.getName());
			this.name = s.toString();
		}

		public void addConsumer(@NonNull NavigationCallExp consumer) {
			assert consumptionPassRange == null;
			isDebugTarget(QVTimperativeUtil.getReferredProperty(consumer));
			consumers.add(consumer);
		}

		public void addProducer(@NonNull NamedElement producer) {
			assert productionPassRange == null;
			if ("AttributeToColumn::owner".equals(toString()) || "NonLeafAttribute::owner".equals(toString()) || "FromAttribute::owner".equals(toString())) {
				getClass();
			}
			if (producer instanceof SetStatement) {
				isDebugTarget(QVTimperativeUtil.getTargetProperty((SetStatement)producer));
			}
			else if (producer instanceof GuardParameter) {
				Property successProperty = ((GuardParameter)producer).getSuccessProperty();
				if (successProperty != null) {
					isDebugTarget(successProperty);
				}
			}
			producers.add(producer);
		}

		public @NonNull PassRange getConsumptionPassRange() {
			PassRange consumptionPassRange2 = consumptionPassRange;
			if (consumptionPassRange2 == null) {
				consumptionPassRange = consumptionPassRange2 = PassRange.create(consumers);
			}
			return consumptionPassRange2;
		}


		@Override
		public @NonNull String getName() {
			return name;
		}

		public @NonNull PassRange getProductionPassRange() {
			PassRange productionPassRange2 = productionPassRange;
			if (productionPassRange2 == null) {
				productionPassRange = productionPassRange2 = PassRange.create(producers);
			}
			return productionPassRange2;
		}

		//	public @NonNull String getRangeTexts() {
		//		return getProductionPassRange() + " " + getConsumptionPassRange();
		//	}

		private void isDebugTarget(@NonNull Property property) {
			String name1 = property.getName();
			if ("fromAttributes".equals(name1)) {
				getClass();
			}
			Property opposite = property.getOpposite();
			if (opposite != null) {
				String name2 = opposite.getName();
				if ("fromAttributes".equals(name2)) {
					getClass();
				}
			}
		}

		@Override
		public @NonNull String toString() {
			return name;
		}

		/*	public void validate(@Nullable StringBuilder s) {
			if ("ClassToTable::fromAttributes".equals(toString())) {
				getClass();
			}
			Summary summary = new Summary(this, null);
			for (@NonNull NamedElement producer : producers) {
				Mapping mapping = QVTimperativeUtil.getContainingMapping(producer);
				summary.setProducer(mapping, sourceClass, producer);
			}
			for (@NonNull NavigationCallExp consumer : consumers) {
				Mapping mapping = QVTimperativeUtil.getContainingMapping(consumer);
				summary.setConsumer(mapping, sourceClass, consumer);
			}
			if (s != null) {
				s.append("\n  " + summary.appendAccessAnalysis());
			}
			//	for (@NonNull NamedElement producer : producers) {
			summary.checkProducers();
			//	}
			for (@NonNull NavigationCallExp consumer : consumers) {
				summary.checkConsumer(s, consumer);
			}
		} */
	}

	/**
	 * ConnectionAnalysis matches the conforming production and consumption analyses that correspond to a connection.
	 */
	private class ConnectionAnalysis //implements Nameable
	{
		protected final @NonNull BasePropertyAnalysis basePropertyAnalysis;
		protected final @NonNull Set<@NonNull AccessAnalysis> producingAnalyses;
		protected final @NonNull PassRange productionPassRange;
		protected final @NonNull List<@NonNull AccessAnalysis> consumingAnalyses = new ArrayList<>();
		private @NonNull PassRange consumptionPassRange = new PassRange();

		public ConnectionAnalysis(@NonNull BasePropertyAnalysis basePropertyAnalysis, @NonNull Set<@NonNull AccessAnalysis> producingAnalyses) {
			this.basePropertyAnalysis = basePropertyAnalysis;
			this.producingAnalyses = producingAnalyses;
			PassRange productionPassRange = new PassRange();
			for (@NonNull AccessAnalysis producingAnalysis : producingAnalyses) {
				productionPassRange = productionPassRange.max(producingAnalysis.getProductionPassRange());
			}
			this.productionPassRange = productionPassRange;
		}

		//	public @NonNull PassRange getConsumptionPassRange() {
		//		return consumptionPassRange;
		//	}

		public @NonNull PassRange getProductionPassRange() {
			return productionPassRange;
		}

		public void addConsumingAnalysis(@NonNull AccessAnalysis consumingAnalysis) {
			assert !consumingAnalyses.contains(consumingAnalysis);
			consumingAnalyses.add(consumingAnalysis);
			consumptionPassRange = consumptionPassRange.max(consumingAnalysis.getConsumptionPassRange());
		}

		public boolean needsNotify() {
			return !productionPassRange.precedes(consumptionPassRange);
		}

		//	public boolean needsObserve(@NonNull AccessAnalysis consumingAnalysis) {
		//		return !productionPassRange.precedes(consumingAnalysis.getConsumptionPassRange());
		//	}

		@Override
		public @NonNull String toString() {
			return basePropertyAnalysis.toString() + " " + productionPassRange + " " + consumptionPassRange;
		}

		/*	public void validate(@Nullable StringBuilder s) {
			if (s != null) {
				s.append("\n    connection " + productionPassRange + " " + consumptionPassRange + (needsNotify() ? " needsNotify" : " not-needsNotify"));
			}
			for (@NonNull AccessAnalysis producingAnalysis : producingAnalyses) {
				if (s != null) {
					s.append("\n    produce " + producingAnalysis.name + " " + producingAnalysis.getProductionPassRange());
					for (@NonNull NamedElement producer : producingAnalysis.producers) {
						Mapping mapping = QVTimperativeUtil.getContainingMapping(producer);
						s.append("\n      in " + mapping.getName() + " " + PassRange.create(mapping) + " " + producer);
					}
				}
			}
		} */

		/*	private void validateConsumption(@Nullable StringBuilder s, @NonNull AccessAnalysis consumingAnalysis) {
			PassRange consumingPassRange = consumingAnalysis.getConsumptionPassRange();
			PassRange producingPassRange = new PassRange();
			List<@NonNull AccessAnalysis> conformingProducingAnalyses = null;
			for (@NonNull AccessAnalysis producingAnalysis : producingAccessAnalyses) {
				if (isConforming(producingAnalysis, consumingAnalysis)) {
					if (conformingProducingAnalyses == null) {
						conformingProducingAnalyses = new ArrayList<>();
					}
					conformingProducingAnalyses.add(producingAnalysis);
					producingPassRange = producingPassRange.max(producingAnalysis.getProductionPassRange());
				}
			}
			boolean needsObserve = !producingPassRange.precedes(consumingPassRange);
			if (s != null) {
				s.append("\n    consume " + consumingAnalysis.name + " " + consumingAnalysis.getRangeTexts() + (needsObserve ? " needsObserve" : " not-needsObserve"));
				for (@NonNull NavigationCallExp consumer : consumingAnalysis.consumers) {
					Mapping mapping = QVTimperativeUtil.getContainingMapping(consumer);
					s.append("\n      in " + mapping.getName() + " " + PassRange.create(mapping) + " " + consumer);
				}
			}
			if (conformingProducingAnalyses != null) {
				for (@NonNull AccessAnalysis producingAnalysis : conformingProducingAnalyses) {
					if (s != null) {
						s.append("\n      conforming " + producingAnalysis.name + " " + producingAnalysis.getRangeTexts());
						for (@NonNull NamedElement producer : producingAnalysis.producers) {
							Mapping mapping = QVTimperativeUtil.getContainingMapping(producer);
							s.append("\n        from " + mapping.getName() + " " + PassRange.create(mapping) + " " + producer);
						}
					}
				}
			}
			for (@NonNull NavigationCallExp consumer : consumingAnalysis.consumers) {
				boolean isObserve = isObserve(consumer);
				if (isObserve != needsObserve) {
					StringBuilder sProblem = initProblem("", consumer, isObserve ? " should not be observed" : " should be observed");
					Mapping mapping = QVTimperativeUtil.getContainingMapping(consumer);
					compilerStep.addProblem(new MappingProblem(CompilerProblem.Severity.ERROR, mapping, sProblem.toString()));
					if (s != null) {
						s.append("\n      BAD " + sProblem);
					}
				}
			}
		} */

		/*	private void validateProduction(@Nullable StringBuilder s, @NonNull AccessAnalysis producingAnalysis) {
			//	PassRange producingPassRange = producingAnalysis.getProductionPassRange();
			PassRange producingPassRange = new PassRange();
			PassRange consumingPassRange = new PassRange();
			List<@NonNull AccessAnalysis> conformingConsumingAnalyses = null;
			for (@NonNull AccessAnalysis consumingAnalysis : consumingAccessAnalyses) {
				if (isConforming(producingAnalysis, consumingAnalysis)) {
					if (conformingConsumingAnalyses == null) {
						conformingConsumingAnalyses = new ArrayList<>();
					}
					conformingConsumingAnalyses.add(consumingAnalysis);
					consumingPassRange = consumingPassRange.max(consumingAnalysis.getConsumptionPassRange());
					producingPassRange = producingPassRange.max(producingAnalysis.getProductionPassRange());
				}
			}
			boolean needsNotify = !producingPassRange.precedes(consumingPassRange);
			if (s != null) {
				s.append("\n    produce " + producingAnalysis.name + " " + producingAnalysis.getRangeTexts() + (needsNotify ? " needsNotify" : " not-needsNotify"));
				for (@NonNull NamedElement producer : producingAnalysis.producers) {
					Mapping mapping = QVTimperativeUtil.getContainingMapping(producer);
					s.append("\n      in " + mapping.getName() + " " + PassRange.create(mapping) + " " + producer);
				}
			}
			if (conformingConsumingAnalyses != null) {
				for (@NonNull AccessAnalysis consumingAnalysis : conformingConsumingAnalyses) {
					if (s != null) {
						s.append("\n      conforming " + consumingAnalysis.name + " " + consumingAnalysis.getRangeTexts());
						for (@NonNull NavigationCallExp consumer : consumingAnalysis.consumers) {
							Mapping mapping = QVTimperativeUtil.getContainingMapping(consumer);
							s.append("\n        for " + mapping.getName() + " " + PassRange.create(mapping) + " " + consumer);
						}
					}
				}
			}
			for (@NonNull NamedElement producer : producingAnalysis.producers) {
				boolean isNotify = isNotify(producer);
				if (isNotify != needsNotify) {
					StringBuilder sProblem = initProblem("", producer, isNotify ? " should not be notified" : " should be notified");
					Mapping mapping = QVTimperativeUtil.getContainingMapping(producer);
					compilerStep.addProblem(new MappingProblem(CompilerProblem.Severity.ERROR, mapping, sProblem.toString()));
					if (s != null) {
						s.append("\n      BAD " + sProblem);
					}
				}
			}
		} */
	}

	/**
	 * Summary aggregates the production/consumption timing on a specific Connection.
	 *
	private class Summary
	{
		private final @NonNull AccessAnalysis accessAnalysis;
		private final @Nullable AccessAnalysis forAccessAnalysis;
		private @Nullable Integer firstProducer = null;
		private @Nullable Integer lastProducer = null;
		private @Nullable Integer firstConsumer = null;
		private @Nullable Integer lastConsumer = null;
		private final @NonNull StringBuilder s = new StringBuilder();
		private boolean anyObserve = false;
		private @NonNull List<@NonNull NavigationCallExp> debugConsumers = new ArrayList<>();
		private @NonNull List<@NonNull NamedElement> debugProducers = new ArrayList<>();

		public Summary(@NonNull AccessAnalysis accessAnalysis, @Nullable AccessAnalysis forAccessAnalysis) {
			this.accessAnalysis = accessAnalysis;
			this.forAccessAnalysis = forAccessAnalysis;
			s.append(accessAnalysis.toString());
			if (forAccessAnalysis != null) {
				s.append(" for ");
				s.append(forAccessAnalysis.toString());
			}
		}

		public @NonNull String appendAccessAnalysis() {
			Integer firstProducer2 = firstProducer;
			s.append("\n\tproduce " + firstProducer2);
			if (firstProducer2 != null) {
				if ((lastProducer != null) && (lastProducer > firstProducer2)) {
					s.append(".." + lastProducer);
				}
			}
			Integer firstConsumer2 = firstConsumer;
			s.append(" consume " + firstConsumer2);
			if (firstConsumer2 != null) {
				if ((lastConsumer != null) && (lastConsumer > firstConsumer2)) {
					s.append(".." + lastConsumer);
				}
			}
			return s.toString();
		}

		/*	public void checkConsumer(@Nullable StringBuilder s, @NonNull NavigationCallExp consumer) {
			//	Property referredProperty = QVTimperativeUtil.getReferredProperty(consumer);
			//	Map<@NonNull CompleteClass, @NonNull AccessAnalysis> class2connection = property2class2connection.get(referredProperty);
			//	assert class2connection != null;
			//	CompleteClass completeClass = getCompleteClass(QVTimperativeUtil.getOwningClass(referredProperty));
			//	AccessAnalysis zbaseAccessAnalysis = accessAnalysis; //class2connection.get(completeClass);
			//	assert zbaseAccessAnalysis != null;
			CompleteClass completeClass = accessAnalysis.sourceClass;
			//	Map<@NonNull CompleteClass, List<@NonNull NamedElement>> class2producers = property2class2producers.get(property);
			//	assert class2producers != null;
			//	List<@NonNull NamedElement> producers = connection.producers;
			//	if (producers != null) {
			//		for (@NonNull NavigationCallExp callExp : connection.consumers) {
			///			Mapping mapping = QVTimperativeUtil.getContainingMapping(callExp);
			//			connection.setConsumer(mapping, asClass, callExp);
			//		}
			//	}
			boolean isObserve = isObserve(consumer);
			Mapping mapping = QVTimperativeUtil.getContainingMapping(consumer);
			int firstPass = mapping.getFirstPass();
			Integer lastProducer2 = lastProducer;
			if (lastProducer2 == null) {
				if (isObserve) {
					StringBuilder s2 = initProblem("Not-produced ", " should not be observed");
					compilerStep.addProblem(new MappingProblem(CompilerProblem.Severity.ERROR, mapping, s2.toString()));
				}
				else {
					Property referredProperty = QVTimperativeUtil.getReferredProperty(consumer);
					BasePropertyAnalysis basePropertyAnalysis = getBasePropertyAnalysis(referredProperty);
					basePropertyAnalysis.checkConsumer(s, consumer, completeClass, referredProperty);
				}
			}
			else if (!isObserve) {
				if (firstPass <= lastProducer2) {
					StringBuilder s2 = initProblem(null, " should be observed");
					compilerStep.addProblem(new MappingProblem(CompilerProblem.Severity.ERROR, mapping, s2.toString()));
				}
			}
			else {
				if (firstPass > lastProducer2) {
					StringBuilder s2 = initProblem(null, " should not be observed");
					compilerStep.addProblem(new MappingProblem(CompilerProblem.Severity.ERROR, mapping, s2.toString()));
				}
			}
		} */

	/*	public void checkProducers() {
			if (anyObserve) {
				Integer firstConsumer2 = firstConsumer;
				Integer lastProducer2 = lastProducer;
				if ((firstConsumer2 != null) && (lastProducer2 != null) && (firstConsumer2 <= lastProducer2)) {
					for (@NonNull NamedElement producer : accessAnalysis.producers) {
						if (!isNotify(producer)) {
							StringBuilder s = initProblem("", " should be notified");
							Mapping mapping = QVTimperativeUtil.getContainingMapping(producer);
							compilerStep.addProblem(new MappingProblem(CompilerProblem.Severity.ERROR, mapping, s.toString()));
						}
					}
				}
			}
		} * /

		private @NonNull StringBuilder initProblem(@Nullable String prefix, @Nullable String suffix) {
			StringBuilder s = new StringBuilder();
			if (prefix != null) {
				s.append(prefix);
			}
			s.append(accessAnalysis);
			Integer firstProducer2 = firstProducer;
			s.append(" produced " + firstProducer2);
			if (firstProducer2 != null) {
				Integer lastProducer2 = lastProducer;
				if ((lastProducer2 != null) && (lastProducer2 > firstProducer2)) {
					s.append(".." + lastProducer2);
				}
			}
			Integer firstConsumer2 = firstConsumer;
			s.append(" consumed " + firstConsumer2);
			if (firstConsumer2 != null) {
				if ((lastConsumer != null) && (lastConsumer > firstConsumer2)) {
					s.append(".." + lastConsumer);
				}
			}
			if (suffix != null) {
				s.append(suffix);
			}
			return s;
		}

		private boolean isNotify(NamedElement producer) {
			if (producer instanceof SetStatement) {
				return ((SetStatement)producer).isIsNotify();
			}
			else {
				return false;
			}
		}

		private boolean isObserve(@NonNull NavigationCallExp callExp) {
			Statement statement = QVTimperativeUtil.getContainingStatement(callExp);
			if (statement instanceof ObservableStatement) {
				List<Property> observedProperties = ((ObservableStatement)statement).basicGetObservedProperties();
				if (observedProperties != null) {
					boolean contains1 = observedProperties.contains(accessAnalysis.property);
					boolean contains2 = observedProperties.contains(accessAnalysis.property.getOpposite());
					if (contains1) {
						return true;
					}
					else if (contains2) {
						return true;
					}
					else {
						return false;
					}
				}
			}
			return false;
		}

		public void setConsumer(@NonNull Mapping mapping, @NonNull CompleteClass completeClass, @NonNull NavigationCallExp callExp) {
			debugConsumers.add(callExp);
			boolean anObserve = isObserve(callExp);
			if (anObserve) {
				anyObserve  = true;
			}
			int firstPass = mapping.getFirstPass();
			Integer lastPassOrNull = mapping.getLastPass();
			int lastPass = lastPassOrNull != null ? lastPassOrNull : firstPass;
			Integer firstConsumer2 = firstConsumer;
			if ((firstConsumer2 == null) || (firstPass < firstConsumer2)) {
				firstConsumer = firstConsumer2 = firstPass;
			}
			Integer lastConsumer2 = lastConsumer;
			if ((lastConsumer2 == null) || (lastPass > lastConsumer2)) {
				lastConsumer = lastConsumer2 = lastPass;
			}
			s.append("\n\tconsume ");
			s.append(accessAnalysis);
			s.append(" in ");
			s.append(mapping.getName());
			s.append(" at " + firstPass);
			if (lastPassOrNull != null) {
				s.append(".." + lastPass);
			}
			s.append(" " + (anObserve ? "observe" : "no-observe"));
		}

		public void setProducer(@NonNull Mapping mapping, @NonNull CompleteClass completeClass, @NonNull NamedElement producer) {
			debugProducers.add(producer);
			boolean isNotify = isNotify(producer);
			int firstPass = mapping.getFirstPass();
			@Nullable Integer lastPassOrNull = mapping.getLastPass();
			int lastPass = lastPassOrNull != null ? lastPassOrNull : firstPass;
			Integer firstProducer2 = firstProducer;
			if ((firstProducer2 == null) || (firstPass < firstProducer2)) {
				firstProducer = firstProducer2 = firstPass;
			}
			Integer lastProducer2 = lastProducer;
			if ((lastProducer2 == null) || (lastPass > lastProducer2)) {
				lastProducer = lastProducer2 = lastPass;
			}
			s.append("\n\tproduce ");
			s.append(accessAnalysis);
			s.append(" in ");
			s.append(mapping.getName());
			s.append(" at " + firstPass);
			if (lastPassOrNull != null) {
				s.append(".." + lastPass);
			}
			s.append(" " + (isNotify ? "notify" : "no-notify"));
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append(accessAnalysis.toString());
			s.append(" produce ");
			s.append(firstProducer);
			s.append("..");
			s.append(lastProducer);
			s.append(" consume ");
			s.append(firstConsumer);
			s.append("..");
			s.append(lastConsumer);
			return s.toString();
		}
	} */

	protected final @NonNull CompilerStep compilerStep;
	protected final @NonNull QVTimperativeDomainUsageAnalysis domainUsageAnalysis;
	//	protected final @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull List<@NonNull NamedElement>> class2producers = new HashMap<>();
	protected final @NonNull Map<@NonNull Property, @NonNull BasePropertyAnalysis> property2basePropertyAnalysis = new HashMap<>();
	protected final @NonNull CompleteModel completeModel;

	public QVTiProductionConsumption(@NonNull CompilerStep compilerStep, @NonNull Resource iResource) {
		super(iResource);
		this.compilerStep = compilerStep;
		this.domainUsageAnalysis = new QVTimperativeDomainUsageAnalysis(compilerStep.getEnvironmentFactory());
		this.completeModel = compilerStep.getEnvironmentFactory().getCompleteModel();
	}

	public void analyze() {
		//
		//	Traverse the model to discover all producers and consumers with a corresponding AccessAnalysis supervised by a BasePropertyAnalysis.
		//
		for (@NonNull EObject eObject : new TreeIterable(context)) {
			if (eObject instanceof Visitable) {
				((Visitable)eObject).accept(this);
			}
		}
		//
		//	Build the CommunicationAnalysis instances for each BasePropertyAnalysis.
		//
		for (@NonNull BasePropertyAnalysis basePropertyAnalysis : property2basePropertyAnalysis.values()) {
			basePropertyAnalysis.analyze();
		}
	}

	/*
	 *	Propagate each producing AccessAnalysis to each conforming consuming AccessAnalysis.
	 *
	protected void analyzeProductionEquivalents() {
		//
		//	Propagate explicit producers to their sub producers.
		//
		for (@NonNull BasePropertyAnalysis basePropertyAnalysis : property2basePropertyAnalysis.values()) {
			basePropertyAnalysis.propagateToSubs();
		}
		//
		//	Propagate explicit derived producers to their super producers.
		//
		for (@NonNull BasePropertyAnalysis basePropertyAnalysis : property2basePropertyAnalysis.values()) {
			basePropertyAnalysis.propagateToSupers();
		}
	} */

	/*	protected void zdoProducer(@NonNull NamedElement producer, @NonNull CompleteClass targetClass, @NonNull Property setProperty) {
		//	CompleteClass owningClass = getCompleteClass(QVTimperativeUtil.getOwningClass(setProperty));
		//	CompleteInheritance owningInheritance = owningClass.getCompleteInheritance();
		//	CompleteInheritance targetInheritance = targetClass.getCompleteInheritance();
		//	int owningDepth = owningInheritance.getDepth();
		//	int targetDepth = targetInheritance.getDepth();
		//	for (int i = owningDepth; i <= targetDepth; i++) {
		//		Iterable<@NonNull InheritanceFragment> superFragments = targetInheritance.getSuperFragments(i);
		//		for (@NonNull InheritanceFragment superFragment : superFragments) {
		//			Iterable<@NonNull InheritanceFragment> owningSuperFragments = superFragment.getDerivedInheritance().getSuperFragments(owningDepth);
		//			for (@NonNull InheritanceFragment owningSuperFragment : owningSuperFragments) {
		//				if (owningSuperFragment.getBaseInheritance() == owningInheritance) {
		//					CompleteClass superClass = ((CompleteInheritanceImpl)superFragment.getBaseInheritance()).getCompleteClass();
		AccessAnalysis accessAnalysis = getAccessAnalysis(targetClass, setProperty);
		accessAnalysis.addProducer(producer);
		//				}
		//			}
		//		}
		//	}
	} */

	protected BasePropertyAnalysis getBasePropertyAnalysis(@NonNull Property property) {
		Property baseProperty = QVTscheduleUtil.getPrimaryProperty(property);
		BasePropertyAnalysis basePropertyAnalysis = property2basePropertyAnalysis.get(baseProperty);
		if (basePropertyAnalysis == null) {
			basePropertyAnalysis = new BasePropertyAnalysis(baseProperty);
			property2basePropertyAnalysis.put(baseProperty, basePropertyAnalysis);
		}
		return basePropertyAnalysis;
	}

	/**
	 * Return the distinct ancestors of derivedCompleteClass that are derived from baseCompleteClass. Result includes baseCompleteClass and derivedCompleteClass
	 * unless derivedCompleteClass does nt actuall dertived from baseCompleteClass.
	 *
	private @NonNull List<@NonNull CompleteClass> getAncestors(@NonNull CompleteClass baseCompleteClass, @NonNull CompleteClass derivedCompleteClass) {
		List<@NonNull CompleteClass> ancestors = new ArrayList<>();
//		CompleteClass baseCompleteClass = getCompleteClass(QVTimperativeUtil.getOwningClass(property));
		CompleteInheritance baseInheritance = baseCompleteClass.getCompleteInheritance();
		CompleteInheritance derivedInheritance = derivedCompleteClass.getCompleteInheritance();
		int baseDepth = baseInheritance.getDepth();
		int derivedDepth = derivedInheritance.getDepth();
		for (int i = baseDepth; i <= derivedDepth; i++) {
			Iterable<@NonNull InheritanceFragment> derivedSuperFragments = derivedInheritance.getSuperFragments(i);
			for (@NonNull InheritanceFragment superFragment : derivedSuperFragments) {
				Iterable<@NonNull InheritanceFragment> owningSuperFragments = superFragment.getDerivedInheritance().getSuperFragments(baseDepth);
				for (@NonNull InheritanceFragment owningSuperFragment : owningSuperFragments) {
					if (owningSuperFragment.getBaseInheritance() == baseInheritance) {
						CompleteClass superClass = ((CompleteInheritanceImpl)superFragment.getBaseInheritance()).getCompleteClass();
						ancestors.add(superClass);
					}
				}
			}
		}
		return ancestors;
	} */

	protected @NonNull CompleteClass getCompleteClass(@NonNull Type type) {
		return completeModel.getCompleteClass(type);
	}

	protected @NonNull CompleteClass getCompleteClass(@NonNull TypedElement typedElement) {
		return getCompleteClass(QVTimperativeUtil.getType(typedElement));
	}

	public void validate() {
		List<@NonNull BasePropertyAnalysis> sortedBasePropertyAnalyses = new ArrayList<>(property2basePropertyAnalysis.values());
		Collections.sort(sortedBasePropertyAnalyses, NameUtil.NAMEABLE_COMPARATOR);
		StringBuilder s = SUMMARY.isActive() ? new StringBuilder() : null;
		for (@NonNull BasePropertyAnalysis basePropertyAnalysis : sortedBasePropertyAnalyses) {
			basePropertyAnalysis.validate(s);
		}
		if (s != null) {
			SUMMARY.println(s.toString());
		}
	}

	@Override
	public @Nullable Object visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException("Unimplemented " + getClass().getName() + " for " + visitable.eClass().getName());
	}

	@Override
	public @Nullable Object visitElement(@NonNull Element object) {
		return null;
	}

	@Override
	public @Nullable Object visitGuardParameter(@NonNull GuardParameter guardParameter) {
		Property successProperty = guardParameter.getSuccessProperty();
		if (successProperty != null) {
			CompleteClass sourceClass = getCompleteClass(QVTimperativeUtil.getOwningClass(successProperty));
			CompleteClass targetClass = getCompleteClass(successProperty);
			BasePropertyAnalysis basePropertyAnalysis = getBasePropertyAnalysis(successProperty);
			basePropertyAnalysis.addProducer(guardParameter, sourceClass, successProperty, targetClass);
		}
		return null;
	}

	@Override
	public @Nullable Object visitNavigationCallExp(@NonNull NavigationCallExp navigationCallExp) {
		@SuppressWarnings("unused") String name = navigationCallExp.getName();
		Mapping mapping = QVTimperativeUtil.basicGetContainingMapping(navigationCallExp);
		if (mapping != null) {
			OCLExpression ownedSource = QVTimperativeUtil.getOwnedSource(navigationCallExp);
			DomainUsage usage = domainUsageAnalysis.getUsage(ownedSource);
			if (!usage.isInput() && !usage.isPrimitive()) {		// Skip endogenously confusing input
				Property getProperty = QVTimperativeUtil.getReferredProperty(navigationCallExp);
				BasePropertyAnalysis basePropertyAnalysis = getBasePropertyAnalysis(getProperty);
				CompleteClass sourceClass = getCompleteClass(ownedSource);
				CompleteClass targetClass = getCompleteClass(navigationCallExp);
				basePropertyAnalysis.addConsumer(navigationCallExp, sourceClass, getProperty, targetClass);
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitNewStatement(@NonNull NewStatement newStatement) {
		//	org.eclipse.ocl.pivot.Class newClass = (Class) QVTimperativeUtil.getType(newStatement);
		//	List<@NonNull NamedElement> producers = class2producers.get(newClass);
		//	if (producers == null) {
		//		producers = new ArrayList<>();
		//		class2producers.put(newClass, producers);
		//	}
		//	producers.add(newStatement);
		return null;
	}

	@Override
	public @Nullable Object visitSetStatement(@NonNull SetStatement setStatement) {
		Property setProperty = QVTimperativeUtil.getTargetProperty(setStatement);
		String name = setProperty.getName();
		if (name.equals("fromAttributes")) {
			getClass();
		}
		else if (name.equals("owner")) {
			getClass();
		}
		BasePropertyAnalysis basePropertyAnalysis = getBasePropertyAnalysis(setProperty);
		CompleteClass sourceClass = getCompleteClass(QVTimperativeUtil.getTargetVariable(setStatement));
		CompleteClass targetClass = getCompleteClass(QVTimperativeUtil.getOwnedExpression(setStatement));
		basePropertyAnalysis.addProducer(setStatement, sourceClass, setProperty, targetClass);
		//	Property oppositeProperty = setProperty.getOpposite();
		//	if (oppositeProperty != null) {
		//		basePropertyAnalysis.addProducer(setStatement, targetClass, oppositeProperty, sourceClass);
		//	}
		return null;
	}

	@Override
	public @Nullable Object visitTransformation(@NonNull Transformation transformation) {
		domainUsageAnalysis.analyzeTransformation(transformation);
		return null;
	}

}
