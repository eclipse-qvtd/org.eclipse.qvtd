/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.scheduler;

import java.util.ArrayList;
import java.util.Collections;
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
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.scheduler.DependencyAnalyzer.DependencyPaths;
import org.eclipse.qvtd.compiler.internal.scheduler.DependencyAnalyzer.DependencyStep;
import org.eclipse.qvtd.compiler.internal.scheduler.DependencyAnalyzer.NavigationDependencyStep;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphStringBuilder;

import com.google.common.collect.Iterables;

public class OperationRegion extends AbstractMappingRegion
{
	protected final @NonNull Operation operation;
	protected final @NonNull ExpressionInOCL specification;
	protected final @NonNull String name;
//	private final @NonNull List<SimpleNode> iteratorNodes = new ArrayList<SimpleNode>();
	private final @NonNull SimpleNode resultNode;
	private final @NonNull List<Node> extraNodes = new ArrayList<Node>();
	
	protected OperationRegion(@NonNull SuperRegion superRegion, @NonNull OperationDatum operationDatum, @NonNull ExpressionInOCL specification, @NonNull OperationCallExp operationCallExp) {//, @NonNull SimpleNode sourceNode) {
		super(superRegion);
		this.operation = ClassUtil.nonNullState(operationCallExp.getReferredOperation());
		this.specification = specification;
		String name = operationDatum.toString();
		assert name != null;
		this.name = name;
		//
		Variable selfVariable = specification.getOwnedContext();
		OCLExpression source = operationCallExp.getOwnedSource();
		assert source != null;
		SimpleNode selfNode = createParameterNode(selfVariable, ClassUtil.nonNullState(selfVariable.getName()), source);
		SimpleNode extraNode;
		extraNode = selfNode;
		//
		resultNode = Nodes.UNNAVIGABLE_STEP.createSimpleNode(this, "result", operationCallExp, extraNode);				
		Edges.RESULT.createSimpleEdge(this, extraNode, null, resultNode);
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
		DependencyPaths path = dependencyAnalyzer.analyze(operationCallExp);
//		System.out.println("Analyze " + operationCallExp + " gives\n" + path);
		Iterable<List<DependencyStep>> hiddenPaths = path.getHiddenPaths();
		Iterable<List<DependencyStep>> returnPaths = path.getReturnPaths();
		Map<ClassDatumAnalysis, SimpleNode> classDatumAnalysis2node = new HashMap<ClassDatumAnalysis, SimpleNode>();
		for (List<DependencyStep> steps : Iterables.concat(returnPaths, hiddenPaths)) {
			if (steps.size() > 0) {
				DependencyStep classStep = steps.get(0);
				DomainUsage stepUsage = classStep.getUsage();
				if (stepUsage.isEnforceable() && !stepUsage.isCheckable()) {
//					System.out.println("!checkable && enforceable: " + steps);
					org.eclipse.ocl.pivot.Class stepType = steps.get(0).getElementalType();
					TypedModel typedModel = stepUsage.getTypedModel();
					assert typedModel != null;
					ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(stepType, typedModel);
					if (!(classDatumAnalysis.getCompleteClass().getPrimaryClass() instanceof DataType)) {
	//					OCLExpression source = operationCallExp.getOwnedSource();
	//					assert source != null;
	//					createParameterNode(selfVariable, selfVariable.getName(), source);
						SimpleNode extraNode2 = classDatumAnalysis2node.get(classDatumAnalysis);
						if (extraNode2 == null) {
							extraNode2 = createParameterNode(classDatumAnalysis, "extra2_" + stepType.getName());
							classDatumAnalysis2node.put(classDatumAnalysis, extraNode2);
							extraNodes.add(extraNode2);
						}
	//					extraNodes.add(extraNode);
						for (int i = 1; i < steps.size(); i++) {
							NavigationDependencyStep propertyStep = (NavigationDependencyStep)steps.get(i);
							NavigationCallExp navigationCallExp = propertyStep.getNavigationCallExp();
	//						stepUsage = propertyStep.getUsage();
	//						typedModel = stepUsage.getTypedModel();
	//						assert typedModel != null;
	//						stepType = propertyStep.getType();
	//						classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(stepType, typedModel);
	//						SimpleNode nextNode = Nodes.StepNodeRoleFactory.PREDICATED_STEP.createSimpleNode(this, "next", classDatumAnalysis);
							
							CompleteClass completeClass = extraNode2.getCompleteClass();
							Type primaryClass = completeClass.getPrimaryClass();
							if (primaryClass instanceof CollectionType) {
								Property iterateProperty = schedulerConstants.getIterateProperty(primaryClass);
								Type elementType = ((CollectionType)primaryClass).getElementType();
								TypedModel typedModel2 = extraNode2.getClassDatumAnalysis().getTypedModel();
								ClassDatumAnalysis elementClassDatumAnalysis = schedulerConstants.getClassDatumAnalysis((@NonNull Class) elementType, typedModel2);
								SimpleNode elementNode = Nodes.ELEMENT.createSimpleNode(this, name, elementClassDatumAnalysis, extraNode2);
								//(region, name, typedElement, argNodes)SimpleNode(region, name, callExp, sourceNode)Node(this, name, iterateProperty, extraNode2);
								Edges.NAVIGATION.createSimpleEdge(this, extraNode2, iterateProperty, elementNode);
								extraNode2 = elementNode;
							}
							SimpleNode nextNode = Nodes.ATTRIBUTE.createSimpleNode(this, extraNode2, navigationCallExp);
							Edges.NAVIGATION.createSimpleEdge(this, extraNode2, propertyStep.getProperty(), nextNode);
							extraNode2 = nextNode;
						}
					}
				}
				else {
//					System.out.println("checkable || !enforceable: " + steps);			
				}
			}
		}			
		
		
		
		
		//
		getHeadNodeGroups();
		toDOT();
		toGraphML();
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitOperationRegion(this);
	}
	
