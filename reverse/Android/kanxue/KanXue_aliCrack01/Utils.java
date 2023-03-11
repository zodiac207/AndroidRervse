import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

//个性化工具类
public class Utils {
   // 将字节转换为16进制 
    public static String bytesToHexString(byte[] byteSrc){
        
        StringBuilder hexMagic = new StringBuilder();
        for (byte aByte : byteSrc) {
            int decData = (int) aByte & 0xff;               // bytes widen to int, need mask, prevent sign extension
                                                            // get last 8 bits
            String hex = Integer.toHexString(decData);
            if (hex.length() % 2 == 1) {                    // if half hex, pad with zero, e.g \t
                hex = "0" + hex;
            }
            hexMagic.append(hex);            
        }

        return hexMagic.toString();
    }

    //将字节转换为10进制数字 字符串
    public static String bytesToDecString(byte[] byteSrc){
        StringBuilder byteString = new StringBuilder();
        for (byte aByte : byteSrc) {
            int decData = (int) aByte & 0xff;               // bytes widen to int, need mask, prevent sign extension
                                                            // get last 8 bits
            String hex = Integer.toHexString(decData);
            if (hex.length() % 2 == 1) {                    // if half hex, pad with zero, e.g \t
                hex = "0" + hex;
            }
            byteString.insert(0,hex);            
        }

        int  result = Integer.parseInt(byteString.toString(),16);
        return  String.valueOf(result);
    }

    //将字节转换为10进制数字 
    public static Integer bytesToDecInt(byte[] byteSrc){
        StringBuilder byteString = new StringBuilder();
        for (byte aByte : byteSrc) {
            int decData = (int) aByte & 0xff;               // bytes widen to int, need mask, prevent sign extension
                                                            // get last 8 bits
            String hex = Integer.toHexString(decData);
            if (hex.length() % 2 == 1) {                    // if half hex, pad with zero, e.g \t
                hex = "0" + hex;
            }
            byteString.insert(0,hex);            
        }

        int  result = (int)Long.parseLong(byteString.toString(),16);
        return  result;
    }

    // 从一个字节变量 截取 指定位置与长度的数据
    public static byte[] copyByte(byte[] byteSrc,int pos,int len){
        byte[] byteDest = new byte[len];
        System.arraycopy(byteSrc,pos,byteDest,0,len);
        return byteDest;
    }
    //读取文件的字节数据
    public static byte[]  readFileInByte(String fileName){

        byte[] byteSrc=null;
        FileInputStream fis=null;
        ByteArrayOutputStream bos=null;

        try{
            fis=new FileInputStream(fileName);
            bos = new ByteArrayOutputStream();
            byte[] buffer=new byte[1024];
            int len=0;
            while((len=fis.read(buffer))!=-1){
                bos.write(buffer,0,len);
                
            }
            byteSrc=bos.toByteArray();
        }
        catch(Exception e){
            System.out.println("Read file  error:"+e.toString());

        }
        finally{

            try{
            fis.close();
            bos.close();
            }
            catch(Exception e){}
        }

        return byteSrc;
    }


   

}
