/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.genmodel
 *
 * Do not edit it.
 */
package	org.eclipse.qvtd.pivot.qvtbase.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.utilities.AS2XMIid;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.Unit;
import org.eclipse.qvtd.pivot.qvtbase.util.AbstractQVTbaseAS2XMIidVisitor;

public class QVTbaseAS2XMIidVisitor extends AbstractQVTbaseAS2XMIidVisitor
{
	public QVTbaseAS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
	}	

	@Override
	public @Nullable Boolean visitBaseModel(@NonNull BaseModel object) {
		return null;
	}

	@Override
	public @Nullable Boolean visitDomain(@NonNull Domain object) {
		return false;
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
		return false;
	}

	@Override
	public @Nullable Boolean visitUnit(@NonNull Unit object) {
		return null;
	}
}
