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
 * $Id: AdaptingEList.java,v 1.2 2008/08/08 17:00:10 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.adapters;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.qvt.declarative.ecore.mappings.MappingMetaDataRegistry;

/**
 * An AdaptingEList maintains an EList of adapting adapting model objects, delegating all interaction
 * to a corresponding list of adapted ecore objects, performing appropriate adapting to ecore and
 * ecore to adapting conversions.
 *
 * @param <E> Ecore model EObject type
 * @param <A> Adapting model EObject type
 * @param <L> Ecore model EList type
 */
public class AdaptingEList<E extends EObject, A extends EObject, L extends EList<E>> extends AdaptingList<E, A, L> implements EList<A>
{
	public AdaptingEList(MappingMetaDataRegistry mappingMetaDataRegistry, L ecoreList) {
		super(mappingMetaDataRegistry, ecoreList);
	}

	public void move(int newPosition, A adaptingObject) {
		ecoreList.move(newPosition, getTarget(adaptingObject));		
	}

	public A move(int newPosition, int oldPosition) {
		return getAdapter(ecoreList.move(newPosition, oldPosition));		
	}
}