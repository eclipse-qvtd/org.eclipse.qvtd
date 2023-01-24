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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.tests.TestFileSystemHelper;

public class QVTbaseTestFileSystemHelper extends TestFileSystemHelper
{ // FIXME share with UsageTests.getTestFileSystemHelper
	private @NonNull List<@NonNull String> exportedPackages = new ArrayList<>();
	private @NonNull List<@NonNull String> requiredBundles = new ArrayList<>();

	public QVTbaseTestFileSystemHelper() {
		addRequiredBundle("org.eclipse.qvtd.runtime");
	}

	public void addExportedPackage(@NonNull String exportedPackage) {
		if (!exportedPackages.contains(exportedPackage)) {
			exportedPackages.add(exportedPackage);
		}
	}

	public void addRequiredBundle(@NonNull String requiredBundle) {
		if (!requiredBundles.contains(requiredBundle)) {
			requiredBundles.add(requiredBundle);
		}
	}

	@Override
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
	}

	@Override
	protected void appendNatures(@NonNull Writer s) throws IOException {
		s.append("  <natures>\n");
		s.append("    <!--nature>org.eclipse.qvtd.xtext.qvtbase.ui.qvtdnature</nature-->\n");
		s.append("    <nature>org.eclipse.jdt.core.javanature</nature>\n");
		s.append("    <nature>org.eclipse.pde.PluginNature</nature>\n");
		s.append("  </natures>\n");
	}

	@Override
	public @Nullable File createBuildDotProperties(@NonNull File projectFolder, @NonNull String projectName) {
		File file = new File(projectFolder, "build.properties");
		Writer s;
		try {
			s = new FileWriter(file);
			s.append("bin.includes = META-INF/\n");
			s.append("source.. = test-src/\n");
			s.append("");
			s.close();
		} catch (IOException e) {
			throw new WrappedException(e);
		}
		return file;
	}

	@Override
	public @Nullable File createDotClasspathFile(@NonNull File projectFolder, @NonNull String projectName) {
		File file = new File(projectFolder, ".classpath");
		Writer s;
		try {
			s = new FileWriter(file);
			s.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			s.append("<classpath>\n");
			s.append("	<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.8\"/>\n");
			s.append("	<classpathentry kind=\"con\" path=\"org.eclipse.pde.core.requiredPlugins\"/>\n");
			s.append("	<classpathentry kind=\"src\" path=\"test-src\"/>\n");
			s.append("	<classpathentry kind=\"output\" path=\"bin\"/>\n");
			s.append("</classpath>\n");
			s.append("");
			s.close();
		} catch (IOException e) {
			throw new WrappedException(e);
		}
		return file;
	}

	@Override
	public @Nullable File createManifestFile(@NonNull File projectFolder, @NonNull String projectName) {
		File metaInfFolder = new File(projectFolder, "META-INF");
		metaInfFolder.mkdir();
		File file = new File(metaInfFolder, "MANIFEST.MF");
		Writer s;
		try {
			s = new FileWriter(file);
			s.append("Manifest-Version: 1.0\n");
			s.append("Automatic-Module-Name: " + projectName + "\n");
			s.append("Bundle-ManifestVersion: 2\n");
			s.append("Bundle-Name: " + projectName + "\n");
			s.append("Bundle-SymbolicName: " + projectName + ";singleton:=true\n");
			s.append("Bundle-Version: 1.0.0.qualifier\n");
			s.append("Bundle-RequiredExecutionEnvironment: JavaSE-1.8\n");
			boolean isFirst = true;
			for (@NonNull String requiredBundle : getRequiredBundles()) {
				s.append(isFirst ? "Require-Bundle: " : ",\n ");
				s.append(requiredBundle);
				isFirst = false;
			}
			s.append("\n");
			isFirst = true;
			List<@NonNull String> exportedPackages = getExportedPackages();
			for (@NonNull String exportedPackage : exportedPackages) {
				s.append(isFirst ? "Export-Package: " : ",\n ");
				s.append(exportedPackage);
				isFirst = false;
			}
			s.append("\n");
			s.close();
		} catch (IOException e) {
			throw new WrappedException(e);
		}
		return file;
	}

	protected @NonNull List<@NonNull String> getExportedPackages() {
		return exportedPackages;
	}

	protected @NonNull List<@NonNull String> getRequiredBundles() {
		return requiredBundles;
	}
}