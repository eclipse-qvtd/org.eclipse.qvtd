/**
 * <copyright>
 * 
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: QVTrNewWizard.java,v 1.3 2008/10/25 17:03:06 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtrelation.ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.qvt.declarative.editor.ui.wizards.PagedNewWizard;

/**
 * This is a sample new wizard. Its role is to create a new file 
 * resource in the provided container. If the container resource
 * (a folder or a project) is selected in the workspace 
 * when the wizard is opened, it will accept it as the target
 * container. The wizard creates one file with the extension
 * "qvtr". If a sample multi-page editor (also available
 * as a template) is registered for the same extension, it will
 * be able to open it.
 */

public class QVTrNewWizard extends PagedNewWizard
{
	@Override protected QVTrNewWizardPage createNewWizardPage(ISelection selection) {
		return new QVTrNewWizardPage(selection);
	}
	
	/**
	 * We will initialize file contents with a sample text.
	 */
	@Override protected InputStream openContentStream() {
		String contents =
			"--\n" +
			"-- The errors in this example may be eliminated by:\n" +
			"-- 1) Adding the Model Registry Nature using the QVT Declarative Natures\n" +
			"--    menu entry available from the project right button menu\n" +
			"-- 2) Using the Model Registry to bind leftMM and rightMM to Ecore models\n" +
			"--    that define the Left and Right classes. The Model Registry is available\n" +
			"--    as one of the Properties of this file or its parent folders or project.\n" +
			"--    The Properties menu entry is available from the project right button menu\n" +
			"--\n" +
			"transformation MyTx(left:leftMM, right:rightMM) {\n" +
			"\trelation MyRelation {\n" +
			"\t\tcheckonly domain left r : Left {\n" +
			"\t\t};\n" +
			"\t\tenforce domain right m : Right {\n" +
			"\t\t};\n" +
			"\t}\n" +
			"}\n";
		return new ByteArrayInputStream(contents.getBytes());
	}
}