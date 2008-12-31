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
 * $Id: EPackageOperations.java,v 1.1 2008/12/31 17:38:40 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.operations;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;

public class EPackageOperations extends AbstractEcoreOperations
{
	public static EPackageOperations INSTANCE = new EPackageOperations();

	public Set<EPackage> getAllEPackages(EPackage ePackage) {
		Set<EPackage> allEPackages = new HashSet<EPackage>();
		getAllEPackages(ePackage, allEPackages);
		return allEPackages;
	}

	public void getAllEPackages(EPackage ePackage, Set<EPackage> allEPackages) {
		if (allEPackages.add(ePackage))
			for (EPackage subPackage : ePackage.getESubpackages())
				getAllEPackages(subPackage, allEPackages);
	}
}