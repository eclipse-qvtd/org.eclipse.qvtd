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
 */
public interface QVTrelationVisitor<R> extends org.eclipse.qvtd.pivot.qvttemplate.util.QVTtemplateVisitor<R>
{
	R visitDomainPattern(org.eclipse.qvtd.pivot.qvtrelation.DomainPattern object);
	R visitKey(org.eclipse.qvtd.pivot.qvtrelation.Key object);
	R visitOppositePropertyCallExp(org.eclipse.qvtd.pivot.qvtrelation.OppositePropertyCallExp object);
	R visitRelation(org.eclipse.qvtd.pivot.qvtrelation.Relation object);
	R visitRelationCallExp(org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp object);
	R visitRelationDomain(org.eclipse.qvtd.pivot.qvtrelation.RelationDomain object);
	R visitRelationDomainAssignment(org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment object);
	R visitRelationImplementation(org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation object);
	R visitRelationModel(org.eclipse.qvtd.pivot.qvtrelation.RelationModel object);
	R visitRelationalTransformation(org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation object);
}
