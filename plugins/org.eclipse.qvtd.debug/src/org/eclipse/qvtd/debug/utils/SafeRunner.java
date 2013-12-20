package org.eclipse.qvtd.debug.utils;


public class SafeRunner {
    public static interface IRunner {
        public void run(BaseProcess.IRunnable r) throws Exception;
    }
    
    public static BaseProcess.IRunnable getSafeRunnable(final BaseProcess.IRunnable r) {
        final IRunner runner = SameThreadRunner.INSTANCE;
        return new BaseProcess.IRunnable() {
            public void run() throws Exception {
                runner.run(r);
            }
        };
    }

    static class SameThreadRunner implements IRunner {
        public void run(BaseProcess.IRunnable r) throws Exception {
            r.run();
        }
        
        static IRunner INSTANCE = new SameThreadRunner();
    }
}