import java.io.File;

public class SystemMonitoring {

    private static void getFreeDiskSpace() {
        File fileSystem = new File(File.listRoots()[0].toURI());
        System.out.println("Total space: " + fileSystem.getTotalSpace() / Math.pow(1024, 3) + " GB");
        System.out.println("Free space: " + fileSystem.getFreeSpace() / Math.pow(1024, 3) + " GB");
        System.out.println("Usable space: " + fileSystem.getUsableSpace() / Math.pow(1024, 3) + " GB");
    }


    private static void printUsage() {
        System.out.println("Available processors (cores): " + Runtime.getRuntime().availableProcessors());
        /* Returns the maximum amount of memory available to the Java Virtual Machine set by the '-mx' or '-Xmx' flags. */
        long maxMemory = Runtime.getRuntime().maxMemory();
        /* Returns the total memory allocated from the system (which can at most reach the maximum memory value returned by the previous function). */
        long totalMemory = Runtime.getRuntime().totalMemory();
        /* Returns the free memory *within* the total memory returned by the previous function. */
        long freeMemory = Runtime.getRuntime().freeMemory();

        System.out.println("Maximum memory (GB): " + (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory / Math.pow(1024, 3) + " GB"));
        System.out.println("Total memory (GB): " + totalMemory / Math.pow(1024, 3) + " GB");
        System.out.println("Free memory (GB): " + freeMemory / Math.pow(1024, 3) + " GB");
    }

    public static void main(String[] args) {
        getFreeDiskSpace();
        printUsage();
    }
}