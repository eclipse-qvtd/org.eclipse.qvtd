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
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTr2QVTcRelations;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

public class RelationalTransformationToTracePackage extends AbstractRule
{
	// Relation
	private final @NonNull RelationalTransformation rt;	

	// Core
	private org.eclipse.ocl.pivot.Package p;
	
	// Primitives
	private String rtn;
	
	// Mapping
	private final @NonNull Map<@NonNull Relation, org.eclipse.ocl.pivot.@NonNull Class> relation2class = new HashMap<@NonNull Relation, org.eclipse.ocl.pivot.@NonNull Class>();

	public RelationalTransformationToTracePackage(@NonNull QvtrToQvtcTransformation transformation, @NonNull RelationalTransformation rt) {
		super(transformation);
		this.rt = rt;
	}

	@Override
	public void check() {
		rtn = rt.getName();
		for (org.eclipse.qvtd.pivot.qvtbase.Rule r : ClassUtil.nullFree(rt.getRule())) {
			if (r instanceof Relation) {
				org.eclipse.ocl.pivot.Class rc = PivotFactory.eINSTANCE.createClass();
				assert rc != null;
				relation2class.put((Relation)r, rc);
			}
		}
	}
	
	public org.eclipse.ocl.pivot.@Nullable Package getCore() {
		return p;
	}

	@Override
	public void instantiateOutput() {
		p = PivotFactory.eINSTANCE.createPackage();
		assert p != null;
		transformation.addOrphan(p);
		transformation.putTransformationToPackageTrace(rt, p);
		for (Relation r : relation2class.keySet()) {
			org.eclipse.ocl.pivot.Class rc = relation2class.get(r);
			p.getOwnedClasses().add(rc);
		}
	}

	@Override
	public void setAttributes() {	
		p.setName("P" + rtn);
		p.setURI(p.getName());
	}
	
	@Override
	public void where() {
		QVTr2QVTcRelations relations = new QVTr2QVTcRelations(transformation);
		for (Relation r : relation2class.keySet()) {
			org.eclipse.ocl.pivot.Class rc = relation2class.get(r);
			assert rc != null;
			relations.doRelationToTraceClass(r, rc);
		}
	}
}
