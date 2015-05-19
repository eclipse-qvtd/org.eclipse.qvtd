/*******************************************************************************
 * Copyright (c) 2012, 2014 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbasePrettyPrintVisitor;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.util.QVTtemplateVisitor;

public class QVTtemplatePrettyPrintVisitor extends QVTbasePrettyPrintVisitor implements QVTtemplateVisitor<Object>
{	
	public QVTtemplatePrettyPrintVisitor(@NonNull PrettyPrinter context) {
		super(context);
	}

	@Override
	public Object visitCollectionTemplateExp(@NonNull CollectionTemplateExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitObjectTemplateExp(@NonNull ObjectTemplateExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitPropertyTemplateItem(@NonNull PropertyTemplateItem object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitTemplateExp(@NonNull TemplateExp object) {
		// TODO Auto-generated method stub
		return null;
	}
}
