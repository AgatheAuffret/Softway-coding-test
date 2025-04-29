package softway.autodiag.autodiag.ressources;

import softway.autodiag.autodiag.model.LanguageEnum;
import softway.autodiag.autodiag.model.MedicalUnitEnum;

public class RessourceMessages {

        private String[][] messages = {
                        // FR strings
                        {
                                        "Cardiologie",
                                        "Traumatologie",
                        },

                        // EN strings
                        {
                                        "Cardiology",
                                        "Trauma",
                        }
        };

        private LanguageEnum language;

        public RessourceMessages(LanguageEnum language) {
                this.language = language;
        }

        public String getString(MedicalUnitEnum id) {
                return messages[language.ordinal()][id.ordinal()];
        }

}
