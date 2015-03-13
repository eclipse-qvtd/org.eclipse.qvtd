package org.eclipse.qvtd.build.cs2as.qvti;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.values.InvalidValueException;

public class CS2ASException extends InvalidValueException
{
	private static final long serialVersionUID = 1L;

	protected final @NonNull EObject csObject;

	public CS2ASException(@NonNull EObject csObject, @NonNull String message) {
		super(message);
		this.csObject = csObject;
	}

	public @NonNull EObject getCSObject() {
		return csObject;
	}
}