	@Override
	public @NonNull SimpleNode createExtraGuard(@NonNull Node extraNode) {
		throw new UnsupportedOperationException();
	}

	private @NonNull SimpleNode createParameterNode(@NonNull Variable variable, @NonNull String name, @NonNull OCLExpression expression) {
		SchedulerConstants schedulerConstants = getSchedulerConstants();
		org.eclipse.ocl.pivot.Class type = (org.eclipse.ocl.pivot.Class)expression.getType();
		assert type != null;
		TypedModel typedModel = schedulerConstants.getDomainUsage(expression).getTypedModel();
		assert typedModel != null;
		ClassDatumAnalysis classDatumAnalysis = schedulerConstants.getClassDatumAnalysis(type, typedModel);
		SimpleNode parameterNode = Nodes.PARAMETER.createSimpleNode(this, name, classDatumAnalysis);
		addVariableNode(variable, parameterNode);
		addHeadGroup(ClassUtil.nonNullState(Collections.<Node>singletonList(parameterNode)));
		return parameterNode;
	}

	private @NonNull SimpleNode createParameterNode(@NonNull ClassDatumAnalysis classDatumAnalysis, @NonNull String name) {
		SimpleNode parameterNode = Nodes.PARAMETER.createSimpleNode(this, name, classDatumAnalysis);
//		addVariableNode(variable, parameterNode);
		addHeadGroup(ClassUtil.nonNullState(Collections.<Node>singletonList(parameterNode)));
		return parameterNode;
	}

	public @NonNull List<Node> getExtraNodes() {
		return extraNodes;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	public @NonNull SimpleNode getResultNode() {
		return resultNode;
	}
	
	@Override
	public @NonNull SimpleNode getUnknownNode(@NonNull TypedElement typedElement) {
		return ((AbstractMappingRegion)ClassUtil.nonNullState(getInvokingRegion())).getUnknownNode(typedElement);
	}

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