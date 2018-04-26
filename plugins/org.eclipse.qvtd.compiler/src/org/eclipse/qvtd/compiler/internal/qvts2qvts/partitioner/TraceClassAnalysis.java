/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractDispatch;

/**
 * Each TraceClassAnalysis identifies the usage of one middle trace class.
 */
public class TraceClassAnalysis extends TraceElementAnalysis
{
	protected final @NonNull ClassDatum traceClassDatum;

	/**
	 * The properties necessary to discriminate multiple use of this trace class once its producers
	 * have been partitioned into speculation stages. All discriminatingProperties must appears in
	 * all partitioned mappings of the consumer.
	 */
	private @Nullable List<@NonNull Property> discriminatingProperties = null;

	private @NonNull List<@NonNull TraceClassAnalysis> subTraceClassAnalyses = new ArrayList<>();
	private @NonNull List<@NonNull TraceClassAnalysis> superTraceClassAnalyses = new ArrayList<>();

	private @Nullable Boolean isCyclic = null;
	private @Nullable Boolean isDispatcher = null;

	public TraceClassAnalysis(@NonNull TransformationPartitioner transformationPartitioner, @NonNull ClassDatum traceClassDatum) {
		super(transformationPartitioner);
		this.traceClassDatum = traceClassDatum;
		subTraceClassAnalyses.add(this);
		superTraceClassAnalyses.add(this);
		assert traceClassDatum.getReferredTypedModel() == transformationPartitioner.getScheduleManager().getTraceTypedModel();
	}

	public void addSubTraceClassAnalysis(@NonNull TraceClassAnalysis traceClassAnalysis) {
		if (!subTraceClassAnalyses.contains(traceClassAnalysis)) {
			subTraceClassAnalyses.add(traceClassAnalysis);
		}
	}

	public void addSuperTraceClassAnalysis(@NonNull TraceClassAnalysis traceClassAnalysis) {
		if (!superTraceClassAnalyses.contains(traceClassAnalysis)) {
			superTraceClassAnalyses.add(traceClassAnalysis);
		}
	}

	/**
	 * Discrimination is required when manually specified trace classes are re-used by more than one mapping. It is therefore necessary
	 * to identify properties such as parent=null/not-null that may distinguish different uses and so enable what appears to be a full
	 * N-producer N-consumer permutation to actually be N distinct 1-producer 1-consumer problems.
	 *
	 * This method identifies the discriminating properties.
	 */
	public void discriminate() throws CompilerChainException {
		if ((producers.size() <= 1) || (consumers.size() <= 1)) {
			TransformationPartitioner.DISCRIMINATION.println("Not required for " + this);
			return;
		}
		//
		//	Identify the properties available for discrimination.
		//
		Map<@NonNull MappingPartitioner, @NonNull Map<@NonNull Property, @NonNull NavigableEdge>> partitioner2property2edge = new HashMap<>();
		Set<@NonNull Property> commonProperties = null;
		for (@NonNull MappingPartitioner producer : producers) {
			Map<@NonNull Property, @NonNull NavigableEdge> property2edge = new HashMap<>();
			partitioner2property2edge.put(producer, property2edge);
			for (@NonNull Node traceNode : producer.getTraceNodes()) {
				for (@NonNull NavigationEdge edge : traceNode.getRealizedNavigationEdges()) {
					if (!edge.getEdgeTarget().isRealized()) {
						property2edge.put(QVTscheduleUtil.getProperty(edge), edge);
					}
				}
			}
			Set<@NonNull Property> partionerProperties = property2edge.keySet();
			if (commonProperties == null) {
				commonProperties = new HashSet<@NonNull Property>(partionerProperties);
			}
			else {
				commonProperties.retainAll(partionerProperties);
			}
		}
		if ((commonProperties == null) || commonProperties.isEmpty()) {
			//			throw new CompilerChainException("No common properties to disambiguate " + this);
			TransformationPartitioner.DISCRIMINATION.println("No common properties to disambiguate " + this);
			return;
		}
		//
		//	Identify the discriminating power of each property.
		//
		List<@NonNull Property> sortedProperties = new ArrayList<@NonNull Property>(commonProperties);
		Collections.sort(sortedProperties, NameUtil.NAMEABLE_COMPARATOR);
		Map<@NonNull Property, @Nullable Map<@Nullable CompleteClass, @NonNull List<@NonNull MappingPartitioner>>> property2completeClass2partitioners  = new HashMap<>();
		for (@NonNull Property property : sortedProperties) {
			for (@NonNull MappingPartitioner producer : producers) {
				Map<@NonNull Property, @NonNull NavigableEdge> property2edge = partitioner2property2edge.get(producer);
				assert property2edge != null;
				NavigableEdge edge = property2edge.get(property);
				if (edge == null) {
					property2completeClass2partitioners.put(property, null);
				}
				else {
					Map<@Nullable CompleteClass, @NonNull List<@NonNull MappingPartitioner>> completeClass2partitioners = property2completeClass2partitioners.get(property);
					if (completeClass2partitioners == null) {
						completeClass2partitioners = new HashMap<>();
						property2completeClass2partitioners.put(property, completeClass2partitioners);
					}
					CompleteClass completeClass;
					Node targetNode = QVTscheduleUtil.getTargetNode(edge);
					if (targetNode.isNullLiteral())  {
						completeClass = null;
					}
					else {
						completeClass = targetNode.getCompleteClass(); // FIXME use/ignore inheritance
					}
					List<@NonNull MappingPartitioner> partitioners = completeClass2partitioners.get(completeClass);
					if (partitioners == null) {
						partitioners = new ArrayList<>();
						completeClass2partitioners.put(completeClass, partitioners);
					}
					partitioners.add(producer);
				}
				/*				assert edge != null;

				//				if (value instanceof VariableExp) {
				//					VariableDeclaration referredVariable = ((VariableExp)value).getReferredVariable();
				//					assert referredVariable != null;
				//					type = referredVariable.getType();
				//				}
				//				else if ((value != null) && !(value instanceof NullLiteralExp)) {
				//					type = value.getType();
				//				}
				CompleteClass thisCompleteClass = targetNode.getCompleteClass();
				for (@NonNull CompleteClass thatCompleteClass : valueCompleteClasses) {
					if (!isDiscriminant(thisCompleteClass, thatCompleteClass)) {
						isDiscriminant = false;
						break;
					}
				}
				valueCompleteClasses.add(thisCompleteClass);
				if (!isDiscriminant) {
					break;
				} */
			}
		}
		//
		//	Choose the best discriminant. FIXME support multi-discrimination
		//
		int bestSize = 0;
		Property bestProperty = null;
		for (@NonNull Property property : property2completeClass2partitioners.keySet()) {
			Map<@Nullable CompleteClass, @NonNull List<@NonNull MappingPartitioner>> completeClass2partitioners = property2completeClass2partitioners.get(property);
			if (completeClass2partitioners != null) {
				int size = completeClass2partitioners.size();
				if (size > bestSize) {
					bestSize = size;
					bestProperty = property;
				}
			}
		}
		if (TransformationPartitioner.DISCRIMINATION.isActive()) {
			StringBuilder s = new StringBuilder();
			s.append("property->completeClass->partitioners");
			for (@NonNull Property property : property2completeClass2partitioners.keySet()) {
				s.append("\n\t" + property);
				Map<@Nullable CompleteClass, @NonNull List<@NonNull MappingPartitioner>> completeClass2partitioners = property2completeClass2partitioners.get(property);
				if (completeClass2partitioners != null) {
					for (@Nullable CompleteClass completeClass : completeClass2partitioners.keySet()) {
						s.append("\n\t\t" + completeClass);
						List<@NonNull MappingPartitioner> partitioners = completeClass2partitioners.get(completeClass);
						assert partitioners != null;
						for (@NonNull MappingPartitioner mappingPartitioner : partitioners) {
							s.append("\n\t\t\t" + mappingPartitioner);
						}
					}
				}
			}
			TransformationPartitioner.DISCRIMINATION.println(s.toString());
		}
		if (bestProperty != null) {
			TransformationPartitioner.DISCRIMINATION.println("Best property : " + bestProperty);
			discriminatingProperties = Collections.singletonList(bestProperty);
			return;
		}
		else {
			throw new CompilerChainException("Unable to disambiguate " + this);
		}
	}

