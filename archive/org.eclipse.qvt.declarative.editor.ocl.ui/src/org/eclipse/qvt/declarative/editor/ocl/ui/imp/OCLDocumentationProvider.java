/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLDocumentationProvider.java,v 1.2 2008/10/21 20:07:55 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ocl.ui.imp;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonDocumentationProvider;

public class OCLDocumentationProvider extends CommonDocumentationProvider
{
	@Override
	protected String getASTDocumentation(Object node) {
		if (node instanceof Constraint)
			return "<" + ((Constraint)node).getStereotype() + "> " + EcoreUtils.formatName(((EObject)node).eClass()) + " : " + EcoreUtils.formatQualifiedName(node);
		return super.getASTDocumentation(node);
	}
}
