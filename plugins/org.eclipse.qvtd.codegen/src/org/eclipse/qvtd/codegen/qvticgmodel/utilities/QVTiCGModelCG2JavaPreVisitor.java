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
package org.eclipse.qvtd.codegen.qvticgmodel.utilities;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElementId;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.util.AbstractQVTiCGModelCG2JavaPreVisitor;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointsAnalysis;

public class QVTiCGModelCG2JavaPreVisitor extends AbstractQVTiCGModelCG2JavaPreVisitor
{
	public QVTiCGModelCG2JavaPreVisitor(@NonNull JavaCodeGenerator codeGenerator) {
		super(codeGenerator);
	}

	@Override
	public @NonNull QVTiCodeGenerator getCodeGenerator() {
		return (@NonNull QVTiCodeGenerator)context;
	}

	@Override
	public Object visitCGFunction(@NonNull CGFunction cgFunction) {
		super.visitCGFunction(cgFunction);
		wrapLetVariables(cgFunction);
		return null;
	}

	@Override
	public @Nullable Object visitCGMapping(@NonNull CGMapping cgMapping) {
		super.visitCGMapping(cgMapping);
		wrapLetVariables(cgMapping);
		return null;
	}

	@Override
	public @Nullable Object visitCGMappingLoop(@NonNull CGMappingLoop cgMappingLoop) {
		super.visitCGMappingLoop(cgMappingLoop);
		wrapLetVariables(cgMappingLoop);
		return null;
	}

	@Override
	public Object visitCGTransformation(@NonNull CGTransformation cgTransformation) {
		ImperativeTransformation transformation = QVTiCGUtil.getAST(cgTransformation);
		EntryPointsAnalysis entryPointsAnalysis = getCodeGenerator().getEntryPointsAnalysis(transformation);
		Map<@NonNull Property, @NonNull Integer> opposites = entryPointsAnalysis.getCaches();
		for (@NonNull Property property : opposites.keySet()) {
			CGElementId cgPropertyId = analyzer.getCGElementId(property.getPropertyId());
			cgPropertyId.accept(this);
		}
		return super.visitCGTransformation(cgTransformation);
	}
}
