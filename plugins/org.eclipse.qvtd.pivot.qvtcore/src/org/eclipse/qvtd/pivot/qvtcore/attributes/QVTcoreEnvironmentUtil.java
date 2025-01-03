/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore.attributes;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;

public class QVTcoreEnvironmentUtil
{
	public static void addMiddleBottomVariables(@NonNull EnvironmentView environmentView, @Nullable Mapping mapping) {
		for (; mapping != null; mapping = mapping.getContext()) {
			addMiddleVariables(environmentView, mapping, true);
		}
	}

	public static void addMiddleGuardVariables(@NonNull EnvironmentView environmentView, @Nullable Mapping mapping) {
		if (mapping != null) {
			addMiddleVariables(environmentView, mapping, false);
			for (mapping = mapping.getContext(); mapping != null; mapping = mapping.getContext()) {
				addMiddleVariables(environmentView, mapping, true);
			}
		}
	}

	private static void addMiddleVariables(@NonNull EnvironmentView environmentView, @NonNull Mapping mapping, boolean bottomToo) {
		if (bottomToo) {
			BottomPattern bottomPattern = mapping.getBottomPattern();
			if (bottomPattern != null) {
				environmentView.addNamedElements(bottomPattern.getRealizedVariable());
				environmentView.addNamedElements(bottomPattern.getOwnedVariables());
			}
		}
		GuardPattern guardPattern = mapping.getGuardPattern();
		if (guardPattern != null) {
			environmentView.addNamedElements(guardPattern.getOwnedVariables());
		}
		for (Domain aDomain : mapping.getDomain()) {
			if (aDomain instanceof CoreDomain) {
				CoreDomain domain = (CoreDomain)aDomain;
				if (bottomToo) {
					BottomPattern bottomPattern = domain.getBottomPattern();
					if (bottomPattern != null) {
						environmentView.addNamedElements(bottomPattern.getRealizedVariable());
						environmentView.addNamedElements(bottomPattern.getOwnedVariables());
					}
				}
				guardPattern = domain.getGuardPattern();
				if (guardPattern != null) {
					environmentView.addNamedElements(guardPattern.getOwnedVariables());
				}
			}
		}
		for (@SuppressWarnings("null")@NonNull Mapping refinedMapping : mapping.getSpecification()) {
			addMiddleVariables(environmentView, refinedMapping, bottomToo);
		}
	}

	public static void addSideBottomVariables(@NonNull EnvironmentView environmentView, @Nullable Mapping mapping, @Nullable TypedModel typedModel) {
		for (; mapping != null; mapping = mapping.getContext()) {
			addSideVariables(environmentView, mapping, typedModel, true);
		}
	}

	public static void addSideGuardVariables(@NonNull EnvironmentView environmentView, @Nullable Mapping mapping, @Nullable TypedModel typedModel) {
		if (mapping != null) {
			addSideVariables(environmentView, mapping, typedModel, false);
			for (mapping = mapping.getContext(); mapping != null; mapping = mapping.getContext()) {
				addSideVariables(environmentView, mapping, typedModel, true);
			}
		}
	}

	private static void addSideVariables(@NonNull EnvironmentView environmentView, @NonNull Mapping mapping, @Nullable TypedModel typedModel, boolean bottomToo) {
		for (Domain aDomain : mapping.getDomain()) {
			if (aDomain instanceof CoreDomain) {
				CoreDomain domain = (CoreDomain)aDomain;
				if ((typedModel == null) || (domain.getTypedModel() == typedModel)) {
					if (bottomToo) {
						BottomPattern bottomPattern = domain.getBottomPattern();
						if (bottomPattern != null) {
							environmentView.addNamedElements(bottomPattern.getRealizedVariable());
							environmentView.addNamedElements(bottomPattern.getOwnedVariables());
						}
					}
					GuardPattern guardPattern = domain.getGuardPattern();
					if (guardPattern != null) {
						environmentView.addNamedElements(guardPattern.getOwnedVariables());
					}
					break;
				}
			}
		}
		for (@SuppressWarnings("null")@NonNull Mapping refinedMapping : mapping.getSpecification()) {
			addSideVariables(environmentView, refinedMapping, typedModel, bottomToo);
		}
	}
}
