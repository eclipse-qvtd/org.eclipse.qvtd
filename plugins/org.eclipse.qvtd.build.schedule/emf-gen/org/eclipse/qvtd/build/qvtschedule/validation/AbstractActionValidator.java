/**
 *
 * $Id$
 */
package org.eclipse.qvtd.build.qvtschedule.validation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.qvtd.build.qvtschedule.AbstractAction;
import org.eclipse.qvtd.build.qvtschedule.AbstractDatum;
import org.eclipse.qvtd.build.qvtschedule.DataParameter;
import org.eclipse.qvtd.build.qvtschedule.ParameterDerivation;
import org.eclipse.qvtd.build.qvtschedule.Schedule;

/**
 * A sample validator interface for {@link org.eclipse.qvtd.build.qvtschedule.AbstractAction}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface AbstractActionValidator {
	boolean validate();

	boolean validateProductions(EList<AbstractDatum> value);
	boolean validateRequisites(EList<AbstractDatum> value);
	boolean validateParameterDerivations(EList<ParameterDerivation> value);
	boolean validateOrder(int value);
	boolean validateParent(AbstractAction value);
	boolean validateChildren(EList<AbstractAction> value);
	boolean validateParameters(EList<AbstractDatum> value);
	boolean validateResults(EList<DataParameter> value);
	boolean validateSchedule(Schedule value);
}
