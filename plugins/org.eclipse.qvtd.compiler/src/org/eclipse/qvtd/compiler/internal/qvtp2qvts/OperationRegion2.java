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
import org.eclipse.ocl.pivot.CallExp;
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
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.OperationDependencyAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.OperationDependencyPaths;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.OperationDependencyStep;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.DOTStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphMLStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatumAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.MultiRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.SchedulerConstants;
import org.eclipse.qvtd.pivot.qvtschedule.impl.OperationRegionImpl;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;
import com.google.common.collect.Iterables;

public class OperationRegion2 extends OperationRegionImpl
{
	protected final @NonNull Operation operation;
	protected final @NonNull String name;
	private final @NonNull List<@NonNull Node> headNodes = new ArrayList<>();
	private final @NonNull Node resultNode;
	private final @NonNull List<@NonNull Node> dependencyNodes = new ArrayList<>();
	private final @NonNull Map<@NonNull VariableDeclaration, @NonNull Node> parameter2node = new HashMap<>();

	protected OperationRegion2(@NonNull MultiRegion multiRegion, @NonNull OperationDatum operationDatum, @NonNull ExpressionInOCL specification, @NonNull OperationCallExp operationCallExp) {//, @NonNull Node sourceNode) {
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
		RegionUtil.createExpressionEdge(dependencyNode, QVTscheduleConstants.EQUALS_NAME, resultNode);
		//
		List<Variable> ownedParameters = specification.getOwnedParameters();
		List<OCLExpression> ownedArguments = operationCallExp.getOwnedArguments();
		int iSize = Math.min(ownedArguments.size(), ownedParameters.size());
		for (int i = 0; i < iSize; i++) {
			Variable parameter = ownedParameters.get(i);
			createParameterNode(parameter, ClassUtil.nonNullState(parameter.getName()), ClassUtil.nonNullState(ownedArguments.get(i)));
		}
		//
		SchedulerConstants2 schedulerConstants = (SchedulerConstants2) getSchedulerConstants();
		OperationDependencyAnalysis operationDependencyAnalysis = schedulerConstants.getOperationDependencyAnalysis();
		//		OperationDependencyAnalysis operationDependencyAnalysis = new OperationDependencyAnalysis(schedulerConstants);
		//		operationDependencyAnalysis.dump();
		OperationDependencyPaths paths = operationDependencyAnalysis.analyzeOperation(operationCallExp);
		//		operationDependencyAnalysis.dump();
		//		System.out.println("Analyze2 " + operationCallExp + " gives\n\t" + paths);
		Iterable<@NonNull List<@NonNull OperationDependencyStep>> hiddenPaths = paths.getHiddenPaths();
		Iterable<@NonNull List<@NonNull OperationDependencyStep>> returnPaths = paths.getReturnPaths();
		RootDomainUsageAnalysis domainAnalysis = schedulerConstants.getDomainAnalysis();
		Map<@NonNull ClassDatumAnalysis, @NonNull Node> classDatumAnalysis2node = new HashMap<>();
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
							OperationDependencyStep.PropertyStep step = (OperationDependencyStep.PropertyStep) steps.get(i);
							Property property = step.getProperty();
							CallExp callExp = step.getCallExp();
							assert (property != null) && (callExp != null);
							//						stepUsage = propertyStep.getUsage();
							//						typedModel = stepUsage.getTypedModel();
							//						assert typedModel != null;
							//						stepType = propertyStep.getType();
							//						classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(stepType, typedModel);
							//						Node nextNode = RegionUtil.StepNodeRoleFactory.PREDICATED_STEP.createNode(this, "next", classDatumAnalysis);

							if (primaryClass instanceof CollectionType) {
								Property iterateProperty = schedulerConstants.getIterateProperty(primaryClass);
								Type elementType = PivotUtil.getElementType((CollectionType)primaryClass);
								TypedModel typedModel2 = classDatumAnalysis.getTypedModel();
								ClassDatumAnalysis elementClassDatumAnalysis = schedulerConstants.getClassDatumAnalysis((org.eclipse.ocl.pivot.Class) elementType, typedModel2);
								Node elementNode = RegionUtil.createOperationElementNode(this, name, elementClassDatumAnalysis, dependencyNode2);
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
		toGraph(new DOTStringBuilder());
		toGraph(new GraphMLStringBuilder());
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitOperationRegion(this);
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

	@Override
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
		s.setColor(QVTscheduleConstants.OPERATION_COLOR);
		s.setPenwidth(QVTscheduleConstants.LINE_WIDTH);
		super.toGraph(s);
	}
}