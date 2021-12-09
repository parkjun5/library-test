package dev.example.lib.exam;

import java.time.LocalDateTime;

import static dev.example.lib.exam.LibraryConfigParams.*;

public class TestLibrary {
    private LibraryConfig libraryconfig;

    public TestLibrary(LibraryConfig libraryConfig) {
        this.libraryconfig = libraryConfig;
    }

    public String lib(LocalDateTime localDateTime) {
        String name = libraryconfig.getProperty(USER_NAME);

        int hourOfDay = localDateTime.getHour();
        String resultString = "Hello %s, %s";
        if (hourOfDay >= 5 && hourOfDay < 12) {
            return String.format(resultString, name, libraryconfig.get(MORNING_MESSAGE));
        } else if (hourOfDay >= 12 && hourOfDay < 17) {
            return String.format(resultString, name, libraryconfig.get(AFTERNOON_MESSAGE));
        } else if (hourOfDay >= 17 && hourOfDay < 20) {
            return String.format(resultString, name, libraryconfig.get(EVENING_MESSAGE));
        } else {
            return String.format(resultString, name, libraryconfig.get(NIGHT_MESSAGE));
        }
    }

    public String lib() {
        return lib(LocalDateTime.now());
    }
}
