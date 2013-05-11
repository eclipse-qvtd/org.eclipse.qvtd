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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;

public class QVTiAnalyzer extends CodeGenAnalyzer
{
	private final @NonNull Map<Function, CGFunction> cgFunctions = new HashMap<Function, CGFunction>();
	private final @NonNull Map<Mapping, CGMapping> cgMappings = new HashMap<Mapping, CGMapping>();
	private final @NonNull Map<TypedModel, CGTypedModel> cgTypedModels = new HashMap<TypedModel, CGTypedModel>();

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
