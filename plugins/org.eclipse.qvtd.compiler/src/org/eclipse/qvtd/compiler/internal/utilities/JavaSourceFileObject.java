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
import java.util.Collections;
import java.util.List;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.ExplicitClassLoader;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;

/**
 * JavaSourceFileObject supports use of a File as a Java compilation unit.
 *
 * The compileClasses utility method support compilation of a source package and subpackages.
 */
public final class JavaSourceFileObject extends SimpleJavaFileObject
{
	public static void compileClass(@NonNull String sourcePath, @NonNull String javaCodeSource, @NonNull String objectPath, @Nullable List<@NonNull String> classpathProjects) throws IOException {
		List<@NonNull JavaFileObject> compilationUnits = Collections.singletonList(new OCL2JavaFileObject(sourcePath, javaCodeSource));
		JavaFileUtil.compileClasses(compilationUnits, sourcePath, objectPath, classpathProjects);
	}

	/**
	 * Compile all *.java files on sourcePath to objectPath.
	 * e.g. from ../xyzzy/src/a/b/c to ../xyzzy/bin
	 */
	public static void compileClasses(@NonNull String sourcePath, @NonNull String objectPath, @Nullable List<@NonNull String> classpathProjects) throws IOException {
		try {
			List<@NonNull JavaFileObject> compilationUnits = gatherCompilationUnits(new File(sourcePath), null);
			JavaFileUtil.compileClasses(compilationUnits, sourcePath, objectPath, classpathProjects);
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

	private JavaSourceFileObject(java.net.@NonNull URI uri) {
		super(uri, Kind.SOURCE);
	}

	@Override
	public @NonNull CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
		char[] buf = new char[4096];
		StringBuilder s = new StringBuilder();
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