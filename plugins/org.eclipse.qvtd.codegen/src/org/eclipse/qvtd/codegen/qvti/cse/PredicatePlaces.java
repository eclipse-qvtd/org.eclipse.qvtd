/*******************************************************************************
 * Copyright (c) 2013 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.cse;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cse.AbstractPlace;
import org.eclipse.ocl.examples.codegen.cse.ControlPlace;
import org.eclipse.ocl.examples.codegen.cse.LocalPlace;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;

/**
 * PredicatePlaces manages a ThenPlace for the then CG tree of a predi8cate expression.
 * <p>
 * They do not yet support hoisting.
 */
public class PredicatePlaces
{
	public static @NonNull LocalPlace createPredicatePlaces(@NonNull Map<CGElement, AbstractPlace> element2place, @NonNull CGPredicate cgPredicate) {
		ControlPlace predicatePlace = ControlPlace.getControlPlace(element2place, cgPredicate);
		CGValuedElement cgThenExp = cgPredicate.getThenExpression();
		if (cgThenExp != null) {
			ThenPlace thenPlace = new ThenPlace(predicatePlace, cgThenExp);
			element2place.put(cgThenExp, thenPlace);
		}
		return predicatePlace;
	}
	
	/**
	 * A ThenPlace describes the then CG tree for a predicate expression.
	 */
	public static class ThenPlace extends ControlPlace
	{
		private ThenPlace(@NonNull LocalPlace letPlace, @NonNull CGValuedElement cgThenExp) {
			super(letPlace, cgThenExp);
		}
	}
}