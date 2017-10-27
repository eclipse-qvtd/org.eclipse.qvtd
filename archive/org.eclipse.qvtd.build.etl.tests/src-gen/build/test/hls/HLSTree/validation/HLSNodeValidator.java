/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 *
 * $Id$
 */
package build.test.hls.HLSTree.validation;

import build.test.hls.HLSTree.HLSNode;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link build.test.hls.HLSTree.HLSNode}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface HLSNodeValidator {
	boolean validate();

	boolean validateParent(HLSNode value);
	boolean validateChildren(EList<HLSNode> value);
	boolean validateHls(String value);
	boolean validateName(String value);
}