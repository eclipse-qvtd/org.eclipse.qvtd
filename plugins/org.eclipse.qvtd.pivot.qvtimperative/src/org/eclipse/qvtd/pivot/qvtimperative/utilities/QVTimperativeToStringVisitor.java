/*******************************************************************************
 * Copyright (c) 2012, 2016 E.D. Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseToStringVisitor;
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
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * Converts an OCL expression to a string for debugging. This is not intended to
 * be used by client applications as an AST-to-text transformation.
 */
public class QVTimperativeToStringVisitor extends QVTbaseToStringVisitor implements QVTimperativeVisitor<String>
{
	protected static class QVTimperativeToStringFactory implements QVTbaseToStringVisitor.Factory
	{
		protected QVTimperativeToStringFactory() {
			ToStringVisitor.addFactory(this);
			QVTbaseToStringVisitor.FACTORY.getClass();
		}

		@Override
		public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
			return new QVTimperativeToStringVisitor(s);
		}

		@Override
		public @NonNull EPackage getEPackage() {
			QVTimperativePackage eInstance = QVTimperativePackage.eINSTANCE;
			assert eInstance != null;
			return eInstance;
		}
	}

	public static ToStringVisitor.@NonNull Factory FACTORY = new QVTimperativeToStringFactory();

	public QVTimperativeToStringVisitor(@NonNull StringBuilder s) {
		super(s);
	}

	@Override
	public @Nullable String visitAddStatement(@NonNull AddStatement asAddStatement) {
		append("add ");
		appendName(asAddStatement.getTargetVariable());
		append(" += ");
		safeVisit(asAddStatement.getOwnedExpression());
		return null;
	}

	@Override
	public @Nullable String visitAppendParameter(@NonNull AppendParameter asVariable) {
		append("append ");
		appendName(asVariable);
		Type type = asVariable.getType();
		if (type != null) {
			append(" : ");
			appendElementType(asVariable);
		}
		return null;
	}

	@Override
	public @Nullable String visitAppendParameterBinding(@NonNull AppendParameterBinding object) {
		appendName(object.getBoundVariable());
		append(" appendsTo ");
		appendName(object.getValue());
		return null;
	}

	@Override
	public @Nullable String visitBufferStatement(@NonNull BufferStatement asVariable) {
		if (asVariable.isIsStrict()) {
			context.append("«strict»");
		}
		append("buffer ");
		appendName(asVariable);
		Type type = asVariable.getType();
		if (type != null) {
			append(" : ");
			appendElementType(asVariable);
		}
		return null;
	}

	@Override
	public @Nullable String visitCheckStatement(@NonNull CheckStatement object) {
		append("check ");
		safeVisit(object.getOwnedExpression());
		return null;
	}

	@Override
	public @Nullable String visitConnectionVariable(@NonNull ConnectionVariable asVariable) {
		//		append("in ");
		appendName(asVariable);
		Type type = asVariable.getType();
		if (type != null) {
			append(" : ");
			appendElementType(asVariable);
		}
		return null;
	}

	@Override
	public @Nullable String visitDeclareStatement(@NonNull DeclareStatement asVariable) {
		if (asVariable.isIsCheck()) {
			append("check ");
		}
		append("var ");
		appendName(asVariable);
		Type type = asVariable.getType();
		if (type != null) {
			append(" : ");
			appendElementType(asVariable);
		}
		OCLExpression asInit = asVariable.getOwnedExpression();
		if (asInit != null) {
			append(" := ");
			safeVisit(asInit);
		}
		return null;
	}

	@Override
	public @Nullable String visitGuardParameter(@NonNull GuardParameter asVariable) {
		append("guard ");
		appendName(asVariable);
		Type type = asVariable.getType();
		if (type != null) {
			append(" : ");
			appendElementType(asVariable);
		}
		return null;
	}

	@Override
	public @Nullable String visitGuardParameterBinding(@NonNull GuardParameterBinding object) {
		if (object.isIsCheck()) {
			append("check ");
		}
		appendName(object.getBoundVariable());
		append(" consumes ");
		safeVisit(object.getValue());
		return null;
	}

	@Override
	public @Nullable String visitImperativeModel(@NonNull ImperativeModel object) {
		return visitModel(object);
	}

	@Override
	public @Nullable String visitImperativeTransformation(@NonNull ImperativeTransformation object) {
		return visitTransformation(object);
	}

	@Override
	public @Nullable String visitImperativeTypedModel(@NonNull ImperativeTypedModel object) {
		if (object.isIsChecked()) {
			append("check ");
		}
		if (object.isIsEnforced()) {
			append("enforce ");
		}
		return visitTypedModel(object);
	}

	@Override
	public @Nullable String visitLoopParameterBinding(@NonNull LoopParameterBinding object) {
		if (object.isIsCheck()) {
			append("check ");
		}
		appendName(object.getBoundVariable());
		append(" iterates ");
		safeVisit(object.getValue());
		return null;
	}

	@Override
	public @Nullable String visitLoopVariable(@NonNull LoopVariable asVariable) {
		appendName(asVariable);
		Type type = asVariable.getType();
		if (type != null) {
			append(" : ");
			appendElementType(asVariable);
		}
		return null;
	}

	@Override
	public @Nullable String visitMapping(@NonNull Mapping asMapping) {
		if (asMapping.isIsStrict()) {
			context.append("«strict»");
		}
		appendQualifiedName(asMapping);
		return null;
	}

	@Override
	public @Nullable String visitMappingCall(@NonNull MappingCall object) {
		if (object.isIsInstall()) {
			append("«install»");
		}
		appendQualifiedName(object.getReferredMapping());
		append(" {");
		boolean isFirst = true;
		for (@NonNull MappingParameterBinding binding : QVTimperativeUtil.getOwnedMappingParameterBindings(object)) {
			if (!isFirst) {
				append(", ");
			}
			safeVisit(binding);
			isFirst = false;
		}
		append("}");
		return null;
	}

	@Override
	public @Nullable String visitMappingLoop(@NonNull MappingLoop object) {
		boolean isFirst = true;
		for (LoopVariable iterator : object.getOwnedIterators()) {
			if (!isFirst) {
				append(", ");
			}
			appendName(iterator);
			isFirst = false;
		}
		append(" := ");
		safeVisit(object.getOwnedExpression());
		return null;
	}

	@Override
	public @Nullable String visitMappingParameter(@NonNull MappingParameter object) {
		return visiting(object);
	}

	@Override
	public @Nullable String visitMappingParameterBinding(@NonNull MappingParameterBinding object) {
		return visiting(object);
	}

	@Override
	public @Nullable String visitMappingStatement(@NonNull MappingStatement object) {
		return visiting(object);
	}

	@Override
	public String visitNewStatement(@NonNull NewStatement newStatement) {
		if (newStatement.isIsContained()) {
			context.append("contained ");
		}
		append("new:");
		appendName(newStatement.getReferredTypedModel());
		append(" ");
		appendName(newStatement);
		Type type = newStatement.getType();
		if (type != null) {
			append(" : ");
			appendElementType(newStatement);
		}
		OCLExpression initExpression = newStatement.getOwnedExpression();
		if (initExpression != null) {
			append(" = ");
			safeVisit(initExpression);
		}
		return null;
	}

	@Override
	public @Nullable String visitObservableStatement(@NonNull ObservableStatement object) {
		return null;
	}

	@Override
	public String visitSetStatement(@NonNull SetStatement asSetStatement) {
		if (asSetStatement.isIsNotify()) {
			append("notify ");
		}
		append("set ");
		appendName(asSetStatement.getTargetVariable());
		append(".");
		if (asSetStatement.isIsOpposite()) {
			append("~");
		}
		appendName(asSetStatement.getTargetProperty());
		append(" := ");
		safeVisit(asSetStatement.getOwnedExpression());
		return null;
	}

	@Override
	public @Nullable String visitSimpleParameter(@NonNull SimpleParameter asVariable) {
		append("in ");
		appendName(asVariable);
		Type type = asVariable.getType();
		if (type != null) {
			append(" : ");
			appendElementType(asVariable);
		}
		return null;
	}

	@Override
	public @Nullable String visitSimpleParameterBinding(@NonNull SimpleParameterBinding object) {
		if (object.isIsCheck()) {
			append("check ");
		}
		appendName(object.getBoundVariable());
		append(" uses ");
		safeVisit(object.getValue());
		return null;
	}

	@Override
	public @Nullable String visitStatement(@NonNull Statement object) {
		return null;
	}

	@Override
	public @Nullable String visitVariableStatement(@NonNull VariableStatement object) {
		return null;
	}
}
