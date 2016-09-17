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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;

public class QVTiAnalyzer extends CodeGenAnalyzer
{
	private final @NonNull Map<@NonNull Function, @NonNull CGFunction> cgFunctions = new HashMap<>();
	private final @NonNull Map<@NonNull Mapping, @NonNull CGMapping> cgMappings = new HashMap<>();
	private final @NonNull Map<@NonNull TypedModel, @NonNull CGTypedModel> cgTypedModels = new HashMap<>();

	public QVTiAnalyzer(@NonNull QVTiCodeGenerator codeGenerator) {
		super(codeGenerator);
	}

	public void addFunction(@NonNull Function pFunction, @NonNull CGFunction cgFunction) {
		cgFunctions.put(pFunction, cgFunction);
	}

	public void addMapping(@NonNull Mapping pMapping, @NonNull CGMapping cgMapping) {
		cgMappings.put(pMapping, cgMapping);
	}

	public void addTypedModel(@NonNull TypedModel pTypedModel, @NonNull CGTypedModel cgTypedModel) {
		cgTypedModels.put(pTypedModel, cgTypedModel);
	}

	public @NonNull CGVariableExp createCGVariableExp(@NonNull CGVariable cgVariable) {
		CGVariableExp cgVariableExp = CGModelFactory.eINSTANCE.createCGVariableExp();
		cgVariableExp.setTypeId(cgVariable.getTypeId());
		cgVariableExp.setAst(cgVariable.getAst());
		cgVariableExp.setReferredVariable(cgVariable);
		cgVariableExp.setRequired(cgVariable.isRequired());
		return cgVariableExp;
	}

	@Override
	public @NonNull QVTiCodeGenerator getCodeGenerator() {
		return (QVTiCodeGenerator) super.getCodeGenerator();
	}

	public @Nullable CGFunction getFunction(@NonNull Function pFunction) {
		return cgFunctions.get(pFunction);
	}

	public @Nullable CGMapping getMapping(@NonNull Mapping pMapping) {
		return cgMappings.get(pMapping);
	}

	public @Nullable CGTypedModel getTypedModel(@NonNull TypedModel pTypedModel) {
		return cgTypedModels.get(pTypedModel);
	}
}
