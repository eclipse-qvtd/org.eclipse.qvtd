/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtimperative.cs2as;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.util.AbstractQVTimperativeCSPostOrderVisitor;

public class QVTimperativeCSPostOrderVisitor extends AbstractQVTimperativeCSPostOrderVisitor
{

	public QVTimperativeCSPostOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	protected @Nullable Assignment refreshPropertyAssignment(@NonNull PropertyCallExp propertyCallExp, @NonNull AssignmentCS csConstraint) {
		@NonNull PropertyAssignment propertyAssignment;
		Property referredProperty = propertyCallExp.getReferredProperty();
		Property oppositeProperty = referredProperty.getOpposite();
		if ((oppositeProperty != null) && oppositeProperty.isImplicit() && QVTimperativeCS2Pivot.isMiddle(referredProperty.getOwningType(), csConstraint)) {
			propertyAssignment = context.refreshModelElement(MiddlePropertyAssignment.class,
				QVTimperativePackage.Literals.MIDDLE_PROPERTY_ASSIGNMENT, csConstraint);
		}
		else {
			propertyAssignment = context.refreshModelElement(PropertyAssignment.class,
				QVTcoreBasePackage.Literals.PROPERTY_ASSIGNMENT, csConstraint);
		}
		propertyAssignment.setSlotExpression(propertyCallExp.getSource());
		propertyAssignment.setTargetProperty(propertyCallExp.getReferredProperty());
		return propertyAssignment;
	}

	@Override
	public Continuation<?> visitGuardPatternCS(@NonNull GuardPatternCS csElement) {
		GuardPattern pGuardPattern = PivotUtil.getPivot(GuardPattern.class, csElement);
		if (pGuardPattern != null) {
			List<Predicate> pPredicates = new ArrayList<Predicate>(); 
			for (AssignmentCS csConstraint : csElement.getConstraints()) {
				ExpCS csTarget = csConstraint.getTarget();
				ExpCS csInitialiser = csConstraint.getInitialiser();
				OCLExpression target = csTarget != null ? context.visitLeft2Right(OCLExpression.class, csTarget) : null;
				if (csInitialiser != null) {
					if (target instanceof VariableExp) {
						@NonNull VariablePredicate predicate = context.refreshModelElement(VariablePredicate.class, QVTimperativePackage.Literals.VARIABLE_PREDICATE, csConstraint);
						Variable variable = (Variable) ((VariableExp)target).getReferredVariable();
						OCLExpression initialiser = context.visitLeft2Right(OCLExpression.class, csInitialiser);
						predicate.setConditionExpression(initialiser);
						predicate.setTargetVariable(variable);
						pPredicates.add(predicate);
					}
					else if (target != null) {
						context.addDiagnostic(csElement, "unrecognised Guard Constraint target " + target.eClass().getName());
					}
				}
				else {
					@NonNull Predicate predicate = context.refreshModelElement(Predicate.class, QVTbasePackage.Literals.PREDICATE, csConstraint);
					predicate.setConditionExpression(target);
					pPredicates.add(predicate);
				}
				if (csConstraint.isDefault()) {
					context.addDiagnostic(csElement, "misplaced default ignored");
				}
			}
			PivotUtil.refreshList(pGuardPattern.getPredicate(), pPredicates);
		}
		return null;
	}

	@Override
	public Continuation<?> visitMappingCS(@NonNull MappingCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitMappingCallBindingCS(@NonNull MappingCallBindingCS csElement) {
		MappingCallBinding pBinding = PivotUtil.getPivot(MappingCallBinding.class, csElement);
		if (pBinding != null) {
			ExpCS expression = csElement.getValue();
			if (expression != null) {
				OCLExpression target = context.visitLeft2Right(OCLExpression.class, expression);
				pBinding.setValue(target);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitTopLevelCS(@NonNull TopLevelCS object) {
		return null;
	}
}