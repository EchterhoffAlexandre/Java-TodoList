import java.util.Scanner;

class TodoListApp {

    // Déclaration des attributs privés pour la liste de tâches et le scanner
    private TodoList todoList;
    private Scanner scanner;

    // Constructeur de la classe TodoListApp, initialisant la liste de tâche et le scanner
    public TodoListApp() {
        this.todoList = new TodoList();
        this.scanner = new Scanner(System.in);
    }

    // Méthode principale qui crée une instance de TodoListApp et lance la méthode run
    public static void main(String[] args) {
        TodoListApp app = new TodoListApp();
        app.run();
    }

    public void run() {
        int choice;

        do {
            // Afficher le menu
            System.out.println("\n Menu principal : ");
            System.out.println("1. Ajouter une tâche");
            System.out.println("2. Supprimer une tâche");
            System.out.println("3. Afficher les tâches");
            System.out.println("4. Quitter");
            System.out.println("Choisissez une option : ");
            
            // Lire le choix de l'utilisateur 
            choice = scanner.nextInt();

            // Gérer l'option choisie 
            switch (choice) {
                // Gestion d'un ajout de tâche
                case 1:
                    System.out.print("Entrez la tâche à ajouter :");
                    scanner.nextLine(); // Ici on consomme le caractère de nouvelle ligne laissé par la méthode nextInt(). Permet de positionner le scanner correctement
                    String newTask = scanner.nextLine(); // Le scanner est correctement positionner, il va pouvoir lire l'entrée utilisateur
                    todoList.addTask(newTask);
                    break;
                // Gestion d'une suppression de tâche
                case 2: 
                    todoList.displayTasks();
                    System.out.print("Entrez l'index de la tâche à supprimer ");
                    int indexToRemove = scanner.nextInt();
                    todoList.removeTask(indexToRemove - 1);
                    break;
                // Afficher les tâches
                case 3:
                    todoList.displayTasks();
                    break;
                // Quitter la todolist
                case 4:
                    System.out.println("Au revoir");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer");
            }
        } while (choice != 4);
    }

    
}