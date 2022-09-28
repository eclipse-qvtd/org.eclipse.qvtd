/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TransformationPartitioner;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractDispatch;

/**
 * Each ClassAnalysis identifies the usage of one middle trace class or property.
 */
public abstract class AbstractPartialRegionClassAnalysis<PRA extends PartialRegionsAnalysis<@NonNull PRA>> extends AbstractPartialRegionElementAnalysis<@NonNull PRA> implements PartialRegionClassAnalysis<@NonNull PRA>
{
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull ClassDatum classDatum;

	private @NonNull List<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> subClassAnalyses = new ArrayList<>();
	private @NonNull List<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> superClassAnalyses = new ArrayList<>();
	private @Nullable Boolean isDispatcher = null;

	/**
	 * The properties necessary to discriminate multiple use of this trace class once its producers
	 * have been partitioned into speculation stages. All discriminatingProperties must appears in
	 * all partitioned mappings of the consumer.
	 */
	private @Nullable List<@NonNull Property> discriminatingProperties = null;

	protected AbstractPartialRegionClassAnalysis(@NonNull ScheduleManager scheduleManager, @NonNull ClassDatum classDatum) {
		this.scheduleManager = scheduleManager;
		this.classDatum = classDatum;
		subClassAnalyses.add(this);
		superClassAnalyses.add(this);
		//	assert classDatum.getReferredTypedModel() == scheduleManager.getTraceTypedModel();
	}

	@Override
	public void addSubClassAnalysis(@NonNull PartialRegionClassAnalysis<@NonNull PRA> classAnalysis) {
		if (!subClassAnalyses.contains(classAnalysis)) {
			subClassAnalyses.add(classAnalysis);
		}
	}

	@Override
	public void addSuperClassAnalysis(@NonNull PartialRegionClassAnalysis<@NonNull PRA> classAnalysis) {
		if (!superClassAnalyses.contains(classAnalysis)) {
			superClassAnalyses.add(classAnalysis);
		}
	}

