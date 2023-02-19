/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.cse;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cse.AbstractPlace;
import org.eclipse.ocl.examples.codegen.cse.ControlPlace;
import org.eclipse.ocl.examples.codegen.cse.LocalPlace;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;

/**
 * SequencePlaces manages a BodyPlace for each statements.
 * <p>
 * They do not yet support hoisting.
 */
public class SequencePlaces
{
	public static @NonNull LocalPlace createSequencePlaces(@NonNull Map<@Nullable CGElement, @NonNull AbstractPlace> element2place, @NonNull CGSequence cgSequence) {
		ControlPlace mapExpPlace = ControlPlace.getControlPlace(element2place, cgSequence);
		for (CGValuedElement cgBody : QVTiCGUtil.getOwnedStatements(cgSequence)) {
			BodyPlace bodyPlace = new BodyPlace(mapExpPlace, cgBody);
			element2place.put(cgBody, bodyPlace);
		}
		return mapExpPlace;
	}

	/**
	 * A BodyPlace describes the then CG tree for body statements.
	 */
	public static class BodyPlace extends ControlPlace		// FIXME should this  be a LocalPlace
	{
		private BodyPlace(@NonNull LocalPlace mapExpPlace, @NonNull CGValuedElement cgBody) {
			super(mapExpPlace, cgBody);
		}
	}
}