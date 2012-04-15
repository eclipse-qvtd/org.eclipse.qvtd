/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: /org.eclipse.qvtd.pivot.qvtrelation/model/QVTrelation.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.pivot.qvtrelation.util;

/**
 * An AbstractNullQVTrelationVisitor provides a default implementation for each
 * visitXxx method that returns null.
 */
public abstract class AbstractNullQVTrelationVisitor<R, C>
	extends org.eclipse.qvtd.pivot.qvttemplate.util.AbstractNullQVTtemplateVisitor<R, C> implements QVTrelationVisitor<R, C>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullQVTrelationVisitor(C context) {
	    super(context);
	}	

	public R visitDomainPattern(org.eclipse.qvtd.pivot.qvtrelation.DomainPattern object) {
		return null;
	}

	public R visitKey(org.eclipse.qvtd.pivot.qvtrelation.Key object) {
		return null;
	}

	public R visitOppositePropertyCallExp(org.eclipse.qvtd.pivot.qvtrelation.OppositePropertyCallExp object) {
		return null;
	}

	public R visitRelation(org.eclipse.qvtd.pivot.qvtrelation.Relation object) {
		return null;
	}

	public R visitRelationCallExp(org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp object) {
		return null;
	}

	public R visitRelationDomain(org.eclipse.qvtd.pivot.qvtrelation.RelationDomain object) {
		return null;
	}

	public R visitRelationDomainAssignment(org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment object) {
		return null;
	}

	public R visitRelationImplementation(org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation object) {
		return null;
	}

	public R visitRelationalTransformation(org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation object) {
		return null;
	}
}
