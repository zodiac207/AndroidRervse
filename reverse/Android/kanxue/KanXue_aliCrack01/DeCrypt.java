
public class DeCrypt {

    
    public static void main(String[] argc){

        AppCode appCode=new AppCode();
        String table=appCode.getTableFromPic();
        String pwd=appCode.getPwdFromPic();

        StringBuilder sb = new StringBuilder();
        StringBuilder sa = new StringBuilder();

        for (int i=0;i<pwd.length();i++){
            int index=table.indexOf(pwd.charAt(i));
            sa.append(index);
            sb.append((char)(index));
        }
        System.out.println("索引串："+sa.toString());
        System.out.println("索引转换后的字符串："+sb);


    }
         
 
    

}