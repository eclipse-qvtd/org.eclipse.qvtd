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
 * $Id: AbstractQVTBaseOperations.java,v 1.2 2008/12/31 17:42:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.operations;

import org.eclipse.qvt.declarative.ecore.QVTBase.util.QVTBaseValidator;
import org.eclipse.qvt.declarative.ecore.operations.EValidatorWithOperations;

public class AbstractQVTBaseOperations extends AbstractEssentialOCLOperations
{
	protected AbstractQVTBaseOperations() {
		this(QVTBaseValidator.INSTANCE);
	}

	public AbstractQVTBaseOperations(EValidatorWithOperations validator) {
		super(validator);
	}
}