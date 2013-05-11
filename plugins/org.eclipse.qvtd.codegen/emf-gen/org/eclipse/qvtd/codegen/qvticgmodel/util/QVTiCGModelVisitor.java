/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: model/qvticgmodel.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.codegen.qvticgmodel.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface QVTiCGModelVisitor<R> extends org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor<R>
{
	@Nullable R visitCGEcorePropertyAssignment(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment object);
	@Nullable R visitCGEcoreRealizedVariable(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable object);
	@Nullable R visitCGFunction(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGFunction object);
	@Nullable R visitCGFunctionCallExp(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp object);
	@Nullable R visitCGFunctionParameter(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter object);
	@Nullable R visitCGGuardVariable(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable object);
	@Nullable R visitCGMapping(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMapping object);
	@Nullable R visitCGMappingCall(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall object);
	@Nullable R visitCGMappingCallBinding(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding object);
	@Nullable R visitCGPredicate(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate object);
	@Nullable R visitCGPropertyAssignment(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment object);
	@Nullable R visitCGRealizedVariable(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable object);
	@Nullable R visitCGTransformation(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation object);
	@Nullable R visitCGTypedModel(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel object);
}
