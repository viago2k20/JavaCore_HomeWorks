package InputOutputStreams_Task1;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        StringBuilder myLog = new StringBuilder();

//        List<String> listDir = new ArrayList<>();
//        listDir.add("Games");
//        listDir.add("Games/src");
//        listDir.add("Games/res");
//        listDir.add("Games/savegames");
//        listDir.add("Games/temp");
//        listDir.add("Games/src/main");
//        listDir.add("Games/src/test");
//        listDir.add("Games/res/drawables");
//        listDir.add("Games/res/vectors");
//        listDir.add("Games/res/icons");
//
//        int count = 0;
//        for (String dir : listDir) {
//
//            File file = new File(dir);
////            file.delete();
//
//            if (file.mkdirs()) {
//                count++;
//                myLog.append(count).append(". ")
//                        .append("Создание директории: ").append(dir).append(" ")
//                        .append("\t").append(LocalDateTime.now())
//                        .append("\n");
//                System.out.println("Директория создана");
//            } else {
//                System.out.println("Директория не создана");
//            }
//        }
//
//        List<String> myFiles = new ArrayList<>();
//        myFiles.add("Games/src/main/Main.java");
//        myFiles.add("Games/src/main/Utils.java");
//        myFiles.add("Games/temp/temp.txt");
//
//        for (String file : myFiles) {
//            count++;
//            File myFile = new File(file);
////            myFile.delete();
//
//            try {
//                if (myFile.createNewFile())
//                    System.out.println("Файл был создан");
//                myLog.append(count).append(". ")
//                        .append("Файл был создан: ").append(file).append(" ")
//                        .append("\t").append(LocalDateTime.now())
//                        .append("\n");
//            } catch (IOException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//        System.out.println(myLog);
//
//        try (FileWriter writer = new FileWriter("Games/temp/temp.txt", false)) {
//            writer.write(String.valueOf(myLog));
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//
        GameProgress game1 = new GameProgress(120, 50, 10, 20);
        GameProgress game2 = new GameProgress(250, 280, 20, 250);
        GameProgress game3 = new GameProgress(3100, 310, 350, 3100);
//        game1.saveGame("Games/savegames/saveGame1.dat", game1);
//        game2.saveGame("Games/savegames/saveGame2.dat", game2);
//        game3.saveGame("Games/savegames/saveGame3.dat", game3);
//
//        GameProgress game11 = null;
//        GameProgress game21 = null;
//        GameProgress game31 = null;
//
//        game11 = game1.loadGame("Games/savegames/saveGame1.dat");
//        game21 = game2.loadGame("Games/savegames/saveGame2.dat");
//        game31 = game3.loadGame("Games/savegames/saveGame3.dat");
//
//        System.out.println(game11);
//        System.out.println(game21);
//        System.out.println(game31);
//
        String zFile = "Games/savegames/zip.zip";
        String file1 = "Games/savegames/saveGame1.dat";
        String file2 = "Games/savegames/saveGame2.dat";
        String file3 = "Games/savegames/saveGame3.dat";

        List<String> toZipList = new ArrayList<>();
        toZipList.add(file1);
        toZipList.add(file2);
        toZipList.add(file3);

//        zipList(zFile, toZipList);


        for (String file : toZipList) {
            File zipFile = new File(file);
            zipFile.delete();
        }

//        unzipFiles("Games/savegames", zFile);

//        File zipFile = new File("saveGame3.dat");
//        zipFile.delete();

//        unzipFiles(".", zFile);


    }


    public static void zipFiles(String path, String file) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path));
             FileInputStream fis = new FileInputStream(file)) {

            ZipEntry entry = new ZipEntry("notes.txt");
            zout.putNextEntry(entry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);

            zout.write(buffer);
            zout.closeEntry();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void zipList(String path, List<String> files) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path))) {
            for (String file : files) {
                File fileToZip = new File(file);
                FileInputStream fis = new FileInputStream(fileToZip);
                ZipEntry entry = new ZipEntry(fileToZip.getName());
                zout.putNextEntry(entry);

                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);

                zout.write(buffer);
                zout.closeEntry();
                fis.close();
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void unzipFiles(String where, String file) {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(file))) {
            ZipEntry entry;
            String name;
            File destinationDir = new File(where);

            while ((entry = zis.getNextEntry()) != null) {
                name = entry.getName();
                File newFile = new File(destinationDir, name);
                FileOutputStream fout = new FileOutputStream(newFile);
                for (int c = zis.read(); c != -1; c = zis.read()) {
                    fout.write(c);
                }
                fout.flush();
                zis.closeEntry();
                fout.close();
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}
