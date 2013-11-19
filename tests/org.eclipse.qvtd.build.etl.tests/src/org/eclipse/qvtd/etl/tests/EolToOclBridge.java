package org.eclipse.qvtd.etl.tests;

import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.ocl.examples.pivot.internal.impl.TypedElementImpl;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class EolToOclBridge {
	
	public void test(EClassImpl c) {
		
		System.out.println("OclBridge " + c);
		
	}
	
	public void test2(org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl c) {
		
		System.out.println("OclBridge 2 " + c);
		System.out.println("OclBridge 2 " + c.getInstanceClassName());
		System.out.println("OclBridge 2 " + c.getMetaTypeName());
		System.out.println("OclBridge 2 " + c.eClass());
		System.out.println("OclBridge 2 " + c.getSuperClass());
	}
	
	public TypedElementImpl test3(org.eclipse.epsilon.eol.types.EolSet<TypedElementImpl> vars) {
		
		for(TypedElementImpl t : vars) {
			System.out.println(t);
		}
		return null;
	}
}
