package softway.autodiag.autodiag.messages;

import softway.autodiag.autodiag.enums.LanguageEnum;
import softway.autodiag.autodiag.enums.MedicalUnitEnum;

public class Messages {

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

        public Messages(LanguageEnum language) {
                this.language = language;
        }

        public String getString(MedicalUnitEnum id) {
                return messages[language.ordinal()][id.ordinal()];
        }

}
