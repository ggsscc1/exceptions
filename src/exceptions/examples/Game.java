package exceptions.examples;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Game {

    public void saveGame() {

        try{
            saveProgress();
            saveScore();
            saveStatistics();
        }catch (SaveProgressException ex){
            System.err.println("Can't save progress" + ex.getMessage());
        } catch (SaveScoreException ex) {
            ex.printStackTrace();//System.err.println("Can't save score" + ex.getMessage());
        } catch (SaveStatisticsException ex) {
            System.err.println("Can't save statistics" + ex.getMessage());
        }

    }

    private void saveProgress() throws SaveProgressException {
        try (FileWriter writer = new FileWriter("progress.txt", true)){
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

            writer.append("Guardado").append(now.format(formatter)).append(System.lineSeparator());
        } catch (IOException e) {
            throw new SaveProgressException();
        }
    }

    private void saveScore() throws SaveScoreException {
        try ( FileWriter writer = new FileWriter("score.txt", true)){
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

            writer.append("Guardado").append(now.format(formatter)).append(System.lineSeparator());
            throw new IOException("IO exception de prueba");
        } catch (IOException e) {
            throw new SaveScoreException("El mensaje", e);
        }
    }

    private void saveStatistics() throws SaveStatisticsException {
        try (FileWriter writer = new FileWriter("statistics.txt", true)){
            LocalDateTime now = null;//LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

            writer.append("Guardado").append(now.format(formatter)).append(System.lineSeparator());
        } catch (IOException e) {
            throw new SaveStatisticsException();
        }
        throw new IndexOutOfBoundsException("IndexOutOfBoundsException thrown just because");
    }
    }




