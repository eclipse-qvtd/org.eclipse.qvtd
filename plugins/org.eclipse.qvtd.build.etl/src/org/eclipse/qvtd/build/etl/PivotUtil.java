/*******************************************************************************
 * Copyright (c) 2013 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.build.etl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;


/**
* The Class PivotUtil. Provides helper methods for analysing pivot model elements
*
* @author Horacio Hoyos
*/
public class PivotUtil {

    /**
    * Returns the variable with the lowest ranking in the class hierarchy of
    * all the variables in the set.
    *
    * @param vars the variables
    * @return The lowest ranking variable
    */
    public TypedElement getLowestRankVariable(Set<TypedElement> vars) {

        return getLowestRankVariable(new ArrayList<TypedElement>(vars));
    }

    
    /**
     * Returns the variable with the lowest ranking in the class hierarchy of
    * all the variables in the list.
     *
     * @param vars the variables
     * @return The lowest rank variable
     */
    public TypedElement getLowestRankVariable(List<TypedElement> vars) {

        TypedElement min = vars.get(0);
        EStructuralFeature typeFeat = min.eClass().getEStructuralFeature("type");
        ClassImpl minType = null;
        for(int i = 1; i < vars.size(); ++i) {
            minType = (ClassImpl) min.eGet(typeFeat);
            if (((ClassImpl)vars.get(i).eGet(typeFeat)).getSuperClass().contains(minType)) {
                min = vars.get(i);
            }
        }
        // Verify that the min is actually the min, i.e. all the other variables are superiors
        // in the hierarchy
        for (TypedElement var : vars) {
            if (!var.equals(min)) {
                if (!((ClassImpl)min.eGet(typeFeat)).getSuperClass().contains(var.eGet(typeFeat))) {
                    // Error
                    return null;
                }
            }
        }
        return min;
    }
    
    // a.type is superType of b.type?
    public Boolean isKindOf(Type typeA, Type typeB) {
    	return typeA.equals(typeB) || typeA.getSuperClass().contains(typeB);
    }

}
