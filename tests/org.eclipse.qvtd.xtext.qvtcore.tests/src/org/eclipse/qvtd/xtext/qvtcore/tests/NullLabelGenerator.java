package org.eclipse.qvtd.xtext.qvtcore.tests;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;

/**
 * This dummy class is solely used to terminate a plugin extension and so avoid a warning.
 */
public final class NullLabelGenerator extends AbstractLabelGenerator<AllQVTcoreTests>
{
	public NullLabelGenerator() {
		super(AllQVTcoreTests.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull AllQVTcoreTests object) {
		throw new UnsupportedOperationException();
	}
}