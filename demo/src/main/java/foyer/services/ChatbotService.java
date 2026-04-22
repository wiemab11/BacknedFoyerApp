package foyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import foyer.entities.Bloc;
import foyer.repositories.BlocRepository;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatbotService {

    private final BlocRepository blocRepo;

    // pour les tests, vous pouvez laisser la clé API vide ou utiliser une clé de test
    private static final String API_KEY = "VOTRE_CLE_API_ICI";
    private static final String OPENAI_URL = "https://api.openai.com/v1/chat/completions";
    // Méthode principale pour obtenir une réponse du chatbot
    public String getReponse(String question) {
        // 1. Récupérer le contexte depuis la base de données
        List<Bloc> blocs = blocRepo.findAll();
        String contexte = blocs.stream().map(b ->
            "Bloc: " + b.getNomBloc() +
            ", Capacité: " + b.getCapaciteBloc() +
            ", Chambres: " + b.getChambres().size() +
            ", Foyer: " + (b.getFoyer() != null ? b.getFoyer().getNomFoyer() : "non affecté")
        ).collect(Collectors.joining("\n"));

        // 2. Construire le prompt
        String prompt = "Tu es un assistant pour la gestion d'hébergement universitaire. " +
            "Réponds en français de manière empathique et personnalisée.\n" +
            "Données actuelles du système:\n" + contexte +
            "\n\nQuestion de l'étudiant: " + question;

        // 3. Appel API OpenAI
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(API_KEY);

            Map<String, Object> message = new HashMap<>();
            message.put("role", "user");
            message.put("content", prompt);

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", "gpt-3.5-turbo");
            requestBody.put("messages", List.of(message));
            requestBody.put("max_tokens", 500);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
            @SuppressWarnings("unchecked")
            Map<String, Object> response = restTemplate.postForObject(OPENAI_URL, entity, Map.class);

            if (response != null && response.containsKey("choices")) {
                @SuppressWarnings("unchecked")
                List<Map<String, Object>> choices = (List<Map<String, Object>>) response.get("choices");
                Map<String, Object> firstChoice = choices.get(0);
                @SuppressWarnings("unchecked")
                Map<String, String> msg = (Map<String, String>) firstChoice.get("message");
                return msg.get("content");
            }
        } catch (Exception e) {
            // Réponse de secours si l'API n'est pas configurée
            return genererReponseLocale(question, contexte);
        }

        return genererReponseLocale(question, contexte);
    }

    // Méthode de secours pour générer une réponse locale basée sur des règles simples
    private String genererReponseLocale(String question, String contexte) {
        String q = question.toLowerCase();
        if (q.contains("chambre") || q.contains("disponible")) {
            return "Voici les blocs disponibles dans notre système:\n" + contexte +
                   "\n\nJe vous conseille de contacter l'administration pour connaître les disponibilités exactes.";
        }
        if (q.contains("calme") || q.contains("stress")) {
            return "Pour un environnement calme, je vous recommande de choisir une chambre simple " +
                   "dans un bloc éloigné des espaces communs. " +
                   "Voici les blocs disponibles:\n" + contexte;
        }
        if (q.contains("réserver") || q.contains("comment")) {
            return "Pour réserver une chambre: 1) Choisissez un bloc disponible, " +
                   "2) Sélectionnez une chambre selon votre type (Simple, Double, Triple), " +
                   "3) Contactez l'administration avec votre CIN pour finaliser la réservation.";
        }
        return "Bonjour ! Je suis l'assistant du foyer universitaire. " +
               "Voici les informations disponibles:\n" + contexte +
               "\n\nComment puis-je vous aider davantage ?";
    }
}
