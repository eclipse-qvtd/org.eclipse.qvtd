/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;

public abstract class AbstractCompilerStep implements CompilerStep
{
	protected final @NonNull CompilerChain compilerChain;
	protected final @NonNull QVTbaseEnvironmentFactory environmentFactory;
	protected final @NonNull String stepName;
	protected final @NonNull String defaultFileExtension;

	private /*@LazyNonNull*/ CompilerProblems compilerProblems = null;

	protected AbstractCompilerStep(@NonNull CompilerChain compilerChain, @NonNull String stepName) {
		this.compilerChain = compilerChain;
		this.environmentFactory = compilerChain.getEnvironmentFactory();
		this.stepName = stepName;
		this.defaultFileExtension = ClassUtil.nonNullState(AbstractCompilerChain.getDefaultFileExtension(stepName));
	}

	@Override
	public void addProblem(@NonNull CompilerProblem problem) {
		CompilerProblems compilerProblems2 = compilerProblems;
		if (compilerProblems2 == null) {
			compilerProblems = compilerProblems2 = new CompilerProblems();
		}
		compilerProblems2.addProblem(problem);
	}

	public <T> @Nullable T basicGetOption(CompilerOptions.@NonNull Key<T> optionKey) {
		return compilerChain.basicGetOption(stepName, optionKey);
	}

	protected void compiled(@NonNull Object object) {
		compiled(stepName, object);
	}

	@Deprecated // should be using getName() regularly
	protected void compiled(@NonNull String stepName, @NonNull Object object) {
		compilerChain.compiled(stepName, object);
	}

	protected @NonNull Resource createResource(@NonNull String contentType) throws IOException {
		return compilerChain.createResource(getURI(), contentType);
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
		return defaultFileExtension;
	}

	@Override
	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	@Override
	public @NonNull String getName() {
		return stepName;
	}

	protected @NonNull URI getURI() {
		return compilerChain.getURI(stepName, CompilerChain.URI_KEY);
	}

	protected @NonNull Resource saveResource(@NonNull Resource asResource) throws IOException {
		compilerChain.saveResource(asResource, stepName);
		compiled(asResource);
		return asResource;
	}

	@Override
	public void throwCompilerChainExceptionForErrors() throws CompilerChainException {
		if (compilerProblems != null) {
			compilerProblems.throwCompilerChainExceptionForErrors();
		}
	}
}
