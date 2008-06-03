package org.eclipse.qvt.declarative.relations.atlvm.utils;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;

public class ATLVMUtils {
	
	public static String getManageableURI (EPackage ePackage) {
		return "uri:" +  ePackage.getNsURI(); //$NON-NLS-1$
	}
	
	public static ASMEMFModel loadModel (EPackage ePackage) {
		ASMEMFModel result = null;
		try {
			result = ASMEMFModel
					.loadASMEMFModel(
							ePackage.getName(), ASMEMFModel.createMOF(null), getManageableURI(ePackage), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
