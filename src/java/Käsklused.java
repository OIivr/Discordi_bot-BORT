import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Käsklused extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent käsklus) {
        super.onSlashCommandInteraction(käsklus);

        System.out.println("käsklust /" + käsklus.getName() + " kasutas: " + käsklus.getUser().getAsTag());  // Väljastab (Java keskkonnas) info, mis näitab, kes millist käsklust kasutas.

        SündmusedTunniplaanis sündmusedTunniplaanis = new SündmusedTunniplaanis("/Users/dariusko/Desktop/OOP/ois2-calendar-et.ics"); // /Users/oliverpikani/Projects/biweekly/ois2-calendar-et (2).ics | /Users/dariusko/Desktop/OOP/ois2-calendar-et.ics
        try {                                                                                                                             // Bot leiab sündmused kalendrifailist, mis peab olema boti asukohaga samas kaustas, seega peab boti tööle panija lisama oma lingi arguementi.
            sündmusedTunniplaanis.sorteeri();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // TERVITAMISE OSA

        List<String> tervitussõnad = new ArrayList<>();
        List<String> tervituslaused = new ArrayList<>();

        Collections.addAll(tervitussõnad, "Tere! ", "Hei! "
                , "Hei-hei! ", "👋 Hei-hei! ", "👋 Hei! ", "👋 Tere!"
                , "Ahoi!", "Tsau! ", "Tervist! ", "Tere tere! ", "Tsauki! "
                , "👋 Tervitus! ", "Tervitus! ", "👋 Tsau! ");

        Collections.addAll(tervituslaused,
                Tervitused.genereeriTervitussõna(tervitussõnad) + käsklus.getUser().getAsMention() + "\n> Mina olen Bort ja aitan sind sinu ajaplaneerimisega 😇",
                Tervitused.genereeriTervitussõna(tervitussõnad) + käsklus.getUser().getAsMention() + "\n> Mina olen Bort ja ma olen sinu abimees planeerimiseks Discordis!",
                Tervitused.genereeriTervitussõna(tervitussõnad) + käsklus.getUser().getAsMention() + "\n> Mina olen Bort ja ma oskan sind aidata!");

        switch (käsklus.getName()) {

            /**
             * Kui käsklus on saadud, rakendub sellele vastav rida, mille järgselt
             * .reply abil saadab bot sõnumi Discordi, selle meetodi sisu sisaldab saadetavat sõnumit, mis on
             * üles ehitatud siinses programmis loodud meetodite abil.
             */
            case "tere" ->
                    käsklus.reply("> " + Tervitused.genereeriTervituslause(tervituslaused) + Motivatsioon.genereeri()).queue();
            case "oop" -> käsklus.reply(Tervitused.genereeriTervitussõna(tervitussõnad)
                    + "\nSiin on OOP-i kontrolltööde ajad:"
                    + sündmusedTunniplaanis.väljastaSündmused(1, "kontrolltöö")).queue();
            case "proge2" -> käsklus.reply(Tervitused.genereeriTervitussõna(tervitussõnad)
                    + "\nSiin on Proge 2 kontrolltööde ajad:"
                    + sündmusedTunniplaanis.väljastaSündmused(2, "kontrolltöö")).queue();
            case "andmebaasid" -> käsklus.reply(Tervitused.genereeriTervitussõna(tervitussõnad)
                    + "\nSiin on Andmebaaside kontrolltööde ajad:"
                    + sündmusedTunniplaanis.väljastaSündmused(3, "kontrolltöö")).queue();
            case "tnt" -> käsklus.reply(Tervitused.genereeriTervitussõna(tervitussõnad)
                    + "\nSiin on Tõenäosusteooria ja matemaatilise statistika kontrolltööde ajad:"
                    + sündmusedTunniplaanis.väljastaSündmused(4, "kontrolltöö")).queue();
            case "diskmat" -> käsklus.reply(Tervitused.genereeriTervitussõna(tervitussõnad)
                    + "\nSiin on Diskreetse matemaatika kontrolltööde ajad:"
                    + sündmusedTunniplaanis.väljastaSündmused(5, "kontrolltöö")).queue();
            case "kt" -> käsklus.reply(Tervitused.genereeriTervitussõna(tervitussõnad)
                    + "\nSiin on järgmine kalendris leitav kontrolltöö:"
                    + sündmusedTunniplaanis.väljastaSündmused(7, "kontrolltöö") + Motivatsioon.genereeri()).queue();
            case "next" -> käsklus.reply(Tervitused.genereeriTervitussõna(tervitussõnad)
                    + "\nSiin on järgmine kalendris leitav kontrolltöö:"
                    + sündmusedTunniplaanis.väljastaSündmused(7, "kontrolltöö") + Motivatsioon.genereeri()).queue();
            case "help" -> käsklus.reply(Tervitused.genereeriTervituslause(tervituslaused) + " Selleks, et mind kasutada, on olemas erinevad käsud: " +
                    "\n> /help -> Praegu kasutatud käsk" +
                    "\n> /tere -> Tervitab käsu kasutajat :)" +
                    "\n> /oop -> Väljastab aines 'Objektorienteeritud Programmeerimine' tulevate kontrolltööde info" +
                    "\n> /proge2 -> Väljastab aines 'Programmeerimine II' tulevate kontrolltööde info"+
                    "\n> /andmebaasid -> Väljastab aines 'Andmebaasid' tulevate kontrolltööde info " +
                    "\n> /tnt -> Väljastab aines 'Tõenäosusteeoria ja matemaatiline statistika' tulevate kontrolltööde info " +
                    "\n> /diskmat -> Väljastab aines 'Diskreetne matemaatika I' tulevate kontrolltööde info " +
                    "\n> /kt või /next -> Väljastab järgmise tunniplaanis leitava kontrolltöö info").queue();
        }
    }
}
