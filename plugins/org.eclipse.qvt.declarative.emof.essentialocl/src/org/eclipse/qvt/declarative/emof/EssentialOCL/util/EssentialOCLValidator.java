/*******************************************************************************
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.emof.EssentialOCL.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.ocl.ecore.TypeType;

/**
 * Workaround for Bugzilla 226368
 */
public class EssentialOCLValidator
{
	private static final class WorkaroundEmfEcoreValidator extends org.eclipse.emf.ecore.util.EcoreValidator
	{
		@Override
		public boolean validateEClassifier_WellFormedInstanceTypeName(EClassifier classifier, DiagnosticChain diagnostics,
				Map<Object, Object> context) {
			if (classifier instanceof TypeType) {	// Workaround 226368
				if (classifier.getInstanceTypeName() == null)
					return true;
			}
			return super.validateEClassifier_WellFormedInstanceTypeName(classifier, diagnostics, context);
		}
	}

	private static final class WorkaroundOclEcoreValidator extends org.eclipse.ocl.ecore.util.EcoreValidator
	{
		public WorkaroundOclEcoreValidator() {
			ecoreValidator = new WorkaroundEmfEcoreValidator();
		}
	}

	/**
	 * Install the workaround OCL EValidator in the EValidator.Registry.INSTANCE if the
     * standard OCL Validator currently installed.
	 */
	public static void install() {
		org.eclipse.ocl.ecore.EcorePackage oclPackage = org.eclipse.ocl.ecore.EcorePackage.eINSTANCE;
		Object oclEcoreValidator = EValidator.Registry.INSTANCE.get(oclPackage);
		if (oclEcoreValidator == org.eclipse.ocl.ecore.util.EcoreValidator.INSTANCE) { // Introduced in M6
			// FIXME Workaround for Bugzilla 226368 Allow null instanceTypeNames
			oclEcoreValidator = new WorkaroundOclEcoreValidator();
			EValidator.Registry.INSTANCE.put(oclPackage, oclEcoreValidator);
		}
	}

	private EssentialOCLValidator() {
		super();
	}
}
