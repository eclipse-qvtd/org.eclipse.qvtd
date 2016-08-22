/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation based on MtcBroker
 ******************************************************************************/
package org.eclipse.qvtd.compiler;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChain.Key;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;

public abstract class AbstractCompilerStep implements CompilerStep
{
	protected final @NonNull CompilerChain compilerChain;
	protected final @NonNull QVTbaseEnvironmentFactory environmentFactory;
	protected final @NonNull String name;
	protected final @NonNull String defaultExtension;

	private /*@LazyNonNull*/ CompilerProblems compilerProblems = null;

	protected AbstractCompilerStep(@NonNull CompilerChain compilerChain, @NonNull String stepName) {
		this.compilerChain = compilerChain;
		this.environmentFactory = compilerChain.getEnvironmentFactory();
		this.name = stepName;
		this.defaultExtension = ClassUtil.nonNullState(AbstractCompilerChain.getDefaultExtension(stepName));
	}

	@Override
	public void addProblem(@NonNull CompilerProblem problem) {
		CompilerProblems compilerProblems2 = compilerProblems;
		if (compilerProblems2 == null) {
			compilerProblems = compilerProblems2 = new CompilerProblems();
		}
		compilerProblems2.addProblem(problem);
	}

	protected void compiled(@NonNull Object object) {
		compiled(name, object);
	}

	@Deprecated // should be using getName() regularly
	protected void compiled(@NonNull String stepKey, @NonNull Object object) {
		compilerChain.compiled(stepKey, object);
	}

	protected @NonNull Resource createResource() throws IOException {
		return compilerChain.createResource(getURI());
	}

	@Deprecated // should be using getURI() regularly
	protected @NonNull Resource createResource(@NonNull URI uri) throws IOException {
		return compilerChain.createResource(uri);
	}

	/*	public @NonNull CompilerProblems getCompilerProblems() {
		CompilerProblems compilerProblems2 = compilerProblems;
		if (compilerProblems2 == null) {
			compilerProblems = compilerProblems2 = new CompilerProblems();
		}
		return compilerProblems2;
	} */

	@Override
	public @NonNull String getDefaultExtension() {
		return defaultExtension;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	public <T> @Nullable T getOption(@NonNull Key<T> optionKey) {
		return compilerChain.getOption(name, optionKey);
	}

	protected @NonNull URI getURI() {
		return compilerChain.getURI(name, CompilerChain.URI_KEY);
	}

	protected @NonNull Resource saveResource(@NonNull Resource asResource) throws IOException {
		compilerChain.saveResource(asResource, name);
		compiled(asResource);
		return asResource;
	}

	@Deprecated // should be using getName() regularly
	protected @NonNull Resource saveResource(@NonNull Resource asResource, @NonNull String stepKey) throws IOException {
		compilerChain.saveResource(asResource, stepKey);
		compiled(stepKey, asResource);
		return asResource;
	}

	public void throwCompilerChainExceptionForErrors() throws CompilerChainException {
		if (compilerProblems != null) {
			compilerProblems.throwCompilerChainExceptionForErrors();
		}
	}
}
