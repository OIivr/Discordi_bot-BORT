public class Motivatsioon {
    public static String genereeri() {
        String mot1 = "Ära unusta võtta aega ka iseendale!";
        String mot2 = "Kõik rasked ajad mööduvad!";
        String mot3 = "Kõik läheb hästi!";
        String valik = ""; // Kui motivatsiooni ei genereerita, tuleb tagastada tühi sõne.
        double valikuNumber = Math.random();

        /**
         * Valib suvalise motiveeriva lause, iga ühe tõenäosusega 10%. 70% juhtudest lauset ei genereerita, seega motiveeriva lause saamine on juhuslik.
         */
        if (valikuNumber < 0.1)
            valik = "\n\n> Siin on sulle üks motiveeriv lause: " + mot1;
        else if (valikuNumber < 0.2)
            valik = "\n\n> Siin on sulle üks motiveeriv lause: " + mot2;
        else if (valikuNumber < 0.3)
            valik = "\n\n> Siin on sulle üks motiveeriv lause: " + mot3;
        return valik;
    }
}
