package fxdialog;

public class ConnectionInfo {

    private final String host;
    private final String username;
    private final String password;

    public ConnectionInfo(String host,
                          String username,
                          String password) {
        this.host = host;
        this.username = username;
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
