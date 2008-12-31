/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: RelationImplementationOperations.java,v 1.1 2008/12/31 17:43:38 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.TransformationOperations;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationImplementation;

public class RelationImplementationOperations extends AbstractQVTRelationOperations
{
	public static RelationImplementationOperations INSTANCE = new RelationImplementationOperations();

	/**
	 * Validates the RootNodeIsBoundToRootVariable constraint of '<em>Relation Implementation</em>'.
	 */
	public boolean checkRootNodeIsBoundToRootVariable(RelationImplementation relationImplementation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		return true;
	}

	/**
	 * Validates the InDirectionOfIsDefinedByTransformation constraint of '<em>Relation Implementation</em>'.
	 */
	public boolean checkInDirectionOfIsDefinedByTransformation(RelationImplementation relationImplementation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Transformation transformation = relationImplementation.getRelation().getTransformation();
		TypedModel typedModel = relationImplementation.getInDirectionOf();
		if (typedModel == null)
			return true;	// TypedModelExistsWarning
		if (TransformationOperations.INSTANCE.definesModel(transformation, typedModel))
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(typedModel, context), getObjectLabel(relationImplementation, context), getObjectLabel(transformation, context) };
		appendError(diagnostics, relationImplementation, QVTRelationMessages._UI_RelationImplementation_DirectionIsNotDefinedByTransformation, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the EveryArgumentTypeMatchesDomainRootVariableType constraint of '<em>Relation Implementation</em>'.
	 */
	public boolean checkEveryArgumentTypeMatchesDomainRootVariableType(RelationImplementation relationImplementation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		return true;
	}
}