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
		p.setURI(p.getName());
		qvtr2qvtc.putTracePackage(rt, p);
		List<org.eclipse.ocl.pivot.@NonNull Class> ownedClasses = ClassUtil.nullFree(p.getOwnedClasses());
		for (@NonNull Rule r : ClassUtil.nullFree(rt.getRule())) {
			if (r instanceof Relation) {
				org.eclipse.ocl.pivot.Class rc = PivotFactory.eINSTANCE.createClass();
				ownedClasses.add(rc);
				doRelationToTraceClass((Relation)r, rc);
				CompilerUtil.normalizeNameables(ClassUtil.nullFree(rc.getOwnedProperties()));
			}
		}
		CompilerUtil.normalizeNameables(ownedClasses);
		return p;
	}

	private void doRelationToTraceClass(@NonNull Relation r, org.eclipse.ocl.pivot.@NonNull Class rc) {	
		qvtr2qvtc.putRelationTrace(r, rc);
		String rn = ClassUtil.nonNullState(r.getName());
		rc.setName("T"+rn);
		for (@NonNull Variable rv : qvtr2qvtc.getSharedDomainVars(r))  {
			createTraceProperty(rc, rv);
		}
		for (@NonNull Domain d : ClassUtil.nullFree(r.getDomain())) {
			for (@NonNull DomainPattern rdp : ClassUtil.nullFree(((RelationDomain) d).getPattern())) {
				TemplateExp t = ClassUtil.nonNullState(rdp.getTemplateExpression());
				doSubTemplateToTraceClassProps(t, rc);
			}
		}
	}

	private void doSubTemplateToTraceClassProps(@NonNull OCLExpression t, org.eclipse.ocl.pivot.@NonNull Class rc) {
		if (t instanceof TemplateExp) {
			TemplateExp te = (TemplateExp) t;
			Variable tv = ClassUtil.nonNullState(te.getBindsTo());
			createTraceProperty(rc, tv);			// ?? not required for CollectionTemplateExp's
			if (te instanceof CollectionTemplateExp) {
				CollectionTemplateExp cte = (CollectionTemplateExp) t;
				for (@NonNull OCLExpression m : ClassUtil.nullFree(cte.getMember())) {
					doSubTemplateToTraceClassProps(m, rc);
				}
				Variable rv = cte.getRest();
				if (rv != null) {
					createTraceProperty(rc, rv);
				}
			}
			else if (te instanceof ObjectTemplateExp) {
				ObjectTemplateExp ote = (ObjectTemplateExp) te;
				for (@NonNull PropertyTemplateItem pt : ClassUtil.nullFree(ote.getPart())) {
					OCLExpression value = ClassUtil.nonNullState(pt.getValue());
					doSubTemplateToTraceClassProps(value, rc);
				}
			}
		}
	}

	private void createTraceProperty(org.eclipse.ocl.pivot.@NonNull Class rc, @NonNull Variable tv) {
		String vn = ClassUtil.nonNullState(tv.getName());
		Type c = ClassUtil.nonNullState(tv.getType());
		qvtr2qvtc.whenTraceProperty(rc, vn, c);
	}
}
