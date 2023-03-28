import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Käsklused extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent käsklus) {
        super.onSlashCommandInteraction(käsklus);

        System.out.println("käsklust /" + käsklus.getName() + " kasutas: " + käsklus.getUser().getAsTag());

        // TERVITAMISE OSA

        List<String> tervitussõnad = new ArrayList<>();
        List<String> tervituslaused = new ArrayList<>();

        tervitussõnad.add("Tere! ");
        tervitussõnad.add("Hei! ");
        tervitussõnad.add("Hei-hei! ");
        tervitussõnad.add("👋 Hei! ");
        tervitussõnad.add("👋 Tere!");
        tervitussõnad.add("👋👋");
        tervitussõnad.add("Tsau! ");
        tervitussõnad.add("Tervist! ");
        tervitussõnad.add("Tere tere! ");

        tervituslaused.add(Tervitused.genereeriTervitussõna(tervitussõnad) + käsklus.getUser().getAsMention() + "\nMina olen Bort ja aitan sind sinu ajaplaneerimisega 😇");
        tervituslaused.add(Tervitused.genereeriTervitussõna(tervitussõnad) + käsklus.getUser().getAsMention() + "\nMina olen Bort ja ma olen sinu abimees planerimiseks Discordis!");
        tervituslaused.add(Tervitused.genereeriTervitussõna(tervitussõnad) + käsklus.getUser().getAsMention() +  "\nMina olen Bort ja ma oskan sind aidata!");


        switch (käsklus.getName()) {
            case "tere":
                käsklus.reply("> " + Tervitused.genereeriTervituslause(tervituslaused)).queue();

            case "oop":
                käsklus.reply("> " + Tervitused.genereeriTervitussõna(tervitussõnad) + "\nSiin on OOP-i kontrolltööde ajad:").queue();

            case "proge2":
                käsklus.reply("> " + Tervitused.genereeriTervitussõna(tervitussõnad) + "\nSiin on Proge 2 kontrolltööde ajad:").queue();

            case "andmebaasid":
                käsklus.reply("> " + Tervitused.genereeriTervitussõna(tervitussõnad) + "\nSiin on Andmebaaside kontrolltööde ajad:").queue();

            case "tntms":
                käsklus.reply("> " + Tervitused.genereeriTervitussõna(tervitussõnad) + "\nSiin on Tõenäosusteooria ja matemaatilise statistika kontrolltööde ajad:").queue();

            case "tnt":
                käsklus.reply("> " + Tervitused.genereeriTervitussõna(tervitussõnad) + "\nSiin on Tõenäosusteooria ja matemaatilise statistika kontrolltööde ajad:").queue();

            case "diskmat":
                käsklus.reply("> " + Tervitused.genereeriTervitussõna(tervitussõnad) + "\nSiin on Diskreetse matemaatika kontrolltööde ajad:").queue();

        }
    }
}
