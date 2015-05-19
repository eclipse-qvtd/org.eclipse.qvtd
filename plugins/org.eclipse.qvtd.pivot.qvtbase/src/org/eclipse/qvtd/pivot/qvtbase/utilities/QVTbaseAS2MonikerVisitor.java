/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.util.AbstractQVTbaseAS2MonikerVisitor;

public class QVTbaseAS2MonikerVisitor extends AbstractQVTbaseAS2MonikerVisitor
{

	public static final @NonNull String MONIKER_PATTERN = "pattern";
	public static final @NonNull String MONIKER_PREDICATE = "pred";

	public QVTbaseAS2MonikerVisitor(@NonNull AS2Moniker context) {
		super(context);
	}	

	@Override
	public @Nullable Object visitDomain(@NonNull Domain asDomain) {
		context.appendParent(asDomain, MONIKER_SCOPE_SEPARATOR);
		context.appendName(asDomain);
		return true;
	}

	@Override
	public @Nullable Object visitPattern(@NonNull Pattern object) {
		context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
		context.append(MONIKER_PATTERN);
		return true;
	}	

	@Override
	public @Nullable Object visitPredicate(@NonNull Predicate object) {
		context.appendParent(object, MONIKER_SCOPE_SEPARATOR);
		context.append(MONIKER_PREDICATE);
		return true;
	}

	@Override
	public @Nullable Object visitTypedModel(@NonNull TypedModel asTypedModel) {
		context.appendParent(asTypedModel, MONIKER_SCOPE_SEPARATOR);
		context.appendName(asTypedModel);
		return true;
	}
}
