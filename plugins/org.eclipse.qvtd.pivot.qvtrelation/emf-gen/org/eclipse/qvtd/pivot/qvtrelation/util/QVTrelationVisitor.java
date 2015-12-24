/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.pivot.qvtrelation/model/QVTrelation.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtrelation.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 */
public interface QVTrelationVisitor<R> extends org.eclipse.qvtd.pivot.qvttemplate.util.QVTtemplateVisitor<R>
{
	R visitDomainPattern(org.eclipse.qvtd.pivot.qvtrelation.@NonNull DomainPattern object);
	R visitKey(org.eclipse.qvtd.pivot.qvtrelation.@NonNull Key object);
	R visitRelation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull Relation object);
	R visitRelationCallExp(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationCallExp object);
	R visitRelationDomain(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationDomain object);
	R visitRelationDomainAssignment(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationDomainAssignment object);
	R visitRelationImplementation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationImplementation object);
	R visitRelationModel(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationModel object);
	R visitRelationalTransformation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationalTransformation object);
}
