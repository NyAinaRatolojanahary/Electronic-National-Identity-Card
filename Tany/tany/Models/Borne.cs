using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Data.SqlClient;


namespace tany.Models
{
    public class Borne
    {
        public int id{get;set;}
        public int idproperty{get;set;}
        public double longitude{get;set;}
        public double latitude{get;set;}

        public Borne(){}

        public Borne(int id,int idp){
            this.id = id;
            this.idproperty = idp;
        }

        public Borne(int id,double longitude,double latitude){
            this.idproperty = id;
            this.longitude = longitude;
            this.latitude = latitude;
        }

        public Borne(int id,int idp,double longitude,double latitude){
            this.id = id;
            this.idproperty = idp;
            this.longitude = longitude;
            this.latitude = latitude;
        }

        public List<Borne> getBorneParIdTany(int idtany){
            List<Borne> borne = new List<Borne>();

            using (SqlConnection connection = new SqlConnection("Data Source=ETU2058-NYAINA\\SQLEXPRESS;Initial Catalog=land;Integrated Security=True")){
                connection.Open();

                string query = "select id, idproperty, landmark.STY AS Latitude, landmark.STX AS Longitude FROM property_landmark where idproperty=@idtany";
                using (SqlCommand command = new SqlCommand(query, connection)){
                    command.Parameters.AddWithValue("@idtany", idtany);

                    using (SqlDataReader reader = command.ExecuteReader()){
                    while (reader.Read()){
                        Borne b = new Borne();
                            b.id = Convert.ToInt32(reader["id"]);
                            b.idproperty = Convert.ToInt32(reader["idproperty"]);
                            b.latitude = Convert.ToDouble(reader["Latitude"]);
                            b.longitude = Convert.ToDouble(reader["Longitude"]);
                        borne.Add(b);
                    }

                }
            }

            return borne;
        }
        }

        public void AddBornes(string idtany,string longit, string lat){
        try
        {
            Console.WriteLine("Tafiditra11");

            string connectionString = "Data Source=ETU2058-NYAINA\\SQLEXPRESS;Initial Catalog=land;Integrated Security=True";
            
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
            Console.WriteLine("Tafiditra");
                string query = "INSERT INTO property_landmark (idproperty, landmark) VALUES (@idtany, Geometry::Point( @longit,@lat, 4326))";
            Console.WriteLine("Query ok");
                using (SqlCommand command = new SqlCommand(query, connection))
                {
                    command.Parameters.AddWithValue("@idtany", idtany);
                    command.Parameters.AddWithValue("@longit", longit);
                    command.Parameters.AddWithValue("@lat", lat);
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


    }
}

