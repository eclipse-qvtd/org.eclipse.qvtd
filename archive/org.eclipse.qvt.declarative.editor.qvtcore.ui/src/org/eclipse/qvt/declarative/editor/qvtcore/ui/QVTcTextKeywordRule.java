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
 * $Id: QVTcTextKeywordRule.java,v 1.3 2008/08/18 07:57:40 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtcore.ui;

import org.eclipse.jface.text.rules.IToken;
import org.eclipse.qvt.declarative.editor.ui.text.EssentialOCLTextKeywordRule;
import org.eclipse.qvt.declarative.editor.ui.text.TextColorManager;

/**
 * Defines a rule to recognise the QVT keywords.
 */
@Deprecated // Use UniversalTextEditor
public class QVTcTextKeywordRule extends EssentialOCLTextKeywordRule {

    public QVTcTextKeywordRule(TextColorManager colorManager, IToken defaultToken) {
    	super(colorManager, defaultToken);
        IToken token = colorManager.getKeywordToken();
        addWord("check", token);
        addWord("creation", token);
        addWord("default", token);
        addWord("deletion", token);
        addWord("enforce", token);
        addWord("imports", token);
        addWord("map", token);
        addWord("query", token);
        addWord("realize", token);
        addWord("refines", token);
        addWord("transformation", token);
        addWord("uses", token);
        addWord("where", token);
    }
}
