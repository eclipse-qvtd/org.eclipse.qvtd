/*******************************************************************************
 * Copyright (c) 2012, 2014 E.D. Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseToStringVisitor;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.util.QVTrelationVisitor;
import org.eclipse.qvtd.pivot.qvttemplate.utilities.QVTtemplateToStringVisitor;

/**
 * Converts an OCL expression to a string for debugging. This is not intended to
 * be used by client applications as an AST-to-text transformation.
 */
public class QVTrelationToStringVisitor extends QVTtemplateToStringVisitor implements QVTrelationVisitor<String>
{
	protected static class QVTrelationToStringFactory implements QVTtemplateToStringVisitor.Factory
	{
		protected QVTrelationToStringFactory() {
			ToStringVisitor.addFactory(this);
			QVTbaseToStringVisitor.FACTORY.getClass();
		}

		@Override
		public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
			return new QVTrelationToStringVisitor(s);
		}

		@Override
		public @NonNull EPackage getEPackage() {
			QVTrelationPackage eInstance = QVTrelationPackage.eINSTANCE;
			assert eInstance != null;
			return eInstance;
		}
	}

	public static ToStringVisitor.@NonNull Factory FACTORY = new QVTrelationToStringFactory();

	public QVTrelationToStringVisitor(@NonNull StringBuilder s) {
		super(s);
	}

	@Override
	public String visitDomainPattern(@NonNull DomainPattern object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitKey(@NonNull Key object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitRelation(@NonNull Relation object) {
		append("Relation " + object.getName());
		return null;
	}

	@Override
	public String visitRelationCallExp(@NonNull RelationCallExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitRelationDomain(@NonNull RelationDomain object) {
		append("RelationDomain " + object.getName());
		return null;
	}

	@Override
	public String visitRelationDomainAssignment(@NonNull RelationDomainAssignment object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitRelationImplementation(@NonNull RelationImplementation object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitRelationModel(@NonNull RelationModel object) {
		append("RelationModel " + object.getName());
		return null;
	}

	@Override
	public String visitRelationalTransformation(@NonNull RelationalTransformation object) {
		append("RelationalTransformation " + object.getName());
		return null;
	}
}
