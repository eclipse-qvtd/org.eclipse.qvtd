/**
 * <copyright>
 * 
 * Copyright (c) 2009 E.D.Willink and others.
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
 * $Id: OCLFormatProvider.java,v 1.1 2009/10/31 17:48:52 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ocl.ui.imp;

import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.qvt.declarative.editor.util.FormatProvider;

public class OCLFormatProvider implements FormatProvider
{
	public String getFormat(Object object) {
		if (object instanceof Constraint) {
			Constraint constraint = (Constraint) object;
			String stereotype = constraint.getStereotype();
			if (UMLReflection.INVARIANT.equals(stereotype))
				return "{0}{1}{3}{4} - {5}";
			else if (UMLReflection.POSTCONDITION.equals(stereotype))
				return "{0}{1}::{2}{3}{4} - {5}";
			else if (UMLReflection.PRECONDITION.equals(stereotype))
				return "{0}{1}::{2}{3}{4} - {5}";
			else if (UMLReflection.DEFINITION.equals(stereotype))
				return "{0}{1}::{2}{3}{4} - {5}";
			else if (UMLReflection.DERIVATION.equals(stereotype))
				return "{0}{1}::{2}{3}{4} - {5}";
			else if (UMLReflection.INITIAL.equals(stereotype))
				return "{0}{1}::{2}{3}{4} - {5}";
		}
		return null;
	}
}
