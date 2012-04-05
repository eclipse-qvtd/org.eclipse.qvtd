/**
 * <copyright>
 * 
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: QVTcAnalyzer.java,v 1.5 2010/01/05 11:41:47 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore;

import lpg.runtime.Monitor;

import org.eclipse.qvt.declarative.parser.environment.ICSTFileAnalyzer;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcFileEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcTopLevelEnvironment;

public class QVTcAnalyzer extends AbstractQVTcAnalyzer implements ICSTFileAnalyzer<QVTcTopLevelEnvironment>
{
	public QVTcAnalyzer(QVTcFileEnvironment environment, Monitor monitor) {
		super(new QVTcParser(new QVTcLexer(environment)), monitor);
	}

	public boolean analyze(QVTcTopLevelEnvironment environment) {
		defineTopLevelCS(environment);
		return true;
	}
}
