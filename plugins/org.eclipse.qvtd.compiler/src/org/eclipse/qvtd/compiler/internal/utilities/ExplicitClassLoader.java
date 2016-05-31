package org.eclipse.qvtd.compiler.internal.utilities;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * ExplicitClassLoader supports loading all classes sharing a qualifiedClassNamePrefix from an explicitClassPath.
 * This may be used to load classes not on the normal classpath or to reload classes that may have changed since
 * previously loaded.
 * <p>
 * The technical approach of:
 * <br>load *.class as byte[],
 * <br>defineClass to transform byte[] to Class<?>
 * <p>
 * is motivated by http://www.toptal.com/java/java-wizardry-101-a-guide-to-java-class-reloading.
 */
class ExplicitClassLoader extends ClassLoader // FIXME duplicates OCL to provide fallBackClassLoader
{
	protected final @NonNull File explicitClassPath;
	protected final @NonNull String qualifiedClassNamePrefix;
	private final @NonNull Map<String, Class<?>> hitsAndMisses = new HashMap<String, Class<?>>();	// Miss signalled by ExplicitClassLoader.class
	protected final @NonNull ClassLoader fallBackClassLoader;
	
	public ExplicitClassLoader(@NonNull File explicitClassPath, @NonNull String qualifiedClassNamePrefix, @NonNull ClassLoader fallBackClassLoader) {
		this.explicitClassPath = explicitClassPath;
		this.qualifiedClassNamePrefix = qualifiedClassNamePrefix;
		this.fallBackClassLoader = fallBackClassLoader;
	}

	/**
	 * Re-implement to load any class sharing qualifiedClassNamePrefix from the explicitClassPath.
	 * Other classes are loaded normally.
	 */
	@Override
	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		if (name.startsWith(qualifiedClassNamePrefix)) {
			Class<?> hitOrMiss = hitsAndMisses.get(name);
			if (hitOrMiss != null) {
				if (hitOrMiss == ExplicitClassLoader.class) {
					throw new ClassNotFoundException("Attempted reload of '" + name + "' failed");
				}
				else {
					return hitOrMiss;
				}
			}
			try {
				hitOrMiss = loadExplicitClass(name, resolve);
				hitsAndMisses.put(name, hitOrMiss);
				return hitOrMiss;
			} catch (IOException e) {
				hitsAndMisses.put(name, ExplicitClassLoader.class);
				throw new ClassNotFoundException(e.getMessage(), e);
			}
		}
		else {
			return fallBackClassLoader.loadClass(name);
		}
	}

	/**
	 * Load the class whose Java name is qualifiedClassName and whose class file can be found below explicitClassPath.
	 * This method always loads the class and so ignores any previously cached loads. 
	 */
	private @Nullable Class<?> loadExplicitClass(@NonNull String qualifiedClassName, boolean resolve) throws ClassNotFoundException, IOException {
		String filePath = qualifiedClassName.replaceAll("\\.", "/") + ".class";
		File classFile = new File(explicitClassPath, filePath);
		FileInputStream inputStream = new FileInputStream(classFile);
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		try {
            int bytes;
            byte[] byteArray = new byte[16384];
            while ((bytes = inputStream.read(byteArray)) >= 0) {
            	byteStream.write(byteArray, 0, bytes);
            }
		}
		finally {
			try {
				inputStream.close();
			} catch (IOException e) {}
		}
        byte[] classBytes = byteStream.toByteArray();
		Class<?> theClass = defineClass(qualifiedClassName, classBytes, 0, classBytes.length);
		if (theClass == null) {
			return null;
		}
		Package thePackage = theClass.getPackage();
		if (thePackage == null) {
			String packageName = qualifiedClassName.replaceAll("\\.\\w+$", "");
			definePackage(packageName, null, null, null, null, null, null, null);
		}
		if (resolve) {
			resolveClass(theClass);
		}
		return theClass;
	}
}