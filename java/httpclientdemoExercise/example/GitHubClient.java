package httpclientdemoExercise.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubClient {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/mita290"))
                .header("User-Agent", "Java HttpClient Demo")
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print response status and body
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Response body:\n" + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
