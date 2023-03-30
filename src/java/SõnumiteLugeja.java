import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * Kuvab konsooli info selle kohta, kes ja mis commandi kasutas
 */
public class SõnumiteLugeja extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent sõnum) {
        super.onMessageReceived(sõnum);

        System.out.println("Kasutaja kirjutas: " + sõnum.getMessage().getContentDisplay());
    }
}
