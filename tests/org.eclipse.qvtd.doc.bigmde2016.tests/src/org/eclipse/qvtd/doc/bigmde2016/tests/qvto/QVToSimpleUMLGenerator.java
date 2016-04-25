/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.bigmde2016.tests.qvto;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.doc.bigmde2016.tests.SimpleUMLGenerator;

import simpleuml.Association;
import simpleuml.Class;
import simpleuml.Model;
import simpleuml.SimpleumlFactory;
import simpleuml.Package;
import simpleuml.PrimitiveType;
import simpleuml.Property;

public class QVToSimpleUMLGenerator extends SimpleUMLGenerator<Package, Class, PrimitiveType, Property, Association>
{ 
	@Override
	protected @NonNull Association createAssociation(@NonNull Package parentPackage, @NonNull String name, @NonNull Class fromClass, @NonNull Class toClass) {
		Association anAssociation = SimpleumlFactory.eINSTANCE.createAssociation();
		anAssociation.setName(name);
		anAssociation.setSource(fromClass);
		anAssociation.setTarget(toClass);
		parentPackage.getOwnedElements().add(anAssociation);
		return anAssociation;
	}

	@Override
	protected @NonNull Class createClass(@NonNull Package parentPackage, @NonNull String name) {
		Class aClass = SimpleumlFactory.eINSTANCE.createClass();
		aClass.setName(name);
		aClass.getStereotype().add("persistent");
		if (parentPackage != null) {
			parentPackage.getOwnedElements().add(aClass);
		}
		return aClass;
	}

	@Override
	protected @NonNull List<@NonNull EObject> createModel(@NonNull List<Package> rootPackages, @NonNull String name) {
		Model aModel = SimpleumlFactory.eINSTANCE.createModel();
		aModel.setName(name);
		aModel.getOwnedElements().addAll(rootPackages);
		return Collections.singletonList(aModel);
	}

	public @NonNull Package createPackage(@Nullable Package parentPackage, @NonNull String name) {
		Package aPackage = SimpleumlFactory.eINSTANCE.createPackage();
		aPackage.setName(name);
		if (parentPackage != null) {
			parentPackage.getOwnedElements().add(aPackage);
		}
		return aPackage;
	}

	@Override
	protected @NonNull Property createProperty(@NonNull Class aClass, @NonNull String name, @NonNull PrimitiveType type) {
		Property aProperty = SimpleumlFactory.eINSTANCE.createProperty();
		aProperty.setName(name);
		aProperty.setType(type);
		if (aClass != null) {
			aClass.getAttributes().add(aProperty);
		}
		return aProperty;
	}

	@Override
	protected @NonNull PrimitiveType createType(@NonNull Package parentPackage, @NonNull String name) {
		PrimitiveType aType = SimpleumlFactory.eINSTANCE.createPrimitiveType();
		aType.setName(name);
		if (parentPackage != null) {
			parentPackage.getOwnedElements().add(aType);
		}
		return aType;
	}
}
