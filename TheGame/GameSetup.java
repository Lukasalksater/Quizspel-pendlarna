package TheGame;
import java.util.ArrayList;
import java.util.List;

public class GameSetup {

    private static final List<Question> Musikfrågor = new ArrayList<>();
    public static List<Question> getMusikfrågor() {
        return Musikfrågor;
    }


    private static final List<Question> Spelfrågor = new ArrayList<>();
    public static List<Question> getSpelfrågor() {
        return Spelfrågor;
    }


    private static final List<Question> Geografifrågor = new ArrayList<>();


      public static List<Question> getGeografifrågor() {
        return Geografifrågor;
    }


    public static void initializeQuestions() {
    
     // Musikkategorin
     Musikfrågor.add(new Question("Vilket av följande album har Madonna inte gjort?",
             List.of("Music", "Like a Prayer", " Control", "Like a Virgin"), 3));
     Musikfrågor.add(new Question("Hur många gånger har Sverige vunnit Eurovision Song Contest? ",
              List.of("4", "5", "6", "7"), 4));
     Musikfrågor.add(new Question("Vilken musiklegendar vann Nobelpriset i litteratur 2016? ",
              List.of("Leonard Cohen", "Joni Mitchell", "Bob Dylan", "Smokey Robinson"), 3));
      Musikfrågor.add(new Question("I vilket landskap brukar Sweden Rock Festival arrangeras?",
              List.of("Blekinge", "Dalarna", "Småland", "Värmland"), 1));
      Musikfrågor.add(new Question("Vilken artist heter egentligen Reginald Dwight?",
                List.of("Elton John", "Bono", "Bob Dylan", "Freddie Mercury"), 1));



        
        // Spelkategorin
        Spelfrågor.add(new Question("Vilket spel är känt för att ha utvecklats av Mojang och handlar om att bygga och överleva i en öppen värld? ",
             List.of("Cube World", " Rust", "Starbound ", "Minecraft"), 4));
        Spelfrågor.add(new Question("Vilket spel är känt för att ha en blockig, pixlig grafikstil och låter spelarna bygga sina egna världar? ",
              List.of("Terraria ", "Stardew Valley ", "Castle Crashers ", " Spelunky"), 1));
        Spelfrågor.add(new Question("Vad är namnet på det första spelet i The Elder Scrolls-serien? ",
             List.of("Skyrim", "Oblivion", "Daggerfall ", "Morrowind "), 3));
        Spelfrågor.add(new Question("Vad heter huvudkaraktären i spelet \"The Legend of Zelda\"?",
              List.of("Link", "Mario", " Sonic", " Zelda"), 1));
        Spelfrågor.add(new Question(" Vilket företag är känd för att ha skapat Super Mario Bros.?",
             List.of("Sega", "Nintendo", "Sony", "Microsoft "), 2));


       
        // Geografikategorin
        Geografifrågor.add(new Question("Vilken stad är huvudstad i Australien?",
                List.of("Sydney", "Melbourne", "Canberra", "Brisbane"), 3));
        Geografifrågor.add(new Question("Vilket land är känt för att ha den största öknen i världen? ",
                List.of( "Australien", "Saudi arabien", "USA", "Algeriet"), 4));
        Geografifrågor.add(new Question(" Vilket land har den längsta kustlinjen i världen? ",
                List.of("Ryssland", "Kanada", "Kina", "Indien"), 2));
        Geografifrågor.add(new Question("Vilket land är känt för att ha den högsta vattenfallet i världen?",
                List.of("Kanada", "Mexico", "Venezuela", "Brasilien"), 3));
         Geografifrågor.add(new Question(" Vilket land är känt för att ha den högsta bergstoppen i världen?",
                List.of("Nepal", "Pakistan", "Kina", "Indien"), 1));

    
}
}
