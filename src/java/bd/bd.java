/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import metier.ProfilSportif;
import metier.Utilisateur;

/**
 *
 * @author 21101690
 */
public class bd {

        private Connection cx;
        /*donnée de connection*/
    private String url="jdbc:mysql://etu-web:3306/db_21205976";
    private String login="21205976";
    private String password="M00V55";
    
    //Constructeur
    public bd(){
   
    //Chargement du driver par la JVM
    try {
        Class.forName("com.mysql.jdbc.Driver");
     } catch (ClassNotFoundException ex) {
         System.out.println("Erreur chargement driver"+ex.getMessage());
        
     }

    //Ouverture de la connexion avec la BD
    try {
        this.cx=DriverManager.getConnection(url, login, password);
        } 
    catch (SQLException ex) {
        System.out.println("Erreur ouverture connexion"+ex.getMessage());
        }
 
    }

    public int verifLogin(String email, String mdp) throws SQLException {
        Statement st;
        int rs1 = 0;

        String sql = "select TYPEU from UTILISATEUR where MAILU='" + email + "' and MDPU = '" + mdp + "'";
        st = cx.createStatement();
        ResultSet rs = st.executeQuery(sql); //resultat

        //verifier
        if (rs.next()) {
            System.out.println("connect ok");
            //ok
            String type = rs.getString("TYPEU");
            if (type.equals("COACH")) {
                rs1 = 1;
                System.out.println("COACH");
            } else if (type.equals("CLIENT")) {
                rs1 = 2;
                System.out.println("CLIENT");
            } else if (type.equals("ADMIN")) {
                rs1 = 3;
                System.out.println("admin");
            }
        } else //ko
        {
            rs1 = 4;
        }
        return rs1;

    }

    public int idUser(String email, String mdp) throws SQLException {
        Statement st;
        int id = 0;
        String sql = "select CODEU from UTILISATEUR where MAILU='" + email + "' and MDPU = '" + mdp + "'";
        st = cx.createStatement();
        ResultSet rs = st.executeQuery(sql); //resultat

        //verifier
        if (rs.next()) {
            System.out.println("connect ok");
            //ok
            id = rs.getInt("CODEU");
            // System.out.println(id);
        }
        return id;

    }

    //affihcer les info pour savoir c'est qui en train de connecter ArrayList<Utilisateur>
    public ArrayList<Utilisateur> userConnect(int id) throws SQLException, ParseException {
        Statement st;
        String sql = "SELECT NOMU,PRENOMU,MAILU,GENREU,DATENAISSANCE,TELU,TYPEU FROM UTILISATEUR WHERE CODEU=" + id;
        st = cx.createStatement();
        ArrayList<Utilisateur> lstI = new ArrayList();
        ResultSet rs = st.executeQuery(sql); //resultat    

        //verifier
        while (rs.next()) {
            SimpleDateFormat forma = new SimpleDateFormat("yyyy-mm-dd");
            lstI.add(new Utilisateur(rs.getString("NOMU"), rs.getString("PRENOMU"), rs.getString("MAILU"), rs.getString("GENREU"), forma.parse(rs.getString("DATENAISSANCE")), rs.getString("TELU"), rs.getString("TYPEU")));
        }

        return lstI;
    }
    
      //PROPORTION STATUS DE CLIENT
    public ArrayList<String> indicClientStatu() throws SQLException {
        int nbv = 0, nbatt = 0,nbtotal=0;
        Statement st, st2, st3;
        //nb de client valide
        String sql = "SELECT COUNT(*)AS NBVALIDE FROM UTILISATEUR WHERE STATUTU='VALIDE'";
        st = cx.createStatement();
        ResultSet rs = st.executeQuery(sql); //resultat    
        //result
        while (rs.next()) {
            nbv = Integer.parseInt(rs.getString("NBVALIDE"));
        }
        //nb client en attente
        String sql2 = "SELECT COUNT(*)AS NBATTENTE FROM UTILISATEUR WHERE STATUTU='EN ATTENTE'";
        st2 = cx.createStatement();
        ResultSet rs2 = st2.executeQuery(sql2); //resultat    
        //result
        while (rs2.next()) {
            nbatt = Integer.parseInt(rs2.getString("NBATTENTE"));
        }
        
       //nb client total
        String sql3 = "SELECT COUNT(*)AS NBTOTAL FROM UTILISATEUR WHERE TYPEU='CLIENT'";
        st3 = cx.createStatement();
        ResultSet rs3 = st3.executeQuery(sql3); //resultat    
        //verifier
        while (rs3.next()) {
            nbtotal = Integer.parseInt(rs3.getString("NBTOTAL"));
        }
        ArrayList<String> indic=new ArrayList<String>();
        indic.add(String.valueOf((nbv*100)/nbtotal));//% de client valider  0
        indic.add(String.valueOf((nbatt*100)/nbtotal));//% de client en attente  1
        indic.add(String.valueOf(nbtotal));  //2 client total
        indic.add(String.valueOf(nbv));  //3 client valider
        indic.add(String.valueOf(nbatt));  //4 client en attente
      
   return indic;

    }
    
    
    //Methode de récuperration des utilisateurs
    public ArrayList<Utilisateur> obtenirutilisateurs() {
        ArrayList<Utilisateur> listeUtilisateur = new ArrayList();
        //Espace d'exécution de la requête
        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace d'exécution " + ex.getMessage());
        }

