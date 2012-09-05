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
package org.eclipse.qvtd.pivot.qvtcore.attributes;

import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;

public class QVTcoreEnvironmentUtil
{
	public static void addMiddleBottomVariables(EnvironmentView environmentView, Mapping mapping) {
		for (; mapping != null; mapping = mapping.getContext()) {
			addMiddleVariables(environmentView, mapping, true);
		}
	}

	public static void addMiddleGuardVariables(EnvironmentView environmentView, Mapping mapping) {
		if (mapping != null) {
			addMiddleVariables(environmentView, mapping, false);
			for (mapping = mapping.getContext(); mapping != null; mapping = mapping.getContext()) {
				addMiddleVariables(environmentView, mapping, true);
			}
		}
	}
	
	private static void addMiddleVariables(EnvironmentView environmentView, Mapping mapping, boolean bottomToo) {
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
		for (Mapping refinedMapping : mapping.getRefinement()) {
			addMiddleVariables(environmentView, refinedMapping, bottomToo);
		}
	}

	public static void addSideBottomVariables(EnvironmentView environmentView, Mapping mapping, TypedModel typedModel) {
		for (; mapping != null; mapping = mapping.getContext()) {
			QVTcoreEnvironmentUtil.addSideVariables(environmentView, mapping, typedModel, true);
		}
	}

	public static void addSideGuardVariables(EnvironmentView environmentView, Mapping mapping, TypedModel typedModel) {
		if (mapping != null) {
			addSideVariables(environmentView, mapping, typedModel, false);
			for (mapping = mapping.getContext(); mapping != null; mapping = mapping.getContext()) {
				addSideVariables(environmentView, mapping, typedModel, true);
			}
		}
	}

	private static void addSideVariables(EnvironmentView environmentView, Mapping mapping, TypedModel typedModel, boolean bottomToo) {
		for (Domain aDomain : mapping.getDomain()) {
			if (aDomain instanceof CoreDomain) {
				CoreDomain domain = (CoreDomain)aDomain;
				if (domain.getTypedModel() == typedModel) {
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
		for (Mapping refinedMapping : mapping.getRefinement()) {
			addSideVariables(environmentView, refinedMapping, typedModel, bottomToo);
		}
	}
}
