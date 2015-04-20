/**
 *
 * $Id$
 */
package org.eclipse.qvtd.compiler.internal.qvtcconfig.validation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.qvtd.compiler.internal.qvtcconfig.Import;

/**
 * A sample validator interface for {@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Direction}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface DirectionValidator {
	boolean validate();

	boolean validateImports(EList<Import> value);
}
