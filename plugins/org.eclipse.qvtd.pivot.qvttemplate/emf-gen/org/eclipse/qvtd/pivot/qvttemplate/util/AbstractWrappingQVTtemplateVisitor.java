/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
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
 * from: org.eclipse.qvtd.pivot.qvttemplate/model/QVTtemplate.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvttemplate.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractWrappingQVTtemplateVisitor delegates all visits wrapping the delegation in a call to a preVisit function and a postVisit function.
 */
public abstract class AbstractWrappingQVTtemplateVisitor<R, C, D extends QVTtemplateVisitor<R>, P>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractWrappingQVTbaseVisitor<R, C, D, P>
	implements QVTtemplateVisitor<R>
{
	protected AbstractWrappingQVTtemplateVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visitCollectionTemplateExp(org.eclipse.qvtd.pivot.qvttemplate.@NonNull CollectionTemplateExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCollectionTemplateExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitObjectTemplateExp(org.eclipse.qvtd.pivot.qvttemplate.@NonNull ObjectTemplateExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitObjectTemplateExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPropertyTemplateItem(org.eclipse.qvtd.pivot.qvttemplate.@NonNull PropertyTemplateItem object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPropertyTemplateItem(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTemplateExp(org.eclipse.qvtd.pivot.qvttemplate.@NonNull TemplateExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTemplateExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}
}
