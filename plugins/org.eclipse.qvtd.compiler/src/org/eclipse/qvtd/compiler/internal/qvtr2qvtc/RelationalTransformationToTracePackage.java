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
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Type;
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
	protected final @NonNull QVTrToQVTc qvtr2qvtc;

	public RelationalTransformationToTracePackage(@NonNull QVTrToQVTc qvtr2qvtc) {
		this.qvtr2qvtc = qvtr2qvtc;
	}

	public org.eclipse.ocl.pivot.@NonNull Package doRelationalTransformationToTracePackage(@NonNull RelationalTransformation rt) {
		org.eclipse.ocl.pivot.Package p = PivotFactory.eINSTANCE.createPackage();
		p.setName("P" + rt.getName());
		p.setNsPrefix("P" + rt.getName());
//		p.setURI(p.getName());
		qvtr2qvtc.putTracePackage(rt, p);
		List<org.eclipse.ocl.pivot.@NonNull Class> ownedClasses = ClassUtil.nullFree(p.getOwnedClasses());
		for (@NonNull Rule r : ClassUtil.nullFree(rt.getRule())) {
			if (r instanceof Relation) {
				ownedClasses.add(doRelationToTraceClass((Relation)r));
			}
		}
		CompilerUtil.normalizeNameables(ownedClasses);
		return p;
	}

	private org.eclipse.ocl.pivot.@NonNull Class doRelationToTraceClass(@NonNull Relation rRelation) {	
		@SuppressWarnings("null")org.eclipse.ocl.pivot.@NonNull Class traceClass = PivotFactory.eINSTANCE.createClass();
		qvtr2qvtc.putRelationTrace(rRelation, traceClass);
		traceClass.setName("T" + rRelation.getName());
		for (@NonNull Variable rVariable : qvtr2qvtc.getMiddleDomainVariables(rRelation))  {
			createTraceProperty(traceClass, rVariable);
		}
		for (@NonNull Domain rDomain : ClassUtil.nullFree(rRelation.getDomain())) {
			for (@NonNull DomainPattern rDomainPattern : ClassUtil.nullFree(((RelationDomain)rDomain).getPattern())) {
				TemplateExp rTemplateExp = ClassUtil.nonNullState(rDomainPattern.getTemplateExpression());
				doSubTemplateToTraceClassProps(rTemplateExp, traceClass);
			}
		}
		CompilerUtil.normalizeNameables(ClassUtil.nullFree(traceClass.getOwnedProperties()));
		return traceClass;
	}

	private void doSubTemplateToTraceClassProps(@NonNull TemplateExp te, org.eclipse.ocl.pivot.@NonNull Class rc) {
		Variable tv = ClassUtil.nonNullState(te.getBindsTo());
		if (te instanceof CollectionTemplateExp) {
			createTraceProperty(rc, tv);			// ?? not required for CollectionTemplateExp's
			CollectionTemplateExp cte = (CollectionTemplateExp) te;
			Variable collectionVariable = cte.getBindsTo();
			CollectionType collectionType = (CollectionType)collectionVariable.getType();
			Type elementType = ClassUtil.nonNullState(collectionType.getElementType());
			int argIndex = 0;
			for (@NonNull OCLExpression m : ClassUtil.nullFree(cte.getMember())) {
				if (m instanceof TemplateExp) {
					doSubTemplateToTraceClassProps((TemplateExp)m, rc);
				}
				else {
					createTraceProperty(rc, collectionVariable.getName() + "_" + argIndex, elementType, collectionType.isIsNullFree());
				}
				argIndex++;
			}
			Variable rv = cte.getRest();
			if (rv != null) {
				createTraceProperty(rc, rv);
			}
		}
		else if (te instanceof ObjectTemplateExp) {
			createTraceProperty(rc, tv);			// ?? not required for CollectionTemplateExp's
			ObjectTemplateExp ote = (ObjectTemplateExp) te;
			for (@NonNull PropertyTemplateItem pt : ClassUtil.nullFree(ote.getPart())) {
				OCLExpression value = ClassUtil.nonNullState(pt.getValue());
				if (value instanceof TemplateExp) {
					doSubTemplateToTraceClassProps((TemplateExp)value, rc);
				}
			}
		}
	}

	private void createTraceProperty(org.eclipse.ocl.pivot.@NonNull Class rc, @NonNull Variable tv) {
		String vn = ClassUtil.nonNullState(tv.getName());
		Type c = ClassUtil.nonNullState(tv.getType());
		qvtr2qvtc.whenTraceProperty(rc, vn, c, tv.isIsRequired());
	}

	private void createTraceProperty(org.eclipse.ocl.pivot.@NonNull Class rc, @NonNull String name, @NonNull Type type, boolean isRequired) {
		qvtr2qvtc.whenTraceProperty(rc, name, type, isRequired);
	}
}
