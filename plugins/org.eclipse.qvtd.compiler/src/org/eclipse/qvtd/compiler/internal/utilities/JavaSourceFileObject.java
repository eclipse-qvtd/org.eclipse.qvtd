/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.osgi.framework.Bundle;

/**
 * JavaSourceFileObject supports use of a File as a Java compilation unit.
 *
 * The compileClasses utility method support compilation of a source package and subpackages.
 */
public final class JavaSourceFileObject extends SimpleJavaFileObject
{
	private static @Nullable JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

	/**
	 * Compile all *.java files on sourcePath to objectPath.
	 * e.g. from ../xyzzy/src/a/b/c to ../xyzzy/bin
	 */
	public static void compileClasses(@NonNull String sourcePath, @NonNull String objectPath, @Nullable List<String> classpathProjects) throws IOException {
		try {
			List<@NonNull JavaFileObject> compilationUnits = gatherCompilationUnits(new File(sourcePath), null);
			JavaCompiler compiler2 = compiler;
			if (compiler2 == null) {
				throw new IllegalStateException("No JavaCompiler provided by the Java platform - you need to use a JDK rather than a JRE");
			}
			StandardJavaFileManager stdFileManager2 = compiler2.getStandardFileManager(null, Locale.getDefault(), null);
			if (stdFileManager2 == null) {
				throw new IllegalStateException("No StandardJavaFileManager provided by the Java platform");
			}
			//			System.out.printf("%6.3f start\n", 0.001 * (System.currentTimeMillis()-base));
			DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
			List<String> compilationOptions;
			if (EcorePlugin.IS_ECLIPSE_RUNNING && (classpathProjects != null)) {
				compilationOptions = Arrays.asList("-d", objectPath, "-g", "-cp", createClassPath(classpathProjects));
			}
			else {
				compilationOptions = Arrays.asList("-d", objectPath, "-g");
			}

			//			System.out.printf("%6.3f getTask\n", 0.001 * (System.currentTimeMillis()-base));
			CompilationTask compilerTask = compiler2.getTask(null, stdFileManager2, diagnostics, compilationOptions, null, compilationUnits);
			//			System.out.printf("%6.3f call\n", 0.001 * (System.currentTimeMillis()-base));
			if (!compilerTask.call()) {
				StringBuilder s = new StringBuilder();
				for (Diagnostic<?> diagnostic : diagnostics.getDiagnostics()) {
					s.append("\n" + diagnostic);
				}
				if (s.length() > 0) {
					//					throw new IOException("Failed to compile " + sourcePath + s.toString());
					// If a previous generation was bad we may get many irrelevant errors.
					System.err.println("Failed to compile " + sourcePath + s.toString());
				}
				else {
					System.out.println("Compilation of " + sourcePath + " returned false but no diagnostics");
				}
			}
			//			System.out.printf("%6.3f close\n", 0.001 * (System.currentTimeMillis()-base));
			stdFileManager2.close();		// Close the file manager which re-opens automatically
			//			System.out.printf("%6.3f forName\n", 0.001 * (System.currentTimeMillis()-base));
		}
		catch (Throwable e) {
			throw e;
		}
	}

	public static @NonNull List<@NonNull String> createClasspathProjectList(@NonNull String... classpathProjects) {
		List<@NonNull String> classpathProjectList = new ArrayList<@NonNull String>();
		if (classpathProjects != null) {
			for (@NonNull String classpathProject : classpathProjects) {
				classpathProjectList.add(classpathProject);
			}
		}
		return classpathProjectList;
	}

