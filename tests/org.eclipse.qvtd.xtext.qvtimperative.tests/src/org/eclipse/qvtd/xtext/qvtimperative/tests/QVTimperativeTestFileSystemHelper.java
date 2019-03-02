package org.eclipse.qvtd.xtext.qvtimperative.tests;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.xtext.qvtbase.tests.QVTbaseTestFileSystemHelper;

public class QVTimperativeTestFileSystemHelper extends QVTbaseTestFileSystemHelper
{
	@Override
	protected @NonNull List<@NonNull String> getRequiredBundles() {
		List<@NonNull String> requiredBundles = super.getRequiredBundles();
		requiredBundles.add("org.eclipse.qvtd.xtext.qvtimperative.tests");
		return requiredBundles;
	}
}