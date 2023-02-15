/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.tests;

import org.eclipse.ocl.examples.xtext.tests.ProjectTestFileSystemHelper;

public class QVTbaseTestFileSystemHelper extends ProjectTestFileSystemHelper
{
	public QVTbaseTestFileSystemHelper() {
		addRequiredBundle("org.eclipse.qvtd.runtime");
	}

	/*	@Override
	protected void appendBuildSpec(@NonNull Writer s) throws IOException {
		s.append("  <buildSpec>\n");
		s.append("    <buildCommand>\n");
		s.append("      <name>org.eclipse.jdt.core.javabuilder</name>\n");
		s.append("      <arguments>\n");
		s.append("      </arguments>\n");
		s.append("    </buildCommand>\n");
		s.append("    <buildCommand>\n");
		s.append("      <name>org.eclipse.pde.ManifestBuilder</name>\n");
		s.append("      <arguments>\n");
		s.append("      </arguments>\n");
		s.append("    </buildCommand>\n");
		s.append("    <buildCommand>\n");
		s.append("      <name>org.eclipse.pde.SchemaBuilder</name>\n");
		s.append("      <arguments>\n");
		s.append("      </arguments>\n");
		s.append("    </buildCommand>\n");
		s.append("    <!--buildCommand>\n");
		s.append("      <name>org.eclipse.qvtd.xtext.qvtbase.ui.qvtdbuilder</name>\n");
		s.append("      <arguments>\n");
		s.append("        <dictionary>\n");
		s.append("          <key>disabledExtensions</key>\n");
		s.append("          <value>*</value>\n");
		s.append("        </dictionary>\n");
		s.append("       <dictionary>\n");
		s.append("          <key>disabledPaths</key>\n");
		s.append("          <value>target/**</value>\n");
		s.append("        </dictionary>\n");
		s.append("        <dictionary>\n");
		s.append("          <key>enabledExtensions</key>\n");
		s.append("          <value>qvtc,qvti,qvtr,umlx</value>\n");
		s.append("        </dictionary>\n");
		s.append("        <dictionary>\n");
		s.append("          <key>enabledPaths</key>\n");
		s.append("          <value>model/**</value>\n");
		s.append("        </dictionary>\n");
		s.append("      </arguments>\n");
		s.append("    </buildCommand-->\n");
		s.append("  </buildSpec>\n");
	} */
}