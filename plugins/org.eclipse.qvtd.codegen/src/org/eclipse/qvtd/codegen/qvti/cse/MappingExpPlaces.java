/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
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
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;

/**
 * MappingExpPlaces manages a BodyPlace for the then CG tree of a body statements.
 * <p>
 * They do not yet support hoisting.
 */
public class MappingExpPlaces
{
	public static @NonNull LocalPlace createMappingExpPlaces(@NonNull Map<CGElement, AbstractPlace> element2place, @NonNull CGMappingExp cgMappingExp) {
		ControlPlace mapExpPlace = ControlPlace.getControlPlace(element2place, cgMappingExp);
		CGValuedElement cgBody = cgMappingExp.getBody();
		if (cgBody != null) {
			BodyPlace bodyPlace = new BodyPlace(mapExpPlace, cgBody);
			element2place.put(cgBody, bodyPlace);
		}
		return mapExpPlace;
	}
	
	/**
	 * A BodyPlace describes the then CG tree for body statements.
	 */
	public static class BodyPlace extends ControlPlace
	{
		private BodyPlace(@NonNull LocalPlace mapExpPlace, @NonNull CGValuedElement cgBody) {
			super(mapExpPlace, cgBody);
		}
	}
}