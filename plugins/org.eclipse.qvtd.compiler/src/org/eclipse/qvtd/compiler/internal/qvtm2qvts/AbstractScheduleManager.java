/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
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
import java.io.OutputStream;
import java.util.ArrayList;
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
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.DOTStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphMLStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.utilities.StandardLibraryHelper;
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
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.ToCallGraphVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.ToRegionGraphVisitor;

import com.google.common.collect.Iterables;

public abstract class AbstractScheduleManager implements ScheduleManager
{
	protected final @NonNull ScheduleModel scheduleModel;
	protected final @NonNull EnvironmentFactory environmentFactory;
	private CompilerOptions.@Nullable StepOptions schedulerOptions;
	protected final @NonNull RootDomainUsageAnalysis domainUsageAnalysis;
	protected final @NonNull DatumCaches datumCaches;
	protected final @NonNull StandardLibraryHelper standardLibraryHelper;

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

	private /*@LazyNonNull */ OperationDependencyAnalysis operationDependencyAnalysis = null;

	private @NonNull Map<@NonNull Region, @NonNull RegionAnalysis> region2regionAnalysis = new HashMap<>();

	private Map<@NonNull OperationDatum, @NonNull OperationRegion> operationDatum2operationRegion = new HashMap<>();

	private final @NonNull Map<@NonNull Transformation, @NonNull TransformationAnalysis> transformation2transformationAnalysis = new HashMap<>();
	private final boolean doDotGraphs;
	private final boolean doYedGraphs;

