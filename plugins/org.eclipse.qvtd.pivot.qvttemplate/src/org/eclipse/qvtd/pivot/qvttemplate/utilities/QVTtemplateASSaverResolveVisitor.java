/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvttemplate.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.util.AbstractQVTtemplateASSaverResolveVisitor;

public class QVTtemplateASSaverResolveVisitor extends AbstractQVTtemplateASSaverResolveVisitor
{
	public QVTtemplateASSaverResolveVisitor(@NonNull ASSaver context) {
		super(context);
	}

	@Override
	public @Nullable Object visitCollectionTemplateExp(@NonNull CollectionTemplateExp object) {
		CollectionType referredCollectionType = QVTtemplateUtil.getReferredCollectionType(object);
		CollectionType resolvedCollectionType = context.resolveType(referredCollectionType);
		if (resolvedCollectionType != referredCollectionType) {
			object.setReferredCollectionType(resolvedCollectionType);
		}
		return super.visitCollectionTemplateExp(object);
	}

	@Override
	public @Nullable Object visitObjectTemplateExp(@NonNull ObjectTemplateExp object) {
		org.eclipse.ocl.pivot.Class referredClass = QVTtemplateUtil.getReferredClass(object);
		org.eclipse.ocl.pivot.Class resolvedClass = context.resolveType(referredClass);
		if (resolvedClass != referredClass) {
			object.setReferredClass(resolvedClass);
		}
		return super.visitObjectTemplateExp(object);
	}
}
