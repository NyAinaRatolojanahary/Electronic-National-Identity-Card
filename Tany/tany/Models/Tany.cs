using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Data.SqlClient;

namespace tany.Models
{
    public class Tany
    {
        // private double io;

        // public double Io{
        //     get{
        //         return this.io;
        //     }
        //     set{
        //         if( value < 0 ) throw new Exception();
        //         this.io = value;
        //     }
        // }

        // this.Io = 3.5;

        public String? id{get;set;}
        public String NomTany{get;set;}
        public double superficie{get;set;}
        public String secteur{get;set;}
        public String district{get;set;}
        public String statusTany{get;set;}
        public String tompony{get;set;}



        public Tany(){}

        public Tany(String nom,double size,String secteur,String district,String status,String tompony){
            this.NomTany = nom;
            this.superficie = size;
            this.secteur = secteur;
            this.district = district;
            this.statusTany = status;
            this.tompony = tompony;

        }

        public Tany(String nom,String tompony){
            this.NomTany = nom;
            this.tompony = tompony;
        }

        public Tany(String id,String nom,double size,String secteur,String district,String status,String tompony){
            this.id = id;
            this.NomTany = nom;
            this.superficie = size;
            this.secteur = secteur;
            this.district = district;
            this.statusTany = status;
            this.tompony = tompony;
        }

        // public List<Tany> listeTanyParCin(String cin)
        // {
        //     List<Tany> TanyLists = new List<Tany>();

        //     using (SqlConnection connection = new SqlConnection("Data Source=ETU2058-NYAINA\\SQLEXPRESS;Initial Catalog=land;Integrated Security=True"))
        //     {
        //         connection.Open();
        //         SqlCommand command = new SqlCommand("SELECT * FROM property join landed_status on property.idlanded_status=landed_status.id WHERE property.idowner=@cin", connection);

        //         using (SqlDataReader reader = command.ExecuteReader())
        //         {
        //             while (reader.Read())
        //             {
        //                 Tany t = new Tany();
        //                     t.setId(Convert.ToString(reader["id"]));
        //                     t.setNomTany(Convert.ToString(reader["property_name"]));
        //                     t.setSuperficie(Convert.ToDouble(reader["property_size"]));
        //                     t.setSecteur(Convert.ToString(reader["sector"]));
        //                     t.setDistrict(Convert.ToString(reader["district"]));
        //                     t.setStatusTany(Convert.ToString(reader["idlanded_status"]));
        //                     t.setTompony(Convert.ToString(reader["idowner"]));
        //                     TanyLists.Add(t);
        //             }
        //         }
        //     }

        //     return TanyLists;
        // }


    public List<Tany> listeTanyParCin(String cin)
    {
        List<Tany> TanyLists = new List<Tany>();

        using (SqlConnection connection = new SqlConnection("Data Source=ETU2058-NYAINA\\SQLEXPRESS;Initial Catalog=land;Integrated Security=True"))
        {
            connection.Open();
            string query = "SELECT * FROM property join landed_status on property.idlanded_status=landed_status.id WHERE property.idowner=@cin";

            using (SqlCommand command = new SqlCommand(query, connection))
            {
                command.Parameters.AddWithValue("@cin", cin);

                using (SqlDataReader reader = command.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        Tany t = new Tany();
                            t.id = Convert.ToString(reader["id"]);
                            t.NomTany = Convert.ToString(reader["property_name"]);
                            t.superficie = Convert.ToDouble(reader["property_size"]);
                            t.secteur = Convert.ToString(reader["sector"]);
                            t.district = Convert.ToString(reader["district"]);
                            t.statusTany = Convert.ToString(reader["idlanded_status"]);
                            t.tompony = Convert.ToString(reader["idowner"]);
                        TanyLists.Add(t);
                    }
                }
            }
        }

        return TanyLists;
    }

    public Tany TanyFarany(String cin)
    {
        List<Tany> TanyLists = new List<Tany>();

        using (SqlConnection connection = new SqlConnection("Data Source=ETU2058-NYAINA\\SQLEXPRESS;Initial Catalog=land;Integrated Security=True"))
        {
            connection.Open();
            string query = "SELECT * FROM property WHERE property.idowner=@cin and id NOT IN( select id from property_landmark) order by id desc limit 1";

            using (SqlCommand command = new SqlCommand(query, connection))
            {
                command.Parameters.AddWithValue("@cin", cin);

                using (SqlDataReader reader = command.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        Tany t = new Tany();
                            t.id = Convert.ToString(reader["id"]);
                            t.NomTany = Convert.ToString(reader["property_name"]);
                            t.superficie = Convert.ToDouble(reader["property_size"]);
                            t.secteur = Convert.ToString(reader["sector"]);
                            t.district = Convert.ToString(reader["district"]);
                            t.statusTany = Convert.ToString(reader["idlanded_status"]);
                            t.tompony = Convert.ToString(reader["idowner"]);
                        TanyLists.Add(t);
                    }
                }
            }
        }

        return TanyLists;
    }


    public void AddTany(string nom, string proprietaire){
    try
    {
        Console.WriteLine("Tafiditra11");

        string connectionString = "Data Source=ETU2058-NYAINA\\SQLEXPRESS;Initial Catalog=land;Integrated Security=True";
        Console.WriteLine("Tafiditra22");

        using (SqlConnection connection = new SqlConnection(connectionString))
        {
            connection.Open();
        Console.WriteLine("Tafiditra");
            string query = "INSERT INTO property (property_name, idowner) VALUES (@nom, @proprietaire)";
        Console.WriteLine("Query ok");
            using (SqlCommand command = new SqlCommand(query, connection))
            {
                command.Parameters.AddWithValue("@nom", nom);
                command.Parameters.AddWithValue("@proprietaire", proprietaire);
                command.ExecuteNonQuery();
            }
        }
    }
    catch (Exception ex)
    {
        // Gérer les exceptions ici
        Console.WriteLine("Erreur lors de l'ajout dans la base de données : " + ex.Message);
    }
}


        // public static void Main(string[] args)
        // {
        //     List<Tany> lst = new List<Tany>();
        //     Tany t = new Tany();
        //     String nci = "Cin1";
        //     lst = t.listeTanyParCin(nci);
        //     Console.WriteLine(lst[0].getNomTany());
        // }


        
    }
}