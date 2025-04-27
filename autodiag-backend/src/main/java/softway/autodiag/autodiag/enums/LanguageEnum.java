package softway.autodiag.autodiag.enums;

public enum LanguageEnum {
    FR(0),
    EN(1);

    private final int code;

    LanguageEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
