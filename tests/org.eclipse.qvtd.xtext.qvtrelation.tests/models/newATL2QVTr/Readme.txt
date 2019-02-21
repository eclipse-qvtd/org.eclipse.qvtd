This is a test variant of /org.eclipse.qvtd.atl/model/ATL2QVTr.qvtr

It has a different package path/tx name to avoid ambiguity during development.

Once developed:
- copy it to the true /org.eclipse.qvtd.atl/model/ATL2QVTr.qvtr
- correct package path/tx name
- launch /org.eclipse.qvtd.build/.launches/Generate QVTd ATL2QVTr Transformation.launch
- open the QVTd_CompileQVTrTransformation__atl2qvtr test project
- copy /QVTd_CompileQVTrTransformation__atl2qvtr/test-src/org/eclipse/qvtd/atl/atl2qvtr/trace_ATL2QVTr/*.java
   to /org.eclipse.qvtd.atl/src-gen/org/eclipse/qvtd/atl/atl2qvtr/trace_ATL2QVTr
   - copy /QVTd_CompileQVTrTransformation__atl2qvtr/test-src/org/eclipse/qvtd/atl/atl2qvtr/trace_ATL2QVTr/impl/*.java
   to /org.eclipse.qvtd.atl/src-gen/org/eclipse/qvtd/atl/atl2qvtr/trace_ATL2QVTr/impl
   - copy /QVTd_CompileQVTrTransformation__atl2qvtr/test-src/org/eclipse/qvtd/atl/atl2qvtr/trace_ATL2QVTr/util/*.java
   to /org.eclipse.qvtd.atl/src-gen/org/eclipse/qvtd/atl/atl2qvtr/trace_ATL2QVTr/util
   - copy /QVTd_CompileQVTrTransformation__atl2qvtr/test-src/org/eclipse/qvtd/atl/atl2qvtr/ATL2QVTr.java
   to /org.eclipse.qvtd.atl/src/org/eclipse/qvtd/atl/atl2qvtr