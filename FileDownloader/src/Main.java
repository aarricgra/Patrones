interface Callback {
    void mostrarProgreso(int progreso);
}

class FileDownloader {
    public void downloadFile(String filePath, Callback callback) {
        // simular progreso de descarga
        for (int percentage = 0; percentage <= 100; percentage += 10) {

            // actualizar el progresso cada 10%
            callback.mostrarProgreso(percentage);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        FileDownloader fileDownloader = new FileDownloader();
        fileDownloader.downloadFile("http://.../myFile.txt", new Callback() {
            @Override
            public void mostrarProgreso(int progreso) {
                System.out.println("Descarga " + progreso + "%");
            }
        });
    }
}
