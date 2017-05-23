/*******************************************************************************
 * Copyright (c) 2012, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.bigmde2016.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public abstract class SimpleUMLGenerator<@NonNull PACKAGE extends EObject, @NonNull CLASS extends EObject, @NonNull TYPE extends EObject, @NonNull PROPERTY extends EObject, @NonNull ASSOCIATION extends EObject>
{ 
    public @NonNull List<@NonNull ? extends EObject> createSimpleUMLModel(int nPackages, int nClasses, int nTypes, int nProperties, int nAssociations) {
    	ThreadLocalRandom random = ThreadLocalRandom.current();
		List<PACKAGE> rootPackages = new ArrayList<PACKAGE>(10);
		List<PACKAGE> allPackages = new ArrayList<PACKAGE>(nPackages);
		for (int iPackage = 0; iPackage < nPackages; iPackage++) {
			int parentPackageIndex = random.nextInt(-1, allPackages.size());
			PACKAGE parentPackage = parentPackageIndex >= 0 ? allPackages.get(parentPackageIndex) : null;
			PACKAGE aPackage = createPackage(parentPackage, "k"+iPackage);
			allPackages.add(aPackage);
			if (parentPackage == null) {
				rootPackages.add(aPackage);
			}
		}
		List<CLASS> allClasses = new ArrayList<CLASS>(nClasses);
		for (int iClass = 0; iClass < nClasses; iClass++) {
			int parentPackageIndex = random.nextInt(0, allPackages.size());
			allClasses.add(createClass(allPackages.get(parentPackageIndex), "c"+iClass));
		}
		List<TYPE> allTypes = new ArrayList<TYPE>(nTypes);
		for (int iType = 0; iType < nTypes; iType++) {
			int parentPackageIndex = random.nextInt(0, allPackages.size());
			allTypes.add(createType(allPackages.get(parentPackageIndex), "t"+iType));
		}
		List<PROPERTY> allProperties = new ArrayList<PROPERTY>(nProperties);
		for (int iProperty = 0; iProperty < nProperties; iProperty++) {
			int parentClassIndex = random.nextInt(0, allClasses.size());
			int typeIndex = random.nextInt(0, allTypes.size());
			allProperties.add(createProperty(allClasses.get(parentClassIndex), "p"+iProperty, allTypes.get(typeIndex)));
		}
		List<ASSOCIATION> allAssociations = new ArrayList<ASSOCIATION>(nAssociations);
		for (int iAssociation = 0; iAssociation < nAssociations; iAssociation++) {
			int parentPackageIndex = random.nextInt(0, allPackages.size());
			int fromClassIndex = random.nextInt(0, allClasses.size());
			int toClassIndex = random.nextInt(0, allClasses.size());
			allAssociations.add(createAssociation(allPackages.get(parentPackageIndex), "a"+iAssociation, allClasses.get(fromClassIndex), allClasses.get(toClassIndex)));
		}
		return createModel(rootPackages, "m0");
	}
	protected abstract ASSOCIATION createAssociation(PACKAGE parentPackage, @NonNull String name, CLASS fromClass, CLASS toClass);

	protected abstract CLASS createClass(PACKAGE aPackage, @NonNull String name);

	protected abstract @NonNull List<@NonNull ? extends EObject> createModel(@NonNull List<PACKAGE> rootPackages, @NonNull String name);

	protected abstract PACKAGE createPackage(@Nullable PACKAGE aPackage, @NonNull String name);

	protected abstract PROPERTY createProperty(CLASS aClass, @NonNull String name, TYPE type);

	protected abstract TYPE createType(PACKAGE aPackage, @NonNull String name);
}
