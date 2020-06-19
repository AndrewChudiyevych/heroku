package edu.andrew.kursach.dataSet;

import edu.andrew.kursach.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataSet {
    private List<Patient> patients = new ArrayList<>(Arrays.asList(
            new Patient("1", '1', "adada", "asdad", "+3802424242"),
            new Patient("2", '2', "saddw", "wdwad", "+3801314444"),
            new Patient("3", '3', "Andrew", "wdwad", "+380138894444")
    ));

    public static void getDoctors(Doctor doctor) {
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    private List<Doctor> doctors = new ArrayList<>(Arrays.asList(
            new Doctor("1","ikik", "assda", "adada", "+3802131313", '2'),
            new Doctor("2","olkjhgf", "assda", "saddw", "+380821931", '3'),
            new Doctor("3","ergh", "assda", "gfhfh", "+3809421414", '5')
    ));

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }


    private List<Diseases> diseases = new ArrayList<>(Arrays.asList(
            new Diseases("1","adadad", "sdsdsd", "adada"),
            new Diseases("2","asdafe", "dfggg", "saddw"),
            new Diseases("3","gfhtrhrh", "sffff", "gfhfh")
    ));

    public List<Diseases> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Diseases> diseases) {
        this.diseases = diseases;
    }

    private List<Manufacter> manufacters = new ArrayList<>(Arrays.asList(
            new Manufacter("1","adadad", "sdsdsd"),
            new Manufacter("2","asdafe", "dfggg"),
            new Manufacter("3","gfhtrhrh", "sffff")
    ));

    public List<Manufacter> getManufacters() {
        return manufacters;
    }

    public void setManufacters(List<Manufacter> manufacters) {
        this.manufacters = manufacters;
    }

    private List<Materials> materials = new ArrayList<>(Arrays.asList(
            new Materials("1", (new Manufacter("1","dada","dasda"
            )), '9', "sdsdsd","kokoo",
                    (new Diseases("1", "dsfs", "sadad", "asdad"))),
            new Materials("2", (new Manufacter("2","tret","juyjj"
            )), '1', "syryr","kry6",
                    (new Diseases("2", "ytrr", "tfft", "hytht")))
    ));

    public List<Materials> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Materials> materials) {
        this.materials = materials;
    }

    private List<Medicine> medicines = new ArrayList<>(Arrays.asList(
            new Medicine("1", (new Manufacter("1","dada","dasda"
            )), '9', "sdsdsd","kokoo",
                    (new Diseases("1", "dsfs", "sadad", "asdad"))),
            new Medicine("2", (new Manufacter("2","tret","juyjj"
            )), '1', "syryr","kry6",
                    (new Diseases("2", "ytrr", "tfft", "hytht")))
    ));

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    private List<Archive> archives = new ArrayList<>(Arrays.asList(
            new Archive("1","sefs","dadad",
                    (new Doctor("1","dada","assda","sfsfs","afafa",'2')),
                    (new Patient("1", '2', "dadadad", "adadad", "+3242242")),
                    (new Diseases("1", "dsfs", "sadad", "asdad"))),
            new Archive("2","sefs","dadad",
                    (new Doctor("2","dada","assda","sfsfs","afafa",'2')),
                    (new Patient("2", '2', "dadadad", "adadad", "+3242242")),
                    (new Diseases("2", "dsfs", "sadad", "asdad")))
    ));

    public List<Archive> getArchives() {
        return archives;
    }

    public void setArchives(List<Archive> archives) {
        this.archives = archives;
    }

    private List<PatientSpendingCard> patientSpendingCards = new ArrayList<>(Arrays.asList(
            new PatientSpendingCard("1",
                    (new Patient("1", '1', "adada", "asdad", "+3802424242")),
                    "1",'2','2', "dasda","adada"),
            new PatientSpendingCard("2",
                    (new Patient("1", '1', "adada", "asdad", "+3802424242")),
                    "2",'2','2', "dasda","adada"),
            new PatientSpendingCard("3",
                    (new Patient("1", '1', "adada", "asdad", "+3802424242")),
                    "3",'2','2', "dasda","adada")

    ));

    public List<PatientSpendingCard> getPatientSpendingCards() {
        return patientSpendingCards;
    }

    public void setPatientSpendingCards(List<PatientSpendingCard> patientSpendingCards) {
        this.patientSpendingCards = patientSpendingCards;
    }

    private List<HistoryOfDiseases> historyOfDiseases = new ArrayList<>(Arrays.asList(
            new HistoryOfDiseases("1", (new Diseases("1", "dsfs", "sadad", "asdad")),
                    (new Patient("1", '1', "adada", "asdad", "+3802424242")),
                    (new Doctor("1","ikik", "assda", "adada", "+3802131313", '2')),
                    "dada", "dadada", "dadada", '2',
                    (new PatientSpendingCard("1",(new Patient("1", '1', "adada", "asdad", "+3802424242")),"1",'2','2', "dasda","adada"))),
            new HistoryOfDiseases("2", (new Diseases("1", "dsfs", "sadad", "asdad")),
                    (new Patient("1", '1', "adada", "asdad", "+3802424242")),
                    (new Doctor("1","ikik", "assda", "adada", "+3802131313", '2')),
                    "dada", "dadada", "dadada", '2',
                    (new PatientSpendingCard("1",(new Patient("1", '1', "adada", "asdad", "+3802424242")),"2",'2','2', "dasda","adada"))),
            new HistoryOfDiseases("3", (new Diseases("1", "dsfs", "sadad", "asdad")),
                    (new Patient("1", '1', "adada", "asdad", "+3802424242")),
                    (new Doctor("1","ikik", "sadada", "adada", "+3802131313", '2')),
                    "dada", "dadada", "dadada", '2',
                    (new PatientSpendingCard("1",(new Patient("1", '1', "adada", "asdad", "+3802424242")), "3",'2','2', "dasda","adada")))

    ));

    public List<HistoryOfDiseases> getHistoryOfDiseases() {
        return historyOfDiseases;
    }

    public void setHistoryOfDiseases(List<HistoryOfDiseases> historyOfDiseases) {
        this.historyOfDiseases = historyOfDiseases;
    }

    private List<ReceiptsOfDoctors> receiptsOfDoctors = new ArrayList<>(Arrays.asList(
            new ReceiptsOfDoctors("1",(new Doctor("1","ikik", "assda",
                    "adada", "+3802131313", '2')),'2','2', "dasda","adada"),
            new ReceiptsOfDoctors("2",(new Doctor("2","ikik", "assda",
                    "adada", "+3802131313", '2')),'2','2', "dasda","adada"),
            new ReceiptsOfDoctors("3",(new Doctor("3","ikik", "assda",
                    "adada", "+3802131313", '2')),'2','2', "dasda","adada")

    ));

    public List<ReceiptsOfDoctors> getReceiptsOfDoctors() {
        return receiptsOfDoctors;
    }

    public void setReceiptsOfDoctors(List<ReceiptsOfDoctors> receiptsOfDoctors) {
        this.receiptsOfDoctors = receiptsOfDoctors;
    }

    private List<ReceiptsOfPoliclinic> receiptsOfPoliclinics = new ArrayList<>(Arrays.asList(
            new ReceiptsOfPoliclinic("1",'2','2', "dasda","adada"),
            new ReceiptsOfPoliclinic("2",'2','2', "dasda","adada"),
            new ReceiptsOfPoliclinic("3",'2','2', "dasda","adada")


    ));

    public List<ReceiptsOfPoliclinic> getReceiptsOfPoliclinics() {
        return receiptsOfPoliclinics;
    }

    public void setReceiptsOfPoliclinics(List<ReceiptsOfPoliclinic> receiptsOfPoliclinics) {
        this.receiptsOfPoliclinics = receiptsOfPoliclinics;
    }

    private List<Visit> visits = new ArrayList<>(Arrays.asList(
            new Visit("1",(new Patient("1", '1', "adada", "asdad", "+3802424242")),
                    (new Doctor("1","ikik", "assda",
                            "adada", "+3802131313", '2')),"wadada", "dadadaa","dadadada",
                    "dadad", '2', '3', '2'),
            new Visit("1",(new Patient("2", '1', "adada", "asdad", "+3802424242")),
                    (new Doctor("2","ikik", "assda",
                            "adada", "+3802131313", '2')),"wadada", "dadadaa","dadadada",
                    "dadad", '2', '3', '2'),
            new Visit("1",(new Patient("3", '1', "adada", "asdad", "+3802424242")),
                    (new Doctor("3","ikik", "assda",
                            "adada", "+3802131313", '2')),"wadada", "dadadaa","dadadada",
                    "dadad", '2', '3', '2')

    ));

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }


    private List<VisitsOfClinic> visitsOfClinics = new ArrayList<>(Arrays.asList(
            new VisitsOfClinic("1",'3', '4', "dsss", "ssdssd"),
            new VisitsOfClinic("2",'3', '4', "dsss", "ssdssd"),
            new VisitsOfClinic("3",'3', '4', "dsss", "ssdssd")


    ));

    public List<VisitsOfClinic> getVisitsOfClinics() {
        return visitsOfClinics;
    }

    public void setVisitsOfClinics(List<VisitsOfClinic> visitsOfClinics) {
        this.visitsOfClinics = visitsOfClinics;
    }



}
