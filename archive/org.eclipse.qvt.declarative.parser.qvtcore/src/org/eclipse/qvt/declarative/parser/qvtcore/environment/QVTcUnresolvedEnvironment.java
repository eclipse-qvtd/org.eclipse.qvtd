/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtcore.environment;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBaseFactory;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTCore.Mapping;
import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCoreFactory;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;
import org.eclipse.qvt.declarative.parser.environment.UnresolvedEnvironment;

public class QVTcUnresolvedEnvironment extends UnresolvedEnvironment
{
	public QVTcUnresolvedEnvironment(QVTcTopLevelEnvironment rootEnvironment) {
		super(rootEnvironment);
	}

	public Mapping getUnresolvedMapping(Transformation resolvedTransformation, String mappingName) {
		Transformation unresolvedTransformation = getUnresolvedTransformation(resolvedTransformation);
		String name =  "mapping$" + mappingName;
		Mapping unresolvedMapping = (Mapping) EcoreUtils.getNamedElement(unresolvedTransformation.getRule(), name);
		if (unresolvedMapping == null) {
			unresolvedMapping = QVTCoreFactory.eINSTANCE.createMapping();
			unresolvedMapping.setName(name);
			unresolvedMapping.setGuardPattern(QVTCoreFactory.eINSTANCE.createGuardPattern());
			unresolvedMapping.setBottomPattern(QVTCoreFactory.eINSTANCE.createBottomPattern());
			unresolvedTransformation.getRule().add(unresolvedMapping);
		}
		return unresolvedMapping;
	}
	
	public Transformation getUnresolvedTransformation(Transformation resolvedTransformation) {
		EPackage unresolvedEPackage = resolvedTransformation != null ? getUnresolvedEPackage(resolvedTransformation.getEPackage()) : getUnresolvedEPackage();
		return getUnresolvedTransformation(unresolvedEPackage, resolvedTransformation != null ? resolvedTransformation.getName() : "");
	}

	/**
	 * Return the unresolved transformation named by the tail of path.
	 */
	public Transformation getUnresolvedTransformation(List<String> path) {
		if (path == null)
			path = Collections.singletonList("");
		EPackage unresolvedEPackage = getUnresolvedEPackage();
		for (int i = 0; i < path.size()-1; i++)
			unresolvedEPackage = getUnresolvedEPackage(unresolvedEPackage, path.get(i));
		return getUnresolvedTransformation(unresolvedEPackage, path.get(path.size()-1));
	}

	public Transformation getUnresolvedTransformation(EPackage unresolvedEPackage, String rawName) {
		String name = rawName != null ? "transformation$" + rawName : "$transformation$";
		Transformation unresolvedTransformation = (Transformation) EcoreUtils.getNamedElement(unresolvedEPackage.getESubpackages(), name);
		if (unresolvedTransformation == null) {
			unresolvedTransformation = QVTBaseFactory.eINSTANCE.createTransformation();
			unresolvedTransformation.setName(name);
			unresolvedEPackage.getESubpackages().add(unresolvedTransformation);
		}
		return unresolvedTransformation;
	}
}

	

	