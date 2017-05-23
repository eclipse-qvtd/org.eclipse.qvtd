/*******************************************************************************
 * Copyright (c) 2012, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.bigmde2016.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.FamiliesFactory;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.Family;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.Member;

public class FamiliesGenerator
{ 
    public static @NonNull List<@NonNull ? extends EObject> createFamiliesModel(int nFamilies, int nMembersPerFamily) {
    	ThreadLocalRandom random = ThreadLocalRandom.current();
		List<Family> families = new ArrayList<Family>(nFamilies);
		List<Member> sons = new ArrayList<Member>();
		List<Member> daughters = new ArrayList<Member>();
		int membersToGo = nFamilies * (nMembersPerFamily-2);
		for (int f = 0; f < nFamilies; f++) {
			Family family = FamiliesFactory.eINSTANCE.createFamily();
			families.add(family);
			family.setLastName("family" + f);
			int familiesToGo = nFamilies-f;
			Member father = FamiliesFactory.eINSTANCE.createMember();
			father.setFirstName("father" + f);
			family.setFather(father);
			Member mother = FamiliesFactory.eINSTANCE.createMember();
			mother.setFirstName("mother" + f);
			family.setMother(mother);
			int nMembers = familiesToGo <= 1 ? membersToGo : (2 * random.nextInt(membersToGo+1) / familiesToGo);
			for (int m = 0; m < nMembers; m++) {
				Member member = FamiliesFactory.eINSTANCE.createMember();
				if (random.nextBoolean()) {
					family.getSons().add(member);
				}
				else {
					family.getDaughters().add(member);
				}
				member.setFirstName("member" + --membersToGo);
			}
//			int fatherIndex = random.nextInt(-10, sons.size());
//			if (fatherIndex >= 0) {
//				family.setFather(sons.get(fatherIndex));
//			}
//			int motherIndex = random.nextInt(-10, daughters.size());
//			if (motherIndex >= 0) {
//				family.setMother(daughters.get(motherIndex));
//			}
			sons.addAll(family.getSons());
			daughters.addAll(family.getDaughters());
		}
		assert 2*families.size() + sons.size() + daughters.size() == nFamilies * nMembersPerFamily;
		return families;
	}

	public static void garbageCollect() throws InterruptedException {
		for (int y = 0; y < 5; y++) {
			System.gc();
			Thread.sleep(100);
		}
	}
}
