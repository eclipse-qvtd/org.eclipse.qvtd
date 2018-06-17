/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Horacio Hoyos - initial migration from Epsilon prototype
 *     E.D.Willink - simplification
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * DatumCaches maintains the caches of ClassDatum and PropertyDatum that establish the inter-Mapping connectivity.
 */
public class QVTcoreDatumCaches extends DatumCaches
{
	public QVTcoreDatumCaches(@NonNull ScheduleManager scheduleManager) {
		super(scheduleManager);
	}

	@Override
	protected @NonNull RuleRegion analyzeRule(@NonNull RuleAnalysis ruleAnalysis) {
		RuleRegion ruleRegion = ruleAnalysis.getRegion();
		Rule rule = ruleAnalysis.getRule();
		List<@NonNull AbstractDatum> productions = QVTscheduleUtil.Internal.getProducedDatumsList(ruleRegion);
		List<@NonNull AbstractDatum> consumptions = QVTscheduleUtil.Internal.getConsumedDatumsList(ruleRegion);
		for (@NonNull EObject eObject : new TreeIterable(rule, true)) {
			if (eObject instanceof GuardPattern) {
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
			else if (eObject instanceof OperationCallExp) {
				OperationCallExp opCall = (OperationCallExp)eObject;
				OCLExpression ownedSource = QVTcoreUtil.getOwnedSource(opCall);
				Type type = QVTcoreUtil.getType(ownedSource);
				CompleteClass context = completeModel.getCompleteClass(type);
				consumptions.addAll(getOperationPropertyDatums(opCall, context, new HashMap<>(), new HashMap<>()));
			}
			else if (eObject instanceof NavigationAssignment) {
				productions.addAll(getAssignedPropertyDatums((NavigationAssignment)eObject));
			}
			else if (eObject instanceof NavigationCallExp) {
				NavigationCallExp navigationCallExp = (NavigationCallExp)eObject;
				OCLExpression source = QVTcoreUtil.getOwnedSource(navigationCallExp);
				TypedModel typedModel = getTypedModel(source);
				Property property = QVTcoreUtil.getReferredProperty(navigationCallExp);
				org.eclipse.ocl.pivot.Class context = QVTcoreUtil.getClass(source);
				PropertyDatum propertyDatum = getPropertyDatum(typedModel, context, property);
				consumptions.add(propertyDatum);
			}
		}
		return ruleRegion;
	}

	private @NonNull Set<@NonNull PropertyDatum> getAssignedPropertyDatums(@NonNull NavigationAssignment propAssign) {
		Set<@NonNull PropertyDatum> result = new HashSet<>();
		Property targetProp = QVTcoreUtil.getTargetProperty(propAssign);
		OCLExpression slotExpression = QVTcoreUtil.getSlotExpression(propAssign);
		TypedModel typedModel = getTypedModel(slotExpression);
		PropertyDatum targetDatum = getPropertyDatum(typedModel, QVTcoreUtil.getClass(slotExpression), targetProp);
		result.add(targetDatum);
		Property oppositeProp = targetProp.getOpposite();
		if (oppositeProp != null) {
			OCLExpression value = QVTcoreUtil.getValue(propAssign);
			DomainUsage valueUsage = getUsage(value);
			if (valueUsage == null) {
				getUsage(value);
				throw new IllegalStateException("No DomainUsage for " + value);
			}
			//			if (valueUsage == domainUsageAnalysis.getNoneUsage()) {
			//				getUsage(value);
			//				throw new IllegalStateException("None DomainUsage for " + value);
			//			}
			Type propertyType = targetProp.getType();
			if ((propertyType != null) && (propertyType.getESObject() != EcorePackage.Literals.EOBJECT)) {		// FIXME Legacy fix tolerating undeclared import of EObject
				DomainUsage propertyUsage = getUsage(propertyType);
				if (propertyUsage == null) {
					getUsage(propertyType);
					throw new IllegalStateException("No DomainUsage for " + propertyType);
				}
				if ((valueUsage != domainUsageAnalysis.getNoneUsage()) && (valueUsage != domainUsageAnalysis.getPrimitiveUsage())) {
					valueUsage = domainUsageAnalysis.intersection(propertyUsage, valueUsage);
				}
				else {
					valueUsage = propertyUsage;
				}
			}
			TypedModel oppositeTypedModel = valueUsage.getTypedModel(propAssign);
			if (oppositeTypedModel == null) {
				@SuppressWarnings("unused") DomainUsage valueUsage2 = getUsage(value);
				@SuppressWarnings("unused") DomainUsage propertyUsage2 = propertyType != null ? getUsage(propertyType) : null;
				oppositeTypedModel = valueUsage.getTypedModel(propAssign);
				throw new IllegalStateException("No left/right DomainUsage commonality for \"" + propAssign + "\"");
			}
			PropertyDatum oppositeDatum = getPropertyDatum(oppositeTypedModel, getElementClass(targetProp), oppositeProp);
			targetDatum.setOpposite(oppositeDatum);		// FIXME this property is obsolete
			result.add(oppositeDatum);
		}
		return result;
	}
}
