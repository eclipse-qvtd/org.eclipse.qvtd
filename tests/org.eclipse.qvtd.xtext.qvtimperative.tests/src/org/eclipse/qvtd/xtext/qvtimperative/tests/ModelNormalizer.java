package org.eclipse.qvtd.xtext.qvtimperative.tests;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase.Normalizer;

public interface ModelNormalizer {
	@NonNull List<Normalizer> normalize(@NonNull Resource resource);
}
