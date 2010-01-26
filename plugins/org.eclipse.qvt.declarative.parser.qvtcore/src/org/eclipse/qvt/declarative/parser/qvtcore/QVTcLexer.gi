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
-- The QVTc Lexer
--

%options escape=$
%options la=2
%options fp=QVTcLexer,prefix=Char_
%options single-productions
%options noserialize
%options package=org.eclipse.qvt.declarative.parser.qvtcore
%options template=../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/LexerTemplateF.gi
%options filter=QVTcKWLexer.gi
%options export_terminals=("QVTcParsersym.java", "TK_")
%options include_directory=".;../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg;../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/parser"

%Import
	EssentialOCLLexer.gi
%End

%Define
	$kw_lexer_class /.QVTcKWLexer./
    $environment_class /.ICSTFileEnvironment./
    $environment_import /.org.eclipse.qvt.declarative.parser.environment.ICSTFileEnvironment./
	$copyright_contributions /.*   E.D.Willink - Extended API and implementation for QVTc
*./
%End

%Export
	COLON_EQUALS
%End

%Rules

	Token ::= ':' '='
		/.$BeginAction
					makeToken($_COLON_EQUALS);
		  $EndAction
		./
		
	SLC -> '/' '/'
%End
