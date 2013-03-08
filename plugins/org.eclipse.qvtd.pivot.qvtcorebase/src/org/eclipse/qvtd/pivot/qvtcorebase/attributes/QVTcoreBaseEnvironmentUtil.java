/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtcorebase.attributes;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.AbstractMapping;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;

public class QVTcoreBaseEnvironmentUtil
{
	public static void addMiddleBottomVariables(@NonNull EnvironmentView environmentView, @Nullable AbstractMapping mapping) {
		for (; mapping != null; mapping = mapping.getContext()) {
			addMiddleVariables(environmentView, mapping, true);
		}
	}

	public static void addMiddleGuardVariables(@NonNull EnvironmentView environmentView, @Nullable AbstractMapping mapping) {
		if (mapping != null) {
			addMiddleVariables(environmentView, mapping, false);
			for (mapping = mapping.getContext(); mapping != null; mapping = mapping.getContext()) {
				addMiddleVariables(environmentView, mapping, true);
			}
		}
	}
	
	private static void addMiddleVariables(@NonNull EnvironmentView environmentView, @NonNull AbstractMapping mapping, boolean bottomToo) {
		if (bottomToo) {
			BottomPattern bottomPattern = mapping.getBottomPattern();
			if (bottomPattern != null) {
				environmentView.addNamedElements(bottomPattern.getRealizedVariable());
				environmentView.addNamedElements(bottomPattern.getVariable());
			}
		}
		GuardPattern guardPattern = mapping.getGuardPattern();
		if (guardPattern != null) {
			environmentView.addNamedElements(guardPattern.getVariable());
		}
		for (Domain aDomain : mapping.getDomain()) {
			if (aDomain instanceof CoreDomain) {
				CoreDomain domain = (CoreDomain)aDomain;
				if (bottomToo) {
					BottomPattern bottomPattern = domain.getBottomPattern();
					if (bottomPattern != null) {
						environmentView.addNamedElements(bottomPattern.getRealizedVariable());
						environmentView.addNamedElements(bottomPattern.getVariable());
					}
				}
				guardPattern = domain.getGuardPattern();
				if (guardPattern != null) {
					environmentView.addNamedElements(guardPattern.getVariable());
				}
			}
		}
		for (@SuppressWarnings("null")@NonNull AbstractMapping refinedMapping : mapping.getRefinement()) {
			addMiddleVariables(environmentView, refinedMapping, bottomToo);
		}
	}

	public static void addSideBottomVariables(@NonNull EnvironmentView environmentView, @Nullable AbstractMapping mapping, @Nullable TypedModel typedModel) {
		for (; mapping != null; mapping = mapping.getContext()) {
			QVTcoreBaseEnvironmentUtil.addSideVariables(environmentView, mapping, typedModel, true);
		}
	}

	public static void addSideGuardVariables(@NonNull EnvironmentView environmentView, @Nullable AbstractMapping mapping, @Nullable TypedModel typedModel) {
		if (mapping != null) {
			addSideVariables(environmentView, mapping, typedModel, false);
			for (mapping = mapping.getContext(); mapping != null; mapping = mapping.getContext()) {
				addSideVariables(environmentView, mapping, typedModel, true);
			}
		}
	}

	private static void addSideVariables(@NonNull EnvironmentView environmentView, @NonNull AbstractMapping mapping, @Nullable TypedModel typedModel, boolean bottomToo) {
		for (Domain aDomain : mapping.getDomain()) {
			if (aDomain instanceof CoreDomain) {
				CoreDomain domain = (CoreDomain)aDomain;
				if ((typedModel == null) || (domain.getTypedModel() == typedModel)) {
					if (bottomToo) {
						BottomPattern bottomPattern = domain.getBottomPattern();
						if (bottomPattern != null) {
							environmentView.addNamedElements(bottomPattern.getRealizedVariable());
							environmentView.addNamedElements(bottomPattern.getVariable());
						}
					}
					GuardPattern guardPattern = domain.getGuardPattern();
					if (guardPattern != null) {
						environmentView.addNamedElements(guardPattern.getVariable());
					}
					break;
				}
			}
		}
		for (@SuppressWarnings("null")@NonNull AbstractMapping refinedMapping : mapping.getRefinement()) {
			addSideVariables(environmentView, refinedMapping, typedModel, bottomToo);
		}
	}
}
