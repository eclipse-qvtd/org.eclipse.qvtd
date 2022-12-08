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
package org.eclipse.qvtd.codegen.qvti.naming;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.naming.NameManagerHelper;
import org.eclipse.ocl.examples.codegen.naming.NameResolution;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.util.AbstractQVTiCGNameHelperVisitor;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;

public class QVTiCGNameHelperVisitor extends AbstractQVTiCGNameHelperVisitor
{
	public QVTiCGNameHelperVisitor(@NonNull NameManagerHelper context) {
		super(context);
	}

	@Override
	public @NonNull String visitCGConnectionAssignment(@NonNull CGConnectionAssignment object) {
		return "CONNECTION_" + context.getNameableHint(object.getConnectionVariable());		// Never used
	}

	@Override
	public @NonNull String visitCGFunction(@NonNull CGFunction cgFunction) {
		return "FUN_" + context.getNameableHint(QVTiCGUtil.getAST(cgFunction));
	}

	@Override
	public @NonNull String visitCGMapping(@NonNull CGMapping cgMapping) {
		return "MAP_" + context.getNameableHint(QVTiCGUtil.getAST(cgMapping));		// XXX not yet used since CGMapping is not a CGValuedElement
	}

	@Override
	public @NonNull String visitCGMappingCall(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMappingCall object) {
		return context.getNameableHint(QVTiCGUtil.getReferredMapping(object));
	}

	@Override
	public @NonNull String visitCGMappingCallBinding(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMappingCallBinding object) {
		return context.getNameableHint(QVTiCGUtil.getAST(object).getBoundVariable());
	}

	@Override
	public @NonNull String visitCGMappingLoop(@NonNull CGMappingLoop object) {
		return "loop";
	}

	@Override
	public @NonNull String visitCGSpeculateExp(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGSpeculateExp object) {
		return "SPEC_"; //NameResolution.NOT_NEEDED; // "XXX-SPEC-"; // Never used
		//		return context.getNameableHint(QVTiCGUtil.getAST(object).getBoundVariable());
	}

	@Override
	public @NonNull String visitCGSpeculatePart(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGSpeculatePart object) {
		return NameResolution.NOT_NEEDED; // "XXX-SPEC-" + object.getEStructuralFeature().getName(); // Never used
	}

	@Override
	public @NonNull String visitCGTypedModel(@NonNull CGTypedModel cgTypedModel) {
		return "MODEL_" + context.getNameableHint(QVTiCGUtil.getAST(cgTypedModel));		// XXX not yet used since CGMapping is not a CGValuedElement
	}
}
