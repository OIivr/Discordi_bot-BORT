import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class kasBotOnline implements EventListener {

    /**
     * Kontrollib, kas bot on valmis ja online
     * boti "ehitamisel" rakendame seda meetodit, kui instanceof ReadyEvent siis bot töötab
     */
    @Override
    public void onEvent(GenericEvent syndmus) {
        if (syndmus instanceof ReadyEvent){
            System.out.println("Bot on valmis ja online");
        }
    }
}
