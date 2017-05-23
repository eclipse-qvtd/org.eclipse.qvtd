/*******************************************************************************
 * Copyright (c) 2014, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvttemplate.utilities;

import java.util.Comparator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.util.AbstractQVTtemplateASSaverNormalizeVisitor;

public class QVTtemplateASSaverNormalizeVisitor extends AbstractQVTtemplateASSaverNormalizeVisitor
{
	protected static final class PropertyTemplateItemComparator implements Comparator<@NonNull PropertyTemplateItem>
	{
		public static final @NonNull Comparator<@NonNull PropertyTemplateItem> INSTANCE = new PropertyTemplateItemComparator();

		@Override
		public int compare(@NonNull PropertyTemplateItem o1, @NonNull PropertyTemplateItem o2) {
			int l1 = o1.isIsOpposite() ? 1 : 0;
			int l2 = o2.isIsOpposite() ? 1 : 0;
			if (l1 != l2) {
				return l1 - l2;
			}
			String n1 = PivotUtil.getName(QVTtemplateUtil.getReferredProperty(o1));
			String n2 = PivotUtil.getName(QVTtemplateUtil.getReferredProperty(o2));
			return n1.compareTo(n2);
		}
	}

	public QVTtemplateASSaverNormalizeVisitor(@NonNull ASSaver context) {
		super(context);
	}

	@Override
	public @Nullable Object visitObjectTemplateExp(@NonNull ObjectTemplateExp object) {
		ClassUtil.sort(QVTtemplateUtil.Internal.getOwnedPartsList(object), PropertyTemplateItemComparator.INSTANCE);
		return null;
	}
}
