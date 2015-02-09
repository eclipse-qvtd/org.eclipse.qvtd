/**
 *
 * $Id$
 */
package org.eclipse.qvtd.build.qvtschedule.validation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.qvtd.build.qvtschedule.PropertyDatum;

/**
 * A sample validator interface for {@link org.eclipse.qvtd.build.qvtschedule.ClassDatum}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ClassDatumValidator {
	boolean validate();

	boolean validateType(org.eclipse.ocl.pivot.Class value);
	boolean validatePropertyDatums(EList<PropertyDatum> value);
}
