/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtrelation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.TemplateExp;
import org.eclipse.qvt.declarative.parser.qvt.environment.QVTFormattingHelper;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.IQVTrNodeEnvironment;

public class QVTrFormattingHelper extends QVTFormattingHelper
{	
	public QVTrFormattingHelper(IQVTrNodeEnvironment environment) {
		super(environment);
	}

	@Override
	public String formatQualifiedName(Object object) {
		if (object instanceof TemplateExp)
            return formatTemplateExpName((TemplateExp)object, new StringBuffer());
		else
			return super.formatQualifiedName(object);
	}

	public String formatTemplateExpName(EObject object, StringBuffer s) {
		EObject container = object.eContainer();
		if ((container instanceof TemplateExp) || (container instanceof PropertyTemplateItem))
			formatTemplateExpName(container, s);
		else if (object instanceof ObjectTemplateExp) {
			s.append(formatName(((ObjectTemplateExp)object).getReferredClass()));
		}
		else if (object instanceof CollectionTemplateExp) {
			s.append(formatName(((CollectionTemplateExp)object).getReferredCollectionType()));
		}
		if (object instanceof PropertyTemplateItem) {
			s.append(formatName(((PropertyTemplateItem)object).getReferredProperty()));
		}
		else if (object instanceof ObjectTemplateExp) {
			s.append(".");
		}
		else if (object instanceof CollectionTemplateExp) {
			s.append("[]");
		}
		else {
			s.append(formatQualifiedName(object));
		}
		return s.toString();
	}
}
