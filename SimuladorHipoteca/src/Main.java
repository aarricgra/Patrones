import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class SimuladorHipoteca {
    interface Callback {
        void onSuccess(double result);
        void onError(String message);
    }


    static void calcularCuota(double capital, double plazo, Callback callback) {
        if (capital <= 0) {
            callback.onError("Capital no válido");
            return;
        }
        if (plazo <= 0) {
            callback.onError("Plazo no válido");
            return;
        }

        double interes = 0;

        try {
            // obtener 'interes' del banco...
            interes = Double.parseDouble(HttpClient.newHttpClient().send(HttpRequest.newBuilder()
                    .uri(URI.create("https://fakebank-tan.vercel.app/api/get-interest"))
                    .GET().build(), HttpResponse.BodyHandlers.ofString()).body());
        } catch (Exception e) {
            callback.onError("Error obteniendo interés");
            return;
        }

        double cuota = capital*interes/12/(1-Math.pow(1+(interes/12),-plazo*12));
        callback.onSuccess(cuota);
    }
}


public class Main {
    public static void main(String[] args) {
        SimuladorHipoteca.calcularCuota(2000, 2, new SimuladorHipoteca.Callback() {
            @Override
            public void onSuccess(double result) {
                System.out.println(result);
            }

            @Override
            public void onError(String message) {
                System.err.println(message);
            }
        });
    }
}
