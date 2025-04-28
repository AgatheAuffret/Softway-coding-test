package softway.autodiag.autodiag.messages;

import softway.autodiag.autodiag.enums.LanguageEnum;

public class ErrorMessages {
        private String[][] messages = {
                        // FR strings
                        {
                                        "L'index de santé saisi ne possède aucune unitée médicale associée",
                                        "Le format de l'index de santé saisi est invalide"
                        },

                        // EN strings
                        { "This health index has no associated medical unit",
                                        "The format of this health index is incorrect"
                        }
        };

        private LanguageEnum language;

        public ErrorMessages(LanguageEnum language) {
                this.language = language;
        }

        public String getString(int id) {
                return messages[language.ordinal()][id];
        }

}
