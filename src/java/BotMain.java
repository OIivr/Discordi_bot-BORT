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
            System.out.println("Faili ei leitud.");
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args){

        final String TOKEN = loeTokenfailist("/Users/oliverpikani/Projects/token.txt"); // /Users/oliverpikani/Projects/token.txt  | /Users/dariusko/Desktop/OOP/token.txt

        JDABuilder botiEhitaja = JDABuilder.createDefault(TOKEN); // Loob boti isendi tokeni järgi.
        JDA bot = botiEhitaja
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(new kasBotOnline(), new Käsklused())
                .build();

        // BOTI COMMANDIDE OSA

        bot.upsertCommand("tere", "Tervitussõnum").setGuildOnly(true).queue();
        bot.upsertCommand("oop", "OOP-i kontrolltööde ajad").setGuildOnly(true).queue();
        bot.upsertCommand("proge2", "Programmeerimine 2 kontrolltööde ajad").setGuildOnly(true).queue();
        bot.upsertCommand("andmebaasid", "Andmebaasid kontrolltööde ajad").setGuildOnly(true).queue();
        bot.upsertCommand("diskmat", "Diskreetse matemaatika kontrolltööde ajad").setGuildOnly(true).queue();
        bot.upsertCommand("tnt", "Tõenäosusteooria ja matemaatilise statistika kontrolltööde ajad").setGuildOnly(true).queue();
        bot.upsertCommand("jargmine", "Järgmise kontrolltöö aeg").setGuildOnly(true).queue();
    }
}
