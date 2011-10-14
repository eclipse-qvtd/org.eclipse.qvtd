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
 * $Id: RelationImplementationOperations.java,v 1.2 2009/01/14 21:02:27 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.operations;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.TransformationOperations;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationImplementation;

public class RelationImplementationOperations extends AbstractQVTRelationOperations
{
	public static RelationImplementationOperations INSTANCE = new RelationImplementationOperations();

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
	 * Validates the EveryParameterTypeMatchesDomainRootVariableType constraint of '<em>Relation Implementation</em>'.
	 */
	public boolean checkEveryParameterTypeMatchesDomainRootVariableType(RelationImplementation relationImplementation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		EOperation operation = relationImplementation.getImpl();
		if (operation == null)
			return true;					// Multiplicity failure
		Relation relation = relationImplementation.getRelation();
		if (relation == null)
			return true;					// Multiplicity failure
		List<Domain> domains = relation.getDomain();
		List<EParameter> parameters = operation.getEParameters();
		int domainCount = domains.size();
		int parameterCount = parameters.size();
		if (domainCount != parameterCount) {
			Object[] messageSubstitutions = new Object[] { parameterCount, getObjectLabel(operation, context), domainCount };
			appendError(diagnostics, relationImplementation, QVTRelationMessages._UI_RelationImplementation_ParameterNumberDoesNotMatch, messageSubstitutions);
			return false;
		}
    	boolean allOk = true;
    	for (int i = 0; i < parameterCount; i++) {
    		EClassifier parameterType = parameters.get(i).getEType();
    		if (parameterType == null)
    			continue;
    		RelationDomain domain = (RelationDomain) domains.get(i);
    		Variable rootVariable = domain.getRootVariable();
    		if (rootVariable == null)
    			continue;
			EClassifier domainType = rootVariable.getEType();
    		if (domainType == null)
    			continue;
			TypedModel typedModel = domain.getTypedModel();
    		if (typedModel == null)
    			continue;
    		if (typedModel == relationImplementation.getInDirectionOf()) {
        		if (!assignableFrom(domainType, parameterType)) {
         			Object[] messageSubstitutions = new Object[] { getObjectLabel(domainType, context), getObjectLabel(parameterType, context) };
        			appendError(diagnostics, relationImplementation, QVTRelationMessages._UI_RelationImplementation_OutputParameterTypeDoesNotMatch, messageSubstitutions);
        			allOk = false;
        	    }
    		}
    		else {
        		if (!assignableFrom(parameterType, domainType)) {
         			Object[] messageSubstitutions = new Object[] { getObjectLabel(parameterType, context), getObjectLabel(domainType, context) };
        			appendError(diagnostics, relationImplementation, QVTRelationMessages._UI_RelationImplementation_InputParameterTypeDoesNotMatch, messageSubstitutions);
        			allOk = false;
        	    }
    		}
    	}
    	return allOk;
	}
}