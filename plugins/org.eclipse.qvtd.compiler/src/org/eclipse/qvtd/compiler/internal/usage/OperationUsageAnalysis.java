/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.usage;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An OperationUsageAnalysis is used for a nested context such as an operation which is analyzed without
 * regard to its invocation parameters. The invoking context is responsible for 'specializing' the generic
 * domain analysis to suit the invocations.
 */
public class OperationUsageAnalysis extends AbstractBaseDomainUsageAnalysis
{
	protected final @NonNull RootDomainUsageAnalysis rootAnalysis;

	protected OperationUsageAnalysis(@NonNull RootDomainUsageAnalysis rootAnalysis) {
		super(rootAnalysis.getEnvironmentFactory(), rootAnalysis.getProblemHandler());
		this.rootAnalysis = rootAnalysis;
	}

	@Override
	protected @NonNull RootDomainUsageAnalysis getRootAnalysis() {
		return rootAnalysis;
	}
}