import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Käsklused extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent käsklus) {
        super.onSlashCommandInteraction(käsklus);
        System.out.println("käsklus: /" + käsklus.getName());
        käsklus.reply("No tervist! Mina olen Java Bot").queue();
    }
}
