/*******************************************************************************
 * Copyright (c) 2010, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.umlx.resource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMISaveImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;

/**
 * PivotSaveImpl ensures that all references to specialized types are terminated
 * by local copies of the specialization.
 */
public final class UMLXSaveImpl extends XMISaveImpl
{
	/**
	 * The Lookup override enforces alphabetical order on saved features.
	 */
	public static class Lookup extends XMISaveImpl.Lookup
	{
		public Lookup() {
			super(null, null, null);
		}

		@Override
		protected EStructuralFeature[] listFeatures(EClass cls) {
			EStructuralFeature[] listFeatures = super.listFeatures(cls);
			Arrays.sort(listFeatures, NameUtil.ENamedElementComparator.INSTANCE);
			return listFeatures;
		}
	}

	public UMLXSaveImpl(@NonNull XMLHelper helper) {
		super(helper);
	}

	/**
	 * Prepare a pivot resource for save by redirecting all type references to
	 * specializations to local copies of the specializations.
	 */
	@Override
	protected void init(XMLResource resource, Map<?, ?> options) {
		XMLResource asResource = ClassUtil.nonNullState(resource);
		Map<@NonNull String, @Nullable Object> saveOptions = new HashMap<>();
		if (options != null) {
			for (Object key : options.keySet()) {
				saveOptions.put(String.valueOf(key), options.get(key));
			}
		}
		UMLX2XMIid as2xmIid = new UMLX2XMIid();
		ResourceSet asResourceSet = asResource.getResourceSet();
		if (asResourceSet != null) {
			as2xmIid.assignIds(asResourceSet, saveOptions);
		}
		else if (asResource instanceof UMLXResourceImpl){
			as2xmIid.assignIds((UMLXResourceImpl) asResource, saveOptions);
		}
		super.init(asResource, saveOptions);
	}
}