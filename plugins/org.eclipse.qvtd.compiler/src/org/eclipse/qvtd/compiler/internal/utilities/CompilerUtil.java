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

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil.UnresolvedProxyCrossReferencer;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
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
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionProblem;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TraceClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TracePropertyAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TransformationPartitioner;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

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
			assertNoValidationErrors(prefix, eObject);
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
		s.append(children.size() + " validation errors");
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
	 * Return a new list of project names that need to be on the class path.
	 */
	public static @NonNull List<@NonNull String> createClasspathProjectNameList(@NonNull String... projectNames) {
		List<@NonNull String> classProjectNames = new ArrayList<>();
		classProjectNames.add("org.eclipse.qvtd.runtime");
		classProjectNames.add("org.eclipse.ocl.pivot");
		classProjectNames.add("org.eclipse.emf.ecore");
		classProjectNames.add("org.eclipse.emf.common");
		classProjectNames.add("org.eclipse.jdt.annotation");
		classProjectNames.add("org.eclipse.osgi");
		if (projectNames != null) {
			for (@NonNull String projectName : projectNames) {
				classProjectNames.add(0, projectName);
			}
		}
		return classProjectNames;
	}

	public static @NonNull List<@NonNull String> createClassPathProjectList(@NonNull URIConverter uriConverter, @NonNull List<@NonNull String> projectNames) {
		List<@NonNull String> classpathProjectList = new ArrayList<@NonNull String>();
		for (@NonNull String projectName : projectNames) {
			File path = JavaFileUtil.getProjectBinFolder(uriConverter, projectName);
			if (path != null) {
				classpathProjectList.add(String.valueOf(path));
			}
		}
		//		}
		return classpathProjectList;
	}

	/**
	 * Return the classpath folders corresponding to the projectNames, except that the projectName uses an explicit and
	 * possibly irregular classFilePath allowing the current project to use a non-standard 'bin' folder to avoid confusion
	 * between the test compilation and the auto-build.
	 */
	public static @NonNull List<@NonNull String> createClassPathProjectList(@NonNull URIConverter uriConverter, @NonNull String projectName,
			@NonNull String classFilePath, @Nullable Iterable<@NonNull String> projectNames) {
		assert EcorePlugin.IS_ECLIPSE_RUNNING;
		if (projectNames == null) {
			projectNames = CompilerUtil.createClasspathProjectNameList(projectName);
		}
		List<@NonNull String> projectNames2 = Lists.newArrayList(projectNames);
		projectNames2.remove(projectName);
		List<@NonNull String> classpathProjects = JavaFileUtil.createClassPathProjectList(uriConverter, projectNames2);
		classpathProjects.add(0, classFilePath);
		return classpathProjects;
	}

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
	 * Return a map of the RegionAnalyses that may execute before each RA.
	 */
	public static <@NonNull RA extends PartialRegionAnalysis<@NonNull RA>> @NonNull Map<@NonNull RA, @NonNull Set<@NonNull RA>> computeTransitivePredecessors(@NonNull Iterable<@NonNull RA> regionAnalyses) {
		Map<@NonNull RA, @NonNull Set<@NonNull RA>> consumer2producers = new HashMap<>();
		for (@NonNull RA regionAnalysis : regionAnalyses) {
			consumer2producers.put(regionAnalysis, new HashSet<>());
		}
		for (@NonNull RA consumer : regionAnalyses) {
			Iterable<@NonNull TraceClassAnalysis<@NonNull RA>> consumedTraceClassAnalyses = consumer.getConsumedTraceClassAnalyses();
			if (consumedTraceClassAnalyses != null) {
				for (@NonNull TraceClassAnalysis<@NonNull RA> consumedTraceClassAnalysis : consumedTraceClassAnalyses) {
					for (@NonNull TraceClassAnalysis<@NonNull RA> subConsumedTraceClass : consumedTraceClassAnalysis.getSubTraceClassAnalyses()) {
						for (@NonNull RA producer : subConsumedTraceClass.getProducers()) {
							Set<@NonNull RA> producers = consumer2producers.get(consumer);
							assert producers != null;
							producers.add(producer);
						}
					}
				}
			}
			Iterable<@NonNull TracePropertyAnalysis<@NonNull RA>> consumedTracePropertyAnalyses = consumer.getConsumedTracePropertyAnalyses();
			if (consumedTracePropertyAnalyses != null) {
				for (@NonNull TracePropertyAnalysis<@NonNull RA> consumedTracePropertyAnalysis : consumedTracePropertyAnalyses) {
					for (@NonNull RA producer : consumedTracePropertyAnalysis.getProducers()) {
						Set<@NonNull RA> producers = consumer2producers.get(consumer);
						assert producers != null;
						producers.add(producer);
					}
				}
			}
		}
		if (TransformationPartitioner.PREDECESSORS.isActive()) {
			for (@NonNull RA successor : regionAnalyses) {
				StringBuilder s = new StringBuilder();
				s.append(successor + ":");
				List<@NonNull RA> producers = new ArrayList<>(consumer2producers.get(successor));
				Collections.sort(producers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull RA producer : producers) {
					s.append(" " + producer);
				}
				TransformationPartitioner.PREDECESSORS.println(s.toString());
			}
		}
		Map<@NonNull RA, @NonNull Set<@NonNull RA>> consumer2producersClosure = CompilerUtil.computeClosure(consumer2producers);
		if (TransformationPartitioner.PREDECESSORS.isActive()) {
			for (@NonNull RA successor : regionAnalyses) {
				StringBuilder s = new StringBuilder();
				s.append(successor + ":");
				List<@NonNull RA> producers = new ArrayList<>(consumer2producersClosure.get(successor));
				Collections.sort(producers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull RA producer : producers) {
					s.append(" " + producer);
				}
				TransformationPartitioner.PREDECESSORS.println(s.toString());
			}
		}
		return consumer2producersClosure;
	}

	/**
	 * Return a map of the RegionAnalyses that may execute after each RA.
	 */
	public static <@NonNull RA extends PartialRegionAnalysis<@NonNull RA>> @NonNull Map<@NonNull RA, @NonNull Set<@NonNull RA>> computeTransitiveSuccessors(@NonNull Iterable<@NonNull RA> regionAnalyses) {
		Map<@NonNull RA, @NonNull Set<@NonNull RA>> producer2consumers = new HashMap<>();
		for (@NonNull RA regionAnalysis : regionAnalyses) {
			producer2consumers.put(regionAnalysis, new HashSet<>());
		}
		for (@NonNull RA producer : regionAnalyses) {
			Iterable<@NonNull TraceClassAnalysis<@NonNull RA>> producedTraceClassAnalyses = producer.getProducedTraceClassAnalyses();
			if (producedTraceClassAnalyses != null) {
				for (@NonNull TraceClassAnalysis<@NonNull RA> producedTraceClassAnalysis : producedTraceClassAnalyses) {
					for (@NonNull TraceClassAnalysis<@NonNull RA> superProducedTraceClassAnalysis : producedTraceClassAnalysis.getSuperTraceClassAnalyses()) {
						for (@NonNull RA consumer : superProducedTraceClassAnalysis.getConsumers()) {
							Set<@NonNull RA> consumers = producer2consumers.get(producer);
							assert consumers != null;
							consumers.add(consumer);
						}
					}
				}
			}
			Iterable<@NonNull TracePropertyAnalysis<@NonNull RA>> producedTracePropertyAnalyses = producer.getProducedTracePropertyAnalyses();
			if (producedTracePropertyAnalyses != null) {
				for (@NonNull TracePropertyAnalysis<@NonNull RA> producedTracePropertyAnalysis : producedTracePropertyAnalyses) {
					for (@NonNull RA consumer : producedTracePropertyAnalysis.getConsumers()) {
						Set<@NonNull RA> consumers = producer2consumers.get(producer);
						assert consumers != null;
						consumers.add(consumer);
					}
				}
			}
		}
		if (TransformationPartitioner.SUCCESSORS.isActive()) {
			for (@NonNull RA successor : regionAnalyses) {
				StringBuilder s = new StringBuilder();
				s.append(successor + ":");
				List<@NonNull RA> consumers = new ArrayList<>(producer2consumers.get(successor));
				Collections.sort(consumers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull RA consumer : consumers) {
					s.append(" " + consumer);
				}
				TransformationPartitioner.SUCCESSORS.println(s.toString());
			}
		}
		Map<@NonNull RA, @NonNull Set<@NonNull RA>> producer2consumersClosure = CompilerUtil.computeClosure(producer2consumers);
		if (TransformationPartitioner.SUCCESSORS.isActive()) {
			for (@NonNull RA predecessor : regionAnalyses) {
				StringBuilder s = new StringBuilder();
				s.append(predecessor + ":");
				List<@NonNull RA> consumers = new ArrayList<>(producer2consumersClosure.get(predecessor));
				Collections.sort(consumers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull RA consumer : consumers) {
					s.append(" " + consumer);
				}
				TransformationPartitioner.SUCCESSORS.println(s.toString());
			}
		}
		return producer2consumersClosure;
	}

	public static @NonNull RegionProblem createRegionError(@NonNull Region region, @NonNull String messageTemplate, Object... bindings) {
		String boundMessage = StringUtil.bind(messageTemplate, bindings);
		return new RegionProblem(CompilerProblem.Severity.ERROR, region, boundMessage);
	}

	public static @NonNull RegionProblem createRegionWarning(@NonNull Region region, @NonNull String messageTemplate, Object... bindings) {
		String boundMessage = StringUtil.bind(messageTemplate, bindings);
		return new RegionProblem(CompilerProblem.Severity.WARNING, region, boundMessage);
	}

	public static void indent(@NonNull StringBuilder s, int depth) {
		for (int i = 0; i < depth; i++) {
			s.append("    ");
		}
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