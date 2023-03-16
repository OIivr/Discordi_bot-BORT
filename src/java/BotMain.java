import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BotMain {

    public static String loeTokenfailist(String misfail) {
        try {
            File fail = new File(misfail);
            Scanner scanner = new Scanner(fail);
            return scanner.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("Faili ei leidnud.");
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {

        final String TOKEN = loeTokenfailist("/Users/oliverpikani/Projects/token.txt");// < -- oma token faili tee

        JDABuilder jdaBuilder = JDABuilder.createDefault(TOKEN);
        JDA jda = jdaBuilder
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(new kasBotOnline(), new SõnumiteLugeja(), new Käsklused())
                .build();

        jda.upsertCommand("tere", "Tere tere vana kere").setGuildOnly(true).queue();
    }
}
