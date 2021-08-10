package fxdialog;

import javafx.util.StringConverter;

class ConnectionInfoStringConverter extends StringConverter<ConnectionInfo> {

    private final String format = "%s@%s:%s";

    @Override
    public String toString(ConnectionInfo c) {
        return String.format( format, c.getUsername(), c.getPassword(), c.getHost() );
    }

    @Override
    public ConnectionInfo fromString(String s) {

        if( s != null && s.contains("@") && s.contains(":") ) {
            String[] toks = s.split("@");
            String username = toks[0];
            String[] secondPart = toks[1].split(":");
            String password = secondPart[0];
            String host = secondPart[1];
            ConnectionInfo ci = new ConnectionInfo(
                    username, password, host
            );
            return ci;
        }

        return null;
    }
}
