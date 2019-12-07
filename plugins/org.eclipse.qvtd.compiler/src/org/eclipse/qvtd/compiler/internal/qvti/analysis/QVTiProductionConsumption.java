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
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.ToGraphVisitor2;

/**
 * QVTiProductionConsumption supports a design rule check on the QVTi model to verify that consumed edges are produced and that notify/observe annotations ensure
 * that not-necessarily-ready consumptions wait for their corresponding productions.
 */
public class QVTiProductionConsumption extends AbstractExtendingQVTimperativeVisitor<@Nullable Object, @NonNull Resource> implements Graphable
{
	public static final @NonNull TracingOption SUMMARY = new TracingOption(CompilerConstants.PLUGIN_ID, "qvti/check/summary");

	private abstract static class AbstractGraphEdge implements GraphEdge
	{
		@Override
		public @NonNull String getColor() {
			throw new UnsupportedOperationException();
		}

		@Override
		public @NonNull GraphNode getEdgeSource() {
			throw new UnsupportedOperationException();
		}

		@Override
		public @NonNull GraphNode getEdgeTarget() {
			throw new UnsupportedOperationException();
		}
	}

	private abstract static class AbstractGraphNode implements GraphNode
	{
		@Override
		public @NonNull String getColor() {
			throw new UnsupportedOperationException();
		}
	}

	protected static class ConsumptionEdge extends AbstractGraphEdge
	{
		private final boolean isObserve;

		protected ConsumptionEdge(boolean isObserve) {
			this.isObserve = isObserve;
		}

		@Override
		public void appendEdgeAttributes(@NonNull ToGraphHelper toGraphHelper, @NonNull String sourceName, @NonNull String targetName) {
			GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
			s.setColor(isObserve ? "brown" : "orange");
			s.setPenwidth(isObserve ? 2 : 1);
			s.appendAttributedEdge(sourceName, this, targetName);
		}
	}

	protected static class ProductionEdge extends AbstractGraphEdge
	{
		private final boolean isNotify;

		protected ProductionEdge(boolean isNotify) {
			this.isNotify = isNotify;
		}

		@Override
		public void appendEdgeAttributes(@NonNull ToGraphHelper toGraphHelper, @NonNull String sourceName, @NonNull String targetName) {
			GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
			s.setColor(isNotify ? "brown" : "orange");
			s.setPenwidth(isNotify ? 2 : 1);
			s.appendAttributedEdge(sourceName, this, targetName);
		}
	}

	protected static class ConnectionEdge extends AbstractGraphEdge
	{
		protected ConnectionEdge() {}

