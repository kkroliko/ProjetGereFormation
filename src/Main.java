import com.maryvone.gereformation.dao.*;
import com.maryvone.gereformation.model.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

// Create a new Stagiaire
//        Stagiaire stagiaire = new Stagiaire(29200, "Le Luron","David", "144 rue Robespierre", "Brest", "wowzillah77@gmail.com", "0298680996");
//        StagiaireDAO.create(stagiaire);

////Create a new Formation
//        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//        Date date = df.parse("15/12/2017");
//        java.sql.Date dtSQL = new java.sql.Date(date.getTime());
//
//        Formation formation = new Formation("Developpeur pause cigarette", "apprendre a faire des pauses cigarettes très souvent", "Derrière le Self", 500,  1235, dtSQL);
//        FormationDAO.create(formation);

        //create a new ECF
//
//        ECF ecf = new ECF("roulage de clope");
//        ECFDAO.create(ecf);

// create a module

//        Module module = new Module(3,"le lancer de cendre","c'est un art");
//        ModuleDAO.create(module);


        // create a sequence

        Sequence sequence = new Sequence(1,"Konrad","est endormi");
        SequenceDAO.update(sequence);





    }
    public static void create() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Personnel");
        System.out.println("Quel est le nom");
        String nom = scanner.nextLine();
        System.out.println("Quel est le prénom?");
        String prenom = scanner.nextLine();
        System.out.println("Quel est le nom d'utilisateur?");
        String utilisateur= scanner.nextLine();
        System.out.println("Quel est le mot de passe");
        String mdp = scanner.nextLine();
        System.out.println("Quel sera le role?");
        String role = scanner.nextLine();
        System.out.println("Quel sera l'email?");
        String email = scanner.nextLine();
        Personnel personnel = new Personnel(nom,prenom,utilisateur,mdp,email,role);
        try {
            PersonnelDAO.create(personnel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public static void afficheResult (){
         ArrayList<Personnel> resultat = PersonnelDAO.findAll();
         for (Personnel personnel : resultat) {
             personnel.affDesc();
         }

     }

}
