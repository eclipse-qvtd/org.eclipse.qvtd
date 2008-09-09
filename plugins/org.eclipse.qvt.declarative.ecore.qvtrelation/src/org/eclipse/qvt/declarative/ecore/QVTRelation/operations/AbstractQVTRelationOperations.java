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
 * $Id: AbstractQVTRelationOperations.java,v 1.1 2008/09/09 20:59:19 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.operations;

import org.eclipse.qvt.declarative.ecore.QVTRelation.util.QVTRelationValidator;
import org.eclipse.qvt.declarative.ecore.operations.AbstractOperations;

public class AbstractQVTRelationOperations extends AbstractOperations
{
	public static final String DIAGNOSTIC_SOURCE = QVTRelationValidator.INSTANCE.getDiagnosticSource();

	protected AbstractQVTRelationOperations() {
		super(QVTRelationValidator.INSTANCE);
	}
}