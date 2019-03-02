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
package org.eclipse.qvtd.compiler.internal.utilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil.UnresolvedProxyCrossReferencer;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.JavaClasspath;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.PartitionProblem;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionProblem;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.Concurrency;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.CompositePartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TransformationPartitioner;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.VerdictRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class CompilerUtil extends QVTscheduleUtil
{
	public final static @NonNull Map<Object, Object> defaultSavingOptions;

	// FIXME use a better default strategy for the saving options
	static {
		defaultSavingOptions = new HashMap<Object, Object>();
		defaultSavingOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
		defaultSavingOptions.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
		defaultSavingOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		defaultSavingOptions.put(XMLResource.OPTION_SCHEMA_LOCATION_IMPLEMENTATION, Boolean.TRUE);
		defaultSavingOptions.put(XMLResource.OPTION_LINE_WIDTH, Integer.valueOf(132));

	}

	/**
	 * PartialRegion definds the necessary partial-region functionality for a computeImmediatePredecessors participant.
	 */
	public interface PartialRegion<PR, TC, TP> extends Nameable
	{
		@Nullable Iterable<@NonNull TC> getConsumedTraceClassAnalyses();
		@Nullable Iterable<@NonNull TP> getConsumedTracePropertyAnalyses();
		@Nullable Iterable<@NonNull PR> getExplicitPredecessors();
	}

	/**
	 * PartialRegion definds the necessary trace-class functionality for a computeImmediatePredecessors participant.
	 */
	public interface TraceClass<PR, TC, TP> extends Nameable
	{
		@NonNull Iterable<@NonNull PR> getProducers();
		@NonNull Iterable<@NonNull TC> getSubTraceClassAnalyses();
	}

	/**
	 * PartialRegion definds the necessary trace-property functionality for a computeImmediatePredecessors participant.
	 */
	public interface TraceProperty<PR, TC, TP> extends Nameable
	{
		@NonNull Iterable<@NonNull PR> getProducers();
	}

	/**
	 * Add the URI to the list of classpath elememnts.
	 *
	 * @throws MalformedURLException
	 */
	@Deprecated /* Promote to JavaClasspath */
	public static void addURI(@NonNull JavaClasspath classpath, @NonNull URI uri) throws MalformedURLException {
		classpath.addURL(new URL(uri.isFile() ? uri.toString() : uri.toFileString()));
	}


	public static void assertNoResourceErrors(@NonNull String prefix, @NonNull Resource resource) {
		String message = PivotUtil.formatResourceDiagnostics(resource.getErrors(), prefix, "\n\t");
		if (message != null)
			assert false : message;
	}

	public static void assertNoResourceSetErrors(@NonNull String prefix, @NonNull Resource resource) {
		ResourceSet resourceSet = resource.getResourceSet();
		assert resourceSet != null : prefix + " no ResourceSet for " + resource;
		for (Resource aResource : resourceSet.getResources()) {
			if (aResource != null) {
				assertNoResourceErrors(prefix, aResource);
			}
		}
	}

	public static void assertNoUnresolvedProxies(String message, Resource resource) {
		Map<EObject, Collection<Setting>> unresolvedProxies = UnresolvedProxyCrossReferencer.find(resource);
		if (unresolvedProxies.size() > 0) {
			StringBuilder s = new StringBuilder();
			s.append(unresolvedProxies.size());
			s.append(" unresolved proxies in '" + resource.getURI() + "' ");
			s.append(message);
			for (Map.Entry<EObject, Collection<Setting>> unresolvedProxy : unresolvedProxies.entrySet()) {
				s.append("\n");
				BasicEObjectImpl key = (BasicEObjectImpl) unresolvedProxy.getKey();
				s.append(key.eProxyURI());
				for (Setting setting : unresolvedProxy.getValue()) {
					s.append("\n\t");
					EObject eObject = setting.getEObject();
					s.append(eObject.toString());
				}
			}
			assert false : s.toString();
		}
	}

	public static void assertNoValidationErrors(@NonNull String prefix, @NonNull Resource resource) {
		for (EObject eObject : resource.getContents()) {
			assertNoValidationErrors(prefix + " of '" + resource.getURI() + "'", eObject);
		}
	}

	public static void assertNoValidationErrors(@NonNull String string, EObject eObject) {
		Map<Object, Object> validationContext = LabelUtil.createDefaultContext(Diagnostician.INSTANCE);
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject, validationContext);
		List<Diagnostic> children = diagnostic.getChildren();
		if (children.size() <= 0) {
			return;
		}
		StringBuilder s = new StringBuilder();
		s.append(string + ": " + children.size() + " validation errors");
		for (Diagnostic child : children){
			s.append("\n\t");
			if (child.getData().size() > 0) {
				Object data = child.getData().get(0);
				if (data instanceof Element) {
					for (EObject eScope = (Element)data; eScope instanceof Element; eScope = eScope.eContainer()) {
						/*						ModelElementCS csElement = ElementUtil.getCsElement((Element)eScope);
						if (csElement != null) {
							ICompositeNode node = NodeModelUtils.getNode(csElement);
							if (node != null) {
								Resource eResource = csElement.eResource();
								if (eResource != null) {
									s.append(eResource.getURI().lastSegment() + ":");
								}
								int startLine = node.getStartLine();
								s.append(startLine + ":");
							}
							s.append(((Element)data).eClass().getName() + ": ");
							break;
						} */
					}
				}
			}
			s.append(child.getMessage());
		}
		assert false : s.toString();
	}

	/**
	 * Return a new list of exemplar classes whose projects need to be on the class path.
	 * @throws IOException
	 */
	public static @NonNull JavaClasspath createDefaultQVTiClasspath() {
		JavaClasspath classpath = JavaFileUtil.createDefaultOCLClasspath();
		classpath.addClass(org.eclipse.qvtd.runtime.evaluation.Invocation.class);
		return classpath;
	}

	/**
	 * Return the classpath folders corresponding to the projectNames, except that the projectName uses an explicit and
	 * possibly irregular classFilePath allowing the current project to use a non-standard 'bin' folder to avoid confusion
	 * between the test compilation and the auto-build.
	 *
	public static @NonNull List<@NonNull Class<?>> createClassPathProjectList(@NonNull URIConverter uriConverter, @NonNull Class<?> projectName,
			@NonNull Class<?> classFilePath, @Nullable Iterable<@NonNull Class<?>> projectNames) {
		assert EcorePlugin.IS_ECLIPSE_RUNNING;
		if (projectNames == null) {
			projectNames = CompilerUtil.createClasspathProjectNameList(projectName);
		}
		List<@NonNull Class<?>> projectNames2 = Lists.newArrayList(projectNames);
		projectNames2.remove(projectName);
		List<@NonNull Class<?>> classpathProjects = JavaFileUtil.createClassPathProjectList(uriConverter, projectNames2);
		classpathProjects.add(0, classFilePath);
		return classpathProjects;
	} */

	//
	//	Ripple the direct from-2-tos to compute and return the transitive from-2-tos closure.
	//
	public static <T> @NonNull Map<T, @NonNull Set<T>> computeClosure(@NonNull Map<T, @NonNull Set<T>> from2tos) {
		Iterable<T> tos = from2tos.keySet();
		Map<T, @NonNull Set<T>> from2tosClosure = new HashMap<>();
		for (T from : tos) {
			from2tosClosure.put(from, new HashSet<>(from2tos.get(from)));
		}
		boolean isChanged = true;
		while (isChanged) {
			isChanged = false;
			for (T from : from2tos.keySet()) {
				Set<T> fromTos = from2tosClosure.get(from);
				assert fromTos != null;
				for (T fromTo : new ArrayList<>(fromTos)) {
					Set<T> fromToTos = from2tosClosure.get(fromTo);
					assert fromToTos != null;
					if (fromTos.addAll(fromToTos)) {
						isChanged = true;
					}
				}
			}
		}
		return from2tosClosure;
	}


	/**
	 * Return a map of the PartialRegions that may execute immediately before each PartialRegion.
	 *
	 * This is a simple type-conformance exercise. Find the sources that are supertypes of the target.
	 */
	public static <@NonNull PR extends PartialRegion<PR, TC, TP>, @NonNull TC extends TraceClass<PR, TC, TP>, @NonNull TP extends TraceProperty<PR, TC, TP>> @NonNull Map<@NonNull PR, @NonNull Set<@NonNull PR>> computeImmediatePredecessors(@NonNull Iterable<@NonNull PR> partialRegionAnalyses) {
		Map<@NonNull PR, @NonNull Set<@NonNull PR>> consumer2producers = new HashMap<>();
		Map<@NonNull PR, @NonNull Map<@NonNull Object, @NonNull Set<@NonNull PR>>> consumer2consumedElement2producers = new HashMap<>();
		for (@NonNull PR partialRegionAnalysis : partialRegionAnalyses) {
			consumer2producers.put(partialRegionAnalysis, new HashSet<>());
		}
		for (@NonNull PR consumer : partialRegionAnalyses) {
			Map<@NonNull Object, @NonNull Set<@NonNull PR>> consumedElement2producers = null;
			if (Iterables.contains(partialRegionAnalyses, consumer)) {
				consumedElement2producers = new HashMap<>();
				consumer2consumedElement2producers.put(consumer, consumedElement2producers);
			}
			Iterable<@NonNull PR> explicitPredecessors = consumer.getExplicitPredecessors();		// Used by no-success QVTc trace
			if (explicitPredecessors != null) {
				for (@NonNull PR explicitPredecessor : explicitPredecessors) {
					Set<@NonNull PR> producers = consumer2producers.get(consumer);
					assert producers != null;
					producers.add(explicitPredecessor);
				}
			}
			Iterable<@NonNull TC> consumedTraceClassAnalyses = consumer.getConsumedTraceClassAnalyses();
			if (consumedTraceClassAnalyses != null) {
				for (@NonNull TC consumedTraceClassAnalysis : consumedTraceClassAnalyses) {
					for (@NonNull TC subConsumedTraceClass : consumedTraceClassAnalysis.getSubTraceClassAnalyses()) {
						for (@NonNull PR producer : subConsumedTraceClass.getProducers()) {
							Set<@NonNull PR> producers = consumer2producers.get(consumer);
							assert producers != null;
							producers.add(producer);
							if ((consumedElement2producers != null) && Iterables.contains(partialRegionAnalyses, producer)) {
								Set<@NonNull PR> producers2 = consumedElement2producers.get(subConsumedTraceClass);
								if (producers2 == null) {
									producers2 = new HashSet<>();
									consumedElement2producers.put(subConsumedTraceClass, producers2);
								}
								producers2.add(producer);
							}
						}
					}
				}
			}
			Iterable<@NonNull TP> consumedTracePropertyAnalyses = consumer.getConsumedTracePropertyAnalyses();
			if (consumedTracePropertyAnalyses != null) {
				for (@NonNull TP consumedTracePropertyAnalysis : consumedTracePropertyAnalyses) {
					for (@NonNull PR producer : consumedTracePropertyAnalysis.getProducers()) {
						Set<@NonNull PR> producers = consumer2producers.get(consumer);
						assert producers != null;
						producers.add(producer);
						if ((consumedElement2producers != null) && Iterables.contains(partialRegionAnalyses, producer)) {
							Set<@NonNull PR> producers2 = consumedElement2producers.get(consumedTracePropertyAnalysis);
							if (producers2 == null) {
								producers2 = new HashSet<>();
								consumedElement2producers.put(consumedTracePropertyAnalysis, producers2);
							}
							producers2.add(producer);
						}
					}
				}
			}
		}
		return consumer2producers;
	}

	//
	//	Compute and return the inverse per-to closure of all froms given the from to tos closure.
	//
	public static <T> @NonNull Map<T, @NonNull Set<T>> computeInverseClosure(@NonNull Map<T, @NonNull Set<T>> from2tos) {
		Map<T, @NonNull Set<T>> to2froms = new HashMap<>();
		Set<T> froms = from2tos.keySet();
		for (T to : froms) {
			to2froms.put(to, new HashSet<>());
		}
		for (T from : froms) {
			Set<T> fromTos = from2tos.get(from);
			assert fromTos != null;
			for (T fromTo : fromTos) {
				Set<T> fromToFroms = to2froms.get(fromTo);
				assert fromToFroms != null;
				fromToFroms.add(from);
			}
		}
		return to2froms;
	}

	/**
	 * Return a sequence of concurrencies, where each concurrency is a set of Partitions that may be executed
	 * concurrently, after their preceding concurrencies and before their subsequent concurrencies. The index in the
	 * sequence corresponds to the critical path length/depth from the earliest predecessor to the concurrent element.
	 */
	public static @NonNull List<@NonNull Concurrency> computeParallelSchedule(	// FIXME this can be much faster with bit masks
			@NonNull Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> partitionAnalysis2predecessors) {
		Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> partition2successors = CompilerUtil.computeTransitiveSuccessors(partitionAnalysis2predecessors);
		//
		//	Loop over the candidates to select those with no unscheduled predecessors. On the first iteration
		//	all partitions are considered, on subsequent iterations only successors of just scheduled partitions
		//	are reconsidered.
		//
		List<@NonNull Concurrency> parallelSchedule = new ArrayList<>();
		Set<@NonNull PartitionAnalysis> scheduledPartitionAnalyses = new HashSet<>();
		Set<@NonNull PartitionAnalysis> scheduleCandidates = new HashSet<>(partitionAnalysis2predecessors.keySet());
		while (!scheduleCandidates.isEmpty()) {
			Concurrency nextConcurrency = new Concurrency();
			Set<@NonNull PartitionAnalysis> nextScheduleCandidates = new HashSet<>();
			for (@NonNull PartitionAnalysis partitionAnalysis : scheduleCandidates) {
				Set<@NonNull PartitionAnalysis> predecessors = partitionAnalysis2predecessors.get(partitionAnalysis);
				assert predecessors != null;
				Set<@NonNull PartitionAnalysis> unscheduledPredecessors = new HashSet<>(predecessors);
				//	assert unscheduledPredecessors != null;
				unscheduledPredecessors.remove(partitionAnalysis);
				unscheduledPredecessors.removeAll(scheduledPartitionAnalyses);
				if (unscheduledPredecessors.isEmpty()) {
					nextConcurrency.add(partitionAnalysis);
					Set<@NonNull PartitionAnalysis> unscheduledSuccessors = partition2successors.get(partitionAnalysis);
					assert unscheduledSuccessors != null;
					nextScheduleCandidates.addAll(unscheduledSuccessors);
				}
			}
			assert nextConcurrency.size() > 0;
			Concurrency nextNonCompositeConcurrency = null;
			List<@NonNull CompositePartitionAnalysis> nextCompositePartitionAnalyses = null;
			for (@NonNull PartitionAnalysis partitionAnalysis : nextConcurrency) {
				nextScheduleCandidates.remove(partitionAnalysis);
				scheduledPartitionAnalyses.add(partitionAnalysis);
				if (partitionAnalysis instanceof CompositePartitionAnalysis) {
					if (nextCompositePartitionAnalyses == null) {
						nextCompositePartitionAnalyses = new ArrayList<>();
					}
					nextCompositePartitionAnalyses.add((CompositePartitionAnalysis) partitionAnalysis);
				}
				else {
					if (nextNonCompositeConcurrency == null) {
						nextNonCompositeConcurrency = new Concurrency();
					}
					nextNonCompositeConcurrency.add(partitionAnalysis);
				}
			}
			if (nextNonCompositeConcurrency != null) {
				parallelSchedule.add(nextNonCompositeConcurrency);
			}
			if (nextCompositePartitionAnalyses != null) {
				for (CompositePartitionAnalysis compositePartitionAnalysis : nextCompositePartitionAnalyses) {
					Concurrency nextCompositeConcurrency = new Concurrency();
					nextCompositeConcurrency.add(compositePartitionAnalysis);
					parallelSchedule.add(nextCompositeConcurrency);
				}
			}
			scheduleCandidates = nextScheduleCandidates;
		}
		return parallelSchedule;
	}

	/**
	 * Return a map of the RAs that may execute before each PR.
	 *
	 * This is a simple type-conformance exercise. Find the sources that are supertypes of the target.
	 */
	public static <@NonNull PR extends PartialRegion<PR, TC, TP>, @NonNull TC extends TraceClass<PR, TC, TP>, @NonNull TP extends TraceProperty<PR, TC, TP>> @NonNull Map<@NonNull PR, @NonNull Set<@NonNull PR>> computeTransitivePredecessors(@NonNull Iterable<@NonNull PR> partialRegionAnalyses) {
		Map<@NonNull PR, @NonNull Set<@NonNull PR>> consumer2producers = computeImmediatePredecessors(partialRegionAnalyses);
		List<@NonNull PR> successors = Lists.newArrayList(partialRegionAnalyses);
		Collections.sort(successors, NameUtil.NAMEABLE_COMPARATOR);
		if (TransformationPartitioner.PREDECESSORS.isActive()) {
			for (@NonNull PR successor : successors) {
				StringBuilder s = new StringBuilder();
				s.append(successor + ":");
				List<@NonNull PR> producers = new ArrayList<>(consumer2producers.get(successor));
				Collections.sort(producers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PR producer : producers) {
					s.append(" " + producer);
				}
				TransformationPartitioner.PREDECESSORS.println(s.toString());
			}
		}
		Map<@NonNull PR, @NonNull Set<@NonNull PR>> consumer2producersClosure = CompilerUtil.computeClosure(consumer2producers);
		if (TransformationPartitioner.PREDECESSORS.isActive()) {
			for (@NonNull PR successor : successors) {
				StringBuilder s = new StringBuilder();
				s.append(successor + ":");
				List<@NonNull PR> producers = new ArrayList<>(consumer2producersClosure.get(successor));
				Collections.sort(producers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PR producer : producers) {
					s.append(" " + producer);
				}
				TransformationPartitioner.PREDECESSORS.println(s.toString());
			}
		}
		return consumer2producersClosure;
	}

	/**
	 * Return a map of the RAs that may execute after each PR.
	 *
	 * This is an inconvenient type-conformance exercise. Find the sources that are subtypes of the target. We therefore
	 * require the inverse computeTransitivePredecessors's result to be provided for inversion.
	 */
	public static <@NonNull PR extends Nameable/*PartialRegionAnalysis<@NonNull PR>*/> @NonNull Map<@NonNull PR, @NonNull Set<@NonNull PR>> computeTransitiveSuccessors(@NonNull Map<@NonNull PR, @NonNull Set<@NonNull PR>> partialRegion2predecessors) {
		Map<@NonNull PR, @NonNull Set<@NonNull PR>> producer2consumersClosure = new HashMap<>();
		Iterable<@NonNull PR> partialRegions = partialRegion2predecessors.keySet();
		for (@NonNull PR predecessor : partialRegions) {
			producer2consumersClosure.put(predecessor, new HashSet<>());
		}
		for (@NonNull PR successor : partialRegions) {
			Iterable<@NonNull PR> predecessors = partialRegion2predecessors.get(successor);
			assert predecessors != null;
			for (@NonNull PR predecessor : predecessors) {
				Set<@NonNull PR> successors = producer2consumersClosure.get(predecessor);
				assert successors != null;
				successors.add(successor);
			}
		}
		/*		for (@NonNull PR regionAnalysis : regionAnalyses) {
			producer2consumers.put(regionAnalysis, new HashSet<>());
		}
		for (@NonNull PR producer : regionAnalyses) {
			Iterable<@NonNull PR> successors = producer.getSuccessors();		// Used by no-success QVTc trace
			if (successors != null) {
				for (@NonNull PR successor : successors) {
					Set<@NonNull PR> consumers = producer2consumers.get(producer);
					assert consumers != null;
					consumers.add(successor);
				}
			}
			Iterable<@NonNull TC> producedTraceClassAnalyses = producer.getProducedTraceClassAnalyses();
			if (producedTraceClassAnalyses != null) {
				for (@NonNull TC producedTraceClassAnalysis : producedTraceClassAnalyses) {
					for (@NonNull TC superProducedTraceClassAnalysis : producedTraceClassAnalysis.getSuperTraceClassAnalyses()) {
						for (@NonNull PR consumer : superProducedTraceClassAnalysis.getConsumers()) {
							Set<@NonNull PR> consumers = producer2consumers.get(producer);
							assert consumers != null;
							consumers.add(consumer);
						}
					}
				}
			}
			Iterable<@NonNull TracePropertyAnalysis<@NonNull PR>> producedTracePropertyAnalyses = producer.getProducedTracePropertyAnalyses();
			if (producedTracePropertyAnalyses != null) {
				for (@NonNull TracePropertyAnalysis<@NonNull PR> producedTracePropertyAnalysis : producedTracePropertyAnalyses) {
					for (@NonNull PR consumer : producedTracePropertyAnalysis.getConsumers()) {
						Set<@NonNull PR> consumers = producer2consumers.get(producer);
						assert consumers != null;
						consumers.add(consumer);
					}
				}
			}
		}
		if (TransformationPartitioner.SUCCESSORS.isActive()) {
			for (@NonNull PR successor : regionAnalyses) {
				StringBuilder s = new StringBuilder();
				s.append(successor + ":");
				List<@NonNull PR> consumers = new ArrayList<>(producer2consumers.get(successor));
				Collections.sort(consumers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PR consumer : consumers) {
					s.append(" " + consumer);
				}
				TransformationPartitioner.SUCCESSORS.println(s.toString());
			}
		}
		Map<@NonNull PR, @NonNull Set<@NonNull PR>> producer2consumersClosure = CompilerUtil.computeClosure(producer2consumers); */
		if (TransformationPartitioner.SUCCESSORS.isActive()) {
			List<@NonNull PR> predecessors = Lists.newArrayList(partialRegions);
			Collections.sort(predecessors, NameUtil.NAMEABLE_COMPARATOR);
			for (@NonNull PR predecessor : predecessors) {
				StringBuilder s = new StringBuilder();
				s.append(predecessor + ":");
				List<@NonNull PR> consumers = new ArrayList<>(producer2consumersClosure.get(predecessor));
				Collections.sort(consumers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PR consumer : consumers) {
					s.append(" " + consumer);
				}
				TransformationPartitioner.SUCCESSORS.println(s.toString());
			}
		}
		return producer2consumersClosure;
	}

	public static @NonNull PartitionProblem createPartitionError(@NonNull Partition partition, @NonNull String messageTemplate, Object... bindings) {
		String boundMessage = StringUtil.bind(messageTemplate, bindings);
		return new PartitionProblem(CompilerProblem.Severity.ERROR, partition, boundMessage);
	}

	public static @NonNull PartitionProblem createPartitionWarning(@NonNull Partition partition, @NonNull String messageTemplate, Object... bindings) {
		String boundMessage = StringUtil.bind(messageTemplate, bindings);
		return new PartitionProblem(CompilerProblem.Severity.WARNING, partition, boundMessage);
	}

	public static @NonNull RegionProblem createRegionError(@NonNull Region region, @NonNull String messageTemplate, Object... bindings) {
		String boundMessage = StringUtil.bind(messageTemplate, bindings);
		return new RegionProblem(CompilerProblem.Severity.ERROR, region, boundMessage);
	}

	public static @NonNull RegionProblem createRegionWarning(@NonNull Region region, @NonNull String messageTemplate, Object... bindings) {
		String boundMessage = StringUtil.bind(messageTemplate, bindings);
		return new RegionProblem(CompilerProblem.Severity.WARNING, region, boundMessage);
	}

	public static @NonNull List<@NonNull PartitionAnalysis> gatherPartitionAnalyses(@NonNull CompositePartitionAnalysis rootPartitionAnalysis, @NonNull List<@NonNull PartitionAnalysis> allPartitionAnalyses) {
		for (@NonNull PartitionAnalysis partitionAnalysis : rootPartitionAnalysis.getPartitionAnalyses()) {
			assert !allPartitionAnalyses.contains(partitionAnalysis);
			if (partitionAnalysis instanceof CompositePartitionAnalysis) {
				gatherPartitionAnalyses((CompositePartitionAnalysis)partitionAnalysis, allPartitionAnalyses);
			}
			else {
				allPartitionAnalyses.add(partitionAnalysis);
			}
		}
		return allPartitionAnalyses;
	}

	public static @NonNull GenPackage getGenPackage(@NonNull ResourceSet resourceSet, @NonNull String resourcePath, @Nullable String fragment) {
		URI uri = URI.createPlatformResourceURI(resourcePath, false);
		if (fragment != null) {
			uri = uri.appendFragment(fragment);
		}
		return ClassUtil.nonNullState((GenPackage)resourceSet.getEObject(uri, true));
	}

	public static void indent(@NonNull StringBuilder s, int depth) {
		for (int i = 0; i < depth; i++) {
			s.append("    ");
		}
	}

	public static boolean isAbstract(@NonNull Partition partition) {
		Region originalRegion = partition.getRegion();
		if (originalRegion instanceof RuleRegion) {
			if (originalRegion instanceof DispatchRegion) {
				return false;
			}
			if (originalRegion instanceof VerdictRegion) {
				return false;
			}
			return ((RuleRegion)originalRegion).getReferredRule().isIsAbstract();
		}
		if (originalRegion instanceof DispatchRegion) {
			return false;
		}
		return false;
	}

	/**
	 * Normalize a list of ENamedElement by sorting according to their name.
	 *
	public static void normalize(@NonNull List<@NonNull ? extends ENamedElement> nameables) {
		if (nameables instanceof EList<?>) {
			ECollections.sort((EList<? extends ENamedElement>)nameables, NameUtil.ENamedElementComparator.INSTANCE);
		}
		else {
			Collections.sort(nameables, NameUtil.ENamedElementComparator.INSTANCE);
		}
	} */

	/**
	 * Normalize a list of Nameable by sorting according to their name.
	 */
	public static void normalizeNameables(@NonNull List<@NonNull ? extends Nameable> nameables) {
		if (nameables instanceof EList<?>) {
			ECollections.sort((EList<? extends Nameable>)nameables, NameUtil.NAMEABLE_COMPARATOR);
		}
		else {
			Collections.sort(nameables, NameUtil.NAMEABLE_COMPARATOR);
		}
	}

	/**
	 * Return the variable name associated with oclExpression, or null if none found.
	 * This enables the user's choice of name to be used for the expression node that implements it.
	 */
	public static @Nullable String recoverVariableName(@NonNull NamedElement namedElement) {
		EObject eContainer = namedElement.eContainer();
		EReference eContainmentFeature = namedElement.eContainmentFeature();
		if ((eContainmentFeature == PivotPackage.Literals.VARIABLE__OWNED_INIT) && (eContainer instanceof Variable)) {
			return ((Variable)eContainer).getName();
		}
		else if ((eContainmentFeature == QVTcorePackage.Literals.ASSIGNMENT__VALUE) && (eContainer instanceof VariableAssignment)) {
			return ((VariableAssignment)eContainer).getTargetVariable().getName();
		}
		else if ((eContainmentFeature == PivotPackage.Literals.CALL_EXP__OWNED_SOURCE) && (eContainer instanceof OperationCallExp)) {
			OperationCallExp operationCallExp = (OperationCallExp)eContainer;
			if (PivotUtil.isSameOperation(operationCallExp.getReferredOperation().getOperationId(), OperationId.OCLANY_EQUALS)) {
				OCLExpression argument = PivotUtil.getOwnedArgument(operationCallExp, 0);
				if (argument instanceof VariableExp) {
					return PivotUtil.getReferredVariable((VariableExp)argument).getName();
				}
			}
		}
		else if ((eContainmentFeature == PivotPackage.Literals.OPERATION_CALL_EXP__OWNED_ARGUMENTS) && (eContainer instanceof OperationCallExp)) {
			OperationCallExp operationCallExp = (OperationCallExp)eContainer;
			if (PivotUtil.isSameOperation(operationCallExp.getReferredOperation().getOperationId(), OperationId.OCLANY_EQUALS)) {
				OCLExpression source = PivotUtil.getOwnedSource(operationCallExp);
				if (source instanceof VariableExp) {
					return PivotUtil.getReferredVariable((VariableExp)source).getName();
				}
			}
		}
		return null;
	}

	public static <T> void removeAll(@NonNull Collection<T> removeFrom, @NonNull Iterable<T> elementsToTemove) {
		for (T element : elementsToTemove) {
			removeFrom.remove(element);
		}
	}

	public static void throwExceptionWithProblems(@NonNull CodeGenerator codeGenerator, @NonNull Exception e) throws Exception {
		List<@NonNull Exception> problems = codeGenerator.getProblems();
		if (problems != null) {
			StringBuilder s = new StringBuilder();
			for (@NonNull Exception ex : problems) {
				s.append(ex.toString() + "\n");
			}
			s.append(e.toString());
			throw new CompilerChainException(e, s.toString());
		}
		else {
			throw e;
		}
	}
}