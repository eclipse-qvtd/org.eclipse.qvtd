/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.ui.labeling;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.xtext.qvtbase.ui.labeling.QVTbaseLabelProvider;
import org.eclipse.qvtd.xtext.qvtrelationcs.TopLevelCS;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class QVTrelationLabelProvider extends QVTbaseLabelProvider {

	@Inject
	public QVTrelationLabelProvider(@NonNull AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	protected String image(CollectionTemplateExp ele) {
		return "CollectionTemplateExp.gif";
	}

	protected String image(DomainPattern ele) {
		return "DomainPattern.gif";
	}

	protected String image(Key ele) {
		return "Key.gif";
	}

	protected String image(ObjectTemplateExp ele) {
		return "ObjectTemplateExp.gif";
	}

//	protected String image(OppositePropertyCallExp ele) {
//		return "OppositePropertyCallExp.gif";
//	}

	protected String image(PropertyTemplateItem ele) {
		return "PropertyTemplateItem.gif";
	}

	protected String image(Relation ele) {
		return "Relation.gif";
	}

	protected String image(RelationCallExp ele) {
		return "RelationCallExp.gif";
	}

	protected String image(RelationDomain ele) {
		return "RelationDomain.gif";
	}

	protected String image(RelationDomainAssignment ele) {
		return "RelationDomainAssignment.gif";
	}

	protected String image(RelationImplementation ele) {
		return "RelationImplementation.gif";
	}

	protected String image(RelationalTransformation ele) {
		return "RelationalTransformation.gif";
	}

	protected String image(TopLevelCS ele) {
		return "QVTrModelFile.gif";
	}

	protected String text(Key ele) {
		StringBuilder s = new StringBuilder();
		appendName(s, ele.getIdentifies());
		s.append("{");
		String prefix = "";
		for (NamedElement usedPackage : ele.getPart()) {
			s.append(prefix);
			appendName(s, usedPackage);
			prefix = ",";
		}
		s.append("}");
		return s.toString();
	}

	protected String text(Pattern ele) {
		EStructuralFeature eContainingFeature = ele.eContainingFeature();
		if (eContainingFeature == QVTrelationPackage.Literals.RELATION__WHEN) {
			return "«when»";
		}
		else if (eContainingFeature == QVTrelationPackage.Literals.RELATION__WHERE) {
			return "«where»";
		}
		else {
			return "«pattern»";
		}
	}

	protected String text(PropertyTemplateItem ele) {
		return NameUtil.getSafeName(ele.getReferredProperty()) + " =";
	}

	protected String text(Relation ele) {
		StringBuilder s = new StringBuilder();
		if (ele.isIsTopLevel()) {
			s.append("«top» ");
		}
		appendName(s, ele);
		return s.toString();
	}

	protected String text(RelationDomain ele) {
		StringBuilder s = new StringBuilder();
		if (ele.isIsCheckable()) {
			s.append("«checkable» ");
		}
		if (ele.isIsEnforceable()) {
			s.append("«enforceable» ");
		}
		appendName(s, ele);
		return s.toString();
	}

	protected String text(RelationCallExp ele) {
		assert ele != null;
		StringBuilder s = new StringBuilder();
		Relation referredRelation = ele.getReferredRelation();
		if (referredRelation != null) {
			appendName(s, referredRelation);
			s.append("(");
			String prefix = "";
			for (Domain csDomain : referredRelation.getDomain()) {
				s.append(prefix);
				appendName(s, csDomain);
				prefix = ", ";
			}
			s.append(")");
		}
		else {
			s.append("<<null>>");
		}
		return s.toString();
	}

	@Override
	protected String text(Variable ele) {
		assert ele != null;
		if (ele.getName() == null) {
			StringBuilder s = new StringBuilder();
			s.append("_ : ");
			Type type = ele.getType();
			if (type != null) {
				s.append(PrettyPrinter.printType(type));
			}
			return s.toString();
		}
		else {
			return super.text(ele);
		}
	}
}
