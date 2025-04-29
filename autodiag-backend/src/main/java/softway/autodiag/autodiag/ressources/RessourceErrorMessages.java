package softway.autodiag.autodiag.ressources;

import softway.autodiag.autodiag.model.ErrorEnum;
import softway.autodiag.autodiag.model.LanguageEnum;

public class RessourceErrorMessages {
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

        public RessourceErrorMessages(LanguageEnum language) {
                this.language = language;
        }

        public String getString(ErrorEnum error) {
                return messages[language.ordinal()][error.ordinal()];
        }

}
