/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation based on org.eclipse.xtext.builder.nature.XtextNature
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.ui.builder;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.base.ui.builder.AbstractValidatingBuilder;
import org.eclipse.ocl.xtext.base.ui.builder.AbstractBuildSelector;
import org.eclipse.qvtd.xtext.qvtbase.ui.QVTdProjectHelper;

/**
 * Builder for QVTd contributions. Currently this involves identifying QVTd files subject to
 * extension filtering defined by the excludeExtension/includeExtensions comma-separated file extensionlist
 * and path filtering defined by excludePaths/includepaths comma-separated classpath-style regexes.
 * Default values are supplied as part of the .project buildCommand when the QVTd nature is added.
 *
 * The identified files are passed to a separate MultiValidationJob for concurrent non-blocking validation.
 */
public class QVTdBuilder extends AbstractValidatingBuilder
{
	protected static class QVTdBuildSelector extends AbstractBuildSelector
	{
		public QVTdBuildSelector(@NonNull IProject project, @NonNull BuildType buildType, @Nullable Map<String, String> args, @NonNull IProgressMonitor monitor) {
			super(project, buildType, args, monitor);
		}

		@Override
		protected @NonNull String getMarkerId(@NonNull IFile iFile) {
			String fileExtension = iFile.getFileExtension();
			if ("qvtc".equals(fileExtension)) {
				return "org.eclipse.qvtd.xtext.qvtcore.ui.Marker"; //QVTcoreUiModule.MARKER_ID;
			}
			else if ("qvti".equals(fileExtension)) {
				return "org.eclipse.qvtd.xtext.qvtimperative.ui.Marker"; //QVTimperativeUiModule.MARKER_ID;
			}
			else if ("qvtr".equals(fileExtension)) {
				return "org.eclipse.qvtd.xtext.qvtrelation.ui.Marker"; //QVTrelationUiModule.MARKER_ID;
			}
			else if ("umlx".equals(fileExtension)) {
				return "org.eclipse.qvtd.umlx.ui.Marker"; //...UMLX....MARKER_ID;
			}
			return super.getMarkerId(iFile);
		}
	}

	private static final Logger log = Logger.getLogger(QVTdBuilder.class);
	public static final String BUILDER_ID = QVTdProjectHelper.BUILDER_ID;

	public static void deleteMarkers(@NonNull IProject project, @Nullable Map<String, String> arguments) throws CoreException {
		AbstractBuildSelector buildSelector = new QVTdBuildSelector(project, BuildType.CLEAN, arguments, new NullProgressMonitor());
		buildSelector.selectResources(null);
		buildSelector.deleteMarkers();
	}

	public QVTdBuilder() {
		//		System.out.println(NameUtil.debugSimpleName(this) + " init");
	}

	@Override
	protected @NonNull AbstractBuildSelector createBuildSelector(@NonNull IProject project, @NonNull BuildType buildType,
			@Nullable Map<String, String> args, @NonNull IProgressMonitor monitor) {
		return new QVTdBuildSelector(project, buildType, args, monitor);
	}

	@Override
	protected @NonNull String getBuilderName() {
		return "QVTd";
	}

	@Override
	protected Logger getLog() {
		return log;
	}
}
