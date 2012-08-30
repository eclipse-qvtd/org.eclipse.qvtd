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
 * An AbstractNullQVTtemplateVisitor provides a default implementation for each
 * visitXxx method that returns null.
 */
public abstract class AbstractNullQVTtemplateVisitor<R, C>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractNullQVTbaseVisitor<R, C> implements QVTtemplateVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullQVTtemplateVisitor(@NonNull C context) {
	    super(context);
	}	

	public @Nullable R visitCollectionTemplateExp(@NonNull org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp object) {
		return null;
	}

	public @Nullable R visitObjectTemplateExp(@NonNull org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp object) {
		return null;
	}

	public @Nullable R visitPropertyTemplateItem(@NonNull org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem object) {
		return null;
	}

	public @Nullable R visitTemplateExp(@NonNull org.eclipse.qvtd.pivot.qvttemplate.TemplateExp object) {
		return null;
	}
}
