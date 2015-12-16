/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.LiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractExtendingQVTimperativeVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 * QVTiTuneUpVisitor enhances the structure of a QVTi transformation to simplify execution.
 * <p>
 * Improvements are
 * - VariableAssignments before PropertyAssignments
 * - all CallExps within PropertyAssignments redirected via an intermediate VariableAssignment
 * - MappingCallBindings are sorted into alphabetical order
 * <p>
 * With OCLExpressions a TRUE/FALSE return indicates the presence of a nested CallExp
 */
public class QVTiTuneUpVisitor extends AbstractExtendingQVTimperativeVisitor<Boolean, Object>
{
	public static final @NonNull QVTiTuneUpVisitor INSTANCE = new QVTiTuneUpVisitor(QVTiTuneUpVisitor.class);
	
	protected QVTiTuneUpVisitor(@NonNull Object context) {
		super(context);
	}

	protected @NonNull VariableExp rewritePropertyAssignmentTerm(@NonNull BottomPattern bottomPattern,
			@NonNull List<Assignment> variableAssignments, @NonNull OCLExpression expression) {
		Variable variable = PivotFactory.eINSTANCE.createVariable();
		variable.setName("_" + variableAssignments.size());
		variable.setType(expression.getType());
		variable.setTypeValue(expression.getTypeValue());
		variable.setIsRequired(expression.isIsRequired());
		bottomPattern.getVariable().add(variable);
		VariableAssignment variableAssignment = QVTcoreBaseFactory.eINSTANCE.createVariableAssignment();
		variableAssignment.setTargetVariable(variable);
		variableAssignment.setValue(expression);
		variableAssignments.add(variableAssignment);
		VariableExp variableExp = PivotFactory.eINSTANCE.createVariableExp();
		variableExp.setReferredVariable(variable);
		variableExp.setType(expression.getType());
		variableExp.setTypeValue(expression.getTypeValue());
		variableExp.setIsRequired(expression.isIsRequired());
		return variableExp;
	}

