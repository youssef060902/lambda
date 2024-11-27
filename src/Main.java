import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentManagement manager = new StudentManagement();
        List<Etudiant> students = new ArrayList<>();

        // Ajouter des étudiants
        students.add(new Etudiant(3, "Ali", 21));
        students.add(new Etudiant(1, "Sami", 22));
        students.add(new Etudiant(2, "Noura", 20));

        // Afficher tous les étudiants
        System.out.println("Liste des étudiants :");
        manager.displayStudents(students, System.out::println);

        // Afficher les étudiants avec un âge > 20
        System.out.println("\nÉtudiants avec un âge > 20 :");
        manager.displayStudentsByFilter(students, e -> e.getAge() > 20, System.out::println);

        // Retourner les noms des étudiants
        System.out.println("\nNoms des étudiants :");
        String names = manager.returnStudentsNames(students, Etudiant::getNom);
        System.out.println(names);

        // Créer un nouvel étudiant
        Etudiant newStudent = manager.createStudent(() -> new Etudiant(4, "Khaled", 23));
        students.add(newStudent);

        // Trier les étudiants par ID
        System.out.println("\nÉtudiants triés par ID :");
        List<Etudiant> sortedStudents = manager.sortStudentsById(students, Comparator.comparingInt(Etudiant::getId));
        manager.displayStudents(sortedStudents, System.out::println);

        // Convertir en Stream et afficher
        System.out.println("\nStream des étudiants :");
        manager.convertToStream(students).forEach(System.out::println);
    }
}
