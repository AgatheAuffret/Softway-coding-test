package softway.autodiag.autodiag.messages;

import java.util.List;

public class ErrorMessages {
        private static final List<String> ERRORS_FR = List.of(
                        "L'index de santé saisi ne possède aucune unitée médicale associée",
                        "Le format de l'index de santé saisi est invalide");

        private static final List<String> ERRORS_EN = List.of(
                        "This health index has no associated medical unit",
                        "The format of this health index is incorrect");

        public static final List<List<String>> ERRORS = List.of(ERRORS_FR, ERRORS_EN);
}
