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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.TraceClassRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
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
public class TraceClassPartitionAnalysis extends TraceElementPartitionAnalysis implements CompilerUtil.TraceClass<@NonNull PartitionAnalysis, @NonNull TraceClassPartitionAnalysis, @NonNull TracePropertyPartitionAnalysis>
{
	protected final @NonNull TraceClassRegionAnalysis traceClassRegionAnalysis;
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull ClassDatum traceClassDatum;

	/**
	 * The properties necessary to discriminate multiple use of this trace class once its producers
	 * have been partitioned into speculation stages. All discriminatingProperties must appears in
	 * all partitioned mappings of the consumer.
	 */
	private @Nullable List<@NonNull Property> discriminatingProperties = null;

	private @NonNull List<@NonNull TraceClassPartitionAnalysis> subTraceClassAnalyses = new ArrayList<>();
	private @NonNull List<@NonNull TraceClassPartitionAnalysis> superTraceClassAnalyses = new ArrayList<>();

	private @Nullable Boolean isDispatcher = null;

	public TraceClassPartitionAnalysis(@NonNull TraceClassRegionAnalysis traceClassRegionAnalysis) {
		this.traceClassRegionAnalysis = traceClassRegionAnalysis;
		this.scheduleManager = traceClassRegionAnalysis.getScheduleManager();
		this.traceClassDatum = traceClassRegionAnalysis.getClassDatum();
		subTraceClassAnalyses.add(this);
		superTraceClassAnalyses.add(this);
		//	assert traceClassDatum.getReferredTypedModel() == scheduleManager.getTraceTypedModel();
	}

	public void addSubTraceClassAnalysis(@NonNull TraceClassPartitionAnalysis traceClassAnalysis) {
		if (!subTraceClassAnalyses.contains(traceClassAnalysis)) {
			subTraceClassAnalyses.add(traceClassAnalysis);
		}
	}

	public void addSuperTraceClassAnalysis(@NonNull TraceClassPartitionAnalysis traceClassAnalysis) {
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
		Map<@NonNull PartitionAnalysis, @NonNull Map<@NonNull Property, @NonNull NavigableEdge>> partitioner2property2edge = new HashMap<>();
		Set<@NonNull Property> commonProperties = null;
		for (@NonNull PartitionAnalysis producer : producers) {
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
		Map<@NonNull Property, @Nullable Map<@Nullable CompleteClass, @NonNull List<@NonNull PartitionAnalysis>>> property2completeClass2partitionAnalyses  = new HashMap<>();
		for (@NonNull Property property : sortedProperties) {
			for (@NonNull PartitionAnalysis producer : producers) {
				Map<@NonNull Property, @NonNull NavigableEdge> property2edge = partitioner2property2edge.get(producer);
				assert property2edge != null;
				NavigableEdge edge = property2edge.get(property);
				if (edge == null) {
					property2completeClass2partitionAnalyses.put(property, null);
				}
				else {
					Map<@Nullable CompleteClass, @NonNull List<@NonNull PartitionAnalysis>> completeClass2partitionAnalyses = property2completeClass2partitionAnalyses.get(property);
					if (completeClass2partitionAnalyses == null) {
						completeClass2partitionAnalyses = new HashMap<>();
						property2completeClass2partitionAnalyses.put(property, completeClass2partitionAnalyses);
					}
					CompleteClass completeClass;
					Node targetNode = QVTscheduleUtil.getTargetNode(edge);
					if (targetNode.isNullLiteral())  {
						completeClass = null;
					}
					else {
						completeClass = targetNode.getCompleteClass(); // FIXME use/ignore inheritance
					}
					List<@NonNull PartitionAnalysis> partitionAnalyses = completeClass2partitionAnalyses.get(completeClass);
					if (partitionAnalyses == null) {
						partitionAnalyses = new ArrayList<>();
						completeClass2partitionAnalyses.put(completeClass, partitionAnalyses);
					}
					partitionAnalyses.add(producer);
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
		for (@NonNull Property property : property2completeClass2partitionAnalyses.keySet()) {
			Map<@Nullable CompleteClass, @NonNull List<@NonNull PartitionAnalysis>> completeClass2partitionAnalyses = property2completeClass2partitionAnalyses.get(property);
			if (completeClass2partitionAnalyses != null) {
				int size = completeClass2partitionAnalyses.size();
				if (size > bestSize) {
					bestSize = size;
					bestProperty = property;
				}
			}
		}
		if (TransformationPartitioner.DISCRIMINATION.isActive()) {
			StringBuilder s = new StringBuilder();
			s.append("property->completeClass->partitionAnalyses");
			for (@NonNull Property property : property2completeClass2partitionAnalyses.keySet()) {
				s.append("\n\t" + property);
				Map<@Nullable CompleteClass, @NonNull List<@NonNull PartitionAnalysis>> completeClass2partitionAnalyses = property2completeClass2partitionAnalyses.get(property);
				if (completeClass2partitionAnalyses != null) {
					for (@Nullable CompleteClass completeClass : completeClass2partitionAnalyses.keySet()) {
						s.append("\n\t\t" + completeClass);
						List<@NonNull PartitionAnalysis> partitionAnalyses = completeClass2partitionAnalyses.get(completeClass);
						assert partitionAnalyses != null;
						for (@NonNull PartitionAnalysis partitionAnalysis : partitionAnalyses) {
							s.append("\n\t\t\t" + partitionAnalysis);
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

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	@Override
	public @NonNull Iterable<@NonNull TraceClassPartitionAnalysis> getSubTraceClassAnalyses() {
		return subTraceClassAnalyses;
	}

	public @NonNull Iterable<@NonNull TraceClassPartitionAnalysis> getSuperTraceClassAnalyses() {
		return superTraceClassAnalyses;
	}

	public @NonNull CompleteClass getTraceClass() {
		return QVTscheduleUtil.getCompleteClass(traceClassDatum);
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
