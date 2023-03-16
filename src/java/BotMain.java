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

        JDABuilder botiEhitaja = JDABuilder.createDefault(TOKEN);
        JDA bot = botiEhitaja
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(new kasBotOnline(), new SõnumiteLugeja(), new Käsklused())
                .build();

        bot.upsertCommand("tere", "Tere tere vana kere").setGuildOnly(true).queue();
    }
}
