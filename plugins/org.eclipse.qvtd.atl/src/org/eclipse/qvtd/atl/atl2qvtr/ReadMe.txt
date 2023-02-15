/org.eclipse.qvtd.build/.launches/Generate QVTd ATL2QVTr Transformation.launch

converts

	/org.eclipse.qvtd.atl/model/ATL2QVTr.qvtr

into

	/_QVTd_CompileQVTrTransformation__atl2qvtr/test-src/org/eclipse/qvtd/atl/atl2qvtr/ATL2QVTr.java
	/_QVTd_CompileQVTrTransformation__atl2qvtr/test-src/org/eclipse/qvtd/atl/atl2qvtr/trace_ATL2QVTr/*

which are manually copied into

/org.eclipse.qvtd.atl/src/org/eclipse/qvtd/atl/atl2qvtr/ATL2QVTr.java
/org.eclipse.qvtd.atl/src/org/eclipse/qvtd/atl/atl2qvtr/trace/*

where missing @Override, unnecessary casts can be bulk-quick-fixed.

(Beware that auto-save modifications on ATL2QVTr.java can be really slow and some cast removals are wrong.)

The QVTrCompilerTests.testQVTrCompiler_ATL2QVTr_CG test is useful for prototyping a NewATL2QVTr.qvtr without
messing everything up till ready. Its artefacts should not be used. Rather a diff of NewATL2QVTr.qvtr
and ATL2QVTr.qvtr should make the improvements available for a regeneration by Generate QVTd ATL2QVTr Transformation.launch
 