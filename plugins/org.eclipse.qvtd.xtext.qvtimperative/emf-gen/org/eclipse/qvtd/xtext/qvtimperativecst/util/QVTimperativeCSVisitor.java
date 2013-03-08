/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: /org.eclipse.qvtd.xtext.qvtimperative/model/QVTimperativeCST.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.xtext.qvtimperativecst.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface QVTimperativeCSVisitor<R> extends org.eclipse.qvtd.xtext.qvtcorebasecst.util.QVTcoreBaseCSVisitor<R>
{
	@Nullable R visitMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecst.MappingCS object);
	@Nullable R visitMappingCallBindingCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecst.MappingCallBindingCS object);
	@Nullable R visitMappingCallCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecst.MappingCallCS object);
	@Nullable R visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecst.TopLevelCS object);
}
