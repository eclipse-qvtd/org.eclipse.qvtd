/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.editor.ui.text;

import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.qvt.declarative.editor.ui.text.TextColorManager;
import org.eclipse.qvt.declarative.editor.ui.text.TextKeywordDetector;

/**
 * Defines a rule to recognise the QVT keywords.
 */
@Deprecated // Use UniversalTextEditor
public class EssentialOCLTextKeywordRule extends WordRule {

    public EssentialOCLTextKeywordRule(TextColorManager colorManager, IToken defaultToken) {
    	super(new TextKeywordDetector(), defaultToken);
        IToken token = colorManager.getKeywordToken();
        addWord("Bag", token);
        addWord("Boolean", token);
        addWord("Collection", token);
        addWord("Integer", token);
        addWord("Real", token);
        addWord("Invalid", token);
        addWord("OclAny", token);
        addWord("OclInvalid", token);
        addWord("OclMessage", token);
        addWord("OclVoid", token);
        addWord("OrderedSet", token);
        addWord("Sequence", token);
        addWord("Set", token);
        addWord("String", token);
        addWord("Tuple", token);
        addWord("allInstances", token);
        addWord("and", token);
        addWord("any", token);
        addWord("closure", token);
        addWord("collect", token);
        addWord("collectNested", token);
        addWord("context", token);
        addWord("else", token);
        addWord("endif", token);
        addWord("exists", token);
        addWord("false", token);
        addWord("forAll", token);
        addWord("if", token);
        addWord("implies", token);
        addWord("in", token);
        addWord("isUnique", token);
        addWord("iterate", token);
        addWord("let", token);
        addWord("not", token);
        addWord("null", token);
        addWord("oclAsType", token);
        addWord("oclIsKindOf", token);
        addWord("oclIsNew", token);
        addWord("oclIsTypeOf", token);
        addWord("oclIsInState", token);
        addWord("oclIsInvalid", token);
        addWord("oclIsUndefined", token);
        addWord("one", token);
        addWord("or", token);
        addWord("reject", token);
        addWord("select", token);
        addWord("self", token);
        addWord("sortedBy", token);
        addWord("then", token);
        addWord("true", token);
        addWord("xor", token);
    }
}
