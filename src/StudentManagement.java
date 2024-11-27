import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentManagement implements Management {

    // Afficher tous les étudiants
    @Override
    public void displayStudents(List<Etudiant> students, Consumer<Etudiant> con) {
        System.out.println(con);
    }

    // Afficher les étudiants en fonction d'un filtre
    @Override
    public void displayStudentsByFilter(List<Etudiant> students, Predicate<Etudiant> pre, Consumer<Etudiant> con) {
        students.stream()
                .filter(pre)
                .forEach(con);
    }

    // Retourner les noms des étudiants
    @Override
    public String returnStudentsNames(List<Etudiant> students, Function<Etudiant, String> fun) {
        return students.stream()
                .map(fun)
                .collect(Collectors.joining(", "));
    }

    // Créer un étudiant à l'aide d'un fournisseur (Supplier)
    @Override
    public Etudiant createStudent(Supplier<Etudiant> sup) {
        return sup.get();
    }

    // Trier les étudiants par ID
    @Override
    public List<Etudiant> sortStudentsById(List<Etudiant> students, Comparator<Etudiant> com) {
        return students.stream()
                .sorted(com)
                .collect(Collectors.toList());
    }

    // Convertir une liste d'étudiants en un Stream
    @Override
    public Stream<Etudiant> convertToStream(List<Etudiant> students) {
        return students.stream();
    }
}
