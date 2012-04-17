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
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.util.QVTrelationVisitor;
import org.eclipse.qvtd.pivot.qvttemplate.utilities.QVTtemplateToStringVisitor;

/**
 * Converts an OCL expression to a string for debugging. This is not intended to
 * be used by client applications as an AST-to-text transformation.
 */
public class QVTrelationToStringVisitor extends QVTtemplateToStringVisitor implements QVTrelationVisitor<String, String>
{
	private static final class Factory implements ToStringVisitor.Factory
	{
		private Factory() {
			QVTtemplateToStringVisitor.FACTORY.getClass();
			ToStringVisitor.addFactory(this);
		}

		public ToStringVisitor createToStringVisitor() {
			return new QVTrelationToStringVisitor();
		}

		public EPackage getEPackage() {
			return QVTrelationPackage.eINSTANCE;
		}
	}

	public static ToStringVisitor.Factory FACTORY = new Factory();

	protected QVTrelationToStringVisitor() {}

	public String visitDomainPattern(DomainPattern object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String visitKey(Key object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String visitOppositePropertyCallExp(OppositePropertyCallExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String visitRelation(Relation object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String visitRelationCallExp(RelationCallExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String visitRelationDomain(RelationDomain object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String visitRelationDomainAssignment(RelationDomainAssignment object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String visitRelationImplementation(RelationImplementation object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String visitRelationalTransformation(RelationalTransformation object) {
		// TODO Auto-generated method stub
		return null;
	}
}
