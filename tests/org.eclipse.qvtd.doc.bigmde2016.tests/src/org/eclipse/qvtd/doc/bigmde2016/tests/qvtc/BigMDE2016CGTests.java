/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.bigmde2016.tests.qvtc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.doc.bigmde2016.tests.FamiliesGenerator;
import org.eclipse.qvtd.doc.bigmde2016.tests.PrintAndLog;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.FamiliesFactory;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.Family;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.Member;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.junit.Test;

/**
 * Source code for CG results in BigMDE 2016, Eclipse QVTC First Results paper.
 */
public class BigMDE2016CGTests extends BigMDE2016_QVTc_AutomatedTests
{

	@Test
	public void testQVTcCompiler_Families_EcoreUtilCopy() throws Exception {
		PrintAndLog logger = new PrintAndLog("results/" + getName());
		logger.printf("%s\n", getName());
		QVTiEnvironmentFactory environmentFactory = new QVTiEnvironmentFactory(ProjectManager.NO_PROJECTS, null);
		try {
			int[] tests = PrintAndLog.getTestSizes();
			for (int testSize : tests) {
				Collection<@NonNull ? extends EObject> rootObjects = FamiliesGenerator.createFamiliesModel(testSize, 9);
				garbageCollect();
				logger.printf("%9d, ", 10*testSize);
				long startTime = System.nanoTime();
				Collection<@NonNull Object> rootObjects2 = EcoreUtil.copyAll(rootObjects);
				long endTime = System.nanoTime();
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
				assert rootObjects2.size() == testSize;
			}
		}
		finally {
			environmentFactory.dispose();
			logger.dispose();
		}
	}

	@Test
	public void testQVTcCompiler_Families2Persons_CG() throws Exception {
		PrintAndLog logger = new PrintAndLog(getName());
		logger.printf("%s\n", getName());
		QVTiEnvironmentFactory environmentFactory = new QVTiEnvironmentFactory(ProjectManager.NO_PROJECTS, null);
		try {
			int[] tests = PrintAndLog.getTestSizes();
			for (int testSize : tests) {
				doTest(logger, environmentFactory, testSize);
			}
		}
		finally {
			environmentFactory.dispose();
			logger.dispose();
		}
	}

	@Test
	public void testQVTcCompiler_Families2Persons_ManualInPlace() throws Exception {
		PrintAndLog logger = new PrintAndLog(getName());
		logger.printf("%s\n", getName());
		QVTiEnvironmentFactory environmentFactory = new QVTiEnvironmentFactory(ProjectManager.NO_PROJECTS, null);
		try {
			int[] tests = PrintAndLog.getTestSizes();
			for (int testSize : tests) {
				Iterable<@NonNull ? extends EObject> rootObjects = FamiliesGenerator.createFamiliesModel(testSize, 9);
				garbageCollect();
				logger.printf("%9d, ", 10*testSize);
				long startTime = System.nanoTime();
				List<Member> members = new ArrayList<Member>(9*testSize);
				for (EObject eObject : rootObjects) {
					Family family = (Family)eObject;
					members.add(family.getFather());
					members.add(family.getMother());
					members.addAll(family.getSons());
					members.addAll(family.getDaughters());
				}
				long endTime = System.nanoTime();
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
				assert members.size() == 9*testSize;
			}
		}
		finally {
			environmentFactory.dispose();
			logger.dispose();
		}
	}
	@Test
	public void testQVTcCompiler_Families2Persons_ManualCopy() throws Exception {
		PrintAndLog logger = new PrintAndLog(getName());
		logger.printf("%s\n", getName());
		QVTiEnvironmentFactory environmentFactory = new QVTiEnvironmentFactory(ProjectManager.NO_PROJECTS, null);
		try {
			int[] tests = PrintAndLog.getTestSizes();
			for (int testSize : tests) {
				Iterable<@NonNull ? extends EObject> rootObjects = FamiliesGenerator.createFamiliesModel(testSize, 9);
				garbageCollect();
				logger.printf("%9d, ", 10*testSize);
				long startTime = System.nanoTime();
				List<Member> members = new ArrayList<Member>(9*testSize);
				for (EObject eObject : rootObjects) {
					Family family = (Family)eObject;
					members.add(manualCopy(family.getFather()));
					members.add(manualCopy(family.getMother()));
					for (Member member : family.getSons()) {
						members.add(manualCopy(member));
					}
					for (Member member : family.getDaughters()) {
						members.add(manualCopy(member));
					}
				}
				long endTime = System.nanoTime();
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
				assert members.size() == 9*testSize;
			}
		}
		finally {
			environmentFactory.dispose();
			logger.dispose();
		}
	}

	private Member manualCopy(@NonNull Member oldMember) {
		Member newMember = FamiliesFactory.eINSTANCE.createMember();
		newMember.setFirstName(oldMember.getFirstName());
		return newMember;
	}

	/*	@Test
	public void testQVTcCompiler_UML2RDBMS_CG() throws Exception {
		PrintAndLog logger = new PrintAndLog(getName());
		logger.printf("%s\n", getName());
		QVTiEnvironmentFactory environmentFactory = new QVTiEnvironmentFactory(ProjectManager.NO_PROJECTS, null);
		try {
			QVTcSimpleUMLGenerator generator = new QVTcSimpleUMLGenerator();
			int[] tests = PrintAndLog.getTestSizes();
			for (int testSize : tests) {
				int nPackages = testSize;
				int nClasses = testSize * 8;
				int nTypes = 0;//testSize;
				int nProperties = 0;//testSize * 45;
				int nAssociations = 0;//testSize * 45;
				int nElements = nPackages + nClasses + nTypes + nProperties + nAssociations;
				Iterable<@NonNull ? extends Object> rootObjects = generator.createSimpleUMLModel(nPackages, nClasses, nTypes, nProperties, nAssociations);
				QVTiTransformationExecutor generatedExecutor = new QVTiTransformationExecutor(environmentFactory, umlRdbms.class);
				Transformer transformer = generatedExecutor.getTransformer();
				transformer.addRootObjects("uml", rootObjects);
				garbageCollect();
				logger.printf("%9d, ", nElements);
				long startTime = System.nanoTime();
				transformer.run();
				long endTime = System.nanoTime();
				logger.printf("%9.6f\n", (endTime - startTime) / 1.0e9);
				Collection<@NonNull Object> rootObjects2 = transformer.getRootObjects("rdbms");
				//				assert rootObjects2.size() == 9*testSize;
				int count = 0;
				for (Object eObject1 : rootObjects2) {
					for (EObject eObject2 : new TreeIterable((EObject)eObject1, true)) {
						count++;
					}
				}
				System.out.println(rootObjects2.size() + " => " + count);
			}
		}
		finally {
			environmentFactory.dispose();
			logger.dispose();
		}
	} */
}
