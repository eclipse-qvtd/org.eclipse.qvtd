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
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.ExpressionInOCL;
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
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.DependencyAnalyzer.DependencyPaths;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.DependencyAnalyzer.DependencyStep;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.SymbolNameBuilder;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.DOTStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphMLStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;

import com.google.common.collect.Iterables;

public class OperationRegion extends AbstractRegion
{
	protected final @NonNull Operation operation;
	protected final @NonNull String name;
	private final @NonNull List<@NonNull Node> headNodes = new ArrayList<>();
	private final @NonNull Node resultNode;
	private final @NonNull List<@NonNull Node> dependencyNodes = new ArrayList<>();
	private final @NonNull Map<@NonNull VariableDeclaration, @NonNull Node> parameter2node = new HashMap<>();

	protected OperationRegion(@NonNull MultiRegion multiRegion, @NonNull OperationDatum operationDatum, @NonNull ExpressionInOCL specification, @NonNull OperationCallExp operationCallExp) {//, @NonNull Node sourceNode) {
		super(multiRegion);
		this.operation = ClassUtil.nonNullState(operationCallExp.getReferredOperation());
		String name = operationDatum.toString();
		assert name != null;
		this.name = name;
		//
		Variable selfVariable = specification.getOwnedContext();
		OCLExpression source = operationCallExp.getOwnedSource();
		assert source != null;
		Node selfNode = createParameterNode(selfVariable, ClassUtil.nonNullState(selfVariable.getName()), source);
		Node dependencyNode;
		dependencyNode = selfNode;
		//
		resultNode = RegionUtil.createStepNode("result", operationCallExp, dependencyNode, false);
		RegionUtil.createExpressionEdge(dependencyNode, ExpressionAnalyzer.EQUALS_NAME, resultNode);
		//
		List<Variable> ownedParameters = specification.getOwnedParameters();
		List<OCLExpression> ownedArguments = operationCallExp.getOwnedArguments();
		int iSize = Math.min(ownedArguments.size(), ownedParameters.size());
		for (int i = 0; i < iSize; i++) {
			Variable parameter = ownedParameters.get(i);
			createParameterNode(parameter, ClassUtil.nonNullState(parameter.getName()), ClassUtil.nonNullState(ownedArguments.get(i)));
		}
		//
		SchedulerConstants schedulerConstants = getSchedulerConstants();
		DependencyAnalyzer dependencyAnalyzer = schedulerConstants.getDependencyAnalyzer();
		//		DependencyAnalyzer dependencyAnalyzer = new DependencyAnalyzer(schedulerConstants);
		//		dependencyAnalyzer.dump();
		DependencyPaths paths = dependencyAnalyzer.analyzeOperation(operationCallExp);
		//		dependencyAnalyzer.dump();
		//		System.out.println("Analyze2 " + operationCallExp + " gives\n\t" + paths);
		Iterable<@NonNull List<@NonNull DependencyStep>> hiddenPaths = paths.getHiddenPaths();
		Iterable<@NonNull List<@NonNull DependencyStep>> returnPaths = paths.getReturnPaths();
		RootDomainUsageAnalysis domainAnalysis = schedulerConstants.getDomainAnalysis();
		Map<org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis, @NonNull Node> classDatumAnalysis2node = new HashMap<>();
		for (List<@NonNull DependencyStep> steps : Iterables.concat(returnPaths, hiddenPaths)) {
			if (steps.size() > 0) {
				boolean isDirty = false;
				for (int i = 1; i < steps.size(); i++) {
					DependencyStep step = steps.get(i);
					Property asProperty = step.getProperty();
					if (asProperty != null) {
						if (domainAnalysis.isDirty(asProperty)) {
							isDirty = true;
							break;
						}
					}
				}
				DependencyStep classStep = steps.get(0);
				DomainUsage stepUsage = classStep.getUsage();
				if (stepUsage.isOutput() && !stepUsage.isInput() || isDirty) {
					//					System.out.println("!checkable && enforceable: " + steps);
					org.eclipse.ocl.pivot.Class stepType = steps.get(0).getElementalType();
					TypedModel typedModel = stepUsage.getTypedModel(classStep.getElement());
					assert typedModel != null;
					ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(stepType, typedModel);
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
								dependencyNode2 = createParameterNode(classDatumAnalysis, "extra2_" + stepType.getName());
								classDatumAnalysis2node.put(classDatumAnalysis, dependencyNode2);
								dependencyNodes.add(dependencyNode2);
							}
						}
						//					dependencyNodes.add(dependencyNode);
						for (int i = 1; i < steps.size(); i++) {
							DependencyStep step = steps.get(i);
							Property property = step.getProperty();
							NavigationCallExp navigationCallExp = step.getNavigationCallExp();
							assert (property != null) && (navigationCallExp != null);
							//						stepUsage = propertyStep.getUsage();
							//						typedModel = stepUsage.getTypedModel();
							//						assert typedModel != null;
							//						stepType = propertyStep.getType();
							//						classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(stepType, typedModel);
							//						Node nextNode = RegionUtil.StepNodeRoleFactory.PREDICATED_STEP.createNode(this, "next", classDatumAnalysis);

							if (primaryClass instanceof CollectionType) {
								Property iterateProperty = schedulerConstants.getIterateProperty(primaryClass);
								Type elementType = ((CollectionType)primaryClass).getElementType();
								TypedModel typedModel2 = classDatumAnalysis.getTypedModel();
								ClassDatumAnalysis elementClassDatumAnalysis = schedulerConstants.getClassDatumAnalysis((@NonNull Class) elementType, typedModel2);
								Node elementNode = RegionUtil.createOperationElementNode(this, name, elementClassDatumAnalysis, dependencyNode2);
								//(region, name, typedElement, argNodes)Node(region, name, callExp, sourceNode)Node(this, name, iterateProperty, dependencyNode2);
								RegionUtil.createNavigationEdge(dependencyNode2, iterateProperty, elementNode);
								dependencyNode2 = elementNode;
							}
							//							assert !dependencyNode2.isMatched();
							Node nextNode = RegionUtil.createDataTypeNode(dependencyNode2, navigationCallExp);			// FIXME re-use shared paths
							RegionUtil.createNavigationEdge(dependencyNode2, property, nextNode);
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
		toGraph(new DOTStringBuilder());
		toGraph(new GraphMLStringBuilder());
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitOperationRegion(this);
	}

	@Override
	protected @NonNull SymbolNameBuilder computeSymbolName() {
		SymbolNameBuilder s = new SymbolNameBuilder();
		s.appendString("o_");
		s.appendName(name);
		return s;
	}

	private @NonNull Node createParameterNode(@NonNull Variable variable, @NonNull String name, @NonNull OCLExpression expression) {
		SchedulerConstants schedulerConstants = getSchedulerConstants();
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)expression.getType();
		assert type != null;
		TypedModel typedModel = schedulerConstants.getDomainUsage(expression).getTypedModel(expression);
		assert typedModel != null;
		ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(type, typedModel);
		Node parameterNode = RegionUtil.createOperationParameterNode(this, name, classDatumAnalysis);
		//		addVariableNode(variable, parameterNode);
		headNodes.add(parameterNode);
		parameter2node.put(variable, parameterNode);
		return parameterNode;
	}

	private @NonNull Node createParameterNode(@NonNull ClassDatumAnalysis classDatumAnalysis, @NonNull String name) {
		Node parameterNode = RegionUtil.createOperationParameterNode(this, name, classDatumAnalysis);
		//		addVariableNode(variable, parameterNode);
		headNodes.add(parameterNode);
		return parameterNode;
	}

	public @NonNull List<@NonNull Node> getDependencyNodes() {
		return dependencyNodes;
	}

	@Override
	public @NonNull List<@NonNull Node> getHeadNodes() {
		return headNodes;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	public @NonNull Node getResultNode() {
		return resultNode;
	}

	//	@Override
	//	public @NonNull Node getUnknownNode(@NonNull TypedElement typedElement) {
	//		return ((BasicMappingRegion)ClassUtil.nonNullState(getInvokingRegion())).getUnknownNode(typedElement);
	//	}

	@Override
	public boolean isOperationRegion() {
		return true;
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.setColor(Role.OPERATION_COLOR);
		s.setPenwidth(Role.LINE_WIDTH);
		super.toGraph(s);
	}
}