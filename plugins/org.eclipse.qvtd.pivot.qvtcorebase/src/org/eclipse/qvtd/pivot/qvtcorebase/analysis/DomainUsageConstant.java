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
	private static final int ANY_MASK = PRIMITIVE_BIT | SOURCE_BIT | MIDDLE_BIT | TARGET_BIT;
	
	private static final @NonNull DomainUsageConstant[] usages = new DomainUsageConstant[2 * ERROR_BIT];
	static {
		usages[ANY_MASK] = new DomainUsageConstant(ANY_MASK);
		usages[MIDDLE_BIT] = new DomainUsageConstant(MIDDLE_BIT);
		usages[PRIMITIVE_BIT] = new DomainUsageConstant(PRIMITIVE_BIT);
		usages[SOURCE_BIT] = new DomainUsageConstant(SOURCE_BIT);
		usages[TARGET_BIT] = new DomainUsageConstant(TARGET_BIT);
		usages[MIDDLE_BIT | PRIMITIVE_BIT] = usages[MIDDLE_BIT];
		usages[SOURCE_BIT | PRIMITIVE_BIT] = usages[SOURCE_BIT];
		usages[TARGET_BIT | PRIMITIVE_BIT] = usages[TARGET_BIT];
		usages[ERROR_BIT] = new DomainUsageConstant(ERROR_BIT);
		for (int i = 1; i < ERROR_BIT; i++) {
			usages[ERROR_BIT + i] = usages[ERROR_BIT];
		}
	}
	
	public static final @SuppressWarnings("null")@NonNull DomainUsageConstant ANY = usages[ANY_MASK];
	public static final @SuppressWarnings("null")@NonNull DomainUsageConstant ERROR = usages[ERROR_BIT];
	public static final @SuppressWarnings("null")@NonNull DomainUsageConstant MIDDLE = usages[MIDDLE_BIT];
	public static final @SuppressWarnings("null")@NonNull DomainUsageConstant PRIMITIVE = usages[PRIMITIVE_BIT];
	public static final @SuppressWarnings("null")@NonNull DomainUsageConstant SOURCE = usages[SOURCE_BIT];
	public static final @SuppressWarnings("null")@NonNull DomainUsageConstant TARGET = usages[TARGET_BIT];

	public static final @NonNull DomainUsageConstant NONE = new DomainUsageConstant(0);

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
