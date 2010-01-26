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
-- The QVTr KeyWord Lexer
--

%options slr
%options fp=QVTrKWLexer,prefix=Char_
%options noserialize
%options package=org.eclipse.qvt.declarative.parser.qvtrelation
%options template=../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/KeywordTemplateF.gi
%options export_terminals=("QVTrParsersym.java", "TK_")
%options include_directory=".;../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg;../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/parser"

%Import
	EssentialOCLKWLexer.gi
%End

%Define
	$copyright_contributions /.*   E.D.Willink - Extended API and implementation for QVTr
*./
%End

%Export
	checkonly
	default_values
	domain
	enforce
	extends
	implementedby
	import
	key
	overrides
	primitive
	query
	relation
	replace
	top
	transformation
	when
	where
%End

%Terminals
	_
%End

%Headers
    /.
        static
        {
            tokenKind['_'] = Char__;
        };
    ./
%End

%Rules

-- The Goal for the parser is a single Keyword

	KeyWord ::=
		  c h e c k o n l y
		/.$BeginAction
			$setResult($_checkonly);
		  $EndAction
		./
		
		| d e f a u l t _ v a l u e s
		/.$BeginAction
			$setResult($_default_values);
		  $EndAction
		./
		
		| d o m a i n
		/.$BeginAction
			$setResult($_domain);
		  $EndAction
		./
		
		| e n f o r c e
		/.$BeginAction
			$setResult($_enforce);
		  $EndAction
		./
		
		| e x t e n d s
		/.$BeginAction
			$setResult($_extends);
		  $EndAction
		./
		
		| i m p l e m e n t e d b y
		/.$BeginAction
			$setResult($_implementedby);
		  $EndAction
		./
		
		| i m p o r t
		/.$BeginAction
			$setResult($_import);
		  $EndAction
		./
		
		| k e y
		/.$BeginAction
			$setResult($_key);
		  $EndAction
		./
		
		| o v e r r i d e s
		/.$BeginAction
			$setResult($_overrides);
		  $EndAction
		./
		
		| p r i m i t i v e
		/.$BeginAction
			$setResult($_primitive);
		  $EndAction
		./
		
		| q u e r y
		/.$BeginAction
			$setResult($_query);
		  $EndAction
		./
		
		| r e l a t i o n
		/.$BeginAction
			$setResult($_relation);
		  $EndAction
		./
		
		| r e p l a c e
		/.$BeginAction
			$setResult($_replace);
		  $EndAction
		./
		
		| t o p
		/.$BeginAction
			$setResult($_top);
		  $EndAction
		./
		
		| t r a n s f o r m a t i o n
		/.$BeginAction
			$setResult($_transformation);
		  $EndAction
		./
		
		| w h e n
		/.$BeginAction
			$setResult($_when);
		  $EndAction
		./
		
		| w h e r e
		/.$BeginAction
			$setResult($_where);
		  $EndAction
		./
%End
