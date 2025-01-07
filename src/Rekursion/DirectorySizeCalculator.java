package Rekursion;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

public class DirectorySizeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Indtast en mappe sti for at beregne dens størrelse:");
        String path = scanner.nextLine();

        File directory = new File(path);

        // Validering af sti
        if (!isValidPath(directory)) {
            System.out.println("Ugyldig sti eller manglende adgang. Prøv igen.");
            return;
        }

        // Beregning af mappestørrelse
        long size = calculateDirectorySize(directory);

        // Udskriv formateret størrelse
        System.out.println("Den samlede størrelse af mappen er: " + size + " bytes (" + formatSize(size) + ")");
    }

    // Metode til at validere stien
    public static boolean isValidPath(File path) {
        return path.exists() && path.isDirectory() && path.canRead();
    }

    // Rekursiv metode til at beregne mappestørrelse
    public static long calculateDirectorySize(File directory) {
        long size = 0;

        // Hent alle filer og mapper i denne mappe
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isHidden()) {
                    // Ignorer skjulte filer
                    continue;
                }
                if (file.isFile()) {
                    // Base case: hvis det er en fil, tilføj dens størrelse
                    size += file.length();
                } else if (file.isDirectory()) {
                    // Rekursiv case: hvis det er en mappe, kald metoden igen
                    size += calculateDirectorySize(file);
                }
            }
        }

        return size;
    }

    // Metode til at formatere størrelsen i en læsbar form
    public static String formatSize(long size) {
        DecimalFormat df = new DecimalFormat("#.##");
        if (size >= 1_000_000_000) {
            return df.format((double) size / 1_000_000_000) + " GB";
        } else if (size >= 1_000_000) {
            return df.format((double) size / 1_000_000) + " MB";
        } else if (size >= 1_000) {
            return df.format((double) size / 1_000) + " KB";
        } else {
            return size + " bytes";
        }
    }
}
