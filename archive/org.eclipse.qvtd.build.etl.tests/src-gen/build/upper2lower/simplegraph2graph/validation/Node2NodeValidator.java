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
package build.upper2lower.simplegraph2graph.validation;

import build.upper2lower.simplegraph.Node;

/**
 * A sample validator interface for {@link build.upper2lower.simplegraph2graph.Node2Node}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface Node2NodeValidator {
	boolean validate();

	boolean validateNode1(Node value);
	boolean validateNode2(Node value);
	boolean validateLabel(String value);
}
