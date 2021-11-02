import java.util.ArrayList;
import java.util.Random;


class Student {

    public String studentNo;
    public String Imie;
    public String Nazwisko;
    public String Status;

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentNo() {
        return this.studentNo;
    }
    public void setImie(String Imie) {
        this.Imie = Imie;
    }

    public String getImie() {
        return this.Imie;
    }
    public void setNazwisko(String Nazwisko) {
        this.Nazwisko = Nazwisko;
    }

    public String getNazwisko() {
        return this.Nazwisko;
    }
    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getStatus() {
        return this.Status;
    }


}

    public class lab02 {

        static int students_count = 10;

        public static void main(String[] args) {
            ArrayList<Student> students = new ArrayList<>();

            for (int i = 0; i < students_count; i++) {
                Student student = new Student();
                student.setStudentNo(getRandomStudentNumber());
                student.setImie(getRandomStudentImie());
                student.setNazwisko(getRandomStudentNazwisko());
                student.setStatus(getRandomStudentStatus());

                students.add(student);
            }
//================================================WYPISUJE WSZYSTKICH STUDENTÓW===================================
            System.out.println("Wszyscy studenci.");

            for (Student student : students) {
                System.out.println(student.getStudentNo() + ", " + student.getImie() + ", " + student.getNazwisko() + ", "
                        + student.getStatus());
            }
//================================================WYPISUJE AKTYWNYCH STUDENTÓW====================================
            System.out.println("\nAktywni studenci.");

            for (Student student : students) {
                if(student.getStatus().equals("Aktywny"))
                System.out.println(student.getStudentNo() + ", " + student.getImie() + ", " + student.getNazwisko() + ", "
                        + student.getStatus());
            }
        }
//====================================================GENERUJE INDEKSY============================================

        protected static String getRandomStudentNumber() {
            Random rand = new Random();
            return String.valueOf(rand.nextInt(2000) + 38000);
        }
//====================================================GENERUJE IMIĘ===============================================

        protected static String getRandomStudentImie() {
            Random rand = new Random();
            String[] imie ={"Bartek","Mateusz","Szymon","Alicja","Kasia","Wojtek","Zuza","Tadeusz","Kamil","Sara",
            "Ula","Paweł","Adrian","Michał"};
            return imie[rand.nextInt(imie.length)];
        }
//====================================================GENERUJE NAZWISKO===========================================

        protected static String getRandomStudentNazwisko() {
            Random rand = new Random();
            String[] nazwisko ={"Karpiak","Ziemanski","Szymanski","Korka","Zaraza","Szuja","Tola","Tadeusz","Jabko",
                    "Żuraw","Listek","Lipa"};
            return nazwisko[rand.nextInt(nazwisko.length)];
        }
//====================================================GENERUJE STATUS=============================================

        protected static String getRandomStudentStatus() {
            Random rand = new Random();
            String Status="Nieaktywny";
            if(rand.nextBoolean()){
            Status="Aktywny";
            }
            return Status;
        }
//================================================================================================================
    }
