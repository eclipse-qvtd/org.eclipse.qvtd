Original work did not use BigMDE2016 as a launch prefix polluting the launch dialog. Also shared ATL/EMFTVM source requiring a per-run edit.

Reworked to match EXE2016. Results very similar except the QVTc CG is three times slower.
a) because Function calls are now cached
b) because of gratuitous debug message formatting

Fixing b) gets the results back much as before.

Declaring the queries as 'transient' and we see a further five-fold speed-up from EXE 2016 enhancements.