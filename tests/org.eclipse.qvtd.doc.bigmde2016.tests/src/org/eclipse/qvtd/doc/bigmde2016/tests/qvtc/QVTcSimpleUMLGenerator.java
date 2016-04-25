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
package org.eclipse.qvtd.doc.bigmde2016.tests.qvtc;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.doc.bigmde2016.tests.SimpleUMLGenerator;

import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Association;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Attribute;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Package;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.PrimitiveDataType;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.SimpleumlFactory;

public class QVTcSimpleUMLGenerator extends SimpleUMLGenerator<Package, Class, PrimitiveDataType, Attribute, Association>
{ 
	@Override
	protected @NonNull Association createAssociation(@NonNull Package parentPackage, @NonNull String name, @NonNull Class fromClass, @NonNull Class toClass) {
		Association anAssociation = SimpleumlFactory.eINSTANCE.createAssociation();
		anAssociation.setName(name);
		anAssociation.setSource(fromClass);
		anAssociation.setDestination(toClass);
		parentPackage.getElements().add(anAssociation);
		return anAssociation;
	}

	@Override
	protected @NonNull Class createClass(@NonNull Package parentPackage, @NonNull String name) {
		Class aClass = SimpleumlFactory.eINSTANCE.createClass();
		aClass.setName(name);
//		aClass.getStereotype().add("persistent");
		if (parentPackage != null) {
			parentPackage.getElements().add(aClass);
		}
		return aClass;
	}

	@Override
	protected @NonNull List<@NonNull ? extends EObject> createModel(@NonNull List<Package> rootPackages, @NonNull String name) {
		Package aModel = SimpleumlFactory.eINSTANCE.createPackage();
		aModel.setName(name);
		aModel.getElements().addAll(rootPackages);
		return Collections.singletonList(aModel);
	}

	public @NonNull Package createPackage(@Nullable Package parentPackage, @NonNull String name) {
		Package aPackage = SimpleumlFactory.eINSTANCE.createPackage();
		aPackage.setName(name);
		if (parentPackage != null) {
			parentPackage.getElements().add(aPackage);
		}
		return aPackage;
	}

	@Override
	protected @NonNull Attribute createProperty(@NonNull Class aClass, @NonNull String name, @NonNull PrimitiveDataType type) {
		Attribute aProperty = SimpleumlFactory.eINSTANCE.createAttribute();
		aProperty.setName(name);
		aProperty.setType(type);
		if (aClass != null) {
			aClass.getAttributes().add(aProperty);
		}
		return aProperty;
	}

	@Override
	protected @NonNull PrimitiveDataType createType(@NonNull Package parentPackage, @NonNull String name) {
		PrimitiveDataType aType = SimpleumlFactory.eINSTANCE.createPrimitiveDataType();
		aType.setName(name);
		if (parentPackage != null) {
			parentPackage.getElements().add(aType);
		}
		return aType;
	}
}
