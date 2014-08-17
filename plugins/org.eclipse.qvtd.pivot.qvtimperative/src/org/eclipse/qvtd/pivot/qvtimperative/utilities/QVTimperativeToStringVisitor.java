/*******************************************************************************
 * Copyright (c) 2012 E.D. Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseToStringVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyCallExp;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * Converts an OCL expression to a string for debugging. This is not intended to
 * be used by client applications as an AST-to-text transformation.
 */
public class QVTimperativeToStringVisitor extends QVTcoreBaseToStringVisitor implements QVTimperativeVisitor<String>
{
	public QVTimperativeToStringVisitor(@NonNull StringBuilder s) {
		super(s);
	}

	public @Nullable String visitImperativeModel(@NonNull ImperativeModel object) {
		return visitRoot(object);
	}

	public @Nullable String visitMapping(@NonNull Mapping object) {
		appendQualifiedName(object);
		return null;
	}

	public @Nullable String visitMappingCall(@NonNull MappingCall object) {
		append("mappingCall ");
		appendQualifiedName(object.getReferredMapping());
		return null;
	}

	public @Nullable String visitMappingCallBinding(@NonNull MappingCallBinding object) {
		appendName(object.getBoundVariable());
		append(" := ");
		safeVisit(object.getValue());
		return null;
	}

	public @Nullable String visitMappingLoop(@NonNull MappingLoop object) {
		append("mappingLoop ");
		appendQualifiedName(object.getIterator().get(0));
		return null;
	}

	public @Nullable String visitMappingSequence(@NonNull MappingSequence object) {
		return null;
	}

	public @Nullable String visitMappingStatement(@NonNull MappingStatement object) {
		return null;
	}

	public @Nullable String visitMiddlePropertyAssignment(@NonNull MiddlePropertyAssignment object) {
		return visitPropertyAssignment(object);
	}

	public @Nullable String visitMiddlePropertyCallExp(@NonNull MiddlePropertyCallExp object) {
		return visitOppositePropertyCallExp(object);
	}

	public @Nullable String visitVariablePredicate(@NonNull VariablePredicate variablePredicate) {
		appendName(variablePredicate.getTargetVariable());
		append(" := ");
		safeVisit(variablePredicate.getConditionExpression());
		return null;
	}
}
