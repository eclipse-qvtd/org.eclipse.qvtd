/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
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
 * from: org.eclipse.qvtd.xtext.qvtimperative/model/QVTimperativeCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtimperativecs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 */
public interface DecorableQVTimperativeCSVisitor<R> extends QVTimperativeCSVisitor<R>, org.eclipse.qvtd.xtext.qvtcorebasecs.util.DecorableQVTcoreBaseCSVisitor<R>
{
	@Override
	void setUndecoratedVisitor(org.eclipse.ocl.xtext.basecs.util.@NonNull BaseCSVisitor<R> visitor);
}
