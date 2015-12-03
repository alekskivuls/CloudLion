package cloudlion.theme;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Generatemenus {
   

    public Generatemenus() {
        String[][] themeData = {
            {"Chrome", null, null},
            {"Clouds", null, null},
            {"Crimson Editor", null, null},
            {"Dawn", null, null},
            {"Dreamweaver", null, null},
            {"Eclipse", null, null},
            {"IPlastic", null, null},
            {"Solarized Light", null, null},
            {"TextMate", null, null},
            {"Tomorrow", null, null},
            {"XCode", null, null},
            {"Kuroir", null, null},
            {"KatzenMilch", null, null},
            {"SQL Server", "sqlserver", "light"},
            {"Ambiance", "ambiance", "dark"},
            {"Chaos", "chaos", "dark"},
            {"Clouds Midnight", "clouds_midnight", "dark"},
            {"Cobalt", "cobalt", "dark"},
            {"idle Fingers", "idle_fingers", "dark"},
            {"krTheme", "kr_theme", "dark"},
            {"Merbivore", "merbivore", "dark"},
            {"Merbivore Soft", "merbivore_soft", "dark"},
            {"Mono Industrial", "mono_industrial", "dark"},
            {"Pastel on dark", "pastel_on_dark", "dark"},
            {"Solarized Dark", "solarized_dark", "dark"},
            {"Terminal", "terminal", "dark"},
            {"Tomorrow Night", "tomorrow_night", "dark"},
            {"Tomorrow Night Blue", "tomorrow_night_blue", "dark"},
            {"Tomorrow Night Bright", "tomorrow_night_bright", "dark"},
            {"Tomorrow Night 80s", "tomorrow_night_eighties", "dark"},
            {"Twilight", "twilight", "dark"},
            {"Vibrant Ink", "vibrant_ink", "dark"}};
        generateFile("themeOption.html", themeData);
    }

    private void generateFile(String fileName, String[][] array) {
        //<option value="katzenmilch" name="theme" onclick="setTheme()">Katzenmilch</option>
        try {
            PrintWriter printWriter = new PrintWriter(fileName);
            for (int i = 0; i < array.length; i++) {
                String generatedLine;
                if (array[i][1] == null) {
                    generatedLine = "<option value=\"" + array[i][0].toLowerCase() + "\" name=\"theme\" onclick=\"setTheme()\">" + array[i][0] + "</option>";
                    printWriter.println(generatedLine);
                }
                if (array[i][1] != null) {
                    generatedLine = "<option value=\"" + array[i][1] + "\" name=\"theme\" onclick=\"setTheme()\">" + array[i][0] + "</option>";
                    printWriter.println(generatedLine);
                }
            }
            printWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Generatemenus.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
