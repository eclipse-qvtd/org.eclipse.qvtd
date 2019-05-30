/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.tests;

import org.eclipse.qvtd.xtext.qvtbase.tests.QVTbaseTestFileSystemHelper;

public class QVTimperativeTestFileSystemHelper extends QVTbaseTestFileSystemHelper
{
	public QVTimperativeTestFileSystemHelper() {
	//	addRequiredBundle("org.eclipse.qvtd.pivot.qvtbase");
		addRequiredBundle("org.eclipse.qvtd.xtext.qvtimperative.tests");
	}
}