package org.eclipse.qvtd.build.etl;

import java.util.ArrayList;
import java.util.HashSet;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl;
import org.eclipse.ocl.examples.pivot.internal.impl.TypedElementImpl;


/**
 * The Class PivotUtil.
 * 
 * @author Horacio Hoyos
 */
public class PivotUtil {
	
	public void dummyTest() {
		System.out.println("PivotUtil dummy");
	}

	/**
	 * Returns the variable with the lowest ranking in the class hierarchy of
	 * all the variables in the set.
	 *
	 * @param vars the variables
	 * @return The lowest ranking variable
	 */
	public TypedElementImpl getLowestRankVariable(HashSet<TypedElementImpl> vars) {
		
		return getLowestRankVariable(new ArrayList<TypedElementImpl>(vars));
		
	}
	
	public TypedElementImpl getLowestRankVariable(ArrayList<TypedElementImpl> vars) {
		
		//System.out.println("getLowestRankVariable");
		TypedElementImpl min = vars.get(0);
		//System.out.println("Min " + min);
		EStructuralFeature typeFeat = min.eClass().getEStructuralFeature("type");
		ClassImpl minType = null;
		for(int i = 1; i < vars.size(); ++i) {
			minType = (ClassImpl) min.eGet(typeFeat);
			if (((ClassImpl)vars.get(i).eGet(typeFeat)).getSuperClass().contains(minType)) {
		    	min = vars.get(i);
		    	//System.out.println("Min " + min);
		    }
		}
		// Verify that the min is actually the min, i.e. all the other variables are superiors
		// in the hierarchy
		for (TypedElementImpl var : vars) {
			if (!var.equals(min)) {
				if (!((ClassImpl)min.eGet(typeFeat)).getSuperClass().contains(var.eGet(typeFeat))) {
					// Error
					return null;
				}
			}
		}
		return min;
	}

}
