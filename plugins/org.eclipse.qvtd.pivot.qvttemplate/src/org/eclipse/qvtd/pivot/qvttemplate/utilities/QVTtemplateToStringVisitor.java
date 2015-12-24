/*******************************************************************************
 * Copyright (c) 2012, 2014 E.D. Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvttemplate.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseToStringVisitor;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.util.QVTtemplateVisitor;

/**
 * Converts an OCL expression to a string for debugging. This is not intended to
 * be used by client applications as an AST-to-text transformation.
 */
public class QVTtemplateToStringVisitor extends QVTbaseToStringVisitor implements QVTtemplateVisitor<String>
{
	protected static class QVTtemplateToStringFactory implements QVTbaseToStringVisitor.Factory
	{
		protected QVTtemplateToStringFactory() {
			ToStringVisitor.addFactory(this);
			QVTbaseToStringVisitor.FACTORY.getClass();
		}

		@Override
		public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
			return new QVTtemplateToStringVisitor(s);
		}

		@Override
		public @NonNull EPackage getEPackage() {
			QVTtemplatePackage eInstance = QVTtemplatePackage.eINSTANCE;
			assert eInstance != null;
			return eInstance;
		}
	}

	public static ToStringVisitor.@NonNull Factory FACTORY = new QVTtemplateToStringFactory();

	public QVTtemplateToStringVisitor(@NonNull StringBuilder s) {
		super(s);
	}

	@Override
	public String visitCollectionTemplateExp(@NonNull CollectionTemplateExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitObjectTemplateExp(@NonNull ObjectTemplateExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitPropertyTemplateItem(@NonNull PropertyTemplateItem object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitTemplateExp(@NonNull TemplateExp object) {
		// TODO Auto-generated method stub
		return null;
	}
}
