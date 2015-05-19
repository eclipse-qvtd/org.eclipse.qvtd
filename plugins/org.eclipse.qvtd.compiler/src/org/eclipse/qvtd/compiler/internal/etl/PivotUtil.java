/*******************************************************************************
 * Copyright (c) 2013, 2015 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.etl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.pivot.TypedElement;
//import org.eclipse.ocl.pivot.impl.ClassImpl;

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
        org.eclipse.ocl.pivot.Class minType = null;
        for(int i = 1; i < vars.size(); ++i) {
            minType = (org.eclipse.ocl.pivot.Class) min.eGet(typeFeat);
            if (((org.eclipse.ocl.pivot.Class)vars.get(i).eGet(typeFeat)).getSuperClasses().contains(minType)) {
                min = vars.get(i);
            }
        }
        // Verify that the min is actually the min, i.e. all the other variables are superiors
        // in the hierarchy
        /*for (TypedElement var : vars) {
            if (!var.equals(min)) {
<<<<<<< HEAD
                if (!((ClassImpl)min.eGet(typeFeat)).getSuperClasses().contains(var.eGet(typeFeat))) {
                    // Error
=======
                if (!((ClassImpl)min.eGet(typeFeat)).getSuperClass().contains(var.eGet(typeFeat))) {
                	System.out.println("min is not min");
>>>>>>> refs/remotes/origin/hhoyos/qvtr
                    return null;
                }
            }
        }*/
        return min;
    }
    
    // typeA is either equal to typeB or a subclass
/*    public Boolean isKindOf(Type typeA, Type typeB) {
    	//System.out.println("TypeA" + typeA);
    	//System.out.println("TypeB" + typeB);
    	return typeA.equals(typeB) || typeA.getSuperClass().contains(typeB);
    } */

}
