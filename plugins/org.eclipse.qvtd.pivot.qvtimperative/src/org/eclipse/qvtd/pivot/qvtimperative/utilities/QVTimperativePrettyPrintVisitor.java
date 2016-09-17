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
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbasePrettyPrintVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardVariable;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.InConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.OutConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

public class QVTimperativePrettyPrintVisitor extends QVTbasePrettyPrintVisitor implements QVTimperativeVisitor<Object>
{
	public QVTimperativePrettyPrintVisitor(@NonNull PrettyPrinter context) {
		super(context);
	}
	@Override
	public Object visitAddStatement(@NonNull AddStatement asAddStatement) {
		context.append("add ");
		context.appendName(asAddStatement.getTargetVariable());
		context.append(" += ");
		safeVisit(asAddStatement.getOwnedInit());
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitCheckStatement(@NonNull CheckStatement pPredicate) {
		context.append("check ");
		safeVisit(pPredicate.getOwnedCondition());
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitConnectionVariable(@NonNull ConnectionVariable object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public Object visitDeclareStatement(@NonNull DeclareStatement asVariable) {
		if (asVariable.isIsChecked()) {
			context.append("check ");
		}
		context.append("var ");
		context.appendName(asVariable);
		Type type = asVariable.getType();
		if (type != null) {
			context.append(" : ");
			context.appendTypedMultiplicity(asVariable);
		}
		OCLExpression asInit = asVariable.getOwnedInit();
		if (asInit != null) {
			context.append(" := ");
			safeVisit(asInit);
		}
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitGuardVariable(@NonNull GuardVariable asVariable) {
		context.append("in ");
		context.appendName(asVariable);
		Type type = asVariable.getType();
		if (type != null) {
			context.append(" : ");
			//			context.appendQualifiedType(type);
			context.appendTypedMultiplicity(asVariable);
		}
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitImperativeDomain(@NonNull ImperativeDomain object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitImperativeModel(@NonNull ImperativeModel object) {
		return visitModel(object);
	}

	@Override
	public Object visitImperativeTypedModel(@NonNull ImperativeTypedModel object) {
		if (object.isIsChecked()) {
			context.append("check ");
		}
		if (object.isIsEnforced()) {
			context.append("enforce ");
		}
		return visitTypedModel(object);
	}

	@Override
	public Object visitInConnectionVariable(@NonNull InConnectionVariable object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public Object visitLoopVariable(@NonNull LoopVariable asVariable) {
		context.appendName(asVariable);
		Type type = asVariable.getType();
		if (type != null) {
			context.append(" : ");
			context.appendTypedMultiplicity(asVariable);
		}
		return null;
	}

	@Override
	public Object visitMapping(@NonNull Mapping pMapping) {
		context.append("map ");
		context.appendName(pMapping);
		context.append(" in ");
		context.appendName(pMapping.getTransformation());
		context.append(" {\n");
		context.push("", "");
		for (GuardVariable pVariable : pMapping.getOwnedGuardVariables()) {
			context.append("in:");
			context.appendName(pVariable.getReferredTypedModel());
			context.append(" ");
			safeVisit(pVariable);
			context.append(";\n");
		}
		for (ConnectionVariable pVariable : pMapping.getInoutVariables()) {
			context.append("inout ");
			safeVisit(pVariable);
			context.append(";\n");
		}
		for (Statement pStatement : pMapping.getOwnedStatements()) {
			safeVisit(pStatement);
		}
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
		for (MappingStatement pMappingStatement : pMappingLoop.getOwnedMappingStatements()) {
			safeVisit(pMappingStatement);
		}
		context.append("}");
		context.pop();
		return null;
	}

	@Override
	public Object visitMappingStatement(@NonNull MappingStatement object) {
		return visitStatement(object);
	}

	@Override
	public Object visitNewStatement(@NonNull NewStatement pNewStatement) {
		context.append("new:");
		context.appendName(pNewStatement.getReferredTypedModel());
		context.append(" ");
		context.appendName(pNewStatement);
		Type type = pNewStatement.getType();
		if (type != null) {
			context.append(" : ");
			//			context.appendQualifiedType(type);
			context.appendTypedMultiplicity(pNewStatement);
		}
		OCLExpression initExpression = pNewStatement.getOwnedInit();
		if (initExpression != null) {
			context.append(" = ");
			safeVisit(initExpression);
		}
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitOutConnectionVariable(@NonNull OutConnectionVariable object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public Object visitPredicate(@NonNull Predicate pPredicate) {
		safeVisit(pPredicate.getConditionExpression());
		return null;
	}

	@Override
	public Object visitSetStatement(@NonNull SetStatement asSetStatement) {
		if (asSetStatement.isIsNotify()) {
			context.append("notify ");
		}
		context.append("set ");
		context.appendName(asSetStatement.getTargetVariable());
		context.append(".");
		context.appendName(QVTimperativeUtil.getTargetProperty(asSetStatement));
		context.append(" := ");
		safeVisit(asSetStatement.getOwnedInit());
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitStatement(@NonNull Statement object) {
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
	public Object visitVariableStatement(@NonNull VariableStatement object) {
		return visiting(object);
	}
}
