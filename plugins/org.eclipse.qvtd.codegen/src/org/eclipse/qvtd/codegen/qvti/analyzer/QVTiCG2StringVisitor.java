/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvti.analyzer;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CG2StringVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.CGVariablePredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;

public class QVTiCG2StringVisitor extends CG2StringVisitor implements QVTiCGModelVisitor<String>
{	
	private static final class MyFactory extends AbstractFactory
	{
		private MyFactory() {
			CG2StringVisitor.addFactory(this);
		}

		public @NonNull CG2StringVisitor createToStringVisitor() {
			return new QVTiCG2StringVisitor();
		}

		public @NonNull EPackage getEPackage() {
			QVTiCGModelPackage eInstance = QVTiCGModelPackage.eINSTANCE;
			assert eInstance != null;
			return eInstance;
		}
	}

	public static @NonNull QVTiCG2StringVisitor.Factory FACTORY = new MyFactory();

	protected QVTiCG2StringVisitor() {}

	@Nullable
	public String visitCGEcorePropertyAssignment(@NonNull CGEcorePropertyAssignment object) {
		return visitCGPropertyAssignment(object);
	}

	public @Nullable String visitCGEcoreRealizedVariable(@NonNull CGEcoreRealizedVariable object) {
		return visitCGRealizedVariable(object);
	}

	public @Nullable String visitCGFunction(@NonNull CGFunction object) {
		return visitCGOperation(object);
	}

	public @Nullable String visitCGFunctionCallExp(@NonNull CGFunctionCallExp object) {
		return visitCGOperationCallExp(object);
	}

	public @Nullable String visitCGFunctionParameter(@NonNull CGFunctionParameter object) {
		return visitCGParameter(object);
	}

	public @Nullable String visitCGGuardVariable(@NonNull CGGuardVariable object) {
		return visitCGParameter(object);
	}

	public @Nullable String visitCGMapping(@NonNull CGMapping cgMapping) {
		appendQualifiedName(cgMapping.getTransformation(), ".", cgMapping);
		append("(");
		boolean isFirst = true;
		for (CGGuardVariable cgFreeVariable : cgMapping.getFreeVariables()) {
			if (!isFirst) {
				append(",");
			}
			appendElementType(cgFreeVariable);
			isFirst = false;
		}
		append(")");
		return null;
	}

	public @Nullable String visitCGMappingCall(@NonNull CGMappingCall cgMappingCall) {
		appendName(((MappingCall)cgMappingCall.getPivot()).getReferredMapping());
		append("(");
		for (CGValuedElement argument : cgMappingCall.getMappingCallBindings()) {
			safeVisit(argument);
			append("; ");
		}
		append(")");
		return null;
	}

	public @Nullable String visitCGMappingCallBinding(@NonNull CGMappingCallBinding cgMappingCallBinding) {
		appendName(cgMappingCallBinding);
		append(cgMappingCallBinding.isLoop() ? " <= " : " := ");
		safeVisit(cgMappingCallBinding.getValueOrValues());
		return null;
	}

	public @Nullable String visitCGMappingExp(@NonNull CGMappingExp object) {
		return visitCGValuedElement(object);
	}

	public @Nullable String visitCGMiddlePropertyAssignment(@NonNull CGMiddlePropertyAssignment object) {
		return visitCGPropertyAssignment(object);
	}

	public @Nullable String visitCGMiddlePropertyCallExp(@NonNull CGMiddlePropertyCallExp object) {
		return visitCGPropertyCallExp(object);
	}

	public @Nullable String visitCGPredicate(@NonNull CGPredicate cgPredicate) {
		safeVisit(cgPredicate.getConditionExpression());
		return null;
	}

	public @Nullable String visitCGPropertyAssignment(@NonNull CGPropertyAssignment cgPropertyAssignment) {
		safeVisit(cgPropertyAssignment.getSlotValue());
		append(".");
		appendName(cgPropertyAssignment.getReferredProperty());
		append(" := ");
		safeVisit(cgPropertyAssignment.getValue());
		return null;
	}

	public @Nullable String visitCGRealizedVariable(@NonNull CGRealizedVariable object) {
		return visitCGVariable(object);
	}

	public @Nullable String visitCGTransformation(@NonNull CGTransformation object) {
		return visitCGClass(object);
	}

	public @Nullable String visitCGTypedModel(@NonNull CGTypedModel object) {
		return visitCGNamedElement(object);
	}

	@Override
	public @Nullable String visitCGVariableExp(@NonNull CGVariableExp v) {
		appendName(v.getReferredVariable());
		return null;
	}

	public @Nullable String visitCGVariablePredicate(@NonNull CGVariablePredicate cgVariablePredicate) {
		appendName(cgVariablePredicate.getPredicateVariable());
		append(" := ");
		safeVisit(cgVariablePredicate.getConditionExpression());
		return null;
	}
}
