import net.dv8tion.jda.api.JDABuilder;

public class BotMain {
    public static void main(String[] args) {
        final String TOKEN = "MTA4NTk1ODc2NDAzNDgwNTgyMQ.Gqg7xM.QGXtZxxDcxoDBZ3pwitGQ11YiZdeQU7yCGlpK0";
        JDABuilder botiEhitaja = JDABuilder.createDefault(TOKEN);
        botiEhitaja.build();
    }
}
