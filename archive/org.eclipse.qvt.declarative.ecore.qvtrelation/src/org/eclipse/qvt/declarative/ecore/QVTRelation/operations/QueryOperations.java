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
 * $Id: QueryOperations.java,v 1.1 2008/12/31 17:43:38 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.operations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.FunctionOperations;
import org.eclipse.qvt.declarative.ecore.QVTRelation.OppositePropertyCallExp;

public class QueryOperations extends FunctionOperations
{
	public static QueryOperations INSTANCE = new QueryOperations();

	@Override
	protected String mayHaveSideEffect(EObject object) {
		if (object instanceof OppositePropertyCallExp)
			return null;
		return super.mayHaveSideEffect(object);
	}
}