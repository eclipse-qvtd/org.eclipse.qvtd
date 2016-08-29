/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.tests.utilities;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * An EcoreURIAdapter supports definition of an explicit, typically platform:/resource/..../*.ecore, URI
 * as the source of the eResource() of a typically Java generated EPackage.
 */
public class EcoreURIAdapter extends AdapterImpl
{
	public static @Nullable EcoreURIAdapter findAdapter(@NonNull Resource resource) {
		List<Adapter> eAdapters = resource.eAdapters();
		for (Adapter adapter : eAdapters) {
			if (adapter instanceof EcoreURIAdapter) {
				return (EcoreURIAdapter)adapter;
			}
		}
		return null;
	}

	public static @NonNull EcoreURIAdapter getAdapter(@NonNull Resource resource, @NonNull URI ecoreURI) {
		List<Adapter> eAdapters = resource.eAdapters();
		for (Adapter adapter : eAdapters) {
			if (adapter instanceof EcoreURIAdapter) {
				EcoreURIAdapter ecoreURIAdapter = (EcoreURIAdapter)adapter;
				if (ecoreURIAdapter.ecoreURI.equals(ecoreURI)) {
					return ecoreURIAdapter;
				}
				else {
					throw new IllegalStateException("Conflicting " + ecoreURI + " and " + ecoreURIAdapter.ecoreURI + " for " + resource);
				}
			}
		}
		return new EcoreURIAdapter(resource, ecoreURI);
	}

	public static @Nullable URI getEcoreURI(@NonNull Resource resource) {
		EcoreURIAdapter ecoreURIAdapter = findAdapter(resource);
		if (ecoreURIAdapter != null) {
			return ecoreURIAdapter.ecoreURI;
		}
		else {
			return null;
		}
	}

	public static void setEcoreURI(/*@NonNull*/ EPackage ePackage, @NonNull URI ecoreURI) {
		getAdapter(ClassUtil.nonNullState(ePackage.eResource()), ecoreURI);
	}

	protected final @NonNull URI ecoreURI;

	public EcoreURIAdapter(@NonNull Resource resource, @NonNull URI ecoreURI) {
		resource.eAdapters().add(this);
		this.ecoreURI = ecoreURI;
	}

	public @NonNull URI getEcoreURI() {
		return ecoreURI;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == EcoreURIAdapter.class;
	}
}
