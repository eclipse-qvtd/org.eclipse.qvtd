/*******************************************************************************
 * Copyright (c) 2012, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbasePrettyPrintVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.SpeculateStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;
import com.google.common.collect.Iterables;

public class QVTimperativePrettyPrintVisitor extends QVTbasePrettyPrintVisitor implements QVTimperativeVisitor<Object>
{
	public QVTimperativePrettyPrintVisitor(@NonNull PrettyPrinter context) {
		super(context);
	}

	protected void appendObservedProperties(@NonNull ObservableStatement asObservableStatement) {
		Iterable<@NonNull Property> observedProperties = QVTimperativeUtil.getObservedProperties(asObservableStatement);
		if (!Iterables.isEmpty(observedProperties)) {
			context.append("observe ");
			boolean isFirst = true;
			for (Property asProperty : observedProperties) {
				if (!isFirst) {
					context.append(", ");
				}
				context.appendParent(null, asProperty, "::");
				context.appendName(asProperty);
				isFirst = false;
			}
			context.append(" ");
		}
	}

	@Override
	public Object visitAddStatement(@NonNull AddStatement asAddStatement) {
		appendObservedProperties(asAddStatement);
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
		context.append("buffer");
		Integer firstPass = pBuffer.getFirstPass();
		if (firstPass != null) {
			context.append(":");
			context.append(firstPass);
			Integer lastPass = pBuffer.getLastPass();
			if (lastPass != null) {
				context.append("..");
				context.append(lastPass);
			}
		}
		context.append(" ");
		context.appendName(pBuffer);
		context.append(" : ");
		context.appendTypedMultiplicity(pBuffer);
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitCheckStatement(@NonNull CheckStatement asCheckStatement) {
		appendObservedProperties(asCheckStatement);
		context.append("check ");
		safeVisit(asCheckStatement.getOwnedExpression());
		context.append(";\n");
		return null;
	}
	@Override
	public Object visitConnectionVariable(@NonNull ConnectionVariable object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public Object visitDeclareStatement(@NonNull DeclareStatement asDeclareStatement) {
		appendObservedProperties(asDeclareStatement);
		if (asDeclareStatement.isIsCheck()) {
			context.append("check ");
		}
		context.append("var ");
		context.appendName(asDeclareStatement);
		Type type = asDeclareStatement.getType();
		if (type != null) {
			context.append(" : ");
			context.appendTypedMultiplicity(asDeclareStatement);
		}
		OCLExpression asInit = asDeclareStatement.getOwnedExpression();
		if (asInit != null) {
			context.append(" := ");
			safeVisit(asInit);
		}
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitEntryPoint(@NonNull EntryPoint pEntryPoint) {
		if (pEntryPoint.isIsStrict()) {
			context.append("strict ");
		}
		context.append("entry ");
		context.appendName(pEntryPoint);
		boolean isFirst = true;
		for (@NonNull TypedModel pTypedModel : QVTimperativeUtil.getInputTypedModels(pEntryPoint)) {
			if (isFirst) {
				context.append("input ");
			}
			else {
				context.append(", ");
			}
			safeVisit(pTypedModel);
		}
		isFirst = true;
		for (@NonNull TypedModel pTypedModel : QVTimperativeUtil.getOutputTypedModels(pEntryPoint)) {
			if (isFirst) {
				context.append("output ");
			}
			else {
				context.append(", ");
			}
			safeVisit(pTypedModel);
		}
		context.append(" in ");
		context.appendName(pEntryPoint.getTransformation());
		context.append(" {\n");
		context.push("", "");
		for (@NonNull MappingParameter pVariable : QVTimperativeUtil.getOwnedMappingParameters(pEntryPoint)) {
			safeVisit(pVariable);
		}
		for (Statement pStatement : pEntryPoint.getOwnedStatements()) {
			safeVisit(pStatement);
		}
		context.pop();
		return null;
	}

	@Override
	public Object visitGuardParameter(@NonNull GuardParameter asParameter) {
		context.append("guard:");
		context.appendName(asParameter.getReferredTypedModel());
		context.append(" ");
		context.appendName(asParameter);
		Type type = asParameter.getType();
		if (type != null) {
			context.append(" : ");
			//			context.appendQualifiedType(type);
			context.appendTypedMultiplicity(asParameter);
		}
		Property successProperty = asParameter.getSuccessProperty();
		if (successProperty != null) {
			context.append(" success ");
			context.appendName(successProperty);
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
		context.append("map");
		Integer firstPass = pMapping.getFirstPass();
		if (firstPass != null) {
			context.append(":");
			context.append(firstPass);
			Integer lastPass = pMapping.getLastPass();
			if (lastPass != null) {
				context.append("..");
				context.append(lastPass);
			}
		}
		context.append(" ");
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
	public Object visitMappingLoop(@NonNull MappingLoop asMappingLoop) {
		appendObservedProperties(asMappingLoop);
		context.append("for ");
		context.appendElement(asMappingLoop.getOwnedIterators().get(0));
		context.append(" in ");
		context.appendElement(asMappingLoop.getOwnedExpression());
		context.append(" {");
		context.push("", "");
		for (MappingStatement pMappingStatement : asMappingLoop.getOwnedMappingStatements()) {
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
	public Object visitNewStatement(@NonNull NewStatement asNewStatement) {
		appendObservedProperties(asNewStatement);
		if (asNewStatement.isIsContained()) {
			context.append("contained ");
		}
		context.append("new:");
		context.appendName(asNewStatement.getReferredTypedModel());
		context.append(" ");
		context.appendName(asNewStatement);
		Type type = asNewStatement.getType();
		if (type != null) {
			context.append(" : ");
			//			context.appendQualifiedType(type);
			context.appendTypedMultiplicity(asNewStatement);
		}
		if (asNewStatement.eIsSet(QVTimperativePackage.Literals.NEW_STATEMENT__OWNED_PARTS)) {
			context.append(" {");
			boolean isFirst = true;
			for (NewStatementPart part : asNewStatement.getOwnedParts()) {
				if (!isFirst) {
					context.append(", ");
				}
				safeVisit(part);
				isFirst = false;
			}
			context.append("}\n");
		}
		else {
			OCLExpression initExpression = asNewStatement.getOwnedExpression();
			if (initExpression != null) {
				context.append(" = ");
				safeVisit(initExpression);
			}
			context.append(";\n");
		}
		return null;
	}

	@Override
	public Object visitNewStatementPart(@NonNull NewStatementPart asNewStatementPart) {
		context.appendElement(asNewStatementPart.getReferredProperty());
		context.append(" = ");
		safeVisit(asNewStatementPart.getOwnedExpression());
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
		appendObservedProperties(asSetStatement);
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
	public Object visitSpeculateStatement(@NonNull SpeculateStatement object) {
		context.append("speculate ");
		boolean isFirst = true;
		for (@NonNull OCLExpression expression : QVTimperativeUtil.getOwnedExpressions(object)) {
			if (!isFirst) {
				context.append(", ");
			}
			safeVisit(expression);
			isFirst = false;
		}
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
