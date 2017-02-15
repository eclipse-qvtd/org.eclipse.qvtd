/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerChain.Key;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.merger.EarlyMerger;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.DOTStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphMLStringBuilder;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatumAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.impl.OperationRegionImpl;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;

import com.google.common.collect.Iterables;

public class QVTm2QVTs extends ScheduleModel2
{
	public static final @NonNull TracingOption DEBUG_GRAPHS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/debugGraphs");
	public static final @NonNull TracingOption DUMP_CLASS_TO_CONSUMING_NODES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/dump/class2consumingNodes");
	public static final @NonNull TracingOption DUMP_CLASS_TO_CONTAINING_PROPERTIES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/dump/class2containingProperty");
	public static final @NonNull TracingOption DUMP_CLASS_TO_REALIZED_NODES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/dump/class2realizedNodes");
	public static final @NonNull TracingOption DUMP_INPUT_MODEL_TO_DOMAIN_USAGE = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/dump/inputModel2domainUsage");
	public static final @NonNull TracingOption DUMP_PROPERTY_TO_CONSUMING_CLASSES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/dump/property2consumingClass");
	public static final @NonNull TracingOption EDGE_ORDER = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/edgeOrder");
	public static final @NonNull TracingOption REGION_CYCLES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/regionCycles");
	public static final @NonNull TracingOption REGION_DEPTH = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/regionDepth");
	//	public static final @NonNull TracingOption REGION_LOCALITY = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/regionLocality");
	public static final @NonNull TracingOption REGION_ORDER = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/regionOrder");
	public static final @NonNull TracingOption REGION_STACK = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/regionStack");
	public static final @NonNull TracingOption REGION_TRAVERSAL = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/regionTraversal");

	protected final @NonNull ProblemHandler problemHandler;

	/**
	 * The Region to which each mapping is allocated.
	 */
	private final @NonNull Map<@NonNull Mapping, @NonNull MappingAnalysis> mapping2mappingAnalysis = new HashMap<>();

	private Map<@NonNull OperationDatum, @NonNull OperationRegion> operationDatum2operationRegion = new HashMap<>();

	public QVTm2QVTs(@NonNull ProblemHandler problemHandler, @NonNull EnvironmentFactory environmentFactory, @NonNull Transformation asTransformation,
			@Nullable Map<@NonNull Key<? extends Object>, @Nullable Object> schedulerOptions) {
		super(environmentFactory, asTransformation, schedulerOptions);
		this.problemHandler = problemHandler;
	}

	public void addProblem(@NonNull CompilerProblem problem) {
		problemHandler.addProblem(problem);
	}

	@Override
	public void addRegionError(@NonNull Region region, @NonNull String messageTemplate, Object... bindings) {
		addProblem(RegionUtil.createRegionError(region, messageTemplate, bindings));
	}

