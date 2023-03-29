import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SündmusedTunniplaanis {

    private String link;
    private List<VEvent> oop = new ArrayList<>();
    private List<VEvent> ab = new ArrayList<>();
    private List<VEvent> tnt = new ArrayList<>();
    private List<VEvent> proge2 = new ArrayList<>();
    private List<VEvent> disk = new ArrayList<>();
    private List<VEvent> mmp = new ArrayList<>();
    private List<VEvent> tundmatud = new ArrayList<>();

    public SündmusedTunniplaanis(String link) {
        this.link = link;
    }

    public void sorteeri() throws IOException {
        File file = new File(link);
        List<ICalendar> kalender = Biweekly.parse(file).all();
        var events = kalender.get(0);

        for (int i = 0; true; i++) {
            try {
                VEvent syndmus = events.getEvents().get(i);
                String[] aine = syndmus.getSummary().getValue().toString().split(" - ");
                switch (aine[0]) {
                    case "Objektorienteeritud programmeerimine" -> oop.add(syndmus);
                    case "Andmebaasid" -> ab.add(syndmus);
                    case "Tõenäosusteooria ja matemaatiline statistika" -> tnt.add(syndmus);
                    case "Programmeerimine II" -> proge2.add(syndmus);
                    case "Diskreetne matemaatika" -> disk.add(syndmus);
                    case "Matemaatiline maailmapilt" -> mmp.add(syndmus);
                    default -> tundmatud.add(syndmus);
                }
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
    }
    public String väljastaSündmused(int aine, String kateg) {
        List<VEvent> kategList;
        StringBuilder lause = new StringBuilder();

        switch (aine) {
            case 1 -> kategList = oop;
            case 2 -> kategList = proge2;
            case 3 -> kategList = ab;
            case 4 -> kategList = tnt;
            case 5 -> kategList = disk;
            case 6 -> kategList = mmp;
            default -> kategList = tundmatud;
        }
        for (int i = 0; i < kategList.size(); i++) {
            boolean samaSyndmus = false;

            VEvent event = kategList.get(i);
            if (i != 0
                    && event.getSummary().getValue().equals(kategList.get(i-1).getSummary().getValue())
                    && event.getDateStart().getValue().equals(kategList.get(i-1).getDateStart().getValue())
                    && event.getDescription().getValue().strip().equals(kategList.get(i-1).getDescription().getValue().strip())){
                samaSyndmus = true;
            }
            var nimi = event.getSummary().getValue();
            var kategooria = event.getCategories().get(0).getValues().toString();
            var kuupaev = event.getDateStart().getValue().toString().split(" ");
            String nadalapaev;
            switch (kuupaev[0]){
                case "Mon" -> nadalapaev = "E ";
                case "Tue" -> nadalapaev = "T ";
                case "Wed" -> nadalapaev = "K ";
                case "Thu" -> nadalapaev = "N ";
                case "Fri" -> nadalapaev = "R ";
                case "Sat" -> nadalapaev = "L ";
                case "Sun" -> nadalapaev = "P ";
                default -> nadalapaev = "? ";
            }


            String kuu;
            switch (kuupaev[1]) {
                case "Jan" -> kuu = ". jaanuar ";
                case "Feb" -> kuu = ". veebruar ";
                case "Mar" -> kuu = ". märts ";
                case "Apr" -> kuu = ". aprill ";
                case "May" -> kuu = ". mai ";
                case "Jun" -> kuu = ". juuni ";
                case "Jul" -> kuu = ". juuli ";
                case "Aug" -> kuu = ". august ";
                case "Sep" -> kuu = ". september ";
                case "Oct" -> kuu = ". oktoober ";
                case "Nov" -> kuu = ". november ";
                case "Dec" -> kuu = ". detsember ";
                default -> kuu = " ? ";
            }
            var aeg = nadalapaev
                    + kuupaev[2]
                    + kuu
                    + kuupaev[3];
            String koht;
            try {
                var osad = event.getLocation().getValue().split(" - ");
                koht = osad[1];
            } catch (Exception e) {
                koht = "Asukoht pole märgitud.";
            }
            var kirjeldus = event.getDescription().getValue().replaceAll("\\s", " ");

            if (kategooria.equals("[" + kateg + "]")) {
                if (!samaSyndmus) {
                    lause.append("\n\n").append("> ").append(nimi)
                            .append("\n> ").append(kategooria)
                            .append("\n> Õisi info: ").append(kirjeldus)
                            .append("\n> Aeg: ").append(aeg)
                            .append("\n> Ruumid: ").append(koht);
                }else lause.append(", ").append(koht);
            }
        }
        if (lause.toString().equals("")) return "\n> Hetkel puudub info tulevaste kontrolltööde osas.";
        return lause.toString();
    }
//    @Override
//    public int compareTo(SündmusedTunniplaanis o) {
//        for (VEvent event : oop){
//            event.getDateStart().getValue().compareTo(o.getDateStart().getValue());
//        }
//    }
}

