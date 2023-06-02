public class Artist{
   private static String artistName;
   private static int birthYear;
   private static int deathYear;
   // TODO: Declare private fields - artistName, birthYear, deathYear

   // TODO: Define default construct
    // TODO: Declare private fields - artistName, birthYear, deathYear

    // TODO: Define default constructor
    public Artist() {
        artistName = "unknown";
        birthYear = -1;
        deathYear = -1;
    }

    public Artist(String artistName, int birthYear, int deathYear) {
        this.artistName = artistName;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    public static String getName() {
        return artistName;
    }

    public static int getBirthYear() {
        return birthYear;
    }

    public static int getDeathYear() {
        return deathYear;
    }

    public static void printInfo() {
        if (birthYear > 0 && deathYear > 0) {
      System.out.println("Artist: " + artistName + " (" + birthYear + " to " + deathYear+")" );
        } else if (birthYear > 0 && deathYear < 0) {
            System.out.println("Artist: " + artistName + " (" + birthYear + " to present)");
        } else

        {
            System.out.println("Artist: " + artistName+" (unknown)");
        }

    }
}
