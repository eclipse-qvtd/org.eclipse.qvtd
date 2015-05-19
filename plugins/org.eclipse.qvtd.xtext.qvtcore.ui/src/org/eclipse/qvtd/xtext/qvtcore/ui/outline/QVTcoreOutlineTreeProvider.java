/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcore.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.qvtd.xtext.qvtcorebase.ui.outline.QVTcoreBaseOutlineTreeProvider;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtcorecs.TopLevelCS;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;

/**
 * customization of the default outline structure
 * 
 */
public class QVTcoreOutlineTreeProvider extends QVTcoreBaseOutlineTreeProvider
{
	protected void _createChildren(IOutlineNode parentNode, TopLevelCS ele) {
		for (ImportCS csImport : ele.getOwnedImports()) {
			createNode(parentNode, csImport);
		}
		for (PackageCS csPackage : ele.getOwnedPackages()) {
			createNode(parentNode, csPackage);
		}
		for (TransformationCS csTransformation : ele.getOwnedTransformations()) {
			createNode(parentNode, csTransformation);
		}
		for (QueryCS csQuery : ele.getOwnedQueries()) {
			createNode(parentNode, csQuery);
		}
		for (MappingCS csMapping : ele.getOwnedMappings()) {
			createNode(parentNode, csMapping);
		}
	}

	protected void _createNode(IOutlineNode parentNode, TopLevelCS ele) {
		_createNode(parentNode, (EObject)ele);
	}
}
