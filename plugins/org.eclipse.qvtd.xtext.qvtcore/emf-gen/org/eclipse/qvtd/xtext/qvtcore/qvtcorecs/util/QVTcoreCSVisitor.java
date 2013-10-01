/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
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
 * from: org.eclipse.qvtd.xtext.qvtcore/model/QVTcoreCS.genmodel
 *
 * Do not edit it.
 */
package	org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface QVTcoreCSVisitor<R> extends org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.util.QVTcoreBaseCSVisitor<R>
{
	@Nullable R visitMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.MappingCS object);
	@Nullable R visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.TopLevelCS object);
}
