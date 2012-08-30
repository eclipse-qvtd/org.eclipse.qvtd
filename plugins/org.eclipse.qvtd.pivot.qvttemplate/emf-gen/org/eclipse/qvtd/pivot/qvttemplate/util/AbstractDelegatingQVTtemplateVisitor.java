/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: /org.eclipse.qvtd.pivot.qvttemplate/model/QVTtemplate.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.pivot.qvttemplate.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingQVTtemplateVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTtemplateVisitor<R, C, D extends QVTtemplateVisitor<R>>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractDelegatingQVTbaseVisitor<R, C, D>
	implements QVTtemplateVisitor<R>
{
    protected AbstractDelegatingQVTtemplateVisitor(@NonNull D delegate, @NonNull C context) {
        super(delegate, context);
    }

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.pivot.util.Visitable visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitCollectionTemplateExp(@NonNull org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp object) {
		return delegate.visitCollectionTemplateExp(object);
	}

	public @Nullable R visitObjectTemplateExp(@NonNull org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp object) {
		return delegate.visitObjectTemplateExp(object);
	}

	public @Nullable R visitPropertyTemplateItem(@NonNull org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem object) {
		return delegate.visitPropertyTemplateItem(object);
	}

	public @Nullable R visitTemplateExp(@NonNull org.eclipse.qvtd.pivot.qvttemplate.TemplateExp object) {
		return delegate.visitTemplateExp(object);
	}
}
