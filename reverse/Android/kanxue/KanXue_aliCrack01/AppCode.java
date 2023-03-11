import java.nio.charset.StandardCharsets;

public class AppCode {
    
    public String getTableFromPic() {
        byte[] is = null;

        is = Utils.readFileInByte("logo.png");
        
        //is.read(b, 0, lenght);
        byte[] data = new byte[768];
        System.arraycopy(is, 89473, data, 0, 768);
        String value = new String(data, StandardCharsets.UTF_8);  
        
        return value;             
       
    }

    public String getPwdFromPic() {
        byte[] is = null;
        is = Utils.readFileInByte("logo.png");
        byte[] data = new byte[18];
        System.arraycopy(is, 91265, data, 0, 18);
        String value = new String(data, StandardCharsets.UTF_8);

        return value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public  String bytesToAliSmsCode(String table, byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (byte b : data) {
            sb.append(table.charAt(b & 255));
        }
        return sb.toString();
    }

    public byte[] aliCodeToBytes(String codeTable, String strCmd) {
        byte[] cmdBuffer = new byte[strCmd.length()];
        for (int i = 0; i < strCmd.length(); i++) {
            char c = strCmd.charAt(i);
            int v = codeTable.indexOf(c);
            cmdBuffer[i] = (byte) v;
        }
        return cmdBuffer;
    }

}