        //Requête SQL
        String recupererUtilisateur = "SELECT NOMU, PRENOMU FROM UTILISATEUR";

        //Ouverture de l'espace de requête
        ResultSet rs = null;
        try {
            rs = st.executeQuery(recupererUtilisateur);
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'interrogation de la base de données " + ex.getMessage());
        }

        //Ecriture des résultats de la requête dans la liste des messages
        try {
            while (rs.next()) {
                listeUtilisateur.add(new Utilisateur(rs.getString("NOMU"),
                        rs.getString("PRENOMU"), rs.getString("STATUTU"),
                        rs.getDate("DATEINSCRI")));
            }
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'écriture dans la liste des messages " + ex.getMessage());
        }

        //Fermeture de l'espace de requête
        try {
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace de requête " + ex.getMessage());
        }

        //Fermeture de l'espace d'exécution de la requête
        try {
            st.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace d'exécution de la requête " + ex.getMessage());
        }

        //Fermeture de la connexion à la base de données
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de la connexion à la base de données " + ex.getMessage());
        }
        return listeUtilisateur;
    }

    public int inscrirebaseutilisateur(Utilisateur lutilisateur) {
        //Espace d'exécution de la requête
        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace d'exécution " + ex.getMessage());
        }

        //Requête SQL
        String inscrirebase = "INSERT INTO UTILISATEUR "
                + "(CODEU, NOMU, PRENOMU, MAILU, MDPU, GENREU, TELU) "
                + "VALUES ('" + lutilisateur.getCodeu() + "','" + lutilisateur.getNomu() + "','"
                + lutilisateur.getPrenomu() + "','" + lutilisateur.getMailu() + "','" + lutilisateur.getMdpu() + "','"
                + lutilisateur.getGenreu() + "','" + lutilisateur.getTelu()
                + "');";

        int nb_ligne_modifie = 0;
        try {
            //Ouverture de l'espace de requête
            nb_ligne_modifie = st.executeUpdate(inscrirebase);
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'insertion de l'utilisateur " + ex.getMessage());
        }

        //Fermeture de l'espace d'exécution de la requête
        try {
            st.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace d'exécution de la requête " + ex.getMessage());
        }

        /*Commit de la modification de la base de donnére
        try {
            System.out.println("test du commit");
            cx.commit();
        } catch (SQLException ex) {
            System.out.println("Echec lors du commit d ela base de données "+ex.getMessage());
        }*/
        //Fermeture de la connexion à la base de données
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de la connexion à la base de données " + ex.getMessage());
        }
        return nb_ligne_modifie;
    }

    public int supprimerutilisateur(Utilisateur lutilisateur) {
        //Espace d'exécution de la requête
        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace "
                    + "d'exécution " + ex.getMessage());
        }

        //Requête SQL
        String inscrirebase = "DELETE FROM UTILISATEUR WHERE MAILU = '"
                + lutilisateur.getMailu() + "';";

        int nb_ligne_modifie = 0;
        try {
            //Ouverture de l'espace de requête
            nb_ligne_modifie = st.executeUpdate(inscrirebase);
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'insertion de l'utilisateur "
                    + ex.getMessage());
        }

        //Fermeture de l'espace d'exécution de la requête
        try {
            st.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace "
                    + "d'exécution de la requête " + ex.getMessage());
        }

        /*Commit de la modification de la base de donnére
        try {
            System.out.println("test du commit");
            cx.commit();
        } catch (SQLException ex) {
            System.out.println("Echec lors du commit d ela base de données "+ex.getMessage());
        }*/
        //Fermeture de la connexion à la base de données
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de la connexion à la "
                    + "base de données " + ex.getMessage());
        }
        return nb_ligne_modifie;
    }
    
    //remplir le profil sportif d'utilisateur
    public void remplirProfilSportif(Utilisateur u1, ProfilSportif ps1) throws SQLException{
        //espace de requêtes
        Statement st;
        
        //requete sql
        String sql = "Insert into PROFILSPORTIF (CODEU,CODE,DATEPS)"+"VALUES ('"+u1.getCodeu()+"',"+ps1.getCodePs()+"',"
                        +"";
        
        //ouverture de l'espace de requetes
        st = cx.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        
        
        
    }
    
    

    //Programme de test de la connexion à la bd
    public static void main(String[] args) throws SQLException {
        bd unebd = new bd();
//        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
//        Utilisateur u1 = new Utilisateur("Setilahy", "Sergio", 
//            "sergio@example.com", "12test", "M", 
//            formatDate.parse("27/09/1990"), "01-23-45-67-89", 
//            "Client", new Date(), "Potentiel");
//
//        int nb_ligne_mod = unebd.inscrirebaseutilisateur(u1);

//        System.out.println("nombre de ligne modifiée " + nb_ligne_mod);
//        ArrayList<Utilisateur> listeUtilisateur = unebd.obtenirutilisateurs();
//        for (Utilisateur user : listeUtilisateur) {
//            System.out.println(user.getNomu() + " " + user.getPrenomu());
//        }
        unebd.verifLogin("EVABAIBAI@GMAIL.COM", "123123asd");
    }
}
