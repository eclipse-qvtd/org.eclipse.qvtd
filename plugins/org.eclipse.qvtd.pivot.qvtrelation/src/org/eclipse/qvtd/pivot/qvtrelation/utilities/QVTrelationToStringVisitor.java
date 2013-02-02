/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D. Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtrelation.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.OppositePropertyCallExp;
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
	private static final class Factory implements ToStringVisitor.Factory
	{
		private Factory() {
			QVTtemplateToStringVisitor.FACTORY.getClass();
			ToStringVisitor.addFactory(this);
		}

		public @NonNull ToStringVisitor createToStringVisitor() {
			return new QVTrelationToStringVisitor();
		}

		@SuppressWarnings("null")
		public @NonNull EPackage getEPackage() {
			return QVTrelationPackage.eINSTANCE;
		}
	}

	public static @NonNull ToStringVisitor.Factory FACTORY = new Factory();

	protected QVTrelationToStringVisitor() {}

	public String visitDomainPattern(@NonNull DomainPattern object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String visitKey(@NonNull Key object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String visitRelation(@NonNull Relation object) {
		return "Relation " + object.getName();
	}

	public String visitRelationCallExp(@NonNull RelationCallExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String visitRelationDomain(@NonNull RelationDomain object) {
		return "RelationDomain " + object.getName();
	}

	public String visitRelationDomainAssignment(@NonNull RelationDomainAssignment object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String visitRelationImplementation(@NonNull RelationImplementation object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String visitRelationModel(@NonNull RelationModel object) {
		return "RelationModel " + object.getName();
	}

	public String visitRelationalTransformation(@NonNull RelationalTransformation object) {
		return "RelationalTransformation " + object.getName();
	}
}