	public static @NonNull String createClassPath(@NonNull List<String> projectNames) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		String pathSeparator = null;
		StringBuilder s = new StringBuilder();
		for (String projectName : projectNames) {
			String projectPath = null;
			IProject project = root.getProject(projectName);
			if (project != null) {
				IPath location = project.getLocation();
				if (location != null) {
					projectPath = location.toString() + "/";
				}
			}
			if (projectPath == null) {
				Bundle bundle = Platform.getBundle(projectName);
				if (bundle != null) {
					projectPath = bundle.getLocation();
				}
			}

			if (projectPath != null) {
				if (projectPath.startsWith("reference:")) {
					projectPath = projectPath.substring(10);
				}
				URI uri = URI.createURI(projectPath);
				if (uri.isFile()) {
					projectPath =  ClassUtil.nonNullState(uri.toFileString()).replace("\\", "/");
				}
				assert projectPath != null;
				if (projectPath.endsWith("/")) {
					projectPath = projectPath + "bin";
				}
				if (pathSeparator != null) {
					s.append(pathSeparator);
				}
				else {
					pathSeparator = System.getProperty("path.separator");
				}
				s.append(projectPath);
			}
		}
		return s.toString();
	}

	/**
	 * Compile all *.java files on sourcePath
	 */
	public static void deleteJavaFiles(@NonNull String sourcePath) {
		deleteJavaFiles(new File(sourcePath));
	}

	/**
	 * Return a list comprisiing a JavaFileObject for each *.java file in or below folder.
	 * A non-null compilationUnits may be provided for use as the returned list.
	 */
	private static void deleteJavaFiles(@NonNull File folder) {
		File[] listFiles = folder.listFiles();
		if (listFiles != null) {
			for (File file : listFiles) {
				if (file.isDirectory()) {
					deleteJavaFiles(file);
				}
				else if (file.isFile() && file.getName().endsWith(".java")) {
					System.out.println("Delete " + file);
					file.delete();
				}
			}
		}
		return;
	}

	/**
	 * Return a list comprisiing a JavaFileObject for each *.java file in or below folder.
	 * A non-null compilationUnits may be provided for use as the returned list.
	 */
	private static @NonNull List<@NonNull JavaFileObject> gatherCompilationUnits(@NonNull File folder, @Nullable List<@NonNull JavaFileObject> compilationUnits) throws IOException {
		if (compilationUnits == null) {
			compilationUnits = new ArrayList<@NonNull JavaFileObject>();
		}
		File[] listFiles = folder.listFiles();
		if (listFiles != null) {
			for (File file : listFiles) {
				if (file.isDirectory()) {
					gatherCompilationUnits(file, compilationUnits);
				}
				else if (file.isFile() && file.getName().endsWith(".java")) {
					java.net.URI uri = file.getCanonicalFile().toURI();
					compilationUnits.add(new JavaSourceFileObject(uri));
				}
			}
		}
		return compilationUnits;
	}

	/**
	 * Load the class whose Java name is qualifiedClassName and whose class file can be found below explicitClassPath.
	 * Subsequent loads of classes such as nested classes whose names are prefixed by qualifiedClassName are also loaded from explicitClassPath.
	 * This method always uses a new ClassLoader to load the class and so ignores any previously cached loads.
	 */
	public static Class<?> loadExplicitClass(@NonNull File explicitClassPath, @NonNull String qualifiedClassName) throws ClassNotFoundException, IOException {
		ClassLoader thisClassLoader = JavaSourceFileObject.class.getClassLoader();
		assert thisClassLoader != null;
		ExplicitClassLoader classLoader = new ExplicitClassLoader(explicitClassPath, qualifiedClassName, thisClassLoader);
		return classLoader.loadClass(qualifiedClassName);
	}

	public static void saveClass(@NonNull String explicitClassPath, @NonNull String qualifiedName, @NonNull String javaCodeSource, @Nullable List<String> classpathProjects) throws IOException {
		JavaCompiler compiler2 = compiler;
		if (compiler2 == null) {
			throw new IllegalStateException("No JavaCompiler provided by the Java platform - you need to use a JDK rather than a JRE");
		}
		StandardJavaFileManager stdFileManager2 = compiler2.getStandardFileManager(null, Locale.getDefault(), null);
		if (stdFileManager2 == null) {
			throw new IllegalStateException("No StandardJavaFileManager provided by the Java platform");
		}
		//		System.out.printf("%6.3f start\n", 0.001 * (System.currentTimeMillis()-base));
		List<? extends JavaFileObject> compilationUnits = Collections.singletonList(
			new OCL2JavaFileObject(qualifiedName, javaCodeSource));
		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

		List<String> compilationOptions;
		if (EcorePlugin.IS_ECLIPSE_RUNNING && (classpathProjects != null)) {
			compilationOptions = Arrays.asList("-d", explicitClassPath, "-g", "-cp", createClassPath(classpathProjects));
		}
		else {
			compilationOptions = Arrays.asList("-d", explicitClassPath, "-g");
		}

		//		System.out.printf("%6.3f getTask\n", 0.001 * (System.currentTimeMillis()-base));
		CompilationTask compilerTask = compiler2.getTask(null, stdFileManager2,
			diagnostics, compilationOptions, null, compilationUnits);
		//		System.out.printf("%6.3f call\n", 0.001 * (System.currentTimeMillis()-base));
		if (!compilerTask.call()) {
			StringBuilder s = new StringBuilder();
			for (Diagnostic<?> diagnostic : diagnostics.getDiagnostics()) {
				s.append("\n" + diagnostic);
			}
			if (s.length() > 0) {
				throw new IOException("Failed to compile " + qualifiedName + s.toString());
			}
			System.out.println("Compilation of " + qualifiedName + " returned false but no diagnostics");
		}
		//		System.out.printf("%6.3f close\n", 0.001 * (System.currentTimeMillis()-base));
		stdFileManager2.close();		// Close the file manager which re-opens automatically
		//		System.out.printf("%6.3f forName\n", 0.001 * (System.currentTimeMillis()-base));
	}

	private JavaSourceFileObject(java.net.@NonNull URI uri) {
		super(uri, Kind.SOURCE);
	}

	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
		char[] buf = new char[4096];
		StringBuffer s = new StringBuffer();
		Reader reader = new FileReader(new File(uri));
		try {
			int len;
			while ((len = reader.read(buf)) > 0) {
				s.append(buf, 0, len);
			}
		}
		finally {
			reader.close();
		}
		return s.toString();
	}
}