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
import org.eclipse.qvtd.compiler.CompilerChain.Key;
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
import org.eclipse.qvtd.pivot.qvtcore.analysis.QVTcoreDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
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

public abstract class ScheduleManager
{
	private final @NonNull ScheduleModel scheduleModel;
	private final @NonNull EnvironmentFactory environmentFactory;
	private final @NonNull Transformation transformation;
	private @Nullable Map<@NonNull Key<? extends Object>, @Nullable Object> schedulerOptions;
	private final @NonNull RootDomainUsageAnalysis domainAnalysis;
	private final @NonNull DatumCaches datumCaches;

	@SuppressWarnings("unused")
	private final @NonNull DomainUsage inputUsage;

	protected final @NonNull StandardLibraryHelper standardLibraryHelper;
	private final @NonNull ClassDatum oclVoidClassDatum;

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

	private /*@LazyNonNull*/ List<@NonNull RuleRegion> orderedMappings;	// Only ordered to improve determinacy

	private @NonNull Map<@NonNull Region, @NonNull RegionAnalysis> region2regionAnalysis = new HashMap<>();

	private Map<@NonNull OperationDatum, @NonNull OperationRegion> operationDatum2operationRegion = new HashMap<>();

	protected ScheduleManager(@NonNull ScheduleModel scheduleModel, @NonNull EnvironmentFactory environmentFactory, @NonNull Transformation asTransformation,
			@Nullable Map<@NonNull Key<? extends Object>, @Nullable Object> schedulerOptions) {
		this.scheduleModel = scheduleModel;
		this.environmentFactory = environmentFactory;
		this.transformation = asTransformation;
		this.schedulerOptions = schedulerOptions;
		this.domainAnalysis = new QVTcoreDomainUsageAnalysis(environmentFactory);
		asTransformation.getModelParameter().add(domainAnalysis.getPrimitiveTypeModel());		// FIXME move to QVTm
		domainAnalysis.analyzeTransformation(asTransformation);
		this.datumCaches = new DatumCaches(this);
		this.orderedMappings = datumCaches.analyzeTransformation(asTransformation);
		analyzeCallTree();
		//
		this.inputUsage = domainAnalysis.getInputUsage();
		//		int outputMask = ((DomainUsage.Internal)domainAnalysis.getOutputUsage()).getMask();
		//		int inputMask = checkableMask & ~enforceableMask;
		//		this.inputUsage = domainAnalysis.getConstantUsage(inputMask);
		//
		StandardLibrary standardLibrary = environmentFactory.getStandardLibrary();
		this.standardLibraryHelper = new StandardLibraryHelper(standardLibrary);
		oclVoidClassDatum = getClassDatum(standardLibrary.getOclVoidType(), domainAnalysis.getPrimitiveTypeModel());
	}

	public void addMappingRegion(@NonNull MappingRegion mappingRegion) {
		scheduleModel.getOwnedMappingRegions().add(mappingRegion);
	}

