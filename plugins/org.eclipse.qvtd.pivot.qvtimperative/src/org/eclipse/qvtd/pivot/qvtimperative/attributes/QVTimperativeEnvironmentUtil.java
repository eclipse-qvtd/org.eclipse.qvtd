/*******************************************************************************
 * Copyright (c) 2012, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.attributes;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;

public class QVTimperativeEnvironmentUtil
{
	public static void addMiddleBottomVariables(@NonNull EnvironmentView environmentView, @Nullable Mapping mapping) {
		if (mapping != null) {
			addMiddleVariables(environmentView, mapping, true);
		}
	}

	public static void addMiddleGuardVariables(@NonNull EnvironmentView environmentView, @Nullable Mapping mapping) {
		if (mapping != null) {
			addMiddleVariables(environmentView, mapping, false);
		}
	}

	private static void addMiddleVariables(@NonNull EnvironmentView environmentView, @NonNull Mapping mapping, boolean bottomToo) {
		if (bottomToo) {
			for (Statement asStatement : mapping.getOwnedStatements()) {
				if (asStatement instanceof VariableStatement) {
					environmentView.addNamedElement(asStatement);
				}
			}
		}
		environmentView.addNamedElements(mapping.getOwnedGuardVariables());
		environmentView.addNamedElements(mapping.getInoutVariables());
	}

	public static void addSideBottomVariables(@NonNull EnvironmentView environmentView, @Nullable Mapping mapping, @Nullable TypedModel typedModel) {
		if (mapping != null) {
			addSideVariables(environmentView, mapping, typedModel, true);
		}
	}

	public static void addSideGuardVariables(@NonNull EnvironmentView environmentView, @Nullable Mapping mapping, @Nullable TypedModel typedModel) {
		if (mapping != null) {
			addSideVariables(environmentView, mapping, typedModel, false);
		}
	}

	private static void addSideVariables(@NonNull EnvironmentView environmentView, @NonNull Mapping mapping, @Nullable TypedModel typedModel, boolean bottomToo) {
		if (bottomToo) {
			for (Statement asStatement : mapping.getOwnedStatements()) {
				if (asStatement instanceof VariableStatement) {
					environmentView.addNamedElement(asStatement);
				}
			}
		}
		environmentView.addNamedElements(mapping.getInoutVariables());
	}
}
