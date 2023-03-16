import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class kasBotOnline implements EventListener {

    @Override
    public void onEvent(GenericEvent syndmus) {
        if (syndmus instanceof ReadyEvent){
            System.out.println("Bot on valmis ja online");
        }
    }
}
