--/**
-- * Copyright (c) 2007,2008 E.D.Willink and others.
-- * All rights reserved.   This program and the accompanying materials
-- * are made available under the terms of the Eclipse Public License v1.0
-- * which accompanies this distribution, and is available at
-- * http://www.eclipse.org/legal/epl-v10.html
-- *
-- * Contributors:
-- *   E.D.Willink - Initial API and implementation
-- */
--
-- The QVTc KeyWord Lexer
--

%options slr
%options fp=QVTcKWLexer,prefix=Char_
%options noserialize
%options package=org.eclipse.qvt.declarative.parser.qvtcore
%options template=../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/KeywordTemplateF.gi
%options export_terminals=("QVTcParsersym.java", "TK_")
%options include_directory=".;../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg;../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/parser"

%Import
	EssentialOCLKWLexer.gi
%End

%Define
	$copyright_contributions /.*   E.D.Willink - Extended API and implementation for QVTc
*./
%End

%Export
	check
	creation
	default
	deletion
	enforce
	imports
	map
	query
	realize
	refines
	transformation
	uses
	where
%End

%Rules

-- The Goal for the parser is a single Keyword

	KeyWord ::=
		  c h e c k
		/.$BeginAction
			$setResult($_check);
		  $EndAction
		./
		
		| c r e a t i o n
		/.$BeginAction
			$setResult($_creation);
		  $EndAction
		./
		
		| d e f a u l t
		/.$BeginAction
			$setResult($_default);
		  $EndAction
		./
		
		| d e l e t i o n
		/.$BeginAction
			$setResult($_deletion);
		  $EndAction
		./
		
		| e n f o r c e
		/.$BeginAction
			$setResult($_enforce);
		  $EndAction
		./
		
		| i m p o r t s
		/.$BeginAction
			$setResult($_imports);
		  $EndAction
		./
		
		| m a p
		/.$BeginAction
			$setResult($_map);
		  $EndAction
		./
		
		| q u e r y
		/.$BeginAction
			$setResult($_query);
		  $EndAction
		./
		
		| r e a l i z e
		/.$BeginAction
			$setResult($_realize);
		  $EndAction
		./
		
		| r e f i n e s
		/.$BeginAction
			$setResult($_refines);
		  $EndAction
		./
		
		| t r a n s f o r m a t i o n
		/.$BeginAction
			$setResult($_transformation);
		  $EndAction
		./
		
		| u s e s
		/.$BeginAction
			$setResult($_uses);
		  $EndAction
		./
		
		| w h e r e
		/.$BeginAction
			$setResult($_where);
		  $EndAction
		./
%End