	protected AbstractScheduleManager(@NonNull ScheduleModel scheduleModel, @NonNull EnvironmentFactory environmentFactory,
			CompilerOptions.@Nullable StepOptions schedulerOptions) {
		this.scheduleModel = scheduleModel;
		this.environmentFactory = environmentFactory;
		this.schedulerOptions = schedulerOptions;
		this.domainUsageAnalysis = createDomainUsageAnalysis();
		this.standardLibraryHelper = new StandardLibraryHelper(environmentFactory.getStandardLibrary());
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
	public void addRegionError(@NonNull Region region, @NonNull String messageTemplate, Object... bindings) {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public void addRegionWarning(@NonNull Region region, @NonNull String messageTemplate, Object... bindings) {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public @NonNull TransformationAnalysis addTransformation(@NonNull Transformation asTransformation) {
		TransformationAnalysis transformationAnalysis = createTransformationAnalysis(asTransformation);
		transformation2transformationAnalysis.put(asTransformation, transformationAnalysis);
		return transformationAnalysis;
	}

	private void analyzeCallTree() {
		Map<@NonNull Rule, @NonNull List<@NonNull Rule>> consumer2producers = new HashMap<>();
		List<@NonNull ClassDatum> middleClassDatums = new ArrayList<>();
		StringBuilder s = QVTm2QVTs.CALL_TREE.isActive() ? new StringBuilder() : null;
		for (@NonNull ClassDatum classDatum : QVTscheduleUtil.getOwnedClassDatums(scheduleModel)) {
			TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
			DomainUsage usage = domainUsageAnalysis.getUsage(typedModel);
			if (usage.isMiddle()) {
				middleClassDatums.add(classDatum);
				if (s != null) {
					s.append("middle: " + classDatum.getProducingRegions() + "\n");
				}
				for (@NonNull RuleRegion consumingRegion : QVTscheduleUtil.getConsumingRegions(classDatum)) {
					Rule consumer = QVTscheduleUtil.getReferredRule(consumingRegion);
					List<@NonNull Rule> producers = consumer2producers.get(consumer);
					if (producers == null) {
						producers = new ArrayList<>();
						consumer2producers.put(consumer, producers);
					}
					for (@NonNull RuleRegion producingRegion : QVTscheduleUtil.getProducingRegions(classDatum)) {
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

	protected void analyzeRules(@NonNull TransformationAnalysis transformationAnalysis) {
		domainUsageAnalysis.analyzeTransformation(transformationAnalysis.getTransformation());
		transformationAnalysis.analyzeRules();
	}

	protected void analyzeTransformation(@NonNull TransformationAnalysis transformationAnalysis) {
		transformationAnalysis.analyzeTransformation();
		datumCaches.analyzeTransformation(transformationAnalysis);
	}

	@Override
	public void analyzeRules() {
		for (@NonNull TransformationAnalysis transformationAnalysis : transformation2transformationAnalysis.values()) {
			analyzeRules(transformationAnalysis);
		}
	}

	@Override
	public void analyzeTransformations() {
		for (@NonNull TransformationAnalysis transformationAnalysis : transformation2transformationAnalysis.values()) {
			analyzeTransformation(transformationAnalysis);
		}
		analyzeCallTree();
	}

	@Override
	public @Nullable Property basicGetStatusProperty(@NonNull Node node) {
		if (!isMiddle(node)) {
			return null;
		}
		CompleteClass completeClass = node.getCompleteClass();
		return completeClass.getProperty(QVTrNameGenerator.TRACECLASS_STATUS_PROPERTY_NAME);
	}

	protected abstract @NonNull DatumCaches createDatumCaches();

	protected abstract @NonNull RootDomainUsageAnalysis createDomainUsageAnalysis();

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
		Node resultNode = regionHelper.createStepNode("result", operationCallExp, dependencyNode, false);
		operationRegion.setResultNode(resultNode);
		regionHelper.createExpressionEdge(dependencyNode, QVTscheduleConstants.RETURN_NAME, resultNode);
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
		Iterable<@NonNull List<org.eclipse.qvtd.compiler.internal.qvtm2qvts.OperationDependencyStep>> hiddenPaths = paths.getHiddenPaths();
		Iterable<@NonNull List<org.eclipse.qvtd.compiler.internal.qvtm2qvts.OperationDependencyStep>> returnPaths = paths.getReturnPaths();
		RootDomainUsageAnalysis domainAnalysis = scheduleManager.getDomainUsageAnalysis();
		Map<@NonNull ClassDatum, @NonNull Node> classDatum2node = new HashMap<>();
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

	protected @NonNull TransformationAnalysis createTransformationAnalysis(@NonNull Transformation asTransformation) {
		return new TransformationAnalysis(this, asTransformation);
	}

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

	public @NonNull PropertyDatum getPropertyDatum(@NonNull ClassDatum classDatum, @NonNull Property property) {
		return datumCaches.getPropertyDatum(classDatum, property);
	}

	@Override
	public @NonNull RegionAnalysis getRegionAnalysis(@NonNull Region region) {
		RegionAnalysis regionAnalysis = region2regionAnalysis.get(region);
		if (regionAnalysis == null) {
			regionAnalysis = new RegionAnalysis(this, region);
			region2regionAnalysis.put(region, regionAnalysis);
		}
		return regionAnalysis;
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
	public @NonNull Iterable<@NonNull TransformationAnalysis> getTransformationAnalyses() {
		return transformation2transformationAnalysis.values();
	}

	@Override
	public @NonNull TransformationAnalysis getTransformationAnalysis(@NonNull Transformation transformation) {
		TransformationAnalysis transformationAnalysis = transformation2transformationAnalysis.get(transformation);
		return ClassUtil.nonNullState(transformationAnalysis);
	}

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
	public void writeDebugGraphs(@NonNull Region region, @Nullable String context) {
		if (doDotGraphs || doYedGraphs) {
			String suffix = context != null ? "-" + context : null;
			writeDOTfile(region, suffix);
			writeGraphMLfile(region, suffix);
		}
	}


	public void writeDOTfile(@NonNull Region region, @Nullable String suffix) {
		if (doDotGraphs) {
			URI baseURI = getGraphsBaseURI();
			String symbolName = region.getSymbolName();
			if (suffix != null) {
				symbolName = symbolName + suffix;
			}
			URI dotURI = URI.createURI(symbolName + ".dot").resolve(baseURI);
			try {
				OutputStream outputStream = environmentFactory.getResourceSet().getURIConverter().createOutputStream(dotURI);
				DOTStringBuilder s = new DOTStringBuilder();
				region.toGraph(s);
				outputStream.write(s.toString().getBytes());
				outputStream.close();
			} catch (IOException e) {
				System.err.println("Failed to generate '" + dotURI + "' : " + e.getLocalizedMessage());
			}
		}
	}

	public void writeGraphMLfile(@NonNull Region region, @Nullable String suffix) {
		if (doYedGraphs) {
			URI baseURI = getGraphsBaseURI();
			String symbolName = region.getSymbolName();
			if (suffix != null) {
				symbolName = symbolName + suffix;
			}
			URI dotURI = URI.createURI(symbolName + ".graphml").resolve(baseURI);
			try {
				OutputStream outputStream = environmentFactory.getResourceSet().getURIConverter().createOutputStream(dotURI);
				GraphMLStringBuilder s = new GraphMLStringBuilder();
				region.toGraph(s);
				outputStream.write(s.toString().getBytes());
				outputStream.close();
			} catch (IOException e) {
				System.err.println("Failed to generate '" + dotURI + "' : " + e.getLocalizedMessage());
			}
		}
	}

	public void writeRegionDOTfile(@NonNull ScheduledRegion region, @NonNull String suffix) {
		if (doDotGraphs) {
			URI baseURI = getGraphsBaseURI();
			URI dotURI = URI.createURI(region.getSymbolName()/*.replace("\n",  "_").replace("\\n",  "_")*/ + suffix + ".dot").resolve(baseURI);
			try {
				OutputStream outputStream = environmentFactory.getResourceSet().getURIConverter().createOutputStream(dotURI);
				ToRegionGraphVisitor visitor = new ToRegionGraphVisitor(new DOTStringBuilder());
				String s = visitor.visit(region);
				outputStream.write(s.getBytes());
				outputStream.close();
			} catch (IOException e) {
				System.err.println("Failed to generate '" + dotURI + "' : " + e.getLocalizedMessage());
			}
			for (@NonNull Region nestedRegion : QVTscheduleUtil.getMappingRegions(region)) {
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
				ToRegionGraphVisitor visitor = new ToRegionGraphVisitor(new GraphMLStringBuilder());
				String s = visitor.visit(region);
				outputStream.write(s.getBytes());
				outputStream.close();
			} catch (IOException e) {
				System.err.println("Failed to generate '" + dotURI + "' : " + e.getLocalizedMessage());
			}
			for (@NonNull Region nestedRegion : QVTscheduleUtil.getMappingRegions(region)) {
				if (nestedRegion instanceof ScheduledRegion) {
					writeRegionGraphMLfile((@NonNull ScheduledRegion)nestedRegion, suffix);
				}
			}
		}
	}
}