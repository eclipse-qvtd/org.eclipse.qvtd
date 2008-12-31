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
 * $Id: AbstractQVTTemplateValidationTest.java,v 1.1 2008/12/31 18:19:15 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.emof.qvttemplate;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplateFactory;
import org.eclipse.qvt.declarative.test.emof.qvtbase.AbstractQVTBaseValidationTest;

public abstract class AbstractQVTTemplateValidationTest extends AbstractQVTBaseValidationTest
{
	public static final QVTTemplateFactory QVTt_Factory = QVTTemplateFactory.eINSTANCE;

	protected CollectionTemplateExp createCollectionTemplateExp(Variable variable, CollectionType collectionType, Variable rest, OCLExpression... members) {
		CollectionTemplateExp collectionTemplateExp = QVTt_Factory.createCollectionTemplateExp();
		if (variable != null) {
			collectionTemplateExp.setBindsTo(variable);
			collectionTemplateExp.setEType(variable.getEType());
		}
		if (collectionType != null)
			collectionTemplateExp.setReferredCollectionType(collectionType);
		if (members != null) {
			for (OCLExpression member : members)
				collectionTemplateExp.getMember().add(member);
		}
		if (rest != null)
			collectionTemplateExp.setRest(rest);
		return collectionTemplateExp;
	}

	protected ObjectTemplateExp createObjectTemplateExp(Variable variable, EClass referredClass, PropertyTemplateItem... parts) {
		ObjectTemplateExp objectTemplateExp = QVTt_Factory.createObjectTemplateExp();
		if (variable != null) {
			objectTemplateExp.setBindsTo(variable);
			objectTemplateExp.setEType(variable.getEType());
		}
		if (referredClass != null)
			objectTemplateExp.setReferredClass(referredClass);
		if (parts != null) {
			for (PropertyTemplateItem part : parts)
				objectTemplateExp.getPart().add(part);
		}
		return objectTemplateExp;
	}

	protected PropertyTemplateItem createPropertyTemplateItem(ObjectTemplateExp templateExp, EStructuralFeature referredProperty, OCLExpression value) {
		PropertyTemplateItem propertyTemplateItem = QVTt_Factory.createPropertyTemplateItem();
		if (templateExp != null)
			templateExp.getPart().add(propertyTemplateItem);
		if (referredProperty != null)
			propertyTemplateItem.setReferredProperty(referredProperty);
		if (value != null)
			propertyTemplateItem.setValue(value);
		return propertyTemplateItem;
	}
}
