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
package org.eclipse.qvtd.xtext.qvtbase.tests.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * JavaSourceFileObject supporets use of a File as a Java compilation unit.
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
	public static void compileClasses(@NonNull String sourcePath, @NonNull String objectPath) throws IOException {
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
			List<String> compilationOptions = Arrays.asList("-d", objectPath, "-g");
//			System.out.printf("%6.3f getTask\n", 0.001 * (System.currentTimeMillis()-base));
			CompilationTask compilerTask = compiler2.getTask(null, stdFileManager2, diagnostics, compilationOptions, null, compilationUnits);
//			System.out.printf("%6.3f call\n", 0.001 * (System.currentTimeMillis()-base));
			if (!compilerTask.call()) {
				StringBuilder s = new StringBuilder();
				for (Diagnostic<?> diagnostic : diagnostics.getDiagnostics()) {
					s.append("\n" + diagnostic);
				}
				if (s.length() > 0) {
					throw new IOException("Failed to compile " + sourcePath + s.toString());
				}
				System.out.println("Compilation of " + sourcePath + " returned false but no diagnostics");
			}
//			System.out.printf("%6.3f close\n", 0.001 * (System.currentTimeMillis()-base));
			stdFileManager2.close();		// Close the file manager which re-opens automatically
//			System.out.printf("%6.3f forName\n", 0.001 * (System.currentTimeMillis()-base));
		}
		catch (Throwable e) {
			throw e;
		}
	}

	/**
	 * Return a list comprisiing a JavaFileObject for each *.java file in or below folder.
	 * A non-null compilationUnits may be provided for use as the returned list.
	 */
	private static @NonNull List<@NonNull JavaFileObject> gatherCompilationUnits(@NonNull File folder, @Nullable List<@NonNull JavaFileObject> compilationUnits) throws IOException {
		if (compilationUnits == null) {
			compilationUnits = new ArrayList<@NonNull JavaFileObject>();
		}
		for (File file : folder.listFiles()) {
			if (file.isDirectory()) {
				gatherCompilationUnits(file, compilationUnits);
			}
			else if (file.isFile() && file.getName().endsWith(".java")) {
				URI uri = file.getCanonicalFile().toURI();
				compilationUnits.add(new JavaSourceFileObject(uri));
			}
		}
		return compilationUnits;
	}

	private JavaSourceFileObject(@NonNull URI uri) {
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