/*******************************************************************************
 * Copyright (c) 2014, 2015 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/*public*/ class RelationalTransformationToTracePackage
{
	protected final @NonNull QVTr2QVTc qvtr2qvtc;

	public RelationalTransformationToTracePackage(@NonNull QVTr2QVTc qvtr2qvtc) {
		this.qvtr2qvtc = qvtr2qvtc;
	}

	public org.eclipse.ocl.pivot.@NonNull Package doRelationalTransformationToTracePackage(@NonNull RelationalTransformation rTransformation) {
		org.eclipse.ocl.pivot.Package p = PivotFactory.eINSTANCE.createPackage();
		p.setName("P" + rTransformation.getName());
		p.setNsPrefix("P" + rTransformation.getName());
//		p.setURI(p.getName());
		qvtr2qvtc.putTracePackage(rTransformation, p);
		List<org.eclipse.ocl.pivot.@NonNull Class> ownedClasses = ClassUtil.nullFree(p.getOwnedClasses());
		for (@NonNull Rule rRule : ClassUtil.nullFree(rTransformation.getRule())) {
			if (rRule instanceof Relation) {
				ownedClasses.add(doRelationToTraceClass((Relation)rRule));
			}
		}
		CompilerUtil.normalizeNameables(ownedClasses);
		return p;
	}

	private org.eclipse.ocl.pivot.@NonNull Class doRelationToTraceClass(@NonNull Relation rRelation) {	
		@SuppressWarnings("null")org.eclipse.ocl.pivot.@NonNull Class traceClass = PivotFactory.eINSTANCE.createClass();
		qvtr2qvtc.putRelationTrace(rRelation, traceClass);
		traceClass.setName("T" + rRelation.getName());
		for (@NonNull Variable rVariable : VariablesAnalysis.getMiddleDomainVariables(rRelation))  {
			createTraceProperty(null, traceClass, rVariable, false);
		}
		for (@NonNull Domain rDomain : ClassUtil.nullFree(rRelation.getDomain())) {
			for (@NonNull DomainPattern rDomainPattern : ClassUtil.nullFree(((RelationDomain)rDomain).getPattern())) {
				TemplateExp rTemplateExp = ClassUtil.nonNullState(rDomainPattern.getTemplateExpression());
				doSubTemplateToTraceClassProps(rDomain, rTemplateExp, traceClass);
			}
		}
		CompilerUtil.normalizeNameables(ClassUtil.nullFree(traceClass.getOwnedProperties()));
		return traceClass;
	}

	/**
	 * Returns true if there are many subtemplate matches. 
	 */
	private boolean doSubTemplateToTraceClassProps(@NonNull Domain rDomain, @NonNull TemplateExp te, org.eclipse.ocl.pivot.@NonNull Class rc) {
		boolean isMany = false;
		Variable tv = ClassUtil.nonNullState(te.getBindsTo());
		if (te instanceof CollectionTemplateExp) {
			CollectionTemplateExp cte = (CollectionTemplateExp) te;
			Variable collectionVariable = cte.getBindsTo();
			CollectionType collectionType = (CollectionType)collectionVariable.getType();
			Type elementType = ClassUtil.nonNullState(collectionType.getElementType());
			int argIndex = 0;
			for (@NonNull OCLExpression m : ClassUtil.nullFree(cte.getMember())) {
				if (m instanceof TemplateExp) {
					if (doSubTemplateToTraceClassProps(rDomain, (TemplateExp)m, rc)) {
						isMany = true;
					}
				}
				else {
					createTraceProperty(rDomain, rc, collectionVariable.getName() + "_" + argIndex, elementType, collectionType.isIsNullFree());
				}
				argIndex++;
			}
			Variable rv = cte.getRest();
			if (rv != null) {
				createTraceProperty(rDomain, rc, rv, isMany);
			}
			createTraceProperty(rDomain, rc, tv, isMany);			// ?? not required for CollectionTemplateExp's
		}
		else if (te instanceof ObjectTemplateExp) {
			ObjectTemplateExp ote = (ObjectTemplateExp) te;
			for (@NonNull PropertyTemplateItem pt : ClassUtil.nullFree(ote.getPart())) {
				if (pt.getReferredProperty().isIsMany()) {
					isMany = true;
				}
				OCLExpression value = ClassUtil.nonNullState(pt.getValue());
				if (value instanceof TemplateExp) {
					if (doSubTemplateToTraceClassProps(rDomain, (TemplateExp)value, rc)) {
						isMany = true;
					}
				}
			}
			createTraceProperty(rDomain, rc, tv, isMany);			// ?? not required for CollectionTemplateExp's
		}
		return isMany;
	}

	private void createTraceProperty(@Nullable Domain rDomain, org.eclipse.ocl.pivot.@NonNull Class rc, @NonNull TypedElement tv, boolean isMany) {
		String vn = ClassUtil.nonNullState(tv.getName());
		Type c = ClassUtil.nonNullState(tv.getType());
		qvtr2qvtc.whenTraceProperty(rDomain, rc, vn, c, tv.isIsRequired(), isMany);
	}

	private void createTraceProperty(@Nullable Domain rDomain, org.eclipse.ocl.pivot.@NonNull Class rc, @NonNull String name, @NonNull Type type, boolean isRequired) {
		qvtr2qvtc.whenTraceProperty(rDomain, rc, name, type, isRequired, false);
	}
}
