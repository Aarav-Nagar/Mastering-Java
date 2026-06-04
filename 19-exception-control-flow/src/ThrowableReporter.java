public final class ThrowableReporter {
    private ThrowableReporter() {
    }

    public static void printSummary(Throwable throwable) {
        System.out.println("Type: " + throwable.getClass().getSimpleName());
        System.out.println("Message: " + throwable.getMessage());

        StackTraceElement[] trace = throwable.getStackTrace();
        int framesToShow = Math.min(3, trace.length);
        for (int index = 0; index < framesToShow; index++) {
            StackTraceElement frame = trace[index];
            System.out.println("  at " + frame.getClassName() + "." + frame.getMethodName()
                    + "(" + frame.getFileName() + ":" + frame.getLineNumber() + ")");
        }
    }
}