	@Override
	public @Nullable Boolean visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for QVTi Tune Up");
	}

	@Override
	public @Nullable Boolean visitBottomPattern(@NonNull BottomPattern object) {
		List<Assignment> variableAssignments = new ArrayList<Assignment>();
		List<Assignment> propertyAssignments = new ArrayList<Assignment>();
		for (Assignment assignment : object.getAssignment()) {
			if (assignment instanceof ConnectionAssignment) {
				variableAssignments.add(assignment);
			}
			else if (assignment instanceof VariableAssignment) {
				variableAssignments.add(assignment);
			}
			else if (assignment instanceof PropertyAssignment) {
				PropertyAssignment propertyAssignment = (PropertyAssignment)assignment;
				OCLExpression slot = propertyAssignment.getSlotExpression();
				if ((slot != null) && (slot.accept(this) != Boolean.TRUE)) {
					propertyAssignment.setSlotExpression(null);			// Avoid a child stealing detection
					VariableExp variableExp = rewritePropertyAssignmentTerm(object, variableAssignments, slot);
					propertyAssignment.setSlotExpression(variableExp);
				}
				OCLExpression value = propertyAssignment.getValue();
				if ((value != null) && (value.accept(this) != Boolean.TRUE)) {
					propertyAssignment.setValue(null);			// Avoid a child stealing detection
					VariableExp variableExp = rewritePropertyAssignmentTerm(object, variableAssignments, value);
					propertyAssignment.setValue(variableExp);
				}
				propertyAssignments.add(propertyAssignment);
			}
			else {
				assignment.accept(this);
			}
		}
		variableAssignments.addAll(propertyAssignments);
		ECollections.setEList(object.getAssignment(), variableAssignments);
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean visitCallExp(@NonNull CallExp object) {
		return Boolean.FALSE;
	}

	@Override
	public @Nullable Boolean visitCollectionItem(@NonNull CollectionItem object) {
		OCLExpression ownedItem = object.getOwnedItem();
		if ((ownedItem != null) && (ownedItem.accept(this) != Boolean.TRUE)) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean visitCollectionLiteralExp(@NonNull CollectionLiteralExp object) {
		for (CollectionLiteralPart part : object.getOwnedParts()) {
			if ((part != null) && (part.accept(this) != Boolean.TRUE)) {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean visitCollectionRange(@NonNull CollectionRange object) {
		OCLExpression ownedFirst = object.getOwnedFirst();
		OCLExpression ownedLast = object.getOwnedLast();
		if ((ownedFirst != null) && (ownedFirst.accept(this) != Boolean.TRUE)) {
			return Boolean.FALSE;
		}
		if ((ownedLast != null) && (ownedLast.accept(this) != Boolean.TRUE)) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean visitCoreDomain(@NonNull CoreDomain object) {
		object.getGuardPattern().accept(this);
		object.getBottomPattern().accept(this);
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean visitGuardPattern(@NonNull GuardPattern object) {
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean visitIfExp(@NonNull IfExp object) {
		OCLExpression ownedCondition = object.getOwnedCondition();
		OCLExpression ownedThen = object.getOwnedThen();
		OCLExpression ownedElse = object.getOwnedElse();
		if ((ownedCondition != null) && (ownedCondition.accept(this) != Boolean.TRUE)) {
			return Boolean.FALSE;
		}
		if ((ownedThen != null) && (ownedThen.accept(this) != Boolean.TRUE)) {
			return Boolean.FALSE;
		}
		if ((ownedElse != null) && (ownedElse.accept(this) != Boolean.TRUE)) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean visitLetExp(@NonNull LetExp object) {
		OCLExpression ownedIn = object.getOwnedIn();
		Variable ownedVariable = object.getOwnedVariable();
		if ((ownedIn != null) && (ownedIn.accept(this) != Boolean.TRUE)) {
			return Boolean.FALSE;
		}
		if ((ownedVariable != null) && (ownedVariable.accept(this) != Boolean.TRUE)) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean visitLiteralExp(@NonNull LiteralExp object) {
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean visitMapping(@NonNull Mapping object) {
		for (Domain domain : object.getDomain()) {
			domain.accept(this);
		}
		object.getGuardPattern().accept(this);
		object.getBottomPattern().accept(this);
		MappingStatement mappingStatement = object.getMappingStatement();
		if (mappingStatement != null) {
			mappingStatement.accept(this);
		}
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean visitMappingCall(@NonNull MappingCall object) {
		ECollections.sort(object.getBinding(), QVTimperativeUtil.MappingCallBindingComparator.INSTANCE);
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean visitMappingLoop(@NonNull MappingLoop object) {
		object.getOwnedBody().accept(this);
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean visitMappingSequence(@NonNull MappingSequence object) {
		for (MappingStatement mappingStatement : object.getMappingStatements()) {
			if (mappingStatement != null) {
				mappingStatement.accept(this);
			}
		}
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean visitShadowExp(@NonNull ShadowExp object) {
		for (ShadowPart part : object.getOwnedParts()) {
			if ((part != null) && (part.accept(this) != Boolean.TRUE)) {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean visitShadowPart(@NonNull ShadowPart object) {
		OCLExpression ownedInit = object.getOwnedInit();
		if ((ownedInit != null) && (ownedInit.accept(this) != Boolean.TRUE)) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean visitTransformation(@NonNull Transformation object) {
		for (Rule rule : object.getRule()) {
			rule.accept(this);
		}
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean visitTupleLiteralExp(@NonNull TupleLiteralExp object) {
		for (TupleLiteralPart part : object.getOwnedParts()) {
			if ((part != null) && (part.accept(this) != Boolean.TRUE)) {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean visitTupleLiteralPart(@NonNull TupleLiteralPart object) {
		OCLExpression ownedInit = object.getOwnedInit();
		if ((ownedInit != null) && (ownedInit.accept(this) != Boolean.TRUE)) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean visitVariable(@NonNull Variable object) {
		OCLExpression ownedInit = object.getOwnedInit();
		if ((ownedInit != null) && (ownedInit.accept(this) != Boolean.TRUE)) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Boolean visitVariableExp(@NonNull VariableExp object) {
		return Boolean.TRUE;
	}
}
