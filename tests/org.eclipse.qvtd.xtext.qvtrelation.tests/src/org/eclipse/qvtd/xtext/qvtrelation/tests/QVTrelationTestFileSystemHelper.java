/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.xtext.qvtbase.tests.QVTbaseTestFileSystemHelper;

public class QVTrelationTestFileSystemHelper extends QVTbaseTestFileSystemHelper
{

	@Override
	public @Nullable File createBuildDotProperties(@NonNull File projectFolder, @NonNull String projectName) {
		File file = new File(projectFolder, "build.properties");
		Writer s;
		try {
			s = new FileWriter(file);
			s.append("bin.includes = META-INF/,\n");
			s.append(" plugin.xml\n");
			s.append("source.. = test-src/\n");
			s.append("");
			s.close();
		} catch (IOException e) {
			throw new WrappedException(e);
		}
		return file;
	}
}