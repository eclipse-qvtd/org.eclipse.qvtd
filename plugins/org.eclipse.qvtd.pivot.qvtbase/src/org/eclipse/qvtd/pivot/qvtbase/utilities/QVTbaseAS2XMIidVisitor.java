/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtbase.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.util.AbstractQVTbaseAS2XMIidVisitor;

public class QVTbaseAS2XMIidVisitor extends AbstractQVTbaseAS2XMIidVisitor
{
	public static final @NonNull String DOMAIN_PREFIX = "qD."; //$NON-NLS-1$
	public static final @NonNull String PATTERN_PREFIX = "qP."; //$NON-NLS-1$
	public static final @NonNull String RULE_PREFIX = "qR."; //$NON-NLS-1$
	public static final @NonNull String TYPED_MODEL_PREFIX = "qT."; //$NON-NLS-1$
	public static final @NonNull String VARIABLE_PREFIX = "qV."; //$NON-NLS-1$

	public QVTbaseAS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
	}	

	@Override
	public @Nullable Boolean visitBaseModel(@NonNull BaseModel object) {
		return null;
	}

	@Override
	public @Nullable Boolean visitDomain(@NonNull Domain object) {
		String name = object.getName();
		if (name != null) {
			s.append(DOMAIN_PREFIX);
			appendParent(object);
			appendName(name);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public @Nullable Boolean visitPattern(@NonNull Pattern object) {
		return false;
	}

	@Override
	public @Nullable Boolean visitPredicate(@NonNull Predicate object) {
		return null;
	}

	@Override
	public @Nullable Boolean visitRule(@NonNull Rule object) {
		return false;
	}

	@Override
	public @Nullable Boolean visitTypedModel(@NonNull TypedModel object) {
		String name = object.getName();
		if (name != null) {
			s.append(TYPED_MODEL_PREFIX);
			appendParent(object);
			appendName(name);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public @Nullable Boolean visitImport(@NonNull Import object) {
		return null;
	}
}
