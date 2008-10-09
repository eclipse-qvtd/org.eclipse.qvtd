/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * </copyright>
 * 
 * Contributors:
 *     Quentin Glineur - initial API and implementation
 *
 * $Id: ASMUtils.java,v 1.2 2008/10/09 17:21:06 qglineur Exp $
 */
package org.eclipse.qvt.declarative.relations.atlvm.utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.ASMInstructionWithOperand;
import org.eclipse.m2m.atl.engine.vm.ASMOperation;
import org.eclipse.m2m.atl.engine.vm.ASMXMLReader;
import org.eclipse.qvt.declarative.relations.atlvm.Activator;
import org.osgi.framework.Bundle;

public class ASMUtils {

	protected static int PUSH_DIRECTION_DOMAIN_NAME_INSTRUCTION_INDEX = 9;

	protected static String REFERENCE_DIRECTION_LIBRARY_LOACTION = "/resources/direction.asm"; //$NON-NLS-1$

	public static ASM createDirectionLibrary(String domainName) {
		Bundle bundle = Activator.getDefault().getBundle();

		URL referenceDirectionLibraryURL = FileLocator.find(bundle, new Path(
				REFERENCE_DIRECTION_LIBRARY_LOACTION), Collections.EMPTY_MAP);
		try {
			ASM referenceDirectionLibrary = new ASMXMLReader()
					.read(new BufferedInputStream(referenceDirectionLibraryURL
							.openStream()));
			ASMOperation directionOperation = referenceDirectionLibrary
					.getOperation("direction_domain");
			Object object = directionOperation.getInstructions().get(
					PUSH_DIRECTION_DOMAIN_NAME_INSTRUCTION_INDEX);
			if (object instanceof ASMInstructionWithOperand) {
				ASMInstructionWithOperand pushDirectionDomainName = (ASMInstructionWithOperand) object;
				pushDirectionDomainName.setOperand(domainName);
			}
			return referenceDirectionLibrary;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
