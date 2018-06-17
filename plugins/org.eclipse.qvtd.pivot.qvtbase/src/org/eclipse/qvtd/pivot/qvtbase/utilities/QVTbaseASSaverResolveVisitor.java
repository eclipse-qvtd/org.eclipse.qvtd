/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtbase.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.qvtd.pivot.qvtbase.util.AbstractQVTbaseASSaverResolveVisitor;

public class QVTbaseASSaverResolveVisitor extends AbstractQVTbaseASSaverResolveVisitor
{
	public QVTbaseASSaverResolveVisitor(@NonNull ASSaver context) {
		super(context);
	}	
}
