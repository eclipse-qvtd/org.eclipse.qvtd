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
import org.eclipse.jdt.annotation.Nullable;

/**
 * A DomainUsageConstant identifies a specific domain result from the DomainUsageAnalysis of an OCL AST node.
 */
public class DomainUsageConstant extends AbstractDomainUsage
{
	/*package*/ static final @NonNull DomainUsageConstant ANY = new DomainUsageConstant(PRIMITIVE_BIT | SOURCE_BIT | MIDDLE_BIT | TARGET_BIT);
	private static final @NonNull DomainUsageConstant ERROR = new DomainUsageConstant(0);
	/*package*/ static final @NonNull DomainUsageConstant MIDDLE = new DomainUsageConstant(MIDDLE_BIT);
	/*package*/ static final @NonNull DomainUsageConstant PRIMITIVE = new DomainUsageConstant(PRIMITIVE_BIT);
	/*package*/ static final @NonNull DomainUsageConstant SOURCE = new DomainUsageConstant(SOURCE_BIT);
	/*package*/ static final @NonNull DomainUsageConstant TARGET = new DomainUsageConstant(TARGET_BIT);
	
	private static final @NonNull DomainUsageConstant[] usages = new DomainUsageConstant[ANY.mask+1];
	{
		usages[ANY.mask] = ANY;
		usages[ERROR.mask] = ERROR;
		usages[MIDDLE.mask] = MIDDLE;
		usages[MIDDLE.mask | PRIMITIVE_BIT] = MIDDLE;
		usages[PRIMITIVE.mask] = PRIMITIVE;
		usages[SOURCE.mask] = SOURCE;
		usages[SOURCE.mask | PRIMITIVE_BIT] = SOURCE;
		usages[TARGET.mask] = TARGET;
		usages[TARGET.mask | PRIMITIVE_BIT] = TARGET;
	}

	/**
	 * Return the DomainUsageConstant that represents mask. Returns null if maks cannot be represented as a valid constant.
	 */
	public static @Nullable DomainUsageConstant getUsage(int mask) {
		return usages[mask];
	}
	
	private DomainUsageConstant(int mask) {
		super(mask);
	}
}
