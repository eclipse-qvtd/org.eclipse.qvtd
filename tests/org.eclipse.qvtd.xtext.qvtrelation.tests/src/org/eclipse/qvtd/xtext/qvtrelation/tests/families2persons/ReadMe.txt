ATL uses a different ANTLR to Xtext so we cannot parse *.atl and *.qvtr in the same test plugin.

Families2Persons.atl is therefore independently saved as Families2Persons.atl.xmi for use by the JUnit test.

Tests in the org.eclipse.qvtd.atl.tests plugin use only ATL ANTLR and so can drop a *.atl.xmi.