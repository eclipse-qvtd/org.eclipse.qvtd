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

/**
 * An AbstractDelegatingQVTtemplateVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTtemplateVisitor<R, C, D extends QVTtemplateVisitor<R>>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractDelegatingQVTbaseVisitor<R, C, D>
	implements QVTtemplateVisitor<R>
{
    protected AbstractDelegatingQVTtemplateVisitor(D delegate, C context) {
        super(delegate, context);
    }

	@Override
	public R visiting(org.eclipse.ocl.examples.pivot.util.Visitable visitable) {
		return delegate.visiting(visitable);
	}

	public R visitCollectionTemplateExp(org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp object) {
		return delegate.visitCollectionTemplateExp(object);
	}

	public R visitObjectTemplateExp(org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp object) {
		return delegate.visitObjectTemplateExp(object);
	}

	public R visitPropertyTemplateItem(org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem object) {
		return delegate.visitPropertyTemplateItem(object);
	}

	public R visitTemplateExp(org.eclipse.qvtd.pivot.qvttemplate.TemplateExp object) {
		return delegate.visitTemplateExp(object);
	}
}
