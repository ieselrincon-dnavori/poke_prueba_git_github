import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiJsonViewer {
    public static void main(String[] args) {
        try {
            // Parámetros de consulta
            String endpoint = "pokemon"; // Cambia por 'ability', 'type', etc.
            int limit = 20; // Número de resultados por página
            int offset = 0; // Desplazamiento

            // Construir la URL
            String baseUrl = "https://pokeapi.co/api/v2/";
            String fullUrl = baseUrl + endpoint + "/?limit=" + limit + "&offset=" + offset;

            // Crear cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(fullUrl))
                    .GET()
                    .build();

            // Enviar solicitud y recibir respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Imprimir código de estado y JSON recibido
            System.out.println("Código de respuesta: " + response.statusCode());
            System.out.println("Respuesta JSON:");
            System.out.println(response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

