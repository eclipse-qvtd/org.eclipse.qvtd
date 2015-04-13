/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcorebase.analysis;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A DomainUsageConstant identifies a specific domain result from the DomainUsageAnalysis of an OCL AST node.
 */
public class DomainUsageConstant extends AbstractDomainUsage
{
	
	DomainUsageConstant(@NonNull RootDomainUsageAnalysis rootAnalysis, long mask) {
		super(rootAnalysis, mask);
	}

	@Override
	public String toString() {
		return "Constant " + rootAnalysis.toString(bitMask);
	}

	public @NonNull DomainUsageConstant union(@NonNull DomainUsageConstant usage) {
		return rootAnalysis.getConstantUsage(bitMask | usage.bitMask);
	}
}
