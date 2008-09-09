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
 * $Id: RelationalTransformationOperations.java,v 1.1 2008/09/09 20:59:19 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.operations;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Key;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;

public class RelationalTransformationOperations extends AbstractQVTRelationOperations
{
	public static RelationalTransformationOperations INSTANCE = new RelationalTransformationOperations();

	/**
	 * Validates the KeyClassesAreDistinct constraint of '<em>Relational Transformation</em>'.
	 */
	public boolean checkKeyClassesAreDistinct(RelationalTransformation relationalTransformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean allOk = true;
		for (Key key : relationalTransformation.getOwnedKey()) {
			EClass identifies = key.getIdentifies();
			for (Key anotherKey : relationalTransformation.getOwnedKey()) {
				if ((key != anotherKey) && (identifies == anotherKey.getIdentifies())) {
					allOk = false;
					if (diagnostics != null) {
						diagnostics.add
							(createDiagnostic
								(Diagnostic.WARNING,
								 DIAGNOSTIC_SOURCE,
								 0,
								 "_UI_DuplicateKeyDefinition_diagnostic",
								 new Object[] { getObjectLabel(identifies, context) },
								 new Object[] { key },
								 context));
					}
					break;	
				}
			}
		}
		return allOk;
	}
}