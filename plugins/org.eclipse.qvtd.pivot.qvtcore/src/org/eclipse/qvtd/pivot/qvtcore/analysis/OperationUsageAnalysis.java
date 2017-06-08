/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore.analysis;

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
		super(rootAnalysis.getEnvironmentFactory());
		this.rootAnalysis = rootAnalysis;
	}

	@Override
	protected @NonNull RootDomainUsageAnalysis getRootAnalysis() {
		return rootAnalysis;
	}
}