	public void addRegionError(@NonNull Region region, @NonNull String messageTemplate, Object... bindings) {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	public void addRegionWarning(@NonNull Region region, @NonNull String messageTemplate, Object... bindings) {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	private void analyzeCallTree() {
		Map<@NonNull Rule, @NonNull List<@NonNull Rule>> consumer2producers = new HashMap<>();
		List<@NonNull ClassDatum> middleClassDatums = new ArrayList<>();
		StringBuilder s = QVTm2QVTs.CALL_TREE.isActive() ? new StringBuilder() : null;
		for (@NonNull ClassDatum classDatum : QVTscheduleUtil.getOwnedClassDatums(scheduleModel)) {
			TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
			DomainUsage usage = domainAnalysis.getUsage(typedModel);
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
				if (AbstractQVTb2QVTs.DEBUG_GRAPHS.isActive()) {
					writeDebugGraphs(operationRegion, null);
				}
			}
			return operationRegion;
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UnsupportedOperationException(e);
		}
	}

	public @Nullable Property basicGetStatusProperty(@NonNull Node node) {
		if (!isMiddle(node)) {
			return null;
		}
		CompleteClass completeClass = node.getCompleteClass();
		return completeClass.getProperty(QVTrNameGenerator.TRACECLASS_STATUS_PROPERTY_NAME);
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

	private @NonNull Node createOperationParameterNode(@NonNull RegionHelper regionHelper, @NonNull Variable variable, @NonNull String name, @NonNull OCLExpression expression) {
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)expression.getType();
		assert type != null;
		TypedModel typedModel = getDomainUsage(expression).getTypedModel(expression);
		assert typedModel != null;
		ClassDatum classDatum = getClassDatum(type, typedModel);
		Node parameterNode = regionHelper.createOperationParameterNode(name, classDatum);
		//		addVariableNode(variable, parameterNode);
		((OperationRegion)regionHelper.getRegion()).addHeadNode(parameterNode);
		return parameterNode;
	}

	private @NonNull Node createOperationParameterNode(@NonNull RegionHelper regionHelper, @NonNull ClassDatum classDatum, @NonNull String name) {
		Node parameterNode = regionHelper.createOperationParameterNode(name, classDatum);
		//		addVariableNode(variable, parameterNode);
		((OperationRegion)regionHelper.getRegion()).addHeadNode(parameterNode);
		return parameterNode;
	}

	protected @NonNull OperationRegion createOperationRegion(@NonNull ScheduleManager scheduleManager, @NonNull OperationCallExp operationCallExp,
			@NonNull ExpressionInOCL specification, @NonNull OperationDatum operationDatum) {
		Map<@NonNull VariableDeclaration, @NonNull Node> parameter2node = new HashMap<>();
		String operationName = ClassUtil.nonNullState(operationDatum.toString());
		final OperationRegion operationRegion = QVTscheduleFactory.eINSTANCE.createOperationRegion();
		scheduleManager.getScheduleModel().getOwnedOperationRegions().add(operationRegion);
		operationRegion.setReferredOperation(ClassUtil.nonNullState(operationCallExp.getReferredOperation()));
		operationRegion.setName(operationName);
		RegionHelper regionHelper = new RegionHelper(scheduleManager, operationRegion);
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
		RootDomainUsageAnalysis domainAnalysis = scheduleManager.getDomainAnalysis();
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
					ClassDatum classDatum = scheduleManager.getClassDatum(stepType, typedModel);
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
								ClassDatum elementClassDatum = scheduleManager.getClassDatum((org.eclipse.ocl.pivot.Class) elementType, typedModel2);
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
									name = QVTcoreUtil.getName(QVTcoreUtil.getReferredProperty((NavigationCallExp)callExp));
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

	public @NonNull Property getCastProperty(@NonNull Type type) {
		Property castProperty = type2castProperty.get(type);
		if (castProperty == null) {
			castProperty = createProperty("«cast»\\n" + type.toString(), type, true);
			type2castProperty.put(type, castProperty);
		}
		return castProperty;
	}

	public @NonNull ClassDatum getClassDatum(@NonNull CompleteClass completeClass, @NonNull TypedModel typedModel) {
		return datumCaches.getClassDatum(typedModel, completeClass);
	}

	public @NonNull ClassDatum getClassDatum(@NonNull TypedElement asTypedElement) {
		org.eclipse.ocl.pivot.Class asType = (org.eclipse.ocl.pivot.Class)asTypedElement.getType();
		assert asType != null;
		Type elementType = PivotUtil.getElementalType(asType);
		TypedModel typedModel;
		if (elementType instanceof DataType) {
			typedModel = getDomainAnalysis().getPrimitiveTypeModel();
		}
		else {
			DomainUsage domainUsage = getDomainUsage(asTypedElement);
			assert domainUsage != null;
			typedModel = domainUsage.getTypedModel(asTypedElement);
			assert typedModel != null;
		}
		return datumCaches.getClassDatum(typedModel, asType);
	}

	public @NonNull ClassDatum getClassDatum(org.eclipse.ocl.pivot.@NonNull Class asType, @NonNull TypedModel typedModel) {
		return datumCaches.getClassDatum(typedModel, asType);
	}

	/*	public @NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull ClassDatum classDatum) {
		ClassDatumAnalysis classDatumAnalysis = classDatum2classDatumAnalysis.get(classDatum);
		if (classDatumAnalysis == null) {
			classDatumAnalysis = new ClassDatumAnalysis(this, classDatum);
			classDatum2classDatumAnalysis.put(classDatum, classDatumAnalysis);
		}
		return classDatumAnalysis;
	} */

	//	public @NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull Element contextElement, @NonNull Type type) {
	//		ClassDatum classDatum = getClassDatum(type);
	//		DomainUsage usage = getDomainUsage(contextElement);
	//		return getClassDatumAnalysis(classDatum, ClassUtil.nonNullState(usage));
	//	}

	/*	public @NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull Type type, @NonNull DomainUsage usage) {
		ClassDatum classDatum = getClassDatum(type);
//		DomainUsage usage = getDomainUsage(contextElement);
		return getClassDatumAnalysis(classDatum);
	} */

	/*	public @NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull TypedElement typedElement) {
		ClassDatum classDatum = getClassDatum(typedElement);
		//		DomainUsage usage = getDomainUsage(typedElement);
		return getClassDatumAnalysis(classDatum);
	} */

	/*	public @NonNull ClassDatumAnalysis getClassDatumAnalysis(org.eclipse.ocl.pivot.@NonNull Class type, @NonNull TypedModel typedModel) {
		ClassDatum classDatum = datumCaches.getClassDatum(typedModel, type);
		return getClassDatumAnalysis(classDatum);
	} */

	/*	public @NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull CompleteClass completeClass, @NonNull TypedModel typedModel) {
		ClassDatum classDatum = datumCaches.getClassDatum(typedModel, completeClass);
		return getClassDatumAnalysis(classDatum);
	} */

	public @NonNull Iterable<@NonNull ClassDatum> getClassDatums() {
		return classDatums;
	}

	public @NonNull ContainmentAnalysis getContainmentAnalysis() {
		return datumCaches.getContainmentAnalysis();
	}

	public @NonNull RootDomainUsageAnalysis getDomainAnalysis() {
		return domainAnalysis;
	}

	public @NonNull DomainUsage getDomainUsage(@NonNull Element element) {
		if (element instanceof ClassDatum) {
			return getDomainUsage(QVTscheduleUtil.getReferredTypedModel((ClassDatum)element));
		}
		DomainUsageAnalysis analysis = domainAnalysis;
		Operation operation = PivotUtil.getContainingOperation(element);
		if (operation != null) {
			analysis = domainAnalysis.getAnalysis(operation);
		}
		return ClassUtil.nonNullState(analysis.getUsage(element));
	}

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
			return getClassDatum((org.eclipse.ocl.pivot.Class)elementType, typedModel);
		}
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	protected @NonNull URI getGraphsBaseURI() {
		return transformation.eResource().getURI().trimSegments(1).appendSegment("graphs").appendSegment("");
	}

	public @NonNull Property getIterateProperty(@NonNull Type type) {
		Property iterateProperty = type2iterateProperty.get(type);
		if (iterateProperty == null) {
			iterateProperty = createProperty("«iterate»", type, true);
			type2iterateProperty.put(type, iterateProperty);
		}
		return iterateProperty;
	}

	public @NonNull ClassDatum getOclVoidClassDatum() {
		return oclVoidClassDatum;
	}

	public @NonNull OperationDependencyAnalysis getOperationDependencyAnalysis() {
		OperationDependencyAnalysis operationDependencyAnalysis2 = operationDependencyAnalysis;
		if (operationDependencyAnalysis2 == null) {
			operationDependencyAnalysis = operationDependencyAnalysis2 = new OperationDependencyAnalysis(getContainmentAnalysis(), getDomainAnalysis());
		}
		return operationDependencyAnalysis2;
	}

	protected @NonNull Iterable<@NonNull RuleRegion> getOrderedMappings() {
		List<@NonNull RuleRegion> orderedMappings2 = orderedMappings;
		if (orderedMappings2 == null) {
			orderedMappings2 = orderedMappings = new ArrayList<>();
			for (@NonNull Rule rule : ClassUtil.nullFree(transformation.getRule())) {
				orderedMappings.add((RuleRegion)rule);
			}
			Collections.sort(orderedMappings2, NameUtil.NAMEABLE_COMPARATOR);
		}
		return orderedMappings2;
	}

	public @NonNull PropertyDatum getPropertyDatum(@NonNull ClassDatum classDatum, @NonNull Property property) {
		return datumCaches.getPropertyDatum(classDatum, property);
	}

	public @NonNull RegionAnalysis getRegionAnalysis(@NonNull Region region) {
		RegionAnalysis regionAnalysis = region2regionAnalysis.get(region);
		if (regionAnalysis == null) {
			regionAnalysis = new RegionAnalysis(this, region);
			region2regionAnalysis.put(region, regionAnalysis);
		}
		return regionAnalysis;
	}

	public @NonNull ScheduleModel getScheduleModel() {
		return scheduleModel;
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return environmentFactory.getStandardLibrary();
	}

	public @NonNull StandardLibraryHelper getStandardLibraryHelper() {
		return standardLibraryHelper;
	}

	/*	public @NonNull Property getStatusProperty(@NonNull Node node) {
		assert isMiddle(node);
		CompleteClass completeClass = node.getCompleteClass();
		return ClassUtil.nonNullState(completeClass.getProperty(QVTrNameGenerator.TRACECLASS_STATUS_PROPERTY_NAME));
	} */

	public @NonNull PropertyDatum getSuccessPropertyDatum(@NonNull Property successProperty) {
		return datumCaches.getSuccessPropertyDatum(successProperty);
	}

	public @NonNull Iterable<@NonNull ClassDatum> getSuperClassDatums(@NonNull ClassDatum classDatum) {
		List<@NonNull ClassDatum> superClassDatums = QVTscheduleUtil.Internal.getSuperClassDatumsList(classDatum);
		if (superClassDatums.isEmpty()) {
			DomainUsage domainUsage = getDomainUsage(classDatum);
			CompleteClass completeClass = classDatum.getCompleteClass();
			for (@NonNull CompleteClass completeSuperClass : completeClass.getSuperCompleteClasses()) {
				ClassDatum superClassDatum = getClassDatum(completeSuperClass, ClassUtil.nonNullState(domainUsage.getTypedModel(completeClass)));
				if (!superClassDatums.contains(superClassDatum)) {
					superClassDatums.add(superClassDatum);
				}
			}
		}
		return superClassDatums;
	}

	public @NonNull Transformation getTransformation() {
		return transformation;
	}

	/**
	 * Return true if a mapping may assign this property in an input model.
	 */
	public boolean isDirty(@NonNull Property property) {
		return domainAnalysis.isDirty(property);
	}

	/**
	 * Return true if the elemental source type of thatEdge is compatible with the source type of thisEdge.
	 */
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

	/**
	 * Return true if node is part of the middle (traced) domain.
	 */
	public boolean isMiddle(@NonNull Node node) {
		return getDomainUsage(QVTscheduleUtil.getClassDatum(node)).isMiddle();
	}

	public boolean isNoEarlyMerge() {
		Map<@NonNull Key<? extends Object>, @Nullable Object> schedulerOptions2 = schedulerOptions;
		if (schedulerOptions2 == null) {
			return false;
		}
		return schedulerOptions2.get(CompilerChain.SCHEDULER_NO_EARLY_MERGE) == Boolean.TRUE;
	}

	public boolean isNoLateConsumerMerge() {
		Map<@NonNull Key<? extends Object>, @Nullable Object> schedulerOptions2 = schedulerOptions;
		if (schedulerOptions2 == null) {
			return false;
		}
		return schedulerOptions2.get(CompilerChain.SCHEDULER_NO_LATE_CONSUMER_MERGE) == Boolean.TRUE;
	}

	public boolean isKnown(@NonNull VariableDeclaration sourceVariable) {
		if (sourceVariable.eContainer() == null) {		// Synthetic variable
			return false;
		}
		DomainUsage usage = getDomainUsage(sourceVariable);
		assert usage != null;
		return !usage.isOutput();
	}

	public void setScheduledRegion(@NonNull MappingRegion mappingRegion, @Nullable ScheduledRegion scheduledRegion) {
		mappingRegion.setScheduledRegion(scheduledRegion);
	}

	public void writeCallDOTfile(@NonNull ScheduledRegion region, @NonNull String suffix) {
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

	public void writeCallGraphMLfile(@NonNull ScheduledRegion region, @NonNull String suffix) {
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

	public void writeDebugGraphs(@NonNull ScheduledRegion scheduledRegion, @NonNull String context, boolean doNodesGraph, boolean doRegionGraph, boolean doCallGraph) {
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

	public void writeDebugGraphs(@NonNull Region region, @Nullable String context) {
		String suffix = context != null ? "-" + context : null;
		writeDOTfile(region, suffix);
		writeGraphMLfile(region, suffix);
	}


	public void writeDOTfile(@NonNull Region region, @Nullable String suffix) {
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

	public void writeGraphMLfile(@NonNull Region region, @Nullable String suffix) {
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

	public void writeRegionDOTfile(@NonNull ScheduledRegion region, @NonNull String suffix) {
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

	public void writeRegionGraphMLfile(@NonNull ScheduledRegion region, @NonNull String suffix) {
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