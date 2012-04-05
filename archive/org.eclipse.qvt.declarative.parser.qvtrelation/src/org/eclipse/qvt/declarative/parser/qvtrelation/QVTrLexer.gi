--/**
-- * <copyright>
-- *
-- * Copyright (c) 2007,2008 E.D.Willink and others.
-- * All rights reserved.   This program and the accompanying materials
-- * are made available under the terms of the Eclipse Public License v1.0
-- * which accompanies this distribution, and is available at
-- * http://www.eclipse.org/legal/epl-v10.html
-- *
-- * Contributors:
-- *   E.D.Willink - Initial API and implementation
-- *
-- * </copyright>
-- */
--
-- The QVTr Lexer
--

%options escape=$
%options la=2
%options fp=QVTrLexer,prefix=Char_
%options single-productions
%options noserialize
%options package=org.eclipse.qvt.declarative.parser.qvtrelation
%options template=../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/LexerTemplateF.gi
%options filter=QVTrKWLexer.gi
%options export_terminals=("QVTrParsersym.java", "TK_")
%options include_directory=".;../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg;../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/parser"

%Import
	EssentialOCLLexer.gi
%End

%Define
	--
	-- Definition of macro used in the included file LexerBasicMap.g
	--
	$kw_lexer_class /.QVTrKWLexer./
    $environment_class /.ICSTFileEnvironment./
    $environment_import /.org.eclipse.qvt.declarative.parser.environment.ICSTFileEnvironment./
	$copyright_contributions /.*   E.D.Willink - Extended API and implementation for QVTr
*./
%End

%Export
	PLUS_PLUS
%End

%Rules

	Token ::= '+' '+'
		/.$BeginAction
					makeToken($_PLUS_PLUS);
		  $EndAction
		./
		
	SLC -> '/' '/'
%End