	/**
	 * Discrimination is required when manually specified trace classes are re-used by more than one mapping. It is therefore necessary
	 * to identify properties such as parent=null/not-null that may distinguish different uses and so enable what appears to be a full
	 * N-producer N-consumer permutation to actually be N distinct 1-producer 1-consumer problems.
	 *
	 * This method identifies the discriminating properties.
	 */
	@Override
	public void discriminate() throws CompilerChainException {
		if ((producers.size() <= 1) || (consumers.size() <= 1)) {
			TransformationPartitioner.DISCRIMINATION.println("Not required for " + this);
			return;
		}
		//
		//	Identify the properties available for discrimination.
		//
		Map<@NonNull PartialRegionAnalysis<@NonNull PRA>, @NonNull Map<@NonNull Property, @NonNull NavigableEdge>> partitioner2property2edge = new HashMap<>();
		Set<@NonNull Property> commonProperties = null;
		for (@NonNull PartialRegionAnalysis<@NonNull PRA> producer : producers) {
			Map<@NonNull Property, @NonNull NavigableEdge> property2edge = new HashMap<>();
			partitioner2property2edge.put(producer, property2edge);
			for (@NonNull Node traceNode : producer.getTraceNodes()) {	// FIXME Bug 488647 discriminate output classes too
				for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(traceNode)) {
					if (edge.isRealized() && edge.isNavigation()) {
						NavigationEdge navigationEdge = (NavigationEdge)edge;
						if (!navigationEdge.getEdgeTarget().isRealized()) {
							property2edge.put(QVTscheduleUtil.getReferredProperty(navigationEdge), navigationEdge);
						}
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
		Map<@NonNull Property, @Nullable Map<@Nullable ClassDatum, @NonNull List<@NonNull PartialRegionAnalysis<@NonNull PRA>>>> property2classDatum2regionAnalyses  = new HashMap<>();
		for (@NonNull Property property : sortedProperties) {
			for (@NonNull PartialRegionAnalysis<@NonNull PRA> producer : producers) {
				Map<@NonNull Property, @NonNull NavigableEdge> property2edge = partitioner2property2edge.get(producer);
				assert property2edge != null;
				NavigableEdge edge = property2edge.get(property);
				if (edge == null) {
					property2classDatum2regionAnalyses.put(property, null);
				}
				else {
					Map<@Nullable ClassDatum, @NonNull List<@NonNull PartialRegionAnalysis<@NonNull PRA>>> classDatum2regionAnalyses = property2classDatum2regionAnalyses.get(property);
					if (classDatum2regionAnalyses == null) {
						classDatum2regionAnalyses = new HashMap<>();
						property2classDatum2regionAnalyses.put(property, classDatum2regionAnalyses);
					}
					ClassDatum classDatum;
					Node targetNode = QVTscheduleUtil.getTargetNode(edge);
					if (targetNode.isNullLiteral())  {
						classDatum = null;
					}
					else {
						classDatum = targetNode.getClassDatum(); // FIXME use/ignore inheritance
					}
					List<@NonNull PartialRegionAnalysis<@NonNull PRA>> regionAnalyses = classDatum2regionAnalyses.get(classDatum);
					if (regionAnalyses == null) {
						regionAnalyses = new ArrayList<>();
						classDatum2regionAnalyses.put(classDatum, regionAnalyses);
					}
					regionAnalyses.add(producer);
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
				ClassDatum thisClassDatum = targetNode.getClassDatum();
				for (@NonNull ClassDatum thatClassDatum : valueClassDatumes) {
					if (!isDiscriminant(thisClassDatum, thatClassDatum)) {
						isDiscriminant = false;
						break;
					}
				}
				valueClassDatumes.add(thisClassDatum);
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
		for (@NonNull Property property : property2classDatum2regionAnalyses.keySet()) {
			Map<@Nullable ClassDatum, @NonNull List<@NonNull PartialRegionAnalysis<@NonNull PRA>>> classDatum2regionAnalyses = property2classDatum2regionAnalyses.get(property);
			if (classDatum2regionAnalyses != null) {
				int size = classDatum2regionAnalyses.size();
				if (size > bestSize) {
					bestSize = size;
					bestProperty = property;
				}
			}
		}
		if (TransformationPartitioner.DISCRIMINATION.isActive()) {
			StringBuilder s = new StringBuilder();
			s.append("property->classDatum->regionAnalyses");
			for (@NonNull Property property : property2classDatum2regionAnalyses.keySet()) {
				s.append("\n\t" + property);
				Map<@Nullable ClassDatum, @NonNull List<@NonNull PartialRegionAnalysis<@NonNull PRA>>> classDatum2regionAnalyses = property2classDatum2regionAnalyses.get(property);
				if (classDatum2regionAnalyses != null) {
					for (@Nullable ClassDatum classDatum : classDatum2regionAnalyses.keySet()) {
						s.append("\n\t\t" + classDatum);
						List<@NonNull PartialRegionAnalysis<@NonNull PRA>> regionAnalyses = classDatum2regionAnalyses.get(classDatum);
						assert regionAnalyses != null;
						for (@NonNull PartialRegionAnalysis<@NonNull PRA> regionAnalysis : regionAnalyses) {
							s.append("\n\t\t\t" + regionAnalysis);
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

	@Override
	public @NonNull ClassDatum getClassDatum() {
		return classDatum;
	}

	@Override
	public @NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PRA>> getCompatibleProducers() {
		return producers;
	}

	@Override
	public @Nullable Iterable<@NonNull Property> getDiscriminatingProperties() {
		return discriminatingProperties;
	}

	@Override
	public String getName() {
		return classDatum.getName();
	}

	@Override
	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	@Override
	public @NonNull Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> getSubClassAnalyses() {
		return subClassAnalyses;
	}

	@Override
	public @NonNull Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> getSuperClassAnalyses() {
		return superClassAnalyses;
	}

	/**
	 * Return true if this ClassAnalyis is for an override hierarchy dispatcher.
	 */
	@Deprecated /* @deprecated not used */
	public boolean isDispatcher() {
		Boolean isDispatcher2 = isDispatcher;
		if (isDispatcher2 == null) {
			String abstractDispatchClassName = AbstractDispatch.class.getName();
			for (org.eclipse.ocl.pivot.@NonNull Class superClass : QVTbaseUtil.getSuperClasses(classDatum.getPrimaryClass())) {
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
		return classDatum.toString();
	}
}
