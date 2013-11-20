package org.eclipse.qvtd.build.etl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.eol.types.EolSet;
import org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl;
import org.eclipse.ocl.examples.pivot.internal.impl.TypedElementImpl;


/**
 * The Class EolToOclBridge.
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
	public TypedElementImpl getLowestRankVariable(EolSet<TypedElementImpl> vars) {
		
		System.out.println("OclBridge 3 ");
		
		ArrayList<TypedElementImpl> varsArray = new ArrayList<TypedElementImpl>(vars);
		TypedElementImpl min = varsArray.get(0);
		System.out.println("Min " + min);
		EStructuralFeature typeFeat = min.eClass().getEStructuralFeature("type");
		ClassImpl minType = null;
		for(int i = 1; i < varsArray.size(); ++i) {
			minType = (ClassImpl) min.eGet(typeFeat);
			if (((ClassImpl)varsArray.get(i).eGet(typeFeat)).getSuperClass().contains(minType)) {
		    	min = varsArray.get(i);
		    	System.out.println("Min " + min);
		    } else {
		    	// Check that the min exists in the ancestors of the item being examined
		    	// If not, there is an error cause the varianbles are not in the same
		    	// hierarchy
		    }
		}
		return min;
	}
	/*
	private boolean typeIsDescendent(ClassImpl type1, ClassImpl type2) {
		List superTypes = type1.getSuperClass();
		// Stop recursion when super type is 
	}*/
}
