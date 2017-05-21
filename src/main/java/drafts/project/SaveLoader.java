package drafts.project;

import entities.documents.auxiliary.Priority;
import entities.documents.auxiliary.Status;
import entities.documents.maindocuments.AbstractMainDocument;
import entities.documents.maindocuments.impl.Project;
import entities.documents.subdocuments.AbstractAction;
import entities.documents.subdocuments.impl.Task;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


public class SaveLoader {

    private AbstractAction action;
    static String dateFormat = "yyyy-MM-dd";
    static String stringDate = "2017-05-21";
    static LocalDate toDate = LocalDate.parse(stringDate, DateTimeFormatter.ofPattern(dateFormat));
    private Path path = Paths.get("D:\\Training\\TimePlanning\\src\\main\\resources");
    private ObjectOutputStream saveObjectStream;
    private ObjectInputStream loadObjectStream;
    private FileInputStream loadFileStream;
    private FileOutputStream saveFileStream;


    public Task findTaskById(int taskId) throws ParseException, IOException, ClassNotFoundException {
        System.out.println("Try to GET task by id: " + taskId);

        String fileName = path.toString() + taskId + ".dat"; //todo if getId not null;
        loadFileStream = new FileInputStream(fileName);
        loadObjectStream = new ObjectInputStream(loadFileStream);
        Task loadTask = (Task) loadObjectStream.readObject();
        loadObjectStream.close();
        return loadTask;
    }

    public void saveTask(Task task) throws IOException {
        System.out.println("Try to SAVE task by id: " + task.getId());
        String fileName = path.toString() + task.getId() + ".dat"; //todo if getId not null;
        saveFileStream = new FileOutputStream(fileName);
        saveObjectStream = new ObjectOutputStream(saveFileStream);
        saveObjectStream.writeObject(task);
        saveObjectStream.close();
    }

//    private static Task returnTask() throws ParseException {
//        String name = "Basic structure for task";
//        String description = "Create basic structure GUI for task";
//        Period period = Period.between(LocalDate.now(), toDate);
//
//        Task action = new Task(name, description, period);
//
//        action.setPriority(Priority.NORMAL);
//        action.setStatus(Status.IN_PROGRESS);
//        action.setLinkedSubDocs(returnLinkedTask());
//        action.setMainDocument(returMainDoc());
//        return action;
//    }

//    private static List<AbstractAction> returnLinkedTask() {
//        String name = "Save/load task locally";
//        String description = "Realize plugin for task";
//        Period period = Period.between(LocalDate.now(), toDate);
//        AbstractAction linkedTask = new Task(name, description, period);
//        linkedTask.setPriority(Priority.NORMAL);
//        linkedTask.setStatus(Status.OPEN);
//        return Arrays.asList(linkedTask);
//    }

    private static AbstractMainDocument returMainDoc() {
        String name = "Time Planning";
        AbstractMainDocument mainDocument = new Project();
        mainDocument.setName(name);
        return mainDocument;
    }
}
