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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.CompilerStep;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.MappingProblem;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphElement;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToGraphHelper;
import org.eclipse.qvtd.pivot.qvtbase.utilities.StandardLibraryHelper;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractExtendingQVTimperativeVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.Graphable;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.ToGraphVisitor2;

/**
 * QVTiProductionConsumption supports a design rule check on the QVTi model to verify that consumed edges are produced and that notify/observe annotations ensure
 * that not-necessarily-ready consumptions wait for their corresponding productions.
 */
public class QVTiProductionConsumption extends AbstractExtendingQVTimperativeVisitor<@Nullable Object, @NonNull Resource> implements Graphable
{
	public static final @NonNull TracingOption SUMMARY = new TracingOption(CompilerConstants.PLUGIN_ID, "qvti/check/summary");

	protected static final class DirectedEdge implements GraphEdge
	{
		private final @NonNull GraphNode targetNode;
		private final @NonNull GraphNode sourceNode;

		protected DirectedEdge(@NonNull GraphNode sourceNode, @NonNull GraphNode targetNode) {
			this.sourceNode = sourceNode;
			this.targetNode = targetNode;
		}

		@Override
		public void appendEdgeAttributes(@NonNull ToGraphHelper toGraphHelper, @NonNull String sourceName, @NonNull String targetName) {
			GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
			s.setColor("orange");
			//	String style = getStyle();
			//	if (style != null) {
			//		s.setStyle(style);
			//	}
			//	String arrowhead = getArrowhead();
			//	if (arrowhead != null) {
			//		s.setArrowhead(arrowhead);
			//	}
			s.setPenwidth(2);
			s.appendAttributedEdge(sourceName, this, targetName);
		}

		@Override
		public @NonNull String getColor() {
			return "red";
		}

		@Override
		public @NonNull GraphNode getEdgeSource() {
			return sourceNode;
		}

