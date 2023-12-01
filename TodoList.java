import java.util.ArrayList;
// BufferedWriter et File Writer s'utilisent le plus souvent ensemble 
import java.io.BufferedReader;
import java.io.BufferedWriter; // Utilise un tampon pour écrire du texte dans un flux de sortie 
import java.io.FileReader; // Permet de lire un fichier
import java.io.FileWriter; // Permet d'écrire dans un fichier
import java.io.IOException; // Gestion des exception I/O ( entrée / sortie )



public class TodoList {
    private ArrayList<String> tasks;
    private String savedTask;

    public TodoList(String savedTask) {
        this.tasks = new ArrayList<>();
        this.savedTask = savedTask;
        loadTasksFromFile(); // Charger les tâche existantes depuis le fichier 
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Tâche ajoutée : " + task);
        saveTasksToFile(); // Enregistrer la tâche dans savedTask
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Tâche supprimée : " + removedTask);
            saveTasksToFile();
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


    private void loadTasksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(savedTask))){
            String line;
            while((line = reader.readLine()) != null) {
                tasks.add(line);
            }
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement des tâches depuis le fichier : " + e.getMessage());
        }
    }


    private void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(savedTask))) {
            for (String task : tasks) {
                writer.write(task);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de l'enregistrement des tâches dans le fichier : " + e.getMessage());
        }
    }



}

