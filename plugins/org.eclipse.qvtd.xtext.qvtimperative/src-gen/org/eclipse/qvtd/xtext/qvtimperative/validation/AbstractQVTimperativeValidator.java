/*******************************************************************************
 * Copyright (c) 2011, 2024 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.qvtd.xtext.qvtbase.validation.QVTbaseValidator;

public abstract class AbstractQVTimperativeValidator extends QVTbaseValidator {

	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>(super.getEPackages());
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/qvt/2016/QVTimperativeCS"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/ocl/2015/BaseCS"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/ocl/2015/EssentialOCLCS"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/ocl/2016/QVTbaseCS"));
		return result;
	}
}