		@Override
		public @NonNull GraphNode getEdgeTarget() {
			return targetNode;
		}
	}

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
			this.first = Integer.MAX_VALUE;
			this.last = Integer.MIN_VALUE;
		}

		public PassRange(int first, int last) {
			this.first = first;
			this.last = last;
			assert first <= last;
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
	private class BasePropertyAnalysis implements Nameable, GraphNode
	{
		/**
		 * The base/normalized/primary property for the edge production/consumption.
		 */
		protected final @NonNull Property baseProperty;

		/**
		 * Name of the base/normalized/primary property.
		 */
		protected final @NonNull String baseName;

		/**
		 * Name of the base/normalized/primary property and its opposite.
		 */
		protected final @NonNull String name;

		/**
		 * The various accesses that conform to the baseProperty.
		 */
		protected final @NonNull Map<@NonNull CompleteClass, @NonNull Map<@NonNull CompleteClass, @NonNull AccessAnalysis>> sourceClass2targetClass2accessAnalysis = new HashMap<>();

		/**
		 * The 'connection' that produces each consumed access.
		 * A BasePropertyAnalysis 'references' a ConnectionAnalysis.
		 */
		protected final @NonNull Map<@NonNull AccessAnalysis, @Nullable ConnectionAnalysis> consumingAnalysis2connectionAnalysis = new HashMap<>();

		/**
		 * The 'connection's that consume each produced access.
		 * A BasePropertyAnalysis 'references' many ConnectionAnalysis.
		 */
		protected final @NonNull Map<@NonNull AccessAnalysis, @Nullable List<@NonNull ConnectionAnalysis>> producingAnalysis2connectionAnalyses = new HashMap<>();

		/**
		 * The 'connection' that aggregates a set of productions that conform to a consumption.
		 * A BasePropertyAnalysis 'composes' a ConnectionAnalysis.
		 */
		protected final @NonNull Map<@NonNull Set<@NonNull AccessAnalysis>, @NonNull ConnectionAnalysis> producingAnalyses2connectionAnalysis = new HashMap<>();

		public BasePropertyAnalysis(@NonNull Property baseProperty) {
			this.baseProperty = baseProperty;
			StringBuilder s = new StringBuilder();
			s.append(baseProperty.getOwningClass().getName());
			s.append("::");
			s.append(baseProperty.getName());
			if (baseProperty.isIsMany()) {
				s.append(/*baseProperty.isIsRequired() ? "[+]" :*/ "[*]");
			}
			else {
				s.append(baseProperty.isIsRequired() ? "[1]" : "[?]");
			}
			this.baseName = s.toString();
			Property oppositeProperty = baseProperty.getOpposite();
			if (oppositeProperty != null) {
				s.append(" <=> ");
				s.append(oppositeProperty.getOwningClass().getName());
				s.append("::");
				s.append(oppositeProperty.getName());
				if (baseProperty.isIsMany()) {
					s.append(/*oppositeProperty.isIsRequired() ? "[+]" :*/ "[*]");
				}
				else {
					s.append(oppositeProperty.isIsRequired() ? "[1]" : "[?]");
				}
			}
			this.name = s.toString();
			assert baseProperty == QVTscheduleUtil.getPrimaryProperty(baseProperty);
		}

		/**
		 * Add all the accesses of basePropertyAnalysis to this BasePropertyAnalysis. This is used to create the
		 * pseudo-Property oclContainer from the actual containment properties.
		 */
		public void accumulate(@NonNull BasePropertyAnalysis basePropertyAnalysis) {
			for (@NonNull AccessAnalysis producingAnalysis : basePropertyAnalysis.producingAnalysis2connectionAnalyses.keySet()) {
				for (@NonNull NamedElement producer : producingAnalysis.producers) {
					addProducer(producer, producingAnalysis.sourceClass, producingAnalysis.property, producingAnalysis.targetClass);
				}
			}
			for (@NonNull AccessAnalysis consumingAnalysis : basePropertyAnalysis.consumingAnalysis2connectionAnalysis.keySet()) {
				for (@NonNull NavigationCallExp consumer : consumingAnalysis.consumers) {
					addConsumer(consumer, consumingAnalysis.sourceClass, consumingAnalysis.property, consumingAnalysis.targetClass);
				}
			}
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
			AccessAnalysis accessAnalysis = targetClass2accessAnalysis.get(targetClass);
			if (accessAnalysis == null) {
				accessAnalysis = new AccessAnalysis(this, sourceClass, property, targetClass);
				targetClass2accessAnalysis.put(targetClass, accessAnalysis);
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
			Mapping mapping = QVTimperativeUtil.getContainingMapping(element);
			s.append(mapping.getName());
			s.append(" ");
			s.append(PassRange.create(mapping));
			s.append(" ");
			s.append(element);
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
			if (s != null) {
				s.append("\n  " + name);
				for (@NonNull AccessAnalysis producingAnalysis : producingAnalysis2connectionAnalyses.keySet()) {
					List<@NonNull ConnectionAnalysis> connectionAnalyses = producingAnalysis2connectionAnalyses.get(producingAnalysis);
					if (connectionAnalyses == null) {
						for (@NonNull NamedElement producer : producingAnalysis.producers) {
							Mapping mapping = QVTimperativeUtil.getContainingMapping(producer);
							s.append("\n    unconnected " + mapping.getName() + " " + PassRange.create(mapping) + " " + producer);
						}
					}
				}
				for (@NonNull ConnectionAnalysis connectionAnalysis : producingAnalyses2connectionAnalysis.values()) {
					boolean needsNotify = connectionAnalysis.needsNotify();
					s.append("\n    connect produce " + connectionAnalysis.productionPassRange + " consume " + connectionAnalysis.consumptionPassRange + (needsNotify ? " needsNotify" : " not-needsNotify"));
					for (@NonNull AccessAnalysis producingAnalysis : connectionAnalysis.producingAnalyses) {
						boolean needsNotify2 = false;
						List<@NonNull ConnectionAnalysis> connectionAnalyses2 = producingAnalysis2connectionAnalyses.get(producingAnalysis);
						assert connectionAnalyses2 != null;
						for (@NonNull ConnectionAnalysis connectionAnalysis2 : connectionAnalyses2) {
							if (connectionAnalysis2.needsNotify()) {
								needsNotify2 = true;
							}
						}
						s.append("\n      produce " + producingAnalysis.name + " " + producingAnalysis.getProductionPassRange() + (needsNotify2 ? " needsNotify" : " not-needsNotify"));
						for (@NonNull NamedElement producer : producingAnalysis.producers) {
							Mapping mapping = QVTimperativeUtil.getContainingMapping(producer);
							s.append("\n        in " + mapping.getName() + " " + PassRange.create(mapping) + " " + producer);
						}
					}
					for (@NonNull AccessAnalysis consumingAnalysis : connectionAnalysis.consumingAnalyses) {
						boolean needsObserve = !connectionAnalysis.getProductionPassRange().precedes(consumingAnalysis.getConsumptionPassRange());
						s.append("\n      consume " + consumingAnalysis.name + " " + consumingAnalysis.getConsumptionPassRange() + (needsObserve ? " needsObserve" : " not-needsObserve"));
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
					if (!(producer instanceof GuardParameter)) {			// GuardParameter are implicitly notified; no need to check
						boolean isNotify = isNotify(producer);
						if (isNotify != needsNotify) {
							StringBuilder sProblem = initProblem("", producer, isNotify ? " should not be notified" : " should be notified");
							Mapping mapping = QVTimperativeUtil.getContainingMapping(producer);
							compilerStep.addProblem(new MappingProblem(CompilerProblem.Severity.WARNING, mapping, sProblem.toString()));
							if (s != null) {
								s.append("\n      BAD " + sProblem);
							}
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
					OCLExpression ownedSource = PivotUtil.getOwnedSource(consumer);
					DomainUsage sourceUsage = domainUsageAnalysis.getUsage(ownedSource);
					if (!sourceUsage.isThis()) {
						StringBuilder sProblem = initProblem("", consumer, " is not produced");
						Mapping mapping = QVTimperativeUtil.getContainingMapping(consumer);
						compilerStep.addProblem(new MappingProblem(CompilerProblem.Severity.WARNING, mapping, sProblem.toString()));
						if (s != null) {
							s.append("\n      BAD " + sProblem);
						}
					}
				}
				else {
					PassRange consumerPassRange = PassRange.create(consumer);
					boolean needsObserve = !productionRange.precedes(consumerPassRange);
					boolean isObserve = isObserve(consumer);
					if (isObserve != needsObserve) {
						StringBuilder sProblem = initProblem("", consumer, isObserve ? " should not be observed" : " should be observed");
						Mapping mapping = QVTimperativeUtil.getContainingMapping(consumer);
						compilerStep.addProblem(new MappingProblem(CompilerProblem.Severity.WARNING, mapping, sProblem.toString()));
						if (s != null) {
							s.append("\n      BAD " + sProblem);
						}
					}
				}
			}
		}

		@Override
		public @NonNull String getColor() {
			return "blue";
		}

		@Override
		public void appendNode(@NonNull ToGraphHelper toGraphHelper, @NonNull String nodeName) {
			/*	GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
			s.setLabel(getName());
			s.setShape("rectangle");
			s.setStyle("solid");
			s.setColor("blue");
			s.setPenwidth(1);
			s.appendAttributedNode(nodeName); */
		}
	}

	private class MappingNode implements Nameable, GraphNode
	{
		protected final @NonNull Mapping mapping;

		protected MappingNode(@NonNull Mapping mapping) {
			this.mapping = mapping;
		}

		@Override
		public @NonNull String getColor() {
			return "brown";
		}

		@Override
		public void appendNode(@NonNull ToGraphHelper toGraphHelper, @NonNull String nodeName) {
			GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
			String name = getName();
			if (name.startsWith(QVTscheduleConstants.REGION_SYMBOL_NAME_PREFIX)) {
				name = name.substring(QVTscheduleConstants.REGION_SYMBOL_NAME_PREFIX.length());
			}
			s.setLabel(getName() + "\n" + PassRange.create(mapping));
			s.setShape("rectangle");
			s.setStyle("solid");
			s.setColor("brown");
			s.setPenwidth(2);
			s.appendAttributedNode(nodeName);
		}

		@Override
		public String getName() {
			return mapping.getName();
		}

	}

	/**
	 * AccessAnalysis aggregates the producer/consumer analysis of a source-CompleteClass via property to target-CompleteClass slot value.
	 * Distinct accesses are kept separate. RElated accesses such as opposites and deriveds are aggregated by a BasePropertyAnalysis.
	 */
	private class AccessAnalysis implements Nameable, GraphNode
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
			s.append(property.getType().getName());
			Property opposite = property.getOpposite();
			if (opposite != null) {
				s.append("\n");
				s.append(targetClass.getName());
				s.append("::");
				s.append(opposite.getName());
				s.append(" : ");
				s.append(opposite.getType().getName());
			}
			this.name = s.toString();
		}

		public void addConsumer(@NonNull NavigationCallExp consumer) {
			assert consumptionPassRange == null;
			consumers.add(consumer);
		}

		public void addProducer(@NonNull NamedElement producer) {
			assert productionPassRange == null;
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

		@Override
		public @NonNull String toString() {
			return name;
		}

		@Override
		public @NonNull String getColor() {
			return "blue";
		}

		@Override
		public void appendNode(@NonNull ToGraphHelper toGraphHelper, @NonNull String nodeName) {
			GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
			s.setLabel(getName() + "\n" + getProductionPassRange() /* + " => " + getConsumptionPassRange()*/);
			s.setShape("rectangle");
			s.setStyle(property.getType() instanceof DataType ? "rounded" : "solid");
			s.setColor("green");
			s.setPenwidth(2);
			s.appendAttributedNode(nodeName);
		}
	}

	/**
	 * ConnectionAnalysis matches the conforming production and consumption analyses that correspond to a connection.
	 */
	private class ConnectionAnalysis implements Nameable, GraphNode
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

		@Override
		public @NonNull String getColor() {
			// TODO Auto-generated method stub
			return "orange";
		}

		@Override
		public void appendNode(@NonNull ToGraphHelper toGraphHelper, @NonNull String nodeName) {
			GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
			s.setLabel(basePropertyAnalysis.baseName + "\n" + /*productionPassRange + " => " +*/ consumptionPassRange);
			s.setShape("ellipse");
			s.setStyle("solid");
			s.setColor("cyan");
			s.setPenwidth(2);
			s.appendAttributedNode(nodeName);
		}

		@Override
		public String getName() {
			return basePropertyAnalysis.getName();
		}
	}

	protected class ToGraph implements ToGraphHelper
	{
		protected final @NonNull GraphStringBuilder context;

		protected ToGraph(@NonNull GraphStringBuilder context) {
			this.context = context;
		}

		@Override
		public @NonNull GraphStringBuilder getGraphStringBuilder() {
			return context;
		}

		protected @NonNull String getLabel(@NonNull GraphNode graphNode) {
			String label = "";
			if (graphNode instanceof BasePropertyAnalysis) {
				BasePropertyAnalysis node = (BasePropertyAnalysis)graphNode;
				label = node.getName();
			}
			return label;
		}

		@Override
		public void setColor(@NonNull GraphElement element) {
			// TODO Auto-generated method stub

		}

		@Override
		public void setHead(@NonNull GraphNode node) {
			// TODO Auto-generated method stub

		}

		@Override
		public void setLabel(@NonNull GraphNode node) {
			String label = getLabel(node);
			context.setLabel(label);
		}

		@Override
		public void setPenwidth(@NonNull GraphNode node) {
			// TODO Auto-generated method stub

		}

		@Override
		public void setShapeAndStyle(@NonNull GraphNode node) {
			// TODO Auto-generated method stub

		}

	}

	protected final @NonNull EnvironmentFactory environmentFactory;
	protected final @NonNull CompilerStep compilerStep;
	protected final @NonNull String name;
	protected final @NonNull QVTimperativeDomainUsageAnalysis domainUsageAnalysis;
	protected final @NonNull Map<@NonNull Property, @NonNull BasePropertyAnalysis> property2basePropertyAnalysis = new HashMap<>();
	protected final @NonNull CompleteModel completeModel;
	protected final @NonNull Iterable<@NonNull Mapping> mappings;
	protected final @NonNull DomainUsage inputUsage;
	protected final @NonNull DomainUsage outputUsage;

	public QVTiProductionConsumption(@NonNull CompilerStep compilerStep, @NonNull QVTimperativeDomainUsageAnalysis domainUsageAnalysis, @NonNull EntryPoint iEntryPoint) throws IOException {
		super(ClassUtil.nonNullState(iEntryPoint.eResource()));
		this.environmentFactory = compilerStep.getEnvironmentFactory();
		this.compilerStep = compilerStep;
		this.name = PivotUtil.getName(iEntryPoint);
		this.domainUsageAnalysis = domainUsageAnalysis;
		this.completeModel = environmentFactory.getCompleteModel();
		this.mappings = QVTimperativeUtil.computeMappingClosure(iEntryPoint);
		DomainUsage inputUsage = domainUsageAnalysis.getNoneUsage();
		for (@NonNull TypedModel inputTypedModel : QVTimperativeUtil.getInputTypedModels(iEntryPoint)) {
			inputUsage = domainUsageAnalysis.union(inputUsage, domainUsageAnalysis.getUsage(inputTypedModel));
		}
		this.inputUsage = inputUsage;
		DomainUsage outputUsage = domainUsageAnalysis.getNoneUsage();
		for (@NonNull TypedModel outputTypedModel : QVTimperativeUtil.getOutputTypedModels(iEntryPoint)) {
			outputUsage = domainUsageAnalysis.union(outputUsage, domainUsageAnalysis.getUsage(outputTypedModel));
		}
		this.outputUsage = outputUsage;
	}

	@Override
	public void acceptGraphVisitor(@NonNull ToGraphVisitor2 toGraphVisitor) {
		GraphStringBuilder context = toGraphVisitor.getContext();
		ToGraph toGraph = new ToGraph(context);
		context.setLabel(getGraphName());
		context.setColor("black");
		context.pushCluster();
		Map<@NonNull Mapping, @NonNull MappingNode> mapping2mappingNode = new HashMap<>();
		for (@NonNull BasePropertyAnalysis basePropertyAnalysis : property2basePropertyAnalysis.values()) {
			context.setLabel(basePropertyAnalysis.baseName);
			Collection<@NonNull Map<@NonNull CompleteClass, @NonNull AccessAnalysis>> values = basePropertyAnalysis.sourceClass2targetClass2accessAnalysis.values();
			//	if (values.size() > 1) {
			context.setColor("blue");
			context.setStyle(basePropertyAnalysis.baseProperty.getType() instanceof DataType ? "rounded" : "solid");
			context.setPenwidth(2);
			context.pushCluster();
			//	}
			for (@NonNull ConnectionAnalysis connectionAnalysis : basePropertyAnalysis.producingAnalyses2connectionAnalysis.values()) {
				context.appendNode(toGraph, connectionAnalysis);
			}
			for (@NonNull Map<@NonNull CompleteClass, @NonNull AccessAnalysis> targetClass2accessAnalysis : values) {
				for (@NonNull AccessAnalysis accessAnalysis : targetClass2accessAnalysis.values()) {
					context.appendNode(toGraph, accessAnalysis);
				}
			}
			//	if (values.size() > 1) {
			context.popCluster();
			//	}
			for (@NonNull ConnectionAnalysis connectionAnalysis : basePropertyAnalysis.producingAnalyses2connectionAnalysis.values()) {
				for (@NonNull AccessAnalysis accessAnalysis : connectionAnalysis.consumingAnalyses) {
					for (@NonNull NamedElement consumer : accessAnalysis.consumers) {
						MappingNode mappingNode = getMappingNode(mapping2mappingNode, consumer);
						context.appendEdge(toGraph, connectionAnalysis, new DirectedEdge(connectionAnalysis, mappingNode), mappingNode);
					}
				}
				for (@NonNull AccessAnalysis accessAnalysis : connectionAnalysis.producingAnalyses) {
					context.appendEdge(toGraph, accessAnalysis, new DirectedEdge(accessAnalysis, connectionAnalysis), connectionAnalysis);
				}
			}
			for (@NonNull Map<@NonNull CompleteClass, @NonNull AccessAnalysis> targetClass2accessAnalysis : values) {
				for (@NonNull AccessAnalysis accessAnalysis : targetClass2accessAnalysis.values()) {
					for (@NonNull NamedElement producer : accessAnalysis.producers) {
						MappingNode mappingNode = getMappingNode(mapping2mappingNode, producer);
						context.appendEdge(toGraph, mappingNode, new DirectedEdge(mappingNode, accessAnalysis), accessAnalysis);
					}
					//	for (@NonNull NamedElement consumer : accessAnalysis.consumers) {
					//		MappingNode mappingNode = getMappingNode(mapping2mappingNode, consumer);
					//		context.appendEdge(toGraph, accessAnalysis, new DirectedEdge(accessAnalysis, mappingNode), mappingNode);
					//	}
				}
			}
			/*		for (List<@NonNull ConnectionAnalysis> connectionAnalyses : basePropertyAnalysis.producingAnalysis2connectionAnalyses.values()) {
				if (connectionAnalyses != null) {
					for (@NonNull ConnectionAnalysis connectionAnalysis : connectionAnalyses) {
						context.appendNode(toGraph, connectionAnalysis);
						for (@NonNull AccessAnalysis accessAnalysis : connectionAnalysis.producingAnalyses) {
							//appingNode mappingNode = getMappingNode(mapping2mappingNode, producer);
							context.appendEdge(toGraph, connectionAnalysis, new DirectedEdge(connectionAnalysis, accessAnalysis), accessAnalysis);
						}
						for (@NonNull AccessAnalysis accessAnalysis : connectionAnalysis.consumingAnalyses) {
							//appingNode mappingNode = getMappingNode(mapping2mappingNode, consumer);
							context.appendEdge(toGraph, accessAnalysis, new DirectedEdge(accessAnalysis, connectionAnalysis), connectionAnalysis);
						}
					}
				}
			} */
		}
		/*	for (@NonNull Mapping mapping : mappings) {
		//	context.setLabel(mapping.name);
		//	context.pushCluster();
			String nodeId = context.appendNode(toGraph, mapping);
			//	node2id.put(basePropertyAnalysis, nodeId);
		//	for (@NonNull Map<@NonNull CompleteClass, @NonNull AccessAnalysis> targetClass2accessAnalysis : basePropertyAnalysis.sourceClass2targetClass2accessAnalysis.values()) {
		//		for (@NonNull AccessAnalysis accessAnalysis : targetClass2accessAnalysis.values()) {
		//			String accessAnalysisId = context.appendNode(toGraph, accessAnalysis);
		//			//			node2id.put(accessAnalysis, accessAnalysisId);
		//		}
		//	}
			context.popCluster();
		} */

		context.popCluster();
	}

	protected @NonNull MappingNode getMappingNode(@NonNull Map<@NonNull Mapping, @NonNull MappingNode> mapping2mappingNode, @NonNull NamedElement element) {
		Mapping mapping = QVTimperativeUtil.getContainingMapping(element);
		assert mapping != null;
		MappingNode mappingNode = mapping2mappingNode.get(mapping);
		if (mappingNode == null) {
			mappingNode = new MappingNode(mapping);
			mapping2mappingNode.put(mapping, mappingNode);
		}
		return mappingNode;
	}

	public void analyze() {
		//
		//	Traverse the model to discover all producers and consumers with a corresponding AccessAnalysis supervised by a BasePropertyAnalysis.
		//
		for (@NonNull Mapping mapping : mappings) {
			for (@NonNull EObject eObject : new TreeIterable(mapping, true)) {
				if (eObject instanceof Visitable) {
					((Visitable)eObject).accept(this);
				}
			}
		}
		//
		//	Add the oclContainer pseudo-property if used.
		//
		StandardLibraryHelper standardLibraryHelper = new StandardLibraryHelper(environmentFactory.getStandardLibrary());
		Property oclContainerProperty = standardLibraryHelper.getOclContainerProperty();
		BasePropertyAnalysis oclContainerPropertyAnalysis = property2basePropertyAnalysis.get(oclContainerProperty);
		if (oclContainerPropertyAnalysis != null) {
			for (@NonNull BasePropertyAnalysis basePropertyAnalysis : property2basePropertyAnalysis.values()) {
				if (basePropertyAnalysis != oclContainerPropertyAnalysis) {
					Property baseOppositeProperty = basePropertyAnalysis.baseProperty.getOpposite();
					if ((baseOppositeProperty != null) && baseOppositeProperty.isIsComposite()) {
						oclContainerPropertyAnalysis.accumulate(basePropertyAnalysis);
					}
				}
			}
		}
		//
		//	Build the CommunicationAnalysis instances for each BasePropertyAnalysis.
		//
		for (@NonNull BasePropertyAnalysis basePropertyAnalysis : property2basePropertyAnalysis.values()) {
			basePropertyAnalysis.analyze();
		}
	}

	protected BasePropertyAnalysis getBasePropertyAnalysis(@NonNull Property property) {
		Property baseProperty = QVTscheduleUtil.getPrimaryProperty(property);
		BasePropertyAnalysis basePropertyAnalysis = property2basePropertyAnalysis.get(baseProperty);
		if (basePropertyAnalysis == null) {
			basePropertyAnalysis = new BasePropertyAnalysis(baseProperty);
			property2basePropertyAnalysis.put(baseProperty, basePropertyAnalysis);
		}
		return basePropertyAnalysis;
	}

	protected @NonNull CompleteClass getCompleteClass(@NonNull Type type) {
		return completeModel.getCompleteClass(type);
	}

	protected @NonNull CompleteClass getCompleteClass(@NonNull TypedElement typedElement) {
		return getCompleteClass(QVTimperativeUtil.getType(typedElement));
	}

	@Override
	public @NonNull String getGraphName() {
		return name;
	}

	protected boolean isInput(@NonNull DomainUsage usage) {
		return (inputUsage.getMask() & usage.getMask()) != 0;
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
		Mapping mapping = QVTimperativeUtil.basicGetContainingMapping(navigationCallExp);
		if (mapping != null) {
			OCLExpression ownedSource = QVTimperativeUtil.getOwnedSource(navigationCallExp);
			DomainUsage usage = domainUsageAnalysis.getUsage(navigationCallExp instanceof OppositePropertyCallExp ? navigationCallExp : ownedSource);
			if (!isInput(usage) && !usage.isPrimitive()) {		// Skip endogenously confusing input
				Property getProperty = QVTimperativeUtil.getReferredProperty(navigationCallExp);
				BasePropertyAnalysis basePropertyAnalysis = getBasePropertyAnalysis(getProperty);
				CompleteClass sourceClass = getCompleteClass(ownedSource);
				CompleteClass targetClass;
				EObject eContainer = navigationCallExp.eContainer();
				if (eContainer instanceof DeclareStatement) {
					targetClass = getCompleteClass(QVTimperativeUtil.getType((DeclareStatement)eContainer));
				}
				else {
					targetClass = getCompleteClass(navigationCallExp);
				}
				if (getProperty.isIsMany()) {
					CollectionType collectionType = (CollectionType)targetClass.getPrimaryClass();
					targetClass = getCompleteClass(PivotUtil.getElementType(collectionType));
				}
				basePropertyAnalysis.addConsumer(navigationCallExp, sourceClass, getProperty, targetClass);
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitNewStatement(@NonNull NewStatement newStatement) {
		return null;
	}

	@Override
	public @Nullable Object visitNewStatementPart(@NonNull NewStatementPart newStatementPart) {
		NewStatement newStatement = QVTimperativeUtil.getOwningNewStatement(newStatementPart);
		Property setProperty = QVTimperativeUtil.getReferredProperty(newStatementPart);
		BasePropertyAnalysis basePropertyAnalysis = getBasePropertyAnalysis(setProperty);
		CompleteClass sourceClass = getCompleteClass(QVTimperativeUtil.getType(newStatement));
		CompleteClass targetClass = getCompleteClass(QVTimperativeUtil.getOwnedExpression(newStatementPart));
		//		if (!newStatementPart.isIsPartial() && setProperty.isIsMany()) {
		//			CollectionType collectionType = (CollectionType)targetClass.getPrimaryClass();
		//			targetClass = getCompleteClass(PivotUtil.getElementType(collectionType));
		//		}
		basePropertyAnalysis.addProducer(newStatementPart, sourceClass, setProperty, targetClass);
		return null;
	}

	@Override
	public @Nullable Object visitSetStatement(@NonNull SetStatement setStatement) {
		Property setProperty = QVTimperativeUtil.getTargetProperty(setStatement);
		BasePropertyAnalysis basePropertyAnalysis = getBasePropertyAnalysis(setProperty);
		CompleteClass sourceClass = getCompleteClass(QVTimperativeUtil.getTargetVariable(setStatement));
		CompleteClass targetClass = getCompleteClass(QVTimperativeUtil.getOwnedExpression(setStatement));
		if (!setStatement.isIsPartial() && setProperty.isIsMany()) {
			CollectionType collectionType = (CollectionType)targetClass.getPrimaryClass();
			targetClass = getCompleteClass(PivotUtil.getElementType(collectionType));
		}
		basePropertyAnalysis.addProducer(setStatement, sourceClass, setProperty, targetClass);
		return null;
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		// TODO Auto-generated method stub

	}

	//	@Override
	//	public @Nullable Object visitTransformation(@NonNull Transformation transformation) {
	//		domainUsageAnalysis.analyzeTransformation();
	//		return null;
	//	}
}
