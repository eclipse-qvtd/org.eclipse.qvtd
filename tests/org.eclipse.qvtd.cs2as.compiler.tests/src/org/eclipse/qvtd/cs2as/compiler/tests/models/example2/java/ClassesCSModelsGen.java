/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler.tests.models.example2.java;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;

import example2.classescs.ClassCS;
import example2.classescs.ClassescsFactory;
import example2.classescs.PackageCS;
import example2.classescs.PathElementCS;
import example2.classescs.PathNameCS;
import example2.classescs.RootCS;

public class ClassesCSModelsGen {

	private static URI TESTS_BASE_URI = URI.createPlatformResourceURI("org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/cs2as/compiler/tests/models", true);
	
	private static int NUM_ROOT_PACKAGES = 4;
	private static int NUM_SUB_PACKAGES = 4;
	private static int NUM_CLASS_PER_PACKAGE = 6;
	private static int NUM_PACKAGE_PER_PACKAGE = 5;
	
	public static void main(String[] args) {
		
		ClassesCSModelsGen mGen = new ClassesCSModelsGen();
		URI baseURI = TESTS_BASE_URI.appendSegments(new String[]{"example2", "samples"});

		ResourceSet rSet = new ResourceSetImpl();
		StandaloneProjectMap.getAdapter(rSet);
		
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		Resource resource = rSet.createResource(baseURI.appendSegment("model7_input.xmi"));
		resource.getContents().add(mGen.createRootCS(NUM_ROOT_PACKAGES, NUM_SUB_PACKAGES, NUM_CLASS_PER_PACKAGE, NUM_PACKAGE_PER_PACKAGE));
		
		try {
			resource.save(TestsXMLUtil.defaultSavingOptions);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public RootCS createRootCS(int nRootPackages, int maxDepth, int nClassesPPackage, int nPackagesPPackage) {
		
		RootCS r = ClassescsFactory.eINSTANCE.createRootCS();
		for (int i = 1; i <= nRootPackages; i++) {
			
			r.getOwnedPackages().add(createPackage(String.valueOf(i), nClassesPPackage, nPackagesPPackage, maxDepth));
		}
		return r;
	}
	
	private PackageCS createPackage(String numberHint, int maxDepth, int nClassesPPackage, int nPackagesPPackage) {
		
				
		PackageCS p = ClassescsFactory.eINSTANCE.createPackageCS();
		p.setName("P"+numberHint);
		 
		for (int i = 1; i <= nClassesPPackage; i++) {
			p.getOwnedClasses().add(createClass(numberHint + String.valueOf(i)));
		}
		
		if (maxDepth > 1) {
			for (int i = 1; i <= nPackagesPPackage; i++) {
				p.getOwnedPackages().add(createPackage(numberHint + String.valueOf(i), maxDepth -1, nClassesPPackage, nPackagesPPackage));
			}
		}
		
		return p;
		
	}
	
	private ClassCS createClass(String numberHint) {
		
		ClassCS c = ClassescsFactory.eINSTANCE.createClassCS();
		c.setName("C"+numberHint);;
		
		// We set the reference to the class in the root package
		if (numberHint.length() > 2) {
			PathNameCS pName = ClassescsFactory.eINSTANCE.createPathNameCS();
			PathElementCS pElement= ClassescsFactory.eINSTANCE.createPathElementCS();
			pElement.setName("C" + numberHint.substring(0, 1) + numberHint.substring(numberHint.length()-1));
			pName.getPath().add(pElement);
			c.setExtends(pName);
		}
		return c;
	}
	
	
	

}
