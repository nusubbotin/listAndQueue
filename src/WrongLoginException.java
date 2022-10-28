public class WrongLoginException extends Exception {
    private String login;

    public WrongLoginException(Throwable cause) {
        super(cause);
    }

    public WrongLoginException(String s, String login) {
        super(s);
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}