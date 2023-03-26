import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Käsklused extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent käsklus) {
        super.onSlashCommandInteraction(käsklus);
        System.out.println("käsklust /" + käsklus.getName() + " kasutas: " + käsklus.getUser().getAsTag());

        switch (käsklus.getName()){
            case "tere":
                käsklus.reply("> No tervist! Mina olen Java Bot").queue();

            case "oop":
                käsklus.reply("> Siin on OOP-i kontrolltööde ajad:").queue();

            case "proge2":
                käsklus.reply("> Siin on Proge 2 kontrolltööde ajad:").queue();

            case "andmebaasid":
                käsklus.reply("> Siin on Andmebaaside kontrolltööde ajad:").queue();

            case "tntms":
                käsklus.reply("> Siin on Tõenäosusteooria ja matemaatilise statistika kontrolltööde ajad:").queue();

            case "diskmat":
                käsklus.reply("> Siin on Diskreetse matemaatika kontrolltööde ajad:").queue();

        }
    }
}
