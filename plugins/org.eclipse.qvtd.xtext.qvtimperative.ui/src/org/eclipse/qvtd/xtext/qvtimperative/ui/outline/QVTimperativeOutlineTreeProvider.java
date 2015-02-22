/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.LibraryCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.xtext.qvtcorebase.ui.outline.QVTcoreBaseOutlineTreeProvider;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;

/**
 * Customization of the default outline structure.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#outline
 */
public class QVTimperativeOutlineTreeProvider extends QVTcoreBaseOutlineTreeProvider
{
	protected void _createChildren(IOutlineNode parentNode, MappingLoop ele) {
		if (ele.getOwnedSource() != null) {
			createNode(parentNode, ele.getOwnedSource());
		}
		for (Variable asIterator : ele.getOwnedIterators()) {
			createNode(parentNode, asIterator);
		}
		if (ele.getOwnedBody() != null) {
			createNode(parentNode, ele.getOwnedBody());
		}
	}

	protected void _createChildren(IOutlineNode parentNode, TopLevelCS ele) {
		for (ImportCS csImport : ele.getOwnedImports()) {
			createNode(parentNode, csImport);
		}
		for (LibraryCS csLibrary : ele.getOwnedLibraries()) {
			createNode(parentNode, csLibrary);
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
