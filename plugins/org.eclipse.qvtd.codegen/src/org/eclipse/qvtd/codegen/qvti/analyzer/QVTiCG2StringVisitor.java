/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyAssignment;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;
import org.eclipse.qvtd.codegen.qvticgmodel.util.AbstractQVTiCG2StringVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart;

public class QVTiCG2StringVisitor extends AbstractQVTiCG2StringVisitor
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
		safeVisit(cgConnectionAssignment.getOwnedInitValue());
		return null;
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
		appendName(cgMappingCall.getReferredMapping());
		append("(");
		for (CGValuedElement argument : cgMappingCall.getOwnedMappingCallBindings()) {
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
		safeVisit(cgMappingCallBinding.getOwnedValue());
		return null;
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
	public @Nullable String visitCGPropertyAssignment(@NonNull CGPropertyAssignment cgPropertyAssignment) {
		safeVisit(cgPropertyAssignment.getOwnedSlotValue());
		append(".");
		appendName(cgPropertyAssignment.getReferredProperty());
		append(" := ");
		safeVisit(cgPropertyAssignment.getOwnedInitValue());
		return null;
	}

	@Override
	public @Nullable String visitCGRealizedVariablePart(@NonNull CGRealizedVariablePart cgRealizedVariablePart) {
		appendName(((NewStatementPart)cgRealizedVariablePart.getAst()).getReferredProperty());
		append(" <- ");
		safeVisit(cgRealizedVariablePart.getInit());
		return null;
	}
}
