/*******************************************************************************
 * Copyright (c) 2012 E.D. Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvttemplate.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseToStringVisitor;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.util.QVTtemplateVisitor;

/**
 * Converts an OCL expression to a string for debugging. This is not intended to
 * be used by client applications as an AST-to-text transformation.
 */
public class QVTtemplateToStringVisitor extends QVTbaseToStringVisitor implements QVTtemplateVisitor<String>
{
	public QVTtemplateToStringVisitor(@NonNull StringBuilder s) {
		super(s);
	}

	public String visitCollectionTemplateExp(@NonNull CollectionTemplateExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String visitObjectTemplateExp(@NonNull ObjectTemplateExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String visitPropertyTemplateItem(@NonNull PropertyTemplateItem object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String visitTemplateExp(@NonNull TemplateExp object) {
		// TODO Auto-generated method stub
		return null;
	}
}
