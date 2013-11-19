package org.eclipse.qvtd.etl.tests;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl;
import org.eclipse.ocl.examples.pivot.internal.impl.TypedElementImpl;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class EolToOclBridge {
	
	public void test(EClassImpl c) {
		
		System.out.println("OclBridge " + c);
		
	}
	
	public void test2(ClassImpl c) {
		
		System.out.println("OclBridge 2 " + c);
		System.out.println("OclBridge 2 " + c.getInstanceClassName());
		System.out.println("OclBridge 2 " + c.getMetaTypeName());
		System.out.println("OclBridge 2 " + c.eClass());
		System.out.println("OclBridge 2 " + c.getSuperClass());
	}
	
	// leastCommonAncestor
	public TypedElementImpl test3(org.eclipse.epsilon.eol.types.EolSet<TypedElementImpl> vars) {
		
		System.out.println("OclBridge 3 ");
		for(TypedElementImpl t : vars) {
			System.out.println(t);
			System.out.println(t.getClass());
			EStructuralFeature typeFeat = t.eClass().getEStructuralFeature("type");
			System.out.println(typeFeat);
			System.out.println(t.eGet(typeFeat));
			System.out.println(((ClassImpl)t.eGet(typeFeat)).getSuperClass());
		}
		return null;
	}
}
