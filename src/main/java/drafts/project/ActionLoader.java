package drafts.project;

import entities.documents.auxiliary.Priority;
import entities.documents.auxiliary.Status;
import entities.documents.maindocuments.AbstractMainDocument;
import entities.documents.maindocuments.impl.Project;
import entities.documents.subdocuments.AbstractAction;
import entities.documents.subdocuments.impl.Task;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


public class ActionLoader {

    private AbstractAction action;
    static String dateFormat = "yyyy-MM-dd";
    static String stringDate = "2017-05-21";
    static LocalDate toDate = LocalDate.parse(stringDate, DateTimeFormatter.ofPattern(dateFormat));


    public static Task findTaskById(int taskId) throws ParseException {
        System.out.println("Try to retrieve task by id: " + taskId);
        return returnTask();
    }

    private static Task returnTask() throws ParseException {
        String name = "Basic structure for task";
        String description = "Create basic structure GUI for task";
        Period period = Period.between(LocalDate.now(), toDate);

        Task action = new Task(name, description, period);

        action.setPriority(Priority.NORMAL);
        action.setStatus(Status.IN_PROGRESS);
        action.setLinkedSubDocs(returnLinkedTask());
        action.setMainDocument(returMainDoc());
        return action;
    }

    private static List<AbstractAction> returnLinkedTask() {
        String name = "Save/load task locally";
        String description = "Realize plugin for task";
        Period period = Period.between(LocalDate.now(), toDate);
        AbstractAction linkedTask = new Task(name, description, period);
        linkedTask.setPriority(Priority.NORMAL);
        linkedTask.setStatus(Status.OPEN);
        return Arrays.asList(linkedTask);
    }

    private static AbstractMainDocument returMainDoc() {
        String name = "Time Planning";
        AbstractMainDocument mainDocument = new Project();
        mainDocument.setName(name);
        return mainDocument;
    }
}
