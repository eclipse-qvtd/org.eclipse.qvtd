/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.umlx.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.umlx.UMLXElement;
import org.eclipse.qvtd.umlx.util.AbstractExtendingUMLXVisitor;

public class UMLXToStringVisitor extends AbstractExtendingUMLXVisitor<@Nullable Object, @NonNull StringBuilder>
{
	public static @NonNull String toString(@NonNull UMLXElement umlxElement) {
		return new UMLXToStringVisitor().toString();
	}

	protected UMLXToStringVisitor() {
		super(new StringBuilder());
	}

	private void append(@NonNull String string) {
		context.append(string);
	}

	@Override
	public @NonNull String toString() {
		return context.toString();
	}

	@Override
	public @Nullable Object visiting(@NonNull UMLXElement umlxElement) {
		append("Unsupported " + getClass().getSimpleName() + " for " + umlxElement.eClass().getName());
		return null;
	}
}
