import java.util.Random;
import java.io.*;
import java.util.*;

public class testconverter {

    public static void main(String args[]) throws IOException {
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            //in = new BufferedReader (new InputStreamReader(System.in));
            in = new BufferedReader (new FileReader("svgimgdata.in"));
            out = new BufferedWriter(new FileWriter("bezierequations.out"));

            double xinit = 0;
            double yinit = 0;

            int i=0;
            while(i<3000){
                
  
                String st = in.readLine();
                //String st = str.replace("\t", "");

                //System.out.println(st);
                if(st.length()==0 || st == null){
                    System.out.println("out");
                    i++;
                    continue;
                }
                char n = (st.charAt(0));
                String s = st.substring(1);

                //StringTokenizer tokenizer = new StringTokenizer(in.readLine());
                //String n = Integer.parseInt(tokenizer.nextToken());

                if(n=='C'){
                    String[] coordinates = s.split(" ");

                    String x1y1 = coordinates[0];
                    String x2y2 = coordinates[1];
                    String xfinyfin = coordinates[2];

                    String[] x1y1split = x1y1.split(",");
                    String[] x2y2split = x2y2.split(",");
                    String[] xfinyfinsplit = xfinyfin.split(",");

                    out.write(String.valueOf("(B(t," + xinit + "," + Double.parseDouble(x1y1split[0]) + "," + Double.parseDouble(x2y2split[0])
                    + "," + Double.parseDouble(xfinyfinsplit[0]) + "), D(t," + yinit + ","  + Double.parseDouble(x1y1split[1]) + "," + Double.parseDouble(x2y2split[1])
                    + "," + Double.parseDouble(xfinyfinsplit[1]) + "))") + '\n');

                    xinit = Double.parseDouble(xfinyfinsplit[0]);
                    yinit = Double.parseDouble(xfinyfinsplit[1]);

                }else if(n=='M'){
                    String[] initpoint = s.split(",");
                    //System.out.println(initpoint[0]);
                    xinit = Double.parseDouble(initpoint[0]);
                    yinit = Double.parseDouble(initpoint[1]);

                }else{
                    i++;
                    continue;
                    
                }

                if(st.equals("</svg>")){
                    break;
                }
                i++;
            }
            
            //int n = Integer.parseInt(st.nextToken());


        }finally{
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

    }
}
