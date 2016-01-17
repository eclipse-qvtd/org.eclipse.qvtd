/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
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
public class QVTimperativeDomainUsageAnalysis extends RootDomainUsageAnalysis implements QVTimperativeVisitor<DomainUsage>
{
	public QVTimperativeDomainUsageAnalysis(@NonNull EnvironmentFactoryInternal environmentFactory) {
		super(environmentFactory);
	}

	@Override
	public void setUsage(@NonNull Element element, @NonNull DomainUsage newUsage) {
		super.setUsage(element, newUsage);
	}

	@Override
	public @Nullable DomainUsage visitConnectionAssignment(@NonNull ConnectionAssignment object) {
		DomainUsage valueUsage = visit(object.getValue());
		DomainUsage variableUsage = visit(object.getTargetVariable());
		return intersection(variableUsage, valueUsage);
	}

	@Override
	public @Nullable DomainUsage visitImperativeBottomPattern(@NonNull ImperativeBottomPattern object) {
		return visitBottomPattern(object);
	}

	@Override
	public @Nullable DomainUsage visitImperativeDomain(@NonNull ImperativeDomain object) {
		return visitCoreDomain(object);
	}

	@Override
	public @Nullable DomainUsage visitImperativeModel(@NonNull ImperativeModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @Nullable DomainUsage visitMapping(@NonNull Mapping object) {
		DomainUsage usage = getNoneUsage();
		setUsage(object, usage);
		visitRule(object);
		visit(object.getGuardPattern());
		visit(object.getBottomPattern());
		visit(object.getMappingStatement());
		return usage;
	}

	@Override
	public @Nullable DomainUsage visitMappingCall(@NonNull MappingCall object) {
		for (MappingCallBinding mappingCallBinding : object.getBinding()) {
			visit(mappingCallBinding);
		}
		return getNoneUsage();
	}

	@Override
	public @Nullable DomainUsage visitMappingCallBinding(@NonNull MappingCallBinding object) {
		DomainUsage valueUsage = visit(object.getValue());
		DomainUsage variableUsage = visit(object.getBoundVariable());
		return intersection(valueUsage, variableUsage);
	}

	@Override
	public @Nullable DomainUsage visitMappingLoop(@NonNull MappingLoop object) {
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
	public @Nullable DomainUsage visitMappingSequence(@NonNull MappingSequence object) {
		for (MappingStatement mappingStatement : object.getMappingStatements()) {
			visit(mappingStatement);
		}
		return getNoneUsage();
	}

	@Override
	public @Nullable DomainUsage visitMappingStatement(@NonNull MappingStatement object) {
		return visitOCLExpression(object);
	}
	
	@Override
	public @Nullable DomainUsage visitVariableExp(@NonNull VariableExp object) {
		StandardLibraryInternal standardLibrary = context.getStandardLibrary();
		Type transformationType = standardLibrary.getLibraryType("Transformation");
		if ((transformationType != null) && object.getType().conformsTo(standardLibrary, transformationType)) {
			return getNoneUsage();
		}
		return super.visitVariableExp(object);
	}

	@Override
	public @Nullable DomainUsage visitVariablePredicate(@NonNull VariablePredicate object) {
		return visitPredicate(object);
	}
}
