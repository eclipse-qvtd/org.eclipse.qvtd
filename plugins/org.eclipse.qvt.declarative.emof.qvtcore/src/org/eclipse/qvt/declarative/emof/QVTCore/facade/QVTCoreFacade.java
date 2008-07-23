/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.emof.QVTCore.facade;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.emof.QVTCore.QVTCorePackage;
import org.eclipse.qvt.declarative.emof.QVTCore.util.QVTCoreMappingMetaData;

/**
 * QVTCoreFacade provides definitions in a distinct package that can be
 * imported avoiding the exposure of all EMOF-based definitions as would
 * be the case for import of the entire bundle.
 */
public interface QVTCoreFacade
{
	String CONTENT_TYPE = QVTCorePackage.eCONTENT_TYPE;
	EPackage PACKAGE = QVTCorePackage.eINSTANCE;
	IMappingMetaData MAPPING_META_DATA = QVTCoreMappingMetaData.INSTANCE;
}
