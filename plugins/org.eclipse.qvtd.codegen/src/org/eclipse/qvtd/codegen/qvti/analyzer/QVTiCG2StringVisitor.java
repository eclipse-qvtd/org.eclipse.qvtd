/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.analyzer;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CG2StringVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment;
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
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;

public class QVTiCG2StringVisitor extends CG2StringVisitor implements QVTiCGModelVisitor<String>
{
	private static final class MyFactory extends AbstractFactory
	{
		private static final class MyFactory2 extends AbstractFactory
		{
			private MyFactory2() {
				CG2StringVisitor.addFactory(this);
			}

			@Override
			public @NonNull CG2StringVisitor createToStringVisitor() {
				return new QVTiCG2StringVisitor();
			}

			@Override
			public @NonNull EPackage getEPackage() {
				CGModelPackage eInstance = CGModelPackage.eINSTANCE;
				assert eInstance != null;
				return eInstance;
			}
		}

		private MyFactory() {
			new MyFactory2();
			CG2StringVisitor.addFactory(this);
		}

		@Override
		public @NonNull CG2StringVisitor createToStringVisitor() {
			return new QVTiCG2StringVisitor();
		}

		@Override
		public @NonNull EPackage getEPackage() {
			QVTiCGModelPackage eInstance = QVTiCGModelPackage.eINSTANCE;
			assert eInstance != null;
			return eInstance;
		}
	}

	public static QVTiCG2StringVisitor.@NonNull Factory FACTORY = new MyFactory();

	public QVTiCG2StringVisitor() {}

	@Override
	public @Nullable String visitCGConnectionAssignment(@NonNull CGConnectionAssignment cgConnectionAssignment) {
		appendName(cgConnectionAssignment.getConnectionVariable());
		append(" := ");
		safeVisit(cgConnectionAssignment.getInitValue());
		return null;
	}

	@Override
	public @Nullable String visitCGConnectionVariable(@NonNull CGConnectionVariable object) {
		return visitCGGuardVariable(object);
	}

	@Override
	public @Nullable String visitCGEcoreContainerAssignment(@NonNull CGEcoreContainerAssignment object) {
		return visitCGPropertyAssignment(object);
	}

	@Override
	public @Nullable String visitCGEcorePropertyAssignment(@NonNull CGEcorePropertyAssignment object) {
		return visitCGPropertyAssignment(object);
	}

	@Override
	public @Nullable String visitCGEcoreRealizedVariable(@NonNull CGEcoreRealizedVariable object) {
		return visitCGRealizedVariable(object);
	}

	@Override
	public @Nullable String visitCGFunction(@NonNull CGFunction object) {
		return visitCGOperation(object);
	}

	@Override
	public @Nullable String visitCGFunctionCallExp(@NonNull CGFunctionCallExp object) {
		return visitCGOperationCallExp(object);
	}

	@Override
	public @Nullable String visitCGFunctionParameter(@NonNull CGFunctionParameter object) {
		return visitCGParameter(object);
	}

	@Override
	public @Nullable String visitCGGuardVariable(@NonNull CGGuardVariable object) {
		return visitCGParameter(object);
	}

	@Override
	public @Nullable String visitCGMapping(@NonNull CGMapping cgMapping) {
		appendQualifiedName(cgMapping.getOwningTransformation(), ".", cgMapping);
		append("(");
		boolean isFirst = true;
		for (CGGuardVariable cgFreeVariable : cgMapping.getOwnedGuardVariables()) {
			if (!isFirst) {
				append(",");
			}
			appendElementType(cgFreeVariable);
			isFirst = false;
		}
		append(")");
		return null;
	}

	@Override
	public @Nullable String visitCGMappingCall(@NonNull CGMappingCall cgMappingCall) {
		appendName(((MappingCall)cgMappingCall.getAst()).getReferredMapping());
		append("(");
		for (CGValuedElement argument : cgMappingCall.getMappingCallBindings()) {
			safeVisit(argument);
			append("; ");
		}
		append(")");
		return null;
	}

	@Override
	public @Nullable String visitCGMappingCallBinding(@NonNull CGMappingCallBinding cgMappingCallBinding) {
		appendName(cgMappingCallBinding);
		append(" := ");
		safeVisit(cgMappingCallBinding.getValue());
		return null;
	}

	@Override
	public @Nullable String visitCGMappingExp(@NonNull CGMappingExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable String visitCGMappingLoop(@NonNull CGMappingLoop cgMappingLoop) {
		CGValuedElement source = cgMappingLoop.getSource();
		safeVisit(source);
		append("->loop(");
		String prefix = "";//$NON-NLS-1$
		for (CGValuedElement argument : cgMappingLoop.getIterators()) {
			append(prefix);
			safeVisit(argument);
			prefix = ", ";//$NON-NLS-1$
		}
		append(" | ");
		append(" ... ");
		//		safeVisit(cgMappingLoop.getBody());
		append(")");
		return null;
	}

	@Override
	public @Nullable String visitCGMiddlePropertyAssignment(@NonNull CGMiddlePropertyAssignment object) {
		return visitCGPropertyAssignment(object);
	}

	@Override
	public @Nullable String visitCGMiddlePropertyCallExp(@NonNull CGMiddlePropertyCallExp object) {
		return visitCGOppositePropertyCallExp(object);
	}

	@Override
	public @Nullable String visitCGPropertyAssignment(@NonNull CGPropertyAssignment cgPropertyAssignment) {
		safeVisit(cgPropertyAssignment.getSlotValue());
		append(".");
		appendName(cgPropertyAssignment.getReferredProperty());
		append(" := ");
		safeVisit(cgPropertyAssignment.getInitValue());
		return null;
	}

	@Override
	public @Nullable String visitCGRealizedVariable(@NonNull CGRealizedVariable object) {
		return visitCGVariable(object);
	}

	@Override
	public @Nullable String visitCGSequence(@NonNull CGSequence object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable String visitCGTransformation(@NonNull CGTransformation object) {
		return visitCGClass(object);
	}

	@Override
	public @Nullable String visitCGTypedModel(@NonNull CGTypedModel object) {
		return visitCGNamedElement(object);
	}

	@Override
	public @Nullable String visitCGVariableExp(@NonNull CGVariableExp v) {
		appendName(v.getReferredVariable());
		return null;
	}
}