	public @NonNull ClassDatum getClassDatum() {
		return traceClassDatum;
	}

	public @Nullable Iterable<@NonNull Property> getDiscriminatingProperties() {
		return discriminatingProperties;
	}

	@Override
	public String getName() {
		return traceClassDatum.getName();
	}

	public @NonNull Iterable<@NonNull TraceClassAnalysis> getSubTraceClassAnalyses() {
		return subTraceClassAnalyses;
	}

	public @NonNull Iterable<@NonNull TraceClassAnalysis> getSuperTraceClassAnalyses() {
		return superTraceClassAnalyses;
	}

	public @NonNull CompleteClass getTraceClass() {
		return QVTscheduleUtil.getCompleteClass(traceClassDatum);
	}

	/**
	 * Return true if this TraceClassAnalyis participates in a production/consumption cycle of either the trace class or its trace properties.
	 */
	public boolean isCyclic() {
		Boolean isCyclic2 = isCyclic;
		if (isCyclic2 == null) {
			for (@NonNull TraceClassAnalysis subTraceClassAnalysis : subTraceClassAnalyses) {
				if (transformationPartitioner.getCycleAnalysis(subTraceClassAnalysis) != null) {
					isCyclic2 = isCyclic = true;
					return isCyclic2;
				}
			}
			isCyclic2 = isCyclic = false;
		}
		return isCyclic2;
	}

	/**
	 * Return true if this TraceClassAnalyis is for an override hierarchy dispatcher.
	 */
	public boolean isDispatcher() {
		Boolean isDispatcher2 = isDispatcher;
		if (isDispatcher2 == null) {
			String abstractDispatchClassName = AbstractDispatch.class.getName();
			for (org.eclipse.ocl.pivot.@NonNull Class superClass : QVTbaseUtil.getSuperClasses(QVTscheduleUtil.getCompleteClass(traceClassDatum).getPrimaryClass())) {
				if (abstractDispatchClassName.equals(superClass.getInstanceClassName())) {
					isDispatcher2 = isDispatcher = true;
					return isDispatcher2;
				}
			}
			isDispatcher2 = isDispatcher = false;
		}
		return isDispatcher2;
	}

	/**
	 * Return true if thisCompleteClass and thatCompleteClass have no mutual conformance and so may be used to discriminate
	 * ambiguous middle types.
	 *
	private boolean isDiscriminant(@Nullable CompleteClass thisCompleteClass, @Nullable CompleteClass thatCompleteClass) {
		if (thisCompleteClass == thatCompleteClass) {
			return false;
		}
		if ((thisCompleteClass == null) || (thatCompleteClass == null)) {
			return true;
		}
		if (thisCompleteClass.conformsTo(thatCompleteClass)) {
			return false;
		}
		if (thatCompleteClass.conformsTo(thisCompleteClass)) {
			return false;
		}
		return true;
	} */

	@Override
	public String toString() {
		return traceClassDatum.toString();
	}
}
