/*******************************************************************************
 * Copyright (c) 2014, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvttemplate.utilities;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;

public class QVTtemplateUtil extends QVTbaseUtil
{

	public static class Internal extends QVTbaseUtil.Internal
	{
		public static @NonNull List<@NonNull OCLExpression> getOwnedMembersList(@NonNull CollectionTemplateExp rCollectionTemplateExp) {
			return ClassUtil.nullFree(rCollectionTemplateExp.getMember());
		}

		public static @NonNull List<@NonNull PropertyTemplateItem> getOwnedPartsList(@NonNull ObjectTemplateExp rObjectTemplateExp) {
			return ClassUtil.nullFree(rObjectTemplateExp.getPart());
		}
	}

	public static final @NonNull String DUMMY_VARIABLE_NAME = "_";

	public static @NonNull Iterable<@NonNull OCLExpression> getOwnedMembers(@NonNull CollectionTemplateExp rCollectionTemplateExp) {
		return ClassUtil.nullFree(rCollectionTemplateExp.getMember());
	}

	public static @NonNull Iterable<@NonNull PropertyTemplateItem> getOwnedParts(@NonNull ObjectTemplateExp rObjectTemplateExp) {
		return ClassUtil.nullFree(rObjectTemplateExp.getPart());
	}

	public static @NonNull OCLExpression getOwnedValue(@NonNull PropertyTemplateItem rPropertyTemplateItem) {
		return ClassUtil.nonNullState(rPropertyTemplateItem.getValue());
	}

	public static org.eclipse.ocl.pivot.@NonNull Class getReferredClass(@NonNull ObjectTemplateExp rObjectTemplateExp) {
		return ClassUtil.nonNullState(rObjectTemplateExp.getReferredClass());
	}

	public static @NonNull CollectionType getReferredCollectionType(@NonNull CollectionTemplateExp rCollectionTemplateExp) {
		return ClassUtil.nonNullState(rCollectionTemplateExp.getReferredCollectionType());
	}

	public static @NonNull Property getReferredProperty(@NonNull PropertyTemplateItem rPropertyTemplateItem) {
		return ClassUtil.nonNullState(rPropertyTemplateItem.getReferredProperty());
	}
}