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
package org.eclipse.qvt.declarative.parser.qvt.environment;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.PrimitiveType;
import org.eclipse.ocl.ecore.TypeType;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.qvt.declarative.ecore.utils.CSTFormattingHelper;

public class QVTFormattingHelper extends CSTFormattingHelper
{
	protected final IQVTNodeEnvironment environment;
	
	public QVTFormattingHelper(IQVTNodeEnvironment environment) {
		this.environment = environment;
	}

	@Override public String formatQualifiedName(Object object) {
		if (object instanceof PrimitiveType)			// OCL built-ins do not need a gratuitous
			return formatName(object);					//  oclstdlib.ecore::oclstdlib prefix
		if (object instanceof CollectionType)
			return formatName(object);
		if (object instanceof TypeType) {				// Type references should show the referred type
			EClassifier referredType = ((TypeType)object).getReferredType();
			if (referredType != null)
				return "Type(" + formatQualifiedName(referredType) + ")";
		}
		if (object instanceof OCLExpression<?>) {
			return object.toString();
		}
		if (object instanceof EObject) {
			EObject eObject = (EObject)object;
			EObject container = eObject.eContainer();
			if (container != null)
				return formatQualifiedName(container) + getSeparator() + formatName(object);
			String prefix = environment.getModelName(eObject);
			if (prefix == null) {
				Resource resource = eObject.eResource();
				if (resource != null)
					prefix = formatResource(resource);
			}
			if (prefix != null)
				return prefix + getSeparator() + formatName(object);
		}
		return formatName(object);
	}
}
