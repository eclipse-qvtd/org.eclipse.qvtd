package org.eclipse.qvtd.build.qvtrtoqvtc;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.AbstractBindings.KeySet;

public interface RelationKey {
	
	
	@NonNull KeySet getKeyBindings();

}
