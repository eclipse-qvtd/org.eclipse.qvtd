/*******************************************************************************
 * Copyright (c) 2011, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators= {org.eclipse.xtext.validation.ImportUriValidator.class})
public class AbstractQVTrelationJavaValidator extends org.eclipse.ocl.xtext.essentialocl.validation.EssentialOCLJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/qvt/2015/QVTrelationCS"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/ocl/2015/BaseCS"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/ocl/2015/EssentialOCLCS"));
		return result;
	}

}
