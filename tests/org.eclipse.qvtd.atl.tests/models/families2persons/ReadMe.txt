To update Families2Persons_expected.qvtras, run the QVTd ATL tests to generate a new
/_QVTd_ATLExampleTests__testATL2QVTr_Families2Persons_CG/Families2Persons_CG.qvtras.

Copy it to this folder and diff.

To eliminate gratuitous errorts replace all "../org.eclipse.qvtd.atl.tests/models/families2persons/" by
"platform:/resource/org.eclipse.qvtd.atl.tests/models/families2persons/"

Residual differences can then be migrated change by change.