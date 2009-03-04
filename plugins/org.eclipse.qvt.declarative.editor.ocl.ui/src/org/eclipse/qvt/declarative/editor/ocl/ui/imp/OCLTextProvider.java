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
 * $Id: OCLTextProvider.java,v 1.2 2009/03/04 19:36:24 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ocl.ui.imp;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.qvt.declarative.editor.util.TextProvider;

public class OCLTextProvider implements TextProvider
{
	public String getText(Object object) {
		if (object instanceof OperationCallExp) {
			OperationCallExp operationCallExp = (OperationCallExp) object;
			OCLExpression<EClassifier> source = operationCallExp.getSource();
			if (source == null)
				return "";
			EClassifier type = source.getType();
			if (type instanceof CollectionType)
				return "->";
			else
				return ".";
		}
		return null;
	}
}
