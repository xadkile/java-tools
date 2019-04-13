package xadkile.tools;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;

public class print {

    private static PrintWriter p;
    static{
        Charset charset = Charset.forName("UTF-8");
        p = new PrintWriter(new OutputStreamWriter(System.out, charset),true);
    }

    public static void setWriter(PrintWriter pw){
        p = pw;
    }

    /**
     * just print, without a new line
     * @param object something to xadkile.utility.print
     * @param <T> object type
     */
    public static <T> void n(T object){
        p.print(object.toString());
        p.flush();
    }

    /**
     * print with new line
     * @param object something to xadkile.utility.print
     * @param <T> object type
     */
    public static <T> void ln(T object){
        p.println(object.toString());
        p.flush();
    }

    /**
     * print format
     * @param format - a string template
     * @param args - value to be used in the template
     */
    public static void f(String format, Object...args){
        String output = String.format(format, args);
        n(output);
    }

    /**
     * print format following by a new line
     * @param format - a string template
     * @param args - values to be used in the template
     */
    public static void fln(String format,Object... args){
        String output = String.format(format,args);
        ln(output);
    }

    /**
     * print a list of objects, each object on one line
     * @param list
     * @param <T>
     */
    public static <T> void list(Collection<T> list){
        for(T ele : list){
            ln(ele.toString());
        }
    }

    public static <K,V> void map(Map<K,V> input){
        for(Map.Entry<K, V> entry : input.entrySet()){
            fln("%s : %s",entry.getKey().toString(),entry.getValue().toString());
        }
    }

    public static <T> void listIndex(Collection<T> list){
        int x = 0;
        for(T ele : list){
            fln("%s: %s", x,ele.toString());
            ++x;
        }
    }

    public static <T> void arrayLn(T[] arr){
        for(T item:arr){
            ln(item);
        }
    }
}
