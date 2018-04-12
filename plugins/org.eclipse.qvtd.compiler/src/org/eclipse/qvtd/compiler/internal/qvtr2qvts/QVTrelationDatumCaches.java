/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

import java.util.HashMap;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.DatumCaches;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;

public class QVTrelationDatumCaches extends DatumCaches
{
	protected QVTrelationDatumCaches(@NonNull QVTrelationScheduleManager scheduleManager) {
		super(scheduleManager);
	}

	@Override
	protected @Nullable RuleRegion analyzeRule(@NonNull RuleAnalysis ruleAnalysis) {
		//		RuleRegion ruleRegion = ruleAnalysis.getRegion();
		Rule rule = ruleAnalysis.getRule();
		//		RuleRegion ruleRegion = QVTscheduleFactory.eINSTANCE.createRuleRegion();
		//		ruleRegion.setOwningScheduleModel(scheduleManager.getScheduleModel());
		//		ruleRegion.setReferredRule(rule);
		//		RuleAction ruleAction = QVTscheduleFactory.eINSTANCE.createRuleAction();
		//		ruleAction.setReferredRuleRegion(ruleRegion);
		//		ruleAction.setOwningScheduleModel(scheduleManager.getScheduleModel());
		//		List<@NonNull AbstractDatum> productions = new ArrayList<>(); //QVTscheduleUtil.Internal.getProducedDatumsList(ruleRegion);
		//		List<@NonNull AbstractDatum> consumptions = new ArrayList<>(); //QVTscheduleUtil.Internal.getConsumedDatumsList(ruleRegion);
		for (@NonNull EObject eObject : new TreeIterable(rule, true)) {
			/*if (eObject instanceof GuardPattern) {
				for (@NonNull Variable inputVar : QVTcoreUtil.getOwnedVariables((GuardPattern)eObject)) {
					TypedModel typedModel = getTypedModel(inputVar);
					consumptions.add(getClassDatum(typedModel, QVTcoreUtil.getClass(inputVar)));
				}
			}
			else if (eObject instanceof RealizedVariable) {
				RealizedVariable outputVar = (RealizedVariable) eObject;
				TypedModel typedModel = getTypedModel(outputVar);
				productions.add(getClassDatum(typedModel, QVTcoreUtil.getClass(outputVar)));
			}
			else*/ if (eObject instanceof OperationCallExp) {
				OperationCallExp opCall = (OperationCallExp)eObject;
				OCLExpression ownedSource = QVTrelationUtil.getOwnedSource(opCall);
				Type type = QVTrelationUtil.getType(ownedSource);
				CompleteClass context = completeModel.getCompleteClass(type);
				@SuppressWarnings("unused")
				Set<@NonNull PropertyDatum> operationPropertyDatum = getOperationPropertyDatums(opCall, context, new HashMap<>(), new HashMap<>());
				//				consumptions.addAll(operationPropertyDatum);
			}
			/* else if (eObject instanceof NavigationAssignment) {
				productions.addAll(getAssignedPropertyDatums((NavigationAssignment)eObject));
			} */
			else if (eObject instanceof NavigationCallExp) {
				NavigationCallExp navigationCallExp = (NavigationCallExp)eObject;
				OCLExpression source = QVTrelationUtil.getOwnedSource(navigationCallExp);
				TypedModel typedModel = getTypedModel(source);
				Property property = QVTrelationUtil.getReferredProperty(navigationCallExp);
				org.eclipse.ocl.pivot.Class context = QVTrelationUtil.getClass(source);
				@SuppressWarnings("unused")
				PropertyDatum propertyDatum = getPropertyDatum(typedModel, context, property);
				//				consumptions.add(propertyDatum);
			}
			else if (eObject instanceof PropertyTemplateItem) {
				PropertyTemplateItem propertyTemplateItem = (PropertyTemplateItem)eObject;
				ObjectTemplateExp sourceExpression = QVTrelationUtil.getOwningObjectTemplateExp(propertyTemplateItem);
				Variable sourceVariable = QVTrelationUtil.getBindsTo(sourceExpression);
				TypedModel typedModel = getTypedModel(sourceVariable);
				Property property = QVTrelationUtil.getReferredProperty(propertyTemplateItem);
				org.eclipse.ocl.pivot.Class context = QVTrelationUtil.getClass(sourceVariable);
				@SuppressWarnings("unused")
				PropertyDatum propertyDatum = getPropertyDatum(typedModel, context, property);
				//				consumptions.add(propertyDatum);
			}
		}
		return null; //ruleRegion;
	}
}