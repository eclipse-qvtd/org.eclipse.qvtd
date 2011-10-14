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
 * $Id: QVTcTextDefaultContentScanner.java,v 1.3 2008/08/18 07:57:40 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtcore.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.qvt.declarative.editor.ui.text.TextColorManager;
import org.eclipse.qvt.declarative.editor.ui.text.TextDefaultContentScanner;

/**
 * Defines a scanner to process the residual NiceXSL partition.
 */
@Deprecated // Use UniversalTextEditor
public class QVTcTextDefaultContentScanner extends TextDefaultContentScanner {
    public QVTcTextDefaultContentScanner(TextColorManager colorManager) {
    	super(colorManager);
    	List<IRule> rules = new ArrayList<IRule>();
    	for (IRule rule : fRules)
    		rules.add(rule);
        rules.add(new MultiLineRule("/*", "*/", colorManager.getMultiLineCommentToken()));
        rules.add(new QVTcTextKeywordRule(colorManager, colorManager.getDefaultContextToken()));
    	IRule[] result = new IRule[rules.size()];
    	rules.toArray(result);
    	setRules(result);
    }
}
