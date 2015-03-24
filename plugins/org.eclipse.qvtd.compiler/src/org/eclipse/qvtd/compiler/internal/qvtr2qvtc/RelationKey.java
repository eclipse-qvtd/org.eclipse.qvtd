package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.AbstractBindings.KeySet;

public interface RelationKey {
	
	
	@NonNull KeySet getKeyBindings();

}
