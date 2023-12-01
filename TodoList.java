import java.util.ArrayList;


public class TodoList {
    private ArrayList<String> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Tâche ajoutée : " + task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Tâche supprimée : " + removedTask);
        } else {
            System.out.println("Index invalide.");
        }
    }

    public void displayTasks() {
        System.out.println("Liste des tâches :");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }




}

