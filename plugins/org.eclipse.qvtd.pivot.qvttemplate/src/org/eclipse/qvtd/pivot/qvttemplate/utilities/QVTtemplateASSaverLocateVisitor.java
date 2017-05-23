/*******************************************************************************
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvttemplate.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.util.AbstractQVTtemplateASSaverLocateVisitor;

public class QVTtemplateASSaverLocateVisitor extends AbstractQVTtemplateASSaverLocateVisitor
{
	public QVTtemplateASSaverLocateVisitor(@NonNull ASSaver context) {
		super(context);
	}

	@Override
	public @Nullable Object visitCollectionTemplateExp(@NonNull CollectionTemplateExp object) {
		CollectionType referredCollectionType = object.getReferredCollectionType();
		if (referredCollectionType != null) {
			context.addSpecializingElement(object, referredCollectionType);
		}
		return super.visitCollectionTemplateExp(object);
	}

	@Override
	public @Nullable Object visitObjectTemplateExp(@NonNull ObjectTemplateExp object) {
		org.eclipse.ocl.pivot.Class referredClass = object.getReferredClass();
		if (referredClass != null) {
			context.addSpecializingElement(object, referredClass);
		}
		return super.visitObjectTemplateExp(object);
	}

	@Override
	public Object visitPropertyTemplateItem(@NonNull PropertyTemplateItem object) {
		Property referredProperty = object.getReferredProperty();
		if (referredProperty != null) {
			context.addSpecializingElement(object, referredProperty);
		}
		return super.visitPropertyTemplateItem(object);
	}
}
