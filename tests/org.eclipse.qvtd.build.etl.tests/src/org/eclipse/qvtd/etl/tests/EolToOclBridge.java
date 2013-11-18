package org.eclipse.qvtd.etl.tests;

import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.ocl.examples.pivot.internal.impl.TypeImpl;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class EolToOclBridge {
	
	public void test(EClassImpl c) {
		
		System.out.println("OclBridge " + c);
		
	}
	
	public void test2(org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl c) {
		
		System.out.println("OclBridge 2 " + c);
		System.out.println("OclBridge 2 " + c.getInstanceClassName());
	}
}
