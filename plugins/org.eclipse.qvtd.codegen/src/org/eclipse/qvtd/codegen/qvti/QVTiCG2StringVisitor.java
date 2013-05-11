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
package org.eclipse.qvtd.codegen.qvti;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CG2StringVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;

public class QVTiCG2StringVisitor extends CG2StringVisitor implements QVTiCGModelVisitor<String>
{	
	private static final class MyFactory implements CG2StringVisitor.Factory
	{
		private MyFactory() {
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

	public static @NonNull QVTiCG2StringVisitor.Factory FACTORY = new MyFactory();

	protected QVTiCG2StringVisitor() {}

	@Override
	@Nullable
	public String visitCGEcorePropertyAssignment(@NonNull CGEcorePropertyAssignment object) {
		return visitCGPropertyAssignment(object);
	}

	@Override
	@Nullable
	public String visitCGEcoreRealizedVariable(@NonNull CGEcoreRealizedVariable object) {
		return visitCGRealizedVariable(object);
	}

	@Override
	@Nullable
	public String visitCGFunction(@NonNull CGFunction object) {
		return visitCGOperation(object);
	}

	@Override
	@Nullable
	public String visitCGFunctionCallExp(@NonNull CGFunctionCallExp object) {
		return visitCGOperationCallExp(object);
	}

	@Override
	@Nullable
	public String visitCGFunctionParameter(@NonNull CGFunctionParameter object) {
		return visitCGParameter(object);
	}

	@Override
	@Nullable
	public String visitCGGuardVariable(@NonNull CGGuardVariable object) {
		return visitCGParameter(object);
	}

	@Override
	@Nullable
	public String visitCGMapping(@NonNull CGMapping cgMapping) {
		appendQualifiedName(cgMapping.getTransformation(), ".", cgMapping);
		append("(");
		boolean isFirst = true;
		for (CGGuardVariable cgGuardVariable : cgMapping.getGuardVariables()) {
			if (!isFirst) {
				append(",");
			}
			appendElementType(cgGuardVariable);
			isFirst = false;
		}
		append(")");
		return null;
	}

	@Override
	@Nullable
	public String visitCGMappingCall(@NonNull CGMappingCall object) {
		return visitCGValuedElement(object);
	}

	@Override
	@Nullable
	public String visitCGMappingCallBinding(@NonNull CGMappingCallBinding object) {
		return visitCGValuedElement(object);
	}

	@Override
	@Nullable
	public String visitCGPredicate(@NonNull CGPredicate object) {
		return visitCGValuedElement(object);
	}

	@Override
	@Nullable
	public String visitCGPropertyAssignment(@NonNull CGPropertyAssignment object) {
		return visitCGValuedElement(object);
	}

	@Override
	@Nullable
	public String visitCGRealizedVariable(@NonNull CGRealizedVariable object) {
		return visitCGVariable(object);
	}

	@Override
	@Nullable
	public String visitCGTransformation(@NonNull CGTransformation object) {
		return visitCGClass(object);
	}

	@Override
	@Nullable
	public String visitCGTypedModel(@NonNull CGTypedModel object) {
		return visitCGNamedElement(object);
	}
}
