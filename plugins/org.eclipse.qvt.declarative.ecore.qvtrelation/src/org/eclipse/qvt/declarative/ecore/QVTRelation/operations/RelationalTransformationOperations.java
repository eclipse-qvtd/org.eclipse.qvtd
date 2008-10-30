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
 * $Id: RelationalTransformationOperations.java,v 1.2 2008/10/30 06:32:03 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Key;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;

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

	/**
	 * Validates the UniqueClassifierNames constraint of '<em>Relational Transformation</em>'.
	 * <br>
	 * This reimplementation of EcoreValidator.validateEPackage_UniqueClassifierNames relaxes the
	 * diagnostic on colliding collection names to a warning, since this is just a gratuitous
	 * OCL 2.0 pedantry.
	 */
	public boolean checkUniqueClassifierNames(RelationalTransformation relationalTransformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		List<String> names = new ArrayList<String>();
		EList<EClassifier> eClassifiers = relationalTransformation.getEClassifiers();
		for (EClassifier eClassifier : eClassifiers)
		{
			String name = eClassifier.getName();
			if (name != null)
			{
				String key = name.replace("_", "").toUpperCase();
				int index = names.indexOf(key);
				if (index != -1)
				{
					if (diagnostics == null)
					{
						return false;
					}
					else
					{
						result = false;
						Diagnostic diagnostic = null;
						EClassifier otherEClassifier = eClassifiers.get(index);
						String otherName = otherEClassifier.getName();
						if (!name.equals(otherName)) {
							diagnostic = createDiagnostic(Diagnostic.WARNING, EcoreValidator.DIAGNOSTIC_SOURCE,
									EcoreValidator.UNIQUE_CLASSIFIER_NAMES, "_UI_EPackageDissimilarClassifierNames_diagnostic",
									new Object[] { name, otherName },
									new Object[] { eClassifier, otherEClassifier },
									context);
						}
						else if ((eClassifier instanceof CollectionType)
							 && (otherEClassifier instanceof CollectionType)
							 && (((CollectionType<?,?>)eClassifier).getElementType() != ((CollectionType<?,?>)otherEClassifier).getElementType())) {
							diagnostic = createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE,
									EcoreValidator.UNIQUE_CLASSIFIER_NAMES, "_UI_CollectionNameCollision_diagnostic",
									new Object[] { ((CollectionType<?,?>)eClassifier).getKind(),
												   EcoreUtils.formatQualifiedName(((CollectionType<?,?>)eClassifier).getElementType()),
												   ((CollectionType<?,?>)otherEClassifier).getKind(),
												   EcoreUtils.formatQualifiedName(((CollectionType<?,?>)otherEClassifier).getElementType()) },
									new Object[] { eClassifier, otherEClassifier },
									context);
							}
						 else {
							diagnostic = createDiagnostic(Diagnostic.ERROR, EcoreValidator.DIAGNOSTIC_SOURCE,
									EcoreValidator.UNIQUE_CLASSIFIER_NAMES, "_UI_EPackageUniqueClassifierNames_diagnostic",
									new Object[] { name },
									new Object[] { eClassifier, otherEClassifier },
									context);
						}
						if (diagnostic != null)
							diagnostics.add(diagnostic);
					}
				}
				names.add(key);
			}
			else
			{
				names.add(null);
			}
		}
		return result;
	}
}