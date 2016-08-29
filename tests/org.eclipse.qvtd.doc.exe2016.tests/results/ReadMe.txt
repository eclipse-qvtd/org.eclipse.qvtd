The draft submission motivated a rewrite of QVTm2QVTp as a QVTs2QVTs optimization with speculation
enabling both QVTr and QVTc results to be reported for the camera ready submission.

A little profiling enabled many gratuitous Sets to be eliminated or replaced by Lists resulting in
dramatically improved results.

Oops. A hand tweak of Set.Accumulator construction to use ArrayList rather than HashSet was just an experiment.
The subsequent "[exe2016] Set ConnectionVariables do not need Set enforcement" commit remedies this.

Oops. The QVTc Interpreted tests did not work. This was debugged for the camera ready submission
where the QVTc Interpreted results are worse than the draft submission. The cause is gratuitous
type checking that can be fixed by the availability of static analysis in QVTa rather than QVTi.
