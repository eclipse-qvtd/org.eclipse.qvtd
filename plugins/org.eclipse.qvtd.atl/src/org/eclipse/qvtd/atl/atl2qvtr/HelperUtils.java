package org.eclipse.qvtd.atl.atl2qvtr;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.m2m.atl.common.ATL.Module;
import org.eclipse.ocl.pivot.evaluation.Executor;

public class HelperUtils
{
	public static org.eclipse.ocl.pivot.@Nullable Package getPackage(@NonNull Executor executor, @NonNull Module atlModule, @NonNull String packageName) {
		for (String comment : atlModule.getCommentsBefore()) {
			String trimmedComment = comment.trim();
			if (trimmedComment.startsWith("--")) {
				trimmedComment = trimmedComment.substring(2).trim();
				if (trimmedComment.startsWith("@nsURI")) {
					trimmedComment = trimmedComment.substring(6).trim();
					int index = trimmedComment.indexOf("=");
					if (index >= 0) {
						String key = trimmedComment.substring(0, index).trim();
						if (key.equals(packageName)) {
							String value = trimmedComment.substring(index+1).trim();
						}
					}
				}
				else if (trimmedComment.startsWith("@path")) {
					trimmedComment = trimmedComment.substring(5).trim();
					int index = trimmedComment.indexOf("=");
					if (index >= 0) {
						String key = trimmedComment.substring(0, index).trim();
						if (key.equals(packageName)) {
							String value = trimmedComment.substring(index+1).trim();
							URI uri = URI.createPlatformResourceURI(value, true);
							if (!uri.hasFragment()) {
								uri = uri.appendFragment("/");
							}
							EObject eObject = executor.getEnvironmentFactory().getResourceSet().getEObject(uri, true);
							return executor.getEnvironmentFactory().getMetamodelManager().getASOfEcore(org.eclipse.ocl.pivot.Package.class, eObject);
						}
					}
				}
			}
		}
		return null;
	}

	public static org.eclipse.ocl.pivot.@Nullable Class getClass(@NonNull Executor executor, @NonNull Module atlModule,
			@NonNull String packageName, @NonNull String className) {
		org.eclipse.ocl.pivot.@Nullable Package asPackage = getPackage(executor, atlModule, packageName);
		if (asPackage != null) {
			org.eclipse.ocl.pivot.Class asClass = asPackage.getOwnedClass(className);
			if (asClass != null) {
				return asClass;
			}
		}
		return null;
	}
}
