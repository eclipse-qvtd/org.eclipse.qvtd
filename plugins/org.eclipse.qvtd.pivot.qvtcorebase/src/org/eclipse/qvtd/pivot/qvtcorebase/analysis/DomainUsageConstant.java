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
	
	private static final @NonNull DomainUsageConstant[] constantUsages = new DomainUsageConstant[2 * ERROR_BIT];

	private static final @NonNull DomainUsageConstant[] usages = new DomainUsageConstant[2 * ERROR_BIT];
	static {
		for (int i = 0; i < usages.length; i++) {
			constantUsages[i] = new DomainUsageConstant(i);
		}
		usages[ANY_MASK] = constantUsages[ANY_MASK];
		usages[MIDDLE_BIT] = constantUsages[MIDDLE_BIT];
		usages[PRIMITIVE_BIT] = constantUsages[PRIMITIVE_BIT];
		usages[SOURCE_BIT] = constantUsages[SOURCE_BIT];
		usages[TARGET_BIT] = constantUsages[TARGET_BIT];
		usages[MIDDLE_BIT | PRIMITIVE_BIT] = constantUsages[MIDDLE_BIT];
		usages[SOURCE_BIT | PRIMITIVE_BIT] = constantUsages[SOURCE_BIT];
		usages[TARGET_BIT | PRIMITIVE_BIT] = constantUsages[TARGET_BIT];
		usages[ERROR_BIT] = constantUsages[ERROR_BIT];
		for (int i = 1; i < ERROR_BIT; i++) {
			usages[ERROR_BIT + i] = constantUsages[ERROR_BIT];
		}
	}
	
	public static final @SuppressWarnings("null")@NonNull DomainUsageConstant ANY = constantUsages[ANY_MASK];
	public static final @SuppressWarnings("null")@NonNull DomainUsageConstant ERROR = constantUsages[ERROR_BIT];
	public static final @SuppressWarnings("null")@NonNull DomainUsageConstant MIDDLE = constantUsages[MIDDLE_BIT];
	public static final @SuppressWarnings("null")@NonNull DomainUsageConstant PRIMITIVE = constantUsages[PRIMITIVE_BIT];
	public static final @SuppressWarnings("null")@NonNull DomainUsageConstant SOURCE = constantUsages[SOURCE_BIT];
	public static final @SuppressWarnings("null")@NonNull DomainUsageConstant TARGET = constantUsages[TARGET_BIT];

	public static final @SuppressWarnings("null")@NonNull DomainUsageConstant NONE = constantUsages[0];

	/**
	 * Return the DomainUsageConstant that represents mask.
	 */
	@SuppressWarnings("null")
	public static @NonNull DomainUsageConstant getConstantUsage(int mask) {
		return constantUsages[mask];
	}

	/**
	 * Return the DomainUsageConstant that represents mask. Returns null if mask cannot be represented as a valid constant.
	 */
	public static @Nullable DomainUsageConstant getUsage(int mask) {
		return usages[mask];
	}
	
	private DomainUsageConstant(int mask) {
		super(mask);
	}

	@SuppressWarnings("null")
	public @NonNull DomainUsageConstant union(@NonNull DomainUsageConstant usage) {
		return constantUsages[mask | usage.mask];
	}
}
