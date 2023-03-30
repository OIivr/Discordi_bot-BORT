import java.util.List;

public class Tervitused {

    public static String genereeriTervitussõna(List<String> str){  // Genereerib suvalise arvu, mille põhjal valib suvalise tervitussõna.
       return str.get((int) (Math.random() * str.size()));
    }
    public static String genereeriTervituslause(List<String> str){ // Genereerib suvalise arvu, mille põhjal valib suvalise tervituslause.
        return str.get((int) (Math.random() * str.size()));
    }

}
