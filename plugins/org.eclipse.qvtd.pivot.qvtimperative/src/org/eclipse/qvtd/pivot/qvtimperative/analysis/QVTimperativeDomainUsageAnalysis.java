/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.analysis;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * A QVTimperativeDomainUsageAnalysis identifies a constrained domain result from the DomainUsageAnalysis of an OCL AST node.
 */
public class QVTimperativeDomainUsageAnalysis extends RootDomainUsageAnalysis implements QVTimperativeVisitor<org.eclipse.qvtd.pivot.qvtbase.analysis.DomainUsage>
{
	public QVTimperativeDomainUsageAnalysis(@NonNull EnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	@Override
	public void setUsage(@NonNull Element element, @NonNull DomainUsage newUsage) {
		super.setUsage(element, newUsage);
	}

	@Override
	public @NonNull DomainUsage visitConnectionAssignment(@NonNull ConnectionAssignment object) {
		DomainUsage valueUsage = visit(object.getValue());
		DomainUsage variableUsage = visit(object.getTargetVariable());
		return intersection(variableUsage, valueUsage);
	}

	@Override
	public @NonNull DomainUsage visitConnectionStatement(@NonNull ConnectionStatement object) {
		DomainUsage valueUsage = visit(object.getValue());
		DomainUsage variableUsage = visit(object.getTargetVariable());
		return intersection(variableUsage, valueUsage);
	}

	@Override
	public @NonNull DomainUsage visitConnectionVariable(@NonNull ConnectionVariable object) {
		return visitVariable(object);
	}

	@Override
	public @NonNull DomainUsage visitImperativeBottomPattern(@NonNull ImperativeBottomPattern object) {
		return visitBottomPattern(object);
	}

	@Override
	public @NonNull DomainUsage visitImperativeDomain(@NonNull ImperativeDomain object) {
		return visitCoreDomain(object);
	}

	@Override
	public @NonNull DomainUsage visitImperativeModel(@NonNull ImperativeModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @NonNull DomainUsage visitMapping(@NonNull Mapping object) {
		DomainUsage usage = getNoneUsage();
		setUsage(object, usage);
		visitRule(object);
		visit(object.getGuardPattern());
		visit(object.getBottomPattern());
		visit(object.getMappingStatement());
		return usage;
	}

	@Override
	public @NonNull DomainUsage visitMappingCall(@NonNull MappingCall object) {
		for (MappingCallBinding mappingCallBinding : object.getBinding()) {
			visit(mappingCallBinding);
		}
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitMappingCallBinding(@NonNull MappingCallBinding object) {
		DomainUsage valueUsage = visit(object.getValue());
		DomainUsage variableUsage = visit(object.getBoundVariable());
		return intersection(valueUsage, variableUsage);
	}

	@Override
	public @NonNull DomainUsage visitMappingLoop(@NonNull MappingLoop object) {
		DomainUsage sourceUsage = visit(object.getOwnedSource());
		for (Variable iterator : object.getOwnedIterators()) {
			if (iterator != null) {
				setUsage(iterator, sourceUsage);
			}
		}
		visit(object.getOwnedBody());
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitMappingSequence(@NonNull MappingSequence object) {
		for (MappingStatement mappingStatement : object.getMappingStatements()) {
			visit(mappingStatement);
		}
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitMappingStatement(@NonNull MappingStatement object) {
		return visitOCLExpression(object);
	}

	@Override
	public @NonNull DomainUsage visitOperationCallExp(@NonNull OperationCallExp object) {
		String operationName = object.getReferredOperation().getName();
		if ("objectsOfKind".equals(operationName) || "objectsOfType".equals(operationName)) {				// FIXME stronger test
			for (OCLExpression argument : object.getOwnedArguments()) {
				visit(argument);
			}
			return visit(object.getOwnedSource());
		}
		return super.visitOperationCallExp(object);
	}

	@Override
	public @NonNull DomainUsage visitVariableExp(@NonNull VariableExp object) {
		StandardLibraryInternal standardLibrary = (StandardLibraryInternal) context.getStandardLibrary();
		Type transformationType = standardLibrary.getLibraryType("Transformation");
		if ((transformationType != null) && object.getType().conformsTo(standardLibrary, transformationType)) {
			return getNoneUsage();
		}
		return super.visitVariableExp(object);
	}

	@Override
	public @NonNull DomainUsage visitVariablePredicate(@NonNull VariablePredicate object) {
		return visitPredicate(object);
	}
}
