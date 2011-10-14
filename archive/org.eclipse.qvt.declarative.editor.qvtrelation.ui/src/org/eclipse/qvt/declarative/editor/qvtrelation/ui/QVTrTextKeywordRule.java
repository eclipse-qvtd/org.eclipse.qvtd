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
 * $Id: QVTrTextKeywordRule.java,v 1.3 2008/08/18 07:57:37 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtrelation.ui;

import org.eclipse.jface.text.rules.IToken;
import org.eclipse.qvt.declarative.editor.ui.text.EssentialOCLTextKeywordRule;
import org.eclipse.qvt.declarative.editor.ui.text.TextColorManager;

/**
 * Defines a rule to recognise the QVT keywords.
 */
@Deprecated // Use UniversalTextEditor
public class QVTrTextKeywordRule extends EssentialOCLTextKeywordRule {

    public QVTrTextKeywordRule(TextColorManager colorManager, IToken defaultToken) {
    	super(colorManager, defaultToken);
        IToken token = colorManager.getKeywordToken();
        addWord("checkonly", token);
        addWord("default_values", token);
        addWord("domain", token);
        addWord("enforce", token);
        addWord("extends", token);
        addWord("implementedby", token);
        addWord("import", token);
        addWord("key", token);
        addWord("overrides", token);
        addWord("primitive", token);
        addWord("query", token);
        addWord("relation", token);
        addWord("replace", token);
        addWord("top", token);
        addWord("transformation", token);
        addWord("when", token);
        addWord("where", token);
    }
}
