/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

public class QVTiAnalyzer extends CodeGenAnalyzer
{
	private final @NonNull Map<@NonNull Function, @NonNull CGFunction> cgFunctions = new HashMap<>();
	private final @NonNull Map<@NonNull Mapping, @NonNull CGMapping> cgMappings = new HashMap<>();
	private final @NonNull Map<@NonNull TypedModel, @NonNull CGTypedModel> cgTypedModels = new HashMap<>();
	private final @Nullable TypeId originalThisTypeId;
	private final @NonNull TypeId runtimeThisTypeId;

	public QVTiAnalyzer(@NonNull QVTiCodeGenerator codeGenerator) {
		super(codeGenerator);
		ImperativeTransformation iTransformation = codeGenerator.getTransformation();
		Type contextClass = QVTimperativeUtil.getRuntimeContextClass(iTransformation);
		if (contextClass != iTransformation) {
			originalThisTypeId = iTransformation.getTypeId();
			runtimeThisTypeId = contextClass.getTypeId();
		}
		else {
			originalThisTypeId = null;
			runtimeThisTypeId = iTransformation.getTypeId();
		}
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

	public @Nullable CGMapping basicGetCGMapping(@NonNull Mapping pMapping) {
		return cgMappings.get(pMapping);
	}

	@Override
	public @NonNull QVTiCodeGenerator getCodeGenerator() {
		return (QVTiCodeGenerator) super.getCodeGenerator();
	}

	public @Nullable CGFunction getFunction(@NonNull Function pFunction) {
		return cgFunctions.get(pFunction);
	}

	@Override
	public @NonNull CGTypeId getCGTypeId(@NonNull TypeId typeId) {
		if (typeId == originalThisTypeId) {
			return super.getCGTypeId(runtimeThisTypeId);
		}
		else {
			return super.getCGTypeId(typeId);
		}
	}

	public @Nullable CGTypedModel getTypedModel(@NonNull TypedModel pTypedModel) {
		return cgTypedModels.get(pTypedModel);
	}
}
