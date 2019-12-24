class FtpClient {
 //https://www.baeldung.com/java-ftp-client
    private String server;
    private int port;
    private String user;
    private String password;
    private FTPClient ftp;
 
    // constructor
 
    void open() throws IOException {
        ftp = new FTPClient();
 
        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
 
        ftp.connect(server, port);
        int reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new IOException("Exception in connecting to FTP Server");
        }
 
        ftp.login(user, password);
    }
 
    void close() throws IOException {
        ftp.disconnect();
    }
}
