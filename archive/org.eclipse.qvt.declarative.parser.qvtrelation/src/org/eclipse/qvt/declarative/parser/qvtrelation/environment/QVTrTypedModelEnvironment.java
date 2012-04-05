/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtrelation.environment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBaseFactory;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.ModelDeclCS;

public class QVTrTypedModelEnvironment extends QVTrEnvironment<QVTrTransformationEnvironment, TypedModel, ModelDeclCS>
{
	private final Map<String,Set<EPackage>> metaModelIdToPackages = new HashMap<String,Set<EPackage>>();

	public QVTrTypedModelEnvironment(QVTrTransformationEnvironment env, ModelDeclCS modelDeclCS) {
		super(env, QVTBaseFactory.eINSTANCE.createTypedModel(), modelDeclCS);
		setNameFromIdentifier(ast, modelDeclCS.getModelId());
	}

	public void addMetaModelPackage(String metaModelId, EPackage ePackage) {
		Set<EPackage> contents = metaModelIdToPackages.get(metaModelId);
		if (contents == null) {
			contents = new HashSet<EPackage>();
			metaModelIdToPackages.put(metaModelId, contents);
		}
		contents.add(ePackage);
		getParentEnvironment().addMetaModelPackage(metaModelId, ePackage);
	}

	@Override public String getModelName(EObject object) {
		for (String key : metaModelIdToPackages.keySet()) {
			Set<EPackage> ePackages = metaModelIdToPackages.get(key);
			if (ePackages.contains(object))
				return key;
		}
		return null;
	}	

	public TypedModel getTypedModel() { return ast; }
}
