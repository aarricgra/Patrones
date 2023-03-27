import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrinterSpooler {
    private static PrinterSpooler INSTANCE = new PrinterSpooler();
    int jobCount;

    private PrinterSpooler() {
        jobCount = 0;
    }

    static synchronized PrinterSpooler getInstance(){
        if(INSTANCE==null){
            INSTANCE=new PrinterSpooler();
        }
        return INSTANCE;
    }

    synchronized void printJob(String job) {
        System.out.println("Printing job " + (++jobCount) + ": " + job);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PrinterSpooler printerSpooler=PrinterSpooler.getInstance();

        List<Callable<Void>> printOrders = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            final int docid = i;
            printOrders.add(() -> {
               printerSpooler.printJob("Document" + docid);
                return null;
            });
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.invokeAll(printOrders);
        executorService.shutdown();

        System.out.println("FINISHED. Jobs printed: " + printerSpooler.jobCount);
    }
}