	public @NonNull OperationRegion analyzeOperation(@NonNull ScheduleModel scheduleModel, @NonNull OperationCallExp operationCallExp) {
		Operation operation = operationCallExp.getReferredOperation();
		LanguageExpression bodyExpression = operation.getBodyExpression();
		assert  bodyExpression != null;
		ExpressionInOCL specification;
		try {
			specification = getEnvironmentFactory().getMetamodelManager().parseSpecification(bodyExpression);
			OperationDatum operationDatum = createOperationDatum(operationCallExp);
			OperationRegion operationRegion = operationDatum2operationRegion.get(operationDatum);
			if (operationRegion == null) {
				operationRegion = createOperationRegion(scheduleModel, operationCallExp, specification, operationDatum);
				operationDatum2operationRegion.put(operationDatum, operationRegion);
				if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
					operationRegion.writeDebugGraphs(null);
				}
			}
			return operationRegion;
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UnsupportedOperationException(e);
		}
	}

	private @NonNull OperationDatum createOperationDatum(@NonNull OperationCallExp operationCallExp) {
		List<@NonNull OCLExpression> ownedArguments = ClassUtil.nullFree(operationCallExp.getOwnedArguments());
		@NonNull ClassDatum[] classDatums = new @NonNull ClassDatum[1 + ownedArguments.size()];
		int i = 0;
		@SuppressWarnings("null")@NonNull OCLExpression source = operationCallExp.getOwnedSource();
		classDatums[i++] = getClassDatum(source);
		for (@NonNull OCLExpression argument : ownedArguments) {
			classDatums[i++] = getClassDatum(argument);
		}
		String operationName = operationCallExp.getReferredOperation().getName();
		assert operationName != null;
		return new OperationDatum(this, operationName, classDatums);
	}

	private @NonNull Node createOperationParameterNode(@NonNull OperationRegion operationRegion, @NonNull Variable variable, @NonNull String name, @NonNull OCLExpression expression) {
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)expression.getType();
		assert type != null;
		TypedModel typedModel = getDomainUsage(expression).getTypedModel(expression);
		assert typedModel != null;
		ClassDatumAnalysis classDatumAnalysis = getClassDatumAnalysis(type, typedModel);
		Node parameterNode = RegionUtil.createOperationParameterNode(operationRegion, name, classDatumAnalysis);
		//		addVariableNode(variable, parameterNode);
		operationRegion.addHeadNode(parameterNode);
		return parameterNode;
	}

	private @NonNull Node createOperationParameterNode(@NonNull OperationRegion operationRegion, @NonNull ClassDatumAnalysis classDatumAnalysis, @NonNull String name) {
		Node parameterNode = RegionUtil.createOperationParameterNode(operationRegion, name, classDatumAnalysis);
		//		addVariableNode(variable, parameterNode);
		operationRegion.addHeadNode(parameterNode);
		return parameterNode;
	}

	protected @NonNull OperationRegion createOperationRegion(@NonNull ScheduleModel scheduleModel, @NonNull OperationCallExp operationCallExp,
			@NonNull ExpressionInOCL specification, @NonNull OperationDatum operationDatum) {
		Map<@NonNull VariableDeclaration, @NonNull Node> parameter2node = new HashMap<>();
		String operationName = ClassUtil.nonNullState(operationDatum.toString());
		OperationRegion operationRegion = QVTscheduleFactory.eINSTANCE.createOperationRegion();
		((OperationRegionImpl)operationRegion).setFixmeScheduleModel(scheduleModel);
		operationRegion.setOperation(ClassUtil.nonNullState(operationCallExp.getReferredOperation()));
		operationRegion.setName(operationName);
		//
		Variable selfVariable = specification.getOwnedContext();
		OCLExpression source = operationCallExp.getOwnedSource();
		assert source != null;
		Node selfNode = createOperationParameterNode(operationRegion, selfVariable, ClassUtil.nonNullState(selfVariable.getName()), source);
		parameter2node.put(selfVariable, selfNode);
		Node dependencyNode;
		dependencyNode = selfNode;
		//
		Node resultNode = RegionUtil.createStepNode("result", operationCallExp, dependencyNode, false);
		operationRegion.setResultNode(resultNode);
		RegionUtil.createExpressionEdge(dependencyNode, QVTscheduleConstants.EQUALS_NAME, resultNode);
		//
		List<Variable> ownedParameters = specification.getOwnedParameters();
		List<OCLExpression> ownedArguments = operationCallExp.getOwnedArguments();
		int iSize = Math.min(ownedArguments.size(), ownedParameters.size());
		for (int i = 0; i < iSize; i++) {
			Variable parameter = ownedParameters.get(i);
			Node parameterNode = createOperationParameterNode(operationRegion, parameter, ClassUtil.nonNullState(parameter.getName()), ClassUtil.nonNullState(ownedArguments.get(i)));
			parameter2node.put(parameter, parameterNode);
		}
		//
		OperationDependencyAnalysis operationDependencyAnalysis = getOperationDependencyAnalysis();
		//		OperationDependencyAnalysis operationDependencyAnalysis = new OperationDependencyAnalysis(scheduleModel);
		//		operationDependencyAnalysis.dump();
		OperationDependencyPaths paths = operationDependencyAnalysis.analyzeOperation(operationCallExp);
		//		operationDependencyAnalysis.dump();
		//		System.out.println("Analyze2 " + operationCallExp + " gives\n\t" + paths);
		Iterable<@NonNull List<org.eclipse.qvtd.compiler.internal.qvtm2qvts.OperationDependencyStep>> hiddenPaths = paths.getHiddenPaths();
		Iterable<@NonNull List<org.eclipse.qvtd.compiler.internal.qvtm2qvts.OperationDependencyStep>> returnPaths = paths.getReturnPaths();
		RootDomainUsageAnalysis domainAnalysis = getDomainAnalysis();
		Map<@NonNull ClassDatumAnalysis, @NonNull Node> classDatumAnalysis2node = new HashMap<>();
		for (List<org.eclipse.qvtd.compiler.internal.qvtm2qvts.OperationDependencyStep> steps : Iterables.concat(returnPaths, hiddenPaths)) {
			if (steps.size() > 0) {
				boolean isDirty = false;
				for (int i = 1; i < steps.size(); i++) {
					OperationDependencyStep.PropertyStep step = (OperationDependencyStep.PropertyStep) steps.get(i);
					Property asProperty = step.getProperty();
					if (domainAnalysis.isDirty(asProperty)) {
						isDirty = true;
						break;
					}
				}
				OperationDependencyStep.ClassStep classStep = (OperationDependencyStep.ClassStep) steps.get(0);
				DomainUsage stepUsage = classStep.getUsage();
				if (stepUsage.isOutput() && !stepUsage.isInput() || isDirty) {
					//					System.out.println("!checkable && enforceable: " + steps);
					org.eclipse.ocl.pivot.Class stepType = steps.get(0).getElementalType();
					TypedModel typedModel = stepUsage.getTypedModel(classStep.getElement());
					assert typedModel != null;
					ClassDatumAnalysis classDatumAnalysis = getClassDatumAnalysis(stepType, typedModel);
					CompleteClass completeClass = classDatumAnalysis.getCompleteClass();
					Type primaryClass = completeClass.getPrimaryClass();
					if (!(primaryClass instanceof DataType) && !(primaryClass instanceof VoidType)) {
						//					OCLExpression source = operationCallExp.getOwnedSource();
						//					assert source != null;
						//					createParameterNode(selfVariable, selfVariable.getName(), source);
						Node dependencyNode2;
						if (classStep.isParameter()) {
							dependencyNode2 = parameter2node.get(classStep.getElement());
							assert dependencyNode2 != null;
						}
						else {
							dependencyNode2 = classDatumAnalysis2node.get(classDatumAnalysis);
							if (dependencyNode2 == null) {
								assert !"OclVoid".equals(stepType.getName());
								dependencyNode2 = createOperationParameterNode(operationRegion, classDatumAnalysis, "extra2_" + stepType.getName());
								classDatumAnalysis2node.put(classDatumAnalysis, dependencyNode2);
								operationRegion.addDependencyNode(dependencyNode2);
							}
						}
						//					dependencyNodes.add(dependencyNode);
						for (int i = 1; i < steps.size(); i++) {
							OperationDependencyStep.PropertyStep step = (OperationDependencyStep.PropertyStep) steps.get(i);
							Property property = step.getProperty();
							CallExp callExp = step.getCallExp();
							assert (property != null) && (callExp != null);
							//						stepUsage = propertyStep.getUsage();
							//						typedModel = stepUsage.getTypedModel();
							//						assert typedModel != null;
							//						stepType = propertyStep.getType();
							//						classDatumAnalysis = scheduleModel.getClassDatumAnalysis(stepType, typedModel);
							//						Node nextNode = RegionUtil.StepNodeRoleFactory.PREDICATED_STEP.createNode(this, "next", classDatumAnalysis);

							if (primaryClass instanceof CollectionType) {
								Property iterateProperty = getIterateProperty(primaryClass);
								Type elementType = PivotUtil.getElementType((CollectionType)primaryClass);
								TypedModel typedModel2 = RegionUtil.getTypedModel(classDatumAnalysis);
								ClassDatumAnalysis elementClassDatumAnalysis = getClassDatumAnalysis((org.eclipse.ocl.pivot.Class) elementType, typedModel2);
								Node elementNode = RegionUtil.createOperationElementNode(operationRegion, operationName, elementClassDatumAnalysis, dependencyNode2);
								//(region, name, typedElement, argNodes)Node(region, name, callExp, sourceNode)Node(this, name, iterateProperty, dependencyNode2);
								RegionUtil.createNavigationEdge(dependencyNode2, iterateProperty, elementNode, false);
								dependencyNode2 = elementNode;
							}
							//							assert !dependencyNode2.isMatched();
							Node nextNode;			// FIXME re-use shared paths
							if (callExp instanceof NavigationCallExp) {
								nextNode = RegionUtil.createDataTypeNode(dependencyNode2, (NavigationCallExp)callExp);
							}
							else {
								nextNode = RegionUtil.createDataTypeNode(dependencyNode2, property);
							}
							RegionUtil.createNavigationEdge(dependencyNode2, property, nextNode, false);
							dependencyNode2 = nextNode;
						}
					}
				}
				else {
					//					System.out.println("checkable || !enforceable: " + steps);
				}
			}
		}
		//
		operationRegion.toGraph(new DOTStringBuilder());
		operationRegion.toGraph(new GraphMLStringBuilder());
		return operationRegion;
	}

	@Override
	protected @NonNull ClassDatumAnalysis createClassDatumAnalysis(@NonNull ClassDatum classDatum) {
		ClassDatumAnalysis classDatumAnalysis = QVTscheduleFactory.eINSTANCE.createClassDatumAnalysis();
		classDatumAnalysis.setScheduleModel(this);
		classDatumAnalysis.setClassDatum(classDatum);
		return classDatumAnalysis;
	}

	public @NonNull MappingRegion getMappingRegion(@NonNull Mapping mapping) {
		MappingAnalysis mappingAnalysis = mapping2mappingAnalysis.get(mapping);
		assert mappingAnalysis != null;
		return mappingAnalysis.getMappingRegion();
	}

	public @NonNull List<@NonNull Region> transform() throws IOException {
		Iterable<@NonNull Mapping> orderedMappings = getOrderedMappings();
		//
		//	Extract salient characteristics from within each MappingAction.
		//
		for (@NonNull Mapping mapping : orderedMappings) {
			MappingAnalysis mappingRegion = MappingAnalysis.createMappingRegion(this, mapping);
			mapping2mappingAnalysis.put(mapping, mappingRegion);
		}
		List<@NonNull MappingAnalysis> mappingAnalyses = new ArrayList<>(mapping2mappingAnalysis.values());
		Collections.sort(mappingAnalyses, NameUtil.NAMEABLE_COMPARATOR);		// Stabilize side effect of symbol name disambiguator suffixes
		for (@NonNull MappingAnalysis mappingRegion : mappingAnalyses) {
			mappingRegion.registerConsumptionsAndProductions(this);
		}
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			for (@NonNull MappingAnalysis mappingAnalysis : mappingAnalyses) {
				mappingAnalysis.getMappingRegion().writeDebugGraphs(null);
			}
		}
		List<@NonNull MappingRegion> orderedRegions = new ArrayList<>();
		for (@NonNull Mapping mapping : orderedMappings) {
			MappingAnalysis mappingAnalysis = mapping2mappingAnalysis.get(mapping);
			assert mappingAnalysis != null;
			orderedRegions.add(mappingAnalysis.getMappingRegion());
			//			mappingRegion.resolveRecursion();
		}
		boolean noEarlyMerge = isNoEarlyMerge();
		List<@NonNull Region> activeRegions = new ArrayList<>(noEarlyMerge ? orderedRegions : EarlyMerger.merge(orderedRegions));
		//		for (@NonNull Region activeRegion : activeRegions) {
		//			((AbstractRegion)activeRegion).resolveRecursion();
		//		}
		//		for (@NonNull OperationRegion operationRegion : multiRegion.getOperationRegions()) {
		//			activeRegions.add(operationRegion);
		//		}
		//		multiRegion.setActiveRegions(activeRegions);
		return activeRegions;
	}
}
