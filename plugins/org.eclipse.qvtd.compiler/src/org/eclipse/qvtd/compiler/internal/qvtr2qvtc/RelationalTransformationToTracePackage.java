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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
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

	private void createTraceProperty(org.eclipse.ocl.pivot.@NonNull Class rc, @NonNull Variable tv) {
		String vn = tv.getName();
		Type c = tv.getType();
		assert (vn != null) && (c != null);
		qvtr2qvtc.whenTraceProperty(rc, vn, c);
	}

	public org.eclipse.ocl.pivot.@NonNull Package doRelationalTransformationToTracePackage(@NonNull RelationalTransformation rt) {
		org.eclipse.ocl.pivot.Package p = PivotFactory.eINSTANCE.createPackage();
		p.setName("P" + rt.getName());
		p.setURI(p.getName());
		qvtr2qvtc.putTracePackage(rt, p);
		for (@NonNull Rule r : ClassUtil.nullFree(rt.getRule())) {
			if (r instanceof Relation) {
				org.eclipse.ocl.pivot.Class rc = PivotFactory.eINSTANCE.createClass();
				p.getOwnedClasses().add(rc);
				doRelationToTraceClass((Relation)r, rc);
			}
		}
		return p;
	}

	private void doRelationToTraceClass(@NonNull Relation r, org.eclipse.ocl.pivot.@NonNull Class rc) {	
		qvtr2qvtc.putRelationTrace(r, rc);
		String rn = r.getName();
		assert rn != null;
		rc.setName("T"+rn);
		for (@NonNull Variable rv : qvtr2qvtc.getSharedDomainVars(r))  {
			createTraceProperty(rc, rv);
		}
		for (@NonNull Domain d : ClassUtil.nullFree(r.getDomain())) {
			for (@NonNull DomainPattern rdp : ClassUtil.nullFree(((RelationDomain) d).getPattern())) {
				TemplateExp t = rdp.getTemplateExpression();
				assert t != null;
				doSubTemplateToTraceClassProps(t, rc);
			}
		}
	}

	private void doSubTemplateToTraceClassProps(@NonNull TemplateExp t, org.eclipse.ocl.pivot.@NonNull Class rc) {
		if (t instanceof CollectionTemplateExp) {
			doCollectionTemplateToTraceClassProps((CollectionTemplateExp) t, rc);
		}
		if (t instanceof ObjectTemplateExp) {
			doObjectTemplateToTraceClassProps((ObjectTemplateExp) t, rc);
		}
	}

	private void doCollectionTemplateToTraceClassProps(@NonNull CollectionTemplateExp t, org.eclipse.ocl.pivot.@NonNull Class rc) {	
		for (@NonNull OCLExpression m : ClassUtil.nullFree(t.getMember())) {
			if (m instanceof TemplateExp) {
				// Don't add trace attributes for collections, just for the members
				doSubTemplateToTraceClassProps((TemplateExp) m, rc);
			}
		}
		Variable rv = t.getRest();
		if (rv != null) {
			createTraceProperty(rc, rv);
		}
	}

	private void doObjectTemplateToTraceClassProps(@NonNull ObjectTemplateExp t, org.eclipse.ocl.pivot.@NonNull Class rc) {	
		Variable tv = t.getBindsTo();
		assert tv != null;
		createTraceProperty(rc, tv);
		for (@NonNull PropertyTemplateItem pt : ClassUtil.nullFree(t.getPart())) {
			OCLExpression value = pt.getValue();
			assert value != null;
			if (value instanceof TemplateExp) {
				doSubTemplateToTraceClassProps((TemplateExp) value, rc);
			}
		}
	}
}
