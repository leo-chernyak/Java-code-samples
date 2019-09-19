package L16_Exceptions_4;

public class GodPunishment extends Exception {

    private static final long serialVersionUID = 4657038752691223705L;

    private String descr = "Just kill all people!";
    public GodPunishment() { }
    public GodPunishment(String ex) {
        super(ex);
        descr = ex + " from now and forever!";
    }
    public String getMessage(){ return descr ;}
}