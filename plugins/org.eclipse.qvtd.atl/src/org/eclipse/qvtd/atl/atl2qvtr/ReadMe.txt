/org.eclipse.qvtd.build/.launches/Generate QVTd ATL2QVTr Transformation.launch

converts

/org.eclipse.qvtd.atl/model/ATL2QVTr.qvtr

into

/_QVTd_CompileQVTrTransformation__atl2qvtr/test-src/org/eclipse/qvtd/atl/atl2qvtr/ATL2QVTr.java
/_QVTd_CompileQVTrTransformation__atl2qvtr/test-src/org/eclipse/qvtd/atl/atl2qvtr/trace_ATL2QVTr/*

which are manually copied into

/org.eclipse.qvtd.atl/src/org/eclipse/qvtd/atl/atl2qvtr/ATL2QVTr.java
/org.eclipse.qvtd.atl/src/org/eclipse/qvtd/atl/atl2qvtr/trace/*

where missing @Override, unnecessary casts can be bulk-quick-fixed
 