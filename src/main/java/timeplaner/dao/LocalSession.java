package timeplaner.dao;

import timeplaner.entities.subdocuments.AbstractAction;
import timeplaner.entities.subdocuments.impl.Task;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class LocalSession {

    private AbstractAction action;
    static String dateFormat = "yyyy-MM-dd";
    static String stringDate = "2017-05-21";
    static LocalDate toDate = LocalDate.parse(stringDate, DateTimeFormatter.ofPattern(dateFormat));
    private Path path = Paths.get("src/main/resources/");
    private ObjectOutputStream saveObjectStream;
    private ObjectInputStream loadObjectStream;
    private FileInputStream loadFileStream;
    private FileOutputStream saveFileStream;


    public Task findTaskById(Long taskId) throws ParseException, IOException, ClassNotFoundException {
        System.out.println("Try to GET task by id: " + taskId);

        String fileName = path.toString() + "/" + taskId + ".dat"; //todo if getId not null;
        loadFileStream = new FileInputStream(fileName);
        loadObjectStream = new ObjectInputStream(loadFileStream);
        Task loadTask = (Task) loadObjectStream.readObject();
        loadObjectStream.close();
        return loadTask;
    }

    public void saveTask(Task task) throws IOException {
        System.out.println("Try to SAVE task by id: " + task.getId());
        String line = "\\" + task.getId() + ".dat";
        File file = new File(String.valueOf(this.getClass().getResource(line)));
        String fileName = path.toString() + "\\" + task.getId() + ".dat"; //todo if getId not null;

            saveFileStream = new FileOutputStream(fileName);
            saveObjectStream = new ObjectOutputStream(saveFileStream);
            saveObjectStream.writeObject(task);
            saveObjectStream.close();

    }

}
