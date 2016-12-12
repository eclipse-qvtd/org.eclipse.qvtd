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
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
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
		safeVisit(asAddStatement.getOwnedExpression());
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitAppendParameter(@NonNull AppendParameter asParameter) {
		context.append("append ");
		context.appendName(asParameter);
		context.append(" ");
		Type type = asParameter.getType();
		if (type != null) {
			context.append(" : ");
			//			context.appendQualifiedType(type);
			context.appendTypedMultiplicity(asParameter);
		}
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitAppendParameterBinding(@NonNull AppendParameterBinding pAppendParameterBinding) {
		context.appendName(pAppendParameterBinding.getBoundVariable());
		context.append(" appendsTo ");
		context.appendName(pAppendParameterBinding.getValue());
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitBufferStatement(@NonNull BufferStatement pBuffer) {
		if (pBuffer.isIsStrict()) {
			context.append("strict ");
		}
		return visitVariableDeclaration(pBuffer);
	}
	@Override
	public Object visitCheckStatement(@NonNull CheckStatement pPredicate) {
		context.append("check ");
		safeVisit(pPredicate.getOwnedExpression());
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitConnectionVariable(@NonNull ConnectionVariable object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public Object visitDeclareStatement(@NonNull DeclareStatement asVariable) {
		if (asVariable.isIsCheck()) {
			context.append("check ");
		}
		context.append("var ");
		context.appendName(asVariable);
		Type type = asVariable.getType();
		if (type != null) {
			context.append(" : ");
			context.appendTypedMultiplicity(asVariable);
		}
		OCLExpression asInit = asVariable.getOwnedExpression();
		if (asInit != null) {
			context.append(" := ");
			safeVisit(asInit);
		}
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitGuardParameter(@NonNull GuardParameter asParameter) {
		context.append("guard:");
		context.appendName(asParameter.getReferredTypedModel());
		context.append(" ");
		context.appendName(asParameter);
		context.append(" ");
		Type type = asParameter.getType();
		if (type != null) {
			context.append(" : ");
			//			context.appendQualifiedType(type);
			context.appendTypedMultiplicity(asParameter);
		}
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitGuardParameterBinding(@NonNull GuardParameterBinding pGuardParameterBinding) {
		if (pGuardParameterBinding.isIsCheck()) {
			context.append("check ");
		}
		context.appendName(pGuardParameterBinding.getBoundVariable());
		context.append(" consumes ");
		safeVisit(pGuardParameterBinding.getValue());
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitImperativeModel(@NonNull ImperativeModel object) {
		return visitModel(object);
	}

	@Override
	public Object visitImperativeTransformation(@NonNull ImperativeTransformation object) {
		return visitTransformation(object);
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
	public Object visitLoopParameterBinding(@NonNull LoopParameterBinding pLoopParameterBinding) {
		if (pLoopParameterBinding.isIsCheck()) {
			context.append("check ");
		}
		context.appendName(pLoopParameterBinding.getBoundVariable());
		context.append(" iterates ");
		safeVisit(pLoopParameterBinding.getValue());
		context.append(";\n");
		return null;
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
		if (pMapping.isIsStrict()) {
			context.append("strict ");
		}
		context.append("map ");
		context.appendName(pMapping);
		context.append(" in ");
		context.appendName(pMapping.getTransformation());
		context.append(" {\n");
		context.push("", "");
		for (@NonNull MappingParameter pVariable : QVTimperativeUtil.getOwnedMappingParameters(pMapping)) {
			safeVisit(pVariable);
		}
		for (Statement pStatement : pMapping.getOwnedStatements()) {
			safeVisit(pStatement);
		}
		context.pop();
		return null;
	}

	@Override
	public Object visitMappingCall(@NonNull MappingCall pMappingCall) {
		context.append(pMappingCall.isIsInstall() ? "install " : pMappingCall.isIsInvoke() ? "invoke " : "call ");
		context.appendName(pMappingCall.getReferredMapping());
		context.append(" {\n");
		context.push("", "");
		for (@NonNull MappingParameterBinding mappingParameterBinding : QVTimperativeUtil.getOwnedMappingParameterBindings(pMappingCall)) {
			safeVisit(mappingParameterBinding);
		}
		context.append("}");
		context.pop();
		return null;
	}

	@Override
	public Object visitMappingLoop(@NonNull MappingLoop pMappingLoop) {
		context.append("for ");
		context.appendElement(pMappingLoop.getOwnedIterators().get(0));
		context.append(" in ");
		context.appendElement(pMappingLoop.getOwnedExpression());
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
	public Object visitMappingParameter(@NonNull MappingParameter object) {
		return visiting(object);
	}

	@Override
	public Object visitMappingParameterBinding(@NonNull MappingParameterBinding object) {
		return visiting(object);
	}

	@Override
	public Object visitMappingStatement(@NonNull MappingStatement object) {
		return visiting(object);
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
		OCLExpression initExpression = pNewStatement.getOwnedExpression();
		if (initExpression != null) {
			context.append(" = ");
			safeVisit(initExpression);
		}
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitObservableStatement(@NonNull ObservableStatement object) {
		return visiting(object);
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
		safeVisit(asSetStatement.getOwnedExpression());
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitSimpleParameter(@NonNull SimpleParameter asParameter) {
		context.append("in:");
		context.appendName(asParameter.getReferredTypedModel());
		context.append(" ");
		context.appendName(asParameter);
		context.append(" ");
		Type type = asParameter.getType();
		if (type != null) {
			context.append(" : ");
			//			context.appendQualifiedType(type);
			context.appendTypedMultiplicity(asParameter);
		}
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitSimpleParameterBinding(@NonNull SimpleParameterBinding pSimpleParameterBinding) {
		if (pSimpleParameterBinding.isIsCheck()) {
			context.append("check ");
		}
		context.appendName(pSimpleParameterBinding.getBoundVariable());
		context.append(" uses ");
		safeVisit(pSimpleParameterBinding.getValue());
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