		@Override
		public void appendEdgeAttributes(@NonNull ToGraphHelper toGraphHelper, @NonNull String sourceName, @NonNull String targetName) {
			GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
			s.setColor("cyan");
			s.setPenwidth(1);
			s.appendAttributedEdge(sourceName, this, targetName);
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

		//	public boolean isDefined() {
		//		return this.first <= this.last;
		//	}

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
		/**
		 * The base/normalized/primary property for the edge production/consumption.
		 */
		protected final @NonNull Property baseProperty;

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

		private void appendComplexPropertyAnalysis(@NonNull ToGraph toGraph, @NonNull Map<@NonNull Mapping, @NonNull MappingNode> mapping2mappingNode) {
			Map<@NonNull ConnectionAnalysis, @NonNull ConnectionAnalysisNode> connectionAnalysis2connectionAnalysisNode = new HashMap<>();
			Map<@NonNull AccessAnalysis, @NonNull AccessAnalysisNode> consumingAnalysis2accessAnalysisNode = new HashMap<>();
			Map<@NonNull AccessAnalysis, @NonNull AccessAnalysisNode> producingAnalysis2accessAnalysisNode = new HashMap<>();
			StringBuilder sLabel = new StringBuilder();
			sLabel.append(baseProperty.getOwningClass().getName());
			sLabel.append("::");
			sLabel.append(baseProperty.getName());
			String label = sLabel.toString();
			GraphStringBuilder context = toGraph.context;
			context.setLabel(label);
			context.setColor("blue");
			context.setStyle(baseProperty.getType() instanceof DataType ? "rounded" : "solid");
			context.setPenwidth(2);
			context.pushCluster();
			for (@NonNull ConnectionAnalysis connectionAnalysis : producingAnalyses2connectionAnalysis.values()) {
				getConnectionAnalysisNode(toGraph, connectionAnalysis, connectionAnalysis2connectionAnalysisNode);
			}
			for (@NonNull AccessAnalysis producingAnalysis : producingAnalysis2connectionAnalyses.keySet()) {
				getAccessAnalysisNode(toGraph, producingAnalysis, producingAnalysis2accessAnalysisNode, false);
			}
			for (@NonNull AccessAnalysis consumingAnalysis : consumingAnalysis2connectionAnalysis.keySet()) {
				getAccessAnalysisNode(toGraph, consumingAnalysis, consumingAnalysis2accessAnalysisNode, true);
			}
			context.popCluster();

			for (@NonNull ConnectionAnalysis connectionAnalysis : connectionAnalysis2connectionAnalysisNode.keySet()) {
				ConnectionAnalysisNode connectionAnalysisNode = connectionAnalysis2connectionAnalysisNode.get(connectionAnalysis);
				assert connectionAnalysisNode != null;
				for (@NonNull AccessAnalysis consumingAnalysis : connectionAnalysis.consumingAnalyses) {
					AccessAnalysisNode consumingAnalysisNode = consumingAnalysis2accessAnalysisNode.get(consumingAnalysis);
					assert consumingAnalysisNode != null;
					context.appendEdge(toGraph, connectionAnalysisNode, new ConnectionEdge(), consumingAnalysisNode);
					//	for (@NonNull NavigationCallExp consumer : consumingAnalysis.consumers) {
					//		MappingNode mappingNode = getMappingNode(mapping2mappingNode, consumer);
					//		context.appendEdge(toGraph, consumingAnalysisNode, new ConsumptionEdge(isObserve(consumer)), mappingNode);
					//	}
				}
				for (@NonNull AccessAnalysis producingAnalysis : connectionAnalysis.producingAnalyses) {
					AccessAnalysisNode producingAnalysisNode = producingAnalysis2accessAnalysisNode.get(producingAnalysis);
					assert producingAnalysisNode != null;
					context.appendEdge(toGraph, producingAnalysisNode, new ConnectionEdge(), connectionAnalysisNode);
					//	for (@NonNull NamedElement producer : producingAnalysis.producers) {
					//		MappingNode mappingNode = getMappingNode(mapping2mappingNode, producer);
					//		context.appendEdge(toGraph, mappingNode, new ProductionEdge(isNotify(producer)), producingAnalysisNode);
					//	}
				}
			}

			for (@NonNull AccessAnalysis producingAnalysis : producingAnalysis2connectionAnalyses.keySet()) {
				AccessAnalysisNode producingAnalysisNode = producingAnalysis2accessAnalysisNode.get(producingAnalysis);
				assert producingAnalysisNode != null;
				for (@NonNull NamedElement producer : producingAnalysis.producers) {
					MappingNode mappingNode = getMappingNode(mapping2mappingNode, producer);
					context.appendEdge(toGraph, mappingNode, new ProductionEdge(isNotify(producer)), producingAnalysisNode);
				}
			}
			for (@NonNull AccessAnalysis consumingAnalysis : consumingAnalysis2connectionAnalysis.keySet()) {
				AccessAnalysisNode consumingAnalysisNode = consumingAnalysis2accessAnalysisNode.get(consumingAnalysis);
				assert consumingAnalysisNode != null;
				for (@NonNull NavigationCallExp consumer : consumingAnalysis.consumers) {
					MappingNode mappingNode = getMappingNode(mapping2mappingNode, consumer);
					context.appendEdge(toGraph, consumingAnalysisNode, new ConsumptionEdge(isObserve(consumer)), mappingNode);
				}
			}
		}

		public void appendNode(@NonNull ToGraph toGraph, @NonNull Map<@NonNull Mapping, @NonNull MappingNode> mapping2mappingNode) {
			Set<@NonNull AccessAnalysis> allAccessAnalyses = new HashSet<>(consumingAnalysis2connectionAnalysis.keySet());
			allAccessAnalyses.addAll(producingAnalysis2connectionAnalyses.keySet());
			if (allAccessAnalyses.size() <= 1) {
				appendSimplePropertyAnalysis(toGraph, mapping2mappingNode, allAccessAnalyses.iterator().next());
			}
			else {
				appendComplexPropertyAnalysis(toGraph, mapping2mappingNode);
			}
		}

		private void appendSimplePropertyAnalysis(@NonNull ToGraph toGraph, @NonNull Map<@NonNull Mapping, @NonNull MappingNode> mapping2mappingNode, @NonNull AccessAnalysis accessAnalysis) {
			GraphStringBuilder context = toGraph.context;
			AccessAnalysisNode accessAnalysisNode = new AccessAnalysisNode(accessAnalysis, null);
			context.appendNode(toGraph, accessAnalysisNode);
			for (@NonNull NavigationCallExp consumer : accessAnalysis.consumers) {
				MappingNode mappingNode = getMappingNode(mapping2mappingNode, consumer);
				ConsumptionEdge consumptionEdge = new ConsumptionEdge(isObserve(consumer));
				context.appendEdge(toGraph, accessAnalysisNode, consumptionEdge, mappingNode);
			}
			for (@NonNull NamedElement producer : accessAnalysis.producers) {
				MappingNode mappingNode = getMappingNode(mapping2mappingNode, producer);
				ProductionEdge productionEdge = new ProductionEdge(isNotify(producer));
				context.appendEdge(toGraph, mappingNode, productionEdge, accessAnalysisNode);
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

		protected @NonNull AccessAnalysisNode getAccessAnalysisNode(@NonNull ToGraph toGraph, @NonNull AccessAnalysis accessAnalysis,
				@NonNull Map<@NonNull AccessAnalysis, @NonNull AccessAnalysisNode> accessAnalysis2accessAnalysisNode, boolean isConsumption) {
			AccessAnalysisNode accessAnalysisNode = accessAnalysis2accessAnalysisNode.get(accessAnalysis);
			if (accessAnalysisNode == null) {
				accessAnalysisNode = new AccessAnalysisNode(accessAnalysis, isConsumption);
				accessAnalysis2accessAnalysisNode.put(accessAnalysis, accessAnalysisNode);
				toGraph.context.appendNode(toGraph, accessAnalysisNode);
			}
			return accessAnalysisNode;
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

		protected @NonNull ConnectionAnalysisNode getConnectionAnalysisNode(@NonNull ToGraph toGraph, @NonNull ConnectionAnalysis connectionAnalysis,
				Map<@NonNull ConnectionAnalysis, @NonNull ConnectionAnalysisNode> connectionAnalysis2connectionAnalysisNode) {
			ConnectionAnalysisNode connectionAnalysisNode = connectionAnalysis2connectionAnalysisNode.get(connectionAnalysis);
			if (connectionAnalysisNode == null) {
				connectionAnalysisNode = new ConnectionAnalysisNode(connectionAnalysis);
				connectionAnalysis2connectionAnalysisNode.put(connectionAnalysis, connectionAnalysisNode);
				toGraph.context.appendNode(toGraph, connectionAnalysisNode);
			}
			return connectionAnalysisNode;
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
	}

	private class MappingNode extends AbstractGraphNode
	{
		protected final @NonNull Mapping mapping;

		protected MappingNode(@NonNull Mapping mapping) {
			this.mapping = mapping;
		}

		@Override
		public void appendNode(@NonNull ToGraphHelper toGraphHelper, @NonNull String nodeName) {
			GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
			s.setLabel(mapping.getName() + "\n" + PassRange.create(mapping));
			s.setShape("rectangle");
			s.setStyle("solid");
			s.setColor("green");
			s.setPenwidth(2);
			s.appendAttributedNode(nodeName);
		}
	}

	private class AccessAnalysisNode extends AbstractGraphNode
	{
		protected final @NonNull AccessAnalysis accessAnalysis;
		protected final @Nullable Boolean isConsumption;

		protected AccessAnalysisNode(@NonNull AccessAnalysis accessAnalysis, @Nullable Boolean isConsumption) {
			this.accessAnalysis = accessAnalysis;
			this.isConsumption = isConsumption;
		}

		@Override
		public void appendNode(@NonNull ToGraphHelper toGraphHelper, @NonNull String nodeName) {
			Property property = accessAnalysis.property;
			Type type = property.getType();
			PassRange productionPassRange = accessAnalysis.getProductionPassRange();
			PassRange consumptionPassRange = accessAnalysis.getConsumptionPassRange();
			StringBuilder sLabel = new StringBuilder();
			sLabel.append(accessAnalysis.sourceClass.getName());
			sLabel.append("::");
			sLabel.append(property.getName());
			sLabel.append("\n: ");
			if (property.isIsMany()) {
				sLabel.append(type.getName());
				sLabel.append("(");
				sLabel.append(((CollectionType)type).getElementType().getName());
				sLabel.append(")");
				//	sLabel.append(/*property.isIsRequired() ? "[+]" :*/ "[*]");
			}
			else {
				sLabel.append(type.getName());
				sLabel.append(property.isIsRequired() ? "[1]" : "[?]");
			}
			sLabel.append("\n");
			if (isConsumption == null) {
				sLabel.append(productionPassRange);
				sLabel.append(" => ");
				sLabel.append(consumptionPassRange);
			}
			else {
				sLabel.append(isConsumption ? consumptionPassRange : productionPassRange);
			}
			String label = sLabel.toString();
			GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
			s.setLabel(label);
			s.setShape("rectangle");
			s.setStyle(type instanceof DataType ? "rounded" : "solid");
			s.setColor(isConsumption == null ? "blue" : "cyan");
			s.setPenwidth(2);
			s.appendAttributedNode(nodeName);
		}
	}

	private class ConnectionAnalysisNode extends AbstractGraphNode
	{
		protected final @NonNull ConnectionAnalysis connectionAnalysis;

		protected ConnectionAnalysisNode(@NonNull ConnectionAnalysis connectionAnalysis) {
			this.connectionAnalysis = connectionAnalysis;
		}

		@Override
		public void appendNode(@NonNull ToGraphHelper toGraphHelper, @NonNull String nodeName) {
			BasePropertyAnalysis basePropertyAnalysis = connectionAnalysis.basePropertyAnalysis;
			Property baseProperty = basePropertyAnalysis.baseProperty;
			StringBuilder sLabel = new StringBuilder();
			sLabel.append(baseProperty.getOwningClass().getName());
			sLabel.append("::");
			sLabel.append(baseProperty.getName());
			String label = sLabel.toString();
			GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
			s.setLabel(label);
			s.setShape("ellipse");
			s.setStyle("solid");
			s.setColor("cyan");
			s.setPenwidth(2);
			s.appendAttributedNode(nodeName);
		}
	}

	/**
	 * AccessAnalysis aggregates the producer/consumer analysis of a source-CompleteClass via property to target-CompleteClass slot value.
	 * Distinct accesses are kept separate. RElated accesses such as opposites and deriveds are aggregated by a BasePropertyAnalysis.
	 */
	private class AccessAnalysis implements Nameable
	{
		//	protected final @NonNull BasePropertyAnalysis basePropertyAnalysis;
		protected final @NonNull CompleteClass sourceClass;
		protected final @NonNull Property property;
		protected final @NonNull CompleteClass targetClass;
		//	protected final @NonNull String baseName;
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
			//	baseName = s.toString();
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
	}

	/**
	 * ConnectionAnalysis matches the conforming production and consumption analyses that correspond to a connection.
	 */
	private class ConnectionAnalysis implements Nameable
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
			throw new UnsupportedOperationException();
		}

		@Override
		public void setHead(@NonNull GraphNode node) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void setLabel(@NonNull GraphNode node) {
			String label = getLabel(node);
			context.setLabel(label);
		}

		@Override
		public void setPenwidth(@NonNull GraphNode node) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void setShapeAndStyle(@NonNull GraphNode node) {
			throw new UnsupportedOperationException();
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
		List<@NonNull BasePropertyAnalysis> basePropertyAnalyses = new ArrayList<>(property2basePropertyAnalysis.values());
		Collections.sort(basePropertyAnalyses, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull BasePropertyAnalysis basePropertyAnalysis : basePropertyAnalyses) {
			basePropertyAnalysis.appendNode(toGraph, mapping2mappingNode);
		}
		context.popCluster();
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

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		throw new UnsupportedOperationException();
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
}
