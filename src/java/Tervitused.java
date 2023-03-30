import java.util.List;

public class Tervitused {

    public static String genereeriTervitussõna(List<String> str){
       return str.get((int) (Math.random() * (str.size() + 1)));
    }
    public static String genereeriTervituslause(List<String> str){
        return str.get((int) (Math.random() * (str.size() + 1)));
    }

}
