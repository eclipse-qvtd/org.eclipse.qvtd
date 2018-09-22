/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.NameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.QVTrelationNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.Partition;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.DOTStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphMLStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseLibraryHelper;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtbase.utilities.StandardLibraryHelper;
import org.eclipse.qvtd.pivot.qvtbase.utilities.TraceHelper;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.Graphable;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.ToCallGraphVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.ToRegionGraphVisitor;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public abstract class AbstractScheduleManager implements ScheduleManager
{
	protected final @NonNull ScheduleModel scheduleModel;
	protected final @NonNull EnvironmentFactory environmentFactory;
	protected final @NonNull ProblemHandler problemHandler;
	protected final @NonNull NameGenerator nameGenerator;
	private @Nullable TraceHelper traceHelper = null;
	private CompilerOptions.@Nullable StepOptions schedulerOptions;
	protected final @NonNull RootDomainUsageAnalysis domainUsageAnalysis;
	protected final @NonNull DatumCaches datumCaches;
	protected final @NonNull StandardLibraryHelper standardLibraryHelper;
	protected final @NonNull QVTbaseLibraryHelper qvtbaseLibraryHelper;

	private @Nullable ClassDatum booleanClassDatum;
	private @Nullable ClassDatum oclVoidClassDatum;

	/**
	 * The extended analysis of each ClassDatum.
	 */
	private final @NonNull Set<@NonNull ClassDatum> classDatums = new HashSet<>();

	/**
	 * Property used as a navigation to cast to a specific type.
	 */
	private final @NonNull Map<Type, Property> type2castProperty = new HashMap<>();

	/**
	 * Property used as a navigation to iterate collection elements.
	 */
	private final @NonNull Map<Type, Property> type2iterateProperty = new HashMap<>();

	/**
	 * Property used as an argument role identification.
	 */
	private final @NonNull Map<String, Property> name2argumentProperty = new HashMap<>();

	/**
	 * The producing/consuming characteristics of each original (unpartitioned) region.
	 */
	private @Nullable LegacyContentsAnalysis originalContentsAnalysis = null;

	private /*@LazyNonNull */ OperationDependencyAnalysis operationDependencyAnalysis = null;

	private Map<@NonNull OperationDatum, @NonNull OperationRegion> operationDatum2operationRegion = new HashMap<>();

	private final @NonNull Map<@NonNull Transformation, @NonNull AbstractTransformationAnalysis> transformation2transformationAnalysis = new HashMap<>();
	private final boolean doDotGraphs;
	private final boolean doYedGraphs;

	//	private final @NonNull Map<@NonNull TransformationAnalysis, @NonNull TransformationAnalysis2TracePackage> transformationAnalysis2transformationAnalysis2tracePackage = new HashMap<>();

	protected AbstractScheduleManager(@NonNull ScheduleModel scheduleModel, @NonNull EnvironmentFactory environmentFactory,
			@NonNull ProblemHandler problemHandler, CompilerOptions.@Nullable StepOptions schedulerOptions) {
		this.scheduleModel = scheduleModel;
		this.environmentFactory = environmentFactory;
		this.problemHandler = problemHandler;
		this.nameGenerator = createNameGenerator();
		this.schedulerOptions = schedulerOptions;
		this.domainUsageAnalysis = createDomainUsageAnalysis();
		this.standardLibraryHelper = new StandardLibraryHelper(environmentFactory.getStandardLibrary());
		this.qvtbaseLibraryHelper = new QVTbaseLibraryHelper();
		this.datumCaches = createDatumCaches();
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			this.doDotGraphs = true;
			this.doYedGraphs = true;
		}
		else if (schedulerOptions != null) {
			this.doDotGraphs = schedulerOptions.basicGet(CompilerChain.SCHEDULER_DOT_GRAPHS) == Boolean.TRUE;
			this.doYedGraphs = schedulerOptions.basicGet(CompilerChain.SCHEDULER_YED_GRAPHS) == Boolean.TRUE;
		}
		else {
			this.doDotGraphs = false;
			this.doYedGraphs = false;
		}
	}

	@Override
	public void addMappingRegion(@NonNull MappingRegion mappingRegion) {
		scheduleModel.getOwnedMappingRegions().add(mappingRegion);
	}

	@Override
	public void addPartitionError(@NonNull Partition partition, @NonNull String messageTemplate, Object... bindings) {
		problemHandler.addProblem(CompilerUtil.createPartitionError(partition, messageTemplate, bindings));
	}

	@Override
	public void addPartitionWarning(@NonNull Partition partition, @NonNull String messageTemplate, Object... bindings) {
		problemHandler.addProblem(CompilerUtil.createPartitionWarning(partition, messageTemplate, bindings));
	}

	@Override
	public void addProblem(@NonNull CompilerProblem problem) {
		problemHandler.addProblem(problem);
	}

	@Override
	public void addRegionError(@NonNull Region region, @NonNull String messageTemplate, Object... bindings) {
		problemHandler.addProblem(CompilerUtil.createRegionError(region, messageTemplate, bindings));
	}

	@Override
	public void addRegionWarning(@NonNull Region region, @NonNull String messageTemplate, Object... bindings) {
		problemHandler.addProblem(CompilerUtil.createRegionWarning(region, messageTemplate, bindings));
	}

	@Override
	public @NonNull AbstractTransformationAnalysis addTransformation(@NonNull Transformation asTransformation) {
		AbstractTransformationAnalysis transformationAnalysis = createTransformationAnalysis(asTransformation);
		TypedModel primitiveTypeModel = domainUsageAnalysis.getPrimitiveTypeModel();
		asTransformation.getModelParameter().add(primitiveTypeModel);
		transformation2transformationAnalysis.put(asTransformation, transformationAnalysis);
		return transformationAnalysis;
	}

	private void analyzeCallTree() {
		LegacyContentsAnalysis originalContentsAnalysis = getOriginalContentsAnalysis();
		Map<@NonNull Rule, @NonNull List<@NonNull Rule>> consumer2producers = new HashMap<>();
		List<@NonNull ClassDatum> middleClassDatums = new ArrayList<>();
		StringBuilder s = QVTm2QVTs.CALL_TREE.isActive() ? new StringBuilder() : null;
		for (@NonNull ClassDatum classDatum : QVTscheduleUtil.getOwnedClassDatums(scheduleModel)) {
			TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
			DomainUsage usage = domainUsageAnalysis.getUsage(typedModel);
			if (usage.isMiddle()) {
				middleClassDatums.add(classDatum);
				if (s != null) {
					s.append("middle: " + originalContentsAnalysis.getProducingRegions(classDatum) + "\n");
				}
				Iterable<@NonNull RuleRegion> contentsGetConsumingRegions = originalContentsAnalysis.getConsumingRegions(classDatum);
				for (@NonNull RuleRegion consumingRegion : contentsGetConsumingRegions) {
					Rule consumer = QVTscheduleUtil.getReferredRule(consumingRegion);
					List<@NonNull Rule> producers = consumer2producers.get(consumer);
					if (producers == null) {
						producers = new ArrayList<>();
						consumer2producers.put(consumer, producers);
					}
					Iterable<@NonNull RuleRegion> contentsGetProducingRegions = originalContentsAnalysis.getProducingRegions(classDatum);
					for (@NonNull RuleRegion producingRegion : contentsGetProducingRegions) {
						Rule producer = QVTscheduleUtil.getReferredRule(producingRegion);
						if (!producers.contains(producer)) {
							producers.add(producer);
						}
					}
				}
			}
		}
		if (s != null) {
			s.append("consumer2producers: " + consumer2producers);
			QVTm2QVTs.CALL_TREE.println(s.toString());
		}
	}

	@Override
	public void analyzeCompletePackage(@NonNull TypedModel typedModel, @NonNull CompletePackage completePackage) {
		//		domainUsageAnalysis.analyzeTracePackage(typedModel, tracePackage);
		datumCaches.analyzeCompletePackage(typedModel, completePackage);
	}

	@Override
	public @NonNull OperationRegion analyzeOperation(@NonNull OperationCallExp operationCallExp) {
		Operation operation = operationCallExp.getReferredOperation();
		LanguageExpression bodyExpression = operation.getBodyExpression();
		assert  bodyExpression != null;
		ExpressionInOCL specification;
		try {
			specification = ((EnvironmentFactoryInternalExtension)environmentFactory).parseSpecification(bodyExpression);
			OperationDatum operationDatum = createOperationDatum(operationCallExp);
			OperationRegion operationRegion = operationDatum2operationRegion.get(operationDatum);
			if (operationRegion == null) {
				operationRegion = createOperationRegion(this, operationCallExp, specification, operationDatum);
				operationDatum2operationRegion.put(operationDatum, operationRegion);
				writeDebugGraphs(operationRegion, null);
			}
			return operationRegion;
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public @NonNull LegacyContentsAnalysis analyzeOriginalContents() {
		LegacyContentsAnalysis contentsAnalysis = new LegacyContentsAnalysis(this);
		List<@NonNull MappingRegion> mappingRegions = Lists.newArrayList(QVTscheduleUtil.getOwnedMappingRegions(getScheduleModel()));
		Collections.sort(mappingRegions, NameUtil.NAMEABLE_COMPARATOR);		// Stabilize side effect of symbol name disambiguator suffixes
		for (@NonNull MappingRegion mappingRegion : mappingRegions) {
			RuleRegion ruleRegion = (RuleRegion) mappingRegion;
			contentsAnalysis.addRegion(ruleRegion);
			Transformation transformation = QVTbaseUtil.getOwningTransformation(QVTscheduleUtil.getReferredRule(ruleRegion));
			AbstractTransformationAnalysis transformationAnalysis = getTransformationAnalysis(transformation);
			transformationAnalysis.getRegionAnalysis(mappingRegion);
		}
		for (@NonNull AbstractTransformationAnalysis transformationAnalysis : getTransformationAnalyses()) {
			transformationAnalysis.computeTraceClassInheritance();
		}
		this.originalContentsAnalysis = contentsAnalysis;
		return contentsAnalysis;
	}

	@Override
	public void analyzeSourceModel() {
		for (@NonNull AbstractTransformationAnalysis transformationAnalysis : getOrderedTransformationAnalyses()) {
			domainUsageAnalysis.analyzeTransformation(transformationAnalysis.getTransformation());
			transformationAnalysis.analyzeSourceModel();
		}
	}

	@Override
	public void analyzeTracePackage(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Package tracePackage) {
		domainUsageAnalysis.analyzeTracePackage(typedModel, tracePackage);
		CompleteModel completeModel = environmentFactory.getCompleteModel();
		CompletePackage completePackage = completeModel.getCompletePackage(tracePackage);
		datumCaches.analyzeCompletePackage(typedModel, completePackage);
	}

	@Override
	public @NonNull Map<@NonNull ScheduledRegion, @NonNull Iterable<@NonNull RuleRegion>> analyzeTransformations() {
		Map<@NonNull ScheduledRegion, @NonNull Iterable<@NonNull RuleRegion>> scheduledRegion2activeRegions = new HashMap<>();
		for (@NonNull AbstractTransformationAnalysis transformationAnalysis : getOrderedTransformationAnalyses()) {
			Iterable<@NonNull RuleRegion> activeRegions = transformationAnalysis.gatherRuleRegions();
			scheduledRegion2activeRegions.put(transformationAnalysis.getScheduledRegion(), activeRegions);
		}
		analyzeCallTree();
		return scheduledRegion2activeRegions;
	}

	@Override
	public @Nullable Property basicGetGlobalSuccessProperty(@NonNull Node node) {
		if (!isMiddle(node)) {
			return null;
		}
		CompleteClass completeClass = node.getCompleteClass();
		return completeClass.getProperty(QVTrelationNameGenerator.TRACE_GLOBAL_SUCCESS_PROPERTY_NAME);
	}

	@Override
	public @Nullable Property basicGetLocalSuccessProperty(@NonNull Node node) {
		if (!isMiddle(node)) {
			return null;
		}
		CompleteClass completeClass = node.getCompleteClass();
		return completeClass.getProperty(QVTrelationNameGenerator.TRACE_LOCAL_SUCCESS_PROPERTY_NAME);
	}

	protected @NonNull DatumCaches createDatumCaches() {
		return new DatumCaches(this);
	}

	protected abstract @NonNull RootDomainUsageAnalysis createDomainUsageAnalysis();

	protected @NonNull NameGenerator createNameGenerator() {
		return new NameGenerator();
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

	private @NonNull Node createOperationParameterNode(@NonNull OperationRegionHelper regionHelper, @NonNull Variable variable, @NonNull String name, @NonNull OCLExpression expression) {
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)expression.getType();
		assert type != null;
		TypedModel typedModel = getDomainUsage(expression).getTypedModel(expression);
		assert typedModel != null;
		ClassDatum classDatum = getClassDatum(typedModel, type);
		Node parameterNode = regionHelper.createOperationParameterNode(name, classDatum);
		//		addVariableNode(variable, parameterNode);
		regionHelper.getRegion().addHeadNode(parameterNode);
		return parameterNode;
	}

	private @NonNull Node createOperationParameterNode(@NonNull OperationRegionHelper regionHelper, @NonNull ClassDatum classDatum, @NonNull String name) {
		Node parameterNode = regionHelper.createOperationParameterNode(name, classDatum);
		//		addVariableNode(variable, parameterNode);
		regionHelper.getRegion().addHeadNode(parameterNode);
		return parameterNode;
	}

	protected @NonNull OperationRegion createOperationRegion(@NonNull AbstractScheduleManager scheduleManager, @NonNull OperationCallExp operationCallExp,
			@NonNull ExpressionInOCL specification, @NonNull OperationDatum operationDatum) {
		Map<@NonNull VariableDeclaration, @NonNull Node> parameter2node = new HashMap<>();
		String operationName = ClassUtil.nonNullState(operationDatum.toString());
		final OperationRegion operationRegion = QVTscheduleFactory.eINSTANCE.createOperationRegion();
		scheduleManager.getScheduleModel().getOwnedOperationRegions().add(operationRegion);
		operationRegion.setReferredOperation(ClassUtil.nonNullState(operationCallExp.getReferredOperation()));
		operationRegion.setName(operationName);
		OperationRegionHelper regionHelper = new OperationRegionHelper(scheduleManager, operationRegion);
		//
		Variable selfVariable = specification.getOwnedContext();
		OCLExpression source = operationCallExp.getOwnedSource();
		assert source != null;
		Node selfNode = createOperationParameterNode(regionHelper, selfVariable, ClassUtil.nonNullState(selfVariable.getName()), source);
		parameter2node.put(selfVariable, selfNode);
		Node dependencyNode;
		dependencyNode = selfNode;
		//
		Node resultNode = regionHelper.createStepNode("result", operationCallExp, dependencyNode, false);	// FIXME do not use a MappingNode
		operationRegion.setResultNode(resultNode);
		regionHelper.createEqualsEdge(dependencyNode, resultNode);
		//
		List<Variable> ownedParameters = specification.getOwnedParameters();
		List<OCLExpression> ownedArguments = operationCallExp.getOwnedArguments();
		int iSize = Math.min(ownedArguments.size(), ownedParameters.size());
		for (int i = 0; i < iSize; i++) {
			Variable parameter = ownedParameters.get(i);
			Node parameterNode = createOperationParameterNode(regionHelper, parameter, ClassUtil.nonNullState(parameter.getName()), ClassUtil.nonNullState(ownedArguments.get(i)));
			parameter2node.put(parameter, parameterNode);
		}
		//
		OperationDependencyAnalysis operationDependencyAnalysis = scheduleManager.getOperationDependencyAnalysis();
		//		OperationDependencyAnalysis operationDependencyAnalysis = new OperationDependencyAnalysis(scheduleModel);
		//		operationDependencyAnalysis.dump();
		OperationDependencyPaths paths = operationDependencyAnalysis.analyzeOperation(operationCallExp);
		//		operationDependencyAnalysis.dump();
		//		System.out.println("Analyze2 " + operationCallExp + " gives\n\t" + paths);
		Iterable<@NonNull List<@NonNull OperationDependencyStep>> hiddenPaths = paths.getHiddenPaths();
		Iterable<@NonNull List<@NonNull OperationDependencyStep>> returnPaths = paths.getReturnPaths();
		RootDomainUsageAnalysis domainAnalysis = scheduleManager.getDomainUsageAnalysis();
		Map<@NonNull ClassDatum, @NonNull Node> classDatum2node = new HashMap<>();
		for (List<@NonNull OperationDependencyStep> steps : Iterables.concat(returnPaths, hiddenPaths)) {
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
					ClassDatum classDatum = scheduleManager.getClassDatum(typedModel, stepType);
					CompleteClass completeClass = classDatum.getCompleteClass();
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
							dependencyNode2 = classDatum2node.get(classDatum);
							if (dependencyNode2 == null) {
								assert !"OclVoid".equals(stepType.getName());
								dependencyNode2 = createOperationParameterNode(regionHelper, classDatum, "extra2_" + stepType.getName());
								classDatum2node.put(classDatum, dependencyNode2);
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
							//						Node nextNode = QVTscheduleUtil.StepNodeRoleFactory.PREDICATED_STEP.createNode(this, "next", classDatumAnalysis);

							if (primaryClass instanceof CollectionType) {
								Property iterateProperty = scheduleManager.getIterateProperty(primaryClass);
								Type elementType = PivotUtil.getElementType((CollectionType)primaryClass);
								TypedModel typedModel2 = QVTscheduleUtil.getTypedModel(classDatum);
								ClassDatum elementClassDatum = scheduleManager.getClassDatum(typedModel2, (org.eclipse.ocl.pivot.Class) elementType);
								Node elementNode = regionHelper.createOperationElementNode(operationName, elementClassDatum, dependencyNode2);
								//(region, name, typedElement, argNodes)Node(region, name, callExp, sourceNode)Node(this, name, iterateProperty, dependencyNode2);
								regionHelper.createNavigationEdge(dependencyNode2, iterateProperty, elementNode, false);
								dependencyNode2 = elementNode;
							}
							//							assert !dependencyNode2.isMatched();
							Node nextNode;			// FIXME re-use shared paths
							if (callExp instanceof NavigationCallExp) {
								String name = CompilerUtil.recoverVariableName(callExp);
								if (name == null) {
									name = QVTscheduleUtil.getName(PivotUtil.getReferredProperty((NavigationCallExp)callExp));
								}
								nextNode = regionHelper.createDataTypeNode(name, dependencyNode2, (NavigationCallExp)callExp);
							}
							else {
								nextNode = regionHelper.createDataTypeNode(dependencyNode2, property);
							}
							regionHelper.createNavigationEdge(dependencyNode2, property, nextNode, false);
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

	protected @NonNull Property createProperty(@NonNull String name, @NonNull Type type, boolean isRequired) {
		Property property = PivotUtil.createProperty(name, type);
		property.setIsRequired(isRequired);
		return property;
	}

	protected abstract @NonNull AbstractTransformationAnalysis createTransformationAnalysis(@NonNull Transformation asTransformation);

	@Override
	public @NonNull Iterable<@NonNull PropertyDatum> getAllPropertyDatums(@NonNull ClassDatum classDatum) {
		return datumCaches.getAllPropertyDatums(classDatum);
	}

	public @NonNull Property getArgumentProperty(@NonNull String argumentName) {
		Property argumentProperty = name2argumentProperty.get(argumentName);
		if (argumentProperty == null) {
			argumentProperty = createProperty(argumentName, getStandardLibrary().getOclAnyType(), true);
			name2argumentProperty.put(argumentName, argumentProperty);
		}
		return argumentProperty;
	}

	@Override
	public @NonNull ClassDatum getBooleanClassDatum() {
		ClassDatum booleanClassDatum2 = booleanClassDatum;
		if (booleanClassDatum2 == null) {
			TypedModel primitiveTypeModel = domainUsageAnalysis.getPrimitiveTypeModel();
			StandardLibrary standardLibrary = environmentFactory.getStandardLibrary();
			booleanClassDatum = booleanClassDatum2 = getClassDatum(primitiveTypeModel, standardLibrary.getBooleanType());
		}
		return booleanClassDatum2;
	}

	@Override
	public @NonNull Property getCastProperty(@NonNull Type type) {
		Property castProperty = type2castProperty.get(type);
		if (castProperty == null) {
			castProperty = createProperty("«cast»\\n" + type.toString(), type, true);
			type2castProperty.put(type, castProperty);
		}
		return castProperty;
	}

	@Override
	public @NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, @NonNull CompleteClass completeClass) {
		return datumCaches.getClassDatum(typedModel, completeClass);
	}

	@Override
	public @NonNull ClassDatum getClassDatum(@NonNull TypedElement asTypedElement) {
		org.eclipse.ocl.pivot.Class asType = (org.eclipse.ocl.pivot.Class)asTypedElement.getType();
		assert asType != null;
		Type elementType = PivotUtil.getElementalType(asType);
		TypedModel typedModel;
		if (elementType instanceof DataType) {
			typedModel = getDomainUsageAnalysis().getPrimitiveTypeModel();
		}
		else {
			DomainUsage domainUsage = getDomainUsage(asTypedElement);
			assert domainUsage != null;
			typedModel = domainUsage.getTypedModel(asTypedElement);
			assert typedModel != null;
		}
		return datumCaches.getClassDatum(typedModel, asType);
	}

	@Override
	public @NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Class asType) {
		return datumCaches.getClassDatum(typedModel, asType);
	}

	@Override
	public @NonNull Iterable<@NonNull ClassDatum> getClassDatums() {
		return classDatums;
	}

	public @NonNull ContainmentAnalysis getContainmentAnalysis() {
		return datumCaches.getContainmentAnalysis();
	}

	@Override
	public @NonNull DomainUsage getDomainUsage(@NonNull Element element) {
		if (element instanceof ClassDatum) {
			return getDomainUsage(QVTscheduleUtil.getReferredTypedModel((ClassDatum)element));
		}
		DomainUsageAnalysis analysis = domainUsageAnalysis;
		Operation operation = PivotUtil.getContainingOperation(element);
		if (operation != null) {
			analysis = domainUsageAnalysis.getAnalysis(operation);
		}
		return ClassUtil.nonNullState(analysis.getUsage(element));
	}

	@Override
	public @NonNull RootDomainUsageAnalysis getDomainUsageAnalysis() {
		return domainUsageAnalysis;
	}

	@Override
	public @NonNull ClassDatum getElementalClassDatum(@NonNull ClassDatum classDatum) {
		Type type = classDatum.getCompleteClass().getPrimaryClass();
		Type elementType = type;
		while (elementType instanceof CollectionType) {
			elementType = ((CollectionType)elementType).getElementType();
		}
		if ((elementType == null) || (elementType == type) || !(elementType instanceof org.eclipse.ocl.pivot.Class)) {
			return classDatum;
		}
		else {
			TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
			return getClassDatum(typedModel, (org.eclipse.ocl.pivot.Class)elementType);
		}
	}

	@Override
	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	protected @NonNull URI getGraphsBaseURI() {
		return scheduleModel.eResource().getURI().trimSegments(1).appendSegment("graphs").appendSegment("");
	}

	public @NonNull Property getIterateProperty(@NonNull Type type) {
		Property iterateProperty = type2iterateProperty.get(type);
		if (iterateProperty == null) {
			iterateProperty = createProperty("«iterate»", type, true);
			type2iterateProperty.put(type, iterateProperty);
		}
		return iterateProperty;
	}

	@Override
	public @NonNull NameGenerator getNameGenerator() {
		return nameGenerator;
	}

	@Override
	public @NonNull Iterable<@NonNull PropertyDatum> getOclContainerPropertyDatums(@NonNull ClassDatum classDatum) {
		return datumCaches.getOclContainerPropertyDatums(classDatum);
	}

	@Override
	public @NonNull ClassDatum getOclVoidClassDatum() {
		ClassDatum oclVoidClassDatum2 = oclVoidClassDatum;
		if (oclVoidClassDatum2 == null) {
			TypedModel primitiveTypeModel = domainUsageAnalysis.getPrimitiveTypeModel();
			StandardLibrary standardLibrary = environmentFactory.getStandardLibrary();
			oclVoidClassDatum = oclVoidClassDatum2 = getClassDatum(primitiveTypeModel, standardLibrary.getOclVoidType());
		}
		return oclVoidClassDatum2;
	}

	public @NonNull OperationDependencyAnalysis getOperationDependencyAnalysis() {
		OperationDependencyAnalysis operationDependencyAnalysis2 = operationDependencyAnalysis;
		if (operationDependencyAnalysis2 == null) {
			operationDependencyAnalysis = operationDependencyAnalysis2 = new OperationDependencyAnalysis(getContainmentAnalysis(), getDomainUsageAnalysis());
		}
		return operationDependencyAnalysis2;
	}

	@Override
	public @NonNull PropertyDatum getPropertyDatum(@NonNull ClassDatum classDatum, @NonNull Property property) {
		return datumCaches.getPropertyDatum(classDatum, property);
	}

	@Override
	public @NonNull PropertyDatum getPropertyDatum(@NonNull NavigableEdge edge) {
		Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
		Property property = QVTscheduleUtil.getProperty(edge);
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(sourceNode);
		return getPropertyDatum(classDatum, property);
	}

	/**
	 * Return a determinstic alphabetical ordering of the TransformationAnalysis instances.
	 */
	@Override
	public @NonNull Iterable<@NonNull AbstractTransformationAnalysis> getOrderedTransformationAnalyses() {
		List<@NonNull AbstractTransformationAnalysis> transformationAnalyses = Lists.newArrayList(transformation2transformationAnalysis.values());
		if (transformationAnalyses.size() > 1) {
			Collections.sort(transformationAnalyses, NameUtil.NAMEABLE_COMPARATOR);
		}
		return transformationAnalyses;
	}

	@Override
	public @NonNull LegacyContentsAnalysis getOriginalContentsAnalysis() {
		return ClassUtil.nonNullState(originalContentsAnalysis);
	}

	@Override
	public @NonNull QVTbaseLibraryHelper getQVTbaseLibraryHelper() {
		return qvtbaseLibraryHelper;
	}

	@Override
	public @NonNull RegionAnalysis getRegionAnalysis(@NonNull Region region) {
		if (region instanceof RuleRegion) {
			Rule rule = QVTscheduleUtil.getReferredRule((RuleRegion) region);
			Transformation transformation = QVTbaseUtil.getContainingTransformation(rule);
			AbstractTransformationAnalysis transformationAnalysis = getTransformationAnalysis(transformation);
			return transformationAnalysis.getRegionAnalysis(region);
		}
		else {
			ScheduledRegion scheduledRegion = QVTscheduleUtil.getContainingScheduledRegion(region);
			Transformation transformation = QVTscheduleUtil.getReferredTransformation(scheduledRegion);
			AbstractTransformationAnalysis transformationAnalysis = getTransformationAnalysis(transformation);
			return transformationAnalysis.getRegionAnalysis(region);
		}
	}

	public @NonNull RuleAnalysis getRuleAnalysis(@NonNull Rule rule) {
		Transformation transformation = QVTbaseUtil.getOwningTransformation(rule);
		AbstractTransformationAnalysis transformationAnalysis = getTransformationAnalysis(transformation);
		return transformationAnalysis.getRuleAnalysis(rule);
	}

	@Override
	public @NonNull ScheduleModel getScheduleModel() {
		return scheduleModel;
	}

	@Override
	public @NonNull StandardLibrary getStandardLibrary() {
		return environmentFactory.getStandardLibrary();
	}

	@Override
	public @NonNull StandardLibraryHelper getStandardLibraryHelper() {
		return standardLibraryHelper;
	}

	/*	public @NonNull Property getStatusProperty(@NonNull Node node) {
		assert isMiddle(node);
		CompleteClass completeClass = node.getCompleteClass();
		return ClassUtil.nonNullState(completeClass.getProperty(QVTrNameGenerator.TRACECLASS_STATUS_PROPERTY_NAME));
	} */

	@Override
	public @NonNull PropertyDatum getSuccessPropertyDatum(@NonNull Property successProperty) {
		return datumCaches.getSuccessPropertyDatum(successProperty);
	}

	@Override
	public @NonNull Iterable<@NonNull ClassDatum> getSuperClassDatums(@NonNull ClassDatum classDatum) {
		List<@NonNull ClassDatum> superClassDatums = QVTscheduleUtil.Internal.getSuperClassDatumsList(classDatum);
		if (superClassDatums.isEmpty()) {
			DomainUsage domainUsage = getDomainUsage(classDatum);
			CompleteClass completeClass = classDatum.getCompleteClass();
			for (@NonNull CompleteClass completeSuperClass : completeClass.getSuperCompleteClasses()) {
				TypedModel typedModel = ClassUtil.nonNullState(domainUsage.getTypedModel(completeClass));
				ClassDatum superClassDatum = getClassDatum(typedModel, completeSuperClass);
				if (!superClassDatums.contains(superClassDatum)) {
					superClassDatums.add(superClassDatum);
				}
			}
		}
		return superClassDatums;
	}

	@Override
	public @NonNull TraceHelper getTraceHelper() {
		TraceHelper traceHelper2 = traceHelper;
		if (traceHelper2 == null) {
			traceHelper = traceHelper2 = new TraceHelper(environmentFactory);
		}
		return traceHelper2;
	}

	@Override
	public @NonNull TypedModel getTraceTypedModel() {
		return domainUsageAnalysis.getTraceTypedModel();
	}

	@Override
	public @NonNull Iterable<@NonNull AbstractTransformationAnalysis> getTransformationAnalyses() {
		return transformation2transformationAnalysis.values();
	}

	@Override
	public @NonNull AbstractTransformationAnalysis getTransformationAnalysis(@NonNull Transformation transformation) {
		AbstractTransformationAnalysis transformationAnalysis = transformation2transformationAnalysis.get(transformation);
		return ClassUtil.nonNullState(transformationAnalysis);
	}

	//	@Override
	//	public @NonNull TransformationAnalysis2TracePackage getTransformationAnalysis2TracePackage(@NonNull TransformationAnalysis transformationAnalysis) {
	//		TransformationAnalysis2TracePackage transformationAnalysis2tracePackage = transformationAnalysis2transformationAnalysis2tracePackage.get(transformationAnalysis);
	//		if (transformationAnalysis2tracePackage == null) {
	//			transformationAnalysis2tracePackage = new TransformationAnalysis2TracePackage(this, transformationAnalysis);
	//			transformationAnalysis2transformationAnalysis2tracePackage.put(transformationAnalysis, transformationAnalysis2tracePackage);
	//		}
	//		return transformationAnalysis2tracePackage;
	//	}

	@Override
	public boolean isDirty(@NonNull Property property) {
		return domainUsageAnalysis.isDirty(property);
	}

	@Override
	public boolean isElementallyConformantSource(@NonNull NavigableEdge thatEdge, @NonNull NavigableEdge thisEdge) {
		Node thatSource = thatEdge.getEdgeSource();
		CompleteClass thatType = ClassUtil.nonNullState(getElementalClassDatum(QVTscheduleUtil.getClassDatum(thatSource)).getCompleteClass());
		CompleteClass thisType = ClassUtil.nonNullState(getElementalClassDatum(QVTscheduleUtil.getClassDatum(thisEdge.getEdgeSource())).getCompleteClass());
		if (thatType.conformsTo(thisType)) {
			return true;
		}
		if (thatSource.isRealized()) {
			return false;
		}
		if (thisType.conformsTo(thatType)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isMiddle(@NonNull Node node) {
		return getDomainUsage(QVTscheduleUtil.getClassDatum(node)).isMiddle();
	}

	@Override
	public boolean isNoEarlyMerge() {
		CompilerOptions.StepOptions schedulerOptions2 = schedulerOptions;
		if (schedulerOptions2 == null) {
			return false;
		}
		return schedulerOptions2.basicGet(CompilerChain.SCHEDULER_NO_EARLY_MERGE) == Boolean.TRUE;
	}

	@Override
	public boolean isNoLateConsumerMerge() {
		CompilerOptions.StepOptions schedulerOptions2 = schedulerOptions;
		if (schedulerOptions2 == null) {
			return false;
		}
		return schedulerOptions2.basicGet(CompilerChain.SCHEDULER_NO_LATE_CONSUMER_MERGE) == Boolean.TRUE;
	}

	public boolean isKnown(@NonNull VariableDeclaration sourceVariable) {
		if (sourceVariable.eContainer() == null) {		// Synthetic variable
			return false;
		}
		DomainUsage usage = getDomainUsage(sourceVariable);
		assert usage != null;
		return !usage.isOutput();
	}

	@Override
	public void setScheduledRegion(@NonNull MappingRegion mappingRegion, @Nullable ScheduledRegion scheduledRegion) {
		mappingRegion.setScheduledRegion(scheduledRegion);
	}

	public void writeCallDOTfile(@NonNull ScheduledRegion region, @NonNull String suffix) {
		if (doDotGraphs) {
			URI baseURI = getGraphsBaseURI();
			URI dotURI = URI.createURI(region.getSymbolName()/*.replace("\n",  "_").replace("\\n",  "_c")*/ + suffix + ".dot").resolve(baseURI);
			try {
				OutputStream outputStream = environmentFactory.getResourceSet().getURIConverter().createOutputStream(dotURI);
				ToCallGraphVisitor visitor = new ToCallGraphVisitor(new DOTStringBuilder());
				String s = visitor.visit(region);
				outputStream.write(s.getBytes());
				outputStream.close();
			} catch (IOException e) {
				System.err.println("Failed to generate '" + dotURI + "' : " + e.getLocalizedMessage());
			}
		}
	}

	public void writeCallGraphMLfile(@NonNull ScheduledRegion region, @NonNull String suffix) {
		if (doYedGraphs) {
			URI baseURI = getGraphsBaseURI();
			URI dotURI = URI.createURI(region.getSymbolName()/*.replace("\n",  "_").replace("\\n",  "_c")*/ + suffix + ".graphml").resolve(baseURI);
			try {
				OutputStream outputStream = environmentFactory.getResourceSet().getURIConverter().createOutputStream(dotURI);
				ToCallGraphVisitor visitor = new ToCallGraphVisitor(new GraphMLStringBuilder());
				String s = visitor.visit(region);
				outputStream.write(s.getBytes());
				outputStream.close();
			} catch (IOException e) {
				System.err.println("Failed to generate '" + dotURI + "' : " + e.getLocalizedMessage());
			}
		}
	}

	@Override
	public void writeDebugGraphs(@NonNull String context, boolean doNodesGraph, boolean doRegionGraph, boolean doCallGraph) {
		if (doDotGraphs || doYedGraphs) {
			for (@NonNull ScheduledRegion scheduledRegion : QVTscheduleUtil.getOwnedScheduledRegions(scheduleModel)) {
				if (doNodesGraph) {
					writeDebugGraphs(scheduledRegion, context);
				}
				if (doRegionGraph) {
					String suffix = "-r-" + context;
					writeRegionDOTfile(scheduledRegion, suffix);
					writeRegionGraphMLfile(scheduledRegion, suffix);
				}
				if (doCallGraph) {
					String suffix = "-c-" + context;
					writeCallDOTfile(scheduledRegion, suffix);
					writeCallGraphMLfile(scheduledRegion, suffix);
				}
			}
		}
	}

	@Override
	public void writeDebugGraphs(@NonNull Graphable graphable, @Nullable String context) {
		if (doDotGraphs || doYedGraphs) {
			String suffix = context != null ? "-" + context : null;
			writeDOTfile(graphable, suffix);
			writeGraphMLfile(graphable, suffix);
		}
	}


	public void writeDOTfile(@NonNull Graphable graphable, @Nullable String suffix) {
		if (doDotGraphs) {
			URI baseURI = getGraphsBaseURI();
			String symbolName = graphable.getSymbolName();
			if (suffix != null) {
				symbolName = symbolName + suffix;
			}
			URI dotURI = URI.createURI(symbolName + ".dot").resolve(baseURI);
			if (dotURI.toString().contains("mTmapIfExp__DmapOclExpression_d2qvtrExpression_glob")) {
				getClass().toString();
			}
			try {
				OutputStream outputStream = environmentFactory.getResourceSet().getURIConverter().createOutputStream(dotURI);
				try {
					DOTStringBuilder s = new DOTStringBuilder();
					graphable.toGraph(s);
					//	ToGraphVisitor visitor = new ToGraphVisitor(s);
					//	graphable.accept(visitor);
					outputStream.write(s.toString().getBytes());
				}
				finally {
					try {
						outputStream.close();
					}
					catch (Throwable e) {}
				}
			} catch (IOException e) {
				System.err.println("Failed to generate '" + dotURI + "' : " + e.getLocalizedMessage());
			}
		}
	}

	public void writeGraphMLfile(@NonNull Graphable graphable, @Nullable String suffix) {
		if (doYedGraphs) {
			URI baseURI = getGraphsBaseURI();
			String symbolName = graphable.getSymbolName();
			if (suffix != null) {
				symbolName = symbolName + suffix;
			}
			URI dotURI = URI.createURI(symbolName + ".graphml").resolve(baseURI);
			try {
				OutputStream outputStream = environmentFactory.getResourceSet().getURIConverter().createOutputStream(dotURI);
				try {
					GraphMLStringBuilder s = new GraphMLStringBuilder();
					graphable.toGraph(s);
					outputStream.write(s.toString().getBytes());
				}
				finally {
					try {
						outputStream.close();
					}
					catch (Throwable e) {}
				}
			} catch (IOException e) {
				System.err.println("Failed to generate '" + dotURI + "' : " + e.getLocalizedMessage());
			}
		}
	}

	public void writeRegionDOTfile(@NonNull ScheduledRegion region, @NonNull String suffix) {
		if (doDotGraphs) {
			URI baseURI = getGraphsBaseURI();
			URI dotURI = URI.createURI(region.getSymbolName()/*.replace("\n",  "_").replace("\\n",  "_")*/ + suffix + ".dot").resolve(baseURI);
			if (dotURI.toString().contains("mTmapIfExp__DmapOclExpression_d2qvtrExpression_glob")) {
				getClass().toString();
			}
			try {
				OutputStream outputStream = environmentFactory.getResourceSet().getURIConverter().createOutputStream(dotURI);
				try {
					ToRegionGraphVisitor visitor = new ToRegionGraphVisitor(new DOTStringBuilder());
					String s = visitor.visit(region);
					outputStream.write(s.getBytes());
				}
				finally {
					try {
						outputStream.close();
					}
					catch (Throwable e) {}
				}
			} catch (IOException e) {
				System.err.println("Failed to generate '" + dotURI + "' : " + e.getLocalizedMessage());
			}
			for (@NonNull Region nestedRegion : QVTscheduleUtil.getActiveRegions(region)) {
				if (nestedRegion instanceof ScheduledRegion) {
					writeRegionDOTfile((@NonNull ScheduledRegion)nestedRegion, suffix);
				}
			}
		}
	}

	public void writeRegionGraphMLfile(@NonNull ScheduledRegion region, @NonNull String suffix) {
		if (doYedGraphs) {
			URI baseURI = getGraphsBaseURI();
			URI dotURI = URI.createURI(region.getSymbolName()/*.replace("\n",  "_").replace("\\n",  "_")*/ + suffix + ".graphml").resolve(baseURI);
			try {
				OutputStream outputStream = environmentFactory.getResourceSet().getURIConverter().createOutputStream(dotURI);
				try {
					ToRegionGraphVisitor visitor = new ToRegionGraphVisitor(new GraphMLStringBuilder());
					String s = visitor.visit(region);
					outputStream.write(s.getBytes());
				}
				finally {
					try {
						outputStream.close();
					}
					catch (Throwable e) {}
				}
			} catch (IOException e) {
				System.err.println("Failed to generate '" + dotURI + "' : " + e.getLocalizedMessage());
			}
			for (@NonNull Region nestedRegion : QVTscheduleUtil.getActiveRegions(region)) {
				if (nestedRegion instanceof ScheduledRegion) {
					writeRegionGraphMLfile((@NonNull ScheduledRegion)nestedRegion, suffix);
				}
			}
		}
	}
}