The QVTrCompilerTests.testQVTrCompiler_ATL2QVTr_CG JUnit test is useful for prototyping a NewATL2QVTr.qvtr without
corrupting the org.eclipse.qvtd.atl files until a development is complete (and tested).
The /_QVTd_QVTrCompilerTests__testQVTrCompiler_ATL2QVTr_CG artefacts should not be used other than as part of the
testQVTrCompiler_ATL2QVTr_CG test.

-----

Once prototyped, a diff of NewATL2QVTr.qvtr and ATL2QVTr.qvtr should make the improvements available for a regeneration
by /org.eclipse.qvtd.build/.launches/Generate QVTd ATL2QVTr Transformation.launch which converts

/org.eclipse.qvtd.atl/model/ATL2QVTr.qvtr

into

/_QVTd_CompileQVTrTransformation__atl2qvtr/test-src/org/eclipse/qvtd/atl/atl2qvtr/ATL2QVTr.java
/_QVTd_CompileQVTrTransformation__atl2qvtr/test-src/org/eclipse/qvtd/atl/atl2qvtr/trace_ATL2QVTr/*

(NB Historically / confusingly it was QVTd_CompileQVTrTransformation__atl2qvtr)

These should be manually copied into

/org.eclipse.qvtd.atl/src/org/eclipse/qvtd/atl/atl2qvtr/ATL2QVTr.java
/org.eclipse.qvtd.atl/src/org/eclipse/qvtd/atl/atl2qvtr/trace/*
/org.eclipse.qvtd.atl/src/org/eclipse/qvtd/atl/atl2qvtr/trace/impl/*
/org.eclipse.qvtd.atl/src/org/eclipse/qvtd/atl/atl2qvtr/trace/util/*

where missing @Override, unnecessary casts can be bulk-quick-fixed

-----

Once refreshed /org.eclipse.qvtd.atl/src/org/eclipse/qvtd/atl/atl2qvtr/ATL2QVTr.java may  be tested by
All QVTd ATL Tests which is not part of All QVTd Tests (standalone) to avoid conflict between the distinct
ANTLR version required by ATL and Xtext.
 