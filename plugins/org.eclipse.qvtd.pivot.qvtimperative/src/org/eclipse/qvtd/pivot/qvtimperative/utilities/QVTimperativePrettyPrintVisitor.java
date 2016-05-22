/*******************************************************************************
 * Copyright (c) 2012, 2016 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBasePrettyPrintVisitor;
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

public class QVTimperativePrettyPrintVisitor extends QVTcoreBasePrettyPrintVisitor implements QVTimperativeVisitor<Object>
{	
	public QVTimperativePrettyPrintVisitor(@NonNull PrettyPrinter context) {
		super(context);
	}

	@Override
	public Object visitConnectionAssignment(@NonNull ConnectionAssignment asConnectionAssignment) {
		context.appendName(asConnectionAssignment.getTargetVariable());
		context.append(" += ");
		safeVisit(asConnectionAssignment.getValue());
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitConnectionStatement(@NonNull ConnectionStatement asConnectionStatement) {
		context.appendName(asConnectionStatement.getTargetVariable());
		context.append(" += ");
		safeVisit(asConnectionStatement.getValue());
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitConnectionVariable(@NonNull ConnectionVariable object) {
		return visitVariable(object);
	}

	@Override
	public Object visitImperativeBottomPattern(@NonNull ImperativeBottomPattern object) {
		return visitBottomPattern(object);
	}

	@Override
	public @Nullable Object visitImperativeDomain(@NonNull ImperativeDomain object) {
		return visitCoreDomain(object);
	}

	@Override
	public Object visitImperativeModel(@NonNull ImperativeModel object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitMapping(@NonNull Mapping pMapping) {
		context.append("map ");
		context.appendName(pMapping);
		context.append(" in ");
		context.appendName(pMapping.getTransformation());
		context.append(" {");
		context.push("", "");
		for (Domain pDomain : pMapping.getDomain()) {
			if (pDomain instanceof CoreDomain) {
				context.appendName(pDomain);
				doArea((CoreDomain)pDomain);
			}
		}
		context.append("where");
		doArea(pMapping);
		safeVisit(pMapping.getMappingStatement());
		context.pop();
		return null;
	}

	@Override
	public Object visitMappingCall(@NonNull MappingCall pMappingCall) {
		if (pMappingCall.isIsInfinite()) {
			context.append("infinite ");
		}
		context.append("call ");
		context.appendName(pMappingCall.getReferredMapping());
		context.append(" {\n");
		context.push("", "");
		for (MappingCallBinding mappingCallBinding : pMappingCall.getBinding()) {
			safeVisit(mappingCallBinding);
		}
		context.append("}");
		context.pop();
		return null;
	}

	@Override
	public Object visitMappingCallBinding(@NonNull MappingCallBinding pMappingCallBinding) {
		context.appendName(pMappingCallBinding.getBoundVariable());
		context.append(pMappingCallBinding.isIsPolled() ? " ?= " : " := ");
		safeVisit(pMappingCallBinding.getValue());
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitMappingLoop(@NonNull MappingLoop pMappingLoop) {
		context.append("for ");
		context.appendElement(pMappingLoop.getOwnedIterators().get(0));
		context.append(" in ");
		context.appendElement(pMappingLoop.getOwnedSource());
		context.append(" {");
		context.push("", "");
		safeVisit(pMappingLoop.getOwnedBody());
		context.append("}");
		context.pop();
		return null;
	}

	@Override
	public Object visitMappingSequence(@NonNull MappingSequence pMappingSequence) {
		for (MappingStatement pMappingStatement : pMappingSequence.getMappingStatements()) {
			safeVisit(pMappingStatement);
		}
		return null;
	}

	@Override
	public Object visitMappingStatement(@NonNull MappingStatement object) {
		return visiting(object);
	}

	@Override
	public Object visitVariable(@NonNull Variable pVariable) {
		if (pVariable.eContainer() instanceof MappingLoop) {
			context.appendName(pVariable);
			context.append(" : ");
			context.appendElement(pVariable.getType());
		}
		else {
			super.visitVariable(pVariable);
			context.append(";\n");
		}
		return null;
	}

	@Override
	public @Nullable Object visitVariablePredicate(@NonNull VariablePredicate object) {
		// TODO Auto-generated method stub
		return null;
	}
}
