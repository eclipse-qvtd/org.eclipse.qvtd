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
 * $Id: AbstractQVTRelationOperations.java,v 1.2 2008/12/31 17:43:38 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.operations;

import org.eclipse.qvt.declarative.ecore.QVTRelation.util.QVTRelationValidator;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.operations.AbstractQVTTemplateOperations;

public class AbstractQVTRelationOperations extends AbstractQVTTemplateOperations
{
	protected AbstractQVTRelationOperations() {
		super(QVTRelationValidator.INSTANCE);
	}
}