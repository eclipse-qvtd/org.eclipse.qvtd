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
 * $Id: EcoreItemProviderAdapterFactoryEx.java,v 1.2 2008/10/10 13:31:45 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.presentation;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.provider.EAttributeItemProvider;
import org.eclipse.emf.ecore.provider.EReferenceItemProvider;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;

public class EcoreItemProviderAdapterFactoryEx extends EcoreItemProviderAdapterFactory
{
	@Override
	public Adapter createEAttributeAdapter()
	{
		if (eAttributeItemProvider == null)
		{
			eAttributeItemProvider = new EAttributeItemProvider(this) {
				@Override
				public String getText(Object obj) {
					return EcoreUtils.formatQualifiedName(obj);
				}
			};
		}
		return eAttributeItemProvider;
	}
	
	@Override
	public Adapter createEReferenceAdapter()
	{
		if (eReferenceItemProvider == null)
		{
			eReferenceItemProvider = new EReferenceItemProvider(this) {
				@Override
				public String getText(Object obj) {
					return EcoreUtils.formatQualifiedName(obj);
				}
			};
		}
		return eReferenceItemProvider;
	}
}
